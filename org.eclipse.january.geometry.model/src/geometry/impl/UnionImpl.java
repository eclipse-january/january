/**
 */
package geometry.impl;

import org.eclipse.emf.ecore.EClass;

import geometry.GeometryFactory;
import geometry.GeometryPackage;
import geometry.Union;

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

		// Set the object's type
		type = "union";
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.UNION;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see geometry.impl.OperatorImpl#clone()
	 */
	@Override
	public Object clone() {

		// Create a new union
		Union clone = GeometryFactory.eINSTANCE.createUnion();

		// Make the operator a copy of this
		clone.copy(this);
		return clone;
	}

} // UnionImpl
