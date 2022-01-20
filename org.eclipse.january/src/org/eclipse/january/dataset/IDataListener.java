/*-
 * Copyright 2015, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.january.dataset;

import java.util.EventListener;

/**
 * Listener for data changes. Don't forget to remove it when you no longer need data
 * changes to be updated.
 */
public interface IDataListener extends EventListener {

	/**
	 * Called when data changes value/shape.
	 * @param evt event
	 */
	void dataChangePerformed(DataEvent evt);
}
