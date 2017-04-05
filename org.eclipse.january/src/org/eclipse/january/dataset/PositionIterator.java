/*-
 *******************************************************************************
 * Copyright (c) 2011, 2016 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Peter Chang - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.january.dataset;

/**
 * <p>Class to provide iteration through a dataset</p>
 * <p>Instantiate an iterator and use it in a while loop:
 * <pre>
 * Dataset ds = DatasetFactory.createLinearSpace(DoubleDataset.class, 0, 10, 0.25);
 * PositionIterator iter = ds.getPositionIterator();
 * int[] pos = iter.getPos()
 *
 * while (iter.hasNext()) {
 *     ds.set(1.2, pos);
 * }
 * </pre>
 *
 */
public class PositionIterator extends IndexIterator {
	private int offset;
	final private int[] shape;
	final private int[] start;
	final private int[] stop;
	final private int[] step;
	final private int endrank;

	final private boolean[] omit; // axes to miss out

	/**
	 * position in dataset
	 */
	final private int[] pos;
	private boolean once;

	/**
	 * Constructor for an iterator over elements of a dataset that are within
	 * the shape
	 *
	 * @param shape
	 */
	public PositionIterator(int[] shape) {
		this(new SliceND(shape), null);
	}

	/**
	 * Constructor for an iterator over a single item broadcasted to given shape
	 *
	 * @param offset offset to single item
	 * @param shape
	 */
	public PositionIterator(int offset, int[] shape) {
		this(offset, new SliceND(shape), null);
	}

	/**
	 * Constructor for an iterator that misses out several axes
	 * @param shape
	 * @param axes missing axes, can be null for full dataset
	 */
	public PositionIterator(int[] shape, int... axes) {
		this(new SliceND(shape), axes);
	}

	/**
	 * Constructor for an iterator that misses out several axes
	 * @param shape
	 * @param slice
	 * @param axes missing axes
	 */
	public PositionIterator(int[] shape, Slice[] slice, int[] axes) {
		this(new SliceND(shape, slice), axes);
	}

	/**
	 * Constructor for an iterator that misses out several axes
	 * @param shape
	 * @param start
	 * @param stop
	 * @param step
	 * @param axes missing axes
	 */
	public PositionIterator(int[] shape, int[] start, int[] stop, int[] step, int[] axes) {
		this(new SliceND(shape, start, stop, step), axes);
	}

	/**
	 * Constructor for an iterator that misses out several axes
	 * @param slice
	 * @param axes missing axes
	 */
	public PositionIterator(SliceND slice, int... axes) {
		this(0, slice, axes);
	}

	/**
	 * Constructor for an iterator that misses out several axes
	 * 
	 * @param offset offset to start with
	 * @param slice
	 * @param axes missing axes
	 */
	public PositionIterator(int offset, SliceND slice, int... axes) {
		this.offset = offset;
		int[] oshape = slice.getShape();
		start = slice.getStart();
		stop  = slice.getStop();
		step  = slice.getStep();
		for (int s : step) {
			if (s < 0) {
				throw new UnsupportedOperationException("Negative steps not implemented");
			}
		}
		int rank = oshape.length;
		endrank = rank - 1;

		omit = new boolean[rank];
		shape = oshape.clone();
		if (axes != null) {
			for (int a : axes) {
				if (a < 0) {
					a += rank;
				}
				if (a >= 0 && a <= endrank) {
					omit[a] = true;
					shape[a] = 1;
				} else if (a > endrank) {
					throw new IllegalArgumentException("Specified axis exceeds dataset rank");
				}
			}
		}

		pos = new int[rank];

		reset();
	}

	@Override
	public boolean hasNext() {
		// now move on one position
		if (once) {
			once = false;
			return true;
		}
		for (int j = endrank; j >= 0; j--) {
			if (omit[j]) {
				continue;
			}
			pos[j] += step[j];
			if (pos[j] >= stop[j]) {
				pos[j] = start[j];
			} else {
				return true;
			}
		}
		return false;
	}

	@Override
	public int[] getPos() {
		return pos;
	}

	/**
	 * @return omit array - array where true means miss out
	 */
	public boolean[] getOmit() {
		return omit;
	}

	@Override
	public void reset() {
		for (int i = 0; i <= endrank; i++)
			pos[i] = start[i];

		int j = 0;
		for (; j <= endrank; j++) {
			if (!omit[j])
				break;
		}
		if (j > endrank) {
			once = true;
			return;
		}

		if (omit[endrank]) {
			pos[endrank] = start[endrank];
			
			for (int i = endrank - 1; i >= 0; i--) {
				if (!omit[i]) {
					pos[i] -= step[i];
					break;
				}
			}
		} else {
			pos[endrank] -= step[endrank];
		}

		index = offset;
	}

	@Override
	public int[] getShape() {
		return shape;
	}

	public int[] getStop() {
		return stop;
	}
}
