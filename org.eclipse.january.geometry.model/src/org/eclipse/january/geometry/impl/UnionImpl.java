/**
 */
package org.eclipse.january.geometry.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.january.geometry.Union;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Union</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public class UnionImpl extends OperatorImpl implements Union {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected UnionImpl() {
		super();

		// Initialize the type
		type = "union";
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.UNION;
	}

} // UnionImpl
