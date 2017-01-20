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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * This enumeration describes the degree to which the Form is found acceptable.
 * </p>
 * <p>
 * </p>
 * 
 * @author Jay Jay Billings
 */
@XmlType
@XmlEnum(Integer.class)
public enum FormStatus {
	/**
	 * <p>
	 * This literal means that the previous Form submitted was accepted, but
	 * another Form with additional information must be submitted.
	 * </p>
	 * 
	 */
	@XmlEnumValue("1")
	NeedsInfo,
	/**
	 * <p>
	 * This literal means that the Form has all of the information it needs and
	 * can be processed.
	 * </p>
	 * 
	 */
	@XmlEnumValue("2")
	ReadyToProcess,
	/**
	 * <p>
	 * This literal means that the Form is currently being processed.
	 * </p>
	 * 
	 */
	@XmlEnumValue("3")
	Processing,
	/**
	 * <p>
	 * This literal means that the Form has been previously and completely
	 * processed for its current configuration.
	 * </p>
	 * 
	 */
	@XmlEnumValue("4")
	Processed,
	/**
	 * <p>
	 * This literal means that the Form is still in review after a prior version
	 * was submitted.
	 * </p>
	 * 
	 */
	@XmlEnumValue("5")
	InReview,
	/**
	 * <p>
	 * This literal means that some invalid information was submitted in the
	 * Form.
	 * </p>
	 * 
	 */
	@XmlEnumValue("6")
	InfoError,
	/**
	 * <p>
	 * This literal means that the Form is unacceptable for some reason outside
	 * of its own nature. It does not mean that Form is erroneous or not capable
	 * of being processed, but instead it means that the Form can not be
	 * processed, reviewed or used in any other way except as a source of
	 * information.
	 * </p>
	 * 
	 */
	@XmlEnumValue("7")
	Unacceptable
}