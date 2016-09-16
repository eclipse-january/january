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
package org.eclipse.january.geometry.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.january.geometry.Complement;
import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.GeometryPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Complement</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ComplementImpl extends OperatorImpl implements Complement {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected ComplementImpl() {
		super();

		// Initialize the type
		type = "complement";
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.COMPLEMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Object clone() {

		// Create a new complement
		Complement clone = GeometryFactory.eINSTANCE.createComplement();

		// Make it a copy of this
		clone.copy(this);
		return clone;
	}

} // ComplementImpl