/**
 */
package org.eclipse.january.geometry.tests;

import org.eclipse.january.geometry.BoundingBox;
import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.Pipe;
import org.eclipse.january.geometry.impl.PipeImpl;

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

} // PipeTest
