/*******************************************************************************
 * Copyright (c) 2013, 2014- UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - Jay Jay Billings,
 *   Jordan H. Deyton, Dasha Gorin, Alexander J. McCaskey, Taylor Patterson,
 *   Claire Saunders, Matthew Wang, Anna Wojtowicz
 *******************************************************************************/

package org.eclipse.ice.datastructures.resource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * <p>This class acts as a manager for discovering and creating resource objects
 * in ICE. Resources in ICE can be used in Model Items for things such as
 * displaying the contents of a mesh file, or in Launcher Items for tasks such
 * as plotting the contents of a post-processed CSV file.</p>
 * 
 * <p>Some resources contain visualization data and can be rendered via the
 * {@link IVizService} declarative service. A private list of all file 
 * extensions that have a IVizService implementation is maintained and used for
 * cross reference. If a file extension matches one found in this private list, 
 * the associated recourse will be a {@link VizResource}, otherwise it will be 
 * just a regular {@link ICEResource}.</p>
 * 
 * <p>This class' methods are intended to be called by Items directly, using the
 * {@link #Item.getProcess(String) Item.getProcess(...)} method.</p>
 * 
 * @author Anna Wojtowicz
 *
 */

public class ResourceHandler {
	
	/**
	 * The list of file extensions that indicate a resource should be made into
	 * a {@link VizResource}.
	 */
	private static ArrayList<String> vizFileExtensions;
	
	/**
	 * Nullary constructor. This constructor is also responsible for initiating 
	 * and constructing the {@link #vizFileExtensions} list.
	 */
	public ResourceHandler() {
		
		// Initiate the list of VizResource file extensions if it hasn't been
		// already
		if (vizFileExtensions == null) {
			vizFileExtensions = new ArrayList<String>(3);
			
			// Add entries to the list; make sure they are lowercase!
			vizFileExtensions.add("csv");
			vizFileExtensions.add("e");
			vizFileExtensions.add("silo");
		}
		
		return;
	}

	/**
	 * <p>This method is the star of the {@link ResourceHandler} class and does 
	 * the majority of the heavy-lifting.</p>
	 * 
	 * <p> Based on the filepath passed in, it will create and return a 
	 * {@link VizResource} if it has a file extension found in the 
	 * {@link #vizFileExtensions} list. If the file extension is not found in 
	 * the list, then it will create and return a regular {@link ICEResource}.
	 * If no valid file extension was found, it will return null.
	 * 
	 * @param filePath	The file path to the resource file.
	 * @return			Returns a {@link VizResource} or {@link ICEResource} 
	 * 					depending on the file path, or null if the file path 
	 * 					was invalid.
	 * @throws IOException
	 */
	public ICEResource getResource(String filePath) throws IOException {
		
		// Local declarations
		ICEResource resource = null;
		File file = null;
		
		// Make sure the file path is valid first
		if (!filePath.isEmpty()) {
			file = new File(filePath);
		} else {
			// If the file path is empty, complain and exit
			System.out.println("ResourceHandler Message: The file path was "
					+ "empty!");
			
			return resource;
		}
		
		// Check the file path is valid
		if (file != null && file.exists()) {			

			// Get the file extension of the file
			int lastDot = filePath.lastIndexOf(".");
			String fileExt = "";
			if (lastDot != -1) {
				// If a proper file extension is found, grab it (not including
				// the dot)
				fileExt = filePath.substring(lastDot+1);
			} else {
				// If no proper file extension was found, complain and exit
				System.out.println("ResourceHandler Message: The file path "
						+ "does not have a valid file extension: "
						+ filePath);
				
				return resource;
			}
			
			// Use the file extension to determine what kind of ICE resource
			// to create
			if (vizFileExtensions.contains(fileExt.toLowerCase())) {
				
				// If the file extension was found in the vizFileExtensions
				// list, create a VizResource object.
				resource = new VizResource(file);
	
			} else {
				
				// If the file extension wasn't found in the vizFileExtensions
				// list, create a regular ICEResource.
				resource = new ICEResource(file);
			}
		
		}
		
		return resource;
		
	}
	
	/**
	 * This method calls {@link #getResource(String)} and then sets the
	 * resource's name.
	 * 
	 * @param filePath	The file path to the resource file.
	 * @param name		The name of the resource object.
	 * @return			Returns a {@link VizResource} or {@link ICEResource} 
	 * 					depending on the file path, or null if the file path 
	 * 					was invalid.
	 * @throws IOException
	 */
	public ICEResource getResource(String filePath, String name) 
			throws IOException {
		
		// Get the resource and set its name
		ICEResource resource = getResource(filePath);
		
		if (resource != null) {
			resource.setName(name);
		}
		
		return resource;
	}
	
	/**
	 * This method calls {@link #getResource(String, String)} and then sets the
	 * resource's ID.
	 * 
	 * @param filePath	The file path to the resource file.
	 * @param name		The name of the resource object.
	 * @param id		The ID of the resource object.
	 * @return			Returns a {@link VizResource} or {@link ICEResource} 
	 * 					depending on the file path, or null if the file path 
	 * 					was invalid.
	 * @throws IOException
	 */
	public ICEResource getResource(String filePath, String name, int id) 
			throws IOException {
		
		// Get the resource and set its name and ID
		ICEResource resource = getResource(filePath, name);
		
		if (resource != null) {
			resource.setId(id);
		}
		
		return resource;	
	}
	
	/**
	 * This method calls {@link #getResource(String, String, int)} and then 
	 * sets the resource's description.
	 * 
	 * @param filePath	The file path to the resource file.
	 * @param name		The name of the resource object.
	 * @param id		The ID of the resource object.
	 * @param desc		The description of the resource object.
	 * @return			Returns a {@link VizResource} or {@link ICEResource} 
	 * 					depending on the file path, or null if the file path 
	 * 					was invalid.
	 * @throws IOException
	 */
	public ICEResource getResource(String filePath, String name, int id, 
			String desc) throws IOException {
		
		// Get the resource and set it's name, ID and description
		ICEResource resource = getResource(filePath, name, id);
		
		if (resource != null) {
			resource.setDescription(desc);
		}
		
		return resource;
	}
}
