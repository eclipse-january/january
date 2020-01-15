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

// This is generated from DoubleDataset.java by fromdouble.py

package org.eclipse.january.dataset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.math3.complex.Complex;
import org.eclipse.january.metadata.StatisticsMetadata;


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

	/**
	 * Create a null dataset
	 */
	FloatDataset() {
	}

	/**
	 * Create a zero-filled dataset of given shape
	 * @param shape
	 */
	FloatDataset(final int... shape) {
		if (shape != null) {
			size = ShapeUtils.calcSize(shape);
			this.shape = shape.clone();

			try {
				odata = data = createArray(size);
			} catch (Throwable t) {
				logger.error("Could not create a dataset of shape {}", Arrays.toString(shape), t);
				throw new IllegalArgumentException(t);
			}
		}
	}

	/**
	 * Create a dataset using given data
	 * @param data
	 * @param shape
	 *            (can be null to create 1D dataset)
	 */
	FloatDataset(final float[] data, int... shape) { // PRIM_TYPE
		if (data == null) {
			throw new IllegalArgumentException("Data must not be null");
		}
		if (shape == null || shape.length == 0) {
			shape = new int[] { data.length };
		}
		size = ShapeUtils.calcSize(shape);
		if (size != data.length) {
			throw new IllegalArgumentException(String.format("Shape %s is not compatible with size of data array, %d",
					Arrays.toString(shape), data.length));
		}
		this.shape = size == 0 ? null : shape.clone();

		odata = this.data = data;
	}

	/**
	 * Copy a dataset
	 * @param dataset
	 */
	FloatDataset(final FloatDataset dataset) {
		copyToView(dataset, this, true, true);

		try {
			if (dataset.stride == null) {
				if (dataset.data != null) {
					odata = data = dataset.data.clone();
				}
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
		} catch (Throwable t) {
			logger.error("Could not create a dataset of shape {}", Arrays.toString(shape), t);
			throw new IllegalArgumentException(t);
		}
	}

	/**
	 * Copy and cast a dataset to this class type
	 * @param dataset
	 */
	FloatDataset(final Dataset dataset) {
		copyToView(dataset, this, true, false);
		offset = 0;
		stride = null;
		base = null;
		try {
			odata = data = createArray(size);
		} catch (Throwable t) {
			logger.error("Could not create a dataset of shape {}", Arrays.toString(shape), t);
			throw new IllegalArgumentException(t);
		}
		IndexIterator iter = dataset.getIterator();
		for (int i = 0; iter.hasNext(); i++) {
			data[i] = (float) dataset.getElementDoubleAbs(iter.index); // GET_ELEMENT_WITH_CAST
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (!getClass().equals(obj.getClass())) {
			if (getRank() == 0) { // for zero-rank datasets
				return obj.equals(getObjectAbs(offset));
			}
			return false;
		}

		FloatDataset other = (FloatDataset) obj;
		if (size != other.size) {
			return false;
		}
		if (!Arrays.equals(shape, other.shape)) {
			return false;
		}
		if (data == other.data && stride == null && other.stride == null) {
			return true;
		}

		IndexIterator iter = getIterator();
		IndexIterator oiter = other.getIterator();
		while (iter.hasNext() && oiter.hasNext()) {
			if (data[iter.index] != other.data[oiter.index]) { // OBJECT_UNEQUAL
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
	static FloatDataset createFromObject(final Object obj) {
		FloatDataset result = new FloatDataset();

		if (obj != null) {
			result.shape = ShapeUtils.getShapeFromObject(obj);
			result.size = ShapeUtils.calcSize(result.shape);

			try {
				result.odata = result.data = createArray(result.size);
			} catch (Throwable t) {
				logger.error("Could not create a dataset of shape {}", Arrays.toString(result.shape), t);
				throw new IllegalArgumentException(t);
			}

			int[] pos = new int[result.shape.length];
			result.fillData(obj, 0, pos);
		}

		return result;
	}
	
	/**
	 *
	 * @param stop
	 * @return a new 1D dataset, filled with values determined by parameters
	 */
	static FloatDataset createRange(final double stop) {
		return createRange(0, stop, 1);
	}
	
	/**
	 *
	 * @param start
	 * @param stop
	 * @param step
	 * @return a new 1D dataset, filled with values determined by parameters
	 */
	static FloatDataset createRange(final double start, final double stop, final double step) {
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
	static FloatDataset ones(final int... shape) {
		return new FloatDataset(shape).fill(1);
	}

	@Override
	public FloatDataset fill(final Object obj) {
		setDirty();
		float dv = (float) DTypeUtils.toReal(obj); // PRIM_TYPE // FROM_OBJECT
		IndexIterator iter = getIterator();
		while (iter.hasNext()) {
			data[iter.index] = dv;
		}

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
	public FloatDataset getView(boolean deepCopyMetadata) {
		FloatDataset view = new FloatDataset();
		copyToView(this, view, true, deepCopyMetadata);
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
		return DTypeUtils.toLong(data[index]); // BOOLEAN_ZERO // OMIT_TOLONG_INT
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
		setDirty();
		data[index] = val;
	}

	@Override
	protected void setItemDirect(final int dindex, final int sindex, final Object src) {
		setDirty();
		float[] dsrc = (float[]) src; // PRIM_TYPE
		data[dindex] = dsrc[sindex];
	}

	@Override
	public void setObjectAbs(final int index, final Object obj) {
		if (index < 0 || index > data.length) {
			throw new IndexOutOfBoundsException("Index given is outside dataset");
		}

		setAbs(index, (float) DTypeUtils.toReal(obj)); // FROM_OBJECT
	}

	/**
	 * @return item in first position
	 * @since 2.0
	 */
	public float get() { // PRIM_TYPE
		return data[getFirst1DIndex()];
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
	public Object getObject() {
		return Float.valueOf(get()); // CLASS_TYPE
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
	public String getString() {
		return getStringAbs(getFirst1DIndex());
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
	public double getDouble() {
		return get(); // BOOLEAN_ZERO
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
	public float getFloat() {
		return get(); // BOOLEAN_ZERO // OMIT_REAL_CAST
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
	public long getLong() {
		return (long) get(); // BOOLEAN_ZERO // OMIT_UPCAST
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
	public int getInt() {
		return (int) get(); // BOOLEAN_ZERO // OMIT_UPCAST
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
	public short getShort() {
		return (short) get(); // BOOLEAN_ZERO // OMIT_UPCAST
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
	public byte getByte() {
		return (byte) get(); // BOOLEAN_ZERO // OMIT_UPCAST
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
	public boolean getBoolean() {
		return get() != 0; // BOOLEAN_FALSE
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
	 * Sets the value at first point to the passed value. The dataset must not be null
	 *
	 * @param value
	 * @since 2.0
	 */
	public void setItem(final float value) { // PRIM_TYPE
		setAbs(getFirst1DIndex(), value);
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
	public void set(final Object obj) {
		setItem((float) DTypeUtils.toReal(obj)); // FROM_OBJECT
	}

	@Override
	public void set(final Object obj, final int i) {
		setItem((float) DTypeUtils.toReal(obj), i); // FROM_OBJECT
	}

	@Override
	public void set(final Object obj, final int i, final int j) {
		setItem((float) DTypeUtils.toReal(obj), i, j); // FROM_OBJECT
	}

	@Override
	public void set(final Object obj, int... pos) {
		if (pos == null || (pos.length == 0 && shape.length > 0)) {
			pos = new int[shape.length];
		}

		setItem((float) DTypeUtils.toReal(obj), pos); // FROM_OBJECT
	}

	@Override
	public void resize(int... newShape) {
		setDirty();
		final IndexIterator iter = getIterator();
		final int nsize = ShapeUtils.calcSize(newShape);
		final float[] ndata; // PRIM_TYPE
		try {
			ndata = createArray(nsize);
		} catch (Throwable t) {
			logger.error("Could not create a dataset of shape {}", Arrays.toString(shape), t);
			throw new IllegalArgumentException(t);
		}
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
		setDirty();
		if (axis == null) {
			if (stride == null) {
				Arrays.sort(data);
			} else {
				FloatDataset ads = clone().sort(null);
				setSlicedView(getView(false), ads);
			}
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
		result.setDirty();

		float[] rdata = ((FloatDataset) result).data; // PRIM_TYPE

		while (riter.hasNext() && iter.hasNext()) {
			rdata[riter.index] = data[iter.index];
		}
	}

	@Override
	public FloatDataset setByBoolean(final Object obj, Dataset selection) {
		setDirty();
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
			final float dv = (float) DTypeUtils.toReal(obj); // PRIM_TYPE // FROM_OBJECT
			final BooleanIterator biter = getBooleanIterator(selection);

			while (biter.hasNext()) {
				data[biter.index] = dv;
			}
		}
		return this;
	}

	@Override
	public FloatDataset setBy1DIndex(final Object obj, final Dataset index) {
		setDirty();
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
			final float dv = (float) DTypeUtils.toReal(obj); // PRIM_TYPE // FROM_OBJECT
			IntegerIterator iter = new IntegerIterator(index, size);

			while (iter.hasNext()) {
				data[iter.index] = dv;
			}
		}
		return this;
	}

	@Override
	public FloatDataset setByIndexes(final Object obj, final Object... indexes) {
		setDirty();
		final IntegersIterator iter = new IntegersIterator(shape, indexes);
		final int[] pos = iter.getPos();

		if (obj instanceof Dataset) {
			final Dataset ds = (Dataset) obj;
			if (ShapeUtils.calcSize(iter.getShape()) != ds.getSize()) {
				throw new IllegalArgumentException(
						"Number of items in index datasets does not match number of items in dataset");
			}

			final IndexIterator oiter = ds.getIterator();

			while (iter.hasNext() && oiter.hasNext()) {
				setItem((float) ds.getElementDoubleAbs(oiter.index), pos); // GET_ELEMENT_WITH_CAST
			}
		} else {
			final float dv = (float) DTypeUtils.toReal(obj); // PRIM_TYPE // FROM_OBJECT

			while (iter.hasNext()) {
				setItem(dv, pos);
			}
		}
		return this;
	}

	@Override
	FloatDataset setSlicedView(Dataset view, Dataset d) {
		setDirty();
		final BroadcastSelfIterator it = BroadcastSelfIterator.createIterator(view, d);

		while (it.hasNext()) {
			data[it.aIndex] = (float) it.bDouble; // BCAST_WITH_CAST d.getElementDoubleAbs(it.bIndex);
		}
		return this;
	}

	@Override
	public FloatDataset setSlice(final Object obj, final IndexIterator siter) {
		setDirty();

		if (obj instanceof IDataset) {
			final IDataset ds = (IDataset) obj;
			final int[] oshape = ds.getShape();

			if (!ShapeUtils.areShapesCompatible(siter.getShape(), oshape)) {
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
				float v = (float) DTypeUtils.toReal(obj); // PRIM_TYPE // FROM_OBJECT

				while (siter.hasNext())
					data[siter.index] = v;
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException("Object for setting slice is not a dataset or number");
			}
		}
		return this;
	}

	@Override
	public void copyItemsFromAxes(final int[] pos, final boolean[] axes, final Dataset dest) {
		float[] ddata = (float[]) dest.getBuffer(); // PRIM_TYPE

		SliceIterator siter = getSliceIteratorFromAxes(pos, axes);
		int[] sshape = ShapeUtils.squeezeShape(siter.getShape(), false);

		IndexIterator diter = dest.getSliceIterator(null, sshape, null);

		if (ddata.length < ShapeUtils.calcSize(sshape)) {
			throw new IllegalArgumentException("destination array is not large enough");
		}

		dest.setDirty();
		while (siter.hasNext() && diter.hasNext()) {
			ddata[diter.index] = data[siter.index];
		}
	}

	@Override
	public void setItemsOnAxes(final int[] pos, final boolean[] axes, final Object src) {
		setDirty();
		float[] sdata = (float[]) src; // PRIM_TYPE

		SliceIterator siter = getSliceIteratorFromAxes(pos, axes);

		if (sdata.length < ShapeUtils.calcSize(siter.getShape())) {
			throw new IllegalArgumentException("destination array is not large enough");
		}

		for (int i = 0; siter.hasNext(); i++) {
			data[siter.index] = sdata[i];
		}
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

	@Override
	public int[] maxPos(boolean... ignoreInvalids) {
		StatisticsMetadata<Number> md = getStats(); // PRIM_TYPE
		// StatisticsMetadata<Number> md = getStats(); // BOOLEAN_USE
		// StatisticsMetadata<String> md = getStringStats(); // OBJECT_USE
		List<int[]> max = md.getMaximumPositions(ignoreInvalids);

		if (max == null) {
			max = findPositions(md.getMaximum(ignoreInvalids).floatValue()); // PRIM_TYPE
			// max = findPositions(md.getMaximum(ignoreInvalids).intValue() != 0); // BOOLEAN_USE
			// max = findPositions(md.getMaximum(ignoreInvalids).toString()); // OBJECT_USE

			md.setMaximumPositions(max);
		}

		return max.get(0); // first maximum
	}

	@Override
	public int[] minPos(boolean... ignoreInvalids) {
		StatisticsMetadata<Number> md = getStats(); // PRIM_TYPE
		// StatisticsMetadata<Number> md = getStats(); // BOOLEAN_USE
		// StatisticsMetadata<String> md = getStringStats(); // OBJECT_USE
		List<int[]> min = md.getMinimumPositions(ignoreInvalids);

		if (min == null) {
			min = findPositions(md.getMinimum(ignoreInvalids).floatValue()); // PRIM_TYPE
			// min = findPositions(md.getMinimum(ignoreInvalids).intValue() != 0); // BOOLEAN_USE
			// min = findPositions(md.getMinimum(ignoreInvalids).toString()); // OBJECT_USE

			md.setMinimumPositions(min);
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
		setDirty();
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		boolean useLong = bds.getElementClass().equals(Long.class);
		if (bds.getSize() == 1) {
			final IndexIterator it = getIterator();
			final int bOffset = bds.getOffset();
			if (useLong) {
				final long lb = bds.getElementLongAbs(bOffset);
				while (it.hasNext()) {
					data[it.index] += lb;
				}
			} else {
				final double db = bds.getElementDoubleAbs(bOffset);
				while (it.hasNext()) {
					data[it.index] += db;
				}
			}
		} else {
			final BroadcastSelfIterator it = BroadcastSelfIterator.createIterator(this, bds);
			it.setOutputDouble(!useLong);
			if (useLong) {
				while (it.hasNext()) {
					data[it.aIndex] += it.bLong;
				}
			} else {
				while (it.hasNext()) {
					data[it.aIndex] += it.bDouble;
				}
			}
		}
		return this;
	}

	@Override
	public FloatDataset isubtract(final Object b) {
		setDirty();
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		boolean useLong = bds.getElementClass().equals(Long.class);
		if (bds.getSize() == 1) {
			final IndexIterator it = getIterator();
			final int bOffset = bds.getOffset();
			if (useLong) {
				final long lb = bds.getElementLongAbs(bOffset);
				while (it.hasNext()) {
					data[it.index] -= lb;
				}
			} else {
				final double db = bds.getElementDoubleAbs(bOffset);
				while (it.hasNext()) {
					data[it.index] -= db;
				}
			}
		} else {
			final BroadcastSelfIterator it = BroadcastSelfIterator.createIterator(this, bds);
			if (useLong) {
				it.setOutputDouble(false);
				while (it.hasNext()) {
					data[it.aIndex] -= it.bLong;
				}
			} else {
				it.setOutputDouble(true);
				while (it.hasNext()) {
					data[it.aIndex] -= it.bDouble;
				}
			}
		}
		return this;
	}

	@Override
	public FloatDataset imultiply(final Object b) {
		setDirty();
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		boolean useLong = bds.getElementClass().equals(Long.class);
		if (bds.getSize() == 1) {
			final IndexIterator it = getIterator();
			final int bOffset = bds.getOffset();
			if (useLong) {
				final long lb = bds.getElementLongAbs(bOffset);
				while (it.hasNext()) {
					data[it.index] *= lb;
				}
			} else {
				final double db = bds.getElementDoubleAbs(bOffset);
				while (it.hasNext()) {
					data[it.index] *= db;
				}
			}
		} else {
			final BroadcastSelfIterator it = BroadcastSelfIterator.createIterator(this, bds);
			it.setOutputDouble(!useLong);
			if (useLong) {
				while (it.hasNext()) {
					data[it.aIndex] *= it.bLong;
				}
			} else {
				while (it.hasNext()) {
					data[it.aIndex] *= it.bDouble;
				}
			}
		}
		return this;
	}

	@Override
	public FloatDataset idivide(final Object b) {
		setDirty();
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		boolean useLong = bds.getElementClass().equals(Long.class);
		if (bds.getSize() == 1) {
			final int bOffset = bds.getOffset();
			if (useLong) {
				final long lb = bds.getElementLongAbs(bOffset);
				// if (lb == 0) { // INT_USE
				// 	fill(0); // INT_USE
				// } else { // INT_USE
				final IndexIterator it = getIterator();
				while (it.hasNext()) {
					data[it.index] /= lb;
				}
				// } // INT_USE
			} else {
				final double db = bds.getElementDoubleAbs(bOffset);
				// if (db == 0) { // INT_USE
				// 	fill(0); // INT_USE
				// } else { // INT_USE
				final IndexIterator it = getIterator();
				while (it.hasNext()) {
					data[it.index] /= db;
				}
				// } // INT_USE
			}
		} else {
			final BroadcastSelfIterator it = BroadcastSelfIterator.createIterator(this, bds);
			it.setOutputDouble(!useLong);
			if (useLong) {
				while (it.hasNext()) {
					// if (it.bLong == 0) { // INT_USE
					// 	data[it.aIndex] = 0; // INT_USE
					// } else { // INT_USE
					data[it.aIndex] /= it.bLong;
					// } // INT_USE
				}
			} else {
				while (it.hasNext()) {
					// if (it.bDouble == 0) { // INT_USE
					// 	data[it.aIndex] = 0; // INT_USE
					// } else { // INT_USE
					data[it.aIndex] /= it.bDouble;
					// } // INT_USE
				}
			}
		}
		return this;
	}

	@Override
	public FloatDataset ifloor() {
		setDirty(); // REAL_ONLY
		IndexIterator it = getIterator(); // REAL_ONLY
		while (it.hasNext()) { // REAL_ONLY
			data[it.index] = (float) Math.floor(data[it.index]); // PRIM_TYPE // REAL_ONLY // ADD_CAST
		} // REAL_ONLY
		return this;
	}

	@Override
	public FloatDataset iremainder(final Object b) {
		setDirty();
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		boolean useLong = bds.getElementClass().equals(Long.class);
		if (bds.getSize() == 1) {
			final int bOffset = bds.getOffset();
			if (useLong) {
				final long lb = bds.getElementLongAbs(bOffset);
				// if (lb == 0) { // INT_USE
				// 	fill(0); // INT_USE
				// } else { // INT_USE
				final IndexIterator it = getIterator();
				while (it.hasNext()) {
					data[it.index] %= lb;
				}
				// } // INT_USE
			} else {
				final long lb = bds.getElementLongAbs(bOffset);
				// if (lb == 0) { // INT_USE
				// 	fill(0); // INT_USE
				// } else { // INT_USE
				final IndexIterator it = getIterator();
				while (it.hasNext()) {
					data[it.index] %= lb;
				}
				// } // INT_USE
			}
		} else {
			final BroadcastSelfIterator it = BroadcastSelfIterator.createIterator(this, bds);
			it.setOutputDouble(!useLong);
			if (useLong) {
				while (it.hasNext()) {
					data[it.aIndex] %= it.bLong; // INT_EXCEPTION
				}
			} else {
				while (it.hasNext()) {
					data[it.aIndex] %= it.bDouble;
				}
			}
		}
		return this;
	}

	@Override
	public FloatDataset ipower(final Object b) {
		setDirty();
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		if (bds.getSize() == 1) {
			final int bOffset = bds.getOffset();
			final double vr = bds.getElementDoubleAbs(bOffset);
			final IndexIterator it = getIterator();
			if (bds.isComplex()) {
				final double vi = bds.getElementDoubleAbs(bOffset + 1);
				if (vi == 0) {
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
						Complex zd = new Complex(data[it.index], 0);
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
			final BroadcastIterator it = BroadcastIterator.createIterator(this, bds);
			it.setOutputDouble(true);
			if (bds.isComplex()) {
				while (it.hasNext()) {
					final Complex zv = new Complex(it.bDouble, bds.getElementDoubleAbs(it.bIndex + 1));
					final double v = new Complex(it.aDouble, 0).pow(zv).getReal();
					// if (Double.isInfinite(v) || Double.isNaN(v)) { // INT_USE
					// 	data[it.aIndex] = 0; // INT_USE
					// } else { // INT_USE
					data[it.aIndex] = (float) v; // PRIM_TYPE_LONG // ADD_CAST
					// } // INT_USE
				}
			} else {// NAN_OMIT
				while (it.hasNext()) {
					final double v = Math.pow(it.aDouble, it.bDouble);
					// if (Double.isInfinite(v) || Double.isNaN(v)) { // INT_USE
					// 	data[it.aIndex] = 0; // INT_USE
					// } else { // INT_USE
					data[it.aIndex] = (float) v; // PRIM_TYPE_LONG // ADD_CAST
					// } // INT_USE
				}
			}
		}
		return this;
	}

	@Override
	public double residual(final Object b, final Dataset w, boolean ignoreNaNs) {
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		final BroadcastIterator it = BroadcastIterator.createIterator(this, bds);
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
