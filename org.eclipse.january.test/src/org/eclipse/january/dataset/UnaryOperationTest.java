/*-
 *******************************************************************************
 * Copyright (c) 2016 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Peter Chang - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.january.dataset;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.math3.complex.Complex;
import org.eclipse.january.asserts.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class UnaryOperationTest {

	private UnaryOperation operation;
	private Object[] expected;
	private Object[][] operands;

	@Parameters
	public static Collection<Object[]> parameters() {
		return Arrays.asList(new Object[][] {
				{Operations.Negation.class, new Object[][] {
					{false, 1l}, {true, 0l}, {false, -1l},
					{0l, 0l}, {-1l, 1l}, {1l, -1l}, {2l, -2l},
					{0d, 0d}, {-1d, 1d}, {1d, -1d}, {2d, -2d},
					{new Complex(0), 0d, 0d}, {new Complex(1), -1d, 0d}, {new Complex(-1), 1d, 0d}, {new Complex(2), -2d, 0d},
					{new Complex(0, 0), 0d, 0d}, {new Complex(1, 1), -1d, -1d}, {new Complex(-1, -1), 1d, 1d}, {new Complex(2, -2), -2d, 2d},
				}},
		});
	}

	/**
	 * 
	 * @param opClass
	 * @param values object array containing expected value first then operands
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public UnaryOperationTest(Class<UnaryOperation> opClass, Object[][] values) throws Exception {
		operation = opClass.newInstance();

		int l = values.length;
		expected = new Object[l];
		operands = new Object[l][2];
		for (int i = 0; i < l; i++) {
			Object[] o = values[i];
			expected[i] = o[0];
			operands[i] = Arrays.copyOfRange(o, 1, o.length);
		}
	}

	@Test
	public void testOp() {
		for (int i = 0, imax = operands.length; i < imax; i++) {
			Object[] vs = operands[i];
			Object ex = expected[i];
			String s = toString() + Arrays.toString(vs);
			if (ex instanceof Boolean) {
				assertEquals(s, ex, operation.booleanOperate((Long) vs[0]));
			} else if (ex instanceof Long) {
				assertEquals(s, ex, operation.longOperate((Long) vs[0]));
			} else if (ex instanceof Double) {
				TestUtils.assertEquals(s, (Double) ex, operation.doubleOperate((Double) vs[0]));
			} else if (ex instanceof Complex) {
				Complex cz = (Complex) ex;
				double[] cpx = new double[2];
				operation.complexOperate(cpx, (Double) vs[0], (Double) vs[1]);
				TestUtils.assertEquals(s + ": real", cz.getReal(), cpx[0], 1e-14, 7e-17);
				TestUtils.assertEquals(s + ": imag", cz.getImaginary(), cpx[1]);
			}
		}
	}

	@Override
	public String toString() {
		return "Test of operation (" + operation + ") failed with " + Arrays.deepToString(operands);
	}
}
