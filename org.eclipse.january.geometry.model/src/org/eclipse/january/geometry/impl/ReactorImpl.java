/**
 */
package org.eclipse.january.geometry.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.eavp.viz.modeling.base.IController;
import org.eclipse.eavp.viz.service.geometry.reactor.Extrema;
import org.eclipse.eavp.viz.service.geometry.reactor.PipeController;
import org.eclipse.eavp.viz.service.geometry.reactor.ReactorMeshProperty;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.january.geometry.BoundingBox;
import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.january.geometry.Pipe;
import org.eclipse.january.geometry.Reactor;
import org.eclipse.january.geometry.Triangle;
import org.eclipse.january.geometry.Vertex;
import org.eclipse.january.geometry.util.MeshUtils;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Reactor</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.january.geometry.impl.ReactorImpl#getPipes
 * <em>Pipes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReactorImpl extends ShapeImpl implements Reactor {
	/**
	 * The cached value of the '{@link #getPipes() <em>Pipes</em>}' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPipes()
	 * @generated
	 * @ordered
	 */
	protected EList<Pipe> pipes;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ReactorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.REACTOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<Pipe> getPipes() {
		if (pipes == null) {
			pipes = new EObjectContainmentEList<Pipe>(Pipe.class, this,
					GeometryPackage.REACTOR__PIPES);
		}
		return pipes;
	}

	@Override
	public EList<Triangle> getTriangles(){

		triangles.clear();
		
		if(pipes.isEmpty()){
			return triangles;
		}
	
		// The bounds of the rectangle defining the capsule's shape
		BoundingBox bounds = pipes.get(0).getLowerEdge();

		// Check all the reactor's children for core channels, adding them to the bounds
		for (Pipe channel : pipes) {
			bounds.addArea(channel.getLowerEdge());
			bounds.addArea(channel.getUpperEdge());
		}

		// How thick the mesh will be
		double thickness = 5;

		// The number of samples to be used in the creation of the circular
		// portion of the mesh
		int samples = 50;

		// The dimensions of the mesh
		double width;
		double height;
		double depth;

		// The literal sizes in each dimension
		double sizeX = bounds.getMaxX() - bounds.getMinX();
		double sizeY = bounds.getMaxY() - bounds.getMinY();
		double sizeZ = bounds.getMaxZ() - bounds.getMinZ();

		// Sort the sizes
		ArrayList<Double> sizes = new ArrayList<Double>();
		sizes.add(sizeX);
		sizes.add(sizeY);
		sizes.add(sizeZ);
		Collections.sort(sizes);

		// The greatest size will be the distance from curved side to curved
		// side, the middle size will the the distance between the two straight
		// sides, and the smallest size will be the object's depth
		depth = sizes.get(0);
		width = sizes.get(1);
		height = sizes.get(2);

		// Widen the reactor so that the inner wall is touching the bounds of
		// the core channels, saving the original width for later comparisons
		double origWidth = width;
		width = width + thickness;

		// Create the two straight sides
		double[] sideVertices = MeshUtils.createRectangularPrism(thickness, height, depth);
		Vertex sideCenter1 = GeometryFactory.eINSTANCE.createVertex();
		sideCenter1.setX(width / 2);
		double[] sideVertices1 = MeshUtils.centerPoints(sideVertices, sideCenter1);
		Vertex sideCenter2 = GeometryFactory.eINSTANCE.createVertex();
		sideCenter2.setX(width / -2);

		// Get the vertices of the semicircular edges
		double[] innerVertices = MeshUtils.createSemiCircle(
				width / 2 - thickness / 2, samples, true);
		double[] outerVertices = MeshUtils.createSemiCircle(
				width / 2 + thickness / 2, samples, true);

		// The number of coordinates on one side of the circular mesh
		int blockSize = samples * 2 * 3;

		// A list of all coordinates in the mesh in the format of the first
		// vertex's x, y, and z coordinates, the second vertex's x, y, and z
		// coordinates, etc
		double[] coordinates = new double[blockSize * 2];

		// At each sample point, create the four vertices defining a
		// rectangular slice of the semicircle
		for (int i = 0; i < samples; i++) {

			// The bottom inner vertex
			coordinates[i * 6] = innerVertices[i * 2];
			coordinates[i * 6 + 1] = innerVertices[i * 2 + 1];
			coordinates[i * 6 + 2] = (float) (depth / -2);

			// The top inner vertex
			coordinates[i * 6 + 3] = innerVertices[i * 2];
			coordinates[i * 6 + 4] = innerVertices[i * 2 + 1];
			coordinates[i * 6 + 5] = (float) (depth / 2);

			// The bottom outer vertex
			coordinates[blockSize + i * 6] = outerVertices[i * 2];
			coordinates[blockSize + i * 6 + 1] = outerVertices[i * 2 + 1];
			coordinates[blockSize + i * 6 + 2] = (float) (depth / -2);

			// The top outer vertex
			coordinates[blockSize + i * 6 + 3] = outerVertices[i * 2];
			coordinates[blockSize + i * 6 + 4] = outerVertices[i * 2 + 1];
			coordinates[blockSize + i * 6 + 5] = (float) (depth / 2);
		}

		//A list of the vertices in the shape
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		
		//Convert the coordinates into vertices
		for(int i = 0; i < coordinates.length / 3; i++){
			
			//Create a new vertex
			Vertex vertex = GeometryFactory.eINSTANCE.createVertex();
			
			//Set the vertex's coordinates 
			vertex.setX(coordinates[i * 3]);
			vertex.setY(coordinates[i * 3 + 1]);
			vertex.setZ(coordinates[i * 3 + 2]);
			
			vertices.add(vertex);
		}

		// The number of faces on one side of the mesh
		int faceBlockSize = samples * 2;

		// Half the total number of faces
		int halfFaces = samples * 4;

		// At each vertex, construct two faces
		for (int i = 0; i < halfFaces - 2; i++) {

			// Ignore the last two vertices on the first edge of the mesh, there
			// are no more faces to make past them
			if (i < faceBlockSize - 2 || i >= faceBlockSize) {

				Triangle triangle = GeometryFactory.eINSTANCE.createTriangle();
				
				if (i < faceBlockSize - 2) {
					// Create a face along the side of the mesh
					faces[i * 6] = i % 2 != 0 ? i + 2 : i;
					
					faces[i * 6] i % 2 != 0 ? i + 2 : i;

					// Set all texture coordinates to zero
					faces[i * 6 + 1] = 0;
					faces[i * 6 + 2] = i + 1;
					faces[i * 6 + 3] = 0;
					faces[i * 6 + 4] = i % 2 == 0 ? i + 2 : i;
					faces[i * 6 + 5] = 0;
				}

				else {
					// Create a face along the side of the mesh
					faces[i * 6] = i % 2 == 0 ? i + 2 : i;

					// Set all texture coordinates to zero
					faces[i * 6 + 1] = 0;
					faces[i * 6 + 2] = i + 1;
					faces[i * 6 + 3] = 0;
					faces[i * 6 + 4] = i % 2 != 0 ? i + 2 : i;
					faces[i * 6 + 5] = 0;
				}

				// Create a face along the top/bottom of the mesh, with two
				// vertices on this vertex's side and one on the opposite side
				if (i < faceBlockSize) {

					faces[(halfFaces + i) * 6] = i % 2 == 0 ? i
							: i + faceBlockSize + 2;
					faces[(halfFaces + i) * 6 + 1] = 0;
					faces[(halfFaces + i) * 6 + 2] = i + 2;
					faces[(halfFaces + i) * 6 + 3] = 0;
					faces[(halfFaces + i) * 6 + 4] = i % 2 != 0 ? i
							: i + faceBlockSize + 2;
					faces[(halfFaces + i) * 6 + 5] = 0;
				}

				else {
					faces[(halfFaces + i) * 6] = i % 2 != 0 ? i
							: i + 2 - faceBlockSize - 2;
					faces[(halfFaces + i) * 6 + 1] = 0;
					faces[(halfFaces + i) * 6 + 2] = i + 2;
					faces[(halfFaces + i) * 6 + 3] = 0;
					faces[(halfFaces + i) * 6 + 4] = i % 2 == 0 ? i
							: i + 2 - faceBlockSize - 2;
					faces[(halfFaces + i) * 6 + 5] = 0;

				}
			}
		}

		// Add the faces to the mesh
		mesh.getFaces().addAll(faces);
		mesh.getFaceSmoothingGroups().addAll(smoothingGroups);

		// Create the top arch from the mesh
		upperArch = new MeshView(mesh);
		upperArch.setMaterial(material);
		upperArch.setTranslateY(height / 2);
		reactorNode.getChildren().add(upperArch);

		// Create the bottom arch by rotating the top one 180 degrees about the
		// axis
		lowerArch = new MeshView(mesh);
		lowerArch.setMaterial(material);
		lowerArch.setRotate(180d);
		lowerArch.setTranslateY(-height / 2 - width / 2 - thickness / 2);
		reactorNode.getChildren().add(lowerArch);

		// Rotate the mesh such that its height is pointing in its longest
		// direction and its hole is pointing along its shortest distance
		// Rotate on the z axis if the X is the height or Z is the height and
		// Y is the width
		if ((sizeX > sizeY && sizeX > sizeZ)
				|| (sizeZ > sizeY && sizeY > sizeX)) {
			Rotate temp = new Rotate();
			temp.setAxis(Rotate.Z_AXIS);
			temp.setAngle(90);
			reactorNode.getTransforms().add(temp);
		}

		// If z is the highest dimension, rotate on the x axis
		if (sizeY != height && sizeX != height && sizeZ == height) {
			Rotate temp = new Rotate();
			temp.setAxis(Rotate.X_AXIS);
			temp.setAngle(90);
			reactorNode.getTransforms().add(temp);
		}

		// If z is the widest dimension, rotate on the y axis
		else if (sizeY != origWidth && sizeX != origWidth
				&& sizeZ == origWidth) {
			Rotate temp = new Rotate();
			temp.setAxis(Rotate.Y_AXIS);
			temp.setAngle(90);
			reactorNode.getTransforms().add(temp);
		}

		// Move the reactor to surround the region
		reactorNode.setTranslateX(
				(bounds.getMaxX() - bounds.getMinX()) / 2 + bounds.getMinX());
		reactorNode.setTranslateY(
				(bounds.getMaxY() - bounds.getMinY()) / 2 + bounds.getMinY());
		reactorNode.setTranslateZ(
				(bounds.getMaxZ() - bounds.getMinZ()) / 2 + bounds.getMinZ());

		// Set the shapes to the correct rendering mode
		setWireframeMode(wireframe);
		setTransparentMode(transparent);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case GeometryPackage.REACTOR__PIPES:
			return ((InternalEList<?>) getPipes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case GeometryPackage.REACTOR__PIPES:
			return getPipes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case GeometryPackage.REACTOR__PIPES:
			getPipes().clear();
			getPipes().addAll((Collection<? extends Pipe>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case GeometryPackage.REACTOR__PIPES:
			getPipes().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case GeometryPackage.REACTOR__PIPES:
			return pipes != null && !pipes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ReactorImpl
