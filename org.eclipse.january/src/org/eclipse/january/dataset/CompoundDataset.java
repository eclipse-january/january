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

import org.eclipse.january.IMonitor;

public interface CompoundDataset extends Dataset {

	@Override
	public CompoundDataset cast(boolean repeat, int dtype, int isize);

	@Override
	public CompoundDataset cast(int dtype);

	@Override
	public CompoundDataset clone();

	@Override
	public CompoundDataset fill(Object obj);

	@Override
	public CompoundDataset flatten();

	@Override
	public CompoundDataset getBy1DIndex(IntegerDataset index);

	@Override
	public CompoundDataset getByBoolean(Dataset selection);

	@Override
	public CompoundDataset getByIndexes(Object... indexes);

	@Override
	public CompoundDataset getSlice(IMonitor mon, int[] start, int[] stop, int[] step);

	@Override
	public CompoundDataset getSlice(IMonitor mon, Slice... slice);

	@Override
	public CompoundDataset getSlice(IMonitor mon, SliceND slice);

	@Override
	public CompoundDataset getSlice(int[] start, int[] stop, int[] step);

	@Override
	public CompoundDataset getSlice(Slice... slice);

	@Override
	public CompoundDataset getSlice(SliceND slice);

	@Override
	public CompoundDataset getSliceView(int[] start, int[] stop, int[] step);

	@Override
	public CompoundDataset getSliceView(Slice... slice);

	@Override
	public CompoundDataset getSliceView(SliceND slice);

	@Override
	public CompoundDataset getTransposedView(int... axes);

	@Override
	public CompoundDataset getView(boolean deepCopyMetadata);

	@Override
	public CompoundDataset getBroadcastView(int... shape);

	@Override
	public CompoundDataset iadd(Object o);

	@Override
	public CompoundDataset idivide(Object o);

	@Override
	public CompoundDataset ifloor();

	@Override
	public CompoundDataset ifloorDivide(Object o);

	@Override
	public CompoundDataset imultiply(Object o);

	@Override
	public CompoundDataset ipower(Object o);

	@Override
	public CompoundDataset iremainder(Object o);

	@Override
	public CompoundDataset isubtract(Object o);

	@Override
	public CompoundDataset reshape(int... shape);

	@Override
	public CompoundDataset setBy1DIndex(Object obj, Dataset index);

	@Override
	public CompoundDataset setByBoolean(Object obj, Dataset selection);

	@Override
	public CompoundDataset setByIndexes(Object obj, Object... indexes);

	@Override
	public CompoundDataset setSlice(Object obj, IndexIterator iterator);

	@Override
	public CompoundDataset setSlice(Object obj, int[] start, int[] stop, int[] step);

	@Override
	public CompoundDataset setSlice(Object object, Slice... slice);

	@Override
	public CompoundDataset sort(Integer axis);

	@Override
	public CompoundDataset squeezeEnds();

	@Override
	public CompoundDataset squeeze();

	@Override
	public CompoundDataset squeeze(boolean onlyFromEnd);

	@Override
	public CompoundDataset swapAxes(int axis1, int axis2);

	@Override
	public CompoundDataset synchronizedCopy();

	@Override
	public CompoundDataset transpose(int... axes);

	/**
	 * @since 2.0
	 */
	@Override
	public CompoundDataset max(int axis, boolean... ignoreInvalids);

	/**
	 * @since 2.0
	 */
	@Override
	public CompoundDataset min(int axis, boolean... ignoreInvalids);

	/**
	 * @since 2.0
	 */
	@Override
	public CompoundDataset peakToPeak(int axis, boolean... ignoreInvalids);

	/**
	 * @since 2.0
	 */
	@Override
	public CompoundDataset sum(int axis, boolean... ignoreInvalids);

	/**
	 * @since 2.0
	 */
	@Override
	public CompoundDataset product(int axis, boolean... ignoreInvalids);

	/**
	 * @since 2.0
	 */
	@Override
	public CompoundDataset mean(int axis, boolean... ignoreInvalids);

	/**
	 * @since 2.0
	 */
	@Override
	public CompoundDataset rootMeanSquare(int axis, boolean... ignoreInvalids);

	@Override
	public CompoundDataset stdDeviation(int axis);

	/**
	 * @since 2.0
	 */
	@Override
	public CompoundDataset stdDeviation(int axis, boolean isWholePopulation, boolean... ignoreInvalids);

	@Override
	public CompoundDataset variance(int axis);

	/**
	 * @since 2.0
	 */
	@Override
	public CompoundDataset variance(int axis, boolean isWholePopulation, boolean... ignoreInvalids);

	/**
	 * Get first item as a double array
	 * @param darray double array must be allocated and have sufficient length
	 * @since 2.0
	 */
	public void getDoubleArray(double[] darray);

	/**
	 * Get an item as a double array
	 * @param darray double array must be allocated and have sufficient length
	 * @param i
	 */
	public void getDoubleArray(double[] darray, final int i);

	/**
	 * Get an item as a double array
	 * @param darray double array must be allocated and have sufficient length
	 * @param i
	 * @param j
	 */
	public void getDoubleArray(double[] darray, final int i, final int j);

	/**
	 * Get an item as a double array
	 * @param darray double array must be allocated and have sufficient length
	 * @param pos
	 */
	public void getDoubleArray(double[] darray, final int... pos);

	/**
	 * Get an item as a double array
	 * @param index
	 * @param darray double array must be allocated and have sufficient length
	 */
	public void getDoubleArrayAbs(int index, double[] darray);

	/**
	 * Get chosen elements from each item as a dataset
	 * @param element
	 * @return dataset of chosen elements
	 */
	public Dataset getElements(int element);

	/**
	 * Get chosen elements from each item as a view on dataset
	 * @param element
	 * @return view dataset of chosen elements
	 */
	public Dataset getElementsView(int element);

	/**
	 * Set values of chosen elements from each item according to source dataset
	 * @param source
	 * @param element
	 */
	public void setElements(Dataset source, int element);

	/**
	 * Copy chosen elements from each item to another dataset
	 * @param destination
	 * @param element
	 */
	public void copyElements(Dataset destination, int element);

	/**
	 * Get a non-compound dataset version
	 * @param shareData if true, share data otherwise copy it
	 * @return non-compound dataset
	 */
	public Dataset asNonCompoundDataset(final boolean shareData);

	/**
	 * Calculate maximum values of elements over all items in dataset
	 * @return double array of element-wise maxima
	 */
	public double[] maxItem();

	/**
	 * Calculate minimum values of elements over all items in dataset
	 * @return double array of element-wise minima
	 */
	public double[] minItem();

	/**
	 * @since 2.0
	 */
	@Override
	public CompoundDataset getErrors();

	/**
	 * @return item in first position
	 * @since 2.0
	 */
	public byte[] getByteArray();

	/**
	 * @param i
	 * @return item in given position
	 */
	public byte[] getByteArray(final int i);

	/**
	 * @param i
	 * @param j
	 * @return item in given position
	 */
	public byte[] getByteArray(final int i, final int j);

	/**
	 * @param pos
	 * @return item in given position
	 */
	public byte[] getByteArray(final int... pos);

	/**
	 * @return item in first position
	 * @since 2.0
	 */
	public short[] getShortArray();

	/**
	 * @param i
	 * @return item in given position
	 */
	public short[] getShortArray(final int i);

	/**
	 * @param i
	 * @param j
	 * @return item in given position
	 */
	public short[] getShortArray(final int i, final int j);

	/**
	 * @param pos
	 * @return item in given position
	 */
	public short[] getShortArray(final int... pos);

	/**
	 * @return item in first position
	 * @since 2.0
	 */
	public int[] getIntArray();

	/**
	 * @param i
	 * @return item in given position
	 */
	public int[] getIntArray(final int i);

	/**
	 * @param i
	 * @param j
	 * @return item in given position
	 */
	public int[] getIntArray(final int i, final int j);

	/**
	 * @param pos
	 * @return item in given position
	 * @since 2.0
	 */
	public int[] getIntArray(final int... pos);

	/**
	 * @return item in first position
	 * @since 2.0
	 */
	public long[] getLongArray();

	/**
	 * @param i
	 * @return item in given position
	 */
	public long[] getLongArray(final int i);

	/**
	 * @param i
	 * @param j
	 * @return item in given position
	 */
	public long[] getLongArray(final int i, final int j);

	/**
	 * @param pos
	 * @return item in given position
	 */
	public long[] getLongArray(final int... pos);

	/**
	 * @return item in first position
	 * @since 2.0
	 */
	public float[] getFloatArray();

	/**
	 * @param i
	 * @return item in given position
	 */
	public float[] getFloatArray(final int i);

	/**
	 * @param i
	 * @param j
	 * @return item in given position
	 */
	public float[] getFloatArray(final int i, final int j);

	/**
	 * @param pos
	 * @return item in given position
	 */
	public float[] getFloatArray(final int... pos);

	/**
	 * @return item in first position
	 * @since 2.0
	 */
	public double[] getDoubleArray();

	/**
	 * @param i
	 * @return item in given position
	 */
	public double[] getDoubleArray(final int i);

	/**
	 * @param i
	 * @param j
	 * @return item in given position
	 */
	public double[] getDoubleArray(final int i, final int j);

	/**
	 * @param pos
	 * @return item in given position
	 */
	public double[] getDoubleArray(final int... pos);
}