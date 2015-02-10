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

package org.eclipse.dawnsci.analysis.api.dataset;

import java.util.List;

import org.eclipse.dawnsci.analysis.api.metadata.IMetadata;
import org.eclipse.dawnsci.analysis.api.metadata.MetadataType;

/**
 * Interface which acts to provide metadata from an object
 */
public interface IMetadataProvider {

	/**
	 * @return an instance of IMetadata
	 * @throws Exception
	 */
	public IMetadata getMetadata() throws Exception;

	/**
	 * @param clazz if null return everything
	 * @return list of metadata with given class
	 * @throws Exception
	 */
	public <T extends MetadataType> List<T> getMetadata(Class<T> clazz) throws Exception;
}
