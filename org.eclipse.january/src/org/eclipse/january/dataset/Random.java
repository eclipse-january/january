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


import java.io.IOException;

import org.apache.commons.math3.random.MersenneTwister;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.eclipse.january.IMonitor;
import org.eclipse.january.io.ILazyLoader;

/**
 * Class to hold methods to create random datasets
 * 
 * Emulates numpy.random
 */
public class Random {
	private final static RandomGenerator generator = new MersenneTwister();
	private final static RandomDataGenerator prng = new RandomDataGenerator(generator);

	/**
	 * @param seed
	 */
	public static void seed(final int seed) {
		generator.setSeed(seed);
	}

	/**
	 * @param seed
	 */
	public static void seed(final int[] seed) {
		generator.setSeed(seed);
	}

	/**
	 * @param seed
	 */
	public static void seed(final long seed) {
		generator.setSeed(seed);
	}

	/**
	 * @param shape
	 * @return an array of values sampled from a uniform distribution between 0 (inclusive) and 1 (exclusive) 
	 */
	public static DoubleDataset rand(final int... shape) {
		DoubleDataset data = DatasetFactory.zeros(DoubleDataset.class, shape);
		double[] buf = data.getData();

		for (int i = 0; i < buf.length; i++) {
			buf[i] = generator.nextDouble();
		}

		return data;
	}

	/**
	 * @param low
	 * @param high
	 * @param shape
	 * @return an array of values sampled from a uniform distribution between low and high (both exclusive) 
	 */
	public static DoubleDataset rand(double low, double high, final int... shape) {
		DoubleDataset data = DatasetFactory.zeros(DoubleDataset.class, shape);
		double[] buf = data.getData();

		for (int i = 0; i < buf.length; i++) {
			buf[i] = prng.nextUniform(low, high);
		}

		return data;
	}

	/**
	 * @param shape
	 * @return an array of values sampled from a Gaussian distribution with mean 0 and variance 1 
	 * 
	 * (The term Gaussian here is a description of a shape of data taken from the mathematician of the
	 * same name Carl Friedrich Gauss  http://en.wikipedia.org/wiki/Carl_Friedrich_Gauss born in 1777.)
	 */
	public static DoubleDataset randn(final int... shape) {
		DoubleDataset data = DatasetFactory.zeros(DoubleDataset.class, shape);
		double[] buf = data.getData();

		for (int i = 0; i < buf.length; i++) {
			buf[i] = generator.nextGaussian();
		}

		return data;
	}

	/**
	 * @param mean
	 * @param std standard deviation
	 * @param shape
	 * @return an array of values sampled from a Gaussian distribution with given mean and standard deviation 
	 */
	public static DoubleDataset randn(double mean, double std, final int... shape) {
		DoubleDataset data = DatasetFactory.zeros(DoubleDataset.class, shape);
		double[] buf = data.getData();

		for (int i = 0; i < buf.length; i++) {
			buf[i] = prng.nextGaussian(mean, std);
		}

		return data;
	}

	/**
	 * @param low 
	 * @param high
	 * @param shape
	 * @return an array of values sampled from a discrete uniform distribution in range [low, high)
	 */
	public static IntegerDataset randint(final int low, final int high, final int[] shape) {
		return random_integers(low, high-1, shape);
	}

	/**
	 * @param low 
	 * @param high 
	 * @param shape
	 * @return an array of values sampled from a discrete uniform distribution in range [low, high]
	 */
	public static IntegerDataset random_integers(final int low, final int high, final int[] shape) {
		IntegerDataset data = DatasetFactory.zeros(IntegerDataset.class, shape);
		int[] buf = data.getData();

		if (low == high) {
			for (int i = 0; i < buf.length; i++) {
				buf[i] = low;
			}			
		} else {
			for (int i = 0; i < buf.length; i++) {
				buf[i] = prng.nextInt(low, high);
			}
		}

		return data;
	}

	/**
	 * @param beta 
	 * @param shape
	 * @return an array of values sampled from an exponential distribution with mean beta
	 */
	public static DoubleDataset exponential(final double beta, final int... shape) {
		DoubleDataset data = DatasetFactory.zeros(DoubleDataset.class, shape);
		double[] buf = data.getData();

		for (int i = 0; i < buf.length; i++) {
			buf[i] = prng.nextExponential(beta);
		}

		return data;
	}

	/**
	 * @param lam 
	 * @param shape
	 * @return an array of values sampled from an exponential distribution with mean lambda
	 */
	public static IntegerDataset poisson(final double lam, final int... shape) {
		IntegerDataset data = DatasetFactory.zeros(IntegerDataset.class, shape);
		int[] buf = data.getData();

		for (int i = 0; i < buf.length; i++) {
			buf[i] = (int) prng.nextPoisson(lam);
		}

		return data;
	}

	/**
	 * @param shape
	 * @return a lazy dataset with uniformly distributed random numbers
	 */
	public static ILazyDataset lazyRand(int... shape) {
		return lazyRand("random", DoubleDataset.class, shape);
	}

	/**
	 * @param name
	 * @param shape
	 * @return a lazy dataset with uniformly distributed random numbers
	 */
	public static ILazyDataset lazyRand(String name, int... shape) {
		return lazyRand(name, DoubleDataset.class, shape);
	}

	/**
	 * @param dtype
	 * @param name
	 * @param shape
	 * @return a lazy dataset with uniformly distributed random numbers
	 * @deprecated Use {@link #lazyRand(String, Class, int...)}
	 */
	@Deprecated
	public static ILazyDataset lazyRand(int dtype, String name, int... shape) {
		return lazyRand(name, DTypeUtils.getInterface(dtype), shape);
	}

	/**
	 * @param name
	 * @param clazz dataset interface
	 * @param shape
	 * @return a lazy dataset with uniformly distributed random numbers
	 * @since 2.3
	 */
	public static ILazyDataset lazyRand(String name, final Class<? extends Dataset> clazz, int... shape) {
		
		return new LazyDataset(new ILazyLoader() {
			private static final long serialVersionUID = ILazyLoader.serialVersionUID;

			@Override
			public boolean isFileReadable() {
				return true;
			}

			@Override
			public IDataset getDataset(IMonitor mon, SliceND slice) throws IOException {
				return rand(slice.getShape()).cast(clazz);
			}
		},
		name, clazz, shape);
	}
}
