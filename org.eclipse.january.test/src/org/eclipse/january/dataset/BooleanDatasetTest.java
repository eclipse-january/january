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
import static org.junit.Assert.assertArrayEquals;

import org.eclipse.january.asserts.TestUtils;
import org.junit.Test;

public class BooleanDatasetTest {

	private final static double ABSERRD = 1e-8;

	@Test
	public void testConstructor() {
		assertEquals(0, new BooleanDataset().getSize());
		assertEquals(0, DatasetFactory.createFromObject(true).getRank());

		boolean[] da = { false, true, false, true, false, true, false, true, false, true, false, true };
		BooleanDataset a = DatasetFactory.createFromObject(BooleanDataset.class, da);

		IndexIterator it = a.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i % 2 != 0, a.getElementBooleanAbs(it.index));
		}

		BooleanDataset b = DatasetFactory.createFromObject(BooleanDataset.class, da, 3, 4);

		it = b.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i % 2 != 0, b.getElementBooleanAbs(it.index));
		}

		// test hashes
		a.hashCode();
		b.hashCode();
	}

	@Test
	public void testGetter() {
		boolean[] da = { false, true, false, true, false, true, false, true, false, true, false, true };
		BooleanDataset a = DatasetFactory.createFromObject(BooleanDataset.class, da);
		int l = da.length;
		for (int i = 0; i < l; i++) {
			assertEquals(da[i], a.getBoolean(i));
		}

		for (int i = 0; i < l; i++) {
			boolean r = da[l - 1 - i];
			assertEquals(r, a.getBoolean(-(i + 1)));
		}

		Dataset sv = a.getSliceView(new Slice(2, 7));
		Dataset sc = a.getSlice(new Slice(2, 7));
		l = sc.getSize();
		for (int i = 0; i < l; i++) {
			boolean r = sc.getBoolean(-(i + 1));
			assertEquals(r, sv.getBoolean(-(i + 1)));
		}
	}

	@Test
	public void testISubstract() {
		boolean[] obj = new boolean[] { true, false, true, true };
		boolean[] objToSubstract = new boolean[] { false, false, true, true };
		Dataset input = DatasetFactory.createFromObject(BooleanDataset.class, obj);

		boolean[] result = new boolean[4];
		for (int index = 0; index < 4; index++) {
			result[index] = obj[index] ^ objToSubstract[index];
		}
		Dataset output = DatasetFactory.createFromObject(BooleanDataset.class, result);
		input.isubtract(objToSubstract);

		TestUtils.assertDatasetEquals(output, input);
	}

	@Test
	public void testGetElementBooleanAbs() {
		int[] values = { 0, 1, 2, 3 };

		boolean[] value = new boolean[] { true, true, true, false };
		Dataset input = DatasetFactory.createFromObject(BooleanDataset.class, value);

		for (int val : values) {
			boolean actualResult = input.getElementBooleanAbs(val);
			boolean result = value[val];
			assertEquals(result, actualResult);
		}
	}

	@Test
	public void testGetElementbooleanAbs() {
		int[] values = { 0, 1, 2, 3 };

		boolean[] value = new boolean[] { true, true, true, false };
		Dataset input = DatasetFactory.createFromObject(BooleanDataset.class, value);

		for (int val : values) {
			boolean actualResult = input.getElementBooleanAbs(val);
			boolean result = value[val];
			assertEquals(result, actualResult);
		}
	}

	@Test
	public void testGetElementLongAbs() {
		int[] values = { 0, 1, 2, 3 };

		boolean[] value = new boolean[] { false, true, true, true };
		Dataset input = DatasetFactory.createFromObject(BooleanDataset.class, value);

		boolean[] results = new boolean[4];
		boolean[] expectedResults = new boolean[4];
		for (int i = 0; i<value.length;i++) {
			results[i] = input.getElementLongAbs(values[i]) <= 0 ? false : true;
			expectedResults[i] = value[i];
		}
		assertArrayEquals(expectedResults, results);
	}
	
	@Test
	public void testEquals() {
		boolean[] value = new boolean[] { true, true, true, false };
		boolean[] value2 = new boolean[] { true, false, true, false };

		Dataset input = DatasetFactory.createFromObject(BooleanDataset.class, value);

		Dataset checkerTrue = DatasetFactory.createFromObject(BooleanDataset.class, value);
		Dataset checkerFalse = DatasetFactory.createFromObject(BooleanDataset.class, value2);

		boolean checkInput1 = input.equals(checkerTrue);
		boolean checkInput2 = input.equals(checkerFalse);

		assertEquals(checkInput1, true);
		assertEquals(checkInput2, false);
	}

	@Test
	public void testGetSlice() {
		boolean[] value = { true, true, false, true, true, false, true, false };
		boolean[] expectedObj = { false, true, true, false, true };
		Dataset dataset = DatasetFactory.createFromObject(BooleanDataset.class, value);
		Dataset expected = DatasetFactory.createFromObject(BooleanDataset.class, expectedObj);
		Dataset actual = dataset.getSlice(new Slice(2, 7));
		TestUtils.assertDatasetEquals(expected, actual);
	}

	@Test
	public void testFillDataset() {
		boolean[] value = new boolean[] { true, false, true, false };
		Dataset input = DatasetFactory.createFromObject(BooleanDataset.class, value);

		IndexIterator iter = input.getIterator();
		Dataset n = DatasetFactory.zeros(4);
		Dataset expected = DatasetFactory.createFromObject(BooleanDataset.class, n);
		input.fillDataset(expected, iter);
		TestUtils.assertDatasetEquals(expected, input);
	}

	@Test
	public void testFill() {
		boolean[] value = new boolean[] { true, false, true, false };
		Dataset input = DatasetFactory.createFromObject(BooleanDataset.class, value);
		Dataset output = DatasetFactory.ones(4);
		Dataset expected = DatasetFactory.createFromObject(BooleanDataset.class, output);
		input.fill(1);
		TestUtils.assertDatasetEquals(expected, input);
	}

	@Test
	public void testIAdd() {
		boolean[] value = new boolean[] { true, false, true, false };
		boolean[] valueToAdd = new boolean[] {  true, true, true, true };
		Dataset input = DatasetFactory.createFromObject(BooleanDataset.class, value);

		boolean[] result = new boolean[4];
		for (int index = 0; index < 4; index++) {
			result[index] = value[index] | valueToAdd[index];
		}
		Dataset expected = DatasetFactory.createFromObject(BooleanDataset.class, result);
		input.iadd(valueToAdd);

		TestUtils.assertDatasetEquals(expected, input);
	}

	@Test
	public void testIdivide() {
		boolean[] value = new boolean[] {  true, false, true, false };
		boolean[] valueToAdd = new boolean[] {  true, true, true, true };
		Dataset input = DatasetFactory.createFromObject(BooleanDataset.class, value);

		boolean[] result = new boolean[4];
		for (int index = 0; index < 4; index++) {
			result[index] = value[index] & valueToAdd[index];
		}
		Dataset expected = DatasetFactory.createFromObject(BooleanDataset.class, result);
		input.idivide(valueToAdd);

		TestUtils.assertDatasetEquals(expected, input);
	}

	@Test
	public void testSetByBoolean() {
		boolean[] value = new boolean[] {true, true, true, true };
		boolean[] newObj = new boolean[] { true, true };
		boolean[] bool = new boolean[] { true, false, true, false };

		Dataset input = DatasetFactory.createFromObject(BooleanDataset.class, value);
		Dataset newInput = DatasetFactory.createFromObject(BooleanDataset.class, newObj);
		Dataset boolInput = DatasetFactory.createFromObject(BooleanDataset.class, bool);
		Dataset output = input.setByBoolean(newInput, boolInput);

		boolean[] expectedObj = new boolean[] { true, true, true, true };
		Dataset expected = DatasetFactory.createFromObject(BooleanDataset.class, expectedObj);
		TestUtils.assertDatasetEquals(expected, output);
	}

	@Test
	public void testSetby1DIndex() {
		boolean valuesIn[] = { true, true, true, true };
		boolean valueExpected[] = { true, true, true, true };
		boolean valueOut[] = { true, true };
		Object out = DatasetFactory.createFromObject(BooleanDataset.class, valueOut);
		Dataset in = DatasetFactory.createFromObject(BooleanDataset.class, valuesIn);
		Dataset index = DatasetFactory.createFromObject(new int[] { 0, 2 });
		Dataset expected = DatasetFactory.createFromObject(BooleanDataset.class, valueExpected);
		Dataset actual = in.setBy1DIndex(out, index);
		TestUtils.assertDatasetEquals(expected, actual);
	}

	@Test
	public void testSetSlice() {
		boolean[] value = new boolean[] {true, true, true, true };
		boolean valueExpected[] = { true, true, false, false };

		Dataset input = DatasetFactory.createFromObject(BooleanDataset.class, value);
		Dataset expected = DatasetFactory.createFromObject(BooleanDataset.class, valueExpected);

		Dataset tdata = DatasetFactory.zeros(2);
		SliceIterator siter = (SliceIterator) input.getSliceIterator(new int[] { 2 }, new int[] { 4 }, null);
		input.setSlice(tdata, siter);

		TestUtils.assertDatasetEquals(expected, input);
	}

	@Test
	public void testSetByIndexes() {
		boolean valuesIn[][] = { { true, true, true, true }, { true, true, true, true } };
		boolean valueOut[] = { true, true };
		boolean valueExpected[][] = { { true, true, true, true }, { true, true, true, true } };
		Dataset expected = DatasetFactory.createFromObject(BooleanDataset.class, valueExpected);

		Dataset in = DatasetFactory.createFromObject(BooleanDataset.class, valuesIn);
		Object out = DatasetFactory.createFromObject(BooleanDataset.class, valueOut);
		Dataset index1 = DatasetFactory.createFromObject(new int[] { 0, 1 });
		Dataset index2 = DatasetFactory.createFromObject(new int[] { 1, 3 });
		Dataset actual = in.setByIndexes(out, index1, index2);

		TestUtils.assertDatasetEquals(expected, actual);
	}

	@Test
	public void testResidual() {
		boolean[] value = new boolean[] { false, true, true, true };
		boolean[] value2 = new boolean[] { true, true, true, true };
		boolean[] valueW = new boolean[] {  true, false, true, true };

		Dataset in = DatasetFactory.createFromObject(BooleanDataset.class, value);
		Dataset in2 = DatasetFactory.createFromObject(BooleanDataset.class, value2);
		Dataset w = DatasetFactory.createFromObject(BooleanDataset.class, valueW);

		double sumExpected = 1;
		
		double sum = in.residual(in2, w, true);

		assertEquals(sumExpected, sum, ABSERRD);

		sum = in.residual(in2, null, true);
		sumExpected = 1;
		assertEquals(sumExpected, sum, ABSERRD);
	}
}
