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
 * This is a simple interface for registering visitors under a generic visitor
 * pattern. It is designed such that implementers should use the IVisitors that
 * are registered with the set() operation to visit the objects passed to the
 * visit() operation. This allows run-time registration of generic visitation
 * callbacks without the need for a verbose, static interface such as 
 * IComponentVisitor. Registration is as simple as associating a Class with an
 * implementation of IVisitor<T>.
 * 
 * This class should not be used in general for all the data types in Forms. It
 * is better to implement IComponentVisitor or extend SelectiveComponentVisitor
 * in those cases because it minimizes the code and avoid bugs. This class and
 * the IVisitor interface are meant to be used only for classes that are not 
 * already available on those two entities. 
 * 
 * @author Jay Jay Billings
 */
public interface IVisitHandler {

	/**
	 * This operation associates an IVisitor with a Class.
	 * @param classType The Class that should be associated with the Visitor
	 * @param visitor The IVisitor that will be invoked for the given class.
	 */
	public void set(Class classType, IVisitor visitor);
	
	/**
	 * This operation uses the registered IVisitor to visit the injected 
	 * object.
	 * @param objectToVisit The object that should be visited.
	 */
	public void visit(Object objectToVisit);
	
}
