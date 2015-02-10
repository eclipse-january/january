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


/**
 * Class to run over non-contiguous or fragmented datasets
 */
public class DiscontiguousIterator extends IndexIterator {
	final private int[] shape;
	final private int endrank; // last dimensions index
	final private int[] gaps; // gaps in dataset
	final private int imax; // maximum index in array
	final private int istep; // step over items
	final private int[] pos; // position in dataset

	/**
	 * Constructor for an iterator over the elements of a dataset that are
	 * within the dimensions
	 *
	 * @param shape
	 * @param dataShape
	 * @param length of entire data array
	 */
	public DiscontiguousIterator(final int[] shape, final int[] dataShape, final int length) {
		this(shape, dataShape, length, 1);
	}

	/**
	 * Constructor for an iterator over the elements of a dataset that are
	 * within the dimensions
	 *
	 * @param shape
	 * @param dataShape
	 * @param length of entire data array
	 * @param isize number of elements in an item
	 */
	public DiscontiguousIterator(final int[] shape, final int[] dataShape, final int length, final int isize) {
		this.shape = shape;
		endrank = shape.length - 1;
		istep = isize;
		pos = new int[endrank + 1];
		pos[endrank] = -1;
		index = -isize;
		imax = length;

		gaps = new int[endrank + 1];
		int chunk = isize;
		for (int i = endrank; i >= 0; i--) {
			gaps[i] = (dataShape[i] - shape[i])*chunk;
			chunk *= dataShape[i];
		}
	}

	@Override
	public boolean hasNext() {
		// now move on one position
		int j = endrank;
		for (; j >= 0; j--) {
			pos[j]++;
			if (pos[j] >= shape[j]) {
				pos[j] = 0;
				index += gaps[j];
			} else {
				break;
			}
		}
		if (j == -1) {
			index = imax;
			return false;
		}

		index += istep;
		return index < imax;
	}

	@Override
	public int[] getPos() {
		return pos;
	}

	@Override
	public void reset() {
		Arrays.fill(pos, 0);
		pos[endrank] = -1;
		index = -istep;
	}

	@Override
	public int[] getShape() {
		return shape;
	}
}
