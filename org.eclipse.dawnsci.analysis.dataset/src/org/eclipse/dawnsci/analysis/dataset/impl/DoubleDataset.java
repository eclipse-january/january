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

// GEN_COMMENT

package org.eclipse.dawnsci.analysis.dataset.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.math3.complex.Complex; // NAN_OMIT
import org.eclipse.dawnsci.analysis.api.dataset.IDataset;
import org.eclipse.dawnsci.analysis.api.dataset.Slice;


/**
 * Extend dataset for double values // PRIM_TYPE
 */
public class DoubleDataset extends AbstractDataset {
	// pin UID to base class
	private static final long serialVersionUID = Dataset.serialVersionUID;

	protected double[] data; // subclass alias // PRIM_TYPE

	@Override
	protected void setData() {
		data = (double[]) odata; // PRIM_TYPE
	}

	protected static double[] createArray(final int size) { // PRIM_TYPE
		double[] array = null; // PRIM_TYPE

		try {
			array = new double[size]; // PRIM_TYPE
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
		return FLOAT64; // DATA_TYPE
	}

	public DoubleDataset() {
	}

	/**
	 * Create a zero-filled dataset of given shape
	 * @param shape
	 */
	public DoubleDataset(final int... shape) {
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
	 * Create a dataset using given data
	 * @param data
	 * @param shape
	 *            (can be null to create 1D dataset)
	 */
	public DoubleDataset(final double[] data, int... shape) { // PRIM_TYPE
		if (shape == null || shape.length == 0) {
			shape = new int[] { data.length };
		}
		size = calcSize(shape);
		if (size != data.length) {
			throw new IllegalArgumentException(String.format("Shape %s is not compatible with size of data array, %d",
					Arrays.toString(shape), data.length));
		}
		this.shape = shape.clone();

		odata = this.data = data;
	}

	/**
	 * Copy a dataset
	 * @param dataset
	 */
	public DoubleDataset(final DoubleDataset dataset) {
		copyToView(dataset, this, true, true);
		if (dataset.stride == null) {
			odata = data = dataset.data.clone();
		} else {
			offset = 0;
			stride = null;
			base = null;
			odata = data = createArray(size);
			IndexIterator iter = dataset.getIterator();
			for (int i = 0; iter.hasNext(); i++) {
				data[i] = dataset.data[iter.index];
			}
		}
	}

	/**
	 * Cast a dataset to this class type
	 * @param dataset
	 */
	public DoubleDataset(final Dataset dataset) {
		copyToView(dataset, this, true, false);
		offset = 0;
		stride = null;
		base = null;
		odata = data = createArray(size);
		IndexIterator iter = dataset.getIterator();
		for (int i = 0; iter.hasNext(); i++) {
			data[i] = dataset.getElementDoubleAbs(iter.index); // GET_ELEMENT_WITH_CAST
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}

		if (getRank() == 0) // already true for zero-rank dataset
			return true;

		DoubleDataset other = (DoubleDataset) obj;
		IndexIterator iter = getIterator();
		IndexIterator oiter = other.getIterator();
		while (iter.hasNext() && oiter.hasNext()) {
			if (data[iter.index] != other.data[oiter.index]) // OBJECT_UNEQUAL
				return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public DoubleDataset clone() {
		return new DoubleDataset(this);
	}

	/**
	 * Create a dataset from an object which could be a Java list, array (of arrays...) or Number. Ragged
	 * sequences or arrays are padded with zeros.
	 * 
	 * @param obj
	 * @return dataset with contents given by input
	 */
	public static DoubleDataset createFromObject(final Object obj) {
		DoubleDataset result = new DoubleDataset();

		result.shape = getShapeFromObject(obj);
		result.size = calcSize(result.shape);

		result.odata = result.data = createArray(result.size);

		int[] pos = new int[result.shape.length];
		result.fillData(obj, 0, pos);
		return result;
	}
	 // NAN_OMIT
	/** // NAN_OMIT
	 * @param stop // NAN_OMIT
	 * @return a new 1D dataset, filled with values determined by parameters // NAN_OMIT
	 * @deprecated Use {@link #createRange(double)} // NAN_OMIT
	 */ // NAN_OMIT
	@Deprecated // NAN_OMIT
	public static DoubleDataset arange(final double stop) { // NAN_OMIT
		return createRange(0, stop, 1); // NAN_OMIT
	} // NAN_OMIT
	 // NAN_OMIT
	/** // NAN_OMIT
	 * @param start // NAN_OMIT
	 * @param stop // NAN_OMIT
	 * @param step // NAN_OMIT
	 * @return a new 1D dataset, filled with values determined by parameters // NAN_OMIT
	 * @deprecated Use {@link #createRange(double, double, double)} // NAN_OMIT
	 */ // NAN_OMIT
	@Deprecated // NAN_OMIT
	public static DoubleDataset arange(final double start, final double stop, final double step) { // NAN_OMIT
		return createRange(start, stop, step); // NAN_OMIT
	} // NAN_OMIT
	 // NAN_OMIT
	/** // NAN_OMIT
	 * // NAN_OMIT
	 * @param stop // NAN_OMIT
	 * @return a new 1D dataset, filled with values determined by parameters // NAN_OMIT
	 */ // NAN_OMIT
	public static DoubleDataset createRange(final double stop) { // NAN_OMIT
		return createRange(0, stop, 1); // NAN_OMIT
	} // NAN_OMIT
	 // NAN_OMIT
	/** // NAN_OMIT
	 * // NAN_OMIT
	 * @param start // NAN_OMIT
	 * @param stop // NAN_OMIT
	 * @param step // NAN_OMIT
	 * @return a new 1D dataset, filled with values determined by parameters // NAN_OMIT
	 */ // NAN_OMIT
	public static DoubleDataset createRange(final double start, final double stop, final double step) { // NAN_OMIT
		int size = calcSteps(start, stop, step); // NAN_OMIT
		DoubleDataset result = new DoubleDataset(size); // NAN_OMIT
		for (int i = 0; i < size; i++) { // NAN_OMIT
			result.data[i] = (start + i * step); // PRIM_TYPE // NAN_OMIT // ADD_CAST
		} // NAN_OMIT
		return result; // NAN_OMIT
	} // NAN_OMIT

	/**
	 * @param shape
	 * @return a dataset filled with ones
	 */
	public static DoubleDataset ones(final int... shape) {
		return new DoubleDataset(shape).fill(1);
	}

	@Override
	public DoubleDataset fill(final Object obj) {
		double dv = toReal(obj); // PRIM_TYPE // FROM_OBJECT
		IndexIterator iter = getIterator();
		while (iter.hasNext()) {
			data[iter.index] = dv;
		}

		setDirty();
		return this;
	}

	/**
	 * This is a typed version of {@link #getBuffer()}
	 * @return data buffer as linear array
	 */
	public double[] getData() { // PRIM_TYPE
		return data;
	}

	@Override
	protected int getBufferLength() {
		if (data == null)
			return 0;
		return data.length;
	}

	@Override
	public DoubleDataset getView() {
		DoubleDataset view = new DoubleDataset();
		copyToView(this, view, true, true);
		view.setData();
		return view;
	}

	/**
	 * Get a value from an absolute index of the internal array. This is an internal method with no checks so can be
	 * dangerous. Use with care or ideally with an iterator.
	 * 
	 * @param index
	 *            absolute index
	 * @return value
	 */
	public double getAbs(final int index) { // PRIM_TYPE
		return data[index];
	}

	@Override
	public boolean getElementBooleanAbs(final int index) {
		return data[index] != 0; // BOOLEAN_FALSE
	}

	@Override
	public double getElementDoubleAbs(final int index) {
		return data[index]; // BOOLEAN_ZERO
	}

	@Override
	public long getElementLongAbs(final int index) {
		return (long) data[index]; // BOOLEAN_ZERO // OMIT_CAST_INT
	}

	@Override
	public Object getObjectAbs(final int index) {
		return data[index];
	}

	@Override
	public String getStringAbs(final int index) {
		return stringFormat == null ? String.format("%.8g", data[index]) : // FORMAT_STRING
			stringFormat.format(data[index]);
	}

	/**
	 * Set a value at absolute index in the internal array. This is an internal method with no checks so can be
	 * dangerous. Use with care or ideally with an iterator.
	 * 
	 * @param index
	 *            absolute index
	 * @param val
	 *            new value
	 */
	public void setAbs(final int index, final double val) { // PRIM_TYPE
		data[index] = val;
		setDirty();
	}

	@Override
	protected void setItemDirect(final int dindex, final int sindex, final Object src) {
		double[] dsrc = (double[]) src; // PRIM_TYPE
		data[dindex] = dsrc[sindex];
	}

	@Override
	public void setObjectAbs(final int index, final Object obj) {
		if (index < 0 || index > data.length) {
			throw new IndexOutOfBoundsException("Index given is outside dataset");
		}

		setAbs(index, toReal(obj)); // FROM_OBJECT
	}

	/**
	 * @param i
	 * @return item in given position
	 */
	public double get(final int i) { // PRIM_TYPE
		return data[get1DIndex(i)];
	}

	/**
	 * @param i
	 * @param j
	 * @return item in given position
	 */
	public double get(final int i, final int j) { // PRIM_TYPE
		return data[get1DIndex(i, j)];
	}

	/**
	 * @param pos
	 * @return item in given position
	 */
	public double get(final int... pos) { // PRIM_TYPE
		return data[get1DIndex(pos)];
	}

	@Override
	public Object getObject(final int i) {
		return Double.valueOf(get(i)); // CLASS_TYPE
	}

	@Override
	public Object getObject(final int i, final int j) {
		return Double.valueOf(get(i, j)); // CLASS_TYPE
	}

	@Override
	public Object getObject(final int... pos) {
		return Double.valueOf(get(pos)); // CLASS_TYPE
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
	public double getDouble(final int i) {
		return get(i); // BOOLEAN_ZERO
	}

	@Override
	public double getDouble(final int i, final int j) {
		return get(i, j); // BOOLEAN_ZERO
	}

	@Override
	public double getDouble(final int... pos) {
		return get(pos); // BOOLEAN_ZERO
	}

	@Override
	public float getFloat(final int i) {
		return (float) get(i); // BOOLEAN_ZERO // OMIT_REAL_CAST
	}

	@Override
	public float getFloat(final int i, final int j) {
		return (float) get(i, j); // BOOLEAN_ZERO // OMIT_REAL_CAST
	}

	@Override
	public float getFloat(final int... pos) {
		return (float) get(pos); // BOOLEAN_ZERO // OMIT_REAL_CAST
	}

	@Override
	public long getLong(final int i) {
		return (long) get(i); // BOOLEAN_ZERO // OMIT_UPCAST
	}

	@Override
	public long getLong(final int i, final int j) {
		return (long) get(i, j); // BOOLEAN_ZERO // OMIT_UPCAST
	}

	@Override
	public long getLong(final int... pos) {
		return (long) get(pos); // BOOLEAN_ZERO // OMIT_UPCAST
	}

	@Override
	public int getInt(final int i) {
		return (int) get(i); // BOOLEAN_ZERO // OMIT_UPCAST
	}

	@Override
	public int getInt(final int i, final int j) {
		return (int) get(i, j); // BOOLEAN_ZERO // OMIT_UPCAST
	}

	@Override
	public int getInt(final int... pos) {
		return (int) get(pos); // BOOLEAN_ZERO // OMIT_UPCAST
	}

	@Override
	public short getShort(final int i) {
		return (short) get(i); // BOOLEAN_ZERO // OMIT_UPCAST
	}

	@Override
	public short getShort(final int i, final int j) {
		return (short) get(i, j); // BOOLEAN_ZERO // OMIT_UPCAST
	}

	@Override
	public short getShort(final int... pos) {
		return (short) get(pos); // BOOLEAN_ZERO // OMIT_UPCAST
	}

	@Override
	public byte getByte(final int i) {
		return (byte) get(i); // BOOLEAN_ZERO // OMIT_UPCAST
	}

	@Override
	public byte getByte(final int i, final int j) {
		return (byte) get(i, j); // BOOLEAN_ZERO // OMIT_UPCAST
	}

	@Override
	public byte getByte(final int... pos) {
		return (byte) get(pos); // BOOLEAN_ZERO // OMIT_UPCAST
	}

	@Override
	public boolean getBoolean(final int i) {
		return get(i) != 0; // BOOLEAN_FALSE
	}

	@Override
	public boolean getBoolean(final int i, final int j) {
		return get(i, j) != 0; // BOOLEAN_FALSE
	}

	@Override
	public boolean getBoolean(final int... pos) {
		return get(pos) != 0; // BOOLEAN_FALSE
	}

	/**
	 * Sets the value at a particular point to the passed value. The dataset must be 1D
	 * 
	 * @param value
	 * @param i
	 */
	public void setItem(final double value, final int i) { // PRIM_TYPE
		setAbs(get1DIndex(i), value);
	}

	/**
	 * Sets the value at a particular point to the passed value. The dataset must be 2D
	 * 
	 * @param value
	 * @param i
	 * @param j
	 */
	public void setItem(final double value, final int i, final int j) { // PRIM_TYPE
		setAbs(get1DIndex(i, j), value);
	}

	/**
	 * Sets the value at a particular point to the passed value
	 * 
	 * @param value
	 * @param pos
	 */
	public void setItem(final double value, final int... pos) { // PRIM_TYPE
		setAbs(get1DIndex(pos), value);
	}

	@Override
	public void set(final Object obj, final int i) {
		setItem(toReal(obj), i); // FROM_OBJECT
	}

	@Override
	public void set(final Object obj, final int i, final int j) {
		setItem(toReal(obj), i, j); // FROM_OBJECT
	}

	@Override
	public void set(final Object obj, int... pos) {
		if (pos == null || (pos.length == 0 && shape.length > 0)) {
			pos = new int[shape.length];
		}

		setItem(toReal(obj), pos); // FROM_OBJECT
	}


	@Override
	public void resize(int... newShape) {
		final IndexIterator iter = getIterator();
		final int nsize = calcSize(newShape);
		final double[] ndata = createArray(nsize); // PRIM_TYPE
		for (int i = 0; iter.hasNext() && i < nsize; i++) {
			ndata[i] = data[iter.index];
		}

		odata = data = ndata;
		size = nsize;
		shape = newShape;
		stride = null;
		offset = 0;
		base = null;
	}

	@Override
	public DoubleDataset sort(Integer axis) {
		if (axis == null) { // BOOLEAN_OMIT
			Arrays.sort(data); // BOOLEAN_OMIT
		} else { // BOOLEAN_OMIT
			axis = checkAxis(axis); // BOOLEAN_OMIT
			 // BOOLEAN_OMIT 
			DoubleDataset ads = new DoubleDataset(shape[axis]); // BOOLEAN_OMIT
			PositionIterator pi = getPositionIterator(axis); // BOOLEAN_OMIT
			int[] pos = pi.getPos(); // BOOLEAN_OMIT
			boolean[] hit = pi.getOmit(); // BOOLEAN_OMIT
			while (pi.hasNext()) { // BOOLEAN_OMIT
				copyItemsFromAxes(pos, hit, ads); // BOOLEAN_OMIT
				Arrays.sort(ads.data); // BOOLEAN_OMIT
				setItemsOnAxes(pos, hit, ads.data); // BOOLEAN_OMIT
			} // BOOLEAN_OMIT
		} // BOOLEAN_OMIT
		 // BOOLEAN_OMIT 
		setDirty(); // BOOLEAN_OMIT
		return this; // BOOLEAN_OMIT
		// throw new UnsupportedOperationException("Cannot sort dataset"); // BOOLEAN_USE
	}

	@Override
	public DoubleDataset getUniqueItems() {
		Set<Double> set = new TreeSet<Double>(); // CLASS_TYPE
		IndexIterator it = getIterator();
		while (it.hasNext()) {
			set.add(data[it.index]);
		}

		DoubleDataset u = new DoubleDataset(set.size()); // CLASS_TYPE
		int i = 0;
		double[] udata = u.getData(); // PRIM_TYPE
		for (Double v : set) { // CLASS_TYPE
			udata[i++] = v;
		}
		return u;
	}

	@Override
	public DoubleDataset getSlice(final SliceIterator siter) {
		DoubleDataset result = new DoubleDataset(siter.getShape());
		double[] rdata = result.data; // PRIM_TYPE

		for (int i = 0; siter.hasNext(); i++)
			rdata[i] = data[siter.index];

		result.setName(name + BLOCK_OPEN + Slice.createString(siter.shape, siter.start, siter.stop, siter.step) + BLOCK_CLOSE);
		return result;
	}

	@Override
	public void fillDataset(Dataset result, IndexIterator iter) {
		IndexIterator riter = result.getIterator();

		double[] rdata = ((DoubleDataset) result).data; // PRIM_TYPE

		while (riter.hasNext() && iter.hasNext())
			rdata[riter.index] = data[iter.index];
	}

	@Override
	public DoubleDataset setByBoolean(final Object obj, Dataset selection) {
		if (obj instanceof Dataset) {
			final Dataset ds = (Dataset) obj;
			final int length = ((Number) selection.sum()).intValue();
			if (length != ds.getSize()) {
				throw new IllegalArgumentException(
						"Number of true items in selection does not match number of items in dataset");
			}

			final IndexIterator oiter = ds.getIterator();
			final BooleanIterator biter = getBooleanIterator(selection);

			while (biter.hasNext() && oiter.hasNext()) {
				data[biter.index] = ds.getElementDoubleAbs(oiter.index); // GET_ELEMENT_WITH_CAST
			}
		} else {
			final double dv = toReal(obj); // PRIM_TYPE // FROM_OBJECT
			final BooleanIterator biter = getBooleanIterator(selection);

			while (biter.hasNext()) {
				data[biter.index] = dv;
			}
		}
		setDirty();
		return this;
	}

	@Override
	public DoubleDataset setBy1DIndex(final Object obj, final Dataset index) {
		if (obj instanceof Dataset) {
			final Dataset ds = (Dataset) obj;
			if (index.getSize() != ds.getSize()) {
				throw new IllegalArgumentException(
						"Number of items in index dataset does not match number of items in dataset");
			}

			final IndexIterator oiter = ds.getIterator();
			final IntegerIterator iter = new IntegerIterator(index, size);

			while (iter.hasNext() && oiter.hasNext()) {
				data[iter.index] = ds.getElementDoubleAbs(oiter.index); // GET_ELEMENT_WITH_CAST
			}
		} else {
			final double dv = toReal(obj); // PRIM_TYPE // FROM_OBJECT
			IntegerIterator iter = new IntegerIterator(index, size);

			while (iter.hasNext()) {
				data[iter.index] = dv;
			}
		}
		setDirty();
		return this;
	}

	@Override
	public DoubleDataset setByIndexes(final Object obj, final Object... indexes) {
		final IntegersIterator iter = new IntegersIterator(shape, indexes);
		final int[] pos = iter.getPos();

		if (obj instanceof Dataset) {
			final Dataset ds = (Dataset) obj;
			if (calcSize(iter.getShape()) != ds.getSize()) {
				throw new IllegalArgumentException(
						"Number of items in index datasets does not match number of items in dataset");
			}

			final IndexIterator oiter = ds.getIterator();

			while (iter.hasNext() && oiter.hasNext()) {
				setItem(ds.getElementDoubleAbs(oiter.index), pos); // GET_ELEMENT_WITH_CAST
			}
		} else {
			final double dv = toReal(obj); // PRIM_TYPE // FROM_OBJECT

			while (iter.hasNext()) {
				setItem(dv, pos);
			}
		}
		setDirty();
		return this;
	}

	@Override
	DoubleDataset setSlicedView(Dataset view, Dataset d) {
		BroadcastIterator biter = new BroadcastIterator(view, d);

		while (biter.hasNext()) {
			data[biter.aIndex] = d.getElementDoubleAbs(biter.bIndex); // GET_ELEMENT_WITH_CAST
		}
		return this;
	}

	@Override
	public DoubleDataset setSlice(final Object obj, final IndexIterator siter) {

		if (obj instanceof IDataset) {
			final IDataset ds = (IDataset) obj;
			final int[] oshape = ds.getShape();

			if (!areShapesCompatible(siter.getShape(), oshape)) {
				throw new IllegalArgumentException(String.format(
						"Input dataset is not compatible with slice: %s cf %s", Arrays.toString(oshape),
						Arrays.toString(siter.getShape())));
			}

			if (ds instanceof Dataset) {
				final Dataset ads = (Dataset) ds;
				final IndexIterator oiter = ads.getIterator();

				while (siter.hasNext() && oiter.hasNext())
					data[siter.index] = ads.getElementDoubleAbs(oiter.index); // GET_ELEMENT_WITH_CAST
			} else {
				final IndexIterator oiter = new PositionIterator(oshape);
				final int[] pos = oiter.getPos();

				while (siter.hasNext() && oiter.hasNext())
					data[siter.index] = ds.getDouble(pos); // PRIM_TYPE
			}
		} else {
			try {
				double v = toReal(obj); // PRIM_TYPE // FROM_OBJECT

				while (siter.hasNext())
					data[siter.index] = v;
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException("Object for setting slice is not a dataset or number");
			}
		}
		setDirty();
		return this;
	}

	@Override
	public void copyItemsFromAxes(final int[] pos, final boolean[] axes, final Dataset dest) {
		double[] ddata = (double[]) dest.getBuffer(); // PRIM_TYPE

		SliceIterator siter = getSliceIteratorFromAxes(pos, axes);
		int[] sshape = squeezeShape(siter.getShape(), false);

		IndexIterator diter = dest.getSliceIterator(null, sshape, null);

		if (ddata.length < calcSize(sshape)) {
			throw new IllegalArgumentException("destination array is not large enough");
		}

		while (siter.hasNext() && diter.hasNext())
			ddata[diter.index] = data[siter.index];
	}

	@Override
	public void setItemsOnAxes(final int[] pos, final boolean[] axes, final Object src) {
		double[] sdata = (double[]) src; // PRIM_TYPE

		SliceIterator siter = getSliceIteratorFromAxes(pos, axes);

		if (sdata.length < calcSize(siter.getShape())) {
			throw new IllegalArgumentException("destination array is not large enough");
		}

		for (int i = 0; siter.hasNext(); i++) {
			data[siter.index] = sdata[i];
		}
		setDirty();
	}

	@Override
	protected Number fromDoubleToNumber(double x) {
		double r = x; // NAN_OMIT // ADD_CAST // PRIM_TYPE_LONG
		return Double.valueOf(r); // CLASS_TYPE // NAN_OMIT
		// return Integer.valueOf((int) (long) x); // BOOLEAN_USE
		// return null; // OBJECT_USE
	}

	private List<int[]> findPositions(final double value) { // PRIM_TYPE
		IndexIterator iter = getIterator(true);
		List<int[]> posns = new ArrayList<int[]>();
		int[] pos = iter.getPos();

		if (Double.isNaN(value)) { // CLASS_TYPE // REAL_ONLY
			while (iter.hasNext()) { // REAL_ONLY
				if (Double.isNaN(data[iter.index])) { // REAL_ONLY
					posns.add(pos.clone()); // REAL_ONLY
				} // REAL_ONLY
			} // REAL_ONLY
		} else // REAL_ONLY
		{
			while (iter.hasNext()) {
				if (data[iter.index] == value) {
					posns.add(pos.clone());
				}
			}
		}
		return posns;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public int[] maxPos(boolean ignoreInvalids) {
		if (storedValues == null || storedValues.isEmpty()) {
			calculateMaxMin(ignoreInvalids, ignoreInvalids);
		}
		String n = storeName(ignoreInvalids, ignoreInvalids, STORE_MAX_POS);
		Object o = storedValues.get(n);

		List<int[]> max = null;
		if (o == null) {
			max = findPositions(max(ignoreInvalids).doubleValue()); // PRIM_TYPE // NAN_OMIT
			// max = findPositions(max(false).intValue() != 0); // BOOLEAN_USE
			// max = findPositions(null); // OBJECT_USE
			storedValues.put(n, max);
		} else if (o instanceof List<?>) {
			max = (List<int[]>) o;
		} else {
			throw new InternalError("Inconsistent internal state of stored values for statistics calculation");
		}

		return max.get(0); // first maximum
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public int[] minPos(boolean ignoreInvalids) {
		if (storedValues == null || storedValues.isEmpty()) {
			calculateMaxMin(ignoreInvalids, ignoreInvalids);
		}
		String n = storeName(ignoreInvalids, ignoreInvalids, STORE_MIN_POS);
		Object o = storedValues.get(n);
		List<int[]> min = null;
		if (o == null) {
			min = findPositions(min(ignoreInvalids).doubleValue()); // PRIM_TYPE // NAN_OMIT
			// min = findPositions(min(false).intValue() != 0); // BOOLEAN_USE
			// min = findPositions(null); // OBJECT_USE
			storedValues.put(n, min);
		} else if (o instanceof List<?>) {
			min = (List<int[]>) o;
		} else {
			throw new InternalError("Inconsistent internal state of stored values for statistics calculation");
		}

		return min.get(0); // first minimum
	}

	@Override
	public boolean containsNans() {
		IndexIterator iter = getIterator(); // REAL_ONLY
		while (iter.hasNext()) { // REAL_ONLY
			if (Double.isNaN(data[iter.index])) // CLASS_TYPE // REAL_ONLY
				return true; // REAL_ONLY
		} // REAL_ONLY
		return false;
	}

	@Override
	public boolean containsInfs() {
		IndexIterator iter = getIterator(); // REAL_ONLY
		while (iter.hasNext()) { // REAL_ONLY
			if (Double.isInfinite(data[iter.index])) // CLASS_TYPE // REAL_ONLY
				return true; // REAL_ONLY
		} // REAL_ONLY
		return false;
	}

	@Override
	public boolean containsInvalidNumbers() {
		IndexIterator iter = getIterator(); // REAL_ONLY
		while (iter.hasNext()) { // REAL_ONLY
			double x = data[iter.index]; // PRIM_TYPE // REAL_ONLY
			if (Double.isNaN(x) || Double.isInfinite(x)) // CLASS_TYPE // REAL_ONLY
				return true; // REAL_ONLY
		} // REAL_ONLY
		return false;
	}

	@Override
	public DoubleDataset iadd(final Object b) {
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b); // NAN_OMIT
		boolean useLong = bds.elementClass().equals(Long.class); // NAN_OMIT
		if (bds.getSize() == 1) { // NAN_OMIT
			final IndexIterator it = getIterator(); // NAN_OMIT
			if (useLong) { // NAN_OMIT
				final long lb = bds.getElementLongAbs(0); // NAN_OMIT
				while (it.hasNext()) { // NAN_OMIT
					data[it.index] += lb; // NAN_OMIT
				} // NAN_OMIT
			} else { // NAN_OMIT
				final double db = bds.getElementDoubleAbs(0); // NAN_OMIT
				while (it.hasNext()) { // NAN_OMIT
					data[it.index] += db; // NAN_OMIT
				} // NAN_OMIT
			} // NAN_OMIT
		} else { // NAN_OMIT
			final BroadcastIterator it = new BroadcastIterator(this, bds); // NAN_OMIT
			it.setOutputDouble(!useLong); // NAN_OMIT
			if (useLong) { // NAN_OMIT
				while (it.hasNext()) { // NAN_OMIT
					data[it.aIndex] += it.bLong; // NAN_OMIT
				} // NAN_OMIT
			} else { // NAN_OMIT
				while (it.hasNext()) { // NAN_OMIT
					data[it.aIndex] += it.bDouble; // NAN_OMIT
				} // NAN_OMIT
			} // NAN_OMIT
		} // NAN_OMIT
		setDirty(); // NAN_OMIT
		return this;
	}

	@Override
	public DoubleDataset isubtract(final Object b) {
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b); // NAN_OMIT
		boolean useLong = bds.elementClass().equals(Long.class); // NAN_OMIT
		if (bds.getSize() == 1) { // NAN_OMIT
			final IndexIterator it = getIterator(); // NAN_OMIT
			if (useLong) { // NAN_OMIT
				final long lb = bds.getElementLongAbs(0); // NAN_OMIT
				while (it.hasNext()) { // NAN_OMIT
					data[it.index] -= lb; // NAN_OMIT
				} // NAN_OMIT
			} else { // NAN_OMIT
				final double db = bds.getElementDoubleAbs(0); // NAN_OMIT
				while (it.hasNext()) { // NAN_OMIT
					data[it.index] -= db; // NAN_OMIT
				} // NAN_OMIT
			} // NAN_OMIT
		} else { // NAN_OMIT
			final BroadcastIterator it = new BroadcastIterator(this, bds); // NAN_OMIT
			if (useLong) { // NAN_OMIT
				it.setOutputDouble(false); // NAN_OMIT
				while (it.hasNext()) { // NAN_OMIT
					data[it.aIndex] -= it.bLong; // NAN_OMIT
				} // NAN_OMIT
			} else { // NAN_OMIT
				it.setOutputDouble(true); // NAN_OMIT
				while (it.hasNext()) { // NAN_OMIT
					data[it.aIndex] -= it.bDouble; // NAN_OMIT
				} // NAN_OMIT
			} // NAN_OMIT
		} // NAN_OMIT
		setDirty(); // NAN_OMIT
		return this;
	}

	@Override
	public DoubleDataset imultiply(final Object b) {
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b); // NAN_OMIT
		boolean useLong = bds.elementClass().equals(Long.class); // NAN_OMIT
		if (bds.getSize() == 1) { // NAN_OMIT
			final IndexIterator it = getIterator(); // NAN_OMIT
			if (useLong) { // NAN_OMIT
				final long lb = bds.getElementLongAbs(0); // NAN_OMIT
				while (it.hasNext()) { // NAN_OMIT
					data[it.index] *= lb; // NAN_OMIT
				} // NAN_OMIT
			} else { // NAN_OMIT
				final double db = bds.getElementDoubleAbs(0); // NAN_OMIT
				while (it.hasNext()) { // NAN_OMIT
					data[it.index] *= db; // NAN_OMIT
				} // NAN_OMIT
			} // NAN_OMIT
		} else { // NAN_OMIT
			final BroadcastIterator it = new BroadcastIterator(this, bds); // NAN_OMIT
			it.setOutputDouble(!useLong); // NAN_OMIT
			if (useLong) { // NAN_OMIT
				while (it.hasNext()) { // NAN_OMIT
					data[it.aIndex] *= it.bLong; // NAN_OMIT
				} // NAN_OMIT
			} else { // NAN_OMIT
				while (it.hasNext()) { // NAN_OMIT
					data[it.aIndex] *= it.bDouble; // NAN_OMIT
				} // NAN_OMIT
			} // NAN_OMIT
		} // NAN_OMIT
		setDirty(); // NAN_OMIT
		return this;
	}

	@Override
	public DoubleDataset idivide(final Object b) {
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b); // NAN_OMIT
		boolean useLong = bds.elementClass().equals(Long.class); // NAN_OMIT
		if (bds.getSize() == 1) { // NAN_OMIT
			if (useLong) { // NAN_OMIT
				final long lb = bds.getElementLongAbs(0); // NAN_OMIT
				// if (lb == 0) { // INT_USE // NAN_OMIT
				// 	fill(0); // INT_USE // NAN_OMIT
				// } else { // INT_USE // NAN_OMIT
				final IndexIterator it = getIterator(); // NAN_OMIT
				while (it.hasNext()) { // NAN_OMIT
					data[it.index] /= lb; // NAN_OMIT
				} // NAN_OMIT
				// } // INT_USE // NAN_OMIT
			} else { // NAN_OMIT
				final double db = bds.getElementDoubleAbs(0); // NAN_OMIT
				// if (db == 0) { // INT_USE // NAN_OMIT
				// 	fill(0); // INT_USE // NAN_OMIT
				// } else { // INT_USE // NAN_OMIT
				final IndexIterator it = getIterator(); // NAN_OMIT
				while (it.hasNext()) { // NAN_OMIT
					data[it.index] /= db; // NAN_OMIT
				} // NAN_OMIT
				// } // INT_USE // NAN_OMIT
			} // NAN_OMIT
		} else { // NAN_OMIT
			final BroadcastIterator it = new BroadcastIterator(this, bds); // NAN_OMIT
			it.setOutputDouble(!useLong); // NAN_OMIT
			if (useLong) { // NAN_OMIT
				while (it.hasNext()) { // NAN_OMIT
					// if (it.bLong == 0) { // INT_USE // NAN_OMIT
					// 	data[it.aIndex] = 0; // INT_USE // NAN_OMIT
					// } else { // INT_USE // NAN_OMIT
					data[it.aIndex] /= it.bLong; // NAN_OMIT
					// } // INT_USE // NAN_OMIT
				} // NAN_OMIT
			} else { // NAN_OMIT
				while (it.hasNext()) { // NAN_OMIT
					// if (it.bDouble == 0) { // INT_USE // NAN_OMIT
					// 	data[it.aIndex] = 0; // INT_USE // NAN_OMIT
					// } else { // INT_USE // NAN_OMIT
					data[it.aIndex] /= it.bDouble; // NAN_OMIT
					// } // INT_USE // NAN_OMIT
				} // NAN_OMIT
			} // NAN_OMIT
		} // NAN_OMIT
		setDirty(); // NAN_OMIT
		return this;
	}

	@Override
	public DoubleDataset ifloor() {
		IndexIterator it = getIterator(); // REAL_ONLY
		while (it.hasNext()) { // REAL_ONLY
			data[it.index] = Math.floor(data[it.index]); // PRIM_TYPE // REAL_ONLY // ADD_CAST
		} // REAL_ONLY
		setDirty(); // REAL_ONLY
		return this;
	}

	@Override
	public DoubleDataset iremainder(final Object b) {
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b); // NAN_OMIT
		boolean useLong = bds.elementClass().equals(Long.class); // NAN_OMIT
		if (bds.getSize() == 1) { // NAN_OMIT
			if (useLong) { // NAN_OMIT
				final long lb = bds.getElementLongAbs(0); // NAN_OMIT
				// if (lb == 0) { // INT_USE // NAN_OMIT
				// 	fill(0); // INT_USE // NAN_OMIT
				// } else { // INT_USE // NAN_OMIT
				final IndexIterator it = getIterator(); // NAN_OMIT
				while (it.hasNext()) { // NAN_OMIT
					data[it.index] %= lb; // NAN_OMIT
				} // NAN_OMIT
				// } // INT_USE // NAN_OMIT
			} else { // NAN_OMIT
				final long lb = bds.getElementLongAbs(0); // NAN_OMIT
				// if (lb == 0) { // INT_USE // NAN_OMIT
				// 	fill(0); // INT_USE // NAN_OMIT
				// } else { // INT_USE // NAN_OMIT
				final IndexIterator it = getIterator(); // NAN_OMIT
				while (it.hasNext()) { // NAN_OMIT
					data[it.index] %= lb; // NAN_OMIT
				} // NAN_OMIT
				// } // INT_USE // NAN_OMIT
			} // NAN_OMIT
		} else { // NAN_OMIT
			final BroadcastIterator it = new BroadcastIterator(this, bds); // NAN_OMIT
			it.setOutputDouble(!useLong); // NAN_OMIT
			if (useLong) { // NAN_OMIT
				while (it.hasNext()) { // NAN_OMIT
					data[it.aIndex] %= it.bLong; // NAN_OMIT // INT_EXCEPTION
				} // NAN_OMIT
			} else { // NAN_OMIT
				while (it.hasNext()) { // NAN_OMIT
					data[it.aIndex] %= it.bDouble; // NAN_OMIT // INT_EXCEPTION
				} // NAN_OMIT
			} // NAN_OMIT
		} // NAN_OMIT
		setDirty(); // NAN_OMIT
		return this;
	}

	@Override
	public DoubleDataset ipower(final Object b) {
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b); // NAN_OMIT
		if (bds.getSize() == 1) { // NAN_OMIT
			final double vr = bds.getElementDoubleAbs(0); // NAN_OMIT
			final IndexIterator it = getIterator(); // NAN_OMIT
			if (bds.isComplex()) { // NAN_OMIT
				final double vi = bds.getElementDoubleAbs(1); // NAN_OMIT
				if (vi == 0) { // NAN_OMIT
					while (it.hasNext()) { // NAN_OMIT
						final double v = Math.pow(data[it.index], vr); // NAN_OMIT
						// if (Double.isInfinite(v) || Double.isNaN(v)) { // INT_USE // NAN_OMIT
						// 	data[it.index] = 0; // INT_USE // NAN_OMIT
						// } else { // INT_USE // NAN_OMIT
						data[it.index] = v; // PRIM_TYPE_LONG // NAN_OMIT // ADD_CAST
						// } // INT_USE // NAN_OMIT
					} // NAN_OMIT
				} else { // NAN_OMIT
					final Complex zv = new Complex(vr, vi); // NAN_OMIT
					while (it.hasNext()) { // NAN_OMIT
						Complex zd = new Complex(data[it.index], 0); // NAN_OMIT
						final double v = zd.pow(zv).getReal(); // NAN_OMIT
						// if (Double.isInfinite(v) || Double.isNaN(v)) { // INT_USE // NAN_OMIT
						// 	data[it.index] = 0; // INT_USE // NAN_OMIT
						// } else { // INT_USE // NAN_OMIT
						data[it.index] = v; // PRIM_TYPE_LONG // NAN_OMIT // ADD_CAST
						// } // INT_USE // NAN_OMIT
					} // NAN_OMIT
				} // NAN_OMIT
			} else {// NAN_OMIT
				while (it.hasNext()) { // NAN_OMIT
					final double v = Math.pow(data[it.index], vr); // NAN_OMIT
					// if (Double.isInfinite(v) || Double.isNaN(v)) { // INT_USE // NAN_OMIT
					// 	data[it.index] = 0; // INT_USE // NAN_OMIT
					// } else { // INT_USE // NAN_OMIT
					data[it.index] = v; // PRIM_TYPE_LONG // NAN_OMIT // ADD_CAST
					// } // INT_USE // NAN_OMIT
				} // NAN_OMIT
			} // NAN_OMIT
		} else { // NAN_OMIT
			final BroadcastIterator it = new BroadcastIterator(this, bds); // NAN_OMIT
			it.setOutputDouble(true); // NAN_OMIT
			if (bds.isComplex()) { // NAN_OMIT
				while (it.hasNext()) { // NAN_OMIT
					final Complex zv = new Complex(it.bDouble, bds.getElementDoubleAbs(it.bIndex + 1)); // NAN_OMIT
					final double v = new Complex(it.aDouble, 0).pow(zv).getReal(); // NAN_OMIT
					// if (Double.isInfinite(v) || Double.isNaN(v)) { // INT_USE // NAN_OMIT
					// 	data[it.aIndex] = 0; // INT_USE // NAN_OMIT
					// } else { // INT_USE // NAN_OMIT
					data[it.aIndex] = v; // PRIM_TYPE_LONG // NAN_OMIT // ADD_CAST
					// } // INT_USE // NAN_OMIT
				} // NAN_OMIT
			} else {// NAN_OMIT
				while (it.hasNext()) { // NAN_OMIT
					final double v = Math.pow(it.aDouble, it.bDouble); // NAN_OMIT
					// if (Double.isInfinite(v) || Double.isNaN(v)) { // INT_USE // NAN_OMIT
					// 	data[it.aIndex] = 0; // INT_USE // NAN_OMIT
					// } else { // INT_USE // NAN_OMIT
					data[it.aIndex] = v; // PRIM_TYPE_LONG // NAN_OMIT // ADD_CAST
					// } // INT_USE // NAN_OMIT
				} // NAN_OMIT
			} // NAN_OMIT
		} // NAN_OMIT
		setDirty(); // NAN_OMIT
		return this;
	}

	@Override
	public double residual(final Object b, final Dataset w, boolean ignoreNaNs) {
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b); // NAN_OMIT
		final BroadcastIterator it = new BroadcastIterator(this, bds); // NAN_OMIT
		it.setOutputDouble(true); // NAN_OMIT
		double sum = 0;
		double comp = 0; // NAN_OMIT
		if (ignoreNaNs) { // REAL_ONLY // NAN_OMIT
			if (w == null) { // REAL_ONLY // NAN_OMIT
				while (it.hasNext()) { // REAL_ONLY // NAN_OMIT
					final double diff = it.aDouble - it.bDouble; // REAL_ONLY // NAN_OMIT
					if (Double.isNaN(diff)) // REAL_ONLY // NAN_OMIT
						continue; // REAL_ONLY // NAN_OMIT
					final double err = diff * diff - comp; // REAL_ONLY // NAN_OMIT
					final double temp = sum + err; // REAL_ONLY // NAN_OMIT
					comp = (temp - sum) - err; // REAL_ONLY // NAN_OMIT
					sum = temp; // REAL_ONLY // NAN_OMIT
				} // REAL_ONLY // NAN_OMIT
			} else { // REAL_ONLY // NAN_OMIT
				IndexIterator itw = w.getIterator(); // REAL_ONLY // NAN_OMIT
				while (it.hasNext() && itw.hasNext()) { // REAL_ONLY // NAN_OMIT
					final double diff = it.aDouble - it.bDouble; // REAL_ONLY // NAN_OMIT
					if (Double.isNaN(diff)) // REAL_ONLY // NAN_OMIT
						continue; // REAL_ONLY // NAN_OMIT
					final double err = diff * diff * w.getElementDoubleAbs(itw.index) - comp; // REAL_ONLY // NAN_OMIT
					final double temp = sum + err; // REAL_ONLY // NAN_OMIT
					comp = (temp - sum) - err; // REAL_ONLY // NAN_OMIT
					sum = temp; // REAL_ONLY // NAN_OMIT
				} // REAL_ONLY // NAN_OMIT
			} // REAL_ONLY // NAN_OMIT
		} else // REAL_ONLY // NAN_OMIT
		{ // NAN_OMIT
			if (w == null) { // NAN_OMIT
				while (it.hasNext()) { // NAN_OMIT
					final double diff = it.aDouble - it.bDouble; // NAN_OMIT
					final double err = diff * diff - comp; // NAN_OMIT
					final double temp = sum + err; // NAN_OMIT
					comp = (temp - sum) - err; // NAN_OMIT
					sum = temp; // NAN_OMIT
				} // NAN_OMIT
			} else { // NAN_OMIT
				IndexIterator itw = w.getIterator(); // NAN_OMIT
				while (it.hasNext() && itw.hasNext()) { // NAN_OMIT
					final double diff = it.aDouble - it.bDouble; // NAN_OMIT
					final double err = diff * diff * w.getElementDoubleAbs(itw.index) - comp; // NAN_OMIT
					final double temp = sum + err; // NAN_OMIT
					comp = (temp - sum) - err; // NAN_OMIT
					sum = temp; // NAN_OMIT
				} // NAN_OMIT
			} // NAN_OMIT
		} // NAN_OMIT
		return sum;
	}
}
