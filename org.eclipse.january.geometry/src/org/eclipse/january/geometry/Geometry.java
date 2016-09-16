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
 * A representation of the model object '<em><b>Geometry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Geometry is a collection of shapes that form a complex, three dimensional object.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.Geometry#getVertexSources <em>Vertex Sources</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.january.geometry.GeometryPackage#getGeometry()
 * @model
 * @generated
 */
public interface Geometry extends INode {

	/**
	 * Returns the value of the '<em><b>Vertex Sources</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.january.geometry.VertexSource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vertex Sources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertex Sources</em>' containment reference list.
	 * @see org.eclipse.january.geometry.GeometryPackage#getGeometry_VertexSources()
	 * @model containment="true"
	 * @generated
	 */
	EList<VertexSource> getVertexSources();
	
	/**
	 * Gets a vertex source which has all of the vertex sources appended to it
	 * @return VertexSource The Union of the vertex sources list
	 */
	VertexSource getVertexSource();
} // Geometry