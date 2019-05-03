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

import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.dataset.IndexIterator;
import org.eclipse.january.dataset.LongDataset;
import org.eclipse.january.dataset.Slice;
import org.junit.Test;

public class LongDatasetTest {

	@Test
	public void testConstructor() {
		assertEquals(0, new LongDataset().getSize());
		assertEquals(0, DatasetFactory.createFromObject(1).getRank());

		long[] da = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		LongDataset a = new LongDataset(da);

		IndexIterator it = a.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i, a.getElementLongAbs(it.index));
		}

		LongDataset b = new LongDataset(da, 3, 4);

		it = b.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i, b.getElementLongAbs(it.index));
		}

		// test hashes
		a.hashCode();
		b.hashCode();
	}

	@Test
	public void testGetter() {
		long[] da = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		LongDataset a = new LongDataset(da);
		int l = da.length;
		for (int i = 0; i < l; i++) {
			assertEquals(i, a.getLong(i));
		}
		
		for (int i = 0; i < l; i++) {
			int r = l - 1 - i;
			assertEquals(r, a.getLong(-(i + 1)));
		}

		Dataset sv = a.getSliceView(new Slice(2,7));
		Dataset sc = a.getSlice(new Slice(2,7));
		l = sc.getSize();
		for (int i = 0; i < l; i++) {
			long r = sc.getLong(-(i + 1));
			assertEquals(r, sv.getLong(-(i + 1)));
		}
	}

	@Test
	public void testStats() {
		Dataset a = DatasetFactory.createRange(LongDataset.class, 12);
		assertEquals(11., a.max().doubleValue(), 1e-6);
		assertEquals(0., a.min().doubleValue(), 1e-6);
		assertEquals(5.5, ((Number) a.mean()).doubleValue(), 1e-6);
		assertEquals(3.6055512754639891, a.stdDeviation(), 1e-6);
		assertEquals(13., a.variance(), 1e-6);
	}

}
