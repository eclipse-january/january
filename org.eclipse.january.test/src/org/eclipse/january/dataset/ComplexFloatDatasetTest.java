/*-
 * Copyright (c) 2012, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ComplexFloatDatasetTest {
	@Test
	public void testConstructor() {
		assertEquals(0, new ComplexFloatDataset().getSize());
		assertEquals(0, DatasetFactory.createFromObject(ComplexFloatDataset.class, 1f).getRank());

		float[] da = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		ComplexFloatDataset a = new ComplexFloatDataset(da);

		assertTrue("Interface", ComplexFloatDataset.class.isAssignableFrom(a.getClass()));
		assertEquals(2, a.getElementsPerItem());
		assertEquals(8, a.getItemBytes());

		IndexIterator it = a.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i*2, a.getElementDoubleAbs(it.index), 1e-5*i);
		}

		ComplexFloatDataset b = new ComplexFloatDataset(da, 3, 2);

		it = b.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i*2, b.getElementDoubleAbs(it.index), 1e-5*i);
		}

		Dataset aa = Maths.abs(a);
		assertTrue("Interface", FloatDataset.class.isAssignableFrom(aa.getClass()));
		assertEquals(1, aa.getElementsPerItem());
		assertEquals(4, aa.getItemBytes());		

		// test hashes
		a.hashCode();
		b.hashCode();
		aa.hashCode();

		Class<? extends Dataset> clazz = a.getClass();
		assertEquals(false, InterfaceUtils.isElemental(clazz));
		assertEquals(true,  InterfaceUtils.isCompound(clazz));
		assertEquals(false, InterfaceUtils.isInteger(clazz));
		assertEquals(true,  InterfaceUtils.isNumerical(clazz));
		assertEquals(true,  InterfaceUtils.isFloating(clazz));
		assertEquals(true,  InterfaceUtils.isComplex(clazz));
	}
}
