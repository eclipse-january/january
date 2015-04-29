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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.complex.Complex;
import org.eclipse.dawnsci.analysis.api.dataset.Slice;
import org.eclipse.dawnsci.analysis.dataset.impl.ComplexDoubleDataset;
import org.eclipse.dawnsci.analysis.dataset.impl.Dataset;
import org.eclipse.dawnsci.analysis.dataset.impl.DatasetFactory;
import org.eclipse.dawnsci.analysis.dataset.impl.IndexIterator;
import org.eclipse.dawnsci.analysis.dataset.impl.Maths;
import org.junit.Test;

public class ComplexDoubleDatasetTest {
	@Test
	public void testConstructor() {
		double[] da = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		ComplexDoubleDataset a = new ComplexDoubleDataset(da);

		assertEquals(Dataset.COMPLEX128, a.getDtype());
		assertEquals(2, a.getElementsPerItem());
		assertEquals(16, a.getItemsize());

		IndexIterator it = a.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i*2, a.getElementDoubleAbs(it.index), 1e-5*i);
		}

		ComplexDoubleDataset b = new ComplexDoubleDataset(da, 3, 2);

		it = b.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i*2, b.getElementDoubleAbs(it.index), 1e-5*i);
		}

		ComplexDoubleDataset c = new ComplexDoubleDataset(a.getSliceView(new int[] {1}, null, new int[] {2}));
		it = c.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(4*i+2, c.getElementDoubleAbs(it.index), 1e-5 * i);
		}

		List<Complex> list = new ArrayList<Complex>();
		list.add(new Complex(0.5, 1.0));
		ComplexDoubleDataset z = ComplexDoubleDataset.createFromObject(list);
		assertEquals(0.5, z.getComplex(0).getReal(), 1e-6);
		assertEquals(1.0, z.getComplex(0).getImaginary(), 1e-6);

		Dataset aa = Maths.abs(a);
		assertEquals(Dataset.FLOAT64, aa.getDtype());
		assertEquals(1, aa.getElementsPerItem());
		assertEquals(8, aa.getItemsize());

		// test hashes
		a.hashCode();
		b.hashCode();
		c.hashCode();
		z.hashCode();
		aa.hashCode();
	}

	@Test
	public void testGetter() {
		double[] da = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		ComplexDoubleDataset a = new ComplexDoubleDataset(da);

		int l = da.length / 2;
		for (int i = 0; i < l; i++) {
			assertEquals(2*i, a.getComplex(i).getReal(), 1e-5*i);
			assertEquals(2*i + 1, a.getComplex(i).getImaginary(), 1e-5*i);
		}

		for (int i = 0; i < l; i++) {
			int r = l - 1 - i;
			assertEquals(2 * r, a.getComplex(-(i + 1)).getReal(), 1e-5 * i);
			assertEquals(2 * r + 1, a.getComplex(-(i + 1)).getImaginary(), 1e-5 * i);
		}

		ComplexDoubleDataset sv = (ComplexDoubleDataset) a.getSliceView(new Slice(1, 4));
		ComplexDoubleDataset sc = (ComplexDoubleDataset) a.getSlice(new Slice(1, 4));
		l = sc.getSize();
		for (int i = 0; i < l; i++) {
			Complex r = sc.getComplex(-(i + 1));
			Complex q = sv.getComplex(-(i + 1));
			assertEquals(r.getReal(), q.getReal(), 1e-5 * r.getReal());
			assertEquals(r.getImaginary(), q.getImaginary(), 1e-5 * r.getImaginary());
		}
	}

	@Test
	public void testStats() {
		Dataset a = DatasetFactory.createRange(12, Dataset.COMPLEX128);
		assertEquals(5.5, ((Complex) a.mean()).getReal(), 1e-6);
		assertEquals(0., ((Complex) a.mean()).getImaginary(), 1e-6);
		assertEquals(13., a.variance().doubleValue(), 1e-6);
		assertEquals(3.6055512754639891, a.stdDeviation().doubleValue(), 1e-6);

		a.iadd(new Complex(0,0.5));
		assertEquals(5.5, ((Complex) a.mean()).getReal(), 1e-6);
		assertEquals(0.5, ((Complex) a.mean()).getImaginary(), 1e-6);
//		assertEquals(13., a.var().doubleValue(), 1e-6);
//		assertEquals(3.6055512754639891, a.std().doubleValue(), 1e-6);

	}
}
