/*-
 * Copyright 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january;

/**
 * Exception class associated with datasets 
 */
public class DatasetException extends Exception {
	private static final long serialVersionUID = 8936607081910736618L;

	/**
	 * @see Exception#Exception()
	 */
	public DatasetException() {
		super();
	}

	/**
	 * @param message detailed message
	 * @see Exception#Exception(String)
	 */
	public DatasetException(String message) {
		super(message);
	}

	/**
	 * @param cause of problem
	 * @see Exception#Exception(Throwable)
	 */
	public DatasetException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message detailed message
	 * @param cause of problem
	 * @see Exception#Exception(String, Throwable)
	 */
	public DatasetException(String message, Throwable cause) {
		super(message, cause);
	}
}
