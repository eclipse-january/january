/*-
 * Copyright 2015, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import static org.eclipse.january.asserts.TestUtils.assertDatasetEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

public class DateDatasetTest {
	static final long START_DATE = 1443657600000l; // 2015-10-01 00:00:00 GMT
	static final int INTERVAL = 24 * 60 * 60 * 1000; // 1 day in seconds
	
	// create an array of dates starting 1st Oct 2015, each 1 day apart
	private int[] createOffsets(int pts) {
		int[] times = new int[pts];
		for (int i = 0; i < pts; i++) {
			times[i] = INTERVAL * i;
		}
		return times;
	}

	@Test
	public void testConstructor() {
		assertEquals(0, new DateDatasetImpl().getSize());
		assertEquals(0, DatasetFactory.createFromObject(new Date(0)).getRank());

		int numDates = 10;
		int[] times = createOffsets(numDates);
		Date[] dates = new Date[numDates];
		for (int i = 0; i < numDates; i++) {
			dates[i] = new Date(times[i] + START_DATE);
		}
		DateDatasetImpl dataset = new DateDatasetImpl(dates);
		
		IndexIterator it = dataset.getIterator();
		for (int i = 0; it.hasNext(); i++) {
			assertEquals(dates[i], dataset.getDateAbs(i));
		}
	}

	@Test
	public void testCreateFromObject() {
		final Date date = new Date(1443657600000l); // 2015-10-01 00:00:00 GMT
		DateDataset dataset = DateDatasetImpl.createFromObject(date);
		assertEquals(date, dataset.getDateAbs(0));

		Dataset d = DatasetFactory.createFromObject(date);
		assertTrue(d instanceof DateDataset);
	}

	static class TimeDataset extends IntegerDataset implements DateDataset {
		private static final long serialVersionUID = 1L;
		long start;

		public TimeDataset(int[] times) {
			super(times, null);
		}
		
		static TimeDataset createDateDataset(Date start, int[] times) {
			TimeDataset t = new TimeDataset(times);
			t.setEpoch(start);
			return t;
		}

		/**
		 * Set instant in time as origin used internally
		 * @param start
		 */
		public void setEpoch(Date start) {
			this.start = start.getTime();
		}

		@Override
		public Date getDate() {
			long t = getLong();
			return new Date(start + t);
		}

		@Override
		public Date getDate(int i) {
			long t = getLong(i);
			return new Date(start + t);
		}

		@Override
		public Date getDate(int i, int j) {
			long t = getLong(i, j);
			return new Date(start + t);
		}

		@Override
		public Date getDate(int... pos) {
			long t = getLong(pos);
			return new Date(start + t);
		}

		@Override
		public Date getDateAbs(int index) {
			long t = getElementLongAbs(index);
			return new Date(start + t);
		}

		@Override
		public Object getObject() {
			return getDate();
		}

		@Override
		public Object getObject(int i) {
			return getDate(i);
		}

		@Override
		public Object getObject(int i, int j) {
			return getDate(i, j);
		}

		@Override
		public Object getObject(int... pos) {
			return getDate(pos);
		}

		@Override
		public Object getObjectAbs(int index) {
			return getDateAbs(index);
		}
	}

	static class TimeDataset2 extends TimeDataset {
		private static final long serialVersionUID = 1L;

		public TimeDataset2(int[] times) {
			super(times);
		}

		static TimeDataset2 createDateDataset(Date start, int[] times) {
			TimeDataset2 t = new TimeDataset2(times);
			t.setEpoch(start);
			return t;
		}
	}

	@Test
	public void testOtherImplementation() {
		int numDates = 10;
		int[] times = createOffsets(numDates);
		Date[] dates = new Date[numDates];
		for (int i = 0; i < numDates; i++) {
			dates[i] = new Date(times[i] + START_DATE);
		}
		DateDatasetImpl d = new DateDatasetImpl(dates);

		assertTrue(d instanceof DateDataset);
		assertEquals(Date.class, d.getElementClass());
		assertEquals(1, d.getItemBytes());
		assertEquals(dates[0], d.getDateAbs(0));

		TimeDataset t = TimeDataset.createDateDataset(new Date(START_DATE), times);
		assertTrue(t instanceof DateDataset);
		assertEquals(Date.class, t.getElementClass());
		assertEquals(1, t.getItemBytes());
		assertDatasetEquals(d, t);

		TimeDataset2 t2 = TimeDataset2.createDateDataset(new Date(START_DATE), times);
		assertTrue(t2 instanceof DateDataset);
		assertEquals(Date.class, t2.getElementClass());
		assertEquals(1, t2.getItemBytes());
		assertDatasetEquals(t, t2);

		Class<? extends Dataset> clazz = d.getClass();
		assertEquals(true,  InterfaceUtils.isElemental(clazz));
		assertEquals(false, InterfaceUtils.isCompound(clazz));
		assertEquals(false, InterfaceUtils.isInteger(clazz));
		assertEquals(false, InterfaceUtils.isNumerical(clazz));
		assertEquals(false, InterfaceUtils.isFloating(clazz));
		assertEquals(false, InterfaceUtils.isComplex(clazz));
	}
}
