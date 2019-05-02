/*******************************************************************************
 * Copyright (c) 2018 Diamond Light Source Ltd. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Diamond Light Source Ltd - initial API and implementation
 *******************************************************************************/
package org.eclipse.january.dataset;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ShapeUtilsTest {

	@Test
	public void testAxesReduction() {
		int[] remain = ShapeUtils.getRemainingAxes(4, 2, -1);
		assertArrayEquals(new int[] {0, 1}, remain);

		remain = ShapeUtils.getRemainingAxes(4, 1, -2);
		assertArrayEquals(new int[] {0, 3}, remain);

		remain = ShapeUtils.reduceShape(new int[] {2, 3, 4, 5}, -1, 2);
		assertArrayEquals(new int[] {2, 3}, remain);

		remain = ShapeUtils.reduceShape(new int[] {2, 3, 4, 5}, 1, -2);
		assertArrayEquals(new int[] {2, 5}, remain);

		remain = ShapeUtils.getReducedShapeKeepRank(new int[] {2, 3, 4, 5}, 1, -2);
		assertArrayEquals(new int[] {2, 1, 1, 5}, remain);
	}

	@Test
	public void testDiffersByOnes() {
		assertTrue(ShapeUtils.differsByOnes(new int[] {}, new int[] {}));
		assertTrue(ShapeUtils.differsByOnes(new int[] {1, 1, 1}, new int[] {}));
		assertTrue(ShapeUtils.differsByOnes(new int[] {}, new int[] {1, 1, 1}));

		assertTrue(ShapeUtils.differsByOnes(new int[] {2}, new int[] {2}));
		assertTrue(ShapeUtils.differsByOnes(new int[] {1, 1, 1, 2}, new int[] {2}));
		assertTrue(ShapeUtils.differsByOnes(new int[] {1, 1, 1, 2}, new int[] {2, 1, 1, 1}));
		assertTrue(ShapeUtils.differsByOnes(new int[] {2}, new int[] {2, 1, 1, 1}));
		assertTrue(ShapeUtils.differsByOnes(new int[] {2}, new int[] {1, 1, 1, 2}));

		assertTrue(ShapeUtils.differsByOnes(new int[] {2, 3}, new int[] {2, 3}));
		assertTrue(ShapeUtils.differsByOnes(new int[] {1, 1, 1, 2, 3}, new int[] {2, 3}));
		assertTrue(ShapeUtils.differsByOnes(new int[] {1, 1, 1, 2, 3}, new int[] {2, 3, 1, 1, 1}));
		assertTrue(ShapeUtils.differsByOnes(new int[] {2, 3}, new int[] {2, 3, 1, 1, 1}));
		assertTrue(ShapeUtils.differsByOnes(new int[] {2, 3}, new int[] {1, 1, 1, 2, 3}));

		assertTrue(ShapeUtils.differsByOnes(new int[] {2, 3}, new int[] {2, 1, 1, 3}));
		assertTrue(ShapeUtils.differsByOnes(new int[] {1, 1, 1, 2, 3}, new int[] {2, 1, 1, 3}));
		assertTrue(ShapeUtils.differsByOnes(new int[] {1, 1, 1, 2, 3}, new int[] {2, 1, 1, 3, 1, 1, 1}));
		assertTrue(ShapeUtils.differsByOnes(new int[] {2, 3}, new int[] {2, 1, 1, 3, 1, 1, 1}));
		assertTrue(ShapeUtils.differsByOnes(new int[] {2, 3}, new int[] {1, 1, 1, 2, 1, 1, 3}));

		assertTrue(ShapeUtils.differsByOnes(new int[] {2, 1, 1, 3}, new int[] {2, 3}));
		assertTrue(ShapeUtils.differsByOnes(new int[] {1, 1, 1, 2, 1, 1, 3}, new int[] {2, 3}));
		assertTrue(ShapeUtils.differsByOnes(new int[] {1, 1, 1, 2, 1, 1, 3}, new int[] {2, 3, 1, 1, 1}));
		assertTrue(ShapeUtils.differsByOnes(new int[] {2, 1, 1, 3}, new int[] {2, 3, 1, 1, 1}));
		assertTrue(ShapeUtils.differsByOnes(new int[] {2, 1, 1, 3}, new int[] {1, 1, 1, 2, 3}));

		assertFalse(ShapeUtils.differsByOnes(new int[] {2}, new int[] {4}));
		assertFalse(ShapeUtils.differsByOnes(new int[] {1, 1, 1, 2}, new int[] {4}));
		assertFalse(ShapeUtils.differsByOnes(new int[] {1, 1, 1, 2}, new int[] {4, 1, 1, 1}));
		assertFalse(ShapeUtils.differsByOnes(new int[] {2}, new int[] {4, 1, 1, 1}));
		assertFalse(ShapeUtils.differsByOnes(new int[] {2}, new int[] {1, 1, 1, 4}));

		assertFalse(ShapeUtils.differsByOnes(new int[] {2, 3}, new int[] {2, 4}));
		assertFalse(ShapeUtils.differsByOnes(new int[] {1, 1, 1, 2, 3}, new int[] {2, 4}));
		assertFalse(ShapeUtils.differsByOnes(new int[] {1, 1, 1, 2, 3}, new int[] {2, 4, 1, 1, 1}));
		assertFalse(ShapeUtils.differsByOnes(new int[] {2, 3}, new int[] {2, 4, 1, 1, 1}));
		assertFalse(ShapeUtils.differsByOnes(new int[] {2, 3}, new int[] {1, 1, 1, 2, 4}));

		assertFalse(ShapeUtils.differsByOnes(new int[] {2, 3}, new int[] {2, 1, 1, 4}));
		assertFalse(ShapeUtils.differsByOnes(new int[] {1, 1, 1, 2, 3}, new int[] {2, 1, 1, 4}));
		assertFalse(ShapeUtils.differsByOnes(new int[] {1, 1, 1, 2, 3}, new int[] {2, 1, 1, 4, 1, 1, 1}));
		assertFalse(ShapeUtils.differsByOnes(new int[] {2, 3}, new int[] {2, 1, 1, 4, 1, 1, 1}));
		assertFalse(ShapeUtils.differsByOnes(new int[] {2, 3}, new int[] {1, 1, 1, 2, 1, 1, 4}));

		assertFalse(ShapeUtils.differsByOnes(new int[] {2, 1, 1, 3}, new int[] {2, 4}));
		assertFalse(ShapeUtils.differsByOnes(new int[] {1, 1, 1, 2, 1, 1, 3}, new int[] {2, 4}));
		assertFalse(ShapeUtils.differsByOnes(new int[] {1, 1, 1, 2, 1, 1, 3}, new int[] {2, 4, 1, 1, 1}));
		assertFalse(ShapeUtils.differsByOnes(new int[] {2, 1, 1, 3}, new int[] {2, 4, 1, 1, 1}));
		assertFalse(ShapeUtils.differsByOnes(new int[] {2, 1, 1, 3}, new int[] {1, 1, 1, 2, 4}));
	}

	@Test
	public void testCalcShapePadding() {
		assertNull(ShapeUtils.calcShapePadding(null, null));

		assertNull(ShapeUtils.calcShapePadding(new int[0], new int[0]));

		assertNull(ShapeUtils.calcShapePadding(new int[] {2,1,3}, new int[] {2,1,3}));

		assertArrayEquals(new int[] {-2}, ShapeUtils.calcShapePadding(new int[] {1, 1}, new int[] {}));
		assertArrayEquals(new int[] {2}, ShapeUtils.calcShapePadding(new int[] {}, new int[] {1, 1}));

		assertArrayEquals(new int[] {1,0}, ShapeUtils.calcShapePadding(new int[] {2}, new int[] {1,2}));
		assertArrayEquals(new int[] {0,1}, ShapeUtils.calcShapePadding(new int[] {2}, new int[] {2,1}));
		assertArrayEquals(new int[] {1,0,1}, ShapeUtils.calcShapePadding(new int[] {2}, new int[] {1,2,1}));
		assertArrayEquals(new int[] {-1,0}, ShapeUtils.calcShapePadding(new int[] {1,2}, new int[] {2}));
		assertArrayEquals(new int[] {-1,0,1}, ShapeUtils.calcShapePadding(new int[] {1,2}, new int[] {2,1}));
		assertArrayEquals(new int[] {0,0,1}, ShapeUtils.calcShapePadding(new int[] {1,2}, new int[] {1,2,1}));
		assertArrayEquals(new int[] {0,-1}, ShapeUtils.calcShapePadding(new int[] {2,1}, new int[] {2}));
		assertArrayEquals(new int[] {1,0,0}, ShapeUtils.calcShapePadding(new int[] {2,1}, new int[] {1,2,1}));
		assertArrayEquals(new int[] {1,0,-1}, ShapeUtils.calcShapePadding(new int[] {2,1}, new int[] {1,2}));
		assertArrayEquals(new int[] {-1,0,-1}, ShapeUtils.calcShapePadding(new int[] {1,2,1}, new int[] {2}));

		assertArrayEquals(new int[] {1,0,0}, ShapeUtils.calcShapePadding(new int[] {2,3}, new int[] {1,2,3}));
		assertArrayEquals(new int[] {0,1,0}, ShapeUtils.calcShapePadding(new int[] {2,3}, new int[] {2,1,3}));
		assertArrayEquals(new int[] {0,0,1}, ShapeUtils.calcShapePadding(new int[] {2,3}, new int[] {2,3,1}));

		assertArrayEquals(new int[] {1,0,0,0}, ShapeUtils.calcShapePadding(new int[] {2,1,3}, new int[] {1,2,1,3}));
		assertArrayEquals(new int[] {0,0,1,0}, ShapeUtils.calcShapePadding(new int[] {2,1,3}, new int[] {2,1,1,3}));
		assertArrayEquals(new int[] {0,0,0,1}, ShapeUtils.calcShapePadding(new int[] {2,1,3}, new int[] {2,1,3,1}));

		assertArrayEquals(new int[] {1,0,-1,0}, ShapeUtils.calcShapePadding(new int[] {2,1,3}, new int[] {1,2,3}));
		assertArrayEquals(new int[] {0,-1,0}, ShapeUtils.calcShapePadding(new int[] {2,1,3}, new int[] {2,3}));
		assertArrayEquals(new int[] {0,-1,0,1}, ShapeUtils.calcShapePadding(new int[] {2,1,3}, new int[] {2,3,1}));

		assertArrayEquals(new int[] {1,0,0,-1,0}, ShapeUtils.calcShapePadding(new int[] {2,1,1,3}, new int[] {1,2,1,3}));
		assertArrayEquals(new int[] {0,0,-1,0}, ShapeUtils.calcShapePadding(new int[] {2,1,1,3}, new int[] {2,1,3}));
		assertArrayEquals(new int[] {0,-2,0,1}, ShapeUtils.calcShapePadding(new int[] {2,1,1,3}, new int[] {2,3,1}));
	}

	@Test
	public void testPadding() {
		testPadding(new int[] {}, new int[] {});

		testPadding(new int[] {2}, new int[] {2});
		testPadding(new int[] {2}, new int[] {2, 1});
		testPadding(new int[] {1, 2}, new int[] {2});
		testPadding(new int[] {1, 2}, new int[] {2, 1});
		testPadding(new int[] {1, 2}, new int[] {1, 2, 1});
		testPadding(new int[] {2, 1}, new int[] {2});
		testPadding(new int[] {2, 1}, new int[] {1, 2});
		testPadding(new int[] {2, 1}, new int[] {1, 2, 1});

		testPadding(new int[] {2, 3}, new int[] {2, 3});
		testPadding(new int[] {2, 3}, new int[] {2, 1, 3});
		testPadding(new int[] {1, 2, 3}, new int[] {2, 3});
		testPadding(new int[] {1, 2, 3}, new int[] {2, 1, 3});
		testPadding(new int[] {1, 2, 3}, new int[] {1, 2, 1, 3});
		testPadding(new int[] {2, 3, 1}, new int[] {2, 3});
		testPadding(new int[] {2, 3, 1}, new int[] {1, 2, 3});
		testPadding(new int[] {2, 3, 1}, new int[] {1, 2, 1, 3});

		testPadding(new int[] {2, 3}, new int[] {2, 3});
		testPadding(new int[] {2, 3}, new int[] {2, 1, 3});
		testPadding(new int[] {1, 2, 3}, new int[] {2, 3});
		testPadding(new int[] {1, 2, 3}, new int[] {2, 1, 3});
		testPadding(new int[] {1, 2, 3}, new int[] {1, 2, 1, 3});
		testPadding(new int[] {2, 3, 1}, new int[] {2, 3});
		testPadding(new int[] {2, 3, 1}, new int[] {1, 2, 3});
		testPadding(new int[] {2, 3, 1}, new int[] {1, 2, 1, 3});
	}

	void testPadding(int[] a, int[] b) {
		int[] p = ShapeUtils.calcShapePadding(a, b);
		assertArrayEquals(b, ShapeUtils.padShape(p, b.length, a));

		p = ShapeUtils.calcShapePadding(b, a);
		assertArrayEquals(a, ShapeUtils.padShape(p, a.length, b));
	}
}
