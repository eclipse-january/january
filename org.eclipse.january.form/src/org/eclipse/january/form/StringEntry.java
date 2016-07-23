/*******************************************************************************
 * Copyright (c) 2012, 2016- UT-Battelle, LLC.
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
package org.eclipse.january.form;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The StringEntry is an AbstractEntry that only contains an 
 * undefined, String-valued value. It does not allow clients to set 
 * multiple values or specify allowed values.  
 * 
 * @author Alex McCaskey
 *
 */
@XmlRootElement(name = "StringEntry")
@XmlAccessorType(XmlAccessType.FIELD)
public class StringEntry extends AbstractEntry {

	public StringEntry() {
		super();
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.entry.AbstractEntry#clone()
	 */
	@Override
	public Object clone() {
		StringEntry entry = new StringEntry();
		entry.copy(this);
		return entry;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.entry.AbstractEntry#setValue(java.lang.String[])
	 */
	@Override
	public boolean setValue(String... values) {
		throw new UnsupportedOperationException("StringEntry only supports "
				+ "the storage of one String value, not many. "
				+ "Therefore, this operation is not supported.");
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.entry.AbstractEntry#getValues()
	 */
	@Override
	public String[] getValues() {
		throw new UnsupportedOperationException(
				"Discrete only supports " + "the storage of one String value, not many, selected from "
						+ "a list of allowed values. " + "Therefore, this operation is not supported.");

	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.entry.AbstractEntry#getAllowedValues()
	 */
	@Override
	public List<String> getAllowedValues() {
		throw new UnsupportedOperationException("StringEntry allows any String to "
				+ "be entered as the value. There are no allowed values. Therefore this "
				+ "operation is not supported.");
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.entry.AbstractEntry#setAllowedValues(java.util.List)
	 */
	@Override
	public void setAllowedValues(List<String> values) {
		throw new UnsupportedOperationException("StringEntry allows any String to "
				+ "be entered as the value. There are no allowed values. Therefore this "
				+ "operation is not supported.");

	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.entry.AbstractEntry#update(org.eclipse.ice.datastructures.ICEObject.IUpdateable)
	 */
	@Override
	public void update(IUpdateable component) {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.entry.IEntry#accept(org.eclipse.ice.datastructures.entry.IEntryVisitor)
	 */
	@Override
	public void accept(IEntryVisitor visitor) {
		visitor.visit(this);
	}

}
