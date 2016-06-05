/*******************************************************************************
 * Copyright (c) 2011, 2014 UT-Battelle, LLC.
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
 * The Component interface is the base for all shared operations in the
 * UpdateableComposite package's classes. These operations must be implemented
 * by all classes that realize either Component or Composite. Components are
 * also observable and realizations of IComponentListener can be registered with
 * Components to receive updates when the state of the Component changes.
 * </p>
 * 
 * @author Jay Jay Billings
 */
public interface Component extends IUpdateable {
	/**
	 * 
	 */
	ArrayList<IComponentVisitor> iComponentVisitor = null;

	/**
	 * <p>
	 * This operation directs the Component to call back to an IComponentVisitor
	 * so that the visitor can perform its required actions for the exact type
	 * of the Component.
	 * </p>
	 * 
	 * @param visitor
	 *            <p>
	 *            The visitor
	 *            </p>
	 */
	public void accept(IComponentVisitor visitor);
}