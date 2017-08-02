/*-
 * Copyright (c) 2012, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import static org.junit.Assert.assertEquals;

import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.dataset.InterpolatorUtils;
import org.eclipse.january.dataset.Maths;
import org.junit.Test;

public class InterpolatorUtilsTest {

	@Test
	public void test() {
		Dataset im = DatasetFactory.createRange(FloatDataset.class, 0.0,10000.0,1.0);
		im = im.reshape(100,100);
		Dataset off = Maths.sin(DatasetFactory.createRange(FloatDataset.class, 0.0, 10.0, 0.1));
		Dataset axis = DatasetFactory.createRange(FloatDataset.class, -5.0, 5.0, 0.1);
		
		Dataset newaxis = DatasetFactory.createRange(FloatDataset.class, -10.0, 10.0, 0.1);
		
		Dataset output = InterpolatorUtils.remapOneAxis(im, 0, off, axis, newaxis);
		
		// check that some values are correct
		assertEquals("Coordinate incorrect", 1468.249, output.getDouble(62,29), 0.1);
		assertEquals("Coordinate incorrect", 7124.733, output.getDouble(127,56), 0.1);
		assertEquals("Coordinate incorrect", Double.NaN, output.getDouble(179,33), 0.1);
		assertEquals("Coordinate incorrect", 9600.669, output.getDouble(144,2), 0.1);
		assertEquals("Coordinate incorrect", 379.814, output.getDouble(53,63), 0.1);
		assertEquals("Coordinate incorrect", 225.239, output.getDouble(54,97), 0.1);
		assertEquals("Coordinate incorrect", 7118.775, output.getDouble(120,94), 0.1);
	}
	

}
