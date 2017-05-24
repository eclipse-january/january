package org.eclipse.january.dataset;

import org.eclipse.january.asserts.TestUtils;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParameterizeDatasetTests {

	@Parameters(name = "{index}: {0}")
	public static Collection<Object> data() {
		return Arrays.asList(new Object[] { FloatDataset.class, DoubleDataset.class, ByteDataset.class,
				ShortDataset.class, IntegerDataset.class, LongDataset.class });
	}

	@Parameter
	public Class<? extends Dataset> classType;

	private final static double ABSERRD = 1e-8;

	@Test
	public void testGetElementBooleanAbs() {
		Class<? extends Dataset> class1 = classType;
		int[] values = { 0, 1, 2, 3 };

		double[] value = new double[] { 4.2, -2.9, 6.10, 0.0 };
		Dataset input = DatasetFactory.createFromObject(class1, value);

		for (int val : values) {
			boolean actualResult = input.getElementBooleanAbs(val);
			boolean result = value[val] != 0;
			assertEquals(result, actualResult);
		}
	}

	@Test
	public void testGetElementDoubleAbs() {
		Class<? extends Dataset> class1 = classType;
		int[] values = { 0, 1, 2, 3 };

		double[] value = new double[] { 4.2, -2.9, 6.10, 0.0 };
		Dataset input = DatasetFactory.createFromObject(class1, value);

		for (int val : values) {
			double actualResult = input.getElementDoubleAbs(val);
			double result = value[val];
			assertEquals(result, actualResult, 0.9);
		}
	}

	@Test
	public void testGetElementLongAbs() {
		Class<? extends Dataset> class1 = classType;
		int[] values = { 0, 1, 2, 3 };

		double[] value = new double[] { 4.2, -2.9, 6.10, 0.0 };
		Dataset input = DatasetFactory.createFromObject(class1, value);

		for (int val : values) {
			long actualResult = input.getElementLongAbs(val);
			long result = (long) value[val];
			assertEquals(result, actualResult);
		}
	}

	@Test
	public void testEquals() {
		Class<? extends Dataset> class1 = classType;

		double[] value = new double[] { 4.2, -2.9, 6.10, 0.0 };
		double[] value2 = new double[] { 4.2, -7.9, 6.10, 0.0 };

		Dataset input = DatasetFactory.createFromObject(class1, value);

		Dataset checkerTrue = DatasetFactory.createFromObject(class1, value);
		Dataset checkerFalse = DatasetFactory.createFromObject(class1, value2);

		boolean checkInput1 = input.equals(checkerTrue);
		boolean checkInput2 = input.equals(checkerFalse);

		assertEquals(checkInput1, true);
		assertEquals(checkInput2, false);
	}

	@Test
	public void testCreateRange() {
		Class<? extends Dataset> class1 = classType;
		double[] value = new double[] { 0.0, 1.0, 2.0, 3.0, 4.0 };

		Dataset input = DatasetFactory.createRange(class1, 5);
		Dataset expected = DatasetFactory.createFromObject(class1, value);

		TestUtils.assertDatasetEquals(expected, input, true, ABSERRD, ABSERRD);
	}

	@Test
	public void testSort() {
		Class<? extends Dataset> class1 = classType;
		double[] value = new double[] { 4.2, -7.9, 6.10, 0.0 };
		double[] sortedObj = new double[] { -7.9, 0.0, 4.2, 6.10 };

		Dataset input = DatasetFactory.createFromObject(class1, value);
		Dataset expected = DatasetFactory.createFromObject(class1, sortedObj);
		input.sort(0);

		TestUtils.assertDatasetEquals(expected, input, true, ABSERRD, ABSERRD);

		// test with null argument
		input = DatasetFactory.createFromObject(class1, value);
		input.sort(null);
		TestUtils.assertDatasetEquals(expected, input, true, ABSERRD, ABSERRD);
	}

	@Test
	public void testResize() {
		Class<? extends Dataset> class1 = classType;
		double[] value = new double[] { 4.2, -7.9, 6.10, 0.0 };
		double[][] resizedObj = new double[][] { { 4.2, -7.9 }, { 6.10, 0.0 } };

		Dataset input = DatasetFactory.createFromObject(class1, value);
		Dataset expected = DatasetFactory.createFromObject(class1, resizedObj);
		input.resize(2, 2);
		TestUtils.assertDatasetEquals(expected, input, true, ABSERRD, ABSERRD);
	}

	@Test
	public void testGetUniqueItems() {
		Class<? extends Dataset> class1 = classType;
		double[] value = new double[] { 4.2, -7.9, 6.10, 0.0, 0.0 };
		double[] sortedObj = new double[] { -7.9, 0.0, 4.2, 6.10 };
		Dataset input = DatasetFactory.createFromObject(class1, value);
		Dataset expected = DatasetFactory.createFromObject(class1, sortedObj);
		input = input.getUniqueItems();
		TestUtils.assertDatasetEquals(expected, input, true, ABSERRD, ABSERRD);
	}

	@Test
	public void testGetSlice() {
		Class<? extends Dataset> class1 = classType;
		double[] value = { 52, 74, 0, -5, 71, 0, 3, -9 };
		double[] expectedObj = { 0, -5, 71, 0, 3 };
		Dataset dataset = DatasetFactory.createFromObject(class1, value);
		Dataset expected = DatasetFactory.createFromObject(class1, expectedObj);
		Dataset actual = dataset.getSlice(new Slice(2, 7));
		TestUtils.assertDatasetEquals(expected, actual, true, ABSERRD, ABSERRD);
	}

	@Test
	public void testFillDataset() {
		Class<? extends Dataset> class1 = classType;
		double[] value = new double[] { 4.2, -7.9, 6.10, 0.0 };
		Dataset input = DatasetFactory.createFromObject(class1, value);

		IndexIterator iter = input.getIterator();
		Dataset n = DatasetFactory.zeros(4);
		Dataset expected = DatasetFactory.createFromObject(class1, n);
		input.fillDataset(expected, iter);
		TestUtils.assertDatasetEquals(expected, input, true, ABSERRD, ABSERRD);
	}

	@Test
	public void testFill() {
		Class<? extends Dataset> class1 = classType;
		double[] value = new double[] { 4.2, -7.9, 6.10, 0.0 };
		Dataset input = DatasetFactory.createFromObject(class1, value);
		Dataset output = DatasetFactory.ones(4);
		Dataset expected = DatasetFactory.createFromObject(class1, output);
		input.fill(1);
		TestUtils.assertDatasetEquals(expected, input, true, ABSERRD, ABSERRD);
	}

	@Test
	public void testMaxPos() throws Exception {
		Class<? extends Dataset> class1 = classType;
		double da[] = { 1.2, 2.3, 13.0, 4.6, 2.8, 2.3, 13.0 };
		int maxExpected = 2;

		Dataset dataset = DatasetFactory.createFromObject(class1, da);
		int maxActual = dataset.maxPos()[0];
		assertEquals(maxExpected, maxActual);
	}

	@Test
	public void testMinPos() throws Exception {
		Class<? extends Dataset> class1 = classType;
		double da[] = { 1.2, 2.3, 13.0, 4.6, 2.8, 2.3, 13.0 };
		int minExpected = 0;
		Dataset dataset = DatasetFactory.createFromObject(class1, da);
		int minActual = dataset.minPos()[0];
		assertEquals(minActual, minExpected);
	}

	@Test
	public void testIAdd() {
		Class<? extends Dataset> class1 = classType;
		byte[] value = new byte[] { 4, -7, 6, 0 };
		byte[] valueToAdd = new byte[] { 5, 6, 7, 4 };
		Dataset input = DatasetFactory.createFromObject(class1, value);

		double[] result = new double[4];
		for (int index = 0; index < 4; index++) {
			result[index] = value[index] + valueToAdd[index];
		}
		Dataset expected = DatasetFactory.createFromObject(class1, result);
		input.iadd(valueToAdd);

		TestUtils.assertDatasetEquals(expected, input, true, 0.000001, 0.000001);
	}

	@Test
	public void testISubstract() {
		Class<? extends Dataset> class1 = classType;
		byte[] value = new byte[] { 4, -7, 6, 0 };
		byte[] valueToSubstract = new byte[] { 5, 6, 7, 4 };
		Dataset input = DatasetFactory.createFromObject(class1, value);

		double[] result = new double[4];
		for (int index = 0; index < 4; index++) {
			result[index] = value[index] - valueToSubstract[index];
		}
		Dataset expected = DatasetFactory.createFromObject(class1, result);
		input.isubtract(valueToSubstract);

		TestUtils.assertDatasetEquals(expected, input, true, 0.000001, 0.000001);
	}

	@Test
	public void testIReminder() {
		Class<? extends Dataset> class1 = classType;
		double[] value = new double[] { 4.2, -7.9, 6.10, 0.0 };
		double[] valueToSubstract = new double[] { 5.4, 6, 7.3, 4.6 };
		Dataset input = DatasetFactory.createFromObject(class1, value);

		double[] result = new double[4];
		for (int index = 0; index < 4; index++) {
			result[index] = value[index] % valueToSubstract[index];
		}
		Dataset expected = DatasetFactory.createFromObject(class1, result);
		input.iremainder(valueToSubstract);

		TestUtils.assertDatasetEquals(expected, input, true, 0.000001, 0.000001);
	}

	@Test
	public void testIdivide() {
		Class<? extends Dataset> class1 = classType;
		double[] value = new double[] { 4.2, -7.9, 6.10, 0.0 };
		double[] valueToAdd = new double[] { 5.4, 6, 7.3, 4.6 };
		Dataset input = DatasetFactory.createFromObject(class1, value);

		double[] result = new double[4];
		for (int index = 0; index < 4; index++) {
			result[index] = value[index] / valueToAdd[index];
		}
		Dataset expected = DatasetFactory.createFromObject(class1, result);
		input.idivide(valueToAdd);

		TestUtils.assertDatasetEquals(expected, input, true, 0.000001, 0.000001);
	}

	@Test
	public void testIpower() {
		Class<? extends Dataset> class1 = classType;
		double[] value = new double[] { 4, -7, 6, 0 };
		double[] valueToAdd = new double[] { 5.4, 6, 7.3, 4.6 };
		Dataset input = DatasetFactory.createFromObject(class1, value);

		double[] result = new double[4];
		for (int index = 0; index < 4; index++) {
			result[index] = Math.pow(value[index], valueToAdd[index]);
		}
		Dataset expected = DatasetFactory.createFromObject(class1, result);
		input.ipower(valueToAdd);

		TestUtils.assertDatasetEquals(expected, input, true, 0.000001, 0.000001);

		// test power with one number
		input = DatasetFactory.createFromObject(class1, value);
		result = new double[4];
		for (int index = 0; index < 4; index++) {
			result[index] = Math.pow(value[index], 2);
		}
		input.ipower(2);
		expected = DatasetFactory.createFromObject(class1, result);

		TestUtils.assertDatasetEquals(expected, input, true, 0.000001, 0.000001);
	}

	@Test
	public void testSetByBoolean() {
		Class<? extends Dataset> class1 = classType;
		double[] value = new double[] { 1.0, 2.0, 3.0, 4.0 };
		double[] newObj = new double[] { 5.0, 7.0 };
		boolean[] bool = new boolean[] { true, false, true, false };

		Dataset input = DatasetFactory.createFromObject(class1, value);
		Dataset newInput = DatasetFactory.createFromObject(class1, newObj);
		Dataset boolInput = DatasetFactory.createFromObject(BooleanDataset.class, bool);
		Dataset output = input.setByBoolean(newInput, boolInput);

		double[] expectedObj = new double[] { 5.0, 2.0, 7.0, 4.0 };
		Dataset expected = DatasetFactory.createFromObject(class1, expectedObj);
		TestUtils.assertDatasetEquals(expected, output, true, ABSERRD, ABSERRD);
	}

	@Test
	public void testSetby1DIndex() {
		Class<? extends Dataset> class1 = classType;
		double valuesIn[] = { 1, 2, 3, 4 };
		double valueExpected[] = { 13, 2, 96, 4 };
		double valueOut[] = { 13, 96 };
		Object out = DatasetFactory.createFromObject(class1, valueOut);
		Dataset in = DatasetFactory.createFromObject(class1, valuesIn);
		Dataset index = DatasetFactory.createFromObject(new int[] { 0, 2 });
		Dataset expected = DatasetFactory.createFromObject(class1, valueExpected);
		Dataset actual = in.setBy1DIndex(out, index);
		TestUtils.assertDatasetEquals(expected, actual);
	}

	@Test
	public void testSetSlice() {
		Class<? extends Dataset> class1 = classType;
		double[] value = new double[] { 1.0, 2.0, 3.0, 4.0 };
		double valueExpected[] = { 1.0, 2.0, 0.0, 0.0 };

		Dataset input = DatasetFactory.createFromObject(class1, value);
		Dataset expected = DatasetFactory.createFromObject(class1, valueExpected);

		Dataset tdata = DatasetFactory.zeros(2);
		SliceIterator siter = (SliceIterator) input.getSliceIterator(new int[] { 2 }, new int[] { 4 }, null);
		input.setSlice(tdata, siter);

		TestUtils.assertDatasetEquals(expected, input, true, ABSERRD, ABSERRD);
	}

	@Test
	public void testSetByIndexes() {
		Class<? extends Dataset> class1 = classType;
		double valuesIn[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
		double valueOut[] = { 13, 96 };
		double valueExpected[][] = { { 1, 13, 3, 4 }, { 5, 6, 7, 96 } };
		Dataset expected = DatasetFactory.createFromObject(class1, valueExpected);

		Dataset in = DatasetFactory.createFromObject(class1, valuesIn);
		Object out = DatasetFactory.createFromObject(class1, valueOut);
		Dataset index1 = DatasetFactory.createFromObject(new int[] { 0, 1 });
		Dataset index2 = DatasetFactory.createFromObject(new int[] { 1, 3 });
		Dataset actual = in.setByIndexes(out, index1, index2);

		TestUtils.assertDatasetEquals(expected, actual);
	}

	@Test
	public void testResidual() {
		Class<? extends Dataset> class1 = classType;

		double[] value = new double[] { 0.0, 2.0, 3.0, 4.0 };
		double[] value2 = new double[] { 1.0, 3.0, 4.0, 5.0 };
		double[] valueW = new double[] { 1, 0, 1, 1 };

		Dataset in = DatasetFactory.createFromObject(class1, value);
		Dataset in2 = DatasetFactory.createFromObject(class1, value2);
		Dataset w = DatasetFactory.createFromObject(class1, valueW);

		double sumExpected = 3;

		double sum = in.residual(in2, w, true);

		assertEquals(sumExpected, sum, ABSERRD);

		sum = in.residual(in2, null, true);
		sumExpected = 1;
		assertEquals(sumExpected, sum, ABSERRD);
	}
}
