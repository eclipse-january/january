/*******************************************************************************
 * Copyright (c) 2012, 2014 UT-Battelle, LLC.
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

import static org.junit.Assert.*;

import org.eclipse.ice.datastructures.form.Material;
import org.eclipse.ice.datastructures.form.MaterialStack;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Jay Jay Billings, Kasper Gammeltoft
 *
 */
public class MaterialStackTester {

	/**
	 * Test method for {@link org.eclipse.ice.datastructures.form.MaterialStack#MaterialStack()}.
	 */
	//@Test
	public void testConstruction() {
		// Check setup
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.ice.datastructures.form.MaterialStack#getMaterial()}.
	 */
//	@Test
	public void testGetMaterial() {
		// Check the material
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.ice.datastructures.form.MaterialStack#getAmount()}.
	 */
//	@Test
	public void testGetAmount() {
		// Check all getters
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.ice.datastructures.form.MaterialStack#incrementAmount()}.
	 */
//	@Test
	public void testIncrementAmount() {
		// Check increment, set and add
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.ice.datastructures.form.MaterialStack#equals(org.eclipse.ice.datastructures.form.MaterialStack)}.
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

}
