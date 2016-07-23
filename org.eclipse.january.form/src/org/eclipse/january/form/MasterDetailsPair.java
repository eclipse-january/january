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

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * The MasterDetailsPair class is used by the MasterDetailsComponent to keep
 * track of "masters" and "details" without having to store them in two separate
 * arrays. It simply allows one master value, a string, to be stored beside one
 * details DataComponent. A list of these pairs may also be used to set the
 * templates for the MasterDetailsComponent.
 * </p>
 * <p>
 * A MasterDetailsPair is an ICEObject and is both uniquely identifiable and
 * persistent. However, it only overloads ICEObject.loadFromXML(), not copy(),
 * equals(), hashcode() or clone().
 * </p>
 * 
 * @author Jay Jay Billings
 */
@XmlRootElement(name = "MasterDetailsPair")
public class MasterDetailsPair extends ICEObject {
	/**
	 * <p>
	 * The "master" value in this pair.
	 * </p>
	 * 
	 */
	private String master;
	/**
	 * <p>
	 * The "details" DataComponent for the master in this pair.
	 * </p>
	 * 
	 */
	private DataComponent details;

	/**
	 * <p>
	 * This is a unique id for the master details pair. This is originally
	 * inserted to allow master details component to have ids and to keep
	 * ICEObject's ids for database manipulation.
	 * </p>
	 * 
	 */
	private Integer masterDetailsPairId;

	/**
	 * <p>
	 * Creates a hash number from the current object.
	 * </p>
	 * 
	 * @return <p>
	 *         A hashcode value.
	 *         </p>
	 */
	@Override
	public int hashCode() {
		// Local Declarations
		int hash = 8;

		// Compute the hashcode
		hash = 31 * super.hashCode();
		hash = 31 * hash + (null == this.details ? 0 : this.details.hashCode());
		hash = 31 * hash + (null == this.master ? 0 : this.master.hashCode());
		hash = 31 * hash + this.masterDetailsPairId;

		return hash;
	}

	/**
	 * <p>
	 * An operation that checks to see if the current object equals the other
	 * object. Returns true if equal. False otherwise.
	 * </p>
	 * 
	 * @param otherObject
	 *            <p>
	 *            The other object to be checked for equality.
	 *            </p>
	 * @return <p>
	 *         True if equal to otherObject. False otherwise.
	 *         </p>
	 */
	@Override
	public boolean equals(Object otherObject) {
		// Local Declarations
		boolean retVal = false;
		MasterDetailsPair other;

		// Check the MasterDetailsPair, null and base type check first. Note
		// that the
		// instanceof operator must be used because subclasses of
		// MasterDetailsPair
		// can be anonymous.
		if (otherObject != null && (otherObject instanceof MasterDetailsPair)) {
			// See if they are the same reference on the heap
			if (this == otherObject) {
				retVal = true;
			} else {
				other = (MasterDetailsPair) otherObject;
				// Check each member value
				retVal = (this.uniqueId == other.uniqueId)
						&& (this.objectName.equals(other.objectName))
						&& (this.objectDescription
								.equals(other.objectDescription))
						&& (this.details.equals(other.details))
						&& (this.master.equals(other.master))
						&& (this.masterDetailsPairId == other.masterDetailsPairId);
			}
		}
		return retVal;
	}

	/**
	 * <p>
	 * An operation that copies the object passed into the current object.
	 * </p>
	 * 
	 * @param otherMasterDetailsPair
	 *            <p>
	 *            A MasterDetailsPair object to be copied.
	 *            </p>
	 */
	public void copy(MasterDetailsPair otherMasterDetailsPair) {
		// Return if object is null
		if (otherMasterDetailsPair == null) {
			return;
		}

		// Copy contents of super
		super.copy(otherMasterDetailsPair);

		// Copy id
		this.masterDetailsPairId = otherMasterDetailsPair.masterDetailsPairId;

		// copy master
		this.master = otherMasterDetailsPair.master;

		// copy details (DataComponent) - clone it.
		this.details = (DataComponent) otherMasterDetailsPair.details.clone();

	}

	/**
	 * <p>
	 * Deep copies current object and returns a newly instantiated object.
	 * </p>
	 * 
	 * @return <p>
	 *         A deep cloned MasterDetailsPair.
	 *         </p>
	 */
	@Override
	public Object clone() {
		// create a new instance of MasterDetailsComponent and copy contents
		MasterDetailsPair master = new MasterDetailsPair();
		master.copy(this);
		return master;

	}

	/**
	 * <p>
	 * This operation returns the master value of this pair or null if it has
	 * not been set.
	 * </p>
	 * 
	 * @return <p>
	 *         The string that describes the value of the master that is
	 *         associated with the details.
	 *         </p>
	 */
	@XmlAttribute
	public String getMaster() {

		return this.master;
	}

	/**
	 * <p>
	 * This operation sets the master value of this pair.
	 * </p>
	 * 
	 * @param masterValue
	 *            <p>
	 *            The string that describes the value of the master that is
	 *            associated with the details.
	 *            </p>
	 */
	public void setMaster(String masterValue) {
		// Do not set if null
		if (masterValue != null) {
			this.master = masterValue;
		}

	}

	/**
	 * <p>
	 * This operation returns the details DataComponent of this pair or null if
	 * it has not been set.
	 * </p>
	 * 
	 * @return <p>
	 *         The DataComponent that contains the detailed parameters
	 *         associated with the master.
	 *         </p>
	 */
	@XmlElement(name = "Details")
	public DataComponent getDetails() {
		return this.details;
	}

	/**
	 * <p>
	 * This operation sets the details DataComponent for this pair.
	 * </p>
	 * 
	 * @param detailsComp
	 *            <p>
	 *            The DataComponent that contains the detailed parameters
	 *            associated with the master.
	 *            </p>
	 */
	public void setDetails(DataComponent detailsComp) {

		// if not null, set
		if (detailsComp != null) {
			this.details = detailsComp;
		}

	}

	/**
	 * <p>
	 * Returns the value of the attribute masterDetailsPairId.
	 * </p>
	 * 
	 * @return <p>
	 *         A return value representing the integer for the
	 *         masterDetailsPairId.
	 *         </p>
	 */
	@XmlAttribute()
	public Integer getMasterDetailsPairId() {

		return this.masterDetailsPairId;
	}

	/**
	 * <p>
	 * Sets the masterDetailsPairId. Must be a non negative number.
	 * </p>
	 * 
	 * @param id
	 *            <p>
	 *            An id to be set to masterDetailsPairId.
	 *            </p>
	 */
	public void setMasterDetailsPairId(Integer id) {

		// If the id is not negative, set
		if (id >= 0 && id != null) {
			this.masterDetailsPairId = id;
		}

	}

	/**
	 * <p>
	 * The constructor.
	 * </p>
	 * 
	 */
	public MasterDetailsPair() {

		this.masterDetailsPairId = 0;
	}

	/**
	 * <p>
	 * An alternative constructor in which the master and details pieces can be
	 * specified to immediately initialize the pair.
	 * </p>
	 * 
	 * @param masterValue
	 *            <p>
	 *            The string that describes the value of the master that is
	 *            associated with the details.
	 *            </p>
	 * @param detailsComp
	 *            <p>
	 *            The DataComponent that contains the detailed parameters
	 *            associated with the master.
	 *            </p>
	 */
	public MasterDetailsPair(String masterValue, DataComponent detailsComp) {
		this.master = masterValue;
		this.details = detailsComp;
		this.masterDetailsPairId = 0;
	}

}