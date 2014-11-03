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
package org.eclipse.ice.datastructures.updateableComposite;

import org.eclipse.ice.datastructures.ICEObject.Identifiable;
import java.util.ArrayList;

/**
 * <!-- begin-UML-doc -->
 * <p>
 * The IUpdateable interface provides a single update operation that may be used
 * by implementers to receive an update based on a key-value pair. This is used
 * by ICEObjects, Components, Entries and other classes to receive updates from
 * the Registry when values stored therein change. More generally it can be used
 * by any class within ICE for receiving or posting updates.
 * </p>
 * <!-- end-UML-doc -->
 * 
 * @author bkj
 * @generated 
 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface IUpdateable extends Identifiable {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	ArrayList<IUpdateableListener> iComponentListener = null;

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation notifies a class that has implemented IUpdateable that the
	 * value associated with the particular key has been updated.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param updatedKey
	 *            <p>
	 *            A unique key that describes the value that to be updated.
	 *            </p>
	 * @param newValue
	 *            <p>
	 *            The updated value of the key.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void update(String updatedKey, String newValue);

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation registers a listener that realizes the IUpdateableListener
	 * interface with the IUpdateable so that it can receive notifications of
	 * changes to the IUpdateable if they are published.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param listener
	 *            <p>
	 *            The new listener that should be notified when the the
	 *            Component's state changes.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void register(IUpdateableListener listener);

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation unregisters a listener that realizes the
	 * IUpdateableListener interface with the IUpdateable so that it will no
	 * longer receive notifications of changes to the IUpdateable if they are
	 * published.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param listener
	 *            <p>
	 *            The listener that should no longer receive updates.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void unregister(IUpdateableListener listener);
}