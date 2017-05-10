/*-
 * Copyright (c) 2017 Kichwa Coders Ltd. and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import org.eclipse.january.asserts.TestUtils;
import org.junit.Test;

public class DatasetUtilsTest {

	@Test(expected = IllegalArgumentException.class)
	public void testSplitException() {
		Dataset dataset = DatasetFactory.createFromObject(new Integer[] { 1, 2, 3 });
		int[] indices = { 1 };
		DatasetUtils.split(dataset, indices, 1);
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

}
