/*-
 * Copyright (c) 2012, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import static org.junit.Assert.assertEquals;

import org.apache.commons.math3.complex.Complex;
import org.eclipse.january.asserts.TestUtils;
import org.junit.Test;

public class IntegerDatasetTest {

	@Test
	public void testConstructor() {
		assertEquals(0, new IntegerDataset().getSize());
		assertEquals(0, DatasetFactory.createFromObject(1).getRank());

		int[] da = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		IntegerDataset a = new IntegerDataset(da, null);

		IndexIterator it = a.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i, a.getElementLongAbs(it.index));
		}

		IntegerDataset b = new IntegerDataset(da, 3, 4);

		it = b.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i, b.getElementLongAbs(it.index));
		}

		// test hashes
		a.hashCode();
		b.hashCode();

		Class<? extends Dataset> clazz = a.getClass();
		assertEquals(true,  InterfaceUtils.isElemental(clazz));
		assertEquals(false, InterfaceUtils.isCompound(clazz));
		assertEquals(true,  InterfaceUtils.isInteger(clazz));
		assertEquals(true,  InterfaceUtils.isNumerical(clazz));
		assertEquals(false, InterfaceUtils.isFloating(clazz));
		assertEquals(false, InterfaceUtils.isComplex(clazz));
	}

	@Test
	public void testStats() {
		Dataset a = DatasetFactory.createRange(IntegerDataset.class, 12);
		assertEquals(Integer.valueOf(11), a.max());
		assertEquals(0., a.min().doubleValue(), 1e-6);
		assertEquals(5.5, ((Number) a.mean()).doubleValue(), 1e-6);
		assertEquals(3.6055512754639891, a.stdDeviation(), 1e-6);
		assertEquals(13., a.variance(), 1e-6);
	}
	
	@Test
	public void testPosition() {
		double[] da = { 0, 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1 };
		DoubleDataset a = new DoubleDataset(da);
		
		assertEquals(6,a.maxPos()[0]);
		assertEquals(0,a.minPos()[0]);
		
		Dataset b = DatasetFactory.zeros(IntegerDataset.class, 100, 200);
		
		b.set(100, new int[]{50,100});
		b.set(-100, new int[]{51,101});
		
		assertEquals(50,b.maxPos()[0]);
		assertEquals(100,b.maxPos()[1]);
		assertEquals(51,b.minPos()[0]);
		assertEquals(101,b.minPos()[1]);
		
	}

	@Test
	public void testInplaceMethods() {
		Dataset a = DatasetFactory.createRange(IntegerDataset.class, 6);
		Dataset b = DatasetFactory.createRange(IntegerDataset.class, 6);
		Dataset bl = DatasetFactory.createRange(LongDataset.class, 6);
		Dataset c, t;

		// add
		c = a.clone();
		TestUtils.assertDatasetEquals(a, c.iadd(b.getSliceView(new Slice(1))));

		c = a.clone();
		TestUtils.assertDatasetEquals(a, c.iadd(bl.getSliceView(new Slice(1))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.add(a, 3), c.iadd(b.getSliceView(new Slice(3, 4))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.add(a, 3l), c.iadd(bl.getSliceView(new Slice(3, 4))));

		c = a.clone();
		c.iadd(b);
		TestUtils.assertDatasetEquals(Maths.add(a, b), c);
		TestUtils.assertDatasetEquals(Maths.multiply(a, 2), c);

		c = a.clone();
		c.iadd(bl);
		TestUtils.assertDatasetEquals(Maths.add(a, bl).cast(IntegerDataset.class), c);
		TestUtils.assertDatasetEquals(Maths.multiply(a, 2l).cast(IntegerDataset.class), c);

		// subtract
		c = a.clone();
		TestUtils.assertDatasetEquals(a, c.isubtract(b.getSliceView(new Slice(1))));

		c = a.clone();
		TestUtils.assertDatasetEquals(a, c.isubtract(bl.getSliceView(new Slice(1))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.subtract(a, 3), c.isubtract(b.getSliceView(new Slice(3, 4))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.subtract(a, 3l).cast(IntegerDataset.class), c.isubtract(bl.getSliceView(new Slice(3, 4))));

		c = a.clone();
		c.isubtract(b);
		TestUtils.assertDatasetEquals(DatasetFactory.zeros(a), c);
		TestUtils.assertDatasetEquals(Maths.multiply(a, 0), c);

		c = a.clone();
		c.isubtract(bl);
		TestUtils.assertDatasetEquals(DatasetFactory.zeros(a), c);
		TestUtils.assertDatasetEquals(Maths.multiply(a, 0), c);

		// multiply
		c = a.clone();
		TestUtils.assertDatasetEquals(a, c.imultiply(b.getSliceView(new Slice(1, 2))));

		c = a.clone();
		TestUtils.assertDatasetEquals(a, c.imultiply(bl.getSliceView(new Slice(1, 2))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.multiply(a, 3), c.imultiply(b.getSliceView(new Slice(3, 4))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.multiply(a, 3l).cast(IntegerDataset.class), c.imultiply(bl.getSliceView(new Slice(3, 4))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.multiply(a, b), c.imultiply(b));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.multiply(a, bl).cast(IntegerDataset.class), c.imultiply(bl));

		c = a.clone();
		c.imultiply(b);
		TestUtils.assertDatasetEquals(Maths.power(a, 2), c);
		TestUtils.assertDatasetEquals(Maths.square(a).cast(IntegerDataset.class), c);

		c = a.clone();
		c.imultiply(bl);
		TestUtils.assertDatasetEquals(Maths.power(a, 2l), c);
		TestUtils.assertDatasetEquals(Maths.square(a).cast(IntegerDataset.class), c);

		// divide
		c = a.clone();
		TestUtils.assertDatasetEquals(DatasetFactory.zeros(a), c.idivide(b.getSliceView(new Slice(1))));

		c = a.clone();
		TestUtils.assertDatasetEquals(DatasetFactory.zeros(a), c.idivide(bl.getSliceView(new Slice(1))));

		c = a.clone();
		TestUtils.assertDatasetEquals(a, c.idivide(b.getSliceView(new Slice(1, 2))));

		c = a.clone();
		TestUtils.assertDatasetEquals(a, c.idivide(bl.getSliceView(new Slice(1, 2))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.divide(a, 3), c.idivide(b.getSliceView(new Slice(3, 4))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.divide(a, 3l), c.idivide(bl.getSliceView(new Slice(3, 4))));

		c = a.clone();
		t = DatasetFactory.ones(a);
		t.set(Double.NaN, 0);
		TestUtils.assertDatasetEquals(t, c.idivide(b));

		c = a.clone();
		TestUtils.assertDatasetEquals(t, c.idivide(bl));

		// remainder
		c = a.clone();
		TestUtils.assertDatasetEquals(DatasetFactory.zeros(a), c.iremainder(b.getSliceView(new Slice(1))));

		c = a.clone();
		TestUtils.assertDatasetEquals(DatasetFactory.zeros(a), c.iremainder(bl.getSliceView(new Slice(1))));

		c = a.clone();
		TestUtils.assertDatasetEquals(DatasetFactory.zeros(a), c.iremainder(b.getSliceView(new Slice(1, 2))));

		c = a.clone();
		TestUtils.assertDatasetEquals(DatasetFactory.zeros(a), c.iremainder(bl.getSliceView(new Slice(1, 2))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.remainder(a, 3), c.iremainder(b.getSliceView(new Slice(3, 4))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.remainder(a, 3l), c.iremainder(bl.getSliceView(new Slice(3, 4))));

		c = a.clone();
		t = DatasetFactory.zeros(a);
		TestUtils.assertDatasetEquals(t, c.iremainder(b));

		c = a.clone();
		TestUtils.assertDatasetEquals(t, c.iremainder(bl));

		// power
		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, 3), c.ipower(3));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, -3), c.ipower(-3));

		c = a.clone();
		TestUtils.assertDatasetEquals(a, c.ipower(b.getSliceView(new Slice(1, 2))));

		c = a.clone();
		TestUtils.assertDatasetEquals(a, c.ipower(bl.getSliceView(new Slice(1, 2))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, 3), c.ipower(b.getSliceView(new Slice(3, 4))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, b), c.ipower(b));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, bl).cast(IntegerDataset.class), c.ipower(bl));

		c = a.clone();
		TestUtils.assertDatasetEquals(a, c.ipower(bl.getSliceView(new Slice(1, 2))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, 3), c.ipower(b.getSliceView(new Slice(3, 4))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, 3), c.ipower(bl.getSliceView(new Slice(3, 4))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, b), c.ipower(b));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, bl).cast(IntegerDataset.class), c.ipower(bl));

		c = a.clone();
		t = Maths.negative(Maths.add(b, 1));
		TestUtils.assertDatasetEquals(Maths.power(a, t).cast(IntegerDataset.class), c.ipower(t));

		ComplexDoubleDataset z;
		z = DatasetFactory.createComplexDataset(ComplexDoubleDataset.class, a, DatasetFactory.zeros(a));
		c = a.clone();
		TestUtils.assertDatasetEquals(a, c.ipower(z.getSliceView(new Slice(1, 2))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, 3), c.ipower(z.getSliceView(new Slice(3, 4))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, z).getRealView().cast(IntegerDataset.class), c.ipower(z));

		z = DatasetFactory.createComplexDataset(ComplexDoubleDataset.class, Maths.negative(a), DatasetFactory.zeros(a));
		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.reciprocal(a), c.ipower(z.getSliceView(new Slice(1, 2))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, -3), c.ipower(z.getSliceView(new Slice(3, 4))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, z).getRealView().cast(IntegerDataset.class), c.ipower(z));

		z = DatasetFactory.createComplexDataset(ComplexDoubleDataset.class, a, a);
		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, new Complex(1, 1)).getRealView().cast(IntegerDataset.class), c.ipower(z.getSliceView(new Slice(1, 2))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, new Complex(3, 3)).getRealView().cast(IntegerDataset.class), c.ipower(z.getSliceView(new Slice(3, 4))));

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.power(a, z).getRealView().cast(IntegerDataset.class), c.ipower(z));

		// floor
		a = Maths.multiply(a, 1.5);

		c = a.clone();
		TestUtils.assertDatasetEquals(Maths.floor(a), c.ifloor());
	}
}
