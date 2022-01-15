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

import org.apache.commons.math3.complex.Complex;

/**
 * @since 2.0
 */
public class Operations {

	/**
	 * This function returns the name of the dataset, bracketed if it already
	 * includes some mathematical symbol
	 * 
	 * @param a input
	 * @return the bracketed if necessary method name
	 */
	public static StringBuilder bracketIfNecessary(final String a) {
		final String name = a.trim();
		StringBuilder newName = new StringBuilder(name);
		if (name.contains("+") || name.contains("-") || name.contains("*") || name.contains("/") || name.contains("%")
				|| name.contains("^") || name.contains("'")) {
			newName.insert(0, '(');
			newName.append(')');
		}

		return newName;
	}

	/**
	 * Create a string for a binary operator and its operands
	 * 
	 * @param operator name
	 * @param a
	 *            1st operand name
	 * @param b
	 *            2nd operand name
	 * @return name of operation
	 */
	public static String createBinaryOperationName(final String operator, final String a, final String b) {
		StringBuilder newName = bracketIfNecessary(a).append(operator).append(bracketIfNecessary(b));
		return newName.toString();
	}

	/**
	 * Create a string for a function and its arguments
	 * 
	 * @param function name
	 * @param arguments to use
	 * @return name of function
	 */
	public static String createFunctionName(final String function, String... arguments) {
		StringBuilder name = new StringBuilder(function);
		name.append('(');
		name.append(String.join(", ", arguments));
		name.append(')');
		return name.toString();
	}

	/**
	 * Negation with boolean not
	 */
	public static class Negation implements UnaryOperation {

		@Override
		public boolean booleanOperate(long a) {
			return a == 0;
		}

		@Override
		public long longOperate(long a) {
			return -a;
		}

		@Override
		public double doubleOperate(double a) {
			return -a;
		}

		@Override
		public void complexOperate(double[] out, double ra, double ia) {
			out[0] = -ra;
			out[1] = -ia;
		}

		@Override
		public String toString(String a) {
			return createFunctionName(toString(), a);
		}

		@Override
		public String toString() {
			return "-";
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
		public String toString(String a, String b) {
			return createBinaryOperationName(toString(), a, b);
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
		public String toString(String a, String b) {
			return createBinaryOperationName(toString(), a, b);
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
		public String toString(String a, String b) {
			return createBinaryOperationName(toString(), a, b);
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
		public String toString(String a, String b) {
			return createBinaryOperationName(toString(), a, b);
		}

		@Override
		public String toString() {
			return "/";
		}
	}

	/**
	 * Division with boolean and of negated second operand and returns zero if
	 * denominator is zero
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
	 * Division with boolean and of negated second operand and rounds down to
	 * negative infinity
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
		public String toString(String a, String b) {
			return createBinaryOperationName(toString(), a, b);
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
		public String toString(String a, String b) {
			return createBinaryOperationName(toString(), a, b);
		}

		@Override
		public String toString() {
			return "**";
		}
	}

	/**
	 * Select maximum of a and b
	 */
	public static class Maximum implements BinaryOperation {
		@Override
		public boolean booleanOperate(long a, long b) {
			return a > b ? a != 0 : b != 0;
		}

		@Override
		public long longOperate(long a, long b) {
			return a > b ? a : b;
		}

		@Override
		public double doubleOperate(double a, double b) {
			return a > b ? a : b;
		}

		@Override
		public void complexOperate(double[] out, double ra, double ia, double rb, double ib) {
			throw new IllegalArgumentException("select greater than does not support complex numbers");
		}

		@Override
		public String toString(String a, String b) {
			return createFunctionName(toString(), a, b);
		}

		@Override
		public String toString() {
			return "max";
		}
	}

	/**
	 * Select minimum of a and b
	 */
	public static class Minimum implements BinaryOperation {
		@Override
		public boolean booleanOperate(long a, long b) {
			return a < b ? a != 0 : b != 0;
		}

		@Override
		public long longOperate(long a, long b) {
			return a < b ? a : b;
		}

		@Override
		public double doubleOperate(double a, double b) {
			return a < b ? a : b;
		}

		@Override
		public void complexOperate(double[] out, double ra, double ia, double rb, double ib) {
			throw new IllegalArgumentException("select less than does not support complex numbers");
		}

		@Override
		public String toString(String a, String b) {
			return createFunctionName(toString(), a, b);
		}

		@Override
		public String toString() {
			return "min";
		}
	}

	/**
	 * Use given value if {@code a > b} else use a
	 */
	public static class UseBase implements BinaryOperation {
		protected boolean br;
		protected long lr;
		protected double dr;

		/**
		 * @param br
		 *            given value as boolean
		 * @param lr
		 *            given value as long
		 * @param dr
		 *            given value as double
		 */
		UseBase(boolean br, long lr, double dr) {
			this.br = br;
			this.lr = lr;
			this.dr = dr;
		}

		/**
		 * @param r
		 *            given value as Number
		 */
		UseBase(Number r) {
			br = r.intValue() != 0;
			lr = r.longValue();
			dr = r.doubleValue();
		}

		@Override
		public boolean booleanOperate(long a, long b) {
			return false;
		}

		@Override
		public long longOperate(long a, long b) {
			return 0;
		}

		@Override
		public double doubleOperate(double a, double b) {
			return 0;
		}

		@Override
		public void complexOperate(double[] out, double ra, double ia, double rb, double ib) {
		}

		@Override
		public String toString(String a, String b) {
			return createBinaryOperationName(toString(), a, b);
		}
	}

	/**
	 * Use given value if {@code a > b} else use a
	 */
	public static class UseIfGreaterThan extends UseBase {
		/**
		 * @param br
		 *            given value as boolean
		 * @param lr
		 *            given value as long
		 * @param dr
		 *            given value as double
		 */
		public UseIfGreaterThan(boolean br, long lr, double dr) {
			super(br, lr, dr);
		}

		/**
		 * @param r
		 *            given value as Number
		 */
		public UseIfGreaterThan(Number r) {
			super(r);
		}

		@Override
		public boolean booleanOperate(long a, long b) {
			return a > b ? br : a != 0;
		}

		@Override
		public long longOperate(long a, long b) {
			return a > b ? lr : a;
		}

		@Override
		public double doubleOperate(double a, double b) {
			return a > b ? dr : a;
		}

		@Override
		public void complexOperate(double[] out, double ra, double ia, double rb, double ib) {
			throw new IllegalArgumentException("replace greater than does not support complex numbers");
		}

		@Override
		public String toString() {
			return ">";
		}
	}

	/**
	 * Use given value if {@code a >= b} else use a
	 */
	public static class UseIfGreaterThanOrEqualTo extends UseBase {
		/**
		 * @param br
		 *            given value as boolean
		 * @param lr
		 *            given value as long
		 * @param dr
		 *            given value as double
		 */
		public UseIfGreaterThanOrEqualTo(boolean br, long lr, double dr) {
			super(br, lr, dr);
		}

		/**
		 * @param r
		 *            given value as Number
		 */
		public UseIfGreaterThanOrEqualTo(Number r) {
			super(r);
		}

		@Override
		public boolean booleanOperate(long a, long b) {
			return a >= b ? br : a != 0;
		}

		@Override
		public long longOperate(long a, long b) {
			return a >= b ? lr : a;
		}

		@Override
		public double doubleOperate(double a, double b) {
			return a >= b ? dr : a;
		}

		@Override
		public void complexOperate(double[] out, double ra, double ia, double rb, double ib) {
			throw new IllegalArgumentException("replace greater than or equal to does not support complex numbers");
		}

		@Override
		public String toString() {
			return ">";
		}
	}

	/**
	 * Use given value if {@code a < b} else use a
	 */
	public static class UseIfLessThan extends UseBase {
		/**
		 * @param br
		 *            given value as boolean
		 * @param lr
		 *            given value as long
		 * @param dr
		 *            given value as double
		 */
		public UseIfLessThan(boolean br, long lr, double dr) {
			super(br, lr, dr);
		}

		/**
		 * @param r
		 *            given value as Number
		 */
		public UseIfLessThan(Number r) {
			super(r);
		}

		@Override
		public boolean booleanOperate(long a, long b) {
			return a < b ? br : a != 0;
		}

		@Override
		public long longOperate(long a, long b) {
			return a < b ? lr : a;
		}

		@Override
		public double doubleOperate(double a, double b) {
			return a < b ? dr : a;
		}

		@Override
		public void complexOperate(double[] out, double ra, double ia, double rb, double ib) {
			throw new IllegalArgumentException("replace less than does not support complex numbers");
		}

		@Override
		public String toString() {
			return "<";
		}
	}

	/**
	 * Use given value if {@code a <= b} else use a
	 */
	public static class UseIfLessThanOrEqualTo extends UseBase {
		/**
		 * @param br
		 *            given value as boolean
		 * @param lr
		 *            given value as long
		 * @param dr
		 *            given value as double
		 */
		public UseIfLessThanOrEqualTo(boolean br, long lr, double dr) {
			super(br, lr, dr);
		}

		/**
		 * @param r
		 *            given value as Number
		 */
		public UseIfLessThanOrEqualTo(Number r) {
			super(r);
		}

		@Override
		public boolean booleanOperate(long a, long b) {
			return a <= b ? br : a != 0;
		}

		@Override
		public long longOperate(long a, long b) {
			return a <= b ? lr : a;
		}

		@Override
		public double doubleOperate(double a, double b) {
			return a <= b ? dr : a;
		}

		@Override
		public void complexOperate(double[] out, double ra, double ia, double rb, double ib) {
			throw new IllegalArgumentException("replace less than or equal to does not support complex numbers");
		}

		@Override
		public String toString() {
			return "<=";
		}
	}

	/**
	 * Use given value if {@code a == b} else use a
	 */
	public static class UseIfEqualTo extends UseBase {
		private double di;

		/**
		 * @param br
		 *            given value as boolean
		 * @param lr
		 *            given value as long
		 * @param dr
		 *            given value as double
		 * @param di
		 *            given value for imaginary part as double
		 */
		public UseIfEqualTo(boolean br, long lr, double dr, double di) {
			super(br, lr, dr);
			this.di = di;
		}

		/**
		 * @param r
		 *            given value as Number
		 */
		public UseIfEqualTo(Number r) {
			super(r);
			di = 0;
		}

		/**
		 * @param z
		 *            given value as Complex
		 */
		public UseIfEqualTo(Complex z) {
			super(z.getReal());
			di = z.getImaginary();
		}

		@Override
		public boolean booleanOperate(long a, long b) {
			return a == b ? br : a != 0;
		}

		@Override
		public long longOperate(long a, long b) {
			return a == b ? lr : a;
		}

		@Override
		public double doubleOperate(double a, double b) {
			return a == b ? dr : a;
		}

		@Override
		public void complexOperate(double[] out, double ra, double ia, double rb, double ib) {
			if (ra == rb && ia == ib) {
				out[0] = dr;
				out[1] = di;
			} else {
				out[0] = ra;
				out[1] = ia;
			}
		}

		@Override
		public String toString() {
			return "==";
		}
	}

	private static long toLong(double d) {
		if (Double.isInfinite(d) || Double.isNaN(d))
			return 0;
		return (long) d;
	}

	/**
	 * Operate on a dataset
	 * 
	 * @param op
	 *            unary operator
	 * @param a
	 *            dataset
	 * @param o
	 *            output can be null - in which case, a new dataset is created
	 * @return op(a), operation on a
	 */
	public static Dataset operate(final UnaryOperation op, final Object a, final Dataset o) {
		final Dataset da = a instanceof Dataset ? (Dataset) a : DatasetFactory.createFromObject(a);
		final SingleInputBroadcastIterator it = new SingleInputBroadcastIterator(da, o, true, true, false);
		final Dataset result = it.getOutput();
		it.setOutputDouble(result.hasFloatingPointElements() || da.isComplex());
		final int is = result.getElementsPerItem();
		final int as = da.getElementsPerItem();
		final double[] z;

		if (result instanceof FloatDataset) {
			final float[] f32data = ((FloatDataset) result).getData();
	
			if (!da.isComplex()) {
				while (it.hasNext()) {
					f32data[it.oIndex] = (float) op.doubleOperate(it.aDouble);
				}
			} else { // only for complex input
				z = new double[2];
				while (it.hasNext()) {
					op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1));
					f32data[it.oIndex] = (float) z[0];
				}
			}
		} else if (result instanceof DoubleDataset) {
			final double[] f64data = ((DoubleDataset) result).getData();
	
			if (!da.isComplex()) {
				while (it.hasNext()) {
					f64data[it.oIndex] = op.doubleOperate(it.aDouble);
				}
			} else {
				z = new double[2];
				while (it.hasNext()) {
					op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1));
					f64data[it.oIndex] = z[0];
				}
			}
		} else if (result instanceof ComplexFloatDataset) {
			final float[] c64data = ((ComplexFloatDataset) result).getData();
			z = new double[2];
	
			if (!da.isComplex()) {
				while (it.hasNext()) {
					op.complexOperate(z, it.aDouble, 0);
					c64data[it.oIndex] = (float) z[0];
				}
			} else {
				while (it.hasNext()) {
					op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1));
					c64data[it.oIndex] = (float) z[0];
					c64data[it.oIndex + 1] = (float) z[1];
				}
			}
		} else if (result instanceof ComplexDoubleDataset) {
			final double[] c128data = ((ComplexDoubleDataset) result).getData();
			z = new double[2];
	
			if (!da.isComplex()) {
				while (it.hasNext()) {
					op.complexOperate(z, it.aDouble, 0);
					c128data[it.oIndex] = z[0];
				}
			} else {
				while (it.hasNext()) {
					op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1));
					c128data[it.oIndex] = z[0];
					c128data[it.oIndex + 1] = z[1];
				}
			}
		} else if (result instanceof CompoundFloatDataset) {
			final float[] af32data = ((CompoundFloatDataset) result).getData();
	
			if (!da.isComplex()) {
				if (is == 1) {
					while (it.hasNext()) {
						af32data[it.oIndex] = (float) op.doubleOperate(it.aDouble);
					}
				} else if (as == 1) {
					while (it.hasNext()) {
						float ox = (float) op.doubleOperate(it.aDouble);
						for (int j = 0; j < is; j++) {
							af32data[it.oIndex + j] = ox;
						}
					}
				} else {
					int ms = Math.min(is, as);
					while (it.hasNext()) {
						af32data[it.oIndex] = (float) op.doubleOperate(it.aDouble);
						for (int j = 1; j < ms; j++) {
							af32data[it.oIndex + j] = (float) op.doubleOperate(da.getElementDoubleAbs(it.aIndex + j));
						}
					}
				}
			} else {
				z = new double[2];
				while (it.hasNext()) {
					op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1));
					float ox = (float) z[0];
					for (int j = 0; j < is; j++) {
						af32data[it.oIndex + j] = ox;
					}
				}
			}
		} else if (result instanceof CompoundDoubleDataset) {
			final double[] af64data = ((CompoundDoubleDataset) result).getData();
	
			if (!da.isComplex()) {
				if (is == 1) {
					while (it.hasNext()) {
						af64data[it.oIndex] = op.doubleOperate(it.aDouble);
					}
				} else if (as == 1) {
					while (it.hasNext()) {
						final double ix = it.aDouble;
						double ox = op.doubleOperate(ix);
						for (int j = 0; j < is; j++) {
							af64data[it.oIndex + j] = ox;
						}
					}
				} else {
					int ms = Math.min(is, as);
					while (it.hasNext()) {
						af64data[it.oIndex] = op.doubleOperate(it.aDouble);
						for (int j = 1; j < ms; j++) {
							af64data[it.oIndex + j] = op.doubleOperate(da.getElementDoubleAbs(it.aIndex + j));
						}
					}
				}
			} else {
				z = new double[2];
				while (it.hasNext()) {
					op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1));
					double ox = z[0];
					for (int j = 0; j < is; j++) {
						af64data[it.oIndex + j] = ox;
					}
				}
			}
		} else if (result instanceof BooleanDataset) {
			boolean[] bdata = ((BooleanDataset) result).getData();

			if (!da.isComplex()) {
				while (it.hasNext()) {
					bdata[it.oIndex] = op.booleanOperate(it.aLong);
				}
			} else {
				z = new double[2];
				while (it.hasNext()) {
					op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1));
					bdata[it.oIndex] = z[0] != 0;
				}
			}
		} else if (result instanceof ByteDataset) {
			final byte[] i8data = ((ByteDataset) result).getData();

			if (!da.isComplex()) {
				while (it.hasNext()) {
					i8data[it.oIndex] = (byte) op.longOperate(it.aLong);
				}
			} else {
				z = new double[2];
				while (it.hasNext()) {
					op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1));
					i8data[it.oIndex] = (byte) toLong(z[0]);
				}
			}
		} else if (result instanceof ShortDataset) {
			final short[] i16data = ((ShortDataset) result).getData();

			if (!da.isComplex()) {
				while (it.hasNext()) {
					i16data[it.oIndex] = (short) op.longOperate(it.aLong);
				}
			} else {
				z = new double[2];
				while (it.hasNext()) {
					op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1));
					i16data[it.oIndex] = (short) toLong(z[0]);
				}
			}
		} else if (result instanceof IntegerDataset) {
			final int[] i32data = ((IntegerDataset) result).getData();

			if (!da.isComplex()) {
				while (it.hasNext()) {
					i32data[it.oIndex] = (int) op.longOperate(it.aLong);
				}
			} else {
				z = new double[2];
				while (it.hasNext()) {
					op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1));
					i32data[it.oIndex] = (int) toLong(z[0]);
				}
			}
		} else if (result instanceof LongDataset) {
			final long[] i64data = ((LongDataset) result).getData();

			if (!da.isComplex()) {
				while (it.hasNext()) {
					i64data[it.oIndex] = op.longOperate(it.aLong);
				}
			} else {
				z = new double[2];
				while (it.hasNext()) {
					op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1));
					i64data[it.oIndex] = toLong(z[0]);
				}
			}
		} else if (result instanceof CompoundByteDataset) {
			final byte[] ai8data = ((CompoundByteDataset) result).getData();

			if (!da.isComplex()) {
				if (is == 1) {
					while (it.hasNext()) {
						ai8data[it.oIndex] = (byte) op.longOperate(it.aLong);
					}
				} else if (as == 1) { // broadcast to other elements of output
					while (it.hasNext()) {
						byte ox = (byte) op.longOperate(it.aLong);
						for (int j = 0; j < is; j++) {
							ai8data[it.oIndex + j] = ox;
						}
					}
				} else { // use lowest common elements
					int ms = Math.min(is, as);
					while (it.hasNext()) {
						ai8data[it.oIndex] = (byte) op.longOperate(it.aLong);
						for (int j = 1; j < ms; j++) {
							ai8data[it.oIndex + j] = (byte) op.longOperate(da.getElementLongAbs(it.aIndex + j));
						}
					}
				}
			} else {
				z = new double[2];
				while (it.hasNext()) {
					op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1));
					byte ox = (byte) toLong(z[0]);
					for (int j = 0; j < is; j++) {
						ai8data[it.oIndex + j] = ox;
					}
				}
			}
		} else if (result instanceof CompoundShortDataset) {
			final short[] ai16data = ((CompoundShortDataset) result).getData();

			if (!da.isComplex()) {
				if (is == 1) {
					while (it.hasNext()) {
						ai16data[it.oIndex] = (short) op.longOperate(it.aLong);
					}
				} else if (as == 1) {
					while (it.hasNext()) {
						short ox = (short) op.longOperate(it.aLong);
						for (int j = 0; j < is; j++) {
							ai16data[it.oIndex + j] = ox;
						}
					}
				} else {
					int ms = Math.min(is, as);
					while (it.hasNext()) {
						ai16data[it.oIndex] = (short) op.longOperate(it.aLong);
						for (int j = 1; j < ms; j++) {
							ai16data[it.oIndex + j] = (short) op.longOperate(da.getElementLongAbs(it.aIndex + j));
						}
					}
				}
			} else {
				z = new double[2];
				while (it.hasNext()) {
					op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1));
					short ox = (short) toLong(z[0]);
					for (int j = 0; j < is; j++) {
						ai16data[it.oIndex + j] = ox;
					}
				}
			}
		} else if (result instanceof CompoundIntegerDataset) {
			final int[] ai32data = ((CompoundIntegerDataset) result).getData();

			if (!da.isComplex()) {
				if (is == 1) {
					while (it.hasNext()) {
						ai32data[it.oIndex] = (int) op.longOperate(it.aLong);
					}
				} else if (as == 1) {
					while (it.hasNext()) {
						int ox = (int) op.longOperate(it.aLong);
						for (int j = 0; j < is; j++) {
							ai32data[it.oIndex + j] = ox;
						}
					}
				} else {
					final int ms = Math.min(is, as);
					while (it.hasNext()) {
						ai32data[it.oIndex] = (int) op.longOperate(it.aLong);
						for (int j = 1; j < ms; j++) {
							ai32data[it.oIndex + j] = (int) op.longOperate(da.getElementLongAbs(it.aIndex + j));
						}
					}
				}
			} else {
				z = new double[2];
				while (it.hasNext()) {
					op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1));
					int ox = (int) toLong(z[0]);
					for (int j = 0; j < is; j++) {
						ai32data[it.oIndex + j] = ox;
					}
				}
			}
		} else if (result instanceof CompoundLongDataset) {
			final long[] ai64data = ((CompoundLongDataset) result).getData();

			if (!da.isComplex()) {
				if (is == 1) {
					while (it.hasNext()) {
						ai64data[it.oIndex] = op.longOperate(it.aLong);
					}
				} else if (as == 1) {
					while (it.hasNext()) {
						long ox = op.longOperate(it.aLong);
						for (int j = 0; j < is; j++) {
							ai64data[it.oIndex + j] = ox;
						}
					}
				} else {
					int ms = Math.min(is, as);
					while (it.hasNext()) {
						ai64data[it.oIndex] = op.longOperate(it.aLong);
						for (int j = 1; j < ms; j++) {
							ai64data[it.oIndex + j] = op.longOperate(da.getElementLongAbs(it.aIndex + j));
						}
					}
				}
			} else {
				z = new double[2];
				while (it.hasNext()) {
					op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1));
					long ox = toLong(z[0]);
					for (int j = 0; j < is; j++) {
						ai64data[it.oIndex + j] = ox;
					}
				}
			}
		} else {
			throw new UnsupportedOperationException("operate does not support this dataset type");
		}

		result.setName(op.toString(da.getName()));
		return result;
	}

	/**
	 * Operate on a dataset
	 * 
	 * @param op
	 *            binary operator
	 * @param a first operand
	 * @param b second operand
	 * @param o
	 *            output can be null - in which case, a new dataset is created
	 * @return a op b, operation on a and b
	 */
	public static Dataset operate(final BinaryOperation op, final Object a, final Object b, final Dataset o) {
		final Dataset da = a instanceof Dataset ? (Dataset) a : DatasetFactory.createFromObject(a);
		final Dataset db = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);

		final BroadcastIterator it = BroadcastIterator.createIterator(da, db, o, true);
		final Dataset result = it.getOutput();
		it.setOutputDouble(result.hasFloatingPointElements() || da.isComplex() || db.isComplex());
		final int is = result.getElementsPerItem();
		int as = da.getElementsPerItem();
		int bs = db.getElementsPerItem();
		final double[] z;

		if (result instanceof FloatDataset) {
			float[] f32data = ((FloatDataset) result).getData();

			if (!da.isComplex() && !db.isComplex()) {
				while (it.hasNext()) {
					f32data[it.oIndex] = (float) op.doubleOperate(it.aDouble, it.bDouble);
				}
			} else {
				z = new double[2];
				if (!db.isComplex()) { // only a complex
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1), it.bDouble, 0);
						f32data[it.oIndex] = (float) z[0];
					}
				} else if (!da.isComplex()) { // only b complex
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, 0, it.bDouble, db.getElementDoubleAbs(it.bIndex + 1));
						f32data[it.oIndex] = (float) z[0];
					}
				} else {
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1),
								it.bDouble, db.getElementDoubleAbs(it.bIndex + 1));
						f32data[it.oIndex] = (float) z[0];
					}
				}
			}
		} else if (result instanceof DoubleDataset) {
			double[] f64data = ((DoubleDataset) result).getData();

			if (!da.isComplex() && !db.isComplex()) {
				while (it.hasNext()) {
					f64data[it.oIndex] = op.doubleOperate(it.aDouble, it.bDouble);
				}
			} else {
				z = new double[2];
				if (!db.isComplex()) { // only a complex
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1), it.bDouble, 0);
						f64data[it.oIndex] = z[0];
					}
				} else if (!da.isComplex()) { // only b complex
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, 0, it.bDouble, db.getElementDoubleAbs(it.bIndex + 1));
						f64data[it.oIndex] = z[0];
					}
				} else {
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1),
								it.bDouble, db.getElementDoubleAbs(it.bIndex + 1));
						f64data[it.oIndex] = z[0];
					}
				}
			}
		} else if (result instanceof ComplexFloatDataset) {
			float[] c64data = ((ComplexFloatDataset) result).getData();
			z = new double[2];

			if (da.isComplex() || db.isComplex()) {
				if (!db.isComplex()) { // only a complex
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1), it.bDouble, 0);
						c64data[it.oIndex] = (float) z[0];
						c64data[it.oIndex + 1] = (float) z[1];
					}
				} else if (!da.isComplex()) { // only b complex
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, 0, it.bDouble, db.getElementDoubleAbs(it.bIndex + 1));
						c64data[it.oIndex] = (float) z[0];
						c64data[it.oIndex + 1] = (float) z[1];
					}
				} else {
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1), it.bDouble,
								db.getElementDoubleAbs(it.bIndex + 1));
						c64data[it.oIndex] = (float) z[0];
						c64data[it.oIndex + 1] = (float) z[1];
					}
				}
			} else {
				while (it.hasNext()) {
					op.complexOperate(z, it.aDouble, 0, it.bDouble, 0);
					c64data[it.oIndex] = (float) z[0];
					c64data[it.oIndex + 1] = (float) z[1];
				}
			}
		} else if (result instanceof ComplexDoubleDataset) {
			double[] c128data = ((ComplexDoubleDataset) result).getData();
			z = new double[2];

			if (da.isComplex() || db.isComplex()) {
				if (!db.isComplex()) { // only a complex
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1), it.bDouble, 0);
						c128data[it.oIndex] = z[0];
						c128data[it.oIndex + 1] = z[1];
					}
				} else if (!da.isComplex()) { // only b complex
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, 0, it.bDouble, db.getElementDoubleAbs(it.bIndex + 1));
						c128data[it.oIndex] = z[0];
						c128data[it.oIndex + 1] = z[1];
					}
				} else {
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1), it.bDouble,
								db.getElementDoubleAbs(it.bIndex + 1));
						c128data[it.oIndex] = z[0];
						c128data[it.oIndex + 1] = z[1];
					}
				}
			} else {
				while (it.hasNext()) {
					op.complexOperate(z, it.aDouble, 0, it.bDouble, 0);
					c128data[it.oIndex] = z[0];
					c128data[it.oIndex + 1] = z[1];
				}
			}
		} else if (result instanceof CompoundFloatDataset) {
			float[] af32data = ((CompoundFloatDataset) result).getData();

			if (!da.isComplex() && !db.isComplex()) {
				if (is == 1) {
					while (it.hasNext()) {
						af32data[it.oIndex] = (float) op.doubleOperate(it.aDouble, it.bDouble);
					}
				} else {
					int ms;
					if (as == 1 && bs != 1) {
						ms = Math.min(is, bs);
						while (it.hasNext()) {
							af32data[it.oIndex] = (float) op.doubleOperate(it.aDouble, it.bDouble);
							for (int j = 1; j < ms; j++) {
								af32data[it.oIndex + j] = (float) op.doubleOperate(it.aDouble,
										db.getElementDoubleAbs(it.bIndex + j));
							}
						}
					} else if (as != 1 && bs == 1) {
						ms = Math.min(is, as);
						while (it.hasNext()) {
							af32data[it.oIndex] = (float) op.doubleOperate(it.aDouble, it.bDouble);
							for (int j = 1; j < ms; j++) {
								af32data[it.oIndex + j] = (float) op
										.doubleOperate(da.getElementDoubleAbs(it.aIndex + j), it.bDouble);
							}
						}
					} else {
						ms = Math.min(is, Math.min(as, bs));
						while (it.hasNext()) {
							af32data[it.oIndex] = (float) op.doubleOperate(it.aDouble, it.bDouble);
							for (int j = 1; j < ms; j++) {
								af32data[it.oIndex + j] = (float) op.doubleOperate(
										da.getElementDoubleAbs(it.aIndex + j), db.getElementDoubleAbs(it.bIndex + j));
							}
						}
					}
				}
			} else {
				z = new double[2];
				if (!db.isComplex()) { // only a complex
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1), it.bDouble, 0);
						float ox = (float) z[0];
						for (int j = 0; j < is; j++) {
							af32data[it.oIndex + j] = ox;
						}
					}
				} else if (!da.isComplex()) { // only b complex
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, 0, it.bDouble, db.getElementDoubleAbs(it.bIndex + 1));
						float ox = (float) z[0];
						for (int j = 0; j < is; j++) {
							af32data[it.oIndex + j] = ox;
						}
					}
				} else {
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1),
								it.bDouble, db.getElementDoubleAbs(it.bIndex + 1));
						float ox = (float) z[0];
						for (int j = 0; j < is; j++) {
							af32data[it.oIndex + j] = ox;
						}
					}
				}
			}
		} else if (result instanceof CompoundDoubleDataset) {
			double[] af64data = ((CompoundDoubleDataset) result).getData();

			if (!da.isComplex() && !db.isComplex()) {
				if (is == 1) {
					while (it.hasNext()) {
						af64data[it.oIndex] = op.doubleOperate(it.aDouble, it.bDouble);
					}
				} else {
					int ms;
					if (as == 1 && bs != 1) {
						ms = Math.min(is, bs);
						while (it.hasNext()) {
							af64data[it.oIndex] = op.doubleOperate(it.aDouble, it.bDouble);
							for (int j = 1; j < ms; j++) {
								af64data[it.oIndex + j] = op.doubleOperate(it.aDouble,
										db.getElementDoubleAbs(it.bIndex + j));
							}
						}
					} else if (as != 1 && bs == 1) {
						ms = Math.min(is, as);
						while (it.hasNext()) {
							af64data[it.oIndex] = op.doubleOperate(it.aDouble, it.bDouble);
							for (int j = 1; j < ms; j++) {
								af64data[it.oIndex + j] = op.doubleOperate(da.getElementDoubleAbs(it.aIndex + j),
										it.bDouble);
							}
						}
					} else {
						ms = Math.min(is, Math.min(as, bs));
						while (it.hasNext()) {
							af64data[it.oIndex] = op.doubleOperate(it.aDouble, it.bDouble);
							for (int j = 1; j < ms; j++) {
								af64data[it.oIndex + j] = op.doubleOperate(da.getElementDoubleAbs(it.aIndex + j),
										db.getElementDoubleAbs(it.bIndex + j));
							}
						}
					}
				}
			} else {
				z = new double[2];
				if (!db.isComplex()) { // only a complex
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1), it.bDouble, 0);
						double ox = z[0];
						for (int j = 0; j < is; j++) {
							af64data[it.oIndex + j] = ox;
						}
					}
				} else if (!da.isComplex()) { // only b complex
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, 0, it.bDouble, db.getElementDoubleAbs(it.bIndex + 1));
						double ox = z[0];
						for (int j = 0; j < is; j++) {
							af64data[it.oIndex + j] = ox;
						}
					}
				} else {
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1),
								it.bDouble, db.getElementDoubleAbs(it.bIndex + 1));
						double ox = z[0];
						for (int j = 0; j < is; j++) {
							af64data[it.oIndex + j] = ox;
						}
					}
				}
			}
		} else if (result instanceof BooleanDataset) {
			boolean[] bdata = ((BooleanDataset) result).getData();

			if (!da.isComplex() && !db.isComplex()) {
				while (it.hasNext()) {
					bdata[it.oIndex] = op.booleanOperate(it.aLong, it.aLong);
				}
			} else {
				z = new double[2];
				if (!db.isComplex()) {
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1), it.bDouble, 0);
						bdata[it.oIndex] = z[0] != 0;
					}
				} else if (!da.isComplex()) {
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, 0, it.bDouble, db.getElementDoubleAbs(it.bIndex + 1));
						bdata[it.oIndex] = z[0] != 0;
					}
				} else {
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1),
								it.bDouble, db.getElementDoubleAbs(it.bIndex + 1));
						bdata[it.oIndex] = z[0] != 0;
					}
				}
			}
		} else if (result instanceof ByteDataset) {
			byte[] i8data = ((ByteDataset) result).getData();

			if (!da.isComplex() && !db.isComplex()) {
				while (it.hasNext()) {
					i8data[it.oIndex] = (byte) op.longOperate(it.aLong, it.aLong);
				}
			} else {
				z = new double[2];
				if (!db.isComplex()) { // only a complex
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1), it.bDouble, 0);
						i8data[it.oIndex] = (byte) toLong(z[0]);
					}
				} else if (!da.isComplex()) { // only b complex
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, 0, it.bDouble, db.getElementDoubleAbs(it.bIndex + 1));
						i8data[it.oIndex] = (byte) toLong(z[0]);
					}
				} else {
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1),
								it.bDouble, db.getElementDoubleAbs(it.bIndex + 1));
						i8data[it.oIndex] = (byte) toLong(z[0]);
					}
				}
			}
		} else if (result instanceof ShortDataset) {
			short[] i16data = ((ShortDataset) result).getData();

			if (!da.isComplex() && !db.isComplex()) {
				while (it.hasNext()) {
					i16data[it.oIndex] = (short) op.longOperate(it.aLong, it.aLong);
				}
			} else {
				z = new double[2];
				if (!db.isComplex()) { // only a complex
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1), it.bDouble, 0);
						i16data[it.oIndex] = (short) toLong(z[0]);
					}
				} else if (!da.isComplex()) { // only b complex
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, 0, it.bDouble, db.getElementDoubleAbs(it.bIndex + 1));
						i16data[it.oIndex] = (short) toLong(z[0]);
					}
				} else {
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1),
								it.bDouble, db.getElementDoubleAbs(it.bIndex + 1));
						i16data[it.oIndex] = (short) toLong(z[0]);
					}
				}
			}
		} else if (result instanceof IntegerDataset) {
			int[] i32data = ((IntegerDataset) result).getData();

			if (!da.isComplex() && !db.isComplex()) {
				while (it.hasNext()) {
					i32data[it.oIndex] = (int) op.longOperate(it.aLong, it.aLong);
				}
			} else {
				z = new double[2];
				if (!db.isComplex()) { // only a complex
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1), it.bDouble, 0);
						i32data[it.oIndex] = (int) toLong(z[0]);
					}
				} else if (!da.isComplex()) { // only b complex
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, 0, it.bDouble, db.getElementDoubleAbs(it.bIndex + 1));
						i32data[it.oIndex] = (int) toLong(z[0]);
					}
				} else {
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1),
								it.bDouble, db.getElementDoubleAbs(it.bIndex + 1));
						i32data[it.oIndex] = (int) toLong(z[0]);
					}
				}
			}
		} else if (result instanceof LongDataset) {
			long[] i64data = ((LongDataset) result).getData();

			if (!da.isComplex() && !db.isComplex()) {
				while (it.hasNext()) {
					i64data[it.oIndex] = op.longOperate(it.aLong, it.aLong);
				}
			} else {
				z = new double[2];
				if (!db.isComplex()) { // only a complex
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1), it.bDouble, 0);
						i64data[it.oIndex] = toLong(z[0]);
					}
				} else if (!da.isComplex()) { // only b complex
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, 0, it.bDouble, db.getElementDoubleAbs(it.bIndex + 1));
						i64data[it.oIndex] = toLong(z[0]);
					}
				} else {
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1),
								it.bDouble, db.getElementDoubleAbs(it.bIndex + 1));
						i64data[it.oIndex] = toLong(z[0]);
					}
				}
			}
		} else if (result instanceof CompoundByteDataset) {
			byte[] ai8data = ((CompoundByteDataset) result).getData();

			if (!da.isComplex() && !db.isComplex()) {
				if (is == 1) {
					while (it.hasNext()) {
						ai8data[it.oIndex] = (byte) op.longOperate(it.aLong, it.bLong);
					}
				} else { // broadcast to other elements of output if possible
					int ms;
					if (as == 1 && bs != 1) {
						ms = Math.min(is, bs);
						while (it.hasNext()) {
							ai8data[it.oIndex] = (byte) op.longOperate(it.aLong, it.bLong);
							for (int j = 1; j < ms; j++) {
								ai8data[it.oIndex + j] = (byte) op.longOperate(it.aLong,
										db.getElementLongAbs(it.bIndex + j));
							}
						}
					} else if (as != 1 && bs == 1) {
						ms = Math.min(is, as);
						while (it.hasNext()) {
							ai8data[it.oIndex] = (byte) op.longOperate(it.aLong, it.bLong);
							for (int j = 1; j < ms; j++) {
								ai8data[it.oIndex + j] = (byte) op.longOperate(da.getElementLongAbs(it.aIndex + j),
										it.bLong);
							}
						}
					} else {
						ms = Math.min(is, Math.min(as, bs));
						while (it.hasNext()) {
							ai8data[it.oIndex] = (byte) op.longOperate(it.aLong, it.bLong);
							for (int j = 1; j < ms; j++) {
								ai8data[it.oIndex + j] = (byte) op.longOperate(da.getElementLongAbs(it.aIndex + j),
										db.getElementLongAbs(it.bIndex + j));
							}
						}
					}
				}
			} else {
				z = new double[2];
				if (!db.isComplex()) { // only a complex
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1), it.bDouble, 0);
						byte ox = (byte) toLong(z[0]);
						for (int j = 0; j < is; j++) {
							ai8data[it.oIndex + j] = ox;
						}
					}
				} else if (!da.isComplex()) { // only b complex
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, 0, it.bDouble, db.getElementDoubleAbs(it.bIndex + 1));
						byte ox = (byte) toLong(z[0]);
						for (int j = 0; j < is; j++) {
							ai8data[it.oIndex + j] = ox;
						}
					}
				} else {
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1),
								it.bDouble, db.getElementDoubleAbs(it.bIndex + 1));
						byte ox = (byte) toLong(z[0]);
						for (int j = 0; j < is; j++) {
							ai8data[it.oIndex + j] = ox;
						}
					}
				}
			}
		} else if (result instanceof CompoundShortDataset) {
			short[] ai16data = ((CompoundShortDataset) result).getData();

			if (!da.isComplex() && !db.isComplex()) {
				if (is == 1) {
					while (it.hasNext()) {
						ai16data[it.oIndex] = (short) op.longOperate(it.aLong, it.bLong);
					}
				} else {
					int ms;
					if (as == 1 && bs != 1) {
						ms = Math.min(is, bs);
						while (it.hasNext()) {
							ai16data[it.oIndex] = (short) op.longOperate(it.aLong, it.bLong);
							for (int j = 1; j < ms; j++) {
								ai16data[it.oIndex + j] = (short) op.longOperate(it.aLong,
										db.getElementLongAbs(it.bIndex + j));
							}
						}
					} else if (as != 1 && bs == 1) {
						ms = Math.min(is, as);
						while (it.hasNext()) {
							ai16data[it.oIndex] = (short) op.longOperate(it.aLong, it.bLong);
							for (int j = 1; j < ms; j++) {
								ai16data[it.oIndex + j] = (short) op.longOperate(da.getElementLongAbs(it.aIndex + j),
										it.bLong);
							}
						}
					} else {
						ms = Math.min(is, Math.min(as, bs));
						while (it.hasNext()) {
							ai16data[it.oIndex] = (short) op.longOperate(it.aLong, it.bLong);
							for (int j = 1; j < ms; j++) {
								ai16data[it.oIndex + j] = (short) op.longOperate(da.getElementLongAbs(it.aIndex + j),
										db.getElementLongAbs(it.bIndex + j));
							}
						}
					}
				}
			} else {
				z = new double[2];
				if (!db.isComplex()) { // only a complex
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1), it.bDouble, 0);
						short ox = (short) toLong(z[0]);
						for (int j = 0; j < is; j++) {
							ai16data[it.oIndex + j] = ox;
						}
					}
				} else if (!da.isComplex()) { // only b complex
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, 0, it.bDouble, db.getElementDoubleAbs(it.bIndex + 1));
						short ox = (short) toLong(z[0]);
						for (int j = 0; j < is; j++) {
							ai16data[it.oIndex + j] = ox;
						}
					}
				} else {
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1),
								it.bDouble, db.getElementDoubleAbs(it.bIndex + 1));
						short ox = (short) toLong(z[0]);
						for (int j = 0; j < is; j++) {
							ai16data[it.oIndex + j] = ox;
						}
					}
				}
			}
		} else if (result instanceof CompoundIntegerDataset) {
			int[] ai32data = ((CompoundIntegerDataset) result).getData();

			if (!da.isComplex() && !db.isComplex()) {
				if (is == 1) {
					while (it.hasNext()) {
						ai32data[it.oIndex] = (int) op.longOperate(it.aLong, it.bLong);
					}
				} else {
					int ms;
					if (as == 1 && bs != 1) {
						ms = Math.min(is, bs);
						while (it.hasNext()) {
							ai32data[it.oIndex] = (int) op.longOperate(it.aLong, it.bLong);
							for (int j = 1; j < ms; j++) {
								ai32data[it.oIndex + j] = (int) op.longOperate(it.aLong,
										db.getElementLongAbs(it.bIndex + j));
							}
						}
					} else if (as != 1 && bs == 1) {
						ms = Math.min(is, as);
						while (it.hasNext()) {
							ai32data[it.oIndex] = (int) op.longOperate(it.aLong, it.bLong);
							for (int j = 1; j < ms; j++) {
								ai32data[it.oIndex + j] = (int) op.longOperate(da.getElementLongAbs(it.aIndex + j),
										it.bLong);
							}
						}
					} else {
						ms = Math.min(is, Math.min(as, bs));
						while (it.hasNext()) {
							ai32data[it.oIndex] = (int) op.longOperate(it.aLong, it.bLong);
							for (int j = 1; j < ms; j++) {
								ai32data[it.oIndex + j] = (int) op.longOperate(da.getElementLongAbs(it.aIndex + j),
										db.getElementLongAbs(it.bIndex + j));
							}
						}
					}
				}
			} else {
				z = new double[2];
				if (!db.isComplex()) { // only a complex
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1), it.bDouble, 0);
						short ox = (short) toLong(z[0]);
						for (int j = 0; j < is; j++) {
							ai32data[it.oIndex + j] = ox;
						}
					}
				} else if (!da.isComplex()) { // only b complex
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, 0, it.bDouble, db.getElementDoubleAbs(it.bIndex + 1));
						short ox = (short) toLong(z[0]);
						for (int j = 0; j < is; j++) {
							ai32data[it.oIndex + j] = ox;
						}
					}
				} else {
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1),
								it.bDouble, db.getElementDoubleAbs(it.bIndex + 1));
						short ox = (short) toLong(z[0]);
						for (int j = 0; j < is; j++) {
							ai32data[it.oIndex + j] = ox;
						}
					}
				}
			}
		} else if (result instanceof CompoundLongDataset) {
			long[] ai64data = ((CompoundLongDataset) result).getData();

			if (!da.isComplex() && !db.isComplex()) {
				if (is == 1) {
					while (it.hasNext()) {
						ai64data[it.oIndex] = op.longOperate(it.aLong, it.bLong);
					}
				} else {
					int ms;
					if (as == 1 && bs != 1) {
						ms = Math.min(is, bs);
						while (it.hasNext()) {
							ai64data[it.oIndex] = op.longOperate(it.aLong, it.bLong);
							for (int j = 1; j < ms; j++) {
								ai64data[it.oIndex + j] = op.longOperate(it.aLong, db.getElementLongAbs(it.bIndex + j));
							}
						}
					} else if (as != 1 && bs == 1) {
						ms = Math.min(is, as);
						while (it.hasNext()) {
							ai64data[it.oIndex] = op.longOperate(it.aLong, it.bLong);
							for (int j = 1; j < ms; j++) {
								ai64data[it.oIndex + j] = op.longOperate(da.getElementLongAbs(it.aIndex + j), it.bLong);
							}
						}
					} else {
						ms = Math.min(is, Math.min(as, bs));
						while (it.hasNext()) {
							ai64data[it.oIndex] = op.longOperate(it.aLong, it.bLong);
							for (int j = 1; j < ms; j++) {
								ai64data[it.oIndex + j] = op.longOperate(da.getElementLongAbs(it.aIndex + j),
										db.getElementLongAbs(it.bIndex + j));
							}
						}
					}
				}
			} else {
				z = new double[2];
				if (!db.isComplex()) { // only a complex
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1), it.bDouble, 0);
						long ox = toLong(z[0]);
						for (int j = 0; j < is; j++) {
							ai64data[it.oIndex + j] = ox;
						}
					}
				} else if (!da.isComplex()) { // only b complex
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, 0, it.bDouble, db.getElementDoubleAbs(it.bIndex + 1));
						long ox = toLong(z[0]);
						for (int j = 0; j < is; j++) {
							ai64data[it.oIndex + j] = ox;
						}
					}
				} else {
					while (it.hasNext()) {
						op.complexOperate(z, it.aDouble, da.getElementDoubleAbs(it.aIndex + 1),
								it.bDouble, db.getElementDoubleAbs(it.bIndex + 1));
						long ox = toLong(z[0]);
						for (int j = 0; j < is; j++) {
							ai64data[it.oIndex + j] = ox;
						}
					}
				}
			}

		} else {
			throw new UnsupportedOperationException("operate does not support this dataset type");
		}

		// set the name based on the changes made
		result.setName(op.toString(da.getName(), db.getName()));

		return result;
	}
}
