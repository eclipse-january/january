/*******************************************************************************
 * Copyright (c) 2014, 2016 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jordan Deyton (UT-Battelle, LLC.) - initial API and implementation and/or 
 *    initial documentation
 *    Alex McCaskey (UT-Battelle, LLC.) - added EMF Component classes
 *    Jay Jay Billings (UT-Battelle, LLC.) - removed BatteryComponent
 *    Jay Jay Billings (UT-Battelle, LLC.) - added ListComponent
 *    Jordan Deyton (UT-Battelle, LLC.) - fixed generic type warnings
 *******************************************************************************/
package org.eclipse.january.form;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.january.form.emf.EMFComponent;

/**
 * This adapter class provides default implementations for the methods described
 * by the {@link IComponentVisitor} interface. The default behavior for each
 * method is to do nothing.
 * <p>
 * Classes that wish to deal with visit operations for specific
 * <code>Component</code>s should extend or instantiate this class and override
 * only the methods which they are interested in.
 * </p>
 * <p>
 * For example, if you have a <code>Component comp</code> and would like to
 * perform a special action if it is a <code>DataComponent</code>, you would do
 * the following:
 * 
 * <pre>
 * <code>IComponentVisitor visitor = new SelectiveComponentVisitor() {
 *     {@literal @}Override
 *     public void visit(DataComponent component) {
 *         // Do something unique for DataComponents...
 *     }
 * };
 * visitor.visit(comp);
 * </code>
 * </pre>
 * 
 * </p>
 * 
 * @see IComponentVisitor
 */
public abstract class SelectiveComponentVisitor implements IComponentVisitor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ice.datastructures.componentVisitor.IComponentVisitor#visit
	 * (org.eclipse.ice.datastructures.form.DataComponent)
	 */
	@Override
	public void visit(DataComponent component) {
		// Nothing to do.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ice.datastructures.componentVisitor.IComponentVisitor#visit
	 * (org.eclipse.ice.datastructures.form.ResourceComponent)
	 */
	@Override
	public void visit(ResourceComponent component) {
		// Nothing to do.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ice.datastructures.componentVisitor.IComponentVisitor#visit
	 * (org.eclipse.ice.datastructures.form.TableComponent)
	 */
	@Override
	public void visit(TableComponent component) {
		// Nothing to do.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ice.datastructures.componentVisitor.IComponentVisitor#visit
	 * (org.eclipse.ice.datastructures.form.MatrixComponent)
	 */
	@Override
	public void visit(MatrixComponent component) {
		// Nothing to do.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ice.datastructures.componentVisitor.IComponentVisitor#visit
	 * (org.eclipse.ice.datastructures.form.geometry.GeometryComponent)
	 */
	@Override
	public void visit(GeometryComponent component) {
		// Nothing to do.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ice.datastructures.componentVisitor.IComponentVisitor#visit
	 * (org.eclipse.ice.datastructures.form.MasterDetailsComponent)
	 */
	@Override
	public void visit(MasterDetailsComponent component) {
		// Nothing to do.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ice.datastructures.componentVisitor.IComponentVisitor#visit
	 * (org.eclipse.ice.datastructures.form.TreeComposite)
	 */
	@Override
	public void visit(TreeComposite component) {
		// Nothing to do.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ice.datastructures.componentVisitor.IComponentVisitor#visit
	 * (org.eclipse.ice.datastructures.form.AdaptiveTreeComposite)
	 */
	@Override
	public void visit(AdaptiveTreeComposite component) {
		// Nothing to do.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ice.datastructures.componentVisitor.IComponentVisitor#visit
	 * (org.eclipse.ice.datastructures.componentVisitor.IReactorComponent)
	 */
	@Override
	public void visit(IReactorComponent component) {
		// Nothing to do.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ice.datastructures.componentVisitor.IComponentVisitor#visit
	 * (org.eclipse.ice.datastructures.form.TimeDataComponent)
	 */
	@Override
	public void visit(TimeDataComponent component) {
		// Nothing to do.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ice.datastructures.componentVisitor.IComponentVisitor#visit
	 * (org.eclipse.ice.datastructures.form.BatteryComponent)
	 */
	@Override
	public void visit(EMFComponent component) {
		// Nothing to do.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ice.datastructures.componentVisitor.IComponentVisitor#visit(
	 * org.eclipse.ice.datastructures.ICEObject.ListComponent)
	 */
	@Override
	public void visit(ListComponent<?> component) {
		// Nothing to do
	}

}
