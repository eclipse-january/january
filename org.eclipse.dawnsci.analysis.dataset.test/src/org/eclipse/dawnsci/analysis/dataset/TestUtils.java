/*-
 * Copyright (c) 2012 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.dataset;

import java.util.Arrays;

import org.eclipse.dawnsci.analysis.dataset.impl.Dataset;
import org.eclipse.dawnsci.analysis.dataset.impl.IndexIterator;
import org.junit.Assert;

public class TestUtils {
	

	/**
	 * Assert equality of datasets where each element is true if abs(a - b) <= absTol + relTol*abs(b)
	 * @param expected
	 * @param calc
	 * @param relTolerance
	 * @param absTolerance
	 */
	public static void assertDatasetEquals(Dataset expected, Dataset calc, double relTolerance, double absTolerance) {
		assertDatasetEquals(expected, calc, false, relTolerance, absTolerance);
	}

	/**
	 * Assert equality of datasets where each element is true if abs(a - b) <= absTol + relTol*abs(b)
	 * @param expected
	 * @param calc
	 * @param testDtype
	 * @param relTolerance
	 * @param absTolerance
	 */
	public static void assertDatasetEquals(Dataset expected, Dataset calc, boolean testDtype, double relTolerance, double absTolerance) {
		Assert.assertEquals("Rank", expected.getRank(), calc.getRank());
		Assert.assertEquals("Size", expected.getSize(), calc.getSize());
		Assert.assertArrayEquals("Shape", expected.getShape(), calc.getShape());
		Assert.assertEquals("Itemsize", expected.getElementsPerItem(), calc.getElementsPerItem());
		if (testDtype) {
			Assert.assertEquals("Dataset type", expected.getDtype(), calc.getDtype());
		}
		IndexIterator at = calc.getIterator(true);
		IndexIterator bt = expected.getIterator();
		final int is = calc.getElementsPerItem();

		while (at.hasNext() && bt.hasNext()) {
			for (int j = 0; j < is; j++) {
				assertEquals("Value does not match at " + Arrays.toString(at.getPos()) + "; " + j +
						": ", expected.getElementDoubleAbs(bt.index + j), calc.getElementDoubleAbs(at.index + j),
						relTolerance, absTolerance);
			}
		}
	}

	/**
	 * Assert equality if abs(e - a) <= max(1e-20, 1e-14*max(abs(e), abs(a)))
	 * @param s message for assert exception
	 * @param e expected value
	 * @param a actual value
	 */
	public static void assertEquals(String s, double e, double a) {
		assertEquals(s, e, a, 1e-14, 1e-20);
	}

	/**
	 * Assert equality if abs(e - a) <= max(absTol, relTol*max(abs(e), abs(a)))
	 * @param s message for assert exception
	 * @param e expected value
	 * @param a actual value
	 * @param relTol relative tolerance
	 * @param absTol absolute tolerance
	 */
	public static void assertEquals(String s, double e, double a, double relTol, double absTol) {
		double t = Math.max(absTol, relTol*Math.max(Math.abs(e), Math.abs(a)));
		Assert.assertEquals(s, e, a, t);
	}

	static boolean verboseOutput = false;

	public static void verbosePrintf(String fmt, Object... args) {
		if (verboseOutput) {
			System.out.printf(fmt, args);
		}
	}
}
