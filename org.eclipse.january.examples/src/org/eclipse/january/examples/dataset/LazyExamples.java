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

import java.util.Arrays;

import org.eclipse.january.DatasetException;
import org.eclipse.january.dataset.IDataset;
import org.eclipse.january.dataset.ILazyDataset;
import org.eclipse.january.dataset.LazyMaths;
import org.eclipse.january.dataset.Random;
import org.eclipse.january.dataset.Slice;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

/**
 * Lazy datasets allow data to be declared and used without loading it
 * directly into memory. 
 * 
 * This is useful when dealing with UIs and algorithms which can act on 
 * data a slice at a time.
 * 
 * Lazy data is usually:
 * 1. An HDF5 file which offers slicing without loading all data
 * 2. A directory of images in which each image is not loaded to memory at the same time.
 * 3. A lazy random which is used for testing.
 * 
 * @author Matthew Gerring
 *
 */
public class LazyExamples {
	
	@Rule
	public TestRule watcher = Utils.testWatcherCreator();
	
	@Before
	public void before() {
		Utils.suppressSLF4JError();
	}

	/**
	 * Lazy datasets can exist which are too big to fit in memory
	 * @throws Exception 
	 */
	@Test
	public void lazyLarge1() throws DatasetException {
		
		// At the time of writing this code, this data will not fit in memory
		final ILazyDataset lz = Random.lazyRand(10000, 2048, 2048);

		// However you may slice an image from it
		final IDataset image = lz.getSlice(new Slice(4000,4001), null, null).squeeze();
		System.out.println("The image has shape "+Arrays.toString(image.getShape()));
		
		// Or a block of data
		final IDataset block = lz.getSlice(new Slice(3000,3010), null, null).squeeze();
		System.out.println("The block has shape "+Arrays.toString(block.getShape()));
		
	}
	
	/**
	 * You may slice from lazy to lazy too.
	 * @throws Exception 
	 */
	@Test
	public void lazyLarge2() throws DatasetException {
		
		// At the time of writing this code, this data will not fit in memory
		final ILazyDataset lz = Random.lazyRand(10000, 2048, 2048);

		// However you may slice an image from it
		final ILazyDataset slice = lz.getSliceView(new Slice(0,5000), null, null);
		System.out.println("The lazy slice is "+slice);
		
		// You may slice an image from  slice instead
		final IDataset image = slice.getSlice(new Slice(4000,4001), null, null).squeeze();
		System.out.println("The image has shape "+Arrays.toString(image.getShape()));
	}

	
	/**
	 * Lazy maths can be done on lazy datasets (also available from the GUI)
	 * @throws Exception 
	 */
	@Test
	public void lazyMaths() throws DatasetException {

		final ILazyDataset lz = Random.lazyRand(100, 2048, 2048);

		// No protection for overflow at the moment in the sum...
		final IDataset sum = LazyMaths.sum(lz, 0).squeeze();
		System.out.println("The sum has shape "+Arrays.toString(sum.getShape()));
	}
}
