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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.dawnsci.analysis.dataset.impl.Dataset;
import org.eclipse.dawnsci.analysis.dataset.impl.DatasetFactory;
import org.eclipse.dawnsci.analysis.dataset.impl.IndexIterator;
import org.eclipse.dawnsci.analysis.dataset.impl.SliceIterator;
import org.junit.Test;

/**
 *
 */
public class IndexIteratorTest {

	/**
	 * 
	 */
	@Test
	public void testIterations() {
		int size, type;

		size = 1024;
		type = Dataset.FLOAT64;
		testIterationsND(size, type);

		type = Dataset.COMPLEX128;
		testIterationsND(size, type);
	}

	private void testIterationsND(int size, int type) {
		Dataset ta;


		System.out.println("Size: " + size);

		// 0D
		ta = DatasetFactory.zeros(new int[] {}, type);
		testDataset(ta);

		// 1D
		ta = DatasetFactory.createRange(0, size, 1, type);
		testDataset(ta);

		// 2D
		ta = DatasetFactory.createRange(0, size, 1, type).reshape(16, size / 16);
		System.out.println(" Shape: " + Arrays.toString(ta.getShape()));
		testDataset(ta);

		ta = DatasetFactory.createRange(0, size, 1, type).reshape(size / 32, 32);
		System.out.println(" Shape: " + Arrays.toString(ta.getShape()));
		testDataset(ta);

		// 3D
		ta = DatasetFactory.createRange(0, size, 1, type).reshape(16, 8, size / (16 * 8));
		System.out.println(" Shape: " + Arrays.toString(ta.getShape()));
		testDataset(ta);

		ta = DatasetFactory.createRange(0, size, 1, type).reshape(size / (16 * 8), 16, 8);
		System.out.println(" Shape: " + Arrays.toString(ta.getShape()));
		testDataset(ta);

	}

	private void testDataset(Dataset ta) {
		IndexIterator iter = ta.getIterator();
		double[] data = (double[]) ta.getBuffer();

		for (int i = 0; iter.hasNext(); i++) {
			assertEquals(i, data[iter.index], 1e-5*i);
		}

		iter.reset();
		for (int i = 0; iter.hasNext(); i++) {
			assertEquals(i, data[iter.index], 1e-5*i);
		}

		iter = ta.getIterator(true);
		int[] pos = iter.getPos();
		for (int i = 0; iter.hasNext(); i++) {
			assertEquals(i, ta.getDouble(pos), 1e-5*i);
		}

		iter.reset();
		for (int i = 0; iter.hasNext(); i++) {
			assertEquals(i, ta.getDouble(pos), 1e-5*i);
		}
	}

	private Dataset oldSlice(Dataset t, SliceIterator siter) {
		int[] shape = siter.getShape();
		int rank = shape.length;
		int[] lstart = siter.getStart();
		int[] lstep = siter.getStep();
		Dataset result = DatasetFactory.zeros(shape, Dataset.FLOAT64);

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

	@SuppressWarnings({ "null" })
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

		elapsed.clear();
		for (int i = 0; i < nloop; i++) {
			stime = System.nanoTime();
			sliced = oldSlice(t, siter);
			elapsed.add(System.nanoTime() - stime);
		}
		Collections.sort(elapsed);
//		System.out.println("  Sliced shape: " + Arrays.toString(sliced.getShape()));
//		System.out.println(String.format("    old  %5.2fus", elapsed.get(0)*1e-3));

		double[] sdata = (double[]) sliced.getBuffer();

		Dataset nsliced = null;

		elapsed.clear();
		for (int i = 0; i < nloop; i++) {
			stime = System.nanoTime();
			nsliced = t.getSlice(starts, null, steps);
			elapsed.add(System.nanoTime() - stime);
		}
		Collections.sort(elapsed);
//		System.out.println(String.format("    iter %5.2fus", elapsed.get(0)*1e-3));

		double[] ndata = (double[]) nsliced.getBuffer();
		IndexIterator iter = nsliced.getIterator();
		for (int i = 0; i < sdata.length && iter.hasNext(); i++) {
			assertEquals(sdata[i], ndata[iter.index], 1e-5*sdata[i]);
		}
	}

	/**
	 * 
	 */
	@Test
	public void testSliceIteration() {
		int size, type;

		size = 60;
		type = Dataset.FLOAT64;
		testSliceIterationND(size, type);

		type = Dataset.COMPLEX128;
		testSliceIterationND(size, type);
	}

	private void testSliceIterationND(int size, int type) {
		Dataset ta;

		System.out.println(" Size: " + size);

		// 1D
		ta = DatasetFactory.createRange(0, size, 1, type);
		testSlicedDataset(ta, 0, 0, 3, 0);
		testSlicedDataset(ta, 0, 0, 62, 0);
		testSlicedDataset(ta, 23, 0, 3, 0);
		testSlicedDataset(ta, 23, 0, 62, 0);

		// 2D
		ta = DatasetFactory.createRange(0, size, 1, type).reshape(size / 15, 15);
//		ta.reshape(15, size / 15);
		System.out.println(" Shape: " + Arrays.toString(ta.getShape()));
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

		// 3D
		ta = DatasetFactory.createRange(0, size, 1, type).reshape(size / 10, 2, 5);
//		ta.reshape(5, size / 10, 2);
		System.out.println(" Shape: " + Arrays.toString(ta.getShape()));

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

}
