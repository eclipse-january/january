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
package org.eclipse.january.geometry.xtext.obj.test;

import static org.junit.Assert.*;

import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.eclipse.emf.common.util.EList;
import org.eclipse.january.geometry.Face;
import org.eclipse.january.geometry.Geometry;
import org.eclipse.january.geometry.INode;
import org.eclipse.january.geometry.PolyShape;
import org.eclipse.january.geometry.Vertex;
import org.eclipse.january.geometry.VertexSource;
import org.eclipse.january.geometry.xtext.obj.importer.OBJGeometryImporter;
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
				"eclipse", "january", "geometry", "xtext", "obj", 
				"test", "files", "airboat.obj");
		
		Geometry testGeom = importer.load(testFile);
		
		testOBJ1(testGeom);
	}
	
	private void testOBJ1(Geometry geom) {
		// Basic checks, making sure things are initialized
		assertNotNull(geom);
		assertNotNull(geom.getNodes());
		assertFalse(geom.getNodes().isEmpty());
		
		// Check the vertex source
		VertexSource vs = geom.getVertexSource();
		assertNotNull(vs);
		assertFalse(vs.getVertices().isEmpty());
		
		// Test some of the vertices at the beginning of the list
		EList<Vertex> vertices = vs.getVertices();
		testVertex(vertices.get(0), 2.712726, -2.398764, -2.492640);
		testVertex(vertices.get(1), 2.712726, -1.954302, -2.665440);
		testVertex(vertices.get(2), -5.975275, -1.954302, -2.665440);
		testVertex(vertices.get(3), -5.975275, -2.398764, -2.492640);
		testVertex(vertices.get(4), -6.113514, -1.885536, -2.803680);
		testVertex(vertices.get(5), 2.712726, -1.885536, -2.803680);
		testVertex(vertices.get(6), -5.975275, -1.372307, -2.803680);
		testVertex(vertices.get(7), -5.975275, -1.816770, -2.700000);
		testVertex(vertices.get(8), 2.712726, -1.816770, -2.700000);
		testVertex(vertices.get(9), 2.712726, -1.372307, -2.803680);
		testVertex(vertices.get(10), 4.766168, -2.256987, -2.354400);
		testVertex(vertices.get(11), 4.766168, -1.372307, -2.665439);
		testVertex(vertices.get(12), 4.766168, -1.769892, -2.561759);
		testVertex(vertices.get(13), 4.766168, -1.827445, -2.665439);
		
		// Test some of the vertices in the middle of the list
		testVertex(vertices.get(2000), -3.318531, 0.506776, -0.929264);
		testVertex(vertices.get(2001), -3.753773, 0.464233, -0.913264);
		testVertex(vertices.get(2002), -3.774562, 0.452674, -0.913264);
		testVertex(vertices.get(2003), -3.778621, 0.473080, -0.913264);
		testVertex(vertices.get(2004), -3.778621, 0.473080, -0.925776);
		testVertex(vertices.get(2005), -3.769773, 0.464233, -0.929264);
		
		// Test some of the vertices at the end of the list
		testVertex(vertices.get(5790), -5.786254, 1.628700, 1.347769);
		testVertex(vertices.get(5791), -5.745853, 1.622586, 1.335769);
		testVertex(vertices.get(5792), -5.745853, 1.819479, 1.192718);
		testVertex(vertices.get(5793), -5.867057, 1.636714, 1.358798);
		testVertex(vertices.get(5794), -5.867057, 1.837016, 1.213270);
		testVertex(vertices.get(5795), -6.048903, 1.856823, 1.202985);
		testVertex(vertices.get(5796), -6.028662, 1.639770, 1.364798);
		
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
		testFace(faces.get(0), new int[] {5049, 5019, 5021, 5033, 5035, 4907, 4909, 5047});
		testFace(faces.get(1), new int[] {4951, 4935, 4937, 4963, 4965, 4879, 4881, 4949});
		testFace(faces.get(2), new int[] {5124, 5125, 5123});
		testFace(faces.get(3), new int[] {5184, 5185, 5183});
		testFace(faces.get(4), new int[] {5214, 5215, 5213});
		testFace(faces.get(5), new int[] {5154, 5155, 5153});
		testFace(faces.get(6), new int[] {5077, 5061, 5063, 4893, 4895, 5089, 5091, 5075});
		testFace(faces.get(7), new int[] {4993, 4977, 4979, 4921, 4923, 5005, 5007, 4991});
		testFace(faces.get(8), new int[] {5127, 5129, 5126});
		testFace(faces.get(9), new int[] {5149, 5151, 5148});
		testFace(faces.get(10), new int[] {5179, 5180, 5181});
		testFace(faces.get(11), new int[] {5187, 5189, 5186});
		testFace(faces.get(12), new int[] {5209, 5211, 5208});
		testFace(faces.get(13), new int[] {5772, 5593, 5592, 5773});


	}
	
	
	private void testFace(Face toTest, int[] indicesExp) {
		assertNotNull(toTest);
		EList<Integer> indices = toTest.getVertexIndices();
		assertEquals(indicesExp.length, indices.size());
		for(int i=0; i<indices.size(); i++) {
			assertEquals(indicesExp[i], (int)indices.get(i));
		}
		
	}
	
	
	private void testVertex(Vertex toTest, double x, double y, double z) {
		assertNotNull(toTest);
		assertEquals(x, toTest.getX(), PARSE_ERROR);
		assertEquals(y, toTest.getY(), PARSE_ERROR);
		assertEquals(z, toTest.getZ(), PARSE_ERROR);
	}

}
