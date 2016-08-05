/**
 */
package org.eclipse.january.geometry.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
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

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Reactor</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.january.geometry.impl.ReactorImpl#getPipes
 * <em>Pipes</em>}</li>
 * </ul>
 * </p>
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.january.geometry.impl.ShapeImpl#getTriangles()
	 * 
	 * @generated NOT
	 */
	@Override
	public EList<Triangle> getTriangles() {

		// Clear the current list of triangles
		triangles = new BasicEList<Triangle>();

		// If there are no pipes, there is no reactor to draw
		if (getPipes().isEmpty()) {
			return triangles;
		}

		// The bounds of the rectangle defining the capsule's shape
		BoundingBox bounds = pipes.get(0).getLowerEdge();

		// Check all the reactor's children for core channels, adding them to
		// the bounds
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
		double[] sideVertices = MeshUtils.createRectangularPrism(thickness,
				height, depth);
		Vertex sideCenter1 = GeometryFactory.eINSTANCE.createVertex();
		sideCenter1.setX(width / 2);
		double[] sideVerticesLeft = MeshUtils.centerPoints(sideVertices,
				sideCenter1);
		Vertex sideCenter2 = GeometryFactory.eINSTANCE.createVertex();
		sideCenter2.setX(width / -2);
		double[] sideVerticesRight = MeshUtils.centerPoints(sideVertices,
				sideCenter2);

		// Get the vertices of the semicircular edges
		double[] innerVertices = MeshUtils
				.createSemiCircle(width / 2 - thickness / 2, samples, true);
		double[] outerVertices = MeshUtils
				.createSemiCircle(width / 2 + thickness / 2, samples, true);

		// The number of coordinates on one side of the circular mesh
		int blockSize = samples * 2 * 3;

		// The number of vertices in one of the reactor's two arch sides
		int archSize = blockSize * 2 / 3;

		// A list of all coordinates in the mesh in the format of the first
		// vertex's x, y, and z coordinates, the second vertex's x, y, and z
		// coordinates, etc
		double[] coordinates = new double[archSize * 2 * 3];

		// At each sample point, create the four vertices defining a
		// rectangular slice of the semicircle
		for (int i = 0; i < samples; i++) {

			// The bottom inner vertex
			coordinates[i * 6] = innerVertices[i * 2];
			coordinates[i * 6 + 1] = innerVertices[i * 2 + 1] + height / 2;
			coordinates[i * 6 + 2] = (float) (depth / -2);

			// The top inner vertex
			coordinates[i * 6 + 3] = innerVertices[i * 2];
			coordinates[i * 6 + 4] = innerVertices[i * 2 + 1] + height / 2;
			coordinates[i * 6 + 5] = (float) (depth / 2);

			// The bottom outer vertex
			coordinates[blockSize + i * 6] = outerVertices[i * 2];
			coordinates[blockSize + i * 6 + 1] = outerVertices[i * 2 + 1]
					+ height / 2;
			coordinates[blockSize + i * 6 + 2] = (float) (depth / -2);

			// The top outer vertex
			coordinates[blockSize + i * 6 + 3] = outerVertices[i * 2];
			coordinates[blockSize + i * 6 + 4] = outerVertices[i * 2 + 1]
					+ height / 2;
			coordinates[blockSize + i * 6 + 5] = (float) (depth / 2);
		}

		// Create the bottom arch by reflecting each vertex in the top arch
		for (int i = 0; i < coordinates.length / 2; i++) {

			if (i % 3 != 1) {
				coordinates[archSize * 3 + i] = coordinates[i];
			} else {
				coordinates[archSize * 3 + i] = -coordinates[i];
			}
		}

		// The amounts of rotation required about the three axes, in radians
		double xRotation = 0;
		double yRotation = 0;
		double zRotation = 0;

		// Rotate the mesh such that its height is pointing in its longest
		// direction and its hole is pointing along its shortest distance
		// Rotate on the z axis if the X is the height or Z is the height and
		// Y is the width
		if ((sizeX > sizeY && sizeX > sizeZ)
				|| (sizeZ > sizeY && sizeY > sizeX)) {
			zRotation = Math.PI / 2;
		}

		// If z is the highest dimension, rotate on the x axis
		if (sizeY != height && sizeX != height && sizeZ == height) {
			xRotation = Math.PI / 2;
		}

		// If z is the widest dimension, rotate on the y axis
		else if (sizeY != origWidth && sizeX != origWidth
				&& sizeZ == origWidth) {
			yRotation = Math.PI / 2;
		}

		// Apply the rotations to the coordinates
		sideVerticesLeft = MeshUtils.rotatePoints(sideVerticesLeft, xRotation,
				yRotation, zRotation);
		sideVerticesRight = MeshUtils.rotatePoints(sideVerticesRight, xRotation,
				yRotation, zRotation);
		coordinates = MeshUtils.rotatePoints(coordinates, xRotation, yRotation,
				zRotation);

		// Add the straight sides' triangles to the mesh
		triangles
				.addAll(MeshUtils.createRectangularPrismMesh(sideVerticesLeft));
		triangles.addAll(
				MeshUtils.createRectangularPrismMesh(sideVerticesRight));

		// A list of the vertices in the shape
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();

		// Convert the coordinates into vertices
		for (int i = 0; i < coordinates.length / 3; i++) {

			// Create a new vertex
			Vertex vertex = GeometryFactory.eINSTANCE.createVertex();

			// Set the vertex's coordinates, increasing Y they will be at the
			// correct height for the top arch
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

			// The indices into the vertex array for each triangle
			int[] indices = new int[3];

			// Ignore the last two vertices on the first edge of the mesh, there
			// are no more faces to make past them
			if (i < faceBlockSize - 2 || i >= faceBlockSize) {

				// For faces in the first half of the list, have them facing
				// inward according to the right hand rule.
				if (i < faceBlockSize - 2) {
					// Create a face along the side of the mesh
					Triangle top = GeometryFactory.eINSTANCE.createTriangle();
					Triangle bottom = GeometryFactory.eINSTANCE
							.createTriangle();

					if (i % 2 != 0) {
						indices[0] = i + 2;
					} else {
						indices[0] = i;
					}

					indices[1] = i + 1;

					if (i % 2 == 0) {
						indices[2] = i + 2;
					} else {
						indices[2] = i;
					}

					// Add the vertices from the first half to the top triangle
					// and the vertices from the second half to the bottom
					for (int j : indices) {
						top.getVertices().add((Vertex) vertices.get(j).clone());
						bottom.getVertices().add(
								(Vertex) vertices.get(archSize + j).clone());
					}

					// Add both triangles to the list
					triangles.add(top);
					triangles.add(bottom);
				}

				// For faces in the second half of the list, have them facing
				// outward according to the right hand rule
				else {

					// Create a face along the side of the mesh
					Triangle top = GeometryFactory.eINSTANCE.createTriangle();
					Triangle bottom = GeometryFactory.eINSTANCE
							.createTriangle();

					if (i % 2 == 0) {
						indices[0] = i;
					} else {
						indices[0] = i + 2;
					}

					indices[1] = i + 1;

					if (i % 2 != 0) {
						indices[2] = i;
					} else {
						indices[2] = i + 2;
					}

					// Add the vertices from the first half to the top triangle
					// and the vertices from the second half to the bottom
					for (int j : indices) {
						top.getVertices().add((Vertex) vertices.get(j).clone());
						bottom.getVertices().add(
								(Vertex) vertices.get(archSize + j).clone());
					}

					// Add both triangles to the list
					triangles.add(top);
					triangles.add(bottom);
				}

				// Create a face along the top/bottom of the mesh, with two
				// vertices on this vertex's side and one on the opposite side
				if (i < faceBlockSize) {

					// Create a face along the side of the mesh
					Triangle top = GeometryFactory.eINSTANCE.createTriangle();
					Triangle bottom = GeometryFactory.eINSTANCE
							.createTriangle();

					if (i % 2 == 0) {
						indices[0] = i;
					} else {
						indices[0] = i + faceBlockSize + 2;
					}

					indices[1] = i + 2;

					if (i % 2 != 0) {
						indices[2] = i;
					} else {
						indices[2] = i + faceBlockSize + 2;
					}

					// Add the vertices from the first half to the top triangle
					// and the vertices from the second half to the bottom
					for (int j : indices) {
						top.getVertices().add((Vertex) vertices.get(j).clone());
						bottom.getVertices().add(
								(Vertex) vertices.get(archSize + j).clone());
					}

					// Add both triangles to the list
					triangles.add(top);
					triangles.add(bottom);
				}

				else {

					// Create a face along the side of the mesh
					Triangle top = GeometryFactory.eINSTANCE.createTriangle();
					Triangle bottom = GeometryFactory.eINSTANCE
							.createTriangle();

					if (i % 2 != 0) {
						indices[0] = i;
					} else {
						indices[0] = i - faceBlockSize;
					}

					indices[1] = i + 2;

					if (i % 2 == 0) {
						indices[2] = i;
					} else {
						indices[2] = i - faceBlockSize;
					}

					// Add the vertices from the first half to the top triangle
					// and the vertices from the second half to the bottom
					for (int j : indices) {
						top.getVertices().add((Vertex) vertices.get(j).clone());
						bottom.getVertices().add(
								(Vertex) vertices.get(archSize + j).clone());
					}

					// Add both triangles to the list
					triangles.add(top);
					triangles.add(bottom);
				}
			}
		}

		// Move the reactor to surround the region
		center.setX(
				(bounds.getMaxX() - bounds.getMinX()) / 2 + bounds.getMinX());
		center.setY(
				(bounds.getMaxY() - bounds.getMinY()) / 2 + bounds.getMinY());
		center.setZ(
				(bounds.getMaxZ() - bounds.getMinZ()) / 2 + bounds.getMinZ());

		return triangles;
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

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Object clone() {

		// Create a new reactor
		Reactor clone = GeometryFactory.eINSTANCE.createReactor();

		// Make it a copy of this
		clone.copy(this);
		return clone;
	}

} // ReactorImpl
