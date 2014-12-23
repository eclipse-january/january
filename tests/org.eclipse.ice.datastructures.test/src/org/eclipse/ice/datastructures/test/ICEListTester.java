/*******************************************************************************
 * Copyright (c) 2012, 2014 UT-Battelle, LLC.
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
package org.eclipse.ice.datastructures.test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import org.eclipse.ice.datastructures.ICEObject.ICEJAXBHandler;
import org.eclipse.ice.datastructures.ICEObject.ICEList;

/**
 * <!-- begin-UML-doc -->
 * <p>
 * This class is responsible for testing the ICEList class. It checks that the
 * ICEList generic container works for Strings, Integers and Doubles.
 * </p>
 * <!-- end-UML-doc -->
 * 
 * @author Jay Jay Billings
 * @generated 
 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ICEListTester {
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation checks that the ICEList works for Strings.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkStrings() {
		// begin-user-code

		// Local Declarations
		ICEList<String> iceList = new ICEList<String>();
		ArrayList<String> inputList = new ArrayList<String>(), outputList = null;

		// Add some strings to the list
		inputList.add("The Next Contestant");
		inputList.add("I don't know the names of any more Nickelback songs");
		inputList.add("Honest");

		// Setup the list container
		iceList.setList(inputList);
		outputList = iceList.getList();

		// Check the list
		assertNotNull(outputList);
		assertEquals(inputList, outputList);

		// Check for XMLPersistence

		// create an instance of ICEJAXBHandler and outputStream
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ICEJAXBHandler manipulator = new ICEJAXBHandler();

		// try to persist
		try {
			manipulator.write(iceList, os);
		} catch (Exception e) {
			// Should not happen
			e.printStackTrace();
			fail();
		}

		// Reroute outputStream to InputStream
		ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());

		// Read in
		ICEList iceList2 = null;

		try {
			iceList2 = (ICEList) manipulator.read(ICEList.class, is);
		} catch (Exception e) {
			// Should not happen
			System.out.println(e.getMessage());
			fail();
		}

		// Check contents
		assertEquals("The Next Contestant", iceList2.getList().get(0));
		assertEquals("I don't know the names of any more Nickelback songs",
				iceList2.getList().get(1));
		assertEquals("Honest", iceList2.getList().get(2));

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation checks that the ICEList works for Strings.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkInt() {
		// begin-user-code

		// Local Declarations
		ICEList<Integer> iceList = new ICEList<Integer>();
		ArrayList<Integer> inputList = new ArrayList<Integer>(), outputList = null;

		// Add some strings to the list
		inputList.add(1);
		inputList.add(99);
		inputList.add(50);

		// Setup the list container
		iceList.setList(inputList);
		outputList = iceList.getList();

		// Check the list
		assertNotNull(outputList);
		assertEquals(inputList, outputList);

		// create an instance of ICEJAXBHandler and outputStream
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ICEJAXBHandler manipulator = new ICEJAXBHandler();

		// try to persist
		try {
			manipulator.write(iceList, os);
		} catch (Exception e) {
			// Should not happen
			System.out.println(e.getMessage());
			fail();
		}

		// check contents of OutputStream

		// Reroute outputStream to InputStream
		ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());

		// Read in
		ICEList iceList2 = null;

		try {
			iceList2 = (ICEList) manipulator.read(ICEList.class, is);
		} catch (Exception e) {
			// Should not happen
			System.out.println(e.getMessage());
			fail();
		}

		// Check contents
		assertEquals(1, iceList2.getList().get(0));
		assertEquals(99, iceList2.getList().get(1));
		assertEquals(50, iceList2.getList().get(2));

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation checks that the ICEList works for Strings.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkDouble() {
		// begin-user-code

		// Local Declarations
		ICEList<Double> iceList = new ICEList<Double>();
		ArrayList<Double> inputList = new ArrayList<Double>(), outputList = null;

		// Add some strings to the list
		inputList.add(1.0);
		inputList.add(99.9);
		inputList.add(50.50);

		// Setup the list container
		iceList.setList(inputList);
		outputList = iceList.getList();

		// Check the list
		assertNotNull(outputList);
		assertEquals(inputList, outputList);

		// create an instance of ICEJAXBHandler and outputStream
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ICEJAXBHandler manipulator = new ICEJAXBHandler();

		// try to persist
		try {
			manipulator.write(iceList, os);
		} catch (Exception e) {
			// Should not happen
			System.out.println(e.getMessage());
			fail();
		}

		// Reroute outputStream to InputStream
		ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());

		// Read in
		ICEList iceList2 = null;

		try {
			iceList2 = (ICEList) manipulator.read(ICEList.class, is);
		} catch (Exception e) {
			// Should not happen
			System.out.println(e.getMessage());
			fail();
		}

		// Check contents
		assertEquals(1.0, iceList2.getList().get(0));
		assertEquals(99.9, iceList2.getList().get(1));
		assertEquals(50.50, iceList2.getList().get(2));

		// end-user-code
	}
}