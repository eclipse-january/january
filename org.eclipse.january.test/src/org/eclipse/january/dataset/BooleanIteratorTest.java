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
import java.util.List;

import org.eclipse.january.asserts.TestUtils;
import org.junit.Before;
import org.junit.Test;

public class BooleanIteratorTest {
	Dataset a, b;

	@Before
	public void setUpClass() {
		a = DatasetFactory.createFromObject(new double[] { 0, 1, 3, 5, -7, -9 });
		b = DatasetFactory.createFromObject(new double[] { 0.01, 1.2, 2.9, 5, -7.1, -9 });
	}

	@Test
	public void testEqualTo() {
		Dataset c = a.clone().reshape(2, 3);
		BooleanDataset s = DatasetFactory.createFromObject(BooleanDataset.class, new boolean[] {false, true, false, true, false, true});
		s.setShape(2, 3);

		List<Integer> inds = new ArrayList<Integer>();

		BooleanIterator iter = c.getBooleanIterator(s);
		while (iter.hasNext())
			inds.add((int) c.getElementLongAbs(iter.index));

		TestUtils.assertDatasetEquals(DatasetFactory.createFromList(IntegerDataset.class, inds), DatasetFactory.createFromObject(IntegerDataset.class, new int[] {1,5,-9}, null));

		iter = c.getBooleanIterator(s, false);
		inds.clear();
		while (iter.hasNext())
			inds.add((int) c.getElementLongAbs(iter.index));

		TestUtils.assertDatasetEquals(DatasetFactory.createFromList(IntegerDataset.class, inds), DatasetFactory.createFromObject(IntegerDataset.class, new int[] {0, 3,-7}, null));
	}

	int size = 1024;

	@Test
	public void testBooleanIterator() {

		Dataset choice = null;
		int count = size;

		// null choice, null output
		testIterator(choice, count, null);

		// null choice, match output
		testIterator(choice, count, DatasetFactory.zeros(size));

		// null choice, broadcast to output
		testIterator(choice, count, DatasetFactory.zeros(3, size));

		// choose every 7th
		choice = DatasetFactory.zeros(size);
		count = 0;
		for (int i = 1; i < size; i += 7) {
			choice.set(1, i);
			count++;
		}
		testIterator(choice, count, null);

		testIterator(choice, count, DatasetFactory.zeros(size));

		testIterator(choice, count, DatasetFactory.zeros(3, size));
	}

	@Test
	public void testBroadcastBooleanIterator() {

		// null choice
		Dataset choice = null;
		int count = size;

		testBroadcastIterator(choice, count, null);

		testBroadcastIterator(choice, count, DatasetFactory.zeros(size));

		testBroadcastIterator(choice, count, DatasetFactory.zeros(3, size));

		// null output
		choice = DatasetFactory.zeros(size);
		count = 0;
		for (int i = 1; i < size; i += 7) {
			choice.set(1, i);
			count++;
		}

		testBroadcastIterator(choice, count, null);

		testBroadcastIterator(choice, count, DatasetFactory.zeros(size));

		testBroadcastIterator(choice, count, DatasetFactory.zeros(3, size));
	}

	private void testIterator(Dataset choice, int count, Dataset output) {
		Dataset ta;
		Dataset ch = null;
		Dataset out = null;

		// 0D
		ta = DatasetFactory.zeros(new int[] {});
		if (choice != null) {
			ch = DatasetFactory.ones(new int[] {});
		}
		if (output != null) {
			out = DatasetFactory.zeros(new int[] {});
		}
		testDataset(ta, out, BooleanIterator.createIterator(ta, ch, out), 1);

		if (choice != null) {
			ch = DatasetFactory.zeros(new int[] {});
			if (output != null) {
				out = DatasetFactory.zeros(new int[] {});
			}
			testDataset(ta, out, BooleanIterator.createIterator(ta, ch, out), 0);
		}

		// 1D
		ta = DatasetFactory.createRange(DoubleDataset.class, 0, size, 1);
		if (choice != null) {
			ch = choice.reshape(ta.getShapeRef());
		}
		if (output != null) {
			out = output;
			out.fill(0);
		}
		testDataset(ta, out, BooleanIterator.createIterator(ta, ch, out), count);

		// 2D
		ta = ta.reshape(16, size / 16);
		TestUtils.verbosePrintf(" Shape: %s\n", Arrays.toString(ta.getShape()));
		if (choice != null) {
			ch = choice.reshape(ta.getShapeRef());
		}
		if (output != null) {
			int nRank = output.getRank() + 1;
			int[] nShape = Arrays.copyOf(output.getShapeRef(), nRank);
			System.arraycopy(ta.getShapeRef(), 0, nShape, nRank - 2, 2);
			out = output.reshape(nShape);
			out.fill(0);
		}
		testDataset(ta, out, BooleanIterator.createIterator(ta, ch, out), count);

		ta = ta.reshape(size / 32, 32);
		TestUtils.verbosePrintf(" Shape: %s\n", Arrays.toString(ta.getShape()));
		if (choice != null) {
			ch = choice.reshape(ta.getShapeRef());
		}
		if (output != null) {
			int nRank = output.getRank() + 1;
			int[] nShape = Arrays.copyOf(output.getShapeRef(), nRank);
			System.arraycopy(ta.getShapeRef(), 0, nShape, nRank - 2, 2);
			out = output.reshape(nShape);
			out.fill(0);
		}
		testDataset(ta, out, BooleanIterator.createIterator(ta, ch, out), count);

		// 3D
		ta = ta.reshape(16, 8, size / (16 * 8));
		TestUtils.verbosePrintf(" Shape: %s\n", Arrays.toString(ta.getShape()));
		if (choice != null) {
			ch = choice.reshape(ta.getShapeRef());
		}
		if (output != null) {
			int nRank = output.getRank() + 2;
			int[] nShape = Arrays.copyOf(output.getShapeRef(), nRank);
			System.arraycopy(ta.getShapeRef(), 0, nShape, nRank - 3, 3);
			out = output.reshape(nShape);
			out.fill(0);
		}
		testDataset(ta, out, BooleanIterator.createIterator(ta, ch, out), count);

		ta = ta.reshape(size / (16 * 8), 16, 8);
		TestUtils.verbosePrintf(" Shape: %s\n", Arrays.toString(ta.getShape()));
		if (choice != null) {
			ch = choice.reshape(ta.getShapeRef());
		}
		if (output != null) {
			int nRank = output.getRank() + 2;
			int[] nShape = Arrays.copyOf(output.getShapeRef(), nRank);
			System.arraycopy(ta.getShapeRef(), 0, nShape, nRank - 3, 3);
			out = output.reshape(nShape);
			out.fill(0);
		}
		testDataset(ta, out, BooleanIterator.createIterator(ta, ch, out), count);
	}

	private void testBroadcastIterator(Dataset choice, int count, Dataset output) {
		Dataset ta;
		Dataset ch = null;
		Dataset out = null;

		// 0D
		ta = DatasetFactory.createRange(DoubleDataset.class, 0, size, 1);
		ta = ta.getSliceView(new Slice(size - 2, size - 1, 1));
		ta.setShape(new int[0]);
		if (choice != null) {
			ch = DatasetFactory.ones(new int[] {});
		}
		if (output != null) {
			out = DatasetFactory.zeros(new int[] {});
		}
		testDataset(ta, out, BooleanIterator.createIterator(ta, ch, out), 1);

		if (choice != null) {
			ch = DatasetFactory.zeros(new int[] {});
			if (output != null) {
				out = DatasetFactory.zeros(new int[] {});
			}
			testDataset(ta, out, BooleanIterator.createIterator(ta, ch, out), 0);
		}

		// 1D
		ta = DatasetFactory.createRange(DoubleDataset.class, 0, size, 1);
		ta = ta.getSliceView(new Slice(null, null, -1));
		if (choice != null) {
			ch = choice.reshape(ta.getShapeRef());
		}
		if (output != null) {
			out = output;
			out.fill(0);
		}
		testDataset(ta, out, BooleanIterator.createIterator(ta, ch, out), count);

		// 2D
		ta = ta.reshape(16, size / 16);
		TestUtils.verbosePrintf(" Shape: %s\n", Arrays.toString(ta.getShape()));
		if (choice != null) {
			ch = choice.reshape(ta.getShapeRef());
		}
		if (output != null) {
			int nRank = output.getRank() + 1;
			int[] nShape = Arrays.copyOf(output.getShapeRef(), nRank);
			System.arraycopy(ta.getShapeRef(), 0, nShape, nRank - 2, 2);
			out = output.reshape(nShape);
			out.fill(0);
		}
		testDataset(ta, out, BooleanIterator.createIterator(ta, ch, out), count);

		ta = ta.reshape(size / 32, 32);
		TestUtils.verbosePrintf(" Shape: %s\n", Arrays.toString(ta.getShape()));
		if (choice != null) {
			ch = choice.reshape(ta.getShapeRef());
		}
		if (output != null) {
			int nRank = output.getRank() + 1;
			int[] nShape = Arrays.copyOf(output.getShapeRef(), nRank);
			System.arraycopy(ta.getShapeRef(), 0, nShape, nRank - 2, 2);
			out = output.reshape(nShape);
			out.fill(0);
		}
		testDataset(ta, out, BooleanIterator.createIterator(ta, ch, out), count);

		// 3D
		ta = ta.reshape(16, 8, size / (16 * 8));
		TestUtils.verbosePrintf(" Shape: %s\n", Arrays.toString(ta.getShape()));
		if (choice != null) {
			ch = choice.reshape(ta.getShapeRef());
		}
		if (output != null) {
			int nRank = output.getRank() + 2;
			int[] nShape = Arrays.copyOf(output.getShapeRef(), nRank);
			System.arraycopy(ta.getShapeRef(), 0, nShape, nRank - 3, 3);
			out = output.reshape(nShape);
			out.fill(0);
		}
		testDataset(ta, out, BooleanIterator.createIterator(ta, ch, out), count);

		ta = ta.reshape(size / (16 * 8), 16, 8);
		TestUtils.verbosePrintf(" Shape: %s\n", Arrays.toString(ta.getShape()));
		if (choice != null) {
			ch = choice.reshape(ta.getShapeRef());
		}
		if (output != null) {
			int nRank = output.getRank() + 2;
			int[] nShape = Arrays.copyOf(output.getShapeRef(), nRank);
			System.arraycopy(ta.getShapeRef(), 0, nShape, nRank - 3, 3);
			out = output.reshape(nShape);
			out.fill(0);
		}
		testDataset(ta, out, BooleanIterator.createIterator(ta, ch, out), count);
	}

	private void testDataset(Dataset ta, Dataset out, BooleanIterator iter, int counts) {
		int counted = 0;
		while (iter.hasNext()) {
			counted++;
			if (out != null) {
				out.setObjectAbs(iter.oIndex, 1);
			}
		}
		if (out != null) {
			assertEquals((counts * out.getSize()) / ta.getSize(), counted);
			assertEquals((counts * out.getSize()) / ta.getSize(), ((Number) out.sum()).intValue());
		} else {
			assertEquals(counts, counted);
		}

		iter.reset();
		counted = 0;
		while (iter.hasNext()) {
			counted++;
			if (out != null) {
				out.setObjectAbs(iter.oIndex, 1);
			}
		}
		if (out != null) {
			assertEquals((counts * out.getSize()) / ta.getSize(), counted);
			assertEquals((counts * out.getSize()) / ta.getSize(), ((Number) out.sum()).intValue());
		} else {
			assertEquals(counts, counted);
		}
	}
}
