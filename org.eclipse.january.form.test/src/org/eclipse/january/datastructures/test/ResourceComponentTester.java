/*******************************************************************************
 * Copyright (c) 2014, 2016 UT-Battelle, LLC.
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
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.eclipse.january.form.JanuaryJAXBHandler;
import org.eclipse.january.form.JanuaryResource;
import org.eclipse.january.form.ResourceComponent;
import org.junit.Test;

/**
 * The ResourceComponentTester class is responsible for testing the
 * functionality of the ResourceComponent class.
 * 
 * @author Jay Jay Billings, Anna Wojtowicz
 */
public class ResourceComponentTester {
	
	/**
	 * A ResourceComponent used for testing.
	 */
	private ResourceComponent resourceComponent;
	
	/**
	 * A fake listener to listen to changes to the ResourceComponent.
	 */
	private TestComponentListener testComponentListener;
	
	/**
	 * A fake visitor to visit the ResourceComponent.
	 */
	private TestVisitor testVisitor;

	/**
	 * This operation checks the construction of ResourceComponents.
	 */
	@Test
	public void checkCreation() {

		// Local declarations
		int id = 2266;
		String name = "3F 127 on Deck 9, section 2";
		String description = "Bones' Quarters";

		// Create the ResourceComponent
		resourceComponent = new ResourceComponent();

		// Set the id, name and description
		resourceComponent.setId(id);
		resourceComponent.setDescription(description);
		resourceComponent.setName(name);

		// Check the id, name and description
		assertEquals(resourceComponent.getDescription(), description);
		assertEquals(resourceComponent.getId(), id);
		assertEquals(resourceComponent.getName(), name);
		
		return;
	}

	/**

	 * This operation checks the ResourceComponent's ability to add Resources to
	 * itself.
	 */
	@Test
	public void checkResources() {

		// Local Declarations
		ArrayList<JanuaryResource> resources = new ArrayList<JanuaryResource>();
		ArrayList<JanuaryResource> retResources = null;

		// Create the ResourceComponent
		resourceComponent = new ResourceComponent();

		// Create five test resources - this one themed after places where Bones
		// lived
		try {
			resources.add(new JanuaryResource(new File("Mississippi.testFile")));
			resources.add(new JanuaryResource(new File("Enterprise.testFile")));
			resources.add(new JanuaryResource(new File("EnterpriseA.testFile")));
			resources.add(new JanuaryResource(new File("DramiaII.testFile")));
			resources.add(new JanuaryResource(new File("CapellaIV.testFile")));
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}

		// Add the Resources to the ResourceComponent
		for (JanuaryResource i : resources) {
			resourceComponent.addResource(i);
		}

		// Get the list of Resources and check it
		retResources = resourceComponent.getResources();
		assertNotNull(retResources);
		assertEquals(resources, retResources);

		return;
	}

	/**
	 * This operation checks the visitation capabilities of the
	 * ResourceComponent.
	 */
	@Test
	public void checkVisitation() {

		// Setup the visitor
		testVisitor = new TestVisitor();

		// Setup the ResourceComponent
		resourceComponent = new ResourceComponent();

		// Send the visitor
		resourceComponent.accept(testVisitor);

		// Check the visitor
		assertTrue(testVisitor.wasVisited());

		return;
	}

	/**
	 * This operation checks the ability of the ResourceComponent to notify
	 * listeners when it has been updated. That is, when the list of Resources
	 * has changed in some way or the identifying information of the component
	 * has changed.
	 */
	@Test
	public void checkNotifications() {

		// Setup the listener
		testComponentListener = new TestComponentListener();

		// Setup the ResourceComponent
		resourceComponent = new ResourceComponent();

		// Register the listener
		resourceComponent.register(testComponentListener);

		// Create a new Resource in the ResourceComponent
		try {
			resourceComponent.addResource(new JanuaryResource(new File(
					"SickBay.testFile")));
		} catch (IOException e1) {
			e1.printStackTrace();
			fail();
		}

		// Check the Listener
		assertTrue(testComponentListener.wasNotified());

		// Reset the listener
		testComponentListener.reset();

		// Add a second Resource, just to make sure.
		try {
			resourceComponent.addResource(new JanuaryResource(new File(
					"ShoreLeavePlanet.testFile")));
		} catch (IOException e1) {
			e1.printStackTrace();
			fail();
		}

		// Check the listener to make sure it was updated
		assertTrue(testComponentListener.wasNotified());

		return;
	}

	/**
	 * This operation checks the ResourceComponent to ensure that its equals()
	 * operation works.
	 */
	@Test
	public void checkEquality() {

		// Create ResourceComponents to test
		ResourceComponent outComp1 = new ResourceComponent();
		ResourceComponent equalComp = new ResourceComponent();
		ResourceComponent unEqual = new ResourceComponent();
		ResourceComponent transitiveComp = new ResourceComponent();
		try {
			outComp1.addResource(new JanuaryResource(new File("TestFile.test")));
			outComp1.addResource(new JanuaryResource(
					new File("SecondTestFile.test")));

			// Add equal files to equalComp
			equalComp.addResource(new JanuaryResource(new File("TestFile.test")));
			equalComp.addResource(new JanuaryResource(new File(
					"SecondTestFile.test")));

			// Create unequal ResourceComponent
			unEqual.addResource(new JanuaryResource(new File("OtherFile.test")));
			unEqual.addResource(new JanuaryResource(new File("HelloFile.file")));

			// Create equal File for transitive test
			transitiveComp.addResource(new JanuaryResource(
					new File("TestFile.test")));
			transitiveComp.addResource(new JanuaryResource(new File(
					"SecondTestFile.test")));

		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}

		// Assert two equal ResourceComponents return true
		assertTrue(outComp1.equals(equalComp));

		// Assert two unequal ResourceComponents return false
		assertFalse(outComp1.equals(unEqual));

		// Assert equals() is reflexive
		assertTrue(outComp1.equals(outComp1));

		// Check that equals() is Symmetric
		assertTrue(outComp1.equals(equalComp) && equalComp.equals(outComp1));

		// Check equals() is transitive
		if (outComp1.equals(equalComp) && equalComp.equals(transitiveComp)) {
			assertTrue(outComp1.equals(transitiveComp));
		} else {
			fail();
		}

		// Check consistent nature of equals()
		assertTrue(outComp1.equals(equalComp) && outComp1.equals(equalComp)
				&& outComp1.equals(equalComp));
		assertTrue(!outComp1.equals(unEqual) && !outComp1.equals(unEqual)
				&& !outComp1.equals(unEqual));

		// Assert checking equality with null value is false
		assertFalse(outComp1==null);

		// Assert that two equal objects return the same hashcode
		assertTrue(outComp1.equals(equalComp)
				&& (outComp1.hashCode() == equalComp.hashCode()));

		// Assert that hashcode is consistent
		assertTrue(outComp1.hashCode() == outComp1.hashCode());

		// Assert hashcodes for unequal objects are different
		assertFalse(outComp1.hashCode() == unEqual.hashCode());

		return;
	}

	/**
	 * This operation checks the ResourceComponent to ensure that its clone()
	 * works as expected.
	 */
	@Test
	public void checkCloning() {

		// Local Declarations
		ArrayList<JanuaryResource> resources = new ArrayList<JanuaryResource>();
		TestComponentListener listener = new TestComponentListener();

		// Local declarations
		int id = 2266;
		String name = "3F 127 on Deck 9, section 2";
		String description = "Bones' Quarters";

		// Create the ResourceComponent
		resourceComponent = new ResourceComponent();

		// Create five test resources - this one themed after places where Bones
		// lived
		try {
			resources.add(new JanuaryResource(new File("Mississippi.testFile")));
			resources.add(new JanuaryResource(new File("Enterprise.testFile")));
			resources.add(new JanuaryResource(new File("EnterpriseA.testFile")));
			resources.add(new JanuaryResource(new File("DramiaII.testFile")));
			resources.add(new JanuaryResource(new File("CapellaIV.testFile")));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// Add the Resources to the ResourceComponent
		for (JanuaryResource i : resources) {
			resourceComponent.addResource(i);
		}

		// Set the id, name and description
		resourceComponent.setId(id);
		resourceComponent.setDescription(description);
		resourceComponent.setName(name);

		// add listener
		resourceComponent.register(listener);

		// Run clone operation
		ResourceComponent cloneOutput = 
				(ResourceComponent) resourceComponent.clone();

		// Check contents
		assertEquals(resourceComponent.getDescription(),
				cloneOutput.getDescription());
		assertEquals(resourceComponent.getId(), cloneOutput.getId());
		assertEquals(resourceComponent.getName(), cloneOutput.getName());
		assertEquals(resourceComponent.getResources(),
				cloneOutput.getResources());

		return;
	}

	/**
	 * This operation checks the ability of the ResourceComponent class to
	 * persist itself to XML and to load itself from an XML input stream.
	 * 
	 * @throws IOException 
	 * @throws JAXBException 
	 * @throws NullPointerException 
	 */
	@Test
	public void checkXMLPersistence() throws NullPointerException, JAXBException, IOException {

		// Local declarations
		ResourceComponent testRC = null, testRC2 = null;
		ArrayList<JanuaryResource> resources = new ArrayList<JanuaryResource>();
		int id = 2266;
		String name = "3F 127 on Deck 9, section 2";
		String description = "Bones' Quarters";
		JanuaryJAXBHandler xmlHandler = new JanuaryJAXBHandler();
		ArrayList<Class> classList = new ArrayList<Class>();
		classList.add(ResourceComponent.class);

		// Set up file path - for resources
		File file = new File("Mississippi.testFile");
		File file2 = new File("Enterprise.testFile");
		file.toURI().toASCIIString();
		file2.toURI().toASCIIString();

		// Create the ResourceComponent
		testRC = new ResourceComponent();

		// Create two test resources - this one themed after places where Bones
		// lived
		try {
			resources.add(new JanuaryResource(file));
			resources.add(new JanuaryResource(file2));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// Add the Resources to the ResourceComponent
		for (JanuaryResource i : resources) {
			testRC.addResource(i);
		}

		// Set the id, name and description
		testRC.setId(id);
		testRC.setDescription(description);
		testRC.setName(name);

		// Demonstrate a basic "write" to file. Should not fail

		// persist to an output stream
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		xmlHandler.write(testRC, classList, outputStream);

		// Load back in

		// Initialize object and pass inputStream to read()
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				outputStream.toByteArray());

		// create a new instance of a different variable to compare
		testRC2 = new ResourceComponent();

		// load into ResourceComponent();
		testRC2 = (ResourceComponent) 
				xmlHandler.read(classList, inputStream);

		// check contents
		assertTrue(testRC.equals(testRC2));

		return;
	}

	/**
	 * An operation that checks the clear operation on ResourceComponent.
	 */
	@Test
	public void checkClear() {
		
		// Local declarations
		ArrayList<JanuaryResource> resources = new ArrayList<JanuaryResource>();
		ResourceComponent resComponent = null;

		// Set up file path - for resources
		File file = new File("Mississippi.testFile");
		File file2 = new File("Enterprise.testFile");

		// Create the ResourceComponent
		resComponent = new ResourceComponent();

		// Create two test resources -
		try {
			resources.add(new JanuaryResource(file));
			resources.add(new JanuaryResource(file2));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// Add the Resources to the ResourceComponent
		for (JanuaryResource i : resources) {
			resComponent.addResource(i);
		}

		// check that ResourceComponent has resources
		assertNotNull(resComponent.getResources());
		assertEquals(2, resComponent.getResources().size());

		// clear the resources
		resComponent.clearResources();

		// check that ResourceComponent has no resources
		assertNotNull(resComponent.getResources());
		assertEquals(0, resComponent.getResources().size());

		// Try to clear a ResourceComponent with no Resources
		// Should still work functionally

		// clear the resources
		resComponent.clearResources();

		// check that ResourceComponent has no resources
		assertNotNull(resComponent.getResources());
		assertEquals(0, resComponent.getResources().size());

		return;
	}
}