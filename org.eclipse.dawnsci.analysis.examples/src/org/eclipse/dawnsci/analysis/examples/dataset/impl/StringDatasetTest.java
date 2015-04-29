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
import org.eclipse.dawnsci.analysis.dataset.impl.StringDataset;
import org.junit.Test;

public class StringDatasetTest {

	@Test
	public void testConstructor() {
		String[] da = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11" };
		StringDataset a = new StringDataset(da, null);

		IndexIterator it = a.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(String.format("%d", i), a.getStringAbs(it.index));
		}

		StringDataset b = new StringDataset(da, 3, 4);

		it = b.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(String.format("%d", i), b.getStringAbs(it.index));
		}

		StringDataset c = new StringDataset(a.getSliceView(new int[] {1}, null, new int[] {2}));
		it = c.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(String.format("%d", 2*i + 1), c.getStringAbs(it.index));
		}

		// test hashes
		a.hashCode();
		b.hashCode();
		c.hashCode();
	}
}
