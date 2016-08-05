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
package org.eclipse.january.geometry.xtext.obj.importer;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.january.geometry.Geometry;
import org.eclipse.january.geometry.IGeometryImporter;
import org.eclipse.january.geometry.INode;
import org.eclipse.january.geometry.PolyShape;
import org.eclipse.january.geometry.xtext.OBJStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

/**
 * Imports OBJ files into Geometries for use in the Geometry Editor
 * 
 * @author Kasper Gammeltoft
 *
 */
public class OBJGeometryImporter implements IGeometryImporter {

	@Override
	public EList<String> getFileTypes() {
		BasicEList<String> list = new BasicInternalEList<String>(String.class);
		list.add("obj");
		return list;
	}

	@Override
	public String getDescription() {
		return "Imports geometry files in Wavefront's OBJ " + "file format for use in the ICE Geometry Editor";
	}

	@Override
	public Geometry load(Path path) {
		Injector injector = new OBJStandaloneSetup().createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		Resource resource = resourceSet.getResource(URI.createFileURI(path.toFile().getAbsolutePath()), true);

		// Check to see if returned contents contain a valid geometry. If not,
		// then the file might be
		// a binary format

		// Get the contents of the resource
		EList<EObject> contents = resource.getContents();

		Geometry geometry = null;

		// If they contents are valid, get the first element
		if (contents != null && !contents.isEmpty()) {
			geometry = (Geometry) contents.get(0);
		}
		
		if (geometry != null) {
			for (INode node : geometry.getNodes()) {
				node.setParent(geometry);
				if (node instanceof PolyShape) {
					geometry.getVertexSource().getMaterialFiles().addAll(((PolyShape)node).getMaterialFiles());
					((PolyShape) node).calculatePolyTriangles();
				}
			}
		}

		// Return the geometry
		return geometry;
	}

	@Override
	public EClass eClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource eResource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EObject eContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EStructuralFeature eContainingFeature() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EReference eContainmentFeature() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<EObject> eContents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeIterator<EObject> eAllContents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eIsProxy() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EList<EObject> eCrossReferences() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object eGet(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eUnset(EStructuralFeature feature) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object eInvoke(EOperation operation, EList<?> arguments) throws InvocationTargetException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<Adapter> eAdapters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eDeliver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eSetDeliver(boolean deliver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eNotify(Notification notification) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDescription(String value) {
		// TODO Auto-generated method stub

	}

}
