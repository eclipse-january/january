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

import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.dataset.IndexIterator;
import org.eclipse.january.dataset.ShortDataset;
import org.junit.Test;

public class ShortDatasetTest {

	@Test
	public void testConstructor() {
		short[] da = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		ShortDataset a = new ShortDataset(da);

		IndexIterator it = a.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i, a.getElementLongAbs(it.index));
		}

		ShortDataset b = new ShortDataset(da, 3, 4);

		it = b.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i, b.getElementLongAbs(it.index));
		}

		// test hashes
		a.hashCode();
		b.hashCode();
	}

	@Test
	public void testStats() {
		Dataset a = DatasetFactory.createRange(12, Dataset.INT16);
		assertEquals(11., a.max().doubleValue(), 1e-6);
		assertEquals(0., a.min().doubleValue(), 1e-6);
		assertEquals(5.5, ((Number) a.mean()).doubleValue(), 1e-6);
		assertEquals(3.6055512754639891, a.stdDeviation().doubleValue(), 1e-6);
		assertEquals(13., a.variance().doubleValue(), 1e-6);
	}


}
