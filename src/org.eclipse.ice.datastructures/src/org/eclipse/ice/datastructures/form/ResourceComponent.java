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
import org.eclipse.ice.datastructures.ICEObject.IUpdateableListener;
import org.eclipse.ice.datastructures.ICEObject.ListComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.ice.datastructures.resource.ICEResource;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.eclipse.ice.datastructures.componentVisitor.IComponentVisitor;

/**
 * <!-- begin-UML-doc -->
 * <p>
 * The ResourceComponent is a specialization of ListComponent that is used to 
 * manage a set of ICEResources. It is used, for example, to collect Resources 
 * for output data on a Form. ICEResources can be very easily added to
 * ResourceComponents by calling the addResource() operation and the whole list
 * of managed ICEResources can be retrieved with getResources().
 * </p>
 * <p>
 * Notifications are not provided on ResourceComponents if their names, IDs or
 * descriptions change. These should not change in general because there is only
 * a single ResourceComponent for the given set of ICEResources. It only
 * provides notifications when ICEResources are added.
 * </p>
 * <!-- end-UML-doc -->
 * 
 * @author Jay Jay Billings, Anna Wojtowicz
 * @generated 
 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@XmlRootElement(name = "ResourceComponent")
public class ResourceComponent extends ListComponent<ICEResource> implements Component {

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The set of IUpdateableListeners observing the ResourceComponent.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlTransient
	protected ArrayList<IUpdateableListener> listeners;
	
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The Constructor
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ResourceComponent() {
		// begin-user-code

		// Setup the listeners list
		listeners = new ArrayList<IUpdateableListener>();

		return;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation adds an ICEResource to the component.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param resource
	 *            <p>
	 *            The new resource
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void addResource(ICEResource resource) {
		// begin-user-code

		// Add the resource if it is good
		if (resource != null) {
			this.add(resource);
			notifyListeners();
		}

		return;

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation gets all of the ICEResources from the component.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The list of ICEResources.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<ICEResource> getResources() {
		// begin-user-code
		
		return new ArrayList<ICEResource>(this);
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * An operation that clears all the ICEResources stored on the 
	 * ResourceComponent. If there are no items in the list, this operation does 
	 * nothing.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void clearResources() {
		// begin-user-code
		this.clear();

		return;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation performs a deep copy of the attributes of another
	 * ResourceComponent into the current ResourceComponent.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param otherResourceComponent
	 *            <p>
	 *            The other ResourceComponent whose information should be copied
	 *            into this ResourceComponent.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void copy(ResourceComponent otherResourceComponent) {
		// begin-user-code

		// Return if otherOutputComponenet is null
		if (otherResourceComponent == null) {
			return;
		}

		// Copy contents into super and current object
		super.copy((ResourceComponent) otherResourceComponent);

		// Deep copy
		this.clear();
		List<ICEResource> otherResources = 
				(List<ICEResource>) otherResourceComponent.getResources().clone();
		this.addAll(otherResources);

		this.notifyListeners();
		
		return;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation provides a deep copy of the ResourceComponent.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The clone of this ResourceComponent.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Object clone() {
		// begin-user-code

		// create a new instance of ResourceComponent and copy contents
		ResourceComponent outputComponent = new ResourceComponent();
		outputComponent.copy(this);
		
		return outputComponent;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation is used to check equality between the ResourceComponent
	 * and another ResourceComponent. It returns true if the Components are
	 * equal and false if they are not.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param otherResourceComponent
	 *            <p>
	 *            The other ResourceComponent whose information should be
	 *            compared to this ResourceComponent.
	 *            </p>
	 * @return <p>
	 *         True if the ResourceComponents are equal, false otherwise.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean equals(Object otherResourceComponent) {
		// begin-user-code

		// Check if they are the same reference in memory
		if (this == otherResourceComponent) {
			return true;
		}

		// Check that the object is not null, and that it is an instance of
		// ResourceComponent
		if (otherResourceComponent == null
				|| !(otherResourceComponent instanceof ResourceComponent)) {
			return false;
		}

		// Check that these objects have the same ICEObject data
		if (!super.equals(otherResourceComponent)) {
			return false;
		}

		// Other object must be a ResourceComponent at this point
		ResourceComponent castedComponent = 
				(ResourceComponent) otherResourceComponent;

		// Check that their resources are equal
		for (ICEResource resource : this) {
			// Check that the other ResourceComponent has the same resource
			if (!castedComponent.contains(resource)) {
				return false;
			}
		}

		// Return true
		return true;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation returns the hashcode value of the ResourceComponent.
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

		// Local declaration
		int hash = 12;

		// Compute hash code from ResourceComponent data
		hash = 31 * hash + super.hashCode();
		for (ICEResource resource : this) {
			hash = 31 * hash + resource.hashCode();
		}

		return hash;
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
		// Nothing to do.
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

		return;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This protected operation notifies the listeners of the ResourceComponent
	 * that its state has changed.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected void notifyListeners() {
		// begin-user-code

		// Only process the update if there are listeners
		if (listeners != null && !listeners.isEmpty()) {
			// Create a thread on which to notify the listeners.
			Thread notifierThread = new Thread() {
				@Override
				public void run() {
					// Loop over all listeners and update them
					for (int i = 0; i < listeners.size(); i++) {
						listeners.get(i).update(ResourceComponent.this);
					}
					return;
				}
			};

			// Launch the thread and do the notifications
			notifierThread.start();
		}

		return;
		// end-user-code
	}
}