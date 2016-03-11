/*******************************************************************************
 * Copyright (c) 2015 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Robert Smith
 *******************************************************************************/
package org.eclipse.eavp.viz.service.modeling;

/**
 * An interface for views which can render themselves in wireframe mode.
 * 
 * @author Robert Smith
 *
 */
public interface IWireFramePart {

	/**
	 * Set the view to display in either wireframe or filled mode
	 * 
	 * @param on
	 *            If true, sets the view to display its mesh in wireframe mode.
	 *            If false, sets the view to display its mesh normally.
	 */
	public void setWireFrameMode(boolean on);
}
