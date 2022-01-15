/*-
 * Copyright 2015, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import java.util.concurrent.TimeUnit;

import org.eclipse.january.DatasetException;

/**
 * A dataset connector contains a lazy dataset which exists in a remote
 * location. It uses a connection to the DataServer to provide the
 * implementation of the slicing required remotely.
 * 
 * You may also listen to data changing in the dataset
 */
public interface IDatasetConnector extends IFileConnection, IDynamicShape {

	/**
	 * The dataset location/name in the file
	 * @return Dataset name
	 */
	public String getDatasetName();

	/**
	 * The dataset location/name in the file
	 * @param datasetName name
	 */
	public void setDatasetName(String datasetName);

	/**
	 * If set to true the DataServer will not cache the dataset. 
	 * If left as false: if the data server can figure out that the 
	 * file is writing, it will reshape. However it cannot always 
	 * determine this depending on the file and what is writing to 
	 * it (SWMR can write without changing date stamp for instance)
	 * 
	 * Setting this boolean ensures that a given path, never will
	 * cache on the data server.
	 * 
	 * Default value is false for MJPEG streams and true for standard
	 * remote datasets.
	 *  
	 * @param expectWrite true if server should expect more data
	 */
	public void setWritingExpected(boolean expectWrite);

	/**
	 * @return true if the remote dataset has been warned that writing is expected.
	 */
	public boolean isWritingExpected();
	

	/**
	 * Same as calling connect(500, TimeUnit.MILLISECOND)
	 * 
	 * This will connect with the DataServer to start listening
	 * to any updates to the file should it be written in the remote file system.
	 * When connect is called, the remote file must exist and the dataset properties
	 * are read. These properties must not change in the file while you are connected.
	 * For instance if the file is ints when you connect, it must not change data class.
	 * 
	 * @return the name of the thread started to run the connection or null if each event
	 * is driven from the event thread of the service (for instance web sockets provide the
	 * thread and this runs the connection)
	 * @throws DatasetException when cannot connect
	 */
	public String connect() throws DatasetException;

	/**
	 * This will connect with the DataServer to start listening
	 * to any updates to the file should it be written in the remote file system.
	 * When connect is called, the remote file must exist and the dataset properties
	 * are read. These properties must not change in the file while you are connected.
	 * For instance if the file is ints when you connect, it must not change data class.
	 * 
	 * @param time amount to wait
	 * @param unit of time
	 * @return the name of the thread started to run the connection or null if each event
	 * is driven from the event thread of the service (for instance web sockets provide the
	 * thread and this runs the connection)
	 * @throws DatasetException when cannot connect
	 */
	public String connect(long time, TimeUnit unit) throws DatasetException;

	/**
	 * Stops listening to the dataset changing and disconnects from the server.
	 * A remote dataset may be connected and disconnected multiple times.
	 * @throws DatasetException when cannot disconnect
	 */
	public void disconnect() throws DatasetException;
}
