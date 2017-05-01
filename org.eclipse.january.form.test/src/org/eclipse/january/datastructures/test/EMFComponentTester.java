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
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBException;

import org.eclipse.january.form.BreadthFirstTreeCompositeIterator;
import org.eclipse.january.form.DataComponent;
import org.eclipse.january.form.JanuaryJAXBHandler;
import org.eclipse.january.form.TreeComposite;
import org.eclipse.january.form.emf.EMFComponent;
import org.eclipse.january.form.emf.EMFTreeComposite;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Alex McCaskey
 */
public class EMFComponentTester {
	/**
	 * 
	 */
	private EMFComponent emfComponent;

	/**
	 * 
	 */
	@Before
	public void before() {
		// Local Declarations
		String separator = System.getProperty("file.separator");
		String userDir = System.getProperty("user.home") + separator
				+ "JanuaryTests" + separator + "datastructuresData";
		String filePath = userDir + separator + "shiporder.xsd";

		// Create the DataComponent
		emfComponent = new EMFComponent(new File(filePath));
	}

	/**
	 */
	@Test
	public void checkCreation() {

		// Local declarations
		DataComponent component = null;
		int id = 20110901;
		String name = "September 1st 2011";
		String description = "The 1st day of the ninth month in the year of "
				+ "our Lord 2011";

		// Set the id, name and description
		emfComponent.setId(id);
		emfComponent.setDescription(description);
		emfComponent.setName(name);

		// Check the id, name and description
		assertEquals(emfComponent.getDescription(), description);
		assertEquals(emfComponent.getId(), id);
		assertEquals(emfComponent.getName(), name);

		// Get the RootNode, this should be the first child
		// of the actual TreeComposite root node, which is DocumentRoot
		TreeComposite emfTree = emfComponent.getEMFTreeComposite();
		assertNotNull(emfTree);

		// Check its tree structure
		assertTrue("DocumentRoot".equals(emfTree.getName()));
		assertEquals(0, emfTree.getNumberOfChildren());
		assertEquals(1, emfTree.getChildExemplars().size());

		return;

	}

	/**
	 * <p>
	 * </p>
	 */
	@Test
	public void checkTreeModification() {

		EMFTreeComposite docRoot = (EMFTreeComposite) emfComponent
				.getEMFTreeComposite();
		EMFTreeComposite shipOrder = (EMFTreeComposite) docRoot
				.getChildExemplars().get(0).clone();

		docRoot.setNextChild(shipOrder);
		assertEquals(1, docRoot.getNumberOfChildren());

		// Test that we can only add 1 shiporder
		docRoot.setNextChild(shipOrder);
		assertEquals(1, docRoot.getNumberOfChildren());

		assertEquals(1, shipOrder.getNumberOfDataNodes());
		DataComponent component = (DataComponent) shipOrder.getActiveDataNode();
		assertEquals("ShiporderType Data", component.getName());
		assertEquals(2, component.retrieveAllEntries().size());
		assertEquals("orderperson",
				component.retrieveAllEntries().get(0).getName());
		assertEquals("orderid",
				component.retrieveAllEntries().get(1).getName());
		assertTrue(component.retrieveEntry("orderperson").setValue("McCaskey"));
		assertTrue(component.retrieveEntry("orderid").setValue(""));

		// Check the first child of RootNode's tree structure
		EMFTreeComposite shipTo = (EMFTreeComposite) shipOrder
				.getChildExemplars().get(0).clone(); // HERE ITS NOT 1 Index BC
														// OUR CHILD EXEMPLAR
														// LIST IS DYNAMIC
		assertEquals(0, shipOrder.getNumberOfChildren());
		shipOrder.setNextChild(shipTo);
		assertEquals(1, shipOrder.getNumberOfChildren());
		assertEquals("ShiptoType", shipTo.getName());
		assertEquals(0, shipTo.getNumberOfChildren());
		assertEquals(1, shipTo.getNumberOfDataNodes());
		component = (DataComponent) shipTo.getActiveDataNode();
		assertEquals("ShiptoType Data", component.getName());
		assertEquals(4, component.retrieveAllEntries().size());
		assertTrue(component.retrieveEntry("name").setValue("name"));
		assertTrue(component.retrieveEntry("address")
				.setValue("1600 Pennsylvania Ave"));
		assertTrue(component.retrieveEntry("city").setValue("city"));
		assertTrue(component.retrieveEntry("country").setValue("country"));

		// Check the second child of RootNode's tree structure
		TreeComposite item = (EMFTreeComposite) shipOrder.getChildExemplars()
				.get(0).clone();
		shipOrder.setNextChild(item);
		assertEquals(2, shipOrder.getNumberOfChildren());
		assertEquals("ItemType", item.getName());
		assertEquals(0, item.getNumberOfChildren());
		assertEquals(1, item.getNumberOfDataNodes());
		component = (DataComponent) item.getActiveDataNode();
		assertEquals("ItemType Data", component.getName());
		assertEquals(4, component.retrieveAllEntries().size());
		assertTrue(component.retrieveEntry("title").setValue("POTUS"));
		assertTrue(component.retrieveEntry("note").setValue("NOTES"));
		assertTrue(component.retrieveEntry("quantity").setValue("1"));
		assertTrue(component.retrieveEntry("price").setValue("0.0"));

		EMFTreeComposite anotherItem = (EMFTreeComposite) shipOrder
				.getChildExemplars().get(0).clone();
		shipOrder.setNextChild(anotherItem);
		assertEquals(3, shipOrder.getNumberOfChildren());
		assertEquals("ItemType", anotherItem.getName());
		assertEquals(0, anotherItem.getNumberOfChildren());
		assertEquals(1, anotherItem.getNumberOfDataNodes());
		component = (DataComponent) anotherItem.getActiveDataNode();
		assertEquals("ItemType Data", component.getName());
		assertEquals(4, component.retrieveAllEntries().size());
		assertTrue(component.retrieveEntry("title").setValue("FLOTUS"));
		assertTrue(component.retrieveEntry("note").setValue("NOTES"));
		assertTrue(component.retrieveEntry("quantity").setValue("1"));
		assertTrue(component.retrieveEntry("price").setValue("0.0"));

		emfComponent.save();

	}

	/**
	 * <p>
	 * </p>
	 */
	@Test
	public void checkBatML() {
		// Local Declarations
		String separator = System.getProperty("file.separator");
		String userDir = System.getProperty("user.home") + separator
				+ "JanuaryTests" + separator + "datastructuresData";

		String filePath1 = userDir + separator + "electrical.xsd";
		String filePath2 = userDir + separator + "electrical.xml";
		ArrayList<String> treeNames = new ArrayList<String>();
		HashMap<String, Integer> verificationMap = new HashMap<String, Integer>();

		EMFComponent batmlEMFComponent = new EMFComponent(new File(filePath1));

		assertTrue(batmlEMFComponent.load(new File(filePath2)));

		EMFTreeComposite docRootTree = (EMFTreeComposite) batmlEMFComponent
				.getEMFTreeComposite();

		assertNotNull(docRootTree);
		assertNotNull(docRootTree.getChildAtIndex(0));
		assertTrue(docRootTree.getChildAtIndex(0).getChildAtIndex(0).getName()
				.equals("ModelDBType1"));

		EMFTreeComposite modelDB = (EMFTreeComposite) docRootTree
				.getChildAtIndex(0).getChildAtIndex(0).getChildAtIndex(0);

		for (TreeComposite t : modelDB.getChildExemplars()) {
			System.out.println("HELLO: " + t.getName());
		}

		BreadthFirstTreeCompositeIterator iter = new BreadthFirstTreeCompositeIterator(
				batmlEMFComponent.getEMFTreeComposite());

		while (iter.hasNext()) {
			EMFTreeComposite tree = (EMFTreeComposite) iter.next();
			String treeName = tree.getName();
			treeNames.add(treeName);
			System.out.println("TreeName: " + treeName);
			if (verificationMap.keySet().contains(treeName)) {
				int newValue = verificationMap.get(treeName) + 1;
				verificationMap.put(treeName, newValue);
			} else {
				verificationMap.put(treeName, 1);
			}
		}

		// Not sure how else to test this except that we have
		// the correct tree nodes.
		assertEquals((Integer) 141, verificationMap.get("AnySingleValueType"));
		assertEquals((Integer) 141, verificationMap.get("ParameterType"));
		assertEquals((Integer) 10, verificationMap.get("ParameterSetType"));
		assertEquals((Integer) 1, verificationMap.get("ParametersType"));
		assertEquals((Integer) 1, verificationMap.get("BatteryMLDocType"));
		assertEquals((Integer) 1, verificationMap.get("ModelDBType1"));
		assertEquals((Integer) 1, verificationMap.get("ModelDBType"));
		assertEquals((Integer) 1, verificationMap.get("DefinitionType"));
		assertEquals((Integer) 1, verificationMap.get("CategoryType"));

	}

	/**
	 * <p>
	 * </p>
	 */
	@Test
	public void checkSave() {

		// Local Declarations
		String separator = System.getProperty("file.separator");
		String userDir = System.getProperty("user.home") + separator
				+ "JanuaryTests" + separator + "datastructuresData";
		String filePath = userDir + separator + "shipOrderSave.xml";
		String expectedFilePath = userDir + separator
				+ "expectedShipOrderSave.xml";
		File saveFile = new File(filePath);

		// Modify the Tree to make things interesting
		// This mimics a user filling out the ICE Form Entries
		checkTreeModification();

		// Save the File, make sure it was successful
		assertTrue(emfComponent.save(saveFile));
		assertTrue(saveFile.exists());

		try {
			ArrayList<String> exptectedFileContents = (ArrayList<String>) Files
					.readAllLines(Paths.get(expectedFilePath),
							Charset.defaultCharset());
			ArrayList<String> actualFileContents = (ArrayList<String>) Files
					.readAllLines(Paths.get(filePath),
							Charset.defaultCharset());

			assertTrue(actualFileContents.equals(exptectedFileContents));
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}

	}

	/**
	 * <p>
	 * </p>
	 */
	@Test
	public void checkLoad() {
		String separator = System.getProperty("file.separator");
		String userDir = System.getProperty("user.home") + separator
				+ "JanuaryTests" + separator + "datastructuresData";
		String expectedFilePath = userDir + separator
				+ "expectedShipOrderSave.xml";
		File loadFile = new File(expectedFilePath);

		emfComponent.save();
		assertTrue(emfComponent.load(loadFile));
		emfComponent.save();

		// Get the RootNode, this should be the first child
		// of the actual TreeComposite root node, which is DocumentRoot
		EMFTreeComposite emfTree = (EMFTreeComposite) emfComponent
				.getEMFTreeComposite();
		assertNotNull(emfTree);
		assertEquals("DocumentRoot", emfTree.getName());
		assertEquals(1, emfTree.getNumberOfChildren());

		// Check its tree structure
		EMFTreeComposite shipOrder = (EMFTreeComposite) emfTree
				.getChildAtIndex(0);
		assertEquals(3, shipOrder.getNumberOfChildren());
		assertEquals("ShiporderType", shipOrder.getName());
		assertEquals(1, shipOrder.getNumberOfDataNodes());
		DataComponent component = (DataComponent) shipOrder.getActiveDataNode();
		assertEquals("ShiporderType Data", component.getName());
		assertEquals(2, component.retrieveAllEntries().size());

		assertEquals(3, shipOrder.getNumberOfChildren());

		int itemCount = 0;
		int shiptoCount = 0;

		for (int i = 0; i < 3; i++) {
			TreeComposite child = shipOrder.getChildAtIndex(i);
			assertNotNull(child);

			if ("ShiptoType".equals(child.getName())) {
				shiptoCount++;
				assertEquals(0, child.getNumberOfChildren());
				assertEquals(1, child.getNumberOfDataNodes());
				component = (DataComponent) child.getActiveDataNode();
				assertEquals("ShiptoType Data", component.getName());
				assertEquals(4, component.retrieveAllEntries().size());
			} else if ("ItemType".equals(child.getName())) {
				itemCount++;
				assertEquals(0, child.getNumberOfChildren());
				assertEquals(1, child.getNumberOfDataNodes());
				component = (DataComponent) child.getActiveDataNode();
				assertEquals("ItemType Data", component.getName());
				assertEquals(4, component.retrieveAllEntries().size());
			} else {
				fail();
			}
		}

		assertEquals(1, shiptoCount);
		assertEquals(2, itemCount);

		String xmlString = emfComponent.saveToString();
		assertNotNull(xmlString);
		assertEquals(2,
				xmlString.split(Pattern.quote("<item>"), -1).length - 1);

	}

	/**
	 * <p>
	 * This operation checks the DataComponent to insure that its equals() and
	 * hashcode() operations work.
	 * </p>
	 * 
	 */
	@Test
	public void checkEquality() {
		String separator = System.getProperty("file.separator");
		String userDir = System.getProperty("user.home") + separator
				+ "JanuaryTests" + separator + "datastructuresData";
		String filePath1 = userDir + separator + "shiporder.xsd";

		// Create DataComponents to test
		EMFComponent component = emfComponent;
		EMFComponent equalComponent = new EMFComponent(new File(filePath1));
		EMFComponent unEqualComponent = new EMFComponent();
		EMFComponent transitiveComponent = new EMFComponent(
				new File(filePath1));

		// Set JanuaryObject data
		component.setId(1);
		equalComponent.setId(1);
		transitiveComponent.setId(1);
		unEqualComponent.setId(2);

		component.setName("EMF Equal");
		equalComponent.setName("EMF Equal");
		transitiveComponent.setName("EMF Equal");
		unEqualComponent.setName("EMF UnEqual");

		// Assert equals() is reflexive
		assertTrue(component.equals(component));

		// Assert two equal DataComponents return true
		assertTrue(component.equals(equalComponent));

		// Assert two unequal DataComponents return false
		assertFalse(component.equals(unEqualComponent));

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

	/**
	 * <p>
	 * This operation checks the EMFComponent to ensure that its copy() and
	 * clone() operations work as specified.
	 * </p>
	 * 
	 */
	@Test
	public void checkCopying() {

		EMFComponent comp = (EMFComponent) emfComponent.clone();
		assertTrue(comp.equals(emfComponent));

		EMFComponent newCopy = new EMFComponent();
		newCopy.copy(emfComponent);
		assertTrue(newCopy.equals(emfComponent));

		return;
	}

	/**
	 * <p>
	 * This operation checks the ability of the EMFComponent to persist itself
	 * to XML and to load itself from an XML input stream.
	 * </p>
	 * 
	 * @throws IOException
	 * @throws JAXBException
	 * @throws NullPointerException
	 * 
	 */
	@Test
	public void checkLoadingFromXML()
			throws NullPointerException, JAXBException, IOException {
		// Local declarations
		int id = 5;
		String name = "Bob";
		String description = "I am Bob! 1.0";
		JanuaryJAXBHandler xmlHandler = new JanuaryJAXBHandler();
		ArrayList<Class> classList = new ArrayList<Class>();
		classList.add(EMFComponent.class);

		emfComponent = new EMFComponent();

		// set JanuaryObject info
		emfComponent.setId(id);
		emfComponent.setName(name);
		emfComponent.setDescription(description);

		// Load it into XML
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		xmlHandler.write(emfComponent, classList, outputStream);

		assertNotNull(outputStream);
		String xmlFile2 = new String(outputStream.toByteArray());

		// convert information inside of outputStream to inputStream
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				outputStream.toByteArray());

		// load contents into xml
		EMFComponent loadEMF = new EMFComponent();
		loadEMF = (EMFComponent) xmlHandler.read(classList, inputStream);

		// Check contents -- Why was this commented out? ~JJB 20141223 16:57
		assertTrue(loadEMF.equals(emfComponent));

	}
}
