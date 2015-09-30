/*-
 * Copyright 2015 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.dataset.impl;

import java.util.Date;

/**
 * Interface for a dataset containing {@link Date}s.
 */
public interface DateDataset extends Dataset {
	
	/**
	 * Get the date at index i. The dataset must be 1D
	 * @param i
	 * @return date
	 */
	public Date getDate(final int i);
	
	/**
	 * Get the date at index i, j. The dataset must be 2D
	 * @param i
	 * @param j
	 * @return date
	 */
	public Date getDate(final int i, final int j);
	
	/**
	 * Get the date at given indices
	 * @param pos indices
	 * @return date
	 */
	public Date getDate(final int... pos);
	
	/**
	 * Get the date at the given absolute index. See warning for {@link Dataset} interface.
	 * @param index
	 * @return date
	 */
	public Date getDateAbs(final int index);
	
}
