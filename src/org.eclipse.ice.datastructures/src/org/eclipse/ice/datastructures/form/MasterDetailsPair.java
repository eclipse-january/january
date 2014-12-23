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
package org.eclipse.ice.datastructures.form;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.ice.datastructures.ICEObject.ICEJAXBHandler;
import org.eclipse.ice.datastructures.ICEObject.ICEObject;

/**
 * <!-- begin-UML-doc -->
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
 * <!-- end-UML-doc -->
 * 
 * @author Jay Jay Billings
 * @generated 
 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@XmlRootElement(name = "MasterDetailsPair")
public class MasterDetailsPair extends ICEObject {
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The "master" value in this pair.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String master;
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The "details" DataComponent for the master in this pair.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private DataComponent details;

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This is a unique id for the master details pair. This is originally
	 * inserted to allow master details component to have ids and to keep
	 * ICEObject's ids for database manipulation.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Integer masterDetailsPairId;

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Creates a hash number from the current object.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         A hashcode value.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int hashCode() {
		// begin-user-code
		// Local Declarations
		int hash = 8;

		// Compute the hashcode
		hash = 31 * super.hashCode();
		hash = 31 * hash + (null == this.details ? 0 : this.details.hashCode());
		hash = 31 * hash + (null == this.master ? 0 : this.master.hashCode());
		hash = 31 * hash + this.masterDetailsPairId;

		return hash;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * An operation that checks to see if the current object equals the other
	 * object. Returns true if equal. False otherwise.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param otherObject
	 *            <p>
	 *            The other object to be checked for equality.
	 *            </p>
	 * @return <p>
	 *         True if equal to otherObject. False otherwise.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean equals(Object otherObject) {
		// begin-user-code
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
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * An operation that copies the object passed into the current object.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param otherMasterDetailsPair
	 *            <p>
	 *            A MasterDetailsPair object to be copied.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void copy(MasterDetailsPair otherMasterDetailsPair) {
		// begin-user-code
		// Return if object is null
		if (otherMasterDetailsPair == null) {
			return;
		}

		// Copy contents of super
		super.copy((MasterDetailsPair) otherMasterDetailsPair);

		// Copy id
		this.masterDetailsPairId = otherMasterDetailsPair.masterDetailsPairId;

		// copy master
		this.master = otherMasterDetailsPair.master;

		// copy details (DataComponent) - clone it.
		this.details = (DataComponent) otherMasterDetailsPair.details.clone();

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Deep copies current object and returns a newly instantiated object.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         A deep cloned MasterDetailsPair.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Object clone() {
		// begin-user-code
		// create a new instance of MasterDetailsComponent and copy contents
		MasterDetailsPair master = new MasterDetailsPair();
		master.copy(this);
		return master;

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation returns the master value of this pair or null if it has
	 * not been set.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The string that describes the value of the master that is
	 *         associated with the details.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlAttribute
	public String getMaster() {
		// begin-user-code

		return this.master;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation sets the master value of this pair.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param masterValue
	 *            <p>
	 *            The string that describes the value of the master that is
	 *            associated with the details.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setMaster(String masterValue) {
		// begin-user-code
		// Do not set if null
		if (masterValue != null) {
			this.master = masterValue;
		}

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation returns the details DataComponent of this pair or null if
	 * it has not been set.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The DataComponent that contains the detailed parameters
	 *         associated with the master.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlElement(name = "Details")
	public DataComponent getDetails() {
		// begin-user-code
		return this.details;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation sets the details DataComponent for this pair.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param detailsComp
	 *            <p>
	 *            The DataComponent that contains the detailed parameters
	 *            associated with the master.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setDetails(DataComponent detailsComp) {
		// begin-user-code

		// if not null, set
		if (detailsComp != null) {
			this.details = detailsComp;
		}

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Returns the value of the attribute masterDetailsPairId.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         A return value representing the integer for the
	 *         masterDetailsPairId.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlAttribute()
	public Integer getMasterDetailsPairId() {
		// begin-user-code

		return this.masterDetailsPairId;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Sets the masterDetailsPairId. Must be a non negative number.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param id
	 *            <p>
	 *            An id to be set to masterDetailsPairId.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setMasterDetailsPairId(Integer id) {
		// begin-user-code

		// If the id is not negative, set
		if (id >= 0 && id != null) {
			this.masterDetailsPairId = id;
		}

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The constructor.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public MasterDetailsPair() {
		// begin-user-code

		this.masterDetailsPairId = 0;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * An alternative constructor in which the master and details pieces can be
	 * specified to immediately initialize the pair.
	 * </p>
	 * <!-- end-UML-doc -->
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
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public MasterDetailsPair(String masterValue, DataComponent detailsComp) {
		// begin-user-code
		this.master = masterValue;
		this.details = detailsComp;
		this.masterDetailsPairId = 0;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation overloads the ICEObject.loadFromXML() operation to
	 * properly load the MasterDetailsPair.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param inputStream
	 *            <p>
	 *            The InputStream containing XML from which the
	 *            MasterDetailsPair should be loaded.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void loadFromXML(InputStream inputStream) {
		// begin-user-code
		// Initialize JAXBManipulator
		jaxbManipulator = new ICEJAXBHandler();

		// Call the read() on jaxbManipulator to create a new Object instance
		// from the inputStream
		Object dataObject = null;
		try {
			dataObject = jaxbManipulator.read(this.getClass(), inputStream);
			// Copy contents of new object into current data structure
			this.copy((MasterDetailsPair) dataObject);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Copy contents of dataObject to here
		if (dataObject != null) {
			this.master = ((MasterDetailsPair) dataObject).master;
			this.details = ((MasterDetailsPair) dataObject).details;
			this.masterDetailsPairId = ((MasterDetailsPair) dataObject).masterDetailsPairId;
		}

		// Nullerize jaxbManipilator
		jaxbManipulator = null;

		// end-user-code
	}
}