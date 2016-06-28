/**
 */
package geometry.impl;

import org.eclipse.emf.ecore.EClass;

import geometry.GeometryPackage;
import geometry.Intersection;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Intersection</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public class IntersectionImpl extends OperatorImpl implements Intersection {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected IntersectionImpl() {
		super();

		// Initialize the type
		type = "intersection";
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.INTERSECTION;
	}

} // IntersectionImpl
