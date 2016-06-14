/**
 */
package geometry;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * @see geometry.GeometryFactory
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
	String eNS_URI = "http://www.eclipse.org/";

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
	GeometryPackage eINSTANCE = geometry.impl.GeometryPackageImpl.init();

	/**
	 * The meta object id for the '{@link geometry.ISubjectShape <em>ISubject Shape</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see geometry.ISubjectShape
	 * @see geometry.impl.GeometryPackageImpl#getISubjectShape()
	 * @generated
	 */
	int ISUBJECT_SHAPE = 13;

	/**
	 * The number of structural features of the '<em>ISubject Shape</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISUBJECT_SHAPE_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Register</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISUBJECT_SHAPE___REGISTER__ISHAPEOBSERVER = 0;

	/**
	 * The operation id for the '<em>Unregister</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISUBJECT_SHAPE___UNREGISTER__ISHAPEOBSERVER = 1;

	/**
	 * The number of operations of the '<em>ISubject Shape</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISUBJECT_SHAPE_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link geometry.impl.ShapeImpl <em>Shape</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see geometry.impl.ShapeImpl
	 * @see geometry.impl.GeometryPackageImpl#getShape()
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
	int SHAPE__NAME = ISUBJECT_SHAPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE__ID = ISUBJECT_SHAPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE__NODES = ISUBJECT_SHAPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE__TYPE = ISUBJECT_SHAPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Triangles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE__TRIANGLES = ISUBJECT_SHAPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Center</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE__CENTER = ISUBJECT_SHAPE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Material</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE__MATERIAL = ISUBJECT_SHAPE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Shape</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE_FEATURE_COUNT = ISUBJECT_SHAPE_FEATURE_COUNT + 7;

	/**
	 * The operation id for the '<em>Register</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE___REGISTER__ISHAPEOBSERVER = ISUBJECT_SHAPE___REGISTER__ISHAPEOBSERVER;

	/**
	 * The operation id for the '<em>Unregister</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE___UNREGISTER__ISHAPEOBSERVER = ISUBJECT_SHAPE___UNREGISTER__ISHAPEOBSERVER;

	/**
	 * The operation id for the '<em>Get Property Names</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE___GET_PROPERTY_NAMES = ISUBJECT_SHAPE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE___GET_PROPERTY__STRING = ISUBJECT_SHAPE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE___SET_PROPERTY__STRING_DOUBLE = ISUBJECT_SHAPE_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Shape</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE_OPERATION_COUNT = ISUBJECT_SHAPE_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link geometry.impl.TriangleImpl <em>Triangle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see geometry.impl.TriangleImpl
	 * @see geometry.impl.GeometryPackageImpl#getTriangle()
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
	 * The meta object id for the '{@link geometry.impl.VertexImpl <em>Vertex</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see geometry.impl.VertexImpl
	 * @see geometry.impl.GeometryPackageImpl#getVertex()
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
	 * The number of operations of the '<em>Vertex</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link geometry.impl.SphereImpl <em>Sphere</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see geometry.impl.SphereImpl
	 * @see geometry.impl.GeometryPackageImpl#getSphere()
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
	 * The operation id for the '<em>Register</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPHERE___REGISTER__ISHAPEOBSERVER = SHAPE___REGISTER__ISHAPEOBSERVER;

	/**
	 * The operation id for the '<em>Unregister</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPHERE___UNREGISTER__ISHAPEOBSERVER = SHAPE___UNREGISTER__ISHAPEOBSERVER;

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
	 * The number of operations of the '<em>Sphere</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPHERE_OPERATION_COUNT = SHAPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link geometry.impl.CubeImpl <em>Cube</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see geometry.impl.CubeImpl
	 * @see geometry.impl.GeometryPackageImpl#getCube()
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
	 * The operation id for the '<em>Register</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUBE___REGISTER__ISHAPEOBSERVER = SHAPE___REGISTER__ISHAPEOBSERVER;

	/**
	 * The operation id for the '<em>Unregister</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUBE___UNREGISTER__ISHAPEOBSERVER = SHAPE___UNREGISTER__ISHAPEOBSERVER;

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
	 * The number of operations of the '<em>Cube</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUBE_OPERATION_COUNT = SHAPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link geometry.impl.CylinderImpl <em>Cylinder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see geometry.impl.CylinderImpl
	 * @see geometry.impl.GeometryPackageImpl#getCylinder()
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
	 * The operation id for the '<em>Register</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYLINDER___REGISTER__ISHAPEOBSERVER = SHAPE___REGISTER__ISHAPEOBSERVER;

	/**
	 * The operation id for the '<em>Unregister</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYLINDER___UNREGISTER__ISHAPEOBSERVER = SHAPE___UNREGISTER__ISHAPEOBSERVER;

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
	 * The number of operations of the '<em>Cylinder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYLINDER_OPERATION_COUNT = SHAPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link geometry.INode <em>INode</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see geometry.INode
	 * @see geometry.impl.GeometryPackageImpl#getINode()
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
	 * The number of structural features of the '<em>INode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INODE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>INode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link geometry.impl.GeometryImpl <em>Geometry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see geometry.impl.GeometryImpl
	 * @see geometry.impl.GeometryPackageImpl#getGeometry()
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
	 * The number of structural features of the '<em>Geometry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY_FEATURE_COUNT = INODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Geometry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY_OPERATION_COUNT = INODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link geometry.impl.TubeImpl <em>Tube</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see geometry.impl.TubeImpl
	 * @see geometry.impl.GeometryPackageImpl#getTube()
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
	 * The operation id for the '<em>Register</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUBE___REGISTER__ISHAPEOBSERVER = SHAPE___REGISTER__ISHAPEOBSERVER;

	/**
	 * The operation id for the '<em>Unregister</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUBE___UNREGISTER__ISHAPEOBSERVER = SHAPE___UNREGISTER__ISHAPEOBSERVER;

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
	 * The number of operations of the '<em>Tube</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUBE_OPERATION_COUNT = SHAPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link geometry.impl.OperatorImpl <em>Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see geometry.impl.OperatorImpl
	 * @see geometry.impl.GeometryPackageImpl#getOperator()
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
	 * The number of structural features of the '<em>Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_FEATURE_COUNT = INODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_OPERATION_COUNT = INODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link geometry.impl.UnionImpl <em>Union</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see geometry.impl.UnionImpl
	 * @see geometry.impl.GeometryPackageImpl#getUnion()
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
	 * The number of structural features of the '<em>Union</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Union</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_OPERATION_COUNT = OPERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link geometry.impl.IntersectionImpl <em>Intersection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see geometry.impl.IntersectionImpl
	 * @see geometry.impl.GeometryPackageImpl#getIntersection()
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
	 * The number of structural features of the '<em>Intersection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Intersection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_OPERATION_COUNT = OPERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link geometry.impl.ComplementImpl <em>Complement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see geometry.impl.ComplementImpl
	 * @see geometry.impl.GeometryPackageImpl#getComplement()
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
	 * The number of structural features of the '<em>Complement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEMENT_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Complement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEMENT_OPERATION_COUNT = OPERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link geometry.IShapeObserver <em>IShape Observer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see geometry.IShapeObserver
	 * @see geometry.impl.GeometryPackageImpl#getIShapeObserver()
	 * @generated
	 */
	int ISHAPE_OBSERVER = 14;

	/**
	 * The number of structural features of the '<em>IShape Observer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISHAPE_OBSERVER_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Update</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISHAPE_OBSERVER___UPDATE__SHAPECHANGEEVENT_ISUBJECTSHAPE = 0;

	/**
	 * The number of operations of the '<em>IShape Observer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISHAPE_OBSERVER_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link geometry.impl.MaterialImpl <em>Material</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see geometry.impl.MaterialImpl
	 * @see geometry.impl.GeometryPackageImpl#getMaterial()
	 * @generated
	 */
	int MATERIAL = 15;

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
	 * The meta object id for the '{@link geometry.impl.ShapeChangeEventImpl <em>Shape Change Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see geometry.impl.ShapeChangeEventImpl
	 * @see geometry.impl.GeometryPackageImpl#getShapeChangeEvent()
	 * @generated
	 */
	int SHAPE_CHANGE_EVENT = 16;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE_CHANGE_EVENT__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE_CHANGE_EVENT__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Shape Change Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE_CHANGE_EVENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Shape Change Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE_CHANGE_EVENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link geometry.IGeometryImporter <em>IGeometry Importer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see geometry.IGeometryImporter
	 * @see geometry.impl.GeometryPackageImpl#getIGeometryImporter()
	 * @generated
	 */
	int IGEOMETRY_IMPORTER = 17;

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
	 * The meta object id for the '{@link geometry.impl.ASCIISTLGeometryImporterImpl <em>ASCIISTL Geometry Importer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see geometry.impl.ASCIISTLGeometryImporterImpl
	 * @see geometry.impl.GeometryPackageImpl#getASCIISTLGeometryImporter()
	 * @generated
	 */
	int ASCIISTL_GEOMETRY_IMPORTER = 18;

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
	 * The meta object id for the '{@link geometry.ShapeChangeEventType <em>Shape Change Event Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see geometry.ShapeChangeEventType
	 * @see geometry.impl.GeometryPackageImpl#getShapeChangeEventType()
	 * @generated
	 */
	int SHAPE_CHANGE_EVENT_TYPE = 19;

	/**
	 * The meta object id for the '<em>Path</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.nio.file.Path
	 * @see geometry.impl.GeometryPackageImpl#getPath()
	 * @generated
	 */
	int PATH = 20;

	/**
	 * Returns the meta object for class '{@link geometry.Shape <em>Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shape</em>'.
	 * @see geometry.Shape
	 * @generated
	 */
	EClass getShape();

	/**
	 * Returns the meta object for the reference '{@link geometry.Shape#getCenter <em>Center</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Center</em>'.
	 * @see geometry.Shape#getCenter()
	 * @see #getShape()
	 * @generated
	 */
	EReference getShape_Center();

	/**
	 * Returns the meta object for the containment reference '{@link geometry.Shape#getMaterial <em>Material</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Material</em>'.
	 * @see geometry.Shape#getMaterial()
	 * @see #getShape()
	 * @generated
	 */
	EReference getShape_Material();

	/**
	 * Returns the meta object for the '{@link geometry.Shape#getPropertyNames() <em>Get Property Names</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Property Names</em>' operation.
	 * @see geometry.Shape#getPropertyNames()
	 * @generated
	 */
	EOperation getShape__GetPropertyNames();

	/**
	 * Returns the meta object for the '{@link geometry.Shape#getProperty(java.lang.String) <em>Get Property</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Property</em>' operation.
	 * @see geometry.Shape#getProperty(java.lang.String)
	 * @generated
	 */
	EOperation getShape__GetProperty__String();

	/**
	 * Returns the meta object for the '{@link geometry.Shape#setProperty(java.lang.String, double) <em>Set Property</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Set Property</em>' operation.
	 * @see geometry.Shape#setProperty(java.lang.String, double)
	 * @generated
	 */
	EOperation getShape__SetProperty__String_double();

	/**
	 * Returns the meta object for class '{@link geometry.Triangle <em>Triangle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Triangle</em>'.
	 * @see geometry.Triangle
	 * @generated
	 */
	EClass getTriangle();

	/**
	 * Returns the meta object for the containment reference '{@link geometry.Triangle#getNormal <em>Normal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Normal</em>'.
	 * @see geometry.Triangle#getNormal()
	 * @see #getTriangle()
	 * @generated
	 */
	EReference getTriangle_Normal();

	/**
	 * Returns the meta object for the containment reference list '{@link geometry.Triangle#getVertices <em>Vertices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vertices</em>'.
	 * @see geometry.Triangle#getVertices()
	 * @see #getTriangle()
	 * @generated
	 */
	EReference getTriangle_Vertices();

	/**
	 * Returns the meta object for class '{@link geometry.Vertex <em>Vertex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vertex</em>'.
	 * @see geometry.Vertex
	 * @generated
	 */
	EClass getVertex();

	/**
	 * Returns the meta object for the attribute '{@link geometry.Vertex#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see geometry.Vertex#getX()
	 * @see #getVertex()
	 * @generated
	 */
	EAttribute getVertex_X();

	/**
	 * Returns the meta object for the attribute '{@link geometry.Vertex#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see geometry.Vertex#getY()
	 * @see #getVertex()
	 * @generated
	 */
	EAttribute getVertex_Y();

	/**
	 * Returns the meta object for the attribute '{@link geometry.Vertex#getZ <em>Z</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Z</em>'.
	 * @see geometry.Vertex#getZ()
	 * @see #getVertex()
	 * @generated
	 */
	EAttribute getVertex_Z();

	/**
	 * Returns the meta object for class '{@link geometry.Sphere <em>Sphere</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sphere</em>'.
	 * @see geometry.Sphere
	 * @generated
	 */
	EClass getSphere();

	/**
	 * Returns the meta object for the attribute '{@link geometry.Sphere#getRadius <em>Radius</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Radius</em>'.
	 * @see geometry.Sphere#getRadius()
	 * @see #getSphere()
	 * @generated
	 */
	EAttribute getSphere_Radius();

	/**
	 * Returns the meta object for class '{@link geometry.Cube <em>Cube</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cube</em>'.
	 * @see geometry.Cube
	 * @generated
	 */
	EClass getCube();

	/**
	 * Returns the meta object for the attribute '{@link geometry.Cube#getSideLength <em>Side Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Side Length</em>'.
	 * @see geometry.Cube#getSideLength()
	 * @see #getCube()
	 * @generated
	 */
	EAttribute getCube_SideLength();

	/**
	 * Returns the meta object for class '{@link geometry.Cylinder <em>Cylinder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cylinder</em>'.
	 * @see geometry.Cylinder
	 * @generated
	 */
	EClass getCylinder();

	/**
	 * Returns the meta object for the attribute '{@link geometry.Cylinder#getRadius <em>Radius</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Radius</em>'.
	 * @see geometry.Cylinder#getRadius()
	 * @see #getCylinder()
	 * @generated
	 */
	EAttribute getCylinder_Radius();

	/**
	 * Returns the meta object for the attribute '{@link geometry.Cylinder#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see geometry.Cylinder#getHeight()
	 * @see #getCylinder()
	 * @generated
	 */
	EAttribute getCylinder_Height();

	/**
	 * Returns the meta object for class '{@link geometry.Geometry <em>Geometry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Geometry</em>'.
	 * @see geometry.Geometry
	 * @generated
	 */
	EClass getGeometry();

	/**
	 * Returns the meta object for class '{@link geometry.Tube <em>Tube</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tube</em>'.
	 * @see geometry.Tube
	 * @generated
	 */
	EClass getTube();

	/**
	 * Returns the meta object for the attribute '{@link geometry.Tube#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see geometry.Tube#getHeight()
	 * @see #getTube()
	 * @generated
	 */
	EAttribute getTube_Height();

	/**
	 * Returns the meta object for the attribute '{@link geometry.Tube#getInnerRadius <em>Inner Radius</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inner Radius</em>'.
	 * @see geometry.Tube#getInnerRadius()
	 * @see #getTube()
	 * @generated
	 */
	EAttribute getTube_InnerRadius();

	/**
	 * Returns the meta object for the attribute '{@link geometry.Tube#getRadius <em>Radius</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Radius</em>'.
	 * @see geometry.Tube#getRadius()
	 * @see #getTube()
	 * @generated
	 */
	EAttribute getTube_Radius();

	/**
	 * Returns the meta object for class '{@link geometry.INode <em>INode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>INode</em>'.
	 * @see geometry.INode
	 * @generated
	 */
	EClass getINode();

	/**
	 * Returns the meta object for the attribute '{@link geometry.INode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see geometry.INode#getName()
	 * @see #getINode()
	 * @generated
	 */
	EAttribute getINode_Name();

	/**
	 * Returns the meta object for the attribute '{@link geometry.INode#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see geometry.INode#getId()
	 * @see #getINode()
	 * @generated
	 */
	EAttribute getINode_Id();

	/**
	 * Returns the meta object for the containment reference list '{@link geometry.INode#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see geometry.INode#getNodes()
	 * @see #getINode()
	 * @generated
	 */
	EReference getINode_Nodes();

	/**
	 * Returns the meta object for the attribute '{@link geometry.INode#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see geometry.INode#getType()
	 * @see #getINode()
	 * @generated
	 */
	EAttribute getINode_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link geometry.INode#getTriangles <em>Triangles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Triangles</em>'.
	 * @see geometry.INode#getTriangles()
	 * @see #getINode()
	 * @generated
	 */
	EReference getINode_Triangles();

	/**
	 * Returns the meta object for class '{@link geometry.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator</em>'.
	 * @see geometry.Operator
	 * @generated
	 */
	EClass getOperator();

	/**
	 * Returns the meta object for class '{@link geometry.Union <em>Union</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Union</em>'.
	 * @see geometry.Union
	 * @generated
	 */
	EClass getUnion();

	/**
	 * Returns the meta object for class '{@link geometry.Intersection <em>Intersection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Intersection</em>'.
	 * @see geometry.Intersection
	 * @generated
	 */
	EClass getIntersection();

	/**
	 * Returns the meta object for class '{@link geometry.Complement <em>Complement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complement</em>'.
	 * @see geometry.Complement
	 * @generated
	 */
	EClass getComplement();

	/**
	 * Returns the meta object for class '{@link geometry.ISubjectShape <em>ISubject Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ISubject Shape</em>'.
	 * @see geometry.ISubjectShape
	 * @generated
	 */
	EClass getISubjectShape();

	/**
	 * Returns the meta object for the '{@link geometry.ISubjectShape#register(geometry.IShapeObserver) <em>Register</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Register</em>' operation.
	 * @see geometry.ISubjectShape#register(geometry.IShapeObserver)
	 * @generated
	 */
	EOperation getISubjectShape__Register__IShapeObserver();

	/**
	 * Returns the meta object for the '{@link geometry.ISubjectShape#unregister(geometry.IShapeObserver) <em>Unregister</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Unregister</em>' operation.
	 * @see geometry.ISubjectShape#unregister(geometry.IShapeObserver)
	 * @generated
	 */
	EOperation getISubjectShape__Unregister__IShapeObserver();

	/**
	 * Returns the meta object for class '{@link geometry.IShapeObserver <em>IShape Observer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IShape Observer</em>'.
	 * @see geometry.IShapeObserver
	 * @generated
	 */
	EClass getIShapeObserver();

	/**
	 * Returns the meta object for the '{@link geometry.IShapeObserver#update(geometry.ShapeChangeEvent, geometry.ISubjectShape) <em>Update</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Update</em>' operation.
	 * @see geometry.IShapeObserver#update(geometry.ShapeChangeEvent, geometry.ISubjectShape)
	 * @generated
	 */
	EOperation getIShapeObserver__Update__ShapeChangeEvent_ISubjectShape();

	/**
	 * Returns the meta object for class '{@link geometry.Material <em>Material</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Material</em>'.
	 * @see geometry.Material
	 * @generated
	 */
	EClass getMaterial();

	/**
	 * Returns the meta object for class '{@link geometry.ShapeChangeEvent <em>Shape Change Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shape Change Event</em>'.
	 * @see geometry.ShapeChangeEvent
	 * @generated
	 */
	EClass getShapeChangeEvent();

	/**
	 * Returns the meta object for the attribute '{@link geometry.ShapeChangeEvent#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see geometry.ShapeChangeEvent#getType()
	 * @see #getShapeChangeEvent()
	 * @generated
	 */
	EAttribute getShapeChangeEvent_Type();

	/**
	 * Returns the meta object for the attribute '{@link geometry.ShapeChangeEvent#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see geometry.ShapeChangeEvent#getValue()
	 * @see #getShapeChangeEvent()
	 * @generated
	 */
	EAttribute getShapeChangeEvent_Value();

	/**
	 * Returns the meta object for class '{@link geometry.IGeometryImporter <em>IGeometry Importer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IGeometry Importer</em>'.
	 * @see geometry.IGeometryImporter
	 * @generated
	 */
	EClass getIGeometryImporter();

	/**
	 * Returns the meta object for the attribute list '{@link geometry.IGeometryImporter#getFileTypes <em>File Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>File Types</em>'.
	 * @see geometry.IGeometryImporter#getFileTypes()
	 * @see #getIGeometryImporter()
	 * @generated
	 */
	EAttribute getIGeometryImporter_FileTypes();

	/**
	 * Returns the meta object for the attribute '{@link geometry.IGeometryImporter#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see geometry.IGeometryImporter#getDescription()
	 * @see #getIGeometryImporter()
	 * @generated
	 */
	EAttribute getIGeometryImporter_Description();

	/**
	 * Returns the meta object for the '{@link geometry.IGeometryImporter#load(java.nio.file.Path) <em>Load</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Load</em>' operation.
	 * @see geometry.IGeometryImporter#load(java.nio.file.Path)
	 * @generated
	 */
	EOperation getIGeometryImporter__Load__Path();

	/**
	 * Returns the meta object for class '{@link geometry.ASCIISTLGeometryImporter <em>ASCIISTL Geometry Importer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ASCIISTL Geometry Importer</em>'.
	 * @see geometry.ASCIISTLGeometryImporter
	 * @generated
	 */
	EClass getASCIISTLGeometryImporter();

	/**
	 * Returns the meta object for enum '{@link geometry.ShapeChangeEventType <em>Shape Change Event Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Shape Change Event Type</em>'.
	 * @see geometry.ShapeChangeEventType
	 * @generated
	 */
	EEnum getShapeChangeEventType();

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
		 * The meta object literal for the '{@link geometry.impl.ShapeImpl <em>Shape</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see geometry.impl.ShapeImpl
		 * @see geometry.impl.GeometryPackageImpl#getShape()
		 * @generated
		 */
		EClass SHAPE = eINSTANCE.getShape();

		/**
		 * The meta object literal for the '<em><b>Center</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHAPE__CENTER = eINSTANCE.getShape_Center();

		/**
		 * The meta object literal for the '<em><b>Material</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHAPE__MATERIAL = eINSTANCE.getShape_Material();

		/**
		 * The meta object literal for the '<em><b>Get Property Names</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SHAPE___GET_PROPERTY_NAMES = eINSTANCE.getShape__GetPropertyNames();

		/**
		 * The meta object literal for the '<em><b>Get Property</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SHAPE___GET_PROPERTY__STRING = eINSTANCE.getShape__GetProperty__String();

		/**
		 * The meta object literal for the '<em><b>Set Property</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SHAPE___SET_PROPERTY__STRING_DOUBLE = eINSTANCE.getShape__SetProperty__String_double();

		/**
		 * The meta object literal for the '{@link geometry.impl.TriangleImpl <em>Triangle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see geometry.impl.TriangleImpl
		 * @see geometry.impl.GeometryPackageImpl#getTriangle()
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
		 * The meta object literal for the '{@link geometry.impl.VertexImpl <em>Vertex</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see geometry.impl.VertexImpl
		 * @see geometry.impl.GeometryPackageImpl#getVertex()
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
		 * The meta object literal for the '{@link geometry.impl.SphereImpl <em>Sphere</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see geometry.impl.SphereImpl
		 * @see geometry.impl.GeometryPackageImpl#getSphere()
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
		 * The meta object literal for the '{@link geometry.impl.CubeImpl <em>Cube</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see geometry.impl.CubeImpl
		 * @see geometry.impl.GeometryPackageImpl#getCube()
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
		 * The meta object literal for the '{@link geometry.impl.CylinderImpl <em>Cylinder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see geometry.impl.CylinderImpl
		 * @see geometry.impl.GeometryPackageImpl#getCylinder()
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
		 * The meta object literal for the '{@link geometry.impl.GeometryImpl <em>Geometry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see geometry.impl.GeometryImpl
		 * @see geometry.impl.GeometryPackageImpl#getGeometry()
		 * @generated
		 */
		EClass GEOMETRY = eINSTANCE.getGeometry();

		/**
		 * The meta object literal for the '{@link geometry.impl.TubeImpl <em>Tube</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see geometry.impl.TubeImpl
		 * @see geometry.impl.GeometryPackageImpl#getTube()
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
		 * The meta object literal for the '{@link geometry.INode <em>INode</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see geometry.INode
		 * @see geometry.impl.GeometryPackageImpl#getINode()
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
		 * The meta object literal for the '{@link geometry.impl.OperatorImpl <em>Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see geometry.impl.OperatorImpl
		 * @see geometry.impl.GeometryPackageImpl#getOperator()
		 * @generated
		 */
		EClass OPERATOR = eINSTANCE.getOperator();

		/**
		 * The meta object literal for the '{@link geometry.impl.UnionImpl <em>Union</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see geometry.impl.UnionImpl
		 * @see geometry.impl.GeometryPackageImpl#getUnion()
		 * @generated
		 */
		EClass UNION = eINSTANCE.getUnion();

		/**
		 * The meta object literal for the '{@link geometry.impl.IntersectionImpl <em>Intersection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see geometry.impl.IntersectionImpl
		 * @see geometry.impl.GeometryPackageImpl#getIntersection()
		 * @generated
		 */
		EClass INTERSECTION = eINSTANCE.getIntersection();

		/**
		 * The meta object literal for the '{@link geometry.impl.ComplementImpl <em>Complement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see geometry.impl.ComplementImpl
		 * @see geometry.impl.GeometryPackageImpl#getComplement()
		 * @generated
		 */
		EClass COMPLEMENT = eINSTANCE.getComplement();

		/**
		 * The meta object literal for the '{@link geometry.ISubjectShape <em>ISubject Shape</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see geometry.ISubjectShape
		 * @see geometry.impl.GeometryPackageImpl#getISubjectShape()
		 * @generated
		 */
		EClass ISUBJECT_SHAPE = eINSTANCE.getISubjectShape();

		/**
		 * The meta object literal for the '<em><b>Register</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ISUBJECT_SHAPE___REGISTER__ISHAPEOBSERVER = eINSTANCE.getISubjectShape__Register__IShapeObserver();

		/**
		 * The meta object literal for the '<em><b>Unregister</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ISUBJECT_SHAPE___UNREGISTER__ISHAPEOBSERVER = eINSTANCE.getISubjectShape__Unregister__IShapeObserver();

		/**
		 * The meta object literal for the '{@link geometry.IShapeObserver <em>IShape Observer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see geometry.IShapeObserver
		 * @see geometry.impl.GeometryPackageImpl#getIShapeObserver()
		 * @generated
		 */
		EClass ISHAPE_OBSERVER = eINSTANCE.getIShapeObserver();

		/**
		 * The meta object literal for the '<em><b>Update</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ISHAPE_OBSERVER___UPDATE__SHAPECHANGEEVENT_ISUBJECTSHAPE = eINSTANCE.getIShapeObserver__Update__ShapeChangeEvent_ISubjectShape();

		/**
		 * The meta object literal for the '{@link geometry.impl.MaterialImpl <em>Material</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see geometry.impl.MaterialImpl
		 * @see geometry.impl.GeometryPackageImpl#getMaterial()
		 * @generated
		 */
		EClass MATERIAL = eINSTANCE.getMaterial();

		/**
		 * The meta object literal for the '{@link geometry.impl.ShapeChangeEventImpl <em>Shape Change Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see geometry.impl.ShapeChangeEventImpl
		 * @see geometry.impl.GeometryPackageImpl#getShapeChangeEvent()
		 * @generated
		 */
		EClass SHAPE_CHANGE_EVENT = eINSTANCE.getShapeChangeEvent();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHAPE_CHANGE_EVENT__TYPE = eINSTANCE.getShapeChangeEvent_Type();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHAPE_CHANGE_EVENT__VALUE = eINSTANCE.getShapeChangeEvent_Value();

		/**
		 * The meta object literal for the '{@link geometry.IGeometryImporter <em>IGeometry Importer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see geometry.IGeometryImporter
		 * @see geometry.impl.GeometryPackageImpl#getIGeometryImporter()
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
		 * The meta object literal for the '{@link geometry.impl.ASCIISTLGeometryImporterImpl <em>ASCIISTL Geometry Importer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see geometry.impl.ASCIISTLGeometryImporterImpl
		 * @see geometry.impl.GeometryPackageImpl#getASCIISTLGeometryImporter()
		 * @generated
		 */
		EClass ASCIISTL_GEOMETRY_IMPORTER = eINSTANCE.getASCIISTLGeometryImporter();

		/**
		 * The meta object literal for the '{@link geometry.ShapeChangeEventType <em>Shape Change Event Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see geometry.ShapeChangeEventType
		 * @see geometry.impl.GeometryPackageImpl#getShapeChangeEventType()
		 * @generated
		 */
		EEnum SHAPE_CHANGE_EVENT_TYPE = eINSTANCE.getShapeChangeEventType();

		/**
		 * The meta object literal for the '<em>Path</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.nio.file.Path
		 * @see geometry.impl.GeometryPackageImpl#getPath()
		 * @generated
		 */
		EDataType PATH = eINSTANCE.getPath();

	}

} //GeometryPackage
