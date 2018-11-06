package org.eclipse.january.dataset;

import static org.junit.Assert.*;

import org.junit.Test;

public class BroadcastSelfIteratorTest {
	@Test
	public void testSingle() {
		Dataset a = DatasetFactory.zeros(5, 3);
		Dataset b = DatasetFactory.createRange(1, 31., 2.);

		Dataset bv = b.getSliceView(new Slice(3, 8));
		Slice s;

		// passes already
		s = new Slice(1, 2);
		BroadcastSelfIterator bit;

		bit = BroadcastSelfIterator.createIterator(a.getSliceView(null, s), bv.reshape(5, 1));
		while (bit.hasNext()) {
			assertEquals(bv.getElementDoubleAbs(bit.bIndex), bit.bDouble, 1e-6);
		}

		// triggers #321
		s = new Slice(0, 1);
		bit = BroadcastSelfIterator.createIterator(a.getSliceView(null, s), bv.reshape(5, 1));
		while (bit.hasNext()) {
			assertEquals(bv.getElementDoubleAbs(bit.bIndex), bit.bDouble, 1e-6);
		}

		s = new Slice(2, 3);
		bit = BroadcastSelfIterator.createIterator(a.getSliceView(null, s), bv.reshape(5, 1));
		while (bit.hasNext()) {
			assertEquals(bv.getElementDoubleAbs(bit.bIndex), bit.bDouble, 1e-6);
		}
	}

	@Test
	public void testScalar() {
		ComplexDoubleDataset a = (ComplexDoubleDataset) DatasetFactory.createFromObject(ComplexDoubleDataset.class, new double[] {-1, 2}).reshape();
		Dataset b = DatasetFactory.createFromObject(-1);

		Dataset ra = a.getRealView();
		
		BroadcastSelfIterator bit;
		bit = BroadcastSelfIterator.createIterator(ra, b);
		while (bit.hasNext()) {
			assertEquals(a.getElementDoubleAbs(bit.aIndex), bit.bDouble, 1e-9);
		}

		Dataset ia = a.getImaginaryView();
		b = DatasetFactory.createFromObject(2);
		bit = BroadcastSelfIterator.createIterator(ia, b);
		while (bit.hasNext()) {
			assertEquals(a.getElementDoubleAbs(bit.aIndex), bit.bDouble, 1e-9);
		}
	}
}
