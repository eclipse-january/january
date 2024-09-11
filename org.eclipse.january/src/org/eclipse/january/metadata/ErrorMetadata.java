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

import org.eclipse.january.dataset.ILazyDataset;

/**
 * This metadata describes any error associated with a dataset
 */
public interface ErrorMetadata extends MetadataType {

	public void initialize();

	/**
	 * @param error to set
	 * @since 2.2
	 */
	public void initialize(ILazyDataset error);

	/**
	 * Get error dataset
	 * @return error dataset
	 */
	public ILazyDataset getError();

	/**
	 * Set the error
	 * @param error to set
	 */
	public void setError(ILazyDataset error);
}
