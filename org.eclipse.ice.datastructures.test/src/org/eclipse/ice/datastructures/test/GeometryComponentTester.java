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

import java.util.List;

import org.eclipse.eavp.viz.service.geometry.shapes.GeometryMeshProperty;
import org.eclipse.eavp.viz.service.geometry.shapes.OperatorType;
import org.eclipse.eavp.viz.service.geometry.shapes.ShapeType;
import org.eclipse.eavp.viz.modeling.base.BasicController;
import org.eclipse.eavp.viz.modeling.base.BasicView;
import org.eclipse.eavp.viz.modeling.base.IController;
import org.eclipse.eavp.viz.modeling.properties.MeshProperty;
import org.eclipse.eavp.viz.modeling.ShapeController;
import org.eclipse.eavp.viz.modeling.ShapeMesh;
import org.eclipse.ice.datastructures.ICEObject.Component;
import org.eclipse.ice.datastructures.form.GeometryComponent;
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
		ShapeMesh geometryModel = new ShapeMesh();
		geometryModel.setProperty(MeshProperty.TYPE,
				ShapeType.Sphere.toString());
		BasicView geometryView = new BasicView();
		ShapeController geometryShape = new ShapeController(geometryModel,
				geometryView);

		// Instantiate a GeometryComponent
		GeometryComponent geometry = new GeometryComponent();
		geometry.setGeometry(geometryShape);

		// Add a PrimitiveShape
		ShapeController sphere = (ShapeController) geometryShape.clone();
		geometry.getGeometry().addEntity(sphere);
		assertEquals(1, geometry.getGeometry().getEntities().size());
		assertEquals(sphere, geometry.getGeometry().getEntities().get(0));

		// Add a ComplexShape
		ShapeController complex = (ShapeController) geometryShape.clone();
		geometry.getGeometry().addEntity(complex);
		assertEquals(2, geometry.getGeometry().getEntities().size());
		assertEquals(complex, geometry.getGeometry().getEntities().get(1));

		// Try adding null
		geometry.getGeometry().addEntity(null);
		assertEquals(2, geometry.getGeometry().getEntities().size());

		// Add a shape with an unknown concrete type
		ShapeController unknownShape = (ShapeController) geometryShape.clone();
		geometry.getGeometry().addEntity(unknownShape);
		assertEquals(3, geometry.getGeometry().getEntities().size());
		assertEquals(unknownShape, geometry.getGeometry().getEntities().get(2));

		// Remove the second shape
		geometry.getGeometry().removeEntity(complex);
		assertEquals(2, geometry.getGeometry().getEntities().size());

		// Steal the list from the GeometryComponent
		List<IController> shapes = geometry.getGeometry().getEntities();
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
		ShapeMesh geometryModel = new ShapeMesh();
		geometryModel.setProperty(MeshProperty.TYPE,
				ShapeType.Sphere.toString());
		BasicView geometryView = new BasicView();
		ShapeController geometryShape = new ShapeController(geometryModel,
				geometryView);

		// Create a new listener and add it to a GeometryComponent
		GeometryComponent geometry = new GeometryComponent();
		geometry.setGeometry(geometryShape);
		TestComponentListener listener = new TestComponentListener();
		geometry.register(listener);

		// Modify geometryComponent's shapes list
		geometry.getGeometry()
				.addEntity((BasicController) geometryShape.clone());

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

	// Reimplement test if JAXB persistence is ever supported for the geometry
	// editor
	// /**
	// * <p>
	// * This operation checks the ability of the GeometryComponent to persist
	// * itself to XML and to load itself from an XML input stream.
	// * </p>
	// *
	// * @throws IOException
	// * @throws JAXBException
	// * @throws NullPointerException
	// *
	// */
	// @Test
	// public void checkLoadingFromXML()
	// throws NullPointerException, JAXBException, IOException {
	//
	// // Create a shape
	// ShapeComponent geometryModel = new ShapeComponent();
	// geometryModel.setProperty("Type", ShapeType.Sphere.toString());
	// AbstractView geometryView = new AbstractView();
	// Shape geometryShape = new Shape(geometryModel, geometryView);
	//
	// // Local Declarations
	// ICEJAXBHandler xmlHandler = new ICEJAXBHandler();
	// ArrayList<Class> classList = new ArrayList<Class>();
	// classList.add(GeometryComponent.class);
	//
	// // Instantiate a GeometryComponent
	// GeometryComponent geometry = new GeometryComponent();
	// geometry.setGeometry(geometryShape);
	// geometry.setId(25);
	// geometry.setDescription("description");
	// geometry.setName("name");
	//
	// // Load it into XML
	// ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	// xmlHandler.write(geometry, classList, outputStream);
	//
	// // convert information inside of outputStream to inputStream
	// ByteArrayInputStream inputStream = new ByteArrayInputStream(
	// outputStream.toByteArray());
	//
	// String xmlFile2 = new String(outputStream.toByteArray());
	// // System.err.println(xmlFile2);
	//
	// // load contents into xml
	// GeometryComponent loadGeometry = new GeometryComponent();
	// loadGeometry = (GeometryComponent) xmlHandler.read(classList,
	// inputStream);
	//
	// // Check contents
	// assertTrue(loadGeometry.equals(geometry));
	//
	// }

	/**
	 * <p>
	 * This operation checks the GeometryComponent to ensure that its equals()
	 * and hashcode() operations work.
	 * </p>
	 * 
	 */
	@Test
	public void checkEquality() {

		ShapeMesh geometryModel = new ShapeMesh();
		geometryModel.setProperty(MeshProperty.TYPE,
				ShapeType.Sphere.toString());
		BasicView geometryView = new BasicView();
		ShapeController geometryShape = new ShapeController(geometryModel,
				geometryView);

		// Create GeometryComponent to test
		GeometryComponent component = new GeometryComponent();
		GeometryComponent equalComponent = new GeometryComponent();
		GeometryComponent unEqualComponent = new GeometryComponent();
		GeometryComponent transitiveComponent = new GeometryComponent();
		component.setGeometry(geometryShape);
		equalComponent.setGeometry((ShapeController) geometryShape.clone());
		unEqualComponent.setGeometry((ShapeController) geometryShape.clone());
		transitiveComponent
				.setGeometry((ShapeController) geometryShape.clone());

		// Change values
		ShapeController shape = (ShapeController) geometryShape.clone();
		shape.setProperty(MeshProperty.TYPE, ShapeType.Cylinder.toString());
		ShapeController weirdShape = (ShapeController) geometryShape.clone();
		shape.setProperty(GeometryMeshProperty.OPERATOR,
				OperatorType.Intersection.toString());

		component.getGeometry().addEntity(shape);
		equalComponent.getGeometry().addEntity(shape);
		transitiveComponent.getGeometry().addEntity(shape);

		unEqualComponent.getGeometry().addEntity(weirdShape);

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
		ShapeMesh geometryModel = new ShapeMesh();
		geometryModel.setProperty(MeshProperty.TYPE,
				ShapeType.Sphere.toString());
		BasicView geometryView = new BasicView();
		ShapeController geometryShape = new ShapeController(geometryModel,
				geometryView);

		// Create a new GeometryComponent
		GeometryComponent geometry = new GeometryComponent();
		geometry.setGeometry(geometryShape);

		// Check that the shapes list exists but is empty
		assertNotNull(geometry.getGeometry().getEntities());
		assertTrue(geometry.getGeometry().getEntities().isEmpty());

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
		ShapeMesh geometryModel = new ShapeMesh();
		geometryModel.setProperty(MeshProperty.TYPE,
				ShapeType.Sphere.toString());
		BasicView geometryView = new BasicView();
		ShapeController geometryShape = new ShapeController(geometryModel,
				geometryView);

		GeometryComponent geometry = new GeometryComponent();
		GeometryComponent cloneGeometry;
		GeometryComponent copyGeometry;
		geometry.setGeometry(geometryShape);

		// Set up ICEObject stuff for GeometryComponent
		geometry.setId(25);
		geometry.setDescription("Geometry description");
		geometry.setName("Geometry name");

		// Set up GeometryComponent-specific stuff
		ShapeMesh sphereModel = new ShapeMesh();
		sphereModel.setProperty(MeshProperty.TYPE, ShapeType.Sphere.toString());
		BasicView sphereView = new BasicView();
		ShapeController sphere1 = new ShapeController(sphereModel, sphereView);

		ShapeMesh cubeModel = new ShapeMesh();
		cubeModel.setProperty(GeometryMeshProperty.OPERATOR,
				OperatorType.Union.toString());
		BasicView cubeView = new BasicView();
		ShapeController cube1 = new ShapeController(cubeModel, cubeView);

		geometry.getGeometry().addEntity(sphere1);
		geometry.getGeometry().addEntity(cube1);

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