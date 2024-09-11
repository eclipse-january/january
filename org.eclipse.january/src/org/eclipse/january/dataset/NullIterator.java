/*-
 * Copyright 2015, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/EPL-2.0.html
 */

package org.eclipse.january.dataset;

public class NullIterator extends SliceIterator {

	/**
	 * @since 2.3
	 */
	public NullIterator() {
	}

	/**
	 * @param shape shape of dataset
	 * @param sshape shape of slice
	 */
	public NullIterator(int[] shape, int[] sshape) {
		this.shape = shape;
		this.sshape = sshape;
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public int[] getPos() {
		return null;
	}

	@Override
	public void reset() {
	}
}
