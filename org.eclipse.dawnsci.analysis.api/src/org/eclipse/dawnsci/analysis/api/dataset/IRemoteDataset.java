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
 * A Remote dataset is a lazy dataset which exists in a remote
 * location. It uses a connection to the DataServer to provide the
 * implementation of the slicing requied remotely.
 * 
 * You may also listen to data changing in the dataset
 */
public interface IRemoteDataset extends ILazyDataset, IDynamicDataset {

}
