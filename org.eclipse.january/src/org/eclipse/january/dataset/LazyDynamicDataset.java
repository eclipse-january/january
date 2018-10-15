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

	protected transient DataListenerDelegate eventDelegate; // this does not need to be serialised!

	protected IDatasetChangeChecker checker;
	private boolean stop;

	class PeriodicRunnable implements Runnable {
		long millis;

		@Override
		public void run() {
			while (!stop) {
				try {
					Thread.sleep(millis);
				} catch (InterruptedException e) {
					logger.error("Something has interrupted this periodic runner!");
					stop = true; // ends runner
				}
				if (checker == null || checker.check()) {
					fireDataListeners();
				}
			}
		}
	}

	private transient PeriodicRunnable runner = new PeriodicRunnable();

	private Thread checkingThread;

	public LazyDynamicDataset(String name, int dtype, int elements, int[] shape, int[] maxShape, ILazyLoader loader) {
		super(name, dtype, elements, shape, loader);
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
		this.eventDelegate = new DataListenerDelegate();
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
		if (base != null) {
			throw new UnsupportedOperationException("Changing the shape of a view is not allowed");
		}
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
	public LazyDynamicDataset clone() {
		LazyDynamicDataset ret = new LazyDynamicDataset(new String(name), getDType(), getElementsPerItem(), 
				oShape, maxShape, loader);
		ret.shape = shape;
		ret.size = size;
		ret.prepShape = prepShape;
		ret.postShape = postShape;
		ret.begSlice = begSlice;
		ret.delSlice = delSlice;
		ret.map = map;
		ret.base = base;
		ret.metadata = copyMetadata();
		ret.oMetadata = oMetadata;
		ret.eventDelegate = eventDelegate;
		return ret;
	}

	@Override
	public synchronized void startUpdateChecker(int milliseconds, IDatasetChangeChecker checker) {
		// stop any current checking threads
		if (checkingThread != null) {
			stop = true;
			if (checkingThread != null) {
				checkingThread.interrupt();
			}
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
