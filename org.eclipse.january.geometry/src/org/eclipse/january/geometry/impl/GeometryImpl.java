/**
 */
package org.eclipse.january.geometry.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.january.geometry.Geometry;
import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.january.geometry.INode;
import org.eclipse.january.geometry.Triangle;
import org.eclipse.january.geometry.Vertex;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Geometry</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.impl.GeometryImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.impl.GeometryImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.impl.GeometryImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.impl.GeometryImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.impl.GeometryImpl#getTriangles <em>Triangles</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.impl.GeometryImpl#getCenter <em>Center</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.impl.GeometryImpl#getParent <em>Parent</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GeometryImpl extends MinimalEObjectImpl.Container
		implements Geometry {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final long ID_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected long id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<INode> nodes;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTriangles() <em>Triangles</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTriangles()
	 * @generated
	 * @ordered
	 */
	protected EList<Triangle> triangles;

	/**
	 * The cached value of the '{@link #getCenter() <em>Center</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCenter()
	 * @generated
	 * @ordered
	 */
	protected Vertex center;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected INode parent;

	/**
	 * The map of the shape's physical properties. Property names are mapped to
	 * their values.
	 * 
	 * @generated NOT
	 */
	protected HashMap<String, Double> properties;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected GeometryImpl() {
		super();

		// Initialize the properties
		properties = new HashMap<String, Double>();
		center = GeometryFactory.eINSTANCE.createVertex();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.GEOMETRY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.GEOMETRY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(long newId) {
		long oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.GEOMETRY__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<INode> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<INode>(INode.class, this, GeometryPackage.GEOMETRY__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.GEOMETRY__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Triangle> getTriangles() {
		if (triangles == null) {
			triangles = new EObjectContainmentEList<Triangle>(Triangle.class, this, GeometryPackage.GEOMETRY__TRIANGLES);
		}
		return triangles;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vertex getCenter() {
		if (center != null && center.eIsProxy()) {
			InternalEObject oldCenter = (InternalEObject)center;
			center = (Vertex)eResolveProxy(oldCenter);
			if (center != oldCenter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeometryPackage.GEOMETRY__CENTER, oldCenter, center));
			}
		}
		return center;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Vertex basicGetCenter() {
		return center;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCenter(Vertex newCenter) {
		Vertex oldCenter = center;
		center = newCenter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.GEOMETRY__CENTER, oldCenter, center));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public INode getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (INode)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeometryPackage.GEOMETRY__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public INode basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParent(INode newParent) {
		INode oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.GEOMETRY__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void changeDecoratorProperty(String property, Object value) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getPropertyNames() {
		//Return a list of the properties' keys.
		return new BasicEList<String>(properties.keySet());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getProperty(final String property) {
		return properties.get(property);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProperty(final String property, final double value) {
		properties.put(property, value);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void addNode(INode child) {

		// If the node is already in the list, fail silently
		if (!getNodes().contains(child)) {

			// Set the child's parent to this
			child.setParent(this);

			// Add the child to the list of nodes
			nodes.add(child);

			// Register to listen to each child
			child.eAdapters().add(new AdapterImpl() {

				@Override
				public void notifyChanged(Notification notification) {

					// Pass the notification along to own listeners
					eNotify(notification);
				}
			});
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void removeNode(INode child) {

		// If the node isn't in the list, fail silently
		if (getNodes().contains(child)) {

			// Remove this as the child's parent
			child.setParent(null);

			// Remove the child from the list of nodes
			nodes.remove(child);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void copy(Object source) {

		// Fail silently if the source is not a geometry
		if (source instanceof Geometry) {

			// Empty the list of nodes
			for (INode node : getNodes()) {
				removeNode(node);
			}

			// Add a clone of each of the other geometry's nodes
			for (INode node : ((Geometry) source).getNodes()) {
				addNode((INode) node.clone());
			}
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Object clone() {

		// Create another geometry
		Geometry clone = GeometryFactory.eINSTANCE.createGeometry();

		// Make the geometry a copy of this
		clone.copy(this);
		return clone;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeometryPackage.GEOMETRY__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case GeometryPackage.GEOMETRY__TRIANGLES:
				return ((InternalEList<?>)getTriangles()).basicRemove(otherEnd, msgs);
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
			case GeometryPackage.GEOMETRY__NAME:
				return getName();
			case GeometryPackage.GEOMETRY__ID:
				return getId();
			case GeometryPackage.GEOMETRY__NODES:
				return getNodes();
			case GeometryPackage.GEOMETRY__TYPE:
				return getType();
			case GeometryPackage.GEOMETRY__TRIANGLES:
				return getTriangles();
			case GeometryPackage.GEOMETRY__CENTER:
				if (resolve) return getCenter();
				return basicGetCenter();
			case GeometryPackage.GEOMETRY__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
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
			case GeometryPackage.GEOMETRY__NAME:
				setName((String)newValue);
				return;
			case GeometryPackage.GEOMETRY__ID:
				setId((Long)newValue);
				return;
			case GeometryPackage.GEOMETRY__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends INode>)newValue);
				return;
			case GeometryPackage.GEOMETRY__TYPE:
				setType((String)newValue);
				return;
			case GeometryPackage.GEOMETRY__TRIANGLES:
				getTriangles().clear();
				getTriangles().addAll((Collection<? extends Triangle>)newValue);
				return;
			case GeometryPackage.GEOMETRY__CENTER:
				setCenter((Vertex)newValue);
				return;
			case GeometryPackage.GEOMETRY__PARENT:
				setParent((INode)newValue);
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
			case GeometryPackage.GEOMETRY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GeometryPackage.GEOMETRY__ID:
				setId(ID_EDEFAULT);
				return;
			case GeometryPackage.GEOMETRY__NODES:
				getNodes().clear();
				return;
			case GeometryPackage.GEOMETRY__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case GeometryPackage.GEOMETRY__TRIANGLES:
				getTriangles().clear();
				return;
			case GeometryPackage.GEOMETRY__CENTER:
				setCenter((Vertex)null);
				return;
			case GeometryPackage.GEOMETRY__PARENT:
				setParent((INode)null);
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
			case GeometryPackage.GEOMETRY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GeometryPackage.GEOMETRY__ID:
				return id != ID_EDEFAULT;
			case GeometryPackage.GEOMETRY__NODES:
				return nodes != null && !nodes.isEmpty();
			case GeometryPackage.GEOMETRY__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case GeometryPackage.GEOMETRY__TRIANGLES:
				return triangles != null && !triangles.isEmpty();
			case GeometryPackage.GEOMETRY__CENTER:
				return center != null;
			case GeometryPackage.GEOMETRY__PARENT:
				return parent != null;
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
			case GeometryPackage.GEOMETRY___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT:
				changeDecoratorProperty((String)arguments.get(0), arguments.get(1));
				return null;
			case GeometryPackage.GEOMETRY___GET_PROPERTY_NAMES:
				return getPropertyNames();
			case GeometryPackage.GEOMETRY___GET_PROPERTY__STRING:
				return getProperty((String)arguments.get(0));
			case GeometryPackage.GEOMETRY___SET_PROPERTY__STRING_DOUBLE:
				setProperty((String)arguments.get(0), (Double)arguments.get(1));
				return null;
			case GeometryPackage.GEOMETRY___ADD_NODE__INODE:
				addNode((INode)arguments.get(0));
				return null;
			case GeometryPackage.GEOMETRY___REMOVE_NODE__INODE:
				removeNode((INode)arguments.get(0));
				return null;
			case GeometryPackage.GEOMETRY___COPY__OBJECT:
				copy(arguments.get(0));
				return null;
			case GeometryPackage.GEOMETRY___CLONE:
				return clone();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", id: ");
		result.append(id);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} // GeometryImpl
