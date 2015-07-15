/*-
 * Copyright 2015 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.dataset.impl;

/**
 * Base class for broadcast iterators. For speed, there are public members
 */
public abstract class BroadcastIteratorBase extends IndexIterator {

	/**
	 * Index in first dataset
	 */
	public int aIndex;
	/**
	 * Index in second dataset
	 */
	public int bIndex;
	/**
	 * Index in output dataset
	 */
	public int oIndex;
	/**
	 * Current value in first dataset
	 */
	public double aDouble;
	/**
	 * Current value in second dataset
	 */
	public double bDouble;
	/**
	 * Current value in first dataset
	 */
	public long aLong;
	/**
	 * Current value in second dataset
	 */
	public long bLong;

	protected boolean asDouble = true;

	/**
	 * position in dataset
	 */
	protected int[] pos;

	/**
	 * Output dataset
	 */
	protected Dataset oDataset;

	BroadcastIteratorBase() {
	}

	/**
	 * @return output dataset (can be null)
	 */
	public Dataset getOutput() {
		return oDataset;
	}

	@Override
	public int[] getPos() {
		return pos;
	}

	/**
	 * @return true if output from iterator is double
	 */
	public boolean isOutputDouble() {
		return asDouble;
	}

	/**
	 * Set to output doubles
	 * @param asDouble
	 */
	public void setOutputDouble(boolean asDouble) {
		if (this.asDouble != asDouble) {
			this.asDouble = asDouble;
			storeCurrentValues();
		}
	}

	/**
	 * Read and store current values
	 */
	abstract protected void storeCurrentValues();

}