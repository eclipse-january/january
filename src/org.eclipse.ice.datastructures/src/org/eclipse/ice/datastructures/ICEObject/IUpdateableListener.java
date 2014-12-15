/*******************************************************************************
 * Copyright (c) 2013, 2014 UT-Battelle, LLC.
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

import java.util.ArrayList;

/**
 * <!-- begin-UML-doc -->
 * <p>
 * The IComponentListener interface specifies the operations that must be
 * realized by classes in order to receive updates from realizations of the
 * Component interface when their state changes.
 * </p>
 * <!-- end-UML-doc -->
 * 
 * @author Jay Jay Billings
 * @generated 
 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface IUpdateableListener {
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The Component that was updated.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	ArrayList<IUpdateable> component = null;

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation notifies the listener that an update has occurred in the
	 * Component.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param component The component that was updated in some way.
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void update(IUpdateable component);
}