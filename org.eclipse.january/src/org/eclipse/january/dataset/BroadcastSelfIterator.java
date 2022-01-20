/*-
 * Copyright 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import java.util.Arrays;

/**
 * Base class for broadcast iterators where the second dataset could be broadcast to the first
 * and it is also read into either bLong or bDouble fields.<p>
 * For speed, there are public members. Note, index is not updated
 */
public abstract class BroadcastSelfIterator extends BroadcastIteratorBase {

	/**
	 * @param a dataset to iterate over
	 * @param b dataset to iterate over (will broadcast to first)
	 * @return broadcast iterator
	 */
	public static BroadcastSelfIterator createIterator(Dataset a, Dataset b) {
		if (Arrays.equals(a.getShapeRef(), b.getShapeRef()) && a.getStrides() == null && b.getStrides() == null) {
			return a.getElementsPerItem() == 1 && b.getElementsPerItem() == 1 ? new ContiguousSingleIteratorElemental(a, b) : new ContiguousSingleIterator(a, b);
		}
		return new BroadcastSingleIterator(a, b);
	}

	/**
	 * @param a dataset to iterate over
	 * @param b dataset to iterate over (will broadcast to first)
	 */
	protected BroadcastSelfIterator(Dataset a, Dataset b) {
		super(a, b);
		read = InterfaceUtils.isNumerical(b.getClass());
		asDouble = aDataset.hasFloatingPointElements();
		BroadcastUtils.checkItemSize(a, b, null);
	}

	@Override
	protected void storeCurrentValues() {
		if (bIndex >= 0) {
			if (asDouble) {
				bDouble = bDataset.getElementDoubleAbs(bIndex);
			} else {
				bLong = bDataset.getElementLongAbs(bIndex);
			}
		}
	}
}
