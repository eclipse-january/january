/*******************************************************************************
 * Copyright (c) 2016 UT-Battelle, LLC. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     UT-Battelle, LLC. - initial API and implementation
 *******************************************************************************/
package org.eclipse.january.geometry.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.january.geometry.Geometry;
import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.january.geometry.INode;
import org.eclipse.january.geometry.STLGeometryImporter;
import org.eclipse.january.geometry.Shape;
import org.eclipse.january.geometry.Triangle;
import org.eclipse.january.geometry.Vertex;
import org.eclipse.january.geometry.model.STLStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>ASCIISTL Geometry Importer</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.impl.STLGeometryImporterImpl#getFileTypes <em>File Types</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.impl.STLGeometryImporterImpl#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public class STLGeometryImporterImpl extends MinimalEObjectImpl.Container
		implements STLGeometryImporter {
	/**
	 * The cached value of the '{@link #getFileTypes() <em>File Types</em>}' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFileTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<String> fileTypes;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected STLGeometryImporterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.STL_GEOMETRY_IMPORTER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getFileTypes() {
		if (fileTypes == null) {
			fileTypes = new EDataTypeUniqueEList<String>(String.class, this, GeometryPackage.STL_GEOMETRY_IMPORTER__FILE_TYPES);
		}
		return fileTypes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.STL_GEOMETRY_IMPORTER__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc --> Returns the geometry from the STL file given by
	 * the specified path <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Geometry load(Path path) {
		// Geometry to return
		Geometry geometry = null;

		Injector injector = new STLStandaloneSetup()
				.createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = injector
				.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL,
				Boolean.TRUE);
		Resource resource = resourceSet.getResource(
				URI.createFileURI(path.toFile().getAbsolutePath()), true);

		// Check to see if returned contents contain a valid geometry. If not,
		// then the file might be
		// a binary format

		// Get the contents of the resource
		EList<EObject> contents = resource.getContents();

		// If they contents are valid, get the first element
		if (contents != null && !contents.isEmpty()) {
			Geometry g = (Geometry) contents.get(0);

			// If the geometry has no nodes, or the shape has no triangles, try
			// loading from binary
			if (g.getNodes().isEmpty()
					|| ((Shape) g.getNodes().get(0)).getTriangles().isEmpty()) {
				geometry = loadBinary(path);
			} else {
				// Otherwise, return this geometry
				geometry = g;
			}
		}

		// Iterate through the returned nodes, replacing triangles with complex
		// triangles
		for (INode node : geometry.getNodes()) {

			// Get the nodes current triangles
			EList<Triangle> triangles = node.getTriangles();

			// The list of the new, complex triangles to assign to the node
			ArrayList<Triangle> newTriangles = new ArrayList<Triangle>();

			// The list of vertices in the mesh
			ArrayList<Vertex> vertices = new ArrayList<Vertex>();

			// COnvert each triangle into a complex triangle
			for (Triangle tri : triangles) {

				// The vertices for the current triangle
				ArrayList<Vertex> currVertices = new ArrayList<Vertex>();

				// Add each vertex to the list
				for (Vertex v : tri.getVertices()) {

					// If the vertex is unrecognized, clone it and add it to the
					// list
					if (!vertices.contains(v)) {
						Vertex clone = (Vertex) v.clone();
						vertices.add(clone);
						currVertices.add(clone);
					}

					// If it is already in the list, just get the reference to
					// it
					else {
						currVertices.add(vertices.get(vertices.indexOf(v)));
					}
				}

				// Create a new triangle and set its normal
				ComplexTriangle cTri = new ComplexTriangle(currVertices.get(0),
						currVertices.get(1), currVertices.get(2));
				cTri.getNormal().setX(tri.getNormal().getX());
				cTri.getNormal().setY(tri.getNormal().getY());
				cTri.getNormal().setZ(tri.getNormal().getZ());

				// Register to listen for changes in the triangle
				cTri.eAdapters().add(new AdapterImpl() {

					@Override
					public void notifyChanged(Notification notification) {

						// Simply pass the notification along to the node's
						// listeners
						node.eNotify(notification);
					}

				});

				newTriangles.add(cTri);
			}

			// Empty the list of old triangles
			node.getTriangles().clear();

			// Add the new triangles to the list
			for (Triangle tri : newTriangles) {
				node.getTriangles().add(tri);
			}
		}

		// Return the geometry
		return geometry;
	}

	/**
	 * Loads a binary STL file from the given path into a geometry instance.
	 * 
	 * @param path
	 *            The path to read the file from
	 * @return Returns the geometry given from the binary file
	 * @generated NOT
	 */
	private Geometry loadBinary(Path path) {
		// Create a new geometry and add the new shape
		Geometry geometry = GeometryFactory.eINSTANCE.createGeometry();
		geometry.setName(path.getFileName().toString());
		Shape shape = GeometryFactory.eINSTANCE.createShape();
		geometry.getNodes().add(shape);

		// Can throw IO exceptions
		try {
			// Read in the file's bytes, convert to buffer
			byte[] fileBytes = Files.readAllBytes(path);
			ByteBuffer buffer = ByteBuffer.wrap(fileBytes, 80,
					fileBytes.length - 80);
			buffer.order(ByteOrder.LITTLE_ENDIAN);

			// Get the number of triangles
			int triNum = buffer.getInt();

			// Read in all the triangles
			for (int i = 0; i < triNum; i++) {

				// Create a triangle
				Triangle triangle = GeometryFactory.eINSTANCE.createTriangle();

				// Create a normal for the triangle
				Vertex normal = GeometryFactory.eINSTANCE.createVertex();
				normal.setX(buffer.getFloat());
				normal.setY(buffer.getFloat());
				normal.setZ(buffer.getFloat());

				triangle.setNormal(normal);

				// Create the triangle vertices
				for (int j = 0; j < 3; j++) {
					Vertex vertex = GeometryFactory.eINSTANCE.createVertex();
					vertex.setX(buffer.getFloat());
					vertex.setY(buffer.getFloat());
					vertex.setZ(buffer.getFloat());

					triangle.getVertices().add(vertex);
				}

				// Not used- sometimes gives color information or texture info
				int attributeByteCount = buffer.getShort();

				// Add this triangle to the list
				shape.getTriangles().add(triangle);

			}
		} catch (IOException e) {
			// Put default error data in

		}

		// Return the triangles array list
		return geometry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeometryPackage.STL_GEOMETRY_IMPORTER__FILE_TYPES:
				return getFileTypes();
			case GeometryPackage.STL_GEOMETRY_IMPORTER__DESCRIPTION:
				return getDescription();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GeometryPackage.STL_GEOMETRY_IMPORTER__FILE_TYPES:
				getFileTypes().clear();
				getFileTypes().addAll((Collection<? extends String>)newValue);
				return;
			case GeometryPackage.STL_GEOMETRY_IMPORTER__DESCRIPTION:
				setDescription((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GeometryPackage.STL_GEOMETRY_IMPORTER__FILE_TYPES:
				getFileTypes().clear();
				return;
			case GeometryPackage.STL_GEOMETRY_IMPORTER__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GeometryPackage.STL_GEOMETRY_IMPORTER__FILE_TYPES:
				return fileTypes != null && !fileTypes.isEmpty();
			case GeometryPackage.STL_GEOMETRY_IMPORTER__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID) {
			case GeometryPackage.STL_GEOMETRY_IMPORTER___LOAD__PATH:
				return load((Path)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (fileTypes: ");
		result.append(fileTypes);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} // ASCIISTLGeometryImporterImpl