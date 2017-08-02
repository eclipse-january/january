/*-
 * Copyright (c) 2012, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.eclipse.january.dataset.AggregateDataset;
import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.dataset.DatasetUtils;
import org.eclipse.january.dataset.ILazyDataset;
import org.eclipse.january.dataset.Slice;
import org.junit.Before;
import org.junit.Test;

public class AggregateDatasetTest {
	ILazyDataset[] datasets;

	@Before
	public void init() {
		datasets = new ILazyDataset[] {
				DatasetFactory.zeros(IntegerDataset.class, 2, 6).fill(0),
				DatasetFactory.zeros(IntegerDataset.class, 2, 6).fill(1),
				DatasetFactory.zeros(IntegerDataset.class, 2, 6).fill(2),
				DatasetFactory.zeros(IntegerDataset.class, 2, 6).fill(3),
				DatasetFactory.zeros(IntegerDataset.class, 2, 6).fill(4),
		};
	}

	@Test
	public void testConstructorFailures() {
		@SuppressWarnings("unused")
		AggregateDataset a;
		try {
			a = new AggregateDataset(true, new ILazyDataset[] {});
		} catch (Exception e) {
			try {
				a = new AggregateDataset(false, new ILazyDataset[] {});
			} catch (Exception e1) {
				try {
					a = new AggregateDataset(false, new ILazyDataset[] {
							DatasetFactory.ones(BooleanDataset.class, 2, 3),
							DatasetFactory.ones(BooleanDataset.class, 3, 4),});
				} catch (Exception e2) {
					try {
						a = new AggregateDataset(true, new ILazyDataset[] {
								DatasetFactory.ones(BooleanDataset.class, 2, 3),
								DatasetFactory.ones(BooleanDataset.class, 3, 3), });
					} catch (Exception e3) {
						System.out.println("Success!");
						return;
					}
				}
			}
		}
		fail("No exceptions thrown!");
	}

	@Test
	public void testUnextendedShape() throws Exception {
		AggregateDataset a = new AggregateDataset(false, datasets);
		assertEquals("Incorrect rank", datasets[0].getRank(), a.getRank());
		assertArrayEquals("Incorrect shape", new int[] {2*datasets.length, 6}, a.getShape());

		Dataset s;
		s = DatasetUtils.convertToDataset(a.getSlice((Slice) null, null));
		assertArrayEquals("Incorrect shape", new int[] {2*datasets.length, 6}, s.getShape());

		s = DatasetUtils.convertToDataset(a.getSlice(null, new int[] {2,2}, null));
		assertArrayEquals("Incorrect shape", new int[] {2, 2}, s.getShape());

		s = DatasetUtils.convertToDataset(a.getSlice(new int[] {1,0}, new int[] {2,2}, null));
		assertArrayEquals("Incorrect shape", new int[] {1, 2}, s.getShape());

		ILazyDataset l;
		l = a.getSliceView(null, new int[] {2,2}, null);
		s = DatasetUtils.convertToDataset(l.getSlice());
		System.out.println("View is " + l + "; slice is " + s);
		s = DatasetUtils.convertToDataset(l.getSlice());
		assertArrayEquals("Incorrect shape", new int[] {2, 2}, s.getShape());

		l = a.getSliceView(new int[] {1,0}, new int[] {2,2}, null);
		s = DatasetUtils.convertToDataset(l.getSlice());
		System.out.println("View is " + l + "; slice is " + s);
		s = DatasetUtils.convertToDataset(l.getSlice());
		assertArrayEquals("Incorrect shape", new int[] {1, 2}, s.getShape());
	}

	@Test
	public void testExtendedShape() throws Exception {
		AggregateDataset a = new AggregateDataset(true, datasets);
		assertEquals("Incorrect rank", datasets[0].getRank() + 1, a.getRank());
		assertArrayEquals("Incorrect shape", new int[] {datasets.length, 2, 6}, a.getShape());
		Dataset s;
		s = DatasetUtils.convertToDataset(a.getSlice((Slice) null, null, null));
		assertArrayEquals("Incorrect shape", new int[] {datasets.length, 2, 6}, s.getShape());

		s = DatasetUtils.convertToDataset(a.getSlice(null, new int[] {2,2,2}, null));
		assertArrayEquals("Incorrect shape", new int[] {2, 2, 2}, s.getShape());

		s = DatasetUtils.convertToDataset(a.getSlice(new int[] {1,0,1}, new int[] {2,2,3}, new int[] {1, 1, 2}));
		assertArrayEquals("Incorrect shape", new int[] {1, 2, 1}, s.getShape());

		ILazyDataset l;
		l = a.getSliceView(new int[] {0, 0, 1}, new int[] {2,2,6}, new int[] {1,1,3});
		s = DatasetUtils.convertToDataset(l.getSlice());
		System.out.println("View is " + l + "; slice is " + s);
		assertArrayEquals("Incorrect shape", new int[] {2, 2, 2}, s.getShape());
	}

	@Test
	public void testRepeatedDataset() throws Exception {
		Dataset a = DatasetFactory.createRange(3);
		Dataset[] as = new Dataset[5];
		Arrays.fill(as, a);
		AggregateDataset b = new AggregateDataset(true, as);
		assertEquals("Incorrect rank", a.getRank() + 1, b.getRank());
		assertArrayEquals("Incorrect shape", new int[] {as.length, 3}, b.getShape());

		Dataset s;
		s = DatasetUtils.convertToDataset(b.getSlice(new int[] {1,0}, new int[] {2,2}, null));
		assertArrayEquals("Incorrect shape", new int[] {1, 2}, s.getShape());
		assertArrayEquals("Incorrect values", new double[] {0, 1}, (double[])s.getBuffer(), 1e-5);

		s = DatasetUtils.convertToDataset(b.getSlice(new int[] {0,1}, new int[] {2,2}, null));
		assertArrayEquals("Incorrect shape", new int[] {2, 1}, s.getShape());
		assertArrayEquals("Incorrect values", new double[] {1, 1}, (double[])s.getBuffer(), 1e-5);

		ILazyDataset l;
		l = b.getSliceView(new int[] {1,0}, new int[] {2,2}, null);
		s = DatasetUtils.convertToDataset(l.getSlice());
		System.out.println("View is " + l + "; slice is " + s);
		assertArrayEquals("Incorrect shape", new int[] {1, 2}, s.getShape());
		assertArrayEquals("Incorrect values", new double[] {0, 1}, (double[])s.getBuffer(), 1e-5);

		l = b.getSliceView(new int[] {0,1}, new int[] {2,2}, null);
		s = DatasetUtils.convertToDataset(l.getSlice());
		System.out.println("View is " + l + "; slice is " + s);
		assertArrayEquals("Incorrect shape", new int[] {2, 1}, s.getShape());
		assertArrayEquals("Incorrect values", new double[] {1, 1}, (double[])s.getBuffer(), 1e-5);
	}
}
