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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.*;
import org.eclipse.ice.datastructures.form.Entry;
import org.eclipse.ice.datastructures.form.Form;
import org.eclipse.ice.datastructures.form.ResourceComponent;
import org.eclipse.ice.datastructures.form.ResourceComponent;

import org.eclipse.ice.datastructures.form.DataComponent;
import org.eclipse.ice.datastructures.resource.ICEResource;
import org.eclipse.ice.datastructures.updateableComposite.Component;

/**
 * <!-- begin-UML-doc -->
 * <p>
 * The FormTester is responsible for testing the Form class.
 * </p>
 * <!-- end-UML-doc -->
 * 
 * @author bkj
 */
public class FormTester {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 */
	private Form form;

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 */
	private DataComponent dataComponent;

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The TestComponentListener used to subscribe to and check notifications
	 * from the Form.
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
	 * This operation tests the Form by calling the constructor and checking the
	 * getters and setters for the operations inherited from ICEObject.
	 * </p>
	 * <!-- end-UML-doc -->
	 */
	@Test
	public void checkCreation() {
		// begin-user-code

		form = new Form();

		// Check the form ID
		form.setId(1);
		assertEquals(1, form.getId());
		// Check the form name
		form.setName("Form 1");
		assertEquals("Form 1", form.getName());
		// Check the form description
		form.setDescription("First Form");
		assertEquals("First Form", form.getDescription());

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation tests the Form class by insuring that parent Item IDs can
	 * be set and retrieved without error.
	 * </p>
	 * <!-- end-UML-doc -->
	 */
	@Test
	public void checkItemID() {
		// begin-user-code
		// Create the form
		form = new Form();

		// Set the Parent Item
		form.setItemID(3858);
		// Check that the ID is properly set
		assertEquals(3858, form.getItemID());

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation checks the Form to insure that DataComponents can be
	 * properly manipulated.
	 * </p>
	 * <!-- end-UML-doc -->
	 */
	@Test
	public void checkDataComponents() {
		// begin-user-code

		// Local Declarations
		int i = 0, numComps = 10;
		ArrayList<DataComponent> compList = new ArrayList<DataComponent>();
		ArrayList<Component> retCompList = null;

		// Create the DataComponents
		for (i = 0; i < numComps; i++) {
			compList.add(new DataComponent());
			compList.get(i).setId(i);
		}

		// Add the components
		form = new Form();
		for (i = 0; i < compList.size(); i++) {
			form.addComponent(compList.get(i));
		}

		// Check the number of components
		assertEquals(compList.size(), form.getNumberOfComponents());

		// Check the component IDs
		for (i = 0; i < form.getNumberOfComponents(); i++) {
			assertEquals(i, ((DataComponent) form.getComponent(i)).getId());
		}

		// Check retrieving the whole set of Components
		retCompList = form.getComponents();
		assertNotNull(retCompList);
		assertEquals(retCompList.size(), form.getNumberOfComponents());
		assertEquals(retCompList.size(), compList.size());
		// Make sure it is the same list as what was originally sent
		for (i = 0; i < compList.size(); i++) {
			assertEquals(((DataComponent) retCompList.get(i)).getId(), compList
					.get(i).getId());
		}

		// Check component removal
		form.removeComponent(2);
		assertEquals(compList.size() - 1, form.getNumberOfComponents());

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation tests the Form class by registering a realization of
	 * IComponentListener against it and making sure that it receives status
	 * updates from the Form class.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkNotifications() {
		// begin-user-code

		// Setup the listener
		testComponentListener = new TestComponentListener();

		// Setup the Form
		form = new Form();

		// Setup the DataComponent
		dataComponent = new DataComponent();

		// Register the listener
		form.register(testComponentListener);

		// Create a new Entry in the DataComponent
		form.addComponent(dataComponent);

		// Check the Listener
		assertTrue(testComponentListener.wasNotified());

		return;

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This test insures that the list of Actions give to the Form on creation
	 * is consistent. It also checks that getActionList() returns null for a
	 * Form created with a null value for the list of Actions.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkActionList() {
		// begin-user-code

		// Local declarations
		ArrayList<String> actionList = new ArrayList<String>();

		// Add Strings to ArrayList for testing
		actionList.add("String 1");
		actionList.add("String 2");
		actionList.add("String 3");

		// Create the form
		form = new Form();
		form.setActionList(actionList);

		// Check for a null list
		assertNotNull(form.getActionList());

		// Check the number of strings
		assertEquals(actionList.size(), form.getActionList().size());

		// Make sure it is the same list as what was originally sent
		for (int i = 0; i < actionList.size(); i++) {
			assertEquals(actionList.get(i), form.getActionList().get(i));
		}

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation checks the Form by making sure that it can be marked as
	 * ready or not ready.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkReadiness() {
		// begin-user-code

		// Create the Form
		form = new Form();

		// Make sure the Form is ready by default
		assertTrue(form.isReady());

		// Set the readiness and check it
		form.markReady(true);
		assertTrue(form.isReady());

		// Reset the readiness and check it
		form.markReady(false);
		assertFalse(form.isReady());

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation checks the Form to insure that its equals() operation
	 * works.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkEquality() {
		// begin-user-code

		// Create Forms to check equals()
		Form form = new Form();
		Form equalForm = new Form();
		Form transitiveForm = new Form();
		Form unEqualForm = new Form();

		// Set Form Item IDs
		form.setItemID(1);
		equalForm.setItemID(1);
		transitiveForm.setItemID(1);
		unEqualForm.setItemID(2);

		// Set Form ICEObject IDs
		form.setId(22);
		equalForm.setId(22);
		transitiveForm.setId(22);
		unEqualForm.setId(23);

		// Set Form ICEObject Names
		form.setName("Form for Equals");
		equalForm.setName("Form for Equals");
		transitiveForm.setName("Form for Equals");
		unEqualForm.setName("UnEqual Form");

		// Set Form ICEObject descriptions
		form.setDescription("This is a Form");
		equalForm.setDescription("This is a Form");
		transitiveForm.setDescription("This is a Form");
		unEqualForm
				.setDescription("This is a Form, but it is not equal to the others");

		// Create Data Components to add to the Forms
		DataComponent comp1 = new DataComponent();
		DataComponent comp2 = new DataComponent();
		DataComponent unEqualComponent = new DataComponent();
		ArrayList<Entry> entries = new ArrayList<Entry>();

		// Create list of Entries
		for (int i = 0; i < 10; i++) {
			// Create Entry, add to list, and set data
			entries.add(new Entry());
			(entries.get(i)).setId(i);
			(entries.get(i)).setName("Test Entry " + i);
			(entries.get(i)).setValue("Value" + i);

			// Create 3 equal DataComponents by adding Entries to DC's
			comp1.addEntry(entries.get(i));
			comp2.addEntry(entries.get(i));
		}

		// Add only half of the Entries to the unequal DataComponent
		for (int i = 0; i < 5; i++) {
			unEqualComponent.addEntry(entries.get(i));
		}

		// Add the DataComponents to the Forms
		form.addComponent(comp1);
		form.addComponent(comp2);
		equalForm.addComponent(comp1);
		equalForm.addComponent(comp2);
		transitiveForm.addComponent(comp1);
		transitiveForm.addComponent(comp2);

		// Add Components to the unEqualForm that are not the same
		unEqualForm.addComponent(comp1);
		unEqualForm.addComponent(unEqualComponent);

		// Create Actions for the Forms
		ArrayList<String> actions = new ArrayList<String>();

		for (int i = 0; i < 10; i++) {
			actions.add("Action " + i);
		}
		// Add the actions to the forms
		form.setActionList(actions);
		equalForm.setActionList(actions);
		transitiveForm.setActionList(actions);

		// Remove the first 5 actions
		for (int i = 0; i < 5; i++) {
			actions.remove(i);
		}
		// Add them to the unEqualForm
		unEqualForm.setActionList(actions);

		// Assert two equal Forms return true
		assertTrue(form.equals(equalForm));

		// Assert two unequal forms return false
		assertFalse(form.equals(unEqualForm));

		// Assert equals() is reflexive
		assertTrue(form.equals(form));

		// Assert equals is Symmetric
		assertTrue(form.equals(equalForm) && equalForm.equals(form));

		// Assert equals is Transitive
		if (form.equals(equalForm) && equalForm.equals(transitiveForm)) {
			assertTrue(form.equals(transitiveForm));
		} else {
			fail();
		}

		// Assert equals is consistent
		assertTrue(form.equals(equalForm) && form.equals(equalForm)
				&& form.equals(equalForm));
		assertTrue(!form.equals(unEqualForm) && !form.equals(unEqualForm)
				&& !form.equals(unEqualForm));

		// Assert checking equality with null is false
		assertFalse(form==null);

		// Assert that two equal forms return same hashcode
		assertTrue(form.equals(equalForm)
				&& form.hashCode() == equalForm.hashCode());

		// Assert that hashcode is consistent
		assertTrue(form.hashCode() == form.hashCode());

		// Assert that hashcodes are different for unequal Forms
		assertTrue(form.hashCode() != unEqualForm.hashCode());

		// Additional tests for equality - actionlist is null
		form.setActionList(null);
		assertFalse(form.equals(equalForm));

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation checks the Form to ensure that its copy() and clone()
	 * operations work as specified.
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
		 * "clone and copy" portion of Form.
		 */
		// Local declarations
		Form form, copyForm, cloneForm = null;
		ArrayList<String> actionList = new ArrayList<String>();

		DataComponent dataComponent = new DataComponent();
		DataComponent dataComponent2 = new DataComponent();
		Entry entry1 = new Entry();
		Entry entry2 = new Entry();
		Entry entry3 = new Entry();
		Entry entry4 = new Entry();

		// Listener
		TestComponentListener listener = new TestComponentListener();

		// Fill up actionList
		actionList.add("Robots in Disguise");
		actionList.add("Autobots Rollout!");
		actionList.add("Transformers");

		// Set up entries
		entry1.setId(1);
		entry1.setName("Entry 1");
		entry1.setDescription("I am Entry1");
		entry1.setValue("one");

		entry2.setId(2);
		entry2.setName("Entry 2");
		entry2.setDescription("I am Entry2");
		entry2.setValue("two");

		entry3.setId(3);
		entry3.setName("Entry 3");
		entry3.setDescription("I am Entry3");
		entry3.setValue("three");

		entry4.setId(4);
		entry4.setName("Entry 4");
		entry4.setDescription("I am Entry4");
		entry4.setValue("four");

		// Set up components
		dataComponent.setId(1);
		dataComponent.setName("DataComponent 1");
		dataComponent.setDescription("I am DataComponent1");
		dataComponent.addEntry(entry1);
		dataComponent.addEntry(entry2);

		dataComponent2.setId(2);
		dataComponent2.setName("DataComponent 2");
		dataComponent2.setDescription("I am DataComponent2");
		dataComponent2.addEntry(entry3);
		dataComponent2.addEntry(entry4);

		// Allocate form
		form = new Form();
		form.setId(1);
		form.setDescription("This is a description of a form");
		form.setName("TestFormA");
		form.setItemID(2);
		form.setActionList(actionList);
		form.addComponent(dataComponent);
		form.addComponent(dataComponent2);
		// register listener
		form.register(listener);

		// Test to show valid usage of clone

		// Run clone operation
		cloneForm = (Form) form.clone();

		/* check Contents */
		assertTrue(form.equals(cloneForm));

		// Test to show valid usage of copy
		// Use form from above

		// run copy operation
		copyForm = new Form();
		copyForm.copy(form);

		/* check Contents */
		assertTrue(form.equals(copyForm));

		// Test to show an invalid use of copy - null args

		// Call copy with null, which should not change anything

		copyForm.copy(null);

		/* check contents, nothing has changed */
		assertTrue(form.equals(copyForm));

		return;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation checks the ability of the Form to persist itself to XML
	 * and to load itself from an XML input stream.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkXMLPersistence() {
		// begin-user-code

		/*
		 * The following sets of operations will be used to test the
		 * "read and write" portion of the Form. It will demonstrate the
		 * behavior of reading and writing from an
		 * "XML (inputStream and outputStream)" file. It will use an annotated
		 * Form to demonstrate basic behavior.
		 */

		// Local declarations
		Form form, loadedForm = null;
		ArrayList<String> actionList = new ArrayList<String>();

		DataComponent dataComponent = new DataComponent();
		DataComponent dataComponent2 = new DataComponent();
		Entry entry1 = new Entry();
		Entry entry2 = new Entry();
		Entry entry3 = new Entry();
		Entry entry4 = new Entry();

		ArrayList<ICEResource> resources = new ArrayList<ICEResource>();

		// Fill up actionList
		actionList.add("Robots in Disguise");
		actionList.add("Autobots Rollout!");
		actionList.add("Transformers");

		// Set up entries
		entry1.setId(1);
		entry1.setName("Entry 1");
		entry1.setDescription("I am Entry1");
		entry1.setValue("one");

		entry2.setId(2);
		entry2.setName("Entry 2");
		entry2.setDescription("I am Entry2");
		entry2.setValue("two");

		entry3.setId(3);
		entry3.setName("Entry 3");
		entry3.setDescription("I am Entry3");
		entry3.setValue("three");

		entry4.setId(4);
		entry4.setName("Entry 4");
		entry4.setDescription("I am Entry4");
		entry4.setValue("four");

		// Set up components
		dataComponent.setId(1);
		dataComponent.setName("DataComponent 1");
		dataComponent.setDescription("I am DataComponent1");
		dataComponent.addEntry(entry1);
		dataComponent.addEntry(entry2);

		dataComponent2.setId(2);
		dataComponent2.setName("DataComponent 2");
		dataComponent2.setDescription("I am DataComponent2");
		dataComponent2.addEntry(entry3);
		dataComponent2.addEntry(entry4);

		// Allocate form
		form = new Form();
		form.setId(1);
		form.setDescription("This is a description of a form");
		form.setName("TestFormA");
		form.setItemID(2);
		form.setActionList(actionList);
		form.addComponent(dataComponent);
		form.addComponent(dataComponent2);

		// Added ResourceComponent to test it with DataComponent and make
		// distinction in JAXB.
		ResourceComponent outputComp = new ResourceComponent();

		// Set up file path - for resources
		File file = new File("Mississippi.testFile");
		File file2 = new File("Enterprise.testFile");
		File file3 = new File("EnterpriseA.testFile");

		// Create five test resources - this one themed after places where Bones
		// lived
		try {
			resources.add(new ICEResource(file));
			resources.add(new ICEResource(file2));
			resources.add(new ICEResource(file3));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// Add the Resources to the ResourceComponent
		for (ICEResource i : resources) {
			outputComp.addResource(i);
		}

		// add to form
		form.addComponent(outputComp);

		// Demonstrate a basic "write" to file. Should not fail

		// persist to an output stream
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		form.persistToXML(outputStream);

		// Initialize object and pass inputStream to read()
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				outputStream.toByteArray());

		// create a new instance of a different variable to compare
		loadedForm = new Form();

		// load into Form();
		loadedForm.loadFromXML(inputStream);

		/* check contents */
		assertTrue(form.equals(loadedForm));

		// The next following tests demonstrate behavior for when you pass null
		// args for read()

		// test for read - null args
		loadedForm.loadFromXML(null);

		/* check contents - nothing has changed */
		assertTrue(form.equals(loadedForm));

		// args for write() - null args
		outputStream = null;
		loadedForm.persistToXML(outputStream);

		assertNull(outputStream);
		// end-user-code
	}
}