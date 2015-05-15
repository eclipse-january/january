/*******************************************************************************
 * Copyright (c) 2012, 2014 UT-Battelle, LLC.
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

import org.eclipse.ice.datastructures.ICEObject.ListComponent;
import org.eclipse.ice.datastructures.componentVisitor.IComponentVisitor;
import org.eclipse.ice.datastructures.form.AdaptiveTreeComposite;
import org.eclipse.ice.datastructures.form.DataComponent;
import org.eclipse.ice.datastructures.form.ResourceComponent;
import org.eclipse.ice.datastructures.form.MasterDetailsComponent;
import org.eclipse.ice.datastructures.form.TimeDataComponent;
import org.eclipse.ice.datastructures.form.mesh.MeshComponent;
import org.eclipse.ice.datastructures.form.TreeComposite;
import org.eclipse.ice.datastructures.componentVisitor.IReactorComponent;
import org.eclipse.ice.datastructures.form.MatrixComponent;
import org.eclipse.ice.datastructures.form.TableComponent;
import org.eclipse.ice.datastructures.form.emf.EMFComponent;
import org.eclipse.ice.datastructures.form.geometry.GeometryComponent;
import org.eclipse.ice.datastructures.form.geometry.IShape;

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
	 * @return <p>
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
	public void visit(MatrixComponent component) {

		if (component != null) {
			visited = true;
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IComponentVisitor#visit(IShape component)
	 */
	public void visit(IShape component) {

		// Set the visitation state to true if the component is not null
		if (component != null) {
			visited = true;
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IComponentVisitor#visit(GeometryComponent component)
	 */
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
	public void visit(TreeComposite component) {
		// TODO Auto-generated method stub

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IComponentVisitor#visit(IReactorComponent component)
	 */
	public void visit(IReactorComponent component) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(TimeDataComponent component) {
		// TODO Auto-generated method stub

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IComponentVisitor#visit(MeshComponent component)
	 */
	public void visit(MeshComponent component) {

		// Set the visitation state to true if the component is not null
		if (component != null) {
			visited = true;
		}

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