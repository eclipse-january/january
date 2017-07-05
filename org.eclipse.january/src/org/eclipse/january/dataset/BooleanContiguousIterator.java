/*-
 * Copyright 2017 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

/**
 * Class to run over a pair of contiguous datasets
 */
public class BooleanContiguousIterator extends BooleanIterator {
	private final int cMax; // maximum index in array
	private final int cStep;

	/**
	 * Construct a boolean iterator that stops at the position in choice dataset where its value matches
	 * the given boolean
	 * @param v boolean value
	 * @param a primary dataset
	 * @param c choice dataset
	 * @param o output dataset, can be null
	 * @param createIfNull if true create the output dataset if that is null
	 */
	public BooleanContiguousIterator(boolean v, Dataset a, Dataset c, Dataset o, boolean createIfNull) {
		super(v, a, c, o);
		aMax = a.getSize() * aStep;
		cStep = c.getElementsPerItem();
		cMax = c.getSize() * cStep;
		if (outputA) {
			oStep = aStep;
		} else if (o != null) {
			oStep = o.getElementsPerItem();
		} else if (createIfNull) {
			oDataset = BroadcastUtils.createDataset(a, c, a.getShapeRef());
			oStep = oDataset.getElementsPerItem();
		} else {
			oStep = 1;
		}
		maxShape = a.getShape();
		reset();
	}

	@Override
	public boolean hasNext() {
		do {
			index += aStep;
			cIndex += cStep;
	
			if (outputA) {
				oIndex = index;
			} else {
				oIndex += oStep;
			}
	
			if (index >= aMax || cIndex >= cMax) {
				return false;
			}
		} while (cDataset.getElementBooleanAbs(cIndex) != value);

		return true;
	}

	@Override
	public int[] getPos() {
		return null;
	}

	@Override
	public void reset() {
		index = -aStep;
		cIndex = -cStep;
		oIndex = -oStep;
	}
}
