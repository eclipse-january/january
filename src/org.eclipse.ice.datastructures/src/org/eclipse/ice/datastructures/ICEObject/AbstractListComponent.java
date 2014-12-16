/*******************************************************************************
 * Copyright (c) 2011, 2014 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - Jay Jay 
 *   Billings
 *******************************************************************************/
package org.eclipse.ice.datastructures.ICEObject;

import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.ice.datastructures.componentVisitor.IComponentVisitor;

import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.TransformedList;;

/**
 * This class...
 * @author Jay Jay Billings
 *
 */
public abstract class AbstractListComponent<T> extends TransformedList<T,T> implements Component, Persistable {

	/**
	 * A protected constructor inherited from TransformedList.
	 * @param source The source list used by the TransformedList.
	 */
	protected AbstractListComponent(EventList<T> source) {
		super(source);
	}

	
	
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
	
	@Override
	public abstract void loadFromXML(InputStream inputStream);
	
	@Override
	public abstract void persistToXML(OutputStream outputStream);
}
