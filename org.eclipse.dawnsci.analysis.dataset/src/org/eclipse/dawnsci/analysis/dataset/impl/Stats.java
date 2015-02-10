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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.stat.descriptive.moment.Kurtosis;
import org.apache.commons.math3.stat.descriptive.moment.Skewness;


/**
 * Statistics class
 * 
 * TODO Where is mode? http://en.wikipedia.org/wiki/Mode_(statistics)
 * 
 */
public class Stats {

	private static final String STORE_KURTOSIS = "kurtosis";
	private static final String STORE_SKEWNESS = "skewness";
	private static final String STORE_MEDIAN = "median";
	private static final String STORE_QUARTILE1 = "quartile1";
	private static final String STORE_QUARTILE3 = "quartile3";

	// calculates statistics and returns sorted dataset (0th element if compound)
	private static Dataset calcQuartileStats(final AbstractDataset a) {
		Dataset s = null;
		final int is = a.getElementsPerItem();

		if (is == 1) {
			s = DatasetUtils.sort(a, null);
		
			a.setStoredValue(STORE_MEDIAN, Double.valueOf(pQuantile(s, 0.5)));
			a.setStoredValue(STORE_QUARTILE1, Double.valueOf(pQuantile(s, 0.25)));
			a.setStoredValue(STORE_QUARTILE3, Double.valueOf(pQuantile(s, 0.75)));
		} else {
			Dataset w = DatasetFactory.zeros(a.getShapeRef(), a.getDtype());
			a.setStoredValue(STORE_MEDIAN, new double[is]);
			a.setStoredValue(STORE_QUARTILE1, new double[is]);
			a.setStoredValue(STORE_QUARTILE3, new double[is]);
			for (int j = 0; j < is; j++) {
				((CompoundDataset) a).copyElements(w, j);
				w.sort(null);

				double[] store;
				store = (double[]) a.getStoredValue(STORE_MEDIAN);
				store[j] = pQuantile(w, 0.5);
				store = (double[]) a.getStoredValue(STORE_QUARTILE1);
				store[j] = pQuantile(w, 0.25);
				store = (double[]) a.getStoredValue(STORE_QUARTILE3);
				store[j] = pQuantile(w, 0.75);
				if (j == 0)
					s = w.clone();
			}
		}
		return s;
	}

	static private Object getQStatistics(final AbstractDataset a, final String stat) {
		Object m = a.getStoredValue(stat);
		if (m == null) {
			calcQuartileStats(a);
			m = a.getStoredValue(stat);
		}
		return m;
	}

	static private Dataset getQStatistics(final AbstractDataset a, int axis, final String stat) {
		axis = a.checkAxis(axis);
		Object obj = a.getStoredValue(stat);
		final int is = a.getElementsPerItem();

		if (obj == null) {
			if (is == 1) {
				Dataset s = DatasetUtils.sort(a, axis);

				a.setStoredValue(STORE_MEDIAN + "-" + axis, pQuantile(s, axis, 0.5));
				a.setStoredValue(STORE_QUARTILE1 + "-" + axis, pQuantile(s, axis, 0.25));
				a.setStoredValue(STORE_QUARTILE3 + "-" + axis, pQuantile(s, axis, 0.75));
			} else {
				Dataset w = DatasetFactory.zeros(a.getShapeRef(), a.getDtype());
				for (int j = 0; j < is; j++) {
					((CompoundDataset) a).copyElements(w, j);
					w.sort(axis);

					CompoundDoubleDataset s;
					final Dataset c = pQuantile(w, axis, 0.5);
					if (j == 0) {
						s = (CompoundDoubleDataset) DatasetFactory.zeros(is, c.getShapeRef(), c.getDtype());
						a.setStoredValue(STORE_MEDIAN + "-" + axis, s);
						s = (CompoundDoubleDataset) DatasetFactory.zeros(is, c.getShapeRef(), c.getDtype());
						a.setStoredValue(STORE_QUARTILE1 + "-" + axis, s);
						s = (CompoundDoubleDataset) DatasetFactory.zeros(is, c.getShapeRef(), c.getDtype());
						a.setStoredValue(STORE_QUARTILE3 + "-" + axis, s);
					}
					s = (CompoundDoubleDataset) a.getStoredValue(STORE_MEDIAN + "-" + axis);
					s.setElements(c, j);

					s = (CompoundDoubleDataset) a.getStoredValue(STORE_QUARTILE1 + "-" + axis);
					s.setElements(pQuantile(w, axis, 0.25), j);

					s = (CompoundDoubleDataset) a.getStoredValue(STORE_QUARTILE3 + "-" + axis);
					s.setElements(pQuantile(w, axis, 0.75), j);
				}
			}
			obj = a.getStoredValue(stat);
		}

		return (Dataset) obj;
	}

	// process a sorted dataset
	private static double pQuantile(final Dataset s, final double q) {
		double f = (s.getSize() - 1) * q; // fraction of sample number
		if (f < 0)
			return Double.NaN;
		int qpt = (int) Math.floor(f); // quantile point
		f -= qpt;

		double quantile = s.getElementDoubleAbs(qpt);
		if (f > 0) {
			quantile = (1-f)*quantile + f*s.getElementDoubleAbs(qpt+1);
		}
		return quantile;
	}

	// process a sorted dataset and returns a double or compound double dataset
	private static Dataset pQuantile(final Dataset s, final int axis, final double q) {
		final int rank = s.getRank();
		final int is = s.getElementsPerItem();

		int[] oshape = s.getShape();

		double f = (oshape[axis] - 1) * q; // fraction of sample number
		int qpt = (int) Math.floor(f); // quantile point
		f -= qpt;

		oshape[axis] = 1;
		int[] qshape = AbstractDataset.squeezeShape(oshape, false);
		Dataset qds = DatasetFactory.zeros(is, qshape, Dataset.FLOAT64);

		IndexIterator qiter = qds.getIterator(true);
		int[] qpos = qiter.getPos();
		int[] spos = oshape;

		while (qiter.hasNext()) {
			int i = 0;
			for (; i < axis; i++) {
				spos[i] = qpos[i];
			}
			spos[i++] = qpt;
			for (; i < rank; i++) {
				spos[i] = qpos[i-1];
			}

			Object obj = s.getObject(spos);
			qds.set(obj, qpos);
		}

		if (f > 0) {
			qiter = qds.getIterator(true);
			qpos = qiter.getPos();
			qpt++;
			Dataset rds = DatasetFactory.zeros(is, qshape, Dataset.FLOAT64);
			
			while (qiter.hasNext()) {
				int i = 0;
				for (; i < axis; i++) {
					spos[i] = qpos[i];
				}
				spos[i++] = qpt;
				for (; i < rank; i++) {
					spos[i] = qpos[i-1];
				}

				Object obj = s.getObject(spos);
				rds.set(obj, qpos);
			}
			rds.imultiply(f);
			qds.imultiply(1-f);
			qds.iadd(rds);
		}

		return qds;
	}

	/**
	 * Calculate quantile of dataset which is defined as the inverse of the cumulative distribution function (CDF)
	 * @param a
	 * @param q
	 * @return point at which CDF has value q
	 */
	public static double quantile(final Dataset a, final double q) {
		if (q < 0 || q > 1) {
			throw new IllegalArgumentException("Quantile requested is outside [0,1]");
		}
		final Dataset s = calcQuartileStats(DatasetUtils.convertToAbstractDataset(a));
		return pQuantile(s, q);
	}

	/**
	 * Calculate quantiles of dataset which is defined as the inverse of the cumulative distribution function (CDF)
	 * @param a
	 * @param values
	 * @return points at which CDF has given values
	 */
	public static double[] quantile(final Dataset a, final double... values) {
		final double[] points  = new double[values.length];
		final Dataset s = calcQuartileStats(DatasetUtils.convertToAbstractDataset(a));
		for (int i = 0; i < points.length; i++) {
			final double q = values[i];
			if (q < 0 || q > 1) {
				throw new IllegalArgumentException("Quantile requested is outside [0,1]");
			}
			points[i] = pQuantile(s, q);
		}
		return points;
	}

	/**
	 * Calculate quantiles of dataset which is defined as the inverse of the cumulative distribution function (CDF)
	 * @param a
	 * @param axis
	 * @param values
	 * @return points at which CDF has given values
	 */
	public static Dataset[] quantile(final Dataset a, final int axis, final double... values) {
		final Dataset[] points  = new Dataset[values.length];
		final int is = a.getElementsPerItem();

		if (is == 1) {
			Dataset s = DatasetUtils.sort(a, axis);
			for (int i = 0; i < points.length; i++) {
				final double q = values[i];
				if (q < 0 || q > 1) {
					throw new IllegalArgumentException("Quantile requested is outside [0,1]");
				}
				points[i] = pQuantile(s, axis, q);
			}
		} else {
			Dataset w = DatasetFactory.zeros(a.getShapeRef(), a.getDtype());
			for (int j = 0; j < is; j++) {
				((CompoundDataset) a).copyElements(w, j);
				w.sort(axis);

				for (int i = 0; i < points.length; i++) {
					final double q = values[i];
					if (q < 0 || q > 1) {
						throw new IllegalArgumentException("Quantile requested is outside [0,1]");
					}
					final Dataset c = pQuantile(w, axis, q);
					if (j == 0) {
						points[i] = DatasetFactory.zeros(is, c.getShapeRef(), c.getDtype());
					}
					((CompoundDoubleDataset) points[i]).setElements(c, j);
				}
			}
		}

		return points;
	}

	/**
	 * @param a dataset
	 * @param axis
	 * @return median
	 */
	public static Dataset median(final Dataset a, final int axis) {
		return getQStatistics(DatasetUtils.convertToAbstractDataset(a), axis, STORE_MEDIAN + "-" + axis);
	}

	/**
	 * @param a dataset
	 * @return median
	 */
	public static Object median(final Dataset a) {
		return getQStatistics(DatasetUtils.convertToAbstractDataset(a), STORE_MEDIAN);
	}

	/**
	 * Interquartile range: Q3 - Q1
	 * @param a
	 * @return range
	 */
	public static Object iqr(final Dataset a) {
		AbstractDataset aa = DatasetUtils.convertToAbstractDataset(a);
		final int is = aa.getElementsPerItem();
		if (is == 1) {
			double q3 = ((Double) getQStatistics(aa, STORE_QUARTILE3));
			return Double.valueOf(q3 - ((Double) aa.getStoredValue(STORE_QUARTILE1)).doubleValue());
		}

		double[] q1 = (double[]) getQStatistics(aa, STORE_QUARTILE1);
		double[] q3 = (double[]) getQStatistics(aa, STORE_QUARTILE3);
		for (int j = 0; j < is; j++) {
			q3[j] -= q1[j];
		}
		return q3;
	}

	/**
	 * Interquartile range: Q3 - Q1
	 * @param a
	 * @param axis
	 * @return range
	 */
	public static Dataset iqr(final Dataset a, final int axis) {
		AbstractDataset aa = DatasetUtils.convertToAbstractDataset(a);
		Dataset q3 = getQStatistics(aa, axis, STORE_QUARTILE3 + "-" + axis);

		return Maths.subtract(q3, aa.getStoredValue(STORE_QUARTILE1 + "-" + axis));
	}

	static private Object getHigherStatistic(final AbstractDataset a, final boolean ignoreNaNs, String stat) {
		Object obj = a.getStoredValue(stat);
		if (obj == null) {
			calculateHigherMoments(a, ignoreNaNs);
			obj = a.getStoredValue(stat);
		}
	
		return obj;
	}

	static private DoubleDataset getHigherStatistic(final AbstractDataset a, final boolean ignoreNaNs, int axis, String stat) {
		axis = a.checkAxis(axis);
	
		DoubleDataset obj = (DoubleDataset) a.getStoredValue(stat);
		if (obj == null) {
			calculateHigherMoments(a, ignoreNaNs, axis);
			obj = (DoubleDataset) a.getStoredValue(stat);
		}
	
		return obj;
	}

	static private void calculateHigherMoments(final AbstractDataset a, final boolean ignoreNaNs) {
		final int is = a.getElementsPerItem();
		final IndexIterator iter = a.getIterator();

		if (is == 1) {
			Skewness s = new Skewness();
			Kurtosis k = new Kurtosis();
			if (ignoreNaNs) {
				while (iter.hasNext()) {
					final double x = a.getElementDoubleAbs(iter.index);
					if (Double.isNaN(x))
						continue;
					s.increment(x);
					k.increment(x);
				}
			} else {
				while (iter.hasNext()) {
					final double x = a.getElementDoubleAbs(iter.index);
					s.increment(x);
					k.increment(x);
				}
			}
			a.setStoredValue(AbstractDataset.storeName(ignoreNaNs, STORE_SKEWNESS), s.getResult());
			a.setStoredValue(AbstractDataset.storeName(ignoreNaNs, STORE_KURTOSIS), k.getResult());
		} else {
			final Skewness[] s = new Skewness[is];
			final Kurtosis[] k = new Kurtosis[is];

			for (int j = 0; j < is; j++) {
				s[j] = new Skewness();
				k[j] = new Kurtosis();
			}
			if (ignoreNaNs) {
				while (iter.hasNext()) {
					boolean skip = false;
					for (int j = 0; j < is; j++) {
						if (Double.isNaN(a.getElementDoubleAbs(iter.index + j))) {
							skip = true;
							break;
						}
					}
					if (!skip)
						for (int j = 0; j < is; j++) {
							final double val = a.getElementDoubleAbs(iter.index + j);
							s[j].increment(val);
							k[j].increment(val);
						}
				}
			} else {
				while (iter.hasNext()) {
					for (int j = 0; j < is; j++) {
						final double val = a.getElementDoubleAbs(iter.index + j);
						s[j].increment(val);
						k[j].increment(val);
					}
				}
			}
			final double[] ts = new double[is];
			final double[] tk = new double[is];
			for (int j = 0; j < is; j++) {
				ts[j] = s[j].getResult();
				tk[j] = k[j].getResult();
			}
			a.setStoredValue(AbstractDataset.storeName(ignoreNaNs, STORE_SKEWNESS), ts);
			a.setStoredValue(AbstractDataset.storeName(ignoreNaNs, STORE_KURTOSIS), tk);
		}
	}

	static private void calculateHigherMoments(final AbstractDataset a, final boolean ignoreNaNs, final int axis) {
		final int rank = a.getRank();
		final int is = a.getElementsPerItem();
		final int[] oshape = a.getShape();
		final int alen = oshape[axis];
		oshape[axis] = 1;
	
		final int[] nshape = AbstractDataset.squeezeShape(oshape, false);
		final Dataset sk;
		final Dataset ku;
	
	
		if (is == 1) {
			sk = new DoubleDataset(nshape);
			ku = new DoubleDataset(nshape);
			final IndexIterator qiter = sk.getIterator(true);
			final int[] qpos = qiter.getPos();
			final int[] spos = oshape;
	
			while (qiter.hasNext()) {
				int i = 0;
				for (; i < axis; i++) {
					spos[i] = qpos[i];
				}
				spos[i++] = 0;
				for (; i < rank; i++) {
					spos[i] = qpos[i - 1];
				}
	
				Skewness s = new Skewness();
				Kurtosis k = new Kurtosis();
				if (ignoreNaNs) {
					for (int j = 0; j < alen; j++) {
						spos[axis] = j;
						final double val = a.getDouble(spos);
						if (Double.isNaN(val))
							continue;
	
						s.increment(val);
						k.increment(val);
					}
				} else {
					for (int j = 0; j < alen; j++) {
						spos[axis] = j;
						final double val = a.getDouble(spos);
						s.increment(val);
						k.increment(val);
					}
				}
				sk.set(s.getResult(), spos);
				ku.set(k.getResult(), spos);
			}
		} else {
			sk = new CompoundDoubleDataset(is, nshape);
			ku = new CompoundDoubleDataset(is, nshape);
			final IndexIterator qiter = sk.getIterator(true);
			final int[] qpos = qiter.getPos();
			final int[] spos = oshape;
			final Skewness[] s = new Skewness[is];
			final Kurtosis[] k = new Kurtosis[is];
			final double[] ts = new double[is];
			final double[] tk = new double[is];
	
			for (int j = 0; j < is; j++) {
				s[j] = new Skewness();
				k[j] = new Kurtosis();
			}
			while (qiter.hasNext()) {
				int i = 0;
				for (; i < axis; i++) {
					spos[i] = qpos[i];
				}
				spos[i++] = 0;
				for (; i < rank; i++) {
					spos[i] = qpos[i-1];
				}
	
				for (int j = 0; j < is; j++) {
					s[j].clear();
					k[j].clear();
				}
				int index = a.get1DIndex(spos);
				if (ignoreNaNs) {
					boolean skip = false;
					for (int j = 0; j < is; j++) {
						if (Double.isNaN(a.getElementDoubleAbs(index + j))) {
							skip = true;
							break;
						}
					}
					if (!skip)
						for (int j = 0; j < is; j++) {
							final double val = a.getElementDoubleAbs(index + j);
							s[j].increment(val);
							k[j].increment(val);
						}
				} else {
					for (int j = 0; j < is; j++) {
						final double val = a.getElementDoubleAbs(index + j);
						s[j].increment(val);
						k[j].increment(val);
					}
				}
				for (int j = 0; j < is; j++) {
					ts[j] = s[j].getResult(); 
					tk[j] = k[j].getResult(); 
				}
				sk.set(ts, spos);
				ku.set(tk, spos);
			}
		}
	
		a.setStoredValue(AbstractDataset.storeName(ignoreNaNs, STORE_SKEWNESS + "-" + axis), sk);
		a.setStoredValue(AbstractDataset.storeName(ignoreNaNs, STORE_KURTOSIS + "-" + axis), ku);
	}

	/**
	 * See {@link #skewness(Dataset a, boolean ignoreNaNs)} with ignoreNaNs = false
	 * @param a dataset
	 * @return skewness
	 */
	public static Object skewness(final Dataset a) {
		return skewness(a, false);
	}

	/**
	 * @param a dataset
	 * @param ignoreNaNs if true, skip NaNs
	 * @return skewness
	 */
	public static Object skewness(final Dataset a, final boolean ignoreNaNs) {
		return getHigherStatistic(DatasetUtils.convertToAbstractDataset(a), ignoreNaNs, AbstractDataset.storeName(ignoreNaNs, STORE_SKEWNESS));
	}

	/**
	 * See {@link #kurtosis(Dataset a, boolean ignoreNaNs)} with ignoreNaNs = false
	 * @param a dataset
	 * @return kurtosis
	 */
	public static Object kurtosis(final Dataset a) {
		return kurtosis(a, false);
	}

	/**
	 * @param a dataset
	 * @param ignoreNaNs if true, skip NaNs
	 * @return kurtosis
	 */
	public static Object kurtosis(final Dataset a, final boolean ignoreNaNs) {
		return getHigherStatistic(DatasetUtils.convertToAbstractDataset(a), ignoreNaNs, AbstractDataset.storeName(ignoreNaNs, STORE_KURTOSIS));
	}

	/**
	 * See {@link #skewness(Dataset a, boolean ignoreNaNs, int axis)} with ignoreNaNs = false
	 * @param a dataset
	 * @param axis
	 * @return skewness
	 */
	public static Dataset skewness(final Dataset a, final int axis) {
		return skewness(a, false, axis);
	}

	/**
	 * @param a dataset
	 * @param ignoreNaNs if true, skip NaNs
	 * @param axis
	 * @return skewness
	 */
	public static Dataset skewness(final Dataset a, final boolean ignoreNaNs, final int axis) {
		return getHigherStatistic(DatasetUtils.convertToAbstractDataset(a), ignoreNaNs, axis, AbstractDataset.storeName(ignoreNaNs, STORE_SKEWNESS + "-" + axis));
	}

	/**
	 * See {@link #kurtosis(Dataset a, boolean ignoreNaNs, int axis)} with ignoreNaNs = false
	 * @param a dataset
	 * @param axis
	 * @return kurtosis
	 */
	public static Dataset kurtosis(final Dataset a, final int axis) {
		return kurtosis(a, false, axis);
	}

	/**
	 * @param a dataset
	 * @param ignoreNaNs if true, skip NaNs
	 * @param axis
	 * @return kurtosis
	 */
	public static Dataset kurtosis(final Dataset a, final boolean ignoreNaNs, final int axis) {
		return getHigherStatistic(DatasetUtils.convertToAbstractDataset(a), ignoreNaNs, axis, AbstractDataset.storeName(ignoreNaNs, STORE_KURTOSIS + "-" + axis));
	}

	/**
	 * See {@link #product(Dataset a, boolean ignoreNaNs)} with ignoreNaNs = false
	 * @param a
	 * @return product of all items in dataset
	 */
	public static Object product(final Dataset a) {
		return product(a, false);
	}

	/**
	 * @param a
	 * @param ignoreNaNs if true, skip NaNs
	 * @return product of all items in dataset
	 */
	public static Object product(final Dataset a, final boolean ignoreNaNs) {
		return typedProduct(a, a.getDtype(), ignoreNaNs);
	}

	/**
	 * See {@link #typedProduct(Dataset a, int dtype, boolean ignoreNaNs)} with ignoreNaNs = false
	 * @param a
	 * @param dtype
	 * @return product of all items in dataset
	 */
	public static Object typedProduct(final Dataset a, final int dtype) {
		return typedProduct(a, dtype, false);
	}

	/**
	 * @param a
	 * @param dtype
	 * @param ignoreNaNs if true, skip NaNs
	 * @return product of all items in dataset
	 */
	public static Object typedProduct(final Dataset a, final int dtype, final boolean ignoreNaNs) {

		if (a.isComplex()) {
			IndexIterator it = a.getIterator();
			double rv = 1, iv = 0;

			if (ignoreNaNs) {
				while (it.hasNext()) {
					final double r1 = a.getElementDoubleAbs(it.index);
					final double i1 = a.getElementDoubleAbs(it.index + 1);
					if (Double.isNaN(r1) || Double.isNaN(i1))
						continue;
					final double tv = r1*rv - i1*iv;
					iv = r1*iv + i1*rv;
					rv = tv;
				}
			} else {
				while (it.hasNext()) {
					final double r1 = a.getElementDoubleAbs(it.index);
					final double i1 = a.getElementDoubleAbs(it.index + 1);
					final double tv = r1*rv - i1*iv;
					iv = r1*iv + i1*rv;
					rv = tv;
				}
			}

			return new Complex(rv, iv);
		}

		IndexIterator it = a.getIterator();
		final int is;
		final long[] lresults;
		final double[] dresults;

		switch (dtype) {
		case Dataset.BOOL:
		case Dataset.INT8: case Dataset.INT16:
		case Dataset.INT32: case Dataset.INT64:
			long lresult = 1;
			while (it.hasNext()) {
				lresult *= a.getElementLongAbs(it.index);
			}
			return new Long(lresult);
		case Dataset.ARRAYINT8: case Dataset.ARRAYINT16:
		case Dataset.ARRAYINT32: case Dataset.ARRAYINT64:
			lresult = 1;
			is = a.getElementsPerItem();
			lresults = new long[is];
			for (int j = 0; j < is; j++) {
				lresults[j] = 1;
			}
			while (it.hasNext()) {
				for (int j = 0; j < is; j++)
					lresults[j] *= a.getElementLongAbs(it.index+j);
			}
			return lresults;
		case Dataset.FLOAT32: case Dataset.FLOAT64:
			double dresult = 1.;
			if (ignoreNaNs) {
				while (it.hasNext()) {
					final double x = a.getElementDoubleAbs(it.index);
					if (Double.isNaN(x))
						continue;
					dresult *= x;
				}
			} else {
				while (it.hasNext()) {
					dresult *= a.getElementDoubleAbs(it.index);
				}
			}
			return Double.valueOf(dresult);
		case Dataset.ARRAYFLOAT32:
		case Dataset.ARRAYFLOAT64:
			is = a.getElementsPerItem();
			dresults = new double[is];
			for (int j = 0; j < is; j++) {
				dresults[j] = 1.;
			}
			if (ignoreNaNs) {
				while (it.hasNext()) {
					boolean skip = false;
					for (int j = 0; j < is; j++) {
						if (Double.isNaN(a.getElementDoubleAbs(it.index + j))) {
							skip = true;
							break;
						}
					}
					if (!skip)
						for (int j = 0; j < is; j++) {
							dresults[j] *= a.getElementDoubleAbs(it.index + j);
						}
				}
			} else {
				while (it.hasNext()) {
					for (int j = 0; j < is; j++)
						dresults[j] *= a.getElementDoubleAbs(it.index + j);
				}
			}
			return dresults;
		}

		return null;
	}

	/**
	 * See {@link #product(Dataset a, boolean ignoreNaNs, int axis)} with ignoreNaNs = false
	 * @param a
	 * @param axis
	 * @return product of items along axis in dataset
	 */
	public static Dataset product(final Dataset a, final int axis) {
		return product(a, false, axis);
	}

	/**
	 * @param a
	 * @param ignoreNaNs if true, skip NaNs
	 * @param axis
	 * @return product of items along axis in dataset
	 */
	public static Dataset product(final Dataset a, final boolean ignoreNaNs, final int axis) {
		return typedProduct(a, a.getDtype(), ignoreNaNs, axis);
	}

	/**
	 * See {@link #typedProduct(Dataset a, int dtype, boolean ignoreNaNs, int axis)} with ignoreNaNs = false
	 * @param a
	 * @param dtype
	 * @param axis
	 * @return product of items along axis in dataset
	 */
	public static Dataset typedProduct(final Dataset a, final int dtype, final int axis) {
		return typedProduct(a, dtype, false, axis);
	}

	/**
	 * @param a
	 * @param dtype
	 * @param ignoreNaNs if true, skip NaNs
	 * @param axis
	 * @return product of items along axis in dataset
	 */
	public static Dataset typedProduct(final Dataset a, final int dtype, final boolean ignoreNaNs, int axis) {
		axis = a.checkAxis(axis);
		final int[] oshape = a.getShape();
		final int is = a.getElementsPerItem();
		final int alen = oshape[axis];
		oshape[axis] = 1;

		Dataset result = DatasetFactory.zeros(is, oshape, dtype);

		IndexIterator qiter = result.getIterator(true);
		int[] qpos = qiter.getPos();
		int[] spos;

		while (qiter.hasNext()) {
			spos = qpos.clone();

			if (a.isComplex()) {
				double rv = 1, iv = 0;
				switch (dtype) {
				case Dataset.COMPLEX64:
					ComplexFloatDataset af = (ComplexFloatDataset) a;
					if (ignoreNaNs) {
						for (int j = 0; j < alen; j++) {
							spos[axis] = j;
							final float r1 = af.getReal(spos);
							final float i1 = af.getImag(spos);
							if (Float.isNaN(r1) || Float.isNaN(i1))
								continue;
							final double tv = r1*rv - i1*iv;
							iv = r1*iv + i1*rv;
							rv = tv;
						}
					} else {
						for (int j = 0; j < alen; j++) {
							spos[axis] = j;
							final float r1 = af.getReal(spos);
							final float i1 = af.getImag(spos);
							final double tv = r1*rv - i1*iv;
							iv = r1*iv + i1*rv;
							rv = tv;
						}
					}
					break;
				case Dataset.COMPLEX128:
					ComplexDoubleDataset ad = (ComplexDoubleDataset) a;
					if (ignoreNaNs) {
						for (int j = 0; j < alen; j++) {
							spos[axis] = j;
							final double r1 = ad.getReal(spos);
							final double i1 = ad.getImag(spos);
							if (Double.isNaN(r1) || Double.isNaN(i1))
								continue;
							final double tv = r1*rv - i1*iv;
							iv = r1*iv + i1*rv;
							rv = tv;
						}
					} else {
						for (int j = 0; j < alen; j++) {
							spos[axis] = j;
							final double r1 = ad.getReal(spos);
							final double i1 = ad.getImag(spos);
							final double tv = r1*rv - i1*iv;
							iv = r1*iv + i1*rv;
							rv = tv;
						}
					}
					break;
				}

				result.set(new Complex(rv, iv), qpos);
			} else {
				final long[] lresults;
				final double[] dresults;

				switch (dtype) {
				case Dataset.BOOL:
				case Dataset.INT8: case Dataset.INT16:
				case Dataset.INT32: case Dataset.INT64:
					long lresult = 1;
					for (int j = 0; j < alen; j++) {
						spos[axis] = j;
						lresult *= a.getInt(spos);
					}
					result.set(lresult, qpos);
					break;
				case Dataset.ARRAYINT8:
					lresults = new long[is];
					for (int k = 0; k < is; k++) {
						lresults[k] = 1;
					}
					for (int j = 0; j < alen; j++) {
						spos[axis] = j;
						final byte[] va = (byte[]) a.getObject(spos);
						for (int k = 0; k < is; k++) {
							lresults[k] *= va[k];
						}
					}
					result.set(lresults, qpos);
					break;
				case Dataset.ARRAYINT16:
					lresults = new long[is];
					for (int k = 0; k < is; k++) {
						lresults[k] = 1;
					}
					for (int j = 0; j < alen; j++) {
						spos[axis] = j;
						final short[] va = (short[]) a.getObject(spos);
						for (int k = 0; k < is; k++) {
							lresults[k] *= va[k];
						}
					}
					result.set(lresults, qpos);
					break;
				case Dataset.ARRAYINT32:
					lresults = new long[is];
					for (int k = 0; k < is; k++) {
						lresults[k] = 1;
					}
					for (int j = 0; j < alen; j++) {
						spos[axis] = j;
						final int[] va = (int[]) a.getObject(spos);
						for (int k = 0; k < is; k++) {
							lresults[k] *= va[k];
						}
					}
					result.set(lresults, qpos);
					break;
				case Dataset.ARRAYINT64:
					lresults = new long[is];
					for (int k = 0; k < is; k++) {
						lresults[k] = 1;
					}
					for (int j = 0; j < alen; j++) {
						spos[axis] = j;
						final long[] va = (long[]) a.getObject(spos);
						for (int k = 0; k < is; k++) {
							lresults[k] *= va[k];
						}
					}
					result.set(lresults, qpos);
					break;
				case Dataset.FLOAT32: case Dataset.FLOAT64:
					double dresult = 1.;
					if (ignoreNaNs) {
						for (int j = 0; j < alen; j++) {
							spos[axis] = j;
							final double x = a.getDouble(spos); 
							if (Double.isNaN(x))
								continue;
							dresult *= x;
						}
					} else {
						for (int j = 0; j < alen; j++) {
							spos[axis] = j;
							dresult *= a.getDouble(spos);
						}
					}
					result.set(dresult, qpos);
					break;
				case Dataset.ARRAYFLOAT32:
					dresults = new double[is];
					for (int k = 0; k < is; k++) {
						dresults[k] = 1.;
					}
					if (ignoreNaNs) {
						for (int j = 0; j < alen; j++) {
							spos[axis] = j;
							final float[] va = (float[]) a.getObject(spos);
							boolean skip = false;
							for (int k = 0; k < is; k++) {
								if (Float.isNaN(va[k])) {
									skip = true;
									break;
								}
							}
							if (!skip)
								for (int k = 0; k < is; k++) {
									dresults[k] *= va[k];
								}
						}
					} else {
						for (int j = 0; j < alen; j++) {
							spos[axis] = j;
							final float[] va = (float[]) a.getObject(spos);
							for (int k = 0; k < is; k++) {
								dresults[k] *= va[k];
							}
						}
					}
					result.set(dresults, qpos);
					break;
				case Dataset.ARRAYFLOAT64:
					dresults = new double[is];
					for (int k = 0; k < is; k++) {
						dresults[k] = 1.;
					}
					if (ignoreNaNs) {
						for (int j = 0; j < alen; j++) {
							spos[axis] = j;
							final double[] va = (double[]) a.getObject(spos);
							boolean skip = false;
							for (int k = 0; k < is; k++) {
								if (Double.isNaN(va[k])) {
									skip = true;
									break;
								}
							}
							if (!skip)
								for (int k = 0; k < is; k++) {
									dresults[k] *= va[k];
								}
						}
					} else {
						for (int j = 0; j < alen; j++) {
							spos[axis] = j;
							final double[] va = (double[]) a.getObject(spos);
							for (int k = 0; k < is; k++) {
								dresults[k] *= va[k];
							}
						}
					}
					result.set(dresults, qpos);
					break;
				}
			}
		}

		result.setShape(AbstractDataset.squeezeShape(oshape, axis));
		return result;
	}

	/**
	 * See {@link #cumulativeProduct(Dataset a, boolean ignoreNaNs)} with ignoreNaNs = false
	 * @param a
	 * @return cumulative product of items in flattened dataset
	 */
	public static Dataset cumulativeProduct(final Dataset a) {
		return cumulativeProduct(a, false);
	}

	/**
	 * @param a
	 * @param ignoreNaNs if true, skip NaNs
	 * @return cumulative product of items along axis in dataset
	 */
	public static Dataset cumulativeProduct(final Dataset a, boolean ignoreNaNs) {
		return cumulativeProduct(a.flatten(), ignoreNaNs, 0);
	}

	/**
	 * See {@link #cumulativeProduct(Dataset a, boolean ignoreNaNs, int axis)} with ignoreNaNs = false
	 * @param a
	 * @param axis
	 * @return cumulative product of items along axis in dataset
	 */
	public static Dataset cumulativeProduct(final Dataset a, int axis) {
		return cumulativeProduct(a, false, axis);
	}

	/**
	 * @param a
	 * @param ignoreNaNs if true, skip NaNs
	 * @param axis
	 * @return cumulative product of items along axis in dataset
	 */
	public static Dataset cumulativeProduct(final Dataset a, boolean ignoreNaNs, int axis) {
		axis = a.checkAxis(axis);
		int dtype = a.getDtype();
		int[] oshape = a.getShape();
		int alen = oshape[axis];
		oshape[axis] = 1;

		Dataset result = DatasetFactory.zeros(a);
		PositionIterator pi = result.getPositionIterator(axis);

		int[] pos = pi.getPos();

		while (pi.hasNext()) {

			if (a.isComplex()) {
				double rv = 1, iv = 0;
				switch (dtype) {
				case Dataset.COMPLEX64:
					ComplexFloatDataset af = (ComplexFloatDataset) a;
					if (ignoreNaNs) {
						for (int j = 0; j < alen; j++) {
							pos[axis] = j;
							final float r1 = af.getReal(pos);
							final float i1 = af.getImag(pos);
							if (Float.isNaN(r1) || Float.isNaN(i1))
								continue;
							final double tv = r1*rv - i1*iv;
							iv = r1*iv + i1*rv;
							rv = tv;
							af.set((float) rv, (float) iv, pos);
						}
					} else {
						for (int j = 0; j < alen; j++) {
							pos[axis] = j;
							final float r1 = af.getReal(pos);
							final float i1 = af.getImag(pos);
							final double tv = r1*rv - i1*iv;
							iv = r1*iv + i1*rv;
							rv = tv;
							af.set((float) rv, (float) iv, pos);
						}
					}
					break;
				case Dataset.COMPLEX128:
					ComplexDoubleDataset ad = (ComplexDoubleDataset) a;
					if (ignoreNaNs) {
						for (int j = 0; j < alen; j++) {
							pos[axis] = j;
							final double r1 = ad.getReal(pos);
							final double i1 = ad.getImag(pos);
							if (Double.isNaN(r1) || Double.isNaN(i1))
								continue;
							final double tv = r1*rv - i1*iv;
							iv = r1*iv + i1*rv;
							rv = tv;
							ad.set(rv, iv, pos);
						}
					} else {
						for (int j = 0; j < alen; j++) {
							pos[axis] = j;
							final double r1 = ad.getReal(pos);
							final double i1 = ad.getImag(pos);
							final double tv = r1*rv - i1*iv;
							iv = r1*iv + i1*rv;
							rv = tv;
							ad.set(rv, iv, pos);
						}
					}
					break;
				}

				result.set(new Complex(rv, iv), pos);
			} else {
				final int is;
				final long[] lresults;
				final double[] dresults;

				switch (dtype) {
				case Dataset.BOOL:
				case Dataset.INT8: case Dataset.INT16:
				case Dataset.INT32: case Dataset.INT64:
					long lresult = 1;
					for (int j = 0; j < alen; j++) {
						pos[axis] = j;
						lresult *= a.getInt(pos);
						result.set(lresult, pos);
					}
					break;
				case Dataset.ARRAYINT8:
					is = a.getElementsPerItem();
					lresults = new long[is];
					for (int k = 0; k < is; k++) {
						lresults[k] = 1;
					}
					for (int j = 0; j < alen; j++) {
						pos[axis] = j;
						final byte[] va = (byte[]) a.getObject(pos);
						for (int k = 0; k < is; k++) {
							lresults[k] *= va[k];
						}
						result.set(lresults, pos);
					}
					break;
				case Dataset.ARRAYINT16:
					is = a.getElementsPerItem();
					lresults = new long[is];
					for (int k = 0; k < is; k++) {
						lresults[k] = 1;
					}
					for (int j = 0; j < alen; j++) {
						pos[axis] = j;
						final short[] va = (short[]) a.getObject(pos);
						for (int k = 0; k < is; k++) {
							lresults[k] *= va[k];
						}
						result.set(lresults, pos);
					}
					break;
				case Dataset.ARRAYINT32:
					is = a.getElementsPerItem();
					lresults = new long[is];
					for (int k = 0; k < is; k++) {
						lresults[k] = 1;
					}
					for (int j = 0; j < alen; j++) {
						pos[axis] = j;
						final int[] va = (int[]) a.getObject(pos);
						for (int k = 0; k < is; k++) {
							lresults[k] *= va[k];
						}
						result.set(lresults, pos);
					}
					break;
				case Dataset.ARRAYINT64:
					is = a.getElementsPerItem();
					lresults = new long[is];
					for (int k = 0; k < is; k++) {
						lresults[k] = 1;
					}
					for (int j = 0; j < alen; j++) {
						pos[axis] = j;
						final long[] va = (long[]) a.getObject(pos);
						for (int k = 0; k < is; k++) {
							lresults[k] *= va[k];
						}
						result.set(lresults, pos);
					}
					break;
				case Dataset.FLOAT32: case Dataset.FLOAT64:
					double dresult = 1.;
					if (ignoreNaNs) {
						for (int j = 0; j < alen; j++) {
							pos[axis] = j;
							final double x = a.getDouble(pos);
							if (Double.isNaN(x))
								continue;
							dresult *= x;
							result.set(dresult, pos);
						}
					} else {
						for (int j = 0; j < alen; j++) {
							pos[axis] = j;
							dresult *= a.getDouble(pos);
							result.set(dresult, pos);
						}
					}
					break;
				case Dataset.ARRAYFLOAT32:
					is = a.getElementsPerItem();
					dresults = new double[is];
					for (int k = 0; k < is; k++) {
						dresults[k] = 1.;
					}
					if (ignoreNaNs) {
						for (int j = 0; j < alen; j++) {
							pos[axis] = j;
							final float[] va = (float[]) a.getObject(pos);
							boolean skip = false;
							for (int k = 0; k < is; k++) {
								if (Float.isNaN(va[k])) {
									skip = true;
									break;
								}
							}
							if (!skip)
								for (int k = 0; k < is; k++) {
									dresults[k] *= va[k];
								}
							result.set(dresults, pos);
						}
					} else {
						for (int j = 0; j < alen; j++) {
							pos[axis] = j;
							final float[] va = (float[]) a.getObject(pos);
							for (int k = 0; k < is; k++) {
								dresults[k] *= va[k];
							}
							result.set(dresults, pos);
						}
					}
					break;
				case Dataset.ARRAYFLOAT64:
					is = a.getElementsPerItem();
					dresults = new double[is];
					for (int k = 0; k < is; k++) {
						dresults[k] = 1.;
					}
					if (ignoreNaNs) {
						for (int j = 0; j < alen; j++) {
							pos[axis] = j;
							final double[] va = (double[]) a.getObject(pos);
							boolean skip = false;
							for (int k = 0; k < is; k++) {
								if (Double.isNaN(va[k])) {
									skip = true;
									break;
								}
							}
							if (!skip)
								for (int k = 0; k < is; k++) {
									dresults[k] *= va[k];
								}
							result.set(dresults, pos);
						}
					} else {
						for (int j = 0; j < alen; j++) {
							pos[axis] = j;
							final double[] va = (double[]) a.getObject(pos);
							for (int k = 0; k < is; k++) {
								dresults[k] *= va[k];
							}
							result.set(dresults, pos);
						}
					}
					break;
				}
			}
		}

		return result;
	}

	/**
	 * See {@link #cumulativeSum(Dataset a, boolean ignoreNaNs)} with ignoreNaNs = false
	 * @param a
	 * @return cumulative sum of items in flattened dataset
	 */
	public static Dataset cumulativeSum(final Dataset a) {
		return cumulativeSum(a, false);
	}

	/**
	 * @param a
	 * @param ignoreNaNs if true, skip NaNs
	 * @return cumulative sum of items in flattened dataset
	 */
	public static Dataset cumulativeSum(final Dataset a, boolean ignoreNaNs) {
		return cumulativeSum(a.flatten(), ignoreNaNs, 0);
	}

	/**
	 * See {@link #cumulativeSum(Dataset a, boolean ignoreNaNs, int axis)} with ignoreNaNs = false
	 * @param a
	 * @param axis
	 * @return cumulative sum of items along axis in dataset
	 */
	public static Dataset cumulativeSum(final Dataset a, int axis) {
		return cumulativeSum(a, false, axis);
	}

	/**
	 * @param a
	 * @param ignoreNaNs if true, skip NaNs
	 * @param axis
	 * @return cumulative sum of items along axis in dataset
	 */
	public static Dataset cumulativeSum(final Dataset a, boolean ignoreNaNs, int axis) {
		axis = a.checkAxis(axis);
		int dtype = a.getDtype();
		int[] oshape = a.getShape();
		int alen = oshape[axis];
		oshape[axis] = 1;

		Dataset result = DatasetFactory.zeros(a);
		PositionIterator pi = result.getPositionIterator(axis);

		int[] pos = pi.getPos();

		while (pi.hasNext()) {

			if (a.isComplex()) {
				double rv = 0, iv = 0;
				switch (dtype) {
				case Dataset.COMPLEX64:
					ComplexFloatDataset af = (ComplexFloatDataset) a;
					if (ignoreNaNs) {
						for (int j = 0; j < alen; j++) {
							pos[axis] = j;
							final float x = af.getReal(pos);
							final float y = af.getImag(pos);
							if (Float.isNaN(x) || Float.isNaN(y))
								continue;
							rv += x;
							iv += y;
							af.set((float) rv, (float) iv, pos);
						}
					} else {
						for (int j = 0; j < alen; j++) {
							pos[axis] = j;
							rv += af.getReal(pos);
							iv += af.getImag(pos);
							af.set((float) rv, (float) iv, pos);
						}
					}
					break;
				case Dataset.COMPLEX128:
					ComplexDoubleDataset ad = (ComplexDoubleDataset) a;
					if (ignoreNaNs) {
						for (int j = 0; j < alen; j++) {
							pos[axis] = j;
							final double x = ad.getReal(pos);
							final double y = ad.getImag(pos);
							if (Double.isNaN(x) || Double.isNaN(y))
								continue;
							rv += x;
							iv += y;
							ad.set(rv, iv, pos);
						}
					} else {
						for (int j = 0; j < alen; j++) {
							pos[axis] = j;
							rv += ad.getReal(pos);
							iv += ad.getImag(pos);
							ad.set(rv, iv, pos);
						}
					}
					break;
				}

				result.set(new Complex(rv, iv), pos);
			} else {
				final int is;
				final long[] lresults;
				final double[] dresults;

				switch (dtype) {
				case Dataset.BOOL:
				case Dataset.INT8: case Dataset.INT16:
				case Dataset.INT32: case Dataset.INT64:
					long lresult = 0;
					for (int j = 0; j < alen; j++) {
						pos[axis] = j;
						lresult += a.getInt(pos);
						result.set(lresult, pos);
					}
					break;
				case Dataset.ARRAYINT8:
					is = a.getElementsPerItem();
					lresults = new long[is];
					for (int j = 0; j < alen; j++) {
						pos[axis] = j;
						final byte[] va = (byte[]) a.getObject(pos);
						for (int k = 0; k < is; k++) {
							lresults[k] += va[k];
						}
						result.set(lresults, pos);
					}
					break;
				case Dataset.ARRAYINT16:
					is = a.getElementsPerItem();
					lresults = new long[is];
					for (int j = 0; j < alen; j++) {
						pos[axis] = j;
						final short[] va = (short[]) a.getObject(pos);
						for (int k = 0; k < is; k++) {
							lresults[k] += va[k];
						}
						result.set(lresults, pos);
					}
					break;
				case Dataset.ARRAYINT32:
					is = a.getElementsPerItem();
					lresults = new long[is];
					for (int j = 0; j < alen; j++) {
						pos[axis] = j;
						final int[] va = (int[]) a.getObject(pos);
						for (int k = 0; k < is; k++) {
							lresults[k] += va[k];
						}
						result.set(lresults, pos);
					}
					break;
				case Dataset.ARRAYINT64:
					is = a.getElementsPerItem();
					lresults = new long[is];
					for (int j = 0; j < alen; j++) {
						pos[axis] = j;
						final long[] va = (long[]) a.getObject(pos);
						for (int k = 0; k < is; k++) {
							lresults[k] += va[k];
						}
						result.set(lresults, pos);
					}
					break;
				case Dataset.FLOAT32: case Dataset.FLOAT64:
					double dresult = 0.;
					if (ignoreNaNs) {
						for (int j = 0; j < alen; j++) {
							pos[axis] = j;
							final double x = a.getDouble(pos);
							if (Double.isNaN(x))
								continue;
							dresult += x;
							result.set(dresult, pos);
						}
					} else {
						for (int j = 0; j < alen; j++) {
							pos[axis] = j;
							dresult += a.getDouble(pos);
							result.set(dresult, pos);
						}
					}
					break;
				case Dataset.ARRAYFLOAT32:
					is = a.getElementsPerItem();
					dresults = new double[is];
					if (ignoreNaNs) {
						for (int j = 0; j < alen; j++) {
							pos[axis] = j;
							final float[] va = (float[]) a.getObject(pos);
							boolean skip = false;
							for (int k = 0; k < is; k++) {
								if (Float.isNaN(va[k])) {
									skip = true;
									break;
								}
							}
							if (!skip)
								for (int k = 0; k < is; k++) {
									dresults[k] += va[k];
								}
							result.set(dresults, pos);
						}
					} else {
						for (int j = 0; j < alen; j++) {
							pos[axis] = j;
							final float[] va = (float[]) a.getObject(pos);
							for (int k = 0; k < is; k++) {
								dresults[k] += va[k];
							}
							result.set(dresults, pos);
						}
					}
					break;
				case Dataset.ARRAYFLOAT64:
					is = a.getElementsPerItem();
					dresults = new double[is];
					if (ignoreNaNs) {
						for (int j = 0; j < alen; j++) {
							pos[axis] = j;
							final double[] va = (double[]) a.getObject(pos);
							boolean skip = false;
							for (int k = 0; k < is; k++) {
								if (Double.isNaN(va[k])) {
									skip = true;
									break;
								}
							}
							if (!skip)
								for (int k = 0; k < is; k++) {
									dresults[k] += va[k];
								}
							result.set(dresults, pos);
						}
					} else {
						for (int j = 0; j < alen; j++) {
							pos[axis] = j;
							final double[] va = (double[]) a.getObject(pos);
							for (int k = 0; k < is; k++) {
								dresults[k] += va[k];
							}
							result.set(dresults, pos);
						}
					}
					break;
				}
			}
		}

		return result;
	}

	/**
	 * @param a
	 * @return average deviation value of all items the dataset
	 */
	public static Object averageDeviation(final Dataset a) {
		final IndexIterator it = a.getIterator();
		final int is = a.getElementsPerItem();

		if (is == 1) {
			double mean = (Double) a.mean();
			double sum = 0.0;

			while (it.hasNext()) {
				sum += Math.abs(a.getElementDoubleAbs(it.index) - mean);
			}

			return sum / a.getSize();
		}

		double[] means = (double[]) a.mean();
		double[] sums = new double[is];

		while (it.hasNext()) {
			for (int j = 0; j < is; j++)
				sums[j] += Math.abs(a.getElementDoubleAbs(it.index + j) - means[j]);
		}

		double n = a.getSize();
		for (int j = 0; j < is; j++)
			sums[j] /= n;

		return sums;
	}

	/**
	 * The residual is the sum of squared differences
	 * @param a
	 * @param b
	 * @return residual value
	 */
	public static double residual(final Dataset a, final Dataset b) {
		return a.residual(b);
	}

	/**
	 * The residual is the sum of squared differences
	 * @param a
	 * @param b
	 * @param w
	 * @return residual value
	 */
	public static double weightedResidual(final Dataset a, final Dataset b, final Dataset w) {
		return a.residual(b, w, false);
	}

	/**
	 * Calculate approximate outlier values. These are defined as the values in the dataset
	 * that are approximately below and above the given thresholds - in terms of percentages
	 * of dataset size.
	 * <p>
	 * It approximates by limiting the number of items (given by length) used internally by
	 * data structures - the larger this is, the more accurate will those outlier values become.
	 * The actual thresholds used are returned in the array.
	 * <p>
	 * Also, the low and high values will be made distinct if possible by adjusting the thresholds
	 * @param a
	 * @param lo percentage threshold for lower limit
	 * @param hi percentage threshold for higher limit
	 * @param length maximum number of items used internally, if negative, then unlimited
	 * @return double array with low and high values, and low and high percentage thresholds
	 */
	public static double[] outlierValues(final Dataset a, double lo, double hi, final int length) {
		if (lo <= 0 || hi <= 0 || lo >= hi || hi >= 100  || Double.isNaN(lo)|| Double.isNaN(hi)) {
			throw new IllegalArgumentException("Thresholds must be between (0,100) and in order");
		}
		final int size = a.getSize();
		int nl = Math.max((int) ((lo*size)/100), 1);
		if (length > 0 && nl > length)
			nl = length;
		int nh = Math.max((int) (((100-hi)*size)/100), 1);
		if (length > 0 && nh > length)
			nh = length;

		double[] results = Math.max(nl, nh) > 640 ? outlierValuesMap(a, nl, nh) : outlierValuesList(a, nl, nh);

		results[2] = results[2]*100./size;
		results[3] = 100. - results[3]*100./size;
		return results;
	}

	public static double[] outlierValuesMap(final Dataset a, int nl, int nh) {
		final TreeMap<Double, Integer> lMap = new TreeMap<Double, Integer>();
		final TreeMap<Double, Integer> hMap = new TreeMap<Double, Integer>();

		int ml = 0;
		int mh = 0;
		IndexIterator it = a.getIterator();
		while (it.hasNext()) {
			Double x = a.getElementDoubleAbs(it.index);
			Integer i;
			if (ml == nl) {
				Double k = lMap.lastKey();
				if (x < k) {
					i = lMap.get(k) - 1;
					if (i == 0) {
						lMap.remove(k);
					} else {
						lMap.put(k, i);
					}
					i = lMap.get(x);
					if (i == null) {
						lMap.put(x, 1);
					} else {
						lMap.put(x, i + 1);
					}
				}
			} else {
				i = lMap.get(x);
				if (i == null) {
					lMap.put(x, 1);
				} else {
					lMap.put(x, i + 1);
				}
				ml++;
			}

			if (mh == nh) {
				Double k = hMap.firstKey();
				if (x > k) {
					i = hMap.get(k) - 1;
					if (i == 0) {
						hMap.remove(k);
					} else {
						hMap.put(k, i);
					}
					i = hMap.get(x);
					if (i == null) {
						hMap.put(x, 1);
					} else {
						hMap.put(x, i+1);
					}
				}
			} else {
				i = hMap.get(x);
				if (i == null) {
					hMap.put(x, 1);
				} else {
					hMap.put(x, i+1);
				}
				mh++;
			}
		}

		// Attempt to make values distinct
		double lx = lMap.lastKey();
		double hx = hMap.firstKey();
		if (lx >= hx) {
			Double h = hMap.higherKey(lx);
			if (h != null) {
				hx = h;
				mh--;
			} else {
				Double l = lMap.lowerKey(hx);
				if (l != null) {
					lx = l;
					ml--;
				}
			}
			
		}
		return new double[] {lMap.lastKey(), hMap.firstKey(), ml, mh};
	}

	public static double[] outlierValuesList(final Dataset a, int nl, int nh) {
		final List<Double> lList = new ArrayList<Double>(nl);
		final List<Double> hList = new ArrayList<Double>(nh);
//		final List<Double> lList = new LinkedList<Double>();
//		final List<Double> hList = new LinkedList<Double>();

		double lx = Double.POSITIVE_INFINITY;
		double hx = Double.NEGATIVE_INFINITY;

		IndexIterator it = a.getIterator();
		while (it.hasNext()) {
			double x = a.getElementDoubleAbs(it.index);
			if (x < lx) {
				if (lList.size() == nl) {
					lList.remove(lx);
				}
				lList.add(x);
				lx = Collections.max(lList);
			} else if (x == lx) {
				if (lList.size() < nl) {
					lList.add(x);
				}
			}

			if (x > hx) {
				if (hList.size() == nh) {
					hList.remove(hx);
				}
				hList.add(x);
				hx = Collections.min(hList);
			} else if (x == hx) {
				if (hList.size() < nh) {
					hList.add(x);
				}
			}
		}

		nl = lList.size();
		nh = hList.size();

		// Attempt to make values distinct
		if (lx >= hx) {
			Collections.sort(hList);
			for (double h : hList) {
				if (h > hx) {
					hx = h;
					break;
				}
				nh--;
			}
			if (lx >= hx) {
				Collections.sort(lList);
				Collections.reverse(lList);
				for (double l : lList) {
					if (l < lx) {
						lx = l;
						break;
					}
					nl--;
				}
			}
		}
		return new double[] {lx, hx, nl, nh};
	}	
}
