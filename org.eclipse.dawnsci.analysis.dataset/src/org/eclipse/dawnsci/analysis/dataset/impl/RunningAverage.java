/*-
 * Copyright 2015 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.dataset.impl;

import org.eclipse.dawnsci.analysis.api.dataset.IDataset;
import org.eclipse.dawnsci.analysis.api.dataset.ILazyDataset;

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
		average = (DoubleDataset) (dataset.elementClass().equals(Double.class) ? DatasetUtils.convertToDataset(dataset).clone()
				: DatasetUtils.cast(dataset, Dataset.FLOAT64));

		sqAveError = null;
		Dataset eb = average.getErrorBuffer();
		if (eb != null) {
			sqAveError = eb.getDtype() != Dataset.FLOAT64 ? (DoubleDataset) DatasetUtils.cast(eb, Dataset.FLOAT64) :
				(DoubleDataset) eb;
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
				ILazyDataset le = dataset.getError();
				final IDataset e;
				if (le instanceof IDataset) {
					e = (IDataset) le;
				} else if (le != null) {
					e = le.getSlice();
				} else {
					e = null;
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
