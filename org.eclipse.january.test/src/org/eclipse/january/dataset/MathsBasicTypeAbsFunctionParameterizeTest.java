package org.eclipse.january.dataset;

import org.junit.Test;
import org.eclipse.january.asserts.TestUtils;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MathsBasicTypeAbsFunctionParameterizeTest {

	@Parameters(name = "{index}: {0}")
	public static Collection<Object> data() {
		return Arrays.asList(new Object[] { FloatDataset.class, DoubleDataset.class, ByteDataset.class,
				ShortDataset.class, IntegerDataset.class, LongDataset.class });
	}

	@Parameter
	public Class<? extends Dataset> classType;

	private final static double ABSERRD = 1e-8;

	@Test
	public void test() {
		Class<? extends Dataset> class1 = classType;
		double[] obj = new double[] {4.2, -2.9, 6.10};
		Dataset input = DatasetFactory.createFromObject(class1, obj);
		Dataset output = DatasetFactory.createFromObject(class1, new double[]{0,0,0});
		System.out.println(output.getElementsPerItem());

		int size = input.getSize();
		double[] c = new double[size];
		for (int i = 0; i < size; i++) {
			double abs = Math.abs(obj[i]);
			c[i] = abs;
		}
		Dataset expectedResult = DatasetFactory.createFromObject(class1, c);

		Dataset actualResult = Maths.abs(input, output);
		TestUtils.assertDatasetEquals(expectedResult, actualResult, true, ABSERRD, ABSERRD);
	}
}
