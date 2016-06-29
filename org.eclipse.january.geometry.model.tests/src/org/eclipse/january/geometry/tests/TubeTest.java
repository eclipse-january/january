/**
 */
package org.eclipse.january.geometry.tests;

import junit.textui.TestRunner;

import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.Tube;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Tube</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TubeTest extends ShapeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TubeTest.class);
	}

	/**
	 * Constructs a new Tube test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TubeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Tube test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Tube getFixture() {
		return (Tube)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GeometryFactory.eINSTANCE.createTube());
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

} //TubeTest
