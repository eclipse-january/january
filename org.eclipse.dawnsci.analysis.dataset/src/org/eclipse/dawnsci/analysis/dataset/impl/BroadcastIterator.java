/*-
 * Copyright 2015 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.dataset.impl;

import java.util.Arrays;

/**
 * Base class for broadcast iterators of pairs with output. For speed, there are public members. Note, index is not updated
 */
public abstract class BroadcastIterator extends BroadcastIteratorBase {

	public static BroadcastIterator createIterator(Dataset a, Dataset b) {
		return createIterator(a, b, null, false);
	}

	public static BroadcastIterator createIterator(Dataset a, Dataset b, Dataset o) {
		return createIterator(a, b, o, false);
	}

	public static BroadcastIterator createIterator(Dataset a, Dataset b, Dataset o, boolean createIfNull) {
		if (Arrays.equals(a.getShapeRef(), b.getShapeRef()) && a.getStrides() == null && b.getStrides() == null) {
			if (o == null || (o.getStrides() == null && Arrays.equals(a.getShapeRef(), o.getShapeRef()))) {
				return new ContiguousPairIterator(a, b, o, createIfNull);
			}
		}
		return new BroadcastPairIterator(a, b, o, createIfNull);
	}

	/**
	 * Index in output dataset
	 */
	public int oIndex;
	/**
	 * Current value in first dataset
	 */
	public double aDouble;
	/**
	 * Current value in first dataset
	 */
	public long aLong;
	/**
	 * Output dataset
	 */
	protected Dataset oDataset;

	final protected boolean outputA;
	final protected boolean outputB;

	protected BroadcastIterator(Dataset a, Dataset b, Dataset o) {
		super(a, b);
		oDataset = o;
		outputA = a == o;
		outputB = b == o;
		read = AbstractDataset.isDTypeNumerical(a.getDType()) && AbstractDataset.isDTypeNumerical(b.getDType());
		asDouble = aDataset.hasFloatingPointElements() || bDataset.hasFloatingPointElements();
		BroadcastUtils.checkItemSize(a, b, o);
	}

	/**
	 * @return output dataset (can be null)
	 */
	public Dataset getOutput() {
		return oDataset;
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
