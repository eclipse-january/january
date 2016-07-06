/*-
 * Copyright 2015 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.eclipse.january.dataset.DateDataset;
import org.eclipse.january.dataset.DateDatasetImpl;
import org.eclipse.january.dataset.IndexIterator;
import org.junit.Test;

public class DateDatasetTest {
	
	@Test
	public void testConstructor() {
		// create an array of dates starting 1st Oct 2015, each 1 day apart
		final long startDate = 1443657600000l; // 2015-10-01 00:00:00 GMT
		final long interval = 24 * 60 * 60 * 1000; // 1 day
		final int numDates = 10;
		final Date[] dates = new Date[numDates];
		long currentDate = startDate;
		for (int i = 0; i < numDates; i++) {
			dates[i] = new Date(currentDate);
			currentDate += interval;
		}
		// add to new DateDataset
		DateDatasetImpl dataset = new DateDatasetImpl(dates, null);
		
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
	}
	
}
