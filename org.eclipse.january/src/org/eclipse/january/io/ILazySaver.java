/*-
 * Copyright 2015, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.io;

import java.io.IOException;

import org.eclipse.january.IMonitor;
import org.eclipse.january.dataset.IDataset;
import org.eclipse.january.dataset.SliceND;

/**
 * Used by lazy writeable datasets to write slices to a file
 */
public interface ILazySaver extends ILazyLoader {
	public static final long serialVersionUID = 1366057382940519510L;

	/**
	 * Initialize dataset in file
	 * @throws IOException when cannot open destination
	 */
	public void initialize() throws IOException;

	/**
	 * @return true if file is writeable
	 */
	public boolean isFileWriteable();

	/**
	 * @param mon can be null
	 * @param data to use
	 * @param slice destination where to set with items of data
	 * @throws IOException when cannot write data
	 */
	public void setSlice(IMonitor mon, IDataset data, SliceND slice) throws IOException;
}
