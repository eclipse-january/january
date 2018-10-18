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

package org.eclipse.january.metadata;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import org.eclipse.january.MetadataException;
import org.eclipse.january.io.IDataAnalysisObject;

/**
 * This interface describes the minimal metadata information that should be 
 * associated with a Dataset or DataHolder. It is intended that
 * this interface will be implemented in an object that will then be 
 * associated with a DataHolder or dataset using setMetadata(IMetadata).
 * <p>
 * All returned collections and maps are <b>unmodifiable</b>.
 */
public interface IMetadata extends IDataAnalysisObject, MetadataType, Serializable {
	/**
	 * Update this when there are any serious changes to API
	 */
	static final long serialVersionUID = 8640458661665962384L;

	/**
	 * Initialize metadata
	 * @param metadata
	 */
	public void initialize(Map<String, ? extends Serializable> metadata);

	/**
	 * 
	 * @return the path to the original file, or null if there was not a file.
	 */
	public String getFilePath();

	/**
	 * Returns a collection of dataset names or null if not implemented
	 * 
	 * @return collection
	 */
	public Collection<String> getDataNames();

	/**
	 * Can be implemented to return sizes of datasets
	 * (size can be null if it is not known)
	 * @return map of sizes
	 */
	public Map<String, Integer> getDataSizes();

	/**
	 * Can be implemented to return shapes of dataset
	 * (shape can be null if it is not known)
	 * @return map of shapes
	 */
	public Map<String, int[]> getDataShapes();

	/**
	 * Returns string value or null if not implemented
	 * 
	 * @param key
	 * @return value
	 * @throws MetadataException
	 */
	public Serializable getMetaValue(String key) throws MetadataException;

	/**
	 * Returns a collection of metadata names
	 * @return collection
	 * @throws MetadataException
	 */
	public Collection<String> getMetaNames() throws MetadataException;

	/**
	 * May be implemented to provide custom metadata in the form of a collection of serializable objects
	 * 
	 * @return collection
	 */
	public Collection<Serializable> getUserObjects();

	/**
	 * Copy of metadata
	 * @return deep copy
	 */
	@Override
	public IMetadata clone();

	public void setFilePath(String filename);

	/**
	 * Add name and shape of a dataset to metadata
	 * 
	 * @param name
	 * @param shape (can be null or zero-length)
	 * 
	 * (NOTE method should be public, people can define loaders outside this
	 * package like the DESY FIO loader for instance.)
	 */
	public void addDataInfo(String name, int... shape);

	public void addNames(Collection<String> names);

	/**
	 * Set metadata map
	 * @param metadata
	 */
	public void setMetadata(Map<String, ? extends Serializable> metadata);
}
