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
package org.eclipse.january.datastructures.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.eclipse.january.form.JanuaryJAXBHandler;
import org.eclipse.january.form.Material;
import org.eclipse.january.form.MaterialStack;
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

		// Make sure that requesting a property that isn't in the map returns
		// 0.0.
		assertEquals(0.0, testMaterial.getProperty("penguin"), 1.0e-8);
		
		// Make some more test materials
		Material carbon = new Material();
		carbon.setName("C");
		
		Material c1 = new Material();
		c1.setName("12C");
		
		// Test the get isotopic number and get elemental name
		assertEquals(12, c1.getIsotopicNumber());
		assertEquals(carbon.getName(), carbon.getElementalName());
		assertEquals(0, carbon.getIsotopicNumber());
		assertEquals(carbon.getName(), c1.getElementalName());

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
		List<MaterialStack> components = testMaterial.getComponents();
		assertEquals(2, components.size());

		// Get the Materials
		Material firstMaterial = components.get(0).getMaterial();
		Material secondMaterial = components.get(1).getMaterial();

		// Check them in an order independent way. It is enough to check that
		// the components are there. There is no need to check their sizes.
		assertTrue(("C".equals(firstMaterial.getName())
				&& "O".equals(secondMaterial.getName()))
				|| ("O".equals(firstMaterial.getName())
						&& "C".equals(secondMaterial.getName())));

	}

	/**
	 * This operation checks that a set of materials can properly sort itself
	 * using the compare to method on the material's names. For example, sorting
	 * a list such as b, c, 1c, d, f, 5c should give the resulting order of a,
	 * b, c, 1c, 5c, d, f.
	 */
	@Test
	public void checkSorting() {
		
		// Make some test materials
		Material A = new Material();
		A.setName("A");
		Material B = new Material();
		B.setName("B");
		Material co2 = TestMaterialFactory.createCO2();
		Material B1 = new Material();
		B1.setName("3B");

		// Make sure that alphabetical order is followed
		assertTrue(A.compareTo(B) < 0);

		// Make sure that isotopes go in numeric order
		assertTrue(B.compareTo(B1) < 0);

		// Make sure that a blank material would be at the front of a list
		assertTrue(A.compareTo(new Material()) > 0);

		// Make sure that if materials have the same name they are the same when
		// compared.
		Material A1 = new Material();
		A1.setName(A.getName());
		assertTrue(A.compareTo(A1) == 0);

		// Make sure that the compound is in proper alphabetic order (no numeric
		// sorting).
		assertTrue(co2.compareTo(B1) > 0);
		Material C = new Material();
		C.setName("C");
		assertTrue(C.compareTo(co2) < 0);

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

		// They should be equal
		assertTrue(testMat1.equals(testMat2));

		// Make sure that a self comparison works
		assertTrue(testMat1.equals(testMat1));

		// Make sure that passing something else in fails
		assertFalse(testMat1.equals(1));

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
		JanuaryJAXBHandler xmlHandler = new JanuaryJAXBHandler();
		ArrayList<Class> classList = new ArrayList<Class>();
		classList.add(Material.class);

		// Use the ICE JAXB Manipulator instead of raw JAXB. Waste not want not.
		JanuaryJAXBHandler jaxbHandler = new JanuaryJAXBHandler();

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

		return;
	}
}
