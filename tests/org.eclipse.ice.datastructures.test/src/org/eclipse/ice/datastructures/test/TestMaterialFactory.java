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

import org.eclipse.ice.datastructures.form.Material;

/**
 * This is a utility class used by the Material tests to create materials with a
 * known initial configuration.
 * 
 * @author Jay Jay Billings
 * 
 */
public class TestMaterialFactory {

	/**
	 * This operation creates a simple CO2 Material that can be used for
	 * testing.
	 * 
	 * @return the test material
	 */
	public static Material createCO2() {

		// Create a simple CO2 Material
		Material testMaterial = new Material();
		testMaterial.setName("CO2");
		testMaterial.setProperty("molar mass (g/mol)", 44.01);
		testMaterial.setProperty("vapor pressure (MPa)", 5.73);

		// Create component 1 - Carbon
		Material carbon = new Material();
		carbon.setName("C");

		// Create component 2 - Oxygen
		Material oxygen = new Material();
		oxygen.setName("O");
		// Note that the "size" of O is 2 since we need O2

		// Add them as components
		testMaterial.addComponent(carbon);
		testMaterial.addComponent(oxygen);

		return testMaterial;
	}

	/**
	 * This operation creates a simple H2O Material that can be used for
	 * testing.
	 * 
	 * @return the test material
	 */
	public static Material createH2O() {

		// Create a simple H2O Material
		Material testMaterial = new Material();
		testMaterial.setName("H2O");
		testMaterial.setProperty("molar mass (g/mol)", 18.01);
		// Vapor pressure at 273 K
		testMaterial.setProperty("vapor pressure (MPa)", 611.0e-6);

		// Create component 1 - Hydrogen
		Material hydrogen = new Material();
		hydrogen.setName("H");

		// Create component 2 - Oxygen
		Material oxygen = new Material();
		oxygen.setName("O");

		// Add them as components
		testMaterial.addComponent(hydrogen);
		testMaterial.addComponent(oxygen);

		return testMaterial;
	}
	
}
