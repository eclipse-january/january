/**
 * Copyright (c) 2016 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Initial API and implementation and/or initial documentation -
 *   Kasper Gammeltoft
 */
package org.eclipse.january.geometry.model;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EValidatorRegistryImpl;
import org.eclipse.january.geometry.model.AbstractSTLRuntimeModule;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
@SuppressWarnings("all")
public class STLRuntimeModule extends AbstractSTLRuntimeModule {
  @Override
  public EValidator.Registry bindEValidatorRegistry() {
    return new EValidatorRegistryImpl() {
      @Override
      public Object get(final Object key) {
        return null;
      }
      
      @Override
      public EValidator getEValidator(final EPackage ePackage) {
        return null;
      }
    };
  }
}
