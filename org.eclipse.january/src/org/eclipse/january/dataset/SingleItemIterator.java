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
	final private int offset;
	private int i;

	/**
	 * Constructor for an iterator over single item that will be broadcast over
	 * given size of broadcast shape
	 * @param offset offset to single item
	 * @param size
	 */
	public SingleItemIterator(final int offset, final int size) {
		this.size = size;
		this.offset = offset;
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
		index = offset;
		i = 0;
	}
}
