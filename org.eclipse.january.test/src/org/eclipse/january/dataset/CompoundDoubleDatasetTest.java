/*-
 *******************************************************************************
 * Copyright (c) 2017 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Peter Chang - initial API and implementation and/or initial documentation
 *******************************************************************************/


package org.eclipse.january.dataset;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.eclipse.january.asserts.TestUtils;
import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.dataset.DoubleDataset;
import org.eclipse.january.dataset.IndexIterator;
import org.eclipse.january.dataset.Maths;
import org.eclipse.january.dataset.Slice;
import org.junit.Test;

public class CompoundDoubleDatasetTest {

	@Test
	public void testConstructor() {
		assertEquals(0, new CompoundDoubleDataset().getSize());
		assertEquals(0, new CompoundDoubleDataset(2).getSize());
		assertEquals(0, DatasetFactory.createFromObject(2, CompoundDoubleDataset.class, 1d).getRank());

		double[] da = { 0, 0.5, 1, 1.5, 2, 2.5, 3, 3.5, 4, 4.5, 5, 5.5,
				6, 6.5, 7, 7.5, 8, 8.5, 9, 9.5, 10, 10.5, 11, 11.5 };
		CompoundDoubleDataset a = new CompoundDoubleDataset(2, da);

		IndexIterator it = a.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i, a.getElementDoubleAbs(it.index), 1e-5 * i);
			assertEquals(i + 0.5, a.getElementDoubleAbs(it.index + 1), 1e-5 * i);
		}

		CompoundDoubleDataset b = new CompoundDoubleDataset(2, da, 3, 4);

		it = b.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i, b.getElementDoubleAbs(it.index), 1e-5 * i);
			assertEquals(i + 0.5, b.getElementDoubleAbs(it.index + 1), 1e-5 * i);
		}

		CompoundDoubleDataset c = new CompoundDoubleDataset(a.getSliceView(new int[] {1}, null, new int[] {2}));
		it = c.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(2*i+1, c.getElementDoubleAbs(it.index), 1e-5 * i);
			assertEquals(2*i+1.5, c.getElementDoubleAbs(it.index + 1), 1e-5 * i);
		}

		// test hashes
		a.hashCode();
		b.hashCode();
		c.hashCode();
	}

	@Test
	public void testGetter() {
		double[] da = { 0, 0.5, 1, 1.5, 2, 2.5, 3, 3.5, 4, 4.5, 5, 5.5,
				6, 6.5, 7, 7.5, 8, 8.5, 9, 9.5, 10, 10.5, 11, 11.5 };
		CompoundDoubleDataset a = new CompoundDoubleDataset(2, da);
		int l = da.length/2;
		for (int i = 0; i < l; i++) {
			assertEquals(i, a.getDouble(i), 1e-5 * i);
			assertArrayEquals(new double[] {i, i+0.5}, a.getDoubleArray(i), 1e-5 * i);
		}

		for (int i = 0; i < l; i++) {
			int r = l - 1 - i;
			assertEquals(r, a.getDouble(-(i + 1)), 1e-5 * r);
			assertArrayEquals(new double[] {r, r+0.5}, a.getDoubleArray(-(i+1)), 1e-5 * i);
		}

		CompoundDataset sv = a.getSliceView(new Slice(2, 7));
		CompoundDataset sc = a.getSlice(new Slice(2, 7));
		l = sc.getSize();
		for (int i = 0; i < l; i++) {
			double r = sc.getDouble(-(i + 1));
			assertEquals(r, sv.getDouble(-(i + 1)), 1e-5 * r);
			assertArrayEquals(new double[] {r, r+0.5}, sv.getDoubleArray(-(i+1)), 1e-5 * i);
		}

		assertEquals(0, a.getDouble(), 1e-16);
		assertArrayEquals(new double[] {0, 0.5}, a.getDoubleArray(), 1e-5);

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
	}

	@Test
	public void testCreators() {
		double dz = 0.5;
		CompoundDoubleDataset z = CompoundDoubleDataset.createFromObject(dz);
		assertEquals(0, z.getRank());
		assertEquals(1, z.getSize());
		assertEquals(dz, z.getElementDoubleAbs(0), 1e-14);

		double[] da = { 0, 1, 2, 3, 4, 5 };
		CompoundDoubleDataset a = CompoundDoubleDataset.createFromObject(da);
		assertEquals(6, a.getElementsPerItem());
		assertEquals(1, a.getRank());
		assertEquals(1, a.getSize());
		assertEquals(1, a.getShape()[0]);
		IndexIterator it = a.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			for (int j = 0; j < 6; j++) {
				assertEquals(i + j, a.getElementDoubleAbs(it.index + j), 1e-15 * i);
			}
		}

		double[][] db = { { 0, 1, 2 }, { 3, 4, 5 } };
		CompoundDoubleDataset b = CompoundDoubleDataset.createFromObject(db);
		assertEquals(3, b.getElementsPerItem());
		assertEquals(1, b.getRank());
		assertEquals(2, b.getSize());
		assertEquals(2, b.getShape()[0]);
		it = b.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			for (int j = 0; j < 3; j++) {
				assertEquals(i*3 + j, b.getElementDoubleAbs(it.index + j), 1e-15 * i);
			}
		}

		double[][] dc = { { 0, 1, 2, 3 }, { 4, 5, 6 } };
		CompoundDoubleDataset c = CompoundDoubleDataset.createFromObject(dc);
		assertEquals(4, c.getElementsPerItem());
		assertEquals(1, c.getRank());
		assertEquals(2, c.getSize());
		assertEquals(2, c.getShape()[0]);
		it = c.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			for (int j = 0; j < 3; j++) {
				int r = i*4 + j;
				assertEquals(r < 7 ? r : 0, c.getElementDoubleAbs(it.index + j), 1e-15 * i);
			}
		}

		double[][] dd = { { 0, 1, 2 }, { 4, 5, 6, 7 } };
		CompoundDoubleDataset d = CompoundDoubleDataset.createFromObject(dd);
		assertEquals(4, d.getElementsPerItem());
		assertEquals(1, d.getRank());
		assertEquals(2, d.getSize());
		assertEquals(2, d.getShape()[0]);
		it = d.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			for (int j = 0; j < 3; j++) {
				int r = i*4 + j;
				assertEquals(r != 3 ? r : 0, d.getElementDoubleAbs(it.index + j), 1e-15 * i);
			}
		}
	}

	@Test
	public void testStats() {
		DoubleDataset d = DatasetFactory.createRange(DoubleDataset.class, 36);
		d.setShape(3,4,3);
		CompoundDataset a = DatasetUtils.createCompoundDatasetFromLastAxis(d, true);

		try {
			a.max();
			fail("Should have thrown an UOE");
		} catch (UnsupportedOperationException e) {
			// do nothing
		}
		try {
			a.max(0);
			fail("Should have thrown an UOE");
		} catch (UnsupportedOperationException e) {
			// do nothing
		}
		try {
			a.argMax();
			fail("Should have thrown an UOE");
		} catch (UnsupportedOperationException e) {
			// do nothing
		}
		try {
			a.argMax(0);
			fail("Should have thrown an UOE");
		} catch (UnsupportedOperationException e) {
			// do nothing
		}
		try {
			a.peakToPeak();
			fail("Should have thrown an UOE");
		} catch (UnsupportedOperationException e) {
			// do nothing
		}
		try {
			a.peakToPeak(0);
			fail("Should have thrown an UOE");
		} catch (UnsupportedOperationException e) {
			// do nothing
		}

		assertEquals(12, a.count());
		assertArrayEquals(new double[] {16.5, 17.5, 18.5}, (double[]) a.mean(), 1e-10);
		assertEquals(351, a.variance(), 1e-10);
		assertEquals(321.75, a.variance(true), 1e-10);
		assertArrayEquals(new double[] {198, 210, 222}, (double[]) a.sum(), 1e-10);
		assertEquals(Math.sqrt(1242.5), a.rootMeanSquare(), 1e-10);

		assertArrayEquals(new double[] {33, 34, 35}, a.maxItem(), 1e-10);

		a.setShape(3, 1, 4);
		CompoundDataset b = a.sum(0);
		assertEquals(DatasetFactory.zeros(LongDataset.class, 1, 4).fill(3) , a.count(0));
		assertEquals(2, b.getRank());
		assertArrayEquals(new int[] { 1, 4 }, b.getShape());
		assertArrayEquals(new double[] {36, 39, 42}, b.getDoubleArray(0, 0), 1e-10);
		assertArrayEquals(new double[] {45, 48, 51}, b.getDoubleArray(0, 1), 1e-10);
		assertArrayEquals(new double[] {54, 57, 60}, b.getDoubleArray(0, 2), 1e-10);
		assertArrayEquals(new double[] {63, 66, 69}, b.getDoubleArray(0, 3), 1e-10);

		b = a.sum(1);
		assertEquals(DatasetFactory.zeros(LongDataset.class, 3, 4).fill(1) , a.count(1));
		assertEquals(2, b.getRank());
		assertArrayEquals(new int[] { 3, 4 }, b.getShape());
		assertEquals(a.squeeze(), b);

		a.setShape(3, 1, 4);
		b = a.sum(2);
		assertEquals(DatasetFactory.zeros(LongDataset.class, 3, 1).fill(4) , a.count(2));
		assertEquals(2, b.getRank());
		assertArrayEquals(new int[] { 3, 1 }, b.getShape());
		assertArrayEquals(new double[] {18, 22, 26}, b.getDoubleArray(0, 0), 1e-10);
		assertArrayEquals(new double[] {66, 70, 74}, b.getDoubleArray(1, 0), 1e-10);
		assertArrayEquals(new double[] {114, 118, 122}, b.getDoubleArray(2, 0), 1e-10);

		d = DatasetFactory.createRange(DoubleDataset.class, 180);
		d.setShape(4, 3, 5, 3);
		a = DatasetUtils.createCompoundDatasetFromLastAxis(d, true);
		CompoundDataset c = a.sum(2);
		assertArrayEquals(new double[] {30, 35, 40}, c.getDoubleArray(0, 0), 1e-10);
		TestUtils.assertDatasetEquals(c, a.sum(new int[] {2}));
		TestUtils.assertDatasetEquals(c.sum(0), a.sum(new int[] {0, 2}));
		c = a.sum(0);
		assertArrayEquals(new double[] {270, 274, 278}, c.getDoubleArray(0, 0), 1e-10);
		TestUtils.assertDatasetEquals(c, a.sum(new int[] {0}));
		TestUtils.assertDatasetEquals(c.sum(1), a.sum(new int[] {0, 2}));

		c = a.product(2);
		TestUtils.assertDatasetEquals(c.product(0), a.product(new int[] {0, 2}));
		c = a.product(0);
		TestUtils.assertDatasetEquals(c.product(1), a.product(new int[] {0, 2}));

	}

	@Test
	public void testMaths() {
		DoubleDataset d = DatasetFactory.createRange(DoubleDataset.class, 36);
		d.setShape(3,4,3);
		CompoundDataset a = DatasetUtils.createCompoundDatasetFromLastAxis(d, true);

		Dataset r = Maths.add(a, a);
		IndexIterator it = r.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(6. * i, r.getElementDoubleAbs(it.index), 1e-5 * i);
			assertEquals(6. * i + 2, r.getElementDoubleAbs(it.index + 1), 1e-5 * i);
			assertEquals(6. * i + 4, r.getElementDoubleAbs(it.index + 2), 1e-5 * i);
		}
	}

	@Test
	public void testPosition() {
		DoubleDataset d = DatasetFactory.createRange(DoubleDataset.class, 36);
		d.setShape(3,4,3);
		CompoundDataset a = DatasetUtils.createCompoundDatasetFromLastAxis(d, true);

		try {
			a.maxPos();
			fail("Should have thrown an UOE");
		} catch (UnsupportedOperationException e) {
			// do nothing
		}
	}


	private static final double[] VALUES = new double[] {Double.NEGATIVE_INFINITY, -3, 0, 3, Double.POSITIVE_INFINITY, Double.NaN};

	@Test
	public void testZ() {
		for (double a : VALUES) {
			for (double b : VALUES) {
				System.err.println(a + " + " + b + " = " + (a+b));
			}
			
		}
		for (double a : VALUES) {
			for (double b : VALUES) {
				System.err.println(a + " * " + b + " = " + (a*b));
			}
			
		}
	}
}
