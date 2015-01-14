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

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.eclipse.ice.datastructures.componentVisitor.IComponentVisitor;

import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.TransformedList;
import ca.odell.glazedlists.event.ListEvent;
import ca.odell.glazedlists.event.ListEventListener;
import ca.odell.glazedlists.gui.WritableTableFormat;

/**
 * This is a base class for Components that are based on lists. Its primary
 * purpose is to provide all of the standard list operations expected from Java
 * Collections in a class that realizes ICE's additional requirements for
 * persistence, unique identification, and notifications.
 * 
 * It implements the Component to match up with the ICE requirements and extends
 * the TransformedList from GlazedLists to provide the generic, observable list
 * capabilities.
 * 
 * It can be configured to provide a handle to an IElementSource that will
 * provide valid, new elements upon request. This configuration is meant to
 * facilitate the use of the ListComponent as a, for example, proxy for
 * selections made from databases or similar tools. If getElementSource()
 * returns null, clients should feel free to put whatever values they want into
 * the List.
 * 
 * This class also realizes the WritableTableFormat interface from GlazedLists
 * so that it can simply be "dropped in" to GlazedList tables in client UIs.
 * This is handled using delegation instead of inheritance so that the format
 * can be easily changed without re-initializing the list. Alternatively, the
 * WritableTableFormat can just be retrieved with a getter too. If the table
 * format is not provided, the behavior is unspecified, but this Component
 * should probably not be put in a Form in that case.
 * 
 * <b>Implementation note</b>
 * 
 * Unfortunately, there are some tricky implementation details here related to
 * extending TransformedList. The point of a TransformedList is to sit on top of
 * a source list and manipulate it so it is a wrapper around another list,
 * facilitating transformations to that list. This means that in the
 * implementation of this class any work to register listeners or manipulate the
 * list should be done to the source list, not "this" list. TransformedList is
 * the suggested base class for extensions to GlazedLists instead of
 * AbstractEventList, so we will have to live with this for now.
 * 
 * I also had to override the ListEventListener registration operations to make
 * sure that the source list was registered. The TransformedList by defaults
 * registers listeners against itself, not the source, but it processes all of
 * the list additions, etc., through the source.
 * 
 * @author Jay Jay Billings
 * 
 */
@XmlRootElement(name = "ListComponent")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListComponent<T> extends TransformedList<T, T> implements
		Component, WritableTableFormat<T> {

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

	/**
	 * A handle to the source list that is necessary for JAXB to properly handle
	 * this class.
	 */
	protected BasicEventList<T> jaxbSourceList;

	/**
	 * The IElementSource provides a list of possible new elements for this
	 * list. If it is available, it should be used, but it doesn't have to be.
	 */
	@XmlTransient
	protected IElementSource<T> elementSource;

	/**
	 * The GlazedList WritableTableFormat that should be used by this list when
	 * it is fed to client UI code. Its purpose is simply to describe the list
	 * and how it can be read in a human-friendly fashion.
	 */
	@XmlTransient
	protected WritableTableFormat<T> tableFormat;

	/**
	 * The default constructor.
	 * 
	 * It delegates the actual constructor to the TransformedList constructor
	 * and sets the source list to an empty BasicEventList.
	 */
	public ListComponent() {
		this(new BasicEventList<T>());
	}

	/**
	 * An alternative constructor that provides a handle to an IElementSource so
	 * that clients have a source for valid, new elements to add to the list.
	 * 
	 * @param elementSource
	 *            the IElementSource from which new elements should be drawn.
	 */
	public ListComponent(IElementSource<T> elementSource) {
		this();
		this.elementSource = elementSource;
	}

	/**
	 * A protected constructor inherited from TransformedList.
	 * 
	 * @param source
	 *            The source list used by the TransformedList.
	 */
	protected ListComponent(EventList<T> source) {
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
	 * This operation copies the contents of the ListComponent into the current
	 * object using a deep copy.
	 * 
	 * @param list
	 *            The list from which the values should be copied.
	 */
	public void copy(ListComponent<T> list) {
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
		ListComponent<T> castedOtherObject = null;

		// Check null and base type first. Note that the instanceof operator
		// must be used because subclasses of ICEObject can be anonymous.
		if (otherObject != null && (otherObject instanceof ListComponent<?>)) {
			// See if they are the same reference on the heap
			if (this == otherObject) {
				retVal = true;
			} else {
				castedOtherObject = (ListComponent<T>) otherObject;
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
	public void accept(IComponentVisitor visitor) {
		visitor.visit(this);
	};

	/**
	 * (non-Javadoc)
	 * 
	 * @see Cloneable#clone()
	 */
	@Override
	public Object clone() {
		// Create a copy of this list
		ListComponent<T> copy = new ListComponent<T>();
		copy.copy(this);
		return copy;
	};

	/**
	 * (non-Javadoc)
	 * 
	 * @see IUpdateable#update(String updatedKey, String newValue)
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public void update(String updatedKey, String newValue) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.odell.glazedlists.gui.TableFormat#getColumnCount()
	 */
	@Override
	public int getColumnCount() {

		int retValue = 0;

		// Delegate the call
		if (tableFormat != null) {
			retValue = tableFormat.getColumnCount();
		}

		return retValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.odell.glazedlists.gui.TableFormat#getColumnName(int)
	 */
	@Override
	public String getColumnName(int column) {

		String name = null;

		// Delegate the call
		if (tableFormat != null) {
			name = tableFormat.getColumnName(column);
		}

		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.odell.glazedlists.gui.TableFormat#getColumnValue(java.lang.Object,
	 * int)
	 */
	@Override
	public Object getColumnValue(T baseObject, int column) {

		Object obj = null;

		// Delegate the call
		if (tableFormat != null) {
			obj = tableFormat.getColumnValue(baseObject, column);
		}

		return obj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.odell.glazedlists.gui.WritableTableFormat#isEditable(java.lang.Object,
	 * int)
	 */
	@Override
	public boolean isEditable(T baseObject, int column) {

		boolean retValue = false;

		// Delegate the call
		if (tableFormat != null) {
			retValue = tableFormat.isEditable(baseObject, column);
		}

		return retValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.odell.glazedlists.gui.WritableTableFormat#setColumnValue(java.lang
	 * .Object, java.lang.Object, int)
	 */
	@Override
	public T setColumnValue(T baseObject, Object editedValue, int column) {

		T retValue = null;

		// Delegate the call
		if (tableFormat != null) {
			retValue = tableFormat.setColumnValue(baseObject, editedValue,
					column);
		}

		return retValue;
	};

	/**
	 * This operation sets the element source that should be used by the list
	 * 
	 * @param source
	 *            the element source that provides a list of values that
	 *            *should* be used to seed new entries.
	 */
	public void setElementSource(IElementSource<T> source) {
		elementSource = source;
	}

	/**
	 * This operation returns the element source which should be used to create
	 * new elements to add to the list.
	 * 
	 * @return The element source or null if no IElementSource is provided. If
	 *         null, then the client code should add whatever valid element they
	 *         want.
	 */
	public IElementSource<T> getElementSource() {
		return elementSource;
	}

	/**
	 * This operation sets the GlazedList WritableTableFormat that should be
	 * used to describe this List when used by client UI code or other clients
	 * that need to know how to read the List.
	 * 
	 * @param format
	 *            The table format. Calls to this class' implementation of the
	 *            WritableTableFormat interface will be delegated to this
	 *            format.
	 */
	public void setTableFormat(WritableTableFormat<T> format) {
		tableFormat = format;
	}

	/**
	 * This operation returns the GlazedList WritableTableFormat that is used to
	 * describe this list or null if it was not set.
	 * 
	 * @return The table format or null.
	 */
	public WritableTableFormat<T> getTableFormat() {
		return tableFormat;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.odell.glazedlists.AbstractEventList#addListEventListener(ca.odell.
	 * glazedlists.event.ListEventListener)
	 */
	@Override
	public void addListEventListener(
			ListEventListener<? super T> listChangeListener) {
		// Make sure that the listener is registered with this list
		super.addListEventListener(listChangeListener);
		// And the source
		source.addListEventListener(listChangeListener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.odell.glazedlists.AbstractEventList#removeListEventListener(ca.odell
	 * .glazedlists.event.ListEventListener)
	 */
	@Override
	public void removeListEventListener(
			ListEventListener<? super T> listChangeListener) {
		// Make sure that the listener is unregistered with this list
		super.removeListEventListener(listChangeListener);
		// And the source
		source.removeListEventListener(listChangeListener);
	}

}
