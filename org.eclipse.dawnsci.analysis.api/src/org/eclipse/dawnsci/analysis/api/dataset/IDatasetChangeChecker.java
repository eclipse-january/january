/*-
 * Copyright 2015 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.api.dataset;

/**
 * Interface for a dataset checker to detect change
 */
public interface IDatasetChangeChecker {

	/**
	 * Set dataset to be checked for signs of change. Do any state initialization in here.
	 * @param dataset
	 */
	public void setDataset(ILazyDataset dataset);

	/**
	 * Check for any change. Also update state information.
	 * @return true if possible change may have occurred
	 */
	public boolean check();
}
