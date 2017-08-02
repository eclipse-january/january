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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.january.asserts.TestUtils;
import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.dataset.IndexIterator;
import org.eclipse.january.dataset.SliceIterator;
import org.eclipse.january.dataset.StrideIterator;
import org.junit.Test;

/**
 *
 */
public class StrideIteratorTest {

	/**
	 * 
	 */
	@Test
	public void testIterations() {
		int size = 1024;

		testIterationsND(size, DoubleDataset.class);

		testIterationsND(size, ComplexDoubleDataset.class);
	}

	private void testIterationsND(int size, Class<? extends Dataset> clazz) {
		Dataset ta;


		TestUtils.verbosePrintf("Size: %d\n", size);

		// 0D
		ta = DatasetFactory.zeros(clazz, new int[] {});
		testDataset(ta);

		// 1D
		ta = DatasetFactory.createRange(clazz, 0, size, 1);
		testDataset(ta);

		// 2D
		ta = DatasetFactory.createRange(clazz, 0, size, 1).reshape(16, size / 16);
		TestUtils.verbosePrintf(" Shape: %s\n", Arrays.toString(ta.getShape()));
		testDataset(ta);

		ta = DatasetFactory.createRange(clazz, 0, size, 1).reshape(size / 32, 32);
		TestUtils.verbosePrintf(" Shape: %s\n", Arrays.toString(ta.getShape()));
		testDataset(ta);

		// 3D
		ta = DatasetFactory.createRange(clazz, 0, size, 1).reshape(16, 8, size / (16 * 8));
		TestUtils.verbosePrintf(" Shape: %s\n", Arrays.toString(ta.getShape()));
		testDataset(ta);

		ta = DatasetFactory.createRange(clazz, 0, size, 1).reshape(size / (16 * 8), 16, 8);
		TestUtils.verbosePrintf(" Shape: %s\n", Arrays.toString(ta.getShape()));
		testDataset(ta);
	}

	private void testDataset(Dataset ta) {
		IndexIterator iter = new StrideIterator(ta.getElementsPerItem(), ta.getShape());
		double[] data = (double[]) ta.getBuffer();

		int size = ta.getSize();
		int i;
		for (i = 0; iter.hasNext(); i++) {
			assertEquals(i, data[iter.index], 1e-5*i);
		}
		assertEquals(size, i);

		iter.reset();
		for (i = 0; iter.hasNext(); i++) {
			assertEquals(i, data[iter.index], 1e-5*i);
		}
		assertEquals(size, i);

		iter = ta.getIterator(true);
		int[] pos = iter.getPos();
		for (i = 0; iter.hasNext(); i++) {
			assertEquals(i, ta.getDouble(pos), 1e-5*i);
		}
		assertEquals(size, i);

		iter.reset();
		for (i = 0; iter.hasNext(); i++) {
			assertEquals(i, ta.getDouble(pos), 1e-5*i);
		}
		assertEquals(size, i);
	}

	private Dataset oldSlice(Dataset t, SliceIterator siter) {
		int[] shape = siter.getShape();
		int rank = shape.length;
		int[] lstart = siter.getStart();
		int[] lstep = siter.getStep();
		Dataset result = DatasetFactory.zeros(shape);

		// set up the vectors needed to do this
		int relative[] = new int[rank];
		int absolute[] = new int[rank];

		for (int i = 0; i < rank; i++) {
			relative[i] = lstart[i];
			absolute[i] = 0;
		}

		// now perform the loop
		while (true) {
			// write the value from the relative position of this dataset
			// to the actual position in the final vector.
			result.set(t.getDouble(relative), absolute);

			// now move the count on one position
			int j = rank - 1;
			for (; j >= 0; j--) {
				relative[j] += lstep[j];
				absolute[j]++;
				if (absolute[j] >= shape[j]) {
					relative[j] = lstart[j];
					absolute[j] = 0;
				} else {
					break;
				}
			}
			if (j == -1)
				break;
		}
		return result;
	}

	private void timeOldSlice(SliceIterator siter) {
		int[] shape = siter.getShape();
		int rank = shape.length;
		int[] lstart = siter.getStart();
		int[] lstep = siter.getStep();

		// set up the vectors needed to do this
		int relative[] = new int[rank];
		int absolute[] = new int[rank];

		for (int i = 0; i < rank; i++) {
			relative[i] = lstart[i];
			absolute[i] = 0;
		}

		// now perform the loop
		while (true) {
			// now move the count on one position
			int j = rank - 1;
			for (; j >= 0; j--) {
				relative[j] += lstep[j];
				absolute[j]++;
				if (absolute[j] >= shape[j]) {
					relative[j] = lstart[j];
					absolute[j] = 0;
				} else {
					break;
				}
			}
			if (j == -1)
				break;
		}
	}

	private Dataset newSlice(Dataset t, int[] start, int[] stop, int[] step) {
		StrideIterator iter = new StrideIterator(t.getElementsPerItem(), t.getShape(), start, stop, step);

		Dataset result = DatasetFactory.zeros(iter.getShape());
		int i = 0;
		while (iter.hasNext()) {
			result.setObjectAbs(i++, t.getElementDoubleAbs(iter.index));
		}

		return result;
	}

	private void timeNewSlice(Dataset t, int[] start, int[] stop, int[] step) {
		StrideIterator iter = new StrideIterator(t.getElementsPerItem(), t.getShape(), start, stop, step);

		while (iter.hasNext()) {
		}
	}

	private void timeCurrentSlice(Dataset t, int[] start, int[] stop, int[] step) {
		IndexIterator iter = t.getSliceIterator(start, stop, step);

		while (iter.hasNext()) {
		}
	}

	private void testSlicedDataset(Dataset t, int start, int startaxis, int step, int stepaxis) {
		int rank = t.getRank();
		int[] steps = new int[rank];
		int[] starts = new int[rank];

		Arrays.fill(steps, 1);
		while (stepaxis > rank) {
			stepaxis -= rank;
		}
		if (stepaxis < 0)
			stepaxis += rank;

		steps[stepaxis] = step;

		//Arrays.fill(starts, 1);
		while (startaxis > rank) {
			startaxis -= rank;
		}
		if (startaxis < 0)
			startaxis += rank;

		starts[startaxis] = start;

		int nloop = 7;
		long stime;
		List<Long> elapsed = new ArrayList<Long>();

		Dataset sliced = null;
		SliceIterator siter = (SliceIterator) t.getSliceIterator(starts, null, steps);

		sliced = oldSlice(t, siter);
		TestUtils.verbosePrintf("  Slicing : %d@%d, %d@%d\n", start, startaxis, step, stepaxis);
		TestUtils.verbosePrintf("  Sliced shape: %s\n", Arrays.toString(sliced.getShape()));
		elapsed.clear();
		for (int i = 0; i < nloop; i++) {
			stime = System.nanoTime();
			timeOldSlice(siter);
			elapsed.add(System.nanoTime() - stime);
		}
		Collections.sort(elapsed);
		TestUtils.verbosePrintf("    old  %5.2fus\n", elapsed.get(0)*1e-3);

		Dataset nsliced = null;

		elapsed.clear();
		for (int i = 0; i < nloop; i++) {
			stime = System.nanoTime();
			timeCurrentSlice(t, starts, null, steps);
			elapsed.add(System.nanoTime() - stime);
		}
		Collections.sort(elapsed);
		TestUtils.verbosePrintf("    iter %5.2fus\n", elapsed.get(0)*1e-3);
		double current = elapsed.get(0);

		nsliced = newSlice(t, starts, null, steps);
		elapsed.clear();
		for (int i = 0; i < nloop; i++) {
			stime = System.nanoTime();
			timeNewSlice(t, starts, null, steps);
			elapsed.add(System.nanoTime() - stime);
		}
		Collections.sort(elapsed);
		TestUtils.verbosePrintf("    strides %5.2fus (%.2f)\n", elapsed.get(0)*1e-3, elapsed.get(0)/current);

		checkSliced(sliced, nsliced);
	}

	private void checkSliced(Dataset sliced, Dataset nsliced) {
		double[] ndata = (double[]) nsliced.getBuffer();
		IndexIterator iter = nsliced.getIterator();
		double[] sdata = (double[]) sliced.getBuffer();
		int n = 0;
		int isize = sliced.getElementsPerItem();
		for (int i = 0; i < sdata.length && iter.hasNext();) {
			for (int j = 0; j < isize; i++, j++, n++) {
				assertEquals(sdata[i], ndata[iter.index + j], 1e-5*sdata[i]);
			}
		}
		assertEquals("Size of dataset slice is incorrect", sdata.length, n);
	}

	@Test
	public void testNegativeStrideIteration() {
		Dataset t = DatasetFactory.createRange(40);

		SliceIterator siter = (SliceIterator) t.getSliceIterator(new int[] {12}, null, new int[] {-2});
		Dataset sliced = oldSlice(t, siter);
		Dataset nsliced = newSlice(t, new int[] {12}, null, new int[] {-2});
		checkSliced(sliced, nsliced);

		t.setShape(8,5);
		sliced = oldSlice(t, (SliceIterator) t.getSliceIterator(new int[] {1, 3}, null, new int[] {2, -2}));
		nsliced = newSlice(t, new int[] {1, 3}, null, new int[] {2, -2});
		checkSliced(sliced, nsliced);

		sliced = oldSlice(t, (SliceIterator) t.getSliceIterator(new int[] {7, 4}, null, new int[] {-1, -1}));
		nsliced = newSlice(t, new int[] {7, 4}, null, new int[] {-1, -1});
		checkSliced(sliced, nsliced);
	}

	/**
	 * 
	 */
	@Test
	public void testSliceIteration() {
		int size = 6000;
		testSliceIterationND(size, DoubleDataset.class);

		testSliceIterationND(size, ComplexDoubleDataset.class);
	}

	private void testSliceIterationND(int size, Class<? extends Dataset> clazz) {
		Dataset ta;

		TestUtils.verbosePrintf(" Size: %d\n", size);

		// 1D
		ta = DatasetFactory.createRange(clazz, 0, size, 1);
		testSlicedDataset(ta, 0, 0, 3, 0);
		testSlicedDataset(ta, 0, 0, 62, 0);
		testSlicedDataset(ta, 23, 0, 3, 0);
		testSlicedDataset(ta, 23, 0, 62, 0);

		testSlicedDataset(ta, -3, 0, -2, 0);

		// 2D
		ta = DatasetFactory.createRange(clazz, 0, size, 1).reshape(size / 15, 15);
//		ta.reshape(15, size / 15);
		TestUtils.verbosePrintf(" Shape: %s\n", Arrays.toString(ta.getShape()));
		testSlicedDataset(ta, 0, 0, 3, 0);
		testSlicedDataset(ta, 0, 0, 3, 1);
		testSlicedDataset(ta, 2, 0, 3, 0);
		testSlicedDataset(ta, 2, 0, 3, 1);
		testSlicedDataset(ta, 3, 1, 3, 0);
		testSlicedDataset(ta, 3, 1, 3, 1);

		testSlicedDataset(ta, 0, 0, 4, 0);
		testSlicedDataset(ta, 0, 0, 4, 1);
		testSlicedDataset(ta, 2, 0, 4, 0);
		testSlicedDataset(ta, 2, 0, 4, 1);
		testSlicedDataset(ta, 3, 1, 4, 0);
		testSlicedDataset(ta, 3, 1, 4, 1);

		testSlicedDataset(ta, 0, 0, -1, 0);
		testSlicedDataset(ta, 0, 0, -1, 1);
		testSlicedDataset(ta, 2, 0, -1, 0);
		testSlicedDataset(ta, 2, 0, -1, 1);
		testSlicedDataset(ta, 3, 1, -1, 0);
		testSlicedDataset(ta, 3, 1, -1, 1);

		testSlicedDataset(ta, 0, 0, -2, 0);
		testSlicedDataset(ta, 0, 0, -2, 1);
		testSlicedDataset(ta, 2, 0, -2, 0);
		testSlicedDataset(ta, 2, 0, -2, 1);
		testSlicedDataset(ta, 3, 1, -2, 0);
		testSlicedDataset(ta, 3, 1, -2, 1);

		testSlicedDataset(ta, 0, 0, -3, 0);
		testSlicedDataset(ta, 0, 0, -3, 1);
		testSlicedDataset(ta, 2, 0, -3, 0);
		testSlicedDataset(ta, 2, 0, -3, 1);
		testSlicedDataset(ta, 3, 1, -3, 0);
		testSlicedDataset(ta, 3, 1, -3, 1);

		testSlicedDataset(ta, 8, 0, -3, 0);
		testSlicedDataset(ta, 8, 1, -3, 1);

		// 3D
		ta = DatasetFactory.createRange(clazz, 0, size, 1).reshape(size / 10, 2, 5);
//		ta.reshape(5, size / 10, 2);
		TestUtils.verbosePrintf(" Shape: %s\n", Arrays.toString(ta.getShape()));

		testSlicedDataset(ta, 0, 0, 3, 0);
		testSlicedDataset(ta, 0, 0, 3, 1);
		testSlicedDataset(ta, 0, 0, 3, 2);
		testSlicedDataset(ta, 3, 0, 3, 0);
		testSlicedDataset(ta, 3, 0, 3, 1);
		testSlicedDataset(ta, 3, 0, 3, 2);
		testSlicedDataset(ta, 1, 1, 3, 0);
		testSlicedDataset(ta, 1, 1, 3, 1);
		testSlicedDataset(ta, 1, 1, 3, 2);
		testSlicedDataset(ta, 2, 2, 3, 0);
		testSlicedDataset(ta, 2, 2, 3, 1);
		testSlicedDataset(ta, 2, 2, 3, 2);

		testSlicedDataset(ta, 0, 0, 4, 0);
		testSlicedDataset(ta, 0, 0, 4, 1);
		testSlicedDataset(ta, 0, 0, 4, 2);
		testSlicedDataset(ta, 3, 0, 4, 0);
		testSlicedDataset(ta, 3, 0, 4, 1);
		testSlicedDataset(ta, 3, 0, 4, 2);
		testSlicedDataset(ta, 1, 1, 4, 0);
		testSlicedDataset(ta, 1, 1, 4, 1);
		testSlicedDataset(ta, 1, 1, 4, 2);
		testSlicedDataset(ta, 2, 2, 4, 0);
		testSlicedDataset(ta, 2, 2, 4, 1);
		testSlicedDataset(ta, 2, 2, 4, 2);

		testSlicedDataset(ta, 0, 0, -1, 0);
		testSlicedDataset(ta, 0, 0, -1, 1);
		testSlicedDataset(ta, 0, 0, -1, 2);
		testSlicedDataset(ta, 3, 0, -1, 0);
		testSlicedDataset(ta, 3, 0, -1, 1);
		testSlicedDataset(ta, 3, 0, -1, 2);
		testSlicedDataset(ta, 1, 1, -1, 0);
		testSlicedDataset(ta, 1, 1, -1, 1);
		testSlicedDataset(ta, 1, 1, -1, 2);
		testSlicedDataset(ta, 2, 2, -1, 0);
		testSlicedDataset(ta, 2, 2, -1, 1);
		testSlicedDataset(ta, 2, 2, -1, 2);

		testSlicedDataset(ta, 0, 0, -2, 0);
		testSlicedDataset(ta, 0, 0, -2, 1);
		testSlicedDataset(ta, 0, 0, -2, 2);
		testSlicedDataset(ta, 3, 0, -2, 0);
		testSlicedDataset(ta, 3, 0, -2, 1);
		testSlicedDataset(ta, 3, 0, -2, 2);
		testSlicedDataset(ta, 1, 1, -2, 0);
		testSlicedDataset(ta, 1, 1, -2, 1);
		testSlicedDataset(ta, 1, 1, -2, 2);
		testSlicedDataset(ta, 2, 2, -2, 0);
		testSlicedDataset(ta, 2, 2, -2, 1);
		testSlicedDataset(ta, 2, 2, -2, 2);

		testSlicedDataset(ta, 0, 0, -3, 0);
		testSlicedDataset(ta, 0, 0, -3, 1);
		testSlicedDataset(ta, 0, 0, -3, 2);
		testSlicedDataset(ta, 3, 0, -3, 0);
		testSlicedDataset(ta, 3, 0, -3, 1);
		testSlicedDataset(ta, 3, 0, -3, 2);
		testSlicedDataset(ta, 1, 1, -3, 0);
		testSlicedDataset(ta, 1, 1, -3, 1);
		testSlicedDataset(ta, 1, 1, -3, 2);
		testSlicedDataset(ta, 2, 2, -3, 0);
		testSlicedDataset(ta, 2, 2, -3, 1);
		testSlicedDataset(ta, 2, 2, -3, 2);
	}

	@Test
	public void testBroadcastStrideIteration() {
		Dataset b, r;

		// 0D to 1D
		b = DatasetFactory.createFromObject(2., 1).getBroadcastView(4);
		r = DatasetFactory.zeros(b.getClass(), b.getShape()).fill(b.getObjectAbs(0));
		checkSliced(r, b);

		// 1D to 2D
		b = DatasetFactory.createRange(2.).getBroadcastView(4, 2);
		r = DatasetFactory.createRange(2.).reshape(1, 2);
		r = DatasetUtils.concatenate(new Dataset[] {r, r, r, r}, 0);
		checkSliced(r, b);
		
		r = DatasetFactory.createRange(2.);
		checkSliced(r, b.getSlice(new Slice(0, 1)));
		checkSliced(r, b.getSlice(new Slice(3, 4)));
		checkSliced(r, b.getSliceView(new Slice(0, 1)));
		checkSliced(r, b.getSliceView(new Slice(3, 4)));

		// compound datasets
		// 0D to 1D
		b = DatasetFactory.createCompoundDataset(1., 2., 3.).getBroadcastView(4);
		r = DatasetFactory.zeros(b.getElementsPerItem(), b.getClass(), b.getShape()).fill(b.getObjectAbs(0));
		checkSliced(r, b);

		// 1D to 2D
		CompoundDataset a = DatasetFactory.createCompoundDataset(new double[] {1., 2.}, new double[] {3., 4.});
		b = a.getBroadcastView(4, 2);
		a.reshape(1,2);
		r = DatasetUtils.concatenate(new Dataset[] {a, a, a, a}, 0);
		checkSliced(r, b);
	}
}
