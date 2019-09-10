/*
 * Copyright (c) 2014 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.metadata.internal;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.january.DatasetException;
import org.eclipse.january.dataset.BooleanDataset;
import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DoubleDataset;
import org.eclipse.january.dataset.IDataset;
import org.eclipse.january.dataset.ILazyDataset;
import org.eclipse.january.dataset.Random;
import org.eclipse.january.dataset.ShortDataset;
import org.eclipse.january.dataset.Slice;
import org.eclipse.january.dataset.SliceND;
import org.junit.Test;

public class SliceableMetadataTest {

	@Test
	public void testSlicingMetadata() {
		final int[] shape = new int[] {1, 2, 3, 4};
		ILazyDataset ld = Random.lazyRand(Dataset.INT32, "Metadata1", shape);

		final DoubleDataset[] dda = new DoubleDataset[] {Random.randn(shape), Random.randn(shape),};

		List<ShortDataset> sdl = new ArrayList<>();
		sdl.add((ShortDataset) Random.randn(shape).cast(Dataset.INT16));
		sdl.add((ShortDataset) Random.randn(shape).cast(Dataset.INT16));

		Map<String, BooleanDataset> bdm = new HashMap<String, BooleanDataset>();
		bdm.put("1", (BooleanDataset) Random.randn(shape).cast(Dataset.BOOL));
		bdm.put("2", (BooleanDataset) Random.randn(shape).cast(Dataset.BOOL));
		
		List<DoubleDataset[]> l2 = new ArrayList<DoubleDataset[]>();
		l2.add(new DoubleDataset[]{Random.randn(shape)});
		l2.add(new DoubleDataset[]{Random.randn(shape)});
		
		SliceableTestMetadata md = new SliceableTestMetadata(ld, dda, sdl, bdm, l2);

		ILazyDataset dataset = Random.lazyRand(Dataset.INT32, "Main", shape);
		dataset.addMetadata(md);

		try {
			SliceableTestMetadata tmd = dataset.getFirstMetadata(SliceableTestMetadata.class);
			assertEquals(md, tmd);
			assertEquals(2, tmd.getArray().length);
			assertEquals(2, tmd.getList().size());
			assertEquals(2, tmd.getMap().size());
			assertEquals(2, tmd.getListOfArrays().size());
		} catch (Exception e) {
			fail("Should not fail: " + e);
		}

		Slice[] slice = new Slice[] {null, new Slice(1), null, new Slice(null, null, 2)};
		ILazyDataset sliced = dataset.getSliceView(slice);

		assertArrayEquals(new int[] {1, 1, 3, 2}, sliced.getShape());
		try {
			SliceableTestMetadata tmd = sliced.getFirstMetadata(SliceableTestMetadata.class);
			assertEquals(2, tmd.getArray().length);
			assertEquals(2, tmd.getList().size());
			assertEquals(2, tmd.getMap().size());
			assertEquals(2, tmd.getListOfArrays().size());
			assertArrayEquals(sliced.getShape(), tmd.getLazyDataset().getShape());
			assertArrayEquals(sliced.getShape(), tmd.getArray()[0].getShapeRef());
			assertArrayEquals(sliced.getShape(), tmd.getList().get(0).getShapeRef());
			assertArrayEquals(sliced.getShape(), tmd.getMap().get("1").getShapeRef());
			assertArrayEquals(sliced.getShape(), tmd.getListOfArrays().get(0)[0].getShapeRef());
			
			//test original unchanged
			tmd = dataset.getFirstMetadata(SliceableTestMetadata.class);
			assertEquals(2, tmd.getArray().length);
			assertEquals(2, tmd.getList().size());
			assertEquals(2, tmd.getMap().size());
			assertArrayEquals(shape, tmd.getLazyDataset().getShape());
			assertArrayEquals(shape, tmd.getArray()[0].getShapeRef());
			assertArrayEquals(shape, tmd.getList().get(0).getShapeRef());
			assertArrayEquals(shape, tmd.getMap().get("1").getShapeRef());
			assertArrayEquals(shape, tmd.getListOfArrays().get(0)[0].getShapeRef());
			
			IDataset slice2 = sliced.getSlice();
			tmd = slice2.getFirstMetadata(SliceableTestMetadata.class);
			assertEquals(2, tmd.getArray().length);
			assertEquals(2, tmd.getList().size());
			assertEquals(2, tmd.getMap().size());
			assertArrayEquals(sliced.getShape(), tmd.getLazyDataset().getShape());
			assertArrayEquals(sliced.getShape(), tmd.getArray()[0].getShapeRef());
			assertArrayEquals(sliced.getShape(), tmd.getList().get(0).getShapeRef());
			assertArrayEquals(sliced.getShape(), tmd.getMap().get("1").getShapeRef());
			assertArrayEquals(sliced.getShape(), tmd.getListOfArrays().get(0)[0].getShapeRef());
			
			//test original unchanged
			tmd = dataset.getFirstMetadata(SliceableTestMetadata.class);
			assertEquals(2, tmd.getArray().length);
			assertEquals(2, tmd.getList().size());
			assertEquals(2, tmd.getMap().size());
			assertArrayEquals(shape, tmd.getLazyDataset().getShape());
			assertArrayEquals(shape, tmd.getArray()[0].getShapeRef());
			assertArrayEquals(shape, tmd.getList().get(0).getShapeRef());
			assertArrayEquals(shape, tmd.getMap().get("1").getShapeRef());
			assertArrayEquals(shape, tmd.getListOfArrays().get(0)[0].getShapeRef());
		} catch (Exception e) {
			fail("Should not fail: " + e);
		}

		SubMetadata smd = new SubMetadata(ld, dda, sdl, bdm, l2);
		dataset.setMetadata(smd);
		sliced = dataset.getSliceView(slice);

		try {
			SubMetadata tmd = dataset.getFirstMetadata(SubMetadata.class);
			assertEquals(smd, tmd);
			assertEquals(2, tmd.getArray().length);
			assertEquals(2, tmd.getList().size());
			assertEquals(2, tmd.getMap().size());
			assertEquals(2, tmd.getListOfArrays().size());
		} catch (Exception e) {
			fail("Should not fail: " + e);
		}

		assertArrayEquals(new int[] {1, 1, 3, 2}, sliced.getShape());
		try {
			SubMetadata tmd = sliced.getFirstMetadata(SubMetadata.class);
			assertEquals(2, tmd.getArray().length);
			assertEquals(2, tmd.getList().size());
			assertEquals(2, tmd.getMap().size());
			assertArrayEquals(sliced.getShape(), tmd.getLazyDataset().getShape());
			assertArrayEquals(sliced.getShape(), tmd.getArray()[0].getShapeRef());
			assertArrayEquals(sliced.getShape(), tmd.getList().get(0).getShapeRef());
			assertArrayEquals(sliced.getShape(), tmd.getMap().get("1").getShapeRef());
			assertArrayEquals(sliced.getShape(), tmd.getLazyDataset2().getShape());
			assertArrayEquals(sliced.getShape(), tmd.getListOfArrays().get(0)[0].getShapeRef());
		} catch (Exception e) {
			fail("Should not fail: " + e);
		}
	}
	
	@Test
	public void testStepBroadcasted() {
		
		final int[] bshape = new int[] {1, 5, 1};
		final int[] shape = new int[] {4, 5, 6};
		ILazyDataset ld = Random.lazyRand(Dataset.INT32, "Metadata1", bshape);
		SliceableTestMetadata md = new SliceableTestMetadata(ld, null, null, null, null);

		ILazyDataset dataset = Random.lazyRand(Dataset.INT32, "Main", shape);
		dataset.addMetadata(md);
		
		try {
			SliceND snd = new SliceND(dataset.getShape());
			snd.setSlice(1, 0, 5, 2);
			ILazyDataset slicedStep = dataset.getSliceView(snd);
			SliceableTestMetadata tmd = slicedStep.getFirstMetadata(SliceableTestMetadata.class);
			ILazyDataset lazyDataset = tmd.getLazyDataset();
			assertEquals(slicedStep.getShape()[1], lazyDataset.getShape()[1]);
			
		} catch (Exception e) {
			fail("Should not fail: " + e);
		}
	}

	@Test
	public void testSlicingSqueezedMetadata() throws DatasetException {
		final int[] shape = new int[] {1, 1, 128};
		ILazyDataset ld = Random.lazyRand(Dataset.INT32, "Metadata1", shape);
		SliceableTestMetadata md = new SliceableTestMetadata(ld, null, null, null, null);

		ILazyDataset dataset = Random.lazyRand(Dataset.INT32, "Main", shape);
		dataset.addMetadata(md);

		Slice[] slice = new Slice[] {null, null, new Slice(64)};
		ILazyDataset sliced = dataset.getSliceView(slice);

		assertArrayEquals(new int[] {1, 1, 64}, sliced.getShape());

		dataset.squeezeEnds();
		assertEquals(1, dataset.getRank());
		assertArrayEquals(new int[] {128}, dataset.getShape());
		try {
			SliceableTestMetadata tmd = dataset.getFirstMetadata(SliceableTestMetadata.class);
			assertEquals(1, tmd.getLazyDataset().getRank());
			assertArrayEquals(new int[] {128}, tmd.getLazyDataset().getShape());
		} catch (Exception e) {
			fail("Should not fail: " + e);
		}

		slice = new Slice[] {new Slice(64)};
		sliced = dataset.getSliceView(slice);
		assertEquals(1, sliced.getRank());
		assertArrayEquals(new int[] {64}, sliced.getShape());
		try {
			SliceableTestMetadata tmd = sliced.getFirstMetadata(SliceableTestMetadata.class);
			assertEquals(1, tmd.getLazyDataset().getRank());
			assertArrayEquals(new int[] {64}, tmd.getLazyDataset().getShape());
		} catch (Exception e) {
			fail("Should not fail: " + e);
		}

		slice = new Slice[] {new Slice(64)};
		sliced = dataset.getSlice(slice);
		assertEquals(1, sliced.getRank());
		assertArrayEquals(new int[] {64}, sliced.getShape());
		try {
			SliceableTestMetadata tmd = sliced.getFirstMetadata(SliceableTestMetadata.class);
			assertEquals(1, tmd.getLazyDataset().getRank());
			assertArrayEquals(new int[] {64}, tmd.getLazyDataset().getShape());
		} catch (Exception e) {
			fail("Should not fail: " + e);
		}
	}

	@Test
	public void testSlicingSameRankDifferentShapeMetadata() {
		final int[] result1 = new int[] {1, 1, 1, 1};
		final int[] result2 = new int[] {1, 1, 3, 1};
		
		final int[] shape = new int[] {1, 2, 3, 4};
		ILazyDataset ld = Random.lazyRand(Dataset.INT32, "Metadata1", shape);

		final int [] partial1 = new int[] {1, 1, 1, 4};
		final DoubleDataset[] dda = new DoubleDataset[] {Random.randn(partial1), Random.randn(partial1),};

		final int [] partial2 = new int[] {1, 1, 3, 1};
		List<ShortDataset> sdl = new ArrayList<>();
		sdl.add((ShortDataset) Random.randn(partial2).cast(Dataset.INT16));
		sdl.add((ShortDataset) Random.randn(partial2).cast(Dataset.INT16));

		final int [] partial3 = new int[] {1, 2, 1, 1};
		Map<String, BooleanDataset> bdm = new HashMap<String, BooleanDataset>();
		bdm.put("1", (BooleanDataset) Random.randn(partial3).cast(Dataset.BOOL));
		bdm.put("2", (BooleanDataset) Random.randn(partial3).cast(Dataset.BOOL));

		List<DoubleDataset[]> l2 = new ArrayList<DoubleDataset[]>();
		l2.add(new DoubleDataset[]{Random.randn(partial1)});
		l2.add(new DoubleDataset[]{Random.randn(partial1)});
		
		SliceableTestMetadata md = new SliceableTestMetadata(ld, dda, sdl, bdm, l2);

		ILazyDataset dataset = Random.lazyRand(Dataset.INT32, "Main", shape);
		dataset.addMetadata(md);
		
		try {
			SliceableTestMetadata tmd = dataset.getFirstMetadata(SliceableTestMetadata.class);
			assertEquals(md, tmd);
			assertEquals(2, tmd.getArray().length);
			assertEquals(2, tmd.getList().size());
			assertEquals(2, tmd.getMap().size());
			assertEquals(2, tmd.getListOfArrays().size());
		} catch (Exception e) {
			fail("Should not fail: " + e);
		}

		Slice[] slice = new Slice[] {null, new Slice(1), null, new Slice(1)};
		ILazyDataset sliced = dataset.getSliceView(slice);

		assertArrayEquals(new int[] {1, 1, 3, 1}, sliced.getShape());
		try {
			SliceableTestMetadata tmd = sliced.getFirstMetadata(SliceableTestMetadata.class);
			assertEquals(2, tmd.getArray().length);
			assertEquals(2, tmd.getList().size());
			assertEquals(2, tmd.getMap().size());
			assertArrayEquals(result2, tmd.getLazyDataset().getShape());
			assertArrayEquals(result1, tmd.getArray()[0].getShapeRef());
			assertArrayEquals(result2, tmd.getList().get(0).getShapeRef());
			assertArrayEquals(result1, tmd.getMap().get("1").getShapeRef());
			assertArrayEquals(result1, tmd.getListOfArrays().get(0)[0].getShapeRef());
			
			//test original unchanged
			tmd = dataset.getFirstMetadata(SliceableTestMetadata.class);
			assertEquals(2, tmd.getArray().length);
			assertEquals(2, tmd.getList().size());
			assertEquals(2, tmd.getMap().size());
			assertArrayEquals(shape, tmd.getLazyDataset().getShape());
			assertArrayEquals(partial1, tmd.getArray()[0].getShapeRef());
			assertArrayEquals(partial2, tmd.getList().get(0).getShapeRef());
			assertArrayEquals(partial3, tmd.getMap().get("1").getShapeRef());
			assertArrayEquals(partial1, tmd.getListOfArrays().get(0)[0].getShapeRef());
			
			IDataset slice2 = sliced.getSlice();
			tmd = slice2.getFirstMetadata(SliceableTestMetadata.class);
			assertEquals(2, tmd.getArray().length);
			assertEquals(2, tmd.getList().size());
			assertEquals(2, tmd.getMap().size());
			assertArrayEquals(result2, tmd.getLazyDataset().getShape());
			assertArrayEquals(result1, tmd.getArray()[0].getShapeRef());
			assertArrayEquals(result2, tmd.getList().get(0).getShapeRef());
			assertArrayEquals(result1, tmd.getMap().get("1").getShapeRef());
			assertArrayEquals(result1, tmd.getListOfArrays().get(0)[0].getShapeRef());
			
			//test original unchanged
			tmd = dataset.getFirstMetadata(SliceableTestMetadata.class);
			assertEquals(2, tmd.getArray().length);
			assertEquals(2, tmd.getList().size());
			assertEquals(2, tmd.getMap().size());
			assertArrayEquals(shape, tmd.getLazyDataset().getShape());
			assertArrayEquals(partial1, tmd.getArray()[0].getShapeRef());
			assertArrayEquals(partial2, tmd.getList().get(0).getShapeRef());
			assertArrayEquals(partial3, tmd.getMap().get("1").getShapeRef());
			assertArrayEquals(partial1, tmd.getListOfArrays().get(0)[0].getShapeRef());
			
		} catch (Exception e) {
			fail("Should not fail: " + e);
		}
	}

	@Test
	public void testSlicingSameRankDifferentShapeMetadataFail() {
		
		final int[] result1 = new int[] {1, 1, 1, 2};
		final int[] result2 = new int[] {1, 1, 3, 2};
		
		final int[] shape = new int[] {1, 2, 3, 4};
		ILazyDataset ld = Random.lazyRand(Dataset.INT32, "Metadata1", shape);

		final int [] partial1 = new int[] {1, 1, 1, 4};
		final DoubleDataset[] dda = new DoubleDataset[] {Random.randn(partial1), Random.randn(partial1),};

		final int [] partial2 = new int[] {1, 1, 3, 4};
		List<ShortDataset> sdl = new ArrayList<>();
		sdl.add((ShortDataset) Random.randn(partial2).cast(Dataset.INT16));
		sdl.add((ShortDataset) Random.randn(partial2).cast(Dataset.INT16));

		final int [] partial3 = new int[] {1, 1, 1, 3};
		Map<String, BooleanDataset> bdm = new HashMap<String, BooleanDataset>();
		bdm.put("1", (BooleanDataset) Random.randn(partial3).cast(Dataset.BOOL));
		bdm.put("2", (BooleanDataset) Random.randn(partial3).cast(Dataset.BOOL));
		
		List<DoubleDataset[]> l2 = new ArrayList<DoubleDataset[]>();
		l2.add(new DoubleDataset[]{Random.randn(shape)});
		l2.add(new DoubleDataset[]{Random.randn(shape)});

		SliceableTestMetadata md = new SliceableTestMetadata(ld, dda, sdl, bdm, l2);

		ILazyDataset dataset = Random.lazyRand(Dataset.INT32, "Main", shape);
		dataset.addMetadata(md);
		
		try {
			SliceableTestMetadata tmd = dataset.getFirstMetadata(SliceableTestMetadata.class);
			assertEquals(md, tmd);
			assertEquals(2, tmd.getArray().length);
			assertEquals(2, tmd.getList().size());
			assertEquals(2, tmd.getMap().size());
		} catch (Exception e) {
			fail("Should not fail: " + e);
		}

		Slice[] slice = new Slice[] {null, new Slice(1), null, new Slice(0,2)};
		ILazyDataset sliced;
		try {
			sliced = dataset.getSliceView(slice);
			fail("Should not get here");
		} catch (Exception e) {
		}

		final int [] partial4 = new int[] {1, 2, 1, 1};
		final int[] result3 = new int[] {1, 1, 1, 1};
		bdm.put("1", (BooleanDataset) Random.randn(partial4).cast(Dataset.BOOL));
		bdm.put("2", (BooleanDataset) Random.randn(partial4).cast(Dataset.BOOL));
		sliced = dataset.getSliceView(slice);
		assertArrayEquals(new int[] {1, 1, 3, 2}, sliced.getShape());
		try {
			SliceableTestMetadata tmd = sliced.getFirstMetadata(SliceableTestMetadata.class);
			assertEquals(2, tmd.getArray().length);
			assertEquals(2, tmd.getList().size());
			assertEquals(2, tmd.getMap().size());
			assertArrayEquals(new int[] {1, 1, 3, 2}, tmd.getLazyDataset().getShape());
			assertArrayEquals(result1, tmd.getArray()[0].getShapeRef());
			assertArrayEquals(result2, tmd.getList().get(0).getShapeRef());
			assertArrayEquals(result3, tmd.getMap().get("1").getShapeRef());
			assertArrayEquals(result3, tmd.getMap().get("2").getShapeRef());
		} catch (Exception e) {
			fail("Should not fail: " + e);
		}
	}

	@Test
	public void testSlicingSameRankDifferentShapeSqueezeMetadata() {
		
		final int[] shape = new int[] {1, 2, 3, 4};
		ILazyDataset ld = Random.lazyRand(Dataset.INT32, "Metadata1", shape);

		final int [] partial1 = new int[] {1, 1, 1, 4};
		final DoubleDataset[] dda = new DoubleDataset[] {Random.randn(partial1), Random.randn(partial1),};

		final int [] partial2 = new int[] {1, 1, 3, 1};
		List<ShortDataset> sdl = new ArrayList<>();
		sdl.add((ShortDataset) Random.randn(partial2).cast(Dataset.INT16));
		sdl.add((ShortDataset) Random.randn(partial2).cast(Dataset.INT16));

		final int [] partial3 = new int[] {1, 2, 1, 1};
		Map<String, BooleanDataset> bdm = new HashMap<String, BooleanDataset>();
		bdm.put("1", (BooleanDataset) Random.randn(partial3).cast(Dataset.BOOL));
		bdm.put("2", (BooleanDataset) Random.randn(partial3).cast(Dataset.BOOL));

		List<DoubleDataset[]> l2 = new ArrayList<DoubleDataset[]>();
		l2.add(new DoubleDataset[]{Random.randn(partial1)});
		l2.add(new DoubleDataset[]{Random.randn(partial1)});
		
		SliceableTestMetadata md = new SliceableTestMetadata(ld, dda, sdl, bdm, l2);

		ILazyDataset dataset = Random.lazyRand(Dataset.INT32, "Main", shape);
		dataset.addMetadata(md);
		
		try {
			SliceableTestMetadata tmd = dataset.getFirstMetadata(SliceableTestMetadata.class);
			assertEquals(md, tmd);
			assertEquals(2, tmd.getArray().length);
			assertEquals(2, tmd.getList().size());
			assertEquals(2, tmd.getMap().size());
			assertEquals(2, tmd.getListOfArrays().size());
		} catch (Exception e) {
			fail("Should not fail: " + e);
		}

		Slice[] slice = new Slice[] {new Slice(1), new Slice(1), null, null};
		ILazyDataset sliced = dataset.getSliceView(slice);
		
		sliced.squeezeEnds();
		int rank = sliced.getRank();
		assertArrayEquals(new int[] {3, 4}, sliced.getShape());
		try {
			SliceableTestMetadata tmd = sliced.getFirstMetadata(SliceableTestMetadata.class);
			assertEquals(2, tmd.getArray().length);
			assertEquals(2, tmd.getList().size());
			assertEquals(2, tmd.getMap().size());
			assertEquals(rank, tmd.getLazyDataset().getRank());
			assertEquals(rank, tmd.getArray()[0].getRank());
			assertEquals(rank, tmd.getList().get(0).getRank());
			assertEquals(rank, tmd.getMap().get("1").getRank());
			assertEquals(rank, tmd.getListOfArrays().get(0)[0].getRank());
			
		} catch (Exception e) {
			fail("Should not fail: " + e);
		}

		dataset = Random.randn(shape).cast(Dataset.INT32);
		md = new SliceableTestMetadata(null, dda, sdl, bdm, l2);
		dataset.addMetadata(md);
		try {
			dataset.setShape(2, 4, 3);
			fail("Should fail!");
		} catch (Exception e) {
		}

		dataset.setShape(1, 2, 3, 2, 2);
		rank = dataset.getRank();
		assertArrayEquals(new int[] {1, 2, 3, 2, 2}, dataset.getShape());
		try {
			SliceableTestMetadata tmd = dataset.getFirstMetadata(SliceableTestMetadata.class);
			assertEquals(2, tmd.getArray().length);
			assertEquals(2, tmd.getList().size());
			assertEquals(2, tmd.getMap().size());
			assertEquals(rank, tmd.getArray()[0].getRank());
			assertEquals(rank, tmd.getList().get(0).getRank());
			assertEquals(rank, tmd.getMap().get("1").getRank());
			assertEquals(rank, tmd.getListOfArrays().get(0)[0].getRank());
		} catch (Exception e) {
			fail("Should not fail: " + e);
		}

	}

}
