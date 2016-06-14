/**
 */
package geometry.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import geometry.Cube;
import geometry.GeometryPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Cube</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link geometry.impl.CubeImpl#getSideLength <em>Side Length</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CubeImpl extends ShapeImpl implements Cube {
	/**
	 * The default value of the '{@link #getSideLength() <em>Side Length</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSideLength()
	 * @generated
	 * @ordered
	 */
	protected static final double SIDE_LENGTH_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSideLength() <em>Side Length</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSideLength()
	 * @generated
	 * @ordered
	 */
	protected double sideLength = SIDE_LENGTH_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CubeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.CUBE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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

		// Ignore negative side lengths
		if (newSideLength >= 0) {
			double oldSideLength = sideLength;
			sideLength = newSideLength;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET,
						GeometryPackage.CUBE__SIDE_LENGTH, oldSideLength,
						sideLength));
		}

		// Log an error for an invalid value
		else {
			logger.error("An attempt was made to change cube " + name + " " + id
					+ "'s side length to the invalid value " + newSideLength
					+ ".");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GeometryPackage.CUBE__SIDE_LENGTH:
				setSideLength((Double)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (sideLength: ");
		result.append(sideLength);
		result.append(')');
		return result.toString();
	}

} // CubeImpl
