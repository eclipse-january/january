/*-
 * Copyright 2015 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.dataset;

import org.eclipse.dawnsci.analysis.api.dataset.Slice;
import org.eclipse.dawnsci.analysis.api.dataset.SliceND;
import org.eclipse.dawnsci.analysis.dataset.impl.Dataset;
import org.eclipse.dawnsci.analysis.dataset.impl.DatasetFactory;
import org.eclipse.dawnsci.analysis.dataset.impl.LazyWriteableDataset;
import org.eclipse.dawnsci.analysis.dataset.impl.Random;
import org.junit.Assert;
import org.junit.Test;

public class LazyWriteableDatasetTest {

	@Test
	public void testSetSlice() throws Exception {
		final int[] shape = new int[] {1, 2, 3, 4};
		final Dataset d = Random.randn(shape);
		LazyWriteableDataset ld = LazyWriteableDataset.createLazyDataset(d);

		SliceND s = new SliceND(d.getShapeRef(), (Slice) null, null, new Slice(1), new Slice(0, null, 2));
		Dataset sd = DatasetFactory.ones(s.getShape(), d.getDType());
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
		Dataset sd = DatasetFactory.ones(s.getShape(), ld.getDType());
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
		Dataset sd = DatasetFactory.ones(s.getShape(), ld.getDType());
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
		Dataset sd = DatasetFactory.ones(s.getShape(), ld.getDType());
		ld.setSlice(sd, s);
		Assert.assertEquals(d.transpose().getSlice(s), sd);
	}

	@Test
	public void testSetExpandedSlice() throws Exception {
		final int[] shape = new int[] {1, 2, 3, 4};
		final Dataset d = Random.randn(shape);
		LazyWriteableDataset ld = LazyWriteableDataset.createLazyDataset(d, new int[] {2, 2, 3, 4});

		SliceND s = new SliceND(d.getShapeRef(), ld.getMaxShape(), new Slice(1,2), null, new Slice(1), new Slice(0, null, 2));
		Dataset sd = DatasetFactory.ones(s.getShape(), d.getDType());
		ld.setSlice(sd, s);
		Assert.assertEquals(ld.getSlice(s), sd);
	}	
}
