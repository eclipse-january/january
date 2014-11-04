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
package org.eclipse.ice.datastructures.componentVisitor;

import java.util.ArrayList;

import org.eclipse.ice.datastructures.form.AdaptiveTreeComposite;
import org.eclipse.ice.datastructures.form.DataComponent;
import org.eclipse.ice.datastructures.form.MasterDetailsComponent;
import org.eclipse.ice.datastructures.form.MatrixComponent;
import org.eclipse.ice.datastructures.form.ResourceComponent;
import org.eclipse.ice.datastructures.form.TableComponent;
import org.eclipse.ice.datastructures.form.TimeDataComponent;
import org.eclipse.ice.datastructures.form.TreeComposite;
import org.eclipse.ice.datastructures.form.emf.EMFComponent;
import org.eclipse.ice.datastructures.form.geometry.GeometryComponent;
import org.eclipse.ice.datastructures.form.geometry.IShape;
import org.eclipse.ice.datastructures.form.mesh.MeshComponent;
import org.eclipse.ice.datastructures.updateableComposite.Component;

/**
 * <!-- begin-UML-doc -->
 * <p>
 * This interface defines the "visitation" routines that implementations of
 * Component may use to reveal their types to visitors. It is one part of the
 * Visitor pattern.
 * </p>
 * <!-- end-UML-doc -->
 * 
 * @author Jay Jay Billings
 * @generated 
 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface IComponentVisitor {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	ArrayList<Component> component = null;

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation directs a visitor to perform its actions on the Component
	 * as a DataComponent.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param component
	 *            <p>
	 *            DataComponent which was originally called by the accept()
	 *            operation
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void visit(DataComponent component);

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation directs a visitor to perform its actions on the Component
	 * as an OutputComponent.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param component
	 *            <p>
	 *            OutputComponent which was originally called by the accept()
	 *            operation
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void visit(ResourceComponent component);

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation directs a visitor to perform its actions on the Component
	 * as a VisitorComponent.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param component
	 *            <p>
	 *            TableComponent which was originally called by the accept()
	 *            operation
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void visit(TableComponent component);

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation directs a visitor to perform its actions on the Component
	 * as a MatrixComponent.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param component
	 *            <p>
	 *            MatrixComponent which was originally called by the accept()
	 *            operation
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void visit(MatrixComponent component);

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation directs a visitor to perform its actions on the Component
	 * as an IShape.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param component
	 *            <p>
	 *            IShape which was originally called by the accept() operation
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void visit(IShape component);

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation directs a visitor to perform its actions on the Component
	 * as a GeometryComponent.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param component
	 *            <p>
	 *            GeometryComponent which was originally called by the accept()
	 *            operation
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void visit(GeometryComponent component);

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation directs a visitor to perform its actions on the Component
	 * as a MasterDetailsComponent.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param component
	 *            <p>
	 *            MasterDetailsComponent which was originally called by the
	 *            accept() operation.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void visit(MasterDetailsComponent component);

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation directs informs the visitor that it is actually working
	 * with a TreeComposite and should operate accordingly.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param component
	 *            <p>
	 *            The TreeComposite
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void visit(TreeComposite component);

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation directs informs the visitor that it is actually working
	 * with an AdaptiveTreeComposite and should operate accordingly.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param component
	 *            <p>
	 *            The AdaptiveTreeComposite
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void visit(AdaptiveTreeComposite component);
	
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation directs informs the visitor that it is actually working
	 * with an IReactorComponent and should operate accordingly.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param component
	 *            <p>
	 *            The IReactorComponent
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void visit(IReactorComponent component);

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation directs informs the visitor that it is actually working
	 * with a TimeDataComponent and should operate accordingly.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param component
	 *            <p>
	 *            The TimeDataComponent.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void visit(TimeDataComponent component);

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation directs informs the visitor that it is actually working
	 * with a MeshComponent and should operate accordingly.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param component
	 *            <p>
	 *            The MeshComponent.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void visit(MeshComponent component);
	
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation directs informs the visitor that it is actually working
	 * with a BatteryComponent and should operate accordingly.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param component
	 *            <p>
	 *            The BatteryComponent.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void visit(EMFComponent component);
	
}