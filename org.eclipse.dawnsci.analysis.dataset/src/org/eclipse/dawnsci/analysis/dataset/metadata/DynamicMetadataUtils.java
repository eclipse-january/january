/*-
 * Copyright 2015 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.dataset.metadata;

import java.util.List;

import org.eclipse.dawnsci.analysis.api.metadata.AxesMetadata;

public class DynamicMetadataUtils {

	public static int[] refreshDynamicAxesMetadata(List<AxesMetadata> axm, int[] shape){
		
		int[] maxShape = shape.clone();
		if (axm == null) return maxShape;
		
		for (AxesMetadata a : axm) {
			AxesMetadataImpl ai = (AxesMetadataImpl)a;
			int[] s = ai.refresh(shape);
			for (int i = 0; i < s.length; i++) {
				if (maxShape[i] > s[i]) maxShape[i] = s[i];
 			}
		}
		
		return maxShape;	
	}
	
}
