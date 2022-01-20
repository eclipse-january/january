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
 * Base class for boolean iterators for pairs of dataset where the second dataset could be broadcast to the first and
 * is used to select where {{@link #hasNext()} returns true. An optional third dataset can specify the output.
 * For speed, there are public members.
 */
public abstract class BooleanIterator extends IndexIterator {

	/**
	 * Create a boolean iterator that stops at every position in the choice dataset with a true value
	 * @param a primary dataset
	 * @param c choice dataset, can be null to choose all
	 * @return boolean iterator
	 * @since 2.1
	 */
	public static BooleanIterator createIterator(Dataset a, Dataset c) {
		return createIterator(true, a, c, null, false);
	}

	/**
	 * Create a boolean iterator that stops at every position in the choice dataset with a true value
	 * @param a primary dataset
	 * @param c choice dataset, can be null to choose all
	 * @param o output dataset, can be null
	 * @return boolean iterator
	 * @since 2.1
	 */
	public static BooleanIterator createIterator(Dataset a, Dataset c, Dataset o) {
		return createIterator(true, a, c, o, false);
	}

	/**
	 * Create a boolean iterator that stops at every position in the choice dataset where its value matches
	 * the given boolean
	 * @param v boolean value
	 * @param a primary dataset
	 * @param c choice dataset, can be null to choose all
	 * @param o output dataset, can be null
	 * @return boolean iterator
	 * @since 2.1
	 */
	public static BooleanIterator createIterator(boolean v, Dataset a, Dataset c, Dataset o) {
		return createIterator(v, a, c, o, false);
	}

	/**
	 * Create a boolean iterator that stops at every position in the choice dataset where its value matches
	 * the given boolean
	 * @param v boolean value
	 * @param a primary dataset
	 * @param c choice dataset, can be null to choose all
	 * @param o output dataset, can be null
	 * @param createIfNull if true create the output dataset if that is null
	 * @return boolean iterator
	 * @since 2.1
	 */
	public static BooleanIterator createIterator(boolean v, Dataset a, Dataset c, Dataset o, boolean createIfNull) {
		if (c == null) {
			return new BooleanNullIterator(a, o, createIfNull);
		}
		if (Arrays.equals(a.getShapeRef(), c.getShapeRef()) && a.getStrides() == null && c.getStrides() == null) {
			if (o == null || (o.getStrides() == null && Arrays.equals(a.getShapeRef(), o.getShapeRef()))) {
				return new BooleanContiguousIterator(v, a, c, o, createIfNull);
			}
		}
		return new BooleanBroadcastIterator(v, a, c, o, createIfNull);
	}

	protected final boolean value;

	/**
	 * Index in choice dataset
	 */
	public int cIndex;

	/**
	 * Index in output dataset
	 */
	public int oIndex;

	/**
	 * Output dataset
	 */
	protected Dataset oDataset;

	final protected boolean outputA;

	protected int[] maxShape;

	protected final int aStep; // step over items
	protected int oStep;
	protected int aMax; // maximum index in array
	protected int aStart, oStart;

	protected Dataset aDataset;
	protected Dataset cDataset;

	/**
	 * @return choice
	 * @since 2.1
	 */
	public Dataset getChoice() {
		return cDataset;
	}

	@Override
	public int[] getShape() {
		return maxShape;
	}

	/**
	 * Construct a boolean iterator that stops at the given boolean value in choice dataset
	 * @param v boolean value
	 * @param a primary dataset
	 * @param c choice dataset
	 * @param o output dataset, can be null
	 */
	protected BooleanIterator(boolean v, Dataset a, Dataset c, Dataset o) {
		value = v;
		aDataset = a;
		aStep = a.getElementsPerItem();
		cDataset = c;
		oDataset = o;
		outputA = a == o;
		if (c != null && c == o) {
			throw new IllegalArgumentException("Output dataset must not be same as mask dataset");
		}

		if (c != null) {
			BroadcastUtils.checkItemSize(a, c, o);
		} else if (o != null) {
			BroadcastUtils.checkItemSize(a, o);
		}
		if (o != null) {
			o.setDirty();
		}
	}

	/**
	 * @return output dataset (can be null)
	 * @since 2.1
	 */
	public Dataset getOutput() {
		return oDataset;
	}
}
