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
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.eclipse.january.form.ContinuousEntry;
import org.eclipse.january.form.DataComponent;
import org.eclipse.january.form.DiscreteEntry;
import org.eclipse.january.form.JanuaryJAXBClassProvider;
import org.eclipse.january.form.JanuaryJAXBHandler;
import org.eclipse.january.form.IEntry;
import org.eclipse.january.form.MasterDetailsPair;
import org.eclipse.january.form.StringEntry;
import org.junit.Test;

/**
 * <p>
 * This class is responsible for testing the MasterDetailsPair class.
 * </p>
 * 
 * @author Jay Jay Billings
 */

public class MasterDetailsPairTester {
	/**
	 * <p>
	 * This operation checks the MasterDetailsPair to insure that its equals()
	 * and hashcode() operations work.
	 * </p>
	 * 
	 */
	@Test
	public void checkEquality() {
		// Local Declarations
		DataComponent dComponent = new DataComponent();
		DataComponent dComponent2 = new DataComponent();
		IEntry entry1 = new ContinuousEntry("0", "50");
		IEntry entry2 = new DiscreteEntry("Apple", "Orange");
		entry1.setDefaultValue("25");
		entry2.setDefaultValue("Orange");
		entry1.setValue("25");
		entry2.setValue("Orange");
		
		// Add the entries to seperate DataComponents
		dComponent.addEntry(entry1);
		dComponent2.addEntry(entry2);

		// Create MasterDetailsPair to test
		MasterDetailsPair component = new MasterDetailsPair("Type One",
				dComponent);
		MasterDetailsPair equalComponent = new MasterDetailsPair("Type One",
				dComponent);
		MasterDetailsPair unEqualComponent = new MasterDetailsPair("Type Two",
				dComponent2);
		MasterDetailsPair transitiveComponent = new MasterDetailsPair(
				"Type One", dComponent);

		component.setMasterDetailsPairId(1);
		equalComponent.setMasterDetailsPairId(1);
		transitiveComponent.setMasterDetailsPairId(1);

		// Set JanuaryObject data
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

	}

	/**
	 * <p>
	 * This operation checks the MasterDetailsPair to ensure that its copy() and
	 * clone() operations work as specified.
	 * </p>
	 * 
	 */
	@Test
	public void checkCopying() {
		// Local Declarations
		MasterDetailsPair cloneMaster, copyMaster = null;
		DataComponent dComponent = new DataComponent();
		IEntry entry1 = new ContinuousEntry("0", "50");
		IEntry entry2 = new DiscreteEntry("Apple", "Orange");
		entry1.setDefaultValue("25");
		entry2.setDefaultValue("Orange");
		entry1.setValue("25");
		entry2.setValue("Orange");

		// Add entries to DataComponent (Details)
		dComponent.addEntry(entry1);
		dComponent.addEntry(entry2);

		// Create MasterDetailsPair to test
		MasterDetailsPair component = new MasterDetailsPair("Type One",
				dComponent);
		component.setMasterDetailsPairId(55);

		// Clone contents
		cloneMaster = (MasterDetailsPair) component.clone();

		// Make sure the clone is not null
		assertNotNull(cloneMaster);

		// Check equality of contents
		assertTrue(cloneMaster.equals(component));

		// Copy contents
		copyMaster = new MasterDetailsPair(); // Create a new instance of
												// MasterDetailsPair
		copyMaster.copy(component);

		// Check equality of contents
		assertTrue(copyMaster.equals(component));

		// Pass null into copy contents, show nothing has changed
		copyMaster.copy(null);

		// Check equality of contents
		assertTrue(copyMaster.equals(component));

	}

	/**
	 * <p>
	 * This operation checks the alternative constructor of the
	 * MasterDetailsPair class to make sure that the master and details can be
	 * retrieved after calling it.
	 * </p>
	 * 
	 */
	@Test
	public void checkAlternativeConstructor() {

		// Local Declarations
		MasterDetailsPair mDetailsP;
		DataComponent dComponent;
		String MasterType1 = "TypeOne!";
		// Setup DataComponent
		dComponent = new DataComponent();
		dComponent.setName(MasterType1);
		IEntry entry = new StringEntry();
		// Add entry to dComponent
		dComponent.addEntry(entry);

		// Call Alternative Constructor
		mDetailsP = new MasterDetailsPair(MasterType1, dComponent);

		// Check values. Should be typeone and equal to the declared
		// dataComponent
		assertEquals(MasterType1, mDetailsP.getMaster());
		assertTrue(dComponent.equals(mDetailsP.getDetails()));

		// Try to pass null to the constructor - sets values appropriately
		mDetailsP = new MasterDetailsPair(null, dComponent); // null master
		assertNull(mDetailsP.getMaster());
		assertTrue(dComponent.equals(mDetailsP.getDetails()));

		// DataComponent null
		mDetailsP = new MasterDetailsPair(MasterType1, null);
		assertEquals(MasterType1, mDetailsP.getMaster());
		assertNull(mDetailsP.getDetails());

		// Both null
		mDetailsP = new MasterDetailsPair(null, null);
		assertNull(mDetailsP.getMaster());
		assertNull(mDetailsP.getDetails());

	}

	/**
	 * <p>
	 * This operation checks the MasterDetailsPair by making sure its getters
	 * and setters work.
	 * </p>
	 * 
	 */
	@Test
	public void checkGetsAndSets() {
		// Local Declarations
		MasterDetailsPair mDetailsP;
		DataComponent dComponent;
		String MasterType1 = "TypeOne!";

		// Create a new instance of MasterDetailsPair
		mDetailsP = new MasterDetailsPair();

		// Check that the returned value is null
		assertNull(mDetailsP.getMaster());

		// Try to set the Master String
		mDetailsP.setMaster(MasterType1);

		// Make sure it is the correct type
		assertEquals(MasterType1, mDetailsP.getMaster());

		// Try to set it to null
		mDetailsP.setMaster(null);

		// Show that it can not be set to null
		assertNotNull(mDetailsP.getMaster());

		// check the DataComponent - should be null
		assertNull(mDetailsP.getDetails());

		// Add a DataComponent
		dComponent = new DataComponent();
		dComponent.setName("I am a DataComponent");
		mDetailsP.setDetails(dComponent);

		// Check that it is a DataComponent
		assertTrue(dComponent.equals(mDetailsP.getDetails()));

		// Check you cant set DataComponent to null
		mDetailsP.setDetails(null);

		// Check value
		assertNotNull(mDetailsP.getDetails());

	}

	/**
	 * <p>
	 * This operation checks the ability of the MasterDetails to persist itself
	 * to XML and to load itself from an XML input stream.
	 * </p>
	 * @throws IOException 
	 * @throws JAXBException 
	 * @throws NullPointerException 
	 * 
	 */
	@Test
	public void checkLoadingFromXML() throws NullPointerException, JAXBException, IOException {
		// Local Declarations
		MasterDetailsPair mDetailsP = new MasterDetailsPair();
		MasterDetailsPair loadDetailsP = new MasterDetailsPair();
		DataComponent detailsComp = new DataComponent();
		String MasterType1 = "TypeOne!";
		IEntry entry;
		JanuaryJAXBHandler xmlHandler = new JanuaryJAXBHandler();
		ArrayList<Class> classList = new ArrayList<Class>();
		classList.add(MasterDetailsPair.class);
		classList.addAll(new JanuaryJAXBClassProvider().getClasses());
		
		// Setup DataComponent
		entry = new StringEntry();
		entry.setValue("Values!");
		detailsComp.addEntry(entry);

		// Setup MasterDetailsPair
		mDetailsP.setDescription("I am a master details pair!");
		mDetailsP.setName("Type One Association");
		mDetailsP.setId(3005);
		mDetailsP.setMaster(MasterType1);
		mDetailsP.setDetails(detailsComp);
		mDetailsP.setMasterDetailsPairId(5);

		// Load it into XML
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		xmlHandler.write(mDetailsP, classList, outputStream);

		// convert information inside of outputStream to inputStream
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				outputStream.toByteArray());

		// load contents into xml
		loadDetailsP = (MasterDetailsPair) xmlHandler.read(classList, inputStream);

		// Check contents
		// Check that data is correct
		assertTrue(mDetailsP.equals(loadDetailsP));

	}
}