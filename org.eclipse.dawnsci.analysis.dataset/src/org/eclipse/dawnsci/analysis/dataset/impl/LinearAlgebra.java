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

import java.util.Arrays;
import java.util.List;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.CholeskyDecomposition;
import org.apache.commons.math3.linear.ConjugateGradient;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealLinearOperator;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.linear.SingularValueDecomposition;


public class LinearAlgebra {

	private static final int CROSSOVERPOINT = 16; // point at which using slice iterators for inner loop is faster 

	/**
	 * Calculate the tensor dot product over given axes. This is the sum of products of elements selected
	 * from the given axes in each dataset
	 * @param a
	 * @param b
	 * @param axisa axis dimension in a to sum over (can be -ve)
	 * @param axisb axis dimension in b to sum over (can be -ve)
	 * @return tensor dot product
	 */
	public static Dataset tensorDotProduct(final Dataset a, final Dataset b, final int axisa, final int axisb) {
		// this is slower for summing lengths < ~15
		final int[] ashape = a.getShapeRef();
		final int[] bshape = b.getShapeRef();
		final int arank = ashape.length;
		final int brank = bshape.length;
		int aaxis = axisa;
		if (aaxis < 0)
			aaxis += arank;
		if (aaxis < 0 || aaxis >= arank)
			throw new IllegalArgumentException("Summing axis outside valid rank of 1st dataset");

		if (ashape[aaxis] < CROSSOVERPOINT) { // faster to use position iteration
			return tensorDotProduct(a, b, new int[] {axisa}, new int[] {axisb});
		}
		int baxis = axisb;
		if (baxis < 0)
			baxis += arank;
		if (baxis < 0 || baxis >= arank)
			throw new IllegalArgumentException("Summing axis outside valid rank of 2nd dataset");

		final boolean[] achoice = new boolean[arank];
		final boolean[] bchoice = new boolean[brank];
		Arrays.fill(achoice, true);
		Arrays.fill(bchoice, true);
		achoice[aaxis] = false; // flag which axes not to iterate over
		bchoice[baxis] = false;

		final boolean[] notachoice = new boolean[arank];
		final boolean[] notbchoice = new boolean[brank];
		notachoice[aaxis] = true; // flag which axes to iterate over
		notbchoice[baxis] = true;

		int drank = arank + brank - 2;
		int[] dshape = new int[drank];
		int d = 0;
		for (int i = 0; i < arank; i++) {
			if (achoice[i])
				dshape[d++] = ashape[i];
		}
		for (int i = 0; i < brank; i++) {
			if (bchoice[i])
				dshape[d++] = bshape[i];
		}
		int dtype = AbstractDataset.getBestDType(a.getDtype(), b.getDtype());
		Dataset data = DatasetFactory.zeros(dshape, dtype);

		SliceIterator ita = a.getSliceIteratorFromAxes(null, achoice);
		int l = 0;
		final int[] apos = ita.getPos();
		while (ita.hasNext()) {
			SliceIterator itb = b.getSliceIteratorFromAxes(null, bchoice);
			final int[] bpos = itb.getPos();
			while (itb.hasNext()) {
				SliceIterator itaa = a.getSliceIteratorFromAxes(apos, notachoice);
				SliceIterator itba = b.getSliceIteratorFromAxes(bpos, notbchoice);
				double sum = 0.0;
				double com = 0.0;
				while (itaa.hasNext() && itba.hasNext()) {
					final double y = a.getElementDoubleAbs(itaa.index) * b.getElementDoubleAbs(itba.index) - com;
					final double t = sum + y;
					com = (t - sum) - y;
					sum = t;
				}
				data.setObjectAbs(l++, sum);
			}
		}

		return data;
	}

	/**
	 * Calculate the tensor dot product over given axes. This is the sum of products of elements selected
	 * from the given axes in each dataset
	 * @param a
	 * @param b
	 * @param axisa axis dimensions in a to sum over (can be -ve)
	 * @param axisb axis dimensions in b to sum over (can be -ve)
	 * @return tensor dot product
	 */
	public static Dataset tensorDotProduct(final Dataset a, final Dataset b, final int[] axisa, final int[] axisb) {
		if (axisa.length != axisb.length) {
			throw new IllegalArgumentException("Numbers of summing axes must be same");
		}
		final int[] ashape = a.getShapeRef();
		final int[] bshape = b.getShapeRef();
		final int arank = ashape.length;
		final int brank = bshape.length;
		final int[] aaxes = new int[axisa.length];
		final int[] baxes = new int[axisa.length];
		for (int i = 0; i < axisa.length; i++) {
			int n;

			n = axisa[i];
			if (n < 0) n += arank;
			if (n < 0 || n >= arank)
				throw new IllegalArgumentException("Summing axis outside valid rank of 1st dataset");
			aaxes[i] = n;

			n = axisb[i];
			if (n < 0) n += brank;
			if (n < 0 || n >= brank)
				throw new IllegalArgumentException("Summing axis outside valid rank of 2nd dataset");
			baxes[i] = n;

			if (ashape[aaxes[i]] != bshape[n])
				throw new IllegalArgumentException("Summing axes do not have matching lengths");
		}

		final boolean[] achoice = new boolean[arank];
		final boolean[] bchoice = new boolean[brank];
		Arrays.fill(achoice, true);
		Arrays.fill(bchoice, true);
		for (int i = 0; i < aaxes.length; i++) { // flag which axes to iterate over
			achoice[aaxes[i]] = false;
			bchoice[baxes[i]] = false;
		}

		int drank = arank + brank - 2*aaxes.length;
		int[] dshape = new int[drank];
		int d = 0;
		for (int i = 0; i < arank; i++) {
			if (achoice[i])
				dshape[d++] = ashape[i];
		}
		for (int i = 0; i < brank; i++) {
			if (bchoice[i])
				dshape[d++] = bshape[i];
		}
		int dtype = AbstractDataset.getBestDType(a.getDtype(), b.getDtype());
		Dataset data = DatasetFactory.zeros(dshape, dtype);

		SliceIterator ita = a.getSliceIteratorFromAxes(null, achoice);
		int l = 0;
		final int[] apos = ita.getPos();
		while (ita.hasNext()) {
			SliceIterator itb = b.getSliceIteratorFromAxes(null, bchoice);
			final int[] bpos = itb.getPos();
			while (itb.hasNext()) {
				double sum = 0.0;
				double com = 0.0;
				apos[aaxes[aaxes.length - 1]] = -1;
				bpos[baxes[aaxes.length - 1]] = -1;
				while (true) { // step through summing axes
					int e = aaxes.length - 1;
					for (; e >= 0; e--) {
						int ai = aaxes[e];
						int bi = baxes[e];

						apos[ai]++;
						bpos[bi]++;
						if (apos[ai] == ashape[ai]) {
							apos[ai] = 0;
							bpos[bi] = 0;
						} else
							break;
					}
					if (e == -1) break;
					final double y = a.getDouble(apos) * b.getDouble(bpos) - com;
					final double t = sum + y;
					com = (t - sum) - y;
					sum = t;
				}
				data.setObjectAbs(l++, sum);
			}
		}

		return data;
	}

	/**
	 * Calculate the dot product of two datasets. When <b>b</b> is a 1D dataset, the sum product over
	 * the last axis of <b>a</b> and <b>b</b> is returned. Where <b>a</b> is also a 1D dataset, a zero-rank dataset
	 * is returned. If <b>b</b> is 2D or higher, its second-to-last axis is used
	 * @param a
	 * @param b
	 * @return dot product
	 */
	public static Dataset dotProduct(Dataset a, Dataset b) {
		if (b.getRank() < 2)
			return tensorDotProduct(a, b, -1, 0);
		return tensorDotProduct(a, b, -1, -2);
	}

	/**
	 * Calculate the outer product of two datasets
	 * @param a
	 * @param b
	 * @return outer product
	 */
	public static Dataset outerProduct(Dataset a, Dataset b) {
		int[] as = a.getShapeRef();
		int[] bs = b.getShapeRef();
		int rank = as.length + bs.length;
		int[] shape = new int[rank];
		for (int i = 0; i < as.length; i++) {
			shape[i] = as[i];
		}
		for (int i = 0; i < bs.length; i++) {
			shape[as.length + i] = bs[i];
		}
		int isa = a.getElementsPerItem();
		int isb = b.getElementsPerItem();
		if (isa != 1 || isb != 1) {
			throw new UnsupportedOperationException("Compound datasets not supported");
		}
		Dataset o = DatasetFactory.zeros(shape, AbstractDataset.getBestDType(a.getDtype(), b.getDtype()));

		IndexIterator ita = a.getIterator();
		IndexIterator itb = b.getIterator();
		int j = 0;
		while (ita.hasNext()) {
			double va = a.getElementDoubleAbs(ita.index);
			while (itb.hasNext()) {
				o.setObjectAbs(j++, va * b.getElementDoubleAbs(itb.index));
			}
			itb.reset();
		}
		return o;
	}

	/**
	 * Calculate the cross product of two datasets. Datasets must be broadcastable and
	 * possess last dimensions of length 2 or 3
	 * @param a
	 * @param b
	 * @return cross product
	 */
	public static Dataset crossProduct(Dataset a, Dataset b) {
		return crossProduct(a, b, -1, -1, -1);
	}

	/**
	 * Calculate the cross product of two datasets. Datasets must be broadcastable and
	 * possess dimensions of length 2 or 3. The axis parameters can be negative to indicate
	 * dimensions from the end of their shapes
	 * @param a
	 * @param b
	 * @param axisA dimension to be used a vector (must have length of 2 or 3)
	 * @param axisB dimension to be used a vector (must have length of 2 or 3)
	 * @param axisC dimension to assign as cross-product
	 * @return cross product
	 */
	public static Dataset crossProduct(Dataset a, Dataset b, int axisA, int axisB, int axisC) {
		final int rankA = a.getRank();
		final int rankB = b.getRank();
		if (rankA == 0 || rankB == 0) {
			throw new IllegalArgumentException("Datasets must have one or more dimensions");
		}
		if (axisA < 0) {
			axisA += rankA;
		}
		if (axisA < 0 || axisA >= rankA) {
			throw new IllegalArgumentException("Axis A argument exceeds rank");
		}
		if (axisB < 0) {
			axisB += rankB;
		}
		if (axisB < 0 || axisB >= rankB) {
			throw new IllegalArgumentException("Axis B argument exceeds rank");
		}

		final int[] shapeA = a.getShape();
		final int[] shapeB = b.getShape();
		int la = shapeA[axisA];
		int lb = shapeB[axisB];
		if (Math.min(la,  lb) < 2 || Math.max(la, lb) > 3) {
			throw new IllegalArgumentException("Chosen dimension of A & B must be 2 or 3");
		}

		if (Math.max(la,  lb) == 2) {
			return crossProduct2D(a, b, axisA, axisB);
		}

		return crossProduct3D(a, b, axisA, axisB, axisC);
	}

	private static int[] removeAxisFromShape(int[] shape, int axis) {
		int[] s = new int[shape.length - 1];
		int i = 0;
		int j = 0;
		while (i < axis) {
			s[j++] = shape[i++];
		}
		i++;
		while (i < shape.length) {
			s[j++] = shape[i++];
		}
		return s;
	}

	// assume axes is in increasing order
	private static int[] removeAxesFromShape(int[] shape, int... axes) {
		int n = axes.length;
		int[] s = new int[shape.length - n];
		int i = 0;
		int j = 0;
		for (int k = 0; k < n; k++) {
			int a = axes[k];
			while (i < a) {
				s[j++] = shape[i++];
			}
			i++;
		}
		while (i < shape.length) {
			s[j++] = shape[i++];
		}
		return s;
	}

	private static int[] addAxisToShape(int[] shape, int axis, int length) {
		int[] s = new int[shape.length + 1];
		int i = 0;
		int j = 0;
		while (i < axis) {
			s[j++] = shape[i++];
		}
		s[j++] = length;
		while (i < shape.length) {
			s[j++] = shape[i++];
		}
		return s;
	}

	// assume axes is in increasing order
	private static int[] addAxesToShape(int[] shape, int[] axes, int[] lengths) {
		int n = axes.length;
		if (lengths.length != n) {
			throw new IllegalArgumentException("Axes and lengths arrays must be same size");
		}
		int[] s = new int[shape.length + n];
		int i = 0;
		int j = 0;
		for (int k = 0; k < n; k++) {
			int a = axes[k];
			while (i < a) {
				s[j++] = shape[i++];
			}
			s[j++] = lengths[k];
		}
		while (i < shape.length) {
			s[j++] = shape[i++];
		}
		return s;
	}

	private static Dataset crossProduct2D(Dataset a, Dataset b, int axisA, int axisB) {
		// need to broadcast and omit given axes
		int[] shapeA = removeAxisFromShape(a.getShapeRef(), axisA);
		int[] shapeB = removeAxisFromShape(b.getShapeRef(), axisB);

		List<int[]> fullShapes = BroadcastIterator.broadcastShapes(shapeA, shapeB);

		int[] maxShape = fullShapes.get(0);
		Dataset c = DatasetFactory.zeros(maxShape, AbstractDataset.getBestDType(a.getDtype(), b.getDtype()));

		PositionIterator ita = a.getPositionIterator(axisA);
		PositionIterator itb = b.getPositionIterator(axisB);
		IndexIterator itc = c.getIterator();

		final int[] pa = ita.getPos();
		final int[] pb = itb.getPos();
		while (itc.hasNext()) {
			if (!ita.hasNext()) // TODO use broadcasting...
				ita.reset();
			if (!itb.hasNext())
				itb.reset();
			pa[axisA] = 0;
			pb[axisB] = 1;
			double cv = a.getDouble(pa) * b.getDouble(pb);
			pa[axisA] = 1;
			pb[axisB] = 0;
			cv -= a.getDouble(pa) * b.getDouble(pb);

			c.setObjectAbs(itc.index, cv);
		}
		return c;
	}

	private static Dataset crossProduct3D(Dataset a, Dataset b, int axisA, int axisB, int axisC) {
		int[] shapeA = removeAxisFromShape(a.getShapeRef(), axisA);
		int[] shapeB = removeAxisFromShape(b.getShapeRef(), axisB);

		List<int[]> fullShapes = BroadcastIterator.broadcastShapes(shapeA, shapeB);

		int[] maxShape = fullShapes.get(0);
		int rankC = maxShape.length + 1;
		if (axisC < 0) {
			axisC += rankC;
		}
		if (axisC < 0 || axisC >= rankC) {
			throw new IllegalArgumentException("Axis C argument exceeds rank");
		}
		maxShape = addAxisToShape(maxShape, axisC, 3);
		Dataset c = DatasetFactory.zeros(maxShape, AbstractDataset.getBestDType(a.getDtype(), b.getDtype()));

		PositionIterator ita = a.getPositionIterator(axisA);
		PositionIterator itb = b.getPositionIterator(axisB);
		PositionIterator itc = c.getPositionIterator(axisC);

		final int[] pa = ita.getPos();
		final int[] pb = itb.getPos();
		final int[] pc = itc.getPos();
		final int la = a.getShapeRef()[axisA];
		final int lb = b.getShapeRef()[axisB];

		if (la == 2) {
			while (itc.hasNext()) {
				if (!ita.hasNext()) // TODO use broadcasting...
					ita.reset();
				if (!itb.hasNext())
					itb.reset();
				double cv;
				pa[axisA] = 1;
				pb[axisB] = 2;
				cv = a.getDouble(pa) * b.getDouble(pb);
				pc[axisC] = 0;
				c.set(cv, pc);

				pa[axisA] = 0;
				pb[axisB] = 2;
				cv = -a.getDouble(pa) * b.getDouble(pb);
				pc[axisC] = 1;
				c.set(cv, pc);

				pa[axisA] = 0;
				pb[axisB] = 1;
				cv = a.getDouble(pa) * b.getDouble(pb);
				pa[axisA] = 1;
				pb[axisB] = 0;
				cv -= a.getDouble(pa) * b.getDouble(pb);
				pc[axisC] = 2;
				c.set(cv, pc);
			}
		} else if (lb == 2) {
			while (itc.hasNext()) {
				if (!ita.hasNext()) // TODO use broadcasting...
					ita.reset();
				if (!itb.hasNext())
					itb.reset();
				double cv;
				pa[axisA] = 2;
				pb[axisB] = 1;
				cv = -a.getDouble(pa) * b.getDouble(pb);
				pc[axisC] = 0;
				c.set(cv, pc);

				pa[axisA] = 2;
				pb[axisB] = 0;
				cv = a.getDouble(pa) * b.getDouble(pb);
				pc[axisC] = 1;
				c.set(cv, pc);

				pa[axisA] = 0;
				pb[axisB] = 1;
				cv = a.getDouble(pa) * b.getDouble(pb);
				pa[axisA] = 1;
				pb[axisB] = 0;
				cv -= a.getDouble(pa) * b.getDouble(pb);
				pc[axisC] = 2;
				c.set(cv, pc);
			}
			
		} else {
			while (itc.hasNext()) {
				if (!ita.hasNext()) // TODO use broadcasting...
					ita.reset();
				if (!itb.hasNext())
					itb.reset();
				double cv;
				pa[axisA] = 1;
				pb[axisB] = 2;
				cv = a.getDouble(pa) * b.getDouble(pb);
				pa[axisA] = 2;
				pb[axisB] = 1;
				cv -= a.getDouble(pa) * b.getDouble(pb);
				pc[axisC] = 0;
				c.set(cv, pc);

				pa[axisA] = 2;
				pb[axisB] = 0;
				cv = a.getDouble(pa) * b.getDouble(pb);
				pa[axisA] = 0;
				pb[axisB] = 2;
				cv -= a.getDouble(pa) * b.getDouble(pb);
				pc[axisC] = 1;
				c.set(cv, pc);

				pa[axisA] = 0;
				pb[axisB] = 1;
				cv = a.getDouble(pa) * b.getDouble(pb);
				pa[axisA] = 1;
				pb[axisB] = 0;
				cv -= a.getDouble(pa) * b.getDouble(pb);
				pc[axisC] = 2;
				c.set(cv, pc);
			}
		}
		return c;
	}

	/**
	 * Raise dataset to given power by matrix multiplication
	 * @param a
	 * @param n power
	 * @return a ** n
	 */
	public static Dataset power(Dataset a, int n) {
		if (n < 0) {
			LUDecomposition lud = new LUDecomposition(createRealMatrix(a));
			return createDataset(lud.getSolver().getInverse().power(-n));
		}
		Dataset p = createDataset(createRealMatrix(a).power(n));
		if (!a.hasFloatingPointElements())
			return p.cast(a.getDtype());
		return p;
	}

	/**
	 * Create the Kronecker product as defined by 
	 * kron[k0,...,kN] = a[i0,...,iN] * b[j0,...,jN]
	 * where kn = sn * in + jn for n = 0...N and s is shape of b
	 * @param a
	 * @param b
	 * @return Kronecker product of a and b
	 */
	public static Dataset kroneckerProduct(Dataset a, Dataset b) {
		if (a.getElementsPerItem() != 1 || b.getElementsPerItem() != 1) {
			throw new UnsupportedOperationException("Compound datasets (including complex ones) are not currently supported");
		}
		int ar = a.getRank();
		int br = b.getRank();
		int[] aShape;
		int[] bShape;
		aShape = a.getShapeRef();
		bShape = b.getShapeRef();
		int r = ar;
		// pre-pad if ranks are not same
		if (ar < br) {
			r = br;
			int[] shape = new int[br];
			int j = 0;
			for (int i = ar; i < br; i++) {
				shape[j++] = 1;
			}
			int i = 0;
			while (j < br) {
				shape[j++] = aShape[i++];
			}
			a = a.reshape(shape);
			aShape = shape;
		} else if (ar > br) {
			int[] shape = new int[ar];
			int j = 0;
			for (int i = br; i < ar; i++) {
				shape[j++] = 1;
			}
			int i = 0;
			while (j < ar) {
				shape[j++] = bShape[i++];
			}
			b = b.reshape(shape);
			bShape = shape;
		}

		int[] nShape = new int[r];
		for (int i = 0; i < r; i++) {
			nShape[i] = aShape[i] * bShape[i];
		}
		Dataset kron = DatasetFactory.zeros(nShape, AbstractDataset.getBestDType(a.getDtype(), b.getDtype()));
		IndexIterator ita = a.getIterator(true);
		IndexIterator itb = b.getIterator(true);
		int[] pa = ita.getPos();
		int[] pb = itb.getPos();
		int[] off = new int[1];
		int[] stride = AbstractDataset.createStrides(1, nShape, null, 0, off);
		if (kron.getDtype() == Dataset.INT64) {
			while (ita.hasNext()) {
				long av = a.getElementLongAbs(ita.index);

				int ka = 0; 
				for (int i = 0; i < r; i++) {
					ka += stride[i] * bShape[i] * pa[i];
				}
				itb.reset();
				while (itb.hasNext()) {
					long bv = b.getElementLongAbs(itb.index);
					int kb = ka;
					for (int i = 0; i < r; i++) {
						kb += stride[i] * pb[i];
					}
					kron.setObjectAbs(kb, av * bv);
				}
			}
		} else {
			while (ita.hasNext()) {
				double av = a.getElementDoubleAbs(ita.index);

				int ka = 0; 
				for (int i = 0; i < r; i++) {
					ka += stride[i] * bShape[i] * pa[i];
				}
				itb.reset();
				while (itb.hasNext()) {
					double bv = b.getElementLongAbs(itb.index);
					int kb = ka;
					for (int i = 0; i < r; i++) {
						kb += stride[i] * pb[i];
					}
					kron.setObjectAbs(kb, av * bv);
				}
			}
		}

		return kron;
	}

	/**
	 * Calculate trace of dataset - sum of values over 1st axis and 2nd axis
	 * @param a
	 * @return trace of dataset
	 */
	public static Dataset trace(Dataset a) {
		return trace(a, 0, 0, 1);
	}

	/**
	 * Calculate trace of dataset - sum of values over axis1 and axis2 where axis2 is offset
	 * @param a
	 * @param offset
	 * @param axis1
	 * @param axis2
	 * @return trace of dataset
	 */
	public static Dataset trace(Dataset a, int offset, int axis1, int axis2) {
		int[] shape = a.getShapeRef();
		int[] axes = new int[] { a.checkAxis(axis1), a.checkAxis(axis2) };
		Arrays.sort(axes);
		int is = a.getElementsPerItem();
		Dataset trace = DatasetFactory.zeros(is, removeAxesFromShape(shape, axes), a.getDtype());

		int am = axes[0];
		int mmax = shape[am];
		int an = axes[1];
		int nmax = shape[an];
		PositionIterator it = new PositionIterator(shape, axes);
		int[] pos = it.getPos();
		int i = 0;
		int mmin;
		int nmin;
		if (offset >= 0) {
			mmin = 0;
			nmin = offset;
		} else {
			mmin = -offset;
			nmin = 0;
		}
		if (is == 1) {
			if (a.getDtype() == Dataset.INT64) {
				while (it.hasNext()) {
					int m = mmin;
					int n = nmin;
					long s = 0;
					while (m < mmax && n < nmax) {
						pos[am] = m++;
						pos[an] = n++;
						s += a.getLong(pos);
					}
					trace.setObjectAbs(i++, s);
				}
			} else {
				while (it.hasNext()) {
					int m = mmin;
					int n = nmin;
					double s = 0;
					while (m < mmax && n < nmax) {
						pos[am] = m++;
						pos[an] = n++;
						s += a.getDouble(pos);
					}
					trace.setObjectAbs(i++, s);
				}
			}
		} else {
			AbstractCompoundDataset ca = (AbstractCompoundDataset) a;
			if (ca instanceof CompoundLongDataset) {
				long[] t = new long[is];
				long[] s = new long[is];
				while (it.hasNext()) {
					int m = mmin;
					int n = nmin;
					Arrays.fill(s, 0);
					while (m < mmax && n < nmax) {
						pos[am] = m++;
						pos[an] = n++;
						((CompoundLongDataset)ca).getAbs(ca.get1DIndex(pos), t);
						for (int k = 0; k < is; k++) {
							s[k] += t[k];
						}
					}
					trace.setObjectAbs(i++, s);
				}
			} else {
				double[] t = new double[is];
				double[] s = new double[is];
				while (it.hasNext()) {
					int m = mmin;
					int n = nmin;
					Arrays.fill(s, 0);
					while (m < mmax && n < nmax) {
						pos[am] = m++;
						pos[an] = n++;
						ca.getDoubleArray(t, pos);
						for (int k = 0; k < is; k++) {
							s[k] += t[k];
						}
					}
					trace.setObjectAbs(i++, s);
				}
			}
		}

		return trace;
	}

	/**
	 * Order value for norm
	 */
	public enum NormOrder {
		/**
		 * 2-norm for vectors and Frobenius for matrices
		 */
		DEFAULT,
		/**
		 * Frobenius (not allowed for vectors)
		 */
		FROBENIUS,
		/**
		 * Zero-order (not allowed for matrices)
		 */
		ZERO,
		/**
		 * Positive infinity
		 */
		POS_INFINITY,
		/**
		 * Negative infinity
		 */
		NEG_INFINITY;
	}

	/**
	 * @param a
	 * @return norm of dataset
	 */
	public static double norm(Dataset a) {
		return norm(a, NormOrder.DEFAULT);
	}

	/**
	 * @param a
	 * @param order
	 * @return norm of dataset
	 */
	public static double norm(Dataset a, NormOrder order) {
		int r = a.getRank();
		if (r == 1) {
			return vectorNorm(a, order);
		} else if (r == 2) {
			return matrixNorm(a, order);
		}
		throw new IllegalArgumentException("Rank of dataset must be one or two");
	}

	private static double vectorNorm(Dataset a, NormOrder order) {
		double n;
		IndexIterator it;
		switch (order) {
		case FROBENIUS:
			throw new IllegalArgumentException("Not allowed for vectors");
		case NEG_INFINITY:
		case POS_INFINITY:
			it = a.getIterator();
			if (order == NormOrder.POS_INFINITY) {
				n = Double.NEGATIVE_INFINITY;
				if (a.isComplex()) {
					while (it.hasNext()) {
						double v = ((Complex) a.getObjectAbs(it.index)).abs();
						n = Math.max(n, v);
					}
				} else {
					while (it.hasNext()) {
						double v = Math.abs(a.getElementDoubleAbs(it.index));
						n = Math.max(n, v);
					}
				}
			} else {
				n = Double.POSITIVE_INFINITY;
				if (a.isComplex()) {
					while (it.hasNext()) {
						double v = ((Complex) a.getObjectAbs(it.index)).abs();
						n = Math.min(n, v);
					}
				} else {
					while (it.hasNext()) {
						double v = Math.abs(a.getElementDoubleAbs(it.index));
						n = Math.min(n, v);
					}
				}
			}
			break;
		case ZERO:
			it = a.getIterator();
			n = 0;
			if (a.isComplex()) {
				while (it.hasNext()) {
					if (!((Complex) a.getObjectAbs(it.index)).equals(Complex.ZERO))
						n++;
				}
			} else {
				while (it.hasNext()) {
					if (a.getElementBooleanAbs(it.index))
						n++;
				}
			}
			
			break;
		default:
			n = vectorNorm(a, 2);
			break;
		}
		return n;
	}

	private static double matrixNorm(Dataset a, NormOrder order) {
		double n;
		IndexIterator it;
		switch (order) {
		case NEG_INFINITY:
		case POS_INFINITY:
			n = maxMinMatrixNorm(a, 1, order == NormOrder.POS_INFINITY);
			break;
		case ZERO:
			throw new IllegalArgumentException("Not allowed for matrices");
		default:
		case FROBENIUS:
			it = a.getIterator();
			n = 0;
			if (a.isComplex()) {
				while (it.hasNext()) {
					double v = ((Complex) a.getObjectAbs(it.index)).abs();
					n += v*v;
				}
			} else {
				while (it.hasNext()) {
					double v = a.getElementDoubleAbs(it.index);
					n += v*v;
				}
			}
			n = Math.sqrt(n);
			break;
		}
		return n;
	}

	/**
	 * @param a
	 * @param p
	 * @return p-norm of dataset
	 */
	public static double norm(Dataset a, final double p) {
		if (p == 0) {
			return norm(a, NormOrder.ZERO);
		}
		int r = a.getRank();
		if (r == 1) {
			return vectorNorm(a, p);
		} else if (r == 2) {
			return matrixNorm(a, p);
		}
		throw new IllegalArgumentException("Rank of dataset must be one or two");
	}

	private static double vectorNorm(Dataset a, final double p) {
		IndexIterator it = a.getIterator();
		double n = 0;
		if (a.isComplex()) {
			while (it.hasNext()) {
				double v = ((Complex) a.getObjectAbs(it.index)).abs();
				if (p == 2) {
					v *= v;
				} else if (p != 1) {
					v = Math.pow(v, p);
				}
				n += v;
			}
		} else {
			while (it.hasNext()) {
				double v = a.getElementDoubleAbs(it.index);
				if (p == 1) {
					v = Math.abs(v);
				} else if (p == 2) {
					v *= v;
				} else {
					v = Math.pow(Math.abs(v), p);
				}
				n += v;
			}
		}
		return Math.pow(n, 1./p);
	}

	private static double matrixNorm(Dataset a, final double p) {
		double n;
		if (Math.abs(p) == 1) {
			n = maxMinMatrixNorm(a, 0, p > 0);
		} else if (Math.abs(p) == 2) {
			double[] s = calcSingularValues(a);
			n = p > 0 ? s[0] : s[s.length - 1];
		} else {
			throw new IllegalArgumentException("Order not allowed");
		}

		return n;
	}

	private static double maxMinMatrixNorm(Dataset a, int d, boolean max) {
		double n;
		IndexIterator it;
		int[] pos;
		int l;
		it = a.getPositionIterator(d);
		pos = it.getPos();
		l = a.getShapeRef()[d];
		if (max) {
			n = Double.NEGATIVE_INFINITY;
			if (a.isComplex()) {
				while (it.hasNext()) {
					double v = ((Complex) a.getObject(pos)).abs();
					for (int i = 1; i < l; i++) {
						pos[d] = i;
						v += ((Complex) a.getObject(pos)).abs();
					}
					pos[d] = 0;
					n = Math.max(n, v);
				}
			} else {
				while (it.hasNext()) {
					double v = Math.abs(a.getDouble(pos));
					for (int i = 1; i < l; i++) {
						pos[d] = i;
						v += Math.abs(a.getDouble(pos));
					}
					pos[d] = 0;
					n = Math.max(n, v);
				}
			}
		} else {
			n = Double.POSITIVE_INFINITY;
			if (a.isComplex()) {
				while (it.hasNext()) {
					double v = ((Complex) a.getObject(pos)).abs();
					for (int i = 1; i < l; i++) {
						pos[d] = i;
						v += ((Complex) a.getObject(pos)).abs();
					}
					pos[d] = 0;
					n = Math.min(n, v);
				}
			} else {
				while (it.hasNext()) {
					double v = Math.abs(a.getDouble(pos));
					for (int i = 1; i < l; i++) {
						pos[d] = i;
						v += Math.abs(a.getDouble(pos));
					}
					pos[d] = 0;
					n = Math.min(n, v);
				}
			}
		}
		return n;
	}

	/**
	 * @param a
	 * @return array of singular values
	 */
	public static double[] calcSingularValues(Dataset a) {
		SingularValueDecomposition svd = new SingularValueDecomposition(createRealMatrix(a));
		return svd.getSingularValues();
	}


	/**
	 * Calculate singular value decomposition A = U S V^T
	 * @param a
	 * @return array of U - orthogonal matrix, s - singular values vector, V - orthogonal matrix
	 */
	public static Dataset[] calcSingularValueDecomposition(Dataset a) {
		SingularValueDecomposition svd = new SingularValueDecomposition(createRealMatrix(a));
		return new Dataset[] {createDataset(svd.getU()), new DoubleDataset(svd.getSingularValues()),
				createDataset(svd.getV())};
	}

	/**
	 * Calculate (Moore-Penrose) pseudo-inverse
	 * @param a
	 * @return pseudo-inverse
	 */
	public static Dataset calcPseudoInverse(Dataset a) {
		SingularValueDecomposition svd = new SingularValueDecomposition(createRealMatrix(a));
		return createDataset(svd.getSolver().getInverse());
	}

	/**
	 * Calculate matrix rank by singular value decomposition method
	 * @param a
	 * @return effective numerical rank of matrix
	 */
	public static int calcMatrixRank(Dataset a) {
		SingularValueDecomposition svd = new SingularValueDecomposition(createRealMatrix(a));
		return svd.getRank();
	}

	/**
	 * Calculate condition number of matrix by singular value decomposition method
	 * @param a
	 * @return condition number
	 */
	public static double calcConditionNumber(Dataset a) {
		SingularValueDecomposition svd = new SingularValueDecomposition(createRealMatrix(a));
		return svd.getConditionNumber();
	}

	/**
	 * @param a
	 * @return determinant of dataset
	 */
	public static double calcDeterminant(Dataset a) {
		EigenDecomposition evd = new EigenDecomposition(createRealMatrix(a));
		return evd.getDeterminant();
	}

	/**
	 * @param a
	 * @return dataset of eigenvalues (can be double or complex double)
	 */
	public static Dataset calcEigenvalues(Dataset a) {
		EigenDecomposition evd = new EigenDecomposition(createRealMatrix(a));
		double[] rev = evd.getRealEigenvalues();

		if (evd.hasComplexEigenvalues()) {
			double[] iev = evd.getImagEigenvalues();
			return new ComplexDoubleDataset(rev, iev);
		}
		return new DoubleDataset(rev);
	}

	/**
	 * Calculate eigen-decomposition A = V D V^T
	 * @param a
	 * @return array of D eigenvalues (can be double or complex double) and V eigenvectors
	 */
	public static Dataset[] calcEigenDecomposition(Dataset a) {
		EigenDecomposition evd = new EigenDecomposition(createRealMatrix(a));
		Dataset[] results = new Dataset[2];

		double[] rev = evd.getRealEigenvalues();
		if (evd.hasComplexEigenvalues()) {
			double[] iev = evd.getImagEigenvalues();
			results[0] = new ComplexDoubleDataset(rev, iev);
		} else {
			results[0] = new DoubleDataset(rev);
		}
		results[1] = createDataset(evd.getV());
		return results;
	}

	/**
	 * Calculate QR decomposition A = Q R
	 * @param a
	 * @return array of Q and R
	 */
	public static Dataset[] calcQRDecomposition(Dataset a) {
		QRDecomposition qrd = new QRDecomposition(createRealMatrix(a));
		return new Dataset[] {createDataset(qrd.getQT()).getTransposedView(), createDataset(qrd.getR())};
	}

	/**
	 * Calculate LU decomposition A = P^-1 L U
	 * @param a
	 * @return array of L, U and P
	 */
	public static Dataset[] calcLUDecomposition(Dataset a) {
		LUDecomposition lud = new LUDecomposition(createRealMatrix(a));
		return new Dataset[] {createDataset(lud.getL()), createDataset(lud.getU()),
				createDataset(lud.getP())};
	}

	/**
	 * Calculate inverse of square dataset
	 * @param a
	 * @return inverse
	 */
	public static Dataset calcInverse(Dataset a) {
		LUDecomposition lud = new LUDecomposition(createRealMatrix(a));
		return createDataset(lud.getSolver().getInverse());
	}

	/**
	 * Solve linear matrix equation A x = v
	 * @param a
	 * @param v
	 * @return x
	 */
	public static Dataset solve(Dataset a, Dataset v) {
		LUDecomposition lud = new LUDecomposition(createRealMatrix(a));
		if (v.getRank() == 1) {
			RealVector x = createRealVector(v);
			return createDataset(lud.getSolver().solve(x));
		}
		RealMatrix x = createRealMatrix(v);
		return createDataset(lud.getSolver().solve(x));
	}

	/**
	 * Calculate Cholesky decomposition A = L L^T
	 * @param a
	 * @return L
	 */
	public static Dataset calcCholeskyDecomposition(Dataset a) {
		CholeskyDecomposition cd = new CholeskyDecomposition(createRealMatrix(a));
		return createDataset(cd.getL());
	}

	/**
	 * Calculation A x = v by conjugate gradient method with the stopping criterion being
	 * that the estimated residual r = v - A x satisfies ||r|| < ||v|| with maximum of 100 iterations
	 * @param a
	 * @param v
	 * @return solution of A^-1 v by conjugate gradient method
	 */
	public static Dataset calcConjugateGradient(Dataset a, Dataset v) {
		return calcConjugateGradient(a, v, 100, 1);
	}

	/**
	 * Calculation A x = v by conjugate gradient method with the stopping criterion being
	 * that the estimated residual r = v - A x satisfies ||r|| < delta ||v||
	 * @param a
	 * @param v
	 * @param maxIterations
	 * @param delta parameter used by stopping criterion
	 * @return solution of A^-1 v by conjugate gradient method
	 */
	public static Dataset calcConjugateGradient(Dataset a, Dataset v, int maxIterations, double delta) {
		ConjugateGradient cg = new ConjugateGradient(maxIterations, delta, false);
		return createDataset(cg.solve((RealLinearOperator) createRealMatrix(a), createRealVector(v)));
	}

	private static RealMatrix createRealMatrix(Dataset a) {
		if (a.getRank() != 2) {
			throw new IllegalArgumentException("Dataset must be rank 2");
		}
		int[] shape = a.getShapeRef();
		IndexIterator it = a.getIterator(true);
		int[] pos = it.getPos();
		RealMatrix m = MatrixUtils.createRealMatrix(shape[0], shape[1]);
		while (it.hasNext()) {
			m.setEntry(pos[0], pos[1], a.getElementDoubleAbs(it.index));
		}
		return m;
	}

	private static RealVector createRealVector(Dataset a) {
		if (a.getRank() != 1) {
			throw new IllegalArgumentException("Dataset must be rank 1");
		}
		int size = a.getSize();
		IndexIterator it = a.getIterator(true);
		int[] pos = it.getPos();
		RealVector m = new ArrayRealVector(size);
		while (it.hasNext()) {
			m.setEntry(pos[0], a.getElementDoubleAbs(it.index));
		}
		return m;
	}

	private static Dataset createDataset(RealVector v) {
		DoubleDataset r = new DoubleDataset(v.getDimension());
		int size = r.getSize();
		if (v instanceof ArrayRealVector) {
			double[] data = ((ArrayRealVector) v).getDataRef();
			for (int i = 0; i < size; i++) {
				r.setAbs(i, data[i]);
			}
		} else {
			for (int i = 0; i < size; i++) {
				r.setAbs(i, v.getEntry(i));
			}
		}
		return r;
	}

	private static Dataset createDataset(RealMatrix m) {
		DoubleDataset r = new DoubleDataset(m.getRowDimension(), m.getColumnDimension());
		if (m instanceof Array2DRowRealMatrix) {
			double[][] data = ((Array2DRowRealMatrix) m).getDataRef();
			IndexIterator it = r.getIterator(true);
			int[] pos = it.getPos();
			while (it.hasNext()) {
				r.setAbs(it.index, data[pos[0]][pos[1]]);
			}
		} else {
			IndexIterator it = r.getIterator(true);
			int[] pos = it.getPos();
			while (it.hasNext()) {
				r.setAbs(it.index, m.getEntry(pos[0], pos[1]));
			}
		}
		return r;
	}
}
