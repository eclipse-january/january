/**
 */
package org.eclipse.january.geometry;

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
 *   <li>{@link org.eclipse.january.geometry.Triangle#getNormal <em>Normal</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.Triangle#getVertex1 <em>Vertex1</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.Triangle#getVertex2 <em>Vertex2</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.Triangle#getVertex3 <em>Vertex3</em>}</li>
 * </ul>
 *
 * @see org.eclipse.january.geometry.GeometryPackage#getTriangle()
 * @model
 * @generated
 */
public interface Triangle extends EObject {
	/**
	 * Returns the value of the '<em><b>Normal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The normal, or normal vector, is a vector that is perpendicular to the surface of the triangle. It is computed by taking the cross product of any two vectors formed between the three vertices.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Normal</em>' containment reference.
	 * @see #setNormal(Vertex)
	 * @see org.eclipse.january.geometry.GeometryPackage#getTriangle_Normal()
	 * @model containment="true"
	 * @generated
	 */
	Vertex getNormal();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.Triangle#getNormal <em>Normal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Normal</em>' containment reference.
	 * @see #getNormal()
	 * @generated
	 */
	void setNormal(Vertex value);

	/**
	 * Returns the value of the '<em><b>Vertex1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The first of the three ordered vertices that make up the triangle.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Vertex1</em>' containment reference.
	 * @see #setVertex1(Vertex)
	 * @see org.eclipse.january.geometry.GeometryPackage#getTriangle_Vertex1()
	 * @model containment="true"
	 * @generated
	 */
	Vertex getVertex1();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.Triangle#getVertex1 <em>Vertex1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertex1</em>' containment reference.
	 * @see #getVertex1()
	 * @generated
	 */
	void setVertex1(Vertex value);

	/**
	 * Returns the value of the '<em><b>Vertex2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The second of the three ordered vertices that make up the triangle.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Vertex2</em>' containment reference.
	 * @see #setVertex2(Vertex)
	 * @see org.eclipse.january.geometry.GeometryPackage#getTriangle_Vertex2()
	 * @model containment="true"
	 * @generated
	 */
	Vertex getVertex2();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.Triangle#getVertex2 <em>Vertex2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertex2</em>' containment reference.
	 * @see #getVertex2()
	 * @generated
	 */
	void setVertex2(Vertex value);

	/**
	 * Returns the value of the '<em><b>Vertex3</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The third of the three ordered vertices that make up the triangle.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Vertex3</em>' containment reference.
	 * @see #setVertex3(Vertex)
	 * @see org.eclipse.january.geometry.GeometryPackage#getTriangle_Vertex3()
	 * @model containment="true"
	 * @generated
	 */
	Vertex getVertex3();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.Triangle#getVertex3 <em>Vertex3</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertex3</em>' containment reference.
	 * @see #getVertex3()
	 * @generated
	 */
	void setVertex3(Vertex value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get the three vertices making up the triangle, in order vertex1, vertex2, vertex3.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Vertex> getVertices();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model otherObjectDataType="org.eclipse.january.geometry.Object"
	 * @generated
	 */
	boolean equals(Object otherObject);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	int hashCode();

} // Triangle
