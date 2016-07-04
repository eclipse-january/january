/*-
 * Copyright (c) 2012 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.dataset;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.dawnsci.analysis.api.dataset.Slice;
import org.eclipse.dawnsci.analysis.asserts.TestUtils;
import org.eclipse.dawnsci.analysis.dataset.impl.Dataset;
import org.eclipse.dawnsci.analysis.dataset.impl.DatasetFactory;
import org.eclipse.dawnsci.analysis.dataset.impl.DoubleDataset;
import org.eclipse.dawnsci.analysis.dataset.impl.IntegerDataset;
import org.eclipse.dawnsci.analysis.dataset.impl.IntegersIterator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntegersIteratorTest {
	Dataset a, b;

	@Before
	public void setUpClass() {
		a = DatasetFactory.createFromObject(new double[] { 0, 1, 3, 5, -7, -9 });
		b = DatasetFactory.createFromObject(new double[] { 0.01, 1.2, 2.9, 5, -7.1, -9 });
	}

	@Test
	public void testShapes() {
		IntegerDataset s = DatasetFactory.zeros(IntegerDataset.class, 2, 3, 4);
		IntegerDataset t = DatasetFactory.zeros(IntegerDataset.class, 2, 3, 4);
		IntegerDataset u = DatasetFactory.zeros(IntegerDataset.class, 2, 3, 4);
		IntegerDataset v = DatasetFactory.zeros(IntegerDataset.class, 1);

		IntegersIterator iter;
		int[] shape;

		shape = new int[] {10, 20, 30};

		iter = new IntegersIterator(shape);
		Assert.assertArrayEquals("Shape", new int[] {10, 20, 30}, iter.getShape());

		iter = new IntegersIterator(shape, s, t, u);
		Assert.assertArrayEquals("Shape", new int[] {2, 3, 4}, iter.getShape());
		
		iter = new IntegersIterator(shape, null, t, u);
		Assert.assertArrayEquals("Shape", new int[] {10, 2, 3, 4}, iter.getShape());

		iter = new IntegersIterator(shape, s, null, u);
		Assert.assertArrayEquals("Shape", new int[] {2, 3, 4, 20}, iter.getShape());

		iter = new IntegersIterator(shape, s, t, null);
		Assert.assertArrayEquals("Shape", new int[] {2, 3, 4, 30}, iter.getShape());

		iter = new IntegersIterator(shape, new Slice(1,7,2), t, u);
		Assert.assertArrayEquals("Shape", new int[] {3, 2, 3, 4}, iter.getShape());

		iter = new IntegersIterator(shape, s, new Slice(1,7,2), u);
		Assert.assertArrayEquals("Shape", new int[] {2, 3, 4, 3}, iter.getShape());

		iter = new IntegersIterator(shape, s, t, new Slice(1,7,2));
		Assert.assertArrayEquals("Shape", new int[] {2, 3, 4, 3}, iter.getShape());

		shape = new int[] {10, 20, 30, 40, 50};
		iter = new IntegersIterator(shape, s, t, u);
		Assert.assertArrayEquals("Shape", new int[] {2, 3, 4, 40, 50}, iter.getShape());

		iter = new IntegersIterator(shape, null, t, u);
		Assert.assertArrayEquals("Shape", new int[] {10, 2, 3, 4, 40, 50}, iter.getShape());

		iter = new IntegersIterator(shape, s, null, u);
		Assert.assertArrayEquals("Shape", new int[] {2, 3, 4, 20, 40, 50}, iter.getShape());

		iter = new IntegersIterator(shape, s, t, null);
		Assert.assertArrayEquals("Shape", new int[] {2, 3, 4, 30, 40, 50}, iter.getShape());

		iter = new IntegersIterator(shape, new Slice(1,7,2), t, u);
		Assert.assertArrayEquals("Shape", new int[] {3, 2, 3, 4, 40, 50}, iter.getShape());

		iter = new IntegersIterator(shape, s, new Slice(1,7,2), u);
		Assert.assertArrayEquals("Shape", new int[] {2, 3, 4, 3, 40, 50}, iter.getShape());

		iter = new IntegersIterator(shape, s, t, new Slice(1,7,2));
		Assert.assertArrayEquals("Shape", new int[] {2, 3, 4, 3, 40, 50}, iter.getShape());

		iter = new IntegersIterator(shape, s, t, new Slice(1,7,2));
		Assert.assertArrayEquals("Shape", new int[] {2, 3, 4, 3, 40, 50}, iter.getShape());

		// check broadcasting
		iter = new IntegersIterator(shape, s, t, v);
		Assert.assertArrayEquals("Shape", new int[] {2, 3, 4, 40, 50}, iter.getShape());

		iter = new IntegersIterator(shape, s, v, u);
		Assert.assertArrayEquals("Shape", new int[] {2, 3, 4, 40, 50}, iter.getShape());

		iter = new IntegersIterator(shape, v, t, u);
		Assert.assertArrayEquals("Shape", new int[] {2, 3, 4, 40, 50}, iter.getShape());

		iter = new IntegersIterator(shape, s, v, v);
		Assert.assertArrayEquals("Shape", new int[] {2, 3, 4, 40, 50}, iter.getShape());

		iter = new IntegersIterator(shape, v, t, v);
		Assert.assertArrayEquals("Shape", new int[] {2, 3, 4, 40, 50}, iter.getShape());

		iter = new IntegersIterator(shape, v, v, u);
		Assert.assertArrayEquals("Shape", new int[] {2, 3, 4, 40, 50}, iter.getShape());

		// now 1D
		shape = new int[] {10, 20, 30};
		s = DatasetFactory.createFromObject(IntegerDataset.class, new int[] {2, 5, 9}, null);
		t = DatasetFactory.createFromObject(IntegerDataset.class, new int[] {0, 5, 10, 15, 18, 19}, null);
		iter = new IntegersIterator(true, shape, s, t, new Slice(1,7,2));
		Assert.assertArrayEquals("Shape", new int[] {3, 6, 3}, iter.getShape());

	}

	@Test
	public void testEqualTo() {
		Dataset c = a.clone().reshape(2, 3);
		IntegerDataset s = DatasetFactory.createFromObject(IntegerDataset.class, new int[] {0, 1, 0}, null);
		IntegerDataset t = DatasetFactory.createFromObject(IntegerDataset.class, new int[] {0, 2, 1}, null);

		List<Double> inds = new ArrayList<Double>();
		IntegersIterator iter;
		int[] pos;

		iter = new IntegersIterator(c.getShapeRef());
		pos = iter.getPos();
		while (iter.hasNext())
			inds.add(c.getDouble(pos));
		checkDatasets((DoubleDataset) a, DatasetFactory.createFromList(DoubleDataset.class, inds));
		inds.clear();

		iter = new IntegersIterator(c.getShapeRef(), s, t);
		pos = iter.getPos();
		while (iter.hasNext())
			inds.add(c.getDouble(pos));
		checkDatasets(DatasetFactory.createFromObject(DoubleDataset.class, new double[] {0, -9, 1}),
				DatasetFactory.createFromList(DoubleDataset.class, inds));
		inds.clear();

		iter = new IntegersIterator(c.getShapeRef(), s, null);
		pos = iter.getPos();
		while (iter.hasNext())
			inds.add(c.getDouble(pos));
		checkDatasets(DatasetFactory.createFromObject(DoubleDataset.class, new double[] {0, 1, 3, 5, -7, -9, 0, 1, 3}),
				DatasetFactory.createFromList(DoubleDataset.class, inds));
		inds.clear();

		iter = new IntegersIterator(c.getShapeRef(), null, t);
		pos = iter.getPos();
		while (iter.hasNext())
			inds.add(c.getDouble(pos));
		checkDatasets(DatasetFactory.createFromObject(DoubleDataset.class, new double[] {0, 3, 1, 5, -9, -7}),
				DatasetFactory.createFromList(DoubleDataset.class, inds));
		inds.clear();

		iter = new IntegersIterator(c.getShapeRef(), s, new Slice());
		pos = iter.getPos();
		while (iter.hasNext())
			inds.add(c.getDouble(pos));
		checkDatasets(DatasetFactory.createFromObject(DoubleDataset.class, new double[] {0, 1, 3, 5, -7, -9, 0, 1, 3}),
				DatasetFactory.createFromList(DoubleDataset.class, inds));
		inds.clear();

		iter = new IntegersIterator(c.getShapeRef(), new Slice(), t);
		pos = iter.getPos();
		while (iter.hasNext())
			inds.add(c.getDouble(pos));
		checkDatasets(DatasetFactory.createFromObject(DoubleDataset.class, new double[] {0, 3, 1, 5, -9, -7}),
				DatasetFactory.createFromList(DoubleDataset.class, inds));
		inds.clear();

		iter = new IntegersIterator(c.getShapeRef(), s, new Slice(1));
		pos = iter.getPos();
		while (iter.hasNext())
			inds.add(c.getDouble(pos));
		checkDatasets(DatasetFactory.createFromObject(DoubleDataset.class, new double[] {0, 5, 0}),
				DatasetFactory.createFromList(DoubleDataset.class, inds));
		inds.clear();

		iter = new IntegersIterator(c.getShapeRef(), new Slice(1), t);
		pos = iter.getPos();
		while (iter.hasNext())
			inds.add(c.getDouble(pos));
		checkDatasets(DatasetFactory.createFromObject(DoubleDataset.class, new double[] {0, 3, 1}),
				DatasetFactory.createFromList(DoubleDataset.class, inds));
		inds.clear();

		t = DatasetFactory.createFromObject(IntegerDataset.class, new int[] {0, 2}, null);
		iter = new IntegersIterator(true, c.getShapeRef(), s, t);
		pos = iter.getPos();
		while (iter.hasNext())
			inds.add(c.getDouble(pos));
		checkDatasets(DatasetFactory.createFromObject(DoubleDataset.class, new double[] {0, 3, 5, -9, 0, 3}),
				DatasetFactory.createFromList(DoubleDataset.class, inds));
		inds.clear();

		s = DatasetFactory.createFromObject(IntegerDataset.class, new int[] {0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0}, 2, 3, 2);
		t = DatasetFactory.createFromObject(IntegerDataset.class, new int[] {2, 1, 1, 0, 1, 2, 1, 0, 0, 0, 1, 0}, 2, 3, 2);

		iter = new IntegersIterator(c.getShapeRef(), s, t);
		pos = iter.getPos();
		while (iter.hasNext())
			inds.add(c.getDouble(pos));
		checkDatasets(DatasetFactory.createFromObject(DoubleDataset.class, new double[] {3, -7, 1, 0, -7, 3, -7, 5, 5, 0, 1, 0}),
				DatasetFactory.createFromList(DoubleDataset.class, inds));
		inds.clear();

		iter = new IntegersIterator(c.getShapeRef(), s, null);
		pos = iter.getPos();
		while (iter.hasNext())
			inds.add(c.getDouble(pos));
		checkDatasets(DatasetFactory.createFromObject(DoubleDataset.class, new double[] {0, 1, 3, 5, -7, -9, 0, 1, 3, 0, 1, 3, 5,
				-7, -9, 0, 1, 3, 5, -7, -9, 5, -7, -9, 5, -7, -9, 0, 1, 3, 0, 1, 3, 0, 1, 3}),
				DatasetFactory.createFromList(DoubleDataset.class, inds));
		inds.clear();

		iter = new IntegersIterator(c.getShapeRef(), null, t);
		pos = iter.getPos();
		while (iter.hasNext())
			inds.add(c.getDouble(pos));
		checkDatasets(DatasetFactory.createFromObject(DoubleDataset.class, new double[] {3, 1, 1, 0, 1, 3, 1, 0, 0, 0, 1, 0, -9,
				-7, -7, 5, -7, -9, -7, 5, 5, 5, -7, 5}),
				DatasetFactory.createFromList(DoubleDataset.class, inds));
		inds.clear();

		iter = new IntegersIterator(c.getShapeRef(), s, new Slice());
		pos = iter.getPos();
		while (iter.hasNext())
			inds.add(c.getDouble(pos));
		checkDatasets(DatasetFactory.createFromObject(DoubleDataset.class, new double[] {0, 1, 3, 5, -7, -9, 0, 1, 3, 0, 1, 3, 5,
				-7, -9, 0, 1, 3, 5, -7, -9, 5, -7, -9, 5, -7, -9, 0, 1, 3, 0, 1, 3, 0, 1, 3}),
				DatasetFactory.createFromList(DoubleDataset.class, inds));
		inds.clear();

		iter = new IntegersIterator(c.getShapeRef(), new Slice(), t);
		pos = iter.getPos();
		while (iter.hasNext())
			inds.add(c.getDouble(pos));
		checkDatasets(DatasetFactory.createFromObject(DoubleDataset.class, new double[] {3, 1, 1, 0, 1, 3, 1, 0, 0, 0, 1, 0, -9,
				-7, -7, 5, -7, -9, -7, 5, 5, 5, -7, 5}),
				DatasetFactory.createFromList(DoubleDataset.class, inds));
		inds.clear();

		iter = new IntegersIterator(c.getShapeRef(), s, new Slice(1));
		pos = iter.getPos();
		while (iter.hasNext())
			inds.add(c.getDouble(pos));
		checkDatasets(DatasetFactory.createFromObject(DoubleDataset.class, new double[] {0, 5, 0, 0, 5, 0, 5, 5, 5, 0, 0, 0}),
				DatasetFactory.createFromList(DoubleDataset.class, inds));
		inds.clear();

		iter = new IntegersIterator(c.getShapeRef(), new Slice(1), t);
		pos = iter.getPos();
		while (iter.hasNext())
			inds.add(c.getDouble(pos));
		checkDatasets(DatasetFactory.createFromObject(DoubleDataset.class, new double[] {3, 1, 1, 0, 1, 3, 1, 0, 0, 0, 1, 0}),
				DatasetFactory.createFromList(DoubleDataset.class, inds));
		inds.clear();

		iter = new IntegersIterator(c.getShapeRef(), s, new Slice(1, null, -1));
		pos = iter.getPos();
		while (iter.hasNext())
			inds.add(c.getDouble(pos));
		checkDatasets(DatasetFactory.createFromObject(DoubleDataset.class, new double[] {1, 0, -7, 5, 1, 0, 1, 0, -7, 5, 1, 0, -7,
				5, -7, 5, -7, 5, 1, 0, 1, 0, 1, 0}),
				DatasetFactory.createFromList(DoubleDataset.class, inds));
		inds.clear();

		iter = new IntegersIterator(c.getShapeRef(), new Slice(1, null, -1), t);
		pos = iter.getPos();
		while (iter.hasNext())
			inds.add(c.getDouble(pos));
		checkDatasets(DatasetFactory.createFromObject(DoubleDataset.class, new double[] {-9, -7, -7, 5, -7, -9, -7, 5, 5, 5, -7,
				5, 3, 1, 1, 0, 1, 3, 1, 0, 0, 0, 1, 0}),
				DatasetFactory.createFromList(DoubleDataset.class, inds));
		inds.clear();

		iter = new IntegersIterator(c.getShapeRef(), new Slice(null, null, -1));
		pos = iter.getPos();
		while (iter.hasNext())
			inds.add(c.getDouble(pos));
		checkDatasets(DatasetFactory.createFromObject(DoubleDataset.class, new double[] {5, -7, -9, 0, 1, 3}),
				DatasetFactory.createFromList(DoubleDataset.class, inds));
		inds.clear();

		iter = new IntegersIterator(c.getShapeRef(), null, new Slice(1, null, -1));
		pos = iter.getPos();
		while (iter.hasNext())
			inds.add(c.getDouble(pos));
		checkDatasets(DatasetFactory.createFromObject(DoubleDataset.class, new double[] {1, 0, -7, 5}),
				DatasetFactory.createFromList(DoubleDataset.class, inds));
		inds.clear();
	}

	private void checkDatasets(DoubleDataset expected, DoubleDataset calc) {
		TestUtils.assertDatasetEquals(expected, calc, 0.1, 1e-5);
	}
}
