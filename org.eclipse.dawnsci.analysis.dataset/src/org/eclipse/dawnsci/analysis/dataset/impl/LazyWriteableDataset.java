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

import org.eclipse.dawnsci.analysis.api.dataset.DataEvent;
import org.eclipse.dawnsci.analysis.api.dataset.IDataset;
import org.eclipse.dawnsci.analysis.api.dataset.ILazyWriteableDataset;
import org.eclipse.dawnsci.analysis.api.dataset.Slice;
import org.eclipse.dawnsci.analysis.api.dataset.SliceND;
import org.eclipse.dawnsci.analysis.api.io.ILazySaver;
import org.eclipse.dawnsci.analysis.api.monitor.IMonitor;

/**
 * Subclass of lazy dataset that allows setting slices
 */
public class LazyWriteableDataset extends LazyDynamicDataset implements ILazyWriteableDataset {
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
		super(name, dtype, elements, shape, maxShape, saver);
		this.chunks = chunks == null ? null : chunks.clone();
		this.saver = saver;

		size = AbstractDataset.calcLongSize(this.shape);
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
		return createLazyDataset(dataset, null);
	}

	/**
	 * Create a lazy writeable dataset based on in-memory data (handy for testing)
	 * @param dataset
	 */
	public static LazyWriteableDataset createLazyDataset(final Dataset dataset, final int[] maxShape) {
		return new LazyWriteableDataset(dataset.getName(), dataset.getDtype(), dataset.getElementsPerItem(), dataset.getShape(),
				maxShape, null,
		new ILazySaver() {
			Dataset d = dataset;
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
				if (slice.isExpanded()) {
					Dataset od = d;
					d = DatasetFactory.zeros(slice.getSourceShape(), od.getDtype());
					d.setSlice(od, SliceND.createSlice(od, null, null));
				}
				d.setSlice(data, slice);
			}
		});
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
		ret.eventDelegate = eventDelegate;
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
			eventDelegate.fire(new DataEvent(name, shape));
		}
	}

	@Override
	public void setSlice(IMonitor monitor, IDataset data, int[] start, int[] stop, int[] step) throws Exception {
		setSlice(monitor, data, new SliceND(shape, maxShape, start, stop, step));
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
		return base.createSlice(nstart, nstop, nstep);
	}
}
