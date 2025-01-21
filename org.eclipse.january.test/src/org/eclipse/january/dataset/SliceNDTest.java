/*-
 * Copyright (c) 2014, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.function.ThrowingRunnable;

public class SliceNDTest {

	@Test
	public void testSliceND() {
		final int[] step;
		int[] lstart;
		int[] lstop;
		SliceND slice;

		// null dataset
		slice = new SliceND(null);
		assertTrue(slice.isAll());
		assertEquals("", slice.toString());
		assertNull(slice.convertToSlice());

		// zero-rank dataset
		slice = new SliceND(new int[0]);
		assertTrue(slice.isAll());
		assertEquals("", slice.toString());

		// zero-sized
		slice = new SliceND(new int[] {0});
		assertFalse(slice.isAll());
		assertEquals(":", slice.toString());

		lstart = new int[] {};
		lstop = new int[] {};
		slice = new SliceND(new int[] {}, null, null, new int[] {});
		assertArrayEquals(new int[] {}, slice.getShape());

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				new SliceND(new int[] {1}, null, null, new int[] {});
			}
		});

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				new SliceND(new int[] {3}, null, null, new int[1]);
			}
		});

		step = new int[] {2};
		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				new SliceND(new int[] {2, 3}, null, null, step);
			}
		});

		lstart = new int[1];
		lstop = new int[1];
		slice = new SliceND(new int[] {7}, null, null, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());
		assertArrayEquals(new int[] {7}, slice.getMaxShape());

		lstart[0] = 0;
		slice = new SliceND(new int[] {7}, lstart, null, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());

		lstart[0] = 3;
		slice = new SliceND(new int[] {7}, lstart, null, step);
		assertArrayEquals(new int[] {2}, slice.getShape());
		assertArrayEquals(new int[] {3}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());

		lstart[0] = -4;
		slice = new SliceND(new int[] {7}, lstart, null, step);
		assertArrayEquals(new int[] {2}, slice.getShape());
		assertArrayEquals(new int[] {3}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());

		lstart[0] = -8;
		slice = new SliceND(new int[] {7}, lstart, null, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());

		lstart[0] = 7;
		slice = new SliceND(new int[] {7}, lstart, null, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {7}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());

		lstart[0] = 8;
		slice = new SliceND(new int[] {7}, lstart, null, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {7}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());

		lstop[0] = 7;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());

		lstop[0] = -3;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertArrayEquals(new int[] {2}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {4}, slice.getStop());

		lstop[0] = 0;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {0}, slice.getStop());

		lstop[0] = -6;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertArrayEquals(new int[] {1}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {1}, slice.getStop());

		lstop[0] = -8;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {0}, slice.getStop());

		lstop[0] = 9;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());

		lstart[0] = 4;
		lstop[0] = 2;
		slice = new SliceND(new int[] {7}, lstart, lstop, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {4}, slice.getStart());
		assertArrayEquals(new int[] {4}, slice.getStop());

		step[0] = -2;
		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				new SliceND(new int[] {2, 3}, null, null, step);
			}
		});

		slice = new SliceND(new int[] {7}, null, null, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());

		lstart[0] = 0;
		slice = new SliceND(new int[] {7}, lstart, null, step);
		assertArrayEquals(new int[] {1}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());

		lstart[0] = 3;
		slice = new SliceND(new int[] {7}, lstart, null, step);
		assertArrayEquals(new int[] {2}, slice.getShape());
		assertArrayEquals(new int[] {3}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());

		lstart[0] = -4;
		slice = new SliceND(new int[] {7}, lstart, null, step);
		assertArrayEquals(new int[] {2}, slice.getShape());
		assertArrayEquals(new int[] {3}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());

		lstart[0] = -8;
		slice = new SliceND(new int[] {7}, lstart, null, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {-1}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());

		lstart[0] = -7;
		slice = new SliceND(new int[] {7}, lstart, null, step);
		assertArrayEquals(new int[] {1}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());

		lstart[0] = 7;
		slice = new SliceND(new int[] {7}, lstart, null, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());

		lstart[0] = 8;
		slice = new SliceND(new int[] {7}, lstart, null, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());


		lstop[0] = 0;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertArrayEquals(new int[] {3}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {0}, slice.getStop());

		lstop[0] = 1;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertArrayEquals(new int[] {3}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {1}, slice.getStop());

		lstop[0] = -1;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {6}, slice.getStop());

		lstop[0] = -2;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertArrayEquals(new int[] {1}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {5}, slice.getStop());

		lstop[0] = -3;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertArrayEquals(new int[] {1}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {4}, slice.getStop());

		lstop[0] = -8;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());

		lstop[0] = -6;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertArrayEquals(new int[] {3}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {1}, slice.getStop());

		lstop[0] = 8;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {6}, slice.getStop());

		lstop[0] = -8;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());

		lstart[0] = 1;
		lstop[0] = 5;
		slice = new SliceND(new int[] {7}, lstart, lstop, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {1}, slice.getStart());
		assertArrayEquals(new int[] {1}, slice.getStop());

		slice = new SliceND(new int[] {8, 4}, new int[] {1 , 1}, new int[] {8, 4}, new int[] {3, 1});
		assertArrayEquals(new int[] {3, 3}, slice.getShape());
		assertArrayEquals(new int[] {1, 1}, slice.getStart());
		assertArrayEquals(new int[] {8, 4}, slice.getStop());

		slice = new SliceND(new int[] {8, 4}, new int[] {5 , 1}, new int[] {1, 4}, new int[] {3, 1});
		assertArrayEquals(new int[] {0, 3}, slice.getShape());
		assertArrayEquals(new int[] {5, 1}, slice.getStart());
		assertArrayEquals(new int[] {5, 4}, slice.getStop());

		slice = new SliceND(new int[] {8, 4}, new int[] {5 , 1}, new int[] {1, 4}, new int[] {-3, 1});
		assertArrayEquals(new int[] {2, 3}, slice.getShape());
		assertArrayEquals(new int[] {5, 1}, slice.getStart());
		assertArrayEquals(new int[] {1, 4}, slice.getStop());

		slice = new SliceND(new int[] {8, 4}, new int[] {1 , 1}, new int[] {8, 4}, new int[] {-3, 1});
		assertArrayEquals(new int[] {0, 3}, slice.getShape());
		assertArrayEquals(new int[] {1, 1}, slice.getStart());
		assertArrayEquals(new int[] {1, 4}, slice.getStop());

		slice = new SliceND(new int[] {8, 4}, new Slice(1,8,-3), new Slice(1, 4));
		assertArrayEquals(new int[] {0, 3}, slice.getShape());
		assertArrayEquals(new int[] {1, 1}, slice.getStart());
		assertArrayEquals(new int[] {1, 4}, slice.getStop());

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				new SliceND(new int[] {2, 3}, new Slice[] {null, null, null});
			}
		});
}

	@Test
	public void testExpandedSliceND() {
		final int[] step;
		int[] lstart;
		int[] lstop;
		SliceND slice;

		lstart = new int[] {};
		lstop = new int[] {};

		slice = new SliceND(null, null, null, null, null);
		assertArrayEquals(new int[] {}, slice.getShape());
		assertArrayEquals(new int[] {}, slice.getStart());
		assertArrayEquals(new int[] {}, slice.getStop());

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				new SliceND(new int[] {1}, new int[] {}, null, null, null);
			}
		});

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				new SliceND(new int[] {1}, new int[] {2, 2}, null, null, null);
			}
		});

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				new SliceND(new int[] {5}, new int[] {2}, null, null, null);
			}
		});

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				new SliceND(new int[] {5}, new int[] {2}, new int[0], null, null);
			}
		});

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				new SliceND(new int[] {5}, new int[] {2}, null, new int[2], null);
			}
		});

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				new SliceND(new int[] {5}, new int[] {2}, null, null, new int[0]);
			}
		});

		step = new int[] {2};

		lstart = new int[1];
		lstop = new int[1];
		slice = new SliceND(new int[] {7}, new int[] {9}, null, null, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());
		assertArrayEquals(new int[] {9}, slice.getMaxShape());
		assertFalse(slice.isExpanded());

		lstart[0] = 0;
		slice = new SliceND(new int[] {7}, new int[] {9}, lstart, null, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());
		assertFalse(slice.isExpanded());

		lstart[0] = 3;
		slice = new SliceND(new int[] {7}, new int[] {9}, lstart, null, step);
		assertArrayEquals(new int[] {2}, slice.getShape());
		assertArrayEquals(new int[] {3}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());

		lstart[0] = 8;
		slice = new SliceND(new int[] {7}, new int[] {9}, lstart, null, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {8}, slice.getStart());
		assertArrayEquals(new int[] {8}, slice.getStop());
		assertTrue(slice.isExpanded());

		lstart[0] = 8;
		lstop[0] = 10;
		slice = new SliceND(new int[] {7}, new int[] {9}, lstart, lstop, step);
		assertArrayEquals(new int[] {1}, slice.getShape());
		assertArrayEquals(new int[] {8}, slice.getStart());
		assertArrayEquals(new int[] {9}, slice.getStop());
		assertTrue(slice.isExpanded());

		lstart[0] = 10;
		slice = new SliceND(new int[] {7}, new int[] {9}, lstart, lstop, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {9}, slice.getStart());
		assertArrayEquals(new int[] {9}, slice.getStop());

		lstart[0] = 5;
		lstop[0] = 2;
		slice = new SliceND(new int[] {7}, new int[] {9}, lstart, lstop, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {5}, slice.getStart());
		assertArrayEquals(new int[] {5}, slice.getStop());

		lstart[0] = 12;
		lstop[0] = 6;
		slice = new SliceND(new int[] {7}, new int[] {19}, lstart, lstop, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {12}, slice.getStart());
		assertArrayEquals(new int[] {12}, slice.getStop());

		lstop[0] = 8;
		slice = new SliceND(new int[] {7}, new int[] {19}, lstart, lstop, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {12}, slice.getStart());
		assertArrayEquals(new int[] {12}, slice.getStop());

		lstart[0] = 10;
		slice = new SliceND(new int[] {7}, new int[] {9}, lstart, null, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {9}, slice.getStart());
		assertArrayEquals(new int[] {9}, slice.getStop());

		lstart[0] = -4;
		slice = new SliceND(new int[] {7}, new int[] {9}, lstart, null, step);
		assertArrayEquals(new int[] {2}, slice.getShape());
		assertArrayEquals(new int[] {3}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());

		lstart[0] = -8;
		slice = new SliceND(new int[] {7}, new int[] {9}, lstart, null, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());

		lstart[0] = 7;
		slice = new SliceND(new int[] {7}, new int[] {9}, lstart, null, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {7}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());
		assertArrayEquals(new int[] {7}, slice.getSourceShape());

		lstart[0] = 8;
		slice = new SliceND(new int[] {7}, new int[] {9}, lstart, null, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {8}, slice.getStart());
		assertArrayEquals(new int[] {8}, slice.getStop());
		assertArrayEquals(new int[] {8}, slice.getSourceShape());
		assertFalse(slice.isAll());

		lstop[0] = 7;
		slice = new SliceND(new int[] {7}, new int[] {9}, null, lstop, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());
		assertArrayEquals(new int[] {7}, slice.getSourceShape());

		lstop[0] = -3;
		slice = new SliceND(new int[] {7}, new int[] {9}, null, lstop, step);
		assertArrayEquals(new int[] {2}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {4}, slice.getStop());

		lstop[0] = 0;
		slice = new SliceND(new int[] {7}, new int[] {9}, null, lstop, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {0}, slice.getStop());

		lstop[0] = -6;
		slice = new SliceND(new int[] {7}, new int[] {9}, null, lstop, step);
		assertArrayEquals(new int[] {1}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {1}, slice.getStop());

		lstop[0] = -8;
		slice = new SliceND(new int[] {7}, new int[] {9}, null, lstop, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {0}, slice.getStop());
		assertArrayEquals(new int[] {7}, slice.getSourceShape());

		lstop[0] = 8;
		slice = new SliceND(new int[] {7}, new int[] {9}, null, lstop, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {8}, slice.getStop());
		assertArrayEquals(new int[] {8}, slice.getSourceShape());

		lstop[0] = 9;
		slice = new SliceND(new int[] {7}, new int[] {9}, null, lstop, step);
		assertArrayEquals(new int[] {5}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {9}, slice.getStop());
		assertArrayEquals(new int[] {9}, slice.getSourceShape());

		step[0] = -2;
		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				new SliceND(new int[] {2, 3}, null, null, step);
			}
		});

		slice = new SliceND(new int[] {7}, new int[] {9}, null, null, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());

		lstart[0] = 0;
		slice = new SliceND(new int[] {7}, new int[] {9}, lstart, null, step);
		assertArrayEquals(new int[] {1}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());

		lstart[0] = 3;
		slice = new SliceND(new int[] {7}, new int[] {9}, lstart, null, step);
		assertArrayEquals(new int[] {2}, slice.getShape());
		assertArrayEquals(new int[] {3}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());

		lstart[0] = 8;
		slice = new SliceND(new int[] {7}, new int[] {9}, lstart, null, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());

		lstart[0] = -4;
		slice = new SliceND(new int[] {7}, new int[] {9}, lstart, null, step);
		assertArrayEquals(new int[] {2}, slice.getShape());
		assertArrayEquals(new int[] {3}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());

		lstart[0] = -8;
		slice = new SliceND(new int[] {7}, new int[] {9}, lstart, null, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {-1}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());

		lstart[0] = -7;
		slice = new SliceND(new int[] {7}, new int[] {9}, lstart, null, step);
		assertArrayEquals(new int[] {1}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());

		lstart[0] = 7;
		slice = new SliceND(new int[] {7}, new int[] {9}, lstart, null, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());

		lstart[0] = 8;
		slice = new SliceND(new int[] {7}, new int[] {9}, lstart, null, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());

		lstop[0] = 0;
		slice = new SliceND(new int[] {7}, new int[] {9}, null, lstop, step);
		assertArrayEquals(new int[] {3}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {0}, slice.getStop());

		lstop[0] = 1;
		slice = new SliceND(new int[] {7}, new int[] {9}, null, lstop, step);
		assertArrayEquals(new int[] {3}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {1}, slice.getStop());

		lstop[0] = -1;
		slice = new SliceND(new int[] {7}, new int[] {9}, null, lstop, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {6}, slice.getStop());

		lstop[0] = -2;
		slice = new SliceND(new int[] {7}, new int[] {9}, null, lstop, step);
		assertArrayEquals(new int[] {1}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {5}, slice.getStop());

		lstop[0] = -3;
		slice = new SliceND(new int[] {7}, new int[] {9}, null, lstop, step);
		assertArrayEquals(new int[] {1}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {4}, slice.getStop());

		lstop[0] = -9;
		slice = new SliceND(new int[] {7}, new int[] {9}, null, lstop, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());

		lstop[0] = -6;
		slice = new SliceND(new int[] {7}, new int[] {9}, null, lstop, step);
		assertArrayEquals(new int[] {3}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {1}, slice.getStop());

		lstop[0] = 8;
		slice = new SliceND(new int[] {7}, new int[] {9}, null, lstop, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {6}, slice.getStop());

		lstop[0] = -8;
		slice = new SliceND(new int[] {7}, new int[] {9}, null, lstop, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());

		slice = new SliceND(new int[] {7, 12}, new int[] {9, 12}, (Slice[]) null);
		assertArrayEquals(new int[] {7, 12}, slice.getShape());
		assertArrayEquals(new int[] {0, 0}, slice.getStart());
		assertArrayEquals(new int[] {7, 12}, slice.getStop());

		slice = new SliceND(new int[] {7, 12}, new int[] {9, 12}, new Slice(null, -8, step[0]), null);
		assertArrayEquals(new int[] {4, 12}, slice.getShape());
		assertArrayEquals(new int[] {6, 0}, slice.getStart());
		assertArrayEquals(new int[] {-1, 12}, slice.getStop());
	}

	@Test
	public void testUnlimitedSliceND() {
		final int[] step;
		final int[] lstart;
		int[] lstop;
		SliceND slice;

		step = new int[] {2};
		lstart = new int[1];
		lstop = new int[1];
		slice = new SliceND(new int[] {7}, new int[] {-1}, null, null, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());
		assertArrayEquals(new int[] {7}, slice.getSourceShape());

		lstart[0] = 0;
		slice = new SliceND(new int[] {7}, new int[] {-1}, lstart, null, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());

		lstart[0] = 3;
		slice = new SliceND(new int[] {7}, new int[] {-1}, lstart, null, step);
		assertArrayEquals(new int[] {2}, slice.getShape());
		assertArrayEquals(new int[] {3}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());

		lstart[0] = -4;
		slice = new SliceND(new int[] {7}, new int[] {-1}, lstart, null, step);
		assertArrayEquals(new int[] {2}, slice.getShape());
		assertArrayEquals(new int[] {3}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());

		lstart[0] = -8;
		slice = new SliceND(new int[] {7}, new int[] {-1}, lstart, null, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());

		lstart[0] = 7;
		slice = new SliceND(new int[] {7}, new int[] {-1}, lstart, null, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {7}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());

		lstart[0] = 8;
		slice = new SliceND(new int[] {7}, new int[] {-1}, lstart, null, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {8}, slice.getStart());
		assertArrayEquals(new int[] {8}, slice.getStop());

		lstop[0] = 7;
		slice = new SliceND(new int[] {7}, new int[] {-1}, null, lstop, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());
		assertArrayEquals(new int[] {7}, slice.getSourceShape());

		lstop[0] = -3;
		slice = new SliceND(new int[] {7}, new int[] {-1}, null, lstop, step);
		assertArrayEquals(new int[] {2}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {4}, slice.getStop());

		lstop[0] = 0;
		slice = new SliceND(new int[] {7}, new int[] {-1}, null, lstop, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {0}, slice.getStop());

		lstop[0] = -6;
		slice = new SliceND(new int[] {7}, new int[] {-1}, null, lstop, step);
		assertArrayEquals(new int[] {1}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {1}, slice.getStop());

		lstop[0] = -8;
		slice = new SliceND(new int[] {7}, new int[] {-1}, null, lstop, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {0}, slice.getStop());

		lstop[0] = 8;
		slice = new SliceND(new int[] {7}, new int[] {-1}, null, lstop, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {8}, slice.getStop());
		assertArrayEquals(new int[] {8}, slice.getSourceShape());

		lstop[0] = 9;
		slice = new SliceND(new int[] {7}, new int[] {-1}, null, lstop, step);
		assertArrayEquals(new int[] {5}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {9}, slice.getStop());
		assertArrayEquals(new int[] {9}, slice.getSourceShape());

		lstop[0] = 12;
		slice = new SliceND(new int[] {7}, new int[] {-1}, null, lstop, step);
		assertArrayEquals(new int[] {6}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {12}, slice.getStop());
		assertArrayEquals(new int[] {12}, slice.getSourceShape());

		lstart[0] = 2;
		lstop[0] = 7;
		slice = new SliceND(new int[] {7}, new int[] {-1}, lstart, lstop, step);
		assertArrayEquals(new int[] {3}, slice.getShape());
		assertArrayEquals(new int[] {2}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());
		assertArrayEquals(new int[] {7}, slice.getSourceShape());

		lstart[0] = 2;
		lstop[0] = 12;
		slice = new SliceND(new int[] {7}, new int[] {-1}, lstart, lstop, step);
		assertArrayEquals(new int[] {5}, slice.getShape());
		assertArrayEquals(new int[] {2}, slice.getStart());
		assertArrayEquals(new int[] {12}, slice.getStop());
		assertArrayEquals(new int[] {12}, slice.getSourceShape());

		lstart[0] = 9;
		lstop[0] = 8;
		slice = new SliceND(new int[] {7}, new int[] {-1}, lstart, lstop, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {9}, slice.getStart());
		assertArrayEquals(new int[] {9}, slice.getStop());
		assertArrayEquals(new int[] {9}, slice.getSourceShape());

		lstop[0] = 2;
		slice = new SliceND(new int[] {7}, new int[] {-1}, lstart, lstop, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {9}, slice.getStart());
		assertArrayEquals(new int[] {9}, slice.getStop());
		assertArrayEquals(new int[] {9}, slice.getSourceShape());

		step[0]= -2;
		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				new SliceND(new int[] {2, 3}, null, null, step);
			}
		});

		slice = new SliceND(new int[] {7}, new int[] {-1}, null, null, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());

		lstart[0] = 0;
		slice = new SliceND(new int[] {7}, new int[] {-1}, lstart, null, step);
		assertArrayEquals(new int[] {1}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());

		lstart[0] = 3;
		slice = new SliceND(new int[] {7}, new int[] {-1}, lstart, null, step);
		assertArrayEquals(new int[] {2}, slice.getShape());
		assertArrayEquals(new int[] {3}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());

		lstart[0] = -4;
		slice = new SliceND(new int[] {7}, new int[] {-1}, lstart, null, step);
		assertArrayEquals(new int[] {2}, slice.getShape());
		assertArrayEquals(new int[] {3}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());

		lstart[0] = -8;
		slice = new SliceND(new int[] {7}, new int[] {-1}, lstart, null, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {-1}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());

		lstart[0] = -7;
		slice = new SliceND(new int[] {7}, new int[] {-1}, lstart, null, step);
		assertArrayEquals(new int[] {1}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());

		lstart[0] = 7;
		slice = new SliceND(new int[] {7}, new int[] {-1}, lstart, null, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());

		lstart[0] = 8;
		slice = new SliceND(new int[] {7}, new int[] {-1}, lstart, null, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());


		lstop[0] = 0;
		slice = new SliceND(new int[] {7}, new int[] {-1}, null, lstop, step);
		assertArrayEquals(new int[] {3}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {0}, slice.getStop());

		lstop[0] = 1;
		slice = new SliceND(new int[] {7}, new int[] {-1}, null, lstop, step);
		assertArrayEquals(new int[] {3}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {1}, slice.getStop());

		lstop[0] = -1;
		slice = new SliceND(new int[] {7}, new int[] {-1}, null, lstop, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {6}, slice.getStop());

		lstop[0] = -2;
		slice = new SliceND(new int[] {7}, new int[] {-1}, null, lstop, step);
		assertArrayEquals(new int[] {1}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {5}, slice.getStop());

		lstop[0] = -3;
		slice = new SliceND(new int[] {7}, new int[] {-1}, null, lstop, step);
		assertArrayEquals(new int[] {1}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {4}, slice.getStop());

		lstop[0] = -8;
		slice = new SliceND(new int[] {7}, new int[] {-1}, null, lstop, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());

		lstop[0] = -6;
		slice = new SliceND(new int[] {7}, new int[] {-1}, null, lstop, step);
		assertArrayEquals(new int[] {3}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {1}, slice.getStop());

		lstop[0] = 8;
		slice = new SliceND(new int[] {7}, new int[] {-1}, null, lstop, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {6}, slice.getStop());

		lstop[0] = -8;
		slice = new SliceND(new int[] {7}, new int[] {-1}, null, lstop, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());
	}

	@Test
	public void testIsAll() {
		int[] step;
		int[] lstart;
		int[] lstop;
		SliceND slice;

		step = new int[] {};
		lstart = new int[] {};
		lstop = new int[] {};
		slice = new SliceND(new int[] {}, null, null, step);
		assertTrue(slice.isAll());

		step = new int[] {1};
		slice = new SliceND(new int[] {7}, null, null, step);
		assertTrue(slice.isAll());

		step = new int[] {-1};
		slice = new SliceND(new int[] {7}, null, null, step);
		assertFalse(slice.isAll());

		lstart = new int[1];
		lstop = new int[1];

		step = new int[] {2};
		slice = new SliceND(new int[] {7}, null, null, step);
		assertFalse(slice.isAll());

		lstart[0] = 0;
		slice = new SliceND(new int[] {7}, lstart, null, step);
		assertFalse(slice.isAll());

		lstart[0] = 3;
		slice = new SliceND(new int[] {7}, lstart, null, step);
		assertFalse(slice.isAll());

		lstart[0] = -4;
		slice = new SliceND(new int[] {7}, lstart, null, step);
		assertFalse(slice.isAll());

		lstart[0] = -8;
		slice = new SliceND(new int[] {7}, lstart, null, step);
		assertFalse(slice.isAll());

		lstart[0] = 7;
		slice = new SliceND(new int[] {7}, lstart, null, step);
		assertFalse(slice.isAll());

		lstart[0] = 8;
		slice = new SliceND(new int[] {7}, lstart, null, step);
		assertFalse(slice.isAll());

		lstop[0] = 7;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertFalse(slice.isAll());

		lstop[0] = -3;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertFalse(slice.isAll());

		lstop[0] = 0;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertFalse(slice.isAll());

		lstop[0] = -6;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertFalse(slice.isAll());

		lstop[0] = -8;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertFalse(slice.isAll());

		lstop[0] = 9;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertFalse(slice.isAll());


		step = new int[] {-2};

		slice = new SliceND(new int[] {7}, null, null, step);
		assertFalse(slice.isAll());

		lstart[0] = 0;
		slice = new SliceND(new int[] {7}, lstart, null, step);
		assertFalse(slice.isAll());

		lstart[0] = 3;
		slice = new SliceND(new int[] {7}, lstart, null, step);
		assertFalse(slice.isAll());

		lstart[0] = -4;
		slice = new SliceND(new int[] {7}, lstart, null, step);
		assertFalse(slice.isAll());

		lstart[0] = -8;
		slice = new SliceND(new int[] {7}, lstart, null, step);
		assertFalse(slice.isAll());

		lstart[0] = -7;
		slice = new SliceND(new int[] {7}, lstart, null, step);
		assertFalse(slice.isAll());

		lstart[0] = 7;
		slice = new SliceND(new int[] {7}, lstart, null, step);
		assertFalse(slice.isAll());

		lstart[0] = 8;
		slice = new SliceND(new int[] {7}, lstart, null, step);
		assertFalse(slice.isAll());


		lstop[0] = 0;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertFalse(slice.isAll());

		lstop[0] = 1;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertFalse(slice.isAll());

		lstop[0] = -1;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertFalse(slice.isAll());

		lstop[0] = -2;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertFalse(slice.isAll());

		lstop[0] = -3;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertFalse(slice.isAll());

		lstop[0] = -8;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertFalse(slice.isAll());

		lstop[0] = -6;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertFalse(slice.isAll());

		lstop[0] = 8;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertFalse(slice.isAll());

		lstop[0] = -8;
		slice = new SliceND(new int[] {7}, null, lstop, step);
		assertFalse(slice.isAll());
	}

	@Test
	public void testFlip() {
		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				new SliceND(new int[] {}, null, null, new int[] {}).flip(0);
			}
		});

		int[] step;
		int[] lstart;
		SliceND slice;

		step = new int[] {2};
		lstart = new int[1];
		slice = new SliceND(new int[] {7}, null, null, step).flip();
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());
		assertArrayEquals(new int[] {-2}, slice.getStep());
		slice.flip();
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {8}, slice.getStop());
		assertArrayEquals(new int[] {2}, slice.getStep());

		lstart = new int[] {1};
		slice = new SliceND(new int[] {7}, lstart, null, step).flip();
		assertArrayEquals(new int[] {3}, slice.getShape());
		assertArrayEquals(new int[] {5}, slice.getStart());
		assertArrayEquals(new int[] {-1}, slice.getStop());
		assertArrayEquals(new int[] {-2}, slice.getStep());
		slice.flip();
		assertArrayEquals(new int[] {3}, slice.getShape());
		assertArrayEquals(new int[] {1}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());
		assertArrayEquals(new int[] {2}, slice.getStep());

		lstart = new int[] {6};
		slice = new SliceND(new int[] {7}, lstart, null, step).flip();
		assertArrayEquals(new int[] {1}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {4}, slice.getStop());
		assertArrayEquals(new int[] {-2}, slice.getStep());
		slice.flip();
		assertArrayEquals(new int[] {1}, slice.getShape());
		assertArrayEquals(new int[] {6}, slice.getStart());
		assertArrayEquals(new int[] {8}, slice.getStop());
		assertArrayEquals(new int[] {2}, slice.getStep());

		step = new int[] {2, -3};
		lstart = new int[] {3, 4};
		slice = new SliceND(new int[] {7, 9}, lstart, null, step).flip(0);
		assertArrayEquals(new int[] {2, 2}, slice.getShape());
		assertArrayEquals(new int[] {5, 4}, slice.getStart());
		assertArrayEquals(new int[] {1, -1}, slice.getStop());
		assertArrayEquals(new int[] {-2, -3}, slice.getStep());
		slice.flip(0);
		assertArrayEquals(new int[] {2, 2}, slice.getShape());
		assertArrayEquals(new int[] {3, 4}, slice.getStart());
		assertArrayEquals(new int[] {7, -1}, slice.getStop());
		assertArrayEquals(new int[] {2, -3}, slice.getStep());
		slice.flip(-2);
		assertArrayEquals(new int[] {2, 2}, slice.getShape());
		assertArrayEquals(new int[] {5, 4}, slice.getStart());
		assertArrayEquals(new int[] {1, -1}, slice.getStop());
		assertArrayEquals(new int[] {-2, -3}, slice.getStep());
		slice.flip(0);

		slice.flip();
		assertArrayEquals(new int[] {2, 2}, slice.getShape());
		assertArrayEquals(new int[] {5, 1}, slice.getStart());
		assertArrayEquals(new int[] {1, 7}, slice.getStop());
		assertArrayEquals(new int[] {-2, 3}, slice.getStep());
		slice.flip();
		assertArrayEquals(new int[] {2, 2}, slice.getShape());
		assertArrayEquals(new int[] {3, 4}, slice.getStart());
		assertArrayEquals(new int[] {7, -1}, slice.getStop());
		assertArrayEquals(new int[] {2, -3}, slice.getStep());

		slice = new SliceND(null);
		slice.flip();
		slice.flip(0); // perhaps should throw exception
	}

	/**
	 * Test that demonstrates Python slicing behaviour.
	 * <p>
	 * Negative end points are always wrapped once so that for negative steps, to specify
	 * explicitly stopping at the beginning, you need to use -length-1
	 */
	@Test
	public void testSliceNDNegativeStepEndPoints() {
		// ::-1 => 511:-1:-1
		SliceND slice = new SliceND(new int[] {512}, null, null, new int[] {-1});
		assertEquals(511, slice.getStart()[0]);
		assertEquals(512, slice.getShape()[0]);
		assertEquals(-1, slice.getStop()[0]);

		// :-1:-1 => 511:511:-1
		slice = new SliceND(new int[] {512}, null, new int[] {-1}, new int[] {-1});
		assertEquals(511, slice.getStart()[0]);
		assertEquals(0, slice.getShape()[0]);
		assertEquals(511, slice.getStop()[0]);

		// :-513:-1 => 511:-1:-1
		slice = new SliceND(new int[] {512}, null, new int[] {-513}, new int[] {-1});
		assertEquals(511, slice.getStart()[0]);
		assertEquals(512, slice.getShape()[0]);
		assertEquals(-1, slice.getStop()[0]);

		// 511::-1 => 511:-1:-1
		slice = new SliceND(new int[] {512}, new int[] {511}, null, new int[] {-1});
		assertEquals(511, slice.getStart()[0]);
		assertEquals(512, slice.getShape()[0]);
		assertEquals(-1, slice.getStop()[0]);

		// 511:-1:-1 => 511:511:-1
		slice = new SliceND(new int[] {512}, new int[] {511}, new int[] {-1}, new int[] {-1});
		assertEquals(511, slice.getStart()[0]);
		assertEquals(0, slice.getShape()[0]);
		assertEquals(511, slice.getStop()[0]);

		// 511:-513:-1 => 511:-1:-1
		slice = new SliceND(new int[] {512}, new int[] {511}, new int[] {-513}, new int[] {-1});
		assertEquals(511, slice.getStart()[0]);
		assertEquals(512, slice.getShape()[0]);
		assertEquals(-1, slice.getStop()[0]);
	}

	@Test
	public void testSliceWithinShape() {
		assertTrue(SliceND.isSliceWithinShape(0, 0, 0, 1));
		assertFalse(SliceND.isSliceWithinShape(0, 1, 0, 1));
		assertFalse(SliceND.isSliceWithinShape(0, 0, 1, 1));

		assertTrue(SliceND.isSliceWithinShape(5, 0, 5, 1));
		assertTrue(SliceND.isSliceWithinShape(5, 1, 1, 1));
		assertFalse(SliceND.isSliceWithinShape(5, -1, 1, 1));
		assertFalse(SliceND.isSliceWithinShape(5, 3, 2, 1));
		assertTrue(SliceND.isSliceWithinShape(5, 1, 5, 1));
		assertTrue(SliceND.isSliceWithinShape(5, 4, 4, 1));
		assertFalse(SliceND.isSliceWithinShape(5, 5, 5, 1));
		assertFalse(SliceND.isSliceWithinShape(5, 4, 6, 1));
		assertFalse(SliceND.isSliceWithinShape(5, 2, 1, 1));

		assertTrue(SliceND.isSliceWithinShape(5, 4, -1, -1));
		assertTrue(SliceND.isSliceWithinShape(5, 1, 1, -1));
		assertTrue(SliceND.isSliceWithinShape(5, 4, 0, -1));
		assertTrue(SliceND.isSliceWithinShape(5, 4, 4, -1));
		assertFalse(SliceND.isSliceWithinShape(5, 5, 5, -1));
		assertFalse(SliceND.isSliceWithinShape(5, -1, -1, -1));
		assertFalse(SliceND.isSliceWithinShape(5, 1, 2, -1));
		assertFalse(SliceND.isSliceWithinShape(5, 4, -2, -1));
	}

	@Test
	public void testUpdateSourceShape() {
		// (8,12)[6:2:-3, 5:9] => (2,3)
		final SliceND slice = new SliceND(new int[] {8, 12}, new int[] {6 , 5}, new int[] {2, 9}, new int[] {-3, 1});

		slice.updateSourceShape(13, 12);

		slice.updateSourceShape(8,14);

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				slice.updateSourceShape(8, 3);
			}
		});

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				slice.updateSourceShape(8, 3);
			}
		});

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				slice.updateSourceShape(3, 4);
			}
		});

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				slice.updateSourceShape(1, 4);
			}
		});

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				slice.updateSourceShape(3);
			}
		});

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				slice.updateSourceShape();
			}
		});

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				slice.updateSourceShape(null);
			}
		});

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				slice.updateSourceShape();
			}
		});

		final SliceND slice1 = new SliceND(null);
		slice1.updateSourceShape(null);

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				slice1.updateSourceShape(3);
			}
		});
	}

	@Test
	public void testCheckShapes() {
		// [6:2:-3, 1:] in (8,4) has output shape is (2,3)
		final SliceND slice1 = new SliceND(new int[] {8, 4}, new int[] {6 , 1}, new int[] {2, 4}, new int[] {-3, 1});

		slice1.checkShapes(new int[] {8, 4}, null);

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				slice1.checkShapes(new int[] {7}, null);
			}
		});

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				slice1.checkShapes(new int[] {7, 2}, null);
			}
		});

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				slice1.checkShapes(new int[] {6, 4}, null);
			}
		});

		slice1.checkShapes(new int[] {6, 4}, new int[] {12, ILazyWriteableDataset.UNLIMITED});

		slice1.checkShapes(new int[] {6, 4}, new int[] {ILazyWriteableDataset.UNLIMITED, 4});

		// [6:2:-3, 2:] in (8,4) [max (12,6)] has output shape (2,3)
		final SliceND slice2 = new SliceND(new int[] {8, 4}, new int[] {12, 6},
				new int[] {6 , 1}, new int[] {2, 4}, new int[] {-3, 1});

		slice2.checkShapes(new int[] {10, 4}, null);

		slice2.checkShapes(new int[] {8, 4}, null);

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				slice2.checkShapes(new int[] {6, 4}, null);
			}
		});

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				slice2.checkShapes(new int[] {5, 5}, null);
			}
		});

		slice2.checkShapes(new int[] {7, 5}, new int[] {8, 4});
		slice2.checkShapes(new int[] {5, 5}, new int[] {8, 4});
		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				// b >= m
				slice2.checkShapes(new int[] {5, 5}, new int[] {5, 4});
			}
		});

		slice2.checkShapes(new int[] {7, 3}, new int[] {8, 4});
		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				slice2.checkShapes(new int[] {7, 3}, new int[] {8, 3});
			}
		});

		slice2.checkShapes(new int[] {5, 5}, new int[] {ILazyWriteableDataset.UNLIMITED, 6});

		slice2.checkShapes(new int[] {6, 5}, new int[] {ILazyWriteableDataset.UNLIMITED, 6});

		slice2.checkShapes(new int[] {5, 5}, new int[] {12, ILazyWriteableDataset.UNLIMITED});

		slice2.checkShapes(new int[] {5, 3}, new int[] {12, ILazyWriteableDataset.UNLIMITED});

		final SliceND slice3 = new SliceND(null);

		slice3.checkShapes(null, null);

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				slice3.checkShapes(new int[] {5, 5}, null);
			}
		});
	}

	@Test
	public void testSetStartStop() {
		int length = 12;
		int step = 1;
		int last = length - 1;
		int stop = 5;
		SliceND sl;

		sl = new SliceND(new int[] {length});
		assertEquals(0, sl.getStart()[0]);
		assertEquals(length, sl.getShape()[0]);

		sl.setSlice(0, 1, null, step);
		assertEquals(1, sl.getStart()[0]);
		assertEquals(last, sl.getShape()[0]);

		sl.setSlice(0, -1, null, step);
		assertEquals(last, sl.getStart()[0]);
		assertEquals(1, sl.getShape()[0]);

		sl.setSlice(0, -length-1, null, step);
		assertEquals(0, sl.getStart()[0]);
		assertEquals(length, sl.getShape()[0]);

		sl.setSlice(0, last, null, step);
		assertEquals(last, sl.getStart()[0]);
		assertEquals(1, sl.getShape()[0]);


		sl.setSlice(0, last + 2, null, step);
		assertEquals(length, sl.getStart()[0]);
		assertEquals(0, sl.getShape()[0]);

		sl.setSlice(0, 1, null, -step);
		assertEquals(1, sl.getStart()[0]);
		assertEquals(2, sl.getShape()[0]);

		sl.setSlice(0, -1, null, -step);
		assertEquals(last, sl.getStart()[0]);
		assertEquals(length, sl.getShape()[0]);

		sl.setSlice(0, -length-2, null, -step);
		assertEquals(-1, sl.getStart()[0]);
		assertEquals(0, sl.getShape()[0]);

		sl.setSlice(0, last, null, -step);
		assertEquals(last, sl.getStart()[0]);
		assertEquals(length, sl.getShape()[0]);

		sl.setSlice(0, last + 2, null, -step);
		assertEquals(last, sl.getStart()[0]);
		assertEquals(length, sl.getShape()[0]);

		// with a stop defined
		sl.setSlice(0, 1, stop, step);
		assertEquals(1, sl.getStart()[0]);
		assertEquals(stop - 1, sl.getShape()[0]);

		sl.setSlice(0, -1, stop, step);
		assertEquals(last, sl.getStart()[0]);
		assertEquals(0, sl.getShape()[0]);

		sl.setSlice(0, -length-1, stop, step);
		assertEquals(0, sl.getStart()[0]);
		assertEquals(stop, sl.getShape()[0]);

		sl.setSlice(0, last, stop, step);
		assertEquals(last, sl.getStart()[0]);
		assertEquals(0, sl.getShape()[0]);

		sl.setSlice(0, last + 2, stop, step);
		assertEquals(length, sl.getStart()[0]);
		assertEquals(0, sl.getShape()[0]);

		sl.setSlice(0, last + 2, stop - 2, step);
		assertEquals(length, sl.getStart()[0]);
		assertEquals(0, sl.getShape()[0]);

		sl.setSlice(0, null, null, step);
		assertEquals(length, sl.getStop()[0]);
		assertEquals(0, sl.getStart()[0]);
		assertEquals(length, sl.getShape()[0]);

		sl.setSlice(0, null, -length-1, step);
		assertEquals(0, sl.getStop()[0]);
		assertEquals(0, sl.getStart()[0]);
		assertEquals(0, sl.getShape()[0]);

		sl.setSlice(0, null, length+1, step);
		assertEquals(length, sl.getStop()[0]);
		assertEquals(length, sl.getShape()[0]);

		sl.setSlice(0, 1, stop, -step);
		assertEquals(1, sl.getStart()[0]);
		assertEquals(0, sl.getShape()[0]);

		int expected = last - stop;
		sl.setSlice(0, -1, stop, -step);
		assertEquals(last, sl.getStart()[0]);
		assertEquals(expected, sl.getShape()[0]);

		sl.setSlice(0, -length-1, stop, -step);
		assertEquals(-1, sl.getStart()[0]);
		assertEquals(0, sl.getShape()[0]);

		sl.setSlice(0, last, stop, -step);
		assertEquals(last, sl.getStart()[0]);
		assertEquals(expected, sl.getShape()[0]);

		sl.setSlice(0, last+1, stop, -step);
		assertEquals(last, sl.getStart()[0]);
		assertEquals(expected, sl.getShape()[0]);

		sl.setSlice(0, null, null, -step);
		assertEquals(-1, sl.getStop()[0]);
		assertEquals(length, sl.getShape()[0]);

		sl.setSlice(0, null, -length-1, -step);
		assertEquals(-1, sl.getStop()[0]);
		assertEquals(length, sl.getShape()[0]);

		sl.setSlice(0, null, length+1, -step);
		assertEquals(last, sl.getStop()[0]);
		assertEquals(0, sl.getShape()[0]);

		sl.setSlice(0, stop, length+1, -step);
		assertEquals(stop, sl.getStop()[0]);
		assertEquals(0, sl.getShape()[0]);

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				new SliceND(null).setSlice(0, null, null, -2);
			}
		});
	}

	@Test
	public void testCreateSlice() {
		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				SliceND.createSlice(null, null, null, null, null);
			}
		});

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				SliceND.createSlice(new int[0], new int[1], null, null, null);
			}
		});

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				SliceND.createSlice(new int[1], null, new int[2], null, null);
			}
		});

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				SliceND.createSlice(new int[1], null, null, new int[2], null);
			}
		});

		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				SliceND.createSlice(new int[1], null, null, null, new int[2]);
			}
		});

		SliceND s = SliceND.createSlice(new int[0], null, null, null, null);
		assertEquals(0, s.getShape().length);

		LazyDataset lazy = LazyDataset.createLazyDataset(DatasetFactory.createRange(12));
		s = SliceND.createSlice(lazy, new int[] {2}, new int[] {8});
		assertArrayEquals(new int[] {6}, s.getShape());

		lazy = new LazyDynamicDataset(lazy.getLoader(), lazy.getName(), lazy.getElementsPerItem(), DoubleDataset.class, lazy.getShape(), new int[] {20});
		s = SliceND.createSlice(lazy, new int[] {2}, new int[] {8});
		assertArrayEquals(new int[] {6}, s.getShape());
	}
}
