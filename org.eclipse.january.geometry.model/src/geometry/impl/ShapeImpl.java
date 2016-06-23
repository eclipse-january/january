/**
 */
package geometry.impl;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import geometry.GeometryPackage;
import geometry.INode;
import geometry.Material;
import geometry.Shape;
import geometry.Triangle;
import geometry.Vertex;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Shape</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link geometry.impl.ShapeImpl#getName <em>Name</em>}</li>
 *   <li>{@link geometry.impl.ShapeImpl#getId <em>Id</em>}</li>
 *   <li>{@link geometry.impl.ShapeImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link geometry.impl.ShapeImpl#getType <em>Type</em>}</li>
 *   <li>{@link geometry.impl.ShapeImpl#getTriangles <em>Triangles</em>}</li>
 *   <li>{@link geometry.impl.ShapeImpl#getCenter <em>Center</em>}</li>
 *   <li>{@link geometry.impl.ShapeImpl#getMaterial <em>Material</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ShapeImpl extends MinimalEObjectImpl.Container implements Shape {
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
	 * The cached value of the '{@link #getMaterial() <em>Material</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMaterial()
	 * @generated
	 * @ordered
	 */
	protected Material material;

	/**
	 * Logger for handling event messages and other information.
	 * 
	 * @generated NOT
	 */
	protected static final Logger logger = LoggerFactory
			.getLogger(ShapeImpl.class);

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
	protected ShapeImpl() {
		super();

		// Instantiate the type to "shape" by default, marking the shape as one
		// which will export its information to the MeshCache as a set of
		// triangles.
		type = "shape";
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.SHAPE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.SHAPE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.SHAPE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<INode> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<INode>(INode.class, this, GeometryPackage.SHAPE__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Triangle> getTriangles() {
		if (triangles == null) {
			triangles = new EObjectContainmentEList<Triangle>(Triangle.class, this, GeometryPackage.SHAPE__TRIANGLES);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeometryPackage.SHAPE__CENTER, oldCenter, center));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.SHAPE__CENTER, oldCenter, center));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.SHAPE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Material getMaterial() {
		return material;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMaterial(Material newMaterial,
			NotificationChain msgs) {
		Material oldMaterial = material;
		material = newMaterial;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeometryPackage.SHAPE__MATERIAL, oldMaterial, newMaterial);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaterial(Material newMaterial) {
		if (newMaterial != material) {
			NotificationChain msgs = null;
			if (material != null)
				msgs = ((InternalEObject)material).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeometryPackage.SHAPE__MATERIAL, null, msgs);
			if (newMaterial != null)
				msgs = ((InternalEObject)newMaterial).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeometryPackage.SHAPE__MATERIAL, null, msgs);
			msgs = basicSetMaterial(newMaterial, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.SHAPE__MATERIAL, newMaterial, newMaterial));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public double getProperty(String property) {
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
	public void changeDecoratorProperty(String property, Object value) {

		// Send a notification for the shape's set property method with the
		// property name placed instead of the previous value. By convention,
		// decorator classes will be set to interpret this non-standard
		// notification message correctly and other listeners will ignore it.
		eNotify(new ENotificationImpl(this, Notification.SET,
				GeometryPackage.SHAPE___SET_PROPERTY__STRING_DOUBLE, property,
				value));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeometryPackage.SHAPE__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case GeometryPackage.SHAPE__TRIANGLES:
				return ((InternalEList<?>)getTriangles()).basicRemove(otherEnd, msgs);
			case GeometryPackage.SHAPE__MATERIAL:
				return basicSetMaterial(null, msgs);
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
			case GeometryPackage.SHAPE__NAME:
				return getName();
			case GeometryPackage.SHAPE__ID:
				return getId();
			case GeometryPackage.SHAPE__NODES:
				return getNodes();
			case GeometryPackage.SHAPE__TYPE:
				return getType();
			case GeometryPackage.SHAPE__TRIANGLES:
				return getTriangles();
			case GeometryPackage.SHAPE__CENTER:
				if (resolve) return getCenter();
				return basicGetCenter();
			case GeometryPackage.SHAPE__MATERIAL:
				return getMaterial();
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
			case GeometryPackage.SHAPE__NAME:
				setName((String)newValue);
				return;
			case GeometryPackage.SHAPE__ID:
				setId((Long)newValue);
				return;
			case GeometryPackage.SHAPE__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends INode>)newValue);
				return;
			case GeometryPackage.SHAPE__TYPE:
				setType((String)newValue);
				return;
			case GeometryPackage.SHAPE__TRIANGLES:
				getTriangles().clear();
				getTriangles().addAll((Collection<? extends Triangle>)newValue);
				return;
			case GeometryPackage.SHAPE__CENTER:
				setCenter((Vertex)newValue);
				return;
			case GeometryPackage.SHAPE__MATERIAL:
				setMaterial((Material)newValue);
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
			case GeometryPackage.SHAPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GeometryPackage.SHAPE__ID:
				setId(ID_EDEFAULT);
				return;
			case GeometryPackage.SHAPE__NODES:
				getNodes().clear();
				return;
			case GeometryPackage.SHAPE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case GeometryPackage.SHAPE__TRIANGLES:
				getTriangles().clear();
				return;
			case GeometryPackage.SHAPE__CENTER:
				setCenter((Vertex)null);
				return;
			case GeometryPackage.SHAPE__MATERIAL:
				setMaterial((Material)null);
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
			case GeometryPackage.SHAPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GeometryPackage.SHAPE__ID:
				return id != ID_EDEFAULT;
			case GeometryPackage.SHAPE__NODES:
				return nodes != null && !nodes.isEmpty();
			case GeometryPackage.SHAPE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case GeometryPackage.SHAPE__TRIANGLES:
				return triangles != null && !triangles.isEmpty();
			case GeometryPackage.SHAPE__CENTER:
				return center != null;
			case GeometryPackage.SHAPE__MATERIAL:
				return material != null;
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
			case GeometryPackage.SHAPE___SET_PROPERTY__STRING_DOUBLE:
				setProperty((String)arguments.get(0), (Double)arguments.get(1));
				return null;
			case GeometryPackage.SHAPE___GET_PROPERTY__STRING:
				return getProperty((String)arguments.get(0));
			case GeometryPackage.SHAPE___GET_PROPERTY_NAMES:
				return getPropertyNames();
			case GeometryPackage.SHAPE___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT:
				changeDecoratorProperty((String)arguments.get(0), arguments.get(1));
				return null;
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

} // ShapeImpl
