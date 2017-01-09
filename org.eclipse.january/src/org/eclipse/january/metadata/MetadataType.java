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

import java.io.Serializable;

import org.eclipse.january.dataset.IMetadataProvider;

/**
 * This is a marker interface for all metadata items which can be associated
 * with a dataset.
 * <p>
 * All sub-interfaces must have an initialize method and all implementations
 * must have a null constructor.
 * <p>
 * Extending sub-interfaces of MetadataType is strongly discouraged. That is,
 * metadata interfaces (sub-interfaces of MetadataType) should be considered
 * to be "final". This simplifies the implementation of {@link IMetadataProvider#getMetadata(Class)}, etc.
 */
public interface MetadataType extends Serializable, Cloneable {

	/**
	 * Make a deep copy of metadata
	 * @return clone
	 */
	public MetadataType clone();
}
