/*******************************************************************************
 * Copyright (c) 2012, 2016 UT-Battelle, LLC.
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
package org.eclipse.ice.datastructures.test;

import org.eclipse.january.form.AdaptiveTreeComposite;
import org.eclipse.january.form.DataComponent;
import org.eclipse.january.form.GeometryComponent;
import org.eclipse.january.form.IComponentVisitor;
import org.eclipse.january.form.IReactorComponent;
import org.eclipse.january.form.ListComponent;
import org.eclipse.january.form.MasterDetailsComponent;
import org.eclipse.january.form.MatrixComponent;
import org.eclipse.january.form.ResourceComponent;
import org.eclipse.january.form.TableComponent;
import org.eclipse.january.form.TimeDataComponent;
import org.eclipse.january.form.TreeComposite;
import org.eclipse.january.form.emf.EMFComponent;

/**
 * <p>
 * An implementation of IComponentVisitor used for testing.
 * </p>
 * 
 * @author Jay Jay Billings
 */
public class TestVisitor implements IComponentVisitor {
	/**
	 * <p>
	 * The Visitation state. False if the TestVisitor has not been visited, true
	 * otherwise.
	 * </p>
	 * 
	 */
	private boolean visited;

	/**
	 * <p>
	 * The Constructor
	 * </p>
	 * 
	 */
	public TestVisitor() {

		// Set the default visitation state
		visited = false;

	}

	/**
	 * <p>
	 * True if the TestVisitor was visited, false otherwise.
	 * </p>
	 * 
	 * @return
	 * 		<p>
	 *         True if the TestVisitor was visited by a Component, false
	 *         otherwise.
	 *         </p>
	 */
	public boolean wasVisited() {
		return visited;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IComponentVisitor#visit(DataComponent component)
	 */
	@Override
	public void visit(DataComponent component) {

		// Set the visitation state to true if the component is not null
		if (component != null) {
			visited = true;
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IComponentVisitor#visit(ResourceComponent component)
	 */
	@Override
	public void visit(ResourceComponent component) {

		// Set the visitation state to true if the component is not null
		if (component != null) {
			visited = true;
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IComponentVisitor#visit(TableComponent component)
	 */
	@Override
	public void visit(TableComponent component) {

		// Set the visitation state to true if the component is not null
		if (component != null) {
			visited = true;
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IComponentVisitor#visit(MatrixComponent component)
	 */
	@Override
	public void visit(MatrixComponent component) {

		if (component != null) {
			visited = true;
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IComponentVisitor#visit(GeometryComponent component)
	 */
	@Override
	public void visit(GeometryComponent component) {

		if (component != null) {
			visited = true;
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IComponentVisitor#visit(MasterDetailsComponent component)
	 */
	@Override
	public void visit(MasterDetailsComponent component) {

		// Set the visitation state to true if the component is not null
		if (component != null) {
			visited = true;
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IComponentVisitor#visit(TreeComposite component)
	 */
	@Override
	public void visit(TreeComposite component) {
		// TODO Auto-generated method stub

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IComponentVisitor#visit(IReactorComponent component)
	 */
	@Override
	public void visit(IReactorComponent component) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(TimeDataComponent component) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(AdaptiveTreeComposite component) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(EMFComponent component) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(ListComponent component) {
		// TODO Auto-generated method stub

	}
	
}
