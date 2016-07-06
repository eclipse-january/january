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

package org.eclipse.january.dataset;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class DatasetFactory {

	/**
	 * Create dataset with items ranging from 0 to given stop in steps of 1
	 * @param stop
	 * @return a new double dataset of given shape and type, filled with values determined by parameters
	 */
	public static DoubleDataset createRange(final double stop) {
		return createRange(DoubleDataset.class, 0, stop, 1);
	}


	/**
	 * Create dataset with items ranging from 0 to given stop in steps of 1
	 * @param stop
	 * @param dtype
	 * @return a new dataset of given shape and type, filled with values determined by parameters
	 */
	public static Dataset createRange(final double stop, final int dtype) {
		return createRange(0, stop, 1, dtype);
	}

	/**
	 * Create dataset with items ranging from given start to given stop in given steps
	 * @param start
	 * @param stop
	 * @param step spacing between items
	 * @param dtype
	 * @return a new 1D dataset of given type, filled with values determined by parameters
	 */
	public static Dataset createRange(final double start, final double stop, final double step, final int dtype) {
		if ((step > 0) != (start <= stop)) {
			throw new IllegalArgumentException("Invalid parameters: start and stop must be in correct order for step");
		}

		switch (dtype) {
		case Dataset.BOOL:
			break;
		case Dataset.INT8:
			return ByteDataset.createRange(start, stop, step);
		case Dataset.INT16:
			return ShortDataset.createRange(start, stop, step);
		case Dataset.INT32:
			return IntegerDataset.createRange(start, stop, step);
		case Dataset.INT64:
			return LongDataset.createRange(start, stop, step);
		case Dataset.FLOAT32:
			return FloatDataset.createRange(start, stop, step);
		case Dataset.FLOAT64:
			return DoubleDataset.createRange(start, stop, step);
		case Dataset.COMPLEX64:
			return ComplexFloatDataset.createRange(start, stop, step);
		case Dataset.COMPLEX128:
			return ComplexDoubleDataset.createRange(start, stop, step);
		}
		throw new IllegalArgumentException("dtype not known");
	}

	/**
	 * Create compound dataset with items of given size ranging from 0 to given stop in steps of 1
	 * @param itemSize
	 * @param stop
	 * @param dtype
	 * @return a new dataset of given shape and type, filled with values determined by parameters
	 */
	public static CompoundDataset createRange(final int itemSize, final double stop, final int dtype) {
		return createRange(itemSize, 0, stop, 1, dtype);
	}

	/**
	 * Create compound dataset with items of given size ranging from given start to given stop in given steps
	 * @param itemSize
	 * @param start
	 * @param stop
	 * @param step spacing between items
	 * @param dtype
	 * @return a new 1D dataset of given type, filled with values determined by parameters
	 */
	public static CompoundDataset createRange(final int itemSize, final double start, final double stop, final double step, final int dtype) {
		if (itemSize < 1) {
			throw new IllegalArgumentException("Item size must be greater or equal to 1");
		}
		if ((step > 0) != (start <= stop)) {
			throw new IllegalArgumentException("Invalid parameters: start and stop must be in correct order for step");
		}

		switch (dtype) {
		case Dataset.BOOL:
			break;
		case Dataset.ARRAYINT8:
		case Dataset.INT8:
			return CompoundIntegerDataset.createRange(itemSize, start, stop, step);
		case Dataset.ARRAYINT16:
		case Dataset.INT16:
			return CompoundShortDataset.createRange(itemSize, start, stop, step);
		case Dataset.ARRAYINT32:
		case Dataset.INT32:
			return CompoundIntegerDataset.createRange(itemSize, start, stop, step);
		case Dataset.ARRAYINT64:
		case Dataset.INT64:
			return CompoundLongDataset.createRange(itemSize, start, stop, step);
		case Dataset.ARRAYFLOAT32:
		case Dataset.FLOAT32:
			return CompoundFloatDataset.createRange(itemSize, start, stop, step);
		case Dataset.ARRAYFLOAT64:
		case Dataset.FLOAT64:
			return CompoundDoubleDataset.createRange(itemSize, start, stop, step);
		case Dataset.COMPLEX64:
			if (itemSize != 2) {
				throw new IllegalArgumentException("Item size must be equal to 2");
			}
			return ComplexFloatDataset.createRange(start, stop, step);
		case Dataset.COMPLEX128:
			if (itemSize != 2) {
				throw new IllegalArgumentException("Item size must be equal to 2");
			}
			return ComplexFloatDataset.createRange(start, stop, step);
		}
		throw new IllegalArgumentException("dtype not known");
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
		if (obj instanceof BigInteger) {
			obj = ((BigInteger) obj).longValue();
		}

		final int dtype = DTypeUtils.getDTypeFromObject(obj);
		return createFromObject(dtype, obj, shape);
	}

	/**
	 * Create a dataset from object (automatically detect dataset type)
	 * @param isUnsigned
	 *            if true, interpret integer values as unsigned by increasing element bit width
	 * @param obj
	 *            can be a Java list, array or Number
	 * @return dataset
	 */
	public static Dataset createFromObject(boolean isUnsigned, final Object obj) {
		Dataset a = createFromObject(obj);
		if (isUnsigned) {
			a = DatasetUtils.makeUnsigned(a);
		}
		return a;
	}

	/**
	 * Create a dataset from object
	 * @param dtype
	 * @param obj
	 *            can be a Java list, array or Number
	 * @return dataset
	 * @throws IllegalArgumentException if dataset type is not known
	 */
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
	 */
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
	 */
	public static Dataset createFromObject(final int itemSize, final int dtype, final Object obj, final int... shape) {
		Dataset d = null;

		if (obj instanceof IDataset) {
			d = itemSize == 1 ? DatasetUtils.cast((IDataset) obj, dtype) :
				DatasetUtils.cast((IDataset) obj, false, dtype, itemSize);
		} else {
			// primitive arrays
			Class<? extends Object> ca = obj == null ? null : obj.getClass().getComponentType();
			if (ca != null && (ca.isPrimitive() || ca.equals(String.class))) {
				switch (dtype) {
				case Dataset.COMPLEX64:
					return new ComplexFloatDataset(DTypeUtils.toFloatArray(obj, DTypeUtils.getLength(obj)), shape);
				case Dataset.COMPLEX128:
					return new ComplexDoubleDataset(DTypeUtils.toDoubleArray(obj, DTypeUtils.getLength(obj)), shape);
				default:
					d = createFromPrimitiveArray(DTypeUtils.getDTypeFromClass(ca), obj);
					if (!DTypeUtils.isDTypeElemental(dtype)) {
						if (dtype == Dataset.RGB) {
							d = DatasetUtils.createCompoundDataset(d, 3);
						} else {
							d = itemSize == 1 ? DatasetUtils.createCompoundDatasetFromLastAxis(d, true) :
								DatasetUtils.createCompoundDataset(d, itemSize);
						}
					}
					d = DatasetUtils.cast(d, dtype);
				}
			} else {
				switch (dtype) {
				case Dataset.BOOL:
					d = BooleanDataset.createFromObject(obj);
					break;
				case Dataset.INT8:
					d = ByteDataset.createFromObject(obj);
					break;
				case Dataset.INT16:
					d = ShortDataset.createFromObject(obj);
					break;
				case Dataset.INT32:
					d = IntegerDataset.createFromObject(obj);
					break;
				case Dataset.INT64:
					d = LongDataset.createFromObject(obj);
					break;
				case Dataset.ARRAYINT8:
					d = CompoundByteDataset.createFromObject(itemSize, obj);
					break;
				case Dataset.ARRAYINT16:
					d = CompoundShortDataset.createFromObject(itemSize, obj);
					break;
				case Dataset.ARRAYINT32:
					d = CompoundIntegerDataset.createFromObject(itemSize, obj);
					break;
				case Dataset.ARRAYINT64:
					d = CompoundLongDataset.createFromObject(itemSize, obj);
					break;
				case Dataset.FLOAT32:
					d = FloatDataset.createFromObject(obj);
					break;
				case Dataset.FLOAT64:
					d = DoubleDataset.createFromObject(obj);
					break;
				case Dataset.ARRAYFLOAT32:
					d = CompoundFloatDataset.createFromObject(itemSize, obj);
					break;
				case Dataset.ARRAYFLOAT64:
					d = CompoundDoubleDataset.createFromObject(itemSize, obj);
					break;
				case Dataset.COMPLEX64:
					d = ComplexFloatDataset.createFromObject(obj);
					break;
				case Dataset.COMPLEX128:
					d = ComplexDoubleDataset.createFromObject(obj);
					break;
				case Dataset.DATE:
					d = DateDatasetImpl.createFromObject(obj);
					break;
				case Dataset.STRING:
					d = StringDataset.createFromObject(obj);
					break;
				case Dataset.OBJECT:
					d = ObjectDataset.createFromObject(obj);
					break;
				case Dataset.RGB:
					d = RGBDataset.createFromObject(obj);
					break;
				default:
					throw new IllegalArgumentException("Dataset type is not known");
				}
			}
		}

		if (shape != null && !(shape.length == 0 && d.getSize() > 1)) { // allow zero-rank datasets
			d.setShape(shape);
		}
		return d;
	}

	private static Dataset createFromPrimitiveArray(final int dtype, final Object array) {
		switch (dtype) {
		case Dataset.BOOL:
			return new BooleanDataset((boolean []) array);
		case Dataset.INT8:
			return new ByteDataset((byte []) array);
		case Dataset.INT16:
			return new ShortDataset((short []) array);
		case Dataset.INT32:
			return new IntegerDataset((int []) array, null);
		case Dataset.INT64:
			return new LongDataset((long []) array);
		case Dataset.FLOAT32:
			return new FloatDataset((float []) array);
		case Dataset.FLOAT64:
			return new DoubleDataset((double []) array);
		case Dataset.STRING:
			return new StringDataset((String []) array);
		case Dataset.DATE:
			return new DateDatasetImpl((Date []) array);
		default:
			return null;
		}
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
			return zeros(new int[objectList.size()], Dataset.OBJECT);
		}

		Class<? extends Object> clazz = obj.getClass();
		if (!DTypeUtils.isClassSupportedAsElement(clazz)) {
			throw new IllegalArgumentException("Class of list element not supported");
		}

		int dtype = DTypeUtils.getDTypeFromClass(clazz);
		return createFromList(dtype, objectList);
	}

	/**
	 * Create dataset of given type from list
	 *
	 * @param dtype
	 * @param objectList
	 * @return dataset filled with values from list
	 */
	public static Dataset createFromList(final int dtype, List<?> objectList) {
		int len = objectList.size();
		Dataset result = zeros(new int[] { len }, dtype);

		for (int i = 0; i < len; i++) {
			result.setObjectAbs(i, objectList.get(i));
		}
		return result;
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
	 * Create compound dataset of given type from given parts
	 *
	 * @param dtype
	 * @param objects
	 * @return compound dataset
	 */
	public static CompoundDataset createCompoundDataset(final int dtype, Object... objects) {
		Dataset[] datasets = new Dataset[objects.length];
		for (int i = 0; i < objects.length; i++) {
			datasets[i] = createFromObject(objects[i]);
		}
		return DatasetUtils.createCompoundDataset(dtype, datasets);
	}

	/**
	 * Create complex dataset of given type from real and imaginary parts
	 *
	 * @param dtype
	 * @param real
	 * @param imag
	 * @return complex dataset
	 */
	public static CompoundDataset createComplexDataset(final int dtype, Object real, Object imag) {
		switch (dtype) {
		case Dataset.COMPLEX64:
			return new ComplexFloatDataset(createFromObject(real), createFromObject(imag));
		case Dataset.COMPLEX128:
			return new ComplexDoubleDataset(createFromObject(real), createFromObject(imag));
		default:
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
	 * @param shape
	 * @param dtype
	 * @return a new dataset of given shape and type, filled with zeros
	 */
	public static Dataset zeros(final int[] shape, final int dtype) {
		switch (dtype) {
		case Dataset.BOOL:
			return new BooleanDataset(shape);
		case Dataset.INT8:
		case Dataset.ARRAYINT8:
			return new ByteDataset(shape);
		case Dataset.INT16:
		case Dataset.ARRAYINT16:
			return new ShortDataset(shape);
		case Dataset.RGB:
			return new RGBDataset(shape);
		case Dataset.INT32:
		case Dataset.ARRAYINT32:
			return new IntegerDataset(shape);
		case Dataset.INT64:
		case Dataset.ARRAYINT64:
			return new LongDataset(shape);
		case Dataset.FLOAT32:
		case Dataset.ARRAYFLOAT32:
			return new FloatDataset(shape);
		case Dataset.FLOAT64:
		case Dataset.ARRAYFLOAT64:
			return new DoubleDataset(shape);
		case Dataset.COMPLEX64:
			return new ComplexFloatDataset(shape);
		case Dataset.COMPLEX128:
			return new ComplexDoubleDataset(shape);
		case Dataset.STRING:
			return new StringDataset(shape);
		case Dataset.DATE:
			return new DateDatasetImpl(shape);
		case Dataset.OBJECT:
			return new ObjectDataset(shape);
		}
		throw new IllegalArgumentException("dtype not known or unsupported");
	}

	/**
	 * @param itemSize
	 *            if equal to 1, then non-compound dataset is returned
	 * @param shape
	 * @param dtype
	 * @return a new dataset of given item size, shape and type, filled with zeros
	 */
	public static Dataset zeros(final int itemSize, final int[] shape, final int dtype) {
		if (itemSize == 1) {
			return zeros(shape, dtype);
		}
		switch (dtype) {
		case Dataset.INT8:
		case Dataset.ARRAYINT8:
			return new CompoundByteDataset(itemSize, shape);
		case Dataset.INT16:
		case Dataset.ARRAYINT16:
			return new CompoundShortDataset(itemSize, shape);
		case Dataset.RGB:
			if (itemSize != 3) {
				throw new IllegalArgumentException("Number of elements not compatible with RGB type");
			}
			return new RGBDataset(shape);
		case Dataset.INT32:
		case Dataset.ARRAYINT32:
			return new CompoundIntegerDataset(itemSize, shape);
		case Dataset.INT64:
		case Dataset.ARRAYINT64:
			return new CompoundLongDataset(itemSize, shape);
		case Dataset.FLOAT32:
		case Dataset.ARRAYFLOAT32:
			return new CompoundFloatDataset(itemSize, shape);
		case Dataset.FLOAT64:
		case Dataset.ARRAYFLOAT64:
			return new CompoundDoubleDataset(itemSize, shape);
		case Dataset.COMPLEX64:
			if (itemSize != 2) {
				throw new IllegalArgumentException("Number of elements not compatible with complex type");
			}
			return new ComplexFloatDataset(shape);
		case Dataset.COMPLEX128:
			if (itemSize != 2) {
				throw new IllegalArgumentException("Number of elements not compatible with complex type");
			}
			return new ComplexDoubleDataset(shape);
		}
		throw new IllegalArgumentException("dtype not a known compound type");
	}

	/**
	 * @param dataset
	 * @return a new dataset of same shape and type as input dataset, filled with zeros
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Dataset> T zeros(final T dataset) {
		return (T) zeros(dataset, dataset.getDType());
	}

	/**
	 * Create a new dataset of same shape as input dataset, filled with zeros. If dtype is not
	 * explicitly compound then an elemental dataset is created 
	 * @param dataset
	 * @param dtype
	 * @return a new dataset
	 */
	public static Dataset zeros(final Dataset dataset, final int dtype) {
		final int[] shape = dataset.getShapeRef();
		final int isize = DTypeUtils.isDTypeElemental(dtype) ? 1 :dataset.getElementsPerItem();

		return zeros(isize, shape, dtype);
	}

	/**
	 * @param dataset
	 * @return a new dataset of same shape and type as input dataset, filled with ones
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Dataset> T ones(final T dataset) {
		return (T) ones(dataset, dataset.getDType());
	}

	/**
	 * Create a new dataset of same shape as input dataset, filled with ones. If dtype is not
	 * explicitly compound then an elemental dataset is created
	 * @param dataset
	 * @param dtype
	 * @return a new dataset
	 */
	public static Dataset ones(final Dataset dataset, final int dtype) {
		final int[] shape = dataset.getShapeRef();
		final int isize = DTypeUtils.isDTypeElemental(dtype) ? 1 :dataset.getElementsPerItem();

		return ones(isize, shape, dtype);
	}

	/**
	 * @param shape
	 * @return a new double dataset of given shape, filled with ones
	 */
	public static DoubleDataset ones(final int... shape) {
		return ones(DoubleDataset.class, shape);
	}

	/**
	 * @param shape
	 * @param dtype
	 * @return a new dataset of given shape and type, filled with ones
	 */
	public static Dataset ones(final int[] shape, final int dtype) {
		switch (dtype) {
		case Dataset.BOOL:
			return BooleanDataset.ones(shape);
		case Dataset.INT8:
			return ByteDataset.ones(shape);
		case Dataset.INT16:
			return ShortDataset.ones(shape);
		case Dataset.RGB:
			return new RGBDataset(shape).fill(1);
		case Dataset.INT32:
			return IntegerDataset.ones(shape);
		case Dataset.INT64:
			return LongDataset.ones(shape);
		case Dataset.FLOAT32:
			return FloatDataset.ones(shape);
		case Dataset.FLOAT64:
			return DoubleDataset.ones(shape);
		case Dataset.COMPLEX64:
			return ComplexFloatDataset.ones(shape);
		case Dataset.COMPLEX128:
			return ComplexDoubleDataset.ones(shape);
		}
		throw new IllegalArgumentException("dtype not known");
	}

	/**
	 * @param itemSize
	 *            if equal to 1, then non-compound dataset is returned
	 * @param shape
	 * @param dtype
	 * @return a new dataset of given item size, shape and type, filled with ones
	 */
	public static Dataset ones(final int itemSize, final int[] shape, final int dtype) {
		if (itemSize == 1) {
			return ones(shape, dtype);
		}
		switch (dtype) {
		case Dataset.INT8:
		case Dataset.ARRAYINT8:
			return CompoundByteDataset.ones(itemSize, shape);
		case Dataset.INT16:
		case Dataset.ARRAYINT16:
			return CompoundShortDataset.ones(itemSize, shape);
		case Dataset.RGB:
			if (itemSize != 3) {
				throw new IllegalArgumentException("Number of elements not compatible with RGB type");
			}
			return new RGBDataset(shape).fill(1);
		case Dataset.INT32:
		case Dataset.ARRAYINT32:
			return CompoundIntegerDataset.ones(itemSize, shape);
		case Dataset.INT64:
		case Dataset.ARRAYINT64:
			return CompoundLongDataset.ones(itemSize, shape);
		case Dataset.FLOAT32:
		case Dataset.ARRAYFLOAT32:
			return CompoundFloatDataset.ones(itemSize, shape);
		case Dataset.FLOAT64:
		case Dataset.ARRAYFLOAT64:
			return CompoundDoubleDataset.ones(itemSize, shape);
		case Dataset.COMPLEX64:
			if (itemSize != 2) {
				throw new IllegalArgumentException("Number of elements not compatible with complex type");
			}
			return ComplexFloatDataset.ones(shape);
		case Dataset.COMPLEX128:
			if (itemSize != 2) {
				throw new IllegalArgumentException("Number of elements not compatible with complex type");
			}
			return ComplexDoubleDataset.ones(shape);
		}
		throw new IllegalArgumentException("dtype not a known compound type");
	}

	/**
	 * Create a 1D dataset of linearly spaced values in closed interval
	 * 
	 * @param start
	 * @param stop
	 * @param length number of points
	 * @param dtype
	 * @return dataset with linearly spaced values
	 */
	public static Dataset createLinearSpace(final double start, final double stop, final int length, final int dtype) {
		if (length < 1) {
			throw new IllegalArgumentException("Length is less than one");
		} else if (length == 1) {
			return createFromObject(dtype, start);
		} else {
			Dataset ds = zeros(new int[] {length}, dtype);
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
	 * @param start
	 * @param stop
	 * @param length number of points
	 * @param base
	 * @param dtype
	 * @return dataset with logarithmically spaced values
	 */
	public static Dataset createLogSpace(final double start, final double stop, final int length, final double base, final int dtype) {
		if (length < 1) {
			throw new IllegalArgumentException("Length is less than one");
		} else if (length == 1) {
			return createFromObject(dtype, Math.pow(base, start));
		} else {
			Dataset ds = zeros(new int[] {length}, dtype);
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
	 * Create dataset with items ranging from 0 to given stop in steps of 1
	 * @param clazz
	 * @param stop
	 * @return a new dataset of given shape and type, filled with values determined by parameters
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Dataset> T createRange(Class<T> clazz, final double stop) {
		return (T) createRange(0, stop, 1, DTypeUtils.getDType(clazz));
	}

	/**
	 * Create dataset with items ranging from given start to given stop in given steps
	 * @param clazz dataset class
	 * @param start
	 * @param stop
	 * @param step spacing between items
	 * @return a new 1D dataset of given class, filled with values determined by parameters
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Dataset> T createRange(Class<T> clazz, final double start, final double stop, final double step) {
		return (T) createRange(start, stop, step, DTypeUtils.getDType(clazz));
	}

	/**
	 * Create a dataset from object
	 * @param clazz dataset class
	 * @param obj
	 *            can be a Java list, array or Number
	 * @param shape can be null
	 * @return dataset
	 * @throws IllegalArgumentException if dataset type is not known
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Dataset> T createFromObject(Class<T> clazz, Object obj, int... shape) {
		return (T) createFromObject(1, DTypeUtils.getDType(clazz), obj, shape);
	}

	/**
	 * Create a compound dataset from object
	 * @param itemSize
	 * @param clazz dataset class
	 * @param obj
	 *            can be a Java list, array or Number
	 * @param shape can be null
	 * @return dataset
	 * @throws IllegalArgumentException if dataset type is not known
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Dataset> T createFromObject(final int itemSize, Class<T> clazz, Object obj, int... shape) {
		return (T) createFromObject(itemSize, DTypeUtils.getDType(clazz), obj, shape);
	}

	/**
	 * Create dataset of given class from list
	 *
	 * @param clazz dataset class
	 * @param objectList
	 * @return dataset filled with values from list
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Dataset> T createFromList(Class<T> clazz, List<?> objectList) {
		return (T) createFromList(DTypeUtils.getDType(clazz), objectList);
	}

	/**
	 * Create compound dataset of given class from given parts
	 *
	 * @param clazz
	 * @param objects
	 * @return compound dataset
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Dataset> T createCompoundDataset(Class<T> clazz, Object... objects) {
		return (T) createCompoundDataset(DTypeUtils.getDType(clazz), objects);
	}

	/**
	 * Create complex dataset of given class from real and imaginary parts
	 *
	 * @param clazz dataset class
	 * @param real
	 * @param imag
	 * @return complex dataset
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Dataset> T createComplexDataset(Class<T> clazz, Object real, Object imag) {
		return (T) createComplexDataset(DTypeUtils.getDType(clazz), real, imag);
	}

	/**
	 * @param clazz dataset class
	 * @param shape
	 * @return a new dataset of given shape and class, filled with zeros
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Dataset> T zeros(Class<T> clazz, int... shape) {
		return (T) zeros(shape, DTypeUtils.getDType(clazz));
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
		return (T) zeros(itemSize, shape, DTypeUtils.getDType(clazz));
	}

	/**
	 * @param dataset
	 * @param clazz dataset class
	 * @return a new dataset of given class with same shape as input dataset, filled with zeros
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Dataset> T zeros(Dataset dataset, Class<T> clazz) {
		return (T) zeros(dataset, DTypeUtils.getDType(clazz));
	}

	/**
	 * @param clazz dataset class
	 * @param shape
	 * @return a new dataset of given shape and class, filled with ones
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Dataset> T ones(Class<T> clazz, int... shape) {
		return (T) ones(shape, DTypeUtils.getDType(clazz));
	}

	/**
	 * @param itemSize
	 *            if equal to 1, then non-compound dataset is returned
	 * @param clazz dataset class
	 * @param shape
	 * @return a new dataset of given item size, shape and class, filled with ones
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Dataset> T ones(int itemSize, Class<T> clazz, int... shape) {
		return (T) ones(itemSize, shape, DTypeUtils.getDType(clazz));
	}

	/**
	 * @param dataset
	 * @param clazz dataset class
	 * @return a new dataset of given class with same shape as input dataset, filled with ones
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Dataset> T ones(Dataset dataset, Class<T> clazz) {
		return (T) ones(dataset, DTypeUtils.getDType(clazz));
	}

	/**
	 * Create a 1D dataset of linearly spaced values in closed interval
	 * 
	 * @param clazz dataset class
	 * @param start
	 * @param stop
	 * @param length number of points
	 * @return dataset with linearly spaced values
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Dataset> T createLinearSpace(Class<T> clazz, final double start, final double stop, final int length) {
		return (T) createLinearSpace(start, stop, length, DTypeUtils.getDType(clazz));
	}

	/**
	 * Create a 1D dataset of logarithmically spaced values in closed interval. The base value is used to
	 * determine the factor between values: factor = base ** step, where step is the interval between linearly
	 * spaced sequence of points
	 * 
	 * @param start
	 * @param stop
	 * @param length number of points
	 * @param base
	 * @return dataset with logarithmically spaced values
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Dataset> T createLogSpace(Class<T> clazz, final double start, final double stop, final int length, final double base) {
		return (T) createLogSpace(start, stop, length, base, DTypeUtils.getDType(clazz));
	}
}
