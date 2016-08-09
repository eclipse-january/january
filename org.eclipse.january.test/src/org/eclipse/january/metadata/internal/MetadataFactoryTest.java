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
package org.eclipse.january.metadata.internal;

import org.eclipse.january.MetadataException;
import org.eclipse.january.dataset.LazyDatasetBase;
import org.eclipse.january.metadata.DynamicConnectionInfo;
import org.eclipse.january.metadata.ErrorMetadata;
import org.eclipse.january.metadata.IExtendedMetadata;
import org.eclipse.january.metadata.MetadataFactory;
import org.eclipse.january.metadata.MetadataType;
import org.eclipse.january.metadata.OriginMetadata;
import org.eclipse.january.metadata.internal.ErrorMetadataImpl;
import org.junit.Assert;
import org.junit.Test;

public class MetadataFactoryTest {

	@Test
	public void testFinder() throws MetadataException {
		Class<? extends MetadataType> clazz = LazyDatasetBase.findMetadataTypeSubInterfaces(IExtendedMetadata.class);
		Assert.assertEquals(IExtendedMetadata.class, clazz);

		clazz = LazyDatasetBase.findMetadataTypeSubInterfaces(DynamicConnectionInfo.class);
		Assert.assertEquals(MetadataType.class, clazz);

		// this interface is a sub-interface of DimensionMetadata
		clazz = LazyDatasetBase.findMetadataTypeSubInterfaces(OriginMetadataImpl.class);
		Assert.assertEquals(OriginMetadata.class, clazz);
	}

	@Test
	public void testCreator() throws MetadataException {
		ErrorMetadata emd = MetadataFactory.createMetadata(ErrorMetadata.class);
		Assert.assertEquals(new ErrorMetadataImpl().getError(), emd.getError());
	}
}
