/*-
 * Copyright 2015 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.api.dataset;

import java.util.EventObject;

/**
 * Event fired to diseminate information about a dataset changing.
 * For instance if an image represents a live stream.
 */
public class DataEvent extends EventObject {

	/**
	 * Creates an event to notify that this data has changed.
	 * @param source
	 */
	public DataEvent(IDataset source) {
		super(source);
	}

	@Override
	public IDataset getSource() {
		return (IDataset)super.getSource();
	}
}
