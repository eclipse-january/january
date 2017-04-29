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
 * A simple, templated Visitor interface as part of the Visitor pattern. This
 * interface is implemented by classes that work with IVisitorHandlers to 
 * dynamically and generically extend the visitation capabilities of the forms
 * package. Using this interface in place of the IComponentVisitor interface 
 * allows clients to create custom Components or other structures and visit 
 * them dynamically, wherease the IComponentVisitor interface is static and does
 * not allow extension outside the basic components.
 * 
 * @author Jay Jay Billings
 *
 */
public interface IVisitor<T> {
	
	/**
	 * This operation directs the visitor to visit the provided data element.
	 * @param component The data element that should be visited. 
	 */
	public void visit(T element);
	
}
