/*-
 * Copyright 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.january.dataset;

import java.util.Map;

/**
 * This class provides access to remote data which
 * may consist of more than one remote dataset. It
 * provides meta information about the contents of
 * the remote data which can be used to determine
 * which remote dataset to open. It provides a convenience
 * method for creating a remote dataset which must
 * be connected when it is returned but must be disconnected
 * or its parent IRemoteData disconnected at some point
 * later to close the connection with the server.
 */
public interface IRemoteData extends IFileConnection {

	/**
	 * Map of path to collection of attributes at that path.
	 * @return NeXus meta-data objects in most instances.
	 * @throws Exception
	 */
	public Map<String, Object> getTree()  throws Exception;
	
	/**
	 * Create a remote dataset looking at the dataset path named.
	 * connect() before use and disconnect() after use must be performed.
	 * 
	 * @param datasetPath
	 * @return IRemoteDataset
	 * @throws Exception
	 */
	public IRemoteDataset createRemoteDataset(String datasetPath) throws Exception;
}
