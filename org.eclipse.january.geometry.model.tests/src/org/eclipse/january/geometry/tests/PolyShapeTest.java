/**
 */
package org.eclipse.january.geometry.tests;

import junit.textui.TestRunner;

import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.PolyShape;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Poly Shape</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PolyShapeTest extends ShapeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PolyShapeTest.class);
	}

	/**
	 * Constructs a new Poly Shape test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolyShapeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Poly Shape test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected PolyShape getFixture() {
		return (PolyShape)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GeometryFactory.eINSTANCE.createPolyShape());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //PolyShapeTest
