/*-
 *******************************************************************************
 * Copyright (c) 2017 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Peter Chang - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.january.metadata.internal;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.eclipse.january.dataset.CompoundDataset;
import org.eclipse.january.dataset.CompoundDoubleDataset;
import org.eclipse.january.dataset.DTypeUtils;
import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.dataset.DoubleDataset;
import org.eclipse.january.dataset.IndexIterator;
import org.eclipse.january.dataset.IntegerDataset;
import org.eclipse.january.dataset.LongDataset;
import org.eclipse.january.dataset.Maths;
import org.eclipse.january.dataset.NullStorelessUnivariateStatistic;
import org.eclipse.january.metadata.Dirtiable;
import org.eclipse.january.metadata.StatisticsMetadata;

/**
 * Calculate and store standard statistics
 */
public class StatisticsMetadataImpl<T> implements StatisticsMetadata<T> {

	private static final long serialVersionUID = -6660224998596148031L;

	private static final int COMBOS = 4; // number of combinations of ignoreInvalids

	private int hash;
	private int dtype;
	private int isize;
	private Dataset dataset;
	private Dataset[][] axisStats = null;

	private MaxMin<T>[] mms;
	private SummaryStatistics[][] summaries;

	@Dirtiable
	private boolean isDirty = true;

	public StatisticsMetadataImpl() {
	}

	@SuppressWarnings("unchecked")
	private StatisticsMetadataImpl(StatisticsMetadataImpl<T> statsMetadata) {
		hash = statsMetadata.hash;
		isize = statsMetadata.isize;
		dtype = statsMetadata.dtype;
		dataset = statsMetadata.dataset.getView(false);
		axisStats = new Dataset[dataset.getRank() * COMBOS][];
		for (int i = 0; i < axisStats.length; i++) {
			axisStats[i] = statsMetadata.axisStats[i];
		}

		if (statsMetadata.mms != null) {
			mms = new MaxMin[COMBOS];
			for (int i = 0; i < mms.length; i++) {
				mms[i] = statsMetadata.mms[i];
			}
		}

		summaries = new SummaryStatistics[COMBOS][];
		for (int i = 0; i < summaries.length; i++) {
			SummaryStatistics[] oSummary = statsMetadata.summaries[i];
			if (oSummary != null) {
				SummaryStatistics[] nSummary = new SummaryStatistics[isize];
				summaries[i] = nSummary;
				for (int j = 0; j < isize; j++) {
					nSummary[j] = oSummary[j];
				}
			}
		}

		isDirty = statsMetadata.isDirty;
	}

	private static class MaxMin<T> implements Serializable {
		private static final long serialVersionUID = -8707875904521260325L;
		T maximum;
		T minimum;
		List<int[]> maximumPositions;
		List<int[]> minimumPositions;
	}

	@SuppressWarnings("unchecked")
	public void initialize(Dataset dataset) {
		this.dataset = dataset.getView(false);
		this.dataset.clearMetadata(null);
		dtype = dataset.getDType();
		isize = dataset.getElementsPerItem();
		mms = new MaxMin[COMBOS];
		summaries = new SummaryStatistics[COMBOS][];

		axisStats = new Dataset[this.dataset.getRank() * COMBOS][];
		setDirty();
	}

	/**
	 * @param maxMin
	 * @param ignoreInvalids - Can be null, one boolean, or two booleans. By default, both are false. If
	 * the first boolean is true, will ignore NaNs and ignore infinities. Use the second boolean to
	 * ignore infinities separately.
	 */
	private int refresh(boolean maxMin, boolean... ignoreInvalids) {
		boolean ignoreNaNs = false;
		boolean ignoreInfs = false;
		if (dataset.hasFloatingPointElements()) {
			ignoreNaNs = ignoreInvalids != null && ignoreInvalids.length > 0 ? ignoreInvalids[0] : false;
			ignoreInfs = ignoreInvalids != null && ignoreInvalids.length > 1 ? ignoreInvalids[1] : ignoreNaNs;
		}

		if (isDirty) {
			clearAll();
		}
		int idx = (ignoreNaNs ? 1 : 0)*2 + (ignoreInfs ? 1 : 0);
		if (mms[idx] == null) {
			mms[idx] = new MaxMin<T>();
		}
		// FIXME not thread-safe...
		if (maxMin) {
			if (mms[idx].maximum == null) {
				setMaxMin(mms[idx], ignoreNaNs, ignoreInfs);
			}
		} else {
			if (summaries[idx] == null) {
				summaries[idx] = createSummaryStats(mms[idx],ignoreNaNs, ignoreInfs);
			}
		}
		isDirty = false;
		return idx;
	}

	/**
	 * Calculate summary statistics for a dataset
	 * @param mm
	 * @param ignoreNaNs if true, ignore NaNs
	 * @param ignoreInfs if true, ignore infinities
	 */
	@SuppressWarnings("unchecked")
	private void setMaxMin(final MaxMin<T> mm, final boolean ignoreNaNs, final boolean ignoreInfs) {
		final IndexIterator iter = dataset.getIterator();

		if (!DTypeUtils.isDTypeNumerical(dtype)) { // TODO FIXME for strings
			 // treat non-numerical as strings in lexicographic order
			String smax = dataset.getStringAbs(0);
			String smin = smax;
			while (iter.hasNext()) {
				final String val = dataset.getStringAbs(iter.index);
				hash = (int) (hash * 19 + val.hashCode());
				if (val.compareTo(smax) > 0) {
					smax = val;
				}
				if (val.compareTo(smin) < 0) {
					smin = val;
				}
			}

			hash = hash * 19 + dtype * 17 + isize;
			mm.maximum = (T) smax;
			mm.minimum = (T) smin;
			mm.maximumPositions = null;
			mm.minimumPositions = null;
			return;
		}

		if (isize == 1) {
			double amax = Double.NEGATIVE_INFINITY;
			double amin = Double.POSITIVE_INFINITY;
	
			boolean hasNaNs = false;
			if (dataset.hasFloatingPointElements() && (ignoreNaNs || ignoreInfs)) {
				while (iter.hasNext()) {
					final double val = dataset.getElementDoubleAbs(iter.index);
					hash = (int) (hash * 19 + Double.doubleToRawLongBits(val));
					if (Double.isNaN(val)) {
						if (ignoreNaNs)
							continue;
						hasNaNs = true;
					} else if (Double.isInfinite(val)) {
						if (ignoreInfs)
							continue;
					}
					if (val > amax) {
						amax = val;
					}
					if (val < amin) {
						amin = val;
					}
				}
			} else if (dataset.hasFloatingPointElements()) {
				while (iter.hasNext()) {
					final double val = dataset.getElementDoubleAbs(iter.index);
					hash = (int) (hash * 19 + Double.doubleToRawLongBits(val));
					if (Double.isNaN(val)) {
						hasNaNs = true;
						continue;
					}
					if (val > amax) {
						amax = val;
					}
					if (val < amin) {
						amin = val;
					}
				}
			} else {
				while (iter.hasNext()) {
					final long val = dataset.getElementLongAbs(iter.index);
					hash = (int) (hash * 19 + val);
					if (val > amax) {
						amax = val;
					}
					if (val < amin) {
						amin = val;
					}
				}
			}

			mm.maximum = (T) (hasNaNs ? Double.NaN : DTypeUtils.fromDoubleToBiggestNumber(amax, dtype));
			mm.minimum = (T) (hasNaNs ? Double.NaN : DTypeUtils.fromDoubleToBiggestNumber(amin, dtype));
		} else {
			while (iter.hasNext()) {
				for (int j = 0; j < isize; j++) {
					final double val = dataset.getElementDoubleAbs(iter.index + j);
					hash = (int) (hash * 19 + Double.doubleToRawLongBits(val));
				}
			}

			mm.maximum = null;
			mm.minimum = null;
		}

		hash = hash * 19 + dtype * 17 + isize;
		mm.maximumPositions = null;
		mm.minimumPositions = null;
	}

	/**
	 * Calculate summary statistics for a dataset
	 * @param ignoreNaNs if true, ignore NaNs
	 * @param ignoreInfs if true, ignore infinities
	 */
	@SuppressWarnings("unchecked")
	private SummaryStatistics[] createSummaryStats(final MaxMin<T> mm, final boolean ignoreNaNs, final boolean ignoreInfs) {
		final IndexIterator iter = dataset.getIterator();
		SummaryStatistics[] istats = new SummaryStatistics[isize];
		for (int i = 0; i < isize; i++) {
			istats[i] = new SummaryStatistics();
			// sum of logs is slow and we don't use it, so blocking its calculation here
			istats[i].setSumLogImpl(new NullStorelessUnivariateStatistic());
		}

		SummaryStatistics stats;
		if (isize == 1) {
			boolean hasNaNs = false;
			stats = istats[0];
			if (dataset.hasFloatingPointElements() && (ignoreNaNs || ignoreInfs)) {
				while (iter.hasNext()) {
					final double val = dataset.getElementDoubleAbs(iter.index);
					hash = (int) (hash * 19 + Double.doubleToRawLongBits(val));
					if (Double.isNaN(val)) {
						if (ignoreNaNs)
							continue;
						hasNaNs = true;
					} else if (Double.isInfinite(val)) {
						if (ignoreInfs)
							continue;
					}
					stats.addValue(val);
				}
			} else if (dataset.hasFloatingPointElements()) {
				while (iter.hasNext()) {
					final double val = dataset.getElementDoubleAbs(iter.index);
					hash = (int) (hash * 19 + Double.doubleToRawLongBits(val));
					if (Double.isNaN(val)) {
						hasNaNs = true;
					}
					stats.addValue(val);
				}
			} else {
				while (iter.hasNext()) {
					final long val = dataset.getElementLongAbs(iter.index);
					hash = (int) (hash * 19 + val);
					stats.addValue(val);
				}
			}

			mm.maximum = (T) (hasNaNs ? Double.NaN : DTypeUtils.fromDoubleToBiggestNumber(stats.getMax(), dtype));
			mm.minimum = (T) (hasNaNs ? Double.NaN : DTypeUtils.fromDoubleToBiggestNumber(stats.getMin(), dtype));
		} else {
			double[] vals = new double[isize];
			while (iter.hasNext()) {
				boolean okay = true;
				for (int j = 0; j < isize; j++) {
					final double val = dataset.getElementDoubleAbs(iter.index + j);
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
					for (int j = 0; j < isize; j++) {
						double val = vals[j];
						istats[j].addValue(val);
						hash = (int) (hash * 19 + Double.doubleToRawLongBits(val));
					}
				}
			}

			double[] lmax = new double[isize];
			double[] lmin = new double[isize];
			for (int j = 0; j < isize; j++) {
				stats = istats[j];
				lmax[j] = stats.getMax();
				lmin[j] = stats.getMin();
			}
			mm.maximum = (T) lmax;
			mm.minimum = (T) lmin;
		}

		hash = hash * 19 + dtype * 17 + isize;
		mm.maximumPositions = null;
		mm.minimumPositions = null;
		return istats;
	}

	@Override
	public void setDirty() {
		isDirty = true;
	}

	@Override
	public boolean isDirty() {
		return isDirty;
	}

	private void clearAll() {
		hash = 0;
		for (int i = 0; i < summaries.length; i++) {
			summaries[i] = null;
			mms[i] = null;
		}
		for (int i = 0; i < axisStats.length; i++) {
			axisStats[i] = null;
		}
	}

	@Override
	public StatisticsMetadataImpl<T> clone() {
		return new StatisticsMetadataImpl<T>(this);
	}

	@Override
	public int getHash(int[] shape) {
		if (isDirty || hash == 0) {
			isDirty = true;
			refresh(true);
		}

		final int rank = shape == null ? 0 : shape.length;
		int shash = hash;
		for (int i = 0; i < rank; i++) {
			shash = shash*17 + shape[i];
		}
		return shash;
	}

	@Override
	public void setHash(int hash) {
		this.hash = hash;
	}

	@Override
	public T getMaximum(boolean... ignoreInvalids) {
		int idx = refresh(isize == 1, ignoreInvalids);
		return mms[idx].maximum;
	}

	@Override
	public void setMaximumMinimum(T maximum, T minimum, boolean... ignoreInvalids) {
		int idx = refresh(true, ignoreInvalids);
		MaxMin<T> mm = mms[idx];
		mm.maximum = maximum;
		mm.minimum = minimum;
		mm.maximumPositions = null;
		mm.minimumPositions = null;
	}

	@Override
	public void setMaximumPositions(List<int[]> maximumPositions, boolean... ignoreInvalids) {
		int idx = refresh(true, ignoreInvalids);
		mms[idx].maximumPositions = maximumPositions;
	}

	@Override
	public List<int[]> getMaximumPositions(boolean... ignoreInvalids) {
		int idx = refresh(true, ignoreInvalids);
		return mms[idx].maximumPositions;
	}

	@Override
	public T getMinimum(boolean... ignoreInvalids) {
		int idx = refresh(isize == 1, ignoreInvalids);
		return mms[idx].minimum;
	}

	@Override
	public List<int[]> getMinimumPositions(boolean... ignoreInvalids) {
		int idx = refresh(true, ignoreInvalids);
		return mms[idx].minimumPositions;
	}

	@Override
	public void setMinimumPositions(List<int[]> minimumPositions, boolean... ignoreInvalids) {
		int idx = refresh(true, ignoreInvalids);
		mms[idx].minimumPositions = minimumPositions;
	}

	@Override
	public long getCount(boolean... ignoreInvalids) {
		int idx = refresh(false, ignoreInvalids);
		return summaries[idx][0].getN();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getMean(boolean... ignoreInvalids) { // TODO
		int idx = refresh(false, ignoreInvalids);
		SummaryStatistics[] summary = summaries[idx];
		if (isize == 1) {
			return (T) (Double) summary[0].getMean();
		} else {
			double[] result = new double[isize];
			for (int i = 0; i < isize; i++) {
				result[i] = summary[i].getMean();
			}
			return (T) result;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getSum(boolean... ignoreInvalids) { // TODO
		int idx = refresh(false, ignoreInvalids);
		SummaryStatistics[] summary = summaries[idx];
		if (isize == 1) {
			return (T) (Double) summary[0].getSum();
		} else {
			double[] result = new double[isize];
			for (int i = 0; i < isize; i++) {
				result[i] = summary[i].getSum();
			}
			return (T) result;
		}
	}

	@Override
	public double getVariance(boolean isWholePopulation, boolean... ignoreInvalids) { // TODO
		int idx = refresh(false, ignoreInvalids);
		SummaryStatistics[] summary = summaries[idx];
		if (isize == 1) {
			return isWholePopulation ? summary[0].getPopulationVariance() : summary[0].getVariance();
		} else {
			double result = 0;
			for (int i = 0; i < isize; i++) {
				result += isWholePopulation ? summary[i].getPopulationVariance() : summary[i].getVariance();
			}
			return result;
		}
	}

	/**
	 * @param axis
	 * @param ignoreInvalids - Can be null, one boolean, or two booleans. By default, both are false. If
	 * the first boolean is true, will ignore NaNs and ignore infinities. Use the second boolean to
	 * ignore infinities separately.
	 */
	private int refresh(int axis, boolean... ignoreInvalids) {
		boolean ignoreNaNs = false;
		boolean ignoreInfs = false;
		if (dataset.hasFloatingPointElements()) {
			ignoreNaNs = ignoreInvalids != null && ignoreInvalids.length > 0 ? ignoreInvalids[0] : false;
			ignoreInfs = ignoreInvalids != null && ignoreInvalids.length > 1 ? ignoreInvalids[1] : ignoreNaNs;
		}

		if (isDirty) {
			clearAll();
		}
		int axisOffset = (ignoreNaNs ? 1 : 0)*2 + (ignoreInfs ? 1 : 0) + COMBOS * axis;
		if (axisStats[axisOffset] == null) {
			axisStats[axisOffset] = createAxisStats(axis, ignoreNaNs, ignoreInfs);
		}

		isDirty = false;
		return axisOffset;
	}

	/**
	 * Calculate summary statistics for a dataset along an axis
	 * @param ignoreNaNs if true, ignore NaNs
	 * @param ignoreInfs if true, ignore infinities
	 * @param axis
	 */
	@SuppressWarnings("deprecation")
	private Dataset[] createAxisStats(final int axis, final boolean ignoreNaNs, final boolean ignoreInfs) {
		int rank = dataset.getRank();

		int[] oshape = dataset.getShape();
		int alen = oshape[axis];
		oshape[axis] = 1;

		int[] nshape = new int[rank - 1];
		for (int i = 0; i < axis; i++) {
			nshape[i] = oshape[i];
		}
		for (int i = axis + 1; i < rank; i++) {
			nshape[i - 1] = oshape[i];
		}

		Dataset max;
		Dataset min;
		IntegerDataset maxIndex;
		IntegerDataset minIndex;
		LongDataset count = DatasetFactory.zeros(LongDataset.class, nshape);
		Dataset sum;
		Dataset mean;
		Dataset var;

		if (isize == 1) {
			max = DatasetFactory.zeros(nshape, dtype);
			min = DatasetFactory.zeros(nshape, dtype);
			maxIndex = DatasetFactory.zeros(IntegerDataset.class, nshape);
			minIndex = DatasetFactory.zeros(IntegerDataset.class, nshape);
			sum = DatasetFactory.zeros(nshape, DTypeUtils.getLargestDType(dtype));
			mean = DatasetFactory.zeros(DoubleDataset.class, nshape);
			var = DatasetFactory.zeros(DoubleDataset.class, nshape);
		} else {
			max = null;
			min = null;
			maxIndex = null;
			minIndex = null;
			sum = DatasetFactory.zeros(isize, nshape, DTypeUtils.getLargestDType(dtype));
			mean = DatasetFactory.zeros(isize, CompoundDoubleDataset.class, nshape);
			var = DatasetFactory.zeros(isize, CompoundDoubleDataset.class, nshape);
		}


		IndexIterator qiter = count.getIterator(true);
		int[] qpos = qiter.getPos();
		int[] spos = oshape.clone();

		if (isize == 1) {
			DoubleDataset lmean = (DoubleDataset) mean;
			DoubleDataset lvar = (DoubleDataset) var;

			final SummaryStatistics stats = new SummaryStatistics();
			while (qiter.hasNext()) {
				int i = 0;
				for (; i < axis; i++) {
					spos[i] = qpos[i];
				}
				spos[i++] = 0;
				for (; i < rank; i++) {
					spos[i] = qpos[i - 1];
				}
	
				stats.clear();
				//sum of logs is slow and we dont use it, so blocking its calculation here
				stats.setSumLogImpl(new NullStorelessUnivariateStatistic());
				
				double amax = Double.NEGATIVE_INFINITY;
				double amin = Double.POSITIVE_INFINITY;
				boolean hasNaNs = false;
				if (ignoreNaNs) {
					for (int j = 0; j < alen; j++) {
						spos[axis] = j;
						final double val = dataset.getDouble(spos);
	
						if (Double.isNaN(val)) {
							hasNaNs = true;
							continue;
						} else if (ignoreInfs && Double.isInfinite(val)) {
							continue;
						}
	
						if (val > amax) {
							amax = val;
						}
						if (val < amin) {
							amin = val;
						}
	
						stats.addValue(val);
					}
				} else {
					for (int j = 0; j < alen; j++) {
						spos[axis] = j;
						final double val = dataset.getDouble(spos);
	
						if (hasNaNs) {
							if (!Double.isNaN(val))
								stats.addValue(0);
							continue;
						}
	
						if (Double.isNaN(val)) {
							amax = Double.NaN;
							amin = Double.NaN;
							hasNaNs = true;
						} else if (ignoreInfs && Double.isInfinite(val)) {
							continue;
						} else {
							if (val > amax) {
								amax = val;
							}
							if (val < amin) {
								amin = val;
							}
						}
						stats.addValue(val);
					}
				}
	
				count.setAbs(qiter.index, stats.getN());

				max.set(amax, qpos);
				min.set(amin, qpos);
				boolean fmax = false;
				boolean fmin = false;
				if (hasNaNs) {
					if (ignoreNaNs) {
						for (int j = 0; j < alen; j++) {
							spos[axis] = j;
							final double val = dataset.getDouble(spos);
							if (Double.isNaN(val))
								continue;
	
							if (!fmax && val == amax) { // FIXME qiter.index is wrong!!!
								maxIndex.setAbs(qiter.index, j);
								fmax = true;
								if (fmin)
									break;
							}
							if (!fmin && val == amin) {
								minIndex.setAbs(qiter.index, j);
								fmin = true;
								if (fmax)
									break;
							}
						}
					} else {
						for (int j = 0; j < alen; j++) {
							spos[axis] = j;
							final double val = dataset.getDouble(spos);
							if (Double.isNaN(val)) {
								maxIndex.setAbs(qiter.index, j);
								minIndex.setAbs(qiter.index, j);
								break;
							}
						}
					}
				} else {
					for (int j = 0; j < alen; j++) {
						spos[axis] = j;
						final double val = dataset.getDouble(spos);
						if (!fmax && val == amax) {
							maxIndex.setAbs(qiter.index, j);
							fmax = true;
							if (fmin)
								break;
						}
						if (!fmin && val == amin) {
							minIndex.setAbs(qiter.index, j);
							fmin = true;
							if (fmax)
								break;
						}
					}
				}
				sum.setObjectAbs(qiter.index, stats.getSum());
				lmean.setAbs(qiter.index, stats.getMean());
				lvar.setAbs(qiter.index, stats.getVariance());
			}
		} else {
			CompoundDataset ldataset = (CompoundDataset) dataset;
			CompoundDoubleDataset lmean = (CompoundDoubleDataset) mean;
			CompoundDoubleDataset lvar = (CompoundDoubleDataset) var;
			double[] darray = new double[isize];

			while (qiter.hasNext()) {
				int i = 0;
				for (; i < axis; i++) {
					spos[i] = qpos[i];
				}
				spos[i++] = 0;
				for (; i < rank; i++) {
					spos[i] = qpos[i-1];
				}

				final SummaryStatistics[] stats = new SummaryStatistics[isize];
				for (int k = 0; k < isize; k++) {
					stats[k] = new SummaryStatistics();
				}
				for (int j = 0; j < alen; j++) {
					spos[axis] = j;
					ldataset.getDoubleArray(darray, spos);
					boolean skip = false;
					for (int k = 0; k < isize; k++) {
						double v = darray[k];
						if (ignoreNaNs && Double.isNaN(v)) {
							skip = true;
							break;
						}
						if (ignoreInfs && Double.isInfinite(v)) {
							skip = true;
							break;
						}
					}
					if (!skip)
						for (int k = 0; k < isize; k++) {
							stats[k].addValue(darray[k]);
						}
				}

				count.setAbs(qiter.index, (int) stats[0].getN());

				for (int k = 0; k < isize; k++) {
					darray[k] = stats[k].getSum();
				}
				sum.set(darray, qpos);
				for (int k = 0; k < isize; k++) {
					darray[k] = stats[k].getMean();
				}
				lmean.setItem(darray, qpos);
				for (int k = 0; k < isize; k++) {
					darray[k] = stats[k].getVariance();
				}
				lvar.setItem(darray, qpos);
			}
		}
		
		return new Dataset[] {max, min, maxIndex, minIndex, count, mean, sum, var};
	}

	private static final int AS_MAX = 0,
			AS_MIN = 1,
			AS_MAX_INDEX = 2,
			AS_MIN_INDEX = 3,
			AS_CNT = 4,
			AS_MEAN = 5,
			AS_SUM = 6,
			AS_VAR = 7;

	@Override
	public Dataset getMaximum(int axis, boolean... ignoreInvalids) {
		int axisOffset = refresh(axis, ignoreInvalids);
		return axisStats[axisOffset][AS_MAX];
	}

	@Override
	public Dataset getMinimum(int axis, boolean... ignoreInvalids) {
		int axisOffset = refresh(axis, ignoreInvalids);
		return axisStats[axisOffset][AS_MIN];
	}

	@Override
	public Dataset getArgMaximum(int axis, boolean... ignoreInvalids) {
		int axisOffset = refresh(axis, ignoreInvalids);
		return axisStats[axisOffset][AS_MAX_INDEX];
	}

	@Override
	public Dataset getArgMinimum(int axis, boolean... ignoreInvalids) {
		int axisOffset = refresh(axis, ignoreInvalids);
		return axisStats[axisOffset][AS_MIN_INDEX];
	}

	@Override
	public Dataset getCount(int axis, boolean... ignoreInvalids) {
		int axisOffset = refresh(axis, ignoreInvalids);
		return axisStats[axisOffset][AS_CNT];
	}

	@Override
	public Dataset getMean(int axis, boolean... ignoreInvalids) {
		int axisOffset = refresh(axis, ignoreInvalids);
		return axisStats[axisOffset][AS_MEAN];
	}

	@Override
	public Dataset getSum(int axis, boolean... ignoreInvalids) {
		int axisOffset = refresh(axis, ignoreInvalids);
		return axisStats[axisOffset][AS_SUM];
	}

	@Override
	public Dataset getVariance(int axis, boolean isWholePopulation, boolean... ignoreInvalids) {
		int axisOffset = refresh(axis, ignoreInvalids);
		Dataset v = axisStats[axisOffset][AS_VAR];
		if (isWholePopulation) {
			Dataset c = axisStats[axisOffset][AS_CNT];
			v = Maths.multiply(v, Maths.subtract(c, 1.).idivide(c));
		}
		return v;
	}
}
