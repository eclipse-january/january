package org.eclipse.ice.datastructures.entry;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

import org.eclipse.ice.datastructures.ICEObject.IUpdateable;
import org.eclipse.ice.datastructures.ICEObject.IUpdateableListener;
import org.eclipse.ice.datastructures.ICEObject.Identifiable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractEntry implements IEntry {
	/**
	 * Logger for handling event messages and other information.
	 */
	@XmlTransient
	protected final Logger logger;

	/**
	 * <p>
	 * The unique identification number of the ICEObject.
	 * </p>
	 * 
	 */
	protected int uniqueId;
	/**
	 * <p>
	 * The name of the ICEObject.
	 * </p>
	 * 
	 */
	protected String objectName;
	/**
	 * <p>
	 * The description of the ICEObject. This description should be different
	 * than the name of the ICEObject and should contain information that would
	 * be useful to a human user.
	 * </p>
	 * 
	 */
	protected String objectDescription;
	
	/**
	 * <p>
	 * The set of IUpdateableListeners observing the ICEObject.
	 * </p>
	 * 
	 */
	@XmlTransient
	protected ArrayList<IUpdateableListener> listeners;

	protected String value;
	
	protected String defaultValue;
	
	protected String contextId;
	
	protected String comment;
	
	protected String tag;
	
	protected boolean isReady = true;
	
	protected boolean isModified = false;
	
	protected boolean isRequired = true;
	
	/**
	 * <p>
	 * The Constructor
	 * </p>
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
						&& (this.objectDescription.equals(castedOtherObject.objectDescription));
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
