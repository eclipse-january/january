/*-
 *******************************************************************************
 * Copyright (c) 2011, 2016 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/EPL-2.0.html
 *
 * Contributors:
 *    Peter Chang - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.january.metadata;

import org.eclipse.january.dataset.IDataset;

/**
 * This metadata describes masking information associated with a dataset
 */
public interface MaskMetadata extends MetadataType {

	/**
	 * Initialize mask
	 * @param mask to set
	 */
	public void initialize(IDataset mask);

	/**
	 * Get mask
	 * @return mask
	 */
	public IDataset getMask();
}
