/**
 */
package org.eclipse.january.geometry;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Geometry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Geometry is a collection of shapes that form a complex, three dimensional object.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.Geometry#getVertexSource <em>Vertex Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.january.geometry.GeometryPackage#getGeometry()
 * @model
 * @generated
 */
public interface Geometry extends INode {

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
	 * @see org.eclipse.january.geometry.GeometryPackage#getGeometry_VertexSource()
	 * @model containment="true"
	 * @generated
	 */
	VertexSource getVertexSource();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.Geometry#getVertexSource <em>Vertex Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertex Source</em>' containment reference.
	 * @see #getVertexSource()
	 * @generated
	 */
	void setVertexSource(VertexSource value);
} // Geometry
