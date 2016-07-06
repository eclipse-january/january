/*
 * Copyright (c) 2012 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.metadata.internal;

import org.eclipse.january.dataset.IDataset;
import org.eclipse.january.metadata.MaskMetadata;
import org.eclipse.january.metadata.Sliceable;
import org.eclipse.january.metadata.Transposable;

public class MaskMetadataImpl implements MaskMetadata {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Transposable
	@Sliceable
	IDataset mask;
	
	public MaskMetadataImpl(IDataset mask) {
		this.mask = mask;
	}

	public MaskMetadataImpl(MaskMetadataImpl mask) {
		this.mask = mask == null ? null : mask.mask.getSliceView();
	}

	@Override
	public IDataset getMask() {
		return mask;
	}
	
	@Override
	public MaskMetadata clone() {
		return new MaskMetadataImpl(this);
	}

}
