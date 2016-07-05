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
import java.util.HashMap;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.eclipse.dawnsci.analysis.api.dataset.Slice;
import org.eclipse.dawnsci.analysis.api.dataset.SliceND;
import org.eclipse.dawnsci.analysis.api.monitor.IMonitor;

/**
 * Generic container class for data that is compound in nature
 * 
 * Each subclass has an array of compound types, items of this array are composed of primitive types
 * 
 * Data items can be Complex, Vector, etc
 * 
 */
public abstract class AbstractCompoundDataset extends AbstractDataset implements CompoundDataset {
	// pin UID to base class
	private static final long serialVersionUID = Dataset.serialVersionUID;

	protected int isize; // number of elements per item

	@Override
	public int getElementsPerItem() {
		return isize;
	}

	@Override
	protected int get1DIndex(final int i) {
		int n = super.get1DIndex(i);
		return stride == null ? isize * n : n;
	}

	@Override
	protected int get1DIndex(final int i, final int j) {
		int n = super.get1DIndex(i, j);
		return stride == null ? isize * n : n;
	}

	@Override
	protected int get1DIndexFromShape(final int... n) {
		return isize * super.get1DIndexFromShape(n);
	}

	@Override
	public Dataset getUniqueItems() {
		throw new UnsupportedOperationException("Cannot sort compound datasets");
	}

	@Override
	public IndexIterator getIterator(final boolean withPosition) {
		if (stride != null)
			return new StrideIterator(isize, shape, stride, offset);
		return withPosition ? getSliceIterator(null, null, null) :
			new ContiguousIterator(size, isize);
	}

	/**
	 * Get an iterator that picks out the chosen element from all items
	 * @param element
	 * @return an iterator
	 */
	public IndexIterator getIterator(int element) {
		if (element < 0)
			element += isize;
		if (element < 0 || element > isize) {
			logger.error("Invalid choice of element: {}/{}", element, isize);
			throw new IllegalArgumentException("Invalid choice of element: " + element + "/" + isize);
		}
		final IndexIterator it = stride != null ?  new StrideIterator(isize, shape, stride, offset) : new ContiguousIterator(size, isize);

		it.index += element;
		return it;
	}

	@Override
	public IndexIterator getSliceIterator(SliceND slice) {
		if (stride != null)
			return new StrideIterator(isize, shape, stride, offset, slice);

		return new SliceIterator(shape, size, isize, slice);
	}

	/**
	 * Constructor required for serialisation.
	 */
	public AbstractCompoundDataset() {
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}

		CompoundDataset other = (CompoundDataset) obj;
		return isize == other.getElementsPerItem();
	}

	@Override
	public int hashCode() {
		return getHash();
	}

	@Override
	public CompoundDataset cast(boolean repeat, int dtype, int isize) {
		return (CompoundDataset) super.cast(repeat, dtype, isize);
	}

	@Override
	public CompoundDataset cast(int dtype) {
		return (CompoundDataset) super.cast(dtype);
	}

	@Override
	abstract public AbstractCompoundDataset clone();

	@Override
	public CompoundDataset flatten() {
		return (CompoundDataset) super.flatten();
	}

	@Override
	public CompoundDataset getBy1DIndex(IntegerDataset index) {
		return (CompoundDataset) super.getBy1DIndex(index);
	}

	@Override
	public CompoundDataset getByBoolean(Dataset selection) {
		return (CompoundDataset) super.getByBoolean(selection);
	}

	@Override
	public CompoundDataset getByIndexes(Object... indexes) {
		return (CompoundDataset) super.getByIndexes(indexes);
	}

	@Override
	public CompoundDataset getSlice(IMonitor mon, int[] start, int[] stop, int[] step) {
		return (CompoundDataset) super.getSlice(mon, start, stop, step);
	}

	@Override
	public CompoundDataset getSlice(IMonitor mon, Slice... slice) {
		return (CompoundDataset) super.getSlice(mon, slice);
	}

	@Override
	public CompoundDataset getSlice(IMonitor mon, SliceND slice) {
		return (CompoundDataset) super.getSlice(mon, slice);
	}

	@Override
	public CompoundDataset getSlice(int[] start, int[] stop, int[] step) {
		return (CompoundDataset) super.getSlice(start, stop, step);
	}

	@Override
	public CompoundDataset getSlice(Slice... slice) {
		return (CompoundDataset) super.getSlice(slice);
	}

	@Override
	public CompoundDataset getSlice(SliceND slice) {
		return (CompoundDataset) super.getSlice(slice);
	}

	@Override
	abstract public AbstractCompoundDataset getSlice(SliceIterator iterator);

	@Override
	public CompoundDataset getSliceView(int[] start, int[] stop, int[] step) {
		return (CompoundDataset) super.getSliceView(start, stop, step);
	}

	@Override
	public CompoundDataset getSliceView(Slice... slice) {
		return (CompoundDataset) super.getSliceView(slice);
	}

	@Override
	public CompoundDataset getSliceView(SliceND slice) {
		return (CompoundDataset) super.getSliceView(slice);
	}

	@Override
	public CompoundDataset getTransposedView(int... axes) {
		return (CompoundDataset) super.getTransposedView(axes);
	}

	@Override
	abstract public AbstractCompoundDataset getView();

	@Override
	public CompoundDataset ifloorDivide(Object o) {
		return (CompoundDataset) super.ifloorDivide(o);
	}

	@Override
	public CompoundDataset mean(boolean ignoreNaNs, int axis) {
		return (CompoundDataset) super.mean(ignoreNaNs, axis);
	}

	@Override
	public CompoundDataset mean(int axis) {
		return (CompoundDataset) super.mean(axis);
	}

	@Override
	public CompoundDataset peakToPeak(int axis) {
		return (CompoundDataset) super.peakToPeak(axis);
	}

	@Override
	public CompoundDataset product(int axis) {
		return (CompoundDataset) super.product(axis);
	}

	@Override
	public CompoundDataset reshape(int... shape) {
		return (CompoundDataset) super.reshape(shape);
	}

	@Override
	public CompoundDataset rootMeanSquare(int axis) {
		return (CompoundDataset) super.rootMeanSquare(axis);
	}

	@Override
	public CompoundDataset setSlice(Object obj, int[] start, int[] stop, int[] step) {
		return (CompoundDataset) super.setSlice(obj, start, stop, step);
	}

	@Override
	public CompoundDataset setSlice(Object object, Slice... slice) {
		return (CompoundDataset) super.setSlice(object, slice);
	}

	@Override
	public CompoundDataset sort(Integer axis) {
		throw new UnsupportedOperationException("Cannot sort dataset");
	}

	@Override
	public CompoundDataset squeezeEnds() {
		return (CompoundDataset) super.squeezeEnds();
	}

	@Override
	public CompoundDataset squeeze() {
		return (CompoundDataset) super.squeeze();
	}

	@Override
	public CompoundDataset squeeze(boolean onlyFromEnd) {
		return (CompoundDataset) super.squeeze(onlyFromEnd);
	}

	@Override
	public CompoundDataset stdDeviation(int axis) {
		return (CompoundDataset) super.stdDeviation(axis);
	}

	@Override
	public CompoundDataset sum(boolean ignoreNaNs, int axis) {
		return (CompoundDataset) super.sum(ignoreNaNs, axis);
	}

	@Override
	public CompoundDataset sum(int axis) {
		return (CompoundDataset) super.sum(axis);
	}

	@Override
	public CompoundDataset swapAxes(int axis1, int axis2) {
		return (CompoundDataset) super.swapAxes(axis1, axis2);
	}

	@Override
	public synchronized CompoundDataset synchronizedCopy() {
		return clone();
	}

	@Override
	public CompoundDataset transpose(int... axes) {
		return (CompoundDataset) super.transpose(axes);
	}

	@Override
	public CompoundDataset typedProduct(int dtype, int axis) {
		return (CompoundDataset) super.typedProduct(dtype, axis);
	}

	@Override
	public CompoundDataset typedSum(int dtype, int axis) {
		return (CompoundDataset) super.typedSum(dtype, axis);
	}

	@Override
	public CompoundDataset variance(int axis) {
		return (CompoundDataset) super.variance(axis);
	}

	abstract protected double getFirstValue(final int i);

	abstract protected double getFirstValue(final int i, final int j);

	abstract protected double getFirstValue(final int...pos);

	@Override
	public boolean getBoolean(final int i) {
		return getFirstValue(i) != 0;
	}

	@Override
	public boolean getBoolean(final int i, final int j) {
		return getFirstValue(i, j) != 0;
	}

	@Override
	public boolean getBoolean(final int... pos) {
		return getFirstValue(pos) != 0;
	}

	@Override
	public byte getByte(final int i) {
		return (byte) getFirstValue(i);
	}

	@Override
	public byte getByte(final int i, final int j) {
		return (byte) getFirstValue(i, j);
	}

	@Override
	public byte getByte(final int... pos) {
		return (byte) getFirstValue(pos);
	}

	@Override
	public short getShort(final int i) {
		return (short) getFirstValue(i);
	}

	@Override
	public short getShort(final int i, final int j) {
		return (short) getFirstValue(i, j);
	}

	@Override
	public short getShort(final int... pos) {
		return (short) getFirstValue(pos);
	}

	@Override
	public int getInt(final int i) {
		return (int) getFirstValue(i);
	}

	@Override
	public int getInt(final int i, final int j) {
		return (int) getFirstValue(i, j);
	}

	@Override
	public int getInt(final int... pos) {
		return (int) getFirstValue(pos);
	}

	@Override
	public long getLong(final int i) {
		return (long) getFirstValue(i);
	}

	@Override
	public long getLong(final int i, final int j) {
		return (long) getFirstValue(i, j);
	}

	@Override
	public long getLong(final int... pos) {
		return (long) getFirstValue(pos);
	}

	@Override
	public float getFloat(final int i) {
		return (float) getFirstValue(i);
	}

	@Override
	public float getFloat(final int i, final int j) {
		return (float) getFirstValue(i, j);
	}

	@Override
	public float getFloat(final int... pos) {
		return (float) getFirstValue(pos);
	}

	@Override
	public double getDouble(final int i) {
		return getFirstValue(i);
	}

	@Override
	public double getDouble(final int i, final int j) {
		return getFirstValue(i, j);
	}

	@Override
	public double getDouble(final int... pos) {
		return getFirstValue(pos);
	}

	@Override
	public void getDoubleArray(final double[] darray, final int i) {
		getDoubleArrayAbs(get1DIndex(i), darray);
	}

	@Override
	public void getDoubleArray(final double[] darray, final int i, final int j) {
		getDoubleArrayAbs(get1DIndex(i, j), darray);
	}

	@Override
	public void getDoubleArray(final double[] darray, final int... pos) {
		getDoubleArrayAbs(get1DIndex(pos), darray);
	}

	@Override
	protected Number fromDoubleToNumber(double x) {
		return null;
	}

	/**
	 * Calculate minimum and maximum for a dataset
	 */
	protected void calculateHash() {
		IndexIterator iter = getIterator();
		double hash = 0;
		while (iter.hasNext()) {
			for (int j = 0; j < isize; j++) {
				final double val = getElementDoubleAbs(iter.index + j);
				if (Double.isInfinite(val) || Double.isNaN(val)) {
					hash = (hash * 19) % Integer.MAX_VALUE;
				} else {
					hash = (hash * 19 + val) % Integer.MAX_VALUE;
				}
			}
		}

		int ihash = ((int) hash) * 19 + getDType() * 17 + getElementsPerItem();
		setStoredValue(STORE_SHAPELESS_HASH, ihash);
	}

	private int getHash() {
		Object value = getStoredValue(STORE_HASH);
		if (value == null) {
			value = getStoredValue(STORE_SHAPELESS_HASH);
			if (value == null) {
				calculateHash();
				value = getStoredValue(STORE_SHAPELESS_HASH);
			}

			int ihash = (Integer) value;
			int rank = shape.length;
			for (int i = 0; i < rank; i++) {
				ihash = ihash * 17 + shape[i];
			}
			storedValues.put(STORE_HASH, ihash);
			return ihash;
		}

		return (Integer) value;
	}

	@Override
	protected void calculateSummaryStats(boolean ignoreNaNs, final boolean ignoreInfs, String name) {
		IndexIterator iter = getIterator();
		SummaryStatistics[] stats = new SummaryStatistics[isize];
		for (int i = 0; i < isize; i++)
			stats[i] = new SummaryStatistics();

		double[] vals = new double[isize];
		while (iter.hasNext()) {
			boolean okay = true;
			for (int i = 0; i < isize; i++) {
				final double val = getElementDoubleAbs(iter.index + i);
				if (ignoreNaNs && Double.isNaN(val)) {
					okay = false;
					break;
				}
				if (ignoreInfs && Double.isInfinite(val)) {
					okay = false;
					break;
				}
				vals[i] = val;
			}
			if (!okay)
				continue;
			for (int i = 0; i < isize; i++)
				stats[i].addValue(vals[i]);
		}

		// now all the calculations are done, add the values into store
		if (storedValues == null)
			storedValues = new HashMap<String, Object>();
		else
			storedValues.clear();

		for (int i = 0; i < isize; i++)
			storedValues.put(name+i, stats[i]);
	}

	@Override
	protected void calculateSummaryStats(final boolean ignoreNaNs, final boolean ignoreInfs, final int axis) {
		int rank = getRank();

		int[] oshape = getShape();
		int alen = oshape[axis];
		oshape[axis] = 1;

		int[] nshape = squeezeShape(oshape, false);

		IntegerDataset count = new IntegerDataset(nshape);
		CompoundDoubleDataset sum = new CompoundDoubleDataset(isize, nshape);
		CompoundDoubleDataset mean = new CompoundDoubleDataset(isize, nshape);
		CompoundDoubleDataset var = new CompoundDoubleDataset(isize, nshape);

		IndexIterator qiter = count.getIterator(true);
		int[] qpos = qiter.getPos();
		int[] spos = oshape;
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
				getDoubleArray(darray, spos);
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
			mean.set(darray, qpos);
			for (int k = 0; k < isize; k++) {
				darray[k] = stats[k].getVariance();
			}
			var.set(darray, qpos);
		}
		setStoredValue(storeName(ignoreNaNs, ignoreInfs, STORE_COUNT + "-" + axis), count);
		storedValues.put(storeName(ignoreNaNs, ignoreInfs, STORE_SUM + "-" + axis), sum);
		storedValues.put(storeName(ignoreNaNs, ignoreInfs, STORE_MEAN + "-" +axis), mean);
		storedValues.put(storeName(ignoreNaNs, ignoreInfs, STORE_VAR + "-" +axis), var);
	}

	@Override
	public Number max(boolean... switches) {
		logger.error("Cannot compare compound numbers");
		throw new UnsupportedOperationException("Cannot compare compound numbers");
	}

	@Override
	public CompoundDataset max(boolean ignoreNaNs, int axis) {
		logger.error("Cannot compare compound numbers");
		throw new UnsupportedOperationException("Cannot compare compound numbers");
	}

	@Override
	public CompoundDataset max(int axis) {
		logger.error("Cannot compare compound numbers");
		throw new UnsupportedOperationException("Cannot compare compound numbers");
	}

	@Override
	public Number min(boolean... switches) {
		logger.error("Cannot compare compound numbers");
		throw new UnsupportedOperationException("Cannot compare compound numbers");
	}

	@Override
	public CompoundDataset min(boolean ignoreNaNs, int axis) {
		logger.error("Cannot compare compound numbers");
		throw new UnsupportedOperationException("Cannot compare compound numbers");
	}

	@Override
	public CompoundDataset min(int axis) {
		logger.error("Cannot compare compound numbers");
		throw new UnsupportedOperationException("Cannot compare compound numbers");
	}

	@Override
	public Number positiveMin(boolean ignoreInvalids) {
		logger.error("Cannot compare compound numbers");
		throw new UnsupportedOperationException("Cannot compare compound numbers");
	}

	@Override
	public Number positiveMax(boolean ignoreNaNs, boolean ignoreInfs) {
		logger.error("Cannot compare compound numbers");
		throw new UnsupportedOperationException("Cannot compare compound numbers");
	}

	@Override
	public Number positiveMin(boolean ignoreNaNs, boolean ignoreInfs) {
		logger.error("Cannot compare compound numbers");
		throw new UnsupportedOperationException("Cannot compare compound numbers");
	}

	@Override
	public int[] maxPos(boolean ignoreNaNs) {
		logger.error("Cannot compare compound numbers");
		throw new UnsupportedOperationException("Cannot compare compound numbers");
	}

	@Override
	public int[] minPos(boolean ignoreNaNs) {
		logger.error("Cannot compare compound numbers");
		throw new UnsupportedOperationException("Cannot compare compound numbers");
	}

	protected final static String STORE_STATS_ITEM_NAME = STORE_STATS + "=";

	@Override
	public double[] maxItem() {
		final String n = storeName(false, STORE_STATS_ITEM_NAME);
		if (isize < 1)
			return new double[0];
		if (getStoredValue(n+0) == null) {
			calculateSummaryStats(false, false, n);
		}

		double[] results = new double[isize];
		for (int i = 0; i < isize; i++) {
			results[i] = ((SummaryStatistics) storedValues.get(n + i)).getMax();
		}
		return results;
	}

	@Override
	public double[] minItem() {
		final String n = storeName(false, STORE_STATS_ITEM_NAME);
		if (isize < 1)
			return new double[0];
		if (getStoredValue(n+0) == null) {
			calculateSummaryStats(false, false, n);
		}

		double[] results = new double[isize];
		for (int i = 0; i < isize; i++) {
			results[i] = ((SummaryStatistics) storedValues.get(n + i)).getMin();
		}
		return results;
	}

	@Override
	public Object sum() {
		final String n = storeName(false, STORE_STATS_ITEM_NAME);
		if (isize < 1)
			return new double[0];
		if (getStoredValue(n+0) == null) {
			calculateSummaryStats(false, false, n);
		}

		double[] results = new double[isize];
		for (int i = 0; i < isize; i++) {
			results[i] = ((SummaryStatistics) storedValues.get(n + i)).getSum();
		}
		return results;
	}

	@Override
	public Object typedSum(int dtype) {
		return DTypeUtils.fromDoublesToBiggestPrimitives((double[]) sum(), dtype);
	}

	@Override
	public Object mean(boolean... switches) {
		final String n = storeName(false, STORE_STATS_ITEM_NAME);
		if (isize < 1)
			return new double[0];
		if (getStoredValue(n+0) == null) {
			calculateSummaryStats(false, false, n);
		}

		double[] results = new double[isize];
		for (int i = 0; i < isize; i++) {
			results[i] = ((SummaryStatistics) storedValues.get(n + i)).getMean();
		}
		return results;
	}

	@Override
	public Number variance() {
		final String n = storeName(false, STORE_STATS_ITEM_NAME);
		if (isize < 1)
			return Double.NaN;
		if (getStoredValue(n+0) == null) {
			calculateSummaryStats(false, false, n);
		}

		double result = 0;
		for (int i = 0; i < isize; i++)
			result += ((SummaryStatistics) storedValues.get(n + i)).getVariance();
		return result;
	}

	@Override
	public Number rootMeanSquare() {
		final String n = storeName(false, STORE_STATS_ITEM_NAME);
		if (isize < 1)
			return Double.NaN;
		if (getStoredValue(n+0) == null) {
			calculateSummaryStats(false, false, n);
		}

		double result = 0;
		for (int i = 0; i < isize; i++) {
			final SummaryStatistics stats = (SummaryStatistics) storedValues.get(n + i);
			final double mean = stats.getMean();
			result += stats.getVariance() + mean*mean;
		}
		return Math.sqrt(result);
	}

	@Override
	public CompoundDataset getError() {
		Dataset ed = getInternalError();
		if (ed == null)
			return null;

		if (ed.getSize() != size || ed.getElementsPerItem() != isize) {
			CompoundDataset errors = new CompoundDoubleDataset(isize, shape);
			errors.setSlice(ed);
			return errors;
		}
		return (CompoundDataset) ed;
	}

	@Override
	public double getError(final int i) {
		return calcError(getInternalErrorArray(true, i));
	}

	@Override
	public double getError(final int i, final int j) {
		return calcError(getInternalErrorArray(true, i, j));
	}

	@Override
	public double getError(final int... pos) {
		return calcError(getInternalErrorArray(true, pos));
	}

	private double calcError(double[] es) {
		if (es == null)
			return 0;

		// assume elements are independent
		double e = 0;
		for (int k = 0; k < isize; k++) {
			e += es[k];
		}

		return Math.sqrt(e);
	}

	@Override
	public double[] getErrorArray(final int i) {
		return getInternalErrorArray(false, i);
	}

	@Override
	public double[] getErrorArray(final int i, final int j) {
		return getInternalErrorArray(false, i, j);
	}

	@Override
	public double[] getErrorArray(final int... pos) {
		return getInternalErrorArray(false, pos);
	}

	private double[] getInternalErrorArray(final boolean squared, final int i) {
		Dataset sed = squared ? getInternalSquaredError() : getInternalError();
		if (sed == null)
			return null;

		BroadcastStride bs = (BroadcastStride) getStoredValue(STORE_BROADCAST);
		int n = bs.get1DIndex(i);
		double[] es = new double[isize];
		if (sed instanceof CompoundDoubleDataset) {
			((CompoundDoubleDataset) sed).getDoubleArrayAbs(n, es);
			if (sed.getElementsPerItem() != isize) { // ensure error is broadcasted
				Arrays.fill(es, es[0]);
			}
		} else {
			Arrays.fill(es, ((DoubleDataset) sed).getElementDoubleAbs(n));
		}
		return es;
	}

	private double[] getInternalErrorArray(final boolean squared, final int i, final int j) {
		Dataset sed = squared ? getInternalSquaredError() : getInternalError();
		if (sed == null)
			return null;

		BroadcastStride bs = (BroadcastStride) getStoredValue(STORE_BROADCAST);
		int n = bs.get1DIndex(i, j);
		double[] es = new double[isize];
		if (sed instanceof CompoundDoubleDataset) {
			((CompoundDoubleDataset) sed).getDoubleArrayAbs(n, es);
			if (sed.getElementsPerItem() != isize) { // ensure error is broadcasted
				Arrays.fill(es, es[0]);
			}
		} else {
			Arrays.fill(es, ((DoubleDataset) sed).getElementDoubleAbs(n));
		}
		return es;
	}

	private double[] getInternalErrorArray(final boolean squared, final int... pos) {
		Dataset sed = squared ? getInternalSquaredError() : getInternalError();
		if (sed == null)
			return null;

		BroadcastStride bs = (BroadcastStride) getStoredValue(STORE_BROADCAST);
		int n = bs.get1DIndex(pos);
		double[] es = new double[isize];
		if (sed instanceof CompoundDoubleDataset) {
			((CompoundDoubleDataset) sed).getDoubleArrayAbs(n, es);
			if (sed.getElementsPerItem() != isize) { // ensure error is broadcasted
				Arrays.fill(es, es[0]);
			}
		} else {
			Arrays.fill(es, ((DoubleDataset) sed).getElementDoubleAbs(n));
		}
		return es;
	}
}

