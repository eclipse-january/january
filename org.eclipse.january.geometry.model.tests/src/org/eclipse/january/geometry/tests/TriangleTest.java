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
import org.eclipse.january.geometry.Triangle;
import org.eclipse.january.geometry.Vertex;

import junit.framework.TestCase;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Triangle</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.Triangle#equals(java.lang.Object) <em>Equals</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.Triangle#hashCode() <em>Hash Code</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class TriangleTest extends TestCase {

	/**
	 * The fixture for this Triangle test case.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected Triangle fixture = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TriangleTest.class);
	}

	/**
	 * Constructs a new Triangle test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TriangleTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Triangle test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Triangle fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Triangle test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Triangle getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GeometryFactory.eINSTANCE.createTriangle());
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
	 * Tests the '
	 * {@link org.eclipse.january.geometry.Triangle#equals(java.lang.Object)
	 * <em>Equals</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.january.geometry.Triangle#equals(java.lang.Object)
	 * @generated NOT
	 */
	public void testEquals__Object() {

		// The normal that is equal to the fixture's
		Vertex equalNormal = GeometryFactory.eINSTANCE.createVertex();
		equalNormal.setX(1d);

		// The fixture's first vertex
		Vertex equalV1 = GeometryFactory.eINSTANCE.createVertex();
		equalV1.setX(0);
		equalV1.setY(0);
		equalV1.setZ(0);

		// The fixture's second vertex
		Vertex equalV2 = GeometryFactory.eINSTANCE.createVertex();
		equalV2.setX(1);
		equalV2.setY(1);
		equalV2.setZ(1);

		// The fixture's third vertex
		Vertex equalV3 = GeometryFactory.eINSTANCE.createVertex();
		equalV3.setX(2);
		equalV3.setY(2);
		equalV3.setZ(2);

		// Set the triangle's vertices
		fixture.setNormal(equalNormal);
		fixture.getVertices().add(equalV1);
		fixture.getVertices().add(equalV2);
		fixture.getVertices().add(equalV3);

		// Triangles should equal themselves
		assertTrue(fixture.equals(fixture));

		// Hash codes should be equal if and only if triangles are equal
		assertTrue(fixture.hashCode() == fixture.hashCode());

		// Triangles should not equal null or non-triangles
		assertFalse(fixture.equals(null));
		assertFalse(fixture.equals("invalid object"));

		// Create a triangle with the same values as the fixture
		Triangle equalTri = GeometryFactory.eINSTANCE.createTriangle();
		equalTri.setNormal((Vertex) equalNormal.clone());
		equalTri.getVertices().add((Vertex) equalV1.clone());
		equalTri.getVertices().add((Vertex) equalV2.clone());
		equalTri.getVertices().add((Vertex) equalV3.clone());

		// Two equivalent triangles should be equal
		assertTrue(fixture.equals(equalTri));
		assertTrue(fixture.hashCode() == equalTri.hashCode());

		// Equality should be symmetric
		assertTrue(equalTri.equals(fixture));

		// Create a triangle with the same values as the fixture, but with the
		// vertices specified in a different order
		Triangle rotatedTri = GeometryFactory.eINSTANCE.createTriangle();
		rotatedTri.setNormal((Vertex) equalNormal.clone());
		rotatedTri.getVertices().add((Vertex) equalV2.clone());
		rotatedTri.getVertices().add((Vertex) equalV3.clone());
		rotatedTri.getVertices().add((Vertex) equalV1.clone());

		// The triangles should be equal despite their vertices being in a
		// different order
		assertTrue(rotatedTri.equals(fixture));
		assertTrue(rotatedTri.hashCode() == fixture.hashCode());

		// A fourth vertex not in the triangle
		Vertex unequalV = GeometryFactory.eINSTANCE.createVertex();
		unequalV.setX(3);
		unequalV.setY(3);
		unequalV.setZ(3);

		// Create a triangle with different values from the fixture
		Triangle unequalTri = GeometryFactory.eINSTANCE.createTriangle();
		unequalTri.setNormal((Vertex) equalNormal.clone());
		unequalTri.getVertices().add((Vertex) equalV1.clone());
		unequalTri.getVertices().add((Vertex) equalV2.clone());
		unequalTri.getVertices().add((Vertex) unequalV.clone());

		// Triangels with different vertices should not be equal
		assertFalse(fixture.equals(unequalTri));

	}

	/**
	 * Tests the '{@link org.eclipse.january.geometry.Triangle#hashCode()
	 * <em>Hash Code</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.january.geometry.Triangle#hashCode()
	 * @generated NOT
	 */
	public void testHashCode() {
		// Nothing to do. See testEquals__Object instead.
	}

} // TriangleTest
