/**
 */
package org.eclipse.january.geometry.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.january.geometry.Face;
import org.eclipse.january.geometry.Geometry;
import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.january.geometry.INode;
import org.eclipse.january.geometry.PolyShape;
import org.eclipse.january.geometry.Triangle;
import org.eclipse.january.geometry.Vertex;
import org.eclipse.january.geometry.VertexSource;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Poly
 * Shape</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.impl.PolyShapeImpl#getFaces <em>Faces</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.impl.PolyShapeImpl#getVertexSource <em>Vertex Source</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.impl.PolyShapeImpl#getMaterialFiles <em>Material Files</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PolyShapeImpl extends ShapeImpl implements PolyShape {
	/**
	 * The cached value of the '{@link #getFaces() <em>Faces</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFaces()
	 * @generated
	 * @ordered
	 */
	protected EList<Face> faces;

	/**
	 * The cached value of the '{@link #getVertexSource() <em>Vertex Source</em>}' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getVertexSource()
	 * @generated
	 * @ordered
	 */
	protected VertexSource vertexSource;

	/**
	 * The cached value of the '{@link #getMaterialFiles() <em>Material
	 * Files</em>}' attribute list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getMaterialFiles()
	 * @generated
	 * @ordered
	 */
	protected EList<String> materialFiles;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PolyShapeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.POLY_SHAPE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Face> getFaces() {
		if (faces == null) {
			faces = new EObjectContainmentEList<Face>(Face.class, this, GeometryPackage.POLY_SHAPE__FACES);
		}
		return faces;
	}

	/**
	 * Calculates the triangles from the faces given
	 * 
	 * @generated NOT
	 */
	@Override
	public void calculatePolyTriangles() {
		if (getMaterial() != null) {
			getMaterial().getMaterialFiles()
					.addAll(getVertexSource().getMaterialFiles());
		}
		
		//Check whether indices are specified in 0 or 1 indexing
		boolean oneIndexing = true;
		
		for(Face face : getFaces()){
			if(face.getVertexIndices().contains(0)){
				oneIndexing = false;
				break;
			}
		}
		
		for (Face face : getFaces()) {
			EList<Integer> indices = face.getVertexIndices();
			if (indices.size() > 2) {
				for (int i = 1; i < indices.size() - 1; i++) {
					
					//Get the indices into the vertex array
					int index1 = indices.get(0);
					int index2 = indices.get(i);
					int index3 = indices.get(i + 1);
					
					//If the indices are in one indexing, convert to zero indexing
					if(oneIndexing){
						index1--;
						index2--;
						index3--;
					}
					
					Vertex v1 = getVertexSource().getVertices()
							.get(index1);
					Vertex v2 = getVertexSource().getVertices()
							.get(index2);
					Vertex v3 = getVertexSource().getVertices()
							.get(index3);
					ComplexTriangle tri = new ComplexTriangle(v1, v2, v3);

					// Listen to the triangle, passing along any notifications.
					tri.eAdapters().add(new AdapterImpl() {

						@Override
						public void notifyChanged(Notification notification) {
							eNotify(notification);
						}

					});
					getTriangles().add(tri);
				}
			} else {
				// Throw an exception- file is not properly specified
			}
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public VertexSource getVertexSource() {
		if (parent != null && parent instanceof Geometry) {
			return ((Geometry) parent).getVertexSource();
		} else {
			return vertexSource;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVertexSource(VertexSource newVertexSource,
			NotificationChain msgs) {
		VertexSource oldVertexSource = vertexSource;
		vertexSource = newVertexSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeometryPackage.POLY_SHAPE__VERTEX_SOURCE, oldVertexSource, newVertexSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVertexSource(VertexSource newVertexSource) {
		if (newVertexSource != vertexSource) {
			NotificationChain msgs = null;
			if (vertexSource != null)
				msgs = ((InternalEObject)vertexSource).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeometryPackage.POLY_SHAPE__VERTEX_SOURCE, null, msgs);
			if (newVertexSource != null)
				msgs = ((InternalEObject)newVertexSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeometryPackage.POLY_SHAPE__VERTEX_SOURCE, null, msgs);
			msgs = basicSetVertexSource(newVertexSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.POLY_SHAPE__VERTEX_SOURCE, newVertexSource, newVertexSource));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Object clone() {

		// Create a new shape
		PolyShape clone = GeometryFactory.eINSTANCE.createPolyShape();

		// Make it a copy of this
		clone.copy(this);
		return clone;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void copy(Object source) {

		// If the source object is not aa shape, fail silently
		if (source instanceof PolyShape) {

			// Cast the object as an operator
			PolyShape castSource = (PolyShape) source;

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

			// Clear the current list of triangles
			triangles = new BasicEList<Triangle>();

			// Copy the faces
			faces = new BasicEList<Face>();
			for (Face face : castSource.getFaces()) {

				// Construct a new face with all the same coordinates and add it
				// to the list
				Face newFace = GeometryFactory.eINSTANCE.createFace();
				newFace.getTextureIndices().addAll(face.getTextureIndices());
				newFace.getVertexIndices().addAll(face.getVertexIndices());

				faces.add(newFace);
			}

			// Copy the vertex source
			vertexSource = castSource.getVertexSource();

			// calculate the new polygons now that evertrhing is set up.
			calculatePolyTriangles();
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getMaterialFiles() {
		if (materialFiles == null) {
			materialFiles = new EDataTypeUniqueEList<String>(String.class, this, GeometryPackage.POLY_SHAPE__MATERIAL_FILES);
		}
		return materialFiles;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeometryPackage.POLY_SHAPE__FACES:
				return ((InternalEList<?>)getFaces()).basicRemove(otherEnd, msgs);
			case GeometryPackage.POLY_SHAPE__VERTEX_SOURCE:
				return basicSetVertexSource(null, msgs);
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
			case GeometryPackage.POLY_SHAPE__FACES:
				return getFaces();
			case GeometryPackage.POLY_SHAPE__VERTEX_SOURCE:
				return getVertexSource();
			case GeometryPackage.POLY_SHAPE__MATERIAL_FILES:
				return getMaterialFiles();
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
			case GeometryPackage.POLY_SHAPE__FACES:
				getFaces().clear();
				getFaces().addAll((Collection<? extends Face>)newValue);
				return;
			case GeometryPackage.POLY_SHAPE__VERTEX_SOURCE:
				setVertexSource((VertexSource)newValue);
				return;
			case GeometryPackage.POLY_SHAPE__MATERIAL_FILES:
				getMaterialFiles().clear();
				getMaterialFiles().addAll((Collection<? extends String>)newValue);
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
			case GeometryPackage.POLY_SHAPE__FACES:
				getFaces().clear();
				return;
			case GeometryPackage.POLY_SHAPE__VERTEX_SOURCE:
				setVertexSource((VertexSource)null);
				return;
			case GeometryPackage.POLY_SHAPE__MATERIAL_FILES:
				getMaterialFiles().clear();
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
			case GeometryPackage.POLY_SHAPE__FACES:
				return faces != null && !faces.isEmpty();
			case GeometryPackage.POLY_SHAPE__VERTEX_SOURCE:
				return vertexSource != null;
			case GeometryPackage.POLY_SHAPE__MATERIAL_FILES:
				return materialFiles != null && !materialFiles.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (materialFiles: ");
		result.append(materialFiles);
		result.append(')');
		return result.toString();
	}

} // PolyShapeImpl
