/*******************************************************************************
 * Copyright (c) 2011, 2014 UT-Battelle, LLC.
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
package org.eclipse.ice.datastructures.test;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.ice.datastructures.ICEObject.IUpdateable;
import org.eclipse.ice.datastructures.ICEObject.IUpdateableListener;
import org.eclipse.ice.viz.service.datastructures.VizObject.IManagedVizUpdateable;
import org.eclipse.ice.viz.service.datastructures.VizObject.IManagedVizUpdateableListener;
import org.eclipse.ice.viz.service.datastructures.VizObject.IVizUpdateable;
import org.eclipse.ice.viz.service.datastructures.VizObject.IVizUpdateableListener;
import org.eclipse.ice.viz.service.datastructures.VizObject.UpdateableSubscriptionType;

/**
 * <p>
 * This class realizes the IComponentListener interface and is used to test
 * Component call backs in tests. It has a unlisted, volatile attribute called
 * serviceLatch that is a CountDownLatch. It is instantiated in reset and
 * constructor. This is used to utilize threads more effectively by waiting for
 * a thread to be free in order to notify if a component was changed. The update
 * operation calls countDown on the latch.
 * </p>
 * 
 * @author Jay Jay Billings
 */
public class TestComponentListener implements IManagedVizUpdateableListener, IUpdateableListener,
		IVizUpdateableListener {

	/**
	 * The flag that indicates whether or not the listener was updated.
	 */
	private AtomicBoolean wasNotified;

	/**
	 * <p>
	 * The Constructor. Sets up the CountDownLatch to one.
	 * </p>
	 * 
	 */
	public TestComponentListener() {

		// Initialize the atomic
		wasNotified = new AtomicBoolean();
		wasNotified.set(false);

		return;
	}

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

	/**
	 * (non-Javadoc)
	 * 
	 * @see IUpdateableListener#update(IUpdateable component)
	 */
	@Override
	public void update(IUpdateable component) {

		// Update the flag
		wasNotified.set(true);

		// Dump some debug information
		System.out.println("TestComponentListener Message: Updated!");

		return;

	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.viz.service.datastructures.IVizUpdateableListener#update(org.eclipse.ice.viz.service.datastructures.IVizUpdateable)
	 */
	@Override
	public void update(IVizUpdateable component) {

		// Update the flag
		wasNotified.set(true);

		// Dump some debug information
		System.out.println("TestComponentListener Message: Updated!");

		return;
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.viz.service.datastructures.VizObject.IManagedVizUpdateableListener#getSubscriptions(org.eclipse.ice.viz.service.datastructures.VizObject.IManagedVizUpdateable)
	 */
	@Override
	public ArrayList<UpdateableSubscriptionType> getSubscriptions(IManagedVizUpdateable source) {
		ArrayList<UpdateableSubscriptionType> types = new ArrayList<UpdateableSubscriptionType>();
		types.add(UpdateableSubscriptionType.All);
		return types;
	}

	@Override
	public void update(IManagedVizUpdateable component, UpdateableSubscriptionType[] type) {
		// Update the flag
		wasNotified.set(true);

		// Dump some debug information
		System.out.println("TestComponentListener Message: Updated!");
		
	}
}