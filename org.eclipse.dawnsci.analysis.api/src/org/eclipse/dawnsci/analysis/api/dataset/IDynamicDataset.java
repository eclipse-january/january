/*-
 * Copyright 2015 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.api.dataset;


/**
 * This interface is intended for data sources that change dynamically.
 * Examples:
 * 1. An image stream from a camera encoded which entire image, changes periodically.
 * 2. An HDF5 dataset which entire shape changes as data is added.
 *  
 */
public interface IDynamicDataset extends ILazyDataset {

	/**
	 * Denotes an unlimited dimension in maximum shape
	 */
	public static final int UNLIMITED = -1;

	/**
	 * Change shape
	 * @param newShape
	 * @throws IllegalArgumentException if new shape exceeds maximum shape or is of different rank
	 * @throws UnsupportedOperationException if used on a view
	 */
	public void resize(int... newShape);

	/**
	 * @return maximum shape (can be null)
	 */
	public int[] getMaxShape();

	/**
	 * Set maximum shape
	 */
	public void setMaxShape(int[] maxShape);

	/**
	 * Add a listener which will be fired when aspects of the data change for
	 * instance shape or content.
	 * @param l
	 */
	public void addDataListener(IDataListener l);
	

	/**
	 * Remove a listener which will be fired when aspects of the data change for
	 * instance shape or content.
	 * @param l
	 */
	public void removeDataListener(IDataListener l);

	
	/**
	 * Add a listener which will be fired when aspects of the meta data change for
	 * instance origin of data
	 * @param l
	 */
	// TODO Add this when required.
	//public void addMetadataListener(IMetadataListener l);
	

	/**
	 * Remove a listener which will be fired when aspects of the meta data change for
	 * instance origin of data
	 * @param l
	 */
	// TODO Add this when required.
	//public void removeDataListener(IMetadataListener l);

}
