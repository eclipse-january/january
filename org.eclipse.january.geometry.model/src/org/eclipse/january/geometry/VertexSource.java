/**
 */
package org.eclipse.january.geometry;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vertex Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.VertexSource#getVertices <em>Vertices</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.VertexSource#getTextureCoordinates <em>Texture Coordinates</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.VertexSource#getMaterialFiles <em>Material Files</em>}</li>
 * </ul>
 *
 * @see org.eclipse.january.geometry.GeometryPackage#getVertexSource()
 * @model
 * @generated
 */
public interface VertexSource extends EObject {
	/**
	 * Returns the value of the '<em><b>Vertices</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.january.geometry.Vertex}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vertices</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertices</em>' containment reference list.
	 * @see org.eclipse.january.geometry.GeometryPackage#getVertexSource_Vertices()
	 * @model containment="true"
	 * @generated
	 */
	EList<Vertex> getVertices();

	/**
	 * Returns the value of the '<em><b>Texture Coordinates</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.january.geometry.Vertex}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Texture Coordinates</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Texture Coordinates</em>' containment reference list.
	 * @see org.eclipse.january.geometry.GeometryPackage#getVertexSource_TextureCoordinates()
	 * @model containment="true"
	 * @generated
	 */
	EList<Vertex> getTextureCoordinates();

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
	 * @see org.eclipse.january.geometry.GeometryPackage#getVertexSource_MaterialFiles()
	 * @model
	 * @generated
	 */
	EList<String> getMaterialFiles();

} // VertexSource
