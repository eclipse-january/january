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
		Assert.assertEquals(DynamicConnectionInfo.class, clazz);

		// this interface is a sub-interface of DimensionMetadata
		clazz = LazyDatasetBase.findMetadataTypeSubInterfaces(OriginMetadataImpl.class);
		Assert.assertEquals(OriginMetadata.class, clazz);

		// test for anonymous class
		clazz = LazyDatasetBase.findMetadataTypeSubInterfaces(new DynamicConnectionInfo() {
			private static final long serialVersionUID = 3467617639382611191L;
			
		}.getClass());
		Assert.assertEquals(DynamicConnectionInfo.class, clazz);

		// test for inner class
		clazz = LazyDatasetBase.findMetadataTypeSubInterfaces(new InnerMetadata().getClass());
		Assert.assertEquals(InnerMetadata.class, clazz);

		// test for inner class
		clazz = LazyDatasetBase.findMetadataTypeSubInterfaces(new InnerMetadata2().getClass());
		Assert.assertEquals(InnerMetadata2.class, clazz);
	}

	class InnerMetadata implements MetadataType {
		private static final long serialVersionUID = 93680612340323601L;

		public InnerMetadata() {
		}

		@Override
		public InnerMetadata clone() {
			return new InnerMetadata();
		}
	}

	static class InnerMetadata2 implements MetadataType {
		private static final long serialVersionUID = 93680612340323601L;

		public InnerMetadata2() {
		}

		@Override
		public InnerMetadata2 clone() {
			return new InnerMetadata2();
		}
	}

	@Test
	public void testCreator() throws MetadataException {
		ErrorMetadata emd = MetadataFactory.createMetadata(ErrorMetadata.class);
		Assert.assertEquals(new ErrorMetadataImpl().getError(), emd.getError());
	}
}
