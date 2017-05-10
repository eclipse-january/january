/*-
 * Copyright (c) 2017 Kichwa Coders Ltd. and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.january.asserts.TestUtils;
import org.junit.Test;

public class DatasetUtilsTest {

	@Test
	public void testSplit() {
		Dataset dataset = DatasetFactory.createFromObject(new Integer[] { 1, 2, 3 });
		Dataset expected1 = DatasetFactory.createFromObject(new Integer[] { 1 });
		Dataset expected2 = DatasetFactory.createFromObject(new Integer[] { 2, 3 });
		List<Dataset> expected = new ArrayList<Dataset>();
		expected.add(expected1);
		expected.add(expected2);
		int[] indices = { 1 };
		List<Dataset> actual = DatasetUtils.split(dataset, indices, 0);
		if (actual.size() != expected.size())
			fail();
		for (int i = 0; i < expected.size(); i++) {
			TestUtils.assertDatasetEquals(actual.get(i), expected.get(i));
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSplit2() {
		Dataset dataset = DatasetFactory.createFromObject(new Integer[] { 1, 2, 3 });		
		Dataset expected1 = DatasetFactory.zeros(1, new int[] { 0 }, dataset.getDType());
		Dataset expected2 = DatasetFactory.createFromObject(new Integer[] { 1, 2, 3 });
		List<Dataset> expected = new ArrayList<Dataset>();
		expected.add(expected1);
		expected.add(expected2);
		int[] indices = { 4 };
		List<Dataset> actual = DatasetUtils.split(dataset, indices, 0);
		if (actual.size() != expected.size())
			fail();
		for (int i = 0; i < expected.size(); i++) {
			TestUtils.assertDatasetEquals(actual.get(i), expected.get(i));
		}
	}

	@Test
	public void testSplitEqual() {
		Dataset dataset = DatasetFactory.createFromObject(new Integer[] { 1, 2, 3, 4 });
		Dataset expected1 = DatasetFactory.createFromObject(new Integer[] { 1, 2 });
		Dataset expected2 = DatasetFactory.createFromObject(new Integer[] { 3, 4 });
		List<Dataset> expected = new ArrayList<Dataset>();
		expected.add(expected1);
		expected.add(expected2);
		List<Dataset> actual = DatasetUtils.split(dataset, 2, 0, false);
		if (actual.size() != expected.size())
			fail();
		for (int i = 0; i < expected.size(); i++) {
			TestUtils.assertDatasetEquals(actual.get(i), expected.get(i));
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSplitEqual2() {
		Dataset dataset = DatasetFactory.createFromObject(new Integer[] { 1, 2, 3, 4 });
		Dataset expected1 = DatasetFactory.createFromObject(new Integer[] { 1 });
		Dataset expected2 = DatasetFactory.createFromObject(new Integer[] { 2 });
		Dataset expected3 = DatasetFactory.createFromObject(new Integer[] { 3 });
		Dataset expected4 = DatasetFactory.createFromObject(new Integer[] { 4 });
		Dataset expected5 = DatasetFactory.zeros(1, new int[] { 0 }, dataset.getDType());
		List<Dataset> expected = new ArrayList<Dataset>();
		expected.add(expected1);
		expected.add(expected2);
		expected.add(expected3);
		expected.add(expected4);
		expected.add(expected5);
		List<Dataset> actual = DatasetUtils.split(dataset, 6, 0, false);
		if (actual.size() != expected.size())
			fail();
		for (int i = 0; i < expected.size(); i++) {
			TestUtils.assertDatasetEquals(actual.get(i), expected.get(i));
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSplitEqualException() {
		Dataset dataset = DatasetFactory.createFromObject(new Integer[] { 1, 2, 3, 4 });
		Dataset expected1 = DatasetFactory.createFromObject(new Integer[] { 1, 2 });
		Dataset expected2 = DatasetFactory.createFromObject(new Integer[] { 3, 4 });
		List<Dataset> expected = new ArrayList<Dataset>();
		expected.add(expected1);
		expected.add(expected2);
		DatasetUtils.split(dataset, 3, 0, true);
	}

}
