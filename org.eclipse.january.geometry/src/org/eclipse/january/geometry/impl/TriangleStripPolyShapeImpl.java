/**
 */
package org.eclipse.january.geometry.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.january.geometry.Face;
import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.january.geometry.TriangleStripPolyShape;
import org.eclipse.january.geometry.Vertex;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Triangle Strip Poly Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class TriangleStripPolyShapeImpl extends PolyShapeImpl implements TriangleStripPolyShape {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TriangleStripPolyShapeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.TRIANGLE_STRIP_POLY_SHAPE;
	}
	
	/**
	 * Calculates the triangles from the faces given
	 * 
	 * @generated NOT
	 */
	@Override
	public void calculatePolyTriangles() {
		if (getMaterial() != null) {
			getMaterial().getMaterialFiles()
					.addAll(getVertexSource().getMaterialFiles());
		}
		
		//Check whether indices are specified in 0 or 1 indexing
		boolean oneIndexing = true;
		
		for(Face face : getFaces()){
			if(face.getVertexIndices().contains(0)){
				oneIndexing = false;
				break;
			}
		}
		
		for (Face face : getFaces()) {
			EList<Integer> indices = face.getVertexIndices();
			if (indices.size() > 2) {
				for (int i = 0; i < indices.size() - 2; i++) {
					
					//Get the indices into the vertex array
					int index1 = indices.get(i);
					int index2 = indices.get(i + 1);
					int index3 = indices.get(i + 2);
					
					//If the indices are in one indexing, convert to zero indexing
					if(oneIndexing){
						index1--;
						index2--;
						index3--;
					}
					
					Vertex v1 = getVertexSource().getVertices()
							.get(index1);
					Vertex v2 = getVertexSource().getVertices()
							.get(index2);
					Vertex v3 = getVertexSource().getVertices()
							.get(index3);
					ComplexTriangle tri = new ComplexTriangle(v1, v2, v3);

					// Listen to the triangle, passing along any notifications.
					tri.eAdapters().add(new AdapterImpl() {

						@Override
						public void notifyChanged(Notification notification) {
							eNotify(notification);
						}

					});
					getTriangles().add(tri);
				}
			} else {
				// Throw an exception- file is not properly specified
			}
		}
	}

} //TriangleStripPolyShapeImpl
