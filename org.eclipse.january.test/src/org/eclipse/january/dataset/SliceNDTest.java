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
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class SliceNDTest {

	@Test
	public void testSliceND() {
		int[] step;
		int[] lstart;
		int[] lstop;
		SliceND slice;

		// null dataset
		slice = new SliceND(null);
		assertTrue(slice.isAll());
		assertEquals("", slice.toString());

		// zero-rank dataset
		slice = new SliceND(new int[0]);
		assertTrue(slice.isAll());
		assertEquals("", slice.toString());

		// zero-sized
		slice = new SliceND(new int[] {0});
		assertFalse(slice.isAll());
		assertEquals(":", slice.toString());

		step = new int[] {};
		lstart = new int[] {};
		lstop = new int[] {};
		slice = new SliceND(new int[] {}, null, null, step);
		assertArrayEquals(new int[] {}, slice.getShape());

		try {
			slice = new SliceND(new int[] {1}, null, null, step);
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println("As expected: " + e);
		}

		try {
			slice = new SliceND(new int[] {3}, null, null, new int[1]);
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println("As expected: " + e);
		}

		step = new int[] {2};
		try {
			slice = new SliceND(new int[] {2, 3}, null, null, step);
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println("As expected: " + e);
		}

		lstart = new int[1];
		lstop = new int[1];
		slice = new SliceND(new int[] {7}, null, null, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());

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

		step = new int[] {-2};
		try {
			slice = new SliceND(new int[] {2, 3}, null, null, step);
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println("As expected: " + e);
		}

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
	}

	@Test
	public void testExpandedSliceND() {
		int[] step;
		int[] lstart;
		int[] lstop;
		SliceND slice;

		step = new int[] {};
		lstart = new int[] {};
		lstop = new int[] {};

		try {
			slice = new SliceND(new int[] {1}, new int[] {}, null, null, null);
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println("As expected: " + e);
		}

		try {
			slice = new SliceND(new int[] {1}, new int[] {2, 2}, null, null, null);
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println("As expected: " + e);
		}

		step = new int[] {2};

		lstart = new int[1];
		lstop = new int[1];
		slice = new SliceND(new int[] {7}, new int[] {9}, null, null, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());

		lstart[0] = 0;
		slice = new SliceND(new int[] {7}, new int[] {9}, lstart, null, step);
		assertArrayEquals(new int[] {4}, slice.getShape());
		assertArrayEquals(new int[] {0}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());

		lstart[0] = 3;
		slice = new SliceND(new int[] {7}, new int[] {9}, lstart, null, step);
		assertArrayEquals(new int[] {2}, slice.getShape());
		assertArrayEquals(new int[] {3}, slice.getStart());
		assertArrayEquals(new int[] {7}, slice.getStop());

		lstart[0] = 8;
		slice = new SliceND(new int[] {7}, new int[] {9}, lstart, null, step);
		assertArrayEquals(new int[] {1}, slice.getShape());
		assertArrayEquals(new int[] {8}, slice.getStart());
		assertArrayEquals(new int[] {9}, slice.getStop());

		lstart[0] = 8;
		slice = new SliceND(new int[] {7}, new int[] {9}, lstart, new int[] {10}, step);
		assertArrayEquals(new int[] {1}, slice.getShape());
		assertArrayEquals(new int[] {8}, slice.getStart());
		assertArrayEquals(new int[] {9}, slice.getStop());

		lstart[0] = 10;
		slice = new SliceND(new int[] {7}, new int[] {9}, lstart, new int[] {10}, step);
		assertArrayEquals(new int[] {0}, slice.getShape());
		assertArrayEquals(new int[] {9}, slice.getStart());
		assertArrayEquals(new int[] {9}, slice.getStop());

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
		assertArrayEquals(new int[] {1}, slice.getShape());
		assertArrayEquals(new int[] {7}, slice.getStart());
		assertArrayEquals(new int[] {9}, slice.getStop());
		assertArrayEquals(new int[] {9}, slice.getSourceShape());

		lstart[0] = 8;
		slice = new SliceND(new int[] {7}, new int[] {9}, lstart, null, step);
		assertArrayEquals(new int[] {1}, slice.getShape());
		assertArrayEquals(new int[] {8}, slice.getStart());
		assertArrayEquals(new int[] {9}, slice.getStop());
		assertArrayEquals(new int[] {9}, slice.getSourceShape());
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

		step = new int[] {-2};
		try {
			slice = new SliceND(new int[] {2, 3}, null, null, step);
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println("As expected: " + e);
		}

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
	}

	@Test
	public void testUnlimitedSliceND() {
		int[] step;
		int[] lstart;
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
		try {
			slice = new SliceND(new int[] {7}, new int[] {-1}, lstart, null, step);
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println("As expected: " + e);
		}

		lstart[0] = 8;
		try {
			slice = new SliceND(new int[] {7}, new int[] {-1}, lstart, null, step);
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println("As expected: " + e);
		}

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


		step = new int[] {-2};
		try {
			slice = new SliceND(new int[] {2, 3}, null, null, step);
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println("As expected: " + e);
		}

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
		int[] step;
		int[] lstart;
		SliceND slice;

		step = new int[] {};
		slice = new SliceND(new int[] {}, null, null, step);
		try {
			slice.flip(0);
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println("As expected: " + e);
		}

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

		assertTrue(SliceND.isSliceWithinShape(5, 0, 5, 1));
		assertTrue(SliceND.isSliceWithinShape(5, 1, 1, 1));
		assertTrue(SliceND.isSliceWithinShape(5, 1, 5, 1));
		assertTrue(SliceND.isSliceWithinShape(5, 4, 4, 1));
		assertFalse(SliceND.isSliceWithinShape(5, 5, 5, 1));
		assertFalse(SliceND.isSliceWithinShape(5, 2, 1, 1));

		assertTrue(SliceND.isSliceWithinShape(5, 4, -1, -1));
		assertTrue(SliceND.isSliceWithinShape(5, 1, 1, -1));
		assertTrue(SliceND.isSliceWithinShape(5, 4, 0, -1));
		assertTrue(SliceND.isSliceWithinShape(5, 4, 4, -1));
		assertFalse(SliceND.isSliceWithinShape(5, 5, 5, -1));
		assertFalse(SliceND.isSliceWithinShape(5, -1, -1, -1));
		assertFalse(SliceND.isSliceWithinShape(5, 1, 2, -1));
	}

	@Test
	public void testUpdateSourceShape() {
		SliceND slice = new SliceND(new int[] {8, 4}, new int[] {6 , 1}, new int[] {2, 4}, new int[] {-3, 1});

		slice.updateSourceShape(13, 4);

		slice.updateSourceShape(8, 6);

		try {
			slice.updateSourceShape(8, 3);
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println("As expected: " + e);
		}

		try {
			slice.updateSourceShape(3, 4);
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println("As expected: " + e);
		}

		try {
			slice.updateSourceShape(1, 4);
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println("As expected: " + e);
		}

		try {
			slice.updateSourceShape(3);
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println("As expected: " + e);
		}

		try {
			slice.updateSourceShape();
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println("As expected: " + e);
		}

		try {
			slice.updateSourceShape(null);
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println("As expected: " + e);
		}

		slice = new SliceND(null);
		slice.updateSourceShape(null);

		try {
			slice.updateSourceShape();
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println("As expected: " + e);
		}

		try {
			slice.updateSourceShape(3);
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println("As expected: " + e);
		}
	}

	@Test
	public void testCheckShapes() {
		SliceND slice = new SliceND(new int[] {8, 4}, new int[] {6 , 1}, new int[] {2, 4}, new int[] {-3, 1});

		slice.checkShapes(new int[] {8, 4}, null);

		try {
			slice.checkShapes(new int[] {7}, null);
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println("As expected: " + e);
		}

		try {
			slice.checkShapes(new int[] {7, 4}, null);
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println("As expected: " + e);
		}

		try {
			slice.checkShapes(new int[] {6, 4}, null);
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println("As expected: " + e);
		}

		slice.checkShapes(new int[] {6, 4}, new int[] {12, ILazyWriteableDataset.UNLIMITED});

		slice.checkShapes(new int[] {6, 4}, new int[] {ILazyWriteableDataset.UNLIMITED, 4});

		slice = new SliceND(new int[] {8, 4}, new int[] {12, 6},
				new int[] {6 , 1}, new int[] {2, 4}, new int[] {-3, 1});

		slice.checkShapes(new int[] {10, 4}, null);

		slice.checkShapes(new int[] {8, 4}, null);

		try {
			slice.checkShapes(new int[] {7, 4}, null);
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println("As expected: " + e);
		}

		try {
			slice.checkShapes(new int[] {5, 5}, null);
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println("As expected: " + e);
		}

		slice.checkShapes(new int[] {5, 5}, new int[] {ILazyWriteableDataset.UNLIMITED, 6});

		slice.checkShapes(new int[] {5, 5}, new int[] {12, ILazyWriteableDataset.UNLIMITED});

		try {
			slice.checkShapes(new int[] {5, 2}, new int[] {12, 3});
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println("As expected: " + e);
		}

		slice = new SliceND(null);

		slice.checkShapes(null, null);

		try {
			slice.checkShapes(new int[] {5, 5}, null);
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println("As expected: " + e);
		}
	}
}
