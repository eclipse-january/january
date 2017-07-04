/*-
 * Copyright (c) 2012, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import org.eclipse.january.dataset.CompoundDataset;
import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.dataset.SingleInputBroadcastIterator;
import org.eclipse.january.dataset.Slice;
import org.junit.Assert;
import org.junit.Test;

public class SingleInputBroadcastIteratorTest {

	@Test
	public void testBroadcastWithNoOutput() {
		Dataset a, b, c;
		SingleInputBroadcastIterator it;

		a = DatasetFactory.createRange(DoubleDataset.class, 2, 8, 1);

		it = new SingleInputBroadcastIterator(a, null);
		Assert.assertArrayEquals("Broadcast shape", new int[] {6}, it.getShape());
		c = DatasetFactory.zeros(it.getShape());

		for (int j = 0; j < 6; j++) {
			Assert.assertTrue(it.hasNext());
			c.set(it.aDouble, j);
			Assert.assertEquals(a.getDouble(j), it.aDouble, 1e-15);
		}
		Assert.assertFalse(it.hasNext());

		// zero-rank dataset
		a = DatasetFactory.createFromObject(1);
		it = new SingleInputBroadcastIterator(a, null);
		it.setOutputDouble(true);
		Assert.assertArrayEquals("Broadcast shape", new int[] {}, it.getShape());
		c = DatasetFactory.zeros(it.getShape());

		Assert.assertTrue(it.hasNext());
		c.set(it.aDouble);
		Assert.assertEquals(a.getDouble(), it.aDouble, 1e-15);
		Assert.assertFalse(it.hasNext());

		// also sliced views
		a = DatasetFactory.createRange(DoubleDataset.class, 2, 8, 1);

		b = a.getSliceView(new Slice(null, null, 2));
		it = new SingleInputBroadcastIterator(b, null);
		Assert.assertArrayEquals("Broadcast shape", new int[] {3}, it.getShape());
		c = DatasetFactory.zeros(it.getShape());

		for (int j = 0; j < 3; j++) {
			Assert.assertTrue(it.hasNext());
			c.set(it.aDouble, j);
			Assert.assertEquals(b.getDouble(j), it.aDouble, 1e-15);
			Assert.assertEquals(c.getDouble(j), (2*j + 2.0), 1e-15);
		}
		Assert.assertFalse(it.hasNext());

		b = a.getSliceView(new Slice(null, null, -2));
		it = new SingleInputBroadcastIterator(b, null);
		Assert.assertArrayEquals("Broadcast shape", new int[] {3}, it.getShape());
		c = DatasetFactory.zeros(it.getShape());

		for (int j = 0; j < 3; j++) {
			Assert.assertTrue(it.hasNext());
			c.set(it.aDouble, j);
			Assert.assertEquals(b.getDouble(j), it.aDouble, 1e-15);
			Assert.assertEquals(c.getDouble(j), (-2*j + 7.0), 1e-15);
		}
		Assert.assertFalse(it.hasNext());

		a = DatasetFactory.createRange(DoubleDataset.class, 2, 14, 1).reshape(3, 4);

		b = a;
		it = new SingleInputBroadcastIterator(b, null);
		Assert.assertArrayEquals("Broadcast shape", new int[] {3, 4}, it.getShape());
		c = DatasetFactory.zeros(it.getShape());

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				Assert.assertTrue(it.hasNext());
				c.set(it.aDouble, i, j);
				Assert.assertEquals(b.getDouble(i, j), it.aDouble, 1e-15);
				Assert.assertEquals(c.getDouble(i, j), (i*4 + j + 2.0), 1e-15);
			}
		}
		Assert.assertFalse(it.hasNext());

		b = a.getSliceView(null, new Slice(null, null, 2));
		it = new SingleInputBroadcastIterator(b, null);
		Assert.assertArrayEquals("Broadcast shape", new int[] {3, 2}, it.getShape());
		c = DatasetFactory.zeros(it.getShape());

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				Assert.assertTrue(it.hasNext());
				c.set(it.aDouble, i, j);
				Assert.assertEquals(a.getDouble(i, 2*j), it.aDouble, 1e-15);
				Assert.assertEquals(c.getDouble(i, j), (i*4 + j*2 + 2.0), 1e-15);
			}
		}
		Assert.assertFalse(it.hasNext());

		b = a.getSliceView(null, new Slice(null, null, -2));
		it = new SingleInputBroadcastIterator(b, null);
		Assert.assertArrayEquals("Broadcast shape", new int[] {3, 2}, it.getShape());
		c = DatasetFactory.zeros(it.getShape());

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				Assert.assertTrue(it.hasNext());
				c.set(it.aDouble, i, j);
				Assert.assertEquals(a.getDouble(i, 3 - 2*j), it.aDouble, 1e-15);
				Assert.assertEquals(c.getDouble(i, j), (i*4 + 3.0 - 2*j + 2.0), 1e-15);
			}
		}
		Assert.assertFalse(it.hasNext());

		a = a.reshape(12).getSliceView(new Slice(null, null, -1));
		b = a.reshape(3, 4);
		it = new SingleInputBroadcastIterator(b, null);
		Assert.assertArrayEquals("Broadcast shape", new int[] {3, 4}, it.getShape());
		c = DatasetFactory.zeros(it.getShape());

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				Assert.assertTrue(it.hasNext());
				c.set(it.aDouble, i, j);
				Assert.assertEquals(b.getDouble(i, j), it.aDouble, 1e-15);
				Assert.assertEquals(c.getDouble(i, j), (8 - i*4 + 3 - j + 2.0), 1e-15);
			}
		}
		Assert.assertFalse(it.hasNext());

		b = b.getSliceView(new Slice(null, null, -1));
		it = new SingleInputBroadcastIterator(b, null);
		Assert.assertArrayEquals("Broadcast shape", new int[] {3, 4}, it.getShape());
		c = DatasetFactory.zeros(it.getShape());

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				Assert.assertTrue(it.hasNext());
				c.set(it.aDouble, i, j);
				Assert.assertEquals(b.getDouble(i, j), it.aDouble, 1e-15);
				Assert.assertEquals(c.getDouble(i, j), (i*4 + 3 - j + 2.0), 1e-15);
			}
		}
		Assert.assertFalse(it.hasNext());
	}

	@Test
	public void testBroadcastWithOutput() {
		Dataset a, c;
		SingleInputBroadcastIterator it;

		a = DatasetFactory.createFromObject(1.0);
		c = DatasetFactory.zeros(10);
		it = new SingleInputBroadcastIterator(a, c);
		Assert.assertArrayEquals("Broadcast shape", new int[] {10}, it.getShape());

		for (int i = 0; i < 10; i++) {
			Assert.assertTrue(it.hasNext());
			Assert.assertEquals(a.getDouble(), it.aDouble, 1e-15);
			c.setObjectAbs(it.oIndex, it.aDouble);
			Assert.assertEquals(c.getDouble(i), 1, 1e-15);
		}
		Assert.assertFalse(it.hasNext());

		a = DatasetFactory.createRange(10);
		c = DatasetFactory.zeros(10);
		it = new SingleInputBroadcastIterator(a, c);
		Assert.assertArrayEquals("Broadcast shape", new int[] {10}, it.getShape());

		for (int i = 0; i < 10; i++) {
			Assert.assertTrue(it.hasNext());
			Assert.assertEquals(a.getDouble(i), it.aDouble, 1e-15);
			c.setObjectAbs(it.oIndex, it.aDouble);
			Assert.assertEquals(c.getDouble(i), i, 1e-15);
		}
		Assert.assertFalse(it.hasNext());

		// same output
		a = DatasetFactory.createRange(120).reshape(10, 12);
		c = a;
		it = new SingleInputBroadcastIterator(a, c);
		Assert.assertArrayEquals("Broadcast shape", new int[] {10, 12}, it.getShape());

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 12; j++) {
				Assert.assertTrue(it.hasNext());
				Assert.assertEquals(a.getDouble(i, j), it.aDouble, 1e-15);
				c.setObjectAbs(it.oIndex, it.aDouble);
				Assert.assertEquals(c.getDouble(i, j), (i*12+j), 1e-15);
			}
		}
		Assert.assertFalse(it.hasNext());

		// sliced input/output view
		a = DatasetFactory.createRange(240).reshape(20, 12).getSliceView(new Slice(null, null, 2));
		c = a;
		it = new SingleInputBroadcastIterator(a, c);
		Assert.assertArrayEquals("Broadcast shape", new int[] {10, 12}, it.getShape());

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 12; j++) {
				Assert.assertTrue(it.hasNext());
				Assert.assertEquals(a.getDouble(i, j), it.aDouble, 1e-15);
				c.setObjectAbs(it.oIndex, it.aDouble);
				Assert.assertEquals(c.getDouble(i, j), (24*i+j), 1e-15);
			}
		}
		Assert.assertFalse(it.hasNext());

		// independent output
		a = DatasetFactory.createRange(12);
		c = DatasetFactory.zeros(10, 12);
		it = new SingleInputBroadcastIterator(a, c);
		Assert.assertArrayEquals("Broadcast shape", new int[] {10, 12}, it.getShape());

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 12; j++) {
				Assert.assertTrue(it.hasNext());
				Assert.assertEquals(a.getDouble(j), it.aDouble, 1e-15);
				c.setObjectAbs(it.oIndex, it.aDouble);
				Assert.assertEquals(c.getDouble(i, j), j, 1e-15);
			}
		}
		Assert.assertFalse(it.hasNext());

		// compound output
		CompoundDataset cc = DatasetFactory.compoundZeros(3, CompoundDoubleDataset.class, 10, 12);
		it = new SingleInputBroadcastIterator(a, cc);
		Assert.assertArrayEquals("Broadcast shape", new int[] {10, 12}, it.getShape());

		int isc = cc.getElementsPerItem();
		double[] ca = new double[isc];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 12; j++) {
				Assert.assertTrue(it.hasNext());
				Assert.assertEquals(a.getDouble(j), it.aDouble, 1e-15);
				cc.setObjectAbs(it.oIndex, it.aDouble);
				Assert.assertEquals(cc.getDouble(i, j), j, 1e-15);
				cc.getDoubleArray(ca, i, j);
				for (int k = 1; k < isc; k++) {
					Assert.assertEquals(ca[k], ca[0], 1e-15);
				}
			}
		}
		Assert.assertFalse(it.hasNext());
	}
}
