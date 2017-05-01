/*******************************************************************************
 * Copyright (c) 2012, 2016 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - Jay Jay Billings,
 *   Jordan H. Deyton, Dasha Gorin, Alexander J. McCaskey, Taylor Patterson,
 *   Claire Saunders, Matthew Wang, Anna Wojtowicz
 *******************************************************************************/
package org.eclipse.january.datastructures.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import org.eclipse.january.form.JanuaryJAXBHandler;
import org.eclipse.january.form.JanuaryList;
import org.junit.Test;

/**
 * <p>
 * This class is responsible for testing the JanuaryList class. It checks that the
 * JanuaryList generic container works for Strings, Integers and Doubles.
 * </p>
 * 
 * @author Jay Jay Billings
 */
public class JanuaryListTester {
	/**
	 * <p>
	 * This operation checks that the JanuaryList works for Strings.
	 * </p>
	 * 
	 */
	@Test
	public void checkStrings() {

		// Local Declarations
		JanuaryList<String> JanuaryList = new JanuaryList<String>();
		ArrayList<String> inputList = new ArrayList<String>(), outputList = null;
		JanuaryJAXBHandler xmlHandler = new JanuaryJAXBHandler();
		ArrayList<Class> classList = new ArrayList<Class>();
		classList.add(JanuaryList.class);

		// Add some strings to the list
		inputList.add("The Next Contestant");
		inputList.add("I don't know the names of any more Nickelback songs");
		inputList.add("Honest");

		// Setup the list container
		JanuaryList.setList(inputList);
		outputList = JanuaryList.getList();

		// Check the list
		assertNotNull(outputList);
		assertEquals(inputList, outputList);

		// Check for XMLPersistence

		// create an instance of JanuaryJAXBHandler and outputStream
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		JanuaryJAXBHandler manipulator = new JanuaryJAXBHandler();

		// try to persist
		try {
			manipulator.write(JanuaryList,classList, os);
		} catch (Exception e) {
			// Should not happen
			e.printStackTrace();
			fail();
		}

		// Reroute outputStream to InputStream
		ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());

		// Read in
		JanuaryList JanuaryList2 = null;

		try {
			JanuaryList2 = (JanuaryList) manipulator.read(classList, is);
		} catch (Exception e) {
			// Should not happen
			System.out.println(e.getMessage());
			fail();
		}

		// Check contents
		assertEquals("The Next Contestant", JanuaryList2.getList().get(0));
		assertEquals("I don't know the names of any more Nickelback songs",
				JanuaryList2.getList().get(1));
		assertEquals("Honest", JanuaryList2.getList().get(2));

	}

	/**
	 * <p>
	 * This operation checks that the JanuaryList works for Strings.
	 * </p>
	 * 
	 */
	@Test
	public void checkInt() {

		// Local Declarations
		JanuaryList<Integer> JanuaryList = new JanuaryList<Integer>();
		ArrayList<Integer> inputList = new ArrayList<Integer>(), outputList = null;
		JanuaryJAXBHandler xmlHandler = new JanuaryJAXBHandler();
		ArrayList<Class> classList = new ArrayList<Class>();
		classList.add(JanuaryList.class);

		// Add some strings to the list
		inputList.add(1);
		inputList.add(99);
		inputList.add(50);

		// Setup the list container
		JanuaryList.setList(inputList);
		outputList = JanuaryList.getList();

		// Check the list
		assertNotNull(outputList);
		assertEquals(inputList, outputList);

		// create an instance of JanuaryJAXBHandler and outputStream
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		JanuaryJAXBHandler manipulator = new JanuaryJAXBHandler();

		// try to persist
		try {
			manipulator.write(JanuaryList, classList, os);
		} catch (Exception e) {
			// Should not happen
			System.out.println(e.getMessage());
			fail();
		}

		// check contents of OutputStream

		// Reroute outputStream to InputStream
		ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());

		// Read in
		JanuaryList JanuaryList2 = null;

		try {
			JanuaryList2 = (JanuaryList) manipulator.read(classList, is);
		} catch (Exception e) {
			// Should not happen
			System.out.println(e.getMessage());
			fail();
		}

		// Check contents
		assertEquals(1, JanuaryList2.getList().get(0));
		assertEquals(99, JanuaryList2.getList().get(1));
		assertEquals(50, JanuaryList2.getList().get(2));

	}

	/**
	 * <p>
	 * This operation checks that the JanuaryList works for Strings.
	 * </p>
	 * 
	 */
	@Test
	public void checkDouble() {

		// Local Declarations
		JanuaryList<Double> JanuaryList = new JanuaryList<Double>();
		ArrayList<Double> inputList = new ArrayList<Double>(), outputList = null;
		JanuaryJAXBHandler xmlHandler = new JanuaryJAXBHandler();
		ArrayList<Class> classList = new ArrayList<Class>();
		classList.add(JanuaryList.class);

		// Add some strings to the list
		inputList.add(1.0);
		inputList.add(99.9);
		inputList.add(50.50);

		// Setup the list container
		JanuaryList.setList(inputList);
		outputList = JanuaryList.getList();

		// Check the list
		assertNotNull(outputList);
		assertEquals(inputList, outputList);

		// create an instance of JanuaryJAXBHandler and outputStream
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		JanuaryJAXBHandler manipulator = new JanuaryJAXBHandler();

		// try to persist
		try {
			manipulator.write(JanuaryList, classList, os);
		} catch (Exception e) {
			// Should not happen
			System.out.println(e.getMessage());
			fail();
		}

		// Reroute outputStream to InputStream
		ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());

		// Read in
		JanuaryList JanuaryList2 = null;

		try {
			JanuaryList2 = (JanuaryList) manipulator.read(classList, is);
		} catch (Exception e) {
			// Should not happen
			System.out.println(e.getMessage());
			fail();
		}

		// Check contents
		assertEquals(1.0, JanuaryList2.getList().get(0));
		assertEquals(99.9, JanuaryList2.getList().get(1));
		assertEquals(50.50, JanuaryList2.getList().get(2));

	}
}