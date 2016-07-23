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
package org.eclipse.ice.datastructures.entry.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.eclipse.january.form.AbstractEntry;
import org.eclipse.january.form.ICEJAXBHandler;
import org.junit.Test;

/**
 * This class tests the functionality of the AbstractEntry 
 * by using a test concrete subclass of it. 
 * 
 * It checks that we can get/set basic IEntry attributes, 
 * that we can set/get the IEntry value, that we can perform 
 * equality and copy, and that the AbstractEntry can be persisted 
 * to XML. 
 * 
 * @author Alex McCaskey
 *
 */
public class AbstractEntryTester {

	/**
	 * Reference to the AbstractEntry to test.
	 */
	private TestableAbstractEntry entry;
	
	/**
	 * Check that we can get/set basic IEntry properties. 
	 */
	@Test
	public void checkBasicProperties() {
		
		// Create an AbstractEntry
		entry = new TestableAbstractEntry();
		
		// Check the already set stuff
		assertEquals("ICE Entry", entry.getName());
		assertEquals("default", entry.getContext());
		assertEquals("",entry.getDefaultValue());
		assertEquals("ICE Entry", entry.getDescription());
		assertEquals(1, entry.getId());
		assertEquals("", entry.getComment());
		assertEquals("", entry.getTag());
		assertTrue(entry.isReady());
		assertFalse(entry.isModified());
		assertTrue(entry.isRequired());
		
		// Try changing it and check again
		entry.setName("Entry Name");
		entry.setDefaultValue("powerball");
		entry.setDescription("I am described.");
		entry.setId(234);
		entry.setComment("I am a comment in a file corresponding to a parameter.");
		entry.setTag("I forget what this tag should be about.");
		entry.setReady(false);
		entry.setRequired(false);

		assertEquals("Entry Name", entry.getName());
		assertEquals("powerball", entry.getDefaultValue());
		assertEquals("I am described.", entry.getDescription());
		assertEquals(234, entry.getId());
		assertEquals("I am a comment in a file corresponding to a parameter.", entry.getComment());
		assertEquals("I forget what this tag should be about.", entry.getTag());
		assertFalse(entry.isReady());
		assertFalse(entry.isModified());
		assertFalse(entry.isRequired());

	}
	
	/**
	 * Check that we can set the value appropriately.
	 */
	@Test
	public void checkSetValue() {
		entry = new TestableAbstractEntry();

		// Create and AbstractEntry
		entry = new TestableAbstractEntry();

		// Try setting a null value. 
		String value = null;
		assertFalse(entry.setValue(value));
		assertFalse(entry.isModified());
		
		// Try setting a good value
		value = "Value";
		assertTrue(entry.setValue(value));
		assertEquals(value, entry.getValue());
		assertTrue(entry.isModified());
	}
	
	/**
	 * This operation checks the AbstractEntry class to insure that its copy operation
	 * works.
	 */
	@Test
	public void checkEquality() {

		// Local Declarations
		TestableAbstractEntry copyOfEntry = new TestableAbstractEntry();
		TestableAbstractEntry otherEntry = new TestableAbstractEntry();
		entry = new TestableAbstractEntry();

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
	 * This operation checks the AbstractEntry to ensure that its copy() and clone()
	 * operations work as specified.
	 */
	@Test
	public void checkCopying() {

		/*
		 * The following sets of operations will be used to test the
		 * "clone and copy" portion of AbstractEntry.
		 */
		entry = new TestableAbstractEntry();

		entry.setId(6);
		entry.setName("Copy Test Entry");
		entry.setDescription("Fluffy Bunny");
		entry.setValue("8675309");
		entry.setComment("Peanut butter and jelly");
		entry.setTag("ChevyChase");
		entry.setRequired(true);

		// Create a new instance of AbstractEntry and copy contents
		AbstractEntry entryCopy = new TestableAbstractEntry();
		entryCopy.copy(entry);

		// Check contents
		assertTrue(entry.equals(entryCopy));

		// Call copy with null, which should not change anything
		entry.copy(null);

		// Check contents - nothing has changed
		assertTrue(entry.equals(entryCopy));

		return;
	}

	/**
	 * This operation checks the ability of the AbstractEntry to persist itself to XML
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
		TestableAbstractEntry entry2;
		ICEJAXBHandler xmlHandler = new ICEJAXBHandler();
		ArrayList<Class> classList = new ArrayList<Class>();
		classList.add(TestableAbstractEntry.class);

		// Fill out Entry and override setup
		TestableAbstractEntry myEntry = new TestableAbstractEntry();
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
			entry2 = (TestableAbstractEntry) xmlHandler.read(classList, inputStream);

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
