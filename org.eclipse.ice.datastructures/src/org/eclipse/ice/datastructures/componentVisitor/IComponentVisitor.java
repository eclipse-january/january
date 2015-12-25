/*******************************************************************************
 * Copyright (c) 2011, 2014- UT-Battelle, LLC.
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
package org.eclipse.ice.datastructures.componentVisitor;

import org.eclipse.ice.datastructures.ICEObject.ListComponent;
import org.eclipse.ice.datastructures.form.AdaptiveTreeComposite;
import org.eclipse.ice.datastructures.form.DataComponent;
import org.eclipse.ice.datastructures.form.GeometryComponent;
import org.eclipse.ice.datastructures.form.MasterDetailsComponent;
import org.eclipse.ice.datastructures.form.MatrixComponent;
import org.eclipse.ice.datastructures.form.MeshComponent;
import org.eclipse.ice.datastructures.form.MeshComponent;
import org.eclipse.ice.datastructures.form.ResourceComponent;
import org.eclipse.ice.datastructures.form.TableComponent;
import org.eclipse.ice.datastructures.form.TimeDataComponent;
import org.eclipse.ice.datastructures.form.TreeComposite;
import org.eclipse.ice.datastructures.form.emf.EMFComponent;

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
	 * This operation informs the visitor that it is actually working with a
	 * MeshComponent and should operate accordingly.
	 * 
	 * @param component
	 *            The MeshComponent.
	 */
	public void visit(MeshComponent component);

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
	 * @param component The ListComponent
	 */
	public void visit(ListComponent<?> component);
}
