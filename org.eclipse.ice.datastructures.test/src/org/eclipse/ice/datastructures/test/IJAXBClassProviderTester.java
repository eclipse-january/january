/*******************************************************************************
 * Copyright (c) 2013, 2014- UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation -
 *   Jay Jay Billings
 *******************************************************************************/
package org.eclipse.ice.datastructures.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.ice.datastructures.jaxbclassprovider.IJAXBClassProvider;
import org.junit.Test;

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
	 * {@link org.eclipse.ice.datastructures.jaxbclassprovider.IJAXBClassProvider}
	 * .
	 *
	 * @throws CoreException
	 */
	@Test
	public void test() throws CoreException {
		// Simply get the providers from the registry and make sure they are
		// actually there.
		IJAXBClassProvider[] providers = IJAXBClassProvider.getJAXBProviders();
		assertNotNull(providers);
		assertTrue(providers.length > 0);
		return;
	}

}
