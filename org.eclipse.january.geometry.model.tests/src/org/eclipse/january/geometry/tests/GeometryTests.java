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
/**
 */
package org.eclipse.january.geometry.tests;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test suite for the '<em><b>geometry</b></em>'
 * package. <!-- end-user-doc -->
 * 
 * @generated
 */
public class GeometryTests extends TestSuite {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new GeometryTests("geometry Tests");
		suite.addTestSuite(ShapeTest.class);
		suite.addTestSuite(TriangleTest.class);
		suite.addTestSuite(VertexTest.class);
		suite.addTestSuite(SphereTest.class);
		suite.addTestSuite(CubeTest.class);
		suite.addTestSuite(CylinderTest.class);
		suite.addTestSuite(GeometryTest.class);
		suite.addTestSuite(TubeTest.class);
		suite.addTestSuite(OperatorTest.class);
		suite.addTestSuite(UnionTest.class);
		suite.addTestSuite(IntersectionTest.class);
		suite.addTestSuite(ComplementTest.class);
		suite.addTestSuite(STLGeometryImporterTest.class);
		suite.addTestSuite(PipeTest.class);
		suite.addTestSuite(BoundingBoxTest.class);
		suite.addTestSuite(JunctionTest.class);
		suite.addTestSuite(HeatExchangerTest.class);
		suite.addTestSuite(ReactorTest.class);
		suite.addTestSuite(PolyShapeTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GeometryTests(String name) {
		super(name);
	}

} // GeometryTests
