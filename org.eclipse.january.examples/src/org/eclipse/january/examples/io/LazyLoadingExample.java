/*-
 * Copyright 2017 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.examples.io;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

import org.eclipse.january.DatasetException;
import org.eclipse.january.IMonitor;
import org.eclipse.january.dataset.AggregateDataset;
import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.dataset.DatasetUtils;
import org.eclipse.january.dataset.IDataset;
import org.eclipse.january.dataset.ILazyDataset;
import org.eclipse.january.dataset.LazyDataset;
import org.eclipse.january.dataset.Slice;
import org.eclipse.january.dataset.SliceND;
import org.eclipse.january.io.ILazyLoader;

/**
 * Demonstrate how to lazy load files
 */
public class LazyLoadingExample {

	/**
	 * Create a lazy dataset from a given file
	 * @param file
	 * @return lazy dataset or null if it is not a file that {@link ImageIO} can handle
	 * @throws IllegalArgumentException if file does not exist or cannot be read
	 */
	public static ILazyDataset createFromFile(final File file) {
		if (!file.canRead()) {
			throw new IllegalArgumentException("File '" + file + "' does not exist or is not readable");
		}
		try {
			BufferedImage image = ImageIO.read(file);

			Raster ras = image.getData();
			final int height = ras.getHeight();
			final int width = ras.getWidth();
			final int[] shape = new int[] {height, width};

			ILazyLoader loader = new ILazyLoader() {
				private static final long serialVersionUID = 8802943590647491871L;

				@Override
				public boolean isFileReadable() {
					return file.canRead();
				}

				@Override
				public IDataset getDataset(IMonitor mon, SliceND slice) throws IOException {
					BufferedImage image = ImageIO.read(file);

					Raster ras = image.getData();
					Dataset tmp = DatasetFactory.createFromObject(
							ras.getSamples(0, 0, width, height, 0, (int[]) null), height, width);
					return tmp.getSliceView(slice);
				}
			};
			LazyDataset lazy = new LazyDataset(file.getName(), Dataset.INT32, shape, loader);
			return lazy;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Create lazy dataset from a set of files in the given directory.
	 * <p>
	 * Any file that cannot be read or handled by {@link #createFromFile(File)} will be ignored
	 * <p>
	 * @param directory
	 * @return lazy dataset
	 */
	public static ILazyDataset createFromDirectory(String directory) {
		File d = new File(directory);
		if (!d.isDirectory()) {
			throw new IllegalArgumentException("Directory '" + d + "' does not exists or is not a directory");
		}

		List<ILazyDataset> lazies = new ArrayList<>();
		for (File f : d.listFiles()) {
			try {
				ILazyDataset l = createFromFile(f);
				if (l != null) {
					lazies.add(l);
				}
			} catch (IllegalArgumentException e) {
				// do nothing
			}
		}

		return new AggregateDataset(true, lazies.toArray(new ILazyDataset[0]));
	}

	public static void main(String[] args) throws IOException, DatasetException {
		String directory = "files";

		ILazyDataset allImages = createFromDirectory(directory);

		System.out.printf("Image stack has shape: %s\n", Arrays.toString(allImages.getShape()));

		// show central portion of first image
		Dataset zero = DatasetUtils.convertToDataset(allImages.getSlice(new Slice(1))).squeeze();
		System.out.println(zero.getSliceView(new Slice(22,42), new Slice(22,42)).toString(true));

		// show central rows of all images
		Dataset rows = DatasetUtils.convertToDataset(allImages.getSlice((Slice) null, new Slice(32,33), new Slice(12,52))).squeeze();
		System.out.println(rows.toString(true));
	}
}
