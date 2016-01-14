/*******************************************************************************
 * Copyright (c) 2012, 2014- UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Initial API and implementation and/or initial documentation - Jay Jay Billings, 
 *    Jordan H. Deyton, Dasha Gorin, Alexander J. McCaskey, Taylor Patterson, 
 *    Claire Saunders, Matthew Wang, Anna Wojtowicz
 *     
 *******************************************************************************/
package org.eclipse.ice.datastructures.entry;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.eclipse.ice.datastructures.ICEObject.IUpdateable;
import org.eclipse.ice.datastructures.ICEObject.IUpdateableListener;
import org.eclipse.ice.datastructures.ICEObject.Identifiable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The AbstractEntry is a realization of IEntry (and by extension 
 * the Identifiable, IUpdateable, and IUpdateableListener interfaces) that 
 * provides default behaviour for an Undefined (ie String valued entry). 
 * It keeps track of an entry value, a default value, a tag and comment 
 * for the entry, and name, id, description, contextId identifiers. 
 * 
 * It defers implementation for entry-type-specific operations to subclasses.
 * 
 * @author Alex McCaskey
 *
 */
@XmlRootElement(name = "AbstractEntry")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AbstractEntry implements IEntry {
	/**
	 * Logger for handling event messages and other information.
	 */
	@XmlTransient
	protected final Logger logger;

	/**
	 * The unique identification number of the ICEObject.
	 * 
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
	 * 
	 */
	protected String objectDescription;

	/**
	 * The set of IUpdateableListeners observing the ICEObject.
	 */
	@XmlTransient
	protected ArrayList<IUpdateableListener> listeners;

	/**
	 * The value of this AbstractEntry
	 */
	@XmlAttribute
	protected String value;

	/**
	 * The default value for this AbstractEntry.
	 */
	@XmlAttribute
	protected String defaultValue;

	/**
	 * The context Id of the AbstractEntry to be used in generating custom UI
	 * Widgets.
	 */
	@XmlAttribute
	protected String contextId;

	/**
	 * A String attribute where a comment about the Entry can be stored.
	 */
	@XmlElement(name = "Comment")
	protected String comment;

	/**
	 * The tag of an Entry is a secondary descriptive value that may be used to
	 * "tag" an Entry with a small note or additional value. This information
	 * should not be used in the UI! Another way to think of the tag of an Entry
	 * is to consider it as a second name that could be used, for example, when
	 * writing to a file or stream where human readability is less of a factor
	 * than the ability to parse the stream, (such as key-value pairs).
	 */
	@XmlAttribute()
	protected String tag;

	/**
	 * This attribute stores the state of the Entry as either true if the Entry
	 * is ready to be addressed and false if the Entry is not ready. This
	 * attribute is true by default.
	 */
	@XmlAttribute()
	protected boolean isReady = true;

	/**
	 * This attribute describes the "changed" state of the Entry. It has a value
	 * of true if the Entry's value was recently set and false if the Entry has
	 * not changed or was recently updated. It defaults to false.
	 */
	@XmlAttribute()
	protected boolean isModified = false;

	/**
	 * This attribute indicates whether or not the Entry should be considered as
	 * a required quantity.
	 */
	@XmlAttribute()
	protected boolean isRequired = true;

	/**
	 * The Constructor
	 * 
	 */
	public AbstractEntry() {

		// Create the logger
		logger = LoggerFactory.getLogger(getClass());

		// Set it all up
		uniqueId = 1;
		objectName = "ICE Entry";
		objectDescription = "ICE Entry";
		contextId = "org.eclipse.ice.datastructures.entry.AbstractEntry";
		listeners = new ArrayList<IUpdateableListener>();
		defaultValue = "";
		comment = "";
		tag = "";
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
	public void copy(AbstractEntry entity) {

		// Return if null
		if (entity == null) {
			return;
		}
		// Copy contents of entity to this ICEObject.
		this.objectDescription = entity.objectDescription;
		this.objectName = entity.objectName;
		this.uniqueId = entity.uniqueId;
		this.comment = entity.comment;
		this.defaultValue = entity.defaultValue;
		this.value = entity.value;
		this.isModified = entity.isModified;
		this.isReady = entity.isReady;
		this.isRequired = entity.isRequired;
		this.tag = entity.tag;
		this.contextId = entity.contextId;

	}

	/**
	 * <p>
	 * This protected operation notifies the listeners of the ICEObject that its
	 * state has changed.
	 * </p>
	 * 
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
						listeners.get(i).update(AbstractEntry.this);
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
	 * <p>
	 * This operation returns a clone of the ICEObject using a deep copy.
	 * </p>
	 * 
	 * @return
	 * 		<p>
	 *         The new clone.
	 *         </p>
	 */
	@Override
	public abstract Object clone();

	/**
	 * (non-Javadoc)
	 * 
	 * @see Identifiable#equals(Object otherObject)
	 */
	@Override
	public boolean equals(Object otherObject) {

		// Local Declarations
		boolean retVal = false;
		AbstractEntry castedOtherObject = null;

		// Check null and base type first. Note that the instanceof operator
		// must be used because subclasses of ICEObject can be anonymous.
		if (otherObject != null && (otherObject instanceof AbstractEntry)) {
			// See if they are the same reference on the heap
			if (this == otherObject) {
				retVal = true;
			} else {
				castedOtherObject = (AbstractEntry) otherObject;
				// Check each member attribute
				retVal = (this.uniqueId == castedOtherObject.uniqueId)
						&& (this.objectName.equals(castedOtherObject.objectName))
						&& (this.objectDescription.equals(castedOtherObject.objectDescription)
								&& (this.defaultValue.equals(castedOtherObject.defaultValue))
								&& (this.tag.equals(castedOtherObject.tag))
								&& (this.comment.equals(castedOtherObject.comment))
								&& (this.isReady == castedOtherObject.isReady)
								&& (this.isModified == castedOtherObject.isModified)
								&& (this.isRequired == castedOtherObject.isRequired)
								&& (this.contextId.equals(castedOtherObject.contextId)));
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
		hash = 31 * hash + (null == objectDescription ? 0 : objectDescription.hashCode());
		hash = 31 * hash + (null == defaultValue ? 0 : defaultValue.hashCode());
		hash = 31 * hash + (null == comment ? 0 : comment.hashCode());
		hash = 31 * hash + (null == tag ? 0 : tag.hashCode());
		hash = 31 * hash + (null == contextId ? 0 : contextId.hashCode());
		hash = 31 * hash + new Boolean(isReady).hashCode();
		hash = 31 * hash + new Boolean(isRequired).hashCode();
		hash = 31 * hash + new Boolean(isModified).hashCode();
		hash = 31 * hash + (null == this.value ? 0 : this.value.hashCode());

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

	@Override
	public boolean setValue(String value) {
		if (value != null) {
			this.value = value;
			isModified = true;
			notifyListeners();
			return true;
		}

		return false;
	}

	@Override
	public abstract boolean setValue(String... values);

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String getValue(int index) {
		return getValue();
	}

	@Override
	public String getDefaultValue() {
		return defaultValue;
	}

	@Override
	public void setDefaultValue(String value) {
		defaultValue = value;
	}

	@Override
	public abstract List<String> getAllowedValues();

	@Override
	public abstract void setAllowedValues(List<String> values);

	@Override
	public String getComment() {
		return comment;
	}

	@Override
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String getTag() {
		return tag;
	}

	@Override
	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isReady() {
		return isReady;
	}

	@Override
	public boolean isRequired() {
		return isRequired;
	}

	public void setReady(boolean ready) {
		isReady = ready;
	}

	public void setRequired(boolean required) {
		isRequired = required;
	}

	@Override
	public boolean isModified() {
		return isModified;
	}

	@Override
	public abstract void update(IUpdateable component);

	@Override
	public String getContextId() {
		return contextId;
	}

	@Override
	public void setContextId(String id) {
		contextId = id;
	}

}
