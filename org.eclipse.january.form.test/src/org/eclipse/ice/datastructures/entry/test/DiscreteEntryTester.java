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
import java.util.List;

import javax.xml.bind.JAXBException;

import org.eclipse.january.form.DiscreteEntry;
import org.eclipse.january.form.ICEJAXBHandler;
import org.junit.Test;

/**
 * This tests that we can set only specified allowed values. 
 * 
 * @author Alex McCaskey
 *
 */
public class DiscreteEntryTester {

	/**
	 * Check that we can only set allowed values. 
	 */
	@Test
	public void checkSetValue() {
		List<String> allowed = new ArrayList<String>();
		allowed.add("true");
		allowed.add("false");
		
		DiscreteEntry entry = new DiscreteEntry();
		entry.setAllowedValues(allowed);
		entry.setDefaultValue("true");
		entry.setId(4);
		entry.setName("Full Valid Entry");
		
		// Make sure the call to Entry.setValue returns true
		// if the value is accepted
		assertEquals("true", entry.getDefaultValue());
		assertEquals(true, entry.setValue("true"));
		// Check the value
		assertEquals("true", entry.getValue());

		// Make sure the call to Entry.setValue returns true
		// if the value is accepted
		assertEquals(true, entry.setValue("false"));
		// Check the value
		assertEquals("false", entry.getValue());
		// Make sure that the Entry's change state is true
		assertEquals(true, entry.isModified());

		// Make sure the the Entry returns false
		// the value is not accepted
		assertEquals(false, entry.setValue("Overburdened."));

		// Set value back to make sure the error is false
		assertEquals(true, entry.setValue("true"));

	}
	
	/**
	 * This operation checks the Entry to ensure that its copy() and clone()
	 * operations work as specified.
	 */
	@Test
	public void checkCopying() {

		// Local Declarations
		DiscreteEntry entry = new DiscreteEntry();
		List<String> allowed = new ArrayList<String>();
		allowed.add("true");
		allowed.add("false");

		/*
		 * The following sets of operations will be used to test the
		 * "clone and copy" portion of Entry.
		 */
		entry.setAllowedValues(allowed);
		entry.setId(6);
		entry.setName("Copy Test Entry");
		entry.setDescription("Fluffy Bunny");
		entry.setValue("8675309");
		entry.setComment("Peanut butter and jelly");
		entry.setTag("ChevyChase");
		entry.setRequired(true);

		// Create a new instance of Entry and copy contents
		DiscreteEntry entryCopy = new DiscreteEntry();
		entryCopy.copy(entry);

		// Check contents
		assertTrue(entry.equals(entryCopy));

		// Test to show valid usage of clone

		// Run clone operation
		DiscreteEntry cloneEntry = (DiscreteEntry) entry.clone();

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
		DiscreteEntry copyOfEntry = new DiscreteEntry();
		DiscreteEntry otherEntry = new DiscreteEntry();
		DiscreteEntry entry = new DiscreteEntry();
		List<String> allowed = new ArrayList<String>();
		allowed.add("true");
		allowed.add("false");
		
		// Setup the base AbstractEntry
		entry.setAllowedValues(allowed);
		entry.setId(6);
		entry.setName("Copy Test Entry");
		entry.setDescription("Fluffy Bunny");
		entry.setValue("8675309");
		entry.setComment("Peanut butter and jelly");
		entry.setTag("ChevyChase");
		entry.setRequired(true);

		copyOfEntry.setAllowedValues(allowed);
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

		List<String> newAllowed = new ArrayList<String>(allowed);//allowed.remove(1);
		newAllowed.remove(1);
		
		DiscreteEntry badEqual = new DiscreteEntry();
		badEqual.setAllowedValues(newAllowed);
		badEqual.setId(entry.getId());
		badEqual.setName(entry.getName());
		badEqual.setDescription(entry.getDescription());
		badEqual.setValue(entry.getValue());
		badEqual.setComment(entry.getComment());
		badEqual.setTag("ChevyChase");
		badEqual.setRequired(true);
		
		assertFalse(entry.equals(badEqual));
		
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
		DiscreteEntry entry2;
		List<String> allowed = new ArrayList<String>();
		allowed.add("true");
		allowed.add("false");
		ICEJAXBHandler xmlHandler = new ICEJAXBHandler();
		ArrayList<Class> classList = new ArrayList<Class>();
		classList.add(DiscreteEntry.class);

		// Fill out Entry and override setup
		DiscreteEntry myEntry = new DiscreteEntry();
		myEntry.setAllowedValues(allowed);
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
			entry2 = (DiscreteEntry) xmlHandler.read(classList, inputStream);

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
