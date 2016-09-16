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
 * A representation of the model object '<em><b>Triangle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A triangle is a collection of three vertices that are connected by three edges and together form a discrete plane in three dimensional space.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.Triangle#getNormal <em>Normal</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.Triangle#getVertices <em>Vertices</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.january.geometry.GeometryPackage#getTriangle()
 * @model
 * @generated
 */
public interface Triangle extends EObject {
	/**
	 * Returns the value of the '<em><b>Normal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The normal, or normal vector, is a vector that is perpendicular to the surface of the triangle. It is computed by taking the cross product of any two vectors formed between the three vertices.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Normal</em>' containment reference.
	 * @see #setNormal(Vertex)
	 * @see org.eclipse.january.geometry.GeometryPackage#getTriangle_Normal()
	 * @model containment="true"
	 * @generated
	 */
	Vertex getNormal();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.Triangle#getNormal <em>Normal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Normal</em>' containment reference.
	 * @see #getNormal()
	 * @generated
	 */
	void setNormal(Vertex value);

	/**
	 * Returns the value of the '<em><b>Vertices</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.january.geometry.Vertex}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Each triangle has exactly three vertices where its edges meet.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Vertices</em>' containment reference list.
	 * @see org.eclipse.january.geometry.GeometryPackage#getTriangle_Vertices()
	 * @model containment="true" upper="3"
	 * @generated
	 */
	EList<Vertex> getVertices();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model otherObjectDataType="org.eclipse.january.geometry.Object"
	 * @generated
	 */
	boolean equals(Object otherObject);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	int hashCode();

} // Triangle