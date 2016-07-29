/**
 */
package org.eclipse.january.geometry.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.january.geometry.Cube;
import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.january.geometry.Triangle;
import org.eclipse.january.geometry.util.MeshUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Cube</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.january.geometry.impl.CubeImpl#getSideLength <em>Side
 * Length</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CubeImpl extends ShapeImpl implements Cube {
	/**
	 * The default value of the '{@link #getSideLength() <em>Side Length</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSideLength()
	 * @generated
	 * @ordered
	 */
	protected static final double SIDE_LENGTH_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSideLength() <em>Side Length</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSideLength()
	 * @generated
	 * @ordered
	 */
	protected double sideLength = SIDE_LENGTH_EDEFAULT;

	/**
	 * The side length for the last set of triangles computed.
	 * 
	 * @generated NOT
	 */
	private double prevSideLength = SIDE_LENGTH_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected CubeImpl() {
		super();

		// Populate the properties map
		properties.put("sideLength", sideLength);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.CUBE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public double getSideLength() {
		return sideLength;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setSideLength(double newSideLength) {

		// Fail silently if the new value is already set
		if (newSideLength != sideLength) {

			double oldSideLength = sideLength;
			sideLength = newSideLength;

			// Update the properties map as well
			if (properties.get("sideLength") == null
					|| properties.get("sideLength") != sideLength) {
				properties.put("sideLength", sideLength);
			}
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET,
						GeometryPackage.CUBE__SIDE_LENGTH, oldSideLength,
						sideLength));

		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case GeometryPackage.CUBE__SIDE_LENGTH:
			return getSideLength();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case GeometryPackage.CUBE__SIDE_LENGTH:
			setSideLength((Double) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case GeometryPackage.CUBE__SIDE_LENGTH:
			setSideLength(SIDE_LENGTH_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case GeometryPackage.CUBE__SIDE_LENGTH:
			return sideLength != SIDE_LENGTH_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (sideLength: ");
		result.append(sideLength);
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

		// If the side length has not changed since the last time the mesh was
		// recalculated, return the current mesh
		if (prevSideLength == sideLength && triangles != null
				&& !triangles.isEmpty()) {

			// Initialize the list if it does not exist
			if (triangles == null) {
				triangles = new BasicEList<Triangle>();
			}

			return triangles;
		}

		// Update to the current side length
		prevSideLength = sideLength;

		// Get the coordinates for the vertices

		double[] points = MeshUtils.createRectangularPrism(sideLength,
				sideLength, sideLength);

		// Initialize the list if it does not exist
		if (triangles == null) {
			triangles = new BasicInternalEList<Triangle>(Triangle.class);
		} else {
			triangles.clear();
		}

		// Replace the previous list

		triangles.addAll(MeshUtils.createRectangularPrismMesh(points));

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
		if ("sideLength".equals(property)) {
			setSideLength(value);
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

		// Create a new cube
		Cube clone = GeometryFactory.eINSTANCE.createCube();

		// Make it a copy of this
		clone.copy(this);
		return clone;
	}
} // CubeImpl
