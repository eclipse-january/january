/*******************************************************************************
 * Copyright (c) 2012, 2014 UT-Battelle, LLC.
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
package org.eclipse.ice.datastructures.form.emf;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.eclipse.ice.datastructures.ICEObject.ICEJAXBManipulator;
import org.eclipse.ice.datastructures.form.AdaptiveTreeComposite;
import org.eclipse.ice.datastructures.form.DataComponent;
import org.eclipse.ice.datastructures.form.TreeComposite;
import org.eclipse.ice.datastructures.form.emf.EMFEntry;
import org.eclipse.ice.datastructures.updateableComposite.IUpdateableListener;

/**
 * 
 * The EMFTreeComposite is a subclass of TreeComposite that represents a node in
 * an Eclipse Modeling Framework Ecore model tree. To do that, it takes as input
 * the EClass metadata representing the corresponding model tree, and from that
 * creates an actual EObject instance. From this data, the EMFTreeComposite can
 * construct an active data node (DataComponent) that contains EMFEntries
 * corresponding to the EAttributes within the EClass metadata's
 * EStructuralFeatures. This data node can then be shown to the users in the
 * same way a regular TreeComposite does.
 * 
 * Additionally, since a TreeComposite can have child exemplars, so too can the
 * underlying Ecore model tree. To keep the model in sync, EMFTreeComposite
 * keeps track of the list of EClass EReferences that allow it to correctly add
 * and remove Ecore model nodes whenever a new child is added to this
 * TreeComposite.
 * 
 * @author Alex McCaskey
 * 
 */
@XmlRootElement(name = "EMFTreeComposite")
@XmlAccessorType(XmlAccessType.FIELD)
public class EMFTreeComposite extends TreeComposite {

	/**
	 * Reference to the Ecore model object that is the actual tree node instance
	 * and has sub-children. This reference is used and manipulated to keep the
	 * TreeComposite data in sync with the Ecore model tree.
	 * 
	 */
	@XmlTransient
	private EObject ecoreNode;

	/**
	 * Reference to the EClass metadata corresponding to the ecoreNode EObject
	 * instance. This object gives information about the EStructuralFeatures
	 * (EAttributes and EReferences) of the ecoreNode EObject.
	 * 
	 */
	@XmlTransient
	private EClass ecoreNodeMetaData;

	private boolean canModifyEcore = true;

	/**
	 * The nullary-constructor
	 * 
	 */
	public EMFTreeComposite() {
		super();
		setName("Null Constructed EMFTreeComposite");
		setDescription(toString());
		return;
	}

	/**
	 * The constructor, takes a Ecore model tree EClass metadata object.
	 */
	public EMFTreeComposite(EClass eClass) {
		super();
		// Set the data
		if (eClass != null) {
			ecoreNodeMetaData = eClass;
			ecoreNode = EcoreUtil.create(ecoreNodeMetaData);
			setName(ecoreNodeMetaData.getName());
			setDescription(toString());
			
			// Create the active DataComponent and
			// set up this TreeComposites exemplar children
			createActiveDataNode(true);
			createChildExemplars(false);
		}
		return;
	}

	public EMFTreeComposite(EClass eClass, boolean createExemplars) {
		super();
		// Set the data
		ecoreNodeMetaData = eClass;
		if (eClass != null) {
			ecoreNode = EcoreUtil.create(ecoreNodeMetaData);
			setName(ecoreNodeMetaData.getName());
			setDescription(toString());
			
			// Create the active DataComponent and
			// set up this TreeComposites exemplar children
			createActiveDataNode(true);
			if (createExemplars) {
				createChildExemplars(false);
			}
		}

	}

	/**
	 * The constructor, takes a Ecore model tree EObject node instance
	 */
	public EMFTreeComposite(EObject treeNode) {
		super();
		// Set the data
		ecoreNode = treeNode;
		ecoreNodeMetaData = ecoreNode.eClass();
		setName(ecoreNodeMetaData.getName());
		setDescription(toString());
		
		// Create the active DataComponent and
		// set up this TreeComposites exemplar children
		createActiveDataNode(false);

		// If we are constructing from an Ecore EObject,
		// we want to preserve the links already in that tree
		// so set this flag during construction
		canModifyEcore = false;

		return;
	}

	/**
	 * This method reads through this ECore node's EAttributes and creates an
	 * active DataComponent data node from them.
	 */
	private void createActiveDataNode(boolean initializeDefaults) {
		// Local Declarations
		int id = 0;
		DataComponent data = new DataComponent();

		// Loop over all the EStructuralFeatures and pick out
		// the EAttributes to create Entries.
		for (EAttribute a : ecoreNodeMetaData.getEAllAttributes()) {
			if (!"mixed".equals(a.getName())) {
				// Create the EMFEntry to add to the DataComponent
				EMFEntry entry = new EMFEntry(a, ecoreNode, initializeDefaults);
				entry.setId(id++);

				// Add the Entry to the DataComponent and
				// register this EMFTreeComposite as a listener
				data.addEntry(entry);
			}
		}

		// Set the name and description for the DataComponent
		data.setName(ecoreNodeMetaData.getName() + " Data");
		data.setDescription("Please set all required data pertinent to "
				+ ecoreNodeMetaData.getName() + ".");

		// Set the DataComponent as the active data node.
		allowActiveDataNodes(true);
		addComponent(data);
		setActiveDataNode(data);

	}

	/**
	 * This method reads through this ECore node's EReferences and creates a set
	 * of exemplar children from them.
	 */
	private void createChildExemplars(boolean useEObjectConstructor) {
		// Set the child exemplars
		for (EReference ref : ecoreNodeMetaData.getEAllReferences()) {
			if (!ref.getEReferenceType().getName()
					.equals("EStringToStringMapEntry")) {
				// FIXME MAY NEED TO SEARCH THE LIST FOR DUPLICATES
				if (useEObjectConstructor) {
					childExemplars.add(new EMFTreeComposite(EcoreUtil
							.create(ref.getEReferenceType())));
				} else {
					childExemplars.add(new EMFTreeComposite(ref
							.getEReferenceType()));
				}
			}
		}
	}

	/**
	 * Return the EObject tree node corresponding to this EMFTreeComposite.
	 * 
	 */
	public EObject getEcoreNode() {
		return ecoreNode;
	}

	/**
	 * Return the EClass metadata object corresponding to this EMFTreeComposite.
	 */
	public EClass getEcoreMetaData() {
		return ecoreNodeMetaData;
	}

	/**
	 * This method overrides TreeComposite.setNextChild to allow more than one
	 * of the same child TreeComposite to be added to this EMFTreeComposite and
	 * append a Ecore child Exemplar EObject to the containingNode EObject.
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void setNextChild(TreeComposite cNode) {
		// begin-user-code

		// Local Declarations
		EMFTreeComposite lastChild = null;
		EReference exemplar = null;

		// Get the Ecore Exemplar corresponding to this cNode
		for (EReference ref : ecoreNodeMetaData.getEAllReferences()) {
			if (ref.getEReferenceType().getName().equals(cNode.getName())) {
				exemplar = ref;

				// Here are the rules here:
				// (1) Upper bound could be 1, in which case we can only
				// have 1 of that particular node in the tree, so we search here
				// to make sure it hasn't already been added
				// (2) The bound could be -1, in which case we can have as many
				// of
				// these nodes as the user wants, so no need to search here and
				// just let clients add a new child
				// (3) The bound could be -2, which is weird, but it means
				// unspecified,
				// so just treat it like (1).
				if (exemplar.getUpperBound() <= 1
						&& exemplar.getUpperBound() != -1) {
					for (TreeComposite c : children) {
						if (c.getName().equals(
								exemplar.getEReferenceType().getName())) {
							return;
						}
					}
				}

				break;
			}
		}

		// Only add the child if it is not null is part of the
		// exemplar list
		if (exemplar != null && cNode != null && cNode != this
				&& hasChildExemplars()) { // checkExemplars(cNode)) {
			// Set the sibling links if there is more than one child in the list
			if (!children.isEmpty()) {
				// Get the last child in the list
				lastChild = (EMFTreeComposite) children
						.get(children.size() - 1);
				// Set the next sibling link for the current child at the end of
				// the list to the new child.
				lastChild.setTreeReference(cNode, "nextSibling");
				// Set the previous sibling link for the new child to the
				// current child at the end of the list.
				// It doesn't have a next sibling
				// since it is at the end of the list.
				((EMFTreeComposite) cNode).setTreeReference(lastChild,
						"previousSibling");
			}

			// Add the node to the end of the list.
			children.add(cNode);
			// Set the parent reference for the child
			((EMFTreeComposite) cNode).setTreeReference(this, "parent");

			// Register the listeners with this child
			for (IUpdateableListener listener : listeners) {
				cNode.register(listener);
			}

			if (canModifyEcore) {
				// Now that we have the new EObject child Ecore
				// exemplar, we can add it to our containingNode
				EObject newObj = EcoreUtil.create(((EMFTreeComposite) cNode)
						.getEcoreMetaData());

				if (exemplar.getUpperBound() != -1) {
					ecoreNode.eSet(exemplar, newObj);
				} else {
					((EList<EObject>) ecoreNode.eGet(exemplar)).add(newObj);
				}

				// We have to update the Containing EObject, and
				// corresponding EMFEntries that use it, on
				// the newly added child cNode.
				((EMFTreeComposite) cNode).updateContainingNode(newObj);
			}
			// Notify any listeners that a this tree was changed
			notifyListeners();
		}

		return;

		// end-user-code
	}

	public void canModifyEcore(boolean canModify) {
		canModifyEcore = canModify;
	}

	/**
	 * Update the EObject node and the EMFEntries corresponding to that EObjects
	 * contained EAttributes.
	 * 
	 */
	public void updateContainingNode(EObject newEcoreChild) {
		// Get the Active Data Node, there should just be one
		// Clear its Entries since we need to start anew
		// with EMFEntries that point to the correct containing Ecore node
		DataComponent dataComp = (DataComponent) getDataNodes().get(0);
		dataComp.clearEntries();

		ecoreNode = newEcoreChild;

		// Loop over the new Ecore Node's attributes and
		// create a EMFEntry for each
		for (EAttribute a : newEcoreChild.eClass().getEAllAttributes()) {
			dataComp.addEntry(new EMFEntry(a, newEcoreChild));
		}

		// Set the active data node data.
		allowActiveDataNodes(true);
		setActiveDataNode(dataComp);
	}

	/**
	 * This method overrides TreeComposite.removeChild to also remove the
	 * corresponding EObject child node.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void removeChild(TreeComposite cNode) {
		// Local Declarations
		EStructuralFeature childStructuralFeature = null;

		// Remove the TreeComposite from this TreeComposite
		super.removeChild(cNode);

		// If it worked...
		if (!children.contains(cNode)) {

			// Get the EStructuralFeature that we are removing
			for (EStructuralFeature feature : ecoreNodeMetaData
					.getEStructuralFeatures()) {
				if (feature.getEType().getName().equals(cNode.getName())) {
					childStructuralFeature = feature;
				}
			}

			// Remove it.
			((EList<EObject>) ecoreNode.eGet(childStructuralFeature))
					.remove(((EMFTreeComposite) cNode).getEcoreNode());
		}

		return;
	}

	/**
	 * This is a utility method, and kind of a hack, for setting the actual
	 * references for the TreeComposite's next and previous siblings, and the
	 * parent. Someone else may have a better way to do this in setNextChild.
	 * 
	 */
	protected void setTreeReference(TreeComposite node, String reference) {
		if (reference.equals("nextSibling")) {
			nextSibling = node;
		} else if (reference.equals("previousSibling")) {
			previousSibling = node;
		} else if (reference.equals("parent")) {
			parent = node;
		}

		return;
	}

	/**
	 * This operation is used to check equality between the EMFTreeComposite and
	 * another EMFTreeComposite. It returns true if the EMFTreeComposites are
	 * equal and false if they are not.
	 * 
	 */
	@Override
	public boolean equals(Object otherTreeComposite) {
		// begin-user-code

		// It is extremely difficult to check for equality
		// between these Ecore objects, so for now
		// I'm just gonna assume if the TreeComposite parts are
		// equal, then the EMFTreeComposites are equal.
		return super.equals(otherTreeComposite);
		// Local Declarations
		// boolean equalVal = false;
		// EMFTreeComposite tree = null;
		//
		// // Make sure we are dealing with a legitimate TreeComposite
		// if (otherTreeComposite != null
		// && (otherTreeComposite instanceof EMFTreeComposite)) {
		//
		// // See if they are the same reference
		// if (this == otherTreeComposite) {
		// equalVal = true;
		// } else {
		// tree = (EMFTreeComposite) otherTreeComposite;
		// equalVal = super.equals(tree) &&
		// EcoreUtil.equals(ecoreNode, tree.ecoreNode);
		// // EcoreUtil.equals(containingNode, tree.containingNode)
		// // && EcoreUtil
		// // .equals(ecoreExemplars, tree.ecoreExemplars)
		// // super.equals(tree);
		// }
		// }
		//
		// return equalVal;
		// end-user-code
	}

	/**
	 * This operation returns the hashcode value of the EMFTreeComposite. It
	 * does not include the parent and sibling references when computing the
	 * hashcode.
	 * 
	 */
	@Override
	public int hashCode() {
		// begin-user-code

		// Local Declarations
		int hash = 8;

		// Compute the hashcode
		hash = 31 * hash + super.hashCode();

		return hash;
		// end-user-code
	}

	/**
	 * This operation performs a deep copy of the attributes of another
	 * EMFTreeComposite into the current EMFTreeComposite. It copies ALL of the
	 * children of the EMFTreeComposite, data and child nodes alike.
	 * 
	 */
	public void copy(EMFTreeComposite otherTreeComposite) {
		// begin-user-code

		// If null, return
		if (otherTreeComposite == null) {
			return;
		}

		// Copy this EMFTree's stuff

		// Copy the rest
		super.copy((TreeComposite) otherTreeComposite, true);

		return;
		// end-user-code
	}

	/**
	 * This operation provides a deep copy of the TreeComposite. It clones ALL
	 * of the nodes of a TreeComposite, data and child nodes alike.
	 * 
	 */
	@Override
	public Object clone() {
		// begin-user-code
		// Local Declarations
		EMFTreeComposite emfTreeComposite = new EMFTreeComposite(
				ecoreNodeMetaData, false);

		emfTreeComposite.copy(this);

		// Return the tree
		return emfTreeComposite;
		// end-user-code
	}

	/**
	 * This method overloads the
	 * {@link org.eclipse.ice.datastructures.ICEObject#loadFromXML(InputStream)
	 * ICEObject.loadFromXML(...)} method to properly load the EMFTreeComposite.
	 * 
	 * @param inputStream
	 *            <p>
	 *            The InputStream containing XML from which the
	 *            AdaptiveTreeComposite should be loaded.
	 *            </p>
	 */
	@Override
	public void loadFromXML(InputStream inputStream) {

		// Initialize JAXBManipulator
		jaxbManipulator = new ICEJAXBManipulator();

		// Call the read() on jaxbManipulator to create a new Object instance
		// from the inputStream
		Object dataObject;
		try {
			dataObject = jaxbManipulator.read(this.getClass(), inputStream);
			// Copy contents of new object into current data structure
			this.copy((EMFTreeComposite) dataObject);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Nullerize jaxbManipilator
		jaxbManipulator = null;

		return;
	}

	/** THIS IS FOR DEBUGGING **/
	public void printEcoreTree(XMLProcessor processor) {

		XMLResource resource = new XMLResourceImpl();

		resource.getContents().add(ecoreNode);

		String xmlString = "";
		try {
			xmlString = processor.saveToString(resource, null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(xmlString);
	}

	public void createExemplarsBasedOnEClass() {
		// TODO Auto-generated method stub
		for (EReference ref : ecoreNodeMetaData.getEAllReferences()) {
			if (!ref.getEReferenceType().getName()
					.equals("EStringToStringMapEntry")) {
				childExemplars.add(new EMFTreeComposite(
						ref.getEReferenceType(), false));
			}
		}
	}

}
