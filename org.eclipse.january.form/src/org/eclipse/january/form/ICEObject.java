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

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ICEObject is the base class for all common, shared data structures in ICE
 * with the notable exception of the ICEList. ICEObjects are uniquely
 * identifiable by their identification numbers and are persistent; it realizes
 * both the Identifiable and Persistable interfaces. ICEObject implements
 * clone() for creating deep copies and also provides a public copy operation to
 * copy into an existing ICEObject. ICEObjects can be marshalled and
 * unmarshalled to XML using the loadFromXML() and persistToXML() operations
 * from the Persistable interface.
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
 * 
 * @author Jay Jay Billings
 */
@XmlRootElement(name = "ICEObject")
public class ICEObject implements IUpdateable {

	/**
	 * Logger for handling event messages and other information.
	 */
	@XmlTransient
	protected final Logger logger;

	/**
	 * The context for this object. It should be used as described on
	 * {@link org.eclipse.january.form.Identifiable}. It is not
	 * persisted to XML because it only matters during runtime. It's default
	 * value is "ice-default."
	 */
	@XmlTransient
	protected String context = "ice-default";

	/**
	 * The unique identification number of the ICEObject.
	 */
	protected int uniqueId;

	/**
	 * The name of the ICEObject.
	 */
	protected String objectName;

	/**
	 * The description of the ICEObject. This description should be different
	 * than the name of the ICEObject and should contain information that would
	 * be useful to a human user.
	 */
	protected String objectDescription;

	/**
	 * The ICEJAXBHandler used to marshal ICEObjects to and from XML.
	 */
	protected ICEJAXBHandler jaxbManipulator;

	/**
	 * The set of IUpdateableListeners observing the ICEObject.
	 */
	@XmlTransient
	protected ArrayList<IUpdateableListener> listeners;

	/**
	 * The Constructor
	 */
	public ICEObject() {

		// Create the logger
		logger = LoggerFactory.getLogger(getClass());

		// Set it all up
		uniqueId = 1;
		objectName = "ICE Object";
		objectDescription = "ICE Object";
		listeners = new ArrayList<IUpdateableListener>();

		return;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Identifiable#setId(int id)
	 */
	@Override
	public void setId(int id) {

		if (id >= 0) {
			uniqueId = id;
			// Notify the listeners that the object has changed.
			notifyListeners();
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Identifiable#getId()
	 */
	@Override
	@XmlAttribute()
	public int getId() {
		return uniqueId;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Identifiable#setName(String name)
	 */
	@Override
	public void setName(String name) {

		if (name != null) {
			objectName = name;
			// Notify the listeners that the object has changed.
			notifyListeners();
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Identifiable#getName()
	 */
	@Override
	@XmlAttribute()
	public String getName() {
		return objectName;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Identifiable#setDescription(String description)
	 */
	@Override
	public void setDescription(String description) {

		if (description != null) {
			objectDescription = description;
			// Notify the listeners that the object has changed.
			notifyListeners();
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Identifiable#getDescription()
	 */
	@Override
	@XmlAttribute()
	public String getDescription() {
		return objectDescription;
	}

	/**
	 * This operation copies the contents of an ICEObject into the current
	 * object using a deep copy.
	 * 
	 * @param entity
	 *            The Identifiable entity from which the values should be
	 *            copied.
	 */
	public void copy(ICEObject entity) {

		// Return if null
		if (entity == null) {
			return;
		}
		// Copy contents of entity to this ICEObject.
		objectDescription = entity.objectDescription;
		objectName = entity.objectName;
		uniqueId = entity.uniqueId;
		context = entity.context;

		return;
	}

	/**
	 * This protected operation notifies the listeners of the ICEObject that its
	 * state has changed.
	 */
	protected void notifyListeners() {

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
	}

	/**
	 * This operation returns a clone of the ICEObject using a deep copy.
	 * 
	 * @return The new clone.
	 */
	@Override
	public Object clone() {

		// Create a new instance of the current object
		ICEObject newObject = new ICEObject();

		// Copy contents from current object to new object
		newObject.copy(this);

		// return object
		return newObject;

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Identifiable#equals(Object otherObject)
	 */
	@Override
	public boolean equals(Object otherObject) {

		// Local Declarations
		boolean retVal = false;
		ICEObject castedOtherObject = null;

		// Check null and base type first. Note that the instanceof operator
		// must be used because subclasses of ICEObject can be anonymous.
		if (otherObject != null && (otherObject instanceof ICEObject)) {
			// See if they are the same reference on the heap
			if (this == otherObject) {
				retVal = true;
			} else {
				castedOtherObject = (ICEObject) otherObject;
				// Check each member attribute
				retVal = (uniqueId == castedOtherObject.uniqueId)
						&& (objectName.equals(castedOtherObject.objectName))
						&& (objectDescription
								.equals(castedOtherObject.objectDescription))
						&& (context.equals(castedOtherObject.context));
			}
		}

		return retVal;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Identifiable#hashCode()
	 */
	@Override
	public int hashCode() {

		// Local Declaration
		int hash = 11;

		// Compute the hashcode from this ICEObject's data
		hash = 31 * hash + uniqueId;
		// If objectName is null, add 0, otherwise add String.hashcode()
		hash = 31 * hash + (null == objectName ? 0 : objectName.hashCode());
		hash = 31 * hash + (null == objectDescription ? 0
				: objectDescription.hashCode());
		hash = 31 * hash + context.hashCode();
		// Return the computed hash code
		return hash;

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IUpdateable#update(String updatedKey, String newValue)
	 */
	@Override
	public void update(String updatedKey, String newValue) {

		// Nothing TODO. Subclasses must override this operation for tailored
		// behavior.

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IUpdateable#register(IUpdateableListener listener)
	 */
	@Override
	public void register(IUpdateableListener listener) {

		// Register the listener if it is not null
		if (listener != null) {
			listeners.add(listener);
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
		}

		return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ice.datastructures.ICEObject.Identifiable#getContext()
	 */
	@Override
	public String getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ice.datastructures.ICEObject.Identifiable#setContext(java.
	 * lang.String)
	 */
	@Override
	public void setContext(String context) {
		this.context = context;
	}
}