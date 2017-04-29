/*******************************************************************************
 * Copyright (c) 2011, 2016 UT-Battelle, LLC.
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
package org.eclipse.january.form;

import java.util.ArrayList;

/**
 * "Components" are the basic building blocks of the Form package and bring
 * together the dynamically updateable, identifiable, observable, and visitable
 * qualities of the interfaces in this package in one place. Composites -
 * which aggregate Components - also realize these capabilities.
 * 
 * @author Jay Jay Billings
 */
public interface Component extends IUpdateable, Identifiable, IVisitable {

}