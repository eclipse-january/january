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
package org.eclipse.ice.datastructures.ICEObject;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * <!-- begin-UML-doc -->
 * <p>
 * This class is responsible for reading and writing JAXB-annotated classes into
 * and out of ICE.
 * </p>
 * <!-- end-UML-doc -->
 * 
 * @author Jay Jay Billings
 * @generated 
 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ICEJAXBManipulator {
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation reads an instance of a particular class type from the
	 * input stream into a Java Object.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param objectClass
	 *            <p>
	 *            The Class from which JAXB annotations should be read.
	 *            </p>
	 * @param inputStream
	 *            <p>
	 *            An InputStream from which the XML should be read by JAXB.
	 *            </p>
	 * @return <p>
	 *         An Object that is an instance of the Class that was parsed from
	 *         the XML InputStream.
	 *         </p>
	 * @throws NullPointerException
	 * @throws JAXBException
	 * @throws IOException
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Object read(Class objectClass, InputStream inputStream)
			throws NullPointerException, JAXBException, IOException {
		// begin-user-code

		// Initialize local variables
		JAXBContext context;

		// If the input args are null, throw an exception
		if (objectClass == null) {
			throw new NullPointerException("NullPointerException: "
					+ "objectClass argument can not be null");
		}
		if (inputStream == null) {
			throw new NullPointerException("NullPointerException: "
					+ "inputStream argument can not be null");
		}

		// Create new instance of object from file and then return it.
		context = JAXBContext.newInstance(objectClass);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		// New object created
		Object dataFromFile = unmarshaller.unmarshal(inputStream);

		// Return object
		return dataFromFile;

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation writes an instance of a particular class type from the
	 * input stream into a Java Object. This operation requires both the Object
	 * and the specific class type because some classes, such as local classes,
	 * do return the appropriate class type from a call to "this.getClass()."
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param dataObject
	 *            <p>
	 *            An Object that is an instance of the Class that is parsed to
	 *            create the XML InputStream.
	 *            </p>
	 * @param outputStream
	 *            <p>
	 *            An OutputStream to which the XML should be written by JAXB.
	 *            </p>
	 * @throws NullPointerException
	 * @throws JAXBException
	 * @throws IOException
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void write(Object dataObject, OutputStream outputStream)
			throws NullPointerException, JAXBException, IOException {
		// begin-user-code

		JAXBContext jaxbContext = null;

		// Throw exceptions if input args are null
		if (dataObject == null) {
			throw new NullPointerException(
					"NullPointerException: dataObject can not be null");
		}
		if (outputStream == null) {
			throw new NullPointerException(
					"NullPointerException: outputStream can not be null");
		}
		// Create context from args and write a filled out object to file

		// If it is an anonymous class, then it needs to use the super class.
		// Otherwise, use runtime class.
		if (!dataObject.getClass().isAnonymousClass()) {
			jaxbContext = JAXBContext.newInstance(dataObject.getClass());
		} else {
			jaxbContext = JAXBContext.newInstance(dataObject.getClass()
					.getSuperclass());
		}

		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		// Write to file
		marshaller.marshal(dataObject, outputStream);

		// end-user-code
	}
}