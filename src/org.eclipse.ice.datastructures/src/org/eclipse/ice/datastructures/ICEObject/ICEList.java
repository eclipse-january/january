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
package org.eclipse.ice.datastructures.ICEObject;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

/**
 * <!-- begin-UML-doc -->
 * <p>
 * A generic list container used by ICE to transmit lists in XML.
 * </p>
 * <!-- end-UML-doc -->
 * 
 * @author Jay Jay Billings
 * @generated 
 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@XmlRootElement(name = "ICEList")
public class ICEList<varType> {
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The stored list.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ArrayList<varType> storedList;

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation retrieves the list.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The list.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlElement(name = "ListElement")
	public ArrayList<varType> getList() {
		// begin-user-code
		return storedList;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation retrieves stores the list.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param list
	 *            <p>
	 *            The list to store
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setList(ArrayList<varType> list) {
		// begin-user-code

		storedList = list;

		// end-user-code
	}
}