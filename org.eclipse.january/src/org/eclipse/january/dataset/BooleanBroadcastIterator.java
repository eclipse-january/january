/*-
 * Copyright 2017 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import java.util.Arrays;
import java.util.List;

/**
 * Class to run over a pair of datasets in parallel with NumPy broadcasting to promote shapes
 * which have lower rank and outputs to a third dataset
 * @since 2.1
 */
public class BooleanBroadcastIterator extends BooleanIteratorBase {
	private int[] cShape;
	private int[] cStride;

	private final int[] cDelta;
	private final int cStep;
	private int cMax;
	private int cStart;

	/**
	 * Construct a boolean iterator that stops at every position in the choice dataset where its value matches
	 * the given boolean
	 * @param v boolean value
	 * @param a primary dataset
	 * @param c choice dataset
	 * @param o output dataset, can be null
	 * @param createIfNull if true create the output dataset if that is null
	 */
	public BooleanBroadcastIterator(boolean v, Dataset a, Dataset c, Dataset o, boolean createIfNull) {
		super(v, a, c, o);
		List<int[]> fullShapes = BroadcastUtils.broadcastShapes(a.getShapeRef(), c.getShapeRef(), o == null ? null : o.getShapeRef());

		maxShape = fullShapes.remove(0);

		oStride = null;
		if (o != null && !Arrays.equals(maxShape, o.getShapeRef())) {
			throw new IllegalArgumentException("Output does not match broadcasted shape");
		}
		aShape = fullShapes.remove(0);
		cShape = fullShapes.remove(0);

		int rank = maxShape.length;
		endrank = rank - 1;

		aDataset = a.reshape(aShape);
		cDataset = c.reshape(cShape);
		aStride = BroadcastUtils.createBroadcastStrides(aDataset, maxShape);
		cStride = BroadcastUtils.createBroadcastStrides(cDataset, maxShape);
		if (outputA) {
			oStride = aStride;
			oDelta = null;
			oStep = 0;
		} else if (o != null) {
			oStride = BroadcastUtils.createBroadcastStrides(o, maxShape);
			oDelta = new int[rank];
			oStep = o.getElementsPerItem();
		} else if (createIfNull) {
			oDataset = BroadcastUtils.createDataset(a, c, maxShape);
			oStride = BroadcastUtils.createBroadcastStrides(oDataset, maxShape);
			oDelta = new int[rank];
			oStep = oDataset.getElementsPerItem();
		} else {
			oDelta = null;
			oStep = 0;
		}

		pos = new int[rank];
		aDelta = new int[rank];
		cDelta = new int[rank];
		cStep = cDataset.getElementsPerItem();
		for (int j = endrank; j >= 0; j--) {
			aDelta[j] = aStride[j] * aShape[j];
			cDelta[j] = cStride[j] * cShape[j];
			if (oDelta != null) {
				oDelta[j] = oStride[j] * maxShape[j];
			}
		}
		aStart = aDataset.getOffset();
		cStart = cDataset.getOffset();
		aMax = endrank < 0 ? aStep + aStart: Integer.MIN_VALUE;
		cMax = endrank < 0 ? cStep + cStart: Integer.MIN_VALUE;
		oStart = oDelta == null ? 0 : oDataset.getOffset();
		reset();
	}

	@Override
	public boolean hasNext() {
		do {
			int j = endrank;
			for (; j >= 0; j--) {
				pos[j]++;
				index += aStride[j];
				cIndex += cStride[j];
				if (oDelta != null) {
					oIndex += oStride[j];
				}
				if (pos[j] >= maxShape[j]) {
					pos[j] = 0;
					index -= aDelta[j]; // reset these dimensions
					cIndex -= cDelta[j];
					if (oDelta != null) {
						oIndex -= oDelta[j];
					}
				} else {
					break;
				}
			}
			if (j == -1) {
				if (endrank >= 0) {
					return false;
				}
				index += aStep;
				cIndex += cStep;
				if (oDelta != null) {
					oIndex += oStep;
				}
			}
			if (outputA) {
				oIndex = index;
			}
	
			if (index == aMax || cIndex == cMax) {
				return false;
			}
		} while (cDataset.getElementBooleanAbs(cIndex) != value);

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
	public int[] getMaskShape() {
		return cShape;
	}

	@Override
	public void reset() {
		for (int i = 0; i <= endrank; i++) {
			pos[i] = 0;
		}

		if (endrank >= 0) {
			pos[endrank] = -1;
			index = aStart - aStride[endrank];
			cIndex = cStart - cStride[endrank];
			oIndex = oStart - (oStride == null ? 0 : oStride[endrank]);
		} else {
			index = aStart - aStep;
			cIndex = cStart - cStep;
			oIndex = oStart - oStep;
		}
	}
}
