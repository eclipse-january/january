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

import java.util.List;

/**
 * The IEntry interface exposes the operations necessary for ICE to describe 
 * the individual values needed by the Item to perform a task. Realizations are 
 * responsible for collecting and managing these values in a way that suits the 
 * class' needs. 
 * 
 * @author Alex McCaskey
 *
 */
public interface IEntry extends Identifiable, IUpdateable, IUpdateableListener {

	/**
	 * Set the value of this IEntry. 
	 * 
	 * @param value The String value of this Entry
	 * @return success True if the value was set correctly.
	 */
	public boolean setValue(String value);
	
	/**
	 * This operation allows realizations and clients to describe 
	 * a multi-valued entry. 
	 * 
	 * @param values The values to be tracked
	 * @return success True if the values were set correctly.
	 */
	public boolean setValue(String... values);
	
	/**
	 * This operation returns this IEntry realization's value.
	 *  
	 * @return value The value of this Entry
	 */
	public String getValue();
	
	/**
	 * Return the value at the given index for an IEntry that is multi-valued. 
	 *
	 * @param index The index of the desired value. 
	 * @return value The value at the given index. 
	 */
	public String getValue(int index);
	
	/**
	 * For an IEntry that is multi-valued, return all values. 
	 * 
	 * @return values The values for this multi-valued IEntry
	 */
	public String[] getValues();
	
	/**
	 * Return the default value for this IEntry. 
	 * 
	 * @return default The default value for this IEntry.
	 */
	public String getDefaultValue();
	
	/**
	 * This operation let's clients set the default value for this IEntry. 
	 * 
	 * @param defaultValue The default value to set.
	 */
	public void setDefaultValue(String defaultValue);
	
	/**
	 * Return the list of allowed values for this IEntry. 
	 * 
	 * @return allowedValues The list of allowed values for this IEntry.
	 */
	public List<String> getAllowedValues();
	
	/**
	 * This operation allows clients to introduce, change, or alter this 
	 * IEntry's allowed values. 
	 * 
	 * @param allowedValues The list of values this IEntry can allow. 
	 */
	public void setAllowedValues(List<String> values);
	
	/**
	 * Return any comment that is associated with this IEntry. 
	 * 
	 * @return comment A descriptive comment about this IEntry. 
	 */
	public String getComment();
	
	/**
	 * This operation sets a descriptive comment about this IEntry.
	 * 
	 * @param comment The comment to set for this IEntry. 
	 */
	public void setComment(String comment);
	
	/**
	 * This operation returns the Entry's tag.
	 * 
	 * @return tag The tag for this IEntry.
	 */
	public String getTag();
	
	/**
	 * This operation sets the tag for the Entry
	 * 
	 * @param tag The IEntry's new tag. 
	 */
	public void setTag(String tag);
	
	/**
	 * This operation returns true if the Entry should be addressed and false if
	 * the Entry is not ready to be addressed (waiting on a parent Entry, etc.).
	 * 
	 * @return The readiness state of the Entry.
	 */
	public boolean isReady();
	
	/**
	 * This operation returns true if the Entry should be treated as a required
	 * quantity.
	 * 
	 * @return True if required, false if not.
	 */
	public boolean isRequired();
	
	/**
	 * This operation returns true if the Entry's value was recently set and
	 * false if the Entry's value has not been changed or if the Entry was
	 * recently updated.
	 * 
	 * @return True if the Entry's value was recently set, false if the Entry's
	 *         value has not been set or if the Entry was recently updated.
	 */
	public boolean isModified();
	
	/**
	 * This operation sets the readiness state of the Entry to the value of
	 * isReady.
	 * 
	 * @param isReady
	 *            The value to which the readiness state of the Entry should be
	 *            set.
	 */
	public void setReady(boolean ready);
	
	/**
	 * This operation sets the marks the Entry as required or not to indicate
	 * where or not it should be treated as a required quantity.
	 * 
	 * @param entryRequired
	 *            The value to which the required state of the Entry should be
	 *            set; true if required, false if not.
	 */
	public void setRequired(boolean required);
	
	/**
	 * This operation informs clients whether this IEntry is for a 
	 * secret value (such as password) or not. 
	 * 
	 * @return secret True if secret, false if not.
	 */
	public boolean isSecret();
	
	/**
	 * This operations marks the IEntry as secret.
	 * 
	 * @param secret True if secret, false otherwise.
	 */
	public void setSecret(boolean secret);
	
	/**
	 * This operation returns a human-readable reason for a rejected value
	 * passed to setValue().
	 * 
	 * @return
	 */
	public String getErrorMessage();
	
	/**
	 * This operation directs the IEntry to call back to an IEntryVisitor
	 * so that the visitor can perform its required actions for the exact type
	 * of the IEntry.
	 * 
	 * @param visitor
	 *            The visitor
	 */
	public void accept(IEntryVisitor visitor);
}
