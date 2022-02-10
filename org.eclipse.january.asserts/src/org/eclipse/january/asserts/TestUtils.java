/*-
 * Copyright (c) 2012, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.asserts;

import java.util.Arrays;

import org.eclipse.january.dataset.BooleanDataset;
import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.IndexIterator;
import org.eclipse.january.dataset.InterfaceUtils;
import org.eclipse.january.dataset.ObjectDataset;
import org.eclipse.january.dataset.StringDataset;
import org.junit.Assert;
import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

public class TestUtils {
	static RunListener listener;
	static {
		listener = new RunListener() {
			@Override
			public void testStarted(Description description) throws Exception {
				if (verbosity != Verbosity.QUIET) {
					System.out.println("Starting: " + description.getMethodName());
				}
				super.testStarted(description);
			}

			@Override
			public void testFinished(Description description) throws Exception {
				super.testFinished(description);
				if (verbosity != Verbosity.QUIET) {
					System.out.println("Finished: " + description.getMethodName());
				}
			}
		};
	}

	/**
	 * Suite that adds a Run listener that prints when methods start and finish
	 */
	public static class VerboseSuite extends Suite {

		// TODO handle suites of suites properly
		public VerboseSuite(Class<?> klass, RunnerBuilder builder) throws InitializationError {
			super(klass, builder);
		}

		@Override
		public void run(RunNotifier notifier) {
			// To avoid duplicates need to do N-1 times if there's N levels of these suites
			// Note, in this notifier implementation it does not matter if we try to remove
			// a listener if is not contained with the notifier
			notifier.removeListener(listener);

			notifier.addListener(listener);
			super.run(notifier);
			notifier.removeListener(listener);
		}
	}

	/**
	 * Assert equality of datasets where each item is true if they are equal or
	 * for floating point datasets, if <code>abs(a - b) &le; 1e-12 + 1e-12*abs(b)</code>
	 * <p>
	 * The dataset types have to match and so does the number of elements in each item.
	 * <p>
	 * Same as <pre>TestUtils.assertDatasetEquals(expected, actual, true, 1e-12, 1e-12)</pre>
	 * @param expected dataset
	 * @param actual dataset
	 */
	public static void assertDatasetEquals(Dataset expected, Dataset actual) {
		assertDatasetEquals(expected, actual, true, 1e-12, 1e-12);
	}

	/**
	 * Assert equality of datasets where each element is true if they are equal or
	 * for floating point datasets, if <code>abs(a - b) &le; 1e-12 + 1e-12*abs(b)</code>
	 * @param expected dataset
	 * @param actual dataset
	 * @param testDTypeAndItemSize if true, check dataset type and number of elements
	 */
	public static void assertDatasetEquals(Dataset expected, Dataset actual, boolean testDTypeAndItemSize) {
		assertDatasetEquals(expected, actual, testDTypeAndItemSize, 1e-12, 1e-12);
	}

	/**
	 * Assert equality of datasets where each element is true if they are equal or
	 * for floating point datasets, if <code>abs(a - b) &le; absTolerance + relTolerance*abs(b)</code>.
	 * <p>
	 * The dataset types does not have to match nor does the number of elements in each item. 
	 * @param expected dataset
	 * @param actual dataset
	 * @param relTolerance relative tolerance
	 * @param absTolerance absolute tolerance
	 */
	public static void assertDatasetEquals(Dataset expected, Dataset actual, double relTolerance, double absTolerance) {
		assertDatasetEquals(expected, actual, false, relTolerance, absTolerance);
	}

	/**
	 * Assert equality of datasets where each element is true if they are equal or
	 * for floating point datasets, if <code>abs(a - b) &le; absTolerance + relTolerance*abs(b)</code>.
	 * @param expected dataset
	 * @param actual dataset
	 * @param testDTypeAndItemSize if true, check dataset type and number of elements
	 * @param relTolerance relative tolerance
	 * @param absTolerance absolute tolerance
	 */
	public static void assertDatasetEquals(Dataset expected, Dataset actual, boolean testDTypeAndItemSize, double relTolerance, double absTolerance) {
		final int eis = expected.getElementsPerItem();
		final int ais = actual.getElementsPerItem();
		Class<? extends Dataset> clazz = InterfaceUtils.findSubInterface(expected.getClass());
		if (testDTypeAndItemSize) {
			Assert.assertEquals("Interface", clazz, InterfaceUtils.findSubInterface(actual.getClass()));
			Assert.assertEquals("Itemsize", eis, ais);
		}
		Assert.assertEquals("Size", expected.getSize(), actual.getSize());
		try {
			Assert.assertArrayEquals("Shape", expected.getShapeRef(), actual.getShapeRef());
		} catch (AssertionError e) {
			if (actual.getSize() == 1) {
				Assert.assertArrayEquals("Shape", new int[0], actual.getShapeRef());
			} else {
				throw e;
			}
		}
		IndexIterator et = expected.getIterator(true);
		IndexIterator at = actual.getIterator();
		final int is = Math.max(eis, ais);

		int n = 0;
		if (InterfaceUtils.isInteger(clazz)) {
			while (et.hasNext() && at.hasNext()) {
				for (int j = 0; j < is; j++) {
					long e = j >= eis ? 0 : expected.getElementLongAbs(et.index + j);
					long a = j >= ais ? 0 : actual.getElementLongAbs(at.index + j);
					Assert.assertEquals("Value does not match at " + Arrays.toString(et.getPos()) + "; " + j +
							": ", e, a);
				}
				n++;
			}
		} else if (InterfaceUtils.isFloating(clazz)) {
			while (et.hasNext() && at.hasNext()) {
				for (int j = 0; j < is; j++) {
					double e = j >= eis ? 0 : expected.getElementDoubleAbs(et.index + j);
					double a = j >= ais ? 0 : actual.getElementDoubleAbs(at.index + j);
					assertEquals("Value does not match at " + Arrays.toString(et.getPos()) + "; " + j +
							": ", e, a, relTolerance, absTolerance);
				}
				n++;
			}
		} else if (BooleanDataset.class.isAssignableFrom(clazz)) {
			while (et.hasNext() && at.hasNext()) {
				for (int j = 0; j < is; j++) {
					boolean e = j >= eis ? false : expected.getElementBooleanAbs(et.index + j);
					boolean a = j >= ais ? false : actual.getElementBooleanAbs(at.index + j);
					Assert.assertEquals("Value does not match at " + Arrays.toString(et.getPos()) + "; " + j +
							": ", e, a);
				}
				n++;
			}
		} else if (StringDataset.class.isAssignableFrom(clazz)) {
			StringDataset es = (StringDataset) expected;
			StringDataset as = (StringDataset) actual;
	
			while (et.hasNext() && at.hasNext()) {
				Assert.assertEquals("Value does not match at " + Arrays.toString(et.getPos()) + ": ",
						es.getAbs(et.index), as.getAbs(at.index));
				n++;
			}
		} else if (ObjectDataset.class.isAssignableFrom(clazz)) {
			ObjectDataset eo = (ObjectDataset) expected;
			ObjectDataset ao = (ObjectDataset) actual;
	
			while (et.hasNext() && at.hasNext()) {
				Assert.assertEquals("Value does not match at " + Arrays.toString(et.getPos()) + ": ",
						eo.getAbs(et.index), ao.getAbs(at.index));
				n++;
			}
		} else {
			while (et.hasNext() && at.hasNext()) {
				Assert.assertEquals("Value does not match at " + Arrays.toString(et.getPos()) + ": ",
						expected.getObjectAbs(et.index), actual.getObjectAbs(at.index));
				n++;
			}
		}

		Assert.assertEquals("Total items checked", expected.getSize(), n);
	}

	/**
	 * Assert equality if <code>abs(e - a) &le; max(1e-20, 1e-14*max(abs(e), abs(a)))</code>
	 * @param s message for assert exception
	 * @param e expected value
	 * @param a actual value
	 */
	public static void assertEquals(String s, double e, double a) {
		assertEquals(s, e, a, 1e-14, 1e-20);
	}

	/**
	 * Assert equality if <code>abs(e - a) &le; max(absTol, relTol*max(abs(e), abs(a)))</code>
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

	public static enum Verbosity {
		/**
		 * Completely quiet
		 */
		QUIET,
		/**
		 * Output test method entry and exit
		 */
		TEST_METHOD,
		/**
		 * Output all
		 */
		VERBOSE;
	}

	private static Verbosity verbosity = Verbosity.QUIET;

	/**
	 * @param verbosity level
	 */
	public static void setVerbosity(Verbosity verbosity) {
		TestUtils.verbosity = verbosity;
	}

	/**
	 * Print when verbosity set to verbose
	 * @param fmt format
	 * @param args arguments
	 */
	public static void verbosePrintf(String fmt, Object... args) {
		if (verbosity == Verbosity.VERBOSE) {
			System.out.printf(fmt, args);
		}
	}

	/**
	 * Print when verbosity set to verbose
	 * @param arg argument
	 */
	public static void verbosePrintln(String arg) {
		if (verbosity == Verbosity.VERBOSE) {
			System.out.println(arg);
		}
	}
}
