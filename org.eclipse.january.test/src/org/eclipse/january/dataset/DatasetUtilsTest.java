/*-
 * Copyright (c) 2017 Kichwa Coders Ltd. and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.january.asserts.TestUtils;
import org.junit.Test;

public class DatasetUtilsTest {

	@Test
	public void testSplit() {
		Dataset dataset = DatasetFactory.createFromObject(new int[] { 1, 2, 3 });
		Dataset expected1 = DatasetFactory.createFromObject(new int[] { 1 });
		Dataset expected2 = DatasetFactory.createFromObject(new int[] { 2, 3 });
		List<Dataset> expected = new ArrayList<Dataset>();
		expected.add(expected1);
		expected.add(expected2);
		int[] indices = { 1 };

		List<Dataset> actual = DatasetUtils.split(dataset, indices, 0);
		assertEquals(expected.size(), actual.size());
		for (int i = 0; i < expected.size(); i++) {
			TestUtils.assertDatasetEquals(expected.get(i), actual.get(i));
		}

		actual = DatasetUtils.split(dataset, indices, -1);
		assertEquals(expected.size(), actual.size());
		for (int i = 0; i < expected.size(); i++) {
			TestUtils.assertDatasetEquals(expected.get(i), actual.get(i));
		}
	}

	@Test
	public void testSplit2() {
		Dataset dataset = DatasetFactory.createFromObject(new int[] { 1, 2, 3 });
		Dataset expected1 = DatasetFactory.zeros(1, dataset.getClass(), 0);
		Dataset expected2 = DatasetFactory.createFromObject(new int[] { 1, 2, 3 });
		List<Dataset> expected = new ArrayList<Dataset>();
		expected.add(expected1);
		expected.add(expected2);
		int[] indices = { 4 };

		List<Dataset> actual = DatasetUtils.split(dataset, indices, 0);
		assertEquals(expected.size(), actual.size());
		for (int i = 0; i < expected.size(); i++) {
			TestUtils.assertDatasetEquals(expected.get(i), actual.get(i));
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSplitException() {
		Dataset dataset = DatasetFactory.createFromObject(new int[] { 1, 2, 3 });
		int[] indices = { 1 };
		DatasetUtils.split(dataset, indices, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCrossingsException() {
		Dataset xAxis = DatasetFactory.createFromObject(new Double[] { 0.0, 0.0, 0.0 });
		Dataset yAxis = DatasetFactory.createFromObject(new Double[] { 0.0, 0.0 });
		DatasetUtils.crossings(xAxis, yAxis, 0);
	}

	@Test
	public void testMakeUnsigned() {
		ByteDataset pos = DatasetFactory.createFromObject(ByteDataset.class, new byte[] { 0, 1, 127 });
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(ShortDataset.class, new short[] { 0, 1, 127 }),
				DatasetUtils.makeUnsigned(pos, false));
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(ByteDataset.class, new byte[] { 0, 1, 127 }),
				DatasetUtils.makeUnsigned(pos, true));

		ByteDataset neg = DatasetFactory.createFromObject(ByteDataset.class, new byte[] { 0, -1, -128 });
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(ShortDataset.class, new short[] { 0, 255, 128 }),
				DatasetUtils.makeUnsigned(neg, false));
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(ShortDataset.class, new short[] { 0, 255, 128 }),
				DatasetUtils.makeUnsigned(neg, true));
	}

	@Test
	public void testSplitEqual() {
		Dataset dataset = DatasetFactory.createFromObject(new int[] { 1, 2, 3, 4 });
		Dataset expected1 = DatasetFactory.createFromObject(new int[] { 1, 2 });
		Dataset expected2 = DatasetFactory.createFromObject(new int[] { 3, 4 });
		List<Dataset> expected = new ArrayList<Dataset>();
		expected.add(expected1);
		expected.add(expected2);

		List<Dataset> actual = DatasetUtils.split(dataset, 2, 0, false);
		assertEquals(expected.size(), actual.size());
		for (int i = 0; i < expected.size(); i++) {
			TestUtils.assertDatasetEquals(expected.get(i), actual.get(i));
		}

		actual = DatasetUtils.split(dataset, 2, -1, false);
		assertEquals(expected.size(), actual.size());
		for (int i = 0; i < expected.size(); i++) {
			TestUtils.assertDatasetEquals(expected.get(i), actual.get(i));
		}
	}

	@Test
	public void testSplitEqual2() {
		Dataset dataset = DatasetFactory.createFromObject(new int[] { 1, 2, 3, 4 });
		Dataset expected1 = DatasetFactory.createFromObject(new int[] { 1 });
		Dataset expected2 = DatasetFactory.createFromObject(new int[] { 2 });
		Dataset expected3 = DatasetFactory.createFromObject(new int[] { 3 });
		Dataset expected4 = DatasetFactory.createFromObject(new int[] { 4 });
		Dataset expected5 = DatasetFactory.zeros(1, dataset.getClass(), 0);
		List<Dataset> expected = new ArrayList<Dataset>();
		expected.add(expected1);
		expected.add(expected2);
		expected.add(expected3);
		expected.add(expected4);
		expected.add(expected5);

		List<Dataset> actual = DatasetUtils.split(dataset, 6, 0, false);
		assertEquals(expected.size(), actual.size());
		for (int i = 0; i < expected.size(); i++) {
			TestUtils.assertDatasetEquals(expected.get(i), actual.get(i));
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSplitEqualException() {
		Dataset dataset = DatasetFactory.createFromObject(new int[] { 1, 2, 3, 4 });
		Dataset expected1 = DatasetFactory.createFromObject(new int[] { 1, 2 });
		Dataset expected2 = DatasetFactory.createFromObject(new int[] { 3, 4 });
		List<Dataset> expected = new ArrayList<Dataset>();
		expected.add(expected1);
		expected.add(expected2);
		DatasetUtils.split(dataset, 3, 0, true);
	}

	@Test
	public void testRemoveNansAndInfinitiesDouble() {
		double dvalue = 13;
		Dataset dataset = DatasetFactory.createFromObject(
				new Double[][] { { 10.0, 11.0, Double.NaN }, { Double.POSITIVE_INFINITY, Double.MAX_VALUE, 69.0 },
						{ Double.MIN_VALUE, 0.0, Double.NEGATIVE_INFINITY } });
		Dataset expected = DatasetFactory.createFromObject(new Double[][] { { 10.0, 11.0, dvalue },
				{ dvalue, Double.MAX_VALUE, 69.0 }, { Double.MIN_VALUE, 0.0, dvalue } });
		DatasetUtils.removeNansAndInfinities(dataset, dvalue);
		TestUtils.assertDatasetEquals(dataset, expected);
	}

	@Test
	public void testRemoveNansAndInfinitiesFloat() {
		float dvalue = 13;
		Dataset dataset = DatasetFactory.createFromObject(
				new Float[][] { { 10.0f, 11.0f, Float.NaN }, { Float.POSITIVE_INFINITY, Float.MAX_VALUE, 69.0f },
						{ Float.MIN_VALUE, 0.0f, Float.NEGATIVE_INFINITY } });
		Dataset expected = DatasetFactory.createFromObject(new Float[][] { { 10.0f, 11.0f, dvalue },
				{ dvalue, Float.MAX_VALUE, 69.0f }, { Float.MIN_VALUE, 0.0f, dvalue } });
		DatasetUtils.removeNansAndInfinities(dataset, dvalue);
		TestUtils.assertDatasetEquals(dataset, expected);
	}

	@Test
	public void testRemoveNansAndInfinitiesCompoundDouble() {
		double dvalue = 13;
		double[] da = { 0, 0.5, 1, Double.MAX_VALUE, 2, 2.5, 3, 3.5, Double.NEGATIVE_INFINITY, Double.NaN, 5, 5.5, 6,
				6.5, 7, 7.5, 8, 8.5, 9, 9.5, Double.MIN_VALUE, 10.5, 11, Double.POSITIVE_INFINITY };
		double[] eda = { 0, 0.5, 1, Double.MAX_VALUE, 2, 2.5, 3, 3.5, dvalue, dvalue, 5, 5.5, 6, 6.5, 7, 7.5, 8, 8.5, 9,
				9.5, Double.MIN_VALUE, 10.5, 11, dvalue };
		CompoundDoubleDataset dataset = new CompoundDoubleDataset(2, da);
		CompoundDoubleDataset expected = new CompoundDoubleDataset(2, eda);

		DatasetUtils.removeNansAndInfinities(dataset, dvalue);
		TestUtils.assertDatasetEquals(dataset, expected);
	}

	@Test
	public void testRemoveNansAndInfinitiesCompoundFloat() {
		float dvalue = 13;
		float[] da = { 0, 0.5f, 1, Float.MAX_VALUE, 2, 2.5f, 3, 3.5f, Float.NEGATIVE_INFINITY, Float.NaN, 5, 5.5f, 6,
				6.5f, 7, 7.5f, 8, 8.5f, 9, 9.5f, Float.MIN_VALUE, 10.5f, 11, Float.POSITIVE_INFINITY };
		float[] eda = { 0, 0.5f, 1, Float.MAX_VALUE, 2, 2.5f, 3, 3.5f, dvalue, dvalue, 5, 5.5f, 6, 6.5f, 7, 7.5f, 8,
				8.5f, 9, 9.5f, Float.MIN_VALUE, 10.5f, 11, dvalue };
		CompoundFloatDataset dataset = new CompoundFloatDataset(2, da);
		CompoundFloatDataset expected = new CompoundFloatDataset(2, eda);

		DatasetUtils.removeNansAndInfinities(dataset, dvalue);
		TestUtils.assertDatasetEquals(dataset, expected);
	}

	@Test
	public void testRemoveNansAndInfinitiesOther() {
		Number value = 13.0;
		Dataset dataset = DatasetFactory
				.createFromObject(new int[][] { { 10, 11, Integer.MAX_VALUE }, { Integer.MIN_VALUE, 5, 13 } });
		Dataset expected = dataset.clone();
		DatasetUtils.removeNansAndInfinities(dataset, value);
		TestUtils.assertDatasetEquals(dataset, expected);
	}

	@Test
	public void testFindIndexEqualTo() {
		Dataset dataset = DatasetFactory.createFromObject(new Double[] { 5.2, 2.0, 4.8, 13.0, 0.8, 96.0, 13.0 });
		int expected = 3;
		int actual = DatasetUtils.findIndexEqualTo(dataset, 13.0);
		assertEquals(expected, actual);
	}

	@Test
	public void testFindIndexGreaterThan() {
		Dataset dataset = DatasetFactory.createFromObject(new Double[] { 5.2, 2.0, 4.8, 13.0, 0.8, 96.0, 13.0 });
		int expected = 5;
		int actual = DatasetUtils.findIndexGreaterThan(dataset, 50.0);
		assertEquals(expected, actual);
	}

	@Test
	public void testFindIndexGreaterThanOrEqualTo() {
		Dataset dataset = DatasetFactory.createFromObject(new Double[] { 5.2, 2.0, 4.8, 13.0, 0.8, 96.0, 13.0 });
		int expected = 3;
		int actual = DatasetUtils.findIndexGreaterThanOrEqualTo(dataset, 13.0);
		assertEquals(expected, actual);
	}

	@Test
	public void testFindIndexLessThan() {
		Dataset dataset = DatasetFactory.createFromObject(new Double[] { 5.2, 2.0, 4.8, 13.0, 0.8, 96.0, 13.0 });
		int expected = 4;
		int actual = DatasetUtils.findIndexLessThan(dataset, 1.0);
		assertEquals(expected, actual);
	}

	@Test
	public void testFindIndexLesshanOrEqualTo() {
		Dataset dataset = DatasetFactory.createFromObject(new Double[] { 5.2, 2.0, 4.8, 13.0, 0.8, 96.0, 13.0 });
		int expected = 4;
		int actual = DatasetUtils.findIndexLessThanOrEqualTo(dataset, 0.8);
		assertEquals(expected, actual);
	}

	@Test
	public void testCrossings() {
		Dataset dataset = DatasetFactory.createFromObject(new Double[] { 0.8, 1.2, 1.6, 0.4, 0.9, 1.1 });
		List<Double> expected = new ArrayList<Double>();
		expected.add(0.5);
		expected.add(2.5);
		expected.add(4.5);
		List<Double> actual = DatasetUtils.crossings(dataset, 1.0);
		assertEquals(expected, actual);
	}

	@Test
	public void testCrossings2() {
		Dataset yAxis = DatasetFactory.createFromObject(new Double[] { 0.8, 1.2, 1.6, 0.4, 0.9, 1.1 });
		Dataset xAxis = DatasetFactory.createFromObject(new Double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 });
		List<Double> expected = new ArrayList<Double>();
		expected.add(1.5);
		expected.add(3.5);
		expected.add(5.5);
		List<Double> actual = DatasetUtils.crossings(xAxis, yAxis, 1);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCrossings3() {
		Dataset yAxis = DatasetFactory.createFromObject(new Double[] { 0.5, 1.1, 0.9, 1.5 });
		Dataset xAxis = DatasetFactory.createFromObject(new Double[] { 1.0, 2.0, 3.0, 4.0 });
		List<Double> expected = new ArrayList<Double>();
		expected.add(2.5);
		List<Double> actual = DatasetUtils.crossings(xAxis, yAxis, 1, 0.5);
		assertEquals(expected, actual);
	}

	@Test
	public void testNorm() {
		Dataset dataset = DatasetFactory.createFromObject(new int[] { -10, -5, -1, 3, 5, 9, 10 });
		Dataset expected = DatasetFactory.createFromObject(new Double[] { 0.0, 0.25, 0.45, 0.65, 0.75, 0.95, 1.0 });
		Dataset actual = DatasetUtils.norm(dataset);
		TestUtils.assertDatasetEquals(expected, actual);
	}

	@Test
	public void testIndexSort() {
		Dataset a = DatasetFactory.createFromObject(new int[] {0, 3, 1, 2, 2, -1}).reshape(2, 3);
		Dataset e;

		e = DatasetFactory.createFromObject(new int[] {5, 0, 2, 3, 4, 1});
		TestUtils.assertDatasetEquals(e, DatasetUtils.indexSort(a, null));

		e = DatasetFactory.createFromObject(new int[] {0, 1, 1, 1, 0, 0}).reshape(2, 3);
		TestUtils.assertDatasetEquals(e, DatasetUtils.indexSort(a, 0));

		e = DatasetFactory.createFromObject(new int[] {0, 2, 1, 2, 0, 1}).reshape(2, 3);
		TestUtils.assertDatasetEquals(e, DatasetUtils.indexSort(a, 1));
	}
}
