/*-
 *******************************************************************************
 * Copyright (c) 2011, 2014 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Peter Chang - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.dawnsci.analysis.dataset.impl;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.dawnsci.analysis.api.dataset.ILazyDataset;
import org.eclipse.dawnsci.analysis.api.dataset.Slice;
import org.eclipse.dawnsci.analysis.api.dataset.SliceND;
import org.eclipse.dawnsci.analysis.api.io.ILazyLoader;
import org.eclipse.dawnsci.analysis.api.metadata.MetadataType;
import org.eclipse.dawnsci.analysis.api.metadata.Reshapeable;
import org.eclipse.dawnsci.analysis.api.metadata.Sliceable;
import org.eclipse.dawnsci.analysis.api.metadata.Transposable;
import org.eclipse.dawnsci.analysis.api.monitor.IMonitor;
import org.eclipse.dawnsci.analysis.dataset.metadata.OriginMetadataImpl;

public class LazyDataset extends LazyDatasetBase implements Serializable, Cloneable {

	private int[]       oShape; // original shape
	protected long      size;   // number of items
	private int         dtype;
	private int         isize; // number of elements per item

	protected ILazyLoader loader;
	private LazyDataset base = null; // used for transpose

	// relative to loader or base
	private int         prepShape = 0; // prepending and post-pending 
	private int         postShape = 0; // changes to shape
	private int[]       begSlice = null; // slice begin
	private int[]       delSlice = null; // slice delta
	private int[]       map; // transposition map (same length as current shape)
	private Map<Class<? extends MetadataType>, List<MetadataType>> oMetadata = null;

	/**
	 * Create a lazy dataset
	 * @param name
	 * @param dtype dataset type
	 * @param elements
	 * @param shape
	 * @param loader
	 */
	public LazyDataset(String name, int dtype, int elements, int[] shape, ILazyLoader loader) {
		this.name = name;
		this.shape = shape;
		this.oShape = shape;
		this.loader = loader;
		this.dtype = dtype;
		this.isize = elements;
		try {
			size = AbstractDataset.calcLongSize(shape);
		} catch (IllegalArgumentException e) {
			size = Long.MAX_VALUE; // this indicates that the entire dataset cannot be read in! 
		}
	}

	/**
	 * Create a lazy dataset
	 * @param name
	 * @param dtype dataset type
	 * @param shape
	 * @param loader
	 */
	public LazyDataset(String name, int dtype, int[] shape, ILazyLoader loader) {
		this(name, dtype, 1, shape, loader);
	}

	/**
	 * Create a lazy dataset based on in-memory data (handy for testing)
	 * @param dataset
	 */
	public static LazyDataset createLazyDataset(final Dataset dataset) {
		return new LazyDataset(dataset.getName(), dataset.getDtype(), dataset.getElementsPerItem(), dataset.getShape(),
		new ILazyLoader() {
			final Dataset d = dataset;
			@Override
			public boolean isFileReadable() {
				return true;
			}

			@Override
			public Dataset getDataset(IMonitor mon, SliceND slice)
					throws Exception {
				return d.getSlice(mon, slice);
			}
		});
	}

	/**
	 * Can return -1 for unknown
	 */
	@Override
	public int getDtype() {
		return dtype;
	}

	/**
	 * Can return -1 for unknown
	 */
	@Override
	public int getElementsPerItem() {
		return isize;
	}

	@Override
	public int getSize() {
		return (int) size;
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();

		if (name != null && name.length() > 0) {
			out.append("Lazy dataset '");
			out.append(name);
			out.append("' has shape [");
		} else {
			out.append("Lazy dataset shape is [");
		}
		int rank = shape == null ? 0 : shape.length;

		if (rank > 0 && shape[0] >= 0) {
			out.append(shape[0]);
		}
		for (int i = 1; i < rank; i++) {
			out.append(", " + shape[i]);
		}
		out.append(']');

		return out.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj))
			return false;

		LazyDataset other = (LazyDataset) obj;
		if (dtype != other.dtype) {
			return false;
		}
		if (isize != other.isize) {
			return false;
		}

		if (!Arrays.equals(shape, other.shape)) {
			return false;
		}

		if (loader != other.loader) {
			return false;
		}

		if (prepShape != other.prepShape) {
			return false;
		}

		if (postShape != other.postShape) {
			return false;
		}

		if (!Arrays.equals(begSlice, other.begSlice)) {
			return false;
		}
		if (!Arrays.equals(delSlice, other.delSlice)) {
			return false;
		}
		if (!Arrays.equals(map, other.map)) {
			return false;
		}
		return true;
	}

	@Override
	public LazyDataset clone() {
		LazyDataset ret = new LazyDataset(new String(name), dtype, isize, oShape, loader);
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
	public void setShape(int... shape) {
		setShapeInternal(shape);
	}

	@Override
	public LazyDataset squeezeEnds() {
		setShapeInternal(AbstractDataset.squeezeShape(shape, true));
		return this;
	}

	@Override
	public Dataset getSlice(int[] start, int[] stop, int[] step) {
		try {
			return getSlice(null, start, stop, step);
		} catch (Exception e) {
			logger.error("Problem slicing lazy dataset", e);
		}
		return null;
	}

	@Override
	public Dataset getSlice(Slice... slice) {
		try {
			if (slice == null || slice.length == 0) {
				return getSlice(null, new SliceND(shape));
			}
			return getSlice(null, new SliceND(shape, slice));
		} catch (Exception e) {
			logger.error("Problem slicing lazy dataset", e);
		}
		return null;
	}

	@Override
	public Dataset getSlice(SliceND slice) {
		try {
			return getSlice(null, slice);
		} catch (Exception e) {
			logger.error("Problem slicing lazy dataset", e);
		}
		return null;
	}

	@Override
	public Dataset getSlice(IMonitor monitor, Slice... slice) throws Exception {
		if (slice == null || slice.length == 0) {
			return getSlice(monitor, new SliceND(shape));
		}
		return getSlice(monitor, new SliceND(shape, slice));
	}

	@Override
	public LazyDataset getSliceView(Slice... slice) {
		if (slice == null || slice.length == 0) {
			return getSliceView(new SliceND(shape));
		}
		return getSliceView(new SliceND(shape, slice));
	}

	private void setShapeInternal(int... nShape) {
		long nsize = AbstractDataset.calcLongSize(nShape);
		if (nsize != size) {
			throw new IllegalArgumentException("Size of new shape is not equal to current size");
		}
		if (nsize == 1) {
			shape = nShape.clone();
			return;
		}

		int ob = -1; // first non-unit dimension
		int or = shape.length;
		for (int i = 0; i < or; i++) {
			if (shape[i] != 1) {
				ob = i;
				break;
			}
		}
		assert ob >= 0;
		int oe = -1; // last non-unit dimension
		for (int i = or - 1; i >= ob; i--) {
			if (shape[i] != 1) {
				oe = i;
				break;
			}
		}
		assert oe >= 0;
		oe++;

		int nb = -1; // first non-unit dimension
		int nr = nShape.length;
		for (int i = 0; i < nr; i++) {
			if (nShape[i] != 1) {
				nb = i;
				break;
			}
		}

		int i = ob;
		int j = nb;
		if (begSlice == null) {
			for (; i < oe && j < nr; i++, j++) {
				if (shape[i] != nShape[j]) {
					throw new IllegalArgumentException("New shape not allowed - can only change shape by adding or removing ones to ends of old shape");
				}
			}
		} else {
			int[] nBegSlice = new int[nr];
			int[] nDelSlice = new int[nr];
			Arrays.fill(nDelSlice, 1);
			for (; i < oe && j < nr; i++, j++) {
				if (shape[i] != nShape[j]) {
					throw new IllegalArgumentException("New shape not allowed - can only change shape by adding or removing ones to ends of old shape");
				}
				nBegSlice[j] = begSlice[i];
				nDelSlice[j] = delSlice[i];
			}
	
			begSlice = nBegSlice;
			delSlice = nDelSlice;
		}
		prepShape += nb - ob;
		postShape += nr - oe;

		storeMetadata(metadata, Reshapeable.class);
		metadata = copyMetadata();
		reshapeMetadata(shape, nShape);
		shape = nShape;
	}

	@Override
	public LazyDataset getSliceView(int[] start, int[] stop, int[] step) {
		return getSliceView(new SliceND(shape, start, stop, step));
	}

	@Override
	public LazyDataset getSliceView(SliceND slice) {
		LazyDataset view = clone();
		if (slice.isAll())
			return view;

		int[] lstart = slice.getStart();
		int[] lstep  = slice.getStep();
		final int rank = shape.length;

		int[] nShape = slice.getShape();
		view.shape = nShape;
		view.size = AbstractDataset.calcLongSize(nShape);
		if (begSlice == null) {
			view.begSlice = lstart.clone();
			view.delSlice = lstep.clone();
		} else {
			view.begSlice = new int[rank];
			view.delSlice = new int[rank];
			for (int i = 0; i < rank; i++) {
				view.begSlice[i] = begSlice[i] + lstart[i] * delSlice[i];
				view.delSlice[i] = delSlice[i] * lstep[i];
			}
		}
		view.storeMetadata(metadata, Sliceable.class);
		
		view.sliceMetadata(true, slice);
		return view;
	}

	@Override
	public LazyDataset getTransposedView(int... axes) {
		LazyDataset view = clone();

		// everything now is seen through a map
		axes = checkPermutatedAxes(shape, axes);
		if (axes == null)
			return view;

		int r = shape.length;
		view.shape = new int[r];
		for (int i = 0; i < r; i++) {
			view.shape[i] = shape[axes[i]];
		}

		view.prepShape = 0;
		view.postShape = 0;
		view.begSlice = null;
		view.delSlice = null;
		view.map = axes;
		view.base = this;
		view.storeMetadata(metadata, Transposable.class);
		view.transposeMetadata(axes);
		return view;
	}

	// reverse transform
	private int[] getOriginal(int[] values) {
		if (values == null)
			return null;
		int r = values.length;
		if (map == null || r < 2)
			return values;
		int[] ovalues = new int[r];
		for (int i = 0; i < r; i++) {
			ovalues[map[i]] = values[i];
		}
		return ovalues;
	}

	@Override
	public Dataset getSlice(IMonitor monitor, int[] start, int[] stop, int[] step) throws Exception {
		return getSlice(monitor, new SliceND(shape, start, stop, step));
	}

	@Override
	public Dataset getSlice(IMonitor monitor, SliceND slice) throws Exception {

		if (loader != null && !loader.isFileReadable())
			return null; // TODO add interaction to use plot (or remote) server to load dataset

		int[] lstart = slice.getStart();
		int[] lstop  = slice.getStop();
		int[] lstep  = slice.getStep();

		int[] nstart;
		int[] nstop;
		int[] nstep;

		int r = base == null ? oShape.length : base.shape.length;
		nstart = new int[r];
		nstop = new int[r];
		nstep = new int[r];
		Arrays.fill(nstop, 1);
		Arrays.fill(nstep, 1);
		{
			int i = 0;
			int j = 0;
			if (prepShape < 0) { // ignore entries from new slice 
				i = -prepShape;
			} else if (prepShape > 0) {
				j = prepShape;
			}
			if (begSlice == null) {
				for (; i < r && j < shape.length; i++, j++) {
					nstart[i] = lstart[j];
					nstop[i]  = lstop[j];
					nstep[i]  = lstep[j];
				}
			} else {
				for (; i < r && j < shape.length; i++, j++) {
					nstart[i] = begSlice[j] + lstart[j] * delSlice[j];
					nstop[i]  = begSlice[j] + (lstop[j] - 1) * delSlice[j] + 1;
					nstep[i]  = lstep[j] * delSlice[j];
				}
			}
			if (map != null) {
				nstart = getOriginal(nstart);
				nstop  = getOriginal(nstop);
				nstep  = getOriginal(nstep);
			}
		}

		SliceND nslice = new SliceND(base == null ? oShape : base.shape, nstart, nstop, nstep);
		Dataset a;
		if (base != null) {
			a = base.getSlice(monitor, nslice);
		} else {
			try {
				a = DatasetUtils.convertToDataset(loader.getDataset(monitor, nslice));
			} catch (Exception e) {
				// return a fake dataset to show that this has not worked, should not be used in general though.
				logger.debug("Problem getting {}: {}", String.format("slice %s %s %s", Arrays.toString(slice.getStart()), Arrays.toString(slice.getStop()),
								Arrays.toString(slice.getStep())), e);
				a = new DoubleDataset(1);
			}
			a.setName(name + AbstractDataset.BLOCK_OPEN + nslice.toString() + AbstractDataset.BLOCK_CLOSE);
			if (metadata != null && a instanceof LazyDatasetBase) {
				LazyDatasetBase ba = (LazyDatasetBase) a;
				ba.metadata = copyMetadata();
				if (oMetadata != null)
					ba.restoreMetadata(oMetadata);
				if (!nslice.isAll())
					ba.sliceMetadata(true, nslice);
			}
		}
		if (map != null) {
			a = a.getTransposedView(map);
		}
		a.setShape(slice.getShape());
		a.addMetadata(new OriginMetadataImpl(this, nslice.convertToSlice(), oShape, null, null));
		
		return a;
	}

	/**
	 * Store metadata items that has given annotation
	 * @param origMetadata
	 * @param aclazz
	 */
	private void storeMetadata(Map<Class<? extends MetadataType>, List<MetadataType>> origMetadata, Class<? extends Annotation> aclazz) {
		List<Class<? extends MetadataType>> mclazzes = findAnnotatedMetadata(aclazz);
		if (mclazzes.size() == 0)
			return;

		if (oMetadata == null) {
			oMetadata = new HashMap<Class<? extends MetadataType>, List<MetadataType>>();
		}
		for (Class<? extends MetadataType> mc : mclazzes) {
			if (oMetadata.containsKey(mc))
				continue; // do not overwrite original

			List<MetadataType> l = origMetadata.get(mc);
			List<MetadataType> nl = new ArrayList<MetadataType>(l.size());
			for (MetadataType m : l) {
				nl.add(m.clone());
			}
			oMetadata.put(mc, nl);
		}
	}

	@SuppressWarnings("unchecked")
	private List<Class<? extends MetadataType>> findAnnotatedMetadata(Class<? extends Annotation> aclazz) {
		List<Class<? extends MetadataType>> mclazzes = new ArrayList<Class<? extends MetadataType>>();
		if (metadata == null)
			return mclazzes;

		for (Class<? extends MetadataType> c : metadata.keySet()) {
			boolean hasAnn = false;
			for (MetadataType m : metadata.get(c)) {
				if (m == null)
					continue;

				Class<? extends MetadataType> mc = m.getClass();
				do { // iterate over super-classes
					for (Field f : mc.getDeclaredFields()) {
						if (f.isAnnotationPresent(aclazz)) {
							hasAnn = true;
							break;
						}
					}
					Class<?> sclazz = mc.getSuperclass();
					if (!MetadataType.class.isAssignableFrom(sclazz))
						break;
					mc = (Class<? extends MetadataType>) sclazz;
				} while (!hasAnn);
				if (hasAnn)
					break;
			}
			if (hasAnn) {
				mclazzes.add(c);
			}
		}
		return mclazzes;
	}

	/**
	 * Gets the maximum size of a slice of a dataset in a given dimension
	 * which should normally fit in memory. Note that it might be possible
	 * to get more in memory, this is a conservative estimate and seems to
	 * almost always work at the size returned; providing Xmx is less than
	 * the physical memory.
	 * 
	 * To get more in memory increase -Xmx setting or use an expression
	 * which calls a rolling function (like rmean) instead of slicing directly
	 * to memory.
	 * 
	 * @param lazySet
	 * @param dimension
	 * @return maximum size of dimension that can be sliced.
	 */
	public static int getMaxSliceLength(ILazyDataset lazySet, int dimension) {
		// size in bytes of each item
		final double size = AbstractDataset.getItemsize(AbstractDataset.getDTypeFromClass(lazySet.elementClass()), lazySet.getElementsPerItem());
		
		// Max in bytes takes into account our minimum requirement
		final double max  = Math.max(Runtime.getRuntime().totalMemory(), Runtime.getRuntime().maxMemory());
		
        // Firstly if the whole dataset it likely to fit in memory, then we allow it.
		// Space specified in bytes per item available
		final double space = max/lazySet.getSize();

		// If we have room for this whole dataset, then fine
		int[] shape = lazySet.getShape();
		if (space >= size)
			return shape[dimension];
		
		// Otherwise estimate what we can fit in, conservatively.
		// First get size of one slice, see it that fits, if not, still return 1
		double sizeOneSlice = size; // in bytes
		for (int dim = 0; dim < shape.length; dim++) {
			if (dim == dimension)
				continue;
			sizeOneSlice *= shape[dim];
		}
		double avail = max / sizeOneSlice;
		if (avail < 1)
			return 1;

		// We fudge this to leave some room
		return (int) Math.floor(avail/4d);
	}
}
