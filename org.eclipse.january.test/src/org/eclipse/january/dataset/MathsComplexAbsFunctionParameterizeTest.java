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
public class MathsComplexAbsFunctionParameterizeTest {
	@Parameters(name = "{index}: {0}")
	public static Collection<Object> data() {
		return Arrays.asList(
				new Object[] { ComplexFloatDataset.class, ComplexDoubleDataset.class });
	}

	@Parameter
	public Class<? extends CompoundDataset> classType;

	private final static double ABSERRD = 1e-8;

	@Test
	public void test() throws Exception {
		Class<? extends CompoundDataset> class1 = classType;
		
		double[] ds = new double[] { -0, 1, 2, -3, 4, 5 };
		Dataset input = DatasetFactory.createFromObject(class1, ds);
		Dataset output = DatasetFactory.createFromObject(class1, new double[] { 0, 4, 0, 0, 0, 0 });

		int size = ds.length;
		double[] c = new double[size];
		for (int i = 0; i < size; i = i + 2) {
			double val = Math.hypot(ds[i], ds[i + 1]);
			c[i] = val; // real part
			c[i + 1] = 0; // imaginary part
		}
		Dataset expectedResult = DatasetFactory.createFromObject(class1, c);

		Dataset actualResult = Maths.abs(input, output);
		TestUtils.assertDatasetEquals(expectedResult, actualResult, true, ABSERRD, ABSERRD);
	}
}
