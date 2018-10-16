/*-
 *******************************************************************************
 * Copyright (c) 2018 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Peter Chang - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.january.metadata.internal;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Immutable class to use as keys
 */
class Axes implements Serializable {
	private static final long serialVersionUID = -10965330793644662L;
	private final int[] axes;

	public Axes(int[] axes) {
		this.axes = axes;
	}

	@Override
	public int hashCode() {
		return Arrays.hashCode(axes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Axes)) {
			return false;
		}
		Axes other = (Axes) obj;
		if (!Arrays.equals(axes, other.axes)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return Arrays.toString(axes);
	}
}
