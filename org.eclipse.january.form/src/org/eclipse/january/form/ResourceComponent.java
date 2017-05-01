/*******************************************************************************
 * Copyright (c) 2012, 2016- UT-Battelle, LLC.
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

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The ResourceComponent is a specialization of ListComponent that is used to
 * manage a set of JanuaryResources. It is used, for example, to collect Resources
 * for output data on a Form. JanuaryResources can be very easily added to
 * ResourceComponents by calling the addResource() operation and the whole list
 * of managed JanuaryResources can be retrieved with getResources().
 *
 *
 * 
 * @author Jay Jay Billings, Anna Wojtowicz
 */
@XmlRootElement(name = "ResourceComponent")
public class ResourceComponent extends ListComponent<JanuaryResource> {

	/**
	 * The set of IUpdateableListeners observing the ResourceComponent.
	 */
	@XmlTransient
	protected ArrayList<IUpdateableListener> listeners;

	/**
	 * The constructor.
	 */
	public ResourceComponent() {

		// Setup the listeners list
		listeners = new ArrayList<IUpdateableListener>();

		return;
	}

	/**
	 * This operation adds an JanuaryResource to the component.
	 * 
	 * @param resource
	 *            The new resource to add.
	 */
	public void addResource(JanuaryResource resource) {

		// Add the resource if it is good
		if (resource != null) {
			this.add(resource);
		}

		return;
	}

	/**
	 * This operation gets all of the JanuaryResources from the component.
	 * 
	 * @return The list of JanuaryResources contained by the ResourceComponent.
	 */
	public ArrayList<JanuaryResource> getResources() {
		return new ArrayList<JanuaryResource>(this);
	}

	/**
	 * An operation that clears all the JanuaryResources stored on the
	 * ResourceComponent. If there are no items in the list, this operation does
	 * nothing.
	 */
	public void clearResources() {
		this.clear();
		return;
	}

	/**
	 * This operation provides a deep copy of the ResourceComponent.
	 * 
	 * @return The clone of this ResourceComponent.
	 */
	@Override
	public Object clone() {

		// Create a new instance of ResourceComponent and copy contents
		ResourceComponent outputComponent = new ResourceComponent();
		outputComponent.copy(this);

		return outputComponent;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.JanuaryObject.ListComponent#hashCode()
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
		
	}
	
	/**
	 * This operation is used to check equality between the ResourceComponent
	 * and another ResourceComponent. It returns true if the Components are
	 * equal and false if they are not.
	 * 
	 * @param otherResourceComponent
	 *            The other ResourceComponent whose information should be
	 *            compared to this ResourceComponent.
	 * @return True if the ResourceComponents are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object otherResourceComponent) {

		// Check if they are the same reference in memory
		if (this == otherResourceComponent) {
			return true;
		}

		// Check that the object is not null, and that it is an instance of
		// ResourceComponent
		boolean retVal = false;
		if (otherResourceComponent != null
				&& otherResourceComponent instanceof ResourceComponent) {

			// Call the super equals to check the list contents
			retVal = super.equals(otherResourceComponent);
		}

		return retVal;
	}

	/**
	 * Accepts a visitor to reveal the type of the ResourceComponent.
	 */
	@Override
	public void accept(IComponentVisitor visitor) {

		// Reveal our type to the visitor
		visitor.visit(this);

		return;
	}

	// /**
	// * This protected operation notifies the listeners of the
	// ResourceComponent
	// * that its state has changed.
	// */
	// protected void notifyListeners() {
	//
	// // Only process the update if there are listeners
	// if (listeners != null && !listeners.isEmpty()) {
	// // Create a thread on which to notify the listeners.
	// Thread notifierThread = new Thread() {
	// @Override
	// public void run() {
	// // Loop over all listeners and update them
	// for (int i = 0; i < listeners.size(); i++) {
	// listeners.get(i).update(ResourceComponent.this);
	// }
	// return;
	// }
	// };
	//
	// // Launch the thread and do the notifications
	// notifierThread.start();
	// }
	//
	// return;
	// }
}
