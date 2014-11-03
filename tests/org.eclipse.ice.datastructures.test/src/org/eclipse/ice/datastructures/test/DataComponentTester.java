/*******************************************************************************
 * Copyright (c) 2012, 2014 UT-Battelle, LLC.
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

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import org.eclipse.ice.datastructures.form.DataComponent;
import org.eclipse.ice.datastructures.form.Entry;

import org.junit.*;

/**
 * <!-- begin-UML-doc -->
 * <p>
 * The DataComponentTester class is responsible for testing the DataComponent
 * class.
 * </p>
 * <!-- end-UML-doc -->
 * 
 * @author jaybilly
 * @generated 
 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DataComponentTester {
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The DataComponent to be tested.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private DataComponent dataComponent;
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The TestComponentListener used to subscribe to and check notifications
	 * from the DataComponent.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private TestComponentListener testComponentListener;

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * A TestVisitor that is used to test the visitation scheme.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private TestVisitor testVisitor;

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation tests the construction of the DataComponent class and the
	 * functionality inherited from ICEObject.
	 * </p>
	 * <!-- end-UML-doc -->
	 */
	@Test
	public void checkCreation() {
		// begin-user-code

		// Local declarations
		int id = 20110901;
		String name = "September 1st 2011";
		String description = "The 1st day of the ninth month in the year of "
				+ "our Lord 2011";

		// Create the DataComponent
		dataComponent = new DataComponent();

		// Set the id, name and description
		dataComponent.setId(id);
		dataComponent.setDescription(description);
		dataComponent.setName(name);

		// Check the id, name and description
		assertEquals(dataComponent.getDescription(), description);
		assertEquals(dataComponent.getId(), id);
		assertEquals(dataComponent.getName(), name);

		return;

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation tests the DataComponent class by making sure that Entry
	 * can be added to the component.
	 * </p>
	 * <!-- end-UML-doc -->
	 */
	@Test
	public void checkAddingEntries() {
		// begin-user-code

		// Location Declarations
		int i = 0, numEntries = 50;
		ArrayList<Entry> entries = new ArrayList<Entry>();
		ArrayList<Entry> retEntries = null;
		Entry Entry = null;

		// Setup the list of Entries
		for (i = 0; i < numEntries; i++) {
			entries.add(new Entry());
			(entries.get(i)).setId(i);
			(entries.get(i)).setName("Test Entry " + i);
		}
		(entries.get(4)).setReady(false);
		(entries.get(39)).setReady(false);

		// Add the Entries to the DataComponent
		dataComponent = new DataComponent();
		for (i = 0; i < numEntries; i++) {
			dataComponent.addEntry(entries.get(i));
		}

		// Retrieve the Entries one-by-one and check them
		for (i = 0; i < entries.size(); i++) {
			Entry = dataComponent.retrieveEntry("Test Entry " + i);
			assertEquals(Entry.getId(), (entries.get(i)).getId());
		}

		// Retrieve the Entries in a block and check them
		retEntries = dataComponent.retrieveAllEntries();
		assertNotNull(retEntries);
		assertEquals(entries.size(), retEntries.size());
		for (i = 0; i < numEntries; i++) {
			assertEquals((retEntries.get(i)).getId(), (entries.get(i)).getId());
			assertEquals((retEntries.get(i)).getName(),
					(entries.get(i)).getName());
		}

		// Get only the Entries that are ready
		retEntries = dataComponent.retrieveReadyEntries();
		assertEquals(48, retEntries.size());

		return;

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation tests the DataComponent class to make sure that Entries
	 * can be cleared and deleted.
	 * </p>
	 * <!-- end-UML-doc -->
	 */
	@Test
	public void checkClearingEntries() {
		// begin-user-code

		// Location Declarations
		int i = 0, numEntries = 50;
		ArrayList<Entry> entries = new ArrayList<Entry>();
		ArrayList<Entry> retEntries = null;
		// Setup the list of Entries
		for (i = 0; i < numEntries; i++) {
			entries.add(new Entry());
			(entries.get(i)).setId(i);
			(entries.get(i)).setName("Test Entry " + i);
		}

		// Add the Entries to the DataComponent
		dataComponent = new DataComponent();
		for (i = 0; i < numEntries; i++) {
			dataComponent.addEntry(entries.get(i));
		}

		// Delete three Entries and make sure they were deleted
		dataComponent.deleteEntry(entries.get(23).getName());
		dataComponent.deleteEntry(entries.get(17).getName());
		dataComponent.deleteEntry(entries.get(32).getName());
		// retrieve the entries to see if the size changed.
		retEntries = dataComponent.retrieveAllEntries();
		assertEquals(numEntries - 3, retEntries.size());
		assertNotSame((retEntries.get(23)).getId(), 23);
		assertNotSame((retEntries.get(17)).getId(), 17);
		assertNotSame((retEntries.get(32)).getId(), 32);

		return;

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation tests the DataComponent class to insure that checking for
	 * Entry containment functions properly.
	 * </p>
	 * <!-- end-UML-doc -->
	 */
	@Test
	public void checkContainment() {
		// begin-user-code

		// Location Declarations
		int i = 0, numEntries = 50;
		ArrayList<Entry> entries = new ArrayList<Entry>();

		// Setup the list of Entries
		for (i = 0; i < numEntries; i++) {
			entries.add(new Entry());
			(entries.get(i)).setId(i);
			(entries.get(i)).setName("Test Entry " + i);
		}

		// Add the Entries to the DataComponent
		dataComponent = new DataComponent();
		for (i = 0; i < numEntries; i++) {
			dataComponent.addEntry(entries.get(i));
		}

		// Retrieve the Entries one-by-one and check them
		for (i = 0; i < numEntries; i++) {
			assertTrue(dataComponent.contains((entries.get(i)).getName()));
		}

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation checks the ability of the DataComponent to update its
	 * Entries.
	 * </p>
	 * <!-- end-UML-doc -->
	 */
	@Test
	public void checkUpdate() {
		// begin-user-code

		// Location Declarations
		int i = 0, numEntries = 10;
		ArrayList<Entry> entries = new ArrayList<Entry>();
		ArrayList<Entry> retEntries = null;
		String value = "3D";

		// Setup the list of Entries
		for (i = 0; i < numEntries; i++) {
			entries.add(new Entry() {
				@Override
				public void update(String key, String newValue) {
					if ("Blender".equals(key)) {
						this.value = newValue;
					}
				}
			});
			(entries.get(i)).setId(i);
			(entries.get(i)).setName("Test Entry " + i);
			(entries.get(i)).setValue("2D");
		}

		// Add the Entries to the DataComponent
		dataComponent = new DataComponent();
		for (i = 0; i < numEntries; i++) {
			dataComponent.addEntry(entries.get(i));
		}

		// Update the DataComponent
		dataComponent.update("Blender", value);

		// Check the updated Entries
		retEntries = dataComponent.retrieveAllEntries();
		assertEquals(numEntries, retEntries.size());
		for (i = 0; i < retEntries.size(); i++) {
			assertEquals(value, retEntries.get(i).getValue());
		}

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation tests the DataComponent to insure that it can properly
	 * dispatch notifications when it receives an update that changes its state.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkNotifications() {
		// begin-user-code

		// Local Declarations
		Entry testEntry = new Entry();
		TestComponentListener secondTestComponentListener = new TestComponentListener();

		// Setup the listener
		testComponentListener = new TestComponentListener();

		// Setup the DataComponent
		dataComponent = new DataComponent();

		// Register the listener
		dataComponent.register(testComponentListener);

		// Create a new Entry in the DataComponent
		dataComponent.addEntry(testEntry);
		// Check the Listener
		assertTrue(testComponentListener.wasNotified());
		// Reset the listener
		testComponentListener.reset();

		// Change the value of the Entry
		testEntry.setValue("Entry Value Change Test");
		// Check the Listener
		assertTrue(testComponentListener.wasNotified());
		// Reset the listener
		testComponentListener.reset();

		// Add the second listener
		dataComponent.register(secondTestComponentListener);
		// Change the value of the Entry
		testEntry.setValue("Second listener test value");
		// Check the Listeners
		assertTrue(testComponentListener.wasNotified());
		assertTrue(secondTestComponentListener.wasNotified());
		// Reset the listeners
		testComponentListener.reset();
		secondTestComponentListener.reset();

		// Remove the Entry
		dataComponent.clearEntries();
		// Check the listener to make sure it was updated
		assertTrue(testComponentListener.wasNotified());
		// Reset the listener
		testComponentListener.reset();

		// Change the name of the component
		dataComponent.setName("Warren Buffett");
		// Check the listener to make sure it was updated
		assertTrue(testComponentListener.wasNotified());
		// Reset the listener
		testComponentListener.reset();

		// Change the id of the component
		dataComponent.setId(899);
		// Change the name of the component
		dataComponent.setName("Warren Buffett");
		// Check the listener to make sure it was updated
		assertTrue(testComponentListener.wasNotified());

		return;

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation checks the DataComponent to insure that it can be
	 * correctly visited by a realization of the IComponentVisitor interface.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkVisitation() {
		// begin-user-code

		// Setup the visitor
		testVisitor = new TestVisitor();

		// Setup the DataComponent
		dataComponent = new DataComponent();

		// Send the visitor
		dataComponent.accept(testVisitor);

		// Check the visitor
		assertTrue(testVisitor.wasVisited());

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation checks the DataComponent to insure that its equals() and
	 * hashcode() operations work.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkEquality() {
		// begin-user-code

		// Create DataComponents to test
		DataComponent component = new DataComponent();
		DataComponent equalComponent = new DataComponent();
		DataComponent unEqualComponent = new DataComponent();
		DataComponent transitiveComponent = new DataComponent();

		// Create Entries to add to DataComponents
		ArrayList<Entry> entries = new ArrayList<Entry>();

		// Create list of Entries
		for (int i = 0; i < 10; i++) {
			// Create Entry, add to list, and set data
			entries.add(new Entry());
			(entries.get(i)).setId(i);
			(entries.get(i)).setName("Test Entry " + i);
			(entries.get(i)).setValue("Value" + i);

			// Create 3 equal DataComponents by adding Entries to DC's
			component.addEntry(entries.get(i));
			equalComponent.addEntry(entries.get(i));
			transitiveComponent.addEntry(entries.get(i));
		}

		// Add only half of the Entries to the unequal DataComponent
		for (int i = 0; i < 5; i++) {
			unEqualComponent.addEntry(entries.get(i));
		}

		// Set ICEObject data
		component.setId(1);
		equalComponent.setId(1);
		transitiveComponent.setId(1);
		unEqualComponent.setId(2);

		component.setName("DC Equal");
		equalComponent.setName("DC Equal");
		transitiveComponent.setName("DC Equal");
		unEqualComponent.setName("DC UnEqual");

		// Assert two equal DataComponents return true
		assertTrue(component.equals(equalComponent));

		// Assert two unequal DataComponents return false
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
		assertFalse(component==null);

		// Assert that two equal objects return same hashcode
		assertTrue(component.equals(equalComponent)
				&& component.hashCode() == equalComponent.hashCode());

		// Assert that hashcode is consistent
		assertTrue(component.hashCode() == component.hashCode());

		// Assert that hashcodes from unequal objects are different
		assertTrue(component.hashCode() != unEqualComponent.hashCode());

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation checks the DataComponent to ensure that its copy() and
	 * clone() operations work as specified.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkCopying() {
		// begin-user-code
		/*
		 * The following sets of operations will be used to test the
		 * "clone and copy" portion of DataComponent.
		 */

		// Local declarations
		int id = 20110901;
		String name = "September 1st 2011";
		String description = "The 1st day of the ninth month in the year of "
				+ "our Lord 2011";
		DataComponent cloneData = new DataComponent();
		DataComponent copyData = new DataComponent();
		TestComponentListener listener = new TestComponentListener();

		// Create the DataComponent
		dataComponent = new DataComponent();

		// Set the id, name and description and listener
		dataComponent.setId(id);
		dataComponent.setDescription(description);
		dataComponent.setName(name);
		dataComponent.register(listener);

		// create entries
		Entry entry1 = new Entry();
		Entry entry2 = new Entry();

		// add entries to DataComponent
		dataComponent.addEntry(entry1);
		dataComponent.addEntry(entry2);

		// Test to show valid usage of clone

		// Run clone operation
		cloneData = (DataComponent) dataComponent.clone();

		// check Contents
		assertEquals(dataComponent.getDescription(), cloneData.getDescription());
		assertEquals(dataComponent.getId(), cloneData.getId());
		assertEquals(dataComponent.getName(), cloneData.getName());
		assertTrue(cloneData.contains(entry1.getName()));
		assertTrue(cloneData.contains(entry2.getName()));

		// check listeners
		cloneData.setName("Testing");
		// check the listener
		assertTrue(listener.wasNotified());
		cloneData.setName(dataComponent.getName());
		listener.reset();

		// Test to show valid usage of copy
		// Use dataComponent from above

		// run copy operation
		copyData.copy(dataComponent);

		// check Contents
		assertEquals(dataComponent.getDescription(), copyData.getDescription());
		assertEquals(dataComponent.getId(), copyData.getId());
		assertEquals(dataComponent.getName(), copyData.getName());
		assertTrue(copyData.contains(entry1.getName()));
		assertTrue(copyData.contains(entry2.getName()));

		/*----- Test to show an invalid use of copy - null args -----*/

		// Call copy with null, which should not change anything
		copyData.copy(null);

		// check contents, nothing has changed
		assertEquals(dataComponent.getDescription(), copyData.getDescription());
		assertEquals(dataComponent.getId(), copyData.getId());
		assertEquals(dataComponent.getName(), copyData.getName());
		assertTrue(copyData.contains(entry1.getName()));
		assertTrue(copyData.contains(entry2.getName()));

		return;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation checks the ability of the DataComponent to persist itself
	 * to XML and to load itself from an XML input stream.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkLoadingFromXML() {
		// begin-user-code
		/*
		 * The following sets of operations will be used to test the
		 * "read and write" portion of the DataComponent. It will demonstrate
		 * the behavior of reading and writing from an
		 * "XML (inputStream and outputStream)" file. It will use an annotated
		 * DataComponent to demonstrate basic behavior.
		 */

		// Local declarations
		int id = 20110901;
		String name = "September 1st 2011";
		String description = "The 1st day of the ninth month in the year of "
				+ "our Lord 2011";

		// Create the DataComponent
		dataComponent = new DataComponent();
		DataComponent loadDataComponent = new DataComponent();

		// Set the id, name and description
		dataComponent.setId(id);
		dataComponent.setDescription(description);
		dataComponent.setName(name);

		// create entries
		Entry entry1 = new Entry();
		Entry entry2 = new Entry();

		// add entries to DataComponent
		dataComponent.addEntry(entry1);
		dataComponent.addEntry(entry2);

		// Demonstrate a basic "write" to file. Should not fail

		// persist to an output stream
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		dataComponent.persistToXML(outputStream);

		// Initialize object and pass inputStream to read()
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				outputStream.toByteArray());

		// create a new instance of a different variable to compare
		loadDataComponent = new DataComponent();

		// load into DataComponent();
		loadDataComponent.loadFromXML(inputStream);

		// check contents
		assertTrue(dataComponent.equals(loadDataComponent));

		// The next following tests demonstrate behavior for when you pass null
		// args for read()

		// test for read - null args
		loadDataComponent.loadFromXML(null);

		// check contents - nothing has changed the previously set data
		assertTrue(dataComponent.equals(loadDataComponent));

		// args for write() - null args
		outputStream = null;
		loadDataComponent.persistToXML(outputStream);

		// checkContents - nothing has changed
		assertNull(outputStream);

		// end-user-code
	}
}