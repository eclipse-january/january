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

/**
 * <!-- begin-UML-doc -->
 * <p>
 * The AcceptanceCode enumeration is the list of all possible return values that
 * will be returned by Forms when updating Entries or by Items when submitting
 * Forms.
 * </p>
 * <!-- end-UML-doc -->
 * 
 * @author Jay Jay Billings
 * @generated 
 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public enum AcceptanceCode {
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Returning this literal means that the Entry or Form was accepted as
	 * valid.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	Valid,
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Returning this literal means that the Entry or Form was not accepted and
	 * that for some reason or other the values were erroneous.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	Invalid,
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Returning this literal means that the Entry or Form was accepted, but not
	 * checked for validity.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	Accepted,
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This literal means that the submission was rejected and should be
	 * resubmitted after corrections are made.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	Rejected,
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Returning this literal means that the Entry or Form was not accepted by
	 * the Form or Item because of some unexpected failure.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	AcceptanceFailure
}