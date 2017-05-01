/*******************************************************************************
 * Copyright (c) 2012, 2016 UT-Battelle, LLC.
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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.january.geometry.Geometry;
import org.eclipse.january.geometry.GeometryFactory;

/**
 * <p>
 * Composite container for a Geometry along with any additional information
 * required to interpret the geometry data
 * </p>
 *
 * @author Jay Jay Billings
 */
@XmlRootElement(name = "GeometryComponent")
@XmlAccessorType(XmlAccessType.FIELD)
public class GeometryComponent extends JanuaryObject
		implements Component, IUpdateableListener {

	/**
	 * <p>
	 * The set of ComponentListeners observing the GeometryComponent
	 * </p>
	 *
	 */
	@XmlTransient
	private ArrayList<IUpdateableListener> listeners;

	/**
	 * The Geometry managed by the GeometryComponent
	 */
	@XmlTransient
	private Geometry geometry;

	/**
	 * <p>
	 * This operation overrides the JanuaryObject.setName() operation and provides
	 * an update notification in addition to setting the name.
	 * </p>
	 *
	 * @param name
	 *            <p>
	 *            The new JanuaryObject ID
	 *            </p>
	 */
	@Override
	public void setName(String name) {

		// Call JanuaryObject::setName
		super.setName(name);

		// Notify listeners
		notifyListeners();

	}

	/**
	 * <p>
	 * This operation overrides the JanuaryObject.setId() operation and provides an
	 * update notification in addition to setting the id.
	 * </p>
	 *
	 * @param id
	 *            <p>
	 *            The new JanuaryObject ID
	 *            </p>
	 */
	@Override
	public void setId(int id) {

		// Call JanuaryObject::setId
		super.setId(id);

		// Notify listeners
		notifyListeners();

	}

	/**
	 * <p>
	 * Creates an empty Geometry and list of IShapes and ComponentListeners
	 * </p>
	 *
	 */
	public GeometryComponent() {

		// Create a new Geometry and register as its listener.
		// ShapeComponent model = new ShapeComponent();
		// TODO Get the right factory from a service, instead of hard coding
		// IControllerFactory factory = new JME3ControllerFactory();
		// geometry = (Shape) factory.createController(model);
		// geometry.register(this);

		// Create a new listeners list
		listeners = new ArrayList<IUpdateableListener>();

		// Initialize the geometry
		geometry = GeometryFactory.eINSTANCE.createGeometry();
	}

	/**
	 * Accessor method for the held Geometry.
	 *
	 * @return The held Geometry
	 */
	public Geometry getGeometry() {
		return geometry;
	}

	/**
	 * Mutator method for the held geometry
	 *
	 * @param newGeometry
	 *            the new Geometry to hold
	 */
	public void setGeometry(Geometry newGeometry) {
		geometry = newGeometry;

		// Register self as a listener for the geometry
		geometry.eAdapters().add(new AdapterImpl() {

			@Override
			public void notifyChanged(Notification notification) {
				notifyListeners();
			}
		});

		// Notify listeners
		notifyListeners();
	}

	/**
	 * <p>
	 * This operation returns the hashcode value of the GeometryComponent.
	 * </p>
	 *
	 * @return
	 *         <p>
	 *         The hashcode of the JanuaryObject.
	 *         </p>
	 */
	@Override
	public int hashCode() {

		// Return the JanuaryObject's hashcode
		int hash = super.hashCode();

		return hash;

	}

	/**
	 * <p>
	 * This operation is used to check equality between this GeometryComponent
	 * and another GeometryComponent. It returns true if the GeometryComponents
	 * are equal and false if they are not.
	 * </p>
	 *
	 * @param otherObject
	 *            <p>
	 *            The other JanuaryObject that should be compared with this one.
	 *            </p>
	 * @return
	 *         <p>
	 *         True if the JanuaryObjects are equal, false otherwise.
	 *         </p>
	 */
	@Override
	public boolean equals(Object otherObject) {

		// Check if a similar reference
		if (this == otherObject) {
			return true;
		}
		// Check that the other object is not null and an instance of the
		// GeometryComponent
		if (otherObject == null
				|| !(otherObject instanceof GeometryComponent)) {
			return false;
		}
		// Check that these objects have the same JanuaryObject data
		if (!super.equals(otherObject)) {
			return false;
		}
		// At this point, other object must be a PrimitiveShape, so cast it
		GeometryComponent geometryComponent = (GeometryComponent) otherObject;

		// Check for equal number of shapes in shapes list
		if (!this.geometry.equals(geometryComponent.geometry)) {
			return false;
		}

		// The two shapes are equal
		return true;

	}

	/**
	 * <p>
	 * This operation copies the contents of a GeometryComponent into the
	 * current object using a deep copy.
	 * </p>
	 *
	 * @param JanuaryObject
	 *            <p>
	 *            The JanuaryObject from which the values should be copied
	 *            </p>
	 */
	public void copy(GeometryComponent JanuaryObject) {

		// Return if object is null
		if (JanuaryObject == null) {
			return;
		}
		// Copy the JanuaryObject data
		super.copy(JanuaryObject);

		// Copy shapes list
		Geometry otherGeometry = JanuaryObject.getGeometry();
		if (otherGeometry != null) {
			this.setGeometry((Geometry) otherGeometry.clone());
		} else {
			geometry = null;
		}
		this.notifyListeners();

	}

	/**
	 * <p>
	 * This operation returns a clone of the GeometryComponent using a deep
	 * copy.
	 * </p>
	 *
	 * @return
	 *         <p>
	 *         The new clone
	 *         </p>
	 */
	@Override
	public Object clone() {

		// Instantiate GeometryComponent
		GeometryComponent geometryComponent = new GeometryComponent();

		// Return the copied GeometryComponent
		geometryComponent.copy(this);
		return geometryComponent;

	}

	/**
	 * <p>
	 * Notifies all IUpdateableListeners in the listener list that an event has
	 * occurred which has changed the state of this GeometryComponent
	 * </p>
	 *
	 */
	@Override
	protected void notifyListeners() {

		final GeometryComponent geometryComponent = this;

		// If the listeners are empty, return
		if (this.listeners == null || this.listeners.isEmpty()) {
			return;
		}
		// Create a thread object that notifies all listeners

		// Thread notifyThread = new Thread() {
		//
		// @Override
		// public void run() {
		// // Loop over all listeners and update them
		for (int i = 0; i < listeners.size(); i++) {
			listeners.get(i).update(geometryComponent);
		}
		// }
		// };

		// Start the thread
		// notifyThread.start();

	}

	/**
	 * (non-Javadoc)
	 *
	 * @see IUpdateable#update(String updatedKey, String newValue)
	 */
	@Override
	public void update(String updatedKey, String newValue) {
		// Not implemented
	}

	/**
	 * (non-Javadoc)
	 *
	 * @see Component#register(IUpdateableListener listener)
	 */
	@Override
	public void register(IUpdateableListener listener) {

		// Fail silently if listener is null
		if (listener == null) {
			return;
		}
		// Add listener to listeners list
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}

	/**
	 * (non-Javadoc)
	 *
	 * @see Component#accept(IComponentVisitor visitor)
	 */
	@Override
	public void accept(IComponentVisitor visitor) {

		// Call the visitor's visit operation
		visitor.visit(this);

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.ice.datastructures.JanuaryObject.IUpdateableListener#update(org.
	 * eclipse.ice.datastructures.JanuaryObject.IUpdateable)
	 */
	@Override
	public void update(IUpdateable component) {

		// If the component is an IShape, we're receiving an event from one of
		// our Geometry's children.
		notifyListeners();
	}

}