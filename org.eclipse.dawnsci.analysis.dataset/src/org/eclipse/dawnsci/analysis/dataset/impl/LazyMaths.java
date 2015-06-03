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

import org.eclipse.dawnsci.analysis.api.dataset.IDataset;
import org.eclipse.dawnsci.analysis.api.dataset.ILazyDataset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mathematics class for lazy datasets
 */
public final class LazyMaths {
	/**
	 * Setup the logging facilities
	 */
	protected static final Logger logger = LoggerFactory.getLogger(LazyMaths.class);

	/**
	 * @param data
	 * @param axis (can be negative)
	 * @return sum along axis in lazy dataset
	 */
	public static Dataset sum(final ILazyDataset data, int axis) {
		int[][] sliceInfo = new int[3][];
		int[] shape = data.getShape();
		final Dataset result = prepareDataset(axis, shape, sliceInfo);

		final int[] start = sliceInfo[0];
		final int[] stop = sliceInfo[1];
		final int[] step = sliceInfo[2];
		final int length = shape[axis];

		for (int i = 0; i < length; i++) {
			start[axis] = i;
			stop[axis] = i + 1;
			result.iadd(data.getSlice(start, stop, step));
		}

		result.setShape(AbstractDataset.squeezeShape(shape, axis));
		return result;
	}

	/**
	 * @param data
	 * @param axis (can be negative)
	 * @return product along axis in lazy dataset
	 */
	public static Dataset product(final ILazyDataset data, int axis) {
		int[][] sliceInfo = new int[3][];
		int[] shape = data.getShape();
		final Dataset result = prepareDataset(axis, shape, sliceInfo);
		result.fill(1);

		final int[] start = sliceInfo[0];
		final int[] stop = sliceInfo[1];
		final int[] step = sliceInfo[2];
		final int length = shape[axis];

		for (int i = 0; i < length; i++) {
			start[axis] = i;
			stop[axis] = i + 1;
			result.imultiply(data.getSlice(start, stop, step));
		}

		result.setShape(AbstractDataset.squeezeShape(shape, axis));
		return result;
	}

	/**
	 * @param start
	 * @param stop inclusive
	 * @param data
	 * @param ignoreAxes
	 * @return mean when given axes are ignored in lazy dataset
	 */
	public static Dataset mean(int start, int stop, ILazyDataset data, int... ignoreAxes) {
		int[] shape = data.getShape();
		PositionIterator iter = new PositionIterator(shape, ignoreAxes);
		int[] pos = iter.getPos();
		boolean[] omit = iter.getOmit();

		int rank = shape.length;
		int[] st = new int[rank];
		Arrays.fill(st, 1);
		int[] end = new int[rank];

		RunningAverage av = null;
		int c = 0;
		while (iter.hasNext() && c < stop) {
			if (c++ < start) continue;
			for (int i = 0; i < rank; i++) {
				end[i] = omit[i] ? shape[i] : pos[i] + 1;
			}
			IDataset ds = data.getSlice(pos, end, st);
			if (av == null) {
				av = new RunningAverage(ds);
			} else {
				av.update(ds);
			}
		}

		return  av != null ? av.getCurrentAverage().squeeze() : null;
	}
	
	public static Dataset mean(ILazyDataset data, int... ignoreAxes) {
		return mean(0, Integer.MAX_VALUE -1 , data, ignoreAxes);
	}

	private static Dataset prepareDataset(int axis, int[] shape, int[][] sliceInfo) {
		int rank = shape.length;
		if (axis < 0)
			axis += rank;
		if (axis < 0 || axis >= rank) {
			logger.error("Axis argument is outside allowed range");
			throw new IllegalArgumentException("Axis argument is outside allowed range");
		}

		sliceInfo[0] = new int[rank];
		sliceInfo[1] = shape.clone();
		sliceInfo[2] = new int[rank];
		Arrays.fill(sliceInfo[2], 1);

		final int[] nshape = shape.clone();
		nshape[axis] = 1;

		return DatasetFactory.zeros(nshape, Dataset.FLOAT64);
	}
}
