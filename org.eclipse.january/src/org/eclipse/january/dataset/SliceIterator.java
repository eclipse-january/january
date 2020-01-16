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


import java.util.Arrays;

/**	
 * The {@code SliceIterator} class is use to run over a Slice of a Dataset.
 * 
 * This is an Iterator thats allows the programmer to traverse the elements of a sliced Dataset and obtain the current position, the starts, steps,
 * shapes.
 * Moreover, there is possibilities to set the start point to begin at the wanted position.
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
	 * Constructs an SliceIterator Object, which can iterate over sliced
	 * Datasets elements, by default the start set to 0 and with a step of 1.
	 * 
	 * @param shape
	 *            Array of shapes of the Dataset
	 * @param length
	 *            Length of entire data array
	 * @param sshape
	 *            Shape of the new dataset, i.e. slice
	 */
	public SliceIterator(final int[] shape, final int length, final int[] sshape) {
		this(shape, length, null, null, sshape, 1);
	}

	/**
	 * Constructs an SliceIterator Object, which can iterate over sliced
	 * Datasets elements, by default the start set to 0 and with a step of 1.
	 * 
	 * @param shape
	 *            Array of shapes of the Dataset
	 * @param length
	 *            Length of entire data array
	 * @param start
	 *            Array of starts indexes, may be {@code null}
	 * @param sshape
	 *            Shape of the new dataset, i.e. slice
	 */
	public SliceIterator(final int[] shape, final int length, final int[] start, final int[] sshape) {
		this(shape, length, start, null, sshape, 1);
	}

	/**
	 * Constructs an SliceIterator Object, which can iterate over sliced
	 * Datasets elements, by default the start set to 0 and with a step of 1.
	 * 
	 * @param shape
	 *            Array of shapes of the Dataset
	 * @param length
	 *            Length of entire data array
	 * @param sshape
	 *            Shape of the new dataset, i.e. slice
	 * @param isize
	 *            Number of elements in an item
	 */
	public SliceIterator(final int[] shape, final int length, final int[] sshape, final int isize) {
		this(shape, length, null, null, sshape, isize);
	}

	/**
	 * Constructs an SliceIterator Object, which can iterate over sliced
	 * Datasets elements, by default the start set to 0 and with a step of 1.
	 * 
	 * @param shape
	 *            Array of shapes of the Dataset
	 * @param length
	 *            Length of entire data array
	 * @param start
	 *            Array of starts indexes, may be {@code null}
	 * @param sshape
	 *            Shape of the new dataset, i.e. slice
	 * @param isize
	 *            Number of elements in an item
	 */
	public SliceIterator(final int[] shape, final int length, final int[] start, final int[] sshape, final int isize) {
		this(shape, length, start, null, sshape, isize);
	}

	/**
	 * Constructs an SliceIterator Object, which can iterate over sliced
	 * Datasets elements, by default the start set to 0 and with a step of 1.
	 * 
	 * @param shape
	 *            Array of shapes of the Dataset
	 * @param length
	 *            Length of entire data array
	 * @param start
	 *            Array of starts indexes, may be {@code null}
	 * @param step
	 *            Array of steps, may be {@code null}, but can't be 0
	 * @param sshape
	 *            shape of new dataset, i.e. slice
	 */
	public SliceIterator(final int[] shape, final int length, final int[] start, final int[] step, final int[] sshape) {
		this(shape, length, start, step, sshape, 1);
	}

	/**
	 * Constructs an SliceIterator Object, which can iterate over sliced
	 * Datasets elements, by default the start set to 0 and with a step of 1.
	 * 
	 * @param shape
	 *            Array of shapes of the Dataset
	 * @param length
	 *            Length of entire data array
	 * @param slice
	 *            SliceND to iterate on
	 */
	public SliceIterator(final int[] shape, final int length, final SliceND slice) {
		this(shape, length, slice.getStart(), slice.getStep(), slice.getShape(), 1);
	}

	/**
	 * Constructs an SliceIterator Object, which can iterate over sliced
	 * Datasets elements, by default the start set to 0 and with a step of 1.
	 * 
	 * @param shape
	 *            Array of shapes of the Dataset
	 * @param length
	 *            Length of entire data array
	 * @param isize
	 *            Number of elements in an item
	 * @param slice
	 *            SliceND to iterate on
	 */
	public SliceIterator(final int[] shape, final int length, final int isize, final SliceND slice) {
		this(shape, length, slice.getStart(), slice.getStep(), slice.getShape(), isize);
	}

	/**
	 * Constructs an SliceIterator Object, which can iterate over sliced
	 * Datasets elements, by default the start set to 0 and with a step of 1.
	 * 
	 * @param shape
	 *            Array of shapes of the Dataset
	 * @param length
	 *            Length of entire data array
	 * @param start
	 *            Array of starts indexes, may be {@code null}
	 * @param step
	 *            Array of steps, may be {@code null}, but can't be 0
	 * @param sshape
	 *            Shape of the new dataset, i.e. slice
	 * @param isize
	 *            Number of elements in an item
	 */
	public SliceIterator(final int[] shape, final int length, final int[] start, final int[] step, final int[] sshape,
			final int isize) {
		this.isize = isize;
		final int rank = shape == null ? 0 : shape.length;
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
			imax = length * isize;
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

			if (step[i] < 0) {
				stop[i]++; // adjust for -ve steps so later code has more succinct test
			}

			if (i > 0) {
				gap[i] = (shape[i] * step[i - 1] - sshape[i] * step[i]) * chunk;
				chunk *= shape[i];
			}
		}
	}

	/**
	 * Set the starts indexes to new positions, {@code if null} the start index
	 * is set by default to 0
	 * 
	 * @param newStart
	 *            Array of new starts indexes (prefix with zeros if necessary),
	 *            may be {@code null}
	 */
	public void setStart(int... newStart) {
		final int rank = shape == null ? 0 : shape.length;
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
				start[i + extra] = newStart[i];
			}
		}

		reset();
		calcGap();
	}

	/**
	 * Reset the Iterator to the first Slice.
	 */
	@Override
	public void reset() {
		final int rank = shape == null ? 0 : shape.length;
		if (rank == 0) {
			index = -istep;
		} else {
			// work out index of first position
			for (int i = 0; i < shape.length; i++) {
				pos[i] = start[i];
			}
			pos[endrank] -= step[endrank];

			index = pos[0];
			for (int j = 1; j <= endrank; j++)
				index = index * shape[j] + pos[j];
			index *= isize;
		}
	}

	/**
	 * Returns {@code true} if there is an other element after the current
	 * Slice.
	 * 
	 * @return Returns {@code true} if the iteration has more Slice, {@code false} in
	 *         the other case
	 */
	@Override
	public boolean hasNext() {
		// now move on one position in slice
		int j = endrank;
		for (; j >= 0; j--) {
			pos[j] += step[j];

			if ((pos[j] >= stop[j]) == (step[j] > 0)) { 
				pos[j] = start[j]; // stop index has been adjusted in code for -ve steps
				index += gap[j];
			} else {
				break;
			}
		}
		if (j == -1 && endrank >= 0) {
			return false;
		}

		index += istep;
		return index < imax;
	}

	/**
	 * Returns an array of starts indexes.
	 * 
	 * @return Array of starts indexes
	 */
	public int[] getStart() {
		return start;
	}

	/**
	 * Returns the current position of the iterator.
	 * 
	 * @return Iterator current position
	 */
	@Override
	public int[] getPos() {
		return pos;
	}

	/**
	 * Returns an array of steps
	 * 
	 * @return Array of steps
	 */
	public int[] getStep() {
		return step;
	}

	/**
	 * Returns an array of the Slices shapes.
	 * 
	 * @return Array of shapes.
	 */
	@Override
	public int[] getShape() {
		return sshape;
	}
}
