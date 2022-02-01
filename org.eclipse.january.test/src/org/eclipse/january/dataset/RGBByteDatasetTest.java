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
import org.junit.Test;

/**
 * Basic tests of RGB dataset
 */
public class RGBByteDatasetTest {

	@Test
	public void testConstructors() {
		assertEquals(0, new RGBByteDataset().getSize());
		assertEquals(0, DatasetFactory.createFromObject(RGBByteDataset.class, new byte[] {1,3,5}).getRank());

		int n = 250;
		Dataset r = DatasetFactory.createRange(IntegerDataset.class, n);
		Dataset g = DatasetFactory.createRange(IntegerDataset.class, 1., n+1, 1);
		Dataset b = DatasetFactory.createRange(IntegerDataset.class, 2., n+2, 1);
		RGBByteDataset c = new RGBByteDataset(r, g, b);

		for (int i = 0; i < n; i++) {
			assertEquals(i, Byte.toUnsignedInt(c.getRed(i)));
			assertEquals(i + 1, Byte.toUnsignedInt(c.getGreen(i)));
			assertEquals(i + 2, Byte.toUnsignedInt(c.getBlue(i)));
		}

		c = new RGBByteDataset(g);
		for (int i = 0; i < n; i++) {
			assertEquals(i + 1, Byte.toUnsignedInt(c.getRed(i)));
			assertEquals(i + 1, Byte.toUnsignedInt(c.getGreen(i)));
			assertEquals(i + 1, Byte.toUnsignedInt(c.getBlue(i)));
		}

		r = r.cast(ByteDataset.class);
		g = g.cast(ByteDataset.class);
		b = b.cast(ByteDataset.class);

		c = new RGBByteDataset((byte[]) r.getBuffer(), (byte[]) g.getBuffer(), (byte[]) b.getBuffer());
		for (int i = 0; i < n; i++) {
			assertEquals(i, Byte.toUnsignedInt(c.getRed(i)));
			assertEquals(i + 1, Byte.toUnsignedInt(c.getGreen(i)));
			assertEquals(i + 2, Byte.toUnsignedInt(c.getBlue(i)));
		}

		CompoundDataset cc = DatasetFactory.createRange(2, CompoundIntegerDataset.class, n);
		c = RGBByteDataset.createFromCompoundDataset(cc);
		for (int i = 0; i < n; i++) {
			assertEquals(i, Byte.toUnsignedInt(c.getRed(i)));
			assertEquals(i, Byte.toUnsignedInt(c.getGreen(i)));
			assertEquals(i, Byte.toUnsignedInt(c.getBlue(i)));
		}
		
		cc = DatasetFactory.createRange(4, CompoundIntegerDataset.class, n);
		c = RGBByteDataset.createFromCompoundDataset(cc);
		for (int i = 0; i < n; i++) {
			assertEquals(i, Byte.toUnsignedInt(c.getRed(i)));
			assertEquals(0, c.getGreen(i));
			assertEquals(0, c.getBlue(i));
		}

		Class<? extends Dataset> clazz = c.getClass();
		assertEquals(false, InterfaceUtils.isElemental(clazz));
		assertEquals(true,  InterfaceUtils.isCompound(clazz));
		assertEquals(true,  InterfaceUtils.isInteger(clazz));
		assertEquals(true,  InterfaceUtils.isNumerical(clazz));
		assertEquals(false, InterfaceUtils.isFloating(clazz));
		assertEquals(false, InterfaceUtils.isComplex(clazz));
	}

	@Test
	public void testConstructorsWithSliceViews() {
		int n = 10;
		Dataset a = DatasetFactory.createRange(IntegerDataset.class, 3*n).reshape(3, n);

		Dataset r = a.getSliceView(new Slice(0, 1)).squeeze();
		Dataset g = a.getSliceView(new Slice(1, 2)).squeeze();
		Dataset b = a.getSliceView(new Slice(2, 3)).squeeze();

		RGBByteDataset c = new RGBByteDataset(r, g, b);
		for (int i = 0; i < n; i++) {
			assertEquals(r.getInt(i), c.getRed(i));
			assertEquals(g.getInt(i), c.getGreen(i));
			assertEquals(b.getInt(i), c.getBlue(i));
		}
	}

	@Test
	public void testConverters() {
		byte[] rgbs = new byte[] {
				(byte) 255, 0, 0,            // Red
				(byte) 191, (byte) 191, 0,   // Dirty yellow
				0, 127, 0,                   // Dark green
				127, (byte) 255, (byte) 255, // Cyan
				127, 127, (byte) 255,        // Lavender
				(byte) 191, 63, (byte) 191,  // Mauve
				};

		RGBByteDataset rgb = RGBByteDataset.createFromCompoundDataset(new CompoundByteDataset(3, rgbs, 6));
		ByteDataset g = new ByteDataset(new byte[] {76,  (byte) 169,   74,  (byte) 216,  (byte) 141,  115}, 6);
		TestUtils.assertDatasetEquals(g, rgb.createGreyDataset(ByteDataset.class), 1, 1);

		Dataset h = new ShortDataset(new short[] {0, 60, 120, 180, 240, 300}, 6);
		Dataset v = new FloatDataset(new float[] {1, 0.75f, 0.5f, 1, 1, 0.75f}, 6);
		Dataset s = new DoubleDataset(new double[] {1, 1, 1, 0.5, 0.5, 0.667}, 6);
		RGBByteDataset a = RGBByteDataset.createFromHSV(h, s, v);
		TestUtils.assertDatasetEquals(rgb, a, 1, 1);
		h.isubtract(360);
		a = RGBByteDataset.createFromHSV(h, s, v);
		TestUtils.assertDatasetEquals(rgb, a, 1, 1);

		Dataset l = new FloatDataset(new float[] {0.5f, 0.375f, 0.25f, 0.75f, 0.75f, 0.5f}, 6);
		s = new DoubleDataset(new double[] {1, 1, 1, 1, 1, 0.5}, 6);
		a = RGBByteDataset.createFromHSL(h, s, l);
		TestUtils.assertDatasetEquals(rgb, a, 1, 1);

		h.iadd(360);
		a = RGBByteDataset.createFromHSL(h, s, l);
		TestUtils.assertDatasetEquals(rgb, a, 1, 1);

		FloatDataset bf = rgb.createBlueDataset(FloatDataset.class);
		s = DatasetFactory.createFromObject(FloatDataset.class, new short[] {0, 0, 0, 255, 255, 191});
		TestUtils.assertDatasetEquals(s, bf, 1, 1);
	}
}
