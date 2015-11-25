/*-
 *******************************************************************************
 * Copyright (c) 2011, 2014 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Matthew Gerring - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.dawnsci.analysis.examples.dataset;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.dawnsci.analysis.api.dataset.IDataset;
import org.eclipse.dawnsci.analysis.api.dataset.ILazyDataset;
import org.eclipse.dawnsci.analysis.api.dataset.Slice;
import org.eclipse.dawnsci.analysis.api.dataset.SliceND;
import org.eclipse.dawnsci.analysis.dataset.impl.Random;
import org.eclipse.dawnsci.analysis.dataset.slicer.SliceViewIterator;
import org.eclipse.dawnsci.analysis.dataset.slicer.SliceVisitor;
import org.eclipse.dawnsci.analysis.dataset.slicer.Slicer;
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
	 */
	@Test
	public void iterateImages1() {
		
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
	 */
	@Test
	public void iterateImages2() {
		
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
	 * Slice visitor
	 */
	@Test
	public void slicerImages() throws Exception {
		
		final ILazyDataset         lz   = Random.lazyRand(64, 100, 100);
		final Map<Integer, String> dims = new HashMap<Integer, String>();
		dims.put(0, "all");
		SliceND slice = Slicer.getSliceNDFromSliceDimensions(dims, lz.getShape());
		int[] axes = Slicer.getDataDimensions(lz.getShape(), dims);
		final SliceViewIterator it = new SliceViewIterator(lz, slice, axes);
		Slicer.visit(it, new SliceVisitor() {
			
			private int count = 0;
			@Override
			public void visit(IDataset data) throws Exception {
				
                IDataset image = data.squeeze(); // We squeeze the slice to get the image.
                ++count;
                System.out.println("Image "+count+" "+image);
			}
			@Override
			public boolean isCancelled() {
				return false;
			}
		});
	}
	
}
