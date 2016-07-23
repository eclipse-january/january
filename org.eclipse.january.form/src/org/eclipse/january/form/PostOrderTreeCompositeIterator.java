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

import java.util.Stack;

/**
 * This class implements a post-order traversal for a {@link TreeComposite}. To
 * use this, instantiate it with a root TreeComposite and use the standard
 * iterator commands, e.g.:
 * 
 * <pre>
 * <code>
 * TreeComposite root;
 * // Set up your tree here...
 * 
 * Iterator<TreeComposite> iterator = new PostOrderTreeCompositeIterator(root);
 * while (iterator.hasNext()) {
 *     TreeComposite child = iterator.next();
 * 
 *     // Do something with the child tree here...
 * }
 * </code>
 * </pre>
 * 
 * @author Jordan H. Deyton
 * 
 */
public class PostOrderTreeCompositeIterator extends
		AbstractTreeCompositeIterator {

	/**
	 * A stack used to maintain state information about the position of the
	 * iterator. If empty, there is no remaining TreeComposite to visit.
	 */
	private final Stack<TreeComposite> stack;

	/**
	 * A reference to the last node returned by {@link #next()}. This is null
	 * only at the beginning of the traversal.
	 */
	private TreeComposite lastNodeVisited;

	/**
	 * The default constructor.
	 * 
	 * @param root
	 *            The root TreeComposite that is the starting point for this
	 *            iterator.
	 */
	public PostOrderTreeCompositeIterator(TreeComposite root) {

		// Call the super constructor. Send a non-null root TreeComposite. We
		// must make sure this class is completely initialized before throwing
		// an exception for a null argument.
		super((root != null ? root : new TreeComposite()));

		// Create a new, empty stack.
		stack = new Stack<TreeComposite>();
		// Initialize the last visited node.
		lastNodeVisited = null;

		// If the root TreeComposite is not null, it is the first element to
		// iterate over.
		if (root != null) {
			stack.push(root);
		}
		// Otherwise, now that the class is initialized, we can throw an
		// exception for a null argument.
		else {
			throw new IllegalArgumentException(
					"PostOrderTreeCompositeIterator error: "
							+ "Root cannot be null.");
		}

		return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ice.datastructures.form.TreeCompositeIterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ice.datastructures.form.TreeCompositeIterator#next()
	 */
	@Override
	public TreeComposite next() {

		// Set the default return value.
		TreeComposite next = super.next();

		// Take a peek at the top node in the stack.
		TreeComposite node = stack.peek();

		// If the last node visited was the right-most child of the top node, we
		// have finished traversing the top node. It is the next node that
		// should be visited.
		if (lastNodeVisited == node
				.getChildAtIndex(node.getNumberOfChildren() - 1)) {
			next = stack.pop();
			lastNodeVisited = next;
		}
		// Otherwise, we are still traversing this node.
		else {
			// If the last node visited was not null, get the sibling to its
			// right.
			if (lastNodeVisited != null) {
				node = lastNodeVisited.getNextSibling();
			}
			// Otherwise, we have just started traversing the tree. The current
			// node is the root node. Remove it from the stack because it might
			// be added below.
			else {
				node = stack.pop();
			}

			// Traverse all left-descendants of the node down to a leaf child.
			while (node.getNumberOfChildren() > 0) {
				stack.push(node);
				node = node.getChildAtIndex(0);
			}

			// The next node to visit is the leaf child.
			next = node;
			lastNodeVisited = next;
		}

		return next;
	}

}
