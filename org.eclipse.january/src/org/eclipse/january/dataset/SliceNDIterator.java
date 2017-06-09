/*-
 *******************************************************************************
 * Copyright (c) 2015, 2016 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Peter Chang - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.january.dataset;

/**
 * <p>Class to provide slice iteration through a dataset</p>
 * <p>It allows a number of axes to be omitted and iterates over
 * the axes left over.</p>
 */
public class SliceNDIterator extends IndexIterator {
	final private int[] shape;
	final private int[] start;
	final private int[] stop;
	final private int[] step;
	final private int endrank;

	final private boolean[] omit; // axes to miss out

	/**
	 * position in source dataset
	 */
	final private int[] pos;
	final private int[] end;
	private boolean once;

	private SliceND cSlice; // current slice
	
	private int sRank; // number of dimensions used (i.e. not missing)
	final private SliceND oSlice; // omitted source slice

	final private SliceND sSlice; // shortened slice
	final private int[] sStart; // shortened position
	final private int[] sStop; // shortened end

	private SliceND dSlice; // destination slice
	private int[] dStart;
	private int[] dStop;

	/**
	 * Constructor for an iterator that misses out several axes
	 * @param slice
	 * @param axes missing axes
	 */
	public SliceNDIterator(SliceND slice, int... axes) {
		cSlice = slice.clone();
		int[] sShape = cSlice.getSourceShape();
		shape = cSlice.getShape().clone();
		start = cSlice.getStart();
		stop  = cSlice.getStop();
		step  = cSlice.getStep();
		for (int s : step) {
			if (s < 0) {
				throw new UnsupportedOperationException("Negative steps not implemented");
			}
		}
		int rank = shape.length;
		endrank = rank - 1;

		omit = new boolean[rank];
		dSlice = new SliceND(shape);
		dStart = dSlice.getStart();
		dStop  = dSlice.getStop();
		sRank = rank;
		if (axes != null) {
			for (int a : axes) {
				if (a < 0) {
					a += rank;
				}
				if (a >= 0 && a <= endrank) {
					sRank--;
					omit[a] = true;
					shape[a] = 1;
				} else if (a > endrank) {
					throw new IllegalArgumentException("Specified axis exceeds dataset rank");
				}
			}
		}

		cSlice = cSlice.clone();
		pos = cSlice.getStart();
		end = cSlice.getStop();
		if (sRank == rank) {
			sStart = pos;
			sStop = null;
			oSlice = null;
			sSlice = cSlice;
		} else {
			int[] dShape = dSlice.getShape();
			int[] lShape = new int[sRank]; // inner shape
			int[] oShape = new int[rank - sRank]; // output shape
			for (int i = 0, j = 0, k = 0; i < rank; i++) {
				if (omit[i]) {
					oShape[j++] = sShape[i];
				} else {
					lShape[k++] = sShape[i];
					dShape[i] = 1;
				}
			}
			sSlice = new SliceND(lShape);
			sStart = sSlice.getStart();
			sStop = sSlice.getStop();

			oSlice = new SliceND(oShape);
			for (int i = 0, j = 0, k = 0; i < rank; i++) {
				if (omit[i]) {
					oSlice.setSlice(j++, start[i], stop[i], step[i]);
				} else {
					sSlice.setSlice(k++, start[i], stop[i], step[i]);
				}
			}
		}
		
		reset();
	}

	@Override
	public boolean hasNext() {
		// now move on one position
		if (once) {
			once = false;
			return true;
		}
		int k = sRank - 1;
		for (int j = endrank; j >= 0; j--) {
			if (omit[j]) {
				continue;
			}
			pos[j] += step[j];
			end[j] = pos[j] + step[j];
			dStart[j]++;
			dStop[j]++;
			if (pos[j] >= stop[j]) {
				pos[j] = start[j];
				end[j] = pos[j] + step[j];
				dStart[j] = 0;
				dStop[j] = 1;
				if (sStop != null) {
					sStart[k] = pos[j];
					sStop[k] = end[j];
					k--;
				}
			} else {
				if (sStop != null) {
					sStart[k] = pos[j];
					sStop[k] = end[j];
					k--;
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public int[] getPos() {
		return pos;
	}

	/**
	 * Get omitted part of source slice which never changes
	 * @return slice (can be null)
	 */
	public SliceND getOmittedSlice() {
		return oSlice;
	}

	/**
	 * Get output or destination slice
	 * @return slice
	 */
	public SliceND getOutputSlice() {
		return dSlice;
	}

	/**
	 * Get current slice
	 * @return slice
	 */
	public SliceND getCurrentSlice() {
		return cSlice;
	}

	/**
	 * Shortened position where axes are omitted
	 * @return used position
	 */
	public int[] getUsedPos() {
		return sStart;
	}

	/**
	 * Shortened slice where axes are omitted
	 * @return used slice
	 */
	public SliceND getUsedSlice() {
		return sSlice;
	}

	/**
	 * @return omit array - array where true means miss out
	 */
	public boolean[] getOmit() {
		return omit;
	}

	@Override
	public void reset() {
		for (int i = 0, k = 0; i <= endrank; i++) {
			int b = start[i];
			int d = step[i];
			if (!omit[i]) {
				cSlice.setSlice(i, b, b + d, d);
				dStart[i] = 0;
				dStop[i] = 1;
				if (sStop != null) {
					sSlice.setSlice(k++, b, b + d, d);
				}
			} else {
				cSlice.setSlice(i, b, end[i], d);
			}
		}

		int j = 0;
		for (; j <= endrank; j++) {
			if (!omit[j])
				break;
		}
		if (j > endrank) {
			once = true;
			return;
		}

		if (omit[endrank]) {
			pos[endrank] = start[endrank];
			for (int i = endrank - 1; i >= 0; i--) {
				if (!omit[i]) {
					end[i] = pos[i];
					pos[i] -= step[i];
					dStart[i]--;
					dStop[i]--;
					break;
				}
			}
		} else {
			end[endrank] = pos[endrank];
			pos[endrank] -= step[endrank];
			dStart[endrank]--;
			dStop[endrank]--;
		}

		if (sStart != pos) {
			for (int i = 0, k = 0; i <= endrank; i++) {
				if (!omit[i]) {
					sStart[k++] = pos[i];
				}
			}
		}
	}

	@Override
	public int[] getShape() {
		return shape;
	}
}
