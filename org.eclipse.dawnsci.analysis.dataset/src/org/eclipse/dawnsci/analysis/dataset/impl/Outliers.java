/*-
 * Copyright 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.dataset.impl;

public class Outliers {

	private final static double MADSCALEFACTOR = 1.4826;
	private final static double SNSCALEFACTOR = 1.1926;
	
	public static double[] medianAbsoluteDeviation(Dataset data) {
		
		double median = (Double)Stats.median(data);
		data = Maths.subtract(data, median);
		data = Maths.abs(data);
		double median2 = (Double)Stats.median(data);
		double mad = MADSCALEFACTOR * median2;
		
		return new double[]{mad, median};
	}
	
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
	
	public static double lowMed(Dataset data) {
		return data.getElementDoubleAbs((int)Math.floor((data.getSize()/2)));
	}
	
	public static double highMed(Dataset data) {
		return data.getElementDoubleAbs((int)Math.floor((data.getSize()+1)/2-1));
	}
	
	
}
