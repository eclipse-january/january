/**
 */
package org.eclipse.january.geometry;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Poly Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.PolyShape#getFaces <em>Faces</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.PolyShape#getVertexSource <em>Vertex Source</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.PolyShape#getMaterialFiles <em>Material Files</em>}</li>
 * </ul>
 *
 * @see org.eclipse.january.geometry.GeometryPackage#getPolyShape()
 * @model
 * @generated
 */
public interface PolyShape extends Shape {
	/**
	 * Returns the value of the '<em><b>Faces</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.january.geometry.Face}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Faces</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Faces</em>' containment reference list.
	 * @see org.eclipse.january.geometry.GeometryPackage#getPolyShape_Faces()
	 * @model containment="true"
	 * @generated
	 */
	EList<Face> getFaces();

	/**
	 * Returns the value of the '<em><b>Vertex Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vertex Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertex Source</em>' containment reference.
	 * @see #setVertexSource(VertexSource)
	 * @see org.eclipse.january.geometry.GeometryPackage#getPolyShape_VertexSource()
	 * @model containment="true"
	 * @generated
	 */
	VertexSource getVertexSource();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.PolyShape#getVertexSource <em>Vertex Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertex Source</em>' containment reference.
	 * @see #getVertexSource()
	 * @generated
	 */
	void setVertexSource(VertexSource value);

	/**
	 * Returns the value of the '<em><b>Material Files</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Material Files</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Material Files</em>' attribute list.
	 * @see org.eclipse.january.geometry.GeometryPackage#getPolyShape_MaterialFiles()
	 * @model
	 * @generated
	 */
	EList<String> getMaterialFiles();

	/**
	 * Calcualates the triangles from the faces given to this polyshape
	 * @generated NOT
	 */
	void calculatePolyTriangles();

} // PolyShape
