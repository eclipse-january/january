/**
 */
package geometry;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link geometry.Operator#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @see geometry.GeometryPackage#getOperator()
 * @model
 * @generated
 */
public interface Operator extends NamedNode {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link geometry.NamedNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see geometry.GeometryPackage#getOperator_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<NamedNode> getChildren();

} // Operator
