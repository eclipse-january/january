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
 * Interface to represent a unary operation for implementations over different output domains
 */
public interface UnaryOperation extends IOperation {

	/**
	 * @param a
	 * @return op(a)
	 */
	boolean booleanOperate(long a);

	/**
	 * @param a
	 * @return op(a)
	 */
	long longOperate(long a);

	/**
	 * @param a
	 * @return op(a)a
	 */
	double doubleOperate(double a);

	/**
	 * @param out holds op(ra, ia)
	 * @param ra
	 * @param ia
	 */
	void complexOperate(double[] out, double ra, double ia);

	/**
	 * @param a
	 * @return string to represent output
	 */
	String toString(String a);

	/**
	 * Stub class where only two methods need to be overridden:
	 *  {@link #complexOperate(double[], double, double)},
	 *  {@link #toString(String)}
	 */
	public static class Stub implements UnaryOperation {
		double[] z = new double[2];

		@Override
		public double doubleOperate(double a) {
			complexOperate(z, a, 0);
			return z[0];
		}

		@Override
		public boolean booleanOperate(long a) {
			return doubleOperate(a) != 0;
		}

		private static long toLong(double d) {
			if (Double.isInfinite(d) || Double.isNaN(d))
				return 0;
			return (long) d;
		}

		@Override
		public long longOperate(long a) {
			return toLong(doubleOperate(a));
		}

		/**
		 * Override this
		 */
		@Override
		public void complexOperate(double[] out, double ra, double ia) {
		}

		/**
		 * Override this
		 */
		@Override
		public String toString(String a) {
			return null;
		}
	}
}
