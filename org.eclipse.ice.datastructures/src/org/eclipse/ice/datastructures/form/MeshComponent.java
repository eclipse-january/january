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
package org.eclipse.ice.datastructures.form;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.ice.datastructures.ICEObject.Component;
import org.eclipse.ice.datastructures.ICEObject.ICEObject;
import org.eclipse.ice.datastructures.componentVisitor.IComponentVisitor;
import org.eclipse.ice.viz.service.datastructures.IVizUpdateable;
import org.eclipse.ice.viz.service.datastructures.IVizUpdateableListener;
import org.eclipse.ice.viz.service.mesh.datastructures.Edge;
import org.eclipse.ice.viz.service.mesh.datastructures.IMeshPart;
import org.eclipse.ice.viz.service.mesh.datastructures.IMeshPartVisitor;
import org.eclipse.ice.viz.service.mesh.datastructures.Polygon;
import org.eclipse.ice.viz.service.mesh.datastructures.Vertex;
import org.eclipse.ice.viz.service.mesh.datastructures.VizMeshComponent;

/**
 * <p>
 * A wrapper class for a VizMeshComponent. It provides all the functionality of
 * a VizMeshComponent, but delegates to a wrapped VizMeshComponent for all
 * actual implementations.
 * </p>
 * 
 * @author Jordan H. Deyton
 * @author Robert Smith
 */
@XmlRootElement(name = "MeshComponent")
@XmlAccessorType(XmlAccessType.FIELD)
public class MeshComponent extends ICEObject implements Component, IMeshPart,
		IVizUpdateableListener {

	/**
	 * The wrapped VizMeshComponent.
	 */
	private VizMeshComponent mesh;

	/**
	 * <p>
	 * The default constructor for a MeshComponent. Initializes the list of
	 * polygons and any associated bookkeeping structures.
	 * </p>
	 * 
	 */
	public MeshComponent() {
		super();
		mesh = new VizMeshComponent();
		mesh.register(this);
		return;
	}

	/**
	 * Getter method for the wrapped VizMeshComponent
	 * 
	 * @return The wrapped VizMeshComponent
	 */
	public VizMeshComponent getMesh() {
		return mesh;
	}

	/**
	 * Setter method for the wrapped VizMeshComponent
	 * 
	 * @param newMesh
	 *            The new mesh to hold
	 */
	public void setMesh(VizMeshComponent newMesh) {
		mesh = newMesh;
	}

	/**
	 * <p>
	 * Adds a polygon to the MeshComponent. The polygon is expected to have a
	 * unique polygon ID. If the polygon can be added, a notification is sent to
	 * listeners. If the polygon uses equivalent vertices or edges with
	 * different references, then a new polygon is created with references to
	 * the vertices and edges already known by this MeshComponent.
	 * </p>
	 * 
	 * @param polygon
	 *            <p>
	 *            The new polygon to add to the existing list.
	 *            </p>
	 */
	public void addPolygon(Polygon polygon) {
		mesh.addPolygon(polygon);
		notifyListeners();

		return;
	}

	/**
	 * <p>
	 * Removes a polygon from the MeshComponent. This will also remove any
	 * vertices and edges used only by this polygon. If a polygon was removed, a
	 * notification is sent to listeners.
	 * </p>
	 * 
	 * @param id
	 *            <p>
	 *            The ID of the polygon to remove from the existing list.
	 *            </p>
	 */
	public void removePolygon(int id) {
		mesh.removePolygon(id);
		notifyListeners();

		return;
	}

	/**
	 * <p>
	 * Removes a list polygons from the MeshComponent. This will also remove any
	 * vertices and edges used by these polygons. If a polygon was removed, a
	 * notification is sent to listeners.
	 * </p>
	 * 
	 * @param ids
	 *            <p>
	 *            An ArrayList containing the IDs of the polygons to remove from
	 *            the MeshComponent.
	 *            </p>
	 */
	public void removePolygons(ArrayList<Integer> ids) {
		mesh.removePolygons(ids);
		notifyListeners();
		return;
	}

	/**
	 * <p>
	 * Gets a list of all polygons stored in the MeshComponent ordered by their
	 * IDs.
	 * </p>
	 * 
	 * @return <p>
	 *         A list of polygons contained in this MeshComponent.
	 *         </p>
	 */
	public ArrayList<Polygon> getPolygons() {
		return mesh.getPolygons();
	}

	/**
	 * <p>
	 * Gets a Polygon instance corresponding to an ID.
	 * </p>
	 * 
	 * @param id
	 *            <p>
	 *            The ID of the polygon.
	 *            </p>
	 * @return <p>
	 *         The polygon referred to by the ID, or null if there is no polygon
	 *         with the ID.
	 *         </p>
	 */
	public Polygon getPolygon(int id) {
		return mesh.getPolygon(id);
	}

	/**
	 * <p>
	 * Returns the next available ID for polygons.
	 * </p>
	 * 
	 * @return <p>
	 *         The greatest polygon ID (or zero) plus one.
	 *         </p>
	 */
	public int getNextPolygonId() {
		return mesh.getNextPolygonId();
	}

	/**
	 * <p>
	 * Sets the list of all polygons stored in the MeshComponent.
	 * </p>
	 * 
	 * @param polygons
	 *            <p>
	 *            The list of polygons to replace the existing list of polygons
	 *            in the MeshComponent.
	 *            </p>
	 */
	public void setPolygons(ArrayList<Polygon> polygons) {
		mesh.setPolygons(polygons);
	}

	/**
	 * <p>
	 * Gets a list of all vertices associated with this MeshComponent.
	 * </p>
	 * 
	 * @return <p>
	 *         All vertices managed by this MeshComponent.
	 *         </p>
	 */
	public ArrayList<Vertex> getVertices() {
		return mesh.getVertices();
	}

	/**
	 * <p>
	 * Gets a Vertex instance corresponding to an ID.
	 * </p>
	 * 
	 * @param id
	 *            <p>
	 *            The ID of the vertex.
	 *            </p>
	 * @return <p>
	 *         The vertex referred to by the ID, or null if the ID is invalid.
	 *         </p>
	 */
	public Vertex getVertex(int id) {
		return mesh.getVertex(id);
	}

	/**
	 * <p>
	 * Returns the next available ID for vertices.
	 * </p>
	 * 
	 * @return <p>
	 *         The greatest vertex ID (or zero) plus one.
	 *         </p>
	 */
	public int getNextVertexId() {
		return mesh.getNextVertexId();
	}

	/**
	 * <p>
	 * Gets a list of all edges associated with this MeshComponent.
	 * </p>
	 * 
	 * @return <p>
	 *         All edges managed by this MeshComponent.
	 *         </p>
	 */
	public ArrayList<Edge> getEdges() {
		return mesh.getEdges();
	}

	/**
	 * <p>
	 * Gets an Edge instance corresponding to an ID.
	 * </p>
	 * 
	 * @param id
	 *            <p>
	 *            The ID of the edge.
	 *            </p>
	 * @return <p>
	 *         The edge referred to by the ID, or null if the ID is invalid.
	 *         </p>
	 */
	public Edge getEdge(int id) {
		return mesh.getEdge(id);
	}

	/**
	 * <p>
	 * Returns the next available ID for edges.
	 * </p>
	 * 
	 * @return <p>
	 *         The greatest edge ID (or zero) plus one.
	 *         </p>
	 */
	public int getNextEdgeId() {
		return mesh.getNextEdgeId();
	}

	/**
	 * <p>
	 * Returns a list of Edges attached to the Vertex with the specified ID.
	 * </p>
	 * 
	 * @param id
	 *            <p>
	 *            The ID of the vertex.
	 *            </p>
	 * @return <p>
	 *         An ArrayList of Edges that are attached to the vertex with the
	 *         specified ID. If there are no such edges, e.g., if the vertex ID
	 *         is invalid, the list will be empty.
	 *         </p>
	 */
	public ArrayList<Edge> getEdgesFromVertex(int id) {
		return getEdgesFromVertex(id);
	}

	/**
	 * <p>
	 * Returns a list of Polygons containing the Vertex with the specified ID.
	 * </p>
	 * 
	 * @param id
	 *            <p>
	 *            The ID of the vertex.
	 *            </p>
	 * @return <p>
	 *         An ArrayList of Polygons that contain the vertex with the
	 *         specified ID. If there are no such polygons, e.g., if the vertex
	 *         ID is invalid, the list will be empty.
	 *         </p>
	 */
	public ArrayList<Polygon> getPolygonsFromVertex(int id) {
		return mesh.getPolygonsFromVertex(id);
	}

	/**
	 * <p>
	 * Returns a list of Polygons containing the Edge with the specified ID.
	 * </p>
	 * 
	 * @param id
	 *            <p>
	 *            The ID of the edge.
	 *            </p>
	 * @return <p>
	 *         An ArrayList of Polygons that contain the edge with the specified
	 *         ID. If there are no such polygons, e.g., if the edge ID is
	 *         invalid, the list will be empty.
	 *         </p>
	 */
	public ArrayList<Polygon> getPolygonsFromEdge(int id) {
		return mesh.getPolygonsFromEdge(id);
	}

	/**
	 * <p>
	 * Returns an Edge that connects two specified vertices if one exists.
	 * </p>
	 * 
	 * @param firstId
	 *            <p>
	 *            The ID of the first vertex.
	 *            </p>
	 * @param secondId
	 *            <p>
	 *            The ID of the second vertex.
	 *            </p>
	 * 
	 * @return <p>
	 *         An Edge instance that connects the first and second vertices, or
	 *         null if no such edge exists.
	 *         </p>
	 */
	public Edge getEdgeFromVertices(int firstId, int secondId) {
		return mesh.getEdgeFromVertices(firstId, secondId);

	}

	/**
	 * <p>
	 * Returns a list containing all Polygons in the MeshComponent whose
	 * vertices are a subset of the supplied list of vertices.
	 * </p>
	 * 
	 * @param vertices
	 *            <p>
	 *            A collection of vertices.
	 *            </p>
	 * @return <p>
	 *         An ArrayList of all Polygons in the MeshComponent that are
	 *         composed of some subset of the specified vertices.
	 *         </p>
	 */
	public ArrayList<Polygon> getPolygonsFromVertices(ArrayList<Vertex> vertices) {
		return mesh.getPolygonsFromVertices(vertices);

	}

	/**
	 * <p>
	 * This operation returns the hash value of the MeshComponent.
	 * </p>
	 * 
	 * @return <p>
	 *         The hashcode of the ICEObject.
	 *         </p>
	 */
	@Override
	public int hashCode() {
		return mesh.hashCode();
	}

	/**
	 * <p>
	 * This operation is used to check equality between this MeshComponent and
	 * another MeshComponent. It returns true if the MeshComponents are equal
	 * and false if they are not.
	 * </p>
	 * 
	 * @param otherObject
	 *            <p>
	 *            The other ICEObject that should be compared with this one.
	 *            </p>
	 * @return <p>
	 *         True if the ICEObjects are equal, false otherwise.
	 *         </p>
	 */
	@Override
	public boolean equals(Object otherObject) {

		// By default, the objects are not equivalent.
		boolean equals = false;

		// Check the reference.
		if (this == otherObject) {
			equals = true;
		}
		// Check the information stored in the other object.
		else if (otherObject != null && otherObject instanceof MeshComponent) {

			// We can now cast the other object.
			MeshComponent component = (MeshComponent) otherObject;

			// Compare the values between the two objects.
			equals = (super.equals(otherObject) && mesh.equals(component.mesh));
			// The polygons are the only defining feature of the MeshComponent
			// (aside from the super properties). If the polygon lists are
			// equivalent, we can safely expect the other bookkeeping structures
			// are identical.
		}

		return equals;
	}

	/**
	 * <p>
	 * This operation copies the contents of a MeshComponent into the current
	 * object using a deep copy.
	 * </p>
	 * 
	 * @param component
	 *            <p>
	 *            The ICEObject from which the values should be copied
	 *            </p>
	 */
	public void copy(MeshComponent component) {

		// Check the parameters.
		if (component != null) {
			super.copy(component);
			mesh.copy(component.mesh);
			notifyListeners();
		}

		return;
	}

	/**
	 * <p>
	 * This operation returns a clone of the MeshComponent using a deep copy.
	 * </p>
	 * 
	 * @return <p>
	 *         The new clone
	 *         </p>
	 */
	@Override
	public Object clone() {

		// Initialize a new object.
		MeshComponent object = new MeshComponent();

		// Copy the contents from this one.
		object.copy(this);
		// Return the newly instantiated object.
		return object;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Component#accept(IComponentVisitor visitor)
	 */
	@Override
	public void accept(IComponentVisitor visitor) {

		// Call the visitor's visit(MeshComponent) method.
		if (visitor != null) {
			visitor.visit(this);
		}
		return;
	}

	/**
	 * <p>
	 * This method calls the {@link IMeshPartVisitor}'s visit method.
	 * </p>
	 * 
	 * @param visitor
	 *            <p>
	 *            The {@link IMeshPartVisitor} that is visiting this
	 *            {@link IMeshPart}.
	 *            </p>
	 */
	@Override
	public void acceptMeshVisitor(IMeshPartVisitor visitor) {
		if (visitor != null) {
			visitor.visit(this);
		}
		return;
	}

	@Override
	public void update(IVizUpdateable component) {
		notifyListeners();
		
	}



}