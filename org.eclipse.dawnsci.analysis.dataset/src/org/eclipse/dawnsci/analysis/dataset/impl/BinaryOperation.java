/*-
 *******************************************************************************
 * Copyright (c) 2011, 2014 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Peter Chang - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.dawnsci.analysis.dataset.impl;

import org.apache.commons.math3.complex.Complex;

/**
 * Interface to represent a binary operation for implementations over different output domains
 */
public interface BinaryOperation {

	/**
	 * @param a
	 * @param b
	 * @return a op b
	 */
	boolean booleanOperate(long a, long b);

	/**
	 * @param a
	 * @param b
	 * @return a op b
	 */
	long longOperate(long a, long b);

	/**
	 * @param a
	 * @param b
	 * @return a op b
	 */
	double doubleOperate(double a, double b);

	/**
	 * @param out holds (ra, ia) op (rb, ib)
	 * @param ra
	 * @param ia
	 * @param rb
	 * @param ib
	 */
	void complexOperate(double[] out, double ra, double ia, double rb, double ib);

	@Override
	String toString();

	public static class Stub implements BinaryOperation {

		/**
		 * override this
		 */
		@Override
		public double doubleOperate(double a, double b) {
			return 0;
		}

		@Override
		public boolean booleanOperate(long a, long b) {
			return doubleOperate(a, b) != 0;
		}

		private static long toLong(double d) {
			if (Double.isInfinite(d) || Double.isNaN(d))
				return 0;
			return (long) d;
		}

		@Override
		public long longOperate(long a, long b) {
			return toLong(doubleOperate(a, b));
		}

		/**
		 * override this
		 */
		@Override
		public void complexOperate(double[] out, double ra, double ia, double rb, double ib) {
		}
	}

	/**
	 * Addition with boolean or
	 */
	public static class Addition implements BinaryOperation {

		@Override
		public boolean booleanOperate(long a, long b) {
			return a != 0 || b != 0;
		}

		@Override
		public long longOperate(long a, long b) {
			return a + b;
		}

		@Override
		public double doubleOperate(double a, double b) {
			return a + b;
		}

		@Override
		public void complexOperate(double[] out, double ra, double ia, double rb, double ib) {
			out[0] = ra + rb;
			out[1] = ia + ib;
		}

		@Override
		public String toString() {
			return "+";
		}
	}

	/**
	 * Subtraction with boolean or of negated second operand
	 */
	public static class Subtraction implements BinaryOperation {

		@Override
		public boolean booleanOperate(long a, long b) {
			return a != 0 || b == 0;
		}

		@Override
		public long longOperate(long a, long b) {
			return a - b;
		}

		@Override
		public double doubleOperate(double a, double b) {
			return a - b;
		}

		@Override
		public void complexOperate(double[] out, double ra, double ia, double rb, double ib) {
			out[0] = ra - rb;
			out[1] = ia - ib;
		}

		@Override
		public String toString() {
			return "-";
		}
	}

	/**
	 * Multiplication with boolean and
	 */
	public static class Multiplication implements BinaryOperation {

		@Override
		public boolean booleanOperate(long a, long b) {
			return a != 0 && b != 0;
		}

		@Override
		public long longOperate(long a, long b) {
			return a * b;
		}

		@Override
		public double doubleOperate(double a, double b) {
			return a * b;
		}

		@Override
		public void complexOperate(double[] out, double ra, double ia, double rb, double ib) {
			out[0] = ra * rb - ia * ib;
			out[1] = ra * ib + ia * rb;
		}

		@Override
		public String toString() {
			return "*";
		}
	}

	/**
	 * Division with boolean and of negated second operand
	 */
	public static class Division implements BinaryOperation {

		@Override
		public boolean booleanOperate(long a, long b) {
			return a != 0 && b == 0;
		}

		@Override
		public long longOperate(long a, long b) {
			return b == 0 ? 0 : a / b;
		}

		@Override
		public double doubleOperate(double a, double b) {
			return a / b;
		}

		@Override
		public void complexOperate(double[] out, double ra, double ia, double rb, double ib) {
			double q;
			double den;
			if (ib == 0) {
				out[0] = ra / rb;
				out[1] = ia / rb;
			} else if (rb == 0) {
				out[0] = ia / ib;
				out[1] = -ra / ib;
			} else if (Math.abs(rb) < Math.abs(ib)) {
				q = rb / ib;
				den = rb * q + ib;
				out[0] = (ra * q + ia) / den;
				out[1] = (ia * q - rb) / den;
			} else {
				q = ib / rb;
				den = ib * q + rb;
				out[0] = (ia * q + ra) / den;
				out[1] = (ia - ra * q) / den;
			}
		}

		@Override
		public String toString() {
			return "/";
		}
	}

	/**
	 * Division with boolean and of negated second operand and returns zero if denominator is zero
	 */
	public static class DivisionWithZero extends Division {

		@Override
		public double doubleOperate(double a, double b) {
			return b == 0 ? 0 : a / b;
		}

		@Override
		public void complexOperate(double[] out, double ra, double ia, double rb, double ib) {
			double q;
			double den;
			if (ib == 0) {
				if (rb == 0) {
					out[0] = 0;
					out[1] = 0;
				} else {
					out[0] = ra / rb;
					out[1] = ia / rb;
				}
			} else if (rb == 0) {
				out[0] = ia / ib;
				out[1] = -ra / ib;
			} else if (Math.abs(rb) < Math.abs(ib)) {
				q = rb / ib;
				den = rb * q + ib;
				out[0] = (ra * q + ia) / den;
				out[1] = (ia * q - rb) / den;
			} else {
				q = ib / rb;
				den = ib * q + rb;
				out[0] = (ia * q + ra) / den;
				out[1] = (ia - ra * q) / den;
			}
		}
	}

	/**
	 * Division with boolean and of negated second operand and rounds down to negative infinity
	 */
	public static class DivisionTowardsFloor extends Division {

		@Override
		public long longOperate(long a, long b) {
			if (b == 0)
				return 0;

			long ox = a / b;
			if (a != ox * b && ((a < 0) ^ (b < 0))) {
				ox--;
			}

			return ox;
		}
	}

	/**
	 * Remainder
	 */
	public static class Remainder implements BinaryOperation {

		@Override
		public boolean booleanOperate(long a, long b) {
			throw new IllegalArgumentException("remainder does not support booleans");
		}

		@Override
		public long longOperate(long a, long b) {
			return b == 0 ? 0 : a % b;
		}

		@Override
		public double doubleOperate(double a, double b) {
			return a % b;
		}

		@Override
		public void complexOperate(double[] out, double ra, double ia, double rb, double ib) {
			throw new IllegalArgumentException("remainder does not support complex numbers");
		}

		@Override
		public String toString() {
			return "%";
		}
	}

	/**
	 * Exponentiation with boolean and
	 */
	public static class Exponentiation extends BinaryOperation.Stub {

		@Override
		public double doubleOperate(double a, double b) {
			return Math.pow(a, b);
		}

		@Override
		public void complexOperate(double[] out, double ra, double ia, double rb, double ib) {
			Complex c = new Complex(ra, ia);
			c = ib == 0 ? c.pow(rb) : c.pow(new Complex(rb, ib));
			out[0] = c.getReal();
			out[1] = c.getImaginary();
		}

		@Override
		public String toString() {
			return "**";
		}
	}
}
