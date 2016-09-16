/*******************************************************************************
 * Copyright (c) 2014 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation -
 *   Robert Smith
 *******************************************************************************/
package org.eclipse.january.form.internal;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.eavp.viz.service.IVizServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Holder class for a VizServiceFactory.
 *
 * @author Robert Smith
 *
 */

public class VizServiceFactoryHolder {
	// The VizServiceFactory held by the VizServiceFactory
	private static IVizServiceFactory factory;

	/**
	 * Getter for the held VizServiceFactory.
	 *
	 * @return the held VizServiceFactory
	 */
	public static IVizServiceFactory getFactory() {
		return factory;
	}

	/**
	 * Setter for the VizServiceFactory.
	 *
	 * @param input
	 *            the VizServiceFactory to hold
	 */
	public static void setVizServiceFactory(IVizServiceFactory input) {
		VizServiceFactoryHolder.factory = input;
		Logger staticLogger = LoggerFactory
				.getLogger(VizServiceFactoryHolder.class);

		IConfigurationElement[] elements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						"org.eclipse.eavp.viz.service.IVizServiceFactory");
		staticLogger.info("Available configuration elements");
		for (IConfigurationElement element : elements) {
			staticLogger.info(element.getName());
		}

		return;
	}

	/**
	 * Remove the given VizServiceFactory if it is held by the
	 * VizServiceFactoryHolder.
	 *
	 * @input A VizServiceFactory to remove.
	 */
	public static void unsetVizServiceFactory(IVizServiceFactory input) {
		if (input == factory) {
			factory = null;
		}
		return;
	}

}