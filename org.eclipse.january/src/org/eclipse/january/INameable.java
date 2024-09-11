/*-
 * Copyright 2014, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/EPL-2.0.html
 */

package org.eclipse.january;

/**
 * Simple interface to provide a data object with a name.
 */
public interface INameable {

	/**
	 * @return the name
	 */
	public String getName();

	/**
	 * @param name to use
	 */
	public void setName(String name);

}
