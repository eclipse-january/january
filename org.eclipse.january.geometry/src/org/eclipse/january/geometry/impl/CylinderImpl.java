/**
 */
package org.eclipse.january.geometry.impl;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.january.geometry.Cylinder;
import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.january.geometry.Triangle;
import org.eclipse.january.geometry.Vertex;
import org.eclipse.january.geometry.util.MeshUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Cylinder</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.january.geometry.impl.CylinderImpl#getRadius
 * <em>Radius</em>}</li>
 * <li>{@link org.eclipse.january.geometry.impl.CylinderImpl#getHeight
 * <em>Height</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CylinderImpl extends ShapeImpl implements Cylinder {
	/**
	 * The default value of the '{@link #getRadius() <em>Radius</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRadius()
	 * @generated
	 * @ordered
	 */
	protected static final double RADIUS_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRadius() <em>Radius</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRadius()
	 * @generated
	 * @ordered
	 */
	protected double radius = RADIUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeight() <em>Height</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected static final double HEIGHT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected double height = HEIGHT_EDEFAULT;

	/**
	 * The resolution of the cylinder, measured in the number of points used to
	 * describe the circles at its ends.
	 * 
	 * @generated NOT
	 */
	final private int RESOLUTION = 50;

	/**
	 * The number of vertical segments into which the mesh will be divided.
	 * 
	 * @generated NOT
	 */
	final private int SEGMENTS = 2;

	/**
	 * The last height used in drawing the mesh.
	 * 
	 * @generated NOT
	 */
	protected double prevHeight = HEIGHT_EDEFAULT;

	/**
	 * The last radius used in drawing the mesh.
	 * 
	 * @generated NOT
	 */
	protected double prevRadius = RADIUS_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CylinderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.CYLINDER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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

		// Fail silently if the new value is already set
		if (newRadius != radius) {

			double oldRadius = radius;
			radius = newRadius;

			// Update the properties map as well
			if (properties.get("radius") == null
					|| properties.get("radius") != radius) {
				properties.put("radius", radius);
			}
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET,
						GeometryPackage.CYLINDER__RADIUS, oldRadius, radius));

		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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

		// Fail silently if the new value is already set
		if (newHeight != height) {

			double oldHeight = height;
			height = newHeight;

			// Update the properties map as well
			if (properties.get("height") == null
					|| properties.get("height") != height) {
				properties.put("height", height);
			}
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET,
						GeometryPackage.CYLINDER__HEIGHT, oldHeight, height));
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
		case GeometryPackage.CYLINDER__RADIUS:
			return getRadius();
		case GeometryPackage.CYLINDER__HEIGHT:
			return getHeight();
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
		case GeometryPackage.CYLINDER__RADIUS:
			setRadius((Double) newValue);
			return;
		case GeometryPackage.CYLINDER__HEIGHT:
			setHeight((Double) newValue);
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
		case GeometryPackage.CYLINDER__RADIUS:
			setRadius(RADIUS_EDEFAULT);
			return;
		case GeometryPackage.CYLINDER__HEIGHT:
			setHeight(HEIGHT_EDEFAULT);
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
		case GeometryPackage.CYLINDER__RADIUS:
			return radius != RADIUS_EDEFAULT;
		case GeometryPackage.CYLINDER__HEIGHT:
			return height != HEIGHT_EDEFAULT;
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
		result.append(" (radius: ");
		result.append(radius);
		result.append(", height: ");
		result.append(height);
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

		// If the properties have not changed since the last time the mesh was
		// recalculated, return the current mesh
		if (prevRadius == radius && prevHeight == height && triangles != null
				&& !triangles.isEmpty()) {

			if (triangles != null) {
				return triangles;
			} else {
				triangles = new BasicInternalEList<Triangle>(Triangle.class);
				return triangles;
			}
		}

		// Update to the new properties
		prevRadius = radius;
		prevHeight = height;

		// Clear the previous list
		triangles = new BasicInternalEList<Triangle>(Triangle.class);

		// Make an array of vertices to form the triangles
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();

		// The x and z vertices for the cylinder
		float[] circle = new float[RESOLUTION * 2];

		// Get the unit circle's coordinates
		circle = MeshUtils.createCircle((float) radius, RESOLUTION);

		// The number of coordinates required to specify every 3D vertex for a
		// cylinder of with SEGMENTS extra circles above the base circle and
		// RESOLUTION points per circle.
		int blockSize = (SEGMENTS + 1) * RESOLUTION * 3;

		// Iterate through the points, one circle along the cylinder at a time,
		// adding them to the vertex array
		for (int i = 0; i <= SEGMENTS; i++) {
			for (int j = 0; j < RESOLUTION; j++) {

				Vertex vertex = GeometryFactory.eINSTANCE.createVertex();

				// X and Z coordinate of the unit circle
				vertex.setX(circle[j * 2]);
				vertex.setZ(circle[j * 2 + 1]);

				// Y coordinate of the current segment's height
				vertex.setY(-height / 2 + i * height / SEGMENTS);

				// Add the vertex to the list
				vertices.add(vertex);
			}
		}

		// Add a vertex at the center of the bottom circle
		Vertex bottom = GeometryFactory.eINSTANCE.createVertex();
		bottom.setX(0);
		bottom.setY(-height / 2);
		bottom.setZ(0);
		vertices.add(bottom);

		// Add a vertex at the center of the top circle
		Vertex top = GeometryFactory.eINSTANCE.createVertex();
		top.setX(0);
		top.setY(height / 2);
		top.setZ(0);
		vertices.add(top);

		// Construct the side out of identical vertical segments, one at a time.
		for (int axialSegment = 0; axialSegment < SEGMENTS; axialSegment++) {

			// Add two triangles for each vertex along the current circle
			for (int radialSegment = 0; radialSegment < RESOLUTION; radialSegment++) {

				// Create a new triangle
				Triangle t0 = GeometryFactory.eINSTANCE.createTriangle();

				// Create a triangle between the current vertex, the next vertex
				// along the circle, and the vertex immediately above this one.
				t0.getVertices()
						.add((Vertex) vertices
								.get((axialSegment + 1) * RESOLUTION
										+ ((radialSegment + 1) % RESOLUTION))
								.clone());
				t0.getVertices()
						.add((Vertex) vertices
								.get(axialSegment * RESOLUTION
										+ ((radialSegment + 1) % RESOLUTION))
								.clone());
				t0.getVertices()
						.add((Vertex) vertices
								.get(axialSegment * RESOLUTION + radialSegment)
								.clone());

				// Add it to the list
				triangles.add(t0);

				// Create the second triangle
				Triangle t1 = GeometryFactory.eINSTANCE.createTriangle();

				// Create a triangle between the current vertex, the vertex
				// immediately above it, and the last one along the circle from
				// that one.
				t1.getVertices()
						.add((Vertex) vertices
								.get(axialSegment * RESOLUTION + radialSegment)
								.clone());
				t1.getVertices()
						.add((Vertex) vertices.get(
								(axialSegment + 1) * RESOLUTION + radialSegment)
								.clone());
				t1.getVertices()
						.add((Vertex) vertices
								.get((axialSegment + 1) * RESOLUTION
										+ ((radialSegment + 1) % RESOLUTION))
								.clone());

				// Add the second triangle to the list
				triangles.add(t1);
			}
		}

		// Add two triangles for each vertex along the top and bottom circles
		for (int radialSegment = 0; radialSegment < RESOLUTION; radialSegment++) {

			// Create a new triangle
			Triangle t0 = GeometryFactory.eINSTANCE.createTriangle();

			// Create a triangle between the current vertex,the next vertex
			// along the circle, and the center point.
			t0.getVertices().add((Vertex) vertices.get(blockSize / 3).clone());
			t0.getVertices().add((Vertex) vertices.get(radialSegment).clone());
			t0.getVertices().add((Vertex) vertices
					.get((radialSegment + 1) % RESOLUTION).clone());

			// Add it to the list
			triangles.add(t0);

			// Create the second triangle
			Triangle t1 = GeometryFactory.eINSTANCE.createTriangle();

			// Create a triangle between the current vertex,the next vertex
			// along the circle, and the center point.
			t1.getVertices().add(vertices.get(((SEGMENTS) * RESOLUTION)
					+ ((radialSegment + 1) % RESOLUTION)));
			t1.getVertices().add((Vertex) vertices
					.get(((SEGMENTS) * RESOLUTION) + radialSegment).clone());
			t1.getVertices()
					.add((Vertex) vertices.get(blockSize / 3 + 1).clone());

			// Add the second triangle to the list
			triangles.add(t1);
		}

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

		// Create a new cylinder
		Cylinder clone = GeometryFactory.eINSTANCE.createCylinder();

		// Make it a copy of this
		clone.copy(this);
		return clone;
	}
} // CylinderImpl
