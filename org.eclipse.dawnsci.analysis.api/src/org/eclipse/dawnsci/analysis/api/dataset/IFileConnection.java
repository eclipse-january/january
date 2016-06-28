/*-
 * Copyright 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.api.dataset;

public interface IFileConnection {

	/**
	 * DataServer path, a local path on the server used to locate the remote dataset.
	 * @return the file path to the data in the file system of the remote machine
	 */
	public String getPath();
	
	/**
	 * DataServer path, a local path on the server used to locate the remote dataset.
	 * This path may also be a directory where the data collection will happen. In this
	 * case when the first file is written, the dataset must be made up of files with the
	 * same extension.
	 * 
	 * @param path to the data in the file system of the remote machine
	 */
	public void setPath(String path);

}
