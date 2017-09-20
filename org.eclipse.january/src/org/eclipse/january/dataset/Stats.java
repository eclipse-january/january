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

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.stat.descriptive.moment.Kurtosis;
import org.apache.commons.math3.stat.descriptive.moment.Skewness;
import org.eclipse.january.metadata.Dirtiable;
import org.eclipse.january.metadata.MetadataType;


/**
 * Statistics class
 * 
 * TODO Where is mode? http://en.wikipedia.org/wiki/Mode_(statistics)
 * 
 */
public class Stats {

	private static class ReferencedDataset extends SoftReference<Dataset> {
		public ReferencedDataset(Dataset d) {
			super(d);
		}
	}

	private static class QStatisticsImpl<T> implements MetadataType {
		private static final long serialVersionUID = -3296671666463190388L;
		final static Double Q1 = 0.25;
		final static Double Q2 = 0.5;
		final static Double Q3 = 0.75;
		Map<Double, T> qmap = new HashMap<Double, T>();
		transient Map<Integer, Map<Double, ReferencedDataset>> aqmap = new HashMap<Integer, Map<Double, ReferencedDataset>>();
		transient ReferencedDataset s; // store 0th element
		transient Map<Integer, ReferencedDataset> smap = new HashMap<>();

		@Dirtiable
		private boolean isDirty = true;

		@Override
		public QStatisticsImpl<T> clone() {
			return new QStatisticsImpl<T>(this);
		}

		public QStatisticsImpl() {
		}

		private QStatisticsImpl(QStatisticsImpl<T> qstats) {
			if (qstats.s != null && qstats.s.get() != null) {
				s = new ReferencedDataset(qstats.s.get().getView(false));
			}
			qmap.putAll(qstats.qmap);
			for (Integer i : qstats.aqmap.keySet()) {
				aqmap.put(i, new HashMap<>(qstats.aqmap.get(i)));
			}
			smap.putAll(qstats.smap);
			isDirty = qstats.isDirty;
		}

		public void setQuantile(double q, T v) {
			qmap.put(q, v);
		}

		public T getQuantile(double q) {
			return qmap.get(q);
		}

		private Map<Double, ReferencedDataset> getMap(int axis) {
			Map<Double, ReferencedDataset> qm = aqmap.get(axis);
			if (qm == null) {
				qm = new HashMap<>();
				aqmap.put(axis, qm);
			}
			return qm;
		}

		public void setQuantile(int axis, double q, Dataset v) {
			Map<Double, ReferencedDataset> qm = getMap(axis);
			qm.put(q, new ReferencedDataset(v));
		}

		public Dataset getQuantile(int axis, double q) {
			Map<Double, ReferencedDataset> qm = getMap(axis);
			ReferencedDataset rd = qm.get(q);
			return rd == null ? null : rd.get();
		}

		Dataset getSortedDataset(int axis) {
			return smap.containsKey(axis) ? smap.get(axis).get() : null;
		}

		void setSortedDataset(int axis, Dataset v) {
			smap.put(axis, new ReferencedDataset(v));
		}
	}

	// calculates statistics and returns sorted dataset (0th element if compound)
	private static QStatisticsImpl<?> calcQuartileStats(final Dataset a) {
		Dataset s = null;
		final int is = a.getElementsPerItem();

		if (is == 1) {
			s = DatasetUtils.sort(a);

			QStatisticsImpl<Double> qstats = new QStatisticsImpl<Double>();

			qstats.setQuantile(QStatisticsImpl.Q1, pQuantile(s, QStatisticsImpl.Q1));
			qstats.setQuantile(QStatisticsImpl.Q2, pQuantile(s, QStatisticsImpl.Q2));
			qstats.setQuantile(QStatisticsImpl.Q3, pQuantile(s, QStatisticsImpl.Q3));
			qstats.s = new ReferencedDataset(s);
			return qstats;
		}

		QStatisticsImpl<double[]> qstats = new QStatisticsImpl<double[]>();

		Dataset w = DatasetFactory.zeros(1, a.getClass(), a.getShapeRef());
		double[] q1 = new double[is];
		double[] q2 = new double[is];
		double[] q3 = new double[is];
		qstats.setQuantile(QStatisticsImpl.Q1, q1);
		qstats.setQuantile(QStatisticsImpl.Q2, q2);
		qstats.setQuantile(QStatisticsImpl.Q3, q3);
		for (int j = 0; j < is; j++) {
			((CompoundDataset) a).copyElements(w, j);
			w.sort(null);

			q1[j] = pQuantile(w, QStatisticsImpl.Q1);
			q2[j] = pQuantile(w, QStatisticsImpl.Q2);
			q3[j] = pQuantile(w, QStatisticsImpl.Q3);
			if (j == 0)
				s = w.clone();
		}
		qstats.s = new ReferencedDataset(s);

		return qstats;
	}

	static private QStatisticsImpl<?> getQStatistics(final Dataset a) {
		QStatisticsImpl<?> m = a.getFirstMetadata(QStatisticsImpl.class);
		if (m == null || m.isDirty) {
			m = calcQuartileStats(a);
			a.setMetadata(m);
		}
		return m;
	}

	static private QStatisticsImpl<?> getQStatistics(final Dataset a, final int axis) {
		final int is = a.getElementsPerItem();
		QStatisticsImpl<?> qstats = a.getFirstMetadata(QStatisticsImpl.class);

		if (qstats == null || qstats.isDirty) {
			if (is == 1) {
				qstats = new QStatisticsImpl<Double>();
			} else {
				qstats = new QStatisticsImpl<double[]>();
			}
			a.setMetadata(qstats);
		}

		if (qstats.getQuantile(axis, QStatisticsImpl.Q2) == null) {
			if (is == 1) {
				Dataset s = DatasetUtils.sort(a, axis);

				qstats.setQuantile(axis, QStatisticsImpl.Q1, pQuantile(s, axis, QStatisticsImpl.Q1));
				qstats.setQuantile(axis, QStatisticsImpl.Q2, pQuantile(s, axis, QStatisticsImpl.Q2));
				qstats.setQuantile(axis, QStatisticsImpl.Q3, pQuantile(s, axis, QStatisticsImpl.Q3));
				qstats.setSortedDataset(axis, s);
			} else {
				Dataset w = DatasetFactory.zeros(1, a.getClass(), a.getShapeRef());
				CompoundDoubleDataset q1 = null, q2 = null, q3 = null;
				for (int j = 0; j < is; j++) {
					((CompoundDataset) a).copyElements(w, j);
					w.sort(axis);
	
					final Dataset c = pQuantile(w, axis, QStatisticsImpl.Q1);
					if (j == 0) {
						q1 = DatasetFactory.zeros(is, CompoundDoubleDataset.class, c.getShapeRef());
						q2 = DatasetFactory.zeros(is, CompoundDoubleDataset.class, c.getShapeRef());
						q3 = DatasetFactory.zeros(is, CompoundDoubleDataset.class, c.getShapeRef());
					}
					q1.setElements(c, j);
	
					q2.setElements(pQuantile(w, axis, QStatisticsImpl.Q2), j);
	
					q3.setElements(pQuantile(w, axis, QStatisticsImpl.Q3), j);
				}
				qstats.setQuantile(axis, QStatisticsImpl.Q1, q1);
				qstats.setQuantile(axis, QStatisticsImpl.Q2, q2);
				qstats.setQuantile(axis, QStatisticsImpl.Q3, q3);
			}
		}

		return qstats;
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
		int[] qshape = ShapeUtils.squeezeShape(oshape, false);
		Dataset qds = DatasetFactory.zeros(is, CompoundDoubleDataset.class, qshape);

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
			Dataset rds = DatasetFactory.zeros(is, CompoundDoubleDataset.class, qshape);
			
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
	@SuppressWarnings("unchecked")
	public static double quantile(final Dataset a, final double q) {
		if (q < 0 || q > 1) {
			throw new IllegalArgumentException("Quantile requested is outside [0,1]");
		}
		QStatisticsImpl<Double> qs = (QStatisticsImpl<Double>) getQStatistics(a);
		Double qv = qs.getQuantile(q);
		if (qv == null) {
			qv = pQuantile(qs.s.get(), q);
			qs.setQuantile(q, qv);
		}
		return qv;
	}

	/**
	 * Calculate quantiles of dataset which is defined as the inverse of the cumulative distribution function (CDF)
	 * @param a
	 * @param values
	 * @return points at which CDF has given values
	 */
	@SuppressWarnings("unchecked")
	public static double[] quantile(final Dataset a, final double... values) {
		final double[] points  = new double[values.length];
		QStatisticsImpl<Double> qs = (QStatisticsImpl<Double>) getQStatistics(a);
		for (int i = 0; i < points.length; i++) {
			final double q = values[i];
			if (q < 0 || q > 1) {
				throw new IllegalArgumentException("Quantile requested is outside [0,1]");
			}
			Double qv = qs.getQuantile(q);
			if (qv == null) {
				qv = pQuantile(qs.s.get(), q);
				qs.setQuantile(q, qv);
			}
			points[i] = qv;
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
	@SuppressWarnings({ "unchecked" })
	public static Dataset[] quantile(final Dataset a, int axis, final double... values) {
		final Dataset[] points  = new Dataset[values.length];
		final int is = a.getElementsPerItem();
		axis = a.checkAxis(axis);

		if (is == 1) {
			QStatisticsImpl<Double> qs = (QStatisticsImpl<Double>) getQStatistics(a, axis);
			for (int i = 0; i < points.length; i++) {
				final double q = values[i];
				if (q < 0 || q > 1) {
					throw new IllegalArgumentException("Quantile requested is outside [0,1]");
				}
				Dataset qv = qs.getQuantile(axis, q);
				if (qv == null) {
					qv = pQuantile(qs.getSortedDataset(axis), axis, q);
					qs.setQuantile(axis, q, qv);
				}
				points[i] = qv;
			}
		} else {
			QStatisticsImpl<double[]> qs = (QStatisticsImpl<double[]>) getQStatistics(a);
			Dataset w = DatasetFactory.zeros(1, a.getClass(), a.getShapeRef());
			for (int j = 0; j < is; j++) {
				boolean copied = false;

				for (int i = 0; i < points.length; i++) {
					final double q = values[i];
					if (q < 0 || q > 1) {
						throw new IllegalArgumentException("Quantile requested is outside [0,1]");
					}
					Dataset qv = qs.getQuantile(axis, q);
					if (qv == null) {
						if (!copied) {
							copied = true;
							((CompoundDataset) a).copyElements(w, j);
							w.sort(axis);
						}
						qv = pQuantile(w, axis, q);
						qs.setQuantile(axis, q, qv);
						if (j == 0) {
							points[i] = DatasetFactory.zeros(is, qv.getClass(), qv.getShapeRef());
						}
						((CompoundDoubleDataset) points[i]).setElements(qv, j);
					}
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
	public static Dataset median(final Dataset a, int axis) {
		axis = a.checkAxis(axis);
		return getQStatistics(a, axis).getQuantile(axis, QStatisticsImpl.Q2);
	}

	/**
	 * @param a dataset
	 * @return median
	 */
	public static Object median(final Dataset a) {
		return getQStatistics(a).getQuantile(QStatisticsImpl.Q2);
	}

	/**
	 * Interquartile range: Q3 - Q1
	 * @param a
	 * @return range
	 */
	@SuppressWarnings("unchecked")
	public static Object iqr(final Dataset a) {
		final int is = a.getElementsPerItem();
		if (is == 1) {
			QStatisticsImpl<Double> qs = (QStatisticsImpl<Double>) getQStatistics(a);
			return qs.getQuantile(QStatisticsImpl.Q3) - qs.getQuantile(QStatisticsImpl.Q1);
		}

		QStatisticsImpl<double[]> qs = (QStatisticsImpl<double[]>) getQStatistics(a);
		double[] q1 = (double[]) qs.getQuantile(QStatisticsImpl.Q1);
		double[] q3 = ((double[]) qs.getQuantile(QStatisticsImpl.Q3)).clone();
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
	public static Dataset iqr(final Dataset a, int axis) {
		axis = a.checkAxis(axis);
		QStatisticsImpl<?> qs = getQStatistics(a, axis);
		Dataset q3 = qs.getQuantile(axis, QStatisticsImpl.Q3);

		return Maths.subtract(q3, qs.getQuantile(axis, QStatisticsImpl.Q1));
	}

	static private HigherStatisticsImpl<?> getHigherStatistic(final Dataset a, boolean[] ignoreInvalids) {
		boolean ignoreNaNs = false;
		boolean ignoreInfs = false;
		if (a.hasFloatingPointElements()) {
			ignoreNaNs = ignoreInvalids != null && ignoreInvalids.length > 0 ? ignoreInvalids[0] : false;
			ignoreInfs = ignoreInvalids != null && ignoreInvalids.length > 1 ? ignoreInvalids[1] : ignoreNaNs;
		}

		HigherStatisticsImpl<?> stats = a.getFirstMetadata(HigherStatisticsImpl.class);
		if (stats == null || stats.isDirty) {
			stats = calculateHigherMoments(a, ignoreNaNs, ignoreInfs);
			a.setMetadata(stats);
		}
	
		return stats;
	}

	static private HigherStatisticsImpl<?> getHigherStatistic(final Dataset a, final boolean[] ignoreInvalids, final int axis) {
		boolean ignoreNaNs = false;
		boolean ignoreInfs = false;
		if (a.hasFloatingPointElements()) {
			ignoreNaNs = ignoreInvalids != null && ignoreInvalids.length > 0 ? ignoreInvalids[0] : false;
			ignoreInfs = ignoreInvalids != null && ignoreInvalids.length > 1 ? ignoreInvalids[1] : ignoreNaNs;
		}
	
		HigherStatisticsImpl<?> stats = a.getFirstMetadata(HigherStatisticsImpl.class);
		if (stats == null || stats.getSkewness(axis) == null || stats.isDirty) {
			stats = calculateHigherMoments(a, ignoreNaNs, ignoreInfs, axis);
			a.setMetadata(stats);
		}
	
		return stats;
	}

	private static class HigherStatisticsImpl<T> implements MetadataType {
		private static final long serialVersionUID = -6587974784104116792L;
		T skewness;
		T kurtosis;
		transient Map<Integer, ReferencedDataset> smap = new HashMap<>();
		transient Map<Integer, ReferencedDataset> kmap = new HashMap<>();

		@Dirtiable
		private boolean isDirty = true;

		@Override
		public HigherStatisticsImpl<T> clone() {
			return new HigherStatisticsImpl<>(this);
		}

		public HigherStatisticsImpl() {
		}

		private HigherStatisticsImpl(HigherStatisticsImpl<T> hstats) {
			skewness = hstats.skewness;
			kurtosis = hstats.kurtosis;
			smap.putAll(hstats.smap);
			kmap.putAll(hstats.kmap);
			isDirty = hstats.isDirty;
		}

//		public void setSkewness(T skewness) {
//			this.skewness = skewness;
//		}
//
//		public void setKurtosis(T kurtosis) {
//			this.kurtosis = kurtosis;
//		}
//
//		public T getSkewness() {
//			return skewness;
//		}
//
//		public T getKurtosis() {
//			return kurtosis;
//		}

		public Dataset getSkewness(int axis) {
			ReferencedDataset rd = smap.get(axis);
			return rd == null ? null : rd.get();
		}

		public Dataset getKurtosis(int axis) {
			ReferencedDataset rd = kmap.get(axis);
			return rd == null ? null : rd.get();
		}

		public void setSkewness(int axis, Dataset s) {
			smap.put(axis, new ReferencedDataset(s));
		}

		public void setKurtosis(int axis, Dataset k) {
			kmap.put(axis, new ReferencedDataset(k));
		}
	}

	static private HigherStatisticsImpl<?> calculateHigherMoments(final Dataset a, final boolean ignoreNaNs, final boolean ignoreInfs) {
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

			HigherStatisticsImpl<Double> stats = new HigherStatisticsImpl<Double>();
			stats.skewness = s.getResult();
			stats.kurtosis = k.getResult();
			return stats;
		}
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

		HigherStatisticsImpl<double[]> stats = new HigherStatisticsImpl<double[]>();
		stats.skewness = ts;
		stats.kurtosis = tk;
		return stats;
	}

	static private HigherStatisticsImpl<?> calculateHigherMoments(final Dataset a, final boolean ignoreNaNs, final boolean ignoreInfs, final int axis) {
		final int rank = a.getRank();
		final int is = a.getElementsPerItem();
		final int[] oshape = a.getShape();
		final int alen = oshape[axis];
		oshape[axis] = 1;
	
		final int[] nshape = ShapeUtils.squeezeShape(oshape, false);
		final Dataset sk;
		final Dataset ku;
		HigherStatisticsImpl<?> stats = null;
	
		if (is == 1) {
			if (stats == null) {
				stats = new HigherStatisticsImpl<Double>();
				a.setMetadata(stats);
			}
			sk = DatasetFactory.zeros(DoubleDataset.class, nshape);
			ku = DatasetFactory.zeros(DoubleDataset.class, nshape);
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
				sk.set(s.getResult(), qpos);
				ku.set(k.getResult(), qpos);
			}
		} else {
			if (stats == null) {
				stats = new HigherStatisticsImpl<double[]>();
				a.setMetadata(stats);
			}
			sk = DatasetFactory.zeros(is, CompoundDoubleDataset.class, nshape);
			ku = DatasetFactory.zeros(is, CompoundDoubleDataset.class, nshape);
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
				sk.set(ts, qpos);
				ku.set(tk, qpos);
			}
		}

		stats.setSkewness(axis, sk);
		stats.setKurtosis(axis, ku);
		return stats;
	}

	/**
	 * @param a dataset
	 * @param ignoreInvalids see {@link IDataset#max(boolean...)}
	 * @return skewness
	 * @since 2.0
	 */
	public static Object skewness(final Dataset a, final boolean... ignoreInvalids) {
		return getHigherStatistic(a, ignoreInvalids).skewness;
	}

	/**
	 * @param a dataset
	 * @param ignoreInvalids see {@link IDataset#max(boolean...)}
	 * @return kurtosis
	 * @since 2.0
	 */
	public static Object kurtosis(final Dataset a, final boolean... ignoreInvalids) {
		return getHigherStatistic(a, ignoreInvalids).kurtosis;
	}

	/**
	 * @param a dataset
	 * @param axis
	 * @param ignoreInvalids see {@link Dataset#max(int, boolean...)}
	 * @return skewness along axis in dataset
	 * @since 2.0
	 */
	public static Dataset skewness(final Dataset a, int axis, final boolean... ignoreInvalids) {
		axis = a.checkAxis(axis);
		return getHigherStatistic(a, ignoreInvalids, axis).getSkewness(axis);
	}

	/**
	 * @param a dataset
	 * @param axis
	 * @param ignoreInvalids see {@link Dataset#max(int, boolean...)}
	 * @return kurtosis along axis in dataset
	 * @since 2.0
	 */
	public static Dataset kurtosis(final Dataset a, int axis, final boolean... ignoreInvalids) {
		axis = a.checkAxis(axis);
		return getHigherStatistic(a, ignoreInvalids, axis).getKurtosis(axis);
	}

	/**
	 * @param a dataset
	 * @param ignoreInvalids see {@link IDataset#max(boolean...)}
	 * @return sum of dataset
	 * @since 2.0
	 */
	public static Object sum(final Dataset a, final boolean... ignoreInvalids) {
		return a.sum(ignoreInvalids);
	}

	/**
	 * @param a dataset
	 * @param dtype
	 * @param ignoreInvalids see {@link IDataset#max(boolean...)}
	 * @return typed sum of dataset
	 * @since 2.0
	 */
	public static Object typedSum(final Dataset a, int dtype, final boolean... ignoreInvalids) {
		if (a.isComplex()) {
			Complex m = (Complex) a.sum(ignoreInvalids);
			return m;
		} else if (a instanceof CompoundDataset) {
			return  DTypeUtils.fromDoublesToBiggestPrimitives((double[]) a.sum(ignoreInvalids), dtype);
		}
		return DTypeUtils.fromDoubleToBiggestNumber(DTypeUtils.toReal(a.sum(ignoreInvalids)), dtype);
	}

	/**
	 * @param a dataset
	 * @param dtype
	 * @param axis
	 * @param ignoreInvalids see {@link Dataset#max(int, boolean...)}
	 * @return typed sum of items along axis in dataset
	 * @since 2.0
	 */
	public static Dataset typedSum(final Dataset a, int dtype, int axis, final boolean... ignoreInvalids) {
		return DatasetUtils.cast(a.sum(axis, ignoreInvalids), dtype);
	}

	/**
	 * @param a dataset
	 * @param ignoreInvalids see {@link IDataset#max(boolean...)}
	 * @return product of all items in dataset
	 * @since 2.0
	 */
	public static Object product(final Dataset a, final boolean... ignoreInvalids) {
		return typedProduct(a, a.getDType(), ignoreInvalids);
	}

	/**
	 * @param a dataset
	 * @param axis
	 * @param ignoreInvalids see {@link Dataset#max(int, boolean...)}
	 * @return product of items along axis in dataset
	 * @since 2.0
	 */
	public static Dataset product(final Dataset a, final int axis, final boolean... ignoreInvalids) {
		return typedProduct(a, a.getDType(), axis, ignoreInvalids);
	}

	/**
	 * @param a dataset
	 * @param dtype
	 * @param ignoreInvalids see {@link IDataset#max(boolean...)}
	 * @return typed product of all items in dataset
	 * @since 2.0
	 */
	public static Object typedProduct(final Dataset a, final int dtype, final boolean... ignoreInvalids) {
		final boolean ignoreNaNs;
		final boolean ignoreInfs;
		if (a.hasFloatingPointElements()) {
			ignoreNaNs = ignoreInvalids != null && ignoreInvalids.length > 0 ? ignoreInvalids[0] : false;
			ignoreInfs = ignoreInvalids != null && ignoreInvalids.length > 1 ? ignoreInvalids[1] : ignoreNaNs;
		} else {
			ignoreNaNs = false;
			ignoreInfs = false;
		}

		if (a.isComplex()) {
			IndexIterator it = a.getIterator();
			double rv = 1, iv = 0;

			while (it.hasNext()) {
				final double r1 = a.getElementDoubleAbs(it.index);
				final double i1 = a.getElementDoubleAbs(it.index + 1);
				if (ignoreNaNs && (Double.isNaN(r1) || Double.isNaN(i1))) {
					continue;
				}
				if (ignoreInfs  && (Double.isInfinite(r1) || Double.isInfinite(i1))) {
					continue;
				}
				final double tv = r1*rv - i1*iv;
				iv = r1*iv + i1*rv;
				rv = tv;
				if (Double.isNaN(rv) && Double.isNaN(iv)) {
					break;
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
			while (it.hasNext()) {
				final double x = a.getElementDoubleAbs(it.index);
				if (ignoreNaNs && Double.isNaN(x)) {
					continue;
				}
				if (ignoreInfs && Double.isInfinite(x)) {
					continue;
				}
				dresult *= x;
				if (Double.isNaN(dresult)) {
					break;
				}
			}
			return Double.valueOf(dresult);
		case Dataset.ARRAYFLOAT32:
		case Dataset.ARRAYFLOAT64:
			is = a.getElementsPerItem();
			double[] vals = new double[is];
			dresults = new double[is];
			for (int j = 0; j < is; j++) {
				dresults[j] = 1.;
			}
			while (it.hasNext()) {
				boolean okay = true;
				for (int j = 0; j < is; j++) {
					final double val = a.getElementDoubleAbs(it.index + j);
					if (ignoreNaNs && Double.isNaN(val)) {
						okay = false;
						break;
					}
					if (ignoreInfs && Double.isInfinite(val)) {
						okay = false;
						break;
					}
					vals[j] = val;
				}
				if (okay) {
					for (int j = 0; j < is; j++) {
						double val = vals[j];
						dresults[j] *= val;
					}
				}
			}
			return dresults;
		}

		return null;
	}

	/**
	 * @param a dataset
	 * @param dtype
	 * @param axis
	 * @param ignoreInvalids see {@link IDataset#max(boolean...)}
	 * @return typed product of items along axis in dataset
	 * @since 2.0
	 */
	public static Dataset typedProduct(final Dataset a, final int dtype, int axis, final boolean... ignoreInvalids) {
		axis = a.checkAxis(axis);
		final int[] oshape = a.getShape();
		final int is = a.getElementsPerItem();
		final int alen = oshape[axis];
		oshape[axis] = 1;

		final boolean ignoreNaNs;
		final boolean ignoreInfs;
		if (a.hasFloatingPointElements()) {
			ignoreNaNs = ignoreInvalids != null && ignoreInvalids.length > 0 ? ignoreInvalids[0] : false;
			ignoreInfs = ignoreInvalids != null && ignoreInvalids.length > 1 ? ignoreInvalids[1] : ignoreNaNs;
		} else {
			ignoreNaNs = false;
			ignoreInfs = false;
		}
		@SuppressWarnings("deprecation")
		Dataset result = DatasetFactory.zeros(is, oshape, dtype);

		IndexIterator qiter = result.getIterator(true);
		int[] qpos = qiter.getPos();
		int[] spos;

		// TODO add getLongArray(long[], int...) to CompoundDataset
		while (qiter.hasNext()) {
			spos = qpos.clone();

			if (a.isComplex()) {
				double rv = 1, iv = 0;
				switch (dtype) {
				case Dataset.COMPLEX64:
					ComplexFloatDataset af = (ComplexFloatDataset) a;
					for (int j = 0; j < alen; j++) {
						spos[axis] = j;
						final float r1 = af.getReal(spos);
						final float i1 = af.getImag(spos);
						if (ignoreNaNs && (Float.isNaN(r1) || Float.isNaN(i1))) {
							continue;
						}
						if (ignoreInfs  && (Float.isInfinite(r1) || Float.isInfinite(i1))) {
							continue;
						}
						final double tv = r1*rv - i1*iv;
						iv = r1*iv + i1*rv;
						rv = tv;
						if (Double.isNaN(rv) && Double.isNaN(iv)) {
							break;
						}
					}
					break;
				case Dataset.COMPLEX128:
					ComplexDoubleDataset ad = (ComplexDoubleDataset) a;
					for (int j = 0; j < alen; j++) {
						spos[axis] = j;
						final double r1 = ad.getReal(spos);
						final double i1 = ad.getImag(spos);
						if (ignoreNaNs && (Double.isNaN(r1) || Double.isNaN(i1))) {
							continue;
						}
						if (ignoreInfs  && (Double.isInfinite(r1) || Double.isInfinite(i1))) {
							continue;
						}
						final double tv = r1*rv - i1*iv;
						iv = r1*iv + i1*rv;
						rv = tv;
						if (Double.isNaN(rv) && Double.isNaN(iv)) {
							break;
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
					for (int j = 0; j < alen; j++) {
						spos[axis] = j;
						final double x = a.getDouble(spos); 
						if (ignoreNaNs && Double.isNaN(x)) {
							continue;
						}
						if (ignoreInfs && Double.isInfinite(x)) {
							continue;
						}
						dresult *= x;
						if (Double.isNaN(dresult)) {
							break;
						}
					}
					result.set(dresult, qpos);
					break;
				case Dataset.ARRAYFLOAT32: case Dataset.ARRAYFLOAT64:
					CompoundDataset da = (CompoundDataset) a;
					double[] dvalues = new double[is];
					dresults = new double[is];
					for (int k = 0; k < is; k++) {
						dresults[k] = 1.;
					}
					for (int j = 0; j < alen; j++) {
						spos[axis] = j;
						da.getDoubleArray(dvalues, spos);
						boolean okay = true;
						for (int k = 0; k < is; k++) {
							final double val = dvalues[k];
							if (ignoreNaNs && Double.isNaN(val)) {
								okay = false;
								break;
							}
							if (ignoreInfs && Double.isInfinite(val)) {
								okay = false;
								break;
							}
						}
						if (okay) {
							for (int k = 0; k < is; k++) {
								dresults[k] *= dvalues[k];
							}
						}
					}
					result.set(dresults, qpos);
					break;
				}
			}
		}

		result.setShape(ShapeUtils.squeezeShape(oshape, axis));
		return result;
	}

	/**
	 * @param a dataset
	 * @param ignoreInvalids see {@link IDataset#max(boolean...)}
	 * @return cumulative product of items in flattened dataset
	 * @since 2.0
	 */
	public static Dataset cumulativeProduct(final Dataset a, final boolean... ignoreInvalids) {
		return cumulativeProduct(a.flatten(), 0, ignoreInvalids);
	}

	/**
	 * @param a dataset
	 * @param axis
	 * @param ignoreInvalids see {@link Dataset#max(int, boolean...)}
	 * @return cumulative product of items along axis in dataset
	 * @since 2.0
	 */
	public static Dataset cumulativeProduct(final Dataset a, int axis, final boolean... ignoreInvalids) {
		axis = a.checkAxis(axis);
		int dtype = a.getDType();
		int[] oshape = a.getShape();
		int alen = oshape[axis];
		oshape[axis] = 1;

		final boolean ignoreNaNs;
		final boolean ignoreInfs;
		if (a.hasFloatingPointElements()) {
			ignoreNaNs = ignoreInvalids != null && ignoreInvalids.length > 0 ? ignoreInvalids[0] : false;
			ignoreInfs = ignoreInvalids != null && ignoreInvalids.length > 1 ? ignoreInvalids[1] : ignoreNaNs;
		} else {
			ignoreNaNs = false;
			ignoreInfs = false;
		}
		Dataset result = DatasetFactory.zeros(a);
		PositionIterator pi = result.getPositionIterator(axis);

		int[] pos = pi.getPos();

		while (pi.hasNext()) {

			if (a.isComplex()) {
				double rv = 1, iv = 0;
				switch (dtype) {
				case Dataset.COMPLEX64:
					ComplexFloatDataset af = (ComplexFloatDataset) a;
					ComplexFloatDataset rf = (ComplexFloatDataset) result;
					for (int j = 0; j < alen; j++) {
						if (!Double.isNaN(rv) || !Double.isNaN(iv)) {
							pos[axis] = j;
							final float r1 = af.getReal(pos);
							final float i1 = af.getImag(pos);
							if (ignoreNaNs && (Float.isNaN(r1) || Float.isNaN(i1))) {
								continue;
							}
							if (ignoreInfs  && (Float.isInfinite(r1) || Float.isInfinite(i1))) {
								continue;
							}
							final double tv = r1*rv - i1*iv;
							iv = r1*iv + i1*rv;
							rv = tv;
						}
						rf.set((float) rv, (float) iv, pos);
					}
					break;
				case Dataset.COMPLEX128:
					ComplexDoubleDataset ad = (ComplexDoubleDataset) a;
					ComplexDoubleDataset rd = (ComplexDoubleDataset) result;
					for (int j = 0; j < alen; j++) {
						if (!Double.isNaN(rv) || !Double.isNaN(iv)) {
							pos[axis] = j;
							final double r1 = ad.getReal(pos);
							final double i1 = ad.getImag(pos);
							if (ignoreNaNs && (Double.isNaN(r1) || Double.isNaN(i1))) {
								continue;
							}
							if (ignoreInfs  && (Double.isInfinite(r1) || Double.isInfinite(i1))) {
								continue;
							}
							final double tv = r1*rv - i1*iv;
							iv = r1*iv + i1*rv;
							rv = tv;
						}
						rd.set(rv, iv, pos);
					}
					break;
				}
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
					for (int j = 0; j < alen; j++) {
						if (!Double.isNaN(dresult)) {
							pos[axis] = j;
							final double x = a.getDouble(pos);
							if (ignoreNaNs && Double.isNaN(x)) {
								continue;
							}
							if (ignoreInfs && Double.isInfinite(x)) {
								continue;
							}
							dresult *= x;
						}
						result.set(dresult, pos);
					}
					break;
				case Dataset.ARRAYFLOAT32: case Dataset.ARRAYFLOAT64:
					is = a.getElementsPerItem();
					CompoundDataset da = (CompoundDataset) a;
					double[] dvalues = new double[is];
					dresults = new double[is];
					for (int k = 0; k < is; k++) {
						dresults[k] = 1.;
					}
					for (int j = 0; j < alen; j++) {
						pos[axis] = j;
						da.getDoubleArray(dvalues, pos);
						boolean okay = true;
						for (int k = 0; k < is; k++) {
							final double val = dvalues[k];
							if (ignoreNaNs && Double.isNaN(val)) {
								okay = false;
								break;
							}
							if (ignoreInfs && Double.isInfinite(val)) {
								okay = false;
								break;
							}
						}
						if (okay) {
							for (int k = 0; k < is; k++) {
								dresults[k] *= dvalues[k];
							}
						}
						result.set(dresults, pos);
					}
					break;
				}
			}
		}

		return result;
	}

	/**
	 * @param a dataset
	 * @param ignoreInvalids see {@link IDataset#max(boolean...)}
	 * @return cumulative sum of items in flattened dataset
	 * @since 2.0
	 */
	public static Dataset cumulativeSum(final Dataset a, final boolean... ignoreInvalids) {
		return cumulativeSum(a.flatten(), 0, ignoreInvalids);
	}

	/**
	 * @param a dataset
	 * @param axis
	 * @param ignoreInvalids see {@link Dataset#max(int, boolean...)}
	 * @return cumulative sum of items along axis in dataset
	 * @since 2.0
	 */
	public static Dataset cumulativeSum(final Dataset a, int axis, final boolean... ignoreInvalids) {
		axis = a.checkAxis(axis);
		int dtype = a.getDType();
		int[] oshape = a.getShape();
		int alen = oshape[axis];
		oshape[axis] = 1;

		final boolean ignoreNaNs;
		final boolean ignoreInfs;
		if (a.hasFloatingPointElements()) {
			ignoreNaNs = ignoreInvalids != null && ignoreInvalids.length > 0 ? ignoreInvalids[0] : false;
			ignoreInfs = ignoreInvalids != null && ignoreInvalids.length > 1 ? ignoreInvalids[1] : ignoreNaNs;
		} else {
			ignoreNaNs = false;
			ignoreInfs = false;
		}
		Dataset result = DatasetFactory.zeros(a);
		PositionIterator pi = result.getPositionIterator(axis);

		int[] pos = pi.getPos();

		while (pi.hasNext()) {

			if (a.isComplex()) {
				double rv = 0, iv = 0;
				switch (dtype) {
				case Dataset.COMPLEX64:
					ComplexFloatDataset af = (ComplexFloatDataset) a;
					ComplexFloatDataset rf = (ComplexFloatDataset) result;
					for (int j = 0; j < alen; j++) {
						if (!Double.isNaN(rv) || !Double.isNaN(iv)) {
							pos[axis] = j;
							final float r1 = af.getReal(pos);
							final float i1 = af.getImag(pos);
							if (ignoreNaNs && (Float.isNaN(r1) || Float.isNaN(i1))) {
								continue;
							}
							if (ignoreInfs  && (Float.isInfinite(r1) || Float.isInfinite(i1))) {
								continue;
							}
							rv += r1;
							iv += i1;
						}
						rf.set((float) rv, (float) iv, pos);
					}
					break;
				case Dataset.COMPLEX128:
					ComplexDoubleDataset ad = (ComplexDoubleDataset) a;
					ComplexDoubleDataset rd = (ComplexDoubleDataset) result;
					for (int j = 0; j < alen; j++) {
						if (!Double.isNaN(rv) || !Double.isNaN(iv)) {
							pos[axis] = j;
							final double r1 = ad.getReal(pos);
							final double i1 = ad.getImag(pos);
							if (ignoreNaNs && (Double.isNaN(r1) || Double.isNaN(i1))) {
								continue;
							}
							if (ignoreInfs  && (Double.isInfinite(r1) || Double.isInfinite(i1))) {
								continue;
							}
							rv += r1;
							iv += i1;
						}
						rd.set(rv, iv, pos);
					}
					break;
				}
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
					for (int j = 0; j < alen; j++) {
						if (!Double.isNaN(dresult)) {
							pos[axis] = j;
							final double x = a.getDouble(pos);
							if (ignoreNaNs && Double.isNaN(x)) {
								continue;
							}
							if (ignoreInfs && Double.isInfinite(x)) {
								continue;
							}
							dresult += x;
						}
						result.set(dresult, pos);
					}
					break;
				case Dataset.ARRAYFLOAT32: case Dataset.ARRAYFLOAT64:
					is = a.getElementsPerItem();
					CompoundDataset da = (CompoundDataset) a;
					double[] dvalues = new double[is];
					dresults = new double[is];
					for (int j = 0; j < alen; j++) {
						pos[axis] = j;
						da.getDoubleArray(dvalues, pos);
						boolean okay = true;
						for (int k = 0; k < is; k++) {
							final double val = dvalues[k];
							if (ignoreNaNs && Double.isNaN(val)) {
								okay = false;
								break;
							}
							if (ignoreInfs && Double.isInfinite(val)) {
								okay = false;
								break;
							}
						}
						if (okay) {
							for (int k = 0; k < is; k++) {
								dresults[k] += dvalues[k];
							}
						}
						result.set(dresults, pos);
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

	static double[] outlierValuesMap(final Dataset a, int nl, int nh) {
		final TreeMap<Double, Integer> lMap = new TreeMap<Double, Integer>();
		final TreeMap<Double, Integer> hMap = new TreeMap<Double, Integer>();

		int ml = 0;
		int mh = 0;
		IndexIterator it = a.getIterator();
		while (it.hasNext()) {
			Double x = a.getElementDoubleAbs(it.index);
			if (Double.isNaN(x)) {
				continue;
			}
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

	static double[] outlierValuesList(final Dataset a, int nl, int nh) {
		final List<Double> lList = new ArrayList<Double>(nl);
		final List<Double> hList = new ArrayList<Double>(nh);

		double lx = Double.POSITIVE_INFINITY;
		double hx = Double.NEGATIVE_INFINITY;

		IndexIterator it = a.getIterator();
		while (it.hasNext()) {
			double x = a.getElementDoubleAbs(it.index);
			if (Double.isNaN(x)) {
				continue;
			}
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

	/**
	 * See {@link #covariance(Dataset a, Dataset b, boolean rowvar, boolean bias, Integer ddof)} with b = null, rowvar = true, bias = false and ddof = null.
	 * @param a
	 * @return covariance array of a
	 */
	public static Dataset covariance(final Dataset a) {
		return covariance(a, true, false, null); 
	}

	/**
	 * See {@link #covariance(Dataset a, Dataset b, boolean rowvar, boolean bias, Integer ddof)} with b = null.
	 * @param a
	 * @return covariance array of a
	 * @since 2.0
	 */
	public static Dataset covariance(final Dataset a, 
			boolean rowvar, boolean bias, Integer ddof) {
		return covariance(a, null, rowvar, bias, ddof);
	}

	/**
	 * See {@link #covariance(Dataset a, Dataset b, boolean rowvar, boolean bias, Integer ddof)} with b = null, rowvar = true, bias = false and ddof = null.
	 * @param a
	 * @return covariance array of a concatenated with b
	 */
	public static Dataset covariance(final Dataset a, final Dataset b) {
		return covariance(a, b, true, false, null);
	}

	/**
	 * Calculate the covariance matrix (array) of a concatenated with b. This 
	 * method is directly based on the implementation in numpy (cov). 
	 * @param a Array containing multiple variable and observations. Each row represents a variable, each column an observation.
	 * @param b An extra set of variables and observations. Must be of same type as a and have a compatible shape. 
	 * @param rowvar When true (default), each row is a variable; when false each column is a variable.
	 * @param bias Default normalisation is (N - 1) - N is number of observations. If set true, normalisation is (N). 
	 * @param ddof Default normalisation is (N - 1). If ddof is set, then normalisation is (N - ddof).
	 * @return covariance array of a concatenated with b
	 * @since 2.0
	 */
	public static Dataset covariance (final Dataset a, final Dataset b, 
			boolean rowvar, boolean bias, Integer ddof) {
		
		//Create a working copy of the dataset & check its rank.
		Dataset vars = a.clone();
		if (a.getRank() == 1) {
			vars.setShape(1, a.getShape()[0]);
		}
		
		//1D of variables, so consider rows as variables
		if (vars.getShape()[0] == 1) {
			rowvar = true;
		}
		
		//nr is the number of records; axis is index
		int nr, axis;
		if (rowvar) {
			nr = vars.getShape()[1];
			axis = 0;
		} else {
			nr = vars.getShape()[0];
			axis = 1;
		}
		
		//Set the reduced degrees of freedom & normalisation factor
		if (ddof == null) {
			if (bias == false) {
				ddof = 1;
			} else {
				ddof = 0;
			}
		}
		double norm_fact = nr - ddof;
		if (norm_fact <= 0.) {
			//TODO Some sort of warning here?
			norm_fact = 0.;
		}
		
		//Concatenate additional set of variables with main set
		if (b != null) {
			//Create a working copy of the dataset & check its rank.
			Dataset extraVars = b.clone();
			if (b.getRank() == 1) {
				extraVars.setShape(1, a.getShape()[0]);
			}
			vars = DatasetUtils.concatenate(new Dataset[]{vars, extraVars}, axis);
		}
		
		//Calculate deviations & covariance matrix
		Dataset varsMean = vars.mean(1-axis, false);
		//-vars & varsMean need same shape (this is a hack!)
		int[] meanShape = vars.getShape();
		meanShape[1-axis] = 1;
		varsMean.setShape(meanShape);
		vars.isubtract(varsMean);
		Dataset cov;
		if (rowvar) {
			cov = Maths.divide(LinearAlgebra.dotProduct(vars, Maths.conjugate(vars.transpose())), norm_fact).squeeze();
		} else {
			cov = Maths.divide(LinearAlgebra.dotProduct(vars.transpose(), Maths.conjugate(vars)), norm_fact).squeeze();
		}
		return cov;
	}
}
