/*-
 * Copyright (c) 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.dataset.impl;

import java.lang.reflect.Array;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.complex.Complex;
import org.eclipse.dawnsci.analysis.api.dataset.IDataset;
import org.eclipse.dawnsci.analysis.api.dataset.ILazyDataset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DTypeUtils {
	protected static final Logger logger = LoggerFactory.getLogger(DTypeUtils.class);

	private static final Map<Class<? extends Dataset>, Integer> interface2DTypes = createInterfaceMap(); // map interface to dataset type

	private static Map<Class<? extends Dataset>, Integer> createInterfaceMap() {
		Map<Class<? extends Dataset>, Integer> map = new HashMap<Class<? extends Dataset>, Integer>();
		map.put(BooleanDataset.class, Dataset.BOOL);
		map.put(ByteDataset.class, Dataset.INT8);
		map.put(ShortDataset.class, Dataset.INT16);
		map.put(IntegerDataset.class, Dataset.INT32);
		map.put(LongDataset.class, Dataset.INT64);
		map.put(FloatDataset.class, Dataset.FLOAT32);
		map.put(DoubleDataset.class, Dataset.FLOAT64);
		map.put(CompoundByteDataset.class, Dataset.ARRAYINT8);
		map.put(CompoundShortDataset.class, Dataset.ARRAYINT16);
		map.put(CompoundIntegerDataset.class, Dataset.ARRAYINT32);
		map.put(CompoundLongDataset.class, Dataset.ARRAYINT64);
		map.put(CompoundFloatDataset.class, Dataset.ARRAYFLOAT32);
		map.put(CompoundDoubleDataset.class, Dataset.ARRAYFLOAT64);
		map.put(ComplexFloatDataset.class, Dataset.COMPLEX64);
		map.put(ComplexDoubleDataset.class, Dataset.COMPLEX128);
		map.put(ObjectDataset.class, Dataset.OBJECT);
		map.put(StringDataset.class, Dataset.STRING);
		map.put(DateDataset.class, Dataset.DATE);
		map.put(RGBDataset.class, Dataset.RGB);
		map.put(ObjectDataset.class, Dataset.OBJECT);
		return map;
	}

	transient private static final Map<Class<?>, Integer> class2DType = createElementClassMap();

	private static Map<Class<?>, Integer> createElementClassMap() {
		Map<Class<?>, Integer> result = new HashMap<Class<?>, Integer>();
		result.put(Boolean.class, Dataset.BOOL);
		result.put(Byte.class, Dataset.INT8);
		result.put(Short.class, Dataset.INT16);
		result.put(Integer.class, Dataset.INT32);
		result.put(Long.class, Dataset.INT64);
		result.put(Float.class, Dataset.FLOAT32);
		result.put(Double.class, Dataset.FLOAT64);
		result.put(boolean.class, Dataset.BOOL);
		result.put(byte.class, Dataset.INT8);
		result.put(short.class, Dataset.INT16);
		result.put(int.class, Dataset.INT32);
		result.put(long.class, Dataset.INT64);
		result.put(float.class, Dataset.FLOAT32);
		result.put(double.class, Dataset.FLOAT64);
		result.put(Complex.class, Dataset.COMPLEX128);
		result.put(String.class, Dataset.STRING);
		result.put(Date.class, Dataset.DATE);
		result.put(Object.class, Dataset.OBJECT);
		return result;
	}

	/**
	 * @param a
	 * @return name of dataset type
	 */
	public static String getDTypeName(Dataset a) {
		return getDTypeName(a.getDType(), a.getElementsPerItem());
	}

	/**
	 * @param a
	 * @return name of dataset type
	 */
	public static String getDTypeName(ILazyDataset a) {
		return getDTypeName(getDTypeFromClass(a.getElementClass()), a.getElementsPerItem());
	}

	/**
	 * @param dtype
	 * @param itemSize
	 * @return name of dataset type
	 */
	public static String getDTypeName(int dtype, int itemSize) {
		int bytes = DTypeUtils.getItemBytes(dtype, itemSize);
		if (isDTypeComplex(dtype)) {
			return "COMPLEX" + bytes*8;
		} else if (dtype == Dataset.RGB) {
			return "RGB";
		}
	
		String prefix = itemSize > 1 ? ("ARRAY of " + itemSize + " ") : "";
		if (isDTypeFloating(dtype)) {
			return prefix + "FLOAT" + bytes*8;
		}
		switch (dtype) {
		case Dataset.BOOL:
			return prefix + "BOOLEAN";
		case Dataset.STRING:
			return prefix + "STRING";
		case Dataset.DATE:
			return prefix + "DATE";
		case Dataset.OBJECT:
			return prefix + "OBJECT";
		}
	
		return prefix + "INT" + bytes*8;
	}

	/**
	 * @param clazz
	 * @return dataset type for dataset class 
	 */
	public static int getDType(Class<? extends Dataset> clazz) {
		if (!interface2DTypes.containsKey(clazz)) {
			throw new IllegalArgumentException("Interface class not allowed or supported");
		}
		return interface2DTypes.get(clazz);
	}

	public static boolean isDTypeElemental(int dtype) {
		return dtype <= Dataset.DATE;
	}

	public static boolean isDTypeInteger(int dtype) {
		return dtype == Dataset.INT8 || dtype == Dataset.INT16 || dtype == Dataset.INT32 || dtype == Dataset.INT64 ||
				dtype == Dataset.ARRAYINT8 || dtype == Dataset.ARRAYINT16 || dtype == Dataset.ARRAYINT32 || dtype == Dataset.ARRAYINT64 || dtype == Dataset.RGB;
	}

	public static boolean isDTypeFloating(int dtype) {
		return dtype == Dataset.FLOAT32 || dtype == Dataset.FLOAT64 || dtype == Dataset.COMPLEX64 || dtype == Dataset.COMPLEX128 ||
				dtype == Dataset.ARRAYFLOAT32 || dtype == Dataset.ARRAYFLOAT64;
	}

	public static boolean isDTypeComplex(int dtype) {
		return dtype == Dataset.COMPLEX64 || dtype == Dataset.COMPLEX128;
	}

	/**
	 * @param dtype
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
		int besttype;
	
		int a = atype >= Dataset.ARRAYINT8 ? atype / Dataset.ARRAYMUL : atype;
		int b = btype >= Dataset.ARRAYINT8 ? btype / Dataset.ARRAYMUL : btype;
	
		if (isDTypeFloating(a)) {
			if (!isDTypeFloating(b)) {
				b = getBestFloatDType(b);
				if (isDTypeComplex(a)) {
					b += Dataset.COMPLEX64 - Dataset.FLOAT32;
				}
			}
		} else if (isDTypeFloating(b)) {
			a = getBestFloatDType(a);
			if (isDTypeComplex(b)) {
				a += Dataset.COMPLEX64 - Dataset.FLOAT32;
			}
		}
		besttype = a > b ? a : b;
	
		if (atype >= Dataset.ARRAYINT8 || btype >= Dataset.ARRAYINT8) {
			if (besttype >= Dataset.COMPLEX64) {
				throw new IllegalArgumentException("Complex type cannot be promoted to compound type");
			}
			besttype *= Dataset.ARRAYMUL;
		}
	
		return besttype;
	}

	/**
	 * Find floating point dataset type that best fits given types. The best type takes into account complex and array
	 * datasets
	 * 
	 * @param otype
	 *            old dataset type
	 * @return best dataset type
	 */
	public static int getBestFloatDType(final int otype) {
		int btype;
		switch (otype) {
		case Dataset.BOOL:
		case Dataset.INT8:
		case Dataset.INT16:
		case Dataset.ARRAYINT8:
		case Dataset.ARRAYINT16:
		case Dataset.FLOAT32:
		case Dataset.ARRAYFLOAT32:
		case Dataset.COMPLEX64:
		case Dataset.RGB:
			btype = Dataset.FLOAT32; // demote, if necessary
			break;
		case Dataset.INT32:
		case Dataset.INT64:
		case Dataset.ARRAYINT32:
		case Dataset.ARRAYINT64:
		case Dataset.FLOAT64:
		case Dataset.ARRAYFLOAT64:
		case Dataset.COMPLEX128:
			btype = Dataset.FLOAT64; // promote, if necessary
			break;
		default:
			btype = otype; // for non-numeric datasets, preserve type
			break;
		}
	
		return btype;
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
	 * Get dataset type from a class
	 * 
	 * @param cls
	 * @return dataset type
	 */
	public static int getDTypeFromClass(Class<? extends Object> cls) {
		return getDTypeFromClass(cls, 1);
	}

	/**
	 * Get dataset type from a class
	 * 
	 * @param cls
	 * @return dataset type
	 */
	public static int getDTypeFromClass(Class<? extends Object> cls, int isize) {
		Integer dtype = class2DType.get(cls);
		if (dtype == null) {
			throw new IllegalArgumentException("Class of object not supported");
		}
		if (isize != 1) {
			if (dtype < Dataset.FLOAT64)
				dtype *= Dataset.ARRAYMUL;
		}
		return dtype;
	}

	/**
	 * Get dataset type from an object. The following are supported: Java Number objects, Apache common math Complex
	 * objects, Java arrays and lists
	 * 
	 * @param obj
	 * @return dataset type
	 */
	public static int getDTypeFromObject(Object obj) {
		int dtype = -1;
	
		if (obj == null) {
			return dtype;
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
			if (DTypeUtils.isClassSupportedAsElement(ca)) {
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
			return ((Dataset) obj).getDType();
		} else if (obj instanceof ILazyDataset) {
			dtype = getDTypeFromClass(((ILazyDataset) obj).getElementClass(), ((ILazyDataset) obj).getElementsPerItem());
		} else {
			dtype = getDTypeFromClass(obj.getClass());
		}
		return dtype;
	}

	/**
	 * Get dataset type from given dataset
	 * @param d
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
	 * @param otype
	 * @return largest dataset type available for given dataset type
	 */
	public static int getLargestDType(final int otype) {
		switch (otype) {
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
		case Dataset.RGB:
		case Dataset.OBJECT:
			return otype;
		}
		throw new IllegalArgumentException("Unsupported dataset type");
	}

	/**
	 * @param otype
	 * @return elemental dataset type available for given dataset type
	 */
	public static int getElementalDType(final int otype) {
		switch (otype) {
		case Dataset.COMPLEX64:
			return Dataset.FLOAT32;
		case Dataset.COMPLEX128:
			return Dataset.FLOAT64;
		case Dataset.ARRAYINT8:
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
			return otype;
		}
	}
	/**
	 * @param comp
	 * @return true if supported
	 */
	public static boolean isClassSupportedAsElement(Class<? extends Object> comp) {
		return comp.isPrimitive() || Number.class.isAssignableFrom(comp) || comp.equals(Boolean.class)
				|| comp.equals(Complex.class) || comp.equals(String.class) || comp.equals(Date.class);
	}

	/**
	 * @param dtype
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
		case Dataset.RGB:
			return 3;
		}
		return 1;
	}

	/**
	 * @param dtype
	 * @return length of single item in bytes
	 */
	public static int getItemBytes(final int dtype) {
		return getItemBytes(dtype, getElementsPerItem(dtype));
	}

	/**
	 * @param dtype
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
			return toBoolean(db.getObjectAbs(0));
		} else if (b instanceof IDataset) {
			IDataset db = (IDataset) b;
			if (db.getSize() != 1) {
				logger.error("Given dataset must have only one item");
				throw new IllegalArgumentException("Given dataset must have only one item");
			}
			return toBoolean(db.getObject(new int[db.getRank()]));
		} else {
			logger.error("Argument is of unsupported class");
			throw new IllegalArgumentException("Argument is of unsupported class");
		}
	}

	public static long toLong(final Object b) {
		if (b instanceof Number) {
			return ((Number) b).longValue();
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
			return toLong(db.getObjectAbs(0));
		} else if (b instanceof IDataset) {
			IDataset db = (IDataset) b;
			if (db.getSize() != 1) {
				logger.error("Given dataset must have only one item");
				throw new IllegalArgumentException("Given dataset must have only one item");
			}
			return toLong(db.getObject(new int[db.getRank()]));
		} else {
			logger.error("Argument is of unsupported class");
			throw new IllegalArgumentException("Argument is of unsupported class");
		}
	}

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
			return toReal(db.getObjectAbs(0));
		} else if (b instanceof IDataset) {
			IDataset db = (Dataset) b;
			if (db.getSize() != 1) {
				logger.error("Given dataset must have only one item");
				throw new IllegalArgumentException("Given dataset must have only one item");
			}
			return toReal(db.getObject(new int[db.getRank()]));
		} else {
			logger.error("Argument is of unsupported class");
			throw new IllegalArgumentException("Argument is of unsupported class");
		}
	}

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
			return toImag(db.getObjectAbs(0));
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

	public static double[] toDoubleArray(final Object b, final int itemSize) {
		double[] result = null;
	
		// ensure array is of given length
		if (b instanceof Number) {
			result = new double[itemSize];
			double val = ((Number) b).doubleValue();
			for (int i = 0; i < itemSize; i++)
				result[i] = val;
		} else if (b instanceof double[]) {
			result = (double[]) b;
			if (result.length < itemSize) {
				result = new double[itemSize];
				int ilen = result.length;
				for (int i = 0; i < ilen; i++)
					result[i] = ((double[]) b)[i];
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
			for (int i = 0; i < ilen; i++)
				result[i] = ((Number) Array.get(b, i)).doubleValue();
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
			return toDoubleArray(db.getObjectAbs(0), itemSize);
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

	public static float[] toFloatArray(final Object b, final int itemSize) {
		float[] result = null;
	
		if (b instanceof Number) {
			result = new float[itemSize];
			float val = ((Number) b).floatValue();
			for (int i = 0; i < itemSize; i++)
				result[i] = val;
		} else if (b instanceof float[]) {
			result = (float[]) b;
			if (result.length < itemSize) {
				result = new float[itemSize];
				int ilen = result.length;
				for (int i = 0; i < ilen; i++)
					result[i] = ((float[]) b)[i];
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
			for (int i = 0; i < ilen; i++)
				result[i] = ((Number) Array.get(b, i)).floatValue();
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
			return toFloatArray(db.getObjectAbs(0), itemSize);
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

	public static long[] toLongArray(final Object b, final int itemSize) {
		long[] result = null;
	
		if (b instanceof Number) {
			result = new long[itemSize];
			long val = ((Number) b).longValue();
			for (int i = 0; i < itemSize; i++)
				result[i] = val;
		} else if (b instanceof long[]) {
			result = (long[]) b;
			if (result.length < itemSize) {
				result = new long[itemSize];
				int ilen = result.length;
				for (int i = 0; i < ilen; i++)
					result[i] = ((long[]) b)[i];
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
			for (int i = 0; i < ilen; i++)
				result[i] = ((Number) Array.get(b, i)).longValue();
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
			return toLongArray(db.getObjectAbs(0), itemSize);
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

	public static int[] toIntegerArray(final Object b, final int itemSize) {
		int[] result = null;
	
		if (b instanceof Number) {
			result = new int[itemSize];
			int val = ((Number) b).intValue();
			for (int i = 0; i < itemSize; i++)
				result[i] = val;
		} else if (b instanceof int[]) {
			result = (int[]) b;
			if (result.length < itemSize) {
				result = new int[itemSize];
				int ilen = result.length;
				for (int i = 0; i < ilen; i++)
					result[i] = ((int[]) b)[i];
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
			for (int i = 0; i < ilen; i++)
				result[i] = (int) ((Number) Array.get(b, i)).longValue();
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
			return toIntegerArray(db.getObjectAbs(0), itemSize);
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

	public static short[] toShortArray(final Object b, final int itemSize) {
		short[] result = null;
	
		if (b instanceof Number) {
			result = new short[itemSize];
			short val = ((Number) b).shortValue();
			for (int i = 0; i < itemSize; i++)
				result[i] = val;
		} else if (b instanceof short[]) {
			result = (short[]) b;
			if (result.length < itemSize) {
				result = new short[itemSize];
				int ilen = result.length;
				for (int i = 0; i < ilen; i++)
					result[i] = ((short[]) b)[i];
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
			for (int i = 0; i < ilen; i++)
				result[i] = (short) ((Number) Array.get(b, i)).longValue();
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
			return toShortArray(db.getObjectAbs(0), itemSize);
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

	public static byte[] toByteArray(final Object b, final int itemSize) {
		byte[] result = null;
	
		if (b instanceof Number) {
			result = new byte[itemSize];
			final byte val = ((Number) b).byteValue();
			for (int i = 0; i < itemSize; i++) {
				result[i] = val;
			}
		} else if (b instanceof byte[]) {
			result = (byte[]) b;
			if (result.length < itemSize) {
				result = new byte[itemSize];
				int ilen = result.length;
				for (int i = 0; i < ilen; i++) {
					result[i] = ((byte[]) b)[i];
				}
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
				result[i] = (byte) ((Number) Array.get(b, i)).longValue();
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
			return toByteArray(db.getObjectAbs(0), itemSize);
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
	 * @param x
	 * @param dtype
	 * @return biggest native primitive if integer (should test for 64bit?)
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
	 * @param b
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
	 * @param dtype
	 * @return (boxed) class of constituent element
	 */
	public static Class<?> getElementClass(final int dtype) {
		switch (dtype) {
		case Dataset.BOOL:
			return Boolean.class;
		case Dataset.INT8:
		case Dataset.ARRAYINT8:
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

}
