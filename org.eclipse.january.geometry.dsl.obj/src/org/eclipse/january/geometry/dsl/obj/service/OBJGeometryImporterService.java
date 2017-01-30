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
package org.eclipse.january.geometry.dsl.obj.service;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.january.geometry.Geometry;
import org.eclipse.january.geometry.dsl.obj.importer.OBJGeometryImporter;
import org.eclipse.january.geometry.model.importer.IGeometryImporterService;

/**
 * A service to import OBJ files into a geometry.
 * 
 * @author Robert Smith
 *
 */
public class OBJGeometryImporterService implements IGeometryImporterService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.eavp.viz.service.geometry.importers.IGeometryImporterService#
	 * getName()
	 */
	@Override
	public String getName() {
		return "obj importer";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.eavp.viz.service.geometry.importers.IGeometryImporterService#
	 * importFile(java.nio.file.Path)
	 */
	@Override
	public Geometry importFile(Path path) {
		return new OBJGeometryImporter().load(path);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.eavp.viz.service.geometry.importers.IGeometryImporterService#
	 * getSupportedExtensions()
	 */
	@Override
	public Set<String> getSupportedExtensions() {
		HashSet<String> extensions = new HashSet<String>();
		extensions.add("obj");
		return extensions;
	}

}
