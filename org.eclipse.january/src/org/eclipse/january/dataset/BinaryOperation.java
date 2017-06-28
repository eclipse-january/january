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

/**
 * Interface to represent a binary operation for implementations over different output domains
 */
public interface BinaryOperation extends IOperation {

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

	/**
	 * @param a
	 * @param b
	 * @return string to represent output
	 * @since 2.0
	 */
	String toString(String a, String b);

	/**
	 * Stub class where only three methods need to be overridden:
	 *  {@link #complexOperate(double[], double, double, double, double)},
	 *  {@link #toString(String, String)}
	 */
	public static class Stub implements BinaryOperation {
		double[] z = new double[2];

		@Override
		public double doubleOperate(double a, double b) {
			complexOperate(z, a, 0, b, 0);
			return z[0];
		}

		@Override
		public boolean booleanOperate(long a, long b) {
			return doubleOperate(a, b) != 0;
		}

		@Override
		public long longOperate(long a, long b) {
			return DTypeUtils.toLong(doubleOperate(a, b));
		}

		/**
		 * override this
		 */
		@Override
		public void complexOperate(double[] out, double ra, double ia, double rb, double ib) {
		}

		/**
		 * override this
		 */
		@Override
		public String toString(String string, String string2) {
			return null;
		}
	}
}
