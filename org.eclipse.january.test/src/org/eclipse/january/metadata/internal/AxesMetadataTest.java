/*
 * Copyright (c) 2014 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.metadata.internal;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.eclipse.january.DatasetException;
import org.eclipse.january.MetadataException;
import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DoubleDataset;
import org.eclipse.january.dataset.IDataset;
import org.eclipse.january.dataset.ILazyDataset;
import org.eclipse.january.dataset.Random;
import org.eclipse.january.dataset.Slice;
import org.eclipse.january.metadata.AxesMetadata;
import org.eclipse.january.metadata.ErrorMetadata;
import org.eclipse.january.metadata.MetadataFactory;
import org.junit.Test;

public class AxesMetadataTest {

	@Test
	public void testAxesMetadata() throws MetadataException {
		final int[] shape = new int[] {1, 1, 2, 3, 4, 1, 1};

		int r = shape.length;
		AxesMetadata amd = MetadataFactory.createMetadata(AxesMetadata.class, r);
		for (int i = 0; i < r; i++) {
			DoubleDataset[] array = new DoubleDataset[i + 1];
			for (int j = 0; j < (i + 1) ; j++) {
				array[j] = Random.randn(shape);
			}			
			amd.setAxis(i, array);
		}


		ILazyDataset dataset = Random.lazyRand(Dataset.INT32, "Main", shape);
		dataset.addMetadata(amd);

		try {
			AxesMetadata tmd = dataset.getMetadata(AxesMetadata.class).get(0);
			assertEquals(amd, tmd);
			assertEquals(r, tmd.getAxes().length);
			for (int i = 0; i < r; i++) {
				assertEquals(i + 1, tmd.getAxis(i).length);
			}
			assertEquals(r, tmd.getAxis(0)[0].getRank());
		} catch (Exception e) {
			fail("Should not fail: " + e);
		}

		dataset.squeezeEnds();
		r = dataset.getRank();
		try {
			AxesMetadata tmd = dataset.getMetadata(AxesMetadata.class).get(0);
			assertEquals(r, tmd.getAxes().length);
			for (int i = 0; i < r; i++) {
				assertEquals(i + 3, tmd.getAxis(i).length);
			}
			assertEquals(r, tmd.getAxis(0)[0].getRank());
		} catch (Exception e) {
			fail("Should not fail: " + e);
		}

		Slice[] slice = new Slice[] {new Slice(1), null, new Slice(null, null, 2)};
		ILazyDataset sliced = dataset.getSliceView(slice);
		int[] nshape = new int[] {1, 3, 2};
		assertArrayEquals(nshape, sliced.getShape());
		try {
			AxesMetadata tmd = sliced.getMetadata(AxesMetadata.class).get(0);
			assertEquals(sliced.getRank(), tmd.getAxes().length);
			assertEquals(3, tmd.getAxis(0).length);
			assertArrayEquals(nshape, tmd.getAxis(0)[0].getShape());
			assertEquals(4, tmd.getAxis(1).length);
			assertArrayEquals(nshape, tmd.getAxis(1)[0].getShape());
			assertEquals(5, tmd.getAxis(2).length);
			assertArrayEquals(nshape, tmd.getAxis(2)[0].getShape());
		} catch (Exception e) {
			fail("Should not fail: " + e);
		}

		nshape = new int[] {3, 2, 1, 1};
		sliced.setShape(nshape);
		try {
			AxesMetadata tmd = sliced.getMetadata(AxesMetadata.class).get(0);
			assertEquals(sliced.getRank(), tmd.getAxes().length);
			assertArrayEquals(nshape, tmd.getAxis(0)[0].getShape());
			assertArrayEquals(null, tmd.getAxis(2));
		} catch (Exception e) {
			fail("Should not fail: " + e);
		}

		nshape = new int[] {1, 1, 3, 2};
		sliced.setShape(nshape);
		try {
			AxesMetadata tmd = sliced.getMetadata(AxesMetadata.class).get(0);
			assertEquals(sliced.getRank(), tmd.getAxes().length);
			assertArrayEquals(nshape, tmd.getAxis(2)[0].getShape());
			assertArrayEquals(null, tmd.getAxis(0));
		} catch (Exception e) {
			fail("Should not fail: " + e);
		}
	}

	@Test
	public void testAxesMetadataReshape() throws MetadataException {
		final int[] shape = new int[] { 1, 2, 3, 1 };
		final int[] reshape = new int[] { 1, 1, 2, 3, 1 };

		int r = shape.length;
		int[] nShape = new int[r];
		AxesMetadata amd = MetadataFactory.createMetadata(AxesMetadata.class, r);
		for (int i = 0; i < r; i++) {
			Arrays.fill(nShape, 1);
			nShape[i] = shape[i];
			DoubleDataset array = Random.randn(nShape);
			amd.setAxis(i, array);
		}
		ILazyDataset dataset = Random.lazyRand(Dataset.INT32, "Main", shape);
		dataset.addMetadata(amd);
		dataset.setShape(reshape);
	}

	@Test
	public void testAxesMetadataReshapeEmpty() throws Exception {
		final int[] shape = new int[] { 1, 2, 3, 1 };

		int r = shape.length;

		ILazyDataset dataset = Random.lazyRand(Dataset.INT32, "Main", shape);

		AxesMetadata amd = MetadataFactory.createMetadata(AxesMetadata.class, r);
		dataset.addMetadata(amd);

		ILazyDataset v = dataset.getSliceView();
		v.squeezeEnds();
		assertEquals(2, v.getMetadata(AxesMetadata.class).get(0).getAxes().length);

		IDataset d = v.getSlice(new Slice(1), null);
		assertEquals(2, d.getMetadata(AxesMetadata.class).get(0).getAxes().length);

		final int[] reshape = new int[] { 1, 1, 2, 3, 1 };
		v.setShape(reshape);
		assertEquals(5, v.getMetadata(AxesMetadata.class).get(0).getAxes().length);

		d = v.getSlice((Slice) null, null, new Slice(1));
		assertEquals(5, d.getMetadata(AxesMetadata.class).get(0).getAxes().length);
	}

	@Test
	public void testAxesMetadataRecursion() throws MetadataException {
		final int[] shape = new int[] { 1, 2, 3, 1 };

		int r = shape.length;

		ILazyDataset axis = Random.lazyRand(Dataset.INT32, "axis", 2);
		AxesMetadata amd = MetadataFactory.createMetadata(AxesMetadata.class, 1);
		amd.setAxis(0, Random.lazyRand(Dataset.INT32, "axis2", 2));
		axis.addMetadata(amd);

		amd = MetadataFactory.createMetadata(AxesMetadata.class, r);
		amd.setAxis(1, axis);
		ILazyDataset dataset = Random.lazyRand(Dataset.INT32, "Main", shape);
		dataset.addMetadata(amd);

		dataset.setShape(2,3,1,1);

		ErrorMetadata emd = MetadataFactory.createMetadata(ErrorMetadata.class);
		ILazyDataset axisErr = Random.lazyRand(Dataset.INT32, "axis2_err", 2);
		emd.setError(axisErr);
		axis.addMetadata(emd);

		amd = MetadataFactory.createMetadata(AxesMetadata.class, 1);
		amd.setAxis(0, axis);
		axisErr.addMetadata(amd);

		axisErr.setShape(2,1);
		axisErr.getSliceView(new Slice(1));
		axisErr.getTransposedView();
	}

	@Test
	public void testAxesMetadataTranspose() throws Exception {
		final int[] shape = new int[] { 1, 2, 3, 4 };
		int r = shape.length;
		int[] nShape = new int[r];
		AxesMetadata amd = MetadataFactory.createMetadata(AxesMetadata.class, r);
		for (int i = 0; i < r; i++) {
			Arrays.fill(nShape, 1);
			nShape[i] = shape[i];
			DoubleDataset array = Random.randn(nShape);
			amd.setAxis(i, array);
		}

		Dataset dataset = Random.rand(shape);
		dataset.addMetadata(amd);

		int[] map = new int[] {3, 1, 2, 0};
		Dataset t = dataset.getTransposedView(map);
		assertArrayEquals(new int[]{4, 2, 3, 1}, t.getShape());
		amd = t.getMetadata(AxesMetadata.class).get(0);

		for (int i = 0; i < r; i++) {
			ILazyDataset a = amd.getAxis(i)[0];
			assertEquals(shape[map[i]], a.getSize());
		}
	}

	@Test
	public void testAxesMetadataError() throws DatasetException {
		final int[] shape = new int[] { 1, 2, 3, 1 };

		int r = shape.length;

		ILazyDataset axis = Random.lazyRand(Dataset.INT32, "axis", 2);
		AxesMetadata amd = MetadataFactory.createMetadata(AxesMetadata.class, 1);
		amd.setAxis(0, Random.lazyRand(Dataset.INT32, "axis2", 2));
		axis.addMetadata(amd);

		amd = MetadataFactory.createMetadata(AxesMetadata.class, r);
		amd.setAxis(1, axis);
		ILazyDataset dataset = Random.lazyRand(Dataset.INT32, "Main", shape);
		dataset.addMetadata(amd);
		ILazyDataset datasetErr = Random.lazyRand(Dataset.INT32, "dataset_err", 1, 2, 1, 1);
		dataset.setErrors(datasetErr);

		dataset.setShape(2, 3, 1, 1);

		ILazyDataset axisErr = Random.lazyRand(Dataset.INT32, "axis2_err", 2);

		amd = MetadataFactory.createMetadata(AxesMetadata.class, 1);
		amd.setAxis(0, axis);
		axisErr.addMetadata(amd);
		axis.setErrors(axisErr);

		ILazyDataset d = dataset.getSliceView();
		d.squeezeEnds();
		IDataset slice = d.getSlice();

		assertTrue(slice != null);
	}

	@Test
	public void testSliceFromView() throws DatasetException {
		final int[] shape = new int[] { 3, 10, 11 };
		final int[] ashape = new int[] { 3 };

		ILazyDataset dataset = Random.lazyRand(Dataset.INT32, "Main", shape);
		ILazyDataset ax = Random.lazyRand(Dataset.INT32, "Axis", ashape);

		AxesMetadata amd = MetadataFactory.createMetadata(AxesMetadata.class, shape.length);
		amd.setAxis(0, ax);
		dataset.setMetadata(amd);

		ILazyDataset view = dataset.getSliceView(new Slice(1, 2), null, null);
		IDataset slice = view.getSlice();
		assertTrue(slice != null);
	}

	@Test
	public void testBroadcastWithErrors() throws DatasetException {
		final int[] shape = new int[] { 2, 3, 10, 11 };
		final int[] ashape = new int[] { 11 };

		ILazyDataset dataset = Random.lazyRand(Dataset.INT32, "Main", shape);
		ILazyDataset ax = Random.lazyRand(Dataset.INT32, "Axis", ashape);
		ILazyDataset er = Random.lazyRand(Dataset.INT32, "Error", ashape);
		ax.setErrors(er);

		AxesMetadata amd = MetadataFactory.createMetadata(AxesMetadata.class, shape.length);
		amd.setAxis(3, ax);
		dataset.setMetadata(amd);
		dataset = dataset.getSliceView();

		IDataset d = dataset.getSlice(new Slice(1, 2), new Slice(1, 2), new Slice(1, 2), null);
		AxesMetadata m = d.getFirstMetadata(AxesMetadata.class);
		m.getAxes()[3].getSlice();
		d.squeeze();
		AxesMetadata axOut = d.getFirstMetadata(AxesMetadata.class);

		IDataset slice = axOut.getAxes()[0].getSlice();

		slice = axOut.getAxes()[0].getSlice();
		assertTrue(slice != null);

		m = dataset.getSlice().getFirstMetadata(AxesMetadata.class);
		ax = m.getAxes()[3];
		ax.clearMetadata(ErrorMetadata.class);
		ErrorMetadata em = ax.getSlice().getFirstMetadata(ErrorMetadata.class);
		assertTrue(em == null);
	}

	@Test
	public void testReversedSlice() throws DatasetException {
		final int[] shape = new int[] {3, 10};
	
		ILazyDataset dataset = Random.lazyRand(shape);
		Dataset ax = Random.rand(shape[0]);
		Dataset bx = Random.rand(shape[1]);
	
		AxesMetadata amd = MetadataFactory.createMetadata(AxesMetadata.class, shape.length);
		amd.setAxis(0, ax);
		amd.setAxis(1, bx);
		dataset.setMetadata(amd);
	
		IDataset slice;
	
		slice = dataset.getSlice((Slice) null, new Slice(null, 7));
		amd = slice.getFirstMetadata(AxesMetadata.class);
		assertEquals(ax.getSize(), amd.getAxes()[0].getSize());
		assertEquals(7, amd.getAxes()[1].getSize());
	
		slice = dataset.getSlice((Slice) null, new Slice(7, null, -1));
		amd = slice.getFirstMetadata(AxesMetadata.class);
		assertEquals(ax.getSize(), amd.getAxes()[0].getSize());
		assertEquals(8, amd.getAxes()[1].getSize());
	}
}
