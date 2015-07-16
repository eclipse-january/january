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

import java.util.Arrays;
import java.util.List;

/**
 * Class to run over a pair of datasets in parallel with NumPy broadcasting to promote shapes
 * which have lower rank and outputs to a third dataset
 */
public class BroadcastPairIterator extends BroadcastIterator {
	private int[] maxShape;
	private int[] aShape;
	private int[] bShape;
	private int[] aStride;
	private int[] bStride;
	private int[] oStride;

	final private int endrank;

	private final int[] aDelta, bDelta;
	private final int[] oDelta; // this being non-null means output is different from inputs
	private final int aStep, bStep, oStep;
	private int aMax, bMax;
	private int aStart, bStart, oStart;

	/**
	 * 
	 * @param a
	 * @param b
	 * @param o (can be null for new dataset, a or b)
	 * @param createIfNull
	 */
	public BroadcastPairIterator(Dataset a, Dataset b, Dataset o, boolean createIfNull) {
		super(a, b, o);
		List<int[]> fullShapes = broadcastShapes(a.getShapeRef(), b.getShapeRef(), o == null ? null : o.getShapeRef());

		maxShape = fullShapes.remove(0);

		oStride = null;
		if (o != null && !Arrays.equals(maxShape, o.getShapeRef())) {
			throw new IllegalArgumentException("Output does not match broadcasted shape");
		}
		aShape = fullShapes.remove(0);
		bShape = fullShapes.remove(0);

		int rank = maxShape.length;
		endrank = rank - 1;

		aDataset = a.reshape(aShape);
		bDataset = b.reshape(bShape);
		aStride = AbstractDataset.createBroadcastStrides(aDataset, maxShape);
		bStride = AbstractDataset.createBroadcastStrides(bDataset, maxShape);
		if (outputA) {
			oStride = aStride;
			oDelta = null;
			oStep = 0;
			oDataset = aDataset;
		} else if (outputB) {
			oStride = bStride;
			oDelta = null;
			oStep = 0;
			oDataset = bDataset;
		} else if (o != null) {
			oStride = AbstractDataset.createBroadcastStrides(o, maxShape);
			oDelta = new int[rank];
			oStep = o.getElementsPerItem();
			oDataset = o;
		} else if (createIfNull) {
			oDataset = createDataset(a, b, maxShape);
			oStride = AbstractDataset.createBroadcastStrides(oDataset, maxShape);
			oDelta = new int[rank];
			oStep = oDataset.getElementsPerItem();
		} else {
			oDelta = null;
			oStep = 0;
			oDataset = o;
		}

		pos = new int[rank];
		aDelta = new int[rank];
		aStep = aDataset.getElementsPerItem();
		bDelta = new int[rank];
		bStep = bDataset.getElementsPerItem();
		for (int j = endrank; j >= 0; j--) {
			aDelta[j] = aStride[j] * aShape[j];
			bDelta[j] = bStride[j] * bShape[j];
			if (oDelta != null) {
				oDelta[j] = oStride[j] * maxShape[j];
			}
		}
		if (endrank < 0) {
			aMax = aStep;
			bMax = bStep;
		} else {
			aMax = Integer.MIN_VALUE; // use max delta
			bMax = Integer.MIN_VALUE;
			for (int j = endrank; j >= 0; j--) {
				if (aDelta[j] > aMax) {
					aMax = aDelta[j];
				}
				if (bDelta[j] > bMax) {
					bMax = bDelta[j];
				}
			}
		}
		aStart = aDataset.getOffset();
		aMax += aStart;
		bStart = bDataset.getOffset();
		bMax += bStart;
		oStart = oDelta == null ? 0 : oDataset.getOffset();
		asDouble = aDataset.hasFloatingPointElements() || bDataset.hasFloatingPointElements();
		reset();
	}

	@Override
	public int[] getShape() {
		return maxShape;
	}

	@Override
	public boolean hasNext() {
		int j = endrank;
		int oldA = aIndex;
		int oldB = bIndex;
		for (; j >= 0; j--) {
			pos[j]++;
			aIndex += aStride[j];
			bIndex += bStride[j];
			if (oDelta != null)
				oIndex += oStride[j];
			if (pos[j] >= maxShape[j]) {
				pos[j] = 0;
				aIndex -= aDelta[j]; // reset these dimensions
				bIndex -= bDelta[j];
				if (oDelta != null)
					oIndex -= oDelta[j];
			} else {
				break;
			}
		}
		if (j == -1) {
			if (endrank >= 0) {
				aIndex = aMax;
				bIndex = bMax;
				return false;
			}
			aIndex += aStep;
			bIndex += bStep;
			if (oDelta != null)
				oIndex += oStep;
		}
		if (outputA) {
			oIndex = aIndex;
		} else if (outputB) {
			oIndex = bIndex;
		}

		if (aIndex == aMax || bIndex == bMax)
			return false;

		if (oldA != aIndex) {
			if (asDouble) {
				aDouble = aDataset.getElementDoubleAbs(aIndex);
			} else {
				aLong = aDataset.getElementLongAbs(aIndex);
			}
		}
		if (oldB != bIndex) {
			if (asDouble) {
				bDouble = bDataset.getElementDoubleAbs(bIndex);
			} else {
				bLong = bDataset.getElementLongAbs(bIndex);
			}
		}

		return true;
	}

	/**
	 * @return shape of first broadcasted dataset
	 */
	public int[] getFirstShape() {
		return aShape;
	}

	/**
	 * @return shape of second broadcasted dataset
	 */
	public int[] getSecondShape() {
		return bShape;
	}

	@Override
	public void reset() {
		for (int i = 0; i <= endrank; i++)
			pos[i] = 0;

		if (endrank >= 0) {
			pos[endrank] = -1;
			aIndex = aStart - aStride[endrank];
			bIndex = bStart - bStride[endrank];
			oIndex = oStart - (oStride == null ? 0 : oStride[endrank]);
		} else {
			aIndex = aStart - aStep;
			bIndex = bStart - bStep;
			oIndex = oStart - oStep;
		}

		if (aIndex == 0 || bIndex == 0) { // for zero-ranked datasets
			storeCurrentValues();
			if (aMax == aIndex)
				aMax++;
			if (bMax == bIndex)
				bMax++;
		}
	}

	@Override
	protected void storeCurrentValues() {
		if (aIndex >= 0) {
			if (asDouble) {
				aDouble = aDataset.getElementDoubleAbs(aIndex);
			} else {
				aLong = aDataset.getElementLongAbs(aIndex);
			}
		}
		if (bIndex >= 0) {
			if (asDouble) {
				bDouble = bDataset.getElementDoubleAbs(bIndex);
			} else {
				bLong = bDataset.getElementLongAbs(bIndex);
			}
		}
	}
}
