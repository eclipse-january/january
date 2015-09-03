/*******************************************************************************
 * Copyright (c) 2013, 2014 UT-Battelle, LLC.
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

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.ice.datastructures.ICEObject.Component;
import org.eclipse.ice.datastructures.componentVisitor.IComponentVisitor;

/**
 * <p>
 * A specific DataComponent implementation that handles very specific roles for
 * setting up time loops. These time loops are delegated on the Datastructure.
 * There are two specific time modes. The first one is regular, or when the user
 * wants to specify the start time, the end time, and the number of steps
 * inbetween. The other mode is explicit, which specifies that the user can put
 * a series of values to represent time steps. The time steps must be in order
 * and valid, since this component will not verify if the values inserted for
 * explicit are numerical or parsed correctly. It is assumed the user will put
 * these values in order where there is a space to separate the values between
 * each setting.
 * </p>
 * <p>
 * There will be five entries allocated at startup (mode, start, finish, nstep,
 * and values). Keep in mind that the TimeDataComponent is only responsible for
 * those values. If other entries are added or removed, this will lead to
 * undefined behavior. As such, the only operations that work are retrieving
 * entries.
 * </p>
 * 
 * @author Scott Forest Hull II
 */
@XmlRootElement(name = "TimeDataComponent")
public class TimeDataComponent extends DataComponent {
	/**
	 * <p>
	 * A parameterized constructor that takes a type (Explicit or Regular) as a
	 * passed parameter. If the parameter is not specified as "EXPLICIT" or
	 * "REGULAR", then it will default to nullary constructor.
	 * </p>
	 * 
	 * @param type
	 */
	public TimeDataComponent(String type) {

		// Call nullary constructor
		this();

		// Setup type if explicit
		if (type != null && "EXPLICIT".equals(type)) {

			// Set to false
			super.retrieveAllEntries().get(0).setValue("False");
			super.retrieveAllEntries().get(1).setReady(false);
			super.retrieveAllEntries().get(2).setReady(false);
			super.retrieveAllEntries().get(3).setReady(false);
		}

	}

	/**
	 * <p>
	 * The nullary constructor. Defaults object to mode of Regular and creates
	 * required entries as necessary.
	 * </p>
	 * 
	 */
	public TimeDataComponent() {

		// Call super
		super();

		// Setup entries
		Entry entry;
		int entryCount = 0;

		// Setup Entries for comparison
		entry = new Entry() {
			@Override
			protected void setup() {
				this.setName("Enable Regular Mode");
				this.tag = "MODE";
				this.setDescription("Time loop's mode.  Can be Regular (true) or Explicit (false)");
				this.defaultValue = "True";
				this.value = this.defaultValue;
				this.allowedValues = new ArrayList<String>();
				this.allowedValues.add("True");
				this.allowedValues.add("False");
				this.allowedValueType = AllowedValueType.Discrete;
			}
		};
		entryCount++;
		entry.setId(entryCount);
		super.addEntry(entry);

		// Entry: START
		entry = new Entry() {
			@Override
			protected void setup() {
				this.setName("Start");
				this.tag = "START";
				this.setDescription("Time loop's start time. Can start between allowed values.");
				this.defaultValue = "0";
				this.value = this.defaultValue;
				this.allowedValues = new ArrayList<String>();
				this.allowedValues.add("0");
				this.allowedValues.add("99999999");
				this.allowedValueType = AllowedValueType.Continuous;
				this.parent = "Enable Regular Mode";
			}
		};
		entryCount++;
		entry.setId(entryCount);
		super.addEntry(entry);

		// Entry: FINISH
		entry = new Entry() {
			@Override
			protected void setup() {
				this.setName("Finish");
				this.tag = "FINISH";
				this.setDescription("Time loop's finish time. Can finish between allowed values.");
				this.defaultValue = "30";
				this.value = this.defaultValue;
				this.allowedValues = new ArrayList<String>();
				this.allowedValues.add("1");
				this.allowedValues.add("999999");
				this.allowedValueType = AllowedValueType.Continuous;
				this.parent = "Enable Regular Mode";
			}
		};
		entryCount++;
		entry.setId(entryCount);
		super.addEntry(entry);

		// Entry: NSTEP
		entry = new Entry() {
			@Override
			protected void setup() {
				this.setName("The number to step");
				this.tag = "NSTEP";
				this.setDescription("Time loop's number to step.  Can be set between allowed values.");
				this.defaultValue = "1";
				this.value = this.defaultValue;
				this.allowedValues = new ArrayList<String>();
				this.allowedValues.add("1");
				this.allowedValues.add("99999999");
				this.allowedValueType = AllowedValueType.Continuous;
				this.parent = "Enable Regular Mode";
			}
		};
		entryCount++;
		entry.setId(entryCount);
		super.addEntry(entry);

		// Entry: VALUES
		entry = new Entry() {
			@Override
			protected void setup() {
				this.setName("VALUES");
				this.tag = "VALUES";
				this.setDescription("Time loop's values.");
				this.defaultValue = "4.4, 3.5, 3.6, 3.7";
				this.value = this.defaultValue;
				this.allowedValueType = AllowedValueType.Undefined;
			}
		};
		entryCount++;
		entry.setId(entryCount);
		super.addEntry(entry);

		// Setup ICEObject info
		this.setName("TimeDataComponent 1");
		this.setId(1);
		this.setDescription("TimeDataComponent 1's Description");


	}

	/**
	 * <p>
	 * This operation performs a deep copy of the attributes of another
	 * TimeDataComponent into the current TimeDataComponent.
	 * </p>
	 * 
	 * @param otherDataComponent
	 *            <p>
	 *            The other DataComponent from which information should be
	 *            copied.
	 *            </p>
	 */
	public void copy(TimeDataComponent otherDataComponent) {

		super.copy(otherDataComponent);

	}

	/**
	 * <p>
	 * This operation provides a deep copy of the TimeDataComponent.
	 * </p>
	 * 
	 * @return <p>
	 *         The deep-copy clone of this DataComponent.
	 *         </p>
	 */
	@Override
	public Object clone() {

		// Local Declarations
		TimeDataComponent component = new TimeDataComponent();

		// Copy
		component.copy(this);

		// Return object
		return component;

	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.form.DataComponent#addEntry(org.eclipse.ice.datastructures.form.Entry)
	 */
	@Override
	public void addEntry(Entry newEntry) {

		// Do nothing

	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.form.DataComponent#addEntry(org.eclipse.ice.datastructures.form.Entry, java.lang.String[])
	 */
	@Override
	public void addEntry(Entry newEntry, String... parentNames) {

		// Do nothing

	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.form.DataComponent#clearEntries()
	 */
	@Override
	public void clearEntries() {

		// Do nothing

	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.form.DataComponent#deleteEntry(java.lang.String)
	 */
	@Override
	public void deleteEntry(String entryName) {

		// Do nothing

	}

	/**
	 * <p>
	 * Overrides DataComponent's implementation of retrieveAllEntries. This will
	 * return a list of entries in a shallow copied list. This way, entries can
	 * not be added or removed indirectly via getter method.
	 * </p>
	 * 
	 * @return <p>
	 *         The list of all Entries stored in the Form.
	 *         </p>
	 */
	@Override
	public ArrayList<Entry> retrieveAllEntries() {

		// Local Declarations
		ArrayList<Entry> entries = new ArrayList<Entry>();

		// Create a list of entries

		for (int i = 0; i < super.retrieveAllEntries().size(); i++) {
			entries.add(super.retrieveAllEntries().get(i));
		}

		// Return the entries
		return entries;


	}

	/**
	 * <p>
	 * This operation is used to check equality between the DataComponent and
	 * another DataComponent. It returns true if the DataComponents are equal
	 * and false if they are not.
	 * </p>
	 * 
	 * @param otherDataComponent
	 *            <p>
	 *            The other DataComponent to which this component should be
	 *            compared.
	 *            </p>
	 * @return <p>
	 *         True if the DataComponents are equal, false otherwise.
	 *         </p>
	 */
	@Override
	public boolean equals(Object otherDataComponent) {

		// Make sure it is an instance of TimeDataComponent, compare the rest
		// normally
		return otherDataComponent instanceof TimeDataComponent
				&& super.equals(otherDataComponent);

	}

	/**
	 * Returns the hashcode of the object.
	 */
	@Override
	public int hashCode() {

		// Hash code is the same as super's
		int hash = super.hashCode();

		return hash;
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