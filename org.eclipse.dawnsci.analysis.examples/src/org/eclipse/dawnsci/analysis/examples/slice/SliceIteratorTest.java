/*
 * Copyright (c) 2012 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.examples.slice;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.eclipse.dawnsci.analysis.dataset.impl.Dataset;
import org.eclipse.dawnsci.analysis.dataset.impl.DatasetFactory;
import org.eclipse.dawnsci.analysis.dataset.impl.SliceIterator;
import org.junit.Test;

/**
 *
 */
public class SliceIteratorTest {
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
		testDatasetSteps(ta, new int[] {});
		testDatasetAxes(ta, new boolean[] {});

		// 1D
		ta = DatasetFactory.createRange(0, size, 1, type);
		testDataset(ta);
		testDatasetSteps(ta, new int[] {2});
		testDatasetSteps(ta, new int[] {-3});
		testDatasetAxes(ta, new boolean[] {true});

		// 2D
		ta.setShape(16, size / 16);
		System.out.println(" Shape: " + Arrays.toString(ta.getShape()));
		testDataset(ta);
		testDatasetSteps(ta, new int[] {1, 2});
		testDatasetSteps(ta, new int[] {3, 1});
		testDatasetAxes(ta, new boolean[] {true, true});
		testDatasetAxes(ta, new boolean[] {true, false});
		testDatasetAxes(ta, new boolean[] {false, true});

		ta.setShape(size / 32, 32);
		System.out.println(" Shape: " + Arrays.toString(ta.getShape()));
		testDataset(ta);
		testDatasetSteps(ta, new int[] {1, 2});
		testDatasetSteps(ta, new int[] {3, 1});
		testDatasetAxes(ta, new boolean[] {true, true});
		testDatasetAxes(ta, new boolean[] {true, false});
		testDatasetAxes(ta, new boolean[] {false, true});

		// 3D
		ta.setShape(16, 8, size / (16 * 8));
		System.out.println(" Shape: " + Arrays.toString(ta.getShape()));
		testDataset(ta);
		testDatasetSteps(ta, new int[] {1, 1, 3});
		testDatasetSteps(ta, new int[] {1, 2, 1});
		testDatasetSteps(ta, new int[] {3, 1, 1});
		testDatasetSteps(ta, new int[] {3, 1, 2});
		testDatasetSteps(ta, new int[] {3, -1, 2});
		testDatasetAxes(ta, new boolean[] {true, true, true});
		testDatasetAxes(ta, new boolean[] {true, true, false});
		testDatasetAxes(ta, new boolean[] {true, false, true});
		testDatasetAxes(ta, new boolean[] {true, false, false});
		testDatasetAxes(ta, new boolean[] {false, true, true});
		testDatasetAxes(ta, new boolean[] {false, true, false});
		testDatasetAxes(ta, new boolean[] {false, false, true});
		testDatasetAxes(ta, new boolean[] {false, false, false});

		ta.setShape(size / (16 * 8), 16, 8);
		System.out.println(" Shape: " + Arrays.toString(ta.getShape()));
		testDataset(ta);
		testDatasetSteps(ta, new int[] {1, 1, 3});
		testDatasetSteps(ta, new int[] {1, 2, 1});
		testDatasetSteps(ta, new int[] {3, 1, 1});
		testDatasetSteps(ta, new int[] {3, 1, 2});
		testDatasetSteps(ta, new int[] {3, -1, 2});
		testDatasetAxes(ta, new boolean[] {true, true, true});
		testDatasetAxes(ta, new boolean[] {true, true, false});
		testDatasetAxes(ta, new boolean[] {true, false, true});
		testDatasetAxes(ta, new boolean[] {true, false, false});
		testDatasetAxes(ta, new boolean[] {false, true, true});
		testDatasetAxes(ta, new boolean[] {false, true, false});
		testDatasetAxes(ta, new boolean[] {false, false, true});
		testDatasetAxes(ta, new boolean[] {false, false, false});

	}

	private void testDataset(Dataset ta) {
		SliceIterator iter = (SliceIterator) ta.getSliceIterator(null, null, null);
		int[] pos = iter.getPos();

		for (int i = 0; iter.hasNext(); i++) {
			assertEquals(i, ta.getDouble(pos), 1e-5*i);
		}
	}

	private void testDatasetSteps(Dataset ta, int[] step) {
		SliceIterator iter = (SliceIterator) ta.getSliceIterator(null, null, step);
		int[] pos = iter.getPos();
		int[] shape = ta.getShapeRef();
		int endrank = shape.length - 1;
		int[] tpos = new int[shape.length];

		for (int j = 0; j <= endrank; j++) {
			if (step[j] < 0)
				tpos[j] = shape[j] - 1;
		}

		while (iter.hasNext()) {
//			System.out.println("        " + Arrays.toString(pos));
			for (int j = 0; j <= endrank; j++) {
				assertEquals("  step: " + Arrays.toString(step) + "; shape: " + Arrays.toString(shape) + "; dim " + j,
						tpos[j], pos[j], 1e-5*tpos[j]);
			}

			int j = endrank;
			for (; j >= 0; j--) {
				if (step[j] > 0) {
					tpos[j] += step[j];
					if (tpos[j] >= shape[j]) {
						tpos[j] = 0;
					} else {
						break;
					}
				} else {
					tpos[j] += step[j];
					if (tpos[j] < 0) {
						tpos[j] = shape[j] - 1;
					} else {
						break;
					}
				}
			}

		}
	}

	private void testDatasetAxes(Dataset ta, boolean[] axes) {
		SliceIterator iter = ta.getSliceIteratorFromAxes(null, axes);
		int[] pos = iter.getPos();
		int[] shape = ta.getShapeRef();
		int endrank = shape.length - 1;
		int[] tpos = new int[shape.length];

		while (iter.hasNext()) {
//			System.out.println("        " + Arrays.toString(pos));
			for (int j = 0; j <= endrank; j++) {
				assertEquals("  axes: " + Arrays.toString(axes) + "; shape: " + Arrays.toString(shape) + "; dim " + j,
						tpos[j], pos[j], 1e-5*tpos[j]);
			}

			int j = endrank;
			for (; j >= 0; j--) {
				if (axes[j]) {
					tpos[j]++;
					if (tpos[j] >= shape[j]) {
						tpos[j] = 0;
					} else {
						break;
					}
				}
			}
		}
	}
}
