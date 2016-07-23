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
import org.eclipse.january.geometry.Sphere;

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

} // SphereTest
