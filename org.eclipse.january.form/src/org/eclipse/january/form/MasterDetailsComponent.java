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

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * This class provides a data structure that orders key values and
 * DataComponents in a way that is consistent with the Master/Details pattern.
 * Each master is represented by a string and the associated details are
 * represented by a DataComponent. Clients may configure the component, which is
 * configured based on a template, to have any number of instances of the
 * allowed masters. This class manages a collection of "masters" and a
 * collection of "details," one per master, the members of both being
 * instantiated based on their respective templates.
 * </p>
 * <p>
 * The set of masters that may be created and the set of details that may be
 * modified for instances of those masters are provided to the component by
 * calling the setTemplates() operation. The list of strings that is passed to
 * this operation represents the allowed types of instances of a master and the
 * list of DataComponents should be ordered exactly like the list of master
 * types such that the first allowed master type in the string list corresponds
 * to the first DataComponent in the details list. A null value may not be
 * passed for the list of DataComponents, but a null value is allowed for the
 * list that represents the master. If null is passed for the master, the
 * MasterDetailsComponent will create masters with undefined or null types and
 * the client will be expected to supply a name.
 * </p>
 * <p>
 * Clients should call addMaster() to add a master to the block and then
 * retrieve the new master from getMaster() using the integer id that was
 * returned from addMaster(). The value of the master can be changed and the
 * details retrieved using one of the getMasters() operations. All masters are
 * created equal, but each instance may have its value set to one of its other
 * allowed values. Changing the value of the master value will change the type
 * of details that are returned by any of the getDetails() operations (which is
 * why they are "locked" together during creation). Details may be retrieved in
 * three ways: by the name, id or reference to the master itself.
 * </p>
 * <p>
 * The MasterDetailsComponent is an JanuaryObject and is both uniquely identifiable
 * and persistent to either XML or SQL. It implements the Component interface
 * and can be visited and observed.
 * </p>
 * <p>
 * The MasterDetailsComponent can be configured with a "header component." The
 * header is a DataComponent that contains Entries whose values apply to the
 * master-details pairs globally. For example, in the January MultiLauncher the
 * header contains an Entry to determine whether or not the jobs should be
 * launched sequentially or in parallel. This header is retrieved and set by
 * calling get/setGlobalsComponent and it is referred to interchangeably as
 * "the header" or "the globals" component.
 * </p>
 * <p>
 * It is possible to generate a unique value for a particular master by calling
 * getUniqueMasterValue() to handle the case where there are degenerate master
 * values. The MasterDetailsComponent will create a unique value equal to the id
 * of the master plus its value.
 * </p>
 * <p>
 * Internally, the MasterDetailsComponent stores a master and its details in a
 * list of MasterDetailsPairs. This is primarily motivated by the requirements
 * that the masters and details values should be stored next to each other when
 * they are persisted and that storing them in two separate arrays can cause
 * book keeping errors (which is a common procedural anti-pattern).
 * </p>
 * 
 * @author Scott Forest Hull II
 */
@XmlRootElement(name = "MasterDetailsComponent")
@XmlAccessorType(XmlAccessType.FIELD)
public class MasterDetailsComponent extends JanuaryObject implements Component {
	/**
	 * <p>
	 * The list of Master/Details pairs that have been created in the component.
	 * </p>
	 * 
	 */
	@XmlElement(name = "MasterDetailsPairs")
	private ArrayList<MasterDetailsPair> masterDetailsPairs;
	/**
	 * <p>
	 * The list of strings that is used as a template for creating new master
	 * instances. The default value of a new master is set to the first value in
	 * this list and the masters that are created may have their values set to
	 * any one of the values in this list.
	 * </p>
	 * 
	 */
	@XmlElement(name = "AllowedMasters")
	private ArrayList<String> allowedMasters;

	/**
	 * <p>
	 * The list of masters and details that may be instantiated in this
	 * component. Calling setTemplates() with separate lists will populate this
	 * list and calling setTemplates() with a pair will reference that list.
	 * </p>
	 * 
	 */
	@XmlElement(name = "MasterDetailsTemplateList")
	private ArrayList<MasterDetailsPair> masterDetailsTemplateList;

	/**
	 * <p>
	 * An attribute that represents the total number of MasterDetailPairs added.
	 * This counter will increment and reflect in the masterDetailsPairId. When
	 * a Master is deleted, this counter will not decrement.
	 * </p>
	 * 
	 */
	@XmlAttribute
	private Integer counter;

	/**
	 * <p>
	 * A DataComponent that can be configured to contain global properties for
	 * MasterDetailsPairs.
	 * </p>
	 * 
	 */
	@XmlElement(name = "GlobalsComponent")
	private DataComponent globals;

	/**
	 * <p>
	 * Represents the add and remove button for the MasterDetailsComponent's GUI
	 * infrastructure. Defaults to true. If it is set to false, then the GUI
	 * should disable the add and remove button and allow the internal
	 * infrastructure handle the masters's overall size.
	 * </p>
	 * 
	 */
	@XmlAttribute()
	private boolean toggleAddRemoveButton;

	/**
	 * <p>
	 * The constructor.
	 * </p>
	 * 
	 */
	public MasterDetailsComponent() {

		// Setup listeners, masters, template, and pairs.
		this.listeners = new ArrayList<IUpdateableListener>();
		this.allowedMasters = new ArrayList<String>();
		this.masterDetailsPairs = new ArrayList<MasterDetailsPair>();
		this.masterDetailsTemplateList = new ArrayList<MasterDetailsPair>();
		this.toggleAddRemoveButton = true;

		// Set counter to One
		this.counter = 1;

	}

	/**
	 * <p>
	 * This operation sets the Master/Details template that is required for to
	 * initialize the component. It may only be called once per
	 * MasterDetailsComponent.
	 * </p>
	 * 
	 * @param masterTypeList
	 *            <p>
	 *            The list of strings that should be used as the template for
	 *            all master instances that will be created in this component.
	 *            </p>
	 * @param detailList
	 *            <p>
	 *            The ordered list of DataComponents that should be used as the
	 *            base set of details for the masters. The DataComponents in
	 *            this list should be ordered such that the first DataComponent
	 *            is the details block for the first master, the second for the
	 *            second, and so on.
	 *            </p>
	 */
	public void setTemplates(ArrayList<String> masterTypeList,
			ArrayList<DataComponent> detailList) {
		// Local declarations
		MasterDetailsPair mDetailsP;

		// If the masterTypeList or detailList is null, return
		if (!(masterTypeList != null && detailList != null)) {
			return;
		} else {
			// This is a speedy boolean statement to check validation for
			// setting templates
			// If the lists (plural) are not empty, are equal in size, and if
			// the templatelist has not been set, everything is okay.
			// Otherwise, return.
			if (!(!masterTypeList.isEmpty() && !detailList.isEmpty()
					&& (masterTypeList.size() == detailList.size()) && this.masterDetailsTemplateList
						.isEmpty())) {
				return;
			}
		}

		// Then you can set it

		// Copy contents into new arrays - maintains data integrity
		this.masterDetailsPairs = new ArrayList<MasterDetailsPair>();
		this.allowedMasters = new ArrayList<String>();
		this.masterDetailsTemplateList = new ArrayList<MasterDetailsPair>();

		// Deep copy contents of detailList and masterTypeList
		for (int i = 0; i < detailList.size(); i++) {
			// Create a master details page
			mDetailsP = new MasterDetailsPair();
			// Set the id
			mDetailsP.setMasterDetailsPairId(i);
			// Set the Master and details
			mDetailsP.setDetails((DataComponent) detailList.get(i).clone());
			mDetailsP.setMaster(masterTypeList.get(i));
			// Move to template
			this.masterDetailsTemplateList.add(mDetailsP);
			this.allowedMasters.add(mDetailsP.getMaster());
		}

		this.notifyListeners();
	}

	/**
	 * <p>
	 * This operation sets up the templates for the MasterDetailsComponent using
	 * a list of MasterDetailsPairs. It is provided as an alternative to the
	 * other setTemplates() operation for both brevity and better memory
	 * management.<b></b>
	 * </p>
	 * 
	 * @param pairs
	 *            <p>
	 *            The list of MasterDetailsPairs that should be used as the
	 *            template for this component.
	 *            </p>
	 */
	public void setTemplates(ArrayList<MasterDetailsPair> pairs) {
		// Local declarations
		MasterDetailsPair mDetailsP;

		// Check to see if they are null or empty
		if (pairs == null || pairs.isEmpty()) {
			return;
		}

		// Return if the masterDetailsTemplateList is set.
		if (!this.masterDetailsTemplateList.isEmpty()) {
			return;
		}

		// Deep copy contents of detailList and masterTypeList
		for (int i = 0; i < pairs.size(); i++) {
			// Copy clone
			mDetailsP = (MasterDetailsPair) pairs.get(i).clone();
			// Move to template
			this.masterDetailsTemplateList.add(mDetailsP);
			this.allowedMasters.add(mDetailsP.getMaster());
		}

		this.notifyListeners();
	}

	/**
	 * <p>
	 * This operation returns the details block (a DataComponent) associated
	 * with the master who has the specified id. If there are two masters with
	 * the same id in the component, it only returns the first.
	 * </p>
	 * 
	 * @param masterId
	 *            <p>
	 *            The id of the master whose details should be retrieved.
	 *            </p>
	 * @return <p>
	 *         The details block for the master with the specified id.
	 *         </p>
	 */
	public DataComponent getDetails(int masterId) {

		// Return if the masterDetailsTemplateList is not set.
		// Also check if the masterId < 0 || masterId > this.counter
		// Faster boolean operations.
		if (!(!this.masterDetailsTemplateList.isEmpty() && (masterId >= 0) && (masterId < this.counter))) {
			return null;
		}

		// Search to see if the id exists
		for (int i = 0; i < this.masterDetailsPairs.size(); i++) {
			// If the id is found, return the DataComponent
			if (this.masterDetailsPairs.get(i).getMasterDetailsPairId() == masterId) {
				return this.masterDetailsPairs.get(i).getDetails();
			}
		}

		// It was not found. Return
		return null;

	}

	/**
	 * <p>
	 * This operation adds a instantiates a new master. The value of the new
	 * master is set to the first value in the masterTemplate list. It returns
	 * the integer id that the MasterDetailsComponent assigns to that master and
	 * the master may be retrieved later by calling getMaster().
	 * </p>
	 * 
	 * @return <p>
	 *         The id of the new master instance.
	 *         </p>
	 */
	public int addMaster() {
		// Local Declarations
		MasterDetailsPair mDetailsP = null;

		// Return if the masterDetailsTemplateList is not set.
		if (this.masterDetailsTemplateList.isEmpty()) {
			return -1;
		}

		// This should not happen - failsafe for empty templatelist
		if (this.masterDetailsTemplateList.isEmpty()) {
			return -1;
		}

		// Create a new MasterPage based on the first of the list.
		// Set the id based on the counter
		mDetailsP = (MasterDetailsPair) this.masterDetailsTemplateList.get(0)
				.clone();
		mDetailsP.setMasterDetailsPairId(this.counter);

		// add it to the list
		this.masterDetailsPairs.add(mDetailsP);

		// Increment counter
		this.counter++;

		this.notifyListeners();

		return this.counter - 1;

	}

	/**
	 * <p>
	 * This operation deletes a master from the MasterDetailsComponent. It
	 * returns true if the id is valid and it is able to delete the master and
	 * its details and it returns false otherwise. Deleting a master will not
	 * change the ids of the other masters.
	 * </p>
	 * 
	 * @param id
	 *            <p>
	 *            The id of the master that should be deleted.
	 *            </p>
	 * @return <p>
	 *         True if the master was deleted, false otherwise.
	 *         </p>
	 */
	public boolean deleteMaster(int id) {
		// Return if the masterDetailsTemplateList is null
		if (this.masterDetailsTemplateList == null) {
			return false;
		}

		// Id needs to be less than or equal to counter or positive
		if (id < 0 || id > this.counter) {
			return false;
		}

		// Search to see if the id exists
		for (int i = 0; i < this.masterDetailsPairs.size(); i++) {
			// If the id is found, delete it
			if (this.masterDetailsPairs.get(i).getMasterDetailsPairId() == id) {
				this.masterDetailsPairs.remove(i);
				this.notifyListeners();
				return true;
			}
		}

		// It was not found. Return
		return false;

	}

	/**
	 * <p>
	 * This operation returns the value of the master with the specified id.
	 * </p>
	 * 
	 * @param id
	 *            <p>
	 *            The id of the master that should be retrieved.
	 *            </p>
	 * @return <p>
	 *         The value of the instance of the master with the given id.
	 *         </p>
	 */
	public String getMasterValue(int id) {

		// Return if the masterDetailsTemplateList is not set.
		if (this.masterDetailsTemplateList.isEmpty()) {
			return null;
		}

		// Id needs to be less than or equal to counter or positive
		if (id < 0 || id > this.counter) {
			return null;
		}

		// Search to see if the id exists
		for (int i = 0; i < this.masterDetailsPairs.size(); i++) {
			// If the id is found, delete it
			if (this.masterDetailsPairs.get(i).getMasterDetailsPairId() == id) {
				return this.masterDetailsPairs.get(i).getMaster();
			}
		}

		// Nothing found, return null
		return null;
	}

	/**
	 * <p>
	 * This operation sets the value of an instance of a master with the
	 * specified id. If the value is not one of the values in the list returned
	 * from getAllowedMasterValues(), this operation returns false and does not
	 * set the value.
	 * </p>
	 * 
	 * @param id
	 *            <p>
	 *            The id of the master that should be set.
	 *            </p>
	 * @param value
	 *            <p>
	 *            The new value of the master.
	 *            </p>
	 * @return <p>
	 *         True if setting the value was successful, false otherwise.
	 *         </p>
	 */
	public boolean setMasterInstanceValue(int id, String value) {

		// Local Declarations
		DataComponent dataComponent = null;

		// If value is null or the id is not correct, return
		if (value == null || id < 0 || id > this.counter) {
			return false;
		}

		// Return if the masterDetailsTemplateList is not set.
		if (this.masterDetailsTemplateList.isEmpty()) {
			return false;
		}

		// Check to see if the value exists. If not, return false
		if (!this.allowedMasters.contains(value)) {
			return false;
		}

		// Search to see if the id exists
		for (int i = 0; i < this.masterDetailsPairs.size(); i++) {
			// If the id is found, set it
			if (this.masterDetailsPairs.get(i).getMasterDetailsPairId() == id) {
				// Set the DataComponent
				// Get the DataComponent to copy
				for (int j = 0; j < this.masterDetailsTemplateList.size(); j++) {
					if (this.masterDetailsTemplateList.get(j).getMaster()
							.equals(value)) {
						// Clone another dataComponent
						dataComponent = (DataComponent) this.masterDetailsTemplateList
								.get(j).getDetails().clone();
					}
				}
				// If not a valid type, return false
				if (dataComponent == null) {
					return false;
				}

				// If the value of the master is correctly set, do not change
				// the details
				if (this.masterDetailsPairs.get(i).getMaster().equals(value)) {
					this.notifyListeners();

					return true;
				}

				// Set the masters
				this.masterDetailsPairs.get(i).setMaster(value);

				// Set the dataComponent
				this.masterDetailsPairs.get(i).setDetails(dataComponent);

				this.notifyListeners();
				return true;

			}
		}

		// Nothing found, return false
		return false;
	}

	/**
	 * <p>
	 * This operation returns the list of allowed values that may be assigned to
	 * masters when setMasterInstanceValue() is called.
	 * </p>
	 * 
	 * @return <p>
	 *         The list of values that may be assigned to masters.
	 *         </p>
	 */
	public ArrayList<String> getAllowedMasterValues() {
		ArrayList<String> tempString = new ArrayList<String>();

		// If the allowedMasterValues are empty, return null
		if (this.allowedMasters.isEmpty()) {
			return null;
		}

		// If they are not null or empty, then create a list of values
		for (int i = 0; i < this.allowedMasters.size(); i++) {
			tempString.add(this.allowedMasters.get(i));
		}

		return tempString;

	}

	/**
	 * <p>
	 * This operation is used to check equality between the
	 * MasterDetailsComponent and another MasterDetailsComponent. It returns
	 * true if the MasterDetailsComponents are equal and false if they are not.
	 * </p>
	 * 
	 * @param otherMasterDetailsComponent
	 *            <p>
	 *            The other MasterDetailsComponent to which this component
	 *            should be compared.
	 *            </p>
	 * @return <p>
	 *         True if the MasterDetailsComponents are equal, false otherwise.
	 *         </p>
	 */
	@Override
	public boolean equals(Object otherMasterDetailsComponent) {
		boolean retVal = true;
		// Check if they are the same reference in memory
		if (this == otherMasterDetailsComponent) {
			return true;
		}

		// Check that the object is not null, and that it is a
		// MasterDetailsComponent
		if (otherMasterDetailsComponent == null
				|| !(otherMasterDetailsComponent instanceof MasterDetailsComponent)) {
			return false;
		}

		// Check that these objects have the same JanuaryObject data
		if (!super.equals(otherMasterDetailsComponent)) {
			return false;
		}

		// At this point, other object must be a MasterDetailsComponent, so cast
		// it
		MasterDetailsComponent castedmDetailsP = (MasterDetailsComponent) otherMasterDetailsComponent;

		// Check for globals - can be null!
		if (this.globals == null || castedmDetailsP.globals == null) {
			if (this.globals != castedmDetailsP.globals) {
				return false;
			}
		} else {
			if (!this.globals.equals(castedmDetailsP.globals)) {
				return false;
			}
		}

		// Check each member value
		retVal = (this.allowedMasters.equals(castedmDetailsP.allowedMasters))
				&& (this.masterDetailsPairs
						.equals(castedmDetailsP.masterDetailsPairs))
				&& (this.masterDetailsTemplateList
						.equals(castedmDetailsP.masterDetailsTemplateList));

		return retVal;
	}

	/**
	 * <p>
	 * This operation returns the hashcode value of the MasterDetailsComponent.
	 * </p>
	 * 
	 * @return <p>
	 *         The hashcode.
	 *         </p>
	 */
	@Override
	public int hashCode() {
		// Local Declaration
		int hash = 1;

		// Compute hash code from JanuaryObject data
		hash = 31 * hash + super.hashCode();

		// Compute attributes
		hash = 31
				* hash
				+ (null == this.allowedMasters ? 0 : this.allowedMasters
						.hashCode());
		hash = 31 * hash + (null == this.counter ? 0 : this.counter.hashCode());
		hash = 31
				* hash
				+ (null == this.masterDetailsPairs ? 0
						: this.masterDetailsPairs.hashCode());
		hash = 31
				* hash
				+ (null == this.masterDetailsTemplateList ? 0
						: this.masterDetailsTemplateList.hashCode());
		hash = 31 * hash + (null == this.globals ? 0 : this.globals.hashCode());

		return hash;

	}

	/**
	 * <p>
	 * This operation performs a deep copy of the attributes of another
	 * MasterDetailsComponent into the current MasterDetailsComponent.
	 * </p>
	 * 
	 * @param otherMasterDetailsComponent
	 *            <p>
	 *            The other MasterDetailsComponent from which information should
	 *            be copied.
	 *            </p>
	 */
	public void copy(MasterDetailsComponent otherMasterDetailsComponent) {
		// Return if object is null
		if (otherMasterDetailsComponent == null) {
			return;
		}

		// Copy contents of super
		super.copy(otherMasterDetailsComponent);

		this.counter = otherMasterDetailsComponent.counter;

		// Copy allowedMasters
		this.allowedMasters.clear();
		for (int i = 0; i < otherMasterDetailsComponent.allowedMasters.size(); i++) {
			this.allowedMasters.add(otherMasterDetailsComponent.allowedMasters
					.get(i));
		}

		// Copy MasterDetailsPairs
		this.masterDetailsPairs.clear();
		for (int i = 0; i < otherMasterDetailsComponent.masterDetailsPairs
				.size(); i++) {
			this.masterDetailsPairs
					.add((MasterDetailsPair) otherMasterDetailsComponent.masterDetailsPairs
							.get(i).clone());
		}

		// Copy MasterDetailsTemplateList
		this.masterDetailsTemplateList.clear();
		for (int i = 0; i < otherMasterDetailsComponent.masterDetailsTemplateList
				.size(); i++) {
			this.masterDetailsTemplateList
					.add((MasterDetailsPair) otherMasterDetailsComponent.masterDetailsTemplateList
							.get(i).clone());
		}

		// Copy globals
		if (otherMasterDetailsComponent.globals == null) {
			this.globals = null;
		} else {
			this.globals = (DataComponent) otherMasterDetailsComponent.globals
					.clone();
		}

		// Copy toggle
		this.toggleAddRemoveButton = otherMasterDetailsComponent.toggleAddRemoveButton;

		this.notifyListeners();
	}

	/**
	 * <p>
	 * This operation provides a deep copy of the MasterDetailsComponent.
	 * </p>
	 * 
	 * @return <p>
	 *         The deep-copy clone of this MasterDetailsComponent.
	 *         </p>
	 */
	@Override
	public Object clone() {
		// create a new instance of MasterDetailsComponent and copy contents
		MasterDetailsComponent mDetailsP = new MasterDetailsComponent();
		mDetailsP.copy(this);
		return mDetailsP;
	}

	/**
	 * <p>
	 * This private operation checks the list of MasterDetailsPairs to make sure
	 * that for the value of the master the proper details DataComponent is set.
	 * </p>
	 * 
	 * @param id
	 *            <p>
	 *            The integer id of the MasterDetailsPair that should be
	 *            checked.
	 *            </p>
	 */
	private void rectifyDetailsBlock(int id) {
		// TODO Auto-generated method stub

	}

	/**
	 * <p>
	 * Returns the number of MasterDetailsPairs in masterDetailsPairs list.
	 * </p>
	 * 
	 * @return <p>
	 *         Number of masters.
	 *         </p>
	 */
	public int numberOfMasters() {
		return this.masterDetailsPairs.size();
	}

	/**
	 * <p>
	 * An operation that gets the globals variable. Returns null if it has not
	 * been set. This should be reviewed by clients if it is not null.
	 * </p>
	 * 
	 * @return <p>
	 *         A returned DataComponent globals value.
	 *         </p>
	 */
	public DataComponent getGlobalsComponent() {
		return this.globals;
	}

	/**
	 * <p>
	 * An operation that sets the globals attribute. If the global's operation
	 * has been set and is passed null, globals is set to null.
	 * </p>
	 * 
	 * @param globals
	 *            <p>
	 *            The DataComponent global to be set.
	 *            </p>
	 */
	public void setGlobalsComponent(DataComponent globals) {

		// Passed all required critera, set as globals.
		this.globals = globals;

		// Notify the listeners
		this.notifyListeners();
	}

	/**
	 * <p>
	 * An operation that returns the master at index in the masterDetailsPairs
	 * list. Returns null if it does not exist.
	 * </p>
	 * 
	 * @param index
	 *            <p>
	 *            List index.
	 *            </p>
	 * @return <p>
	 *         A string value in masterDetailsPairs list.
	 *         </p>
	 */
	public String getMasterAtIndex(int index) {

		// If it is a proper index, return Master String
		if (index < 0 || index > this.masterDetailsPairs.size()
				|| this.masterDetailsPairs.isEmpty()) {
			return null;
		} else {
			return this.masterDetailsPairs.get(index).getMaster();
		}

	}

	/**
	 * <p>
	 * An operation that returns the details DataComponent at index in the
	 * masterDetailsPairs list. Returns null if it does not exist.
	 * </p>
	 * 
	 * @param index
	 *            <p>
	 *            The index in the list.
	 *            </p>
	 * @return <p>
	 *         The returned DataComponent.
	 *         </p>
	 */
	public DataComponent getDetailsAtIndex(int index) {
		// If it is a proper index, return DataComponent details
		if (index < 0 || index > this.masterDetailsPairs.size()
				|| this.masterDetailsPairs.isEmpty()) {
			return null;
		} else {
			return this.masterDetailsPairs.get(index).getDetails();
		}
	}

	/**
	 * <p>
	 * An operation that returns the unique masterDetailsPairId plus Master
	 * String keyed on the unique id (masterDetailsPairId) in the list of
	 * masterDetailsPairs. Returns null if it does not exist.
	 * </p>
	 * 
	 * @param id
	 *            <p>
	 *            The unique masterDetailsPairId.
	 *            </p>
	 * @return <p>
	 *         The unique master value, equal to 'id + " " + value'.
	 *         </p>
	 */
	public String getUniqueMasterValue(int id) {
		// If it is a proper index, return Master String
		if (id < 0 || id > this.counter || this.masterDetailsPairs.isEmpty()) {
			return null;
		} else {
			for (int i = 0; i < this.masterDetailsPairs.size(); i++) {
				if (id == this.masterDetailsPairs.get(i)
						.getMasterDetailsPairId()) {
					return id + " "
							+ this.masterDetailsPairs.get(i).getMaster();
				}
			}

		}

		// Nothing found, return null
		return null;
	}

	/**
	 * <p>
	 * An operation that returns the unique masterDetailsPairId plus Master
	 * String keyed on the index in the list of masterDetailsPairs. Returns null
	 * if it does not exist.
	 * </p>
	 * 
	 * @param index
	 *            <p>
	 *            The index in the list.
	 *            </p>
	 * @return <p>
	 *         The unique master value, equal to 'id + " " + value'.
	 *         </p>
	 */
	public String getUniqueMasterValueAtIndex(int index) {
		// If it is a proper index, return Master String
		if (index < 0 || index > this.masterDetailsPairs.size()
				|| this.masterDetailsPairs.isEmpty()) {
			return null;
		} else {
			// uniqueId + " " + masterString
			return this.masterDetailsPairs.get(index).getMasterDetailsPairId()
					+ " " + this.masterDetailsPairs.get(index).getMaster();
		}
	}

	/**
	 * <p>
	 * An operation that deletes a master at an index. Returns true if the
	 * operation was successful. False otherwise.
	 * </p>
	 * 
	 * @param index
	 *            <p>
	 *            The index to be deleted.
	 *            </p>
	 * @return <p>
	 *         Status of deletion.
	 *         </p>
	 */
	public boolean deleteMasterAtIndex(int index) {
		// If it is a proper index, return DataComponent details
		if (index < 0 || index > this.masterDetailsPairs.size()
				|| this.masterDetailsPairs.isEmpty()) {
			return false;
		} else {

			// Delete at index and return true
			this.masterDetailsPairs.remove(index);

			return true;
		}
	}

	/**
	 * <p>
	 * Returns true if the MasterDetailsComponent's buttons should be enabled.
	 * If false, the buttons should be disabled.
	 * </p>
	 * 
	 * @return <p>
	 *         The status
	 *         </p>
	 */
	public boolean canAddRemoveButton() {

		return this.toggleAddRemoveButton;

	}

	/**
	 * <p>
	 * Sets the toggle for the add and remove button.
	 * </p>
	 * 
	 * @param toggle
	 *            <p>
	 *            Toggle for the add or remove button.
	 *            </p>
	 */
	public void toggleAddRemoveButton(boolean toggle) {

		this.toggleAddRemoveButton = toggle;

	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.JanuaryObject.JanuaryObject#update(java.lang.String, java.lang.String)
	 */
	@Override
	public void update(String updatedKey, String newValue) {
		// Not used at this time. Does nothing.

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Component#accept(IComponentVisitor visitor)
	 */
	@Override
	public void accept(IComponentVisitor visitor) {
		// Reveal our type to the visitor
		visitor.visit(this);

	}
}