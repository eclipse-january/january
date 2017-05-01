/*******************************************************************************
 * Copyright (c) 2012, 2016 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - 
 *   Jay Jay Billings
 *******************************************************************************/
package org.eclipse.january.form;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.content.ITextContentDescriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The FormTextContentDescriber interface is an extension of the
 * ITextContentDescriber that provides form-specific methods for the file to be
 * described.
 * 
 * @author Alex McCaskey
 *
 */
public interface FormTextContentDescriber extends ITextContentDescriber {

	/**
	 * If this is a valid January Item being described, return the discovered Item
	 * ID.
	 * 
	 * @return itemId The id of the Item.
	 */
	public int getItemID();

	/**
	 * Return true if given the provided lines of text as one String this file
	 * describes a valid January Form.
	 * 
	 * @param lines
	 *            Lines of text as one String
	 * @return isValid True if this is a valid January Form file description.
	 */
	public boolean isValidFile(String lines);

	/**
	 * This operation retrieves all FormTextContentDescriber implementations found in the
	 * ExtensionRegistry.
	 *
	 * @return The list of FormTextContentDescriber implementations that were found in the registry.
	 * @throws CoreException
	 *             This exception is thrown if an extension cannot be loaded.
	 */
	public static List<FormTextContentDescriber> getFormTextContentDescribers() throws CoreException {
		/**
		 * Logger for handling event messages and other information.
		 */
		Logger logger = LoggerFactory.getLogger(FormTextContentDescriber.class);
		List<FormTextContentDescriber> foundDescribers = new ArrayList<FormTextContentDescriber>();

		Object describer = null;
		String id = "org.eclipse.core.contenttype.contentTypes";
		IExtensionPoint point = Platform.getExtensionRegistry().getExtensionPoint(id);

		// If the point is available, create all the builders and load them into
		// the array.
		if (point != null) {
			IConfigurationElement[] elements = point.getConfigurationElements();
			for (IConfigurationElement e : elements) {
				if ("content-type".equals(e.getName())) {
					String[] attributes = e.getAttributeNames();
					ArrayList<String> attributesList = new ArrayList<String>();
					Collections.addAll(attributesList, attributes);
					if (attributesList.contains("describer")) {
						describer = e.createExecutableExtension("describer");
						if (describer instanceof FormTextContentDescriber) {
							foundDescribers.add((FormTextContentDescriber) describer);
						}
					}
				}
			}
		} else {
			logger.error("Extension Point " + id + " does not exist");
		}

		return foundDescribers;
	}

	// FIXME MAYBE ADD MORE LATER
}
