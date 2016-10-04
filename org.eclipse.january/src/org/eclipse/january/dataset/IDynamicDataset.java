/*-
 * Copyright 2015, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;


/**
 * This interface is intended for data sources that change dynamically.
 * Examples:
 * 1. An image stream from a camera encoded which entire image, changes periodically.
 * 2. An HDF5 dataset which entire shape changes as data is added.
 *  
 */
public interface IDynamicDataset extends ILazyDataset, IDynamicShape {

	/**
	 * Denotes an unlimited dimension in maximum shape
	 */
	public static final int UNLIMITED = IDynamicShape.UNLIMITED;
}
