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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Statistics of data set lists. Used for image processing.
 */
public class CollectionStats {

	private static interface StatFunction {
		double evaluate(Dataset set);
	}

	/**
	 * Used to get a mean image from a set of images for instance.
	 * 
	 * @param sets datasets
	 * @return mean dataset of the same shape as those passed in
	 * @throws Exception when datasets have different shapes
	 */
	public static Dataset mean(final List<IDataset> sets) throws Exception {
		
		return process(sets, new StatFunction() {
			@Override
			public double evaluate(Dataset set) {
				return (Double)set.mean();
			}
		});
	}
	
	/**
	 * Used to get a median image from a set of images for instance.
	 * 
	 * @param sets datasets
	 * @return median dataset of the same shape as those passed in
	 * @throws Exception when datasets have different shapes
	 */
	public static Dataset median(final List<IDataset> sets) throws Exception {
		
		return process(sets, new StatFunction() {
			@Override
			public double evaluate(Dataset set) {
				return (Double)Stats.median(set);
			}
		});
	}

	/**
	 * Used to get a median image from a set of images for instance.
	 * 
	 * @param sets datasets
	 * @return median data set of the same shape as those passed in.
	 * @throws Exception when datasets have different shapes
	 */
	private static Dataset process(final List<IDataset> sets, final StatFunction function) throws Exception {
		
		int[] shape = assertShapes(sets);
		final DoubleDataset result = DatasetFactory.zeros(DoubleDataset.class, shape);
		final double[] rData = result.getData();
		final IndexIterator iter = new PositionIterator(shape);
		final int[] pos = iter.getPos();

		final int len = sets.size();
		final DoubleDataset pixel = DatasetFactory.zeros(DoubleDataset.class, len);
		final double[] pData = pixel.getData();
		for (int i = 0; iter.hasNext(); i++) {
			for (int ipix = 0; ipix < len; ipix++) {
				pData[ipix] = sets.get(ipix).getDouble(pos);
			}
			pixel.setDirty();
			rData[i] = function.evaluate(pixel);
		}

		return result;
	}

	private static int[] assertShapes(final Collection<IDataset> sets) throws Exception {
		
		if (sets.size()<2) throw new IllegalArgumentException("You must take the median of at least two sets!");
		
		final Iterator<IDataset> it = sets.iterator();
		final int[] shape = it.next().getShape();
		while (it.hasNext()) {
			IDataset d = it.next();
			final int[] nextShape = d.getShape();
			if (!Arrays.equals(shape, nextShape)) throw new IllegalArgumentException("All data sets should be the same shape!");
		}
		return shape;
	}
}
