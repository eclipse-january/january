/*******************************************************************************
 * Copyright (c) 2013, 2016 UT-Battelle, LLC.
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
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.eclipse.january.form.ContinuousEntry;
import org.eclipse.january.form.DiscreteEntry;
import org.eclipse.january.form.JanuaryJAXBHandler;
import org.eclipse.january.form.IEntry;
import org.eclipse.january.form.StringEntry;
import org.eclipse.january.form.TimeDataComponent;
import org.junit.Test;

/**
 * <p>
 * A class that tests the TimeDataComponent.
 * </p>
 * 
 * @author Scott Forest Hull II
 */
public class TimeDataComponentTester {
	/**
	 * <p>
	 * Checks the construction operations.
	 * </p>
	 * 
	 */
	@Test
	public void checkConstruction() {


		// Local Declarations
		String defaultName = "TimeDataComponent 1";
		int defaultId = 1;
		String defaultDescription = "TimeDataComponent 1's Description";
		IEntry entry1, entry2, entry3, entry4, entry5;
		TimeDataComponent timeComponent;
		int entryCount = 0;
		ArrayList<IEntry> entryList = new ArrayList<IEntry>();

		// Setup Entries for comparison
		entry1 = new DiscreteEntry();
		List<String> allowed = new ArrayList<String>();
		allowed.add("True");
		allowed.add("False");
		entry1.setAllowedValues(allowed);
		entry1.setDefaultValue("True");
		entry1.setTag("MODE");
		entry1.setName("Enable Regular Mode");
		entry1.setDescription("Time loop's mode.  Can be Regular (true) or Explicit (false)");
		entryCount++;
		entry1.setId(entryCount);
		entryList.add(entry1);

		// Entry: START
		entry2 = new ContinuousEntry();
		List<String> allowed2 = new ArrayList<String>();
		allowed.add("0");
		allowed.add("99999999");
		entry2.setAllowedValues(allowed2);
		entry2.setName("Start");
		entry2.setTag("START");
		entry2.setDescription("Time loop's start time. Can start between allowed values.");
		entry2.setDefaultValue("0");
		entryCount++;
		entry2.setId(entryCount);
		entryList.add(entry2);

		// Entry: FINISH
		entry3 = new ContinuousEntry();
		List<String> allowed3 = new ArrayList<String>();
		allowed.add("1");
		allowed.add("99999999");
		entry3.setAllowedValues(allowed3);
		entry3.setName("Finish");
		entry3.setTag("FINISH");
		entry3.setDescription("Time loop's finish time. Can finish between allowed values.");
		entry3.setDefaultValue("30");
		entryCount++;
		entry3.setId(entryCount);
		entryList.add(entry3);

		// Entry: NSTEP
		entry4 = new ContinuousEntry();
		List<String> allowed4 = new ArrayList<String>();
		allowed.add("1");
		allowed.add("99999999");
		entry4.setAllowedValues(allowed4);
		entry4.setName("The number to step");
		entry4.setTag("NSTEP");
		entry4.setDescription("Time loop's number to step. Can be set between allowed values.");
		entry4.setDefaultValue("1");
		entryCount++;
		entry4.setId(entryCount);
		entryList.add(entry4);

		// Entry: VALUES
		entry5 = new StringEntry();
		entry5.setName("VALUES");
		entry5.setTag("VALUES");
		entry5.setDescription("Time loop's values.");
		entry5.setDefaultValue("4.4, 3.5, 3.6, 3.7");
		entryCount++;
		entry5.setId(entryCount);
		entryList.add(entry5);

		// Create a nullary timeComponent
		timeComponent = new TimeDataComponent();
		// Check values
		assertEquals(defaultName, timeComponent.getName());
		assertEquals(defaultId, timeComponent.getId());
		assertEquals(defaultDescription, timeComponent.getDescription());
		assertTrue(entryList.equals(timeComponent.retrieveAllEntries()));

		// Create a non-nullary timeComponent - REGULAR
		timeComponent = new TimeDataComponent("REGULAR");
		// Check values
		assertEquals(defaultName, timeComponent.getName());
		assertEquals(defaultId, timeComponent.getId());
		assertEquals(defaultDescription, timeComponent.getDescription());
		assertTrue(entryList.equals(timeComponent.retrieveAllEntries()));

		// Create a non-nullary timeComponent - badValue
		timeComponent = new TimeDataComponent("1@#BADVALUE");
		// Check values - defaults
		assertEquals(defaultName, timeComponent.getName());
		assertEquals(defaultId, timeComponent.getId());
		assertEquals(defaultDescription, timeComponent.getDescription());
		assertTrue(entryList.equals(timeComponent.retrieveAllEntries()));

		// Create a non-nullary timeComponent - null
		timeComponent = new TimeDataComponent(null);
		// Check values
		assertEquals(defaultName, timeComponent.getName());
		assertEquals(defaultId, timeComponent.getId());
		assertEquals(defaultDescription, timeComponent.getDescription());
		assertTrue(entryList.equals(timeComponent.retrieveAllEntries()));

		// Reset values here for ready state
		entry1.setValue("False");
		entry2.setReady(false);
		entry3.setReady(false);
		entry4.setReady(false);

		// Create a nullary timeComponent
		timeComponent = new TimeDataComponent("EXPLICIT");
		// Check values
		assertEquals(defaultName, timeComponent.getName());
		assertEquals(defaultId, timeComponent.getId());
		assertEquals(defaultDescription, timeComponent.getDescription());
		// Set to the new entry list of ready values
		assertTrue(entryList.equals(timeComponent.retrieveAllEntries()));

	}

	/**
	 * Checks loading and persisting to XML.
	 * 
	 * @throws IOException
	 * @throws JAXBException
	 * @throws NullPointerException
	 */
	@Test
	public void checkXMLPersistence() throws NullPointerException,
			JAXBException, IOException {

		// Local declarations
		int id = 20110901;
		String name = "September 1st 2011";
		String description = "The 1st day of the ninth month in the year of "
				+ "our Lord 2011";
		JanuaryJAXBHandler xmlHandler = new JanuaryJAXBHandler();
		ArrayList<Class> classList = new ArrayList<Class>();
		classList.add(TimeDataComponent.class);
		classList.add(StringEntry.class);
		classList.add(DiscreteEntry.class);
		classList.add(ContinuousEntry.class);


		// Create the DataComponent
		TimeDataComponent dataComponent = new TimeDataComponent();
		TimeDataComponent loadDataComponent = new TimeDataComponent();

		// Set the id, name and description
		dataComponent.setId(id);
		dataComponent.setDescription(description);
		dataComponent.setName(name);

		// Demonstrate a basic "write" to file. Should not fail

		// persist to an output stream
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		xmlHandler.write(dataComponent, classList, outputStream);

		// Initialize object and pass inputStream to read()
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				outputStream.toByteArray());

		// create a new instance of a different variable to compare
		loadDataComponent = new TimeDataComponent();

		// load into TimeDataComponent();
		loadDataComponent = (TimeDataComponent) xmlHandler.read(classList,
				inputStream);

		// check contents
		assertTrue(dataComponent.equals(loadDataComponent));

	}

	/**
	 * <p>
	 * Checks copying and clone routines.
	 * </p>
	 * 
	 */
	@Test
	public void checkCopying() {


		// Local declarations
		int id = 20110901;
		String name = "September 1st 2011";
		String description = "The 1st day of the ninth month in the year of "
				+ "our Lord 2011";
		TimeDataComponent cloneData = new TimeDataComponent();
		TimeDataComponent copyData = new TimeDataComponent();
		TestComponentListener listener = new TestComponentListener();

		// Create the TimeDataComponent
		TimeDataComponent dataComponent = new TimeDataComponent();

		// Set the id, name and description and listener
		dataComponent.setId(id);
		dataComponent.setDescription(description);
		dataComponent.setName(name);
		dataComponent.register(listener);

		// Test to show valid usage of clone

		// Run clone operation
		cloneData = (TimeDataComponent) dataComponent.clone();

		// check Contents
		assertTrue(dataComponent.equals(cloneData));

		// Test to show valid usage of copy
		// Use dataComponent from above

		// run copy operation
		copyData.copy(dataComponent);

		// check Contents
		assertTrue(dataComponent.equals(copyData));

		/*----- Test to show an invalid use of copy - null args -----*/

		// Call copy with null, which should not change anything
		copyData.copy(null);

		// check contents, nothing has changed1's
		// check Contents
		assertTrue(dataComponent.equals(copyData));

		return;
	}

	/**
	 * <p>
	 * An operation that checks the equality operations.
	 * </p>
	 * 
	 */
	@Test
	public void checkEquality() {


		// Create TimeDataComponents to test
		TimeDataComponent component = new TimeDataComponent();
		TimeDataComponent equalComponent = new TimeDataComponent();
		TimeDataComponent unEqualComponent = new TimeDataComponent();
		TimeDataComponent transitiveComponent = new TimeDataComponent();

		// Change name on unEqualComponent
		unEqualComponent.retrieveAllEntries()
				.get(unEqualComponent.retrieveAllEntries().size() - 1)
				.setName("DifferentFoo");

		// Assert two equal TimeDataComponents return true
		assertTrue(component.equals(equalComponent));

		// Assert two unequal TimeDataComponents return false
		assertFalse(component.equals(unEqualComponent));

		// Assert equals() is reflexive
		assertTrue(component.equals(component));

		// Assert the equals() is Symmetric
		assertTrue(component.equals(equalComponent)
				&& equalComponent.equals(component));

		// Assert equals() is transitive
		if (component.equals(equalComponent)
				&& equalComponent.equals(transitiveComponent)) {
			assertTrue(component.equals(transitiveComponent));
		} else {
			fail();
		}

		// Assert equals is consistent
		assertTrue(component.equals(equalComponent)
				&& component.equals(equalComponent)
				&& component.equals(equalComponent));
		assertTrue(!component.equals(unEqualComponent)
				&& !component.equals(unEqualComponent)
				&& !component.equals(unEqualComponent));

		// Assert checking equality with null is false
		assertFalse(component == null);

		// Assert that two equal objects return same hashcode
		assertTrue(component.equals(equalComponent)
				&& component.hashCode() == equalComponent.hashCode());

		// Assert that hashcode is consistent
		assertTrue(component.hashCode() == component.hashCode());

		// Assert that hashcodes from unequal objects are different
		assertTrue(component.hashCode() != unEqualComponent.hashCode());


	}
}