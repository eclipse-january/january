/**
 */
package org.eclipse.january.geometry.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.Triangle;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Triangle</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TriangleTest extends TestCase {

	/**
	 * The fixture for this Triangle test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Triangle fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TriangleTest.class);
	}

	/**
	 * Constructs a new Triangle test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TriangleTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Triangle test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Triangle fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Triangle test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Triangle getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GeometryFactory.eINSTANCE.createTriangle());
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

} //TriangleTest
