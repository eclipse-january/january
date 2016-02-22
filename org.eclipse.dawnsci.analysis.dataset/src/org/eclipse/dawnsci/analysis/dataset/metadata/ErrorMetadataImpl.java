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

package org.eclipse.dawnsci.analysis.dataset.metadata;

import java.io.Serializable;

import org.eclipse.dawnsci.analysis.api.dataset.IDataset;
import org.eclipse.dawnsci.analysis.api.dataset.ILazyDataset;
import org.eclipse.dawnsci.analysis.api.metadata.AxesMetadata;
import org.eclipse.dawnsci.analysis.api.metadata.ErrorMetadata;
import org.eclipse.dawnsci.analysis.api.metadata.MetadataType;
import org.eclipse.dawnsci.analysis.api.metadata.Reshapeable;
import org.eclipse.dawnsci.analysis.api.metadata.Sliceable;
import org.eclipse.dawnsci.analysis.api.metadata.Transposable;
import org.eclipse.dawnsci.analysis.dataset.impl.Dataset;
import org.eclipse.dawnsci.analysis.dataset.impl.DatasetUtils;
import org.eclipse.dawnsci.analysis.dataset.impl.Maths;

/**
 * Implementation of error class
 */
public class ErrorMetadataImpl implements ErrorMetadata, Serializable {

	@Transposable
	@Sliceable
	@Reshapeable
	private ILazyDataset error = null; // holds linear errors

	@Transposable
	@Sliceable
	@Reshapeable
	transient private ILazyDataset sqError = null; // holds squared errors

	/**
	 * Do not use this constructor to set errors to datasets as it does not allow any shaping
	 * checking and broadcasting. Use {@link ILazyDataset#setError(Serializable)} instead.
	 */
	public ErrorMetadataImpl() {
	}

	public ErrorMetadataImpl(ErrorMetadataImpl error) {
		this.error = error.error == null ? null : error.error.getSliceView();
		this.sqError = error.sqError == null ? null : error.sqError.getSliceView();
	}

	@Override
	public MetadataType clone() {
		return new ErrorMetadataImpl(this);
	}

	@Override
	public ILazyDataset getError() {
		return error;
	}

	public void setError(ILazyDataset error) {
		this.error = sanitizeErrorData(error);
		this.sqError = null;
	}

	public Dataset getSquaredError() {
		if (sqError == null)
			sqError = error instanceof IDataset ? Maths.square(error) : null;
		return (Dataset) sqError;
	}

	public void setSquaredError(IDataset sqErrors) {
		ILazyDataset se = sanitizeErrorData(sqErrors);
		if (se instanceof IDataset) {
			sqError = DatasetUtils.convertToDataset((IDataset) se);
			if (sqError != null)
				error = Maths.sqrt(sqError);
		}
	}

	private ILazyDataset sanitizeErrorData(ILazyDataset errorData) {
		// remove any axes metadata as parent already has them
		if (errorData == null) return null;
		ILazyDataset view = errorData.getSliceView();
		view.clearMetadata(AxesMetadata.class);
		return view;
	}
}
