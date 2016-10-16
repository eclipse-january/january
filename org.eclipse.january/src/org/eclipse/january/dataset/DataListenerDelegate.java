/*-
 * Copyright 2015, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class used by DynamicDataset to delegate
 */
public class DataListenerDelegate {

	private Set<IDataListener> listeners;

	public DataListenerDelegate() {
		listeners = Collections.newSetFromMap(new ConcurrentHashMap<IDataListener, Boolean>());
	}

	public void addDataListener(IDataListener l) {
		listeners.add(l);
	}

	public void removeDataListener(IDataListener l) {
		listeners.remove(l);
	}

	public void fire(DataEvent evt) {
		for (IDataListener listener : listeners) {
			listener.dataChangePerformed(evt);
		}
	}

	public boolean hasDataListeners() {
		return listeners.size() > 0;
	}

	public void clear() {
		listeners.clear();
	}

}
