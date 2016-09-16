/**
 */
package org.eclipse.january.geometry.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.january.geometry.BoundingBox;
import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.swt.widgets.Display;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Bounding Box</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.january.geometry.impl.BoundingBoxImpl#getMaxX <em>Max
 * X</em>}</li>
 * <li>{@link org.eclipse.january.geometry.impl.BoundingBoxImpl#getMaxY <em>Max
 * Y</em>}</li>
 * <li>{@link org.eclipse.january.geometry.impl.BoundingBoxImpl#getMaxZ <em>Max
 * Z</em>}</li>
 * <li>{@link org.eclipse.january.geometry.impl.BoundingBoxImpl#getMinX <em>Min
 * X</em>}</li>
 * <li>{@link org.eclipse.january.geometry.impl.BoundingBoxImpl#getMinY <em>Min
 * Y</em>}</li>
 * <li>{@link org.eclipse.january.geometry.impl.BoundingBoxImpl#getMinZ <em>Min
 * Z</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BoundingBoxImpl extends MinimalEObjectImpl.Container
		implements BoundingBox {
	/**
	 * The default value of the '{@link #getMaxX() <em>Max X</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMaxX()
	 * @generated
	 * @ordered
	 */
	protected static final double MAX_X_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMaxX() <em>Max X</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMaxX()
	 * @generated
	 * @ordered
	 */
	protected double maxX = MAX_X_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxY() <em>Max Y</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMaxY()
	 * @generated
	 * @ordered
	 */
	protected static final double MAX_Y_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMaxY() <em>Max Y</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMaxY()
	 * @generated
	 * @ordered
	 */
	protected double maxY = MAX_Y_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxZ() <em>Max Z</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMaxZ()
	 * @generated
	 * @ordered
	 */
	protected static final double MAX_Z_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMaxZ() <em>Max Z</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMaxZ()
	 * @generated
	 * @ordered
	 */
	protected double maxZ = MAX_Z_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinX() <em>Min X</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMinX()
	 * @generated
	 * @ordered
	 */
	protected static final double MIN_X_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMinX() <em>Min X</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMinX()
	 * @generated
	 * @ordered
	 */
	protected double minX = MIN_X_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinY() <em>Min Y</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMinY()
	 * @generated
	 * @ordered
	 */
	protected static final double MIN_Y_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMinY() <em>Min Y</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMinY()
	 * @generated
	 * @ordered
	 */
	protected double minY = MIN_Y_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinZ() <em>Min Z</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMinZ()
	 * @generated
	 * @ordered
	 */
	protected static final double MIN_Z_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMinZ() <em>Min Z</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMinZ()
	 * @generated
	 * @ordered
	 */
	protected double minZ = MIN_Z_EDEFAULT;

	/**
	 * The thread that will deliver updates to the class's eAdapters.
	 */
	protected Thread updateThread;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected BoundingBoxImpl() {
		super();

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.BOUNDING_BOX;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public double getMaxX() {
		return maxX;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setMaxX(double newMaxX) {
		double oldMaxX = maxX;
		maxX = newMaxX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeometryPackage.BOUNDING_BOX__MAX_X, oldMaxX, maxX));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public double getMaxY() {
		return maxY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setMaxY(double newMaxY) {
		double oldMaxY = maxY;
		maxY = newMaxY;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeometryPackage.BOUNDING_BOX__MAX_Y, oldMaxY, maxY));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public double getMaxZ() {
		return maxZ;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setMaxZ(double newMaxZ) {
		double oldMaxZ = maxZ;
		maxZ = newMaxZ;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeometryPackage.BOUNDING_BOX__MAX_Z, oldMaxZ, maxZ));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public double getMinX() {
		return minX;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setMinX(double newMinX) {
		double oldMinX = minX;
		minX = newMinX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeometryPackage.BOUNDING_BOX__MIN_X, oldMinX, minX));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public double getMinY() {
		return minY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setMinY(double newMinY) {
		double oldMinY = minY;
		minY = newMinY;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeometryPackage.BOUNDING_BOX__MIN_Y, oldMinY, minY));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public double getMinZ() {
		return minZ;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setMinZ(double newMinZ) {
		double oldMinZ = minZ;
		minZ = newMinZ;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeometryPackage.BOUNDING_BOX__MIN_Z, oldMinZ, minZ));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void addArea(BoundingBox area) {

		// Compare each of the area's maximums to the current maximums,
		// replacing them if any are higher
		if (area.getMaxX() > maxX) {
			maxX = area.getMaxX();
		}

		if (area.getMaxY() > maxY) {
			maxY = area.getMaxY();
		}

		if (area.getMaxZ() > maxZ) {
			maxZ = area.getMaxZ();
		}

		// Compare each of the area's minimums to the current minimums,
		// replacing them if any are lower
		if (area.getMinX() < minX) {
			minX = area.getMinX();
		}

		if (area.getMinY() < minY) {
			minY = area.getMinY();
		}

		if (area.getMinZ() < minZ) {
			minZ = area.getMinZ();
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
		case GeometryPackage.BOUNDING_BOX__MAX_X:
			return getMaxX();
		case GeometryPackage.BOUNDING_BOX__MAX_Y:
			return getMaxY();
		case GeometryPackage.BOUNDING_BOX__MAX_Z:
			return getMaxZ();
		case GeometryPackage.BOUNDING_BOX__MIN_X:
			return getMinX();
		case GeometryPackage.BOUNDING_BOX__MIN_Y:
			return getMinY();
		case GeometryPackage.BOUNDING_BOX__MIN_Z:
			return getMinZ();
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
		case GeometryPackage.BOUNDING_BOX__MAX_X:
			setMaxX((Double) newValue);
			return;
		case GeometryPackage.BOUNDING_BOX__MAX_Y:
			setMaxY((Double) newValue);
			return;
		case GeometryPackage.BOUNDING_BOX__MAX_Z:
			setMaxZ((Double) newValue);
			return;
		case GeometryPackage.BOUNDING_BOX__MIN_X:
			setMinX((Double) newValue);
			return;
		case GeometryPackage.BOUNDING_BOX__MIN_Y:
			setMinY((Double) newValue);
			return;
		case GeometryPackage.BOUNDING_BOX__MIN_Z:
			setMinZ((Double) newValue);
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
		case GeometryPackage.BOUNDING_BOX__MAX_X:
			setMaxX(MAX_X_EDEFAULT);
			return;
		case GeometryPackage.BOUNDING_BOX__MAX_Y:
			setMaxY(MAX_Y_EDEFAULT);
			return;
		case GeometryPackage.BOUNDING_BOX__MAX_Z:
			setMaxZ(MAX_Z_EDEFAULT);
			return;
		case GeometryPackage.BOUNDING_BOX__MIN_X:
			setMinX(MIN_X_EDEFAULT);
			return;
		case GeometryPackage.BOUNDING_BOX__MIN_Y:
			setMinY(MIN_Y_EDEFAULT);
			return;
		case GeometryPackage.BOUNDING_BOX__MIN_Z:
			setMinZ(MIN_Z_EDEFAULT);
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
		case GeometryPackage.BOUNDING_BOX__MAX_X:
			return maxX != MAX_X_EDEFAULT;
		case GeometryPackage.BOUNDING_BOX__MAX_Y:
			return maxY != MAX_Y_EDEFAULT;
		case GeometryPackage.BOUNDING_BOX__MAX_Z:
			return maxZ != MAX_Z_EDEFAULT;
		case GeometryPackage.BOUNDING_BOX__MIN_X:
			return minX != MIN_X_EDEFAULT;
		case GeometryPackage.BOUNDING_BOX__MIN_Y:
			return minY != MIN_Y_EDEFAULT;
		case GeometryPackage.BOUNDING_BOX__MIN_Z:
			return minZ != MIN_Z_EDEFAULT;
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
		case GeometryPackage.BOUNDING_BOX___ADD_AREA__BOUNDINGBOX:
			addArea((BoundingBox) arguments.get(0));
			return null;
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
		result.append(" (maxX: ");
		result.append(maxX);
		result.append(", maxY: ");
		result.append(maxY);
		result.append(", maxZ: ");
		result.append(maxZ);
		result.append(", minX: ");
		result.append(minX);
		result.append(", minY: ");
		result.append(minY);
		result.append(", minZ: ");
		result.append(minZ);
		result.append(')');
		return result.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.common.notify.impl.BasicNotifierImpl#eNotify(org.eclipse.
	 * emf.common.notify.Notification)
	 */
	@Override
	public void eNotify(Notification notification) {
		// Check if a notification is required
		Adapter[] eAdapters = eBasicAdapterArray();
		if (eAdapters != null && eDeliver()) {

			// If this notification is on the UI thread, launch a new thread to
			// handle it
			Display currDisplay = Display.getCurrent();
			if (currDisplay != null
					&& Thread.currentThread() == currDisplay.getThread()) {

				Thread updateThread = new Thread() {

					@Override
					public void run() {
						for (int i = 0, size = eAdapters.length; i < size; ++i) {
							eAdapters[i].notifyChanged(notification);
						}
					}
				};

				updateThread.run();

			}

			// If we are already off the UI thread, such as being called by a
			// thread created by some other object's eNotify(), then just notify
			// the adapters.
			else {
				for (int i = 0, size = eAdapters.length; i < size; ++i) {
					eAdapters[i].notifyChanged(notification);
				}
			}
		}
	}
} // BoundingBoxImpl
