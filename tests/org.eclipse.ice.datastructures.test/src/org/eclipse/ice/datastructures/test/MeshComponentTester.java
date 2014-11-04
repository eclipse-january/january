/*******************************************************************************
 * Copyright (c) 2014 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - Jay Jay Billings,
 *   Jordan H. Deyton, Dasha Gorin, Alexander J. McCaskey, Taylor Patterson,
 *   Claire Saunders, Matthew Wang, Anna Wojtowicz
 *******************************************************************************/
package org.eclipse.ice.datastructures.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.ice.datastructures.form.mesh.Edge;
import org.eclipse.ice.datastructures.form.mesh.MeshComponent;
import org.eclipse.ice.datastructures.form.mesh.Polygon;
import org.eclipse.ice.datastructures.form.mesh.Vertex;
import org.eclipse.ice.datastructures.updateableComposite.Component;
import org.junit.Test;

/**
 * <!-- begin-UML-doc -->
 * <p>
 * Tests the MeshComponent class.
 * </p>
 * <!-- end-UML-doc -->
 * 
 * @author Jordan H. Deyton
 * @generated 
 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class MeshComponentTester {
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation tests the construction of the MeshComponent class and the
	 * functionality inherited from ICEObject.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkCreation() {
		// begin-user-code

		// Create a MeshComponent to test.
		MeshComponent component = new MeshComponent();

		// Make sure the shapes List was initialized.
		assertNotNull(component.getPolygons());
		assertTrue(component.getPolygons().isEmpty());
		assertNotNull(component.getEdges());
		assertTrue(component.getEdges().isEmpty());
		assertNotNull(component.getVertices());
		assertTrue(component.getVertices().isEmpty());

		// Check the initially available IDs for polygons, edges, and vertices.
		assertEquals(1, component.getNextPolygonId());
		assertEquals(1, component.getNextEdgeId());
		assertEquals(1, component.getNextVertexId());

		return;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation verifies that shapes can be successfully added to and
	 * removed from the MeshComponent.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkAddPolygons() {
		// begin-user-code

		/*- XXX The minus sign right after the asterisk on this line prevents
		 * auto-formatting from messing up the ASCII art below!
		 * 
		 * The tests below create four quads positioned roughly like the diagram
		 * below. The polygon with ID 3 is totally disjoint, while the others
		 * share edges and/or vertices.
		 *  _______________
		 * | 0 |        ___
		 * |___|       | 3 |
		 * | 1 |       |___|
		 * |___|___
		 * |   | 2 |
		 * |   |___|
		 * |
		 * 
		 * After the quads are created, quad 1 is removed, then quad 2 is 
		 * removed. After each of these removals, the shapes, edges, and 
		 * vertices reported by the MeshComponent are checked.
		 */

		// These variables will be used to construct polygons to add to the
		// mesh.
		Polygon polygon;
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		ArrayList<Edge> edges = new ArrayList<Edge>();

		// These lists hold values that we will use to check the contents of the
		// component.
		ArrayList<Polygon> allShapes = new ArrayList<Polygon>();
		ArrayList<Edge> allEdges = new ArrayList<Edge>();
		ArrayList<Vertex> allVertices = new ArrayList<Vertex>();

		// Create a MeshComponent to test.
		MeshComponent mesh = new MeshComponent();

		// Initially, everything should be empty.
		assertEquals(allShapes, mesh.getPolygons());
		assertEquals(allEdges, mesh.getEdges());
		for (Edge e : allEdges) {
			assertEquals(e, mesh.getEdge(e.getId()));
		}
		assertEquals(allVertices, mesh.getVertices());
		for (Vertex v : allVertices) {
			assertEquals(v, mesh.getVertex(v.getId()));
		}

		/* ---- Make a square of area 1 cornered on the origin. ---- */
		// Set up the vertices.
		vertices.add(new Vertex(0f, 0f, 0f));
		vertices.add(new Vertex(1f, 0f, 0f));
		vertices.add(new Vertex(1f, 0f, 1f));
		vertices.add(new Vertex(0f, 0f, 1f));
		for (int i = 0; i < 4; i++) {
			allVertices.add(vertices.get(i));
			vertices.get(i).setId(allVertices.size());
		}
		// Set up the edges.
		for (int i = 0; i < 4; i++) {
			edges.add(new Edge(vertices.get(i), vertices.get((i + 1) % 4)));
			allEdges.add(edges.get(i));
			edges.get(i).setId(allEdges.size());
		}
		// Initialize the polygon.
		polygon = new Polygon(edges, vertices);
		polygon.setId(1);
		allShapes.add(polygon);

		// Add the shape and verify the contents of the component.
		mesh.addPolygon(polygon);
		assertEquals(allShapes, mesh.getPolygons());
		assertEquals(allEdges, mesh.getEdges());
		for (Edge e : allEdges) {
			assertEquals(e, mesh.getEdge(e.getId()));
		}
		assertEquals(allVertices, mesh.getVertices());
		for (Vertex v : allVertices) {
			assertEquals(v, mesh.getVertex(v.getId()));
		}
		assertEquals(polygon, mesh.getPolygon(polygon.getId()));

		// Check the next available IDs.
		assertEquals(allShapes.size() + 1, mesh.getNextPolygonId());
		assertEquals(allEdges.size() + 1, mesh.getNextEdgeId());
		assertEquals(allVertices.size() + 1, mesh.getNextVertexId());
		/* --------------------------------------------------------- */

		/* ---- Make a square of area 1 attached below the origin. ---- */
		// Set up the vertices. The bottom two vertices of the first square are
		// re-used. For the one in position (0,0,1), use the same vertex. For
		// the one in position (1,0,1), use a clone.
		vertices.set(0, (Vertex) vertices.get(3).clone());
		vertices.set(1, vertices.get(2));
		vertices.set(2, new Vertex(1f, 0f, 2f));
		vertices.set(3, new Vertex(0f, 0f, 2f));
		for (int i = 2; i < 4; i++) {
			allVertices.add(vertices.get(i));
			vertices.get(i).setId(allVertices.size());
		}
		// Set up the edges. Use a clone of the shared edge.
		edges.set(0, edges.get(2));
		for (int i = 1; i < 4; i++) {
			edges.set(i, new Edge(vertices.get(i), vertices.get((i + 1) % 4)));
			allEdges.add(edges.get(i));
			edges.get(i).setId(allEdges.size());
		}
		// Initialize the polygon.
		polygon = new Polygon(edges, vertices);
		polygon.setId(2);
		allShapes.add(polygon);

		// Add the shape and verify the contents of the component.
		mesh.addPolygon(polygon);
		assertEquals(allShapes, mesh.getPolygons());
		assertEquals(allEdges, mesh.getEdges());
		for (Edge e : allEdges) {
			assertEquals(e, mesh.getEdge(e.getId()));
		}
		assertEquals(allVertices, mesh.getVertices());
		for (Vertex v : allVertices) {
			assertEquals(v, mesh.getVertex(v.getId()));
		}
		assertEquals(polygon, mesh.getPolygon(polygon.getId()));

		// Check the next available IDs.
		assertEquals(allShapes.size() + 1, mesh.getNextPolygonId());
		assertEquals(allEdges.size() + 1, mesh.getNextEdgeId());
		assertEquals(allVertices.size() + 1, mesh.getNextVertexId());
		/* ------------------------------------------------------------ */

		/* ---- Add a new square with the same bottom-right vertex. ---- */
		// Set up the vertices.
		vertices.set(0, vertices.get(2));
		vertices.set(1, new Vertex(2f, 0f, 2f));
		vertices.set(2, new Vertex(2f, 0f, 3f));
		vertices.set(3, new Vertex(1f, 0f, 3f));
		for (int i = 1; i < 4; i++) {
			allVertices.add(vertices.get(i));
			vertices.get(i).setId(allVertices.size());
		}
		// Set up the edges.
		for (int i = 0; i < 4; i++) {
			edges.set(i, new Edge(vertices.get(i), vertices.get((i + 1) % 4)));
			allEdges.add(edges.get(i));
			edges.get(i).setId(allEdges.size());
		}
		// Initialize the polygon.
		polygon = new Polygon(edges, vertices);
		polygon.setId(3);
		allShapes.add(polygon);

		// Add the shape and verify the contents of the component.
		mesh.addPolygon(polygon);
		assertEquals(allShapes, mesh.getPolygons());
		assertEquals(allEdges, mesh.getEdges());
		for (Edge e : allEdges) {
			assertEquals(e, mesh.getEdge(e.getId()));
		}
		assertEquals(allVertices, mesh.getVertices());
		for (Vertex v : allVertices) {
			assertEquals(v, mesh.getVertex(v.getId()));
		}
		assertEquals(polygon, mesh.getPolygon(polygon.getId()));

		// Check the next available IDs.
		assertEquals(allShapes.size() + 1, mesh.getNextPolygonId());
		assertEquals(allEdges.size() + 1, mesh.getNextEdgeId());
		assertEquals(allVertices.size() + 1, mesh.getNextVertexId());
		/* ------------------------------------------------------------- */

		/* ---- Add a disjoint polygon (attached to nothing). ---- */
		// Set up the vertices.
		vertices.set(0, new Vertex(10f, 0, 10f));
		vertices.set(1, new Vertex(11f, 0f, 10f));
		vertices.set(2, new Vertex(11f, 0f, 11f));
		vertices.set(3, new Vertex(10f, 0f, 11f));
		for (int i = 0; i < 4; i++) {
			allVertices.add(vertices.get(i));
			vertices.get(i).setId(allVertices.size());
		}
		// Set up the edges.
		for (int i = 0; i < 4; i++) {
			edges.set(i, new Edge(vertices.get(i), vertices.get((i + 1) % 4)));
			allEdges.add(edges.get(i));
			edges.get(i).setId(allEdges.size());
		}
		// Initialize the polygon.
		polygon = new Polygon(edges, vertices);
		polygon.setId(4);
		allShapes.add(polygon);

		// Add the shape and verify the contents of the component.
		mesh.addPolygon(polygon);
		assertEquals(allShapes, mesh.getPolygons());
		assertEquals(allEdges, mesh.getEdges());
		for (Edge e : allEdges) {
			assertEquals(e, mesh.getEdge(e.getId()));
		}
		assertEquals(allVertices, mesh.getVertices());
		for (Vertex v : allVertices) {
			assertEquals(v, mesh.getVertex(v.getId()));
		}
		assertEquals(polygon, mesh.getPolygon(polygon.getId()));

		// Check the next available IDs.
		assertEquals(allShapes.size() + 1, mesh.getNextPolygonId());
		assertEquals(allEdges.size() + 1, mesh.getNextEdgeId());
		assertEquals(allVertices.size() + 1, mesh.getNextVertexId());
		/* ------------------------------------------------------- */

		// ---- Check the helper methods. ---- //

		// First, check getEdgeFromVertices(). We should be able to check the ID
		// for valid combinations of vertex IDs passed into the method.

		// Try an invalid call: the same vertex ID and an invalid vertex ID.
		// These should return null.
		assertNull(mesh.getEdgeFromVertices(1, 1));
		assertNull(mesh.getEdgeFromVertices(0, 1));

		// Try more valid values.
		assertNotNull(mesh.getEdgeFromVertices(1, 2));
		assertEquals(1, mesh.getEdgeFromVertices(1, 2).getId());
		assertNotNull(mesh.getEdgeFromVertices(3, 5));
		assertEquals(5, mesh.getEdgeFromVertices(3, 5).getId());
		assertNotNull(mesh.getEdgeFromVertices(13, 12));
		assertEquals(14, mesh.getEdgeFromVertices(13, 12).getId());
		// Try another invalid value.
		assertNull(mesh.getEdgeFromVertices(9, 3));

		// Next, check getPolygonsFromVertices(). We should be able to check the
		// IDs of the polygons expected to be returned from the method.

		ArrayList<Polygon> polygonList;

		// Passing in a null argument should result in an empty list.
		ArrayList<Vertex> vertexList = null;
		assertTrue(mesh.getPolygonsFromVertices(vertexList).isEmpty());

		// Initialize the list of vertices and add the first three. There
		// shouldn't be enough vertices to yield a polygon from the method.
		vertexList = new ArrayList<Vertex>();
		for (int i = 0; i < 3; i++) {
			vertexList.add(allVertices.get(i));
		}
		polygonList = mesh.getPolygonsFromVertices(vertexList);
		assertTrue(polygonList.isEmpty());

		// Add the third vertex twice. It shouldn't change anything.
		vertexList.add(allVertices.get(2));
		polygonList = mesh.getPolygonsFromVertices(vertexList);
		assertTrue(polygonList.isEmpty());

		// Add the fourth vertex. We should get the first polygon.
		vertexList.add(allVertices.get(3));
		polygonList = mesh.getPolygonsFromVertices(vertexList);
		assertEquals(1, polygonList.size());
		assertEquals(1, polygonList.get(0).getId());

		// Add the next three vertices. We should get the first two polygons.
		for (int i = 4; i < 7; i++) {
			vertexList.add(allVertices.get(i));
		}
		polygonList = mesh.getPolygonsFromVertices(vertexList);
		assertEquals(2, polygonList.size());
		assertEquals(1, polygonList.get(0).getId());
		assertEquals(2, polygonList.get(1).getId());
		// ----------------------------------- //

		/* ---- Remove the second polygon we added. ---- */
		int nextPolygonId = allShapes.size() + 1;
		int nextEdgeId = allEdges.size() + 1;
		int nextVertexId = allVertices.size() + 1;

		polygon = (Polygon) allShapes.get(1);
		allShapes.remove(polygon);
		// Get the vertices that will be removed.
		vertices.clear();
		vertices.add(polygon.getVertices().get(3));
		for (Vertex v : vertices) {
			allVertices.remove(v);
		}
		// Get the edges that will be removed.
		edges.clear();
		edges.add(polygon.getEdges().get(1));
		edges.add(polygon.getEdges().get(2));
		edges.add(polygon.getEdges().get(3));
		for (Edge e : edges) {
			allEdges.remove(e);
		}
		// Remove the shape and verify the contents of the component.
		mesh.removePolygon(polygon.getId());
		assertEquals(allShapes, mesh.getPolygons());
		assertEquals(allEdges, mesh.getEdges());
		for (Edge e : allEdges) {
			assertEquals(e, mesh.getEdge(e.getId()));
		}
		assertEquals(allVertices, mesh.getVertices());
		for (Vertex v : allVertices) {
			assertEquals(v, mesh.getVertex(v.getId()));
		}

		// Check the next available IDs.
		// We didn't remove the highest-indexed polygon, so these don't change.
		assertEquals(nextPolygonId, mesh.getNextPolygonId());
		assertEquals(nextEdgeId, mesh.getNextEdgeId());
		assertEquals(nextVertexId, mesh.getNextVertexId());
		/* --------------------------------------------- */

		/* ---- Remove the third polygon we added. ---- */
		polygon = (Polygon) allShapes.get(1);
		allShapes.remove(polygon);
		// Get the vertices that will be removed.
		for (Vertex v : polygon.getVertices()) {
			allVertices.remove(v);
		}
		// Get the edges that will be removed.
		for (Edge e : polygon.getEdges()) {
			allEdges.remove(e);
		}

		// Remove the shape and verify the contents of the component.
		mesh.removePolygon(polygon.getId());
		assertEquals(allShapes, mesh.getPolygons());
		assertEquals(allEdges, mesh.getEdges());
		for (Edge e : allEdges) {
			assertEquals(e, mesh.getEdge(e.getId()));
		}
		assertEquals(allVertices, mesh.getVertices());
		for (Vertex v : allVertices) {
			assertEquals(v, mesh.getVertex(v.getId()));
		}

		// Check the next available IDs.
		// We didn't remove the highest-indexed polygon, so these don't change.
		assertEquals(nextPolygonId, mesh.getNextPolygonId());
		assertEquals(nextEdgeId, mesh.getNextEdgeId());
		assertEquals(nextVertexId, mesh.getNextVertexId());
		/* -------------------------------------------- */

		// ---- Check the helper methods. ---- //

		// First, check getEdgeFromVertices(). We should be able to check the ID
		// for valid combinations of vertex IDs passed into the method.

		// Try an invalid call: the same vertex ID and an invalid vertex ID.
		// These should return null.
		assertNull(mesh.getEdgeFromVertices(1, 1));
		assertNull(mesh.getEdgeFromVertices(0, 1));

		// Try more valid values.
		assertNotNull(mesh.getEdgeFromVertices(1, 2));
		assertEquals(1, mesh.getEdgeFromVertices(1, 2).getId());
		assertNull(mesh.getEdgeFromVertices(3, 5)); // This edge from the second
													// quad is now invalid.
		assertNotNull(mesh.getEdgeFromVertices(13, 12));
		assertEquals(14, mesh.getEdgeFromVertices(13, 12).getId());
		// Try another invalid value.
		assertNull(mesh.getEdgeFromVertices(9, 3));

		// Next, check getPolygonsFromVertices(). We should be able to check the
		// IDs of the polygons expected to be returned from the method.

		// Passing in a null argument should result in an empty list.
		vertexList = null;
		assertTrue(mesh.getPolygonsFromVertices(vertexList).isEmpty());

		// Initialize the list of vertices and add the first three. There
		// shouldn't be enough vertices to yield a polygon from the method.
		vertexList = new ArrayList<Vertex>();
		for (int i = 0; i < 3; i++) {
			vertexList.add(allVertices.get(i));
		}
		polygonList = mesh.getPolygonsFromVertices(vertexList);
		assertTrue(polygonList.isEmpty());

		// Add the third vertex twice. It shouldn't change anything.
		vertexList.add(allVertices.get(2));
		polygonList = mesh.getPolygonsFromVertices(vertexList);
		assertTrue(polygonList.isEmpty());

		// Add the fourth vertex. We should get the first polygon.
		vertexList.add(allVertices.get(3));
		polygonList = mesh.getPolygonsFromVertices(vertexList);
		assertEquals(1, polygonList.size());
		assertEquals(1, polygonList.get(0).getId());

		// Add the next three vertices. We should get now only get the first
		// polygon, because the second one has been removed.
		for (int i = 4; i < 7; i++) {
			vertexList.add(allVertices.get(i));
		}
		polygonList = mesh.getPolygonsFromVertices(vertexList);
		assertEquals(1, polygonList.size());
		assertEquals(1, polygonList.get(0).getId());
		// ----------------------------------- //

		// TODO - More complicated tests, like overlapping polygons, different
		// references to the same vertex/edge (i.e., vertex1.equals(vertex2),
		// but vertex1 != vertex2), bad IDs.

		return;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation checks MeshComponent to ensure that it can be correctly
	 * visited by a realization of the IComponentVisitor and IMeshPartVisitor
	 * interfaces.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkVisitation() {
		// begin-user-code

		// ---- Check visiting with an IComponentVisitor. ---- //
		// Create a MeshComponent to test.
		Component component = new MeshComponent();

		// Create a new test visitor.
		TestVisitor visitor = new TestVisitor();
		assertFalse(visitor.wasVisited());

		// Visit the component.
		component.accept(visitor);

		// Make sure the visitor visited successfully.
		assertTrue(visitor.wasVisited());
		// -------------------------------------------------- //

		// ---- Check visiting with an IMeshPartVisitor. ---- //
		// Create a new TestMeshVisitor that only does anything useful when
		// visiting a MeshComponent.
		TestMeshVisitor meshVisitor = new TestMeshVisitor() {
			@Override
			public void visit(MeshComponent component) {
				visited = true;
			}
		};
		assertFalse(meshVisitor.wasVisited());

		// Now try to visit the MeshComponent with the TestMeshVisitor.
		((MeshComponent) component).acceptMeshVisitor(meshVisitor);
		assertTrue(meshVisitor.wasVisited());
		// -------------------------------------------------- //

		return;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation tests the MeshComponent to ensure that it can properly
	 * dispatch notifications when it receives an update that changes its state.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkNotifications() {
		// begin-user-code

		// Create a simple polygon to add the the component.
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		vertices.add(new Vertex(0f, 0f, 0f));
		vertices.add(new Vertex(1f, 0f, 0f));
		vertices.add(new Vertex(0f, 0f, 1f));
		for (int i = 0; i < 3; i++) {
			vertices.get(i).setId(i + 1);
		}
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for (int i = 0; i < 3; i++) {
			edges.add(new Edge(vertices.get(i), vertices.get((i + 1) % 3)));
			edges.get(i).setId(i + 1);
		}
		Polygon shape1 = new Polygon(edges, vertices);
		shape1.setId(1);

		vertices.clear();
		vertices.add(new Vertex(10f, 0f, 10f));
		vertices.add(new Vertex(11f, 0f, 10f));
		vertices.add(new Vertex(10f, 0f, 11f));
		for (int i = 0; i < 3; i++) {
			vertices.get(i).setId(i + 4);
		}
		edges.clear();
		for (int i = 0; i < 3; i++) {
			edges.add(new Edge(vertices.get(i), vertices.get((i + 1) % 3)));
			edges.get(i).setId(i + 4);
		}
		Polygon shape2 = new Polygon(edges, vertices);
		shape2.setId(2);

		// Create a MeshComponent to test.
		MeshComponent component = new MeshComponent();

		// All methods that should notify listeners:
		// setPolygons(ArrayList<Polygon>)
		// addPolygon(Polygon)
		// removePolygon(int)

		// All of these methods are tested at some point below.

		// Create a test listener and register it with the component.
		TestComponentListener listener1 = new TestComponentListener();
		component.register(listener1);

		// Add a shape. The listener should be notified.
		component.addPolygon(shape1);
		assertTrue(listener1.wasNotified());
		listener1.reset();

		// Now remove the shape. The listener should be notified.
		component.removePolygon(shape1.getId());
		assertTrue(listener1.wasNotified());
		listener1.reset();

		// Set the list of shapes.
		ArrayList<Polygon> polygons = new ArrayList<Polygon>();
		polygons.add(shape1);
		polygons.add(shape2);
		component.setPolygons(polygons);
		assertTrue(listener1.wasNotified());

		return;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation checks the ability of the MeshComponent to persist itself
	 * to XML and to load itself from an XML input stream.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkLoadingFromXML() {
		// begin-user-code

		// Create a simple polygon to add the the component.
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		vertices.add(new Vertex(0f, 0f, 0f));
		vertices.add(new Vertex(1f, 0f, 0f));
		vertices.add(new Vertex(0f, 0f, 1f));
		for (int i = 0; i < 3; i++) {
			vertices.get(i).setId(i + 1);
		}
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for (int i = 0; i < 3; i++) {
			edges.add(new Edge(vertices.get(i), vertices.get((i + 1) % 3)));
			edges.get(i).setId(i + 1);
		}
		Polygon shape = new Polygon(edges, vertices);

		// Create a MeshComponent to test.
		MeshComponent component = new MeshComponent();

		// Customize it.
		component.setId(42);
		component.setName("YAMC");
		component.setDescription("Yet Another MeshComponent");
		component.addPolygon(shape);
		// Load it into XML.
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		component.persistToXML(outputStream);
		assertNotNull(outputStream);

		// Convert the output stream data to an input stream.
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				outputStream.toByteArray());

		// Load the input stream's contents into a new component.
		MeshComponent loadedComponent = new MeshComponent();
		loadedComponent.loadFromXML(inputStream);

		// Make sure the two components match.
		assertTrue(component.equals(loadedComponent));

		// Check invalid parameters.

		// Try passing null and make sure the components match.
		inputStream = null;
		loadedComponent.loadFromXML(inputStream);
		assertTrue(component.equals(loadedComponent));

		// Try passing a bad input stream and make sure the components match.
		inputStream = new ByteArrayInputStream("invalidstreamasdf1".getBytes());
		loadedComponent.loadFromXML(inputStream);
		assertTrue(component.equals(loadedComponent));

		return;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation checks the MeshComponent to insure that its equals() and
	 * hashCode() operations work.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkEquality() {
		// begin-user-code

		// Create a simple polygon to add the the component.
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		vertices.add(new Vertex(0f, 0f, 0f));
		vertices.add(new Vertex(1f, 0f, 0f));
		vertices.add(new Vertex(0f, 0f, 1f));
		for (int i = 0; i < 3; i++) {
			vertices.get(i).setId(i + 1);
		}
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for (int i = 0; i < 3; i++) {
			edges.add(new Edge(vertices.get(i), vertices.get((i + 1) % 3)));
			edges.get(i).setId(i + 1);
		}
		Polygon polygon = new Polygon(edges, vertices);
		polygon.setId(1);

		// Initialize objects for testing.
		MeshComponent object = new MeshComponent();
		MeshComponent equalObject = new MeshComponent();
		MeshComponent unequalObject = new MeshComponent();

		// Set up the object and equalObject.
		object.setName("YAMC");
		object.addPolygon(polygon);

		equalObject.setName("YAMC");
		equalObject.addPolygon((Polygon) polygon.clone());

		// Set up the unequalObject.
		unequalObject.setName("YAMC");
		vertices.set(2, new Vertex(0f, 0f, 2f));
		vertices.get(2).setId(3);
		for (int i = 1; i < 3; i++) {
			edges.set(i, new Edge(vertices.get(i), vertices.get((i + 1) % 3)));
			edges.get(i).setId(i + 1);
		}
		polygon = new Polygon(edges, vertices);
		polygon.setId(1);
		unequalObject.addPolygon(polygon);

		// Make sure the references are different.
		assertFalse(object == equalObject);
		assertFalse(object == unequalObject);
		assertFalse(equalObject == unequalObject);

		// Check that equality is reflexive and symmetric.
		assertTrue(object.equals(object));
		assertTrue(object.equals(equalObject));
		assertTrue(equalObject.equals(object));

		// Check that equals will fail when it should.
		assertFalse(object == null);
		assertFalse(object.equals(42));
		assertFalse("just a string".equals(object));
		assertFalse(object.equals(unequalObject));
		assertFalse(unequalObject.equals(object));

		// Check the hash codes.
		assertTrue(object.hashCode() == object.hashCode());
		assertTrue(object.hashCode() == equalObject.hashCode());
		assertFalse(object.hashCode() == unequalObject.hashCode());

		return;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation checks the MeshComponent to ensure that its copy() and
	 * clone() operations work as specified.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkCopying() {
		// begin-user-code

		/*
		 * 
		 * The mesh should look like two triangles that form a square of area 1.
		 * 
		 * After the copy, we make sure the references in the copy are set up
		 * correctly by changing the top-right and bottom-left vertices in the
		 * copy to form a 30-60-90 triangle with sides of length 3-4-5.
		 */

		// Create a simple polygon to add the the component.
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		vertices.add(new Vertex(0f, 0f, 0f));
		vertices.add(new Vertex(1f, 0f, 0f));
		vertices.add(new Vertex(0f, 0f, 1f));
		for (int i = 0; i < 3; i++) {
			vertices.get(i).setId(i + 1);
		}
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for (int i = 0; i < 3; i++) {
			edges.add(new Edge(vertices.get(i), vertices.get((i + 1) % 3)));
			edges.get(i).setId(i + 1);
		}
		Polygon shape = new Polygon(edges, vertices);
		shape.setId(1);

		vertices.set(0, vertices.get(1));
		vertices.set(1, vertices.get(2));
		vertices.set(2, new Vertex(1f, 0f, 1f));
		vertices.get(2).setId(4);
		edges.set(0, edges.get(1));
		for (int i = 1; i < 3; i++) {
			edges.set(i, new Edge(vertices.get(i), vertices.get((i + 1) % 3)));
			edges.get(i).setId(i + 3);
		}
		Polygon shape2 = new Polygon(edges, vertices);
		shape2.setId(2);

		// Initialize objects for testing.
		MeshComponent object = new MeshComponent();
		MeshComponent copy = new MeshComponent();
		MeshComponent clone = null;

		// Set up the object.
		object.setName("YAMC");
		object.addPolygon(shape);
		object.addPolygon(shape2);

		// Make sure the objects are not equal before copying.
		assertFalse(object == copy);
		assertFalse(object.equals(copy));

		// Copy the object.
		copy.copy(object);

		// Make sure the references are different but contents the same.
		assertFalse(object == copy);
		assertTrue(object.equals(copy));

		// Do the same for the clone operation.

		// Make sure the objects are not equal before copying.
		assertFalse(object == clone);
		assertFalse(object.equals(clone));

		// Copy the object.
		clone = (MeshComponent) object.clone();

		// Make sure the references are different but contents the same.
		assertFalse(object == clone);
		assertTrue(object.equals(clone));
		assertFalse(copy == clone);
		assertTrue(copy.equals(clone));

		// Make sure the references copied correctly by changing some of the
		// vertices.

		// The first triangle should be an isosceles right triangle.
		assertEquals(1f, object.getEdge(1).getLength(), 1e-7f);
		assertEquals(Math.sqrt(2), object.getEdge(2).getLength(), 1e-7f);
		assertEquals(1f, object.getEdge(3).getLength(), 1e-7f);

		// The same dimensions apply to the copy.
		assertEquals(1f, copy.getEdge(1).getLength(), 1e-7f);
		assertEquals(Math.sqrt(2), copy.getEdge(2).getLength(), 1e-7f);
		assertEquals(1f, copy.getEdge(3).getLength(), 1e-7f);

		// Create listeners for the edges in the copy to make sure they were all
		// updated.
		List<TestComponentListener> listeners = new ArrayList<TestComponentListener>();
		for (Edge edge : copy.getEdges()) {
			TestComponentListener listener = new TestComponentListener();
			edge.register(listener);
			listeners.add(listener);
		}

		// Make the copy into a 30-60-90 triangle.
		copy.getVertex(2).setLocation(3f, 0f, 0f);
		copy.getVertex(3).setLocation(0f, 0f, 4f);

		// The first triangle should still be an isosceles right triangle.
		assertEquals(1f, object.getEdge(1).getLength(), 1e-7f);
		assertEquals(Math.sqrt(2), object.getEdge(2).getLength(), 1e-7f);
		assertEquals(1f, object.getEdge(3).getLength(), 1e-7f);

		// Make sure the edges in the copy's first triangle were updated.
		for (int i = 1; i < 4; i++) {
			assertTrue(listeners.get(i).wasNotified());
			listeners.get(i).reset();
		}

		// The copy's first triangle should now be a 3-4-5 triangle.
		assertEquals(3f, copy.getEdge(1).getLength(), 1e-7f);
		assertEquals(5f, copy.getEdge(2).getLength(), 1e-7f);
		assertEquals(4f, copy.getEdge(3).getLength(), 1e-7f);

		return;
		// end-user-code
	}
}