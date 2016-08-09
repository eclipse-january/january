/**
 */
package org.eclipse.january.geometry.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;

import org.eclipse.emf.common.notify.Adapter;
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
import org.eclipse.january.geometry.Geometry;
import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.january.geometry.INode;
import org.eclipse.january.geometry.Triangle;
import org.eclipse.january.geometry.Vertex;
import org.eclipse.january.geometry.VertexSource;
import org.eclipse.swt.widgets.Display;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Geometry</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.january.geometry.impl.GeometryImpl#getName
 * <em>Name</em>}</li>
 * <li>{@link org.eclipse.january.geometry.impl.GeometryImpl#getId
 * <em>Id</em>}</li>
 * <li>{@link org.eclipse.january.geometry.impl.GeometryImpl#getNodes
 * <em>Nodes</em>}</li>
 * <li>{@link org.eclipse.january.geometry.impl.GeometryImpl#getType
 * <em>Type</em>}</li>
 * <li>{@link org.eclipse.january.geometry.impl.GeometryImpl#getTriangles
 * <em>Triangles</em>}</li>
 * <li>{@link org.eclipse.january.geometry.impl.GeometryImpl#getCenter
 * <em>Center</em>}</li>
 * <li>{@link org.eclipse.january.geometry.impl.GeometryImpl#getParent
 * <em>Parent</em>}</li>
 * <li>{@link org.eclipse.january.geometry.impl.GeometryImpl#getVertexSources
 * <em>Vertex Sources</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GeometryImpl extends MinimalEObjectImpl.Container
		implements Geometry {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<INode> nodes;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTriangles() <em>Triangles</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTriangles()
	 * @generated
	 * @ordered
	 */
	protected EList<Triangle> triangles;

	/**
	 * The cached value of the '{@link #getCenter() <em>Center</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCenter()
	 * @generated
	 * @ordered
	 */
	protected Vertex center;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected INode parent;

	/**
	 * The cached value of the '{@link #getVertexSources() <em>Vertex
	 * Sources</em>}' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getVertexSources()
	 * @generated
	 * @ordered
	 */
	protected EList<VertexSource> vertexSources;

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
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.GEOMETRY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeometryPackage.GEOMETRY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public long getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setId(long newId) {
		long oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeometryPackage.GEOMETRY__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<INode> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<INode>(INode.class, this,
					GeometryPackage.GEOMETRY__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeometryPackage.GEOMETRY__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<Triangle> getTriangles() {
		if (triangles == null) {
			triangles = new EObjectContainmentEList<Triangle>(Triangle.class,
					this, GeometryPackage.GEOMETRY__TRIANGLES);
		}
		return triangles;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Vertex getCenter() {
		if (center != null && center.eIsProxy()) {
			InternalEObject oldCenter = (InternalEObject) center;
			center = (Vertex) eResolveProxy(oldCenter);
			if (center != oldCenter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							GeometryPackage.GEOMETRY__CENTER, oldCenter,
							center));
			}
		}
		return center;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Vertex basicGetCenter() {
		return center;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setCenter(Vertex newCenter) {
		Vertex oldCenter = center;
		center = newCenter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeometryPackage.GEOMETRY__CENTER, oldCenter, center));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public INode getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject) parent;
			parent = (INode) eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							GeometryPackage.GEOMETRY__PARENT, oldParent,
							parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public INode basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setParent(INode newParent) {
		INode oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeometryPackage.GEOMETRY__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<VertexSource> getVertexSources() {
		if (vertexSources == null) {
			vertexSources = new EObjectContainmentEList<VertexSource>(
					VertexSource.class, this,
					GeometryPackage.GEOMETRY__VERTEX_SOURCES);
		}
		return vertexSources;
	}

	/**
	 * Gets the vertex source that results from combining all of the vertex
	 * sources. Note that this call will replace those other sources with this
	 * one large source, even in the vertex sources list. If there is no vertex
	 * source set, returns an empty one
	 * 
	 * @return VertexSource The large vertex source
	 */
	@Override
	public VertexSource getVertexSource() {
		// If no sources, return null
		if (getVertexSources().size() < 1) {
			return null;
			// If there is only one, return that
		} else if (vertexSources.size() == 1) {
			return vertexSources.get(0);
			// Return the combination of all the vertex sources in the list
		} else {
			// Create a new source
			VertexSource source = GeometryFactory.eINSTANCE
					.createVertexSource();
			EList<Vertex> sourceVert = source.getVertices();
			// Go through each vertex source's vertices
			for (int i = 0; i < vertexSources.size(); i++) {
				// Add that vertex
				for (Vertex v : vertexSources.get(i).getVertices()) {
					sourceVert.add((Vertex) v.clone());
				}

				source.getMaterialFiles()
						.addAll(vertexSources.get(i).getMaterialFiles());
				// Clear the now unused vertices
				vertexSources.get(i).getVertices().clear();
			}
			// Add the resulting vertex source to the list, and clear the rest
			vertexSources.clear();
			vertexSources.add(source);
			// Finally, return the new vertex source
			return source;
		}

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
	 * @generated
	 */
	@Override
	public EList<String> getPropertyNames() {
		// Return a list of the properties' keys.
		return new BasicEList<String>(properties.keySet());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public double getProperty(final String property) {
		return properties.get(property);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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

		// If the node is already in the list or is null, fail silently
		if (child != null && !getNodes().contains(child)) {

			// Set the child's parent to this
			child.setParent(this);

			// Add the child to the list of nodes
			nodes.add(child);
		}
	}

	@Override
	public void addNodes(EList<INode> children) {
		for (INode node : children) {
			addNode(node);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void removeNode(INode child) {

		// If the node is null, fail silently
		if (child != null) {

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

		// If the source object is not aa shape, fail silently
		if (source instanceof Geometry) {

			// Cast the object as an operator
			Geometry castSource = (Geometry) source;

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
				setProperty(property, castSource.getProperty(property));
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
				getTriangles().add(cloneTriangle);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * 
	 * @generated NOT
	 */
	@Override
	public boolean equals(Object otherObject) {

		// The other object must be a geometry
		if (otherObject instanceof Geometry) {
			Geometry otherGeometry = (Geometry) otherObject;

			// If any of the data members are different, they are unequal
			if (name == otherGeometry.getName() && id == otherGeometry.getId()
					&& type == otherGeometry.getType()) {

				// The triangles from the other geometry
				EList<Triangle> otherTriangles = otherGeometry.getTriangles();

				// Check that the triangles lists are equal. We may ignore the
				// VertexSources and assume that if two objects have the same
				// triangles the source for the data may be disregarded.
				if (getTriangles().size() == otherTriangles.size()) {

					// Check that the other list contains every triangle in this
					// one. Since they are the same length, this will mean the
					// triangles are identical
					for (Triangle triangle : triangles) {

						// Whether a matching triangle has been found
						boolean found = false;

						// Search for an identical triangle
						for (Triangle otherTriangle : otherTriangles) {
							if (triangle.equals(otherTriangle)) {
								found = true;
								break;
							}
						}

						// If the triangle is not in the other object, they are
						// not equal
						if (!found) {
							return false;
						}
					}

					// Check that the centers are equal
					if (getCenter().equals(otherGeometry.getCenter())) {

						// The properties for both geometries
						EList<String> props = getPropertyNames();
						EList<String> otherProps = otherGeometry
								.getPropertyNames();

						// Check that there are identical numbers of properties
						// and that each property in one object equals the value
						// for the other
						if (props.size() == otherProps.size()) {
							for (String property : props) {
								if (!otherProps.contains(property)
										|| getProperty(
												property) != otherGeometry
														.getProperty(
																property)) {
									return false;
								}
							}

							// The lists of child nodes
							EList<INode> ownNodes = getNodes();
							EList<INode> otherNodes = otherGeometry.getNodes();

							// Check that the lists of children contain the same
							// values
							if (ownNodes.size() == otherNodes.size()) {
								for (INode node : ownNodes) {

									// Whether a match has been found
									boolean found = false;

									// Check to see if the node equals any other
									// the other object's
									for (INode otherNode : otherNodes) {
										if (node.equals(otherNode)) {
											found = true;
											break;
										}
									}

									// If the node was not in the other list,
									// the objects are not equal
									if (!found) {
										return false;
									}
								}

								// All tests passed, so the objects must be
								// equal
								return true;
							}
						}
					}
				}
			}
		}

		// One of the tests failed, so they are not equal
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 * 
	 * @generated NOT
	 */
	@Override
	public int hashCode() {

		int hashCode = 31;

		// Add the hashes for each data member
		hashCode = 31 * hashCode + getName().hashCode();
		hashCode = 31 * hashCode;
		hashCode += getId();
		hashCode = hashCode * 31 + getType().hashCode();
		hashCode = 31 * hashCode + getCenter().hashCode();
		hashCode = 31 * hashCode + properties.hashCode();

		// Add the hash for each node
		int nodesHash = 0;
		for (INode node : getNodes()) {
			nodesHash += node.hashCode();
		}
		hashCode += 31 * hashCode + nodesHash;

		// Add the hash for each triangle
		int trianglesHash = 0;
		for (Triangle triangle : getTriangles()) {
			trianglesHash += triangle.hashCode();
		}
		hashCode += 31 * hashCode + trianglesHash;

		return hashCode;

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case GeometryPackage.GEOMETRY__NODES:
			return ((InternalEList<?>) getNodes()).basicRemove(otherEnd, msgs);
		case GeometryPackage.GEOMETRY__TRIANGLES:
			return ((InternalEList<?>) getTriangles()).basicRemove(otherEnd,
					msgs);
		case GeometryPackage.GEOMETRY__VERTEX_SOURCES:
			return ((InternalEList<?>) getVertexSources()).basicRemove(otherEnd,
					msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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
			if (resolve)
				return getCenter();
			return basicGetCenter();
		case GeometryPackage.GEOMETRY__PARENT:
			if (resolve)
				return getParent();
			return basicGetParent();
		case GeometryPackage.GEOMETRY__VERTEX_SOURCES:
			return getVertexSources();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case GeometryPackage.GEOMETRY__NAME:
			setName((String) newValue);
			return;
		case GeometryPackage.GEOMETRY__ID:
			setId((Long) newValue);
			return;
		case GeometryPackage.GEOMETRY__NODES:
			getNodes().clear();
			getNodes().addAll((Collection<? extends INode>) newValue);
			return;
		case GeometryPackage.GEOMETRY__TYPE:
			setType((String) newValue);
			return;
		case GeometryPackage.GEOMETRY__TRIANGLES:
			getTriangles().clear();
			getTriangles().addAll((Collection<? extends Triangle>) newValue);
			return;
		case GeometryPackage.GEOMETRY__CENTER:
			setCenter((Vertex) newValue);
			return;
		case GeometryPackage.GEOMETRY__PARENT:
			setParent((INode) newValue);
			return;
		case GeometryPackage.GEOMETRY__VERTEX_SOURCES:
			getVertexSources().clear();
			getVertexSources()
					.addAll((Collection<? extends VertexSource>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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
			setCenter((Vertex) null);
			return;
		case GeometryPackage.GEOMETRY__PARENT:
			setParent((INode) null);
			return;
		case GeometryPackage.GEOMETRY__VERTEX_SOURCES:
			getVertexSources().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case GeometryPackage.GEOMETRY__NAME:
			return NAME_EDEFAULT == null ? name != null
					: !NAME_EDEFAULT.equals(name);
		case GeometryPackage.GEOMETRY__ID:
			return id != ID_EDEFAULT;
		case GeometryPackage.GEOMETRY__NODES:
			return nodes != null && !nodes.isEmpty();
		case GeometryPackage.GEOMETRY__TYPE:
			return TYPE_EDEFAULT == null ? type != null
					: !TYPE_EDEFAULT.equals(type);
		case GeometryPackage.GEOMETRY__TRIANGLES:
			return triangles != null && !triangles.isEmpty();
		case GeometryPackage.GEOMETRY__CENTER:
			return center != null;
		case GeometryPackage.GEOMETRY__PARENT:
			return parent != null;
		case GeometryPackage.GEOMETRY__VERTEX_SOURCES:
			return vertexSources != null && !vertexSources.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID) {
		case GeometryPackage.GEOMETRY___CHANGE_DECORATOR_PROPERTY__STRING_OBJECT:
			changeDecoratorProperty((String) arguments.get(0),
					arguments.get(1));
			return null;
		case GeometryPackage.GEOMETRY___GET_PROPERTY_NAMES:
			return getPropertyNames();
		case GeometryPackage.GEOMETRY___GET_PROPERTY__STRING:
			return getProperty((String) arguments.get(0));
		case GeometryPackage.GEOMETRY___SET_PROPERTY__STRING_DOUBLE:
			setProperty((String) arguments.get(0), (Double) arguments.get(1));
			return null;
		case GeometryPackage.GEOMETRY___ADD_NODE__INODE:
			addNode((INode) arguments.get(0));
			return null;
		case GeometryPackage.GEOMETRY___REMOVE_NODE__INODE:
			removeNode((INode) arguments.get(0));
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
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.common.notify.impl.BasicNotifierImpl#eNotify(org.eclipse.
	 * emf.common.notify.Notification)
	 */
	@Override
	public void eNotify(Notification notification) {
		// Check if a notification is required
		Adapter[] eAdapters = eBasicAdapterArray();
		if (eAdapters != null && eDeliver()) {

			// If this notification is on the UI thread, launch a new thread to
			// handle it
			Display currDisplay = Display.getCurrent();
			if (currDisplay != null
					&& Thread.currentThread() == currDisplay.getThread()) {

				Thread updateThread = new Thread() {

					@Override
					public void run() {
						for (int i = 0, size = eAdapters.length; i < size; ++i) {
							eAdapters[i].notifyChanged(notification);
						}
					}
				};

				updateThread.run();

			}

			// If we are already off the UI thread, such as being called by a
			// thread created by some other object's eNotify(), then just notify
			// the adapters.
			else {
				for (int i = 0, size = eAdapters.length; i < size; ++i) {
					eAdapters[i].notifyChanged(notification);
				}
			}
		}
	}
} // GeometryImpl
