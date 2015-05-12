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
import org.eclipse.dawnsci.analysis.api.dataset.Slice;
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

		// check shape for expandable dimensions
		for (int i = 0; i < shape.length; i++) {
			if (shape[i] == UNLIMITED) {
				shape[i] = 0;
			}
		}
		size = AbstractDataset.calcLongSize(shape);
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

	/**
	 * Create a lazy writeable dataset based on in-memory data (handy for testing)
	 * @param dataset
	 */
	public static LazyWriteableDataset createLazyDataset(final Dataset dataset) {
		return new LazyWriteableDataset(dataset.getName(), dataset.getDtype(), dataset.getElementsPerItem(), dataset.getShape(),
				null, null,
		new ILazySaver() {
			final Dataset d = dataset;
			@Override
			public boolean isFileReadable() {
				return true;
			}

			@Override
			public boolean isFileWriteable() {
				return true;
			}

			@Override
			public void initialize() throws Exception {
			}

			@Override
			public Dataset getDataset(IMonitor mon, SliceND slice)
					throws Exception {
				return d.getSlice(mon, slice);
			}

			@Override
			public void setSlice(IMonitor mon, IDataset data, SliceND slice) throws Exception {
				d.setSlice(data, slice);
			}
		});
	}

	@Override
	public int[] getMaxShape() {
		return maxShape;
	}

	@Override
	public void setMaxShape(int[] maxShape) {
		this.maxShape = maxShape == null ? shape.clone() : maxShape.clone();
	}

	@Override
	public int[] getChunking() {
		return chunks;
	}

	@Override
	public void setChunking(int[] chunks) {
		this.chunks = chunks == null ? null : chunks.clone();
	}

	@Override
	public LazyWriteableDataset clone() {
		LazyWriteableDataset ret = new LazyWriteableDataset(new String(name), getDtype(), getElementsPerItem(), 
				oShape, maxShape, chunks, saver);
		ret.shape = shape;
		ret.size = size;
		ret.prepShape = prepShape;
		ret.postShape = postShape;
		ret.begSlice = begSlice;
		ret.delSlice = delSlice;
		ret.map = map;
		ret.base = base;
		ret.metadata = copyMetadata();
		ret.oMetadata = oMetadata;
		return ret;
	}

	@Override
	public LazyWriteableDataset getSliceView(int[] start, int[] stop, int[] step) {
		return (LazyWriteableDataset) super.getSliceView(start, stop, step);
	}

	@Override
	public LazyWriteableDataset getSliceView(Slice... slice) {
		return (LazyWriteableDataset) super.getSliceView(slice);
	}

	@Override
	public LazyWriteableDataset getSliceView(SliceND slice) {
		return (LazyWriteableDataset) super.getSliceView(slice);
	}

	@Override
	public LazyWriteableDataset getTransposedView(int... axes) {
		return (LazyWriteableDataset) super.getTransposedView(axes);
	}

	/**
	 * Set a slice of the dataset
	 * 
	 * @param data
	 * @param slice an n-D slice
	 * @throws Exception 
	 */
	public void setSlice(IDataset data, SliceND slice) throws Exception {
		setSlice(null, data, slice);
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
			shape = slice.getSourceShape();
		}
	}

	/**
	 * Set saver (and also loader)
	 * @param saver
	 */
	@Override
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
