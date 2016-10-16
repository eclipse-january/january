/*******************************************************************************
 * Copyright (c) 2016 UT-Battelle, LLC. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Robert Smith
 *******************************************************************************/
package org.eclipse.january.geometry.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.january.geometry.Triangle;
import org.eclipse.january.geometry.Vertex;
import org.eclipse.swt.widgets.Display;

/**
 * An implementation of the Triangle interface that allows for multiple triangles to share the same vertices.
 * 
 * @author Robert Smith
 *
 */
public class ComplexTriangle extends MinimalEObjectImpl.Container implements Triangle {

	/**
	 * The Vertex that serves to specify the endpoint of the ray from the origin that will set the normal vector's direction for this triangle.
	 */
	protected Vertex normal;
	
	/**
	 * The list of vertices which make up the triangle
	 */
	protected EList<Vertex> vertices;
	
	/**
	 * The default constructor.
	 * 
	 * @param v1 The first vertex.
	 * @param v2 The second vertex.
	 * @param v3 The third vertex.
	 */
	public ComplexTriangle(Vertex v1, Vertex v2, Vertex v3){
		super();
		
		//Create a list of vertices
		vertices = new BasicEList<Vertex>();
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		//Listen to each vertex, passing along their notifications
		v1.eAdapters().add(new AdapterImpl(){
			public void notifyChanged(Notification notification) {
				eNotify(notification);
			}
		});
		
		v2.eAdapters().add(new AdapterImpl(){
			public void notifyChanged(Notification notification) {
				eNotify(notification);
			}
		});
		
		v3.eAdapters().add(new AdapterImpl(){
			public void notifyChanged(Notification notification) {
				eNotify(notification);
			}
		});
		
		normal = GeometryFactory.eINSTANCE.createVertex();
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.january.geometry.Triangle#getNormal()
	 */
	@Override
	public Vertex getNormal() {
		return normal;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.january.geometry.Triangle#setNormal(org.eclipse.january.geometry.Vertex)
	 */
	@Override
	public void setNormal(Vertex value) {
		if(normal != value){
		normal = value;
		eNotify(new ENotificationImpl(this, Notification.SET,
				GeometryPackage.TRIANGLE__NORMAL, value, value));
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.january.geometry.Triangle#getVertices()
	 */
	@Override
	public EList<Vertex> getVertices() {
		return vertices;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.common.notify.impl.BasicNotifierImpl#eNotify(org.eclipse.
	 * emf.common.notify.Notification)
	 */
	@Override
	public void eNotify(Notification notification) {
		// Check if a notification is required
		Adapter[] eAdapters = eBasicAdapterArray();
		if (eAdapters != null && eDeliver()) {

			// If this notification is on the UI thread, launch a new thread to
			// handle it
			Display currDisplay = Display.getCurrent();
			if (currDisplay != null
					&& Thread.currentThread() == currDisplay.getThread()) {

				Thread updateThread = new Thread() {

					@Override
					public void run() {
						for (int i = 0, size = eAdapters.length; i < size; ++i) {
							eAdapters[i].notifyChanged(notification);
						}
					}
				};

				updateThread.run();

			}

			// If we are already off the UI thread, such as being called by a
			// thread created by some other object's eNotify(), then just notify
			// the adapters.
			else {
				for (int i = 0, size = eAdapters.length; i < size; ++i) {
					eAdapters[i].notifyChanged(notification);
				}
			}
		}
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public boolean equals(Object otherObject) {

		// To be equal, the other object must be a triangle
		if (otherObject instanceof Triangle) {
			Triangle otherTriangle = (Triangle) otherObject;

			// Check that the normal vectors are equal
			if (normal != null) {
				if (normal.equals(otherTriangle.getNormal())) {

					// Get the other triangle's vertices
					EList<Vertex> otherVertices = otherTriangle.getVertices();

					// The triangles must both be either initialized (ie having
					// three vertices) or not to be equal
					if (getVertices().size() == otherVertices.size()) {

						// If any vertex is in one list but not the other, the
						// triangles are not equal
						for (Vertex vertex : vertices) {

							// If a match was found
							boolean match = false;

							// Search for a matching vertex
							for (Vertex otherVertex : otherVertices) {
								if (vertex.equals(otherVertex)) {
									match = true;
									break;
								}
							}

							// If one vertex was not in the other triangle, then
							// they are not equal
							if (!match) {
								return false;
							}
						}

						// All tests passed, the triangles are equal
						return true;
					}

				}
			} else {
				Vertex otherNormal = otherTriangle.getNormal();

				// If both normals are null, the triangles are equal
				if (otherNormal == null) {
					return true;
				}
			}
		}
		// One of the tests failed, so the triangles are not equal
		return false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public int hashCode() {

		// Add the normal's hash code
		int hash = 31;

		if (normal != null) {
			hash = hash * 31 + normal.hashCode();
		}

		// The list of hash codes from the vertices
		ArrayList<Integer> vertexHashes = new ArrayList<Integer>();
		
		//Populate the list for all vertex hashes
		for(Vertex v : getVertices()){
			vertexHashes.add(v.hashCode());
		}

		// We must reorder the hashes so that two triangles will have the same
		// hash code if they have the same vertices, regardless of order in the
		// list
		Collections.sort(vertexHashes);

		// Add each vertex's hash, multiplying by 31 each time.
		for (Integer vHash : vertexHashes) {
			hash = hash * 31 + vHash;
		}

		return hash;
	}
}
