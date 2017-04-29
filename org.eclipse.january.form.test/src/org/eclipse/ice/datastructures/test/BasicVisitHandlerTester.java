/*******************************************************************************
 * Copyright (c) 2012, 2016 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - 
 *   Jay Jay Billings
 *******************************************************************************/
package org.eclipse.ice.datastructures.test;

import static org.junit.Assert.*;

import org.eclipse.january.form.BasicVisitHandler;
import org.eclipse.january.form.IGenericallyVisitable;
import org.eclipse.january.form.IVisitHandler;
import org.eclipse.january.form.IVisitor;
import org.junit.Test;

// Test Class for visiting
class TestClass implements IGenericallyVisitable {
	public void accept(IVisitHandler vh) {
		vh.visit(this);
	}
}

// Second Test Class for making sure multiple classes can be registered
// successfully.
class TestClass2 {
	void accept(IVisitHandler vh) {
		vh.visit(this);
	}
}

// Test visitor. Note TestVisitor is already a named class in this package!
class TestVisitor2 implements IVisitor<TestClass> {

	public String val;

	@Override
	public void visit(TestClass o) {
		val = "Allemande";
	}

}

// Second Test visitor for second class tests
class TestVisitor3 implements IVisitor<TestClass2> {

	public String val;

	@Override
	public void visit(TestClass2 o) {
		val = "Rostropovich";
	}

}

/**
 * This class tests the BasicVisitHandler by making sure that multiple classes
 * can be registered against visitors and that visitation events are properly
 * dispatched.
 * 
 * @author Jay Jay Billings
 *
 */
public class BasicVisitHandlerTester {

	/**
	 * Test method for
	 * {@link org.eclipse.january.form.BasicVisitHandler#visit(java.lang.Object)}.
	 */
	@Test
	public void testVisit() {

		// Create a simple handler and register visitors with it.
		BasicVisitHandler bvh = new BasicVisitHandler();
		TestVisitor2 visitor = new TestVisitor2();
		TestVisitor3 secondVisitor = new TestVisitor3();
		bvh.set(TestClass.class, visitor);
		bvh.set(TestClass2.class, secondVisitor);

		// Execute the visitation orders
		TestClass myTestClass = new TestClass();
		myTestClass.accept(bvh);
		TestClass2 myTestClass2 = new TestClass2();
		myTestClass2.accept(bvh);

		// Check the result
		assertEquals("Allemande", visitor.val);
		assertEquals("Rostropovich", secondVisitor.val);
	}

}
