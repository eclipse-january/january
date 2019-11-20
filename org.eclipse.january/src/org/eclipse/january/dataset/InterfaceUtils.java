/*-
 * Copyright (c) 2019 Diamond Light Source Ltd.
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

/**
 * @since 2.3
 */
public class InterfaceUtils {
	private static final Map<Class<?>, Class<? extends Dataset>> class2Interface;

	private static final Map<Class<? extends Dataset>, Class<?>> interface2Class;

	private static final Map<Class<?>, Integer> elementBytes;

	private static final Map<Class<?>, Class<?>> bestFloatElement;

	private static final Map<Class<? extends Dataset>, Class<? extends CompoundDataset>> interface2Compound;

	private static final Map<Class<? extends CompoundDataset>, Class<? extends Dataset>> compound2Interface;
	static {
		class2Interface = createClassInterfaceMap();

		interface2Class = createInterfaceClassMap();

		elementBytes = createElementBytesMap();

		bestFloatElement = createBestFloatElementMap();

		interface2Compound = createInterfaceCompoundMap();
		compound2Interface = new HashMap<Class<? extends CompoundDataset>, Class<? extends Dataset>>();
		for (Entry<Class<? extends Dataset>, Class<? extends CompoundDataset>> e : interface2Compound.entrySet()) {
			compound2Interface.put(e.getValue(), e.getKey());
		}
	}

	private static Map<Class<?>, Class<? extends Dataset>> createClassInterfaceMap() {
		Map<Class<?>, Class<? extends Dataset>> result = new HashMap<>();
		result.put(Boolean.class, BooleanDataset.class);
		result.put(Byte.class, ByteDataset.class);
		result.put(Short.class, ShortDataset.class);
		result.put(Integer.class, IntegerDataset.class);
		result.put(Long.class, LongDataset.class);
		result.put(Float.class, FloatDataset.class);
		result.put(Double.class, DoubleDataset.class);
		result.put(boolean.class, BooleanDataset.class);
		result.put(byte.class, ByteDataset.class);
		result.put(short.class, ShortDataset.class);
		result.put(int.class, IntegerDataset.class);
		result.put(long.class, LongDataset.class);
		result.put(float.class, FloatDataset.class);
		result.put(double.class, DoubleDataset.class);
		result.put(Complex.class, ComplexDoubleDataset.class);
		result.put(String.class, StringDataset.class);
		result.put(Date.class, DateDataset.class);
		return result;
	}

	private static Map<Class<? extends Dataset>, Class<?>> createInterfaceClassMap() {
		Map<Class<? extends Dataset>, Class<?>> result = new HashMap<>();
		result.put(BooleanDataset.class, Boolean.class);
		result.put(ByteDataset.class, Byte.class);
		result.put(ShortDataset.class, Short.class);
		result.put(IntegerDataset.class, Integer.class);
		result.put(LongDataset.class, Long.class);
		result.put(FloatDataset.class, Float.class);
		result.put(DoubleDataset.class, Double.class);
		result.put(CompoundByteDataset.class, Byte.class);
		result.put(CompoundShortDataset.class, Short.class);
		result.put(CompoundIntegerDataset.class, Integer.class);
		result.put(CompoundLongDataset.class, Long.class);
		result.put(CompoundFloatDataset.class, Float.class);
		result.put(CompoundDoubleDataset.class, Double.class);
		result.put(ComplexFloatDataset.class, Float.class);
		result.put(ComplexDoubleDataset.class, Double.class);
		result.put(RGBDataset.class, Short.class);
		result.put(StringDataset.class, String.class);
		result.put(DateDataset.class, Date.class);
		result.put(ObjectDataset.class, Object.class);
		return result;
	}

	private static Map<Class<?>, Integer> createElementBytesMap() {
		Map<Class<?>, Integer> result = new LinkedHashMap<>();
		result.put(Boolean.class, 1);
		result.put(Byte.class, Byte.SIZE / 8);
		result.put(Short.class, Short.SIZE / 8);
		result.put(Integer.class, Integer.SIZE / 8);
		result.put(Long.class, Long.SIZE / 8);
		result.put(Float.class, Float.SIZE / 8);
		result.put(Double.class, Double.SIZE / 8);
		result.put(String.class, 1);
		result.put(Object.class, 1);
		result.put(Date.class, 1);
		return result;
	}

	private static Map<Class<?>, Class<?>> createBestFloatElementMap() {
		Map<Class<?>, Class<?>> result = new HashMap<>();
		result.put(Boolean.class, Float.class);
		result.put(Byte.class, Float.class);
		result.put(Short.class, Float.class);
		result.put(Integer.class, Double.class);
		result.put(Long.class, Double.class);
		result.put(Float.class, Float.class);
		result.put(Double.class, Double.class);
		return result;
	}

	private static Map<Class<? extends Dataset>, Class<? extends CompoundDataset>> createInterfaceCompoundMap() {
		Map<Class<? extends Dataset>, Class<? extends CompoundDataset>> result = new HashMap<>();
		result.put(ByteDataset.class, CompoundByteDataset.class);
		result.put(ShortDataset.class, CompoundShortDataset.class);
		result.put(IntegerDataset.class, CompoundIntegerDataset.class);
		result.put(LongDataset.class, CompoundLongDataset.class);
		result.put(FloatDataset.class, CompoundFloatDataset.class);
		result.put(DoubleDataset.class, CompoundDoubleDataset.class);
		return result;
	}

	/**
	 * @param clazz
	 * @return true if supported as an element class (note, Object is not supported)
	 */
	public static boolean isElementSupported(Class<? extends Object> clazz) {
		return class2Interface.containsKey(clazz);
	}

	/**
	 * @param clazz dataset class
	 * @return (boxed) class of constituent element
	 */
	public static Class<?> getElementClass(final Class<? extends Dataset> clazz) {
		return interface2Class.get(clazz);
	}

	/**
	 * Get dataset interface from an object. The following are supported: Java Number objects, Apache common math Complex
	 * objects, Java arrays and lists
	 *
	 * @param obj
	 * @return dataset interface 
	 */
	public static Class <? extends Dataset> getInterface(Object obj) {
		Class<? extends Dataset> dc = null;

		if (obj == null) {
			return ObjectDataset.class;
		}

		if (obj instanceof List<?>) {
			List<?> jl = (List<?>) obj;
			int l = jl.size();
			for (int i = 0; i < l; i++) {
				Class<? extends Dataset> lc = getInterface(jl.get(i));
				if (isBetter(lc, dc)) {
					dc = lc;
				}
			}
		} else if (obj.getClass().isArray()) {
			Class<?> ca = obj.getClass().getComponentType();
			if (isElementSupported(ca)) {
				return class2Interface.get(ca);
			}
			int l = Array.getLength(obj);
			for (int i = 0; i < l; i++) {
				Object lo = Array.get(obj, i);
				Class<? extends Dataset> lc = getInterface(lo);
				if (isBetter(lc, dc)) {
					dc = lc;
				}
			}
		} else if (obj instanceof Dataset) {
			return ((Dataset) obj).getClass();
		} else if (obj instanceof ILazyDataset) {
			dc = getInterfaceFromClass(((ILazyDataset) obj).getElementsPerItem(), ((ILazyDataset) obj).getElementClass());
		} else {
			Class<?> ca = obj.getClass();
			if (isElementSupported(ca)) {
				return class2Interface.get(ca);
			}
		}
		return dc;
	}

	/**
	 * @param elementsPerItem
	 * @param elementClass
	 * @return dataset interface 
	 */
	public static Class<? extends Dataset> getInterfaceFromClass(int elementsPerItem, Class<?> elementClass) {
		Class<? extends Dataset> clazz = class2Interface.get(elementClass);
		if (clazz == null) {
			throw new IllegalArgumentException("Class of object not supported");
		}
		if (elementsPerItem > 1 && interface2Compound.containsKey(clazz)) {
			clazz = interface2Compound.get(clazz);
		}
		return clazz;
	}

	/**
	 * @param clazz dataset interface
	 * @return elemental dataset interface available for given dataset interface
	 */
	public static Class<? extends Dataset> getElementalInterface(final Class<? extends Dataset> clazz) {
		return isElemental(clazz) ? clazz : compound2Interface.get(clazz);
	}

	/**
	 * @param a dataset
	 * @return true if dataset is not compound or complex
	 */
	public static boolean isElemental(ILazyDataset a) {
		return isElemental(getInterface(a));
	}

	/**
	 * @param clazz
	 * @return true if dataset interface is not compound or complex
	 */
	public static boolean isElemental(Class<? extends Dataset> clazz) {
		return !CompoundDataset.class.isAssignableFrom(clazz) || !ComplexFloatDataset.class.equals(clazz) || !ComplexDoubleDataset.class.equals(clazz);
	}

	/**
	 * @param clazz
	 * @return true if dataset interface is compound (not complex)
	 */
	public static boolean isCompound(Class<? extends Dataset> clazz) {
		return compound2Interface.containsKey(clazz) || RGBDataset.class.equals(clazz);
	}

	/**
	 * @param a dataset
	 * @return true if dataset has integer elements
	 */
	public static boolean isInteger(ILazyDataset a) {
		return a instanceof Dataset ? isInteger(((Dataset) a).getClass()) : isElementClassInteger(a.getElementClass());
	}

	/**
	 * @param a dataset
	 * @return true if dataset has floating point elements
	 */
	public static boolean isFloating(ILazyDataset a) {
		return a instanceof Dataset ? isFloating(((Dataset) a).getClass()) : isElementClassFloating(a.getElementClass());
	}

	/**
	 * @param clazz
	 * @return true if dataset interface has integer elements
	 */
	public static boolean isInteger(Class<? extends Dataset> clazz) {
		Class<?> c = interface2Class.get(clazz);
		return isElementClassInteger(c);
	}

	/**
	 * @param clazz
	 * @return true if dataset interface has floating point elements
	 */
	public static boolean isFloating(Class<? extends Dataset> clazz) {
		Class<?> c = interface2Class.get(clazz);
		return isElementClassFloating(c);
	}

	private static boolean isElementClassInteger(Class<?> c) {
		return Byte.class == c || Short.class == c || Integer.class == c || Long.class == c;
	}

	private static boolean isElementClassFloating(Class<?> c) {
		return Double.class == c || Float.class == c;
	}

	/**
	 * @param clazz
	 * @return true if dataset interface has complex items
	 */
	public static boolean isComplex(Class<? extends Dataset> clazz) {
		return ComplexDoubleDataset.class.isAssignableFrom(clazz) || ComplexFloatDataset.class.isAssignableFrom(clazz);
	}

	/**
	 * @param clazz
	 * @return true if dataset interface has numerical elements
	 */
	public static boolean isNumerical(Class<? extends Dataset> clazz) {
		Class<?> c = interface2Class.get(clazz);
		return Boolean.class == c || isElementClassInteger(c) || isElementClassFloating(c);
	}

	/**
	 * @param clazz
	 * @return number of elements per item
	 */
	public static int getElementsPerItem(Class<? extends Dataset> clazz) {
		if (isComplex(clazz)) {
			return 2;
		} else if (RGBDataset.class.isAssignableFrom(clazz)) {
			return 3;
		}
		if (CompoundDataset.class.isAssignableFrom(clazz)) {
			throw new UnsupportedOperationException("Multi-element type unsupported");
		}
		return 1;
	}

	/**
	 * Find dataset interface that best fits given classes. The best class takes into account complex and array datasets
	 *
	 * @param a
	 *            first dataset class
	 * @param b
	 *            second dataset class
	 * @return best dataset interface
	 */
	public static Class<? extends Dataset> getBestInterface(Class<? extends Dataset> a, Class<? extends Dataset> b) {
		boolean isElemental = true;
		
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		if (!isElemental(a)) {
			isElemental = false;
			a = compound2Interface.get(a);
		}
		if (!isElemental(b)) {
			isElemental = false;
			b = compound2Interface.get(b);
		}

		if (isFloating(a)) {
			if (!isFloating(b)) {
				b = getBestFloatInterface(b); // note doesn't change if not numerical!!!
			} else if (isComplex(b)) {
				a = DoubleDataset.class.isAssignableFrom(a) ? ComplexDoubleDataset.class : ComplexFloatDataset.class;
			}
			if (isComplex(a) && !isComplex(b)) {
				b = DoubleDataset.class.isAssignableFrom(b) ? ComplexDoubleDataset.class : ComplexFloatDataset.class;
			}
		} else if (isFloating(b)) {
			a = getBestFloatInterface(a);
			if (isComplex(b)) {
				a = DoubleDataset.class.isAssignableFrom(a) ? ComplexDoubleDataset.class : ComplexFloatDataset.class;
			}
		}

		Class<? extends Dataset> c = isBetter(interface2Class.get(a), interface2Class.get(b)) ? a : b;

		if (!isElemental && interface2Compound.containsKey(c)) {
			c = interface2Compound.get(c);
		}
		return c;
	}

	private static boolean isBetter(Class<?> a, Class<?> b) {
		for (Class<?> k : elementBytes.keySet()) { // elements order in increasing width (for numerical primitives)
			if (k.equals(b)) {
				return true;
			}
			if (k.equals(a)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * The largest dataset type suitable for a summation of around a few thousand items without changing from the "kind"
	 * of dataset
	 *
	 * @param otype
	 * @return largest dataset type available for given dataset type
	 */
	public static Class<? extends Dataset> getLargestInterface(Dataset a) {
		if (a instanceof BooleanDataset || a instanceof ByteDataset || a instanceof ShortDataset) {
			return IntegerDataset.class;
		} else if (a instanceof IntegerDataset) {
			return LongDataset.class;
		} else if (a instanceof FloatDataset) {
			return DoubleDataset.class;
		} else if (a instanceof ComplexFloatDataset) {
			return ComplexDoubleDataset.class;
		} else if (a instanceof CompoundByteDataset || a instanceof CompoundShortDataset) {
			return CompoundIntegerDataset.class;
		} else if (a instanceof CompoundIntegerDataset) {
			return CompoundLongDataset.class;
		} else if (a instanceof CompoundFloatDataset) {
			return CompoundDoubleDataset.class;
		}
		return a.getClass();
	}

	/**
	 * Find floating point dataset interface that best fits given types. The best type takes into account complex and array
	 * datasets
	 *
	 * @param clazz
	 *            old dataset class
	 * @return best dataset interface
	 */
	public static Class<? extends Dataset> getBestFloatInterface(Class<? extends Dataset> clazz) {
		Class<?> e = interface2Class.get(clazz);
		if (bestFloatElement.containsKey(e)) {
			e = bestFloatElement.get(e);
			return class2Interface.get(e);
		}
		return clazz;
	}

	/**
	 * @param isize
	 *            number of elements in an item
	 * @param dtype
	 * @return length of single item in bytes
	 */
	public static int getItemBytes(final int isize, Class<? extends Dataset> clazz) {
		int bytes = elementBytes.get(interface2Class.get(clazz));

		return isize * bytes;
	}

	/**
	 * Convert double array to primitive array
	 * @param clazz dataset interface
	 * @param x
	 * @return biggest native primitive array if integer. Return null if not interface is not numerical
	 */
	public static Object fromDoublesToBiggestPrimitives(Class<? extends Dataset> clazz, double[] x) {
		if (BooleanDataset.class.isAssignableFrom(clazz) || ByteDataset.class.isAssignableFrom(clazz)
				|| ShortDataset.class.isAssignableFrom(clazz) || IntegerDataset.class.isAssignableFrom(clazz)) {
			int[] i32 = new int[x.length];
			for (int i = 0; i < x.length; i++) {
				i32[i] = (int) (long) x[i];
			}
			return i32;
		} else if (LongDataset.class.isAssignableFrom(clazz)) {
			long[] i64 = new long[x.length];
			for (int i = 0; i < x.length; i++) {
				i64[i] = (long) x[i];
			}
			return i64;
		} else if (FloatDataset.class.isAssignableFrom(clazz)) {
			float[] f32 = new float[x.length];
			for (int i = 0; i < x.length; i++) {
				f32[i] = (float) x[i];
			}
			return f32;
		} else if (DoubleDataset.class.isAssignableFrom(clazz)) {
			return x;
		}
		return null;
	}

	/**
	 * Convert double to number
	 * @param clazz dataset interface
	 * @param x
	 * @return number if integer. Return null if not interface is not numerical
	 * @since 2.3
	 */
	public static Number fromDoubleToNumber(Class<? extends Dataset> clazz, double x) {
		if (BooleanDataset.class.isAssignableFrom(clazz) || ByteDataset.class.isAssignableFrom(clazz)) {
			return Byte.valueOf((byte) (long) x);
		} else if (ShortDataset.class.isAssignableFrom(clazz)) {
			return Short.valueOf((short) (long) x);
		} else if (IntegerDataset.class.isAssignableFrom(clazz)) {
			return Integer.valueOf((int) (long) x);
		} else if (LongDataset.class.isAssignableFrom(clazz)) {
			return Long.valueOf((long) x);
		} else if (FloatDataset.class.isAssignableFrom(clazz)) {
			return Float.valueOf((float) x);
		} else if (DoubleDataset.class.isAssignableFrom(clazz)) {
			return Double.valueOf(x);
		}
		return null;
	}

	/**
	 * Convert double to number
	 * @param clazz dataset interface
	 * @param x
	 * @return biggest number if integer. Return null if not interface is not numerical
	 */
	public static Number fromDoubleToBiggestNumber(Class<? extends Dataset> clazz, double x) {
		if (BooleanDataset.class.isAssignableFrom(clazz) || ByteDataset.class.isAssignableFrom(clazz)
				|| ShortDataset.class.isAssignableFrom(clazz) || IntegerDataset.class.isAssignableFrom(clazz)) {
			return Integer.valueOf((int) (long) x);
		} else if (LongDataset.class.isAssignableFrom(clazz)) {
			return Long.valueOf((long) x);
		} else if (FloatDataset.class.isAssignableFrom(clazz)) {
			return Float.valueOf((float) x);
		} else if (DoubleDataset.class.isAssignableFrom(clazz)) {
			return Double.valueOf(x);
		}
		return null;
	}

	/**
	 * @param clazz dataset interface
	 * @param x
	 * @return biggest native primitive if integer
	 * @since 2.3
	 */
	public static Number toBiggestNumber(Class<? extends Dataset> clazz, Number x) {
		if (BooleanDataset.class.isAssignableFrom(clazz) || ByteDataset.class.isAssignableFrom(clazz)
				|| ShortDataset.class.isAssignableFrom(clazz) || IntegerDataset.class.isAssignableFrom(clazz)) {
			return x instanceof Integer ? x : Integer.valueOf(x.intValue());
		} else if (LongDataset.class.isAssignableFrom(clazz)) {
			return x instanceof Long ? x : Long.valueOf(x.longValue());
		} else if (FloatDataset.class.isAssignableFrom(clazz)) {
			return x instanceof Float ? x : Float.valueOf(x.floatValue());
		} else if (DoubleDataset.class.isAssignableFrom(clazz)) {
			return x instanceof Double ? x : Double.valueOf(x.doubleValue());
		}
		return null;
	}
}
