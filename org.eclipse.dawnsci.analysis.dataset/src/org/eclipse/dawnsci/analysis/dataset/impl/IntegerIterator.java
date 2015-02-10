/*-
 *******************************************************************************
 * Copyright (c) 2011, 2014 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Peter Chang - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.dawnsci.analysis.dataset.impl;

/**
 * Class to run over an integer dataset and return its items
 */
public class IntegerIterator extends IndexIterator {
	final private IntegerDataset indices;
	final private IndexIterator iter;
	final private int istep; // step over items
	final private int imax; // maximum index in array

	/**
	 * Constructor for an iterator over the items of an integer dataset
	 *
	 * @param index integer dataset
	 * @param length of entire data array
	 */
	public IntegerIterator(final Dataset index, final int length) {
		this(index, length, 1);
	}

	/**
	 * Constructor for an iterator over the items of an integer dataset
	 * 
	 * @param index integer dataset
	 * @param length of entire data array
	 * @param isize number of elements in an item
	 */
	public IntegerIterator(final Dataset index, final int length, final int isize) {
		indices = (IntegerDataset) (index instanceof IntegerDataset ? index : DatasetUtils.convertToDataset(index).cast(Dataset.INT32));
		iter = index.getIterator();
		istep = isize;
		imax = length*istep;
	}

	@Override
	public boolean hasNext() {
		while (iter.hasNext()) {
			index = istep*indices.getAbs(iter.index);
			if (index < 0)
				index += imax;
			return true;
		}
		return false;
	}

	@Override
	public int[] getPos() {
		return null;
	}

	@Override
	public void reset() {
		iter.reset();
	}
}
