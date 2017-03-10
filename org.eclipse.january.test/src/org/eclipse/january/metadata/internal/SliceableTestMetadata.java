/*
 * Copyright (c) 2014 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.metadata.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.january.dataset.BooleanDataset;
import org.eclipse.january.dataset.DoubleDataset;
import org.eclipse.january.dataset.ILazyDataset;
import org.eclipse.january.dataset.ShortDataset;
import org.eclipse.january.metadata.MetadataType;
import org.eclipse.january.metadata.Reshapeable;
import org.eclipse.january.metadata.Sliceable;

public class SliceableTestMetadata implements MetadataType {
	
	//default ID for test class
	private static final long serialVersionUID = 1L;
	
	@Reshapeable
	@Sliceable
	private ILazyDataset ds;
	@Reshapeable
	@Sliceable
	private DoubleDataset[] dds;
	@Reshapeable
	@Sliceable
	private List<ShortDataset> lds;
	@Reshapeable
	@Sliceable
	private Map<String, BooleanDataset> mds;
	@Reshapeable
	@Sliceable
	private List<DoubleDataset[]> l2deep;

	public SliceableTestMetadata(ILazyDataset ld, DoubleDataset[] array, List<ShortDataset> list, Map<String, BooleanDataset> map, List<DoubleDataset[]> l2) {
		ds = ld;
		dds = array;
		lds = list;
		mds = map;
		l2deep = l2;
	}

	public SliceableTestMetadata(SliceableTestMetadata stm) {
		if (stm.ds == null) {
			ds = null;
		} else {
			ds = stm.ds.getSliceView();
		}

		if (stm.dds == null) {
			dds = null;
		} else {
			dds = new DoubleDataset[stm.dds.length];
			for (int i = 0; i < dds.length; i++) {
				dds[i] = stm.dds[i].getView(true);
			}
		}

		if (stm.lds == null) {
			lds = null;
		} else {
			lds = new ArrayList<ShortDataset>();
			for (ShortDataset d : stm.lds) {
				lds.add(d.getView(true));
			}
		}

		if (stm.mds == null) {
			mds = null;
		} else {
			mds = new HashMap<String, BooleanDataset>();
			for (String s : stm.mds.keySet()) {
				mds.put(s, stm.mds.get(s).getView(true));
			}
		}

		if (stm.l2deep == null) {
			l2deep = null;
		} else {
			l2deep = new ArrayList<DoubleDataset[]>();
			for (DoubleDataset[] da : stm.l2deep) {
				DoubleDataset[] ta = new DoubleDataset[da.length];
				for (int i = 0; i < ta.length; i++) {
					ta[i] = da[i].getView(true);
				}
				l2deep.add(ta);
			}
		}
	}

	@Override
	public MetadataType clone() {
		return new SliceableTestMetadata(this);
	}

	public ILazyDataset getLazyDataset() {
		return ds;
	}

	public DoubleDataset[] getArray() {
		return dds;
	}
	public List<ShortDataset> getList() {
		return lds;
	}
	public Map<String, BooleanDataset> getMap() {
		return mds;
	}
	
	public List<DoubleDataset[]> getListOfArrays() {
		return l2deep;
	}
}
