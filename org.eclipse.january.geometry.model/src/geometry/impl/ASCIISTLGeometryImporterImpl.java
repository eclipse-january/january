/**
 */
package geometry.impl;

import geometry.ASCIISTLGeometryImporter;
import geometry.Geometry;
import geometry.GeometryPackage;

import java.lang.reflect.InvocationTargetException;

import java.nio.file.Path;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ASCIISTL Geometry Importer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link geometry.impl.ASCIISTLGeometryImporterImpl#getFileTypes <em>File Types</em>}</li>
 *   <li>{@link geometry.impl.ASCIISTLGeometryImporterImpl#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ASCIISTLGeometryImporterImpl extends MinimalEObjectImpl.Container implements ASCIISTLGeometryImporter {
	/**
	 * The cached value of the '{@link #getFileTypes() <em>File Types</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<String> fileTypes;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ASCIISTLGeometryImporterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.ASCIISTL_GEOMETRY_IMPORTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getFileTypes() {
		if (fileTypes == null) {
			fileTypes = new EDataTypeUniqueEList<String>(String.class, this, GeometryPackage.ASCIISTL_GEOMETRY_IMPORTER__FILE_TYPES);
		}
		return fileTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeometryPackage.ASCIISTL_GEOMETRY_IMPORTER__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Geometry load(Path path) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeometryPackage.ASCIISTL_GEOMETRY_IMPORTER__FILE_TYPES:
				return getFileTypes();
			case GeometryPackage.ASCIISTL_GEOMETRY_IMPORTER__DESCRIPTION:
				return getDescription();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GeometryPackage.ASCIISTL_GEOMETRY_IMPORTER__FILE_TYPES:
				getFileTypes().clear();
				getFileTypes().addAll((Collection<? extends String>)newValue);
				return;
			case GeometryPackage.ASCIISTL_GEOMETRY_IMPORTER__DESCRIPTION:
				setDescription((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GeometryPackage.ASCIISTL_GEOMETRY_IMPORTER__FILE_TYPES:
				getFileTypes().clear();
				return;
			case GeometryPackage.ASCIISTL_GEOMETRY_IMPORTER__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GeometryPackage.ASCIISTL_GEOMETRY_IMPORTER__FILE_TYPES:
				return fileTypes != null && !fileTypes.isEmpty();
			case GeometryPackage.ASCIISTL_GEOMETRY_IMPORTER__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case GeometryPackage.ASCIISTL_GEOMETRY_IMPORTER___LOAD__PATH:
				return load((Path)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (fileTypes: ");
		result.append(fileTypes);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //ASCIISTLGeometryImporterImpl
