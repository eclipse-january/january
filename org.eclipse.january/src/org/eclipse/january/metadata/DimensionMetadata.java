/*-
 *******************************************************************************
 * Copyright (c) 2011, 2016 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/EPL-2.0.html
 *
 * Contributors:
 *    Peter Chang - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.january.metadata;

public interface DimensionMetadata extends MetadataType {

	/**
	 * Initialize dimension metadata
	 * @param shape to set
	 * @param maxShape maximum possible dimensions
	 * @param chunkShape dimensions of chunks
	 */
	public void initialize(int[] shape, int[] maxShape, int[] chunkShape);

	public int[] getDataDimensions();

	public int[] getDataMaxDimensions();

	public int[] getDataChunkDimensions();
}
