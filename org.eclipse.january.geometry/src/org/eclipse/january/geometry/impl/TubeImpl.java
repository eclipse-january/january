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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.january.geometry.Triangle;
import org.eclipse.january.geometry.Tube;
import org.eclipse.january.geometry.util.MeshUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Tube</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.impl.TubeImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.impl.TubeImpl#getInnerRadius <em>Inner Radius</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.impl.TubeImpl#getRadius <em>Radius</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TubeImpl extends ShapeImpl implements Tube {

	/**
	 * Logger for handling event messages and other information.
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(TubeImpl.class);

	/**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected static final double HEIGHT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected double height = HEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getInnerRadius() <em>Inner Radius</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInnerRadius()
	 * @generated
	 * @ordered
	 */
	protected static final double INNER_RADIUS_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getInnerRadius() <em>Inner Radius</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInnerRadius()
	 * @generated
	 * @ordered
	 */
	protected double innerRadius = INNER_RADIUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getRadius() <em>Radius</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRadius()
	 * @generated
	 * @ordered
	 */
	protected static final double RADIUS_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRadius() <em>Radius</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRadius()
	 * @generated
	 * @ordered
	 */
	protected double radius = RADIUS_EDEFAULT;

	/**
	 * The height value used the last time the mesh was redrawn.
	 * 
	 * @generated NOT
	 */
	protected double prevHeight;

	/**
	 * The inner value used the last time the mesh was redrawn.
	 * 
	 * @generated NOT
	 */
	protected double prevInnerRadius;

	/**
	 * The radius value used the last time the mesh was redrawn.
	 * 
	 * @generated NOT
	 */
	protected double prevRadius;

	/**
	 * The number of sample points along the axis
	 * 
	 * @generated NOT
	 */
	protected final int SEGMENTS = 15;

	/**
	 * The number of sample points about the circumference
	 * 
	 * @generated NOT
	 */
	protected final int RESOLUTION = 25;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TubeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.TUBE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getHeight() {
		return height;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setHeight(double newHeight) {
		double oldHeight = height;
		height = newHeight;

		// Update the properties map as well
		if (properties.get("height") == null
				|| properties.get("height") != height) {
			properties.put("height", height);
		}
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeometryPackage.TUBE__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getInnerRadius() {
		return innerRadius;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setInnerRadius(double newInnerRadius) {

		// After initialization, the inner radius must be no smaller than the
		// normal radius
		if (newInnerRadius <= radius || properties.get("innerRadius") == null) {

			double oldInnerRadius = innerRadius;
			innerRadius = newInnerRadius;

			// Update the properties map as well
			if (properties.get("innerRadius") == null
					|| properties.get("innerRadius") != innerRadius) {
				properties.put("innerRadius", innerRadius);
			}
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET,
						GeometryPackage.TUBE__INNER_RADIUS, oldInnerRadius,
						innerRadius));

		}

		else {
			logger.error("Attempted to set tube " + name + " " + id
					+ "'s inner radius to " + newInnerRadius
					+ " while radius was " + radius
					+ ", but a  tube's radius must be no less than its inner radius.");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getRadius() {
		return radius;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setRadius(double newRadius) {

		// The radius must be no smaller than the inner radius
		if (newRadius >= innerRadius) {

			double oldRadius = radius;
			radius = newRadius;

			// Update the properties map as well
			if (properties.get("radius") == null
					|| properties.get("radius") != radius) {
				properties.put("radius", radius);
			}
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET,
						GeometryPackage.TUBE__RADIUS, oldRadius, radius));
		}

		else {
			logger.error("Attempted to set tube " + name + " " + id
					+ "'s radius to " + newRadius + " while inner radius was "
					+ innerRadius
					+ ", but a  tube's radius must be no less than its inner radius.");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeometryPackage.TUBE__HEIGHT:
				return getHeight();
			case GeometryPackage.TUBE__INNER_RADIUS:
				return getInnerRadius();
			case GeometryPackage.TUBE__RADIUS:
				return getRadius();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GeometryPackage.TUBE__HEIGHT:
				setHeight((Double)newValue);
				return;
			case GeometryPackage.TUBE__INNER_RADIUS:
				setInnerRadius((Double)newValue);
				return;
			case GeometryPackage.TUBE__RADIUS:
				setRadius((Double)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GeometryPackage.TUBE__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case GeometryPackage.TUBE__INNER_RADIUS:
				setInnerRadius(INNER_RADIUS_EDEFAULT);
				return;
			case GeometryPackage.TUBE__RADIUS:
				setRadius(RADIUS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GeometryPackage.TUBE__HEIGHT:
				return height != HEIGHT_EDEFAULT;
			case GeometryPackage.TUBE__INNER_RADIUS:
				return innerRadius != INNER_RADIUS_EDEFAULT;
			case GeometryPackage.TUBE__RADIUS:
				return radius != RADIUS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (height: ");
		result.append(height);
		result.append(", innerRadius: ");
		result.append(innerRadius);
		result.append(", radius: ");
		result.append(radius);
		result.append(')');
		return result.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see geometry.impl.ShapeImpl#getTriangles()
	 * 
	 * @generated NOT
	 */
	@Override
	public EList<Triangle> getTriangles() {

		// If the attributes have not changed since the last time the mesh was
		// recalculated, return the current mesh
		if (prevHeight == height && prevInnerRadius == innerRadius
				&& prevRadius == radius && triangles != null
				&& !triangles.isEmpty()) {
			if (triangles != null) {
				return triangles;
			} else {
				triangles = new BasicInternalEList<Triangle>(Triangle.class);
				return triangles;
			}
		}

		// Update to the current radius
		prevRadius = radius;
		
		if (triangles == null) {
			triangles = new BasicInternalEList<Triangle>(Triangle.class);
		} else {
			triangles.clear();
		}

		// Replace the previous list with a a new tube's triangles.
		double[] vertices = MeshUtils.createTube(height, innerRadius, radius,
				RESOLUTION, SEGMENTS);

		triangles.addAll(MeshUtils.createTubeMesh(vertices, RESOLUTION, SEGMENTS));

		return triangles;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see geometry.impl.ShapeImpl#setProperty(java.lang.String, double)
	 * 
	 * @generated NOT
	 */
	@Override
	public void setProperty(final String property, final double value) {

		// Set the data member as well
		if ("height".equals(property)) {
			setHeight(value);
		} else if ("innerRadius".equals(property)) {
			setInnerRadius(value);
		} else if ("radius".equals(property)) {
			setRadius(value);
		}

		super.setProperty(property, value);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Object clone() {

		// Create a new tube
		Tube clone = GeometryFactory.eINSTANCE.createTube();

		// Make it a copy of this
		clone.copy(this);
		return clone;
	}
} // TubeImpl