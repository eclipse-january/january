/*-
 *******************************************************************************
 * Copyright (c) 2011, 2016 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Peter Chang - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.january.metadata;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.january.MetadataException;
import org.eclipse.january.dataset.ShapeUtils;


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
		initialize(metadata);
	}

	@Override
	public void initialize(Map<String, ? extends Serializable> metadata) {
		this.metadata = metadata;
	}

	@Override
	public void addNames(Collection<String> names) {
		if (names != null) {
			for (String n : names) {
				shapes.put(n, null);
			}
		}
	}

	/**
	 * Set metadata map
	 * @param metadata map
	 */
	@Override
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
	 * @param objects for user
	 */
	public void setUserObjects(Collection<Serializable> objects) {
		userObjects = objects;
	}

	public void addDataInfo(String name, int... shape) {
		shapes.put(name, shape);
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
				sizes.put(e.getKey(), ShapeUtils.calcSize(shape));
			else
				sizes.put(e.getKey(), null);
		}
		if (sizes.size() > 0) {
			return Collections.unmodifiableMap(sizes);
		}
		return null;
	}

	@Override
	public Serializable getMetaValue(String key) throws MetadataException {
		return metadata == null ? null : metadata.get(key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<String> getMetaNames() throws MetadataException {
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
						try (ObjectOutputStream oos = new ObjectOutputStream(os)) {
							oos.writeObject(v);
							try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(os.toByteArray()))) {
								Serializable nv = (Serializable) ois.readObject();
								md.put(k, nv);
							}
						}
						os.reset();
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

	@Override
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
