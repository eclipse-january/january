/**
 */
package org.eclipse.january.geometry.tests;

import junit.textui.TestRunner;

import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.Union;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Union</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class UnionTest extends OperatorTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(UnionTest.class);
	}

	/**
	 * Constructs a new Union test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Union test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Union getFixture() {
		return (Union)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GeometryFactory.eINSTANCE.createUnion());
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

} //UnionTest
