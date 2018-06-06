/*-
 * Copyright (c) 2012, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import static org.junit.Assert.*;

import org.junit.Test;

public class BroadcastIteratorTest {

	@Test
	public void testBroadcastShape() {
		Dataset a;
		a = DatasetFactory.ones();
		checkBroadcastShape(a, "scalar as scalar", new int[0], new int[0]);
		checkBroadcastShape(a, "scalar as [1]", new int[] {1}, new int[] {1}, 1);
		checkBroadcastShape(a, "scalar as [3]", new int[] {1}, new int[] {3}, 3);
		checkBroadcastShape(a, "scalar as [3,4]", new int[] {1,1}, new int[] {3,4}, 3, 4);

		a = DatasetFactory.ones(1);
		checkBroadcastShape(a, "[1] as scalar", new int[] {1}, new int[] {});
		checkBroadcastShape(a, "[1] as [1]", new int[] {1}, new int[] {1}, 1);
		checkBroadcastShape(a, "[1] as [3]", new int[] {1}, new int[] {3}, 3);
		checkBroadcastShape(a, "[1] as [3,4]", new int[] {1,1}, new int[] {3,4}, 3, 4);

		a = DatasetFactory.ones(1,1);
		checkBroadcastShape(a, "[1,1] as scalar", new int[] {1,1}, new int[] {});
		checkBroadcastShape(a, "[1,1] as [1]", new int[] {1,1}, new int[] {1,1}, 1);
		checkBroadcastShape(a, "[1,1] as [3]", new int[] {1,1}, new int[] {1,3}, 3);
		checkBroadcastShape(a, "[1,1] as [1,3]", new int[] {1,1}, new int[] {1,3}, 1, 3);
		checkBroadcastShape(a, "[1,1] as [3,4]", new int[] {1,1}, new int[] {3,4}, 3, 4);

		a = DatasetFactory.ones(3);
		checkBroadcastShape(a, "[3] as scalar", null, null);
		checkBroadcastShape(a, "[3] as [1]", new int[] {3}, new int[] {1}, 1);
		checkBroadcastShape(a, "[3] as [3]", new int[] {3}, new int[] {3}, 3);
		checkBroadcastShape(a, "[3] as [1,3]", new int[] {1,3}, new int[] {1,3}, 1, 3);
		checkBroadcastShape(a, "[3] as [3,4]", null, null, 3, 4);

		a = DatasetFactory.ones(3,1);
		checkBroadcastShape(a, "[3,1] as scalar", null, null);
		checkBroadcastShape(a, "[3,1] as [1]", new int[] {3,1}, new int[] {1,1}, 1);
		checkBroadcastShape(a, "[3,1] as [3]", new int[] {3,1}, new int[] {1,3}, 3);
		checkBroadcastShape(a, "[3,1] as [1,3]", new int[] {3,1}, new int[] {1,3}, 1, 3);
		checkBroadcastShape(a, "[3,1] as [3,4]", new int[] {3,1}, new int[] {3,4}, 3, 4);
		checkBroadcastShape(a, "[3,1] as [6,3,4]", new int[] {1,3,1}, new int[] {6,3,4}, 6, 3, 4);
		checkBroadcastShape(a, "[3,1] as [3,4,6]", null, null, 3, 4, 6);

		a = DatasetFactory.ones(1,3);
		checkBroadcastShape(a, "[1,3] as scalar", null, null);
		checkBroadcastShape(a, "[1,3] as [1]", new int[] {1,3}, new int[] {1,1}, 1);
		checkBroadcastShape(a, "[1,3] as [3]", new int[] {1,3}, new int[] {1,3}, 3);
		checkBroadcastShape(a, "[1,3] as [1,3]", new int[] {1,3}, new int[] {1,3}, 1, 3);
		checkBroadcastShape(a, "[1,3] as [3,4]", null, null, 3, 4);
		checkBroadcastShape(a, "[1,3] as [4,3]", new int[] {1,3}, new int[] {4,3}, 4,3);
		checkBroadcastShape(a, "[1,3] as [6,4,3]", new int[] {1,1,3}, new int[] {6,4,3}, 6, 4, 3);
		checkBroadcastShape(a, "[1,3] as [3,4,6]", null, null, 3, 4, 6);
	}

	private void checkBroadcastShape(Dataset a, String msg, int[] bShape, int[] cShape, int... newShape) {
		int[][] answer = bShape == null && cShape == null ? null : new int[][] { bShape, cShape };
		int[][] result = BroadcastUtils.calculateBroadcastShapes(a.getShapeRef(), a.getSize(), newShape);
		assertArrayEquals("Broadcasting " + msg, answer, result);
	}

	@Test
	public void testBroadcastWithNoOutput() {
		Dataset a, b, c;
		BroadcastIterator it;

		a = DatasetFactory.createRange(5).reshape(5, 1);
		b = DatasetFactory.createRange(2., 8, 1).reshape(1, 6);
		it = BroadcastIterator.createIterator(a, b);
		assertArrayEquals("Broadcast shape", new int[] {5, 6}, it.getShape());
		c = DatasetFactory.zeros(it.getShape());

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				assertTrue(it.hasNext());
				c.set(it.aDouble * it.bDouble, i, j);
				assertEquals(a.getDouble(i, 0), it.aDouble, 1e-15);
				assertEquals(b.getDouble(0, j), it.bDouble, 1e-15);
				assertEquals(c.getDouble(i, j), i*(j + 2.0), 1e-15);
			}
		}

		b.setShape(6);
		it = BroadcastIterator.createIterator(a, b);
		assertArrayEquals("Broadcast shape", new int[] {5, 6}, it.getShape());
		c = DatasetFactory.zeros(it.getShape());

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				assertTrue(it.hasNext());
				c.set(it.aDouble * it.bDouble, i, j);
				assertEquals(a.getDouble(i, 0), it.aDouble, 1e-15);
				assertEquals(b.getDouble(j), it.bDouble, 1e-15);
				assertEquals(c.getDouble(i, j), i*(j + 2.0), 1e-15);
			}
		}

		a = DatasetFactory.ones(ShortDataset.class, 1);
		it = BroadcastIterator.createIterator(a, b);
		assertArrayEquals("Broadcast shape", new int[] {6}, it.getShape());
		c = DatasetFactory.zeros(it.getShape());

		for (int j = 0; j < 6; j++) {
			assertTrue(it.hasNext());
			c.set(it.aDouble * it.bDouble, j);
			assertEquals(a.getDouble(0), it.aDouble, 1e-15);
			assertEquals(b.getDouble(j), it.bDouble, 1e-15);
			assertEquals(c.getDouble(j), (j + 2.0), 1e-15);
		}

		// zero-rank dataset
		a = DatasetFactory.createFromObject(1);
		it = BroadcastIterator.createIterator(a, b);
		assertArrayEquals("Broadcast shape", new int[] {6}, it.getShape());
		c = DatasetFactory.zeros(it.getShape());

		for (int j = 0; j < 6; j++) {
			assertTrue(it.hasNext());
			c.set(it.aDouble * it.bDouble, j);
			assertEquals(a.getDouble(), it.aDouble, 1e-15);
			assertEquals(b.getDouble(j), it.bDouble, 1e-15);
			assertEquals(c.getDouble(j), (j + 2.0), 1e-15);
		}

		b = DatasetFactory.createFromObject(2);
		it = BroadcastIterator.createIterator(a, b);
		it.setOutputDouble(true);
		assertArrayEquals("Broadcast shape", new int[] {}, it.getShape());
		c = DatasetFactory.zeros(it.getShape());
		assertTrue(it.hasNext());
		c.set(it.aDouble * it.bDouble);
		assertEquals(a.getDouble(), it.aDouble, 1e-15);
		assertEquals(b.getDouble(), it.bDouble, 1e-15);
		assertEquals(c.getDouble(), 2.0, 1e-15);

		// also sliced views
		a = DatasetFactory.createRange(5).reshape(5, 1);
		b = DatasetFactory.createRange(2., 8, 1).getSliceView(new Slice(null, null, 2));
		it = BroadcastIterator.createIterator(a, b);
		assertArrayEquals("Broadcast shape", new int[] {5, 3}, it.getShape());
		c = DatasetFactory.zeros(it.getShape());

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				assertTrue(it.hasNext());
				c.set(it.aDouble * it.bDouble, i, j);
				assertEquals(a.getDouble(i, 0), it.aDouble, 1e-15);
				assertEquals(b.getDouble(j), it.bDouble, 1e-15);
				assertEquals(c.getDouble(i, j), i*(2*j + 2.0), 1e-15);
			}
		}

	}

	@Test
	public void testBroadcastWithOutput() {
		Dataset a, b, c;
		BroadcastIterator it;

		a = DatasetFactory.createRange(10).reshape(10, 1);
		b = DatasetFactory.createRange(2., 14, 1).reshape(1, 12);
		c = DatasetFactory.zeros(10, 12);
		it = BroadcastIterator.createIterator(a, b, c);
		assertArrayEquals("Broadcast shape", new int[] {10, 12}, it.getShape());

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 12; j++) {
				assertTrue(it.hasNext());
				assertEquals(a.getDouble(i, 0), it.aDouble, 1e-15);
				assertEquals(b.getDouble(0, j), it.bDouble, 1e-15);
				c.setObjectAbs(it.oIndex, it.aDouble * it.bDouble);
				assertEquals(c.getDouble(i, j), i*(j + 2.0), 1e-15);
			}
		}

		// same output
		a = DatasetFactory.createRange(120).reshape(10, 12);
		b = DatasetFactory.createRange(2., 14, 1).reshape(1, 12);
		c = a;
		it = BroadcastIterator.createIterator(a, b, c);
		assertArrayEquals("Broadcast shape", new int[] {10, 12}, it.getShape());

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 12; j++) {
				assertTrue(it.hasNext());
				assertEquals(a.getDouble(i, j), it.aDouble, 1e-15);
				assertEquals(b.getDouble(0, j), it.bDouble, 1e-15);
				c.setObjectAbs(it.oIndex, it.aDouble * it.bDouble);
				assertEquals(c.getDouble(i, j), (i*12+j)*(j + 2.0), 1e-15);
			}
		}

		a = DatasetFactory.createRange(10).reshape(10, 1);
		b = DatasetFactory.createRange(2., 122, 1).reshape(10, 12);
		c = b;
		it = BroadcastIterator.createIterator(a, b, c);
		assertArrayEquals("Broadcast shape", new int[] {10, 12}, it.getShape());

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 12; j++) {
				assertTrue(it.hasNext());
				assertEquals(a.getDouble(i, 0), it.aDouble, 1e-15);
				assertEquals(b.getDouble(i, j), it.bDouble, 1e-15);
				c.setObjectAbs(it.oIndex, it.aDouble * it.bDouble);
				assertEquals(c.getDouble(i, j), i*((i*12 + j) + 2.0), 1e-15);
			}
		}

		// sliced input/output view
		a = DatasetFactory.createRange(240).reshape(20, 12).getSliceView(new Slice(null, null, 2));
		b = DatasetFactory.createRange(2., 14, 1).reshape(1, 12);
		c = a;
		it = BroadcastIterator.createIterator(a, b, c);
		assertArrayEquals("Broadcast shape", new int[] {10, 12}, it.getShape());

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 12; j++) {
				assertTrue(it.hasNext());
				assertEquals(a.getDouble(i, j), it.aDouble, 1e-15);
				assertEquals(b.getDouble(0, j), it.bDouble, 1e-15);
				c.setObjectAbs(it.oIndex, it.aDouble * it.bDouble);
				assertEquals(c.getDouble(i, j), (24*i+j)*(j + 2.0), 1e-15);
			}
		}

		// independent output
		a = DatasetFactory.createRange(12);
		b = DatasetFactory.createRange(2., 14, 1);
		c = DatasetFactory.zeros(10, 12);
		it = BroadcastIterator.createIterator(a, b, c);
		assertArrayEquals("Broadcast shape", new int[] {10, 12}, it.getShape());

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 12; j++) {
				assertTrue(it.hasNext());
				assertEquals(a.getDouble(j), it.aDouble, 1e-15);
				assertEquals(b.getDouble(j), it.bDouble, 1e-15);
				c.setObjectAbs(it.oIndex, it.aDouble * it.bDouble);
				assertEquals(c.getDouble(i, j), j*(j + 2.0), 1e-15);
			}
		}

		// compound output
		c = DatasetFactory.zeros(3, CompoundDoubleDataset.class, 10, 12);
		it = BroadcastIterator.createIterator(a, b, c);
		assertArrayEquals("Broadcast shape", new int[] {10, 12}, it.getShape());

		CompoundDataset cc = (CompoundDataset) c;
		int isc = c.getElementsPerItem();
		double[] ca = new double[isc];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 12; j++) {
				assertTrue(it.hasNext());
				assertEquals(a.getDouble(j), it.aDouble, 1e-15);
				assertEquals(b.getDouble(j), it.bDouble, 1e-15);
				c.setObjectAbs(it.oIndex, it.aDouble * it.bDouble);
				assertEquals(c.getDouble(i, j), j*(j + 2.0), 1e-15);
				cc.getDoubleArray(ca, i, j);
				for (int k = 1; k < isc; k++) {
					assertEquals(ca[k], ca[0], 1e-15);
				}
			}
		}
	}

	@Test
	public void testPair() {
		Dataset a = DatasetFactory.zeros(5, 3);
		Dataset b = DatasetFactory.createRange(1, 31., 2.);

		Dataset bv = b.getSliceView(new Slice(3, 8));

		// triggers #321
		BroadcastIterator bit;
		bit = BroadcastIterator.createIterator(a, bv.reshape(5, 1));

		while (bit.hasNext()) {
			assertEquals(a.getElementDoubleAbs(bit.aIndex), bit.aDouble, 1e-9);
			assertEquals(bv.getElementDoubleAbs(bit.bIndex), bit.bDouble, 1e-9);
		}
	}
}
