/*******************************************************************************
 * Copyright (c) 2015, 2016- UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - Jay Jay 
 *   Billings
 *******************************************************************************/
package org.eclipse.january.datastructures.test;

import static org.junit.Assert.fail;

import java.util.concurrent.atomic.AtomicBoolean;

import ca.odell.glazedlists.event.ListEvent;
import ca.odell.glazedlists.event.ListEventListener;

/**
 * This class realizes the ListEventListener interface and is used to test
 * ListComponent call backs in tests.
 * 
 * @author Jordan Deyton
 */
public class TestListComponentListener<T> implements ListEventListener<T> {

	/**
	 * The flag that indicates whether or not the listener was updated.
	 */
	private final AtomicBoolean wasNotified = new AtomicBoolean(false);

	/**
	 * <p>
	 * This operation returns the notification state of the listener.
	 * </p>
	 * 
	 * @return <p>
	 *         True if the listener has been notified of an update, false
	 *         otherwise.
	 *         </p>
	 */
	public boolean wasNotified() {

		// Wait a couple of seconds so that the thread can work, but break early
		// if the thread has finished.
		double seconds = 2;
		double sleepTime = 0.0;
		while (!wasNotified.get() && sleepTime < seconds) {
			try {
				Thread.sleep(50);
				sleepTime += 0.05;
			} catch (InterruptedException e) {
				// Complain and fail
				e.printStackTrace();
				fail();
			}
		}

		return wasNotified.get();
	}

	/**
	 * <p>
	 * This operation resets the countdownlatch to 0.
	 * </p>
	 * 
	 */
	public void reset() {

		wasNotified.set(false);

		return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.odell.glazedlists.event.ListEventListener#listChanged(ca.odell.glazedlists
	 * .event.ListEvent)
	 */
	@Override
	public void listChanged(ListEvent<T> listChanges) {
		// Update the flag
		wasNotified.set(true);

		// Dump some debug information
		System.out.println("TestListComponentListener Message: Updated!");
	}

}
