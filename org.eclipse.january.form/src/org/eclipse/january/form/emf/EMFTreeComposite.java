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
package org.eclipse.january.form.emf;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.january.form.DataComponent;
import org.eclipse.january.form.TreeComposite;

/**
 * 
 * The EMFTreeComposite is a subclass of TreeComposite that represents a tree node in
 * an Eclipse Modeling Framework Ecore model tree. To do that, it takes as input
 * the EClass metadata representing the corresponding model tree node, and from
 * that creates an actual EObject instance. From this data, the EMFTreeComposite
 * can construct an active data node (DataComponent) that contains EMFEntrys
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
	 */
	@XmlTransient
	private EObject ecoreNode;

	/**
	 * Reference to the EClass metadata corresponding to the ecoreNode EObject
	 * instance. This object gives information about the EStructuralFeatures
	 * (EAttributes and EReferences) of the ecoreNode EObject.
	 */
	@XmlTransient
	private EClass ecoreNodeMetaData;

	/**
	 * The nullary-constructor
	 */
	public EMFTreeComposite() {
		super();
		setName("Null Constructed EMFTreeComposite");
		setDescription(toString());
		return;
	}

	/**
	 * The constructor, takes a Ecore model tree EClass metadata object.
	 * 
	 * @param eClass
	 */
	public EMFTreeComposite(EClass eClass) {
		super();
		// Set the data
		if (eClass != null) {
			ecoreNodeMetaData = eClass;
			ecoreNode = EcoreUtil.create(ecoreNodeMetaData);
			setName(ecoreNodeMetaData.getName());
			setDescription(toString());

			// Create the active DataComponent
			createActiveDataNode();
		}

		return;
	}

	/**
	 * The constructor, takes a Ecore model tree EObject node instance
	 * 
	 * @param treeNode
	 */
	public EMFTreeComposite(EObject treeNode) {
		super();
		// Set the data
		ecoreNode = treeNode;
		ecoreNodeMetaData = ecoreNode.eClass();
		setName(ecoreNodeMetaData.getName());
		setDescription(toString());

		// Create the active DataComponent
		createActiveDataNode();

		return;
	}

	/**
	 * This method reads through this ECore node's EAttributes and creates an
	 * active DataComponent data node from them.
	 */
	private void createActiveDataNode() {
		// Local Declarations
		int id = 0;
		DataComponent data = new DataComponent();

		// Loop over all the EStructuralFeatures and pick out
		// the EAttributes to create Entries.
		for (EAttribute a : ecoreNodeMetaData.getEAllAttributes()) {
			if (!"mixed".equals(a.getName())) {
				// Create the EMFEntry to add to the DataComponent
				EMFEntry entry = new EMFEntry(a, ecoreNode);
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
	 * This method overrides TreeComposite.getChildExemplars to dynamically
	 * generate a list of exemplar children based on the EClass metadata's list
	 * of EReferences.
	 * 
	 * @return
	 */
	@Override
	public ArrayList<TreeComposite> getChildExemplars() {
		ArrayList<TreeComposite> exemplars = new ArrayList<TreeComposite>();
		boolean childExists = false;

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

		for (EReference exemplar : ecoreNodeMetaData.getEAllReferences()) { // BUG, need getE(ALL)References...

			// We don't want to use any of these types. 
			if ("EStringToStringMapEntry".equals(exemplar.getEReferenceType()
					.getName())) {
				continue;
			}

			// Get the upper bound
			int upperBound = exemplar.getUpperBound();

			// If -1, it is unbounded.
			if (upperBound == -1) {
				exemplars
						.add(new EMFTreeComposite(exemplar.getEReferenceType()));
				continue;
			} else if (upperBound <= 1) {

				// Loop through the children, if the current possible exemplar
				// has the
				// same name as one of this tree's children, then do not add it
				// to the exemplar list.
				for (TreeComposite currentChild : children) {
					if (currentChild.getName().equals(
							exemplar.getEReferenceType().getName())) {
						childExists = true;
						break;
					}
				}

				// If we didn't find an already existing child, then add it
				if (!childExists) {
					exemplars.add(new EMFTreeComposite(exemplar
							.getEReferenceType()));
				}

			}

		}
		return exemplars;
	}

	/**
	 * Return the EObject tree node corresponding to this EMFTreeComposite.
	 * 
	 * @return the EObject representing the root node of this tree
	 */
	public EObject getEcoreNode() {
		return ecoreNode;
	}

	/**
	 * Return the EClass metadata object corresponding to this EMFTreeComposite.
	 * 
	 * @return
	 */
	public EClass getEcoreMetaData() {
		return ecoreNodeMetaData;
	}

	/**
	 * This method overrides TreeComposite.setNextChild to allow more than one
	 * of the same child TreeComposite to be added to this EMFTreeComposite and
	 * append a Ecore child Exemplar EObject to the containingNode EObject.
	 * 
	 * @param cNode
	 */
	@Override
	public void setNextChild(TreeComposite cNode) {

		// Local Declarations
		EMFTreeComposite castedTree;
		EReference exemplar;
		int currentSize = children.size();

		// Set the next child. This will use our custom checkExemplars method
		super.setNextChild(cNode);

		// Check if we successfully added a child
		if (currentSize == children.size()) {
			logger.info("Could not add " + cNode.getName()
					+ " as child of " + getName());
			return;
		}

		castedTree = (EMFTreeComposite) cNode;

		// EObject newObj = EcoreUtil.create(castedTree.ecoreNodeMetaData);

		// We need to figure out which child exemplar this child node
		// corresponds to.
		exemplar = getEReferenceExemplar(castedTree.getName());

		if (exemplar != null) {
			if (exemplar.getUpperBound() != -1) {
				ecoreNode.eSet(exemplar, castedTree.ecoreNode);
			} else {
				((EList<EObject>) ecoreNode.eGet(exemplar))
						.add(castedTree.ecoreNode);
			}
		}

		// We have to update the Containing EObject, and
		// corresponding EMFEntries that use it, on
		// the newly added child cNode.
		castedTree.updateContainingNode(castedTree.ecoreNode);
	}

	/**
	 * This method returns an EReference exemplar child of this EClass node c
	 * corresponding to the given String name.
	 * 
	 * @param treeName
	 * @return
	 */
	private EReference getEReferenceExemplar(String treeName) {
		for (EReference ref : this.ecoreNodeMetaData.getEReferences()) {
			if (treeName.equals(ref.getEReferenceType().getName())) {
				return ref;
			}
		}

		return null;
	}

	/**
	 * This method overrides TreeComposite.checkExemplars to use the overridden
	 * getChildExemplars method to see if a given TreeComposite can be added as
	 * a new child of this tree.
	 * 
	 * @param cNode
	 * @return
	 */
	@Override
	protected boolean checkExemplars(TreeComposite cNode) {

		// Loop over all exemplars and see if this cNode is compatible
		for (TreeComposite exemplar : getChildExemplars()) {
			if (cNode.getName().equals("DefinitionType")) {
				logger.info("Exemplar: " + exemplar.getName());
			}
			if (cNode.getName().equals(exemplar.getName())) {
				return true;
			}
		}

		return false;
	}

	/**
	 * This method overrides TreeComposite.hasChildExemplars to use the
	 * overridden getChildExemplars method to return whether or not this tree
	 * has child exemplars.
	 * 
	 * @return
	 */
	@Override
	public boolean hasChildExemplars() {
		return !getChildExemplars().isEmpty();
	}

	/**
	 * Update the EObject node and the EMFEntries corresponding to that EObjects
	 * contained EAttributes.
	 * 
	 * @param newEcoreChild
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
		for (EAttribute a : ecoreNode.eClass().getEAllAttributes()) {
			dataComp.addEntry(new EMFEntry(a, ecoreNode));
		}

		// Set the active data node data.
		allowActiveDataNodes(true);
		setActiveDataNode(dataComp);
	}

	/**
	 * This method overrides TreeComposite.removeChild to also remove the
	 * corresponding EObject child node.
	 * 
	 * @param cNode
	 */
	@Override
	public void removeChild(TreeComposite cNode) {
		// Local Declarations
		EStructuralFeature childStructuralFeature = null;
		int currentSize = children.size();

		// Remove the TreeComposite from this TreeComposite
		super.removeChild(cNode);

		// If it worked...
		if (currentSize != children.size()) {

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
	 * This operation is used to check equality between the EMFTreeComposite and
	 * another EMFTreeComposite. It returns true if the EMFTreeComposites are
	 * equal and false if they are not.
	 */
	@Override
	public boolean equals(Object otherTreeComposite) {
		return super.equals(otherTreeComposite);
	}

	/**
	 * This operation returns the hashcode value of the EMFTreeComposite. It
	 * does not include the parent and sibling references when computing the
	 * hashcode.
	 * 
	 * @return
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * Sets the ECore node meta data
	 * 
	 * @param metaData : The meta data to set
	 */
	public void setECoreNodeMetaData(EClass metaData) {
		ecoreNodeMetaData = metaData;
	}
	
	/**
	 * This operation performs a deep copy of the attributes of another
	 * EMFTreeComposite into the current EMFTreeComposite. It copies ALL of the
	 * children of the EMFTreeComposite, data and child nodes alike.
	 * 
	 * @param otherTreeComposite
	 */
	public void copy(EMFTreeComposite otherTreeComposite) {

		// If null, return
		if (otherTreeComposite == null) {
			return;
		}

		if (otherTreeComposite.ecoreNodeMetaData != null) {
			ecoreNodeMetaData = otherTreeComposite.ecoreNodeMetaData;
			ecoreNode = EcoreUtil.create(ecoreNodeMetaData);
		}
		super.copy(otherTreeComposite, true);

		return;
	}

	/**
	 * This operation provides a deep copy of the TreeComposite. It clones ALL
	 * of the nodes of a TreeComposite, data and child nodes alike.
	 */
	@Override
	public Object clone() {
		// Local Declarations
		EMFTreeComposite emfTreeComposite = new EMFTreeComposite();

		// Copy this EMFTreeComposite
		emfTreeComposite.copy(this);

		// Return the tree
		return emfTreeComposite;
	}

}
