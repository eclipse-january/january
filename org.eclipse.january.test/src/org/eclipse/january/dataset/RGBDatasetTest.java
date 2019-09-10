/*-
 * Copyright (c) 2014, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import static org.junit.Assert.assertEquals;

import org.eclipse.january.asserts.TestUtils;
import org.eclipse.january.dataset.CompoundDataset;
import org.eclipse.january.dataset.CompoundShortDataset;
import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.dataset.DoubleDataset;
import org.eclipse.january.dataset.FloatDataset;
import org.eclipse.january.dataset.RGBDataset;
import org.eclipse.january.dataset.ShortDataset;
import org.junit.Test;

/**
 * Basic tests of RGB dataset
 */
public class RGBDatasetTest {
	@Test
	public void testConstructors() {
		assertEquals(0, new RGBDataset().getSize());
		assertEquals(0, DatasetFactory.createFromObject(RGBDataset.class, new short[] {1,3,5}).getRank());

		int n = 250;
		Dataset r = DatasetFactory.createRange(IntegerDataset.class, n);
		Dataset g = DatasetFactory.createRange(IntegerDataset.class, 1., n+1, 1);
		Dataset b = DatasetFactory.createRange(IntegerDataset.class, 2., n+2, 1);
		RGBDataset c = new RGBDataset(r, g, b);

		for (int i = 0; i < n; i++) {
			assertEquals(i, c.getRed(i));
			assertEquals(i + 1, c.getGreen(i));
			assertEquals(i + 2, c.getBlue(i));
		}

		c = new RGBDataset(g);
		for (int i = 0; i < n; i++) {
			assertEquals(i + 1, c.getRed(i));
			assertEquals(i + 1, c.getGreen(i));
			assertEquals(i + 1, c.getBlue(i));
		}

		r = r.cast(ByteDataset.class);
		g = g.cast(ByteDataset.class);
		b = b.cast(ByteDataset.class);

		c = new RGBDataset((byte[]) r.getBuffer(), (byte[]) g.getBuffer(), (byte[]) b.getBuffer());
		for (int i = 0; i < n; i++) {
			assertEquals(i, c.getRed(i));
			assertEquals(i + 1, c.getGreen(i));
			assertEquals(i + 2, c.getBlue(i));
		}

		CompoundDataset cc = DatasetFactory.createRange(2, CompoundIntegerDataset.class, n);
		c = RGBDataset.createFromCompoundDataset(cc);
		for (int i = 0; i < n; i++) {
			assertEquals(i, c.getRed(i));
			assertEquals(i, c.getGreen(i));
			assertEquals(i, c.getBlue(i));
		}
		
		cc = DatasetFactory.createRange(4, CompoundIntegerDataset.class, n);
		c = RGBDataset.createFromCompoundDataset(cc);
		for (int i = 0; i < n; i++) {
			assertEquals(i, c.getRed(i));
			assertEquals(0, c.getGreen(i));
			assertEquals(0, c.getBlue(i));
		}
	}

	@Test
	public void testConverters() {
		short[] rgbs = new short[] {
				255, 0, 0,     // Red
				191, 191, 0,   // Dirty yellow
				0, 127, 0,     // Dark green
				127, 255, 255, // Cyan
				127, 127, 255, // Lavender
				191, 63, 191,  // Mauve
				};

		RGBDataset rgb = RGBDataset.createFromCompoundDataset(new CompoundShortDataset(3, rgbs, 6));
		ShortDataset g = new ShortDataset(new short[] {76,  169,   74,  216,  141,  115}, 6);
		TestUtils.assertDatasetEquals(g, rgb.createGreyDataset(ShortDataset.class), 1, 1);

		Dataset h = new ShortDataset(new short[] {0, 60, 120, 180, 240, 300}, 6);
		Dataset v = new FloatDataset(new float[] {1, 0.75f, 0.5f, 1, 1, 0.75f}, 6);
		Dataset s = new DoubleDataset(new double[] {1, 1, 1, 0.5, 0.5, 0.667}, 6);
		RGBDataset a = RGBDataset.createFromHSV(h, s, v);
		TestUtils.assertDatasetEquals(rgb, a, 1, 1);
		h.isubtract(360);
		a = RGBDataset.createFromHSV(h, s, v);
		TestUtils.assertDatasetEquals(rgb, a, 1, 1);

		Dataset l = new FloatDataset(new float[] {0.5f, 0.375f, 0.25f, 0.75f, 0.75f, 0.5f}, 6);
		s = new DoubleDataset(new double[] {1, 1, 1, 1, 1, 0.5}, 6);
		a = RGBDataset.createFromHSL(h, s, l);
		TestUtils.assertDatasetEquals(rgb, a, 1, 1);

		h.iadd(360);
		a = RGBDataset.createFromHSL(h, s, l);
		TestUtils.assertDatasetEquals(rgb, a, 1, 1);
	}
}
