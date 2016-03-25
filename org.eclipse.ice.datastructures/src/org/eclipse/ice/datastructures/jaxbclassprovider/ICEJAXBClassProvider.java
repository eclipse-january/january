/*******************************************************************************
 * Copyright (c) 2013, 2014 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - Jay Jay Billings,
 *   Jordan H. Deyton, Dasha Gorin, Alexander J. McCaskey, Taylor Patterson,
 *   Claire Saunders, Matthew Wang, Anna Wojtowicz
 *******************************************************************************/
package org.eclipse.ice.datastructures.jaxbclassprovider;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ice.datastructures.ICEObject.ListComponent;
import org.eclipse.ice.datastructures.entry.AbstractEntry;
import org.eclipse.ice.datastructures.entry.ContinuousEntry;
import org.eclipse.ice.datastructures.entry.DiscreteEntry;
import org.eclipse.ice.datastructures.entry.ExecutableEntry;
import org.eclipse.ice.datastructures.entry.FileEntry;
import org.eclipse.ice.datastructures.entry.StringEntry;
import org.eclipse.ice.datastructures.form.DataComponent;
import org.eclipse.ice.datastructures.form.GeometryComponent;
import org.eclipse.ice.datastructures.form.Material;
import org.eclipse.ice.datastructures.form.MatrixComponent;
import org.eclipse.ice.datastructures.form.MeshComponent;
import org.eclipse.ice.datastructures.form.ResourceComponent;
import org.eclipse.ice.datastructures.form.TableComponent;
import org.eclipse.ice.datastructures.form.TimeDataComponent;
import org.eclipse.ice.datastructures.form.TreeComposite;
import org.eclipse.ice.datastructures.form.emf.EMFComponent;
import org.eclipse.ice.datastructures.resource.ICEResource;
import org.eclipse.ice.datastructures.resource.VizResource;

/**
 * The ICEJAXBClassProvider is a realization of the IJAXBClassProvider that
 * provides a list of classes that the XMLPersistenceProvider's JAXBContext must
 * be aware of when marshalling/unmarshalling ICE data structures.
 * 
 * @author Alex McCaskey
 *
 */
public class ICEJAXBClassProvider implements IJAXBClassProvider {

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.jaxbclassprovider.IJAXBClassProvider#getClasses()
	 */
	@Override
	public List<Class> getClasses() {

		// Create the return list of classes.
		List<Class> classList = new ArrayList<Class>();

		// Add the classes needed for XML persistence
		classList.add(TableComponent.class);
		classList.add(MatrixComponent.class);
		classList.add(GeometryComponent.class);
		classList.add(TimeDataComponent.class);
		classList.add(DataComponent.class);
		classList.add(TreeComposite.class);
		classList.add(MeshComponent.class);
		classList.add(ResourceComponent.class);
		classList.add(ListComponent.class);
		classList.add(EMFComponent.class);
		classList.add(Material.class);
		classList.add(VizResource.class);
		classList.add(ICEResource.class);
		classList.add(AbstractEntry.class);
		classList.add(FileEntry.class);
		classList.add(StringEntry.class);
		classList.add(ExecutableEntry.class);
		classList.add(ContinuousEntry.class);
		classList.add(DiscreteEntry.class);


		return classList;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.jaxbclassprovider.IJAXBClassProvider#getProviderName()
	 */
	@Override
	public String getProviderName() {
		return "ICE JAXB Class Provider";
	}

}
