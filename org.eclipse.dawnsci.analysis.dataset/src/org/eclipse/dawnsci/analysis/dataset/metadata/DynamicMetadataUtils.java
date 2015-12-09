/*-
 * Copyright 2015 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.dataset.metadata;

import java.util.Arrays;
import java.util.List;

import org.eclipse.dawnsci.analysis.api.dataset.ILazyDataset;
import org.eclipse.dawnsci.analysis.api.metadata.AxesMetadata;
import org.eclipse.dawnsci.analysis.dataset.impl.LazyDynamicDataset;

public class DynamicMetadataUtils {

	public static int[] refreshDynamicAxesMetadata(List<AxesMetadata> axm, int[] shape){
		int[] maxShape = shape.clone();
		
		for (AxesMetadata a : axm) {
			AxesMetadataImpl ai = (AxesMetadataImpl)a;
			for (int i = 0 ; i < ai.getAxes().length; i++) {
				ILazyDataset[] axis = ai.getAxis(i);
				if (axis == null) continue;
				for (int j = 0; j < axis.length; j++) {
					ILazyDataset l = axis[i];
					if (l == null) continue;
					int[] dims = ai.getDimensions(l);
					
					if (l instanceof LazyDynamicDataset) {
						l = l.squeezeEnds();
						((LazyDynamicDataset) l).refreshShape();
					}
					
					if (dims == null) {
						int k = l.getShape()[0];
						if (k < maxShape[i]) maxShape[i] = k;
						int[] newShape = shape.clone();
						Arrays.fill(newShape, 1);
						newShape[i] = k;
						l.setShape(newShape);
					} else {
						int[] newShape = shape.clone();
						Arrays.fill(newShape, 1);
						for (int k = 0 ; k < dims.length; k++) {
							int[] s = l.getShape();
							if (s[dims[k]] < maxShape[k]) maxShape[k] = dims[k];
							newShape[k] = s[dims[k]];
							l.setShape(newShape);
						}
					}
				}
			}
		}
		
		return maxShape;	
	}
	
}
