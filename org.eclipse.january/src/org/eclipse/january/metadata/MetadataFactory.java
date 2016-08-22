/*******************************************************************************
 * Copyright (c) 2016 Diamond Light Source Ltd. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Diamond Light Source Ltd - initial API and implementation
 *******************************************************************************/
package org.eclipse.january.metadata;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.january.MetadataException;
import org.eclipse.january.dataset.LazyDatasetBase;
import org.eclipse.january.metadata.internal.AxesMetadataImpl;
import org.eclipse.january.metadata.internal.DimensionMetadataImpl;
import org.eclipse.january.metadata.internal.ErrorMetadataImpl;
import org.eclipse.january.metadata.internal.MaskMetadataImpl;
import org.eclipse.january.metadata.internal.OriginMetadataImpl;
import org.eclipse.january.metadata.internal.PeemMetadataImpl;

public class MetadataFactory {

	private MetadataFactory() {
	}

	static Map<Class<? extends MetadataType>, Class<? extends MetadataType>> metadataClasses = createMap();
	private static Map<Class<? extends MetadataType>, Class<? extends MetadataType>> createMap() {
		Map<Class<? extends MetadataType>, Class<? extends MetadataType>> map = new HashMap<Class<? extends MetadataType>, Class<? extends MetadataType>>();
		map.put(IMetadata.class, Metadata.class);
		map.put(ErrorMetadata.class, ErrorMetadataImpl.class);
		map.put(AxesMetadata.class, AxesMetadataImpl.class);
		map.put(DimensionMetadata.class, DimensionMetadataImpl.class);
		map.put(MaskMetadata.class, MaskMetadataImpl.class);
		map.put(OriginMetadata.class, OriginMetadataImpl.class);
		map.put(PeemMetadata.class, PeemMetadataImpl.class);
		return map;
	}

	
	/**
	 * Create a metadata object of given class with given arguments
	 * @param clazz
	 * @param arguments these must match the arguments given in the initialize method specified in the class
	 * @return metadata object or null if type not available
	 * @throws MetadataException if the class cannot be instantiated, the initialize method does not exist, or
	 *  the initialize method could not be called successfully
	 */
	public static <T extends MetadataType> T createMetadata(Class<T> clazz, Object... arguments) throws MetadataException {
		@SuppressWarnings("unchecked")
		Class<T> mdClass = (Class<T>) metadataClasses.get(clazz);
		if (mdClass == null) {
			return null;
		}

		T obj = null;
		try {
			obj = mdClass.newInstance();
		} catch (Exception e) {
			throw new MetadataException("Could not create metadata object", e);
		}

		try {
			for (Method m : mdClass.getMethods()) {
				if (m.getName().equals("initialize")) {
					m.invoke(obj, arguments);
					return obj;
				}
			}
		} catch (Exception e) {
			throw new MetadataException("Could not initialize object", e);
		}
		throw new MetadataException("Could not find initialize method");
	}

	/**
	 * Register metadata class
	 * @param clazz
	 */
	public static <T extends MetadataType> void registerClass(Class<T> clazz) {
		Class<? extends MetadataType> iClass = LazyDatasetBase.findMetadataTypeSubInterfaces(clazz);

		metadataClasses.put(iClass, clazz);
	}
}
