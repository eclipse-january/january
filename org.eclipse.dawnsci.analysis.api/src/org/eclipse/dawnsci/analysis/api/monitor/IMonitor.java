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

package org.eclipse.dawnsci.analysis.api.monitor;

/**
 * Interface to monitoring loading of files, which may take a while.
 */
public interface IMonitor {

	/**
	 * @param amount
	 */
	public void worked(int amount);
	
	/**
	 * @return true if user cancelled loading.
	 */
	public boolean isCancelled();
	
	/**
	 * Starts a subtask.
	 * 
	 * @param taskName
	 */
	public void subTask(String taskName);
	
	public class Stub implements IMonitor {

		@Override
		public void worked(int amount) {
			
		}

		@Override
		public boolean isCancelled() {
			return false;
		}

		@Override
		public void subTask(String taskName) {
			// nothing
		}
		
	}
}
