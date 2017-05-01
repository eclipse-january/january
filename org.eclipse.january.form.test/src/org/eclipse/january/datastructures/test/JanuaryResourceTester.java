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
package org.eclipse.january.datastructures.test;

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
import org.eclipse.january.form.JanuaryJAXBClassProvider;
import org.eclipse.january.form.JanuaryJAXBHandler;
import org.eclipse.january.form.JanuaryResource;
import org.eclipse.january.form.IEntry;
import org.eclipse.january.form.StringEntry;
import org.junit.Test;

/**
 * <p>
 * This class is responsible for checking the JanuaryResource class.
 * </p>
 * 
 * @author Jay Jay Billings
 */
public class JanuaryResourceTester {
	/**
	 * 
	 */
	private JanuaryResource JanuaryResource;

	/**
	 * <p>
	 * This operation checks the construction of an JanuaryResource to insure that it
	 * can be created from both a java.io.File.
	 * </p>
	 * 
	 */
	@Test
	public void checkResourceCreation() {

		// Local Declarations
		String filename = "JanuaryResourceTestFile.testFile";
		File testFile = new File(filename);

		// Create the JanuaryResource using a java.io.File
		try {
			JanuaryResource = new JanuaryResource(testFile);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}

		// Check the default values of the name, id and description of the
		// Resource
		assertEquals(filename, JanuaryResource.getName());
		assertEquals(1, JanuaryResource.getId());
		assertEquals(testFile.getAbsolutePath(), JanuaryResource.getDescription());

	}

	/**
	 * <p>
	 * This operation checks the creation of the non nullary JanuaryResource
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
		JanuaryResource = new JanuaryResource(null);

	}

	/**
	 * <p>
	 * This operation checks the contents of the File managed by an JanuaryResource.
	 * It also checks the get/setPath operations for URIs to make sure that the
	 * URI can be changed and that changing the URI changes the File.
	 * </p>
	 * 
	 */
	@Test
	public void checkContents() {

		// Local Declarations
		String filename = "JanuaryResourceTestFile.testFile";
		String filename2 = "JanuaryResourceTestFile.testFile2";
		File testFile = new File(filename);
		File testFile2 = new File(filename2);

		// Create the JanuaryResource using a java.io.File
		try {
			JanuaryResource = new JanuaryResource(testFile);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}

		// Make sure the File returned by getContents is the same file
		assertEquals(testFile, JanuaryResource.getContents());

		// Check the path against the File
		assertEquals(testFile.toURI(), JanuaryResource.getPath());

		// Check null constructor
		JanuaryResource = new JanuaryResource();

		assertNull(JanuaryResource.getContents());
		assertNull(JanuaryResource.getPath());
		assertEquals(JanuaryResource.getName(), "January Object");
		assertEquals(JanuaryResource.getDescription(), "January Object");

		// This is to check the get/setter for Path
		// Create the JanuaryResource with null constructor
		JanuaryResource = new JanuaryResource();

		// Set the file with setFile
		try {
			JanuaryResource.setContents(testFile);
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail(); // fail if this is hit
		} catch (IOException e) {
			e.printStackTrace();
			fail(); // fail if this is hit
		}

		// Check that the path is the correct URI
		assertTrue(JanuaryResource.getContents().equals(testFile));

		// Change the path
		JanuaryResource.setPath(testFile2.toURI());

		// Check that it has changed the path and file
		assertTrue(JanuaryResource.getPath().equals(testFile2.toURI()));
		assertTrue(JanuaryResource.getContents().getName()
				.equals(testFile2.getName()));
		assertTrue(JanuaryResource.getContents().getAbsolutePath()
				.equals(testFile2.getAbsolutePath()));

		// Try to pass null
		JanuaryResource.setPath(null);

		// Should not change
		assertTrue(JanuaryResource.getPath().equals(testFile2.toURI()));
		assertTrue(JanuaryResource.getContents().getName()
				.equals(testFile2.getName()));
		assertTrue(JanuaryResource.getContents().getAbsolutePath()
				.equals(testFile2.getAbsolutePath()));

		// Try to change the URI to same type
		// Should not change testFile2
		// Try to pass null
		JanuaryResource.setPath(testFile2.toURI());

		// Should not change
		assertTrue(JanuaryResource.getPath().equals(testFile2.toURI()));
		assertTrue(JanuaryResource.getContents().getName()
				.equals(testFile2.getName()));
		assertTrue(JanuaryResource.getContents().getAbsolutePath()
				.equals(testFile2.getAbsolutePath()));

	}

	/**
	 * <p>
	 * This operation checks the accessors for setting a list of properties on
	 * the JanuaryResource.
	 * </p>
	 * 
	 */
	@Test
	public void checkProperties() {
		// Local declarations
		JanuaryResource resource = null;
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

		// setup an JanuaryResource
		// Setup the file
		file = new File("An awesome file");

		// Create the JanuaryResource
		try {
			resource = new JanuaryResource(file);
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
	 * This operation checks the JanuaryResource to insure that its equals()
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

		// Create an JanuaryResource
		File testFile = new File("testFileName.xml");
		File anotherFile = new File("anotherTestFileName.xml");
		JanuaryResource resource = null, equalResource = null, unEqualResource = null, thirdEqualResource = null;
		try {
			// Instantiate an JanuaryResource, another one equal to that,
			// and a third JanuaryResource that is not the same
			resource = new JanuaryResource(testFile);
			resource.setProperties(properties);
			equalResource = new JanuaryResource(testFile);
			equalResource.setProperties(properties);
			thirdEqualResource = new JanuaryResource(testFile);
			thirdEqualResource.setProperties(properties);
			unEqualResource = new JanuaryResource(anotherFile);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}

		// Assert that equals returns true for 2 equal JanuaryResources
		assertTrue(resource.equals(equalResource));

		// Assert that equals returns false for 2 unequal JanuaryResources
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

		// Assert that two equal JanuaryResources have equal hashcodes
		assertTrue(resource.equals(equalResource)
				&& resource.hashCode() == equalResource.hashCode());

		assertFalse(resource.hashCode() == unEqualResource.hashCode());

	}

	/**
	 * <p>
	 * This operation checks the JanuaryResource to ensure that its copy() and
	 * clone() operations work as specified.
	 * </p>
	 * 
	 */
	@Test
	public void checkCopying() {

		/*
		 * The following sets of operations will be used to test the
		 * "clone and copy" portion of JanuaryResource.
		 */

		// Test to show valid usage of clone

		// Local Declarations
		String filename = "JanuaryResourceTestFile.testFile";
		String filename2 = "JanuaryResourceTestFile2.testFile";
		File testFile = new File(filename);
		File testFile2 = new File(filename2);

		// Create the JanuaryResource using a java.io.File
		try {
			JanuaryResource = new JanuaryResource(testFile);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}

		// Run clone operation
		JanuaryResource cloneResource = (JanuaryResource) JanuaryResource.clone();

		// Check contents
		assertEquals(JanuaryResource.getContents(), cloneResource.getContents());
		assertEquals(JanuaryResource.getId(), cloneResource.getId());
		assertEquals(JanuaryResource.getLastModificationDate(),
				cloneResource.getLastModificationDate());
		assertEquals(JanuaryResource.getName(), cloneResource.getName());
		assertEquals(JanuaryResource.getPath(), cloneResource.getPath());

		// Test to show valid usage of copy

		// get a new instance
		try {
			JanuaryResource = new JanuaryResource(testFile);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}

		// Create a new instance of JanuaryResource and copy contents
		JanuaryResource copyResource = null;
		try {
			copyResource = new JanuaryResource(testFile2);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		copyResource.copy(JanuaryResource);

		// Check contents
		assertEquals(JanuaryResource.getContents(), copyResource.getContents());
		assertEquals(JanuaryResource.getId(), copyResource.getId());
		assertEquals(JanuaryResource.getLastModificationDate(),
				copyResource.getLastModificationDate());
		assertEquals(JanuaryResource.getName(), copyResource.getName());
		assertEquals(JanuaryResource.getPath(), copyResource.getPath());

		// Test to show an invalid use of copy - null args

		// get a new Instance
		try {
			JanuaryResource = new JanuaryResource(testFile);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}

		// Call copy with null, which should not change anything
		JanuaryResource.copy(null);

		// Check contents - nothing has changed
		assertEquals(JanuaryResource.getContents(), copyResource.getContents());
		assertEquals(JanuaryResource.getId(), copyResource.getId());
		assertEquals(JanuaryResource.getLastModificationDate(),
				copyResource.getLastModificationDate());
		assertEquals(JanuaryResource.getName(), copyResource.getName());
		assertEquals(JanuaryResource.getPath(), copyResource.getPath());

	}

	/**
	 * This operation checks the ability of the JanuaryResource to persist itself to
	 * XML and to load itself from an XML input stream.
	 * @throws IOException 
	 * @throws JAXBException 
	 * @throws NullPointerException 
	 */
	@Test
	public void checkXMLPersistence() throws NullPointerException, JAXBException, IOException {
		/*
		 * The following sets of operations will be used to test the
		 * "read and write" portion of the JanuaryResourceTester. It will
		 * demonstrate the behavior of reading and writing from an
		 * "XML (inputStream and outputStream)" file. It will use an annotated
		 * JanuaryResource to demonstrate basic behavior.
		 */

		// Local declarations
		JanuaryResource testNR = null, testNR2 = null;

		// Local Declarations
		String filename = "JanuaryResourceTestFile.testFile";
		String filename2 = "JanuaryResourceTestFile2.testFile";
		File testFile = new File(filename);
		File testFile2 = new File(filename2);
		IEntry prop1, prop2, prop3;
		ArrayList<IEntry> properties = null;
		JanuaryJAXBHandler xmlHandler = new JanuaryJAXBHandler();
		ArrayList<Class> classList = new ArrayList<Class>();
		classList.add(JanuaryResource.class);
		classList.addAll(new JanuaryJAXBClassProvider().getClasses());
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

		// Create the JanuaryResource using a java.io.File
		try {
			JanuaryResource = new JanuaryResource(testFile);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}

		// Add properties to JanuaryResource
		JanuaryResource.setProperties(properties);

		// persist to an output stream
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		xmlHandler.write(JanuaryResource, classList, outputStream);

		// Initialize object and pass inputStream to read()
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				outputStream.toByteArray());
		try {
			testNR2 = new JanuaryResource(testFile2); // forces it to be different
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		testNR2 = (JanuaryResource) xmlHandler.read(classList, inputStream);

		// checkContents
		assertTrue(JanuaryResource.getProperties().get(0)
				.equals(testNR2.getProperties().get(0)));
		assertTrue(JanuaryResource.equals(testNR2));

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
		JanuaryResource testNR = null, testNR2 = null;

		// Local Declarations
		String filename = "JanuaryResourceTestFile.testFile";
		String filename2 = "JanuaryResourceTestFile2.text";

		File testFile = new File(filename);
		File testFile2 = new File(filename2);

		// testFile is a .testFile extension and should not be a picture
		try {
			JanuaryResource = new JanuaryResource();
			testNR = new JanuaryResource(testFile);
			testNR2 = new JanuaryResource(testFile2);
			testNR2.setPictureType(true);

		} catch (IOException e) {
			fail(); // Should not happen
		}
		// Default of JanuaryResource is false with no file type set
		assertFalse(JanuaryResource.isPictureType());
		// Default of JanuaryResource is false with a file type set
		assertFalse(testNR.isPictureType());
		// If set to true, picture type is true
		assertTrue(testNR2.isPictureType());

		// Set the testNR2 to false
		testNR2.setPictureType(false);

		// If set to false, picture type is false
		assertFalse(testNR2.isPictureType());

	}
}