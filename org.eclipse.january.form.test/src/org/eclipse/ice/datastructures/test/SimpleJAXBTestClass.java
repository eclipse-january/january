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
package org.eclipse.ice.datastructures.test;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * This class is used for testing JAXB parsing in ICE. It is a simple class with
 * a single attribute and a single accessor pair for that value. The class is
 * annotated with JAXB bindings.
 * </p>
 * 
 * @author Jay Jay Billings
 */
@XmlRootElement(name = "SimpleJAXBTestClass")
public class SimpleJAXBTestClass {
	/**
	 * <p>
	 * An integer.
	 * </p>
	 * 
	 */
	private int simpleInt;

	/**
	 * <p>
	 * This operation gets the integer.
	 * </p>
	 * 
	 * @return <p>
	 *         The integer
	 *         </p>
	 */
	@XmlAttribute()
	public int getInt() {
		// TODO Auto-generated method stub
		return simpleInt;
	}

	/**
	 * <p>
	 * This operation sets the integer.
	 * </p>
	 * 
	 * @param value
	 *            <p>
	 *            The value of the integer
	 *            </p>
	 */
	public void setInt(int value) {
		// TODO Auto-generated method stub
		simpleInt = value;
	}
}