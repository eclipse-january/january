/*******************************************************************************
 * Copyright (c) 2012, 2014 UT-Battelle, LLC.
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
 * <!-- begin-UML-doc -->
 * <p>
 * This class is used for testing JAXB parsing in ICE. It is a simple class with
 * a single attribute and a single accessor pair for that value. The class is
 * annotated with JAXB bindings.
 * </p>
 * <!-- end-UML-doc -->
 * 
 * @author jaybilly
 * @generated 
 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@XmlRootElement(name = "SimpleJAXBTestClass")
public class SimpleJAXBTestClass {
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * An integer.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private int simpleInt;

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation gets the integer.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The integer
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlAttribute()
	public int getInt() {
		// begin-user-code
		// TODO Auto-generated method stub
		return simpleInt;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation sets the integer.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param value
	 *            <p>
	 *            The value of the integer
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setInt(int value) {
		// begin-user-code
		// TODO Auto-generated method stub
		simpleInt = value;
		// end-user-code
	}
}