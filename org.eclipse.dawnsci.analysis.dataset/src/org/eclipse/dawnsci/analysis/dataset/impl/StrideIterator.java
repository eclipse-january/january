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
 * Class to run over a contiguous dataset using strides
 */
public class StrideIterator extends SliceIterator {
	private int[] stride;
	private int[] delta;  // reset values
	private int nstart;

	public StrideIterator(final int[] shape) {
		this(shape, null, 0);
	}

	public StrideIterator(final int isize, final int[] shape) {
		this(isize, shape, null, 0);
	}

	public StrideIterator(final int[] shape, final int[] strides) {
		this(shape, strides, 0);
	}

	public StrideIterator(final int[] shape, final int[] strides, final int offset) {
		this(1, shape, strides, offset);
	}

	public StrideIterator(final int isize, final int[] shape, final int[] strides, final int offset) {
		init(isize, shape, strides, offset);
		reset();
	}

	public StrideIterator(final int isize, final int[] shape, final int[] start, final int[] stop, final int[] step) {
		this(isize, shape, null, 0, start, stop, step);
	}

	public StrideIterator(final int isize, final int[] shape, final int[] oStrides, final int oOffset, final int[] start, final int[] stop, final int[] step) {
		this(isize, shape, oStrides, oOffset, new SliceND(shape, start, stop, step));
	}

	public StrideIterator(final int isize, final int[] shape, final int[] oStrides, final int oOffset, final SliceND slice) {
		int rank = shape.length;
		int[] strides = new int[rank];
		int[] offset = new int[1];
		int[] newShape = AbstractDataset.createStrides(slice, isize, shape, oStrides, oOffset, strides, offset);

		init(isize, newShape, strides, offset[0]);
		reset();
	}

	private void init(final int isize, final int[] shape, final int[] strides, final int offset) {
		this.isize = isize;
		istep = isize;
		this.shape = shape;
		int rank = shape.length;
		endrank = rank - 1;
		pos = new int[rank];
		delta = new int[rank];
		if (strides != null) {
			stride = strides;
			for (int j = endrank; j >= 0; j--) {
				delta[j] = stride[j] * shape[j];
			}
			if (endrank < 0) {
				imax = istep;
			} else {
				imax = Integer.MIN_VALUE; // use max delta
				for (int j = endrank; j >= 0; j--) {
					if (delta[j] > imax) {
						imax = delta[j];
					}
				}
			}
		} else {
			stride = new int[rank];
			int s = isize;
			for (int j = endrank; j >= 0; j--) {
				stride[j] = s;
				s *= shape[j];
				delta[j] = s;
			}
			imax = s;
		}
		nstart = offset;
		imax += nstart;
	}

	@Override
	void calcGap() {
		// do nothing
	}

	@Override
	public int[] getShape() {
		return shape;
	}

	@Override
	public boolean hasNext() {
		// now move on one position
		int j = endrank;
		for (; j >= 0; j--) {
			index += stride[j];
			final int p = pos[j] + 1;
			if (p < shape[j]) {
				pos[j] = p;
				break;
			}
			pos[j] = 0;
			index -= delta[j]; // reset this dimension
		}
		if (j == -1) {
			if (endrank >= 0) {
				index = imax;
				return false;
			}
			index += istep;
		}

		return index != imax;
	}

	@Override
	public int[] getPos() {
		return pos;
	}

	@Override
	public void reset() {
		Arrays.fill(pos, 0);
		if (endrank >= 0) {
			pos[endrank] = -1;
			index = nstart - stride[endrank];
		} else {
			index = -istep;
		}
	}
}
