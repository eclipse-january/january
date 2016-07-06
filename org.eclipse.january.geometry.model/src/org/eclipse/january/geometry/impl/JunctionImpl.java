/**
 */
package org.eclipse.january.geometry.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.january.geometry.Junction;
import org.eclipse.january.geometry.Pipe;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Junction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.impl.JunctionImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.impl.JunctionImpl#getZIn <em>ZIn</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.impl.JunctionImpl#getZOut <em>ZOut</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.impl.JunctionImpl#getInput <em>Input</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.impl.JunctionImpl#getOutput <em>Output</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JunctionImpl extends ShapeImpl implements Junction {
	/**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected static final double HEIGHT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected double height = HEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getZIn() <em>ZIn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZIn()
	 * @generated
	 * @ordered
	 */
	protected static final double ZIN_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getZIn() <em>ZIn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZIn()
	 * @generated
	 * @ordered
	 */
	protected double zIn = ZIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getZOut() <em>ZOut</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZOut()
	 * @generated
	 * @ordered
	 */
	protected static final double ZOUT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getZOut() <em>ZOut</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZOut()
	 * @generated
	 * @ordered
	 */
	protected double zOut = ZOUT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInput() <em>Input</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected EList<Pipe> input;

	/**
	 * The cached value of the '{@link #getOutput() <em>Output</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutput()
	 * @generated
	 * @ordered
	 */
	protected EList<Pipe> output;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.JUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeight(double newHeight) {
		double oldHeight = height;
		height = newHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.JUNCTION__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getZIn() {
		return zIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZIn(double newZIn) {
		double oldZIn = zIn;
		zIn = newZIn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.JUNCTION__ZIN, oldZIn, zIn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getZOut() {
		return zOut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZOut(double newZOut) {
		double oldZOut = zOut;
		zOut = newZOut;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.JUNCTION__ZOUT, oldZOut, zOut));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Pipe> getInput() {
		if (input == null) {
			input = new EObjectContainmentEList<Pipe>(Pipe.class, this, GeometryPackage.JUNCTION__INPUT);
		}
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Pipe> getOutput() {
		if (output == null) {
			output = new EObjectContainmentEList<Pipe>(Pipe.class, this, GeometryPackage.JUNCTION__OUTPUT);
		}
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeometryPackage.JUNCTION__INPUT:
				return ((InternalEList<?>)getInput()).basicRemove(otherEnd, msgs);
			case GeometryPackage.JUNCTION__OUTPUT:
				return ((InternalEList<?>)getOutput()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GeometryPackage.JUNCTION__HEIGHT:
				setHeight((Double)newValue);
				return;
			case GeometryPackage.JUNCTION__ZIN:
				setZIn((Double)newValue);
				return;
			case GeometryPackage.JUNCTION__ZOUT:
				setZOut((Double)newValue);
				return;
			case GeometryPackage.JUNCTION__INPUT:
				getInput().clear();
				getInput().addAll((Collection<? extends Pipe>)newValue);
				return;
			case GeometryPackage.JUNCTION__OUTPUT:
				getOutput().clear();
				getOutput().addAll((Collection<? extends Pipe>)newValue);
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

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

} //JunctionImpl
