/*-
 *******************************************************************************
 * Copyright (c) 2011, 2016 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Peter Chang - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.january.dataset;

/**
 * Class to run over contiguous datasets
 */
public class ContiguousIterator extends IndexIterator {
	final private int imax; // maximum index in array
	final private int istep; // step over items
	final private int element;

	/**
	 * Constructor for an iterator over the items of a contiguous dataset that are
	 * within the dimensions
	 *
	 * @param length of entire data array
	 */
	public ContiguousIterator(final int length) {
		this(length, 1);
	}

	/**
	 * Constructor for an iterator over the items of a contiguous dataset that are
	 * within the dimensions
	 *
	 * @param length of entire data array
	 * @param isize number of elements in an item
	 */
	public ContiguousIterator(final int length, final int isize) {
		this(length, isize, 0);
	}

	/**
	 * Constructor for an iterator over the items of a contiguous dataset that are
	 * within the dimensions
	 *
	 * @param length of entire data array
	 * @param isize number of elements in an item
	 * @param element element to start with (for compound datasets)
	 */
	public ContiguousIterator(final int length, final int isize, final int element) {
		istep = isize;
		index = -istep + element;
		imax = length*isize;
		this.element = element;
	}

	@Override
	public boolean hasNext() {
		index += istep;
		return index < imax;
	}

	@Override
	public int[] getPos() {
		return null;
	}

	@Override
	public void reset() {
		index = -istep + element;
	}
}
