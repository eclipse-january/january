/*******************************************************************************
 *  * Copyright (c) 2012, 2016 UT-Battelle, LLC.
 *   * All rights reserved. This program and the accompanying materials
 *    * are made available under the terms of the Eclipse Public License v1.0
 *     * which accompanies this distribution, and is available at
 *      * http://www.eclipse.org/legal/epl-v10.html
 *       *
 *        * Contributors:
 *         *   Initial API and implementation and/or initial documentation - Jay Jay Billings,
 *          *   Jordan H. Deyton, Dasha Gorin, Alexander J. McCaskey, Taylor Patterson,
 *           *   Claire Saunders, Matthew Wang, Anna Wojtowicz
 *            *******************************************************************************/
package org.eclipse.ice.datastructures.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.eclipse.january.form.ICEJAXBHandler;
import org.eclipse.january.form.VizResource;
import org.junit.Test;

/**
 *  * This class is responsible for checking the VizResource class
 *   * 
 *    * @author Taylor Patterson
 *     * 
 *      */
public class VizResourceTester {

	/**
 * 	 * The VizResource to use for testing.
 * 	 	 */
	private VizResource vizResource;

	/**
 * 	 * Check the setFileSet and getFileSet operations.
 * 	 	 */
	@Test
	public void checkFileSet() {

		// Initialize the VizResource
		vizResource = new VizResource();

		// Ensure null initialization
		assertNull(vizResource.getFileSet());

		// Create a file set
		String[] fakeFilenames = { "Benjamin", "Buford", "Blue" };

		// Set the file set
		vizResource.setFileSet(fakeFilenames);

		// Check that the file set is set
		assertNotNull(vizResource.getFileSet());
		assertEquals(3, vizResource.getFileSet().length);
		assertTrue(fakeFilenames.equals(vizResource.getFileSet()));

	}

	/**
	 * Check the setFileSetTitle and getFileSetTitle operations.
	 */
	@Test
	public void checkFileSetTitle() {

		// Initialize the VizResource
		vizResource = new VizResource();

		// Ensure it is not null to start
		assertNotNull(vizResource.getFileSetTitle());

		// Set the file set title
		vizResource.setFileSetTitle("Bubba");

		// Check that the file set title is set
		assertNotNull(vizResource.getFileSetTitle());
		assertTrue("Bubba".equals(vizResource.getFileSetTitle()));

	}

	/**
	 * Check the setRemote and isRemote operations.
	 */
	@Test
	public void checkIsRemote() {

		// Initialize the VizResource
		vizResource = new VizResource();

		// Set the host to 'localhost'
		vizResource.setHost("localhost");

		// Check that the resource is not remote
		assertFalse(vizResource.isRemote());

		// Set the host to something else
		vizResource.setHost("notlocalhost");

		// Not the resource should be remote
		assertTrue(vizResource.isRemote());

	}

	/**
	 * This operation makes sure that the VizResource can be written to and read
	 * from XML properly.
	 * 
	 * @throws IOException
	 * @throws JAXBException
	 * @throws NullPointerException
	 */
	@Test
	public void checkXMLPersistence()
			throws NullPointerException, JAXBException, IOException {

		// Local declarations
		VizResource vizResource = null, loadedResource = null;
		VizResource childRes1 = new VizResource(new File("1")),
				childRes2 = new VizResource(new File("2"));
		childRes2.setId(2);
		childRes2.setName("2");
		ArrayList<VizResource> childResources = new ArrayList<VizResource>();
		childResources.add(childRes1);
		childResources.add(childRes2);
		String[] fileSet = { "one", "two", "three" };
		String title = "title", host = "localhost";
		String filename = "ICEResourceTestFile.testFile";
		String filename2 = "ICEResourceTestFile2.testFile";
		ICEJAXBHandler xmlHandler = new ICEJAXBHandler();
		ArrayList<Class> classList = new ArrayList<Class>();
		classList.add(VizResource.class);

		// Create the VizResource and load it up with a lot of stuff to persist
		vizResource = new VizResource(new File(filename), childResources);
		vizResource.setFileSet(fileSet);
		vizResource.setFileSetTitle(title);
		vizResource.setHost(host);

		// persist to an output stream
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		xmlHandler.write(vizResource, classList, outputStream);

		// Initialize object and pass inputStream to read()
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				outputStream.toByteArray());
		loadedResource = (VizResource) xmlHandler.read(classList, inputStream);

		// checkContents
		assertTrue(vizResource.equals(loadedResource));

	}

	/**
	 * This operation checks the equals() and hashcode() operations of
	 * VizResource.
	 * 
	 * @throws IOException
	 */
	@Test
	public void checkEquality() throws IOException {

		// Local declarations
		VizResource vizResource = null, equalResource = null;
		VizResource childRes1 = new VizResource(),
				childRes2 = new VizResource();
		ArrayList<VizResource> childResources = new ArrayList<VizResource>();
		childResources.add(childRes1);
		childResources.add(childRes2);
		String[] fileSet = { "one", "two", "three" };
		String title = "title", host = "localhost";
		String filename = "ICEResourceTestFile.testFile";

		// Create the VizResource and load it up with a lot of stuff to persist
		vizResource = new VizResource(new File(filename), childResources);
		vizResource.setFileSet(fileSet);
		vizResource.setFileSetTitle(title);
		vizResource.setHost(host);

		// Create the second, equal resource
		equalResource = new VizResource(new File(filename), childResources);
		equalResource.setFileSet(fileSet);
		equalResource.setFileSetTitle(title);
		equalResource.setHost(host);

		// Check them
		assertEquals(vizResource, equalResource);
		assertEquals(vizResource.hashCode(), equalResource.hashCode());
	}

	/**
	 * This operation makes sure that copying and cloning the VizResource works.
	 * 
	 * @throws IOException
	 */
	@Test
	public void checkCopying() throws IOException {

		// Local declarations
		VizResource vizResource = null, equalResource = new VizResource();
		VizResource childRes1 = new VizResource(),
				childRes2 = new VizResource();
		ArrayList<VizResource> childResources = new ArrayList<VizResource>();
		childResources.add(childRes1);
		childResources.add(childRes2);
		String[] fileSet = { "one", "two", "three" };
		String title = "title", host = "localhost";
		String filename = "ICEResourceTestFile.testFile";

		// Create the VizResource and load it up with a lot of stuff to persist
		vizResource = new VizResource(new File(filename), childResources);
		vizResource.setFileSet(fileSet);
		vizResource.setFileSetTitle(title);
		vizResource.setHost(host);

		// Create the second, equal resource and check it
		equalResource.copy(vizResource);
		assertEquals(vizResource, equalResource);

		// Now check it as a clone
		equalResource = null;
		equalResource = (VizResource) vizResource.clone();
		assertEquals(vizResource, equalResource);

		return;
	}

}
