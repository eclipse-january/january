/**
 */
package org.eclipse.january.geometry.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.january.geometry.Vertex;
import org.eclipse.january.geometry.VertexSource;
import org.eclipse.swt.widgets.Display;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Vertex
 * Source</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.january.geometry.impl.VertexSourceImpl#getVertices
 * <em>Vertices</em>}</li>
 * <li>{@link org.eclipse.january.geometry.impl.VertexSourceImpl#getTextureCoordinates
 * <em>Texture Coordinates</em>}</li>
 * <li>{@link org.eclipse.january.geometry.impl.VertexSourceImpl#getMaterialFiles
 * <em>Material Files</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VertexSourceImpl extends MinimalEObjectImpl.Container
		implements VertexSource {
	/**
	 * The cached value of the '{@link #getVertices() <em>Vertices</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getVertices()
	 * @generated
	 * @ordered
	 */
	protected EList<Vertex> vertices;

	/**
	 * The cached value of the '{@link #getTextureCoordinates() <em>Texture
	 * Coordinates</em>}' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getTextureCoordinates()
	 * @generated
	 * @ordered
	 */
	protected EList<Vertex> textureCoordinates;

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
	 * 
	 * @generated
	 */
	protected VertexSourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.VERTEX_SOURCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<Vertex> getVertices() {
		if (vertices == null) {
			vertices = new EObjectContainmentEList<Vertex>(Vertex.class, this,
					GeometryPackage.VERTEX_SOURCE__VERTICES);
		}
		return vertices;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<Vertex> getTextureCoordinates() {
		if (textureCoordinates == null) {
			textureCoordinates = new EObjectContainmentEList<Vertex>(
					Vertex.class, this,
					GeometryPackage.VERTEX_SOURCE__TEXTURE_COORDINATES);
		}
		return textureCoordinates;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<String> getMaterialFiles() {
		if (materialFiles == null) {
			materialFiles = new EDataTypeUniqueEList<String>(String.class, this,
					GeometryPackage.VERTEX_SOURCE__MATERIAL_FILES);
		}
		return materialFiles;
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
		case GeometryPackage.VERTEX_SOURCE__VERTICES:
			return ((InternalEList<?>) getVertices()).basicRemove(otherEnd,
					msgs);
		case GeometryPackage.VERTEX_SOURCE__TEXTURE_COORDINATES:
			return ((InternalEList<?>) getTextureCoordinates())
					.basicRemove(otherEnd, msgs);
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
		case GeometryPackage.VERTEX_SOURCE__VERTICES:
			return getVertices();
		case GeometryPackage.VERTEX_SOURCE__TEXTURE_COORDINATES:
			return getTextureCoordinates();
		case GeometryPackage.VERTEX_SOURCE__MATERIAL_FILES:
			return getMaterialFiles();
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
		case GeometryPackage.VERTEX_SOURCE__VERTICES:
			getVertices().clear();
			getVertices().addAll((Collection<? extends Vertex>) newValue);
			return;
		case GeometryPackage.VERTEX_SOURCE__TEXTURE_COORDINATES:
			getTextureCoordinates().clear();
			getTextureCoordinates()
					.addAll((Collection<? extends Vertex>) newValue);
			return;
		case GeometryPackage.VERTEX_SOURCE__MATERIAL_FILES:
			getMaterialFiles().clear();
			getMaterialFiles().addAll((Collection<? extends String>) newValue);
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
		case GeometryPackage.VERTEX_SOURCE__VERTICES:
			getVertices().clear();
			return;
		case GeometryPackage.VERTEX_SOURCE__TEXTURE_COORDINATES:
			getTextureCoordinates().clear();
			return;
		case GeometryPackage.VERTEX_SOURCE__MATERIAL_FILES:
			getMaterialFiles().clear();
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
		case GeometryPackage.VERTEX_SOURCE__VERTICES:
			return vertices != null && !vertices.isEmpty();
		case GeometryPackage.VERTEX_SOURCE__TEXTURE_COORDINATES:
			return textureCoordinates != null && !textureCoordinates.isEmpty();
		case GeometryPackage.VERTEX_SOURCE__MATERIAL_FILES:
			return materialFiles != null && !materialFiles.isEmpty();
		}
		return super.eIsSet(featureID);
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
		result.append(" (materialFiles: ");
		result.append(materialFiles);
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
} // VertexSourceImpl
