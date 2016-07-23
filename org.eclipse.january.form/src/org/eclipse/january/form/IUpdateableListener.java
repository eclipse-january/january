/*******************************************************************************
 * Copyright (c) 2013, 2016 UT-Battelle, LLC.
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
 * The IComponentListener interface specifies the operations that must be
 * realized by classes in order to receive updates from realizations of the
 * Component interface when their state changes.
 * </p>
 * 
 * @author Jay Jay Billings
 */

public interface IUpdateableListener {
	/**
	 * <p>
	 * The Component that was updated.
	 * </p>
	 * 
	 */

	ArrayList<IUpdateable> component = null;

	/**
	 * <p>
	 * This operation notifies the listener that an update has occurred in the
	 * Component.
	 * </p>
	 * 
	 * @param component
	 *            The component that was updated in some way.
	 */
	public void update(IUpdateable component);
}