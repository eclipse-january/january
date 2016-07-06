/**
 */
package org.eclipse.january.geometry.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.january.geometry.HeatExchanger;
import org.eclipse.january.geometry.Junction;
import org.eclipse.january.geometry.Pipe;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Heat Exchanger</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.impl.HeatExchangerImpl#getPipe <em>Pipe</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.impl.HeatExchangerImpl#getInput <em>Input</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.impl.HeatExchangerImpl#getOutput <em>Output</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HeatExchangerImpl extends ShapeImpl implements HeatExchanger {
	/**
	 * The cached value of the '{@link #getPipe() <em>Pipe</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPipe()
	 * @generated
	 * @ordered
	 */
	protected Pipe pipe;

	/**
	 * The cached value of the '{@link #getInput() <em>Input</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected Junction input;

	/**
	 * The cached value of the '{@link #getOutput() <em>Output</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutput()
	 * @generated
	 * @ordered
	 */
	protected Junction output;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HeatExchangerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.HEAT_EXCHANGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pipe getPipe() {
		if (pipe != null && pipe.eIsProxy()) {
			InternalEObject oldPipe = (InternalEObject)pipe;
			pipe = (Pipe)eResolveProxy(oldPipe);
			if (pipe != oldPipe) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeometryPackage.HEAT_EXCHANGER__PIPE, oldPipe, pipe));
			}
		}
		return pipe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pipe basicGetPipe() {
		return pipe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPipe(Pipe newPipe) {
		Pipe oldPipe = pipe;
		pipe = newPipe;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.HEAT_EXCHANGER__PIPE, oldPipe, pipe));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Junction getInput() {
		if (input != null && input.eIsProxy()) {
			InternalEObject oldInput = (InternalEObject)input;
			input = (Junction)eResolveProxy(oldInput);
			if (input != oldInput) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeometryPackage.HEAT_EXCHANGER__INPUT, oldInput, input));
			}
		}
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Junction basicGetInput() {
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInput(Junction newInput) {
		Junction oldInput = input;
		input = newInput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.HEAT_EXCHANGER__INPUT, oldInput, input));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Junction getOutput() {
		if (output != null && output.eIsProxy()) {
			InternalEObject oldOutput = (InternalEObject)output;
			output = (Junction)eResolveProxy(oldOutput);
			if (output != oldOutput) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeometryPackage.HEAT_EXCHANGER__OUTPUT, oldOutput, output));
			}
		}
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Junction basicGetOutput() {
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutput(Junction newOutput) {
		Junction oldOutput = output;
		output = newOutput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.HEAT_EXCHANGER__OUTPUT, oldOutput, output));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeometryPackage.HEAT_EXCHANGER__PIPE:
				if (resolve) return getPipe();
				return basicGetPipe();
			case GeometryPackage.HEAT_EXCHANGER__INPUT:
				if (resolve) return getInput();
				return basicGetInput();
			case GeometryPackage.HEAT_EXCHANGER__OUTPUT:
				if (resolve) return getOutput();
				return basicGetOutput();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GeometryPackage.HEAT_EXCHANGER__PIPE:
				setPipe((Pipe)newValue);
				return;
			case GeometryPackage.HEAT_EXCHANGER__INPUT:
				setInput((Junction)newValue);
				return;
			case GeometryPackage.HEAT_EXCHANGER__OUTPUT:
				setOutput((Junction)newValue);
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
			case GeometryPackage.HEAT_EXCHANGER__PIPE:
				setPipe((Pipe)null);
				return;
			case GeometryPackage.HEAT_EXCHANGER__INPUT:
				setInput((Junction)null);
				return;
			case GeometryPackage.HEAT_EXCHANGER__OUTPUT:
				setOutput((Junction)null);
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
			case GeometryPackage.HEAT_EXCHANGER__PIPE:
				return pipe != null;
			case GeometryPackage.HEAT_EXCHANGER__INPUT:
				return input != null;
			case GeometryPackage.HEAT_EXCHANGER__OUTPUT:
				return output != null;
		}
		return super.eIsSet(featureID);
	}

} //HeatExchangerImpl
