/*-
 * Copyright (c) 2012 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.dataset;

import org.eclipse.dawnsci.analysis.api.dataset.DatasetException;
import org.eclipse.dawnsci.analysis.api.dataset.ILazyDataset;
import org.eclipse.dawnsci.analysis.api.dataset.Slice;
import org.eclipse.dawnsci.analysis.api.dataset.SliceND;
import org.eclipse.dawnsci.analysis.asserts.TestUtils;
import org.eclipse.dawnsci.analysis.dataset.impl.Dataset;
import org.eclipse.dawnsci.analysis.dataset.impl.LazyDataset;
import org.eclipse.dawnsci.analysis.dataset.impl.Random;
import org.junit.Assert;
import org.junit.Test;

public class LazyDatasetTest {

	private void setShape(String msg, boolean well, LazyDataset l, int... shape) {
		try {
			l.setShape(shape);
			if (well)
				TestUtils.verbosePrintf("Succeeded setting shape for %s\n", msg);
			else
				Assert.fail("Should have thrown exception for " + msg);
		} catch (IllegalArgumentException iae) {
			// do nothing
			if (well)
				Assert.fail("Unexpected exception for " + msg);
			else
				TestUtils.verbosePrintf("Correctly failed setting shape for %s\n", msg);
		} catch (Exception e) {
			msg += ": " + e.getMessage();
			if (well)
				Assert.fail("Unexpected exception for " + msg);
			else
				Assert.fail("Thrown wrong exception for " + msg);
		}
	}

	@Test
	public void testSetShape() {
		LazyDataset ld = new LazyDataset("", Dataset.INT, new int[] {1, 2, 3, 4}, null);

		setShape("check on same rank", true, ld, 1, 2, 3, 4);
		setShape("check on same rank", false, ld, 1, 2, 3, 5);

		setShape("check on greater rank", true, ld, 1, 1, 1, 2, 3, 4);
		setShape("check on greater rank", false, ld, 1, 2, 2, 3, 5);
		setShape("check on greater rank", false, ld, 2, 1, 2, 3, 4);

		setShape("check on greater rank", true, ld, 2, 3, 4, 1, 1, 1);
		setShape("check on greater rank", true, ld, 1, 1, 2, 3, 4, 1, 1, 1);

		setShape("check on lesser rank", true, ld, 2, 3, 4);
		setShape("check on lesser rank", false, ld, 3, 4);
		setShape("check on lesser rank", false, ld, 2, 3);

		ld = new LazyDataset("", Dataset.INT, new int[] {2, 3, 4, 1}, null);
		setShape("check on lesser rank", true, ld, 2, 3, 4);

		ld = new LazyDataset("", Dataset.INT, new int[] {1, 2, 3, 4, 1}, null);
		setShape("check on lesser rank", true, ld, 2, 3, 4);
	}

	@Test
	public void testGetSlice() throws Exception {
		final int[] shape = new int[] {1, 2, 3, 4};
		final Dataset d = Random.randn(shape);
		LazyDataset ld = LazyDataset.createLazyDataset(d);

		Slice[] slice;
		slice = new Slice[]{null, new Slice(1), null, new Slice(1, 3)};
		Assert.assertEquals("Full slice", d, ld.getSlice());
		Assert.assertEquals("Full slice", d, ld.getSlice((Slice) null));
		Assert.assertEquals("Full slice", d, ld.getSlice((Slice) null, null));
		Assert.assertEquals("Full slice", d, ld.getSlice(null, (SliceND) null));
		Assert.assertEquals("Full slice", d, ld.getSlice(null, null, null));
		Assert.assertEquals("Full slice", d, ld.getSlice(null, null, new int[] {1, 1, 1, 1}));
		Assert.assertEquals("Full slice", d, ld.getSlice(new int[4], null, new int[] {1, 1, 1, 1}));
		Assert.assertEquals("Full slice", d, ld.getSlice(new int[4], new int[] { 1, 2, 3, 4 }, new int[] { 1, 1, 1, 1 }));
		Assert.assertEquals("Part slice", d.getSlice(slice), ld.getSlice(slice));

		Dataset nd;
		ld.setShape(1, 1, 1, 2, 3, 4);
		nd = d.getView();
		nd.setShape(1, 1, 1, 2, 3, 4);
		Assert.assertEquals("Full slice", nd, ld.getSlice());
		slice = new Slice[]{null, null, null, new Slice(1), null, new Slice(1, 3)};
		Assert.assertEquals("Part slice", nd.getSlice(slice), ld.getSlice(slice));

		ld.setShape(2, 3, 4);
		nd = d.getView();
		nd.setShape(2, 3, 4);
		Assert.assertEquals("Full slice", nd, ld.getSlice());
		slice = new Slice[]{new Slice(1), null, new Slice(1, 3)};
		Assert.assertEquals("Part slice", nd.getSlice(slice), ld.getSlice(slice));

		ld.setShape(2, 3, 4, 1, 1, 1);
		nd = d.getView();
		nd.setShape(2, 3, 4, 1, 1, 1);
		Assert.assertEquals("Full slice", nd, ld.getSlice());
		slice = new Slice[]{new Slice(1), null, new Slice(1, 3), null, null, null};
		Assert.assertEquals("Part slice", nd.getSlice(slice), ld.getSlice(slice));

		ld.setShape(1, 2, 3, 4, 1, 1, 1);
		nd = d.getView();
		nd.setShape(1, 2, 3, 4, 1, 1, 1);
		Assert.assertEquals("Full slice", nd, ld.getSlice());
		slice = new Slice[]{null, new Slice(1), null, new Slice(1, 3), null, null, null};
		Assert.assertEquals("Part slice", nd.getSlice(slice), ld.getSlice(slice));

		// test negative slice
		ld.setShape(shape);
		slice = new Slice[]{new Slice(null, null, -1), null, null, null};
		nd = ld.getSlice(slice);
		Assert.assertEquals("Full negative slice", d.getSlice(slice), nd);

		slice = new Slice[]{null, null, null, new Slice(null, null, -1)};
		nd = ld.getSlice(slice);
		Assert.assertEquals("Full negative slice", d.getSlice(slice), nd);
	}

	@Test
	public void testGetSliceView() throws Exception {
		final int[] shape = new int[] {6, 2, 4, 1};
		final Dataset d = Random.randn(shape);
		LazyDataset ld = LazyDataset.createLazyDataset(d);

		Slice[] slice;
		slice = new Slice[]{new Slice(1, null, 3), new Slice(1), new Slice(1, 3), null};
		ILazyDataset l = ld.getSliceView(null, shape, null);
		TestUtils.verbosePrintf("%s\n", l.toString());
		Assert.assertEquals("Full slice", d, l.getSlice());
		l = ld.getSliceView(slice);
		TestUtils.verbosePrintf("%s\n", l.toString());
		Assert.assertEquals("Part slice", d.getSlice(slice), l.getSlice());

		l = ld.getSliceView();
		TestUtils.verbosePrintf("%s\n", l.toString());
		Assert.assertEquals("Full slice", d, l.getSlice());
		l = ld.getSliceView(slice);
		TestUtils.verbosePrintf("%s\n", l.toString());
		Assert.assertEquals("Part slice", d.getSlice(slice), l.getSlice());

		l = ld.getSliceView();
		l.squeezeEnds();
		Assert.assertEquals("Full slice", 3, l.getSlice().getRank());

		// test negative slice views
		slice = new Slice[]{new Slice(null, null, -1), null, null, null};
		l = ld.getSliceView(slice);
		Assert.assertEquals("Full negative slice", d.getSlice(slice), l.getSlice());

		slice = new Slice[]{null, null, null, new Slice(null, null, -1)};
		l = ld.getSliceView(slice);
		Assert.assertEquals("Full negative slice", d.getSlice(slice), l.getSlice());
	}

	@Test
	public void testShape() throws DatasetException {
		Dataset data = Random.rand(new int[] {1, 2, 3, 4});
		data.setName("random");
		LazyDataset ld = LazyDataset.createLazyDataset(data);

		ld.setShape(1, 1, 2, 3, 4, 1);
		Assert.assertArrayEquals(new int[] {1, 1, 2, 3, 4, 1}, ld.getShape());
		TestUtils.assertDatasetEquals(data.reshape(1, 1, 2, 3, 4, 1), ld.getSlice(), true, 1e-14, 1e-14);

		LazyDataset tld = ld.getSliceView();
		Assert.assertArrayEquals(new int[] {1, 1, 2, 3, 4, 1}, tld.getShape());
		TestUtils.assertDatasetEquals(data.reshape(1, 1, 2, 3, 4, 1), tld.getSlice(), true, 1e-14, 1e-14);

		ld.setShape(1, 2, 3, 4);
		tld = ld.getSliceView();
		ld.setShape(1, 1, 2, 3, 4, 1);
		Assert.assertArrayEquals(new int[] {1, 1, 2, 3, 4, 1}, ld.getShape());
		Assert.assertArrayEquals(new int[] {1, 2, 3, 4}, tld.getShape());
		TestUtils.assertDatasetEquals(data.reshape(1, 1, 2, 3, 4, 1), ld.getSlice(), true, 1e-14, 1e-14);
		TestUtils.assertDatasetEquals(data.reshape(1, 1, 2, 3, 4, 1), ld.getSliceView().getSlice(), true, 1e-14, 1e-14);

		tld.setShape(1, 1, 2, 3, 4, 1);
		Assert.assertArrayEquals(new int[] {1, 1, 2, 3, 4, 1}, tld.getShape());
		TestUtils.assertDatasetEquals(data.reshape(1, 1, 2, 3, 4, 1), tld.getSlice(), true, 1e-14, 1e-14);
		TestUtils.assertDatasetEquals(data.reshape(1, 1, 2, 3, 4, 1), tld.getSliceView().getSlice(), true, 1e-14, 1e-14);

		LazyDataset uld = tld.getSliceView();
		Assert.assertArrayEquals(new int[] {1, 1, 2, 3, 4, 1}, uld.getShape());
		TestUtils.assertDatasetEquals(data.reshape(1, 1, 2, 3, 4, 1), uld.getSlice(), true, 1e-14, 1e-14);
		TestUtils.assertDatasetEquals(data.reshape(1, 1, 2, 3, 4, 1), uld.getSliceView().getSlice(), true, 1e-14, 1e-14);

		uld.setShape(2, 3, 4);
		Assert.assertArrayEquals(new int[] {2, 3, 4}, uld.getShape());
		TestUtils.assertDatasetEquals(data.reshape(2, 3, 4), uld.getSlice(), true, 1e-14, 1e-14);
		TestUtils.assertDatasetEquals(data.reshape(2, 3, 4), uld.getSliceView().getSlice(), true, 1e-14, 1e-14);

		Slice[] slice = new Slice[] {null, null, null, new Slice(1, null, 2)};
		ld.setShape(1, 2, 3, 4);
		tld = ld.getSliceView(slice);
		tld.squeezeEnds();
		TestUtils.assertDatasetEquals(data.getSliceView(slice).squeezeEnds(), tld.getSlice(), true, 1e-14, 1e-14);
		TestUtils.assertDatasetEquals(data.getSliceView(slice).squeezeEnds(), tld.getSliceView().getSlice(), true, 1e-14, 1e-14);
	}

	@Test
	public void testTranspose() throws DatasetException {
		Dataset data = Random.rand(new int[] {1, 2, 3, 4});
		data.setName("random");
		LazyDataset ld = LazyDataset.createLazyDataset(data);

		LazyDataset tld = ld.getTransposedView(3, 1, 0, 2);
		Assert.assertEquals(tld.getSize(), ld.getSize());
		Assert.assertArrayEquals(new int[] {4, 2, 1, 3}, tld.getShape());
		TestUtils.assertDatasetEquals(data.getTransposedView(3, 1, 0, 2), tld.getSlice(), true, 1e-14, 1e-14);

		LazyDataset uld = tld.getTransposedView(3, 2, 1, 0);
		Assert.assertArrayEquals(new int[] {3, 1, 2, 4}, uld.getShape());
		TestUtils.assertDatasetEquals(data.getTransposedView(3, 1, 0, 2).getTransposedView(3, 2, 1, 0), uld.getSlice(), true, 1e-14, 1e-14);

		Assert.assertArrayEquals(new int[] {3, 1, 2, 4}, ld.getTransposedView(2, 0, 1, 3).getShape());
		TestUtils.assertDatasetEquals(data.getTransposedView(2, 0, 1, 3), uld.getSlice(), true, 1e-14, 1e-14);

		// set shape of transposed view
		tld.setShape(1, 4, 2, 1, 3, 1);
		Assert.assertArrayEquals(new int[] {1, 4, 2, 1, 3, 1}, tld.getShape());
		TestUtils.assertDatasetEquals(data.getTransposedView(3, 1, 0, 2).reshape(1, 4, 2, 1, 3, 1), tld.getSlice(), true, 1e-14, 1e-14);

		// get transpose of shaped dataset
		ld.setShape(1, 1, 2, 3, 4, 1);
		tld = ld.getTransposedView(3, 1, 0, 2, 4, 5);
		Assert.assertArrayEquals(new int[] {3, 1, 1, 2, 4, 1}, tld.getShape());
		TestUtils.assertDatasetEquals(data.reshape(1, 1, 2, 3, 4, 1).getTransposedView(3, 1, 0, 2, 4, 5), tld.getSlice(), true, 1e-14, 1e-14);

		// get transpose of shaped sliced dataset
		ld.setShape(1, 2, 3, 4);
		tld = ld.getSliceView(null, null, null, new Slice(1, null, 2));
		TestUtils.assertDatasetEquals(data.getSliceView(null, null, null, new Slice(1, null, 2)), tld.getSlice(), true, 1e-14, 1e-14);
		TestUtils.assertDatasetEquals(data.getSliceView(null, null, null, new Slice(1, null, 2)), tld.getSliceView().getSlice(), true, 1e-14, 1e-14);
		uld = tld.getTransposedView(3, 1, 0, 2);
		Assert.assertEquals(tld.getSize(), uld.getSize());
		Assert.assertArrayEquals(new int[] {2, 2, 1, 3}, uld.getShape());
		TestUtils.assertDatasetEquals(data.getSliceView(null, null, null, new Slice(1, null, 2)).getTransposedView(3, 1, 0, 2), uld.getSlice(), true, 1e-14, 1e-14);

		// slice after transpose
		tld = ld.getTransposedView(3, 1, 0, 2);
		TestUtils.assertDatasetEquals(data.getTransposedView(3, 1, 0, 2), tld.getSlice(), true, 1e-14, 1e-14);
		TestUtils.assertDatasetEquals(data.getTransposedView(3, 1, 0, 2), tld.getSliceView().getSlice(), true, 1e-14, 1e-14);
		LazyDataset vld = tld.getSliceView(new Slice(1, null, 2));
		Assert.assertEquals(12, vld.getSize());
		Assert.assertArrayEquals(new int[] {2, 2, 1, 3}, vld.getShape());
		TestUtils.assertDatasetEquals(data.getTransposedView(3, 1, 0, 2).getSliceView(new Slice(1, null, 2)), vld.getSlice(), true, 1e-14, 1e-14);

		// transpose of reshaped transpose
		tld.setShape(1, 4, 2, 1, 3, 1);
		TestUtils.assertDatasetEquals(data.getTransposedView(3, 1, 0, 2).reshape(1, 4, 2, 1, 3, 1), tld.getSlice(), true, 1e-14, 1e-14);
		TestUtils.assertDatasetEquals(data.getTransposedView(3, 1, 0, 2).reshape(1, 4, 2, 1, 3, 1), tld.getSliceView().getSlice(), true, 1e-14, 1e-14);
		uld = tld.getTransposedView();
		Assert.assertArrayEquals(new int[] {1, 3, 1, 2, 4, 1}, uld.getShape());
		TestUtils.assertDatasetEquals(data.getTransposedView(3, 1, 0, 2).reshape(1, 4, 2, 1, 3, 1).getTransposedView(), uld.getSlice(), true, 1e-14, 1e-14);
		uld.setShape(3, 1, 2, 4, 1);
		Assert.assertArrayEquals(new int[] {3, 1, 2, 4, 1}, uld.getShape());
		TestUtils.assertDatasetEquals(data.getTransposedView(3, 1, 0, 2).reshape(1, 4, 2, 1, 3, 1).getTransposedView().reshape(3, 1, 2, 4, 1),
				uld.getSlice(), true, 1e-14, 1e-14);
	}

	@Test
	public void testSlicePadRankSlice() throws DatasetException {
		Dataset data = Random.rand(new int[] { 10 });
		data.setName("random");
		LazyDataset ld = LazyDataset.createLazyDataset(data);

		LazyDataset sv = ld.getSliceView(new int[] { 0 }, new int[] { 5 }, null);
		sv.setShape(new int[] { 1, 1, 5 });
		LazyDataset view = sv.getSliceView(new int[] { 0, 0, 0 }, new int[] { 1, 1, 4 }, null);
		TestUtils.assertDatasetEquals(data.getSliceView(new Slice(5)).reshape(1, 1, 5).getSliceView(null, null, new Slice(4)),
				view.getSlice(), true, 1e-14, 1e-14);
	}
}
