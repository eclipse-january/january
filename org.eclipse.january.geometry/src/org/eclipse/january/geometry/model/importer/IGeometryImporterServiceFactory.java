/*******************************************************************************
 * Copyright (c) 2016 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Robert Smith
 *******************************************************************************/
package org.eclipse.january.geometry.model.importer;

import java.util.Collection;

/**
 * This is an interface for classes handling the importing of a file into a
 * Geometry. It is intended that classes implementing this interface will be
 * consumed as an OSGI service by an IGeometryImporterFactory.
 * 
 * @author Robert Smith
 *
 */
public interface IGeometryImporterServiceFactory {

	/**
	 * Gets the IGeometryImporterServiceFactory with the given name.
	 * 
	 * @param name
	 *            The name of the service to be retrieved.
	 * @return The service with the given name, or null if no such service is
	 *         registered.
	 */
	IGeometryImporterService get(String name);

	/**
	 * Get all registered services.
	 * 
	 * @return A collection containing every service in the factory.
	 */
	Collection<IGeometryImporterService> getAll();

	/**
	 * Register a service to be provided by this factory. It is intended that
	 * this method will be invoked by the OSGI framework and not by users.
	 * 
	 * @param service
	 *            The new service to be added to the factory.
	 */
	void register(IGeometryImporterService service);

	/**
	 * Unregister a service from the factory. It is intended that this method
	 * will be invoked by the OSGI framework and not by users.
	 * 
	 * @param service
	 *            The service to be removed from the factory.
	 */
	void unregister(IGeometryImporterService service);
}
