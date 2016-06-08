/**
 */
package geometry;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cylinder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A cylinder is a shape formed by a surface whose points are equidistant from a central axis. The shortest distance from a point on the surface to the central axis is the radius of the cylinder. The length of the central axis is defined as as the height of the cylinder. The center of the cylinder lies exactly in the middle of the central axis.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link geometry.Cylinder#getRadius <em>Radius</em>}</li>
 * </ul>
 *
 * @see geometry.GeometryPackage#getCylinder()
 * @model features="height" 
 *        heightDataType="org.eclipse.emf.ecore.EDouble" heightSuppressedGetVisibility="true"
 *        heightAnnotation="http://www.eclipse.org/emf/2002/GenModel supressedSetVisibility='true'"
 * @generated
 */
public interface Cylinder extends Shape {
	/**
	 * Returns the value of the '<em><b>Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The radius is the shortest distance from a point on the surface of the cylinder to the central axis. It is constant across the entire cylinder.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Radius</em>' attribute.
	 * @see #setRadius(double)
	 * @see geometry.GeometryPackage#getCylinder_Radius()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel supressedGetVisibility='true' supressedSetVisibility='true'"
	 * @generated
	 */
	double getRadius();

	/**
	 * Sets the value of the '{@link geometry.Cylinder#getRadius <em>Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Radius</em>' attribute.
	 * @see #getRadius()
	 * @generated
	 */
	void setRadius(double value);

	/**
	 * Sets the value of the '{@link geometry.Cylinder#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(double value);

} // Cylinder
