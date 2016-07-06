/*-
 * Copyright 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

/**
 * Exception class associated with datasets 
 */
public class DatasetException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4789908999411239514L;

	/**
	 * @see Exception#Exception()
	 */
	public DatasetException() {
		super();
	}

	/**
	 * @param message
	 * @see Exception#Exception(String)
	 */
	public DatasetException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 * @see Exception#Exception(Throwable)
	 */
	public DatasetException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @see Exception#Exception(String, Throwable)
	 */
	public DatasetException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 * @see Exception#Exception(String, Throwable, boolean, boolean)
	 */
	public DatasetException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
