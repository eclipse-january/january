/**
 */
package org.eclipse.january.geometry.impl;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.january.geometry.Sphere;
import org.eclipse.january.geometry.Triangle;
import org.eclipse.january.geometry.Vertex;
import org.eclipse.january.geometry.util.MeshUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Sphere</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.january.geometry.impl.SphereImpl#getRadius
 * <em>Radius</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SphereImpl extends ShapeImpl implements Sphere {
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
	 * The last radius used in drawing the sphere.
	 * 
	 * @generated NOT
	 */
	protected double prevRadius = RADIUS_EDEFAULT;

	/**
	 * A constant defining how many vertices will be rendered along the sphere's
	 * circumference.
	 * 
	 * @generated NOT
	 */
	protected final static int RESOLUTION = 25;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SphereImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.SPHERE;
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
						GeometryPackage.SPHERE__RADIUS, oldRadius, radius));
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
		case GeometryPackage.SPHERE__RADIUS:
			return getRadius();
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
		case GeometryPackage.SPHERE__RADIUS:
			setRadius((Double) newValue);
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
		case GeometryPackage.SPHERE__RADIUS:
			setRadius(RADIUS_EDEFAULT);
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
		case GeometryPackage.SPHERE__RADIUS:
			return radius != RADIUS_EDEFAULT;
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
		if (prevRadius == radius && triangles != null && !triangles.isEmpty()) {
			return triangles;
		}

		// Update to the current radius
		prevRadius = radius;

		// Clear the previous list
		if (triangles == null) {
			triangles = new BasicInternalEList<Triangle>(Triangle.class);
		} else {
			triangles.clear();
		}

		// Make an array of the vertices along each circle
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();

		// The amount of change between one layer and the next, both in the
		// layer's height and the radius of the circle at that height
		double stepSize = 2d / (RESOLUTION - 1);

		// The radius for the current circle under construction. It starts off
		// one step above 0.
		double currRadius;

		// The height starts one step above the sphere's nadir at height -radius
		double height;

		// Add each circle's points to the sphere
		for (int i = 0; i < RESOLUTION - 2; i++) {

			// Get the radius of the sphere at the proper height. For the bottom
			// half of the sphere, the radius will increase from zero. For the
			// top half, it will decrease from one. At exactly half way through
			// the sphere, the radius will be exactly 1.
			if (i < (RESOLUTION - 3) / 2) {
				currRadius = (float) Math
						.sqrt(1f - (Math.pow(1f - (stepSize * (i + 1f)), 2)));
			} else if (i > (RESOLUTION - 1) / 2 - 1) {
				currRadius = (float) Math
						.sqrt(1f - (Math.pow(1f - (((i + 1f) * stepSize)), 2)));
			} else {
				currRadius = 1f;
			}

			// Scale the current radius by the total radius
			currRadius = currRadius * radius;

			// The height is one step above -1 for each circle
			height = (-radius) + ((i + 1) * stepSize * radius);

			// Create a circle of the correct radius
			float[] circle = MeshUtils.createCircle((float) currRadius,
					RESOLUTION);

			// Add the circle's coordinates to the points as its X and Z values,
			// with Y values given by the current height
			for (int j = 0; j < RESOLUTION; j++) {

				Vertex vertex = GeometryFactory.eINSTANCE.createVertex();
				vertex.setX(circle[j * 2]);
				vertex.setY(height);
				vertex.setZ(circle[j * 2 + 1]);
				vertices.add(vertex);
			}

			// In the bottom half, the circles on the sphere increase in size up
			// to the sphere's radius, and decrease from the full radius down to
			// a point on the top half.
			if (i <= RESOLUTION / 2) {
				currRadius = (float) Math.pow(stepSize, (i + 1) * 2);
			} else {
				currRadius = (float) Math.pow(stepSize,
						(RESOLUTION - i + 1) * 2);
			}

			// The next circle will be one step above this one.
			height += stepSize;

		}

		// The index of the lowest point on the sphere
		int nadir = RESOLUTION * (RESOLUTION - 2);

		// The index of the highest point on the sphere
		int apex = nadir + 1;

		// Finally add the top and bottom points, (0, -1, 0) and (0, 1, 0)
		Vertex nadirVertex = GeometryFactory.eINSTANCE.createVertex();
		nadirVertex.setX(0);
		nadirVertex.setY(-radius);
		nadirVertex.setZ(0);
		vertices.add(nadirVertex);

		Vertex apexVertex = GeometryFactory.eINSTANCE.createVertex();
		apexVertex.setX(0);
		apexVertex.setY(radius);
		apexVertex.setZ(0);
		vertices.add(apexVertex);

		// For each of the resolution layers of the sphere, excluding the
		// special cases of the top and bottom ones...
		for (int i = 0; i < RESOLUTION - 3; i++) {

			// Add two faces at each point
			for (int j = 0; j < RESOLUTION; j++) {

				// Create a new triangle
				Triangle tri0 = GeometryFactory.eINSTANCE.createTriangle();

				// Calculate the third vertex's index based on whether or not
				// this is the end of the circle
				int vIndex0 = (j != RESOLUTION - 1) ? i * RESOLUTION + j + 1
						: i * RESOLUTION;

				// The first face will go from the point to the next one along
				// the circle to the point above the original on the next circle
				// up.
				tri0.getVertices()
						.add((Vertex) vertices.get(i * RESOLUTION + j).clone());
				tri0.getVertices().add((Vertex) vertices
						.get((i + 1) * RESOLUTION + j).clone());
				tri0.getVertices().add((Vertex) vertices.get(vIndex0).clone());

				// Add the triangle to the list
				triangles.add(tri0);

				// Create the second triangle
				Triangle tri1 = GeometryFactory.eINSTANCE.createTriangle();

				// Calculate the second vertex's index based on whether or not
				// this is the start of the circle
				int vIndex1 = (j != 0) ? (i + 1) * RESOLUTION + j - 1
						: (i + 2) * RESOLUTION - 1;

				// The first face will go from the point to the next one along
				// the circle to the point above the original on the next circle
				// up.
				tri1.getVertices()
						.add((Vertex) vertices.get(i * RESOLUTION + j).clone());
				tri1.getVertices().add((Vertex) vertices.get(vIndex1).clone());
				tri1.getVertices().add((Vertex) vertices
						.get((i + 1) * RESOLUTION + j).clone());

				// Add the triangle to the list
				triangles.add(tri1);
			}
		}

		// The index of the start of the block of points on the highest circle
		// in the sphere
		int indexTopPoints = RESOLUTION * (RESOLUTION - 3);

		// Add the faces from the top and bottom circles to the top and bottom
		// points
		for (int i = 0; i < RESOLUTION; i++) {

			// Create the triangle
			Triangle tri0 = GeometryFactory.eINSTANCE.createTriangle();

			// Create a face between two points on the bottom circle and the
			// nadir.
			tri0.getVertices().add((Vertex) vertices.get(i).clone());
			tri0.getVertices()
					.add((Vertex) vertices.get((i + 1) % RESOLUTION).clone());
			tri0.getVertices().add((Vertex) vertices.get(nadir).clone());

			// Add the bottom triangle to the list
			triangles.add(tri0);

			// Create the second triangle
			Triangle tri1 = GeometryFactory.eINSTANCE.createTriangle();

			// Create a face between two points on the bottom circle and the
			// nadir.
			tri1.getVertices().add((Vertex) vertices
					.get(indexTopPoints + ((i + 1) % RESOLUTION)).clone());
			tri1.getVertices()
					.add((Vertex) vertices.get(indexTopPoints + i).clone());
			tri1.getVertices().add((Vertex) vertices.get(apex).clone());

			// Add the top triangle to the list
			triangles.add(tri1);
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
		if ("radius".equals(property)) {
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

		// Create a new sphere
		Sphere clone = GeometryFactory.eINSTANCE.createSphere();

		// Make it a copy of this
		clone.copy(this);
		return clone;
	}
} // SphereImpl
