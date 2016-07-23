/*******************************************************************************
 * Copyright (c) 2016 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - 
 *   Kasper Gammeltoft
 *******************************************************************************/
package xtext

import com.google.inject.Injector
import org.eclipse.emf.ecore.EPackage

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class STLStandaloneSetup extends xtext.STLStandaloneSetupGenerated {

	def static void doSetup() {
		new STLStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
	
	override void register(Injector injector) {
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/january/geometry")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/january/geometry", org.eclipse.january.geometry.GeometryPackage.eINSTANCE);
		}
		super.register(injector);
	}
}
