/**
 */
package geometry;

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
 * </p>
 * <ul>
 *   <li>{@link geometry.INode#getName <em>Name</em>}</li>
 *   <li>{@link geometry.INode#getId <em>Id</em>}</li>
 *   <li>{@link geometry.INode#getNodes <em>Nodes</em>}</li>
 *   <li>{@link geometry.INode#getType <em>Type</em>}</li>
 *   <li>{@link geometry.INode#getTriangles <em>Triangles</em>}</li>
 * </ul>
 *
 * @see geometry.GeometryPackage#getINode()
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
	 * @see geometry.GeometryPackage#getINode_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link geometry.INode#getName <em>Name</em>}' attribute.
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
	 * @see geometry.GeometryPackage#getINode_Id()
	 * @model
	 * @generated
	 */
	long getId();

	/**
	 * Sets the value of the '{@link geometry.INode#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(long value);

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link geometry.INode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of nodes that compose the head node.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see geometry.GeometryPackage#getINode_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<INode> getNodes();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A string representing the type of entity this node represents in the tree in a human readable way. Example values might include "cube", "sphere" or "intersection."
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see geometry.GeometryPackage#getINode_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link geometry.INode#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Triangles</b></em>' containment reference list.
	 * The list contents are of type {@link geometry.Triangle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A series of triangles which comprise the mesh which will represent this object graphically. If this list is empty, it will be the responsibility of other classes to determine, based on this INode's "type", what mesh, if any, should be displayed for it.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Triangles</em>' containment reference list.
	 * @see geometry.GeometryPackage#getINode_Triangles()
	 * @model containment="true"
	 * @generated
	 */
	EList<Triangle> getTriangles();

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
	 * @model
	 * @generated
	 */
	void changeDecoratorProperty(String property, EObject value);
} // INode
