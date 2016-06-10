/*-
 * Copyright (c) 2012 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.dataset;

import org.eclipse.dawnsci.analysis.dataset.impl.Dataset;
import org.eclipse.dawnsci.analysis.dataset.impl.DatasetFactory;
import org.eclipse.dawnsci.analysis.dataset.impl.LazyMaths;
import org.eclipse.dawnsci.analysis.dataset.impl.Maths;
import org.junit.Test;

public class LazyMathsTest {

	@Test
	public void testSum() throws Exception {
		Dataset a = DatasetFactory.createRange(100, Dataset.FLOAT64);

		AbstractDatasetTest.checkDatasets(a.sum(0), LazyMaths.sum(a, 0), 1e-9, 1e-15);

		a.setShape(10, 10);
		AbstractDatasetTest.checkDatasets(a.sum(0), LazyMaths.sum(a, 0), 1e-9, 1e-15);
		AbstractDatasetTest.checkDatasets(a.sum(1), LazyMaths.sum(a, 1), 1e-9, 1e-15);

		a.setShape(4, 5, 5);
		AbstractDatasetTest.checkDatasets(a.sum(0), LazyMaths.sum(a, 0), 1e-9, 1e-15);
		AbstractDatasetTest.checkDatasets(a.sum(1), LazyMaths.sum(a, 1), 1e-9, 1e-15);
		AbstractDatasetTest.checkDatasets(a.sum(2), LazyMaths.sum(a, 2), 1e-9, 1e-15);

		a.setShape(4, 5, 1, 5);
		AbstractDatasetTest.checkDatasets(a.sum(0), LazyMaths.sum(a, 0), 1e-9, 1e-15);
		AbstractDatasetTest.checkDatasets(a.sum(1), LazyMaths.sum(a, 1), 1e-9, 1e-15);
		AbstractDatasetTest.checkDatasets(a.sum(2), LazyMaths.sum(a, 2), 1e-9, 1e-15);
		AbstractDatasetTest.checkDatasets(a.sum(3), LazyMaths.sum(a, 3), 1e-9, 1e-15);
	}

	@Test
	public void testProduct() throws Exception {
		Dataset a = DatasetFactory.createRange(100, Dataset.FLOAT64);
		a.iadd(1.);
		a.idivide(100.);

		AbstractDatasetTest.checkDatasets(a.product(0), LazyMaths.product(a, 0), 1e-9, 1e-15);

		a.setShape(10, 10);
		AbstractDatasetTest.checkDatasets(a.product(0), LazyMaths.product(a, 0), 1e-9, 1e-15);
		AbstractDatasetTest.checkDatasets(a.product(1), LazyMaths.product(a, 1), 1e-9, 1e-15);

		a.setShape(4, 5, 5);
		AbstractDatasetTest.checkDatasets(a.product(0), LazyMaths.product(a, 0), 1e-9, 1e-15);
		AbstractDatasetTest.checkDatasets(a.product(1), LazyMaths.product(a, 1), 1e-9, 1e-15);
		AbstractDatasetTest.checkDatasets(a.product(2), LazyMaths.product(a, 2), 1e-9, 1e-15);

		a.setShape(4, 5, 1, 5);
		AbstractDatasetTest.checkDatasets(a.product(0), LazyMaths.product(a, 0), 1e-9, 1e-15);
		AbstractDatasetTest.checkDatasets(a.product(1), LazyMaths.product(a, 1), 1e-9, 1e-15);
		AbstractDatasetTest.checkDatasets(a.product(2), LazyMaths.product(a, 2), 1e-9, 1e-15);
		AbstractDatasetTest.checkDatasets(a.product(3), LazyMaths.product(a, 3), 1e-9, 1e-15);
	}
	
	@Test
	public void testMeanIgnore() throws Exception {

		Dataset a = DatasetFactory.createRange(100, Dataset.FLOAT64);
		a.setShape(10, 10);
		AbstractDatasetTest.checkDatasets(a.mean(1), LazyMaths.mean(a, 0), 1e-9, 1e-15);
		AbstractDatasetTest.checkDatasets(a.mean(0), LazyMaths.mean(a, 1), 1e-9, 1e-15);

		a.setShape(4, 5, 5);
		AbstractDatasetTest.checkDatasets(a.mean(2).mean(1),LazyMaths.mean(a, 0), 1e-9, 1e-15);
		AbstractDatasetTest.checkDatasets(a.mean(2),LazyMaths.mean(a, 0,1), 1e-9, 1e-15);
		AbstractDatasetTest.checkDatasets(a.mean(0),LazyMaths.mean(a, 1,2), 1e-9, 1e-15);

		a.setShape(4, 5, 1, 5);
		AbstractDatasetTest.checkDatasets(a.mean(3).mean(2),LazyMaths.mean(a, 0,1), 1e-9, 1e-15);
		AbstractDatasetTest.checkDatasets(a.mean(3).mean(2).mean(1),LazyMaths.mean(a, 0), 1e-9, 1e-15);
		AbstractDatasetTest.checkDatasets(a.mean(3).squeeze(),LazyMaths.mean(a, 0,1,2), 1e-9, 1e-15);
		AbstractDatasetTest.checkDatasets(a.mean(0).mean(0).squeeze(),LazyMaths.mean(a, 2,3), 1e-9, 1e-15);
		
		Dataset er = DatasetFactory.createRange(100, Dataset.FLOAT64);
		a.setShape(10, 10);
		er.setShape(10, 10);
		a.setErrorBuffer(er);

		Dataset e = Maths.sqrt(er.sum(1)).idivide(10);

		AbstractDatasetTest.checkDatasets(e, LazyMaths.mean(a, 0).getError(), 1e-9, 1e-15);

	}
}
