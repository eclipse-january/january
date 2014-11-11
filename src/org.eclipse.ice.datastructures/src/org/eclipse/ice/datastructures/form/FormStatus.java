/*******************************************************************************
 * Copyright (c) 2011, 2014 UT-Battelle, LLC.
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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <!-- begin-UML-doc -->
 * <p>
 * This enumeration describes the degree to which the Form is found acceptable.
 * </p>
 * <p>
 * </p>
 * <!-- end-UML-doc -->
 * 
 * @author Jay Jay Billings
 * @generated 
 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@XmlType
@XmlEnum(Integer.class)
public enum FormStatus {
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This literal means that the previous Form submitted was accepted, but
	 * another Form with additional information must be submitted.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlEnumValue("1")
	NeedsInfo,
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This literal means that the Form has all of the information it needs and
	 * can be processed.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlEnumValue("2")
	ReadyToProcess,
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This literal means that the Form is currently being processed.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlEnumValue("3")
	Processing,
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This literal means that the Form has been previously and completely
	 * processed for its current configuration.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlEnumValue("4")
	Processed,
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This literal means that the Form is still in review after a prior version
	 * was submitted.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlEnumValue("5")
	InReview,
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This literal means that some invalid information was submitted in the
	 * Form.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlEnumValue("6")
	InfoError,
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This literal means that the Form is unacceptable for some reason outside
	 * of its own nature. It does not mean that Form is erroneous or not capable
	 * of being processed, but instead it means that the Form can not be
	 * processed, reviewed or used in any other way except as a source of
	 * information.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlEnumValue("7")
	Unacceptable
}