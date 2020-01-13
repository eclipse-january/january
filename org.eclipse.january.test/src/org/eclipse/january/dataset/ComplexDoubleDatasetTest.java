/*-
 * Copyright (c) 2012, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.complex.Complex;
import org.eclipse.january.asserts.TestUtils;
import org.junit.Test;

public class ComplexDoubleDatasetTest {
	@Test
	public void testConstructor() {
		assertEquals(0, new ComplexDoubleDataset().getSize());
		assertEquals(0, DatasetFactory.createFromObject(new Complex(1, 1)).getRank());

		double[] da = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		ComplexDoubleDataset a = new ComplexDoubleDataset(da);

		assertTrue("Interface", ComplexDoubleDataset.class.isAssignableFrom(a.getClass()));
		assertEquals(2, a.getElementsPerItem());
		assertEquals(16, a.getItemBytes());

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
		assertTrue("Interface", DoubleDataset.class.isAssignableFrom(aa.getClass()));
		assertEquals(1, aa.getElementsPerItem());
		assertEquals(8, aa.getItemBytes());

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
		Dataset a = DatasetFactory.createRange(ComplexDoubleDataset.class, 12);
		assertEquals(5.5, ((Complex) a.mean()).getReal(), 1e-6);
		assertEquals(0., ((Complex) a.mean()).getImaginary(), 1e-6);
		assertEquals(13., a.variance(), 1e-6);
		assertEquals(3.6055512754639891, a.stdDeviation(), 1e-6);

		a.iadd(new Complex(0,0.5));
		assertEquals(5.5, ((Complex) a.mean()).getReal(), 1e-6);
		assertEquals(0.5, ((Complex) a.mean()).getImaginary(), 1e-6);
		assertEquals(13., a.variance(), 1e-6);
		assertEquals(3.6055512754639891, a.stdDeviation(), 1e-6);
	}

	static class ComplexDoubleDataset2 extends ComplexDoubleDataset {
		private static final long serialVersionUID = 1L;

		public ComplexDoubleDataset2(final ComplexDoubleDataset dataset) {
			super(dataset);
		}
	}

	@Test
	public void testSubclassing() {
		double[] da = { 0, 0.5, 1, 1.5, 2, 2.5, 3, 3.5, 4, 4.5, 5, 5.5,
				6, 6.5, 7, 7.5, 8, 8.5, 9, 9.5, 10, 10.5, 11, 11.5 };
		ComplexDoubleDataset a = new ComplexDoubleDataset(da);

		ComplexDoubleDataset2 b = new ComplexDoubleDataset2(a);
		TestUtils.assertDatasetEquals(a, b);
	}
}
