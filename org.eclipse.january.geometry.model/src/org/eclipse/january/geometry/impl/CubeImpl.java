/**
 */
package org.eclipse.january.geometry.impl;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.january.geometry.Cube;
import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.january.geometry.Triangle;
import org.eclipse.january.geometry.Vertex;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Cube</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.january.geometry.impl.CubeImpl#getSideLength
 * <em>Side Length</em>}</li>
 * </ul>
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
		double oldSideLength = sideLength;
		sideLength = newSideLength;

		// Update the properties map as well
		if (properties.get("sideLength") != sideLength) {
			properties.put("sideLength", sideLength);
		}
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeometryPackage.CUBE__SIDE_LENGTH, oldSideLength,
					sideLength));
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
		if (prevSideLength == sideLength) {
			return triangles;
		}

		// Update to the current side length
		prevSideLength = sideLength;

		// Clear the previous list
		triangles = new BasicEList<Triangle>();

		// Make an array of the 8 vertices forming the cube's corners
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();

		// Point 0
		Vertex v0 = GeometryFactory.eINSTANCE.createVertex();
		v0.setX(-sideLength / 2);
		v0.setY(-sideLength / 2);
		v0.setZ(-sideLength / 2);
		vertices.add(v0);

		// Point 1
		Vertex v1 = GeometryFactory.eINSTANCE.createVertex();
		v1.setX(-sideLength / 2);
		v1.setY(-sideLength / 2);
		v1.setZ(sideLength / 2);
		vertices.add(v1);

		// Point 2
		Vertex v2 = GeometryFactory.eINSTANCE.createVertex();
		v2.setX(-sideLength / 2);
		v2.setY(sideLength / 2);
		v2.setZ(-sideLength / 2);
		vertices.add(v2);

		// Point 3
		Vertex v3 = GeometryFactory.eINSTANCE.createVertex();
		v3.setX(-sideLength / 2);
		v3.setY(sideLength / 2);
		v3.setZ(sideLength / 2);
		vertices.add(v3);

		// Point 4
		Vertex v4 = GeometryFactory.eINSTANCE.createVertex();
		v4.setX(sideLength / 2);
		v4.setY(-sideLength / 2);
		v4.setZ(-sideLength / 2);
		vertices.add(v4);

		// Point 5
		Vertex v5 = GeometryFactory.eINSTANCE.createVertex();
		v5.setX(sideLength / 2);
		v5.setY(-sideLength / 2);
		v5.setZ(sideLength / 2);
		vertices.add(v5);

		// Point 6
		Vertex v6 = GeometryFactory.eINSTANCE.createVertex();
		v6.setX(sideLength / 2);
		v6.setY(sideLength / 2);
		v6.setZ(-sideLength / 2);
		vertices.add(v6);

		// Point 7
		Vertex v7 = GeometryFactory.eINSTANCE.createVertex();
		v7.setX(sideLength / 2);
		v7.setY(sideLength / 2);
		v7.setZ(sideLength / 2);
		vertices.add(v7);

		// Start adding the faces, with each face of the cube formed from two
		// triangles. Triangles' vertices are specified in order according to
		// the right hand rule.
		// Left side face 1
		Triangle t0 = GeometryFactory.eINSTANCE.createTriangle();
		t0.getVertices().add((Vertex) vertices.get(2).clone());
		t0.getVertices().add((Vertex) vertices.get(0).clone());
		t0.getVertices().add((Vertex) vertices.get(1).clone());
		triangles.add(t0);

		// Left side Face 2
		Triangle t1 = GeometryFactory.eINSTANCE.createTriangle();
		t1.getVertices().add((Vertex) vertices.get(3).clone());
		t1.getVertices().add((Vertex) vertices.get(2).clone());
		t1.getVertices().add((Vertex) vertices.get(1).clone());
		triangles.add(t1);

		// Top side Face 1
		Triangle t2 = GeometryFactory.eINSTANCE.createTriangle();
		t2.getVertices().add((Vertex) vertices.get(2).clone());
		t2.getVertices().add((Vertex) vertices.get(3).clone());
		t2.getVertices().add((Vertex) vertices.get(7).clone());
		triangles.add(t2);

		// Top side Face 2
		Triangle t3 = GeometryFactory.eINSTANCE.createTriangle();
		t3.getVertices().add((Vertex) vertices.get(2).clone());
		t3.getVertices().add((Vertex) vertices.get(7).clone());
		t3.getVertices().add((Vertex) vertices.get(6).clone());
		triangles.add(t3);

		// Front side Face 1
		Triangle t4 = GeometryFactory.eINSTANCE.createTriangle();
		t4.getVertices().add((Vertex) vertices.get(2).clone());
		t4.getVertices().add((Vertex) vertices.get(6).clone());
		t4.getVertices().add((Vertex) vertices.get(0).clone());
		triangles.add(t4);

		// Front side Face 2
		Triangle t5 = GeometryFactory.eINSTANCE.createTriangle();
		t5.getVertices().add((Vertex) vertices.get(6).clone());
		t5.getVertices().add((Vertex) vertices.get(4).clone());
		t5.getVertices().add((Vertex) vertices.get(0).clone());
		triangles.add(t5);

		// Back side Face 1
		Triangle t6 = GeometryFactory.eINSTANCE.createTriangle();
		t6.getVertices().add((Vertex) vertices.get(7).clone());
		t6.getVertices().add((Vertex) vertices.get(3).clone());
		t6.getVertices().add((Vertex) vertices.get(1).clone());
		triangles.add(t6);

		// Back side Face 2
		Triangle t7 = GeometryFactory.eINSTANCE.createTriangle();
		t7.getVertices().add((Vertex) vertices.get(7).clone());
		t7.getVertices().add((Vertex) vertices.get(1).clone());
		t7.getVertices().add((Vertex) vertices.get(5).clone());
		triangles.add(t7);

		// Bottom side Face 1
		Triangle t8 = GeometryFactory.eINSTANCE.createTriangle();
		t8.getVertices().add((Vertex) vertices.get(1).clone());
		t8.getVertices().add((Vertex) vertices.get(0).clone());
		t8.getVertices().add((Vertex) vertices.get(5).clone());
		triangles.add(t8);

		// Bottom side Face 2
		Triangle t9 = GeometryFactory.eINSTANCE.createTriangle();
		t9.getVertices().add((Vertex) vertices.get(5).clone());
		t9.getVertices().add((Vertex) vertices.get(0).clone());
		t9.getVertices().add((Vertex) vertices.get(4).clone());
		triangles.add(t9);

		// Right side Face 1
		Triangle t10 = GeometryFactory.eINSTANCE.createTriangle();
		t10.getVertices().add((Vertex) vertices.get(6).clone());
		t10.getVertices().add((Vertex) vertices.get(7).clone());
		t10.getVertices().add((Vertex) vertices.get(4).clone());
		triangles.add(t10);

		// Right side Face 2
		Triangle t11 = GeometryFactory.eINSTANCE.createTriangle();
		t11.getVertices().add((Vertex) vertices.get(7).clone());
		t11.getVertices().add((Vertex) vertices.get(5).clone());
		t11.getVertices().add((Vertex) vertices.get(4).clone());
		triangles.add(t11);

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
} // CubeImpl
