/**
 */
package geometry.impl;

import org.eclipse.emf.ecore.EClass;

import geometry.Complement;
import geometry.GeometryFactory;
import geometry.GeometryPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Complement</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public class ComplementImpl extends OperatorImpl implements Complement {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ComplementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.COMPLEMENT;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see geometry.impl.OperatorImpl#clone()
	 */
	@Override
	public Object clone() {

		// Create a new complement
		Complement clone = GeometryFactory.eINSTANCE.createComplement();

		// Make the operator a copy of this
		clone.copy(this);
		return clone;
	}

} // ComplementImpl
