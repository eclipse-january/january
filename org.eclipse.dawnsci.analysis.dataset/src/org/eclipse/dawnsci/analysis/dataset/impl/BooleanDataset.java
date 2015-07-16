/*-
 *******************************************************************************
 * Copyright (c) 2011, 2014 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Peter Chang - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.dawnsci.analysis.dataset.impl;

import java.text.MessageFormat;


/**
 * Extend boolean base dataset for boolean values
 */
public class BooleanDataset extends BooleanDatasetBase {
	// pin UID to base class
	private static final long serialVersionUID = Dataset.serialVersionUID;

	public BooleanDataset() {
		super();
	}

	/**
	 * Create a false-filled dataset of given shape
	 * @param shape
	 */
	public BooleanDataset(final int... shape) {
		super(shape);
	}

	/**
	 * Create a dataset using given data
	 * @param data
	 * @param shape (can be null to create 1D dataset)
	 */
	public BooleanDataset(final boolean[] data, int... shape) {
		super(data, shape);
	}

	/**
	 * Copy a dataset
	 * @param dataset
	 */
	public BooleanDataset(final BooleanDataset dataset) {
		super(dataset);
	}

	/**
	 * Cast a dataset to this class type
	 * @param dataset
	 */
	public BooleanDataset(final Dataset dataset) {
		super(dataset);
	}

	@Override
	public BooleanDataset getView() {
		BooleanDataset view = new BooleanDataset();
		copyToView(this, view, true, true);
		view.data = data;
		return view;
	}

	@Override
	public BooleanDataset clone() {
		return new BooleanDataset(this);
	}

	@Override
	public BooleanDataset getSlice(SliceIterator siter) {
		BooleanDataset slice = new BooleanDataset();
		BooleanDatasetBase base = super.getSlice(siter);
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
	public static BooleanDataset createFromObject(final Object obj) {
		BooleanDatasetBase result = BooleanDatasetBase.createFromObject(obj);
		return new BooleanDataset(result.data, result.shape);
	}

	/**
	 * @param shape
	 * @return a dataset filled with trues
	 */
	public static BooleanDataset ones(final int... shape) {
		BooleanDatasetBase result = BooleanDatasetBase.ones(shape);
		return new BooleanDataset(result.data, result.shape);
	}

	@Override
	public boolean getElementBooleanAbs(final int index) {
		return data[index];
	}

	@Override
	public double getElementDoubleAbs(final int index) {
		return data[index] ? 1 : 0;
	}

	@Override
	public long getElementLongAbs(final int index) {
		return data[index] ? 1 : 0;
	}

	@Override
	public double getDouble(final int i) {
		return getInt(i);
	}

	@Override
	public double getDouble(final int i, final int j) {
		return getInt(i, j);
	}

	@Override
	public double getDouble(final int... pos) {
		return getInt(pos);
	}

	@Override
	public float getFloat(final int i) {
		return getInt(i);
	}

	@Override
	public float getFloat(final int i, final int j) {
		return getInt(i, j);
	}

	@Override
	public float getFloat(final int... pos) {
		return getInt(pos);
	}

	@Override
	public long getLong(final int i) {
		return getInt(i);
	}

	@Override
	public long getLong(final int i, final int j) {
		return getInt(i, j);
	}

	@Override
	public long getLong(final int... pos) {
		return getInt(pos);
	}

	@Override
	public int getInt(final int i) {
		return get(i) ? 1 : 0;
	}

	@Override
	public int getInt(final int i, final int j) {
		return get(i, j) ? 1 : 0;
	}

	@Override
	public int getInt(final int... pos) {
		return get(pos) ? 1 : 0;
	}

	@Override
	public short getShort(final int i) {
		return (short) getInt(i);
	}

	@Override
	public short getShort(final int i, final int j) {
		return (short) getInt(i, j);
	}

	@Override
	public short getShort(final int... pos) {
		return (short) getInt(pos);
	}

	@Override
	public byte getByte(final int i) {
		return (byte) getInt(i);
	}

	@Override
	public byte getByte(final int i, final int j) {
		return (byte) getInt(i, j);
	}

	@Override
	public byte getByte(final int... pos) {
		return (byte) getInt(pos);
	}

	@Override
	public boolean getBoolean(final int i) {
		return get(i);
	}

	@Override
	public boolean getBoolean(final int i, final int j) {
		return get(i, j);
	}

	@Override
	public boolean getBoolean(final int... pos) {
		return get(pos);
	}

	@Override
	public String getStringAbs(final int index) {
		return stringFormat instanceof MessageFormat ? stringFormat.format(data[index]) :
				String.format("%b", data[index]);
	}

	@Override
	public BooleanDataset getSlice(final int[] start, final int[] stop, final int[] step) {
		BooleanDatasetBase result = (BooleanDatasetBase) super.getSlice(start, stop, step);

		return new BooleanDataset(result.data, result.shape);
	}

	/**
	 * OR
	 */
	@Override
	public BooleanDataset iadd(final Object b) {
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		final BroadcastIterator it = BroadcastIterator.createIterator(this, bds);
		while (it.hasNext()) {
			data[it.aIndex] |= bds.getElementBooleanAbs(it.bIndex);
		}
		setDirty();
		return this;
	}

	/**
	 * XOR
	 */
	@Override
	public BooleanDataset isubtract(final Object b) {
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		final BroadcastIterator it = BroadcastIterator.createIterator(this, bds);
		while (it.hasNext()) {
			data[it.aIndex] ^= bds.getElementBooleanAbs(it.bIndex);
		}
		setDirty();
		return this;
	}

	/**
	 * AND
	 */
	@Override
	public BooleanDataset imultiply(final Object b) {
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		final BroadcastIterator it = BroadcastIterator.createIterator(this, bds);
		while (it.hasNext()) {
			data[it.aIndex] &= bds.getElementBooleanAbs(it.bIndex);
		}
		setDirty();
		return this;
	}

	@Override
	public BooleanDataset idivide(final Object b) {
		return imultiply(b);
	}

	@Override
	public BooleanDataset iremainder(final Object b) {
		logger.error("Unsupported method for class");
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public BooleanDataset ipower(final Object b) {
		logger.error("Unsupported method for class");
		throw new UnsupportedOperationException("Unsupported method for class");
	}

	@Override
	public double residual(final Object b, final Dataset w, boolean ignoreNaNs) {
		Dataset bds = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);
		final BroadcastIterator it = BroadcastIterator.createIterator(this, bds);
		double sum = 0;
		{
			if (w == null) {
				while (it.hasNext()) {
					if (data[it.aIndex] ^ bds.getElementBooleanAbs(it.bIndex))
						sum++;
				}
			} else {
				IndexIterator itw = w.getIterator();
				double comp = 0;
				while (it.hasNext() && itw.hasNext()) {
					if (data[it.aIndex] ^ bds.getElementBooleanAbs(it.bIndex)) {
						final double err = w.getElementDoubleAbs(itw.index) - comp;
						final double temp = sum + err;
						comp = (temp - sum) - err;
						sum = temp;
					}
				}
			}
		}
		return sum;
	}
}
