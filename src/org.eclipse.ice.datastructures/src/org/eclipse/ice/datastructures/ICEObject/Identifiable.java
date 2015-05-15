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

/**
 * <p>
 * This interface describes operations that would make a class uniquely
 * identifiable to ICE.
 * </p>
 * 
 * @author Jay Jay Billings
 */
public interface Identifiable {
	/**
	 * <p>
	 * This operation sets the identification number of the Identifiable entity.
	 * It must be greater than zero.
	 * </p>
	 * 
	 * @param id
	 *            <p>
	 *            The unique identification number that should be assigned to
	 *            the Identifiable entity.
	 *            </p>
	 */
	public void setId(int id);

	/**
	 * <p>
	 * This operation retrieves the description of the Identifiable entity.
	 * </p>
	 * 
	 * @return <p>
	 *         The description of the Identifiable entity.
	 *         </p>
	 */
	public String getDescription();

	/**
	 * <p>
	 * This operation retrieves the identification number of the Identifiable
	 * entity.
	 * </p>
	 * 
	 * @return <p>
	 *         The unique identification number of the Identifiable entity.
	 *         </p>
	 */
	public int getId();

	/**
	 * <p>
	 * This operation sets the name of the Identifiable entity.
	 * </p>
	 * 
	 * @param name
	 *            <p>
	 *            The name that should be given to the Identifiable entity.
	 *            </p>
	 */
	public void setName(String name);

	/**
	 * <p>
	 * This operation retrieves the name of the Identifiable entity.
	 * </p>
	 * 
	 * @return <p>
	 *         The name of the Identifiable entity.
	 *         </p>
	 */
	public String getName();

	/**
	 * <p>
	 * This operation sets the description of the Identifiable entity.
	 * </p>
	 * 
	 * @param description
	 *            <p>
	 *            The description that should be stored for the Identifiable
	 *            entity.
	 *            </p>
	 */
	public void setDescription(String description);

	/**
	 * <p>
	 * This operation is used to check equality between the ICE and another
	 * Identifiable entity. It returns true if the Identifiable entities are
	 * equal and false if they are not.
	 * </p>
	 * 
	 * @param otherObject
	 *            <p>
	 *            The other Identifiable entity that should be compared with
	 *            this one.
	 *            </p>
	 * @return <p>
	 *         True if the Identifiable entitys are equal, false otherwise.
	 *         </p>
	 */
	public boolean equals(Object otherObject);

	/**
	 * <p>
	 * This operation returns the hashcode value of the Identifiable entity.
	 * </p>
	 * 
	 * @return <p>
	 *         The hashcode of the Identifiable entity.
	 *         </p>
	 */
	public int hashCode();

	/**
	 * <p>
	 * This operation returns a clone of the Identifiable instance using a deep
	 * copy.
	 * </p>
	 * 
	 * @return <p>
	 *         The new clone.
	 *         </p>
	 */
	public Object clone();

}