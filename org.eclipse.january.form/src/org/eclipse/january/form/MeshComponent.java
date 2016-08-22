/*******************************************************************************
 * Copyright (c) 2014, 2016 UT-Battelle, LLC.
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
package org.eclipse.january.form;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.eavp.viz.datastructures.VizObject.IManagedUpdateable;
import org.eclipse.eavp.viz.datastructures.VizObject.IManagedUpdateableListener;
import org.eclipse.eavp.viz.datastructures.VizObject.SubscriptionType;
import org.eclipse.eavp.viz.modeling.FaceController;
import org.eclipse.eavp.viz.modeling.base.BasicController;
import org.eclipse.eavp.viz.modeling.base.BasicMesh;
import org.eclipse.eavp.viz.modeling.base.BasicView;
import org.eclipse.eavp.viz.modeling.base.IController;
import org.eclipse.eavp.viz.service.IVizService;
import org.eclipse.eavp.viz.service.mesh.datastructures.MeshDescription;

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
@XmlAccessorType(XmlAccessType.NONE)
public class MeshComponent extends ICEObject
		implements Component, IManagedUpdateableListener {

	/**
	 * A compressed description of the mesh, used for persistence
	 */
	private MeshDescription compressedMesh;

	/**
	 * The wrapped VizMeshComponent.
	 */
	private BasicController mesh;

	/**
	 * The next free ID to assign to a Polygon.
	 */
	private int nextPolygonID = 1;

	/**
	 * The next free ID to assign to an Edge.
	 */
	private int nextEdgeID = 1;

	/**
	 * The next free ID to assign to a Vertex.
	 */
	private int nextVertexID = 1;

	/**
	 * The service which will be rendering this component.
	 */
	private IVizService service;

	/**
	 * <p>
	 * The default constructor for a MeshComponent. Initializes the list of
	 * polygons and any associated bookkeeping structures.
	 * </p>
	 * 
	 */
	public MeshComponent() {
		super();

		// Initialize the data members
		mesh = new BasicController(new BasicMesh(), new BasicView());
		mesh.register(this);
		compressedMesh = null;
		service = null;
		return;
	}

	/**
	 * Getter method for the wrapped VizMeshComponent
	 * 
	 * @return The wrapped VizMeshComponent
	 */
	public IController getMesh() {
		return mesh;
	}

	/**
	 * Setter method for the wrapped VizMeshComponent
	 * 
	 * @param newMesh
	 *            The new mesh to hold
	 */
	public void setMesh(BasicController newMesh) {
		mesh = newMesh;
		mesh.register(this);
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
	public void addPolygon(FaceController polygon) {
		mesh.addEntity(polygon);
		notifyListeners();

		return;
	}

	/**
	 * Remove the given polygon from the MeshComponent.
	 * 
	 * @param polygon
	 *            The polygon to be removed from the list.
	 */
	public void removePolygon(FaceController polygon) {
		mesh.removeEntity(polygon);
		notifyListeners();
	}

	/**
	 * Returns the component's mesh, compressed into a MeshDescription for easy
	 * use in persistence for JAXB.
	 * 
	 * This function exists for use by JAXB and is not intended to be called.
	 * 
	 * @return
	 */
	@XmlElement
	private MeshDescription getCompressedMesh() {
		return new MeshDescription(mesh);
	}

	/**
	 * <p>
	 * Gets a list of all polygons stored in the MeshComponent ordered by their
	 * IDs.
	 * </p>
	 * 
	 * @return
	 *         <p>
	 *         A list of polygons contained in this MeshComponent.
	 *         </p>
	 */
	public List<IController> getPolygons() {
		return mesh.getEntities();
	}

	/**
	 * <p>
	 * Returns the next available ID for polygons.
	 * </p>
	 * 
	 * @return
	 *         <p>
	 *         The greatest polygon ID (or zero) plus one.
	 *         </p>
	 */
	public int getNextPolygonId() {

		// Increment the next polygon id then return its original value
		int temp = nextPolygonID;
		nextPolygonID++;
		return temp;
	}

	/**
	 * <p>
	 * Returns the next available ID for vertices.
	 * </p>
	 * 
	 * @return
	 *         <p>
	 *         The greatest vertex ID (or zero) plus one.
	 *         </p>
	 */
	public int getNextVertexId() {

		// Increment the next polygon id then return its original value
		int temp = nextVertexID;
		nextVertexID++;
		return temp;
	}

	/**
	 * <p>
	 * Returns the next available ID for edges.
	 * </p>
	 * 
	 * @return
	 *         <p>
	 *         The greatest edge ID (or zero) plus one.
	 *         </p>
	 */
	public int getNextEdgeId() {

		// Increment the next edge id then return its original value
		int temp = nextEdgeID;
		nextEdgeID++;
		return temp;
	}

	/**
	 * Sets the component's contents based on the compressed form of a
	 * MeshDescription.
	 * 
	 * This function is intended for use by JAXB for persistence and is not
	 * intended for use.
	 * 
	 * @param description
	 *            The compressed description the component's new data.
	 */
	private void setCompressedMesh(MeshDescription description) {
		compressedMesh = description;
	}

	/**
	 * Setter method for the service being used to render this component.
	 * 
	 * @param service
	 *            The service providing the rendering support used to view this
	 *            component's contents.
	 */
	public void setService(IVizService service) {
		this.service = service;

		// If a persisted mesh has been loaded into the component, we can now
		// unpack it
		if (compressedMesh != null) {

			mesh = (BasicController) compressedMesh
					.unpack(service.getControllerProviderFactory());
			mesh.register(this);

			// The full mesh is now in memory, so delete the compressed version
			compressedMesh = null;
		}
	}

	/**
	 * <p>
	 * This operation returns the hash value of the MeshComponent.
	 * </p>
	 * 
	 * @return
	 *         <p>
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
	 * @return
	 *         <p>
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
	 * @return
	 *         <p>
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
	 * Notify all listeners that a change has occurred, providing them with the
	 * given component as the source.
	 * 
	 * @param component
	 *            The object to serve as the source of the update.
	 */
	private void notifyListeners(IUpdateable component) {

		// Only process the update if there are listeners
		if (listeners != null && !listeners.isEmpty()) {
			// Create a thread on which to notify the listeners.
			Thread notifierThread = new Thread() {
				@Override
				public void run() {
					// Loop over all listeners and update them
					for (int i = 0; i < listeners.size(); i++) {
						listeners.get(i).update(component);
					}
					return;
				}
			};

			// Launch the thread and do the notifications
			notifierThread.start();
		}

		return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.eavp.viz.service.datastructures.VizObject.
	 * IManagedVizUpdateableListener#update(org.eclipse.eavp.viz.service.
	 * datastructures.VizObject.IManagedVizUpdateable,
	 * org.eclipse.eavp.viz.service.datastructures.VizObject.
	 * UpdateableSubscriptionType[])
	 */
	@Override
	public void update(IManagedUpdateable component, SubscriptionType[] types) {

		// If something other than a property changed, then notify the listeners
		// as normal
		if (types.length != 1 || !SubscriptionType.PROPERTY.equals(types[0])) {

			// Notify own listeners of the change
			notifyListeners();
		}

		// If only a property changed, send a new ICEObject as a special signal
		// that the MeshComponent should not necessarily be considered as
		// updated, leaving it to the listener to check if the meshcomponent is
		// equal to the source in case sepcial behavior is required.
		else {
			notifyListeners(new ICEObject());
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.eavp.viz.service.datastructures.VizObject.
	 * IManagedVizUpdateableListener#getSubscriptions(org.eclipse.eavp.viz.
	 * service.datastructures.VizObject.IVizUpdateable)
	 */
	@Override
	public ArrayList<SubscriptionType> getSubscriptions(
			IManagedUpdateable source) {

		// Register to listen when a part is added/removed/moved or when a
		// property is changed
		ArrayList<SubscriptionType> types = new ArrayList<SubscriptionType>();
		types.add(SubscriptionType.CHILD);
		types.add(SubscriptionType.PROPERTY);
		types.add(SubscriptionType.TRANSFORMATION);
		return types;
	}

}