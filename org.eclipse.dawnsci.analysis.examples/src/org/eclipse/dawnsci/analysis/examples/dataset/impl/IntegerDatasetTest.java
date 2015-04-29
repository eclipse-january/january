/*
 * Copyright (c) 2012 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.examples.dataset.impl;

import static org.junit.Assert.assertEquals;

import org.eclipse.dawnsci.analysis.dataset.impl.Dataset;
import org.eclipse.dawnsci.analysis.dataset.impl.DatasetFactory;
import org.eclipse.dawnsci.analysis.dataset.impl.DoubleDataset;
import org.eclipse.dawnsci.analysis.dataset.impl.IndexIterator;
import org.eclipse.dawnsci.analysis.dataset.impl.IntegerDataset;
import org.junit.Test;

public class IntegerDatasetTest {

	@Test
	public void testConstructor() {
		int[] da = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		IntegerDataset a = new IntegerDataset(da, null);

		IndexIterator it = a.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i, a.getElementLongAbs(it.index));
		}

		IntegerDataset b = new IntegerDataset(da, 3, 4);

		it = b.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i, b.getElementLongAbs(it.index));
		}

		// test hashes
		a.hashCode();
		b.hashCode();
	}

	@Test
	public void testStats() {
		Dataset a = DatasetFactory.createRange(12, Dataset.INT32);
		assertEquals(11., a.max().doubleValue(), 1e-6);
		assertEquals(0., a.min().doubleValue(), 1e-6);
		assertEquals(5.5, ((Number) a.mean()).doubleValue(), 1e-6);
		assertEquals(3.6055512754639891, a.stdDeviation().doubleValue(), 1e-6);
		assertEquals(13., a.variance().doubleValue(), 1e-6);
	}
	
	@Test
	public void testPosition() {
		double[] da = { 0, 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1 };
		DoubleDataset a = new DoubleDataset(da);
		
		assertEquals(6,a.maxPos()[0]);
		assertEquals(0,a.minPos()[0]);
		
		Dataset b = DatasetFactory.zeros(new int[]{100,200}, Dataset.INT32 );
		
		b.set(100, new int[]{50,100});
		b.set(-100, new int[]{51,101});
		
		assertEquals(50,b.maxPos()[0]);
		assertEquals(100,b.maxPos()[1]);
		assertEquals(51,b.minPos()[0]);
		assertEquals(101,b.minPos()[1]);
		
	}

}
