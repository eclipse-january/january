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

/**	
 * The {@code Slice} class represents the set of indices (start, stop, step), that are used to extract specifics subsets of {@link org.eclipse.january.dataset.Dataset}.<br><br>
 * The start argument default to 0, stop argument default to the stop argument default to the end of the dimension that the slice is applied to, and the default argument for the step is 1.
 * <br><br>
 * The start index is inclusive, for example, if we want to get data from index 1, so sliceData will be <b>[2,3]</b> :
 * <pre>
* {@code
* final Dataset onedData = DatasetFactory.createFromObject(new int[]{1,2,3});
* Dataset sliceData = onedData.getSlice(new Slice(1, null, null));
* }
* </pre>
* 
* If Slice is specified with only one argument, this will be the stop index which is exclusive. In this case sliceData will be <b>[1,2]</b> :
 * <pre>
* {@code
* final Dataset onedData = DatasetFactory.createFromObject(new int[]{1,2,3});
* Dataset sliceData = onedData.getSlice(new Slice(2));
* }
* </pre>
* 
* To create a 1D Slice, so sliceData is : <b>[6, 5, 4]</b>, we will do :
* <pre>
* {@code
* final Dataset sliceData = DatasetFactory.createFromObject(new int[]{10,9,8,7,6,5,4,3,2,1,0});
* Dataset newOnedData = sliceData.getSlice(new Slice(4, 7, 1));
* }
* </pre>
* <br>
* For more informations, see the sliceFrom1D example in SlicingExamples.
 */
public class Slice implements Cloneable, Serializable {

	private static final long serialVersionUID = 3714928852236201310L;
	private Integer start;
	private Integer stop;
	private int step;

	private int length; // max length of dimension

	/**
	 * Constructs a Slice object with the start and the stop value representing
	 * the entirety of the sliced dimension of the Dataset.
	 */
	public Slice() {
		this(null, null, 1);
	}

	/**
	 * Constructs a Slice object with, by default the start set to 0 and with a
	 * step of 1. If the stop point of the Slice is {@code null}, it will be set
	 * to the stop argument default to the end of the dimension that the slice
	 * is applied to.
	 * 
	 * @param stop
	 *            the stop point of the Slice
	 */
	public Slice(final Integer stop) {
		this(null, stop, 1);
	}

	/**
	 * Constructs a Slice object with, by default a step of 1. If the start
	 * point of the Slice is {@code null}, it will be set automatically to 0. If
	 * the stop point of the Slice is {@code null}, it will be set to the stop
	 * argument default to the end of the dimension that the slice is applied
	 * to.
	 * 
	 * @param start
	 *            the start point of the Slice
	 * @param stop
	 *            the stop point of the Slice
	 */
	public Slice(final Integer start, final Integer stop) {
		this(start, stop, 1);
	}

	/**
	 * Constructs a Slice object on which it is possible to chooe the start, the
	 * stop and the step. If the start point of the Slice is {@code null}, it
	 * will be set automatically to 0. If the stop point of the Slice is
	 * {@code null}, it will be set to the stop argument default to the end of
	 * the dimension that the slice is applied to. If the the wanted step is set
	 * to {@code null}, it will be set by default to 1.
	 * 
	 * @param start
	 *            the start point of the Slice, may be {@code null}
	 * @param stop
	 *            the stop point of the Slice, may be {@code null}
	 * @param step
	 *            the step wanted to browse the Dataset, may be {@code null}
	 */
	public Slice(final Integer start, final Integer stop, final Integer step) {
		this.start = start;
		this.stop = stop;
		this.step = step == null ? 1 : step;
		length = -1;
	}

	/**
	 * Copy another slice
	 * 
	 * @param other
	 */
	private Slice(final Slice other) {
		start = other.start;
		stop = other.stop;
		step = other.step;
		length = other.length;
	}

	/**
	 * Creates a deep copy of the Slice.
	 * 
	 * @return New Slice with the current Slice properties
	 */
	@Override
	public Slice clone() {
		return new Slice(this);
	}

	/**
	 * Sets the maximal dimensions length of the Slice.
	 * 
	 * @param length
	 *            Wanted size of dimensions
	 * @return The Slice which the method is called on
	 */
	public Slice setLength(int length) {
		if (stop != null) {
			if (step > 0) {
				if (stop > length) {
					throw new IllegalArgumentException("Stop must be less than or equal to length");
				}
			}
		}
		if (start != null) {
			if (start > length) {
				throw new IllegalArgumentException("Start must be less than or equal to length");
			}
		}
		this.length = length;
		return this;
	}

	/**
	 * Returns {@code true} if the slice has a maximum size equal to the current
	 * size, else {@code false}.
	 * 
	 * @return {@code true} if slice represents complete dimension,
	 *         {@code false} in the other case.
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
	 * Returns the maximum value of the slice.
	 * 
	 * @return Maximum value of the slice
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Returns the starting index of the slice.
	 * 
	 * @return Start point of the slice
	 */
	public Integer getStart() {
		return start;
	}

	/**
	 * Returns the stopping index of the slice.
	 * 
	 * @return Stop point of the slice
	 */
	public Integer getStop() {
		return stop;
	}

	/**
	 * Returns the step of the slice.
	 * 
	 * @return Step of the slice
	 */
	public int getStep() {
		return step;
	}

	/**
	 * Set the starting index of the slice. If the start point of the Slice is
	 * {@code null}, it will be set automatically to 0.
	 * 
	 * @param start
	 *            Starting index of the Slice, may be {@code null}
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
	 * Set the stopping index of the slice. If the stop point of the Slice is
	 * {@code null}, it will be set to the stop argument default to the end of
	 * the dimension that the slice is applied to.
	 * 
	 * @param stop
	 *            Stopping index of the Slice, may be {@code null}
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
	 * Move the start and end to an other index keeping the same step and the
	 * same gap between the two values
	 * 
	 * @param beg
	 *            New starting point
	 * @return Return {@code true} if the end was reached, {@code false} in the
	 *         other case.
	 */
	public boolean setPosition(int beg) {
		boolean end = false;
		int len = getNumSteps();
		int max = getNumSteps(beg, length, step);
		if (len > max) {
			len = max;
			end = true;
		}
		start = beg;
		stop = start + (len - 1) * step + 1;
		return end;
	}

	/**
	 * Returns the index of the n-th step inside of the slice
	 * 
	 * @param n
	 *            Wanted step index in the slice
	 * @return Return the index of the step inside of the Slice
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
		return beg + step * n;
	}

	/**
	 * Set the step size inside of the Slice. If the the wanted step is set to
	 * {@code null}, it will be set by default to 1.
	 * 
	 * @param step
	 *            New wanted step, may be {@code null}
	 */
	public void setStep(int step) {
		if (step == 0) {
			throw new IllegalArgumentException("Step must not be zero");
		}
		this.step = step;
	}

	/**
	 * Append a string representation of the Slice comparable to the Python
	 * representation.
	 * 
	 * @param s
	 *            String builder
	 * @param len
	 *            Maximal length of the Slice, or -1 if not set
	 * @param beg
	 *            Start index of the Slice
	 * @param end
	 *            Stop index of the Slice
	 * @param del
	 *            Step of the Slice
	 */
	public static void appendSliceToString(final StringBuilder s, final int len, final int beg, final int end,
			final int del) {
		int o = s.length();
		if (del > 0) {
			if (beg != 0)
				s.append(beg);
		} else {
			if (beg != len - 1)
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

	/**
	 * Returns a string construction of the slice with the Python form.
	 * 
	 * @return Constructed String.
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		appendSliceToString(s, length, start != null ? start : (step > 0 ? 0 : length - 1),
				stop != null ? stop : (step > 0 ? length : -1), step);
		return s.toString();
	}

	/**
	 * Returns the number of steps inside of the Slice
	 * 
	 * @return Number of steps inside of the Slice
	 */
	public int getNumSteps() {
		if (length < 0) {
			if (stop == null)
				throw new IllegalStateException("Slice is underspecified - stop is null and length is negative");
			int beg = start == null ? (step > 0 ? 0 : stop - 1) : start;
			if (step > 0 && stop <= beg)
				return 0;
			if (step < 0 && stop > beg)
				return 0;
			return getNumSteps(beg, stop, step);
		}
		int beg = start == null ? (step > 0 ? 0 : length - 1) : start;
		int end = stop == null ? (step > 0 ? length : -1) : stop;
		return getNumSteps(beg, end, step);
	}

	/**
	 * Returns the number of steps inside of the Slice from a point to an other
	 * point minus 1 because this is an exclusive index
	 * 
	 * @param beg
	 *            Starting point
	 * @param end
	 *            (exclusive) Stopping point
	 * @return Numbers of steps between the 2 limits.
	 */
	public int getNumSteps(int beg, int end) {
		return getNumSteps(beg, end, step);
	}

	private static int getNumSteps(int beg, int end, int step) {
		int del = step > 0 ? 1 : -1;
		return Math.max(0, (end - beg - del) / step + 1);
	}

	/**
	 * Returns the last value inside of Slice.
	 * 
	 * @return Last value in the slice, it can be a lower value than the start
	 *         if the step is going backward
	 */
	public int getEnd() {
		int n = getNumSteps() - 1;
		if (n < 0)
			throw new IllegalStateException("End is not defined");

		return getPosition(n);
	}

	/**
	 * Flips the Slice direction, after this operation, the slice begins at
	 * previous end point, steps in the opposite direction, and finishes at the
	 * previous start point.
	 * <p>
	 * Note : the stop value may not be preserved across two flips
	 * </p>
	 * 
	 * @return Flipped Slice.
	 */
	public Slice flip() {
		if (length < 0) {
			Integer tmp = start == null ? null : start - step;
			start = stop == null ? null : getEnd();
			stop = tmp;
		} else {
			Integer tstart = start;
			start = stop == null ? null : getEnd();
			stop = tstart == null ? null : tstart - step;
		}
		step = -step;

		return this;
	}

	/**
	 * Populates given start, stop, step arrays from given slice array
	 * 
	 * @param slice
	 *            Input array of Slices wanted to convert
	 * @param shape
	 *            Input array of Slices shapes
	 * @param start
	 *            Output array of Slices starts
	 * @param stop
	 *            Output array of Slices stops
	 * @param step
	 *            Output array of Slices steps
	 */
	public static void convertFromSlice(final Slice[] slice, final int[] shape, final int[] start, final int[] stop,
			final int[] step) {
		final int rank = shape.length;
		final int length = slice == null ? 0 : slice.length;

		int i = 0;
		for (; i < length; i++) {
			if (length > rank)
				break;

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
					throw new IllegalArgumentException(
							String.format("Start is out of bounds: %d is not in [%d,%d)", n, s.start, shape[i]));
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
					throw new IllegalArgumentException(
							String.format("Stop is out of bounds: %d is not in [%d,%d)", n, s.stop, shape[i]));
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
	 * Converts a set of integer arrays in a slice array
	 * 
	 * @param start
	 *            Array of Slices starts
	 * @param stop
	 *            Array of Slices stops
	 * @param step
	 *            Array of Slices steps
	 * @return Slice array corresponding to the starts, stops and steps arrays
	 *         entered.
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

	private static final int COLON = ':';

	/**
	 * Converts string in a Slice array
	 * 
	 * @param sliceString
	 *            String of the Slice array
	 * @return Slice array created from the given string
	 */
	public static Slice[] convertFromString(String sliceString) {

		String clean = sliceString.replace("[", "").replace("]", "");

		String[] sub = clean.split(",");

		Slice[] slices = new Slice[sub.length];

		for (int i = 0; i < sub.length; i++) {
			String s = sub[i];

			Slice slice = new Slice();
			slices[i] = slice;

			int idx0 = s.indexOf(COLON);

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
			int idx1 = s.indexOf(COLON, idx0);
			if (idx1 == -1) {
				String t = s.substring(idx0).trim();
				if (t.length() == 0) {
					continue;
				}

				slice.setStop(Integer.parseInt(t));
				continue;
			} else if (idx1 != idx0) {
				slice.setStop(Integer.parseInt(s.substring(idx0, idx1)));
			}

			String t = s.substring(idx1 + 1).trim();
			if (t.length() > 0) {
				slice.setStep(Integer.parseInt(t));
			}
		}

		return slices;
	}

	/**
	 * Creates a string representing the slice taken from given shape
	 * 
	 * @param shape
	 *            Array of Slices shapes
	 * @param start
	 *            Array of Slices starts
	 * @param stop
	 *            Array of Slices stops
	 * @param step
	 *            Array of Slices steps
	 * @return String representation of the Slice
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

		return s.substring(0, s.length() - 1);
	}

	/**
	 * Creates a string representation of slices.
	 * 
	 * @param slices
	 *            Wanted Slices to put inside of the string representation
	 * @return Return the string representation of the Slices entered.
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
