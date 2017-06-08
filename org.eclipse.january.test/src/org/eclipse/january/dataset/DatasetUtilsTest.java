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
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DatasetUtilsTest {

	@Test(expected = IllegalArgumentException.class)
	public void testSplitException() {
		Dataset dataset = DatasetFactory.createFromObject(new Integer[] { 1, 2, 3 });
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
		ByteDataset pos = DatasetFactory.createFromObject(ByteDataset.class, new byte[] {0, 1, 127});
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(ShortDataset.class, new short[] {0, 1, 127}), DatasetUtils.makeUnsigned(pos, false));
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(ByteDataset.class, new byte[] {0, 1, 127}), DatasetUtils.makeUnsigned(pos, true));

		ByteDataset neg = DatasetFactory.createFromObject(ByteDataset.class, new byte[] {0, -1, -128});
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(ShortDataset.class, new short[] {0, 255, 128}), DatasetUtils.makeUnsigned(neg, false));
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(ShortDataset.class, new short[] {0, 255, 128}), DatasetUtils.makeUnsigned(neg, true));
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
	
}
