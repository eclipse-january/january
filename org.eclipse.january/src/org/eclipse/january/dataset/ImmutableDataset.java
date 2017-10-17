/*-
 * Copyright (c) 2017 Halliburton International, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.january.dataset;

import java.io.Serializable;
import java.text.Format;
import java.util.List;

import org.eclipse.january.IMonitor;
import org.eclipse.january.MetadataException;
import org.eclipse.january.metadata.IMetadata;
import org.eclipse.january.metadata.MetadataType;

/**
 * An internal class used to make a dataset immutable.
 * This class will throw exceptions if getters which give
 * access to data or setters are called.
 * 
 * @author Matthew Gerring
 *
 */
class ImmutableDataset implements Dataset {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4639514187811463816L;
	
	private final Dataset delegate;
	ImmutableDataset(Dataset delegate) {
		this.delegate = delegate;
	}
	public String getName() {
		return delegate.getName();
	}
	public void setName(String name) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public void setStringFormat(Format format) {
		delegate.setStringFormat(format);
	}
	public int getItemBytes() {
		return delegate.getItemBytes();
	}
	public Object getObject(int... pos) {
		return delegate.getObject(pos);
	}
	public <S extends MetadataType, T extends S> List<S> getMetadata(Class<T> clazz) throws MetadataException {
		return delegate.getMetadata(clazz);
	}
	public Class<?> getElementClass() {
		return delegate.getElementClass();
	}
	public String getString(int... pos) {
		return delegate.getString(pos);
	}
	public int getElementsPerItem() {
		return delegate.getElementsPerItem();
	}
	public double getDouble(int... pos) {
		return delegate.getDouble(pos);
	}
	public int getSize() {
		return delegate.getSize();
	}
	public <S extends MetadataType, T extends S> S getFirstMetadata(Class<T> clazz) {
		return delegate.getFirstMetadata(clazz);
	}
	public long getLong(int... pos) {
		return delegate.getLong(pos);
	}
	public int[] getShape() {
		return delegate.getShape();
	}
	public float getFloat(int... pos) {
		return delegate.getFloat(pos);
	}
	public int getInt(int... pos) {
		return delegate.getInt(pos);
	}
	public void setShape(int... shape) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public short getShort(int... pos) {
		return delegate.getShort(pos);
	}
	public int getRank() {
		return delegate.getRank();
	}
	public byte getByte(int... pos) {
		return delegate.getByte(pos);
	}
	public boolean getBoolean(int... pos) {
		return delegate.getBoolean(pos);
	}
	public void set(Object obj, int... pos) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public void resize(int... newShape) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public Number max(boolean... ignoreInvalids) {
		return delegate.max(ignoreInvalids);
	}
	public Object mean(boolean... ignoreInvalids) {
		return delegate.mean(ignoreInvalids);
	}
	public Number min(boolean... ignoreInvalids) {
		return delegate.min(ignoreInvalids);
	}
	public int[] minPos(boolean... ignoreInvalids) {
		return delegate.minPos(ignoreInvalids);
	}
	public int[] getShapeRef() {
		return delegate.getShapeRef();
	}
	public int[] maxPos(boolean... ignoreInvalids) {
		return delegate.maxPos(ignoreInvalids);
	}
	public int getDType() {
		return delegate.getDType();
	}
	public int[] getStrides() {
		return delegate.getStrides();
	}
	public int getOffset() {
		return delegate.getOffset();
	}
	public boolean hasFloatingPointElements() {
		return delegate.hasFloatingPointElements();
	}
	public IMetadata getMetadata() {
		return delegate.getMetadata();
	}
	public int getNbytes() {
		return delegate.getNbytes();
	}
	public Serializable getBuffer() {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable and cannot be changed!");
	}
	public void overrideInternal(Serializable buffer, int... shape) {
		delegate.overrideInternal(buffer, shape);
	}
	public Dataset synchronizedCopy() {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public Dataset getView(boolean deepCopyMetadata) {
		return delegate.getView(deepCopyMetadata);
	}
	public Dataset getBroadcastView(int... shape) {
		return delegate.getBroadcastView(shape);
	}
	public String toString(boolean showData) {
		return delegate.toString(showData);
	}
	public Dataset squeezeEnds() {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public Dataset squeeze() {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public Dataset squeeze(boolean onlyFromEnds) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public Dataset clone() {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public void setDirty() {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public int[] getNDPosition(int n) {
		return delegate.getNDPosition(n);
	}
	public int get1DIndex(int... n) {
		return delegate.get1DIndex(n);
	}
	public int checkAxis(int axis) {
		return delegate.checkAxis(axis);
	}
	public double getError(int... pos) {
		return delegate.getError(pos);
	}
	public void addMetadata(MetadataType metadata) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public boolean isCompatibleWith(ILazyDataset g) {
		return delegate.isCompatibleWith(g);
	}
	public double[] getErrorArray(int... pos) {
		return delegate.getErrorArray(pos);
	}
	public void setMetadata(MetadataType metadata) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public void clearMetadata(Class<? extends MetadataType> clazz) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public void checkCompatibility(ILazyDataset g) throws UnsupportedOperationException {
		delegate.checkCompatibility(g);
	}
	public void setErrors(Serializable errors) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public Dataset reshape(int... shape) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public boolean hasErrors() {
		return delegate.hasErrors();
	}
	public boolean isComplex() {
		return delegate.isComplex();
	}
	public Dataset getRealPart() {
		return delegate.getRealPart();
	}
	public Dataset getRealView() {
		return delegate.getRealView();
	}
	public Dataset getErrors() {
		return new ImmutableDataset(delegate.getErrors());
	}
	public Dataset getErrorBuffer() {
		return new ImmutableDataset(delegate.getErrorBuffer());
	}
	public void setErrorBuffer(Serializable buffer) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public Dataset copy(int dtype) {
		return new ImmutableDataset(delegate.copy(dtype));
	}
	public <T extends Dataset> T copy(Class<T> clazz) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public Dataset cast(int dtype) {
		return new ImmutableDataset(delegate.cast(dtype));
	}
	public <T extends Dataset> T cast(Class<T> clazz) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public Dataset cast(boolean repeat, int dtype, int isize) {
		return new ImmutableDataset(delegate.cast(repeat, dtype, isize));
	}
	public IntegerDataset getIndices() {
		return delegate.getIndices();
	}
	public Dataset getTransposedView(int... axes) {
		return new ImmutableDataset(delegate.getTransposedView(axes));
	}
	public Dataset transpose(int... axes) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public Dataset swapAxes(int axis1, int axis2) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public Dataset flatten() {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public Dataset getUniqueItems() {
		return new ImmutableDataset(delegate.getUniqueItems());
	}
	public IndexIterator getIterator(boolean withPosition) {
		return delegate.getIterator(withPosition);
	}
	public IndexIterator getIterator() {
		return delegate.getIterator();
	}
	public PositionIterator getPositionIterator(int... axes) {
		return delegate.getPositionIterator(axes);
	}
	public IndexIterator getSliceIterator(int[] start, int[] stop, int[] step) {
		return delegate.getSliceIterator(start, stop, step);
	}
	public IndexIterator getSliceIterator(SliceND slice) {
		return delegate.getSliceIterator(slice);
	}
	public SliceIterator getSliceIteratorFromAxes(int[] pos, boolean[] axes) {
		return delegate.getSliceIteratorFromAxes(pos, axes);
	}
	public void copyItemsFromAxes(int[] pos, boolean[] axes, Dataset dest) {
		delegate.copyItemsFromAxes(pos, axes, dest);
	}
	public void setItemsOnAxes(int[] pos, boolean[] axes, Object src) {
		delegate.setItemsOnAxes(pos, axes, src);
	}
	public BooleanIterator getBooleanIterator(Dataset choice) {
		return delegate.getBooleanIterator(choice);
	}
	public BooleanIterator getBooleanIterator(Dataset choice, boolean value) {
		return delegate.getBooleanIterator(choice, value);
	}
	public Dataset getByBoolean(Dataset selection) {
		return delegate.getByBoolean(selection);
	}
	public Dataset setByBoolean(Object obj, Dataset selection) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public Dataset getBy1DIndex(IntegerDataset index) {
		return delegate.getBy1DIndex(index);
	}
	public Dataset getByIndexes(Object... indexes) {
		return delegate.getByIndexes(indexes);
	}
	public Dataset setBy1DIndex(Object obj, Dataset index) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public Dataset setByIndexes(Object obj, Object... indexes) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public Dataset fill(Object obj) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public boolean getElementBooleanAbs(int index) {
		return delegate.getElementBooleanAbs(index);
	}
	public double getElementDoubleAbs(int index) {
		return delegate.getElementDoubleAbs(index);
	}
	public long getElementLongAbs(int index) {
		return delegate.getElementLongAbs(index);
	}
	public Object getObjectAbs(int index) {
		return delegate.getObjectAbs(index);
	}
	public String getStringAbs(int index) {
		return delegate.getStringAbs(index);
	}
	public void setObjectAbs(int index, Object obj) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public Object getObject() {
		return delegate.getObject();
	}
	public Object getObject(int i) {
		return delegate.getObject(i);
	}
	public Object getObject(int i, int j) {
		return delegate.getObject(i, j);
	}
	public String getString() {
		return delegate.getString();
	}
	public String getString(int i) {
		return delegate.getString(i);
	}
	public String getString(int i, int j) {
		return delegate.getString(i, j);
	}
	public double getDouble() {
		return delegate.getDouble();
	}
	public double getDouble(int i) {
		return delegate.getDouble(i);
	}
	public double getDouble(int i, int j) {
		return delegate.getDouble(i, j);
	}
	public float getFloat() {
		return delegate.getFloat();
	}
	public float getFloat(int i) {
		return delegate.getFloat(i);
	}
	public float getFloat(int i, int j) {
		return delegate.getFloat(i, j);
	}
	public long getLong() {
		return delegate.getLong();
	}
	public long getLong(int i) {
		return delegate.getLong(i);
	}
	public long getLong(int i, int j) {
		return delegate.getLong(i, j);
	}
	public int getInt() {
		return delegate.getInt();
	}
	public int getInt(int i) {
		return delegate.getInt(i);
	}
	public int getInt(int i, int j) {
		return delegate.getInt(i, j);
	}
	public short getShort() {
		return delegate.getShort();
	}
	public short getShort(int i) {
		return delegate.getShort(i);
	}
	public short getShort(int i, int j) {
		return delegate.getShort(i, j);
	}
	public byte getByte() {
		return delegate.getByte();
	}
	public byte getByte(int i) {
		return delegate.getByte(i);
	}
	public byte getByte(int i, int j) {
		return delegate.getByte(i, j);
	}
	public boolean getBoolean() {
		return delegate.getBoolean();
	}
	public boolean getBoolean(int i) {
		return delegate.getBoolean(i);
	}
	public boolean getBoolean(int i, int j) {
		return delegate.getBoolean(i, j);
	}
	public double getError() {
		return delegate.getError();
	}
	public double getError(int i) {
		return delegate.getError(i);
	}
	public double getError(int i, int j) {
		return delegate.getError(i, j);
	}
	public double[] getErrorArray(int i) {
		return delegate.getErrorArray(i);
	}
	public double[] getErrorArray(int i, int j) {
		return delegate.getErrorArray(i, j);
	}
	public void set(Object obj) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public void set(Object obj, int i) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public void set(Object obj, int i, int j) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public Dataset sort(Integer axis) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public Dataset getSlice(int[] start, int[] stop, int[] step) {
		return delegate.getSlice(start, stop, step);
	}
	public Dataset getSlice(IMonitor mon, int[] start, int[] stop, int[] step) {
		return new ImmutableDataset(delegate.getSlice(mon, start, stop, step));
	}
	public Dataset getSlice(Slice... slice) {
		return new ImmutableDataset(delegate.getSlice(slice));
	}
	public Dataset getSlice(IMonitor mon, Slice... slice) {
		return new ImmutableDataset(delegate.getSlice(mon, slice));
	}
	public Dataset getSlice(SliceND slice) {
		return new ImmutableDataset(delegate.getSlice(slice));
	}
	public Dataset getSlice(IMonitor mon, SliceND slice) {
		return new ImmutableDataset(delegate.getSlice(mon, slice));
	}
	public Dataset getSliceView(int[] start, int[] stop, int[] step) {
		return new ImmutableDataset(delegate.getSliceView(start, stop, step));
	}
	public Dataset getSliceView(Slice... slice) {
		return new ImmutableDataset(delegate.getSliceView(slice));
	}
	public Dataset getSliceView(SliceND slice) {
		return new ImmutableDataset(delegate.getSliceView(slice));
	}
	public Dataset setSlice(Object obj, int[] start, int[] stop, int[] step) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public Dataset setSlice(Object obj, Slice... slice) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public Dataset setSlice(Object obj, SliceND slice) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public Dataset setSlice(Object obj, IndexIterator iterator) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public void fillDataset(Dataset other, IndexIterator iter) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public boolean all() {
		return delegate.all();
	}
	public Dataset all(int axis) {
		return delegate.all(axis);
	}
	public boolean any() {
		return delegate.any();
	}
	public Dataset any(int axis) {
		return delegate.any(axis);
	}
	public Dataset iadd(Object o) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public Dataset isubtract(Object o) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public Dataset imultiply(Object o) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public Dataset idivide(Object o) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public Dataset ifloorDivide(Object o) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public Dataset iremainder(Object o) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public Dataset ifloor() {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public Dataset ipower(Object o) {
		throw new UnsupportedOperationException("Dataset "+getName()+" is immutable!");
	}
	public double residual(Object o) {
		return delegate.residual(o);
	}
	public double residual(Object o, boolean ignoreNaNs) {
		return delegate.residual(o, ignoreNaNs);
	}
	public double residual(Object o, Dataset weight, boolean ignoreNaNs) {
		return delegate.residual(o, weight, ignoreNaNs);
	}
	public boolean containsInfs() {
		return delegate.containsInfs();
	}
	public boolean containsNans() {
		return delegate.containsNans();
	}
	public boolean containsInvalidNumbers() {
		return delegate.containsInvalidNumbers();
	}
	public Dataset max(int axis, boolean... ignoreInvalids) {
		return delegate.max(axis, ignoreInvalids);
	}
	public Dataset min(int axis, boolean... ignoreInvalids) {
		return delegate.min(axis, ignoreInvalids);
	}
	public int argMax(boolean... ignoreInvalids) {
		return delegate.argMax(ignoreInvalids);
	}
	public Dataset argMax(int axis, boolean... ignoreInvalids) {
		return delegate.argMax(axis, ignoreInvalids);
	}
	public int argMin(boolean... ignoreInvalids) {
		return delegate.argMin(ignoreInvalids);
	}
	public Dataset argMin(int axis, boolean... ignoreInvalids) {
		return delegate.argMin(axis, ignoreInvalids);
	}
	public Number peakToPeak(boolean... ignoreInvalids) {
		return delegate.peakToPeak(ignoreInvalids);
	}
	public Dataset peakToPeak(int axis, boolean... ignoreInvalids) {
		return delegate.peakToPeak(axis, ignoreInvalids);
	}
	public long count(boolean... ignoreInvalids) {
		return delegate.count(ignoreInvalids);
	}
	public Dataset count(int axis, boolean... ignoreInvalids) {
		return delegate.count(axis, ignoreInvalids);
	}
	public Object sum(boolean... ignoreInvalids) {
		return delegate.sum(ignoreInvalids);
	}
	public Dataset sum(int axis, boolean... ignoreInvalids) {
		return delegate.sum(axis, ignoreInvalids);
	}
	public Object product(boolean... ignoreInvalids) {
		return delegate.product(ignoreInvalids);
	}
	public Dataset product(int axis, boolean... ignoreInvalids) {
		return delegate.product(axis, ignoreInvalids);
	}
	public Dataset mean(int axis, boolean... ignoreInvalids) {
		return delegate.mean(axis, ignoreInvalids);
	}
	public double variance() {
		return delegate.variance();
	}
	public double variance(boolean isWholePopulation, boolean... ignoreInvalids) {
		return delegate.variance(isWholePopulation, ignoreInvalids);
	}
	public Dataset variance(int axis) {
		return delegate.variance(axis);
	}
	public Dataset variance(int axis, boolean isWholePopulation, boolean... ignoreInvalids) {
		return delegate.variance(axis, isWholePopulation, ignoreInvalids);
	}
	public double stdDeviation() {
		return delegate.stdDeviation();
	}
	public double stdDeviation(boolean isWholePopulation, boolean... ignoreInvalids) {
		return delegate.stdDeviation(isWholePopulation, ignoreInvalids);
	}
	public Dataset stdDeviation(int axis) {
		return delegate.stdDeviation(axis);
	}
	public Dataset stdDeviation(int axis, boolean isWholePopulation, boolean... ignoreInvalids) {
		return delegate.stdDeviation(axis, isWholePopulation, ignoreInvalids);
	}
	public double rootMeanSquare(boolean... ignoreInvalids) {
		return delegate.rootMeanSquare(ignoreInvalids);
	}
	public Dataset rootMeanSquare(int axis, boolean... ignoreInvalids) {
		return delegate.rootMeanSquare(axis, ignoreInvalids);
	}
	
}