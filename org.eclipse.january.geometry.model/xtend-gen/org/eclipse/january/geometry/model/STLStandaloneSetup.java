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

import com.google.inject.Injector;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.january.geometry.model.STLStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class STLStandaloneSetup extends STLStandaloneSetupGenerated {
  public static void doSetup() {
    new STLStandaloneSetup().createInjectorAndDoEMFRegistration();
  }
  
  @Override
  public void register(final Injector injector) {
    boolean _containsKey = EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/january/geometry");
    boolean _not = (!_containsKey);
    if (_not) {
      EPackage.Registry.INSTANCE.put("http://www.eclipse.org/january/geometry", GeometryPackage.eINSTANCE);
    }
    super.register(injector);
  }
}
