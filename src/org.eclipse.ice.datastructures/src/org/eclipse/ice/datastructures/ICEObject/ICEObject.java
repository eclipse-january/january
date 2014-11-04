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
package org.eclipse.ice.datastructures.ICEObject;

import org.eclipse.ice.datastructures.updateableComposite.IUpdateable;
import java.util.ArrayList;
import org.eclipse.ice.datastructures.updateableComposite.IUpdateableListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * <!-- begin-UML-doc -->
 * <p>
 * ICEObject is the base class for all common, shared data structures in ICE
 * with the notable exception of the ICEList. ICEObjects are uniquely
 * identifiable by their identification numbers and are persistent; it realizes
 * both the Identifiable and Persistable interfaces. ICEObject implements
 * clone() for creating deep copies and also provides a public copy operation to
 * copy into an existing ICEObject. ICEObjects can be marshalled and
 * unmarshalled to XML using the loadFromXML() and persistToXML() operations
 * from the Persistable interface.
 * </p>
 * <p>
 * Operations are defined for most of the attributes and capabilities of the
 * ICEObject class, but some work is required by subclasses. Subclasses must
 * override clone() if they extend ICEObject by adding attributes or the deep
 * copy will fail. They should provide a custom implementation of copy() that is
 * specific to their own type to do a deep copy (i.e. copy(a:myType) instead of
 * copy(a:ICEObject)) since ICEObject.copy() will only copy the attributes of
 * ICEObjects. They must also override the loadFromXML() operation to copy the
 * XML data properly from the XMLLoader (because ICE uses JAXB to bind XML to
 * ICEObjects and its subclasses).
 * </p>
 * <p>
 * ICEObjects implement IUpdateable. The base class manages registering,
 * unregistering and notifications. Subclasses are expected to override
 * update().
 * </p>
 * <!-- end-UML-doc -->
 * 
 * @author Jay Jay Billings
 * @generated 
 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@XmlRootElement(name = "ICEObject")
public class ICEObject implements IUpdateable, Persistable {
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The unique identification number of the ICEObject.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected int uniqueId;
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The name of the ICEObject.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected String objectName;
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The description of the ICEObject. This description should be different
	 * than the name of the ICEObject and should contain information that would
	 * be useful to a human user.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected String objectDescription;
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The ICEJAXBManipulator used to marshal ICEObjects to and from XML.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected ICEJAXBManipulator jaxbManipulator;

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * A specifically attribute designed to be utilized by the JPA database.
	 * This variable should not be accessed normally by ICE, only by JPA. DO NOT
	 * OVERRIDE THIS VARIABLE!
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected int DB_ID;

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The set of IUpdateableListeners observing the ICEObject.
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
	public ICEObject() {
		// begin-user-code

		// Set it all up
		uniqueId = 1;
		objectName = "ICE Object";
		objectDescription = "ICE Object";
		listeners = new ArrayList<IUpdateableListener>();

		return;
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Identifiable#setId(int id)
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setId(int id) {
		// begin-user-code

		if (id >= 0) {
			uniqueId = id;
			// Notify the listeners that the object has changed.
			notifyListeners();
		}

		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Identifiable#getId()
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlAttribute()
	public int getId() {
		// begin-user-code
		return uniqueId;
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Identifiable#setName(String name)
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setName(String name) {
		// begin-user-code

		if (name != null) {
			objectName = name;
			// Notify the listeners that the object has changed.
			notifyListeners();
		}

		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Identifiable#getName()
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlAttribute()
	public String getName() {
		// begin-user-code
		return objectName;
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Identifiable#setDescription(String description)
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setDescription(String description) {
		// begin-user-code

		if (description != null) {
			objectDescription = description;
			// Notify the listeners that the object has changed.
			notifyListeners();
		}

		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Identifiable#getDescription()
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlAttribute()
	public String getDescription() {
		// begin-user-code
		return objectDescription;
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Persistable#loadFromXML(InputStream inputStream)
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
			this.copy((ICEObject) dataObject);

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
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Persistable#persistToXML(OutputStream outputStream)
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void persistToXML(OutputStream outputStream) {
		// begin-user-code

		// Initialize JAXBManipulator
		jaxbManipulator = new ICEJAXBManipulator();

		// Call the write() on jaxbManipulator to write to outputStream
		try {
			jaxbManipulator.write(this, outputStream);
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
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation copies the contents of a Identifiable entity into the
	 * current object using a deep copy.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param entity
	 *            <p>
	 *            The Identifiable entity from which the values should be
	 *            copied.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void copy(ICEObject entity) {
		// begin-user-code

		// Return if null
		if (entity == null) {
			return;
		}
		// Copy contents of entity to this ICEObject.
		this.objectDescription = entity.objectDescription;
		this.objectName = entity.objectName;
		this.uniqueId = entity.uniqueId;

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This protected operation notifies the listeners of the ICEObject that its
	 * state has changed.
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
						listeners.get(i).update(ICEObject.this);
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

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation returns a clone of the ICEObject using a deep copy.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The new clone.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public Object clone() {
		// begin-user-code

		// Create a new instance of the current object
		ICEObject newObject = new ICEObject();

		// Copy contents from current object to new object
		newObject.copy(this);

		// return object
		return newObject;

		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Identifiable#equals(Object otherObject)
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean equals(Object otherObject) {
		// begin-user-code

		// Local Declarations
		boolean retVal = false;
		ICEObject castedOtherObject = null;

		// Check the ICEObject, null and base type check first. Note that the
		// instanceof operator must be used because subclasses of ICEObject
		// can be anonymous.
		if (otherObject != null && (otherObject instanceof ICEObject)) {
			// See if they are the same reference on the heap
			if (this == otherObject) {
				retVal = true;
			} else {
				castedOtherObject = (ICEObject) otherObject;
				// Check each member attribute
				retVal = (this.uniqueId == castedOtherObject.uniqueId)
						&& (this.objectName
								.equals(castedOtherObject.objectName))
						&& (this.objectDescription
								.equals(castedOtherObject.objectDescription))
				/* && (this.DB_ID == castedOtherObject.DB_ID) */;
			}
		}

		return retVal;
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Identifiable#hashCode()
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int hashCode() {
		// begin-user-code

		// Local Declaration
		int hash = 11;

		// Compute the hashcode from this ICEObject's data
		hash = 31 * hash + uniqueId;
		// If objectName is null, add 0, otherwise add String.hashcode()
		hash = 31 * hash
				+ (null == objectName ? 0 : objectName.hashCode());
		hash = 31
				* hash
				+ (null == objectDescription ? 0 : objectDescription
						.hashCode());
		// Return the computed hash code
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

		// Nothing TODO. Subclasses must override this operation for tailored
		// behavior.

		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IUpdateable#register(IUpdateableListener listener)
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void register(IUpdateableListener listener) {
		// begin-user-code

		// Register the listener if it is not null
		if (listener != null) {
			listeners.add(listener);
		}
		return;
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IUpdateable#unregister(IUpdateableListener listener)
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void unregister(IUpdateableListener listener) {
		// begin-user-code

		// Unregister the listener if it is not null and in the list
		if (listener != null && listeners.contains(listener)) {
			listeners.remove(listener);
		}

		return;
		// end-user-code
	}
}