/*-
 * Copyright 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;
import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.dataset.Outliers;
import org.eclipse.january.dataset.Random;
import org.junit.Before;
import org.junit.Test;

public class OutlierCorrectnessTest {

	Dataset dataNormal;
	Dataset dataOneToFour;
	Dataset data11;
	
	@Before
	public void setUp() throws Exception {
		Random.seed(2468);
		dataNormal = Random.randn(1.0,  1.0, new int[]{6});
		dataNormal.sort(null);
		dataOneToFour = DatasetFactory.createFromList(Arrays.asList(ArrayUtils.toObject(new double[]{1, 2, 3, 4})));
		System.out.println("Normal data " + dataNormal.toString(true));
		System.out.println("data 1-4 " + dataOneToFour.toString(true));
	}

	@Test
	public void testSnNaive1() {
		double sn124 = Outliers.snNaive(dataOneToFour);
		System.out.println(sn124);
		assertEquals(1.1926, sn124, 1e-4);
	}
	@Test
	public void testSnNaive2() {
		double snNormal = Outliers.snNaive(dataNormal);
		System.out.println(snNormal);
		assertEquals(0.697354, snNormal, 1e-4);
	}
	
	@Test
	public void testSnFast1() {
		double sn124 = Outliers.snFast(dataOneToFour);
		System.out.println(sn124);
		assertEquals(1.1926, sn124, 1e-4);
	}
	@Test
	public void testSnFast2() {
		double snNormal = Outliers.snFast(dataNormal);
		System.out.println(snNormal);
		assertEquals(0.697354, snNormal, 1e-4);
	}
	

	@Test
	public void testArrayMedians() {
		double[] int11 = new double[] {1,2,3,4,5,6,7,8,9,10,11}; // lomed is 6
		double[] int11Mix = new double[] {4,8,2,6,3,5,1,10,7,11,9}; // lomed is 6
		double[] int12 = new double[] {1,2,3,4,5,6,7,8,9,10,11,12}; // lomed is 6
		double[] int12Mix = new double[] {12,10,4,8,7,1,2,9,6,3,11,5}; // lomed is 6
		
		fastArrayMedian(int11);
		fastArrayMedian(int11Mix);
		fastArrayMedian(int12);
		fastArrayMedian(int12Mix);

		java.util.Random rando = new java.util.Random(56478329);
		double[] circleOData = rando.doubles(360).toArray();
		
		fastArrayMedian(circleOData);
		
	}

	private void fastArrayMedian(double[] data) {
		
		double[] sortedCopy = Arrays.copyOf(data, data.length);
		Arrays.sort(sortedCopy);
		double expected = sortedCopy[(int) Math.floor((data.length+1)/2)-1];
		
		for (int rightA = 0; rightA < data.length; rightA++) {
			double[] left = Arrays.copyOfRange(data, 0, rightA+1),
					right = Arrays.copyOfRange(data, rightA+1, data.length);
			Arrays.sort(left);
			Arrays.sort(right);
			
			double median = Outliers.medianOFTwoPrimitiveArrays(left, right);
			assertEquals("Expected median (lomed)", expected, median, 1e-15);
		}
		
	}
	
}
