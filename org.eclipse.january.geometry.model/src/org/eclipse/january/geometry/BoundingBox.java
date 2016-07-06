/**
 */
package org.eclipse.january.geometry;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bounding Box</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A bounding box describes the minimally sized rectangular prism box to contain some region. The box is defined by two points on opposite sides of the prism, one formed from (minX, minY, minZ) and the other from (maxX, maxY, maxZ).  These points are chosen such that minX is the smallest the x coordinate can be in any point within the prism, maxX is the maximal x coordinate value, minY is the minal y coordinate value, etc. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.BoundingBox#getMaxX <em>Max X</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.BoundingBox#getMaxY <em>Max Y</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.BoundingBox#getMaxZ <em>Max Z</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.BoundingBox#getMinX <em>Min X</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.BoundingBox#getMinY <em>Min Y</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.BoundingBox#getMinZ <em>Min Z</em>}</li>
 * </ul>
 *
 * @see org.eclipse.january.geometry.GeometryPackage#getBoundingBox()
 * @model
 * @generated
 */
public interface BoundingBox extends EObject {
	/**
	 * Returns the value of the '<em><b>Max X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The maximal x value in the bounding box.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max X</em>' attribute.
	 * @see #setMaxX(double)
	 * @see org.eclipse.january.geometry.GeometryPackage#getBoundingBox_MaxX()
	 * @model
	 * @generated
	 */
	double getMaxX();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.BoundingBox#getMaxX <em>Max X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max X</em>' attribute.
	 * @see #getMaxX()
	 * @generated
	 */
	void setMaxX(double value);

	/**
	 * Returns the value of the '<em><b>Max Y</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The maximal y value in the bounding box.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max Y</em>' attribute.
	 * @see #setMaxY(double)
	 * @see org.eclipse.january.geometry.GeometryPackage#getBoundingBox_MaxY()
	 * @model default="0.0"
	 * @generated
	 */
	double getMaxY();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.BoundingBox#getMaxY <em>Max Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Y</em>' attribute.
	 * @see #getMaxY()
	 * @generated
	 */
	void setMaxY(double value);

	/**
	 * Returns the value of the '<em><b>Max Z</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The maximal z value in the bounding box.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max Z</em>' attribute.
	 * @see #setMaxZ(double)
	 * @see org.eclipse.january.geometry.GeometryPackage#getBoundingBox_MaxZ()
	 * @model default="0.0"
	 * @generated
	 */
	double getMaxZ();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.BoundingBox#getMaxZ <em>Max Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Z</em>' attribute.
	 * @see #getMaxZ()
	 * @generated
	 */
	void setMaxZ(double value);

	/**
	 * Returns the value of the '<em><b>Min X</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minimal x value in the bounding box.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Min X</em>' attribute.
	 * @see #setMinX(double)
	 * @see org.eclipse.january.geometry.GeometryPackage#getBoundingBox_MinX()
	 * @model default="0.0"
	 * @generated
	 */
	double getMinX();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.BoundingBox#getMinX <em>Min X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min X</em>' attribute.
	 * @see #getMinX()
	 * @generated
	 */
	void setMinX(double value);

	/**
	 * Returns the value of the '<em><b>Min Y</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minimal y value in the bounding box.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Min Y</em>' attribute.
	 * @see #setMinY(double)
	 * @see org.eclipse.january.geometry.GeometryPackage#getBoundingBox_MinY()
	 * @model default="0.0"
	 * @generated
	 */
	double getMinY();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.BoundingBox#getMinY <em>Min Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Y</em>' attribute.
	 * @see #getMinY()
	 * @generated
	 */
	void setMinY(double value);

	/**
	 * Returns the value of the '<em><b>Min Z</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minimal z value in the bounding box.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Min Z</em>' attribute.
	 * @see #setMinZ(double)
	 * @see org.eclipse.january.geometry.GeometryPackage#getBoundingBox_MinZ()
	 * @model default="0.0"
	 * @generated
	 */
	double getMinZ();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.BoundingBox#getMinZ <em>Min Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Z</em>' attribute.
	 * @see #getMinZ()
	 * @generated
	 */
	void setMinZ(double value);

} // BoundingBox
