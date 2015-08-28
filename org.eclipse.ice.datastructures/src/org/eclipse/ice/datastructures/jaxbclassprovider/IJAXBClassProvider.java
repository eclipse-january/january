/*******************************************************************************
 * Copyright (c) 2013, 2014 UT-Battelle, LLC.
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
package org.eclipse.ice.datastructures.jaxbclassprovider;

import java.util.List;

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
 * @author Alex McCaskey
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

}
