/*-
 *******************************************************************************
 * Copyright (c) 2022 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Peter Chang - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.january.dataset;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to hold colour datasets as red, green, blue tuples of byte integers. Note that
 * the values are treated as unsigned integers
 * @since 2.3
 */
public class RGBByteDataset extends CompoundByteDataset implements Cloneable {
	// pin UID to base class
	private static final long serialVersionUID = Dataset.serialVersionUID;

	private static final Logger logger = LoggerFactory.getLogger(RGBByteDataset.class);

	private static final int ISIZE = 3; // number of elements per item

	/**
	 * Create a null dataset
	 */
	public RGBByteDataset() {
		super(ISIZE);
	}

	/**
	 * @param shape output shape
	 */
	public RGBByteDataset(final int... shape) {
		super(ISIZE, shape);
	}

	/**
	 * @param data interleaved RGB values
	 * @param shape output shape
	 */
	public RGBByteDataset(final byte[] data, final int... shape) {
		super(ISIZE, data, shape);
	}

	/**
	 * Copy a dataset
	 * @param dataset to clone
	 */
	public RGBByteDataset(final RGBByteDataset dataset) {
		super(dataset);
	}

	@Override
	public RGBByteDataset clone() {
		return new RGBByteDataset(this);
	}

	/**
	 * Create a dataset using given data (red, green and blue parts are given separately)
	 * @param redData data for red
	 * @param greenData data for green
	 * @param blueData data for blue
	 * @param shape (can be null to create 1D dataset)
	 */
	public RGBByteDataset(final int[] redData, final int[] greenData, final int[] blueData, int... shape) {
		int dsize = redData.length > greenData.length ? greenData.length : redData.length;
		dsize = dsize > blueData.length ? blueData.length : dsize;
		if (shape == null || shape.length == 0) {
			shape = new int[] {dsize};
		}
		isize = ISIZE;
		size = ShapeUtils.calcSize(shape);
		if (size != dsize) {
			logger.error("Shape is not compatible with size of data array");
			throw new IllegalArgumentException("Shape is not compatible with size of data array");
		}
		this.shape = shape.clone();

		try {
			odata = data = createArray(size);
		} catch (Throwable t) {
			logger.error("Could not create a dataset of shape {}", Arrays.toString(shape), t);
			throw new IllegalArgumentException(t);
		}

		for (int i = 0, n = 0; i < size; i++) {
			data[n++] = (byte) redData[i];
			data[n++] = (byte) greenData[i];
			data[n++] = (byte) blueData[i];
		}
	}

	/**
	 * Create a dataset using given data (red, green and blue parts are given separately)
	 * @param redData data for red
	 * @param greenData data for green
	 * @param blueData data for blue
	 * @param shape (can be null to create 1D dataset)
	 */
	public RGBByteDataset(final short[] redData, final short[] greenData, final short[] blueData, int... shape) {
		int dsize = redData.length > greenData.length ? greenData.length : redData.length;
		dsize = dsize > blueData.length ? blueData.length : dsize;
		if (shape == null || shape.length == 0) {
			shape = new int[] {dsize};
		}
		isize = ISIZE;
		size = ShapeUtils.calcSize(shape);
		if (size != dsize) {
			logger.error("Shape is not compatible with size of data array");
			throw new IllegalArgumentException("Shape is not compatible with size of data array");
		}
		this.shape = shape.clone();

		try {
			odata = data = createArray(size);
		} catch (Throwable t) {
			logger.error("Could not create a dataset of shape {}", Arrays.toString(shape), t);
			throw new IllegalArgumentException(t);
		}

		for (int i = 0, n = 0; i < size; i++) {
			data[n++] = (byte) redData[i];
			data[n++] = (byte) greenData[i];
			data[n++] = (byte) blueData[i];
		}
	}

	/**
	 * Create a dataset using given data (red, green and blue parts are given separately)
	 * @param redData data for red
	 * @param greenData data for green
	 * @param blueData data for blue
	 * @param shape (can be null to create 1D dataset)
	 */
	public RGBByteDataset(final byte[] redData, final byte[] greenData, final byte[] blueData, int... shape) {
		int dsize = redData.length > greenData.length ? greenData.length : redData.length;
		dsize = dsize > blueData.length ? blueData.length : dsize;
		if (shape == null || shape.length == 0) {
			shape = new int[] {dsize};
		}
		isize = ISIZE;
		size = ShapeUtils.calcSize(shape);
		if (size != dsize) {
			logger.error("Shape is not compatible with size of data array");
			throw new IllegalArgumentException("Shape is not compatible with size of data array");
		}
		this.shape = shape.clone();

		try {
			odata = data = createArray(size);
		} catch (Throwable t) {
			logger.error("Could not create a dataset of shape {}", Arrays.toString(shape), t);
			throw new IllegalArgumentException(t);
		}

		for (int i = 0, n = 0; i < size; i++) {
			data[n++] = redData[i];
			data[n++] = greenData[i];
			data[n++] = blueData[i];
		}
	}

	private final static int MIN_VALUE = 0;
	private final static int MAX_VALUE = 255;

	/**
	 * Create a dataset using given colour data (colour components are given separately)
	 * @param red dataset
	 * @param green dataset
	 * @param blue dataset
	 */
	public RGBByteDataset(final Dataset red, final Dataset green, final Dataset blue) {
		super(ISIZE, red.getShapeRef());
		red.checkCompatibility(green);
		red.checkCompatibility(blue);

		if (red.max().doubleValue() > MAX_VALUE || red.min().doubleValue() < MIN_VALUE ||
				green.max().doubleValue() > MAX_VALUE || green.min().doubleValue() < MIN_VALUE || 
				blue.max().doubleValue() > MAX_VALUE || blue.min().doubleValue() < MIN_VALUE) {
			logger.warn("Some values are out of range and will be truncated");
		}

		IndexIterator riter = red.getIterator();
		IndexIterator giter = green.getIterator();
		IndexIterator biter = blue.getIterator();

		for (int i = 0; riter.hasNext() && giter.hasNext() && biter.hasNext();) {
			data[i++] = (byte) red.getElementLongAbs(riter.index);
			data[i++] = (byte) green.getElementLongAbs(giter.index);
			data[i++] = (byte) blue.getElementLongAbs(biter.index);
		}
	}

	/**
	 * Create a dataset using given grey data
	 * @param grey dataset
	 */
	public RGBByteDataset(final Dataset grey) {
		super(ISIZE, grey.getShapeRef());

		IndexIterator giter = grey.getIterator();

		for (int i = 0; giter.hasNext();) {
			final byte g = (byte) grey.getElementLongAbs(giter.index); 
			data[i++] = g;
			data[i++] = g;
			data[i++] = g;
		}
	}

	/**
	 * Create a dataset using given compound data
	 * @param colour dataset with colour data
	 */
	public RGBByteDataset(final CompoundDataset colour) {
		super(ISIZE, colour.getShapeRef());

		if (colour.getElementsPerItem() != 3) {
			throw new IllegalArgumentException("Compound dataset must have three elements per item");
		}

		final IndexIterator it = colour.getIterator();
		for (int i = 0; it.hasNext();) {
			data[i++] = (byte) colour.getElementLongAbs(it.index);
			data[i++] = (byte) colour.getElementLongAbs(it.index + 1);
			data[i++] = (byte) colour.getElementLongAbs(it.index + 2);
		}
	}

	/**
	 * Create a RGB dataset from an object which could be a Java list, array (of arrays...) or Number. Ragged
	 * sequences or arrays are padded with zeros. The item size is the last dimension of the corresponding
	 * elemental dataset
	 *
	 * @param obj object
	 * @return dataset with contents given by input
	 */
	public static RGBByteDataset createFromObject(final Object obj) {
		CompoundByteDataset result = (CompoundByteDataset) DatasetUtils.createCompoundDataset(ByteDataset.createFromObject(obj), ISIZE);
		return new RGBByteDataset(result.data, result.shape);
	}

	/**
	 * Create a RGB dataset from a compound dataset (no normalisation performed)
	 * @param a dataset
	 * @return RGB dataset (grey if input dataset has less than 3 elements per item)
	 */
	public static RGBByteDataset createFromCompoundDataset(final CompoundDataset a) {
		if (a instanceof RGBByteDataset)
			return (RGBByteDataset) a;
		final int is = a.getElementsPerItem();
		if (is < 3) {
			return new RGBByteDataset((Dataset) a);
		}

		if (a instanceof CompoundByteDataset && is == 3) {
			return new RGBByteDataset((byte[]) a.getBuffer(), a.getShapeRef());
		}

		final RGBByteDataset rgb = new RGBByteDataset(a.getShapeRef());
		final IndexIterator it = a.getIterator();

		int n = 0;
		while (it.hasNext()) {
			rgb.data[n++] = (byte) a.getElementLongAbs(it.index);
			rgb.data[n++] = (byte) a.getElementLongAbs(it.index + 1);
			rgb.data[n++] = (byte) a.getElementLongAbs(it.index + 2);
		}

		return rgb;
	}

	/**
	 * Create a RGB dataset from hue, saturation and value dataset
	 * @param hue (in degrees from -360 to 360)
	 * @param saturation (from 0 to 1), can be null to denote 1
	 * @param value (from 0 to 1)
	 * @return RGB dataset
	 */
	public static RGBByteDataset createFromHSV(final Dataset hue, final Dataset saturation, final Dataset value) {
		if ((saturation != null && !hue.isCompatibleWith(saturation)) || !hue.isCompatibleWith(value)) {
			throw new IllegalArgumentException("Hue, saturation and value datasets must have the same shape");
		}

		RGBByteDataset result = new RGBByteDataset(hue.getShapeRef());
		IndexIterator it = result.getIterator(true);
		int[] pos = it.getPos();
		byte[] rgb = new byte[3];

		if (saturation == null) {
			while (it.hasNext()) {
				convertHSVToRGB(hue.getDouble(pos), 1, value.getDouble(pos), rgb);
				result.setAbs(it.index, rgb);
			}
		} else {
			while (it.hasNext()) {
				convertHSVToRGB(hue.getDouble(pos), saturation.getDouble(pos), value.getDouble(pos), rgb);
				result.setAbs(it.index, rgb);
			}
		}

		return result;
	}

	/**
	 * Create a RGB dataset from hue, saturation and lightness dataset
	 * @param hue (in degrees from -360 to 360)
	 * @param saturation (from 0 to 1), can be null to denote 1
	 * @param lightness (from 0 to 1)
	 * @return RGB dataset
	 */
	public static RGBByteDataset createFromHSL(final Dataset hue, final Dataset saturation, final Dataset lightness) {
		if ((saturation != null && !hue.isCompatibleWith(saturation)) || !hue.isCompatibleWith(lightness)) {
			throw new IllegalArgumentException("Hue, saturation and lightness datasets must have the same shape");
		}

		RGBByteDataset result = new RGBByteDataset(hue.getShapeRef());
		IndexIterator it = result.getIterator(true);
		int[] pos = it.getPos();
		byte[] rgb = new byte[3];

		if (saturation == null) {
			while (it.hasNext()) {
				convertHSLToRGB(hue.getDouble(pos), 1, lightness.getDouble(pos), rgb);
				result.setAbs(it.index, rgb);
			}
		} else {
			while (it.hasNext()) {
				convertHSLToRGB(hue.getDouble(pos), saturation.getDouble(pos), lightness.getDouble(pos), rgb);
				result.setAbs(it.index, rgb);
			}
		}

		return result;
	}

	private static void convertHSVToRGB(double h, double s, double v, byte[] rgb) {
		double m = 255 * v;
		double chroma = s * m;
		m -= chroma;
		double hprime = h / 60.;
		if (hprime < 0) {
			hprime += 6;
		}
		byte sx = (byte) (chroma * (1 - Math.abs((hprime % 2) - 1)) + m);
		byte sc = (byte) (chroma + m);
		byte sm = (byte) m;
		
		if (hprime < 1) {
			rgb[0] = sc;
			rgb[1] = sx;
			rgb[2] = sm;
		} else if (hprime < 2) {
			rgb[0] = sx;
			rgb[1] = sc;
			rgb[2] = sm;
		} else if (hprime < 3) {
			rgb[0] = sm;
			rgb[1] = sc;
			rgb[2] = sx;
		} else if (hprime < 4) {
			rgb[0] = sm;
			rgb[1] = sx;
			rgb[2] = sc;
		} else if (hprime < 5) {
			rgb[0] = sx;
			rgb[1] = sm;
			rgb[2] = sc;
		} else if (hprime < 6) {
			rgb[0] = sc;
			rgb[1] = sm;
			rgb[2] = sx;
		} else { // if hue is outside domain
			rgb[0] = sm;
			rgb[1] = sm;
			rgb[2] = sm;
		}
	}

	private static void convertHSLToRGB(double h, double s, double l, byte[] rgb) {
		double m = l;
		double chroma = s * (1 - Math.abs(2 * m - 1));
		m -= chroma * 0.5;
		m *= 255;
		chroma *= 255;
		double hprime = h / 60.;
		if (hprime < 0) {
			hprime += 6;
		}
		byte sx = (byte) (chroma * (1 - Math.abs((hprime % 2) - 1)) + m);
		byte sc = (byte) (chroma + m);
		byte sm = (byte) m;
		
		if (hprime < 1) {
			rgb[0] = sc;
			rgb[1] = sx;
			rgb[2] = sm;
		} else if (hprime < 2) {
			rgb[0] = sx;
			rgb[1] = sc;
			rgb[2] = sm;
		} else if (hprime < 3) {
			rgb[0] = sm;
			rgb[1] = sc;
			rgb[2] = sx;
		} else if (hprime < 4) {
			rgb[0] = sm;
			rgb[1] = sx;
			rgb[2] = sc;
		} else if (hprime < 5) {
			rgb[0] = sx;
			rgb[1] = sm;
			rgb[2] = sc;
		} else if (hprime < 6) {
			rgb[0] = sc;
			rgb[1] = sm;
			rgb[2] = sx;
		} else { // if hue is outside domain
			rgb[0] = sm;
			rgb[1] = sm;
			rgb[2] = sm;
		}
	}

	@Override
	public RGBByteDataset getSlice(SliceIterator siter) {
		CompoundByteDataset base = super.getSlice(siter);

		RGBByteDataset slice = new RGBByteDataset();
		copyToView(base, slice, false, false);
		slice.setData();
		return slice;
	}

	@Override
	public RGBByteDataset getView(boolean deepCopyMetadata) {
		RGBByteDataset view = new RGBByteDataset();
		copyToView(this, view, true, deepCopyMetadata);
		view.setData();
		return view;
	}

	/**
	 * @return red value in the first position
	 */
	public byte getRed() {
		return data[getFirst1DIndex()];
	}

	/**
	 * @param i position in first dimension
	 * @return red value in given position
	 */
	public byte getRed(final int i) {
		return data[get1DIndex(i)];
	}

	/**
	 * @param i position in first dimension
	 * @param j position in second dimension
	 * @return red value in given position
	 */
	public byte getRed(final int i, final int j) {
		return data[get1DIndex(i, j)];
	}

	/**
	 * @param pos position
	 * @return red value in given position
	 */
	public byte getRed(final int... pos) {
		return data[get1DIndex(pos)];
	}

	/**
	 * @return green value in the first position
	 */
	public byte getGreen() {
		return data[getFirst1DIndex() + 1];
	}

	/**
	 * @param i position in first dimension
	 * @return green value in given position
	 */
	public byte getGreen(final int i) {
		return data[get1DIndex(i) + 1];
	}

	/**
	 * @param i position in first dimension
	 * @param j position in second dimension
	 * @return green value in given position
	 */
	public byte getGreen(final int i, final int j) {
		return data[get1DIndex(i, j) + 1];
	}

	/**
	 * @param pos position
	 * @return green value in given position
	 */
	public byte getGreen(final int... pos) {
		return data[get1DIndex(pos) + 1];
	}

	/**
	 * @return blue value in the first position
	 */
	public byte getBlue() {
		return data[getFirst1DIndex() + 2];
	}

	/**
	 * @param i position in first dimension
	 * @return blue value in given position
	 */
	public byte getBlue(final int i) {
		return data[get1DIndex(i) + 2];
	}

	/**
	 * @param i position in first dimension
	 * @param j position in second dimension
	 * @return blue value in given position
	 */
	public byte getBlue(final int i, final int j) {
		return data[get1DIndex(i, j) + 2];
	}

	/**
	 * @param pos position
	 * @return blue value in given position
	 */
	public byte getBlue(final int... pos) {
		return data[get1DIndex(pos) + 2];
	}

	/**
	 * Get a red value from given absolute index as a byte - note this index does not
	 * take in account the item size so be careful when using with multi-element items
	 * 
	 * @param n absolute index
	 * @return red value
	 */
	public byte getRedAbs(int n) {
		return data[n*isize];
	}

	/**
	 * Get a green value from given absolute index as a byte - note this index does not
	 * take in account the item size so be careful when using with multi-element items
	 * 
	 * @param n absolute index
	 * @return green value
	 */
	public byte getGreenAbs(int n) {
		return data[n*isize + 1];
	}

	/**
	 * Get a blue value from given absolute index as a byte - note this index does not
	 * take in account the item size so be careful when using with multi-element items
	 * 
	 * @param n absolute index
	 * @return blue value
	 */
	public byte getBlueAbs(int n) {
		return data[n*isize + 2];
	}


	// weights from NTSC formula aka ITU-R BT.601 for mapping RGB to luma
	private static final double Wr = 0.299, Wg = 0.587, Wb = 0.114;

	/**
	 * Convert colour dataset to a grey-scale one using the NTSC formula, aka ITU-R BT.601, for RGB to luma mapping
	 * @param <T> dataset sub-interface
	 * @param clazz dataset sub-interface
	 * @return a grey-scale dataset of given type
	 */
	public <T extends Dataset> T createGreyDataset(final Class<T> clazz) {
		return createGreyDataset(clazz, Wr, Wg, Wb);
	}

	/**
	 * Convert colour dataset to a grey-scale one using given RGB to luma mapping
	 * @param <T> dataset sub-interface
	 * @param clazz dataset sub-interface
	 * @param red weight
	 * @param green weight
	 * @param blue weight
	 * @return a grey-scale dataset of given class
	 */
	public <T extends Dataset> T createGreyDataset(final Class<T> clazz, final double red, final double green, final double blue) {
		final T grey = DatasetFactory.zeros(clazz, shape);
		final IndexIterator it = getIterator();

		int i = 0;
		while (it.hasNext()) {
			grey.setObjectAbs(i++, red*Byte.toUnsignedInt(data[it.index]) + green*Byte.toUnsignedInt(data[it.index + 1]) + blue*Byte.toUnsignedInt(data[it.index + 2]));
		}
		return grey;
	}

	/**
	 * Convert colour dataset to a grey-scale one using the NTSC formula, aka ITU-R BT.601, for RGB to luma mapping
	 * @param dtype dataset type
	 * @return a grey-scale dataset of given class
	 * @deprecated Use {@link RGBByteDataset#createGreyDataset(Class)}
	 */
	@Deprecated
	public Dataset createGreyDataset(final int dtype) {
		return createGreyDataset(Wr, Wg, Wb, dtype);
	}

	/**
	 * Convert colour dataset to a grey-scale one using given RGB to luma mapping
	 * @param red weight
	 * @param green weight
	 * @param blue weight
	 * @param dtype dataset type
	 * @return a grey-scale dataset of given type
	 * @deprecated Use {@link RGBByteDataset#createGreyDataset(Class, double, double, double)}
	 */
	@Deprecated
	public Dataset createGreyDataset(final double red, final double green, final double blue, final int dtype) {
		return createGreyDataset(DTypeUtils.getInterface(dtype), red, green, blue);
	}

	/**
	 * Extract red colour channel
	 * @param <T> dataset sub-interface
	 * @param clazz dataset sub-interface
	 * @return a dataset of given class
	 */
	public <T extends Dataset> T createRedDataset(final Class<T> clazz) {
		return createColourChannelDataset(0, clazz, "red");
	}

	/**
	 * Extract green colour channel
	 * @param <T> dataset sub-interface
	 * @param clazz dataset sub-interface
	 * @return a dataset of given class
	 */
	public <T extends Dataset> T createGreenDataset(final Class<T> clazz) {
		return createColourChannelDataset(1, clazz, "green");
	}

	/**
	 * Extract blue colour channel
	 * @param <T> dataset sub-interface
	 * @param clazz dataset sub-interface
	 * @return a dataset of given class
	 */
	public <T extends Dataset> T createBlueDataset(final Class<T> clazz) {
		return createColourChannelDataset(2, clazz, "blue");
	}

	/**
	 * Extract red colour channel
	 * @param dtype dataset type
	 * @return a dataset of given type
	 * @deprecated Use {@link #createRedDataset}
	 */
	@Deprecated
	public Dataset createRedDataset(final int dtype) {
		return createColourChannelDataset(0, DTypeUtils.getInterface(dtype), "red");
	}

	/**
	 * Extract green colour channel
	 * @param dtype dataset type
	 * @return a dataset of given type
	 * @deprecated Use {@link #createGreenDataset}
	 */
	@Deprecated
	public Dataset createGreenDataset(final int dtype) {
		return createColourChannelDataset(1, DTypeUtils.getInterface(dtype), "green");
	}

	/**
	 * Extract blue colour channel
	 * @param dtype dataset type
	 * @return a dataset of given type
	 * @deprecated Use {@link #createBlueDataset}
	 */
	@Deprecated
	public Dataset createBlueDataset(final int dtype) {
		return createColourChannelDataset(2, DTypeUtils.getInterface(dtype), "blue");
	}

	private <T extends Dataset> T createColourChannelDataset(int channelOffset, Class<T> clazz, String cName) {
		final T channel = DatasetFactory.zeros(clazz, shape);

		final StringBuilder cname = name == null ? new StringBuilder() : new StringBuilder(name);
		if (cname.length() > 0) {
			cname.append('.');
		}
		cname.append(cName);
		channel.setName(cname.toString());

		final IndexIterator it = getIterator();

		int i = 0;
		while (it.hasNext()) {
			channel.setObjectAbs(i++, Byte.toUnsignedInt(data[it.index + channelOffset]));
		}

		return channel;
	}


	/**
	 * @return red view
	 */
	public ByteDataset getRedView() {
		return getColourChannelView(0, "red");
	}

	/**
	 * @return green view
	 */
	public ByteDataset getGreenView() {
		return getColourChannelView(1, "green");
	}

	/**
	 * @return blue view
	 */
	public ByteDataset getBlueView() {
		return getColourChannelView(2, "blue");
	}

	private ByteDataset getColourChannelView(final int channelOffset, final String cName) {
		ByteDataset view = getElements(channelOffset);
		view.setName(cName);
		return view;
	}

	@Override
	public double getElementDoubleAbs(final int index) {
		return Byte.toUnsignedInt(data[index]);
	}

	@Override
	public long getElementLongAbs(final int index) {
		return Byte.toUnsignedInt(data[index]);
	}

	@Override
	public Number max(boolean... ignored) {
		int max = 0;
		final IndexIterator it = getIterator();

		while (it.hasNext()) {
			for (int i = 0; i < ISIZE; i++) {
				int value = Byte.toUnsignedInt(data[it.index + i]);
				if (value > max)
					max = value;
			}
		}
		return max;
	}

	@Override
	public Number min(boolean... ignored) {
		int min = MAX_VALUE;
		final IndexIterator it = getIterator();

		while (it.hasNext()) {
			for (int i = 0; i < ISIZE; i++) {
				int value = Byte.toUnsignedInt(data[it.index + i]);
				if (value < min)
					min = value;
			}
		}
		return min;
	}
}
