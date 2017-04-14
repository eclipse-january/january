/*******************************************************************************
 * Copyright (c) 2012, 2014, 2015 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - 
 *   Alex McCaskey
 *******************************************************************************/
package org.eclipse.january.form;

import java.net.URI;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osgi.service.prefs.BackingStoreException;

/**
 * ExecutableEntry is a subclass of the DiscreteEntry that keeps track of a list
 * of executables (as allowed values) for the user to select. The value for this
 * IEntry is the selected executable.
 * 
 * @author Alex McCaskey
 *
 */
@XmlRootElement(name = "ExecutableEntry")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExecutableEntry extends DiscreteEntry {

	/**
	 * Reference to the current URI
	 */
	private URI executableUri;

	/**
	 * A mapping holding allowed values to their URI counterparts. 
	 */
	private HashMap<String, URI> allowedValueToURI;

	/**
	 * The Constructor
	 */
	public ExecutableEntry() {
		super();
		allowedValueToURI = new HashMap<String, URI>();
	}
	
	/**
	 * The constructor for discrete allowed values. 
	 * 
	 * @param allowed
	 */
	public ExecutableEntry(String... allowed) {
		super(allowed);
		allowedValueToURI = new HashMap<String, URI>();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.entry.DiscreteEntry#setValue(java.lang.String[])
	 */
	@Override
	public boolean setValue(String... newValues) {
		URI uri = null;
		if (newValues.length == 2 && (uri = URI.create(newValues[1])) != null && setValue(newValues[0])) {
			allowedValueToURI.put(value, uri);
			executableUri = uri;
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.entry.DiscreteEntry#setValue(java.lang.String)
	 */
	@Override
	public boolean setValue(String newValue) {
		if (super.setValue(newValue)) {
			executableUri = allowedValueToURI.get(newValue);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Return the URI for the current application. 
	 * @return
	 */
	public URI getExecutableURI() {
		return executableUri;
	}

	/**
	 * This operations persists the ExecutableEntry to Eclipse Preferences. 
	 * It constructs the key as the URI.toString and the value as the name 
	 * of the corresponding executable. 
	 * 
	 * @param prefId
	 */
	public void persistToPreferences(String prefId) {
		// Save this App as a Preference
		IEclipsePreferences prefs = InstanceScope.INSTANCE.getNode(prefId);
		try {
			for (String key : allowedValueToURI.keySet()) {
				prefs.put(allowedValueToURI.get(key).toString(), key);
				prefs.flush();
			}
		} catch (BackingStoreException e) {
			logger.error(getClass().getName() + " Exception!", e);
		}
	}

	/**
	 * This operation loads the ExecutableEntry from Eclipse Preferences. 
	 * @param prefId
	 */
	public void loadFromPreferences(String prefId) {
		// Get the Application preferences
		IEclipsePreferences prefs = InstanceScope.INSTANCE.getNode(prefId);
		try {
			for (String key : prefs.keys()) {
				String pref = prefs.get(key, "");
				if (!pref.isEmpty()) {
					allowedValues.add(pref);
					allowedValueToURI.put(pref, URI.create(key));
				}
			}
		} catch (BackingStoreException e) {
			logger.error(getClass().getName() + " Exception!", e);
		}

		if (!allowedValues.isEmpty()) {
			allowedValues.add(0, "Select Application");
			setDefaultValue(allowedValues.get(0));
		} else {
			allowedValues.add("Import Application");
			setDefaultValue(allowedValues.get(0));
		}
	}
	

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.entry.DiscreteEntry#clone()
	 */
	@Override
	public Object clone() {
		ExecutableEntry entry = new ExecutableEntry();
		entry.copy(this);
		return entry;
	}
	

	/**
	 * Copy the source entity's data into this object.
	 * 
	 * @param entity The Entry of which this object will be come a copy.
	 */
	public void copy(ExecutableEntry entity) {

		// Return if null
		if (entity == null) {
			return;
		}

		//Copy all data members
		super.copy(entity);
		executableUri = entity.executableUri;
		
		//Clear the current map
		allowedValueToURI.clear();
		
		//Copy in each value from the other map.
		for(String value : entity.allowedValueToURI.keySet()){
			allowedValueToURI.put(value, allowedValueToURI.get(value));
		}
		
		return;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ice.datastructures.entry.DiscreteEntry#accept(org.eclipse.ice
	 * .datastructures.entry.IEntryVisitor)
	 */
	@Override
	public void accept(IEntryVisitor visitor) {
		visitor.visit(this);
	}

}
