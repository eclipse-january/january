/*******************************************************************************
 * Copyright (c) 2012, 2016- UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Initial API and implementation and/or initial documentation - Jay Jay Billings, 
 *    Jordan H. Deyton, Dasha Gorin, Alexander J. McCaskey, Taylor Patterson, 
 *    Claire Saunders, Matthew Wang, Anna Wojtowicz
 *     
 *******************************************************************************/
package org.eclipse.ice.datastructures.entry.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.january.form.ContinuousEntry;
import org.junit.Test;

/**
 * This class tests the ContinuousEntry. 
 * 
 * @author Alex McCaskey
 *
 */
public class ContinuousEntryTester {

	/**
	 * Check that this Entry only takes 2 allowed values: 
	 * a lower and upper bound. 
	 */
	@Test
	public void checkSetValue() {
		// Create the lower and upper bound
		List<String> bounds = new ArrayList<String>();
		bounds.add("1.2");
		bounds.add("55.5");
		
		// Create the Continuous Entry.
		ContinuousEntry entry = new ContinuousEntry();
		entry.setAllowedValues(bounds);
		
		// Assert that we can't set a value outside 
		// the range.
		assertFalse(entry.setValue("100.0"));
		
		// Assert we can set one inside the range
		assertTrue(entry.setValue("33.3"));
		assertEquals("33.3", entry.getValue());
		
		// Add a third allowed value, to invalidate it
		bounds.add("4444");
		assertFalse(entry.setValue("44"));
		
		bounds.remove(2);
		assertFalse(entry.setValue("not a number"));
	}
}
