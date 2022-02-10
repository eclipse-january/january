/*-
 * Copyright 2015, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

/**
 * This interface is intended for data sources that change shape dynamically.
 * Examples:
 * 1. An image stream from a camera encoded which entire image, changes periodically.
 * 2. An HDF5 dataset which entire shape changes as data is added.
 *  
 */
public interface IDynamicShape {

	/**
	 * Denotes an unlimited dimension in maximum shape
	 */
	public static final int UNLIMITED = -1;


	/**
	 * @return dataset associated with shape
	 */
	public ILazyDataset getDataset();

	/**
	 * Change shape
	 * @param newShape new shape
	 * @throws IllegalArgumentException if new shape exceeds maximum shape or is of different rank
	 * @throws UnsupportedOperationException if used on a view
	 * @return true if shape has changed
	 */
	public boolean resize(int... newShape);

	/**
	 * @return maximum shape (can be null)
	 */
	public int[] getMaxShape();

	/**
	 * Set maximum shape
	 * @param maxShape maximum shape
	 */
	public void setMaxShape(int... maxShape);

	/**
	 * Starts a periodic checker to see if dataset has changed in some manner. If any potential changes
	 * are detected after the period has finished then registered listeners are alerted.
	 * A period of 0 or less will stop any existing checker.
	 * 
	 * @param milliseconds period between checks in milliseconds
	 * @param checker can be null for default implementation of alerting listeners unconditionally
	 */
	public void startUpdateChecker(int milliseconds, IDatasetChangeChecker checker);

	/**
	 * Force the shape to be re-read from file, if possible
	 * @return true if shape has changed
	 */
	public boolean refreshShape();

	/**
	 * Add a listener which will be fired when aspects of the data change for
	 * instance shape or content.
	 * @param l listener
	 */
	public void addDataListener(IDataListener l);
	
	/**
	 * Remove a listener which will be fired when aspects of the data change for
	 * instance shape or content.
	 * @param l listener
	 */
	public void removeDataListener(IDataListener l);

	/**
	 * Alert any registered listeners
	 */
	public void fireDataListeners();

	/**
	 * Add a listener which will be fired when aspects of the meta data change for
	 * instance origin of data
	 * @param l
	 */
	// TODO Add this when required.
	//public void addMetadataListener(IMetadataListener l);
	

	/**
	 * Remove a listener which will be fired when aspects of the meta data change for
	 * instance origin of data
	 * @param l
	 */
	// TODO Add this when required.
	//public void removeDataListener(IMetadataListener l);
}
