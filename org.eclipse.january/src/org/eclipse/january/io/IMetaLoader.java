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

package org.eclipse.january.io;

import java.io.IOException;

import org.eclipse.january.IMonitor;
import org.eclipse.january.metadata.IMetadata;


/**
 * Interface used to mark a loader as being available to load and return
 * metadata without loading the entire file into memory.
 */
public interface IMetaLoader {

	/**
	 * Loads the meta data from the file but not all the data.
	 * This can be read in more cheaply than the entire data.
	 * @param mon can be null
	 * @throws IOException when cannot load metadata
	 */
	public void loadMetadata(IMonitor mon) throws IOException ;

	/**
	 * Returns an object containing some data about the data file to be read in
	 *
	 * @return IMetadata
	 */
	public IMetadata getMetadata();
}
