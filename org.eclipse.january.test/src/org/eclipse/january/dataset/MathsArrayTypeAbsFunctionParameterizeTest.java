package org.eclipse.january.dataset;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.january.asserts.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MathsArrayTypeAbsFunctionParameterizeTest {
	@Parameters(name = "{index}: {0}")
	public static Collection<Object> data() {
		return Arrays.asList(
				new Object[] { CompoundFloatDataset.class, CompoundDoubleDataset.class, CompoundByteDataset.class,
						CompoundShortDataset.class, CompoundIntegerDataset.class, CompoundLongDataset.class });
	}

	@Parameter
	public Class<? extends CompoundDataset> classType;

	private final static double ABSERRD = 1e-8;

	@Test
	public void test() throws Exception {
		Class<? extends CompoundDataset> class1 = classType;
		byte[] ba = { 0, 8, -1, 2, 3, 5, 6, 41, 7, 95, 8, -74, 9, 41, 11 };
		Dataset a = DatasetFactory.createFromObject(ba);
		CompoundDataset input = DatasetUtils.createCompoundDataset(class1, a);

		int size = a.getSize();
		double[] c = new double[size];
		for (int i = 0; i < size; i++) {
			double abs = Math.abs(ba[i]);
			c[i] = abs;
		}
		CompoundDataset expectedResult = DatasetUtils.createCompoundDataset(class1, DatasetFactory.createFromObject(c));
		CompoundDataset output = DatasetUtils.createCompoundDataset(class1,
				DatasetFactory.createFromObject(new float[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }));

		Dataset actual = Maths.abs(input, output);
		CompoundDataset actualResult = DatasetUtils.createCompoundDataset(actual);
		System.out.println(expectedResult.toString(true));
		System.out.println(actualResult.toString(true));
		TestUtils.assertDatasetEquals(expectedResult, actualResult, true, ABSERRD, ABSERRD);
	}
}
