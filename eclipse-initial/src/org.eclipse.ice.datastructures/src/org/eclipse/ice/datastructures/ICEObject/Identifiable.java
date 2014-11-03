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

/**
 * <!-- begin-UML-doc -->
 * <p>
 * This interface describes operations that would make a class uniquely
 * identifiable to ICE.
 * </p>
 * <!-- end-UML-doc -->
 * 
 * @author bkj
 * @generated 
 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface Identifiable {
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation sets the identification number of the Identifiable entity.
	 * It must be greater than zero.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param id
	 *            <p>
	 *            The unique identification number that should be assigned to
	 *            the Identifiable entity.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setId(int id);

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation retrieves the description of the Identifiable entity.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The description of the Identifiable entity.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getDescription();

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation retrieves the identification number of the Identifiable
	 * entity.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The unique identification number of the Identifiable entity.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int getId();

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation sets the name of the Identifiable entity.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param name
	 *            <p>
	 *            The name that should be given to the Identifiable entity.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setName(String name);

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation retrieves the name of the Identifiable entity.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The name of the Identifiable entity.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getName();

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation sets the description of the Identifiable entity.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param description
	 *            <p>
	 *            The description that should be stored for the Identifiable
	 *            entity.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setDescription(String description);

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation is used to check equality between the ICE and another
	 * Identifiable entity. It returns true if the Identifiable entities are
	 * equal and false if they are not.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param otherObject
	 *            <p>
	 *            The other Identifiable entity that should be compared with
	 *            this one.
	 *            </p>
	 * @return <p>
	 *         True if the Identifiable entitys are equal, false otherwise.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean equals(Object otherObject);

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation returns the hashcode value of the Identifiable entity.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The hashcode of the Identifiable entity.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int hashCode();

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation returns a clone of the Identifiable instance using a deep
	 * copy.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The new clone.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Object clone();

}