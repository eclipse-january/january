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
/**
 */
package org.eclipse.january.geometry.tests;

import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.eclipse.emf.common.util.EList;
import org.eclipse.january.geometry.Geometry;
import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.STLGeometryImporter;
import org.eclipse.january.geometry.Shape;
import org.eclipse.january.geometry.Triangle;
import org.eclipse.january.geometry.Vertex;

import junit.framework.TestCase;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>STL Geometry Importer</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.IGeometryImporter#load(java.nio.file.Path) <em>Load</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class STLGeometryImporterTest extends TestCase {

	/**
	 * The margin of tolerance between the expected values and those read by the
	 * importer when comparing double values.
	 * 
	 * @generated NOT
	 */
	private final double PARSE_ERROR = 0.0;

	/**
	 * The fixture for this STL Geometry Importer test case.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected STLGeometryImporter fixture = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(STLGeometryImporterTest.class);
	}

	/**
	 * Constructs a new STL Geometry Importer test case with the given name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public STLGeometryImporterTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this STL Geometry Importer test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void setFixture(STLGeometryImporter fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this STL Geometry Importer test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected STLGeometryImporter getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GeometryFactory.eINSTANCE.createSTLGeometryImporter());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link geometry.IGeometryImporter#load(java.nio.file.Path)
	 * <em>Load</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see geometry.IGeometryImporter#load(java.nio.file.Path)
	 * @generated NOT
	 */
	public void testLoad__Path() {
		Path asciiSTL = FileSystems.getDefault().getPath("src", "geometry",
				"tests", "files", "cube.stl");
		Geometry stlGeom = fixture.load(asciiSTL);

		testGeometry(stlGeom);

		Path binarySTL = FileSystems.getDefault().getPath("src", "geometry",
				"tests", "files", "binaryExample.stl");

		Geometry binaryStlGeom = fixture.load(binarySTL);

		testGeometry(binaryStlGeom);

	}

	/**
	 * Tests the given geometry against the data in the files cube.stl and
	 * binaryExample.stl
	 * 
	 * @param g
	 *            The geometry to test
	 * @generated NOT
	 */
	private void testGeometry(Geometry g) {
		// Make sure it successfully loaded the shape
		assertNotNull(g.getNodes());
		assertEquals(1, g.getNodes().size());

		// Get the shape
		Shape shape = (Shape) g.getNodes().get(0);

		// Make sure it imports the triangles successfully
		assertNotNull(shape.getTriangles());
		assertEquals(12, shape.getTriangles().size());

		// Get the triangle list
		EList<Triangle> triangles = shape.getTriangles();

		// Test the first triangle
		Triangle t1 = triangles.get(0);
		testVertex(t1.getNormal(), 0.0, 0.0, 1.0);

		// Test the vertices
		assertEquals(3, t1.getVertices().size());
		Vertex v11 = t1.getVertices().get(0);
		testVertex(v11, 5.0, 5.0, 5.0);
		Vertex v12 = t1.getVertices().get(1);
		testVertex(v12, -5.0, 5.0, 5.0);
		Vertex v13 = t1.getVertices().get(2);
		testVertex(v13, 5.0, -5.0, 5.0);

		// Test the second triangle
		Triangle t2 = triangles.get(1);
		testVertex(t2.getNormal(), 0.0, 0.0, 1.0);
		assertEquals(3, t2.getVertices().size());
		Vertex v21 = t2.getVertices().get(0);
		testVertex(v21, 5.0, -5.0, 5.0);
		Vertex v22 = t2.getVertices().get(1);
		testVertex(v22, -5.0, 5.0, 5.0);
		Vertex v23 = t2.getVertices().get(2);
		testVertex(v23, -5.0, -5.0, 5.0);

		// Test the third triangle
		Triangle t3 = triangles.get(2);
		testVertex(t3.getNormal(), 0.0, 0.0, -1.0);
		assertEquals(3, t3.getVertices().size());
		Vertex v31 = t3.getVertices().get(0);
		testVertex(v31, 5.0, -5.0, -5.0);
		Vertex v32 = t3.getVertices().get(1);
		testVertex(v32, -5.0, -5.0, -5.0);
		Vertex v33 = t3.getVertices().get(2);
		testVertex(v33, 5.0, 5.0, -5.0);

		// Test the fourth triangle
		Triangle t4 = triangles.get(3);
		testVertex(t4.getNormal(), 0.0, 0.0, -1.0);
		assertEquals(3, t4.getVertices().size());
		Vertex v41 = t4.getVertices().get(0);
		testVertex(v41, 5.0, 5.0, -5.0);
		Vertex v42 = t4.getVertices().get(1);
		testVertex(v42, -5.0, -5.0, -5.0);
		Vertex v43 = t4.getVertices().get(2);
		testVertex(v43, -5.0, 5.0, -5.0);

		// Test the fifth triangle
		Triangle t5 = triangles.get(4);
		testVertex(t5.getNormal(), 0.0, -1.0, 0.0);
		assertEquals(3, t5.getVertices().size());
		Vertex v51 = t5.getVertices().get(0);
		testVertex(v51, -5.0, -5.0, 5.0);
		Vertex v52 = t5.getVertices().get(1);
		testVertex(v52, -5.0, -5.0, -5.0);
		Vertex v53 = t5.getVertices().get(2);
		testVertex(v53, 5.0, -5.0, 5.0);

		// Test the last triangle
		Triangle t12 = triangles.get(11);
		testVertex(t12.getNormal(), 1.0, 0.0, 0.0);

		assertEquals(3, t12.getVertices().size());
		Vertex v121 = t12.getVertices().get(0);
		testVertex(v121, 5.0, 5.0, 5.0);
		Vertex v122 = t12.getVertices().get(1);
		testVertex(v122, 5.0, -5.0, -5.0);
		Vertex v123 = t12.getVertices().get(2);
		testVertex(v123, 5.0, 5.0, -5.0);

	}

	/**
	 * Tests the given vertex for the x, y, and z value it should have
	 * 
	 * @param v
	 *            The vertex to test
	 * @param x
	 *            The x value to test against
	 * @param y
	 *            The y value to test against
	 * @param z
	 *            The z value to test against
	 */
	private void testVertex(Vertex v, double x, double y, double z) {
		assertEquals(x, v.getX(), PARSE_ERROR);
		assertEquals(y, v.getY(), PARSE_ERROR);
		assertEquals(z, v.getZ(), PARSE_ERROR);
	}

} // STLGeometryImporterTest
