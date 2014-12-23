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
import org.eclipse.ice.datastructures.ICEObject.ICEJAXBHandler;
import org.eclipse.ice.datastructures.ICEObject.ICEObject;
import org.eclipse.ice.datastructures.ICEObject.IUpdateableListener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.ice.datastructures.resource.ICEResource;

import java.io.InputStream;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.ice.datastructures.componentVisitor.IComponentVisitor;

/**
 * <!-- begin-UML-doc -->
 * <p>
 * The ResourceComponent is a specialization of Component that is used to manage
 * a set of ICEResources. It is used, for example, to collect Resources for
 * output data on a Form. ICEResources can be very easily added to
 * ResourceComponents by calling the addResource() operation and the whole list
 * of managed ICEResources can be retrieved with getResources().
 * </p>
 * <p>
 * Notifications are not provided on ResourceComponents if their names, ids or
 * descriptions change. These should not change in general because there is only
 * a single ResourceComponent for the given set of ICEResources. It only
 * provides notifications when ICEResources are added.
 * </p>
 * <!-- end-UML-doc -->
 * 
 * @author Jay Jay Billings
 * @generated 
 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@XmlRootElement(name = "ResourceComponent")
public class ResourceComponent extends ICEObject implements Component {
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The list of ICEResources managed by this component.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlElement(name = "ICEResource")
	private ArrayList<ICEResource> resources;

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

		// Setup the ICEResources list
		resources = new ArrayList<ICEResource>();

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

		// Add the ICEResource if it is good
		if (resource != null) {
			resources.add(resource);
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
		return resources;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * An operation that clears all the ICEResources in the iCEResource list. If
	 * there are no items in the list, this operation does nothing.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void clearResources() {
		// begin-user-code
		this.resources.clear();

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
		super.copy((ICEObject) otherResourceComponent);

		// Deep copy
		this.resources.clear();
		for (int i = 0; i < otherResourceComponent.resources.size(); i++) {
			this.resources.add((ICEResource) otherResourceComponent.resources
					.get(i).clone());
		}

		this.notifyListeners();

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
		ResourceComponent castedComponent = (ResourceComponent) otherResourceComponent;

		// Check that their resources are equal
		for (ICEResource r : this.resources) {
			// Check that the other ResourceComponent has r
			// Contains in ArrayList<E> uses E.equals()
			if (!castedComponent.resources.contains(r)) {
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
		for (ICEResource r : this.resources) {
			hash = 31 * hash + r.hashCode();
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
		// begin-user-code

		// Nothing to do.

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

		return;

		// end-user-code
	}
}