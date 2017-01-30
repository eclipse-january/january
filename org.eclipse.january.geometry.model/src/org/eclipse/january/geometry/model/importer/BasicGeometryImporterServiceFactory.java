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
import java.util.HashMap;

/**
 * A simple implementation of the IGeometryImporterServiceFactory interface.
 * 
 * @author Robert Smith
 *
 */
public class BasicGeometryImporterServiceFactory
		implements IGeometryImporterServiceFactory {

	/**
	 * The map of all registered services, keyed on their names.
	 */
	HashMap<String, IGeometryImporterService> services;

	/**
	 * The default constructor.
	 */
	public BasicGeometryImporterServiceFactory() {
		// Nothing to do
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.eavp.viz.service.geometry.importers.
	 * IGeometryImporterServiceFactory#get(java.lang.String)
	 */
	@Override
	public IGeometryImporterService get(String name) {
		return services.get(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.eavp.viz.service.geometry.importers.
	 * IGeometryImporterServiceFactory#getAll()
	 */
	@Override
	public Collection<IGeometryImporterService> getAll() {
		return services.values();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.eavp.viz.service.geometry.importers.
	 * IGeometryImporterServiceFactory#register(org.eclipse.eavp.viz.service.
	 * geometry.importers.IGeometryImporterService)
	 */
	@Override
	public void register(IGeometryImporterService service) {
		services.put(service.getName(), service);
	}

	/**
	 * Initialize the factory. It is expected that this function will be called
	 * by the OSGI layer and not the user.
	 */
	public void start() {

		// Initialize the map of services
		services = new HashMap<String, IGeometryImporterService>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.eavp.viz.service.geometry.importers.
	 * IGeometryImporterServiceFactory#unregister(org.eclipse.eavp.viz.service.
	 * geometry.importers.IGeometryImporterService)
	 */
	@Override
	public void unregister(IGeometryImporterService service) {
		services.remove(service.getName());
	}

}
