/*-
 * Copyright 2015 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.dataset;

import java.io.IOException;
import java.util.Arrays;

import org.eclipse.dawnsci.analysis.api.dataset.IDataset;
import org.eclipse.dawnsci.analysis.api.dataset.SliceND;
import org.eclipse.dawnsci.analysis.api.io.ILazyDynamicLoader;
import org.eclipse.dawnsci.analysis.api.io.ILazyLoader;
import org.eclipse.dawnsci.analysis.api.metadata.AxesMetadata;
import org.eclipse.dawnsci.analysis.api.monitor.IMonitor;
import org.eclipse.dawnsci.analysis.dataset.impl.Dataset;
import org.eclipse.dawnsci.analysis.dataset.impl.DatasetFactory;
import org.eclipse.dawnsci.analysis.dataset.impl.LazyDynamicDataset;
import org.eclipse.dawnsci.analysis.dataset.impl.SliceNDIterator;
import org.eclipse.dawnsci.analysis.dataset.metadata.AxesMetadataImpl;
import org.eclipse.dawnsci.analysis.dataset.metadata.DynamicMetadataUtils;
import org.junit.Assert;
import org.junit.Test;

public class LazyDynamicLoaderTest {
	
	@Test
	public void testLoader() throws Exception {
		
		Dataset range = DatasetFactory.createRange(10*13*20*20,Dataset.INT64);
		range.setShape(new int[]{10,13,20,20} );
		
		LazyDynamicDataset dataset = getDataset(range,2,"data");
		
		AxesMetadata ax = new AxesMetadataImpl(4);
		ax.setAxis(0, DatasetFactory.createRange(10, Dataset.INT64));
		ax.setAxis(1, DatasetFactory.createRange(13, Dataset.INT64));
		dataset.addMetadata(ax);
		
		int max = 399;
		
		for (int i = 0 ; i < (10*13); i++) {
			SliceND slice = new SliceND(dataset.getShape());
			int[] shape = dataset.getShape();
			slice.setSlice(0, shape[0]-1, shape[0], 1);
			slice.setSlice(1, shape[1]-1, shape[1], 1);
			IDataset s = dataset.getSlice(slice);
			Assert.assertEquals(max, s.max().intValue());
			max+=400;
			
			AxesMetadata axm = s.getFirstMetadata(AxesMetadata.class);
			
			Assert.assertEquals(axm.getAxis(0)[0].getSlice().getInt(0),shape[0]-1);
			Assert.assertEquals(axm.getAxis(1)[0].getSlice().getInt(0),shape[1]-1);
			
			dataset.refreshShape();
		}
		
		Assert.assertArrayEquals(new int[]{10,13,20,20},dataset.getShape());
		
	}
	
	@Test
	public void testDynamicAxesMetadata() throws Exception {
		
		int[] maxShape = new int[]{10,13,20,20};
		
		Dataset range = DatasetFactory.createRange(10*13*20*20,Dataset.INT64);
		range.setShape(maxShape);
		
		LazyDynamicDataset dataset = getDataset(range,2,"data");
		LazyDynamicDataset ax1 = getDataset(DatasetFactory.createRange(10, Dataset.INT64),0,"ax0");
		LazyDynamicDataset ax2 = getDataset(DatasetFactory.createRange(13, Dataset.INT64),0,"ax1");
		
		AxesMetadata ax = new AxesMetadataImpl(4);
		ax.setAxis(0, ax1);
		ax.setAxis(1, ax2);
		dataset.addMetadata(ax);
		
		int max = 399;
		
		SliceND slice = new SliceND(dataset.getShape(),maxShape);
		int[] axShape = new int[]{1,1,1,1};
		
		for (int i = 0 ; i < (10*13); i++) {
			int[] shape = dataset.getShape();
			@SuppressWarnings("unused")
			int[] so = DynamicMetadataUtils.refreshDynamicAxesMetadata(dataset.getMetadata(AxesMetadata.class), shape);
			slice.setSlice(0, shape[0]-1, shape[0], 1);
			slice.setSlice(1, shape[1]-1, shape[1], 1);
			IDataset s = dataset.getSlice(slice);
			Assert.assertEquals((long) max, s.max().longValue());
			max+=400;
			
			AxesMetadata axm = s.getFirstMetadata(AxesMetadata.class);

			IDataset s0 = axm.getAxis(0)[0].getSlice();
			Assert.assertArrayEquals(axShape, s0.getShape());
			Assert.assertEquals(s0.getInt(0),shape[0]-1);
			s0 = axm.getAxis(1)[0].getSlice();
			Assert.assertArrayEquals(axShape, s0.getShape());
			Assert.assertEquals(axm.getAxis(1)[0].getSlice().getInt(0),shape[1]-1);

			dataset.refreshShape();
		}
		
		Assert.assertArrayEquals(new int[]{10,13,20,20},dataset.getShape());
		
	}

	private LazyDynamicDataset getDataset(IDataset data, int detectorRank, String name) {
		
		int[] shape = determineInitialShape(data.getShape(), detectorRank);
		return new LazyDynamicDataset(name, Dataset.FLOAT64, 1, shape, data.getShape(), new LazyDynamicTestLoader(data, detectorRank));
		
	}
	
	private static int[] determineInitialShape(int[] maxShape, int detectorRank) {
		int[] shape = maxShape.clone();
		Arrays.fill(shape, 1);
		for (int i = 0; i < detectorRank; i++) {
			shape[shape.length-i-1] = maxShape[shape.length-i-1];
		}
		
		return shape;
	}
	
	private class LazyDynamicTestLoader implements ILazyLoader,ILazyDynamicLoader {

		/**
		 * 
		 */
		private static final long serialVersionUID = -2336998015537666270L;
		int[] currentShape;
		IDataset data;
		SliceNDIterator iterator;
		boolean hasNext = true;
		
		LazyDynamicTestLoader(IDataset data, int detectorRank) {
			this.data = data;
			this.currentShape = determineInitialShape(data.getShape(), detectorRank);
			int[] axes = new int[detectorRank];
			for (int i = 0; i < detectorRank; i++) axes[i] = data.getRank()-1-i;
			iterator = new SliceNDIterator(new SliceND(data.getShape()), axes);
			iterator.hasNext();
			
		}
		
		@Override
		public int[] refreshShape() {
			if (!iterator.hasNext()) hasNext = false;
			if (!hasNext) return data.getShape();
			SliceND sliceND = iterator.getCurrentSlice();
			currentShape = sliceND.getStop();
			return currentShape.clone();
		}

		@Override
		public boolean isFileReadable() {
			return true;
		}

		@Override
		public IDataset getDataset(IMonitor mon, SliceND slice) throws IOException {
			return data.getSlice(slice);
		}
		
	}
	
}
