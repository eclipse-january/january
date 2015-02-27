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

package org.eclipse.dawnsci.analysis.api.dataset;

import java.io.Serializable;

import org.eclipse.dawnsci.analysis.api.INameable;
import org.eclipse.dawnsci.analysis.api.metadata.MetadataType;
import org.eclipse.dawnsci.analysis.api.monitor.IMonitor;

/**
 * This interface defines the lazy parts of a dataset. A dataset is a N-dimensional array of items
 * where N can be zero to represent a zero-rank or single-valued dataset. A zero-rank dataset has
 * an empty array for shape. An item comprises a number of elements.
 */
public interface ILazyDataset extends Serializable, IMetadataProvider, INameable {
		
	/**
	 * @return Boxed class of element
	 */
	public Class<?> elementClass();

	/**
	 * @return Number of elements per item
	 */
	public int getElementsPerItem();

	/**
	 * The size of the dataset is the number of items in the array
	 * (not including reserved space)
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
	 */
	public IDataset getSlice(final int[] start, final int[] stop, final int[] step);

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
	 * @throws Exception 
	 */
	public IDataset getSlice(final IMonitor monitor, final int[] start, final int[] stop,
			final int[] step) throws Exception;

	/**
	 * Get a slice of the dataset. The returned dataset is a copied selection of items
	 * 
	 * @param slice an array of slice objects (the array can be null or contain nulls)
	 * @return The dataset of the sliced data
	 */
	public IDataset getSlice(final Slice... slice);

	/**
	 * Get a slice of the dataset. The returned dataset is a copied selection of items
	 * 
	 * @param slice an n-D slice
	 * @return The dataset of the sliced data
	 */
	public IDataset getSlice(final SliceND slice);

	/**
	 * Get a slice of the dataset. The returned dataset is a copied selection of items
	 * 
	 * @param monitor
	 * @param slice an array of slice objects (the array can be null or contain nulls)
	 * @return The dataset of the sliced data
	 * @throws Exception 
	 */
	public IDataset getSlice(final IMonitor monitor, final Slice... slice) throws Exception;

	/**
	 * Get a slice of the dataset. The returned dataset is a copied selection of items
	 * 
	 * @param monitor
	 * @param slice an n-D slice
	 * @return The dataset of the sliced data
	 * @throws Exception 
	 */
	public IDataset getSlice(final IMonitor monitor, final SliceND slice) throws Exception;

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
	public <T extends MetadataType> void addMetadata(final T metadata);

	/**
	 * Set metadata on the dataset
	 * 
	 * @param metadata (null is ignored so use clear(null) instead)
	 */
	public <T extends MetadataType> void setMetadata(T metadata);

	/**
	 * Remove metadata of given class 
	 * @param clazz if null remove everything
	 */
	public <T extends MetadataType> void clearMetadata(Class<T> clazz);

	/**
	 * Clone dataset
	 * @return a (shallow) copy of dataset
	 */
	public ILazyDataset clone();

	/**
	 * Set the errors. These must be in a shape that can broadcast to the dataset
	 * 
	 * @param errors - may be null to remove the error set
	 * @throws RuntimeException if the rank or shape are incorrect
	 */
	public void setError(Serializable errors);

	/**
	 * Get the errors, if any. These will in a shape that can broadcast to the dataset
	 */
	public ILazyDataset getError();

}
