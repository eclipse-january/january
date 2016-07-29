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
import org.eclipse.january.geometry.Intersection;
import org.junit.Test;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Intersection</b></em>'. <!-- end-user-doc -->
 * @generated
 */
public class IntersectionTest extends OperatorTest {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(IntersectionTest.class);
	}

	/**
	 * Constructs a new Intersection test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IntersectionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Intersection test case.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Intersection getFixture() {
		return (Intersection)fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GeometryFactory.eINSTANCE.createIntersection());
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
	 * Check that the clone operation returns a copy.
	 * 
	 * @generated NOT
	 */
	@Test
	public void checkClone() {

		// Check that clones are of the proper type
		assertTrue(fixture.clone() instanceof Intersection);
	}

} // IntersectionTest
