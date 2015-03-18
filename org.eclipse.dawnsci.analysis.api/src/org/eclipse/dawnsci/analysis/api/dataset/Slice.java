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

package org.eclipse.dawnsci.analysis.api.dataset;

import java.io.Serializable;

/**
 * Class to represent a slice through a single dimension of a multi-dimensional dataset. A slice
 * comprises a starting position, a stopping position (not included) and a stepping size.
 */
public class Slice implements Cloneable, Serializable {

	private Integer start;
	private Integer stop;
	private int step;

	private int length; // max length of dimension

	public Slice() {
		this(null, null, 1);
	}

	/**
	 * Default to starting at 0 with steps of 1
	 * @param stop if null, then default to whatever shape is when converted
	 */
	public Slice(final Integer stop) {
		this(null, stop, 1);
	}

	/**
	 * Default to steps of 1
	 * @param start if null, then default to 0
	 * @param stop if null, then default to whatever shape is when converted
	 */
	public Slice(final Integer start, final Integer stop) {
		this(start, stop, 1);
	}

	/**
	 * 
	 * @param start if null, then default to bound
	 * @param stop if null, then default to bound
	 * @param step if null, then default to 1
	 */
	public Slice(final Integer start, final Integer stop, final Integer step) {
		this.start = start;
		this.stop = stop;
		this.step = step == null ? 1 : step;
		length = -1;
	}

	/**
	 * Copy another slice
	 * @param other
	 */
	private Slice(final Slice other) {
		start  = other.start;
		stop   = other.stop;
		step   = other.step;
		length = other.length;
	}

	@Override
	public Slice clone() {
		return new Slice(this);
	}

	/**
	 * Set maximum value of slice
	 * @param length
	 * @return this slice
	 */
	public Slice setLength(int length) {
		if (stop != null && step > 0 && length < stop) {
			throw new IllegalArgumentException("Length must be greater than or equal to stop");
		}
		if (start != null && step < 0 && length < start) {
			throw new IllegalArgumentException("Length must be greater than or equal to start");
		}
		this.length = length;
		return this;
	}

	/**
	 * @return true if slice represents complete dimension
	 */
	public boolean isSliceComplete() {
		if (start == null && stop == null && (step == 1 || step == -1))
			return true;
		if (length > 0) {
			return getNumSteps() == length;
		}

		return true;
	}

	/**
	 * @return maximum value of slice
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @return starting position of slice
	 */
	public Integer getStart() {
		return start;
	}

	/**
	 * @return stopping position of slice
	 */
	public Integer getStop() {
		return stop;
	}

	/**
	 * @return step size of slice
	 */
	public int getStep() {
		return step;
	}

	/**
	 * Set starting position of slice
	 * @param start (can be null)
	 */
	public void setStart(Integer start) {
		if (start != null && length > 0) {
			if (step > 0) {
				int end = stop == null ? length : stop;
				if (start >= end) {
					throw new IllegalArgumentException("Non-null start must be less than end");
				}
			} else {
				int end = stop == null ? -1 : stop;
				if (start < end) {
					throw new IllegalArgumentException("Non-null start must be greater than end for negative step");
				}
			}
		}
		this.start = start;
	}

	/**
	 * Set stopping position of slice
	 * @param stop (can be null)
	 */
	public void setStop(Integer stop) {
		if (stop != null && length > 0) {
			if (step > 0) {
				int beg = start == null ? 0 : start;
				if (stop < beg) {
					throw new IllegalArgumentException("Non-null stop must be greater than or equal to beginning");
				}
			} else {
				int beg = start == null ? length - 1 : start;
				if (stop >= beg) {
					throw new IllegalArgumentException("Non-null stop must be less than beginning for negative step");
				}
			}
			if (stop > length)
				stop = length;
		}
		this.stop = stop;
	}

	/**
	 * Set start and end from implied number of steps. I.e. shift start to position given by
	 * parameter whilst keeping size of slice fixed
	 * @param beg
	 * @return true if end reached
	 */
	public boolean setPosition(int beg) {
		boolean end = false;
		int len = getNumSteps();
		int max = getNumSteps(beg, length);
		if (len > max) {
			len = max;
			end = true;
		}
		start = beg;
		stop = start + (len-1) * step + 1;
		return end;
	}

	/**
	 * Get position of n-th step in slice
	 * @param n
	 * @return position
	 */
	public int getPosition(int n) {
		if (n < 0)
			throw new IllegalArgumentException("Given n-th step should be non-negative");
		if (n >= getNumSteps())
			throw new IllegalArgumentException("N-th step exceeds extent of slice");
		int beg;
		if (start == null) {
			if (step < 0) {
				if (length < 0) {
					if (stop == null) {
						throw new IllegalStateException("Length or stop should be set");
					}
					beg = stop - 1;
				} else {
					beg = length - 1;
				}
			} else {
				beg = 0;
			}
		} else {
			beg = start;
		}
		return beg + step*n;
	}

	/**
	 * Set step size of slice
	 * @param step
	 */
	public void setStep(int step) {
		if (step == 0) {
			throw new IllegalArgumentException("Step must not be zero");
		}
		this.step = step;
	}

	/**
	 * Append string representation of slice
	 * @param s
	 * @param len
	 * @param beg
	 * @param end
	 * @param del
	 */
	public static void appendSliceToString(final StringBuilder s, final int len, final int beg, final int end, final int del) {
		int o = s.length();
		if (del > 0) {
			if (beg != 0)
				s.append(beg);
		} else {
			if (beg != len-1)
				s.append(beg);
		}

		int n = getNumSteps(beg, end, del);
		if (n == 1) {
			if (s.length() == o) {
				s.append(beg);
			}
			return;
		}

		s.append(':');

		if (del > 0) {
			if (end != len)
				s.append(end);
		} else {
			if (end != -1)
				s.append(end);
		}

		if (del != 1) {
			s.append(':');
			s.append(del);
		}
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		appendSliceToString(s, length, start != null ? start : (step > 0 ? 0 : length - 1), stop != null ? stop : (step > 0 ? length : -1), step);
		return s.toString();
	}

	/**
	 * @return number of steps in slice
	 */
	public int getNumSteps() {
		if (length < 0) {
			if (stop == null)
				throw new IllegalStateException("Slice is underspecified - stop is null and length is negative");
			int beg = start == null ? (step > 0 ? 0: stop-1) : start;
			if (step > 0 && stop <= beg)
				return 0;
			if (step < 0 && stop > beg)
				return 0;
			return getNumSteps(beg, stop);
		}
		int beg = start == null ? (step > 0 ? 0: length-1) : start;
		int end = stop == null ? (step > 0 ? length : -1) : stop;
		return getNumSteps(beg, end);
	}

	/**
	 * @param beg
	 * @param end (exclusive)
	 * @return number of steps between limits
	 */
	public int getNumSteps(int beg, int end) {
		return getNumSteps(beg, end, step);
	}

	private static int getNumSteps(int beg, int end, int step) {
		int del = step > 0 ? 1 : -1;
		return (end - beg - del) / step + 1;
	}

	/**
	 * @return last value in slice (< stop if step > 0, > stop if step < 0)
	 */
	public int getEnd() {
		int n = getNumSteps() - 1;
		if (n < 0)
			throw new IllegalStateException("End is not defined");

		return getPosition(n);
	}

	/**
	 * Populate given start, stop, step arrays from given slice array 
	 * @param shape
	 * @param start
	 * @param stop
	 * @param step
	 * @param slice
	 */
	public static void convertFromSlice(final Slice[] slice, final int[] shape, final int[] start, final int[] stop, final int[] step) {
		final int rank = shape.length;
		final int length = slice == null ? 0 : slice.length;
	
		int i = 0;
		for (; i < length; i++) {
			if (length > rank)
				break;

			@SuppressWarnings("null")
			Slice s = slice[i];
			if (s == null) {
				start[i] = 0;
				stop[i] = shape[i];
				step[i] = 1;
				continue;
			}
			int n;
			if (s.start == null) {
				start[i] = s.step > 0 ? 0 : shape[i] - 1;
			} else {
				n = s.start;
				if (n < 0)
					n += shape[i];
				if (n < 0 || n >= shape[i]) {
					throw new IllegalArgumentException(String.format("Start is out of bounds: %d is not in [%d,%d)",
							n, s.start, shape[i]));
				}
				start[i] = n;
			}

			if (s.stop == null) {
				stop[i] = s.step > 0 ? shape[i] : -1;
			} else {
				n = s.stop;
				if (n < 0)
					n += shape[i];
				if (n < 0 || n > shape[i]) {
					throw new IllegalArgumentException(String.format("Stop is out of bounds: %d is not in [%d,%d)",
							n, s.stop, shape[i]));
				}
				stop[i] = n;
			}

			n = s.step;
			if (n == 0) {
				throw new IllegalArgumentException("Step cannot be zero");
			}
			if (n > 0) {
				if (start[i] > stop[i])
					throw new IllegalArgumentException("Start must be less than stop for positive steps");
			} else {
				if (start[i] < stop[i])
					throw new IllegalArgumentException("Start must be greater than stop for negative steps");				
			}
			step[i] = n;
		}
		for (; i < rank; i++) {
			start[i] = 0;
			stop[i] = shape[i];
			step[i] = 1;
		}
	}

	/**
	 * Convert from a set of integer arrays to a slice array
	 * @param start
	 * @param stop
	 * @param step
	 * @return a slice array
	 */
	public static Slice[] convertToSlice(final int[] start, final int[] stop, final int[] step) {
		int orank = start.length;

		if (stop.length != orank || step.length != orank) {
			throw new IllegalArgumentException("All arrays must be same length");
		}

		Slice[] slice = new Slice[orank];

		for (int j = 0; j < orank; j++) {
			slice[j] = new Slice(start[j], stop[j], step[j]);
		}

		return slice;
	}

	/**
	 * Convert a string to a slice array
	 * 
	 * @param sliceString
	 * @return a slice array
	 */
	public static Slice[] convertFromString(String sliceString) {

		String clean = sliceString.replace("[", "");
		clean = clean.replace("]", "");

		String[] sub = clean.split(",");

		Slice[] slices = new Slice[sub.length];

		for (int i = 0; i < sub.length; i++) {
			String s = sub[i];

			Slice slice = new Slice(); 
			slices[i] = slice;

			int idx0 = s.indexOf(":");

			int n = 0;
			if (idx0 == -1) {
				n = Integer.parseInt(s);
				slice.setStart(n);
				slice.setStop(n + 1);
				continue;
			} else if (idx0 != 0) {
				n = Integer.parseInt(s.substring(0, idx0));
			}
			slice.setStart(n);

			idx0++;
			int idx1 = s.indexOf(":", idx0);
			if (idx1 == -1) {
				String t = s.substring(idx0).trim(); 
				if (t.length() == 0)
					continue;

				slice.setStop(Integer.parseInt(t));
				continue;
			} else if (idx1 != idx0) {
				slice.setStop(Integer.parseInt(s.substring(idx0, idx1)));
			}

			String t = s.substring(idx1 + 1).trim(); 
			if (t.length() > 0)
				slice.setStep(Integer.parseInt(t));
		}

		return slices;
	}

	/**
	 * Create a string representing the slice taken from given shape
	 * @param shape
	 * @param start
	 * @param stop
	 * @param step
	 * @return string representation
	 */
	public static String createString(final int[] shape, final int[] start, final int[] stop, final int[] step) {
		final int rank = shape.length;
		if (rank == 0) {
			return "";
		}
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < rank; i++) {
			int l = shape[i];
			int d = step == null ? 1 : step[i];
			int b = start == null ? (d > 0 ? 0 : l - 1) : start[i];
			int e = stop == null ? (d > 0 ? l : -1) : stop[i];
	
			appendSliceToString(s, l, b, e, d);
			s.append(',');
		}
	
		return s.substring(0, s.length()-1);
	}

	/**
	 * @param slices
	 * @return string specifying slices
	 */
	public static String createString(Slice... slices) {
		if (slices == null || slices.length == 0) {
			return "";
		}

		StringBuilder t = new StringBuilder();
		for (Slice s : slices) {
			t.append(s != null ? s.toString() : ':');
			t.append(',');
		}

		return t.substring(0, t.length() - 1);
	}
}
