/*******************************************************************************
 * Copyright (c) 2014, 2016 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jordan Deyton (UT-Battelle, LLC.) - initial API and implementation and/or initial documentation
 *    Jay Jay Billings (UT-Battelle, LLC.) - fixed class author tag
 *******************************************************************************/
package org.eclipse.january.form;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class provides a base for implementing traversals of
 * {@link TreeComposite} instances using Java's {@link Iterator} interface. The
 * purpose of this class and any sub-classes is that iterating over a
 * TreeComposite should require something like the following code:
 * 
 * <pre>
 * <code>
 * TreeComposite root;
 * // Set up your tree here...
 * 
 * Iterator<TreeComposite> iterator = new TreeCompositeIterator(root);
 * while (iterator.hasNext()) {
 *     TreeComposite child = iterator.next();
 * 
 *     // Do something with the child tree here...
 * }
 * </code>
 * </pre>
 * 
 * Sub-classes should implement an iterative tree traversal algorithm instead of
 * a recursive one.
 * 
 * @author Jordan H. Deyton
 * 
 */
public abstract class AbstractTreeCompositeIterator implements
		Iterator<TreeComposite> {

	/**
	 * The root TreeComposite that is the starting point for this iterator.
	 */
	protected final TreeComposite root;

	/**
	 * The default constructor.
	 * 
	 * @param root
	 *            The root TreeComposite that is the starting point for this
	 *            iterator.
	 */
	public AbstractTreeCompositeIterator(TreeComposite root) {

		// Set the root node of the tree.
		if (root != null) {
			this.root = root;
		}
		// If the argument is null, we must throw an IllegalArgumentException.
		else {
			// Set the root TreeComposite so that this instance is not in an
			// incomplete state.
			this.root = new TreeComposite();
			throw new IllegalArgumentException("TreeCompositeIterator error: "
					+ "Root cannot be null.");
		}

		return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public abstract boolean hasNext();

	/**
	 * Sub-classes should <b>override this method and call it via
	 * <code>super.next()</code></b>. If {@link #hasNext()} is false, this
	 * method throws a {@link NoSuchElementException} as specified in the
	 * {@link Iterator} API.
	 * 
	 * @see java.util.Iterator#next()
	 */
	@Override
	public TreeComposite next() {

		// Set the default return value.
		TreeComposite next = null;

		// Throw a NoSuchElementException if there is no element left to
		// traverse.
		if (!hasNext()) {
			throw new NoSuchElementException("TreeCompositeIterator error: "
					+ "No elements remaining in iterative traversal.");
		}

		return next;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#remove()
	 */
	@Override
	public void remove() {

		// TODO We may or may not want to implement this.
		throw new UnsupportedOperationException("TreeCompositeIterator error: "
				+ "Removing elements is currently not supported.");

	}

}
