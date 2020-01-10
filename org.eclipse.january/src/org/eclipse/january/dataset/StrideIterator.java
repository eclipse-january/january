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
 * Class to run over a contiguous dataset using strides
 */
public class StrideIterator extends SliceIterator {
	private int[] stride;
	private int[] delta;  // reset values
	private int nstart;
	private int element;
	private boolean zero;

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
		this(isize, shape, strides, offset, 0);
	}

	public StrideIterator(final int isize, final int[] shape, final int[] strides, final int offset, final int element) {
		final int rank = shape == null ? 0 : shape.length;
		start = new int[rank];
		stop = shape;
		step = new int[rank];
		Arrays.fill(step, 1);
		this.sshape = shape;

		init(isize, shape, strides, offset, element);
		reset();
	}

	public StrideIterator(final int isize, final int[] shape, final int[] start, final int[] stop, final int[] step) {
		this(isize, shape, null, 0, start, stop, step);
	}

	public StrideIterator(final int isize, final int[] shape, final int[] oStrides, final int oOffset, final int[] start, final int[] stop, final int[] step) {
		this(isize, shape, oStrides, oOffset, new SliceND(shape, start, stop, step));
	}

	public StrideIterator(final int isize, final int[] shape, final int[] strides, final int offset, final SliceND slice) {
		start = slice.getStart();
		stop = slice.getStop();
		step = slice.getStep();
		this.sshape = slice.getShape();

		init(isize, shape, strides, offset, 0);
		reset();
	}

	private void init(final int isize, final int[] shape, final int[] strides, int offset, final int element) {
		this.isize = isize;
		istep = isize;
		this.shape = shape;
		final int rank = shape == null ? 0 : shape.length;
		zero = shape == null;
		endrank = rank - 1;
		pos = new int[rank];
		delta = new int[rank];
		this.element = element;
		if (strides == null) {
			offset = 0;
			stride = new int[rank];
			int s = isize;
			for (int j = endrank; j >= 0; j--) {
				stride[j] = s;
				s *= shape[j];
			}
		} else {
			stride = strides.clone();
		}

		for (int j = endrank; j >= 0; j--) {
			int t = stride[j];
			offset += t * start[j];
			t *= step[j];
			stride[j] = t;
			int s = sshape[j];
			if (!zero) {
				zero = s == 0;
			}
			delta[j] = s * t;
		}

		nstart = offset;
	}

	@Override
	void calcGap() {
		// do nothing
	}

	@Override
	public boolean hasNext() {
		if (zero) {
			return false;
		}

		// now move on one position
		int j = endrank;
		if (j < 0) {
			index += istep;
			return index < istep;
		}
		for (; j >= 0; j--) {
			index += stride[j];
			final int s = step[j];
			final int p = pos[j] + s;
			if ((s > 0 && p < stop[j]) || (s < 0 && p > stop[j])) {
				pos[j] = p;
				break;
			}
			pos[j] = start[j];
			index -= delta[j]; // reset this dimension
		}
		return j >= 0;
	}

	@Override
	public int[] getPos() {
		return pos;
	}

	@Override
	public void reset() {
		System.arraycopy(start, 0, pos, 0, start.length);
		if (endrank >= 0) {
			pos[endrank] -= step[endrank];
			index = nstart - stride[endrank];
		} else {
			index = -istep;
		}
		index += element;
	}
}
