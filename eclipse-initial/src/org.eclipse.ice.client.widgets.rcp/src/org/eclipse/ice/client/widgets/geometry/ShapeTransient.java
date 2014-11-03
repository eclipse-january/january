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
package org.eclipse.ice.client.widgets.geometry;

import java.io.IOException;

import com.jme3.export.JmeExporter;
import com.jme3.export.JmeImporter;
import com.jme3.export.Savable;

import org.eclipse.ice.datastructures.form.geometry.IShape;

/**
 * <!-- begin-UML-doc -->
 * <p>
 * Wrapper class for allowing an IShape to be stored in a JME3 Spatial as user
 * data
 * </p>
 * <p>
 * ShapeTransient implements JME3's Savable interface but does not offer the
 * ability to persist the IShape. This class exists solely to avoid IShape
 * implementing Savable.
 * </p>
 * <!-- end-UML-doc -->
 * 
 * @author abd
 * @generated 
 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ShapeTransient implements Savable {
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The associated shape
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private IShape shape;

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Associates a new ShapeTransient with the given IShape
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param shape
	 *            <p>
	 *            The associated shape
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ShapeTransient(IShape shape) {
		// begin-user-code
		this.shape = shape;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Returns the associated shape
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The associated shape
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public IShape getShape() {
		// begin-user-code
		return shape;
		// end-user-code
	}

	/**
	 * Not implemented
	 */
	@Override
	public void read(JmeImporter importer) throws IOException {
		// Do nothing
	}

	/**
	 * Not implemented
	 */
	@Override
	public void write(JmeExporter exporter) throws IOException {
		// Do nothing
	}
}