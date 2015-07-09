/*******************************************************************************
 * Copyright (c) 2014 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - Jay Jay Billings,
 *   Jordan H. Deyton, Dasha Gorin, Alexander J. McCaskey, Taylor Patterson,
 *   Claire Saunders, Matthew Wang, Anna Wojtowicz
 *******************************************************************************/
package org.eclipse.ice.datastructures.resource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * The VizResource is used for loading a data set that should be visualized in
 * one of the platform's many visualization services. It is significantly
 * different than the base resource in that it can track multiple files that
 * collectively define a single resource as well as whether or not that resource
 * is a local or remote file.
 * 
 * @author Matthew Wang, Jay Jay Billings, Taylor Patterson
 * 
 */
@XmlRootElement(name = "VizResource")
public class VizResource extends ICEResource {

	/**
	 * The set of files contained associated with this resource
	 */
	private String[] fileSet;

	/**
	 * The fileSet title
	 */
	private String fileSetTitle = "No title";

	/**
	 * Reference to possible children VizResources
	 */
	private ArrayList<VizResource> childrenResources;

	/**
	 * The String representation of the hostname where the resource resides. By
	 * default it assumes localhost.
	 */
	private String host = "localhost";

	/**
	 * Comprehensive constructor
	 */
	public VizResource() {

		// Call ICEResource's constructor
		super();

		// Setup the list
		childrenResources = new ArrayList<VizResource>();
	}

	/**
	 * An alternative constructor that takes a File as input.
	 * 
	 * @param resourceFile
	 *            The File to set as the VizResources contents.
	 * @throws IOException
	 */
	public VizResource(File resourceFile) throws IOException {

		// Call ICEResource's constructor
		super(resourceFile);

		// Setup the list
		childrenResources = new ArrayList<VizResource>();

	}

	/**
	 * The Constructor. This allows for the creation of a VizResource that is
	 * composed of other VizResources.
	 * 
	 * @param resourceFile
	 * @param children
	 * @throws IOException
	 */
	public VizResource(File resourceFile, ArrayList<VizResource> children)
			throws IOException {
		this(resourceFile);
		childrenResources = children;

	}

	/**
	 * Return any possible children VizResources.
	 * 
	 * @return A list containing child viz resources.
	 */
	public ArrayList<VizResource> getChildrenResources() {
		return childrenResources;
	}

	/**
	 * Mutator for the file set
	 * 
	 * @param fileSet
	 *            The list of file names to add to the file set
	 */
	public void setFileSet(String[] fileSet) {
		for (String i : fileSet)
			logger.info(i);
		this.fileSet = fileSet;
	}

	/**
	 * Set the fileSetTitle
	 * 
	 * @param title
	 *            The String to use as the file set ID
	 */
	public void setFileSetTitle(String title) {
		fileSetTitle = title;
	}

	/**
	 * Accessor for the file set
	 * 
	 * @return The list of file names in the file set
	 */
	public String[] getFileSet() {
		return this.fileSet;
	}

	/**
	 * Accessor for the file set's title
	 * 
	 * @return The title used to identify the file set
	 */
	public String getFileSetTitle() {
		return this.fileSetTitle;
	}

	/**
	 * Set the remote file flag
	 * 
	 * @param name
	 *            The new name of the host. If local, use "localhost". Any other
	 *            hostname will be treated as remote.
	 */
	public void setHost(String name) {
		host = name;
		return;
	}

	/**
	 * Retrieve the name of the host for this file.
	 * 
	 * @return The String for the name of the host machine.
	 */
	public String getHost() {
		return host;
	}

	/**
	 * Retrieve the flag signifying if this file is on a remote machine or not.
	 * 
	 * @return True if this resource is on a remote machine; false otherwise
	 */
	public boolean isRemote() {
		return !"localhost".equals(host);
	}

	/**
	 * This operation is used to check equality between the VizResource and
	 * another VizResource. It returns true if the VizResources are equal and
	 * false if they are not.
	 * 
	 * @param resource
	 *            The other VizResource to which this VizResource should be
	 *            compared.
	 * @return True if the VizResources are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object resource) {

		// Default the return value to fail
		boolean retVal = false;

		// We're only interested if the types match and the resource exists
		if (resource instanceof VizResource && resource != null) {
			VizResource otherVizResource = (VizResource) resource;
			// Make sure all the identity information, etc., matches.
			retVal = super.equals(resource);
			// Check the children resources if they both exists
			retVal &= childrenResources
					.equals(otherVizResource.childrenResources);
			// Do the same check for the file sets
			if (fileSet != null && otherVizResource.fileSet != null) {
				// The files must be checked one by one because [] only checks
				// reference equality, not element equality.
				if (fileSet.length == otherVizResource.fileSet.length) {
					for (int i = 0; i < fileSet.length; i++) {
						retVal &= fileSet[i]
								.equals(otherVizResource.fileSet[i]);
					}
				} else {
					retVal = false;
				}
			} else if ((fileSet != null && otherVizResource.fileSet == null)
					|| (fileSet == null && otherVizResource.fileSet != null)) {
				// If one of the arrays of file sets is null, but the
				// other isn't, they are not equal.
				retVal = false;
			}
			// Check the host and title
			retVal &= (host.equals(otherVizResource.host))
					&& (fileSetTitle.equals(otherVizResource.fileSetTitle));
		}

		return retVal;
	}

	/**
	 * This operation returns the hashcode value of the VizResource.
	 * 
	 * @return The hashcode for the VizResource.
	 */
	@Override
	public int hashCode() {

		// Local Declaration
		int hash = 11;

		// Compute hashcode from ICEResource data
		hash = 31 * hash + super.hashCode() + childrenResources.hashCode();

		return hash;

	}

	/**
	 * This operation performs a deep copy of the attributes of another
	 * VizResource into the current VizResource.
	 * 
	 * @param otherResource
	 *            The other VizResource from which information should be copied.
	 */
	public void copy(VizResource otherResource) {

		if (otherResource != null) {
			// Copy all the base class stuff
			super.copy(otherResource);
			// Copy everything else we need
			fileSetTitle = otherResource.fileSetTitle;
			host = otherResource.host;
			childrenResources.clear();
			childrenResources = (ArrayList<VizResource>) otherResource.childrenResources
					.clone();
			fileSet = Arrays.copyOf(otherResource.fileSet,
					otherResource.fileSet.length);
		}
	}

	/**
	 * This operation provides a deep copy of the VizResource.
	 * 
	 * @return A clone of the VizResource.
	 */
	@Override
	public Object clone() {

		// Create a new instance of resource and copy contents
		VizResource resource = null;
		resource = new VizResource();
		resource.copy(this);

		return resource;
	}

}
