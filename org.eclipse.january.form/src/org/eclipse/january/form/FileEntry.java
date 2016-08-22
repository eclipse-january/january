/*******************************************************************************
 * Copyright (c) 2012, 2016- UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Initial API and implementation and/or initial documentation - Jay Jay Billings, 
 *    Jordan H. Deyton, Dasha Gorin, Alexander J. McCaskey, Taylor Patterson, 
 *    Claire Saunders, Matthew Wang, Anna Wojtowicz
 *     
 *******************************************************************************/
package org.eclipse.january.form;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

/**
 * FileEntry is a subclass of the DiscreteEntry that keeps track of a list of
 * files (as allowed values) for the user to select. The value for this IEntry
 * is the selected file name.
 * 
 * @author Alex McCaskey
 *
 */
@XmlRootElement(name = "FileEntry")
@XmlAccessorType(XmlAccessType.FIELD)
public class FileEntry extends DiscreteEntry implements IResourceChangeListener {

	/**
	 * Reference to the selected file.
	 */
	@XmlTransient
	protected IFile file;

	/**
	 * Reference to the IProject space that the Item containing this IEntry
	 * belongs to. This is used to query information about available files to
	 * list as allowed values.
	 */
	@XmlTransient
	protected IProject project;

	/**
	 * The file extension this FileEntry cares about. If provided, only files
	 * with this extension will be added to the list of allowed values.
	 */
	@XmlAttribute
	private String fileExtension;

	/**
	 * The Constructor
	 */
	public FileEntry() {
		super();
		fileExtension = "";
	}

	/**
	 * The constructor, with ability to specify file types clients care about
	 * for this FileEntry
	 * 
	 * @param fileType
	 */
	public FileEntry(String fileType) {
		super();
		fileExtension = fileType;
	}

	/**
	 * 
	 * @param files
	 */
	public FileEntry(String... files) {
		super(files);
		contextId = "org.eclipse.ice.client.widgets.FileEntry";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ice.datastructures.entry.DiscreteEntry#clone()
	 */
	@Override
	public Object clone() {
		FileEntry entry = new FileEntry();
		entry.copy(this);
		return entry;
	}

	/**
	 * This operation lets clients specify the IProject space for the Item
	 * containing this FileEntry.
	 * 
	 * @param projectSpace
	 *            The project this Entry belongs to.
	 */
	public void setProject(IProject projectSpace) {
		if (projectSpace != null) {
			project = projectSpace;
			generateAllowedValues();
			isModified = true;
			ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ice.datastructures.entry.DiscreteEntry#setValue(java.lang.
	 * String)
	 */
	@Override
	public boolean setValue(String newValue) {
		// Set the value as normal for a Discrete entry,
		// but also get a reference to the file.
		if (super.setValue(newValue)) {
			if (project != null) {
				file = project.getFile(newValue);
			}
			notifyListeners();
			return true;
		}
		return false;
	}

	/**
	 * Return the absolute file path for the selected file.
	 * 
	 * @return path
	 */
	public String getAbsoluteFilePath() {
		if (file != null) {
			return file.getLocation().toOSString();
		} else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ice.datastructures.entry.DiscreteEntry#setValue(java.lang.
	 * String[])
	 */
	@Override
	public boolean setValue(String... values) {
		throw new UnsupportedOperationException(
				"FileEntry only supports " + "the storage of one String value, not many, selected from "
						+ "a list of files in the IProject space. " + "Therefore, this operation is not supported.");

	}

	/**
	 * This private operation serves as a utility for generating a list of
	 * available files names in the project with the given file extension. These
	 * files are set as the allowed values for this DiscreteEntry.
	 */
	private void generateAllowedValues() {
		ArrayList<String> files = null, allFiles = null;

		// Make sure that the project is available
		if (project != null && project.isAccessible()) {
			allFiles = new ArrayList<String>();
			// Get the files from the project space
			try {
				// Load the file names into the list
				IResource[] resources = project.members();
				for (int i = 0; i < resources.length; i++) {
					// Only load files, not directories
					if (resources[i].getType() == IResource.FILE && !resources[i].getName().startsWith(".")) {
						allFiles.add(resources[i].getName());
					}
				}
				// Remove the files that are of the wrong type if and only if a
				// type has been selected
				if (fileExtension != null && !fileExtension.isEmpty()) {
					files = new ArrayList<String>();
					int size = allFiles.size();
					// Check all the files
					for (int i = 0; i < size; i++) {
						String fileName = allFiles.get(i);
						if (fileName.endsWith(fileExtension)) {
							// Add the correct ones to the list
							files.add(fileName);
						}
					}
				} else {
					// Return all the files
					files = allFiles;
				}
			} catch (CoreException e) {
				// Complain
				logger.info("FileEntry Message: " + "Unable to load project files!");
				logger.error(getClass().getName() + " Exception!", e);
			}
		}

		allowedValues = files;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Identifiable#equals(Object otherObject)
	 */
	@Override
	public boolean equals(Object otherObject) {

		if (otherObject != null && (otherObject instanceof FileEntry)) {

			// Make sure everything else is equal
			if (!super.equals(otherObject)) {
				return false;
			}

			// Cast to a DiscreteEntry, we know it is if we are here
			FileEntry otherEntry = (FileEntry) otherObject;

			// Make sure the allowedValues are the same.
			if (fileExtension.equals(otherEntry.fileExtension)) {
				return true;
			}
		}

		return false;
	}

	public void copy(FileEntry entity) {

		// Return if null
		if (entity == null) {
			return;
		}

		super.copy(entity);
		allowedValues = entity.allowedValues;
		return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ice.datastructures.entry.AbstractEntry#hashCode()
	 */
	@Override
	public int hashCode() {

		// Local Declaration
		int hash = 11;

		// Compute the hashcode from this ICEObject's data
		hash = 31 * hash + super.hashCode();
		hash = 31 * hash + fileExtension.hashCode();

		return hash;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ice.datastructures.entry.DiscreteEntry#accept(org.eclipse.ice
	 * .datastructures.entry.IEntryVisitor)
	 */
	@Override
	public void accept(IEntryVisitor visitor) {
		visitor.visit(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.resources.IResourceChangeListener#resourceChanged(org.
	 * eclipse.core.resources.IResourceChangeEvent)
	 */
	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		if (project != null) {
			if (event.getType() == IResourceChangeEvent.POST_CHANGE) {
				try {
					event.getDelta().accept(new IResourceDeltaVisitor() {
						public boolean visit(IResourceDelta delta) throws CoreException {
							IProject p = delta.getResource().getProject();
							if (p != null && p.getName().equals(project.getName())) {
								generateAllowedValues();
								notifyListeners();
							}
							return true;
						}
					});
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
