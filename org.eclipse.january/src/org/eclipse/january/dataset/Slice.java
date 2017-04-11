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
 * The start argument default to 0, stop argument default to the end of the Dataset on which you are applying to the Slice and the default argument for the step is 1.
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

	String bob;
	private static final long serialVersionUID = 3714928852236201310L;
	private Integer start;
	private Integer stop;
	private int step;

	private int length; // max length of dimension

	/**
	 * Slice constructor without parameters. It's construct a Slice object with the start and the stop at the size of the Dataset on 
	 * which you apply the Slice, the step is set to 1.
	 */
	public Slice() {
		this(null, null, 1);
	}

	/**
	 * Slice constructor with the stop parameter. It's construct by default the start at 0 with a step of 1.
	 * @param stop the stop point of the Slice, if null, the stop will be the entire size of the Dataset on which you apply the Slice to
	 */
	public Slice(final Integer stop) {
		this(null, stop, 1);
	}

	/**
	 * Slice constructor with the start and stop parameter. It's construct by default with a step of 1.
	 * @param start the start point of the Slice,  if null, it's automatically set to 0
	 * @param stop the stop point of the Slice, if null, the stop will be the entire size of the Dataset on which you apply the Slice to
	 */
	public Slice(final Integer start, final Integer stop) {
		this(start, stop, 1);
	}

	/**
	 * Slice constructor with the start, the stop and the step parameter.
	 * @param start the start point of the Slice,  if null, it's automatically set to 0
	 * @param stop the stop point of the Slice, if null, the stop will be the entire size of the Dataset on which you apply the Slice to
	 * @param step the step wanted to browse the Dataset, if null, it's set by default to 1
	 */
	public Slice(final Integer start, final Integer stop, final Integer step) {
		this.start = start;
		this.stop = stop;
		this.step = step == null ? 1 : step;
		length = -1;
	}

	/**
	 * This method allows to create a new Slice Object from an other Slice, this is a deep copy.
	 * @param other The Slice that you want to copy
	 */
	private Slice(final Slice other) {
		start  = other.start;
		stop   = other.stop;
		step   = other.step;
		length = other.length;
	}

	@Override
	/**
	 * This method allows to create a deep copy of the Slice.
	 * @return 
	 * 		Return the new Slice with properties of the current Slice
	 */
	public Slice clone() {
		return new Slice(this);
	}

	/**
	 * This method allows to set the maximal length of dimensions of the Slice.
	 * @param length Wanted size of dimensions
	 * @return 
	 * 		Return the Slice on which the method is called on
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
	 * This method allows to know if the slice has a maximum size equal to the current size.
	 * @return 
	 * 		Return true if slice represents complete dimension, false in the other case.
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
	 * This method allows to get the maximum value of the slice.
	 * @return 
	 * 		Return the maximum value of the slice
	 */
	public int getLength() {
		return length;
	}

	/**
	 * This method allows to get the starting position of the slice.
	 * @return
	 * 		Return the start point of the slice
	 */
	public Integer getStart() {
		return start;
	}

	/**
	 * This method allows to get the stopping position of the slice.
	 * @return
	 * 		Return the stop point of the slice
	 */
	public Integer getStop() {
		return stop;
	}

	/**
	 * This method allows to get the step of the slice.
	 * @return
	 * 		Return the step of the slice
	 */
	public int getStep() {
		return step;
	}

	/**
	 * This method allows to set the starting position of the slice.
	 * @param start The starting position of the Slice, if null, the start point is set to 0
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
	 * This method allows to set the stopping position of the slice.
	 * @param stop The stopping position of the Slice, if null, the stop will be the entire size of the Dataset on which you apply the Slice to
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
	 * This method allows to set the start and end to an other position in the Slice by keeping the same step and the same gap between the start and the end
	 * @param beg this is the new starting point
	 * @return 
	 * 		Return true if the end was reached, false in the other case.
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
		stop = start + (len-1) * step + 1;
		return end;
	}

	/**
	 * This method allows to get the position of the n-th step inside of the slice
	 * @param n This is the wanted step position in the slice
	 * @return 
	 * 		Return the position of the step inside of the Slice
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
	 * This method allows to set the step size inside of the Slice
	 * @param step This is the new step wanted.
	 */
	public void setStep(int step) {
		if (step == 0) {
			throw new IllegalArgumentException("Step must not be zero");
		}
		this.step = step;
	}

	/**
	 * This method allows to get a String representation of the Slice comparable to the python representation.
	 * @param s This is the string builder
	 * @param len This is the size of the wanted string
	 * @param beg This is the start position of the Slice
	 * @param end This is the end position of the Slice
	 * @param del This is the step of the Slice
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
	/**
	 * This method return a string construction of the slice with the python form.
	 * @return 
	 * 		Return the construct String.
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		appendSliceToString(s, length, start != null ? start : (step > 0 ? 0 : length - 1), stop != null ? stop : (step > 0 ? length : -1), step);
		return s.toString();
	}

	/**
	 * This method allows to get the number of steps inside of the Slice
	 * @return 
	 * 		Return the number of steps inside of the Slice
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
			return getNumSteps(beg, stop, step);
		}
		int beg = start == null ? (step > 0 ? 0: length-1) : start;
		int end = stop == null ? (step > 0 ? length : -1) : stop;
		return getNumSteps(beg, end, step);
	}

	/**
	 * This method allows to get the number of steps inside of the Slice from a point to an other point minus 1 because this is an exclusive position
	 * @param beg starting point
	 * @param end (exclusive) stopping point
	 * @return 
	 * 		Return the numbers of steps between the 2 limits.
	 */
	public int getNumSteps(int beg, int end) {
		return getNumSteps(beg, end, step);
	}

	private static int getNumSteps(int beg, int end, int step) {
		int del = step > 0 ? 1 : -1;
		return Math.max(0, (end - beg - del) / step + 1);
	}

	/**
	 * This method allows to get the last value inside of the Slice.
	 * @return
	 * 		Return the last value in the slice, it can be a lower value than the start if the step is going backward
	 */
	public int getEnd() {
		int n = getNumSteps() - 1;
		if (n < 0)
			throw new IllegalStateException("End is not defined");

		return getPosition(n);
	}

	/**
	 * This method allows to flip the slice direction, after this operation, the slice begins at previous end point, steps
	 * in the opposite direction, and finishes at the previous start point.
	 * <p>
	 * 		Note : the stop value may not be preserved across two flips
	 * </p>
	 * @return 
	 * 		Return the flipped Slice.
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
	 * This method allows to populate given start, stop, step arrays from given slice array
	 * @param slice This is an array of Slices wanted to convert
	 * @param shape This is the array corresponding to the shapes of the Slices entered
	 * @param start This is the array corresponding to the starting positions of the Slices entered
	 * @param stop This is the array corresponding to the stopping positions of the Slices entered
	 * @param step This is the array corresponding to the steps of the Slices entered
	 */
	public static void convertFromSlice(final Slice[] slice, final int[] shape, final int[] start, final int[] stop, final int[] step) {
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
	 * This method allows to convert a set of integer arrays in a slice array
	 * @param start This is the array corresponding to the starting positions of the wanted Slices
	 * @param stop This is the array corresponding to the stopping positions of the wanted Slices
	 * @param step This is the array corresponding to the steps of the wanted Slices
	 * @return 
	 * 		Return a Slice array corresponding to the starts, stops and steps arrays entered.
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
	 * This method allows to convert string in a Slice array
	 * 
	 * @param sliceString This is the String of the Slice array
	 * @return 
	 * 		Return the Slice array created from the given string
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
	 * This method create a string representing the slice taken from given shape
	 * @param shape This is the number of dimensions and the length of each one of them
	 * @param start This is an array of the start positions of Slices
	 * @param stop This is an array of the stop positions of Slices
	 * @param step This is an array of the steps of Slices
	 * @return 
	 * 		Return a string representation of the Slice
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
	 * This method allows to create a string representation of slices. 
	 * @param slices Wanted Slices to put inside the string representation
	 * @return 
	 * 		Return the string representation of the Slices entered.
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
