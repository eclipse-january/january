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

import java.util.HashMap;
import java.util.Map;

/**
 * This is a simple, map-based implementation of the IVisitHandler.
 * @author Jay Jay Billings
 *
 */
public class BasicVisitHandler implements IVisitHandler {

	/**
	 * The map that is used to associate classes with visitors.
	 */
	private Map<Class, IVisitor> visitorMap;

	/**
	 * The Constructor
	 */
	public BasicVisitHandler() {
		visitorMap = new HashMap<Class,IVisitor>();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.january.form.IVisitHandler#set(java.lang.Class, org.eclipse.january.form.IVisitor)
	 */
	@Override
	public void set(Class classType, IVisitor visitor) {
		visitorMap.put(classType,visitor);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.january.form.IVisitHandler#visit(java.lang.Object)
	 */
	@Override
	public void visit(Object objectToVisit) {
		visitorMap.get(objectToVisit.getClass()).visit(objectToVisit);
	}

}
