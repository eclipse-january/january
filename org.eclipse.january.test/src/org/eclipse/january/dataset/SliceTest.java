/*-
 * Copyright (c) 2012, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.function.ThrowingRunnable;

public class SliceTest {

	@Test
	public void testSlice() {
		Slice sl;
		sl = new Slice();
		assertEquals(":", sl.toString());
		sl = new Slice(12);
		assertEquals(":12", sl.toString());
		sl = sl.clone();
		assertEquals(":12", sl.toString());
		sl = new Slice(1, 12);
		assertEquals("1:12", sl.toString());
		sl = new Slice(0, 12);
		assertEquals(":12", sl.toString());
		sl = new Slice(null, 12);
		assertEquals(":12", sl.toString());
		sl = new Slice(11, 12);
		assertEquals("11", sl.toString());
		sl = new Slice(1, 12, 3);
		assertEquals("1:12:3", sl.toString());
		sl = new Slice(11, 12, 3);
		assertEquals("11", sl.toString());
		sl = new Slice(0, 12, 3);
		assertEquals(":12:3", sl.toString());
		sl = new Slice(1, 12).setLength(12);
		assertEquals("1:", sl.toString());
		sl = new Slice(1, null).setLength(12);
		assertEquals("1:", sl.toString());
		sl = new Slice(0, 12).setLength(12);
		assertEquals(":", sl.toString());
		sl = new Slice(1, 12, 3).setLength(12);
		assertEquals("1::3", sl.toString());
		sl = new Slice(0, 12, 3).setLength(12);
		assertEquals("::3", sl.toString());
		sl = new Slice(null, null, 3).setLength(12);
		assertEquals("::3", sl.toString());
		sl = new Slice(null, null, null).setLength(12);
		assertEquals(":", sl.toString());
		sl = new Slice(11, 12);
		assertEquals("11", sl.toString());
		sl = new Slice(0, 1);
		assertEquals("0", sl.toString());
		sl = new Slice(1);
		assertEquals("0", sl.toString());
	}

	@Test
	public void testSliceSteps() {
		Slice sl;

		sl = new Slice(null, null, 3).setLength(1);
		assertEquals(1, sl.getNumSteps());
		sl = new Slice(null, null, 3).setLength(2);
		assertEquals(1, sl.getNumSteps());
		sl = new Slice(null, null, 3).setLength(3);
		assertEquals(1, sl.getNumSteps());
		sl = new Slice(null, null, 3).setLength(4);
		assertEquals(2, sl.getNumSteps());
		sl = new Slice(null, null, 3).setLength(5);
		assertEquals(2, sl.getNumSteps());
		sl = new Slice(null, null, 3).setLength(6);
		assertEquals(2, sl.getNumSteps());
		sl = new Slice(null, null, 3).setLength(7);
		assertEquals(3, sl.getNumSteps());
		sl = new Slice(null, null, 3).setLength(8);
		assertEquals(3, sl.getNumSteps());
		sl = new Slice(null, null, 3).setLength(9);
		assertEquals(3, sl.getNumSteps());

		sl = new Slice().setLength(12);
		assertEquals(12, sl.getNumSteps());
		sl = new Slice(null, null, 2).setLength(12);
		assertEquals(6, sl.getNumSteps());
		sl = new Slice(1, null).setLength(12);
		assertEquals(11, sl.getNumSteps());
		sl = new Slice(1, null, 2).setLength(12);
		assertEquals(6, sl.getNumSteps());
		sl = new Slice(1, null, -2).setLength(12);
		assertEquals(1, sl.getNumSteps());
		sl = new Slice(null, null, -1).setLength(12);
		assertEquals(12, sl.getNumSteps());
		sl = new Slice(null, null, -2).setLength(12);
		assertEquals(6, sl.getNumSteps());
		sl = new Slice(6, null, -2).setLength(12);
		assertEquals(4, sl.getNumSteps());
		sl = new Slice(6, 1, -2).setLength(12);
		assertEquals(3, sl.getNumSteps());
		sl = new Slice(6, 0, -2).setLength(12);
		assertEquals(3, sl.getNumSteps());

		assertThrows(IllegalStateException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				Slice sa = new Slice();
				sa.getNumSteps();
			}
		});

		sl = new Slice(12);
		assertEquals(12, sl.getNumSteps());
		sl = new Slice(null, 12);
		assertEquals(12, sl.getNumSteps());
		sl = new Slice(1, 12);
		assertEquals(11, sl.getNumSteps());
		sl = new Slice(12, 1);
		assertEquals(0, sl.getNumSteps());
		sl = new Slice(1, 12, 2);
		assertEquals(6, sl.getNumSteps());
		sl = new Slice(1, 12, 12);
		assertEquals(1, sl.getNumSteps());
		sl = new Slice(12, 1, -1);
		assertEquals(11, sl.getNumSteps());
		sl = new Slice(1, 12, -1);
		assertEquals(0, sl.getNumSteps());
		sl = new Slice(12, 1, -2);
		assertEquals(6, sl.getNumSteps());
		sl = new Slice(12, 1, -12);
		assertEquals(1, sl.getNumSteps());

		sl = new Slice(null, 11, 1);
		assertEquals(11, sl.getNumSteps());
		assertThrows(IllegalStateException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				Slice sa = new Slice(null, 1, -1);
				sa.getNumSteps();
			}
		});

		sl = new Slice(null, null, 15).setLength(4096);
		assertEquals(274, sl.getNumSteps());
	}

	@Test
	public void testSliceEndPoints() {
		Slice sl;

		sl = new Slice(null, null, 1).setLength(1);
		assertEquals(1, sl.getNumSteps());

		sl = new Slice(null, null, 1).setLength(5);
		assertEquals(5, sl.getNumSteps());
		sl = new Slice(null, 5, 1).setLength(5);
		assertEquals(5, sl.getNumSteps());
		sl = new Slice(0, null, 1).setLength(5);
		assertEquals(5, sl.getNumSteps());
		sl = new Slice(0, 5, 1).setLength(5);
		assertEquals(5, sl.getNumSteps());
		sl = new Slice(0, 5, -1).setLength(5);
		assertEquals(0, sl.getNumSteps());

		sl = new Slice(null, null, -1).setLength(1);
		assertEquals(1, sl.getNumSteps());

		sl = new Slice(null, null, -1).setLength(5);
		assertEquals(5, sl.getNumSteps());
		sl = new Slice(null, -1, -1).setLength(5);
		assertEquals(5, sl.getNumSteps());
		sl = new Slice(4, null, -1).setLength(5);
		assertEquals(5, sl.getNumSteps());
		sl = new Slice(4, -1, -1).setLength(5);
		assertEquals(5, sl.getNumSteps());
		sl = new Slice(4, -1, 1).setLength(5);
		assertEquals(0, sl.getNumSteps());
	}

	@Test
	public void testGetter() {
		Slice sl;

		sl = new Slice().setLength(12);
		assertNull(sl.getStart());
		assertNull(sl.getStop());
		assertEquals(1, sl.getStep());
		assertEquals(12, sl.getLength());

		sl = new Slice(10).setLength(12);
		assertNull(sl.getStart());
		assertEquals(10, (int) sl.getStop());
		assertEquals(1, sl.getStep());
		assertEquals(12, sl.getLength());
	}

	@Test
	public void testSetStartStop() {
		int length = 12;
		int step = 1;
		int last = length - 1;
		int stop = 5;
		Slice sl;

		sl = new Slice().setLength(length);
		sl.setStep(step);
		sl.setStart(null);
		assertNull(sl.getStart());
		assertEquals(length, sl.getNumSteps());

		sl.setStart(1);
		assertEquals(1, (int) sl.getStart());
		assertEquals(last, sl.getNumSteps());

		sl.setStart(-1);
		assertEquals(last, (int) sl.getStart());
		assertEquals(1, sl.getNumSteps());

		sl.setStart(-length-1);
		assertEquals(0, (int) sl.getStart());
		assertEquals(length, sl.getNumSteps());

		sl.setStart(last);
		assertEquals(last, (int) sl.getStart());
		assertEquals(1, sl.getNumSteps());

		sl.setStart(last + 2);
		assertEquals(length, (int) sl.getStart());
		assertEquals(0, sl.getNumSteps());

		sl.setStep(-step);
		sl.setStart(1);
		assertEquals(1, (int) sl.getStart());
		assertEquals(2, sl.getNumSteps());

		sl.setStart(-1);
		assertEquals(last, (int) sl.getStart());
		assertEquals(length, sl.getNumSteps());

		sl.setStart(-length-2);
		assertEquals(-1, (int) sl.getStart());
		assertEquals(0, sl.getNumSteps());

		sl.setStart(last);
		assertEquals(last, (int) sl.getStart());
		assertEquals(length, sl.getNumSteps());
		sl.setStart(last + 2);
		assertEquals(last, (int) sl.getStart());
		assertEquals(length, sl.getNumSteps());

		// with a stop defined
		sl.setStep(step);
		sl.setStart(1);
		sl.setStop(stop);
		assertEquals(1, (int) sl.getStart());
		assertEquals(stop - 1, sl.getNumSteps());

		sl.setStart(-1);
		assertEquals(stop, (int) sl.getStart());
		assertEquals(0, sl.getNumSteps());

		sl.setStart(-length-1);
		assertEquals(0, (int) sl.getStart());
		assertEquals(stop, sl.getNumSteps());

		sl.setStart(last);
		assertEquals(stop, (int) sl.getStart());
		assertEquals(0, sl.getNumSteps());

		sl.setStart(last + 2);
		assertEquals(stop, (int) sl.getStart());
		assertEquals(0, sl.getNumSteps());

		sl.setStop(stop - 2);
		assertEquals(stop, (int) sl.getStart());
		assertEquals(0, sl.getNumSteps());

		sl.setStart(null);
		sl.setStop(null);
		assertNull(sl.getStop());
		assertEquals(length, sl.getNumSteps());

		sl.setStop(-length-1);
		assertEquals(0, (int) sl.getStop());
		assertEquals(0, sl.getNumSteps());

		sl.setStop(length + 1);
		assertEquals(length, (int) sl.getStop());
		assertEquals(length, sl.getNumSteps());

		sl.setStop(stop);
		sl.setStep(-step);
		sl.setStart(1);
		assertEquals(stop, (int) sl.getStart());
		assertEquals(0, sl.getNumSteps());

		sl.setStart(-1);
		assertEquals(last, (int) sl.getStart());
		int expected = last - stop;
		assertEquals(expected, sl.getNumSteps());

		sl.setStart(-length-1);
		assertEquals(stop, (int) sl.getStart());
		assertEquals(0, sl.getNumSteps());

		sl.setStart(last);
		assertEquals(last, (int) sl.getStart());
		assertEquals(expected, sl.getNumSteps());

		sl.setStart(last + 2);
		assertEquals(last, (int) sl.getStart());
		assertEquals(expected, sl.getNumSteps());

		sl.setStart(null);
		sl.setStop(null);
		assertNull(sl.getStop());
		assertEquals(length, sl.getNumSteps());

		sl.setStop(-length-4);
		assertEquals(-1, (int) sl.getStop());
		assertEquals(length, sl.getNumSteps());

		sl.setStop(-length-1);
		assertEquals(-1, (int) sl.getStop());
		assertEquals(length, sl.getNumSteps());

		sl.setStop(length + 1);
		assertEquals(last, (int) sl.getStop());
		assertEquals(0, sl.getNumSteps());

		sl.setStop(null);
		sl.setStart(stop);
		sl.setStop(length + 1);
		assertEquals(stop, (int) sl.getStop());
		assertEquals(0, sl.getNumSteps());
	}

	@Test
	public void testSetLengthStep() {
		Slice sl;

		sl = new Slice().setLength(12);
		sl.setStop(10);
		final Slice sa = sl;
		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			public void run() throws Throwable {
				sa.setLength(9);
			}
		});

		sl = new Slice().setLength(12);
		sl.setStart(3);
		sl.setStop(10);
		assertEquals(10, (int) sl.getStop());
		assertEquals(7, sl.getNumSteps());
		final Slice sb = sl;
		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			public void run() throws Throwable {
				sb.setLength(9);
			}
		});

		sl = new Slice().setLength(12);
		sl.setStep(-2);
		sl.setStart(10);
		assertEquals(10, (int) sl.getStart());
		assertEquals(6, sl.getNumSteps());
		sl.setStop(3);
		assertEquals(4, sl.getNumSteps());
		final Slice sc = sl;
		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			public void run() throws Throwable {
				sc.setLength(9);
			}
		});

		sl.setStart(10);
		sl.setStop(10);
		assertEquals(10, (int) sl.getStop());
		assertEquals(0, sl.getNumSteps());

		final Slice sd = sl;
		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			public void run() throws Throwable {
				sd.setStep(0);
			}
		});

		sl = new Slice(10).setLength(12);
		assertNull(sl.getStart());
		assertEquals(10, (int) sl.getStop());
		assertEquals(1, sl.getStep());
		assertEquals(12, sl.getLength());
	}

	@Test
	public void testSliceEnd() {
		Slice sl;

		sl = new Slice().setLength(12);
		assertEquals(11, sl.getEnd());
		sl = new Slice(null, null, 2).setLength(12);
		assertEquals(10, sl.getEnd());
		sl = new Slice(1, null).setLength(12);
		assertEquals(11, sl.getEnd());
		sl = new Slice(1, null, 2).setLength(12);
		assertEquals(11, sl.getEnd());
		sl = new Slice(1, null, -2).setLength(12);
		assertEquals(1, sl.getEnd());
		sl = new Slice(null, null, -1).setLength(12);
		assertEquals(0, sl.getEnd());
		sl = new Slice(null, null, -2).setLength(12);
		assertEquals(1, sl.getEnd());

		sl = new Slice(12);
		assertEquals(11, sl.getEnd());
		sl = new Slice(1, 12);
		assertEquals(11, sl.getEnd());
		final Slice sa = new Slice(12, 1);
		assertThrows(IllegalStateException.class, new ThrowingRunnable() {
			public void run() throws Throwable {
				sa.getEnd();
			}
		});
		sl = new Slice(1, 12, 2);
		assertEquals(11, sl.getEnd());
		sl = new Slice(1, 12, 12);
		assertEquals(1, sl.getEnd());
		sl = new Slice(12, 1, -1);
		assertEquals(2, sl.getEnd());
		sl = new Slice(12, 1, -2);
		assertEquals(2, sl.getEnd());
		sl = new Slice(12, 1, -12);
		assertEquals(12, sl.getEnd());

		sl = new Slice(null, 12, 2);
		assertEquals(10, sl.getEnd());
		final Slice sb = new Slice(null, 12, -2);
		assertThrows(IllegalStateException.class, new ThrowingRunnable() {
			public void run() throws Throwable {
				sb.getEnd();
			}
		});
		final Slice sc = new Slice(null, null, -2);
		assertThrows(IllegalStateException.class, new ThrowingRunnable() {
			public void run() throws Throwable {
				sc.getEnd();
			}
		});
	}

	@Test
	public void testFlip() {
		Slice sl;

		sl = new Slice().flip();
		assertEquals("::-1", sl.toString());
		assertEquals(":", sl.flip().toString());

		sl = new Slice(12).flip();
		assertEquals("11::-1", sl.toString());
		assertEquals(":12", sl.flip().toString());
		sl = new Slice(1, 12).flip();
		assertEquals("11:0:-1", sl.toString());
		assertEquals("1:12", sl.flip().toString());
		sl = new Slice(0, 12).flip();
		assertEquals("11::-1", sl.toString());
		assertEquals(":12", sl.flip().toString());
		sl = new Slice(null, 12).flip();
		assertEquals("11::-1", sl.toString());
		assertEquals(":12", sl.flip().toString());
		sl = new Slice(11, 12).flip();
		assertEquals("11", sl.toString());
		assertEquals("11", sl.flip().toString());
		sl = new Slice(1, 12, 3).flip();
		assertEquals("10:0:-3", sl.toString());
		assertEquals("1:11:3", sl.flip().toString());
		sl = new Slice(11, 12, 3).flip();
		assertEquals("11", sl.toString());
		assertEquals("11", sl.flip().toString());

		
		sl = new Slice().setLength(12);
		sl.flip();
		assertNull(sl.getStart());
		assertNull(sl.getStop());
		assertEquals(-1, sl.getStep());
		assertEquals(12, sl.getNumSteps());

		sl = new Slice(10).setLength(12);
		sl.flip();
		assertEquals(9, (int) sl.getStart());
		assertNull(sl.getStop());
		assertEquals(-1, sl.getStep());
		assertEquals(10, sl.getNumSteps());

		sl = new Slice(null, 10).setLength(12);
		sl.flip();
		assertEquals(9, (int) sl.getStart());
		assertNull(sl.getStop());
		assertEquals(-1, sl.getStep());
		assertEquals(10, sl.getNumSteps());

		sl = new Slice(null, 4, -1).setLength(12);
		sl.flip();
		assertEquals(5, (int) sl.getStart());
		assertNull(sl.getStop());
		assertEquals(1, sl.getStep());
		assertEquals(7, sl.getNumSteps());

		sl = new Slice(3, 10).setLength(12);
		sl.flip();
		assertEquals(9, (int) sl.getStart());
		assertEquals(2, (int) sl.getStop());
		assertEquals(-1, sl.getStep());
		assertEquals(7, sl.getNumSteps());

		sl = new Slice(9, 2, -1).setLength(12);
		sl.flip();
		assertEquals(3, (int) sl.getStart());
		assertEquals(10, (int) sl.getStop());
		assertEquals(1, sl.getStep());
		assertEquals(7, sl.getNumSteps());
	}

	@Test
	public void testConverters() {
		final int[] start = new int[1];
		final int[] stop  = new int[1];
		final int[] step  = new int[1];
		int[] shape = new int[] {12};

		Slice.convertFromSlice(null, shape, start, stop, step);
		assertEquals(0, start[0]);
		assertEquals(12, stop[0]);
		assertEquals(1, step[0]);

		Slice.convertFromSlice(new Slice[] {null}, shape, start, stop, step);
		assertEquals(0, start[0]);
		assertEquals(12, stop[0]);
		assertEquals(1, step[0]);

		Slice.convertFromSlice(new Slice[] {new Slice(null,11,2)}, shape, start, stop, step);
		assertEquals(0, start[0]);
		assertEquals(11, stop[0]);
		assertEquals(2, step[0]);

		Slice.convertFromSlice(new Slice[] {new Slice(null,null,2)}, shape, start, stop, step);
		assertEquals(0, start[0]);
		assertEquals(12, stop[0]);
		assertEquals(2, step[0]);

		Slice.convertFromSlice(new Slice[] {new Slice(null,6,-2)}, shape, start, stop, step);
		assertEquals(11, start[0]);
		assertEquals(6, stop[0]);
		assertEquals(-2, step[0]);

		Slice.convertFromSlice(new Slice[] {new Slice(null,null,-2)}, shape, start, stop, step);
		assertEquals(11, start[0]);
		assertEquals(-1, stop[0]);
		assertEquals(-2, step[0]);

		Slice.convertFromSlice(new Slice[] {new Slice(1,11,2).setLength(12)}, shape, start, stop, step);
		assertEquals(1, start[0]);
		assertEquals(11, stop[0]);
		assertEquals(2, step[0]);

		Slice.convertFromSlice(new Slice[] {new Slice(3, 6).setLength(12), new Slice().setLength(12)}, shape, start, stop, step);
		assertEquals(3, start[0]);
		assertEquals(6, stop[0]);
		assertEquals(1, step[0]);

		Slice.convertFromSlice(new Slice[] {new Slice().setLength(12)}, shape, start, stop, step);
		assertEquals(0, start[0]);
		assertEquals(12, stop[0]);
		assertEquals(1, step[0]);

		Slice[] sl = Slice.convertToSlice(start, stop, step);
		assertEquals(1, sl.length);
		assertEquals(0, (int) sl[0].getStart());
		assertEquals(12, (int) sl[0].getStop());
		assertEquals(1, sl[0].getStep());

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			public void run() throws Throwable {
				Slice.convertToSlice(start, new int[0], step);
			}
		});

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			public void run() throws Throwable {
				Slice.convertToSlice(start, stop, new int[0]);
			}
		});

		sl = Slice.convertFromString("[:,:,:,:]");
		assertEquals(4, sl.length);
		assertEquals(0, (int) sl[0].getStart());
		assertEquals(0, (int) sl[1].getStart());
		assertEquals(0, (int) sl[2].getStart());
		assertEquals(0, (int) sl[3].getStart());
		assertNull(sl[0].getStop());
		assertNull(sl[1].getStop());
		assertNull(sl[2].getStop());
		assertNull(sl[3].getStop());
		assertEquals(1, sl[0].getStep());
		assertEquals(1, sl[1].getStep());
		assertEquals(1, sl[2].getStep());
		assertEquals(1, sl[3].getStep());

		sl = Slice.convertFromString("[7]");
		assertEquals(7, (int) sl[0].getStart());
		assertEquals(8, (int) sl[0].getStop());
		assertEquals(1, sl[0].getStep());

		sl = Slice.convertFromString("[7:12]");
		assertEquals(7, (int) sl[0].getStart());
		assertEquals(12, (int) sl[0].getStop());
		assertEquals(1, sl[0].getStep());

		sl = Slice.convertFromString("[::]");
		assertEquals(0, (int) sl[0].getStart());
		assertNull(sl[0].getStop());
		assertEquals(1, sl[0].getStep());

		sl = Slice.convertFromString("[1::]");
		assertEquals(1, (int) sl[0].getStart());
		assertNull(sl[0].getStop());
		assertEquals(1, sl[0].getStep());

		sl = Slice.convertFromString("[:3:]");
		assertEquals(0, (int) sl[0].getStart());
		assertEquals(3, (int) sl[0].getStop());
		assertEquals(1, sl[0].getStep());

		sl = Slice.convertFromString("[::-1]");
		assertEquals(0, (int) sl[0].getStart());
		assertNull(sl[0].getStop());
		assertEquals(-1, sl[0].getStep());

		sl = Slice.convertFromString("[10:2:-2]");
		assertEquals(10, (int) sl[0].getStart());
		assertEquals(2, (int) sl[0].getStop());
		assertEquals(-2, sl[0].getStep());
	}

	@Test
	public void testShifts() {
		Slice sl;
		sl = new Slice().setLength(12);
		sl.setStop(2);
		assertEquals(2, sl.getNumSteps());
		assertFalse(sl.setPosition(5));
		assertEquals(5, (int) sl.getStart());
		assertEquals(7, (int) sl.getStop());

		sl.setStart(5);
		assertEquals(5, (int) sl.getStart());

		assertTrue(sl.setPosition(11));
	}

	@Test
	public void testPos() {
		final Slice sa = new Slice(0, 10, 1);
		assertEquals(0, sa.getPosition(0));
		assertEquals(5, sa.getPosition(5));
		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			public void run() throws Throwable {
				sa.getPosition(-1);
			}
		});
		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			public void run() throws Throwable {
				sa.getPosition(10);
			}
		});

		final Slice sb = new Slice(5, 2, -1);
		assertEquals(5, sb.getPosition(0));
		assertEquals(3, sb.getPosition(2));
		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			public void run() throws Throwable {
				sb.getPosition(3);
			}
		});

		final Slice sc = new Slice(null, null, 1).setLength(12);
		assertEquals(0, sc.getPosition(0));
		assertEquals(3, sc.getPosition(3));
		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			public void run() throws Throwable {
				sc.getPosition(12);
			}
		});

		final Slice sd = new Slice(null, null, -1).setLength(12);
		assertEquals(11, sd.getPosition(0));
		assertEquals(8, sd.getPosition(3));
		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			public void run() throws Throwable {
				sd.getPosition(12);
			}
		});

		sd.setLength(-1);
		assertThrows(IllegalStateException.class, new ThrowingRunnable() {
			public void run() throws Throwable {
				sd.getPosition(1);
			}
		});
		sd.setStart(12);
		assertEquals(9, sd.getPosition(3));

		final Slice se = new Slice(null, null, -2).setLength(12);
		assertEquals(11, se.getPosition(0));
		assertEquals(5, se.getPosition(3));
		assertEquals(1, se.getPosition(5));
		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			public void run() throws Throwable {
				se.getPosition(6);
			}
		});

		final Slice sf = new Slice(6, null, -2).setLength(12);
		assertEquals(6, sf.getPosition(0));
		assertEquals(0, sf.getPosition(3));
		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			public void run() throws Throwable {
				sf.getPosition(4);
			}
		});

		final Slice sg = new Slice(6, 1, -2).setLength(12);
		assertEquals(6, sg.getPosition(0));
		assertEquals(2, sg.getPosition(2));
		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			public void run() throws Throwable {
				sg.getPosition(3);
			}
		});

		final Slice sh = new Slice(6, 0, -2).setLength(12);
		assertEquals(6, sh.getPosition(0));
		assertEquals(2, sh.getPosition(2));
		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			public void run() throws Throwable {
				sh.getPosition(3);
			}
		});
	}

	@Test
	public void testSetZeroLength() {
		Slice s = new Slice(4, 5);
		s.setLength(9);

		s.setStart(0);
		s.setStop(0);
		s.setLength(0);

		assertEquals(0, s.getNumSteps());
	}

	@Test
	public void testCreateStrings() {
		assertEquals("", Slice.createString());
		assertEquals("", Slice.createString((Slice[]) null));
		assertEquals(":", Slice.createString(new Slice[1]));
		assertEquals(":", Slice.createString(new Slice()));
		assertEquals(":4", Slice.createString(new Slice(4)));
		assertEquals("4:", Slice.createString(new Slice(4, null)));
		assertEquals("4:7", Slice.createString(new Slice(4, 7).setLength(12)));
		assertEquals("4", Slice.createString(new Slice(4, 5).setLength(12)));
		assertEquals("", Slice.createString(new int[0], new int[] {0}, new int[] {12}, new int[] {1}));
		assertEquals(":", Slice.createString(new int[] {12}, new int[] {0}, new int[] {12}, new int[] {1}));
		assertEquals("4:", Slice.createString(new int[] {12}, new int[] {4}, new int[] {12}, new int[] {1}));
		assertEquals("4:7", Slice.createString(new int[] {12}, new int[] {4}, new int[] {7}, new int[] {1}));
		assertEquals("4", Slice.createString(new int[] {12}, new int[] {4}, new int[] {5}, new int[] {1}));
		assertEquals(":", Slice.createString(new int[] {12}, null, null, null));
		assertEquals("::-1", Slice.createString(new int[] {12}, null, null, new int[] {-1}));
	}

	@Test
	public void testIsSliceComplete() {
		Slice s = new Slice();

		assertTrue(s.isSliceComplete());
		s.setStep(-1);
		assertTrue(s.isSliceComplete());
		s.setStep(2);
		assertFalse(s.isSliceComplete());
		s.setStep(-2);
		assertFalse(s.isSliceComplete());
		s.setStep(1);
		s.setStart(4);
		assertFalse(s.isSliceComplete());
		s.setStart(null);
		s.setStop(12);
		assertFalse(s.isSliceComplete());
		s.setStop(null);

		s.setStart(4);
		s.setLength(9);
		assertFalse(s.isSliceComplete());
		s.setStart(null);
		assertTrue(s.isSliceComplete());
		s.setStart(0);
		assertTrue(s.isSliceComplete());
	}
}
