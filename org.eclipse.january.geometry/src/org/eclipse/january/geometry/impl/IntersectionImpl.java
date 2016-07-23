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
/**
 */
package org.eclipse.january.geometry.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.january.geometry.Intersection;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Intersection</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public class IntersectionImpl extends OperatorImpl implements Intersection {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected IntersectionImpl() {
		super();

		// Initialize the type
		type = "intersection";
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.INTERSECTION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Object clone() {

		// Create a new intersection
		Intersection clone = GeometryFactory.eINSTANCE.createIntersection();

		// Make it a copy of this
		clone.copy(this);
		return clone;
	}

} // IntersectionImpl
