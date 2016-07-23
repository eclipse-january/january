/*******************************************************************************
\ * Copyright (c) 2011, 2016 UT-Battelle, LLC.
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

/**
 * The ValueType enumeration describes the types of Values that are stored for
 * in an instance of the Entry class.
 * 
 * @author Jay Jay Billings
 */
@XmlEnum
public enum AllowedValueType {
	/**
	 * This literal means that the Value stored by an Entry must equal one of
	 * the values stored in the allowedValues array for that Entry.
	 */
	Discrete,

	/**
	 * This literal means that the value stored by an Entry must be within the
	 * range of values specified by the allowedValues array for that Entry.
	 */
	Continuous,

	/**
	 * This literal means the Entry is used in a form for specifying some sort
	 * of file (such as an input file). The value of the entry will be a
	 * filename, and the list of allowedValues will be files in the workspace.
	 */
	File,

	/**
	 * This literal implies that the Entry is used in a form for specifying 
	 * an executable on the file system. The value of the Entry will be a 
	 * URI represented as a string, and the list of allowedValues will be 
	 * previously selected executables.
	 */
	Executable,
	
	/**
	 * This literal means that the Entry is used in an undefined form where the
	 * value is and should be treated as a simple string.
	 */
	Undefined
}