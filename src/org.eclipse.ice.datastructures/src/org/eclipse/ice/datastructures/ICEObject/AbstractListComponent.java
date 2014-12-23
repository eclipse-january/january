/*******************************************************************************
 * Copyright (c) 2011, 2014 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - Jay Jay 
 *   Billings
 *******************************************************************************/
package org.eclipse.ice.datastructures.ICEObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.eclipse.ice.datastructures.componentVisitor.IComponentVisitor;

import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.TransformedList;
import ca.odell.glazedlists.event.ListEvent;
import ca.odell.glazedlists.event.ListEventListener;

/**
 * This is an abstract base class for Components that are based on lists. Its
 * primary purpose is to provide all of the standard list operations expected
 * from the Java Collections in a class that realizes ICE's additional
 * requirements for persistence and unique identification.
 * 
 * It implements both the Component and Persistable interfaces to match up with
 * the ICE requirements and extends the TransformedList from GlazedLists to
 * provide the generic, observable list capabilities.
 * 
 * It provides a base implementation for most of the capabilities it provides,
 * although it must be subclassed to handle certain specific operations such as
 * loading from XML and cloning.
 * 
 * <b>Implementation note</b>
 * 
 * Unfortunately, there are some tricky implementation details here related to
 * extending TransformedList. The point of a TransformedList is to sit on top of
 * a source list and manipulate it so it is a wrapper around another list. This
 * means that in the implementation of this class any work to register listeners
 * or manipulate the list should be done to the source list, not "this" list.
 * TransformedList is the suggested base class for extensions to GlazedLists
 * instead of AbstractEventList, so we will live with this for now.
 * 
 * @author Jay Jay Billings
 *
 */
@XmlRootElement(name = "AbstractListComponent")
@XmlAccessorType(XmlAccessType.FIELD)
public class AbstractListComponent<T> extends TransformedList<T, T>
		implements Component {

	/**
	 * The ICEJAXBHandler used to marshal the class to and from XML.
	 */
	@XmlTransient
	protected ICEJAXBHandler jaxbManipulator;
	
	/**
	 * A listener map to map ICE listeners to ListEventListeners.
	 */
	@XmlTransient
	Map<IUpdateableListener, ListEventListener> listenerMap;

	/**
	 * A BasicEventList that is used to store the identity of this component.
	 * Index 0 - the unique id, cast to a String Index 1 - the name Index 2 -
	 * the description
	 * 
	 * Doing this makes it possible to use the built-in updates provided by the
	 * BasicEventList instead of implementing our own here since these
	 * properties are not part of the Transformed list per se and will not have
	 * events posted for them. It also makes almost every other operation easy
	 * to implement too.
	 */
	protected BasicEventList<String> idList;

	
	protected BasicEventList<T> jaxbSourceList;
	
	/**
	 * The default constructor.
	 * 
	 * It delegates the actual constructor to the TransformedList constructor
	 * and sets the source list to an empty BasicEventList.
	 */
	public AbstractListComponent() {
		this(new BasicEventList<T>());
	}

	/**
	 * A protected constructor inherited from TransformedList.
	 * 
	 * @param source
	 *            The source list used by the TransformedList.
	 */
	protected AbstractListComponent(EventList<T> source) {
		super(source);
		// Store the source list locally too so that JAXB gets it
		jaxbSourceList = (BasicEventList<T>) source;
		// Set it all up
		idList = new BasicEventList<String>();
		idList.add("1");
		idList.add("ICE Object");
		idList.add("ICE Object");
		// Setup the listener map
		listenerMap = new HashMap<IUpdateableListener, ListEventListener>();
	}

	/**
	 * This operation copies the contents of the AbstractListComponent into the
	 * current object using a deep copy.
	 * 
	 * @param list
	 *            The list from which the values should be copied.
	 */
	public void copy(AbstractListComponent<T> list) {
		// Return if null
		if (list == null) {
			return;
		}
		// Copy the identity
		idList.clear();
		idList.addAll(list.idList);
		// Copy the list
		clear();
		addAll(list);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Identifiable#hashCode()
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int hashCode() {
		// Local Declaration
		int hash = 11;

		// Compute the hashcode for the identity information
		hash = 31 * hash + idList.hashCode();
		// Add the hash for the list in
		hash = 31 * hash + super.hashCode();
		// Return the computed hash code
		return hash;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Identifiable#equals(Object otherObject)
	 */
	public boolean equals(Object otherObject) {
		// Local Declarations
		boolean retVal = false;
		AbstractListComponent<T> castedOtherObject = null;

		// Check null and base type first. Note that the instanceof operator
		// must be used because subclasses of ICEObject can be anonymous.
		if (otherObject != null
				&& (otherObject instanceof AbstractListComponent<?>)) {
			// See if they are the same reference on the heap
			if (this == otherObject) {
				retVal = true;
			} else {
				castedOtherObject = (AbstractListComponent<T>) otherObject;
				// Check each member attribute
				retVal = (idList.equals(castedOtherObject.idList))
						&& (source.equals(castedOtherObject.source));
			}
		}

		return retVal;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IUpdateable#register(IUpdateableListener listener)
	 */
	@Override
	public void register(IUpdateableListener listener) {
		// Delegate this to the super class and id list by wrapping the listener
		// and registering it
		WrappedGlazedEventListener glazedListener = new WrappedGlazedEventListener(
				listener, this);
		System.out.println("Registered!");
		source.addListEventListener(glazedListener);
		idList.addListEventListener(glazedListener);
		// Add the wrapped listener to the map so that it can be located later
		// if it needs be unregistered.
		listenerMap.put(listener, glazedListener);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IUpdateable#unregister(IUpdateableListener listener)
	 */
	@Override
	public void unregister(IUpdateableListener listener) {
		// Pull the listener from the map
		ListEventListener glazedListener = listenerMap.get(listener);
		// Unregister it from the lists
		source.removeListEventListener(glazedListener);
		idList.removeListEventListener(glazedListener);
		// Remove the listener from the map
		listenerMap.remove(listener);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Identifiable#setId(int id)
	 */
	@Override
	public void setId(int id) {
		if (id >= 0) {
			idList.set(0, String.valueOf(id));
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Identifiable#getDescription()
	 */
	@Override
	public String getDescription() {
		return idList.get(2);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Identifiable#getId()
	 */
	@Override
	public int getId() {
		return Integer.valueOf(idList.get(0));
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Identifiable#setName(String name)
	 */
	@Override
	public void setName(String name) {
		if (name != null) {
			idList.set(1, name);
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Identifiable#getName()
	 */
	@Override
	public String getName() {
		return idList.get(1);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Identifiable#setDescription(String description)
	 */
	@Override
	public void setDescription(String description) {
		if (description != null) {
			idList.set(2, description);
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see TransformedList#listChanged(ListEvent)
	 */
	@Override
	public void listChanged(ListEvent<T> listChanges) {
		System.out.println("List changed!");
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see TransformedList#isWriteable()
	 */
	@Override
	protected boolean isWritable() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Component#accept(IComponentVisitor)
	 */
	@Override
	public void accept(IComponentVisitor visitor) {};

	/**
	 * (non-Javadoc)
	 * 
	 * @see Cloneable#clone()
	 */
	@Override
	public Object clone() { return null;};

	/**
	 * (non-Javadoc)
	 * 
	 * @see IUpdateable#update(String updatedKey, String newValue)
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public void update(String updatedKey, String newValue) {};

}
