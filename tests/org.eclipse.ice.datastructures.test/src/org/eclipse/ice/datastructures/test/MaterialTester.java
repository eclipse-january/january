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

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.eclipse.ice.datastructures.ICEObject.ICEJAXBHandler;
import org.eclipse.ice.datastructures.form.Material;
import org.junit.Test;

/**
 * This class is responsible for testing the Material class.
 * 
 * @author Jay Jay Billings
 * 
 */
public class MaterialTester {

	/**
	 * This operation checks the Material class to make sure that simple
	 * attributes such as names and properties can be changed.
	 */
	@Test
	public void checkSimpleAttributes() {

		// Local Declarations
		Material testMaterial = TestMaterialFactory.createCO2();

		// Check the name
		testMaterial.setName("CO2");
		assertEquals("CO2", testMaterial.getName());

		// Check the size
		testMaterial.setSize(1);
		assertEquals(1, testMaterial.getSize());

		// Check properties - just test handling a few
		testMaterial.setProperty("molar mass (g/mol)", 44.01);
		double mass = testMaterial.getProperty("molar mass (g/mol)");
		assertEquals(44.01, mass, 1.0e-16);
		testMaterial.setProperty("vapor pressure (MPa)", 5.73);
		double pressure = testMaterial.getProperty("vapor pressure (MPa)");
		assertEquals(5.73, pressure, 1.0e-16);

		// Get all the properties and make sure they have molar mass and vapor
		// pressure.
		Map<String, Double> properties = testMaterial.getProperties();
		assertTrue(properties.containsKey("molar mass (g/mol)"));
		assertTrue(properties.containsKey("vapor pressure (MPa)"));

		// Make sure that requesting a property that isn't in the map returns 0.0.
		assertEquals(0.0,testMaterial.getProperty("penguin"),1.0e-8);
		
		return;
	}

	/**
	 * This operation checks that the Material class can properly manage a set
	 * of component Materials that define its detailed composition.
	 */
	@Test
	public void checkComponents() {

		// Local Declarations
		Material testMaterial = TestMaterialFactory.createCO2();

		// Check its components
		assertNotNull(testMaterial.getComponents());
		List<Material> components = testMaterial.getComponents();
		assertEquals(2, components.size());

		// Get the Materials
		Material firstMaterial = components.get(0);
		Material secondMaterial = components.get(1);

		// Check them in an order independent way. It is enough to check that
		// the components are there. There is no need to check their sizes.
		assertTrue(("C".equals(firstMaterial.getName()) && "O"
				.equals(secondMaterial.getName()))
				|| ("O".equals(firstMaterial.getName()) && "C"
						.equals(secondMaterial.getName())));

	}

	/**
	 * This operation checks that Materials.equals() and Materials.hashCode()
	 * work.
	 */
	@Test
	public void checkEquality() {

		// Create two test materials to compare against each other
		Material testMat1 = TestMaterialFactory.createCO2();
		Material testMat2 = TestMaterialFactory.createCO2();

		// The should be equal
		assertTrue(testMat1.equals(testMat2));

		// Make sure that a self comparison works
		assertTrue(testMat1.equals(testMat1));

		// Make sure that passing something else in fails
		assertFalse(testMat1.equals(1));

		// Make sure they are not equal after the size is changed
		testMat2.setSize(5);
		assertFalse(testMat1.equals(testMat2));
		testMat2.setSize(1);

		// Check that the hash code doesn't change with no changes in state
		assertEquals(testMat1.hashCode(), testMat1.hashCode());

		// Check that they have the same hash codes
		assertEquals(testMat1.hashCode(), testMat2.hashCode());
	}

	/**
	 * This operation checks that Material.copy() and Material.clone() work.
	 */
	@Test
	public void checkCopying() {
		// Create a material to copy and check
		Material material = TestMaterialFactory.createCO2();
		Material materialCopy = new Material(), materialClone = null;

		// Copy it and check it
		materialCopy.copy(material);

		// Make sure they are equal
		assertTrue(material.equals(materialCopy));

		// Checking cloning
		materialClone = (Material) material.clone();
		assertEquals(material, materialClone);
	}

	/**
	 * This operation checks that the Material class can be loaded and written
	 * with JAXB.
	 */
	@Test
	public void checkPersistence() {

		// Local Declarations
		ICEJAXBHandler xmlHandler = new ICEJAXBHandler();
		ArrayList<Class> classList = new ArrayList<Class>();
		classList.add(Material.class);
		
		// Use the ICE JAXB Manipulator instead of raw JAXB. Waste not want not.
		ICEJAXBHandler jaxbHandler = new ICEJAXBHandler();

		// Create a Material that will be written to XML
		Material material = TestMaterialFactory.createCO2();

		try {
			// Write the material to a byte stream so that it can be converted
			// easily and read back in.
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			jaxbHandler.write(material, classList, outputStream);

			// Read it back from the stream into a second Material by converting
			// the output stream into a byte array and then an input stream.
			ByteArrayInputStream inputStream = new ByteArrayInputStream(
					outputStream.toByteArray());
			Material readMaterial = (Material) jaxbHandler.read(classList,
					inputStream);
			
			// They should be equal.
			assertTrue(readMaterial.equals(material));
		} catch (NullPointerException | JAXBException | IOException e) {
			// Just learned about Multicatch! Is this not the coolest #!@%?
			e.printStackTrace();
		}

	}
}
