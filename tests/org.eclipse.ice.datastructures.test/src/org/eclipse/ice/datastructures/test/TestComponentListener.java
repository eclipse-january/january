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

import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.ice.datastructures.ICEObject.IUpdateable;
import org.eclipse.ice.datastructures.ICEObject.IUpdateableListener;

/**
 * <!-- begin-UML-doc -->
 * <p>
 * This class realizes the IComponentListener interface and is used to test
 * Component call backs in tests. It has a unlisted, volatile attribute called
 * serviceLatch that is a CountDownLatch. It is instantiated in reset and
 * constructor. This is used to utilize threads more effectively by waiting for
 * a thread to be free in order to notify if a component was changed. The update
 * operation calls countDown on the latch.
 * </p>
 * <!-- end-UML-doc -->
 * 
 * @author Jay Jay Billings
 * @generated 
 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TestComponentListener implements IUpdateableListener {

	/**
	 * The flag that indicates whether or not the listener was updated.
	 */
	private AtomicBoolean wasNotified;

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The Constructor. Sets up the CountDownLatch to one.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TestComponentListener() {
		// begin-user-code

		// Initialize the atomic
		wasNotified = new AtomicBoolean();
		wasNotified.set(false);

		return;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation returns the notification state of the listener.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         True if the listener has been notified of an update, false
	 *         otherwise.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean wasNotified() {
		// begin-user-code

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
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation resets the countdownlatch to 0.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void reset() {
		// begin-user-code

		wasNotified.set(false);

		return;
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IUpdateableListener#update(IUpdateable component)
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void update(IUpdateable component) {
		// begin-user-code

		// Update the flag
		wasNotified.set(true);

		// Dump some debug information
		System.out.println("TestComponentListener Message: Updated!");

		return;

		// end-user-code
	}
}