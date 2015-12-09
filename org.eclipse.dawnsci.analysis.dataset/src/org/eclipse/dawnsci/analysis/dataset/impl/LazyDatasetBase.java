/*-
 *******************************************************************************
 * Copyright (c) 2011, 2014 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Peter Chang - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.dawnsci.analysis.dataset.impl;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.dawnsci.analysis.api.dataset.IDataset;
import org.eclipse.dawnsci.analysis.api.dataset.ILazyDataset;
import org.eclipse.dawnsci.analysis.api.dataset.SliceND;
import org.eclipse.dawnsci.analysis.api.metadata.ErrorMetadata;
import org.eclipse.dawnsci.analysis.api.metadata.IMetadata;
import org.eclipse.dawnsci.analysis.api.metadata.MetadataType;
import org.eclipse.dawnsci.analysis.api.metadata.Reshapeable;
import org.eclipse.dawnsci.analysis.api.metadata.Sliceable;
import org.eclipse.dawnsci.analysis.api.metadata.Transposable;
import org.eclipse.dawnsci.analysis.dataset.metadata.ErrorMetadataImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Common base for both lazy and normal dataset implementations
 */
public abstract class LazyDatasetBase implements ILazyDataset, Serializable {

	protected static final Logger logger = LoggerFactory.getLogger(LazyDatasetBase.class);

	protected static boolean catchExceptions;
	
	static {
		/**
		 * Boolean to set to true if running jython scripts that utilise ScisoftPy in IDE
		 */
		catchExceptions = Boolean.getBoolean("run.in.eclipse");
	}

	protected String name = "";

	/**
	 * The shape or dimensions of the dataset
	 */
	protected int[] shape;

	protected Map<Class<? extends MetadataType>, List<MetadataType>> metadata = null;

	/**
	 * @return type of dataset item
	 */
	abstract public int getDtype();

	@Override
	public Class<?> elementClass() {
		return AbstractDataset.elementClass(getDtype());
	}

	@Override
	public LazyDatasetBase clone() {
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!getClass().equals(obj.getClass())) {
			return false;
		}
	
		LazyDatasetBase other = (LazyDatasetBase) obj;
		if (getDtype() != other.getDtype()) {
			return false;
		}
		if (getElementsPerItem() != other.getElementsPerItem()) {
			return false;
		}
		if (!Arrays.equals(shape, other.shape)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = getDtype() * 17 + getElementsPerItem();
		int rank = shape.length;
		for (int i = 0; i < rank; i++) {
			hash = hash*17 + shape[i];
		}
		return hash;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int[] getShape() {
		return shape.clone();
	}

	@Override
	public int getRank() {
		return shape.length;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends MetadataType> void setMetadata(T metadata) {
		if (metadata == null)
			return;

		List<T> ml = null;
		try {
			ml = (List<T>) getMetadata(metadata.getClass());
		} catch (Exception e) {
			logger.error("Problem retrieving metadata of class {}: {}", metadata.getClass().getCanonicalName(), e);
		}

		if (ml == null) {
			addMetadata(metadata);
		} else {
			ml.clear();
			ml.add(metadata);
		}
	}

	@Override
	public IMetadata getMetadata() {
		List<IMetadata> ml = null;
		try {
			ml = getMetadata(IMetadata.class);
		} catch (Exception e) {
			logger.error("Problem retrieving metadata of class {}: {}", IMetadata.class.getCanonicalName(), e);
		}

		return ml == null ? null : ml.get(0);
	}

	@Override
	public <T extends MetadataType> void addMetadata(T metadata) {
		if (metadata == null)
			return;

		if (this.metadata == null) {
			this.metadata = new HashMap<Class<? extends MetadataType>, List<MetadataType>>();
		}

		Class<? extends MetadataType> clazz = findMetadataTypeSubInterfaces(metadata.getClass());
		if (!this.metadata.containsKey(clazz)) {
			this.metadata.put(clazz, new ArrayList<MetadataType>());
		}
		this.metadata.get(clazz).add(metadata);
	}

	/**
	 * Dig down to interface (or class) that directly extends (or implements) MetadataType
	 * @param clazz
	 * @return sub-interface
	 */
	@SuppressWarnings("unchecked")
	static Class<? extends MetadataType> findMetadataTypeSubInterfaces(Class<? extends MetadataType> clazz) {
		Class<?> sclazz = clazz.getSuperclass();
		if (sclazz != null && !sclazz.equals(Object.class)) // recurse up class hierarchy
			return findMetadataTypeSubInterfaces((Class<? extends MetadataType>) sclazz);

		for (Class<?> c : clazz.getInterfaces()) {
			if (c.equals(MetadataType.class))
				return clazz;
			if (MetadataType.class.isAssignableFrom(c)) {
				return findMetadataTypeSubInterfaces((Class<? extends MetadataType>) c);
			}
		}
		assert false; // should not be able to get here!!!
		logger.error("Somehow the search for metadata type interface ended in a bad place");
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends MetadataType> List<T> getMetadata(Class<T> clazz) throws Exception {
		if (metadata == null)
			return null;

		if (clazz == null) {
			List<T> all = new ArrayList<T>();
			for (Class<? extends MetadataType> c : metadata.keySet()) {
				all.addAll((Collection<? extends T>) metadata.get(c));
			}
			return all;
		}

		return (List<T>) metadata.get(findMetadataTypeSubInterfaces(clazz));
	}
	
	@Override
	public <T extends MetadataType> T getFirstMetadata(Class<T> clazz) {
		try {
			List<T> ml = getMetadata(clazz);
			if (ml == null) return null;
			for (T t : ml) if (t.getClass().equals(clazz)) return t;
		} catch (Exception e) {
			logger.error("Get metadata failed!",e);
		}

		return null;
	}

	@Override
	public <T extends MetadataType> void clearMetadata(Class<T> clazz) {
		if (metadata == null)
			return;

		if (clazz == null) {
			metadata.clear();
			return;
		}

		List<MetadataType> list = metadata.get(findMetadataTypeSubInterfaces(clazz));
		if( list != null) {
			list.clear();
		}
	}

	protected Map<Class<? extends MetadataType>, List<MetadataType>> copyMetadata() {
		return copyMetadata(metadata);
	}

	protected static Map<Class<? extends MetadataType>, List<MetadataType>> copyMetadata(Map<Class<? extends MetadataType>, List<MetadataType>> metadata) {
		if (metadata == null)
			return null;

		HashMap<Class<? extends MetadataType>, List<MetadataType>> map = new HashMap<Class<? extends MetadataType>, List<MetadataType>>();

		for (Class<? extends MetadataType> c : metadata.keySet()) {
			List<MetadataType> l = metadata.get(c);
			List<MetadataType> nl = new ArrayList<MetadataType>(l.size());
			map.put(c, nl);
			for (MetadataType m : l) {
				nl.add(m.clone());
			}
		}
		return map;
	}

	interface MetadatasetAnnotationOperation {
		Object processField(Field f, Object o);
		Class<? extends Annotation> getAnnClass();
		/**
		 * @param axis
		 * @return number of dimensions to insert or remove
		 */
		int change(int axis);
		/**
		 * 
		 * @return rank or -1 to match
		 */
		int getNewRank();
		ILazyDataset run(ILazyDataset lz);
	}

	class MdsSlice implements MetadatasetAnnotationOperation {
		private boolean asView;
		private int[] start;
		private int[] stop;
		private int[] step;
		private int[] oShape;
		private long oSize;

		public MdsSlice(boolean asView, final int[] start, final int[] stop, final int[] step, final int[] oShape) {
			this.asView = asView;
 			this.start = start;
			this.stop = stop;
			this.step = step;
			this.oShape = oShape;
			oSize = AbstractDataset.calcLongSize(oShape);
		}

		@Override
		public Object processField(Field field, Object o) {
			return o;
		}

		@Override
		public Class<? extends Annotation> getAnnClass() {
			return Sliceable.class;
		}

		@Override
		public int change(int axis) {
			return 0;
		}

		@Override
		public int getNewRank() {
			return -1;
		}

		@Override
		public ILazyDataset run(ILazyDataset lz) {
			int rank = lz.getRank();
			if (start.length != rank)
				throw new IllegalArgumentException("Slice dimensions do not match dataset!");

			int[] shape = lz.getShape();
			int[] stt;
			int[] stp;
			int[] ste;
			if (lz.getSize() == oSize) {
				stt = start;
				stp = stop;
				ste = step;
			} else {
				stt = start.clone();
				stp = stop.clone();
				ste = step.clone();
				for (int i = 0; i < rank; i++) {
					if (shape[i] == oShape[i]) continue;
					if (shape[i] == 1) {
						stt[i] = 0;
						stp[i] = 1;
						ste[1] = 1;
					} else {
						throw new IllegalArgumentException("Sliceable dataset has invalid size!");
					}
				}
			}

			if (asView || (lz instanceof IDataset))
				return lz.getSliceView(stt, stp, ste);
			return lz.getSlice(stt, stp, ste);
		}
	}

	class MdsReshape implements MetadatasetAnnotationOperation {
		private boolean matchRank;
		private int[] oldShape;
		private int[] newShape;
		boolean onesOnly;
		int[] differences;

		/*
		 * if only ones then record differences (insertions and deletions)
		 * 
		 * if shape changing, find broadcasted dimensions and disallow
		 * merging that include those dimensions
		 */
		public MdsReshape(final int[] oldShape, final int[] newShape) {
			this.oldShape = oldShape;
			this.newShape = newShape;
			differences = null;
		}

		@Override
		public Object processField(Field field, Object o) {
			Annotation a = field.getAnnotation(getAnnClass());
			if (a instanceof Reshapeable) {
				matchRank = ((Reshapeable) a).matchRank();
			}
			return o;
		}

		@Override
		public Class<? extends Annotation> getAnnClass() {
			return Reshapeable.class;
		}	

		@Override
		public int change(int axis) {
			if (matchRank) {
				if (differences == null)
					init();

				if (onesOnly) {
					return differences[axis];
				}
				throw new UnsupportedOperationException("TODO support other shape operations");
			}
			return 0;
		}

		@Override
		public int getNewRank() {
			return matchRank ? newShape.length : -1;
		}

		private void init() {
			int or = oldShape.length - 1;
			int nr = newShape.length - 1;
			if (or < 0 || nr < 0) { // zero-rank shapes
				onesOnly = true;
				differences = new int[1];
				differences[0] = or < 0 ? nr + 1 : or + 1;
				return;
			}
			int ob = 0;
			int nb = 0;
			onesOnly = true;
			do {
				while (oldShape[ob] == 1 && ob < or) {
					ob++; // next non-unit dimension
				}
				while (newShape[nb] == 1 && nb < nr) {
					nb++;
				}
				if (oldShape[ob++] != newShape[nb++]) {
					onesOnly = false;
					break;
				}
			} while (ob <= or && nb <= nr);

			ob = 0;
			nb = 0;
			differences = new int[or + 2];
			if (onesOnly) {
				// work out unit dimensions removed from or add to old
				int j = 0;
				do {
					if (oldShape[ob] != 1 && newShape[nb] != 1) {
						ob++;
						nb++;
					} else {
						while (oldShape[ob] == 1 && ob < or) {
							ob++;
							differences[j]--;
						}
						while (newShape[nb] == 1 && nb < nr) {
							nb++;
							differences[j]++;
						}
					}
					j++;
				} while (ob <= or && nb <= nr && j <= or);
				while (ob <= or && oldShape[ob] == 1) {
					ob++;
					differences[j]--;
				}
				while (nb <= nr && newShape[nb] == 1) {
					nb++;
					differences[j]++;
				}
			} else {
				if (matchRank) {
					logger.error("Combining dimensions is currently not supported");
					throw new IllegalArgumentException("Combining dimensions is currently not supported");
				}
				// work out mapping: contiguous dimensions can be grouped or split
				while (ob <= or && nb <= nr) {
					int ol = oldShape[ob];
					while (ol == 1 && ol <= or) {
						ob++;
						ol = oldShape[ob];
					}
					int oe = ob + 1;
					int nl = newShape[nb];
					while (nl == 1 && nl <= nr) {
						nb++;
						nl = newShape[nb];
					}
					int ne = nb + 1;
					if (ol < nl) {
						differences[ob] = 1;
						do { // case where new shape combines several dimensions into one dimension
							if (oe == (or + 1)) {
								break;
							}
							differences[oe] = 1;
							ol *= oldShape[oe++];
						} while (ol < nl);
						differences[oe - 1] = oe - ob; // signal end with difference
						if (nl != ol) {
							logger.error("Single dimension is incompatible with subshape");
							throw new IllegalArgumentException("Single dimension is incompatible with subshape");
						}
					} else if (ol > nl) {
						do { // case where new shape spreads single dimension over several dimensions
							if (ne == (nr + 1)) {
								break;
							}
							nl *= newShape[ne++];
						} while (nl < ol);
						if (nl != ol) {
							logger.error("Subshape is incompatible with single dimension");
							throw new IllegalArgumentException("Subshape is incompatible with single dimension");
						}

					}

					ob = oe;
					nb = ne;
				}

			}
		}

		@Override
		public ILazyDataset run(ILazyDataset lz) {
			if (differences == null)
				init();

			int[] lshape = lz.getShape();
			if (Arrays.equals(newShape, lshape)) {
				return lz;
			}
			int or = lz.getRank();
			int nr = newShape.length;
			int[] nshape = new int[nr];
			Arrays.fill(nshape, 1);
			if (onesOnly) {
				// ignore omit removed dimensions
				for (int i = 0, si = 0, di = 0; i < (or+1) && si <= or && di < nr; i++) {
					int c = differences[i];
					if (c == 0) {
						nshape[di++] = lshape[si++];
					} else if (c > 0) {
						while (c-- > 0 && di < nr) {
							di++;
						}
					} else if (c < 0) {
						si -= c; // remove dimensions by skipping forward in source array
					}
				}
			} else {
				boolean[] broadcast = new boolean[or];
				for (int ob = 0; ob < or; ob++) {
					broadcast[ob] = oldShape[ob] != 1 && lshape[ob] == 1;
				}
				int osize = lz.getSize();

				// cannot do 3x5x... to 15x... if metadata is broadcasting (i.e. 1x5x...)
				int ob = 0;
				int nsize = 1;
				for (int i = 0; i < nr; i++) {
					if (ob < or && broadcast[ob]) {
						if (differences[ob] != 0) {
							logger.error("Metadata contains a broadcast axis which cannot be reshaped");
							throw new IllegalArgumentException("Metadata contains a broadcast axis which cannot be reshaped");
						}
					} else {
						nshape[i] = nsize < osize ? newShape[i] : 1;
					}
					nsize *= nshape[i];
					ob++;
				}
			}

			ILazyDataset nlz = lz; //.clone();
			nlz.setShape(nshape);
			return nlz;
		}
	}

	class MdsTranspose implements MetadatasetAnnotationOperation {
		int[] map;

		public MdsTranspose(final int[] axesMap) {
			map = axesMap;
		}

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public Object processField(Field f, Object o) {
			if (o.getClass().isArray()) {
				int l = Array.getLength(o);
				if (l == map.length) {
					Object narray = Array.newInstance(o.getClass().getComponentType(), l);
					for (int i = 0; i < l; i++) {
						Array.set(narray, i, Array.get(o, map[i]));
					}
					for (int i = 0; i < l; i++) {
						Array.set(o, i, Array.get(narray, i));
					}
				}
			} else if (o instanceof List<?>) {
				List list = (List) o;
				int l = list.size();
				if (l == map.length) {
					Object narray = Array.newInstance(o.getClass().getComponentType(), l);
					for (int i = 0; i < l; i++) {
						Array.set(narray, i, list.get(map[i]));
					}
					list.clear();
					for (int i = 0; i < l; i++) {
						list.add(Array.get(narray, i));
					}
				}
			}
			return o;
		}

		@Override
		public Class<? extends Annotation> getAnnClass() {
			return Transposable.class;
		}

		@Override
		public int change(int axis) {
			return 0;
		}

		@Override
		public int getNewRank() {
			return -1;
		}

		@Override
		public ILazyDataset run(ILazyDataset lz) {
			return lz.getTransposedView(map);
		}
	}

	/**
	 * Slice all datasets in metadata that are annotated by @Sliceable. Call this on the new sliced
	 * dataset after cloning the metadata
	 * @param asView if true then just a view
	 * @param slice
	 */
	protected void sliceMetadata(boolean asView, final SliceND slice) {
		processAnnotatedMetadata(new MdsSlice(asView, slice.getStart(), slice.getStop(), slice.getStep(), slice.getSourceShape()), true);
	}

	/**
	 * Reshape all datasets in metadata that are annotated by @Reshapeable. Call this when squeezing
	 * or setting the shape
	 * 
	 * @param newShape
	 */
	protected void reshapeMetadata(final int[] oldShape, final int[] newShape) {
		processAnnotatedMetadata(new MdsReshape(oldShape, newShape), true);
	}

	/**
	 * Transpose all datasets in metadata that are annotated by @Transposable. Call this on the transposed
	 * dataset after cloning the metadata
	 * @param axesMap
	 */
	protected void transposeMetadata(final int[] axesMap) {
		processAnnotatedMetadata(new MdsTranspose(axesMap), true);
	}

	@SuppressWarnings("unchecked")
	private void processAnnotatedMetadata(MetadatasetAnnotationOperation op, boolean throwException) {
		if (metadata == null)
			return;

		for (Class<? extends MetadataType> c : metadata.keySet()) {
			for (MetadataType m : metadata.get(c)) {
				if (m == null)
					continue;

				Class<? extends MetadataType> mc = m.getClass();
				do { // iterate over super-classes
					processClass(op, m, mc, throwException);
					Class<?> sclazz = mc.getSuperclass();
					if (!MetadataType.class.isAssignableFrom(sclazz))
						break;
					mc = (Class<? extends MetadataType>) sclazz;
				} while (true);
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void processClass(MetadatasetAnnotationOperation op, MetadataType m, Class<? extends MetadataType> mc, boolean throwException) {
		for (Field f : mc.getDeclaredFields()) {
			if (!f.isAnnotationPresent(op.getAnnClass()))
				continue;

			try {
				f.setAccessible(true);
				Object o = f.get(m);
				if (o == null)
					continue;

				o = op.processField(f, o);
				Object r = null;
				if (o instanceof ILazyDataset) {
					try {
						f.set(m, op.run((ILazyDataset) o));
					} catch (Exception e) {
						logger.error("Problem processing " + o, e);
						if (!catchExceptions)
							throw e;
					}
				} else if (o.getClass().isArray()) {
					int l = Array.getLength(o);
					if (l <= 0)
						continue;

					for (int i = 0; r == null && i < l; i++) {
						r = Array.get(o, i);
					}
					int n = op.getNewRank();
					if (r == null) {
						if (n < 0 || n != l) { // all nulls be need to match rank as necessary
							f.set(m, Array.newInstance(o.getClass().getComponentType(), n < 0 ? l : n));
						}
						continue;
					}
					if (n < 0)
						n = l;
					Object narray = Array.newInstance(r.getClass(), n);
					for (int i = 0, si = 0, di = 0; di < n && si < l; i++) {
						int c = op.change(i);
						if (c == 0) {
							Array.set(narray, di++, processObject(op, Array.get(o, si++)));
						} else if (c > 0) {
							di += c; // add nulls by skipping forward in destination array
						} else if (c < 0) {
							si -= c; // remove dimensions by skipping forward in source array
						}
					}
					if (n == l) {
						for (int i = 0; i < l; i++) {
							Array.set(o, i, Array.get(narray, i));
						}
					} else {
						f.set(m, narray);
					}
				} else if (o instanceof List<?>) {
					List list = (List) o;
					int l = list.size();
					if (l <= 0)
						continue;

					for (int i = 0; r == null && i < l; i++) {
						r = list.get(i);
					}
					int n = op.getNewRank();
					if (r == null) {
						if (n < 0 || n != l) { // all nulls be need to match rank as necessary
							list.clear();
							for (int i = 0, imax = n < 0 ? l : n; i < imax; i++) {
								list.add(null);
							}
						}
						continue;
					}

					if (n < 0)
						n = l;
					Object narray = Array.newInstance(r.getClass(), n);
					for (int i = 0, si = 0, di = 0; i < l && si < l; i++) {
						int c = op.change(i);
						if (c == 0) {
							Array.set(narray, di++, processObject(op, list.get(si++)));
						} else if (c > 0) {
							di += c; // add nulls by skipping forward in destination array
						} else if (c < 0) {
							si -= c; // remove dimensions by skipping forward in source array
						}
					}
					list.clear();
					for (int i = 0; i < n; i++) {
						list.add(Array.get(narray, i));
					}
				} else if (o instanceof Map<?,?>) {
					Map map = (Map) o;
					for (Object k : map.keySet()) {
						map.put(k, processObject(op, map.get(k)));
					}
				}
			} catch (Exception e) {
				logger.error("Problem occurred when processing metadata of class {}: {}", mc.getCanonicalName(), e);
				if (throwException)
					throw new RuntimeException(e);
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static Object processObject(MetadatasetAnnotationOperation op, Object o) throws Exception {
		if (o == null)
			return o;

		if (o instanceof ILazyDataset) {
			try {
				return op.run((ILazyDataset) o);
			} catch (Exception e) {
				logger.error("Problem processing " + o, e);
				if (!catchExceptions)
					throw e;
			}
		} else if (o.getClass().isArray()) {
			int l = Array.getLength(o);
			for (int i = 0; i < l; i++) {
				Array.set(o, i, processObject(op, Array.get(o, i)));
			}
		} else if (o instanceof List<?>) {
			List list = (List) o;
			for (int i = 0, imax = list.size(); i < imax; i++) {
				list.set(i, processObject(op, list.get(i)));
			}
		} else if (o instanceof Map<?,?>) {
			Map map = (Map) o;
			for (Object k : map.keySet()) {
				map.put(k, processObject(op, map.get(k)));
			}
		}
		return o;
	}

	protected void restoreMetadata(Map<Class<? extends MetadataType>, List<MetadataType>> oldMetadata) {
		for (Class<? extends MetadataType> mc : oldMetadata.keySet()) {
			metadata.put(mc, oldMetadata.get(mc));
		}
	}

	protected ILazyDataset createFromSerializable(Serializable blob, boolean keepLazy) {
		ILazyDataset d = null;
		if (blob instanceof ILazyDataset) {
			d = (ILazyDataset) blob;
			if (d instanceof IDataset) {
				Dataset ed = DatasetUtils.convertToDataset(d);
				int is = ed.getElementsPerItem();
				if (is != 1 && is != getElementsPerItem()) {
					throw new IllegalArgumentException("Dataset has incompatible number of elements with this dataset");
				}
				d = ed.cast(is == 1 ? Dataset.FLOAT64 : Dataset.ARRAYFLOAT64);
			} else if (!keepLazy) {
				final int is = getElementsPerItem();
				d = DatasetUtils.cast(d.getSlice(), is == 1 ? Dataset.FLOAT64 : Dataset.ARRAYFLOAT64);
			}
		} else {
			final int is = getElementsPerItem();
			d = DatasetFactory.createFromObject(blob, is == 1 ? Dataset.FLOAT64 : Dataset.ARRAYFLOAT64);
			if (d.getSize() == getSize() && !Arrays.equals(d.getShape(), shape)) {
				d.setShape(shape.clone());
			}
		}
		List<int[]> s = BroadcastIterator.broadcastShapesToMax(shape, d.getShape());
		d.setShape(s.get(0));

		return d;
	}

	@Override
	public void setError(Serializable errors) {
		if (errors == null) {
			clearMetadata(ErrorMetadata.class);
			return;
		}
		if (errors == this) {
			logger.warn("Ignoring setting error to itself as this will lead to infinite recursion");
			return;
		}

		ILazyDataset errorData = createFromSerializable(errors, true);

		ErrorMetadata emd = getErrorMetadata();
		if (emd == null || !(emd instanceof ErrorMetadataImpl)) {
			emd = new ErrorMetadataImpl();
			setMetadata(emd);
		}
		((ErrorMetadataImpl) emd).setError(errorData);
	}

	protected ErrorMetadata getErrorMetadata() {
		try {
			List<ErrorMetadata> el = getMetadata(ErrorMetadata.class);
			if (el != null && !el.isEmpty()) {
				 return el.get(0);
			}
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public ILazyDataset getError() {
		ErrorMetadata emd = getErrorMetadata();
		return emd == null ? null : emd.getError();
	}

	/**
	 * Check permutation axes
	 * @param shape
	 * @param axes
	 * @return cleaned up axes or null if trivial
	 */
	public static int[] checkPermutatedAxes(int[] shape, int... axes) {
		int rank = shape.length;
	
		if (axes == null || axes.length == 0) {
			axes = new int[rank];
			for (int i = 0; i < rank; i++) {
				axes[i] = rank - 1 - i;
			}
		}

		if (axes.length != rank) {
			logger.error("axis permutation has length {} that does not match dataset's rank {}", axes.length, rank);
			throw new IllegalArgumentException("axis permutation does not match shape of dataset");
		}
	
		// check all permutation values are within bounds
		for (int d : axes) {
			if (d < 0 || d >= rank) {
				logger.error("axis permutation contains element {} outside rank of dataset", d);
				throw new IllegalArgumentException("axis permutation contains element outside rank of dataset");
			}
		}
	
		// check for a valid permutation (is this an unnecessary restriction?)
		int[] perm = axes.clone();
		Arrays.sort(perm);

		for (int i = 0; i < rank; i++) {
			if (perm[i] != i) {
				logger.error("axis permutation is not valid: it does not contain complete set of axes");
				throw new IllegalArgumentException("axis permutation does not contain complete set of axes");	
			}
		}

		if (Arrays.equals(axes, perm))
			return null; // signal identity or trivial permutation

		return axes;
	}
}
