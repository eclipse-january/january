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

/**
 * Class to hold colour datasets as red, green, blue tuples of short integers
 */
public class RGBDataset extends CompoundShortDataset implements Cloneable {
	// pin UID to base class
	private static final long serialVersionUID = Dataset.serialVersionUID;

	private static final int ISIZE = 3; // number of elements per item

	@Override
	public int getDtype() {
		return Dataset.RGB;
	}

	public RGBDataset() {
		super(ISIZE);
	}

	public RGBDataset(final int... shape) {
		super(ISIZE, shape);
	}

	/**
	 * Copy a dataset
	 * @param dataset
	 */
	public RGBDataset(final RGBDataset dataset) {
		super(dataset);
	}

	@Override
	public RGBDataset clone() {
		return new RGBDataset(this);
	}

	/**
	 * Create a dataset using given data (red, green and blue parts are given separately)
	 * @param redData
	 * @param greenData
	 * @param blueData
	 * @param shape (can be null to create 1D dataset)
	 */
	public RGBDataset(final int[] redData, final int[] greenData, final int[] blueData, int... shape) {
		int dsize = redData.length > greenData.length ? greenData.length : redData.length;
		dsize = dsize > blueData.length ? blueData.length : dsize;
		if (shape == null || shape.length == 0) {
			shape = new int[] {dsize};
		}
		isize = ISIZE;
		size = calcSize(shape);
		if (size != dsize) {
			logger.error("Shape is not compatible with size of data array");
			throw new IllegalArgumentException("Shape is not compatible with size of data array");
		}
		this.shape = shape.clone();

		odata = data = createArray(size);

		for (int i = 0, n = 0; i < size; i++) {
			data[n++] = (short) redData[i];
			data[n++] = (short) greenData[i];
			data[n++] = (short) blueData[i];
		}
	}

	/**
	 * Create a dataset using given data (red, green and blue parts are given separately)
	 * @param redData
	 * @param greenData
	 * @param blueData
	 * @param shape (can be null to create 1D dataset)
	 */
	public RGBDataset(final short[] redData, final short[] greenData, final short[] blueData, int... shape) {
		int dsize = redData.length > greenData.length ? greenData.length : redData.length;
		dsize = dsize > blueData.length ? blueData.length : dsize;
		if (shape == null || shape.length == 0) {
			shape = new int[] {dsize};
		}
		isize = ISIZE;
		size = calcSize(shape);
		if (size != dsize) {
			logger.error("Shape is not compatible with size of data array");
			throw new IllegalArgumentException("Shape is not compatible with size of data array");
		}
		this.shape = shape.clone();

		odata = data = createArray(size);

		for (int i = 0, n = 0; i < size; i++) {
			data[n++] = redData[i];
			data[n++] = greenData[i];
			data[n++] = blueData[i];
		}
	}

	/**
	 * Create a dataset using given data (red, green and blue parts are given separately)
	 * @param redData
	 * @param greenData
	 * @param blueData
	 * @param shape (can be null to create 1D dataset)
	 */
	public RGBDataset(final byte[] redData, final byte[] greenData, final byte[] blueData, int... shape) {
		int dsize = redData.length > greenData.length ? greenData.length : redData.length;
		dsize = dsize > blueData.length ? blueData.length : dsize;
		if (shape == null || shape.length == 0) {
			shape = new int[] {dsize};
		}
		isize = ISIZE;
		size = calcSize(shape);
		if (size != dsize) {
			logger.error("Shape is not compatible with size of data array");
			throw new IllegalArgumentException("Shape is not compatible with size of data array");
		}
		this.shape = shape.clone();

		odata = data = createArray(size);

		for (int i = 0, n = 0; i < size; i++) {
			data[n++] = (short) (0xff & redData[i]);
			data[n++] = (short) (0xff & greenData[i]);
			data[n++] = (short) (0xff & blueData[i]);
		}
	}

	/**
	 * Create a dataset using given colour data (colour components are given separately)
	 * @param red
	 * @param green
	 * @param blue
	 */
	public RGBDataset(final Dataset red, final Dataset green, final Dataset blue) {
		super(ISIZE, red.getShapeRef());
		red.checkCompatibility(green);
		red.checkCompatibility(blue);

		if (red.max().doubleValue() > Short.MAX_VALUE || red.min().doubleValue() < Short.MIN_VALUE ||
				green.max().doubleValue() > Short.MAX_VALUE || green.min().doubleValue() < Short.MIN_VALUE || 
				blue.max().doubleValue() > Short.MAX_VALUE || blue.min().doubleValue() < Short.MIN_VALUE) {
			logger.warn("Some values are out of range and will be ");
		}

		IndexIterator riter = red.getIterator();
		IndexIterator giter = green.getIterator();
		IndexIterator biter = blue.getIterator();

		for (int i = 0; riter.hasNext() && giter.hasNext() && biter.hasNext();) {
			data[i++] = (short) red.getElementLongAbs(riter.index);
			data[i++] = (short) green.getElementLongAbs(riter.index);
			data[i++] = (short) blue.getElementLongAbs(riter.index);
		}
	}

	/**
	 * Create a dataset using given grey data
	 * @param grey
	 */
	public RGBDataset(final Dataset grey) {
		super(ISIZE, grey.getShapeRef());

		IndexIterator giter = grey.getIterator();

		for (int i = 0; giter.hasNext();) {
			final short g = (short) grey.getElementLongAbs(giter.index); 
			data[i++] = g;
			data[i++] = g;
			data[i++] = g;
		}
	}

	/**
	 * Create a RGB dataset from a compound dataset (no normalisation performed)
	 * @param a
	 * @return RGB dataset (grey if input dataset has less than 3 elements per item)
	 */
	public static RGBDataset createFromCompoundDataset(final CompoundDataset a) {
		if (a instanceof RGBDataset)
			return (RGBDataset) a;
		final int is = a.getElementsPerItem();
		if (is < 3) {
			return new RGBDataset(a);
		}
		final RGBDataset rgb = new RGBDataset(a.getShapeRef());
		final IndexIterator it = a.getIterator();

		int n = 0;
		while (it.hasNext()) {
			rgb.data[n++] = (short) a.getElementLongAbs(it.index);
			rgb.data[n++] = (short) a.getElementLongAbs(it.index + 1);
			rgb.data[n++] = (short) a.getElementLongAbs(it.index + 2);
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
	public static RGBDataset createFromHSV(final Dataset hue, final Dataset saturation, final Dataset value) {
		if ((saturation != null && !hue.isCompatibleWith(saturation)) || !hue.isCompatibleWith(value)) {
			throw new IllegalArgumentException("Hue, saturation and value datasets must have the same shape");
		}

		RGBDataset result = new RGBDataset(hue.getShapeRef());
		IndexIterator it = result.getIterator(true);
		int[] pos = it.getPos();
		short[] rgb = new short[3];

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
	public static RGBDataset createFromHSL(final Dataset hue, final Dataset saturation, final Dataset lightness) {
		if ((saturation != null && !hue.isCompatibleWith(saturation)) || !hue.isCompatibleWith(lightness)) {
			throw new IllegalArgumentException("Hue, saturation and lightness datasets must have the same shape");
		}

		RGBDataset result = new RGBDataset(hue.getShapeRef());
		IndexIterator it = result.getIterator(true);
		int[] pos = it.getPos();
		short[] rgb = new short[3];

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

	private static void convertHSVToRGB(double h, double s, double v, short[] rgb) {
		double m = 255 * v;
		double chroma = s * m;
		m -= chroma;
		double hprime = h / 60.;
		if (hprime < 0) {
			hprime += 6;
		}
		short sx = (short) (chroma * (1 - Math.abs((hprime % 2) - 1)) + m);
		short sc = (short) (chroma + m);
		short sm = (short) m;
		
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

	private static void convertHSLToRGB(double h, double s, double l, short[] rgb) {
		double m = l;
		double chroma = s * (1 - Math.abs(2 * m - 1));
		m -= chroma * 0.5;
		m *= 255;
		chroma *= 255;
		double hprime = h / 60.;
		if (hprime < 0) {
			hprime += 6;
		}
		short sx = (short) (chroma * (1 - Math.abs((hprime % 2) - 1)) + m);
		short sc = (short) (chroma + m);
		short sm = (short) m;
		
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
	public RGBDataset getSlice(final int[] start, final int[] stop, final int[] step) {
		IndexIterator siter = getSliceIterator(start, stop, step);

		RGBDataset result = new RGBDataset(siter.getShape());
		short[] rdata = result.data;
		IndexIterator riter = result.getIterator();

		while (siter.hasNext() && riter.hasNext()) {
			for (int i = 0; i < isize; i++)
				rdata[riter.index + i] = data[siter.index + i];
		}

		return result;
	}

	@Override
	public RGBDataset getView() {
		RGBDataset view = new RGBDataset();
		view.name = new String(name);
		view.size = size;
		view.shape = shape.clone();
		view.odata = view.data = data;
		view.metadata = metadata;

		return view;
	}

	/**
	 * @param i
	 * @return red value in given position
	 */
	public short getRed(final int i) {
		return data[get1DIndex(i)];
	}

	/**
	 * @param i
	 * @param j
	 * @return red value in given position
	 */
	public short getRed(final int i, final int j) {
		return data[get1DIndex(i, j)];
	}

	/**
	 * @param pos
	 * @return red value in given position
	 */
	public short getRed(final int... pos) {
		return data[get1DIndex(pos)];
	}

	/**
	 * @param i
	 * @return green value in given position
	 */
	public short getGreen(final int i) {
		return data[get1DIndex(i) + 1];
	}

	/**
	 * @param i
	 * @param j
	 * @return green value in given position
	 */
	public short getGreen(final int i, final int j) {
		return data[get1DIndex(i, j) + 1];
	}

	/**
	 * @param pos
	 * @return green value in given position
	 */
	public short getGreen(final int... pos) {
		return data[get1DIndex(pos) + 1];
	}

	/**
	 * @param i
	 * @return blue value in given position
	 */
	public short getBlue(final int i) {
		return data[get1DIndex(i) + 2];
	}

	/**
	 * @param i
	 * @param j
	 * @return blue value in given position
	 */
	public short getBlue(final int i, final int j) {
		return data[get1DIndex(i, j) + 2];
	}

	/**
	 * @param pos
	 * @return blue value in given position
	 */
	public short getBlue(final int... pos) {
		return data[get1DIndex(pos) + 2];
	}

	/**
	 * Get a red value from given absolute index as a short - note this index does not
	 * take in account the item size so be careful when using with multi-element items
	 * 
	 * @param n
	 * @return red value
	 */
	public short getRedAbs(int n) {
		return data[n*isize];
	}

	/**
	 * Get a green value from given absolute index as a short - note this index does not
	 * take in account the item size so be careful when using with multi-element items
	 * 
	 * @param n
	 * @return green value
	 */
	public short getGreenAbs(int n) {
		return data[n*isize + 1];
	}

	/**
	 * Get a blue value from given absolute index as a short - note this index does not
	 * take in account the item size so be careful when using with multi-element items
	 * 
	 * @param n
	 * @return blue value
	 */
	public short getBlueAbs(int n) {
		return data[n*isize + 2];
	}


	// weights from NTSC formula aka ITU-R BT.601 for mapping RGB to luma
	private static final double Wr = 0.299, Wg = 0.587, Wb = 0.114;

	/**
	 * Convert colour dataset to a grey-scale one using the NTSC formula, aka ITU-R BT.601, for RGB to luma mapping
	 * @param dtype
	 * @return a grey-scale dataset of given type
	 */
	public Dataset createGreyDataset(final int dtype) {
		return createGreyDataset(Wr, Wg, Wb, dtype);
	}

	/**
	 * Convert colour dataset to a grey-scale one using given RGB to luma mapping
	 * @param red weight
	 * @param green weight
	 * @param blue weight
	 * @param dtype
	 * @return a grey-scale dataset of given type
	 */
	public Dataset createGreyDataset(final double red, final double green, final double blue, final int dtype) {
		final Dataset grey = DatasetFactory.zeros(shape, dtype);
		final IndexIterator it = getIterator();

		int i = 0;
		while (it.hasNext()) {
			grey.setObjectAbs(i++, red*data[it.index] + green*data[it.index + 1] + blue*data[it.index + 2]);
		}
		return grey;
	}

	/**
	 * Extract red colour channel
	 * @param dtype
	 * @return a dataset of given type
	 */
	public Dataset createRedDataset(final int dtype) {
		return createColourChannelDataset(0, dtype, "red");
	}

	/**
	 * Extract green colour channel
	 * @param dtype
	 * @return a dataset of given type
	 */
	public Dataset createGreenDataset(final int dtype) {
		return createColourChannelDataset(1, dtype, "green");
	}

	/**
	 * Extract blue colour channel
	 * @param dtype
	 * @return a dataset of given type
	 */
	public Dataset createBlueDataset(final int dtype) {
		return createColourChannelDataset(2, dtype, "blue");
	}

	private Dataset createColourChannelDataset(final int channelOffset, final int dtype, final String cName) {
		final Dataset channel = DatasetFactory.zeros(shape, dtype);

		final StringBuilder cname = name == null ? new StringBuilder() : new StringBuilder(name);
		if (cname.length() > 0) {
			cname.append('.');
		}
		cname.append(cName);
		channel.setName(cname.toString());

		final IndexIterator it = getIterator();

		int i = 0;
		while (it.hasNext()) {
			channel.setObjectAbs(i++, data[it.index + channelOffset]);
		}

		return channel;
	}

	/**
	 * @return red view
	 */
	public ShortDataset getRedView() {
		return getColourChannelView(0, "red");
	}

	/**
	 * @return green view
	 */
	public ShortDataset getGreenView() {
		return getColourChannelView(1, "green");
	}

	/**
	 * @return blue view
	 */
	public ShortDataset getBlueView() {
		return getColourChannelView(2, "blue");
	}

	private ShortDataset getColourChannelView(final int channelOffset, final String cName) {
		ShortDataset view = getElements(channelOffset);
		view.setName(cName);
		return view;
	}

	@Override
	public Number max(boolean... ignored) {
		short max = Short.MIN_VALUE;
		final IndexIterator it = getIterator();

		while (it.hasNext()) {
			for (int i = 0; i < ISIZE; i++) {
				final short value = data[it.index + i];
				if (value > max)
					max = value;
			}
		}
		return max;
	}

	@Override
	public Number min(boolean... ignored) {
		short max = Short.MAX_VALUE;
		final IndexIterator it = getIterator();

		while (it.hasNext()) {
			for (int i = 0; i < ISIZE; i++) {
				final short value = data[it.index + i];
				if (value < max)
					max = value;
			}
		}
		return max;
	}
}
