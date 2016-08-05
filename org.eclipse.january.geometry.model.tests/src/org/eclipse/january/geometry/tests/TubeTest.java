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

import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.Tube;
import org.eclipse.january.geometry.impl.TubeImpl;
import org.junit.Test;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Tube</b></em>'. <!-- end-user-doc -->
 * 
 * @generated
 */
public class TubeTest extends ShapeTest {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TubeTest.class);
	}

	/**
	 * Constructs a new Tube test case with the given name. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TubeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Tube test case. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected Tube getFixture() {
		return (Tube) fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GeometryFactory.eINSTANCE.createTube());
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
	 * Check that only valid values are accepted for the properties.
	 * 
	 * @generated NOT
	 */
	@Test
	public void checkProperties() {

		// The tube for testing
		Tube tube = getFixture();

		// Check that the height can be set
		tube.setHeight(1d);
		assertEquals(1d, tube.getHeight());

		// Check that invalid values are ignored
		tube.setHeight(-1d);
		assertEquals(1d, tube.getHeight());

		// Check that the radii can be set
		tube.setInnerRadius(1d);
		assertEquals(1d, tube.getInnerRadius());
		tube.setRadius(2d);
		assertEquals(2d, tube.getInnerRadius());

		// Check that invalid values are ignored
		tube.setInnerRadius(-1d);
		assertEquals(1d, tube.getInnerRadius());
		tube.setRadius(-1d);
		assertEquals(2d, tube.getRadius());

		// innerRadius <= radius
		tube.setInnerRadius(3d);
		assertEquals(1d, tube.getInnerRadius());
		tube.setRadius(0.5d);
		assertEquals(2d, tube.getRadius());

		// Check that the property map is in sync with the variable
		assertEquals(1d, tube.getProperty("height"));
		tube.setProperty("height", 2d);
		assertEquals(2d, tube.getHeight());
		assertEquals(2d, tube.getProperty("radius"));
		tube.setProperty("radius", 3d);
		assertEquals(3d, tube.getInnerRadius());
		assertEquals(1d, tube.getProperty("innerRadius"));
		tube.setProperty("innerRadius", 2d);
		assertEquals(2d, tube.getInnerRadius());

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
		assertTrue(fixture.clone() instanceof TubeImpl);
	}

} // TubeTest
