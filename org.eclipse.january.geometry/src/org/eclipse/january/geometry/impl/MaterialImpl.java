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

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.january.geometry.Material;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Material</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.impl.MaterialImpl#getPhongMatName <em>Phong Mat Name</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.impl.MaterialImpl#getTexture <em>Texture</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.impl.MaterialImpl#getMaterialFiles <em>Material Files</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MaterialImpl extends MinimalEObjectImpl.Container implements Material {
	/**
	 * The default value of the '{@link #getPhongMatName() <em>Phong Mat Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhongMatName()
	 * @generated
	 * @ordered
	 */
	protected static final String PHONG_MAT_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getPhongMatName() <em>Phong Mat Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhongMatName()
	 * @generated
	 * @ordered
	 */
	protected String phongMatName = PHONG_MAT_NAME_EDEFAULT;
	/**
	 * The default value of the '{@link #getTexture() <em>Texture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTexture()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXTURE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getTexture() <em>Texture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTexture()
	 * @generated
	 * @ordered
	 */
	protected String texture = TEXTURE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getMaterialFiles() <em>Material Files</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaterialFiles()
	 * @generated
	 * @ordered
	 */
	protected EList<String> materialFiles;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MaterialImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.MATERIAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPhongMatName() {
		return phongMatName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhongMatName(String newPhongMatName) {
		String oldPhongMatName = phongMatName;
		phongMatName = newPhongMatName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.MATERIAL__PHONG_MAT_NAME, oldPhongMatName, phongMatName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTexture() {
		return texture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTexture(String newTexture) {
		String oldTexture = texture;
		texture = newTexture;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.MATERIAL__TEXTURE, oldTexture, texture));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getMaterialFiles() {
		if (materialFiles == null) {
			materialFiles = new EDataTypeUniqueEList<String>(String.class, this, GeometryPackage.MATERIAL__MATERIAL_FILES);
		}
		return materialFiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeometryPackage.MATERIAL__PHONG_MAT_NAME:
				return getPhongMatName();
			case GeometryPackage.MATERIAL__TEXTURE:
				return getTexture();
			case GeometryPackage.MATERIAL__MATERIAL_FILES:
				return getMaterialFiles();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GeometryPackage.MATERIAL__PHONG_MAT_NAME:
				setPhongMatName((String)newValue);
				return;
			case GeometryPackage.MATERIAL__TEXTURE:
				setTexture((String)newValue);
				return;
			case GeometryPackage.MATERIAL__MATERIAL_FILES:
				getMaterialFiles().clear();
				getMaterialFiles().addAll((Collection<? extends String>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GeometryPackage.MATERIAL__PHONG_MAT_NAME:
				setPhongMatName(PHONG_MAT_NAME_EDEFAULT);
				return;
			case GeometryPackage.MATERIAL__TEXTURE:
				setTexture(TEXTURE_EDEFAULT);
				return;
			case GeometryPackage.MATERIAL__MATERIAL_FILES:
				getMaterialFiles().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GeometryPackage.MATERIAL__PHONG_MAT_NAME:
				return PHONG_MAT_NAME_EDEFAULT == null ? phongMatName != null : !PHONG_MAT_NAME_EDEFAULT.equals(phongMatName);
			case GeometryPackage.MATERIAL__TEXTURE:
				return TEXTURE_EDEFAULT == null ? texture != null : !TEXTURE_EDEFAULT.equals(texture);
			case GeometryPackage.MATERIAL__MATERIAL_FILES:
				return materialFiles != null && !materialFiles.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (phongMatName: ");
		result.append(phongMatName);
		result.append(", texture: ");
		result.append(texture);
		result.append(", materialFiles: ");
		result.append(materialFiles);
		result.append(')');
		return result.toString();
	}

} //MaterialImpl