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
public class ObjectDataset extends ObjectDatasetBase {
	// pin UID to base class
	private static final long serialVersionUID = Dataset.serialVersionUID;

	/**
	 * Create a null dataset
	 */
	ObjectDataset() {
		super();
	}

	/**
	 * Create a null-filled dataset of given shape
	 * @param shape
	 */
	ObjectDataset(final int... shape) {
		super(shape);
	}

	/**
	 * Create a dataset using given data
	 * @param data
	 * @param shape (can be null to create 1D dataset)
	 */
	ObjectDataset(final Object[] data, int... shape) {
		super(data, shape);
	}

	/**
	 * Copy a dataset
	 * @param dataset
	 */
	ObjectDataset(final ObjectDataset dataset) {
		super(dataset);
	}

	/**
	 * Cast a dataset to this class type
	 * @param dataset
	 */
	ObjectDataset(final Dataset dataset) {
		super(dataset);
	}

	@Override
	public ObjectDataset getView(boolean deepCopyMetadata) {
		ObjectDataset view = new ObjectDataset();
		copyToView(this, view, true, deepCopyMetadata);
		view.setData();
		return view;
	}

	@Override
	public ObjectDataset clone() {
		return new ObjectDataset(this);
	}

	@Override
	public ObjectDataset getSlice(SliceIterator siter) {
		ObjectDatasetBase base = super.getSlice(siter);

		ObjectDataset slice = new ObjectDataset();
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
	static ObjectDataset createFromObject(final Object obj) {
		ObjectDatasetBase result = ObjectDatasetBase.createFromObject(obj);
		ObjectDataset ds = new ObjectDataset(result.data, result.shape);
		if (result.shape.length == 0) {
			ds.setShape(result.shape); // special case of single item
		}
		return ds;
	}

	/**
	 * @param shape
	 * @return a dataset filled with ones
	 */
	static ObjectDataset ones(final int... shape) {
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
	public int getInt() {
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
	public int[] minPos(boolean... ignoreInvalids) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public int[] maxPos(boolean... ignoreInvalids) {
		throw new UnsupportedOperationException("Unsupported method for class");
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
	public ObjectDataset iadd(Object o) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public ObjectDataset isubtract(Object o) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public ObjectDataset imultiply(Object o) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public ObjectDataset idivide(Object o) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public ObjectDataset iremainder(Object o) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public ObjectDataset ifloor() {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public ObjectDataset ipower(Object o) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public double residual(Object o) {
		throw new UnsupportedOperationException("Unsupported method for class");
	}
}
