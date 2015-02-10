/*-
 *******************************************************************************
 * Copyright (c) 2011, 2014 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Peter Chang - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.dawnsci.analysis.dataset.impl;


import java.util.Arrays;

import org.eclipse.dawnsci.analysis.api.dataset.SliceND;

/**
 * Class to run over a slice of a dataset
 */
public class SliceIterator extends IndexIterator {
	int[] shape;
	int isize;
	int endrank; // last shape index
	int[] gap; // gaps in dataset
	int imax; // maximum index in array
	int[] start;
	int[] stop;
	int[] step;
	int[] sshape; // slice shape
	int[] pos; // position in dataset
	int istep; // step in last index

	SliceIterator() {
	}

	/**
	 * Constructor for an iterator over the elements of a sliced dataset
	 * 
	 * @param shape or dataShape
	 * @param length of entire data array
	 * @param sshape shape of new dataset, i.e. slice
	 */
	public SliceIterator(final int[] shape, final int length, final int[] sshape) {
		this(shape, length, null, null, sshape, 1);
	}

	/**
	 * Constructor for an iterator over the elements of a sliced dataset
	 * 
	 * @param shape or dataShape
	 * @param length of entire data array
	 * @param start (if null then equivalent to the origin)
	 * @param sshape shape of new dataset, i.e. slice
	 */
	public SliceIterator(final int[] shape, final int length, final int[] start, final int[] sshape) {
		this(shape, length, start, null, sshape, 1);
	}

	/**
	 * Constructor for an iterator over the elements of a sliced dataset
	 * 
	 * @param shape or dataShape
	 * @param length of entire data array
	 * @param sshape shape of new dataset, i.e. slice
	 * @param isize number of elements in an item
	 */
	public SliceIterator(final int[] shape, final int length, final int[] sshape, final int isize) {
		this(shape, length, null, null, sshape, isize);
	}

	/**
	 * Constructor for an iterator over the elements of a sliced dataset
	 * 
	 * @param shape or dataShape
	 * @param length of entire data array
	 * @param start (if null then equivalent to the origin)
	 * @param sshape shape of new dataset, i.e. slice
	 * @param isize number of elements in an item
	 */
	public SliceIterator(final int[] shape, final int length, final int[] start, final int[] sshape, final int isize) {
		this(shape, length, start, null, sshape, isize);
	}

	/**
	 * Constructor for an iterator over the elements of a sliced dataset
	 * 
	 * @param shape or dataShape
	 * @param length of entire data array
	 * @param start (if null then equivalent to the origin)
	 * @param step (cannot contain zeros, if null then equivalent to ones)
	 * @param sshape shape of new dataset, i.e. slice
	 */
	public SliceIterator(final int[] shape, final int length, final int[] start, final int[] step, final int[] sshape) {
		this(shape, length, start, step, sshape, 1);
	}

	/**
	 * Constructor for an iterator over the elements of a sliced dataset
	 * 
	 * @param shape or dataShape
	 * @param length of entire data array
	 * @param slice
	 */
	public SliceIterator(final int[] shape, final int length, final SliceND slice) {
		this(shape, length, slice.getStart(), slice.getStep(), slice.getShape(), 1);
	}

	/**
	 * Constructor for an iterator over the elements of a sliced dataset
	 * 
	 * @param shape or dataShape
	 * @param length of entire data array
	 * @param isize number of elements in an item
	 * @param slice
	 */
	public SliceIterator(final int[] shape, final int length, final int isize, final SliceND slice) {
		this(shape, length, slice.getStart(), slice.getStep(), slice.getShape(), isize);
	}

	/**
	 * Constructor for an iterator over the elements of a sliced dataset
	 * 
	 * @param shape or dataShape
	 * @param length of entire data array
	 * @param start (if null then equivalent to the origin)
	 * @param step (cannot contain zeros, if null then equivalent to ones)
	 * @param sshape shape of new dataset, i.e. slice
	 * @param isize number of elements in an item
	 */
	public SliceIterator(final int[] shape, final int length, final int[] start, final int[] step, final int[] sshape, final int isize) {
		this.isize = isize;
		int rank = shape.length;
		endrank = rank - 1;
		this.shape = shape;
		this.start = new int[rank];
		this.sshape = sshape;
		if (step == null) {
			this.step = new int[rank];
			Arrays.fill(this.step, 1);
		} else {
			this.step = step;
		}

		if (rank == 0) {
			istep = isize;
			imax = length*isize;
			stop = new int[0];
			pos = new int[0];
			gap = null;
		} else {
			istep = this.step[endrank] * isize;
			imax = length * isize;
			stop = new int[rank];
			gap = new int[endrank + 1];
			pos = new int[rank];
			calcGap();
		}

		setStart(start);
	}

	void calcGap() {
		int chunk = isize;
		for (int i = endrank; i >= 0; i--) {
			stop[i] = start[i] + sshape[i] * step[i];
	
			if (step[i] < 0)
				stop[i]++; // adjust for -ve steps so later code has more succinct test
	
			if (i > 0) {
				gap[i] = (shape[i] * step[i - 1] - sshape[i] * step[i]) * chunk;
				chunk *= shape[i];
			}
		}
	}

	/**
	 * Set start (prefix with zeros if necessary)
	 * @param newStart if null, then treat as origin
	 */
	public void setStart(int... newStart) {
		final int rank = shape.length;
		if (rank == 0) {
			index = -istep;
			return;
		}

		if (newStart == null) {
			for (int i = 0; i < rank; i++) {
				start[i] = 0;
			}
		} else if (newStart.length > rank) {
			throw new IllegalArgumentException("Length of start array greater than rank");
		} else {
			int extra = rank - newStart.length;
			for (int i = 0; i < extra; i++) {
				start[i] = 0;
			}
			for (int i = 0; i < newStart.length; i++) {
				start[i+extra] = newStart[i];
			}
		}

		reset();
		calcGap();
	}

	@Override
	public void reset() {
		if (shape.length == 0) {
			index = -istep;
		} else {
			// work out index of first position
			for (int i = 0; i < shape.length; i++)
				pos[i] = start[i];
			pos[endrank] -= step[endrank];
	
			index = pos[0];
			for (int j = 1; j <= endrank; j++)
				index = index * shape[j] + pos[j];
			index *= isize;
		}
	}

	@Override
	public boolean hasNext() {
		// now move on one position in slice
		int j = endrank;
		for (; j >= 0; j--) {
			pos[j] += step[j];

			if ((pos[j] >= stop[j]) == (step[j] > 0)) { // stop index has been adjusted in code for -ve steps
				pos[j] = start[j];
				index += gap[j];
			} else {
				break;
			}
		}
		if (j == -1 && endrank >= 0) {
			index = imax;
			return false;
		}

		index += istep;
		return index < imax;
	}

	public int[] getStart() {
		return start;
	}

	@Override
	public int[] getPos() {
		return pos;
	}

	public int[] getStep() {
		return step;
	}

	@Override
	public int[] getShape() {
		return sshape;
	}
}
