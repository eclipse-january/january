/*******************************************************************************
 * Copyright (c) 2016 Diamond Light Source Ltd. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.january.metadata;

import org.eclipse.january.MetadataException;
import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.junit.Assert;
import org.junit.Test;

/** test class introduced to verify performance of relaxed implementation of IDataset.getMetadata() which 
 * now matches signature of IDataset.setMetadata()
 *
 */
public class PlainMetadataTest {

	@Test
	public void testPlainMetadata() throws MetadataException {
		Dataset mdp = DatasetFactory.zeros(2, 3);

		// check empty
		Assert.assertNull("Metadata should be empty", mdp.getMetadata());
		Assert.assertNull("Metadata should be empty", mdp.getMetadata(PlainMetadata.class));
		
		// set metadata
		mdp.setMetadata(new PlainMetadata());
		
		// check not empty
		Assert.assertNotNull("Metadata should not be empty (general)", mdp.getMetadata());
		Assert.assertNotNull("Metadata should not be empty (specific)", mdp.getMetadata(PlainMetadata.class));
		Assert.assertNull("Metadata should be empty (type not present)", mdp.getMetadata(Metadata.class));
	}

	protected class PlainMetadata implements MetadataType
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public PlainMetadata clone()
		{
			return new PlainMetadata();
		}
		
	}
	
}
