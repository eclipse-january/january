/*-
 * Copyright 2015 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.dataset.impl;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic;

public class NullStorelessUnivariateStatistic implements StorelessUnivariateStatistic {

	@Override
	public double evaluate(double[] arg0) throws MathIllegalArgumentException {
		return 0;
	}

	@Override
	public double evaluate(double[] arg0, int arg1, int arg2) throws MathIllegalArgumentException {
		return 0;
	}

	@Override
	public void clear() {

	}

	@Override
	public StorelessUnivariateStatistic copy() {
		return new NullStorelessUnivariateStatistic();
	}

	@Override
	public long getN() {
		return 0;
	}

	@Override
	public double getResult() {
		return 0;
	}

	@Override
	public void increment(double arg0) {

	}

	@Override
	public void incrementAll(double[] arg0) throws MathIllegalArgumentException {

	}

	@Override
	public void incrementAll(double[] arg0, int arg1, int arg2) throws MathIllegalArgumentException {

	}

}
