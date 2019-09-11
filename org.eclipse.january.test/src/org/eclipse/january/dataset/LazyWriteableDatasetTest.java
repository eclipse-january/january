/*-
 * Copyright 2015, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.dataset.LazyWriteableDataset;
import org.eclipse.january.dataset.Random;
import org.eclipse.january.dataset.Slice;
import org.eclipse.january.dataset.SliceND;
import org.junit.Assert;
import org.junit.Test;

public class LazyWriteableDatasetTest {

	@Test
	public void testSetSlice() throws Exception {
		final int[] shape = new int[] {1, 2, 3, 4};
		final Dataset d = Random.randn(shape);
		LazyWriteableDataset ld = LazyWriteableDataset.createLazyDataset(d);

		SliceND s = new SliceND(d.getShapeRef(), (Slice) null, null, new Slice(1), new Slice(0, null, 2));
		Dataset sd = DatasetFactory.ones(d.getClass(), s.getShape());
		ld.setSlice(sd, s);
		Assert.assertEquals(d.getSlice(s), sd);
	}

	@Test
	public void testSetSliceOnFullView() throws Exception {
		final int[] shape = new int[] {1, 2, 3, 4};
		final Dataset d = Random.randn(shape);
		LazyWriteableDataset old = LazyWriteableDataset.createLazyDataset(d);
		LazyWriteableDataset ld = old.getSliceView();

		SliceND s = new SliceND(ld.getShape(), (Slice) null, null, new Slice(1, null), new Slice(0, null, 2));
		Dataset sd = DatasetFactory.ones(ld.getInterface(), s.getShape());
		ld.setSlice(sd, s);
		Assert.assertEquals(d.getSlice(s), sd);
	}

	@Test
	public void testSetSliceOnSlicedView() throws Exception {
		final int[] shape = new int[] {1, 2, 3, 4};
		final Dataset d = Random.randn(shape);
		LazyWriteableDataset old = LazyWriteableDataset.createLazyDataset(d);
		LazyWriteableDataset ld = old.getSliceView(null, null, null, new Slice(1, null));

		SliceND s = new SliceND(ld.getShape(), (Slice) null, null, new Slice(1, null), new Slice(0, null, 2));
		Dataset sd = DatasetFactory.ones(ld.getInterface(), s.getShape());
		ld.setSlice(sd, s);
		Assert.assertEquals(d.getSlice((Slice) null, null, new Slice(1, null), new Slice(1, null, 2)), sd);
	}

	@Test
	public void testSetSliceOnTransposedView() throws Exception {
		final int[] shape = new int[] {1, 2, 3, 4};
		final Dataset d = Random.randn(shape);
		LazyWriteableDataset old = LazyWriteableDataset.createLazyDataset(d);
		LazyWriteableDataset ld = old.getTransposedView();
		
		SliceND s = new SliceND(ld.getShape(), new Slice(0, null, 2), new Slice(1, null), null, null);
		Dataset sd = DatasetFactory.ones(ld.getInterface(), s.getShape());
		ld.setSlice(sd, s);
		Assert.assertEquals(d.transpose().getSlice(s), sd);
	}

	@Test
	public void testSetExpandedSlice() throws Exception {
		final int[] shape = new int[] {1, 2, 3, 4};
		final Dataset d = Random.randn(shape);
		LazyWriteableDataset ld = LazyWriteableDataset.createLazyDataset(d, new int[] {2, 2, 3, 4});

		SliceND s = new SliceND(d.getShapeRef(), ld.getMaxShape(), new Slice(1,2), null, new Slice(1), new Slice(0, null, 2));
		Dataset sd = DatasetFactory.ones(ld.getInterface(), s.getShape());
		ld.setSlice(sd, s);
		Assert.assertEquals(ld.getSlice(s), sd);
	}

	// TODO test set slice on squeezed sliced view
	
}
