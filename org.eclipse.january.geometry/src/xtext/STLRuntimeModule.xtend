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

import org.eclipse.emf.ecore.EValidator
import org.eclipse.emf.ecore.EPackage

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class STLRuntimeModule extends xtext.AbstractSTLRuntimeModule {
	
	override public EValidator.Registry bindEValidatorRegistry() {
		return new org.eclipse.emf.ecore.impl.EValidatorRegistryImpl() {
			
			override Object get(Object key) {
				return null;
			}
			
			override public EValidator getEValidator(EPackage ePackage) {
			  	return null;
			}
				
		}
	}
	
}
