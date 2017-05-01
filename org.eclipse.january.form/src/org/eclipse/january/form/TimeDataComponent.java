/*******************************************************************************
 * Copyright (c) 2013, 2016 UT-Battelle, LLC.
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
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

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
		IEntry entry1, entry2, entry3, entry4, entry5;
		int entryCount = 0;

		// Setup Entries for comparison
		entry1 = new DiscreteEntry();
		List<String> allowed = new ArrayList<String>();
		allowed.add("True");
		allowed.add("False");
		entry1.setAllowedValues(allowed);
		entry1.setDefaultValue("True");
		entry1.setTag("MODE");
		entry1.setName("Enable Regular Mode");
		entry1.setDescription("Time loop's mode.  Can be Regular (true) or Explicit (false)");
		entryCount++;
		entry1.setId(entryCount);
		addEntry(entry1);

		// Entry: START
		entry2 = new ContinuousEntry();
		List<String> allowed2 = new ArrayList<String>();
		allowed.add("0");
		allowed.add("99999999");
		entry2.setAllowedValues(allowed2);
		entry2.setName("Start");
		entry2.setTag("START");
		entry2.setDescription("Time loop's start time. Can start between allowed values.");
		entry2.setDefaultValue("0");
		entryCount++;
		entry2.setId(entryCount);
		addEntry(entry2);

		// Entry: FINISH
		entry3 = new ContinuousEntry();
		List<String> allowed3 = new ArrayList<String>();
		allowed.add("1");
		allowed.add("99999999");
		entry3.setAllowedValues(allowed3);
		entry3.setName("Finish");
		entry3.setTag("FINISH");
		entry3.setDescription("Time loop's finish time. Can finish between allowed values.");
		entry3.setDefaultValue("30");
		entryCount++;
		entry3.setId(entryCount);
		addEntry(entry3);

		// Entry: NSTEP
		entry4 = new ContinuousEntry();
		List<String> allowed4 = new ArrayList<String>();
		allowed.add("1");
		allowed.add("99999999");
		entry4.setAllowedValues(allowed4);
		entry4.setName("The number to step");
		entry4.setTag("NSTEP");
		entry4.setDescription("Time loop's number to step. Can be set between allowed values.");
		entry4.setDefaultValue("1");
		entryCount++;
		entry4.setId(entryCount);
		addEntry(entry4);

		// Entry: VALUES
		entry5 = new StringEntry();
		entry5.setName("VALUES");
		entry5.setTag("VALUES");
		entry5.setDescription("Time loop's values.");
		entry5.setDefaultValue("4.4, 3.5, 3.6, 3.7");
		entryCount++;
		entry5.setId(entryCount);
		addEntry(entry5);

		// Setup JanuaryObject info
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
	 * @return
	 * 		<p>
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
	 * @return
	 * 		<p>
	 *         True if the DataComponents are equal, false otherwise.
	 *         </p>
	 */
	@Override
	public boolean equals(Object otherDataComponent) {

		// Make sure it is an instance of TimeDataComponent, compare the rest
		// normally
		return otherDataComponent instanceof TimeDataComponent && super.equals(otherDataComponent);

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