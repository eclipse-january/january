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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.ice.datastructures.ICEObject.IUpdateable;
import org.eclipse.ice.datastructures.ICEObject.Identifiable;

/**
 * The DiscreteEntry is a subclass of AbstractEntry that only allows clients to
 * set a value from an existing list of allowed values.
 * 
 * @author Alex McCaskey
 *
 */
@XmlRootElement(name = "DiscreteEntry")
@XmlAccessorType(XmlAccessType.FIELD)
public class DiscreteEntry extends AbstractEntry {

	/**
	 * This list stores either the exact values that the Entry may have or a
	 * range in which the value of the Entry must exist depending on the
	 * AllowedValueType.
	 */
	@XmlElement(name = "AllowedValues")
	protected List<String> allowedValues;

	/**
	 * The Constructor
	 */
	public DiscreteEntry() {
		allowedValues = new ArrayList<String>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ice.datastructures.entry.AbstractEntry#clone()
	 */
	@Override
	public Object clone() {
		DiscreteEntry entry = new DiscreteEntry();
		entry.copy(this);
		return entry;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ice.datastructures.entry.AbstractEntry#setValue(java.lang.
	 * String[])
	 */
	@Override
	public boolean setValue(String... values) {
		throw new UnsupportedOperationException(
				"Discrete only supports " + "the storage of one String value, not many, selected from "
						+ "a list of allowed values. " + "Therefore, this operation is not supported.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ice.datastructures.entry.AbstractEntry#setValue(java.lang.
	 * String)
	 */
	@Override
	public boolean setValue(String newValue) {
		// Only set the value if it is allowed
		if (allowedValues.contains(newValue)) {
			return super.setValue(newValue);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ice.datastructures.entry.AbstractEntry#getAllowedValues()
	 */
	@Override
	public List<String> getAllowedValues() {
		return allowedValues;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ice.datastructures.entry.AbstractEntry#setAllowedValues(java.
	 * util.List)
	 */
	@Override
	public void setAllowedValues(List<String> values) {
		allowedValues = values;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ice.datastructures.entry.AbstractEntry#update(org.eclipse.ice
	 * .datastructures.ICEObject.IUpdateable)
	 */
	@Override
	public void update(IUpdateable component) {
		// Do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ice.datastructures.entry.AbstractEntry#getValues()
	 */
	@Override
	public String[] getValues() {
		throw new UnsupportedOperationException(
				"Discrete only supports " + "the storage of one String value, not many, selected from "
						+ "a list of allowed values. " + "Therefore, this operation is not supported.");

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Identifiable#equals(Object otherObject)
	 */
	@Override
	public boolean equals(Object otherObject) {

		if (otherObject != null && (otherObject instanceof DiscreteEntry)) {

			// Make sure everything else is equal
			if (!super.equals(otherObject)) {
				return false;
			}

			// Cast to a DiscreteEntry, we know it is if we are here
			DiscreteEntry otherEntry = (DiscreteEntry) otherObject;

			// Make sure the allowedValues are the same.
			if (allowedValues.equals(otherEntry.allowedValues)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void copy(DiscreteEntry entity) {

		// Return if null
		if (entity == null) {
			return;
		}
		
		super.copy(entity);
		allowedValues = entity.allowedValues;
		return;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.entry.AbstractEntry#hashCode()
	 */
	@Override
	public int hashCode() {

		// Local Declaration
		int hash = 11;

		// Compute the hashcode from this ICEObject's data
		hash = 31 * hash + super.hashCode();
		hash = 31 * hash + allowedValues.hashCode();
		
		return hash;
	}
}
