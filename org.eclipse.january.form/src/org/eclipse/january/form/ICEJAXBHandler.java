/*******************************************************************************
 * Copyright (c) 2012, 2016 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation -
 *   Jay Jay Billings
 *******************************************************************************/
package org.eclipse.january.form;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * This class is responsible for reading and writing JAXB-annotated classes into
 * and out of ICE.
 *
 * @author Jay Jay Billings
 */
public class ICEJAXBHandler {

	/**
	 * This operation reads an instance of a particular class type from the
	 * input stream into a Java Object.
	 *
	 * @param classList
	 *            The class list from which JAXB annotations should be read.
	 * @param inputStream
	 *            An InputStream from which the XML should be read by JAXB.
	 * @return An Object that is an instance of the Class that was parsed from
	 *         the XML InputStream.
	 * @throws NullPointerException
	 * @throws JAXBException
	 * @throws IOException
	 */
	public Object read(ArrayList<Class> classList, InputStream inputStream)
			throws NullPointerException, JAXBException, IOException {

		// Initialize local variables
		JAXBContext context;
		Class[] clazzArray = {};

		// If the input args are null, throw an exception
		if (classList == null) {
			throw new NullPointerException("NullPointerException: "
					+ "objectClass argument can not be null");
		}
		if (inputStream == null) {
			throw new NullPointerException("NullPointerException: "
					+ "inputStream argument can not be null");
		}

		// Create new instance of object from file and then return it.
		context = JAXBContext.newInstance(classList.toArray(clazzArray));
		Unmarshaller unmarshaller = context.createUnmarshaller();
		// New object created
		Object dataFromFile = unmarshaller.unmarshal(inputStream);

		// Return object
		return dataFromFile;

	}

	/**
	 * This operation writes an instance of a particular class type from the
	 * input stream into a Java Object. This operation requires both the Object
	 * and the specific class type because some classes, such as local classes,
	 * do return the appropriate class type from a call to "this.getClass()."
	 *
	 * @param dataObject
	 *            An Object that is an instance of the Class that is parsed to
	 *            create the XML InputStream.
	 * @param classList
	 * @param outputStream
	 *            An OutputStream to which the XML should be written by JAXB.
	 * @throws NullPointerException
	 * @throws JAXBException
	 * @throws IOException
	 */
	public void write(Object dataObject, ArrayList<Class> classList,
			OutputStream outputStream) throws NullPointerException,
			JAXBException, IOException {

		JAXBContext jaxbContext = null;
		Class[] classArray = {};

		// Throw exceptions if input args are null
		if (dataObject == null) {
			throw new NullPointerException(
					"NullPointerException: dataObject can not be null");
		}
		if (outputStream == null) {
			throw new NullPointerException(
					"NullPointerException: outputStream can not be null");
		}

		// Create the class list with which to initialize the context. If the
		// data object is an ListComponent, it is important to give it
		// both the type of the container and the generic.
		if (dataObject instanceof ListComponent) {
			// Cast the object to a generic, type-less list
			ListComponent list = (ListComponent) dataObject;
			// Don't pop the container open if it is empty
			if (list.size() > 0 && !classList.contains(ListComponent.class)) {
				classList.add(ListComponent.class);
				classList.add(list.get(0).getClass());
			}
		} else if (!dataObject.getClass().isAnonymousClass()) {
			// Otherwise just get the class if it is not anonymous
			classList.add(dataObject.getClass());
		} else {
			// Or get the base class if it is anonymous
			classList.add(dataObject.getClass().getSuperclass());
		}

		// Create the context and marshal the data if classes were determined
		if (classList.size() > 0) {
			jaxbContext = JAXBContext
					.newInstance(classList.toArray(classArray));
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
					Boolean.TRUE);
			// Write to file
			marshaller.marshal(dataObject, outputStream);
		}

		return;
	}
}