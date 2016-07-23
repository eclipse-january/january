/*-
 * Copyright 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import org.eclipse.january.dataset.DoubleDataset;
import org.eclipse.january.dataset.Outliers;
import org.eclipse.january.dataset.Random;
import org.junit.Assert;
import org.junit.Test;

public class OutlierStatsTest {
	
	// The expected value of the function, given the seed 3145 
	double expected3145 = 0.9976411809392469;
	
	@Test
	public void testSn() {
		Random.seed(3145);
		DoubleDataset randn = Random.randn(1, 1, new int[]{5000});
		
		long t = System.currentTimeMillis();
		double snNaive = Outliers.snNaive(randn);
		System.out.println(System.currentTimeMillis()-t);
		Assert.assertEquals(expected3145, snNaive, 1E-10);
		
	}

	@Test
	public void testSnFast() {
		Random.seed(3145);
		DoubleDataset randn = Random.randn(1, 1, new int[]{5000});
		
		long t = System.currentTimeMillis();
		double snFast = Outliers.snFast(randn);
		System.out.println(System.currentTimeMillis()-t);
		Assert.assertEquals(expected3145, snFast, 1E-10);
		
	}

}
