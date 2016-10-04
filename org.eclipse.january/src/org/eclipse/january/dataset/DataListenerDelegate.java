/*-
 * Copyright 2015, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Class used by DynamicDataset to delegate
 */
public class DataListenerDelegate {

	private List<IDataListener> listeners;

	public DataListenerDelegate() {
		listeners = Collections.synchronizedList(new ArrayList<IDataListener>());
	}
	
	public void addDataListener(IDataListener l) {
		synchronized (listeners) {
			if (!listeners.contains(l)) {
				listeners.add(l);
			}
		}
	}

	public void removeDataListener(IDataListener l) {
		listeners.remove(l);
	}

	public void fire(DataEvent evt) {
		synchronized (listeners) {
			for (Iterator<IDataListener> iterator = listeners.iterator(); iterator.hasNext();) {
				iterator.next().dataChangePerformed(evt);
			}
		}
	}

	public boolean hasDataListeners() {
		return listeners.size() > 0;
	}

	public void clear() {
		listeners.clear();
 	}

}
