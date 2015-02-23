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

// This is generated from DoubleDataset.java by fromdouble.py

package org.eclipse.dawnsci.analysis.dataset.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.math3.complex.Complex;
import org.eclipse.dawnsci.analysis.api.dataset.IDataset;
import org.eclipse.dawnsci.analysis.api.dataset.Slice;


/**
 * Extend dataset for float values // PRIM_TYPE
 */
public class FloatDataset extends AbstractDataset {
	// pin UID to base class
	private static final long serialVersionUID = Dataset.serialVersionUID;

	protected float[] data; // subclass alias // PRIM_TYPE

	@Override
	protected void setData() {
		data = (float[]) odata; // PRIM_TYPE
	}

	protected static float[] createArray(final int size) { // PRIM_TYPE
		float[] array = null; // PRIM_TYPE

		try {
			array = new float[size]; // PRIM_TYPE
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
		return FLOAT32; // DATA_TYPE
	}

	public FloatDataset() {
	}

	/**
	 * Create a zero-filled dataset of given shape
	 * @param shape
	 */
	public FloatDataset(final int... shape) {
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
	public FloatDataset(final float[] data, int... shape) { // PRIM_TYPE
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
	public FloatDataset(final FloatDataset dataset) {
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
	public FloatDataset(final Dataset dataset) {
		copyToView(dataset, this, true, false);
		offset = 0;
		stride = null;
		base = null;
		odata = data = createArray(size);
		IndexIterator iter = dataset.getIterator();
		for (int i = 0; iter.hasNext(); i++) {
			data[i] = (float) dataset.getElementDoubleAbs(iter.index); // GET_ELEMENT_WITH_CAST
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}

		if (getRank() == 0) // already true for zero-rank dataset
			return true;

		FloatDataset other = (FloatDataset) obj;
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
	public FloatDataset clone() {
		return new FloatDataset(this);
	}

	/**
	 * Create a dataset from an object which could be a Java list, array (of arrays...) or Number. Ragged
	 * sequences or arrays are padded with zeros.
	 *
	 * @param obj
	 * @return dataset with contents given by input
	 */
	public static FloatDataset createFromObject(final Object obj) {
		FloatDataset result = new FloatDataset();

		result.shape = getShapeFromObject(obj);
		result.size = calcSize(result.shape);

		result.odata = result.data = createArray(result.size);

		int[] pos = new int[result.shape.length];
		result.fillData(obj, 0, pos);
		return result;
	}
	
	/**
	 * @param stop
	 * @return a new 1D dataset, filled with values determined by parameters
	 * @deprecated Use {@link #createRange(double)}
	 */
	@Deprecated
	public static FloatDataset arange(final double stop) {
		return createRange(0, stop, 1);
	}
	
	/**
	 * @param start
	 * @param stop
	 * @param step
	 * @return a new 1D dataset, filled with values determined by parameters
	 * @deprecated Use {@link #createRange(double, double, double)}
	 */
	@Deprecated
	public static FloatDataset arange(final double start, final double stop, final double step) {
		return createRange(start, stop, step);
	}
	
	/**
	 *
	 * @param stop
	 * @return a new 1D dataset, filled with values determined by parameters
	 */
	public static FloatDataset createRange(final double stop) {
		return createRange(0, stop, 1);
	}
	
	/**
	 *
	 * @param start
	 * @param stop
	 * @param step
	 * @return a new 1D dataset, filled with values determined by parameters
	 */
	public static FloatDataset createRange(final double start, final double stop, final double step) {
		int size = calcSteps(start, stop, step);
		FloatDataset result = new FloatDataset(size);
		for (int i = 0; i < size; i++) {
			result.data[i] = (float) (start + i * step); // PRIM_TYPE // ADD_CAST
		}
		return result;
	}

	/**
	 * @param shape
	 * @return a dataset filled with ones
	 */
	public static FloatDataset ones(final int... shape) {
		return new FloatDataset(shape).fill(1);
	}

	@Override
	public FloatDataset fill(final Object obj) {
		float dv = (float) toReal(obj); // PRIM_TYPE // FROM_OBJECT
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
	public float[] getData() { // PRIM_TYPE
		return data;
	}

	@Override
	protected int getBufferLength() {
		if (data == null)
			return 0;
		return data.length;
	}

	@Override
	public FloatDataset getView() {
		FloatDataset view = new FloatDataset();
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
	public float getAbs(final int index) { // PRIM_TYPE
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
	public void setAbs(final int index, final float val) { // PRIM_TYPE
		data[index] = val;
		setDirty();
	}

	@Override
	protected void setItemDirect(final int dindex, final int sindex, final Object src) {
		float[] dsrc = (float[]) src; // PRIM_TYPE
		data[dindex] = dsrc[sindex];
	}

	@Override
	public void setObjectAbs(final int index, final Object obj) {
		if (index < 0 || index > data.length) {
			throw new IndexOutOfBoundsException("Index given is outside dataset");
		}

		setAbs(index, (float) toReal(obj)); // FROM_OBJECT
	}

	/**
	 * @param i
	 * @return item in given position
	 */
	public float get(final int i) { // PRIM_TYPE
		return data[get1DIndex(i)];
	}

	/**
	 * @param i
	 * @param j
	 * @return item in given position
	 */
	public float get(final int i, final int j) { // PRIM_TYPE
		return data[get1DIndex(i, j)];
	}

	/**
	 * @param pos
	 * @return item in given position
	 */
	public float get(final int... pos) { // PRIM_TYPE
		return data[get1DIndex(pos)];
	}

	@Override
	public Object getObject(final int i) {
		return Float.valueOf(get(i)); // CLASS_TYPE
	}

	@Override
	public Object getObject(final int i, final int j) {
		return Float.valueOf(get(i, j)); // CLASS_TYPE
	}

	@Override
	public Object getObject(final int... pos) {
		return Float.valueOf(get(pos)); // CLASS_TYPE
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
		return get(i); // BOOLEAN_ZERO // OMIT_REAL_CAST
	}

	@Override
	public float getFloat(final int i, final int j) {
		return get(i, j); // BOOLEAN_ZERO // OMIT_REAL_CAST
	}

	@Override
	public float getFloat(final int... pos) {
		return get(pos); // BOOLEAN_ZERO // OMIT_REAL_CAST
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
	public void setItem(final float value, final int i) { // PRIM_TYPE
		setAbs(get1DIndex(i), value);
	}

	/**
	 * Sets the value at a particular point to the passed value. The dataset must be 2D
	 *
	 * @param value
	 * @param i
	 * @param j
	 */
	public void setItem(final float value, final int i, final int j) { // PRIM_TYPE
		setAbs(get1DIndex(i, j), value);
	}

	/**
	 * Sets the value at a particular point to the passed value
	 *
	 * @param value
	 * @param pos
	 */
	public void setItem(final float value, final int... pos) { // PRIM_TYPE
		setAbs(get1DIndex(pos), value);
	}

	@Override
	public void set(final Object obj, final int i) {
		setItem((float) toReal(obj), i); // FROM_OBJECT
	}

	@Override
	public void set(final Object obj, final int i, final int j) {
		setItem((float) toReal(obj), i, j); // FROM_OBJECT
	}

	@Override
	public void set(final Object obj, int... pos) {
		if (pos == null || (pos.length == 0 && shape.length > 0)) {
			pos = new int[shape.length];
		}

		setItem((float) toReal(obj), pos); // FROM_OBJECT
	}


	@Override
	public void resize(int... newShape) {
		final IndexIterator iter = getIterator();
		final int nsize = calcSize(newShape);
		final float[] ndata = createArray(nsize); // PRIM_TYPE
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
	public FloatDataset sort(Integer axis) {
		if (axis == null) {
			Arrays.sort(data);
		} else {
			axis = checkAxis(axis);
			
			FloatDataset ads = new FloatDataset(shape[axis]);
			PositionIterator pi = getPositionIterator(axis);
			int[] pos = pi.getPos();
			boolean[] hit = pi.getOmit();
			while (pi.hasNext()) {
				copyItemsFromAxes(pos, hit, ads);
				Arrays.sort(ads.data);
				setItemsOnAxes(pos, hit, ads.data);
			}
		}
		
		setDirty();
		return this;
		// throw new UnsupportedOperationException("Cannot sort dataset"); // BOOLEAN_USE
	}

	@Override
	public FloatDataset getUniqueItems() {
		Set<Float> set = new TreeSet<Float>(); // CLASS_TYPE
		IndexIterator it = getIterator();
		while (it.hasNext()) {
			set.add(data[it.index]);
		}

		FloatDataset u = new FloatDataset(set.size()); // CLASS_TYPE
		int i = 0;
		float[] udata = u.getData(); // PRIM_TYPE
		for (Float v : set) { // CLASS_TYPE
			udata[i++] = v;
		}
		return u;
	}

	@Override
	public FloatDataset getSlice(final SliceIterator siter) {
		FloatDataset result = new FloatDataset(siter.getShape());
		float[] rdata = result.data; // PRIM_TYPE

		for (int i = 0; siter.hasNext(); i++)
			rdata[i] = data[siter.index];

		result.setName(name + BLOCK_OPEN + Slice.createString(siter.shape, siter.start, siter.stop, siter.step) + BLOCK_CLOSE);
		return result;
	}

	@Override
	public void fillDataset(Dataset result, IndexIterator iter) {
		IndexIterator riter = result.getIterator();

		float[] rdata = ((FloatDataset) result).data; // PRIM_TYPE

		while (riter.hasNext() && iter.hasNext())
			rdata[riter.index] = data[iter.index];
	}

	@Override
	public FloatDataset setByBoolean(final Object obj, Dataset selection) {
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
				data[biter.index] = (float) ds.getElementDoubleAbs(oiter.index); // GET_ELEMENT_WITH_CAST
			}
		} else {
			final float dv = (float) toReal(obj); // PRIM_TYPE // FROM_OBJECT
			final BooleanIterator biter = getBooleanIterator(selection);

			while (biter.hasNext()) {
				data[biter.index] = dv;
			}
		}
		setDirty();
		return this;
	}

	@Override
	public FloatDataset setBy1DIndex(final Object obj, final Dataset index) {
		if (obj instanceof Dataset) {
			final Dataset ds = (Dataset) obj;
			if (index.getSize() != ds.getSize()) {
				throw new IllegalArgumentException(
						"Number of items in index dataset does not match number of items in dataset");
			}

			final IndexIterator oiter = ds.getIterator();
			final IntegerIterator iter = new IntegerIterator(index, size);

			while (iter.hasNext() && oiter.hasNext()) {
				data[iter.index] = (float) ds.getElementDoubleAbs(oiter.index); // GET_ELEMENT_WITH_CAST
			}
		} else {
			final float dv = (float) toReal(obj); // PRIM_TYPE // FROM_OBJECT
			IntegerIterator iter = new IntegerIterator(index, size);

			while (iter.hasNext()) {
				data[iter.index] = dv;
			}
		}
		setDirty();
		return this;
	}

	@Override
	public FloatDataset setByIndexes(final Object obj, final Object... indexes) {
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
				setItem((float) ds.getElementDoubleAbs(oiter.index), pos); // GET_ELEMENT_WITH_CAST
			}
		} else {
			final float dv = (float) toReal(obj); // PRIM_TYPE // FROM_OBJECT

			while (iter.hasNext()) {
				setItem(dv, pos);
			}
		}
		setDirty();
		return this;
	}

	@Override
	FloatDataset setSlicedView(Dataset view, Dataset d) {
		BroadcastIterator biter = new BroadcastIterator(view, d);

		while (biter.hasNext()) {
			data[biter.aIndex] = (float) d.getElementDoubleAbs(biter.bIndex); // GET_ELEMENT_WITH_CAST
		}
		return this;
	}

	@Override
	public FloatDataset setSlice(final Object obj, final IndexIterator siter) {

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
					data[siter.index] = (float) ads.getElementDoubleAbs(oiter.index); // GET_ELEMENT_WITH_CAST
			} else {
				final IndexIterator oiter = new PositionIterator(oshape);
				final int[] pos = oiter.getPos();

				while (siter.hasNext() && oiter.hasNext())
					data[siter.index] = ds.getFloat(pos); // PRIM_TYPE
			}
		} else {
			try {
				float v = (float) toReal(obj); // PRIM_TYPE // FROM_OBJECT

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
		float[] ddata = (float[]) dest.getBuffer(); // PRIM_TYPE

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
		float[] sdata = (float[]) src; // PRIM_TYPE

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
		float r = (float) x; // ADD_CAST // PRIM_TYPE_LONG
		return Float.valueOf(r); // CLASS_TYPE
		// return Integer.valueOf((int) (long) x); // BOOLEAN_USE
		// return null; // OBJECT_USE
	}

	private List<int[]> findPositions(final float value) { // PRIM_TYPE
		IndexIterator iter = getIterator(true);
		List<int[]> posns = new ArrayList<int[]>();
		int[] pos = iter.getPos();

		if (Float.isNaN(value)) { // CLASS_TYPE // REAL_ONLY
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
			max = findPositions(max(ignoreInvalids).floatValue()); // PRIM_TYPE
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
			min = findPositions(min(ignoreInvalids).floatValue()); // PRIM_TYPE
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
			if (Float.isNaN(data[iter.index])) // CLASS_TYPE // REAL_ONLY
				return true; // REAL_ONLY
		} // REAL_ONLY
		return false;
	}

	@Override
	public boolean containsInfs() {
		IndexIterator iter = getIterator(); // REAL_ONLY
		while (iter.hasNext()) { // REAL_ONLY
			if (Float.isInfinite(data[iter.index])) // CLASS_TYPE // REAL_ONLY
				return true; // REAL_ONLY
		} // REAL_ONLY
		return false;
	}

	@Override
	public boolean containsInvalidNumbers() {
		IndexIterator iter = getIterator(); // REAL_ONLY
		while (iter.hasNext()) { // REAL_ONLY
			float x = data[iter.index]; // PRIM_TYPE // REAL_ONLY
			if (Float.isNaN(x) || Float.isInfinite(x)) // CLASS_TYPE // REAL_ONLY
				return true; // REAL_ONLY
		} // REAL_ONLY
		return false;
	}

	@Override
	public FloatDataset iadd(final Object b) {
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		if (bds.getSize() == 1) {
			final IndexIterator it = getIterator();
			final double db = bds.getElementDoubleAbs(0);
			while (it.hasNext()) {
				data[it.index] += db;
			}
		} else {
			final BroadcastIterator it = new BroadcastIterator(this, bds);
			it.setOutputDouble(true);
			while (it.hasNext()) {
				data[it.aIndex] += it.bDouble;
			}
		}
		setDirty();
		return this;
	}

	@Override
	public FloatDataset isubtract(final Object b) {
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		if (bds.getSize() == 1) {
			final IndexIterator it = getIterator();
			final double db = bds.getElementDoubleAbs(0);
			while (it.hasNext()) {
				data[it.index] -= db;
			}
		} else {
			final BroadcastIterator it = new BroadcastIterator(this, bds);
			it.setOutputDouble(true);
			while (it.hasNext()) {
				data[it.aIndex] -= it.bDouble;
			}
		}
		setDirty();
		return this;
	}

	@Override
	public FloatDataset imultiply(final Object b) {
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		if (bds.getSize() == 1) {
			final IndexIterator it = getIterator();
			final double db = bds.getElementDoubleAbs(0);
			while (it.hasNext()) {
				data[it.index] *= db;
			}
		} else {
			final BroadcastIterator it = new BroadcastIterator(this, bds);
			it.setOutputDouble(true);
			while (it.hasNext()) {
				data[it.aIndex] *= it.bDouble;
			}
		}
		setDirty();
		return this;
	}

	@Override
	public FloatDataset idivide(final Object b) {
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		if (bds.getSize() == 1) {
			final double db = bds.getElementDoubleAbs(0);
			// if (db == 0) { // INT_USE
			// 	fill(0); // INT_USE
			// } else { // INT_USE
			final IndexIterator it = getIterator();
			while (it.hasNext()) {
				data[it.index] /= db;
			}
			// } // INT_USE
		} else {
			final BroadcastIterator it = new BroadcastIterator(this, bds);
			it.setOutputDouble(true);
			while (it.hasNext()) {
				// if (it.bDouble == 0) { // INT_USE
				// 	data[it.aIndex] = 0; // INT_USE
				// } else { // INT_USE
				data[it.aIndex] /= it.bDouble;
				// } // INT_USE
			}
		}
		setDirty();
		return this;
	}

	@Override
	public FloatDataset ifloor() {
		IndexIterator it = getIterator(); // REAL_ONLY
		while (it.hasNext()) { // REAL_ONLY
			data[it.index] = (float) Math.floor(data[it.index]); // PRIM_TYPE // REAL_ONLY // ADD_CAST
		} // REAL_ONLY
		setDirty(); // REAL_ONLY
		return this;
	}

	@Override
	public FloatDataset iremainder(final Object b) {
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		if (bds.getSize() == 1) {
			final double db = bds.getElementDoubleAbs(0);
			// if (db == 0) { // INT_USE
			// 	fill(0); // INT_USE
			// } else { // INT_USE
			final IndexIterator it = getIterator();
			while (it.hasNext()) {
				data[it.index] %= db;
			}
			// } // INT_USE
		} else {
			final BroadcastIterator it = new BroadcastIterator(this, bds);
			it.setOutputDouble(true);
			while (it.hasNext()) {
				data[it.aIndex] %= it.bDouble; // INT_EXCEPTION
			}
		}
		setDirty();
		return this;
	}

	@Override
	public FloatDataset ipower(final Object b) {
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		if (bds.getSize() == 1) {
			final double vr = bds.getElementDoubleAbs(0);
			final IndexIterator it = getIterator();
			if (bds.isComplex()) {
				final double vi = bds.getElementDoubleAbs(1);
				if (vi == 0.) {
					while (it.hasNext()) {
						final double v = Math.pow(data[it.index], vr);
						// if (Double.isInfinite(v) || Double.isNaN(v)) { // INT_USE
						// 	data[it.index] = 0; // INT_USE
						// } else { // INT_USE
						data[it.index] = (float) v; // PRIM_TYPE_LONG // ADD_CAST
						// } // INT_USE
					}
				} else {
					final Complex zv = new Complex(vr, vi);
					while (it.hasNext()) {
						Complex zd = new Complex(data[it.index], 0.);
						final double v = zd.pow(zv).getReal();
						// if (Double.isInfinite(v) || Double.isNaN(v)) { // INT_USE
						// 	data[it.index] = 0; // INT_USE
						// } else { // INT_USE
						data[it.index] = (float) v; // PRIM_TYPE_LONG // ADD_CAST
						// } // INT_USE
					}
				}
			} else {// NAN_OMIT
				while (it.hasNext()) {
					final double v = Math.pow(data[it.index], vr);
					// if (Double.isInfinite(v) || Double.isNaN(v)) { // INT_USE
					// 	data[it.index] = 0; // INT_USE
					// } else { // INT_USE
					data[it.index] = (float) v; // PRIM_TYPE_LONG // ADD_CAST
					// } // INT_USE
				}
			}
		} else {
			final BroadcastIterator it = new BroadcastIterator(this, bds);
			it.setOutputDouble(true);
			while (it.hasNext()) {
				final double v = Math.pow(it.aDouble, it.bDouble);
				// if (Double.isInfinite(v) || Double.isNaN(v)) { // INT_USE
				// 	data[it.aIndex] = 0; // INT_USE
				// } else { // INT_USE
				data[it.aIndex] = (float) v; // PRIM_TYPE_LONG // ADD_CAST
				// } // INT_USE
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
		if (ignoreNaNs) { // REAL_ONLY
			if (w == null) { // REAL_ONLY
				while (it.hasNext()) { // REAL_ONLY
					final double diff = it.aDouble - it.bDouble; // REAL_ONLY
					if (Double.isNaN(diff)) // REAL_ONLY
						continue; // REAL_ONLY
					final double err = diff * diff - comp; // REAL_ONLY
					final double temp = sum + err; // REAL_ONLY
					comp = (temp - sum) - err; // REAL_ONLY
					sum = temp; // REAL_ONLY
				} // REAL_ONLY
			} else { // REAL_ONLY
				IndexIterator itw = w.getIterator(); // REAL_ONLY
				while (it.hasNext() && itw.hasNext()) { // REAL_ONLY
					final double diff = it.aDouble - it.bDouble; // REAL_ONLY
					if (Double.isNaN(diff)) // REAL_ONLY
						continue; // REAL_ONLY
					final double err = diff * diff * w.getElementDoubleAbs(itw.index) - comp; // REAL_ONLY
					final double temp = sum + err; // REAL_ONLY
					comp = (temp - sum) - err; // REAL_ONLY
					sum = temp; // REAL_ONLY
				} // REAL_ONLY
			} // REAL_ONLY
		} else // REAL_ONLY
		{
			if (w == null) {
				while (it.hasNext()) {
					final double diff = it.aDouble - it.bDouble;
					final double err = diff * diff - comp;
					final double temp = sum + err;
					comp = (temp - sum) - err;
					sum = temp;
				}
			} else {
				IndexIterator itw = w.getIterator();
				while (it.hasNext() && itw.hasNext()) {
					final double diff = it.aDouble - it.bDouble;
					final double err = diff * diff * w.getElementDoubleAbs(itw.index) - comp;
					final double temp = sum + err;
					comp = (temp - sum) - err;
					sum = temp;
				}
			}
		}
		return sum;
	}
}
