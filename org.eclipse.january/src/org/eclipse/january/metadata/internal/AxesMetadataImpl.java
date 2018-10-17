/*
 * Copyright (c) 2014, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.metadata.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.january.dataset.IDynamicDataset;
import org.eclipse.january.dataset.ILazyDataset;
import org.eclipse.january.dataset.ShapeUtils;
import org.eclipse.january.metadata.AxesMetadata;
import org.eclipse.january.metadata.Reshapeable;
import org.eclipse.january.metadata.Sliceable;
import org.eclipse.january.metadata.Transposable;

public class AxesMetadataImpl implements AxesMetadata {

	private static final long serialVersionUID = -3602919073785450882L;

	@Transposable
	@Reshapeable(matchRank = true)
	@Sliceable List<ILazyDataset>[] allAxes;
	
	Map<ILazyDataset,int[]> dimensionMap;

	public AxesMetadataImpl() {
	}

	@Override
	@SuppressWarnings("unchecked")
	public void initialize(int rank) {
		allAxes = new List[rank];
		dimensionMap = new IdentityHashMap<>();
	}

	@SuppressWarnings("unchecked")
	private AxesMetadataImpl(AxesMetadataImpl axesMetadataImpl) {
		int r = axesMetadataImpl.allAxes.length;
		allAxes = new List[r];
		dimensionMap = new IdentityHashMap<>();
		for (int i = 0; i < r; i++) {
			List<ILazyDataset> ol = axesMetadataImpl.allAxes[i];
			if (ol == null) {
				continue;
			}
			List<ILazyDataset> list = new ArrayList<ILazyDataset>();
			for (ILazyDataset l : ol) {
				ILazyDataset lv = l == null ? null : l.getSliceView();
				list.add(lv);
				if (lv != null && axesMetadataImpl.dimensionMap.containsKey(l)) {
					dimensionMap.put(lv, axesMetadataImpl.dimensionMap.get(l).clone());
				}
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
			if (ax != null && ax.length > 0) {
				result[i] = ax[0];
			}
		}
		return result;
	}

	@Override
	public ILazyDataset[] getAxis(int axisDim) {
		if (allAxes[axisDim] == null) {
			return null;
		}
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
		axisDim = ShapeUtils.checkAxis(allAxes.length, axisDim);
		if (allAxes[axisDim] == null) {
			allAxes[axisDim] = new ArrayList<ILazyDataset>();
		}
		allAxes[axisDim].add(sanitizeAxisData(axisData, axisDim));
	}

	/**
	 * Add axis data to given dimension. This dataset must be one dimensional or match rank
	 * with the associating dataset
	 * @param primaryAxisDim dimension (n.b. this is zero-based)
	 * @param axisData dataset for axis
	 * @param dimMapping indicates where each axis dimension maps to in the dataset dimensions
	 */
	public void addAxis(int primaryAxisDim, ILazyDataset axisData, int... dimMapping) {
		primaryAxisDim = ShapeUtils.checkAxis(allAxes.length, primaryAxisDim);
		if (allAxes[primaryAxisDim] == null) {
			allAxes[primaryAxisDim] = new ArrayList<ILazyDataset>();
		}
		
		ILazyDataset lz = sanitizeAxisData(axisData, dimMapping);
		allAxes[primaryAxisDim].add(lz);
		if (lz != null) {
			dimensionMap.put(lz, dimMapping);
		}
	}

	private ILazyDataset sanitizeAxisData(ILazyDataset axisData, int... axisDims) {
		// remove any axes metadata to prevent infinite recursion
		// and also check rank
		if (axisData == null) {
			return null;
		}

		if (axisDims.length == 1) {
			int ad = ShapeUtils.checkAxis(allAxes.length, axisDims[0]);
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
		} else if (allAxes.length == axisData.getRank()) {
			return axisData;
		} else {
			ILazyDataset view = axisData.getSliceView();
			view.clearMetadata(AxesMetadata.class);
			int[] axisShape = axisData.getShape();
			int[] newShape = new int[allAxes.length];
			Arrays.fill(newShape, 1);
			for (int i = 0 ; i < axisDims.length; i++) {
				newShape[ShapeUtils.checkAxis(allAxes.length, axisDims[i])] = axisShape[i];
			}
			view.setShape(newShape);
			return view;
		}
	}

	@Override
	public int[] refresh(int[] shape) {
		int[] maxShape = shape.clone();

		for (int i = 0 ; i < allAxes.length; i++) {
			List<ILazyDataset> axis = allAxes[i];
			if (axis == null) continue;
			for (int j = 0; j < axis.size(); j++) {
				ILazyDataset l = axis.get(j);
				if (l == null) {
					continue;
				}
				int[] dims = dimensionMap.get(l);

				if (l instanceof IDynamicDataset) {
					
					if (l.getSize() == 1) {
						l.setShape(new int[]{1});
					} else {
						l = l.squeezeEnds();
					}
					
					if (dims != null && dims.length != l.getRank()) {
						int[] tempShape = new int[dims.length];
						Arrays.fill(tempShape,1);
						int[] ss = l.getShape();
						for (int k = 0 ; k < tempShape.length && k < ss.length; k++) {
							tempShape[k] = ss[k];
						}
						l.setShape(tempShape);
					}
					
					try {
						((IDynamicDataset) l).refreshShape();
					} catch (Exception e) {
						String name = l.getName();
						if (name == null) {
							name = "unknown_dataset";
						}
						dimensionMap.remove(l);
						axis.set(j,null);
						continue;
					}
					
				}
				// need to look at rank of l;
				if (dims == null || dims.length == 1) {
					int k = l.getShape()[0];
					if (k < maxShape[i]) {
						maxShape[i] = k;
					}
					int[] newShape = shape.clone();
					Arrays.fill(newShape, 1);
					newShape[i] = k;
					l.setShape(newShape);
					axis.set(j, l);
				} else {
					int[] newShape = shape.clone();
					Arrays.fill(newShape, 1);
					for (int k = 0 ; k < dims.length; k++) {
						int[] s = l.getShape();
						if (s[dims[k]] < maxShape[k]) {
							maxShape[k] = s[dims[k]];
						}
						newShape[k] = s[dims[k]];
					}
					l.setShape(newShape);
					axis.set(j, l);
				}
			}

		}
		return maxShape;
	}
}
