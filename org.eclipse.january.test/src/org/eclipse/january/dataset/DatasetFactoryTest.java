/*-
 * Copyright (c) 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.january.asserts.TestUtils;
import org.junit.Test;

public class DatasetFactoryTest {

	@Test
	public void testZeros() {
		DoubleDataset act, exp;

		// zero-sized
		exp = new DoubleDataset();
		act = DatasetFactory.zeros(DoubleDataset.class, null);
		TestUtils.assertDatasetEquals(exp, act);

		// zero-ranked (unit size)
		exp = new DoubleDataset(new int[0]);
		act = DatasetFactory.zeros(DoubleDataset.class);
		TestUtils.assertDatasetEquals(exp, act);

		// one dimensional
		exp = new DoubleDataset(3);
		act = DatasetFactory.zeros(DoubleDataset.class, 3);
		TestUtils.assertDatasetEquals(exp, act);

		// two dimensional
		exp = new DoubleDataset(0, 0);
		act = DatasetFactory.zeros(DoubleDataset.class, 0, 0);
		TestUtils.assertDatasetEquals(exp, act);

		// three dimensional
		exp = new DoubleDataset(3, 4, 5);
		act = DatasetFactory.zeros(DoubleDataset.class, 3, 4, 5);
		TestUtils.assertDatasetEquals(exp, act);
	}

	@Test
	public void testZerosElemental() {
		DoubleDataset act, exp;

		// zero-sized
		exp = new DoubleDataset();
		act = DatasetFactory.zeros(1, DoubleDataset.class, null);
		TestUtils.assertDatasetEquals(exp, act);

		// zero-ranked (unit size)
		exp = new DoubleDataset(new int[0]);
		act = DatasetFactory.zeros(1, DoubleDataset.class);
		TestUtils.assertDatasetEquals(exp, act);

		// one dimensional
		exp = new DoubleDataset(3);
		act = DatasetFactory.zeros(1, DoubleDataset.class, 3);
		TestUtils.assertDatasetEquals(exp, act);

		// three dimensional
		exp = new DoubleDataset(3, 4, 5);
		act = DatasetFactory.zeros(1, DoubleDataset.class, 3, 4, 5);
		TestUtils.assertDatasetEquals(exp, act);
	}

	@Test
	public void testZerosCompound() {
		CompoundDoubleDataset act, exp;

		// zero-sized
		exp = new CompoundDoubleDataset();
		act = DatasetFactory.zeros(0, CompoundDoubleDataset.class, null);
		TestUtils.assertDatasetEquals(exp, act);

		exp = new CompoundDoubleDataset(1);
		act = DatasetFactory.compoundZeros(1, CompoundDoubleDataset.class, null);
		TestUtils.assertDatasetEquals(exp, act);

		exp = new CompoundDoubleDataset(2);
		act = DatasetFactory.zeros(2, CompoundDoubleDataset.class, null);
		TestUtils.assertDatasetEquals(exp, act);

		// zero-ranked (unit size)
		exp = new CompoundDoubleDataset(1, new int[0]);
		act = DatasetFactory.compoundZeros(1, CompoundDoubleDataset.class);
		TestUtils.assertDatasetEquals(exp, act);

		exp = new CompoundDoubleDataset(2, new int[0]);
		act = DatasetFactory.zeros(2, CompoundDoubleDataset.class);
		TestUtils.assertDatasetEquals(exp, act);

		// one dimensional
		exp = new CompoundDoubleDataset(1, new int[] {3});
		act = DatasetFactory.compoundZeros(1, CompoundDoubleDataset.class, 3);
		TestUtils.assertDatasetEquals(exp, act);

		exp = new CompoundDoubleDataset(2, new int[] {3});
		act = DatasetFactory.zeros(2, CompoundDoubleDataset.class, 3);
		TestUtils.assertDatasetEquals(exp, act);

		// three dimensional
		exp = new CompoundDoubleDataset(1, new int[] {3, 4, 5});
		act = DatasetFactory.compoundZeros(1, CompoundDoubleDataset.class, 3, 4, 5);
		TestUtils.assertDatasetEquals(exp, act);

		exp = new CompoundDoubleDataset(2, new int[] {3, 4, 5});
		act = DatasetFactory.zeros(2, CompoundDoubleDataset.class, 3, 4, 5);
		TestUtils.assertDatasetEquals(exp, act);
	}

	@Test
	public void testCreator() {
		DoubleDataset act, exp;

		// zero-sized
		exp = new DoubleDataset();

		act = DatasetFactory.createFromObject(DoubleDataset.class, (Object) null);
		TestUtils.assertDatasetEquals(exp, act);

		act = DatasetFactory.createFromObject(DoubleDataset.class, null, null);
		TestUtils.assertDatasetEquals(exp, act);

		act = DatasetFactory.createFromObject(DoubleDataset.class, new double[0], null);
		TestUtils.assertDatasetEquals(exp, act);

		act = DatasetFactory.createFromObject(DoubleDataset.class, new double[0]);
		TestUtils.assertDatasetEquals(exp, act);

		act = DatasetFactory.createFromObject(DoubleDataset.class, null, 0);
		TestUtils.assertDatasetEquals(exp.reshape(0), act);

		act = DatasetFactory.createFromObject(DoubleDataset.class, new double[0], 0);
		TestUtils.assertDatasetEquals(exp.reshape(0), act);

		act = DatasetFactory.createFromObject(DoubleDataset.class, new double[0], 0, 0, 0);
		TestUtils.assertDatasetEquals(exp.reshape(0, 0, 0), act);

		act = DatasetFactory.createFromObject(DoubleDataset.class, new double[0], 0, 1, 0);
		TestUtils.assertDatasetEquals(exp.reshape(0, 1, 0), act);

		// zero-ranked (unit size)
		exp = new DoubleDataset(new double[] {3});
		exp.setShape();
		act = DatasetFactory.createFromObject(DoubleDataset.class, (Object) 3);
		TestUtils.assertDatasetEquals(exp, act);

		// one dimensional
		exp = new DoubleDataset(new double[] { 3, 4, 5 });
		act = DatasetFactory.createFromObject(DoubleDataset.class, new double[] { 3, 4, 5 });
		TestUtils.assertDatasetEquals(exp, act);

		// two dimensional
		exp = new DoubleDataset(new double[] {3, 4, 5, 6, 7, 8}, 2, 3);
		act = DatasetFactory.createFromObject(DoubleDataset.class, new double[] {3, 4, 5, 6, 7, 8}, 2, 3);
		TestUtils.assertDatasetEquals(exp, act);

		act = DatasetFactory.createFromObject(DoubleDataset.class, new double[][] {{3, 4, 5}, {6, 7, 8}});
		TestUtils.assertDatasetEquals(exp, act);
	}

	@Test
	public void testCreatorInteger() {
		IntegerDataset act, exp;

		// zero-sized
		exp = new IntegerDataset();
		act = DatasetFactory.createFromObject(IntegerDataset.class, null, null);
		TestUtils.assertDatasetEquals(exp, act);

		act = DatasetFactory.createFromObject(IntegerDataset.class, new int[0], null);
		TestUtils.assertDatasetEquals(exp, act);

		// zero-ranked (unit size)
		exp = new IntegerDataset(new int[] {3}, null);
		exp.setShape();
		act = DatasetFactory.createFromObject(IntegerDataset.class, (Object) 3);
		TestUtils.assertDatasetEquals(exp, act);

		// one dimensional
		exp = new IntegerDataset(new int[] { 3, 4, 5 }, null);
		act = DatasetFactory.createFromObject(IntegerDataset.class, new int[] { 3, 4, 5 }, null);
		TestUtils.assertDatasetEquals(exp, act);

		// two dimensional
		exp = new IntegerDataset(new int[] {3, 4, 5, 6, 7, 8}, 2, 3);
		act = DatasetFactory.createFromObject(IntegerDataset.class, new int[] {3, 4, 5, 6, 7, 8}, 2, 3);
		TestUtils.assertDatasetEquals(exp, act);

		act = DatasetFactory.createFromObject(IntegerDataset.class, new int[][] {{3, 4, 5}, {6, 7, 8}});
		TestUtils.assertDatasetEquals(exp, act);
	}

	@Test
	public void testCreatorElemental() {
		DoubleDataset act, exp;

		// zero-sized
		exp = new DoubleDataset();
		act = DatasetFactory.createFromObject(1, DoubleDataset.class, null, null);
		TestUtils.assertDatasetEquals(exp, act);

		// zero-ranked (unit size)
		exp = new DoubleDataset(new double[] {3});
		exp.setShape();
		act = DatasetFactory.createFromObject(1, DoubleDataset.class, (Object) 3);
		TestUtils.assertDatasetEquals(exp, act);

		// one dimensional
		exp = new DoubleDataset(new double[] { 3, 4, 5 });
		act = DatasetFactory.createFromObject(1, DoubleDataset.class, new double[] { 3, 4, 5 });
		TestUtils.assertDatasetEquals(exp, act);

		// two dimensional
		exp = new DoubleDataset(new double[] {3, 4, 5, 6, 7, 8}, 2, 3);
		act = DatasetFactory.createFromObject(1, DoubleDataset.class, new double[] {3, 4, 5, 6, 7, 8}, 2, 3);
		TestUtils.assertDatasetEquals(exp, act);
	}

	@Test
	public void testCreatorCompound() {
		CompoundDoubleDataset act, exp;

		// zero-sized
		exp = new CompoundDoubleDataset();
		act = DatasetFactory.createFromObject(0, CompoundDoubleDataset.class, null, null);
		TestUtils.assertDatasetEquals(exp, act);

		exp = new CompoundDoubleDataset(1);
		act = DatasetFactory.createFromObject(1, CompoundDoubleDataset.class, null, null);
		TestUtils.assertDatasetEquals(exp, act);

		exp = new CompoundDoubleDataset(2);
		act = DatasetFactory.createFromObject(2, CompoundDoubleDataset.class, null, null);
		TestUtils.assertDatasetEquals(exp, act);

		// zero-ranked (unit size)
		exp = new CompoundDoubleDataset(1, new double[] {3}, new int[0]);
		act = DatasetFactory.createFromObject(1, CompoundDoubleDataset.class, 3.);
		TestUtils.assertDatasetEquals(exp, act);

		exp = new CompoundDoubleDataset(2, new double[] {3, 4}, new int[0]);
		act = DatasetFactory.createFromObject(2, CompoundDoubleDataset.class, new double[] {3, 4});
		TestUtils.assertDatasetEquals(exp, act);

		// one dimensional
		exp = new CompoundDoubleDataset(1, new double[] {3, 4, 5, 6});
		act = DatasetFactory.createFromObject(1, CompoundDoubleDataset.class, new double[] {3, 4, 5, 6});
		TestUtils.assertDatasetEquals(exp, act);

		exp = new CompoundDoubleDataset(2, new double[] {3, 4, 5, 6});
		act = DatasetFactory.createFromObject(2, CompoundDoubleDataset.class, new double[] {3, 4, 5, 6});
		TestUtils.assertDatasetEquals(exp, act);

		// two dimensional
		exp = new CompoundDoubleDataset(1, new double[] {3, 5, 7}, new int[] {3, 1});
		act = DatasetFactory.createFromObject(1, CompoundDoubleDataset.class, new double[] {3, 5, 7}, 3, 1);
		TestUtils.assertDatasetEquals(exp, act);

		exp = new CompoundDoubleDataset(2, new double[] {3, 4, 5, 6, 7, 8}, new int[] {3, 1});
		act = DatasetFactory.createFromObject(2, CompoundDoubleDataset.class, new double[] {3, 4, 5, 6, 7, 8}, 3, 1);
		TestUtils.assertDatasetEquals(exp, act);

		act = DatasetFactory.createCompoundDataset(CompoundDoubleDataset.class, new double[] {3, 5, 7} , new double[] {4, 6, 8});
		act.setShape(3, 1);
		TestUtils.assertDatasetEquals(exp, act);
	}

	@Test
	public void testCreatorComplex() {
		ComplexDoubleDataset act, exp;

		exp = new ComplexDoubleDataset(new double[] {3, 5, 7}, new double[] {4, 6, 8}, new int[] {3, 1});
		act = DatasetFactory.createComplexDataset(ComplexDoubleDataset.class, new double[] {3, 5, 7} , new double[] {4, 6, 8});
		act.setShape(3, 1);
		TestUtils.assertDatasetEquals(exp, act);
	}

	@Test
	public void testRGBCreator() {
		RGBDataset act, exp;

		// zero-sized
		exp = new RGBDataset();
		act = DatasetFactory.createFromObject(0, RGBDataset.class, null, null);
		TestUtils.assertDatasetEquals(exp, act);

		// zero-ranked (unit size)
		exp = new RGBDataset(new short[] {3, 4, 5}, new int[0]);
		act = DatasetFactory.createFromObject(2, RGBDataset.class, new short[] {3, 4, 5});
		TestUtils.assertDatasetEquals(exp, act);

		// one dimensional
		exp = new RGBDataset(new short[] {3, 4, 5, 6, 7, 8});
		act = DatasetFactory.createFromObject(2, RGBDataset.class, new short[] {3, 4, 5, 6, 7, 8});
		TestUtils.assertDatasetEquals(exp, act);

		// two dimensional
		exp = new RGBDataset(new short[] {3, 4, 5, 6, 7, 8, 9, 0, 1}, new int[] {3, 1});
		act = DatasetFactory.createFromObject(2, RGBDataset.class, new short[] {3, 4, 5, 6, 7, 8, 9, 0, 1}, 3, 1);
		TestUtils.assertDatasetEquals(exp, act);

		// one dimensional
		exp = new RGBDataset(new short[] {3, 4, 5, 6, 7, 8});
		act = DatasetFactory.createFromObject(RGBDataset.class, new short[] {3, 4, 5, 6, 7, 8});
		TestUtils.assertDatasetEquals(exp, act);
	}

	@Test
	public void testCreatorDataset() {
		Dataset a = DatasetFactory.createRange(10).reshape(5, 2);
		Dataset act = DatasetFactory.createFromObject(new IDataset[] {a, a, a});
		assertEquals(3, act.getRank());
		assertArrayEquals(new int[] {3, 5, 2}, act.getShapeRef());
		Dataset b = a.reshape(1, 5, 2);
		Dataset exp = DatasetUtils.concatenate(new IDataset[] {b, b, b}, 0);
		TestUtils.assertDatasetEquals(exp, act);

		List<IDataset> list = new ArrayList<>();
		list.add(a);
		list.add(a);
		list.add(a);
		act = DatasetFactory.createFromObject(list);
		TestUtils.assertDatasetEquals(exp, act);

		act = DatasetFactory.createFromList(list);
		TestUtils.assertDatasetEquals(exp, act);
	}

	@Test
	public void testLinearSpace() {
		DoubleDataset act = DatasetFactory.createLinearSpace(DoubleDataset.class, 2, 12.4, 4);
		Dataset exp = DatasetFactory.createFromObject(new double[] {2, 5.4666666666666666666, 8.9333333333333333333, 12.4});
		TestUtils.assertDatasetEquals(exp, act);

		act = DatasetFactory.createLinearSpace(DoubleDataset.class, 12.4, 2, 4);
		exp = DatasetFactory.createFromObject(new double[] {12.4, 8.9333333333333333333, 5.4666666666666666666, 2});
		TestUtils.assertDatasetEquals(exp, act);
	}

	@Test
	public void testLogSpace() {
		DoubleDataset act = DatasetFactory.createLogSpace(DoubleDataset.class, 2, 3.6, 4, 3.5);
		Dataset exp = DatasetFactory.createFromObject(new double[] {12.25, 23.89492724, 46.60959572, 90.91697129});
		TestUtils.assertDatasetEquals(exp, act, 1e-9, 1e-9);

		act = DatasetFactory.createLogSpace(DoubleDataset.class, 3.6, 2, 4, 3.5);
		exp = DatasetFactory.createFromObject(new double[] {90.91697129, 46.60959572, 23.89492724, 12.25});
		TestUtils.assertDatasetEquals(exp, act, 1e-9, 1e-9);
	}
}
