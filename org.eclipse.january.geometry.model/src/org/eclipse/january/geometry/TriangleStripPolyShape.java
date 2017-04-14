/**
 */
package org.eclipse.january.geometry;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Triangle Strip Poly Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A PolyShape in which the mesh is specified according to a triangle strip format. This means that instead of specifying faces by vertices around the edge, each three consecutive vertices will form a triangle, with each vertex but those at the ends being a vertex for three triangles.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.january.geometry.GeometryPackage#getTriangleStripPolyShape()
 * @model
 * @generated
 */
public interface TriangleStripPolyShape extends PolyShape {
} // TriangleStripPolyShape
