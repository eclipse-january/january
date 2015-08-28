/*******************************************************************************
 * Copyright (c) 2012, 2014 UT-Battelle, LLC.
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

import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.gui.TableFormat;

/**
 * This interface provides a list of possible new elements for a ListComponent.
 * If an instance of this is available on the ListComponent, it should be used,
 * but it isn't required.
 * 
 * Like the ListComponent, it is templated and its type should match the
 * ListComponent. It provides a list of new elements as well as a TableFormat
 * that can be used to know how to read that list.
 * 
 * @author Jay Jay Billings
 * 
 */
public interface IElementSource<T> {

	/**
	 * This operation returns the list of candidates that should be used to select
	 * new elements to add to the ListComponent.
	 * 
	 * @return The element candidates
	 */
	public EventList<T> getElements();

	/**
	 * This operation returns the TableFormat that makes it possible to put the
	 * list of elements from getElements() in a searchable table or to otherwise
	 * query them as if they were a table. It is the only good way to deal with
	 * the generic nature of this interface and the ListComponent.
	 * 
	 * @return the TableFormat
	 */
	public TableFormat<T> getTableFormat();

}
