/*
 * Copyright (c) 2015 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.examples.slice;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.eclipse.dawnsci.analysis.api.dataset.Slice;
import org.eclipse.dawnsci.analysis.api.dataset.SliceND;
import org.eclipse.dawnsci.analysis.dataset.impl.SliceNDIterator;
import org.junit.Test;

/**
 *
 */
public class SliceNDIteratorTest {
	/**
	 * 
	 */
	@Test
	public void testIterations() {
		SliceND sa = new SliceND(new int[] {4, 5, 6, 7}, new Slice(1, 5, 2), null, null, null);

		SliceNDIterator it = new SliceNDIterator(sa, 1);

		assertArrayEquals(new int[]{2, 1, 6, 7}, it.getShape());
		myAssertEquals(new SliceND(new int[] {5}), it.getOmittedSlice());

		int size = 0;
		while (it.hasNext()) {
			System.err.println(size + ": " + Arrays.toString(it.getPos()) + " or " + Arrays.toString(it.getUsedPos()));
			System.err.println("         " + it.getOutputSlice());
			if (size == (6*7 + 3*7 + 5)) {
				assertArrayEquals(new int[]{3, 0, 3, 5}, it.getPos());
				assertArrayEquals(new int[]{3, 3, 5}, it.getUsedPos());
				myAssertEquals(new SliceND(new int[] {2, 5, 6, 7}, new Slice(1, 2), null, new Slice(3, 4), new Slice(5, 6)), it.getOutputSlice());
			}
			size++;
		}
		assertEquals(2*6*7, size);
	}

	private void myAssertEquals(SliceND a, SliceND b) {
		assertArrayEquals(a.getSourceShape(), b.getSourceShape());
		assertArrayEquals(a.getShape(), b.getShape());
	}
}
