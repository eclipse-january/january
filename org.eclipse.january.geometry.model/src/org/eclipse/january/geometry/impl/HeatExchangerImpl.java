/**
 */
package org.eclipse.january.geometry.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.january.geometry.BoundingBox;
import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.january.geometry.HeatExchanger;
import org.eclipse.january.geometry.Junction;
import org.eclipse.january.geometry.Pipe;
import org.eclipse.january.geometry.Triangle;
import org.eclipse.january.geometry.Vertex;
import org.eclipse.january.geometry.util.MeshUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Heat Exchanger</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.january.geometry.impl.HeatExchangerImpl#getPipe
 * <em>Pipe</em>}</li>
 * <li>{@link org.eclipse.january.geometry.impl.HeatExchangerImpl#getInput
 * <em>Input</em>}</li>
 * <li>{@link org.eclipse.january.geometry.impl.HeatExchangerImpl#getOutput
 * <em>Output</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HeatExchangerImpl extends ShapeImpl implements HeatExchanger {
	/**
	 * The cached value of the '{@link #getPipe() <em>Pipe</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPipe()
	 * @generated
	 * @ordered
	 */
	protected Pipe pipe;

	/**
	 * The cached value of the '{@link #getInput() <em>Input</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected Junction input;

	/**
	 * The cached value of the '{@link #getOutput() <em>Output</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOutput()
	 * @generated
	 * @ordered
	 */
	protected Junction output;

	/**
	 * Whether or not the mesh has changed since the last time it was requested
	 * from this object. If true, the triangles list will have to be regenerated
	 * the next time getTriangles() is invoked.
	 * 
	 * @generated NOT
	 */
	protected boolean meshChanged = false;

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
	 * 
	 * @generated
	 */
	protected HeatExchangerImpl() {
		super();
	}

	/**
	 * Create a list of triangles that define a pipe which follows the shortest
	 * possible path between the given point and the wall surrounding the
	 * exchanger's primary pipe and which has the same radius as the primary
	 * pipe..
	 * 
	 * @param point
	 *            The point which will define the center of the the far end of
	 *            the created pipe.
	 * @return A list of triangles that describe the pipe.
	 */
	protected EList<Triangle> createPipeToPoint(Vertex point) {

		// Get the primary tube's start point
		BoundingBox start = pipe.getLowerEdge();
		double[] startPoint = new double[3];
		startPoint[0] = (start.getMaxX() - start.getMinX()) / 2
				+ start.getMinX();
		startPoint[1] = (start.getMaxY() - start.getMinY()) / 2
				+ start.getMinY();
		startPoint[2] = (start.getMaxZ() - start.getMinZ()) / 2
				+ start.getMinZ();

		// Get the primary tube's end point
		BoundingBox end = pipe.getUpperEdge();
		double[] endPoint = new double[3];
		endPoint[0] = (end.getMaxX() - end.getMinX()) / 2 + end.getMinX();
		endPoint[1] = (end.getMaxY() - end.getMinY()) / 2 + end.getMinY();
		endPoint[2] = (end.getMaxZ() - end.getMinZ()) / 2 + end.getMinZ();

		// Calculate the direction of the axis
		double[] axis = new double[3];
		axis[0] = endPoint[0] - startPoint[0];
		axis[1] = endPoint[1] - startPoint[1];
		axis[2] = endPoint[2] - startPoint[2];

		// Calculate the point 1/10th of its length along the axis from the
		// start point
		double[] wallStart = new double[3];
		wallStart[0] = startPoint[0] + (axis[0] * 0.1d);
		wallStart[1] = startPoint[1] + (axis[1] * 0.1d);
		wallStart[2] = startPoint[2] + (axis[2] * 0.1d);

		// Calculate the point 1/10th of its length along the axis from the end
		// point
		double[] wallEnd = new double[3];
		wallEnd[0] = endPoint[0] - (axis[0] * 0.1d);
		wallEnd[1] = endPoint[1] - (axis[1] * 0.1d);
		wallEnd[2] = endPoint[2] - (axis[2] * 0.1d);

		// Get the vector representing the axis segment from one end of the wall
		// to the other
		double[] primaryVector = new double[3];
		primaryVector[0] = wallEnd[0] - wallStart[0];
		primaryVector[1] = wallEnd[1] - wallStart[1];
		primaryVector[2] = wallEnd[2] - wallStart[2];

		// Calculate the squared magnitude of the primary pipe's axis
		double axisMag = Math.pow(primaryVector[0], 2)
				+ Math.pow(primaryVector[1], 2) + Math.pow(primaryVector[2], 2);

		// Get the vector from the start point to the target point
		double[] targetVector = new double[3];
		targetVector[0] = point.getX() - wallStart[0];
		targetVector[1] = point.getY() - wallStart[1];
		targetVector[2] = point.getZ() - wallStart[2];

		// Calculate the dot product between the axis and target vector
		double dotProduct = primaryVector[0] * targetVector[0]
				+ primaryVector[1] * targetVector[1]
				+ primaryVector[2] * targetVector[2];

		// Get the normalized length to the intersection point
		double step = dotProduct / axisMag;

		// Calculate the intersection point by stepping along the axis from the
		// start of the wall
		double[] intersection = new double[3];
		intersection[0] = wallStart[0] + primaryVector[0] * step;
		intersection[1] = wallStart[1] + primaryVector[1] * step;
		intersection[2] = wallStart[2] + primaryVector[2] * step;

		// Get the line between the intersection and the target point
		Vertex line = GeometryFactory.eINSTANCE.createVertex();
		line.setX(point.getX() - intersection[0]);
		line.setY(point.getY() - intersection[1]);
		line.setZ(point.getZ() - intersection[2]);

		// Get the axis of rotation for the cylinder by taking the cross product
		// of the line with the y axis.
		// x = line.y * 0 - line.z * 1
		// y = line.z * 0 - line.x * 0
		// z = line.x * 1 - line.y * 0
		Vertex axisOfRotation = GeometryFactory.eINSTANCE.createVertex();
		axisOfRotation.setX(-line.getZ());
		axisOfRotation.setY(0);
		axisOfRotation.setZ(line.getX());

		// Get line's magnitude
		double lineMagnitude = Math.sqrt(Math.pow(line.getX(), 2)
				+ Math.pow(line.getY(), 2) + Math.pow(line.getZ(), 2));

		// The magnitude of the rotation will be arccosine of the dot product
		// between the normal y vector and the normalized line. That will be =
		// line.x / length * 0 + line.y / length * 1 + line.z / length * 0
		double rotationAmount = Math.acos(line.getY() / lineMagnitude);

		// Calculate the length of the tube
		double length = Math.sqrt(Math.pow(intersection[0] - point.getX(), 2)
				+ Math.pow(intersection[1] - point.getY(), 2)
				+ Math.pow(intersection[2] - point.getZ(), 2));

		// Calculate the vector between the intersection point and the target
		// point
		double[] directVector = new double[3];
		directVector[0] = point.getX() - intersection[0];
		directVector[1] = point.getY() - intersection[1];
		directVector[2] = point.getZ() - intersection[2];

		// Normalize the vector of the direct line
		double directLength = Math.sqrt(Math.pow(directVector[0], 2)
				+ Math.pow(directVector[1], 2) + Math.pow(directVector[2], 2));
		double[] normalizedDirect = new double[3];
		normalizedDirect[0] = directVector[0] / directLength;
		normalizedDirect[1] = directVector[1] / directLength;
		normalizedDirect[2] = directVector[2] / directLength;

		// Get the vertices for a tube of the pipe's length
		double[] vertices = MeshUtils.createTube(length, pipe.getRadius(),
				pipe.getRadius(), RESOLUTION, SEGMENTS);

		// Rotate the tube so that it is pointing in the right direction
		vertices = MeshUtils.rotatePointsAboutAxis(vertices, axisOfRotation,
				rotationAmount);

		// Move the vertices to the intersection point, then step along the
		// direct
		// vector a distance equal to half the pipe's length. Since tubes'
		// translations are based on their central point, this will shift the
		// tube so that one end is at the intersection point and the other is at
		// the target. Also subtract the center point from this translation, so that they will be attached to the heat exchanger centered around the origin. 
		Vertex intersectionPoint = GeometryFactory.eINSTANCE.createVertex();
		intersectionPoint
				.setX(intersection[0] + (normalizedDirect[0] * length / 2) - center.getX());
		intersectionPoint
				.setY(intersection[1] + (normalizedDirect[1] * length / 2) - center.getY());
		intersectionPoint
				.setZ(intersection[2] + (normalizedDirect[2] * length / 2) - center.getZ());
		vertices = MeshUtils.centerPoints(vertices, intersectionPoint);

		// Get the triangles that define the tube
		return MeshUtils.createTubeMesh(vertices, RESOLUTION, SEGMENTS);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.HEAT_EXCHANGER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Pipe getPipe() {
		if (pipe != null && pipe.eIsProxy()) {
			InternalEObject oldPipe = (InternalEObject) pipe;
			pipe = (Pipe) eResolveProxy(oldPipe);
			if (pipe != oldPipe) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							GeometryPackage.HEAT_EXCHANGER__PIPE, oldPipe,
							pipe));
			}
		}
		return pipe;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Pipe basicGetPipe() {
		return pipe;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setPipe(Pipe newPipe) {
		Pipe oldPipe = pipe;
		pipe = newPipe;

		// If the pipe was changed, the mesh needs to be regenerated.
		if (newPipe != oldPipe) {
			meshChanged = true;
		}

		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeometryPackage.HEAT_EXCHANGER__PIPE, oldPipe, pipe));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Junction getInput() {
		if (input != null && input.eIsProxy()) {
			InternalEObject oldInput = (InternalEObject) input;
			input = (Junction) eResolveProxy(oldInput);
			if (input != oldInput) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							GeometryPackage.HEAT_EXCHANGER__INPUT, oldInput,
							input));
			}
		}
		return input;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Junction basicGetInput() {
		return input;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setInput(Junction newInput) {
		Junction oldInput = input;
		input = newInput;

		// If the junction was changed, the mesh needs to be regenerated.
		if (newInput != oldInput) {
			meshChanged = true;
		}
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeometryPackage.HEAT_EXCHANGER__INPUT, oldInput, input));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Junction getOutput() {
		if (output != null && output.eIsProxy()) {
			InternalEObject oldOutput = (InternalEObject) output;
			output = (Junction) eResolveProxy(oldOutput);
			if (output != oldOutput) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							GeometryPackage.HEAT_EXCHANGER__OUTPUT, oldOutput,
							output));
			}
		}
		return output;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Junction basicGetOutput() {
		return output;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setOutput(Junction newOutput) {
		Junction oldOutput = output;
		output = newOutput;

		// If the junction was changed, the mesh needs to be regenerated.
		if (newOutput != oldOutput) {
			meshChanged = true;
		}

		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeometryPackage.HEAT_EXCHANGER__OUTPUT, oldOutput, output));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.january.geometry.impl.ShapeImpl#getTriangles()
	 * 
	 * @generated NOT
	 */
	@Override
	public EList<Triangle> getTriangles() {

		// If nothing has changed return the current list of triangles.
		if (!meshChanged) {
			return triangles;
		}

		// Clear the current list
		triangles.clear();

		// If there is no pipe, there is nothing to draw.
		if (pipe == null) {
			return triangles;
		}

		// Start with getting the primary pipe's triangles.
		triangles = pipe.getTriangles();

		// Make the wall twice as thick as the pipe
		double wallWidth = pipe.getRadius() * 4;

		// Make the wall 4/5ths as tall as the pipe
		double wallHeight = pipe.getHeight() * 0.8;

		// Get the coordinates for the wall, rotated to fit around the pipe
		double[] wallCoords = MeshUtils.createRectangularPrism(wallWidth,
				wallHeight, wallWidth);
		wallCoords = MeshUtils.rotatePoints(wallCoords, pipe.getRotationX(),
				pipe.getRotationY(), pipe.getRotationZ());

		// Add the triangles for the wall
		triangles.addAll(MeshUtils.createRectangularPrismMesh(wallCoords));

		// If the input exists, create a pipe ending at its center
		if (input != null) {
			triangles.addAll(createPipeToPoint(input.getCenter()));
		}

		// If the output exists, create a pipe ending at its center
		if (output != null) {
			triangles.addAll(createPipeToPoint(output.getCenter()));
		}

		return triangles;

	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.january.geometry.impl.ShapeImpl#setCenter(org.eclipse.january.geometry.Vertex)
	 * 
	 * @generated NOT
	 */
	public void setCenter(Vertex newCenter){
		
		//If the exchanger has a pipe, move its center too
		if(pipe != null){
			pipe.setCenter(newCenter);
		}
		super.setCenter(newCenter);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case GeometryPackage.HEAT_EXCHANGER__PIPE:
			if (resolve)
				return getPipe();
			return basicGetPipe();
		case GeometryPackage.HEAT_EXCHANGER__INPUT:
			if (resolve)
				return getInput();
			return basicGetInput();
		case GeometryPackage.HEAT_EXCHANGER__OUTPUT:
			if (resolve)
				return getOutput();
			return basicGetOutput();
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
		case GeometryPackage.HEAT_EXCHANGER__PIPE:
			setPipe((Pipe) newValue);
			return;
		case GeometryPackage.HEAT_EXCHANGER__INPUT:
			setInput((Junction) newValue);
			return;
		case GeometryPackage.HEAT_EXCHANGER__OUTPUT:
			setOutput((Junction) newValue);
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
		case GeometryPackage.HEAT_EXCHANGER__PIPE:
			setPipe((Pipe) null);
			return;
		case GeometryPackage.HEAT_EXCHANGER__INPUT:
			setInput((Junction) null);
			return;
		case GeometryPackage.HEAT_EXCHANGER__OUTPUT:
			setOutput((Junction) null);
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
		case GeometryPackage.HEAT_EXCHANGER__PIPE:
			return pipe != null;
		case GeometryPackage.HEAT_EXCHANGER__INPUT:
			return input != null;
		case GeometryPackage.HEAT_EXCHANGER__OUTPUT:
			return output != null;
		}
		return super.eIsSet(featureID);
	}

} // HeatExchangerImpl
