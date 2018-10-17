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

package org.eclipse.january.dataset;

import java.util.List;

import org.eclipse.january.MetadataException;
import org.eclipse.january.metadata.IMetadata;
import org.eclipse.january.metadata.MetadataType;

/**
 * Interface which acts to provide metadata from an object
 */
public interface IMetadataProvider {

	/**
	 * @deprecated Use {@code getFirstMetadata(IMetadata.class)} instead
	 * @return an instance of IMetadata
	 * @throws Exception
	 */
	@Deprecated
	public IMetadata getMetadata() throws Exception;

	/**
	 * @param clazz if null return everything
	 * @return list of metadata with given class (or its super interface)
	 * @throws MetadataException
	 */
	public <S extends MetadataType, T extends S> List<S> getMetadata(Class<T> clazz) throws MetadataException;

	/**
	 * @param clazz if null return first from everything
	 * @return first element from list of metadata with given class (or its super interface)
	 */
	public <S extends MetadataType, T extends S> S getFirstMetadata(Class<T> clazz);
}
