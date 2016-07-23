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

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * The DataComponent class is a container for Entries and behaves as a Component
 * from the UpdateableComposite package. The class is used contain a set of
 * Entries that are related to each other in some way and to accept updates from
 * dispatched from the Registry.
 * </p>
 * 
 * @author Jay Jay Billings
 */
@XmlRootElement(name = "DataComponent")
public class DataComponent extends ICEObject
		implements Component, IUpdateableListener {
	/**
	 * The entries in this data component.
	 */
	@XmlElementWrapper
	@XmlAnyElement(lax = true)
	private ArrayList<IEntry> entries;

	/**
	 * <p>
	 * The Constructor
	 * </p>
	 * 
	 */
	public DataComponent() {

		// Setup the list of Entries
		entries = new ArrayList<IEntry>();

	}

	/**
	 * <p>
	 * This operation adds an entry to the DataComponent.
	 * </p>
	 * 
	 * @param newEntry
	 *            <p>
	 *            The new Entry that will be added to the Form.
	 *            </p>
	 */
	public void addEntry(IEntry newEntry) {

		// Add the Entry if it is not null
		if (newEntry != null) {
			entries.add(newEntry);
			// Register the data component as a listener of the Entry
			newEntry.register(this);
			// Notify the listeners that the component has changed
			notifyListeners();
		}

	}

	/**
	 * <p>
	 * This operation adds an Entry to the DataComponent and specifies the name
	 * of another Entry on which it is dependent. It notifies listeners that the
	 * DataComponent has been updated.
	 * </p>
	 * 
	 * @param newEntry
	 *            <p>
	 *            The new Entry that should be added to the form.
	 *            </p>
	 * @param parentNames
	 *            <p>
	 *            The list of Entry names for those Entries on which the new
	 *            Entry is dependent.
	 *            </p>
	 */
	public void addEntry(IEntry newEntry, String... parentNames) {

		// FIXME - Do we need this?

	}

	/**
	 * <p>
	 * This operation clears all entries that are currently stored in the Form.
	 * </p>
	 * 
	 */
	public void clearEntries() {

		// Clear the list of Entries if it is not already empty
		if (!entries.isEmpty()) {
			entries.clear();
			notifyListeners();
		}

	}

	/**
	 * <p>
	 * This operation deletes the Entry with name equal to entryName from the
	 * Entries in the Form.
	 * </p>
	 * 
	 * @param entryName
	 *            <p>
	 *            The name of the Entry to delete.
	 *            </p>
	 */
	public void deleteEntry(String entryName) {

		// FIXME - Entry names are not necessarily unique!

		// Local Declarations
		int i = 0;

		// Make sure the entryName is not null
		if (entryName != null) {
			// Find and delete the Entry or Entries with this name. A linear
			// search is OK since the list should be small
			for (i = 0; i < entries.size(); i++) {
				if (entries.get(i).getName().equals(entryName)) {
					entries.remove(i);
				}
			}

			// Notify the listeners
			notifyListeners();
		}

		return;
	}

	/**
	 * <p>
	 * This operation retrieves the Entry with name entryName from the Form.
	 * </p>
	 * 
	 * @param entryName
	 *            <p>
	 *            The name of the Entry to retrieve from the Form.
	 *            </p>
	 * @return
	 * 		<p>
	 *         The Entry with name entryName.
	 *         </p>
	 */
	public IEntry retrieveEntry(String entryName) {

		for (IEntry j : entries) {
			if (j.getName().equals(entryName)) {
				return j;
			}
		}

		return null;
	}

	/**
	 * <p>
	 * This operation retrieves those Entries in the Form that are currently
	 * ready to be answered by the Eclipse User. This list can change with time
	 * as more information is provided to the Form and Item.
	 * </p>
	 * 
	 * @return
	 * 		<p>
	 *         The list of Entries that are ready to be addressed. The Entries
	 *         in this list are only the Entries that are not dependent on other
	 *         Entries or Entries for which all of the needed information has
	 *         been provided.
	 *         </p>
	 */
	public ArrayList<IEntry> retrieveReadyEntries() {

		// Local Declarations
		ArrayList<IEntry> readyEntryList = new ArrayList<IEntry>();

		for (IEntry i : entries) {
			if (i.isReady()) {
				readyEntryList.add(i);
			}
		}

		return readyEntryList;
	}

	/**
	 * <p>
	 * This operation will return all of the Entries in the Form regardless of
	 * their dependency or preparation status.
	 * </p>
	 * 
	 * @return
	 * 		<p>
	 *         The list of all Entries stored in the Form.
	 *         </p>
	 */
	public ArrayList<IEntry> retrieveAllEntries() {
		return entries;
	}

	/**
	 * <p>
	 * This operation determines whether a Form contains an Entry with the name
	 * entryName. It returns True if the Entry is in the Form and False if it is
	 * not in the Form.
	 * </p>
	 * 
	 * @param entryName
	 *            <p>
	 *            The name of the Entry whose existence in the Form should be
	 *            checked.
	 *            </p>
	 * @return
	 * 		<p>
	 *         True if the Entry with name entryName is in the form, false
	 *         otherwise.
	 *         </p>
	 */
	public boolean contains(String entryName) {

		for (IEntry i : entries) {
			if (i.getName().equals(entryName)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * <p>
	 * This operation is used to check equality between the DataComponent and
	 * another DataComponent. It returns true if the DataComponents are equal
	 * and false if they are not.
	 * </p>
	 * 
	 * @param otherDataComponent
	 *            <p>
	 *            The other DataComponent to which this component should be
	 *            compared.
	 *            </p>
	 * @return
	 * 		<p>
	 *         True if the DataComponents are equal, false otherwise.
	 *         </p>
	 */
	@Override
	public boolean equals(Object otherDataComponent) {

		// Check if they are the same reference in memory
		if (this == otherDataComponent) {
			return true;
		}

		// Check that the object is not null, and that it is a DataComponent
		// Check that these objects have the same ICEObject data
		if (otherDataComponent == null
				|| !(otherDataComponent instanceof DataComponent)
				|| !super.equals(otherDataComponent)) {
			return false;
		}

		// At this point, other object must be a DataComponent, so cast it
		DataComponent castedComponent = (DataComponent) otherDataComponent;

		// Check that their Entries are equal
		for (IEntry entry : this.entries) {
			// Check that the other DataComponent has entry
			// Note that ArrayList<E>.contains() uses E.equals()
			if (!castedComponent.entries.contains(entry)) {
				return false;
			}
		}

		// If made it here, these DataComponents are Equal
		// Return true
		return true;
	}

	/**
	 * <p>
	 * This operation returns the hashcode value of the DataComponent.
	 * </p>
	 * 
	 * @return
	 * 		<p>
	 *         The hashcode.
	 *         </p>
	 */
	@Override
	public int hashCode() {

		// Local Declaration
		int hash = 9;

		// Compute hash code from DataComponent data
		hash = 31 * hash + super.hashCode();
		for (IEntry entry : this.entries) {
			hash = 31 * hash + entry.hashCode();
		}
		return hash;
	}

	/**
	 * <p>
	 * This operation performs a deep copy of the attributes of another
	 * DataComponent into the current DataComponent.
	 * </p>
	 * 
	 * @param otherDataComponent
	 *            <p>
	 *            The other DataComponent from which information should be
	 *            copied.
	 *            </p>
	 */
	public void copy(DataComponent otherDataComponent) {

		// Return if otherDataComponenet is null
		if (otherDataComponent != null) {

			// Copy contents into super and current object
			super.copy(otherDataComponent);

			// reset entries
			entries.clear();

			// Copy entries
			for (int i = 0; i < otherDataComponent.entries.size(); i++) {
				entries.add((IEntry) otherDataComponent.entries.get(i).clone());
			}

			notifyListeners();
		}
		return;
	}

	/**
	 * <p>
	 * This operation provides a deep copy of the DataComponent.
	 * </p>
	 * 
	 * @return
	 * 		<p>
	 *         The deep-copy clone of this DataComponent.
	 *         </p>
	 */
	@Override
	public Object clone() {

		// Create a new instance, copy contents and return it
		DataComponent dataComponent = new DataComponent();
		dataComponent.copy(this);

		return dataComponent;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IUpdateable#update(String updatedKey, String newValue)
	 * 
	 */
	@Override
	public void update(String updatedKey, String newValue) {

		for (IEntry i : entries) {
			i.update(updatedKey, newValue);
		}

		return;

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Component#accept(IComponentVisitor visitor)
	 */
	@Override
	public void accept(IComponentVisitor visitor) {

		// Reveal our type to the visitor
		visitor.visit(this);

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IUpdateableListener#update(IUpdateable component)
	 */
	@Override
	public void update(IUpdateable component) {

		notifyListeners();

	}

}