/*-
 * Copyright (c) 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.dataset;

import static org.junit.Assert.assertEquals;

import org.eclipse.dawnsci.analysis.dataset.impl.CompoundDoubleDataset;
import org.eclipse.dawnsci.analysis.dataset.impl.DatasetFactory;
import org.eclipse.dawnsci.analysis.dataset.impl.DoubleDataset;
import org.eclipse.dawnsci.analysis.dataset.impl.IntegerDataset;
import org.eclipse.dawnsci.analysis.dataset.impl.RGBDataset;
import org.junit.Test;

public class DatasetFactoryTest {

	@Test
	public void testZeros() {
		DoubleDataset act, exp;

		// zero-sized
		exp = new DoubleDataset();
		act = DatasetFactory.zeros(DoubleDataset.class, null);
		assertEquals(exp, act);

		// zero-ranked
		exp = new DoubleDataset(new int[0]);
		act = DatasetFactory.zeros(DoubleDataset.class);
		assertEquals(exp, act);

		// one dimensional
		exp = new DoubleDataset(3);
		act = DatasetFactory.zeros(DoubleDataset.class, 3);
		assertEquals(exp, act);

		// two dimensional
		exp = new DoubleDataset(0, 0);
		act = DatasetFactory.zeros(DoubleDataset.class, 0, 0);
		assertEquals(exp, act);

		// three dimensional
		exp = new DoubleDataset(3, 4, 5);
		act = DatasetFactory.zeros(DoubleDataset.class, 3, 4, 5);
		assertEquals(exp, act);
	}

	@Test
	public void testZerosElemental() {
		DoubleDataset act, exp;

		// zero-sized
		exp = new DoubleDataset();
		act = DatasetFactory.zeros(1, DoubleDataset.class, null);
		assertEquals(exp, act);

		// zero-ranked
		exp = new DoubleDataset(new int[0]);
		act = DatasetFactory.zeros(1, DoubleDataset.class);
		assertEquals(exp, act);

		// one dimensional
		exp = new DoubleDataset(3);
		act = DatasetFactory.zeros(1, DoubleDataset.class, 3);
		assertEquals(exp, act);

		// three dimensional
		exp = new DoubleDataset(3, 4, 5);
		act = DatasetFactory.zeros(1, DoubleDataset.class, 3, 4, 5);
		assertEquals(exp, act);
	}

	@Test
	public void testZerosCompound() {
		CompoundDoubleDataset act, exp;

		// zero-sized
		exp = new CompoundDoubleDataset();
		act = DatasetFactory.zeros(0, CompoundDoubleDataset.class, null);
		assertEquals(exp, act);

		exp = new CompoundDoubleDataset(2);
		act = DatasetFactory.zeros(2, CompoundDoubleDataset.class, null);
		assertEquals(exp, act);

		// zero-ranked
		exp = new CompoundDoubleDataset(2, new int[0]);
		act = DatasetFactory.zeros(2, CompoundDoubleDataset.class);
		assertEquals(exp, act);

		// one dimensional
		exp = new CompoundDoubleDataset(2, new int[] {3});
		act = DatasetFactory.zeros(2, CompoundDoubleDataset.class, 3);
		assertEquals(exp, act);

		// three dimensional
		exp = new CompoundDoubleDataset(2, new int[] {3, 4, 5});
		act = DatasetFactory.zeros(2, CompoundDoubleDataset.class, 3, 4, 5);
		assertEquals(exp, act);
	}

	@Test
	public void testCreator() {
		DoubleDataset act, exp;

		// zero-sized
		exp = new DoubleDataset();
		act = DatasetFactory.createFromObject(DoubleDataset.class, null, null);
		assertEquals(exp, act);

		// zero-ranked
		exp = new DoubleDataset(new double[] {3});
		exp.setShape();
		act = DatasetFactory.createFromObject(DoubleDataset.class, (Object) 3);
		assertEquals(exp, act);

		// one dimensional
		exp = new DoubleDataset(new double[] { 3, 4, 5 });
		act = DatasetFactory.createFromObject(DoubleDataset.class, new double[] { 3, 4, 5 });
		assertEquals(exp, act);

		// two dimensional
		exp = new DoubleDataset(new double[] {3, 4, 5, 6, 7, 8}, 2, 3);
		act = DatasetFactory.createFromObject(DoubleDataset.class, new double[] {3, 4, 5, 6, 7, 8}, 2, 3);
		assertEquals(exp, act);

		act = DatasetFactory.createFromObject(DoubleDataset.class, new double[][] {{3, 4, 5}, {6, 7, 8}});
		assertEquals(exp, act);
	}

	@Test
	public void testCreatorInteger() {
		IntegerDataset act, exp;

		// zero-sized
		exp = new IntegerDataset();
		act = DatasetFactory.createFromObject(IntegerDataset.class, null, null);
		assertEquals(exp, act);

		// zero-ranked
		exp = new IntegerDataset(new int[] {3}, null);
		exp.setShape();
		act = DatasetFactory.createFromObject(IntegerDataset.class, (Object) 3);
		assertEquals(exp, act);

		// one dimensional
		exp = new IntegerDataset(new int[] { 3, 4, 5 }, null);
		act = DatasetFactory.createFromObject(IntegerDataset.class, new int[] { 3, 4, 5 }, null);
		assertEquals(exp, act);

		// two dimensional
		exp = new IntegerDataset(new int[] {3, 4, 5, 6, 7, 8}, 2, 3);
		act = DatasetFactory.createFromObject(IntegerDataset.class, new int[] {3, 4, 5, 6, 7, 8}, 2, 3);
		assertEquals(exp, act);

		act = DatasetFactory.createFromObject(IntegerDataset.class, new int[][] {{3, 4, 5}, {6, 7, 8}});
		assertEquals(exp, act);
	}

	@Test
	public void testCreatorElemental() {
		DoubleDataset act, exp;

		// zero-sized
		exp = new DoubleDataset();
		act = DatasetFactory.createFromObject(1, DoubleDataset.class, null, null);
		assertEquals(exp, act);

		// zero-ranked
		exp = new DoubleDataset(new double[] {3});
		exp.setShape();
		act = DatasetFactory.createFromObject(1, DoubleDataset.class, (Object) 3);
		assertEquals(exp, act);

		// one dimensional
		exp = new DoubleDataset(new double[] { 3, 4, 5 });
		act = DatasetFactory.createFromObject(1, DoubleDataset.class, new double[] { 3, 4, 5 });
		assertEquals(exp, act);

		// two dimensional
		exp = new DoubleDataset(new double[] {3, 4, 5, 6, 7, 8}, 2, 3);
		act = DatasetFactory.createFromObject(1, DoubleDataset.class, new double[] {3, 4, 5, 6, 7, 8}, 2, 3);
		assertEquals(exp, act);
	}

	@Test
	public void testCreatorCompound() {
		CompoundDoubleDataset act, exp;

		// zero-sized
		exp = new CompoundDoubleDataset();
		act = DatasetFactory.createFromObject(0, CompoundDoubleDataset.class, null, null);
		assertEquals(exp, act);

		exp = new CompoundDoubleDataset(2);
		act = DatasetFactory.createFromObject(2, CompoundDoubleDataset.class, null, null);
		assertEquals(exp, act);

		// zero-ranked
		exp = new CompoundDoubleDataset(2, new double[] {3, 4}, new int[0]);
		act = DatasetFactory.createFromObject(2, CompoundDoubleDataset.class, new double[] {3, 4});
		assertEquals(exp, act);

		// one dimensional
		exp = new CompoundDoubleDataset(2, new double[] {3, 4, 5, 6});
		act = DatasetFactory.createFromObject(2, CompoundDoubleDataset.class, new double[] {3, 4, 5, 6});
		assertEquals(exp, act);

		// two dimensional
		exp = new CompoundDoubleDataset(2, new double[] {3, 4, 5, 6, 7, 8}, new int[] {3, 1});
		act = DatasetFactory.createFromObject(2, CompoundDoubleDataset.class, new double[] {3, 4, 5, 6, 7, 8}, 3, 1);
		assertEquals(exp, act);
	}

	@Test
	public void testRGBCreator() {
		RGBDataset act, exp;

		// zero-sized
		exp = new RGBDataset();
		act = DatasetFactory.createFromObject(0, RGBDataset.class, null, null);
		assertEquals(exp, act);

		// zero-ranked
		exp = new RGBDataset(new short[] {3, 4, 5}, new int[0]);
		act = DatasetFactory.createFromObject(2, RGBDataset.class, new short[] {3, 4, 5});
		assertEquals(exp, act);

		// one dimensional
		exp = new RGBDataset(new short[] {3, 4, 5, 6, 7, 8});
		act = DatasetFactory.createFromObject(2, RGBDataset.class, new short[] {3, 4, 5, 6, 7, 8});
		assertEquals(exp, act);

		// two dimensional
		exp = new RGBDataset(new short[] {3, 4, 5, 6, 7, 8, 9, 0, 1}, new int[] {3, 1});
		act = DatasetFactory.createFromObject(2, RGBDataset.class, new short[] {3, 4, 5, 6, 7, 8, 9, 0, 1}, 3, 1);
		assertEquals(exp, act);

		// one dimensional
		exp = new RGBDataset(new short[] {3, 4, 5, 6, 7, 8});
		act = DatasetFactory.createFromObject(RGBDataset.class, new short[] {3, 4, 5, 6, 7, 8});
		assertEquals(exp, act);
	}
}

