/*-
 *******************************************************************************
 * Copyright (c) 2017 Diamond Light Source Ltd.
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
import java.util.Collection;
import java.util.Map;

import org.eclipse.january.MetadataException;
import org.eclipse.january.dataset.LazyDatasetBase;
import org.junit.Assert;
import org.junit.Test;

public class MetadataTest {

	@Test
	public void testIMetadata() {
		Assert.assertEquals(IMetadata.class, LazyDatasetBase.findMetadataTypeSubInterfaces(IMetadata.class));
		Assert.assertEquals(IInnerMetadata.class, LazyDatasetBase.findMetadataTypeSubInterfaces(IInnerMetadata.class));
		Assert.assertEquals(IInnerMetadata.class, LazyDatasetBase.findMetadataTypeSubInterfaces(InnerMetadata.class));
		Assert.assertTrue(IMetadata.class.isAssignableFrom(IInnerMetadata.class));

		IInnerMetadata md = new IInnerMetadata() {
			private static final long serialVersionUID = 1L;

			@Override
			public IInnerMetadata clone() {
				return null;
			}

			@Override
			public void setMetadata(Map<String, ? extends Serializable> map) {
			}

			@Override
			public void setFilePath(String filename) {
			}

			@Override
			public void initialize(Map<String, ? extends Serializable> metadata) {
			}

			@Override
			public Collection<Serializable> getUserObjects() {
				return null;
			}

			@Override
			public Serializable getMetaValue(String key) throws MetadataException {
				return null;
			}

			@Override
			public Collection<String> getMetaNames() throws MetadataException {
				return null;
			}

			@Override
			public String getFilePath() {
				return null;
			}

			@Override
			public Map<String, Integer> getDataSizes() {
				return null;
			}

			@Override
			public Map<String, int[]> getDataShapes() {
				return null;
			}

			@Override
			public Collection<String> getDataNames() {
				return null;
			}

			@Override
			public void addNames(Collection<String> names) {
			}

			@Override
			public void addDataInfo(String n, int... shape) {
			}
		};
		Assert.assertEquals(IInnerMetadata.class, LazyDatasetBase.findMetadataTypeSubInterfaces(md.getClass()));
	}

	interface IInnerMetadata extends IMetadata {

	}

	static class InnerMetadata implements IInnerMetadata {
		private static final long serialVersionUID = 6375564863874875635L;

		@Override
		public void initialize(Map<String, ? extends Serializable> metadata) {
		}

		@Override
		public String getFilePath() {
			return null;
		}

		@Override
		public Collection<String> getDataNames() {
			return null;
		}

		@Override
		public Map<String, Integer> getDataSizes() {
			return null;
		}

		@Override
		public Map<String, int[]> getDataShapes() {
			return null;
		}

		@Override
		public Serializable getMetaValue(String key) throws MetadataException {
			return null;
		}

		@Override
		public Collection<String> getMetaNames() throws MetadataException {
			return null;
		}

		@Override
		public Collection<Serializable> getUserObjects() {
			return null;
		}

		@Override
		public IMetadata clone() {
			return null;
		}

		@Override
		public void setFilePath(String filename) {
		}

		@Override
		public void addDataInfo(String n, int... shape) {
		}

		@Override
		public void addNames(Collection<String> names) {
		}

		@Override
		public void setMetadata(Map<String, ? extends Serializable> map) {
		}
	}
}
