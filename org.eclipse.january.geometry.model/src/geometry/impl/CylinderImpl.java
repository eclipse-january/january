/**
 */
package geometry.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import geometry.Cylinder;
import geometry.GeometryPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Cylinder</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link geometry.impl.CylinderImpl#getRadius <em>Radius</em>}</li>
 *   <li>{@link geometry.impl.CylinderImpl#getHeight <em>Height</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CylinderImpl extends ShapeImpl implements Cylinder {
	/**
	 * The default value of the '{@link #getRadius() <em>Radius</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRadius()
	 * @generated
	 * @ordered
	 */
	protected static final double RADIUS_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRadius() <em>Radius</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRadius()
	 * @generated
	 * @ordered
	 */
	protected double radius = RADIUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected static final double HEIGHT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected double height = HEIGHT_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CylinderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.CYLINDER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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

		// If the new value is invalid, ignore it and log an error
		if (newRadius >= 0) {
			double oldRadius = radius;
			radius = newRadius;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET,
						GeometryPackage.CYLINDER__RADIUS, oldRadius, radius));
		} else {
			logger.error("An attempt was made to change cylinder " + name + " "
					+ id + "'s radius to the invalid value " + newRadius + ".");
		}

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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

		// If the new value is invalid, ignore it and log an error
		if (newHeight >= 0) {
			double oldHeight = height;
			height = newHeight;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET,
						GeometryPackage.CYLINDER__HEIGHT, oldHeight, height));
		} else {
			logger.error("An attempt was made to change cylinder " + name + " "
					+ id + "'s height to the invalid value " + newHeight + ".");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GeometryPackage.CYLINDER__RADIUS:
				setRadius((Double)newValue);
				return;
			case GeometryPackage.CYLINDER__HEIGHT:
				setHeight((Double)newValue);
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
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (radius: ");
		result.append(radius);
		result.append(", height: ");
		result.append(height);
		result.append(')');
		return result.toString();
	}

} // CylinderImpl
