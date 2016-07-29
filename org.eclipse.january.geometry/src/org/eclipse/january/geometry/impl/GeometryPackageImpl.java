/*******************************************************************************
 * Copyright (c) 2016 UT-Battelle, LLC. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     UT-Battelle, LLC. - initial API and implementation
 *******************************************************************************/
package org.eclipse.january.geometry.impl;

import java.nio.file.Path;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.january.geometry.BoundingBox;
import org.eclipse.january.geometry.STLGeometryImporter;
import org.eclipse.january.geometry.Complement;
import org.eclipse.january.geometry.Cube;
import org.eclipse.january.geometry.Cylinder;
import org.eclipse.january.geometry.Face;
import org.eclipse.january.geometry.Geometry;
import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.january.geometry.HeatExchanger;
import org.eclipse.january.geometry.IGeometryImporter;
import org.eclipse.january.geometry.INode;
import org.eclipse.january.geometry.Intersection;
import org.eclipse.january.geometry.Junction;
import org.eclipse.january.geometry.Material;
import org.eclipse.january.geometry.Operator;
import org.eclipse.january.geometry.Pipe;
import org.eclipse.january.geometry.PolyShape;
import org.eclipse.january.geometry.Reactor;
import org.eclipse.january.geometry.Shape;
import org.eclipse.january.geometry.Sphere;
import org.eclipse.january.geometry.Triangle;
import org.eclipse.january.geometry.Tube;
import org.eclipse.january.geometry.Union;
import org.eclipse.january.geometry.Vertex;
import org.eclipse.january.geometry.VertexSource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GeometryPackageImpl extends EPackageImpl implements GeometryPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass triangleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vertexEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sphereEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cubeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cylinderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass geometryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tubeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intersectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass materialEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iGeometryImporterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stlGeometryImporterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pipeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boundingBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass junctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass heatExchangerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reactorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass polyShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass faceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vertexSourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType pathEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType objectEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.january.geometry.GeometryPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GeometryPackageImpl() {
		super(eNS_URI, GeometryFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link GeometryPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GeometryPackage init() {
		if (isInited) return (GeometryPackage)EPackage.Registry.INSTANCE.getEPackage(GeometryPackage.eNS_URI);

		// Obtain or create and register package
		GeometryPackageImpl theGeometryPackage = (GeometryPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GeometryPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GeometryPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theGeometryPackage.createPackageContents();

		// Initialize created meta-data
		theGeometryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGeometryPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GeometryPackage.eNS_URI, theGeometryPackage);
		return theGeometryPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShape() {
		return shapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getShape_Material() {
		return (EReference)shapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTriangle() {
		return triangleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTriangle_Normal() {
		return (EReference)triangleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTriangle_Vertices() {
		return (EReference)triangleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTriangle__Equals__Object() {
		return triangleEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTriangle__HashCode() {
		return triangleEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVertex() {
		return vertexEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVertex_X() {
		return (EAttribute)vertexEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVertex_Y() {
		return (EAttribute)vertexEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVertex_Z() {
		return (EAttribute)vertexEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getVertex__Clone() {
		return vertexEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getVertex__Equals__Object() {
		return vertexEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getVertex__HashCode() {
		return vertexEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSphere() {
		return sphereEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSphere_Radius() {
		return (EAttribute)sphereEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCube() {
		return cubeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCube_SideLength() {
		return (EAttribute)cubeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCylinder() {
		return cylinderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCylinder_Radius() {
		return (EAttribute)cylinderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCylinder_Height() {
		return (EAttribute)cylinderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeometry() {
		return geometryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeometry_VertexSources() {
		return (EReference)geometryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTube() {
		return tubeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTube_Height() {
		return (EAttribute)tubeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTube_InnerRadius() {
		return (EAttribute)tubeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTube_Radius() {
		return (EAttribute)tubeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getINode() {
		return iNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getINode_Name() {
		return (EAttribute)iNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getINode_Id() {
		return (EAttribute)iNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getINode_Nodes() {
		return (EReference)iNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getINode_Type() {
		return (EAttribute)iNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getINode_Triangles() {
		return (EReference)iNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getINode_Center() {
		return (EReference)iNodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getINode_Parent() {
		return (EReference)iNodeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getINode__ChangeDecoratorProperty__String_Object() {
		return iNodeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getINode__GetPropertyNames() {
		return iNodeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getINode__GetProperty__String() {
		return iNodeEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getINode__SetProperty__String_double() {
		return iNodeEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getINode__AddNode__INode() {
		return iNodeEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getINode__RemoveNode__INode() {
		return iNodeEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getINode__Copy__Object() {
		return iNodeEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getINode__Clone() {
		return iNodeEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperator() {
		return operatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnion() {
		return unionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntersection() {
		return intersectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplement() {
		return complementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMaterial() {
		return materialEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMaterial_PhongMatName() {
		return (EAttribute)materialEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMaterial_Texture() {
		return (EAttribute)materialEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMaterial_MaterialFiles() {
		return (EAttribute)materialEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIGeometryImporter() {
		return iGeometryImporterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIGeometryImporter_FileTypes() {
		return (EAttribute)iGeometryImporterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIGeometryImporter_Description() {
		return (EAttribute)iGeometryImporterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIGeometryImporter__Load__Path() {
		return iGeometryImporterEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSTLGeometryImporter() {
		return stlGeometryImporterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPipe() {
		return pipeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPipe_NumRods() {
		return (EAttribute)pipeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPipe_Pitch() {
		return (EAttribute)pipeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPipe_RodDiameter() {
		return (EAttribute)pipeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPipe_RotationX() {
		return (EAttribute)pipeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPipe_RotationY() {
		return (EAttribute)pipeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPipe_RotationZ() {
		return (EAttribute)pipeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPipe__GetLowerEdge() {
		return pipeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPipe__GetUpperEdge() {
		return pipeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoundingBox() {
		return boundingBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoundingBox_MaxX() {
		return (EAttribute)boundingBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoundingBox_MaxY() {
		return (EAttribute)boundingBoxEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoundingBox_MaxZ() {
		return (EAttribute)boundingBoxEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoundingBox_MinX() {
		return (EAttribute)boundingBoxEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoundingBox_MinY() {
		return (EAttribute)boundingBoxEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoundingBox_MinZ() {
		return (EAttribute)boundingBoxEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundingBox__AddArea__BoundingBox() {
		return boundingBoxEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJunction() {
		return junctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJunction_Height() {
		return (EAttribute)junctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJunction_ZIn() {
		return (EAttribute)junctionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJunction_ZOut() {
		return (EAttribute)junctionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJunction_Input() {
		return (EReference)junctionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJunction_Output() {
		return (EReference)junctionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHeatExchanger() {
		return heatExchangerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHeatExchanger_Pipe() {
		return (EReference)heatExchangerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHeatExchanger_Input() {
		return (EReference)heatExchangerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHeatExchanger_Output() {
		return (EReference)heatExchangerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReactor() {
		return reactorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReactor_Pipes() {
		return (EReference)reactorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPolyShape() {
		return polyShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPolyShape_Faces() {
		return (EReference)polyShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPolyShape_VertexSource() {
		return (EReference)polyShapeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPolyShape_MaterialFiles() {
		return (EAttribute)polyShapeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFace() {
		return faceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFace_VertexIndices() {
		return (EAttribute)faceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFace_TextureIndices() {
		return (EAttribute)faceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVertexSource() {
		return vertexSourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVertexSource_Vertices() {
		return (EReference)vertexSourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVertexSource_TextureCoordinates() {
		return (EReference)vertexSourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVertexSource_MaterialFiles() {
		return (EAttribute)vertexSourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPath() {
		return pathEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getObject() {
		return objectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeometryFactory getGeometryFactory() {
		return (GeometryFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		shapeEClass = createEClass(SHAPE);
		createEReference(shapeEClass, SHAPE__MATERIAL);

		triangleEClass = createEClass(TRIANGLE);
		createEReference(triangleEClass, TRIANGLE__NORMAL);
		createEReference(triangleEClass, TRIANGLE__VERTICES);
		createEOperation(triangleEClass, TRIANGLE___EQUALS__OBJECT);
		createEOperation(triangleEClass, TRIANGLE___HASH_CODE);

		vertexEClass = createEClass(VERTEX);
		createEAttribute(vertexEClass, VERTEX__X);
		createEAttribute(vertexEClass, VERTEX__Y);
		createEAttribute(vertexEClass, VERTEX__Z);
		createEOperation(vertexEClass, VERTEX___CLONE);
		createEOperation(vertexEClass, VERTEX___EQUALS__OBJECT);
		createEOperation(vertexEClass, VERTEX___HASH_CODE);

		sphereEClass = createEClass(SPHERE);
		createEAttribute(sphereEClass, SPHERE__RADIUS);

		cubeEClass = createEClass(CUBE);
		createEAttribute(cubeEClass, CUBE__SIDE_LENGTH);

		cylinderEClass = createEClass(CYLINDER);
		createEAttribute(cylinderEClass, CYLINDER__RADIUS);
		createEAttribute(cylinderEClass, CYLINDER__HEIGHT);

		geometryEClass = createEClass(GEOMETRY);
		createEReference(geometryEClass, GEOMETRY__VERTEX_SOURCES);

		tubeEClass = createEClass(TUBE);
		createEAttribute(tubeEClass, TUBE__HEIGHT);
		createEAttribute(tubeEClass, TUBE__INNER_RADIUS);
		createEAttribute(tubeEClass, TUBE__RADIUS);

		iNodeEClass = createEClass(INODE);
		createEAttribute(iNodeEClass, INODE__NAME);
		createEAttribute(iNodeEClass, INODE__ID);
		createEReference(iNodeEClass, INODE__NODES);
		createEAttribute(iNodeEClass, INODE__TYPE);
		createEReference(iNodeEClass, INODE__TRIANGLES);
		createEReference(iNodeEClass, INODE__CENTER);
		createEReference(iNodeEClass, INODE__PARENT);
		createEOperation(iNodeEClass, INODE___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT);
		createEOperation(iNodeEClass, INODE___GET_PROPERTY_NAMES);
		createEOperation(iNodeEClass, INODE___GET_PROPERTY__STRING);
		createEOperation(iNodeEClass, INODE___SET_PROPERTY__STRING_DOUBLE);
		createEOperation(iNodeEClass, INODE___ADD_NODE__INODE);
		createEOperation(iNodeEClass, INODE___REMOVE_NODE__INODE);
		createEOperation(iNodeEClass, INODE___COPY__OBJECT);
		createEOperation(iNodeEClass, INODE___CLONE);

		operatorEClass = createEClass(OPERATOR);

		unionEClass = createEClass(UNION);

		intersectionEClass = createEClass(INTERSECTION);

		complementEClass = createEClass(COMPLEMENT);

		materialEClass = createEClass(MATERIAL);
		createEAttribute(materialEClass, MATERIAL__PHONG_MAT_NAME);
		createEAttribute(materialEClass, MATERIAL__TEXTURE);
		createEAttribute(materialEClass, MATERIAL__MATERIAL_FILES);

		iGeometryImporterEClass = createEClass(IGEOMETRY_IMPORTER);
		createEAttribute(iGeometryImporterEClass, IGEOMETRY_IMPORTER__FILE_TYPES);
		createEAttribute(iGeometryImporterEClass, IGEOMETRY_IMPORTER__DESCRIPTION);
		createEOperation(iGeometryImporterEClass, IGEOMETRY_IMPORTER___LOAD__PATH);

		stlGeometryImporterEClass = createEClass(STL_GEOMETRY_IMPORTER);

		pipeEClass = createEClass(PIPE);
		createEAttribute(pipeEClass, PIPE__NUM_RODS);
		createEAttribute(pipeEClass, PIPE__PITCH);
		createEAttribute(pipeEClass, PIPE__ROD_DIAMETER);
		createEAttribute(pipeEClass, PIPE__ROTATION_X);
		createEAttribute(pipeEClass, PIPE__ROTATION_Y);
		createEAttribute(pipeEClass, PIPE__ROTATION_Z);
		createEOperation(pipeEClass, PIPE___GET_LOWER_EDGE);
		createEOperation(pipeEClass, PIPE___GET_UPPER_EDGE);

		boundingBoxEClass = createEClass(BOUNDING_BOX);
		createEAttribute(boundingBoxEClass, BOUNDING_BOX__MAX_X);
		createEAttribute(boundingBoxEClass, BOUNDING_BOX__MAX_Y);
		createEAttribute(boundingBoxEClass, BOUNDING_BOX__MAX_Z);
		createEAttribute(boundingBoxEClass, BOUNDING_BOX__MIN_X);
		createEAttribute(boundingBoxEClass, BOUNDING_BOX__MIN_Y);
		createEAttribute(boundingBoxEClass, BOUNDING_BOX__MIN_Z);
		createEOperation(boundingBoxEClass, BOUNDING_BOX___ADD_AREA__BOUNDINGBOX);

		junctionEClass = createEClass(JUNCTION);
		createEAttribute(junctionEClass, JUNCTION__HEIGHT);
		createEAttribute(junctionEClass, JUNCTION__ZIN);
		createEAttribute(junctionEClass, JUNCTION__ZOUT);
		createEReference(junctionEClass, JUNCTION__INPUT);
		createEReference(junctionEClass, JUNCTION__OUTPUT);

		heatExchangerEClass = createEClass(HEAT_EXCHANGER);
		createEReference(heatExchangerEClass, HEAT_EXCHANGER__PIPE);
		createEReference(heatExchangerEClass, HEAT_EXCHANGER__INPUT);
		createEReference(heatExchangerEClass, HEAT_EXCHANGER__OUTPUT);

		reactorEClass = createEClass(REACTOR);
		createEReference(reactorEClass, REACTOR__PIPES);

		polyShapeEClass = createEClass(POLY_SHAPE);
		createEReference(polyShapeEClass, POLY_SHAPE__FACES);
		createEReference(polyShapeEClass, POLY_SHAPE__VERTEX_SOURCE);
		createEAttribute(polyShapeEClass, POLY_SHAPE__MATERIAL_FILES);

		faceEClass = createEClass(FACE);
		createEAttribute(faceEClass, FACE__VERTEX_INDICES);
		createEAttribute(faceEClass, FACE__TEXTURE_INDICES);

		vertexSourceEClass = createEClass(VERTEX_SOURCE);
		createEReference(vertexSourceEClass, VERTEX_SOURCE__VERTICES);
		createEReference(vertexSourceEClass, VERTEX_SOURCE__TEXTURE_COORDINATES);
		createEAttribute(vertexSourceEClass, VERTEX_SOURCE__MATERIAL_FILES);

		// Create data types
		pathEDataType = createEDataType(PATH);
		objectEDataType = createEDataType(OBJECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		shapeEClass.getESuperTypes().add(this.getINode());
		sphereEClass.getESuperTypes().add(this.getShape());
		cubeEClass.getESuperTypes().add(this.getShape());
		cylinderEClass.getESuperTypes().add(this.getShape());
		geometryEClass.getESuperTypes().add(this.getINode());
		tubeEClass.getESuperTypes().add(this.getShape());
		operatorEClass.getESuperTypes().add(this.getINode());
		unionEClass.getESuperTypes().add(this.getOperator());
		intersectionEClass.getESuperTypes().add(this.getOperator());
		complementEClass.getESuperTypes().add(this.getOperator());
		stlGeometryImporterEClass.getESuperTypes().add(this.getIGeometryImporter());
		pipeEClass.getESuperTypes().add(this.getTube());
		junctionEClass.getESuperTypes().add(this.getShape());
		heatExchangerEClass.getESuperTypes().add(this.getShape());
		reactorEClass.getESuperTypes().add(this.getShape());
		polyShapeEClass.getESuperTypes().add(this.getShape());

		// Initialize classes, features, and operations; add parameters
		initEClass(shapeEClass, Shape.class, "Shape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getShape_Material(), this.getMaterial(), null, "material", null, 0, 1, Shape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(triangleEClass, Triangle.class, "Triangle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTriangle_Normal(), this.getVertex(), null, "normal", null, 0, 1, Triangle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTriangle_Vertices(), this.getVertex(), null, "vertices", null, 0, 3, Triangle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getTriangle__Equals__Object(), ecorePackage.getEBoolean(), "equals", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getObject(), "otherObject", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getTriangle__HashCode(), ecorePackage.getEInt(), "hashCode", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(vertexEClass, Vertex.class, "Vertex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVertex_X(), ecorePackage.getEDouble(), "x", null, 0, 1, Vertex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVertex_Y(), ecorePackage.getEDouble(), "y", null, 0, 1, Vertex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVertex_Z(), ecorePackage.getEDouble(), "z", null, 0, 1, Vertex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getVertex__Clone(), this.getObject(), "clone", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getVertex__Equals__Object(), ecorePackage.getEBoolean(), "equals", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getObject(), "otherObject", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getVertex__HashCode(), ecorePackage.getEInt(), "hashCode", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sphereEClass, Sphere.class, "Sphere", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSphere_Radius(), ecorePackage.getEDouble(), "radius", null, 0, 1, Sphere.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cubeEClass, Cube.class, "Cube", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCube_SideLength(), ecorePackage.getEDouble(), "sideLength", null, 0, 1, Cube.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cylinderEClass, Cylinder.class, "Cylinder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCylinder_Radius(), ecorePackage.getEDouble(), "radius", null, 0, 1, Cylinder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCylinder_Height(), ecorePackage.getEDouble(), "height", null, 0, 1, Cylinder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(geometryEClass, Geometry.class, "Geometry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGeometry_VertexSources(), this.getVertexSource(), null, "vertexSources", null, 0, -1, Geometry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tubeEClass, Tube.class, "Tube", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTube_Height(), ecorePackage.getEDouble(), "height", "0.0", 0, 1, Tube.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTube_InnerRadius(), ecorePackage.getEDouble(), "innerRadius", "0.0", 0, 1, Tube.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTube_Radius(), ecorePackage.getEDouble(), "radius", "0.0", 0, 1, Tube.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iNodeEClass, INode.class, "INode", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getINode_Name(), ecorePackage.getEString(), "name", null, 0, 1, INode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getINode_Id(), ecorePackage.getELong(), "id", null, 0, 1, INode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getINode_Nodes(), this.getINode(), null, "nodes", null, 0, -1, INode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getINode_Type(), ecorePackage.getEString(), "type", null, 0, 1, INode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getINode_Triangles(), this.getTriangle(), null, "triangles", null, 0, -1, INode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getINode_Center(), this.getVertex(), null, "center", null, 1, 1, INode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getINode_Parent(), this.getINode(), null, "parent", null, 0, 1, INode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getINode__ChangeDecoratorProperty__String_Object(), null, "changeDecoratorProperty", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "property", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getObject(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getINode__GetPropertyNames(), ecorePackage.getEString(), "getPropertyNames", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getINode__GetProperty__String(), ecorePackage.getEDouble(), "getProperty", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "property", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getINode__SetProperty__String_double(), null, "setProperty", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "property", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDouble(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getINode__AddNode__INode(), null, "addNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getINode(), "child", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getINode__RemoveNode__INode(), null, "removeNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getINode(), "child", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getINode__Copy__Object(), null, "copy", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getObject(), "source", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getINode__Clone(), this.getObject(), "clone", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(operatorEClass, Operator.class, "Operator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unionEClass, Union.class, "Union", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(intersectionEClass, Intersection.class, "Intersection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(complementEClass, Complement.class, "Complement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(materialEClass, Material.class, "Material", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMaterial_PhongMatName(), ecorePackage.getEString(), "phongMatName", null, 0, 1, Material.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMaterial_Texture(), ecorePackage.getEString(), "texture", null, 0, 1, Material.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMaterial_MaterialFiles(), ecorePackage.getEString(), "materialFiles", null, 0, -1, Material.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iGeometryImporterEClass, IGeometryImporter.class, "IGeometryImporter", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIGeometryImporter_FileTypes(), ecorePackage.getEString(), "fileTypes", null, 1, -1, IGeometryImporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIGeometryImporter_Description(), ecorePackage.getEString(), "description", null, 0, 1, IGeometryImporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getIGeometryImporter__Load__Path(), this.getGeometry(), "load", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPath(), "path", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(stlGeometryImporterEClass, STLGeometryImporter.class, "STLGeometryImporter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pipeEClass, Pipe.class, "Pipe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPipe_NumRods(), ecorePackage.getEInt(), "numRods", null, 0, 1, Pipe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPipe_Pitch(), ecorePackage.getEInt(), "pitch", null, 0, 1, Pipe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPipe_RodDiameter(), ecorePackage.getEInt(), "rodDiameter", null, 0, 1, Pipe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPipe_RotationX(), ecorePackage.getEDouble(), "rotationX", null, 0, 1, Pipe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPipe_RotationY(), ecorePackage.getEDouble(), "rotationY", null, 0, 1, Pipe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPipe_RotationZ(), ecorePackage.getEDouble(), "rotationZ", null, 0, 1, Pipe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getPipe__GetLowerEdge(), this.getBoundingBox(), "getLowerEdge", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getPipe__GetUpperEdge(), this.getBoundingBox(), "getUpperEdge", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(boundingBoxEClass, BoundingBox.class, "BoundingBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBoundingBox_MaxX(), ecorePackage.getEDouble(), "maxX", null, 0, 1, BoundingBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoundingBox_MaxY(), ecorePackage.getEDouble(), "maxY", "0.0", 0, 1, BoundingBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoundingBox_MaxZ(), ecorePackage.getEDouble(), "maxZ", "0.0", 0, 1, BoundingBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoundingBox_MinX(), ecorePackage.getEDouble(), "minX", "0.0", 0, 1, BoundingBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoundingBox_MinY(), ecorePackage.getEDouble(), "minY", "0.0", 0, 1, BoundingBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoundingBox_MinZ(), ecorePackage.getEDouble(), "minZ", "0.0", 0, 1, BoundingBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getBoundingBox__AddArea__BoundingBox(), null, "addArea", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBoundingBox(), "area", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(junctionEClass, Junction.class, "Junction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJunction_Height(), ecorePackage.getEDouble(), "height", null, 0, 1, Junction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJunction_ZIn(), ecorePackage.getEDouble(), "zIn", null, 0, 1, Junction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJunction_ZOut(), ecorePackage.getEDouble(), "zOut", null, 0, 1, Junction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJunction_Input(), this.getPipe(), null, "input", null, 0, -1, Junction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJunction_Output(), this.getPipe(), null, "output", null, 0, -1, Junction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(heatExchangerEClass, HeatExchanger.class, "HeatExchanger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHeatExchanger_Pipe(), this.getPipe(), null, "pipe", null, 0, 1, HeatExchanger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHeatExchanger_Input(), this.getJunction(), null, "input", null, 0, 1, HeatExchanger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHeatExchanger_Output(), this.getJunction(), null, "output", null, 0, 1, HeatExchanger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(reactorEClass, Reactor.class, "Reactor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReactor_Pipes(), this.getPipe(), null, "pipes", null, 0, -1, Reactor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(polyShapeEClass, PolyShape.class, "PolyShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPolyShape_Faces(), this.getFace(), null, "faces", null, 0, -1, PolyShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPolyShape_VertexSource(), this.getVertexSource(), null, "vertexSource", null, 0, 1, PolyShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPolyShape_MaterialFiles(), ecorePackage.getEString(), "materialFiles", null, 0, -1, PolyShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(faceEClass, Face.class, "Face", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFace_VertexIndices(), ecorePackage.getEInt(), "vertexIndices", null, 0, -1, Face.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFace_TextureIndices(), ecorePackage.getEInt(), "textureIndices", null, 0, -1, Face.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vertexSourceEClass, VertexSource.class, "VertexSource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVertexSource_Vertices(), this.getVertex(), null, "vertices", null, 0, -1, VertexSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVertexSource_TextureCoordinates(), this.getVertex(), null, "textureCoordinates", null, 0, -1, VertexSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVertexSource_MaterialFiles(), ecorePackage.getEString(), "materialFiles", null, 0, -1, VertexSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(pathEDataType, Path.class, "Path", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(objectEDataType, Object.class, "Object", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //GeometryPackageImpl