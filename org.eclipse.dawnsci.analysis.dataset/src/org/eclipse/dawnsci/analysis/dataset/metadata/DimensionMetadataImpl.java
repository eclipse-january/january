/*-
 * Copyright 2015 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.dataset.metadata;

import org.eclipse.dawnsci.analysis.api.metadata.DimensionMetadata;
import org.eclipse.dawnsci.analysis.api.metadata.MetadataType;

public class DimensionMetadataImpl implements DimensionMetadata {

	protected int[] shape;
	private int[] maxShape;
	private int[] chunkShape;

	public DimensionMetadataImpl(int[] shape, int[] maxShape, int[] chunkShape) {
		this.shape = shape;
		this.maxShape = maxShape;
		this.chunkShape = chunkShape;
	}

	public DimensionMetadataImpl(DimensionMetadataImpl dim) {
		this.shape = dim.shape.clone();
		this.maxShape = dim.maxShape == null ? null : dim.maxShape.clone();
		this.chunkShape = dim.chunkShape == null ? null : dim.chunkShape.clone();
	}

	@Override
	public MetadataType clone() {
		return new DimensionMetadataImpl(this);
	}

	@Override
	public int[] getDataDimensions() {
		return shape;
	}

	@Override
	public int[] getDataMaxDimensions() {
		return maxShape;
	}

	@Override
	public int[] getDataChunkDimensions() {
		return chunkShape;
	}
}
