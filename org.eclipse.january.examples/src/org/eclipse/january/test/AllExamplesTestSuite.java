/*******************************************************************************
 * Copyright (c) 2017 Kichwa Coders Ltd, and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jonah Graham - initial implementation
 *******************************************************************************/

package org.eclipse.january.test;

import java.io.IOException;

import org.eclipse.january.DatasetException;
import org.eclipse.january.examples.dataset.AxesMetadataExample;
import org.eclipse.january.examples.dataset.BasicExample;
import org.eclipse.january.examples.dataset.ConwayGameOfLife;
import org.eclipse.january.examples.dataset.ErrorExamples;
import org.eclipse.january.examples.dataset.IterationExamples;
import org.eclipse.january.examples.dataset.LazyExamples;
import org.eclipse.january.examples.dataset.NumpyExamples;
import org.eclipse.january.examples.dataset.SlicingExamples;
import org.eclipse.january.examples.io.LazyLoadingExample;
import org.eclipse.january.tutorial.C1TheBasics;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * New here? Start with {@link BasicExample}.
 *
 * This JUnit suite is used to automate testing of all the examples in January.
 * As the examples are not written as self-checking tests, this suite simply
 * ensures that they are running without exceptions.
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ AxesMetadataExample.class, ErrorExamples.class, IterationExamples.class, LazyExamples.class,
		NumpyExamples.class, SlicingExamples.class, AllExamplesTestSuite.StandaloneExamples.class })
public class AllExamplesTestSuite {

	/**
	 * Some of the examples are provided as classes with main instead of JUnit,
	 * this class provides tests for those classes by calling main.
	 */
	public static class StandaloneExamples {

		@Test
		public void testBasicExample() {
			BasicExample.main(new String[0]);
		}

		@Test
		public void testC1TheBasics() {
			C1TheBasics.main(new String[0]);
		}

		@Test
		public void testConway() throws Exception {
			ConwayGameOfLife.main(new String[0]);
		}

		@Test
		public void testLazyLoadingExample() throws IOException, DatasetException {
			LazyLoadingExample.main(new String[0]);
		}
	}
}
