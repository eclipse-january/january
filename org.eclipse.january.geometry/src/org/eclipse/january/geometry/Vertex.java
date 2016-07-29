package org.eclipse.january.geometry;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vertex</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The Vertex class represents a simple three dimensional point in space with x, y, and z coordinates where one or more curves, lines or edges converge.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.Vertex#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.Vertex#getY <em>Y</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.Vertex#getZ <em>Z</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.january.geometry.GeometryPackage#getVertex()
 * @model
 * @generated
 */
public interface Vertex extends EObject {
	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The vertex's coordinate along the x axis.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(double)
	 * @see org.eclipse.january.geometry.GeometryPackage#getVertex_X()
	 * @model
	 * @generated
	 */
	double getX();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.Vertex#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(double value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The vertex's coordinate along the y axis.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(double)
	 * @see org.eclipse.january.geometry.GeometryPackage#getVertex_Y()
	 * @model
	 * @generated
	 */
	double getY();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.Vertex#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(double value);

	/**
	 * Returns the value of the '<em><b>Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The vertex's coordinate along the z axis.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Z</em>' attribute.
	 * @see #setZ(double)
	 * @see org.eclipse.january.geometry.GeometryPackage#getVertex_Z()
	 * @model
	 * @generated
	 */
	double getZ();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.Vertex#getZ <em>Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Z</em>' attribute.
	 * @see #getZ()
	 * @generated
	 */
	void setZ(double value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Create a copy of this vertex.
	 * <!-- end-model-doc -->
	 * @model dataType="org.eclipse.january.geometry.Object"
	 * @generated
	 */
	Object clone();

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

} // Vertex