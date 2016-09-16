/*******************************************************************************
 * Copyright (c) 2016 UT-Battelle, LLC. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     UT-Battelle, LLC. - initial API and implementation
 *******************************************************************************/
package org.eclipse.january.geometry;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>INode</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An INode represents a single node in a geometry tree.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.INode#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.INode#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.INode#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.INode#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.INode#getTriangles <em>Triangles</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.INode#getCenter <em>Center</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.INode#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.january.geometry.GeometryPackage#getINode()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface INode extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the node.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.january.geometry.GeometryPackage#getINode_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.INode#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An optional node id to identify the node numerically.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(long)
	 * @see org.eclipse.january.geometry.GeometryPackage#getINode_Id()
	 * @model
	 * @generated
	 */
	long getId();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.INode#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(long value);

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.january.geometry.INode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of nodes that compose the head node.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.eclipse.january.geometry.GeometryPackage#getINode_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<INode> getNodes();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A string representing the type of entity this node represents in the tree in a human readable way. Example values might include "cube", "sphere" or "intersection."
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.eclipse.january.geometry.GeometryPackage#getINode_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.INode#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Triangles</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.january.geometry.Triangle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A series of triangles which comprise the mesh which will represent this object graphically. If this list is empty, it will be the responsibility of other classes to determine, based on this INode's "type", what mesh, if any, should be displayed for it.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Triangles</em>' containment reference list.
	 * @see org.eclipse.january.geometry.GeometryPackage#getINode_Triangles()
	 * @model containment="true"
	 * @generated
	 */
	EList<Triangle> getTriangles();

	/**
	 * Returns the value of the '<em><b>Center</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Each shape is centered on a special vertex.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Center</em>' reference.
	 * @see #setCenter(Vertex)
	 * @see org.eclipse.january.geometry.GeometryPackage#getINode_Center()
	 * @model required="true"
	 * @generated
	 */
	Vertex getCenter();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.INode#getCenter <em>Center</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Center</em>' reference.
	 * @see #getCenter()
	 * @generated
	 */
	void setCenter(Vertex value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(INode)
	 * @see org.eclipse.january.geometry.GeometryPackage#getINode_Parent()
	 * @model
	 * @generated
	 */
	INode getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.INode#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(INode value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Fire a notification that will alert decorator pattern classes registered to this object that they should change their state.
	 * 
	 * This method is intended to cause change in the INode's graphical representation in a non-permanent way, by modifying qualities such as opacity which are purely concerned with rendering and do not belong to the modeling data itself.
	 * 
	 * "Property" should offer sufficient description for the client to determine "value"'s type.
	 * <!-- end-model-doc -->
	 * @model valueDataType="org.eclipse.january.geometry.Object"
	 * @generated
	 */
	void changeDecoratorProperty(String property, Object value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get the names of all properties set for this shape.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='//Return a list of the properties\' keys.\r\nreturn new BasicEList<String>(properties.keySet());'"
	 * @generated
	 */
	EList<String> getPropertyNames();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get the value for one of the shape's properties.
	 * @param property The name of the property whose value is to be returned.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return properties.get(property);'"
	 * @generated
	 */
	double getProperty(String property);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Set one of the Shape's properties.
	 * @param property The name of the property whose value is being set.
	 * @param value The property's new value.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='properties.put(property, value);'"
	 * @generated
	 */
	void setProperty(String property, double value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Add a child to the list of children nodes contained by this object.
	 * 
	 * It is intended that users will use addNode() instead of adding objects directly to the nodes list to properly maintain the child's parent attribute.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	void addNode(INode child);
	
	/**
	 * Allows for multiple nodes to be added simultaneously, maintaining the parent reference for each new node.
	 * @param children List of nodes to add as children under this node
	 * @generated NOT
	 */
	void addNodes(EList<INode> children);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Remove a child from the list of children nodes contained by this object.
	 * 
	 * It is intended that users will use removeNode() instead of adding objects directly to the nodes list to properly maintain the child's parent attribute.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	void removeNode(INode child);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Make this object a copy of the source object, if the source object is of an appropriate type.
	 * <!-- end-model-doc -->
	 * @model sourceDataType="org.eclipse.january.geometry.Object"
	 * @generated
	 */
	void copy(Object source);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Create a copy of this object.
	 * <!-- end-model-doc -->
	 * @model dataType="org.eclipse.january.geometry.Object"
	 * @generated
	 */
	Object clone();

} // INode
