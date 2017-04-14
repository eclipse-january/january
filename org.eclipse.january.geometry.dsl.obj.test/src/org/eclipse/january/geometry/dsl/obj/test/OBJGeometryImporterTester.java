/*******************************************************************************
 * Copyright (c) 2014 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - Kasper
 *   Gammeltoft
 *******************************************************************************/
package org.eclipse.january.geometry.dsl.obj.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.eclipse.emf.common.util.EList;
import org.eclipse.january.geometry.Face;
import org.eclipse.january.geometry.Geometry;
import org.eclipse.january.geometry.INode;
import org.eclipse.january.geometry.PolyShape;
import org.eclipse.january.geometry.Vertex;
import org.eclipse.january.geometry.VertexSource;
import org.eclipse.january.geometry.dsl.obj.importer.OBJGeometryImporter;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the functionality of the obj file importer.
 * 
 * @author Kasper Gammeltoft
 *
 */
public class OBJGeometryImporterTester {

	/**
	 * The margin of tolerance between the expected values and those read by the
	 * importer when comparing double values.
	 * 
	 */
	private final double PARSE_ERROR = 0.0;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {

		OBJGeometryImporter importer = new OBJGeometryImporter();

		Path testFile = FileSystems.getDefault().getPath("src", "org",
				"eclipse", "january", "geometry", "xtext", "obj", "test",
				"files", "test.obj");

		Geometry testGeom = importer.load(testFile);

		testOBJ1(testGeom);
	}

	private void testOBJ1(Geometry geom) {
		// Basic checks, making sure things are initialized
		assertNotNull(geom);
		assertNotNull(geom.getNodes());
		assertFalse(geom.getNodes().isEmpty());

		assertEquals(geom.getNodes().size(), 1);

		// Check the vertex source
		VertexSource vs = geom.getVertexSource();
		assertNotNull(vs);
		assertFalse(vs.getVertices().isEmpty());

		// Test some of the vertices at the beginning of the list
		EList<Vertex> vertices = vs.getVertices();
		testVertex(vertices.get(0), 0, 1, 2);
		testVertex(vertices.get(1), 1, 2, 3);
		testVertex(vertices.get(2), 2, 3, 4);
		testVertex(vertices.get(3), 3, 4, 5);

		// Test the face groups

		// Basic tests for first shape
		INode first = geom.getNodes().get(0);
		assertNotNull(first);
		assertTrue(first instanceof PolyShape);
		PolyShape shape1 = (PolyShape) first;
		assertTrue(shape1.getVertexSource() == geom.getVertexSource());
		assertEquals("shroud", shape1.getName());

		// Data tests

		// Test the first few faces
		EList<Face> faces = shape1.getFaces();
		testFace(faces.get(0), new int[] { 1, 2, 3 });
		testFace(faces.get(1), new int[] { 2, 3, 4 });
	}

	private void testFace(Face toTest, int[] indicesExp) {
		assertNotNull(toTest);
		EList<Integer> indices = toTest.getVertexIndices();
		assertEquals(indicesExp.length, indices.size());
		for (int i = 0; i < indices.size(); i++) {
			assertEquals(indicesExp[i], (int) indices.get(i));
		}

	}

	private void testVertex(Vertex toTest, double x, double y, double z) {
		assertNotNull(toTest);
		assertEquals(x, toTest.getX(), PARSE_ERROR);
		assertEquals(y, toTest.getY(), PARSE_ERROR);
		assertEquals(z, toTest.getZ(), PARSE_ERROR);
	}

}
