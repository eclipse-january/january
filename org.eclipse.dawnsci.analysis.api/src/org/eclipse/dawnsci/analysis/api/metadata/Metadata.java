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

package org.eclipse.dawnsci.analysis.api.metadata;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.SerializationUtils;


/**
 * Basic implementation of metadata
 */
public class Metadata implements IMetadata {
	private static final long serialVersionUID = IMetadata.serialVersionUID;

	private Map<String, ? extends Serializable> metadata;
	// NOTE shapes is LinkedHashMap here because the names collection 
	// maintained order. Now that we do not need this collection but if we
	// do not keep the shapes in a LinkedHashMap, we lose order.
	private Map<String,int[]> shapes = new LinkedHashMap<String,int[]>(7);
	private Collection<Serializable> userObjects;
	private String filePath;


	public Metadata() {
	}

	public Metadata(Map<String, ? extends Serializable> metadata) {
		this.metadata = metadata;
	}

	public Metadata(Collection<String> names) {
		if (names != null) {
			for (String n : names) {
				shapes.put(n, null);
			}
		}
	}

	/**
	 * Set metadata map
	 * @param metadata
	 */
	public void setMetadata(Map<String, ? extends Serializable> metadata) {
		this.metadata = metadata;
	}

	/**
	 * Internal use only
	 * @return metadata map
	 */
	protected Map<String, ? extends Serializable> getInternalMetadata() {
		return metadata;
	}

	/**
	 * Set user objects
	 * @param objects
	 */
	public void setUserObjects(Collection<Serializable> objects) {
		userObjects = objects;
	}

	/**
	 * Add name and shape of a dataset to metadata
	 * 
	 * @param name
	 * @param shape (can be null or zero-length)
	 * 
	 * (NOTE method should be public, people can define loaders outside this
	 * package like the DESY FIO loader for instance.)
	 */
	public void addDataInfo(String name, int... shape) {
		shapes.put(name, shape == null || shape.length == 0 ? null : shape);
	}

	@Override
	public Collection<String> getDataNames() {
		return Collections.unmodifiableCollection(shapes.keySet());
	}

	@Override
	public Map<String, int[]> getDataShapes() {
		return Collections.unmodifiableMap(shapes);
	}

	@Override
	public Map<String, Integer> getDataSizes() {
		Map<String, Integer> sizes = new HashMap<String, Integer>(1);
		for (Entry<String, int[]> e : shapes.entrySet()) {
			int[] shape = e.getValue();
			if (shape != null && shape.length > 1)
				sizes.put(e.getKey(), calcSize(shape));
			else
				sizes.put(e.getKey(), null);
		}
		if (sizes.size() > 0) {
			return Collections.unmodifiableMap(sizes);
		}
		return null;
	}

	@Override
	public Serializable getMetaValue(String key) throws Exception {
		return metadata == null ? null : metadata.get(key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<String> getMetaNames() throws Exception {
		return metadata == null ? (Collection<String>) Collections.EMPTY_SET : Collections.unmodifiableCollection(metadata.keySet());
	}

	@Override
	public Collection<Serializable> getUserObjects() {
		return userObjects;
	}

	@Override
	public IMetadata clone() {
		Metadata c = null;
		try {
			c = (Metadata) super.clone();
			if (metadata != null) {
				HashMap<String, Serializable> md = new HashMap<String, Serializable>();
				c.metadata = md;
				ByteArrayOutputStream os = new ByteArrayOutputStream(512);
				for (String k : metadata.keySet()) {
					Serializable v = metadata.get(k);
					if (v != null) {
						SerializationUtils.serialize(v, os);
						Serializable nv = (Serializable) SerializationUtils.deserialize(os.toByteArray());
						os.reset();
						md.put(k, nv);
					} else {
						md.put(k, null);
					}
				}
			}
			c.shapes = new HashMap<String, int[]>(1);
			for (Entry<String, int[]> e : shapes.entrySet()) {
				int[] s = e.getValue();
				c.shapes.put(e.getKey(), s == null ? null : s.clone());
			}
		} catch (CloneNotSupportedException e) {
			// Allowed for some objects not to be cloned.
		} catch (Throwable e) {
			if (e instanceof ClassNotFoundException) {
				// Fix to http://jira.diamond.ac.uk/browse/SCI-1644
				// Happens when cloning meta data with GridPreferences
			} if (e instanceof RuntimeException ) {
			   throw (RuntimeException)e;
			}
		}
		return c;
	}
	
	@Override
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	/**
	 * Calculate total number of items in given shape
	 * @param shape
	 * @return size
	 */
	public static int calcSize(final int[] shape) {
		long lsize = calcLongSize(shape);

		// check to see if the size is larger than an integer, i.e. we can't allocate it
		if (lsize > Integer.MAX_VALUE) {
			throw new IllegalArgumentException("Size of the dataset is too large to allocate");
		}
		return (int) lsize;
	}

	/**
	 * Calculate total number of items in given shape
	 * @param shape
	 * @return size
	 */
	public static long calcLongSize(final int[] shape) {
		double dsize = 1.0;

		if (shape == null || shape.length == 0)  // special case of zero-rank shape 
			return 1;

		for (int i = 0; i < shape.length; i++) {
			// make sure the indexes isn't zero or negative
			if (shape[i] == 0) {
				return 0;
			} else if (shape[i] < 0) {
				throw new IllegalArgumentException(String.format(
						"The %d-th is %d which is an illegal argument as it is negative", i, shape[i]));
			}

			dsize *= shape[i];
		}

		// check to see if the size is larger than an integer, i.e. we can't allocate it
		if (dsize > Long.MAX_VALUE) {
			throw new IllegalArgumentException("Size of the dataset is too large to allocate");
		}
		return (long) dsize;
	}

}
