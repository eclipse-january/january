/*******************************************************************************
 * Copyright (c) 2013, 2014, 2016 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation -
 *   Jay Jay Billings
 *******************************************************************************/
package org.eclipse.ice.datastructures.test;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.january.form.IJAXBClassProvider;

/**
 * This is a fake JAXBClassProvider that is registered with the framework for
 * testing.
 *
 * @author Jay Jay Billings
 *
 */
public class FakeJAXBClassProvider implements IJAXBClassProvider {

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ice.datastructures.jaxbclassprovider.IJAXBClassProvider#
	 * getClasses()
	 */
	@Override
	public List<Class> getClasses() {
		List<Class> classList = new ArrayList<Class>();
		classList.add(this.getClass());
		return classList;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ice.datastructures.jaxbclassprovider.IJAXBClassProvider#
	 * getProviderName()
	 */
	@Override
	public String getProviderName() {
		return "Fake Class Provider";
	}

}
