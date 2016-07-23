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
import org.eclipse.january.form.ICEJAXBClassProvider;
import org.eclipse.january.form.ICEJAXBHandler;
import org.eclipse.january.form.IEntry;
import org.eclipse.january.form.MasterDetailsComponent;
import org.eclipse.january.form.MasterDetailsPair;
import org.eclipse.january.form.StringEntry;
import org.junit.Test;

/**
 * This class is responsible for testing the MasterDetailsComponent.
 * 
 * @author Jay Jay Billings
 */

public class MasterDetailsTester {
	/**
	 * <p>
	 * The TestComponentListener used to subscribe to and check notifications
	 * from the DataComponent.
	 * </p>
	 * 
	 */
	private TestComponentListener testComponentListener;
	/**
	 * <p>
	 * A TestVisitor that is used to test the visitation scheme.
	 * </p>
	 * 
	 */
	private TestVisitor testVisitor;

	/**
	 * <p>
	 * This operation checks the construction process of the
	 * MasterDetailsComponent by ensuring that the template can be set and that
	 * it can only be set once. It checks that the template was properly
	 * configured by adding a master and retrieving its details.
	 * </p>
	 * 
	 */
	@Test
	public void checkConstruction() {
		// Local Declarations
		MasterDetailsComponent mDetailsComp = new MasterDetailsComponent();
		DataComponent detailsComp1, detailsComp2, detailsComp3;
		MasterDetailsPair mdpair1, mdpair2, mdpair3;
		ArrayList<MasterDetailsPair> template;
		ArrayList<DataComponent> dataCompTemplate;
		ArrayList<String> masterTypeTemplate;
		IEntry entry1, entry2, entry3, entry4;
		boolean toggle = true;

		// create a new instance of MasterDetailsComponent
		mDetailsComp = new MasterDetailsComponent();

		// Setup list for templates
		// Create Entries

		entry1 = new ContinuousEntry("0","50");
		entry1.setDefaultValue("25");
		entry1.setValue("0");
		
		entry2 = new DiscreteEntry("Apple", "Orange");
		entry2.setDefaultValue("Orange");
		entry2.setValue("Orange");
				
		entry3 = new StringEntry();
		entry3.setDefaultValue("Gabriel");
		entry3.setValue("Gabriel");

		entry4 = new ContinuousEntry("0", "10000");
		entry4.setDefaultValue("9001");
		entry4.setValue("9001");

		// Create DataComponents
		detailsComp1 = new DataComponent();
		detailsComp2 = new DataComponent();
		detailsComp3 = new DataComponent();

		// Add entries
		detailsComp1.addEntry(entry1);
		detailsComp2.addEntry(entry2);
		detailsComp3.addEntry(entry3);
		detailsComp3.addEntry(entry4);

		// Set names
		detailsComp1.setName("DataComponent1");
		detailsComp2.setName("DataComponent2");
		detailsComp3.setName("DataComponent3");

		// Create pairs
		mdpair1 = new MasterDetailsPair("Type One", detailsComp1);
		mdpair2 = new MasterDetailsPair("Type Two", detailsComp2);
		mdpair3 = new MasterDetailsPair("Type Three", detailsComp3);
		mdpair1.setMasterDetailsPairId(1);
		mdpair2.setMasterDetailsPairId(2);
		mdpair3.setMasterDetailsPairId(3);

		// Add pairs to template
		template = new ArrayList<MasterDetailsPair>();
		template.add(mdpair1);
		template.add(mdpair2);
		template.add(mdpair3);

		// Add to dataComponent's template
		dataCompTemplate = new ArrayList<DataComponent>();
		dataCompTemplate.add(detailsComp1);
		dataCompTemplate.add(detailsComp1);
		dataCompTemplate.add(detailsComp1);

		// Add types to masterType template
		masterTypeTemplate = new ArrayList<String>();
		masterTypeTemplate.add("Type One");
		masterTypeTemplate.add("Type Two");
		masterTypeTemplate.add("Type Three");

		// create a page, set template
		mDetailsComp = new MasterDetailsComponent();

		mDetailsComp.setTemplates(template);

		// Add a Master
		mDetailsComp.addMaster();

		// Get the master, check that is equal to the first component
		assertTrue(mdpair1.getDetails().equals(mDetailsComp.getDetails(1)));

		// Delete it
		mDetailsComp.deleteMaster(0);

		// check that the template can only be set once
		mDetailsComp.setTemplates(new ArrayList<MasterDetailsPair>());

		// Check values - add another pair
		mDetailsComp.addMaster();
		// Get the master, check that is equal to the first component
		assertTrue(mdpair1.getDetails().equals(mDetailsComp.getDetails(1)));
		// Delete it
		mDetailsComp.deleteMaster(1); // Increments based on counter

		// check that you can not set the template to null
		mDetailsComp.setTemplates(null);
		// Check values - add another pair
		mDetailsComp.addMaster();
		// Get the master, check that is equal to the first component
		assertTrue(mdpair1.getDetails().equals(mDetailsComp.getDetails(2)));

		// Check for pairs
		mDetailsComp = new MasterDetailsComponent();

		// check that the template needs to have contents
		mDetailsComp.setTemplates(new ArrayList<String>(),
				new ArrayList<DataComponent>());

		// Null checks
		mDetailsComp.setTemplates(null, null);
		mDetailsComp.setTemplates(null, dataCompTemplate);
		mDetailsComp.setTemplates(masterTypeTemplate, null);

		// You can still set the template - nothing passed previously was valid
		mDetailsComp.setTemplates(masterTypeTemplate, dataCompTemplate);

		// Add a Master
		assertEquals(1, mDetailsComp.addMaster());

		// Get the master, check that is equal to the first component
		assertTrue(mdpair1.getDetails().equals(mDetailsComp.getDetails(1)));
		// Delete it
		assertTrue(mDetailsComp.deleteMaster(1));

		// check that the template can only be set once
		mDetailsComp.setTemplates(new ArrayList<String>(),
				new ArrayList<DataComponent>());

		// Check values - add another pair
		assertEquals(2, mDetailsComp.addMaster());
		// Get the master, check that is equal to the first component
		assertTrue(mdpair1.getDetails().equals(mDetailsComp.getDetails(2)));
		// Delete it
		assertTrue(mDetailsComp.deleteMaster(2)); // Increments based on counter

		// check that the toggle defaults to true
		assertEquals(toggle, mDetailsComp.canAddRemoveButton());

	}

	/**
	 * <p>
	 * This operation checks getAllMasters() and getMaster() by first adding the
	 * masters and then retrieving them.
	 * </p>
	 * 
	 */
	@Test
	public void checkMasters() {
		// Local Declarations
		MasterDetailsComponent mDetailsComp = new MasterDetailsComponent();
		DataComponent detailsComp1, detailsComp2, detailsComp3;
		MasterDetailsPair mdpair1, mdpair2, mdpair3;
		ArrayList<MasterDetailsPair> template;
		ArrayList<String> masterTypeTemplate;
		IEntry entry1, entry2, entry3, entry4;

		// Types of MasterValues
		String MasterType1 = "Type One";
		String MasterType2 = "Type Two";
		String MasterType3 = "Type Three";

		// create a new instance of MasterDetailsComponent
		mDetailsComp = new MasterDetailsComponent();

		// Setup list for templates
		// Create Entries

		entry1 = new ContinuousEntry("0","50");
		entry1.setDefaultValue("25");
		entry1.setValue("0");
		
		entry2 = new DiscreteEntry("Apple", "Orange");
		entry2.setDefaultValue("Orange");
		entry2.setValue("Orange");
				
		entry3 = new StringEntry();
		entry3.setDefaultValue("Gabriel");
		entry3.setValue("Gabriel");

		entry4 = new ContinuousEntry("0", "10000");
		entry4.setDefaultValue("9001");
		entry4.setValue("9001");

		// Create DataComponents
		detailsComp1 = new DataComponent();
		detailsComp2 = new DataComponent();
		detailsComp3 = new DataComponent();

		// Add entries
		detailsComp1.addEntry(entry1);
		detailsComp2.addEntry(entry2);
		detailsComp3.addEntry(entry3);
		detailsComp3.addEntry(entry4);

		// Set names
		detailsComp1.setName("DataComponent1");
		detailsComp2.setName("DataComponent2");
		detailsComp3.setName("DataComponent3");

		// Create pairs
		mdpair1 = new MasterDetailsPair(MasterType1, detailsComp1);
		mdpair2 = new MasterDetailsPair(MasterType2, detailsComp2);
		mdpair3 = new MasterDetailsPair(MasterType3, detailsComp3);
		mdpair1.setMasterDetailsPairId(0);
		mdpair2.setMasterDetailsPairId(1);
		mdpair3.setMasterDetailsPairId(2);

		// Add pairs to template
		template = new ArrayList<MasterDetailsPair>();
		template.add(mdpair1);
		template.add(mdpair2);
		template.add(mdpair3);

		// create a page, set template
		mDetailsComp = new MasterDetailsComponent();

		// Try to add a master, does not happen since the template has not been
		// set
		assertEquals(-1, mDetailsComp.addMaster());
		assertNull(mDetailsComp.getAllowedMasterValues());
		assertNull(mDetailsComp.getMasterValue(0));
		assertEquals(0, mDetailsComp.numberOfMasters());

		// check that the template needs to have contents
		mDetailsComp.setTemplates(new ArrayList<MasterDetailsPair>());
		assertEquals(-1, mDetailsComp.addMaster());
		assertNull(mDetailsComp.getAllowedMasterValues());
		assertNull(mDetailsComp.getMasterValue(0));
		assertEquals(0, mDetailsComp.numberOfMasters());

		// check that the template needs to have contents
		mDetailsComp.setTemplates(template);

		// Check the allowedMasterValues and masterValue
		masterTypeTemplate = mDetailsComp.getAllowedMasterValues();
		assertNotNull(masterTypeTemplate);
		assertEquals(MasterType1, masterTypeTemplate.get(0));
		assertEquals(MasterType2, masterTypeTemplate.get(1));
		assertEquals(MasterType3, masterTypeTemplate.get(2));
		assertEquals(0, mDetailsComp.numberOfMasters());

		// Add a master
		assertEquals(1, mDetailsComp.addMaster());
		assertEquals(2, mDetailsComp.addMaster());
		assertEquals(3, mDetailsComp.addMaster());
		assertEquals(3, mDetailsComp.numberOfMasters());

		// Check the type of a master - should always default to first type when
		// added
		// for first time.
		assertEquals(MasterType1, mDetailsComp.getMasterValue(1));
		assertEquals(MasterType1, mDetailsComp.getMasterValue(2));
		assertEquals(MasterType1, mDetailsComp.getMasterValue(3));

		// Time to edit a file and check if the masterType changed
		mDetailsComp.setMasterInstanceValue(2, MasterType2);
		mDetailsComp.setMasterInstanceValue(3, MasterType3);
		assertEquals(3, mDetailsComp.numberOfMasters());

		// Check the type of a master
		assertEquals(MasterType1, mDetailsComp.getMasterValue(1));
		assertEquals(MasterType2, mDetailsComp.getMasterValue(2));
		assertEquals(MasterType3, mDetailsComp.getMasterValue(3));

		// Check that the 2nd and 3rd copied correctly
		// Get the master, check that is equal to the first component
		assertTrue(mdpair2.getDetails().equals(mDetailsComp.getDetails(2)));
		assertTrue(mdpair3.getDetails().equals(mDetailsComp.getDetails(3)));

		// Set a master that does not exist
		assertEquals(4, mDetailsComp.addMaster());
		assertEquals(4, mDetailsComp.numberOfMasters()); // check the size of
															// the masters
		assertTrue(mDetailsComp.deleteMaster(4));
		assertEquals(3, mDetailsComp.numberOfMasters());
		assertFalse(mDetailsComp.setMasterInstanceValue(1, "Not a Type"));
		assertFalse(mDetailsComp.setMasterInstanceValue(2, null));
		assertFalse(mDetailsComp.setMasterInstanceValue(1, "Not a Type"));
		assertFalse(mDetailsComp.setMasterInstanceValue(-1, MasterType1));
		assertFalse(mDetailsComp.setMasterInstanceValue(4, MasterType1));

		// Set a Master to something that is the same type, but does not change
		// details
		mDetailsComp.getDetails(1).setName("I am different!");
		assertTrue(mDetailsComp.setMasterInstanceValue(1, MasterType1));
		assertEquals("I am different!", mDetailsComp.getDetails(1).getName());

		// Try to delete a master that does not exist
		assertFalse(mDetailsComp.deleteMaster(5));
		assertFalse(mDetailsComp.deleteMaster(4));
		assertFalse(mDetailsComp.deleteMaster(-1));
		assertEquals(3, mDetailsComp.numberOfMasters());

		// Try to delete when the templates are not set
		mDetailsComp = new MasterDetailsComponent();
		assertFalse(mDetailsComp.deleteMaster(0));

	}

	/**
	 * <p>
	 * This operations checks the four operations related to retrieving details.
	 * It creates several master instances in the component and calls the
	 * details getters in turn (including getAllDetails()). It also sets the
	 * values of the masters and makes sure that the associated details blocks
	 * change to the appropriate DataComponent.
	 * </p>
	 * 
	 */
	@Test
	public void checkDetails() {
		// Local Declarations
		MasterDetailsComponent mDetailsComp = new MasterDetailsComponent();
		DataComponent detailsComp1, detailsComp2, detailsComp3;
		MasterDetailsPair mdpair1, mdpair2, mdpair3;
		ArrayList<MasterDetailsPair> template;
		IEntry entry1, entry2, entry3, entry4;

		// Types of MasterValues
		String MasterType1 = "Type One";
		String MasterType2 = "Type Two";
		String MasterType3 = "Type Three";

		// create a new instance of MasterDetailsComponent
		mDetailsComp = new MasterDetailsComponent();

		// Setup list for templates
		// Create Entries
		entry1 = new ContinuousEntry("0","50");
		entry1.setDefaultValue("25");
		entry1.setValue("0");
		
		entry2 = new DiscreteEntry("Apple", "Orange");
		entry2.setDefaultValue("Orange");
		entry2.setValue("Orange");
				
		entry3 = new StringEntry();
		entry3.setDefaultValue("Gabriel");
		entry3.setValue("Gabriel");

		entry4 = new ContinuousEntry("0", "10000");
		entry4.setDefaultValue("9001");
		entry4.setValue("9001");

		// Create DataComponents
		detailsComp1 = new DataComponent();
		detailsComp2 = new DataComponent();
		detailsComp3 = new DataComponent();

		// Add entries
		detailsComp1.addEntry(entry1);
		detailsComp2.addEntry(entry2);
		detailsComp3.addEntry(entry3);
		detailsComp3.addEntry(entry4);

		// Set names
		detailsComp1.setName("DataComponent1");
		detailsComp2.setName("DataComponent2");
		detailsComp3.setName("DataComponent3");

		// Create pairs
		mdpair1 = new MasterDetailsPair(MasterType1, detailsComp1);
		mdpair2 = new MasterDetailsPair(MasterType2, detailsComp2);
		mdpair3 = new MasterDetailsPair(MasterType3, detailsComp3);
		mdpair1.setMasterDetailsPairId(0);
		mdpair2.setMasterDetailsPairId(1);
		mdpair3.setMasterDetailsPairId(2);

		// Add pairs to template
		template = new ArrayList<MasterDetailsPair>();
		template.add(mdpair1);
		template.add(mdpair2);
		template.add(mdpair3);

		// check that the template needs to have contents
		mDetailsComp.setTemplates(template);

		// Check get details and setting masters on an empty list
		assertNull(mDetailsComp.getDetails(0));
		mDetailsComp.setMasterInstanceValue(0, MasterType1); // Cant really
																// check, but
																// nothing
																// should happen

		// Add masters to the list
		assertEquals(1, mDetailsComp.addMaster());
		assertEquals(2, mDetailsComp.addMaster());
		assertEquals(3, mDetailsComp.addMaster());

		// Check details
		assertTrue(detailsComp1.equals(mDetailsComp.getDetails(1)));
		assertTrue(detailsComp1.equals(mDetailsComp.getDetails(2)));
		assertTrue(detailsComp1.equals(mDetailsComp.getDetails(3)));

		// Try to get details on something that does not exist
		assertNull(mDetailsComp.getDetails(4));
		assertNull(mDetailsComp.getDetails(-1));
	}

	/**
	 * <p>
	 * This operation checks the ability of the MasterDetailsComponent to
	 * process updates. At the moment, it should do absolutely nothing (so
	 * nothing should change).
	 * </p>
	 * 
	 */
	public void checkUpdate() {
		// Nothing to do here

	}

	/**
	 * <p>
	 * This operation tests the MasterDetailsComponent to insure that it can
	 * properly dispatch notifications when it receives an update that changes
	 * its state.
	 * </p>
	 * 
	 */
	@Test
	public void checkNotifications() {
		// Local Declarations
		MasterDetailsComponent mDetailsComp = new MasterDetailsComponent();
		DataComponent detailsComp1, detailsComp2, detailsComp3;
		MasterDetailsPair mdpair1, mdpair2, mdpair3;
		ArrayList<MasterDetailsPair> template;
		IEntry entry1, entry2, entry3, entry4;

		// Types of MasterValues
		String MasterType1 = "Type One";
		String MasterType2 = "Type Two";
		String MasterType3 = "Type Three";

		// create a new instance of MasterDetailsComponent
		mDetailsComp = new MasterDetailsComponent();

		// Setup list for templates
		// Create Entries
		entry1 = new ContinuousEntry("0","50");
		entry1.setDefaultValue("25");
		entry1.setValue("0");
		
		entry2 = new DiscreteEntry("Apple", "Orange");
		entry2.setDefaultValue("Orange");
		entry2.setValue("Orange");
				
		entry3 = new StringEntry();
		entry3.setDefaultValue("Gabriel");
		entry3.setValue("Gabriel");

		entry4 = new ContinuousEntry("0", "10000");
		entry4.setDefaultValue("9001");
		entry4.setValue("9001");

		// Create DataComponents
		detailsComp1 = new DataComponent();
		detailsComp2 = new DataComponent();
		detailsComp3 = new DataComponent();

		// Add entries
		detailsComp1.addEntry(entry1);
		detailsComp2.addEntry(entry2);
		detailsComp3.addEntry(entry3);
		detailsComp3.addEntry(entry4);

		// Set names
		detailsComp1.setName("DataComponent1");
		detailsComp2.setName("DataComponent2");
		detailsComp3.setName("DataComponent3");

		// Create pairs
		mdpair1 = new MasterDetailsPair(MasterType1, detailsComp1);
		mdpair2 = new MasterDetailsPair(MasterType2, detailsComp2);
		mdpair3 = new MasterDetailsPair(MasterType3, detailsComp3);
		mdpair1.setMasterDetailsPairId(0);
		mdpair2.setMasterDetailsPairId(1);
		mdpair3.setMasterDetailsPairId(2);

		// Add pairs to template
		template = new ArrayList<MasterDetailsPair>();
		template.add(mdpair1);
		template.add(mdpair2);
		template.add(mdpair3);

		// Setup the listener
		testComponentListener = new TestComponentListener();

		// Register the listener
		mDetailsComp.register(testComponentListener);

		// check that the template needs to have contents
		mDetailsComp.setTemplates(template);

		// Check the Listener
		assertTrue(testComponentListener.wasNotified());

		// Reset the listener
		testComponentListener.reset();

		mDetailsComp.addMaster();
		mDetailsComp.addMaster();

		// Check the Listener
		assertTrue(testComponentListener.wasNotified());

		// Reset the listener
		testComponentListener.reset();

		mDetailsComp.deleteMaster(1);

		// Check the Listener
		assertTrue(testComponentListener.wasNotified());

		// Reset the listener
		testComponentListener.reset();

		mDetailsComp.setMasterInstanceValue(2, MasterType1);

		// Check the Listener
		assertTrue(testComponentListener.wasNotified());

		// Reset the listener
		testComponentListener.reset();

		mDetailsComp.copy((MasterDetailsComponent) mDetailsComp.clone());

		// Check the Listener
		assertTrue(testComponentListener.wasNotified());

		// Reset the listener
		testComponentListener.reset();

		// Test to see globals set correctly
		DataComponent globals = new DataComponent();
		globals.addEntry(new StringEntry());
		mDetailsComp.setGlobalsComponent(globals);

		// Check the Listener
		assertTrue(testComponentListener.wasNotified());

		// Reset the listener
		testComponentListener.reset();

	}

	/**
	 * <p>
	 * This operation checks the MasterDetailsComponent to insure that it can be
	 * correctly visited by a realization of the IComponentVisitor interface.
	 * </p>
	 * 
	 */
	@Test
	public void checkVisitation() {
		// Local Declarations
		MasterDetailsComponent master = new MasterDetailsComponent();

		// Setup the visitor
		testVisitor = new TestVisitor();

		// Send the visitor
		master.accept(testVisitor);

		// Check the visitor
		assertTrue(testVisitor.wasVisited());

	}

	/**
	 * <p>
	 * This operation checks the MasterDetailsComponent to insure that its
	 * equals() and hashcode() operations work.
	 * </p>
	 * 
	 */
	@Test
	public void checkEquality() {
		// Local Declarations
		MasterDetailsComponent component = new MasterDetailsComponent();
		MasterDetailsComponent equalComponent = new MasterDetailsComponent();
		MasterDetailsComponent unEqualComponent = new MasterDetailsComponent();
		MasterDetailsComponent transitiveComponent = new MasterDetailsComponent();
		ArrayList<MasterDetailsPair> mdpairList = new ArrayList<MasterDetailsPair>();
		IEntry entry5, entry6;
		DataComponent globalsDataComponent;

		DataComponent dComponent = new DataComponent();
		DataComponent dComponent2 = new DataComponent();
		IEntry entry1 = new StringEntry();
		entry1.setValue("300");

		dComponent.addEntry(new StringEntry());
		dComponent2.addEntry(entry1);

		MasterDetailsPair mdpair1 = new MasterDetailsPair("Type One",
				dComponent);
		MasterDetailsPair mdpair2 = new MasterDetailsPair("Type Bueno",
				dComponent2);

		mdpairList.add(mdpair1);
		unEqualComponent.setTemplates(mdpairList);
		mdpairList.add(mdpair2);
		component.setTemplates(mdpairList);
		equalComponent.setTemplates(mdpairList);
		transitiveComponent.setTemplates(mdpairList);

		// Setup Globals DataComponent
		globalsDataComponent = new DataComponent();

		entry5 = new StringEntry();
		entry5.setDefaultValue("Gabriel");
		entry5.setValue("Gabriel");

		entry6 = new ContinuousEntry("0", "10000");
		entry6.setDefaultValue("9001");
		entry6.setValue("9001");

		globalsDataComponent.addEntry(entry5);
		globalsDataComponent.addEntry(entry6);

		component.setGlobalsComponent(globalsDataComponent);
		equalComponent.setGlobalsComponent(globalsDataComponent);
		transitiveComponent.setGlobalsComponent(globalsDataComponent);

		// Set ICEObject data
		component.setId(1);
		equalComponent.setId(1);
		transitiveComponent.setId(1);
		unEqualComponent.setId(2);

		component.setName("DC Equal");
		equalComponent.setName("DC Equal");
		transitiveComponent.setName("DC Equal");
		unEqualComponent.setName("DC UnEqual");

		// Check two freshly created objects can be equal to each other
		assertTrue(new MasterDetailsComponent()
				.equals(new MasterDetailsComponent()));

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
	 * This operation checks the MasterDetailsComponent to ensure that its
	 * copy() and clone() operations work as specified.
	 * </p>
	 * 
	 */
	@Test
	public void checkCopying() {
		// Local Declarations
		MasterDetailsComponent cloneMaster, copyMaster;
		MasterDetailsComponent mDetailsComp = new MasterDetailsComponent();
		DataComponent detailsComp1, detailsComp2, detailsComp3;
		MasterDetailsPair mdpair1, mdpair2, mdpair3;
		ArrayList<MasterDetailsPair> template;
		IEntry entry1, entry2, entry3, entry4, entry5, entry6;
		DataComponent globalsDataComponent;

		// Check to make sure listener is copied!
		TestComponentListener listener = new TestComponentListener();

		// Types of MasterValues
		String MasterType1 = "Type One";
		String MasterType2 = "Type Two";
		String MasterType3 = "Type Three";

		// create a new instance of MasterDetailsComponent
		mDetailsComp = new MasterDetailsComponent();

		// Setup list for templates

		// Create Entries
		entry1 = new ContinuousEntry("0","50");
		entry1.setDefaultValue("25");
		entry1.setValue("0");
		
		entry2 = new DiscreteEntry("Apple", "Orange");
		entry2.setDefaultValue("Orange");
		entry2.setValue("Orange");
				
		entry3 = new StringEntry();
		entry3.setDefaultValue("Gabriel");
		entry3.setValue("Gabriel");

		entry4 = new ContinuousEntry("0", "10000");
		entry4.setDefaultValue("9001");
		entry4.setValue("9001");

		// Create DataComponents
		detailsComp1 = new DataComponent();
		detailsComp2 = new DataComponent();
		detailsComp3 = new DataComponent();

		// Add entries
		detailsComp1.addEntry(entry1);
		detailsComp2.addEntry(entry2);
		detailsComp3.addEntry(entry3);
		detailsComp3.addEntry(entry4);

		// Set names
		detailsComp1.setName("DataComponent1");
		detailsComp2.setName("DataComponent2");
		detailsComp3.setName("DataComponent3");

		// Create pairs
		mdpair1 = new MasterDetailsPair(MasterType1, detailsComp1);
		mdpair2 = new MasterDetailsPair(MasterType2, detailsComp2);
		mdpair3 = new MasterDetailsPair(MasterType3, detailsComp3);
		mdpair1.setMasterDetailsPairId(0);
		mdpair2.setMasterDetailsPairId(1);
		mdpair3.setMasterDetailsPairId(2);

		// Add pairs to template
		template = new ArrayList<MasterDetailsPair>();
		template.add(mdpair1);
		template.add(mdpair2);
		template.add(mdpair3);

		// create a page, set template
		mDetailsComp = new MasterDetailsComponent();

		mDetailsComp.setTemplates(template);

		// Setup Globals DataComponent
		globalsDataComponent = new DataComponent();

		entry5 = new StringEntry();
		entry5.setDefaultValue("Gabriel");
		entry5.setValue("Gabriel");

		entry6 = new ContinuousEntry("0", "10000");
		entry6.setDefaultValue("9001");
		entry6.setValue("9001");

		// Add listener
		mDetailsComp.register(listener);

		// Add entries to globals DataComponent.
		globalsDataComponent.addEntry(entry5);
		globalsDataComponent.addEntry(entry6);
		mDetailsComp.setGlobalsComponent(globalsDataComponent);

		mDetailsComp.addMaster();
		// Clone contents
		cloneMaster = (MasterDetailsComponent) mDetailsComp.clone();

		assertNotNull(cloneMaster);

		// Check equality of contents
		assertTrue(cloneMaster.equals(mDetailsComp));

		// Copy contents
		copyMaster = new MasterDetailsComponent();
		copyMaster.copy(mDetailsComp);

		// Check equality of contents
		assertTrue(copyMaster.equals(mDetailsComp));

		// Pass null into copy contents, show nothing has changed
		copyMaster.copy(null);

		// Check equality of contents
		assertTrue(copyMaster.equals(mDetailsComp));

		return;
	}

	/**
	 * This operation checks the ability of the MasterDetailsComponent to
	 * persist itself to XML and to load itself from an XML input stream.
	 * @throws IOException 
	 * @throws JAXBException 
	 * @throws NullPointerException 
	 */
	@Test
	public void checkLoadingFromXML() throws NullPointerException, JAXBException, IOException {
		// Local Declarations
		MasterDetailsComponent loadMaster;
		MasterDetailsComponent mDetailsComp = new MasterDetailsComponent();
		DataComponent detailsComp1, detailsComp2, detailsComp3;
		MasterDetailsPair mdpair1, mdpair2, mdpair3;
		ArrayList<MasterDetailsPair> template;
		IEntry entry1, entry2, entry3, entry4;
		IEntry entryGlobal1, entryGlobal2;
		DataComponent globalsDataComponent;
		ICEJAXBHandler xmlHandler = new ICEJAXBHandler();
		ArrayList<Class> classList = new ArrayList<Class>();
		classList.add(MasterDetailsComponent.class);
		classList.addAll(new ICEJAXBClassProvider().getClasses());
		
		// Types of MasterValues
		String MasterType1 = "Type One";
		String MasterType2 = "Type Two";
		String MasterType3 = "Type Three";

		// create a new instance of MasterDetailsComponent
		mDetailsComp = new MasterDetailsComponent();

		// Setup list for templates

		// Create Entries
		entry1 = new ContinuousEntry("0","50");
		entry1.setDefaultValue("25");
		entry1.setValue("0");
		
		entry2 = new DiscreteEntry("Apple", "Orange");
		entry2.setDefaultValue("Orange");
		entry2.setValue("Orange");
				
		entry3 = new StringEntry();
		entry3.setDefaultValue("Gabriel");
		entry3.setValue("Gabriel");

		entry4 = new ContinuousEntry("0", "10000");
		entry4.setDefaultValue("9001");
		entry4.setValue("9001");

		// Create DataComponents
		detailsComp1 = new DataComponent();
		detailsComp2 = new DataComponent();
		detailsComp3 = new DataComponent();

		// Add entries
		detailsComp1.addEntry(entry1);
		detailsComp2.addEntry(entry2);
		detailsComp3.addEntry(entry3);
		detailsComp3.addEntry(entry4);

		// Set names
		detailsComp1.setName("DataComponent1");
		detailsComp2.setName("DataComponent2");
		detailsComp3.setName("DataComponent3");

		// Create pairs
		mdpair1 = new MasterDetailsPair(MasterType1, detailsComp1);
		mdpair2 = new MasterDetailsPair(MasterType2, detailsComp2);
		mdpair3 = new MasterDetailsPair(MasterType3, detailsComp3);
		mdpair1.setMasterDetailsPairId(0);
		mdpair2.setMasterDetailsPairId(1);
		mdpair3.setMasterDetailsPairId(2);

		// Add pairs to template
		template = new ArrayList<MasterDetailsPair>();
		template.add(mdpair1);
		template.add(mdpair2);
		template.add(mdpair3);

		// create a page, set template
		mDetailsComp = new MasterDetailsComponent();

		mDetailsComp.setTemplates(template);

		// Setup Globals DataComponent
		globalsDataComponent = new DataComponent();
				
		entryGlobal1 = new StringEntry();
		entryGlobal1.setDefaultValue("Gabriel");
		entryGlobal1.setValue("Gabriel");

		entryGlobal2 = new ContinuousEntry("0", "10000");
		entryGlobal2.setDefaultValue("9001");
		entryGlobal2.setValue("9001");

		globalsDataComponent.addEntry(entryGlobal1);
		globalsDataComponent.addEntry(entryGlobal2);

		mDetailsComp.setGlobalsComponent(globalsDataComponent);

		mDetailsComp.addMaster();

		// Load it into XML
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		xmlHandler.write(mDetailsComp, classList, outputStream);

		// convert information inside of outputStream to inputStream
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				outputStream.toByteArray());
		// load contents into xml
		loadMaster = new MasterDetailsComponent();
		loadMaster = (MasterDetailsComponent) xmlHandler.read(classList, inputStream);
		// Check the contents
		assertTrue(loadMaster.equals(mDetailsComp));

	}

	/**
	 * <p>
	 * An operation that checks the getGlobalsComponent() and
	 * setGlobalsComponent() operations on MasterDetailsComponent.
	 * </p>
	 * 
	 */
	@Test
	public void checkGetSetGlobalsComponent() {
		// Local Declarations
		MasterDetailsComponent mDetailsComp = new MasterDetailsComponent();
		DataComponent detailsComp1, detailsComp2, detailsComp3;
		MasterDetailsPair mdpair1, mdpair2, mdpair3;
		ArrayList<MasterDetailsPair> template;
		IEntry entry1, entry2, entry3, entry4, entry5, entry6;
		DataComponent globalsDataComponent = new DataComponent();

		// Types of MasterValues
		String MasterType1 = "Type One";
		String MasterType2 = "Type Two";
		String MasterType3 = "Type Three";

		// create a new instance of MasterDetailsComponent
		mDetailsComp = new MasterDetailsComponent();

		// Setup list for templates

		entry1 = new ContinuousEntry("0","50");
		entry1.setDefaultValue("25");
		entry1.setValue("0");
		
		entry2 = new DiscreteEntry("Apple", "Orange");
		entry2.setDefaultValue("Orange");
		entry2.setValue("Orange");
				
		entry3 = new StringEntry();
		entry3.setDefaultValue("Gabriel");
		entry3.setValue("Gabriel");

		entry4 = new ContinuousEntry("0", "10000");
		entry4.setDefaultValue("9001");
		entry4.setValue("9001");

		// Create DataComponents
		detailsComp1 = new DataComponent();
		detailsComp2 = new DataComponent();
		detailsComp3 = new DataComponent();

		// Add entries
		detailsComp1.addEntry(entry1);
		detailsComp2.addEntry(entry2);
		detailsComp3.addEntry(entry3);
		detailsComp3.addEntry(entry4);

		// Set names
		detailsComp1.setName("DataComponent1");
		detailsComp2.setName("DataComponent2");
		detailsComp3.setName("DataComponent3");

		// Create pairs
		mdpair1 = new MasterDetailsPair(MasterType1, detailsComp1);
		mdpair2 = new MasterDetailsPair(MasterType2, detailsComp2);
		mdpair3 = new MasterDetailsPair(MasterType3, detailsComp3);
		mdpair1.setMasterDetailsPairId(0);
		mdpair2.setMasterDetailsPairId(1);
		mdpair3.setMasterDetailsPairId(2);

		// Add pairs to template
		template = new ArrayList<MasterDetailsPair>();
		template.add(mdpair1);
		template.add(mdpair2);
		template.add(mdpair3);

		// create a page, set template
		mDetailsComp = new MasterDetailsComponent();
		// Globals should be Null when created for MasterDetailsComponent
		assertNull(mDetailsComp.getGlobalsComponent());

		// Setup Globals DataComponent
		globalsDataComponent = new DataComponent();

		entry5 = new StringEntry();
		entry5.setDefaultValue("Gabriel");
		entry5.setValue("Gabriel");

		entry6 = new ContinuousEntry("0", "10000");
		entry6.setDefaultValue("9001");
		entry6.setValue("9001");

		// Add entries to global DataComponent
		globalsDataComponent.addEntry(entry5);
		globalsDataComponent.addEntry(entry6);

		// You can set globals without setting a template!
		mDetailsComp.setGlobalsComponent(globalsDataComponent);
		// Should not be null
		assertNotNull(mDetailsComp.getGlobalsComponent());

		// Setup Template
		mDetailsComp.setTemplates(template);

		// You can still set the template
		mDetailsComp.setGlobalsComponent(globalsDataComponent);

		// check to see that is the globalsDataComponent we passed!
		assertTrue(globalsDataComponent.equals(mDetailsComp
				.getGlobalsComponent()));

		// You can pass null, it does set it to null!
		// Now you can add a GlobalsComponent
		mDetailsComp.setGlobalsComponent(null);

		// check to see that it is null
		assertNull(mDetailsComp.getGlobalsComponent());

		// We can pass an empty DataComponent (no Entries)
		mDetailsComp.setGlobalsComponent(new DataComponent());

		// check to see that it is not null
		assertNotNull(mDetailsComp.getGlobalsComponent());
		// See that the entries list is empty!
		assertEquals(0, mDetailsComp.getGlobalsComponent().retrieveAllEntries()
				.size());

	}

	/**
	 * <p>
	 * An operation that checks getMasterAtIndex(), getDetailsAtIndex(),
	 * getUniqueMasterValue(), deleteMasterAtIndex(), and
	 * getUniqueMasterValueAtIndex().
	 * </p>
	 * 
	 */
	@Test
	public void checkAtIndexOperations() {
		// Local Declarations
		MasterDetailsComponent mDetailsComp = new MasterDetailsComponent();
		DataComponent detailsComp1, detailsComp2, detailsComp3;
		MasterDetailsPair mdpair1, mdpair2, mdpair3;
		ArrayList<MasterDetailsPair> template;
		IEntry entry1, entry2, entry3, entry4, entry5, entry6;
		DataComponent globalsDataComponent = new DataComponent();

		// Types of MasterValues
		String MasterType1 = "Type One";
		String MasterType2 = "Type Two";
		String MasterType3 = "Type Three";

		// create a new instance of MasterDetailsComponent
		mDetailsComp = new MasterDetailsComponent();

		// Setup list for templates

		// Create Entries
		entry1 = new ContinuousEntry("0","50");
		entry1.setDefaultValue("25");
		entry1.setValue("0");
		
		entry2 = new DiscreteEntry("Apple", "Orange");
		entry2.setDefaultValue("Orange");
		entry2.setValue("Orange");
				
		entry3 = new StringEntry();
		entry3.setDefaultValue("Gabriel");
		entry3.setValue("Gabriel");

		entry4 = new ContinuousEntry("0", "10000");
		entry4.setDefaultValue("9001");
		entry4.setValue("9001");
		// Create DataComponents
		detailsComp1 = new DataComponent();
		detailsComp2 = new DataComponent();
		detailsComp3 = new DataComponent();

		// Add entries
		detailsComp1.addEntry(entry1);
		detailsComp2.addEntry(entry2);
		detailsComp3.addEntry(entry3);
		detailsComp3.addEntry(entry4);

		// Set names
		detailsComp1.setName("DataComponent1");
		detailsComp2.setName("DataComponent2");
		detailsComp3.setName("DataComponent3");

		// Create pairs
		mdpair1 = new MasterDetailsPair(MasterType1, detailsComp1);
		mdpair2 = new MasterDetailsPair(MasterType2, detailsComp2);
		mdpair3 = new MasterDetailsPair(MasterType3, detailsComp3);
		mdpair1.setMasterDetailsPairId(0);
		mdpair2.setMasterDetailsPairId(1);
		mdpair3.setMasterDetailsPairId(2);

		// Add pairs to template
		template = new ArrayList<MasterDetailsPair>();
		template.add(mdpair1);
		template.add(mdpair2);
		template.add(mdpair3);

		// create a page, set template
		mDetailsComp = new MasterDetailsComponent();

		// Setup Globals DataComponent
		globalsDataComponent = new DataComponent();

		// Setup Entries for global DataComponent
		entry5 = new StringEntry();
		entry5.setDefaultValue("Gabriel");
		entry5.setValue("Gabriel");

		entry6 = new ContinuousEntry("0", "10000");
		entry6.setDefaultValue("9001");
		entry6.setValue("9001");

		// Add entries to global DataComponent
		globalsDataComponent.addEntry(entry5);
		globalsDataComponent.addEntry(entry6);

		// These operations should return null when a template has not been set.
		assertNull(mDetailsComp.getMasterAtIndex(0));
		assertNull(mDetailsComp.getDetailsAtIndex(0));
		assertNull(mDetailsComp.getUniqueMasterValueAtIndex(0));
		assertNull(mDetailsComp.getUniqueMasterValue(1));
		assertFalse(mDetailsComp.deleteMasterAtIndex(0));

		// Setup Template
		mDetailsComp.setTemplates(template);

		// Now you can add a GlobalsComponent
		mDetailsComp.setGlobalsComponent(globalsDataComponent);

		// These operations should return null when MasterDetailsPairs do not
		// exist
		assertNull(mDetailsComp.getMasterAtIndex(0));
		assertNull(mDetailsComp.getDetailsAtIndex(0));
		assertNull(mDetailsComp.getUniqueMasterValueAtIndex(0));
		assertNull(mDetailsComp.getUniqueMasterValue(0));
		assertFalse(mDetailsComp.deleteMasterAtIndex(0));
		assertFalse(mDetailsComp.deleteMasterAtIndex(-1));

		// Add Some masters
		mDetailsComp.addMaster();
		mDetailsComp.addMaster();

		// Check operations
		assertEquals(MasterType1, mDetailsComp.getMasterAtIndex(0));
		assertTrue(detailsComp1.equals(mDetailsComp.getDetailsAtIndex(0)));
		assertEquals("1 " + MasterType1,
				mDetailsComp.getUniqueMasterValueAtIndex(0));
		assertEquals("1 " + MasterType1, mDetailsComp.getUniqueMasterValue(1));

		// Check operations
		assertEquals(MasterType1, mDetailsComp.getMasterAtIndex(1));
		assertTrue(detailsComp1.equals(mDetailsComp.getDetailsAtIndex(1)));
		assertEquals("2 " + MasterType1,
				mDetailsComp.getUniqueMasterValueAtIndex(1));
		assertEquals("2 " + MasterType1, mDetailsComp.getUniqueMasterValue(2));

		// Change the 0 masters to masters 3
		mDetailsComp.setMasterInstanceValue(1, MasterType3);

		assertEquals(MasterType3, mDetailsComp.getMasterAtIndex(0));
		assertTrue(mdpair3.getDetails().equals(
				mDetailsComp.getDetailsAtIndex(0)));
		assertEquals("1 " + MasterType3,
				mDetailsComp.getUniqueMasterValueAtIndex(0));
		assertEquals("1 " + MasterType3, mDetailsComp.getUniqueMasterValue(1));

		// Check operations, check the type to see if it is set correctly.
		assertEquals(MasterType1, mDetailsComp.getMasterAtIndex(1));
		assertTrue(detailsComp1.equals(mDetailsComp.getDetailsAtIndex(1)));
		assertEquals("2 " + MasterType1,
				mDetailsComp.getUniqueMasterValueAtIndex(1));
		assertEquals("2 " + MasterType1, mDetailsComp.getUniqueMasterValue(2));

		// Add another master, delete 2nd master
		mDetailsComp.addMaster();
		mDetailsComp.setMasterInstanceValue(3, MasterType2);
		mDetailsComp.deleteMaster(2);

		// Check operations for 2nd master - Even though the 2nd master is
		// killed, it is replaced by 3rd add
		assertEquals(MasterType2, mDetailsComp.getMasterAtIndex(1));
		assertTrue(detailsComp2.equals(mDetailsComp.getDetailsAtIndex(1)));
		assertEquals("3 " + MasterType2,
				mDetailsComp.getUniqueMasterValueAtIndex(1));
		assertEquals("3 " + MasterType2, mDetailsComp.getUniqueMasterValue(3)); // See
																				// this
																				// is
																				// 3
																				// and
																				// not
																				// 2!
																				// UniqueID!

		// Delete 3rd master, add another master
		mDetailsComp.deleteMaster(3);
		mDetailsComp.addMaster();
		mDetailsComp.setMasterInstanceValue(4, MasterType3);

		// Should only be two masters. Check accordingly

		// Check operations - check the type to see if it is set correctly.
		assertEquals(MasterType3, mDetailsComp.getMasterAtIndex(0));
		assertTrue(detailsComp3.equals(mDetailsComp.getDetailsAtIndex(0)));
		assertEquals("1 " + MasterType3,
				mDetailsComp.getUniqueMasterValueAtIndex(0));
		assertEquals("1 " + MasterType3, mDetailsComp.getUniqueMasterValue(1));

		// Check operations- check the type to see if it is set correctly.
		assertEquals(MasterType3, mDetailsComp.getMasterAtIndex(1));
		assertTrue(detailsComp3.equals(mDetailsComp.getDetailsAtIndex(1)));
		assertEquals("4 " + MasterType3,
				mDetailsComp.getUniqueMasterValueAtIndex(1));
		assertEquals("4 " + MasterType3, mDetailsComp.getUniqueMasterValue(4)); // See
																				// this
																				// is
																				// 4
																				// and
																				// not
																				// 2!
																				// UniqueID!

		// Add a few and delete them all
		mDetailsComp.addMaster();
		mDetailsComp.addMaster();

		// Delete them all
		assertTrue(mDetailsComp.deleteMasterAtIndex(3));
		assertTrue(mDetailsComp.deleteMasterAtIndex(1));
		assertTrue(mDetailsComp.deleteMasterAtIndex(0));
		assertTrue(mDetailsComp.deleteMasterAtIndex(0));
		assertFalse(mDetailsComp.deleteMasterAtIndex(0)); // Index 0 is gone,
															// should be unable
															// to delete

	}

	/**
	 * <p>
	 * Checks the toggling of add and removing of buttons boolean for MDC.
	 * </p>
	 * 
	 */
	@Test
	public void checkToggle() {

		// Instantiate a new master details component
		MasterDetailsComponent mDetailsComp = new MasterDetailsComponent();

		// Set false
		mDetailsComp.toggleAddRemoveButton(false);

		// Check value
		assertFalse(mDetailsComp.canAddRemoveButton());

		// Set true
		mDetailsComp.toggleAddRemoveButton(true);

		// Check value
		assertTrue(mDetailsComp.canAddRemoveButton());

	}
}