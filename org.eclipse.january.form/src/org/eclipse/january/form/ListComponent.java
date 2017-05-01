/*******************************************************************************
 * Copyright (c) 2011, 2016 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - Jay Jay 
 *   Billings
 *******************************************************************************/
package org.eclipse.january.form;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.TransformedList;
import ca.odell.glazedlists.event.ListEvent;
import ca.odell.glazedlists.event.ListEventListener;
import ca.odell.glazedlists.gui.WritableTableFormat;

/**
 * This is a base class for Components that are based on lists. Its primary
 * purpose is to provide all of the standard list operations expected from Java
 * Collections in a class that realizes January's additional requirements for
 * persistence, unique identification, and notifications.
 * <p>
 * It implements the Component to match up with the January requirements and extends
 * the TransformedList from GlazedLists to provide the generic, observable list
 * capabilities.
 * </p>
 * <p>
 * It can be configured to provide a handle to an IElementSource that will
 * provide valid, new elements upon request. This configuration is meant to
 * facilitate the use of the ListComponent as a, for example, proxy for
 * selections made from databases or similar tools. If getElementSource()
 * returns null, clients should feel free to put whatever values they want into
 * the List.
 * </p>
 * <p>
 * This class also realizes the WritableTableFormat interface from GlazedLists
 * so that it can simply be "dropped in" to GlazedList tables in client UIs.
 * This is handled using delegation instead of inheritance so that the format
 * can be easily changed without re-initializing the list. Alternatively, the
 * WritableTableFormat can just be retrieved with a getter too. If the table
 * format is not provided, the behavior is unspecified, but this Component
 * should probably not be put in a Form in that case.
 * </p>
 * <b>Implementation note</b>
 * <p>
 * Unfortunately, there are some tricky implementation details here related to
 * extending TransformedList. The point of a TransformedList is to sit on top of
 * a source list and manipulate it so it is a wrapper around another list,
 * facilitating transformations to that list. This means that in the
 * implementation of this class any work to register listeners or manipulate the
 * list should be done to the source list, not "this" list. TransformedList is
 * the suggested base class for extensions to GlazedLists instead of
 * AbstractEventList, so we will have to live with this for now.
 * </p>
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
public class ListComponent<T> extends TransformedList<T, T>
		implements Component, WritableTableFormat<T> {

	/**
	 * Logger for handling event messages and other information.
	 */
	@XmlTransient
	protected final Logger logger;

	/**
	 * The JanuaryJAXBHandler used to marshal the class to and from XML.
	 */
	@XmlTransient
	protected JanuaryJAXBHandler jaxbManipulator;

	/**
	 * A listener map to map January listeners to ListEventListeners.
	 * <p>
	 * The listeners must have the type Object since the listeners are
	 * registered with both {@link #idList} and the TransformedList's source.
	 * </p>
	 */
	@XmlTransient
	Map<IUpdateableListener, ListEventListener<Object>> listenerMap;

	/**
	 * A BasicEventList that is used to store the identity of this component.
	 * Index 0 - the unique id, cast to a String; Index 1 - the name; Index 2 -
	 * the description; Index 3 - the context
	 * 
	 * Doing this makes it possible to use the built-in updates provided by the
	 * BasicEventList instead of implementing our own here since these
	 * properties are not part of the Transformed list per se and will not have
	 * events posted for them. It also makes almost every other operation easy
	 * to implement too.
	 * 
	 * The context for this object is at index 3. It should be used as described
	 * on {@link org.eclipse.january.form.Identifiable}.
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

		// Create the logger
		logger = LoggerFactory.getLogger(getClass());

		// Store the source list locally too so that JAXB gets it
		jaxbSourceList = (BasicEventList<T>) source;
		// Set up the ids - id, name, description and context
		idList = new BasicEventList<String>();
		idList.add("1");
		idList.add("January Object");
		idList.add("January Object");
		idList.add("");
		// Setup the listener map
		listenerMap = new HashMap<IUpdateableListener, ListEventListener<Object>>();
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
	 * @see Identifiable#hashCode()
	 */
	@Override
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
	 * @see Identifiable#equals(Object otherObject)
	 */
	@Override
	public boolean equals(Object otherObject) {
		// Local Declarations
		boolean retVal = false;
		ListComponent<?> castedOtherObject = null;

		// Check null and base type first. Note that the instanceof operator
		// must be used because subclasses of JanuaryObject can be anonymous.
		if (otherObject != null && (otherObject instanceof ListComponent<?>)) {
			// See if they are the same reference on the heap
			if (this == otherObject) {
				retVal = true;
			} else {
				castedOtherObject = (ListComponent<?>) otherObject;
				// Check each member attribute
				retVal = (idList.equals(castedOtherObject.idList))
						&& (source.equals(castedOtherObject.source));
			}
		}

		return retVal;
	}

	/**
	 * @see IUpdateable#register(IUpdateableListener listener)
	 */
	@Override
	public void register(IUpdateableListener listener) {
		// Delegate this to the super class and id list by wrapping the listener
		// and registering it
		WrappedGlazedEventListener<Object> glazedListener = new WrappedGlazedEventListener<Object>(
				listener, this);
		logger.info("Registered!");
		source.addListEventListener(glazedListener);
		idList.addListEventListener(glazedListener);
		// Add the wrapped listener to the map so that it can be located later
		// if it needs be unregistered.
		listenerMap.put(listener, glazedListener);
	}

	/**
	 * @see IUpdateable#unregister(IUpdateableListener listener)
	 */
	@Override
	public void unregister(IUpdateableListener listener) {
		// Pull the listener from the map
		ListEventListener<Object> glazedListener = listenerMap.get(listener);
		// Unregister it from the lists
		source.removeListEventListener(glazedListener);
		idList.removeListEventListener(glazedListener);
		// Remove the listener from the map
		listenerMap.remove(listener);
	}

	/**
	 * @see Identifiable#setId(int id)
	 */
	@Override
	public void setId(int id) {
		if (id >= 0) {
			idList.set(0, String.valueOf(id));
		}
	}

	/**
	 * @see Identifiable#getDescription()
	 */
	@Override
	public String getDescription() {
		return idList.get(2);
	}

	/**
	 * @see Identifiable#getId()
	 */
	@Override
	public int getId() {
		return Integer.valueOf(idList.get(0));
	}

	/**
	 * @see Identifiable#setName(String name)
	 */
	@Override
	public void setName(String name) {
		if (name != null) {
			idList.set(1, name);
		}
	}

	/**
	 * @see Identifiable#getName()
	 */
	@Override
	public String getName() {
		return idList.get(1);
	}

	/**
	 * @see Identifiable#setDescription(String description)
	 */
	@Override
	public void setDescription(String description) {
		if (description != null) {
			idList.set(2, description);
		}
	}

	/**
	 * @see TransformedList#listChanged(ListEvent)
	 */
	@Override
	public void listChanged(ListEvent<T> listChanges) {
		logger.info("List changed!");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.odell.glazedlists.TransformedList#isWritable()
	 */
	@Override
	protected boolean isWritable() {
		return true;
	}

	/**
	 * @see Component#accept(IComponentVisitor)
	 */
	@Override
	public void accept(IComponentVisitor visitor) {
		visitor.visit(this);
	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() {
		// Create a copy of this list
		ListComponent<T> copy = new ListComponent<T>();
		copy.copy(this);
		return copy;
	};

	/**
	 * @see IUpdateable#update(String updatedKey, String newValue)
	 */
	@Override
	public void update(String updatedKey, String newValue) {
	}

	/**
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

	/**
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

	/**
	 * @see ca.odell.glazedlists.gui.TableFormat#getColumnValue(java.lang.Object,
	 *      int)
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

	/**
	 * @see ca.odell.glazedlists.gui.WritableTableFormat#isEditable(java.lang.Object,
	 *      int)
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
	 * ca.odell.glazedlists.gui.WritableTableFormat#setColumnValue(java.lang.
	 * Object, java.lang.Object, int)
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

	/**
	 * Registers the specified listener to receive change updates for this list.
	 * <p>
	 * ListComponent also registers the listener to the underlying source list.
	 * Effectively, this method can be used to register glazed list listeners.
	 * </p>
	 */
	@Override
	public void addListEventListener(
			ListEventListener<? super T> listChangeListener) {
		super.addListEventListener(listChangeListener);

		// Add the listener to the TransformedList's source EventList.
		super.source.addListEventListener(listChangeListener);
	}

	/**
	 * Removes the specified listener from receiving change updates for this
	 * list.
	 * <p>
	 * ListComponent also removes the listener from the underlying source list.
	 * Effectively, this method can be used to unregister glazed list listeners.
	 * </p>
	 */
	@Override
	public void removeListEventListener(
			ListEventListener<? super T> listChangeListener) {
		super.removeListEventListener(listChangeListener);

		// Remove the listener from the TransformedList's source EventList.
		super.source.removeListEventListener(listChangeListener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ice.datastructures.JanuaryObject.Identifiable#getContext()
	 */
	@Override
	public String getContext() {
		return idList.get(3);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ice.datastructures.JanuaryObject.Identifiable#setContext(java.
	 * lang.String)
	 */
	@Override
	public void setContext(String context) {
		idList.set(3, context);
	}

}
