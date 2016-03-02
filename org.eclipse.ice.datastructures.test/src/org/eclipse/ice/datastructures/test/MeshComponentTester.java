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
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.eavp.viz.service.mesh.datastructures.NekPolygonController;
import org.eclipse.eavp.viz.service.mesh.datastructures.NekPolygonMesh;
import org.eclipse.eavp.viz.service.modeling.AbstractController;
import org.eclipse.eavp.viz.service.modeling.AbstractView;
import org.eclipse.eavp.viz.service.modeling.EdgeController;
import org.eclipse.eavp.viz.service.modeling.FaceEdgeController;
import org.eclipse.eavp.viz.service.modeling.FaceEdgeMesh;
import org.eclipse.eavp.viz.service.modeling.IController;
import org.eclipse.eavp.viz.service.modeling.LinearEdgeMesh;
import org.eclipse.eavp.viz.service.modeling.MeshCategory;
import org.eclipse.eavp.viz.service.modeling.MeshProperty;
import org.eclipse.eavp.viz.service.modeling.VertexController;
import org.eclipse.eavp.viz.service.modeling.VertexMesh;
import org.eclipse.ice.datastructures.form.MeshComponent;
import org.junit.Test;

/**
 * <p>
 * Tests the MeshComponent class.
 * </p>
 * 
 * @author Jordan H. Deyton
 */
public class MeshComponentTester {
	/**
	 * <p>
	 * This operation tests the construction of the MeshComponent class and the
	 * functionality inherited from ICEObject.
	 * </p>
	 * 
	 */
	@Test
	public void checkCreation() {

		// Create a MeshComponent to test.
		MeshComponent component = new MeshComponent();

		// Make sure the shapes List was initialized.
		assertNotNull(component.getPolygons());
		assertTrue(component.getPolygons().isEmpty());

		// Check the initially available IDs for polygons, edges, and vertices.
		assertEquals(1, component.getNextPolygonId());
		assertEquals(1, component.getNextEdgeId());
		assertEquals(1, component.getNextVertexId());

		return;
	}

	/**
	 * <p>
	 * This operation verifies that shapes can be successfully added to and
	 * removed from the MeshComponent.
	 * </p>
	 * 
	 */
	@Test
	public void checkAddPolygons() {

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
		NekPolygonController polygon;
		ArrayList<IController> vertices = new ArrayList<IController>();
		ArrayList<IController> edges = new ArrayList<IController>();

		// These lists hold values that we will use to check the contents of the
		// component.
		ArrayList<IController> allShapes = new ArrayList<IController>();
		ArrayList<IController> allEdges = new ArrayList<IController>();
		ArrayList<IController> allVertices = new ArrayList<IController>();

		// Create a MeshComponent to test.
		MeshComponent mesh = new MeshComponent();

		// Initially, everything should be empty.
		assertEquals(allShapes, mesh.getPolygons());

		/* ---- Make a square of area 1 cornered on the origin. ---- */
		// Set up the vertices.
		vertices.add(new VertexController(new VertexMesh(0f, 0f, 0f),
				new AbstractView()));
		vertices.add(new VertexController(new VertexMesh(1f, 0f, 0f),
				new AbstractView()));
		vertices.add(new VertexController(new VertexMesh(1f, 0f, 1f),
				new AbstractView()));
		vertices.add(new VertexController(new VertexMesh(0f, 0f, 1f),
				new AbstractView()));
		for (int i = 0; i < 4; i++) {
			allVertices.add(vertices.get(i));
			vertices.get(i).setProperty(MeshProperty.ID,
					Integer.toString(allVertices.size()));
		}
		// Set up the edges.
		for (int i = 0; i < 4; i++) {
			edges.add(
					new EdgeController(
							new LinearEdgeMesh(
									(VertexController) vertices.get(i),
									(VertexController) vertices
											.get((i + 1) % 4)),
					new AbstractView()));
			allEdges.add(edges.get(i));
			edges.get(i).setProperty(MeshProperty.ID,
					Integer.toString(allEdges.size()));
		}
		// Initialize the polygon.
		polygon = new NekPolygonController(new NekPolygonMesh(),
				new AbstractView());
		for (IController edge : edges) {
			polygon.addEntityToCategory(edge, MeshCategory.EDGES);
		}
		polygon.setProperty(MeshProperty.ID, "1");
		allShapes.add(polygon);

		// Add the shape and verify the contents of the component.
		mesh.addPolygon(polygon);
		assertEquals(allShapes, mesh.getPolygons());

		// Collect all the edges and vertices of all polygons
		ArrayList<IController> meshEdges = new ArrayList<IController>();
		ArrayList<IController> meshVertices = new ArrayList<IController>();
		for (IController entity : mesh.getPolygons()) {
			meshEdges
					.addAll(entity.getEntitiesFromCategory(MeshCategory.EDGES));
			meshVertices.addAll(
					entity.getEntitiesFromCategory(MeshCategory.VERTICES));
		}

		assertTrue(compareLists(allEdges, meshEdges));
		assertTrue(compareLists(allVertices, meshVertices));
		assertEquals(polygon, mesh.getPolygons().get(0));

		/* --------------------------------------------------------- */

		/* ---- Make a square of area 1 attached below the origin. ---- */
		// Set up the vertices. The bottom two vertices of the first square are
		// re-used. For the one in position (0,0,1), use the same vertex. For
		// the one in position (1,0,1), use a clone.
		vertices.set(0,
				(IController) ((AbstractController) vertices.get(3)).clone());
		vertices.set(1, vertices.get(2));
		vertices.set(2, new VertexController(new VertexMesh(1f, 0f, 2f),
				new AbstractView()));
		vertices.set(3, new VertexController(new VertexMesh(0f, 0f, 2f),
				new AbstractView()));
		for (int i = 2; i < 4; i++) {
			allVertices.add(vertices.get(i));
			vertices.get(i).setProperty(MeshProperty.ID,
					Integer.toString(allVertices.size()));
		}
		// Set up the edges. Use a clone of the shared edge.
		edges.set(0, edges.get(2));
		for (int i = 1; i < 4; i++) {
			edges.set(i,
					new EdgeController(
							new LinearEdgeMesh(
									(VertexController) vertices.get(i),
									(VertexController) vertices
											.get((i + 1) % 4)),
					new AbstractView()));
			allEdges.add(edges.get(i));
			edges.get(i).setProperty(MeshProperty.ID,
					Integer.toString(allEdges.size()));
		}
		// Initialize the polygon.
		polygon = new NekPolygonController(new NekPolygonMesh(),
				new AbstractView());
		for (IController edge : edges) {
			polygon.addEntityToCategory(edge, MeshCategory.EDGES);
		}
		polygon.setProperty(MeshProperty.ID, "2");
		allShapes.add(polygon);

		// Add the shape and verify the contents of the component.
		mesh.addPolygon(polygon);
		assertEquals(allShapes, mesh.getPolygons());

		// Collect all the edges and vertices of all polygons
		meshEdges = new ArrayList<IController>();
		meshVertices = new ArrayList<IController>();
		for (IController entity : mesh.getPolygons()) {
			meshEdges
					.addAll(entity.getEntitiesFromCategory(MeshCategory.EDGES));
			meshVertices.addAll(
					entity.getEntitiesFromCategory(MeshCategory.VERTICES));
		}

		assertTrue(compareLists(allEdges, meshEdges));
		assertTrue(compareLists(allVertices, meshVertices));
		assertTrue(polygon.equals(mesh.getPolygons().get(1)));
		/* ------------------------------------------------------------ */

		/* ---- Add a new square with the same bottom-right vertex. ---- */
		// Set up the vertices.
		vertices.set(0, vertices.get(2));
		vertices.set(1, new VertexController(new VertexMesh(2f, 0f, 2f),
				new AbstractView()));
		vertices.set(2, new VertexController(new VertexMesh(2f, 0f, 3f),
				new AbstractView()));
		vertices.set(3, new VertexController(new VertexMesh(1f, 0f, 3f),
				new AbstractView()));
		for (int i = 1; i < 4; i++) {
			allVertices.add(vertices.get(i));
			vertices.get(i).setProperty(MeshProperty.ID,
					Integer.toString(allVertices.size()));
		}
		// Set up the edges.
		for (int i = 0; i < 4; i++) {
			edges.set(i,
					new EdgeController(
							new LinearEdgeMesh(
									(VertexController) vertices.get(i),
									(VertexController) vertices
											.get((i + 1) % 4)),
					new AbstractView()));
			allEdges.add(edges.get(i));
			edges.get(i).setProperty(MeshProperty.ID,
					Integer.toString(allEdges.size()));
		}
		// Initialize the polygon.
		polygon = new NekPolygonController(new NekPolygonMesh(),
				new AbstractView());
		for (IController edge : edges) {
			polygon.addEntityToCategory(edge, MeshCategory.EDGES);
		}
		polygon.setProperty(MeshProperty.ID, "3");
		allShapes.add(polygon);

		// Add the shape and verify the contents of the component.
		mesh.addPolygon(polygon);

		// Get the current lists of edges and vertices from the mesh
		meshEdges = new ArrayList<IController>();
		meshVertices = new ArrayList<IController>();
		for (IController entity : mesh.getPolygons()) {
			meshEdges
					.addAll(entity.getEntitiesFromCategory(MeshCategory.EDGES));
			meshVertices.addAll(
					entity.getEntitiesFromCategory(MeshCategory.VERTICES));
		}

		assertEquals(allShapes, mesh.getPolygons());
		assertTrue(compareLists(allEdges, meshEdges));
		assertTrue(compareLists(allVertices, meshVertices));
		assertEquals(polygon, mesh.getPolygons().get(2));
		/* ------------------------------------------------------------- */

		/* ---- Add a disjoint polygon (attached to nothing). ---- */
		// Set up the vertices.
		vertices.set(0, new VertexController(new VertexMesh(10f, 0, 10f),
				new AbstractView()));
		vertices.set(1, new VertexController(new VertexMesh(11f, 0f, 10f),
				new AbstractView()));
		vertices.set(2, new VertexController(new VertexMesh(11f, 0f, 11f),
				new AbstractView()));
		vertices.set(3, new VertexController(new VertexMesh(10f, 0f, 11f),
				new AbstractView()));
		for (int i = 0; i < 4; i++) {
			allVertices.add(vertices.get(i));
			vertices.get(i).setProperty(MeshProperty.ID,
					Integer.toString(allVertices.size()));
		}
		// Set up the edges.
		for (int i = 0; i < 4; i++) {
			edges.set(i,
					new EdgeController(
							new LinearEdgeMesh(
									(VertexController) vertices.get(i),
									(VertexController) vertices
											.get((i + 1) % 4)),
					new AbstractView()));
			allEdges.add(edges.get(i));
			edges.get(i).setProperty(MeshProperty.ID,
					Integer.toString(allEdges.size()));
		}
		// Initialize the polygon.
		polygon = new NekPolygonController(new NekPolygonMesh(),
				new AbstractView());
		for (IController edge : edges) {
			polygon.addEntityToCategory(edge, MeshCategory.EDGES);
		}
		polygon.setProperty(MeshProperty.ID, "4");
		allShapes.add(polygon);

		// Add the shape and verify the contents of the component.
		mesh.addPolygon(polygon);
		assertEquals(allShapes, mesh.getPolygons());

		// Get the current lists of edges and vertices from the mesh
		meshEdges = new ArrayList<IController>();
		meshVertices = new ArrayList<IController>();
		for (IController entity : mesh.getPolygons()) {
			meshEdges
					.addAll(entity.getEntitiesFromCategory(MeshCategory.EDGES));
			meshVertices.addAll(
					entity.getEntitiesFromCategory(MeshCategory.VERTICES));
		}

		assertTrue(compareLists(allEdges, meshEdges));
		assertTrue(compareLists(allVertices, meshVertices));
		assertEquals(polygon, mesh.getPolygons().get(3));
		/* ------------------------------------------------------- */

		// ---- Check the helper methods. ---- //

		/* ---- Remove the second polygon we added. ---- */
		int nextPolygonId = allShapes.size() + 1;
		int nextEdgeId = allEdges.size() + 1;
		int nextVertexId = allVertices.size() + 1;

		polygon = (NekPolygonController) allShapes.get(1);
		allShapes.remove(polygon);
		// Get the vertices that will be removed.
		vertices.clear();
		vertices.add(
				polygon.getEntitiesFromCategory(MeshCategory.VERTICES).get(3));
		for (IController v : vertices) {
			allVertices.remove(v);
		}
		// Get the edges that will be removed.
		edges.clear();
		edges.add(polygon.getEntitiesFromCategory(MeshCategory.EDGES).get(1));
		edges.add(polygon.getEntitiesFromCategory(MeshCategory.EDGES).get(2));
		edges.add(polygon.getEntitiesFromCategory(MeshCategory.EDGES).get(3));
		for (IController e : edges) {
			allEdges.remove(e);
		}
		// Remove the shape and verify the contents of the component.
		mesh.removePolygon(polygon);
		assertEquals(allShapes, mesh.getPolygons());

		// Get the current edges and vertices
		meshEdges.clear();
		meshVertices.clear();
		for (IController entity : mesh.getPolygons()) {
			meshEdges
					.addAll(entity.getEntitiesFromCategory(MeshCategory.EDGES));
			meshVertices.addAll(
					entity.getEntitiesFromCategory(MeshCategory.VERTICES));
		}

		assertEquals(allEdges, meshEdges);
		assertEquals(allVertices, meshVertices);
		/* --------------------------------------------- */

		/* ---- Remove the third polygon we added. ---- */
		polygon = (NekPolygonController) allShapes.get(1);
		allShapes.remove(polygon);
		// Get the vertices that will be removed.
		for (IController v : polygon
				.getEntitiesFromCategory(MeshCategory.VERTICES)) {
			allVertices.remove(v);
		}
		// Get the edges that will be removed.
		for (IController e : polygon
				.getEntitiesFromCategory(MeshCategory.EDGES)) {
			allEdges.remove(e);
		}

		// Remove the shape and verify the contents of the component.
		mesh.removePolygon(polygon);
		assertEquals(allShapes, mesh.getPolygons());

		// Get the current edges and vertices
		meshEdges.clear();
		meshVertices.clear();
		for (IController entity : mesh.getPolygons()) {
			meshEdges
					.addAll(entity.getEntitiesFromCategory(MeshCategory.EDGES));
			meshVertices.addAll(
					entity.getEntitiesFromCategory(MeshCategory.VERTICES));
		}

		assertEquals(allEdges, meshEdges);
		assertEquals(allVertices, meshVertices);
		/* -------------------------------------------- */

		// TODO - More complicated tests, like overlapping polygons, different
		// references to the same vertex/edge (i.e., vertex1.equals(vertex2),
		// but vertex1 != vertex2), bad IDs.

		return;
	}

	// Reimplement this test if JAXB persistence is ever added to the mesh
	// editor
	// /**
	// * <p>
	// * This operation checks the ability of the MeshComponent to persist
	// itself
	// * to XML and to load itself from an XML input stream.
	// * </p>
	// * @throws IOException
	// * @throws JAXBException
	// * @throws NullPointerException
	// *
	// */
	// @Test
	// public void checkLoadingFromXML() throws NullPointerException,
	// JAXBException, IOException {
	//
	// // Local Declarations
	// ICEJAXBHandler xmlHandler = new ICEJAXBHandler();
	// ArrayList<Class> classList = new ArrayList<Class>();
	// classList.add(MeshComponent.class);
	//
	// // Create a simple polygon to add the the component.
	// ArrayList<Vertex> vertices = new ArrayList<Vertex>();
	// vertices.add(new Vertex( new VertexComponent(0f, 0f, 0f), new
	// AbstractView()));
	// vertices.add(new Vertex( new VertexComponent(1f, 0f, 0f), new
	// AbstractView()));
	// vertices.add(new Vertex( new VertexComponent(0f, 0f, 1f), new
	// AbstractView()));
	// for (int i = 0; i < 3; i++) {
	// vertices.get(i).setProperty("Id", Integer.toString(i + 1));
	// }
	// ArrayList<Edge> edges = new ArrayList<Edge>();
	// for (int i = 0; i < 3; i++) {
	// edges.add(new Edge(new EdgeComponent((Vertex) vertices.get(i), (Vertex)
	// vertices.get((i + 1) % 3)), new AbstractView()));
	// edges.get(i).setProperty("Id", Integer.toString(i + 1));
	// }
	// NekPolygon shape = new NekPolygon(new NekPolygonComponent(), new
	// AbstractView());
	// for(IController edge : edges){
	// shape.addEntity(edge);
	// }
	//
	// // Create a MeshComponent to test.
	// MeshComponent component = new MeshComponent();
	//
	// // Customize it.
	// component.setId(42);
	// component.setName("YAMC");
	// component.setDescription("Yet Another MeshComponent");
	// component.addPolygon(shape);
	// // Load it into XML.
	// ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	// xmlHandler.write(component, classList, outputStream);
	//
	// // Convert the output stream data to an input stream.
	// ByteArrayInputStream inputStream = new ByteArrayInputStream(
	// outputStream.toByteArray());
	//
	// // Load the input stream's contents into a new component.
	// MeshComponent loadedComponent = new MeshComponent();
	// loadedComponent = (MeshComponent) xmlHandler.read(classList,
	// inputStream);
	//
	// // Make sure the two components match.
	// assertTrue(component.equals(loadedComponent));
	//
	// return;
	// }

	/**
	 * <p>
	 * This operation checks the MeshComponent to insure that its equals() and
	 * hashCode() operations work.
	 * </p>
	 * 
	 */
	@Test
	public void checkEquality() {

		// Create a simple polygon to add the the component.
		ArrayList<VertexController> vertices = new ArrayList<VertexController>();
		vertices.add(new VertexController(new VertexMesh(0f, 0f, 0f),
				new AbstractView()));
		vertices.add(new VertexController(new VertexMesh(1f, 0f, 0f),
				new AbstractView()));
		vertices.add(new VertexController(new VertexMesh(0f, 0f, 1f),
				new AbstractView()));
		for (int i = 0; i < 3; i++) {
			vertices.get(i).setProperty(MeshProperty.ID,
					Integer.toString(i + 1));
		}
		ArrayList<EdgeController> edges = new ArrayList<EdgeController>();
		for (int i = 0; i < 3; i++) {
			edges.add(
					new FaceEdgeController(
							new FaceEdgeMesh(vertices.get(i),
									vertices.get((i + 1) % 3)),
							new AbstractView()));
			edges.get(i).setProperty(MeshProperty.ID, Integer.toString(i + 1));
		}
		NekPolygonController polygon = new NekPolygonController(
				new NekPolygonMesh(), new AbstractView());
		for (IController edge : edges) {
			polygon.addEntityToCategory(edge, MeshCategory.EDGES);
		}
		polygon.setProperty(MeshProperty.ID, "1");

		// Initialize objects for testing.
		MeshComponent object = new MeshComponent();
		MeshComponent equalObject = new MeshComponent();
		MeshComponent unequalObject = new MeshComponent();

		// Set up the object and equalObject.
		object.setName("YAMC");
		object.addPolygon(polygon);

		equalObject.setName("YAMC");
		equalObject.addPolygon((NekPolygonController) polygon.clone());

		// Set up the unequalObject.
		unequalObject.setName("YAMC");
		vertices.set(2, new VertexController(new VertexMesh(0f, 0f, 2f),
				new AbstractView()));
		vertices.get(2).setProperty(MeshProperty.ID, "3");
		for (int i = 1; i < 3; i++) {
			edges.set(i,
					new FaceEdgeController(
							new FaceEdgeMesh(vertices.get(i),
									vertices.get((i + 1) % 3)),
							new AbstractView()));
			edges.get(i).setProperty(MeshProperty.ID, Integer.toString(i + 1));
		}
		polygon = new NekPolygonController(new NekPolygonMesh(),
				new AbstractView());
		for (IController edge : edges) {
			polygon.addEntityToCategory(edge, MeshCategory.EDGES);
		}
		polygon.setProperty(MeshProperty.ID, "1");
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
	}

	/**
	 * <p>
	 * This operation checks the MeshComponent to ensure that its copy() and
	 * clone() operations work as specified.
	 * </p>
	 * 
	 */
	@Test
	public void checkCopying() {

		/*
		 * 
		 * The mesh should look like two triangles that form a square of area 1.
		 * 
		 * After the copy, we make sure the references in the copy are set up
		 * correctly by changing the top-right and bottom-left vertices in the
		 * copy to form a 30-60-90 triangle with sides of length 3-4-5.
		 */

		// Create a simple polygon to add the the component.
		ArrayList<VertexController> vertices = new ArrayList<VertexController>();
		vertices.add(new VertexController(new VertexMesh(0f, 0f, 0f),
				new AbstractView()));
		vertices.add(new VertexController(new VertexMesh(1f, 0f, 0f),
				new AbstractView()));
		vertices.add(new VertexController(new VertexMesh(0f, 0f, 1f),
				new AbstractView()));
		for (int i = 0; i < 3; i++) {
			vertices.get(i).setProperty(MeshProperty.ID,
					Integer.toString(i + 1));
		}
		ArrayList<EdgeController> edges = new ArrayList<EdgeController>();
		for (int i = 0; i < 3; i++) {
			edges.add(
					new EdgeController(
							new LinearEdgeMesh(vertices.get(i),
									vertices.get((i + 1) % 3)),
							new AbstractView()));
			edges.get(i).setProperty(MeshProperty.ID, Integer.toString(i + 1));
		}
		NekPolygonController shape = new NekPolygonController(
				new NekPolygonMesh(), new AbstractView());
		for (IController edge : edges) {
			shape.addEntityToCategory(edge, MeshCategory.EDGES);
		}
		shape.setProperty(MeshProperty.ID, "1");

		vertices.set(0, vertices.get(1));
		vertices.set(1, vertices.get(2));
		vertices.set(2, new VertexController(new VertexMesh(1f, 0f, 1f),
				new AbstractView()));
		vertices.get(2).setProperty(MeshProperty.ID, "4");
		edges.set(0, edges.get(1));
		for (int i = 1; i < 3; i++) {
			edges.set(i,
					new EdgeController(
							new LinearEdgeMesh(vertices.get(i),
									vertices.get((i + 1) % 3)),
							new AbstractView()));
			edges.get(i).setProperty(MeshProperty.ID, Integer.toString(i + 3));
		}
		NekPolygonController shape2 = new NekPolygonController(
				new NekPolygonMesh(), new AbstractView());
		for (IController edge : edges) {
			shape2.addEntityToCategory(edge, MeshCategory.EDGES);
		}
		shape2.setProperty(MeshProperty.ID, "2");

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
		for (IController polygon : object.getPolygons()) {
			for (EdgeController edge : polygon.getEntitiesFromCategory(
					MeshCategory.EDGES, EdgeController.class)) {
				switch (edge.getProperty(MeshProperty.ID)) {
				case "1":
					assertEquals(1f, edge.getLength(), 1e-7f);
					break;

				case "2":
					assertEquals(Math.sqrt(2), edge.getLength(), 1e-7f);
					break;

				case "3":
					assertEquals(1f, edge.getLength(), 1e-7f);
					break;

				default:
					break;
				}
			}
		}

		// The same dimensions apply to the copy.
		for (IController polygon : copy.getPolygons()) {
			for (EdgeController edge : polygon.getEntitiesFromCategory(
					MeshCategory.EDGES, EdgeController.class)) {
				switch (edge.getProperty(MeshProperty.ID)) {
				case "1":
					assertEquals(1f, edge.getLength(), 1e-7f);
					break;

				case "2":
					assertEquals(Math.sqrt(2), edge.getLength(), 1e-7f);
					break;

				case "3":
					assertEquals(1f, edge.getLength(), 1e-7f);
					break;

				default:
					break;
				}
			}
		}

		// Create listeners for the edges in the copy to make sure they were all
		// updated.
		List<TestComponentListener> listeners = new ArrayList<TestComponentListener>();
		for (IController edge : copy.getPolygons().get(0)
				.getEntitiesFromCategory(MeshCategory.EDGES)) {
			TestComponentListener listener = new TestComponentListener();
			edge.register(listener);
			listeners.add(listener);
		}

		for (IController vertex : copy.getPolygons().get(0)
				.getEntitiesFromCategory(MeshCategory.VERTICES)) {
			if ("2".equals(vertex.getProperty(MeshProperty.ID))) {
				((VertexController) vertex).updateLocation(3f, 0f, 0f);
			} else if ("3".equals(vertex.getProperty(MeshProperty.ID))) {
				((VertexController) vertex).updateLocation(0f, 0f, 4f);
			}
		}

		// The first triangle should still be an isosceles right triangle.
		for (IController polygon : object.getPolygons()) {
			for (EdgeController edge : polygon.getEntitiesFromCategory(
					MeshCategory.EDGES, EdgeController.class)) {
				switch (edge.getProperty(MeshProperty.ID)) {
				case "1":
					assertEquals(1f, edge.getLength(), 1e-7f);
					break;

				case "2":
					assertEquals(Math.sqrt(2), edge.getLength(), 1e-7f);
					break;

				case "3":
					assertEquals(1f, edge.getLength(), 1e-7f);
					break;

				default:
					break;
				}
			}
		}

		// Make sure the edges in the copy's first triangle were updated.
		for (int i = 0; i < 3; i++) {
			assertTrue(listeners.get(i).wasNotified());
			listeners.get(i).reset();
		}

		// The copy's first triangle should now be a 3-4-5 triangle.
		for (EdgeController edge : copy.getPolygons().get(0)
				.getEntitiesFromCategory(MeshCategory.EDGES,
						EdgeController.class)) {
			switch (edge.getProperty(MeshProperty.ID)) {
			case "1":
				assertEquals(1f, edge.getLength(), 1e-7f);
				break;

			case "2":
				assertEquals(1.4142135, edge.getLength(), 1e-7f);
				break;

			case "3":
				assertEquals(1f, edge.getLength(), 1e-7f);
				break;

			default:
				break;
			}
		}

		return;
	}

	/**
	 * Compares two ArrayLists to check them for equality.
	 * 
	 * @param first
	 * @param second
	 * @return True if the lists contain the same set of objects, false
	 *         otherwise
	 */
	public <T, U> boolean compareLists(ArrayList<T> first,
			ArrayList<U> second) {

		// Check that each object in the first list is in the second
		for (T object : first) {
			if (!second.contains(object)) {
				return false;
			}
		}

		// Check that each object in the second list is in the first
		for (U object : second) {
			if (!first.contains(object)) {
				return false;
			}
		}

		// If no discrepancies were found, the lists must be equal
		return true;
	}
}