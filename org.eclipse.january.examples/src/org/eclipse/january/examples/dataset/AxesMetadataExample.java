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

import java.util.Arrays;

import org.eclipse.january.DatasetException;
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
		public Dataset perform(final Object a, final Object b, final Dataset o);
	}

	/**
	 * experiment with extending maths processing to be AxesMetadata aware
	 * 
	 * @author ian
	 *
	 */
	private static class NewMaths extends Maths
	{
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
		public static Dataset performWithInterpolation(final Object a,
				final Object b, final Dataset o, final IOperationPerformer operation)
		{
			final Object operandA;
			final Object operandB;

			// ok, check if we've received datasets
			if (a instanceof Dataset && b instanceof Dataset)
			{
				final Dataset da = (Dataset) a;
				final Dataset db = (Dataset) b;
				final AxesMetadata axesA = da.getFirstMetadata(AxesMetadata.class);
				final AxesMetadata axesB = db.getFirstMetadata(AxesMetadata.class);

				if (axesA != null && axesB != null)
				{
					// ok, we've got indexed data. see if they match
					final ILazyDataset aLazyIndices = axesA.getAxis(0)[0];
					final ILazyDataset bLazyIndices = axesB.getAxis(0)[0];

					// first we need to load the datasets in order to compare them
					Dataset aIndices = null;
					Dataset bIndices = null;
					boolean success = false;
					try
					{
						aIndices = DatasetUtils.sliceAndConvertLazyDataset(aLazyIndices);
						bIndices = DatasetUtils.sliceAndConvertLazyDataset(bLazyIndices);
						success = true;
					}
					catch (DatasetException e)
					{
						e.printStackTrace();
					}

					if (success)
					{
						// ok, if they're different length then we know they're non-synced
						final boolean needInterp;
						if (aIndices.getSize() != bIndices.getSize())
						{
							// ok, need syncing
							needInterp = true;
						}
						else if (aIndices.equals(bIndices))
						{
							// ok, they're equal, no need to interp
							needInterp = false;
						}
						else
						{
							// values don't match, need to interp
							needInterp = true;
						}

						if (needInterp)
						{
							// we now need to decide which set of indices to use as the master
							final boolean useAforIndexMaster;

							// find the data limits
							final double aMin = aIndices.min().doubleValue();
							final double aMax = aIndices.max().doubleValue();

							final double bMin = bIndices.min().doubleValue();
							final double bMax = bIndices.max().doubleValue();

							if (aMax < bMin || aMin > bMax)
							{
								// datasets don't overlap
								throw new IllegalArgumentException(
										"The indices of the dataset do not overlap");
							}
							else if (aMin <= bMin && aMax >= bMax)
							{
								// ok, use b, since it fits within a
								useAforIndexMaster = false;
							}
							else if (bMin < aMin && bMax > aMax)
							{
								// ok, use a, since it fits within b
								useAforIndexMaster = true;
							}
							else if (aIndices.getSize() > bIndices.getSize())
							{
								// ok, one isn't contained within the other, they merely overlap. Sort out which to
								// use initially, take the longer dataset. In the future use the one with the most
								// measurements in the overlapping period (slice() operations may help with this)

								// ok, use a - it's the most frequent
								useAforIndexMaster = true;
							}
							else
							{
								// ok, use b - it's the most frequent
								useAforIndexMaster = false;
							}

							// ok, decide which way around things are
							final Dataset indices = useAforIndexMaster ? bIndices : aIndices;
							final Dataset values = useAforIndexMaster ? db : da;
							final IDataset masterIndices = useAforIndexMaster ? aIndices
									: bIndices;
							final IDataset masterValues = useAforIndexMaster ? da : db;

							// ok, now do interpolation
							final Dataset interpolatedValues = Maths.interpolate(indices,
									values, masterIndices, null, null);
							operandA = masterValues;
							operandB = interpolatedValues;

							// remember the output axes, since we'll put them into the results
							interpolatedValues.addMetadata(useAforIndexMaster ? axesA
									: axesB);
						}
						else
						{
							// an exception was thrown while trying to determine the
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
				else
				{
					// we don't know the axes, so forget about syncing
					operandA = da;
					operandB = db;
				}
			}
			else
			{
				// we can only handle datasets, leave them to it.
				operandA = a;
				operandB = b;
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
	public void testNonSyncedAxesOperationInNewMaths()
	{
		// configure Dataset A
		final Dataset elevationA_m = DatasetFactory.createFromList(Arrays.asList(
				50d, 100d, 150d));
		elevationA_m.setName("A elevation (m)");
		Dataset temperatureA_C = DatasetFactory.createFromList(Arrays.asList(5d,
				10d, 15d));
		final AxesMetadata axesMetadataA = new AxesMetadataImpl();
		axesMetadataA.initialize(1);
		axesMetadataA.setAxis(0, elevationA_m);
		temperatureA_C.addMetadata(axesMetadataA);
		temperatureA_C.setName(
				"A temperature (deg C), with elevations (t = e / 10)");

		// configure Dataset B
		final Dataset elevationB_m = DatasetFactory.createFromList(Arrays.asList(
				50d, 75d, 100d, 125d, 150d));
		elevationB_m.setName("B elevation (m)");
		final Dataset temperatureB_C = DatasetFactory.createFromList(Arrays.asList(
				15d, 17.5d, 20d, 22.5d, 25d));
		final AxesMetadata axesMetadataB = new AxesMetadataImpl();
		axesMetadataB.initialize(1);
		axesMetadataB.setAxis(0, elevationB_m);
		temperatureB_C.addMetadata(axesMetadataB);
		temperatureB_C.setName(
				"B temperature (deg C), with elevations (t = e / 10 + 10)");

		// show initial values
		printIndexedDataset(temperatureA_C);
		printIndexedDataset(temperatureB_C);

		// wrap mathematical operation
		final IOperationPerformer doAdd = new IOperationPerformer()
		{
			@Override
			public Dataset perform(Object a, Object b, Dataset o)
			{
				return Maths.add(a, b, o).idivide(2d);
			}
		};

		// apply our operation to the two datasets
		final Dataset meanTemperature = NewMaths.performWithInterpolation(
				temperatureA_C, temperatureB_C, null, doAdd);
		meanTemperature.setName(
				"Mean of A and B, taken at B elevations (should be t = e / 10 + 5)");

		printIndexedDataset(meanTemperature);
		Utils.print(meanTemperature);

		final AxesMetadata elevations = meanTemperature.getFirstMetadata(
				AxesMetadata.class);
		assertNotNull("elevations present in results", elevations);
		assertEquals("correct elevations", elevationB_m, elevations.getAxis(0)[0]);

		// check results, via sampling
		assertEquals("correct value", 12.5d, meanTemperature.getDouble(1), 0.001); // mean temp at 75m
		assertEquals("correct value", 17.5d, meanTemperature.getDouble(3), 0.001); // mean temp at 125m

	}

	private static void printIndexedDataset(Dataset dataset)
	{
		final AxesMetadata axesMetadata = dataset.getFirstMetadata(
				AxesMetadata.class);
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
				indexVal = "" + axisDataset.getElementDoubleAbs(iterator.index);
			}
			else
			{
				indexVal = "N/A";
			}

			System.out.print(indexVal + " : " + dataset.getElementDoubleAbs(
					iterator.index));
			System.out.print("; ");
		}
		System.out.println();
	}

}
