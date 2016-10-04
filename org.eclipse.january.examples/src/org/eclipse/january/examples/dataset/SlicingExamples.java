/*-
 * Copyright (c) 2011, 2014, 2016 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Matthew Gerring - initial API and implementation and/or initial documentation
 */

package org.eclipse.january.examples.dataset;

import org.eclipse.january.DatasetException;
import org.eclipse.january.dataset.IDataset;
import org.eclipse.january.dataset.ILazyDataset;
import org.eclipse.january.dataset.Random;
import org.eclipse.january.dataset.Slice;
import org.junit.Test;

/**
 * @see the full slicing unit tests in plugin    uk.ac.diamond.scisoft.analysis.test
 *                                     package   uk/ac/diamond/scisoft/analysis/dataset
 * @author Matthew Gerring
 *
 */
public class SlicingExamples {

	/**
	 * Slice using basic int[]
	 * @throws Exception 
	 */
	@Test
	public void iterateImages1() throws DatasetException {
		
		final ILazyDataset lz = Random.lazyRand(64, 100, 100);
		int count = 0;
		for (int i = 0; i < 64; i++) {
			IDataset image = lz.getSlice(new int[]{i, 0, 0}, new int[]{i+1,100,100}, new int[]{1,1,1});
			image.squeeze(); // This changes shape from 1,100,100 to 100,100
			++count;
            System.out.println("Array sliced "+count+" "+image);
		}
	}
	
	/**
	 * Slice using basic Slice object
	 * @throws Exception 
	 */
	@Test
	public void iterateImages2() throws DatasetException {
		
		final ILazyDataset lz = Random.lazyRand(64, 100, 100);
		int count = 0;
		for (int i = 0; i < 64; i++) {
			IDataset image = lz.getSlice(new Slice(i, i+1), null, null);
			image.squeeze(); // This changes shape from 1,100,100 to 100,100
			++count;
            System.out.println("Slice object sliced "+count+" "+image);
		}
	}


}
