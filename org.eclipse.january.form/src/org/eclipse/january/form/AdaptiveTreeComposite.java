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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class extends {@link TreeComposite} to create TreeComposites that have
 * adaptive properties based on a currently selected type. This class maintains
 * a map of all available TreeComposites (keyed on name), that the current
 * AdaptiveTreeComposite can be.
 * 
 * @author Anna Wojtowicz
 * 
 */
@XmlRootElement(name = "AdaptiveTreeComposite")
@XmlAccessorType(XmlAccessType.FIELD)
public class AdaptiveTreeComposite extends TreeComposite {

	/**
	 * The name of the current type.
	 */
	@XmlAttribute
	private String type = null;

	/**
	 * A HashMap of all possible TreeComposite types available, keyed on name.
	 * The HashMap is instantiated only if a non-null, non-empty ArrayList of
	 * TreeComposites is passed to the AdaptiveTreeComposite constructor.
	 */

	@XmlElementWrapper(name = "TypesMap")
	private HashMap<String, TreeComposite> typesMap;

	/**
	 * Nullary constructor. This is not part of the AdaptiveTreeComposite
	 * design, but is required for JAXB marshaling.
	 */
	public AdaptiveTreeComposite() {
		
		// Call the parameterized constructor with a null types list
		this(null);
		
		return;
	}
	
	
	/**
	 * Parameterized constructor.
	 * 
	 * @param types
	 *            An ArrayList of TreeComposites that the AdaptiveTreeComposite
	 *            may use as its type. The ArrayList must be both non-null AND
	 *            non-empty, otherwise the typesMap will remain uninstantiated.
	 */
	public AdaptiveTreeComposite(ArrayList<TreeComposite> types) {

		// Call the super constructor
		super();

		// Set the name, description and ID
		this.setName("Adaptive Tree Composite 1");
		this.setDescription("A TreeComposite object that can toggle its type");
		this.setId(1);

		// Check the input list is valid
		if (types != null && !types.isEmpty()) {

			// Instantiate the HashMap
			typesMap = new HashMap<String, TreeComposite>();

			// Add the list contents to the HashMap
			for (TreeComposite tree : types) {
				typesMap.put(tree.getName(), tree);
			}
		}

		return;
	}

	/**
	 * Returns the name of the current AdaptiveTreeComposite's type, or null if
	 * not set.
	 * 
	 * @return The name of this AdaptiveTreeComposite's current type.
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Sets the current type based a name String passed in. The name must be
	 * found in the HashMap of all possible types, otherwise it will leave the
	 * type as whatever it was previously. Returns a true or false to indicate
	 * if the setting was successful.
	 * 
	 * @param type
	 *            Name of the type. Must be in the AdaptiveTreeComposite's Map
	 *            of types.
	 * @return Returns a true/false indicating if the setting of the type was
	 *         successful.
	 */
	public boolean setType(String type) {

		// Local declaration
		boolean wasSuccess = false;
		TreeComposite typeTree;
		TreeComposite child = null;

		// Check the input is valid
		if (type != null && !type.isEmpty() && !type.equals(this.type)) {

			// Get the TreeComposite corresponding to the type name
			typeTree = typesMap.get(type);

			// Check if the type is in the HashMap
			if (typeTree != null) {

				// We need to temporarily unregister all listeners. This has two
				// benefits/purposes:
				// (1) The listeners are not notified during the copy operation.
				// (2) The listeners are completely unregistered from old
				// components.

				// Create a backup of the listeners, then unregister from all of
				// them.
				List<IUpdateableListener> listenersCopy = new ArrayList<IUpdateableListener>(
						listeners);
				for (IUpdateableListener listener : listenersCopy) {
					unregister(listener);
				}

				// Copy the old AdaptiveTreeComposite's name, state, type,
				// child exemplars and children. These properties will be lost
				// when the copy() method is used.
				String oldTreeName = getName();
				boolean isActive = isActive();
				String oldType = getType();
				ArrayList<TreeComposite> childExemplars = getChildExemplars();
				ArrayList<TreeComposite> children = 
						new ArrayList<TreeComposite>();
				resetChildIterator();
				while ((child = getNextChild()) != null) {
					children.add(child);
				}

				// Check if this AdaptiveTreeComposite has parameters, if it
				// does we will have to copy them over to retain any data they
				// might contain
				List<Component> oldDataNodes = getDataNodes();
				if (oldDataNodes != null && !oldDataNodes.isEmpty()) {

					// Make a copy of the current parameter data
					DataComponent oldParamData = 
							(DataComponent) oldDataNodes.get(0);

					// Set this AdaptiveTreeComposite as a copy of the typeTree
					this.type = type;
					this.copy(typeTree);

					// Get the new parameter data, put its entries in a HashMap
					List<Component> newDataNodes = getDataNodes();
					DataComponent newParamData = 
							(DataComponent) newDataNodes.get(0);
					Map<String, IEntry> newParamMap = 
							new HashMap<String, IEntry>();
					for (IEntry currEntry : newParamData.retrieveAllEntries()) {
						newParamMap.put(currEntry.getName(), currEntry);
					}
					
					// Get the old type's "standard" parameter list, also put 
					// those entries in a HashMap
					TreeComposite oldTypeTree = typesMap.get(oldType);
					HashMap<String, IEntry> oldTypeParamMap = null;
					if (oldTypeTree != null) {
						DataComponent oldTypeParameters = (DataComponent) 
								oldTypeTree.getDataNodes().get(0);
						oldTypeParamMap = new HashMap<String, IEntry>();
						for (IEntry currEntry : oldTypeParameters.retrieveAllEntries()) {
							oldTypeParamMap.put(currEntry.getName(), currEntry);
						}
					}
					
					// Iterate through the old parameter list and look for 
					// matches in the new parameter map
					for (IEntry currEntry : oldParamData.retrieveAllEntries()) {
						// Look for a match in the new parameter HashMap
						if (newParamMap.containsKey(currEntry.getName())) {
							// Copy the data into the new parameter list
							IEntry newEntry = newParamMap.get(currEntry.getName());
							boolean req = currEntry.isRequired();
							((AbstractEntry)newEntry).copy((AbstractEntry) currEntry);
							newEntry.setRequired(req);
						}
						
						// If it's not in the list and the previous type of
						// this AdaptiveTreeComposite was null (ie. never set), 
						// OR the old type's "standard" list of parameters
						// doesn't contain a match to this parameter, add this
						// parameter anyways, as it might be necessary for the 
						// simulation to run. (This can happen due to a 
						// discrepancy between old/new YAML specs and input files)
						else if (oldType == null 
								|| !oldTypeParamMap.containsKey(currEntry.getName())) {
							newParamData.addEntry(currEntry);
						}
						
						// Lastly, we must find the "type" parameter, and set
						// it's value to reflect the new adaptive type
						if ("type".equals(currEntry.getName())) {
							newParamMap.get(currEntry.getName()).setValue(type);
						}
					}
				}
				// Otherwise just set the type, don't do any extra work
				else {
					// Set this AdaptiveTreeComposite as a copy of the typeTree
					this.type = type;
					copy(typeTree);
				}

				// Set the old name, state, active data node, children and 
				// child exemplars
				setName(oldTreeName);
				setActive(isActive);
				if (getDataNodes() != null && !getDataNodes().isEmpty()) {
					setActiveDataNode(getDataNodes().get(0));
				}
				for (TreeComposite tree : children) {
					setNextChild(tree);
				}
				setChildExemplars(childExemplars);

				// Flag the operation as successful
				wasSuccess = true;

				// Re-register with all of the listeners and notify them.
				for (IUpdateableListener listener : listenersCopy) {
					register(listener);
				}
				notifyListeners();
			}
		}

		return wasSuccess;
	}

	/**
	 * Returns a list of names representing all TreeComposite types that this
	 * AdaptiveTreeComposite can take on.
	 * 
	 * @return ArrayList of all TreeComposite types associated to this
	 *         AdaptiveTreeComposite. It is null if no types are available.
	 */
	public ArrayList<String> getTypes() {
		return (typesMap != null) ? 
				new ArrayList<String>(typesMap.keySet()) : null;
	}

	/**
	 * Performs a deep copy.
	 * 
	 * @param otherObject
	 *            The AdaptiveTreeComposite to copy the contents of.
	 */
	public void copy(AdaptiveTreeComposite otherObject) {

		// Make sure other object is not null, or the same reference
		if (otherObject == null || otherObject == this) {
			return;
		}

		// Copy the type and HashMap
		typesMap = otherObject.typesMap;
		type = otherObject.type;

		// Call the super copy. This notifies listeners when it has finished.
		super.copy(otherObject);

		return;
	}

	/**
	 * Performs a deep copy and returns a newly instantiated object.
	 * 
	 * @return The newly instantiated AdaptiveTreeComposite.
	 */
	@Override
	public AdaptiveTreeComposite clone() {

		// Instantiate a new AdaptiveTreeComposite
		AdaptiveTreeComposite clonedTree = new AdaptiveTreeComposite(null);
		// Copy to the new tree
		clonedTree.copy(this);

		return clonedTree;
	}

	/**
	 * Performs an equality check between two AdaptiveTreeComposites.
	 * 
	 * @param otherObject
	 *            The other AdaptiveTreeComposite to compare against.
	 * @return Returns true if the objects are equal, otherwise false.
	 */
	@Override
	public boolean equals(Object otherObject) {

		// Local declarations
		boolean isEqual = false;

		// Check the references first
		if (this == otherObject) {
			isEqual = true;
		}

		// Check the otherObject is valid
		else if (otherObject != null
				&& otherObject instanceof AdaptiveTreeComposite) {

			// Cast it to an AdaptiveTreeComposite
			AdaptiveTreeComposite otherTree = (AdaptiveTreeComposite) otherObject;

			// Compare the members
			isEqual = (super.equals(otherTree) 
					&& (type == null ? (otherTree.type == null) : type.equals(otherTree.type)) 
					&& typesMap.equals(otherTree.typesMap));
		}

		return isEqual;
	}

	/**
	 * Returns the hashcode of the object.
	 * 
	 * @return The hashcode of the object.
	 */
	@Override
	public int hashCode() {

		// Call the super's hash
		int hash = super.hashCode();

		// Append local hashes
		hash = (type == null ? hash : 31 * hash + type.hashCode());
		hash = 31 * hash + typesMap.hashCode();

		return hash;
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
}
