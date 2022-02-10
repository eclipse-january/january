/*-
 * Copyright 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import java.util.List;

/**
 * Class to run over a pair of datasets in parallel with NumPy broadcasting of second dataset
 */
public class BroadcastSingleIterator extends BroadcastSelfIterator {
	private int[] bShape;
	private int[] aStride;
	private int[] bStride;

	final private int endrank;

	private final int[] aDelta, bDelta;
	private final int aStep, bStep;
	private int aMax, bMax;
	private int aStart, bStart;

	/**
	 * @param a dataset to iterate over
	 * @param b dataset to iterate over (will broadcast to first)
	 */
	public BroadcastSingleIterator(Dataset a, Dataset b) {
		super(a, b);

		int[] aShape = a.getShapeRef();
		maxShape = aShape;
		List<int[]> fullShapes = BroadcastUtils.broadcastShapesToMax(maxShape, b.getShapeRef());
		bShape = fullShapes.remove(0);

		int rank = maxShape.length;
		endrank = rank - 1;

		bDataset = b.reshape(bShape);
		int[] aOffset = new int[1];
		aStride = AbstractDataset.createStrides(aDataset, aOffset);
		bStride = BroadcastUtils.createBroadcastStrides(bDataset, maxShape);

		pos = new int[rank];
		aDelta = new int[rank];
		aStep = aDataset.getElementsPerItem();
		bDelta = new int[rank];
		bStep = bDataset.getElementsPerItem();
		for (int j = endrank; j >= 0; j--) {
			aDelta[j] = aStride[j] * aShape[j];
			bDelta[j] = bStride[j] * bShape[j];
		}
		aStart = aOffset[0];
		bStart = bDataset.getOffset();
		aMax = endrank < 0 ? aStep + aStart: Integer.MIN_VALUE;
		bMax = endrank < 0 ? bStep + bStart: Integer.MIN_VALUE;
		reset();
	}

	@Override
	public boolean hasNext() {
		int j = endrank;
		int oldB = bIndex;
		for (; j >= 0; j--) {
			pos[j]++;
			aIndex += aStride[j];
			bIndex += bStride[j];
			if (pos[j] >= maxShape[j]) {
				pos[j] = 0;
				aIndex -= aDelta[j]; // reset these dimensions
				bIndex -= bDelta[j];
			} else {
				break;
			}
		}
		if (j == -1) {
			if (endrank >= 0) {
				return false;
			}
			aIndex += aStep;
			bIndex += bStep;
		}

		if (aIndex == aMax || bIndex == bMax) {
			return false;
		}

		if (read) {
			if (oldB != bIndex) {
				if (asDouble) {
					bDouble = bDataset.getElementDoubleAbs(bIndex);
				} else {
					bLong = bDataset.getElementLongAbs(bIndex);
				}
			}
		}

		return true;
	}

	/**
	 * @return shape of first broadcasted dataset
	 */
	public int[] getFirstShape() {
		return maxShape;
	}

	/**
	 * @return shape of second broadcasted dataset
	 */
	public int[] getSecondShape() {
		return bShape;
	}

	@Override
	public void reset() {
		for (int i = 0; i <= endrank; i++) {
			pos[i] = 0;
		}

		if (endrank >= 0) {
			pos[endrank] = -1;
			aIndex = aStart - aStride[endrank];
			bIndex = bStart - bStride[endrank];
		} else {
			aIndex = aStart - aStep;
			bIndex = bStart - bStep;
		}

		if (aIndex == 0 || bIndex == 0 || (endrank >= 0 && bStride[endrank] == 0)) { // for zero-ranked datasets or extended shape
			if (read) {
				storeCurrentValues();
			}
		}
	}
}
