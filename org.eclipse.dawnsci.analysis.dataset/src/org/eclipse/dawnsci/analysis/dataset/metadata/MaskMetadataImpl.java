/*
 * Copyright (c) 2012 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.dataset.metadata;

import org.eclipse.dawnsci.analysis.api.dataset.ILazyDataset;
import org.eclipse.dawnsci.analysis.api.metadata.MaskMetadata;
import org.eclipse.dawnsci.analysis.api.metadata.Sliceable;
import org.eclipse.dawnsci.analysis.api.metadata.Transposable;

public class MaskMetadataImpl implements MaskMetadata {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Transposable
	@Sliceable
	ILazyDataset mask;
	
	public MaskMetadataImpl(ILazyDataset mask) {
		this.mask = mask;
	}

	public MaskMetadataImpl(MaskMetadataImpl mask) {
		this.mask = mask == null ? null : mask.mask.getSliceView();
	}

	@Override
	public ILazyDataset getMask() {
		return mask;
	}
	
	@Override
	public MaskMetadata clone() {
		return new MaskMetadataImpl(this);
	}

}
