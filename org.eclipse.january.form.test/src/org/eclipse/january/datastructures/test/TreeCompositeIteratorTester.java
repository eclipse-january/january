/*******************************************************************************
 * Copyright (c) 2014, 2016 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jordan Deyton (UT-Battelle, LLC.) - initial API and implementation and/or initial documentation
 *   
 *******************************************************************************/
package org.eclipse.january.datastructures.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.eclipse.january.form.BreadthFirstTreeCompositeIterator;
import org.eclipse.january.form.PostOrderTreeCompositeIterator;
import org.eclipse.january.form.PreOrderTreeCompositeIterator;
import org.eclipse.january.form.TreeComposite;
import org.junit.Before;
import org.junit.Test;

/**
 * Checks the different types of iterators provided for TreeComposites.
 * 
 * @author Jordan H. Deyton
 * 
 */
public class TreeCompositeIteratorTester {

	/**
	 * A TreeComposite with a base-case structure (a single node).
	 */
	private TreeComposite rootBase;

	/**
	 * The root of a TreeComposite with a more complicated structure than
	 * {@link #rootBase}.
	 */
	private TreeComposite root;

	/**
	 * Initializes the base-case tree and the more complicated tree.
	 */
	@Before
	public void initializeTree() {

		// Create a tree with a single node.
		rootBase = new TreeComposite();
		rootBase.setName("A1");

		/*-
		 * Here's how the tree breaks down:
		 * 
		 * A1
		 * |-B1
		 * | \-C1
		 * \-B2
		 *   |-C2
		 *   |-C3
		 *   | |-D1
		 *   | \-D2
		 *   \-C4
		 *     |-D3
		 *     |-D4
		 *     \-D5
		 */

		// The root node is labeled A for top level and 1 for first "A".
		root = new TreeComposite();
		root.setName("A1");

		// There are 3 additional levels of the tree (B, C, and D).
		TreeComposite b, c, d;

		// The first sub-tree is B1 with a child C1.
		b = new TreeComposite();
		b.setName("B1");
		root.setNextChild(b);
		c = new TreeComposite();
		c.setName("C1");
		b.setNextChild(c);

		// The second sub-tree is B2. It has 3 C children and 5 D grandchildren.
		b = new TreeComposite();
		b.setName("B2");
		root.setNextChild(b);

		// C2 is a child of B2 but has no children.
		c = new TreeComposite();
		c.setName("C2");
		b.setNextChild(c);

		// C3 is a child of B2 and has children D1 and D2.
		c = new TreeComposite();
		c.setName("C3");
		b.setNextChild(c);
		// C3's children...
		d = new TreeComposite();
		d.setName("D1");
		c.setNextChild(d);
		d = new TreeComposite();
		d.setName("D2");
		c.setNextChild(d);

		// C4 is a child of B2 and has children D3, D4, and D5.
		c = new TreeComposite();
		c.setName("C4");
		b.setNextChild(c);
		// C4's children...
		d = new TreeComposite();
		d.setName("D3");
		c.setNextChild(d);
		d = new TreeComposite();
		d.setName("D4");
		c.setNextChild(d);
		d = new TreeComposite();
		d.setName("D5");
		c.setNextChild(d);

		return;
	}

	/**
	 * Tests the exceptions and return values that should be produced by
	 * pre-order iterators.
	 */
	@Test
	public void checkPreOrderExceptions() {

		TreeComposite root;
		Iterator<TreeComposite> iterator;

		// Initialize with a null tree.
		try {
			root = null;

			// The below call should throw an exception.
			iterator = new PreOrderTreeCompositeIterator(root);
			fail("PreOrderTreeCompositeIterator failure: "
					+ "Null root node should throw an IllegalArgumentException");
		} catch (IllegalArgumentException e) {

		}

		// Next when no more elements. Also check normal return values for
		// hasNext() and next().
		try {
			root = new TreeComposite();
			iterator = new PreOrderTreeCompositeIterator(root);
			// hasNext() should return true.
			assertTrue(iterator.hasNext());
			// The return value for the first call to next() should be the tree.
			assertSame(root, iterator.next());
			// hasNext() should return false.
			assertFalse(iterator.hasNext());

			// The below call should throw an exception.
			iterator.next();
			fail("PreOrderTreeCompositeIterator failure: "
					+ "When no elements remain, next() should throw a NoSuchElementException.");
		} catch (NoSuchElementException e) {

		}

		// Removal (currently not supported).
		try {
			root = new TreeComposite();
			iterator = new PreOrderTreeCompositeIterator(root);
			iterator.next();

			// The below call should throw an exception.
			iterator.remove();
			fail("PreOrderTreeCompositeIterator failure: "
					+ "remove() should throw an UnsupportedOperationException.");
		} catch (UnsupportedOperationException e) {

		}

		return;
	}

	/**
	 * Tests the pre-order traversal of a TreeComposite and its sub-trees.
	 */
	@Test
	public void checkPreOrderTraversal() {

		// ---- Test with the base case tree. ---- //
		// Initialize the actual output.
		String actualOutput = "";

		// Create a pre-order iterator.
		Iterator<TreeComposite> iterator = new PreOrderTreeCompositeIterator(
				rootBase);

		// Test the base case.
		while (iterator.hasNext()) {
			actualOutput += iterator.next().getName() + " ";
		}

		// Check the output. It should be the name of the single node.
		assertEquals("A1 ", actualOutput);
		// --------------------------------------- //

		// ---- Test with the more complicated tree. ---- //
		// Create a pre-order iterator.
		iterator = new PreOrderTreeCompositeIterator(root);

		// Set up the expected pre-order output. This is based on the names of
		// the TreeComposites.
		final String expectedOutput = "A1 B1 C1 B2 C2 C3 D1 D2 C4 D3 D4 D5 ";

		// Reset the actual output.
		actualOutput = "";

		// Iterate over the tree and append the names to the output string.
		while (iterator.hasNext()) {
			actualOutput += iterator.next().getName() + " ";
		}

		// Make sure the actual order of the trees matches the expected order.
		assertEquals(expectedOutput, actualOutput);
		// ---------------------------------------------- //

		return;
	}

	/**
	 * Tests the exceptions and return values that should be produced by
	 * post-order iterators.
	 */
	@Test
	public void checkPostOrderErrors() {

		TreeComposite root;
		Iterator<TreeComposite> iterator;

		// Initialize with a null tree.
		try {
			root = null;

			// The below call should throw an exception.
			iterator = new PostOrderTreeCompositeIterator(root);
			fail("PostOrderTreeCompositeIterator failure: "
					+ "Null root node should throw an IllegalArgumentException");
		} catch (IllegalArgumentException e) {

		}

		// Next when no more elements. Also check normal return values for
		// hasNext() and next().
		try {
			root = new TreeComposite();
			iterator = new PostOrderTreeCompositeIterator(root);
			// hasNext() should return true.
			assertTrue(iterator.hasNext());
			// The return value for the first call to next() should be the tree.
			assertSame(root, iterator.next());
			// hasNext() should return false.
			assertFalse(iterator.hasNext());

			// The below call should throw an exception.
			iterator.next();
			fail("PostOrderTreeCompositeIterator failure: "
					+ "When no elements remain, next() should throw a NoSuchElementException.");
		} catch (NoSuchElementException e) {

		}

		// Removal (currently not supported).
		try {
			root = new TreeComposite();
			iterator = new PostOrderTreeCompositeIterator(root);
			iterator.next();

			// The below call should throw an exception.
			iterator.remove();
			fail("PostOrderTreeCompositeIterator failure: "
					+ "remove() should throw an UnsupportedOperationException.");
		} catch (UnsupportedOperationException e) {

		}

		return;
	}

	/**
	 * Tests the post-order traversal of a TreeComposite and its sub-trees.
	 */
	@Test
	public void checkPostOrderTraversal() {

		// ---- Test with the base case tree. ---- //
		// Initialize the actual output.
		String actualOutput = "";

		// Create a post-order iterator.
		Iterator<TreeComposite> iterator = new PostOrderTreeCompositeIterator(
				rootBase);

		// Test the base case.
		while (iterator.hasNext()) {
			actualOutput += iterator.next().getName() + " ";
		}

		// Check the output. It should be the name of the single node.
		assertEquals("A1 ", actualOutput);
		// --------------------------------------- //

		// ---- Test with the more complicated tree. ---- //
		// Create a post-order iterator.
		iterator = new PostOrderTreeCompositeIterator(root);

		// Set up the expected post-order output. This is based on the names of
		// the TreeComposites.
		final String expectedOutput = "C1 B1 C2 D1 D2 C3 D3 D4 D5 C4 B2 A1 ";

		// Reset the actual output.
		actualOutput = "";

		// Iterate over the tree and append the names to the output string.
		while (iterator.hasNext()) {
			actualOutput += iterator.next().getName() + " ";
		}

		// Make sure the actual order of the trees matches the expected order.
		assertEquals(expectedOutput, actualOutput);
		// ---------------------------------------------- //

		return;
	}

	/**
	 * Tests the exceptions and return values that should be produced by
	 * breadth-first iterators.
	 */
	@Test
	public void checkBreadthFirstErrors() {

		TreeComposite root;
		Iterator<TreeComposite> iterator;

		// Initialize with a null tree.
		try {
			root = null;

			// The below call should throw an exception.
			iterator = new BreadthFirstTreeCompositeIterator(root);
			fail("BreadthFirstTreeCompositeIterator failure: "
					+ "Null root node should throw an IllegalArgumentException");
		} catch (IllegalArgumentException e) {

		}

		// Next when no more elements. Also check normal return values for
		// hasNext() and next().
		try {
			root = new TreeComposite();
			iterator = new BreadthFirstTreeCompositeIterator(root);
			// hasNext() should return true.
			assertTrue(iterator.hasNext());
			// The return value for the first call to next() should be the tree.
			assertSame(root, iterator.next());
			// hasNext() should return false.
			assertFalse(iterator.hasNext());

			// The below call should throw an exception.
			iterator.next();
			fail("BreadthFirstTreeCompositeIterator failure: "
					+ "When no elements remain, next() should throw a NoSuchElementException.");
		} catch (NoSuchElementException e) {

		}

		// Removal (currently not supported).
		try {
			root = new TreeComposite();
			iterator = new BreadthFirstTreeCompositeIterator(root);
			iterator.next();

			// The below call should throw an exception.
			iterator.remove();
			fail("BreadthFirstTreeCompositeIterator failure: "
					+ "remove() should throw an UnsupportedOperationException.");
		} catch (UnsupportedOperationException e) {

		}

		return;
	}

	/**
	 * Tests the breadth-first traversal of a TreeComposite and its sub-trees.
	 */
	@Test
	public void checkBreadthFirstTraversal() {

		// ---- Test with the base case tree. ---- //
		// Initialize the actual output.
		String actualOutput = "";

		// Create a breadth-first-order iterator.
		Iterator<TreeComposite> iterator = new BreadthFirstTreeCompositeIterator(
				rootBase);

		// Test the base case.
		while (iterator.hasNext()) {
			actualOutput += iterator.next().getName() + " ";
		}

		// Check the output. It should be the name of the single node.
		assertEquals("A1 ", actualOutput);
		// --------------------------------------- //

		// ---- Test with the more complicated tree. ---- //
		// Create a breadth-first-order iterator.
		iterator = new BreadthFirstTreeCompositeIterator(root);

		// Set up the expected breadth-first-order output. This is based on the
		// names of the TreeComposites.
		final String expectedOutput = "A1 B1 B2 C1 C2 C3 C4 D1 D2 D3 D4 D5 ";

		// Reset the actual output.
		actualOutput = "";

		// Iterate over the tree and append the names to the output string.
		while (iterator.hasNext()) {
			actualOutput += iterator.next().getName() + " ";
		}

		// Make sure the actual order of the trees matches the expected order.
		assertEquals(expectedOutput, actualOutput);
		// ---------------------------------------------- //

		return;
	}

}
