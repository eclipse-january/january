/*******************************************************************************
 * Copyright (c) 2011, 2014 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - Jay Jay 
 *   Billings
 *******************************************************************************/
package org.eclipse.ice.datastructures.test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import org.junit.*;

/**
 * The AbstractListComponentTester is responsible for testing the
 * AbstractListComponent class. It only tests the name, id, and description
 * properties as well as persistence (insofar as it can for the latter). It also
 * checks equality, hashCode computation, copying, and cloning.
 * 
 * Finally, this class tests those operations from Component that are
 * implemented by AbstractListComponentTester.
 *
 * @author Jay Jay Billings
 */
public class AbstractListComponentTester {

	/**
	 * The IntegerListComponent that will be used for the test. This class is
	 * simply a stub that makes it possible to instantiate the
	 * AbstractListComponent so that it can be tested.
	 */
	private IntegerListComponent component;

	/**
	 * <!-- begin-UML-doc -->
	 *
	 * This operation checks the IntegerListComponent to insure that the id,
	 * name and description getters and setters function properly.
	 *
	 * <!-- end-UML-doc -->
	 */
	@Test
	public void checkProperties() {
		// begin-user-code

		// Local declarations
		int id = 20110901;
		String name = "September 1st 2011";
		String description = "The 1st day of the ninth month in the year of "
				+ "our Lord 2011";

		// Create the IntegerListComponent
		IntegerListComponent component = new IntegerListComponent();

		// Set up the id, name and description
		component.setId(id);
		component.setName(name);
		component.setDescription(description);

		// Check the id, name and description
		assertEquals(component.getId(), id);
		assertEquals(component.getName(), name);
		assertEquals(component.getDescription(), description);

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 *
	 * This operation checks the IntegerListComponent class to ensure that its
	 * copy() and clone() operations work as specified.
	 *
	 * <!-- end-UML-doc -->
	 */
	@Test
	public void checkCopying() {
		// begin-user-code

		// Test to show valid usage of copy

		// Local declarations
		int id = 20110901;
		String name = "September 1st 2011";
		String description = "The 1st day of the ninth month in the year of "
				+ "our Lord 2011";
		component = new IntegerListComponent();

		// Set up the id, name and description
		component.setId(id);
		component.setName(name);
		component.setDescription(description);
		// Add some integers to the list
		component.add(5);
		component.add(383400);

		// Create a new instance of IntegerListComponent and copy contents
		IntegerListComponent component2 = new IntegerListComponent();
		component2.copy(component);

		// Check the id, name and description with copy
		assertEquals(component.getId(), component2.getId());
		assertEquals(component.getName(), component2.getName());
		assertEquals(component.getDescription(), component2.getDescription());
		// Make sure it holds the integers
		assertTrue(component2.contains(5));
		assertTrue(component2.contains(383400));

		// Test to show an invalid use of copy - null args

		// Local declarations
		id = 20110901;
		name = "September 1st 2011";
		description = "The 1st day of the ninth month in the year of "
				+ "our Lord 2011";
		component = new IntegerListComponent();

		// Set up the id, name and description
		component.setId(id);
		component.setName(name);
		component.setDescription(description);

		// Attempt the null copy
		component.copy(null);

		// Check the id, name and description - nothing has changed
		assertEquals(component.getId(), id);
		assertEquals(component.getName(), name);
		assertEquals(component.getDescription(), description);

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 *
	 * This operation checks the ability of the IntegerListComponent to persist
	 * itself to XML and to load itself from an XML input stream.
	 *
	 * <!-- end-UML-doc -->
	 */
	@Test
	public void checkXMLPersistence() {
		// begin-user-code

		// Local declarations
		IntegerListComponent component = null, component2 = null;
		int id = 20110901;
		String name = "September 1st 2011";
		String description = "The 1st day of the ninth month in the year of "
				+ "our Lord 2011";

		// Demonstrate a basic "write" to file. Should not fail
		// Initialize the object and set values.
		component = new IntegerListComponent();
		component.setId(id);
		component.setName(name);
		component.setDescription(description);

		// persist to an output stream
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		component.persistToXML(outputStream);
		component.persistToXML(System.out);
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				outputStream.toByteArray());

	
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 *
	 * This operation checks the IntegerListComponent class to insure that its
	 * equals() operation works.
	 *
	 * <!-- end-UML-doc -->
	 */
	@Test
	public void checkEquality() {
		// begin-user-code

		// Create an IntegerListComponent
		component = new IntegerListComponent();
		// Create another IntegerListComponent to assert Equality with the last
		IntegerListComponent equalComponent = new IntegerListComponent();
		// Create an IntegerListComponent that is not equal to component
		IntegerListComponent unequalComponent = new IntegerListComponent();
		// Create a third IntegerListComponent to test Transitivity
		IntegerListComponent transitiveComponent = new IntegerListComponent();

		// Set its data
		component.setId(12);
		component.setName("ICE IntegerListComponent");
		component
				.setDescription("This is an IntegerListComponent that will "
						+ "be used for testing equality with other IntegerListComponents.");
		// Add some integers to the list
		component.add(5);
		component.add(383400);

		// Setup the equal component
		equalComponent.setId(12);
		equalComponent.setName("ICE IntegerListComponent");
		equalComponent
				.setDescription("This is an IntegerListComponent that will "
						+ "be used for testing equality with other IntegerListComponents.");
		equalComponent.add(5);
		equalComponent.add(383400);

		// Assert that these two IntegerListComponents are equal
		assertTrue(component.equals(equalComponent));
		
		// Setup the unequal component
		unequalComponent.setId(52);
		unequalComponent.setName("Bill the IntegerListComponent");
		unequalComponent
				.setDescription("This is an IntegerListComponent to verify that "
						+ "IntegerListComponent.equals() returns false for an object that is not "
						+ "equivalent to component.");

		// Assert that two unequal objects returns false
		assertFalse(component.equals(unequalComponent));

		// Setup the transitive list
		transitiveComponent.setId(12);
		transitiveComponent.setName("ICE IntegerListComponent");
		transitiveComponent
				.setDescription("This is an IntegerListComponent that will "
						+ "be used for testing equality with other IntegerListComponents.");
		transitiveComponent.add(5);
		transitiveComponent.add(383400);

		// Check that equals() is Reflexive
		// x.equals(x) = true
		assertTrue(component.equals(component));

		// Check that equals() is Symmetric
		// x.equals(y) = true iff y.equals(x) = true
		assertTrue(component.equals(equalComponent)
				&& equalComponent.equals(component));

		// Check that equals() is Transitive
		// x.equals(y) = true, y.equals(z) = true => x.equals(z) = true
		if (component.equals(equalComponent)
				&& equalComponent.equals(transitiveComponent)) {
			assertTrue(component.equals(transitiveComponent));
		} else {
			fail();
		}

		// Check the Consistent nature of equals()
		assertTrue(component.equals(equalComponent)
				&& component.equals(equalComponent)
				&& component.equals(equalComponent));
		assertTrue(!component.equals(unequalComponent)
				&& !component.equals(unequalComponent)
				&& !component.equals(unequalComponent));

		// Assert checking equality with null value returns false
		assertFalse(component == null);

		// Assert that two equal objects have the same hashcode
		assertTrue(component.equals(equalComponent)
				&& component.hashCode() == equalComponent
						.hashCode());

		// Assert that hashcode is consistent
		assertTrue(component.hashCode() == component
				.hashCode());

		// Assert that hashcodes are different for unequal objects
		assertFalse(component.hashCode() == unequalComponent
				.hashCode());

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 *
	 * This operation tests the IntegerListComponent to insure that it can
	 * properly dispatch notifications when it receives an update that changes
	 * its state.
	 *
	 * <!-- end-UML-doc -->
	 */
	@Test
	public void checkNotifications() {
		// begin-user-code

		// Setup the listeners
		TestComponentListener firstListener = new TestComponentListener();
		TestComponentListener secondListener = new TestComponentListener();

		// Setup the component
		component = new IntegerListComponent();

		// Register the listener
		component.register(firstListener);

		// Add the second listener
		component.register(secondListener);
		
		// Change the name of the object
		component.setName("Warren Buffett");
		
		// Check the listeners to make sure they updated
		assertTrue(firstListener.wasNotified());
		assertTrue(secondListener.wasNotified());
		// Reset the listeners
		firstListener.reset();
		secondListener.reset();

		// Unregister the second listener so that it no longer receives updates
		component.unregister(secondListener);

		// Change the id of the object
		component.setId(899);
		assertTrue(firstListener.wasNotified());
		// Make sure the second listener was not updated
		assertFalse(secondListener.wasNotified());

		// Reset the listener
		firstListener.reset();
		// Change the description of the object
		component.setDescription("New description");
		// Make sure the listener was notified
		assertTrue(firstListener.wasNotified());

		return;
		// end-user-code
	}
}