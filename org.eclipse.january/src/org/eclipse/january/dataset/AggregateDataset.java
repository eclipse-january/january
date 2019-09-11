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

package org.eclipse.january.dataset;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.january.DatasetException;
import org.eclipse.january.IMonitor;

/**
 * Class to aggregate a set of lazy datasets and present them as a single lazy dataset where
 * the first position value accesses the aggregation
 */
public class AggregateDataset extends LazyDatasetBase implements ILazyDataset {

	/**
	 * Update this when there are any serious changes to API
	 */
	private static final long serialVersionUID = -5523566223386837581L;

	private ILazyDataset[] data = null; // array of lazy datasets
	private int[] map = null;    // map first dimension to index of dataset
	private int[] offset = null; // cumulative first dimension lengths used as slice offsets
	private int size;
	private Class<? extends Dataset> clazz = null;
	private int isize; // number of elements per item
	protected AggregateDataset base = null;
	private int[] sliceStart = null;
	private int[] sliceStep  = null;

	/**
	 * Calculate (possibly extended) shapes from given datasets
	 * @param extend if true, extend rank by one
	 * @param datasets
	 * @return array of shapes
	 */
	public static int[][] calcShapes(boolean extend, ILazyDataset... datasets) {
		if (datasets.length == 0)
			throw new IllegalArgumentException("No datasets given");

		int maxRank = -1;
		for (ILazyDataset d : datasets) {
			if (d == null)
				throw new IllegalArgumentException("Null dataset given");

			int r = d.getRank();
			if (r > maxRank)
				maxRank = r;
		}

		if (extend)
			maxRank++;

		int[][] shapes = new int[datasets.length][];
		for (int j = 0; j < datasets.length; j++) {
			ILazyDataset d = datasets[j];
			int[] s = d.getShape();
			if (s.length < maxRank) {
				int[] ns = new int[maxRank];
				int start = maxRank - s.length;

				for (int i = 0; i < start; i++) { // prepend ones as necessary
					ns[i] = 1;
				}
				for (int i = 0; i < s.length; i++) {
					ns[i+start] = s[i];
				}
				s = ns;
			}
			shapes[j] = s;
		}

		return shapes;
	}

	AggregateDataset(int itemSize, Class<? extends Dataset> clazz, int... shape) {
		isize = itemSize;
		this.shape = shape.clone();
		try {
			size = ShapeUtils.calcSize(shape);
		} catch (IllegalArgumentException e) {
			size = Integer.MAX_VALUE; // this indicates that the entire dataset cannot be read in! 
		}
		this.clazz = clazz;
	}

	AggregateDataset(int itemSize, int[] shape, int dtype) {
		this(itemSize, DTypeUtils.getInterface(dtype), shape);
	}

	/**
	 * Create an aggregate dataset
	 * @param extend if true, extend rank by one
	 * @param datasets
	 */
	public AggregateDataset(boolean extend, ILazyDataset... datasets) {

		final int[][] shapes = calcShapes(extend, datasets);

		// check for same (sub-)shape
		final int[] s = shapes[0];
		final int axis = extend ? -1 : 0;
		for (int j = 1; j < shapes.length; j++) {
			if (!ShapeUtils.areShapesCompatible(s, shapes[j], axis))
				throw new IllegalArgumentException("Dataset '" + datasets[j].getName() + "' has wrong shape");
		}

		// set shapes of datasets
		final int maxRank = s.length;
		data = new ILazyDataset[datasets.length];
		isize = datasets[0].getElementsPerItem();
		for (int j = 0; j < datasets.length; j++) {
			ILazyDataset d = datasets[j];
			int[] ds = d.getShape();
			if (ds.length < maxRank) {
				d = d.clone();
				d.setShape(shapes[j]);
			}
			data[j] = d;
			if (d.getElementsPerItem() != isize) {
				throw new IllegalArgumentException("All datasets must have the same number of elements");
			}
		}

		// calculate new shape
		shape = new int[maxRank];
		for (int i = 1; i < shape.length; i++) {
			shape[i] = s[i];
		}
		if (extend) {
			shape[0] = data.length;
		} else {
			for (int j = 0; j < datasets.length; j++) {
				shape[0] += shapes[j][0];
			}
		}
		try {
			size = ShapeUtils.calcSize(shape);
		} catch (IllegalArgumentException e) {
			size = Integer.MAX_VALUE; // this indicates that the entire dataset cannot be read in! 
		}

		// work out offsets from cumulative lengths
		offset = new int[data.length];
		int cd = 0;
		for (int i = 0; i < data.length; i++) {
			offset[i] = cd;
			cd += data[i].getShape()[0];
		}

		// calculate mapping from aggregate dimension to dataset array index
		map = new int[shape[0]];
		int k = 0;
		for (int i = 0; i < data.length; i++) {
			int jmax = data[i].getShape()[0];
			for (int j = 0; j < jmax; j++)
				map[k++] = i;
		}

		for (ILazyDataset d : data) {
			clazz = InterfaceUtils.getBestInterface(clazz, InterfaceUtils.getInterfaceFromClass(d.getElementsPerItem(), d.getElementClass()));
		}

		for (ILazyDataset d : data) {
			String n = d.getName();
			if (n != null) {
				name = n;
				break;
			}
		}
	}

	@Override
	public Class<?> getElementClass() {
		return InterfaceUtils.getElementClass(clazz);
	}

	@Override
	public int getElementsPerItem() {
		return isize;
	}

	@Override
	public int getDType() {
		return DTypeUtils.getDType(clazz);
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void setShape(int... shape) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public ILazyDataset squeezeEnds() {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public Dataset getSlice(int[] start, int[] stop, int[] step) throws DatasetException {
		return getSlice(null, new SliceND(shape, start, stop, step));
	}

	@Override
	public Dataset getSlice(IMonitor monitor, int[] start, int[] stop, int[] step) throws DatasetException {
		return getSlice(monitor, new SliceND(shape, start, stop, step));
	}

	@Override
	public Dataset getSlice(IMonitor monitor, SliceND slice) throws DatasetException {
		int[] start = slice.getStart();
		int[] stop  = slice.getStop();
		int[] step  = slice.getStep();

		if (base != null) {
			for (int i = 0; i < shape.length; i++) {
				start[i] = sliceStart[i] + start[i] * sliceStep[i];
				stop[i]  = sliceStart[i] + (stop[i] - 1) * sliceStep[i] + 1;
				step[i]  = step[i] * sliceStep[i];
			}
			return base.getSlice(monitor, start, stop, step);
		}

		// convert first dimension's slice to individual slices per stored dataset
		int fb = start[0];
		int fe = stop[0];
		int fs = step[0];

		List<Dataset> sliced = new ArrayList<Dataset>();
		int op = fb;
		int p = op;
		ILazyDataset od = data[map[op]];
		ILazyDataset nd; 
		while (p < fe) {
			
			if (monitor!=null && monitor.isCancelled()) throw new DatasetException("Slice cancelled");
			nd = data[map[p]];
			if (nd != od) {
				start[0] = op - offset[map[op]];
				stop[0] = p - offset[map[op]];
				Dataset a = DatasetUtils.convertToDataset(od.getSlice(monitor, start, stop, step));
				sliced.add(a.cast(clazz));

				od = nd;
				op = p;
			}
			p += fs;
		}
		start[0] = op - offset[map[op]];
		stop[0] = p - offset[map[op]];
		Dataset a = DatasetUtils.convertToDataset(od.getSlice(monitor, start, stop, step));
		sliced.add(a.cast(clazz));

		Dataset d = DatasetUtils.concatenate(sliced.toArray(new Dataset[0]), 0);
		d.setName(name);
		return d;
	}

	@Override
	public Dataset getSlice(Slice... slice) throws DatasetException {
		return getSlice(null, slice);
	}

	@Override
	public Dataset getSlice(SliceND slice) throws DatasetException {
		return getSlice(null, slice);
	}

	@Override
	public Dataset getSlice(IMonitor monitor, Slice... slice) throws DatasetException {
		return getSlice(monitor, new SliceND(shape, slice));
	}

	@Override
	public AggregateDataset getSliceView(Slice... slice) {
		return getSliceView(new SliceND(shape, slice));
	}

	@Override
	public AggregateDataset getSliceView(int[] start, int[] stop, int[] step) {
		return getSliceView(new SliceND(shape, start, stop, step));
	}

	@Override
	public AggregateDataset getSliceView(SliceND slice) {
		AggregateDataset lazy = new AggregateDataset(isize, clazz, slice.getShape());
		lazy.sliceStart = slice.getStart();
		lazy.sliceStep  = slice.getStep();
		lazy.name = name + "[" + slice + "]";
		lazy.base = base == null ? this : base;
		return lazy;
	}

	@Override
	public AggregateDataset getTransposedView(int... axes) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public AggregateDataset clone() {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();

		if (name != null && name.length() > 0) {
			out.append("Aggregate dataset '");
			out.append(name);
			out.append("' has shape [");
		} else {
			out.append("Aggregate dataset shape is [");
		}
		int rank = shape == null ? 0 : shape.length;

		if (rank > 0 && shape[0] > 0) {
			out.append(shape[0]);
		}
		for (int i = 1; i < rank; i++) {
			out.append(", " + shape[i]);
		}
		out.append(']');

		return out.toString();
	}
	
	@Override
	public void setErrors(Serializable errors) {
		throw new RuntimeException("setLazyErrors is unimplemented for "+getClass().getSimpleName());
	}
	
	@Override
	public ILazyDataset getErrors() {
		return null;
	}

}
