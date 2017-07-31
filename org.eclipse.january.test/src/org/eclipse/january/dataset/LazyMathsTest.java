/*-
 * Copyright (c) 2012, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import org.eclipse.january.asserts.TestUtils;
import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.dataset.LazyMaths;
import org.eclipse.january.dataset.Maths;
import org.junit.Before;
import org.junit.Test;

public class LazyMathsTest {

	private ILazyDataset a2x2L;
	private ILazyDataset b4x4x4x4L;
	private ILazyDataset c4x5x6x7L;
	private Dataset a2x2D;
	private Dataset b4x4x4x4D;
	
	@Before
	public void init() throws Exception {
		a2x2L = LazyDataset.createLazyDataset(DatasetFactory.createRange(4).reshape(2, 2));
		a2x2D = DatasetUtils.sliceAndConvertLazyDataset(a2x2L);
		b4x4x4x4L = LazyDataset.createLazyDataset(DatasetFactory.createRange(256).reshape(4, 4, 4, 4));
		b4x4x4x4D = DatasetUtils.sliceAndConvertLazyDataset(b4x4x4x4L);
		c4x5x6x7L = LazyDataset.createLazyDataset(DatasetFactory.createRange(4 * 5 * 6 * 7).reshape(4, 5, 6, 7));
	}
	
	@Test
	public void testMaxNoAxis() throws Exception {
		// from https://docs.scipy.org/doc/numpy/reference/generated/numpy.amax.html
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(a2x2D.max()), LazyMaths.max(a2x2L));
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(b4x4x4x4D.max()), LazyMaths.max(b4x4x4x4L));
	}

	@Test
	public void testMinNoAxis() throws Exception {
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(a2x2D.min()), LazyMaths.min(a2x2L));
		TestUtils.assertDatasetEquals(DatasetFactory.createFromObject(b4x4x4x4D.min()), LazyMaths.min(b4x4x4x4L));
	}
	
	@Test
	public void testMaxSingleAxis() throws Exception {
		// from https://docs.scipy.org/doc/numpy/reference/generated/numpy.amax.html
		TestUtils.assertDatasetEquals(a2x2D.max(0), LazyMaths.max(a2x2L, 0));
		TestUtils.assertDatasetEquals(a2x2D.max(1), LazyMaths.max(a2x2L, 1));

		for (int i = 0 ; i < 4 ; i++) {
			Dataset expected = b4x4x4x4D.max(i);
			Dataset actual = LazyMaths.max(b4x4x4x4L, i);
			TestUtils.assertDatasetEquals(expected, actual);
		}
	}

	@Test
	public void testMinSingleAxis() throws Exception {
		TestUtils.assertDatasetEquals(a2x2D.min(0), LazyMaths.min(a2x2L, 0));
		TestUtils.assertDatasetEquals(a2x2D.min(1), LazyMaths.min(a2x2L, 1));

		for (int i = 0 ; i < 4 ; i++) {
			Dataset expected = b4x4x4x4D.min(i);
			Dataset actual = LazyMaths.min(b4x4x4x4L, i);
			TestUtils.assertDatasetEquals(expected, actual);
		}
	}

	@Test
	public void testMaxMultipleAxes() throws Exception {
		testMaxMultipleAxes(false);
		testMaxMultipleAxes(true);
	}

	private void testMaxMultipleAxes(boolean allowMaths) throws Exception {
		if (allowMaths)
			LazyMaths.setAllowDatasetMaths(true);

		// there is no equivalent method in Dataset that supports multiple axes, so compare against the output from numpy
		Dataset expected = DatasetFactory.createFromObject(new double[] {15,  31,  47,  63, 79,  95, 111, 127, 143, 159, 175, 191, 207, 223, 239, 255}, 4, 4);
		Dataset actual = LazyMaths.max(b4x4x4x4L, 2, 3);
		TestUtils.assertDatasetEquals(expected, actual);
		// switch axes
		actual = LazyMaths.max(b4x4x4x4L, 3, 2);
		TestUtils.assertDatasetEquals(expected, actual);

		expected = DatasetFactory.createFromObject(new double[] {41,  83, 125, 167, 209, 251, 293, 335, 377, 419, 461, 503, 545, 587, 629, 671, 713, 755, 797, 839}, 4, 5);
		actual = LazyMaths.max(c4x5x6x7L, 2, 3);
		TestUtils.assertDatasetEquals(expected, actual);

		if (allowMaths)
			LazyMaths.setAllowDatasetMaths(false);
	}

	@Test
	public void testMinMultipleAxes() throws Exception {
		testMinMultipleAxes(false);
		testMinMultipleAxes(true);
	}

	private void testMinMultipleAxes(boolean allowMaths) throws Exception {
		if (allowMaths)
			LazyMaths.setAllowDatasetMaths(true);

		// there is no equivalent method in Dataset that supports multiple axes, so compare against the output from numpy
		Dataset expected = DatasetFactory.createFromObject(new double[] {15,  31,  47,  63, 79,  95, 111, 127, 143, 159, 175, 191, 207, 223, 239, 255}, 4, 4).isubtract(15);
		Dataset actual = LazyMaths.min(b4x4x4x4L, 2, 3);
		TestUtils.assertDatasetEquals(expected, actual);
		// switch axes
		actual = LazyMaths.min(b4x4x4x4L, 3, 2);
		TestUtils.assertDatasetEquals(expected, actual);

		expected = DatasetFactory.createFromObject(new double[] {41,  83, 125, 167, 209, 251, 293, 335, 377, 419, 461, 503, 545, 587, 629, 671, 713, 755, 797, 839}, 4, 5).isubtract(41);
		actual = LazyMaths.min(c4x5x6x7L, 2, 3);
		TestUtils.assertDatasetEquals(expected, actual);

		if (allowMaths)
			LazyMaths.setAllowDatasetMaths(false);
	}

	@Test
	public void testSum() throws Exception {
		Dataset a = DatasetFactory.createRange(100);

		TestUtils.assertDatasetEquals(a.sum(0), LazyMaths.sum(a, 0), 1e-9, 1e-15);

		a.setShape(10, 10);
		TestUtils.assertDatasetEquals(a.sum(0), LazyMaths.sum(a, 0), 1e-9, 1e-15);
		TestUtils.assertDatasetEquals(a.sum(1), LazyMaths.sum(a, 1), 1e-9, 1e-15);

		a.setShape(4, 5, 5);
		TestUtils.assertDatasetEquals(a.sum(0), LazyMaths.sum(a, 0), 1e-9, 1e-15);
		TestUtils.assertDatasetEquals(a.sum(1), LazyMaths.sum(a, 1), 1e-9, 1e-15);
		TestUtils.assertDatasetEquals(a.sum(2), LazyMaths.sum(a, 2), 1e-9, 1e-15);

		a.setShape(4, 5, 1, 5);
		TestUtils.assertDatasetEquals(a.sum(0), LazyMaths.sum(a, 0), 1e-9, 1e-15);
		TestUtils.assertDatasetEquals(a.sum(1), LazyMaths.sum(a, 1), 1e-9, 1e-15);
		TestUtils.assertDatasetEquals(a.sum(2), LazyMaths.sum(a, 2), 1e-9, 1e-15);
		TestUtils.assertDatasetEquals(a.sum(3), LazyMaths.sum(a, 3), 1e-9, 1e-15);
	}

	@Test
	public void testSumIgnoreAxes() throws Exception {
		Dataset a = DatasetFactory.createRange(100);

		a.setShape(10, 10);
		// force the use of the varargs sum method by using 1-element arrays
		TestUtils.assertDatasetEquals(a.sum(0), LazyMaths.sum(a, new int[]{1}), 1e-9, 1e-15);
		TestUtils.assertDatasetEquals(a.sum(1), LazyMaths.sum(a, new int[]{0}), 1e-9, 1e-15);

		a.setShape(4, 5, 5);
		TestUtils.assertDatasetEquals(a.sum(0), LazyMaths.sum(a, 1, 2), 1e-9, 1e-15);
		TestUtils.assertDatasetEquals(a.sum(1), LazyMaths.sum(a, 0, 2), 1e-9, 1e-15);
		TestUtils.assertDatasetEquals(a.sum(2), LazyMaths.sum(a, 0, 1), 1e-9, 1e-15);

		a.setShape(4, 5, 1, 5);
		TestUtils.assertDatasetEquals(a.sum(0), LazyMaths.sum(a, 1, 2, 3), 1e-9, 1e-15);
		TestUtils.assertDatasetEquals(a.sum(1), LazyMaths.sum(a, 0, 2, 3), 1e-9, 1e-15);
		TestUtils.assertDatasetEquals(a.sum(2), LazyMaths.sum(a, 0, 1, 3), 1e-9, 1e-15);
		TestUtils.assertDatasetEquals(a.sum(3), LazyMaths.sum(a, 0, 1, 2), 1e-9, 1e-15);
		
		TestUtils.assertDatasetEquals(a.sum(0).sum(0), LazyMaths.sum(a, false, 0, 1), 1e-9, 1e-15);
		TestUtils.assertDatasetEquals(a.sum(1).sum(0), LazyMaths.sum(a, false, 1, 0), 1e-9, 1e-15);
		TestUtils.assertDatasetEquals(a.sum(1).sum(0), LazyMaths.sum(a, false, 0, 1), 1e-9, 1e-15);
		TestUtils.assertDatasetEquals(a.sum(3).sum(2).sum(0), LazyMaths.sum(a, false, 0, 3, 2), 1e-9, 1e-15);
	}

	@Test
	public void testProduct() throws Exception {
		Dataset a = DatasetFactory.createRange(100);
		a.iadd(1.);
		a.idivide(100.);

		TestUtils.assertDatasetEquals(a.product(0), LazyMaths.product(a, 0), 1e-9, 1e-15);

		a.setShape(10, 10);
		TestUtils.assertDatasetEquals(a.product(0), LazyMaths.product(a, 0), 1e-9, 1e-15);
		TestUtils.assertDatasetEquals(a.product(1), LazyMaths.product(a, 1), 1e-9, 1e-15);

		a.setShape(4, 5, 5);
		TestUtils.assertDatasetEquals(a.product(0), LazyMaths.product(a, 0), 1e-9, 1e-15);
		TestUtils.assertDatasetEquals(a.product(1), LazyMaths.product(a, 1), 1e-9, 1e-15);
		TestUtils.assertDatasetEquals(a.product(2), LazyMaths.product(a, 2), 1e-9, 1e-15);

		a.setShape(4, 5, 1, 5);
		TestUtils.assertDatasetEquals(a.product(0), LazyMaths.product(a, 0), 1e-9, 1e-15);
		TestUtils.assertDatasetEquals(a.product(1), LazyMaths.product(a, 1), 1e-9, 1e-15);
		TestUtils.assertDatasetEquals(a.product(2), LazyMaths.product(a, 2), 1e-9, 1e-15);
		TestUtils.assertDatasetEquals(a.product(3), LazyMaths.product(a, 3), 1e-9, 1e-15);
	}
	
	@Test
	public void testMeanIgnore() throws Exception {

		Dataset a = DatasetFactory.createRange(100);
		a.setShape(10, 10);
		TestUtils.assertDatasetEquals(a.mean(1), LazyMaths.mean(a, 0), 1e-9, 1e-15);
		TestUtils.assertDatasetEquals(a.mean(0), LazyMaths.mean(a, 1), 1e-9, 1e-15);

		a.setShape(4, 5, 5);
		TestUtils.assertDatasetEquals(a.mean(2).mean(1),LazyMaths.mean(a, 0), 1e-9, 1e-15);
		TestUtils.assertDatasetEquals(a.mean(2),LazyMaths.mean(a, 0,1), 1e-9, 1e-15);
		TestUtils.assertDatasetEquals(a.mean(0),LazyMaths.mean(a, 1,2), 1e-9, 1e-15);

		a.setShape(4, 5, 1, 5);
		TestUtils.assertDatasetEquals(a.mean(3).mean(2),LazyMaths.mean(a, 0,1), 1e-9, 1e-15);
		TestUtils.assertDatasetEquals(a.mean(3).mean(2).mean(1),LazyMaths.mean(a, 0), 1e-9, 1e-15);
		TestUtils.assertDatasetEquals(a.mean(3).squeeze(),LazyMaths.mean(a, 0,1,2), 1e-9, 1e-15);
		TestUtils.assertDatasetEquals(a.mean(0).mean(0).squeeze(),LazyMaths.mean(a, 2,3), 1e-9, 1e-15);
		
		Dataset er = DatasetFactory.createRange(100);
		a.setShape(10, 10);
		er.setShape(10, 10);
		a.setErrorBuffer(er);

		Dataset e = Maths.sqrt(er.sum(1)).idivide(10);

		TestUtils.assertDatasetEquals(e, LazyMaths.mean(a, 0).getErrors(), 1e-9, 1e-15);

	}
}
