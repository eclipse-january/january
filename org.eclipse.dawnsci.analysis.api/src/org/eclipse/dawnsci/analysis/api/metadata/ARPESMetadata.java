/*-
 *******************************************************************************
 * Copyright (c) 2011, 2014 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Peter Chang - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.dawnsci.analysis.api.metadata;

import org.eclipse.dawnsci.analysis.api.dataset.ILazyDataset;

/**
 * This metadata describes ARPES-related information
 */
public interface ARPESMetadata extends MetadataType {

	// Constants for the scan
	public double getPhotonEnergy();
	public double getWorkFunction();
	public double getPassEnergy();
	public double getTemperature();
	
	// Axis associated with detector images
	public ILazyDataset getKineticEnergies();
	public ILazyDataset getAnalyserAngles();
	
	// Axis associated with the scan direction of the data
	public ILazyDataset getPolarAngles();
	public ILazyDataset getTiltAngles();
	public ILazyDataset getAzimuthalAngles();

	// Calibration information
	public double getEnergyAxisGlobalOffset();
	public double getAngleAxisGlobalOffset();
	public ILazyDataset getEnergyAxisOffset();
	
	
	// calculated axis associated with frames
	public ILazyDataset getBindingEnergies();
	public ILazyDataset getPhotoelectronMomentum();
	
	
	// Methods to correct data
	
}
