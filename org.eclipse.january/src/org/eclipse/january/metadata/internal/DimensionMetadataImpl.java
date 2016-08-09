/*-
 * Copyright 2015, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.metadata.internal;

import org.eclipse.january.metadata.DimensionMetadata;
import org.eclipse.january.metadata.MetadataType;

public class DimensionMetadataImpl implements DimensionMetadata {

	private static final long serialVersionUID = -8414494547115738924L;

	protected int[] shape;
	private int[] maxShape;
	private int[] chunkShape;

	public DimensionMetadataImpl() {
	}

	@Override
	public void initialize(int[] shape, int[] maxShape, int[] chunkShape) {
		this.shape = shape;
		this.maxShape = maxShape;
		this.chunkShape = chunkShape;
	}

	protected DimensionMetadataImpl(DimensionMetadataImpl dim) {
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
