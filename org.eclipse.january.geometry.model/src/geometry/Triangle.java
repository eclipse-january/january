/**
 */
package geometry;

import java.math.BigDecimal;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Triangle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A triangle is a collection of three vertices that are connected by three edges and together form a discrete plane in three dimensional space.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link geometry.Triangle#getVertices <em>Vertices</em>}</li>
 *   <li>{@link geometry.Triangle#getNormal <em>Normal</em>}</li>
 * </ul>
 *
 * @see geometry.GeometryPackage#getTriangle()
 * @model
 * @generated
 */
public interface Triangle extends EObject {
	/**
	 * Returns the value of the '<em><b>Vertices</b></em>' containment reference list.
	 * The list contents are of type {@link geometry.Vertex}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Each triangle has exactly three vertices where its edges meet.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Vertices</em>' containment reference list.
	 * @see geometry.GeometryPackage#getTriangle_Vertices()
	 * @model containment="true" lower="3" upper="3"
	 * @generated
	 */
	EList<Vertex> getVertices();

	/**
	 * Returns the value of the '<em><b>Normal</b></em>' attribute list.
	 * The list contents are of type {@link java.math.BigDecimal}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The normal, or normal vector, is a vector that is perpendicular to the surface of the triangle. It is computed by taking the cross product of any two vectors formed between the three vertices.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Normal</em>' attribute list.
	 * @see geometry.GeometryPackage#getTriangle_Normal()
	 * @model lower="3" upper="3"
	 * @generated
	 */
	EList<BigDecimal> getNormal();

} // Triangle
