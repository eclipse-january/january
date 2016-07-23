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

import org.eclipse.january.geometry.Cube;
import org.eclipse.january.geometry.GeometryFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Cube</b></em>'. <!-- end-user-doc -->
 * @generated
 */
public class CubeTest extends ShapeTest {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CubeTest.class);
	}

	/**
	 * Constructs a new Cube test case with the given name.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	public CubeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Cube test case.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	protected Cube getFixture() {
		return (Cube)fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GeometryFactory.eINSTANCE.createCube());
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
	public void checkProperties() {

		// The cube for testing
		Cube cube = getFixture();

		// Check that the length can be set
		cube.setSideLength(1d);
		assertEquals(1d, cube.getSideLength());

		// Check that invalid values are ignored
		cube.setSideLength(-1d);
		assertEquals(1d, cube.getSideLength());

		// Check that the property map is in sync with the variable
		assertEquals(1d, cube.getProperty("sideLength"));
		cube.setProperty("sideLength", 2d);
		assertEquals(2d, cube.getSideLength());
	}

} // CubeTest
