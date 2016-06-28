/**
 */
package geometry.impl;

import java.util.ArrayList;

import org.eclipse.eavp.viz.modeling.MeshUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import geometry.GeometryFactory;
import geometry.GeometryPackage;
import geometry.Triangle;
import geometry.Tube;
import geometry.Vertex;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Tube</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link geometry.impl.TubeImpl#getHeight <em>Height</em>}</li>
 * <li>{@link geometry.impl.TubeImpl#getInnerRadius <em>Inner Radius</em>}</li>
 * <li>{@link geometry.impl.TubeImpl#getRadius <em>Radius</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TubeImpl extends ShapeImpl implements Tube {
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
	 * The default value of the '{@link #getInnerRadius() <em>Inner Radius</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInnerRadius()
	 * @generated
	 * @ordered
	 */
	protected static final double INNER_RADIUS_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getInnerRadius() <em>Inner Radius</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInnerRadius()
	 * @generated
	 * @ordered
	 */
	protected double innerRadius = INNER_RADIUS_EDEFAULT;

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
	private final int SEGMENTS = 15;

	/**
	 * The number of sample points about the circumference
	 * 
	 * @generated NOT
	 */
	private final int RESOLUTION = 25;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected TubeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.TUBE;
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
	 * @generated
	 */
	@Override
	public void setHeight(double newHeight) {
		double oldHeight = height;
		height = newHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeometryPackage.TUBE__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public double getInnerRadius() {
		return innerRadius;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setInnerRadius(double newInnerRadius) {
		double oldInnerRadius = innerRadius;
		innerRadius = newInnerRadius;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeometryPackage.TUBE__INNER_RADIUS, oldInnerRadius,
					innerRadius));
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
	 * @generated
	 */
	@Override
	public void setRadius(double newRadius) {
		double oldRadius = radius;
		radius = newRadius;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeometryPackage.TUBE__RADIUS, oldRadius, radius));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case GeometryPackage.TUBE__HEIGHT:
			setHeight((Double) newValue);
			return;
		case GeometryPackage.TUBE__INNER_RADIUS:
			setInnerRadius((Double) newValue);
			return;
		case GeometryPackage.TUBE__RADIUS:
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
	 * 
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
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

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

		// If the side length has not changed since the last time the mesh was
		// recalculated, return the current mesh
		if (prevHeight == height && prevInnerRadius == innerRadius
				&& prevRadius == radius) {
			return triangles;
		}

		// Update to the current radius
		prevRadius = radius;

		// Clear the previous list
		triangles = new BasicEList<Triangle>();

		// Make an array of the vertices along each circle
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();

		// The y coordinate of the pipe's bottom edge
		float base = (float) (height / -2);

		// The vertices for the inner circle on the lower level
		float[] innerVertices = new float[RESOLUTION * 2];

		// The vertices for the outer circle on the lower level
		float[] outerVertices = new float[RESOLUTION * 2];

		// Get the XZ coordinates for the circles defining the tube's thickness
		innerVertices = MeshUtils.createCircle((float) innerRadius, RESOLUTION);
		outerVertices = MeshUtils.createCircle((float) radius, RESOLUTION);

		// Iterate through each point on each circle up the side of the inner
		// wall
		for (int i = 0; i <= SEGMENTS; i++) {
			for (int j = 0; j < RESOLUTION; j++) {

				// Create a new vertex
				Vertex v = GeometryFactory.eINSTANCE.createVertex();

				// Set its coordinates
				v.setX(innerVertices[j * 2]);
				v.setY(base + i * (height / SEGMENTS));
				v.setZ(innerVertices[j * 2 + 1]);

				// Save it to the list
				vertices.add(v);

			}
		}

		// Iterate through each point on each circle up the side of the outer
		// wall
		for (int i = 0; i <= SEGMENTS; i++) {
			for (int j = 0; j < RESOLUTION; j++) {

				// Create a new vertex
				Vertex v = GeometryFactory.eINSTANCE.createVertex();

				// Set its coordinates
				v.setX(outerVertices[j * 2]);
				v.setY((base + i * height / SEGMENTS));
				v.setZ(outerVertices[j * 2 + 1]);

				// Save it to the list
				vertices.add(v);
			}
		}

		// The number of vertices needed to fully specify one of the two
		// cylindrical faces of the tube mesh
		int vertexBlockSize = (SEGMENTS + 1) * RESOLUTION;

		// Construct the tube out of identical vertical segments, one at a time.
		for (int axialSegment = 0; axialSegment < SEGMENTS; axialSegment++) {

			// Add two triangles for each vertex along the current circle
			for (int radialSegment = 0; radialSegment < RESOLUTION; radialSegment++) {

				// Create the first triangle on the inner side
				Triangle innerTri0 = GeometryFactory.eINSTANCE.createTriangle();

				// Create a triangle between the current vertex, the next vertex
				// along the circle, and the vertex immediately above this one.
				innerTri0.getVertices()
						.add((Vertex) vertices
								.get(axialSegment * RESOLUTION + radialSegment)
								.clone());
				innerTri0.getVertices()
						.add((Vertex) vertices
								.get(axialSegment * RESOLUTION
										+ ((radialSegment + 1) % RESOLUTION))
								.clone());
				innerTri0.getVertices()
						.add((Vertex) vertices
								.get((axialSegment + 1) * RESOLUTION
										+ ((radialSegment + 1) % RESOLUTION))
								.clone());

				// Add the triangle to the list
				triangles.add(innerTri0);

				// Create the second triangle on the inner side
				Triangle innerTri1 = GeometryFactory.eINSTANCE.createTriangle();

				// Create a triangle between the current vertex, the vertex
				// immediately above it, and the last one along the circle from
				// that one.
				innerTri1.getVertices()
						.add((Vertex) vertices
								.get((axialSegment + 1) * RESOLUTION
										+ ((radialSegment + 1) % RESOLUTION))
								.clone());
				innerTri1.getVertices()
						.add((Vertex) vertices.get(
								(axialSegment + 1) * RESOLUTION + radialSegment)
								.clone());
				innerTri1.getVertices()
						.add((Vertex) vertices
								.get(axialSegment * RESOLUTION + radialSegment)
								.clone());

				// Add the triangle to the list
				triangles.add(innerTri1);

				// Create the first triangle on the outer side
				Triangle outerTri0 = GeometryFactory.eINSTANCE.createTriangle();

				// Create a triangle between the current vertex, the next vertex
				// along the circle, and the vertex immediately above this one.
				outerTri0.getVertices()
						.add((Vertex) vertices.get(vertexBlockSize
								+ (axialSegment + 1) * RESOLUTION
								+ ((radialSegment + 1) % RESOLUTION)).clone());
				outerTri0.getVertices()
						.add((Vertex) vertices
								.get(vertexBlockSize + axialSegment * RESOLUTION
										+ ((radialSegment + 1) % RESOLUTION))
								.clone());
				outerTri0.getVertices()
						.add((Vertex) vertices.get(vertexBlockSize
								+ axialSegment * RESOLUTION + radialSegment)
								.clone());

				// Add the triangle to the list
				triangles.add(outerTri0);

				// Create the first triangle on the outer side
				Triangle outerTri1 = GeometryFactory.eINSTANCE.createTriangle();

				// Create a triangle between the current vertex, the vertex
				// immediately above it, and the last one along the circle from
				// that one.
				outerTri1.getVertices()
						.add((Vertex) vertices.get(vertexBlockSize
								+ axialSegment * RESOLUTION + radialSegment)
								.clone());
				outerTri1.getVertices()
						.add((Vertex) vertices.get(vertexBlockSize
								+ (axialSegment + 1) * RESOLUTION
								+ radialSegment).clone());
				outerTri1.getVertices()
						.add((Vertex) vertices.get(vertexBlockSize
								+ (axialSegment + 1) * RESOLUTION
								+ ((radialSegment + 1) % RESOLUTION)).clone());

				// Add the triangle to the list
				triangles.add(outerTri1);
			}

			// If the radii are different, the tube also needs a top and bottom
			// edge
			if (innerRadius != radius) {

				// Add two triangles for each vertex along the current circle
				for (int radialSegment = 0; radialSegment < RESOLUTION; radialSegment++) {

					// Create the first triangle on the bottom
					Triangle bottomTri0 = GeometryFactory.eINSTANCE
							.createTriangle();

					// Create a triangle between the current vertex, the next
					// vertex
					// along the circle, and the corresponding vertex on the
					// other
					// edge.
					bottomTri0.getVertices()
							.add((Vertex) vertices.get(vertexBlockSize
									+ ((radialSegment + 1) % RESOLUTION))
									.clone());
					bottomTri0.getVertices()
							.add((Vertex) vertices
									.get((radialSegment + 1) % RESOLUTION)
									.clone());
					bottomTri0.getVertices()
							.add((Vertex) vertices.get(radialSegment).clone());

					// Add the triangle to the list
					triangles.add(bottomTri0);

					// Create the second triangle on the bottom
					Triangle bottomTri1 = GeometryFactory.eINSTANCE
							.createTriangle();

					// Create a triangle between the current vertex, the
					// corresponding vertex on the other edge, and the last one
					// along the circle from the other edge.
					bottomTri1.getVertices()
							.add((Vertex) vertices.get(
									((SEGMENTS) * RESOLUTION) + radialSegment)
									.clone());
					bottomTri1.getVertices()
							.add((Vertex) vertices.get(((SEGMENTS) * RESOLUTION)
									+ ((radialSegment + 1) % RESOLUTION))
									.clone());
					bottomTri1
							.getVertices().add(
									(Vertex) vertices
											.get(((SEGMENTS) * RESOLUTION)
													+ vertexBlockSize
													+ ((radialSegment + 1)
															% RESOLUTION))
											.clone());

					// Add the triangle to the list
					triangles.add(bottomTri1);

					// Create the first triangle on the top
					Triangle topTri0 = GeometryFactory.eINSTANCE
							.createTriangle();

					// Create a triangle between the current vertex, the
					// corresponding vertex on the other edge, and the last one
					// along the circle from the other edge.
					topTri0.getVertices()
							.add((Vertex) vertices.get(radialSegment).clone());
					topTri0.getVertices()
							.add((Vertex) vertices
									.get(vertexBlockSize + radialSegment)
									.clone());
					topTri0.getVertices()
							.add((Vertex) vertices.get(vertexBlockSize
									+ ((radialSegment + 1) % RESOLUTION))
									.clone());

					// Add the triangle to the list
					triangles.add(topTri0);

					// Create the second triangle on the top
					Triangle topTri1 = GeometryFactory.eINSTANCE
							.createTriangle();

					// Create a triangle between the current vertex, the vertex
					// immediately above it, and the last one along the circle
					// from
					// that one.
					topTri1.getVertices().add((Vertex) vertices
							.get(((SEGMENTS) * RESOLUTION) + vertexBlockSize
									+ ((radialSegment + 1) % RESOLUTION))
							.clone());
					topTri1.getVertices()
							.add((Vertex) vertices
									.get(((SEGMENTS) * RESOLUTION)
											+ vertexBlockSize + radialSegment)
									.clone());
					topTri1.getVertices()
							.add((Vertex) vertices.get(
									((SEGMENTS) * RESOLUTION) + radialSegment)
									.clone());

					// Add the triangle to the list
					triangles.add(topTri1);
				}
			}
		}

		return triangles;
	}

} // TubeImpl
