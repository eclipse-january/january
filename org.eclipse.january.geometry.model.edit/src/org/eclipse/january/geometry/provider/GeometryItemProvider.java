/*******************************************************************************
 * Copyright (c) 2016 UT-Battelle, LLC. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     UT-Battelle, LLC. - initial API and implementation
 *******************************************************************************/
package org.eclipse.january.geometry.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.january.geometry.Geometry;
import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.GeometryPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.january.geometry.Geometry} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GeometryItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeometryItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNamePropertyDescriptor(object);
			addIdPropertyDescriptor(object);
			addTypePropertyDescriptor(object);
			addCenterPropertyDescriptor(object);
			addParentPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_INode_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_INode_name_feature", "_UI_INode_type"),
				 GeometryPackage.Literals.INODE__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_INode_id_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_INode_id_feature", "_UI_INode_type"),
				 GeometryPackage.Literals.INODE__ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_INode_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_INode_type_feature", "_UI_INode_type"),
				 GeometryPackage.Literals.INODE__TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Center feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCenterPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_INode_center_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_INode_center_feature", "_UI_INode_type"),
				 GeometryPackage.Literals.INODE__CENTER,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Parent feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_INode_parent_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_INode_parent_feature", "_UI_INode_type"),
				 GeometryPackage.Literals.INODE__PARENT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(GeometryPackage.Literals.INODE__NODES);
			childrenFeatures.add(GeometryPackage.Literals.INODE__TRIANGLES);
			childrenFeatures.add(GeometryPackage.Literals.GEOMETRY__VERTEX_SOURCES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Geometry.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Geometry"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Geometry)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Geometry_type") :
			getString("_UI_Geometry_type") + " " + label;
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Geometry.class)) {
			case GeometryPackage.GEOMETRY__NAME:
			case GeometryPackage.GEOMETRY__ID:
			case GeometryPackage.GEOMETRY__TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case GeometryPackage.GEOMETRY__NODES:
			case GeometryPackage.GEOMETRY__TRIANGLES:
			case GeometryPackage.GEOMETRY__VERTEX_SOURCES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(GeometryPackage.Literals.INODE__NODES,
				 GeometryFactory.eINSTANCE.createShape()));

		newChildDescriptors.add
			(createChildParameter
				(GeometryPackage.Literals.INODE__NODES,
				 GeometryFactory.eINSTANCE.createSphere()));

		newChildDescriptors.add
			(createChildParameter
				(GeometryPackage.Literals.INODE__NODES,
				 GeometryFactory.eINSTANCE.createCube()));

		newChildDescriptors.add
			(createChildParameter
				(GeometryPackage.Literals.INODE__NODES,
				 GeometryFactory.eINSTANCE.createCylinder()));

		newChildDescriptors.add
			(createChildParameter
				(GeometryPackage.Literals.INODE__NODES,
				 GeometryFactory.eINSTANCE.createGeometry()));

		newChildDescriptors.add
			(createChildParameter
				(GeometryPackage.Literals.INODE__NODES,
				 GeometryFactory.eINSTANCE.createTube()));

		newChildDescriptors.add
			(createChildParameter
				(GeometryPackage.Literals.INODE__NODES,
				 GeometryFactory.eINSTANCE.createOperator()));

		newChildDescriptors.add
			(createChildParameter
				(GeometryPackage.Literals.INODE__NODES,
				 GeometryFactory.eINSTANCE.createUnion()));

		newChildDescriptors.add
			(createChildParameter
				(GeometryPackage.Literals.INODE__NODES,
				 GeometryFactory.eINSTANCE.createIntersection()));

		newChildDescriptors.add
			(createChildParameter
				(GeometryPackage.Literals.INODE__NODES,
				 GeometryFactory.eINSTANCE.createComplement()));

		newChildDescriptors.add
			(createChildParameter
				(GeometryPackage.Literals.INODE__NODES,
				 GeometryFactory.eINSTANCE.createPipe()));

		newChildDescriptors.add
			(createChildParameter
				(GeometryPackage.Literals.INODE__NODES,
				 GeometryFactory.eINSTANCE.createJunction()));

		newChildDescriptors.add
			(createChildParameter
				(GeometryPackage.Literals.INODE__NODES,
				 GeometryFactory.eINSTANCE.createHeatExchanger()));

		newChildDescriptors.add
			(createChildParameter
				(GeometryPackage.Literals.INODE__NODES,
				 GeometryFactory.eINSTANCE.createReactor()));

		newChildDescriptors.add
			(createChildParameter
				(GeometryPackage.Literals.INODE__NODES,
				 GeometryFactory.eINSTANCE.createPolyShape()));

		newChildDescriptors.add
			(createChildParameter
				(GeometryPackage.Literals.INODE__TRIANGLES,
				 GeometryFactory.eINSTANCE.createTriangle()));

		newChildDescriptors.add
			(createChildParameter
				(GeometryPackage.Literals.GEOMETRY__VERTEX_SOURCES,
				 GeometryFactory.eINSTANCE.createVertexSource()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return OrgeclipsejanuaryEditPlugin.INSTANCE;
	}

}