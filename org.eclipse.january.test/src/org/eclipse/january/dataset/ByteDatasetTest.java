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

public class ByteDatasetTest {

	@Test
	public void testConstructor() {
		assertEquals(0, new ByteDataset().getSize());
		assertEquals(0, DatasetFactory.createFromObject((byte) 1).getRank());

		byte[] da = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		ByteDataset a = new ByteDataset(da);

		IndexIterator it = a.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i, a.getElementLongAbs(it.index));
		}

		ByteDataset b = new ByteDataset(da, 3, 4);

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
	public void testStats() {
		Dataset a = DatasetFactory.createRange(ByteDataset.class, 12);
		assertEquals(Byte.valueOf((byte) 11), a.max());
		assertEquals(0., a.min().doubleValue(), 1e-6);
		assertEquals(5.5, ((Number) a.mean()).doubleValue(), 1e-6);
		assertEquals(3.6055512754639891, a.stdDeviation(), 1e-6);
		assertEquals(13., a.variance(), 1e-6);
	}

}
