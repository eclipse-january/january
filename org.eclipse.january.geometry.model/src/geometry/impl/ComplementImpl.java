/**
 */
package geometry.impl;

import org.eclipse.emf.ecore.EClass;

import geometry.Complement;
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
	 * 
	 * @generated NOT
	 */
	protected ComplementImpl() {
		super();

		// Initialize the type
		type = "complement";
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.COMPLEMENT;
	}

} // ComplementImpl
