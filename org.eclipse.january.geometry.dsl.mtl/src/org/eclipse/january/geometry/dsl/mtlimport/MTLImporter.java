/*******************************************************************************
 * Copyright (c) 2016 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - Kasper
 *   Gammeltoft
 *******************************************************************************/
package org.eclipse.january.geometry.dsl.mtlimport;

import java.nio.file.Path;
import java.util.ArrayList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.january.geometry.dsl.mTL.Material;
import org.eclipse.january.geometry.dsl.mTL.MaterialSource;
import org.eclipse.january.geometry.dsl.MTLStandaloneSetup;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

/**
 * 
 * @author Kasper Gammeltoft
 *
 */
public class MTLImporter {

	/**
	 * Loads the materials from the specified material file
	 * 
	 * @param path
	 *            The path to the material file
	 * @return Returns an array list with the materials specified in the file,
	 *         or returns null if no materials were specified or the file didn't
	 *         load properly
	 */
	public ArrayList<Material> load(Path path) {
		// Load the file with the Xtext resources
		Injector injector = new MTLStandaloneSetup()
				.createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = injector
				.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL,
				Boolean.TRUE);

		Resource resource = null;
		try {
			resource = resourceSet.getResource(
					URI.createFileURI(path.toFile().getAbsolutePath()), true);
		} catch (Exception e) {

			// Display an error if an unreadable file was selected.
			ErrorDialog.openError(Display.getCurrent().getActiveShell(),
					"Error Importing Geometry File",
					"Error while importing material file(s).",
					new Status(IStatus.ERROR,
							"org.eclipse.january.geometry.xtext",
							e.getMessage()));
		}
		;

		// Get the contents of the resource
		EList<EObject> contents = resource.getContents();

		ArrayList<Material> materials = null;

		// Get the materials from the material source
		if (!contents.isEmpty() && contents.get(0) instanceof MaterialSource) {
			MaterialSource source = (MaterialSource) contents.get(0);
			materials = new ArrayList<Material>();
			materials.addAll(source.getMaterials());
		}
		return materials;
	}

}
