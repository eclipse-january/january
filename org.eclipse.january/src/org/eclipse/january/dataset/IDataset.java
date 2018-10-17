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

import java.text.Format;

import org.eclipse.january.metadata.IMetadata;


/**
 * This interface defines the implementation-independent and generic parts of a dataset.
 * <p>
 * The position array used in the getters
 */
public interface IDataset extends ILazyDataset {
	/**
	 * Set string output format
	 * @param format
	 */
	public void setStringFormat(Format format);

	/**
	 * @return Size of an item in dataset in bytes
	 */
	public int getItemBytes();

	/**
	 * @param pos
	 * @return Item in given position as an object
	 */
	public Object getObject(final int... pos);

	/**
	 * @param pos
	 * @return Item in given position as a string
	 */
	public String getString(final int... pos);

	/**
	 * @param pos
	 * @return Item in given position as a double
	 */
	public double getDouble(final int... pos);

	/**
	 * @param pos
	 * @return Item in given position as a long
	 */
	public long getLong(final int... pos);

	/**
	 * @param pos
	 * @return Item in given position as a float
	 */
	public float getFloat(final int... pos);

	/**
	 * @param pos
	 * @return Item in given position as an int
	 */
	public int getInt(final int... pos);

	/**
	 * @param pos
	 * @return Item in given position as a short
	 */
	public short getShort(final int... pos);

	/**
	 * @param pos
	 * @return Item in given position as a byte
	 */
	public byte getByte(final int... pos);

	/**
	 * @param pos
	 * @return Item in given position as a boolean
	 */
	public boolean getBoolean(final int... pos);

	/**
	 * Set the value given by object at given position
	 * @param obj
	 * @param pos
	 */
	public void set(final Object obj, final int... pos);

	/**
	 * Change shape and size of dataset in-place
	 * @param newShape
	 */
	public void resize(int... newShape);

	@Override
	public IDataset squeezeEnds();

	/**
	 * Remove dimensions of 1 in shape of the dataset
	 */
	public IDataset squeeze();

	/**
	 * Remove dimensions of 1 in shape of the dataset from ends only if true
	 * 
	 * @param onlyFromEnds
	 */
	public IDataset squeeze(boolean onlyFromEnds);

	/**
	 * @param ignoreInvalids - Can be null, empty, or one or more booleans. By default, all booleans
	 * are false. If the first boolean is true, will ignore NaNs and ignore infinities. Use the second
	 * boolean to ignore infinities separately.
	 * @return Maximum value
	 * @throws UnsupportedOperationException if comparisons are not valid
	 */
	public Number max(boolean... ignoreInvalids);

	/**
	 * @param ignoreInvalids - see {@link #max(boolean...)}
	 * @return mean of all items in dataset as a double, array of doubles or a complex number
	 */
	public Object mean(boolean... ignoreInvalids);

	/**
	 * @param ignoreInvalids - see {@link #max(boolean...)}
	 * @return Minimum value
	 * @throws UnsupportedOperationException if comparisons are not valid
	 */
	public Number min(boolean... ignoreInvalids);

	/**
	 * @param ignoreInvalids - see {@link #max(boolean...)}
	 * @return Position of minimum value (or first position if there are more than one)
	 * @since 2.0
	 */
	public int[] minPos(boolean... ignoreInvalids);

	/**
	 * @param ignoreInvalids - see {@link #max(boolean...)}
	 * @return Position of maximum value (or first position if there are more than one)
	 * @since 2.0
	 */
	public int[] maxPos(boolean... ignoreInvalids);

	/**
	 * Clone dataset, making new copy of data
	 * @return a (deep) copy of dataset
	 */
	@Override
	public IDataset clone();

	/**
	 * @deprecated Use {@code getFirstMetadata(IMetadata.class)} instead
	 * @return an instance of IMetadata, may be null
	 */
	@Override
	@Deprecated
	public IMetadata getMetadata();

	@Override
	public IDataset getSlice(int[] start, int[] stop, int[] step);

	@Override
	public IDataset getSlice(Slice... slice);

	@Override
	public IDataset getSlice(SliceND slice);

	
	/**
	 * Get a slice of the dataset. The returned dataset is a view on a selection of items
	 * 
	 * @param start
	 *            specifies the starting indexes (can be null for origin)
	 * @param stop
	 *            specifies the stopping indexes (can be null for end)
	 * @param step
	 *            specifies the steps in the slice (can be null for unit steps)
	 * @return The sliced view of a dataset
	 */
	@Override
	public IDataset getSliceView(int[] start, int[] stop, int[] step);

	/**
	 * Get a slice of the dataset. The returned dataset is a view on a selection of items
	 * 
	 * @param slice an array of slice objects (the array can be null or contain nulls)
	 * @return The sliced view of a dataset
	 */
	@Override
	public IDataset getSliceView(Slice... slice);

	/**
	 * Get a slice of the dataset. The returned dataset is a view on a selection of items
	 * 
	 * @param slice an nD slice object
	 * @return The sliced view of a dataset
	 */
	@Override
	public IDataset getSliceView(SliceND slice);

	/**
	 * Permute copy of dataset's axes so that given order is old order:
	 * 
	 * <pre>{@literal
	 *  axisPerm = (p(0), p(1),...) => newdata(n(0), n(1),...) = olddata(o(0), o(1), ...)
	 *  such that n(i) = o(p(i)) for all i
	 * }</pre>
	 * 
	 * I.e. for a 3D dataset (1,0,2) implies the new dataset has its 1st dimension running along
	 * the old dataset's 2nd dimension and the new 2nd is the old 1st. The 3rd dimension is left
	 * unchanged.
	 * 
	 * @param axes
	 *            if zero length then axes order reversed
	 * @return remapped view of data
	 */
	@Override
	IDataset getTransposedView(int... axes);

	/**
	 * 
	 * @return the error dataset, constructing one if necessary
	 * @since 2.0
	 */
	@Override
	public IDataset getErrors();

	/**
	 * Get the error for a given position.
	 * @param pos
	 * @return error value (symmetric)
	 */
	public double getError(int... pos);

	/**
	 * Get the error values for a single point in the dataset
	 * @param pos of the point to be referenced 
	 * @return the values of the error at this point (can be null when no error defined)
	 */
	public double[] getErrorArray(int... pos);
}
