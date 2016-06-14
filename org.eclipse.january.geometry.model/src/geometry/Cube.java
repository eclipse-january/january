/**
 */
package geometry;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cube</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A cube, or perfect box, is a three dimensional shape composed of six faces that are perpendicular to each other. Each face is composed of four vertices that are connected by edges that are perpendicular to each other. The total number of vertices in the box is eight with each vertex being shared by three edges and three sides. The distance from the center of the cube to each vertex is constant. The length of any side of the box is constant.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link geometry.Cube#getSideLength <em>Side Length</em>}</li>
 * </ul>
 *
 * @see geometry.GeometryPackage#getCube()
 * @model
 * @generated
 */
public interface Cube extends Shape {

	/**
	 * Returns the value of the '<em><b>Side Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The length of any side of the box.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Side Length</em>' attribute.
	 * @see #setSideLength(double)
	 * @see geometry.GeometryPackage#getCube_SideLength()
	 * @model
	 * @generated
	 */
	double getSideLength();

	/**
	 * Sets the value of the '{@link geometry.Cube#getSideLength <em>Side Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Side Length</em>' attribute.
	 * @see #getSideLength()
	 * @generated
	 */
	void setSideLength(double value);

} // Cube
