/*-
 * Copyright (c) 2012 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.dataset;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.math3.complex.Complex;
import org.eclipse.dawnsci.analysis.api.dataset.IDataset;
import org.eclipse.dawnsci.analysis.api.dataset.Slice;
import org.eclipse.dawnsci.analysis.asserts.TestUtils;
import org.eclipse.dawnsci.analysis.dataset.impl.AbstractDataset;
import org.eclipse.dawnsci.analysis.dataset.impl.BooleanDataset;
import org.eclipse.dawnsci.analysis.dataset.impl.Comparisons;
import org.eclipse.dawnsci.analysis.dataset.impl.ComplexDoubleDataset;
import org.eclipse.dawnsci.analysis.dataset.impl.CompoundDataset;
import org.eclipse.dawnsci.analysis.dataset.impl.Dataset;
import org.eclipse.dawnsci.analysis.dataset.impl.DatasetFactory;
import org.eclipse.dawnsci.analysis.dataset.impl.DatasetUtils;
import org.eclipse.dawnsci.analysis.dataset.impl.DoubleDataset;
import org.eclipse.dawnsci.analysis.dataset.impl.IndexIterator;
import org.eclipse.dawnsci.analysis.dataset.impl.IntegerDataset;
import org.eclipse.dawnsci.analysis.dataset.impl.LongDataset;
import org.eclipse.dawnsci.analysis.dataset.impl.Maths;
import org.eclipse.dawnsci.analysis.dataset.impl.ObjectDataset;
import org.eclipse.dawnsci.analysis.dataset.impl.Random;
import org.eclipse.dawnsci.analysis.dataset.impl.StringDataset;
import org.junit.Assert;
import org.junit.Test;

public class AbstractDatasetTest {
	@Test
	public void testBestDType() {
		assertEquals(Dataset.FLOAT32, AbstractDataset.getBestDType(Dataset.INT16, Dataset.FLOAT32));
		assertEquals(Dataset.FLOAT64, AbstractDataset.getBestDType(Dataset.INT32, Dataset.FLOAT32));
		assertEquals(Dataset.COMPLEX64, AbstractDataset.getBestDType(Dataset.FLOAT32, Dataset.COMPLEX64));
		assertEquals(Dataset.COMPLEX128, AbstractDataset.getBestDType(Dataset.INT32, Dataset.COMPLEX64));
	}

	@Test
	public void testCompatibleShapes() {
		assertTrue("[] and []", AbstractDataset.areShapesCompatible(new int[] {}, new int[] {}));
		assertTrue("[1] and []", AbstractDataset.areShapesCompatible(new int[] {1}, new int[] {}));
		assertFalse("[2] and []", AbstractDataset.areShapesCompatible(new int[] {2}, new int[] {}));
		assertTrue("[2] and [2]", AbstractDataset.areShapesCompatible(new int[] {2}, new int[] {2}));
		assertTrue("[3] and [3]", AbstractDataset.areShapesCompatible(new int[] {3}, new int[] {3}));
		assertTrue("[1,2] and [2]", AbstractDataset.areShapesCompatible(new int[] {1,2}, new int[] {2}));
		assertTrue("[2] and [1,2]", AbstractDataset.areShapesCompatible(new int[] {2}, new int[] {1,2}));
		assertFalse("[10,10] and [10,10,10]", AbstractDataset.areShapesCompatible(new int[] {10,10}, new int[] {10,10,10}));
		assertFalse("[10,10,10] and [10,10]", AbstractDataset.areShapesCompatible(new int[] {10,10,10}, new int[] {10,10}));
		assertTrue("[2] and [2,1,1,1]", AbstractDataset.areShapesCompatible(new int[] {2}, new int[] {2,1,1,1}));
		assertTrue("[2,1] and [2,1,1,1]", AbstractDataset.areShapesCompatible(new int[] {2,1}, new int[] {2,1,1,1}));
		assertFalse("[2,1] and [3,1,1,2]", AbstractDataset.areShapesCompatible(new int[] {2,1}, new int[] {3,1,1,2}));
		assertFalse("[2,1] and [3,1,1,1]", AbstractDataset.areShapesCompatible(new int[] {2,1}, new int[] {3,1,1,1}));
		assertTrue("[1,2,1] and [2,1,1,1]", AbstractDataset.areShapesCompatible(new int[] {1,2,1}, new int[] {2,1,1,1}));
		assertTrue("[1,2,1,3] and [2,1,1,1,3]", AbstractDataset.areShapesCompatible(new int[] {1,2,1,3}, new int[] {2,1,1,1,3}));
		assertTrue("[2,1,1] and [1,1,2]", AbstractDataset.areShapesCompatible(new int[] {2,1,1}, new int[] {1,1,2}));
		assertFalse("[2,1,1] and [1,1,3]", AbstractDataset.areShapesCompatible(new int[] {2,1,1}, new int[] {1,1,3}));
		assertFalse("[2,1,4] and [2,1,1,3]", AbstractDataset.areShapesCompatible(new int[] {2,1,4}, new int[] {2,1,1,3}));
		assertFalse("[2,1,4] and [2,1,3]", AbstractDataset.areShapesCompatible(new int[] {2,1,4}, new int[] {2,1,3}));
		assertFalse("[2,4] and [2,3]", AbstractDataset.areShapesCompatible(new int[] {2,4}, new int[] {2,3}));
		assertTrue("[2,1,4] and [2,1,4]", AbstractDataset.areShapesCompatible(new int[] {2,1,4}, new int[] {2,1,4}));
		assertTrue("[2,1,4] and [2,1,1,4]", AbstractDataset.areShapesCompatible(new int[] {2,1,4}, new int[] {2,1,1,4}));
		assertFalse("[2,4] and [2,4,3]", AbstractDataset.areShapesCompatible(new int[] {2,4}, new int[] {2,4,3}));
		assertFalse("[2,1,4] and [2,4,3]", AbstractDataset.areShapesCompatible(new int[] {2,1,4}, new int[] {2,4,3}));
		assertTrue(AbstractDataset.areShapesCompatible(new int[] {}, new int[] {}, 0));
		assertTrue(AbstractDataset.areShapesCompatible(new int[] {2}, new int[] {3}, 0));
		assertFalse(AbstractDataset.areShapesCompatible(new int[] {2,4}, new int[] {3,4}, 1));
		assertTrue(AbstractDataset.areShapesCompatible(new int[] {2,4}, new int[] {3,4}, 0));
//		assertTrue(AbstractDataset.areShapesCompatible(new int[] {}, new int[] {}));
	}

	@Test
	public void testBroadcastCompatibleShapes() {
		assertTrue("[] and []", AbstractDataset.areShapesBroadcastCompatible(new int[] {}, new int[] {}));
		assertTrue("[1] and []", AbstractDataset.areShapesBroadcastCompatible(new int[] {1}, new int[] {}));
		assertTrue("[2] and []", AbstractDataset.areShapesBroadcastCompatible(new int[] {2}, new int[] {}));
		assertTrue("[2] and [2]", AbstractDataset.areShapesBroadcastCompatible(new int[] {2}, new int[] {2}));
		assertTrue("[3] and [3]", AbstractDataset.areShapesBroadcastCompatible(new int[] {3}, new int[] {3}));
		assertTrue("[1,2] and [2]", AbstractDataset.areShapesBroadcastCompatible(new int[] {1,2}, new int[] {2}));
		assertTrue("[2] and [1,2]", AbstractDataset.areShapesBroadcastCompatible(new int[] {2}, new int[] {1,2}));
		assertTrue("[4,2] and [1,2]", AbstractDataset.areShapesBroadcastCompatible(new int[] {4,2}, new int[] {1,2}));
		assertTrue("[10,10] and [10,10,10]", AbstractDataset.areShapesBroadcastCompatible(new int[] {10,10}, new int[] {10,10,10}));
		assertTrue("[10,10,10] and [10,10]", AbstractDataset.areShapesBroadcastCompatible(new int[] {10,10,10}, new int[] {10,10}));

		
		assertTrue("[2] and [2,1,1,1]", AbstractDataset.areShapesBroadcastCompatible(new int[] {2}, new int[] {2,1,1,1}));
		assertTrue("[2,1] and [2,1,1,1]", AbstractDataset.areShapesBroadcastCompatible(new int[] {2,1}, new int[] {2,1,1,1}));
		assertTrue("[2,1] and [3,1,1,2]", AbstractDataset.areShapesBroadcastCompatible(new int[] {2,1}, new int[] {3,1,1,2}));
		assertTrue("[2,1] and [3,1,1,1]", AbstractDataset.areShapesBroadcastCompatible(new int[] {2,1}, new int[] {3,1,1,1}));
		assertTrue("[1,2,1] and [2,1,1,1]", AbstractDataset.areShapesBroadcastCompatible(new int[] {1,2,1}, new int[] {2,1,1,1}));
		assertTrue("[1,2,1,3] and [2,1,1,1,3]", AbstractDataset.areShapesBroadcastCompatible(new int[] {1,2,1,3}, new int[] {2,1,1,1,3}));
		assertTrue("[2,1,1] and [1,1,2]", AbstractDataset.areShapesBroadcastCompatible(new int[] {2,1,1}, new int[] {1,1,2}));
		assertTrue("[2,1,1] and [1,1,3]", AbstractDataset.areShapesBroadcastCompatible(new int[] {2,1,1}, new int[] {1,1,3}));
		assertFalse("[2,1,4] and [2,1,1,3]", AbstractDataset.areShapesBroadcastCompatible(new int[] {2,1,4}, new int[] {2,1,1,3}));
		assertFalse("[2,1,4] and [2,1,3]", AbstractDataset.areShapesBroadcastCompatible(new int[] {2,1,4}, new int[] {2,1,3}));
		assertFalse("[2,4] and [2,3]", AbstractDataset.areShapesBroadcastCompatible(new int[] {2,4}, new int[] {2,3}));
		assertTrue("[2,1,4] and [2,1,4]", AbstractDataset.areShapesBroadcastCompatible(new int[] {2,1,4}, new int[] {2,1,4}));
		assertTrue("[2,1,4] and [2,1,1,4]", AbstractDataset.areShapesBroadcastCompatible(new int[] {2,1,4}, new int[] {2,1,1,4}));
		assertFalse("[2,4] and [2,4,3]", AbstractDataset.areShapesBroadcastCompatible(new int[] {2,4}, new int[] {2,4,3}));
		assertFalse("[2,1,4] and [2,4,3]", AbstractDataset.areShapesBroadcastCompatible(new int[] {2,1,4}, new int[] {2,4,3}));
	}

	@Test
	public void testMaxMin() {
		Dataset a = DatasetFactory.createRange(12, Dataset.FLOAT64);
		a.setShape(3,4);
		assertEquals("Max", 11, a.max().doubleValue(), 1e-6);
		assertEquals("Max 0", DatasetFactory.createFromObject(new double[] {8,9,10,11}), a.max(0));
		assertEquals("Max 1", DatasetFactory.createFromObject(new double[] {3,7,11}), a.max(1));
		assertEquals("Max arg", 11, a.argMax());
		assertEquals("Max arg 0 ", DatasetFactory.createFromObject(new int[] {2,2,2,2}), a.argMax(0));
		assertEquals("Max arg 1 ", DatasetFactory.createFromObject(new int[] {3,3,3}), a.argMax(1));
		a.set(Double.NaN, 1, 0);
		System.out.println(a.toString(true));
		assertTrue("Max", Double.isNaN(a.max().doubleValue()));
		assertTrue("Max", !Double.isNaN(a.max(true).doubleValue()));
		assertTrue("Max 0", equalsWithNaNs(DatasetFactory.createFromObject(new double[] {Double.NaN,9,10,11}), a.max(0)));
		assertTrue("Max 1", equalsWithNaNs(DatasetFactory.createFromObject(new double[] {3,Double.NaN,11}), a.max(1)));
		assertEquals("Max arg", 4, a.argMax());
		assertEquals("Max arg 0 ", DatasetFactory.createFromObject(new int[] {1,2,2,2}), a.argMax(0));
		assertEquals("Max arg 1 ", DatasetFactory.createFromObject(new int[] {3,0,3}), a.argMax(1));
		assertEquals("Max", 11, a.max(true).doubleValue(), 1e-6);
		assertEquals("Max 0", DatasetFactory.createFromObject(new double[] {8,9,10,11}), a.max(true,0));
		assertEquals("Max 1", DatasetFactory.createFromObject(new double[] {3,7,11}), a.max(true,1));
		assertEquals("Max arg", 11, a.argMax(true));
		assertEquals("Max arg 0 ", DatasetFactory.createFromObject(new int[] {2,2,2,2}), a.argMax(true, 0));
		assertEquals("Max arg 1 ", DatasetFactory.createFromObject(new int[] {3,3,3}), a.argMax(true, 1));

		a.set(Double.NEGATIVE_INFINITY, 1, 1);
		System.out.println(a.toString(true));
		assertTrue("Max", Double.isNaN(a.max().doubleValue()));
		assertTrue("Max", !Double.isNaN(a.max(true).doubleValue()));
		assertTrue("Max", Double.isNaN(a.max(false, true).doubleValue()));
		assertTrue("Max", !Double.isNaN(a.max(true, false).doubleValue()));
		assertEquals("Max", 11, a.max(true).doubleValue(), 1e-6);
		assertTrue("+Max", Double.isNaN(a.positiveMax(false).doubleValue()));
		assertTrue("+Max", Double.isNaN(a.positiveMax(false, true).doubleValue()));
		assertTrue("+Max", !Double.isNaN(a.positiveMax(true, false).doubleValue()));
		assertEquals("+Max", 11, a.positiveMax(true).doubleValue(), 1e-6);
		assertTrue("Min", Double.isNaN(a.min().doubleValue()));
		assertTrue("Min", !Double.isNaN(a.min(true).doubleValue()));
		assertTrue("Min", Double.isNaN(a.min(false, true).doubleValue()));
		assertTrue("Min", !Double.isNaN(a.min(true, false).doubleValue()));
		assertTrue("Min", !Double.isInfinite(a.min().doubleValue()));
		assertTrue("Min", !Double.isInfinite(a.min(true).doubleValue()));
		assertTrue("Min", !Double.isInfinite(a.min(false, true).doubleValue()));
		assertTrue("Min", Double.isInfinite(a.min(true, false).doubleValue()));
		assertEquals("Min", 0, a.min(true).doubleValue(), 1e-6);
		assertTrue("+Min", !Double.isNaN(a.positiveMin(true).doubleValue()));
		assertTrue("+Min", Double.isNaN(a.positiveMin(false).doubleValue()));
		assertTrue("+Min", Double.isNaN(a.positiveMin(false, true).doubleValue()));
		assertTrue("+Min", !Double.isNaN(a.positiveMin(true, false).doubleValue()));
		assertTrue("+Min", !Double.isInfinite(a.positiveMin(true).doubleValue()));
		assertTrue("+Min", !Double.isInfinite(a.positiveMin(false).doubleValue()));
		assertTrue("+Min", !Double.isInfinite(a.positiveMin(true, false).doubleValue()));
		assertTrue("+Min", !Double.isInfinite(a.positiveMin(false, true).doubleValue()));
		assertEquals("+Min", 1, a.positiveMin(true).doubleValue(), 1e-6);

		// test other code path
		Dataset b = DatasetFactory.createRange(12, Dataset.FLOAT64);
		b.setShape(3,4);
		b.mean(); // trigger summary stats calculation
		assertEquals("Max", 11, b.max().doubleValue(), 1e-6);
		assertEquals("Max arg", 11, b.argMax());
		b.set(Double.NaN, 1, 0);
		b.mean(); // trigger summary stats calculation
		assertTrue("Max", Double.isNaN(b.max().doubleValue()));
		assertEquals("Max arg", 4, b.argMax());
		b.mean(true);
		assertEquals("Max", 11, b.max(true).doubleValue(), 1e-6);
		assertEquals("Max arg", 11, b.argMax(true));

		// check strided datasets give same max/min positions
		a = DatasetFactory.createRange(12, Dataset.FLOAT64).reshape(3,4);
		b = a.getSliceView(new Slice(1, null), new Slice(0, null, 2));
		Dataset c = a.getSlice(new Slice(1, null), new Slice(0, null, 2));

		Assert.assertEquals(c.argMax(), b.argMax());
		Assert.assertEquals(c.argMin(), b.argMin());
	}

	@Test
	public void testGetSpeed() {
		final int ITERATIONS = 1000;
		Dataset a = DatasetFactory.createRange(1000000, Dataset.FLOAT64);
		long start, startN, startP;

		start = -System.nanoTime();
		for (int i = 0; i < 10; i++) {
			a.getDouble(i);
		}
		start += System.nanoTime();

		start = -System.nanoTime();
		for (int i = 0; i < ITERATIONS; i++) {
			a.getDouble(i);
		}
		start += System.nanoTime();

		startN = -System.nanoTime();
		for (int i = 0; i < ITERATIONS; i++) {
			a.getDouble(new int[] {i});
		}
		startN += System.nanoTime();

		startP = -System.nanoTime();
		int[] pos = new int[1];
		for (int i = 0; i < ITERATIONS; i++) {
			pos[0] = i;
			a.getDouble(pos);
		}
		startP += System.nanoTime();

		System.out.printf("Get 1D double took %gus (cf %gus and %gus)\n", start*1e-3/ITERATIONS, startN*1e-3/ITERATIONS, startP*1e-3/ITERATIONS);

		a.setShape(1000, 1000);
		start = -System.nanoTime();
		for (int i = 0; i < 10; i++) {
			a.getDouble(i, i);
		}
		start += System.nanoTime();

		start = -System.nanoTime();
		for (int i = 0; i < ITERATIONS; i++) {
			a.getDouble(i, i);
		}
		start += System.nanoTime();

		startN = -System.nanoTime();
		for (int i = 0; i < ITERATIONS; i++) {
			a.getDouble(new int[] {i, i});
		}
		startN += System.nanoTime();

		startP = -System.nanoTime();
		pos = new int[2];
		for (int i = 0; i < ITERATIONS; i++) {
			pos[0] = i;
			pos[1] = i;
			a.getDouble(pos);
		}
		startP += System.nanoTime();

		System.out.printf("Get 2D double took %gus (cf %gus and %gus)\n", start*1e-3/ITERATIONS, startN*1e-3/ITERATIONS, startP*1e-3/ITERATIONS);
	}

	@Test
	public void testHash() {
		Dataset a = DatasetFactory.createRange(12, Dataset.FLOAT64);
		a.setShape(3,4);
		Dataset b = DatasetFactory.createRange(12, Dataset.FLOAT64);
		b.setShape(3,4);

		b.mean(); // trigger other code path
		assertEquals("Hash code", a.hashCode(), b.hashCode());

		a.set(Double.POSITIVE_INFINITY, 1, 0);
		b.set(Double.POSITIVE_INFINITY, 1, 0);
		b.mean(); // trigger other code path
		assertEquals("Hash code", a.hashCode(), b.hashCode());

		a.set(Double.NaN, 0, 1);
		b.set(Double.NaN, 0, 1);
		b.mean(); // trigger other code path
		assertEquals("Hash code", a.hashCode(), b.hashCode());
	}

	private static boolean equalsWithNaNs(Dataset a, Dataset b) {
		if (a.equals(b))
			return true;

		IndexIterator ita = a.getIterator();
		IndexIterator itb = b.getIterator();
		while (ita.hasNext() && itb.hasNext()) {
			final double av = a.getElementDoubleAbs(ita.index);
			final double bv = b.getElementDoubleAbs(itb.index);
			if (Double.isNaN(av)) {
				if (!Double.isNaN(bv))
					return false;
			} else {
				if (av != bv)
					return false;
			}
		}
		return true;
	}

	@Test
	public void testMaxSpeed() {
		long start;
		long elapsed;
		final int ITERATIONS = 200;

		Dataset a = DatasetFactory.createRange(1000000, Dataset.FLOAT64);
		for (int i = 0; i < 10; i++) {
			a.set(1, 0);
			start = -System.nanoTime();
			a.max();
			start += System.nanoTime();
		}
		elapsed = 0;
		for (int i = 0; i < ITERATIONS; i++) {
			a.set(1, 0);
			start = -System.nanoTime();
			a.max();
			start += System.nanoTime();

			elapsed += start;
		}
		System.out.printf("Max double calculation took %g ms\n", elapsed*1e-6/ITERATIONS);

		a = DatasetFactory.createRange(1000000, Dataset.INT16);
		elapsed = 0;
		for (int i = 0; i < ITERATIONS; i++) {
			a.set(1, 0);
			start = -System.nanoTime();
			a.max();
			start += System.nanoTime();

			elapsed += start;
		}
		System.out.printf("Max short calculation took %g ms\n", elapsed*1e-6/ITERATIONS);
	}

	@Test
	public void testSort() {
		Dataset a = DatasetFactory.createRange(12, Dataset.FLOAT64);
		a.set(Double.NaN, 0);
		a.setShape(3, 4);
		a.sort(-1);
		TestUtils.verbosePrintf("%s\n", a.toString());
		assertEquals("First element", 1, a.getDouble(0,0), 1e-6);
		assertTrue("0,3 element", Double.isNaN(a.getDouble(0,3)));
		assertEquals("Final element", 11, a.getDouble(2,3), 1e-6);

		a.sort(0);
		TestUtils.verbosePrintf("%s\n", a.toString());
		assertEquals("First element", 1, a.getDouble(0,0), 1e-6);
		assertEquals("0,3 element", 7, a.getDouble(0,3), 1e-6);
		assertTrue("Final element", Double.isNaN(a.getDouble(2,3)));

		a.set(12, 0);
		a.sort(null);
		TestUtils.verbosePrintf("%s\n", a.toString());
		assertEquals("First element", 2, a.getDouble(0), 1e-6);
		assertEquals("2,2 element", 12, a.getDouble(2,2), 1e-6);
		assertTrue("Final element", Double.isNaN(a.getDouble(2,3)));
	}

	@Test
	public void testPut() {
		Dataset d1 = DatasetFactory.createRange(6, Dataset.FLOAT64);
		
		DatasetUtils.put(d1, new int[] {2, 5}, DatasetFactory.createFromObject(new double[] {-2, -5.5}));
		checkDatasets(d1, DatasetFactory.createFromObject(new double[] {0, 1, -2, 3, 4, -5.5}));
	
		DatasetUtils.put(d1, DatasetFactory.createFromObject(new int[] {0, 4}), DatasetFactory.createFromObject(new double[] {-2, -5.5}));
		checkDatasets(d1, DatasetFactory.createFromObject(new double[] {-2, 1, -2, 3, -5.5, -5.5}));
	
		d1 = DatasetFactory.createRange(6, Dataset.FLOAT64).reshape(2, 3);
		DatasetUtils.put(d1, new int[] {2, 5}, DatasetFactory.createFromObject(new double[] {-2, -5.5}));
		checkDatasets(d1, DatasetFactory.createFromObject(new double[] {0, 1, -2, 3, 4, -5.5}).reshape(2, 3));
	
		DatasetUtils.put(d1, DatasetFactory.createFromObject(new int[] {0, 4}), DatasetFactory.createFromObject(new double[] {-2, -5.5}));
		checkDatasets(d1, DatasetFactory.createFromObject(new double[] {-2, 1, -2, 3, -5.5, -5.5}).reshape(2, 3));
	}

	@Test
	public void testTake() {
		Dataset a = DatasetFactory.createRange(12, Dataset.FLOAT64);
		Dataset t;

		t = DatasetUtils.take(a, new int[] {0, 2, 4}, null);
		TestUtils.verbosePrintf("%s\n", t.toString());

		t = DatasetUtils.take(a, new int[] {0, 2, 4}, 0);
		TestUtils.verbosePrintf("%s\n", t.toString());

		a.setShape(new int[] {3,4});
		TestUtils.verbosePrintf("%s\n", a.toString());

		t = DatasetUtils.take(a, new int[] {0}, 0);
		TestUtils.verbosePrintf("%s\n", t.toString());

		t = DatasetUtils.take(a, new int[] {1}, 0);
		TestUtils.verbosePrintf("%s\n", t.toString());

		t = DatasetUtils.take(a, new int[] {2}, 0);
		TestUtils.verbosePrintf("%s\n", t.toString());

		t = DatasetUtils.take(a, new int[] {0}, 1);
		TestUtils.verbosePrintf("%s\n", t.toString());

		t = DatasetUtils.take(a, new int[] {1}, 1);
		TestUtils.verbosePrintf("%s\n", t.toString());

		t = DatasetUtils.take(a, new int[] {2}, 1);
		TestUtils.verbosePrintf("%s\n", t.toString());

		t = DatasetUtils.take(a, new int[] {3}, 1);
		TestUtils.verbosePrintf("%s\n", t.toString());
	}

	/**
	 * Tests for squeeze method
	 */
	@Test
	public void testSqueeze() {
		Dataset ds = DatasetFactory.createRange(10, Dataset.FLOAT64);
		ds.setShape(2,1,5);

		ds.squeeze();
		assertEquals(2, ds.getShape().length);
		assertEquals(2, ds.getShape()[0]);
		assertEquals(5, ds.getShape()[1]);

		int[] os, ns;
		os = new int[] { 1, 1 };
		ns = AbstractDataset.squeezeShape(os, false);
		assertEquals(0, ns.length);
		ns = AbstractDataset.squeezeShape(os, true);
		assertEquals(0, ns.length);

		os = new int[] { 2, 1, 5 };
		ns = AbstractDataset.squeezeShape(os, false);
		assertEquals(2, ns.length);
		assertEquals(2, ns[0]);
		assertEquals(5, ns[1]);
		ns = AbstractDataset.squeezeShape(os, true);
		assertEquals(3, ns.length);
		assertEquals(2, ns[0]);
		assertEquals(1, ns[1]);
		assertEquals(5, ns[2]);

		os = new int[] { 2, 1, 5, 1 };
		ns = AbstractDataset.squeezeShape(os, false);
		assertEquals(2, ns.length);
		assertEquals(2, ns[0]);
		assertEquals(5, ns[1]);
		ns = AbstractDataset.squeezeShape(os, true);
		assertEquals(3, ns.length);
		assertEquals(2, ns[0]);
		assertEquals(1, ns[1]);
		assertEquals(5, ns[2]);

		os = new int[] { 1, 2, 1, 5 };
		ns = AbstractDataset.squeezeShape(os, false);
		assertEquals(2, ns.length);
		assertEquals(2, ns[0]);
		assertEquals(5, ns[1]);
		ns = AbstractDataset.squeezeShape(os, true);
		assertEquals(3, ns.length);
		assertEquals(2, ns[0]);
		assertEquals(1, ns[1]);
		assertEquals(5, ns[2]);

		os = new int[] { 1, 2, 1, 5, 1 };
		ns = AbstractDataset.squeezeShape(os, false);
		assertEquals(2, ns.length);
		assertEquals(2, ns[0]);
		assertEquals(5, ns[1]);
		ns = AbstractDataset.squeezeShape(os, true);
		assertEquals(3, ns.length);
		assertEquals(2, ns[0]);
		assertEquals(1, ns[1]);
		assertEquals(5, ns[2]);
	}

	/**
	 * Tests for tile method
	 */
	@Test
	public void testTile() {
		// 1D
		Dataset ds = DatasetFactory.createRange(3, Dataset.FLOAT64);

		Dataset ta = DatasetUtils.tile(ds, 2);
		double[] xa = { 0., 1., 2., 0., 1., 2. };

		assertEquals(1, ta.getShape().length);
		assertEquals(6, ta.getShape()[0]);
		for (int i = 0; i < xa.length; i++) {
			assertEquals(xa[i], ((DoubleDataset) ta).getData()[i], 1e-6);
		}

		Dataset tb = DatasetUtils.tile(ds, 1, 2);

		assertEquals(2, tb.getShape().length);
		assertEquals(1, tb.getShape()[0]);
		assertEquals(6, tb.getShape()[1]);
		for (int i = 0; i < xa.length; i++) {
			assertEquals(xa[i], ((DoubleDataset) tb).getData()[i], 1e-6);
		}

		Dataset tc = DatasetUtils.tile(ds, 2, 1);

		assertEquals(2, tc.getShape().length);
		assertEquals(2, tc.getShape()[0]);
		assertEquals(3, tc.getShape()[1]);
		for (int i = 0; i < xa.length; i++) {
			assertEquals(xa[i], ((DoubleDataset) tc).getData()[i], 1e-6);
		}

		// 2D
		ds = DatasetFactory.createRange(6, Dataset.FLOAT64);
		ds.setShape(2,3);
		Dataset td = DatasetUtils.tile(ds, 2);
		double[] xd = { 0., 1., 2., 0., 1., 2., 3., 4., 5., 3., 4., 5. };

		assertEquals(2, td.getShape().length);
		assertEquals(2, td.getShape()[0]);
		assertEquals(6, td.getShape()[1]);
		for (int i = 0; i < xd.length; i++) {
			assertEquals(xd[i], ((DoubleDataset) td).getData()[i], 1e-6);
		}

		Dataset te = DatasetUtils.tile(ds, 1, 2);

		assertEquals(2, te.getShape().length);
		assertEquals(2, te.getShape()[0]);
		assertEquals(6, te.getShape()[1]);
		for (int i = 0; i < xd.length; i++) {
			assertEquals(xd[i], ((DoubleDataset) te).getData()[i], 1e-6);
		}

		Dataset tf = DatasetUtils.tile(ds, 2, 1);
		double[] xf = { 0., 1., 2., 3., 4., 5., 0., 1., 2., 3., 4., 5. };

		assertEquals(2, tf.getShape().length);
		assertEquals(4, tf.getShape()[0]);
		assertEquals(3, tf.getShape()[1]);
		for (int i = 0; i < xf.length; i++) {
			assertEquals(xf[i], ((DoubleDataset) tf).getData()[i], 1e-6);
		}
	}

	@Test
	public void testTileSpeed() {
		int[][] blocks = {{1024,1}, {256,4}, {64,16}, {32,32}, {16,64}, {4, 256}, {1,1024}};
//		int[][] blocks = {{1024,64}, {256,64}, {64,64}, {32,64}, {16,64}, {4, 64}, {1,64}};

		int[][] shapes = { {1024, 2048}, {2048, 2048}, {2048, 1024} };

		for (int b = 0; b < blocks.length; b++) {
			for (int s = 0; s < shapes.length; s++) {
				for (int n = 0; n < 3; n++)
					runTile(blocks[b][0], blocks[b][1], shapes[s][0], shapes[s][1]);
			}
		}
	}

	private void runTile(final int srows, final int scols, final int rows, final int cols) {
		Dataset a = DatasetFactory.createRange(srows*scols, Dataset.FLOAT64).reshape(srows, scols);

		long start, end;

		TestUtils.verbosePrintf("Tile %sx%d Block %dx%d: ", rows, cols, srows, scols);

		final int nrows = rows/srows;
		final int ncols = cols/scols;

		start = System.currentTimeMillis();
		DoubleDataset b = new DoubleDataset(rows, cols);
		final double[] da = (double[]) a.getBuffer();
		final double[] db = b.getData();
		if (scols == 1) {
			for (int i = 0; i < db.length; i++) {
				db[i] = da[(i / cols) % srows];
			}
		} else if (srows == 1) {
			for (int i = 0; i < db.length; i++) {
				db[i] = da[i % scols];
			}
		} else {
			for (int i = 0; i < db.length; i++) {
				db[i] = da[((i / cols) % srows) * scols + i % scols];
			}
		}
		end = System.currentTimeMillis();
		long diff1 = end - start;
		TestUtils.verbosePrintf("array = %d ms, ", diff1);

		start = System.currentTimeMillis();
		final Dataset tiled = DatasetUtils.tile(a, nrows, ncols);
		end = System.currentTimeMillis();
		long diff2 = end - start;
		TestUtils.verbosePrintf("tile = %d ms\n", diff2);

		assertEquals(rows, tiled.getShape()[0]);
		assertEquals(cols, tiled.getShape()[1]);
		assertEquals("Datasets not equal", tiled, b);

		assertTrue("Creation of tile took more than 30x as long as array creation of same size! (It took "
				+ diff2 + ")", diff2 <= (diff1 * 30));
	}

	/**
	 * Tests for transpose method
	 */
	@Test
	public void testTranspose() {
		// 2D
		Dataset ds = DatasetFactory.createRange(6, Dataset.FLOAT64);
		ds.setShape(2,3);

		Dataset ta = DatasetUtils.transpose(ds, 1, 0);
		double[][] xa = { { 0., 1., 2. }, { 3., 4., 5. } };

		assertEquals(2, ta.getShape().length);
		assertEquals(3, ta.getShape()[0]);
		assertEquals(2, ta.getShape()[1]);
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				assertEquals(xa[i][j], ta.getDouble(j, i), 1e-6);
			}
		}
		ds.set(-2, 1, 2);
		assertEquals(-2., ds.getDouble(1, 2), 1e-6);
		assertEquals(5., ta.getDouble(2, 1), 1e-6);
		ta = ds.getTransposedView(); // test view has changed
		assertEquals(-2., ta.getDouble(2, 1), 1e-6);

		// 3D
		ds = DatasetFactory.createRange(24, Dataset.FLOAT64);
		ds.setShape(2, 3, 4);

		double[][][] xb = { {{ 0., 1., 2., 3.}, {4., 5., 6., 7.}, {8., 9., 10., 11. }},
				{{12., 13., 14., 15.}, {16., 17., 18., 19.}, {20., 21., 22., 23.}} };

		Dataset tb;

		try {
			tb = DatasetUtils.transpose(ds, 0);
		} catch (IllegalArgumentException e) {
			// this is correct.
		} catch (Exception e) {
			fail("wrong exception type passed from incorrect arguments being passed to the constructor");
		}

		try {
			tb = DatasetUtils.transpose(ds, 0, -1, 0);
		} catch (IllegalArgumentException e) {
			// this is correct.
		} catch (Exception e) {
			fail("wrong exception type passed from incorrect arguments being passed to the constructor");
		}

		try {
			tb = DatasetUtils.transpose(ds, 0, 1, 1);
		} catch (IllegalArgumentException e) {
			// this is correct.
		} catch (Exception e) {
			fail("wrong exception type passed from incorrect arguments being passed to the constructor");
		}

		tb = DatasetUtils.transpose(ds, 0, 1, 2);
		assertEquals(3, tb.getShape().length);
		assertEquals(2, tb.getShape()[0]);
		assertEquals(3, tb.getShape()[1]);
		assertEquals(4, tb.getShape()[2]);
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 4; k++) {
					assertEquals(xb[i][j][k], tb.getDouble(i, j, k), 1e-6);
				}
			}
		}

		tb = DatasetUtils.transpose(ds, 1, 0, 2);
		assertEquals(3, tb.getShape().length);
		assertEquals(3, tb.getShape()[0]);
		assertEquals(2, tb.getShape()[1]);
		assertEquals(4, tb.getShape()[2]);
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 4; k++) {
					assertEquals(xb[i][j][k], tb.getDouble(j, i, k), 1e-6);
				}
			}
		}

		tb = DatasetUtils.transpose(ds, 2, 0, 1);
		assertEquals(3, tb.getShape().length);
		assertEquals(4, tb.getShape()[0]);
		assertEquals(2, tb.getShape()[1]);
		assertEquals(3, tb.getShape()[2]);
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 4; k++) {
					assertEquals(xb[i][j][k], tb.getDouble(k, i, j), 1e-6);
				}
			}
		}
	}

	/**
	 * Tests for repeat method
	 */
	@Test
	public void testRepeat() {
		// 2D
		Dataset ds = DatasetFactory.createRange(6, Dataset.FLOAT64);
		ds.setShape(2,3);

		double[] xa = { 0., 0., 1., 1., 2., 2., 3., 3., 4., 4., 5., 5. };
		DoubleDataset ta = (DoubleDataset) DatasetUtils.repeat(ds, new int[] {2}, -1);
		assertEquals(1, ta.getShape().length);
		assertEquals(12, ta.getShape()[0]);
		for (int i = 0; i < 12; i++) {
			assertEquals(xa[i], ta.get(i), 1e-6);
		}

		double[][] xb = { { 0., 0., 1., 1., 2., 2. }, {  3., 3., 4., 4., 5., 5. }  };
		DoubleDataset tb = (DoubleDataset) DatasetUtils.repeat(ds, new int[] {2}, 1);
		assertEquals(2, tb.getShape().length);
		assertEquals(2, tb.getShape()[0]);
		assertEquals(6, tb.getShape()[1]);
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				assertEquals(xb[i][j], tb.get(i, j), 1e-6);
			}
		}

		double[][] xc = { { 0., 1., 2. }, { 0., 1., 2. }, {  3., 4., 5. }, {  3., 4., 5. }  };
		DoubleDataset tc = (DoubleDataset) DatasetUtils.repeat(ds, new int[] {2}, 0);
		assertEquals(2, tc.getShape().length);
		assertEquals(4, tc.getShape()[0]);
		assertEquals(3, tc.getShape()[1]);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				assertEquals(xc[i][j], tc.get(i, j), 1e-6);
			}
		}

		double[][] xd = { { 0., 1., 2. }, { 0., 1., 2. }, {  3., 4., 5. } };
		DoubleDataset td = (DoubleDataset) DatasetUtils.repeat(ds, new int[] {2, 1}, 0);
		assertEquals(2, td.getShape().length);
		assertEquals(3, td.getShape()[0]);
		assertEquals(3, td.getShape()[1]);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				assertEquals(xd[i][j], td.get(i, j), 1e-6);
			}
		}

		double[][] xe = { { 0., 1., 1., 2., 2., 2.}, {  3., 4., 4., 5., 5., 5. }  };
		DoubleDataset te = (DoubleDataset) DatasetUtils.repeat(ds, new int[] {1, 2, 3}, 1);
		assertEquals(2, te.getShape().length);
		assertEquals(2, te.getShape()[0]);
		assertEquals(6, te.getShape()[1]);
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				assertEquals(xe[i][j], te.get(i, j), 1e-6);
			}
		}

		double[] xf = { 0., 1., 2., 2., 5., 5., 5. };
		DoubleDataset tf = (DoubleDataset) DatasetUtils.repeat(ds, new int[] {1, 1, 2, 0, 0, 3}, -1);
		assertEquals(1, tf.getShape().length);
		assertEquals(7, tf.getShape()[0]);
		for (int i = 0; i < 7; i++) {
			assertEquals(xf[i], tf.get(i), 1e-6);
		}

		try {
			tf = (DoubleDataset) DatasetUtils.repeat(ds, new int[] {0}, 3);
		} catch (IllegalArgumentException e) {
			// this is correct.
		} catch (Exception e) {
			fail("wrong exception type passed from incorrect arguments being passed to the constructor");
		}

		try {
			tf = (DoubleDataset) DatasetUtils.repeat(ds, new int[] {2, 1}, -1);
		} catch (IllegalArgumentException e) {
			// this is correct.
		} catch (Exception e) {
			fail("wrong exception type passed from incorrect arguments being passed to the constructor");
		}

		try {
			tf = (DoubleDataset) DatasetUtils.repeat(ds, new int[] {-1}, -1);
		} catch (IllegalArgumentException e) {
			// this is correct.
		} catch (Exception e) {
			fail("wrong exception type passed from incorrect arguments being passed to the constructor");
		}
	}

	/**
	 * Tests for resize method
	 */
	@Test
	public void testResize() {
		int size = 6;
		Dataset ds = DatasetFactory.createRange(size, Dataset.FLOAT64);
		DoubleDataset tf;
		IndexIterator it;

		tf = (DoubleDataset) DatasetUtils.resize(ds, 3);
		assertArrayEquals(new int[] {3}, tf.getShape());
		it = tf.getIterator();
		while (it.hasNext()) {
			assertEquals(it.index % size, tf.getElementDoubleAbs(it.index), 1e-6);
		}

		tf = (DoubleDataset) DatasetUtils.resize(ds, 8);
		assertArrayEquals(new int[] {8}, tf.getShape());
		it = tf.getIterator();
		while (it.hasNext()) {
			assertEquals(it.index % size, tf.getElementDoubleAbs(it.index), 1e-6);
		}

		tf = (DoubleDataset) DatasetUtils.resize(ds, 3, 4);
		assertArrayEquals(new int[] {3, 4}, tf.getShape());
		it = tf.getIterator();
		while (it.hasNext()) {
			assertEquals(it.index % size, tf.getElementDoubleAbs(it.index), 1e-6);
		}

		ds.setShape(2,3);

		tf = (DoubleDataset) DatasetUtils.resize(ds, 3);
		assertArrayEquals(new int[] {3}, tf.getShape());
		it = tf.getIterator();
		while (it.hasNext()) {
			assertEquals(it.index % size, tf.getElementDoubleAbs(it.index), 1e-6);
		}

		tf = (DoubleDataset) DatasetUtils.resize(ds, 8);
		assertArrayEquals(new int[] {8}, tf.getShape());
		it = tf.getIterator();
		while (it.hasNext()) {
			assertEquals(it.index % size, tf.getElementDoubleAbs(it.index), 1e-6);
		}

		tf = (DoubleDataset) DatasetUtils.resize(ds, 3, 4);
		assertArrayEquals(new int[] {3, 4}, tf.getShape());
		it = tf.getIterator();
		while (it.hasNext()) {
			assertEquals(it.index % size, tf.getElementDoubleAbs(it.index), 1e-6);
		}
	}

	/**
	 * Test contents functions
	 */
	@Test
	public void testContents() {
		double[] x = { 0, 2., -12.3 };
		double[] y = { 2.3, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY };
		double[] z = { 1e14, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY };

		DoubleDataset ta = new DoubleDataset(x);
		assertEquals(false, ta.containsNans());
		assertEquals(false, ta.containsInfs());

		DoubleDataset tb = new DoubleDataset(y);
		assertEquals(true, tb.containsNans());
		assertEquals(true, tb.containsInfs());
		assertEquals(true, Double.isNaN(tb.min().doubleValue()));
		assertEquals(false, Double.isInfinite(tb.min().doubleValue()));
		assertEquals(true, Double.isNaN(tb.max().doubleValue()));
		assertEquals(false, Double.isInfinite(tb.max().doubleValue()));

		Dataset f = tb.cast(Dataset.FLOAT32);
		assertEquals(true, f.containsNans());
		assertEquals(true, f.containsInfs());
		assertEquals(true, Double.isNaN(f.min().doubleValue()));
		assertEquals(false, Double.isInfinite(f.min().doubleValue()));
		assertEquals(true, Double.isNaN(f.max().doubleValue()));
		assertEquals(false, Double.isInfinite(f.max().doubleValue()));

		DoubleDataset tc = new DoubleDataset(z);
		assertEquals(true, Double.isInfinite(tc.min().doubleValue()));
		assertEquals(true, Double.isInfinite(tc.max().doubleValue()));
	}
	
	@Test
	public void testView() {
		Dataset a = DatasetFactory.createRange(20, Dataset.FLOAT64);
		Dataset b = a.getView();
		assertEquals(true, a.equals(b));
	}

	/**
	 * Test equals and hashCode
	 */
	@Test
	public void testEquals() {
		Dataset a, b, c, d, e;
		a = DatasetFactory.createRange(20, Dataset.FLOAT64);
		b = DatasetFactory.createRange(20, Dataset.FLOAT64);
		c = a.clone();
		d = Maths.add(a, 0.5);
		e = DatasetFactory.createRange(20, Dataset.FLOAT32);

		assertTrue(a.equals(b));
		assertFalse(a == b);
		assertTrue(a.equals(c));
		assertFalse(a == c);
		assertFalse(a.equals(d));
		assertFalse(a.equals(e));
		HashSet<Dataset> set = new HashSet<Dataset>();
		set.add(a);
		assertTrue(set.contains(a));
		assertTrue(set.contains(b));
		assertTrue(set.contains(c));
		assertFalse(set.contains(d));
		assertFalse(set.contains(e));
		set.add(b);
		assertEquals(1, set.size());
		set.add(d);
		set.add(e);
		assertEquals(3, set.size());
		assertTrue(set.contains(d));
		assertTrue(set.contains(e));
		assertTrue(set.contains(Maths.subtract(d, 0.5)));
		assertFalse(set.contains(Maths.subtract(d, 0.5001)));
		assertTrue(set.contains(e.cast(Dataset.FLOAT64)));
		assertTrue(set.contains(b.cast(Dataset.FLOAT32)));
	}

	@Test
	public void testPrint() {
		Dataset a = DatasetFactory.createRange(1000000, Dataset.INT32);

		System.out.println(a);

		System.out.println(a.reshape(1000, 1000));

		System.out.println(a.reshape(100, 100, 100));

//		System.out.println(a.reshape(10, 10, 100, 100));

		Dataset b = DatasetFactory.createRange(12, Dataset.INT32);

		System.out.println(b);

		System.out.println(b.reshape(1,12));

		System.out.println(b.reshape(4,1,3));
	}

	@Test
	public void testSlicing() {
		Dataset a = DatasetFactory.createRange(1000, Dataset.INT32);
		Dataset s, t;
		IndexIterator is, it;

		s = a.getSlice(null, new int[] {10}, null);
		assertEquals(1, s.getShape().length);
		assertEquals(10, s.getShape()[0]);

		is = s.getIterator();
		for (int i = 0; is.hasNext(); i++) {
			assertEquals(i, s.getElementLongAbs(is.index));
		}

		t = a.getSlice(new Slice(10));
		assertEquals(1, t.getShape().length);
		assertEquals(10, t.getShape()[0]);

		it = t.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i, t.getElementLongAbs(it.index));
		}

		is = s.getIterator();
		it = t.getIterator();
		while (is.hasNext() && it.hasNext()) {
			assertEquals(s.getElementLongAbs(is.index), t.getElementLongAbs(it.index));
		}

		s = a.getSlice(new int[]{0}, new int[] {10}, null);
		assertEquals(1, s.getShape().length);
		assertEquals(10, s.getShape()[0]);

		s = a.getSlice(new int[]{-1000}, new int[] {10}, null);
		assertEquals(1, s.getShape().length);
		assertEquals(10, s.getShape()[0]);

		s = a.getSlice(new int[] {9}, null, new int[] {-1});
		assertEquals(1, s.getShape().length);
		assertEquals(10, s.getShape()[0]);

		is = s.getIterator();
		for (int i = 9; is.hasNext(); i--) {
			assertEquals(i, s.getElementLongAbs(is.index));
		}

		t = a.getSlice(new Slice(9, null, -1));
		assertEquals(1, t.getShape().length);
		assertEquals(10, t.getShape()[0]);

		it = t.getIterator();
		for (int i = 9; it.hasNext(); i--) {
			assertEquals(i, t.getElementLongAbs(it.index));
		}

		is = s.getIterator();
		it = t.getIterator();
		while (is.hasNext() && it.hasNext()) {
			assertEquals(s.getElementLongAbs(is.index), t.getElementLongAbs(it.index));
		}

		s = a.getSlice(new int[] {2}, new int[] {10}, null);
		t = a.getSlice(new Slice(2, 10));
		is = s.getIterator();
		it = t.getIterator();
		while (is.hasNext() && it.hasNext()) {
			assertEquals(s.getElementLongAbs(is.index), t.getElementLongAbs(it.index));
		}

		s = a.getSlice(new int[] {2}, new int[] {10}, new int[] {3});
		t = a.getSlice(new Slice(2, 10, 3));
		is = s.getIterator();
		it = t.getIterator();
		while (is.hasNext() && it.hasNext()) {
			assertEquals(s.getElementLongAbs(is.index), t.getElementLongAbs(it.index));
		}

		t = a.getSlice(new Slice(2000));
		assertArrayEquals(a.getShapeRef(), t.getShapeRef());

		t = a.getSlice(new Slice(12, 10, 3));
		assertArrayEquals(new int[] {0}, t.getShapeRef());

		t = a.getSlice(new Slice(2, 10, -3));
		assertArrayEquals(new int[] {0}, t.getShapeRef());

		a.setShape(10, 10, 10);

		s = a.getSlice(null, null, null);
		t = a.getSlice();
		is = s.getIterator();
		it = t.getIterator();
		while (is.hasNext() && it.hasNext()) {
			assertEquals(s.getElementLongAbs(is.index), t.getElementLongAbs(it.index));
		}

		s = a.getSlice(null, null, null);
		Slice[] slice = null;
		t = a.getSlice(slice);
		is = s.getIterator();
		it = t.getIterator();
		while (is.hasNext() && it.hasNext()) {
			assertEquals(s.getElementLongAbs(is.index), t.getElementLongAbs(it.index));
		}

		s = a.getSlice(null, new int[] {8, 10, 10}, null);
		t = a.getSlice(new Slice(8));
		is = s.getIterator();
		it = t.getIterator();
		while (is.hasNext() && it.hasNext()) {
			assertEquals(s.getElementLongAbs(is.index), t.getElementLongAbs(it.index));
		}

		s = a.getSlice(null, new int[] {8, 3, 10}, null);
		t = a.getSlice(new Slice(8), new Slice(3));
		is = s.getIterator();
		it = t.getIterator();
		while (is.hasNext() && it.hasNext()) {
			assertEquals(s.getElementLongAbs(is.index), t.getElementLongAbs(it.index));
		}

		s = a.getSlice(null, new int[] {8, 10, 3}, null);
		t = a.getSlice(new Slice(8), null, new Slice(3));
		is = s.getIterator();
		it = t.getIterator();
		while (is.hasNext() && it.hasNext()) {
			assertEquals(s.getElementLongAbs(is.index), t.getElementLongAbs(it.index));
		}
	}

	@Test
	public void testSlicingViews() {
		DoubleDataset a, b, c;
		a = (DoubleDataset) DatasetFactory.createRange(32, Dataset.FLOAT64).reshape(4, 8);
		checkSliceView(a, new int[] {0, 1}, new int[] {3, 5}, new int[] {1, 2});
		checkSliceView(a, new int[] {1, -1}, new int[] {-1, 3}, new int[] {1, -2});

		a = (DoubleDataset) DatasetFactory.createRange(60, Dataset.FLOAT64).reshape(6, 10);
		b = checkSliceView(a, new int[] {0, 1}, new int[] {6, 8}, new int[] {1, 2}); // 6x4
		c = (DoubleDataset) b.getSliceView(new int[] {0, 1}, new int[] {1, 4}, null);
		c.setShape(3);
		checkSliceView(b, new int[] {1, 0}, new int[] {5, 3}, new int[] {2, 1});
		checkSliceView(b, new int[] {1, -1}, new int[] {5, 2}, new int[] {2, -1});
		c = (DoubleDataset) a.getSlice(new int[] {0, 1}, new int[] {6, 8}, new int[] {1, 2});
		b.setShape(2,3,4);
		c.setShape(2,3,4);
		assertEquals(c, b);
		b.setShape(6,4);
		b.setShape(6,2,2);
		c.setShape(6,2,2);
		assertEquals(c, b);
		b.setShape(6,4);
		try {
			b.setShape(2,12);
			fail("Should have raised an exception");
		} catch (IllegalArgumentException iae) {
			// expected
		} catch (Exception e) {
			fail("Unexpected exception: " + e);
		}

		b = checkSliceView(a, new int[] {1, -1}, new int[] {-1, 2}, new int[] {1, -2}); // 4x4
		checkSliceView(b, new int[] {1, 0}, new int[] {4, 3}, new int[] {2, 1});
		checkSliceView(b, new int[] {1, -1}, new int[] {4, 2}, new int[] {2, -1});

		b = checkSliceView(a, new int[] {0, 1}, new int[] {1, 8}, new int[] {1, 2}); // 1x4
		b = checkSliceView(a, new int[] {0, 1}, new int[] {6, 2}, new int[] {1, 2}); // 6x1

		// test special case of zero-rank dataset
		a = (DoubleDataset) DatasetFactory.createFromObject(1., Dataset.FLOAT64);
		b = (DoubleDataset) a.getSliceView();
		b.setShape(1);
		assertTrue(b.getIterator().hasNext());
	}

	private DoubleDataset checkSliceView(DoubleDataset a, int[] start, int[] stop, int[] step) {
		DoubleDataset s = (DoubleDataset) a.getSliceView(start, stop, step).squeeze();
		DoubleDataset t = (DoubleDataset) a.getSlice(start, stop, step).squeeze();
		assertArrayEquals(t.getShape(), s.getShape());
		assertEquals(t.toString(true), t, s);
		IndexIterator iter = s.getIterator(true);
		int[] pos = iter.getPos();
		while (iter.hasNext()) {
			assertEquals(iter.index, ((AbstractDataset) s).get1DIndex(pos));
			int[] p = s.getNDPosition(iter.index);
			assertArrayEquals(Arrays.toString(pos) + " : " + Arrays.toString(p), pos, p);
		}

		// test for correct copying of non-contiguous datasets
		assertArrayEquals(((DoubleDataset) t.flatten()).getData(), ((DoubleDataset) s.flatten()).getData(), 1e-15);

		TestUtils.assertEquals("Max", t.max().doubleValue(), s.max().doubleValue());
		TestUtils.assertEquals("Min", t.min().doubleValue(), s.min().doubleValue());
		return s;
	}

	@Test
	public void testSliceStrings() {
		String s;
		s = Slice.createString(new int[] {3}, null, null, null);
		assertEquals(":", s);

		s = Slice.createString(new int[] {3}, null, null, new int[] {1});
		assertEquals(":", s);

		s = Slice.createString(new int[] {3}, null, new int[] {2}, new int[] {1});
		assertEquals(":2", s);

		s = Slice.createString(new int[] {4}, new int[] {1}, new int[] {3}, new int[] {1});
		assertEquals("1:3", s);

		s = Slice.createString(new int[] {4}, new int[] {1}, new int[] {2}, new int[] {1});
		assertEquals("1", s);

		s = Slice.createString(new int[] {4}, new int[] {1}, new int[] {3}, new int[] {2});
		assertEquals("1", s);

		s = Slice.createString(new int[] {5}, null, null, new int[] {2});
		assertEquals("::2", s);

		s = Slice.createString(new int[] {5}, new int[] {1}, new int[] {4}, new int[] {2});
		assertEquals("1:4:2", s);

		s = Slice.createString(new int[] {5}, new int[] {1}, new int[] {5}, new int[] {2});
		assertEquals("1::2", s);

		s = Slice.createString(new int[] {5}, new int[] {1}, new int[] {3}, new int[] {2});
		assertEquals("1", s);

		s = Slice.createString(new int[] {3}, null, null, new int[] {-1});
		assertEquals("::-1", s);

		s = Slice.createString(new int[] {5}, new int[] {3}, new int[] {1}, new int[] {-1});
		assertEquals("3:1:-1", s);

		s = Slice.createString(new int[] {5}, new int[] {4}, new int[] {1}, new int[] {-1});
		assertEquals(":1:-1", s);

		s = Slice.createString(new int[] {5}, new int[] {3}, new int[] {0}, new int[] {-1});
		assertEquals("3:0:-1", s);

		s = Slice.createString(new int[] {5}, new int[] {3}, new int[] {-1}, new int[] {-1});
		assertEquals("3::-1", s);

		s = Slice.createString(new int[] {5}, new int[] {3}, new int[] {2}, new int[] {-1});
		assertEquals("3", s);

		s = Slice.createString(new int[] {5}, new int[] {3}, new int[] {1}, new int[] {-2});
		assertEquals("3", s);

		s = Slice.createString(new int[] {3, 2}, null, null, null);
		assertEquals(":,:", s);
	}

	@Test
	public void testSetSlice() {
		Dataset a = DatasetFactory.createRange(100, Dataset.FLOAT64).reshape(20, 5);
		a.setSlice(-2, null, new Slice(null, null, 2));

		assertEquals(-2, a.getDouble(0, 0), 1e-15);
		assertEquals(1,  a.getDouble(0, 1), 1e-15);
		assertEquals(-2, a.getDouble(0, 2), 1e-15);
		assertEquals(3,  a.getDouble(0, 3), 1e-15);
		assertEquals(-2, a.getDouble(0, 4), 1e-15);

		// with broadcasting
		a = DatasetFactory.createRange(100, Dataset.FLOAT64).reshape(20, 5);
		a.setSlice(DatasetFactory.createRange(3, Dataset.INT16), new Slice(2, 10), new Slice(null, null, 2));

		assertEquals(0, a.getDouble(0, 0), 1e-15);
		assertEquals(1, a.getDouble(0, 1), 1e-15);
		assertEquals(2, a.getDouble(0, 2), 1e-15);
		assertEquals(3, a.getDouble(0, 3), 1e-15);
		assertEquals(4, a.getDouble(0, 4), 1e-15);

		assertEquals(5, a.getDouble(1, 0), 1e-15);
		assertEquals(6, a.getDouble(1, 1), 1e-15);
		assertEquals(7, a.getDouble(1, 2), 1e-15);
		assertEquals(8, a.getDouble(1, 3), 1e-15);
		assertEquals(9, a.getDouble(1, 4), 1e-15);

		assertEquals(0, a.getDouble(2, 0), 1e-15);
		assertEquals(11, a.getDouble(2, 1), 1e-15);
		assertEquals(1, a.getDouble(2, 2), 1e-15);
		assertEquals(13, a.getDouble(2, 3), 1e-15);
		assertEquals(2, a.getDouble(2, 4), 1e-15);

		// compound
		CompoundDataset c = DatasetFactory.createRange(3, 100, Dataset.ARRAYFLOAT64).reshape(20, 5);
		c.setSlice(DatasetFactory.createRange(3, Dataset.INT16), new Slice(2, 10), new Slice(null, null, 2));
	}

	@Test
	public void test1DErrors() {
		
		// test 1D errors for single value
		Dataset a = DatasetFactory.createRange(100, Dataset.INT32);
		a.setError(5);
		
		assertEquals(5.0, a.getError(0), 0.001);
		assertEquals(5.0, a.getError(50), 0.001);
		assertEquals(5.0, a.getError(99), 0.001);

		assertTrue(a.hasErrors());

		// now for pulling out the full error array
		Dataset error = a.getError();
		
		// check compatibility
		try {
			AbstractDataset.checkCompatibility(a, error);
		} catch (Exception e) {
			fail("Error shape is not the same as input datasets");
		}
		
		assertEquals(5.0, error.getDouble(0), 0.001);
		assertEquals(5.0, error.getDouble(50), 0.001);
		assertEquals(5.0, error.getDouble(99), 0.001);
		
		// Now set the error as a whole array
		a.setError(Maths.multiply(error, 2));
		
		assertEquals(10.0, a.getError(0), 0.001);
		assertEquals(10.0, a.getError(50), 0.001);
		assertEquals(10.0, a.getError(99), 0.001);
		
		// test pulling the error out again, to make sure its correct
		Dataset error2 = a.getError();
		
		// check compatibility
		try {
			AbstractDataset.checkCompatibility(a, error2);
		} catch (Exception e) {
			fail("Error shape is not the same as input datasets");
		}
		
		assertEquals(10.0, error2.getDouble(0), 0.001);
		assertEquals(10.0, error2.getDouble(50), 0.001);
		assertEquals(10.0, error2.getDouble(99), 0.001);
	}
	
	
	@Test
	public void test2DErrors() {
		
		// test 1D errors for single value
		Dataset a = DatasetFactory.zeros(new int[] {100,100}, Dataset.INT32);
		a.setError(5);
		
		assertEquals(5.0, a.getError(0,0), 0.001);
		assertEquals(5.0, a.getError(50,50), 0.001);
		assertEquals(5.0, a.getError(99,99), 0.001);

		assertTrue(a.hasErrors());

		// now for pulling out the full error array
		Dataset error = a.getError();
		
		// check compatibility
		try {
			AbstractDataset.checkCompatibility(a, error);
		} catch (Exception e) {
			fail("Error shape is not the same as input datasets");
		}
		
		assertEquals(5.0, error.getDouble(0,0), 0.001);
		assertEquals(5.0, error.getDouble(50,50), 0.001);
		assertEquals(5.0, error.getDouble(99,99), 0.001);
		
		// Now set the error as a whole array
		a.setError(Maths.multiply(error, 2));
		
		assertEquals(10.0, a.getError(0,0), 0.001);
		assertEquals(10.0, a.getError(50,50), 0.001);
		assertEquals(10.0, a.getError(99,99), 0.001);
		
		// test pulling the error out again, to make sure its correct
		Dataset error2 = a.getError();
		
		// check compatibility
		try {
			AbstractDataset.checkCompatibility(a, error2);
		} catch (Exception e) {
			fail("Error shape is not the same as input datasets");
		}
		
		assertEquals(10.0, error2.getDouble(0,0), 0.001);
		assertEquals(10.0, error2.getDouble(50,50), 0.001);
		assertEquals(10.0, error2.getDouble(99,99), 0.001);
	}
	
	@Test
	public void testSetErrorBuffer() {
		
		Dataset a = DatasetFactory.zeros(new int[] {100,100}, Dataset.INT32);
		Dataset err = DatasetFactory.createLinearSpace(0, a.getSize() - 1, a.getSize(), Dataset.FLOAT64);
		err.setShape(a.getShape());
		
		a.setErrorBuffer(null);
		assertFalse(a.hasErrors());
		
		a.setErrorBuffer(25.0);
		
		assertEquals(5.0, a.getError(0,0), 0.001);
		assertEquals(5.0, a.getError(50,50), 0.001);
		assertEquals(5.0, a.getError(99,99), 0.001);

		assertTrue(a.hasErrors());
		
		// now for pulling out the full error array and check compatibility
		Dataset error = a.getError();
		try {
			AbstractDataset.checkCompatibility(a, error);
		} catch (Exception e) {
			fail("Error shape is not the same as input datasets");
		}
				
		a.setErrorBuffer(err);

		assertEquals(0.0, a.getError(0,0), 0.001);
		assertEquals(Math.sqrt(50.0 + 100*50.0), a.getError(50,50), 0.001);
		assertEquals(Math.sqrt(99.0 + 100*99.0), a.getError(99,99), 0.001);

		assertTrue(a.hasErrors());
		
		// now for pulling out the full error array and check compatibility
		error = a.getError();
		try {
			AbstractDataset.checkCompatibility(a, error);
		} catch (Exception e) {
			fail("Error shape is not the same as input datasets");
		}
		
		a.setErrorBuffer(err.getBuffer());

		assertEquals(0.0, a.getError(0,0), 0.001);
		assertEquals(Math.sqrt(35.0 + 100*25.0), a.getError(25,35), 0.001);
		assertEquals(Math.sqrt(99.0 + 100*99.0), a.getError(99,99), 0.001);

		assertTrue(a.hasErrors());
		
		// now for pulling out the full error array and check compatibility
		error = a.getError();
		try {
			AbstractDataset.checkCompatibility(a, error);
		} catch (Exception e) {
			fail("Error shape is not the same as input datasets");
		}
	}
	
	@Test
	public void testInternalErrors() {
		
		// test 1D errors for single value
		Dataset a = DatasetFactory.createRange(100, Dataset.INT32);
		a.setError(5);
		
		// should be squared
		Number ne = (Number) a.getErrorBuffer().getObjectAbs(0);
		assertEquals(25.0, ne.doubleValue(), 0.001);
		
		// now for pulling out the full error array
		Dataset error = a.getError();
	
		a.setError(Maths.multiply(error, 2));
		
		// should also be squared
		Dataset ae = a.getErrorBuffer();
		assertEquals(100.0, ae.getDouble(0), 0.001);
		assertEquals(100.0, ae.getDouble(50), 0.001);
		assertEquals(100.0, ae.getDouble(99), 0.001);	
	}

	@Test
	public void testZeroRankDatasets() {
		Dataset a;
		a = DoubleDataset.ones();
		assertEquals("Rank", 0, a.getRank());
		assertEquals("Shape", 0, a.getShape().length);
		assertEquals("Value", 1.0, a.getObject());
		assertEquals("Max", 1.0, a.max());
		assertEquals("Min", 1.0, a.min());
		assertEquals("MaxPos", 0, a.maxPos().length);
		assertEquals("MinPos", 0, a.minPos().length);
		assertEquals("ArgMax", 0, a.argMax());
		assertEquals("ArgMin", 0, a.argMin());
		assertEquals("Value", true, a.equals(new Double(1.0)));

		a = DatasetFactory.zeros(new int[] {}, Dataset.INT16);
		assertEquals("Rank", 0, a.getRank());
		assertEquals("Shape", 0, a.getShape().length);
		assertEquals("Value", (short) 0, a.getObject());

		a = DatasetFactory.createFromObject(new Complex(1.0, -0.5));
		assertEquals("Rank", 0, a.getRank());
		assertEquals("Shape", 0, a.getShape().length);
		assertEquals("Value", new Complex(1.0, -0.5), a.getObject());
		assertEquals("Real view value", 1.0, a.getRealView().getObject());
		assertEquals("Imaginary view value", -0.5, ((ComplexDoubleDataset) a).getImaginaryView().getObject());

		a = DatasetFactory.createFromObject(1.f);
		assertEquals("Rank", 0, a.getRank());
		assertEquals("Shape", 0, a.getShape().length);
		assertEquals("Value", 1.f, a.getObject());

		a = DoubleDataset.ones(1);
		a.squeeze();
		assertEquals("Rank", 0, a.getRank());
		assertEquals("Shape", 0, a.getShape().length);

		a = DatasetFactory.createFromObject(1.f);
		assertEquals("Equals", a, DatasetFactory.createFromObject(1.f));
		assertFalse("Differs", a.equals(DatasetFactory.createFromObject(2.f)));
	}

	@Test
	public void testConcatenate() {
		Dataset a, b, c, d;
		a = DatasetFactory.createRange(6, Dataset.FLOAT64);
		b = DatasetFactory.createRange(6, 8, 1, Dataset.FLOAT64);
		c = DatasetUtils.concatenate(new IDataset[] {a, b}, 0);
		d = DatasetFactory.createRange(8, Dataset.FLOAT64);
		assertEquals("Rank", 1, c.getRank());
		assertTrue("Dataset", c.equals(d));

		a = DatasetFactory.createRange(6, Dataset.FLOAT64).reshape(3,2);
		b = DatasetFactory.createRange(6, 8, 1, Dataset.FLOAT64).reshape(1,2);
		c = DatasetUtils.concatenate(new IDataset[] {a, b}, 0);
		d = DatasetFactory.createRange(8, Dataset.FLOAT64).reshape(4,2);
		assertEquals("Rank", 2, c.getRank());
		assertTrue("Dataset", c.equals(d));

		a.setShape(2,3);
		b = DatasetFactory.createRange(6, 9, 1, Dataset.FLOAT64).reshape(1,3);
		c = DatasetUtils.concatenate(new IDataset[] {a, b}, 0);
		d = DatasetFactory.createRange(9, Dataset.FLOAT64).reshape(3,3);
		assertEquals("Rank", 2, c.getRank());
		assertTrue("Dataset", c.equals(d));

		a = DatasetFactory.createRange(2, Dataset.FLOAT64).reshape(1,2);
		b = DatasetFactory.createRange(3, 5, 1, Dataset.FLOAT64).reshape(1,2);
		a = DatasetUtils.concatenate(new IDataset[] {a, b}, 0);
		b = DatasetFactory.createRange(2, 6, 3, Dataset.FLOAT64).reshape(2,1);
		c = DatasetUtils.concatenate(new IDataset[] {a, b}, 1);
		d = DatasetFactory.createRange(6, Dataset.FLOAT64).reshape(2,3);
		assertEquals("Rank", 2, c.getRank());
		assertTrue("Dataset", c.equals(d));
	}

	@Test
	public void testSum() {
		Dataset a = DatasetFactory.createRange(1024*1024, Dataset.INT32);

		assertEquals("Typed sum", -524288, a.typedSum(Dataset.INT32));

		a = DatasetFactory.createRange(12, Dataset.FLOAT64);
		a.setShape(3,4);
		assertEquals("Sum", 11*6, ((Number) a.sum()).doubleValue(), 1e-6);
		a.set(Double.NaN, 0,0);
		assertTrue("Sum", Double.isNaN(((Number) a.sum()).doubleValue()));
		assertEquals("Sum", 11*6, ((Number) a.sum(true)).doubleValue(), 1e-6);
	}

	@Test
	public void testMakeFinite() {
		Dataset a = DatasetFactory.createFromObject(new double[] {0, Double.POSITIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY });
		DatasetUtils.makeFinite(a);

		assertTrue("Make finite", DatasetFactory.createFromObject(new double[] {0, Double.MAX_VALUE, 0, -Double.MAX_VALUE}).equals(a));
	}

	@Test
	public void testCast() {
		long[] udata = new long[] {0, 1, 127, 128, 255, 256, 32767, 32768, 65535, 65536, 2147483647L, 2147483648L, 4294967295L, 4294967296L};
		Dataset d = new LongDataset(udata);
		Dataset a, c;
		c = DatasetUtils.cast(d, Dataset.INT32);
		Assert.assertTrue(c.max().doubleValue() < d.max().doubleValue()); // check stored values
		a = DatasetFactory.createFromObject(c, true);
		assertEquals("", 0, a.getLong(13));
		for (int i = 0; i < 13; i++)
			assertEquals("", udata[i], a.getLong(i));

		c = DatasetUtils.cast(d, Dataset.INT16);
		Assert.assertTrue(c.max().doubleValue() < d.max().doubleValue());
		a = DatasetFactory.createFromObject(c, true);
		assertEquals("", 0, a.getLong(9));
		for (int i = 0; i < 9; i++)
			assertEquals("", udata[i], a.getLong(i));

		c = DatasetUtils.cast(d, Dataset.INT8);
		Assert.assertTrue(c.max().doubleValue() < d.max().doubleValue());
		a = DatasetFactory.createFromObject(c, true);
		assertEquals("", 0, a.getLong(5));
		for (int i = 0; i < 5; i++)
			assertEquals("", udata[i], a.getLong(i));
	}

	@Test
	public void testRoll() {
		Dataset a = DatasetFactory.createRange(10, Dataset.INT32);

		Dataset r = DatasetUtils.roll(a, 2, null);

		TestUtils.assertDatasetEquals(r, Maths.add(a, 10-2).iremainder(10), 1e-6, 1e-6);

		r = DatasetUtils.roll(a, -2, null);
		TestUtils.assertDatasetEquals(r, Maths.add(a, 10+2).iremainder(10), 1e-6, 1e-6);

		a.setShape(2,5);
		r = DatasetUtils.roll(a, 1, null);
		TestUtils.assertDatasetEquals(r, Maths.add(a, 10-1).iremainder(10).reshape(2,5), 1e-6, 1e-6);

		r = DatasetUtils.roll(a, 1, 0);
		TestUtils.assertDatasetEquals(r, Maths.add(a, 5).iremainder(10).reshape(2,5), 1e-6, 1e-6);

		r = DatasetUtils.roll(a, 1, 1);
		TestUtils.assertDatasetEquals(r, new IntegerDataset(new int[] {4, 0, 1, 2, 3, 9, 5, 6, 7, 8}, 2,5), 1e-6, 1e-6);
	}

	@Test
	public void testRollAxis() {
		Dataset a = DatasetFactory.ones(new int[] {3, 4, 5, 6}, Dataset.INT8);
		Assert.assertArrayEquals(new int[] {3, 6, 4, 5}, DatasetUtils.rollAxis(a, 3, 1).getShape());
		Assert.assertArrayEquals(new int[] {5, 3, 4, 6}, DatasetUtils.rollAxis(a, 2, 0).getShape());
		Assert.assertArrayEquals(new int[] {3, 5, 6, 4}, DatasetUtils.rollAxis(a, 1, 4).getShape());
	}

	@Test
	public void testFindOccurrences() {
		Dataset a = new DoubleDataset(new double[] {0, 0, 3, 7, -4, 2, 1});
		Dataset v = DatasetFactory.createRange(-3, 3, 1, Dataset.FLOAT64);

		Dataset indexes = DatasetUtils.findFirstOccurrences(a, v);
		TestUtils.assertDatasetEquals(new IntegerDataset(new int[] {-1, -1, -1, 0, 6, 5}, null), indexes, true, 1, 1);
	}

	@Test
	public void testFindIndexes() {
		Dataset a = new DoubleDataset(new double[] {0, 0, 3, 7, -4, 2, 1});
		Dataset v = DatasetFactory.createRange(-3, 3, 1, Dataset.FLOAT64);

		IntegerDataset indexes = DatasetUtils.findIndexesForValues(a, v);
		TestUtils.assertDatasetEquals(new IntegerDataset(new int[] {3, 3, -1, -1, -1, 5, 4}, null), indexes, true, 1, 1);

		v = new DoubleDataset(new double[] {-4, 0, 1, 2, 3, 7});
		indexes = DatasetUtils.findIndexesForValues(a, v);
		TestUtils.assertDatasetEquals(a, v.getBy1DIndex(indexes), true, 1e-6, 1e-6);
	}

	@Test
	public void testAppend() {
		double[] x = { 0., 1., 2., 3., 4., 5. };
		Dataset d1 = DoubleDataset.createRange(3.);
		Dataset d2 = DoubleDataset.createRange(3., 6., 1.);
		Dataset d3 = DatasetUtils.append(d1, d2, 0);

		for (int i = 0; i < x.length; i++) {
			assertEquals("Append 1", x[i], d3.getDouble(i), 1e-8);
		}

		d1.setShape(1, 3);
		d2.setShape(1, 3);
		d3 = DatasetUtils.append(d1, d2, 0);
		Dataset d4 = new DoubleDataset(x);

		d4.setShape(2, 3);
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				assertEquals("Append 2", d4.getDouble(i, j), d3.getDouble(i, j), 1e-8);
			}
		}

		d3 = DatasetUtils.append(d1, d2, 1);
		d4 = new DoubleDataset(x);
		d4.setShape(1, 6);
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 6; j++) {
				assertEquals("Append 3", d4.getDouble(i, j), d3.getDouble(i, j), 1e-8);
			}
		}
	}

	public static void checkDatasets(Dataset calc, Dataset expected) {
		checkDatasets(expected, calc, 1e-5, 1e-5);
	}

	public static void checkDatasets(Dataset expected, Dataset calc, double relTol, double absTol) {
		checkDatasets(expected, calc, false, relTol, absTol);
	}

	public static void checkDatasets(Dataset expected, Dataset calc, boolean valuesOnly, double relTol, double absTol) {
		int type = expected.getDType();
		if (!valuesOnly) {
			Assert.assertEquals("Type", type, calc.getDType());
			Assert.assertEquals("Items", expected.getElementsPerItem(), calc.getElementsPerItem());
		}
		Assert.assertEquals("Size", expected.getSize(), calc.getSize());
		try {
			Assert.assertArrayEquals("Shape", expected.getShape(), calc.getShape());
		} catch (AssertionError e) {
			if (calc.getSize() == 1) {
				Assert.assertArrayEquals("Shape", new int[0], calc.getShape());
			} else {
				throw e;
			}
		}
		IndexIterator at = expected.getIterator(true);
		IndexIterator bt = calc.getIterator();
		final int eis = expected.getElementsPerItem();
		final int cis = calc.getElementsPerItem();
		final int is = Math.max(eis, cis);

		if (expected.getElementClass().equals(Boolean.class)) {
			while (at.hasNext() && bt.hasNext()) {
				for (int j = 0; j < is; j++) {
					boolean e = j >= eis ? false : expected.getElementBooleanAbs(at.index + j);
					boolean c = j >= cis ? false : calc.getElementBooleanAbs(bt.index + j);
					Assert.assertEquals("Value does not match at " + Arrays.toString(at.getPos()) + "; " + j +
							": ", e, c);
				}
			}
		} else if (expected.hasFloatingPointElements()) {
			while (at.hasNext() && bt.hasNext()) {
				for (int j = 0; j < is; j++) {
					double e = j >= eis ? 0 : expected.getElementDoubleAbs(at.index + j);
					double c = j >= cis ? 0 : calc.getElementDoubleAbs(bt.index + j);
					double t = Math.max(absTol, relTol*Math.max(Math.abs(e), Math.abs(c)));
					Assert.assertEquals("Value does not match at " + Arrays.toString(at.getPos()) + "; " + j +
							": ", e, c, t);
				}
			}
		} else if (type == Dataset.STRING) {
			StringDataset es = (StringDataset) expected;
			StringDataset cs = (StringDataset) calc;

			while (at.hasNext() && bt.hasNext()) {
				Assert.assertEquals("Value does not match at " + Arrays.toString(at.getPos()) + ": ",
						es.getAbs(at.index), cs.getAbs(bt.index));
			}
		} else if (type == Dataset.OBJECT) {
			ObjectDataset eo = (ObjectDataset) expected;
			ObjectDataset co = (ObjectDataset) calc;

			while (at.hasNext() && bt.hasNext()) {
				Assert.assertEquals("Value does not match at " + Arrays.toString(at.getPos()) + ": ",
						eo.getAbs(at.index), co.getAbs(bt.index));
			}
		} else {
			while (at.hasNext() && bt.hasNext()) {
				for (int j = 0; j < is; j++) {
					long e = j >= eis ? 0 : expected.getElementLongAbs(at.index + j);
					long c = j >= cis ? 0 : calc.getElementLongAbs(bt.index + j);
					Assert.assertEquals("Value does not match at " + Arrays.toString(at.getPos()) + "; " + j +
							": ", e, c);
				}
			}
		}
	}

	@Test
	public void testSelect() {
		DoubleDataset a = new DoubleDataset(new double[] { 0, 1, 3, 5, -7, -9 });
		DoubleDataset b = new DoubleDataset(new double[] { 0.01, 1.2, 2.9, 5, -7.1, -9 });

		Dataset c = a.clone().reshape(2, 3);
		BooleanDataset d = new BooleanDataset(new boolean[] {false, true, false, false, true, false}, 2, 3);

		DoubleDataset e = (DoubleDataset) DatasetUtils.select(new BooleanDataset[] {d}, new Object[] {c}, -2);
		checkDatasets(e, new DoubleDataset(new double[] {-2, 1, -2, -2, -7, -2}, 2, 3));

		Dataset f = b.clone().reshape(2, 3);
		BooleanDataset g = new BooleanDataset(new boolean[] {false, true, true, false, false, false}, 2, 3);

		e = (DoubleDataset) DatasetUtils.select(new BooleanDataset[] {d, g}, new Dataset[] {c, f}, -2.5);

		checkDatasets(e, new DoubleDataset(new double[] {-2.5, 1, 2.9, -2.5, -7, -2.5}, 2, 3));

		e = (DoubleDataset) DatasetUtils.select(d, c, -2);
		checkDatasets(e, new DoubleDataset(new double[] {-2, 1, -2, -2, -7, -2}, 2, 3));
	}

	@Test
	public void testChoose() {
		DoubleDataset a = new DoubleDataset(new double[] { 0, 1, 3, 5, -7, -9 });
		DoubleDataset b = new DoubleDataset(new double[] { 0.01, 1.2, 2.9, 5, -7.1, -9 });

		Dataset c = a.clone().reshape(2, 3);
		IntegerDataset d = new IntegerDataset(new int[] {0, 0, 1, 1, 0, 1}, 2, 3);

		DoubleDataset e = (DoubleDataset) DatasetUtils.choose(d, new Object[] {c, -2}, true, false);
		checkDatasets(e, new DoubleDataset(new double[] {0, 1, -2, -2, -7, -2}, 2, 3));

		d = new IntegerDataset(new int[] {-2, 0, 3, 1, 0, 2}, 2, 3);
		try {
			e = (DoubleDataset) DatasetUtils.choose(d, new Object[] {c, -2}, true, false);
			fail("Should have thrown an array index OOB exception");
		} catch (ArrayIndexOutOfBoundsException oob) {
			// expected
		}
		e = (DoubleDataset) DatasetUtils.choose(d, new Object[] {c, -2}, false, false);
		checkDatasets(e, new DoubleDataset(new double[] {0, 1, -2, -2, -7, -9}, 2, 3));

		e = (DoubleDataset) DatasetUtils.choose(d, new Object[] {c, -2}, false, true);
		checkDatasets(e, new DoubleDataset(new double[] {0, 1, -2, -2, -7, -2}, 2, 3));

		Dataset f = b.clone().reshape(2, 3);
		IntegerDataset g = new IntegerDataset(new int[] {1, 0, 1, 1, 2, 2}, 2, 3);

		e = (DoubleDataset) DatasetUtils.choose(g, new Object[] {c, f, -2}, true, false);
		checkDatasets(e, new DoubleDataset(new double[] {0.01, 1, 2.9, 5, -2, -2}, 2, 3));

		g = new IntegerDataset(new int[] {-1, 3, 1, 1, 2, 2}, 2, 3);
		try {
			e = (DoubleDataset) DatasetUtils.choose(d, new Object[] {c, f, -2}, true, false);
			fail("Should have thrown an array index OOB exception");
		} catch (ArrayIndexOutOfBoundsException oob) {
			// expected
		}

		e = (DoubleDataset) DatasetUtils.choose(g, new Object[] {c, f, -2}, false, false);
		checkDatasets(e, new DoubleDataset(new double[] {-2, 1, 2.9, 5, -2, -2}, 2, 3));

		e = (DoubleDataset) DatasetUtils.choose(g, new Object[] {c, f, -2}, false, true);
		checkDatasets(e, new DoubleDataset(new double[] {0, -2, 2.9, 5, -2, -2}, 2, 3));
	}

	@Test
	public void testSize() {
		int[] zero = new int[] {0};
		int[] one = new int[] {};
		int[] small = new int[] {2};
		int[] medium = new int[] {1024, 1024};
		int[] large = new int[] {1024, 1024, 1024};
		int[] xxxlarge = new int[] {1024, 1024, 1024, 1024};
		int[] bad = new int[] {1024, -1, 1024};

		assertEquals(0, AbstractDataset.calcLongSize(zero));
		assertEquals(0, AbstractDataset.calcSize(zero));

		assertEquals(1, AbstractDataset.calcLongSize(one));
		assertEquals(1, AbstractDataset.calcSize(one));

		assertEquals(2, AbstractDataset.calcLongSize(small));
		assertEquals(2, AbstractDataset.calcSize(small));

		assertEquals(1024*1024, AbstractDataset.calcLongSize(medium));
		assertEquals(1024*1024, AbstractDataset.calcSize(medium));

		assertEquals(1024*1024*1024, AbstractDataset.calcLongSize(large));
		assertEquals(1024*1024*1024, AbstractDataset.calcSize(large));

		assertEquals(1024*1024*1024*1024L, AbstractDataset.calcLongSize(xxxlarge));
		try {
			AbstractDataset.calcSize(xxxlarge);
			fail("Should have thrown an illegal argument exception");
		} catch (IllegalArgumentException e) {
			// expected
		} catch (Throwable t) {
			fail("Should have thrown an illegal argument exception");
		}

		try {
			AbstractDataset.calcLongSize(bad);
			fail("Should have thrown an illegal argument exception");
		} catch (IllegalArgumentException e) {
			// expected
		} catch (Throwable t) {
			fail("Should have thrown an illegal argument exception");
		}

		try {
			AbstractDataset.calcSize(bad);
			fail("Should have thrown an illegal argument exception");
		} catch (IllegalArgumentException e) {
			// expected
		} catch (Throwable t) {
			fail("Should have thrown an illegal argument exception");
		}
	}

	@Test
	public void testFill() {
		Dataset a = DatasetFactory.createRange(12, Dataset.FLOAT64);

		Dataset b = DatasetFactory.zeros(a);
		a.fill(0);
		checkDatasets(a, b, 1e-15, 1e-20);

		a.fill(0.);
		checkDatasets(a, b, 1e-15, 1e-20);

		a.fill(0L);
		checkDatasets(a, b, 1e-15, 1e-20);

		a.fill(new Complex(0));
		checkDatasets(a, b, 1e-15, 1e-20);

		a.fill(DatasetFactory.createFromObject(0));
		checkDatasets(a, b, 1e-15, 1e-20);

		a.fill(DatasetFactory.createFromObject(new int[] {0}));
		checkDatasets(a, b, 1e-15, 1e-20);

		try {
			a.fill(DatasetFactory.createFromObject(new int[] {0, 1}));
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void testPositions() {
		int[] shape = new int[] { 23, 34, 2 };
		int[] indexes = new int[] {1, 10, 70, 171};
		List<IntegerDataset> list = DatasetUtils.calcPositionsFromIndexes(new IntegerDataset(indexes, 2, 2), shape);

		Assert.assertEquals(shape.length, list.size());
		IntegerDataset l = list.get(0);
		Assert.assertEquals(2, l.getRank());
		Assert.assertEquals(2, l.getShapeRef()[0]);
		Assert.assertEquals(2, l.getShapeRef()[1]);

		checkPositions(list, new int[] {0, 0, 1},  0, 0);
		checkPositions(list, new int[] {0, 5, 0},  0, 1);
		checkPositions(list, new int[] {1, 1, 0},  1, 0);
		checkPositions(list, new int[] {2, 17, 1},  1, 1);
	}

	private void checkPositions(List<IntegerDataset> list, int[] expected, int... position) {
		int j = 0;
		for (int i : expected) {
			IntegerDataset l = list.get(j++);
			Assert.assertEquals(i, l.getInt(position));
		}
	}

	@Test
	public void testIndexes() {
		List<IntegerDataset> list = new ArrayList<IntegerDataset>();
		int[] shape = new int[] { 23, 34, 2 };
		list.add(new IntegerDataset(new int[] {0, 0, 1, 2}, 2, 2));
		list.add(new IntegerDataset(new int[] {0, 5, 1, 17}, 2, 2));
		list.add(new IntegerDataset(new int[] {1, 0, 0, 1}, 2, 2));
		IntegerDataset indexes = DatasetUtils.calcIndexesFromPositions(list, shape, null);

		checkDatasets(indexes, new IntegerDataset(new int[] {1, 10, 70, 171}, 2, 2));

		list.set(1, new IntegerDataset(new int[] {0, -5, 1, 17}, 2, 2));
		try {
			indexes = DatasetUtils.calcIndexesFromPositions(list, shape, null);
			Assert.fail("Should have thrown an exception");
		} catch (Exception e) {
		}

		list.set(1, new IntegerDataset(new int[] {0, 34, 1, 17}, 2, 2));
		try {
			indexes = DatasetUtils.calcIndexesFromPositions(list, shape, null);
			Assert.fail("Should have thrown an exception");
		} catch (Exception e) {
		}

		list.set(1, new IntegerDataset(new int[] {0, 39, 1, 17}, 2, 2));
		indexes = DatasetUtils.calcIndexesFromPositions(list, shape, 1);
		checkDatasets(indexes, new IntegerDataset(new int[] {1, 10, 70, 171}, 2, 2));

		list.set(1, new IntegerDataset(new int[] {0, -29, 1, 17}, 2, 2));
		indexes = DatasetUtils.calcIndexesFromPositions(list, shape, 1);
		checkDatasets(indexes, new IntegerDataset(new int[] {1, 10, 70, 171}, 2, 2));

		list.set(1, new IntegerDataset(new int[] {-2, 5, 1, 17}, 2, 2));
		indexes = DatasetUtils.calcIndexesFromPositions(list, shape, 2);
		checkDatasets(indexes, new IntegerDataset(new int[] {1, 10, 70, 171}, 2, 2));

		list.set(1, new IntegerDataset(new int[] {34, 5, 1, 17}, 2, 2));
		indexes = DatasetUtils.calcIndexesFromPositions(list, shape, 2);
		checkDatasets(indexes, new IntegerDataset(new int[] {33*2 + 1, 10, 70, 171}, 2, 2));
	}

	@Test
	public void testSetByBoolean() {
		Dataset a = DatasetFactory.createRange(10, Dataset.INT32);
		a.max();
		a.setByBoolean(0, Comparisons.greaterThan(a, 5));
		Assert.assertEquals(a.max().longValue(), 5);
	}

	@Test
	public void testExtract() {
		Dataset a = DatasetFactory.createRange(20, Dataset.INT32).reshape(4,5);
		Dataset b = DatasetFactory.createFromObject(new boolean[] {true, false, true, false, false});

		checkDatasets(DatasetUtils.extract(a, b), DatasetFactory.createFromObject(new int[] {0, 2, 5, 7, 10, 12, 15, 17}));
	}

	@Test
	public void testSetBy1DIndex() {
		Dataset a = DatasetFactory.createRange(10, Dataset.INT32);
		a.max();
		a.setBy1DIndex(0, Comparisons.nonZero(Comparisons.greaterThan(a, 5)).get(0));
		Assert.assertEquals(a.max().longValue(), 5);
	}

	@Test
	public void testSetByPosition() {
		Dataset a = DatasetFactory.createRange(10, Dataset.INT32);
		a.max();
		List<IntegerDataset> list = Comparisons.nonZero(Comparisons.greaterThan(a, 5));
		a.setByIndexes(0, list.get(0));
		Assert.assertEquals(a.max().longValue(), 5);

		a = DatasetFactory.createRange(10, Dataset.INT32).reshape(2, 5);
		a.max();
		list = Comparisons.nonZero(Comparisons.greaterThan(a, 5));
		a.setByIndexes(0, list.get(0), list.get(1));
		Assert.assertEquals(a.max().longValue(), 5);
	}

	@Test
	public void testReshape() {
		Dataset a = DatasetFactory.createRange(60, Dataset.INT32);
		Dataset b = a.getSliceView(new int[] {1}, null, new int[] {2});
		Dataset c = a.getSlice(new int[] {1}, null, new int[] {2});
		checkDatasets(b, c);

		// check if strides still work
		b.setShape(6, 5);
		c.setShape(6, 5);
		checkDatasets(b, c);

		b.setShape(1, 6, 5);
		c.setShape(1, 6, 5);
		checkDatasets(b, c);

		b.setShape(1, 6, 1, 5);
		c.setShape(1, 6, 1, 5);
		checkDatasets(b, c);

		b.setShape(30);
		c.setShape(30);
		checkDatasets(b, c);

		b.setShape(6, 5);
		try {
			Dataset d = b.getSliceView(new Slice(1,6,2));
			d.setShape(15);
			Assert.fail("Should have thrown an illegal argument exception");
		} catch (IllegalArgumentException e) {
			// do nothing
		} catch (Exception e) {
			Assert.fail("Should have thrown an illegal argument exception");
		}
	}

	@Test
	public void testDatasetVariance() {
		Random.seed(12345);
		final Dataset image = Maths.multiply(Random.rand(new int[] { 10, 10 }), 1);
		double mean = ((Number) image.mean()).doubleValue();
		Dataset square = Maths.square(Maths.subtract(image, mean));
		double var = ((Number) square.mean()).doubleValue();

		Assert.assertEquals(var, image.variance(true).doubleValue(), var * 1.e-15);
	}

	@Test
	public void testBroadcast() {
		Dataset a = DatasetFactory.createRange(3, Dataset.INT32);
		Dataset b = checkBroadcast2D(a, false, 2, 3);
		Assert.assertEquals(1, b.getInt(0, 1));
		Assert.assertEquals(1, b.getInt(1, 1));

		a.setShape(3, 1);
		b = checkBroadcast2D(a, true, 3, 4);
		Assert.assertEquals(1, b.getInt(1, 0));
		Assert.assertEquals(1, b.getInt(1, 1));
	}

	private Dataset checkBroadcast2D(Dataset a, boolean broadcastFirstDim, int... broadcastShape) {
		Dataset b = a.getBroadcastView(broadcastShape);
		Assert.assertArrayEquals(broadcastShape, b.getShape());
		int size = AbstractDataset.calcSize(broadcastShape);
		Assert.assertEquals(size, b.getSize());

		IndexIterator it = b.getIterator(true);
		int[] pos = it.getPos();
		int i = 0;
		while (it.hasNext()) {
			i++;
			if (broadcastFirstDim) {
				Assert.assertEquals(a.getInt(pos[0], 0), b.getInt(pos));
				Assert.assertEquals(a.getInt(pos[0], 0), b.getElementLongAbs(it.index));
			} else {
				Assert.assertEquals(a.getInt(pos[1]), b.getInt(pos));
				Assert.assertEquals(a.getInt(pos[1]), b.getElementLongAbs(it.index));
			}
		}
		Assert.assertEquals(size, i);

		return b;
	}
}
