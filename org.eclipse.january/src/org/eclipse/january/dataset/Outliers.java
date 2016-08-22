/*-
 * Copyright 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

/**
 * Estimators of the scale of a Dataset.
 * <p>
 * A class of static methods to produce estimations of the scale of variation within a Dataset.
 * The available estimators are:
 * <ul>
 * <li> Median Absolute Deviation </li>
 * <li> S<sub>n</sub> of Croux and Rousseeuw (1992).</li>
 * </ul> 
 * <p>
 * Croux, C. and P. J. Rousseeuw, "Time-efficient algorithms for two highly robust estimators of scale", Computational Statistics, Volume 1, eds. Y. Dodge and J.Whittaker, Physica-Verlag, Heidelberg, pp411--428 (1992).
 */
public class Outliers {

	private final static double MADSCALEFACTOR = 1.4826;
	private final static double SNSCALEFACTOR = 1.1926;
	
	/**
	 * Returns the Median Absolute Deviation (MAD) and the median. 
	 * @param data
	 * 			The data for which the median and the MAD are to be calculated
	 * @return A two-element array of doubles, consisting of the MAD and the median of the data
	 */
	public static double[] medianAbsoluteDeviation(Dataset data) {
		
		double median = (Double)Stats.median(data);
		data = Maths.subtract(data, median);
		data = Maths.abs(data);
		double median2 = (Double)Stats.median(data);
		double mad = MADSCALEFACTOR * median2;
		
		return new double[]{mad, median};
	}
	
	/**
	 * Returns the Sn estimator of Croux and Rousseeuw.
	 * <p>
	 * This is the simple O(n²) version of the calculation algorithm.
	 * @param data
	 * 			The data for which the estimator is to be calculated.
	 * @return The value of the Sn estimator for the data
	 */
	public static double snNaive(Dataset data) {
		
		Dataset medAbs = DatasetFactory.zeros(data);
		Dataset dif = DatasetFactory.zeros(data);
		
		IndexIterator it = data.getIterator();
		int count = 0;
		while (it.hasNext()) {
			double val = data.getElementDoubleAbs(it.index);
			Maths.subtract(data, val, dif);
			Maths.abs(dif,dif);
			//Lower median - Math.floor((n/2)+1) of sorted
			dif.sort(null);
			medAbs.setObjectAbs(count++, lowMed(dif));
		}
		
		
		//Higher median - Math.floor((n+1)/2) of sorted
		medAbs.sort(null);
		double median = highMed(medAbs);
		
		return median * SNSCALEFACTOR;
	}
	
	/**
	 * Returns the Sn estimator of Croux and Rousseeuw.
	 * <p>
	 * This is the complex O(nlog n) version of the calculation algorithm.
	 * @param data
	 * 			The data for which the estimator is to be calculated.
	 * @return The value of the Sn estimator for the data
	 */
	public static double snFast(Dataset data) {
		
		Dataset sorted = data.clone();
		sorted.sort(null);
		
		Dataset medAbs = DatasetFactory.zeros(data);
		
		IndexIterator it = data.getIterator();
		int count = 0;
		while (it.hasNext()) {
			MedianOfTwoSortedSets snuff = new MedianForSn(sorted, it.index);
			medAbs.setObjectAbs(count++, snuff.get());
		}
		
		
		//Higher median - Math.floor((n+1)/2) of sorted
		medAbs.sort(null);
		double median = highMed(medAbs);
		
		return median * SNSCALEFACTOR;
	}
	
	/**
	 * Returns the lomed
	 * <p>
	 * Returns the lomed (low median) of a sorted Dataset.
	 * @param data
	 * 			A sorted Dataset for which the low median is to be calculated.  
	 * @return
	 * 		The value of the lomed of the data
	 */
	public static double lowMed(Dataset data) {
		return data.getElementDoubleAbs((int)Math.floor((data.getSize()/2)));
	}
	
	/**
	 * Returns the himed
	 * <p>
	 * Returns the himed (high median) of a sorted Dataset.
	 * @param data
	 * 			A sorted Dataset for which the low median is to be calculated.  
	 * @return
	 * 		The value of the himed of the data
	 */
	public static double highMed(Dataset data) {
		return data.getElementDoubleAbs((int)Math.floor((data.getSize()+1)/2-1));
	}

	/**
	 * Calculates the overall median of two double arrays
	 * @param a
	 * @param b
	 * 			the two arrays for which the overall median is desired. 
	 * @return the overall median of the two arrays
	 */
	public static double medianOFTwoPrimitiveArrays (double[] a, double[] b) {
		MedianOfTwoArrays medio = new MedianOfTwoArrays(a, b);
		return medio.get();
	}
}

/**
 * Allows the calculation of the median of two arrays.
 * <p>
 * Subclasses must implement getA() and getB() to return the elements of A or B
 * at the given index. The length of a must be less than or equal to that of b.
 * The constructor must set the sizes nA and nB.
 */
abstract class MedianOfTwoSortedSets{
	int nB, nA, diff, diffLeft;
	
	public final double get() {
		// Initialize the left and right markers for the set of candidate 
		// values. These are inclusive on both left and right.
		int leftA = 0, leftB = 0;
		@SuppressWarnings("unused") // keep rightA for symmetry
		int rightA = nB-1, rightB = nB-1;
		
		while (nB > 1) {
			// For 0-based indexing, the lomed is the element at floor((n+1)/2)-1
			int medianIndex = (int) Math.floor((nB+1)/2)-1;
			int medianAIndex = leftA + medianIndex,
					medianBIndex = leftB + medianIndex;
			double medA = getAm(medianAIndex),
					medB = getBm(medianBIndex);

			int smallerShift = 0;
			if (nB % 2 == 0) {
				// N even: the smaller lomed, as well as anything smaller than it, cannot be the overall median
				smallerShift = +1;
			}
			
			if (medA >= medB) {
				rightA = medianAIndex;
				leftB = medianBIndex + smallerShift;
			} else {
				rightB = medianBIndex;
				leftA = medianAIndex + smallerShift;
			}
			
			// Different lengths
			// It should be floor((l_m-1 + 1)/2))
			// this is newLength, defined above
			// Difference between left and right
			nB = rightB - leftB + 1;
		}

		// when the array is length 1, right and left will be the same.
		// The lomed of a two element array is the smaller of the two
		return Math.min(getAm(leftA), getBm(leftB));
	}
	
	// Get the value in the expanded array
	private double getAm(int i) {
		int firstElement = diffLeft,
				lastElement = diffLeft + nA - 1;
		if (i < firstElement) {
			return Double.NEGATIVE_INFINITY;
		} else if (i > lastElement) {
			return Double.POSITIVE_INFINITY;
		} else {
			return getA(i - diffLeft);
		}
	}
	
	private double getBm(int i) {
		return getB(i);
	}

	// Get the values in the original arrays
	protected abstract double getA(int i);	
	protected abstract double getB(int i);
	
	// Call this to set up the length difference variables. 
	protected void setDiffs() {
		diff = nB - nA;
		diffLeft = diff/2;
	}
}

class MedianOfTwoArrays extends MedianOfTwoSortedSets {

	double[] a, b;

	public MedianOfTwoArrays(double[] ain, double[] bin) {
		if (bin.length >= ain.length) {
			this.a = ain;
			nA = ain.length;
			this.b = bin;
			nB = bin.length;
		} else {
			this.a = bin;
			nA = bin.length;
			this.b = ain;
			nB = ain.length;
		}
		setDiffs();
	}
	@Override
	protected double getA(int i) {
		return a[i];
	}
	@Override
	protected double getB(int i) {
		return b[i];
	}
}

class MedianForSn extends MedianOfTwoSortedSets {
	Dataset xj;
	int referenceIndex;
	boolean lowerIsBigger;

	public MedianForSn(Dataset xj, int referenceIndex) {
		this.xj = xj;
		this.referenceIndex = referenceIndex;

		// determine which of the two halves of the array is larger
		int lowerSize = referenceIndex, upperSize = xj.getSize() - referenceIndex - 1;
		lowerIsBigger = lowerSize > upperSize;

		// Set the array sizes
		if (lowerIsBigger) {
			nA = upperSize;
			nB = lowerSize;
		} else {
			nA = lowerSize;
			nB = upperSize;
		}
		setDiffs();
	}

	@Override
	protected double getA(int i) {
		return (!lowerIsBigger) ? getLower(i) : getUpper(i);
	}
	@Override
	protected double getB(int i) {
		return (!lowerIsBigger) ? getUpper(i) : getLower(i);
	}
	
	private double getLower(int i) {
		return xj.getDouble(referenceIndex) - xj.getDouble(referenceIndex - 1 - i);
	}
	private double getUpper(int i) {
		return xj.getDouble(i + referenceIndex + 1) - xj.getDouble(referenceIndex);
	}
}
