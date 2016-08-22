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
 * Class to run over a pair of contiguous datasets with only the second dataset read
 */
public class ContiguousSingleIterator extends BroadcastSelfIterator {
	private final int aMax; // maximum index in array
	private final int aStep; // step over items
	private final int bMax; // maximum index in array
	private final int bStep;

	public ContiguousSingleIterator(Dataset a, Dataset b) {
		super(a, b);
		aStep = a.getElementsPerItem();
		aMax = a.getSize() * aStep;
		bStep = b.getElementsPerItem();
		bMax = b.getSize() * bStep;
		maxShape = a.getShape();
		asDouble = aDataset.hasFloatingPointElements();
		reset();
	}

	@Override
	public boolean hasNext() {
		aIndex += aStep;
		bIndex += bStep;

		if (aIndex >= aMax || bIndex >= bMax) {
			return false;
		}
		if (read) {
			if (asDouble) {
				bDouble = bDataset.getElementDoubleAbs(bIndex);
			} else {
				bLong = bDataset.getElementLongAbs(bIndex);
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
		aIndex = -aStep;
		bIndex = -bStep;
		if (read) {
			storeCurrentValues();
		}
	}
}
