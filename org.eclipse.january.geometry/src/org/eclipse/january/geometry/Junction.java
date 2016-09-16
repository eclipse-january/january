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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Junction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A junction shape between pipes in a reactor. A junction is drawn as a box around the lower ends of its input pipes and the upper ends of its output pipes. 
 * 
 * This class is part of the nuclear reactor example code, and is included here as an example of extending the model.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.Junction#getHeight <em>Height</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.Junction#getZIn <em>ZIn</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.Junction#getZOut <em>ZOut</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.Junction#getInput <em>Input</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.Junction#getOutput <em>Output</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.january.geometry.GeometryPackage#getJunction()
 * @model
 * @generated
 */
public interface Junction extends Shape {
	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The height of the junction. Note that this does not influence how the junction will be drawn.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(double)
	 * @see org.eclipse.january.geometry.GeometryPackage#getJunction_Height()
	 * @model
	 * @generated
	 */
	double getHeight();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.Junction#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(double value);

	/**
	 * Returns the value of the '<em><b>ZIn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The junction's zIn property.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>ZIn</em>' attribute.
	 * @see #setZIn(double)
	 * @see org.eclipse.january.geometry.GeometryPackage#getJunction_ZIn()
	 * @model
	 * @generated
	 */
	double getZIn();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.Junction#getZIn <em>ZIn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ZIn</em>' attribute.
	 * @see #getZIn()
	 * @generated
	 */
	void setZIn(double value);

	/**
	 * Returns the value of the '<em><b>ZOut</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The junction's zOut property.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>ZOut</em>' attribute.
	 * @see #setZOut(double)
	 * @see org.eclipse.january.geometry.GeometryPackage#getJunction_ZOut()
	 * @model
	 * @generated
	 */
	double getZOut();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.Junction#getZOut <em>ZOut</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ZOut</em>' attribute.
	 * @see #getZOut()
	 * @generated
	 */
	void setZOut(double value);

	/**
	 * Returns the value of the '<em><b>Input</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.january.geometry.Pipe}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The pipes which provide input flow for this junction.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Input</em>' containment reference list.
	 * @see org.eclipse.january.geometry.GeometryPackage#getJunction_Input()
	 * @model containment="true"
	 * @generated
	 */
	EList<Pipe> getInput();

	/**
	 * Returns the value of the '<em><b>Output</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.january.geometry.Pipe}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The pipes which will receive output from this junction.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Output</em>' containment reference list.
	 * @see org.eclipse.january.geometry.GeometryPackage#getJunction_Output()
	 * @model containment="true"
	 * @generated
	 */
	EList<Pipe> getOutput();

} // Junction