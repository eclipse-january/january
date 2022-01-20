package org.eclipse.january.io;

import java.io.IOException;

import org.eclipse.january.IMonitor;
import org.eclipse.january.dataset.IDataset;
import org.eclipse.january.dataset.SliceND;

/**
 * Used by lazy writeable datasets to write slices to a file in an asynchronous manner
 */
public interface ILazyAsyncSaver extends ILazySaver {

	/**
	 * Non-blocking version of {@link #setSlice(IMonitor, IDataset, SliceND)}
	 * @param mon can be null
	 * @param data to use
	 * @param slice destination where to set with items of data
	 * @throws IOException when cannot write data
	 */
	public void setSliceAsync(IMonitor mon, IDataset data, SliceND slice) throws IOException;
}
