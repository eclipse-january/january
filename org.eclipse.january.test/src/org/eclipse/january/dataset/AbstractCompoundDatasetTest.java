/*-
 * Copyright (c) 2012, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.eclipse.january.asserts.TestUtils;
import org.eclipse.january.dataset.CompoundDataset;
import org.eclipse.january.dataset.CompoundDoubleDataset;
import org.eclipse.january.dataset.CompoundIntegerDataset;
import org.eclipse.january.dataset.DTypeUtils;
import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.dataset.DatasetUtils;
import org.eclipse.january.dataset.IndexIterator;
import org.eclipse.january.dataset.Maths;
import org.eclipse.january.dataset.PositionIterator;
import org.eclipse.january.dataset.RGBDataset;
import org.eclipse.january.dataset.Random;
import org.eclipse.january.dataset.Slice;
import org.junit.Test;

public class AbstractCompoundDatasetTest {
	long[] ldata = {0, 1, 2, 3, 4, 5};
	int[] idata = {0, 1, 2, 3, 4, 5};
	short[] sdata = {0, 1, 2, 3, 4, 5};
	byte[] bdata = {0, 1, 2, 3, 4, 5};
	double[] ddata = {0., 1., 2., 3., 4., 5.};
	float[] fdata = {0.f, 1.f, 2.f, 3.f, 4.f, 5.f};

	@Test
	public void testSlice() {
		int isize, size;
		isize = 5;
		size = 1024;
		testSliceND(isize, size, CompoundDoubleDataset.class);

		testSliceND(2, size, ComplexDoubleDataset.class);

		testSliceND(size, DoubleDataset.class);
		testSliceND(size, ShortDataset.class);
	}

	private void testSliceND(int isize, int size, Class<? extends CompoundDataset> clazz) {
		// 1D
		CompoundDataset ta;
		ta = DatasetFactory.createRange(isize, clazz, 0, size, 1);
		testSlicedDataset(ta);

		// 2D
		ta = DatasetFactory.createRange(isize, clazz, 0, size, 1).reshape(16, size / 16);
		System.out.println(" Shape: " + Arrays.toString(ta.getShape()));
		testSlicedDataset(ta);

		ta = DatasetFactory.createRange(isize, clazz, 0, size, 1).reshape(size / 32, 32);
		System.out.println(" Shape: " + Arrays.toString(ta.getShape()));
		testSlicedDataset(ta);

		// 3D
		ta = DatasetFactory.createRange(isize, clazz, 0, size, 1).reshape(16, 8, size / (16 * 8));
		System.out.println(" Shape: " + Arrays.toString(ta.getShape()));
		testSlicedDataset(ta);

		ta = DatasetFactory.createRange(isize, clazz, 0, size, 1).reshape(size / (16 * 8), 16, 8);
		System.out.println(" Shape: " + Arrays.toString(ta.getShape()));
		testSlicedDataset(ta);
	}

	private void testSliceND(int size, Class<? extends Dataset> clazz) {
		// 1D
		CompoundDataset ta;
		ta = DatasetUtils.createCompoundDatasetFromLastAxis(DatasetFactory.createRange(clazz, size).reshape(size/16, 16), true);
		testSlicedDataset(ta);
		testElementViews(ta);

		// 2D
		ta = DatasetUtils.createCompoundDatasetFromLastAxis(DatasetFactory.createRange(clazz, size).reshape(size/(16*8), 16, 8), true);
		testSlicedDataset(ta);
		testElementViews(ta);

		// 3D
		ta = DatasetUtils.createCompoundDatasetFromLastAxis(DatasetFactory.createRange(clazz, size).reshape(size/(16*8), 8, 8, 2), true);
		testSlicedDataset(ta);
		testElementViews(ta);
	}

	private void testSlicedDataset(CompoundDataset ta) {
		int[] stop = ta.getShape();
		stop[stop.length - 1] -= 1;
		CompoundDataset sa = ta.getSliceView(null, stop, null);

		PositionIterator it = new PositionIterator(sa.getShape());
		int[] pos = it.getPos();
		double[] expected = new double[ta.getElementsPerItem()];
		double[] actual   = new double[expected.length];
		while (it.hasNext()) {
			ta.getDoubleArray(actual, pos);
			sa.getDoubleArray(expected, pos);
			assertArrayEquals(expected, actual, 1e-14);
		}
	}

	private void testElementViews(CompoundDataset ta) {
		int isize = ta.getElementsPerItem();
		int e = isize > 1 ? isize - 2 : isize - 1;

		Dataset va = ta.getElementsView(e);
		assertArrayEquals(ta.getShapeRef(), va.getShapeRef());
		IndexIterator it = ta.getIterator(true);
		int[] pos = it.getPos();
		while (it.hasNext()) {
			assertEquals(ta.getElementDoubleAbs(it.index + e), va.getDouble(pos), 1e-14);
		}

		va.setSlice(0);
		it.reset();
		while (it.hasNext()) {
			assertEquals(0, va.getDouble(pos), 1e-14);
			assertEquals(0, ta.getElementDoubleAbs(it.index + e), 1e-14);
		}
	}

	@Test
	public void testToDoubleArray() {
		double[] d;

		d = DTypeUtils.toDoubleArray(ddata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toDoubleArray(fdata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toDoubleArray(ldata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toDoubleArray(idata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toDoubleArray(sdata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toDoubleArray(bdata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
	}

	@Test
	public void testToFloatArray() {
		float[] d;

		d = DTypeUtils.toFloatArray(ddata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toFloatArray(fdata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toFloatArray(ldata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toFloatArray(idata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toFloatArray(sdata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toFloatArray(bdata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
	}

	@Test
	public void testToLongArray() {
		long[] d;

		d = DTypeUtils.toLongArray(ddata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toLongArray(fdata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toLongArray(ldata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toLongArray(idata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toLongArray(sdata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toLongArray(bdata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
	}

	@Test
	public void testToIntegerArray() {
		int[] d;

		d = DTypeUtils.toIntegerArray(ddata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toIntegerArray(fdata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toIntegerArray(ldata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toIntegerArray(idata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toIntegerArray(sdata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toIntegerArray(bdata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
	}

	@Test
	public void testToShortArray() {
		short[] d;

		d = DTypeUtils.toShortArray(ddata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toShortArray(fdata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toShortArray(ldata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toShortArray(idata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toShortArray(sdata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toShortArray(bdata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
	}

	@Test
	public void testToByteArray() {
		byte[] d;

		d = DTypeUtils.toByteArray(ddata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toByteArray(fdata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toByteArray(ldata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toByteArray(idata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toByteArray(sdata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
		d = DTypeUtils.toByteArray(bdata, idata.length);
		for (int i = 0; i < idata.length; i++) {
			assertEquals(ddata[i], d[i], 1e-10);
		}
	}

	@Test
	public void testSum() {
		Dataset d = Random.randint(0, 255, new int[] {5,2});
		CompoundDataset dc = DatasetUtils.createCompoundDatasetFromLastAxis(d, true);
		Dataset dd = DatasetUtils.createDatasetFromCompoundDataset(dc, true);
		double[] dcsum = (double[]) dc.sum();
		double dsum = ((Number) d.sum()).doubleValue();
		double ddsum = ((Number) dd.sum()).doubleValue();
		assertEquals(dsum, dcsum[0]+dcsum[1], 1e-10);
		assertEquals(dsum, ddsum, 1e-10);

		d = Random.randint(0, 255, new int[] {5,3,2});
		dc = DatasetUtils.createCompoundDatasetFromLastAxis(d, true);
		Dataset dca = DatasetUtils.createDatasetFromCompoundDataset(dc.sum(0), true);
		Dataset da = d.sum(0);
		IndexIterator it = da.getIterator();
		while (it.hasNext()) {
			assertEquals(da.getElementDoubleAbs(it.index), dca.getElementDoubleAbs(it.index), 1e-15);
		}
		Dataset dcb = DatasetUtils.createDatasetFromCompoundDataset(dc.sum(1), true);
		Dataset db = d.sum(1);
		it = db.getIterator();
		while (it.hasNext()) {
			assertEquals(db.getElementDoubleAbs(it.index), dcb.getElementDoubleAbs(it.index), 1e-15);
		}
	}

	@Test
	public void testCompoundIntegerCreators() {
		int iz = 3;
		CompoundIntegerDataset z = CompoundIntegerDataset.createFromObject(iz);
		assertEquals(0, z.getRank());
		assertEquals(1, z.getSize());
		assertEquals(1, z.getElementsPerItem());
		assertEquals(iz, z.getElementLongAbs(0));

		int[] ia = { 0, 1, 2, 3, 4, 5 };
		CompoundIntegerDataset a = CompoundIntegerDataset.createFromObject(ia);

		int is = a.getElementsPerItem();
		assertEquals(6, is);
		assertEquals(1, a.getRank());
		assertEquals(1, a.getSize());
		assertEquals(1, a.getShape()[0]);
		IndexIterator it = a.getIterator();
		for (int i = 0; it.hasNext();) {
			for (int j = 0; j < is; j++, i++)
				assertEquals(i, a.getElementLongAbs(it.index + j));
		}

		a = CompoundIntegerDataset.createFromObject(ia.length, ia);
		is = a.getElementsPerItem();
		assertEquals(6, is);
		assertEquals(1, a.getRank());
		assertEquals(1, a.getSize());
		assertEquals(1, a.getShape()[0]);
		it = a.getIterator();
		for (int i = 0; it.hasNext();) {
			for (int j = 0; j < is; j++, i++)
				assertEquals(i, a.getElementLongAbs(it.index + j));
		}

	}

	@Test
	public void testCompoundCreators() {
		double dz = 0.5;
		CompoundDoubleDataset z = CompoundDoubleDataset.createFromObject(dz);
		assertEquals(0, z.getRank());
		assertEquals(1, z.getSize());
		assertEquals(1, z.getElementsPerItem());
		assertEquals(dz, z.getElementDoubleAbs(0), 1e-14);

		double[] da = { 0, 1, 2, 3, 4, 5 };
		CompoundDoubleDataset a = CompoundDoubleDataset.createFromObject(da);
		int is = a.getElementsPerItem();
		assertEquals(6, is);
		assertEquals(1, a.getRank());
		assertEquals(1, a.getSize());
		assertEquals(1, a.getShape()[0]);
		IndexIterator it = a.getIterator();
		for (int i = 0; it.hasNext();) {
			for (int j = 0; j < is; j++, i++)
				assertEquals(i, a.getElementDoubleAbs(it.index + j), 1e-15*i);
		}

		double[][] db = { {0, 1, 2}, {3, 4, 5} };
		CompoundDoubleDataset b = CompoundDoubleDataset.createFromObject(db);
		is = b.getElementsPerItem();
		assertEquals(3, is);
		assertEquals(1, b.getRank());
		assertEquals(2, b.getSize());
		assertEquals(2, b.getShape()[0]);
		it = b.getIterator();
		for (int i = 0; it.hasNext();) {
			for (int j = 0; j < is; j++, i++)
				assertEquals(i, b.getElementDoubleAbs(it.index + j), 1e-15*i);
		}
		b.hashCode();
		double[] mb = (double[]) b.mean();
		double[] rb = new double[] {1.5, 2.5, 3.5};
		for (int j = 0; j < is; j++)
			assertEquals(rb[j], mb[j], 1e-15);

		double[][] dc = { {0, 1, 2, 3}, {4, 5, 6} };
		CompoundDoubleDataset c = CompoundDoubleDataset.createFromObject(dc);
		is = c.getElementsPerItem();
		assertEquals(4, is);
		assertEquals(1, c.getRank());
		assertEquals(2, c.getSize());
		assertEquals(2, c.getShape()[0]);
		it = c.getIterator();
		for (int i = 0; it.hasNext();) {
			for (int j = 0; j < is; j++, i++) {
				if (i < 7)
					assertEquals(i, c.getElementDoubleAbs(it.index + j), 1e-15 * i);
				else
					assertEquals(0, c.getElementDoubleAbs(it.index + j), 1e-15);
			}
		}

		double[][] dd = { {0, 1, 2}, {4, 5, 6, 7} };
		CompoundDoubleDataset d = CompoundDoubleDataset.createFromObject(dd);
		is = d.getElementsPerItem();
		assertEquals(4, is);
		assertEquals(1, d.getRank());
		assertEquals(2, d.getSize());
		assertEquals(2, d.getShape()[0]);
		it = d.getIterator();
		for (int i = 0; it.hasNext();) {
			for (int j = 0; j < is; j++, i++) {
				if (i != 3)
					assertEquals(i, d.getElementDoubleAbs(it.index + j), 1e-15 * i);
				else
					assertEquals(0, d.getElementDoubleAbs(it.index + j), 1e-15);
			}
		}
	}
	
	@Test
	public void testRGB() {
		Dataset r = Random.randint(0, 255, new int[] {128, 128});
		Dataset g = Random.randint(0, 255, r.getShape());
		Dataset b = Random.randint(0, 255, r.getShape());
		RGBDataset c = new RGBDataset(r, g, b);
		System.out.println("" + c.hashCode());
		double[] mc = (double[]) c.mean();
		double[] rc = new double[] {((Number) r.mean()).doubleValue(),
				((Number) g.mean()).doubleValue(), ((Number) b.mean()).doubleValue()};
		
		for (int j = 0; j < 3; j++)
			assertEquals(rc[j], mc[j], 1e-15);
	}

	@Test
	public void testTake() {
		Dataset a = DatasetFactory.createRange(ComplexDoubleDataset.class, 12);
		Dataset t;
		System.out.println(a);

		t = DatasetUtils.take(a, new int[] {0, 2, 4}, 0);
		System.out.println(t);

		a.setShape(new int[] {3,4});
		System.out.println(a);

		t = DatasetUtils.take(a, new int[] {0}, 0);
		System.out.println(t);

		t = DatasetUtils.take(a, new int[] {1}, 0);
		System.out.println(t);

		t = DatasetUtils.take(a, new int[] {2}, 0);
		System.out.println(t);

		t = DatasetUtils.take(a, new int[] {0}, 1);
		System.out.println(t);

		t = DatasetUtils.take(a, new int[] {1}, 1);
		System.out.println(t);

		t = DatasetUtils.take(a, new int[] {2}, 1);
		System.out.println(t);

		t = DatasetUtils.take(a, new int[] {3}, 1);
		System.out.println(t);
	}

	@Test
	public void test1DErrors() {
	
		// test 1D errors for single value
		Dataset[] aa =  new Dataset[5];
		for (int i = 0 ; i < 5; i++) {
			aa[i] = DatasetFactory.createRange(IntegerDataset.class, 100);
		}
		CompoundDataset a = new CompoundIntegerDataset(aa);
		
		a.setErrors(5);
		assertTrue(a.hasErrors());
		
		assertEquals(5.0, a.getErrorArray(0)[0], 0.001);
		assertEquals(5.0, a.getErrorArray(0)[2], 0.001);
		assertEquals(5.0, a.getErrorArray(0)[4], 0.001);
		
		assertEquals(5.0, a.getErrorArray(50)[0], 0.001);
		assertEquals(5.0, a.getErrorArray(50)[2], 0.001);
		assertEquals(5.0, a.getErrorArray(50)[4], 0.001);
		
		assertEquals(5.0, a.getErrorArray(99)[0], 0.001);
		assertEquals(5.0, a.getErrorArray(99)[2], 0.001);
		assertEquals(5.0, a.getErrorArray(99)[4], 0.001);
		
		// now for pulling out the full error array
		CompoundDataset error = a.getErrors();
		
		// check compatibility
		try {
			ShapeUtils.checkCompatibility(a, error);
		} catch (Exception e) {
			fail("Error shape is not the same as input datasets");
		}
		
		assertEquals(5.0, error.getElements(0).getDouble(0), 0.001);
		assertEquals(5.0, error.getElements(0).getDouble(50), 0.001);
		assertEquals(5.0, error.getElements(0).getDouble(99), 0.001);
		
		assertEquals(5.0, error.getElements(2).getDouble(0), 0.001);
		assertEquals(5.0, error.getElements(2).getDouble(50), 0.001);
		assertEquals(5.0, error.getElements(2).getDouble(99), 0.001);
		
		assertEquals(5.0, error.getElements(4).getDouble(0), 0.001);
		assertEquals(5.0, error.getElements(4).getDouble(50), 0.001);
		assertEquals(5.0, error.getElements(4).getDouble(99), 0.001);
		
		// Now set the error as a whole array
		a.setErrors(Maths.multiply(error, 2));
		
		assertEquals(10.0, a.getErrorArray(0)[0], 0.001);
		assertEquals(10.0, a.getErrorArray(0)[2], 0.001);
		assertEquals(10.0, a.getErrorArray(0)[4], 0.001);
		
		assertEquals(10.0, a.getErrorArray(50)[0], 0.001);
		assertEquals(10.0, a.getErrorArray(50)[2], 0.001);
		assertEquals(10.0, a.getErrorArray(50)[4], 0.001);
		
		assertEquals(10.0, a.getErrorArray(99)[0], 0.001);
		assertEquals(10.0, a.getErrorArray(99)[2], 0.001);
		assertEquals(10.0, a.getErrorArray(99)[4], 0.001);
		
		// test pulling the error out again, to make sure its correct
		CompoundDataset error2 = a.getErrors();
		
		// check compatibility
		try {
			ShapeUtils.checkCompatibility(a, error2);
		} catch (Exception e) {
			fail("Error shape is not the same as input datasets");
		}
		
		assertEquals(10.0, error2.getElements(0).getDouble(0), 0.001);
		assertEquals(10.0, error2.getElements(0).getDouble(50), 0.001);
		assertEquals(10.0, error2.getElements(0).getDouble(99), 0.001);
		
		assertEquals(10.0, error2.getElements(2).getDouble(0), 0.001);
		assertEquals(10.0, error2.getElements(2).getDouble(50), 0.001);
		assertEquals(10.0, error2.getElements(2).getDouble(99), 0.001);
		
		assertEquals(10.0, error2.getElements(4).getDouble(0), 0.001);
		assertEquals(10.0, error2.getElements(4).getDouble(50), 0.001);
		assertEquals(10.0, error2.getElements(4).getDouble(99), 0.001);
		
		
		// finally check the array setting
		
		a.setErrors(new Double[] { 1.0, 2.0, 3.0, 4.0, 5.0});
		
		assertEquals(1.0, a.getErrorArray(0)[0], 0.001);
		assertEquals(3.0, a.getErrorArray(0)[2], 0.001);
		assertEquals(5.0, a.getErrorArray(0)[4], 0.001);
		
		assertEquals(1.0, a.getErrorArray(50)[0], 0.001);
		assertEquals(3.0, a.getErrorArray(50)[2], 0.001);
		assertEquals(5.0, a.getErrorArray(50)[4], 0.001);
		
		assertEquals(1.0, a.getErrorArray(99)[0], 0.001);
		assertEquals(3.0, a.getErrorArray(99)[2], 0.001);
		assertEquals(5.0, a.getErrorArray(99)[4], 0.001);
		
		// test pulling the error out again, to make sure its correct
		CompoundDataset error3 = a.getErrors();
		
		// check compatibility
		try {
			ShapeUtils.checkCompatibility(a, error3);
		} catch (Exception e) {
			fail("Error shape is not the same as input datasets");
		}
		
		assertEquals(1.0, error3.getElements(0).getDouble(0), 0.001);
		assertEquals(2.0, error3.getElements(1).getDouble(50), 0.001);
		assertEquals(1.0, error3.getElements(0).getDouble(99), 0.001);
		
		assertEquals(2.0, error3.getElements(1).getDouble(0), 0.001);
		assertEquals(3.0, error3.getElements(2).getDouble(50), 0.001);
		assertEquals(4.0, error3.getElements(3).getDouble(99), 0.001);
		
		assertEquals(5.0, error3.getElements(4).getDouble(0), 0.001);
		assertEquals(4.0, error3.getElements(3).getDouble(50), 0.001);
		assertEquals(5.0, error3.getElements(4).getDouble(99), 0.001);
	}

	@Test
	public void testInternalErrors() {
		Dataset[] aa =  new Dataset[5];
		for (int i = 0 ; i < 5; i++) {
			aa[i] = DatasetFactory.createRange(IntegerDataset.class, 100);
		}
		CompoundDataset a = new CompoundIntegerDataset(aa);
		
		a.setErrors(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0});
		
		// should be squared
		CompoundDataset e = (CompoundDataset) a.getErrorBuffer();
		double[] ea = e.getDoubleArray(0);
		assertEquals(1.0, ea[0], 0.001);
		assertEquals(4.0, ea[1], 0.001);
		assertEquals(9.0, ea[2], 0.001);
		assertEquals(16.0, ea[3], 0.001);
		assertEquals(25.0, ea[4], 0.001);
		
		// now for pulling out the full error array
		CompoundDataset error = a.getErrors();

		a.setErrors(error);
		
		// should also be squared
		CompoundDataset ae = (CompoundDataset) a.getErrorBuffer();
		assertEquals(1.0, ae.getElements(0).getDouble(0), 0.001);
		assertEquals(4.0, ae.getElements(1).getDouble(0), 0.001);
		assertEquals(9.0, ae.getElements(2).getDouble(0), 0.001);
		assertEquals(16.0, ae.getElements(3).getDouble(0), 0.001);
		assertEquals(25.0, ae.getElements(4).getDouble(0), 0.001);
		
		assertEquals(1.0, ae.getElements(0).getDouble(99), 0.001);
		assertEquals(4.0, ae.getElements(1).getDouble(99), 0.001);
		assertEquals(9.0, ae.getElements(2).getDouble(99), 0.001);
		assertEquals(16.0, ae.getElements(3).getDouble(99), 0.001);
		assertEquals(25.0, ae.getElements(4).getDouble(99), 0.001);
	}

	@Test
	public void testSlicing() {
		CompoundDataset a;
		a = DatasetFactory.createRange(3, CompoundIntegerDataset.class, 12).reshape(3, 4);

		a.setSlice(new short[] {-1, -2, -3},  new Slice(1, 3), new Slice(3,4));

		assertArrayEquals(new int[] {0, 0, 0}, a.getIntArray(0, 0));
		assertArrayEquals(new int[] {8, 0, 0}, a.getIntArray(2, 0));
		assertArrayEquals(new int[] {-1, -2, -3}, a.getIntArray(2, 3));
	}

	@Test
	public void testBroadcastElements() {
		CompoundDataset a;
		Dataset b;

		a = DatasetFactory.createCompoundDataset((Object) 1, 2, 3).getBroadcastView(2);
		b = a.getElements(0);
		assertEquals(1, b.getInt(0));
		assertEquals(1, b.getInt(1));
		b = a.getElements(2);
		assertEquals(3, b.getInt(0));
		assertEquals(3, b.getInt(1));


		a = DatasetFactory.createRange(3, CompoundIntegerDataset.class, 4).getBroadcastView(5, 4);
		b = a.getElements(0);
		assertEquals(0, b.getInt(0, 0));
		assertEquals(1, b.getInt(0, 1));
		assertEquals(2, b.getInt(0, 2));
		assertEquals(3, b.getInt(0, 3));
		assertEquals(0, b.getInt(1, 0));
		assertEquals(1, b.getInt(2, 1));
		assertEquals(2, b.getInt(3, 2));
		assertEquals(3, b.getInt(4, 3));

		b = a.getElements(1);
		assertEquals(0, b.getInt(0, 0));
		assertEquals(0, b.getInt(0, 1));
		assertEquals(0, b.getInt(0, 2));
		assertEquals(0, b.getInt(0, 3));
		assertEquals(0, b.getInt(1, 0));
		assertEquals(0, b.getInt(2, 1));
		assertEquals(0, b.getInt(3, 2));
		assertEquals(0, b.getInt(4, 3));
	}

	@Test
	public void testBroadcastSliceView() {
		Dataset a = DatasetFactory.createRange(3, CompoundIntegerDataset.class, 12);
		Dataset b = a.getSliceView(new Slice(5, 8)).getBroadcastView(2, 3);

		Dataset r = DatasetFactory.createRange(3, CompoundIntegerDataset.class, 5, 8, 1).reshape(1, 3);
		Dataset c = DatasetUtils.concatenate(new Dataset[] {r, r}, 0);
		TestUtils.assertDatasetEquals(c, b);

		b = a.getSliceView(new Slice(5, 6)).getBroadcastView(3, 3);
		c = DatasetFactory.zeros(3, CompoundIntegerDataset.class, 3, 3).fill(new int[] {5, 0, 0});
		TestUtils.assertDatasetEquals(c, b);
	}
}
