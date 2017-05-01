/*******************************************************************************
 * Copyright (c) 2013, 2016- UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation -
 *   Jay Jay Billings
 *******************************************************************************/
package org.eclipse.january.datastructures.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.january.form.IJAXBClassProvider;
import org.junit.Ignore;
import org.junit.Test;
import org.osgi.framework.BundleException;

/**
 * This class tests the static interface operation
 * IJAXBClassProvider.getJAXBProviders().
 *
 * @author Jay Jay Billings
 *
 */
public class IJAXBClassProviderTester {

	/**
	 * Test for
	 * {@link org.eclipse.january.form.IJAXBClassProvider}
	 * .
	 *
	 * @throws CoreException
	 * @throws BundleException
	 * @throws ClassNotFoundException
	 * @throws URISyntaxException
	 * @throws FileNotFoundException
	 */
	// This test fails in the Tycho build, so it is disabled by default.
	@Ignore
	@Test
	public void test() throws CoreException, BundleException,
			ClassNotFoundException, URISyntaxException, FileNotFoundException {

		IJAXBClassProvider[] jaxbProviders = null;
		String id = "org.eclipse.ice.datastructures.jaxbClassProvider";
		IExtensionPoint point = Platform.getExtensionRegistry()
				.getExtensionPoint(id);

		// If the point is available, create all the builders and load them into
		// the array.
		IConfigurationElement[] elements = point.getConfigurationElements();
		jaxbProviders = new IJAXBClassProvider[elements.length];
		for (int i = 0; i < elements.length; i++) {
			jaxbProviders[i] = (IJAXBClassProvider) elements[i]
					.createExecutableExtension("class");
		}

		// Simply get the providers from the registry and make sure they are
		// actually there.
		IJAXBClassProvider[] providers = IJAXBClassProvider.getJAXBProviders();
		assertNotNull(providers);
		assertTrue(providers.length > 0);

		return;
	}

}
