/**
 */
package org.eclipse.january.geometry;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pipe</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A pipe is a directional tube. It has a definite top and a definite bottom, and has been extended to include data about rods important to a nuclear reactor model.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.Pipe#getNumRods <em>Num Rods</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.Pipe#getPitch <em>Pitch</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.Pipe#getRodDiameter <em>Rod Diameter</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.Pipe#getRotationX <em>Rotation X</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.Pipe#getRotationY <em>Rotation Y</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.Pipe#getRotationZ <em>Rotation Z</em>}</li>
 * </ul>
 *
 * @see org.eclipse.january.geometry.GeometryPackage#getPipe()
 * @model
 * @generated
 */
public interface Pipe extends Tube {
	/**
	 * Returns the value of the '<em><b>Num Rods</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The number of rods in the pipe.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Num Rods</em>' attribute.
	 * @see #setNumRods(int)
	 * @see org.eclipse.january.geometry.GeometryPackage#getPipe_NumRods()
	 * @model
	 * @generated
	 */
	int getNumRods();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.Pipe#getNumRods <em>Num Rods</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Rods</em>' attribute.
	 * @see #getNumRods()
	 * @generated
	 */
	void setNumRods(int value);

	/**
	 * Returns the value of the '<em><b>Pitch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The pipe's pitch.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pitch</em>' attribute.
	 * @see #setPitch(int)
	 * @see org.eclipse.january.geometry.GeometryPackage#getPipe_Pitch()
	 * @model
	 * @generated
	 */
	int getPitch();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.Pipe#getPitch <em>Pitch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pitch</em>' attribute.
	 * @see #getPitch()
	 * @generated
	 */
	void setPitch(int value);

	/**
	 * Returns the value of the '<em><b>Rod Diameter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The diameter of the pipe's contained rods.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rod Diameter</em>' attribute.
	 * @see #setRodDiameter(int)
	 * @see org.eclipse.january.geometry.GeometryPackage#getPipe_RodDiameter()
	 * @model
	 * @generated
	 */
	int getRodDiameter();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.Pipe#getRodDiameter <em>Rod Diameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rod Diameter</em>' attribute.
	 * @see #getRodDiameter()
	 * @generated
	 */
	void setRodDiameter(int value);

	/**
	 * Returns the value of the '<em><b>Rotation X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The amount of rotation about the X axis applied to the pipe, given in radians.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rotation X</em>' attribute.
	 * @see #setRotationX(double)
	 * @see org.eclipse.january.geometry.GeometryPackage#getPipe_RotationX()
	 * @model
	 * @generated
	 */
	double getRotationX();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.Pipe#getRotationX <em>Rotation X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotation X</em>' attribute.
	 * @see #getRotationX()
	 * @generated
	 */
	void setRotationX(double value);

	/**
	 * Returns the value of the '<em><b>Rotation Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotation Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The amount of rotation about the y axis applied to the pipe, given in radians.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rotation Y</em>' attribute.
	 * @see #setRotationY(double)
	 * @see org.eclipse.january.geometry.GeometryPackage#getPipe_RotationY()
	 * @model
	 * @generated
	 */
	double getRotationY();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.Pipe#getRotationY <em>Rotation Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotation Y</em>' attribute.
	 * @see #getRotationY()
	 * @generated
	 */
	void setRotationY(double value);

	/**
	 * Returns the value of the '<em><b>Rotation Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotation Z</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The amount of rotation about the z axis applied to the pipe, given in radians. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rotation Z</em>' attribute.
	 * @see #setRotationZ(double)
	 * @see org.eclipse.january.geometry.GeometryPackage#getPipe_RotationZ()
	 * @model
	 * @generated
	 */
	double getRotationZ();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.Pipe#getRotationZ <em>Rotation Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotation Z</em>' attribute.
	 * @see #getRotationZ()
	 * @generated
	 */
	void setRotationZ(double value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get the bounding box encompassing the lower (input) edge of the pipe.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	BoundingBox getLowerEdge();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get the bounding box surrounding the top (output) edge of the pipe.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	BoundingBox getUpperEdge();

} // Pipe
