/*******************************************************************************
 * Copyright (c) 2016 UT-Battelle, LLC. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     UT-Battelle, LLC. - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.january.geometry.tests;

import static org.junit.Assert.assertNotEquals;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.january.geometry.Geometry;
import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.january.geometry.Operator;
import org.eclipse.january.geometry.Shape;
import org.eclipse.january.geometry.Vertex;
import org.eclipse.january.geometry.impl.GeometryImpl;

import junit.framework.TestCase;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object
 * '<em><b>Geometry</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 * <li>{@link org.eclipse.january.geometry.INode#changeDecoratorProperty(java.lang.String, java.lang.Object)
 * <em>Change Decorator Property</em>}</li>
 * <li>{@link org.eclipse.january.geometry.INode#getPropertyNames() <em>Get
 * Property Names</em>}</li>
 * <li>{@link org.eclipse.january.geometry.INode#getProperty(java.lang.String)
 * <em>Get Property</em>}</li>
 * <li>{@link org.eclipse.january.geometry.INode#setProperty(java.lang.String, double)
 * <em>Set Property</em>}</li>
 * <li>{@link org.eclipse.january.geometry.INode#addNode(org.eclipse.january.geometry.INode)
 * <em>Add Node</em>}</li>
 * <li>{@link org.eclipse.january.geometry.INode#removeNode(org.eclipse.january.geometry.INode)
 * <em>Remove Node</em>}</li>
 * <li>{@link org.eclipse.january.geometry.INode#copy(java.lang.Object)
 * <em>Copy</em>}</li>
 * <li>{@link org.eclipse.january.geometry.INode#clone() <em>Clone</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class GeometryTest extends TestCase {

	/**
	 * The fixture for this Geometry test case. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected Geometry fixture = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GeometryTest.class);
	}

	/**
	 * Constructs a new Geometry test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GeometryTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Geometry test case. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void setFixture(Geometry fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Geometry test case. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Geometry getFixture() {
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
		setFixture(GeometryFactory.eINSTANCE.createGeometry());
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
	 * '{@link org.eclipse.january.geometry.INode#changeDecoratorProperty(java.lang.String, java.lang.Object)
	 * <em>Change Decorator Property</em>}' operation. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.january.geometry.INode#changeDecoratorProperty(java.lang.String,
	 *      java.lang.Object)
	 * @generated NOT
	 */
	public void testChangeDecoratorProperty__String_Object() {

		// Whether or not a notification was received
		AtomicBoolean notified = new AtomicBoolean();
		notified.set(false);

		// Add an adapter to check for notifications
		fixture.eAdapters().add(new AdapterImpl() {

			@Override
			public void notifyChanged(Notification notification) {

				// Check that the notification has the right feature ID, the
				// property name as the old value, and the property value as the
				// new value
				if (notification.getFeatureID(
						GeometryFactory.class) == GeometryPackage.INODE___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT
						&& "test".equals(notification.getOldValue())
						&& "value".equals((notification.getNewValue()))) {
					notified.set(true);
				}
			}

		});
		fixture.changeDecoratorProperty("test", "value");

		// Check that the notification was received
		assertTrue(notified.get());
	}

	/**
	 * Tests the '{@link org.eclipse.january.geometry.INode#getPropertyNames()
	 * <em>Get Property Names</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.january.geometry.INode#getPropertyNames()
	 * @generated NOT
	 */
	public void testGetPropertyNames() {

		// Give the operator some properties
		fixture.setProperty("name1", 1);
		fixture.setProperty("name2", 2);
		fixture.setProperty("name3", 3);

		// Get the list of property names and check that it is populated
		// correctly
		List<String> names = fixture.getPropertyNames();
		assertTrue(names.contains("name1"));
		assertTrue(names.contains("name2"));
		assertTrue(names.contains("name3"));
	}

	/**
	 * Tests the
	 * '{@link org.eclipse.january.geometry.INode#getProperty(java.lang.String)
	 * <em>Get Property</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.january.geometry.INode#getProperty(java.lang.String)
	 * @generated NOT
	 */
	public void testGetProperty__String() {

		// Set some properties
		fixture.setProperty("property1", 1);
		fixture.setProperty("property2", 2);
		fixture.setProperty("property3", 3);

		// Check that the properties were saved
		assertEquals(1d, fixture.getProperty("property1"));
		assertEquals(2d, fixture.getProperty("property2"));
		assertEquals(3d, fixture.getProperty("property3"));
	}

	/**
	 * Tests the
	 * '{@link org.eclipse.january.geometry.INode#setProperty(java.lang.String, double)
	 * <em>Set Property</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.january.geometry.INode#setProperty(java.lang.String,
	 *      double)
	 * @generated NOT
	 */
	public void testSetProperty__String_double() {
		// Nothing to do here. See testGetProperty__String() instead.
	}

	/**
	 * Tests the
	 * '{@link org.eclipse.january.geometry.INode#addNode(org.eclipse.january.geometry.INode)
	 * <em>Add Node</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.january.geometry.INode#addNode(org.eclipse.january.geometry.INode)
	 * @generated NOT
	 */
	public void testAddNode__INode() {

		// Create two child nodes
		Operator child1 = GeometryFactory.eINSTANCE.createOperator();
		child1.setName("child1");
		Operator child2 = GeometryFactory.eINSTANCE.createOperator();
		child2.setName("child2");

		// Add the children to a test object
		fixture.addNode(child1);
		fixture.addNode(child2);

		// Check that the children are in the nodes list
		assertTrue("child1".equals(fixture.getNodes().get(0).getName()));
		assertTrue("child2".equals(fixture.getNodes().get(1).getName()));

		// Try adding null
		fixture.addNode(null);

		// The list shouldn't have changed
		assertEquals(2, fixture.getNodes().size());

		// Try adding a node that's already in the list
		fixture.addNode(child1);

		// The list shouldn't have changed
		assertEquals(2, fixture.getNodes().size());

		// Remove a child from the list
		fixture.removeNode(child1);

		// Check that the child is now gone
		assertEquals(1, fixture.getNodes().size());
		assertTrue("child2".equals(fixture.getNodes().get(0).getName()));

		// Try removing it again
		fixture.removeNode(child1);

		// The list shouldn't have changed
		assertEquals(1, fixture.getNodes().size());

		// Try removing null
		fixture.removeNode(null);

		// The list shouldn't have changed
		assertEquals(1, fixture.getNodes().size());
	}

	/**
	 * Tests the
	 * '{@link org.eclipse.january.geometry.INode#removeNode(org.eclipse.january.geometry.INode)
	 * <em>Remove Node</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.january.geometry.INode#removeNode(org.eclipse.january.geometry.INode)
	 * @generated NOT
	 */
	public void testRemoveNode__INode() {
		// Nothing to do. See testAddNode_INode() instead.
	}

	/**
	 * Tests the
	 * '{@link org.eclipse.january.geometry.INode#copy(java.lang.Object)
	 * <em>Copy</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.january.geometry.INode#copy(java.lang.Object)
	 * @generated NOT
	 */
	public void testCopy__Object() {

		// Create two shapes
		Shape shape1 = GeometryFactory.eINSTANCE.createShape();
		shape1.setName("shape1");
		Shape shape2 = GeometryFactory.eINSTANCE.createShape();
		shape2.setName("shape2");

		// Add the shapes to the parent
		fixture.addNode(shape1);
		fixture.addNode(shape2);

		// Set the shape's center
		Vertex center = GeometryFactory.eINSTANCE.createVertex();
		center.setX(8d);
		fixture.setCenter(center);

		// Set the shape's data members.
		fixture.setId(1);
		fixture.setName("test");
		fixture.setType("testType");
		fixture.setProperty("testProperty", 4);

		// Set the shape's parent
		Operator parent = GeometryFactory.eINSTANCE.createOperator();
		fixture.setParent(parent);

		// Create a copy
		Geometry clone = GeometryFactory.eINSTANCE.createGeometry();
		clone.copy(fixture);

		// The clone's nodes should have also been cloned
		assertTrue("shape1".equals(clone.getNodes().get(0).getName()));
		assertTrue("shape2".equals(clone.getNodes().get(1).getName()));

		// Check that the operator has the correct center
		assertTrue(8d == clone.getCenter().getX());

		// Check the operator's data members
		assertTrue(1 == clone.getId());
		assertTrue("test".equals(clone.getName()));
		assertTrue("testType".equals(clone.getType()));
		assertTrue(4.0 == clone.getProperty("testProperty"));

		// The clone should not kept a reference to the original's parent
		assertNull(clone.getParent());

		// Try to copy something that isn't an operator
		fixture.copy("invalid object");

		// Make sure that nothing changed
		assertTrue("shape1".equals(clone.getNodes().get(0).getName()));
		assertTrue("shape2".equals(clone.getNodes().get(1).getName()));

		// Check that the operator has the correct center
		assertTrue(8d == clone.getCenter().getX());

		// Check the operator's data members
		assertTrue(1 == clone.getId());
		assertTrue("test".equals(clone.getName()));
		assertTrue("testType".equals(clone.getType()));
		assertTrue(4 == clone.getProperty("testProperty"));
	}

	/**
	 * Tests the '{@link org.eclipse.january.geometry.INode#clone()
	 * <em>Clone</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.january.geometry.INode#clone()
	 * @generated NOT
	 */
	public void testClone() {

		// Check that the clone is of the correct type.
		assertTrue(fixture.clone() instanceof GeometryImpl);
	}

	/**
	 * Check that geometries can be tested for equality correctly.
	 * 
	 * @generated NOT
	 */
	public void testEquals() {

		// A geometry which will be identical to the feature
		Geometry equalGeometry = GeometryFactory.eINSTANCE.createGeometry();

		// Set some values on the fixture
		fixture.setId(8);
		fixture.setName("equal name");
		fixture.setProperty("testProperty", 0);
		fixture.setType("equal type");

		// Set identical values on the geoemtry
		equalGeometry.setId(8);
		equalGeometry.setName("equal name");
		equalGeometry.setProperty("testProperty", 0);
		equalGeometry.setType("equal type");

		// Create a child shape
		Shape equalChild = GeometryFactory.eINSTANCE.createShape();
		equalChild.setName("equal child");

		// Add the child as a node to the geometries
		fixture.addNode(equalChild);
		equalGeometry.addNode((Shape) equalChild.clone());

		// An object should equal itself, and hash codes should be equal if and
		// only if the objects are themselves equal
		assertTrue(fixture.equals(fixture));
		assertEquals(fixture.hashCode(), fixture.hashCode());

		// Check that the two objects are equal, regardless of order
		assertTrue(fixture.equals(equalGeometry));
		assertEquals(fixture.hashCode(), equalGeometry.hashCode());
		assertTrue(equalGeometry.equals(fixture));

		// Check that changing a variable makes the objects unequal
		Geometry unequalGeometry = (Geometry) equalGeometry.clone();
		unequalGeometry.setId(1);
		assertFalse(fixture.equals(unequalGeometry));
		assertFalse(fixture.equals(unequalGeometry));
		assertNotEquals(fixture.hashCode(), unequalGeometry.hashCode());

		// Check that having different properties makes the objects unequal
		unequalGeometry = (Geometry) equalGeometry.clone();
		unequalGeometry.setProperty("testProperty", 1);
		assertFalse(fixture.equals(unequalGeometry));
		assertFalse(fixture.equals(unequalGeometry));
		assertNotEquals(fixture.hashCode(), unequalGeometry.hashCode());

		// Check that having a different set of properties makes the objects
		// unequal
		unequalGeometry = (Geometry) equalGeometry.clone();
		unequalGeometry.setProperty("extraProperty", 1);
		assertFalse(fixture.equals(unequalGeometry));
		assertFalse(fixture.equals(unequalGeometry));
		assertNotEquals(fixture.hashCode(), unequalGeometry.hashCode());

		// Check that having different children makes the objects unequal
		unequalGeometry = (Geometry) equalGeometry.clone();
		unequalGeometry.removeNode(unequalGeometry.getNodes().get(0));
		assertFalse(fixture.equals(unequalGeometry));
		assertFalse(fixture.equals(unequalGeometry));
		assertNotEquals(fixture.hashCode(), unequalGeometry.hashCode());

		// Check that adding a node also makes them unequal
		unequalGeometry = (Geometry) equalGeometry.clone();
		Shape unequalChild = GeometryFactory.eINSTANCE.createShape();
		unequalGeometry.addNode(unequalChild);
		assertFalse(fixture.equals(unequalGeometry));
		assertFalse(fixture.equals(unequalGeometry));
		assertNotEquals(fixture.hashCode(), unequalGeometry.hashCode());
	}

} // GeometryTest
