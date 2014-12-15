/*******************************************************************************
 * Copyright (c) 2011, 2014 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - Jay Jay Billings
 *******************************************************************************/
package org.eclipse.ice.datastructures.ICEObject;

import org.eclipse.ice.datastructures.componentVisitor.IComponentVisitor;

/**
 * This class...
 * @author Jay Jay Billings
 *
 */
public abstract class AbstractListComponent<T> implements Component, Cloneable {

	@Override
	public abstract Object clone();
	
	@Override
	public abstract void update(String updatedKey, String newValue);

	@Override
	public abstract void register(IUpdateableListener listener);

	@Override
	public abstract void unregister(IUpdateableListener listener);

	@Override
	public abstract void setId(int id);

	@Override
	public abstract String getDescription();

	@Override
	public abstract int getId();

	@Override
	public abstract void setName(String name);

	@Override
	public abstract String getName();

	@Override
	public abstract void setDescription(String description);

	@Override
	public abstract void accept(IComponentVisitor visitor);
}
