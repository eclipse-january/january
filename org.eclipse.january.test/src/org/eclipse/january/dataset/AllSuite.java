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

import org.eclipse.january.asserts.TestUtils;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(TestUtils.VerboseSuite.class)
@SuiteClasses({ AbstractCompoundDatasetTest.class, AbstractDatasetTest.class, AggregateDatasetTest.class,
		BinaryOperationTest.class, BooleanDatasetTest.class, BooleanIteratorTest.class,
		BroadcastIteratorTest.class, BroadcastUtilsTest.class, ByteDatasetTest.class,
		ComparisonsTest.class, CompoundDoubleDatasetTest.class, ComplexDoubleDatasetTest.class,
		ComplexFloatDatasetTest.class,
		DatasetFactoryTest.class, DateDatasetTest.class, DoubleDatasetTest.class,
		FloatDatasetTest.class, IndexIteratorTest.class, IntegerDatasetTest.class,
		IntegerIteratorTest.class, IntegersIteratorTest.class, InterpolatorUtilsTest.class,
		LazyDatasetTest.class, LazyDynamicDatasetTest.class, LazyDynamicLoaderTest.class,
		LazyMathsTest.class, LazyWriteableDatasetTest.class, LinearAlgebraTest.class, LongDatasetTest.class,
		MathsArrayTypeAbsFunctionParameterizeTest.class, MathsBasicTypeAbsFunctionParameterizeTest.class,
		MathsComplexAbsFunctionParameterizeTest.class, MathsTest.class,
		ObjectDatasetTest.class, OutlierCorrectnessTest.class, OutlierStatsTest.class,
		PositionIteratorTest.class, RandomTest.class, RGBDatasetTest.class,
		ShortDatasetTest.class, SingleInputBroadcastIteratorTest.class, SliceIteratorTest.class,
		SliceNDIteratorTest.class, SliceNDTest.class, SliceTest.class, StatsTest.class,
		StrideIteratorTest.class, StringDatasetTest.class,
		UnsignedArithmeticsTest.class, UnaryOperationTest.class,
		org.eclipse.january.metadata.AllSuite.class,
		ParameterizeDatasetTests.class
		})
public class AllSuite {

}
