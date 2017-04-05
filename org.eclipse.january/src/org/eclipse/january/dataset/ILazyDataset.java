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
import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.eclipse.january.DatasetException;
import org.eclipse.january.IMonitor;
import org.eclipse.january.INameable;
import org.eclipse.january.metadata.MetadataType;

/**
 * This interface defines the lazy parts of a dataset. A dataset is a N-dimensional array of items
 * where N can be zero to represent a zero-rank or single-valued dataset. A zero-rank dataset has
 * an empty array for shape. An item comprises a number of elements.
 */
public interface ILazyDataset extends Serializable, IMetadataProvider, INameable {
		
	/**
	 * @return Boxed class of element
	 */
	public Class<?> getElementClass();

	/**
	 * @return Number of elements per item
	 */
	public int getElementsPerItem();

	/**
	 * The size of the dataset is the number of items in the array
	 * 
	 * @return number of data items
	 */
	public int getSize();

	/**
	 * The shape (or array of lengths for each dimension) of the dataset can be empty for zero-rank
	 * datasets
	 * 
	 * @return Copy of shape of dataset
	 */
	public int[] getShape();

	/**
	 * Set a compatible shape for dataset. A shape is compatible if it has the capacity to contain
	 * the same number of items
	 * 
	 * @param shape
	 */
	public void setShape(final int... shape);

	/**
	 * The rank (or number of dimensions/indices) of the dataset can be zero for a zero-rank
	 * (single-valued) dataset 
	 * @return rank
	 */
	public int getRank();

	/**
	 * Remove dimensions of 1 from ends of shape of the dataset
	 */
	public ILazyDataset squeezeEnds();

	/**
	 * Get a slice of the dataset. The returned dataset is a copied selection of items
	 * 
	 * @param start
	 *            specifies the starting indexes (can be null for origin)
	 * @param stop
	 *            specifies the stopping indexes (can be null for end)
	 * @param step
	 *            specifies the steps in the slice (can be null for unit steps)
	 * @return The dataset of the sliced data
	 * @throws DatasetException
	 */
	public IDataset getSlice(final int[] start, final int[] stop, final int[] step) throws DatasetException;

	/**
	 * Get a slice of the dataset. The returned dataset is a copied selection of items
	 * 
	 * @param monitor
	 * @param start
	 *            specifies the starting indexes (can be null for origin)
	 * @param stop
	 *            specifies the stopping indexes (can be null for end)
	 * @param step
	 *            specifies the steps in the slice (can be null for unit steps)
	 * @return The dataset of the sliced data
	 * @throws DatasetException
	 */
	public IDataset getSlice(final IMonitor monitor, final int[] start, final int[] stop,
			final int[] step) throws DatasetException;

	/**
	 * Get a slice of the dataset. The returned dataset is a copied selection of items
	 * 
	 * @param slice an array of slice objects (the array can be null or contain nulls)
	 * @return The dataset of the sliced data
	 * @throws DatasetException
	 */
	public IDataset getSlice(final Slice... slice) throws DatasetException;

	/**
	 * Get a slice of the dataset. The returned dataset is a copied selection of items
	 * 
	 * @param monitor
	 * @param slice an array of slice objects (the array can be null or contain nulls)
	 * @return The dataset of the sliced data
	 * @throws DatasetException
	 */
	public IDataset getSlice(final IMonitor monitor, final Slice... slice) throws DatasetException;

	/**
	 * Get a slice of the dataset. The returned dataset is a copied selection of items
	 * 
	 * @param slice an n-D slice
	 * @return The dataset of the sliced data
	 * @throws DatasetException
	 */
	public IDataset getSlice(final SliceND slice) throws DatasetException;

	/**
	 * Get a slice of the dataset. The returned dataset is a copied selection of items
	 * 
	 * @param monitor
	 * @param slice an n-D slice
	 * @return The dataset of the sliced data
	 * @throws DatasetException
	 */
	public IDataset getSlice(final IMonitor monitor, final SliceND slice) throws DatasetException;

	/**
	 * Get a slice of the dataset. The returned lazy dataset is a view on a selection of items
	 * 
	 * @param start
	 *            specifies the starting indexes (can be null for origin)
	 * @param stop
	 *            specifies the stopping indexes (can be null for end)
	 * @param step
	 *            specifies the steps in the slice (can be null for unit steps)
	 * @return The sliced view of a lazy dataset 
	 */
	public ILazyDataset getSliceView(final int[] start, final int[] stop, final int[] step);

	/**
	 * Get a slice of the dataset. The returned lazy dataset is a view on a selection of items
	 * 
	 * @param slice an array of slice objects (the array can be null or contain nulls)
	 * @return The sliced view of a lazy dataset
	 */
	public ILazyDataset getSliceView(final Slice... slice);

	/**
	 * Get a slice of the dataset. The returned lazy dataset is a view on a selection of items
	 * 
	 * @param slice an n-D slice
	 * @return The sliced view of a lazy dataset
	 */
	public ILazyDataset getSliceView(final SliceND slice);

	/**
	 * Permute copy of dataset's axes so that given order is old order:
	 * 
	 * <pre>
	 *  axisPerm = (p(0), p(1),...) => newdata(n(0), n(1),...) = olddata(o(0), o(1), ...)
	 *  such that n(i) = o(p(i)) for all i
	 * </pre>
	 * 
	 * I.e. for a 3D dataset (1,0,2) implies the new dataset has its 1st dimension running along
	 * the old dataset's 2nd dimension and the new 2nd is the old 1st. The 3rd dimension is left
	 * unchanged.
	 * 
	 * @param axes
	 *            if zero length then axes order reversed
	 * @return remapped view of data
	 */
	public ILazyDataset getTransposedView(int... axes);

	/**
	 * Add metadata to the dataset
	 * 
	 * @param metadata
	 */
	public void addMetadata(final MetadataType metadata);

	/**
	 * Set metadata on the dataset
	 * 
	 * @param metadata (null is ignored so use clear(null) instead)
	 */
	public void setMetadata(MetadataType metadata);

	/**
	 * Remove metadata of given class
	 * @param clazz if null remove everything
	 */
	public void clearMetadata(Class<? extends MetadataType> clazz);

	/**
	 * Clone dataset
	 * @return a (shallow) copy of dataset
	 */
	public ILazyDataset clone();

	/**
	 * Set the errors. It may be a single double, a double array or a
	 * whole dataset that can broadcast to the dataset
	 * 
	 * @param errors - may be null to remove the error set
	 * @throws RuntimeException if the rank or shape are incorrect
	 * @since 2.0
	 */
	public void setErrors(Serializable errors);

	/**
	 * Get the errors, if any. These will be in a shape that can broadcast to the dataset
	 * @since 2.0
	 */
	public ILazyDataset getErrors();

	/**
	 * If error information is set, returns true.
	 * Faster to call than getError() which constructs a
	 * new dataset.
	 * 
	 * @return true if there is error data.
	 */
	public boolean hasErrors();
	
	/**
	 * Overloads PositionIterator(int[]) for ease of use.
	 * @param shape
	 * @since 2.1
	 * @return
	 */
	default Stream<IDataset> positionStream(int... shape) {
		return positionStream(new PositionIterator(shape));
	}
	
	/**
	 * Overloads PositionIterator(int, int[]) for ease of use.
	 * @param shape
	 * @since 2.1
	 * @return
	 */
	default Stream<IDataset> positionStream(int offset, int[] shape) {
		return positionStream(new PositionIterator(offset, shape));
	}
	
	/**
	 * Overloads PositionIterator(int[], int...) for ease of use.
	 * @param shape
	 * @since 2.1
	 * @return
	 */
	default Stream<IDataset> positionStream(int[] shape, int... axes) {
		return positionStream(new PositionIterator(shape, axes));
	}

	/**
	 * This default method is designed to move the slice 
	 * logic to a single place and return a Stream of IDatasets.
	 * The current implementation slices from left to right in
	 * the shape of the lazy dataset only. For instance if the 
	 * position iterator is slicing two dimensions, the first
	 * two dimensions of this dataset will be used to slice
	 * whilst the others keep full width. For instance using a 
	 * 64x64 iterator with a 64,64,100,100 dataset will give
	 * 4096 100x100 images of shape 1,1,100,100.
	 * 
	 * This approach allows the syntax of slicing to be kept 
	 * inside the API and a Stream<IDataset> of the slices to be
	 * returned. It allow allows the stream to be evaluated lazily
	 * because of the way that streams work.
	 * 
	 * Streams can be processed in parallel using .parallel, however
	 * that is not guaranteed to work for the current implementation.
	 * 
	 * It allows lambda expressions to be used with IDataset slicing
	 * which reduces bugs because much less code is created.
	 * 
	 * @param sliceShape
	 * @since 2.1
	 * @return
	 */
	default Stream<IDataset> positionStream(PositionIterator it) {
				
		return Stream.generate(it).map(pos -> {
			if (pos==null) return null;
			
			// TODO Need help.
			// Not generic because we fill up the slices
			// from left to right in the amount of PositionIterator
			Slice[] slice = new Slice[getRank()];
			for (int i = 0; i < pos.length; i++) {
				if (pos[i]<0) {
					slice = null;
				} else {
                    slice[i] = new Slice(pos[i], pos[i]+1);
				}
			}
			try {
				return getSlice(slice);
			} catch (DatasetException e) {
				return null;
			}
		}).limit(it.size());
	}
	
	/**
	 * Create a slice stream from a sliceND
	 * 
	 * @param slice
	 * @since 2.1
	 * @return
	 */
	default Stream<IDataset> sliceStream(SliceND slice) {
		
		int size = ShapeUtils.calcSize(slice.getShape());
		if (size < 1) {
			throw new IllegalArgumentException("The size is smaller than 1");
		}
	
		return sliceStream(new SliceIterator(getShape(), size, slice));

	}
	
	/**
	 * Create a slice stream from a slice iterator
	 * 
	 * @param slice
	 * @since 2.1
	 * @return
	 */
	default Stream<IDataset> sliceStream(SliceIterator it) {

		return Stream.generate(it).map(pos -> {
			
			// TODO Need help.
			// Not generic because we fill up the slices
			// from left to right in the amount of PositionIterator
			Slice[] slice = new Slice[getRank()];
			for (int i = 0; i < pos.length; i++) {
				if (pos[i]<0) {
					slice = null;
				} else {
                    slice[i] = new Slice(pos[i], pos[i]+1);
				}
			}
			try {
				return getSlice(slice);
			} catch (DatasetException e) {
				return null;
			}
		}).limit(it.size());

	}
}
