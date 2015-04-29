/*
 * Copyright (c) 2012 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.examples.dataset.impl;

import org.eclipse.dawnsci.analysis.api.dataset.Slice;
import org.eclipse.dawnsci.analysis.dataset.impl.CompoundDataset;
import org.eclipse.dawnsci.analysis.dataset.impl.Dataset;
import org.eclipse.dawnsci.analysis.dataset.impl.DatasetFactory;
import org.eclipse.dawnsci.analysis.dataset.impl.SingleInputBroadcastIterator;
import org.junit.Assert;
import org.junit.Test;

public class SingleInputBroadcastIteratorTest {

	@Test
	public void testBroadcastWithNoOutput() {
		Dataset a, b, c;
		SingleInputBroadcastIterator it;

		a = DatasetFactory.createRange(5, Dataset.FLOAT64).reshape(5, 1);
		b = DatasetFactory.createRange(2, 8, 1, Dataset.FLOAT64);
		it = new SingleInputBroadcastIterator(b, null);
		Assert.assertArrayEquals("Broadcast shape", new int[] {6}, it.getShape());
		c = DatasetFactory.zeros(it.getShape(), Dataset.FLOAT64);

		for (int j = 0; j < 6; j++) {
			Assert.assertTrue(it.hasNext());
			c.set(it.aDouble, j);
			Assert.assertEquals(b.getDouble(j), it.aDouble, 1e-15);
		}

		// zero-rank dataset
		a = DatasetFactory.createFromObject(1);
		it = new SingleInputBroadcastIterator(a, null);
		it.setOutputDouble(true);
		Assert.assertArrayEquals("Broadcast shape", new int[] {}, it.getShape());
		c = DatasetFactory.zeros(it.getShape(), Dataset.FLOAT64);

		Assert.assertTrue(it.hasNext());
		c.set(it.aDouble);
		Assert.assertEquals(a.getDouble(), it.aDouble, 1e-15);

		// also sliced views
		a = DatasetFactory.createRange(5, Dataset.FLOAT64).reshape(5, 1);
		b = DatasetFactory.createRange(2, 8, 1, Dataset.FLOAT64).getSliceView(new Slice(null, null, 2));
		it = new SingleInputBroadcastIterator(b, null);
		Assert.assertArrayEquals("Broadcast shape", new int[] {3}, it.getShape());
		c = DatasetFactory.zeros(it.getShape(), Dataset.FLOAT64);

		for (int j = 0; j < 3; j++) {
			Assert.assertTrue(it.hasNext());
			c.set(it.aDouble, j);
			Assert.assertEquals(b.getDouble(j), it.aDouble, 1e-15);
			Assert.assertEquals(c.getDouble(j), (2*j + 2.0), 1e-15);
		}
	}

	@Test
	public void testBroadcastWithOutput() {
		Dataset a, c;
		SingleInputBroadcastIterator it;

		a = DatasetFactory.createRange(10, Dataset.FLOAT64);
		c = DatasetFactory.zeros(new int[] {10}, Dataset.FLOAT64);
		it = new SingleInputBroadcastIterator(a, c);
		Assert.assertArrayEquals("Broadcast shape", new int[] {10}, it.getShape());

		for (int i = 0; i < 10; i++) {
			Assert.assertTrue(it.hasNext());
			Assert.assertEquals(a.getDouble(i), it.aDouble, 1e-15);
			c.setObjectAbs(it.oIndex, it.aDouble);
			Assert.assertEquals(c.getDouble(i), i, 1e-15);
		}

		// same output
		a = DatasetFactory.createRange(120, Dataset.FLOAT64).reshape(10, 12);
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


		// sliced input/output view
		a = DatasetFactory.createRange(240, Dataset.FLOAT64).reshape(20, 12).getSliceView(new Slice(null, null, 2));
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

		// independent output
		a = DatasetFactory.createRange(12, Dataset.FLOAT64);
		c = DatasetFactory.zeros(new int[] {10, 12}, Dataset.FLOAT64);
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

		// compound output
		c = DatasetFactory.zeros(3, new int[] {10, 12}, Dataset.FLOAT64);
		it = new SingleInputBroadcastIterator(a, c);
		Assert.assertArrayEquals("Broadcast shape", new int[] {10, 12}, it.getShape());

		CompoundDataset cc = (CompoundDataset) c;
		int isc = c.getElementsPerItem();
		double[] ca = new double[isc];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 12; j++) {
				Assert.assertTrue(it.hasNext());
				Assert.assertEquals(a.getDouble(j), it.aDouble, 1e-15);
				c.setObjectAbs(it.oIndex, it.aDouble);
				Assert.assertEquals(c.getDouble(i, j), j, 1e-15);
				cc.getDoubleArray(ca, i, j);
				for (int k = 1; k < isc; k++) {
					Assert.assertEquals(ca[k], ca[0], 1e-15);
				}
			}
		}
	}
}
