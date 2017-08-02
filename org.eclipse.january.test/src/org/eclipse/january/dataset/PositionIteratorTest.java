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

import java.util.Arrays;

import org.eclipse.january.asserts.TestUtils;
import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.dataset.PositionIterator;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class PositionIteratorTest {
	/**
	 * 
	 */
	@Test
	public void testIterations() {
		int size = 1024;
		testIterationND(size, DoubleDataset.class);

		testIterationND(size, ComplexDoubleDataset.class);
	}

	@Test
	public void testOffsetIteration() {
		int size = 3 * 3 * 1024 * 1024;
		
		Dataset ta = DatasetFactory.createRange(0., size, 1).reshape(3, 3, 1024, 1024);
		
		int[] start = new int[] {1,1,0,0};
		int[] stop = new int[] {3,3,1024,1024};
		int[] step = new int[] {1,1,1,1};
		int[] axes = new int[] {2,3};
		testDatasetAxes(ta, axes, start, stop, step);
	}

	private void testIterationND(int size, Class<? extends Dataset> clazz) {
		Dataset ta;

		TestUtils.verbosePrintf("Size: %d\n", size);

		// 1D
		ta = DatasetFactory.createRange(clazz, 0, size, 1);
		testDataset(ta);

		// 2D
		ta = DatasetFactory.createRange(clazz, 0, size, 1).reshape(16, size / 16);
		TestUtils.verbosePrintf(" Shape: %s\n", Arrays.toString(ta.getShape()));
		testDataset(ta);
		testDatasetAxes(ta, new int[] {0});
		testDatasetAxes(ta, new int[] {1});

		ta = DatasetFactory.createRange(clazz, 0, size, 1).reshape(size / 32, 32);
		TestUtils.verbosePrintf(" Shape: %s\n", Arrays.toString(ta.getShape()));
		testDataset(ta);
		testDatasetAxes(ta, new int[] {0});
		testDatasetAxes(ta, new int[] {1});

		// 3D
		ta = DatasetFactory.createRange(clazz, 0, size, 1).reshape(16, 8, size / (16 * 8));
		TestUtils.verbosePrintf(" Shape: %s\n", Arrays.toString(ta.getShape()));
		testDataset(ta);
		testDatasetAxes(ta, new int[] {0});
		testDatasetAxes(ta, new int[] {2});
		testDatasetAxes(ta, new int[] {0,1});
		testDatasetAxes(ta, new int[] {0,2});

		ta = DatasetFactory.createRange(clazz, 0, size, 1).reshape(size / (16 * 8), 16, 8);
		TestUtils.verbosePrintf(" Shape: %s\n", Arrays.toString(ta.getShape()));
		testDataset(ta);
		testDatasetAxes(ta, new int[] {0});
		testDatasetAxes(ta, new int[] {2});
		testDatasetAxes(ta, new int[] {0,1});
		testDatasetAxes(ta, new int[] {0,2});

	}

	private void testDataset(Dataset ta) {
		PositionIterator iter = ta.getPositionIterator();
		int[] pos = iter.getPos();

		assertArrayEquals(ta.getShapeRef(), iter.getShape());
		for (int i = 0; iter.hasNext(); i++) {
			assertEquals(i, ta.getDouble(pos), 1e-5*i);
		}
	}

	private void testDatasetAxes(Dataset ta, int[] axes) {
		int[] shape = ta.getShapeRef();
		int rank = shape.length;
		int[] step = new int[rank];
		Arrays.fill(step, 1);
		int[] start = new int[rank];
		int[] stop = shape.clone();
		testDatasetAxes(ta, axes, start , stop, step);
	}

	private void testDatasetAxes(Dataset ta, int[] axes, int[] start, int[] stop, int[] step) {
		int[] shape = ta.getShapeRef();
		PositionIterator iter = new PositionIterator(shape, start, stop, step, axes);
		int[] pos = iter.getPos();
		int endrank = shape.length - 1;
		int[] tpos = start.clone();

		for (int i = 0; i < axes.length; i++) {
			step[axes[i]] = 0;
		}
		for (int i = 0; i <= endrank; i++) {
			int s = iter.getShape()[i];
			if (step[i] > 0) {
				assertEquals(s, (stop[i] - start[i] - 1)/step[i] + 1);
			} else if (step[i] < 0) {
				assertEquals(s, (stop[i] - start[i] + 1)/step[i] + 1);
			} else {
				assertEquals(s, 1);
			}
		}

		for (; iter.hasNext();) {
//			System.out.println("        " + Arrays.toString(pos));
			for (int j = 0; j <= endrank; j++) {
				assertEquals("  Axes: " + Arrays.toString(axes) + "; shape: " + Arrays.toString(shape) + "; dim " + j,
						tpos[j], pos[j], 1e-5*tpos[j]);
			}

			int j = endrank;
			for (; j >= 0; j--) {
				if (step[j] > 0) {
					tpos[j] += step[j];
					if (tpos[j] >= stop[j]) {
						tpos[j] = start[j];
					} else {
						break;
					}
				}
			}

		}
	}

}
