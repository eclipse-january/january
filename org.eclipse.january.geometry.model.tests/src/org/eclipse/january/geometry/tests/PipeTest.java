/**
 */
package org.eclipse.january.geometry.tests;

import static org.junit.Assert.assertNotEquals;

import org.eclipse.january.geometry.BoundingBox;
import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.Pipe;
import org.eclipse.january.geometry.Shape;
import org.eclipse.january.geometry.impl.PipeImpl;
import org.junit.Test;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object
 * '<em><b>Pipe</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 * <li>{@link org.eclipse.january.geometry.Pipe#getLowerEdge() <em>Get Lower
 * Edge</em>}</li>
 * <li>{@link org.eclipse.january.geometry.Pipe#getUpperEdge() <em>Get Upper
 * Edge</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class PipeTest extends TubeTest {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PipeTest.class);
	}

	/**
	 * Constructs a new Pipe test case with the given name. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PipeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Pipe test case. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected Pipe getFixture() {
		return (Pipe) fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GeometryFactory.eINSTANCE.createPipe());
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
	 * Tests the '{@link org.eclipse.january.geometry.Pipe#getLowerEdge()
	 * <em>Get Lower Edge</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.january.geometry.Pipe#getLowerEdge()
	 * @generated NOT
	 */
	public void testGetLowerEdge() {

		// Create a pipe that will roughly fill a 20 x 20 x 20 box centered on
		// the origin
		getFixture().setHeight(20);
		getFixture().setRadius(10);

		// Get the bounding box
		BoundingBox box = getFixture().getLowerEdge();

		// The lower edge should be a radius 10 circle located 10 units above
		// the XZ plane
		assertEquals(10d, box.getMaxX(), 0.1);
		assertEquals(10d, box.getMaxY(), 0.1);
		assertEquals(10d, box.getMaxZ(), 0.1);
		assertEquals(-10d, box.getMinX(), 0.1);
		assertEquals(10d, box.getMinY(), 0.1);
		assertEquals(-10d, box.getMinZ(), 0.1);

		// Cutting the height in half should move the circle up
		getFixture().setHeight(10);
		box = getFixture().getLowerEdge();
		assertEquals(10d, box.getMaxX(), 0.1);
		assertEquals(5d, box.getMaxY(), 0.1);
		assertEquals(10d, box.getMaxZ(), 0.1);
		assertEquals(-10d, box.getMinX(), 0.1);
		assertEquals(5d, box.getMinY(), 0.1);
		assertEquals(-10d, box.getMinZ(), 0.1);

		// Reducing the radius should make the circle smaller
		getFixture().setRadius(5);
		box = getFixture().getLowerEdge();
		assertEquals(5d, box.getMaxX(), 0.1);
		assertEquals(5d, box.getMaxY(), 0.1);
		assertEquals(5d, box.getMaxZ(), 0.1);
		assertEquals(-5d, box.getMinX(), 0.1);
		assertEquals(5d, box.getMinY(), 0.1);
		assertEquals(-5d, box.getMinZ(), 0.1);
	}

	/**
	 * Tests the '{@link org.eclipse.january.geometry.Pipe#getUpperEdge()
	 * <em>Get Upper Edge</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.january.geometry.Pipe#getUpperEdge()
	 * @generated NOT
	 */
	public void testGetUpperEdge() {

		// Create a pipe that will roughly fill a 20 x 20 x 20 box centered on
		// the origin
		getFixture().setHeight(20);
		getFixture().setRadius(10);

		// Get the bounding box
		BoundingBox box = getFixture().getUpperEdge();

		// The lower edge should be a radius 10 circle located 10 units below
		// the XZ plane
		assertEquals(10d, box.getMaxX(), 0.1);
		assertEquals(-10d, box.getMaxY(), 0.1);
		assertEquals(10d, box.getMaxZ(), 0.1);
		assertEquals(-10d, box.getMinX(), 0.1);
		assertEquals(-10d, box.getMinY(), 0.1);
		assertEquals(-10d, box.getMinZ(), 0.1);

		// Cutting the height in half should move the circle up
		getFixture().setHeight(10);
		box = getFixture().getUpperEdge();
		assertEquals(10d, box.getMaxX(), 0.1);
		assertEquals(-5d, box.getMaxY(), 0.1);
		assertEquals(10d, box.getMaxZ(), 0.1);
		assertEquals(-10d, box.getMinX(), 0.1);
		assertEquals(-5d, box.getMinY(), 0.1);
		assertEquals(-10d, box.getMinZ(), 0.1);

		// Reducing the radius should make the circle smaller
		getFixture().setRadius(5);
		box = getFixture().getUpperEdge();
		assertEquals(5d, box.getMaxX(), 0.1);
		assertEquals(-5d, box.getMaxY(), 0.1);
		assertEquals(5d, box.getMaxZ(), 0.1);
		assertEquals(-5d, box.getMinX(), 0.1);
		assertEquals(-5d, box.getMinY(), 0.1);
		assertEquals(-5d, box.getMinZ(), 0.1);
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
		assertTrue(fixture.clone() instanceof PipeImpl);
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
		Pipe equalShape = GeometryFactory.eINSTANCE.createPipe();

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
} // PipeTest
