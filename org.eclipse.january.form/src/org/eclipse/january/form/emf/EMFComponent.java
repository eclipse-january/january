/*******************************************************************************
 * Copyright (c) 2012, 2016 UT-Battelle, LLC.
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
package org.eclipse.january.form.emf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.eclipse.january.form.Component;
import org.eclipse.january.form.JanuaryObject;
import org.eclipse.january.form.IComponentVisitor;
import org.eclipse.january.form.TreeComposite;
import org.xml.sax.SAXException;

/**
 * The EMFComponent is a realization of the Component interface that
 * encapsulates the data in an Eclipse Modeling Framework (EMF) Ecore model
 * tree. EMFComponent takes a valid XML schema file (*.xsd) and generates an
 * Ecore model using the EMF utility class, XMLProcessor. This Ecore model is
 * then mapped to an EMFTreeComposite, a subclass of TreeComposite that keeps
 * track of a given Ecore tree node's structural EAttribute features and keeps
 * the Ecore model updated upon user modification to those attributes.
 * EMFComponent provides serialization and de-serialization routines for the
 * encapsulated XML resource.
 * 
 * @author Alex McCaskey
 */
@XmlRootElement(name = "EMFComponent")
public class EMFComponent extends JanuaryObject implements Component {

	/**
	 * Reference to the EMFTreeComposite which provides a representation of the
	 * Ecore model that the January UI expects and can visualization for user
	 * manipulation. This tree represents DocumentRoot in the EMF tree, so it
	 * should only have 1 child.
	 * 
	 */
	@XmlElement(name = "EMFTreeComposite")
	private EMFTreeComposite januaryEMFTree;

	/**
	 * Reference to the XMLProcessor that is used to read and write the
	 * EMFComponent's XML Resource.
	 * 
	 */
	@XmlTransient
	private XMLProcessor xmlProcessor;

	/**
	 * Reference to the EMF XML Resource that contains the Ecore domain model.
	 * 
	 */
	@XmlTransient
	private XMLResource xmlResource;

	/**
	 * The nullary constructor
	 * 
	 */
	public EMFComponent() {
		super();
		januaryEMFTree = new EMFTreeComposite();
		xmlResource = new XMLResourceImpl();
	}

	/**
	 * The constructor, takes a Java file pointing to the XML schema model.
	 * 
	 * @param file
	 *            The XML Schema
	 */
	public EMFComponent(File file) {
		super();

		// Initialize class data
		januaryEMFTree = new EMFTreeComposite();
		xmlResource = new XMLResourceImpl();

		// Make sure we have a valid File object.
		if (file != null) {
			// Create a new XMLProcessor to be used in creating
			// and persisting XML Resources
			try {
				xmlProcessor = new XMLProcessor(URI.createFileURI(file.getAbsolutePath()));
			} catch (SAXException e) {
				logger.error(getClass().getName() + " Exception!", e);
			}

			if (xmlProcessor != null) {

				// Get the package containing the model
				EPackage ePackage = (EPackage) xmlProcessor.getEPackageRegistry().values().toArray()[0];

				// Get the TreeIterator to walk over the elements
				TreeIterator<EObject> tree = ePackage.eAllContents();
				while (tree.hasNext()) {
					// Get the Element
					EObject obj = tree.next();

					// We only care about EClass instances bc those
					// are the nodes of the tree.
					if (obj instanceof EClass) {
						EClass eClass = (EClass) obj;
						// Add the new EMFTreeComposite corresponding to the
						// current
						// EClass instance to the mapping
						if ("DocumentRoot".equals(eClass.getName())) {
							// This will give us a root node, and the
							// constructor
							// will take care of constructing possible exemplar
							// children nodes.
							januaryEMFTree = new EMFTreeComposite(eClass);
							break;
						}
					}
				}
			}
		}

		return;
	}

	/**
	 * Return the generated EMFTreeComposite that represents the Ecore domain
	 * model.
	 * 
	 * @return
	 */
	public TreeComposite getEMFTreeComposite() {
		return januaryEMFTree;
	}

	/**
	 * Save the XMLResource to the given Java File.
	 * 
	 * @param saveFile
	 * @return
	 */
	public boolean save(File saveFile) {

		// Local Declarations
		boolean created = false;
		FileOutputStream outputStream = null;

		try {
			// If the file already exists, we are
			// going to overwrite it, so delete it first
			if (saveFile.exists()) {
				saveFile.delete();
			}

			// Create the file
			created = saveFile.createNewFile();

			if (created) {
				// Create the output stream
				outputStream = new FileOutputStream(saveFile);

				xmlResource.getContents().clear();
				xmlResource.getContents().add(januaryEMFTree.getEcoreNode());

				// Direct the XMLProcessor to save the Resource
				xmlProcessor.save(outputStream, xmlResource, null);

				outputStream.close();

				// Indicate success
				return true;
			} else {
				logger.info("[EMFComponent] Could not create save file.");
				return false;
			}

		} catch (IOException e) {
			logger.error(getClass().getName() + " Exception!", e);
			return false;
		}

	}

	/**
	 * Load the XML file with a given XML schema. This method should be used in
	 * conjuction with the nullary constructor.
	 * 
	 * @param schema
	 * @param file
	 * @return
	 */
	public boolean load(File schema, File file) {
		// Create a new XMLProcessor to be used in creating
		// and persisting XML Resources
		try {
			xmlProcessor = new XMLProcessor(URI.createFileURI(schema.getAbsolutePath()));
		} catch (SAXException e) {
			logger.error(getClass().getName() + " Exception!", e);
			return false;
		}

		return load(file);
	}

	/**
	 * Load the given File as an XMLResource.
	 * 
	 * @param file
	 * @return whether the operation was successful
	 */
	public boolean load(File file) {

		// Local Declarations
		EObject documentRoot = null;

		if (xmlProcessor != null) {
			try {
				xmlResource = (XMLResource) xmlProcessor.load(new FileInputStream(file), null);
			} catch (IOException e) {
				logger.error(getClass().getName() + " Exception!", e);
				return false;
			}
		}

		if (xmlResource != null && xmlResource.getContents().size() > 0) {
			documentRoot = xmlResource.getContents().get(0);
		} else {
			logger.error("EMFComponent Error: Could not find document root for " + file.getAbsolutePath());
			return false;
		}

		// If we have a valid document root node, we should walk
		// and create the EMFTreeComposite
		if (documentRoot != null) {
			// Create the root node EMFTreeComposite
			int id = 1;
			januaryEMFTree = new EMFTreeComposite(documentRoot);
			januaryEMFTree.setId(id);
			
			// Create the a map to store EObject keys to their corresponding
			// EMFTreeComposite value.
			HashMap<EObject, EMFTreeComposite> map = new HashMap<EObject, EMFTreeComposite>();

			// Put the root node in the tree
			map.put(documentRoot, januaryEMFTree);

			// Use the EMF tree iterator to walk the Ecore tree.
			TreeIterator<EObject> tree = documentRoot.eAllContents();
			EObject obj = null;
			EMFTreeComposite tempTree = null;
			while (tree.hasNext()){
				id++;
				obj = tree.next();
				tempTree = new EMFTreeComposite(obj);
				tempTree.setId(id);
				// Put this EObject in the map with its
				// EMFTreeComposite representation
				map.put(obj, tempTree);
			}
			
			// Loop through all the EObject keys and
			// set each EMFTreeComposite's parent
			for (EObject o : map.keySet()) {
				EObject parent = o.eContainer();
				if (parent != null) {
					map.get(parent).setNextChild(map.get(o));
				}
			}
		} else {
			return false;
		}

		return true;
	}

	/**
	 * This operation is used to check equality between the EMFComponent and
	 * another EMFComponent. It returns true if the EMFComponents are equal and
	 * false if they are not.
	 * 
	 */
	@Override
	public boolean equals(Object otherEMFComponent) {

		// Check if they are the same reference in memory
		if (this == otherEMFComponent) {
			return true;
		}

		// Check that the object is not null, and that it is a EMFComponent
		// Check that these objects have the same JanuaryObject data
		if (otherEMFComponent == null || !(otherEMFComponent instanceof EMFComponent)
				|| !super.equals(otherEMFComponent)) {
			return false;
		}

		// At this point, other object must be a EMFComponent, so cast it
		EMFComponent castedComponent = (EMFComponent) otherEMFComponent;

		// For now assume that if the TreeComposites are equal,
		// the two EMFComponents are equal
		if (!castedComponent.januaryEMFTree.equals(januaryEMFTree)) {
			logger.info("TREES NOT EQUAL");
			return false;
		}

		// If made it here, these EMFComponents are Equal
		// Return true
		return true;
	}

	/**
	 * This operation returns the hashcode value of the EMFComponent.
	 * 
	 */
	@Override
	public int hashCode() {

		// Local Declaration
		int hash = 9;

		// Compute hash code from EMFComponent data
		hash = 31 * hash + super.hashCode();
		hash = 31 * hash + januaryEMFTree.hashCode();

		return hash;
	}

	/**
	 * This operation performs a deep copy of the attributes of another
	 * EMFComponent into the current EMFComponent.
	 * 
	 * @param otherEMFComponent
	 */
	public void copy(EMFComponent otherEMFComponent) {

		// Return if otherEMFComponenet is null
		if (otherEMFComponent != null) {

			// Copy contents into super and current object
			super.copy(otherEMFComponent);

			// TODO Do rest of copy...
			// FIXME ECOREUTILS
			januaryEMFTree.copy(otherEMFComponent.januaryEMFTree);
			// documentRoot = EcoreUtil.copy(otherEMFComponent.documentRoot);

			notifyListeners();
		}
		return;
	}

	/**
	 * This operation provides a deep copy of the EMFComponent.
	 * 
	 */
	@Override
	public Object clone() {

		// Create a new instance, copy contents and return it
		EMFComponent emfComponent = new EMFComponent();
		if (januaryEMFTree.getEcoreMetaData() != null) {
			emfComponent.januaryEMFTree.setECoreNodeMetaData(januaryEMFTree.getEcoreMetaData());
		}
		emfComponent.copy(this);

		return emfComponent;
	}

	@Override
	public void accept(IComponentVisitor visitor) {
		visitor.visit(this);
	}

	/**
	 * Save the XMLResource to stdout. This is mainly for debugging.
	 * 
	 * @return Always true if successful, false otherwise.
	 */
	public boolean save() {

		// Create a new XMLResource and add the Ecore model to it
		// xmlResource.getContents().clear();
		if (januaryEMFTree.getEcoreNode() != null) {
			xmlResource.getContents().add(januaryEMFTree.getEcoreNode());

			// Write to standard out
			try {
				xmlProcessor.save(System.out, xmlResource, null);
			} catch (IOException e) {
				logger.error(getClass().getName() + " Exception!", e);
				return false;
			}
			return true;
		} else {
			return true;
		}
	}

	/**
	 * Save the XMLResource to a java.lang.String
	 * 
	 * @return
	 */
	public String saveToString() {
		String retString = null;
		try {
			retString = xmlProcessor.saveToString(xmlResource, null);
		} catch (IOException e) {
			logger.error(getClass().getName() + " Exception!", e);
			return null;
		}
		return retString;
	}

}
