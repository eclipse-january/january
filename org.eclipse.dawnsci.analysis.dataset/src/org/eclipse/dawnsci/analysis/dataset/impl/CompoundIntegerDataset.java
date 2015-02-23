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

// This is generated from CompoundDoubleDataset.java by fromcpddouble.py

package org.eclipse.dawnsci.analysis.dataset.impl;

import java.util.Arrays;

import org.apache.commons.math3.complex.Complex;
import org.eclipse.dawnsci.analysis.api.dataset.IDataset;
import org.eclipse.dawnsci.analysis.api.dataset.Slice;

/**
 * Extend compound dataset for int values // PRIM_TYPE
 */
public class CompoundIntegerDataset extends AbstractCompoundDataset {
	// pin UID to base class
	private static final long serialVersionUID = Dataset.serialVersionUID;

	protected int[] data; // subclass alias // PRIM_TYPE

	@Override
	protected void setData() {
		data = (int[]) odata; // PRIM_TYPE
	}

	protected int[] createArray(final int size) { // PRIM_TYPE
		int[] array = null; // PRIM_TYPE

		try {
			array = new int[isize * size]; // PRIM_TYPE
		} catch (OutOfMemoryError e) {
			logger.error("The size of the dataset ({}) that is being created is too large "
					+ "and there is not enough memory to hold it.", size);
			throw new OutOfMemoryError("The dimensions given are too large, and there is "
					+ "not enough memory available in the Java Virtual Machine");
		}
		return array;
	}

	@Override
	public int getDtype() {
		return Dataset.ARRAYINT32; // DATA_TYPE
	}

	public CompoundIntegerDataset() {
	}

	public CompoundIntegerDataset(final int itemSize) {
		isize = itemSize;
	}

	/**
	 * Create a zero-filled dataset of given item size and shape
	 * @param itemSize
	 * @param shape
	 */
	public CompoundIntegerDataset(final int itemSize, final int[] shape) {
		isize = itemSize;
		if (shape.length == 1) {
			size = shape[0];
			if (size < 0) {
				throw new IllegalArgumentException("Negative component in shape is not allowed");
			}
		} else {
			size = calcSize(shape);
		}
		this.shape = shape.clone();

		odata = data = createArray(size);
	}

	/**
	 * Copy a dataset
	 * @param dataset
	 */
	public CompoundIntegerDataset(final CompoundIntegerDataset dataset) {
		isize = dataset.isize;

		copyToView(dataset, this, true, true);
		if (dataset.stride == null) {
			odata = data = dataset.data.clone();
		} else {
			offset = 0;
			stride = null;
			base = null;
			odata = data = createArray(size);
			IndexIterator iter = dataset.getIterator();
			for (int j = 0; iter.hasNext();) {
				for (int i = 0; i < isize; i++) {
					data[j++] = dataset.data[iter.index + i];
				}
			}
		}
	}

	/**
	 * Create a dataset using given dataset
	 * @param dataset
	 */
	public CompoundIntegerDataset(final CompoundDataset dataset) {
		copyToView(dataset, this, true, false);
		offset = 0;
		stride = null;
		base = null;
		isize = dataset.getElementsPerItem();
		odata = data = createArray(size);

		IndexIterator iter = dataset.getIterator();
		for (int j = 0; iter.hasNext();) {
			for (int i = 0; i < isize; i++) {
				data[j++] = (int) dataset.getElementLongAbs(iter.index + i); // GET_ELEMENT_WITH_CAST
			}
		}
	}

	/**
	 * Create a dataset using given data (elements are grouped together)
	 * @param itemSize
	 * @param data
	 * @param shape
	 *            (can be null to create 1D dataset)
	 */
	public CompoundIntegerDataset(final int itemSize, final int[] data, int... shape) { // PRIM_TYPE
		isize = itemSize;
		if (shape == null || shape.length == 0) {
			shape = new int[] { data.length / isize };
		}
		size = calcSize(shape);
		if (size * isize != data.length) {
			throw new IllegalArgumentException(String.format("Shape %s is not compatible with size of data array, %d",
					Arrays.toString(shape), data.length / isize));
		}
		this.shape = shape.clone();

		odata = this.data = data;
	}

	/**
	 * Create a dataset using given datasets
	 * @param datasets
	 */
	public CompoundIntegerDataset(final Dataset... datasets) {
		if (datasets.length < 1) {
			throw new IllegalArgumentException("Array of datasets must have length greater than zero");
		}

		for (int i = 1; i < datasets.length; i++)
			datasets[0].checkCompatibility(datasets[i]);

		isize = datasets.length;
		size = calcSize(datasets[0].getShapeRef());
		shape = datasets[0].getShape();

		odata = data = createArray(size);

		IndexIterator[] iters = new IndexIterator[isize];
		for (int i = 0; i < datasets.length; i++)
			iters[i] = datasets[i].getIterator();

		for (int j = 0; iters[0].hasNext();) {
			data[j++] = (int) datasets[0].getElementLongAbs(iters[0].index); // GET_ELEMENT_WITH_CAST
			for (int i = 1; i < datasets.length; i++) {
				iters[i].hasNext();
				data[j++] = (int) datasets[i].getElementLongAbs(iters[i].index); // GET_ELEMENT_WITH_CAST
			}
		}
	}

	/**
	 * Cast a dataset to this compound type. If repeat is set, the first element of each item in the given dataset is
	 * repeated across all elements of an item. Otherwise, each item comprises a truncated or zero-padded copy of
	 * elements from the given dataset.
	 * @param itemSize
	 * @param repeat
	 *            repeat first element
	 * @param dataset
	 */
	public CompoundIntegerDataset(final int itemSize, final boolean repeat, final Dataset dataset) {
		isize = itemSize;
		size = dataset.getSize();
		shape = dataset.getShape();
		name = new String(dataset.getName());

		odata = data = createArray(size);
		final int os = dataset.getElementsPerItem();

		IndexIterator iter = dataset.getIterator();
		if (repeat) {
			int i = 0;
			while (iter.hasNext()) {
				final int v = (int) dataset.getElementLongAbs(iter.index); // PRIM_TYPE // GET_ELEMENT_WITH_CAST
				for (int k = 0; k < isize; k++)
					data[i++] = v;
			}
		} else {
			final int kmax = Math.min(isize, os);
			int i = 0;
			while (iter.hasNext()) {
				for (int k = 0; k < kmax; k++)
					data[i + k] = (int) dataset.getElementLongAbs(iter.index + k); // GET_ELEMENT_WITH_CAST
				i += isize;
			}
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}

		if (getRank() == 0) // already true for zero-rank dataset
			return true;

		CompoundIntegerDataset other = (CompoundIntegerDataset) obj;
		IndexIterator iter = getIterator();
		IndexIterator oiter = other.getIterator();
		while (iter.hasNext() && oiter.hasNext()) {
			for (int j = 0; j < isize; j++) {
				if (data[iter.index+j] != other.data[oiter.index+j])
					return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public CompoundIntegerDataset clone() {
		return new CompoundIntegerDataset(this);
	}

	/**
	 * Create a dataset from an object which could be a Java list, array (of arrays...) or Number. Ragged
	 * sequences or arrays are padded with zeros.
	 *
	 * @param obj
	 * @return dataset with contents given by input
	 */
	public static CompoundIntegerDataset createFromObject(final Object obj) {
		IntegerDataset result = IntegerDataset.createFromObject(obj); // CLASS_TYPE
		return (CompoundIntegerDataset) DatasetUtils.createCompoundDatasetFromLastAxis(result, true);
	}

	/**
	 * @param stop
	 * @return a new 1D dataset, filled with values determined by parameters
	 * @deprecated Use {@link #createRange(int, double)}
	 */
	@Deprecated
	public static CompoundIntegerDataset arange(final int itemSize, final double stop) {
		return createRange(itemSize, 0, stop, 1);
	}

	/**
	 * @param start
	 * @param stop
	 * @param step
	 * @return a new 1D dataset, filled with values determined by parameters
	 * @deprecated Use {@link #createRange(int, double, double, double)}
	 */
	@Deprecated
	public static CompoundIntegerDataset arange(final int itemSize, final double start, final double stop, final double step) {
		return createRange(itemSize, start, stop, step);
	}

	/**
	 * @param stop
	 * @return a new 1D dataset, filled with values determined by parameters
	 */
	public static CompoundIntegerDataset createRange(final int itemSize, final double stop) {
		return createRange(itemSize, 0., stop, 1.);
	}

	/**
	 * @param start
	 * @param stop
	 * @param step
	 * @return a new 1D dataset, filled with values determined by parameters
	 */
	public static CompoundIntegerDataset createRange(final int itemSize, final double start, final double stop,
			final double step) {
		int size = calcSteps(start, stop, step);
		CompoundIntegerDataset result = new CompoundIntegerDataset(itemSize, new int[] { size });
		for (int i = 0; i < size; i++) {
			result.data[i * result.isize] = (int) (start + i * step); // PRIM_TYPE // ADD_CAST
		}
		return result;
	}

	/**
	 * @param shape
	 * @return a dataset filled with ones
	 */
	public static CompoundIntegerDataset ones(final int itemSize, final int... shape) {
		return new CompoundIntegerDataset(itemSize, shape).fill(1);
	}

	/**
	 * Create a compound dataset using last dimension of given dataset
	 * @param a
	 * @param shareData
	 * @return compound dataset
	 */
	public static CompoundIntegerDataset createCompoundDatasetWithLastDimension(final Dataset a, final boolean shareData) {
		if (a.getElementsPerItem() != 1) {
			logger.error("Need a single-element dataset");
			throw new IllegalArgumentException("Need a single-element dataset");
		}
		if (a.getDtype() != Dataset.INT32) { // DATA_TYPE
			logger.error("Dataset type must be int"); // PRIM_TYPE
			throw new IllegalArgumentException("Dataset type must be int"); // PRIM_TYPE
		}

		final int[] shape = a.getShape();
		final int rank = shape.length - 1;
		final int is = rank < 0 ? 1 : shape[rank];

		CompoundIntegerDataset result = new CompoundIntegerDataset(is);

		result.shape = rank > 0 ? Arrays.copyOf(shape, rank) : (rank < 0 ? new int[] {} : new int[] {1});
		result.size = AbstractDataset.calcSize(result.shape);
		result.odata = shareData ? a.getBuffer() : a.clone().getBuffer();
		result.setName(a.getName());
		result.setData();
		return result;
	}

	@Override
	public IntegerDataset asNonCompoundDataset(final boolean shareData) { // CLASS_TYPE
		IntegerDataset result = new IntegerDataset(); // CLASS_TYPE
		final int is = getElementsPerItem();
		final int rank = is == 1 ? shape.length : shape.length + 1;
		final int[] nshape = Arrays.copyOf(shape, rank);
		if (is != 1)
			nshape[rank-1] = is;

		result.shape = nshape;
		result.size = AbstractDataset.calcSize(nshape);
		result.odata = shareData ? data : data.clone();
		result.setName(name);
		result.setData();
		return result;
	}

	@Override
	public CompoundIntegerDataset fill(final Object obj) {
		int[] vr = toIntegerArray(obj, isize); // PRIM_TYPE // CLASS_TYPE
		IndexIterator iter = getIterator();

		while (iter.hasNext()) {
			for (int i = 0; i < isize; i++)
				data[iter.index + i] = vr[i]; // PRIM_TYPE
		}

		setDirty();
		return this;
	}

	/**
	 * This is a typed version of {@link #getBuffer()}
	 * @return data buffer as linear array
	 */
	public int[] getData() { // PRIM_TYPE
		return data;
	}

	@Override
	protected int getBufferLength() {
		if (data == null)
			return 0;
		return data.length;
	}

	@Override
	public CompoundIntegerDataset getView() {
		CompoundIntegerDataset view = new CompoundIntegerDataset(isize);
		copyToView(this, view, true, true);
		view.setData();
		return view;
	}

	/**
	 * Get values at absolute index in the internal array. This is an internal method with no checks so can be
	 * dangerous. Use with care or ideally with an iterator.
	 *
	 * @param index
	 *            absolute index
	 * @return values
	 */
	public int[] getAbs(final int index) { // PRIM_TYPE
		int[] result = new int[isize]; // PRIM_TYPE
		for (int i = 0; i < isize; i++)
			result[i] = data[index + i];
		return result;
	}

	/**
	 * Get values at absolute index in the internal array. This is an internal method with no checks so can be
	 * dangerous. Use with care or ideally with an iterator.
	 *
	 * @param index
	 *            absolute index
	 * @param values
	 */
	public void getAbs(final int index, final int[] values) { // PRIM_TYPE
		for (int i = 0; i < isize; i++)
			values[i] = data[index + i];
	}

	@Override
	public boolean getElementBooleanAbs(final int index) {
		for (int i = 0; i < isize; i++) {
			if (data[index + i] == 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public double getElementDoubleAbs(final int index) {
		return data[index];
	}

	@Override
	public long getElementLongAbs(final int index) {
		return data[index]; // OMIT_CAST_INT
	}

	@Override
	protected void setItemDirect(final int dindex, final int sindex, final Object src) {
		int[] dsrc = (int[]) src; // PRIM_TYPE
		for (int i = 0; i < isize; i++)
			data[dindex + i] = dsrc[sindex + i];
	}

	/**
	 * Set values at absolute index in the internal array. This is an internal method with no checks so can be
	 * dangerous. Use with care or ideally with an iterator.
	 *
	 * @param index
	 *            absolute index
	 * @param val
	 *            new values
	 */
	public void setAbs(final int index, final int[] val) { // PRIM_TYPE
		for (int i = 0; i < isize; i++)
			data[index + i] = val[i];
		setDirty();
	}

	/**
	 * Set element value at absolute index in the internal array. This is an internal method with no checks so can be
	 * dangerous. Use with care or ideally with an iterator.
	 *
	 * @param index
	 *            absolute index
	 * @param val
	 *            new value
	 */
	public void setAbs(final int index, final int val) { // PRIM_TYPE
		data[index] = val;
		setDirty();
	}

	@Override
	public Object getObject(final int i) {
		return getIntArray(i); // PRIM_TYPE
	}

	@Override
	public Object getObject(final int i, final int j) {
		return getIntArray(i, j); // PRIM_TYPE
	}

	@Override
	public Object getObject(final int... pos) {
		return getIntArray(pos); // PRIM_TYPE
	}

	@Override
	public byte[] getByteArray(final int i) {
		byte[] result = new byte[isize];
		int index = get1DIndex(i);
		for (int k = 0; k < isize; k++)
			result[k] = (byte) data[index + k]; // OMIT_UPCAST
		return result;
	}

	@Override
	public byte[] getByteArray(final int i, final int j) {
		byte[] result = new byte[isize];
		int index = get1DIndex(i, j);
		for (int k = 0; k < isize; k++)
			result[k] = (byte) data[index + k]; // OMIT_UPCAST
		return result;
	}

	@Override
	public byte[] getByteArray(final int... pos) {
		byte[] result = new byte[isize];
		int index = get1DIndex(pos);
		for (int k = 0; k < isize; k++)
			result[k] = (byte) data[index + k]; // OMIT_UPCAST
		return result;
	}

	@Override
	public short[] getShortArray(final int i) {
		short[] result = new short[isize];
		int index = get1DIndex(i);
		for (int k = 0; k < isize; k++)
			result[k] = (short) data[index + k]; // OMIT_UPCAST
		return result;
	}

	@Override
	public short[] getShortArray(final int i, final int j) {
		short[] result = new short[isize];
		int index = get1DIndex(i, j);
		for (int k = 0; k < isize; k++)
			result[k] = (short) data[index + k]; // OMIT_UPCAST
		return result;
	}

	@Override
	public short[] getShortArray(final int... pos) {
		short[] result = new short[isize];
		int index = get1DIndex(pos);
		for (int k = 0; k < isize; k++)
			result[k] = (short) data[index + k]; // OMIT_UPCAST
		return result;
	}

	@Override
	public int[] getIntArray(final int i) {
		int[] result = new int[isize];
		int index = get1DIndex(i);
		for (int k = 0; k < isize; k++)
			result[k] = data[index + k]; // OMIT_UPCAST
		return result;
	}

	@Override
	public int[] getIntArray(final int i, final int j) {
		int[] result = new int[isize];
		int index = get1DIndex(i, j);
		for (int k = 0; k < isize; k++)
			result[k] = data[index + k]; // OMIT_UPCAST
		return result;
	}

	@Override
	public int[] getIntArray(final int... pos) {
		int[] result = new int[isize];
		int index = get1DIndex(pos);
		for (int k = 0; k < isize; k++)
			result[k] = data[index + k]; // OMIT_UPCAST
		return result;
	}

	@Override
	public long[] getLongArray(final int i) {
		long[] result = new long[isize];
		int index = get1DIndex(i);
		for (int k = 0; k < isize; k++)
			result[k] = data[index + k]; // OMIT_UPCAST
		return result;
	}

	@Override
	public long[] getLongArray(final int i, final int j) {
		long[] result = new long[isize];
		int index = get1DIndex(i, j);
		for (int k = 0; k < isize; k++)
			result[k] = data[index + k]; // OMIT_UPCAST
		return result;
	}

	@Override
	public long[] getLongArray(final int... pos) {
		long[] result = new long[isize];
		int index = get1DIndex(pos);
		for (int k = 0; k < isize; k++)
			result[k] = data[index + k]; // OMIT_UPCAST
		return result;
	}

	@Override
	public float[] getFloatArray(final int i) {
		float[] result = new float[isize];
		int index = get1DIndex(i);
		for (int k = 0; k < isize; k++)
			result[k] = data[index + k]; // OMIT_REAL_CAST
		return result;
	}

	@Override
	public float[] getFloatArray(final int i, final int j) {
		float[] result = new float[isize];
		int index = get1DIndex(i, j);
		for (int k = 0; k < isize; k++)
			result[k] = data[index + k]; // OMIT_REAL_CAST
		return result;
	}

	@Override
	public float[] getFloatArray(final int... pos) {
		float[] result = new float[isize];
		int index = get1DIndex(pos);
		for (int k = 0; k < isize; k++)
			result[k] = data[index + k]; // OMIT_REAL_CAST
		return result;
	}

	@Override
	public double[] getDoubleArray(final int i) {
		double[] result = new double[isize];
		int index = get1DIndex(i);
		for (int k = 0; k < isize; k++)
			result[k] = data[index + k]; // OMIT_REAL_CAST
		return result;
	}

	@Override
	public double[] getDoubleArray(final int i, final int j) {
		double[] result = new double[isize];
		int index = get1DIndex(i, j);
		for (int k = 0; k < isize; k++)
			result[k] = data[index + k]; // OMIT_REAL_CAST
		return result;
	}

	@Override
	public double[] getDoubleArray(final int... pos) {
		double[] result = new double[isize];
		int index = get1DIndex(pos);
		for (int k = 0; k < isize; k++)
			result[k] = data[index + k]; // OMIT_REAL_CAST
		return result;
	}

	@Override
	public void getDoubleArrayAbs(final int index, final double[] darray) {
		for (int i = 0; i < isize; i++)
			darray[i] = data[index + i];
	}

	@Override
	public String getString(final int i) {
		return getStringAbs(get1DIndex(i));
	}

	@Override
	public String getString(final int i, final int j) {
		return getStringAbs(get1DIndex(i, j));
	}

	@Override
	public String getString(final int... pos) {
		return getStringAbs(get1DIndex(pos));
	}

	@Override
	protected double getFirstValue(int i) {
		return data[get1DIndex(i)];
	}

	@Override
	protected double getFirstValue(int i, int j) {
		return data[get1DIndex(i, j)];
	}

	@Override
	protected double getFirstValue(final int... pos) {
		return data[get1DIndex(pos)];
	}

	@Override
	public Object getObjectAbs(final int index) {
		int[] result = new int[isize]; // PRIM_TYPE
		for (int i = 0; i < isize; i++)
			result[i] = data[index + i];
		return result;
	}

	@Override
	public String getStringAbs(final int index) {
		StringBuilder s = new StringBuilder();
		s.append('(');
		s.append(stringFormat == null ? String.format("%d", data[index]) : // FORMAT_STRING
			stringFormat.format(data[index]));
		for (int i = 1; i < isize; i++) {
			s.append(' ');
			s.append(stringFormat == null ? String.format("%d", data[index + i]) : // FORMAT_STRING
				stringFormat.format(data[index + i]));
		}
		s.append(')');
		return s.toString();
	}

	@Override
	public void setObjectAbs(final int index, final Object obj) {
		int[] oa = toIntegerArray(obj, isize); // PRIM_TYPE // CLASS_TYPE
		setAbs(index, oa);
	}

	@Override
	public void set(final Object obj, final int i) {
		setItem(toIntegerArray(obj, isize), i); // CLASS_TYPE
	}

	@Override
	public void set(final Object obj, final int i, final int j) {
		setItem(toIntegerArray(obj, isize), i, j); // CLASS_TYPE
	}

	@Override
	public void set(final Object obj, int... pos) {
		if (pos == null || (pos.length == 0 && shape.length > 0)) {
			pos = new int[shape.length];
		}

		setItem(toIntegerArray(obj, isize), pos); // CLASS_TYPE
	}

	/**
	 * Set values at given position. The dataset must be 1D
	 *
	 * @param d
	 * @param i
	 */
	public void setItem(final int[] d, final int i) { // PRIM_TYPE
		if (d.length > isize) {
			throw new IllegalArgumentException("Array is larger than number of elements in an item");
		}
		setAbs(get1DIndex(i), d);
	}

	/**
	 * Set values at given position. The dataset must be 1D
	 *
	 * @param d
	 * @param i
	 * @param j
	 */
	public void setItem(final int[] d, final int i, final int j) { // PRIM_TYPE
		if (d.length > isize) {
			throw new IllegalArgumentException("Array is larger than number of elements in an item");
		}
		setAbs(get1DIndex(i, j), d);
	}

	/**
	 * Set values at given position
	 *
	 * @param d
	 * @param pos
	 */
	public void setItem(final int[] d, final int... pos) { // PRIM_TYPE
		if (d.length > isize) {
			throw new IllegalArgumentException("Array is larger than number of elements in an item");
		}
		setAbs(get1DIndex(pos), d);
	}

	private void setDoubleArrayAbs(final int index, final double[] d) {
		for (int i = 0; i < isize; i++)
			data[index + i] = (int) d[i]; // ADD_CAST
	}

	@Override
	public void resize(int... newShape) {
		IndexIterator iter = getIterator();
		int nsize = calcSize(newShape);
		int[] ndata = createArray(nsize); // PRIM_TYPE

		int i = 0;
		while (iter.hasNext() && i < nsize) {
			for (int j = 0; j < isize; j++) {
				ndata[i++] = data[iter.index + j];
			}
		}

		odata = data = ndata;
		size = nsize;
		shape = newShape;
		stride = null;
		offset = 0;
		base = null;
	}

	@Override
	public IntegerDataset real() { // CLASS_TYPE
		IntegerDataset rdataset = new IntegerDataset(shape); // CLASS_TYPE
		IndexIterator iter = getIterator();
		IndexIterator riter = rdataset.getIterator();

		int[] rdata = rdataset.data; // PRIM_TYPE
		while (iter.hasNext() && riter.hasNext())
			rdata[riter.index] = data[iter.index];

		return rdataset;
	}

	@Override
	public Dataset realView() {
		return getElementsView(0);
	}

	@Override
	public CompoundIntegerDataset getSlice(final SliceIterator siter) {
		CompoundIntegerDataset result = new CompoundIntegerDataset(isize, siter.getShape());
		int[] rdata = result.data; // PRIM_TYPE
		IndexIterator riter = result.getIterator();

		while (siter.hasNext() && riter.hasNext()) {
			for (int i = 0; i < isize; i++)
				rdata[riter.index + i] = data[siter.index + i];
		}

		result.setName(name + BLOCK_OPEN + Slice.createString(siter.shape, siter.start, siter.stop, siter.step) + BLOCK_CLOSE);
		return result;
	}

	@Override
	public IntegerDataset getElementsView(int element) { // CLASS_TYPE
		if (element < 0)
			element += isize;
		if (element < 0 || element > isize) {
			throw new IllegalArgumentException(String.format("Invalid choice of element: %d/%d", element, isize));
		}

		IntegerDataset view = new IntegerDataset(shape); // CLASS_TYPE

		copyToView(this, view, true, true);
		view.setData();
		if (view.stride == null) {
			int[] offset = new int[1];
			view.stride = createStrides(this, offset);
			view.offset = offset[0] + element;
			view.base = base == null ? this : base;
		} else {
			view.offset += element;
		}

		return view;
	}

	@Override
	public IntegerDataset getElements(int element) { // CLASS_TYPE
		final IntegerDataset elements = new IntegerDataset(shape); // CLASS_TYPE

		copyElements(elements, element);
		return elements;
	}

	@Override
	public void copyElements(Dataset destination, int element) {
		if (element < 0)
			element += isize;
		if (element < 0 || element > isize) {
			throw new IllegalArgumentException(String.format("Invalid choice of element: %d/%d", element, isize));
		}
		if (elementClass() != destination.elementClass()) {
			throw new IllegalArgumentException("Element class of destination does not match this dataset");
		}

		final IndexIterator it = getIterator(element);
		final int[] elements = ((IntegerDataset) destination).data; // CLASS_TYPE // PRIM_TYPE

		int n = 0;
		while (it.hasNext()) {
			elements[n] = data[it.index];
			n++;
		}
	}

	@Override
	public void setElements(Dataset source, int element) {
		if (element < 0)
			element += isize;
		if (element < 0 || element > isize) {
			throw new IllegalArgumentException(String.format("Invalid choice of element: %d/%d", element, isize));
		}
		if (elementClass() != source.elementClass()) {
			throw new IllegalArgumentException("Element class of destination does not match this dataset");
		}

		final IndexIterator it = getIterator(element);
		final int[] elements = ((IntegerDataset) source).data; // CLASS_TYPE // PRIM_TYPE

		int n = 0;
		while (it.hasNext()) {
			data[it.index] = elements[n];
			n++;
		}
		setDirty();
	}

	@Override
	public void fillDataset(Dataset result, IndexIterator iter) {
		IndexIterator riter = result.getIterator();

		int[] rdata = ((CompoundIntegerDataset) result).data; // PRIM_TYPE

		while (riter.hasNext() && iter.hasNext()) {
			for (int i = 0; i < isize; i++)
				rdata[riter.index + i] = data[iter.index + i];
		}
	}

	@Override
	public CompoundIntegerDataset setByBoolean(final Object o, Dataset selection) {
		if (o instanceof Dataset) {
			Dataset ds = (Dataset) o;
			final int length = ((Number) selection.sum()).intValue();
			if (length != ds.getSize()) {
				throw new IllegalArgumentException(
						"Number of true items in selection does not match number of items in dataset");
			}

			IndexIterator iter = ds.getIterator();
			BooleanIterator biter = getBooleanIterator(selection);

			if (ds instanceof AbstractCompoundDataset) {
				if (isize != ds.getElementsPerItem()) {
					throw new IllegalArgumentException("Input dataset is not compatible with slice");
				}

				while (biter.hasNext() && iter.hasNext()) {
					for (int i = 0; i < isize; i++)
						data[biter.index + i] = (int) ds.getElementLongAbs(iter.index + i); // GET_ELEMENT_WITH_CAST
				}
			} else {
				while (biter.hasNext() && iter.hasNext()) {
					data[biter.index] = (int) ds.getElementLongAbs(iter.index); // GET_ELEMENT_WITH_CAST
					for (int i = 1; i < isize; i++)
						data[biter.index + i] = 0;
				}
			}
		} else {
			try {
				final int[] vr = toIntegerArray(o, isize); // PRIM_TYPE // CLASS_TYPE

				final BooleanIterator biter = getBooleanIterator(selection);

				while (biter.hasNext()) {
					for (int i = 0; i < isize; i++)
						data[biter.index + i] = vr[i];
				}
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException("Object for setting is not a dataset or number");
			}
		}
		setDirty();
		return this;
	}

	@Override
	public CompoundIntegerDataset setBy1DIndex(final Object o, Dataset index) {
		if (o instanceof Dataset) {
			Dataset ds = (Dataset) o;
			if (index.getSize() != ds.getSize()) {
				throw new IllegalArgumentException(
						"Number of items in selection does not match number of items in dataset");
			}

			IndexIterator oiter = ds.getIterator();
			final IntegerIterator iter = new IntegerIterator(index, size, isize);

			if (ds instanceof AbstractCompoundDataset) {
				if (isize != ds.getElementsPerItem()) {
					throw new IllegalArgumentException("Input dataset is not compatible with slice");
				}

				double[] temp = new double[isize];
				while (iter.hasNext() && oiter.hasNext()) {
					((AbstractCompoundDataset) ds).getDoubleArrayAbs(oiter.index, temp);
					setDoubleArrayAbs(iter.index, temp);
				}
				while (iter.hasNext() && oiter.hasNext()) {
					for (int i = 0; i < isize; i++)
						data[iter.index + i] = (int) ds.getElementLongAbs(oiter.index + i); // GET_ELEMENT_WITH_CAST
				}
			} else {
				while (iter.hasNext() && oiter.hasNext()) {
					data[iter.index] = (int) ds.getElementLongAbs(oiter.index); // GET_ELEMENT_WITH_CAST
					for (int i = 1; i < isize; i++)
						data[iter.index + i] = 0;
				}
			}
		} else {
			try {
				final int[] vr = toIntegerArray(o, isize); // PRIM_TYPE // CLASS_TYPE

				final IntegerIterator iter = new IntegerIterator(index, size, isize);

				while (iter.hasNext()) {
					setAbs(iter.index, vr);
				}
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException("Object for setting is not a dataset or number");
			}
		}
		setDirty();
		return this;
	}

	@Override
	public CompoundIntegerDataset setByIndexes(final Object o, final Object... indexes) {
		final IntegersIterator iter = new IntegersIterator(shape, indexes);
		final int[] pos = iter.getPos();

		if (o instanceof Dataset) {
			Dataset ds = (Dataset) o;
			if (calcSize(iter.getShape()) != ds.getSize()) {
				throw new IllegalArgumentException(
						"Number of items in selection does not match number of items in dataset");
			}

			IndexIterator oiter = ds.getIterator();

			if (ds instanceof AbstractCompoundDataset) {
				if (isize != ds.getElementsPerItem()) {
					throw new IllegalArgumentException("Input dataset is not compatible with slice");
				}

				double[] temp = new double[isize];
				while (iter.hasNext() && oiter.hasNext()) {
					((AbstractCompoundDataset) ds).getDoubleArray(temp, pos);
					setDoubleArrayAbs(get1DIndex(pos), temp);
				}
			} else {
				while (iter.hasNext() && oiter.hasNext()) {
					int n = get1DIndex(pos);
					data[n] = (int) ds.getElementLongAbs(oiter.index); // GET_ELEMENT_WITH_CAST
					for (int i = 1; i < isize; i++)
						data[n + i] = 0;
				}
			}
		} else {
			try {
				final int[] vr = toIntegerArray(o, isize); // PRIM_TYPE // CLASS_TYPE

				while (iter.hasNext()) {
					setAbs(get1DIndex(pos), vr);
				}
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException("Object for setting is not a dataset or number");
			}
		}
		setDirty();
		return this;
	}

	@Override
	CompoundIntegerDataset setSlicedView(Dataset view, Dataset d) {
		BroadcastIterator it = new BroadcastIterator(view, d);

		final int is = view.getElementsPerItem();

		if (is > 1) {
			if (d.getElementsPerItem() == 1) {
				while (it.hasNext()) {
					final int bv = (int) it.bDouble; // PRIM_TYPE // ADD_CAST
					data[it.aIndex] = bv;
					for (int j = 1; j < is; j++) {
						data[it.aIndex + j] = bv;
					}
				}
			} else {
				while (it.hasNext()) {
					data[it.aIndex] = (int) it.bDouble; // ADD_CAST
					for (int j = 1; j < is; j++) {
						data[it.aIndex + j] = (int) d.getElementLongAbs(it.bIndex + j); // GET_ELEMENT_WITH_CAST
					}
				}
			}
		} else {
			while (it.hasNext()) {
				data[it.aIndex] = (int) it.bDouble; // ADD_CAST
			}
		}
		return this;
	}

	@Override
	public CompoundIntegerDataset setSlice(final Object o, final IndexIterator siter) {
		if (o instanceof IDataset) {
			final IDataset ds = (IDataset) o;
			final int[] oshape = ds.getShape();

			if (!areShapesCompatible(siter.getShape(), oshape)) {
				throw new IllegalArgumentException(String.format(
						"Input dataset is not compatible with slice: %s cf %s", Arrays.toString(oshape),
						Arrays.toString(siter.getShape())));
			}

			if (ds instanceof Dataset) {
				final Dataset ads = (Dataset) ds;
				IndexIterator oiter = ads.getIterator();

				if (ds instanceof AbstractCompoundDataset) {
					if (isize != ads.getElementsPerItem()) {
						throw new IllegalArgumentException("Input dataset is not compatible with slice");
					}

					while (siter.hasNext() && oiter.hasNext()) {
						for (int i = 0; i < isize; i++)
							data[siter.index + i] = (int) ads.getElementLongAbs(oiter.index + i); // GET_ELEMENT_WITH_CAST
					}
				} else {
					while (siter.hasNext() && oiter.hasNext()) {
						data[siter.index] = (int) ads.getElementLongAbs(oiter.index); // GET_ELEMENT_WITH_CAST
						for (int i = 1; i < isize; i++)
							data[siter.index + i] = 0;
					}
				}
			} else {
				final IndexIterator oiter = new PositionIterator(oshape);
				final int[] pos = oiter.getPos();

				if (ds.getElementsPerItem() == 1) {
					while (siter.hasNext() && oiter.hasNext()) {
						data[siter.index] = ds.getInt(pos); // PRIM_TYPE
						for (int i = 1; i < isize; i++)
							data[siter.index + i] = 0;
					}
				} else {
					while (siter.hasNext() && oiter.hasNext()) {
						final int[] val = toIntegerArray(ds.getObject(pos), isize); // PRIM_TYPE // CLASS_TYPE
						for (int i = 0; i < isize; i++)
							data[siter.index + i] = val[i];
					}
				}
			}
		} else {
			try {
				final int[] vr = toIntegerArray(o, isize); // PRIM_TYPE // CLASS_TYPE

				while (siter.hasNext()) {
					for (int i = 0; i < isize; i++)
						data[siter.index + i] = vr[i];
				}
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException("Object for setting slice is not a dataset or number");
			}
		}
		setDirty();
		return this;
	}

	@Override
	public void copyItemsFromAxes(final int[] pos, final boolean[] axes, final Dataset dest) {
		int[] ddata = (int[]) dest.getBuffer(); // PRIM_TYPE

		if (dest.getElementsPerItem() != isize) {
			throw new IllegalArgumentException(String.format(
					"Destination dataset is incompatible as it has %d elements per item not %d",
					dest.getElementsPerItem(), isize));
		}

		SliceIterator siter = getSliceIteratorFromAxes(pos, axes);
		int[] sshape = squeezeShape(siter.getShape(), false);

		IndexIterator diter = dest.getSliceIterator(null, sshape, null);

		if (ddata.length < calcSize(sshape)) {
			throw new IllegalArgumentException("destination array is not large enough");
		}

		while (siter.hasNext() && diter.hasNext()) {
			for (int i = 0; i < isize; i++)
				ddata[diter.index + i] = data[siter.index + i];
		}
	}

	@Override
	public void setItemsOnAxes(final int[] pos, final boolean[] axes, final Object src) {
		int[] sdata = (int[]) src; // PRIM_TYPE

		SliceIterator siter = getSliceIteratorFromAxes(pos, axes);

		if (sdata.length < calcSize(siter.getShape())) {
			throw new IllegalArgumentException("source array is not large enough");
		}

		for (int i = 0; siter.hasNext(); i++) {
			for (int j = 0; j < isize; j++)
				data[siter.index + j] = sdata[isize * i + j];
		}

		setDirty();
	}

	@Override
	public boolean containsNans() {
		return false;
	}

	@Override
	public boolean containsInfs() {
		return false;
	}

	@Override
	public boolean containsInvalidNumbers() {
		return false;
	}

	@Override
	public CompoundIntegerDataset iadd(final Object b) {
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		int is = bds.getElementsPerItem();
		if (bds.getSize() == 1) {
			final IndexIterator it = getIterator();
			if (is == 1) {
				final double db = bds.getElementDoubleAbs(0);
				while (it.hasNext()) {
					for (int i = 0; i < isize; i++) {
						data[it.index + i] += db;
					}
				}
			} else if (is == isize) {
				while (it.hasNext()) {
					for (int i = 0; i < isize; i++) {
						data[it.index + i] += bds.getElementDoubleAbs(i);
					}
				}
			} else {
				throw new IllegalArgumentException("Argument does not have same number of elements per item or is not a non-compound dataset");
			}
		} else {
			final BroadcastIterator it = new BroadcastIterator(this, bds);
			it.setOutputDouble(true);
			if (is == 1) {
				while (it.hasNext()) {
					final double db = it.bDouble;
					data[it.aIndex] += db;
					for (int i = 1; i < isize; i++) {
						data[it.aIndex + i] += db;
					}
				}
			} else if (is == isize) {
				while (it.hasNext()) {
					data[it.aIndex] += it.bDouble;
					for (int i = 1; i < isize; i++) {
						data[it.aIndex + i] += bds.getElementDoubleAbs(it.bIndex + i);
					}
				}
			} else {
				throw new IllegalArgumentException("Argument does not have same number of elements per item or is not a non-compound dataset");
			}
		}
		setDirty();
		return this;
	}

	@Override
	public CompoundIntegerDataset isubtract(final Object b) {
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		int is = bds.getElementsPerItem();
		if (bds.getSize() == 1) {
			final IndexIterator it = getIterator();
			if (is == 1) {
				final double db = bds.getElementDoubleAbs(0);
				while (it.hasNext()) {
					for (int i = 0; i < isize; i++) {
						data[it.index + i] -= db;
					}
				}
			} else if (is == isize) {
				while (it.hasNext()) {
					for (int i = 0; i < isize; i++) {
						data[it.index + i] -= bds.getElementDoubleAbs(i);
					}
				}
			} else {
				throw new IllegalArgumentException("Argument does not have same number of elements per item or is not a non-compound dataset");
			}
		} else {
			final BroadcastIterator it = new BroadcastIterator(this, bds);
			it.setOutputDouble(true);
			if (is == 1) {
				while (it.hasNext()) {
					final double db = it.bDouble;
					for (int i = 0; i < isize; i++) {
						data[it.aIndex + i] -= db;
					}
				}
			} else if (is == isize) {
				while (it.hasNext()) {
					data[it.aIndex] -= it.bDouble;
					for (int i = 1; i < isize; i++) {
						data[it.aIndex + i] -= bds.getElementDoubleAbs(it.bIndex + i);
					}
				}
			} else {
				throw new IllegalArgumentException("Argument does not have same number of elements per item or is not a non-compound dataset");
			}
		}
		setDirty();
		return this;
	}

	@Override
	public CompoundIntegerDataset imultiply(final Object b) {
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		int is = bds.getElementsPerItem();
		if (bds.getSize() == 1) {
			final IndexIterator it = getIterator();
			if (is == 1) {
				final double db = bds.getElementDoubleAbs(0);
				while (it.hasNext()) {
					for (int i = 0; i < isize; i++) {
						data[it.index + i] *= db;
					}
				}
			} else if (is == isize) {
				while (it.hasNext()) {
					for (int i = 0; i < isize; i++) {
						data[it.index + i] *= bds.getElementDoubleAbs(i);
					}
				}
			} else {
				throw new IllegalArgumentException("Argument does not have same number of elements per item or is not a non-compound dataset");
			}
		} else {
			final BroadcastIterator it = new BroadcastIterator(this, bds);
			it.setOutputDouble(true);
			if (is == 1) {
				while (it.hasNext()) {
					final double db = it.bDouble;
					for (int i = 0; i < isize; i++) {
						data[it.aIndex + i] *= db;
					}
				}
			} else if (is == isize) {
				while (it.hasNext()) {
					data[it.aIndex] *= it.bDouble;
					for (int i = 1; i < isize; i++) {
						data[it.aIndex + i] *= bds.getElementDoubleAbs(it.bIndex + i);
					}
				}
			} else {
				throw new IllegalArgumentException("Argument does not have same number of elements per item or is not a non-compound dataset");
			}
		}
		setDirty();
		return this;
	}

	@Override
	public CompoundIntegerDataset idivide(final Object b) {
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		int is = bds.getElementsPerItem();
		if (bds.getSize() == 1) {
			final IndexIterator it = getIterator();
			if (is == 1) {
				final double db = bds.getElementDoubleAbs(0);
				if (db == 0) { // INT_USE
					fill(0); // INT_USE
				} else { // INT_USE
				while (it.hasNext()) {
					for (int i = 0; i < isize; i++) {
						data[it.index + i] /= db;
					}
				}
				} // INT_USE
			} else if (is == isize) {
				while (it.hasNext()) {
					for (int i = 0; i < isize; i++) {
						final double db = bds.getElementDoubleAbs(i);
				try {
							data[it.index + i] /= db; // INT_EXCEPTION
				} catch (ArithmeticException e) {
					data[it.index + i] = 0;
				}
					}
				}
			} else {
				throw new IllegalArgumentException("Argument does not have same number of elements per item or is not a non-compound dataset");
			}
		} else {
			final BroadcastIterator it = new BroadcastIterator(this, bds);
			it.setOutputDouble(true);
			if (is == 1) {
				while (it.hasNext()) {
					final double db = it.bDouble;
					if (db == 0) { // INT_USE
						for (int i = 0; i < isize; i++) { // INT_USE
							data[it.aIndex + i] = 0; // INT_USE
						}// INT_USE
					} else { // INT_USE
					for (int i = 0; i < isize; i++) {
						data[it.aIndex + i] /= db;
					}
					} // INT_USE
				}
			} else if (is == isize) {
				while (it.hasNext()) {
					for (int i = 0; i < isize; i++) {
						final double db = bds.getElementDoubleAbs(it.bIndex + i);
				try {
							data[it.aIndex + i] /= db; // INT_EXCEPTION
				} catch (ArithmeticException e) {
					data[it.aIndex + i] = 0;
				}
					}
				}
			} else {
				throw new IllegalArgumentException("Argument does not have same number of elements per item or is not a non-compound dataset");
			}
		}
		setDirty();
		return this;
	}

	@Override
	public CompoundIntegerDataset ifloor() {
		return this;
	}

	@Override
	public CompoundIntegerDataset iremainder(final Object b) {
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		int is = bds.getElementsPerItem();
		if (bds.getSize() == 1) {
			final IndexIterator it = getIterator();
			if (is == 1) {
				final double db = bds.getElementDoubleAbs(0);
				if (db == 0) { // INT_USE
					fill(0); // INT_USE
				} else { // INT_USE
				while (it.hasNext()) {
					for (int i = 0; i < isize; i++) {
						data[it.index + i] %= db;
					}
				}
				} // INT_USE
			} else if (is == isize) {
				while (it.hasNext()) {
					for (int i = 0; i < isize; i++) {
				try {
							data[it.index + i] %= bds.getElementDoubleAbs(i); // INT_EXCEPTION
				} catch (ArithmeticException e) {
					data[it.index + i] = 0;
				}
					}
				}
			} else {
				throw new IllegalArgumentException("Argument does not have same number of elements per item or is not a non-compound dataset");
			}
		} else {
			final BroadcastIterator it = new BroadcastIterator(this, bds);
			it.setOutputDouble(true);
			if (is == 1) {
				while (it.hasNext()) {
					final double db = it.bDouble;
					if (db == 0) { // INT_USE
						for (int i = 0; i < isize; i++) // INT_USE
							data[it.aIndex + i] = 0; // INT_USE
					} else { // INT_USE
					for (int i = 0; i < isize; i++)
						data[it.aIndex + i] %= db;
					} // INT_USE
				}
			} else if (is == isize) {
				while (it.hasNext()) {
					for (int i = 0; i < isize; i++) {
						final double db = bds.getElementDoubleAbs(it.bIndex + i);
				try {
							data[it.aIndex + i] %= db; // INT_EXCEPTION
				} catch (ArithmeticException e) {
					data[it.aIndex + i] = 0;
				}
					}
				}
			} else {
				throw new IllegalArgumentException("Argument does not have same number of elements per item or is not a non-compound dataset");
			}
		}
		setDirty();
		return this;
	}

	@Override
	public CompoundIntegerDataset ipower(final Object b) {
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		final int is = bds.getElementsPerItem();
		if (bds.getSize() == 1) {
			final double vr = bds.getElementDoubleAbs(0);
			final IndexIterator it = getIterator();
			if (bds.isComplex()) {
				final double vi = bds.getElementDoubleAbs(1);
				if (vi == 0.) {
					while (it.hasNext()) {
						for (int i = 0; i < isize; i++) {
							final double v = Math.pow(data[it.index + i], vr);
							if (Double.isInfinite(v) || Double.isNaN(v)) { // INT_USE
								data[it.index + i] = 0; // INT_USE
							} else { // INT_USE
							data[it.index + i] = (int) (long) v; // PRIM_TYPE_LONG // ADD_CAST
							} // INT_USE
						}
					}
				} else {
					final Complex zv = new Complex(vr, vi);
					while (it.hasNext()) {
						for (int i = 0; i < isize; i++) {
							Complex zd = new Complex(data[it.index + i], 0.);
							final double v = zd.pow(zv).getReal();
							if (Double.isInfinite(v) || Double.isNaN(v)) { // INT_USE
								data[it.index + i] = 0; // INT_USE
							} else { // INT_USE
							data[it.index + i] = (int) (long) v; // PRIM_TYPE_LONG // ADD_CAST
							} // INT_USE
						}
					}
				}
			} else if (is == 1) {
				while (it.hasNext()) {
					for (int i = 0; i < isize; i++) {
						final double v = Math.pow(data[it.index + i], vr);
						if (Double.isInfinite(v) || Double.isNaN(v)) { // INT_USE
							data[it.index + i] = 0; // INT_USE
						} else { // INT_USE
						data[it.index + i] = (int) (long) v; // PRIM_TYPE_LONG // ADD_CAST
						} // INT_USE
					}
				}
			} else if (is == isize) {
				while (it.hasNext()) {
					for (int i = 0; i < isize; i++) {
						final double v = Math.pow(data[it.index + i], bds.getElementDoubleAbs(i));
						if (Double.isInfinite(v) || Double.isNaN(v)) { // INT_USE
							data[it.index + i] = 0; // INT_USE
						} else { // INT_USE
						data[it.index + i] = (int) (long) v; // PRIM_TYPE_LONG // ADD_CAST
						} // INT_USE
					}
				}
			}
		} else {
			final BroadcastIterator it = new BroadcastIterator(this, bds);
			it.setOutputDouble(true);
			while (it.hasNext()) {
				double v = Math.pow(it.aDouble, it.bDouble);
				if (Double.isInfinite(v) || Double.isNaN(v)) { // INT_USE
					data[it.aIndex] = 0; // INT_USE
				} else { // INT_USE
				data[it.aIndex] = (int) (long) v; // PRIM_TYPE_LONG // ADD_CAST
				} // INT_USE
				for (int i = 1; i < isize; i++) {
					v = Math.pow(data[it.aIndex + i], bds.getElementDoubleAbs(it.bIndex + i));
					if (Double.isInfinite(v) || Double.isNaN(v)) { // INT_USE
						data[it.aIndex + i] = 0; // INT_USE
					} else { // INT_USE
					data[it.aIndex + i] = (int) (long) v; // PRIM_TYPE_LONG // ADD_CAST
					} // INT_USE
				}
			}
		}
		setDirty();
		return this;
	}

	@Override
	public double residual(final Object b, final Dataset w, boolean ignoreNaNs) {
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		final BroadcastIterator it = new BroadcastIterator(this, bds);
		it.setOutputDouble(true);
		double sum = 0;
		double comp = 0;
		final int bis = bds.getElementsPerItem();

		if (bis == 1) {
			if (w == null) {
				while (it.hasNext()) {
					final double db = it.bDouble;
					double diff = it.aDouble - db;
					double err = diff * diff - comp;
					double temp = sum + err;
					comp = (temp - sum) - err;
					sum = temp;
					for (int i = 1; i < isize; i++) {
						diff = data[it.aIndex + i] - db;
						err = diff * diff - comp;
						temp = sum + err;
						comp = (temp - sum) - err;
						sum = temp;
					}
				}
			} else {
				IndexIterator itw = w.getIterator();
				while (it.hasNext() && itw.hasNext()) {
					final double db = it.bDouble;
					double diff = it.aDouble - db;
					final double dw = w.getElementDoubleAbs(itw.index);
					double err = diff * diff * dw - comp;
					double temp = sum + err;
					comp = (temp - sum) - err;
					sum = temp;
					for (int i = 1; i < isize; i++) {
						diff = data[it.aIndex + i] - db;
						err = diff * diff * dw - comp;
						temp = sum + err;
						comp = (temp - sum) - err;
						sum = temp;
					}
				}
			}
		} else {
			if (w == null) {
				while (it.hasNext()) {
					double diff = it.aDouble - it.bDouble;
					double err = diff * diff - comp;
					double temp = sum + err;
					comp = (temp - sum) - err;
					sum = temp;
					for (int i = 1; i < isize; i++) {
						diff = data[it.aIndex + i] - bds.getElementDoubleAbs(it.bIndex + i);
						err = diff * diff - comp;
						temp = sum + err;
						comp = (temp - sum) - err;
						sum = temp;
					}
				}
			} else {
				IndexIterator itw = w.getIterator();
				while (it.hasNext() && itw.hasNext()) {
					double diff = it.aDouble - it.bDouble;
					final double dw = w.getElementDoubleAbs(itw.index);
					double err = diff * diff * dw - comp;
					double temp = sum + err;
					comp = (temp - sum) - err;
					sum = temp;
					for (int i = 1; i < isize; i++) {
						diff = data[it.aIndex + i] - bds.getElementDoubleAbs(it.bIndex + i);
						err = diff * diff * dw - comp;
						temp = sum + err;
						comp = (temp - sum) - err;
						sum = temp;
					}
				}
			}
		}
		return sum;
	}
}
