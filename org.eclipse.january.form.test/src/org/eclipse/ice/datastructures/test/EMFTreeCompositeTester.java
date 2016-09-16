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
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.eclipse.january.form.DataComponent;
import org.eclipse.january.form.emf.EMFTreeComposite;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

/**
 * This class tests the EMFTreeComposite. It checks that the class can be
 * constructed from a valid EClass instance, that the tree can be modified
 * through the addition of children, and that the tree can be copied and cloned.
 * 
 * @author Alex McCaskey
 *
 */
public class EMFTreeCompositeTester {

	/**
	 * Reference to a list of EMFTreeComposites that will be created from the
	 * Ship Order schema
	 */
	private ArrayList<EMFTreeComposite> trees;

	/**
	 * Reference to the XMLProcessor used to create an Ecore model from a valid
	 * XML schema file.
	 */
	private XMLProcessor processor;

	/**
	 * This method is run before all tests and initializes a set of
	 * EMFTreeComposites for testing.
	 */
	@Before
	public void before() {
		// Local Declarations
		String separator = System.getProperty("file.separator");
		String userDir = System.getProperty("user.home") + separator
				+ "JanuaryTests" + separator + "datastructuresData";
		String filePath = userDir + separator + "shiporder.xsd";
		processor = null;
		trees = new ArrayList<EMFTreeComposite>();

		// Create an XMLProcessor instance to help
		// us load the ShipOrder EPackage
		try {
			processor = new XMLProcessor(URI.createFileURI(filePath));
		} catch (SAXException e) {
			e.printStackTrace();
			fail();
		}

		// Get the EPackage, this has the entire Ecore model in it
		EPackage shipOrderPackage = (EPackage) processor.getEPackageRegistry()
				.values().toArray()[0];

		// Walk the Tree to get the EClass instances,
		// those are what make up our EMFTreeComposite nodes
		TreeIterator<EObject> tree = shipOrderPackage.eAllContents();
		while (tree.hasNext()) {
			EObject obj = tree.next();
			if (obj instanceof EClass) {
				EClass eClass = (EClass) obj;
				trees.add(new EMFTreeComposite(eClass));

			}
		}
	}

	/**
	 * Check that we can correctly construct EMFTreeComposites from EClass
	 * objects.
	 */
	@Test
	public void checkConstruction() {

		// Make sure we have 4 trees
		// for the 4 EClass instances
		// DocumentRoot, ShipOrder, ShiptTo, and Item
		assertEquals(4, trees.size());

		// Get those trees and make sure their names were
		// set correctly.
		EMFTreeComposite docRoot = trees.get(0);
		EMFTreeComposite item = trees.get(1);
		EMFTreeComposite shipOrder = trees.get(2);
		EMFTreeComposite shipTo = trees.get(3);
		assertEquals("DocumentRoot", docRoot.getName());
		assertEquals("ItemType", item.getName());
		assertEquals("ShiporderType", shipOrder.getName());
		assertEquals("ShiptoType", shipTo.getName());

		// Check the ShipOrder tree's DataComponent
		DataComponent data = (DataComponent) shipOrder.getActiveDataNode();
		assertNotNull(data);
		assertEquals(2, data.retrieveAllEntries().size());
		assertTrue(data.contains("orderperson"));
		assertTrue(data.contains("orderid"));

		// Check the ShipTo tree's DataComponent
		data = (DataComponent) shipTo.getActiveDataNode();
		assertNotNull(data);
		assertEquals(4, data.retrieveAllEntries().size());
		assertTrue(data.contains("name"));
		assertTrue(data.contains("address"));
		assertTrue(data.contains("city"));
		assertTrue(data.contains("country"));

		// Check the ItemType tree's DataComponent
		data = (DataComponent) item.getActiveDataNode();
		assertNotNull(data);
		assertEquals(4, data.retrieveAllEntries().size());
		assertTrue(data.contains("title"));
		assertTrue(data.contains("quantity"));
		assertTrue(data.contains("price"));
		assertTrue(data.contains("note"));

		// Check that we can modify the tree entries
		data = (DataComponent) shipTo.getActiveDataNode();
		data.retrieveEntry("name").setValue("McCaskey");

	}

	/**
	 * Test that we can properly get correct child exemplars
	 */
	@Test
	public void checkGetChildExemplars() {
		EMFTreeComposite docRoot = trees.get(0);
		EMFTreeComposite item = trees.get(1);
		EMFTreeComposite shipOrder = trees.get(2);
		EMFTreeComposite shipTo = trees.get(3);

		// Now make sure we have the correct number of child exemplars
		assertEquals(1, docRoot.getChildExemplars().size());
		assertTrue("ShiporderType"
				.equals(docRoot.getChildExemplars().get(0).getName()));
		assertEquals(2, shipOrder.getChildExemplars().size());
		assertTrue("ShiptoType"
				.equals(shipOrder.getChildExemplars().get(0).getName()));
		assertTrue("ItemType"
				.equals(shipOrder.getChildExemplars().get(1).getName()));
		assertEquals(0, item.getChildExemplars().size());
		assertEquals(0, shipTo.getChildExemplars().size());

	}

	/**
	 * Check that we can add and remove children correctly.
	 */
	@Test
	public void checkAddRemoveChildren() {

		// Get the Tree nodes
		EMFTreeComposite docRoot = trees.get(0);
		EMFTreeComposite item = trees.get(1);
		EMFTreeComposite shipOrder = trees.get(2);
		EMFTreeComposite shipTo = trees.get(3);

		// Clone the ShipOrder tree
		EMFTreeComposite clonedOrder = (EMFTreeComposite) shipOrder.clone();

		// Add it to the DocumentRoot tree
		assertEquals(0, docRoot.getNumberOfChildren());
		docRoot.setNextChild(clonedOrder);
		assertEquals(1, docRoot.getNumberOfChildren());
		docRoot.setNextChild(clonedOrder);
		assertEquals(1, docRoot.getNumberOfChildren());

		// Change the value of an Entry
		assertTrue(((DataComponent) clonedOrder.getActiveDataNode())
				.retrieveEntry("orderperson").setValue("McCaskey"));

		// Clone the ItemType, this one is unbounded, ie
		// we can add many of them.
		EMFTreeComposite clonedItem = (EMFTreeComposite) item.clone();
		assertEquals(0, clonedOrder.getNumberOfChildren());
		clonedOrder.setNextChild(clonedItem);
		assertEquals(1, clonedOrder.getNumberOfChildren());

		EMFTreeComposite anotherClonedItem = (EMFTreeComposite) item.clone();
		assertEquals(1, clonedOrder.getNumberOfChildren());
		clonedOrder.setNextChild(anotherClonedItem);
		assertEquals(2, clonedOrder.getNumberOfChildren());

		// Make sure if we change the entry on one, it doesn't
		// change the entry on the other clone
		assertTrue(((DataComponent) clonedItem.getActiveDataNode())
				.retrieveEntry("title").setValue("hello"));
		assertFalse("hello"
				.equals(((DataComponent) anotherClonedItem.getActiveDataNode())
						.retrieveEntry("title").getValue()));

		// Clone the ShipTo tree and add it to the ShipOrder
		EMFTreeComposite clonedShipTo = (EMFTreeComposite) shipTo.clone();
		assertEquals(2, clonedOrder.getNumberOfChildren());
		clonedOrder.setNextChild(clonedShipTo);
		assertEquals(3, clonedOrder.getNumberOfChildren());

		// Make sure we can't add more than one of these.
		EMFTreeComposite anotherClonedShipTo = (EMFTreeComposite) shipTo
				.clone();
		assertEquals(3, clonedOrder.getNumberOfChildren());
		clonedOrder.setNextChild(anotherClonedShipTo);
		assertEquals(3, clonedOrder.getNumberOfChildren());

		clonedOrder.removeChild(anotherClonedItem);
		assertEquals(2, clonedOrder.getNumberOfChildren());

		return;
	}

	/**
	 * Check that we can copy and clone EMFTreeComposites.
	 */
	@Test
	public void checkCopying() {
		EMFTreeComposite shipOrder = trees.get(2);
		System.out.println("NAME: " + shipOrder.getName());
		EMFTreeComposite clonedOrder = (EMFTreeComposite) shipOrder.clone();

		// Check the ShipOrder tree's DataComponent
		DataComponent data = (DataComponent) clonedOrder.getActiveDataNode();
		assertNotNull(data);
		assertEquals(2, data.retrieveAllEntries().size());
		assertTrue(data.contains("orderperson"));
		assertTrue(data.contains("orderid"));

		assertTrue(((DataComponent) shipOrder.getActiveDataNode())
				.retrieveEntry("orderperson").setValue("hello"));
		assertTrue(
				"hello".equals(((DataComponent) shipOrder.getActiveDataNode())
						.retrieveEntry("orderperson").getValue()));
		assertFalse(
				"hello".equals(((DataComponent) clonedOrder.getActiveDataNode())
						.retrieveEntry("orderperson").getValue()));

		assertTrue(((DataComponent) clonedOrder.getActiveDataNode())
				.retrieveEntry("orderperson").setValue("helloworld"));
		assertTrue("helloworld"
				.equals(((DataComponent) clonedOrder.getActiveDataNode())
						.retrieveEntry("orderperson").getValue()));
		assertFalse("helloworld"
				.equals(((DataComponent) shipOrder.getActiveDataNode())
						.retrieveEntry("orderperson").getValue()));

	}

}
