/*-
 *******************************************************************************
 * Copyright (c) 2011, 2016 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Peter Chang - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.january.metadata;

/**
 * This metadata describes Peem-related information
 */
public interface PeemMetadata extends MetadataType {

	/**
	 * Initialize PEEM metadata
	 * @param xyPosition values of motor
	 * @param scaling image resolution
	 * @param fieldOfView size of image
	 */
	public void initialize(double[] xyPosition, double scaling, double fieldOfView);

	/**
	 * 
	 * @return X/y motor position in microns
	 */
	public double[] getXYMotorPosition();

	/**
	 * 
	 * @return scaling value micron/pixel
	 */
	public double getScaling();

	/**
	 * 
	 * @return field of view value in microns
	 */
	public double getFieldOfView();
//
//	/**
//	 * Image rotation (motor x-axis angle with respect to camera x-axis)
//	 * @return angular rotation in degrees 
//	 */
//	public double getRotation();

	/**
	 * Sets X/y motor position in microns
	 * @param xyMotorPosition values of motor
	 */
	void setXYMotorPosition(double[] xyMotorPosition);

	/**
	 * Sets scaling micron/pixel
	 * @param scaling image resolution
	 */
	void setScaling(double scaling);

	/**
	 * Sets fieldOfView value in microns
	 * @param fieldOfView size of image
	 */
	void setFieldOfView(double fieldOfView);

//	/**
//	 * Sets rotation angular value in degree
//	 * Image rotation (motor x-axis angle with respect to camera x-axis)
//	 * @param rotation
//	 */
//	void setRotation(double rotation);
}
