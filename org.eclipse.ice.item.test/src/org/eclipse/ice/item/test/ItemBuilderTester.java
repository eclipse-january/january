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
package org.eclipse.ice.item.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.ice.item.ItemBuilder;
import org.junit.Test;

/**
 * This class tests the static interface operation
 * ItemBuilder.getItemBuilders().
 *
 * @author Jay Jay Billings
 *
 */
public class ItemBuilderTester {

	/**
	 * Test for {@link org.eclipse.ice.item.ItemBuilder#getItemBuilders()}.
	 *
	 * @throws CoreException
	 */
	@Test
	public void test() throws CoreException {
		// Simply get the builders from the registry and make sure they are
		// actually there.
		ItemBuilder[] builders = ItemBuilder.getItemBuilders();
		assertNotNull(builders);
		assertTrue(builders.length > 0);
		return;
	}

}
