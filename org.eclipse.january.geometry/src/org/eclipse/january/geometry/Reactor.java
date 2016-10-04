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
 * A representation of the model object '<em><b>Reactor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A shape representing the core reactor in a nuclear reactor. It is represented by a cut away of a capsule shape around a series of pipes, consisting of two strainght rectangular sides along its shortest dimension, a curved side along the middle dimension, and the largest dimension left open to show the pipes within.
 * 
 * This class is part of the nuclear reactor example code, and is included here as an example of extending the model.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.Reactor#getPipes <em>Pipes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.january.geometry.GeometryPackage#getReactor()
 * @model
 * @generated
 */
public interface Reactor extends Shape {
	/**
	 * Returns the value of the '<em><b>Pipes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.january.geometry.Pipe}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pipes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pipes</em>' containment reference list.
	 * @see org.eclipse.january.geometry.GeometryPackage#getReactor_Pipes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Pipe> getPipes();

} // Reactor