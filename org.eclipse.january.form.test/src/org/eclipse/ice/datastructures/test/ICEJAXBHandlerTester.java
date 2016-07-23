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
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.eclipse.january.form.ICEJAXBHandler;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * The ICEJAXBHandlerTester is responsible for testing the checks the
 * ICEJAXBHandler to ensure that it can read and write to the streams
 * properly. It used the SimpleJAXBTestClass.
 * </p>
 * 
 * @author Jay Jay Billings
 */

public class ICEJAXBHandlerTester {
	/**
	 * 
	 */
	private SimpleJAXBTestClass simpleJAXBTestClass;
	/**
	 * 
	 */
	private ICEJAXBHandler iCEJAXBManipulator;

	/**
	 * The list of classes used by the JAXB handler
	 */
	ArrayList<Class> classList = new ArrayList<Class>();
	
	/**
	 * <p>
	 * An operation that sets up some of the tests. @Before Annotation used.
	 * </p>
	 * 
	 */
	@Before
	public void setupTests() {

		// Initialize the test class and ICEJAXBHandler
		simpleJAXBTestClass = new SimpleJAXBTestClass();
		iCEJAXBManipulator = new ICEJAXBHandler();
		classList.add(SimpleJAXBTestClass.class);

	}

	/**
	 * <p>
	 * This operation checks the ICEJAXBHandler to ensure that it can read
	 * and write to the streams properly. It used the SimpleJAXBTestClass.
	 * </p>
	 * 
	 */
	@Test
	public void checkXMLPersistence() {
		/*
		 * The following sets of operations will be used to test the
		 * "read and write" portion of the ICE JAXBManipulator. It will
		 * demonstrate the behavior of reading and writing from an
		 * "XML (inputStream and outputStream)" file. It will use an annotated
		 * SimpleJAXBTestClass to demonstrate basic behavior.
		 */

		// Basic operation that should not fail

		// Demonstrate a basic read in. Create file in memory and convert to an
		// inputstream.
		String xmlFile = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
				+ "<SimpleJAXBTestClass int=\"1\"/>\n";

		InputStream inputStream = new ByteArrayInputStream(xmlFile.getBytes());

		// Initialize Manipulator and pass inputStream to read()
		iCEJAXBManipulator = new ICEJAXBHandler();
		Object data;

		// Try to do the read, fail if an exception is caught.
		try {
			data = iCEJAXBManipulator.read(classList,
					inputStream);
			// Cast data to SimpleJAXBTestClass and check contents
			simpleJAXBTestClass = (SimpleJAXBTestClass) data;
			assertEquals(simpleJAXBTestClass.getInt(), 1);
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail();
		} catch (JAXBException e) {
			e.printStackTrace();
			fail();
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}

		// Demonstrate a basic "write" to file. Should not fail

		// Initialize the testclass and set integer.
		simpleJAXBTestClass = new SimpleJAXBTestClass();
		simpleJAXBTestClass.setInt(1);

		// persist to an output stream
		OutputStream outputStream = new ByteArrayOutputStream();
		iCEJAXBManipulator = new ICEJAXBHandler();

		// Try to do the write, fail if an exception is caught.
		try {
			iCEJAXBManipulator.write(simpleJAXBTestClass, classList, outputStream);
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail();
		} catch (JAXBException e) {
			e.printStackTrace();
			fail();
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}

		// Check outputStream - convert to string and compare
		String xmlFile2 = outputStream.toString();
		assertEquals(xmlFile, xmlFile2); // Should be the same!
	}

	/**
	 * <p>
	 * This test checks the behavior ICEJAXBHandler.read() operation when a
	 * null Class parameter is passed. The testing method should throw a
	 * NullPointerException.
	 * </p>
	 * 
	 * @throws NullPointerException
	 * @throws IOException
	 * @throws JAXBException
	 */
	@Test(expected = java.lang.NullPointerException.class)
	public void checkXMLPersistenceReadOperationWithClassAsNull()
			throws NullPointerException, IOException, JAXBException {
		// Local declarations
		String xmlFile = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
				+ "<SimpleJAXBTestClass int=\"0\"/>";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				xmlFile.getBytes());
		Object data;

		// The next following tests demonstrate behavior for when you pass null
		// args for read()
		// Make sure that the read pointer throws a null pointer exception if
		// the Class is null
		data = null;
		data = iCEJAXBManipulator.read(null, inputStream); // Throws
															// NullPointerException

	}

	/**
	 * <p>
	 * This test checks the behavior ICEJAXBHandler.read() operation when a
	 * null inputStream parameter is passed. The testing method should throw a
	 * NullPointerException.
	 * </p>
	 * 
	 * @throws IOException
	 * @throws JAXBException
	 * @throws NullPointerException
	 */
	@Test(expected = java.lang.NullPointerException.class)
	public void checkXMLPersistenceReadOperationWithInputStreamAsNull()
			throws IOException, JAXBException, NullPointerException {
		// Make sure that the read pointer throws a null pointer exception if
		// the stream is null
		iCEJAXBManipulator.read(classList, null);

	}

	/**
	 * <p>
	 * This test checks the behavior ICEJAXBHandler.write() operation when a
	 * null Object parameter is passed. The testing method should throw a
	 * NullPointerException.
	 * </p>
	 * 
	 * @throws IOException
	 * @throws JAXBException
	 * @throws NullPointerException
	 */
	@Test(expected = java.lang.NullPointerException.class)
	public void checkXMLPersistenceWriteOperationWithObjectAsNull()
			throws IOException, JAXBException, NullPointerException {
		// Initialize variables
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		// test for write - null args
		iCEJAXBManipulator.write(null, classList, outputStream);

	}

	/**
	 * <p>
	 * This test checks the behavior ICEJAXBHandler.write() operation when a
	 * null inputStream parameter is passed. The testing method should throw a
	 * NullPointerException.
	 * </p>
	 * 
	 * @throws IOException
	 * @throws JAXBException
	 * @throws NullPointerException
	 */
	@Test(expected = java.lang.NullPointerException.class)
	public void checkXMLPersistenceWriteOperationWithInputStreamAsNull()
			throws IOException, JAXBException, NullPointerException {
		// Catch a null pointer exception
		iCEJAXBManipulator.write(simpleJAXBTestClass,classList, null);

	}

	/**
	 * <p>
	 * This test checks the behavior ICEJAXBHandler.read() operation when an
	 * invalid inputStream parameter is passed. The testing method should throw
	 * a JAXBException.
	 * </p>
	 * 
	 * @throws IOException
	 * @throws JAXBException
	 * @throws NullPointerException
	 */
	@Test(expected = javax.xml.bind.JAXBException.class)
	public void checkXMLPersistenceReadWithInvalidInputStream()
			throws IOException, JAXBException, NullPointerException {
		// Setup the invalid XML String and then convert it to InputStream
		String xmlFile = "A String not in XML";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				xmlFile.getBytes());

		// Should throw a JAXBException on the invalid InputStream
		iCEJAXBManipulator.read(classList, inputStream);

	}

	/**
	 * <p>
	 * This test checks the behavior ICEJAXBHandler.read() operation when an
	 * invalid object is passed. The testing method should throw a
	 * JAXBException. The testing method should throw a JAXBException.
	 * </p>
	 * 
	 * @throws IOException
	 * @throws JAXBException
	 * @throws NullPointerException
	 */
	@Test(expected = javax.xml.bind.JAXBException.class)
	public void checkXMLPersistenceReadWithInvalidObject() throws IOException,
			JAXBException, NullPointerException {
		// This test will demonstrate the reaction of JAXB marshallers on a
		// object that is not annotated (for read)

		// Local declarations
		ByteArrayInputStream inputStream = null;
		String xmlFile = null;
		Object j = null;

		// initialize a random object
		// This object is not annotated
		j = new Object();

		// Create a valid "object" xml string
		xmlFile = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
				+ "<object/>";
		// create new inputStream from the xmlFile
		inputStream = new ByteArrayInputStream(xmlFile.getBytes());

		// This method should throw a JAXBException.
		iCEJAXBManipulator.read(classList, inputStream);

	}

	/**
	 * <p>
	 * This test checks the behavior ICEJAXBHandler.write() operation when
	 * an invalid object is passed. The testing method should throw a
	 * JAXBException.
	 * </p>
	 * 
	 * @throws IOException
	 * @throws JAXBException
	 * @throws NullPointerException
	 */
	@Test(expected = javax.xml.bind.JAXBException.class)
	public void checkXMLPersistenceWriteWithInvalidObject() throws IOException,
			JAXBException, NullPointerException {
		// This test will demonstrate the reaction of JAXB marshallers on a
		// object that is not annotated (for write)

		Object j = new Object();

		// create outputStream
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		// This operation should throw a JAXBException
		iCEJAXBManipulator.write(j, classList, outputStream);

	}
}