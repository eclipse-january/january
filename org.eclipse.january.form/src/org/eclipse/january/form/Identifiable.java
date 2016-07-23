/*******************************************************************************
 * Copyright (c) 2012, 2016 UT-Battelle, LLC.
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
package org.eclipse.january.form;

/**
 * This interface describes operations that would make a class uniquely
 * identifiable to ICE.
 * 
 * @author Jay Jay Billings
 */
public interface Identifiable {

	/**
	 * This operation sets the identification number of the Identifiable entity.
	 * It must be greater than zero.
	 * 
	 * @param id
	 *            The unique identification number that should be assigned to
	 *            the Identifiable entity.
	 */
	public void setId(int id);

	/**
	 * This operation retrieves the description of the Identifiable entity.
	 * 
	 * @return The description of the Identifiable entity.
	 */
	public String getDescription();

	/**
	 * This operation retrieves the identification number of the Identifiable
	 * entity.
	 * 
	 * @return The unique identification number of the Identifiable entity.
	 */
	public int getId();

	/**
	 * This operation sets the name of the Identifiable entity.
	 * 
	 * @param name
	 *            The name that should be given to the Identifiable entity.
	 */
	public void setName(String name);

	/**
	 * This operation retrieves the name of the Identifiable entity.
	 * 
	 * @return The name of the Identifiable entity.
	 */
	public String getName();

	/**
	 * This operation sets the description of the Identifiable entity.
	 * 
	 * @param description
	 *            The description that should be stored for the Identifiable
	 *            entity.
	 */
	public void setDescription(String description);

	/**
	 * This operation is used to check equality between the ICE and another
	 * Identifiable entity. It returns true if the Identifiable entities are
	 * equal and false if they are not.
	 * 
	 * @param otherObject
	 *            The other Identifiable entity that should be compared with
	 *            this one.
	 * @return True if the Identifiable entitys are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object otherObject);

	/**
	 * This operation returns the hashcode value of the Identifiable entity.
	 * 
	 * @return The hashcode of the Identifiable entity.
	 */
	@Override
	public int hashCode();

	/**
	 * This operation returns a clone of the Identifiable instance using a deep
	 * copy.
	 * 
	 * @return The new clone.
	 */
	public Object clone();

	/**
	 * This operation returns the "context" of the identifiable object. The
	 * context can be thought of as an additional clue that can be provided with
	 * the object to allow clients to interpret its contents in a slightly
	 * different way. This is useful, for example, in dynamically redrawing the
	 * UI using a service factory where the context can be used as a clue to
	 * find the correct service for the Identifiable object. In this case, the
	 * context behaves as a separate identifier that associates it with related
	 * utilities.
	 * 
	 * @return the context
	 */
	public String getContext();

	/**
	 * This operation sets the context of Identifiable object.
	 * 
	 * @param context
	 *            the context
	 */
	public void setContext(String context);

}