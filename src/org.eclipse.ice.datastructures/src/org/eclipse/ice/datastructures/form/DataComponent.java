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
package org.eclipse.ice.datastructures.form;

import org.eclipse.ice.datastructures.ICEObject.Component;
import org.eclipse.ice.datastructures.ICEObject.ICEJAXBManipulator;
import org.eclipse.ice.datastructures.ICEObject.ICEObject;
import org.eclipse.ice.datastructures.ICEObject.IUpdateable;
import org.eclipse.ice.datastructures.ICEObject.IUpdateableListener;
import org.eclipse.ice.datastructures.componentVisitor.IComponentVisitor;

import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <!-- begin-UML-doc -->
 * <p>
 * The DataComponent class is a container for Entries and behaves as a Component
 * from the UpdateableComposite package. The class is used contain a set of
 * Entries that are related to each other in some way and to accept updates from
 * dispatched from the Registry.
 * </p>
 * <!-- end-UML-doc -->
 * 
 * @author Jay Jay Billings
 */
@XmlRootElement(name = "DataComponent")
public class DataComponent extends ICEObject implements Component,
		IUpdateableListener {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 */
	@XmlElement(name = "Entry")
	private ArrayList<Entry> entries;

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The Constructor
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 */
	public DataComponent() {
		// begin-user-code

		// Setup the list of Entries
		entries = new ArrayList<Entry>();

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation adds an entry to the DataComponent.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param newEntry
	 *            <p>
	 *            The new Entry that will be added to the Form.
	 *            </p>
	 */
	public void addEntry(Entry newEntry) {
		// begin-user-code

		// Add the Entry if it is not null
		if (newEntry != null) {
			entries.add(newEntry);
			// Register the data component as a listener of the Entry
			newEntry.register(this);
			// Notify the listeners that the component has changed
			notifyListeners();
		}

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation adds an Entry to the DataComponent and specifies the name
	 * of another Entry on which it is dependent. It notifies listeners that the
	 * DataComponent has been updated.
	 * </p>
	 * <!-- end-UML-doc -->
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
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void addEntry(Entry newEntry, String... parentNames) {
		// begin-user-code

		// FIXME - Do we need this?

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation clears all entries that are currently stored in the Form.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 */
	public void clearEntries() {
		// begin-user-code

		// Clear the list of Entries if it is not already empty
		if (!entries.isEmpty()) {
			entries.clear();
			notifyListeners();
		}

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation deletes the Entry with name equal to entryName from the
	 * Entries in the Form.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param entryName
	 *            <p>
	 *            The name of the Entry to delete.
	 *            </p>
	 */
	public void deleteEntry(String entryName) {
		// begin-user-code

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
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation retrieves the Entry with name entryName from the Form.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param entryName
	 *            <p>
	 *            The name of the Entry to retrieve from the Form.
	 *            </p>
	 * @return <p>
	 *         The Entry with name entryName.
	 *         </p>
	 */
	public Entry retrieveEntry(String entryName) {
		// begin-user-code

		for (Entry j : entries) {
			if (j.getName().equals(entryName)) {
				return j;
			}
		}

		return null;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation retrieves those Entries in the Form that are currently
	 * ready to be answered by the Eclipse User. This list can change with time
	 * as more information is provided to the Form and Item.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The list of Entries that are ready to be addressed. The Entries
	 *         in this list are only the Entries that are not dependent on other
	 *         Entries or Entries for which all of the needed information has
	 *         been provided.
	 *         </p>
	 */
	public ArrayList<Entry> retrieveReadyEntries() {
		// begin-user-code

		// Local Declarations
		ArrayList<Entry> readyEntryList = new ArrayList<Entry>();

		for (Entry i : entries) {
			if (i.isReady()) {
				readyEntryList.add(i);
			}
		}

		return readyEntryList;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation will return all of the Entries in the Form regardless of
	 * their dependency or preparation status.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The list of all Entries stored in the Form.
	 *         </p>
	 */
	public ArrayList<Entry> retrieveAllEntries() {
		// begin-user-code
		return entries;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation determines whether a Form contains an Entry with the name
	 * entryName. It returns True if the Entry is in the Form and False if it is
	 * not in the Form.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param entryName
	 *            <p>
	 *            The name of the Entry whose existence in the Form should be
	 *            checked.
	 *            </p>
	 * @return <p>
	 *         True if the Entry with name entryName is in the form, false
	 *         otherwise.
	 *         </p>
	 */
	public boolean contains(String entryName) {
		// begin-user-code

		for (Entry i : entries) {
			if (i.getName().equals(entryName)) {
				return true;
			}
		}

		return false;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation is used to check equality between the DataComponent and
	 * another DataComponent. It returns true if the DataComponents are equal
	 * and false if they are not.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param otherDataComponent
	 *            <p>
	 *            The other DataComponent to which this component should be
	 *            compared.
	 *            </p>
	 * @return <p>
	 *         True if the DataComponents are equal, false otherwise.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean equals(Object otherDataComponent) {
		// begin-user-code

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
		for (Entry entry : this.entries) {
			// Check that the other DataComponent has entry
			// Note that ArrayList<E>.contains() uses E.equals()
			if (!castedComponent.entries.contains(entry)) {
				return false;
			}
		}

		// If made it here, these DataComponents are Equal
		// Return true
		return true;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation returns the hashcode value of the DataComponent.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The hashcode.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int hashCode() {
		// begin-user-code

		// Local Declaration
		int hash = 9;

		// Compute hash code from DataComponent data
		hash = 31 * hash + super.hashCode();
		for (Entry entry : this.entries) {
			hash = 31 * hash + entry.hashCode();
		}
		return hash;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation performs a deep copy of the attributes of another
	 * DataComponent into the current DataComponent.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param otherDataComponent
	 *            <p>
	 *            The other DataComponent from which information should be
	 *            copied.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void copy(DataComponent otherDataComponent) {
		// begin-user-code

		// Return if otherDataComponenet is null
		if (otherDataComponent != null) {

			// Copy contents into super and current object
			super.copy((ICEObject) otherDataComponent);

			// reset entries
			entries.clear();

			// Copy entries
			for (int i = 0; i < otherDataComponent.entries.size(); i++) {
				entries.add((Entry) otherDataComponent.entries.get(i).clone());
			}

			notifyListeners();
		}
		return;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation provides a deep copy of the DataComponent.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The deep-copy clone of this DataComponent.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Object clone() {
		// begin-user-code

		// Create a new instance, copy contents and return it
		DataComponent dataComponent = new DataComponent();
		dataComponent.copy(this);

		return dataComponent;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation overloads the ICEObject.loadFromXML() operation to
	 * properly load the DataComponent.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param inputStream
	 *            <p>
	 *            The InputStream containing XML from which the DataComponent
	 *            should be loaded.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void loadFromXML(InputStream inputStream) {
		// begin-user-code

		// Initialize JAXBManipulator
		jaxbManipulator = new ICEJAXBManipulator();

		// Call the read() on jaxbManipulator to create a new Object instance
		// from the inputStream
		Object dataObject;
		try {
			dataObject = jaxbManipulator.read(this.getClass(), inputStream);
			// Copy contents of new object into current data structure
			this.copy((DataComponent) dataObject);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Nullerize jaxbManipilator
		jaxbManipulator = null;
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IUpdateable#update(String updatedKey, String newValue)
	 * 
	 */
	@Override
	public void update(String updatedKey, String newValue) {
		// begin-user-code

		for (Entry i : entries) {
			i.update(updatedKey, newValue);
		}

		return;

		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Component#accept(IComponentVisitor visitor)
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void accept(IComponentVisitor visitor) {
		// begin-user-code

		// Reveal our type to the visitor
		visitor.visit(this);

		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IUpdateableListener#update(IUpdateable component)
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void update(IUpdateable component) {
		// begin-user-code

		notifyListeners();

		// end-user-code
	}

}