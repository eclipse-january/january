/**
 */
package org.eclipse.january.geometry.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.january.geometry.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.january.geometry.GeometryPackage
 * @generated
 */
public class GeometrySwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GeometryPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeometrySwitch() {
		if (modelPackage == null) {
			modelPackage = GeometryPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case GeometryPackage.SHAPE: {
				Shape shape = (Shape)theEObject;
				T result = caseShape(shape);
				if (result == null) result = caseINode(shape);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeometryPackage.TRIANGLE: {
				Triangle triangle = (Triangle)theEObject;
				T result = caseTriangle(triangle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeometryPackage.VERTEX: {
				Vertex vertex = (Vertex)theEObject;
				T result = caseVertex(vertex);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeometryPackage.SPHERE: {
				Sphere sphere = (Sphere)theEObject;
				T result = caseSphere(sphere);
				if (result == null) result = caseShape(sphere);
				if (result == null) result = caseINode(sphere);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeometryPackage.CUBE: {
				Cube cube = (Cube)theEObject;
				T result = caseCube(cube);
				if (result == null) result = caseShape(cube);
				if (result == null) result = caseINode(cube);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeometryPackage.CYLINDER: {
				Cylinder cylinder = (Cylinder)theEObject;
				T result = caseCylinder(cylinder);
				if (result == null) result = caseShape(cylinder);
				if (result == null) result = caseINode(cylinder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeometryPackage.GEOMETRY: {
				Geometry geometry = (Geometry)theEObject;
				T result = caseGeometry(geometry);
				if (result == null) result = caseINode(geometry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeometryPackage.TUBE: {
				Tube tube = (Tube)theEObject;
				T result = caseTube(tube);
				if (result == null) result = caseShape(tube);
				if (result == null) result = caseINode(tube);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeometryPackage.INODE: {
				INode iNode = (INode)theEObject;
				T result = caseINode(iNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeometryPackage.OPERATOR: {
				Operator operator = (Operator)theEObject;
				T result = caseOperator(operator);
				if (result == null) result = caseINode(operator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeometryPackage.UNION: {
				Union union = (Union)theEObject;
				T result = caseUnion(union);
				if (result == null) result = caseOperator(union);
				if (result == null) result = caseINode(union);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeometryPackage.INTERSECTION: {
				Intersection intersection = (Intersection)theEObject;
				T result = caseIntersection(intersection);
				if (result == null) result = caseOperator(intersection);
				if (result == null) result = caseINode(intersection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeometryPackage.COMPLEMENT: {
				Complement complement = (Complement)theEObject;
				T result = caseComplement(complement);
				if (result == null) result = caseOperator(complement);
				if (result == null) result = caseINode(complement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeometryPackage.MATERIAL: {
				Material material = (Material)theEObject;
				T result = caseMaterial(material);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeometryPackage.IGEOMETRY_IMPORTER: {
				IGeometryImporter iGeometryImporter = (IGeometryImporter)theEObject;
				T result = caseIGeometryImporter(iGeometryImporter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeometryPackage.ASCIISTL_GEOMETRY_IMPORTER: {
				STLGeometryImporter asciistlGeometryImporter = (STLGeometryImporter)theEObject;
				T result = caseASCIISTLGeometryImporter(asciistlGeometryImporter);
				if (result == null) result = caseIGeometryImporter(asciistlGeometryImporter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShape(Shape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Triangle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Triangle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTriangle(Triangle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vertex</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vertex</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVertex(Vertex object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sphere</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sphere</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSphere(Sphere object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cube</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cube</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCube(Cube object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cylinder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cylinder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCylinder(Cylinder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Geometry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Geometry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGeometry(Geometry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tube</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tube</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTube(Tube object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>INode</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>INode</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseINode(INode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperator(Operator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Union</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Union</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnion(Union object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Intersection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Intersection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntersection(Intersection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComplement(Complement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Material</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Material</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMaterial(Material object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IGeometry Importer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IGeometry Importer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIGeometryImporter(IGeometryImporter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ASCIISTL Geometry Importer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ASCIISTL Geometry Importer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseASCIISTLGeometryImporter(STLGeometryImporter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //GeometrySwitch
