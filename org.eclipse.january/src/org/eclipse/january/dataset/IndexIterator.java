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

import java.util.function.Supplier;

/**
 * <p>Class to provide iteration through whole data array that backs a dataset</p>
 * <p>Instantiate an iterator and use it in a while loop:
 * <pre>
 *  DoubleDataset ds = DatasetFactory.createLinearSpace(DoubleDataset.class, 0, 10, 0.25);
 *  IndexIterator iter = ds.getIterator();
 *  double[] data = ds.getData();
 *  
 *  while (iter.hasNext()) {
 *      data[iter.index] = 1.2;
 *  }
 * </pre>
 * 
 */
public abstract class IndexIterator implements Supplier<int[]> {
	/**
	 * Index in array
	 */
	public int index;

	/**
	 * @return true if there is another iteration
	 */
	abstract public boolean hasNext();

	/**
	 * @return position indices (nb this is reference not a copy so avoid changing and can be null)
	 */
	abstract public int[] getPos();

	/**
	 * Reset iterator
	 */
	abstract public void reset();

	/**
	 * @return shape of iterator (can be null, if not known or applicable)
	 */
	public int[] getShape() {
		return null;
	}

	/**
	 * @since 2.1
	 */
	@Override
	public int[] get() {
		return hasNext() ? getPos() : null;
	}
	
	/**
	 * The number of repetitions which this iterator will make
	 * @since 2.1
	 * @return
	 */
	public int size() {
		int size = 0;
		while (hasNext()) size++;
		reset();
        return size;
	}

}
