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
import static org.junit.Assert.assertTrue;

import org.eclipse.january.asserts.TestUtils;
import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.dataset.DatasetUtils;
import org.eclipse.january.dataset.DoubleDataset;
import org.eclipse.january.dataset.LinearAlgebra;
import org.eclipse.january.dataset.Maths;
import org.eclipse.january.dataset.Random;
import org.eclipse.january.dataset.Slice;
import org.eclipse.january.dataset.LinearAlgebra.NormOrder;
import org.junit.Test;

public class LinearAlgebraTest {

	private static boolean close(Number a, double b) {
		double x = a.doubleValue();
		return x == 0 ? Math.abs(b) < 10e-6 : Math.abs(x - b) < 10e-6*x;
	}

	@Test
	public void testTensorDot() {
		Dataset a = DatasetFactory.createRange(FloatDataset.class, 60).reshape(3, 4, 5);
		Dataset b = DatasetFactory.createRange(ShortDataset.class, 24).reshape(4, 3, 2);

		long start;
		start = -System.nanoTime();
		Dataset c = LinearAlgebra.tensorDotProduct(a, b, new int[] {1, 0}, new int[] {0,1});
		start += System.nanoTime();

		System.out.printf("Time taken %dus\n", start/1000);

		assertArrayEquals("Shape", new int[] {5, 2}, c.getShapeRef());
		assertEquals("Type", Dataset.FLOAT32, c.getDType());

		Dataset d = DatasetFactory.createFromObject(new double[] { 4400., 4730.,
			4532.,  4874., 4664., 5018., 4796.,  5162., 4928.,  5306. }, 5, 2);
		assertTrue("Data does not match", d.cast(c.getDType()).equals(c));

		int n = 16;
		a = DatasetFactory.createRange(FloatDataset.class, 20*n).reshape(n, 4, 5);
		b = DatasetFactory.createRange(ShortDataset.class, 8*n).reshape(4, n, 2);
		start = -System.nanoTime();
		c = LinearAlgebra.tensorDotProduct(a, b, 0, 1);
		start += System.nanoTime();

		long nstart = -System.nanoTime();
		d = LinearAlgebra.tensorDotProduct(a, b, new int[] {0}, new int[] {1});
		nstart += System.nanoTime();
		System.out.printf("Time taken %dus %dus\n", start/1000, nstart/1000);

		assertTrue("Data does not match", d.equals(c));
	}

	@Test
	public void testDot() {
		Dataset a = DatasetFactory.createRange(10);
		Dataset b = DatasetFactory.createRange(ShortDataset.class, -6, 4, 1);

		long start;
		start = -System.nanoTime();
//		Dataset c = LinearAlgebra.tensorDotProduct(a, b, 0, 0);
		Dataset c = LinearAlgebra.dotProduct(a, b);
		start += System.nanoTime();
		
		long nstart = -System.nanoTime();
		Dataset d = Maths.multiply(a, b);
		Number n = (Number) d.sum();
		nstart += System.nanoTime();
		System.out.printf("Time taken %dus %dus\n", start/1000, nstart/1000);
		assertTrue("Data does not match", n.equals(c.getObjectAbs(0)));
		assertTrue("Data does not match", n.equals(c.getObject()));
	}

	@Test
	public void testRandomDot() {
		Dataset a = Random.randn(123.5, 23.4, 100);
//		a = DatasetFactory.createFromObject(new double[] {166.332, 139.135, 145.899, 112.830, 125.682, 95.614 });

		Dataset aa = Maths.square(a);

		Dataset c = LinearAlgebra.tensorDotProduct(a, a, 0, 0);
		System.nanoTime();

		Number n = (Number) aa.sum();
		assertTrue("Second moment does not match: " + n + " cf " + c.getObject(), close(n, c.getDouble()));

		c = LinearAlgebra.dotProduct(aa, a);
		Dataset d = Maths.multiply(a, aa);
		n = (Number) d.sum();
		assertTrue("Third moment does not match: " + n + " cf " + c.getObject(), close(n, c.getDouble()));

		c = LinearAlgebra.dotProduct(aa, aa);
		d = Maths.multiply(aa, aa);
		n = (Number) d.sum();
		assertTrue("Fourth moment does not match: " + n + " cf " + c.getObject(), close(n, c.getDouble()));
	}


	@Test
	public void testOuter() {
		Dataset a;
		Dataset b;

		a = DatasetFactory.createRange(DoubleDataset.class, 2);
		b = DatasetFactory.createRange(DoubleDataset.class, 3);
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(new double[] {0, 0, 0, 0, 1, 2}, 2, 3), LinearAlgebra.outerProduct(a, b),
				1e-12, 1e-12);
		
		a = Random.randn(123.5, 23.4, 10);
		b = Random.randn(-31.2, 12.4, 7);
		Dataset c = LinearAlgebra.outerProduct(a, b);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 7; j++) {
				assertEquals("", a.getDouble(i)*b.getDouble(j), c.getDouble(i, j), 1e-12);
			}
		}
	}

	@Test
	public void testCross() {
		Dataset a, b, c, d;

		a = DatasetFactory.createFromObject(new int[] {2, 3, 5}, 3);
		b = DatasetFactory.createFromObject(new float[] {1, 4, 7, 2, 5, 8}, 2, 3);

		c = LinearAlgebra.crossProduct(a, b);
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(new double[] {1, -9, 5, -1, -6, 4}, 2, 3), c, 1e-15, 1e-15);
		d = LinearAlgebra.crossProduct(b, a);
		TestUtils.assertDatasetEquals(Maths.negative(c), d, 1e-15, 1e-15);
		c = LinearAlgebra.crossProduct(a, b, -1, -1, 0);
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(new double[] {1, -1, -9, -6, 5, 4}, 3, 2), c, 1e-15, 1e-15);
		d = LinearAlgebra.crossProduct(b, a, -1, -1, 0);
		TestUtils.assertDatasetEquals(Maths.negative(c), d, 1e-15, 1e-15);

		a = DatasetFactory.createFromObject(new int[] {2, 3, 0}, 3);
		c = LinearAlgebra.crossProduct(a, b);
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(new double[] {21, -14, 5, 24, -16, 4}, 2, 3), c, 1e-15, 1e-15);
		d = LinearAlgebra.crossProduct(b, a);
		TestUtils.assertDatasetEquals(Maths.negative(c), d, 1e-15, 1e-15);

		a = DatasetFactory.createFromObject(new int[] {2, 3}, 2);
		c = LinearAlgebra.crossProduct(a, b);
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(new double[] {21, -14, 5, 24, -16, 4}, 2, 3), c, 1e-15, 1e-15);
		d = LinearAlgebra.crossProduct(b, a);
		TestUtils.assertDatasetEquals(Maths.negative(c), d, 1e-15, 1e-15);

		a = DatasetFactory.createFromObject(new int[] {2, 3, 5}, 3);
		b = DatasetFactory.createFromObject(new float[] {1, 4, 0, 2, 5, 0}, 2, 3);
		c = LinearAlgebra.crossProduct(a, b);
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(new double[] {-20, 5, 5, -25, 10, 4}, 2, 3), c, 1e-15, 1e-15);
		d = LinearAlgebra.crossProduct(b, a);
		TestUtils.assertDatasetEquals(Maths.negative(c), d, 1e-15, 1e-15);

		b = DatasetFactory.createFromObject(new float[] {1, 4, 2, 5}, 2, 2);
		c = LinearAlgebra.crossProduct(a, b);
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(new double[] {-20, 5, 5, -25, 10, 4}, 2, 3), c, 1e-15, 1e-15);
		d = LinearAlgebra.crossProduct(b, a);
		TestUtils.assertDatasetEquals(Maths.negative(c), d, 1e-15, 1e-15);

		a = DatasetFactory.createFromObject(new int[] {2, 3}, 2);
		b = DatasetFactory.createFromObject(new float[] {1, 4, 2, 5}, 2, 2);
		c = LinearAlgebra.crossProduct(a, b);
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(new double[] {5, 4}, 2), c, 1e-15, 1e-15);
		d = LinearAlgebra.crossProduct(b, a);
		TestUtils.assertDatasetEquals(Maths.negative(c), d, 1e-15, 1e-15);
	}

	@Test
	public void testNorm() {
		Dataset a, b;
		a = DatasetFactory.createRange(IntegerDataset.class, 9);
		a.isubtract(4);
		b = a.reshape(3, 3);

		NormOrder n = NormOrder.DEFAULT;
		assertEquals(7.745966692414834, LinearAlgebra.norm(a, n), 1e-15);
		assertEquals(7.745966692414834, LinearAlgebra.norm(b, n), 1e-15);
		n = NormOrder.POS_INFINITY;
		assertEquals(4, LinearAlgebra.norm(a, n), 1e-15);
		assertEquals(9, LinearAlgebra.norm(b, n), 1e-15);
		n = NormOrder.NEG_INFINITY;
		assertEquals(0, LinearAlgebra.norm(a, n), 1e-15);
		assertEquals(2, LinearAlgebra.norm(b, n), 1e-15);

		int p = 1;
		assertEquals(20, LinearAlgebra.norm(a, p), 1e-15);
		assertEquals(7, LinearAlgebra.norm(b, p), 1e-15);
		p = -1;
		assertEquals(-4.6566128774142013e-010, LinearAlgebra.norm(a, p), 1e-09);
		assertEquals(6, LinearAlgebra.norm(b, p), 1e-15);
		p = 2;
		assertEquals(7.745966692414834, LinearAlgebra.norm(a, p), 1e-15);
		assertEquals(7.3484692283495345, LinearAlgebra.norm(b, p), 1e-15);
		p = -2;
//		assertTrue(Double.isNaN(LinearAlgebra.norm(a, p))); TODO make behave like NumPy?
		assertEquals(0, LinearAlgebra.norm(a, p), 1e-15);
		assertEquals(1.8570331885190563e-016, LinearAlgebra.norm(b, p), 1e-15);
		p = 3;
		assertEquals(5.8480354764257312, LinearAlgebra.norm(a, p), 1e-15);
		p = -3;
//		assertTrue(Double.isNaN(LinearAlgebra.norm(a, p)));
		assertEquals(0, LinearAlgebra.norm(a, p), 1e-15);
	}

	@Test
	public void testDeterminant() {
		Dataset a = DatasetFactory.createRange(IntegerDataset.class, 1, 21, 1).reshape(4, 5);
		assertEquals(0, LinearAlgebra.calcDeterminant(a.getSliceView(null, new Slice(4))), 1e-8);
	}

	@Test
	public void testTrace() {
		Dataset a = DatasetFactory.createRange(IntegerDataset.class, 20).reshape(4, 5);
		assertEquals(36, LinearAlgebra.trace(a).getInt());
		assertEquals(33, LinearAlgebra.trace(a, -1, 0, 1).getInt());
		assertEquals(40, LinearAlgebra.trace(a, 1, 0, 1).getInt());

		a = DatasetFactory.createRange(IntegerDataset.class, 60).reshape(3, 4, 5);
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(new int[]{36, 116, 196}, null), LinearAlgebra.trace(a, 0, 1, 2), true, 1e-12, 1e-12);
	}

	@Test
	public void testKronecker() {
		Dataset a = DatasetFactory.createFromObject(IntegerDataset.class, new int[] {1, 10, 100}, null);
		Dataset b = DatasetFactory.createFromObject(IntegerDataset.class, new int[] {5, 6, 7}, null);
		
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(new int[]{5, 6, 7, 50, 60, 70, 500, 600, 700}, null), LinearAlgebra.kroneckerProduct(a, b), true, 1e-12, 1e-12);
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(new int[]{5, 50, 500, 6, 60, 600, 7, 70, 700}, null), LinearAlgebra.kroneckerProduct(b, a), true, 1e-12, 1e-12);

		a = DatasetUtils.eye(2, 2, 0, Dataset.INT16);
		b = DatasetFactory.ones(FloatDataset.class, new int[] {2, 2});
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(new float[]{1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1}, 4, 4), LinearAlgebra.kroneckerProduct(a, b), true, 1e-12, 1e-12);
	}

	@Test
	public void testPower() {
		Dataset a = DatasetFactory.createFromObject(new int[] {0, 1, -1, 0}, 2, 2);

		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(new int[]{0, -1, 1, 0}, 2, 2), LinearAlgebra.power(a, 3), true, 1e-12, 1e-12);
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(new double[]{0, 1, -1, 0}, 2, 2), LinearAlgebra.power(a, -3), true, 1e-12, 1e-12);

		TestUtils.assertDatasetEquals(DatasetUtils.eye(4, 4, 0, Dataset.INT32), LinearAlgebra.power(DatasetFactory.zeros(IntegerDataset.class, 4, 4), 0), true, 1e-12, 1e-12);
	}

	@Test
	public void testSolve() {
		Dataset a = DatasetFactory.createFromObject(new int[] {3, 1, 1, 2}, 2, 2);
		Dataset b = DatasetFactory.createFromObject(new int[] {9, 8}, null);
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(new double[]{2, 3}), LinearAlgebra.solve(a, b), true, 1e-12, 1e-12);
	}
}
