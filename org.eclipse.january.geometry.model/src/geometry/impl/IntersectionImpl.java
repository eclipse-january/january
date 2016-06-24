/**
 */
package geometry.impl;

import org.eclipse.emf.ecore.EClass;

import geometry.GeometryFactory;
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
	 * @generated
	 */
	protected IntersectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.INTERSECTION;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see geometry.impl.OperatorImpl#clone()
	 */
	@Override
	public Object clone() {

		// Create a new intersection
		Intersection clone = GeometryFactory.eINSTANCE.createIntersection();

		// Make the operator a copy of this
		clone.copy(this);
		return clone;
	}

} // IntersectionImpl
