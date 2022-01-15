/*-
 * Copyright (c) 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import java.lang.reflect.Array;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.math3.complex.Complex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DTypeUtils {
	private static final Logger logger = LoggerFactory.getLogger(DTypeUtils.class);

	private static Map<Class<? extends Dataset>, Integer> createInterfaceMap() {
		Map<Class<? extends Dataset>, Integer> map = new LinkedHashMap<>();
		map.put(BooleanDatasetBase.class, Dataset.BOOL);
		map.put(BooleanDataset.class, Dataset.BOOL);
		map.put(ByteDataset.class, Dataset.INT8);
		map.put(ShortDataset.class, Dataset.INT16);
		map.put(IntegerDataset.class, Dataset.INT32);
		map.put(LongDataset.class, Dataset.INT64);
		map.put(FloatDataset.class, Dataset.FLOAT32);
		map.put(DoubleDataset.class, Dataset.FLOAT64);
		map.put(ComplexFloatDataset.class, Dataset.COMPLEX64);
		map.put(ComplexDoubleDataset.class, Dataset.COMPLEX128);
		map.put(CompoundByteDataset.class, Dataset.ARRAYINT8);
		map.put(CompoundShortDataset.class, Dataset.ARRAYINT16);
		map.put(CompoundIntegerDataset.class, Dataset.ARRAYINT32);
		map.put(CompoundLongDataset.class, Dataset.ARRAYINT64);
		map.put(CompoundFloatDataset.class, Dataset.ARRAYFLOAT32);
		map.put(CompoundDoubleDataset.class, Dataset.ARRAYFLOAT64);
		map.put(StringDatasetBase.class, Dataset.STRING);
		map.put(StringDataset.class, Dataset.STRING);
		map.put(ObjectDatasetBase.class, Dataset.OBJECT);
		map.put(ObjectDataset.class, Dataset.OBJECT);
		map.put(DateDatasetImpl.class, Dataset.DATE);
		map.put(DateDataset.class, Dataset.DATE);
		map.put(RGBByteDataset.class, Dataset.RGB8);
		map.put(RGBDataset.class, Dataset.RGB);
		return map;
	}

	static final Map<Class<? extends Dataset>, Integer> interface2DTypes; // map interface to dataset type
	private static final Map<Integer, Class<? extends Dataset>> dtype2Interface; // map dataset type to interface
	static {
		interface2DTypes = createInterfaceMap();
		dtype2Interface = new HashMap<>();
		for (Entry<Class<? extends Dataset>, Integer> e : interface2DTypes.entrySet()) {
			dtype2Interface.put(e.getValue(), e.getKey());
		}
	}

	/**
	 * @param a input
	 * @return name of dataset type
	 */
	public static String getDTypeName(Dataset a) {
		return getDatasetName(a);
	}

	/**
	 * @param a input
	 * @return name of dataset type
	 */
	public static String getDTypeName(ILazyDataset a) {
		return getDatasetName(a);
	}

	/**
	 * @param dtype dataset type
	 * @param itemSize item size
	 * @return name of dataset type
	 */
	public static String getDTypeName(int dtype, int itemSize) {
		return getDatasetName(dtype2Interface.get(dtype), itemSize);
	}

	/**
	 * @param clazz dataset class
	 * @return dataset type for dataset class
	 */
	public static int getDType(Class<? extends Dataset> clazz) {
		Class<? extends Dataset> c = findInterface(clazz);
		if (c == null) {
			throw new IllegalArgumentException("Interface class not allowed or supported");
		}
		return interface2DTypes.get(c);
	}

	private static Class<? extends Dataset> findInterface(Class<? extends Dataset> clazz) {
		if (interface2DTypes.containsKey(clazz)) {
			return clazz;
		}

		Class<? extends Dataset> c = InterfaceUtils.findSubInterface(clazz);
		if (c != null) {
			return findInterface(c);
		}

		return null;
	}

	/**
	 * @param dtype dataset type
	 * @return true if each dataset item has single element
	 */
	public static boolean isDTypeElemental(int dtype) {
		return dtype <= Dataset.DATE;
	}

	/**
	 * @param dtype dataset type
	 * @return true if dataset elements are integers
	 */
	public static boolean isDTypeInteger(int dtype) {
		return dtype == Dataset.INT8 || dtype == Dataset.INT16 || dtype == Dataset.INT32 || dtype == Dataset.INT64 ||
				dtype == Dataset.ARRAYINT8 || dtype == Dataset.ARRAYINT16 || dtype == Dataset.ARRAYINT32 || dtype == Dataset.ARRAYINT64 || dtype == Dataset.RGB8 || dtype == Dataset.RGB;
	}

	/**
	 * @param dtype dataset type
	 * @return true if dataset elements are floats
	 */
	public static boolean isDTypeFloating(int dtype) {
		return dtype == Dataset.FLOAT32 || dtype == Dataset.FLOAT64 || dtype == Dataset.COMPLEX64 || dtype == Dataset.COMPLEX128 ||
				dtype == Dataset.ARRAYFLOAT32 || dtype == Dataset.ARRAYFLOAT64;
	}

	/**
	 * @param dtype dataset type
	 * @return true if each dataset itema are complex
	 */
	public static boolean isDTypeComplex(int dtype) {
		return dtype == Dataset.COMPLEX64 || dtype == Dataset.COMPLEX128;
	}

	/**
	 * @param dtype dataset type
	 * @return true if dataset type is numerical, i.e. a dataset contains numbers
	 */
	public static boolean isDTypeNumerical(int dtype) {
		return isDTypeInteger(dtype) || isDTypeFloating(dtype) || dtype == Dataset.BOOL;
	}

	/**
	 * Find dataset type that best fits given types The best type takes into account complex and array datasets
	 *
	 * @param atype
	 *            first dataset type
	 * @param btype
	 *            second dataset type
	 * @return best dataset type
	 */
	public static int getBestDType(final int atype, final int btype) {
		return interface2DTypes.get(InterfaceUtils.getBestInterface(getInterface(atype), getInterface(btype)));
	}

	/**
	 * Find floating point dataset type that best fits given types. The best type takes into account complex and array
	 * datasets
	 *
	 * @param dtype
	 *            dataset type
	 * @return best dataset type
	 */
	public static int getBestFloatDType(final int dtype) {
		return getDType(InterfaceUtils.getBestFloatInterface(getInterface(dtype)));
	}

	/**
	 * Find floating point dataset type that best fits given class The best type takes into account complex and array
	 * datasets
	 *
	 * @param cls
	 *            of an item or element
	 * @return best dataset type
	 */
	public static int getBestFloatDType(Class<? extends Object> cls) {
		return getBestFloatDType(getDTypeFromClass(cls));
	}

	/**
	 * Get dataset type from an element class
	 *
	 * @param cls element class
	 * @return dataset type
	 */
	public static int getDTypeFromClass(Class<? extends Object> cls) {
		return getDTypeFromClass(cls, 1);
	}

	/**
	 * Get dataset type from an element class
	 *
	 * @param cls element class
	 * @param itemSize item size
	 * @return dataset type
	 */
	public static int getDTypeFromClass(Class<? extends Object> cls, int itemSize) {
		return getDType(InterfaceUtils.getInterfaceFromClass(itemSize, cls));
	}

	/**
	 * Get dataset type from an object. The following are supported: Java Number objects, Apache common math Complex
	 * objects, Java arrays and lists
	 *
	 * @param obj input
	 * @return dataset type
	 */
	public static int getDTypeFromObject(Object obj) {
		int dtype = -1;

		if (obj == null) {
			return Dataset.OBJECT;
		}

		if (obj instanceof List<?>) {
			List<?> jl = (List<?>) obj;
			int l = jl.size();
			for (int i = 0; i < l; i++) {
				int ldtype = getDTypeFromObject(jl.get(i));
				if (ldtype > dtype) {
					dtype = ldtype;
				}
			}
		} else if (obj.getClass().isArray()) {
			Class<?> ca = obj.getClass().getComponentType();
			if (InterfaceUtils.isElementSupported(ca)) {
				return getDTypeFromClass(ca);
			}
			int l = Array.getLength(obj);
			for (int i = 0; i < l; i++) {
				Object lo = Array.get(obj, i);
				int ldtype = getDTypeFromObject(lo);
				if (ldtype > dtype) {
					dtype = ldtype;
				}
			}
		} else if (obj instanceof Dataset) {
			return interface2DTypes.get(obj.getClass());
		} else if (obj instanceof ILazyDataset) {
			dtype = getDTypeFromClass(((ILazyDataset) obj).getElementClass(), ((ILazyDataset) obj).getElementsPerItem());
		} else {
			dtype = getDTypeFromClass(obj.getClass());
		}
		return dtype;
	}

	/**
	 * Get dataset type from given dataset
	 * @param d dataset
	 * @return dataset type
	 */
	public static int getDType(ILazyDataset d) {
		if (d instanceof LazyDatasetBase)
			return ((LazyDatasetBase) d).getDType();
		return getDTypeFromClass(d.getElementClass(), d.getElementsPerItem());
	}

	/**
	 * The largest dataset type suitable for a summation of around a few thousand items without changing from the "kind"
	 * of dataset
	 *
	 * @param dtype dataset type
	 * @return largest dataset type available for given dataset type
	 */
	public static int getLargestDType(final int dtype) {
		switch (dtype) {
		case Dataset.BOOL:
		case Dataset.INT8:
		case Dataset.INT16:
			return Dataset.INT32;
		case Dataset.INT32:
		case Dataset.INT64:
			return Dataset.INT64;
		case Dataset.FLOAT32:
		case Dataset.FLOAT64:
			return Dataset.FLOAT64;
		case Dataset.COMPLEX64:
		case Dataset.COMPLEX128:
			return Dataset.COMPLEX128;
		case Dataset.ARRAYINT8:
		case Dataset.ARRAYINT16:
			return Dataset.ARRAYINT32;
		case Dataset.ARRAYINT32:
		case Dataset.ARRAYINT64:
			return Dataset.ARRAYINT64;
		case Dataset.ARRAYFLOAT32:
		case Dataset.ARRAYFLOAT64:
			return Dataset.ARRAYFLOAT64;
		case Dataset.DATE:
		case Dataset.STRING:
		case Dataset.RGB8:
		case Dataset.RGB:
		case Dataset.OBJECT:
			return dtype;
		}
		throw new IllegalArgumentException("Unsupported dataset type");
	}

	/**
	 * The largest dataset class suitable for a summation of around a few thousand items without changing from the "kind"
	 * of dataset
	 *
	 * @param clazz dataset sub-interface
	 * @return largest dataset class available for given dataset class
	 * @since 2.3
	 */
	public static Class<? extends Dataset> getLargestDataset(final Class<? extends Dataset> clazz) {
		if (BooleanDataset.class.isAssignableFrom(clazz) || ByteDataset.class.isAssignableFrom(clazz) || ShortDataset.class.isAssignableFrom(clazz)) {
			return IntegerDataset.class;
		} else if (IntegerDataset.class.isAssignableFrom(clazz) || LongDataset.class.isAssignableFrom(clazz)) {
			return LongDataset.class;
		} else if (FloatDataset.class.isAssignableFrom(clazz) || DoubleDataset.class.isAssignableFrom(clazz)) {
			return DoubleDataset.class;
		} else if (ComplexFloatDataset.class.isAssignableFrom(clazz) || ComplexDoubleDataset.class.isAssignableFrom(clazz)) {
			return ComplexDoubleDataset.class;
		} else if (CompoundByteDataset.class.isAssignableFrom(clazz) || CompoundShortDataset.class.isAssignableFrom(clazz)) {
			return CompoundIntegerDataset.class;
		} else if (CompoundIntegerDataset.class.isAssignableFrom(clazz) || CompoundLongDataset.class.isAssignableFrom(clazz)) {
			return CompoundLongDataset.class;
		} else if (CompoundFloatDataset.class.isAssignableFrom(clazz) || CompoundDoubleDataset.class.isAssignableFrom(clazz)) {
			return CompoundDoubleDataset.class;
		}

		return clazz;
	}

	/**
	 * @param dtype dataset type
	 * @return elemental dataset type available for given dataset type
	 */
	public static int getElementalDType(final int dtype) {
		switch (dtype) {
		case Dataset.COMPLEX64:
			return Dataset.FLOAT32;
		case Dataset.COMPLEX128:
			return Dataset.FLOAT64;
		case Dataset.ARRAYINT8:
		case Dataset.RGB8:
			return Dataset.INT8;
		case Dataset.ARRAYINT16:
		case Dataset.RGB:
			return Dataset.INT16;
		case Dataset.ARRAYINT32:
			return Dataset.INT32;
		case Dataset.ARRAYINT64:
			return Dataset.INT64;
		case Dataset.ARRAYFLOAT32:
			return Dataset.FLOAT32;
		case Dataset.ARRAYFLOAT64:
			return Dataset.FLOAT64;
		default:
			return dtype;
		}
	}

	/**
	 * @param dtype dataset type
	 * @return number of elements per item
	 */
	public static int getElementsPerItem(final int dtype) {
		switch (dtype) {
		case Dataset.ARRAYINT8:
		case Dataset.ARRAYINT16:
		case Dataset.ARRAYINT32:
		case Dataset.ARRAYINT64:
		case Dataset.ARRAYFLOAT32:
		case Dataset.ARRAYFLOAT64:
			throw new UnsupportedOperationException("Multi-element type unsupported");
		case Dataset.COMPLEX64:
		case Dataset.COMPLEX128:
			return 2;
		case Dataset.RGB8:
		case Dataset.RGB:
			return 3;
		}
		return 1;
	}

	/**
	 * @param dtype dataset type
	 * @return length of single item in bytes
	 */
	public static int getItemBytes(final int dtype) {
		return getItemBytes(dtype, getElementsPerItem(dtype));
	}

	/**
	 * @param dtype dataset type
	 * @param isize
	 *            number of elements in an item
	 * @return length of single item in bytes
	 */
	public static int getItemBytes(final int dtype, final int isize) {
		int size;

		switch (dtype) {
		case Dataset.BOOL:
			size = 1; // How is this defined?
			break;
		case Dataset.INT8:
		case Dataset.ARRAYINT8:
		case Dataset.RGB8:
			size = Byte.SIZE / 8;
			break;
		case Dataset.INT16:
		case Dataset.ARRAYINT16:
		case Dataset.RGB:
			size = Short.SIZE / 8;
			break;
		case Dataset.INT32:
		case Dataset.ARRAYINT32:
			size = Integer.SIZE / 8;
			break;
		case Dataset.INT64:
		case Dataset.ARRAYINT64:
			size = Long.SIZE / 8;
			break;
		case Dataset.FLOAT32:
		case Dataset.ARRAYFLOAT32:
		case Dataset.COMPLEX64:
			size = Float.SIZE / 8;
			break;
		case Dataset.FLOAT64:
		case Dataset.ARRAYFLOAT64:
		case Dataset.COMPLEX128:
			size = Double.SIZE / 8;
			break;
		default:
			size = 0;
			break;
		}

		return size * isize;
	}

	/**
	 * @param b input
	 * @return converted boolean
	 */
	public static boolean toBoolean(final Object b) {
		if (b instanceof Number) {
			return ((Number) b).longValue() != 0;
		} else if (b instanceof Boolean) {
			return ((Boolean) b).booleanValue();
		} else if (b instanceof Complex) {
			return ((Complex) b).getReal() != 0;
		} else if (b instanceof Dataset) {
			Dataset db = (Dataset) b;
			if (db.getSize() != 1) {
				logger.error("Given dataset must have only one item");
				throw new IllegalArgumentException("Given dataset must have only one item");
			}
			return db.getBoolean();
		} else if (b instanceof IDataset) {
			IDataset db = (IDataset) b;
			if (db.getSize() != 1) {
				logger.error("Given dataset must have only one item");
				throw new IllegalArgumentException("Given dataset must have only one item");
			}
			return db.getBoolean(new int[db.getRank()]);
		} else {
			logger.error("Argument is of unsupported class");
			throw new IllegalArgumentException("Argument is of unsupported class");
		}
	}

	/**
	 * @param d value
	 * @return returns a long or 0 if d is NaN or infinite
	 * @since 2.1
	 */
	public static final long toLong(double d) {
		if (Double.isInfinite(d) || Double.isNaN(d))
			return 0l;
		return (long) d;
	}

	/**
	 * @param d value
	 * @return returns a long or 0 if d is NaN or infinite
	 * @since 2.1
	 */
	public static final long toLong(float d) {
		if (Float.isInfinite(d) || Float.isNaN(d))
			return 0l;
		return (long) d;
	}

	/**
	 * @param b input
	 * @return converted long
	 */
	public static long toLong(final Object b) {
		if (b instanceof Number) {
			final Number n = (Number) b;
			return (n instanceof Double || n instanceof Float) ? toLong(n.doubleValue()) : n.longValue();
		} else if (b instanceof Boolean) {
			return ((Boolean) b).booleanValue() ? 1 : 0;
		} else if (b instanceof Complex) {
			return (long) ((Complex) b).getReal();
		} else if (b instanceof Dataset) {
			Dataset db = (Dataset) b;
			if (db.getSize() != 1) {
				logger.error("Given dataset must have only one item");
				throw new IllegalArgumentException("Given dataset must have only one item");
			}
			return db.getLong();
		} else if (b instanceof IDataset) {
			IDataset db = (IDataset) b;
			if (db.getSize() != 1) {
				logger.error("Given dataset must have only one item");
				throw new IllegalArgumentException("Given dataset must have only one item");
			}
			return db.getLong(new int[db.getRank()]);
		} else {
			logger.error("Argument is of unsupported class");
			throw new IllegalArgumentException("Argument is of unsupported class");
		}
	}

	/**
	 * @param b input
	 * @return real part of input
	 */
	public static double toReal(final Object b) {
		if (b instanceof Number) {
			return ((Number) b).doubleValue();
		} else if (b instanceof Boolean) {
			return ((Boolean) b).booleanValue() ? 1 : 0;
		} else if (b instanceof Complex) {
			return ((Complex) b).getReal();
		} else if (b.getClass().isArray()) {
			if (Array.getLength(b) == 0)
				return 0;
			return toReal(Array.get(b, 0));
		} else if (b instanceof Dataset) {
			Dataset db = (Dataset) b;
			if (db.getSize() != 1) {
				logger.error("Given dataset must have only one item");
				throw new IllegalArgumentException("Given dataset must have only one item");
			}
			return db.getDouble();
		} else if (b instanceof IDataset) {
			IDataset db = (Dataset) b;
			if (db.getSize() != 1) {
				logger.error("Given dataset must have only one item");
				throw new IllegalArgumentException("Given dataset must have only one item");
			}
			return db.getDouble(new int[db.getRank()]);
		} else {
			logger.error("Argument is of unsupported class");
			throw new IllegalArgumentException("Argument is of unsupported class");
		}
	}

	/**
	 * @param b input
	 * @return imaginary part of input
	 */
	public static double toImag(final Object b) {
		if (b instanceof Number) {
			return 0;
		} else if (b instanceof Boolean) {
			return 0;
		} else if (b instanceof Complex) {
			return ((Complex) b).getImaginary();
		} else if (b.getClass().isArray()) {
			if (Array.getLength(b) < 2)
				return 0;
			return toReal(Array.get(b, 1));
		} else if (b instanceof Dataset) {
			Dataset db = (Dataset) b;
			if (db.getSize() != 1) {
				logger.error("Given dataset must have only one item");
				throw new IllegalArgumentException("Given dataset must have only one item");
			}
			return toImag(db.getObject());
		} else if (b instanceof IDataset) {
			IDataset db = (Dataset) b;
			if (db.getSize() != 1) {
				logger.error("Given dataset must have only one item");
				throw new IllegalArgumentException("Given dataset must have only one item");
			}
			return toImag(db.getObject(new int[db.getRank()]));
		} else {
			logger.error("Argument is of unsupported class");
			throw new IllegalArgumentException("Argument is of unsupported class");
		}
	}

	/**
	 * @param b input
	 * @param itemSize item size
	 * @return converted doubles
	 */
	public static double[] toDoubleArray(final Object b, final int itemSize) {
		double[] result = null;

		// ensure array is of given length
		if (b instanceof Number) {
			result = new double[itemSize];
			final double val = ((Number) b).doubleValue();
			for (int i = 0; i < itemSize; i++) {
				result[i] = val;
			}
		} else if (b instanceof double[]) {
			final double[] old = (double[]) b;
			result = old;
			final int ilen = old.length;
			if (ilen < itemSize) {
				result = new double[itemSize];
				for (int i = 0; i < ilen; i++) {
					result[i] = old[i];
				}
			}
		} else if (b instanceof List<?>) {
			result = new double[itemSize];
			List<?> jl = (List<?>) b;
			int ilen = jl.size();
			if (ilen > 0 && !(jl.get(0) instanceof Number)) {
				logger.error("Given array was not of a numerical primitive type");
				throw new IllegalArgumentException("Given array was not of a numerical primitive type");
			}
			ilen = Math.min(itemSize, ilen);
			for (int i = 0; i < ilen; i++) {
				result[i] = toReal(jl.get(i));
			}
		} else if (b.getClass().isArray()) {
			result = new double[itemSize];
			int ilen = Array.getLength(b);
			if (ilen > 0 && !(Array.get(b, 0) instanceof Number)) {
				logger.error("Given array was not of a numerical primitive type");
				throw new IllegalArgumentException("Given array was not of a numerical primitive type");
			}
			ilen = Math.min(itemSize, ilen);
			for (int i = 0; i < ilen; i++) {
				result[i] = ((Number) Array.get(b, i)).doubleValue();
			}
		} else if (b instanceof Complex) {
			if (itemSize > 2) {
				logger.error("Complex number will not fit in compound dataset");
				throw new IllegalArgumentException("Complex number will not fit in compound dataset");
			}
			Complex cb = (Complex) b;
			switch (itemSize) {
			default:
			case 0:
				break;
			case 1:
				result = new double[] {cb.getReal()};
				break;
			case 2:
				result = new double[] {cb.getReal(), cb.getImaginary()};
				break;
			}
		} else if (b instanceof Dataset) {
			Dataset db = (Dataset) b;
			if (db.getSize() != 1) {
				logger.error("Given dataset must have only one item");
				throw new IllegalArgumentException("Given dataset must have only one item");
			}
			return toDoubleArray(db.getObject(), itemSize);
		} else if (b instanceof IDataset) {
			IDataset db = (Dataset) b;
			if (db.getSize() != 1) {
				logger.error("Given dataset must have only one item");
				throw new IllegalArgumentException("Given dataset must have only one item");
			}
			return toDoubleArray(db.getObject(new int[db.getRank()]), itemSize);
		}

		return result;
	}

	/**
	 * @param b input
	 * @param itemSize item size
	 * @return converted floats
	 */
	public static float[] toFloatArray(final Object b, final int itemSize) {
		float[] result = null;

		if (b instanceof Number) {
			result = new float[itemSize];
			final float val = ((Number) b).floatValue();
			for (int i = 0; i < itemSize; i++)
				result[i] = val;
		} else if (b instanceof float[]) {
			final float[] old = (float[]) b;
			result = old;
			final int ilen = old.length;
			if (ilen < itemSize) {
				result = new float[itemSize];
				for (int i = 0; i < ilen; i++) {
					result[i] = old[i];
				}
			}
		} else if (b instanceof double[]) {
			final double[] old = (double[]) b;
			final int ilen = Math.min(itemSize, old.length);
			result = new float[itemSize];
			for (int i = 0; i < ilen; i++) {
				result[i] = (float) old[i];
			}
		} else if (b instanceof List<?>) {
			result = new float[itemSize];
			List<?> jl = (List<?>) b;
			int ilen = jl.size();
			if (ilen > 0 && !(jl.get(0) instanceof Number)) {
				logger.error("Given array was not of a numerical primitive type");
				throw new IllegalArgumentException("Given array was not of a numerical primitive type");
			}
			ilen = Math.min(itemSize, ilen);
			for (int i = 0; i < ilen; i++) {
				result[i] = (float) toReal(jl.get(i));
			}
		} else if (b.getClass().isArray()) {
			result = new float[itemSize];
			int ilen = Array.getLength(b);
			if (ilen > 0 && !(Array.get(b, 0) instanceof Number)) {
				logger.error("Given array was not of a numerical primitive type");
				throw new IllegalArgumentException("Given array was not of a numerical primitive type");
			}
			ilen = Math.min(itemSize, ilen);
			for (int i = 0; i < ilen; i++) {
				result[i] = ((Number) Array.get(b, i)).floatValue();
			}
		} else if (b instanceof Complex) {
			if (itemSize > 2) {
				logger.error("Complex number will not fit in compound dataset");
				throw new IllegalArgumentException("Complex number will not fit in compound dataset");
			}
			Complex cb = (Complex) b;
			switch (itemSize) {
			default:
			case 0:
				break;
			case 1:
				result = new float[] {(float) cb.getReal()};
				break;
			case 2:
				result = new float[] {(float) cb.getReal(), (float) cb.getImaginary()};
				break;
			}
		} else if (b instanceof Dataset) {
			Dataset db = (Dataset) b;
			if (db.getSize() != 1) {
				logger.error("Given dataset must have only one item");
				throw new IllegalArgumentException("Given dataset must have only one item");
			}
			return toFloatArray(db.getObject(), itemSize);
		} else if (b instanceof IDataset) {
			IDataset db = (Dataset) b;
			if (db.getSize() != 1) {
				logger.error("Given dataset must have only one item");
				throw new IllegalArgumentException("Given dataset must have only one item");
			}
			return toFloatArray(db.getObject(new int[db.getRank()]), itemSize);
		}

		return result;
	}

	/**
	 * @param b input
	 * @param itemSize item size
	 * @return converted longs
	 */
	public static long[] toLongArray(final Object b, final int itemSize) {
		long[] result = null;

		if (b instanceof Number) {
			result = new long[itemSize];
			final long val = toLong(b);
			for (int i = 0; i < itemSize; i++) {
				result[i] = val;
			}
		} else if (b instanceof long[]) {
			final long[] old = (long[]) b;
			result = old;
			final int ilen = result.length;
			if (ilen < itemSize) {
				result = new long[itemSize];
				for (int i = 0; i < ilen; i++) {
					result[i] = old[i];
				}
			}
		} else if (b instanceof double[]) {
			final double[] old = (double[]) b;
			final int ilen = Math.min(itemSize, old.length);
			result = new long[itemSize];
			for (int i = 0; i < ilen; i++) {
				result[i] = toLong(old[i]);
			}
		} else if (b instanceof List<?>) {
			result = new long[itemSize];
			List<?> jl = (List<?>) b;
			int ilen = jl.size();
			if (ilen > 0 && !(jl.get(0) instanceof Number)) {
				logger.error("Given array was not of a numerical primitive type");
				throw new IllegalArgumentException("Given array was not of a numerical primitive type");
			}
			ilen = Math.min(itemSize, ilen);
			for (int i = 0; i < ilen; i++) {
				result[i] = toLong(jl.get(i));
			}
		} else if (b.getClass().isArray()) {
			result = new long[itemSize];
			int ilen = Array.getLength(b);
			if (ilen > 0 && !(Array.get(b, 0) instanceof Number)) {
				logger.error("Given array was not of a numerical primitive type");
				throw new IllegalArgumentException("Given array was not of a numerical primitive type");
			}
			ilen = Math.min(itemSize, ilen);
			for (int i = 0; i < ilen; i++) {
				result[i] = toLong(Array.get(b, i));
			}
		} else if (b instanceof Complex) {
			if (itemSize > 2) {
				logger.error("Complex number will not fit in compound dataset");
				throw new IllegalArgumentException("Complex number will not fit in compound dataset");
			}
			Complex cb = (Complex) b;
			switch (itemSize) {
			default:
			case 0:
				break;
			case 1:
				result = new long[] {(long) cb.getReal()};
				break;
			case 2:
				result = new long[] {(long) cb.getReal(), (long) cb.getImaginary()};
				break;
			}
		} else if (b instanceof Dataset) {
			Dataset db = (Dataset) b;
			if (db.getSize() != 1) {
				logger.error("Given dataset must have only one item");
				throw new IllegalArgumentException("Given dataset must have only one item");
			}
			return toLongArray(db.getObject(), itemSize);
		} else if (b instanceof IDataset) {
			IDataset db = (Dataset) b;
			if (db.getSize() != 1) {
				logger.error("Given dataset must have only one item");
				throw new IllegalArgumentException("Given dataset must have only one item");
			}
			return toLongArray(db.getObject(new int[db.getRank()]), itemSize);
		}

		return result;
	}

	/**
	 * @param b input
	 * @param itemSize item size
	 * @return converted integers
	 */
	public static int[] toIntegerArray(final Object b, final int itemSize) {
		int[] result = null;

		if (b instanceof Number) {
			result = new int[itemSize];
			final int val = (int) toLong(b);
			for (int i = 0; i < itemSize; i++) {
				result[i] = val;
			}
		} else if (b instanceof int[]) {
			final int[] old = (int[]) b;
			result = old;
			final int ilen = result.length;
			if (ilen < itemSize) {
				result = new int[itemSize];
				for (int i = 0; i < ilen; i++) {
					result[i] = old[i];
				}
			}
		} else if (b instanceof double[]) {
			final double[] old = (double[]) b;
			final int ilen = Math.min(itemSize, old.length);
			result = new int[itemSize];
			for (int i = 0; i < ilen; i++) {
				result[i] = (int) toLong(old[i]);
			}
		} else if (b instanceof List<?>) {
			result = new int[itemSize];
			List<?> jl = (List<?>) b;
			int ilen = jl.size();
			if (ilen > 0 && !(jl.get(0) instanceof Number)) {
				logger.error("Given array was not of a numerical primitive type");
				throw new IllegalArgumentException("Given array was not of a numerical primitive type");
			}
			ilen = Math.min(itemSize, ilen);
			for (int i = 0; i < ilen; i++) {
				result[i] = (int) toLong(jl.get(i));
			}
		} else if (b.getClass().isArray()) {
			result = new int[itemSize];
			int ilen = Array.getLength(b);
			if (ilen > 0 && !(Array.get(b, 0) instanceof Number)) {
				logger.error("Given array was not of a numerical primitive type");
				throw new IllegalArgumentException("Given array was not of a numerical primitive type");
			}
			ilen = Math.min(itemSize, ilen);
			for (int i = 0; i < ilen; i++) {
				result[i] = (int) toLong(Array.get(b, i));
			}
		} else if (b instanceof Complex) {
			if (itemSize > 2) {
				logger.error("Complex number will not fit in compound dataset");
				throw new IllegalArgumentException("Complex number will not fit in compound dataset");
			}
			Complex cb = (Complex) b;
			switch (itemSize) {
			default:
			case 0:
				break;
			case 1:
				result = new int[] {(int) cb.getReal()};
				break;
			case 2:
				result = new int[] {(int) cb.getReal(), (int) cb.getImaginary()};
				break;
			}
		} else if (b instanceof Dataset) {
			Dataset db = (Dataset) b;
			if (db.getSize() != 1) {
				logger.error("Given dataset must have only one item");
				throw new IllegalArgumentException("Given dataset must have only one item");
			}
			return toIntegerArray(db.getObject(), itemSize);
		} else if (b instanceof IDataset) {
			IDataset db = (Dataset) b;
			if (db.getSize() != 1) {
				logger.error("Given dataset must have only one item");
				throw new IllegalArgumentException("Given dataset must have only one item");
			}
			return toIntegerArray(db.getObject(new int[db.getRank()]), itemSize);
		}

		return result;
	}

	/**
	 * @param b input
	 * @param itemSize item size
	 * @return converted shorts
	 */
	public static short[] toShortArray(final Object b, final int itemSize) {
		short[] result = null;

		if (b instanceof Number) {
			result = new short[itemSize];
			final short val = (short) toLong(b);
			for (int i = 0; i < itemSize; i++) {
				result[i] = val;
			}
		} else if (b instanceof short[]) {
			final short[] old = (short[]) b;
			result = old;
			final int ilen = result.length;
			if (ilen < itemSize) {
				result = new short[itemSize];
				for (int i = 0; i < ilen; i++) {
					result[i] = old[i];
				}
			}
		} else if (b instanceof double[]) {
			final double[] old = (double[]) b;
			final int ilen = Math.min(itemSize, old.length);
			result = new short[itemSize];
			for (int i = 0; i < ilen; i++) {
				result[i] = (short) toLong(old[i]);
			}
		} else if (b instanceof List<?>) {
			result = new short[itemSize];
			List<?> jl = (List<?>) b;
			int ilen = jl.size();
			if (ilen > 0 && !(jl.get(0) instanceof Number)) {
				logger.error("Given array was not of a numerical primitive type");
				throw new IllegalArgumentException("Given array was not of a numerical primitive type");
			}
			ilen = Math.min(itemSize, ilen);
			for (int i = 0; i < ilen; i++) {
				result[i] = (short) toLong(jl.get(i));
			}
		} else if (b.getClass().isArray()) {
			result = new short[itemSize];
			int ilen = Array.getLength(b);
			if (ilen > 0 && !(Array.get(b, 0) instanceof Number)) {
				logger.error("Given array was not of a numerical primitive type");
				throw new IllegalArgumentException("Given array was not of a numerical primitive type");
			}
			ilen = Math.min(itemSize, ilen);
			for (int i = 0; i < ilen; i++) {
				result[i] = (short) toLong(Array.get(b, i));
			}
		} else if (b instanceof Complex) {
			if (itemSize > 2) {
				logger.error("Complex number will not fit in compound dataset");
				throw new IllegalArgumentException("Complex number will not fit in compound dataset");
			}
			Complex cb = (Complex) b;
			switch (itemSize) {
			default:
			case 0:
				break;
			case 1:
				result = new short[] {(short) cb.getReal()};
				break;
			case 2:
				result = new short[] {(short) cb.getReal(), (short) cb.getImaginary()};
				break;
			}
		} else if (b instanceof Dataset) {
			Dataset db = (Dataset) b;
			if (db.getSize() != 1) {
				logger.error("Given dataset must have only one item");
				throw new IllegalArgumentException("Given dataset must have only one item");
			}
			return toShortArray(db.getObject(), itemSize);
		} else if (b instanceof IDataset) {
			IDataset db = (Dataset) b;
			if (db.getSize() != 1) {
				logger.error("Given dataset must have only one item");
				throw new IllegalArgumentException("Given dataset must have only one item");
			}
			return toShortArray(db.getObject(new int[db.getRank()]), itemSize);
		}

		return result;
	}

	/**
	 * @param b input
	 * @param itemSize item size
	 * @return converted bytes
	 */
	public static byte[] toByteArray(final Object b, final int itemSize) {
		byte[] result = null;

		if (b instanceof Number) {
			result = new byte[itemSize];
			final byte val = (byte) toLong(b);
			for (int i = 0; i < itemSize; i++) {
				result[i] = val;
			}
		} else if (b instanceof byte[]) {
			final byte[] old = (byte[]) b;
			result = old;
			final int ilen = result.length;
			if (ilen < itemSize) {
				result = new byte[itemSize];
				for (int i = 0; i < ilen; i++) {
					result[i] = old[i];
				}
			}
		} else if (b instanceof double[]) {
			final double[] old = (double[]) b;
			final int ilen = Math.min(itemSize, old.length);
			result = new byte[itemSize];
			for (int i = 0; i < ilen; i++) {
				result[i] = (byte) toLong(old[i]);
			}
		} else if (b instanceof List<?>) {
			result = new byte[itemSize];
			List<?> jl = (List<?>) b;
			int ilen = jl.size();
			if (ilen > 0 && !(jl.get(0) instanceof Number)) {
				logger.error("Given array was not of a numerical primitive type");
				throw new IllegalArgumentException("Given array was not of a numerical primitive type");
			}
			ilen = Math.min(itemSize, ilen);
			for (int i = 0; i < ilen; i++) {
				result[i] = (byte) toLong(jl.get(i));
			}
		} else if (b.getClass().isArray()) {
			result = new byte[itemSize];
			int ilen = Array.getLength(b);
			if (ilen > 0 && !(Array.get(b, 0) instanceof Number)) {
				logger.error("Given array was not of a numerical primitive type");
				throw new IllegalArgumentException("Given array was not of a numerical primitive type");
			}
			ilen = Math.min(itemSize, ilen);
			for (int i = 0; i < ilen; i++) {
				result[i] = (byte) toLong(Array.get(b, i));
			}
		} else if (b instanceof Complex) {
			if (itemSize > 2) {
				logger.error("Complex number will not fit in compound dataset");
				throw new IllegalArgumentException("Complex number will not fit in compound dataset");
			}
			Complex cb = (Complex) b;
			switch (itemSize) {
			default:
			case 0:
				break;
			case 1:
				result = new byte[] {(byte) cb.getReal()};
				break;
			case 2:
				result = new byte[] {(byte) cb.getReal(), (byte) cb.getImaginary()};
				break;
			}
		} else if (b instanceof Dataset) {
			Dataset db = (Dataset) b;
			if (db.getSize() != 1) {
				logger.error("Given dataset must have only one item");
				throw new IllegalArgumentException("Given dataset must have only one item");
			}
			return toByteArray(db.getObject(), itemSize);
		} else if (b instanceof IDataset) {
			IDataset db = (Dataset) b;
			if (db.getSize() != 1) {
				logger.error("Given dataset must have only one item");
				throw new IllegalArgumentException("Given dataset must have only one item");
			}
			return toByteArray(db.getObject(new int[db.getRank()]), itemSize);
		}

		return result;
	}

	/**
	 * @param x input
	 * @param dtype dataset type primitive array
	 * @return array of biggest primitives
	 */
	public static Object fromDoublesToBiggestPrimitives(double[] x, int dtype) {
		switch (dtype) {
		case Dataset.BOOL:
		case Dataset.INT8:
		case Dataset.INT16:
		case Dataset.INT32:
			int[] i32 = new int[x.length];
			for (int i = 0; i < x.length; i++)
				i32[i] = (int) (long) x[i];
			return i32;
		case Dataset.INT64:
			long[] i64 = new long[x.length];
			for (int i = 0; i < x.length; i++)
				i64[i] = (long) x[i];
			return i64;
		case Dataset.FLOAT32:
			float[] f32 = new float[x.length];
			for (int i = 0; i < x.length; i++)
				f32[i] = (float) x[i];
			return f32;
		case Dataset.FLOAT64:
			return x;
		}
		return null;
	}

	/**
	 * @param dtype dataset type
	 * @return (boxed) class of constituent element
	 */
	public static Class<?> getElementClass(final int dtype) {
		switch (dtype) {
		case Dataset.BOOL:
			return Boolean.class;
		case Dataset.INT8:
		case Dataset.ARRAYINT8:
		case Dataset.RGB8:
			return Byte.class;
		case Dataset.INT16:
		case Dataset.ARRAYINT16:
		case Dataset.RGB:
			return Short.class;
		case Dataset.INT32:
		case Dataset.ARRAYINT32:
			return Integer.class;
		case Dataset.INT64:
		case Dataset.ARRAYINT64:
			return Long.class;
		case Dataset.FLOAT32:
		case Dataset.ARRAYFLOAT32:
			return Float.class;
		case Dataset.FLOAT64:
		case Dataset.ARRAYFLOAT64:
			return Double.class;
		case Dataset.COMPLEX64:
			return Float.class;
		case Dataset.COMPLEX128:
			return Double.class;
		case Dataset.STRING:
			return String.class;
		case Dataset.DATE:
			return Date.class;
		}
		return Object.class;
	}

	/**
	 * @param dtype dataset type
	 * @return dataset interface can be null
	 * @since 2.3
	 */
	public static Class<? extends Dataset> getInterface(final int dtype) {
		return dtype2Interface.get(dtype);
	}

	/**
	 * @param x value
	 * @param dtype dataset type
	 * @return biggest native primitive if integer (should test for 64bit?)
	 * @since 2.2
	 */
	public static Number fromDoubleToBiggestNumber(double x, int dtype) {
		switch (dtype) {
		case Dataset.BOOL:
		case Dataset.INT8:
		case Dataset.INT16:
		case Dataset.INT32:
			return Integer.valueOf((int) (long) x);
		case Dataset.INT64:
			return Long.valueOf((long) x);
		case Dataset.FLOAT32:
			return Float.valueOf((float) x);
		case Dataset.FLOAT64:
			return Double.valueOf(x);
		}
		return null;
	}

	/**
	 * @param clazz element class
	 * @return true if supported
	 * @deprecated Use {@link InterfaceUtils#isElementSupported(Class)}
	 */
	@Deprecated
	public static boolean isClassSupportedAsElement(Class<? extends Object> clazz) {
		return InterfaceUtils.isElementSupported(clazz);
	}

	/**
	 * @param b input
	 * @return length of object
	 */
	public static final int getLength(final Object b) {
		if (b instanceof Number) {
			return 1;
		} else if (b instanceof Complex) {
			return 1;
		} else if (b instanceof List<?>) {
			List<?> jl = (List<?>) b;
			return jl.size();
		} else if (b.getClass().isArray()) {
			return Array.getLength(b);
		} else if (b instanceof IDataset) {
			IDataset db = (Dataset) b;
			return db.getSize();
		}

		throw new IllegalArgumentException("Cannot find length as object not supported");
	}

	/**
	 * @param a input
	 * @return name of dataset interface
	 * @since 2.3
	 */
	public static String getDatasetName(Dataset a) {
		return getDatasetName(a.getClass(), a.getElementsPerItem());
	}

	/**
	 * @param a input
	 * @return name of dataset interface
	 * @since 2.3
	 */
	public static String getDatasetName(ILazyDataset a) {
		if (a instanceof Dataset) {
			return getDatasetName((Dataset) a);
		}
		int isize = a.getElementsPerItem();
		return getDatasetName(InterfaceUtils.getInterfaceFromClass(isize, a.getElementClass()), isize);
	}

	/**
	 * @param clazz dataset interface
	 * @param itemSize item size
	 * @return name of dataset interface
	 * @since 2.3
	 */
	public static String getDatasetName(final Class<? extends Dataset> clazz, int itemSize) {
		int bytes = InterfaceUtils.getItemBytes(1, clazz);
		if (InterfaceUtils.isComplex(clazz)) {
			return "COMPLEX" + bytes*16;
		} else if (RGBByteDataset.class.isAssignableFrom(clazz)) {
			return "RGB8";
		} else if (RGBDataset.class.isAssignableFrom(clazz)) {
			return "RGB";
		}

		String prefix = itemSize > 1 ? ("ARRAY of " + itemSize + " ") : "";
		if (InterfaceUtils.isFloating(clazz)) {
			return prefix + "FLOAT" + bytes*8;
		}
		if (BooleanDataset.class.isAssignableFrom(clazz)) {
			return prefix + "BOOLEAN";
		}
		if (StringDataset.class.isAssignableFrom(clazz)) {
			return prefix + "STRING";
		}
		if (DateDataset.class.isAssignableFrom(clazz)) {
			return prefix + "DATE";
		}
		if (ObjectDataset.class.isAssignableFrom(clazz)) {
			return prefix + "OBJECT";
		}

		return prefix + "INT" + bytes*8;
	}
}
