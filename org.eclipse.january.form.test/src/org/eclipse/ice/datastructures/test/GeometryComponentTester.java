/*******************************************************************************
 * Copyright (c) 2012, 2016 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - Jay Jay Billings,
 *   Jordan H. Deyton, Dasha Gorin, Alexander J. McCaskey, Taylor Patterson,
 *   Claire Saunders, Matthew Wang, Anna Wojtowicz
 *******************************************************************************/
package org.eclipse.ice.datastructures.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import org.eclipse.january.form.BasicVisitHandler;
import org.eclipse.january.form.Component;
import org.eclipse.january.form.GeometryComponent;
import org.eclipse.january.form.IVisitHandler;
import org.eclipse.january.form.IVisitor;
import org.eclipse.january.geometry.Cube;
import org.eclipse.january.geometry.Cylinder;
import org.eclipse.january.geometry.Geometry;
import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.INode;
import org.eclipse.january.geometry.Intersection;
import org.eclipse.january.geometry.Operator;
import org.eclipse.january.geometry.Shape;
import org.eclipse.january.geometry.Sphere;
import org.junit.Test;

/**
 * <p>
 * Tests the GeometryComponent class
 * </p>
 *
 * @author Jay Jay Billings
 */
public class GeometryComponentTester {
	
	/**
	 * <p>
	 * Checks whether a ComplexShape and a PrimitiveShape
	 * <span style="font-size:16pt;"></span>can be added, returned, and removed
	 * from a GeometryComponent
	 * </p>
	 *
	 */
	@Test
	public void checkAddShapes() {

		// Create a shape
		Geometry geometryShape = GeometryFactory.eINSTANCE.createGeometry();

		// Instantiate a GeometryComponent
		GeometryComponent geometry = new GeometryComponent();
		geometry.setGeometry(geometryShape);

		// Add a PrimitiveShape
		Sphere sphere = GeometryFactory.eINSTANCE.createSphere();
		geometry.getGeometry().addNode(sphere);
		assertEquals(1, geometry.getGeometry().getNodes().size());
		assertTrue(sphere == geometry.getGeometry().getNodes().get(0));

		// Add a ComplexShape
		Operator complex = GeometryFactory.eINSTANCE.createOperator();
		geometry.getGeometry().addNode(complex);
		assertEquals(2, geometry.getGeometry().getNodes().size());
		assertTrue(complex == geometry.getGeometry().getNodes().get(1));

		// Try adding null
		geometry.getGeometry().addNode(null);
		assertEquals(2, geometry.getGeometry().getNodes().size());

		// Add a shape with an unknown concrete type
		Shape unknownShape = GeometryFactory.eINSTANCE.createShape();
		geometry.getGeometry().addNode(unknownShape);
		assertEquals(3, geometry.getGeometry().getNodes().size());
		assertTrue(unknownShape == geometry.getGeometry().getNodes().get(2));

		// Remove the second shape
		geometry.getGeometry().removeNode(complex);
		assertEquals(2, geometry.getGeometry().getNodes().size());

		// Steal the list from the GeometryComponent
		List<INode> shapes = geometry.getGeometry().getNodes();
		assertEquals(2, shapes.size());

		// Remove a shape from the stolen list
		shapes.remove(0);
		assertEquals(1, shapes.size());

	}

	/**
	 * <p>
	 * This operation checks the shape to ensure that it can be correctly
	 * visited by a realization of the IComponent interface.
	 * </p>
	 *
	 */
	@Test
	public void checkVisitation() {

		// Instantiate TestVisitor
		TestVisitor testVisitor = new TestVisitor();

		// Instantiate TestShape
		Component unknownComponent = new GeometryComponent();

		// Call accept operation
		unknownComponent.accept(testVisitor);

		// Check that testVisitor was visited
		assertTrue(testVisitor.wasVisited());
		
	}

	/**
	 * <p>
	 * This operation checks the ability of the GeometryComponent to update its
	 * Entries.
	 * </p>
	 *
	 */
	@Test
	public void checkUpdate() {
		// Not implemented
	}

	/**
	 * <p>
	 * This operation tests the GeometryComponent to ensure that it can properly
	 * dispatch notifications when it receives an update that changes its state.
	 * </p>
	 *
	 */
	@Test
	public void checkNotifications() {

		// Create a shape
		Geometry geometryShape = GeometryFactory.eINSTANCE.createGeometry();

		// Create a new listener and add it to a GeometryComponent
		GeometryComponent geometry = new GeometryComponent();
		geometry.setGeometry(geometryShape);
		TestComponentListener listener = new TestComponentListener();
		geometry.register(listener);

		// Modify geometryComponent's shapes list
		geometry.getGeometry().addNode(GeometryFactory.eINSTANCE.createShape());

		// Check that the listener was notified and reset the listener
		assertTrue(listener.wasNotified());
		listener.reset();

		// Change geometryComponent's Name
		geometry.setName("name");

		// Check that the listener was notified and reset the listener
		assertTrue(listener.wasNotified());
		listener.reset();

		// Set a name
		geometry.setName("name");

		// Check that the listener was notified and reset the listener
		assertTrue(listener.wasNotified());
		listener.reset();

		// Set an ID
		geometry.setId(3);

		// Check that the listener was notified and reset the listener
		assertTrue(listener.wasNotified());
		listener.reset();

	}

	/**
	 * <p>
	 * This operation checks the GeometryComponent to ensure that its equals()
	 * and hashcode() operations work.
	 * </p>
	 *
	 */
	@Test
	public void checkEquality() {

		Geometry geometryShape = GeometryFactory.eINSTANCE.createGeometry();

		// Create GeometryComponent to test
		GeometryComponent component = new GeometryComponent();
		GeometryComponent equalComponent = new GeometryComponent();
		GeometryComponent unEqualComponent = new GeometryComponent();
		GeometryComponent transitiveComponent = new GeometryComponent();
		component.setGeometry(geometryShape);
		equalComponent.setGeometry((Geometry) geometryShape.clone());
		unEqualComponent.setGeometry((Geometry) geometryShape.clone());
		transitiveComponent.setGeometry((Geometry) geometryShape.clone());

		// Change values
		Cylinder shape = GeometryFactory.eINSTANCE.createCylinder();
		Intersection weirdShape = GeometryFactory.eINSTANCE.createIntersection();

		component.getGeometry().addNode(shape);
		equalComponent.getGeometry().addNode((Cylinder) shape.clone());
		transitiveComponent.getGeometry().addNode((Cylinder) shape.clone());

		unEqualComponent.getGeometry().addNode(weirdShape);

		// Set ICEObject data
		component.setId(1);
		equalComponent.setId(1);
		transitiveComponent.setId(1);
		unEqualComponent.setId(2);

		component.setName("DC 5V");
		equalComponent.setName("DC 5V");
		transitiveComponent.setName("DC 5V");
		unEqualComponent.setName("AC 115V");

		// Assert two equal ComplexShapes return true
		assertTrue(component.equals(equalComponent));

		// Assert two unequal ComplexShapes return false
		assertFalse(component.equals(unEqualComponent));

		// Assert equals() is reflexive
		assertTrue(component.equals(component));

		// Assert the equals() is Symmetric
		assertTrue(component.equals(equalComponent)
				&& equalComponent.equals(component));

		// Assert equals() is transitive
		if (component.equals(equalComponent)
				&& equalComponent.equals(transitiveComponent)) {
			assertTrue(component.equals(transitiveComponent));
		} else {
			fail();
		}

		// Assert equals is consistent
		assertTrue(component.equals(equalComponent)
				&& component.equals(equalComponent)
				&& component.equals(equalComponent));
		assertTrue(!component.equals(unEqualComponent)
				&& !component.equals(unEqualComponent)
				&& !component.equals(unEqualComponent));

		// Assert checking equality with null is false
		assertFalse(component == null);

		// Assert that two equal objects return same hashcode
		assertTrue(component.equals(equalComponent)
				&& component.hashCode() == equalComponent.hashCode());

		// Assert that hashcode is consistent
		assertTrue(component.hashCode() == component.hashCode());

		// Assert that hashcodes from unequal objects are different
		assertTrue(component.hashCode() != unEqualComponent.hashCode());

	}

	/**
	 * <p>
	 * This operation tests the construction of the GeometryComponent class and
	 * the functionality inherited from ICEObject.
	 * </p>
	 *
	 */
	@Test
	public void checkCreation() {

		// Create a shape
		Geometry geometryShape = GeometryFactory.eINSTANCE.createGeometry();

		// Create a new GeometryComponent
		GeometryComponent geometry = new GeometryComponent();
		geometry.setGeometry(geometryShape);

		// Check that the shapes list exists but is empty
		assertNotNull(geometry.getGeometry().getNodes());
		assertTrue(geometry.getGeometry().getNodes().isEmpty());

	}

	/**
	 * <p>
	 * This operation checks the GeometryComponent to ensure that its copy() and
	 * clone() operations work as specified.
	 * </p>
	 *
	 */
	@Test
	public void checkCopying() {

		// Create a shape
		Geometry geometryShape = GeometryFactory.eINSTANCE.createGeometry();

		GeometryComponent geometry = new GeometryComponent();
		GeometryComponent cloneGeometry;
		GeometryComponent copyGeometry;
		geometry.setGeometry(geometryShape);

		// Set up ICEObject stuff for GeometryComponent
		geometry.setId(25);
		geometry.setDescription("Geometry description");
		geometry.setName("Geometry name");

		// Set up GeometryComponent-specific stuff
		Sphere sphere1 = GeometryFactory.eINSTANCE.createSphere();

		Cube cube1 = GeometryFactory.eINSTANCE.createCube();

		geometry.getGeometry().addNode(sphere1);
		geometry.getGeometry().addNode(cube1);
		// Clone contents
		cloneGeometry = (GeometryComponent) geometry.clone();

		assertNotNull(cloneGeometry);

		// Check equality of contents
		assertTrue(cloneGeometry.equals(geometry));

		// Copy contents
		copyGeometry = new GeometryComponent();
		copyGeometry.copy(geometry);

		// Check equality of contents
		assertTrue(copyGeometry.equals(geometry));

		// Pass null into copy contents, show nothing has changed
		copyGeometry.copy(null);

		// Check equality of contents
		assertTrue(copyGeometry.equals(geometry));

	}
}