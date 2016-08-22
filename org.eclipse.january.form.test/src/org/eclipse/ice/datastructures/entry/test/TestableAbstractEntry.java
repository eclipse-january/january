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
package org.eclipse.ice.datastructures.entry.test;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.january.form.AbstractEntry;
import org.eclipse.january.form.IEntryVisitor;
import org.eclipse.january.form.IUpdateable;

/**
 * This class is simply for testing AbstractEntry.
 * 
 * @author Alex McCaskey
 *
 */
@XmlRootElement(name = "TestableAbstractEntry")
@XmlAccessorType(XmlAccessType.FIELD)
public class TestableAbstractEntry extends AbstractEntry {

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.entry.AbstractEntry#clone()
	 */
	@Override
	public Object clone() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.entry.AbstractEntry#setValue(java.lang.String[])
	 */
	@Override
	public boolean setValue(String... values) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.entry.AbstractEntry#getAllowedValues()
	 */
	@Override
	public List<String> getAllowedValues() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.entry.AbstractEntry#setAllowedValues(java.util.List)
	 */
	@Override
	public void setAllowedValues(List<String> values) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.entry.AbstractEntry#update(org.eclipse.ice.datastructures.ICEObject.IUpdateable)
	 */
	@Override
	public void update(IUpdateable component) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] getValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accept(IEntryVisitor visitor) {
		// TODO Auto-generated method stub
		
	}
	
}
