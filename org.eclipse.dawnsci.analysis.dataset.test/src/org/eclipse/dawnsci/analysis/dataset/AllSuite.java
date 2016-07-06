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

package org.eclipse.dawnsci.analysis.dataset;

import org.eclipse.dawnsci.analysis.dataset.DCTTest;
import org.eclipse.dawnsci.analysis.dataset.FFTTest;
import org.eclipse.dawnsci.analysis.dataset.ImageTest;
import org.eclipse.dawnsci.analysis.dataset.SignalTest;
import org.eclipse.dawnsci.analysis.dataset.SummedAreaTableTest;
import org.eclipse.january.asserts.TestUtils;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(TestUtils.VerboseSuite.class)
@SuiteClasses({ DCTTest.class, FFTTest.class, ImageTest.class, SignalTest.class, SummedAreaTableTest.class,
	org.eclipse.dawnsci.analysis.dataset.function.AllSuite.class,
	org.eclipse.dawnsci.analysis.dataset.slicer.AllSuite.class,
		})
public class AllSuite {

}
