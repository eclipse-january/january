package org.eclipse.january.metadata;

import org.eclipse.january.MetadataException;
import org.eclipse.january.dataset.LazyDatasetBase;
import org.eclipse.january.metadata.internal.ErrorMetadataImpl;
import org.junit.Assert;
import org.junit.Test;

public class MetadataFactoryTest {

	@Test
	public void testFinder() {
		Class<? extends MetadataType> clazz = LazyDatasetBase.findMetadataTypeSubInterfaces(IExtendedMetadata.class);
		Assert.assertEquals(IExtendedMetadata.class, clazz);
	}

	@Test
	public void testCreator() throws MetadataException {
		ErrorMetadata emd = MetadataFactory.createMetadata(ErrorMetadata.class);
		Assert.assertEquals(new ErrorMetadataImpl().getError(), emd.getError());
	}

}
