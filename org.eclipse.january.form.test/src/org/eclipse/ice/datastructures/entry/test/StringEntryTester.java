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

import static org.junit.Assert.assertTrue;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.january.form.StringEntry;
import org.junit.Test;

/**
 * The only thing not tested by AbstractEntryTester is the 
 * ability to clone, because it only exists on subclasses. So this 
 * tests the ability of StringEntry to clone. 
 * 
 * @author Alex McCaskey
 *
 */
public class StringEntryTester {

	/**
	 * This operation checks the Entry to ensure that its copy() and clone()
	 * operations work as specified.
	 */
	@Test
	public void checkCopying() {

		// Local Declarations
		StringEntry entry = new StringEntry();
		
		/*
		 * The following sets of operations will be used to test the
		 * "clone and copy" portion of Entry.
		 */
		entry.setId(6);
		entry.setName("Copy Test Entry");
		entry.setDescription("Fluffy Bunny");
		entry.setValue("8675309");
		entry.setComment("Peanut butter and jelly");
		entry.setTag("ChevyChase");
		entry.setRequired(true);

		// Create a new instance of Entry and copy contents
		StringEntry entryCopy = new StringEntry();
		entryCopy.copy(entry);

		// Check contents
		assertTrue(entry.equals(entryCopy));

		// Test to show valid usage of clone

		// Run clone operation
		StringEntry cloneEntry = (StringEntry) entry.clone();

		// Check contents
		assertTrue(entry.equals(cloneEntry));

		// Call copy with null, which should not change anything
		entry.copy(null);

		// Check contents - nothing has changed
		assertTrue(entry.equals(entryCopy));

		return;
	}
}
