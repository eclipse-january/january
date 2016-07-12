package org.eclipse.january.dataset;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ShapeUtils {

	private ShapeUtils() {
	}

	/**
	 * Calculate total number of items in given shape
	 * @param shape
	 * @return size
	 */
	public static long calcLongSize(final int[] shape) {
		double dsize = 1.0;
	
		if (shape == null || shape.length == 0)  // special case of zero-rank shape 
			return 1;
	
		for (int i = 0; i < shape.length; i++) {
			// make sure the indexes isn't zero or negative
			if (shape[i] == 0) {
				return 0;
			} else if (shape[i] < 0) {
				throw new IllegalArgumentException(String.format(
						"The %d-th is %d which is an illegal argument as it is negative", i, shape[i]));
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
		if (oshape == null || oshape.length == 0) {
			return new int[0];
		}
		int rank = oshape.length;
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
	 * @return shape
	 */
	public static int[] getShapeFromObject(final Object obj) {
		ArrayList<Integer> lshape = new ArrayList<Integer>();
	
		getShapeFromObj(lshape, obj, 0);
		if (obj != null && lshape.size() == 0) {
			return new int[0]; // cope with a single item
		}
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
		if (shape == null || shape.length == 0)
			return new int[0];
	
		int rank = shape.length;
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

	
}
