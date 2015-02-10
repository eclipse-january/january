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
 * Class to run over an iterator and visits positions where items in selection dataset are true 
 */
public class BooleanIterator extends IndexIterator {
	final private BooleanDataset b;
	final private IndexIterator iterb;
	final private IndexIterator iterd;
	final private boolean v;
	final private int[] pos; // position in dataset

	/**
	 * Constructor for an iterator over the items of a boolean dataset that are
	 * true
	 *
	 * @param iter dataset iterator
	 * @param selection boolean dataset
	 */
	public BooleanIterator(final IndexIterator iter, final Dataset selection) {
		this(iter, selection, true);
	}

	/**
	 * Constructor for an iterator over the items of a boolean dataset that match
	 * given value
	 *
	 * @param iter dataset iterator
	 * @param selection boolean dataset
	 * @param value
	 */
	public BooleanIterator(final IndexIterator iter, final Dataset selection, boolean value) {
		b = (BooleanDataset) (selection instanceof BooleanDataset ? selection : DatasetUtils.convertToDataset(selection).cast(Dataset.BOOL));

		iterb = selection.getIterator();
		iterd = iter;
		pos = iterd.getPos();
		v = value;
	}

	@Override
	public boolean hasNext() {
		while (iterb.hasNext() && iterd.hasNext()) {
			if (b.getAbs(iterb.index) == v) {
				index = iterd.index;
				return true;
			}
		}
		return false;
	}

	@Override
	public int[] getPos() {
		return pos;
	}

	@Override
	public void reset() {
		iterb.reset();
		iterd.reset();
	}
}
