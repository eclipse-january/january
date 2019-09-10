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
 * Class to run over a single dataset with NumPy broadcasting to promote shapes
 * which have lower rank and outputs to a second dataset
 * @since 2.1
 */
public class BooleanNullIterator extends BooleanIteratorBase {

	/**
	 * @param a
	 * @param o (can be null for new dataset, or a)
	 */
	public BooleanNullIterator(Dataset a, Dataset o) {
		this(a, o, false);
	}

	/**
	 * @param a
	 * @param o (can be null for new dataset, or a)
	 * @param createIfNull if true create the output dataset if that is null
	 * (by default, can create float or complex datasets)
	 */
	public BooleanNullIterator(Dataset a, Dataset o, boolean createIfNull) {
		this(a, o, createIfNull, false, true);
	}

	/**
	 * @param a
	 * @param o (can be null for new dataset, or a)
	 * @param createIfNull if true create the output dataset if that is null
	 * @param allowInteger if true, can create integer datasets
	 * @param allowComplex if true, can create complex datasets
	 */
	public BooleanNullIterator(Dataset a, Dataset o, boolean createIfNull, boolean allowInteger, boolean allowComplex) {
		super(true, a, null, o);
		List<int[]> fullShapes = BroadcastUtils.broadcastShapes(a.getShapeRef(), o == null ? null : o.getShapeRef());

		BroadcastUtils.checkItemSize(a, o);

		maxShape = fullShapes.remove(0);

		oStride = null;
		if (o != null && !Arrays.equals(maxShape, o.getShapeRef())) {
			throw new IllegalArgumentException("Output does not match broadcasted shape");
		}

		aShape = fullShapes.remove(0);

		int rank = maxShape.length;
		endrank = rank - 1;

		aDataset = a.reshape(aShape);
		aStride = BroadcastUtils.createBroadcastStrides(aDataset, maxShape);
		if (outputA) {
			oStride = aStride;
			oDelta = null;
			oStep = 0;
		} else if (o != null) {
			oStride = BroadcastUtils.createBroadcastStrides(o, maxShape);
			oDelta = new int[rank];
			oStep = o.getElementsPerItem();
		} else if (createIfNull) {
			int is = aDataset.getElementsPerItem();
			Class<? extends Dataset> dc = aDataset.getClass();
			if (aDataset.isComplex() && !allowComplex) {
				is = 1;
				dc = InterfaceUtils.getBestFloatInterface(dc);
			} else if (!aDataset.hasFloatingPointElements() && !allowInteger) {
				dc = InterfaceUtils.getBestFloatInterface(dc);
			}
			oDataset = DatasetFactory.zeros(is, dc, maxShape);
			oStride = BroadcastUtils.createBroadcastStrides(oDataset, maxShape);
			oDelta = new int[rank];
			oStep = is;
		} else {
			oDelta = null;
			oStep = 0;
		}

		pos = new int[rank];
		aDelta = new int[rank];
		for (int j = endrank; j >= 0; j--) {
			aDelta[j] = aStride[j] * aShape[j];
			if (oDelta != null) {
				oDelta[j] = oStride[j] * maxShape[j];
			}
		}

		aStart = aDataset.getOffset();
		aMax = endrank < 0 ? aStep + aStart : Integer.MIN_VALUE;
		oStart = oDelta == null ? 0 : oDataset.getOffset();
		reset();
	}

	@Override
	public boolean hasNext() {
		int j = endrank;
		for (; j >= 0; j--) {
			pos[j]++;
			index += aStride[j];
			if (oDelta != null) {
				oIndex += oStride[j];
			}
			if (pos[j] >= maxShape[j]) {
				pos[j] = 0;
				index -= aDelta[j]; // reset these dimensions
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
			if (oDelta != null) {
				oIndex += oStep;
			}
		}
		if (outputA) {
			oIndex = index;
		}

		if (index == aMax) {
			return false;
		}

		return true;
	}

	@Override
	public void reset() {
		for (int i = 0; i <= endrank; i++) {
			pos[i] = 0;
		}

		if (endrank >= 0) {
			pos[endrank] = -1;
			index = aStart - aStride[endrank];
			oIndex = oStart - (oStride == null ? 0 : oStride[endrank]);
		} else {
			index = aStart - aStep;
			oIndex = oStart - oStep;
		}
	}
}
