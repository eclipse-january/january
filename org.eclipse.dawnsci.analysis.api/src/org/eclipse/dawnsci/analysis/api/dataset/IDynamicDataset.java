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
public interface IDynamicDataset<T extends IDataset> {

	/**
	 * Internal use only. When the dataset changes, the internal API may update the 
	 * underlying data which the dataset is linked to.
	 * 
	 * @param newData
	 */
	public void setData(T newData);

	
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
