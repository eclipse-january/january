/*-
 *******************************************************************************
 * Copyright (c) 2011, 2016 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Peter Chang - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.january.dataset;

import java.text.MessageFormat;

/**
 * Extend dataset for objects
 */
public class StringDataset extends StringDatasetBase {
	// pin UID to base class
	private static final long serialVersionUID = Dataset.serialVersionUID;

	/**
	 * Create a null dataset
	 */
	StringDataset() {
		super();
	}

	/**
	 * Create a null-filled dataset of given shape
	 * @param shape
	 */
	StringDataset(final int... shape) {
		super(shape);
	}

	/**
	 * Create a dataset using given data
	 * @param data
	 * @param shape
	 *            (can be null to create 1D dataset)
	 */
	StringDataset(final String[] data, int... shape) {
		super(data, shape);
	}

	/**
	 * Copy a dataset
	 * @param dataset
	 */
	StringDataset(final StringDataset dataset) {
		super(dataset);
	}

	/**
	 * Cast a dataset to this class type
	 * @param dataset
	 */
	StringDataset(final Dataset dataset) {
		super(dataset);
	}

	@Override
	public StringDataset getView(boolean deepCopyMetadata) {
		StringDataset view = new StringDataset();
		copyToView(this, view, true, deepCopyMetadata);
		view.setData();
		return view;
	}

	@Override
	public StringDataset clone() {
		return new StringDataset(this);
	}

	@Override
	public StringDataset getSlice(SliceIterator siter) {
		StringDatasetBase base = super.getSlice(siter);

		StringDataset slice = new StringDataset();
		copyToView(base, slice, false, false);
		slice.setData();
		return slice;
	}

	/**
	 * Create a dataset from an object which could be a Java list, array (of arrays...)
	 * or Number. Ragged sequences or arrays are padded with zeros.
	 * 
	 * @param obj
	 * @return dataset with contents given by input
	 */
	static StringDataset createFromObject(final Object obj) {
		StringDatasetBase result = StringDatasetBase.createFromObject(obj);
		StringDataset ds = new StringDataset(result.data, result.shape);
		if (result.shape.length == 0) {
			ds.setShape(result.shape); // special case of single item
		}
		return ds;
	}

	/**
	 * @param shape
	 * @return a dataset filled with ones
	 */
	static StringDataset ones(final int... shape) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public boolean getElementBooleanAbs(int index) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public double getElementDoubleAbs(int index) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public long getElementLongAbs(int index) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public double getDouble() {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public double getDouble(int i) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public double getDouble(int i, int j) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public double getDouble(int... pos) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public float getFloat() {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public float getFloat(int i) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public float getFloat(int i, int j) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public float getFloat(int... pos) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public long getLong() {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public long getLong(int i) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public long getLong(int i, int j) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public long getLong(int... pos) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public int getInt(int i) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public int getInt(int i, int j) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public int getInt(int... pos) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public short getShort() {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public short getShort(int i) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public short getShort(int i, int j) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public short getShort(int... pos) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public byte getByte() {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public byte getByte(int i) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public byte getByte(int i, int j) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public byte getByte(int... pos) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public boolean getBoolean() {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public boolean getBoolean(int i) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public boolean getBoolean(int i, int j) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public boolean getBoolean(int... pos) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public String getStringAbs(final int index) {
		return stringFormat instanceof MessageFormat ? stringFormat.format(data[index]) :
				String.format("%s", data[index]);
	}

	@Override
	public boolean containsInfs() {
		return false;
	}

	@Override
	public boolean containsNans() {
		return false;
	}

	@Override
	public StringDataset iadd(Object o) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public StringDataset isubtract(Object o) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public StringDataset imultiply(Object o) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public StringDataset idivide(Object o) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public StringDataset iremainder(Object o) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public StringDataset ifloor() {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public StringDataset ipower(Object o) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public double residual(Object o) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}
}
