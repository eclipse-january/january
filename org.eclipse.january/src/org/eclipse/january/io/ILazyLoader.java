/*-
 *******************************************************************************
 * Copyright (c) 2011, 2014 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Peter Chang - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.january.io;

import java.io.IOException;
import java.io.Serializable;

import org.eclipse.january.IMonitor;
import org.eclipse.january.dataset.IDataset;
import org.eclipse.january.dataset.SliceND;

/**
 * Used by lazy datasets to read slices from a file
 */
public interface ILazyLoader extends Serializable {

	/**
	 * 
	 * @return true if file is readable
	 */
	public boolean isFileReadable();

	/**
	 * @param mon
	 * @param slice
	 * @return a slice of a dataset
	 * @throws IOException
	 */
	public IDataset getDataset(IMonitor mon, SliceND slice) throws IOException;
}
