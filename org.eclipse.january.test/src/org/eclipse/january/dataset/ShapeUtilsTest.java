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
}
