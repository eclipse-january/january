/*
 * Copyright (c) 2012 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.examples.dataset.impl;

import static org.junit.Assert.assertEquals;

import org.eclipse.dawnsci.analysis.api.dataset.Slice;
import org.eclipse.dawnsci.analysis.dataset.impl.BooleanDataset;
import org.eclipse.dawnsci.analysis.dataset.impl.Dataset;
import org.eclipse.dawnsci.analysis.dataset.impl.IndexIterator;
import org.junit.Test;

public class BooleanDatasetTest {

	@Test
	public void testConstructor() {
		boolean[] da = { false, true, false, true, false, true, false, true, false, true, false, true};
		BooleanDataset a = new BooleanDataset(da);

		IndexIterator it = a.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i % 2 != 0, a.getElementBooleanAbs(it.index));
		}

		BooleanDataset b = new BooleanDataset(da, 3, 4);

		it = b.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i % 2 != 0, b.getElementBooleanAbs(it.index));
		}

		// test hashes
		a.hashCode();
		b.hashCode();
	}

	@Test
	public void testGetter() {
		boolean[] da = { false, true, false, true, false, true, false, true, false, true, false, true};
		BooleanDataset a = new BooleanDataset(da);
		int l = da.length;
		for (int i = 0; i < l; i++) {
			assertEquals(da[i], a.getBoolean(i));
		}
		
		for (int i = 0; i < l; i++) {
			boolean r = da[l - 1 - i];
			assertEquals(r, a.getBoolean(-(i + 1)));
		}

		Dataset sv = a.getSliceView(new Slice(2,7));
		Dataset sc = a.getSlice(new Slice(2,7));
		l = sc.getSize();
		for (int i = 0; i < l; i++) {
			boolean r = sc.getBoolean(-(i + 1));
			assertEquals(r, sv.getBoolean(-(i + 1)));
		}
	}
}
