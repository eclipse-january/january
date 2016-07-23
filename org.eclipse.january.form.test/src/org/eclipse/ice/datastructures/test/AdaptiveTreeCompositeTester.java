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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.eclipse.january.form.AdaptiveTreeComposite;
import org.eclipse.january.form.ICEJAXBHandler;
import org.eclipse.january.form.IUpdateable;
import org.eclipse.january.form.SelectiveComponentVisitor;
import org.eclipse.january.form.TreeComposite;
import org.junit.Test;

/**
 * This class is responsible for testing the methods of AdaptiveTreeComposite.
 * 
 * @author Anna Wojtowicz
 */
public class AdaptiveTreeCompositeTester {

	/**
	 * Boolean flag to mark if the AdaptiveTreeComposite was successfully
	 * visited.
	 */
	private boolean wasVisited = false;

	/**
	 * This method is responsible for testing the construction of the
	 * AdaptiveTreeComposite class. Also inadvertently tests the TreeMap getter
	 * getTypes().
	 */
	@Test
	public void checkConstruction() {

		// Local declarations
		// TreeComposite currentTree = null;

		// Create a new AdaptiveTreeComposite for testing with valid input
		AdaptiveTreeComposite tester = new AdaptiveTreeComposite(
				createInputTrees());

		// Check the name, description and ID
		assertEquals("Adaptive Tree Composite 1", tester.getName());
		assertEquals("A TreeComposite object that can toggle its type",
				tester.getDescription());
		assertEquals(1, tester.getId());

		// Get the TreeMap, check that it's valid
		ArrayList<String> types = tester.getTypes();
		assertNotNull(types);
		assertEquals(4, types.size());

		// Check the first TreeComposite
		assertTrue(types.contains("Poutine"));

		// Check the second TreeComposite
		assertTrue(types.contains("Loonie"));

		// Check the third TreeComposite
		assertTrue(types.contains("Lumberjack"));

		// Check the fourth TreeComposite
		assertTrue(types.contains("Universal Health Care"));

		// Now try to construct with invalid parameters
		tester = new AdaptiveTreeComposite(null);
		types = tester.getTypes();
		assertNull(types);

		tester = new AdaptiveTreeComposite(new ArrayList<TreeComposite>());
		types = tester.getTypes();
		assertNull(types);

		return;
	}

	/**
	 * This method is responsible for checking the getter and setter for the
	 * AdaptiveTreeComposite type.
	 */
	@Test
	public void checkGetSetType() {

		// Local declarations
		String currentType;

		// Create a new AdaptiveTreeComposite for testing
		AdaptiveTreeComposite tester = new AdaptiveTreeComposite(
				createInputTrees());
		// Set the adaptive tree as active
		tester.setActive(true);

		// Try to set the type with a valid value
		assertTrue(tester.setType("Lumberjack"));

		// Make sure that the tree is still active
		assertTrue(tester.isActive());

		// Try getting the type now, check that it's correct
		currentType = tester.getType();
		assertNotNull(currentType);
		assertEquals("Lumberjack", currentType);
		assertEquals("Adaptive Tree Composite 1", tester.getName());
		assertEquals("A noble profession; a connoisseur of all things manly",
				tester.getDescription());

		// Try to set the type with an invalid value
		assertFalse(tester.setType("Bear Cavalry"));

		// Verify the type is still Lumberjack
		currentType = tester.getType();
		assertNotNull(currentType);
		assertEquals("Lumberjack", currentType);
		assertEquals("Adaptive Tree Composite 1", tester.getName());
		assertEquals("A noble profession; a connoisseur of all things manly",
				tester.getDescription());

		// Try to set the type with null
		assertFalse(tester.setType(null));

		// Verify the type is still Lumberjack
		currentType = tester.getType();
		assertNotNull(currentType);
		assertEquals("Lumberjack", currentType);
		assertEquals("Adaptive Tree Composite 1", tester.getName());
		assertEquals("A noble profession; a connoisseur of all things manly",
				tester.getDescription());

		return;
	}

	/**
	 * This method checks the AdaptiveTreeComposite's copy and clone utilities.
	 */
	@Test
	public void checkCopying() {

		// Create some AdaptiveTreeComposites for copying
		AdaptiveTreeComposite tester = new AdaptiveTreeComposite(
				createInputTrees());
		AdaptiveTreeComposite testerCopy = new AdaptiveTreeComposite(null);

		// Verify the AdaptiveTreeComposites are not equal first
		assertFalse(tester == testerCopy);
		assertFalse(tester.equals(testerCopy));

		// Copy the AdaptiveTreeComposite
		testerCopy.copy(tester);

		// Verify their contents are equal (but not references)
		assertFalse(tester == testerCopy);
		assertTrue(tester.equals(testerCopy));

		// Try copying something invalid
		testerCopy.copy(null);

		// Verify nothing happened
		assertNotNull(testerCopy);
		assertTrue(tester.equals(testerCopy));

		// Now try cloning the tester
		AdaptiveTreeComposite testerClone = tester.clone();

		// Verify their contents are equal (but not references)
		assertFalse(tester == testerClone);
		assertTrue(tester.equals(testerClone));

		return;
	}

	/**
	 * This method checks the AdaptiveTreeComposites equality utility.
	 */
	@Test
	public void checkEquality() {

		// Create some equal AdaptiveTreeComposites
		AdaptiveTreeComposite tree = new AdaptiveTreeComposite(
				createInputTrees());
		AdaptiveTreeComposite equalTree = new AdaptiveTreeComposite(
				createInputTrees());

		// Set their types
		tree.setType("Poutine");
		equalTree.setType("Poutine");

		// Verify the trees are equal (but not references)
		assertTrue(tree.equals(equalTree));
		assertTrue(equalTree.equals(tree));
		assertFalse(tree == equalTree);

		// Change the type of one, verify they're no longer equal
		tree.setType("Loonie");
		assertFalse(tree.equals(equalTree));
		assertFalse(tree == equalTree);

		// Create another AdaptiveTreeComposite, not equal to the first two
		AdaptiveTreeComposite unequalTree;
		ArrayList<TreeComposite> unequalList = new ArrayList<TreeComposite>();
		TreeComposite treeOne = new TreeComposite();
		treeOne.setName("Bagged milk");
		unequalList.add(treeOne);
		TreeComposite treeTwo = new TreeComposite();
		treeTwo.setName("Maple syrup");
		unequalList.add(treeTwo);
		unequalTree = new AdaptiveTreeComposite(unequalList);

		// Verify they're not equal
		assertFalse(tree.equals(unequalTree));
		assertFalse(unequalTree.equals(tree));
		assertFalse(tree == unequalTree);

		return;
	}

	/**
	 * This method ensures that new and overridden methods send notifications.
	 */
	@Test
	public void checkNotifications() {

		// Create an AdaptiveTreeComposite to update.
		final AdaptiveTreeComposite tree = new AdaptiveTreeComposite(
				createInputTrees());
		tree.setName("He's a lumberjack and he's okay...");
		tree.setDescription("He works all night, he sleeps all day!");

		// Create a listener. We only want to deal with updates directly from
		// the tree, not from its children.
		TestComponentListener listener = new TestComponentListener() {
			public void update(IUpdateable component) {
				if (component == tree) {
					super.update(component);
				}
			}
		};
		tree.register(listener);

		// Set its type and the listener should be notified.
		tree.setType("Lumberjack");
		assertTrue(listener.wasNotified());
		listener.reset();

		tree.setType("Lumberjack");
		assertFalse(listener.wasNotified());

		// Setting another new value should notify.
		tree.setType("Loonie");
		assertTrue(listener.wasNotified());
		listener.reset();

		return;
	}

	/**
	 * This method checks the visitation routine.
	 */
	public void checkVisitation() {

		// Create a new AdaptiveTreeComposite to visit
		AdaptiveTreeComposite tree = new AdaptiveTreeComposite(
				createInputTrees());

		// Create an invalid visitor, and try to visit the tree
		FakeTreeVisitor visitor = null;
		tree.accept(visitor);

		// Check that the tree wasn't visited yet
		assertFalse(wasVisited);

		// Create a valid visitor, and try to visit the tree
		visitor = new FakeTreeVisitor();
		tree.accept(visitor);

		// Check that the tree was visited
		assertTrue(wasVisited);

		// Grab the visitor's visited tree
		AdaptiveTreeComposite visitorTree = visitor.tree;

		// Check that the visitor's tree is the same component we initially
		// created (references should match too)
		assertTrue(tree == visitorTree);
		assertTrue(tree.equals(visitorTree));

		return;
	}
	
	/**
	 * This method checks the XML unmarshaling routine.
	 * @throws IOException 
	 * @throws JAXBException 
	 * @throws NullPointerException 
	 */
	@Test
	public void checkLoadingFromXML() throws NullPointerException, JAXBException, IOException {
		
		// Local Declarations
		AdaptiveTreeComposite tree, loadedTree;
		ArrayList<TreeComposite> typesList;
		ByteArrayOutputStream outputStream;
		ByteArrayInputStream inputStream;
		ICEJAXBHandler xmlHandler = new ICEJAXBHandler();
		ArrayList<Class> classList = new ArrayList<Class>();
		classList.add(AdaptiveTreeComposite.class);
		
		// Construct the types list to pass into the constructor
		typesList = createInputTrees();

		// Instantiate the AdaptiveTreeComposite
		tree = new AdaptiveTreeComposite(typesList);
		
		// Set the type
		tree.setType("Loonie");

		// Persist to the OutputStream
		outputStream = new ByteArrayOutputStream();
		xmlHandler.write(tree, classList, outputStream);

		// Convert the data into an InputStream now
		inputStream = new ByteArrayInputStream(outputStream.toByteArray());

		// Try to load from the InputStream
		loadedTree = new AdaptiveTreeComposite(null);
		loadedTree = (AdaptiveTreeComposite) xmlHandler.read(classList, inputStream);

		// Compare the original tree to the one we unmarshalled
		assertTrue(tree.equals(loadedTree));
		
		return;
		
	}

	/**
	 * This method is responsible for creating a dummy ArrayList of
	 * TreeComposites to be taken as input for the AdaptiveTreeComposite
	 * constructor. This is only used for testing purposes.
	 * 
	 * @return An ArrayList of "fake" TreeComposites for testing purposes.
	 */
	private ArrayList<TreeComposite> createInputTrees() {

		// Create an ArrayList
		ArrayList<TreeComposite> treeList = new ArrayList<TreeComposite>();

		// Create some dummy TreeComposites and add them to the list
		TreeComposite treeOne = new TreeComposite();
		treeOne.setName("Poutine");
		treeOne.setDescription("A delicious artery-clogging delight");
		treeList.add(treeOne);

		TreeComposite treeTwo = new TreeComposite();
		treeTwo.setName("Loonie");
		treeTwo.setDescription("A sensible alternative to $1 bills");
		treeList.add(treeTwo);

		TreeComposite treeThree = new TreeComposite();
		treeThree.setName("Lumberjack");
		treeThree
				.setDescription("A noble profession; a connoisseur of all things manly");
		treeList.add(treeThree);

		TreeComposite treeFour = new TreeComposite();
		treeFour.setName("Universal Health Care");
		treeFour.setDescription("don't be jelly, brah");
		treeList.add(treeFour);

		return treeList;
	}

	/**
	 * Fake class to test the visitation routine of the AdaptiveTreeComposite.
	 */
	private class FakeTreeVisitor extends SelectiveComponentVisitor {

		// The fake visitor's visited component.
		private AdaptiveTreeComposite tree = null;

		@Override
		public void visit(AdaptiveTreeComposite tree) {

			// Set the IComponentVisitor component (if valid), and flag the
			// component as having been visited.
			if (tree != null) {
				this.tree = tree;
				wasVisited = true;
			}
			return;
		}
	};
}
