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

import org.eclipse.january.geometry.Cube;
import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.Shape;
import org.eclipse.january.geometry.Sphere;
import org.eclipse.january.geometry.impl.SphereImpl;
import org.junit.Test;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Sphere</b></em>'. <!-- end-user-doc -->
 * @generated
 */
public class SphereTest extends ShapeTest {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SphereTest.class);
	}

	/**
	 * Constructs a new Sphere test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SphereTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Sphere test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Sphere getFixture() {
		return (Sphere)fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GeometryFactory.eINSTANCE.createSphere());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Check that only valid values are accepted for the properties.
	 * 
	 * @generated NOT
	 */
	@Test
	public void checkProperties() {

		// The sphere for testing
		Sphere sphere = getFixture();

		// Check that the radius can be set
		sphere.setRadius(1d);
		assertEquals(1d, sphere.getRadius());

		// Check that invalid values are ignored
		sphere.setRadius(-1);
		assertEquals(1, sphere.getRadius());

		// Check that the property map is in sync with the variable
		assertEquals(1d, sphere.getProperty("radius"));
		sphere.setProperty("radius", 2d);
		assertEquals(2d, sphere.getRadius());
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
		assertTrue(fixture.clone() instanceof SphereImpl);
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
		Sphere equalShape = GeometryFactory.eINSTANCE.createSphere();

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

} // SphereTest
