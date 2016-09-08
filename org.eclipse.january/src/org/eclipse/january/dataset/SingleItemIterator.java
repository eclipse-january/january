/*-
 *******************************************************************************
 * Copyright (c) 2016 Diamond Light Source Ltd.
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
 * Class to run over a broadcasted single-item dataset
 */
public class SingleItemIterator extends IndexIterator {
	final private int size;
	final private int element;
	private int i;

	/**
	 * Constructor for an iterator over the items of a contiguous dataset that are
	 * within the dimensions
	 *
	 * @param length of entire data array
	 */
	public SingleItemIterator(final int length) {
		this(length, 0);
	}

	/**
	 * Constructor for an iterator over the items of a contiguous dataset that are
	 * within the dimensions
	 *
	 * @param length of entire data array
	 * @param element element to start with (for compound datasets)
	 */
	public SingleItemIterator(final int length, final int element) {
		size = length;
		this.element = element;
		reset();
	}

	@Override
	public boolean hasNext() {
		return i++ < size;
	}

	@Override
	public int[] getPos() {
		return null;
	}

	@Override
	public void reset() {
		index = element;
		i = 0;
	}
}
