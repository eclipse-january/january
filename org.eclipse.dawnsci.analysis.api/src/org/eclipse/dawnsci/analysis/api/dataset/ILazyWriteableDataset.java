/*-
 * Copyright 2015 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.api.dataset;

import org.eclipse.dawnsci.analysis.api.io.ILazySaver;
import org.eclipse.dawnsci.analysis.api.monitor.IMonitor;

/**
 * This sub-interface adds the ability to write to a lazy dataset slice-by-slice
 */
public interface ILazyWriteableDataset extends ILazyDataset {

	/**
	 * Denotes an unlimited dimension in maximum shape
	 */
	public static final int UNLIMITED = -1;

	/**
	 * @return maximum shape
	 */
	public int[] getMaxShape();

	/**
	 * Set maximum shape
	 */
	public void setMaxShape(int[] maxShape);

	/**
	 * Get chunking
	 * @return chunks
	 */
	public int[] getChunking();

	/**
	 * Set chunking
	 */
	public void setChunking(int[] chunks);

	/**
	 * Set saver
	 * @param saver
	 */
	public void setSaver(ILazySaver saver);

	/**
	 * Set a slice of the dataset
	 * 
	 * @param monitor
	 * @param data
	 * @param slice an n-D slice
	 * @throws Exception 
	 */
	public void setSlice(final IMonitor monitor, final IDataset data, final SliceND slice) throws Exception;
}
