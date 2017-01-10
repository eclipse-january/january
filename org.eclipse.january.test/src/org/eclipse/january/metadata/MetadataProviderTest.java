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
		Assert.assertTrue(mdp.getFirstMetadata(IMetadata.class) instanceof IMetadata);
		mdp.clearMetadata(null);

		// add sub-class of IMetadata
		mdp.addMetadata(new MetadataTest.InnerMetadata());
		System.err.println(mdp.getFirstMetadata(IMetadata.class));
		Assert.assertTrue(mdp.getFirstMetadata(IMetadata.class) instanceof IMetadata);
		Assert.assertTrue(mdp.getFirstMetadata(IMetadata.class) instanceof MetadataTest.IInnerMetadata);
		Assert.assertTrue(mdp.getFirstMetadata(MetadataTest.IInnerMetadata.class) instanceof MetadataTest.IInnerMetadata);
		mdp.clearMetadata(null);
	}
}
