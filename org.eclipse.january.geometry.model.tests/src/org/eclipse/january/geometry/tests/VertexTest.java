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

import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.Vertex;

import junit.framework.TestCase;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Vertex</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.Vertex#clone() <em>Clone</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.Vertex#equals(java.lang.Object) <em>Equals</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.Vertex#hashCode() <em>Hash Code</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class VertexTest extends TestCase {

	/**
	 * The fixture for this Vertex test case.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected Vertex fixture = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(VertexTest.class);
	}

	/**
	 * Constructs a new Vertex test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VertexTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Vertex test case.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Vertex fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Vertex test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Vertex getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GeometryFactory.eINSTANCE.createVertex());
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
	 * Tests the '{@link org.eclipse.january.geometry.Vertex#clone()
	 * <em>Clone</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.january.geometry.Vertex#clone()
	 * @generated NOT
	 */
	public void testClone() {

		// Initialize the vertex's fields
		fixture.setX(1d);
		fixture.setY(2d);
		fixture.setZ(3d);

		// Create a clone
		Vertex clone = (Vertex) fixture.clone();

		// Check that clones are of the proper type
		assertTrue(fixture.clone() instanceof Vertex);

		// Check that the clone's coordinates are right
		assertEquals(1d, fixture.getX());
		assertEquals(2d, fixture.getY());
		assertEquals(3d, fixture.getZ());
	}

	/**
	 * Tests the '
	 * {@link org.eclipse.january.geometry.Vertex#equals(java.lang.Object)
	 * <em>Equals</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.january.geometry.Vertex#equals(java.lang.Object)
	 * @generated NOT
	 */
	public void testEquals__Object() {

		// Set the fixture's coordinate
		fixture.setX(0);
		fixture.setY(1);
		fixture.setZ(2);

		// Create another vertex with the same coordinates
		Vertex equalVertex = GeometryFactory.eINSTANCE.createVertex();
		equalVertex.setX(0);
		equalVertex.setY(1);
		equalVertex.setZ(2);

		// Vertices should equal themselves
		assertTrue(fixture.equals(fixture));

		// Vertices' hash codes should be equal if and only if the vertices
		// themsevles are equal
		assertEquals(fixture.hashCode(), fixture.hashCode());

		// Vertices should not be equal to non-vertices
		assertFalse(fixture.equals(null));
		assertFalse(fixture.equals("invalid object"));

		// Check that two equivalent vertices are equal
		assertTrue(fixture.equals(equalVertex));
		assertEquals(fixture.hashCode(), equalVertex.hashCode());

		// Equality should be symmetric
		assertTrue(equalVertex.equals(fixture));

		// Create a vertex at a different point
		Vertex unequalVertex = GeometryFactory.eINSTANCE.createVertex();
		equalVertex.setX(3);
		equalVertex.setY(1);
		equalVertex.setZ(2);

		// The two vertices should not be equal
		assertFalse(fixture.equals(unequalVertex));
		assertNotEquals(fixture.hashCode(), unequalVertex.hashCode());
	}

	/**
	 * Tests the '{@link org.eclipse.january.geometry.Vertex#hashCode()
	 * <em>Hash Code</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.january.geometry.Vertex#hashCode()
	 * @generated NOT
	 */
	public void testHashCode() {
		// Nothing to do. See testEquals_Object() instead.
	}

} // VertexTest
