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

package org.eclipse.dawnsci.analysis.dataset.impl;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.eclipse.dawnsci.analysis.api.dataset.IDataset;
import org.eclipse.dawnsci.analysis.api.dataset.Slice;
import org.eclipse.dawnsci.analysis.api.dataset.SliceND;
import org.eclipse.dawnsci.analysis.api.monitor.IMonitor;

/**
 * Generic container class for data that is compound in nature
 * 
 * Each subclass has an array of compound types, items of this array are composed of primitive types
 * 
 * Data items can be Complex, Vector, etc
 * 
 */
public abstract class AbstractCompoundDataset extends AbstractDataset implements CompoundDataset {
	// pin UID to base class
	private static final long serialVersionUID = Dataset.serialVersionUID;

	protected int isize; // number of elements per item

	@Override
	public int getElementsPerItem() {
		return isize;
	}

	@Override
	protected int get1DIndex(final int i) {
		int n = super.get1DIndex(i);
		return stride == null ? isize * n : n;
	}

	@Override
	protected int get1DIndex(final int i, final int j) {
		int n = super.get1DIndex(i, j);
		return stride == null ? isize * n : n;
	}

	@Override
	protected int get1DIndexFromShape(final int... n) {
		return isize * super.get1DIndexFromShape(n);
	}

	@Override
	public Dataset getUniqueItems() {
		throw new UnsupportedOperationException("Cannot sort compound datasets");
	}

	@Override
	public IndexIterator getIterator(final boolean withPosition) {
		if (stride != null)
			return new StrideIterator(isize, shape, stride, offset);
		return withPosition ? getSliceIterator(null, null, null) :
			new ContiguousIterator(size, isize);
	}

	/**
	 * Get an iterator that picks out the chosen element from all items
	 * @param element
	 * @return an iterator
	 */
	public IndexIterator getIterator(int element) {
		if (element < 0)
			element += isize;
		if (element < 0 || element > isize) {
			logger.error("Invalid choice of element: {}/{}", element, isize);
			throw new IllegalArgumentException("Invalid choice of element: " + element + "/" + isize);
		}
		final IndexIterator it = stride != null ?  new StrideIterator(isize, shape, stride, offset) : new ContiguousIterator(size, isize);

		it.index += element;
		return it;
	}

	@Override
	public IndexIterator getSliceIterator(SliceND slice) {
		if (stride != null)
			return new StrideIterator(isize, shape, stride, offset, slice);

		return new SliceIterator(shape, size, isize, slice);
	}

	/**
	 * Constructor required for serialisation.
	 */
	public AbstractCompoundDataset() {
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}
		CompoundDataset other = (CompoundDataset) obj;
		return isize == other.getElementsPerItem();
	}

	@Override
	public int hashCode() {
		return getHash();
	}

	@Override
	public CompoundDataset cast(boolean repeat, int dtype, int isize) {
		return (CompoundDataset) super.cast(repeat, dtype, isize);
	}

	@Override
	public CompoundDataset cast(int dtype) {
		return (CompoundDataset) super.cast(dtype);
	}

	@Override
	abstract public AbstractCompoundDataset clone();

	@Override
	public CompoundDataset flatten() {
		return (CompoundDataset) super.flatten();
	}

	@Override
	public CompoundDataset getBy1DIndex(IntegerDataset index) {
		return (CompoundDataset) super.getBy1DIndex(index);
	}

	@Override
	public CompoundDataset getByBoolean(Dataset selection) {
		return (CompoundDataset) super.getByBoolean(selection);
	}

	@Override
	public CompoundDataset getByIndexes(Object... indexes) {
		return (CompoundDataset) super.getByIndexes(indexes);
	}

	@Override
	public CompoundDataset getSlice(IMonitor mon, int[] start, int[] stop, int[] step) {
		return (CompoundDataset) super.getSlice(mon, start, stop, step);
	}

	@Override
	public CompoundDataset getSlice(IMonitor mon, Slice... slice) {
		return (CompoundDataset) super.getSlice(mon, slice);
	}

	@Override
	public CompoundDataset getSlice(IMonitor mon, SliceND slice) {
		return (CompoundDataset) super.getSlice(mon, slice);
	}

	@Override
	public CompoundDataset getSlice(int[] start, int[] stop, int[] step) {
		return (CompoundDataset) super.getSlice(start, stop, step);
	}

	@Override
	public CompoundDataset getSlice(Slice... slice) {
		return (CompoundDataset) super.getSlice(slice);
	}

	@Override
	public CompoundDataset getSlice(SliceND slice) {
		return (CompoundDataset) super.getSlice(slice);
	}

	@Override
	abstract public AbstractCompoundDataset getSlice(SliceIterator iterator);

	@Override
	public CompoundDataset getSliceView(int[] start, int[] stop, int[] step) {
		return (CompoundDataset) super.getSliceView(start, stop, step);
	}

	@Override
	public CompoundDataset getSliceView(Slice... slice) {
		return (CompoundDataset) super.getSliceView(slice);
	}

	@Override
	public CompoundDataset getSliceView(SliceND slice) {
		return (CompoundDataset) super.getSliceView(slice);
	}

	@Override
	public CompoundDataset getTransposedView(int... axes) {
		return (CompoundDataset) super.getTransposedView(axes);
	}

	@Override
	abstract public AbstractCompoundDataset getView();

	@Override
	public CompoundDataset ifloorDivide(Object o) {
		return (CompoundDataset) super.ifloorDivide(o);
	}

	@Override
	public CompoundDataset mean(boolean ignoreNaNs, int axis) {
		return (CompoundDataset) super.mean(ignoreNaNs, axis);
	}

	@Override
	public CompoundDataset mean(int axis) {
		return (CompoundDataset) super.mean(axis);
	}

	@Override
	public CompoundDataset peakToPeak(int axis) {
		return (CompoundDataset) super.peakToPeak(axis);
	}

	@Override
	public CompoundDataset product(int axis) {
		return (CompoundDataset) super.product(axis);
	}

	@Override
	public CompoundDataset reshape(int... shape) {
		return (CompoundDataset) super.reshape(shape);
	}

	@Override
	public CompoundDataset rootMeanSquare(int axis) {
		return (CompoundDataset) super.rootMeanSquare(axis);
	}

	@Override
	public CompoundDataset setSlice(Object obj, int[] start, int[] stop, int[] step) {
		return (CompoundDataset) super.setSlice(obj, start, stop, step);
	}

	@Override
	public CompoundDataset setSlice(Object object, Slice... slice) {
		return (CompoundDataset) super.setSlice(object, slice);
	}

	@Override
	public CompoundDataset sort(Integer axis) {
		throw new UnsupportedOperationException("Cannot sort dataset");
	}

	@Override
	public CompoundDataset squeezeEnds() {
		return (CompoundDataset) super.squeezeEnds();
	}

	@Override
	public CompoundDataset squeeze() {
		return (CompoundDataset) super.squeeze();
	}

	@Override
	public CompoundDataset squeeze(boolean onlyFromEnd) {
		return (CompoundDataset) super.squeeze(onlyFromEnd);
	}

	@Override
	public CompoundDataset stdDeviation(int axis) {
		return (CompoundDataset) super.stdDeviation(axis);
	}

	@Override
	public CompoundDataset sum(boolean ignoreNaNs, int axis) {
		return (CompoundDataset) super.sum(ignoreNaNs, axis);
	}

	@Override
	public CompoundDataset sum(int axis) {
		return (CompoundDataset) super.sum(axis);
	}

	@Override
	public CompoundDataset swapAxes(int axis1, int axis2) {
		return (CompoundDataset) super.swapAxes(axis1, axis2);
	}

	@Override
	public synchronized CompoundDataset synchronizedCopy() {
		return clone();
	}

	@Override
	public CompoundDataset transpose(int... axes) {
		return (CompoundDataset) super.transpose(axes);
	}

	@Override
	public CompoundDataset typedProduct(int dtype, int axis) {
		return (CompoundDataset) super.typedProduct(dtype, axis);
	}

	@Override
	public CompoundDataset typedSum(int dtype, int axis) {
		return (CompoundDataset) super.typedSum(dtype, axis);
	}

	@Override
	public CompoundDataset variance(int axis) {
		return (CompoundDataset) super.variance(axis);
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
			for (int i = 0; i < itemSize; i++)
				result[i] = val;
		} else if (b instanceof byte[]) {
			result = (byte[]) b;
			if (result.length < itemSize) {
				result = new byte[itemSize];
				int ilen = result.length;
				for (int i = 0; i < ilen; i++)
					result[i] = ((byte[]) b)[i];
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
			for (int i = 0; i < ilen; i++)
				result[i] = (byte) ((Number) Array.get(b, i)).longValue();
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

	abstract protected double getFirstValue(final int i);

	abstract protected double getFirstValue(final int i, final int j);

	abstract protected double getFirstValue(final int...pos);

	@Override
	public boolean getBoolean(final int i) {
		return getFirstValue(i) != 0;
	}

	@Override
	public boolean getBoolean(final int i, final int j) {
		return getFirstValue(i, j) != 0;
	}

	@Override
	public boolean getBoolean(final int... pos) {
		return getFirstValue(pos) != 0;
	}

	@Override
	public byte getByte(final int i) {
		return (byte) getFirstValue(i);
	}

	@Override
	public byte getByte(final int i, final int j) {
		return (byte) getFirstValue(i, j);
	}

	@Override
	public byte getByte(final int... pos) {
		return (byte) getFirstValue(pos);
	}

	@Override
	public short getShort(final int i) {
		return (short) getFirstValue(i);
	}

	@Override
	public short getShort(final int i, final int j) {
		return (short) getFirstValue(i, j);
	}

	@Override
	public short getShort(final int... pos) {
		return (short) getFirstValue(pos);
	}

	@Override
	public int getInt(final int i) {
		return (int) getFirstValue(i);
	}

	@Override
	public int getInt(final int i, final int j) {
		return (int) getFirstValue(i, j);
	}

	@Override
	public int getInt(final int... pos) {
		return (int) getFirstValue(pos);
	}

	@Override
	public long getLong(final int i) {
		return (long) getFirstValue(i);
	}

	@Override
	public long getLong(final int i, final int j) {
		return (long) getFirstValue(i, j);
	}

	@Override
	public long getLong(final int... pos) {
		return (long) getFirstValue(pos);
	}

	@Override
	public float getFloat(final int i) {
		return (float) getFirstValue(i);
	}

	@Override
	public float getFloat(final int i, final int j) {
		return (float) getFirstValue(i, j);
	}

	@Override
	public float getFloat(final int... pos) {
		return (float) getFirstValue(pos);
	}

	@Override
	public double getDouble(final int i) {
		return getFirstValue(i);
	}

	@Override
	public double getDouble(final int i, final int j) {
		return getFirstValue(i, j);
	}

	@Override
	public double getDouble(final int... pos) {
		return getFirstValue(pos);
	}

	@Override
	public void getDoubleArray(final double[] darray, final int i) {
		getDoubleArrayAbs(get1DIndex(i), darray);
	}

	@Override
	public void getDoubleArray(final double[] darray, final int i, final int j) {
		getDoubleArrayAbs(get1DIndex(i, j), darray);
	}

	@Override
	public void getDoubleArray(final double[] darray, final int... pos) {
		getDoubleArrayAbs(get1DIndex(pos), darray);
	}

	@Override
	protected Number fromDoubleToNumber(double x) {
		return null;
	}

	/**
	 * Calculate minimum and maximum for a dataset
	 */
	protected void calculateHash() {
		IndexIterator iter = getIterator();
		double hash = 0;
		while (iter.hasNext()) {
			for (int j = 0; j < isize; j++) {
				final double val = getElementDoubleAbs(iter.index + j);
				if (Double.isInfinite(val) || Double.isNaN(val)) {
					hash = (hash * 19) % Integer.MAX_VALUE;
				} else {
					hash = (hash * 19 + val) % Integer.MAX_VALUE;
				}
			}
		}

		int ihash = ((int) hash) * 19 + getDtype() * 17 + getElementsPerItem();
		setStoredValue(STORE_SHAPELESS_HASH, ihash);
	}

	private int getHash() {
		Object value = getStoredValue(STORE_HASH);
		if (value == null) {
			value = getStoredValue(STORE_SHAPELESS_HASH);
			if (value == null) {
				calculateHash();
				value = getStoredValue(STORE_SHAPELESS_HASH);
			}

			int ihash = (Integer) value;
			int rank = shape.length;
			for (int i = 0; i < rank; i++) {
				ihash = ihash * 17 + shape[i];
			}
			storedValues.put(STORE_HASH, ihash);
			return ihash;
		}

		return (Integer) value;
	}

	@Override
	protected void calculateSummaryStats(boolean ignoreNaNs, final boolean ignoreInfs, String name) {
		IndexIterator iter = getIterator();
		SummaryStatistics[] stats = new SummaryStatistics[isize];
		for (int i = 0; i < isize; i++)
			stats[i] = new SummaryStatistics();

		double[] vals = new double[isize];
		while (iter.hasNext()) {
			boolean okay = true;
			for (int i = 0; i < isize; i++) {
				final double val = getElementDoubleAbs(iter.index + i);
				if (ignoreNaNs && Double.isNaN(val)) {
					okay = false;
					break;
				}
				if (ignoreInfs && Double.isInfinite(val)) {
					okay = false;
					break;
				}
				vals[i] = val;
			}
			if (!okay)
				continue;
			for (int i = 0; i < isize; i++)
				stats[i].addValue(vals[i]);
		}

		// now all the calculations are done, add the values into store
		if (storedValues == null)
			storedValues = new HashMap<String, Object>();
		else
			storedValues.clear();

		for (int i = 0; i < isize; i++)
			storedValues.put(name+i, stats[i]);
	}

	@Override
	protected void calculateSummaryStats(final boolean ignoreNaNs, final boolean ignoreInfs, final int axis) {
		int rank = getRank();

		int[] oshape = getShape();
		int alen = oshape[axis];
		oshape[axis] = 1;

		int[] nshape = squeezeShape(oshape, false);

		IntegerDataset count = new IntegerDataset(nshape);
		CompoundDoubleDataset sum = new CompoundDoubleDataset(isize, nshape);
		CompoundDoubleDataset mean = new CompoundDoubleDataset(isize, nshape);
		CompoundDoubleDataset var = new CompoundDoubleDataset(isize, nshape);

		IndexIterator qiter = count.getIterator(true);
		int[] qpos = qiter.getPos();
		int[] spos = oshape;
		double[] darray = new double[isize];

		while (qiter.hasNext()) {
			int i = 0;
			for (; i < axis; i++) {
				spos[i] = qpos[i];
			}
			spos[i++] = 0;
			for (; i < rank; i++) {
				spos[i] = qpos[i-1];
			}

			final SummaryStatistics[] stats = new SummaryStatistics[isize];
			for (int k = 0; k < isize; k++) {
				stats[k] = new SummaryStatistics();
			}
			for (int j = 0; j < alen; j++) {
				spos[axis] = j;
				getDoubleArray(darray, spos);
				boolean skip = false;
				for (int k = 0; k < isize; k++) {
					double v = darray[k];
					if (ignoreNaNs && Double.isNaN(v)) {
						skip = true;
						break;
					}
					if (ignoreInfs && Double.isInfinite(v)) {
						skip = true;
						break;
					}
				}
				if (!skip)
					for (int k = 0; k < isize; k++) {
						stats[k].addValue(darray[k]);
					}
			}

			count.setAbs(qiter.index, (int) stats[0].getN());

			for (int k = 0; k < isize; k++) {
				darray[k] = stats[k].getSum();
			}
			sum.set(darray, qpos);
			for (int k = 0; k < isize; k++) {
				darray[k] = stats[k].getMean();
			}
			mean.set(darray, qpos);
			for (int k = 0; k < isize; k++) {
				darray[k] = stats[k].getVariance();
			}
			var.set(darray, qpos);
		}
		setStoredValue(storeName(ignoreNaNs, ignoreInfs, STORE_COUNT + "-" + axis), count);
		storedValues.put(storeName(ignoreNaNs, ignoreInfs, STORE_SUM + "-" + axis), sum);
		storedValues.put(storeName(ignoreNaNs, ignoreInfs, STORE_MEAN + "-" +axis), mean);
		storedValues.put(storeName(ignoreNaNs, ignoreInfs, STORE_VAR + "-" +axis), var);
	}

	@Override
	public Number max(boolean... switches) {
		logger.error("Cannot compare compound numbers");
		throw new UnsupportedOperationException("Cannot compare compound numbers");
	}

	@Override
	public CompoundDataset max(boolean ignoreNaNs, int axis) {
		logger.error("Cannot compare compound numbers");
		throw new UnsupportedOperationException("Cannot compare compound numbers");
	}

	@Override
	public CompoundDataset max(int axis) {
		logger.error("Cannot compare compound numbers");
		throw new UnsupportedOperationException("Cannot compare compound numbers");
	}

	@Override
	public Number min(boolean... switches) {
		logger.error("Cannot compare compound numbers");
		throw new UnsupportedOperationException("Cannot compare compound numbers");
	}

	@Override
	public CompoundDataset min(boolean ignoreNaNs, int axis) {
		logger.error("Cannot compare compound numbers");
		throw new UnsupportedOperationException("Cannot compare compound numbers");
	}

	@Override
	public CompoundDataset min(int axis) {
		logger.error("Cannot compare compound numbers");
		throw new UnsupportedOperationException("Cannot compare compound numbers");
	}

	@Override
	public Number positiveMin(boolean ignoreInvalids) {
		logger.error("Cannot compare compound numbers");
		throw new UnsupportedOperationException("Cannot compare compound numbers");
	}

	@Override
	public Number positiveMax(boolean ignoreNaNs, boolean ignoreInfs) {
		logger.error("Cannot compare compound numbers");
		throw new UnsupportedOperationException("Cannot compare compound numbers");
	}

	@Override
	public Number positiveMin(boolean ignoreNaNs, boolean ignoreInfs) {
		logger.error("Cannot compare compound numbers");
		throw new UnsupportedOperationException("Cannot compare compound numbers");
	}

	@Override
	public int[] maxPos(boolean ignoreNaNs) {
		logger.error("Cannot compare compound numbers");
		throw new UnsupportedOperationException("Cannot compare compound numbers");
	}

	@Override
	public int[] minPos(boolean ignoreNaNs) {
		logger.error("Cannot compare compound numbers");
		throw new UnsupportedOperationException("Cannot compare compound numbers");
	}

	protected final static String STORE_STATS_ITEM_NAME = STORE_STATS + "=";

	@Override
	public double[] maxItem() {
		final String n = storeName(false, STORE_STATS_ITEM_NAME);
		if (isize < 1)
			return new double[0];
		if (getStoredValue(n+0) == null) {
			calculateSummaryStats(false, false, n);
		}

		double[] results = new double[isize];
		for (int i = 0; i < isize; i++) {
			results[i] = ((SummaryStatistics) storedValues.get(n + i)).getMax();
		}
		return results;
	}

	@Override
	public double[] minItem() {
		final String n = storeName(false, STORE_STATS_ITEM_NAME);
		if (isize < 1)
			return new double[0];
		if (getStoredValue(n+0) == null) {
			calculateSummaryStats(false, false, n);
		}

		double[] results = new double[isize];
		for (int i = 0; i < isize; i++) {
			results[i] = ((SummaryStatistics) storedValues.get(n + i)).getMin();
		}
		return results;
	}

	@Override
	public Object sum() {
		final String n = storeName(false, STORE_STATS_ITEM_NAME);
		if (isize < 1)
			return new double[0];
		if (getStoredValue(n+0) == null) {
			calculateSummaryStats(false, false, n);
		}

		double[] results = new double[isize];
		for (int i = 0; i < isize; i++) {
			results[i] = ((SummaryStatistics) storedValues.get(n + i)).getSum();
		}
		return results;
	}

	private static Object fromDoublesToBiggestPrimitives(double[] x, int dtype) {
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

	@Override
	public Object typedSum(int dtype) {
		return fromDoublesToBiggestPrimitives((double[]) sum(), dtype);
	}

	@Override
	public Object mean(boolean... switches) {
		final String n = storeName(false, STORE_STATS_ITEM_NAME);
		if (isize < 1)
			return new double[0];
		if (getStoredValue(n+0) == null) {
			calculateSummaryStats(false, false, n);
		}

		double[] results = new double[isize];
		for (int i = 0; i < isize; i++) {
			results[i] = ((SummaryStatistics) storedValues.get(n + i)).getMean();
		}
		return results;
	}

	@Override
	public Number variance() {
		final String n = storeName(false, STORE_STATS_ITEM_NAME);
		if (isize < 1)
			return Double.NaN;
		if (getStoredValue(n+0) == null) {
			calculateSummaryStats(false, false, n);
		}

		double result = 0;
		for (int i = 0; i < isize; i++)
			result += ((SummaryStatistics) storedValues.get(n + i)).getVariance();
		return result;
	}

	@Override
	public Number rootMeanSquare() {
		final String n = storeName(false, STORE_STATS_ITEM_NAME);
		if (isize < 1)
			return Double.NaN;
		if (getStoredValue(n+0) == null) {
			calculateSummaryStats(false, false, n);
		}

		double result = 0;
		for (int i = 0; i < isize; i++) {
			final SummaryStatistics stats = (SummaryStatistics) storedValues.get(n + i);
			final double mean = stats.getMean();
			result += stats.getVariance() + mean*mean;
		}
		return Math.sqrt(result);
	}

	@Override
	public CompoundDataset getError() {
		Dataset ed = getInternalError();
		if (ed == null)
			return null;

		if (ed.getSize() != size || ed.getElementsPerItem() != isize) {
			CompoundDataset errors = new CompoundDoubleDataset(isize, shape);
			errors.setSlice(ed);
			return errors;
		}
		return (CompoundDataset) ed;
	}

	@Override
	public double getError(final int i) {
		return calcError(getInternalErrorArray(true, i));
	}

	@Override
	public double getError(final int i, final int j) {
		return calcError(getInternalErrorArray(true, i, j));
	}

	@Override
	public double getError(final int... pos) {
		return calcError(getInternalErrorArray(true, pos));
	}

	private double calcError(double[] es) {
		if (es == null)
			return 0;

		// assume elements are independent
		double e = 0;
		for (int k = 0; k < isize; k++) {
			e += es[k];
		}

		return Math.sqrt(e);
	}

	@Override
	public double[] getErrorArray(final int i) {
		return getInternalErrorArray(false, i);
	}

	@Override
	public double[] getErrorArray(final int i, final int j) {
		return getInternalErrorArray(false, i, j);
	}

	@Override
	public double[] getErrorArray(final int... pos) {
		return getInternalErrorArray(false, pos);
	}

	private double[] getInternalErrorArray(final boolean squared, final int i) {
		Dataset sed = squared ? getInternalSquaredError() : getInternalError();
		if (sed == null)
			return null;

		BroadcastStride bs = (BroadcastStride) getStoredValue(STORE_BROADCAST);
		int n = bs.get1DIndex(i);
		double[] es = new double[isize];
		if (sed instanceof CompoundDoubleDataset) {
			((CompoundDoubleDataset) sed).getDoubleArrayAbs(n, es);
			if (sed.getElementsPerItem() != isize) { // ensure error is broadcasted
				Arrays.fill(es, es[0]);
			}
		} else {
			Arrays.fill(es, ((DoubleDataset) sed).getElementDoubleAbs(n));
		}
		return es;
	}

	private double[] getInternalErrorArray(final boolean squared, final int i, final int j) {
		Dataset sed = squared ? getInternalSquaredError() : getInternalError();
		if (sed == null)
			return null;

		BroadcastStride bs = (BroadcastStride) getStoredValue(STORE_BROADCAST);
		int n = bs.get1DIndex(i, j);
		double[] es = new double[isize];
		if (sed instanceof CompoundDoubleDataset) {
			((CompoundDoubleDataset) sed).getDoubleArrayAbs(n, es);
			if (sed.getElementsPerItem() != isize) { // ensure error is broadcasted
				Arrays.fill(es, es[0]);
			}
		} else {
			Arrays.fill(es, ((DoubleDataset) sed).getElementDoubleAbs(n));
		}
		return es;
	}

	private double[] getInternalErrorArray(final boolean squared, final int... pos) {
		Dataset sed = squared ? getInternalSquaredError() : getInternalError();
		if (sed == null)
			return null;

		BroadcastStride bs = (BroadcastStride) getStoredValue(STORE_BROADCAST);
		int n = bs.get1DIndex(pos);
		double[] es = new double[isize];
		if (sed instanceof CompoundDoubleDataset) {
			((CompoundDoubleDataset) sed).getDoubleArrayAbs(n, es);
			if (sed.getElementsPerItem() != isize) { // ensure error is broadcasted
				Arrays.fill(es, es[0]);
			}
		} else {
			Arrays.fill(es, ((DoubleDataset) sed).getElementDoubleAbs(n));
		}
		return es;
	}
}

