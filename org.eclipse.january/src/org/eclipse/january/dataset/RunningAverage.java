/*-
 * Copyright 2015, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import org.eclipse.january.DatasetException;

/**
 * A running mean class
 */
public class RunningAverage {
	
	private DoubleDataset average;
	private DoubleDataset sqAveError;
	private int count = 1;

	/**
	 * @param dataset
	 */
	public RunningAverage(IDataset dataset) {
		average = (DoubleDataset) (dataset.getElementClass().equals(Double.class) ? DatasetUtils.convertToDataset(dataset).clone()
				: DatasetUtils.cast(DoubleDataset.class, dataset));

		sqAveError = null;
		Dataset eb = average.getErrorBuffer();
		if (eb != null) {
			sqAveError = DatasetUtils.cast(DoubleDataset.class, eb);
		}
	}

	/**
	 * Update average
	 * @param dataset
	 */
	public void update(IDataset dataset) {
		count++;
		IndexIterator it = average.getIterator(true);
		int[] pos = it.getPos();
		double f = 1. / count;
		if (sqAveError == null) {
			while (it.hasNext()) {
				double m = average.getAbs(it.index);
				double v = f * (dataset.getDouble(pos) - m);
				average.setAbs(it.index, m + v);
			}
		} else {
			double fs = f * f;
			double gs = 2 * count - 1;
			if (dataset instanceof Dataset) {
				final Dataset d = (Dataset) dataset;
				final Dataset e = d.getErrorBuffer();
				while (it.hasNext()) {
					double m = average.getAbs(it.index);
					double v = f * (d.getDouble(pos) - m);
					average.setAbs(it.index, m + v);

					if (e != null) {
						m = sqAveError.getDouble(pos);
						v = fs * (e.getDouble(pos) - gs * m);
						sqAveError.setItem(m + v, pos);
					}
				}
			} else { // only linear error available
				ILazyDataset le = dataset.getErrors();
				IDataset e = null;
				if (le instanceof IDataset) {
					e = (IDataset) le;
				} else if (le != null) {
					try {
						e = le.getSlice();
					} catch (DatasetException e1) {
					}
				}
				while (it.hasNext()) {
					double m = average.getAbs(it.index);
					double v = f * (dataset.getDouble(pos) - m);
					average.setAbs(it.index, m + v);

					if (e != null) {
						m = sqAveError.getDouble(pos);
						v = e.getDouble(pos);
						v = fs * (v * v - gs * m);
						sqAveError.setItem(m + v, pos);
					}
				}
			}
		}
	}

	/**
	 * @return count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @return current average
	 */
	public Dataset getCurrentAverage() {
		if (sqAveError != null) {
			Dataset e = sqAveError.clone();
			DatasetUtils.makeFinite(e);
			average.setErrorBuffer(e);
		}

		return average;
	}
}
