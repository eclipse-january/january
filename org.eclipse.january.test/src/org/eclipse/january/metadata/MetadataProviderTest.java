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

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import org.eclipse.january.MetadataException;
import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.junit.Assert;
import org.junit.Test;

public class MetadataProviderTest {

	@Test
	public void testGetMetadata() throws MetadataException {
		Dataset mdp = DatasetFactory.zeros(2, 3);

		// add IMetadata
		mdp.addMetadata(new Metadata());
		Assert.assertTrue(mdp.getMetadata() instanceof IMetadata);
		mdp.clearMetadata(null);

		// add sub-class of IMetadata
		mdp.addMetadata(new InnerMetadata());
		System.err.println(mdp.getMetadata());
		Assert.assertTrue(mdp.getMetadata() instanceof IMetadata);
		Assert.assertTrue(mdp.getMetadata() instanceof IInnerMetadata);
		mdp.clearMetadata(null);
	}

	interface IInnerMetadata extends IMetadata {

	}

	static class InnerMetadata implements IInnerMetadata {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1450311703714047058L;

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
