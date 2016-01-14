package org.eclipse.ice.datastructures.entry;

import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ice.datastructures.ICEObject.IUpdateable;

public class FileEntry extends DiscreteEntry {

	private IFile file;
	private IProject project;
	private String fileExtension;

	public FileEntry() {
		super();
	}

	public FileEntry(String fileType) {
		super();
		fileExtension = fileType;
	}

	@Override
	public Object clone() {
		FileEntry entry = new FileEntry();
		entry.copy(this);
		return entry;
	}

	public void setProject(IProject projectSpace) {
		project = projectSpace;
		generateAllowedValues();
		isModified = true;
	}

	@Override
	public boolean setValue(String newValue) {
		if (super.setValue(newValue)) {
			file = project.getFile(newValue);
			return true;
		}
		return false;
	}
	
	public String getAbsoluteFilePath() {
		return file.getLocation().toOSString();
	}
	
	@Override
	public boolean setValue(String... values) {
		throw new UnsupportedOperationException(
				"FileEntry only supports " + "the storage of one String value, not many, selected from "
						+ "a list of files in the IProject space. " + "Therefore, this operation is not supported.");

	}

	@Override
	public void update(IUpdateable component) {
		// TODO Auto-generated method stub

	}

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
					if (resources[i].getType() == IResource.FILE) {
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
				logger.info("Item Message: " + "Unable to load project files!");
				logger.error(getClass().getName() + " Exception!", e);
			}
		}

		allowedValues = files;
	}
}
