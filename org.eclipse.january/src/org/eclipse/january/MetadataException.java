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
 * Exception associated with metadata
 */
public class MetadataException extends DatasetException {
	private static final long serialVersionUID = 8699903515753503664L;

	/**
	 * @see Exception#Exception()
	 */
	public MetadataException() {
		super();
	}

	/**
	 * @param message
	 * @see Exception#Exception(String)
	 */
	public MetadataException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 * @see Exception#Exception(Throwable)
	 */
	public MetadataException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @see Exception#Exception(String, Throwable)
	 */
	public MetadataException(String message, Throwable cause) {
		super(message, cause);
	}
}
