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

public interface DimensionMetadata extends MetadataType {

	/**
	 * Initialize dimension metadata
	 * @param shape
	 * @param maxShape
	 * @param chunkShape
	 */
	public void initialize(int[] shape, int[] maxShape, int[] chunkShape);

	public int[] getDataDimensions();

	public int[] getDataMaxDimensions();

	public int[] getDataChunkDimensions();
}
