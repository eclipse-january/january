/*-
 * Copyright (c) 2017 Halliburton International, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * This test should be extended to check that the class ImmutableDataset is immutable
 * in all its methods. This should include slices.
 * 
 * @author Matthew Gerring
 *
 */
public class ImmutableDatasetTest {
	
	private Dataset a;

	@Before
	public void before() {
		 a = DatasetFactory.unmodifiableDataset(DatasetFactory.createRange(FloatDataset.class, 12));
	}

	@Test
	public void getElementDoubleAbs() {

		IndexIterator it = a.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(i, a.getElementDoubleAbs(it.index), 1e-5*i);
		}
		a.hashCode();
	}

	@Test
	public void statistics() {
		assertEquals(11., a.max().doubleValue(), 1e-6);
		assertEquals(0., a.min().doubleValue(), 1e-6);
		assertEquals(5.5, ((Number) a.mean()).doubleValue(), 1e-6);
		assertEquals(3.6055512754639891, a.stdDeviation(), 1e-6);
		assertEquals(13., a.variance(), 1e-6);
	}


	@Test(expected=UnsupportedOperationException.class)
	public void set() {
		a.set(10, 0);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void buffer() {
		a.getBuffer();
	}

}
