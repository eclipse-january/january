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

public class FloatDatasetTest {

	@Test
	public void testConstructor() {
		assertEquals(0, new FloatDataset().getSize());
		assertEquals(0, DatasetFactory.createFromObject(1f).getRank());

		float[] da = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		FloatDataset a = new FloatDataset(da);

		IndexIterator it = a.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i, a.getElementDoubleAbs(it.index), 1e-5*i);
		}

		FloatDataset b = new FloatDataset(da, 3, 4);

		it = b.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i, b.getElementDoubleAbs(it.index), 1e-5*i);
		}

		// test hashes
		a.hashCode();
		b.hashCode();

		Class<? extends Dataset> clazz = a.getClass();
		assertEquals(true,  InterfaceUtils.isElemental(clazz));
		assertEquals(false, InterfaceUtils.isCompound(clazz));
		assertEquals(false, InterfaceUtils.isInteger(clazz));
		assertEquals(true,  InterfaceUtils.isNumerical(clazz));
		assertEquals(true,  InterfaceUtils.isFloating(clazz));
		assertEquals(false, InterfaceUtils.isComplex(clazz));
	}

	@Test
	public void testCreators() {
		float dz = 0.5f;
		FloatDataset z = FloatDataset.createFromObject(dz);
		assertEquals(0, z.getRank());
		assertEquals(1, z.getSize());
		assertEquals(dz, z.getElementDoubleAbs(0), 1e-14);

		float[] da = { 0, 1, 2, 3, 4, 5 };
		FloatDataset a = FloatDataset.createFromObject(da);
		assertEquals(1, a.getRank());
		assertEquals(6, a.getSize());
		assertEquals(6, a.getShapeRef()[0]);
		IndexIterator it = a.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i, a.getElementDoubleAbs(it.index), 1e-15 * i);
		}

		float[][] db = { { 0, 1, 2 }, { 3, 4, 5 } };
		FloatDataset b = FloatDataset.createFromObject(db);
		assertEquals(2, b.getRank());
		assertEquals(6, b.getSize());
		assertEquals(2, b.getShapeRef()[0]);
		assertEquals(3, b.getShapeRef()[1]);
		it = b.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i, b.getElementDoubleAbs(it.index), 1e-15 * i);
		}

		float[][] dc = { { 0, 1, 2, 3 }, { 4, 5, 6 } };
		FloatDataset c = FloatDataset.createFromObject(dc);
		assertEquals(2, c.getRank());
		assertEquals(8, c.getSize());
		assertEquals(2, c.getShapeRef()[0]);
		assertEquals(4, c.getShapeRef()[1]);
		it = c.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			if (i < 7) {
				assertEquals(i, c.getElementDoubleAbs(it.index), 1e-15 * i);
			} else {
				assertEquals(0, c.getElementDoubleAbs(it.index), 1e-15);
			}
		}

		float[][] dd = { { 0, 1, 2 }, { 4, 5, 6, 7 } };
		FloatDataset d = FloatDataset.createFromObject(dd);
		assertEquals(2, d.getRank());
		assertEquals(8, d.getSize());
		assertEquals(2, d.getShapeRef()[0]);
		assertEquals(4, d.getShapeRef()[1]);
		it = d.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			if (i != 3) {
				assertEquals(i, d.getElementDoubleAbs(it.index), 1e-15 * i);
			} else {
				assertEquals(0, d.getElementDoubleAbs(it.index), 1e-15);
			}
		}

		Float[] bda = { 0.5f, null, 2.5f};
		FloatDataset e = FloatDataset.createFromObject(bda);
		assertEquals(1, e.getRank());
		assertEquals(3, e.getSize());
		assertEquals(3, e.getShapeRef()[0]);
		it = e.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			if (i != 1) {
				assertEquals(i + 0.5, e.getElementDoubleAbs(it.index), 1e-15 * i);
			} else {
				assertTrue(Float.isNaN(e.getFloat(1)));
			}
		}
	}

	@Test
	public void testStats() {
		Dataset a = DatasetFactory.createRange(FloatDataset.class, 12);
		assertEquals(Float.valueOf(11), a.max());
		assertEquals(0., a.min().doubleValue(), 1e-6);
		assertEquals(5.5, ((Number) a.mean()).doubleValue(), 1e-6);
		assertEquals(3.6055512754639891, a.stdDeviation(), 1e-6);
		assertEquals(13., a.variance(), 1e-6);
	}

}
