/**
 */
package org.eclipse.january.geometry.tests;

import static org.junit.Assert.assertNotEquals;

import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.HeatExchanger;
import org.eclipse.january.geometry.Shape;
import org.eclipse.january.geometry.impl.HeatExchangerImpl;
import org.junit.Test;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Heat
 * Exchanger</b></em>'. <!-- end-user-doc -->
 * 
 * @generated
 */
public class HeatExchangerTest extends ShapeTest {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(HeatExchangerTest.class);
	}

	/**
	 * Constructs a new Heat Exchanger test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public HeatExchangerTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Heat Exchanger test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected HeatExchanger getFixture() {
		return (HeatExchanger) fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GeometryFactory.eINSTANCE.createHeatExchanger());
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
		assertTrue(fixture.clone() instanceof HeatExchangerImpl);
	}

	/**
	 * Check that geometries can be tested for equality correctly.
	 * 
	 * @generated NOT
	 */
	@Override
	@Test
	public void testEquals() {

		// A shape which will be identical to the feature
		HeatExchanger equalShape = GeometryFactory.eINSTANCE
				.createHeatExchanger();

		// Set some values on the fixture
		fixture.setId(8);
		fixture.setName("equal name");
		fixture.setProperty("testProperty", 0);
		fixture.setType("equal type");

		// Set identical values on the geometry
		equalShape.setId(8);
		equalShape.setName("equal name");
		equalShape.setProperty("testProperty", 0);
		equalShape.setType("equal type");

		// Create a child shape
		Shape equalChild = GeometryFactory.eINSTANCE.createShape();
		equalChild.setName("equal child");

		// Add the child as a node to the geometries
		fixture.addNode(equalChild);
		equalShape.addNode((Shape) equalChild.clone());

		// An object should equal itself, and hash codes should be equal if and
		// only if the objects are themselves equal
		assertTrue(fixture.equals(fixture));
		assertEquals(fixture.hashCode(), fixture.hashCode());

		// Check that the two objects are equal, regardless of order
		assertTrue(fixture.equals(equalShape));
		assertEquals(fixture.hashCode(), equalShape.hashCode());
		assertTrue(equalShape.equals(fixture));

		// Check that changing a variable makes the objects unequal
		Shape unequalShape = (Shape) equalShape.clone();
		unequalShape.setId(1);
		assertFalse(fixture.equals(unequalShape));
		assertFalse(fixture.equals(unequalShape));
		assertNotEquals(fixture.hashCode(), unequalShape.hashCode());

		// Check that having different properties makes the objects unequal
		unequalShape = (Shape) equalShape.clone();
		unequalShape.setProperty("testProperty", 1);
		assertFalse(fixture.equals(unequalShape));
		assertFalse(fixture.equals(unequalShape));
		assertNotEquals(fixture.hashCode(), unequalShape.hashCode());

		// Check that having a different set of properties makes the objects
		// unequal
		unequalShape = (Shape) equalShape.clone();
		unequalShape.setProperty("extraProperty", 1);
		assertFalse(fixture.equals(unequalShape));
		assertFalse(fixture.equals(unequalShape));
		assertNotEquals(fixture.hashCode(), unequalShape.hashCode());

		// Check that having different children makes the objects unequal
		unequalShape = (Shape) equalShape.clone();
		unequalShape.removeNode(unequalShape.getNodes().get(0));
		assertFalse(fixture.equals(unequalShape));
		assertFalse(fixture.equals(unequalShape));
		assertNotEquals(fixture.hashCode(), unequalShape.hashCode());

		// Check that adding a node also makes them unequal
		unequalShape = (Shape) equalShape.clone();
		Shape unequalChild = GeometryFactory.eINSTANCE.createShape();
		unequalShape.addNode(unequalChild);
		assertFalse(fixture.equals(unequalShape));
		assertFalse(fixture.equals(unequalShape));
		assertNotEquals(fixture.hashCode(), unequalShape.hashCode());
	}

} // HeatExchangerTest
