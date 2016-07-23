/*******************************************************************************
 * Copyright (c) 2013, 2014, 2016 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation -
 *   Jay Jay Billings, Alexander J. McCaskey, Anna Wojtowicz, Menghan Li
 *******************************************************************************/
package org.eclipse.january.form;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The IJAXBClassProvider interface provides the methods necessary to inform
 * clients creating a JAXBContext object of the relevant classes that must be
 * known for succesfull marshalling/unmarshalling of XML data.
 *
 * Realizations of this interface must provide a valid name String that
 * describes the realization and a valid set of Java Class objects representing
 * the JAXB-annotated structures the JAXBContext must know about.
 *
 *
 * @author Alex McCaskey, Anna Wojtowicz, Jay Jay Billings, Menghan Li
 *
 */
public interface IJAXBClassProvider {

	/**
	 * Return the list of Classes that will be required in the creation of a
	 * JAXBContext.
	 *
	 * @return classList The list of Classes used in creating a JAXBContext
	 *         object.
	 */
	public List<Class> getClasses();

	/**
	 * Return the name of this IJAXBClassProvider.
	 *
	 * @return providerName The name of this IJAXBClassProvider
	 */
	public String getProviderName();

	/**
	 * This operation pulls the list of JAXB class providers from the registry
	 * for classes that need custom handling.
	 *
	 * @return The list of class providers.
	 * @throws CoreException
	 */
	public static IJAXBClassProvider[] getJAXBProviders() throws CoreException {

		// Logger for handling event messages and other information.
		Logger logger = LoggerFactory.getLogger(IJAXBClassProvider.class);
		IJAXBClassProvider[] jaxbProviders = null;
		String id = "org.eclipse.january.form.jaxbClassProvider";
		IExtensionPoint point = Platform.getExtensionRegistry()
				.getExtensionPoint(id);

		// If the point is available, create all the builders and load them into
		// the array.
		if (point != null) {
			IConfigurationElement[] elements = point.getConfigurationElements();
			jaxbProviders = new IJAXBClassProvider[elements.length];
			for (int i = 0; i < elements.length; i++) {
				jaxbProviders[i] = (IJAXBClassProvider) elements[i]
						.createExecutableExtension("class");
			}
		} else {
			logger.error("Extension Point " + id + " does not exist");
		}

		return jaxbProviders;
	}

}
