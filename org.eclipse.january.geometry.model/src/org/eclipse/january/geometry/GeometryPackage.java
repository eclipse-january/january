/**
 */
package org.eclipse.january.geometry;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.january.geometry.GeometryFactory
 * @model kind="package"
 * @generated
 */
public interface GeometryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "geometry";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/january/geometry";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "january";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GeometryPackage eINSTANCE = org.eclipse.january.geometry.impl.GeometryPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.january.geometry.INode <em>INode</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.january.geometry.INode
	 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getINode()
	 * @generated
	 */
	int INODE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INODE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INODE__ID = 1;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INODE__NODES = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INODE__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Triangles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INODE__TRIANGLES = 4;

	/**
	 * The feature id for the '<em><b>Center</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INODE__CENTER = 5;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INODE__PARENT = 6;

	/**
	 * The number of structural features of the '<em>INode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INODE_FEATURE_COUNT = 7;

	/**
	 * The operation id for the '<em>Change Decorator Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INODE___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT = 0;

	/**
	 * The operation id for the '<em>Get Property Names</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INODE___GET_PROPERTY_NAMES = 1;

	/**
	 * The operation id for the '<em>Get Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INODE___GET_PROPERTY__STRING = 2;

	/**
	 * The operation id for the '<em>Set Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INODE___SET_PROPERTY__STRING_DOUBLE = 3;

	/**
	 * The operation id for the '<em>Add Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INODE___ADD_NODE__INODE = 4;

	/**
	 * The operation id for the '<em>Remove Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INODE___REMOVE_NODE__INODE = 5;

	/**
	 * The operation id for the '<em>Copy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INODE___COPY__OBJECT = 6;

	/**
	 * The operation id for the '<em>Clone</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INODE___CLONE = 7;

	/**
	 * The number of operations of the '<em>INode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INODE_OPERATION_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.january.geometry.impl.ShapeImpl <em>Shape</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.january.geometry.impl.ShapeImpl
	 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getShape()
	 * @generated
	 */
	int SHAPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE__NAME = INODE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE__ID = INODE__ID;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE__NODES = INODE__NODES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE__TYPE = INODE__TYPE;

	/**
	 * The feature id for the '<em><b>Triangles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE__TRIANGLES = INODE__TRIANGLES;

	/**
	 * The feature id for the '<em><b>Center</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE__CENTER = INODE__CENTER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE__PARENT = INODE__PARENT;

	/**
	 * The feature id for the '<em><b>Material</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE__MATERIAL = INODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Shape</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE_FEATURE_COUNT = INODE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Change Decorator Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT = INODE___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT;

	/**
	 * The operation id for the '<em>Get Property Names</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE___GET_PROPERTY_NAMES = INODE___GET_PROPERTY_NAMES;

	/**
	 * The operation id for the '<em>Get Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE___GET_PROPERTY__STRING = INODE___GET_PROPERTY__STRING;

	/**
	 * The operation id for the '<em>Set Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE___SET_PROPERTY__STRING_DOUBLE = INODE___SET_PROPERTY__STRING_DOUBLE;

	/**
	 * The operation id for the '<em>Add Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE___ADD_NODE__INODE = INODE___ADD_NODE__INODE;

	/**
	 * The operation id for the '<em>Remove Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE___REMOVE_NODE__INODE = INODE___REMOVE_NODE__INODE;

	/**
	 * The operation id for the '<em>Copy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE___COPY__OBJECT = INODE___COPY__OBJECT;

	/**
	 * The operation id for the '<em>Clone</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE___CLONE = INODE___CLONE;

	/**
	 * The number of operations of the '<em>Shape</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE_OPERATION_COUNT = INODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.january.geometry.impl.TriangleImpl <em>Triangle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.january.geometry.impl.TriangleImpl
	 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getTriangle()
	 * @generated
	 */
	int TRIANGLE = 1;

	/**
	 * The feature id for the '<em><b>Normal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIANGLE__NORMAL = 0;

	/**
	 * The feature id for the '<em><b>Vertices</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIANGLE__VERTICES = 1;

	/**
	 * The number of structural features of the '<em>Triangle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIANGLE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Triangle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIANGLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.january.geometry.impl.VertexImpl <em>Vertex</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.january.geometry.impl.VertexImpl
	 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getVertex()
	 * @generated
	 */
	int VERTEX = 2;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__X = 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__Y = 1;

	/**
	 * The feature id for the '<em><b>Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__Z = 2;

	/**
	 * The number of structural features of the '<em>Vertex</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>Clone</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX___CLONE = 0;

	/**
	 * The number of operations of the '<em>Vertex</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.january.geometry.impl.SphereImpl <em>Sphere</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.january.geometry.impl.SphereImpl
	 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getSphere()
	 * @generated
	 */
	int SPHERE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPHERE__NAME = SHAPE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPHERE__ID = SHAPE__ID;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPHERE__NODES = SHAPE__NODES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPHERE__TYPE = SHAPE__TYPE;

	/**
	 * The feature id for the '<em><b>Triangles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPHERE__TRIANGLES = SHAPE__TRIANGLES;

	/**
	 * The feature id for the '<em><b>Center</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPHERE__CENTER = SHAPE__CENTER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPHERE__PARENT = SHAPE__PARENT;

	/**
	 * The feature id for the '<em><b>Material</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPHERE__MATERIAL = SHAPE__MATERIAL;

	/**
	 * The feature id for the '<em><b>Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPHERE__RADIUS = SHAPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sphere</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPHERE_FEATURE_COUNT = SHAPE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Change Decorator Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPHERE___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT = SHAPE___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT;

	/**
	 * The operation id for the '<em>Get Property Names</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPHERE___GET_PROPERTY_NAMES = SHAPE___GET_PROPERTY_NAMES;

	/**
	 * The operation id for the '<em>Get Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPHERE___GET_PROPERTY__STRING = SHAPE___GET_PROPERTY__STRING;

	/**
	 * The operation id for the '<em>Set Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPHERE___SET_PROPERTY__STRING_DOUBLE = SHAPE___SET_PROPERTY__STRING_DOUBLE;

	/**
	 * The operation id for the '<em>Add Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPHERE___ADD_NODE__INODE = SHAPE___ADD_NODE__INODE;

	/**
	 * The operation id for the '<em>Remove Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPHERE___REMOVE_NODE__INODE = SHAPE___REMOVE_NODE__INODE;

	/**
	 * The operation id for the '<em>Copy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPHERE___COPY__OBJECT = SHAPE___COPY__OBJECT;

	/**
	 * The operation id for the '<em>Clone</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPHERE___CLONE = SHAPE___CLONE;

	/**
	 * The number of operations of the '<em>Sphere</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPHERE_OPERATION_COUNT = SHAPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.january.geometry.impl.CubeImpl <em>Cube</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.january.geometry.impl.CubeImpl
	 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getCube()
	 * @generated
	 */
	int CUBE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUBE__NAME = SHAPE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUBE__ID = SHAPE__ID;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUBE__NODES = SHAPE__NODES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUBE__TYPE = SHAPE__TYPE;

	/**
	 * The feature id for the '<em><b>Triangles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUBE__TRIANGLES = SHAPE__TRIANGLES;

	/**
	 * The feature id for the '<em><b>Center</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUBE__CENTER = SHAPE__CENTER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUBE__PARENT = SHAPE__PARENT;

	/**
	 * The feature id for the '<em><b>Material</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUBE__MATERIAL = SHAPE__MATERIAL;

	/**
	 * The feature id for the '<em><b>Side Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUBE__SIDE_LENGTH = SHAPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cube</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUBE_FEATURE_COUNT = SHAPE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Change Decorator Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUBE___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT = SHAPE___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT;

	/**
	 * The operation id for the '<em>Get Property Names</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUBE___GET_PROPERTY_NAMES = SHAPE___GET_PROPERTY_NAMES;

	/**
	 * The operation id for the '<em>Get Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUBE___GET_PROPERTY__STRING = SHAPE___GET_PROPERTY__STRING;

	/**
	 * The operation id for the '<em>Set Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUBE___SET_PROPERTY__STRING_DOUBLE = SHAPE___SET_PROPERTY__STRING_DOUBLE;

	/**
	 * The operation id for the '<em>Add Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUBE___ADD_NODE__INODE = SHAPE___ADD_NODE__INODE;

	/**
	 * The operation id for the '<em>Remove Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUBE___REMOVE_NODE__INODE = SHAPE___REMOVE_NODE__INODE;

	/**
	 * The operation id for the '<em>Copy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUBE___COPY__OBJECT = SHAPE___COPY__OBJECT;

	/**
	 * The operation id for the '<em>Clone</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUBE___CLONE = SHAPE___CLONE;

	/**
	 * The number of operations of the '<em>Cube</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUBE_OPERATION_COUNT = SHAPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.january.geometry.impl.CylinderImpl <em>Cylinder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.january.geometry.impl.CylinderImpl
	 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getCylinder()
	 * @generated
	 */
	int CYLINDER = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYLINDER__NAME = SHAPE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYLINDER__ID = SHAPE__ID;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYLINDER__NODES = SHAPE__NODES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYLINDER__TYPE = SHAPE__TYPE;

	/**
	 * The feature id for the '<em><b>Triangles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYLINDER__TRIANGLES = SHAPE__TRIANGLES;

	/**
	 * The feature id for the '<em><b>Center</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYLINDER__CENTER = SHAPE__CENTER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYLINDER__PARENT = SHAPE__PARENT;

	/**
	 * The feature id for the '<em><b>Material</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYLINDER__MATERIAL = SHAPE__MATERIAL;

	/**
	 * The feature id for the '<em><b>Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYLINDER__RADIUS = SHAPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYLINDER__HEIGHT = SHAPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Cylinder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYLINDER_FEATURE_COUNT = SHAPE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Change Decorator Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYLINDER___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT = SHAPE___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT;

	/**
	 * The operation id for the '<em>Get Property Names</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYLINDER___GET_PROPERTY_NAMES = SHAPE___GET_PROPERTY_NAMES;

	/**
	 * The operation id for the '<em>Get Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYLINDER___GET_PROPERTY__STRING = SHAPE___GET_PROPERTY__STRING;

	/**
	 * The operation id for the '<em>Set Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYLINDER___SET_PROPERTY__STRING_DOUBLE = SHAPE___SET_PROPERTY__STRING_DOUBLE;

	/**
	 * The operation id for the '<em>Add Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYLINDER___ADD_NODE__INODE = SHAPE___ADD_NODE__INODE;

	/**
	 * The operation id for the '<em>Remove Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYLINDER___REMOVE_NODE__INODE = SHAPE___REMOVE_NODE__INODE;

	/**
	 * The operation id for the '<em>Copy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYLINDER___COPY__OBJECT = SHAPE___COPY__OBJECT;

	/**
	 * The operation id for the '<em>Clone</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYLINDER___CLONE = SHAPE___CLONE;

	/**
	 * The number of operations of the '<em>Cylinder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYLINDER_OPERATION_COUNT = SHAPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.january.geometry.impl.GeometryImpl <em>Geometry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.january.geometry.impl.GeometryImpl
	 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getGeometry()
	 * @generated
	 */
	int GEOMETRY = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY__NAME = INODE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY__ID = INODE__ID;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY__NODES = INODE__NODES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY__TYPE = INODE__TYPE;

	/**
	 * The feature id for the '<em><b>Triangles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY__TRIANGLES = INODE__TRIANGLES;

	/**
	 * The feature id for the '<em><b>Center</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY__CENTER = INODE__CENTER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY__PARENT = INODE__PARENT;

	/**
	 * The number of structural features of the '<em>Geometry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY_FEATURE_COUNT = INODE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Change Decorator Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT = INODE___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT;

	/**
	 * The operation id for the '<em>Get Property Names</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY___GET_PROPERTY_NAMES = INODE___GET_PROPERTY_NAMES;

	/**
	 * The operation id for the '<em>Get Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY___GET_PROPERTY__STRING = INODE___GET_PROPERTY__STRING;

	/**
	 * The operation id for the '<em>Set Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY___SET_PROPERTY__STRING_DOUBLE = INODE___SET_PROPERTY__STRING_DOUBLE;

	/**
	 * The operation id for the '<em>Add Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY___ADD_NODE__INODE = INODE___ADD_NODE__INODE;

	/**
	 * The operation id for the '<em>Remove Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY___REMOVE_NODE__INODE = INODE___REMOVE_NODE__INODE;

	/**
	 * The operation id for the '<em>Copy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY___COPY__OBJECT = INODE___COPY__OBJECT;

	/**
	 * The operation id for the '<em>Clone</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY___CLONE = INODE___CLONE;

	/**
	 * The number of operations of the '<em>Geometry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY_OPERATION_COUNT = INODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.january.geometry.impl.TubeImpl <em>Tube</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.january.geometry.impl.TubeImpl
	 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getTube()
	 * @generated
	 */
	int TUBE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUBE__NAME = SHAPE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUBE__ID = SHAPE__ID;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUBE__NODES = SHAPE__NODES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUBE__TYPE = SHAPE__TYPE;

	/**
	 * The feature id for the '<em><b>Triangles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUBE__TRIANGLES = SHAPE__TRIANGLES;

	/**
	 * The feature id for the '<em><b>Center</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUBE__CENTER = SHAPE__CENTER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUBE__PARENT = SHAPE__PARENT;

	/**
	 * The feature id for the '<em><b>Material</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUBE__MATERIAL = SHAPE__MATERIAL;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUBE__HEIGHT = SHAPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inner Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUBE__INNER_RADIUS = SHAPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUBE__RADIUS = SHAPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Tube</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUBE_FEATURE_COUNT = SHAPE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Change Decorator Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUBE___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT = SHAPE___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT;

	/**
	 * The operation id for the '<em>Get Property Names</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUBE___GET_PROPERTY_NAMES = SHAPE___GET_PROPERTY_NAMES;

	/**
	 * The operation id for the '<em>Get Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUBE___GET_PROPERTY__STRING = SHAPE___GET_PROPERTY__STRING;

	/**
	 * The operation id for the '<em>Set Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUBE___SET_PROPERTY__STRING_DOUBLE = SHAPE___SET_PROPERTY__STRING_DOUBLE;

	/**
	 * The operation id for the '<em>Add Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUBE___ADD_NODE__INODE = SHAPE___ADD_NODE__INODE;

	/**
	 * The operation id for the '<em>Remove Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUBE___REMOVE_NODE__INODE = SHAPE___REMOVE_NODE__INODE;

	/**
	 * The operation id for the '<em>Copy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUBE___COPY__OBJECT = SHAPE___COPY__OBJECT;

	/**
	 * The operation id for the '<em>Clone</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUBE___CLONE = SHAPE___CLONE;

	/**
	 * The number of operations of the '<em>Tube</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUBE_OPERATION_COUNT = SHAPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.january.geometry.impl.OperatorImpl <em>Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.january.geometry.impl.OperatorImpl
	 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getOperator()
	 * @generated
	 */
	int OPERATOR = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__NAME = INODE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__ID = INODE__ID;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__NODES = INODE__NODES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__TYPE = INODE__TYPE;

	/**
	 * The feature id for the '<em><b>Triangles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__TRIANGLES = INODE__TRIANGLES;

	/**
	 * The feature id for the '<em><b>Center</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__CENTER = INODE__CENTER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__PARENT = INODE__PARENT;

	/**
	 * The number of structural features of the '<em>Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_FEATURE_COUNT = INODE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Change Decorator Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT = INODE___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT;

	/**
	 * The operation id for the '<em>Get Property Names</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___GET_PROPERTY_NAMES = INODE___GET_PROPERTY_NAMES;

	/**
	 * The operation id for the '<em>Get Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___GET_PROPERTY__STRING = INODE___GET_PROPERTY__STRING;

	/**
	 * The operation id for the '<em>Set Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___SET_PROPERTY__STRING_DOUBLE = INODE___SET_PROPERTY__STRING_DOUBLE;

	/**
	 * The operation id for the '<em>Add Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___ADD_NODE__INODE = INODE___ADD_NODE__INODE;

	/**
	 * The operation id for the '<em>Remove Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___REMOVE_NODE__INODE = INODE___REMOVE_NODE__INODE;

	/**
	 * The operation id for the '<em>Copy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___COPY__OBJECT = INODE___COPY__OBJECT;

	/**
	 * The operation id for the '<em>Clone</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___CLONE = INODE___CLONE;

	/**
	 * The number of operations of the '<em>Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_OPERATION_COUNT = INODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.january.geometry.impl.UnionImpl <em>Union</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.january.geometry.impl.UnionImpl
	 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getUnion()
	 * @generated
	 */
	int UNION = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION__NAME = OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION__ID = OPERATOR__ID;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION__NODES = OPERATOR__NODES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION__TYPE = OPERATOR__TYPE;

	/**
	 * The feature id for the '<em><b>Triangles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION__TRIANGLES = OPERATOR__TRIANGLES;

	/**
	 * The feature id for the '<em><b>Center</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION__CENTER = OPERATOR__CENTER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION__PARENT = OPERATOR__PARENT;

	/**
	 * The number of structural features of the '<em>Union</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Change Decorator Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT = OPERATOR___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT;

	/**
	 * The operation id for the '<em>Get Property Names</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION___GET_PROPERTY_NAMES = OPERATOR___GET_PROPERTY_NAMES;

	/**
	 * The operation id for the '<em>Get Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION___GET_PROPERTY__STRING = OPERATOR___GET_PROPERTY__STRING;

	/**
	 * The operation id for the '<em>Set Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION___SET_PROPERTY__STRING_DOUBLE = OPERATOR___SET_PROPERTY__STRING_DOUBLE;

	/**
	 * The operation id for the '<em>Add Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION___ADD_NODE__INODE = OPERATOR___ADD_NODE__INODE;

	/**
	 * The operation id for the '<em>Remove Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION___REMOVE_NODE__INODE = OPERATOR___REMOVE_NODE__INODE;

	/**
	 * The operation id for the '<em>Copy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION___COPY__OBJECT = OPERATOR___COPY__OBJECT;

	/**
	 * The operation id for the '<em>Clone</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION___CLONE = OPERATOR___CLONE;

	/**
	 * The number of operations of the '<em>Union</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_OPERATION_COUNT = OPERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.january.geometry.impl.IntersectionImpl <em>Intersection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.january.geometry.impl.IntersectionImpl
	 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getIntersection()
	 * @generated
	 */
	int INTERSECTION = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION__NAME = OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION__ID = OPERATOR__ID;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION__NODES = OPERATOR__NODES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION__TYPE = OPERATOR__TYPE;

	/**
	 * The feature id for the '<em><b>Triangles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION__TRIANGLES = OPERATOR__TRIANGLES;

	/**
	 * The feature id for the '<em><b>Center</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION__CENTER = OPERATOR__CENTER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION__PARENT = OPERATOR__PARENT;

	/**
	 * The number of structural features of the '<em>Intersection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Change Decorator Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT = OPERATOR___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT;

	/**
	 * The operation id for the '<em>Get Property Names</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION___GET_PROPERTY_NAMES = OPERATOR___GET_PROPERTY_NAMES;

	/**
	 * The operation id for the '<em>Get Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION___GET_PROPERTY__STRING = OPERATOR___GET_PROPERTY__STRING;

	/**
	 * The operation id for the '<em>Set Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION___SET_PROPERTY__STRING_DOUBLE = OPERATOR___SET_PROPERTY__STRING_DOUBLE;

	/**
	 * The operation id for the '<em>Add Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION___ADD_NODE__INODE = OPERATOR___ADD_NODE__INODE;

	/**
	 * The operation id for the '<em>Remove Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION___REMOVE_NODE__INODE = OPERATOR___REMOVE_NODE__INODE;

	/**
	 * The operation id for the '<em>Copy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION___COPY__OBJECT = OPERATOR___COPY__OBJECT;

	/**
	 * The operation id for the '<em>Clone</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION___CLONE = OPERATOR___CLONE;

	/**
	 * The number of operations of the '<em>Intersection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_OPERATION_COUNT = OPERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.january.geometry.impl.ComplementImpl <em>Complement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.january.geometry.impl.ComplementImpl
	 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getComplement()
	 * @generated
	 */
	int COMPLEMENT = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEMENT__NAME = OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEMENT__ID = OPERATOR__ID;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEMENT__NODES = OPERATOR__NODES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEMENT__TYPE = OPERATOR__TYPE;

	/**
	 * The feature id for the '<em><b>Triangles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEMENT__TRIANGLES = OPERATOR__TRIANGLES;

	/**
	 * The feature id for the '<em><b>Center</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEMENT__CENTER = OPERATOR__CENTER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEMENT__PARENT = OPERATOR__PARENT;

	/**
	 * The number of structural features of the '<em>Complement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEMENT_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Change Decorator Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEMENT___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT = OPERATOR___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT;

	/**
	 * The operation id for the '<em>Get Property Names</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEMENT___GET_PROPERTY_NAMES = OPERATOR___GET_PROPERTY_NAMES;

	/**
	 * The operation id for the '<em>Get Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEMENT___GET_PROPERTY__STRING = OPERATOR___GET_PROPERTY__STRING;

	/**
	 * The operation id for the '<em>Set Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEMENT___SET_PROPERTY__STRING_DOUBLE = OPERATOR___SET_PROPERTY__STRING_DOUBLE;

	/**
	 * The operation id for the '<em>Add Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEMENT___ADD_NODE__INODE = OPERATOR___ADD_NODE__INODE;

	/**
	 * The operation id for the '<em>Remove Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEMENT___REMOVE_NODE__INODE = OPERATOR___REMOVE_NODE__INODE;

	/**
	 * The operation id for the '<em>Copy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEMENT___COPY__OBJECT = OPERATOR___COPY__OBJECT;

	/**
	 * The operation id for the '<em>Clone</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEMENT___CLONE = OPERATOR___CLONE;

	/**
	 * The number of operations of the '<em>Complement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEMENT_OPERATION_COUNT = OPERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.january.geometry.impl.MaterialImpl <em>Material</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.january.geometry.impl.MaterialImpl
	 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getMaterial()
	 * @generated
	 */
	int MATERIAL = 13;

	/**
	 * The number of structural features of the '<em>Material</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATERIAL_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Material</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATERIAL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.january.geometry.IGeometryImporter <em>IGeometry Importer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.january.geometry.IGeometryImporter
	 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getIGeometryImporter()
	 * @generated
	 */
	int IGEOMETRY_IMPORTER = 14;

	/**
	 * The feature id for the '<em><b>File Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGEOMETRY_IMPORTER__FILE_TYPES = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGEOMETRY_IMPORTER__DESCRIPTION = 1;

	/**
	 * The number of structural features of the '<em>IGeometry Importer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGEOMETRY_IMPORTER_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Load</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGEOMETRY_IMPORTER___LOAD__PATH = 0;

	/**
	 * The number of operations of the '<em>IGeometry Importer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGEOMETRY_IMPORTER_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.january.geometry.impl.STLGeometryImporterImpl <em>ASCIISTL Geometry Importer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.january.geometry.impl.STLGeometryImporterImpl
	 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getASCIISTLGeometryImporter()
	 * @generated
	 */
	int ASCIISTL_GEOMETRY_IMPORTER = 15;

	/**
	 * The feature id for the '<em><b>File Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASCIISTL_GEOMETRY_IMPORTER__FILE_TYPES = IGEOMETRY_IMPORTER__FILE_TYPES;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASCIISTL_GEOMETRY_IMPORTER__DESCRIPTION = IGEOMETRY_IMPORTER__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>ASCIISTL Geometry Importer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASCIISTL_GEOMETRY_IMPORTER_FEATURE_COUNT = IGEOMETRY_IMPORTER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Load</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASCIISTL_GEOMETRY_IMPORTER___LOAD__PATH = IGEOMETRY_IMPORTER___LOAD__PATH;

	/**
	 * The number of operations of the '<em>ASCIISTL Geometry Importer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASCIISTL_GEOMETRY_IMPORTER_OPERATION_COUNT = IGEOMETRY_IMPORTER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '<em>Path</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.nio.file.Path
	 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getPath()
	 * @generated
	 */
	int PATH = 16;

	/**
	 * The meta object id for the '<em>Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getObject()
	 * @generated
	 */
	int OBJECT = 17;


	/**
	 * Returns the meta object for class '{@link org.eclipse.january.geometry.Shape <em>Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shape</em>'.
	 * @see org.eclipse.january.geometry.Shape
	 * @generated
	 */
	EClass getShape();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.january.geometry.Shape#getMaterial <em>Material</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Material</em>'.
	 * @see org.eclipse.january.geometry.Shape#getMaterial()
	 * @see #getShape()
	 * @generated
	 */
	EReference getShape_Material();

	/**
	 * Returns the meta object for class '{@link org.eclipse.january.geometry.Triangle <em>Triangle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Triangle</em>'.
	 * @see org.eclipse.january.geometry.Triangle
	 * @generated
	 */
	EClass getTriangle();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.january.geometry.Triangle#getNormal <em>Normal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Normal</em>'.
	 * @see org.eclipse.january.geometry.Triangle#getNormal()
	 * @see #getTriangle()
	 * @generated
	 */
	EReference getTriangle_Normal();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.january.geometry.Triangle#getVertices <em>Vertices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vertices</em>'.
	 * @see org.eclipse.january.geometry.Triangle#getVertices()
	 * @see #getTriangle()
	 * @generated
	 */
	EReference getTriangle_Vertices();

	/**
	 * Returns the meta object for class '{@link org.eclipse.january.geometry.Vertex <em>Vertex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vertex</em>'.
	 * @see org.eclipse.january.geometry.Vertex
	 * @generated
	 */
	EClass getVertex();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.Vertex#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.january.geometry.Vertex#getX()
	 * @see #getVertex()
	 * @generated
	 */
	EAttribute getVertex_X();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.Vertex#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.january.geometry.Vertex#getY()
	 * @see #getVertex()
	 * @generated
	 */
	EAttribute getVertex_Y();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.Vertex#getZ <em>Z</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Z</em>'.
	 * @see org.eclipse.january.geometry.Vertex#getZ()
	 * @see #getVertex()
	 * @generated
	 */
	EAttribute getVertex_Z();

	/**
	 * Returns the meta object for the '{@link org.eclipse.january.geometry.Vertex#clone() <em>Clone</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Clone</em>' operation.
	 * @see org.eclipse.january.geometry.Vertex#clone()
	 * @generated
	 */
	EOperation getVertex__Clone();

	/**
	 * Returns the meta object for class '{@link org.eclipse.january.geometry.Sphere <em>Sphere</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sphere</em>'.
	 * @see org.eclipse.january.geometry.Sphere
	 * @generated
	 */
	EClass getSphere();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.Sphere#getRadius <em>Radius</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Radius</em>'.
	 * @see org.eclipse.january.geometry.Sphere#getRadius()
	 * @see #getSphere()
	 * @generated
	 */
	EAttribute getSphere_Radius();

	/**
	 * Returns the meta object for class '{@link org.eclipse.january.geometry.Cube <em>Cube</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cube</em>'.
	 * @see org.eclipse.january.geometry.Cube
	 * @generated
	 */
	EClass getCube();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.Cube#getSideLength <em>Side Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Side Length</em>'.
	 * @see org.eclipse.january.geometry.Cube#getSideLength()
	 * @see #getCube()
	 * @generated
	 */
	EAttribute getCube_SideLength();

	/**
	 * Returns the meta object for class '{@link org.eclipse.january.geometry.Cylinder <em>Cylinder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cylinder</em>'.
	 * @see org.eclipse.january.geometry.Cylinder
	 * @generated
	 */
	EClass getCylinder();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.Cylinder#getRadius <em>Radius</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Radius</em>'.
	 * @see org.eclipse.january.geometry.Cylinder#getRadius()
	 * @see #getCylinder()
	 * @generated
	 */
	EAttribute getCylinder_Radius();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.Cylinder#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.eclipse.january.geometry.Cylinder#getHeight()
	 * @see #getCylinder()
	 * @generated
	 */
	EAttribute getCylinder_Height();

	/**
	 * Returns the meta object for class '{@link org.eclipse.january.geometry.Geometry <em>Geometry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Geometry</em>'.
	 * @see org.eclipse.january.geometry.Geometry
	 * @generated
	 */
	EClass getGeometry();

	/**
	 * Returns the meta object for class '{@link org.eclipse.january.geometry.Tube <em>Tube</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tube</em>'.
	 * @see org.eclipse.january.geometry.Tube
	 * @generated
	 */
	EClass getTube();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.Tube#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.eclipse.january.geometry.Tube#getHeight()
	 * @see #getTube()
	 * @generated
	 */
	EAttribute getTube_Height();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.Tube#getInnerRadius <em>Inner Radius</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inner Radius</em>'.
	 * @see org.eclipse.january.geometry.Tube#getInnerRadius()
	 * @see #getTube()
	 * @generated
	 */
	EAttribute getTube_InnerRadius();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.Tube#getRadius <em>Radius</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Radius</em>'.
	 * @see org.eclipse.january.geometry.Tube#getRadius()
	 * @see #getTube()
	 * @generated
	 */
	EAttribute getTube_Radius();

	/**
	 * Returns the meta object for class '{@link org.eclipse.january.geometry.INode <em>INode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>INode</em>'.
	 * @see org.eclipse.january.geometry.INode
	 * @generated
	 */
	EClass getINode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.INode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.january.geometry.INode#getName()
	 * @see #getINode()
	 * @generated
	 */
	EAttribute getINode_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.INode#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.january.geometry.INode#getId()
	 * @see #getINode()
	 * @generated
	 */
	EAttribute getINode_Id();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.january.geometry.INode#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.eclipse.january.geometry.INode#getNodes()
	 * @see #getINode()
	 * @generated
	 */
	EReference getINode_Nodes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.INode#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.january.geometry.INode#getType()
	 * @see #getINode()
	 * @generated
	 */
	EAttribute getINode_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.january.geometry.INode#getTriangles <em>Triangles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Triangles</em>'.
	 * @see org.eclipse.january.geometry.INode#getTriangles()
	 * @see #getINode()
	 * @generated
	 */
	EReference getINode_Triangles();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.january.geometry.INode#getCenter <em>Center</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Center</em>'.
	 * @see org.eclipse.january.geometry.INode#getCenter()
	 * @see #getINode()
	 * @generated
	 */
	EReference getINode_Center();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.january.geometry.INode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.eclipse.january.geometry.INode#getParent()
	 * @see #getINode()
	 * @generated
	 */
	EReference getINode_Parent();

	/**
	 * Returns the meta object for the '{@link org.eclipse.january.geometry.INode#changeDecoratorProperty(java.lang.String, java.lang.Object) <em>Change Decorator Property</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Change Decorator Property</em>' operation.
	 * @see org.eclipse.january.geometry.INode#changeDecoratorProperty(java.lang.String, java.lang.Object)
	 * @generated
	 */
	EOperation getINode__ChangeDecoratorProperty__String_Object();

	/**
	 * Returns the meta object for the '{@link org.eclipse.january.geometry.INode#getPropertyNames() <em>Get Property Names</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Property Names</em>' operation.
	 * @see org.eclipse.january.geometry.INode#getPropertyNames()
	 * @generated
	 */
	EOperation getINode__GetPropertyNames();

	/**
	 * Returns the meta object for the '{@link org.eclipse.january.geometry.INode#getProperty(java.lang.String) <em>Get Property</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Property</em>' operation.
	 * @see org.eclipse.january.geometry.INode#getProperty(java.lang.String)
	 * @generated
	 */
	EOperation getINode__GetProperty__String();

	/**
	 * Returns the meta object for the '{@link org.eclipse.january.geometry.INode#setProperty(java.lang.String, double) <em>Set Property</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Set Property</em>' operation.
	 * @see org.eclipse.january.geometry.INode#setProperty(java.lang.String, double)
	 * @generated
	 */
	EOperation getINode__SetProperty__String_double();

	/**
	 * Returns the meta object for the '{@link org.eclipse.january.geometry.INode#addNode(org.eclipse.january.geometry.INode) <em>Add Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Node</em>' operation.
	 * @see org.eclipse.january.geometry.INode#addNode(org.eclipse.january.geometry.INode)
	 * @generated
	 */
	EOperation getINode__AddNode__INode();

	/**
	 * Returns the meta object for the '{@link org.eclipse.january.geometry.INode#removeNode(org.eclipse.january.geometry.INode) <em>Remove Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Remove Node</em>' operation.
	 * @see org.eclipse.january.geometry.INode#removeNode(org.eclipse.january.geometry.INode)
	 * @generated
	 */
	EOperation getINode__RemoveNode__INode();

	/**
	 * Returns the meta object for the '{@link org.eclipse.january.geometry.INode#copy(java.lang.Object) <em>Copy</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Copy</em>' operation.
	 * @see org.eclipse.january.geometry.INode#copy(java.lang.Object)
	 * @generated
	 */
	EOperation getINode__Copy__Object();

	/**
	 * Returns the meta object for the '{@link org.eclipse.january.geometry.INode#clone() <em>Clone</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Clone</em>' operation.
	 * @see org.eclipse.january.geometry.INode#clone()
	 * @generated
	 */
	EOperation getINode__Clone();

	/**
	 * Returns the meta object for class '{@link org.eclipse.january.geometry.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator</em>'.
	 * @see org.eclipse.january.geometry.Operator
	 * @generated
	 */
	EClass getOperator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.january.geometry.Union <em>Union</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Union</em>'.
	 * @see org.eclipse.january.geometry.Union
	 * @generated
	 */
	EClass getUnion();

	/**
	 * Returns the meta object for class '{@link org.eclipse.january.geometry.Intersection <em>Intersection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Intersection</em>'.
	 * @see org.eclipse.january.geometry.Intersection
	 * @generated
	 */
	EClass getIntersection();

	/**
	 * Returns the meta object for class '{@link org.eclipse.january.geometry.Complement <em>Complement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complement</em>'.
	 * @see org.eclipse.january.geometry.Complement
	 * @generated
	 */
	EClass getComplement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.january.geometry.Material <em>Material</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Material</em>'.
	 * @see org.eclipse.january.geometry.Material
	 * @generated
	 */
	EClass getMaterial();

	/**
	 * Returns the meta object for class '{@link org.eclipse.january.geometry.IGeometryImporter <em>IGeometry Importer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IGeometry Importer</em>'.
	 * @see org.eclipse.january.geometry.IGeometryImporter
	 * @generated
	 */
	EClass getIGeometryImporter();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.january.geometry.IGeometryImporter#getFileTypes <em>File Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>File Types</em>'.
	 * @see org.eclipse.january.geometry.IGeometryImporter#getFileTypes()
	 * @see #getIGeometryImporter()
	 * @generated
	 */
	EAttribute getIGeometryImporter_FileTypes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.IGeometryImporter#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.january.geometry.IGeometryImporter#getDescription()
	 * @see #getIGeometryImporter()
	 * @generated
	 */
	EAttribute getIGeometryImporter_Description();

	/**
	 * Returns the meta object for the '{@link org.eclipse.january.geometry.IGeometryImporter#load(java.nio.file.Path) <em>Load</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Load</em>' operation.
	 * @see org.eclipse.january.geometry.IGeometryImporter#load(java.nio.file.Path)
	 * @generated
	 */
	EOperation getIGeometryImporter__Load__Path();

	/**
	 * Returns the meta object for class '{@link org.eclipse.january.geometry.STLGeometryImporter <em>ASCIISTL Geometry Importer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ASCIISTL Geometry Importer</em>'.
	 * @see org.eclipse.january.geometry.STLGeometryImporter
	 * @generated
	 */
	EClass getASCIISTLGeometryImporter();

	/**
	 * Returns the meta object for data type '{@link java.nio.file.Path <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Path</em>'.
	 * @see java.nio.file.Path
	 * @model instanceClass="java.nio.file.Path"
	 * @generated
	 */
	EDataType getPath();

	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Object</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GeometryFactory getGeometryFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.january.geometry.impl.ShapeImpl <em>Shape</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.january.geometry.impl.ShapeImpl
		 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getShape()
		 * @generated
		 */
		EClass SHAPE = eINSTANCE.getShape();

		/**
		 * The meta object literal for the '<em><b>Material</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHAPE__MATERIAL = eINSTANCE.getShape_Material();

		/**
		 * The meta object literal for the '{@link org.eclipse.january.geometry.impl.TriangleImpl <em>Triangle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.january.geometry.impl.TriangleImpl
		 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getTriangle()
		 * @generated
		 */
		EClass TRIANGLE = eINSTANCE.getTriangle();

		/**
		 * The meta object literal for the '<em><b>Normal</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRIANGLE__NORMAL = eINSTANCE.getTriangle_Normal();

		/**
		 * The meta object literal for the '<em><b>Vertices</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRIANGLE__VERTICES = eINSTANCE.getTriangle_Vertices();

		/**
		 * The meta object literal for the '{@link org.eclipse.january.geometry.impl.VertexImpl <em>Vertex</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.january.geometry.impl.VertexImpl
		 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getVertex()
		 * @generated
		 */
		EClass VERTEX = eINSTANCE.getVertex();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERTEX__X = eINSTANCE.getVertex_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERTEX__Y = eINSTANCE.getVertex_Y();

		/**
		 * The meta object literal for the '<em><b>Z</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERTEX__Z = eINSTANCE.getVertex_Z();

		/**
		 * The meta object literal for the '<em><b>Clone</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VERTEX___CLONE = eINSTANCE.getVertex__Clone();

		/**
		 * The meta object literal for the '{@link org.eclipse.january.geometry.impl.SphereImpl <em>Sphere</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.january.geometry.impl.SphereImpl
		 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getSphere()
		 * @generated
		 */
		EClass SPHERE = eINSTANCE.getSphere();

		/**
		 * The meta object literal for the '<em><b>Radius</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPHERE__RADIUS = eINSTANCE.getSphere_Radius();

		/**
		 * The meta object literal for the '{@link org.eclipse.january.geometry.impl.CubeImpl <em>Cube</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.january.geometry.impl.CubeImpl
		 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getCube()
		 * @generated
		 */
		EClass CUBE = eINSTANCE.getCube();

		/**
		 * The meta object literal for the '<em><b>Side Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUBE__SIDE_LENGTH = eINSTANCE.getCube_SideLength();

		/**
		 * The meta object literal for the '{@link org.eclipse.january.geometry.impl.CylinderImpl <em>Cylinder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.january.geometry.impl.CylinderImpl
		 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getCylinder()
		 * @generated
		 */
		EClass CYLINDER = eINSTANCE.getCylinder();

		/**
		 * The meta object literal for the '<em><b>Radius</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CYLINDER__RADIUS = eINSTANCE.getCylinder_Radius();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CYLINDER__HEIGHT = eINSTANCE.getCylinder_Height();

		/**
		 * The meta object literal for the '{@link org.eclipse.january.geometry.impl.GeometryImpl <em>Geometry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.january.geometry.impl.GeometryImpl
		 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getGeometry()
		 * @generated
		 */
		EClass GEOMETRY = eINSTANCE.getGeometry();

		/**
		 * The meta object literal for the '{@link org.eclipse.january.geometry.impl.TubeImpl <em>Tube</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.january.geometry.impl.TubeImpl
		 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getTube()
		 * @generated
		 */
		EClass TUBE = eINSTANCE.getTube();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TUBE__HEIGHT = eINSTANCE.getTube_Height();

		/**
		 * The meta object literal for the '<em><b>Inner Radius</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TUBE__INNER_RADIUS = eINSTANCE.getTube_InnerRadius();

		/**
		 * The meta object literal for the '<em><b>Radius</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TUBE__RADIUS = eINSTANCE.getTube_Radius();

		/**
		 * The meta object literal for the '{@link org.eclipse.january.geometry.INode <em>INode</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.january.geometry.INode
		 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getINode()
		 * @generated
		 */
		EClass INODE = eINSTANCE.getINode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INODE__NAME = eINSTANCE.getINode_Name();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INODE__ID = eINSTANCE.getINode_Id();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INODE__NODES = eINSTANCE.getINode_Nodes();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INODE__TYPE = eINSTANCE.getINode_Type();

		/**
		 * The meta object literal for the '<em><b>Triangles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INODE__TRIANGLES = eINSTANCE.getINode_Triangles();

		/**
		 * The meta object literal for the '<em><b>Center</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INODE__CENTER = eINSTANCE.getINode_Center();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INODE__PARENT = eINSTANCE.getINode_Parent();

		/**
		 * The meta object literal for the '<em><b>Change Decorator Property</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INODE___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT = eINSTANCE.getINode__ChangeDecoratorProperty__String_Object();

		/**
		 * The meta object literal for the '<em><b>Get Property Names</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INODE___GET_PROPERTY_NAMES = eINSTANCE.getINode__GetPropertyNames();

		/**
		 * The meta object literal for the '<em><b>Get Property</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INODE___GET_PROPERTY__STRING = eINSTANCE.getINode__GetProperty__String();

		/**
		 * The meta object literal for the '<em><b>Set Property</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INODE___SET_PROPERTY__STRING_DOUBLE = eINSTANCE.getINode__SetProperty__String_double();

		/**
		 * The meta object literal for the '<em><b>Add Node</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INODE___ADD_NODE__INODE = eINSTANCE.getINode__AddNode__INode();

		/**
		 * The meta object literal for the '<em><b>Remove Node</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INODE___REMOVE_NODE__INODE = eINSTANCE.getINode__RemoveNode__INode();

		/**
		 * The meta object literal for the '<em><b>Copy</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INODE___COPY__OBJECT = eINSTANCE.getINode__Copy__Object();

		/**
		 * The meta object literal for the '<em><b>Clone</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INODE___CLONE = eINSTANCE.getINode__Clone();

		/**
		 * The meta object literal for the '{@link org.eclipse.january.geometry.impl.OperatorImpl <em>Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.january.geometry.impl.OperatorImpl
		 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getOperator()
		 * @generated
		 */
		EClass OPERATOR = eINSTANCE.getOperator();

		/**
		 * The meta object literal for the '{@link org.eclipse.january.geometry.impl.UnionImpl <em>Union</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.january.geometry.impl.UnionImpl
		 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getUnion()
		 * @generated
		 */
		EClass UNION = eINSTANCE.getUnion();

		/**
		 * The meta object literal for the '{@link org.eclipse.january.geometry.impl.IntersectionImpl <em>Intersection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.january.geometry.impl.IntersectionImpl
		 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getIntersection()
		 * @generated
		 */
		EClass INTERSECTION = eINSTANCE.getIntersection();

		/**
		 * The meta object literal for the '{@link org.eclipse.january.geometry.impl.ComplementImpl <em>Complement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.january.geometry.impl.ComplementImpl
		 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getComplement()
		 * @generated
		 */
		EClass COMPLEMENT = eINSTANCE.getComplement();

		/**
		 * The meta object literal for the '{@link org.eclipse.january.geometry.impl.MaterialImpl <em>Material</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.january.geometry.impl.MaterialImpl
		 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getMaterial()
		 * @generated
		 */
		EClass MATERIAL = eINSTANCE.getMaterial();

		/**
		 * The meta object literal for the '{@link org.eclipse.january.geometry.IGeometryImporter <em>IGeometry Importer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.january.geometry.IGeometryImporter
		 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getIGeometryImporter()
		 * @generated
		 */
		EClass IGEOMETRY_IMPORTER = eINSTANCE.getIGeometryImporter();

		/**
		 * The meta object literal for the '<em><b>File Types</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IGEOMETRY_IMPORTER__FILE_TYPES = eINSTANCE.getIGeometryImporter_FileTypes();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IGEOMETRY_IMPORTER__DESCRIPTION = eINSTANCE.getIGeometryImporter_Description();

		/**
		 * The meta object literal for the '<em><b>Load</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IGEOMETRY_IMPORTER___LOAD__PATH = eINSTANCE.getIGeometryImporter__Load__Path();

		/**
		 * The meta object literal for the '{@link org.eclipse.january.geometry.impl.STLGeometryImporterImpl <em>ASCIISTL Geometry Importer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.january.geometry.impl.STLGeometryImporterImpl
		 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getASCIISTLGeometryImporter()
		 * @generated
		 */
		EClass ASCIISTL_GEOMETRY_IMPORTER = eINSTANCE.getASCIISTLGeometryImporter();

		/**
		 * The meta object literal for the '<em>Path</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.nio.file.Path
		 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getPath()
		 * @generated
		 */
		EDataType PATH = eINSTANCE.getPath();

		/**
		 * The meta object literal for the '<em>Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Object
		 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getObject()
		 * @generated
		 */
		EDataType OBJECT = eINSTANCE.getObject();

	}

} //GeometryPackage
