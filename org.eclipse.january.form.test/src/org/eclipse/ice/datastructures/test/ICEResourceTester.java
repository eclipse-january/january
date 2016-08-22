/*******************************************************************************
 * Copyright (c) 2012, 2016 UT-Battelle, LLC.
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
package org.eclipse.ice.datastructures.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.bind.JAXBException;

import org.eclipse.january.form.ContinuousEntry;
import org.eclipse.january.form.DiscreteEntry;
import org.eclipse.january.form.ICEJAXBClassProvider;
import org.eclipse.january.form.ICEJAXBHandler;
import org.eclipse.january.form.ICEResource;
import org.eclipse.january.form.IEntry;
import org.eclipse.january.form.StringEntry;
import org.junit.Test;

/**
 * <p>
 * This class is responsible for checking the ICEResource class.
 * </p>
 * 
 * @author Jay Jay Billings
 */
public class ICEResourceTester {
	/**
	 * 
	 */
	private ICEResource iCEResource;

	/**
	 * <p>
	 * This operation checks the construction of an ICEResource to insure that it
	 * can be created from both a java.io.File.
	 * </p>
	 * 
	 */
	@Test
	public void checkResourceCreation() {

		// Local Declarations
		String filename = "ICEResourceTestFile.testFile";
		File testFile = new File(filename);

		// Create the ICEResource using a java.io.File
		try {
			iCEResource = new ICEResource(testFile);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}

		// Check the default values of the name, id and description of the
		// Resource
		assertEquals(filename, iCEResource.getName());
		assertEquals(1, iCEResource.getId());
		assertEquals(testFile.getAbsolutePath(), iCEResource.getDescription());

	}

	/**
	 * <p>
	 * This operation checks the creation of the non nullary ICEResource
	 * constructor when passed a null parameter. Should throw a
	 * NullPointerException.
	 * </p>
	 * 
	 * @throws Class
	 * @throws Class
	 */
	@Test(expected = java.lang.NullPointerException.class)
	public void checkResourceCreationNullPointerException()
			throws NullPointerException, IOException {
		iCEResource = new ICEResource(null);

	}

	/**
	 * <p>
	 * This operation checks the contents of the File managed by an ICEResource.
	 * It also checks the get/setPath operations for URIs to make sure that the
	 * URI can be changed and that changing the URI changes the File.
	 * </p>
	 * 
	 */
	@Test
	public void checkContents() {

		// Local Declarations
		String filename = "ICEResourceTestFile.testFile";
		String filename2 = "ICEResourceTestFile.testFile2";
		File testFile = new File(filename);
		File testFile2 = new File(filename2);

		// Create the ICEResource using a java.io.File
		try {
			iCEResource = new ICEResource(testFile);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}

		// Make sure the File returned by getContents is the same file
		assertEquals(testFile, iCEResource.getContents());

		// Check the path against the File
		assertEquals(testFile.toURI(), iCEResource.getPath());

		// Check null constructor
		iCEResource = new ICEResource();

		assertNull(iCEResource.getContents());
		assertNull(iCEResource.getPath());
		assertEquals(iCEResource.getName(), "ICE Object");
		assertEquals(iCEResource.getDescription(), "ICE Object");

		// This is to check the get/setter for Path
		// Create the ICEResource with null constructor
		iCEResource = new ICEResource();

		// Set the file with setFile
		try {
			iCEResource.setContents(testFile);
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail(); // fail if this is hit
		} catch (IOException e) {
			e.printStackTrace();
			fail(); // fail if this is hit
		}

		// Check that the path is the correct URI
		assertTrue(iCEResource.getContents().equals(testFile));

		// Change the path
		iCEResource.setPath(testFile2.toURI());

		// Check that it has changed the path and file
		assertTrue(iCEResource.getPath().equals(testFile2.toURI()));
		assertTrue(iCEResource.getContents().getName()
				.equals(testFile2.getName()));
		assertTrue(iCEResource.getContents().getAbsolutePath()
				.equals(testFile2.getAbsolutePath()));

		// Try to pass null
		iCEResource.setPath(null);

		// Should not change
		assertTrue(iCEResource.getPath().equals(testFile2.toURI()));
		assertTrue(iCEResource.getContents().getName()
				.equals(testFile2.getName()));
		assertTrue(iCEResource.getContents().getAbsolutePath()
				.equals(testFile2.getAbsolutePath()));

		// Try to change the URI to same type
		// Should not change testFile2
		// Try to pass null
		iCEResource.setPath(testFile2.toURI());

		// Should not change
		assertTrue(iCEResource.getPath().equals(testFile2.toURI()));
		assertTrue(iCEResource.getContents().getName()
				.equals(testFile2.getName()));
		assertTrue(iCEResource.getContents().getAbsolutePath()
				.equals(testFile2.getAbsolutePath()));

	}

	/**
	 * <p>
	 * This operation checks the accessors for setting a list of properties on
	 * the ICEResource.
	 * </p>
	 * 
	 */
	@Test
	public void checkProperties() {
		// Local declarations
		ICEResource resource = null;
		File file;
		IEntry prop1, prop2, prop3;
		ArrayList<IEntry> properties;

		// Create some entries

		// Prop1 is a discrete with true and false
		prop1 = new DiscreteEntry();
		prop1.setAllowedValues(Arrays.asList("true","false"));
		prop1.setDefaultValue("true");
		
		// Prop2 is continuous between 1 and 100. Default 5
		prop2 = new ContinuousEntry();
		prop2.setAllowedValues(Arrays.asList("1","100"));
		prop2.setDefaultValue("5");

		// Prop3 is undefined. Value is "Ughn the Barbarian"
		prop3 = new StringEntry();
		prop3.setValue("Ughn the Barbarian");

		// Add the props to the properties list
		properties = new ArrayList<IEntry>();

		properties.add(prop1);
		properties.add(prop2);
		properties.add(prop3);

		// setup an ICEResource
		// Setup the file
		file = new File("An awesome file");

		// Create the ICEResource
		try {
			resource = new ICEResource(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// check that the properties is empty
		assertNotNull(resource.getProperties());
		assertEquals(0, resource.getProperties().size());

		// Add properties to the list
		resource.setProperties(properties);

		// Check that the list is set and the properties match
		assertNotNull(resource.getProperties());
		assertEquals(3, resource.getProperties().size());
		assertTrue(properties.equals(resource.getProperties()));

		// Assert that you can not pass null into the setter - no change
		resource.setProperties(null);

		// Check that the list is set and the properties match
		assertNotNull(resource.getProperties());
		assertEquals(3, resource.getProperties().size());
		assertTrue(properties.equals(resource.getProperties()));

		// Show that the list is a shallow copy upon entrance
		// and when the getter is called
		prop1.setName("Billy Bob Jones");
		assertTrue(prop1.equals(properties.get(0))); // Same entry
		assertTrue(properties.equals(resource.getProperties()));

		// Assert you can pass an empty arraylist and it will reset the list
		resource.setProperties(new ArrayList<IEntry>());

		// check that the properties is empty
		assertNotNull(resource.getProperties());
		assertEquals(0, resource.getProperties().size());

	}

	/**
	 * <p>
	 * This operation checks the ICEResource to insure that its equals()
	 * operation works.
	 * </p>
	 * 
	 */
	@Test
	public void checkEquality() {
		// Local declaration
		IEntry entry = new StringEntry();
		ArrayList<IEntry> properties = null;

		// setup entry and add to properties list
		entry.setName("Bob");
		properties = new ArrayList<IEntry>();
		properties.add(entry);

		// Create an ICEResource
		File testFile = new File("testFileName.xml");
		File anotherFile = new File("anotherTestFileName.xml");
		ICEResource resource = null, equalResource = null, unEqualResource = null, thirdEqualResource = null;
		try {
			// Instantiate an ICEResource, another one equal to that,
			// and a third ICEResource that is not the same
			resource = new ICEResource(testFile);
			resource.setProperties(properties);
			equalResource = new ICEResource(testFile);
			equalResource.setProperties(properties);
			thirdEqualResource = new ICEResource(testFile);
			thirdEqualResource.setProperties(properties);
			unEqualResource = new ICEResource(anotherFile);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}

		// Assert that equals returns true for 2 equal ICEResources
		assertTrue(resource.equals(equalResource));

		// Assert that equals returns false for 2 unequal ICEResources
		assertFalse(resource.equals(unEqualResource));

		// Check equals() is Reflexive
		// x.equals(x) = true
		assertTrue(resource.equals(resource));

		// Check that equals is Symmetric
		// x.equals(y) = true iff y.equals(x) = true
		assertTrue(resource.equals(equalResource)
				&& equalResource.equals(resource));

		// Check that equals is transitive
		// x.equals(y) = true, y.equals(z) = true => x.equals(z) = true
		if (resource.equals(equalResource)
				&& equalResource.equals(thirdEqualResource)) {
			assertTrue(resource.equals(thirdEqualResource));
		} else {
			fail();
		}

		// Check the Consistent nature of equals()
		assertTrue(resource.equals(resource) && resource.equals(resource)
				&& resource.equals(resource));

		assertTrue(!resource.equals(unEqualResource)
				&& !resource.equals(unEqualResource)
				&& !resource.equals(unEqualResource));

		// Check that equality with null returns false
		assertFalse(resource==null);

		// Assert that two equal ICEResources have equal hashcodes
		assertTrue(resource.equals(equalResource)
				&& resource.hashCode() == equalResource.hashCode());

		assertFalse(resource.hashCode() == unEqualResource.hashCode());

	}

	/**
	 * <p>
	 * This operation checks the ICEResource to ensure that its copy() and
	 * clone() operations work as specified.
	 * </p>
	 * 
	 */
	@Test
	public void checkCopying() {

		/*
		 * The following sets of operations will be used to test the
		 * "clone and copy" portion of ICEResource.
		 */

		// Test to show valid usage of clone

		// Local Declarations
		String filename = "ICEResourceTestFile.testFile";
		String filename2 = "ICEResourceTestFile2.testFile";
		File testFile = new File(filename);
		File testFile2 = new File(filename2);

		// Create the ICEResource using a java.io.File
		try {
			iCEResource = new ICEResource(testFile);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}

		// Run clone operation
		ICEResource cloneResource = (ICEResource) iCEResource.clone();

		// Check contents
		assertEquals(iCEResource.getContents(), cloneResource.getContents());
		assertEquals(iCEResource.getId(), cloneResource.getId());
		assertEquals(iCEResource.getLastModificationDate(),
				cloneResource.getLastModificationDate());
		assertEquals(iCEResource.getName(), cloneResource.getName());
		assertEquals(iCEResource.getPath(), cloneResource.getPath());

		// Test to show valid usage of copy

		// get a new instance
		try {
			iCEResource = new ICEResource(testFile);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}

		// Create a new instance of ICEResource and copy contents
		ICEResource copyResource = null;
		try {
			copyResource = new ICEResource(testFile2);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		copyResource.copy(iCEResource);

		// Check contents
		assertEquals(iCEResource.getContents(), copyResource.getContents());
		assertEquals(iCEResource.getId(), copyResource.getId());
		assertEquals(iCEResource.getLastModificationDate(),
				copyResource.getLastModificationDate());
		assertEquals(iCEResource.getName(), copyResource.getName());
		assertEquals(iCEResource.getPath(), copyResource.getPath());

		// Test to show an invalid use of copy - null args

		// get a new Instance
		try {
			iCEResource = new ICEResource(testFile);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}

		// Call copy with null, which should not change anything
		iCEResource.copy(null);

		// Check contents - nothing has changed
		assertEquals(iCEResource.getContents(), copyResource.getContents());
		assertEquals(iCEResource.getId(), copyResource.getId());
		assertEquals(iCEResource.getLastModificationDate(),
				copyResource.getLastModificationDate());
		assertEquals(iCEResource.getName(), copyResource.getName());
		assertEquals(iCEResource.getPath(), copyResource.getPath());

	}

	/**
	 * This operation checks the ability of the ICEResource to persist itself to
	 * XML and to load itself from an XML input stream.
	 * @throws IOException 
	 * @throws JAXBException 
	 * @throws NullPointerException 
	 */
	@Test
	public void checkXMLPersistence() throws NullPointerException, JAXBException, IOException {
		/*
		 * The following sets of operations will be used to test the
		 * "read and write" portion of the ICEResourceTester. It will
		 * demonstrate the behavior of reading and writing from an
		 * "XML (inputStream and outputStream)" file. It will use an annotated
		 * ICEResource to demonstrate basic behavior.
		 */

		// Local declarations
		ICEResource testNR = null, testNR2 = null;

		// Local Declarations
		String filename = "ICEResourceTestFile.testFile";
		String filename2 = "ICEResourceTestFile2.testFile";
		File testFile = new File(filename);
		File testFile2 = new File(filename2);
		IEntry prop1, prop2, prop3;
		ArrayList<IEntry> properties = null;
		ICEJAXBHandler xmlHandler = new ICEJAXBHandler();
		ArrayList<Class> classList = new ArrayList<Class>();
		classList.add(ICEResource.class);
		classList.addAll(new ICEJAXBClassProvider().getClasses());
		// Create some entries


		// Prop1 is a discrete with true and false
		prop1 = new DiscreteEntry();
		prop1.setAllowedValues(Arrays.asList("true","false"));
		prop1.setDefaultValue("true");
		
		// Prop2 is continuous between 1 and 100. Default 5
		prop2 = new ContinuousEntry();
		prop2.setAllowedValues(Arrays.asList("1","100"));
		prop2.setDefaultValue("5");

		// Prop3 is undefined. Value is "Ughn the Barbarian"
		prop3 = new StringEntry();
		prop3.setValue("Ughn the Barbarian");

		// Add the props to the properties list
		properties = new ArrayList<IEntry>();

		properties.add(prop1);
		properties.add(prop2);
		properties.add(prop3);

		// Create the ICEResource using a java.io.File
		try {
			iCEResource = new ICEResource(testFile);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}

		// Add properties to iCEResource
		iCEResource.setProperties(properties);

		// persist to an output stream
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		xmlHandler.write(iCEResource, classList, outputStream);

		// Initialize object and pass inputStream to read()
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				outputStream.toByteArray());
		try {
			testNR2 = new ICEResource(testFile2); // forces it to be different
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		testNR2 = (ICEResource) xmlHandler.read(classList, inputStream);

		// checkContents
		assertTrue(iCEResource.getProperties().get(0)
				.equals(testNR2.getProperties().get(0)));
		assertTrue(iCEResource.equals(testNR2));

	}

	/**
	 * <p>
	 * An operation that checks the isPictureType and setPictureType operations.
	 * </p>
	 * 
	 */
	@Test
	public void checkIsPicture() {
		// Local declarations
		ICEResource testNR = null, testNR2 = null;

		// Local Declarations
		String filename = "ICEResourceTestFile.testFile";
		String filename2 = "ICEResourceTestFile2.text";

		File testFile = new File(filename);
		File testFile2 = new File(filename2);

		// testFile is a .testFile extension and should not be a picture
		try {
			iCEResource = new ICEResource();
			testNR = new ICEResource(testFile);
			testNR2 = new ICEResource(testFile2);
			testNR2.setPictureType(true);

		} catch (IOException e) {
			fail(); // Should not happen
		}
		// Default of iCEResource is false with no file type set
		assertFalse(iCEResource.isPictureType());
		// Default of ICEResource is false with a file type set
		assertFalse(testNR.isPictureType());
		// If set to true, picture type is true
		assertTrue(testNR2.isPictureType());

		// Set the testNR2 to false
		testNR2.setPictureType(false);

		// If set to false, picture type is false
		assertFalse(testNR2.isPictureType());

	}
}