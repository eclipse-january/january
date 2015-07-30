/*******************************************************************************
 * Copyright (c) 2012, 2014 UT-Battelle, LLC.
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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.eclipse.ice.datastructures.ICEObject.Component;
import org.eclipse.ice.datastructures.ICEObject.ICEJAXBHandler;
import org.eclipse.ice.datastructures.form.GeometryComponent;
import org.eclipse.ice.datastructures.form.geometry.ICEGeometry;
import org.eclipse.ice.datastructures.form.geometry.ICEShape;
import org.eclipse.ice.viz.service.geometry.shapes.Geometry;
import org.eclipse.ice.viz.service.geometry.shapes.OperatorType;
import org.eclipse.ice.viz.service.geometry.shapes.ShapeType;
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
	 * Checks whether a ComplexShape and a PrimitiveShape <span
	 * style="font-size:16pt;"></span>can be added, returned, and removed from a
	 * GeometryComponent
	 * </p>
	 * 
	 */
	@Test
	public void checkAddShapes() {

		// Instantiate a GeometryComponent
		GeometryComponent geometry = new GeometryComponent();
		geometry.setGeometry(new ICEGeometry());

		// Add a PrimitiveShape
		ICEShape sphere = new ICEShape(ShapeType.Sphere);
		geometry.getGeometry().addShape(sphere);
		assertEquals(1, geometry.getGeometry().getShapes().size());
		assertEquals(sphere, geometry.getGeometry().getShapes().get(0));

		// Add a ComplexShape
		ICEShape complex = new ICEShape(OperatorType.Union);
		geometry.getGeometry().addShape(complex);
		assertEquals(2, geometry.getGeometry().getShapes().size());
		assertEquals(complex, geometry.getGeometry().getShapes().get(1));

		// Try adding null
		geometry.getGeometry().addShape(null);
		assertEquals(2, geometry.getGeometry().getShapes().size());

		// Add a shape with an unknown concrete type
		ICEShape unknownShape = new ICEShape(ShapeType.None);
		geometry.getGeometry().addShape(unknownShape);
		assertEquals(3, geometry.getGeometry().getShapes().size());
		assertEquals(unknownShape, geometry.getGeometry().getShapes().get(2));

		// Remove the second shape
		geometry.getGeometry().removeShape(complex);
		assertEquals(2, geometry.getGeometry().getShapes().size());

		// Steal the list from the GeometryComponent
		ArrayList<ICEShape> shapes = geometry.getGeometry().getShapes();
		assertEquals(2, shapes.size());

		// Remove a shape from the stolen list
		shapes.remove(0);
		assertEquals(1, shapes.size());

		// Give it to the GeometryComponent
		geometry.getGeometry().setShapes(shapes);
		assertEquals(1, geometry.getGeometry().getShapes().size());

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

		// Create a new listener and add it to a GeometryComponent
		GeometryComponent geometry = new GeometryComponent();
		geometry.setGeometry(new ICEGeometry());
		TestComponentListener listener = new TestComponentListener();
		geometry.register(listener);

		// Modify geometryComponent's shapes list
		geometry.getGeometry().addShape(new ICEShape(ShapeType.Cube));

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
	 * This operation checks the ability of the GeometryComponent to persist
	 * itself to XML and to load itself from an XML input stream.
	 * </p>
	 * 
	 * @throws IOException
	 * @throws JAXBException
	 * @throws NullPointerException
	 * 
	 */
	@Test
	public void checkLoadingFromXML() throws NullPointerException,
			JAXBException, IOException {
		// Local Declarations
		ICEJAXBHandler xmlHandler = new ICEJAXBHandler();
		ArrayList<Class> classList = new ArrayList<Class>();
		classList.add(GeometryComponent.class);
		classList.add(Geometry.class);

		// Instantiate a GeometryComponent
		GeometryComponent geometry = new GeometryComponent();
		geometry.setGeometry(new ICEGeometry());
		geometry.getGeometry().addShape(new ICEShape(ShapeType.Sphere));
		geometry.setId(25);
		geometry.setDescription("description");
		geometry.setName("name");

		// Load it into XML
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		xmlHandler.write(geometry, classList, outputStream);

		// convert information inside of outputStream to inputStream
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				outputStream.toByteArray());

		String xmlFile2 = new String(outputStream.toByteArray());
		// System.err.println(xmlFile2);

		// load contents into xml
		GeometryComponent loadGeometry = new GeometryComponent();
		loadGeometry = (GeometryComponent) xmlHandler.read(classList,
				inputStream);

		// Check contents
		assertTrue(loadGeometry.equals(geometry));

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
		// Create GeometryComponent to test
		GeometryComponent component = new GeometryComponent();
		GeometryComponent equalComponent = new GeometryComponent();
		GeometryComponent unEqualComponent = new GeometryComponent();
		GeometryComponent transitiveComponent = new GeometryComponent();
		component.setGeometry(new ICEGeometry());
		equalComponent.setGeometry(new ICEGeometry());
		unEqualComponent.setGeometry(new ICEGeometry());
		transitiveComponent.setGeometry(new ICEGeometry());

		// Change values
		ICEShape shape = new ICEShape(ShapeType.Cylinder);
		ICEShape weirdShape = new ICEShape(OperatorType.Intersection);

		component.getGeometry().addShape(shape);
		equalComponent.getGeometry().addShape(shape);
		transitiveComponent.getGeometry().addShape(shape);

		unEqualComponent.getGeometry().addShape(weirdShape);

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

		// Create a new GeometryComponent
		GeometryComponent geometry = new GeometryComponent();
		geometry.setGeometry(new ICEGeometry());

		// Check that the shapes list exists but is empty
		assertNotNull(geometry.getGeometry().getShapes());
		assertTrue(geometry.getGeometry().getShapes().isEmpty());

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

		GeometryComponent geometry = new GeometryComponent();
		GeometryComponent cloneGeometry;
		GeometryComponent copyGeometry;
		geometry.setGeometry(new ICEGeometry());

		// Set up ICEObject stuff for GeometryComponent
		geometry.setId(25);
		geometry.setDescription("Geometry description");
		geometry.setName("Geometry name");

		// Set up GeometryComponent-specific stuff
		ICEShape sphere1 = new ICEShape(ShapeType.Sphere);
		ICEShape cube1 = new ICEShape(OperatorType.Union);

		geometry.getGeometry().addShape(sphere1);
		geometry.getGeometry().addShape(cube1);

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