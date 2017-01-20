/**
 */
package org.eclipse.january.geometry;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Face</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.Face#getVertexIndices <em>Vertex Indices</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.Face#getTextureIndices <em>Texture Indices</em>}</li>
 * </ul>
 *
 * @see org.eclipse.january.geometry.GeometryPackage#getFace()
 * @model
 * @generated
 */
public interface Face extends EObject {
	/**
	 * Returns the value of the '<em><b>Vertex Indices</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vertex Indices</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertex Indices</em>' attribute list.
	 * @see org.eclipse.january.geometry.GeometryPackage#getFace_VertexIndices()
	 * @model
	 * @generated
	 */
	EList<Integer> getVertexIndices();

	/**
	 * Returns the value of the '<em><b>Texture Indices</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Texture Indices</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Texture Indices</em>' attribute list.
	 * @see org.eclipse.january.geometry.GeometryPackage#getFace_TextureIndices()
	 * @model
	 * @generated
	 */
	EList<Integer> getTextureIndices();

} // Face
