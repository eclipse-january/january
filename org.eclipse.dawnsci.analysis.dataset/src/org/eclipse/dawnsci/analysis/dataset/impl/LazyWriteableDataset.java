/*-
 * Copyright 2015 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.dataset.impl;

import java.io.IOException;

import org.eclipse.dawnsci.analysis.api.dataset.IDataset;
import org.eclipse.dawnsci.analysis.api.dataset.ILazyWriteableDataset;
import org.eclipse.dawnsci.analysis.api.dataset.SliceND;
import org.eclipse.dawnsci.analysis.api.io.ILazySaver;
import org.eclipse.dawnsci.analysis.api.monitor.IMonitor;

/**
 * Subclass of lazy dataset that allows setting slices
 */
public class LazyWriteableDataset extends LazyDataset implements ILazyWriteableDataset {
	private int[] maxShape;
	private int[] chunks;
	private ILazySaver saver;

	/**
	 * Create a lazy dataset
	 * @param name
	 * @param dtype dataset type
	 * @param elements
	 * @param shape
	 * @param maxShape
	 * @param chunks
	 * @param saver
	 */
	public LazyWriteableDataset(String name, int dtype, int elements, int[] shape, int[] maxShape, int[] chunks, ILazySaver saver) {
		super(name, dtype, elements, shape, saver);
		this.maxShape = maxShape == null ? shape.clone() : maxShape.clone();
		this.chunks = chunks == null ? null : chunks.clone();
		this.saver = saver;
		this.loader = saver;
	}

	/**
	 * Create a lazy dataset
	 * @param name
	 * @param dtype dataset type
	 * @param shape
	 * @param maxShape
	 * @param chunks
	 * @param saver
	 */
	public LazyWriteableDataset(String name, int dtype, int[] shape, int[] maxShape, int[] chunks, ILazySaver saver) {
		this(name, dtype, 1, shape, maxShape, chunks, saver);
	}

	@Override
	public int[] getMaxShape() {
		return maxShape;
	}

	@Override
	public int[] getChunking() {
		return chunks;
	}

	@Override
	public void setSlice(IMonitor monitor, IDataset data, SliceND slice) throws Exception {
		if (saver == null && saver.isFileWriteable()) {
			throw new IOException("Cannot write to file!");
		}

		SliceND nslice = calcTrueSlice(slice);

		if (base != null) {
			((ILazyWriteableDataset) base).setSlice(monitor, data, nslice);
		} else {
			saver.setSlice(monitor, data, nslice);
			oShape = nslice.getSourceShape();
		}
	}

	/**
	 * Set saver (and also loader)
	 * @param saver
	 */
	public void setSaver(ILazySaver saver) {
		this.saver = saver;
		this.loader = saver;
	}

	@Override
	protected SliceND createSlice(int[] nstart, int[] nstop, int[] nstep) {
		if (base == null) {
			return new SliceND(oShape, maxShape, nstart, nstop, nstep);
		}
		return new SliceND(base.shape, nstart, nstop, nstep);
	}
}
