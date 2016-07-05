/*-
 * Copyright 2016 Diamond Light Source Ltd.
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

public final class BroadcastUtils {

	/**
	 * Calculate shapes for broadcasting
	 * @param oldShape
	 * @param size
	 * @param newShape
	 * @return broadcasted shape and full new shape or null if it cannot be done
	 */
	public static int[][] calculateBroadcastShapes(int[] oldShape, int size, int... newShape) {
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
	
		final int[] nshape = new int[shape.length + padding];
		Arrays.fill(nshape, 1);
		System.arraycopy(shape, 0, nshape, padding, shape.length);
		return nshape;
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

	static Dataset createDataset(final Dataset a, final Dataset b, final int[] shape) {
		final int rt;
		final int ar = a.getRank();
		final int br = b.getRank();
		final int tt = DTypeUtils.getBestDType(a.getDType(), b.getDType());
		if (ar == 0 ^ br == 0) { // ignore type of zero-rank dataset unless it's floating point 
			if (ar == 0) {
				rt = a.hasFloatingPointElements() ? tt : b.getDType();
			} else {
				rt = b.hasFloatingPointElements() ? tt : a.getDType();
			}
		} else {
			rt = tt;
		}
		final int ia = a.getElementsPerItem();
		final int ib = b.getElementsPerItem();
	
		return DatasetFactory.zeros(ia > ib ? ia : ib, shape, rt);
	}

	static void checkItemSize(Dataset a, Dataset b, Dataset o) {
		final int isa = a.getElementsPerItem();
		final int isb = b.getElementsPerItem();
		if (isa != isb && isa != 1 && isb != 1) {
			// exempt single-value dataset case too
			if ((isa == 1 || b.getSize() != 1) && (isb == 1 || a.getSize() != 1) ) {
				throw new IllegalArgumentException("Can not broadcast where number of elements per item mismatch and one does not equal another");
			}
		}
		if (o != null && o.getDType() != Dataset.BOOL) {
			final int ism = Math.max(isa, isb);
			final int iso = o.getElementsPerItem();
			if (iso != ism && ism != 1) {
				throw new IllegalArgumentException("Can not output to dataset whose number of elements per item mismatch inputs'");
			}
		}
	}

	/**
	 * Create a stride array from a dataset to a broadcast shape
	 * @param a dataset
	 * @param broadcastShape
	 * @return stride array
	 */
	public static int[] createBroadcastStrides(Dataset a, final int[] broadcastShape) {
		return createBroadcastStrides(a.getElementsPerItem(), a.getShapeRef(), a.getStrides(), broadcastShape);
	}

	/**
	 * Create a stride array from a dataset to a broadcast shape
	 * @param isize
	 * @param oShape original shape
	 * @param oStride original stride
	 * @param broadcastShape
	 * @return stride array
	 */
	public static int[] createBroadcastStrides(final int isize, final int[] oShape, final int[] oStride, final int[] broadcastShape) {
		int rank = oShape.length;
		if (broadcastShape.length != rank) {
			throw new IllegalArgumentException("Dataset must have same rank as broadcast shape");
		}
	
		int[] stride = new int[rank];
		if (oStride == null) {
			int s = isize;
			for (int j = rank - 1; j >= 0; j--) {
				if (broadcastShape[j] == oShape[j]) {
					stride[j] = s;
					s *= oShape[j];
				} else {
					stride[j] = 0;
				}
			}
		} else {
			for (int j = 0; j < rank; j++) {
				if (broadcastShape[j] == oShape[j]) {
					stride[j] = oStride[j];
				} else {
					stride[j] = 0;
				}
			}
		}
	
		return stride;
	}

	/**
	 * Converts and broadcast all objects as datasets of same shape
	 * @param objects
	 * @return all as broadcasted to same shape
	 */
	public static Dataset[] convertAndBroadcast(Object... objects) {
		final int n = objects.length;

		Dataset[] datasets = new Dataset[n];
		int[][] shapes = new int[n][];
		for (int i = 0; i < n; i++) {
			Dataset d = DatasetFactory.createFromObject(objects[i]);
			datasets[i] = d;
			shapes[i] = d.getShapeRef();
		}

		List<int[]> nShapes = BroadcastUtils.broadcastShapes(shapes);
		int[] mshape = nShapes.get(0);
		for (int i = 0; i < n; i++) {
			datasets[i] = datasets[i].getBroadcastView(mshape);
		}

		return datasets;
	}
}
