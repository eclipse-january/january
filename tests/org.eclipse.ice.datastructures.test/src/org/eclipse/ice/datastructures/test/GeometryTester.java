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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.eclipse.ice.datastructures.ICEObject.ICEJAXBHandler;
import org.eclipse.ice.datastructures.form.geometry.ComplexShape;
import org.eclipse.ice.datastructures.form.geometry.Geometry;
import org.eclipse.ice.datastructures.form.geometry.GeometryComponent;
import org.eclipse.ice.datastructures.form.geometry.OperatorType;
import org.eclipse.ice.datastructures.form.geometry.PrimitiveShape;
import org.eclipse.ice.datastructures.form.geometry.ShapeType;
import org.eclipse.ice.datastructures.form.geometry.Transformation;
import org.junit.Test;

/**
 * <p>
 * Checks the overall functionality of the geometry package and the interaction
 * between each of its components
 * </p>
 * 
 * @author Jay Jay Billings
 */
public class GeometryTester {
	/**
	 * <p>
	 * Checks the functionality of exporting an entire CSG tree to XML
	 * </p>
	 * @throws IOException 
	 * @throws JAXBException 
	 * @throws NullPointerException 
	 * 
	 */
	@Test
	public void checkCSGTree() throws NullPointerException, JAXBException, IOException {

		// Create the root GeometryComponent
		GeometryComponent geometry = new GeometryComponent();
		geometry.setName("Root geometry");
		geometry.setDescription("This here's a verr' fine geom'try structcha");
		ICEJAXBHandler xmlHandler = new ICEJAXBHandler();
		ArrayList<Class> classList = new ArrayList<Class>();
		classList.add(GeometryComponent.class);
		classList.add(Geometry.class);

		// Create the CSG elements
		ComplexShape union = new ComplexShape(OperatorType.Union);
		ComplexShape intersection = new ComplexShape(OperatorType.Intersection);
		ComplexShape complement = new ComplexShape(OperatorType.Complement);
		complement.setDescription("Official ICE shape");

		PrimitiveShape sphere1 = new PrimitiveShape(ShapeType.Sphere);
		PrimitiveShape sphere2 = new PrimitiveShape(ShapeType.Sphere);
		PrimitiveShape cube = new PrimitiveShape(ShapeType.Cube);
		PrimitiveShape cone = new PrimitiveShape(ShapeType.Cone);
		PrimitiveShape cylinder = new PrimitiveShape(ShapeType.Cylinder);

		// Edit the transformations
		Transformation sphere1Transformation = sphere1.getTransformation();
		Transformation sphere2Transformation = new Transformation();
		Transformation intersectionTransformation = intersection
				.getTransformation();

		sphere1Transformation.setScale(0, 0, 2.0);
		sphere1Transformation.setScale(1, 1, 2.0);
		sphere1Transformation.setScale(2, 2, 2.0);

		sphere2Transformation.setScale(2, 2, -4.5);

		intersectionTransformation.setScale(3, 0, 2.0);
		intersectionTransformation.setScale(3, 2, -1.5);

		sphere1.setTransformation(sphere1Transformation);
		sphere2.setTransformation(sphere2Transformation);
		intersection.setTransformation(intersectionTransformation);

		// Add some properties
		intersection.setProperty("selected", "true");
		union.setProperty("awesome?", "yes");

		// Create the CSG tree
		geometry.getGeometry().addShape(union);

		union.addShape(complement);
		union.addShape(cone);
		union.addShape(cylinder);

		complement.addShape(cube);
		complement.addShape(intersection);

		intersection.addShape(sphere1);
		intersection.addShape(sphere2);

		// Persist GeometryComponent to XML
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		xmlHandler.write(geometry, classList, outputStream);

		// Print the XML output
		// System.out.println(outputStream.toString());

		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				outputStream.toByteArray());

		// Load a new GeometryComponent from XML
		GeometryComponent loadedGeometry = new GeometryComponent();
		loadedGeometry = (GeometryComponent) xmlHandler.read(classList, inputStream);

		assertTrue(geometry.equals(loadedGeometry));

		// Change one of the IShapes to check whether the two geometries are
		// not equal
		sphere1.setTransformation(new Transformation());

		assertFalse(geometry.equals(loadedGeometry));
	}

	/**
	 * <p>
	 * Checks whether notifications will be sent up the CSG tree
	 * </p>
	 * 
	 */
	@Test
	public void checkNotifications() {

		TestComponentListener listener = new TestComponentListener();

		// Create the CSG elements
		ComplexShape union1 = new ComplexShape(OperatorType.Union);
		ComplexShape union2 = new ComplexShape(OperatorType.Union);
		PrimitiveShape sphere1 = new PrimitiveShape(ShapeType.Sphere);
		PrimitiveShape sphere2 = new PrimitiveShape(ShapeType.Sphere);

		// Make the CSG tree
		union1.addShape(union2);
		union1.addShape(sphere1);
		union2.addShape(sphere2);

		// Test union1 notification
		union1.register(listener);
		union1.setProperty("key", "value");

		assertTrue(listener.wasNotified()); // U1
		System.out.println("GeometryTester Message: Union1 notified!");
		listener.reset();

		// Test union2 notification
		union2.register(listener);
		union2.setProperty("key", "value");

		assertTrue(listener.wasNotified()); // U2
		System.out.println("GeometryTester Message: Union2 notified!");
		listener.reset();

		// Test sphere1 notification
		sphere1.setProperty("key", "value");
		assertTrue(listener.wasNotified()); // U3
		System.out
				.println("GeometryTester Message: Union1 & Sphere1 notified!");
		listener.reset();

		// Test sphere2 notification
		union2.register(listener);
		System.out
				.println("GeometryTester Message: Union2 & Sphere2 notified!");
		sphere2.setProperty("key", "value");

		assertTrue(listener.wasNotified()); // U4

	}
}