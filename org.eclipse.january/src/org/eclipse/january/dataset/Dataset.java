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

import org.eclipse.january.IMonitor;

/**
 * <p>
 * Interface for our implementation of dataset that adds a lot of extra functionality.
 * </p>
 * <p>
 * <b>Warning:</b>
 * It is important to note that methods (get*Abs() and set*Abs()) which use the absolute
 * index <emph>must</emph> be used with care. In (sliced) views of datasets, neighbouring
 * positions do not necessarily correspond to contiguous indexes. This is also the case
 * with multi-element (or compound) items. Therefore index iterators should be used in
 * conjunction with these methods unless the dataset can be proven to be not a view or
 * be a wholly contiguous slice of a dataset; a copy or new dataset satisfies this criterion.
 * </p>
 */
public interface Dataset extends IDataset {
	/**
	 * Boolean
	 */
	public static final int BOOL = 0;

	/**
	 * Signed 8-bit integer
	 */
	public static final int INT8 = 1;

	/**
	 * Signed 16-bit integer
	 */
	public static final int INT16 = 2;

	/**
	 * Signed 32-bit integer
	 */
	public static final int INT32 = 3;
	/**
	 * Integer (same as signed 32-bit integer)
	 */
	public static final int INT = INT32;

	/**
	 * Signed 64-bit integer
	 */
	public static final int INT64 = 4;

	/**
	 * 32-bit floating point
	 */
	public static final int FLOAT32 = 5;

	/**
	 * 64-bit floating point
	 */
	public static final int FLOAT64 = 6;

	/**
	 * Floating point (same as 64-bit floating point)
	 */
	public static final int FLOAT = FLOAT64;

	/**
	 * 64-bit complex floating point (real and imaginary parts are 32-bit floats)
	 */
	public static final int COMPLEX64 = 7;

	/**
	 * 128-bit complex floating point (real and imaginary parts are 64-bit floats)
	 */
	public static final int COMPLEX128 = 8;

	/**
	 * Complex floating point (same as 64-bit floating point)
	 */
	public static final int COMPLEX = COMPLEX128;

	/**
	 * String
	 */
	public static final int STRING = 9;
	
	/**
	 * Object
	 */
	public static final int OBJECT = 10;

	/**
	 * Date
	 */
	public static final int DATE = 11;

	static final int ARRAYMUL = 100;

	/**
	 * Array of signed 8-bit integers
	 */
	public static final int ARRAYINT8 = ARRAYMUL * INT8;

	/**
	 * Array of signed 16-bit integers
	 */
	public static final int ARRAYINT16 = ARRAYMUL * INT16;

	/**
	 * Array of three signed 16-bit integers for RGB values
	 */
	public static final int RGB = ARRAYINT16 + 3;

	/**
	 * Array of signed 32-bit integers
	 */
	public static final int ARRAYINT32 = ARRAYMUL * INT32;

	/**
	 * Array of signed 64-bit integers
	 */
	public static final int ARRAYINT64 = ARRAYMUL * INT64;

	/**
	 * Array of 32-bit floating points
	 */
	public static final int ARRAYFLOAT32 = ARRAYMUL * FLOAT32;

	/**
	 * Array of 64-bit floating points
	 */
	public static final int ARRAYFLOAT64 = ARRAYMUL * FLOAT64;

	/**
	 * Update this when there are any serious changes to API
	 */
	static final long serialVersionUID = -6891075135217265625L;

	/**
	 * The shape (or array of lengths for each dimension) of the dataset can be empty for zero-rank
	 * datasets and null for null datasets
	 * 
	 * @return reference of shape of dataset
	 */
	public int[] getShapeRef();

	/**
	 * @return type of dataset item
	 */
	public int getDType();

	/**
	 * @return a stride array (can be null)
	 */
	public int[] getStrides();

	/**
	 * @return offset where dataset view begins
	 */
	public int getOffset();

	/**
	 * @return true if dataset has elements which are floating point values
	 */
	public boolean hasFloatingPointElements();

	/**
	 * @return number of bytes used
	 */
	public int getNbytes();

	/**
	 * @return the buffer that backs the dataset
	 */
	public Serializable getBuffer();

	/**
	 * Set the buffer that backs the dataset and its shape
	 * <p>This is very, very <b>dangerous</b>. Please use carefully
	 * @param buffer (can be null to leave unchanged)
	 * @param shape (can be null to leave unchanged)
	 */
	public void overrideInternal(Serializable buffer, int... shape);

	/**
	 * This is a <b>synchronized</b> version of the clone method
	 * 
	 * @return a copy of dataset
	 */
	public Dataset synchronizedCopy();

	/**
	 * @param deepCopyMetadata if true then deep-copy metadata
	 * @return whole view of dataset (i.e. data buffer is shared)
	 */
	public Dataset getView(boolean deepCopyMetadata);

	/**
	 * @return view of dataset that is broadcasted to given shape
	 */
	public Dataset getBroadcastView(int... shape);

	/**
	 * @param showData
	 * @return string representation
	 */
	public String toString(boolean showData);

	@Override
	public Dataset squeezeEnds();

	@Override
	public Dataset squeeze();

	@Override
	public Dataset squeeze(boolean onlyFromEnds);

	@Override
	public Dataset clone();

	/**
	 * This method allows anything that dirties the dataset to clear various metadata values
	 * so that the other methods can work correctly.
	 */
	public void setDirty();

	/**
	 * This method calculates the n-dimensional position in the dataset of
	 * the given index in the data array
	 * 
	 * @param n
	 *            The index in the array
	 * @return the corresponding [a,b,...,n] position in the dataset
	 */
	public int[] getNDPosition(int n);

	/**
	 * This method calculates the index in the data array that corresponds to
	 * the given n-dimensional position
	 * 
	 * @param n
	 *            the integer array specifying the n-D position
	 * @return the index on the data array corresponding to that location
	 */
	public int get1DIndex(final int... n);

	/**
	 * Check that axis is in range [-rank,rank)
	 * 
	 * @param axis
	 * @return sanitized axis in range [0, rank)
	 */
	public int checkAxis(int axis);

	/**
	 * This method takes a dataset and checks its shape against the current dataset. If they are
	 * both of the same size, then this returns true otherwise it returns false.
	 * 
	 * @param g
	 *            The dataset to be compared
	 * @return true if shapes are compatible
	 */
	public boolean isCompatibleWith(ILazyDataset g);

	/**
	 * This method takes a dataset and checks its shape against the current dataset. If they are
	 * both of the same size, then this returns with no error, if there is a problem, then an error
	 * is thrown.
	 * 
	 * @param g
	 *            The dataset to be compared
	 * @throws IllegalArgumentException
	 *             This will be thrown if there is a problem with the compatibility
	 */
	public void checkCompatibility(ILazyDataset g) throws IllegalArgumentException;

	/**
	 * Returns new dataset with new shape but old data if possible, otherwise a copy is made
	 * 
	 * @param shape
	 *            new shape
	 */
	public Dataset reshape(int... shape);

	/**
	 * @return true if dataset is complex
	 */
	public boolean isComplex();

	/**
	 * @return real part of dataset (if necessary, as new dataset)
	 * @since 2.0
	 */
	public Dataset getRealPart();

	/**
	 * @return real part of dataset as a view
	 */
	public Dataset getRealView();

	/**
	 * Get the error array from the dataset of same shape. This will create a new dataset
	 * if the error set was of lower rank
	 *
	 * @return the dataset which contains the error information (can be null)
	 * @since 2.0
	 */
	@Override
	public Dataset getErrors();

	/**
	 * Get the (un-broadcasted) dataset that backs the (squared) error data
	 *
	 * @return the dataset which contains the (squared) error information (can be null)
	 */
	public Dataset getErrorBuffer();

	/**
	 * Set the buffer that backs the (squared) error data
	 *
	 * @buffer the buffer which contains the (squared) error information (can be null)
	 */
	public void setErrorBuffer(Serializable buffer);

	/**
	 * Copy and cast a dataset
	 * 
	 * @param dtype
	 *            dataset type
	 * @return a converted copy of the dataset
	 */
	public Dataset copy(int dtype);

	/**
	 * Copy and cast a dataset
	 * 
	 * @param clazz dataset class
	 * @return a converted copy of the dataset
	 */
	public <T extends Dataset> T copy(Class<T> clazz);

	/**
	 * Cast a dataset
	 * 
	 * @param dtype
	 *            dataset type
	 * @return a converted dataset
	 */
	public Dataset cast(int dtype);

	/**
	 * Cast a dataset
	 * 
	 * @param clazz dataset class
	 * @return a converted dataset
	 */
	public <T extends Dataset> T cast(Class<T> clazz);

	/**
	 * Cast a dataset
	 * 
	 * @param repeat
	 * @param dtype
	 *            dataset type
	 * @param isize
	 *            item size
	 * @return a converted dataset
	 */
	public Dataset cast(boolean repeat, int dtype, int isize);

	/**
	 * Generate an index dataset for current dataset
	 * 
	 * @return an index dataset
	 */
	public IntegerDataset getIndices();

	@Override
	public Dataset getTransposedView(int... axes);

	/**
	 * See {@link #getTransposedView}
	 * @return remapped copy of data
	 */
	public Dataset transpose(int... axes);

	/**
	 * Swap two axes in dataset
	 * 
	 * @param axis1
	 * @param axis2
	 * @return swapped view of dataset
	 */
	public Dataset swapAxes(int axis1, int axis2);

	/**
	 * Flatten shape
	 * 
	 * @return a flattened dataset which is a view if dataset is contiguous otherwise is a copy
	 */
	public Dataset flatten();

	/**
	 * Get unique items
	 * @return a sorted dataset of unique items
	 */
	public Dataset getUniqueItems();

	/**
	 * @param withPosition
	 *            set true if position is needed
	 * @return an IndexIterator tailored for this dataset
	 */
	public IndexIterator getIterator(boolean withPosition);

	/**
	 * @return an IndexIterator tailored for this dataset
	 */
	public IndexIterator getIterator();

	/**
	 * @param axes axes to omit from iterator
	 * @return a PositionIterator that misses out axes
	 */
	public PositionIterator getPositionIterator(int... axes);

	/**
	 * @param start
	 *            specifies the starting indexes
	 * @param stop
	 *            specifies the stopping indexes (nb, these are <b>not</b> included in the slice)
	 * @param step
	 *            specifies the steps in the slice
	 * @return an slice iterator that operates like an IndexIterator
	 */
	public IndexIterator getSliceIterator(int[] start, int[] stop, int[] step);

	/**
	 * Get a slice iterator that is defined by a starting position and a set of axes to include
	 * 
	 * @param pos
	 * @param axes
	 *            to include
	 * @return slice iterator
	 */
	public SliceIterator getSliceIteratorFromAxes(int[] pos, boolean[] axes);

	/**
	 * Copy content from axes in given position to array
	 * 
	 * @param pos
	 *            - null means position at origin
	 * @param axes
	 *            - true means copy
	 * @param dest
	 */
	public void copyItemsFromAxes(int[] pos, boolean[] axes, Dataset dest);

	/**
	 * Set content on axes in given position to values in array
	 * 
	 * @param pos
	 * @param axes
	 *            - true means copy
	 * @param src
	 */
	public void setItemsOnAxes(int[] pos, boolean[] axes, Object src);

	/**
	 * Get an iterator that visits every item in this dataset where the corresponding item in
	 * choice dataset is true
	 * 
	 * @param choice
	 * @return an iterator of dataset that visits items chosen by given choice dataset
	 */
	public BooleanIterator getBooleanIterator(Dataset choice);

	/**
	 * Get an iterator that visits every item in this dataset where the corresponding item in
	 * choice dataset is given by value
	 * 
	 * @param choice
	 * @param value
	 * @return an iterator of dataset that visits items chosen by given choice dataset
	 */
	public BooleanIterator getBooleanIterator(Dataset choice, boolean value);

	/**
	 * This is modelled after the NumPy get item with a condition specified by a boolean dataset
	 *
	 * @param selection
	 *            a boolean dataset of same shape to use for selecting items
	 * @return The new selected dataset
	 */
	public Dataset getByBoolean(Dataset selection);

	/**
	 * This is modelled after the NumPy set item with a condition specified by a boolean dataset
	 *
	 * @param obj
	 *            specifies the object used to set the selected items
	 * @param selection
	 *            a boolean dataset of same shape to use for selecting items
	 * 
	 * @return The dataset with modified content
	 */
	public Dataset setByBoolean(Object obj, Dataset selection);

	/**
	 * This is modelled after the NumPy get item with an index dataset
	 *
	 * @param index
	 *            an integer dataset
	 * @return The new selected dataset by indices
	 */
	public Dataset getBy1DIndex(IntegerDataset index);

	/**
	 * This is modelled after the NumPy get item with an array of indexing objects
	 *
	 * @param indexes
	 *            an array of integer dataset, boolean dataset, slices or null entries (same as
	 *            full slices)
	 * @return The new selected dataset by index
	 */
	public Dataset getByIndexes(Object... indexes);

	/**
	 * This is modelled after the NumPy set item with an index dataset
	 *
	 * @param obj
	 *            specifies the object used to set the selected items
	 * @param index
	 *            an integer dataset
	 * 
	 * @return The dataset with modified content
	 */
	public Dataset setBy1DIndex(Object obj, Dataset index);

	/**
	 * This is modelled after the NumPy set item with an array of indexing objects
	 *
	 * @param obj
	 *            specifies the object used to set the selected items
	 * @param indexes
	 *            an array of integer dataset, boolean dataset, slices or null entries (same as
	 *            full slices)
	 * 
	 * @return The dataset with modified content
	 */
	public Dataset setByIndexes(Object obj, Object... indexes);

	/**
	 * Fill dataset with given object
	 * 
	 * @param obj
	 * @return filled dataset with each item being equal to the given object
	 */
	public Dataset fill(Object obj);

	/**
	 * Get an element from given absolute index as a boolean. See warning in interface doc
	 * 
	 * @param index
	 * @return element as boolean
	 */
	public boolean getElementBooleanAbs(int index);

	/**
	 * Get an element from given absolute index as a double. See warning in interface doc
	 * 
	 * @param index
	 * @return element as double
	 */
	public double getElementDoubleAbs(int index);

	/**
	 * Get an element from given absolute index as a long. See warning in interface doc
	 * 
	 * @param index
	 * @return element as long
	 */
	public long getElementLongAbs(int index);

	/**
	 * Get an item from given absolute index as an object. See warning in interface doc
	 * 
	 * @param index
	 * @return item
	 */
	public Object getObjectAbs(int index);

	/**
	 * Get an item from given absolute index as a string. See warning in interface doc
	 * 
	 * @param index
	 * @return item
	 */
	public String getStringAbs(int index);

	/**
	 * Set an item at absolute index from an object. See warning in interface doc
	 * 
	 * @param index
	 * @param obj
	 */
	public void setObjectAbs(int index, Object obj);

	/**
	 * Get first item as an object. The dataset must not be null
	 * @return item
	 * @since 2.0
	 */
	public Object getObject();

	/**
	 * Get an item from given position as an object. The dataset must be 1D
	 * @param i
	 * @return item
	 */
	public Object getObject(final int i);

	/**
	 * Get an item from given position as an object. The dataset must be 2D
	 * @param i
	 * @param j
	 * @return item
	 */
	public Object getObject(final int i, final int j);

	/**
	 * Get first item as a string. The dataset must not be null
	 * @return item
	 * @since 2.0
	 */
	public String getString();

	/**
	 * Get an item from given position as a string. The dataset must be 1D
	 * @param i
	 * @return item
	 */
	public String getString(final int i);

	/**
	 * Get an item from given position as a string. The dataset must be 2D
	 * @param i
	 * @param j
	 * @return item
	 */
	public String getString(final int i, final int j);

	/**
	 * Get first item as a double. The dataset must not be null
	 * @return item
	 * @since 2.0
	 */
	public double getDouble();

	/**
	 * Get an item from given position as a double. The dataset must be 1D
	 * @param i
	 * @return item
	 */
	public double getDouble(final int i);

	/**
	 * Get an item from given position as a double. The dataset must be 2D
	 * @param i
	 * @param j
	 * @return item
	 */
	public double getDouble(final int i, final int j);

	/**
	 * Get first item as a float. The dataset must not be null
	 * @return item
	 * @since 2.0
	 */
	public float getFloat();

	/**
	 * Get an item from given position as a float. The dataset must be 1D
	 * @param i
	 * @return item
	 */
	public float getFloat(final int i);

	/**
	 * Get an item from given position as a float. The dataset must be 2D
	 * @param i
	 * @param j
	 * @return item
	 */
	public float getFloat(final int i, final int j);

	/**
	 * Get first item as a long. The dataset must not be null
	 * @return item
	 * @since 2.0
	 */
	public long getLong();

	/**
	 * Get an item from given position as a long. The dataset must be 1D
	 * @param i
	 * @return item
	 */
	public long getLong(final int i);

	/**
	 * Get an item from given position as a long. The dataset must be 2D
	 * @param i
	 * @param j
	 * @return item
	 */
	public long getLong(final int i, final int j);

	/**
	 * Get first item as an int. The dataset must not be null
	 * @return item
	 * @since 2.0
	 */
	public int getInt();

	/**
	 * Get an item from given position as an int. The dataset must be 1D
	 * @param i
	 * @return item
	 */
	public int getInt(final int i);

	/**
	 * Get an item from given position as an int. The dataset must be 2D
	 * @param i
	 * @param j
	 * @return item
	 */
	public int getInt(final int i, final int j);

	/**
	 * Get first item as a short. The dataset must not be null
	 * @return item
	 * @since 2.0
	 */
	public short getShort();

	/**
	 * Get an item from given position as a short. The dataset must be 1D
	 * @param i
	 * @return item
	 */
	public short getShort(final int i);

	/**
	 * Get an item from given position as a short. The dataset must be 2D
	 * @param i
	 * @param j
	 * @return item
	 */
	public short getShort(final int i, final int j);

	/**
	 * Get first item as a byte. The dataset must not be null
	 * @return item
	 * @since 2.0
	 */
	public byte getByte();

	/**
	 * Get an item from given position as a byte. The dataset must be 1D
	 * @param i
	 * @return item
	 */
	public byte getByte(final int i);

	/**
	 * Get an item from given positionj as a byte. The dataset must be 2D
	 * @param i
	 * @param j
	 * @return item
	 */
	public byte getByte(final int i, final int j);

	/**
	 * Get first item as a boolean. The dataset must not be null
	 * @return item
	 * @since 2.0
	 */
	public boolean getBoolean();

	/**
	 * Get an item from given position as a boolean. The dataset must be 1D
	 * @param i
	 * @return item
	 */
	public boolean getBoolean(final int i);

	/**
	 * Get an item from given position as a boolean. The dataset must be 2D
	 * @param i
	 * @param j
	 * @return item
	 */
	public boolean getBoolean(final int i, final int j);

	/**
	 * Get the error for the first item. The dataset must not be null
	 * @return item
	 * @since 2.0
	 */
	public double getError();

	/**
	 * Get the error for given position. The dataset must be 1D
	 * @param i
	 * @return error value (symmetric)
	 */
	public double getError(final int i);

	/**
	 * Get the error for given position. The dataset must be 2D
	 * @param i
	 * @param j
	 * @return error value (symmetric)
	 */
	public double getError(final int i, final int j);

	/**
	 * Get the error values for given position
	 * @param i
	 * @return the values of the error at this point (can be null when no error defined)
	 */
	public double[] getErrorArray(final int i);

	/**
	 * Get the error values for given position
	 * @param i
	 * @param j
	 * @return the values of the error at this point (can be null when no error defined)
	 */
	public double[] getErrorArray(final int i, final int j);

	/**
	 * Set the value given by object at the first position. The dataset must not be null
	 * @param obj
	 * @since 2.0
	 */
	public void set(final Object obj);

	/**
	 * Set the value given by object at given position. The dataset must be 1D
	 * @param obj
	 * @param i
	 */
	public void set(final Object obj, final int i);

	/**
	 * Set the value given by object at given position. The dataset must be 2D
	 * @param obj
	 * @param i
	 * @param j
	 */
	public void set(final Object obj, final int i, final int j);

	/**
	 * In-place sort of dataset
	 * 
	 * @param axis
	 *            to sort along. If null, then the flattened view is sorted
	 * @return sorted dataset
	 */
	public Dataset sort(Integer axis);

	@Override
	public Dataset getSlice(int[] start, int[] stop, int[] step);

	@Override
	public Dataset getSlice(IMonitor mon, int[] start, int[] stop, int[] step);

	@Override
	public Dataset getSlice(Slice... slice);

	@Override
	public Dataset getSlice(IMonitor mon, Slice... slice);

	@Override
	public Dataset getSlice(SliceND slice);

	@Override
	public Dataset getSlice(IMonitor mon, SliceND slice);

	@Override
	public Dataset getSliceView(int[] start, int[] stop, int[] step);

	@Override
	public Dataset getSliceView(Slice... slice);

	@Override
	public Dataset getSliceView(SliceND slice);

	/**
	 * This is modelled after the NumPy array slice
	 *
	 * @param obj
	 *            specifies the object used to set the specified slice
	 * @param start
	 *            specifies the starting indexes
	 * @param stop
	 *            specifies the stopping indexes (nb, these are <b>not</b> included in the slice)
	 * @param step
	 *            specifies the steps in the slice
	 * 
	 * @return The dataset with the sliced set to object
	 */
	public Dataset setSlice(Object obj, int[] start, int[] stop, int[] step);

	/**
	 * This is modelled after the NumPy array slice
	 * 
	 * @param obj
	 * @param slice
	 */
	public Dataset setSlice(Object obj, Slice... slice);

	/**
	 * This is modelled after the NumPy array slice
	 * 
	 * @param obj
	 * @param slice
	 */
	public Dataset setSlice(Object obj, SliceND slice);

	/**
	 * @param obj
	 *            specifies the object used to set the specified slice
	 * @param iterator
	 *            specifies the slice iterator
	 * 
	 * @return The dataset with the sliced set to object
	 */
	public Dataset setSlice(Object obj, IndexIterator iterator);

	/**
	 * Populate another dataset with part of current dataset
	 * 
	 * @param other
	 * @param iter
	 *            over current dataset
	 */
	public void fillDataset(Dataset other, IndexIterator iter);

	/**
	 * Test if all items are true
	 */
	public boolean all();

	/**
	 * @param axis
	 * @return dataset where items are true if all items along axis are true
	 */
	public Dataset all(int axis);

	/**
	 * Test if any items are true
	 */
	public boolean any();

	/**
	 * @param axis
	 * @return dataset where items are true if any items along axis are true
	 */
	public Dataset any(int axis);

	/**
	 * In-place addition with object o
	 * 
	 * @param o
	 * @return sum dataset
	 */
	public Dataset iadd(Object o);

	/**
	 * In-place subtraction with object o
	 * 
	 * @param o
	 * @return difference dataset
	 */
	public Dataset isubtract(Object o);

	/**
	 * In-place multiplication with object o
	 * 
	 * @param o
	 * @return product dataset
	 */
	public Dataset imultiply(Object o);

	/**
	 * In-place division with object o
	 * 
	 * @param o
	 * @return dividend dataset
	 */
	public Dataset idivide(Object o);

	/**
	 * In-place floor division with object o
	 * 
	 * @param o
	 * @return dividend dataset
	 */
	public Dataset ifloorDivide(Object o);

	/**
	 * In-place remainder
	 * 
	 * @return remaindered dataset
	 */
	public Dataset iremainder(Object o);

	/**
	 * In-place floor
	 * 
	 * @return floored dataset
	 */
	public Dataset ifloor();

	/**
	 * In-place raise to power of object o
	 * 
	 * @param o
	 * @return raised dataset
	 */
	public Dataset ipower(Object o);

	/**
	 * Calculate residual of dataset with object o
	 * See {@link #residual(Object o, boolean ignoreNaNs)} with ignoreNaNs = false
	 * 
	 * @param o
	 * @return sum of the squares of the differences
	 */
	public double residual(Object o);

	/**
	 * Calculate residual of dataset with object o
	 * 
	 * @param o
	 * @param ignoreNaNs if true, skip NaNs
	 * @return sum of the squares of the differences
	 */
	public double residual(Object o, boolean ignoreNaNs);

	/**
	 * Calculate residual of dataset with object o and weight. The weight is used to multiply
	 * the squared differences
	 * 
	 * @param o
	 * @param weight
	 * @param ignoreNaNs if true, skip NaNs
	 * @return sum of the squares of the differences
	 */
	public double residual(Object o, Dataset weight, boolean ignoreNaNs);

	/**
	 * @return true if dataset contains any infinities
	 */
	public boolean containsInfs();

	/**
	 * @return true if dataset contains any NaNs
	 */
	public boolean containsNans();

	/**
	 * @return true if dataset contains any NaNs or infinities
	 */
	public boolean containsInvalidNumbers();

	/**
	 * @param axis
	 * @param ignoreInvalids - Can be null, empty, or one or more booleans. By default, all booleans
	 * are false. If the first boolean is true, will ignore NaNs and ignore infinities. Use the second
	 * boolean to ignore infinities separately.
	 * @return maxima along axis in dataset
	 * @since 2.0
	 */
	public Dataset max(int axis, boolean... ignoreInvalids);

	/**
	 * @param axis
	 * @param ignoreInvalids - see {@link #max(int, boolean...)}
	 * @return minima along axis in dataset
	 * @since 2.0
	 */
	public Dataset min(int axis, boolean... ignoreInvalids);

	/**
	 * Find absolute index of maximum value (in a flattened view)
	 * @param ignoreInvalids - see {@link IDataset#max(boolean...)}
	 * @return absolute index
	 * @since 2.0
	 */
	public int argMax(boolean... ignoreInvalids);

	/**
	 * Find indices of maximum values along given axis
	 * @param axis
	 * @param ignoreInvalids - see {@link #max(int, boolean...)}
	 * @return index dataset
	 * @since 2.0
	 */
	public Dataset argMax(int axis, boolean... ignoreInvalids);

	/**
	 * Find absolute index of minimum value (in a flattened view)
	 * @param ignoreInvalids - see {@link IDataset#max(boolean...)}
	 * @return absolute index
	 * @since 2.0
	 */
	public int argMin(boolean... ignoreInvalids);

	/**
	 * Find indices of minimum values along given axis
	 * @param axis
	 * @param ignoreInvalids - see {@link #max(int, boolean...)}
	 * @return index dataset
	 * @since 2.0
	 */
	public Dataset argMin(int axis, boolean... ignoreInvalids);

	/**
	 * @param ignoreInvalids - see {@link IDataset#max(boolean...)}
	 * @return peak-to-peak value, the difference of maximum and minimum of dataset
	 * @since 2.0
	 */
	public Number peakToPeak(boolean... ignoreInvalids);

	/**
	 * @param axis
	 * @param ignoreInvalids - see {@link #max(int, boolean...)}
	 * @return peak-to-peak dataset, the difference of maxima and minima of dataset along axis
	 * @since 2.0
	 */
	public Dataset peakToPeak(int axis, boolean... ignoreInvalids);

	/**
	 * @param ignoreInvalids - see {@link IDataset#max(boolean...)}
	 * @return number of items in dataset
	 * @since 2.0
	 */
	public long count(boolean... ignoreInvalids);

	/**
	 * @param axis
	 * @param ignoreInvalids - see {@link #max(int, boolean...)}
	 * @return number of items along axis in dataset
	 * @since 2.0
	 */
	public Dataset count(int axis, boolean... ignoreInvalids);

	/**
	 * @param ignoreInvalids - see {@link IDataset#max(boolean...)}
	 * @return sum over all items in dataset as a Double, array of doubles or a complex number
	 * @since 2.0
	 */
	public Object sum(boolean... ignoreInvalids);

	/**
	 * @param axis
	 * @param ignoreInvalids - see {@link #max(int, boolean...)}
	 * @return sum along axis in dataset
	 * @since 2.0
	 */
	public Dataset sum(int axis, boolean... ignoreInvalids);

	/**
	 * @param ignoreInvalids - see {@link IDataset#max(boolean...)}
	 * @return product over all items in dataset
	 * @since 2.0
	 */
	public Object product(boolean... ignoreInvalids);

	/**
	 * @param axis
	 * @param ignoreInvalids - see {@link #max(int, boolean...)}
	 * @return product along axis in dataset
	 * @since 2.0
	 */
	public Dataset product(int axis, boolean... ignoreInvalids);

	/**
	 * @param axis
	 * @param ignoreInvalids - see {@link #max(int, boolean...)}
	 * @return mean along axis in dataset
	 * @since 2.0
	 */
	public Dataset mean(int axis, boolean... ignoreInvalids);

	/**
	 * @return sample variance of whole dataset
	 * @see #variance(boolean, boolean...) with isWholePopulation = false
	 * @since 2.0
	 */
	public double variance();

	/**
	 * The sample variance can be calculated in two ways: if the dataset is considered as the
	 * entire population then the sample variance is simply the second central moment:
	 * 
	 * <pre>
	 *    sum((x_i - m)^2)/N
	 * where {x_i} are set of N population values and m is the mean
	 *    m = sum(x_i)/N
	 * </pre>
	 * 
	 * Otherwise, if the dataset is a set of samples (with replacement) from the population then
	 * 
	 * <pre>
	 *    sum((x_i - m)^2)/(N-1)
	 * where {x_i} are set of N sample values and m is the unbiased estimate of the mean
	 *    m = sum(x_i)/N
	 * </pre>
	 * 
	 * Note that the second definition is also the unbiased estimator of population variance.
	 * 
	 * @param isWholePopulation
	 * @param ignoreInvalids - see {@link #max(int, boolean...)}
	 * @return sample variance
	 * @since 2.0
	 */
	public double variance(boolean isWholePopulation, boolean... ignoreInvalids);

	/**
	 * @param axis
	 * @return sample variance along axis in dataset
	 * @see #variance(int, boolean, boolean...) with isWholePopulation = false
	 */
	public Dataset variance(int axis);

	/**
	 * @param axis
	 * @param isWholePopulation
	 * @param ignoreInvalids - see {@link #max(int, boolean...)}
	 * @return sample variance along axis in dataset
	 * @see #variance(boolean, boolean...) with isWholePopulation = false
	 * @since 2.0
	 */
	public Dataset variance(int axis, boolean isWholePopulation, boolean... ignoreInvalids);

	/**
	 * Standard deviation is square root of the variance
	 * 
	 * @return sample standard deviation of all items in dataset
	 * @see #stdDeviation(boolean, boolean...) with isWholePopulation = false
	 * @since 2.0
	 */
	public double stdDeviation();

	/**
	 * Standard deviation is square root of the variance
	 * 
	 * @param isWholePopulation
	 * @param ignoreInvalids - see {@link #max(int, boolean...)}
	 * @return sample standard deviation of all items in dataset
	 * @see #variance(boolean, boolean...)
	 * @since 2.0
	 */
	public double stdDeviation(boolean isWholePopulation, boolean... ignoreInvalids);

	/**
	 * Standard deviation is square root of the variance
	 * 
	 * @param axis
	 * @return standard deviation along axis in dataset
	 * @see #stdDeviation(int, boolean, boolean...) with isWholePopulation = false
	 */
	public Dataset stdDeviation(int axis);

	/**
	 * Standard deviation is square root of the variance
	 * 
	 * @param axis
	 * @param isWholePopulation
	 * @param ignoreInvalids - see {@link #max(int, boolean...)}
	 * @return standard deviation along axis in dataset
	 * @see #variance(boolean, boolean...) with isWholePopulation = false
	 * @since 2.0
	 */
	public Dataset stdDeviation(int axis, boolean isWholePopulation, boolean... ignoreInvalids);

	/**
	 * @param ignoreInvalids - see {@link IDataset#max(boolean...)}
	 * @return root mean square
	 * @since 2.0
	 */
	public double rootMeanSquare(boolean... ignoreInvalids);

	/**
	 * @param axis
	 * @param ignoreInvalids - see {@link #max(int, boolean...)}
	 * @return root mean square along axis in dataset
	 * @since 2.0
	 */
	public Dataset rootMeanSquare(int axis, boolean... ignoreInvalids);
}
