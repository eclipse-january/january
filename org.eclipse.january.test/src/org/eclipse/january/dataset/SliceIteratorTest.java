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
import static org.junit.Assert.assertFalse;

import java.util.Arrays;

import org.eclipse.january.asserts.TestUtils;
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
		int size = 1024;
		testIterationsND(size, DoubleDataset.class);

		testIterationsND(size, ComplexDoubleDataset.class);
	}

	@Test
	public void testZeroSizedIteration() {
		Dataset ta = DatasetFactory.createRange(24);
		IndexIterator it = ta.getSliceIterator(null, new int[] {0}, null);

		assertFalse(it.hasNext());
	}

	private void testIterationsND(int size, Class<? extends Dataset> clazz) {
		Dataset ta;

		TestUtils.verbosePrintf("Size: %d\n", size);

		// 0D
		ta = DatasetFactory.zeros(clazz, new int[] {});
		testDataset(ta);
		testDatasetSteps(ta, new int[] {});
		testDatasetSlice(ta, new int[] {}, new int[] {});
		testDatasetAxes(ta, new boolean[] {});

		// 1D
		ta = DatasetFactory.createRange(clazz, 0, size, 1);
		testDataset(ta);
		testDatasetSteps(ta, new int[] {2});
		testDatasetSteps(ta.getSliceView(new Slice(null, null, -1)), new int[] {2});
		testDatasetSteps(ta, new int[] {-3});
		testDatasetSlice(ta, new int[] {size/3}, new int[] {2*size/3});
		testDatasetSlice(ta.getSliceView(new Slice(null, null, -1)), new int[] {2*size/3}, new int[] {size/3});
		testDatasetAxes(ta, new boolean[] {true});

		// 2D
		ta.setShape(16, size / 16);
		TestUtils.verbosePrintf(" Shape: %s\n", Arrays.toString(ta.getShapeRef()));
		testDataset(ta);
		testDatasetSteps(ta, new int[] {1, 2});
		testDatasetSteps(ta, new int[] {3, 1});
		int l = size/16;
		testDatasetSlice(ta, new int[] {2, l/3}, new int[] {12, 2*l/3});
		testDatasetSlice(ta.getSliceView(new Slice(null, null, -1)), new int[] {12, l/3}, new int[] {2, 2*l/3});
		testDatasetAxes(ta, new boolean[] {true, true});
		testDatasetAxes(ta, new boolean[] {true, false});
		testDatasetAxes(ta, new boolean[] {false, true});

		ta.setShape(size / 32, 32);
		TestUtils.verbosePrintf(" Shape: %s\n", Arrays.toString(ta.getShapeRef()));
		testDataset(ta);
		testDatasetSteps(ta, new int[] {1, 2});
		testDatasetSteps(ta, new int[] {3, 1});
		testDatasetAxes(ta, new boolean[] {true, true});
		testDatasetAxes(ta, new boolean[] {true, false});
		testDatasetAxes(ta, new boolean[] {false, true});

		// 3D
		ta.setShape(16, 8, size / (16 * 8));
		TestUtils.verbosePrintf(" Shape: %s\n", Arrays.toString(ta.getShapeRef()));
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
		TestUtils.verbosePrintf(" Shape: %s\n", Arrays.toString(ta.getShapeRef()));
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
//			TestUtils.verbosePrintf("        %s\n", Arrays.toString(pos));
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

	private void testDatasetSlice(Dataset ta, int[] start, int[] stop) {
		SliceIterator iter = (SliceIterator) ta.getSliceIterator(start, stop, null);
		int[] pos = iter.getPos();
		int[] shape = ta.getShapeRef();
		int endrank = shape.length - 1;
		int[] tpos = new int[shape.length];

		for (int j = 0; j <= endrank; j++) {
			tpos[j] = start[j];
		}

		while (iter.hasNext()) {
//			 TestUtils.verbosePrintf("        %s\n", Arrays.toString(pos));
			for (int j = 0; j <= endrank; j++) {
				assertEquals(" start: " + Arrays.toString(start) + "; stop: " + Arrays.toString(stop) + "; dim " + j,
						tpos[j], pos[j], 1e-5 * tpos[j]);
			}

			int j = endrank;
			for (; j >= 0; j--) {
				tpos[j] += 1;
				if (tpos[j] >= stop[j]) {
					tpos[j] = start[j];
				} else {
					break;
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
//			TestUtils.verbosePrintf("        %s\n", Arrays.toString(pos));
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
