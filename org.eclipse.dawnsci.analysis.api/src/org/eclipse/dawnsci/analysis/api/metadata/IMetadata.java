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

package org.eclipse.dawnsci.analysis.api.metadata;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import org.eclipse.dawnsci.analysis.api.io.IDataAnalysisObject;

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
	 */
	public Serializable getMetaValue(String key) throws Exception;

	/**
	 * Returns a collection of metadata names
	 * @return collection
	 * @throws Exception
	 */
	public Collection<String> getMetaNames() throws Exception;

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
}
