/*******************************************************************************
 * Copyright (c) 2016 Diamond Light Source Ltd. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Diamond Light Source Ltd - initial API and implementation
 *******************************************************************************/
package org.eclipse.january.dataset;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class ShapeUtils {

	private ShapeUtils() {
	}

	/**
	 * Calculate total number of items in given shape
	 * @param shape
	 * @return size
	 */
	public static long calcLongSize(final int[] shape) {
		if (shape == null) { // special case of null-shaped
			return 0;
		}

		final int rank = shape.length;
		if (rank == 0) { // special case of zero-rank shape 
			return 1;
		}
	
		double dsize = 1.0;
		for (int i = 0; i < rank; i++) {
			// make sure the indexes isn't zero or negative
			if (shape[i] == 0) {
				return 0;
			} else if (shape[i] < 0) {
				throw new IllegalArgumentException(String.format(
						"The %d-th is %d which is not allowed as it is negative", i, shape[i]));
			}
	
			dsize *= shape[i];
		}
	
		// check to see if the size is larger than an integer, i.e. we can't allocate it
		if (dsize > Long.MAX_VALUE) {
			throw new IllegalArgumentException("Size of the dataset is too large to allocate");
		}
		return (long) dsize;
	}

	/**
	 * Calculate total number of items in given shape
	 * @param shape
	 * @return size
	 */
	public static int calcSize(final int[] shape) {
		long lsize = calcLongSize(shape);
	
		// check to see if the size is larger than an integer, i.e. we can't allocate it
		if (lsize > Integer.MAX_VALUE) {
			throw new IllegalArgumentException("Size of the dataset is too large to allocate");
		}
		return (int) lsize;
	}

	/**
	 * Check if shapes are broadcast compatible
	 * 
	 * @param ashape
	 * @param bshape
	 * @return true if they are compatible
	 */
	public static boolean areShapesBroadcastCompatible(final int[] ashape, final int[] bshape) {
		if (ashape == null || bshape == null) {
			return ashape == bshape;
		}

		if (ashape.length < bshape.length) {
			return areShapesBroadcastCompatible(bshape, ashape);
		}
	
		for (int a = ashape.length - bshape.length, b = 0; a < ashape.length && b < bshape.length; a++, b++) {
			if (ashape[a] != bshape[b] && ashape[a] != 1 && bshape[b] != 1) {
				return false;
			}
		}
	
		return true;
	}

	/**
	 * Check if shapes are compatible, ignoring extra axes of length 1
	 * 
	 * @param ashape
	 * @param bshape
	 * @return true if they are compatible
	 */
	public static boolean areShapesCompatible(final int[] ashape, final int[] bshape) {
		if (ashape == null || bshape == null) {
			return ashape == bshape;
		}

		List<Integer> alist = new ArrayList<Integer>();
	
		for (int a : ashape) {
			if (a > 1) alist.add(a);
		}
	
		final int imax = alist.size();
		int i = 0;
		for (int b : bshape) {
			if (b == 1)
				continue;
			if (i >= imax || b != alist.get(i++))
				return false;
		}
	
		return i == imax;
	}

	/**
	 * Check if shapes are compatible but skip axis
	 * 
	 * @param ashape
	 * @param bshape
	 * @param axis
	 * @return true if they are compatible
	 */
	public static boolean areShapesCompatible(final int[] ashape, final int[] bshape, final int axis) {
		if (ashape == null || bshape == null) {
			return ashape == bshape;
		}

		if (ashape.length != bshape.length) {
			return false;
		}
	
		final int rank = ashape.length;
		for (int i = 0; i < rank; i++) {
			if (i != axis && ashape[i] != bshape[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Remove dimensions of 1 in given shape - from both ends only, if true
	 * 
	 * @param oshape
	 * @param onlyFromEnds
	 * @return newly squeezed shape (or original if unsqueezed)
	 */
	public static int[] squeezeShape(final int[] oshape, boolean onlyFromEnds) {
		int unitDims = 0;
		int rank = oshape.length;
		int start = 0;
	
		if (onlyFromEnds) {
			int i = rank - 1;
			for (; i >= 0; i--) {
				if (oshape[i] == 1) {
					unitDims++;
				} else {
					break;
				}
			}
			for (int j = 0; j <= i; j++) {
				if (oshape[j] == 1) {
					unitDims++;
				} else {
					start = j;
					break;
				}
			}
		} else {
			for (int i = 0; i < rank; i++) {
				if (oshape[i] == 1) {
					unitDims++;
				}
			}
		}
	
		if (unitDims == 0) {
			return oshape;
		}
	
		int[] newDims = new int[rank - unitDims];
		if (unitDims == rank)
			return newDims; // zero-rank dataset
	
		if (onlyFromEnds) {
			rank = newDims.length;
			for (int i = 0; i < rank; i++) {
				newDims[i] = oshape[i+start];
			}
		} else {
			int j = 0;
			for (int i = 0; i < rank; i++) {
				if (oshape[i] > 1) {
					newDims[j++] = oshape[i];
					if (j >= newDims.length)
						break;
				}
			}
		}
	
		return newDims;
	}

	/**
	 * Remove dimension of 1 in given shape
	 * 
	 * @param oshape
	 * @param axis
	 * @return newly squeezed shape
	 */
	public static int[] squeezeShape(final int[] oshape, int axis) {
		if (oshape == null) {
			return null;
		}

		final int rank = oshape.length;
		if (rank == 0) {
			return new int[0];
		}
		if (axis < 0) {
			axis += rank;
		}
		if (axis < 0 || axis >= rank) {
			throw new IllegalArgumentException("Axis argument is outside allowed range");
		}
		int[] nshape = new int[rank-1];
		for (int i = 0; i < axis; i++) {
			nshape[i] = oshape[i];
		}
		for (int i = axis+1; i < rank; i++) {
			nshape[i-1] = oshape[i];
		}
		return nshape;
	}

	/**
	 * Get shape from object (array or list supported)
	 * @param obj
	 * @return shape can be null if obj is null
	 */
	public static int[] getShapeFromObject(final Object obj) {
		if (obj == null) {
			return null;
		}

		ArrayList<Integer> lshape = new ArrayList<Integer>();
		getShapeFromObj(lshape, obj, 0);

		final int rank = lshape.size();
		final int[] shape = new int[rank];
		for (int i = 0; i < rank; i++) {
			shape[i] = lshape.get(i);
		}
	
		return shape;
	}

	/**
	 * Get shape from object
	 * @param ldims
	 * @param obj
	 * @param depth
	 * @return true if there is a possibility of differing lengths
	 */
	private static boolean getShapeFromObj(final ArrayList<Integer> ldims, Object obj, int depth) {
		if (obj == null)
			return true;
	
		if (obj instanceof List<?>) {
			List<?> jl = (List<?>) obj;
			int l = jl.size();
			updateShape(ldims, depth, l);
			for (int i = 0; i < l; i++) {
				Object lo = jl.get(i);
				if (!getShapeFromObj(ldims, lo, depth + 1)) {
					break;
				}
			}
			return true;
		}
		Class<? extends Object> ca = obj.getClass().getComponentType();
		if (ca != null) {
			final int l = Array.getLength(obj);
			updateShape(ldims, depth, l);
			if (DTypeUtils.isClassSupportedAsElement(ca)) {
				return true;
			}
			for (int i = 0; i < l; i++) {
				Object lo = Array.get(obj, i);
				if (!getShapeFromObj(ldims, lo, depth + 1)) {
					break;
				}
			}
			return true;
		} else if (obj instanceof IDataset) {
			int[] s = ((IDataset) obj).getShape();
			for (int i = 0; i < s.length; i++) {
				updateShape(ldims, depth++, s[i]);
			}
			return true;
		} else {
			return false; // not an array of any type
		}
	}

	private static void updateShape(final ArrayList<Integer> ldims, final int depth, final int l) {
		if (depth >= ldims.size()) {
			ldims.add(l);
		} else if (l > ldims.get(depth)) {
			ldims.set(depth, l);
		}
	}

	/**
	 * Get n-D position from given index
	 * @param n index
	 * @param shape
	 * @return n-D position
	 */
	public static int[] getNDPositionFromShape(int n, int[] shape) {
		if (shape == null) {
			return null;
		}

		int rank = shape.length;
		if (rank == 0) {
			return new int[0];
		}

		if (rank == 1) {
			return new int[] { n };
		}

		int[] output = new int[rank];
		for (rank--; rank > 0; rank--) {
			output[rank] = n % shape[rank];
			n /= shape[rank];
		}
		output[0] = n;
	
		return output;
	}

	/**
	 * Get flattened view index of given position 
	 * @param shape
	 * @param pos
	 *            the integer array specifying the n-D position
	 * @return the index on the flattened dataset
	 */
	public static int getFlat1DIndex(final int[] shape, final int[] pos) {
		final int imax = pos.length;
		if (imax == 0) {
			return 0;
		}
	
		return AbstractDataset.get1DIndexFromShape(shape, pos);
	}

	/**
	 * This function takes a dataset and checks its shape against another dataset. If they are both of the same size,
	 * then this returns with no error, if there is a problem, then an error is thrown.
	 * 
	 * @param g
	 *            The first dataset to be compared
	 * @param h
	 *            The second dataset to be compared
	 * @throws IllegalArgumentException
	 *             This will be thrown if there is a problem with the compatibility
	 */
	public static void checkCompatibility(final ILazyDataset g, final ILazyDataset h) throws IllegalArgumentException {
		if (!areShapesCompatible(g.getShape(), h.getShape())) {
			throw new IllegalArgumentException("Shapes do not match");
		}
	}

	/**
	 * Check that axis is in range [-rank,rank)
	 * 
	 * @param rank
	 * @param axis
	 * @return sanitized axis in range [0, rank)
	 * @since 2.1
	 */
	public static int checkAxis(int rank, int axis) {
		if (axis < 0) {
			axis += rank;
		}
	
		if (axis < 0 || axis >= rank) {
			throw new IllegalArgumentException("Axis " + axis + " given is out of range [0, " + rank + ")");
		}
		return axis;
	}

	private static int[] convert(Collection<Integer> list) {
		int[] array = new int[list.size()];
		int i = 0;
		for (Integer l : list) {
			array[i++] = l;
		}
		return array;
	}

	/**
	 * Check that all axes are in range [-rank,rank)
	 * @param rank
	 * @param axes
	 * @return sanitized axes in range [0, rank) and sorted in increasing order
	 * @since 2.2
	 */
	public static int[] checkAxes(int rank, int... axes) {
		return convert(sanitizeAxes(rank, axes));
	}

	/**
	 * Check that all axes are in range [-rank,rank)
	 * @param rank
	 * @param axes
	 * @return sanitized axes in range [0, rank) and sorted in increasing order
	 * @since 2.2
	 */
	private static SortedSet<Integer> sanitizeAxes(int rank, int... axes) {
		SortedSet<Integer> nAxes = new TreeSet<>(); 
		for (int i = 0; i < axes.length; i++) {
			nAxes.add(checkAxis(rank, axes[i]));
		}

		return nAxes;
	}

	/**
	 * @param rank
	 * @param axes
	 * @return remaining axes not given by input
	 * @since 2.2
	 */
	public static int[] getRemainingAxes(int rank, int... axes) {
		SortedSet<Integer> nAxes = sanitizeAxes(rank, axes);

		int[] remains = new int[rank - axes.length];
		int j = 0;
		for (int i = 0; i < rank; i++) {
			if (!nAxes.contains(i)) {
				remains[j++] = i;
			}
		}
		return remains;
	}

	/**
	 * Remove axes from shape
	 * @param shape
	 * @param axes
	 * @return reduced shape
	 * @since 2.2
	 */
	public static int[] reduceShape(int[] shape, int... axes) {
		int[] remain = getRemainingAxes(shape.length, axes);
		for (int i = 0; i < remain.length; i++) {
			int a = remain[i];
			remain[i] = shape[a];
		}
		return remain;
	}

	/**
	 * Set reduced axes to 1
	 * @param shape
	 * @param axes
	 * @return shape with same rank
	 * @since 2.2
	 */
	public static int[] getReducedShapeKeepRank(int[] shape, int... axes) {
		int[] keep = shape.clone();
		axes = checkAxes(shape.length, axes);
		for (int i : axes) {
			keep[i] = 1;
		}
		return keep;
	}

	/**
	 * @param a
	 * @param b
	 * @return true if arrays only differs by unit entries
	 * @since 2.2
	 */
	public static boolean differsByOnes(int[] a, int[] b) {
		int aRank = a.length;
		int bRank = b.length;
		int ai = 0;
		int bi = 0;
		int al = 1;
		int bl = 1;
		do {
			while (ai < aRank && (al = a[ai++]) == 1) { // next non-unit dimension
			}
			while (bi < bRank && (bl = b[bi++]) == 1) {
			}
			if (al != bl) {
				return false;
			}
		} while (ai < aRank && bi < bRank);

		if (ai == aRank) {
			while (bi < bRank) {
				if (b[bi++] != 1) {
					return false;
				}
			}
		}
		if (bi == bRank) {
			while (ai < aRank) {
				if (a[ai++] != 1) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Calculate the padding difference between two shapes. Padding can be positive (negative)
	 * for added (removed) dimensions. NB positive or negative padding is given after matched
	 * dimensions
	 * @param aShape
	 * @param bShape
	 * @return padding can be null if shapes are equal
	 * @throws IllegalArgumentException if one shape is null but not the other, or if shapes do
	 * not possess common non-unit lengths
	 * @since 2.2
	 */
	public static int[] calcShapePadding(int[] aShape, int[] bShape) {
		if (Arrays.equals(aShape, bShape)) {
			return null;
		}

		if (aShape == null || bShape == null) {
			throw new IllegalArgumentException("If one shape is null then the other must be null too");
		}

		if (!differsByOnes(aShape, bShape)) {
			throw new IllegalArgumentException("Non-unit lengths in shapes must be equal");
		}
		int aRank = aShape.length;
		int bRank = bShape.length;

		int[] padding;
		if (aRank == 0 || bRank == 0) {
			padding = new int[1];
			padding[0] = aRank == 0 ? bRank : -aRank;
			return padding;
		}

		padding = new int[Math.max(aRank, bRank) + 2];
		int ai = 0;
		int bi = 0;
		int al = 0;
		int bl = 0;
		int pi = 0;
		int p;
		boolean aLeft = ai < aRank;
		boolean bLeft = bi < bRank;
		while (aLeft && bLeft) {
			if (aLeft) {
				al = aShape[ai++];
				aLeft = ai < aRank;
			}
			if (bLeft) {
				bl = bShape[bi++];
				bLeft = bi < bRank;
			}
			if (al != bl) {
				p = 0;
				while (al == 1 && aLeft) {
					al = aShape[ai++];
					aLeft = ai < aRank;
					p--;
				}
				while (bl == 1 && bLeft) {
					bl = bShape[bi++];
					bLeft = bi < bRank;
					p++;
				}
				padding[pi++] = p;
			}
			if (al == bl) {
				pi++;
			}
		}
		if (aLeft || bLeft) {
			p = 0;
			while (ai < aRank && aShape[ai++] == 1) {
				p--;
			}
			while (bi < bRank && bShape[bi++] == 1) {
				p++;
			}
			padding[pi++] = p;
		}

		return Arrays.copyOf(padding, pi);
	}

	static int[] padShape(int[] padding, int nr, int[] oldShape) {
		if (padding == null) {
			return oldShape.clone();
		}
		int or = oldShape.length;
		int[] newShape = new int[nr];
		int di = 0;
		for (int i = 0, si = 0; i < (or+1) && si <= or && di < nr; i++) {
			int c = padding[i];
			if (c == 0) {
				newShape[di++] = oldShape[si++];
			} else if (c > 0) {
				int dim = di + c;
				while (di < dim) {
					newShape[di++] = 1;
				}
			} else if (c < 0) {
				si -= c; // remove dimensions by skipping forward in source array (should check that they are unit entries)
			}
		}
		while (di < nr) {
			newShape[di++] = 1;
		}
		return newShape;
	}
}
