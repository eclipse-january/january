/*-
 * Copyright (c) 2012 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import static org.junit.Assert.assertEquals;

import org.eclipse.january.dataset.ComplexFloatDataset;
import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.IndexIterator;
import org.eclipse.january.dataset.Maths;
import org.junit.Test;

public class ComplexFloatDatasetTest {
	@Test
	public void testConstructor() {
		float[] da = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		ComplexFloatDataset a = new ComplexFloatDataset(da);

		assertEquals(Dataset.COMPLEX64, a.getDType());
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
		assertEquals(Dataset.FLOAT32, aa.getDType());
		assertEquals(1, aa.getElementsPerItem());
		assertEquals(4, aa.getItemBytes());		

		// test hashes
		a.hashCode();
		b.hashCode();
		aa.hashCode();
	}
}
