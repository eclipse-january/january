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
 * This interface defines a visitation contract where visitation requests are
 * granted through a delegate provided by an IVisitHandler. This interface is an
 * alternative to IVisitable for classes that may need to execute visitation code
 * for classes not available on the IComponentVisitor interface.
 *  
 * @author Jay Jay Billings
 */
public interface IGenericallyVisitable {
	
	/**
	 * This operation will accept a visit handler instead of a typed visitor
	 * that will then be called as a delegate for direct visitation.
	 * @param visitHandler
	 */
	public void accept(IVisitHandler visitHandler);

}
