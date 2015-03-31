/*-
 * Copyright 2015 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.api.dataset;

import java.util.Iterator;

public class DataListenerDelegate implements IDynamicDataset {

	private EventListenerList eventListenerlist;

	public DataListenerDelegate() {
		eventListenerlist = new EventListenerList();
	}
	
	@Override
	public void addDataListener(IDataListener l) {
		eventListenerlist.addListener(IDataListener.class, l);
	}

	@Override
	public void removeDataListener(IDataListener l) {
		eventListenerlist.removeListener(IDataListener.class, l);
	}

	public void fire(DataEvent evt) {
		for (Iterator iterator = eventListenerlist.getListeners(IDataListener.class); iterator.hasNext();) {
			IDataListener l = (IDataListener) iterator.next();
			l.dataChangePerformed(evt);
		}
	}

}
