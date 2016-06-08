/**
 */
package geometry;


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
 * </p>
 * <ul>
 * </ul>
 *
 * @see geometry.GeometryPackage#getTube()
 * @model features="height innerRadius radius" 
 *        heightDefault="0.0" heightDataType="org.eclipse.emf.ecore.EDouble" heightSuppressedGetVisibility="true" heightSuppressedSetVisibility="true"
 *        innerRadiusDefault="0.0" innerRadiusDataType="org.eclipse.emf.ecore.EDouble" innerRadiusSuppressedGetVisibility="true" innerRadiusSuppressedSetVisibility="true"
 *        radiusDefault="0.0" radiusDataType="org.eclipse.emf.ecore.EDouble" radiusSuppressedGetVisibility="true" radiusSuppressedSetVisibility="true"
 * @generated
 */
public interface Tube extends Shape {
} // Tube
