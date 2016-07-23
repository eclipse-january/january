/*******************************************************************************
 * Copyright (c) 2012, 2016 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - 
 *   Jay Jay Billings, Kasper Gammeltoft
 *******************************************************************************/
package org.eclipse.ice.datastructures.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.eclipse.january.form.ICEJAXBHandler;
import org.eclipse.january.form.Material;
import org.eclipse.january.form.MaterialStack;
import org.junit.Test;

/**
 * Test class for {@link org.eclipse.january.form.MaterialStack}
 * @author Jay Jay Billings, Kasper Gammeltoft
 *
 */
public class MaterialStackTester {

	/**
	 * Test method for {@link org.eclipse.january.form.MaterialStack#MaterialStack()}.
	 */
	@Test
	public void testConstruction() {
		Material matTest1 = new Material();
		matTest1.setName("Nitrogen");
		MaterialStack stack1 = new MaterialStack(matTest1, 3);
		assertNotNull(matTest1);
		MaterialStack stack2 = new MaterialStack();
		stack2.setMaterial(matTest1);
		stack2.setAmount(3);
		assertTrue(stack1.equals(stack2));
	}

	/**
	 * Test method for {@link org.eclipse.january.form.MaterialStack#getMaterial()}.
	 */
	@Test
	public void testGetMaterial() {
		Material C02 = TestMaterialFactory.createCO2();
		MaterialStack stack = new MaterialStack(C02, 3);
		Material testMat = stack.getMaterial();
		assertTrue(C02.equals(testMat));
	}

	/**
	 * Test method for {@link org.eclipse.january.form.MaterialStack#getAmount()}.
	 */
	@Test
	public void testGetAmount() {
		int amount = 3;
		MaterialStack stack = new MaterialStack(TestMaterialFactory.createH2O(), amount);
		int testAmount = stack.getAmount();
		assertTrue(amount==testAmount);
	}

	/**
	 * Test method for {@link org.eclipse.january.form.MaterialStack#incrementAmount()}.
	 */
	@Test
	public void testIncrementAmount() {
		int startAmount = 2;
		MaterialStack stack = new MaterialStack(TestMaterialFactory.createH2O(), startAmount);
		stack.incrementAmount();
		assertEquals(startAmount+1, stack.getAmount());
		startAmount++;
		int add = 5;
		stack.addAmount(add);
		assertEquals(startAmount+add, stack.getAmount());
		
	}

	/**
	 * Test method for {@link org.eclipse.january.form.MaterialStack#equals(org.eclipse.january.form.MaterialStack)}.
	 */
	@Test
	public void testEqualsMaterialStack() {
		// Put some carbon in a couple of stacks
		Material carbon = new Material();
		carbon.setName("C");
		Material secondCarbon = new Material();
		secondCarbon.setName("C");
		MaterialStack stack = new MaterialStack(carbon, 1);
		MaterialStack stack2 = new MaterialStack(secondCarbon, 1);

		// Check them
		assertTrue(stack.equals(stack2));
		
		// Create two CO2 molecules 
		stack = new MaterialStack(TestMaterialFactory.createCO2(), 1);
		stack2 = new MaterialStack(TestMaterialFactory.createCO2(), 1);

		// Check them
		assertTrue(stack.equals(stack2));		
		
		return;
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
		classList.add(MaterialStack.class);
		
		// Use the ICE JAXB Manipulator instead of raw JAXB. Waste not want not.
		ICEJAXBHandler jaxbHandler = new ICEJAXBHandler();

		// Create a Material that will be written to XML
		Material material = TestMaterialFactory.createCO2();
		
		MaterialStack stack = new MaterialStack();
		stack.setMaterial(material);

		try {
			// Write the material to a byte stream so that it can be converted
			// easily and read back in.
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			jaxbHandler.write(stack, classList, outputStream);

			// Read it back from the stream into a second Material by converting
			// the output stream into a byte array and then an input stream.
			ByteArrayInputStream inputStream = new ByteArrayInputStream(
					outputStream.toByteArray());
			MaterialStack readMaterialStack = (MaterialStack) jaxbHandler.read(classList,
					inputStream);
			
			// They should be equal.
			assertTrue(readMaterialStack.equals(stack));
		} catch (NullPointerException | JAXBException | IOException e) {
			// Complain
			e.printStackTrace();
			fail();
		}

	}

}
