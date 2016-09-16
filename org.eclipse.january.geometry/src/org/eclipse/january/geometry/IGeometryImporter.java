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

import java.nio.file.Path;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IGeometry Importer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This interface defines the operations by which Geometry instances can be imported from disk. Importers are expected to provide a load operation in addition to a short description and a list of valid file types.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.IGeometryImporter#getFileTypes <em>File Types</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.IGeometryImporter#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.january.geometry.GeometryPackage#getIGeometryImporter()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IGeometryImporter extends EObject {
	/**
	 * Returns the value of the '<em><b>File Types</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of file format types supported by this importer.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>File Types</em>' attribute list.
	 * @see org.eclipse.january.geometry.GeometryPackage#getIGeometryImporter_FileTypes()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getFileTypes();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A brief description of the format supported by the importer.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.january.geometry.GeometryPackage#getIGeometryImporter_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.IGeometryImporter#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This operation directs the import to load the geometry at the specified Path.
	 * <!-- end-model-doc -->
	 * @model pathDataType="org.eclipse.january.geometry.Path"
	 * @generated
	 */
	Geometry load(Path path);

} // IGeometryImporter