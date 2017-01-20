/*******************************************************************************
 * Copyright (c) 2012, 2016- UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Initial API and implementation and/or initial documentation - Jay Jay Billings, 
 *    Jordan H. Deyton, Dasha Gorin, Alexander J. McCaskey, Taylor Patterson, 
 *    Claire Saunders, Matthew Wang, Anna Wojtowicz
 *     
 *******************************************************************************/
package org.eclipse.january.form;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The ContinuousEntry is a DiscreteEntry that requires clients 
 * to set exactly 2 allowed values: the lower bound and upper bound of a 
 * range of continuous values that this IEntry stores. For example, setting 
 * 0 and 5 as the allowed values for this IEntry will allow clients to set this 
 * IEntry's value to anything between 0 and 5. 
 * 
 * @author Alex McCaskey
 *
 */
@XmlRootElement(name = "ContinuousEntry")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContinuousEntry extends DiscreteEntry {

	/**
	 * The template for the error that is returned for set value if the allowed
	 * value type is continuous.
	 */
	@XmlTransient
	protected String continuousErrMsg = "'${incorrectValue}' is an "
			+ "unacceptable value. The value must be between ${lowerBound} " + "and ${upperBound}.";

	/**
	 * The constructor
	 */
	public ContinuousEntry() {
		super();
	}
	
	/**
	 * Convenience constructor
	 * @param allowed
	 */
	public ContinuousEntry(String... allowed) {
		super(allowed);
		if (allowed.length > 2) {
			throw new IllegalArgumentException("ContinuousEntry must be constructed "
					+ "with exactly 2 allowed values: the lower and upper bound of "
					+ "the range.");
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.entry.DiscreteEntry#clone()
	 */
	@Override
	public Object clone() {
		ContinuousEntry entry = new ContinuousEntry();
		entry.copy(this);
		return entry;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.entry.DiscreteEntry#setValue(java.lang.String)
	 */
	@Override
	public boolean setValue(String newValue) {
		Double newValueDouble, lowerBound, upperBound;
		// Check continuous value against the bounds. Doing this with
		// doubles is simplest. allowedValues should only have two
		// values for Continuous values.
		if (allowedValues.size() == 2) {
			lowerBound = Double.valueOf(allowedValues.get(0));
			upperBound = Double.valueOf(allowedValues.get(1));
			// Try to cast to a double, but fail if it is impossible.
			try {
				newValueDouble = Double.valueOf(newValue);
			} catch (NumberFormatException | NullPointerException e) {
				// Replace the default error values with the ones for this Entry
				String error = continuousErrMsg;
				error = error.replace("${incorrectValue}", newValue != null ? newValue : "null");
				error = error.replace("${lowerBound}", getAllowedValues().get(0));
				error = error.replace("${upperBound}", getAllowedValues().get(1));
				this.errorMessage = error;
				return false;
			}
			// Set the value if it is within the bounds
			if (newValueDouble != null
					&& (newValueDouble.compareTo(lowerBound) != -1 && newValueDouble.compareTo(upperBound) != 1)) {
				this.value = newValue;
				errorMessage = null;
				return true;
			} else {
				// Replace the default error values with the ones for this Entry
				String error = continuousErrMsg;
				error = error.replace("${incorrectValue}", newValue != null ? newValue : "null");
				error = error.replace("${lowerBound}", getAllowedValues().get(0));
				error = error.replace("${upperBound}", getAllowedValues().get(1));
				this.errorMessage = error;
				return false;
			}
		}
	
		logger.info("ContinuousEntry must be initialized with an allowedValue list of size 2: the lower bound at index 0 and the upper bound at index 1.");
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.entry.DiscreteEntry#accept(org.eclipse.ice.datastructures.entry.IEntryVisitor)
	 */
	@Override
	public void accept(IEntryVisitor visitor) {
		visitor.visit(this);
	}
	
}
