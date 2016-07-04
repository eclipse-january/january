/*-
 * Copyright (c) 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.dataset.impl;

import java.util.HashMap;
import java.util.Map;

public class DTypeUtils {

	static final Map<Class<? extends Dataset>, Integer> class2DTypes = createInterfaceMap(); // map interface to dataset type

	private static Map<Class<? extends Dataset>, Integer> createInterfaceMap() {
		Map<Class<? extends Dataset>, Integer> map = new HashMap<Class<? extends Dataset>, Integer>();
		map.put(BooleanDataset.class, Dataset.BOOL);
		map.put(ByteDataset.class, Dataset.INT8);
		map.put(ShortDataset.class, Dataset.INT16);
		map.put(IntegerDataset.class, Dataset.INT32);
		map.put(LongDataset.class, Dataset.INT64);
		map.put(FloatDataset.class, Dataset.FLOAT32);
		map.put(DoubleDataset.class, Dataset.FLOAT64);
		map.put(CompoundByteDataset.class, Dataset.ARRAYINT8);
		map.put(CompoundShortDataset.class, Dataset.ARRAYINT16);
		map.put(CompoundIntegerDataset.class, Dataset.ARRAYINT32);
		map.put(CompoundLongDataset.class, Dataset.ARRAYINT64);
		map.put(CompoundFloatDataset.class, Dataset.ARRAYFLOAT32);
		map.put(CompoundDoubleDataset.class, Dataset.ARRAYFLOAT64);
		map.put(ComplexFloatDataset.class, Dataset.COMPLEX64);
		map.put(ComplexDoubleDataset.class, Dataset.COMPLEX128);
		map.put(ObjectDataset.class, Dataset.OBJECT);
		map.put(StringDataset.class, Dataset.STRING);
		map.put(RGBDataset.class, Dataset.RGB);
		return map;
	}

	/**
	 * @param clazz
	 * @return dataset type for dataset class 
	 */
	public static int getDType(Class<? extends Dataset> clazz) {
		if (!class2DTypes.containsKey(clazz)) {
			throw new IllegalArgumentException("Interface class not allowed or supported");
		}
		return class2DTypes.get(clazz);
	}
}
