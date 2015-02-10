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

package org.eclipse.dawnsci.analysis.api.metadata;

import org.eclipse.dawnsci.analysis.api.dataset.ILazyDataset;
import org.eclipse.dawnsci.analysis.api.dataset.Slice;

/**
 * Defines the origin of a dataset which is a slice of a parent dataset
 */
public interface OriginMetadata extends DimensionMetadata {

	/**
	 * 
	 * @return ILazyDataset
	 */
	public ILazyDataset getParent();
	
	/**
	 * The starting slice
	 * @return the initial slice
	 */
	public Slice[] getSliceFromInput();
	
	/**
	 * 
	 * @return name of dataset
	 */
	public String getDatasetName();
	
	/**
	 * 
	 * @return file path
	 */
	public String getFilePath();
	
	/**
	 * Current slice information.
	 * @return the current slice.
	 */
	public Slice[] getSliceInOutput();
	
}
