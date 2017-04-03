/*-
 *******************************************************************************
 * Copyright (c) 2011, 2014, 2016 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Matthew Gerring - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.january.examples.dataset;

import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.Random;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

/**
 * Examples for carrying errors through your calculations.
 * 
 * @author Matthew Gerring
 *
 */
public class ErrorExamples {

	
	@Rule
	public TestRule watcher = Utils.testWatcherCreator();
	
	@Before
	public void before() {
		Utils.suppressSLF4JError();
	}

	/**
	 * Set the error on some data.
	 */
	@Test
	public void setErrorSimple() {
		Dataset rand  = Random.rand(0, 100, new int[]{1024, 1024});
		Dataset error = Random.rand(0, 1,   new int[]{1024, 1024});
		
		rand.setErrors(error);
		// The error now stays with the data and can be retrieved, however:
		
		rand.idivide(10);
		error = rand.getErrors();
		
		// Error is not carried through calculations, the max is still ~1.0
		System.out.println(error.max());
	}
}
