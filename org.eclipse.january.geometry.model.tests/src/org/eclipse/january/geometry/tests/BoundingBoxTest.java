/**
 */
package org.eclipse.january.geometry.tests;

import org.eclipse.january.geometry.BoundingBox;
import org.eclipse.january.geometry.GeometryFactory;

import junit.framework.TestCase;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Bounding
 * Box</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 * <li>{@link org.eclipse.january.geometry.BoundingBox#addArea(org.eclipse.january.geometry.BoundingBox)
 * <em>Add Area</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class BoundingBoxTest extends TestCase {

	/**
	 * The fixture for this Bounding Box test case. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected BoundingBox fixture = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(BoundingBoxTest.class);
	}

	/**
	 * Constructs a new Bounding Box test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BoundingBoxTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Bounding Box test case. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void setFixture(BoundingBox fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Bounding Box test case. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected BoundingBox getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GeometryFactory.eINSTANCE.createBoundingBox());
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
	 * Tests the
	 * '{@link org.eclipse.january.geometry.BoundingBox#addArea(org.eclipse.january.geometry.BoundingBox)
	 * <em>Add Area</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.january.geometry.BoundingBox#addArea(org.eclipse.january.geometry.BoundingBox)
	 * @generated NOT
	 */
	public void testAddArea__BoundingBox() {

		// A bounding box should start out with all values 0.
		assertEquals(0, fixture.getMaxX(), 0.1);
		assertEquals(0, fixture.getMaxY(), 0.1);
		assertEquals(0, fixture.getMaxZ(), 0.1);
		assertEquals(0, fixture.getMinX(), 0.1);
		assertEquals(0, fixture.getMinY(), 0.1);
		assertEquals(0, fixture.getMinZ(), 0.1);

		// Create a box with coordinates at 10.
		BoundingBox box1 = GeometryFactory.eINSTANCE.createBoundingBox();
		box1.setMaxX(10);
		box1.setMaxY(10);
		box1.setMaxZ(10);
		box1.setMinX(-10);
		box1.setMinY(-10);
		box1.setMinZ(-10);

		// Add the box to the fixture and chech that it now has the right
		// extrema.
		fixture.addArea(box1);
		assertEquals(10, fixture.getMaxX(), 0.1);
		assertEquals(10, fixture.getMaxY(), 0.1);
		assertEquals(10, fixture.getMaxZ(), 0.1);
		assertEquals(-10, fixture.getMinX(), 0.1);
		assertEquals(-10, fixture.getMinY(), 0.1);
		assertEquals(-10, fixture.getMinZ(), 0.1);

		// Add a box that fits inside the fixture. This should not change
		// anything.
		BoundingBox box2 = GeometryFactory.eINSTANCE.createBoundingBox();
		box2.setMaxX(5);
		fixture.addArea(box2);
		assertEquals(10, fixture.getMaxX(), 0.1);
		assertEquals(10, fixture.getMaxY(), 0.1);
		assertEquals(10, fixture.getMaxZ(), 0.1);
		assertEquals(-10, fixture.getMinX(), 0.1);
		assertEquals(-10, fixture.getMinY(), 0.1);
		assertEquals(-10, fixture.getMinZ(), 0.1);

		// Add a box that lies partially outside the fixture. The dimensions
		// should increase to include it
		BoundingBox box3 = GeometryFactory.eINSTANCE.createBoundingBox();
		box3.setMaxX(80);
		box3.setMaxY(80);
		box3.setMaxZ(5);
		box3.setMinX(-5);
		box3.setMinY(-5);
		box3.setMinZ(-80);
		fixture.addArea(box3);
		assertEquals(80, fixture.getMaxX(), 0.1);
		assertEquals(80, fixture.getMaxY(), 0.1);
		assertEquals(10, fixture.getMaxZ(), 0.1);
		assertEquals(-10, fixture.getMinX(), 0.1);
		assertEquals(-10, fixture.getMinY(), 0.1);
		assertEquals(-80, fixture.getMinZ(), 0.1);
	}

} // BoundingBoxTest
