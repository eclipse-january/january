/*******************************************************************************
 * Copyright (c) 2012, 2016 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - 
 *   Jay Jay Billings
 *******************************************************************************/
package org.eclipse.january.form;

/**
 * This is the basic interface defining visitation contract for Components.
 * However, since some classes may want to masquerade as components (i.e. - use
 * the IComponentVisitor interface) for purposes unknown, the contract is
 * defined outside of the Component interface.
 * 
 * @author Jay Jay Billings
 */
public interface IVisitable {

	/**
	 * This operation directs the Component to call back to an IComponentVisitor
	 * so that the visitor can perform its required actions for the exact type
	 * of the Component.
	 * 
	 * @param visitor
	 *            The visitor
	 */
	public void accept(IComponentVisitor visitor);

}
