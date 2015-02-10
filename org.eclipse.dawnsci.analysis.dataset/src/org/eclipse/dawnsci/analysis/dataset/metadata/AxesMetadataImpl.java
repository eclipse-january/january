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
import java.util.List;

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

	@SuppressWarnings("unchecked")
	public AxesMetadataImpl(int rank) {
		allAxes = new List[rank];
	}

	@SuppressWarnings("unchecked")
	public AxesMetadataImpl(AxesMetadataImpl axesMetadataImpl) {
		int r = axesMetadataImpl.allAxes.length;
		allAxes = new List[r];
		for (int i = 0; i < r; i++) {
			List<ILazyDataset> ol = axesMetadataImpl.allAxes[i];
			if (ol == null)
				continue;
			List<ILazyDataset> list = new ArrayList<ILazyDataset>();
			for (ILazyDataset l : ol) {
				list.add(l == null ? null : l.getSliceView());
			}
			allAxes[i] = list;
		}
	}

	@Override
	public void setAxis(int axisDim, ILazyDataset... axisData) {
		ArrayList<ILazyDataset> axisList = new ArrayList<ILazyDataset>(0);
		for (int i = 0; i < axisData.length; i++) {
			axisList.add(sanitizeAxisData(axisDim, axisData[i]));
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
		allAxes[axisDim].add(sanitizeAxisData(axisDim, axisData));
	}

	private ILazyDataset sanitizeAxisData(int axisDim, ILazyDataset axisData) {
		// remove any axes metadata to prevent infinite recursion
		// and also check rank
		if (axisData == null) return null;
		ILazyDataset view = axisData.getSliceView();
		view.clearMetadata(AxesMetadata.class);
		int r = axisData.getRank(); 
		if (r != allAxes.length) {
			if (r > 1) {
				throw new IllegalArgumentException("Given axis dataset must be zero or one dimensional, or match rank");
			}
			int[] newShape = new int[allAxes.length];
			Arrays.fill(newShape, 1);
			newShape[axisDim] = axisData.getSize();
			view.setShape(newShape);
		}
		return view;
	}

	@Override
	public AxesMetadata createAxesMetadata(int rank) {
		return new AxesMetadataImpl(rank);
	}
}
