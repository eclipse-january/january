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

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.eclipse.january.DatasetException;
import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.dataset.IDataset;
import org.eclipse.january.dataset.ILazyDataset;
import org.eclipse.january.dataset.PositionIterator;
import org.eclipse.january.dataset.Random;
import org.eclipse.january.dataset.Slice;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

/**
 * @see the full slicing unit tests in plugin    uk.ac.diamond.scisoft.analysis.test
 *                                     package   uk/ac/diamond/scisoft/analysis/dataset
 * @author Matthew Gerring
 *
 */
public class SlicingExamples {
	
	@Rule
	public TestRule watcher = Utils.testWatcherCreator();
	
	@Before
	public void before() {
		Utils.suppressSLF4JError();
	}

	/**
	 * Slice using basic 1D int array. The goal is to create a slice from index 1
	 * This should display : [2,3]
	 */
	@Test
	public void sliceFrom1DFromIndex1() {
		Dataset onedData = DatasetFactory.createFromObject(new int[] { 1, 2, 3 });
		Dataset sliceData = onedData.getSlice(new Slice(1, null, null));
		System.out.println(sliceData.toString(true));
	}

	/**
	 * Slice using basic 1D int array. The goal is to create a Slice with only the stop index
	 * This should display : [1,2]
	 */
	@Test
	public void sliceFrom1DWithStopIndex() {
		Dataset onedData = DatasetFactory.createFromObject(new int[] { 1, 2, 3 });
		Dataset sliceData = onedData.getSlice(new Slice(2));
		System.out.println(sliceData.toString(true));
	}

	/**
	 * Slice using basic 1D int array. The goal is to get the middle of the
	 * array
	 * This should display : [6, 5, 4]
	 */
	@Test
	public void sliceFrom1D() {
		Dataset onedData = DatasetFactory.createFromObject(new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 });
		// We want to get the 4th to the 6th index. Start argument is inclusive so this will be 4. Stop argument is exclusive so this will be 7.
		Dataset sliceData = onedData.getSlice(new Slice(4, 7));
		System.out.println(sliceData.toString(true));
	}

	/**
	 * Slice using basic 1D int array. The goal is to get from the middle of the array to the end-1
	 * This should display : [5, 4, 3, 2, 1]
	 */
	@Test
	public void sliceFrom1DGettingEnd() {
		Dataset onedData = DatasetFactory.createFromObject(new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 });
		// We want to get the 5th to the last-1 index. Start argument is inclusive so this will be 5. Stop argument is -1 because we want to get to the -1
		// element. If you want to get to the 2, you just have to put the end to -2.
		Dataset sliceData = onedData.getSlice(new Slice(5, -1));
		System.out.println(sliceData.toString(true));
	}
	
	/**
	 * Slice using basic 1D int array. The goal is to get from the middle of the
	 * array to the end
	 * This should display : [5, 4, 3, 2, 1, 0]
	 */
	@Test
	public void sliceFrom1DNullStop() {
		Dataset onedData = DatasetFactory.createFromObject(new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 });
		// We want to get the 5th to the last index. Start argument is inclusive so this will be 5. Stop argument will be null because
		// it's automatically set to the end
		Dataset sliceData = onedData.getSlice(new Slice(5, null));
		System.out.println(sliceData.toString(true));
	}

	/**
	 * Slice using basic 2D int array. The goal is to get the middle of the
	 * array
	 * This should display : [[6, 7],
 	 * 						 [9, 10]]
	 */
	@Test
	public void sliceFrom2D() {
		Dataset twodData = DatasetFactory
				.createFromObject(new int[][] { { 1, 2, 3, 4 }, { 4, 5, 6, 7 }, { 7, 8, 9, 10 }, { 11, 10, 11, 10 } });
		// We want to get the 4 values on the two middle lines and at the end of the line of the array, that's to say :
		//	6,7
		// 	9,10
		// to do that, we need to do a first slice for the first dimension,
		// that's to say the rows :
		Slice getterFirstD = new Slice(1, 3);
		// This means that you want to get the element from the index 1 to 2,
		// because the second one is exclusive.

		// And you need a second slice to apply to the second dimension, here
		// you want the 2nd and 3rd rows :
		Slice getterSecondD = new Slice(2, 4);
		// This means that you want to get the line at the index 2 to 3.
		Dataset sliceData = twodData.getSlice(getterFirstD, getterSecondD);
		System.out.println(sliceData.toString(true));
	}

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

	/**
	 * Slice using basic Slice object
	 * @throws Exception 
	 */
	@Test
	public void iterateImagesND() throws DatasetException {
		
		final ILazyDataset lz = Random.lazyRand(64, 64, 100, 100);		
		final PositionIterator it = new PositionIterator(new int[]{64, 64});
		
		while(it.hasNext()) {
			int[] pos = it.getPos();
			Slice[] slice = new Slice[lz.getRank()];
			for (int i = 0; i < pos.length; i++) {
				slice[i] = new Slice(pos[i], pos[i]+1);
			}
			IDataset image = lz.getSlice(slice);
			image.squeeze(); // This changes shape from 1,1,100,100 to 100,100
            assertTrue(Arrays.equals(new int[]{100, 100}, image.getShape()));
		}
	}

}
