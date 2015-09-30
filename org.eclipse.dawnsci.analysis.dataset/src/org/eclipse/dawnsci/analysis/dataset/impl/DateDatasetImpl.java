/*-
 * Copyright 2015 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.dataset.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.dawnsci.analysis.api.dataset.IDataset;

public class DateDatasetImpl extends StringDataset implements DateDataset {
	
	private static final SimpleDateFormat ISO8601_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	

	public static DateDatasetImpl createFromObject(final Object obj) {
		final DateDatasetImpl result = new DateDatasetImpl();
		result.shape = getShapeFromObject(obj);
		result.size = calcSize(result.shape);
		result.odata = result.data = createArray(result.size);
		
		final int[] pos = new int[result.shape.length];
		result.fillData(obj, 0, pos);
		
		return result;
	}
	
	public DateDatasetImpl() {
		super();
	}
	
	public DateDatasetImpl(final int... shape) {
		super(shape);
	}
	
	public DateDatasetImpl(final Date[] data, int... shape) {
		super(datesToStrings(data), shape);
	}
	
	private static String[] datesToStrings(final Date[] dates) {
		final String[] dateStrings = new String[dates.length];
		for (int i = 0; i < dates.length; i++) {
			dateStrings[i] = dateToString(dates[i]);
		}
		
		return dateStrings;
	}
	
	private static String dateToString(final Date date) {
		if (date != null) {
			return ISO8601_DATE_FORMAT.format(date);
		}
		
		return null;
	}
	
	private static String objectToDateString(final Object obj) {
		if (obj instanceof Date) {
			return dateToString((Date) obj);
		} else if (obj instanceof Dataset) {
			Dataset dataset = (Dataset) obj;
			if (dataset.getSize() != 1) {
				logger.error("Given dataset must only have one item");
				throw new IllegalArgumentException("Given dataset must have only one item");
			}
			
			return objectToDateString(dataset.getObjectAbs(0));
		} else if (obj instanceof IDataset) {
			IDataset dataset = (IDataset) obj;
			if (dataset.getSize() != 1) {
				logger.error("Given dataset must only have one item");
				throw new IllegalArgumentException("Given dataset must have only one item");
			}
			return objectToDateString(dataset.getObject(new int[dataset.getRank()]));
		} else {
			logger.error("Argument is of unsupported class");
			throw new IllegalArgumentException("Argument is of unsupported class");
		}
	}
	
	private static Date stringToDate(final String dateAsString) {
		if (dateAsString != null) {
			try {
				return ISO8601_DATE_FORMAT.parse(dateAsString);
			} catch (ParseException e) {
				// fall through to return null
				logger.error("Could not parse datetime: " + dateAsString);
			}
		}
		
		return null;
	}
	
	
	@Override
	public Date getDate(int i) {
		final String dateAsString = super.getString(i);
		return stringToDate(dateAsString);
	}

	@Override
	public Date getDate(int i, int j) {
		final String dateAsString = super.getString(i, j);
		return stringToDate(dateAsString);
	}

	@Override
	public Date getDate(int... pos) {
		final String dateAsString = super.getString(pos);
		return stringToDate(dateAsString);
	}

	@Override
	public Date getDateAbs(int index) {
		final String dateAsString = super.getStringAbs(index);
		if (dateAsString != null) {
			return stringToDate(dateAsString);
		}
		
		return null;
	}
	
	@Override
	public void setItemDirect(final int dindex, final int sindex, final Object src) { // PRIM TYPE
		if (src instanceof String[]) {
			super.setItemDirect(dindex, sindex, src);
		} else if (src instanceof Date[]) {
			String[] datesAsStrings = datesToStrings((Date[]) src);
			data[dindex] = datesAsStrings[sindex];
		} else {
			logger.error("Argument is of unsupported class");
			throw new IllegalArgumentException("Argument is of unsupported class");
		}
	}

	public void setAbs(final int index, final Date date) { // PRIM TYPE
		data[index] = dateToString(date);
		setDirty();
	}
	
	public void setItem(final Date value, final int i) { // PRIM TYPE
		setAbs(get1DIndex(i), value);
	}
	
	public void setItem(final Date value, final int i, final int j) { // PRIM TYPE
		setAbs(get1DIndex(i, j), value);
	}
	
	public void setItem(final Date value, final int... pos) { // PRIM TYPE
		setAbs(get1DIndex(pos), value);
	}
	
	@Override
	public void set(final Object obj, final int i) {
		setItem(objectToDateString(obj), i); // FROM OBJECT
	}
	
	@Override
	public void set(final Object obj, final int i, final int j) {
		setItem(objectToDateString(obj), i, j); // FROM OBJECT
	}
	
	@Override
	public void set(final Object obj, int... pos) {
		if (pos == null || (pos.length == 0 && shape.length > 0)) {
			pos = new int[shape.length];
		}
		
		setItem(objectToDateString(obj), pos); // FROM OBJECT
	}
	
	@Override
	public StringDatasetBase sort(Integer axis) {
		// Note yet supported.
		// TODO: this method will be inefficient as we store dates formatted as strings
		throw new UnsupportedOperationException("Cannot sort dataset");
	}

}
