/*******************************************************************************
 * Copyright (c) 2013, 2016 UT-Battelle, LLC.
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

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * This interface specializes the Component interface for LWRReactors. It is a
 * place holder used
 * </p>
 * 
 * @author Jay Jay Billings
 */
@XmlRootElement(name = "ReactorComponent")
public interface IReactorComponent extends Component {

	/**
	 * <p>
	 * This operation returns the contents of the ILWRComponent as a string.
	 * </p>
	 * 
	 * @return
	 * 		<p>
	 *         The contents of the LWRComponent as a string.
	 *         </p>
	 */
	@Override
	public String toString();
}