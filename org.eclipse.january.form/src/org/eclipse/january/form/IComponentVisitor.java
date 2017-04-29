/*******************************************************************************
 * Copyright (c) 2011, 2016- UT-Battelle, LLC.
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

import org.eclipse.january.form.emf.EMFComponent;

/**
 * This interface defines the "visitation" routines that implementations of
 * Component may use to reveal their types to visitors. It is one part of the
 * Visitor pattern.
 * 
 * @author Jay Jay Billings
 */
public interface IComponentVisitor {
	/**
	 * This operation directs a visitor to perform its actions on the Component
	 * as a DataComponent.
	 * 
	 * @param component
	 *            DataComponent which was originally called by the accept()
	 *            operation
	 */
	public void visit(DataComponent component);

	/**
	 * This operation directs a visitor to perform its actions on the Component
	 * as an OutputComponent.
	 * 
	 * @param component
	 *            OutputComponent which was originally called by the accept()
	 *            operation
	 */
	public void visit(ResourceComponent component);

	/**
	 * This operation directs a visitor to perform its actions on the Component
	 * as a VisitorComponent.
	 * 
	 * @param component
	 *            TableComponent which was originally called by the accept()
	 *            operation
	 */
	public void visit(TableComponent component);

	/**
	 * This operation directs a visitor to perform its actions on the Component
	 * as a MatrixComponent.
	 * 
	 * @param component
	 *            MatrixComponent which was originally called by the accept()
	 *            operation
	 */
	public void visit(MatrixComponent component);

	/**
	 * This operation directs a visitor to perform its actions on the Component
	 * as a GeometryComponent.
	 * 
	 * @param component
	 *            GeometryComponent which was originally called by the accept()
	 *            operation
	 */
	public void visit(GeometryComponent component);

	/**
	 * This operation directs a visitor to perform its actions on the Component
	 * as a MasterDetailsComponent.
	 * 
	 * @param component
	 *            MasterDetailsComponent which was originally called by the
	 *            accept() operation.
	 */
	public void visit(MasterDetailsComponent component);

	/**
	 * This operation informs the visitor that it is actually working with a
	 * TreeComposite and should operate accordingly.
	 * 
	 * @param component
	 *            The TreeComposite
	 */
	public void visit(TreeComposite component);

	/**
	 * This operation informs the visitor that it is actually working with an
	 * AdaptiveTreeComposite and should operate accordingly.
	 * 
	 * @param component
	 *            The AdaptiveTreeComposite
	 */
	public void visit(AdaptiveTreeComposite component);

	/**
	 * This operation informs the visitor that it is actually working with an
	 * IReactorComponent and should operate accordingly.
	 * 
	 * @param component
	 *            The IReactorComponent
	 */
	public void visit(IReactorComponent component);

	/**
	 * This operation informs the visitor that it is actually working with a
	 * TimeDataComponent and should operate accordingly.
	 * 
	 * @param component
	 *            The TimeDataComponent.
	 */
	public void visit(TimeDataComponent component);

	/**
	 * This operation informs the visitor that it is actually working with an
	 * EMFComponent and should operate accordingly.
	 * 
	 * @param component
	 *            The EMFComponent.
	 */
	public void visit(EMFComponent component);

	/**
	 * This operation informs the visitor that it is actually working with a
	 * ListComponent. The generic type of the component is not specified.
	 * 
	 * @param component
	 *            The ListComponent
	 */
	public void visit(ListComponent<?> component);
}
