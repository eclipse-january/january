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


import java.util.Date;

/**
 * This is an interface that has been designed to add information about a file in addition to
 * information which has been implemented in IMetadata.
 * <p>
 * It is intended that implementations of this interface will be through an adapter
 */
public interface IExtendedMetadata extends IMetadata {

	/**
	 * This should be the timestamp of when the experiment or measurement took place which should
	 * be recorded in the header of the file, if applicable
	 * 
	 * @return a date object to represent when the data was created
	 */
	public Date getCreation();

	/**
	 * @return a date object that indicated when the data was last modified
	 */
	public Date getLastModified();

	/**
	 * @return a string representing the user who created the file
	 */
	public String getCreator();

	/**
	 * @return a string containing the filename
	 */
	public String getFileName();

	/**
	 * @return the owner of the file
	 */
	public String getFileOwner();

	/**
	 * @return a long representing the size of the file in bytes
	 */
	public long getFileSize();

	/**
	 * @return the full path string of the file
	 */
	public String getFullPath();

	/**
	 * @return The scan command as a string that was used to generate the data. This can be null as not always
	 *         applicable
	 */
	public String getScanCommand();

}
