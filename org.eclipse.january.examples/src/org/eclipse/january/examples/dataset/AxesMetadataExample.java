/*******************************************************************************
 * Copyright (c) 2017 Deep Blue C Technology Ltd, and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ian Mayo - initial implementation
 *******************************************************************************/
package org.eclipse.january.examples.dataset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.eclipse.january.DatasetException;
import org.eclipse.january.dataset.Comparisons;
import org.eclipse.january.dataset.Comparisons.Monotonicity;
import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.dataset.DatasetUtils;
import org.eclipse.january.dataset.DoubleDataset;
import org.eclipse.january.dataset.IDataset;
import org.eclipse.january.dataset.ILazyDataset;
import org.eclipse.january.dataset.IndexIterator;
import org.eclipse.january.dataset.Maths;
import org.eclipse.january.metadata.AxesMetadata;
import org.eclipse.january.metadata.internal.AxesMetadataImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * example to demonstrate using axes metadata to combine non-synced measurements
 * 
 * 
 */
public class AxesMetadataExample
{

	/**
	 * we wish the interpolation function to be ignorant of the specific mathematical operation being
	 * conducted. This interface wraps the operation in a Command
	 * 
	 */
	public static interface IOperationPerformer
	{
		/**
		 * perform some operation on datasets and and b. If an output dataset is provided, store the
		 * results in there.
		 * 
		 * @param a
		 *          left-hand operand
		 * @param b
		 *          right-hand operand
		 * @param o
		 *          (optional) results object
		 * @return a dataset product
		 */
		public Dataset perform(final Dataset a, final Dataset b, final Dataset o);
	}

	/**
	 * experiment with extending maths processing to be AxesMetadata aware
	 * 
	 * @author ian
	 * 
	 */
	private static class NewMaths extends Maths
	{
		private static final String DUPLICATE_INDEX_VALUES_NOT_ALLOWED =
				"Duplicate index values not allowed";
		private static final String AXES_MUST_ASCEND_IN_SAME_DIRECTION =
				"The axes must both ascend in the same direction to use interpolation";
		private static final String AXES_MUST_BE_MONOTONIC =
				"The dataset axes must both be monotonic to use interpolation";
		private static final String INDICES_DO_NOT_OVERLAP =
				"The indices of the dataset do not overlap";

		/**
		 * 
		 * @param a
		 *          left-hand operand
		 * @param b
		 *          right-hand operand
		 * @param o
		 *          (optional) results object
		 * @param operation
		 *          operation to apply
		 * @return result of operation, resampling data if necessary to synchronise AxesMetadata
		 */
		public static Dataset performWithInterpolation(final Dataset da,
				final Dataset db, final Dataset o, final IOperationPerformer operation)
		{
			final Dataset operandA;
			final Dataset operandB;

			// retrieve the axes
			final AxesMetadata axesA = da.getFirstMetadata(AxesMetadata.class);
			final AxesMetadata axesB = db.getFirstMetadata(AxesMetadata.class);

			if (axesA == null || axesB == null)
			{
				throw new IllegalArgumentException(
						"Both datasets must have axes metadata");
			}
			else
			{
				// ok, we've got indexed data. see if they match
				final ILazyDataset aLazyIndices = axesA.getAxis(0)[0];
				final ILazyDataset bLazyIndices = axesB.getAxis(0)[0];

				// first we need to load the datasets in order to compare
				// them
				Dataset aIndices = null;
				Dataset bIndices = null;
				boolean datasetLoaded = false;
				try
				{
					aIndices = DatasetUtils.sliceAndConvertLazyDataset(aLazyIndices);
					bIndices = DatasetUtils.sliceAndConvertLazyDataset(bLazyIndices);
					datasetLoaded = true;
				}
				catch (DatasetException e)
				{
					throw new IllegalArgumentException("Axis values not present");
				}

				if (datasetLoaded)
				{
					final boolean needInterp;

					// inspect the data to see if it needs to be
					// interpolated
					if (aIndices.getSize() != bIndices.getSize())
					{
						// ok, they're different sizes, they need syncing
						needInterp = true;
					}
					else if (aIndices.equals(bIndices))
					{
						// ok, they're equal, no need to interp
						needInterp = false;
					}
					else
					{
						// indices don't match, need to interp
						needInterp = true;
					}

					if (needInterp)
					{
						// ok, we need to use interpolation. But, first we
						// need to check if the axes are suitable for interpolation.
						final Monotonicity aMono = Comparisons.findMonotonicity(aIndices);
						final Monotonicity bMono = Comparisons.findMonotonicity(bIndices);

						if (aMono.equals(Monotonicity.NOT_ORDERED)
								|| bMono.equals(Monotonicity.NOT_ORDERED))
						{
							throw new IllegalArgumentException(AXES_MUST_BE_MONOTONIC);
						}
						else if (aMono.equals(Monotonicity.NONDECREASING)
								|| bMono.equals(Monotonicity.NONDECREASING))
						{
							throw new IllegalArgumentException(
									DUPLICATE_INDEX_VALUES_NOT_ALLOWED);
						}
						else
						{
							// check they're in the same direction
							if (aMono != bMono)
							{
								throw new IllegalArgumentException(
										AXES_MUST_ASCEND_IN_SAME_DIRECTION);
							}

							// ok, they're both monotonic, in the same direction. we can continue.
						}

						// find the data limits
						final double aMin = aIndices.min().doubleValue();
						final double aMax = aIndices.max().doubleValue();
						final double bMin = bIndices.min().doubleValue();
						final double bMax = bIndices.max().doubleValue();

						if (aMax < bMin || aMin > bMax)
						{
							// datasets don't overlap
							throw new IllegalArgumentException(INDICES_DO_NOT_OVERLAP);
						}
						else if (aMin <= bMin && aMax >= bMax)
						{
							// ok, b is wholly contained within A. Just generate
							// points in A at the time in B
							final Dataset interpolatedValues =
									Maths.interpolate(aIndices, da, bIndices, null, null);
							// remember the output axes, since we'll put them
							// into the results
							interpolatedValues.addMetadata(axesB);

							operandA = db;
							operandB = interpolatedValues;
						}
						else if (bMin < aMin && bMax > aMax)
						{
							// ok, A is wholly contained within B. Just generate
							// points in B at the time in A
							final Dataset interpolatedValues =
									Maths.interpolate(bIndices, db, aIndices, null, null);
							// remember the output axes, since we'll put them
							// into the results
							interpolatedValues.addMetadata(axesA);

							operandA = da;
							operandB = interpolatedValues;
						}
						else
						{
							// ok, one isn't contained within the other,
							// they merely overlap. Find the overlapping period
							final double startPoint = aMin < bMin ? bMin : aMin;
							final double endPoint = aMax > bMax ? bMax : aMax;

							// to find the last matching entry, we have to work through
							// the dataset in reverse.
							final Dataset aReverse = aIndices.getSlice(null, null, new int[]
							{-1});
							final Dataset bReverse = bIndices.getSlice(null, null, new int[]
							{-1});

							// now get the two slices in this period
							final int aStart;
							final int aEnd;
							final int bStart;
							final int bEnd;
							if (aMono == Monotonicity.STRICTLY_INCREASING)
							{
								// ok - data ascending
								aStart =
										DatasetUtils.findIndexGreaterThanOrEqualTo(aIndices,
												startPoint);
								// note: we reduce index by one to allow for zero-indexing
								aEnd =
										aReverse.getSize()
												- 1
												- DatasetUtils.findIndexLessThanOrEqualTo(aReverse,
														endPoint);
								bStart =
										DatasetUtils.findIndexGreaterThanOrEqualTo(bIndices,
												startPoint);
								bEnd =
										bReverse.getSize()
												- 1
												- DatasetUtils.findIndexLessThanOrEqualTo(bReverse,
														endPoint);
							}
							else
							{
								// ok - data descending
								aStart =
										DatasetUtils.findIndexLessThanOrEqualTo(aIndices, endPoint);
								// note: we reduce index by one to allow for zero-indexing
								aEnd =
										aReverse.getSize()
												- 1
												- DatasetUtils.findIndexGreaterThanOrEqualTo(aReverse,
														startPoint);
								bStart =
										DatasetUtils.findIndexLessThanOrEqualTo(bIndices, endPoint);
								bEnd =
										bReverse.getSize()
												- 1
												- DatasetUtils.findIndexGreaterThanOrEqualTo(bReverse,
														startPoint);
							}

							// ok, retrieve the index values that are within the intersecting period
							final Dataset aIndicesTrimmed = aIndices.getSlice(new int[]
							{aStart}, new int[]
							{aEnd + 1}, null);
							final Dataset bIndicesTrimmed = bIndices.getSlice(new int[]
							{bStart}, new int[]
							{bEnd + 1}, null);

							// the interpolation strategy we're going to adopt is that we're
							// going to use the index values from the dataset that has
							// the most measurements in the intersecting range.
							if (aIndicesTrimmed.getSize() > bIndicesTrimmed.getSize())
							{
								// aTimes has more samples, use it for interpolation
								final Dataset interpolatedValues =
										Maths
												.interpolate(bIndices, db, aIndicesTrimmed, null, null);

								// we can just extract the trimmed set of a values
								final Dataset aValues = da.getSlice(new int[]
								{aStart}, new int[]
								{aEnd + 1}, null);

								// clear the metadata from this, since we'll change the axis length
								aValues.clearMetadata(AxesMetadata.class);

								// remember the output axes, since we'll put them
								// into the results
								AxesMetadata newAxis = new AxesMetadataImpl();
								newAxis.initialize(1);
								newAxis.setAxis(0, aIndicesTrimmed);
								interpolatedValues.addMetadata(newAxis);
								aValues.addMetadata(newAxis);

								operandA = aValues;
								operandB = interpolatedValues;
							}
							else
							{
								// bTimes has more samples (or they're equal), use it for interpolation
								final Dataset interpolatedValues =
										Maths
												.interpolate(aIndices, da, bIndicesTrimmed, null, null);

								// we can just extract the trimmed set of b values
								final Dataset bValues = db.getSlice(new int[]
								{bStart}, new int[]
								{bEnd + 1}, null);

								// clear the metadata from this, since we'll change the axis length
								bValues.clearMetadata(AxesMetadata.class);

								// remember the output axes, since we'll put them
								// into the results
								AxesMetadata newAxis = new AxesMetadataImpl();
								newAxis.initialize(1);
								newAxis.setAxis(0, bIndicesTrimmed);
								interpolatedValues.addMetadata(newAxis);
								bValues.addMetadata(newAxis);

								operandA = bValues;
								operandB = interpolatedValues;
							}
						}
					}
					else
					{
						// an exception was thrown while trying to determine
						// the
						// indices. See if the parent class can handle it
						operandA = da;
						operandB = db;
					}
				}
				else
				{
					// no interpolation needed
					operandA = da;
					operandB = db;
				}
			}

			// perform the basic operation
			final Dataset res = operation.perform(operandA, operandB, o);

			// ok, inject the axes back into the result, if we can
			if (operandA instanceof IDataset)
			{
				final IDataset ds = (IDataset) operandA;
				final AxesMetadata targetAxes = ds.getFirstMetadata(AxesMetadata.class);
				if (targetAxes != null)
				{
					res.addMetadata(targetAxes);
				}
			}

			return res;
		}
	}

	@Before
	public void before()
	{
		// prevent missing logger from being reported
		Utils.suppressSLF4JError();
	}

	@Test
	public void testAxisReverseInterpolation()
	{
		// configure Dataset A
		final Dataset elevationA_m =
				DatasetFactory
						.createFromList(Arrays.asList(150d, 125d, 100d, 75d, 50d));
		elevationA_m.setName("A elevation (m)");
		Dataset temperatureA_C =
				DatasetFactory.createFromList(Arrays.asList(5d, 10d, 15d, 20d, 25d));
		final AxesMetadata axesMetadataA = new AxesMetadataImpl();
		axesMetadataA.initialize(1);
		axesMetadataA.setAxis(0, elevationA_m);
		temperatureA_C.addMetadata(axesMetadataA);
		temperatureA_C.setName("A temperature (deg C)");

		// configure Dataset B
		final Dataset elevationB_m =
				DatasetFactory
						.createFromList(Arrays.asList(130d, 125d, 100d, 70d, 40d));
		elevationB_m.setName("B elevation (m)");
		final Dataset temperatureB_C =
				DatasetFactory.createFromList(Arrays
						.asList(15d, 17.5d, 20d, 22.5d, 25d));
		final AxesMetadata axesMetadataB = new AxesMetadataImpl();
		axesMetadataB.initialize(1);
		axesMetadataB.setAxis(0, elevationB_m);
		temperatureB_C.addMetadata(axesMetadataB);
		temperatureB_C.setName("B temperature (deg C)");

		// wrap mathematical operation
		final IOperationPerformer doAdd = new IOperationPerformer()
		{
			@Override
			public Dataset perform(Dataset a, Dataset b, Dataset o)
			{
				return Maths.add(a, b, o).idivide(2d);
			}
		};
		final Dataset meanTemperature =
				NewMaths.performWithInterpolation(temperatureA_C, temperatureB_C, null,
						doAdd);
		assertNotNull(meanTemperature);
		meanTemperature.setName("Interpolated sum of dataset A and dataset B");

		// check that the resulting dataset has the correctly intersecting times
		printIndexedDataset(temperatureA_C);
		printIndexedDataset(temperatureB_C);
		Dataset interElevations =
				(Dataset) meanTemperature.getFirstMetadata(AxesMetadata.class).getAxis(
						0)[0];
		assertEquals("first elevation correct", 130d, interElevations.getDouble(0),
				0.001);
		assertEquals("last elevation correct", 70d, interElevations
				.getDouble(interElevations.getSize() - 1), 0.001);

		printIndexedDataset(meanTemperature);
	}

	@Test
	public void testAxisInterpolationTesting()
	{
		// configure Dataset A
		final Dataset elevationA_m =
				DatasetFactory
						.createFromList(Arrays.asList(50d, 75d, 100d, 125d, 150d));
		elevationA_m.setName("A elevation (m)");
		Dataset temperatureA_C =
				DatasetFactory.createFromList(Arrays.asList(5d, 10d, 15d, 20d, 25d));
		final AxesMetadata axesMetadataA = new AxesMetadataImpl();
		axesMetadataA.initialize(1);
		axesMetadataA.setAxis(0, elevationA_m);
		temperatureA_C.addMetadata(axesMetadataA);
		temperatureA_C.setName("A temperature (deg C)");

		// configure Dataset B
		final Dataset elevationB_m =
				DatasetFactory
						.createFromList(Arrays.asList(50d, 75d, 100d, 125d, 100d));
		elevationB_m.setName("B elevation (m)");
		final Dataset temperatureB_C =
				DatasetFactory.createFromList(Arrays
						.asList(15d, 17.5d, 20d, 22.5d, 25d));
		final AxesMetadata axesMetadataB = new AxesMetadataImpl();
		axesMetadataB.initialize(1);
		axesMetadataB.setAxis(0, elevationB_m);
		temperatureB_C.addMetadata(axesMetadataB);
		temperatureB_C
				.setName("B temperature (deg C), with elevations (t = e / 10 + 10)");

		// show initial values
		printIndexedDataset(temperatureA_C);
		printIndexedDataset(temperatureB_C);

		// wrap mathematical operation
		final IOperationPerformer doAdd = new IOperationPerformer()
		{
			@Override
			public Dataset perform(Dataset a, Dataset b, Dataset o)
			{
				return Maths.add(a, b, o).idivide(2d);
			}
		};

		try
		{
			@SuppressWarnings("unused")
			final Dataset meanTemperature =
					NewMaths.performWithInterpolation(temperatureA_C, temperatureB_C,
							null, doAdd);
			fail("an exception should have been thrown");
		}
		catch (IllegalArgumentException ee)
		{
			assertEquals("correct message", NewMaths.AXES_MUST_BE_MONOTONIC, ee
					.getMessage());
		}

		// configure Dataset C
		final Dataset elevationC_m =
				DatasetFactory
						.createFromList(Arrays.asList(150d, 124d, 100d, 85d, 60d));
		elevationC_m.setName("C elevation (m)");
		final Dataset temperatureC_C =
				DatasetFactory.createFromList(Arrays
						.asList(15d, 17.5d, 20d, 22.5d, 25d));
		final AxesMetadata axesMetadataC = new AxesMetadataImpl();
		axesMetadataC.initialize(1);
		axesMetadataC.setAxis(0, elevationC_m);
		temperatureC_C.addMetadata(axesMetadataC);
		temperatureC_C.setName("C temperature (deg C)");

		try
		{
			@SuppressWarnings("unused")
			final Dataset meanTemperature =
					NewMaths.performWithInterpolation(temperatureA_C, temperatureC_C,
							null, doAdd);
			fail("an exception should have been thrown");
		}
		catch (IllegalArgumentException ee)
		{
			assertEquals("correct message",
					NewMaths.AXES_MUST_ASCEND_IN_SAME_DIRECTION, ee.getMessage());
		}

		// configure Dataset D
		final Dataset elevationD_m =
				DatasetFactory.createFromList(Arrays.asList(60d, 75d, 75d, 100d, 175d));
		elevationD_m.setName("D elevation (m)");
		final Dataset temperatureD_C =
				DatasetFactory.createFromList(Arrays
						.asList(15d, 17.5d, 20d, 22.5d, 25d));
		final AxesMetadata axesMetadataD = new AxesMetadataImpl();
		axesMetadataD.initialize(1);
		axesMetadataD.setAxis(0, elevationD_m);
		temperatureD_C.addMetadata(axesMetadataD);
		temperatureD_C.setName("D temperature (deg C)");

		try
		{
			@SuppressWarnings("unused")
			final Dataset meanTemperature =
					NewMaths.performWithInterpolation(temperatureA_C, temperatureD_C,
							null, doAdd);
			fail("an exception should have been thrown");
		}
		catch (IllegalArgumentException ee)
		{
			assertEquals("correct message",
					NewMaths.DUPLICATE_INDEX_VALUES_NOT_ALLOWED, ee.getMessage());
		}

		// configure Dataset E
		final Dataset elevationE_m =
				DatasetFactory.createFromList(Arrays.asList(60d, 75d, 80d, 100d, 175d));
		elevationE_m.setName("E elevation (m)");
		final Dataset temperatureE_C =
				DatasetFactory.createFromList(Arrays
						.asList(15d, 17.5d, 20d, 22.5d, 25d));
		final AxesMetadata axesMetadataE = new AxesMetadataImpl();
		axesMetadataE.initialize(1);
		axesMetadataE.setAxis(0, elevationE_m);
		temperatureE_C.addMetadata(axesMetadataE);
		temperatureE_C.setName("E temperature (deg C)");

		final Dataset meanTemperature =
				NewMaths.performWithInterpolation(temperatureA_C, temperatureE_C, null,
						doAdd);
		assertNotNull(meanTemperature);
		meanTemperature.setName("Interpolated sum of dataset A and dataset B");

		// check that the resulting dataset has the correctly intersecting times
		printIndexedDataset((Dataset) temperatureA_C.getFirstMetadata(
				AxesMetadata.class).getAxes()[0]);
		printIndexedDataset((Dataset) temperatureE_C.getFirstMetadata(
				AxesMetadata.class).getAxes()[0]);
		Dataset interElevations =
				(Dataset) meanTemperature.getFirstMetadata(AxesMetadata.class).getAxis(
						0)[0];
		assertEquals("first elevation correct", 60d, interElevations.getDouble(0),
				0.001);
		assertEquals("last elevation correct", 100d, interElevations
				.getDouble(interElevations.getSize() - 1), 0.001);

		printIndexedDataset(meanTemperature);

	}

	/**
	 * test we interpolate data when one set of axis measurements spans the region covered by the
	 * other
	 */
	@Test
	public void testNonSyncedContainedAxesOperation()
	{
		// configure Dataset A
		final Dataset elevationA_m =
				DatasetFactory.createFromList(Arrays.asList(50d, 100d, 150d));
		elevationA_m.setName("A elevation (m)");
		Dataset temperatureA_C =
				DatasetFactory.createFromList(Arrays.asList(5d, 10d, 15d));
		final AxesMetadata axesMetadataA = new AxesMetadataImpl();
		axesMetadataA.initialize(1);
		axesMetadataA.setAxis(0, elevationA_m);
		temperatureA_C.addMetadata(axesMetadataA);
		temperatureA_C
				.setName("A temperature (deg C), with elevations (t = e / 10)");

		// configure Dataset B
		final Dataset elevationB_m =
				DatasetFactory
						.createFromList(Arrays.asList(50d, 75d, 100d, 125d, 150d));
		elevationB_m.setName("B elevation (m)");
		final Dataset temperatureB_C =
				DatasetFactory.createFromList(Arrays
						.asList(15d, 17.5d, 20d, 22.5d, 25d));
		final AxesMetadata axesMetadataB = new AxesMetadataImpl();
		axesMetadataB.initialize(1);
		axesMetadataB.setAxis(0, elevationB_m);
		temperatureB_C.addMetadata(axesMetadataB);
		temperatureB_C
				.setName("B temperature (deg C), with elevations (t = e / 10 + 10)");

		// show initial values
		printIndexedDataset(temperatureA_C);
		printIndexedDataset(temperatureB_C);

		// wrap mathematical operation
		final IOperationPerformer doAdd = new IOperationPerformer()
		{
			@Override
			public Dataset perform(Dataset a, Dataset b, Dataset o)
			{
				return Maths.add(a, b, o).idivide(2d);
			}
		};

		// apply our operation to the two datasets
		final Dataset meanTemperature =
				NewMaths.performWithInterpolation(temperatureA_C, temperatureB_C, null,
						doAdd);
		meanTemperature
				.setName("Mean of A and B, taken at B elevations (should be t = e / 10 + 5)");

		printIndexedDataset(meanTemperature);

		final AxesMetadata elevations =
				meanTemperature.getFirstMetadata(AxesMetadata.class);
		assertNotNull("elevations present in results", elevations);
		assertEquals("correct elevations", elevationB_m, elevations.getAxis(0)[0]);

		// check results, via sampling
		assertEquals("correct value", 12.5d, meanTemperature.getDouble(1), 0.001); // mean temp at 75m
		assertEquals("correct value", 17.5d, meanTemperature.getDouble(3), 0.001); // mean temp at 125m

	}

	/**
	 * test we interpolate data when the two sets of axis measurements overlap
	 */
	@Test
	public void testNonSyncedOverlappingAxesOperation()
	{
		// configure Dataset A
		final Dataset elevationA_m =
				DatasetFactory.createFromList(Arrays.asList(50d, 100d, 150d));
		elevationA_m.setName("A elevation (m)");
		Dataset temperatureA_C =
				DatasetFactory.createFromList(Arrays.asList(5d, 10d, 15d));
		final AxesMetadata axesMetadataA = new AxesMetadataImpl();
		axesMetadataA.initialize(1);
		axesMetadataA.setAxis(0, elevationA_m);
		temperatureA_C.addMetadata(axesMetadataA);
		temperatureA_C
				.setName("A temperature (deg C), with elevations (t = e / 10)");

		// configure Dataset B
		final Dataset elevationB_m =
				DatasetFactory
						.createFromList(Arrays.asList(40d, 75d, 100d, 125d, 140d));
		elevationB_m.setName("B elevation (m)");
		final Dataset temperatureB_C =
				DatasetFactory.createFromList(Arrays
						.asList(14d, 17.5d, 20d, 22.5d, 24d));
		final AxesMetadata axesMetadataB = new AxesMetadataImpl();
		axesMetadataB.initialize(1);
		axesMetadataB.setAxis(0, elevationB_m);
		temperatureB_C.addMetadata(axesMetadataB);
		temperatureB_C
				.setName("B temperature (deg C), with elevations (t = e / 10 + 10)");

		// show initial values
		printIndexedDataset(temperatureA_C);
		printIndexedDataset(temperatureB_C);

		// wrap mathematical operation
		final IOperationPerformer doAdd = new IOperationPerformer()
		{
			@Override
			public Dataset perform(Dataset a, Dataset b, Dataset o)
			{
				return Maths.add(a, b, o).idivide(2d);
			}
		};

		// apply our operation to the two datasets
		final Dataset meanTemperature =
				NewMaths.performWithInterpolation(temperatureA_C, temperatureB_C, null,
						doAdd);
		meanTemperature
				.setName("Mean of A and B, taken at intersecting elevations (should be t = e / 10 + 5)");

		printIndexedDataset(meanTemperature);

		final AxesMetadata elevations =
				meanTemperature.getFirstMetadata(AxesMetadata.class);
		assertNotNull("elevations present in results", elevations);
		assertEquals("correct elevations", 4, elevations.getAxis(0)[0].getSize());

		// check results, via sampling
		assertEquals("correct value", 12.5, meanTemperature.getDouble(0), 0.001); // mean temp at 75m
		assertEquals("correct value", 17.5, meanTemperature.getDouble(2), 0.001); // mean temp at 125m
		assertEquals("correct value", 19.0, meanTemperature.getDouble(3), 0.001); // mean temp at 140m

	}

	private static void printIndexedDataset(Dataset dataset)
	{
		final AxesMetadata axesMetadata =
				dataset.getFirstMetadata(AxesMetadata.class);
		final IndexIterator iterator = dataset.getIterator();

		final DoubleDataset axisDataset;
		if (axesMetadata != null && axesMetadata.getAxes().length > 0)
		{
			DoubleDataset doubleAxis = null;
			try
			{
				ILazyDataset rawAxis = axesMetadata.getAxes()[0];
				Dataset axis = DatasetUtils.sliceAndConvertLazyDataset(rawAxis);
				doubleAxis = DatasetUtils.cast(DoubleDataset.class, axis);
			}
			catch (DatasetException e)
			{
				e.printStackTrace();
			}
			axisDataset = doubleAxis != null ? doubleAxis : null;
		}
		else
		{
			axisDataset = null;
		}

		System.out.println(dataset.getName() + ":");
		while (iterator.hasNext())
		{
			final String indexVal;
			if (axisDataset != null)
			{
				indexVal = "" + axisDataset.getElementDoubleAbs(iterator.index) + " : ";
			}
			else
			{
				indexVal = "";
			}

			System.out.print(indexVal + dataset.getElementDoubleAbs(iterator.index));
			System.out.print(", ");
		}
		System.out.println();
	}

}
