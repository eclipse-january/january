/**
 */
package org.eclipse.january.geometry.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>geometry</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class GeometryTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeometryTests(String name) {
		super(name);
	}

} //GeometryTests
