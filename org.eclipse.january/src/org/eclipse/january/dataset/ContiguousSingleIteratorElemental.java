/*-
 * Copyright 2022 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

/**
 * Class to run over a pair of contiguous and elemental datasets with only the second dataset read
 * @since 2.3
 */
public class ContiguousSingleIteratorElemental extends BroadcastSelfIterator {
	private final int aMax; // maximum index in array

	public ContiguousSingleIteratorElemental(Dataset a, Dataset b) {
		super(a, b);
		aMax = a.getSize();
		maxShape = a.getShape();
		asDouble = aDataset.hasFloatingPointElements();
		reset();
	}

	@Override
	public boolean hasNext() {
		aIndex++;
		bIndex = aIndex;
		if (aIndex >= aMax) {
			return false;
		}
		if (read) {
			if (asDouble) {
				bDouble = bDataset.getElementDoubleAbs(aIndex);
			} else {
				bLong = bDataset.getElementLongAbs(aIndex);
			}
		}
		return true;
	}

	@Override
	public int[] getPos() {
		return null;
	}

	@Override
	public void reset() {
		aIndex = -1;
		bIndex = -1;
		if (read) {
			storeCurrentValues();
		}
	}
}
