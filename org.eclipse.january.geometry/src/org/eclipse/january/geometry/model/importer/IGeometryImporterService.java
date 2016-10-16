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

import java.nio.file.Path;
import java.util.Set;

import org.eclipse.january.geometry.Geometry;

/**
 * This is an interface for classes handling the importing of a file into a
 * Geometry. It is intended that classes implementing this interface will be
 * consumed as an OSGI service by an IGeometryImporterFactory.
 * 
 * @author Robert Smith
 *
 */
public interface IGeometryImporterService {

	/**
	 * Getter method for the importer's name.
	 * 
	 * @return The name, which should be a short, human readable description of
	 *         the importer.
	 */
	String getName();

	/**
	 * Import a file into a Geometry.
	 * 
	 * @param path
	 *            The path to the file which is to be imported.
	 * @return A Geometry containing a representation of the data in the file or
	 *         null if the file could not be imported.
	 */
	Geometry importFile(Path path);

	/**
	 * Get the set of file extensions which this importer is capable of
	 * handling.
	 * 
	 * @return A set of all file extensions this importer can import. Extensions
	 *         will be listed in all lower case with no leading period.
	 */
	Set<String> getSupportedExtensions();
}
