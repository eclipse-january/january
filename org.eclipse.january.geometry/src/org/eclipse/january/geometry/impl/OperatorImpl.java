/**
 */
package org.eclipse.january.geometry.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.january.geometry.INode;
import org.eclipse.january.geometry.Operator;
import org.eclipse.january.geometry.Triangle;
import org.eclipse.january.geometry.Vertex;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Operator</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.impl.OperatorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.impl.OperatorImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.impl.OperatorImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.impl.OperatorImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.impl.OperatorImpl#getTriangles <em>Triangles</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.impl.OperatorImpl#getCenter <em>Center</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.impl.OperatorImpl#getParent <em>Parent</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperatorImpl extends MinimalEObjectImpl.Container
		implements Operator {
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
	 * The map of the operator's physical properties. Property names are mapped
	 * to their values.
	 * 
	 * @generated NOT
	 */
	protected HashMap<String, Double> properties;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected OperatorImpl() {
		super();

		// Initialize the data members
		properties = new HashMap<String, Double>();
		center = GeometryFactory.eINSTANCE.createVertex();
		setProperty("scale", 1.0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.OPERATOR;
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.OPERATOR__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.OPERATOR__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<INode> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<INode>(INode.class, this, GeometryPackage.OPERATOR__NODES);
		}
		return nodes;
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public void addNodes(EList<INode> children) {
		for (INode node : children) {
			addNode(node);
		}
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.OPERATOR__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Triangle> getTriangles() {
		if (triangles == null) {
			triangles = new EObjectContainmentEList<Triangle>(Triangle.class, this, GeometryPackage.OPERATOR__TRIANGLES);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeometryPackage.OPERATOR__CENTER, oldCenter, center));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.OPERATOR__CENTER, oldCenter, center));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeometryPackage.OPERATOR__PARENT, oldParent, parent));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.OPERATOR__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void changeDecoratorProperty(String property, Object value) {

		// Send a notification for the shape's set property method with the
		// property name placed instead of the previous value. By convention,
		// decorator classes will be set to interpret this non-standard
		// notification message correctly and other listeners will ignore it.
		eNotify(new ENotificationImpl(this, Notification.SET,
				GeometryPackage.INODE___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT,
				property, value));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public EList<String> getPropertyNames() {

		// Return a list of the properties' keys.
		return new BasicEList<String>(properties.keySet());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public double getProperty(final String property) {
		return properties.get(property);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setProperty(final String property, final double value) {
		properties.put(property, value);
		
		if (property.equals("scale")) {
			for(INode node : getNodes()) {
				if (node instanceof ShapeImpl) {
					node.setProperty(property, value);
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
	public void addNode(INode child) {

		// If the node is already in the list, fail silently
		if (!getNodes().contains(child)) {

			// Set the child's parent to this
			child.setParent(this);

			// Add the child to the list of nodes
			nodes.add(child);
		}

		// Send a notification
		eNotify(new ENotificationImpl(this, Notification.ADD,
				GeometryPackage.INODE___ADD_NODE__INODE, null, child));
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

			// Send a notification
			eNotify(new ENotificationImpl(this, Notification.REMOVE,
					GeometryPackage.OPERATOR___REMOVE_NODE__INODE, child,
					child));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void copy(Object source) {

		// If the source object is not an Operator, fail silently
		if (source instanceof Operator) {

			// Cast the object as an operator
			Operator castSource = (Operator) source;

			// Copy the object's center
			getCenter().setX(castSource.getCenter().getX());
			center.setY(castSource.getCenter().getY());
			center.setZ(castSource.getCenter().getZ());

			// Copy the object's data members
			id = castSource.getId();
			name = castSource.getName();
			type = castSource.getType();

			// Clear the list of child nodes
			for (INode node : getNodes()) {
				removeNode(node);
			}

			// Add clones of each of the source's nodes
			for (INode node : castSource.getNodes()) {
				addNode((INode) node.clone());
			}

			// Make the properties map a copy of the source's
			properties.clear();
			for (String property : castSource.getPropertyNames()) {
				properties.put(property, castSource.getProperty(property));
			}

			// Copy the triangles from the source
			getTriangles().clear();
			for (Triangle triangle : castSource.getTriangles()) {

				// Create a new triangle
				Triangle cloneTriangle = GeometryFactory.eINSTANCE
						.createTriangle();

				// Create a copy of each vertex from the current triangle and
				// add it to the clone under construction
				for (Vertex vertex : triangle.getVertices()) {

					Vertex cloneVertex = GeometryFactory.eINSTANCE
							.createVertex();
					cloneVertex.setX(vertex.getX());
					cloneVertex.setY(vertex.getY());
					cloneVertex.setZ(vertex.getZ());

					cloneTriangle.getVertices().add(cloneVertex);
				}

				// Make the normal vector a copy of the source triangle's
				cloneTriangle.getNormal().setX(triangle.getNormal().getX());
				cloneTriangle.getNormal().setY(triangle.getNormal().getY());
				cloneTriangle.getNormal().setZ(triangle.getNormal().getZ());
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

		// Create a new operator
		Operator clone = GeometryFactory.eINSTANCE.createOperator();

		// Make it a copy of this
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
			case GeometryPackage.OPERATOR__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case GeometryPackage.OPERATOR__TRIANGLES:
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
			case GeometryPackage.OPERATOR__NAME:
				return getName();
			case GeometryPackage.OPERATOR__ID:
				return getId();
			case GeometryPackage.OPERATOR__NODES:
				return getNodes();
			case GeometryPackage.OPERATOR__TYPE:
				return getType();
			case GeometryPackage.OPERATOR__TRIANGLES:
				return getTriangles();
			case GeometryPackage.OPERATOR__CENTER:
				if (resolve) return getCenter();
				return basicGetCenter();
			case GeometryPackage.OPERATOR__PARENT:
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
			case GeometryPackage.OPERATOR__NAME:
				setName((String)newValue);
				return;
			case GeometryPackage.OPERATOR__ID:
				setId((Long)newValue);
				return;
			case GeometryPackage.OPERATOR__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends INode>)newValue);
				return;
			case GeometryPackage.OPERATOR__TYPE:
				setType((String)newValue);
				return;
			case GeometryPackage.OPERATOR__TRIANGLES:
				getTriangles().clear();
				getTriangles().addAll((Collection<? extends Triangle>)newValue);
				return;
			case GeometryPackage.OPERATOR__CENTER:
				setCenter((Vertex)newValue);
				return;
			case GeometryPackage.OPERATOR__PARENT:
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
			case GeometryPackage.OPERATOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GeometryPackage.OPERATOR__ID:
				setId(ID_EDEFAULT);
				return;
			case GeometryPackage.OPERATOR__NODES:
				getNodes().clear();
				return;
			case GeometryPackage.OPERATOR__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case GeometryPackage.OPERATOR__TRIANGLES:
				getTriangles().clear();
				return;
			case GeometryPackage.OPERATOR__CENTER:
				setCenter((Vertex)null);
				return;
			case GeometryPackage.OPERATOR__PARENT:
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
			case GeometryPackage.OPERATOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GeometryPackage.OPERATOR__ID:
				return id != ID_EDEFAULT;
			case GeometryPackage.OPERATOR__NODES:
				return nodes != null && !nodes.isEmpty();
			case GeometryPackage.OPERATOR__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case GeometryPackage.OPERATOR__TRIANGLES:
				return triangles != null && !triangles.isEmpty();
			case GeometryPackage.OPERATOR__CENTER:
				return center != null;
			case GeometryPackage.OPERATOR__PARENT:
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
			case GeometryPackage.OPERATOR___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT:
				changeDecoratorProperty((String)arguments.get(0), arguments.get(1));
				return null;
			case GeometryPackage.OPERATOR___GET_PROPERTY_NAMES:
				return getPropertyNames();
			case GeometryPackage.OPERATOR___GET_PROPERTY__STRING:
				return getProperty((String)arguments.get(0));
			case GeometryPackage.OPERATOR___SET_PROPERTY__STRING_DOUBLE:
				setProperty((String)arguments.get(0), (Double)arguments.get(1));
				return null;
			case GeometryPackage.OPERATOR___ADD_NODE__INODE:
				addNode((INode)arguments.get(0));
				return null;
			case GeometryPackage.OPERATOR___REMOVE_NODE__INODE:
				removeNode((INode)arguments.get(0));
				return null;
			case GeometryPackage.OPERATOR___COPY__OBJECT:
				copy(arguments.get(0));
				return null;
			case GeometryPackage.OPERATOR___CLONE:
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

} // OperatorImpl
