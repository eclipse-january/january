/*******************************************************************************
 * Copyright (c) 2011, 2016 UT-Battelle, LLC.
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

/**
 * <p>
 * The Composite interface defines behavior for realizations of the Component
 * interface that will also have children.
 * </p>
 * 
 * @author Jay Jay Billings
 */
public interface Composite extends Component {
	/**
	 * 
	 */
	ArrayList<Component> component = null;

	/**
	 * <p>
	 * This operation adds a child Component to a class that realizes the
	 * Composite interface. This operation should notify listeners that
	 * components have been added.
	 * </p>
	 * 
	 * @param child
	 *            <p>
	 *            The Component that should be added to the Composite.
	 *            </p>
	 */
	public void addComponent(Component child);

	/**
	 * <p>
	 * This operation removes a child Component to a class that realizes the
	 * Composite interface.
	 * </p>
	 * 
	 * @param childId
	 *            <p>
	 *            The id of the child Component that should be removed from the
	 *            Composite.
	 *            </p>
	 */
	public void removeComponent(int childId);

	/**
	 * <p>
	 * This operation retrieves a child Component to a class that realizes the
	 * Composite interface.
	 * </p>
	 * 
	 * @param childId
	 *            <p>
	 *            The id of the child Component that should be retrieved from
	 *            the Composite.
	 *            </p>
	 * @return <p>
	 *         The child with id childId that was retrieved from the Composite.
	 *         NULL if the childId was not found in the Composite.
	 *         </p>
	 */
	public Component getComponent(int childId);

	/**
	 * <p>
	 * This operations retrieves the number of child Components stored in an
	 * instance of a class that realizes the Composite interface.
	 * </p>
	 * 
	 * @return <p>
	 *         The number of child Components contained in the Composite.
	 *         </p>
	 */
	public int getNumberOfComponents();

	/**
	 * <p>
	 * This operation returns all of the Components stored in the Composite.
	 * </p>
	 * 
	 * @return <p>
	 *         The set of Components.
	 *         </p>
	 */
	public ArrayList<Component> getComponents();
}