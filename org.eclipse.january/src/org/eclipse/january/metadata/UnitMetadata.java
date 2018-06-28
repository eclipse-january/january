/*-
 *******************************************************************************
 * Copyright (c) 2011, 2016 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Peter Chang - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.january.metadata;

import javax.measure.Unit;

/**
 * This metadata describes the unit associated with the quantity stored in a dataset
 * @since 2.1
 */
public interface UnitMetadata extends MetadataType {

	/**
	 * Initialize unit metadata with given unit
	 * @param unit
	 */
	public void initialize(Unit<?> unit);

	/**
	 * Get unit
	 * @return unit of dataset
	 */
	public Unit<?> getUnit();
}
