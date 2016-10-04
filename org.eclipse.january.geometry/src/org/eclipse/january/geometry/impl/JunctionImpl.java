/**
 */
package org.eclipse.january.geometry.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.january.geometry.BoundingBox;
import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.january.geometry.Junction;
import org.eclipse.january.geometry.Pipe;
import org.eclipse.january.geometry.Triangle;
import org.eclipse.january.geometry.util.MeshUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Junction</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.january.geometry.impl.JunctionImpl#getHeight
 * <em>Height</em>}</li>
 * <li>{@link org.eclipse.january.geometry.impl.JunctionImpl#getZIn
 * <em>ZIn</em>}</li>
 * <li>{@link org.eclipse.january.geometry.impl.JunctionImpl#getZOut
 * <em>ZOut</em>}</li>
 * <li>{@link org.eclipse.january.geometry.impl.JunctionImpl#getInput
 * <em>Input</em>}</li>
 * <li>{@link org.eclipse.january.geometry.impl.JunctionImpl#getOutput
 * <em>Output</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JunctionImpl extends ShapeImpl implements Junction {
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
	 * The default value of the '{@link #getZIn() <em>ZIn</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getZIn()
	 * @generated
	 * @ordered
	 */
	protected static final double ZIN_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getZIn() <em>ZIn</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getZIn()
	 * @generated
	 * @ordered
	 */
	protected double zIn = ZIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getZOut() <em>ZOut</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getZOut()
	 * @generated
	 * @ordered
	 */
	protected static final double ZOUT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getZOut() <em>ZOut</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getZOut()
	 * @generated
	 * @ordered
	 */
	protected double zOut = ZOUT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInput() <em>Input</em>}' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected EList<Pipe> input;

	/**
	 * The cached value of the '{@link #getOutput() <em>Output</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOutput()
	 * @generated
	 * @ordered
	 */
	protected EList<Pipe> output;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected JunctionImpl() {
		super();

		// Initialize the lists
		input = new BasicEList<Pipe>();
		output = new BasicEList<Pipe>();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.JUNCTION;
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
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET,
						GeometryPackage.JUNCTION__HEIGHT, oldHeight, height));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public double getZIn() {
		return zIn;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setZIn(double newZIn) {

		// Fail silently if the new value is already set
		if (newZIn != zIn) {

			double oldZIn = zIn;
			zIn = newZIn;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET,
						GeometryPackage.JUNCTION__ZIN, oldZIn, zIn));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public double getZOut() {
		return zOut;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setZOut(double newZOut) {

		// Fail silently if the new value is already set
		if (newZOut != zOut) {

			double oldZOut = zOut;
			zOut = newZOut;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET,
						GeometryPackage.JUNCTION__ZOUT, oldZOut, zOut));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<Pipe> getInput() {
		if (input == null) {
			input = new EObjectContainmentEList<Pipe>(Pipe.class, this,
					GeometryPackage.JUNCTION__INPUT);
		}
		return input;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<Pipe> getOutput() {
		if (output == null) {
			output = new EObjectContainmentEList<Pipe>(Pipe.class, this,
					GeometryPackage.JUNCTION__OUTPUT);
		}
		return output;
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

		// Clear the current list of triangles
		triangles = new BasicEList<Triangle>();

		// The box defining the area of the junction's display
		BoundingBox box;

		// Initialize the junction with one of the pipes.
		if (!input.isEmpty()) {
			box = input.get(0).getLowerEdge();
		} else if (!output.isEmpty()) {
			box = output.get(0).getUpperEdge();
		} else {

			// If there are neither input nor output pipes, there is nothing to
			// display, so return an empty list.
			return triangles;
		}

		// Add each input pipe's lower edge
		for (Pipe pipe : input) {
			box.addArea(pipe.getLowerEdge());
		}

		// Add each output pipe's upper edge
		for (Pipe pipe : output) {
			box.addArea(pipe.getUpperEdge());
		}

		// Get the size of the box, allowing no side to be smaller than 1 unit.
		// We add an additional unit to the size to avoid clipping issues with
		// the pipes the junction is surrounding.
		double lengthX = Math.max(box.getMaxX() - box.getMinX() + 1, 1);
		double lengthY = Math.max(box.getMaxY() - box.getMinY() + 1, 1);
		double lengthZ = Math.max(box.getMaxZ() - box.getMinZ() + 1, 1);

		// Create a rectangular prism which is the size of the junction.
		double[] points = MeshUtils.createRectangularPrism(lengthX, lengthY,
				lengthZ);
		triangles = MeshUtils.createRectangularPrismMesh(points);

		// Set the junction's center to the box's center
		center.setX((box.getMaxX() - box.getMinX()) / 2 + box.getMinX());
		center.setY((box.getMaxY() - box.getMinY()) / 2 + box.getMinY());
		center.setZ((box.getMaxZ() - box.getMinZ()) / 2 + box.getMinZ());

		return triangles;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Object clone() {

		// Create a new junction
		Junction clone = GeometryFactory.eINSTANCE.createJunction();

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
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case GeometryPackage.JUNCTION__INPUT:
			return ((InternalEList<?>) getInput()).basicRemove(otherEnd, msgs);
		case GeometryPackage.JUNCTION__OUTPUT:
			return ((InternalEList<?>) getOutput()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case GeometryPackage.JUNCTION__HEIGHT:
			return getHeight();
		case GeometryPackage.JUNCTION__ZIN:
			return getZIn();
		case GeometryPackage.JUNCTION__ZOUT:
			return getZOut();
		case GeometryPackage.JUNCTION__INPUT:
			return getInput();
		case GeometryPackage.JUNCTION__OUTPUT:
			return getOutput();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case GeometryPackage.JUNCTION__HEIGHT:
			setHeight((Double) newValue);
			return;
		case GeometryPackage.JUNCTION__ZIN:
			setZIn((Double) newValue);
			return;
		case GeometryPackage.JUNCTION__ZOUT:
			setZOut((Double) newValue);
			return;
		case GeometryPackage.JUNCTION__INPUT:
			getInput().clear();
			getInput().addAll((Collection<? extends Pipe>) newValue);
			return;
		case GeometryPackage.JUNCTION__OUTPUT:
			getOutput().clear();
			getOutput().addAll((Collection<? extends Pipe>) newValue);
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
		case GeometryPackage.JUNCTION__HEIGHT:
			setHeight(HEIGHT_EDEFAULT);
			return;
		case GeometryPackage.JUNCTION__ZIN:
			setZIn(ZIN_EDEFAULT);
			return;
		case GeometryPackage.JUNCTION__ZOUT:
			setZOut(ZOUT_EDEFAULT);
			return;
		case GeometryPackage.JUNCTION__INPUT:
			getInput().clear();
			return;
		case GeometryPackage.JUNCTION__OUTPUT:
			getOutput().clear();
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
		case GeometryPackage.JUNCTION__HEIGHT:
			return height != HEIGHT_EDEFAULT;
		case GeometryPackage.JUNCTION__ZIN:
			return zIn != ZIN_EDEFAULT;
		case GeometryPackage.JUNCTION__ZOUT:
			return zOut != ZOUT_EDEFAULT;
		case GeometryPackage.JUNCTION__INPUT:
			return input != null && !input.isEmpty();
		case GeometryPackage.JUNCTION__OUTPUT:
			return output != null && !output.isEmpty();
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
		result.append(", zIn: ");
		result.append(zIn);
		result.append(", zOut: ");
		result.append(zOut);
		result.append(')');
		return result.toString();
	}

} // JunctionImpl
