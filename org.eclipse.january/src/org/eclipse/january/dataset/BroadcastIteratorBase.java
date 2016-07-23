/*-
 * Copyright 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

/**
 * Base class for all broadcast iterators. For speed, there are public members. Note, index is not updated
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
	 * Current value in second dataset
	 */
	public double bDouble;
	/**
	 * Current value in second dataset
	 */
	public long bLong;

	protected boolean asDouble = true;
	protected boolean read = true;

	protected int[] maxShape;

	/**
	 * position in dataset
	 */
	protected int[] pos;

	protected Dataset aDataset;
	protected Dataset bDataset;

	public BroadcastIteratorBase(Dataset a, Dataset b) {
		aDataset = a;
		bDataset = b;
	}

	@Override
	public int[] getShape() {
		return maxShape;
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
