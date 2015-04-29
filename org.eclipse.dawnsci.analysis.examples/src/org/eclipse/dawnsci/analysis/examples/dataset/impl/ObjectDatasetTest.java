/*
 * Copyright (c) 2012 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.examples.dataset.impl;

import static org.junit.Assert.assertEquals;

import org.eclipse.dawnsci.analysis.dataset.impl.IndexIterator;
import org.eclipse.dawnsci.analysis.dataset.impl.ObjectDataset;
import org.junit.Test;

public class ObjectDatasetTest {

	@Test
	public void testConstructor() {
		Object[] da = { "0", (byte) 1, (short) 2, (int) 3, (float) 4, (double) 5, "6", "7", "8", "9", "10", "11" };
		ObjectDataset a = new ObjectDataset(da, null);

		IndexIterator it = a.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i, Double.parseDouble(a.getStringAbs(it.index)), 1e-5*i);
		}

		ObjectDataset b = new ObjectDataset(da, 3, 4);

		it = b.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i, Double.parseDouble(b.getStringAbs(it.index)), 1e-5*i);
		}

		ObjectDataset c = new ObjectDataset(a.getSliceView(new int[] {1}, null, new int[] {2}));
		it = c.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(2*i+1, Double.parseDouble(c.getStringAbs(it.index)), 1e-5 * i);
		}

		// test hashes
		a.hashCode();
		b.hashCode();
		c.hashCode();
	}
}
