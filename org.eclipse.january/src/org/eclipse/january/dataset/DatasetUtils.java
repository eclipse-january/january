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

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.math3.util.MathArrays;
import org.eclipse.january.DatasetException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utilities for manipulating datasets
 */
@SuppressWarnings("unchecked")
public class DatasetUtils {

	/**
	 * Setup the logging facilities
	 */
	transient protected static final Logger utilsLogger = LoggerFactory.getLogger(DatasetUtils.class);

	/**
	 * Append copy of dataset with another dataset along n-th axis
	 * 
	 * @param a
	 * @param b
	 * @param axis
	 *            number of axis (negative number counts from last)
	 * @return appended dataset
	 */
	public static Dataset append(IDataset a, IDataset b, int axis) {
		final int[] ashape = a.getShape();
		final int rank = ashape.length;
		final int[] bshape = b.getShape();
		if (rank != bshape.length) {
			throw new IllegalArgumentException("Incompatible number of dimensions");
		}
		if (axis >= rank) {
			throw new IllegalArgumentException("Axis specified exceeds array dimensions");
		} else if (axis > -rank) {
			if (axis < 0)
				axis += rank;
		} else {
			throw new IllegalArgumentException("Axis specified is less than " + (-rank));
		}

		for (int i = 0; i < rank; i++) {
			if (i != axis && ashape[i] != bshape[i]) {
				throw new IllegalArgumentException("Incompatible dimensions");
			}
		}
		final int[] nshape = new int[rank];
		for (int i = 0; i < rank; i++) {
			nshape[i] = ashape[i];
		}
		nshape[axis] += bshape[axis];
		final int ot = DTypeUtils.getDType(b);
		final int dt = DTypeUtils.getDType(a);
		@SuppressWarnings("deprecation")
		Dataset ds = DatasetFactory.zeros(a.getElementsPerItem(), nshape, dt > ot ? dt : ot);
		IndexIterator iter = ds.getIterator(true);
		int[] pos = iter.getPos();
		while (iter.hasNext()) {
			int d = ashape[axis];
			if (pos[axis] < d) {
				ds.setObjectAbs(iter.index, a.getObject(pos));
			} else {
				pos[axis] -= d;
				ds.setObjectAbs(iter.index, b.getObject(pos));
				pos[axis] += d;
			}
		}

		return ds;
	}

	/**
	 * Changes specific items of dataset by replacing them with other array
	 * @param a
	 * @param indices dataset interpreted as integers
	 * @param values
	 * @return changed dataset
	 */
	public static <T extends Dataset> T put(final T a, final Dataset indices, Object values) {
		IndexIterator it = indices.getIterator();
		Dataset vd = DatasetFactory.createFromObject(values).flatten();
		int vlen = vd.getSize();
		int v = 0;
		while (it.hasNext()) {
			if (v >= vlen) v -= vlen;

			a.setObjectAbs((int) indices.getElementLongAbs(it.index), vd.getObjectAbs(v++));
		}
		return a;
	}

	/**
	 * Changes specific items of dataset by replacing them with other array
	 * @param a
	 * @param indices
	 * @param values
	 * @return changed dataset
	 */
	public static <T extends Dataset> T put(final T a, final int[] indices, Object values) {
		int ilen = indices.length;
		Dataset vd = DatasetFactory.createFromObject(values).flatten();
		int vlen = vd.getSize();
		for (int i = 0, v= 0; i < ilen; i++) {
			if (v >= vlen) v -= vlen;

			a.setObjectAbs(indices[i], vd.getObjectAbs(v++));
		}
		return a;
	}

	/**
	 * Take items from dataset along an axis
	 * @param indices dataset interpreted as integers
	 * @param axis if null, then use flattened view
	 * @return a sub-array
	 */
	public static <T extends Dataset> T take(final T a, final Dataset indices, Integer axis) {
		IntegerDataset indexes = (IntegerDataset) indices.flatten().cast(Dataset.INT32);
		return take(a, indexes.getData(), axis);
	}

	/**
	 * Take items from dataset along an axis
	 * @param indices
	 * @param axis if null, then use flattened view
	 * @return a sub-array
	 */
	@SuppressWarnings("deprecation")
	public static <T extends Dataset> T take(final T a, final int[] indices, Integer axis) {
		if (indices == null || indices.length == 0) {
			utilsLogger.error("No indices given");
			throw new IllegalArgumentException("No indices given");
		}
		int[] ashape = a.getShape();
		final int rank = ashape.length;
		final int at = a.getDType();
		final int ilen = indices.length;
		final int is = a.getElementsPerItem();

		Dataset result;
		if (axis == null) {
			ashape = new int[1];
			ashape[0] = ilen;
			result = DatasetFactory.zeros(is, ashape, at);
			Serializable src = a.getBuffer();
			for (int i = 0; i < ilen; i++) {
				((AbstractDataset) result).setItemDirect(i, indices[i], src);
			}
		} else {
			axis = a.checkAxis(axis);
			ashape[axis] = ilen;
			result = DatasetFactory.zeros(is, ashape, at);

			int[] dpos = new int[rank];
			int[] spos = new int[rank];
			boolean[] axes = new boolean[rank];
			Arrays.fill(axes, true);
			axes[axis] = false;
			Serializable src = a.getBuffer();
			for (int i = 0; i < ilen; i++) {
				spos[axis] = indices[i];
				dpos[axis] = i;
				SliceIterator siter = a.getSliceIteratorFromAxes(spos, axes);
				SliceIterator diter = result.getSliceIteratorFromAxes(dpos, axes);

				while (siter.hasNext() && diter.hasNext()) {
					((AbstractDataset) result).setItemDirect(diter.index, siter.index, src);
				}
			}
		}
		result.setDirty();
		return (T) result;
	}

	/**
	 * Construct a dataset that contains the original dataset repeated the number
	 * of times in each axis given by corresponding entries in the reps array
	 *
	 * @param a
	 * @param reps 
	 * @return tiled dataset
	 */
	public static Dataset tile(final IDataset a, int... reps) {
		int[] shape = a.getShape();
		int rank = shape.length;
		final int rlen = reps.length;

		// expand shape
		if (rank < rlen) {
			int[] newShape = new int[rlen];
			int extraRank = rlen - rank;
			for (int i = 0; i < extraRank; i++) {
				newShape[i] = 1;
			}
			for (int i = 0; i < rank; i++) {
				newShape[i+extraRank] = shape[i];
			}

			shape = newShape;
			rank = rlen;
		} else if (rank > rlen) {
			int[] newReps = new int[rank];
			int extraRank = rank - rlen;
			for (int i = 0; i < extraRank; i++) {
				newReps[i] = 1;
			}
			for (int i = 0; i < rlen; i++) {
				newReps[i+extraRank] = reps[i];
			}
			reps = newReps;
		}

		// calculate new shape
		int[] newShape = new int[rank];
		for (int i = 0; i < rank; i++) {
			newShape[i] = shape[i]*reps[i];
		}

		@SuppressWarnings("deprecation")
		Dataset tdata = DatasetFactory.zeros(a.getElementsPerItem(), newShape, DTypeUtils.getDType(a));

		// decide which way to put slices
		boolean manyColumns;
		if (rank == 1)
			manyColumns = true;
		else
			manyColumns = shape[rank-1] > 64;

		if (manyColumns) {
			// generate each start point and put a slice in
			IndexIterator iter = tdata.getSliceIterator(null, null, shape);
			SliceIterator siter = (SliceIterator) tdata.getSliceIterator(null, shape, null); 
			final int[] pos = iter.getPos();
			while (iter.hasNext()) {
				siter.setStart(pos);
				tdata.setSlice(a, siter);
			}

		} else {
			// for each value, set slice given by repeats
			final int[] skip = new int[rank];
			for (int i = 0; i < rank; i++) {
				if (reps[i] == 1) {
					skip[i] = newShape[i];
				} else {
					skip[i] = shape[i];
				}
			}
			
			Dataset aa = convertToDataset(a);
			IndexIterator ita = aa.getIterator(true);
			final int[] pos = ita.getPos();

			final int[] sstart = new int[rank];
			final int extra = rank - pos.length;
			for (int i = 0; i < extra; i++) {
				sstart[i] = 0;
			}
			SliceIterator siter = (SliceIterator) tdata.getSliceIterator(sstart, null, skip);
			while (ita.hasNext()) {
				for (int i = 0; i < pos.length; i++) {
					sstart[i + extra] = pos[i];
				}
				siter.setStart(sstart);
				tdata.setSlice(aa.getObjectAbs(ita.index), siter);
			}
		}

		return tdata;
	}

	/**
	 * Permute copy of dataset's axes so that given order is old order:
	 * <pre>
	 *  axisPerm = (p(0), p(1),...) => newdata(n(0), n(1),...) = olddata(o(0), o(1), ...)
	 *  such that n(i) = o(p(i)) for all i
	 * </pre>
	 * I.e. for a 3D dataset (1,0,2) implies the new dataset has its 1st dimension
	 * running along the old dataset's 2nd dimension and the new 2nd is the old 1st.
	 * The 3rd dimension is left unchanged.
	 * 
	 * @param a
	 * @param axes if null or zero length then axes order reversed
	 * @return remapped copy of data
	 */
	public static Dataset transpose(final IDataset a, int... axes) {
		return convertToDataset(a).transpose(axes);
	}

	/**
	 * Swap two axes in dataset
	 * @param a
	 * @param axis1
	 * @param axis2
	 * @return swapped dataset
	 */
	public static Dataset swapAxes(final IDataset a, int axis1, int axis2) {
		return convertToDataset(a).swapAxes(axis1, axis2);
	}

	/**
	 * @param a
	 * @return sorted flattened copy of dataset 
	 */
	public static <T extends Dataset> T sort(final T a) {
		return sort(a, (Integer) null);
	}

	/**
	 * @param a
	 * @param axis to sort along
	 * @return dataset sorted along axis
	 */
	public static <T extends Dataset> T sort(final T a, final Integer axis) {
		Dataset s = a.clone();
		return (T) s.sort(axis);
	}

	/**
	 * Sort in place given dataset and reorder ancillary datasets too
	 * @param a dataset to be sorted
	 * @param b ancillary datasets
	 */
	public static void sort(Dataset a, Dataset... b) {
		if (!DTypeUtils.isDTypeNumerical(a.getDType())) {
			throw new UnsupportedOperationException("Sorting non-numerical datasets not supported yet");
		}

		// gather all datasets as double dataset copies
		DoubleDataset s = copy(DoubleDataset.class, a);
		int l = b == null ? 0 : b.length;
		DoubleDataset[] t = new DoubleDataset[l];
		int n = 0;
		for (int i = 0; i < l; i++) {
			if (b[i] != null) {
				if (!DTypeUtils.isDTypeNumerical(b[i].getDType())) {
					throw new UnsupportedOperationException("Sorting non-numerical datasets not supported yet");
				}
				t[i] = copy(DoubleDataset.class, b[i]);
				n++;
			}
		}

		double[][] y = new double[n][];
		for (int i = 0, j = 0; i < l; i++) {
			if (t[i] != null) {
				y[j++] = t[i].getData();
			}
		}

		MathArrays.sortInPlace(s.getData(), y);

		a.setSlice(s);
		for (int i = 0; i < l; i++) {
			if (b[i] != null) {
				b[i].setSlice(t[i]);
			}
		}
	}

	/**
	 * Concatenate the set of datasets along given axis
	 * @param as
	 * @param axis
	 * @return concatenated dataset
	 */
	public static Dataset concatenate(final IDataset[] as, final int axis) {
		if (as == null || as.length == 0) {
			utilsLogger.error("No datasets given");
			throw new IllegalArgumentException("No datasets given");
		}
		IDataset a = as[0];
		if (as.length == 1) {
			return convertToDataset(a.clone());
		}
		int[] ashape = a.getShape();
		int at = DTypeUtils.getDType(a);
		int anum = as.length;
		int isize = a.getElementsPerItem();

		int i = 1;
		for (; i < anum; i++) {
			if (at != DTypeUtils.getDType(as[i])) {
				utilsLogger.error("Datasets are not of same type");
				break;
			}
			if (!ShapeUtils.areShapesCompatible(ashape, as[i].getShape(), axis)) {
				utilsLogger.error("Datasets' shapes are not equal");
				break;
			}
			final int is = as[i].getElementsPerItem();
			if (isize < is)
				isize = is;
		}
		if (i < anum) {
			utilsLogger.error("Dataset are not compatible");
			throw new IllegalArgumentException("Datasets are not compatible");
		}

		for (i = 1; i < anum; i++) {
			ashape[axis] += as[i].getShape()[axis];
		}

		@SuppressWarnings("deprecation")
		Dataset result = DatasetFactory.zeros(isize, ashape, at);

		int[] start = new int[ashape.length];
		int[] stop = ashape;
		stop[axis] = 0;
		for (i = 0; i < anum; i++) {
			IDataset b = as[i];
			int[] bshape = b.getShape();
			stop[axis] += bshape[axis];
			result.setSlice(b, start, stop, null);
			start[axis] += bshape[axis];
		}

		return result;
	}

	/**
	 * Split a dataset into equal sections along given axis
	 * @param a
	 * @param sections
	 * @param axis
	 * @param checkEqual makes sure the division is into equal parts
	 * @return list of split datasets
	 */
	public static List<Dataset> split(final Dataset a, int sections, final int axis, final boolean checkEqual) {
		int[] ashape = a.getShapeRef();
		int rank = ashape.length;
		if (axis >= rank) {
			utilsLogger.error("Axis exceeds rank of dataset");
			throw new IllegalArgumentException("Axis exceeds rank of dataset");
		}
		int imax = ashape[axis];
		if (checkEqual && (imax%sections) != 0) {
			utilsLogger.error("Number of sections does not divide axis into equal parts");
			throw new IllegalArgumentException("Number of sections does not divide axis into equal parts");
		}
		int n = (imax + sections - 1) / sections;
		int[] indices = new int[sections-1];
		for (int i = 1; i < sections; i++)
			indices[i-1] = n*i;
		return split(a, indices, axis);
	}

	/**
	 * Split a dataset into parts along given axis
	 * @param a
	 * @param indices
	 * @param axis
	 * @return list of split datasets
	 */
	@SuppressWarnings("deprecation")
	public static List<Dataset> split(final Dataset a, int[] indices, final int axis) {
		final int[] ashape = a.getShapeRef();
		final int rank = ashape.length;
		if (axis >= rank) {
			utilsLogger.error("Axis exceeds rank of dataset");
			throw new IllegalArgumentException("Axis exceeds rank of dataset");
		}
		final int imax = ashape[axis];

		final List<Dataset> result = new ArrayList<Dataset>();

		final int[] nshape = ashape.clone();
		final int is = a.getElementsPerItem();

		int oind = 0;
		final int[] start = new int[rank];
		final int[] stop = new int[rank];
		final int[] step = new int[rank];
		for (int i = 0; i < rank; i++) {
			start[i] = 0;
			stop[i] = ashape[i];
			step[i] = 1;
		}
		for (int ind : indices) {
			if (ind > imax) {
				result.add(DatasetFactory.zeros(is, new int[] {0}, a.getDType()));
			} else {
				nshape[axis] = ind - oind;
				start[axis] = oind;
				stop[axis] = ind;
				Dataset n = DatasetFactory.zeros(is, nshape, a.getDType());
				IndexIterator iter = a.getSliceIterator(start, stop, step);

				a.fillDataset(n, iter);
				result.add(n);
				oind = ind;
			}
		}

		if (imax > oind) {
			nshape[axis] = imax - oind;
			start[axis] = oind;
			stop[axis] = imax;
			Dataset n = DatasetFactory.zeros(is, nshape, a.getDType());
			IndexIterator iter = a.getSliceIterator(start, stop, step);

			a.fillDataset(n, iter);
			result.add(n);
		}

		return result;
	}

	/**
	 * Constructs a dataset which has its elements along an axis replicated from
	 * the original dataset by the number of times given in the repeats array.
	 * 
	 * By default, axis=-1 implies using a flattened version of the input dataset 
	 *
	 * @param a
	 * @param repeats 
	 * @param axis
	 * @return dataset
	 */
	public static <T extends Dataset> T repeat(T a, int[] repeats, int axis) {
		Serializable buf = a.getBuffer();
		int[] shape = a.getShape();
		int rank = shape.length;
		final int is = a.getElementsPerItem();

		if (axis >= rank) {
			utilsLogger.warn("Axis value is out of bounds");
			throw new IllegalArgumentException("Axis value is out of bounds");
		}

		int alen;
		if (axis < 0) {
			alen = a.getSize();
			axis = 0;
			rank = 1;
			shape[0] = alen;
		} else {
			alen = shape[axis];
		}
		int rlen = repeats.length;
		if (rlen != 1 && rlen != alen) {
			utilsLogger.warn("Repeats array should have length of 1 or match chosen axis");
			throw new IllegalArgumentException("Repeats array should have length of 1 or match chosen axis");
		}

		for (int i = 0; i < rlen; i++) {
			if (repeats[i] < 0) {
				utilsLogger.warn("Negative repeat value is not allowed");
				throw new IllegalArgumentException("Negative repeat value is not allowed");
			}
		}

		int[] newShape = new int[rank];
		for (int i = 0; i < rank; i ++)
			newShape[i] = shape[i];

		// do single repeat separately
		if (repeats.length == 1) {
			newShape[axis] *= repeats[0];
		} else {
			int nlen = 0;
			for (int i = 0; i < alen; i++) {
				nlen += repeats[i];
			}
			newShape[axis] = nlen;
		}

		@SuppressWarnings("deprecation")
		Dataset rdata = DatasetFactory.zeros(is, newShape, a.getDType());
		Serializable nbuf = rdata.getBuffer();

		int csize = is; // chunk size
		for (int i = axis+1; i < rank; i++) {
			csize *= newShape[i];
		}
		int nout = 1;
		for (int i = 0; i < axis; i++) {
			nout *= newShape[i];
		}

		int oi = 0;
		int ni = 0;
		if (rlen == 1) { // do single repeat separately
			for (int i = 0; i < nout; i++) {
				for (int j = 0; j < shape[axis]; j++) {
					for (int k = 0; k < repeats[0]; k++) {
						System.arraycopy(buf, oi, nbuf, ni, csize);
						ni += csize;
					}
					oi += csize;
				}
			}
		} else {
			for (int i = 0; i < nout; i++) {
				for (int j = 0; j < shape[axis]; j++) {
					for (int k = 0; k < repeats[j]; k++) {
						System.arraycopy(buf, oi, nbuf, ni, csize);
						ni += csize;
					}
					oi += csize;
				}
			}
		}

		return (T) rdata;
	}

	/**
	 * Resize a dataset 
	 * @param a
	 * @param shape
	 * @return new dataset with new shape and items that are truncated or repeated, as necessary
	 */
	public static <T extends Dataset> T resize(final T a, final int... shape) {
		int size = a.getSize();
		@SuppressWarnings("deprecation")
		Dataset rdata = DatasetFactory.zeros(a.getElementsPerItem(), shape, a.getDType());
		IndexIterator it = rdata.getIterator();
		while (it.hasNext()) {
			rdata.setObjectAbs(it.index, a.getObjectAbs(it.index % size));
		}

		return (T) rdata;
	}

	/**
	 * Copy and cast a dataset
	 * 
	 * @param d
	 *            The dataset to be copied
	 * @param dtype dataset type
	 * @return copied dataset of given type
	 */
	public static Dataset copy(final IDataset d, final int dtype) {
		Dataset a = convertToDataset(d);

		Dataset c = null;
		try {
			// copy across the data
			switch (dtype) {
			case Dataset.STRING:
				c = new StringDataset(a);
				break;
			case Dataset.BOOL:
				c = new BooleanDataset(a);
				break;
			case Dataset.INT8:
				if (a instanceof CompoundDataset)
					c = new CompoundByteDataset(a);
				else
					c = new ByteDataset(a);
				break;
			case Dataset.INT16:
				if (a instanceof CompoundDataset)
					c = new CompoundShortDataset(a);
				else
					c = new ShortDataset(a);
				break;
			case Dataset.INT32:
				if (a instanceof CompoundDataset)
					c = new CompoundIntegerDataset(a);
				else
					c = new IntegerDataset(a);
				break;
			case Dataset.INT64:
				if (a instanceof CompoundDataset)
					c = new CompoundLongDataset(a);
				else
					c = new LongDataset(a);
				break;
			case Dataset.ARRAYINT8:
				if (a instanceof CompoundDataset)
					c = new CompoundByteDataset((CompoundDataset) a);
				else
					c = new CompoundByteDataset(a);
				break;
			case Dataset.ARRAYINT16:
				if (a instanceof CompoundDataset)
					c = new CompoundShortDataset((CompoundDataset) a);
				else
					c = new CompoundShortDataset(a);
				break;
			case Dataset.ARRAYINT32:
				if (a instanceof CompoundDataset)
					c = new CompoundIntegerDataset((CompoundDataset) a);
				else
					c = new CompoundIntegerDataset(a);
				break;
			case Dataset.ARRAYINT64:
				if (a instanceof CompoundDataset)
					c = new CompoundLongDataset((CompoundDataset) a);
				else
					c = new CompoundLongDataset(a);
				break;
			case Dataset.FLOAT32:
				c = new FloatDataset(a);
				break;
			case Dataset.FLOAT64:
				c = new DoubleDataset(a);
				break;
			case Dataset.ARRAYFLOAT32:
				if (a instanceof CompoundDataset)
					c = new CompoundFloatDataset((CompoundDataset) a);
				else
					c = new CompoundFloatDataset(a);
				break;
			case Dataset.ARRAYFLOAT64:
				if (a instanceof CompoundDataset)
					c = new CompoundDoubleDataset((CompoundDataset) a);
				else
					c = new CompoundDoubleDataset(a);
				break;
			case Dataset.COMPLEX64:
				c = new ComplexFloatDataset(a);
				break;
			case Dataset.COMPLEX128:
				c = new ComplexDoubleDataset(a);
				break;
			case Dataset.RGB:
				if (a instanceof CompoundDataset)
					c = RGBDataset.createFromCompoundDataset((CompoundDataset) a);
				else
					c = new RGBDataset(a);
				break;
			default:
				utilsLogger.error("Dataset of unknown type!");
				break;
			}
		} catch (OutOfMemoryError e) {
			utilsLogger.error("Not enough memory available to create dataset");
			throw new OutOfMemoryError("Not enough memory available to create dataset");
		}

		return c;
	}

	/**
	 * Copy and cast a dataset
	 * 
	 * @param clazz dataset class
	 * @param d
	 *            The dataset to be copied
	 * @return copied dataset of given type
	 */
	public static <T extends Dataset> T copy(Class<T> clazz, final IDataset d) {
		return (T) copy(d, DTypeUtils.getDType(clazz));
	}


	/**
	 * Cast a dataset
	 * 
	 * @param d
	 *            The dataset to be cast.
	 * @param dtype dataset type
	 * @return dataset of given type (or same dataset if already of the right type)
	 */
	public static Dataset cast(final IDataset d, final int dtype) {
		Dataset a = convertToDataset(d);

		if (a.getDType() == dtype) {
			return a;
		}
		return copy(d, dtype);
	}

	/**
	 * Cast a dataset
	 * 
	 * @param clazz dataset class
	 * @param d
	 *            The dataset to be cast.
	 * @return dataset of given type (or same dataset if already of the right type)
	 */
	public static <T extends Dataset> T cast(Class<T> clazz, final IDataset d) {
		return (T) cast(d, DTypeUtils.getDType(clazz));
	}

	/**
	 * Cast a dataset
	 * 
	 * @param d
	 *            The dataset to be cast.
	 * @param repeat repeat elements over item
	 * @param dtype dataset type
	 * @param isize item size
	 */
	public static Dataset cast(final IDataset d, final boolean repeat, final int dtype, final int isize) {
		Dataset a = convertToDataset(d);

		if (a.getDType() == dtype && a.getElementsPerItem() == isize) {
			return a;
		}
		if (isize <= 0) {
			utilsLogger.error("Item size is invalid (>0)");
			throw new IllegalArgumentException("Item size is invalid (>0)");
		}
		if (isize > 1 && dtype <= Dataset.FLOAT64) {
			utilsLogger.error("Item size is inconsistent with dataset type");
			throw new IllegalArgumentException("Item size is inconsistent with dataset type");
		}

		Dataset c = null;

		try {
			// copy across the data
			switch (dtype) {
			case Dataset.BOOL:
				c = new BooleanDataset(a);
				break;
			case Dataset.INT8:
				c = new ByteDataset(a);
				break;
			case Dataset.INT16:
				c = new ShortDataset(a);
				break;
			case Dataset.INT32:
				c = new IntegerDataset(a);
				break;
			case Dataset.INT64:
				c = new LongDataset(a);
				break;
			case Dataset.ARRAYINT8:
				c = new CompoundByteDataset(isize, repeat, a);
				break;
			case Dataset.ARRAYINT16:
				c = new CompoundShortDataset(isize, repeat, a);
				break;
			case Dataset.ARRAYINT32:
				c = new CompoundIntegerDataset(isize, repeat, a);
				break;
			case Dataset.ARRAYINT64:
				c = new CompoundLongDataset(isize, repeat, a);
				break;
			case Dataset.FLOAT32:
				c = new FloatDataset(a);
				break;
			case Dataset.FLOAT64:
				c = new DoubleDataset(a);
				break;
			case Dataset.ARRAYFLOAT32:
				c = new CompoundFloatDataset(isize, repeat, a);
				break;
			case Dataset.ARRAYFLOAT64:
				c = new CompoundDoubleDataset(isize, repeat, a);
				break;
			case Dataset.COMPLEX64:
				c = new ComplexFloatDataset(a);
				break;
			case Dataset.COMPLEX128:
				c = new ComplexDoubleDataset(a);
				break;
			default:
				utilsLogger.error("Dataset of unknown type!");
				break;
			}
		} catch (OutOfMemoryError e) {
			utilsLogger.error("Not enough memory available to create dataset");
			throw new OutOfMemoryError("Not enough memory available to create dataset");
		}

		return c;
	}

	/**
	 * Cast array of datasets to a compound dataset
	 * 
	 * @param a
	 *            The datasets to be cast.
	 */
	public static CompoundDataset cast(final Dataset[] a, final int dtype) {
		CompoundDataset c = null;

		switch (dtype) {
		case Dataset.INT8:
		case Dataset.ARRAYINT8:
			c = new CompoundByteDataset(a);
			break;
		case Dataset.INT16:
		case Dataset.ARRAYINT16:
			c = new CompoundShortDataset(a);
			break;
		case Dataset.INT32:
		case Dataset.ARRAYINT32:
			c = new CompoundIntegerDataset(a);
			break;
		case Dataset.INT64:
		case Dataset.ARRAYINT64:
			c = new CompoundLongDataset(a);
			break;
		case Dataset.FLOAT32:
		case Dataset.ARRAYFLOAT32:
			c = new CompoundFloatDataset(a);
			break;
		case Dataset.FLOAT64:
		case Dataset.ARRAYFLOAT64:
			c = new CompoundDoubleDataset(a);
			break;
		case Dataset.COMPLEX64:
			if (a.length != 2) {
				throw new IllegalArgumentException("Need two datasets for complex dataset type");
			}
			c = new ComplexFloatDataset(a[0], a[1]);
			break;
		case Dataset.COMPLEX128:
			if (a.length != 2) {
				throw new IllegalArgumentException("Need two datasets for complex dataset type");
			}
			c = new ComplexDoubleDataset(a[0], a[1]);
			break;
		default:
			utilsLogger.error("Dataset of unsupported type!");
			break;
		}

		return c;
	}

	/**
	 * Make a dataset unsigned by promoting it to a wider dataset type and unwrapping the signs
	 * of its content
	 * @param a
	 * @return unsigned dataset or original if it is not an integer dataset
	 */
	public static Dataset makeUnsigned(IDataset a) {
		Dataset d = convertToDataset(a);
		int dtype = d.getDType();
		switch (dtype) {
		case Dataset.INT32:
			d = new LongDataset(d);
			unwrapUnsigned(d, 32);
			break;
		case Dataset.INT16:
			d = new IntegerDataset(d);
			unwrapUnsigned(d, 16);
			break;
		case Dataset.INT8:
			d = new ShortDataset(d);
			unwrapUnsigned(d, 8);
			break;
		case Dataset.ARRAYINT32:
			d = new CompoundLongDataset(d);
			unwrapUnsigned(d, 32);
			break;
		case Dataset.ARRAYINT16:
			d = new CompoundIntegerDataset(d);
			unwrapUnsigned(d, 16);
			break;
		case Dataset.ARRAYINT8:
			d = new CompoundShortDataset(d);
			unwrapUnsigned(d, 8);
			break;
		}
		return d;
	}

	/**
	 * Unwrap dataset elements so that all elements are unsigned
	 * @param a dataset
	 * @param bitWidth width of original primitive in bits
	 */
	public static void unwrapUnsigned(Dataset a, final int bitWidth) {
		final int dtype = a.getDType();
		final double dv = 1L << bitWidth;
		final int isize = a.getElementsPerItem();
		IndexIterator it = a.getIterator();

		switch (dtype) {
		case Dataset.BOOL:
			break;
		case Dataset.INT8:
			break;
		case Dataset.INT16:
			ShortDataset sds = (ShortDataset) a;
			final short soffset = (short) dv;
			while (it.hasNext()) {
				final short x = sds.getAbs(it.index);
				if (x < 0)
					sds.setAbs(it.index, (short) (x + soffset));
			}
			break;
		case Dataset.INT32:
			IntegerDataset ids = (IntegerDataset) a;
			final int ioffset = (int) dv;
			while (it.hasNext()) {
				final int x = ids.getAbs(it.index);
				if (x < 0)
					ids.setAbs(it.index, x + ioffset);
			}
			break;
		case Dataset.INT64:
			LongDataset lds = (LongDataset) a;
			final long loffset = (long) dv;
			while (it.hasNext()) {
				final long x = lds.getAbs(it.index);
				if (x < 0)
					lds.setAbs(it.index, x + loffset);
			}
			break;
		case Dataset.FLOAT32:
			FloatDataset fds = (FloatDataset) a;
			final float foffset = (float) dv;
			while (it.hasNext()) {
				final float x = fds.getAbs(it.index);
				if (x < 0)
					fds.setAbs(it.index, x + foffset);
			}
			break;
		case Dataset.FLOAT64:
			DoubleDataset dds = (DoubleDataset) a;
			final double doffset = dv;
			while (it.hasNext()) {
				final double x = dds.getAbs(it.index);
				if (x < 0)
					dds.setAbs(it.index, x + doffset);
			}
			break;
		case Dataset.ARRAYINT8:
			break;
		case Dataset.ARRAYINT16:
			CompoundShortDataset csds = (CompoundShortDataset) a;
			final short csoffset = (short) dv;
			final short[] csa = new short[isize];
			while (it.hasNext()) {
				csds.getAbs(it.index, csa);
				boolean dirty = false;
				for (int i = 0; i < isize; i++) {
					short x = csa[i];
					if (x < 0) {
						csa[i] = (short) (x + csoffset);
						dirty = true;
					}
				}
				if (dirty)
					csds.setAbs(it.index, csa);
			}
			break;
		case Dataset.ARRAYINT32:
			CompoundIntegerDataset cids = (CompoundIntegerDataset) a;
			final int cioffset = (int) dv;
			final int[] cia = new int[isize];
			while (it.hasNext()) {
				cids.getAbs(it.index, cia);
				boolean dirty = false;
				for (int i = 0; i < isize; i++) {
					int x = cia[i];
					if (x < 0) {
						cia[i] = x + cioffset;
						dirty = true;
					}
				}
				if (dirty)
					cids.setAbs(it.index, cia);
			}
			break;
		case Dataset.ARRAYINT64:
			CompoundLongDataset clds = (CompoundLongDataset) a;
			final long cloffset = (long) dv;
			final long[] cla = new long[isize];
			while (it.hasNext()) {
				clds.getAbs(it.index, cla);
				boolean dirty = false;
				for (int i = 0; i < isize; i++) {
					long x = cla[i];
					if (x < 0) {
						cla[i] = x + cloffset;
						dirty = true;
					}
				}
				if (dirty)
					clds.setAbs(it.index, cla);
			}
			break;
		default:
			utilsLogger.error("Dataset of unsupported type for this method");
			break;
		}
	}

	/**
	 * @param rows
	 * @param cols
	 * @param offset
	 * @param dtype
	 * @return a new 2d dataset of given shape and type, filled with ones on the (offset) diagonal
	 */
	public static Dataset eye(final int rows, final int cols, final int offset, final int dtype) {
		int[] shape = new int[] {rows, cols};
		@SuppressWarnings("deprecation")
		Dataset a = DatasetFactory.zeros(shape, dtype);

		int[] pos = new int[] {0, offset};
		while (pos[1] < 0) {
			pos[0]++;
			pos[1]++;
		}
		while (pos[0] < rows && pos[1] < cols) {
			a.set(1, pos);
			pos[0]++;
			pos[1]++;
		}

		return a;
	}

	/**
	 * Create a (off-)diagonal matrix from items in dataset
	 * @param a
	 * @param offset
	 * @return diagonal matrix
	 */
	@SuppressWarnings("deprecation")
	public static <T extends Dataset> T diag(final T a, final int offset) {
		final int dtype = a.getDType();
		final int rank = a.getRank();
		final int is = a.getElementsPerItem();

		if (rank == 0 || rank > 2) {
			utilsLogger.error("Rank of dataset should be one or two");
			throw new IllegalArgumentException("Rank of dataset should be one or two");
		}

		Dataset result;
		final int[] shape = a.getShapeRef();
		if (rank == 1) {
			int side = shape[0] + Math.abs(offset);
			int[] pos = new int[] {side, side};
			result = DatasetFactory.zeros(is, pos, dtype);
			if (offset >= 0) {
				pos[0] = 0;
				pos[1] = offset;
			} else {
				pos[0] = -offset;
				pos[1] = 0;
			}
			int i = 0;
			while (pos[0] < side && pos[1] < side) {
				result.set(a.getObject(i++), pos);
				pos[0]++;
				pos[1]++;
			}
		} else {
			int side = offset >= 0 ? Math.min(shape[0], shape[1]-offset) : Math.min(shape[0]+offset, shape[1]);
			if (side < 0)
				side = 0;
			result = DatasetFactory.zeros(is, new int[] {side}, dtype);

			if (side > 0) {
				int[] pos = offset >= 0 ? new int[] { 0, offset } : new int[] { -offset, 0 };
				int i = 0;
				while (pos[0] < shape[0] && pos[1] < shape[1]) {
					result.set(a.getObject(pos), i++);
					pos[0]++;
					pos[1]++;
				}
			}
		}

		return (T) result;
	}

	/**
	 * Slice (or fully load), if necessary, a lazy dataset, otherwise take a slice view and
	 * convert to our dataset implementation. If a slice is necessary, this may cause resource
	 * problems when used on large datasets and throw runtime exceptions
	 * @param lazy can be null
	 * @return Converted dataset or null
	 * @throws DatasetException
	 */
	public static Dataset sliceAndConvertLazyDataset(ILazyDataset lazy) throws DatasetException {
		if (lazy == null)
			return null;

		IDataset data = lazy instanceof IDataset ? (IDataset) lazy.getSliceView() : lazy.getSlice();

		return convertToDataset(data);
	}

	/**
	 * Convert (if necessary) a dataset obeying the interface to our implementation
	 * @param data can be null
	 * @return Converted dataset or null
	 */
	public static Dataset convertToDataset(IDataset data) {
		if (data == null)
			return null;

		if (data instanceof Dataset) {
			return (Dataset) data;
		}

		int dtype = DTypeUtils.getDType(data);

		final int isize = data.getElementsPerItem();
		if (isize <= 0) {
			throw new IllegalArgumentException("Datasets with " + isize + " elements per item not supported");
		}

		@SuppressWarnings("deprecation")
		final Dataset result = DatasetFactory.zeros(isize, data.getShape(), dtype);
		result.setName(data.getName());

		final IndexIterator it = result.getIterator(true);
		final int[] pos = it.getPos();
		switch (dtype) {
		case Dataset.BOOL:
			while (it.hasNext()) {
				result.setObjectAbs(it.index, data.getBoolean(pos));
			}
			break;
		case Dataset.INT8:
			while (it.hasNext()) {
				result.setObjectAbs(it.index, data.getByte(pos));
			}
			break;
		case Dataset.INT16:
			while (it.hasNext()) {
				result.setObjectAbs(it.index, data.getShort(pos));
			}
			break;
		case Dataset.INT32:
			while (it.hasNext()) {
				result.setObjectAbs(it.index, data.getInt(pos));
			}
			break;
		case Dataset.INT64:
			while (it.hasNext()) {
				result.setObjectAbs(it.index, data.getLong(pos));
			}
			break;
		case Dataset.FLOAT32:
			while (it.hasNext()) {
				result.setObjectAbs(it.index, data.getFloat(pos));
			}
			break;
		case Dataset.FLOAT64:
			while (it.hasNext()) {
				result.setObjectAbs(it.index, data.getDouble(pos));
			}
			break;
		default:
			while (it.hasNext()) {
				result.setObjectAbs(it.index, data.getObject(pos));
			}
			break;
		}

		result.setErrors(data.getErrors());
		return result;
	}

	/**
	 * Create a compound dataset from given datasets
	 * @param datasets
	 * @return compound dataset or null if none given
	 */
	public static CompoundDataset createCompoundDataset(final Dataset... datasets) {
		if (datasets == null || datasets.length == 0)
			return null;

		return createCompoundDataset(datasets[0].getDType(), datasets);
	}

	/**
	 * Create a compound dataset from given datasets
	 * @param dtype
	 * @param datasets
	 * @return compound dataset or null if none given
	 */
	public static CompoundDataset createCompoundDataset(final int dtype, final Dataset... datasets) {
		if (datasets == null || datasets.length == 0)
			return null;

		switch (dtype) {
		case Dataset.INT8:
		case Dataset.ARRAYINT8:
			return new CompoundByteDataset(datasets);
		case Dataset.INT16:
		case Dataset.ARRAYINT16:
			return new CompoundShortDataset(datasets);
		case Dataset.INT32:
		case Dataset.ARRAYINT32:
			return new CompoundIntegerDataset(datasets);
		case Dataset.INT64:
		case Dataset.ARRAYINT64:
			return new CompoundLongDataset(datasets);
		case Dataset.FLOAT32:
		case Dataset.ARRAYFLOAT32:
			return new CompoundFloatDataset(datasets);
		case Dataset.FLOAT64:
		case Dataset.ARRAYFLOAT64:
			return new CompoundDoubleDataset(datasets);
		case Dataset.COMPLEX64:
		case Dataset.COMPLEX128:
			if (datasets.length > 2) {
				utilsLogger.error("At most two datasets are allowed");
				throw new IllegalArgumentException("At most two datasets are allowed");
			} else if (datasets.length == 2) {
				return dtype == Dataset.COMPLEX64 ? new ComplexFloatDataset(datasets[0], datasets[1]) : new ComplexDoubleDataset(datasets[0], datasets[1]);
			}
			return dtype == Dataset.COMPLEX64 ? new ComplexFloatDataset(datasets[0]) : new ComplexDoubleDataset(datasets[0]);
		case Dataset.RGB:
			if (datasets.length == 1) {
				return new RGBDataset(datasets[0]);
			} else if (datasets.length == 3) {
				return new RGBDataset(datasets[0], datasets[1], datasets[2]);
			} else {
				utilsLogger.error("Only one or three datasets are allowed to create a RGB dataset");
				throw new IllegalArgumentException("Only one or three datasets are allowed to create a RGB dataset");
			}
		default:
			utilsLogger.error("Dataset type not supported for this operation");
			throw new UnsupportedOperationException("Dataset type not supported");
		}
	}

	/**
	 * Create a compound dataset from given datasets
	 * @param clazz dataset class
	 * @param datasets
	 * @return compound dataset or null if none given
	 */
	public static <T extends CompoundDataset> T createCompoundDataset(Class<T> clazz, final Dataset... datasets) {
		return (T) createCompoundDataset(DTypeUtils.getDType(clazz), datasets);
	}

	/**
	 * Create a compound dataset from given dataset
	 * @param dataset
	 * @param itemSize
	 * @return compound dataset
	 */
	public static CompoundDataset createCompoundDataset(final Dataset dataset, final int itemSize) {
		int[] shape = dataset.getShapeRef();
		int[] nshape = shape;
		if (shape != null && itemSize > 1) {
			int size = ShapeUtils.calcSize(shape);
			if (size % itemSize != 0) {
				throw new IllegalArgumentException("Input dataset has number of items that is not a multiple of itemSize");
			}
			int d = shape.length;
			int l = 1;
			while (--d >= 0) {
				l *= shape[d];
				if (l % itemSize == 0) {
					break;
				}
			}
			assert d >= 0;
			nshape = new int[d + 1];
			for (int i = 0; i < d; i++) {
				nshape[i] = shape[i];
			}
			nshape[d] = l / itemSize;
		}
		switch (dataset.getDType()) {
		case Dataset.INT8:
			return new CompoundByteDataset(itemSize, (byte[]) dataset.getBuffer(), nshape);
		case Dataset.INT16:
			return new CompoundShortDataset(itemSize, (short[]) dataset.getBuffer(), nshape);
		case Dataset.INT32:
			return new CompoundIntegerDataset(itemSize, (int[]) dataset.getBuffer(), nshape);
		case Dataset.INT64:
			return new CompoundLongDataset(itemSize, (long[]) dataset.getBuffer(), nshape);
		case Dataset.FLOAT32:
			return new CompoundFloatDataset(itemSize, (float[]) dataset.getBuffer(), nshape);
		case Dataset.FLOAT64:
			return new CompoundDoubleDataset(itemSize, (double[]) dataset.getBuffer(), nshape);
		default:
			utilsLogger.error("Dataset type not supported for this operation");
			throw new UnsupportedOperationException("Dataset type not supported");
		}
	}

	
	/**
	 * Create a compound dataset by using last axis as elements of an item
	 * @param a
	 * @param shareData if true, then share data
	 * @return compound dataset
	 */
	public static CompoundDataset createCompoundDatasetFromLastAxis(final Dataset a, final boolean shareData) {
		switch (a.getDType()) {
		case Dataset.INT8:
			return CompoundByteDataset.createCompoundDatasetWithLastDimension(a, shareData);
		case Dataset.INT16:
			return CompoundShortDataset.createCompoundDatasetWithLastDimension(a, shareData);
		case Dataset.INT32:
			return CompoundIntegerDataset.createCompoundDatasetWithLastDimension(a, shareData);
		case Dataset.INT64:
			return CompoundLongDataset.createCompoundDatasetWithLastDimension(a, shareData);
		case Dataset.FLOAT32:
			return CompoundFloatDataset.createCompoundDatasetWithLastDimension(a, shareData);
		case Dataset.FLOAT64:
			return CompoundDoubleDataset.createCompoundDatasetWithLastDimension(a, shareData);
		default:
			utilsLogger.error("Dataset type not supported for this operation");
			throw new UnsupportedOperationException("Dataset type not supported");
		}
	}

	/**
	 * Create a dataset from a compound dataset by using elements of an item as last axis
	 * <p>
	 * In the case where the number of elements is one, the last axis is squeezed out.
	 * @param a
	 * @param shareData if true, then share data
	 * @return non-compound dataset
	 */
	public static Dataset createDatasetFromCompoundDataset(final CompoundDataset a, final boolean shareData) {
		return a.asNonCompoundDataset(shareData);
	}

	/**
	 * Create a copy that has been coerced to an appropriate dataset type
	 * depending on the input object's class
	 *
	 * @param a
	 * @param obj
	 * @return coerced copy of dataset
	 */
	public static Dataset coerce(Dataset a, Object obj) {
		final int dt = a.getDType();
		final int ot = DTypeUtils.getDTypeFromClass(obj.getClass());

		return cast(a.clone(), DTypeUtils.getBestDType(dt, ot));
	}

	/**
	 * Function that returns a normalised dataset which is bounded between 0 and 1
	 * @param a dataset
	 * @return normalised dataset
	 */
	public static Dataset norm(Dataset a) {
		double amin = a.min().doubleValue();
		double aptp = a.max().doubleValue() - amin;
		Dataset temp = Maths.subtract(a, amin);
		temp.idivide(aptp);
		return temp;
	}

	/**
	 * Function that returns a normalised compound dataset which is bounded between 0 and 1. There
	 * are (at least) two ways to normalise a compound dataset: per element - extrema for each element
	 * in a compound item is used, i.e. many min/max pairs; over all elements - extrema for all elements
	 * is used, i.e. one min/max pair.
	 * @param a dataset
	 * @param overAllElements if true, then normalise over all elements in each item
	 * @return normalised dataset
	 */
	public static CompoundDataset norm(CompoundDataset a, boolean overAllElements) {
		double[] amin = a.minItem();
		double[] amax = a.maxItem();
		final int is = a.getElementsPerItem();
		Dataset result;

		if (overAllElements) {
			Arrays.sort(amin);
			Arrays.sort(amax);
			double aptp = amax[0] - amin[0];
			
			result = Maths.subtract(a, amin[0]);
			result.idivide(aptp);
		} else {
			double[] aptp = new double[is];
			for (int j = 0; j < is; j++) {
				aptp[j] = amax[j] - amin[j];
			}

			result = Maths.subtract(a, amin);
			result.idivide(aptp);
		}
		return (CompoundDataset) result;
	}

	/**
	 * Function that returns a normalised dataset which is bounded between 0 and 1
	 * and has been distributed on a log10 scale
	 * @param a dataset
	 * @return normalised dataset
	 */
	public static Dataset lognorm(Dataset a) {
		double amin = a.min().doubleValue();
		double aptp = Math.log10(a.max().doubleValue() - amin + 1.);
		Dataset temp = Maths.subtract(a, amin - 1.);
		temp = Maths.log10(temp);
		temp = Maths.divide(temp, aptp);
		return temp;
	}

	/**
	 * Function that returns a normalised dataset which is bounded between 0 and 1
	 * and has been distributed on a natural log scale
	 * @param a dataset
	 * @return normalised dataset
	 */
	public static Dataset lnnorm(Dataset a) {
		double amin = a.min().doubleValue();
		double aptp = Math.log(a.max().doubleValue() - amin + 1.);
		Dataset temp = Maths.subtract(a, amin - 1.);
		temp = Maths.log(temp);
		temp = Maths.divide(temp, aptp);
		return temp;
	}

	/**
	 * Construct a list of datasets where each represents a coordinate varying over the hypergrid
	 * formed by the input list of axes
	 * 
	 * @param axes an array of 1D datasets representing axes
	 * @return a list of coordinate datasets
	 */
	public static List<Dataset> meshGrid(final Dataset... axes) {
		List<Dataset> result = new ArrayList<Dataset>();
		int rank = axes.length;

		if (rank < 2) {
			utilsLogger.error("Two or more axes datasets are required");
			throw new IllegalArgumentException("Two or more axes datasets are required");
		}

		int[] nshape = new int[rank];

		for (int i = 0; i < rank; i++) {
			Dataset axis = axes[i];
			if (axis.getRank() != 1) {
				utilsLogger.error("Given axis is not 1D");
				throw new IllegalArgumentException("Given axis is not 1D");
			}
			nshape[i] = axis.getSize();
		}

		for (int i = 0; i < rank; i++) {
			Dataset axis = axes[i];
			@SuppressWarnings("deprecation")
			Dataset coord = DatasetFactory.zeros(nshape, axis.getDType());
			result.add(coord);

			final int alen = axis.getSize();
			for (int j = 0; j < alen; j++) {
				final Object obj = axis.getObjectAbs(j);
				PositionIterator pi = coord.getPositionIterator(i);
				final int[] pos = pi.getPos();

				pos[i] = j;
				while (pi.hasNext()) {
					coord.set(obj, pos);
				}
			}
		}

		return result;
	}

	/**
	 * Generate an index dataset for given dataset where sub-datasets contain index values
	 *
	 * @return an index dataset
	 */
	public static IntegerDataset indices(int... shape) {
		// now create another dataset to plot against
		final int rank = shape.length;
		int[] nshape = new int[rank+1];
		nshape[0] = rank;
		for (int i = 0; i < rank; i++) {
			nshape[i+1] = shape[i];
		}

		IntegerDataset index = new IntegerDataset(nshape);

		if (rank == 1) {
			final int alen = shape[0];
			int[] pos = new int[2];
			for (int j = 0; j < alen; j++) {
				pos[1] = j;
				index.set(j, pos);
			}
		} else {
			for (int i = 1; i <= rank; i++) {
				final int alen = nshape[i];
				for (int j = 0; j < alen; j++) {
					PositionIterator pi = index.getPositionIterator(0, i);
					final int[] pos = pi.getPos();

					pos[0] = i-1;
					pos[i] = j;
					while (pi.hasNext()) {
						index.set(j, pos);
					}
				}
			}
		}
		return index;
	}

	/**
	 * Get the centroid value of a dataset, this function works out the centroid in every direction
	 * 
	 * @param a
	 *            the dataset to be analysed
	 * @param bases the optional array of base coordinates to use as weights.
	 * This defaults to the mid-point of indices
	 * @return a double array containing the centroid for each dimension
	 */
	public static double[] centroid(Dataset a, Dataset... bases) {
		int rank = a.getRank();
		if (bases.length > 0 && bases.length != rank) {
			throw new IllegalArgumentException("Number of bases must be zero or match rank of dataset");
		}
		
		int[] shape = a.getShapeRef();
		if (bases.length == rank) {
			for (int i = 0; i < rank; i++) {
				Dataset b = bases[i];
				if (b.getRank() != 1 && b.getSize() != shape[i]) {
					throw new IllegalArgumentException("A base does not have shape to match given dataset");
				}
			}
		}

		double[] dc = new double[rank];
		if (rank == 0)
			return dc;

		final PositionIterator iter = new PositionIterator(shape);
		final int[] pos = iter.getPos();

		double tsum = 0.0;
		while (iter.hasNext()) {
			double val = a.getDouble(pos);
			tsum += val;
			for (int d = 0; d < rank; d++) {
				Dataset b = bases.length == 0 ? null : bases[d];
				if (b == null) {
					dc[d] += (pos[d] + 0.5) * val;
				} else {
					dc[d] += b.getElementDoubleAbs(pos[d]) * val;
				}
			}
		}

		for (int d = 0; d < rank; d++) {
			dc[d] /= tsum;
		}
		return dc;
	}

	/**
	 * Find linearly-interpolated crossing points where the given dataset crosses the given value
	 * 
	 * @param d
	 * @param value
	 * @return list of interpolated indices
	 */
	public static List<Double> crossings(Dataset d, double value) {
		if (d.getRank() != 1) {
			utilsLogger.error("Only 1d datasets supported");
			throw new UnsupportedOperationException("Only 1d datasets supported");
		}
		List<Double> results = new ArrayList<Double>();

		// run through all pairs of points on the line and see if value lies within
		IndexIterator it = d.getIterator();
		double y1, y2;

		y2 = it.hasNext() ? y2 = d.getElementDoubleAbs(it.index) : 0;
		double x = 1;
		while (it.hasNext()) {
			y1 = y2;
			y2 = d.getElementDoubleAbs(it.index);
			// check if value lies within pair [y1, y2]
			if ((y1 <= value && value < y2) || (y1 > value && y2 <= value)) {
				final double f = (value - y2)/(y2 - y1); // negative distance from right to left
				results.add(x + f);
			}
			x++;
		}
		if (y2 == value) { // add end point of it intersects
			results.add(x);
		}

		return results;
	}

	/**
	 * Find x values of all the crossing points of the dataset with the given y value
	 * 
	 * @param xAxis
	 *            Dataset of the X axis that needs to be looked at
	 * @param yAxis
	 *            Dataset of the Y axis that needs to be looked at
	 * @param yValue
	 *            The y value the X values are required for
	 * @return An list of doubles containing all the X coordinates of where the line crosses
	 */
	public static List<Double> crossings(Dataset xAxis, Dataset yAxis, double yValue) {
		List<Double> results = new ArrayList<Double>();

		List<Double> indices = crossings(yAxis, yValue);

		for (double xi : indices) {
			results.add(Maths.interpolate(xAxis, xi));
		}
		return results;
	}

	/**
	 * Function that uses the crossings function but prunes the result, so that multiple crossings within a
	 * certain proportion of the overall range of the x values
	 * 
	 * @param xAxis
	 *            Dataset of the X axis
	 * @param yAxis
	 *            Dataset of the Y axis
	 * @param yValue
	 *            The y value the x values are required for
	 * @param xRangeProportion
	 *            The proportion of the overall x spread used to prune result
	 * @return A list containing all the unique crossing points
	 */
	public static List<Double> crossings(Dataset xAxis, Dataset yAxis, double yValue, double xRangeProportion) {
		// get the values found
		List<Double> vals = crossings(xAxis, yAxis, yValue);

		// use the proportion to calculate the error spacing
		double error = xRangeProportion * xAxis.peakToPeak().doubleValue();

		int i = 0;
		// now go through and check for groups of three crossings which are all
		// within the boundaries
		while (i < vals.size() - 3) {
			double v1 = Math.abs(vals.get(i) - vals.get(i + 2));
			if (v1 < error) {
				// these 3 points should be treated as one
				// make the first point equal to the average of them all
				vals.set(i + 2, ((vals.get(i) + vals.get(i + 1) + vals.get(i + 2)) / 3.0));
				// remove the other offending points
				vals.remove(i);
				vals.remove(i);
			} else {
				i++;
			}
		}

		// once the thinning process has been completed, return the pruned list
		return vals;
	}

	// recursive function
	private static void setRow(Object row, Dataset a, int... pos) {
		final int l = Array.getLength(row);
		final int rank = pos.length;
		final int[] npos = Arrays.copyOf(pos, rank+1);
		Object r;
		if (rank+1 < a.getRank()) {
			for (int i = 0; i < l; i++) {
				npos[rank] = i;
				r = Array.get(row, i);
				setRow(r, a, npos);
			}
		} else {
			for (int i = 0; i < l; i++) {
				npos[rank] = i;
				r = a.getObject(npos);
				Array.set(row, i, r);
			}
		}
	}

	/**
	 * Create Java array (of arrays) from dataset
	 * @param a dataset
	 * @return Java array (of arrays...)
	 */
	public static Object createJavaArray(Dataset a) {
		if (a.getElementsPerItem() > 1) {
			a = createDatasetFromCompoundDataset((CompoundDataset) a, true);
		}
		Object matrix;

		switch (a.getDType()) {
		case Dataset.BOOL:
			matrix = Array.newInstance(boolean.class, a.getShape());
			break;
		case Dataset.INT8:
			matrix = Array.newInstance(byte.class, a.getShape());
			break;
		case Dataset.INT16:
			matrix = Array.newInstance(short.class, a.getShape());
			break;
		case Dataset.INT32:
			matrix = Array.newInstance(int.class, a.getShape());
			break;
		case Dataset.INT64:
			matrix = Array.newInstance(long.class, a.getShape());
			break;
		case Dataset.FLOAT32:
			matrix = Array.newInstance(float.class, a.getShape());
			break;
		case Dataset.FLOAT64:
			matrix = Array.newInstance(double.class, a.getShape());
			break;
		default:
			utilsLogger.error("Dataset type not supported");
			throw new IllegalArgumentException("Dataset type not supported");
		}

		// populate matrix
		setRow(matrix, a);
		return matrix;
	}
	
	/**
	 * Removes NaNs and infinities from floating point datasets.
	 * All other dataset types are ignored.
	 * 
	 * @param a dataset
	 * @param value replacement value
	 */
	public static void removeNansAndInfinities(Dataset a, final Number value) {
		if (a instanceof DoubleDataset) {
			final double dvalue = DTypeUtils.toReal(value);
			final DoubleDataset set = (DoubleDataset) a;
			final IndexIterator it = set.getIterator();
			final double[] data = set.getData();
			while (it.hasNext()) {
				double x = data[it.index];
				if (Double.isNaN(x) || Double.isInfinite(x))
					data[it.index] = dvalue;
			}
		} else if (a instanceof FloatDataset) {
			final float fvalue = (float) DTypeUtils.toReal(value);
			final FloatDataset set = (FloatDataset) a;
			final IndexIterator it = set.getIterator();
			final float[] data = set.getData();
			while (it.hasNext()) {
				float x = data[it.index];
				if (Float.isNaN(x) || Float.isInfinite(x))
					data[it.index] = fvalue;
			}
		} else if (a instanceof CompoundDoubleDataset) {
			final double dvalue = DTypeUtils.toReal(value);
			final CompoundDoubleDataset set = (CompoundDoubleDataset) a;
			final int is = set.getElementsPerItem();
			final IndexIterator it = set.getIterator();
			final double[] data = set.getData();
			while (it.hasNext()) {
				for (int j = 0; j < is; j++) {
					double x = data[it.index + j];
					if (Double.isNaN(x) || Double.isInfinite(x))
						data[it.index + j] = dvalue;
				}
			}
		} else if (a instanceof CompoundFloatDataset) {
			final float fvalue = (float) DTypeUtils.toReal(value);
			final CompoundFloatDataset set = (CompoundFloatDataset) a;
			final int is = set.getElementsPerItem();
			final IndexIterator it = set.getIterator();
			final float[] data = set.getData();
			while (it.hasNext()) {
				for (int j = 0; j < is; j++) {
					float x = data[it.index + j];
					if (Float.isNaN(x) || Float.isInfinite(x))
						data[it.index + j] = fvalue;
				}
			}
		}
	}

	/**
	 * Make floating point datasets contain only finite values. Infinities and NaNs are replaced
	 * by +/- MAX_VALUE and 0, respectively.
	 * All other dataset types are ignored.
	 * 
	 * @param a dataset
	 */
	public static void makeFinite(Dataset a) {
		if (a instanceof DoubleDataset) {
			final DoubleDataset set = (DoubleDataset) a;
			final IndexIterator it = set.getIterator();
			final double[] data = set.getData();
			while (it.hasNext()) {
				final double x = data[it.index];
				if (Double.isNaN(x))
					data[it.index] = 0;
				else if (Double.isInfinite(x))
					data[it.index] = x > 0 ? Double.MAX_VALUE : -Double.MAX_VALUE;
			}
		} else if (a instanceof FloatDataset) {
			final FloatDataset set = (FloatDataset) a;
			final IndexIterator it = set.getIterator();
			final float[] data = set.getData();
			while (it.hasNext()) {
				final float x = data[it.index];
				if (Float.isNaN(x))
					data[it.index] = 0;
				else if (Float.isInfinite(x))
					data[it.index] = x > 0 ? Float.MAX_VALUE : -Float.MAX_VALUE;
			}
		} else if (a instanceof CompoundDoubleDataset) {
			final CompoundDoubleDataset set = (CompoundDoubleDataset) a;
			final int is = set.getElementsPerItem();
			final IndexIterator it = set.getIterator();
			final double[] data = set.getData();
			while (it.hasNext()) {
				for (int j = 0; j < is; j++) {
					final double x = data[it.index + j];
					if (Double.isNaN(x))
						data[it.index + j] = 0;
					else if (Double.isInfinite(x))
						data[it.index + j] = x > 0 ? Double.MAX_VALUE : -Double.MAX_VALUE;
				}
			}
		} else if (a instanceof CompoundFloatDataset) {
			final CompoundFloatDataset set = (CompoundFloatDataset) a;
			final int is = set.getElementsPerItem();
			final IndexIterator it = set.getIterator();
			final float[] data = set.getData();
			while (it.hasNext()) {
				for (int j = 0; j < is; j++) {
					final float x = data[it.index + j];
					if (Float.isNaN(x))
						data[it.index + j] = 0;
					else if (Float.isInfinite(x))
						data[it.index + j] = x > 0 ? Float.MAX_VALUE : -Float.MAX_VALUE;
				}
			}
		}
	}

	/**
	 * Find absolute index of first value in dataset that is equal to given number
	 * @param a
	 * @param n
	 * @return absolute index (if greater than a.getSize() then no value found)
	 */
	public static int findIndexEqualTo(final Dataset a, final double n) {
		IndexIterator iter = a.getIterator();
		while (iter.hasNext()) {
			if (a.getElementDoubleAbs(iter.index) == n)
				break;
		}

		return iter.index;
	}

	/**
	 * Find absolute index of first value in dataset that is greater than given number
	 * @param a
	 * @param n
	 * @return absolute index (if greater than a.getSize() then no value found)
	 */
	public static int findIndexGreaterThan(final Dataset a, final double n) {
		IndexIterator iter = a.getIterator();
		while (iter.hasNext()) {
			if (a.getElementDoubleAbs(iter.index) > n)
				break;
		}

		return iter.index;
	}

	/**
	 * Find absolute index of first value in dataset that is greater than or equal to given number
	 * @param a
	 * @param n
	 * @return absolute index (if greater than a.getSize() then no value found)
	 */
	public static int findIndexGreaterThanOrEqualTo(final Dataset a, final double n) {
		IndexIterator iter = a.getIterator();
		while (iter.hasNext()) {
			if (a.getElementDoubleAbs(iter.index) >= n)
				break;
		}

		return iter.index;
	}

	/**
	 * Find absolute index of first value in dataset that is less than given number
	 * @param a
	 * @param n
	 * @return absolute index (if greater than a.getSize() then no value found)
	 */
	public static int findIndexLessThan(final Dataset a, final double n) {
		IndexIterator iter = a.getIterator();
		while (iter.hasNext()) {
			if (a.getElementDoubleAbs(iter.index) < n)
				break;
		}

		return iter.index;
	}

	/**
	 * Find absolute index of first value in dataset that is less than or equal to given number
	 * @param a
	 * @param n
	 * @return absolute index (if greater than a.getSize() then no value found)
	 */
	public static int findIndexLessThanOrEqualTo(final Dataset a, final double n) {
		IndexIterator iter = a.getIterator();
		while (iter.hasNext()) {
			if (a.getElementDoubleAbs(iter.index) <= n)
				break;
		}

		return iter.index;
	}

	/**
	 * Find first occurrences in one dataset of values given in another sorted dataset  
	 * @param a
	 * @param values sorted 1D dataset of values to find
	 * @return absolute indexes of those first occurrences (-1 is used to indicate value not found)
	 */
	public static IntegerDataset findFirstOccurrences(final Dataset a, final Dataset values) {
		if (values.getRank() != 1) {
			throw new IllegalArgumentException("Values dataset must be 1D");
		}
		IntegerDataset indexes = new IntegerDataset(values.getSize());
		indexes.fill(-1);

		IndexIterator it = a.getIterator();
		final int n = values.getSize();
		if (values.getDType() == Dataset.INT64) {
			while (it.hasNext()) {
				long x = a.getElementLongAbs(it.index);
	
				int l = 0; // binary search to find value in sorted dataset
				long vl = values.getLong(l);
				if (x <= vl) {
					if (x == vl && indexes.getAbs(l) < 0)
						indexes.setAbs(l, it.index);
					continue;
				}
				int h = n - 1;
				long vh = values.getLong(h);
				if (x >= vh) {
					if (x == vh && indexes.getAbs(h) < 0)
						indexes.setAbs(h, it.index);
					continue;
				}
				while (h - l > 1) {
					int m = (l + h) / 2;
					long vm = values.getLong(m);
					if (x < vm) {
						h = m;
					} else if (x > vm) {
						l = m;
					} else {
						if (indexes.getAbs(m) < 0)
							indexes.setAbs(m, it.index);
						break;
					}
				}
			}
		} else {
			while (it.hasNext()) {
				double x = a.getElementDoubleAbs(it.index);
	
				int l = 0; // binary search to find value in sorted dataset
				double vl = values.getDouble(l);
				if (x <= vl) {
					if (x == vl && indexes.getAbs(l) < 0)
						indexes.setAbs(l, it.index);
					continue;
				}
				int h = n - 1;
				double vh = values.getDouble(h);
				if (x >= vh) {
					if (x == vh && indexes.getAbs(h) < 0)
						indexes.setAbs(h, it.index);
					continue;
				}
				while (h - l > 1) {
					int m = (l + h) / 2;
					double vm = values.getDouble(m);
					if (x < vm) {
						h = m;
					} else if (x > vm) {
						l = m;
					} else {
						if (indexes.getAbs(m) < 0)
							indexes.setAbs(m, it.index);
						break;
					}
				}
			}
		}
		return indexes;
	}

	/**
	 * Find indexes in sorted dataset of values for each value in other dataset
	 * @param a
	 * @param values sorted 1D dataset of values to find
	 * @return absolute indexes of values (-1 is used to indicate value not found)
	 */
	public static IntegerDataset findIndexesForValues(final Dataset a, final Dataset values) {
		if (values.getRank() != 1) {
			throw new IllegalArgumentException("Values dataset must be 1D");
		}
		IntegerDataset indexes = new IntegerDataset(a.getSize());
		indexes.fill(-1);

		IndexIterator it = a.getIterator();
		int i = -1;
		final int n = values.getSize();
		if (values.getDType() == Dataset.INT64) {
			while (it.hasNext()) {
				i++;
				long x = a.getElementLongAbs(it.index);
	
				int l = 0; // binary search to find value in sorted dataset
				long vl = values.getLong(l);
				if (x <= vl) {
					if (x == vl)
						indexes.setAbs(i, l);
					continue;
				}
				int h = n - 1;
				long vh = values.getLong(h);
				if (x >= vh) {
					if (x == vh)
						indexes.setAbs(i, h);
					continue;
				}
				while (h - l > 1) {
					int m = (l + h) / 2;
					long vm = values.getLong(m);
					if (x < vm) {
						h = m;
					} else if (x > vm) {
						l = m;
					} else {
						indexes.setAbs(i, m);
						break;
					}
				}
			}
		} else {
			while (it.hasNext()) {
				i++;
				double x = a.getElementDoubleAbs(it.index);
	
				int l = 0; // binary search to find value in sorted dataset
				double vl = values.getDouble(l);
				if (x <= vl) {
					if (x == vl)
						indexes.setAbs(i, l);
					continue;
				}
				int h = n - 1;
				double vh = values.getDouble(h);
				if (x >= vh) {
					if (x == vh)
						indexes.setAbs(i, h);
					continue;
				}
				while (h - l > 1) {
					int m = (l + h) / 2;
					double vm = values.getDouble(m);
					if (x < vm) {
						h = m;
					} else if (x > vm) {
						l = m;
					} else {
						indexes.setAbs(i, m);
						break;
					}
				}
			}
		}

		return indexes;
	}

	/**
	 * Roll items over given axis by given amount
	 * @param a
	 * @param shift
	 * @param axis if null, then roll flattened dataset
	 * @return rolled dataset
	 */
	public static <T extends Dataset> T roll(final T a, final int shift, final Integer axis) {
		Dataset r = DatasetFactory.zeros(a);
		int is = a.getElementsPerItem();
		if (axis == null) {
			IndexIterator it = a.getIterator();
			int s = r.getSize();
			int i = shift % s;
			if (i < 0)
				i += s;
			while (it.hasNext()) {
				r.setObjectAbs(i, a.getObjectAbs(it.index));
				i += is;
				if (i >= s) {
					i %= s;
				}
			}
		} else {
			PositionIterator pi = a.getPositionIterator(axis);
			int s = a.getShapeRef()[axis];
			@SuppressWarnings("deprecation")
			Dataset u = DatasetFactory.zeros(is, new int[] {s}, a.getDType());
			Dataset v = DatasetFactory.zeros(u);
			int[] pos = pi.getPos();
			boolean[] hit = pi.getOmit();
			while (pi.hasNext()) {
				a.copyItemsFromAxes(pos, hit, u);
				int i = shift % s;
				if (i < 0)
					i += s;
				for (int j = 0; j < s; j++) {
					v.setObjectAbs(i, u.getObjectAbs(j*is));
					i += is;
					if (i >= s) {
						i %= s;
					}
				}
				r.setItemsOnAxes(pos, hit, v.getBuffer());
			}
		}
		return (T) r;
	}

	/**
	 * Roll the specified axis backwards until it lies in given position
	 * @param a
	 * @param axis The rolled axis (index in shape array). Other axes are left unchanged in relative positions 
	 * @param start The position with it right of the destination of the rolled axis
	 * @return dataset with rolled axis
	 */
	public static <T extends Dataset> T rollAxis(final T a, int axis, int start) {
		int r = a.getRank();
		if (axis < 0)
			axis += r;
		if (axis < 0 || axis >= r) {
			throw new IllegalArgumentException("Axis is out of range: it should be >= 0 and < " + r);
		}
		if (start < 0)
			start += r;
		if (start < 0 || start > r) {
			throw new IllegalArgumentException("Start is out of range: it should be >= 0 and <= " + r);
		}
		if (axis < start)
			start--;

		if (axis == start)
			return a;

		ArrayList<Integer> axes = new ArrayList<Integer>();
		for (int i = 0; i < r; i++) {
			if (i != axis) {
				axes.add(i);
			}
		}
		axes.add(start, axis);
		int[] aa = new int[r];
		for (int i = 0; i < r; i++) {
			aa[i] = axes.get(i);
		}
		return (T) a.getTransposedView(aa);
	}

	private static SliceND createFlippedSlice(final Dataset a, int axis) {
		int[] shape = a.getShapeRef();
		SliceND slice = new SliceND(shape);
		slice.flip(axis);
		return slice;
	}

	/**
	 * Flip items in left/right direction, column-wise, or along second axis 
	 * @param a dataset must be at least 2D
	 * @return view of flipped dataset
	 */
	public static <T extends Dataset> T flipLeftRight(final T a) {
		if (a.getRank() < 2) {
			throw new IllegalArgumentException("Dataset must be at least 2D");
		}
		return (T) a.getSliceView(createFlippedSlice(a, 1));
	}

	/**
	 * Flip items in up/down direction, row-wise, or along first axis 
	 * @param a dataset
	 * @return view of flipped dataset
	 */
	public static <T extends Dataset> T flipUpDown(final T a) {
		return (T) a.getSliceView(createFlippedSlice(a, 0));
	}

	/**
	 * Rotate items in first two dimension by 90 degrees anti-clockwise
	 * @param a dataset must be at least 2D
	 * @return view of flipped dataset
	 */
	public static <T extends Dataset> T rotate90(final T a) {
		return rotate90(a, 1);
	}

	/**
	 * Rotate items in first two dimension by 90 degrees anti-clockwise
	 * @param a dataset must be at least 2D
	 * @param k number of 90-degree rotations
	 * @return view of flipped dataset
	 */
	public static <T extends Dataset> T rotate90(final T a, int k) {
		k = k % 4;
		while (k < 0) {
			k += 4;
		}
		int r = a.getRank();
		if (r < 2) {
			throw new IllegalArgumentException("Dataset must be at least 2D");
		}
		switch (k) {
		case 1: case 3:
			int[] axes = new int[r];
			axes[0] = 1;
			axes[1] = 0;
			for (int i = 2; i < r; i++) {
				axes[i] = i;
			}
			Dataset t = a.getTransposedView(axes);
			return (T) t.getSliceView(createFlippedSlice(t, k == 1 ? 0 : 1));
		case 2:
			SliceND s = createFlippedSlice(a, 0);
			s.flip(1);
			return (T) a.getSliceView(s);
		default:
		case 0:
			return a;
		}
	}

	/**
	 * Select content according where condition is true. All inputs are broadcasted to a maximum shape
	 * @param condition boolean dataset
	 * @param x
	 * @param y
	 * @return dataset where content is x or y depending on whether condition is true or otherwise 
	 */
	public static Dataset select(BooleanDataset condition, Object x, Object y) {
		Object[] all = new Object[] {condition, x, y};
		Dataset[] dAll = BroadcastUtils.convertAndBroadcast(all);
		condition = (BooleanDataset) dAll[0];
		Dataset dx = dAll[1];
		Dataset dy = dAll[2];
		int dt = DTypeUtils.getBestDType(dx.getDType(),dy.getDType());
		int ds = Math.max(dx.getElementsPerItem(), dy.getElementsPerItem());

		@SuppressWarnings("deprecation")
		Dataset r = DatasetFactory.zeros(ds, condition.getShapeRef(), dt);
		IndexIterator iter = condition.getIterator(true);
		final int[] pos = iter.getPos();
		int i = 0;
		while (iter.hasNext()) {
			r.setObjectAbs(i++, condition.getElementBooleanAbs(iter.index) ? dx.getObject(pos) : dy.getObject(pos));
		}
		return r;
	}

	/**
	 * Select content from choices where condition is true, otherwise use default. All inputs are broadcasted to a maximum shape
	 * @param conditions array of boolean datasets
	 * @param choices array of datasets or objects
	 * @param def default value (can be a dataset)
	 * @return dataset
	 */
	public static Dataset select(BooleanDataset[] conditions, Object[] choices, Object def) {
		final int n = conditions.length;
		if (choices.length != n) {
			throw new IllegalArgumentException("Choices list is not same length as conditions list");
		}
		Object[] all = new Object[2*n];
		System.arraycopy(conditions, 0, all, 0, n);
		System.arraycopy(choices, 0, all, n, n);
		Dataset[] dAll = BroadcastUtils.convertAndBroadcast(all);
		conditions = new BooleanDataset[n];
		Dataset[] dChoices = new Dataset[n];
		System.arraycopy(dAll, 0, conditions, 0, n);
		System.arraycopy(dAll, n, dChoices, 0, n);
		int dt = -1;
		int ds = -1;
		for (int i = 0; i < n; i++) {
			Dataset a = dChoices[i];
			int t = a.getDType();
			if (t > dt)
				dt = t;
			int s = a.getElementsPerItem();
			if (s > ds)
				ds = s;
		}
		if (dt < 0 || ds < 1) {
			throw new IllegalArgumentException("Dataset types of choices are invalid");
		}

		@SuppressWarnings("deprecation")
		Dataset r = DatasetFactory.zeros(ds, conditions[0].getShapeRef(), dt);
		Dataset d = DatasetFactory.createFromObject(def).getBroadcastView(r.getShapeRef());
		PositionIterator iter = new PositionIterator(r.getShapeRef());
		final int[] pos = iter.getPos();
		int i = 0;
		while (iter.hasNext()) {
			int j = 0;
			for (; j < n; j++) {
				if (conditions[j].get(pos)) {
					r.setObjectAbs(i++, dChoices[j].getObject(pos));
					break;
				}
			}
			if (j == n) {
				r.setObjectAbs(i++, d.getObject(pos));
			}
		}
		return r;
	}

	/**
	 * Choose content from choices where condition is true, otherwise use default. All inputs are broadcasted to a maximum shape
	 * @param index integer dataset (ideally, items should be in [0, n) range, if there are n choices)
	 * @param choices array of datasets or objects
	 * @param throwAIOOBE if true, throw array index out of bound exception
	 * @param clip true to clip else wrap indices out of bounds; only used when throwAOOBE is false
	 * @return dataset
	 */
	public static Dataset choose(IntegerDataset index, Object[] choices, boolean throwAIOOBE, boolean clip) {
		final int n = choices.length;
		Object[] all = new Object[n + 1];
		System.arraycopy(choices, 0, all, 0, n);
		all[n] = index;
		Dataset[] dChoices = BroadcastUtils.convertAndBroadcast(all);
		int dt = -1;
		int ds = -1;
		int mr = -1;
		for (int i = 0; i < n; i++) {
			Dataset a = dChoices[i];
			int r = a.getRank();
			if (r > mr)
				mr = r;
			int t = a.getDType();
			if (t > dt)
				dt = t;
			int s = a.getElementsPerItem();
			if (s > ds)
				ds = s;
		}
		if (dt < 0 || ds < 1) {
			throw new IllegalArgumentException("Dataset types of choices are invalid");
		}
		index = (IntegerDataset) dChoices[n];
		dChoices[n] = null;

		@SuppressWarnings("deprecation")
		Dataset r = DatasetFactory.zeros(ds, index.getShape(), dt);
		IndexIterator iter = index.getIterator(true);
		final int[] pos = iter.getPos();
		int i = 0;
		while (iter.hasNext()) {
			int j = index.getAbs(iter.index);
			if (j < 0) {
				if (throwAIOOBE)
					throw new ArrayIndexOutOfBoundsException(j);
				if (clip) {
					j = 0;
				} else {
					j %= n;
					j += n; // as remainder still negative
				}
			}
			if (j >= n) {
				if (throwAIOOBE)
					throw new ArrayIndexOutOfBoundsException(j);
				if (clip) {
					j = n - 1;
				} else {
					j %= n;
				}
			}
			Dataset c = dChoices[j];
			r.setObjectAbs(i++, c.getObject(pos));
		}
		return r;
	}

	/**
	 * Calculate positions in given shape from a dataset of 1-D indexes
	 * @param indices
	 * @param shape
	 * @return list of positions as integer datasets
	 */
	public static List<IntegerDataset> calcPositionsFromIndexes(Dataset indices, int[] shape) {
		int rank = shape.length;
		List<IntegerDataset> posns = new ArrayList<IntegerDataset>();
		int[] iShape = indices.getShapeRef();
		for (int i = 0; i < rank; i++) {
			posns.add(new IntegerDataset(iShape));
		}
		IndexIterator it = indices.getIterator(true);
		int[] pos = it.getPos();
		while (it.hasNext()) {
			int n = indices.getInt(pos);
			int[] p = ShapeUtils.getNDPositionFromShape(n, shape);
			for (int i = 0; i < rank; i++) {
				posns.get(i).setItem(p[i], pos);
			}
		}
		return posns;
	}


	/**
	 * Calculate indexes in given shape from datasets of position
	 * @param positions as a list of datasets where each holds the position in a dimension
	 * @param shape
	 * @param mode either null, zero-length, unit length or length of rank of shape where
	 *  0 = raise exception, 1 = wrap, 2 = clip
	 * @return indexes as an integer dataset
	 */
	public static IntegerDataset calcIndexesFromPositions(List<? extends Dataset> positions, int[] shape, int... mode) {
		int rank = shape.length;
		if (positions.size() != rank) {
			throw new IllegalArgumentException("Number of position datasets must be equal to rank of shape");
		}

		if (mode == null || mode.length == 0) {
			mode = new int[rank];
		} else if (mode.length == 1) {
			int m = mode[0];
			mode = new int[rank];
			Arrays.fill(mode, m);
		} else if (mode.length != rank) {
			throw new IllegalArgumentException("Mode length greater than one must match rank of shape");
		}
		for (int i = 0; i < rank; i++) {
			int m = mode[i];
			if (m < 0 || m > 2) {
				throw new IllegalArgumentException("Unknown mode value - it must be 0, 1, or 2");
			}
		}

		Dataset p = positions.get(0);
		IntegerDataset indexes = new IntegerDataset(p.getShapeRef());
		IndexIterator it = p.getIterator(true);
		int[] iPos = it.getPos();
		int[] tPos = new int[rank];
		while (it.hasNext()) {
			for (int i = 0; i < rank; i++) {
				p = positions.get(i);
				int j = p.getInt(iPos);
				int d = shape[i];
				if (mode[i] == 0) {
					if (j < 0 || j >= d) {
						throw new ArrayIndexOutOfBoundsException("Position value exceeds dimension in shape");
					}
				} else if (mode[i] == 1) {
					while (j < 0)
						j += d;
					while (j >= d)
						j -= d;
				} else {
					if (j < 0)
						j = 0;
					if (j >= d)
						j = d - 1;
				}
				tPos[i] = j;
			}
			indexes.set(ShapeUtils.getFlat1DIndex(shape, tPos), iPos);
		}

		return indexes;
	}

	/**
	 * Serialize dataset by flattening it. Discards metadata
	 * @param data
	 * @return some java array
	 */
	public static Serializable serializeDataset(final IDataset data) {
		Dataset d = convertToDataset(data.getSliceView());
		d.clearMetadata(null);
		return d.flatten().getBuffer();
	}

	/**
	 * Extract values where condition is non-zero. This is similar to Dataset#getByBoolean but supports broadcasting
	 * @param data
	 * @param condition should be broadcastable to data
	 * @return 1-D dataset of values
	 */
	@SuppressWarnings("deprecation")
	public static Dataset extract(final IDataset data, final IDataset condition) {
		Dataset a = convertToDataset(data.getSliceView());
		Dataset b = cast(condition.getSliceView(), Dataset.BOOL);

		try {
			return a.getByBoolean(b);
		} catch (IllegalArgumentException e) {
			final int length = ((Number) b.sum()).intValue();
	
			BroadcastPairIterator it = new BroadcastPairIterator(a, b, null, false);
			int size = ShapeUtils.calcSize(it.getShape());
			Dataset c;
			if (length < size) {
				int[] ashape = it.getFirstShape();
				int[] bshape = it.getSecondShape();
				int r = ashape.length;
				size = length;
				for (int i = 0; i < r; i++) {
					int s = ashape[i];
					if (s > 1 && bshape[i] == 1) {
						size *= s;
					}
				}
			}
			c = DatasetFactory.zeros(new int[] {size}, a.getDType());
	
			int i = 0;
			if (it.isOutputDouble()) {
				while (it.hasNext()) {
					if (it.bLong != 0) {
						c.setObjectAbs(i++, it.aDouble);
					}
				}
			} else {
				while (it.hasNext()) {
					if (it.bLong != 0) {
						c.setObjectAbs(i++, it.aLong);
					}
				}
			}
	
			return c;
		}
	}
}
