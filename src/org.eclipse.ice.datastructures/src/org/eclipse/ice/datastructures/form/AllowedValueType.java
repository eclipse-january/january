/*******************************************************************************
\ * Copyright (c) 2011, 2014 UT-Battelle, LLC.
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
package org.eclipse.ice.datastructures.form;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <!-- begin-UML-doc -->
 * <p>
 * The ValueType enumeration describes the types of Values that are stored for
 * in an instance of the Entry class.
 * </p>
 * <!-- end-UML-doc -->
 * 
 * @author Jay Jay Billings
 * @generated 
 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@XmlEnum
public enum AllowedValueType {
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This literal means that the Value stored by an Entry must equal one of
	 * the values stored in the allowedValues array for that Entry.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	Discrete,
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This literal means that the value stored by an Entry must be within the
	 * range of values specified by the allowedValues array for that Entry.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	Continuous,	
	/**
	 * This literal means the Entry is used in a form for specifying some sort
	 * of file (such as an input file). The value of the entry will be a
	 * filename, and the list of allowedValues will be files in the workspace.
	 */
	File,
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	Undefined
}