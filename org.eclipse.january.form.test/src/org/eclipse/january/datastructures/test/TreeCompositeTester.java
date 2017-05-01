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
import java.util.HashMap;
import java.util.Random;

import javax.xml.bind.JAXBException;

import org.eclipse.january.form.Component;
import org.eclipse.january.form.DataComponent;
import org.eclipse.january.form.JanuaryJAXBClassProvider;
import org.eclipse.january.form.JanuaryJAXBHandler;
import org.eclipse.january.form.IComponentVisitor;
import org.eclipse.january.form.SelectiveComponentVisitor;
import org.eclipse.january.form.StringEntry;
import org.eclipse.january.form.TableComponent;
import org.eclipse.january.form.TreeComposite;
import org.junit.Ignore;
import org.junit.Test;

/**
 * <p>
 * This class is responsible for testing the TreeComposite. The test generates
 * random numbers of children and siblings since the TreeComposite is an n-ary
 * tree. It does not have specific tests for re-wiring and visitation because
 * those must be done extensively in the other tests since it is a tree.
 * </p>
 * 
 * @author Jay Jay Billings
 */
public class TreeCompositeTester extends SelectiveComponentVisitor {
	/**
	 * 
	 */
	private TreeComposite treeComposite;

	/**
	 * A map for the components that are created in the test. Keys: {tree, data,
	 * table}
	 */
	private HashMap<String, ArrayList<Component>> componentMap = new HashMap<String, ArrayList<Component>>();

	/**
	 * <p>
	 * This operation checks the construction of the TreeComposite and whether
	 * or not its name, id and description can be set properly.
	 * </p>
	 * 
	 */
	@Test
	public void checkConstruction() {

		// Local Declarations
		String name = "Tuvok", desc = "Vulcan";
		int id = 3;

		// Setup the TreeComposite
		treeComposite = new TreeComposite();
		treeComposite.setId(id);
		treeComposite.setName(name);
		treeComposite.setDescription(desc);
		treeComposite.setActive(true);

		// Check the details
		assertEquals(name, treeComposite.getName());
		assertEquals(desc, treeComposite.getDescription());
		assertEquals(id, treeComposite.getId());
		assertEquals(true, treeComposite.isActive());

		// Check switching the active mode back
		treeComposite.setActive(false);
		assertEquals(false, treeComposite.isActive());

		return;
	}

	/**
	 * <p>
	 * This operation checks the ability of the TreeComposite to manage a set of
	 * subordinate, child TreeComposites.
	 * </p>
	 * 
	 */
	@Test
	public void checkChildren() {

		// Local Declarations
		long seed = System.nanoTime();
		Random rng = new Random(seed);
		int numChildren = 4 + rng.nextInt(10); // Test many kids, at least 3!
		TreeComposite currentChild = null;
		String name = "Tribble", desc = "Furball";

		// Write out how many children are being created for debug purposes
		System.out
				.println("TreeCompositeTester Message: Testing children with "
						+ numChildren + " children.");

		// Setup the parent tree composite
		treeComposite = new TreeComposite();

		// Create and add a few children
		for (int i = 0; i < numChildren; i++) {
			// Setup the child
			currentChild = new TreeComposite();
			currentChild.setId(i);
			currentChild.setName(name + " " + i);
			currentChild.setDescription(desc + " " + i);
			// Add it to the parent
			treeComposite.setNextChild(currentChild);
		}

		// Check the children individually by index. Make sure the tree has the
		// right number of children in it first.
		assertEquals(numChildren, treeComposite.getNumberOfChildren());
		for (int i = 0; i < treeComposite.getNumberOfChildren(); i++) {
			currentChild = treeComposite.getChildAtIndex(i);
			assertEquals(i, currentChild.getId());
			assertEquals(name + " " + i, currentChild.getName());
			assertEquals(desc + " " + i, currentChild.getDescription());
		}

		// Check forward iteration. Don't reset the iterator because the tree
		// should start at zero by default. Initialize a counter for id.
		int j = 0;
		while ((currentChild = treeComposite.getNextChild()) != null) {
			assertEquals(j, currentChild.getId());
			assertEquals(name + " " + j, currentChild.getName());
			assertEquals(desc + " " + j, currentChild.getDescription());
			j++;
		}
		// Make sure further iteration attempts return null.
		assertNull(treeComposite.getNextChild());

		// Check backward iteration. Don't reset the iterator because the tree
		// should be at the end.
		j--;
		while ((currentChild = treeComposite.getPreviousChild()) != null) {
			assertEquals(j, currentChild.getId());
			assertEquals(name + " " + j, currentChild.getName());
			assertEquals(desc + " " + j, currentChild.getDescription());
			j--;
		}
		// Make sure further iteration attempts return null.
		assertNull(treeComposite.getPreviousChild());

		// Check the first two numChildren/2 kids (rounding down) and then reset
		// the iterator. The tree should already be at the beginning after the
		// last set of checks. Using numChildren instead of
		// getNumberOfChildren() to make sure that nothing was removed
		// erroneously.
		j = 0;
		while (j < numChildren / 2) {
			currentChild = treeComposite.getNextChild();
			assertEquals(j, currentChild.getId());
			assertEquals(name + " " + j, currentChild.getName());
			assertEquals(desc + " " + j, currentChild.getDescription());
			j++;
		}
		// Go back to the beginning
		treeComposite.resetChildIterator();
		// The next child should be the first
		currentChild = treeComposite.getNextChild();
		assertEquals(0, currentChild.getId());
		assertEquals(name + " " + 0, currentChild.getName());
		assertEquals(desc + " " + 0, currentChild.getDescription());

		// Set the iterator for the next test before removing the child.
		// Iterates up one position to index i = 2.
		treeComposite.resetChildIterator();
		currentChild = treeComposite.getNextChild();
		treeComposite.getNextChild();
		treeComposite.getNextChild();
		// Remove a child at index 1
		currentChild = treeComposite.getChildAtIndex(1);
		treeComposite.removeChild(currentChild);
		// Make sure the child was removed
		TreeComposite retChild = treeComposite.getChildAtIndex(1);
		assertTrue(currentChild.getId() != retChild.getId());

		// Try removing null. This will just throw an exception if it doesn't
		// work - no assertions required.
		treeComposite.removeChild(null);

		// Iterate up two children
		currentChild = treeComposite.getNextChild();
		// Make sure the child iterated just fine. It should have id 3.
		assertEquals(3, currentChild.getId());
		assertEquals(name + " " + 3, currentChild.getName());
		assertEquals(desc + " " + 3, currentChild.getDescription());

		// Check getting at child with getComponent()
		currentChild = null;
		currentChild = (TreeComposite) treeComposite.getComponent(3);
		assertNotNull(currentChild);
		assertEquals(3, currentChild.getId());
		assertEquals(name + " " + 3, currentChild.getName());
		assertEquals(desc + " " + 3, currentChild.getDescription());

		// Try adding a child that is already in the tree. It shouldn't change
		// the list.
		int currentNumChildren = treeComposite.getNumberOfChildren();
		treeComposite.setNextChild(currentChild);
		assertEquals(currentNumChildren, treeComposite.getNumberOfChildren());

		// Try adding the tree composite to itself. This too shouldn't change
		// the list.
		currentNumChildren = treeComposite.getNumberOfChildren();
		treeComposite.setNextChild(treeComposite);
		assertEquals(currentNumChildren, treeComposite.getNumberOfChildren());

		return;

	}

	/**
	 * <p>
	 * This operation checks the ability of the TreeComposite to identify its
	 * nearest neighbors (sibling) TreeComposites.
	 * </p>
	 * 
	 */
	@Test
	public void checkSiblings() {

		// Local Declarations
		long seed = System.nanoTime();
		Random rng = new Random(seed);
		int numChildren = 3 + rng.nextInt(10); // Test many kids, at least 3!
		TreeComposite currentChild = null, currentSibling = null;
		String name = "Holodeck", desc = "Recreational Facility";

		// Write out how many children are being created for debug purposes
		System.out
				.println("TreeCompositeTester Message: Testing siblings with "
						+ numChildren + " children.");

		// Create the tree
		treeComposite = new TreeComposite();

		// Create and add a few children
		for (int i = 0; i < numChildren; i++) {
			// Setup the child
			currentChild = new TreeComposite();
			currentChild.setId(i);
			currentChild.setName(name + " " + i);
			currentChild.setDescription(desc + " " + i);
			// Add it to the parent
			treeComposite.setNextChild(currentChild);
		}

		// Get the first child and check it
		currentChild = treeComposite.getNextChild();
		// It should not have a previous sibling
		assertNull(currentChild.getPreviousSibling());
		// Its next sibling should have id 1 and the appropriate name and
		// description
		currentSibling = currentChild.getNextSibling();
		assertEquals(1, currentSibling.getId());
		assertEquals(name + " " + 1, currentSibling.getName());
		assertEquals(desc + " " + 1, currentSibling.getDescription());

		// Check all of the remaining children except for the final one. Start
		// by getting the next sibling and create a marker.
		for (int i = 1; i < treeComposite.getNumberOfChildren() - 1; i++) {
			// Get the first child
			currentChild = treeComposite.getChildAtIndex(i);
			// Its previous sibling should have id i-1 and the appropriate name
			// and description
			currentSibling = currentChild.getPreviousSibling();
			assertEquals(i - 1, currentSibling.getId());
			assertEquals(name + " " + (i - 1), currentSibling.getName());
			assertEquals(desc + " " + (i - 1), currentSibling.getDescription());
			// Its next sibling should have id i+1 and the appropriate name and
			// description
			currentSibling = currentChild.getNextSibling();
			assertEquals(i + 1, currentSibling.getId());
			assertEquals(name + " " + (i + 1), currentSibling.getName());
			assertEquals(desc + " " + (i + 1), currentSibling.getDescription());
		}

		// Get the last child and check it
		currentChild = treeComposite.getChildAtIndex(numChildren - 1);
		// It should not have a next sibling
		assertNull(currentChild.getNextSibling());
		// Its previous sibling should have id numChildren-2 and the appropriate
		// name and description
		currentSibling = currentChild.getPreviousSibling();
		assertEquals(numChildren - 2, currentSibling.getId());
		assertEquals(name + " " + (numChildren - 2), currentSibling.getName());
		assertEquals(desc + " " + (numChildren - 2),
				currentSibling.getDescription());

		// Remove the second child
		treeComposite.removeChild(treeComposite.getChildAtIndex(1));
		// Get the first child and make sure that its next sibling is the third
		// component
		currentChild = treeComposite.getChildAtIndex(0);
		currentSibling = currentChild.getNextSibling();
		assertEquals(2, currentSibling.getId());
		assertEquals(name + " " + 2, currentSibling.getName());
		assertEquals(desc + " " + 2, currentSibling.getDescription());
		// Get the third child and make sure that its previous sibling is the
		// first component
		currentChild = treeComposite.getChildAtIndex(1);
		currentSibling = currentChild.getPreviousSibling();
		assertEquals(0, currentSibling.getId());
		assertEquals(name + " " + 0, currentSibling.getName());
		assertEquals(desc + " " + 0, currentSibling.getDescription());

	}

	/**
	 * <p>
	 * This operation checks the TreeComposite to make sure that parent
	 * TreeComposites can be identified and that the tree can be walked
	 * "to the top."
	 * </p>
	 * 
	 */
	@Test
	public void checkParent() {

		// Local Declarations
		TreeComposite firstChild = null, secondChild = null, parent = null;
		TreeComposite thirdChild = null, fourthChild = null, currentChild = null;
		String name = "Shuttlecraft", desc = "Small transport shuttle";

		// Create the root tree composite
		treeComposite = new TreeComposite();
		treeComposite.setId(0);
		treeComposite.setName(name + " " + 0);
		treeComposite.setDescription(desc + " " + 0);

		// Create four children
		firstChild = new TreeComposite();
		secondChild = new TreeComposite();
		thirdChild = new TreeComposite();
		fourthChild = new TreeComposite();

		// Setup the details of the children
		firstChild.setId(1);
		firstChild.setName(name + " " + 1);
		firstChild.setDescription(desc + " " + 1);
		secondChild.setId(2);
		secondChild.setName(name + " " + 2);
		secondChild.setDescription(desc + " " + 2);
		thirdChild.setId(3);
		thirdChild.setName(name + " " + 3);
		thirdChild.setDescription(desc + " " + 3);
		fourthChild.setId(4);
		fourthChild.setName(name + " " + 4);
		fourthChild.setDescription(desc + " " + 4);

		// Add all of the children
		treeComposite.setNextChild(firstChild);
		treeComposite.setNextChild(secondChild);
		treeComposite.setNextChild(thirdChild);
		treeComposite.setNextChild(fourthChild);

		// Make sure all of the children have the treeComposite as their parent
		for (int i = 0; i < 4; i++) {
			assertEquals(0, treeComposite.getChildAtIndex(i).getParent()
					.getId());
		}

		// Tell the second child to set its parent to the first child. This
		// should cause it to change its sibling references too.
		secondChild.setParent(firstChild);

		// Make sure that it doesn't have any siblings now.
		assertNull(secondChild.getPreviousSibling());
		assertNull(secondChild.getNextSibling());

		// Make sure the next sibling of the firstChild tree is now the
		// thirdChild tree. The checks the re-linking.
		currentChild = firstChild.getNextSibling();
		assertEquals(thirdChild.getId(), currentChild.getId());
		assertEquals(thirdChild.getName(), currentChild.getName());
		assertEquals(thirdChild.getDescription(), currentChild.getDescription());

		// Make sure the previous sibling of the thirdChild tree is now the
		// firstChild tree. The checks the re-linking.
		currentChild = thirdChild.getPreviousSibling();
		assertEquals(firstChild.getId(), currentChild.getId());
		assertEquals(firstChild.getName(), currentChild.getName());
		assertEquals(firstChild.getDescription(), currentChild.getDescription());

		// Move the fourth child the same way.
		fourthChild.setParent(firstChild);

		// Make sure this child has a link to the secondChild tree, which is the
		// first child at this level, but none others.
		assertNull(fourthChild.getNextSibling());
		currentChild = fourthChild.getPreviousSibling();
		assertEquals(secondChild.getId(), currentChild.getId());
		assertEquals(secondChild.getName(), currentChild.getName());
		assertEquals(secondChild.getDescription(),
				currentChild.getDescription());

		// Make sure the thirdChild no longer has a next sibling reference
		assertNull(thirdChild.getNextSibling());

		// Walk up the tree, parent by parent. Check the parent of the fourth
		// child first. It should be the firstChild tree.
		parent = fourthChild.getParent();
		assertEquals(firstChild.getId(), parent.getId());
		assertEquals(firstChild.getName(), parent.getName());
		assertEquals(firstChild.getDescription(), parent.getDescription());
		// Check the parent of the secondChild tree. It should be the firstChild
		// tree too. Null out the parent tree first to do a thorough check.
		parent = null;
		parent = secondChild.getParent();
		assertEquals(firstChild.getId(), parent.getId());
		assertEquals(firstChild.getName(), parent.getName());
		assertEquals(firstChild.getDescription(), parent.getDescription());
		// Get the parent of the firstChild and check it. Get the reference via
		// parent.getParent() so that we will have walked all the way up the
		// tree programmatically. It should be the treeComposite.
		parent = parent.getParent();
		assertEquals(treeComposite.getId(), parent.getId());
		assertEquals(treeComposite.getName(), parent.getName());
		assertEquals(treeComposite.getDescription(), parent.getDescription());
		// Get the parent of the thirdChild and check it. It should be the
		// treeComposite.
		parent = null;
		parent = thirdChild.getParent();
		assertEquals(treeComposite.getId(), parent.getId());
		assertEquals(treeComposite.getName(), parent.getName());
		assertEquals(treeComposite.getDescription(), parent.getDescription());

		return;

	}

	/**
	 * <p>
	 * This operation checks the ability of a TreeComposite to manage its data
	 * nodes. It also checks active data node support.
	 * </p>
	 * 
	 */
	@Test
	public void checkDataNodes() {

		// Local Declarations
		TreeComposite firstChild = null, secondChild = null;
		TreeComposite thirdChild = null, fourthChild = null;
		String name = "Phaser", desc = "Firearm";
		DataComponent dataComp = null, retDataComp = null;
		TableComponent tableComp = null;

		// Create the TreeComponents
		treeComposite = new TreeComposite();
		firstChild = new TreeComposite();
		firstChild.setId(1);
		secondChild = new TreeComposite();
		secondChild.setId(2);
		thirdChild = new TreeComposite();
		thirdChild.setId(3);
		fourthChild = new TreeComposite();
		fourthChild.setId(4);

		// Add a couple of children for the test to make sure getComponents()
		// returns everything.
		treeComposite.setNextChild(firstChild);
		treeComposite.setNextChild(secondChild);

		// Create some components and add them to the TreeComposite
		dataComp = new DataComponent();
		dataComp.setDescription(desc + " " + 0);
		dataComp.setId(5);
		dataComp.setName(name + " " + 0);
		treeComposite.addComponent(dataComp);
		tableComp = new TableComponent();
		tableComp.setDescription(desc + " " + 1);
		tableComp.setId(6);
		tableComp.setName(name + " " + 1);
		treeComposite.addComponent(tableComp);

		// Add the third and fourth trees
		treeComposite.addComponent(thirdChild);
		treeComposite.addComponent(fourthChild);

		// Remove a tree before the next test to make sure removeComponent()
		// works for trees.
		treeComposite.removeComponent(4);

		// Get the components from the tree and visit them
		for (Component comp : treeComposite.getComponents()) {
			comp.accept(this);
		}
		// Check out getComponent()
		retDataComp = (DataComponent) treeComposite.getComponent(5);
		// Make sure it is the right data component
		assertEquals(dataComp, retDataComp);

		// Check the number of components
		assertEquals(5, treeComposite.getNumberOfComponents());
		// Check the map for data components. There should be only one.
		assertEquals(1, componentMap.get("data").size());
		// Now table components. There should also be only one.
		assertEquals(1, componentMap.get("table").size());
		// Finally the tree, of which there should be three, two added by
		// setNextChild() and only one added.
		assertEquals(3, componentMap.get("tree").size());

		// Check data nodes convenience operations. Make sure it returns two
		// total data components, one for the data component and one for the
		// table component.
		assertEquals(2, treeComposite.getDataNodes().size());
		assertEquals(2, treeComposite.getNumberOfDataNodes());

		// Clear the map of data and table components
		componentMap.get("data").clear();
		componentMap.get("table").clear();

		// Remove the table component before the next test to make sure
		// removeComponent() works for Components.
		treeComposite.removeComponent(6);

		// Now visit the data nodes and make sure they get mapped correctly, but
		// use the getDataNodes() operation.
		for (Component comp : treeComposite.getDataNodes()) {
			comp.accept(this);
		}
		// Check the map for data components. There should be only one.
		assertEquals(1, componentMap.get("data").size());
		// Now table components. There should not be any.
		assertEquals(0, componentMap.get("table").size());

		// Check setting the active data node
		treeComposite.setActiveDataNode(dataComp);
		assertEquals(dataComp, treeComposite.getActiveDataNode());
		treeComposite.addComponent(tableComp);
		treeComposite.setActiveDataNode(tableComp);
		assertEquals(tableComp, treeComposite.getActiveDataNode());

		// Check disabling the active node support. Getting the active data node
		// should return null.
		treeComposite.allowActiveDataNodes(false);
		assertNull(treeComposite.getActiveDataNode());

		// Check re-enabling the active node support
		treeComposite.allowActiveDataNodes(true);
		assertEquals(tableComp, treeComposite.getActiveDataNode());

		return;

	}

	/**
	 * <p>
	 * This operation checks the ability of the TreeComposite to process
	 * updates. At the moment, it should do absolutely nothing (so nothing
	 * should change).
	 * </p>
	 * 
	 */
	@Ignore("TreeComposites do not yet perform updates. This test is a stub.")
	@Test
	public void checkUpdate() {

		fail();

	}

	/**
	 * <p>
	 * This operation tests the TreeComposite to insure that it can properly
	 * dispatch notifications when it receives an update that changes its state.
	 * </p>
	 * 
	 */
	@Test
	public void checkNotifications() {

		// Setup the listener
		TestComponentListener testComponentListener = new TestComponentListener();

		// Setup the treeComposite
		treeComposite = new TreeComposite();

		// Register the listener
		treeComposite.register(testComponentListener);

		// Create a new Entry in the treeComposite
		DataComponent dataComp = new DataComponent();
		dataComp.setId(1);
		treeComposite.addComponent(new DataComponent());
		// Check the Listener
		assertTrue(testComponentListener.wasNotified());
		// Reset the listener
		testComponentListener.reset();

		// Set the active data node
		treeComposite.setActiveDataNode(dataComp);
		// Check the Listener
		assertTrue(testComponentListener.wasNotified());
		// Reset the listener
		testComponentListener.reset();

		// Disable active data node support
		treeComposite.allowActiveDataNodes(false);
		// Check the Listener
		assertTrue(testComponentListener.wasNotified());
		// Reset the listener
		testComponentListener.reset();
		// Enable active data node support
		treeComposite.allowActiveDataNodes(false);
		// Check the Listener
		assertTrue(testComponentListener.wasNotified());
		// Reset the listener
		testComponentListener.reset();

		// Remove the DataComponent
		treeComposite.removeComponent(1);
		// Check the listener to make sure it was updated
		assertTrue(testComponentListener.wasNotified());
		// Reset the listener
		testComponentListener.reset();

		// Add a child to the composite
		TreeComposite child = new TreeComposite();
		child.setId(2);
		treeComposite.setNextChild(child);
		// Check the listener to make sure it was updated
		assertTrue(testComponentListener.wasNotified());
		// Reset the listener
		testComponentListener.reset();

		// Remove the child
		treeComposite.removeChild(child);
		// Check the listener to make sure it was updated
		assertTrue(testComponentListener.wasNotified());
		// Reset the listener
		testComponentListener.reset();

		// Set the tree's parent
		TreeComposite parent = new TreeComposite();
		child.setId(3);
		treeComposite.setParent(parent);
		// Check the listener to make sure it was updated
		assertTrue(testComponentListener.wasNotified());
		// Reset the listener
		testComponentListener.reset();

		// ---- Extended tests of child notifications. ---- //
		// We should also check to make sure that listeners to the root are
		// registered with new children and unregistered from removed children.

		// Adding a child (TreeComposite) should register the listener with the
		// child. Then adding a component to the child should notify listeners.
		// Add a new child to the root TreeComposite.
		child = new TreeComposite();
		child.setId(50);
		treeComposite.setNextChild(child);
		// Make sure the listener was notified and reset it.
		assertTrue(testComponentListener.wasNotified());
		testComponentListener.reset();

		// Adding a component to the child should notify the listener (because
		// the listener is automatically registered with the child).
		DataComponent node = new DataComponent();
		node.setId(51);
		child.addComponent(node);
		// Make sure the listener was notified and reset it.
		assertTrue(testComponentListener.wasNotified());
		testComponentListener.reset();

		// Changing the component should also notify the listener (because the
		// listener is automatically registered with the child's components).
		// Reset the listener.
		testComponentListener.reset();
		node.setName("Pie jesu domine *thump*");
		// Make sure the listener was notified and reset it.
		assertTrue(testComponentListener.wasNotified());
		testComponentListener.reset();

		// Removing the child from the root tree should mean the listener no
		// longer receives updates from the child or its component.
		treeComposite.removeChild(child);
		// Make sure the listener was notified and reset it.
		assertTrue(testComponentListener.wasNotified());
		testComponentListener.reset();
		child.setName("Dona eis requiem *thump*");
		// Make sure the listener was notified and reset it.
		assertFalse(testComponentListener.wasNotified());

		return;

	}

	/**
	 * <p>
	 * This operation checks the TreeComposite to insure that its equals() and
	 * hashcode() operations work.
	 * </p>
	 * 
	 */
	@Test
	public void checkEquality() {

		// Local Declarations
		TreeComposite firstChild = null, secondChild = null;
		TreeComposite thirdChild = null, fourthChild = null;
		String name = "Tal'shiar", desc = "Romulan Central Intelligence";

		// Create four children
		firstChild = new TreeComposite();
		secondChild = new TreeComposite();
		thirdChild = new TreeComposite();
		fourthChild = new TreeComposite();

		// Setup the details of the children
		firstChild.setId(1);
		firstChild.setName(name);
		firstChild.setDescription(desc);
		secondChild.setId(1);
		secondChild.setName(name);
		secondChild.setDescription(desc);
		thirdChild.setId(3);
		thirdChild.setName(name);
		thirdChild.setDescription(desc);
		fourthChild.setId(4);
		fourthChild.setName(name);
		fourthChild.setDescription(desc);

		// Add children to the trees that are identical
		firstChild.setNextChild(thirdChild);
		firstChild.setNextChild(fourthChild);
		secondChild.setNextChild(thirdChild);
		secondChild.setNextChild(fourthChild);

		// See if they are equal
		assertTrue(firstChild.equals(secondChild));

		// Make sure the firstChild tree is equal to itself
		assertTrue(firstChild.equals(firstChild));

		// Check the hashcodes
		assertEquals(firstChild.hashCode(), firstChild.hashCode());
		assertEquals(firstChild.hashCode(), secondChild.hashCode());

		// Add a DataComponent to the secondChild tree and try again. It should
		// fail this time since the trees are no longer equal.
		secondChild.addComponent(new DataComponent());
		assertFalse(firstChild.equals(secondChild));

		// Try passing null, which should fail
		assertFalse(firstChild==null);

		// Try passing another type of component, which should also fail.
		assertFalse(firstChild.equals(new DataComponent()));

		// Make sure the hashcodes changed
		assertFalse(firstChild.hashCode() == secondChild.hashCode());

		return;

	}

	/**
	 * <p>
	 * This operation checks the TreeComposite to ensure that its copy() and
	 * clone() operations work as specified.
	 * </p>
	 * 
	 */
	@Test
	public void checkCopying() {

		// Local Declarations
		TreeComposite treeComposite, copyTree, copyTreeChild2, cloneTree;
		TreeComposite treeChild1, treeChild2, treeGrandChild;
		DataComponent component1, component2, component3, component4;

		// Instantiate a few TreeComposites
		treeComposite = new TreeComposite();
		treeChild1 = new TreeComposite();
		treeChild2 = new TreeComposite();
		treeGrandChild = new TreeComposite();

		// Instantiate components
		component1 = new DataComponent();
		component2 = new DataComponent();
		component3 = new DataComponent(); // This one is empty
		component4 = new DataComponent(); // Only used for "copy in place" check

		// Add some entries
		component1.addEntry(new StringEntry());
		component1.addEntry(new StringEntry());
		component2.addEntry(new StringEntry());
		component4.addEntry(new StringEntry());

		// Add some components to the treeComposites
		treeComposite.addComponent(component1);
		treeComposite.setActive(true);
		treeComposite.setActiveDataNode(component1);
		treeGrandChild.addComponent(component2);
		treeChild1.addComponent(component3);

		// This piece is parent, add some children
		treeComposite.setNextChild(treeChild1);
		treeComposite.setNextChild(treeChild2);

		// Add a grandchild
		treeChild2.setNextChild(treeGrandChild);

		// Time to do some copying
		copyTree = new TreeComposite();
		copyTree.copy(treeComposite);

		// Make sure they are equal
		assertTrue(treeComposite.equals(copyTree));
		
		// Check copying for nullary
		copyTree.copy(null);

		// Check to make sure no data has changed
		assertTrue(treeComposite.equals(copyTree));
		
		// Now check the "copy in place" copy method on one of the children
		
		// Set up a TreeComposite we will copy INTO treeChild2
		copyTreeChild2 = new TreeComposite();
		copyTreeChild2.addComponent(component4);
		
		// Copy the contents of copyTreeChild2 into treeChild2
		treeChild2.copy(copyTreeChild2, true);
		
		// Now check that they are equal
		assertTrue(treeChild2.equals(copyTreeChild2));
		
		// Check the familial references are still intact
		assertTrue(treeComposite.equals(treeChild2.getParent()));	// Parent
		assertTrue(treeChild1.equals(treeChild2.getPreviousSibling()));	// Siblings
		assertNull(treeChild2.getNextSibling());
		
		// Try copying null "in place"
		treeChild2.copy(null, true);
		
		// Check that nothing has changed
		assertTrue(treeChild2.equals(copyTreeChild2));
			
		// Try using the "copy in place method", but this time setting the
		// boolean flag (for retaining references) to false
		treeChild2.copy(copyTreeChild2, false);
		
		// The trees should still be equal
		assertTrue(treeChild2.equals(copyTreeChild2));
		
		// But the parent and sibling references should have been erased
		assertNull(treeChild2.getParent());
		assertNull(treeChild2.getPreviousSibling());
		assertNull(treeChild2.getNextSibling());
		
		// Try copying null, with the "in place" flag set to null
		treeChild2.copy(null, false);
		
		// Check that nothing has changed
		assertTrue(treeChild2.equals(copyTreeChild2));

		// Now start checking cloning operations
		
		// Check clone operation
		cloneTree = (TreeComposite) treeComposite.clone();

		// Make sure they are equal
		assertTrue(treeComposite.equals(cloneTree));

		// An operation to check linking during copy
		TreeComposite parentTree = new TreeComposite();
		TreeComposite childTree;

		System.err.println("Preparing tree ");

		for (int i = 0; i < 5; i++) {
			childTree = new TreeComposite();
			childTree.setName("Bob " + i);
			parentTree.setNextChild(childTree);
		}

		System.err.println("Cloning tree " + parentTree.getNumberOfChildren());

		// Clone the tree
		cloneTree = (TreeComposite) parentTree.clone();

		// Check linkage - Next
		for (int i = 0; i < 4; i++) {
			assertNotNull(cloneTree.getChildAtIndex(i).getNextSibling());
		}

		// Check linkage - previous
		for (int i = 4; i > 0; i--) {
			assertNotNull(cloneTree.getChildAtIndex(i).getPreviousSibling());
		}

		return;
	}

	/**
	 * This operation checks the ability of the TreeComposite to persist itself
	 * to XML and to load itself from an XML input stream.
	 * @throws IOException 
	 * @throws JAXBException 
	 * @throws NullPointerException 
	 */
	@Test
	public void checkLoadingFromXML() throws NullPointerException, JAXBException, IOException {
		// Local Declarations
		TreeComposite treeComposite, loadTree;
		TreeComposite treeChild1, treeChild2, treeGrandChild;
		DataComponent component1, component2, component3;
		ByteArrayOutputStream outputStream;
		ByteArrayInputStream inputStream;
		JanuaryJAXBHandler xmlHandler = new JanuaryJAXBHandler();
		ArrayList<Class> classList = new ArrayList<Class>();
		classList.add(TreeComposite.class);
		classList.addAll(new JanuaryJAXBClassProvider().getClasses());
		
		// Instantiate a few TreeComposites
		treeComposite = new TreeComposite();
		treeChild1 = new TreeComposite();
		treeChild2 = new TreeComposite();
		treeGrandChild = new TreeComposite();

		// Instantiate components
		component1 = new DataComponent();
		component2 = new DataComponent();
		component3 = new DataComponent(); // This one is empty

		// Add some entries
		component1.addEntry(new StringEntry());
		component1.addEntry(new StringEntry());
		component2.addEntry(new StringEntry());

		// Add some components to the treeComposites
		treeComposite.addComponent(component1);
		treeGrandChild.addComponent(component2);
		treeChild1.addComponent(component3);

		// This piece is parent, add some children
		treeComposite.setNextChild(treeChild1);
		treeComposite.setNextChild(treeChild2);

		// Add a grandchild
		treeChild2.setNextChild(treeGrandChild);

		// persist to outputStream
		outputStream = new ByteArrayOutputStream();
		xmlHandler.write(treeComposite, classList, outputStream);

		// Convert data to inputStream
		loadTree = new TreeComposite();

		inputStream = new ByteArrayInputStream(outputStream.toByteArray());

		// Load the stream
		loadTree = (TreeComposite) xmlHandler.read(classList, inputStream);

		// Compare to see if equal
		assertTrue(treeComposite.equals(loadTree));

	}

	/**
	 * <p>
	 * This operation checks the TreeComposite to make sure that it can be
	 * configured with a set of exemplar children that must be used to add new
	 * children to the TreeComposite.
	 * </p>
	 * 
	 */
	@Test
	public void checkChildExemplars() {

		// Local Declarations
		DataComponent exemplar1DataComponent = new DataComponent();
		TreeComposite exemplar1 = new TreeComposite();
		TreeComposite exemplar2 = new TreeComposite();
		TreeComposite exemplar3 = new TreeComposite();
		TreeComposite exemplar4 = new TreeComposite();
		TreeComposite exemplar5 = new TreeComposite();
		TreeComposite exemplar3Exemplar = new TreeComposite();
		TreeComposite testTree = new TreeComposite();
		TreeComposite testChildTree = new TreeComposite();
		TreeComposite copiedTestTree = null;
		ArrayList<TreeComposite> exemplars = null, exemplar3Exemplars = null;
		
		// Configure the first exemplar
		exemplar1.setId(1);
		exemplar1.setName("Kahn");
		exemplar1.setDescription("Augment");
		exemplar1.addComponent(exemplar1DataComponent);

		// Configure the second exemplar
		exemplar2.setId(2);
		exemplar2.setName("Vyger");
		exemplar2.setDescription("Augment");

		// Configure the third exemplar
		exemplar3.setId(3);
		exemplar3.setName("Chang");
		exemplar3.setDescription("Klingon");
		exemplar3Exemplars = new ArrayList<TreeComposite>();
		exemplar3Exemplars.add(exemplar3Exemplar);
		exemplar3.setChildExemplars(exemplar3Exemplars);

		// Setup the list of child exemplars
		exemplars = new ArrayList<TreeComposite>();
		exemplars.add(exemplar1);
		exemplars.add(exemplar2);
		exemplars.add(exemplar3);

		// Setup the test tree - there should be no child exemplars by default.
		testTree.setId(4);
		testTree.setName("Enemies of Kirk");
		assertFalse(testChildTree.hasChildExemplars());
		testTree.setChildExemplars(exemplars);

		// Check the set of exemplars
		assertNotNull(testTree.getChildExemplars());
		assertEquals(exemplars, testTree.getChildExemplars());
		assertTrue(testTree.hasChildExemplars());

		// Create another exemplar that will replace the third one
		exemplar4.setId(4);
		exemplar4.setName("Chang");
		exemplar4.setDescription("General");
		exemplars.remove(2);
		exemplars.add(exemplar4);

		// Try adding only it to the list
		testTree.addChildExemplar(exemplar4);

		// Check that it replaced exemplar3 correctly
		assertNotNull(testTree.getChildExemplars());
		assertEquals(exemplars, testTree.getChildExemplars());
		assertTrue(testTree.hasChildExemplars());

		// Trying adding another individual exemplar, but an invalid one this
		// time
		testTree.addChildExemplar(null);

		// Create a fifth exemplar, that shouldn't replace anything
		exemplar5.setId(5);
		exemplar5.setName("Jar Jar Binks");
		exemplar5.setDescription("Gungan");
		exemplars.add(exemplar5);

		// Try adding only it to the list
		testTree.addChildExemplar(exemplar5);

		// Check that it added exemplar5 correctly and didn't overwrite anything
		assertNotNull(testTree.getChildExemplars());
		assertEquals(exemplars, testTree.getChildExemplars());
		assertTrue(testTree.hasChildExemplars());

		// Check that nothing was added
		assertNotNull(testTree.getChildExemplars());
		assertEquals(exemplars, testTree.getChildExemplars());
		assertTrue(testTree.hasChildExemplars());

		// Make sure that adding a new child that is not from the set fails
		testTree.setNextChild(testChildTree);
		assertEquals(0, testTree.getNumberOfChildren());

		// Make sure that adding a new child that is not from the set fails with
		// addComponent().
		testTree.addComponent(testChildTree);
		assertEquals(0, testTree.getNumberOfChildren());
		assertEquals(0, testTree.getNumberOfComponents());

		// Add a child from the set and make sure that it worked
		testChildTree = (TreeComposite) exemplar1.clone();
		testTree.setNextChild(testChildTree);
		assertEquals(1, testTree.getNumberOfChildren());

		// Clear the child from the tree
		testTree.removeComponent(testChildTree.getId());
		assertEquals(0, testTree.getNumberOfChildren());

		// Add a child from the set and make sure that it worked
		// with addComponent().
		testChildTree = (TreeComposite) exemplar2.clone();
		testTree.addComponent(testChildTree);
		assertEquals(1, testTree.getNumberOfChildren());
		assertEquals(1, testTree.getNumberOfComponents());

		// Check copying, equality and hashcodes
		copiedTestTree = new TreeComposite();
		copiedTestTree.copy(testTree);
		assertTrue(testTree.equals(copiedTestTree));
		assertEquals(testTree.hashCode(), copiedTestTree.hashCode());

		// Check cloning, equality and hashcodes
		copiedTestTree = null;
		copiedTestTree = (TreeComposite) testTree.clone();
		assertTrue(testTree.equals(copiedTestTree));
		assertEquals(testTree.hashCode(), copiedTestTree.hashCode());

	}

	/**
	 * This operation adds a component of the specified type to the map.
	 * 
	 * @param key
	 *            The type of the component - tree, data or table
	 * @param comp
	 *            The component
	 */
	private void addComponentToMap(String key, Component comp) {

		// Local Declarations
		ArrayList<Component> compList = componentMap.get(key);

		// Allocate the array if necessary
		if (compList == null) {
			compList = new ArrayList<Component>();
			componentMap.put(key, compList);
		}

		// Add the component
		compList.add(comp);

		return;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IComponentVisitor#visit(DataComponent component)
	 */
	@Override
	public void visit(DataComponent component) {

		addComponentToMap("data", component);

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IComponentVisitor#visit(TableComponent component)
	 */
	@Override
	public void visit(TableComponent component) {

		addComponentToMap("table", component);

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IComponentVisitor#visit(TreeComposite component)
	 */
	@Override
	public void visit(TreeComposite component) {

		addComponentToMap("tree", component);

	}
}
