/**
 */
package org.eclipse.january.geometry.tests;

import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.Reactor;
import org.eclipse.january.geometry.impl.ReactorImpl;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object
 * '<em><b>Reactor</b></em>'. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ReactorTest extends ShapeTest {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ReactorTest.class);
	}

	/**
	 * Constructs a new Reactor test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ReactorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Reactor test case. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected Reactor getFixture() {
		return (Reactor) fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GeometryFactory.eINSTANCE.createReactor());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link org.eclipse.january.geometry.INode#clone()
	 * <em>Clone</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.january.geometry.INode#clone()
	 * @generated NOT
	 */
	@Override
	public void testClone() {

		// Check that the clone is of the correct type.
		assertTrue(fixture.clone() instanceof ReactorImpl);
	}
} // ReactorTest
