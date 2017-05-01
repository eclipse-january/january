/*******************************************************************************
 * Copyright (c) 2013, 2016 UT-Battelle, LLC.
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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.january.form.ContinuousEntry;
import org.eclipse.january.form.DataComponent;
import org.eclipse.january.form.DiscreteEntry;
import org.eclipse.january.form.ExecutableEntry;
import org.eclipse.january.form.FileEntry;
import org.eclipse.january.form.GeometryComponent;
import org.eclipse.january.form.JanuaryJAXBClassProvider;
import org.eclipse.january.form.IJAXBClassProvider;
import org.eclipse.january.form.ListComponent;
import org.eclipse.january.form.Material;
import org.eclipse.january.form.MatrixComponent;
import org.eclipse.january.form.ResourceComponent;
import org.eclipse.january.form.StringEntry;
import org.eclipse.january.form.TableComponent;
import org.eclipse.january.form.TimeDataComponent;
import org.eclipse.january.form.TreeComposite;
import org.eclipse.january.form.emf.EMFComponent;
import org.junit.Test;

/**
 * This class tests the JanuaryJAXBClassProvider. Specifically, it checks that the
 * correct classes are created and returned by its
 * IJAXBClassProvider.getClasses() method.
 * 
 * @author Alex McCaskey
 *
 */
public class JanuaryJAXBClassProviderTester {

	/**
	 * Reference to the IJAXBClassProvider we are testing
	 */
	private IJAXBClassProvider provider;

	/**
	 * This method checks that we can get a valid set of Classes from the
	 * JanuaryJAXBClassProvider.
	 */
	@Test
	public void checkClassList() {

		// Create the class provider
		provider = new JanuaryJAXBClassProvider();

		// Check the name
		assertTrue(
				"January JAXB Class Provider".equals(provider.getProviderName()));

		// Get the list of classes, make sure its
		// not null, and make sure we have 10 of them
		List<Class> classList = provider.getClasses();
		assertNotNull(classList);
		assertEquals(18, classList.size());

		// Check that all the correct ones are there.
		assertTrue(classList.contains(ResourceComponent.class));
		assertTrue(classList.contains(TableComponent.class));
		assertTrue(classList.contains(MatrixComponent.class));
		assertTrue(classList.contains(GeometryComponent.class));
		assertTrue(classList.contains(TimeDataComponent.class));
		assertTrue(classList.contains(DataComponent.class));
		assertTrue(classList.contains(TreeComposite.class));
		assertTrue(classList.contains(ListComponent.class));
		assertTrue(classList.contains(EMFComponent.class));
		assertTrue(classList.contains(Material.class));
		assertTrue(classList.contains(ContinuousEntry.class));
		assertTrue(classList.contains(DiscreteEntry.class));
		assertTrue(classList.contains(FileEntry.class));
		assertTrue(classList.contains(StringEntry.class));
		assertTrue(classList.contains(ExecutableEntry.class));

	}
}
