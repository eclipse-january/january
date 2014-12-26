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

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.ice.datastructures.ICEObject.Component;
import org.eclipse.ice.datastructures.ICEObject.Composite;
import org.eclipse.ice.datastructures.ICEObject.IUpdateableListener;
import org.eclipse.ice.datastructures.ICEObject.Identifiable;
import org.eclipse.ice.datastructures.ICEObject.ICEObject;
import org.eclipse.ice.datastructures.ICEObject.ListComponent;
import org.eclipse.ice.datastructures.componentVisitor.IComponentVisitor;
import org.eclipse.ice.datastructures.form.emf.EMFComponent;
import org.eclipse.ice.datastructures.form.geometry.GeometryComponent;
import org.eclipse.ice.datastructures.form.mesh.MeshComponent;

/**
 * <!-- begin-UML-doc -->
 * <p>
 * The Form class is a representation of the Item class and contains all of the
 * Entries that must be addressed by the Eclipse User before the Item can
 * perform its task or tasks. The Entries in a Form may change after it is
 * submitted if the Item class needs more information. A client only interacts
 * with an Item through its Forms. The Form requires a list of Actions for which
 * it can be used upon construction and, if no such list is provided,
 * getActionList() will return null. Such usage is common because in some
 * instances Forms are actually used by Actions themselves and not Items!
 * </p>
 * <p>
 * All Forms must be in a "ready to use" state by default with enough
 * information provided so that a task can be performed with no modification.
 * isReady() should always return true for such a Form, newly created.
 * </p>
 * <!-- end-UML-doc -->
 * 
 * @author Jay Jay Billings
 * @generated 
 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@XmlRootElement(name = "Form")
public class Form extends ICEObject implements Composite {
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The unique ID of the Item that is represented by this Form.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private int itemID;

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The list of Components.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlAnyElement()
	@XmlElementRefs(value = {
			@XmlElementRef(name = "ResourceComponent", type = ResourceComponent.class),
			@XmlElementRef(name = "TableComponent", type = TableComponent.class),
			@XmlElementRef(name = "MatrixComponent", type = MatrixComponent.class),
			@XmlElementRef(name = "GeometryComponent", type = GeometryComponent.class),
			@XmlElementRef(name = "MasterDetailsComponent", type = MasterDetailsComponent.class),
			@XmlElementRef(name = "TimeDataComponent", type = TimeDataComponent.class),
			@XmlElementRef(name = "DataComponent", type = DataComponent.class),
			@XmlElementRef(name = "TreeComposite", type = TreeComposite.class),
			@XmlElementRef(name = "MeshComponent", type = MeshComponent.class),
			@XmlElementRef(name = "ListComponent", type = ListComponent.class),
			@XmlElementRef(name = "EMFComponent", type = EMFComponent.class)})
	private ArrayList<Component> componentList;

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The list of Actions that can be performed for this Form when it is
	 * processed.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected ArrayList<String> actionList;

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This attribute indicates whether or not the Form is complete and valid
	 * and can be processed by one of the Actions described in its list. This
	 * value is true if the Form is ready, false otherwise.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */

	protected boolean canProcess = true;

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The constructor. This constructor requires a list of Actions for which
	 * the Form can be used. If this list is null, then getActionList() will
	 * return null.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Form() {
		// begin-user-code

		// Setup the Form ID
		this.itemID = 0;

		// Setup the list of Components
		this.componentList = new ArrayList<Component>();

		// Setup the list of Listeners
		listeners = new ArrayList<IUpdateableListener>();

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation returns the id of the Item that is represented by this
	 * Form.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The unique ID of the Item that the Form represents.
	 *         </p>
	 */
	@XmlAttribute()
	public int getItemID() {
		// begin-user-code
		return this.itemID;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation sets the ID of the item to which the Form belongs.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param newItemID
	 *            <p>
	 *            The new Item ID.
	 *            </p>
	 */
	public void setItemID(int newItemID) {
		// begin-user-code
		this.itemID = newItemID;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation retrieves the list of Actions that can be performed for
	 * the Form.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The list of Actions that can be performed for this Form when it
	 *         is processed or null if no such list was provided.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlElement(name = "ActionList")
	public ArrayList<String> getActionList() {
		// begin-user-code
		return this.actionList;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation sets the list of Actions that can be performed using the
	 * data on the Form.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param actions
	 *            <p>
	 *            The list of available Actions.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setActionList(ArrayList<String> actions) {
		// begin-user-code

		// Setup the list of Actions
		this.actionList = actions;

		return;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation returns true if the Form is complete, valid and can be
	 * processed.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         True if the Form is complete, valid and can be processed.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean isReady() {
		// begin-user-code
		return canProcess;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation marks the Form as either ready (true) or not ready (false)
	 * to be processed.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param ready
	 *            <p>
	 *            True if the Form should be marked as complete, valid and ready
	 *            to be processed. False otherwise.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void markReady(boolean ready) {
		// begin-user-code

		canProcess = ready;

		return;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation is used to check equality between the Form and another
	 * Form. It returns true if the Forms are equal and false if they are not.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param otherForm
	 *            <p>
	 *            The other Form to which this Form should be compared.
	 *            </p>
	 * @return <p>
	 *         True if the Forms are equal, false otherwise.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean equals(Object otherForm) {
		// begin-user-code

		// Check if they are the same references in memory
		if (this == otherForm) {
			return true;
		}

		// Check that the object is not null, and that it is a Form
		if (otherForm == null || !(otherForm instanceof Form)) {
			return false;
		}

		// Check that these objects have the same ICEObject data
		if (!super.equals(otherForm)) {
			return false;
		}

		// At this point, other object must be a Form, so cast it
		Form castedForm = (Form) otherForm;

		// Check that the itemIDs and canProcess are equal
		if (this.itemID != castedForm.itemID
				|| this.canProcess != castedForm.canProcess) {
			return false;
		}

		// Check that their Components are equal
		for (Component comp : this.componentList) {
			// Check that the other Form has comp
			// Note that ArrayList<E>.contains() uses E.equals()
			if (!castedForm.componentList.contains(comp)) {
				return false;
			}
		}

		// Check that their ActionLists are equal

		if (this.actionList != null && castedForm != null) {
			for (String action : this.actionList) {
				if (!castedForm.actionList.contains(action)) {
					return false;
				}
			}
		}

		// check actionlist - nonequal null

		if (this.actionList == null && castedForm.actionList != null
				|| this.actionList != null && castedForm.actionList == null) {
			return false;
		}

		// If made it here, these Forms are Equal
		// Return true
		return true;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation returns the hashcode value of the Form.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The hashcode of the Form.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int hashCode() {
		// begin-user-code

		// Local Declaration
		int hash = 13;

		// Compute the hash code from Form data
		hash = 31 * hash + super.hashCode();
		hash = 31 * hash + this.itemID;
		hash = 31 * hash + (!this.canProcess ? 0 : 1);

		// Get Component List contribution
		for (Component comp : this.componentList) {
			hash = 31 * hash + comp.hashCode();
		}

		// Get Action List contribution
		if (actionList != null) {
			for (String action : this.actionList) {
				hash = 31 * hash + action.hashCode();
			}
		}

		return hash;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation provides a deep copy of the Form.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The deep-copy clone of this Form.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Object clone() {
		// begin-user-code

		// Create a new instance, copy contents, and return it

		// create a new instance of form and copy contents
		Form form = new Form();
		form.copy(this);
		return form;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation performs a deep copy of the attributes of another Form
	 * into the current Form.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param otherForm
	 *            <p>
	 *            The other Form from which information should be copied.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void copy(Form otherForm) {
		// begin-user-code

		// Return if otherForm is null
		if (otherForm == null) {
			return;
		}

		// Copy contents into super and current object
		super.copy((ICEObject) otherForm);

		// Copy action list - Deep copy
		if (otherForm.actionList == null) {
			this.actionList = null;
		} else {
			// Make sure it is initialized!
			if (this.actionList != null) {
				this.actionList.clear();
			} else {
				this.actionList = new ArrayList<String>();
			}
			for (int i = 0; i < otherForm.actionList.size(); i++) {
				this.actionList.add(otherForm.actionList.get(i));
			}
		}

		// Copy components - Deep copy
		this.componentList.clear();
		for (int i = 0; i < otherForm.componentList.size(); i++) {
			Identifiable compWithId = (Identifiable) otherForm.componentList
					.get(i).clone();
			this.componentList.add((Component) compWithId);
		}

		// Copy the Item information
		this.itemID = otherForm.itemID;
		this.canProcess = otherForm.canProcess;

		// Throw up a flare
		this.notifyListeners();

		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IUpdateable#update(String updatedKey, String newValue)
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void update(String updatedKey, String newValue) {
		// begin-user-code

		for (Component i : componentList) {
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
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Composite#addComponent(Component child)
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void addComponent(Component child) {
		// begin-user-code

		// Add the child component if it is not null and update listeners
		if (child != null) {
			componentList.add(child);
			notifyListeners();
		} else {
			// Otherwise throw an error exception
			throw new RuntimeException("Data components in Forms "
					+ " cannot be null.");
		}

		return;
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Composite#removeComponent(int childId)
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void removeComponent(int childId) {
		// begin-user-code

		// Local Declarations
		Identifiable comp = null; // FIXME - might not be an ICEObject!

		for (int i = 0; i < componentList.size(); i++) {
			comp = (Identifiable) componentList.get(i);
			if (comp.getId() == childId) {
				componentList.remove(i);
				break;
			}
		}

		return;

		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Composite#getComponent(int childId)
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Component getComponent(int childId) {
		// begin-user-code

		// Local Declarations
		Identifiable comp = null;

		for (int i = 0; i < componentList.size(); i++) {
			comp = (Identifiable) componentList.get(i);
			if (comp.getId() == childId) {
				return componentList.get(i);
			}
		}

		return null;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Composite#getNumberOfComponents()
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int getNumberOfComponents() {
		// begin-user-code
		return this.componentList.size();
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Composite#getComponents()
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<Component> getComponents() {
		// begin-user-code
		return this.componentList;
		// end-user-code
	}
}