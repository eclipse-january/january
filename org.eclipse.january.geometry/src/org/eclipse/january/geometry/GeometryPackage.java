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
	String eNS_URI = "http://www.eclipse.org/january/geometry/model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.january.geometry.model";

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
	 * The feature id for the '<em><b>Vertex1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIANGLE__VERTEX1 = 1;

	/**
	 * The feature id for the '<em><b>Vertex2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIANGLE__VERTEX2 = 2;

	/**
	 * The feature id for the '<em><b>Vertex3</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIANGLE__VERTEX3 = 3;

	/**
	 * The number of structural features of the '<em>Triangle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIANGLE_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIANGLE___EQUALS__OBJECT = 0;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIANGLE___HASH_CODE = 1;

	/**
	 * The operation id for the '<em>Get Vertices</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIANGLE___GET_VERTICES = 2;

	/**
	 * The number of operations of the '<em>Triangle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIANGLE_OPERATION_COUNT = 3;

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
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX___EQUALS__OBJECT = 1;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX___HASH_CODE = 2;

	/**
	 * The number of operations of the '<em>Vertex</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_OPERATION_COUNT = 3;

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
	 * The meta object id for the '{@link org.eclipse.january.geometry.impl.STLGeometryImporterImpl <em>STL Geometry Importer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.january.geometry.impl.STLGeometryImporterImpl
	 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getSTLGeometryImporter()
	 * @generated
	 */
	int STL_GEOMETRY_IMPORTER = 15;

	/**
	 * The feature id for the '<em><b>File Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STL_GEOMETRY_IMPORTER__FILE_TYPES = IGEOMETRY_IMPORTER__FILE_TYPES;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STL_GEOMETRY_IMPORTER__DESCRIPTION = IGEOMETRY_IMPORTER__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>STL Geometry Importer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STL_GEOMETRY_IMPORTER_FEATURE_COUNT = IGEOMETRY_IMPORTER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Load</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STL_GEOMETRY_IMPORTER___LOAD__PATH = IGEOMETRY_IMPORTER___LOAD__PATH;

	/**
	 * The number of operations of the '<em>STL Geometry Importer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STL_GEOMETRY_IMPORTER_OPERATION_COUNT = IGEOMETRY_IMPORTER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.january.geometry.impl.PipeImpl <em>Pipe</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.january.geometry.impl.PipeImpl
	 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getPipe()
	 * @generated
	 */
	int PIPE = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE__NAME = TUBE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE__ID = TUBE__ID;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE__NODES = TUBE__NODES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE__TYPE = TUBE__TYPE;

	/**
	 * The feature id for the '<em><b>Triangles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE__TRIANGLES = TUBE__TRIANGLES;

	/**
	 * The feature id for the '<em><b>Center</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE__CENTER = TUBE__CENTER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE__PARENT = TUBE__PARENT;

	/**
	 * The feature id for the '<em><b>Material</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE__MATERIAL = TUBE__MATERIAL;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE__HEIGHT = TUBE__HEIGHT;

	/**
	 * The feature id for the '<em><b>Inner Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE__INNER_RADIUS = TUBE__INNER_RADIUS;

	/**
	 * The feature id for the '<em><b>Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE__RADIUS = TUBE__RADIUS;

	/**
	 * The feature id for the '<em><b>Num Rods</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE__NUM_RODS = TUBE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pitch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE__PITCH = TUBE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rod Diameter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE__ROD_DIAMETER = TUBE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Rotation X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE__ROTATION_X = TUBE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Rotation Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE__ROTATION_Y = TUBE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Rotation Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE__ROTATION_Z = TUBE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Pipe</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_FEATURE_COUNT = TUBE_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Change Decorator Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT = TUBE___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT;

	/**
	 * The operation id for the '<em>Get Property Names</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE___GET_PROPERTY_NAMES = TUBE___GET_PROPERTY_NAMES;

	/**
	 * The operation id for the '<em>Get Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE___GET_PROPERTY__STRING = TUBE___GET_PROPERTY__STRING;

	/**
	 * The operation id for the '<em>Set Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE___SET_PROPERTY__STRING_DOUBLE = TUBE___SET_PROPERTY__STRING_DOUBLE;

	/**
	 * The operation id for the '<em>Add Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE___ADD_NODE__INODE = TUBE___ADD_NODE__INODE;

	/**
	 * The operation id for the '<em>Remove Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE___REMOVE_NODE__INODE = TUBE___REMOVE_NODE__INODE;

	/**
	 * The operation id for the '<em>Copy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE___COPY__OBJECT = TUBE___COPY__OBJECT;

	/**
	 * The operation id for the '<em>Clone</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE___CLONE = TUBE___CLONE;

	/**
	 * The operation id for the '<em>Get Lower Edge</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE___GET_LOWER_EDGE = TUBE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Upper Edge</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE___GET_UPPER_EDGE = TUBE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Pipe</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_OPERATION_COUNT = TUBE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.january.geometry.impl.BoundingBoxImpl <em>Bounding Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.january.geometry.impl.BoundingBoxImpl
	 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getBoundingBox()
	 * @generated
	 */
	int BOUNDING_BOX = 17;

	/**
	 * The feature id for the '<em><b>Max X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDING_BOX__MAX_X = 0;

	/**
	 * The feature id for the '<em><b>Max Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDING_BOX__MAX_Y = 1;

	/**
	 * The feature id for the '<em><b>Max Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDING_BOX__MAX_Z = 2;

	/**
	 * The feature id for the '<em><b>Min X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDING_BOX__MIN_X = 3;

	/**
	 * The feature id for the '<em><b>Min Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDING_BOX__MIN_Y = 4;

	/**
	 * The feature id for the '<em><b>Min Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDING_BOX__MIN_Z = 5;

	/**
	 * The number of structural features of the '<em>Bounding Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDING_BOX_FEATURE_COUNT = 6;

	/**
	 * The operation id for the '<em>Add Area</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDING_BOX___ADD_AREA__BOUNDINGBOX = 0;

	/**
	 * The number of operations of the '<em>Bounding Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDING_BOX_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.january.geometry.impl.JunctionImpl <em>Junction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.january.geometry.impl.JunctionImpl
	 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getJunction()
	 * @generated
	 */
	int JUNCTION = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__NAME = SHAPE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__ID = SHAPE__ID;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__NODES = SHAPE__NODES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__TYPE = SHAPE__TYPE;

	/**
	 * The feature id for the '<em><b>Triangles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__TRIANGLES = SHAPE__TRIANGLES;

	/**
	 * The feature id for the '<em><b>Center</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__CENTER = SHAPE__CENTER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__PARENT = SHAPE__PARENT;

	/**
	 * The feature id for the '<em><b>Material</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__MATERIAL = SHAPE__MATERIAL;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__HEIGHT = SHAPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>ZIn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__ZIN = SHAPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>ZOut</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__ZOUT = SHAPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Input</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__INPUT = SHAPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Output</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION__OUTPUT = SHAPE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Junction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION_FEATURE_COUNT = SHAPE_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Change Decorator Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT = SHAPE___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT;

	/**
	 * The operation id for the '<em>Get Property Names</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION___GET_PROPERTY_NAMES = SHAPE___GET_PROPERTY_NAMES;

	/**
	 * The operation id for the '<em>Get Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION___GET_PROPERTY__STRING = SHAPE___GET_PROPERTY__STRING;

	/**
	 * The operation id for the '<em>Set Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION___SET_PROPERTY__STRING_DOUBLE = SHAPE___SET_PROPERTY__STRING_DOUBLE;

	/**
	 * The operation id for the '<em>Add Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION___ADD_NODE__INODE = SHAPE___ADD_NODE__INODE;

	/**
	 * The operation id for the '<em>Remove Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION___REMOVE_NODE__INODE = SHAPE___REMOVE_NODE__INODE;

	/**
	 * The operation id for the '<em>Copy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION___COPY__OBJECT = SHAPE___COPY__OBJECT;

	/**
	 * The operation id for the '<em>Clone</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION___CLONE = SHAPE___CLONE;

	/**
	 * The number of operations of the '<em>Junction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUNCTION_OPERATION_COUNT = SHAPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.january.geometry.impl.HeatExchangerImpl <em>Heat Exchanger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.january.geometry.impl.HeatExchangerImpl
	 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getHeatExchanger()
	 * @generated
	 */
	int HEAT_EXCHANGER = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER__NAME = SHAPE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER__ID = SHAPE__ID;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER__NODES = SHAPE__NODES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER__TYPE = SHAPE__TYPE;

	/**
	 * The feature id for the '<em><b>Triangles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER__TRIANGLES = SHAPE__TRIANGLES;

	/**
	 * The feature id for the '<em><b>Center</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER__CENTER = SHAPE__CENTER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER__PARENT = SHAPE__PARENT;

	/**
	 * The feature id for the '<em><b>Material</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER__MATERIAL = SHAPE__MATERIAL;

	/**
	 * The feature id for the '<em><b>Pipe</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER__PIPE = SHAPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Input</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER__INPUT = SHAPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER__OUTPUT = SHAPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Heat Exchanger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER_FEATURE_COUNT = SHAPE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Change Decorator Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT = SHAPE___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT;

	/**
	 * The operation id for the '<em>Get Property Names</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER___GET_PROPERTY_NAMES = SHAPE___GET_PROPERTY_NAMES;

	/**
	 * The operation id for the '<em>Get Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER___GET_PROPERTY__STRING = SHAPE___GET_PROPERTY__STRING;

	/**
	 * The operation id for the '<em>Set Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER___SET_PROPERTY__STRING_DOUBLE = SHAPE___SET_PROPERTY__STRING_DOUBLE;

	/**
	 * The operation id for the '<em>Add Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER___ADD_NODE__INODE = SHAPE___ADD_NODE__INODE;

	/**
	 * The operation id for the '<em>Remove Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER___REMOVE_NODE__INODE = SHAPE___REMOVE_NODE__INODE;

	/**
	 * The operation id for the '<em>Copy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER___COPY__OBJECT = SHAPE___COPY__OBJECT;

	/**
	 * The operation id for the '<em>Clone</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER___CLONE = SHAPE___CLONE;

	/**
	 * The number of operations of the '<em>Heat Exchanger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAT_EXCHANGER_OPERATION_COUNT = SHAPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.january.geometry.impl.ReactorImpl <em>Reactor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.january.geometry.impl.ReactorImpl
	 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getReactor()
	 * @generated
	 */
	int REACTOR = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTOR__NAME = SHAPE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTOR__ID = SHAPE__ID;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTOR__NODES = SHAPE__NODES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTOR__TYPE = SHAPE__TYPE;

	/**
	 * The feature id for the '<em><b>Triangles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTOR__TRIANGLES = SHAPE__TRIANGLES;

	/**
	 * The feature id for the '<em><b>Center</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTOR__CENTER = SHAPE__CENTER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTOR__PARENT = SHAPE__PARENT;

	/**
	 * The feature id for the '<em><b>Material</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTOR__MATERIAL = SHAPE__MATERIAL;

	/**
	 * The feature id for the '<em><b>Pipes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTOR__PIPES = SHAPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reactor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTOR_FEATURE_COUNT = SHAPE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Change Decorator Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTOR___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT = SHAPE___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT;

	/**
	 * The operation id for the '<em>Get Property Names</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTOR___GET_PROPERTY_NAMES = SHAPE___GET_PROPERTY_NAMES;

	/**
	 * The operation id for the '<em>Get Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTOR___GET_PROPERTY__STRING = SHAPE___GET_PROPERTY__STRING;

	/**
	 * The operation id for the '<em>Set Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTOR___SET_PROPERTY__STRING_DOUBLE = SHAPE___SET_PROPERTY__STRING_DOUBLE;

	/**
	 * The operation id for the '<em>Add Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTOR___ADD_NODE__INODE = SHAPE___ADD_NODE__INODE;

	/**
	 * The operation id for the '<em>Remove Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTOR___REMOVE_NODE__INODE = SHAPE___REMOVE_NODE__INODE;

	/**
	 * The operation id for the '<em>Copy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTOR___COPY__OBJECT = SHAPE___COPY__OBJECT;

	/**
	 * The operation id for the '<em>Clone</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTOR___CLONE = SHAPE___CLONE;

	/**
	 * The number of operations of the '<em>Reactor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTOR_OPERATION_COUNT = SHAPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '<em>Path</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.nio.file.Path
	 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getPath()
	 * @generated
	 */
	int PATH = 21;

	/**
	 * The meta object id for the '<em>Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getObject()
	 * @generated
	 */
	int OBJECT = 22;


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
	 * Returns the meta object for the containment reference '{@link org.eclipse.january.geometry.Triangle#getVertex1 <em>Vertex1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Vertex1</em>'.
	 * @see org.eclipse.january.geometry.Triangle#getVertex1()
	 * @see #getTriangle()
	 * @generated
	 */
	EReference getTriangle_Vertex1();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.january.geometry.Triangle#getVertex2 <em>Vertex2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Vertex2</em>'.
	 * @see org.eclipse.january.geometry.Triangle#getVertex2()
	 * @see #getTriangle()
	 * @generated
	 */
	EReference getTriangle_Vertex2();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.january.geometry.Triangle#getVertex3 <em>Vertex3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Vertex3</em>'.
	 * @see org.eclipse.january.geometry.Triangle#getVertex3()
	 * @see #getTriangle()
	 * @generated
	 */
	EReference getTriangle_Vertex3();

	/**
	 * Returns the meta object for the '{@link org.eclipse.january.geometry.Triangle#equals(java.lang.Object) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equals</em>' operation.
	 * @see org.eclipse.january.geometry.Triangle#equals(java.lang.Object)
	 * @generated
	 */
	EOperation getTriangle__Equals__Object();

	/**
	 * Returns the meta object for the '{@link org.eclipse.january.geometry.Triangle#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hash Code</em>' operation.
	 * @see org.eclipse.january.geometry.Triangle#hashCode()
	 * @generated
	 */
	EOperation getTriangle__HashCode();

	/**
	 * Returns the meta object for the '{@link org.eclipse.january.geometry.Triangle#getVertices() <em>Get Vertices</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Vertices</em>' operation.
	 * @see org.eclipse.january.geometry.Triangle#getVertices()
	 * @generated
	 */
	EOperation getTriangle__GetVertices();

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
	 * Returns the meta object for the '{@link org.eclipse.january.geometry.Vertex#equals(java.lang.Object) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equals</em>' operation.
	 * @see org.eclipse.january.geometry.Vertex#equals(java.lang.Object)
	 * @generated
	 */
	EOperation getVertex__Equals__Object();

	/**
	 * Returns the meta object for the '{@link org.eclipse.january.geometry.Vertex#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hash Code</em>' operation.
	 * @see org.eclipse.january.geometry.Vertex#hashCode()
	 * @generated
	 */
	EOperation getVertex__HashCode();

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
	 * Returns the meta object for class '{@link org.eclipse.january.geometry.STLGeometryImporter <em>STL Geometry Importer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>STL Geometry Importer</em>'.
	 * @see org.eclipse.january.geometry.STLGeometryImporter
	 * @generated
	 */
	EClass getSTLGeometryImporter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.january.geometry.Pipe <em>Pipe</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pipe</em>'.
	 * @see org.eclipse.january.geometry.Pipe
	 * @generated
	 */
	EClass getPipe();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.Pipe#getNumRods <em>Num Rods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Rods</em>'.
	 * @see org.eclipse.january.geometry.Pipe#getNumRods()
	 * @see #getPipe()
	 * @generated
	 */
	EAttribute getPipe_NumRods();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.Pipe#getPitch <em>Pitch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pitch</em>'.
	 * @see org.eclipse.january.geometry.Pipe#getPitch()
	 * @see #getPipe()
	 * @generated
	 */
	EAttribute getPipe_Pitch();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.Pipe#getRodDiameter <em>Rod Diameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rod Diameter</em>'.
	 * @see org.eclipse.january.geometry.Pipe#getRodDiameter()
	 * @see #getPipe()
	 * @generated
	 */
	EAttribute getPipe_RodDiameter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.Pipe#getRotationX <em>Rotation X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rotation X</em>'.
	 * @see org.eclipse.january.geometry.Pipe#getRotationX()
	 * @see #getPipe()
	 * @generated
	 */
	EAttribute getPipe_RotationX();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.Pipe#getRotationY <em>Rotation Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rotation Y</em>'.
	 * @see org.eclipse.january.geometry.Pipe#getRotationY()
	 * @see #getPipe()
	 * @generated
	 */
	EAttribute getPipe_RotationY();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.Pipe#getRotationZ <em>Rotation Z</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rotation Z</em>'.
	 * @see org.eclipse.january.geometry.Pipe#getRotationZ()
	 * @see #getPipe()
	 * @generated
	 */
	EAttribute getPipe_RotationZ();

	/**
	 * Returns the meta object for the '{@link org.eclipse.january.geometry.Pipe#getLowerEdge() <em>Get Lower Edge</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Lower Edge</em>' operation.
	 * @see org.eclipse.january.geometry.Pipe#getLowerEdge()
	 * @generated
	 */
	EOperation getPipe__GetLowerEdge();

	/**
	 * Returns the meta object for the '{@link org.eclipse.january.geometry.Pipe#getUpperEdge() <em>Get Upper Edge</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Upper Edge</em>' operation.
	 * @see org.eclipse.january.geometry.Pipe#getUpperEdge()
	 * @generated
	 */
	EOperation getPipe__GetUpperEdge();

	/**
	 * Returns the meta object for class '{@link org.eclipse.january.geometry.BoundingBox <em>Bounding Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bounding Box</em>'.
	 * @see org.eclipse.january.geometry.BoundingBox
	 * @generated
	 */
	EClass getBoundingBox();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.BoundingBox#getMaxX <em>Max X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max X</em>'.
	 * @see org.eclipse.january.geometry.BoundingBox#getMaxX()
	 * @see #getBoundingBox()
	 * @generated
	 */
	EAttribute getBoundingBox_MaxX();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.BoundingBox#getMaxY <em>Max Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Y</em>'.
	 * @see org.eclipse.january.geometry.BoundingBox#getMaxY()
	 * @see #getBoundingBox()
	 * @generated
	 */
	EAttribute getBoundingBox_MaxY();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.BoundingBox#getMaxZ <em>Max Z</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Z</em>'.
	 * @see org.eclipse.january.geometry.BoundingBox#getMaxZ()
	 * @see #getBoundingBox()
	 * @generated
	 */
	EAttribute getBoundingBox_MaxZ();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.BoundingBox#getMinX <em>Min X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min X</em>'.
	 * @see org.eclipse.january.geometry.BoundingBox#getMinX()
	 * @see #getBoundingBox()
	 * @generated
	 */
	EAttribute getBoundingBox_MinX();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.BoundingBox#getMinY <em>Min Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Y</em>'.
	 * @see org.eclipse.january.geometry.BoundingBox#getMinY()
	 * @see #getBoundingBox()
	 * @generated
	 */
	EAttribute getBoundingBox_MinY();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.BoundingBox#getMinZ <em>Min Z</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Z</em>'.
	 * @see org.eclipse.january.geometry.BoundingBox#getMinZ()
	 * @see #getBoundingBox()
	 * @generated
	 */
	EAttribute getBoundingBox_MinZ();

	/**
	 * Returns the meta object for the '{@link org.eclipse.january.geometry.BoundingBox#addArea(org.eclipse.january.geometry.BoundingBox) <em>Add Area</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Area</em>' operation.
	 * @see org.eclipse.january.geometry.BoundingBox#addArea(org.eclipse.january.geometry.BoundingBox)
	 * @generated
	 */
	EOperation getBoundingBox__AddArea__BoundingBox();

	/**
	 * Returns the meta object for class '{@link org.eclipse.january.geometry.Junction <em>Junction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Junction</em>'.
	 * @see org.eclipse.january.geometry.Junction
	 * @generated
	 */
	EClass getJunction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.Junction#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.eclipse.january.geometry.Junction#getHeight()
	 * @see #getJunction()
	 * @generated
	 */
	EAttribute getJunction_Height();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.Junction#getZIn <em>ZIn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ZIn</em>'.
	 * @see org.eclipse.january.geometry.Junction#getZIn()
	 * @see #getJunction()
	 * @generated
	 */
	EAttribute getJunction_ZIn();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.january.geometry.Junction#getZOut <em>ZOut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ZOut</em>'.
	 * @see org.eclipse.january.geometry.Junction#getZOut()
	 * @see #getJunction()
	 * @generated
	 */
	EAttribute getJunction_ZOut();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.january.geometry.Junction#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input</em>'.
	 * @see org.eclipse.january.geometry.Junction#getInput()
	 * @see #getJunction()
	 * @generated
	 */
	EReference getJunction_Input();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.january.geometry.Junction#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output</em>'.
	 * @see org.eclipse.january.geometry.Junction#getOutput()
	 * @see #getJunction()
	 * @generated
	 */
	EReference getJunction_Output();

	/**
	 * Returns the meta object for class '{@link org.eclipse.january.geometry.HeatExchanger <em>Heat Exchanger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Heat Exchanger</em>'.
	 * @see org.eclipse.january.geometry.HeatExchanger
	 * @generated
	 */
	EClass getHeatExchanger();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.january.geometry.HeatExchanger#getPipe <em>Pipe</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pipe</em>'.
	 * @see org.eclipse.january.geometry.HeatExchanger#getPipe()
	 * @see #getHeatExchanger()
	 * @generated
	 */
	EReference getHeatExchanger_Pipe();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.january.geometry.HeatExchanger#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Input</em>'.
	 * @see org.eclipse.january.geometry.HeatExchanger#getInput()
	 * @see #getHeatExchanger()
	 * @generated
	 */
	EReference getHeatExchanger_Input();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.january.geometry.HeatExchanger#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Output</em>'.
	 * @see org.eclipse.january.geometry.HeatExchanger#getOutput()
	 * @see #getHeatExchanger()
	 * @generated
	 */
	EReference getHeatExchanger_Output();

	/**
	 * Returns the meta object for class '{@link org.eclipse.january.geometry.Reactor <em>Reactor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reactor</em>'.
	 * @see org.eclipse.january.geometry.Reactor
	 * @generated
	 */
	EClass getReactor();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.january.geometry.Reactor#getPipes <em>Pipes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pipes</em>'.
	 * @see org.eclipse.january.geometry.Reactor#getPipes()
	 * @see #getReactor()
	 * @generated
	 */
	EReference getReactor_Pipes();

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
		 * The meta object literal for the '<em><b>Vertex1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRIANGLE__VERTEX1 = eINSTANCE.getTriangle_Vertex1();

		/**
		 * The meta object literal for the '<em><b>Vertex2</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRIANGLE__VERTEX2 = eINSTANCE.getTriangle_Vertex2();

		/**
		 * The meta object literal for the '<em><b>Vertex3</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRIANGLE__VERTEX3 = eINSTANCE.getTriangle_Vertex3();

		/**
		 * The meta object literal for the '<em><b>Equals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TRIANGLE___EQUALS__OBJECT = eINSTANCE.getTriangle__Equals__Object();

		/**
		 * The meta object literal for the '<em><b>Hash Code</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TRIANGLE___HASH_CODE = eINSTANCE.getTriangle__HashCode();

		/**
		 * The meta object literal for the '<em><b>Get Vertices</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TRIANGLE___GET_VERTICES = eINSTANCE.getTriangle__GetVertices();

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
		 * The meta object literal for the '<em><b>Equals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VERTEX___EQUALS__OBJECT = eINSTANCE.getVertex__Equals__Object();

		/**
		 * The meta object literal for the '<em><b>Hash Code</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VERTEX___HASH_CODE = eINSTANCE.getVertex__HashCode();

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
		 * The meta object literal for the '{@link org.eclipse.january.geometry.impl.STLGeometryImporterImpl <em>STL Geometry Importer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.january.geometry.impl.STLGeometryImporterImpl
		 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getSTLGeometryImporter()
		 * @generated
		 */
		EClass STL_GEOMETRY_IMPORTER = eINSTANCE.getSTLGeometryImporter();

		/**
		 * The meta object literal for the '{@link org.eclipse.january.geometry.impl.PipeImpl <em>Pipe</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.january.geometry.impl.PipeImpl
		 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getPipe()
		 * @generated
		 */
		EClass PIPE = eINSTANCE.getPipe();

		/**
		 * The meta object literal for the '<em><b>Num Rods</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PIPE__NUM_RODS = eINSTANCE.getPipe_NumRods();

		/**
		 * The meta object literal for the '<em><b>Pitch</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PIPE__PITCH = eINSTANCE.getPipe_Pitch();

		/**
		 * The meta object literal for the '<em><b>Rod Diameter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PIPE__ROD_DIAMETER = eINSTANCE.getPipe_RodDiameter();

		/**
		 * The meta object literal for the '<em><b>Rotation X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PIPE__ROTATION_X = eINSTANCE.getPipe_RotationX();

		/**
		 * The meta object literal for the '<em><b>Rotation Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PIPE__ROTATION_Y = eINSTANCE.getPipe_RotationY();

		/**
		 * The meta object literal for the '<em><b>Rotation Z</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PIPE__ROTATION_Z = eINSTANCE.getPipe_RotationZ();

		/**
		 * The meta object literal for the '<em><b>Get Lower Edge</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PIPE___GET_LOWER_EDGE = eINSTANCE.getPipe__GetLowerEdge();

		/**
		 * The meta object literal for the '<em><b>Get Upper Edge</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PIPE___GET_UPPER_EDGE = eINSTANCE.getPipe__GetUpperEdge();

		/**
		 * The meta object literal for the '{@link org.eclipse.january.geometry.impl.BoundingBoxImpl <em>Bounding Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.january.geometry.impl.BoundingBoxImpl
		 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getBoundingBox()
		 * @generated
		 */
		EClass BOUNDING_BOX = eINSTANCE.getBoundingBox();

		/**
		 * The meta object literal for the '<em><b>Max X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDING_BOX__MAX_X = eINSTANCE.getBoundingBox_MaxX();

		/**
		 * The meta object literal for the '<em><b>Max Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDING_BOX__MAX_Y = eINSTANCE.getBoundingBox_MaxY();

		/**
		 * The meta object literal for the '<em><b>Max Z</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDING_BOX__MAX_Z = eINSTANCE.getBoundingBox_MaxZ();

		/**
		 * The meta object literal for the '<em><b>Min X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDING_BOX__MIN_X = eINSTANCE.getBoundingBox_MinX();

		/**
		 * The meta object literal for the '<em><b>Min Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDING_BOX__MIN_Y = eINSTANCE.getBoundingBox_MinY();

		/**
		 * The meta object literal for the '<em><b>Min Z</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDING_BOX__MIN_Z = eINSTANCE.getBoundingBox_MinZ();

		/**
		 * The meta object literal for the '<em><b>Add Area</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOUNDING_BOX___ADD_AREA__BOUNDINGBOX = eINSTANCE.getBoundingBox__AddArea__BoundingBox();

		/**
		 * The meta object literal for the '{@link org.eclipse.january.geometry.impl.JunctionImpl <em>Junction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.january.geometry.impl.JunctionImpl
		 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getJunction()
		 * @generated
		 */
		EClass JUNCTION = eINSTANCE.getJunction();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JUNCTION__HEIGHT = eINSTANCE.getJunction_Height();

		/**
		 * The meta object literal for the '<em><b>ZIn</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JUNCTION__ZIN = eINSTANCE.getJunction_ZIn();

		/**
		 * The meta object literal for the '<em><b>ZOut</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JUNCTION__ZOUT = eINSTANCE.getJunction_ZOut();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JUNCTION__INPUT = eINSTANCE.getJunction_Input();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JUNCTION__OUTPUT = eINSTANCE.getJunction_Output();

		/**
		 * The meta object literal for the '{@link org.eclipse.january.geometry.impl.HeatExchangerImpl <em>Heat Exchanger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.january.geometry.impl.HeatExchangerImpl
		 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getHeatExchanger()
		 * @generated
		 */
		EClass HEAT_EXCHANGER = eINSTANCE.getHeatExchanger();

		/**
		 * The meta object literal for the '<em><b>Pipe</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HEAT_EXCHANGER__PIPE = eINSTANCE.getHeatExchanger_Pipe();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HEAT_EXCHANGER__INPUT = eINSTANCE.getHeatExchanger_Input();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HEAT_EXCHANGER__OUTPUT = eINSTANCE.getHeatExchanger_Output();

		/**
		 * The meta object literal for the '{@link org.eclipse.january.geometry.impl.ReactorImpl <em>Reactor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.january.geometry.impl.ReactorImpl
		 * @see org.eclipse.january.geometry.impl.GeometryPackageImpl#getReactor()
		 * @generated
		 */
		EClass REACTOR = eINSTANCE.getReactor();

		/**
		 * The meta object literal for the '<em><b>Pipes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REACTOR__PIPES = eINSTANCE.getReactor_Pipes();

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
