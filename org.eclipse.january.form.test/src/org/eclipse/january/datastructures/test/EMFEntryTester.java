/*******************************************************************************
 * Copyright (c) 2014, 2016 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alex McCaskey (UT-Battelle, LLC.) - initial API and implementation and/or initial documentation
 *   Jay Jay Billings (UT-Battelle, LLC.) - modified to use ICETests directory
 *******************************************************************************/
package org.eclipse.january.datastructures.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.eclipse.january.form.emf.EMFEntry;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

/**
 * This class tests the EMFEntry. It checks its construction with a valid
 * EAttribute and containing EObject node, and that EMFEntries can be copied
 * correctly.
 * 
 * @author Alex McCaskey
 *
 */
public class EMFEntryTester {

	/**
	 * Reference to the XMLProcessor used to create an Ecore model from a valid
	 * XML schema file.
	 */
	private XMLProcessor processor;

	/**
	 * Reference to a test EAttribute to be used in the creation of an EMFEntry.
	 */
	private EAttribute attribute;

	/**
	 * Reference to the EMFEntry's containing Ecore model tree node.
	 */
	private EObject ecoreNode;

	/**
	 * This method is run before all tests and initializes an EMFEntry for
	 * testing.
	 */
	@Before
	public void before() {
		// Local Declarations
		String separator = System.getProperty("file.separator");
		String userDir = System.getProperty("user.home") + separator
				+ "JanuaryTests" + separator + "datastructuresData";
		String filePath = userDir + separator + "shiporder.xsd";
		processor = null;

		// Create the XMLProcessor
		try {
			processor = new XMLProcessor(URI.createFileURI(filePath));
		} catch (SAXException e) {
			e.printStackTrace();
			fail();
		}

		// Get those trees and make sure their names were
		// set correctly.
		EPackage shipOrderPackage = (EPackage) processor.getEPackageRegistry()
				.values().toArray()[0];

		// Walk the Tree to get a good EAttribute and EObject
		// to use in the creation of an EMFEntry
		TreeIterator<EObject> tree = shipOrderPackage.eAllContents();
		while (tree.hasNext()) {
			EObject obj = tree.next();

			if (obj instanceof EClass) {
				EClass eClass = (EClass) obj;
				if (eClass.getName().equals("ShiptoType")) {
					for (EAttribute a : eClass.getEAllAttributes()) {
						if (a.getName().equals("name")) {
							attribute = a;
							ecoreNode = EcoreUtil.create(eClass);
							break;
						}
					}
				}

			}
		}
	}

	/**
	 * Check that we can construct an EMFEntry which keeps track of normal ICE
	 * Entry data, but also keeps track of EAttribute data
	 */
	@Test
	public void checkConstruction() {

		// So now we got an EAttribute to test out
		EMFEntry entry = new EMFEntry(attribute, ecoreNode);
		assertTrue("name".equals(entry.getName()));
		assertTrue(entry.setValue("McCaskey"));
		assertTrue("McCaskey".equals(ecoreNode.eGet(attribute)));
	}

	/**
	 * Check that EMFEntries can be cloned and copied.
	 */
	@Test
	public void checkCopying() {
		EMFEntry entry = new EMFEntry(attribute, ecoreNode);
		EMFEntry clonedEntry = (EMFEntry) entry.clone();

		assertTrue(entry.equals(clonedEntry));
		assertTrue(entry.setValue("hello"));
		assertTrue("hello".equals(entry.getValue()));
		assertFalse("hello".equals(clonedEntry.getValue()));

	}

}
