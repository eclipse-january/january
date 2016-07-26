/**
 */
package org.eclipse.january.geometry.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.january.geometry.Triangle;
import org.eclipse.january.geometry.Vertex;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Triangle</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.impl.TriangleImpl#getNormal <em>Normal</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.impl.TriangleImpl#getVertex1 <em>Vertex1</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.impl.TriangleImpl#getVertex2 <em>Vertex2</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.impl.TriangleImpl#getVertex3 <em>Vertex3</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TriangleImpl extends MinimalEObjectImpl.Container
		implements Triangle {
	/**
	 * The cached value of the '{@link #getNormal() <em>Normal</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNormal()
	 * @generated
	 * @ordered
	 */
	protected Vertex normal;

	/**
	 * The cached value of the '{@link #getVertex1() <em>Vertex1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVertex1()
	 * @generated
	 * @ordered
	 */
	protected Vertex vertex1;

	/**
	 * The cached value of the '{@link #getVertex2() <em>Vertex2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVertex2()
	 * @generated
	 * @ordered
	 */
	protected Vertex vertex2;

	/**
	 * The cached value of the '{@link #getVertex3() <em>Vertex3</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVertex3()
	 * @generated
	 * @ordered
	 */
	protected Vertex vertex3;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected TriangleImpl() {
		super();
		normal = GeometryFactory.eINSTANCE.createVertex();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.TRIANGLE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vertex getNormal() {
		return normal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNormal(Vertex newNormal,
			NotificationChain msgs) {
		Vertex oldNormal = normal;
		normal = newNormal;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeometryPackage.TRIANGLE__NORMAL, oldNormal, newNormal);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNormal(Vertex newNormal) {
		if (newNormal != normal) {
			NotificationChain msgs = null;
			if (normal != null)
				msgs = ((InternalEObject)normal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeometryPackage.TRIANGLE__NORMAL, null, msgs);
			if (newNormal != null)
				msgs = ((InternalEObject)newNormal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeometryPackage.TRIANGLE__NORMAL, null, msgs);
			msgs = basicSetNormal(newNormal, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.TRIANGLE__NORMAL, newNormal, newNormal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vertex getVertex1() {
		if (vertex1 == null) {
			vertex1 = GeometryFactory.eINSTANCE.createVertex();
		}
		return vertex1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVertex1(Vertex newVertex1, NotificationChain msgs) {
		Vertex oldVertex1 = vertex1;
		vertex1 = newVertex1;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeometryPackage.TRIANGLE__VERTEX1, oldVertex1, newVertex1);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVertex1(Vertex newVertex1) {
		if (newVertex1 != vertex1) {
			NotificationChain msgs = null;
			if (vertex1 != null)
				msgs = ((InternalEObject)vertex1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeometryPackage.TRIANGLE__VERTEX1, null, msgs);
			if (newVertex1 != null)
				msgs = ((InternalEObject)newVertex1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeometryPackage.TRIANGLE__VERTEX1, null, msgs);
			msgs = basicSetVertex1(newVertex1, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.TRIANGLE__VERTEX1, newVertex1, newVertex1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vertex getVertex2() {
		if (vertex2 == null) {
			vertex2 = GeometryFactory.eINSTANCE.createVertex();
		}
		return vertex2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVertex2(Vertex newVertex2, NotificationChain msgs) {
		Vertex oldVertex2 = vertex2;
		vertex2 = newVertex2;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeometryPackage.TRIANGLE__VERTEX2, oldVertex2, newVertex2);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVertex2(Vertex newVertex2) {
		if (newVertex2 != vertex2) {
			NotificationChain msgs = null;
			if (vertex2 != null)
				msgs = ((InternalEObject)vertex2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeometryPackage.TRIANGLE__VERTEX2, null, msgs);
			if (newVertex2 != null)
				msgs = ((InternalEObject)newVertex2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeometryPackage.TRIANGLE__VERTEX2, null, msgs);
			msgs = basicSetVertex2(newVertex2, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.TRIANGLE__VERTEX2, newVertex2, newVertex2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vertex getVertex3() {
		if (vertex3 == null) {
			vertex3 = GeometryFactory.eINSTANCE.createVertex();
		}
		return vertex3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVertex3(Vertex newVertex3, NotificationChain msgs) {
		Vertex oldVertex3 = vertex3;
		vertex3 = newVertex3;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeometryPackage.TRIANGLE__VERTEX3, oldVertex3, newVertex3);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVertex3(Vertex newVertex3) {
		if (newVertex3 != vertex3) {
			NotificationChain msgs = null;
			if (vertex3 != null)
				msgs = ((InternalEObject)vertex3).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeometryPackage.TRIANGLE__VERTEX3, null, msgs);
			if (newVertex3 != null)
				msgs = ((InternalEObject)newVertex3).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeometryPackage.TRIANGLE__VERTEX3, null, msgs);
			msgs = basicSetVertex3(newVertex3, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.TRIANGLE__VERTEX3, newVertex3, newVertex3));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<Vertex> getVertices() {

		//Create a list of all the vertices
		EList<Vertex> vertices = new BasicEList<Vertex>();
		vertices.add(vertex1);
		vertices.add(vertex2);
		vertices.add(vertex3);
		return vertices;
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
						for (Vertex vertex : getVertices()) {
							if (!otherVertices.contains(vertex)) {
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
		
		// Get each vertex's hash code
		vertexHashes.add(getVertex1().hashCode());
		vertexHashes.add(getVertex2().hashCode());
		vertexHashes.add(getVertex3().hashCode());

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

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeometryPackage.TRIANGLE__NORMAL:
				return basicSetNormal(null, msgs);
			case GeometryPackage.TRIANGLE__VERTEX1:
				return basicSetVertex1(null, msgs);
			case GeometryPackage.TRIANGLE__VERTEX2:
				return basicSetVertex2(null, msgs);
			case GeometryPackage.TRIANGLE__VERTEX3:
				return basicSetVertex3(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeometryPackage.TRIANGLE__NORMAL:
				return getNormal();
			case GeometryPackage.TRIANGLE__VERTEX1:
				return getVertex1();
			case GeometryPackage.TRIANGLE__VERTEX2:
				return getVertex2();
			case GeometryPackage.TRIANGLE__VERTEX3:
				return getVertex3();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GeometryPackage.TRIANGLE__NORMAL:
				setNormal((Vertex)newValue);
				return;
			case GeometryPackage.TRIANGLE__VERTEX1:
				setVertex1((Vertex)newValue);
				return;
			case GeometryPackage.TRIANGLE__VERTEX2:
				setVertex2((Vertex)newValue);
				return;
			case GeometryPackage.TRIANGLE__VERTEX3:
				setVertex3((Vertex)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GeometryPackage.TRIANGLE__NORMAL:
				setNormal((Vertex)null);
				return;
			case GeometryPackage.TRIANGLE__VERTEX1:
				setVertex1((Vertex)null);
				return;
			case GeometryPackage.TRIANGLE__VERTEX2:
				setVertex2((Vertex)null);
				return;
			case GeometryPackage.TRIANGLE__VERTEX3:
				setVertex3((Vertex)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GeometryPackage.TRIANGLE__NORMAL:
				return normal != null;
			case GeometryPackage.TRIANGLE__VERTEX1:
				return vertex1 != null;
			case GeometryPackage.TRIANGLE__VERTEX2:
				return vertex2 != null;
			case GeometryPackage.TRIANGLE__VERTEX3:
				return vertex3 != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID) {
			case GeometryPackage.TRIANGLE___EQUALS__OBJECT:
				return equals(arguments.get(0));
			case GeometryPackage.TRIANGLE___HASH_CODE:
				return hashCode();
			case GeometryPackage.TRIANGLE___GET_VERTICES:
				return getVertices();
		}
		return super.eInvoke(operationID, arguments);
	}

} // TriangleImpl
