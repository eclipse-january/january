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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class to run over a pair of datasets in parallel with NumPy broadcasting to promote shapes
 * which have lower rank and outputs to a third dataset
 */
public class BroadcastIterator extends IndexIterator {
	private int[] maxShape;
	private int[] aShape;
	private int[] bShape;
	private final Dataset aDataset;
	private final Dataset bDataset;
	private final Dataset oDataset;
	private int[] aStride;
	private int[] bStride;
	private int[] oStride;

	final private int endrank;

	/**
	 * position in dataset
	 */
	private final int[] pos;
	private final int[] aDelta, bDelta;
	private final int[] oDelta; // this being non-null means output is different from inputs
	private final int aStep, bStep, oStep;
	private int aMax, bMax;
	private int aStart, bStart, oStart;
	private final boolean outputA;
	private final boolean outputB;

	/**
	 * Index in array
	 */
	public int aIndex, bIndex, oIndex;

	/**
	 * Current value in array
	 */
	public double aDouble, bDouble;

	/**
	 * Current value in array
	 */
	public long aLong, bLong;

	private boolean asDouble = true;

	/**
	 * 
	 * @param a
	 * @param b
	 */
	public BroadcastIterator(Dataset a, Dataset b) {
		this(a, b, null, false);
	}

	/**
	 * @param a
	 * @param b
	 * @param o (can be null for new dataset, a or b)
	 */
	public BroadcastIterator(Dataset a, Dataset b, Dataset o) {
		this(a, b, o, false);
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @param o (can be null for new dataset, a or b)
	 * @param createIfNull
	 */
	public BroadcastIterator(Dataset a, Dataset b, Dataset o, boolean createIfNull) {
		List<int[]> fullShapes = broadcastShapes(a.getShapeRef(), b.getShapeRef(), o == null ? null : o.getShapeRef());

		checkItemSize(a, b, o);

		maxShape = fullShapes.remove(0);

		oStride = null;
		if (o != null && !Arrays.equals(maxShape, o.getShapeRef())) {
			throw new IllegalArgumentException("Output does not match broadcasted shape");
		}
		aShape = fullShapes.remove(0);
		bShape = fullShapes.remove(0);

		int rank = maxShape.length;
		endrank = rank - 1;

		aDataset = a.reshape(aShape);
		bDataset = b.reshape(bShape);
		aStride = AbstractDataset.createBroadcastStrides(aDataset, maxShape);
		bStride = AbstractDataset.createBroadcastStrides(bDataset, maxShape);
		outputA = o == a;
		outputB = o == b;
		if (outputA) {
			oStride = aStride;
			oDelta = null;
			oStep = 0;
			oDataset = aDataset;
		} else if (outputB) {
			oStride = bStride;
			oDelta = null;
			oStep = 0;
			oDataset = bDataset;
		} else if (o != null) {
			oStride = AbstractDataset.createBroadcastStrides(o, maxShape);
			oDelta = new int[rank];
			oStep = o.getElementsPerItem();
			oDataset = o;
		} else if (createIfNull) {
			oDataset = createDataset(a, b, maxShape);
			oStride = AbstractDataset.createBroadcastStrides(oDataset, maxShape);
			oDelta = new int[rank];
			oStep = oDataset.getElementsPerItem();
		} else {
			oDelta = null;
			oStep = 0;
			oDataset = o;
		}

		pos = new int[rank];
		aDelta = new int[rank];
		aStep = aDataset.getElementsPerItem();
		bDelta = new int[rank];
		bStep = bDataset.getElementsPerItem();
		for (int j = endrank; j >= 0; j--) {
			aDelta[j] = aStride[j] * aShape[j];
			bDelta[j] = bStride[j] * bShape[j];
			if (oDelta != null) {
				oDelta[j] = oStride[j] * maxShape[j];
			}
		}
		if (endrank < 0) {
			aMax = aStep;
			bMax = bStep;
		} else {
			aMax = Integer.MIN_VALUE; // use max delta
			bMax = Integer.MIN_VALUE;
			for (int j = endrank; j >= 0; j--) {
				if (aDelta[j] > aMax) {
					aMax = aDelta[j];
				}
				if (bDelta[j] > bMax) {
					bMax = bDelta[j];
				}
			}
		}
		aStart = aDataset.getOffset();
		aMax += aStart;
		bStart = bDataset.getOffset();
		bMax += bStart;
		oStart = oDelta == null ? 0 : oDataset.getOffset();
		asDouble = aDataset.hasFloatingPointElements() || bDataset.hasFloatingPointElements();
		reset();
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

	private static Dataset createDataset(final Dataset a, final Dataset b, final int[] shape) {
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

	@Override
	public int[] getShape() {
		return maxShape;
	}

	@Override
	public boolean hasNext() {
		int j = endrank;
		int oldA = aIndex;
		int oldB = bIndex;
		for (; j >= 0; j--) {
			pos[j]++;
			aIndex += aStride[j];
			bIndex += bStride[j];
			if (oDelta != null)
				oIndex += oStride[j];
			if (pos[j] >= maxShape[j]) {
				pos[j] = 0;
				aIndex -= aDelta[j]; // reset these dimensions
				bIndex -= bDelta[j];
				if (oDelta != null)
					oIndex -= oDelta[j];
			} else {
				break;
			}
		}
		if (j == -1) {
			if (endrank >= 0) {
				aIndex = aMax;
				bIndex = bMax;
				return false;
			}
			aIndex += aStep;
			bIndex += bStep;
			if (oDelta != null)
				oIndex += oStep;
		}
		if (outputA) {
			oIndex = aIndex;
		} else if (outputB) {
			oIndex = bIndex;
		}

		if (aIndex == aMax || bIndex == bMax)
			return false;

		if (oldA != aIndex) {
			if (asDouble) {
				aDouble = aDataset.getElementDoubleAbs(aIndex);
			} else {
				aLong = aDataset.getElementLongAbs(aIndex);
			}
		}
		if (oldB != bIndex) {
			if (asDouble) {
				bDouble = bDataset.getElementDoubleAbs(bIndex);
			} else {
				bLong = bDataset.getElementLongAbs(bIndex);
			}
		}

		return true;
	}

	/**
	 * @return shape of first broadcasted dataset
	 */
	public int[] getFirstShape() {
		return aShape;
	}

	/**
	 * @return shape of second broadcasted dataset
	 */
	public int[] getSecondShape() {
		return bShape;
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

	@Override
	public void reset() {
		for (int i = 0; i <= endrank; i++)
			pos[i] = 0;

		if (endrank >= 0) {
			pos[endrank] = -1;
			aIndex = aStart - aStride[endrank];
			bIndex = bStart - bStride[endrank];
			oIndex = oStart - (oStride == null ? 0 : oStride[endrank]);
		} else {
			aIndex = aStart - aStep;
			bIndex = bStart - bStep;
			oIndex = oStart - oStep;
		}

		if (aIndex == 0 || bIndex == 0) { // for zero-ranked datasets
			storeCurrentValues();
			if (aMax == aIndex)
				aMax++;
			if (bMax == bIndex)
				bMax++;
		}
	}

	private void storeCurrentValues() {
		if (aIndex >= 0) {
			if (asDouble) {
				aDouble = aDataset.getElementDoubleAbs(aIndex);
			} else {
				aLong = aDataset.getElementLongAbs(aIndex);
			}
		}
		if (bIndex >= 0) {
			if (asDouble) {
				bDouble = bDataset.getElementDoubleAbs(bIndex);
			} else {
				bLong = bDataset.getElementLongAbs(bIndex);
			}
		}
	}
}
