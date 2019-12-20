/*-
 * Copyright (c) 2012, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.apache.commons.math3.complex.Complex;
import org.eclipse.january.MetadataException;
import org.eclipse.january.asserts.TestUtils;
import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.dataset.DoubleDataset;
import org.eclipse.january.dataset.IndexIterator;
import org.eclipse.january.dataset.Maths;
import org.eclipse.january.dataset.Slice;
import org.eclipse.january.metadata.StatisticsMetadata;
import org.junit.Test;

public class DoubleDatasetTest {

	@Test
	public void testConstructor() {
		assertEquals(0, new DoubleDataset().getSize());
		assertEquals(0, DatasetFactory.createFromObject(1d).getRank());

		double[] da = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		DoubleDataset a = new DoubleDataset(da);

		IndexIterator it = a.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i, a.getElementDoubleAbs(it.index), 1e-5 * i);
		}

		DoubleDataset b = new DoubleDataset(da, 3, 4);

		it = b.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i, b.getElementDoubleAbs(it.index), 1e-5 * i);
		}

		DoubleDataset c = new DoubleDataset(a.getSliceView(new int[] {1}, null, new int[] {2}));
		it = c.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(2*i+1, c.getElementDoubleAbs(it.index), 1e-5 * i);
		}

		// test hashes
		a.hashCode();
		b.hashCode();
		c.hashCode();
	}

	@Test
	public void testClone() {
		DoubleDataset z = new DoubleDataset();
		TestUtils.assertDatasetEquals(z, z.clone());

		double[] da = null;
		try {
			z = new DoubleDataset(da);
			fail("Should have thrown an IAE");
		} catch (IllegalArgumentException e) {
		}

		da = new double[0];
		z = new DoubleDataset(da);
		TestUtils.assertDatasetEquals(z, z.clone());

		z = new DoubleDataset(0);
		TestUtils.assertDatasetEquals(z, z.clone());

		z = new DoubleDataset(0, 1);
		TestUtils.assertDatasetEquals(z, z.clone());

		da = new double[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		DoubleDataset a = new DoubleDataset(da);

		TestUtils.assertDatasetEquals(a, a.clone());
	}

	@Test
	public void testGetter() {
		double[] da = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		DoubleDataset a = new DoubleDataset(da);
		int l = da.length;
		for (int i = 0; i < l; i++) {
			assertEquals(i, a.getDouble(i), 1e-5 * i);
		}

		for (int i = 0; i < l; i++) {
			int r = l - 1 - i;
			assertEquals(r, a.getDouble(-(i + 1)), 1e-5 * r);
		}

		Dataset sv = a.getSliceView(new Slice(2, 7));
		Dataset sc = a.getSlice(new Slice(2, 7));
		l = sc.getSize();
		for (int i = 0; i < l; i++) {
			double r = sc.getDouble(-(i + 1));
			assertEquals(r, sv.getDouble(-(i + 1)), 1e-5 * r);
		}

		assertEquals(0, a.getDouble(), 1e-16);

		try {
			a.getDouble(null);
			fail("Should have thrown an NPE");
		} catch (NullPointerException e) {
		}

		try {
			a.getDouble(new int[2]);
			fail("Should have thrown an IAE");
		} catch (IllegalArgumentException e) {
		}

		try {
			a.getDouble(0, 0);
			fail("Should have thrown a UOE");
		} catch (UnsupportedOperationException e) {
		}

		sc = a.getSlice(new Slice(7, 2));
		TestUtils.assertDatasetEquals(new DoubleDataset(0), sc);

		Dataset b = a.reshape(4, 3);
		try {
			b.getDouble(new int[1]);
			fail("Should have thrown an IAE");
		} catch (IllegalArgumentException e) {
		}

		try {
			b.getDouble(0);
			fail("Should have thrown a UOE");
		} catch (UnsupportedOperationException e) {
		}

		sc = b.getSlice(new Slice(7, 2));
		TestUtils.assertDatasetEquals(new DoubleDataset(0, 3), sc);

		sc = b.getSlice(new Slice(2, 5, -1));
		TestUtils.assertDatasetEquals(new DoubleDataset(0, 3), sc);
	}

	@Test
	public void testCreators() {
		double dz = 0.5;
		DoubleDataset z = DoubleDataset.createFromObject(dz);
		assertEquals(0, z.getRank());
		assertEquals(1, z.getSize());
		assertEquals(dz, z.getElementDoubleAbs(0), 1e-14);

		double[] da = { 0, 1, 2, 3, 4, 5 };
		DoubleDataset a = DoubleDataset.createFromObject(da);
		assertEquals(1, a.getRank());
		assertEquals(6, a.getSize());
		assertEquals(6, a.getShapeRef()[0]);
		IndexIterator it = a.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i, a.getElementDoubleAbs(it.index), 1e-15 * i);
		}

		double[][] db = { { 0, 1, 2 }, { 3, 4, 5 } };
		DoubleDataset b = DoubleDataset.createFromObject(db);
		assertEquals(2, b.getRank());
		assertEquals(6, b.getSize());
		assertEquals(2, b.getShapeRef()[0]);
		assertEquals(3, b.getShapeRef()[1]);
		it = b.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i, b.getElementDoubleAbs(it.index), 1e-15 * i);
		}

		double[][] dc = { { 0, 1, 2, 3 }, { 4, 5, 6 } };
		DoubleDataset c = DoubleDataset.createFromObject(dc);
		assertEquals(2, c.getRank());
		assertEquals(8, c.getSize());
		assertEquals(2, c.getShapeRef()[0]);
		assertEquals(4, c.getShapeRef()[1]);
		it = c.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			if (i < 7)
				assertEquals(i, c.getElementDoubleAbs(it.index), 1e-15 * i);
			else
				assertEquals(0, c.getElementDoubleAbs(it.index), 1e-15);
		}

		double[][] dd = { { 0, 1, 2 }, { 4, 5, 6, 7 } };
		DoubleDataset d = DoubleDataset.createFromObject(dd);
		assertEquals(2, d.getRank());
		assertEquals(8, d.getSize());
		assertEquals(2, d.getShapeRef()[0]);
		assertEquals(4, d.getShapeRef()[1]);
		it = d.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			if (i != 3)
				assertEquals(i, d.getElementDoubleAbs(it.index), 1e-15 * i);
			else
				assertEquals(0, d.getElementDoubleAbs(it.index), 1e-15);
		}
	}

	@Test
	public void testRange() {
		DoubleDataset a = DoubleDataset.createRange(2, 12.4, 4.3);
		DoubleDataset e = new DoubleDataset(new double[] {2, 6.3, 10.6});
		TestUtils.assertDatasetEquals(e, a);

		a = DoubleDataset.createRange(12.4, 2, -4.3);
		e = new DoubleDataset(new double[] {12.4, 8.1, 3.8});
		TestUtils.assertDatasetEquals(e, a);

		a = DoubleDataset.createRange(2, 12.4, -4.3);
		e = new DoubleDataset(0);
		TestUtils.assertDatasetEquals(e, a);

		a = DoubleDataset.createRange(12.4, 2, 4.3);
		TestUtils.assertDatasetEquals(e, a);
	}

	@Test
	public void testStats() {
		Dataset a = DatasetFactory.createRange(12);
		assertEquals(Double.valueOf(11), a.max());
		assertEquals(0., a.min().doubleValue(), 1e-6);
		assertEquals(5.5, ((Number) a.mean()).doubleValue(), 1e-6);
		assertEquals(3.6055512754639891, a.stdDeviation(), 1e-6);
		assertEquals(13., a.variance(), 1e-6);

		// invalid slice view check
		Dataset v = a.getSliceView(new Slice(14, 24));
		try {
			v.max();
			fail("Should have thrown exception");
		} catch (UnsupportedOperationException e) {
			// do nothing
		} catch (Exception e) {
			fail("Unexpected exception");
		}
		try {
			v.minPos();
			fail("Should have thrown exception");
		} catch (UnsupportedOperationException e) {
			// do nothing
		} catch (Exception e) {
			fail("Unexpected exception");
		}
		assertEquals(0., ((Number) v.sum()).doubleValue(), 1e-6);
		assertTrue(Double.isNaN(((Number) v.mean()).doubleValue()));

		a.setShape(3, 1, 4);
		Dataset b = a.sum(0);
		assertEquals(2, b.getRank());
		assertArrayEquals(new int[] { 1, 4 }, b.getShapeRef());
		assertEquals(12., b.getDouble(0, 0), 1e-6);
		assertEquals(15., b.getDouble(0, 1), 1e-6);
		assertEquals(18., b.getDouble(0, 2), 1e-6);
		assertEquals(21., b.getDouble(0, 3), 1e-6);
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(new double[] {16, 16, 16, 16}, 1, 4), a.variance(0));

		b = a.sum(1);
		assertEquals(2, b.getRank());
		assertArrayEquals(new int[] { 3, 4 }, b.getShapeRef());
		TestUtils.assertDatasetEquals(DatasetFactory.zeros(new int[] {3, 4}), a.variance(1));
		assertEquals(a.getView(true).squeeze(), b);

		b = a.sum(2);
		assertEquals(2, b.getRank());
		assertArrayEquals(new int[] { 3, 1 }, b.getShapeRef());
		assertEquals(6., b.getDouble(0, 0), 1e-6);
		assertEquals(22., b.getDouble(1, 0), 1e-6);
		assertEquals(38., b.getDouble(2, 0), 1e-6);
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(new double[] {1.666666666667, 1.666666666667, 1.666666666667}, 3, 1), a.variance(2));
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(new double[] {1.25, 1.25, 1.25}, 3, 1), a.variance(2, true));

		a.setShape(12);
		a.set(-1, 0);
		assertEquals(-1, a.min().doubleValue(), 1e-6);
		assertEquals(11, a.max().doubleValue(), 1e-6);
		assertEquals(5.41666667, ((Number) a.mean()).doubleValue(), 1e-6);
		assertEquals(3.75277675, a.stdDeviation(), 1e-6);
		assertEquals(14.0833333, a.variance(), 1e-6);

		a = DatasetFactory.createRange(60).reshape(4, 3, 5);
		assertEquals(a.max().doubleValue(), a.max(new int[] {0, 1, 2}).getDouble(), 1e-6);
		Dataset c = a.sum(2);
		assertArrayEquals(new int[] {4, 3}, c.getShapeRef());
		TestUtils.assertDatasetEquals(c, a.sum(new int[] {2}));
		c = c.sum(0);
		assertArrayEquals(new int[] {3}, c.getShapeRef());
		TestUtils.assertDatasetEquals(c, a.sum(new int[] {0, 2}));
		c = a.sum(0);
		assertArrayEquals(new int[] {3, 5}, c.getShapeRef());
		TestUtils.assertDatasetEquals(c, a.sum(new int[] {0}));
		c = c.sum(1);
		assertArrayEquals(new int[] {3}, c.getShapeRef());
		TestUtils.assertDatasetEquals(c, a.sum(new int[] {0, 2}));

		c = a.product(2);
		assertArrayEquals(new int[] {4, 3}, c.getShapeRef());
		TestUtils.assertDatasetEquals(c.product(0), a.product(new int[] {0, 2}));
		c = a.product(0);
		assertArrayEquals(new int[] {3, 5}, c.getShapeRef());
		TestUtils.assertDatasetEquals(c.product(1), a.product(new int[] {0, 2}));

		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(new double[] {49, 49, 49}), a.peakToPeak(new int[] {0, 2}));
	}

	@Test
	public void testShapeChangingStats() throws MetadataException {
		Dataset a = DatasetFactory.createRange(12).reshape(3, 4);
		a.max();
		a.setShape(3, 1, 4);
		Dataset b = a.getView(true);
		assertNull(b.getMetadata(StatisticsMetadata.class));;
	}

	@Test
	public void testMaths() {
		double[] da = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		DoubleDataset a = new DoubleDataset(da);

		Dataset r = Maths.add(a, a);
		IndexIterator it = r.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(2. * i, r.getElementDoubleAbs(it.index), 1e-5 * i);
		}
	}

	@Test
	public void testPosition() {
		double[] da = { 0, 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1 };
		DoubleDataset a = new DoubleDataset(da);

		assertEquals(6, a.maxPos()[0]);
		assertEquals(0, a.minPos()[0]);

		Dataset b = DatasetFactory.zeros(100, 200);

		b.set(100.00, 50, 100);
		b.set(-100.00, 51, 101);

		assertEquals(50, b.maxPos()[0]);
		assertEquals(100, b.maxPos()[1]);
		assertEquals(51, b.minPos()[0]);
		assertEquals(101, b.minPos()[1]);

		b.set(Double.NaN, 52, 53);

		assertEquals(52, b.maxPos()[0]);
		assertEquals(53, b.maxPos()[1]);

		assertEquals(50, b.maxPos(true)[0]);
		assertEquals(100, b.maxPos(true)[1]);

		Dataset c = DatasetFactory.zeros(100, 200);
		c.set(100.00, 99, 50);
		c.set(99.99, 50, 50);
		assertEquals(99, c.maxPos()[0]);
		assertEquals(50, c.maxPos()[1]);

		c.set(101, 0, 0);
		assertEquals(0, c.maxPos()[0]);
		assertEquals(0, c.maxPos()[1]);
	}

	@Test
	public void testInplaceMethods() {
		Dataset a = DatasetFactory.createRange(6);
		Dataset b = DatasetFactory.createRange(6);
		Dataset bl = DatasetFactory.createRange(LongDataset.class, 6);
		Dataset c, t;

		// add
		c = a.clone();
		TestUtils.assertDatasetEquals(a, c.iadd(b.getSliceView(new Slice(1))));

		c = a.clone();
		TestUtils.assertDatasetEquals(a, c.iadd(bl.getSliceView(new Slice(1))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.add(a, 3), c.iadd(b.getSliceView(new Slice(3, 4))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.add(a, 3l), c.iadd(bl.getSliceView(new Slice(3, 4))));

		c = a.clone();
		c.iadd(b);
		TestUtils.assertDatasetEquals(Maths.add(a, b), c);
		TestUtils.assertDatasetEquals(Maths.multiply(a, 2), c);

		c = a.clone();
		c.iadd(bl);
		TestUtils.assertDatasetEquals(Maths.add(a, bl), c);
		TestUtils.assertDatasetEquals(Maths.multiply(a, 2l), c);

		// subtract
		c = a.clone();
		TestUtils.assertDatasetEquals(a, c.isubtract(b.getSliceView(new Slice(1))));

		c = a.clone();
		TestUtils.assertDatasetEquals(a, c.isubtract(bl.getSliceView(new Slice(1))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.subtract(a, 3), c.isubtract(b.getSliceView(new Slice(3, 4))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.subtract(a, 3l), c.isubtract(bl.getSliceView(new Slice(3, 4))));

		c = a.clone();
		c.isubtract(b);
		TestUtils.assertDatasetEquals(DatasetFactory.zeros(a), c);
		TestUtils.assertDatasetEquals(Maths.multiply(a, 0), c);

		c = a.clone();
		c.isubtract(bl);
		TestUtils.assertDatasetEquals(DatasetFactory.zeros(a), c);
		TestUtils.assertDatasetEquals(Maths.multiply(a, 0), c);

		// multiply
		c = a.clone();
		TestUtils.assertDatasetEquals(a, c.imultiply(b.getSliceView(new Slice(1, 2))));

		c = a.clone();
		TestUtils.assertDatasetEquals(a, c.imultiply(bl.getSliceView(new Slice(1, 2))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.multiply(a, 3), c.imultiply(b.getSliceView(new Slice(3, 4))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.multiply(a, 3l), c.imultiply(bl.getSliceView(new Slice(3, 4))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.multiply(a, b), c.imultiply(b));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.multiply(a, bl), c.imultiply(bl));

		c = a.clone();
		c.imultiply(b);
		TestUtils.assertDatasetEquals(Maths.power(a, 2), c);
		TestUtils.assertDatasetEquals(Maths.square(a), c);

		c = a.clone();
		c.imultiply(bl);
		TestUtils.assertDatasetEquals(Maths.power(a, 2l), c);
		TestUtils.assertDatasetEquals(Maths.square(a), c);

		// divide
		c = a.clone();
		TestUtils.assertDatasetEquals(a, c.idivide(b.getSliceView(new Slice(1, 2))));

		c = a.clone();
		TestUtils.assertDatasetEquals(a, c.idivide(bl.getSliceView(new Slice(1, 2))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.divide(a, 3), c.idivide(b.getSliceView(new Slice(3, 4))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.divide(a, 3l), c.idivide(bl.getSliceView(new Slice(3, 4))));

		c = a.clone();
		t = DatasetFactory.ones(a);
		t.set(Double.NaN, 0);
		TestUtils.assertDatasetEquals(t, c.idivide(b));

		c = a.clone();
		TestUtils.assertDatasetEquals(t, c.idivide(bl));

		// remainder
		c = a.clone();
		TestUtils.assertDatasetEquals(DatasetFactory.zeros(a), c.iremainder(b.getSliceView(new Slice(1, 2))));

		c = a.clone();
		TestUtils.assertDatasetEquals(DatasetFactory.zeros(a), c.iremainder(bl.getSliceView(new Slice(1, 2))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.remainder(a, 3), c.iremainder(b.getSliceView(new Slice(3, 4))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.remainder(a, 3l), c.iremainder(bl.getSliceView(new Slice(3, 4))));

		c = a.clone();
		t = DatasetFactory.zeros(a);
		t.set(Double.NaN, 0);
		TestUtils.assertDatasetEquals(t, c.iremainder(b));

		c = a.clone();
		TestUtils.assertDatasetEquals(t, c.iremainder(bl));

		// power
		c = a.clone();
		TestUtils.assertDatasetEquals(a, c.ipower(b.getSliceView(new Slice(1, 2))));

		c = a.clone();
		TestUtils.assertDatasetEquals(a, c.ipower(bl.getSliceView(new Slice(1, 2))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, 3), c.ipower(b.getSliceView(new Slice(3, 4))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, 3), c.ipower(bl.getSliceView(new Slice(3, 4))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, b), c.ipower(b));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, bl), c.ipower(bl));

		c = a.clone();
		TestUtils.assertDatasetEquals(a, c.ipower(bl.getSliceView(new Slice(1, 2))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, 3), c.ipower(b.getSliceView(new Slice(3, 4))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, 3), c.ipower(bl.getSliceView(new Slice(3, 4))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, b), c.ipower(b));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, bl), c.ipower(bl));
		
		ComplexDoubleDataset z;
		z = DatasetFactory.createComplexDataset(ComplexDoubleDataset.class, a, DatasetFactory.zeros(a));
		c = a.clone();
		TestUtils.assertDatasetEquals(a, c.ipower(z.getSliceView(new Slice(1, 2))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, 3), c.ipower(z.getSliceView(new Slice(3, 4))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, z).cast(DoubleDataset.class), c.ipower(z));

		z = DatasetFactory.createComplexDataset(ComplexDoubleDataset.class, a, a);
		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, new Complex(1, 1)).cast(DoubleDataset.class), c.ipower(z.getSliceView(new Slice(1, 2))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, new Complex(3, 3)).cast(DoubleDataset.class), c.ipower(z.getSliceView(new Slice(3, 4))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, z).cast(DoubleDataset.class), c.ipower(z));


		// floor
		a = Maths.multiply(a, 1.5);

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.floor(a), c.ifloor());
	}
}
