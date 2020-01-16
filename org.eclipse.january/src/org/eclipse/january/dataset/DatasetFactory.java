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

import java.util.Date;
import java.util.List;

public class DatasetFactory {

	/**
	 * Create dataset with items ranging from 0 up to given stop in steps of 1
	 * @param stop stop value is <strong>not</strong> included
	 * @param dtype
	 * @return a new dataset of given shape and type, filled with values determined by parameters
	 * 
	 * @deprecated Please use the class-based methods in DatasetFactory,
	 *             such as {@link #createRange(Class, double)}
	 */
	@Deprecated
	public static Dataset createRange(final double stop, final int dtype) {
		return createRange(0, stop, 1, dtype);
	}

	/**
	 * Create dataset with items ranging from given start up to given stop in given steps
	 * @param start
	 * @param stop stop value is <strong>not</strong> included
	 * @param step spacing between items
	 * @param dtype
	 * @return a new 1D dataset of given type, filled with values determined by parameters
	 * 
	 * @deprecated Please use the class-based methods in DatasetFactory,
	 *             such as {@link #createRange(Class, double, double, double)}
	 */
	@Deprecated
	public static Dataset createRange(final double start, final double stop, final double step, final int dtype) {
		return createRange(DTypeUtils.getInterface(dtype), start, stop, step);
	}

	/**
	 * Create compound dataset with items of given size ranging from 0 up to given stop in steps of 1
	 * @param itemSize
	 * @param stop stop value is <strong>not</strong> included
	 * @param dtype
	 * @return a new dataset of given shape and type, filled with values determined by parameters
	 * 
	 * @deprecated Please use the class-based methods in DatasetFactory,
	 *             such as {@link #createRange(int, Class, double)}
	 */
	@Deprecated
	public static CompoundDataset createRange(final int itemSize, final double stop, final int dtype) {
		return createRange(itemSize, 0, stop, 1, dtype);
	}

	/**
	 * Create compound dataset with items of given size ranging from given start up to given stop in given steps
	 * @param itemSize
	 * @param start
	 * @param stop stop value is <strong>not</strong> included
	 * @param step spacing between items
	 * @param dtype
	 * @return a new 1D dataset of given type, filled with values determined by parameters
	 * 
	 * @deprecated Please use the class-based methods in DatasetFactory,
	 *             such as {@link #createRange(int, Class, double, double, double)}
	 */
	@Deprecated
	public static CompoundDataset createRange(final int itemSize, final double start, final double stop, final double step, final int dtype) {
		Class<? extends CompoundDataset> clazz = InterfaceUtils.getCompoundInterface(DTypeUtils.getInterface(dtype));
		return createRange(itemSize, clazz, start, stop, step);
	}

	/**
	 * Create a dataset from object
	 * @param dtype
	 * @param obj
	 *            can be a Java list, array or Number
	 * @return dataset
	 * @throws IllegalArgumentException if dataset type is not known
	 * 
	 * @deprecated Please use the class-based methods in DatasetFactory,
	 *             such as {@link #createFromObject(Class, Object, int...)}
	 */
	@Deprecated
	public static Dataset createFromObject(final int dtype, final Object obj) {
		return createFromObject(dtype, obj, null);
	}

	/**
	 * Create a dataset from object
	 * @param dtype
	 * @param obj
	 *            can be a Java list, array or Number
	 * @param shape can be null
	 * @return dataset
	 * @throws IllegalArgumentException if dataset type is not known
	 * 
	 * @deprecated Please use the class-based methods in DatasetFactory,
	 *             such as {@link #createFromObject(Class, Object, int...)}
	 */
	@Deprecated
	public static Dataset createFromObject(final int dtype, final Object obj, final int... shape) {
		return createFromObject(1, dtype, obj, shape);
	}

	/**
	 * Create a dataset from object
	 * @param itemSize
	 * @param dtype
	 * @param obj
	 *            can be a Java list, array or Number
	 * @param shape can be null
	 * @return dataset
	 * @throws IllegalArgumentException if dataset type is not known
	 * 
	 * @deprecated Please use the class-based methods in DatasetFactory,
	 *             such as {@link #createFromObject(int, Class, Object, int...)}
	 */
	@Deprecated
	public static Dataset createFromObject(final int itemSize, final int dtype, final Object obj, final int... shape) {
		return createFromObject(itemSize, DTypeUtils.getInterface(dtype), obj, shape);
	}

	/**
	 * Create dataset of given type from list
	 *
	 * @param dtype
	 * @param objectList
	 * @return dataset filled with values from list
	 * 
	 * @deprecated Please use the class-based methods in DatasetFactory,
	 *             such as {@link #createFromList(Class, List)}
	 */	
	@Deprecated
	public static Dataset createFromList(final int dtype, List<?> objectList) {
		return createFromList(DTypeUtils.getInterface(dtype), objectList);
	}

	/**
	 * Create compound dataset of given type from given parts
	 *
	 * @param dtype
	 * @param objects
	 * @return compound dataset
	 * 
	 * @deprecated Please use the class-based methods in DatasetFactory,
	 *             such as {@link #createCompoundDataset(Class, Object...)}
	 */
	@Deprecated
	public static CompoundDataset createCompoundDataset(final int dtype, Object... objects) {
		return (CompoundDataset) createCompoundDataset(DTypeUtils.getInterface(dtype), objects);
	}

	/**
	 * Create complex dataset of given type from real and imaginary parts
	 *
	 * @param dtype
	 * @param real
	 * @param imag
	 * @return complex dataset
	 * 
	 * @deprecated Please use the class-based methods in DatasetFactory,
	 *             such as {@link #createComplexDataset(Class, Object, Object)}
	 */
	@Deprecated
	public static CompoundDataset createComplexDataset(final int dtype, Object real, Object imag) {
		return createComplexDataset(DTypeUtils.getInterface(dtype), real, imag);
	}

	/**
	 * @param shape
	 * @param dtype
	 * @return a new dataset of given shape and type, filled with zeros
	 * 
	 * @deprecated Please use the class-based methods in DatasetFactory,
	 *             such as {@link #zeros(Class, int...)}
	 */
	@Deprecated
	public static Dataset zeros(final int[] shape, final int dtype) {
		return zeros(DTypeUtils.getInterface(dtype), shape);
	}

	/**
	 * @param itemSize
	 *            if equal to 1, then non-compound dataset is returned
	 * @param shape
	 * @param dtype
	 * @return a new dataset of given item size, shape and type, filled with zeros
	 * 
	 * @deprecated Please use the class-based methods in DatasetFactory,
	 *             such as {@link #zeros(int, Class, int...)}
	 */
	@Deprecated
	public static Dataset zeros(final int itemSize, final int[] shape, final int dtype) {
		if (itemSize == 1) {
			return zeros(shape, dtype);
		}
		return compoundZeros(itemSize, shape, dtype);
	}

	/**
	 * @param itemSize
	 * @param shape
	 * @param dtype
	 * @return a new dataset of given item size, shape and type, filled with zeros
	 * @since 2.0
	 * 
	 * @deprecated Please use the class-based methods in DatasetFactory,
	 *             such as {@link #compoundZeros(int, Class, int...)}
	 */
	@Deprecated
	public static CompoundDataset compoundZeros(final int itemSize, final int[] shape, final int dtype) {
		return compoundZeros(itemSize, InterfaceUtils.getCompoundInterface(DTypeUtils.getInterface(dtype)), shape);
	}

	/**
	 * Create a new dataset of same shape as input dataset, filled with zeros. If dtype is not
	 * explicitly compound then an elemental dataset is created 
	 * @param dataset
	 * @param dtype
	 * @return a new dataset
	 * 
	 * @deprecated Please use the class-based methods in DatasetFactory,
	 *             such as {@link #zeros(Dataset, Class)}
	 */
	@Deprecated
	public static Dataset zeros(final Dataset dataset, final int dtype) {
		Class<? extends Dataset> clazz = DTypeUtils.getInterface(dtype);
		final int isize = InterfaceUtils.isElemental(clazz) ? 1 :dataset.getElementsPerItem();

		return zeros(isize, clazz, dataset.getShapeRef());
	}

	/**
	 * Create a new dataset of same shape as input dataset, filled with ones. If dtype is not
	 * explicitly compound then an elemental dataset is created
	 * @param dataset
	 * @param dtype
	 * @return a new dataset
	 * 
	 * @deprecated Please use the class-based methods in DatasetFactory,
	 *             such as {@link #ones(Dataset, Class)}
	 */
	@Deprecated
	public static Dataset ones(final Dataset dataset, final int dtype) {
		Class<? extends Dataset> clazz = DTypeUtils.getInterface(dtype);
		final int isize = InterfaceUtils.isElemental(clazz) ? 1 :dataset.getElementsPerItem();

		return ones(isize, clazz, dataset.getShapeRef());
	}

	/**
	 * @param shape
	 * @param dtype
	 * @return a new dataset of given shape and type, filled with ones
	 * 
	 * @deprecated Please use the class-based methods in DatasetFactory,
	 *             such as {@link #ones(Class, int...)}
	 */
	@Deprecated
	public static Dataset ones(final int[] shape, final int dtype) {
		return ones(DTypeUtils.getInterface(dtype), shape);
	}

	/**
	 * @param itemSize
	 *            if equal to 1, then non-compound dataset is returned
	 * @param shape
	 * @param dtype
	 * @return a new dataset of given item size, shape and type, filled with ones
	 * 
	 * @deprecated Please use the class-based methods in DatasetFactory,
	 *             such as {@link #ones(Class, int...)}
	 */
	@Deprecated
	public static Dataset ones(final int itemSize, final int[] shape, final int dtype) {
		return ones(itemSize, DTypeUtils.getInterface(dtype), shape);
	}

	/**
	 * Create a 1D dataset of linearly spaced values in closed interval
	 * 
	 * @param start
	 * @param stop stop value is included
	 * @param length number of points
	 * @param dtype
	 * @return dataset with linearly spaced values
	 * 
	 * @deprecated Please use the class-based methods in DatasetFactory,
	 *             such as {@link #createLinearSpace(Class, double, double, int)}
	 */
	@Deprecated
	public static Dataset createLinearSpace(final double start, final double stop, final int length, final int dtype) {
		return createLinearSpace(DTypeUtils.getInterface(dtype), start, stop, length);
	}

	/**
	 * Create a 1D dataset of logarithmically spaced values in closed interval. The base value is used to
	 * determine the factor between values: factor = base ** step, where step is the interval between linearly
	 * spaced sequence of points
	 * 
	 * @param start
	 * @param stop stop value is included
	 * @param length number of points
	 * @param base
	 * @param dtype
	 * @return dataset with logarithmically spaced values
	 * 
	 * @deprecated Please use the class-based methods in DatasetFactory,
	 *             such as {@link #createLogSpace(Class, double, double, int, double)}
	 */
	@Deprecated
	public static Dataset createLogSpace(final double start, final double stop, final int length, final double base, final int dtype) {
		return createLogSpace(DTypeUtils.getInterface(dtype), start, stop, length, base);
	}

	/**
	 * Create a 1D dataset of linearly spaced values in closed interval
	 * 
	 * @param clazz dataset class
	 * @param start
	 * @param stop stop value is included
	 * @param length number of points
	 * @return dataset with linearly spaced values
	 */
	public static <T extends Dataset> T createLinearSpace(Class<T> clazz, final double start, final double stop, final int length) {
		if (length < 1) {
			throw new IllegalArgumentException("Length is less than one");
		} else if (length == 1) {
			return createFromObject(clazz, start);
		} else {
			T ds = zeros(clazz, length);
			double num = stop - start;
			double den = length - 1;
			double value;
	
			for (int i = 0; i < length; i++) {
				value = start + (num * i) / den;
				ds.setObjectAbs(i, value);
			}
	
			return ds;
		}
	}

	/**
	 * Create a 1D dataset of logarithmically spaced values in closed interval. The base value is used to
	 * determine the factor between values: factor = base ** step, where step is the interval between linearly
	 * spaced sequence of points
	 * 
	 * @param clazz dataset class
	 * @param start
	 * @param stop stop value is included
	 * @param length number of points
	 * @param base
	 * @return dataset with logarithmically spaced values
	 */
	public static <T extends Dataset> T createLogSpace(Class<T> clazz, final double start, final double stop, final int length, final double base) {
		if (length < 1) {
			throw new IllegalArgumentException("Length is less than one");
		} else if (length == 1) {
			return createFromObject(clazz, Math.pow(base, start));
		} else {
			T ds = zeros(clazz, length);
			double step = (stop - start) / (length - 1);
			double value;
	
			for (int i = 0; i < length; i++) {
				value = start + i * step;
				ds.setObjectAbs(i, Math.pow(base, value));
			}
	
			return ds;
		}
	}

	/**
	 * Create dataset with items ranging from 0 up to given stop in steps of 1
	 * @param stop stop value is <strong>not</strong> included
	 * @return a new double dataset of given shape and type, filled with values determined by parameters
	 */
	public static DoubleDataset createRange(final double stop) {
		return createRange(DoubleDataset.class, 0, stop, 1);
	}

	/**
	 * Create dataset with items ranging from given start up to given stop in given steps
	 * @param start
	 * @param stop stop value is <strong>not</strong> included
	 * @param step spacing between items
	 * @return a new 1D dataset of given type, filled with values determined by parameters
	 * @since 2.1
	 */
	public static DoubleDataset createRange(final double start, final double stop, final double step) {
		return createRange(DoubleDataset.class, start, stop, step);
	}

	/**
	 * Create dataset with items ranging from 0 up to given stop in steps of 1
	 * @param clazz dataset class
	 * @param stop stop value is <strong>not</strong> included
	 * @return a new dataset of given shape and class, filled with values determined by parameters
	 */
	public static <T extends Dataset> T createRange(Class<T> clazz, final double stop) {
		return createRange(clazz, 0, stop, 1);
	}

	/**
	 * Create dataset with items ranging from given start up to given stop in given steps
	 * @param clazz dataset class
	 * @param start
	 * @param stop stop value is <strong>not</strong> included
	 * @param step spacing between items
	 * @return a new 1D dataset of given class, filled with values determined by parameters
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Dataset> T createRange(Class<T> clazz, final double start, final double stop, final double step) {
		if ((step > 0) != (start <= stop)) {
			throw new IllegalArgumentException("Invalid parameters: start and stop must be in correct order for step");
		}

		Dataset d = null;
		if (ByteDataset.class.isAssignableFrom(clazz)) {
			d = ByteDataset.createRange(start, stop, step);
		} else if (ShortDataset.class.isAssignableFrom(clazz)) {
			d = ShortDataset.createRange(start, stop, step);
		} else if (IntegerDataset.class.isAssignableFrom(clazz)) {
			d = IntegerDataset.createRange(start, stop, step);
		} else if (LongDataset.class.isAssignableFrom(clazz)) {
			d = LongDataset.createRange(start, stop, step);
		} else if (FloatDataset.class.isAssignableFrom(clazz)) {
			d = FloatDataset.createRange(start, stop, step);
		} else if (DoubleDataset.class.isAssignableFrom(clazz)) {
			d = DoubleDataset.createRange(start, stop, step);
		} else if (ComplexFloatDataset.class.isAssignableFrom(clazz)) {
			d = ComplexFloatDataset.createRange(start, stop, step);
		} else if (ComplexDoubleDataset.class.isAssignableFrom(clazz)) {
			d = ComplexDoubleDataset.createRange(start, stop, step);
		} else {
			throw new IllegalArgumentException("Dataset interface not supported");
		}

		return (T) d;
	}

	/**
	 * Create compound dataset with items ranging from 0 up to given stop in steps of 1
	 * @param itemSize
	 * @param clazz compound dataset class
	 * @param stop stop value is <strong>not</strong> included
	 * @return a new 1D dataset of given class, filled with values determined by parameters
	 * @since 2.1
	 */
	public static <T extends CompoundDataset> T createRange(final int itemSize, Class<T> clazz, final double stop) {
		return createRange(itemSize, clazz, 0, stop, 1);
	}

	/**
	 * Create compound dataset with items ranging from given start up to given stop in given steps
	 * @param itemSize
	 * @param clazz compound dataset class
	 * @param start
	 * @param stop stop value is <strong>not</strong> included
	 * @param step spacing between items
	 * @return a new 1D dataset of given class, filled with values determined by parameters
	 * @since 2.1
	 */
	@SuppressWarnings("unchecked")
	public static <T extends CompoundDataset> T createRange(final int itemSize, Class<T> clazz, final double start, final double stop, final double step) {
		if (itemSize < 1) {
			throw new IllegalArgumentException("Item size must be greater or equal to 1");
		}
		if ((step > 0) != (start <= stop)) {
			throw new IllegalArgumentException("Invalid parameters: start and stop must be in correct order for step");
		}

		CompoundDataset c = null;
		if (CompoundByteDataset.class.isAssignableFrom(clazz)) {
			c = CompoundIntegerDataset.createRange(itemSize, start, stop, step);
		} else if (CompoundShortDataset.class.isAssignableFrom(clazz)) {
			c = CompoundShortDataset.createRange(itemSize, start, stop, step);
		} else if (CompoundIntegerDataset.class.isAssignableFrom(clazz)) {
			c = CompoundIntegerDataset.createRange(itemSize, start, stop, step);
		} else if (CompoundLongDataset.class.isAssignableFrom(clazz)) {
			c = CompoundLongDataset.createRange(itemSize, start, stop, step);
		} else if (ComplexFloatDataset.class.isAssignableFrom(clazz)) {
			if (itemSize != 2) {
				throw new IllegalArgumentException("Item size must be equal to 2");
			}
			c = ComplexFloatDataset.createRange(start, stop, step);
		} else if (ComplexDoubleDataset.class.isAssignableFrom(clazz)) {
			if (itemSize != 2) {
				throw new IllegalArgumentException("Item size must be equal to 2");
			}
			c = ComplexDoubleDataset.createRange(start, stop, step);
		} else if (CompoundFloatDataset.class.isAssignableFrom(clazz)) {
			c = CompoundFloatDataset.createRange(itemSize, start, stop, step);
		} else if (CompoundDoubleDataset.class.isAssignableFrom(clazz)) {
			c = CompoundDoubleDataset.createRange(itemSize, start, stop, step);
		} else {
			throw new IllegalArgumentException("dtype not known");
		}
		return (T) c;
	}

	/**
	 * Create a dataset from object (automatically detect dataset type)
	 *
	 * @param obj
	 *            can be Java list, array or Number
	 * @return dataset
	 */
	public static Dataset createFromObject(Object obj) {
		return createFromObject(obj, null);
	}

	/**
	 * Create a dataset from object (automatically detect dataset type)
	 * 
	 * @param obj
	 *            can be Java list, array or Number
	 * @param shape can be null
	 * @return dataset
	 */
	public static Dataset createFromObject(Object obj, int... shape) {
		if (obj instanceof IDataset) {
			Dataset d = DatasetUtils.convertToDataset((IDataset) obj);
			if (shape != null) {
				d.setShape(shape);
			}
			return d;
		}
	
		return createFromObject(InterfaceUtils.getInterface(obj), obj, shape);
	}

	/**
	 * Create a dataset from object (automatically detect dataset type)
	 * @param isUnsigned
	 *            if true, interpret integer values as unsigned by increasing element bit width if required
	 * @param obj
	 *            can be a Java list, array or Number
	 * @return dataset
	 */
	public static Dataset createFromObject(boolean isUnsigned, final Object obj) {
		Dataset a = createFromObject(obj);
		if (isUnsigned) {
			a = DatasetUtils.makeUnsigned(a, true);
		}
		return a;
	}

	/**
	 * Create dataset of appropriate type from list
	 * 
	 * @param objectList
	 * @return dataset filled with values from list
	 */
	public static Dataset createFromList(List<?> objectList) {
		if (objectList == null || objectList.size() == 0) {
			throw new IllegalArgumentException("No list or zero-length list given");
		}
	
		Object obj = null;
		for (Object o : objectList) {
			if (o != null) {
				obj = o;
				break;
			}
		}
		if (obj == null) {
			return zeros(ObjectDataset.class, objectList.size());
		}
	
		Class<? extends Object> clazz = obj.getClass();
		if (InterfaceUtils.isElementSupported(clazz)) {
			return createFromList(InterfaceUtils.getInterface(obj), objectList);
		}
	
		return createFromObject(objectList);
	}

	/**
	 * Create compound dataset of given type from given parts
	 *
	 * @param objects
	 * @return compound dataset
	 */
	public static CompoundDataset createCompoundDataset(Object... objects) {
		Dataset[] datasets = new Dataset[objects.length];
		for (int i = 0; i < objects.length; i++) {
			datasets[i] = createFromObject(objects[i]);
		}
		return DatasetUtils.createCompoundDataset(datasets);
	}

	/**
	 * Create a dataset from object
	 * @param clazz dataset class
	 * @param obj
	 *            can be a Java list, array or Number
	 * @return dataset
	 * @throws IllegalArgumentException if dataset class is not known
	 * @since 2.1
	 */
	public static <T extends Dataset> T createFromObject(Class<T> clazz, Object obj) {
		return createFromObject(1, clazz, obj, null);
	}


	/**
	 * Create a dataset from object
	 * @param clazz dataset class
	 * @param obj
	 *            can be a Java list, array or Number
	 * @param shape can be null
	 * @return dataset
	 */
	public static <T extends Dataset> T createFromObject(Class<T> clazz, Object obj, int... shape) {
		return createFromObject(1, clazz, obj, shape);
	}

	/**
	 * Create a compound dataset from object
	 * @param itemSize
	 * @param clazz dataset class
	 * @param obj
	 *            can be a Java list, array or Number
	 * @param shape can be null
	 * @return dataset
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Dataset> T createFromObject(final int itemSize, Class<T> clazz, Object obj, int... shape) {
		Dataset d = null;

		if (obj instanceof IDataset) {
			d = itemSize == 1 ? DatasetUtils.cast(clazz, (IDataset) obj) :
				DatasetUtils.cast(itemSize, clazz, (IDataset) obj, false);
		} else {
			// primitive arrays
			Class<? extends Object> ca = obj == null ? null : obj.getClass().getComponentType();
			if (ca != null && (ca.isPrimitive() || ca.equals(String.class))) {
				if (ComplexFloatDataset.class.isAssignableFrom(clazz)) {
					return (T) new ComplexFloatDataset(DTypeUtils.toFloatArray(obj, DTypeUtils.getLength(obj)), shape);
				} else if (ComplexDoubleDataset.class.isAssignableFrom(clazz)) {
					return (T) new ComplexDoubleDataset(DTypeUtils.toDoubleArray(obj, DTypeUtils.getLength(obj)), shape);
				} else {
					d = createFromPrimitiveArray(InterfaceUtils.getInterfaceFromClass(1, ca), obj);
					if (!InterfaceUtils.isElemental(clazz)) {
						if (RGBDataset.class.isAssignableFrom(clazz)) {
							d = DatasetUtils.createCompoundDataset(d, 3);
							if (d.getSize() == 1) { // special case of allowing a zero-rank RGB dataset
								d.setShape();
							}
						} else {
							d = DatasetUtils.createCompoundDataset(d, itemSize);
						}
					}
					d = d.cast(clazz);
				}
			} else {
//				if (itemSize != 1 && !InterfaceUtils.isElemental(clazz)) {
//					throw new IllegalArgumentException("Compound dataset interface needed for itemSize > 1");
//				}
				if (BooleanDataset.class.isAssignableFrom(clazz)) {
					d = BooleanDataset.createFromObject(obj);
				} else if (ByteDataset.class.isAssignableFrom(clazz)) {
					d = ByteDataset.createFromObject(obj);
				} else if (ShortDataset.class.isAssignableFrom(clazz)) {
					d = ShortDataset.createFromObject(obj);
				} else if (IntegerDataset.class.isAssignableFrom(clazz)) {
					d = IntegerDataset.createFromObject(obj);
				} else if (LongDataset.class.isAssignableFrom(clazz)) {
					d = LongDataset.createFromObject(obj);
				} else if (CompoundByteDataset.class.isAssignableFrom(clazz)) {
					d = CompoundByteDataset.createFromObject(itemSize, obj);
				} else if (RGBDataset.class.isAssignableFrom(clazz)) {
					d = RGBDataset.createFromObject(obj);
				} else if (CompoundShortDataset.class.isAssignableFrom(clazz)) {
					d = CompoundShortDataset.createFromObject(itemSize, obj);
				} else if (CompoundIntegerDataset.class.isAssignableFrom(clazz)) {
					d = CompoundIntegerDataset.createFromObject(itemSize, obj);
				} else if (CompoundLongDataset.class.isAssignableFrom(clazz)) {
					d = CompoundLongDataset.createFromObject(itemSize, obj);
				} else if (FloatDataset.class.isAssignableFrom(clazz)) {
					d = FloatDataset.createFromObject(obj);
				} else if (DoubleDataset.class.isAssignableFrom(clazz)) {
					d = DoubleDataset.createFromObject(obj);
				} else if (ComplexFloatDataset.class.isAssignableFrom(clazz)) {
					d = ComplexFloatDataset.createFromObject(obj);
				} else if (ComplexDoubleDataset.class.isAssignableFrom(clazz)) {
					d = ComplexDoubleDataset.createFromObject(obj);
				} else if (CompoundFloatDataset.class.isAssignableFrom(clazz)) {
					d = CompoundFloatDataset.createFromObject(itemSize, obj);
				} else if (CompoundDoubleDataset.class.isAssignableFrom(clazz)) {
					d = CompoundDoubleDataset.createFromObject(itemSize, obj);
				} else if (DateDataset.class.isAssignableFrom(clazz)) {
					d = DateDatasetImpl.createFromObject(obj);
				} else if (StringDataset.class.isAssignableFrom(clazz)) {
					d = StringDataset.createFromObject(obj);
				} else if (ObjectDataset.class.isAssignableFrom(clazz)) {
					d = ObjectDataset.createFromObject(obj);
				} else {
					throw new IllegalArgumentException("Dataset interface is not unsupported");
				}
			}
		}

		if (shape != null && !(shape.length == 0 && d.getSize() > 1)) { // allow zero-rank datasets
			d.setShape(shape);
		}
		return (T) d;
	}

	private static Dataset createFromPrimitiveArray(Class<? extends Dataset> clazz, final Object array) {
		if (BooleanDataset.class.isAssignableFrom(clazz)) {
			return new BooleanDataset((boolean[]) array);
		} else if (ByteDataset.class.isAssignableFrom(clazz)) {
			return new ByteDataset((byte[]) array);
		} else if (ShortDataset.class.isAssignableFrom(clazz)) {
			return new ShortDataset((short[]) array);
		} else if (IntegerDataset.class.isAssignableFrom(clazz)) {
			return new IntegerDataset((int[]) array, null);
		} else if (LongDataset.class.isAssignableFrom(clazz)) {
			return new LongDataset((long[]) array);
		} else if (FloatDataset.class.isAssignableFrom(clazz)) {
			return new FloatDataset((float[]) array);
		} else if (DoubleDataset.class.isAssignableFrom(clazz)) {
			return new DoubleDataset((double[]) array);
		} else if (StringDataset.class.isAssignableFrom(clazz)) {
			return new StringDataset((String[]) array);
		} else if (DateDataset.class.isAssignableFrom(clazz)) {
			return new DateDatasetImpl((Date[]) array);
		}
		return null;
	}

	/**
	 * Create dataset of given class from list
	 *
	 * @param clazz dataset class
	 * @param objectList
	 * @return dataset filled with values from list
	 */
	public static <T extends Dataset> T createFromList(Class<T> clazz, List<?> objectList) {
		int len = objectList.size();
		T result = zeros(clazz, len);

		for (int i = 0; i < len; i++) {
			result.setObjectAbs(i, objectList.get(i));
		}
		return result;
	}

	/**
	 * Create compound dataset of given class from given parts
	 *
	 * @param clazz dataset class
	 * @param objects
	 * @return compound dataset
	 * @since 2.3
	 */
	public static <T extends CompoundDataset> T createCompoundDataset(Class<T> clazz, Object... objects) {
		Dataset[] datasets = new Dataset[objects.length];
		for (int i = 0; i < objects.length; i++) {
			datasets[i] = createFromObject(objects[i]);
		}
		return DatasetUtils.createCompoundDataset(clazz, datasets);
	}

	/**
	 * Create complex dataset of given class from real and imaginary parts
	 *
	 * @param clazz dataset class
	 * @param real
	 * @param imag
	 * @return complex dataset
	 * @since 2.3
	 */
	@SuppressWarnings("unchecked")
	public static <T extends CompoundDataset> T createComplexDataset(Class<? extends Dataset> clazz, Object real, Object imag) {
		if (ComplexFloatDataset.class.isAssignableFrom(clazz)) {
			return (T) new ComplexFloatDataset(createFromObject(real), createFromObject(imag));
		} else if (ComplexDoubleDataset.class.isAssignableFrom(clazz)) {
			return (T) new ComplexDoubleDataset(createFromObject(real), createFromObject(imag));
		} else {
			throw new IllegalArgumentException("Dataset class must be a complex one");
		}
	}

	/**
	 * @param shape
	 * @return a new double dataset of given shape, filled with zeros
	 */
	public static DoubleDataset zeros(final int... shape) {
		return zeros(DoubleDataset.class, shape);
	}

	/**
	 * @param dataset
	 * @return a new dataset of same shape and class as input dataset, filled with zeros
	 */
	public static <T extends Dataset> T zeros(final T dataset) {
		return zeros(dataset, dataset.getShapeRef());
	}

	/**
	 * @param dataset
	 * @param shape
	 * @return a new dataset of same class as input dataset and given shape, filled with zeros
	 * @since 2.3
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Dataset> T zeros(final T dataset, int... shape) {
		Class<? extends Dataset> clazz = dataset.getClass();
		return (T) (InterfaceUtils.isElemental(dataset.getClass()) ? zeros(clazz, shape) :
			compoundZeros(dataset.getElementsPerItem(), InterfaceUtils.getCompoundInterface(clazz), shape));
	}

	/**
	 * @param clazz dataset class
	 * @param shape
	 * @return a new dataset of given shape and class, filled with zeros
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Dataset> T zeros(Class<T> clazz, int... shape) {
		if (BooleanDataset.class.isAssignableFrom(clazz)) {
			return (T) new BooleanDataset(shape);
		} else if (ByteDataset.class.isAssignableFrom(clazz)) {
			return (T) new ByteDataset(shape);
		} else if (ShortDataset.class.isAssignableFrom(clazz)) {
			return (T) new ShortDataset(shape);
		} else if (IntegerDataset.class.isAssignableFrom(clazz)) {
			return (T) new IntegerDataset(shape);
		} else if (LongDataset.class.isAssignableFrom(clazz)) {
			return (T) new LongDataset(shape);
		} else if (FloatDataset.class.isAssignableFrom(clazz)) {
			return (T) new FloatDataset(shape);
		} else if (DoubleDataset.class.isAssignableFrom(clazz)) {
			return (T) new DoubleDataset(shape);
		} else if (RGBDataset.class.isAssignableFrom(clazz)) {
			return (T) new RGBDataset(shape);
		} else if (ComplexFloatDataset.class.isAssignableFrom(clazz)) {
			return (T) new ComplexFloatDataset(shape);
		} else if (ComplexDoubleDataset.class.isAssignableFrom(clazz)) {
			return (T) new ComplexDoubleDataset(shape);
		} else if (StringDataset.class.isAssignableFrom(clazz)) {
			return (T) new StringDataset(shape);
		} else if (DateDataset.class.isAssignableFrom(clazz)) {
			return (T) new DateDatasetImpl(shape);
		} else if (ObjectDataset.class.isAssignableFrom(clazz)) {
			return (T) new ObjectDataset(shape);
		}

		throw new IllegalArgumentException("Interface not known or unsupported");
	}

	/**
	 * @param itemSize
	 *            if equal to 1, then non-compound dataset is returned
	 * @param clazz dataset class
	 * @param shape
	 * @return a new dataset of given item size, shape and class, filled with zeros
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Dataset> T zeros(int itemSize, Class<T> clazz, int... shape) {
		if (itemSize == 1 && InterfaceUtils.isElemental(clazz)) {
			return zeros(clazz, shape);
		}
		return (T) compoundZeros(itemSize, InterfaceUtils.getCompoundInterface(clazz), shape);
	}

	/**
	 * @param dataset
	 * @param clazz dataset class
	 * @return a new dataset of given class with same shape as input dataset, filled with zeros
	 */
	public static <T extends Dataset> T zeros(Dataset dataset, Class<T> clazz) {
		return (T) zeros(dataset.getElementsPerItem(), clazz, dataset.getShapeRef());
	}

	/**
	 * @param itemSize
	 * @param clazz compound dataset class
	 * @param shape
	 * @return a new compound dataset of given item size, shape and class, filled with zeros
	 * @since 2.0
	 */
	@SuppressWarnings("unchecked")
	public static <T extends CompoundDataset> T compoundZeros(int itemSize, Class<T> clazz, int... shape) {
		if (CompoundByteDataset.class.isAssignableFrom(clazz)) {
			return (T) new CompoundByteDataset(itemSize, shape);
		} else if (RGBDataset.class.isAssignableFrom(clazz)) {
			if (itemSize != 3) {
				throw new IllegalArgumentException("Number of elements not compatible with RGB type");
			}
			return (T) new RGBDataset(shape);
		} else if (CompoundShortDataset.class.isAssignableFrom(clazz)) {
			return (T) new CompoundShortDataset(itemSize, shape);
		} else if (CompoundIntegerDataset.class.isAssignableFrom(clazz)) {
			return (T) new CompoundIntegerDataset(itemSize, shape);
		} else if (CompoundLongDataset.class.isAssignableFrom(clazz)) {
			return (T) new CompoundLongDataset(itemSize, shape);
		} else if (ComplexFloatDataset.class.isAssignableFrom(clazz)) {
			if (itemSize != 2) {
				throw new IllegalArgumentException("Number of elements not compatible with complex type");
			}
			return (T) new ComplexFloatDataset(shape);
		} else if (CompoundFloatDataset.class.isAssignableFrom(clazz)) {
			return (T) new CompoundFloatDataset(itemSize, shape);
		} else if (ComplexDoubleDataset.class.isAssignableFrom(clazz)) {
			if (itemSize != 2) {
				throw new IllegalArgumentException("Number of elements not compatible with complex type");
			}
			return (T) new ComplexDoubleDataset(shape);
		} else if (CompoundDoubleDataset.class.isAssignableFrom(clazz)) {
			return (T) new CompoundDoubleDataset(itemSize, shape);
		}
		throw new IllegalArgumentException("Class not a known compound interface");
	}

	/**
	 * @param shape
	 * @return a new double dataset of given shape, filled with ones
	 */
	public static DoubleDataset ones(final int... shape) {
		return ones(DoubleDataset.class, shape);
	}

	/**
	 * @param dataset
	 * @return a new dataset of same shape and class as input dataset, filled with ones
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Dataset> T ones(final T dataset) {
		return (T) ones(dataset, dataset.getClass());
	}

	/**
	 * @param clazz dataset class
	 * @param shape
	 * @return a new dataset of given shape and class, filled with ones
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Dataset> T ones(Class<T> clazz, int... shape) {
		if (BooleanDataset.class.isAssignableFrom(clazz)) {
			return (T) BooleanDataset.ones(shape);
		} else if (ByteDataset.class.isAssignableFrom(clazz)) {
			return (T) ByteDataset.ones(shape);
		} else if (ShortDataset.class.isAssignableFrom(clazz)) {
			return (T) ShortDataset.ones(shape);
		} else if (IntegerDataset.class.isAssignableFrom(clazz)) {
			return (T) IntegerDataset.ones(shape);
		} else if (LongDataset.class.isAssignableFrom(clazz)) {
			return (T) LongDataset.ones(shape);
		} else if (FloatDataset.class.isAssignableFrom(clazz)) {
			return (T) FloatDataset.ones(shape);
		} else if (DoubleDataset.class.isAssignableFrom(clazz)) {
			return (T) DoubleDataset.ones(shape);
		} else if (RGBDataset.class.isAssignableFrom(clazz)) {
			return (T) new RGBDataset(shape).fill(1);
		} else if (ComplexFloatDataset.class.isAssignableFrom(clazz)) {
			return (T) ComplexFloatDataset.ones(shape);
		} else if (ComplexDoubleDataset.class.isAssignableFrom(clazz)) {
			return (T) ComplexDoubleDataset.ones(shape);
		} else if (StringDataset.class.isAssignableFrom(clazz)) {
			return (T) StringDataset.ones(shape);
		} else if (DateDataset.class.isAssignableFrom(clazz)) {
			return (T) DateDatasetImpl.ones(shape);
		} else if (ObjectDataset.class.isAssignableFrom(clazz)) {
			return (T) ObjectDataset.ones(shape);
		}
		throw new IllegalArgumentException("Interface not known or unsupported");
	}

	/**
	 * @param itemSize
	 * @param clazz dataset class
	 * @param shape
	 * @return a new dataset of given item size, shape and class, filled with ones
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Dataset> T ones(int itemSize, Class<T> clazz, int... shape) {
		if (InterfaceUtils.isElemental(clazz)) {
			return ones(clazz, shape);
		}

		if (CompoundByteDataset.class.isAssignableFrom(clazz)) {
			return (T) CompoundByteDataset.ones(itemSize, shape);
		} else if (RGBDataset.class.isAssignableFrom(clazz)) {
			if (itemSize != 3) {
				throw new IllegalArgumentException("Number of elements not compatible with RGB type");
			}
			return (T) new RGBDataset(shape).fill(1);
		} else if (CompoundShortDataset.class.isAssignableFrom(clazz)) {
			return (T) CompoundShortDataset.ones(itemSize, shape);
		} else if (CompoundIntegerDataset.class.isAssignableFrom(clazz)) {
			return (T) CompoundIntegerDataset.ones(itemSize, shape);
		} else if (CompoundLongDataset.class.isAssignableFrom(clazz)) {
			return (T) CompoundLongDataset.ones(itemSize, shape);
		} else if (CompoundFloatDataset.class.isAssignableFrom(clazz)) {
			return (T) CompoundFloatDataset.ones(itemSize, shape);
		} else if (CompoundDoubleDataset.class.isAssignableFrom(clazz)) {
			return (T) CompoundDoubleDataset.ones(itemSize, shape);
		}
		throw new IllegalArgumentException("Class not a known compound interface");
	}

	/**
	 * @param dataset
	 * @param clazz dataset class
	 * @return a new dataset of given class with same shape as input dataset, filled with ones
	 */
	public static <T extends Dataset> T ones(Dataset dataset, Class<T> clazz) {
		return (T) ones(dataset.getElementsPerItem(), clazz, dataset.getShapeRef());
	}
}
