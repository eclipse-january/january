/**
 */
package org.eclipse.january.geometry.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.january.geometry.BoundingBox;
import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.january.geometry.Pipe;
import org.eclipse.january.geometry.Triangle;
import org.eclipse.january.geometry.util.MeshUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Pipe</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.january.geometry.impl.PipeImpl#getNumRods <em>Num
 * Rods</em>}</li>
 * <li>{@link org.eclipse.january.geometry.impl.PipeImpl#getPitch
 * <em>Pitch</em>}</li>
 * <li>{@link org.eclipse.january.geometry.impl.PipeImpl#getRodDiameter <em>Rod
 * Diameter</em>}</li>
 * <li>{@link org.eclipse.january.geometry.impl.PipeImpl#getRotationX
 * <em>Rotation X</em>}</li>
 * <li>{@link org.eclipse.january.geometry.impl.PipeImpl#getRotationY
 * <em>Rotation Y</em>}</li>
 * <li>{@link org.eclipse.january.geometry.impl.PipeImpl#getRotationZ
 * <em>Rotation Z</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PipeImpl extends TubeImpl implements Pipe {
	/**
	 * The default value of the '{@link #getNumRods() <em>Num Rods</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNumRods()
	 * @generated
	 * @ordered
	 */
	protected static final int NUM_RODS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumRods() <em>Num Rods</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNumRods()
	 * @generated
	 * @ordered
	 */
	protected int numRods = NUM_RODS_EDEFAULT;

	/**
	 * The default value of the '{@link #getPitch() <em>Pitch</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPitch()
	 * @generated
	 * @ordered
	 */
	protected static final int PITCH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPitch() <em>Pitch</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPitch()
	 * @generated
	 * @ordered
	 */
	protected int pitch = PITCH_EDEFAULT;

	/**
	 * The default value of the '{@link #getRodDiameter() <em>Rod
	 * Diameter</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRodDiameter()
	 * @generated
	 * @ordered
	 */
	protected static final int ROD_DIAMETER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRodDiameter() <em>Rod Diameter</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRodDiameter()
	 * @generated
	 * @ordered
	 */
	protected int rodDiameter = ROD_DIAMETER_EDEFAULT;

	/**
	 * The default value of the '{@link #getRotationX() <em>Rotation X</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRotationX()
	 * @generated
	 * @ordered
	 */
	protected static final double ROTATION_X_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRotationX() <em>Rotation X</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRotationX()
	 * @generated
	 * @ordered
	 */
	protected double rotationX = ROTATION_X_EDEFAULT;

	/**
	 * The default value of the '{@link #getRotationY() <em>Rotation Y</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRotationY()
	 * @generated
	 * @ordered
	 */
	protected static final double ROTATION_Y_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRotationY() <em>Rotation Y</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRotationY()
	 * @generated
	 * @ordered
	 */
	protected double rotationY = ROTATION_Y_EDEFAULT;

	/**
	 * The default value of the '{@link #getRotationZ() <em>Rotation Z</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRotationZ()
	 * @generated
	 * @ordered
	 */
	protected static final double ROTATION_Z_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRotationZ() <em>Rotation Z</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRotationZ()
	 * @generated
	 * @ordered
	 */
	protected double rotationZ = ROTATION_Z_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PipeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.PIPE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getNumRods() {
		return numRods;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setNumRods(int newNumRods) {

		// Fail silently if the new value is already set
		if (newNumRods != numRods) {

			int oldNumRods = numRods;
			numRods = newNumRods;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET,
						GeometryPackage.PIPE__NUM_RODS, oldNumRods, numRods));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getPitch() {
		return pitch;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setPitch(int newPitch) {

		// Fail silently if the new value is already set
		if (newPitch != pitch) {

			int oldPitch = pitch;
			pitch = newPitch;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET,
						GeometryPackage.PIPE__PITCH, oldPitch, pitch));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getRodDiameter() {
		return rodDiameter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setRodDiameter(int newRodDiameter) {

		// Fail silently if the new value is already set
		if (newRodDiameter != rodDiameter) {

			int oldRodDiameter = rodDiameter;
			rodDiameter = newRodDiameter;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET,
						GeometryPackage.PIPE__ROD_DIAMETER, oldRodDiameter,
						rodDiameter));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public double getRotationX() {
		return rotationX;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setRotationX(double newRotationX) {

		// Fail silently if the new value is already set
		if (newRotationX != rotationX) {

			double oldRotationX = rotationX;
			rotationX = newRotationX;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET,
						GeometryPackage.PIPE__ROTATION_X, oldRotationX,
						rotationX));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public double getRotationY() {
		return rotationY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setRotationY(double newRotationY) {

		// Fail silently if the new value is already set
		if (newRotationY != rotationY) {

			double oldRotationY = rotationY;
			rotationY = newRotationY;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET,
						GeometryPackage.PIPE__ROTATION_Y, oldRotationY,
						rotationY));

		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public double getRotationZ() {
		return rotationZ;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setRotationZ(double newRotationZ) {

		// Fail silently if the new value is already set
		if (newRotationZ != rotationZ) {

			double oldRotationZ = rotationZ;
			rotationZ = newRotationZ;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET,
						GeometryPackage.PIPE__ROTATION_Z, oldRotationZ,
						rotationZ));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.january.geometry.impl.TubeImpl#getInnerRadius()
	 * 
	 * @generated NOT
	 */
	@Override
	public double getInnerRadius() {

		// Pipes are always of infinite thinness, so the inner radius is always
		// equal to the radius.
		return getRadius();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.january.geometry.impl.TubeImpl#setInnerRadius(double)
	 * 
	 * @generated NOT
	 */
	@Override
	public void setInnerRadius(double innerRadius) {

		// The inner radius is always equal to the radius for a pipe
		setRadius(innerRadius);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public BoundingBox getLowerEdge() {
		return createEdgeBounds(false);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public BoundingBox getUpperEdge() {
		return createEdgeBounds(true);
	}

	/**
	 * Create the bounding box around one of the pipe's edges.
	 * 
	 * @param lower
	 *            Whether to create the lower or upper edge's bounding box. The
	 *            lower edge's will be created if true, and the uper edge's will
	 *            be otherwise.
	 * @return A bounding box surrounding the points of the pipe's edge.
	 * 
	 * @generated NOT
	 */
	private BoundingBox createEdgeBounds(boolean lower) {

		// The points for a properly sized 2D circle
		double[] pointsOrig = MeshUtils.createCircle(radius, RESOLUTION);

		// The points comprising the pipe's lip
		double[] points = new double[RESOLUTION * 3];

		// Calculate the 3D points by setting the 2D circle to the correct
		// height
		for (int i = 0; i < RESOLUTION; i++) {
			points[i * 3] = pointsOrig[i * 2];
			points[i * 3 + 1] = lower ? (float) (-height / 2)
					: (float) height / 2;
			points[i * 3 + 2] = pointsOrig[i * 2 + 1];
		}

		// Rotate the points
		points = MeshUtils.rotatePoints(points, rotationX, rotationY,
				rotationZ);

		// Move the points so that the pipe will be centered correctly
		for (int i = 0; i < points.length / 3; i++) {
			points[i * 3] = (points[i * 3] + center.getX());
			points[i * 3 + 1] = (points[i * 3 + 1] + center.getY());
			points[i * 3 + 2] = (points[i * 3 + 2] + center.getZ());
		}

		// Initialize the extrema with the first point
		double minX = points[0];
		double minY = points[1];
		double minZ = points[2];
		double maxX = points[0];
		double maxY = points[1];
		double maxZ = points[2];

		// Compare each point to the current extrema, setting the
		// minimum/maximum values if they are lower/higher
		for (int i = 0; i < points.length / 3; i++) {

			if (minX > points[i * 3]) {
				minX = points[i * 3];
			}

			else if (maxX < points[i * 3]) {
				maxX = points[i * 3];
			}

			if (minY > points[i * 3 + 1]) {
				minY = points[i * 3 + 1];
			}

			else if (maxY < points[i * 3 + 1]) {
				maxY = points[i * 3 + 1];
			}

			if (minZ > points[i * 3 + 2]) {
				minZ = points[i * 3 + 2];
			}

			else if (maxZ < points[i * 3 + 2]) {
				maxZ = points[i * 3 + 2];
			}
		}

		// Create a bounding box based on the edge's extrema
		BoundingBox box = GeometryFactory.eINSTANCE.createBoundingBox();
		box.setMaxX(maxX);
		box.setMaxY(maxY);
		box.setMaxZ(maxZ);
		box.setMinX(minX);
		box.setMinY(minY);
		box.setMinZ(minZ);

		return box;
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

		// Initialize the triangles list if it is not already
		if (triangles == null) {
			triangles = new BasicEList<Triangle>();
		}

		// If the attributes have not changed since the last time the mesh was
		// recalculated, return the current mesh
		if (prevHeight == height && prevInnerRadius == innerRadius
				&& prevRadius == radius) {
			return triangles;
		}

		// Update to the current attributes
		prevRadius = radius;
		prevHeight = height;

		// Get the points and rotate them
		double[] vertices = MeshUtils.createTube(height, radius, radius,
				RESOLUTION, SEGMENTS);
		vertices = MeshUtils.rotatePoints(vertices, rotationX, rotationY,
				rotationZ);

		// Replace the previous list with a a new tube's triangles.
		triangles.clear();
		triangles = MeshUtils.createTubeMesh(vertices, RESOLUTION, SEGMENTS);

		return triangles;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Object clone() {

		// Create a new pipe
		Pipe clone = GeometryFactory.eINSTANCE.createPipe();

		// Make it a copy of this
		clone.copy(this);
		return clone;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case GeometryPackage.PIPE__NUM_RODS:
			return getNumRods();
		case GeometryPackage.PIPE__PITCH:
			return getPitch();
		case GeometryPackage.PIPE__ROD_DIAMETER:
			return getRodDiameter();
		case GeometryPackage.PIPE__ROTATION_X:
			return getRotationX();
		case GeometryPackage.PIPE__ROTATION_Y:
			return getRotationY();
		case GeometryPackage.PIPE__ROTATION_Z:
			return getRotationZ();
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
		case GeometryPackage.PIPE__NUM_RODS:
			setNumRods((Integer) newValue);
			return;
		case GeometryPackage.PIPE__PITCH:
			setPitch((Integer) newValue);
			return;
		case GeometryPackage.PIPE__ROD_DIAMETER:
			setRodDiameter((Integer) newValue);
			return;
		case GeometryPackage.PIPE__ROTATION_X:
			setRotationX((Double) newValue);
			return;
		case GeometryPackage.PIPE__ROTATION_Y:
			setRotationY((Double) newValue);
			return;
		case GeometryPackage.PIPE__ROTATION_Z:
			setRotationZ((Double) newValue);
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
		case GeometryPackage.PIPE__NUM_RODS:
			setNumRods(NUM_RODS_EDEFAULT);
			return;
		case GeometryPackage.PIPE__PITCH:
			setPitch(PITCH_EDEFAULT);
			return;
		case GeometryPackage.PIPE__ROD_DIAMETER:
			setRodDiameter(ROD_DIAMETER_EDEFAULT);
			return;
		case GeometryPackage.PIPE__ROTATION_X:
			setRotationX(ROTATION_X_EDEFAULT);
			return;
		case GeometryPackage.PIPE__ROTATION_Y:
			setRotationY(ROTATION_Y_EDEFAULT);
			return;
		case GeometryPackage.PIPE__ROTATION_Z:
			setRotationZ(ROTATION_Z_EDEFAULT);
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
		case GeometryPackage.PIPE__NUM_RODS:
			return numRods != NUM_RODS_EDEFAULT;
		case GeometryPackage.PIPE__PITCH:
			return pitch != PITCH_EDEFAULT;
		case GeometryPackage.PIPE__ROD_DIAMETER:
			return rodDiameter != ROD_DIAMETER_EDEFAULT;
		case GeometryPackage.PIPE__ROTATION_X:
			return rotationX != ROTATION_X_EDEFAULT;
		case GeometryPackage.PIPE__ROTATION_Y:
			return rotationY != ROTATION_Y_EDEFAULT;
		case GeometryPackage.PIPE__ROTATION_Z:
			return rotationZ != ROTATION_Z_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID) {
		case GeometryPackage.PIPE___GET_LOWER_EDGE:
			return getLowerEdge();
		case GeometryPackage.PIPE___GET_UPPER_EDGE:
			return getUpperEdge();
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (numRods: ");
		result.append(numRods);
		result.append(", pitch: ");
		result.append(pitch);
		result.append(", rodDiameter: ");
		result.append(rodDiameter);
		result.append(", rotationX: ");
		result.append(rotationX);
		result.append(", rotationY: ");
		result.append(rotationY);
		result.append(", rotationZ: ");
		result.append(rotationZ);
		result.append(')');
		return result.toString();
	}

} // PipeImpl
