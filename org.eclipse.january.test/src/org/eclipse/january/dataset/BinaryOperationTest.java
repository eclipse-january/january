/*-
 * Copyright 2015 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.math3.complex.Complex;
import org.eclipse.january.asserts.TestUtils;
import org.eclipse.january.dataset.BinaryOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BinaryOperationTest {

	// (1+i)**(1+i) = exp((log(2)/2 + i*pi/4)*(1 + i))
	private static double C_M = Math.exp(0.5*Math.log(2) - 0.25*Math.PI); // magnitude 
	private static double C_A = 0.5*Math.log(2) + 0.25*Math.PI; // argument

	@Parameters
	public static Collection<Object[]> parameters() {
		return Arrays.asList(new Object[][] {
				{BinaryOperation.Addition.class, new Object[][] {
					{false, 0l, 0l}, {true, 1l, 0l}, {true, 0l, 1l}, {true, 1l, 1l},
					{0l, 0l, 0l}, {1l, 1l, 0l}, {1l, 0l, 1l}, {2l, 1l, 1l},
					{0d, 0d, 0d}, {1d, 1d, 0d}, {1d, 0d, 1d}, {2d, 1d, 1d},
					{new Complex(0), 0d, 0d, 0d, 0d}, {new Complex(1), 1d, 0d, 0d, 0d}, {new Complex(1), 0d, 0d, 1d, 0d}, {new Complex(2), 1d, 0d, 1d, 0d},
					{new Complex(0, 0), 0d, 0d, 0d, 0d}, {new Complex(1, 1), 1d, 1d, 0d, 0d}, {new Complex(1, 1), 0d, 1d, 1d, 0d}, {new Complex(2, 2), 1d, 1d, 1d, 1d},
				}},
				{BinaryOperation.Subtraction.class, new Object[][] {
					{true, 0l, 0l}, {true, 1l, 0l}, {false, 0l, 1l}, {true, 1l, 1l},
					{0l, 0l, 0l}, {1l, 1l, 0l}, {-1l, 0l, 1l}, {0l, 1l, 1l},
					{0d, 0d, 0d}, {1d, 1d, 0d}, {-1d, 0d, 1d}, {0d, 1d, 1d},
					{new Complex(0), 0d, 0d, 0d, 0d}, {new Complex(1), 1d, 0d, 0d, 0d}, {new Complex(-1), 0d, 0d, 1d, 0d}, {new Complex(0), 1d, 0d, 1d, 0d},
					{new Complex(0, 0), 0d, 0d, 0d, 0d}, {new Complex(1, 1), 1d, 1d, 0d, 0d}, {new Complex(-1, 1), 0d, 1d, 1d, 0d}, {new Complex(0, 0), 1d, 1d, 1d, 1d},
				}},
				{BinaryOperation.Multiplication.class, new Object[][] {
					{false, 0l, 0l}, {false, 1l, 0l}, {false, 0l, 1l}, {true, 1l, 1l},
					{0l, 0l, 0l}, {0l, 1l, 0l}, {0l, 0l, 1l}, {2l, 2l, 1l},
					{0d, 0d, 0d}, {0d, 1d, 0d}, {0d, 0d, 1d}, {2d, 2d, 1d},
					{new Complex(0), 0d, 0d, 0d, 0d}, {new Complex(0), 1d, 0d, 0d, 0d}, {new Complex(0), 0d, 0d, 1d, 0d}, {new Complex(1), 1d, 0d, 1d, 0d},
					{new Complex(0, 0), 0d, 0d, 0d, 0d}, {new Complex(0), 1d, 1d, 0d, 0d}, {new Complex(0, 1), 0d, 1d, 1d, 0d}, {new Complex(0, 2), 1d, 1d, 1d, 1d},
				}},
				{BinaryOperation.Division.class, new Object[][] {
					{false, 0l, 0l}, {true, 1l, 0l}, {false, 0l, 1l}, {false, 1l, 1l},
					{0l, 0l, 0l}, {0l, 1l, 0l}, {0l, 0l, 1l}, {2l, 2l, 1l},
					{-2l, -5l, 2l}, {-1l, -5l, 3l}, {-2l, 5l, -2l}, {-1l, 5l, -3l}, {2l, -5l, -2l}, {1l, -5l, -3l},
					{Double.NaN, 0d, 0d}, {Double.POSITIVE_INFINITY, 1d, 0d}, {0d, 0d, 1d}, {2d, 2d, 1d},
					{new Complex(Double.NaN, Double.NaN), 0d, 0d, 0d, 0d}, {new Complex(Double.POSITIVE_INFINITY, Double.NaN), 1d, 0d, 0d, 0d}, {new Complex(0), 0d, 0d, 1d, 0d}, {new Complex(1), 1d, 0d, 1d, 0d},
					{new Complex(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY), 1d, 1d, 0d, 0d}, {new Complex(0, 1), 0d, 1d, 1d, 0d}, {new Complex(1, 0), 1d, 1d, 1d, 1d},
				}},
				{BinaryOperation.DivisionWithZero.class, new Object[][] {
					{false, 0l, 0l}, {true, 1l, 0l}, {false, 0l, 1l}, {false, 1l, 1l},
					{0l, 0l, 0l}, {0l, 1l, 0l}, {0l, 0l, 1l}, {2l, 2l, 1l},
					{new Complex(0d), 0d, 0d, 0d, 0d}, {new Complex(0d), 1d, 0d, 0d, 0d}, {new Complex(0), 0d, 0d, 1d, 0d}, {new Complex(1), 1d, 0d, 1d, 0d},
					{new Complex(0d), 1d, 1d, 0d, 0d}, {new Complex(0, 1), 0d, 1d, 1d, 0d}, {new Complex(1, 0), 1d, 1d, 1d, 1d},
				}},
				{BinaryOperation.DivisionTowardsFloor.class, new Object[][] {
					{false, 0l, 0l}, {true, 1l, 0l}, {false, 0l, 1l}, {false, 1l, 1l},
					{0l, 0l, 0l}, {0l, 1l, 0l}, {0l, 0l, 1l}, {2l, 2l, 1l},
					{-3l, -5l, 2l}, {-2l, -5l, 3l}, {-3l, 5l, -2l}, {-2l, 5l, -3l}, {2l, -5l, -2l}, {1l, -5l, -3l},
					{Double.NaN, 0d, 0d}, {Double.POSITIVE_INFINITY, 1d, 0d}, {0d, 0d, 1d}, {2d, 2d, 1d},
					{Complex.NaN, 0d, 0d, 0d, 0d}, {new Complex(Double.POSITIVE_INFINITY, Double.NaN), 1d, 0d, 0d, 0d}, {new Complex(0), 0d, 0d, 1d, 0d}, {new Complex(1), 1d, 0d, 1d, 0d},
					{Complex.INF, 1d, 1d, 0d, 0d}, {new Complex(0, 1), 0d, 1d, 1d, 0d}, {new Complex(1, 0), 1d, 1d, 1d, 1d},
				}},
				{BinaryOperation.Remainder.class, new Object[][] {
					{0l, 0l, 0l}, {0l, 1l, 0l}, {0l, 0l, 1l}, {0l, 2l, 1l},
					{-1l, -5l, 2l}, {-2l, -5l, 3l}, {1l, 5l, -2l}, {2l, 5l, -3l}, {-1l, -5l, -2l}, {-2l, -5l, -3l},
					{Double.NaN, 0d, 0d}, {Double.NaN, 1d, 0d}, {0d, 0d, 1d}, {0d, 2d, 1d},
				}},
				{BinaryOperation.Exponentiation.class, new Object[][] {
					{true, 0l, 0l}, {true, 1l, 0l}, {false, 0l, 1l}, {true, 1l, 1l},
					{1l, 0l, 0l}, {1l, 1l, 0l}, {0l, 0l, 1l}, {2l, 2l, 1l},
					{1d, 0d, 0d}, {1d, 1d, 0d}, {0d, 0d, 1d}, {2d, 2d, 1d},
					{Complex.NaN, 0d, 0d, 0d, 0d}, {new Complex(1), 1d, 0d, 0d, 0d}, {Complex.NaN, 0d, 0d, 1d, 0d}, {new Complex(1), 1d, 0d, 1d, 0d},
					{Complex.NaN, 0d, 0d, 0d, 0d}, {new Complex(1), 1d, 1d, 0d, 0d}, {new Complex(0, 1), 0d, 1d, 1d, 0d}, {new Complex(C_M*Math.cos(C_A), C_M*Math.sin(C_A)), 1d, 1d, 1d, 1d},
				}},
		});
	}

	private BinaryOperation operation;
	private Object[] expected;
	private Object[][] operands;

	/**
	 * 
	 * @param opClass
	 * @param values object array containing expected value first then operands
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public BinaryOperationTest(Class<BinaryOperation> opClass, Object[][] values) throws InstantiationException, IllegalAccessException {
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
				assertEquals(s, ex, operation.booleanOperate((Long) vs[0], (Long) vs[1]));
			} else if (ex instanceof Long) {
				assertEquals(s, ex, operation.longOperate((Long) vs[0], (Long) vs[1]));
			} else if (ex instanceof Double) {
				TestUtils.assertEquals(s, (Double) ex, operation.doubleOperate((Double) vs[0], (Double) vs[1]));
			} else if (ex instanceof Complex) {
				Complex cz = (Complex) ex;
				double[] cpx = new double[2];
				operation.complexOperate(cpx, (Double) vs[0], (Double) vs[1], (Double) vs[2], (Double) vs[3]);
				TestUtils.assertEquals(s + ": real", cz.getReal(), cpx[0], 1e-14, 7e-17);
				TestUtils.assertEquals(s + ": imag", cz.getImaginary(), cpx[1]);
			}
		}
	}

	@Override
	public String toString() {
		return "Test of operation (" + operation + ") failed with ";
	}
}
