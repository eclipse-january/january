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

		Class<? extends Dataset> clazz = a.getClass();
		assertEquals(true,  InterfaceUtils.isElemental(clazz));
		assertEquals(false, InterfaceUtils.isCompound(clazz));
		assertEquals(true,  InterfaceUtils.isInteger(clazz));
		assertEquals(true,  InterfaceUtils.isNumerical(clazz));
		assertEquals(false, InterfaceUtils.isFloating(clazz));
		assertEquals(false, InterfaceUtils.isComplex(clazz));
	}

	@Test
	public void testCreators() {
		long dz = -5;
		LongDataset z = LongDataset.createFromObject(dz);
		assertEquals(0, z.getRank());
		assertEquals(1, z.getSize());
		assertEquals(dz, z.getElementLongAbs(0));

		long[] da = { 0, 1, 2, 3, 4, 5 };
		LongDataset a = LongDataset.createFromObject(da);
		assertEquals(1, a.getRank());
		assertEquals(6, a.getSize());
		assertEquals(6, a.getShapeRef()[0]);
		IndexIterator it = a.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i, a.getElementLongAbs(it.index));
		}

		long[][] db = { { 0, 1, 2 }, { 3, 4, 5 } };
		LongDataset b = LongDataset.createFromObject(db);
		assertEquals(2, b.getRank());
		assertEquals(6, b.getSize());
		assertEquals(2, b.getShapeRef()[0]);
		assertEquals(3, b.getShapeRef()[1]);
		it = b.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i, b.getElementLongAbs(it.index));
		}

		long[][] dc = { { 0, 1, 2, 3 }, { 4, 5, 6 } };
		LongDataset c = LongDataset.createFromObject(dc);
		assertEquals(2, c.getRank());
		assertEquals(8, c.getSize());
		assertEquals(2, c.getShapeRef()[0]);
		assertEquals(4, c.getShapeRef()[1]);
		it = c.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			if (i < 7) {
				assertEquals(i, c.getElementLongAbs(it.index));
			} else {
				assertEquals(0, c.getElementLongAbs(it.index));
			}
		}

		long[][] dd = { { 0, 1, 2 }, { 4, 5, 6, 7 } };
		LongDataset d = LongDataset.createFromObject(dd);
		assertEquals(2, d.getRank());
		assertEquals(8, d.getSize());
		assertEquals(2, d.getShapeRef()[0]);
		assertEquals(4, d.getShapeRef()[1]);
		it = d.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			if (i != 3) {
				assertEquals(i, d.getElementLongAbs(it.index));
			} else {
				assertEquals(0, d.getElementLongAbs(it.index));
			}
		}

		Long[] bda = { 0l, null, 2l };
		LongDataset e = LongDataset.createFromObject(bda);
		assertEquals(1, e.getRank());
		assertEquals(3, e.getSize());
		assertEquals(3, e.getShapeRef()[0]);
		it = e.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			if (i != 1) {
				assertEquals(i, e.getElementLongAbs(it.index));
			} else {
				assertEquals(0, e.getElementLongAbs(it.index));
			}
		}
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
		assertEquals(Long.valueOf(11), a.max());
		assertEquals(0., a.min().doubleValue(), 1e-6);
		assertEquals(5.5, ((Number) a.mean()).doubleValue(), 1e-6);
		assertEquals(3.6055512754639891, a.stdDeviation(), 1e-6);
		assertEquals(13., a.variance(), 1e-6);
	}

}
