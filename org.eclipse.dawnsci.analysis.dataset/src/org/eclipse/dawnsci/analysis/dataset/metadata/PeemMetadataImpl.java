/*-
 * Copyright (c) 2014 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.dataset.metadata;

import org.eclipse.dawnsci.analysis.api.metadata.PeemMetadata;

public class PeemMetadataImpl implements PeemMetadata {

	private double[] xyMotorPosition;
	private double scaling = 512 / 50;
	private double fieldOfView = 50;
	private double rotation = -49;

	public PeemMetadataImpl(double[] xyPosition, double scaling, double fieldOfView, double rotation) {
		this.xyMotorPosition = xyPosition;
		this.scaling = scaling;
		this.fieldOfView = fieldOfView;
		this.rotation = rotation;
	}

	public PeemMetadataImpl(PeemMetadata metadata) {
		super();
		this.xyMotorPosition = metadata.getXYMotorPosition();
		this.scaling = metadata.getScaling();
		this.fieldOfView = metadata.getFieldOfView();
		this.rotation = metadata.getRotation();
	}

	@Override
	public double[] getXYMotorPosition() {
		return xyMotorPosition;
	}

	@Override
	public double getScaling() {
		return scaling;
	}

	@Override
	public double getFieldOfView() {
		return fieldOfView;
	}

	@Override
	public double getRotation() {
		return rotation;
	}

	@Override
	public void setXYMotorPosition(double[] xyMotorPosition) {
		this.xyMotorPosition = xyMotorPosition;
	}

	@Override
	public void setScaling(double scaling) {
		this.scaling = scaling;
	}

	@Override
	public void setFieldOfView(double fieldOfView) {
		this.fieldOfView = fieldOfView;
	}

	@Override
	public void setRotation(double rotation) {
		this.rotation = rotation;
	}

	@Override
	public PeemMetadataImpl clone() {
		return new PeemMetadataImpl(this);
	}
}
