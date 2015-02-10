/*-
 * Copyright (c) 2014 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.api.dataset;

import java.util.Arrays;

/**
 * Class to represent a slice through all dimensions of a multi-dimensional dataset. A slice
 * comprises a starting position array, a stopping position array (not included) and a stepping size array.
 */
public class SliceND {
	private int[] lstart;
	private int[] lstop;
	private int[] lstep;
	private int[] lshape;
	private int[] oshape;

	private boolean allData;

	/**
	 * Construct ND slice for whole of shape
	 * @param shape
	 */
	public SliceND(final int[] shape) {
		final int rank = shape.length;
		lstart = new int[rank];
		lstop  = shape.clone();
		lstep  = new int[rank];
		Arrays.fill(lstep, 1);
		lshape = shape.clone();
		oshape = shape.clone();
		allData = true;
	}

	/**
	 * Construct ND slice from an array of 1D slices
	 * @param shape
	 * @param slice
	 */
	public SliceND(final int[] shape, Slice... slice) {
		this(shape);

		if (slice != null) {
			final int length = slice.length;
			final int rank = shape.length;
			if (length > rank) {
				throw new IllegalArgumentException("More slices have been specified than rank of shape");
			}
			for (int i = 0; i < length; i++) {
				Slice s = slice[i];
				if (s != null) {
					int d = s.getStep();
					int b = s.getStart() == null ? (d > 0 ? 0 : oshape[i] - 1) : s.getStart();
					int e = s.getStop() == null ? (d > 0 ? oshape[i] : -oshape[i] - 1) : s.getStop();
					internalSetSlice(i, b, e, d);
				}
			}
		}

		checkAllData();
	}

	/**
	 * Construct ND slice parameters
	 * 
	 * @param shape
	 * @param start
	 *            can be null
	 * @param stop
	 *            can be null
	 * @param step
	 *            can be null
	 */
	public SliceND(final int[] shape, final int[] start, final int[] stop, final int[] step) {
		// number of steps, or new shape, taken in each dimension is
		// shape = (stop - start + step - 1) / step if step > 0
		// (stop - start + step + 1) / step if step < 0
		//
		// thus the final index in each dimension is
		// start + (shape-1)*step

		int rank = shape.length;

		if (start == null) {
			lstart = new int[rank];
		} else {
			lstart = start.clone();
		}
		if (stop == null) {
			lstop = shape.clone();
		} else {
			lstop = stop.clone();
		}
		if (step == null) {
			lstep = new int[rank];
			Arrays.fill(lstep, 1);
		} else {
			lstep = step.clone();
		}
		
		if (lstart.length != rank || lstop.length != rank || lstep.length != rank) {
			throw new IllegalArgumentException("No of indexes does not match data dimensions: you passed it start="
					+ lstart.length + ", stop=" + lstop.length + ", step=" + lstep.length + ", and it needs " + rank);
		}

		lshape = new int[rank];
		oshape = shape.clone();

		for (int i = 0; i < rank; i++) {
			final int d = lstep[i];
			final int s = shape[i];
			internalSetSlice(i, d > 0 || start != null ? lstart[i] : s - 1, d > 0 || stop != null ? lstop[i] : -s - 1, d);
		}

		checkAllData();
	}

	private void checkAllData() {
		allData = Arrays.equals(oshape, lshape);
		if (allData) {
			for (int i = 0; i < oshape.length; i++) {
				if (lstep[i] < 0) {
					allData = false;
					break;
				}
			}
		}
	}

	/**
	 * Set slice for given dimension
	 * @param i dimension
	 * @param start can be null to imply start of dimension
	 * @param stop can be null to imply end of dimension
	 * @param step
	 */
	public void setSlice(int i, Integer start, Integer stop, int step) {
		int b = start == null ? (step > 0 ? 0 : oshape[i] - 1) : start;
		int e = stop == null ? (step > 0 ? oshape[i] : -oshape[i] - 1) : stop;
		setSlice(i, b, e, step);
	}

	/**
	 * Set slice for given dimension
	 * @param i dimension
	 * @param start
	 * @param stop
	 * @param step
	 */
	public void setSlice(int i, int start, int stop, int step) {
		internalSetSlice(i, start, stop, step);
		checkAllData();
	}

	
	/**
	 * Set slice for given dimension
	 * @param i dimension
	 * @param start
	 * @param stop
	 * @param step
	 */
	private void internalSetSlice(int i, int start, int stop, int step) {
		if (step == 0) {
			throw new IllegalArgumentException("Step size must not be zero");
		}
		final int s = oshape[i];
		if (start < 0) {
			start += s;
		}
		if (step > 0) {
			if (start < 0) {
				start = 0;
			} else if (start > s) {
				start = s;
			}
			if (stop < 0) {
				stop += s;
			}
			if (stop < 0) {
				stop = 0;
			} else if (stop > s) {
				stop = s;
			}
			if (start >= stop) {
				lstop[i] = start;
				lshape[i] = 0;
			} else {
				lstop[i] = stop;
				lshape[i] = (stop - start - 1) / step + 1;
			}
		} else {
			if (start < 0) {
				start = -1;
			} else if (start >= s) {
				start = s - 1;
			}
			if (stop < 0) {
				stop += s;
			}
			if (stop < -1) {
				stop = -1;
			} else if (stop >= s) {
				stop = s - 1;
			}
			if (stop >= start) {
				lstop[i] = start;
				lshape[i] = 0;
			} else {
				lstop[i] = stop;
				lshape[i] = (stop - start + 1) / step + 1;
			}
		}

		lstart[i] = start;
		lstep[i] = step;
	}

	/**
	 * @return shape of source dataset
	 */
	public int[] getSourceShape() {
		return oshape;
	}

	/**
	 * @return resulting shape
	 */
	public int[] getShape() {
		return lshape;
	}

	public int[] getStart() {
		return lstart;
	}

	public int[] getStop() {
		return lstop;
	}

	public int[] getStep() {
		return lstep;
	}

	public boolean isAll() {
		return allData;
	}

	/**
	 * Convert to a slice array
	 * @return a slice array
	 */
	public Slice[] convertToSlice() {
		int orank = lshape.length;

		Slice[] slice = new Slice[orank];

		for (int j = 0; j < orank; j++) {
			slice[j] = new Slice(lstart[j], lstop[j], lstep[j]);
		}

		return slice;
	}

	@Override
	public String toString() {
		final int rank = lshape.length;
		if (rank == 0) {
			return "";
		}
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < rank; i++) {
			Slice.appendSliceToString(s, oshape[i], lstart[i], lstop[i], lstep[i]);
			s.append(',');
		}
	
		return s.substring(0, s.length()-1);
	}
}