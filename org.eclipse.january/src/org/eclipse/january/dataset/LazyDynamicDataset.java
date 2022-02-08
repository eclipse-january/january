/*-
 * Copyright 2015, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import java.util.Arrays;

import org.eclipse.january.io.ILazyDynamicLoader;
import org.eclipse.january.io.ILazyLoader;

public class LazyDynamicDataset extends LazyDataset implements IDynamicDataset {
	private static final long serialVersionUID = -6296506563932840938L;

	protected int[] maxShape;
	protected int[] chunks;

	protected transient DataListenerDelegate eventDelegate; // this does not need to be serialised!

	protected IDatasetChangeChecker checker;

	class PeriodicRunnable implements Runnable {
		long millis;

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(millis);
				} catch (InterruptedException e) {
					break;
				}
				if (checker == null || checker.check()) {
					fireDataListeners();
				}
			}
		}
	}

	private transient PeriodicRunnable runner = new PeriodicRunnable();

	private Thread checkingThread;

	/**
	 * Create a dynamic lazy dataset
	 * @param name of dataset
	 * @param dtype dataset type
	 * @param elements item size
	 * @param shape dataset shape
	 * @param maxShape maximum shape
	 * @param loader lazy loader
	 * @deprecated Use {@link #LazyDynamicDataset(ILazyLoader, String, int, Class, int[], int[])}
	 */
	@Deprecated
	public LazyDynamicDataset(String name, int dtype, int elements, int[] shape, int[] maxShape, ILazyLoader loader) {
		this(name, elements, DTypeUtils.getInterface(dtype), shape, maxShape, loader);
	}

	/**
	 * Create a dynamic lazy dataset
	 * @param name of dataset
	 * @param elements item size
	 * @param clazz dataset sub-interface
	 * @param shape dataset shape
	 * @param maxShape maximum shape
	 * @param loader lazy loader
	 * @since 2.3
	 * @deprecated Use {@link #LazyDynamicDataset(ILazyLoader, String, int, Class, int[], int[])}
	 */
	@Deprecated
	public LazyDynamicDataset(String name, int elements, Class<? extends Dataset> clazz, int[] shape, int[] maxShape, ILazyLoader loader) {
		this(loader, name, elements, clazz, shape, maxShape);
	}

	/**
	 * Create a dynamic lazy dataset
	 * @param loader lazy loader
	 * @param name of dataset
	 * @param elements item size
	 * @param clazz dataset sub-interface
	 * @param shape dataset shape
	 * @param maxShape maximum shape
	 * @since 2.3
	 */
	public LazyDynamicDataset(ILazyLoader loader, String name, int elements, Class<? extends Dataset> clazz, int[] shape, int[] maxShape) {
		this(loader, name, elements, clazz, shape, maxShape, null);
	}

	/**
	 * Create a dynamic lazy dataset
	 * @param loader lazy loader
	 * @param name of dataset
	 * @param elements item size
	 * @param clazz dataset sub-interface
	 * @param shape dataset shape
	 * @param maxShape maximum shape
	 * @param chunks chunk shape
	 * @since 2.3
	 */
	public LazyDynamicDataset(ILazyLoader loader, String name, int elements, Class<? extends Dataset> clazz, int[] shape, int[] maxShape, int[] chunks) {
		super(loader, name, elements, clazz, shape);
		if (maxShape == null) {
			this.maxShape = shape.clone();
			// check there are no unlimited dimensions in shape
			int rank = shape.length;
			boolean isUnlimited = false;
			for (int i = 0; i < rank; i++) {
				if (shape[i] == ILazyWriteableDataset.UNLIMITED) {
					isUnlimited = true;
					break;
				}
			}
			if (isUnlimited) { // set all zeros
				for (int i = 0; i < rank; i++) {
					this.shape[i] = 0;
					this.oShape[i] = 0;
				}
			}
		} else {
			this.maxShape = maxShape.clone();
		}
		this.chunks = chunks == null ? null : chunks.clone();

		this.eventDelegate = new DataListenerDelegate();
	}

	/**
	 * @param other dataset to clone
	 * @since 2.2
	 */
	protected LazyDynamicDataset(LazyDynamicDataset other) {
		super(other);

		maxShape = other.maxShape;
		chunks = other.chunks;
		eventDelegate = other.eventDelegate;
		checker = other.checker;
		runner = other.runner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((checker == null) ? 0 : checker.hashCode());
		result = prime * result + ((checkingThread == null) ? 0 : checkingThread.hashCode());
		result = prime * result + Arrays.hashCode(maxShape);
		result = prime * result + Arrays.hashCode(chunks);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}

		LazyDynamicDataset other = (LazyDynamicDataset) obj;
		if (!Arrays.equals(maxShape, other.maxShape)) {
			return false;
		}
		if (!Arrays.equals(chunks, other.chunks)) {
			return false;
		}

		if (checker == null) {
			if (other.checker != null) {
				return false;
			}
		} else if (!checker.equals(other.checker)) {
			return false;
		}
		if (checkingThread == null) {
			if (other.checkingThread != null) {
				return false;
			}
		} else if (!checkingThread.equals(other.checkingThread)) {
			return false;
		}
		return true;
	}

	@Override
	public ILazyDataset getDataset() {
		return this;
	}

	@Override
	public void addDataListener(IDataListener l) {
		eventDelegate.addDataListener(l);
	}

	@Override
	public void removeDataListener(IDataListener l) {
		eventDelegate.removeDataListener(l);
	}

	@Override
	public void fireDataListeners() {
		synchronized (eventDelegate) {
			eventDelegate.fire(new DataEvent(name, shape));
		}
	}

	@Override
	public boolean refreshShape() {
		if (loader instanceof ILazyDynamicLoader) {
			return resize(((ILazyDynamicLoader)loader).refreshShape());
		}
		return false;
	}

	@Override
	public boolean resize(int... newShape) {
		int rank = shape.length;
		if (newShape.length != rank) {
			throw new IllegalArgumentException("Rank of new shape must match current shape");
		}

		if (Arrays.equals(shape, newShape)) {
			return false;
		}

		if (maxShape != null) {
			for (int i = 0; i < rank; i++) {
				int m = maxShape[i];
				if (m != -1 && newShape[i] > m) {
					throw new IllegalArgumentException("A dimension of new shape must not exceed maximum shape");
				}
			}
		}
		this.shape = newShape.clone();
		this.oShape = this.shape;
		try {
			size = ShapeUtils.calcLongSize(shape);
		} catch (IllegalArgumentException e) {
			size = Long.MAX_VALUE; // this indicates that the entire dataset cannot be read in! 
		}

		eventDelegate.fire(new DataEvent(name, shape));
		return true;
	}

	@Override
	public int[] getMaxShape() {
		return maxShape;
	}

	@Override
	public void setMaxShape(int... maxShape) {
		this.maxShape = maxShape == null ? shape.clone() : maxShape.clone();

		if (this.maxShape.length > oShape.length) {
			oShape = prependShapeWithOnes(this.maxShape.length, oShape);
		}
		if (this.maxShape.length > shape.length) {
			shape = prependShapeWithOnes(this.maxShape.length, shape); // TODO this does not update any metadata
//			setShapeInternal(prependShapeWithOnes(this.maxShape.length, shape));
		}
	}

	@Override
	public int[] getChunking() {
		return chunks;
	}

	@Override
	public void setChunking(int... chunks) {
		this.chunks = chunks == null ? null : chunks.clone();
	}

	private final static int[] prependShapeWithOnes(int rank, int[] shape) {
		int[] nShape = new int[rank];
		int excess = rank - shape.length;
		for (int i = 0; i < excess; i++) {
			nShape[i] = 1;
		}
		for (int i = excess; i < nShape.length; i++) {
			nShape[i] = shape[i - excess];
		}
		return nShape;
	}

	@Override
	protected void checkSliceND(SliceND slice) {
		slice.checkShapes(shape, maxShape);
	}

	@Override
	protected SliceND createSlice(int[] nstart, int[] nstop, int[] nstep) {
		return SliceND.createSlice(oShape, maxShape, nstart, nstop, nstep);
	}

	@Override
	public LazyDynamicDataset clone() {
		return new LazyDynamicDataset(this);
	}

	@Override
	public synchronized void startUpdateChecker(int milliseconds, IDatasetChangeChecker checker) {
		// stop any current checking threads
		if (checkingThread != null) {
			checkingThread.interrupt();
		}
		this.checker = checker;
		if (checker != null) {
			checker.setDataset(this);
		}
		if (milliseconds <= 0) {  
			return;
		}

		runner.millis = milliseconds;
		checkingThread = new Thread(runner);
		checkingThread.setDaemon(true);
		checkingThread.setName("Checking thread with period " + milliseconds + "ms");
		checkingThread.start();
	}
}
