/*******************************************************************************
 * Copyright (c) 2012, 2014- UT-Battelle, LLC.
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
package org.eclipse.ice.datastructures.entry;

import java.util.List;

import org.eclipse.ice.datastructures.ICEObject.IUpdateable;
import org.eclipse.ice.datastructures.ICEObject.IUpdateableListener;
import org.eclipse.ice.datastructures.ICEObject.Identifiable;

/**
 * @author Alex McCaskey
 *
 */
public interface IEntry extends Identifiable, IUpdateable, IUpdateableListener {

	public boolean setValue(String value);
	public boolean setValue(String... value);
	public String getValue();
	public String getValue(int index);
	public String getDefaultValue();
	public void setDefaultValue(String defaultValue);
	public List<String> getAllowedValues();
	public void setAllowedValues(List<String> values);
	public String getComment();
	public void setComment(String comment);
	public String getTag();
	public void setTag(String tag);
	public String getErrorMessage();
	public boolean isReady();
	public boolean isRequired();
	public boolean isModified();
	public void setReady(boolean ready);
	public void setRequired(boolean required);
	public String getContextId();
	public void setContextId(String id);

	
}
