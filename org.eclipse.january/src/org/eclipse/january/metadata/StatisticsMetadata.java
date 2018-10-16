/*-
 *******************************************************************************
 * Copyright (c) 2017 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Peter Chang - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.january.metadata;

import java.util.List;

import org.eclipse.january.dataset.Dataset;

/**
 * Store standard statistics
 * @param <T> is either a Number or a double array
 * @since 2.0
 */
public interface StatisticsMetadata<T> extends MetadataType {

	/**
	 *
	 * @param dataset
	 */
	public void initialize(Dataset dataset);

	/**
	 * Call to indicate dataset has been modified so statistics are not up-to-date
	 */
	public void setDirty();

	/**
	 * @return true if dataset has been modified
	 */
	public boolean isDirty();

	/**
	 * @return true if dataset has been modified
	 * @since 2.2
	 */
	public boolean isDirty(Dataset dataset);

	/**
	 * @param hash the hash to set
	 */
	public void setHash(int hash);

	/**
	 * @param shape
	 * @return the hash
	 */
	public int getHash(int[] shape);

	/**
	 * @param ignoreInvalids - Can be null, one boolean, or two booleans. By default, both are false. If
	 * the first boolean is true, will ignore NaNs and ignore infinities. Use the second boolean to
	 * ignore infinities separately.
	 * @return the maximum
	 */
	public T getMaximum(boolean... ignoreInvalids);

	/**
	 * @param maximum the maximum to set
	 * @param minimum the minimum to set
	 * @param ignoreInvalids @see {@link #getMaximum(boolean...)} for explanation
	 */
	@Deprecated
	public void setMaximumMinimum(T maximum, T minimum, boolean... ignoreInvalids);

	/**
	 * @param maximum the maximum to set
	 * @param minimum the minimum to set
	 * @param sum the sum to set
	 * @param ignoreInvalids @see {@link #getMaximum(boolean...)} for explanation
	 * @since 2.1
	 */
	public void setMaximumMinimumSum(T maximum, T minimum, T sum, boolean... ignoreInvalids);

	/**
	 * @param maximumPositions the maximum positions to set
	 * @param ignoreInvalids @see {@link #getMaximum(boolean...)} for explanation
	 */
	public void setMaximumPositions(List<int[]> maximumPositions, boolean... ignoreInvalids);

	/**
	 * @param minimumPositions the minimum positions to set
	 * @param ignoreInvalids @see {@link #getMaximum(boolean...)} for explanation
	 */
	public void setMinimumPositions(List<int[]> minimumPositions, boolean... ignoreInvalids);

	/**
	 * @param ignoreInvalids @see {@link #getMaximum(boolean...)} for explanation
	 * @return the maximum positions
	 */
	public List<int[]> getMaximumPositions(boolean... ignoreInvalids);

	/**
	 * @param ignoreInvalids @see {@link #getMaximum(boolean...)} for explanation
	 * @return the minimum
	 */
	public T getMinimum(boolean... ignoreInvalids);

	/**
	 * @param ignoreInvalids @see {@link #getMaximum(boolean...)} for explanation
	 * @return the minimum positions
	 */
	public List<int[]> getMinimumPositions(boolean... ignoreInvalids);

	/**
	 * @param ignoreInvalids @see {@link #getMaximum(boolean...)} for explanation
	 * @return the number of samples
	 */
	public long getCount(boolean... ignoreInvalids);

	/**
	 * @param ignoreInvalids @see {@link #getMaximum(boolean...)} for explanation
	 * @return the mean of samples
	 */
	public T getMean(boolean... ignoreInvalids);

	/**
	 * @param ignoreInvalids @see {@link #getMaximum(boolean...)} for explanation
	 * @return the sum of samples
	 */
	public T getSum(boolean... ignoreInvalids);

	/**
	 * @param isWholePopulation
	 * @param ignoreInvalids @see {@link #getMaximum(boolean...)} for explanation
	 * @return the variance of samples
	 */
	public double getVariance(boolean isWholePopulation, boolean... ignoreInvalids);

	/**
	 * @param axis
	 * @param ignoreInvalids @see {@link #getMaximum(boolean...)} for explanation
	 * @return the argument at which the maximum first occurs
	 */
	public Dataset getArgMaximum(int axis, boolean... ignoreInvalids);

	/**
	 * @param axis
	 * @param ignoreInvalids @see {@link #getMaximum(boolean...)} for explanation
	 * @return the argument at which the minimum first occurs
	 */
	public Dataset getArgMinimum(int axis, boolean... ignoreInvalids);

	/**
	 * @param axis
	 * @param ignoreInvalids - Can be null, one boolean, or two booleans. By default, both are false. If
	 * the first boolean is true, will ignore NaNs and ignore infinities. Use the second boolean to
	 * ignore infinities separately.
	 * @return the maximum
	 */
	public Dataset getMaximum(int axis, boolean... ignoreInvalids);

	/**
	 * @param axis
	 * @param ignoreInvalids @see {@link #getMaximum(boolean...)} for explanation
	 * @return the minimum
	 */
	public Dataset getMinimum(int axis, boolean... ignoreInvalids);

	/**
	 * @param axis
	 * @param ignoreInvalids @see {@link #getMaximum(boolean...)} for explanation
	 * @return the number of samples
	 */
	public Dataset getCount(int axis, boolean... ignoreInvalids);

	/**
	 * @param axis
	 * @param ignoreInvalids @see {@link #getMaximum(boolean...)} for explanation
	 * @return the mean of samples
	 */
	public Dataset getMean(int axis, boolean... ignoreInvalids);

	/**
	 * @param axis
	 * @param ignoreInvalids @see {@link #getMaximum(boolean...)} for explanation
	 * @return the sum of samples
	 */
	public Dataset getSum(int axis, boolean... ignoreInvalids);

	/**
	 * @param axis
	 * @param isWholePopulation
	 * @param ignoreInvalids @see {@link #getMaximum(boolean...)} for explanation
	 * @return the variance of samples
	 */
	public Dataset getVariance(int axis, boolean isWholePopulation, boolean... ignoreInvalids);

	/**
	 * @param axes
	 * @param ignoreInvalids - Can be null, one boolean, or two booleans. By default, both are false. If
	 * the first boolean is true, will ignore NaNs and ignore infinities. Use the second boolean to
	 * ignore infinities separately.
	 * @return the maximum
	 * @since 2.2
	 */
	public Dataset getMaximum(int[] axes, boolean... ignoreInvalids);

	/**
	 * @param axes
	 * @param ignoreInvalids @see {@link #getMaximum(boolean...)} for explanation
	 * @return the minimum
	 * @since 2.2
	 */
	public Dataset getMinimum(int[] axes, boolean... ignoreInvalids);

	/**
	 * @param axes
	 * @param ignoreInvalids @see {@link #getMaximum(boolean...)} for explanation
	 * @return the number of samples
	 * @since 2.2
	 */
	public Dataset getCount(int[] axes, boolean... ignoreInvalids);

	/**
	 * @param axes
	 * @param ignoreInvalids @see {@link #getMaximum(boolean...)} for explanation
	 * @return the mean of samples
	 * @since 2.2
	 */
	public Dataset getMean(int[] axes, boolean... ignoreInvalids);

	/**
	 * @param axes
	 * @param ignoreInvalids @see {@link #getMaximum(boolean...)} for explanation
	 * @return the sum of samples
	 * @since 2.2
	 */
	public Dataset getSum(int[] axes, boolean... ignoreInvalids);

	/**
	 * @param axes
	 * @param isWholePopulation
	 * @param ignoreInvalids @see {@link #getMaximum(boolean...)} for explanation
	 * @return the variance of samples
	 * @since 2.2
	 */
	public Dataset getVariance(int[] axes, boolean isWholePopulation, boolean... ignoreInvalids);
}
