/*******************************************************************************
 * Copyright (c) 2016 UT-Battelle, LLC. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     UT-Battelle, LLC. - initial API and implementation
 *******************************************************************************/
package org.eclipse.january.geometry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Material</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.Material#getPhongMatName <em>Phong Mat Name</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.Material#getTexture <em>Texture</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.Material#getMaterialFiles <em>Material Files</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.january.geometry.GeometryPackage#getMaterial()
 * @model
 * @generated
 */
public interface Material extends EObject {

	/**
	 * Returns the value of the '<em><b>Phong Mat Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Phong Mat Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Phong Mat Name</em>' attribute.
	 * @see #setPhongMatName(String)
	 * @see org.eclipse.january.geometry.GeometryPackage#getMaterial_PhongMatName()
	 * @model
	 * @generated
	 */
	String getPhongMatName();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.Material#getPhongMatName <em>Phong Mat Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phong Mat Name</em>' attribute.
	 * @see #getPhongMatName()
	 * @generated
	 */
	void setPhongMatName(String value);

	/**
	 * Returns the value of the '<em><b>Texture</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Texture</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Texture</em>' attribute.
	 * @see #setTexture(String)
	 * @see org.eclipse.january.geometry.GeometryPackage#getMaterial_Texture()
	 * @model
	 * @generated
	 */
	String getTexture();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.Material#getTexture <em>Texture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Texture</em>' attribute.
	 * @see #getTexture()
	 * @generated
	 */
	void setTexture(String value);

	/**
	 * Returns the value of the '<em><b>Material Files</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Material Files</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Material Files</em>' attribute list.
	 * @see org.eclipse.january.geometry.GeometryPackage#getMaterial_MaterialFiles()
	 * @model
	 * @generated
	 */
	EList<String> getMaterialFiles();
} // Material