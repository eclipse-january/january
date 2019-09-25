/*-
 * Copyright 2015, 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import java.util.Arrays;

import org.eclipse.january.asserts.TestUtils;
import org.junit.Assert;
import org.junit.Test;

public class LazyDynamicDatasetTest {

	class CountingListener implements IDataListener {
		int count = 0;

		@Override
		public void dataChangePerformed(DataEvent evt) {
			TestUtils.verbosePrintf("New shape: %s\n", Arrays.toString(evt.getShape()));
			count++;
		}
	}

	IDynamicDataset createDynamic() {
		IDynamicDataset lazy = new LazyDynamicDataset(null, "test", 1, IntegerDataset.class, new int[] {0,4}, new int[] {IDynamicDataset.UNLIMITED, 4});
		return lazy;
	}

	@Test
	public void testPeriodicChecker() {
		// start checker and wait given period then see if listener has been fired the correct number of times
		IDynamicDataset lazy = createDynamic();
		CountingListener counter = new CountingListener();
		lazy.addDataListener(counter);

		int period = 200;
		int repeat = 5;
		long total = (long) ((repeat + 0.1) * period); // include partial end period
		lazy.startUpdateChecker(period, null);
		try {
			Thread.sleep(total);
			lazy.startUpdateChecker(0, null); // switch off
		} catch (InterruptedException e) {
			Assert.fail("Sleep interrupted!");
		}
		Assert.assertEquals(repeat, counter.count);

		// try again
		counter.count = 0;
		lazy.startUpdateChecker(period, null);
		try {
			Thread.sleep(total);
			lazy.startUpdateChecker(0, null); // switch off
		} catch (InterruptedException e) {
			Assert.fail("Sleep interrupted!");
		}
		Assert.assertEquals(repeat, counter.count);
	}

	@Test
	public void testShapeChecker() {
		// start checker and trigger changes then see if listener has been fired the correct number of times
		IDynamicDataset lazy = createDynamic();
		CountingListener counter = new CountingListener();
		lazy.addDataListener(counter);

		int period = 200;
		int repeat = 5;
		for (int i = 1; i <= repeat; i++) {
			try {
				lazy.resize(i, 4);
				Thread.sleep(period);
			} catch (InterruptedException e) {
				Assert.fail("Sleep interrupted!");
			}
		}
		Assert.assertEquals(repeat, counter.count);
	}
}
