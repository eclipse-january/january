/*-
 * Copyright 2015, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import org.eclipse.january.DatasetException;
import org.eclipse.january.IMonitor;
import org.eclipse.january.io.ILazySaver;

/**
 * This sub-interface adds the ability to write to a lazy dataset slice-by-slice
 */
public interface ILazyWriteableDataset extends IDynamicDataset {

	/**
	 * See {@link IDynamicDataset#UNLIMITED}
	 */
	public static final int UNLIMITED = IDynamicDataset.UNLIMITED;

	/**
	 * Set saver
	 * @param saver lazy saver
	 */
	public void setSaver(ILazySaver saver);

	/**
	 * Set a slice of the dataset
	 * 
	 * @param monitor can be null
	 * @param data input
	 * @param slice an n-D slice
	 * @throws DatasetException when cannot write data
	 */
	public void setSlice(final IMonitor monitor, final IDataset data, final SliceND slice) throws DatasetException;

	/**
	 * Set a slice of the dataset
	 * 
	 * @param monitor can be null
	 * @param data input
	 * @param start
	 *            specifies the starting indexes (can be null for origin)
	 * @param stop
	 *            specifies the stopping indexes (can be null for end)
	 * @param step
	 *            specifies the steps in the slice (can be null for unit steps)
	 * @throws DatasetException when cannot write data
	 */
	public void setSlice(final IMonitor monitor, final IDataset data, final int[] start, final int[] stop, final int[] step) throws DatasetException;

	/**
	 * Set a slice of the dataset synchronously
	 * 
	 * @param monitor can be null
	 * @param data input
	 * @param slice an n-D slice
	 * @throws DatasetException when cannot write data
	 */
	public void setSliceSync(final IMonitor monitor, final IDataset data, final SliceND slice) throws DatasetException;

	/**
	 * Set writing slices as asynchronous
	 * @param async true if writing should be asynchronous
	 */
	public void setWritingAsync(boolean async);

	/**
	 * Get the value used to fill an un-initialized dataset
	 * @return fill value
	 */
	public Object getFillValue();

	/**
	 * Set the value used to fill an un-initialized dataset
	 * @param fill value
	 */
	public void setFillValue(Object fill);

	@Override
	public ILazyWriteableDataset squeezeEnds();
}
