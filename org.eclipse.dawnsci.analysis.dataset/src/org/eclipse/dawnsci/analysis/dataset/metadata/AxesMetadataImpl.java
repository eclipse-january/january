/*
 * Copyright (c) 2014 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.dataset.metadata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.dawnsci.analysis.api.dataset.ILazyDataset;
import org.eclipse.dawnsci.analysis.api.metadata.AxesMetadata;
import org.eclipse.dawnsci.analysis.api.metadata.Reshapeable;
import org.eclipse.dawnsci.analysis.api.metadata.Sliceable;
import org.eclipse.dawnsci.analysis.api.metadata.Transposable;

public class AxesMetadataImpl implements AxesMetadata {

	@Transposable
	@Reshapeable(matchRank = true)
	@Sliceable
	final List<ILazyDataset>[] allAxes;
	
	final Map<ILazyDataset,int[]> dimensionMap;

	@SuppressWarnings("unchecked")
	public AxesMetadataImpl(int rank) {
		allAxes = new List[rank];
		dimensionMap = new HashMap<ILazyDataset,int[]>();
	}

	@SuppressWarnings("unchecked")
	public AxesMetadataImpl(AxesMetadataImpl axesMetadataImpl) {
		int r = axesMetadataImpl.allAxes.length;
		allAxes = new List[r];
		dimensionMap = new HashMap<ILazyDataset,int[]>();
		for (int i = 0; i < r; i++) {
			List<ILazyDataset> ol = axesMetadataImpl.allAxes[i];
			if (ol == null)
				continue;
			List<ILazyDataset> list = new ArrayList<ILazyDataset>();
			for (ILazyDataset l : ol) {
				ILazyDataset lv = l == null ? null : l.getSliceView();
				list.add(lv);
				if (axesMetadataImpl.dimensionMap.containsKey(l)) dimensionMap.put(lv, axesMetadataImpl.dimensionMap.get(lv).clone());
			}
			allAxes[i] = list;
		}
	}

	@Override
	public void setAxis(int axisDim, ILazyDataset... axisData) {
		ArrayList<ILazyDataset> axisList = new ArrayList<ILazyDataset>(0);
		for (int i = 0; i < axisData.length; i++) {
			axisList.add(sanitizeAxisData(axisData[i],axisDim));
		}
		allAxes[axisDim] = axisList;
	}

	@Override
	public ILazyDataset[] getAxes() {
		ILazyDataset[] result = new ILazyDataset[allAxes.length];
		for (int i = 0; i < result.length; i++) {
			ILazyDataset[] ax = getAxis(i);
			if (ax != null && ax.length > 0) result[i] = ax[0];
		}
		return result;
	}

	@Override
	public ILazyDataset[] getAxis(int axisDim) {
		if (allAxes[axisDim] == null)
			return null;
		return allAxes[axisDim].toArray(new ILazyDataset[0]);
	}

	@Override
	public AxesMetadata clone() {
		return new AxesMetadataImpl(this);
	}

	/**
	 * Add axis data to given dimension. This dataset must be one dimensional or match rank
	 * with the associating dataset
	 * @param axisDim dimension (n.b. this is zero-based)
	 * @param axisData dataset for axis
	 */
	public void addAxis(int axisDim, ILazyDataset axisData) {
		if (allAxes[axisDim] == null) {
			allAxes[axisDim] = new ArrayList<ILazyDataset>();
		}
		allAxes[axisDim].add(sanitizeAxisData(axisData,axisDim));
	}
	
	public void addAxis(ILazyDataset axisData, int... axisDim) {
		if (allAxes[axisDim[0]] == null) {
			allAxes[axisDim[0]] = new ArrayList<ILazyDataset>();
		}
		
		ILazyDataset lz = sanitizeAxisData(axisData,axisDim);
		allAxes[axisDim[0]].add(lz);
		if (lz != null) dimensionMap.put(lz, axisDim);
	}
	
	public int[] getDimensions(ILazyDataset lz) {
		return dimensionMap.get(lz);
	}

	private ILazyDataset sanitizeAxisData(ILazyDataset axisData, int... axisDim) {
		// remove any axes metadata to prevent infinite recursion
		// and also check rank
		if (axisData == null) return null;
		
		if (axisDim.length == 1) {
			int ad = axisDim[0];
			ILazyDataset view = axisData.getSliceView();
			view.clearMetadata(AxesMetadata.class);
			int r = axisData.getRank(); 
			if (r != allAxes.length) {
				if (r > 1) {
					throw new IllegalArgumentException("Given axis dataset must be zero or one dimensional, or match rank");
				}
				int[] newShape = new int[allAxes.length];
				Arrays.fill(newShape, 1);
				newShape[ad] = axisData.getSize();
				view.setShape(newShape);
			}
			return view;
		}
		
		return null;
		
	}

	@Override
	public AxesMetadata createAxesMetadata(int rank) {
		return new AxesMetadataImpl(rank);
	}
}
