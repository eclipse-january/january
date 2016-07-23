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

/**
 * <p>
 * The AcceptanceCode enumeration is the list of all possible return values that
 * will be returned by Forms when updating Entries or by Items when submitting
 * Forms.
 * </p>
 * 
 * @author Jay Jay Billings
 */
public enum AcceptanceCode {
	/**
	 * <p>
	 * Returning this literal means that the Entry or Form was accepted as
	 * valid.
	 * </p>
	 * 
	 */
	Valid,
	/**
	 * <p>
	 * Returning this literal means that the Entry or Form was not accepted and
	 * that for some reason or other the values were erroneous.
	 * </p>
	 * 
	 */
	Invalid,
	/**
	 * <p>
	 * Returning this literal means that the Entry or Form was accepted, but not
	 * checked for validity.
	 * </p>
	 * 
	 */
	Accepted,
	/**
	 * <p>
	 * This literal means that the submission was rejected and should be
	 * resubmitted after corrections are made.
	 * </p>
	 * 
	 */
	Rejected,
	/**
	 * <p>
	 * Returning this literal means that the Entry or Form was not accepted by
	 * the Form or Item because of some unexpected failure.
	 * </p>
	 * 
	 */
	AcceptanceFailure
}