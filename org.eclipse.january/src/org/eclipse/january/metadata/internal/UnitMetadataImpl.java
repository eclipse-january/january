/*-
 * Copyright 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.metadata.internal;

import javax.measure.Unit;

import org.eclipse.january.metadata.MetadataType;
import org.eclipse.january.metadata.UnitMetadata;

public class UnitMetadataImpl implements UnitMetadata {

	private static final long serialVersionUID = 8463775397065879390L;

	private Unit<?> unit;

	public UnitMetadataImpl() {
	}

	@Override
	public void initialize(Unit<?> unit) {
		this.unit = unit;
	}

	protected UnitMetadataImpl(UnitMetadata unitMetadata) {
		initialize(unitMetadata.getUnit());
	}

	@Override
	public MetadataType clone() {
		return new UnitMetadataImpl(this);
	}

	@Override
	public Unit<?> getUnit() {
		return unit;
	}
	
	@Override
	public String toString(){
		return unit.toString();
	}
}
