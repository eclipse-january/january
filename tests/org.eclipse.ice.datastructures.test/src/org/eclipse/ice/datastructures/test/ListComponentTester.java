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
import java.io.IOException;
import java.text.Normalizer.Form;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.eclipse.ice.datastructures.ICEObject.IElementSource;
import org.eclipse.ice.datastructures.ICEObject.ListComponent;
import org.eclipse.ice.datastructures.ICEObject.ICEJAXBHandler;
import org.eclipse.ice.datastructures.ICEObject.ICEObject;
import org.eclipse.ice.datastructures.componentVisitor.SelectiveComponentVisitor;
import org.junit.*;

import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.event.ListEvent;
import ca.odell.glazedlists.event.ListEventListener;
import ca.odell.glazedlists.gui.TableFormat;
import ca.odell.glazedlists.gui.WritableTableFormat;

/**
 * The ListComponentTester is responsible for testing the ListComponent class.
 * It only tests the name, id, and description properties as well as persistence
 * (insofar as it can for the latter). It also checks equality, hashCode
 * computation, copying, and cloning.
 * 
 * Finally, this class tests those operations from Component that are
 * implemented by ListComponentTester.
 * 
 * @author Jay Jay Billings
 */
public class ListComponentTester implements IElementSource<Integer>,
		WritableTableFormat<Integer>, ListEventListener<Integer> {

	/**
	 * A flag to mark whether or not visitation worked.
	 */
	boolean visited = false;

	/**
	 * The ListComponent that will be used for the test. This class is simply a
	 * stub that makes it possible to instantiate the ListComponent so that it
	 * can be tested.
	 */
	private ListComponent component;

	/**
	 * True if the test was notified via the GlazedLists ListEventListener
	 * interface instead of the ICE interface.
	 */
	private volatile boolean notified = false;

	/**
	 * <!-- begin-UML-doc -->
	 * 
	 * This operation checks the ListComponent to insure that the id, name and
	 * description getters and setters function properly.
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

		// Create the ListComponent
		ListComponent component = new ListComponent();

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
	 * This operation checks the ListComponent class to ensure that its copy()
	 * and clone() operations work as specified.
	 * 
	 * <!-- end-UML-doc -->
	 */
	@Test
	public void checkCopying() {
		// begin-user-code

		// Local declarations
		int id = 20110901;
		String name = "September 1st 2011";
		String description = "The 1st day of the ninth month in the year of "
				+ "our Lord 2011";
		component = new ListComponent<Integer>();

		// Set up the id, name and description
		component.setId(id);
		component.setName(name);
		component.setDescription(description);
		// Add some integers to the list
		component.add(5);
		component.add(383400);

		// Create a new instance of ListComponent and copy contents
		ListComponent component2 = new ListComponent();
		component2.copy(component);

		// Check the id, name and description with copy
		assertEquals(component.getId(), component2.getId());
		assertEquals(component.getName(), component2.getName());
		assertEquals(component.getDescription(), component2.getDescription());
		// Make sure it holds the integers
		assertTrue(component2.contains(5));
		assertTrue(component2.contains(383400));

		// Create a clone of the component and check it
		ListComponent<Integer> componentClone = (ListComponent<Integer>) component
				.clone();
		assertEquals(component, componentClone);

		// Test to show an invalid use of copy - null args

		// Local declarations
		id = 20110901;
		name = "September 1st 2011";
		description = "The 1st day of the ninth month in the year of "
				+ "our Lord 2011";
		component = new ListComponent();

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
	 * This operation checks the ability of the ListComponent to persist itself
	 * to XML and to load itself from an XML input stream.
	 * 
	 * @throws IOException
	 * @throws JAXBException
	 * @throws NullPointerException
	 */
	@Test
	public void checkXMLPersistence() throws NullPointerException,
			JAXBException, IOException {
		// begin-user-code

		// Local declarations
		ListComponent<Integer> component2 = null;
		int id = 20110901;
		String name = "September 1st 2011";
		String description = "The 1st day of the ninth month in the year of "
				+ "our Lord 2011";
		ICEJAXBHandler xmlHandler = new ICEJAXBHandler();
		ArrayList<Class> classList = new ArrayList<Class>();
		classList.add(ListComponent.class);
		classList.add(Form.class);
		classList.add(Integer.class);
		classList.add(ICEObject.class);

		// Demonstrate a basic "write" to file. Should not fail
		// Initialize the object and set values.
		component = new ListComponent<Integer>();
		component.setId(id);
		component.setName(name);
		component.setDescription(description);
		// Add some list contents
		component.add(5);
		component.add(1337);

		// Persist the Integer list to an output stream
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		xmlHandler.write(component, classList, outputStream);
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				outputStream.toByteArray());
		// Load it up and check it
		component2 = (ListComponent<Integer>) xmlHandler.read(classList,
				inputStream);
		assertEquals(component.getId(), component2.getId());
		assertEquals(component.getName(), component2.getName());
		assertEquals(component.getDescription(), component2.getDescription());
		assertEquals(component.get(0), component2.get(0));
		assertEquals(component.get(1), component2.get(1));

		// Create a list to hold ICEObjects and put one in it.
		ListComponent<ICEObject> objList = new ListComponent<ICEObject>();
		ICEObject obj = new ICEObject();
		obj.setId(777777);
		objList.add(obj);
		// Write it to the stream
		outputStream = new ByteArrayOutputStream();
		xmlHandler.write(objList, classList, outputStream);
		inputStream = new ByteArrayInputStream(outputStream.toByteArray());
		// Load it back up and check it
		ListComponent<ICEObject> loadedList = (ListComponent<ICEObject>) xmlHandler
				.read(classList, inputStream);
		assertEquals(objList.getId(), loadedList.getId());
		assertEquals(1, objList.size());
		assertEquals(obj, loadedList.get(0));

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * 
	 * This operation checks the ListComponent class to insure that its equals()
	 * operation works.
	 * 
	 * <!-- end-UML-doc -->
	 */
	@Test
	public void checkEquality() {
		// begin-user-code

		// Create an ListComponent
		component = new ListComponent();
		// Create another ListComponent to assert Equality with the last
		ListComponent equalComponent = new ListComponent();
		// Create an ListComponent that is not equal to component
		ListComponent unequalComponent = new ListComponent();
		// Create a third ListComponent to test Transitivity
		ListComponent transitiveComponent = new ListComponent();

		// Set its data
		component.setId(12);
		component.setName("ICE ListComponent");
		component
				.setDescription("This is an ListComponent that will "
						+ "be used for testing equality with other AbstractListComponents.");
		// Add some integers to the list
		component.add(5);
		component.add(383400);

		// Setup the equal component
		equalComponent.setId(12);
		equalComponent.setName("ICE ListComponent");
		equalComponent
				.setDescription("This is an ListComponent that will "
						+ "be used for testing equality with other AbstractListComponents.");
		equalComponent.add(5);
		equalComponent.add(383400);

		// Assert that these two AbstractListComponents are equal
		assertTrue(component.equals(equalComponent));

		// Setup the unequal component
		unequalComponent.setId(52);
		unequalComponent.setName("Bill the ListComponent");
		unequalComponent
				.setDescription("This is an ListComponent to verify that "
						+ "ListComponent.equals() returns false for an object that is not "
						+ "equivalent to component.");

		// Assert that two unequal objects returns false
		assertFalse(component.equals(unequalComponent));

		// Setup the transitive list
		transitiveComponent.setId(12);
		transitiveComponent.setName("ICE ListComponent");
		transitiveComponent
				.setDescription("This is an ListComponent that will "
						+ "be used for testing equality with other AbstractListComponents.");
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
				&& component.hashCode() == equalComponent.hashCode());

		// Assert that hashcode is consistent
		assertTrue(component.hashCode() == component.hashCode());

		// Assert that hashcodes are different for unequal objects
		assertFalse(component.hashCode() == unequalComponent.hashCode());

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * 
	 * This operation tests the ListComponent to insure that it can properly
	 * dispatch notifications when it receives an update that changes its state.
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
		component = new ListComponent<Integer>();

		// Register this test as a ListEventListener
		component.addListEventListener(this);

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

		// Reset the listener
		firstListener.reset();
		// Try adding an element
		component.add(88);
		assertTrue(firstListener.wasNotified());
		assertTrue(notified);

		// Unregister as a ListEventListener.
		component.removeListEventListener(this);
		// Reset the notification flag and then add another element to force an
		// update.
		notified = false;
		component.add(888);
		// Make sure we didn't receive a notification through the
		// ListEventListener interface.
		assertFalse(notified);

		return;
		// end-user-code
	}

	/**
	 * This method checks the visitation routine.
	 */
	@Test
	public void checkVisitation() {

		// Create a new AdaptiveTreeComposite to visit
		ListComponent<Integer> component = new ListComponent<Integer>();

		// Create a visitor, and try to visit the tree
		SelectiveComponentVisitor visitor = new SelectiveComponentVisitor() {
			@Override
			public void visit(ListComponent component) {
				visited = true;
			}
		};
		component.accept(visitor);

		// Check that the component was visited
		assertTrue(visited);

		return;
	}

	/**
	 * This operation checks the IElementSource handle of the ListComponent.
	 */
	@Test
	public void checkElementSource() {

		// Create a new AdaptiveTreeComposite to visit
		component = new ListComponent<Integer>(this);

		// Check that the component received the IElementSource and that it
		// returns the correct one.
		IElementSource<Integer> source = component.getElementSource();
		assertNotNull(source);
		assertTrue(source == this);

		// Try it again using the setter
		component = new ListComponent<Integer>();
		component.setElementSource(this);
		source = null;
		source = component.getElementSource();
		assertNotNull(source);
		assertTrue(source == this);

		return;
	}

	/**
	 * This operation is responsible for making sure that the ListComponent can
	 * properly behave as a WritableTableFormat.
	 */
	@Test
	public void checkTableFormat() {

		// Create the list and set the table format
		// Create a new AdaptiveTreeComposite to visit
		ListComponent<Integer> component = new ListComponent<Integer>();
		component.setTableFormat(this);

		// Check everything
		assertNotNull(component.getTableFormat());
		assertTrue(this == component.getTableFormat());
		assertEquals(getColumnCount(), component.getColumnCount());
		assertEquals(getColumnName(0), component.getColumnName(0));
		assertEquals(getColumnValue(0, 1), component.getColumnValue(0, 1));
		assertEquals(isEditable(0, 1), component.isEditable(0, 1));
		assertEquals(setColumnValue(1, 2, 0), component.setColumnValue(1, 2, 0));

	}

	@Override
	public EventList<Integer> getElements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TableFormat<Integer> getTableFormat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public String getColumnName(int column) {
		return "Six";
	}

	@Override
	public Object getColumnValue(Integer baseObject, int column) {
		return 7;
	}

	@Override
	public boolean isEditable(Integer baseObject, int column) {
		return true;
	}

	@Override
	public Integer setColumnValue(Integer baseObject, Object editedValue,
			int column) {
		return 4;
	}

	@Override
	public void listChanged(ListEvent<Integer> listChanges) {
		System.out.println("ListComponentTester Message: "
				+ "ListEventListener callback executed.");
		notified = true;
	}

}
