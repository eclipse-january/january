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

// This is generated from ComplexDoubleDataset.java by fromcpxdouble.py

package org.eclipse.january.dataset;


import java.util.Arrays;

import org.apache.commons.math3.complex.Complex;


/**
 * Extend compound dataset to hold complex float values // PRIM_TYPE
 */
public class ComplexFloatDataset extends CompoundFloatDataset { // CLASS_TYPE
	// pin UID to base class
	private static final long serialVersionUID = Dataset.serialVersionUID;

	private static final int ISIZE = 2; // number of elements per item

	/**
	 * Create a null dataset
	 */
	ComplexFloatDataset() {
		super(ISIZE);
	}

	/**
	 * Create a zero-filled dataset of given shape
	 * @param shape
	 */
	ComplexFloatDataset(final int... shape) {
		super(ISIZE, shape);
	}

	/**
	 * Create a dataset using given data (real and imaginary parts are grouped in pairs)
	 * @param data
	 * @param shape (can be null to create 1D dataset)
	 */
	ComplexFloatDataset(final float[] data, final int... shape) { // PRIM_TYPE
		super(ISIZE, data, shape);
	}

	/**
	 * Copy a dataset
	 * @param dataset
	 */
	ComplexFloatDataset(final ComplexFloatDataset dataset) {
		super(dataset);
	}

	/**
	 * Create a dataset using given data (real and imaginary parts are given separately)
	 * @param realData
	 * @param imagData
	 * @param shape (can be null or zero-length to create 1D dataset)
	 */
	ComplexFloatDataset(final float[] realData, final float[] imagData, int... shape) { // PRIM_TYPE
		if (realData == null || imagData == null) {
			throw new IllegalArgumentException("Data must not be null");
		}
		int dsize = realData.length > imagData.length ? imagData.length : realData.length;
		if (shape == null || shape.length == 0) {
			shape = new int[] {dsize};
		}
		isize = ISIZE;
		size = ShapeUtils.calcSize(shape);
		if (size != dsize) {
			throw new IllegalArgumentException(String.format("Shape %s is not compatible with size of data array, %d",
					Arrays.toString(shape), dsize));
		}
		this.shape = size == 0 ? null : shape.clone();

		try {
			odata = data = createArray(size);
		} catch (Throwable t) {
			logger.error("Could not create a dataset of shape {}", Arrays.toString(shape), t);
			throw new IllegalArgumentException(t);
		}

		for (int i = 0, n = 0; i < size; i++) {
			data[n++] = realData[i];
			data[n++] = imagData[i];
		}
	}

	/**
	 * Create a dataset using given data (real and imaginary parts are given separately)
	 * @param real
	 * @param imag
	 */
	ComplexFloatDataset(final Dataset real, final Dataset imag) {
		super(ISIZE, real.getShapeRef());
		real.checkCompatibility(imag);

		IndexIterator riter = real.getIterator();
		IndexIterator iiter = imag.getIterator();

		for (int i = 0; riter.hasNext() && iiter.hasNext();) {
			data[i++] = (float) real.getElementDoubleAbs(riter.index); // ADD_CAST
			data[i++] = (float) imag.getElementDoubleAbs(iiter.index); // ADD_CAST
		}
	}

	/**
	 * Copy and cast a dataset to this complex type
	 * @param dataset
	 */
	ComplexFloatDataset(final Dataset dataset) {
		super(ISIZE, dataset.getShapeRef());
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
		if (dataset.isComplex()) {
			for (int i = 0; iter.hasNext(); i += isize) {
				data[i] = (float) dataset.getElementDoubleAbs(iter.index); // ADD_CAST
				data[i+1] = (float) dataset.getElementDoubleAbs(iter.index+1); // ADD_CAST
			}
		} else {
			for (int i = 0; iter.hasNext(); i += isize) {
				data[i] = (float) dataset.getElementDoubleAbs(iter.index); // ADD_CAST
			}
		}
	}

	@Override
	public ComplexFloatDataset clone() {
		return new ComplexFloatDataset(this);
	}

	/**
	 * Create a dataset from an object which could be a Java list, array (of arrays...)
	 * or Number. Ragged sequences or arrays are padded with zeros.
	 *
	 * @param obj
	 * @return dataset with contents given by input
	 */
	static ComplexFloatDataset createFromObject(final Object obj) {
		ComplexFloatDataset result = new ComplexFloatDataset();

		result.shape = ShapeUtils.getShapeFromObject(obj);
		result.size = ShapeUtils.calcSize(result.shape);

		try {
			result.odata = result.data = result.createArray(result.size);
		} catch (Throwable t) {
			logger.error("Could not create a dataset of shape {}", Arrays.toString(result.shape), t);
			throw new IllegalArgumentException(t);
		}

		int[] pos = new int[result.shape.length];
		result.fillData(obj, 0, pos);
		return result;
	}

	/**
	 * @param stop
	 * @return a new 1D dataset, filled with values determined by parameters
	 */
	static ComplexFloatDataset createRange(final double stop) {
		return createRange(0, stop, 1);
	}

	/**
	 * @param start
	 * @param stop
	 * @param step
	 * @return a new 1D dataset, filled with values determined by parameters
	 */
	static ComplexFloatDataset createRange(final double start, final double stop, final double step) {
		int size = calcSteps(start, stop, step);
		ComplexFloatDataset result = new ComplexFloatDataset(size);
		for (int i = 0; i < size; i ++) {
			result.data[i*ISIZE] = (float) (start + i*step); // ADD_CAST
		}
		return result;
	}

	/**
	 * @param shape
	 * @return a dataset filled with ones
	 */
	static ComplexFloatDataset ones(final int... shape) {
		return new ComplexFloatDataset(shape).fill(1);
	}

	@Override
	public boolean isComplex() {
		return true;
	}

	@Override
	public ComplexFloatDataset fill(final Object obj) {
		setDirty();
		float vr = (float) DTypeUtils.toReal(obj); // PRIM_TYPE // ADD_CAST
		float vi = (float) DTypeUtils.toImag(obj); // PRIM_TYPE // ADD_CAST
		IndexIterator iter = getIterator();

		while (iter.hasNext()) {
			data[iter.index] = vr;
			data[iter.index+1] = vi;
		}

		return this;
	}

	@Override
	public ComplexFloatDataset getView(boolean deepCopyMetadata) {
		ComplexFloatDataset view = new ComplexFloatDataset();
		copyToView(this, view, true, deepCopyMetadata);
		view.data = data;
		return view;
	}

	/**
	 * Get complex value at absolute index in the internal array.
	 *
	 * This is an internal method with no checks so can be dangerous. Use with care or ideally with an iterator.
	 *
	 * @param index absolute index
	 * @return value
	 */
	public Complex getComplexAbs(final int index) {
		return new Complex(data[index], data[index+1]);
	}

	@Override
	public Object getObjectAbs(final int index) {
		return new Complex(data[index], data[index+1]);
	}

	@Override
	public String getStringAbs(final int index) {
		float di = data[index + 1]; // PRIM_TYPE
		if (stringFormat == null) {
			return di >= 0 ? String.format("%.8g + %.8gj", data[index], di) : // FORMAT_STRING
				String.format("%.8g - %.8gj", data[index], -di); // FORMAT_STRING
		}
		StringBuilder s = new StringBuilder();
		s.append(stringFormat.format(data[index]));
		if (di >= 0) {
			s.append(" + ");
			s.append(stringFormat.format(di));
		} else {
			s.append(" - ");
			s.append(stringFormat.format(-di));
		}
		s.append('j');
		return s.toString();
	}

	/**
	 * Set values at absolute index in the internal array.
	 *
	 * This is an internal method with no checks so can be dangerous. Use with care or ideally with an iterator.
	 * @param index absolute index
	 * @param val new values
	 */
	public void setAbs(final int index, final Complex val) {
		setAbs(index, (float) val.getReal(), (float) val.getImaginary()); // PRIM_TYPE
	}

	@Override
	public void setObjectAbs(final int index, final Object obj) {
		setAbs(index, (float) DTypeUtils.toReal(obj), (float) DTypeUtils.toImag(obj)); // PRIM_TYPE
	}

	/**
	 * Set item at index to complex value given by real and imaginary parts
	 * @param index absolute index
	 * @param real
	 * @param imag
	 */
	public void setAbs(final int index, final float real, final float imag) { // PRIM_TYPE
		setDirty();
		data[index] = real;
		data[index+1] = imag;
	}

	/**
	 * @return item in first position
	 * @since 2.0
	 */
	public Complex get() {
		int n = getFirst1DIndex();
		Complex z = new Complex(data[n], data[n+1]);
		return z;
	}

	/**
	 * @param i
	 * @return item in given position
	 */
	public Complex get(final int i) {
		int n = get1DIndex(i);
		Complex z = new Complex(data[n], data[n+1]);
		return z;
	}

	/**
	 * @param i
	 * @param j
	 * @return item in given position
	 */
	public Complex get(final int i, final int j) {
		int n = get1DIndex(i, j);
		Complex z = new Complex(data[n], data[n+1]);
		return z;
	}

	/**
	 * @param pos
	 * @return item in given position
	 */
	public Complex get(final int... pos) {
		int n = get1DIndex(pos);
		Complex z = new Complex(data[n], data[n+1]);
		return z;
	}

	@Override
	public Object getObject() {
		return get();
	}

	@Override
	public Object getObject(final int i) {
		return get(i);
	}

	@Override
	public Object getObject(final int i, final int j) {
		return get(i, j);
	}

	@Override
	public Object getObject(final int... pos) {
		return getComplex(pos);
	}

	/**
	 * @return item in first position
	 * @since 2.0
	 */
	public float getReal() { // PRIM_TYPE
		return (float) getFirstValue(); // PRIM_TYPE
	}

	/**
	 * @param i
	 * @return item in given position
	 */
	public float getReal(final int i) { // PRIM_TYPE
		return (float) getFirstValue(i); // PRIM_TYPE
	}

	/**
	 * @param i
	 * @param j
	 * @return item in given position
	 */
	public float getReal(final int i, final int j) { // PRIM_TYPE
		return (float) getFirstValue(i, j); // PRIM_TYPE
	}

	/**
	 * @param pos
	 * @return item in given position
	 */
	public float getReal(final int... pos) { // PRIM_TYPE
		return (float) getFirstValue(pos); // PRIM_TYPE
	}

	/**
	 * @return item in first position
	 * @since 2.0
	 */
	public float getImag() { // PRIM_TYPE
		return data[getFirst1DIndex() + 1];
	}

	/**
	 * @param i
	 * @return item in given position
	 */
	public float getImag(final int i) { // PRIM_TYPE
		return data[get1DIndex(i) + 1];
	}

	/**
	 * @param i
	 * @param j
	 * @return item in given position
	 */
	public float getImag(final int i, final int j) { // PRIM_TYPE
		return data[get1DIndex(i, j) + 1];
	}

	/**
	 * @param pos
	 * @return item in given position
	 */
	public float getImag(final int... pos) { // PRIM_TYPE
		return data[get1DIndex(pos) + 1];
	}

	/**
	 * @return item in first position
	 * @since 2.0
	 */
	public Complex getComplex() {
		return get();
	}

	/**
	 * @param i
	 * @return item in given position
	 */
	public Complex getComplex(final int i) {
		return get(i);
	}

	/**
	 * @param i
	 * @param j
	 * @return item in given position
	 */
	public Complex getComplex(final int i, final int j) {
		return get(i, j);
	}

	/**
	 * @param pos
	 * @return item in given position
	 */
	public Complex getComplex(final int... pos) {
		return get(pos);
	}

	@Override
	public void set(final Object obj, final int i) {
		setItem(new float[] {(float) DTypeUtils.toReal(obj), (float) DTypeUtils.toImag(obj)}, i); // PRIM_TYPE
	}

	@Override
	public void set(final Object obj, final int i, final int j) {
		setItem(new float[] {(float) DTypeUtils.toReal(obj), (float) DTypeUtils.toImag(obj)}, i, j); // PRIM_TYPE
	}

	@Override
	public void set(final Object obj, int... pos) {
		if (pos == null || (pos.length == 0 && shape.length > 0)) {
			pos = new int[shape.length];
		}

		setItem(new float[] {(float) DTypeUtils.toReal(obj), (float) DTypeUtils.toImag(obj)}, pos); // PRIM_TYPE
	}

	/**
	 * Set real and imaginary values at given position
	 * @param dr
	 * @param di
	 * @param i
	 */
	public void set(final float dr, final float di, final int i) { // PRIM_TYPE
		setItem(new float[] {dr, di}, i); // PRIM_TYPE
	}

	/**
	 * Set real and imaginary values at given position
	 * @param dr
	 * @param di
	 * @param i
	 * @param j
	 */
	public void set(final float dr, final float di, final int i, final int j) { // PRIM_TYPE
		setItem(new float[] {dr, di}, i, j); // PRIM_TYPE
	}

	/**
	 * Set real and imaginary values at given position
	 * @param dr
	 * @param di
	 * @param pos
	 * @since 2.0
	 */
	public void set(final float dr, final float di, final int... pos) { // PRIM_TYPE
		setItem(new float[] {dr, di}, pos); // PRIM_TYPE
	}

	/**
	 * @since 2.0
	 */
	@Override
	public FloatDataset getRealPart() { // CLASS_TYPE
		return getElements(0);
	}

	/**
	 * @since 2.0
	 */
	@Override
	public FloatDataset getRealView() { // CLASS_TYPE
		return getElementsView(0);
	}

	/**
	 * @return imaginary part of dataset as new dataset
	 * @since 2.0
	 */
	public FloatDataset getImaginaryPart() { // CLASS_TYPE
		return getElements(1);
	}

	/**
	 * @return view of imaginary values
	 */
	public FloatDataset getImaginaryView() { // CLASS_TYPE
		return getElementsView(1);
	}

	@Override
	public Number max(boolean... switches) {
		throw new UnsupportedOperationException("Cannot compare complex numbers");
	}

	@Override
	public Number min(boolean... switches) {
		throw new UnsupportedOperationException("Cannot compare complex numbers");
	}

	@Override
	public Object sum(boolean... switches) { // FIXME
		double[] sum = (double[]) super.sum(switches);
		return new Complex(sum[0], sum[1]);
	}

	@Override
	public Object mean(boolean... switches) {
		double[] mean = (double[]) super.mean(switches);
		return new Complex(mean[0], mean[1]);
	}

	@Override
	public int[] maxPos(boolean... switches) {
		throw new UnsupportedOperationException("Cannot compare complex numbers");
	}

	@Override
	public int[] minPos(boolean... switches) {
		throw new UnsupportedOperationException("Cannot compare complex numbers");
	}

	@Override
	public ComplexFloatDataset getSlice(final SliceIterator siter) {
		ComplexFloatDataset result = new ComplexFloatDataset(siter.getShape());
		float[] rdata = result.data; // PRIM_TYPE
		IndexIterator riter = result.getIterator();

		while (siter.hasNext() && riter.hasNext()) {
			rdata[riter.index] = data[siter.index];
			rdata[riter.index+1] = data[siter.index+1];
		}

		result.setName(name + BLOCK_OPEN + Slice.createString(siter.shape, siter.start, siter.stop, siter.step) + BLOCK_CLOSE);
		return result;
	}

	@Override
	ComplexFloatDataset setSlicedView(Dataset view, Dataset d) {
		setDirty();
		final BroadcastSelfIterator it = BroadcastSelfIterator.createIterator(view, d);

		if (d instanceof ComplexFloatDataset || d instanceof ComplexFloatDataset) {
			while (it.hasNext()) {
				data[it.aIndex] = (float) it.bDouble; // BCAST_WITH_CAST d.getElementDoubleAbs(it.bIndex);
				data[it.aIndex + 1] = (float) d.getElementDoubleAbs(it.bIndex + 1); // GET_ELEMENT_WITH_CAST
			}
		} else {
			while (it.hasNext()) {
				data[it.aIndex] = (float) it.bDouble; // BCAST_WITH_CAST d.getElementDoubleAbs(it.bIndex);
				data[it.aIndex + 1] = 0;
			}
		}
		return this;
	}

	@Override
	public ComplexFloatDataset setSlice(final Object o, final IndexIterator siter) {
		setDirty();
		if (o instanceof ComplexFloatDataset) {
			ComplexFloatDataset zds = (ComplexFloatDataset) o;

			if (!ShapeUtils.areShapesCompatible(siter.getShape(), zds.shape)) {
				throw new IllegalArgumentException(String.format(
						"Input dataset is not compatible with slice: %s cf %s", Arrays.toString(zds.shape),
						Arrays.toString(siter.getShape())));
			}

			IndexIterator oiter = zds.getIterator();
			float[] odata = zds.data;

			while (siter.hasNext() && oiter.hasNext()) {
				data[siter.index] = odata[oiter.index];
				data[siter.index+1] = odata[oiter.index+1];
			}
		} else if (o instanceof ComplexDoubleDataset) { // IGNORE_CLASS
			ComplexDoubleDataset zds = (ComplexDoubleDataset) o; // IGNORE_CLASS

			if (!ShapeUtils.areShapesCompatible(siter.getShape(), zds.shape)) {
				throw new IllegalArgumentException(String.format(
						"Input dataset is not compatible with slice: %s cf %s", Arrays.toString(zds.shape),
						Arrays.toString(siter.getShape())));
			}

			IndexIterator oiter = zds.getIterator();
			double[] odata = zds.data;

			while (siter.hasNext() && oiter.hasNext()) {
				data[siter.index] = (float) odata[oiter.index]; // PRIM_TYPE // ADD_CAST
				data[siter.index+1] = (float) odata[oiter.index+1]; // PRIM_TYPE // ADD_CAST
			}
		} else if (o instanceof IDataset) {
			super.setSlice(o, siter);
		} else {
			try {
				float vr = (float) DTypeUtils.toReal(o); // PRIM_TYPE // ADD_CAST
				float vi = (float) DTypeUtils.toImag(o); // PRIM_TYPE // ADD_CAST

				while (siter.hasNext()) {
					data[siter.index]     = vr;
					data[siter.index + 1] = vi;
				}
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException("Object for setting slice is not a dataset or number");
			}
		}
		return this;
	}

	@Override
	public ComplexFloatDataset iadd(final Object b) {
		setDirty();
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		boolean useLong = bds.getElementClass().equals(Long.class);
		if (bds.getSize() == 1) {
			final IndexIterator it = getIterator();
			final int bOffset = bds.getOffset();
			if (useLong) { // note no complex longs
				final long lb = bds.getElementLongAbs(bOffset);
				while (it.hasNext()) {
					data[it.index] += lb;
				}
			} else {
				final double db = bds.getElementDoubleAbs(bOffset);
				if (!bds.isComplex() || bds.getElementDoubleAbs(bOffset + 1) == 0) {
					while (it.hasNext()) {
						data[it.index] += db;
					}
				} else {
					final double vi = bds.getElementDoubleAbs(bOffset + 1);
					while (it.hasNext()) {
						data[it.index]     += db;
						data[it.index + 1] += vi;
					}
				}
			}
		} else {
			final BroadcastSelfIterator it = BroadcastSelfIterator.createIterator(this, bds);
			it.setOutputDouble(!useLong);
			if (useLong) { // note no complex longs
				while (it.hasNext()) {
					data[it.aIndex] += it.bLong;
				}
			} else {
				if (bds.isComplex()) {
					while (it.hasNext()) {
						data[it.aIndex]     += it.bDouble;
						data[it.aIndex + 1] += bds.getElementDoubleAbs(it.bIndex + 1);
					}
				} else {
					while (it.hasNext()) {
						data[it.aIndex] += it.bDouble;
					}
				}
			}
		}
		return this;
	}

	@Override
	public ComplexFloatDataset isubtract(final Object b) {
		setDirty();
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		boolean useLong = bds.getElementClass().equals(Long.class);
		if (bds.getSize() == 1) {
			final IndexIterator it = getIterator();
			final int bOffset = bds.getOffset();
			if (useLong) { // note no complex longs
				final long lb = bds.getElementLongAbs(bOffset);
				while (it.hasNext()) {
					data[it.index] -= lb;
				}
			} else {
				final double db = bds.getElementDoubleAbs(bOffset);
				if (!bds.isComplex() || bds.getElementDoubleAbs(bOffset + 1) == 0) {
					while (it.hasNext()) {
						data[it.index] -= db;
					}
				} else {
					final double vi = bds.getElementDoubleAbs(bOffset + 1);
					while (it.hasNext()) {
						data[it.index]     -= db;
						data[it.index + 1] -= vi;
					}
				}
			}
		} else {
			final BroadcastSelfIterator it = BroadcastSelfIterator.createIterator(this, bds);
			it.setOutputDouble(!useLong);
			if (useLong) { // note no complex longs
				while (it.hasNext()) {
					data[it.aIndex] -= it.bLong;
				}
			} else {
				if (bds.isComplex()) {
					while (it.hasNext()) {
						data[it.aIndex]     -= it.bDouble;
						data[it.aIndex + 1] -= bds.getElementDoubleAbs(it.bIndex + 1);
					}
				} else {
					while (it.hasNext()) {
						data[it.aIndex] -= it.bDouble;
					}
				}
			}
		}
		return this;
	}

	@Override
	public ComplexFloatDataset imultiply(final Object b) {
		setDirty();
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		boolean useLong = bds.getElementClass().equals(Long.class);
		if (bds.getSize() == 1) {
			final IndexIterator it = getIterator();
			final int bOffset = bds.getOffset();
			if (useLong) { // note no complex longs
				final long r2 = bds.getElementLongAbs(bOffset);
				while (it.hasNext()) {
					data[it.index]     *= r2;
					data[it.index + 1] *= r2;
				}
			} else {
				final double r2 = bds.getElementDoubleAbs(bOffset);
				if (!bds.isComplex() || bds.getElementDoubleAbs(bOffset + 1) == 0) {
					while (it.hasNext()) {
						data[it.index]     *= r2;
						data[it.index + 1] *= r2;
					}
				} else {
					final double i2 = bds.getElementDoubleAbs(bOffset + 1);
					while (it.hasNext()) {
						double r1 = data[it.index];
						double i1 = data[it.index + 1];
						data[it.index]     = (float) (r1*r2 - i1*i2); // ADD_CAST
						data[it.index + 1] = (float) (r1*i2 + i1*r2); // ADD_CAST
					}
				}
			}
		} else {
			final BroadcastIterator it = BroadcastIterator.createIterator(this, bds);
			it.setOutputDouble(!useLong);
			if (useLong) { // note no complex longs
				while (it.hasNext()) {
					data[it.aIndex]     *= it.bDouble;
					data[it.aIndex + 1] *= it.bDouble;
				}
			} else {
				if (bds.isComplex()) {
					while (it.hasNext()) {
						double r1 = it.aDouble;
						double r2 = it.bDouble;
						double i1 = data[it.aIndex + 1];
						double i2 = bds.getElementDoubleAbs(it.bIndex + 1);
						data[it.aIndex]     = (float) (r1*r2 - i1*i2); // ADD_CAST
						data[it.aIndex + 1] = (float) (r1*i2 + i1*r2); // ADD_CAST
					}
				} else {
					while (it.hasNext()) {
						data[it.aIndex]     *= it.bDouble;
						data[it.aIndex + 1] *= it.bDouble;
					}
				}
			}
		}
		return this;
	}

	@Override
	public ComplexFloatDataset idivide(final Object b) {
		setDirty();
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		boolean useLong = bds.getElementClass().equals(Long.class);
		if (bds.getSize() == 1) {
			final IndexIterator it = getIterator();
			final int bOffset = bds.getOffset();
			if (useLong) { // note no complex longs
				final long r2 = bds.getElementLongAbs(bOffset);
				while (it.hasNext()) {
					data[it.index]     /= r2;
					data[it.index + 1] /= r2;
				}
			} else {
				final double r2 = bds.getElementDoubleAbs(bOffset);
				if (!bds.isComplex() || bds.getElementDoubleAbs(bOffset + 1) == 0) {
					while (it.hasNext()) {
						data[it.index]     /= r2;
						data[it.index + 1] /= r2;
					}
				} else {
					final double i2 = bds.getElementDoubleAbs(bOffset + 1);
					if (Math.abs(r2) < Math.abs(i2)) {
						double q = r2/i2;
						double den = r2*q + i2;
						while (it.hasNext()) {
							double r1 = data[it.index];
							double i1 = data[it.index + 1];
							data[it.index]     = (float) ((r1*q + i1) / den); // ADD_CAST
							data[it.index + 1] = (float) ((i1*q - r1) / den); // ADD_CAST
						}
					} else {
						double q = i2/r2;
						double den = i2*q + r2;
						if (den == 0) {
							while (it.hasNext()) {
								data[it.index]     = Float.NaN; // CLASS_TYPE
								data[it.index + 1] = Float.NaN; // CLASS_TYPE
							}
						} else {
							while (it.hasNext()) {
								double r1 = data[it.index];
								double i1 = data[it.index + 1];
								data[it.index]     = (float) ((i1 * q + r1) / den); // ADD_CAST
								data[it.index + 1] = (float) ((i1 - r1 * q) / den); // ADD_CAST
							}
						}
					}
				}
			}
		} else {
			final BroadcastIterator it = BroadcastIterator.createIterator(this, bds);
			it.setOutputDouble(!useLong);
			if (useLong) {
				while (it.hasNext()) {
					data[it.aIndex]     /= it.bLong;
					data[it.aIndex + 1] /= it.bLong;
				}
			} else {
				if (bds.isComplex()) {
					while (it.hasNext()) {
						double r1 = it.aDouble;
						double r2 = it.bDouble;
						double i1 = data[it.aIndex + 1];
						double i2 = bds.getElementDoubleAbs(it.bIndex + 1);
						if (Math.abs(r2) < Math.abs(i2)) {
							double q = r2/i2;
							double den = r2*q + i2;
							data[it.aIndex]     = (float) ((r1*q + i1) / den); // ADD_CAST
							data[it.aIndex + 1] = (float) ((i1*q - r1) / den); // ADD_CAST
						} else {
							double q = i2/r2;
							double den = i2*q + r2;
							if (den == 0) {
								data[it.aIndex]     = Float.NaN; // CLASS_TYPE
								data[it.aIndex + 1] = Float.NaN; // CLASS_TYPE
							} else {
								data[it.aIndex]     = (float) ((i1 * q + r1) / den); // ADD_CAST
								data[it.aIndex + 1] = (float) ((i1 - r1 * q) / den); // ADD_CAST
							}
						}
					}
				} else {
					while (it.hasNext()) {
						data[it.aIndex]     /= it.bDouble;
						data[it.aIndex + 1] /= it.bDouble;
					}
				}
			}
		}
		return this;
	}

	@Override
	public ComplexFloatDataset iremainder(final Object b) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public ComplexFloatDataset ipower(final Object b) {
		setDirty();
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		if (bds.getSize() == 1) {
			final IndexIterator it = getIterator();
			final int bOffset = bds.getOffset();
			final double r2 = bds.getElementDoubleAbs(bOffset);
			if (!bds.isComplex() || bds.getElementDoubleAbs(bOffset + 1) == 0) {
				while (it.hasNext()) {
					final Complex zd = new Complex(data[it.index], data[it.index + 1]).pow(r2);
					data[it.index]     = (float) zd.getReal(); // ADD_CAST
					data[it.index + 1] = (float) zd.getImaginary(); // ADD_CAST
				}
			} else {
				final Complex zv = new Complex(r2, bds.getElementDoubleAbs(bOffset + 1));
				while (it.hasNext()) {
					final Complex zd = new Complex(data[it.index], data[it.index + 1]).pow(zv);
					data[it.index]     = (float) zd.getReal(); // ADD_CAST
					data[it.index + 1] = (float) zd.getImaginary(); // ADD_CAST
				}
			}
		} else {
			final BroadcastIterator it = BroadcastIterator.createIterator(this, bds);
			it.setOutputDouble(true);
			if (bds.isComplex()) {
				while (it.hasNext()) {
					final Complex zv = new Complex(it.bDouble, bds.getElementDoubleAbs(it.bIndex + 1));
					final Complex zd = new Complex(it.aDouble, data[it.aIndex + 1]).pow(zv);
					data[it.aIndex]     = (float) zd.getReal(); // ADD_CAST
					data[it.aIndex + 1] = (float) zd.getImaginary(); // ADD_CAST
				}
			} else {
				while (it.hasNext()) {
					final Complex zd = new Complex(it.aDouble, data[it.aIndex + 1]).pow(it.bDouble);
					data[it.aIndex]     = (float) zd.getReal(); // ADD_CAST
					data[it.aIndex + 1] = (float) zd.getImaginary(); // ADD_CAST
				}
			}
		}
		return this;
	}

	@Override
	public double residual(final Object b, Dataset w, boolean ignoreNaNs) {
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		final BroadcastIterator it = BroadcastIterator.createIterator(this, bds);
		it.setOutputDouble(true);
		double sum = 0;
		double comp = 0;
		final int bis = bds.getElementsPerItem();

		if (bis == 1) {
			if (w == null) {
				while (it.hasNext()) {
					double diffr = it.aDouble - it.bDouble;
					double diffi = data[it.aIndex + 1];
					if (ignoreNaNs && (Double.isNaN(diffr) || Double.isNaN(diffi))) {
						continue;
					}
					double err = diffr * diffr - comp;
					double temp = sum + err;
					comp = (temp - sum) - err;
					sum = temp;

					err = diffi * diffi - comp;
					temp = sum + err;
					comp = (temp - sum) - err;
					sum = temp;
				}
			} else {
				IndexIterator itw = w.getIterator();
				while (it.hasNext() && itw.hasNext()) {
					final double dw = w.getElementDoubleAbs(itw.index);
					double diffr = it.aDouble - it.bDouble;
					double diffi = data[it.aIndex + 1];
					if (ignoreNaNs && (Double.isNaN(diffr) || Double.isNaN(diffi))) {
						continue;
					}
					double err = diffr * diffr * dw - comp;
					double temp = sum + err;
					comp = (temp - sum) - err;
					sum = temp;

					err = diffi * diffi * dw - comp;
					temp = sum + err;
					comp = (temp - sum) - err;
					sum = temp;
				}
			}
		} else {
			if (w == null) {
				while (it.hasNext()) {
					double diffr = it.aDouble - it.bDouble;
					double diffi = data[it.aIndex] - bds.getElementDoubleAbs(it.bIndex + 1);
					if (ignoreNaNs && (Double.isNaN(diffr) || Double.isNaN(diffi))) {
						continue;
					}
					double err = diffr * diffr - comp;
					double temp = sum + err;
					comp = (temp - sum) - err;
					sum = temp;

					err = diffi * diffi - comp;
					temp = sum + err;
					comp = (temp - sum) - err;
					sum = temp;
				}
			} else {
				IndexIterator itw = w.getIterator();
				while (it.hasNext() && itw.hasNext()) {
					final double dw = w.getElementDoubleAbs(itw.index);
					double diffr = it.aDouble - it.bDouble;
					double diffi = data[it.aIndex] - bds.getElementDoubleAbs(it.bIndex + 1);
					if (ignoreNaNs && (Double.isNaN(diffr) || Double.isNaN(diffi))) {
						continue;
					}
					double err = diffr * diffr * dw - comp;
					double temp = sum + err;
					comp = (temp - sum) - err;
					sum = temp;

					err = diffi * diffi * dw - comp;
					temp = sum + err;
					comp = (temp - sum) - err;
					sum = temp;
				}
			}
		}
		return sum;
	}
}
