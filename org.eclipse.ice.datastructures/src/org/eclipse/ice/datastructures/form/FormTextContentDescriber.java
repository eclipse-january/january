/*******************************************************************************
 * Copyright (c) 2012, 2014 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - 
 *   Jay Jay Billings
 *******************************************************************************/
package org.eclipse.ice.datastructures.form;

import org.eclipse.core.runtime.content.ITextContentDescriber;

/**
 * The ICETextContentDescriber interface is an extension of the ITextContentDescriber 
 * that provides ICE-specific methods for the file to be described. 
 * 
 * @author Alex McCaskey
 *
 */
public interface FormTextContentDescriber extends ITextContentDescriber {

	/**
	 * If this is a valid ICE Item being described, return 
	 * the discovered Item ID. 
	 *  
	 * @return
	 */
	public int getItemID();
	
	// FIXME MAYBE ADD MORE LATER
}
