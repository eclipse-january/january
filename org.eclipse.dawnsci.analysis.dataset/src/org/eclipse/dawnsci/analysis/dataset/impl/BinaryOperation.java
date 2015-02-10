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
	 * @param ra
	 * @param ia
	 * @param rb
	 * @param ib
	 * @return Re(a op b)
	 */
	double realComplexOperate(double ra, double ia, double rb, double ib);

	/**
	 * @param ra
	 * @param ia
	 * @param rb
	 * @param ib
	 * @return Im(a op b)
	 */
	double imagComplexOperate(double ra, double ia, double rb, double ib);

	@Override
	String toString();
}

class Stub implements BinaryOperation {
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
	public double realComplexOperate(double ra, double ia, double rb, double ib) {
		return 0;
	}

	/**
	 * override this
	 */
	@Override
	public double imagComplexOperate(double ra, double ia, double rb, double ib) {
		return 0;
	}
}
