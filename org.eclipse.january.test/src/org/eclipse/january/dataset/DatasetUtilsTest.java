/*-
 * Copyright (c) 2017 Kichwa Coders Ltd. and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import org.junit.Test;

public class DatasetUtilsTest {

	@Test(expected = IllegalArgumentException.class)
	public void testSplitException() {
		Dataset dataset = DatasetFactory.createFromObject(new Integer[] { 1, 2, 3 });
		int[] indices = { 1 };
		DatasetUtils.split(dataset, indices, 1);
	}

}
