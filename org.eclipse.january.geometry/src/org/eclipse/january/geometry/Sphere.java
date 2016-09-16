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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sphere</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A sphere, or ball, is a three dimensional shape where the distance from the center of the sphere to any point on its surface, called the radius, is constant.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.Sphere#getRadius <em>Radius</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.january.geometry.GeometryPackage#getSphere()
 * @model
 * @generated
 */
public interface Sphere extends Shape {
	/**
	 * Returns the value of the '<em><b>Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The radius is the distance from the center of the sphere to any point on the surface. It is constant across the entire sphere.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Radius</em>' attribute.
	 * @see #setRadius(double)
	 * @see org.eclipse.january.geometry.GeometryPackage#getSphere_Radius()
	 * @model
	 * @generated
	 */
	double getRadius();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.Sphere#getRadius <em>Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Radius</em>' attribute.
	 * @see #getRadius()
	 * @generated
	 */
	void setRadius(double value);

} // Sphere