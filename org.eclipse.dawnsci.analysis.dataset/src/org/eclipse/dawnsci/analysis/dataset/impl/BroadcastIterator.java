/*-
 * Copyright 2015 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.dataset.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Base class for broadcast iterators. For speed, there are public members. Note, index is not updated
 */
public abstract class BroadcastIterator extends IndexIterator {

	public static BroadcastIterator createIterator(Dataset a, Dataset b) {
		return createIterator(a, b, null, false);
	}

	public static BroadcastIterator createIterator(Dataset a, Dataset b, Dataset o) {
		return createIterator(a, b, o, false);
	}

	public static BroadcastIterator createIterator(Dataset a, Dataset b, Dataset o, boolean createIfNull) {
		if (Arrays.equals(a.getShapeRef(), b.getShapeRef()) && a.getStrides() == null && b.getStrides() == null) {
			if (o == null || (o.getStrides() == null && Arrays.equals(a.getShapeRef(), o.getShapeRef()))) {
				return new ContiguousPairIterator(a, b, o, createIfNull);
			}
		}
		return new BroadcastPairIterator(a, b, o, createIfNull);
	}

	/**
	 * Calculate shapes for broadcasting
	 * @param oldShape
	 * @param size
	 * @param newShape
	 * @return broadcasted shape and full new shape or null if it cannot be done
	 */
	public static int[][] calcBroadcastShapes(int[] oldShape, int size, int... newShape) {
		if (newShape == null)
			return null;
	
		int brank = newShape.length;
		if (brank == 0) {
			if (size == 1)
				return new int[][] {oldShape, newShape};
			return null;
		}
	
		if (Arrays.equals(oldShape, newShape))
			return new int[][] {oldShape, newShape};

		int offset = brank - oldShape.length;
		if (offset < 0) { // when new shape is incomplete
			newShape = padShape(newShape, -offset);
			offset = 0;
		}

		int[] bshape;
		if (offset > 0) { // new shape has extra dimensions
			bshape = padShape(oldShape, offset);
		} else {
			bshape = oldShape;
		}

		for (int i = 0; i < brank; i++) {
			if (newShape[i] != bshape[i] && bshape[i] != 1 && newShape[i] != 1) {
				return null;
			}
		}

		return new int[][] {bshape, newShape};
	}

	/**
	 * Pad shape by prefixing with ones
	 * @param shape
	 * @param padding
	 * @return new shape or old shape if padding is zero
	 */
	public static int[] padShape(final int[] shape, final int padding) {
		if (padding < 0)
			throw new IllegalArgumentException("Padding must be zero or greater");

		if (padding == 0)
			return shape;

		final int total = shape.length + padding;
		final int[] nshape = new int[total];

		int i = 0;
		while (i < padding)
			nshape[i++] = 1;

		i--;
		while (++i < total)
			nshape[i] = shape[i-padding];

		return nshape;
	}

	/**
	 * Create a broadcasting stride array from dataset and slice information
	 * @param isize
	 * @param oShape original shape
	 * @param oStride original stride
	 * @param oOffset original offset (only used if there is an original stride)
	 * @param bShape broadcast shape
	 * @param stride output stride
	 * @param offset output offset
	 * @return new shape
	 */
	public static int[] createStrides(final int isize, final int[] oShape, final int[] oStride, final int oOffset, final int[] bShape, final int[] stride, final int[] offset) {
		final int rank = bShape.length;
		int pad = rank - oShape.length;
		if (pad < 0) {
			throw new IllegalArgumentException("Broadcast rank must be greater than or equal to original rank");
		}

		final int[] shape = padShape(oShape, pad);

		if (oStride == null) {
			int s = isize;
			offset[0] += 0;
			for (int j = rank - 1; j >= 0; j--) {
				stride[j] = s;
				offset[0] += 0;
				s *= shape[j];
			}
		} else {
			offset[0] = oOffset;
			for (int j = 0; j < rank; j++) {
				int s = oStride[j];
				stride[j] = s;
				offset[0] += 0;
			}
		}

		return null;
	}

	/**
	 * Take in shapes and broadcast them to same rank
	 * @param shapes
	 * @return list of broadcasted shapes plus the first entry is the maximum shape
	 */
	public static List<int[]> broadcastShapes(int[]... shapes) {
		int maxRank = -1;
		for (int[] s : shapes) {
			if (s == null)
				continue;

			int r = s.length;
			if (r > maxRank) {
				maxRank = r;
			}
		}

		List<int[]> newShapes = new ArrayList<int[]>();
		for (int[] s : shapes) {
			if (s == null)
				continue;
			newShapes.add(padShape(s, maxRank - s.length));
		}

		int[] maxShape = new int[maxRank];
		for (int i = 0; i < maxRank; i++) {
			int m = -1;
			for (int[] s : newShapes) {
				int l = s[i];
				if (l > m) {
					if (m > 1) {
						throw new IllegalArgumentException("A shape's dimension was not one or equal to maximum");
					}
					m = l;
				}
			}
			maxShape[i] = m;
		}
		newShapes.add(0, maxShape);
		return newShapes;
	}

	/**
	 * Take in shapes and broadcast them to maximum shape
	 * @param maxShape
	 * @param shapes
	 * @return list of broadcasted shapes
	 */
	public static List<int[]> broadcastShapesToMax(int[] maxShape, int[]... shapes) {
		int maxRank = maxShape.length;
		for (int[] s : shapes) {
			if (s == null)
				continue;

			int r = s.length;
			if (r > maxRank) {
				throw new IllegalArgumentException("A shape exceeds given rank of maximum shape");
			}
		}

		List<int[]> newShapes = new ArrayList<int[]>();
		for (int[] s : shapes) {
			if (s == null)
				continue;
			newShapes.add(padShape(s, maxRank - s.length));
		}

		for (int i = 0; i < maxRank; i++) {
			int m = maxShape[i];
			for (int[] s : newShapes) {
				int l = s[i];
				if (l > m) {
					throw new IllegalArgumentException("A shape's dimension was not one or equal to maximum");
				}
			}
		}
		return newShapes;
	}

	protected static Dataset createDataset(final Dataset a, final Dataset b, final int[] shape) {
		final int rt;
		final int ar = a.getRank();
		final int br = b.getRank();
		final int tt = AbstractDataset.getBestDType(a.getDtype(), b.getDtype());
		if (ar == 0 ^ br == 0) { // ignore type of zero-rank dataset unless it's floating point 
			if (ar == 0) {
				rt = a.hasFloatingPointElements() ? tt : b.getDtype();
			} else {
				rt = b.hasFloatingPointElements() ? tt : a.getDtype();
			}
		} else {
			rt = tt;
		}
		final int ia = a.getElementsPerItem();
		final int ib = b.getElementsPerItem();

		return DatasetFactory.zeros(ia > ib ? ia : ib, shape, rt);
	}

	private static void checkItemSize(Dataset a, Dataset b, Dataset o) {
		final int isa = a.getElementsPerItem();
		final int isb = b.getElementsPerItem();
		if (isa != isb && isa != 1 && isb != 1) {
			// exempt single-value dataset case too
			if ((isa == 1 || b.getSize() != 1) && (isb == 1 || a.getSize() != 1) ) {
				throw new IllegalArgumentException("Can not broadcast where number of elements per item mismatch and one does not equal another");
			}
		}
		if (o != null && o.getDtype() != Dataset.BOOL) {
			final int ism = Math.max(isa, isb);
			final int iso = o.getElementsPerItem();
			if (iso != ism && ism != 1) {
				throw new IllegalArgumentException("Can not output to dataset whose number of elements per item mismatch inputs'");
			}
		}
	}

	/**
	 * Index in first dataset
	 */
	public int aIndex;
	/**
	 * Index in second dataset
	 */
	public int bIndex;
	/**
	 * Index in output dataset
	 */
	public int oIndex;
	/**
	 * Current value in first dataset
	 */
	public double aDouble;
	/**
	 * Current value in second dataset
	 */
	public double bDouble;
	/**
	 * Current value in first dataset
	 */
	public long aLong;
	/**
	 * Current value in second dataset
	 */
	public long bLong;

	protected boolean asDouble = true;

	/**
	 * position in dataset
	 */
	protected int[] pos;

	/**
	 * Output dataset
	 */
	protected Dataset oDataset;

	protected Dataset aDataset;
	protected Dataset bDataset;
	final protected boolean outputA;
	final protected boolean outputB;

	protected BroadcastIterator(Dataset a, Dataset b, Dataset o) {
		aDataset = a;
		bDataset = b;
		oDataset = o;
		outputA = a == o;
		outputB = b == o;
		checkItemSize(a, b, o);
	}

	/**
	 * @return output dataset (can be null)
	 */
	public Dataset getOutput() {
		return oDataset;
	}

	@Override
	public int[] getPos() {
		return pos;
	}

	/**
	 * @return true if output from iterator is double
	 */
	public boolean isOutputDouble() {
		return asDouble;
	}

	/**
	 * Set to output doubles
	 * @param asDouble
	 */
	public void setOutputDouble(boolean asDouble) {
		if (this.asDouble != asDouble) {
			this.asDouble = asDouble;
			storeCurrentValues();
		}
	}

	/**
	 * Read and store current values
	 */
	abstract protected void storeCurrentValues();

}