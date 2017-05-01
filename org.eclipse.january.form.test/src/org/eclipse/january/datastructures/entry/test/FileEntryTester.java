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
package org.eclipse.january.datastructures.entry.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.january.form.FileEntry;
import org.eclipse.january.form.JanuaryJAXBHandler;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * This class tests the functionality of the FileEntry.
 *
 * @author Alex McCaskey
 *
 */
@Ignore
public class FileEntryTester {

	/**
	 * Reference to the itemData project.
	 */
	private static IProject project;

	/**
	 * <p>
	 * This operation checks the project setup of the Item to ensure that
	 * calling the constructor with an IProject and Item.setProject() setup the
	 * project reference such that Item.hasProject() returns true.
	 * </p>
	 *
	 */
	@BeforeClass
	public static void beforeClass() {

		// Local Declarations
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		URI defaultProjectLocation = null;
		String separator = System.getProperty("file.separator");

		// Setup the project
		try {
			// Get the project handle
			project = workspaceRoot.getProject("itemData");
			// If the project does not exist, create it
			if (!project.exists()) {
				// Set the location as ${workspace_loc}/ItemTesterWorkspace
				defaultProjectLocation = new File(
						System.getProperty("user.home") + separator + "JanuaryTests"
								+ separator + "itemData").toURI();
				// Create the project description
				IProjectDescription desc = ResourcesPlugin.getWorkspace()
						.newProjectDescription("itemData");
				// Set the location of the project
				desc.setLocationURI(defaultProjectLocation);
				// Create the project
				project.create(desc, null);
			}
			// Open the project if it is not already open
			if (project.exists() && !project.isOpen()) {
				project.open(null);
			}
		} catch (CoreException e) {
			// Catch for creating the project
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Check that files are populated in the allowed values list.
	 */
	@Test
	public void checkAllowedValues() {
		// Make sure we can construct a FileEntry
		// and it correctly sets up its allowed values.
		FileEntry entry = new FileEntry();
		entry.setProject(project);

		// We have 7 files in itemData right now
		// MAKE SURE WE UPDATE THIS IF IT CHANGES
		assertEquals(7, entry.getAllowedValues().size());

		// Now try it where we specify the file extension
		FileEntry yamlFiles = new FileEntry("yaml");
		yamlFiles.setProject(project);
		assertEquals(1, yamlFiles.getAllowedValues().size());

		// Check that if we add a file and update,
		// the allowed values change to record that
		IFile file = project.getFile("newFile.txt");
		try {
			file.create(new ByteArrayInputStream(new String("").getBytes()), true, null);
		} catch (CoreException e) {
			e.printStackTrace();
			fail();
		}

		assertEquals(8, entry.getAllowedValues().size());

		try {
			file.delete(true, null);
		} catch (CoreException e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Check that we can set the file, and that
	 * the file path is reported correctly.
	 */
	@Test
	public void checkSetValue() {
		// We are gonna test that we can get the file path,
		// so set the expected path.
		String separator = System.getProperty("file.separator");
		String actualPath = System.getProperty("user.home") + separator + "JanuaryTests"
				+ separator + "itemData" + separator + "moose_test.yaml";

		// Create a FileEntry over yaml files.
		FileEntry entry = new FileEntry("yaml");
		entry.setProject(project);

		// Make sure we can't set an unallowed value
		assertFalse(entry.setValue("hello.yaml"));

		// Set the allowed value.
		assertTrue(entry.setValue("moose_test.yaml"));

		// Make sure the IFile was set correctly.
		assertEquals(actualPath, entry.getAbsoluteFilePath());
	}

	/**
	 * This operation checks the Entry to ensure that its copy() and clone()
	 * operations work as specified.
	 */
	@Test
	public void checkCopying() {

		// Local Declarations
		FileEntry entry = new FileEntry();
		entry.setProject(project);

		/*
		 * The following sets of operations will be used to test the
		 * "clone and copy" portion of Entry.
		 */
		entry.setId(6);
		entry.setName("Copy Test Entry");
		entry.setDescription("Fluffy Bunny");
		entry.setValue("8675309");
		entry.setComment("Peanut butter and jelly");
		entry.setTag("ChevyChase");
		entry.setRequired(true);

		// Create a new instance of Entry and copy contents
		FileEntry entryCopy = new FileEntry();
		entryCopy.copy(entry);

		// Check contents
		assertTrue(entry.equals(entryCopy));

		// Test to show valid usage of clone

		// Run clone operation
		FileEntry cloneEntry = (FileEntry) entry.clone();

		// Check contents
		assertTrue(entry.equals(cloneEntry));

		// Call copy with null, which should not change anything
		entry.copy(null);

		// Check contents - nothing has changed
		assertTrue(entry.equals(entryCopy));

		return;
	}

	/**
	 * This operation checks the AbstractEntry class to insure that its copy operation
	 * works.
	 */
	@Test
	public void checkEquality() {

		// Local Declarations
		FileEntry copyOfEntry = new FileEntry();
		FileEntry otherEntry = new FileEntry("yaml");
		FileEntry entry = new FileEntry();

		entry.setProject(project);
		copyOfEntry.setProject(project);
		otherEntry.setProject(project);

		// Setup the base AbstractEntry
		entry.setId(6);
		entry.setName("Copy Test Entry");
		entry.setDescription("Fluffy Bunny");
		entry.setValue("8675309");
		entry.setComment("Peanut butter and jelly");
		entry.setTag("ChevyChase");
		entry.setRequired(true);

		copyOfEntry.setId(entry.getId());
		copyOfEntry.setName(entry.getName());
		copyOfEntry.setDescription(entry.getDescription());
		copyOfEntry.setValue(entry.getValue());
		copyOfEntry.setComment(entry.getComment());
		copyOfEntry.setTag("ChevyChase");
		copyOfEntry.setRequired(true);


		// Test AbstractEntry.equals(), first one should be true, second false
		assertEquals(entry.equals(copyOfEntry), true);
		assertEquals(entry.equals(otherEntry), false);

		// Check Entry.hashcode(), first one should be true, second true,
		// third false and fourth false
		assertEquals(entry.hashCode(), entry.hashCode());
		assertEquals(entry.hashCode(), copyOfEntry.hashCode());
		copyOfEntry.setId(444);
		assertEquals(entry.hashCode() == copyOfEntry.hashCode(), false);
		assertEquals(entry.hashCode() == otherEntry.hashCode(), false);


		return;
	}

	/**
	 * This operation checks the ability of the DiscreteEntry to persist itself to XML
	 * and to load itself from an XML input stream.
	 */
	@Test
	public void checkXMLPersistence() {

		/*
		 * The following sets of operations will be used to test the
		 * "read and write" portion of the Entry. It will demonstrate the
		 * behavior of reading and writing from an "XML (inputStream and
		 * outputStream)" file. It will use an annotated Entry to demonstrate
		 * basic behavior.
		 */

		// Local declarations
		FileEntry entry2;
		JanuaryJAXBHandler xmlHandler = new JanuaryJAXBHandler();
		ArrayList<Class> classList = new ArrayList<Class>();
		classList.add(FileEntry.class);

		// Fill out Entry and override setup
		FileEntry myEntry = new FileEntry();
		myEntry.setProject(project);
		myEntry.setId(1);
		myEntry.setName("Simple Entry");
		myEntry.setComment("Peanut butter and jelly");
		myEntry.setTag("ChevyChase");

		// Demonstrate a basic "write" to file. Should not fail
		try {
			// persist to an output stream
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			xmlHandler.write(myEntry, classList, outputStream);
			System.err.println(outputStream.toString());

			// Demonstrate a basic read in. Create file in memory and convert to
			// an
			// inputstream.
			InputStream inputStream = new ByteArrayInputStream(
					outputStream.toByteArray());

			// Initialize object and pass inputStream to read()
			entry2 = (FileEntry) xmlHandler.read(classList, inputStream);

			// Check contents - currently broken due to isReady() needs to
			// return a
			// class Boolean
			// not an attribute Scott Forest Hull II
			assertTrue(myEntry.equals(entry2));

		} catch (NullPointerException | JAXBException | IOException e) {
			e.printStackTrace();
			fail();
		}

		return;
	}

}
