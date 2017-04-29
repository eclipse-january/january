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
package org.eclipse.january.form;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.eclipse.january.form.emf.EMFComponent;

/**
 * The TreeComposite realizes the Composite interface to provide a multi-level
 * hierarchical tree of ICE Components. TreeComposites are n-ary trees, meaning
 * that they can have any number of children and data per node. A "sibling" is a
 * TreeComposite on the same level of the tree as the current TreeComposite and
 * a "child" is a subordinate TreeComposite contained in the set managed by the
 * current TreeComposite.
 * </p>
 * <p>
 * When a Component is added to a TreeComposite (keep in mind Composites are
 * Components too!), it will visit that Component to determine its type. If it
 * is another TreeComposite, it will set itself as the parent composite of the
 * child TreeComposite. If it is anything else, it will just be added to the
 * composite. Only TreeComposites can be parent nodes in the tree and the
 * TreeComposite has getNextSibling():TreeComposite,
 * getLastSibling():TreeComposite and getNextChild():TreeComposite operations to
 * iterate across the tree in both breadth and depth. The
 * getNextComponent():Component operation returns the next "data node" in the
 * TreeComposite which is always a Component and never a TreeComposite. It may
 * be any implementation of the Component interface except a Composite, so do
 * not assume that it is just a TreeComposite. This type of trinary separation
 * between siblings, children and data seems a bit odd at first, but it
 * effectively separates the tree structure from data.
 * </p>
 * <p>
 * Both getNext/LastSibling() and getNextChild() work like standard tree
 * iterators in that the reference can be updated and getNext*() called to go to
 * the next child or sibling. Successively calling getNextChild() on a *child*
 * walks down the tree, but calling it on the parent returns the next child for
 * that parent. Successively calling getNext/LastSibling() walks across the
 * tree. Successively calling getParent() walks up the tree. A node with zero or
 * more children, no parent and no siblings is the root node and the last
 * universal ancestor of all TreeComposites it contains. Children may also be
 * retrieved in a random access mode using getChildAtIndex(), but siblings an
 * only be retrieved by iteration. The resetChildIterator() will set the
 * "iteration pointer" of the children back to the first element of the set.
 * </p>
 * <p>
 * TreeComposite.getComponents():Component[*] returns all components, both
 * TreeComposites and regular Components. TreeComposite.getComponent(int
 * id):Component returns both TreeComposites and regular Components by id or
 * null if a Component with that id does not exist in the tree. The
 * getDataNodes():Component[*] operation can be called to return a list of
 * Components that contain only data. This list will not contain TreeComposites.
 * TreeComposite.getComponent() assumes that the request is for regular
 * Components first and checks the TreeComposites second. The removeComponent()
 * operation makes the same assumption. That being said, in general you should
 * still give all of your components, whether Component or Composite, unique
 * ids.
 * </p>
 * <p>
 * If TreeComposite.addComponent() is called with a TreeComposite as an
 * argument, it will be added as child if it not already a child of that parent.
 * </p>
 * <p>
 * One data node may be specified as the "active" data node. If a data node is
 * marked as active it should take priority over the other data nodes when the
 * nodes are considered for decision making or prioritized. Support for active
 * nodes may be disabled by calling allowActiveDataNodes(false). If this option
 * is specified, getActiveDataNode() will always return null and
 * setActiveDataNode() will not function. Active data nodes are allowed by
 * default. TreeComposites themselves can be marked as active too and this in
 * this case it has the same meaning, but with the added requirement that the
 * entire active composite should be given priority.
 * </p>
 * <p>
 * There is no concept of spatial ordering in a TreeComposite; Children are
 * always add to the end of the set and next and last refer to the last member
 * of the set with no implied spatial position or index.
 * </p>
 * <p>
 * The TreeComposite notifies is listeners whenever trees and data nodes are
 * added or removed, whenever the active data node is set, if allowed, and
 * whenever the parent is set. Those IComponentListeners that register with a
 * TreeComposite are also registered as listeners of its children and data nodes
 * because changes to those groups change the tree.
 * </p>
 * <p>
 * TreeComposites can be configured such that only nodes with specific
 * configurations can be added as children using the setChildExemplars()
 * operation. This capability is used to configure TreeComposites that cannot be
 * universally modified and must be extended according to a specification. If a
 * TreeComposite is configured with this list of allowed children, calling
 * setNextChild() or addComponent() will fail if a child that is not cloned from
 * the list returned by getChildExemplars() is submitted. Special care should be
 * taken that children from this list are added to the TreeComposite *before*
 * they themselves are modified.
 * 
 * @author Jay Jay Billings
 */
@XmlRootElement(name = "TreeComposite")
@XmlAccessorType(XmlAccessType.FIELD)
public class TreeComposite extends ICEObject
		implements Composite, IComponentVisitor {
	/**
	 * <p>
	 * The TreeComposite at the same level of the tree that comes before this
	 * TreeComposite in the set.
	 * </p>
	 * 
	 */
	@XmlTransient
	protected TreeComposite previousSibling = null;
	/**
	 * <p>
	 * The TreeComposite at the same level of the tree that comes after this
	 * TreeComposite in the set.
	 * </p>
	 * 
	 */
	@XmlTransient
	protected TreeComposite nextSibling = null;
	/**
	 * <p>
	 * The set of children TreeComposites that are managed by this
	 * TreeComposite.
	 * </p>
	 * 
	 */
	@XmlElementWrapper(name = "Children")
	@XmlElements({
			@XmlElement(name = "TreeComposite", type = TreeComposite.class),
			@XmlElement(name = "AdaptiveTreeComposite", type = AdaptiveTreeComposite.class) })
	protected ArrayList<TreeComposite> children;
	/**
	 * <p>
	 * The current index in the set to which the child iterator points.
	 * </p>
	 * 
	 */
	@XmlTransient
	private int currentChildIndex = 0;
	/**
	 * <p>
	 * The set of Components that hold data for the TreeComposite.
	 * </p>
	 * 
	 */
	@XmlAnyElement()
	@XmlElementRefs(value = {
			@XmlElementRef(name = "ResourceComponent", type = ResourceComponent.class),
			@XmlElementRef(name = "TableComponent", type = TableComponent.class),
			@XmlElementRef(name = "MatrixComponent", type = MatrixComponent.class),
			@XmlElementRef(name = "GeometryComponent", type = GeometryComponent.class),
			@XmlElementRef(name = "MasterDetailsComponent", type = MasterDetailsComponent.class),
			@XmlElementRef(name = "DataComponent", type = DataComponent.class) })
	private ArrayList<Component> dataNodes;

	/**
	 * <p>
	 * A reference to the parent TreeComposite that "owns" this child.
	 * </p>
	 * 
	 */
	@XmlTransient
	protected TreeComposite parent = null;

	/**
	 * <p>
	 * The active data node is the data node that should take priority over the
	 * other data nodes. If a data node is marked as active it should take
	 * priority over the other data nodes when the nodes are considered for
	 * decision making or prioritized.
	 * </p>
	 * 
	 */
	@XmlTransient
	private Component activeDataNode = null;

	/**
	 * <p>
	 * The flag that determines whether or not active data nodes are allowed.
	 * </p>
	 * 
	 */
	@XmlAttribute
	private boolean allowActiveDataNodes = true;

	/**
	 * <p>
	 * The set of exemplar children of this Tree from which children must be
	 * created. If this TreeComposite has been configured to use the exemplars
	 * (by calling setChildExemplars with a set of TreeComposites), which can be
	 * checked by calling hasChildExemplars, then new children must be created
	 * by copying a TreeComposite from this set and returning it back to the
	 * parent TreeComposite.
	 * </p>
	 * 
	 */
	@XmlElement(name = "exemplar")
	protected ArrayList<TreeComposite> childExemplars;

	/**
	 * <p>
	 * True if the TreeComposite should be considered active, false if not.
	 * </p>
	 * 
	 */
	@XmlAttribute
	private boolean active = false;

	/**
	 * <p>
	 * The constructor.
	 * </p>
	 * 
	 */
	public TreeComposite() {

		// Allocate the array for holding children
		children = new ArrayList<TreeComposite>();

		// Allocate the array for holding data nodes
		dataNodes = new ArrayList<Component>();

		// Setup the list of Listeners
		listeners = new ArrayList<IUpdateableListener>();

		// Setup the exemplar list
		childExemplars = new ArrayList<TreeComposite>();

	}

	/**
	 * <p>
	 * This operation sets the parent TreeComposite of the current
	 * TreeComposite. This operation will automatically "rewire" the original
	 * parent, if one existed, by removing the current node from the old parent.
	 * The TreeComposite for which this operation is called reset its siblings
	 * to null and add itself to the parent tree composite.
	 * </p>
	 * <p>
	 * This operation is essentially a pass-through to setNextChild() with the
	 * exception of erasing the link to the siblings and removing the child from
	 * the previous parent.
	 * </p>
	 * 
	 * @param pNode
	 *            <p>
	 *            The parent node.
	 *            </p>
	 */
	public void setParent(TreeComposite pNode) {

		// Make sure the node isn't null
		if (pNode != null) {
			// Remove the node from its parent if it has one
			if (parent != null) {
				parent.removeChild(this);
			}
			// Clear the links to the siblings
			nextSibling = null;
			previousSibling = null;
			// Welcome the node to the family!
			parent = pNode;
			pNode.setNextChild(this);
			// Notify any listeners
			notifyListeners();
		}

		return;

	}

	/**
	 * <p>
	 * This operation returns the parent TreeComposite of the current
	 * TreeComposite.
	 * </p>
	 * 
	 * @return
	 * 		<p>
	 *         The parent node.
	 *         </p>
	 */
	public TreeComposite getParent() {
		return parent;
	}

	/**
	 * <p>
	 * This operation returns the next child of the TreeComposite.
	 * </p>
	 * 
	 * @return
	 * 		<p>
	 *         The next child in the set of child TreeComposites or null if the
	 *         end of the set has been reached.
	 *         </p>
	 */
	public TreeComposite getNextChild() {

		// Local Declarations
		TreeComposite currentChild = null;

		// Get the next child if we haven't reached the end of the list
		if (currentChildIndex < children.size()) {
			// Return the next child.
			currentChild = children.get(currentChildIndex);
			// Increment the counter
			currentChildIndex++;
		}

		return currentChild;
	}

	/**
	 * This is a helper operation to check the list of exemplars when new
	 * children are added to make sure that they are from the set, if required.
	 * 
	 * @param cNode
	 *            The new child that should be added.
	 * @return True if the child can be added to the set - either because it
	 *         matches the exemplars or because there is no exemplar set of
	 *         children - and false otherwise.
	 */
	protected boolean checkExemplars(TreeComposite cNode) {

		// Local Declarations
		boolean canAdd = true;

		// If there is a list of child exemplars, a check needs to be performed.
		if (hasChildExemplars()) {
			// Make sure the new child matches one of the exemplars.
			canAdd = childExemplars.contains(cNode);
		}
		return canAdd;
	}

	/**
	 * <p>
	 * This operation sets add a child to the list of children managed by this
	 * TreeComposite. The child is added to the end of the set and the tree is
	 * not "rewired." This operation will not add children that are already
	 * members of the TreeComposite and it will not add itself as a child.
	 * </p>
	 * 
	 * @param cNode
	 *            <p>
	 *            The next and newest child TreeComposite at this level of the
	 *            tree.
	 *            </p>
	 */
	public void setNextChild(TreeComposite cNode) {

		// Local Declarations
		TreeComposite lastChild = null;

		// Only add the child if it is not null and already in this tree. Also
		// make sure that it is part of the exemplar list, if required.
		if (cNode != null && !children.contains(cNode) && cNode != this
				&& checkExemplars(cNode)) {
			// Set the sibling links if there is more than one child in the list
			if (!children.isEmpty()) {
				// Get the last child in the list
				lastChild = children.get(children.size() - 1);
				// Set the next sibling link for the current child at the end of
				// the
				// list to the new child.
				lastChild.nextSibling = cNode;
				// Set the previous sibling link for the new child to the
				// current
				// child at the end of the list. It doesn't have a next sibling
				// since it is at the end of the list.
				cNode.previousSibling = lastChild;
			}
			// Add the node to the end of the list.
			children.add(cNode);
			// Set the parent reference for the child
			cNode.parent = this;
			// Register the listeners with this child
			for (IUpdateableListener listener : listeners) {
				cNode.register(listener);
			}
			// Notify any listeners that a this tree was changed
			notifyListeners();
		}

		return;

	}

	/**
	 * <p>
	 * This operation returns the previous child of the TreeComposite.
	 * </p>
	 * 
	 * @return
	 * 		<p>
	 *         The previous child in the set of child TreeComposites or null if
	 *         the iterator has returned to the beginning of the set.
	 *         </p>
	 */
	public TreeComposite getPreviousChild() {

		// Local Declarations
		TreeComposite currentChild = null;

		// Get the next child if we haven't reached the end of the list
		if (currentChildIndex > 0) {
			// Decrement the counter
			currentChildIndex--;
			// Return the next child.
			currentChild = children.get(currentChildIndex);
		}

		return currentChild;
	}

	/**
	 * <p>
	 * This operation removes the specified child node from the set of children
	 * or does nothing if it is not a child of this TreeComposite. Calling this
	 * operation will "rewire" the tree such that the previous and next siblings
	 * of the deleted node will point to each other.
	 * </p>
	 * 
	 * @param cNode
	 *            <p>
	 *            The child node to remove.
	 *            </p>
	 */
	public void removeChild(TreeComposite cNode) {

		// Try to remove the child if it is not null, and make sure the child
		// belongs to the set for this tree
		if (cNode != null && children.contains(cNode)) {
			// Re-link the siblings to point to each other, previous first
			if (cNode.previousSibling != null) {
				cNode.previousSibling.nextSibling = cNode.nextSibling;
			}
			// Next siblings next
			if (cNode.nextSibling != null) {
				cNode.nextSibling.previousSibling = cNode.previousSibling;
			}
			// Get the index of this child in the list before removing it so
			// that the iterator index can be fixed
			int i = children.indexOf(cNode);
			// Remove the child and break out of the loop
			children.remove(cNode);
			// Remove the parent link of the child
			cNode.parent = null;
			// Fix the currentChildIndex iterator if needed
			if (currentChildIndex > i) {
				currentChildIndex--;
			}
			// Unregister listeners from the removed child.
			for (IUpdateableListener listener : listeners) {
				cNode.unregister(listener);
			}
			// Notify any listeners
			notifyListeners();
		}

		return;

	}

	/**
	 * <p>
	 * This operation returns the number of children of this TreeComposite.
	 * </p>
	 * 
	 * @return
	 */
	public int getNumberOfChildren() {
		return children.size();
	}

	/**
	 * <p>
	 * This operation resets the child iterator of this TreeComposite to its
	 * initial position at the beginning of the set.
	 * </p>
	 * 
	 */
	public void resetChildIterator() {

		// Reset the child iterator to the starting position.
		currentChildIndex = 0;

	}

	/**
	 * <p>
	 * This operation treats the set of children as if they are randomly
	 * accessible and returns the child at the given index if it is between zero
	 * and the number of children minus one.
	 * </p>
	 * 
	 * @param index
	 *            <p>
	 *            The index at which the desired child can be found.
	 *            </p>
	 * @return
	 * 		<p>
	 *         The child or null if the index is out of bounds.
	 *         </p>
	 */
	public TreeComposite getChildAtIndex(int index) {

		// Check the bounds
		if (index > -1 && index < children.size()) {
			return children.get(index);
		}

		return null;
	}

	/**
	 * <p>
	 * This operation returns the next or "nearest right" sibling of the
	 * TreeComposite. It returns null if there is not a sibling after this one.
	 * </p>
	 * 
	 * @return
	 * 		<p>
	 *         The next or "nearest right" sibling in the tree.
	 *         </p>
	 */
	public TreeComposite getNextSibling() {
		return nextSibling;
	}

	/**
	 * <p>
	 * This operation returns the previous or "nearest left" sibling of the
	 * TreeComposite. It returns null if there is not a previous sibling.
	 * </p>
	 * 
	 * @return
	 * 		<p>
	 *         The previous or "nearest left" sibling in the tree.
	 *         </p>
	 */
	public TreeComposite getPreviousSibling() {
		return previousSibling;
	}

	/**
	 * <p>
	 * This operation returns the set of data nodes managed by the TreeComposite
	 * or null if no such nodes exist. Data nodes are those nodes which are only
	 * Components and not Composites. This includes things such as DataComponent
	 * and TableComponent.
	 * </p>
	 * 
	 * @return
	 * 		<p>
	 *         The set of Components managed by the TreeComposite.
	 *         </p>
	 */
	public ArrayList<Component> getDataNodes() {
		return dataNodes;
	}

	/**
	 * <p>
	 * This operation returns the number of data nodes of this TreeComposite.
	 * </p>
	 * 
	 * @return
	 */
	public int getNumberOfDataNodes() {
		return dataNodes.size();
	}

	/**
	 * <p>
	 * This operation returns the active data node for this TreeComposite or
	 * null if the active data node has not been specified if and only if active
	 * data nodes are allowed for this TreeComposite.
	 * </p>
	 * 
	 * @return
	 * 		<p>
	 *         The active data node or null if it has not been specified.
	 *         </p>
	 */
	public Component getActiveDataNode() {

		// Make sure active nodes are allowed
		if (allowActiveDataNodes) {
			return activeDataNode;
		}

		return null;
	}

	/**
	 * <p>
	 * This operation sets the active data node for the TreeComposite if and
	 * only if active data nodes are allowed for this TreeComposite. If the node
	 * is not a member of the set of data nodes, the TreeComposite ignores it
	 * and the currently specified data node (or null) remains in place. Calling
	 * this operation with a Component that is not a member of the set of data
	 * nodes will not add it to the set.
	 * </p>
	 * 
	 * @param node
	 *            <p>
	 *            The data node that should be marked as the active data node.
	 *            If this node is null or not a member of the set of data nodes
	 *            for this TreeComposite it is ignored.
	 *            </p>
	 */
	public void setActiveDataNode(Component node) {

		// Make sure active nodes are allowed, that the node is not null and
		// that it is in the set.
		if (allowActiveDataNodes && node != null && dataNodes.contains(node)) {
			activeDataNode = node;
		}

		// Notify any listeners
		notifyListeners();

		return;

	}

	/**
	 * <p>
	 * This operation specifies whether or not this TreeComposite will allow
	 * clients to specify active data nodes. Support for active nodes may be
	 * disabled by calling allowActiveDataNodes(false) and enabled by calling
	 * allowActiveDataNodes(true). If this option is set to false,
	 * getActiveDataNode() will always return null and setActiveDataNode() will
	 * not function. Active data nodes are allowed by default.
	 * </p>
	 * 
	 * @param allow
	 */
	public void allowActiveDataNodes(boolean allow) {

		allowActiveDataNodes = allow;
		// Notify any listeners
		notifyListeners();

	}

	/**
	 * <p>
	 * This operation is used to check equality between the TreeComposite and
	 * another TreeComposite. It returns true if the TreeComposites are equal
	 * and false if they are not. It compares ALL of the nodes of a
	 * TreeComposite, child and data nodes alike. It does not compare the parent
	 * and sibling references.
	 * </p>
	 * 
	 * @param otherTreeComposite
	 *            <p>
	 *            The other TreeComposite to which this component should be
	 *            compared.
	 *            </p>
	 * @return
	 * 		<p>
	 *         True if the TreeComposites are equal, false otherwise.
	 *         </p>
	 */
	@Override
	public boolean equals(Object otherTreeComposite) {

		// Local Declarations
		boolean equalVal = false;
		TreeComposite tree = null;

		// Make sure we are dealing with a legitimate TreeComposite
		if (otherTreeComposite != null
				&& (otherTreeComposite instanceof TreeComposite)) {
			// See if they are the same reference
			if (this == otherTreeComposite) {
				equalVal = true;
			} else {
				tree = (TreeComposite) otherTreeComposite;
				// Check everything except the parent and sibling references.
				// Start with ICEObject descriptive data.
				equalVal = this.uniqueId == tree.uniqueId
						&& this.objectName.equals(tree.objectName)
						&& this.objectDescription.equals(tree.objectDescription)
						&& children.equals(tree.children)
						&& dataNodes.equals(tree.dataNodes)
						&& ((activeDataNode != null)
								? activeDataNode.equals(tree.activeDataNode)
								: tree.activeDataNode == null)
						&& allowActiveDataNodes == tree.allowActiveDataNodes
						&& currentChildIndex == tree.currentChildIndex
						&& childExemplars.equals(tree.childExemplars);
			}
		}

		return equalVal;
	}

	/**
	 * <p>
	 * This operation returns the hashcode value of the TreeComposite. It does
	 * not include the parent and sibling references when computing the
	 * hashcode.
	 * </p>
	 * 
	 * @return
	 * 		<p>
	 *         The hashcode.
	 *         </p>
	 */
	@Override
	public int hashCode() {

		// Local Declarations
		int hash = 8;

		// Compute the hashcode
		hash = 31 * super.hashCode();
		hash = 31 * hash + children.hashCode();
		hash = 31 * hash + dataNodes.hashCode();
		hash = 31 * hash
				+ ((activeDataNode != null) ? activeDataNode.hashCode() : 0);
		hash = 31 * hash + (allowActiveDataNodes ? 1 : 0);
		hash = 31 * hash + currentChildIndex;
		hash = 31 * hash + childExemplars.hashCode();

		return hash;
	}

	/**
	 * <p>
	 * This operation performs a deep copy of the attributes of another
	 * TreeComposite into the current TreeComposite. It copies ALL of the
	 * children of the TreeComposite, data and child nodes alike.
	 * </p>
	 * 
	 * @param otherTreeComposite
	 *            <p>
	 *            The other TreeComposite from which information should be
	 *            copied.
	 *            </p>
	 */
	public void copy(TreeComposite otherTreeComposite) {
		copy(otherTreeComposite, false);
	}

	/**
	 * <p>
	 * This operation performs a deep copy of the attributes of another
	 * TreeComposite into the current TreeComposite. It copies ALL of the
	 * children of the TreeComposite, data and child nodes alike.
	 * 
	 * This version of the copy method is tailored specifically for instances of
	 * TreeComposites that can be "copied in place" in a TreeComposite structure
	 * with multiple levels (ie. when copying data into a TreeComposite which
	 * isn't the most top-level node, so retaining familial references is
	 * crucial for other tasks). If the copyInPlace flag is set to true, parent
	 * and sibling references are not set to null, and only children and data is
	 * copied over.
	 * </p>
	 * 
	 * @param otherTreeComposite
	 *            <p>
	 *            The other TreeComposite from which information should be
	 *            copied.
	 *            </p>
	 * @param copyInPlace
	 *            <p>
	 *            A boolean flag to indicate if the TreeComposite should be
	 *            "copied in place" (ie. retain parent and sibling references).
	 *            Setting this to true will keep all existing wiring in place.
	 *            </p>
	 */
	public void copy(TreeComposite otherTreeComposite, boolean copyInPlace) {

		// If null, return
		if (otherTreeComposite == null) {
			return;
		}

		// We need to temporarily unregister all listeners. This has two
		// benefits/purposes:
		// (1) The listeners are not notified during the copy operation.
		// (2) The listeners are completely unregistered from old components.

		// Create a backup of the listeners, then unregister from all of them.
		List<IUpdateableListener> listenersCopy = new ArrayList<IUpdateableListener>(
				listeners);
		for (IUpdateableListener listener : listenersCopy) {
			unregister(listener);
		}
		// Copy ICEObject contents
		super.copy(otherTreeComposite);

		// Copy contents - look at differences between "shallow", "deep", and
		// nullaries

		// If we aren't "copying in place", then set the familial references
		// to null
		if (!copyInPlace) {
			// Due to references on parent, these have to be null
			this.parent = null;
			this.nextSibling = null;
			this.previousSibling = null;
		}

		// Clear the list of children to prepare for a deep copy
		this.children.clear();

		// Performs a deep copy. Please note that children's parents are reset!
		for (int i = 0; i < otherTreeComposite.children.size(); i++) {

			this.children.add(
					(TreeComposite) otherTreeComposite.children.get(i).clone());
			// Reset parent
			this.children.get(i).setParent(this);
		}

		// Reset links for siblings
		for (int j = 0; j < otherTreeComposite.children.size() - 1; j++) {
			this.children.get(j).nextSibling = this.children.get(j + 1);
		}
		for (int j = otherTreeComposite.children.size() - 1; j > 0; j--) {
			this.children.get(j).previousSibling = this.children.get(j - 1);
		}

		// This is numerical and acceptable
		this.currentChildIndex = otherTreeComposite.currentChildIndex;

		// Deep copy dataNodes
		this.dataNodes.clear();
		this.activeDataNode = null;
		this.allowActiveDataNodes = otherTreeComposite.allowActiveDataNodes;
		for (int i = 0; i < otherTreeComposite.dataNodes.size(); i++) {
			// Get the next data node and a clone of it to go in this tree.
			Component dataNode = otherTreeComposite.dataNodes.get(i);
			Component clone = (Component) ((ICEObject) dataNode).clone();
			// Add the clone to this tree's set of data nodes.
			this.dataNodes.add(clone);
			// Synchronize the active data node with the other tree's active
			// data node if the cloned data node is the active one.
			if (dataNode == otherTreeComposite.activeDataNode) {
				this.activeDataNode = clone;
			}
		}

		// Copy activity marker
		this.active = otherTreeComposite.active;

		// Copy the exemplars
		this.childExemplars.clear();
		for (int i = 0; i < otherTreeComposite.childExemplars.size(); i++) {
			this.childExemplars
					.add((TreeComposite) otherTreeComposite.childExemplars
							.get(i).clone());
		}

		// Re-register with all of the listeners.
		for (IUpdateableListener listener : listenersCopy) {
			register(listener);
		}
		// Notify the listeners that this tree has changed.
		this.notifyListeners();

		return;
	}

	/**
	 * <p>
	 * This operation provides a deep copy of the TreeComposite. It clones ALL
	 * of the nodes of a TreeComposite, data and child nodes alike.
	 * </p>
	 * 
	 * @return
	 * 		<p>
	 *         The deep-copy clone of this TreeComposite.
	 *         </p>
	 */
	@Override
	public Object clone() {
		// Local Declarations
		TreeComposite treeComposite;

		// Create a new treeComposite
		treeComposite = new TreeComposite();
		treeComposite.copy(this);

		// Return the tree
		return treeComposite;

	}

	/**
	 * <p>
	 * This operation adds a list of TreeComposites that must be used to create
	 * children for this TreeComposite. If a list of allowed child nodes exists,
	 * a TreeComposite will overwrite it.
	 * </p>
	 * 
	 * @param exemplars
	 *            <p>
	 *            The set of exemplar child types ("set of exemplars").
	 *            </p>
	 */
	public void setChildExemplars(ArrayList<TreeComposite> exemplars) {

		// Check that the incoming list is valid
		if (exemplars != null) {
			childExemplars = (ArrayList<TreeComposite>) exemplars.clone();
		}

		return;
	}

	/**
	 * This method adds one TreeComposite to the list of child exemplars. If
	 * there already is an existing exemplar of the same name, it will be over-
	 * written.
	 * 
	 * @param exemplar
	 *            The child exemplar to be added to the list.
	 */
	public void addChildExemplar(TreeComposite exemplar) {

		// Local declarations
		TreeComposite currExemplar;

		// Check the input Tree is valid
		if (exemplar != null) {

			// Check if there already is a child exemplar of the same name
			for (int i = 0; i < childExemplars.size(); i++) {
				currExemplar = childExemplars.get(i);

				// If it's already in the list, remove it
				if (currExemplar.getName().equals(exemplar.getName())) {
					childExemplars.remove(i);
					break;
				}
			}

			// Add the new child exemplar
			TreeComposite cloneExemplar = (TreeComposite) exemplar.clone();
			childExemplars.add(cloneExemplar);
		}

		return;
	}

	/**
	 * <p>
	 * This operation retrieves the list of TreeComposites that must be used to
	 * create children for this TreeComposite. An individual from this set must
	 * be copied (via clone(), for example) and submitted to setNextChild() or
	 * addComponent().
	 * </p>
	 * 
	 * @return
	 * 		<p>
	 *         The set of exemplar child types ("set of exemplars").
	 *         </p>
	 */
	public ArrayList<TreeComposite> getChildExemplars() {
		return (ArrayList<TreeComposite>) childExemplars.clone();
	}

	/**
	 * <p>
	 * This operation returns true if a list of exemplar child node types has
	 * been configured and the TreeComposite can only add children of those
	 * types and false if the TreeComposite is willing to store any component.
	 * TreeComposites are configured to accept all components by default (this
	 * operation will return false, that is).
	 * </p>
	 * 
	 * @return
	 * 		<p>
	 *         True if the exemplars exist, false otherwise.
	 *         </p>
	 */
	public boolean hasChildExemplars() {
		return !childExemplars.isEmpty();
	}

	/**
	 * <p>
	 * This operation indicates if the TreeComposite is active. True if Active,
	 * false if not.
	 * </p>
	 * 
	 * @return
	 * 		<p>
	 *         True if Active, false if not
	 *         </p>
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * <p>
	 * This operation sets specifies whether or not the TreeComposite is active.
	 * True for active, false if not.
	 * </p>
	 * 
	 * @param flag
	 *            <p>
	 *            True if Active, false if not
	 *            </p>
	 */
	public void setActive(boolean flag) {
		active = flag;

		notifyListeners();

		return;
	}

	/**
	 * This operation adds a data node to the list. A separate operation is used
	 * because the way the data nodes are stored may be changed and that can be
	 * encapsulated here. This operation also registers the listeners with the
	 * new data node.
	 * 
	 * @param comp
	 *            The component to be added to the list
	 */
	private void addDataNodeToList(Component comp) {

		// Add the component to the list
		dataNodes.add(comp);
		// Register the listeners
		for (IUpdateableListener listener : listeners) {
			comp.register(listener);
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Component#accept(IComponentVisitor visitor)
	 */
	@Override
	public void accept(IComponentVisitor visitor) {

		// Tell the visitor that this is a tree
		if (visitor != null) {
			visitor.visit(this);
		}
		return;

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Composite#addComponent(Component child)
	 */
	@Override
	public void addComponent(Component child) {

		// Visit the component if it is not equal to null. It will be sorted by
		// the visitation routines and all of the current listeners will be
		// registered with it.
		if (child != null) {
			child.accept(this);
			// Notify any listeners
			notifyListeners();
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Composite#removeComponent(int childId)
	 */
	@Override
	public void removeComponent(int childId) {

		// Linear searches are fine for this operation because both the number
		// of children and the number of data components should be very low. In
		// both loops we return early to avoid searching everything.

		// Search the data nodes first.
		for (int i = 0; i < dataNodes.size(); i++) {
			Component component = dataNodes.get(i);
			if (component.getId() == childId) {
				dataNodes.remove(i);
				// Unregister all listeners from the removed data node.
				for (IUpdateableListener listener : listeners) {
					component.unregister(listener);
				}
				// Notify any listeners
				notifyListeners();
				return;
			}
		}

		// Search the children next.
		for (int i = 0; i < children.size(); i++) {
			TreeComposite child = children.get(i);
			if (child.getId() == childId) {
				removeChild(child);
				// Notify any listeners
				notifyListeners();
				return;
			}
		}

		return;

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Composite#getComponent(int childId)
	 */
	@Override
	public Component getComponent(int childId) {

		// Everything should have an id greater than 0.
		if (childId < 1) {
			return null;
		}
		// Linearly search the data nodes
		for (Component comp : dataNodes) {
			if (comp.getId() == childId) {
				return comp;
			}
		}

		// If that didn't find it, search the children
		for (Component comp : children) {
			if (comp.getId() == childId) {
				return comp;
			}
		}

		return null;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Composite#getNumberOfComponents()
	 */
	@Override
	public int getNumberOfComponents() {
		return dataNodes.size() + children.size();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Composite#getComponents()
	 */
	@Override
	public ArrayList<Component> getComponents() {

		// Create a new list that contains the data nodes.
		ArrayList<Component> componentList = new ArrayList<Component>(
				dataNodes);
		// Add all of the TreeComposite children.
		componentList.addAll(children);

		return componentList;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IComponentVisitor#visit(DataComponent component)
	 */
	@Override
	public void visit(DataComponent component) {

		// Make sure the component is real before adding it.
		if (component != null) {
			// Add the DC and register listeners with it
			addDataNodeToList(component);
			// DataComponent also need their Entries to have listeners
			// registered
			for (IEntry entry : component.retrieveAllEntries()) {
				for (IUpdateableListener listener : listeners) {
					entry.register(listener);
				}
			}
		}

		return;

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IComponentVisitor#visit(ResourceComponent component)
	 */
	@Override
	public void visit(ResourceComponent component) {

		// Make sure the component is real before adding it.
		if (component != null) {
			addDataNodeToList(component);
		}

		return;

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IComponentVisitor#visit(TableComponent component)
	 */
	@Override
	public void visit(TableComponent component) {

		// Make sure the component is real before adding it.
		if (component != null) {
			addDataNodeToList(component);
		}

		return;

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IComponentVisitor#visit(MatrixComponent component)
	 */
	@Override
	public void visit(MatrixComponent component) {

		// Make sure the component is real before adding it.
		if (component != null) {
			addDataNodeToList(component);
		}

		return;

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IComponentVisitor#visit(GeometryComponent component)
	 */
	@Override
	public void visit(GeometryComponent component) {

		// Make sure the component is real before adding it.
		if (component != null) {
			addDataNodeToList(component);
		}

		return;

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IComponentVisitor#visit(MasterDetailsComponent component)
	 */
	@Override
	public void visit(MasterDetailsComponent component) {

		// Make sure the component is real before adding it.
		if (component != null) {
			addDataNodeToList(component);
		}

		return;

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IComponentVisitor#visit(TreeComposite component)
	 */
	@Override
	public void visit(TreeComposite component) {

		// Make sure the component is real before adding it.
		if (component != null) {
			// Add it as a child
			setNextChild(component);
		}

		return;

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IComponentVisitor#visit(IReactorComponent component)
	 */
	@Override
	public void visit(IReactorComponent component) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ice.datastructures.componentVisitor.IComponentVisitor#visit
	 * (org.eclipse.ice.datastructures.form.TimeDataComponent)
	 */
	@Override
	public void visit(TimeDataComponent component) {

		// Make sure the component is real before adding it.
		if (component != null) {
			// Add it as a child
			addDataNodeToList(component);
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IComponentVisitor#visit(AdaptiveTreeComposite component)
	 */
	@Override
	public void visit(AdaptiveTreeComposite component) {
		// TODO Auto-generated method stub

	}

	/**
	 * Override the register operation so that listeners are also registered
	 * with all
	 * 
	 * @see IUpdateable#register(IUpdateableListener listener)
	 */
	@Override
	public void register(IUpdateableListener listener) {

		// Register the listener if it is not null
		if (listener != null) {
			listeners.add(listener);

			// Register the listener with all data nodes.
			for (Component component : dataNodes) {
				component.register(listener);
			}
			// Recursively register the listener with all children.
			for (TreeComposite child : children) {
				child.register(listener);
			}
		}

		return;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IUpdateable#unregister(IUpdateableListener listener)
	 */
	@Override
	public void unregister(IUpdateableListener listener) {

		// Unregister the listener if it is not null and in the list
		if (listener != null && listeners.contains(listener)) {
			listeners.remove(listener);

			// Unregister the listener from all data nodes.
			for (Component component : dataNodes) {
				component.unregister(listener);
			}
			// Recursively unregister the listener from all children.
			for (TreeComposite child : children) {
				child.unregister(listener);
			}
		}
		return;
	}

	@Override
	public void visit(EMFComponent component) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(ListComponent component) {
		// TODO Auto-generated method stub

	}

}
