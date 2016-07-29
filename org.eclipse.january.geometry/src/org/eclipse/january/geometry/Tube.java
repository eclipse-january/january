package org.eclipse.january.geometry;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tube</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A tube is a cylindrical shape with a circular hole going down its length. There are two cases which a tube may represent:
 * 
 * In the normal case, a tube consists of four elements. There are two cylinderical surfaces of the same heigh and center, oriented in the same direction, with one containing the other. There are also two flat "O" shaped surfaces which rest on the top and bottom of the two curved surfaces, forming the flat edges of the tube.
 * 
 * In the special case that the tubes inner radius is equal to its radius, there will be only one surface. This surface will be the outline of a circle extruded to form a cylinder with no top or bottom.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.Tube#getHeight <em>Height</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.Tube#getInnerRadius <em>Inner Radius</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.Tube#getRadius <em>Radius</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.january.geometry.GeometryPackage#getTube()
 * @model
 * @generated
 */
public interface Tube extends Shape {
	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The cylinder's height.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(double)
	 * @see org.eclipse.january.geometry.GeometryPackage#getTube_Height()
	 * @model default="0.0"
	 * @generated
	 */
	double getHeight();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.Tube#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(double value);

	/**
	 * Returns the value of the '<em><b>Inner Radius</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The radius of the inner hole bored through the outer cylinder to form the pipe. This value must be no greater than radius. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inner Radius</em>' attribute.
	 * @see #setInnerRadius(double)
	 * @see org.eclipse.january.geometry.GeometryPackage#getTube_InnerRadius()
	 * @model default="0.0"
	 * @generated
	 */
	double getInnerRadius();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.Tube#getInnerRadius <em>Inner Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inner Radius</em>' attribute.
	 * @see #getInnerRadius()
	 * @generated
	 */
	void setInnerRadius(double value);

	/**
	 * Returns the value of the '<em><b>Radius</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The radius of the circle forming the outer edge of the tube.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Radius</em>' attribute.
	 * @see #setRadius(double)
	 * @see org.eclipse.january.geometry.GeometryPackage#getTube_Radius()
	 * @model default="0.0"
	 * @generated
	 */
	double getRadius();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.Tube#getRadius <em>Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Radius</em>' attribute.
	 * @see #getRadius()
	 * @generated
	 */
	void setRadius(double value);

} // Tube