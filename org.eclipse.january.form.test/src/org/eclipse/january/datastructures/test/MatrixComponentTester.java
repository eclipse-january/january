/*******************************************************************************
 * Copyright (c) 2012, 2016 UT-Battelle, LLC.
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
package org.eclipse.january.datastructures.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.xml.bind.JAXBException;

import org.eclipse.january.form.AllowedValueType;
import org.eclipse.january.form.JanuaryJAXBHandler;
import org.eclipse.january.form.JanuaryObject;
import org.eclipse.january.form.MatrixComponent;
import org.junit.Test;

/**
 * This class is responsible for testing the MatrixComponent.
 * @author Jay Jay Billings, Alex McCaskey
 */

public class MatrixComponentTester {
	/**
	 * 
	 */
	private MatrixComponent matrixComponent;
	/**
	 * 
	 */
	private TestComponentListener testComponentListener;
	/**
	 * 
	 */
	private TestVisitor testVisitor;

	/**
	 * <p>
	 * This operation checks the MatrixComponent to insure that its equals() and
	 * hashcode() operations work.
	 * </p>
	 * 
	 */
	@Test
	public void checkEquality() {
		// Create MatrixComponents to test
		MatrixComponent component = new MatrixComponent(false,
				AllowedValueType.Continuous);
		MatrixComponent equalComponent = new MatrixComponent(false,
				AllowedValueType.Continuous);
		MatrixComponent unEqualComponent = new MatrixComponent(true,
				AllowedValueType.Undefined);
		MatrixComponent transitiveComponent = new MatrixComponent(false,
				AllowedValueType.Continuous);

		// Set Type
		ArrayList<Double> allowedValues = new ArrayList<Double>();

		// Add Allowed Values to allowedValues list
		allowedValues.add(1.0);
		allowedValues.add(10.0);

		// Set the allowedValues
		component.setAllowedValues(allowedValues);
		equalComponent.setAllowedValues(allowedValues);
		transitiveComponent.setAllowedValues(allowedValues);

		// Add rows and columns
		for (int i = 0; i < 5; i++) {
			component.addRow();
			equalComponent.addRow();
			transitiveComponent.addRow();
			component.addColumn();
			equalComponent.addColumn();
			transitiveComponent.addColumn();

			// This should double in size - it is squared
			unEqualComponent.addRow();
			unEqualComponent.addColumn();
		}

		// Set JanuaryObject data
		component.setId(1);
		equalComponent.setId(1);
		transitiveComponent.setId(1);
		unEqualComponent.setId(2);

		component.setName("DC Equal");
		equalComponent.setName("DC Equal");
		transitiveComponent.setName("DC Equal");
		unEqualComponent.setName("DC UnEqual");

		// Assert two equal DataComponents return true
		assertTrue(component.equals(equalComponent));

		// Assert two unequal DataComponents return false
		assertFalse(component.equals(unEqualComponent));

		// Assert equals() is reflexive
		assertTrue(component.equals(component));

		// Assert the equals() is Symmetric
		assertTrue(component.equals(equalComponent)
				&& equalComponent.equals(component));

		// Assert equals() is transitive
		if (component.equals(equalComponent)
				&& equalComponent.equals(transitiveComponent)) {
			assertTrue(component.equals(transitiveComponent));
		} else {
			fail();
		}

		// Assert equals is consistent
		assertTrue(component.equals(equalComponent)
				&& component.equals(equalComponent)
				&& component.equals(equalComponent));
		assertTrue(!component.equals(unEqualComponent)
				&& !component.equals(unEqualComponent)
				&& !component.equals(unEqualComponent));

		// Assert checking equality with null is false
		assertFalse(component==null);

		// Assert that two equal objects return same hashcode
		assertTrue(component.equals(equalComponent)
				&& component.hashCode() == equalComponent.hashCode());

		// Assert that hashcode is consistent
		assertTrue(component.hashCode() == component.hashCode());

		// Assert that hashcodes from unequal objects are different
		assertTrue(component.hashCode() != unEqualComponent.hashCode());

	}

	/**
	 * <p>
	 * This operation checks the MatrixComponent to insure that it can be
	 * correctly visited by a realization of the IComponentVisitor interface.
	 * </p>
	 * 
	 */
	@Test
	public void checkVisitation() {
		// Setup the visitor
		testVisitor = new TestVisitor();

		// Setup the DataComponent
		matrixComponent = new MatrixComponent();

		// Send the visitor
		matrixComponent.accept(testVisitor);

		// Check the visitor
		assertTrue(testVisitor.wasVisited());

	}

	/**
	 * <p>
	 * This operation tests the MatrixComponent to insure that it can properly
	 * dispatch notifications when it receives an update that changes its state.
	 * </p>
	 * 
	 */
	@Test
	public void checkNotifications() {
		// Setup the listener
		testComponentListener = new TestComponentListener();

		// Setup the MatrixComponent
		matrixComponent = new MatrixComponent(false,
				AllowedValueType.Continuous);
		matrixComponent.addRow();
		matrixComponent.addColumn();

		// Register the listener
		matrixComponent.register(testComponentListener);

		ArrayList<Double> values = new ArrayList<Double>();
		values.add(0.0);
		values.add(10.0);

		// set the allowed values
		matrixComponent.setAllowedValues(values);

		// Check the Listener
		assertTrue(testComponentListener.wasNotified());

		// Reset the listener
		testComponentListener.reset();

		// add a row in MatrixComponent
		matrixComponent.addRow();

		// Check the Listener
		assertTrue(testComponentListener.wasNotified());

		// Reset the listener
		testComponentListener.reset();

		// delete a row in MatrixComponent
		matrixComponent.deleteRow();

		// Check the Listener
		assertTrue(testComponentListener.wasNotified());

		// Reset the listener
		testComponentListener.reset();

		// add a column in MatrixComponent
		matrixComponent.addColumn();

		// Check the Listener
		assertTrue(testComponentListener.wasNotified());

		// Reset the listener
		testComponentListener.reset();

		// delete a column in MatrixComponent
		matrixComponent.deleteColumn();

		// Check the Listener
		assertTrue(testComponentListener.wasNotified());

		// Reset the listener
		testComponentListener.reset();

		// set an element in MatrixComponent
		matrixComponent.setElementValue(0, 0, 0.0);

		// Check the Listener
		assertTrue(testComponentListener.wasNotified());

		// Reset the listener
		testComponentListener.reset();

		// set the resizable in MatrixComponent
		matrixComponent.setResizable(false);

		// Check the Listener
		assertTrue(testComponentListener.wasNotified());

		// Reset the listener
		testComponentListener.reset();
	}

	/**
	 * <p>
	 * This operation checks the MatrixComponent to ensure that its copy() and
	 * clone() operations work as specified.
	 * </p>
	 * 
	 */
	@Test
	public void checkCopying() {
		// Local declarations
		int id = 5;
		String name = "Bob";
		String description = "I am Bob! 1.0";
		ArrayList<Double> values = new ArrayList<Double>();
		MatrixComponent cloneMatrix, copyMatrix;

		// Listener
		TestComponentListener listener = new TestComponentListener();

		// Add allowedvalues to arraylist
		values.add(1.0);
		values.add(10.0);

		// Create MatrixComponent, set values, add rows (its square, so it will
		// add columns too!)
		matrixComponent = new MatrixComponent(true, AllowedValueType.Continuous);
		matrixComponent.setAllowedValues(values);
		matrixComponent.addRow();
		matrixComponent.addRow();
		matrixComponent.addRow();
		matrixComponent.setElementValue(2, 2, 3.0);

		// set JanuaryObject info
		matrixComponent.setId(id);
		matrixComponent.setName(name);
		matrixComponent.setDescription(description);

		// Register listener
		matrixComponent.register(listener);

		// Clone contents
		cloneMatrix = (MatrixComponent) matrixComponent.clone();

		assertNotNull(cloneMatrix);

		// Check equality of contents
		assertTrue(cloneMatrix.equals(matrixComponent));

		// Copy contents
		copyMatrix = new MatrixComponent();
		copyMatrix.copy(matrixComponent);

		// Check equality of contents
		assertTrue(copyMatrix.equals(matrixComponent));

		// Pass null into copy contents, show nothing has changed
		copyMatrix.copy(null);

		// Check equality of contents
		assertTrue(copyMatrix.equals(matrixComponent));

		return;
	}

	/**
	 * This operation checks the ability of the MatrixComponent to persist
	 * itself to XML and to load itself from an XML input stream.
	 * @throws IOException 
	 * @throws JAXBException 
	 * @throws NullPointerException 
	 */
	@Test
	public void checkLoadingFromXML() throws NullPointerException, JAXBException, IOException {
		// Local declarations
		int id = 5;
		String name = "Bob";
		String description = "I am Bob! 1.0";
		ArrayList<Double> values = new ArrayList<Double>();
		MatrixComponent loadMatrix;
		JanuaryJAXBHandler xmlHandler = new JanuaryJAXBHandler();
		ArrayList<Class> classList = new ArrayList<Class>();
		classList.add(MatrixComponent.class);

		// Add allowedvalues to arraylist
		values.add(1.0);
		values.add(10.0);

		// Create MatrixComponent, set values, add rows (its square, so it will
		// add columns too!)
		matrixComponent = new MatrixComponent(true, AllowedValueType.Continuous);
		matrixComponent.setAllowedValues(values);
		matrixComponent.addRow();
		matrixComponent.addRow();
		matrixComponent.addRow();
		matrixComponent.setElementValue(2, 2, 3.0);

		// set JanuaryObject info
		matrixComponent.setId(id);
		matrixComponent.setName(name);
		matrixComponent.setDescription(description);

		// Load it into XML
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		xmlHandler.write(matrixComponent, classList, outputStream);
		String xmlFile2 = new String(outputStream.toByteArray());
		// System.err.println(xmlFile2);

		// convert information inside of outputStream to inputStream
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				outputStream.toByteArray());

		// load contents into xml
		loadMatrix = new MatrixComponent();
		loadMatrix = (MatrixComponent) xmlHandler.read(classList, inputStream);

		// Check contents
		assertTrue(loadMatrix.equals(matrixComponent));

	}

	/**
	 * <p>
	 * This method checks that a MatrixComponent can be constructed by using all
	 * three constructors. It also tests that its JanuaryObject data can be set and
	 * get correctly.
	 * </p>
	 * 
	 */
	@Test
	public void checkConstruction() {

		// Local Declarations
		JanuaryObject JanuaryObject = new JanuaryObject();
		// JanuaryObject will be used in comparisons to check
		// to see if MatrixComponent just copies data from the
		// super constructor for id, name, and desc.

		// Three types of constructors

		// Nullery constructor
		matrixComponent = new MatrixComponent();

		// Make sure it is not null
		assertNotNull(matrixComponent);

		// Square should be false
		assertFalse(matrixComponent.isSquare());

		// Check name, description, and Id - Should match the super
		// constructor's (JanuaryObject) info
		assertEquals(JanuaryObject.getName(), matrixComponent.getName());
		assertEquals(JanuaryObject.getId(), matrixComponent.getId());
		assertEquals(JanuaryObject.getDescription(),
				matrixComponent.getDescription());

		// isSquared Constructor, setting isSquared to false
		matrixComponent = new MatrixComponent(false);

		// Make sure it is not null
		assertNotNull(matrixComponent);

		// Square should be false
		assertFalse(matrixComponent.isSquare());

		// Check name, description, and Id - Should match the super
		// constructor's (JanuaryObject) info
		assertEquals(JanuaryObject.getName(), matrixComponent.getName());
		assertEquals(JanuaryObject.getId(), matrixComponent.getId());
		assertEquals(JanuaryObject.getDescription(),
				matrixComponent.getDescription());

		// isSquared Constructor, setting isSquared to true
		matrixComponent = new MatrixComponent(true);

		// Make sure it is not null
		assertNotNull(matrixComponent);

		// Square should be true
		assertTrue(matrixComponent.isSquare());

		// Check name, description, and Id - Should match the super
		// constructor's (JanuaryObject) info
		assertEquals(JanuaryObject.getName(), matrixComponent.getName());
		assertEquals(JanuaryObject.getId(), matrixComponent.getId());
		assertEquals(JanuaryObject.getDescription(),
				matrixComponent.getDescription());

		// isSquared Constructor and allowedValueType - undefined, setting
		// isSquared to false
		matrixComponent = new MatrixComponent(false, AllowedValueType.Undefined);

		// Make sure it is not null
		assertNotNull(matrixComponent);

		// Square should be false
		assertFalse(matrixComponent.isSquare());

		// Check name, description, and Id - Should match the super
		// constructor's (JanuaryObject) info
		assertEquals(JanuaryObject.getName(), matrixComponent.getName());
		assertEquals(JanuaryObject.getId(), matrixComponent.getId());
		assertEquals(JanuaryObject.getDescription(),
				matrixComponent.getDescription());

		// isSquared Constructor and allowedValueType - Discrete, setting
		// isSquared to true
		matrixComponent = new MatrixComponent(true, AllowedValueType.Discrete);

		// Make sure it is not null
		assertNotNull(matrixComponent);

		// Square should be false
		assertTrue(matrixComponent.isSquare());

		// Check name, description, and Id - Should match the super
		// constructor's (JanuaryObject) info
		assertEquals(JanuaryObject.getName(), matrixComponent.getName());
		assertEquals(JanuaryObject.getId(), matrixComponent.getId());
		assertEquals(JanuaryObject.getDescription(),
				matrixComponent.getDescription());

		// isSquared Constructor and allowedValueType - Continuous, setting
		// isSquared to true
		matrixComponent = new MatrixComponent(true, AllowedValueType.Continuous);

		// Make sure it is not null
		assertNotNull(matrixComponent);

		// Square should be false
		assertTrue(matrixComponent.isSquare());

		// Check name, description, and Id - Should match the super
		// constructor's (JanuaryObject) info
		assertEquals(JanuaryObject.getName(), matrixComponent.getName());
		assertEquals(JanuaryObject.getId(), matrixComponent.getId());
		assertEquals(JanuaryObject.getDescription(),
				matrixComponent.getDescription());

	}

	/**
	 * <p>
	 * This method checks that if a MatrixComponent is constructed with the
	 * isSquare attribute true, it retains that data and returns true for the
	 * isSquare method.
	 * </p>
	 * 
	 */
	@Test
	public void checkIsSquare() {
		// Use nullery constructor - isSquared should be false
		matrixComponent = new MatrixComponent();
		assertFalse(matrixComponent.isSquare());

		// Use nonnullery constructor - set isSquared to false. Should be false
		matrixComponent = new MatrixComponent(false);
		assertFalse(matrixComponent.isSquare());

		// Use nonnullery constructor - set isSquared to true. Should be true
		matrixComponent = new MatrixComponent(true);
		assertTrue(matrixComponent.isSquare());

		// Use nonnullery allowedValueTypes constructor - set isSquared to
		// false. Should be false
		matrixComponent = new MatrixComponent(false,
				AllowedValueType.Continuous);
		assertFalse(matrixComponent.isSquare());

		// Use nonnullery allowedValueTypes constructor - set isSquared to true.
		// Should be true
		matrixComponent = new MatrixComponent(true, AllowedValueType.Discrete);
		assertTrue(matrixComponent.isSquare());

	}

	/**
	 * <p>
	 * This method checks that users can add and remove rows for a general nxm,
	 * non-square matrix. It also asserts that its default values on those newly
	 * added rows are correct according to its AllowedValueType.
	 * </p>
	 * 
	 */
	@Test
	public void checkRowResize() {
		// Local Declarations
		ArrayList<Double> row1;
		ArrayList<Double> row2;
		ArrayList<Double> row3;
		ArrayList<Double> row4;
		ArrayList<Double> rowTemplate;
		ArrayList<Double> badRowTemplateContinuous;

		// Make a matrixComponent
		// Nullery - Undefinied and isSquared - false
		matrixComponent = new MatrixComponent();
		// A new matrix Component that is empty will have a rowSize of 1, and a
		// colSize of 1
		assertEquals(1, matrixComponent.numberOfColumns());
		assertEquals(1, matrixComponent.numberOfRows());

		// You can't delete the first row if it is a 1x1 matrix!
		assertFalse(matrixComponent.deleteRow());

		// Check for rows: negative and out of range
		assertNull(matrixComponent.getRow(-1));
		assertNull(matrixComponent.getRow(100));

		// add rows. The rows should return a value to each new row
		// index added
		assertEquals(1, matrixComponent.addRow());
		assertEquals(2, matrixComponent.addRow());
		assertEquals(3, matrixComponent.addRow());

		// Number of rows and columns
		assertEquals(4, matrixComponent.numberOfRows(), 0);
		assertEquals(1, matrixComponent.numberOfColumns(), 0);

		// Add some columns -> for testing
		assertEquals(1, matrixComponent.addColumn());
		assertEquals(2, matrixComponent.addColumn());

		// Number of rows and columns
		assertEquals(4, matrixComponent.numberOfRows());
		assertEquals(3, matrixComponent.numberOfColumns());

		// Check the value on the rows
		row1 = matrixComponent.getRow(0);
		row2 = matrixComponent.getRow(1);
		row3 = matrixComponent.getRow(2);
		row4 = matrixComponent.getRow(3);

		// Check values of rows:
		// Not null - they exist
		assertNotNull(row1);
		assertNotNull(row2);
		assertNotNull(row3);
		assertNotNull(row4);

		// check the values of each row:
		// row1
		assertEquals(3, row1.size());
		assertEquals(0.0, row1.get(0), 0.0);
		assertEquals(0.0, row1.get(1), 0.0);
		assertEquals(0.0, row1.get(2), 0.0);

		// row2
		assertEquals(3.0, row2.size(), 0.0);
		assertEquals(0.0, row2.get(0), 0.0);
		assertEquals(0.0, row2.get(1), 0.0);
		assertEquals(0.0, row2.get(2), 0.0);

		// row3
		assertEquals(3.0, row3.size(), 0.0);
		assertEquals(0.0, row3.get(0), 0.0);
		assertEquals(0.0, row3.get(1), 0.0);
		assertEquals(0.0, row3.get(2), 0.0);

		// row4
		assertEquals(3.0, row4.size(), 0.0);
		assertEquals(0.0, row4.get(0), 0.0);
		assertEquals(0.0, row4.get(1), 0.0);
		assertEquals(0.0, row4.get(2), 0.0);

		// delete all rows- all four rows should be gone
		assertTrue(matrixComponent.deleteRow());
		assertTrue(matrixComponent.deleteRow());
		assertTrue(matrixComponent.deleteRow());
		assertTrue(matrixComponent.deleteRow());

		// Check that there still remains a 1x1 matrix
		assertEquals(1, matrixComponent.numberOfRows());
		assertEquals(1, matrixComponent.numberOfColumns());

		// reset values
		row1 = null;
		row2 = null;
		row3 = null;
		row4 = null;
		matrixComponent = null;
		badRowTemplateContinuous = new ArrayList<Double>();
		rowTemplate = new ArrayList<Double>();

		// Non nullery constructor - Continuous and isSquared - false
		matrixComponent = new MatrixComponent(false,
				AllowedValueType.Continuous);
		// A new matrix Component that is empty will have a rowSize of 1, and a
		// colSize of 1
		assertEquals(1, matrixComponent.numberOfColumns());
		assertEquals(1, matrixComponent.numberOfRows());

		// Add a row without setting the default value - FAILS!
		assertEquals(-1, matrixComponent.addRow());

		// Need to set the default value. Try to pass a bad template - nothing
		// is set
		badRowTemplateContinuous.add(0.0);
		matrixComponent.setAllowedValues(badRowTemplateContinuous);

		// Proving that the values are not set
		assertEquals(-1, matrixComponent.addRow());

		// null check
		matrixComponent.setAllowedValues(null);

		// Proving that the values are not set
		assertEquals(-1, matrixComponent.addRow());

		// Setting it properly
		rowTemplate.add(1.0);
		rowTemplate.add(10.0);
		matrixComponent.setAllowedValues(rowTemplate);

		// Check that the values are set correctly when it is loaded with new
		// allowedvalues
		assertEquals(1.0, matrixComponent.getRow(0).get(0), 0.0);

		// add rows
		assertEquals(1, matrixComponent.addRow());
		assertEquals(2, matrixComponent.addRow());
		assertEquals(3, matrixComponent.addRow());

		// Number of rows and columns
		assertEquals(4, matrixComponent.numberOfRows());
		assertEquals(1, matrixComponent.numberOfColumns());

		// Add some columns -> for testing
		assertEquals(1, matrixComponent.addColumn());
		assertEquals(2, matrixComponent.addColumn());

		// Number of rows and columns
		assertEquals(4, matrixComponent.numberOfRows());
		assertEquals(3, matrixComponent.numberOfColumns());

		// Check the value on the rows
		row1 = matrixComponent.getRow(0);
		row2 = matrixComponent.getRow(1);
		row3 = matrixComponent.getRow(2);
		row4 = matrixComponent.getRow(3);

		// Check values of rows:
		// Not null - they exist
		assertNotNull(row1);
		assertNotNull(row2);
		assertNotNull(row3);
		assertNotNull(row4);

		// check the values of each row:
		// row1
		assertEquals(1.0, row1.get(0), 0.0);
		assertEquals(1.0, row1.get(1), 0.0);
		assertEquals(1.0, row1.get(2), 0.0);

		// row2
		assertEquals(1.0, row2.get(0), 0.0);
		assertEquals(1.0, row2.get(1), 0.0);
		assertEquals(1.0, row2.get(2), 0.0);

		// row3
		assertEquals(1.0, row3.get(0), 0.0);
		assertEquals(1.0, row3.get(1), 0.0);
		assertEquals(1.0, row3.get(2), 0.0);

		// row4
		assertEquals(1.0, row4.get(0), 0.0);
		assertEquals(1.0, row4.get(1), 0.0);
		assertEquals(1.0, row4.get(2), 0.0);

		// delete all rows- all four rows should be gone
		assertTrue(matrixComponent.deleteRow());
		assertTrue(matrixComponent.deleteRow());
		assertTrue(matrixComponent.deleteRow());
		assertTrue(matrixComponent.deleteRow());

		// Check that there still remains a 1x1 matrix
		assertEquals(1, matrixComponent.numberOfColumns());
		assertEquals(1, matrixComponent.numberOfRows());

		// Check to make sure it is loaded with default values after deleting
		// everything
		// Check that the values are set correctly when it is loaded with new
		// allowedvalues
		assertEquals(1.0, matrixComponent.getRow(0).get(0), 0.0);

		// reset values
		row1 = null;
		row2 = null;
		row3 = null;
		row4 = null;
		matrixComponent = null;
		badRowTemplateContinuous = new ArrayList<Double>();
		rowTemplate = new ArrayList<Double>();

		// Non nullery constructory - Discrete and isSquared - false
		matrixComponent = new MatrixComponent(false, AllowedValueType.Discrete);
		// A new matrix Component that is empty will have a rowSize of 1, and a
		// colSize of 1
		assertEquals(1, matrixComponent.numberOfColumns());
		assertEquals(1, matrixComponent.numberOfRows());

		// Add a row without setting the default value - FAILS!
		assertEquals(-1, matrixComponent.addRow());

		// Try to pass null
		matrixComponent.setAllowedValues(null);

		// Proving that the values are not set
		assertEquals(-1, matrixComponent.addRow());

		// Setting it properly
		rowTemplate.add(1.0);
		rowTemplate.add(10.0);
		matrixComponent.setAllowedValues(rowTemplate);

		// Check that the values are set correctly when it is loaded with new
		// allowedvalues
		assertEquals(1.0, matrixComponent.getRow(0).get(0), 0.0);

		// add rows
		assertEquals(1, matrixComponent.addRow());
		assertEquals(2, matrixComponent.addRow());
		assertEquals(3, matrixComponent.addRow());

		// Number of rows and columns
		assertEquals(4, matrixComponent.numberOfRows());
		assertEquals(1, matrixComponent.numberOfColumns());

		// Add some columns -> for testing
		assertEquals(1, matrixComponent.addColumn());
		assertEquals(2, matrixComponent.addColumn());

		// Number of rows and columns
		assertEquals(4, matrixComponent.numberOfRows());
		assertEquals(3, matrixComponent.numberOfColumns());

		// Check the value on the rows
		row1 = matrixComponent.getRow(0);
		row2 = matrixComponent.getRow(1);
		row3 = matrixComponent.getRow(2);
		row4 = matrixComponent.getRow(3);

		// Check values of rows:
		// Not null - they exist
		assertNotNull(row1);
		assertNotNull(row2);
		assertNotNull(row3);
		assertNotNull(row4);

		// check the values of each row:
		// row1
		assertEquals(1.0, row1.get(0), 0.0);
		assertEquals(1.0, row1.get(1), 0.0);
		assertEquals(1.0, row1.get(2), 0.0);

		// row2
		assertEquals(1.0, row2.get(0), 0.0);
		assertEquals(1.0, row2.get(1), 0.0);
		assertEquals(1.0, row2.get(2), 0.0);

		// row3
		assertEquals(1.0, row3.get(0), 0.0);
		assertEquals(1.0, row3.get(1), 0.0);
		assertEquals(1.0, row3.get(2), 0.0);

		// row4
		assertEquals(1.0, row4.get(0), 0.0);
		assertEquals(1.0, row4.get(1), 0.0);
		assertEquals(1.0, row4.get(2), 0.0);

		// delete all rows- all four rows should be gone
		assertTrue(matrixComponent.deleteRow());
		assertTrue(matrixComponent.deleteRow());
		assertTrue(matrixComponent.deleteRow());
		assertTrue(matrixComponent.deleteRow());

		// Check that there still remains a 1x1 matrix
		assertEquals(1, matrixComponent.numberOfColumns());
		assertEquals(1, matrixComponent.numberOfRows());

		// Make sure it is the defaul value:
		// Check that the values are set correctly when it is loaded with new
		// allowedvalues
		assertEquals(1.0, matrixComponent.getRow(0).get(0), 0.0);

		// reset values
		row1 = null;
		row2 = null;
		row3 = null;
		row4 = null;
		matrixComponent = null;
		badRowTemplateContinuous = new ArrayList<Double>();
		rowTemplate = new ArrayList<Double>();

	}

	/**
	 * <p>
	 * This method checks that adding a row to a square MatrixComponent also
	 * adds a column, and that all newly added values are correctly set with the
	 * correct default value.
	 * </p>
	 * 
	 */
	@Test
	public void checkRowSquareResize() {
		// Local Declarations
		ArrayList<Double> row1;
		ArrayList<Double> row2;
		ArrayList<Double> row3;
		ArrayList<Double> row4;
		ArrayList<Double> rowTemplate;
		ArrayList<Double> badRowTemplateContinuous;

		// Make a matrixComponent
		// Non Nullery - Undefinied and isSquared - true
		matrixComponent = new MatrixComponent(true, AllowedValueType.Undefined);
		// A new matrix Component that is empty will have a rowSize of 1, and a
		// colSize of 1
		assertEquals(1, matrixComponent.numberOfColumns());
		assertEquals(1, matrixComponent.numberOfRows());

		// You can't delete the first row if it is a 1x1 matrix!
		assertFalse(matrixComponent.deleteRow());

		// Check for rows: negative and out of range
		assertNull(matrixComponent.getRow(-1));
		assertNull(matrixComponent.getRow(100));

		// add rows
		assertEquals(1, matrixComponent.addRow());
		assertEquals(2, matrixComponent.addRow());
		assertEquals(3, matrixComponent.addRow());

		// Number of rows and columns
		assertEquals(4, matrixComponent.numberOfRows());
		assertEquals(4, matrixComponent.numberOfColumns());

		// Check the value on the rows
		row1 = matrixComponent.getRow(0);
		row2 = matrixComponent.getRow(1);
		row3 = matrixComponent.getRow(2);
		row4 = matrixComponent.getRow(3);

		// Check values of rows:
		// Not null - they exist
		assertNotNull(row1);
		assertNotNull(row2);
		assertNotNull(row3);
		assertNotNull(row4);

		// check the values of each row:
		// row1
		assertEquals(0.0, row1.get(0), 0.0);
		assertEquals(0.0, row1.get(1), 0.0);
		assertEquals(0.0, row1.get(2), 0.0);
		assertEquals(0.0, row1.get(3), 0.0);

		// row2
		assertEquals(0.0, row2.get(0), 0.0);
		assertEquals(0.0, row2.get(1), 0.0);
		assertEquals(0.0, row2.get(2), 0.0);
		assertEquals(0.0, row2.get(3), 0.0);

		// row3
		assertEquals(0.0, row3.get(0), 0.0);
		assertEquals(0.0, row3.get(1), 0.0);
		assertEquals(0.0, row3.get(2), 0.0);
		assertEquals(0.0, row3.get(3), 0.0);

		// row4
		assertEquals(0.0, row4.get(0), 0.0);
		assertEquals(0.0, row4.get(1), 0.0);
		assertEquals(0.0, row4.get(2), 0.0);
		assertEquals(0.0, row4.get(3), 0.0);

		// delete all rows and cols- all four rows and cols should be gone
		assertTrue(matrixComponent.deleteRow());
		assertTrue(matrixComponent.deleteRow());
		assertTrue(matrixComponent.deleteRow());

		// Check that there still remains a 1x1 matrix
		assertEquals(1, matrixComponent.numberOfColumns());
		assertEquals(1, matrixComponent.numberOfRows());

		// reset values
		row1 = null;
		row2 = null;
		row3 = null;
		row4 = null;
		matrixComponent = null;
		badRowTemplateContinuous = new ArrayList<Double>();
		rowTemplate = new ArrayList<Double>();

		// Non nullery constructor - Continuous and isSquared - true
		matrixComponent = new MatrixComponent(true, AllowedValueType.Continuous);
		// A new matrix Component that is empty will have a rowSize of 1, and a
		// colSize of 1
		assertEquals(1, matrixComponent.numberOfColumns());
		assertEquals(1, matrixComponent.numberOfRows());

		// Add a row without setting the default value - FAILS!
		assertEquals(-1, matrixComponent.addRow());

		// Need to set the default value. Try to pass a bad template - nothing
		// is set
		badRowTemplateContinuous.add(0.0);
		matrixComponent.setAllowedValues(badRowTemplateContinuous);

		// Proving that the values are not set
		assertEquals(-1, matrixComponent.addRow());

		// null check
		matrixComponent.setAllowedValues(null);

		// Proving that the values are not set
		assertEquals(-1, matrixComponent.addRow());

		// Setting it properly
		rowTemplate.add(1.0);
		rowTemplate.add(10.0);
		matrixComponent.setAllowedValues(rowTemplate);

		// Check that the values are set correctly when it is loaded with new
		// allowedvalues
		assertEquals(1.0, matrixComponent.getRow(0).get(0), 0.0);

		// add rows
		assertEquals(1, matrixComponent.addRow());
		assertEquals(2, matrixComponent.addRow());
		assertEquals(3, matrixComponent.addRow());

		// Print out row

		// Number of rows and columns
		assertEquals(4, matrixComponent.numberOfRows());
		assertEquals(4, matrixComponent.numberOfColumns());

		// Check the value on the rows
		row1 = matrixComponent.getRow(0);
		row2 = matrixComponent.getRow(1);
		row3 = matrixComponent.getRow(2);
		row4 = matrixComponent.getRow(3);

		// Check values of rows:
		// Not null - they exist
		assertNotNull(row1);
		assertNotNull(row2);
		assertNotNull(row3);
		assertNotNull(row4);

		// check the values of each row:
		// row1
		assertEquals(1.0, row1.get(0), 0.0);
		assertEquals(1.0, row1.get(1), 0.0);
		assertEquals(1.0, row1.get(2), 0.0);
		assertEquals(1.0, row1.get(3), 0.0);

		// row2
		assertEquals(1.0, row2.get(0), 0.0);
		assertEquals(1.0, row2.get(1), 0.0);
		assertEquals(1.0, row2.get(2), 0.0);
		assertEquals(1.0, row2.get(3), 0.0);

		// row3
		assertEquals(1.0, row3.get(0), 0.0);
		assertEquals(1.0, row3.get(1), 0.0);
		assertEquals(1.0, row3.get(2), 0.0);
		assertEquals(1.0, row3.get(3), 0.0);

		// row4
		assertEquals(1.0, row4.get(0), 0.0);
		assertEquals(1.0, row4.get(1), 0.0);
		assertEquals(1.0, row4.get(2), 0.0);
		assertEquals(1.0, row4.get(3), 0.0);

		// delete all rows and cols - all four rows and cols should be gone
		assertTrue(matrixComponent.deleteRow());
		assertTrue(matrixComponent.deleteRow());
		assertTrue(matrixComponent.deleteRow());

		// Check that there still remains a 1x1 matrix
		assertEquals(1, matrixComponent.numberOfColumns());
		assertEquals(1, matrixComponent.numberOfRows());

		// Check to make sure it is loaded with default values after deleting
		// everything
		// Check that the values are set correctly when it is loaded with new
		// allowedvalues
		assertEquals(1.0, matrixComponent.getRow(0).get(0), 0.0);

		// reset values
		row1 = null;
		row2 = null;
		row3 = null;
		row4 = null;
		matrixComponent = null;
		badRowTemplateContinuous = new ArrayList<Double>();
		rowTemplate = new ArrayList<Double>();

		// Non nullery constructory - Discrete and isSquared - true
		matrixComponent = new MatrixComponent(true, AllowedValueType.Discrete);
		// A new matrix Component that is empty will have a rowSize of 1, and a
		// colSize of 1
		assertEquals(1, matrixComponent.numberOfColumns());
		assertEquals(1, matrixComponent.numberOfRows());

		// Add a row without setting the default value - FAILS!
		assertEquals(-1, matrixComponent.addRow());

		// Try to pass null
		matrixComponent.setAllowedValues(null);

		// Proving that the values are not set
		assertEquals(-1, matrixComponent.addRow());

		// Setting it properly
		rowTemplate.add(1.0);
		rowTemplate.add(10.0);
		matrixComponent.setAllowedValues(rowTemplate);

		// Check that the values are set correctly when it is loaded with new
		// allowedvalues
		assertEquals(1.0, matrixComponent.getRow(0).get(0), 0.0);

		// add rows
		assertEquals(1, matrixComponent.addRow());
		assertEquals(2, matrixComponent.addRow());
		assertEquals(3, matrixComponent.addRow());

		// Number of rows and columns
		assertEquals(4, matrixComponent.numberOfRows());
		assertEquals(4, matrixComponent.numberOfColumns());

		// Check the value on the rows
		row1 = matrixComponent.getRow(0);
		row2 = matrixComponent.getRow(1);
		row3 = matrixComponent.getRow(2);
		row4 = matrixComponent.getRow(3);

		// Check values of rows:
		// Not null - they exist
		assertNotNull(row1);
		assertNotNull(row2);
		assertNotNull(row3);
		assertNotNull(row4);

		// check the values of each row:
		// row1
		assertEquals(1.0, row1.get(0), 0.0);
		assertEquals(1.0, row1.get(1), 0.0);
		assertEquals(1.0, row1.get(2), 0.0);
		assertEquals(1.0, row1.get(3), 0.0);

		// row2
		assertEquals(1.0, row2.get(0), 0.0);
		assertEquals(1.0, row2.get(1), 0.0);
		assertEquals(1.0, row2.get(2), 0.0);
		assertEquals(1.0, row2.get(3), 0.0);

		// row3
		assertEquals(1.0, row3.get(0), 0.0);
		assertEquals(1.0, row3.get(1), 0.0);
		assertEquals(1.0, row3.get(2), 0.0);
		assertEquals(1.0, row3.get(3), 0.0);

		// row4
		assertEquals(1.0, row4.get(0), 0.0);
		assertEquals(1.0, row4.get(1), 0.0);
		assertEquals(1.0, row4.get(2), 0.0);
		assertEquals(1.0, row4.get(3), 0.0);

		// delete all rows and cols- all four rows and cols should be gone
		assertTrue(matrixComponent.deleteRow());
		assertTrue(matrixComponent.deleteRow());
		assertTrue(matrixComponent.deleteRow());

		// Check that there still remains a 1x1 matrix
		assertEquals(1, matrixComponent.numberOfColumns());
		assertEquals(1, matrixComponent.numberOfRows());

		// Make sure it is the defaul value:
		// Check that the values are set correctly when it is loaded with new
		// allowedvalues
		assertEquals(1.0, matrixComponent.getRow(0).get(0), 0.0);

		// reset values
		row1 = null;
		row2 = null;
		row3 = null;
		row4 = null;
		matrixComponent = null;
		badRowTemplateContinuous = new ArrayList<Double>();
		rowTemplate = new ArrayList<Double>();

	}

	/**
	 * <p>
	 * This method checks that columns can be added or removed from this
	 * non-square MatrixComponent. It also checks that the new values are set to
	 * the correct default values.
	 * </p>
	 * 
	 */
	@Test
	public void checkColumnResize() {
		// Local Declarations
		ArrayList<Double> col1;
		ArrayList<Double> col2;
		ArrayList<Double> col3;
		ArrayList<Double> col4;
		ArrayList<Double> colTemplate;
		ArrayList<Double> badColTemplateContinuous;

		// Make a matrixComponent
		// Nullery - Undefinied and isSquared - false
		matrixComponent = new MatrixComponent();
		// A new matrix Component that is empty will have a rowSize of 1, and a
		// colSize of 1
		assertEquals(1, matrixComponent.numberOfColumns());
		assertEquals(1, matrixComponent.numberOfRows());

		// You can't delete the first column if it is a 1x1 matrix!
		assertFalse(matrixComponent.deleteColumn());

		// Check for columns: negative and out of range
		assertNull(matrixComponent.getColumn(-1));
		assertNull(matrixComponent.getColumn(100));

		// add columns
		assertEquals(1, matrixComponent.addColumn());
		assertEquals(2, matrixComponent.addColumn());
		assertEquals(3, matrixComponent.addColumn());

		// Number of rows and columns
		assertEquals(1, matrixComponent.numberOfRows());
		assertEquals(4, matrixComponent.numberOfColumns());

		// Add some rows -> for testing
		assertEquals(1, matrixComponent.addRow());
		assertEquals(2, matrixComponent.addRow());

		// Number of rows and columns
		assertEquals(3, matrixComponent.numberOfRows());
		assertEquals(4, matrixComponent.numberOfColumns());

		// Check the value on the columns
		col1 = matrixComponent.getColumn(0);
		col2 = matrixComponent.getColumn(1);
		col3 = matrixComponent.getColumn(2);
		col4 = matrixComponent.getColumn(3);

		// Check values of columns:
		// Not null - they exist
		assertNotNull(col1);
		assertNotNull(col2);
		assertNotNull(col3);
		assertNotNull(col4);

		// check the values of each column:
		// column1
		assertEquals(0.0, col1.get(0), 0.0);
		assertEquals(0.0, col1.get(1), 0.0);
		assertEquals(0.0, col1.get(2), 0.0);

		// column2
		assertEquals(0.0, col2.get(0), 0.0);
		assertEquals(0.0, col2.get(1), 0.0);
		assertEquals(0.0, col2.get(2), 0.0);

		// column3
		assertEquals(0.0, col3.get(0), 0.0);
		assertEquals(0.0, col3.get(1), 0.0);
		assertEquals(0.0, col3.get(2), 0.0);

		// column4
		assertEquals(0.0, col4.get(0), 0.0);
		assertEquals(0.0, col4.get(1), 0.0);
		assertEquals(0.0, col4.get(2), 0.0);

		// delete all column- all four columns should be gone
		assertTrue(matrixComponent.deleteColumn());
		assertTrue(matrixComponent.deleteColumn());
		assertTrue(matrixComponent.deleteColumn());
		assertTrue(matrixComponent.deleteColumn());

		// Check that there still remains a 1x1 matrix
		assertEquals(1, matrixComponent.numberOfColumns());
		assertEquals(1, matrixComponent.numberOfRows());

		// reset values
		col1 = null;
		col2 = null;
		col3 = null;
		col4 = null;
		matrixComponent = null;
		badColTemplateContinuous = new ArrayList<Double>();
		colTemplate = new ArrayList<Double>();

		// Non nullery constructor - Continuous and isSquared - false
		matrixComponent = new MatrixComponent(false,
				AllowedValueType.Continuous);
		// A new matrix Component that is empty will have a rowSize of 1, and a
		// colSize of 1
		assertEquals(1, matrixComponent.numberOfColumns());
		assertEquals(1, matrixComponent.numberOfRows());

		// Add a column without setting the default value - FAILS!
		assertEquals(-1, matrixComponent.addColumn());

		// Need to set the default value. Try to pass a bad template - nothing
		// is set
		badColTemplateContinuous.add(0.0);
		matrixComponent.setAllowedValues(badColTemplateContinuous);

		// Proving that the values are not set
		assertEquals(-1, matrixComponent.addColumn());

		// null check
		matrixComponent.setAllowedValues(null);

		// Proving that the values are not set
		assertEquals(-1, matrixComponent.addColumn());

		// Setting it properly
		colTemplate.add(1.0);
		colTemplate.add(10.0);
		matrixComponent.setAllowedValues(colTemplate);

		// Check that the values are set correctly when it is loaded with new
		// allowedvalues
		assertEquals(1.0, matrixComponent.getColumn(0).get(0), 0.0);

		// add Column
		assertEquals(1, matrixComponent.addColumn());
		assertEquals(2, matrixComponent.addColumn());
		assertEquals(3, matrixComponent.addColumn());

		// Number of rows and columns
		assertEquals(1, matrixComponent.numberOfRows());
		assertEquals(4, matrixComponent.numberOfColumns());

		// Add some rows -> for testing
		assertEquals(1, matrixComponent.addRow());
		assertEquals(2, matrixComponent.addRow());

		// Number of rows and columns
		assertEquals(3, matrixComponent.numberOfRows());
		assertEquals(4, matrixComponent.numberOfColumns());

		// Check the value on the column
		col1 = matrixComponent.getColumn(0);
		col2 = matrixComponent.getColumn(1);
		col3 = matrixComponent.getColumn(2);
		col4 = matrixComponent.getColumn(3);

		// Make sure that it catches this
		matrixComponent.getColumn(4);
		matrixComponent.getRow(3);

		// Check values of columns:
		// Not null - they exist
		assertNotNull(col1);
		assertNotNull(col2);
		assertNotNull(col3);
		assertNotNull(col4);

		// check the values of each column:
		// column1
		assertEquals(1.0, col1.get(0), 0.0);
		assertEquals(1.0, col1.get(1), 0.0);
		assertEquals(1.0, col1.get(2), 0.0);

		// column2
		assertEquals(1.0, col2.get(0), 0.0);
		assertEquals(1.0, col2.get(1), 0.0);
		assertEquals(1.0, col2.get(2), 0.0);

		// column3
		assertEquals(1.0, col3.get(0), 0.0);
		assertEquals(1.0, col3.get(1), 0.0);
		assertEquals(1.0, col3.get(2), 0.0);

		// column4
		assertEquals(1.0, col4.get(0), 0.0);
		assertEquals(1.0, col4.get(1), 0.0);
		assertEquals(1.0, col4.get(2), 0.0);

		// delete all column- all four column should be gone
		assertTrue(matrixComponent.deleteColumn());
		assertTrue(matrixComponent.deleteColumn());
		assertTrue(matrixComponent.deleteColumn());
		assertTrue(matrixComponent.deleteColumn());

		// Check that there still remains a 1x1 matrix
		assertEquals(1, matrixComponent.numberOfColumns());
		assertEquals(1, matrixComponent.numberOfRows());

		// Check to make sure it is loaded with default values after deleting
		// everything
		// Check that the values are set correctly when it is loaded with new
		// allowedvalues
		assertEquals(1.0, matrixComponent.getColumn(0).get(0), 0.0);

		// reset values
		col1 = null;
		col2 = null;
		col3 = null;
		col4 = null;
		matrixComponent = null;
		badColTemplateContinuous = new ArrayList<Double>();
		colTemplate = new ArrayList<Double>();

		// Non nullery constructory - Discrete and isSquared - false
		matrixComponent = new MatrixComponent(false, AllowedValueType.Discrete);
		// A new matrix Component that is empty will have a rowSize of 1, and a
		// colSize of 1
		assertEquals(1, matrixComponent.numberOfColumns());
		assertEquals(1, matrixComponent.numberOfRows());

		// Add a column without setting the default value - FAILS!
		assertEquals(-1, matrixComponent.addColumn());

		// Try to pass null
		matrixComponent.setAllowedValues(null);

		// Proving that the values are not set
		assertEquals(-1, matrixComponent.addColumn());

		// Setting it properly
		colTemplate.add(1.0);
		colTemplate.add(10.0);
		matrixComponent.setAllowedValues(colTemplate);

		// Check that the values are set correctly when it is loaded with new
		// allowedvalues
		assertEquals(1.0, matrixComponent.getColumn(0).get(0), 0.0);

		// add column
		assertEquals(1, matrixComponent.addColumn());
		assertEquals(2, matrixComponent.addColumn());
		assertEquals(3, matrixComponent.addColumn());

		// Number of rows and columns
		assertEquals(1, matrixComponent.numberOfRows());
		assertEquals(4, matrixComponent.numberOfColumns());

		// Add some rows -> for testing
		assertEquals(1, matrixComponent.addRow());
		assertEquals(2, matrixComponent.addRow());

		// Number of rows and columns
		assertEquals(3, matrixComponent.numberOfRows());
		assertEquals(4, matrixComponent.numberOfColumns());

		// Check the value on the columns
		col1 = matrixComponent.getColumn(0);
		col2 = matrixComponent.getColumn(1);
		col3 = matrixComponent.getColumn(2);
		col4 = matrixComponent.getColumn(3);

		// Check values of columns:
		// Not null - they exist
		assertNotNull(col1);
		assertNotNull(col2);
		assertNotNull(col3);
		assertNotNull(col4);

		// check the values of each column:
		// column1
		assertEquals(1.0, col1.get(0), 0.0);
		assertEquals(1.0, col1.get(1), 0.0);
		assertEquals(1.0, col1.get(2), 0.0);

		// column2
		assertEquals(1.0, col2.get(0), 0.0);
		assertEquals(1.0, col2.get(1), 0.0);
		assertEquals(1.0, col2.get(2), 0.0);

		// column3
		assertEquals(1.0, col3.get(0), 0.0);
		assertEquals(1.0, col3.get(1), 0.0);
		assertEquals(1.0, col3.get(2), 0.0);

		// column4
		assertEquals(1.0, col4.get(0), 0.0);
		assertEquals(1.0, col4.get(1), 0.0);
		assertEquals(1.0, col4.get(2), 0.0);

		// delete all columns- all four columns should be gone
		assertTrue(matrixComponent.deleteColumn());
		assertTrue(matrixComponent.deleteColumn());
		assertTrue(matrixComponent.deleteColumn());
		assertTrue(matrixComponent.deleteColumn());

		// Check that there still remains a 1x1 matrix
		assertEquals(1, matrixComponent.numberOfColumns());
		assertEquals(1, matrixComponent.numberOfRows());

		// Make sure it is the default value:
		// Check that the values are set correctly when it is loaded with new
		// allowedvalues
		assertEquals(1.0, matrixComponent.getColumn(0).get(0), 0.0);

		// reset values
		col1 = null;
		col2 = null;
		col3 = null;
		col4 = null;
		matrixComponent = null;
		badColTemplateContinuous = new ArrayList<Double>();
		colTemplate = new ArrayList<Double>();

	}

	/**
	 * <p>
	 * This method checks that adding a column to the MatrixComponent correctly
	 * adds both a column and a row, and that all values are correcly set to
	 * their default values.
	 * </p>
	 * 
	 */
	@Test
	public void checkColumnSquareResize() {
		// Local Declarations
		ArrayList<Double> col1;
		ArrayList<Double> col2;
		ArrayList<Double> col3;
		ArrayList<Double> col4;
		ArrayList<Double> colTemplate;
		ArrayList<Double> badColTemplateContinuous;

		// Make a matrixComponent
		// Non-Nullery - Undefinied and isSquared - true
		matrixComponent = new MatrixComponent(true, AllowedValueType.Undefined);
		// A new matrix Component that is empty will have a rowSize of 1, and a
		// colSize of 1
		assertEquals(1, matrixComponent.numberOfColumns());
		assertEquals(1, matrixComponent.numberOfRows());

		// You can't delete the first column if it is a 1x1 matrix!
		assertFalse(matrixComponent.deleteColumn());

		// Check for columns: negative and out of range
		assertNull(matrixComponent.getColumn(-1));
		assertNull(matrixComponent.getColumn(100));

		// add columns
		assertEquals(1, matrixComponent.addColumn());
		assertEquals(2, matrixComponent.addColumn());
		assertEquals(3, matrixComponent.addColumn());

		// Number of rows and columns
		assertEquals(4, matrixComponent.numberOfRows());
		assertEquals(4, matrixComponent.numberOfColumns());

		// Check the value on the columns
		col1 = matrixComponent.getColumn(0);
		col2 = matrixComponent.getColumn(1);
		col3 = matrixComponent.getColumn(2);
		col4 = matrixComponent.getColumn(3);

		// Check values of columns:
		// Not null - they exist
		assertNotNull(col1);
		assertNotNull(col2);
		assertNotNull(col3);
		assertNotNull(col4);

		// check the values of each column:
		// column1
		assertEquals(0.0, col1.get(0), 0.0);
		assertEquals(0.0, col1.get(1), 0.0);
		assertEquals(0.0, col1.get(2), 0.0);
		assertEquals(0.0, col1.get(3), 0.0);

		// column2
		assertEquals(0.0, col2.get(0), 0.0);
		assertEquals(0.0, col2.get(1), 0.0);
		assertEquals(0.0, col2.get(2), 0.0);
		assertEquals(0.0, col2.get(3), 0.0);

		// column3
		assertEquals(0.0, col3.get(0), 0.0);
		assertEquals(0.0, col3.get(1), 0.0);
		assertEquals(0.0, col3.get(2), 0.0);
		assertEquals(0.0, col3.get(3), 0.0);

		// column4
		assertEquals(0.0, col4.get(0), 0.0);
		assertEquals(0.0, col4.get(1), 0.0);
		assertEquals(0.0, col4.get(2), 0.0);
		assertEquals(0.0, col4.get(3), 0.0);

		// delete all columns and rows- all four columns and rows should be gone
		assertTrue(matrixComponent.deleteColumn());
		assertTrue(matrixComponent.deleteColumn());
		assertTrue(matrixComponent.deleteColumn());

		// Check that there still remains a 1x1 matrix
		assertEquals(1, matrixComponent.numberOfColumns());
		assertEquals(1, matrixComponent.numberOfRows());

		// reset values
		col1 = null;
		col2 = null;
		col3 = null;
		col4 = null;
		matrixComponent = null;
		badColTemplateContinuous = new ArrayList<Double>();
		colTemplate = new ArrayList<Double>();

		// Non nullery constructor - Continuous and isSquared - true
		matrixComponent = new MatrixComponent(true, AllowedValueType.Continuous);
		// A new matrix Component that is empty will have a rowSize of 1, and a
		// colSize of 1
		assertEquals(1, matrixComponent.numberOfColumns());
		assertEquals(1, matrixComponent.numberOfRows());

		// Add a column without setting the default value - FAILS!
		assertEquals(-1, matrixComponent.addColumn());

		// Need to set the default value. Try to pass a bad template - nothing
		// is set
		badColTemplateContinuous.add(0.0);
		matrixComponent.setAllowedValues(badColTemplateContinuous);

		// Proving that the values are not set
		assertEquals(-1, matrixComponent.addColumn());

		// null check
		matrixComponent.setAllowedValues(null);

		// Proving that the values are not set
		assertEquals(-1, matrixComponent.addColumn());

		// Setting it properly
		colTemplate.add(1.0);
		colTemplate.add(10.0);
		matrixComponent.setAllowedValues(colTemplate);

		// Check that the values are set correctly when it is loaded with new
		// allowedvalues
		assertEquals(1.0, matrixComponent.getColumn(0).get(0), 0.0);

		// add Column
		assertEquals(1, matrixComponent.addColumn());
		assertEquals(2, matrixComponent.addColumn());
		assertEquals(3, matrixComponent.addColumn());

		// Number of rows and columns
		assertEquals(4, matrixComponent.numberOfRows());
		assertEquals(4, matrixComponent.numberOfColumns());

		// Check the value on the column
		col1 = matrixComponent.getColumn(0);
		col2 = matrixComponent.getColumn(1);
		col3 = matrixComponent.getColumn(2);
		col4 = matrixComponent.getColumn(3);

		// Check values of columns:
		// Not null - they exist
		assertNotNull(col1);
		assertNotNull(col2);
		assertNotNull(col3);
		assertNotNull(col4);

		// check the values of each column:
		// column1
		assertEquals(1.0, col1.get(0), 0.0);
		assertEquals(1.0, col1.get(1), 0.0);
		assertEquals(1.0, col1.get(2), 0.0);
		assertEquals(1.0, col1.get(3), 0.0);

		// column2
		assertEquals(1.0, col2.get(0), 0.0);
		assertEquals(1.0, col2.get(1), 0.0);
		assertEquals(1.0, col2.get(2), 0.0);
		assertEquals(1.0, col2.get(3), 0.0);

		// column3
		assertEquals(1.0, col3.get(0), 0.0);
		assertEquals(1.0, col3.get(1), 0.0);
		assertEquals(1.0, col3.get(2), 0.0);
		assertEquals(1.0, col3.get(3), 0.0);

		// column4
		assertEquals(1.0, col4.get(0), 0.0);
		assertEquals(1.0, col4.get(1), 0.0);
		assertEquals(1.0, col4.get(2), 0.0);
		assertEquals(1.0, col4.get(3), 0.0);

		// delete all column and rows- all four columns and rows should be gone
		assertTrue(matrixComponent.deleteColumn());
		assertTrue(matrixComponent.deleteColumn());
		assertTrue(matrixComponent.deleteColumn());

		// Check that there still remains a 1x1 matrix
		assertEquals(1, matrixComponent.numberOfColumns());
		assertEquals(1, matrixComponent.numberOfRows());

		// Check to make sure it is loaded with default values after deleting
		// everything
		// Check that the values are set correctly when it is loaded with new
		// allowedvalues
		assertEquals(1.0, matrixComponent.getColumn(0).get(0), 0.0);

		// reset values
		col1 = null;
		col2 = null;
		col3 = null;
		col4 = null;
		matrixComponent = null;
		badColTemplateContinuous = new ArrayList<Double>();
		colTemplate = new ArrayList<Double>();

		// Non nullery constructory - Discrete and isSquared - false
		matrixComponent = new MatrixComponent(true, AllowedValueType.Discrete);
		// A new matrix Component that is empty will have a rowSize of 1, and a
		// colSize of 1
		assertEquals(1, matrixComponent.numberOfColumns());
		assertEquals(1, matrixComponent.numberOfRows());

		// Add a column without setting the default value - FAILS!
		assertEquals(-1, matrixComponent.addColumn());

		// Try to pass null
		matrixComponent.setAllowedValues(null);

		// Proving that the values are not set
		assertEquals(-1, matrixComponent.addColumn());

		// Setting it properly
		colTemplate.add(1.0);
		colTemplate.add(10.0);
		matrixComponent.setAllowedValues(colTemplate);

		// Check that the values are set correctly when it is loaded with new
		// allowedvalues
		assertEquals(1.0, matrixComponent.getColumn(0).get(0), 0.0);

		// add column
		assertEquals(1, matrixComponent.addColumn());
		assertEquals(2, matrixComponent.addColumn());
		assertEquals(3, matrixComponent.addColumn());

		// Number of rows and columns
		assertEquals(4, matrixComponent.numberOfRows());
		assertEquals(4, matrixComponent.numberOfColumns());

		// Check the value on the columns
		col1 = matrixComponent.getColumn(0);
		col2 = matrixComponent.getColumn(1);
		col3 = matrixComponent.getColumn(2);
		col4 = matrixComponent.getColumn(3);

		// Check values of columns:
		// Not null - they exist
		assertNotNull(col1);
		assertNotNull(col2);
		assertNotNull(col3);
		assertNotNull(col4);

		// check the values of each column:
		// column1
		assertEquals(1.0, col1.get(0), 0.0);
		assertEquals(1.0, col1.get(1), 0.0);
		assertEquals(1.0, col1.get(2), 0.0);
		assertEquals(1.0, col1.get(3), 0.0);

		// column2
		assertEquals(1.0, col2.get(0), 0.0);
		assertEquals(1.0, col2.get(1), 0.0);
		assertEquals(1.0, col2.get(2), 0.0);
		assertEquals(1.0, col2.get(3), 0.0);

		// column3
		assertEquals(1.0, col3.get(0), 0.0);
		assertEquals(1.0, col3.get(1), 0.0);
		assertEquals(1.0, col3.get(2), 0.0);
		assertEquals(1.0, col3.get(3), 0.0);

		// column4
		assertEquals(1.0, col4.get(0), 0.0);
		assertEquals(1.0, col4.get(1), 0.0);
		assertEquals(1.0, col4.get(2), 0.0);
		assertEquals(1.0, col4.get(3), 0.0);

		// delete all columns- all four columns and rows should be gone
		assertTrue(matrixComponent.deleteColumn());
		assertTrue(matrixComponent.deleteColumn());
		assertTrue(matrixComponent.deleteColumn());

		// Check that there still remains a 1x1 matrix
		assertEquals(1, matrixComponent.numberOfColumns());
		assertEquals(1, matrixComponent.numberOfRows());

		// Make sure it is the default value:
		// Check that the values are set correctly when it is loaded with new
		// allowedvalues
		assertEquals(1.0, matrixComponent.getColumn(0).get(0), 0.0);

		// reset values
		col1 = null;
		col2 = null;
		col3 = null;
		col4 = null;
		matrixComponent = null;
		badColTemplateContinuous = new ArrayList<Double>();
		colTemplate = new ArrayList<Double>();

	}

	/**
	 * <p>
	 * An operation that checks the allowedValueTypes with the get/set
	 * operations for elements at their required index.
	 * </p>
	 * 
	 */
	@Test
	public void checkElementInsertion() {
		// Local Declarations
		ArrayList<Double> row1, row2, row3, row4;
		ArrayList<Double> rowTemplate;

		// Create a matrix - squared and Undefined type
		matrixComponent = new MatrixComponent(true, AllowedValueType.Undefined);

		// Add some rows and columns - 4x4 matrix
		matrixComponent.addRow();
		matrixComponent.addRow();
		matrixComponent.addRow();

		// Set some data - Lets make the identity matrix!
		assertTrue(matrixComponent.setElementValue(0, 0, 1.0));
		assertTrue(matrixComponent.setElementValue(1, 1, 1.0));
		assertTrue(matrixComponent.setElementValue(2, 2, 1.0));
		assertTrue(matrixComponent.setElementValue(3, 3, 1.0));

		// Check their values:

		// Check the value on the rows
		row1 = matrixComponent.getRow(0);
		row2 = matrixComponent.getRow(1);
		row3 = matrixComponent.getRow(2);
		row4 = matrixComponent.getRow(3);

		// Check values of rows:
		// Not null - they exist
		assertNotNull(row1);
		assertNotNull(row2);
		assertNotNull(row3);
		assertNotNull(row4);

		// check the values of each row:
		// row1
		assertEquals(1.0, row1.get(0), 0.0);
		assertEquals(0.0, row1.get(1), 0.0);
		assertEquals(0.0, row1.get(2), 0.0);
		assertEquals(0.0, row1.get(3), 0.0);

		// row2
		assertEquals(0.0, row2.get(0), 0.0);
		assertEquals(1.0, row2.get(1), 0.0);
		assertEquals(0.0, row2.get(2), 0.0);
		assertEquals(0.0, row2.get(3), 0.0);

		// row3
		assertEquals(0.0, row3.get(0), 0.0);
		assertEquals(0.0, row3.get(1), 0.0);
		assertEquals(1.0, row3.get(2), 0.0);
		assertEquals(0.0, row3.get(3), 0.0);

		// row4
		assertEquals(0.0, row4.get(0), 0.0);
		assertEquals(0.0, row4.get(1), 0.0);
		assertEquals(0.0, row4.get(2), 0.0);
		assertEquals(1.0, row4.get(3), 0.0);

		// Check values with the index check operator
		assertEquals(1.0, matrixComponent.getElementValue(0, 0), 0.0);
		assertEquals(1.0, matrixComponent.getElementValue(1, 1), 0.0);
		assertEquals(1.0, matrixComponent.getElementValue(2, 2), 0.0);
		assertEquals(1.0, matrixComponent.getElementValue(3, 3), 0.0);
		assertEquals(0.0, matrixComponent.getElementValue(2, 3), 0.0);

		// Delete a row and a columns Check values to make sure its still the
		// identity matrix
		matrixComponent.deleteColumn();

		// check values
		assertEquals(1.0, matrixComponent.getElementValue(0, 0), 0.0);
		assertEquals(1.0, matrixComponent.getElementValue(1, 1), 0.0);
		assertEquals(1.0, matrixComponent.getElementValue(2, 2), 0.0);
		assertEquals(0.0, matrixComponent.getElementValue(2, 1), 0.0);

		// Grab a value that does not exist in the table
		assertNull(matrixComponent.getElementValue(3, 3));

		// Try to set on something that does not exist
		assertFalse(matrixComponent.setElementValue(3, 3, 1.0));

		// Try to pass null into setElementValue - return false
		assertFalse(matrixComponent.setElementValue(2, 2, null));
		// Nothing changed - no null!
		assertEquals(1.0, matrixComponent.getElementValue(2, 2), 0.0);

		// Make a new matrixComponent - not squared, but Continuous
		matrixComponent = new MatrixComponent(false,
				AllowedValueType.Continuous);

		// Set Type
		rowTemplate = new ArrayList<Double>();
		rowTemplate.add(2.0);
		rowTemplate.add(12.0);
		matrixComponent.setAllowedValues(rowTemplate);

		// Add some rows and columns - 5x2 matrix
		matrixComponent.addRow();
		matrixComponent.addRow();
		matrixComponent.addRow();
		matrixComponent.addRow();
		matrixComponent.addColumn();

		// Try to insert a legal element
		assertTrue(matrixComponent.setElementValue(1, 1, 5.0));

		// Try to insert a illegal element - throw false
		assertFalse(matrixComponent.setElementValue(1, 1, 1.0));

		// Check the value, it should be 5.0
		assertEquals(5.0, matrixComponent.getElementValue(1, 1), 0.0);

		// Make a new matrixComponent - not squared, but Discrete
		matrixComponent = new MatrixComponent(false, AllowedValueType.Discrete);

		// Cant call get/set on a matrix that is not set correctly (Discrete or
		// Continuous values not set)
		assertFalse(matrixComponent.setElementValue(0, 0, 500.0));
		assertNull(matrixComponent.getElementValue(0, 0));

		// Set Type
		rowTemplate = new ArrayList<Double>();
		rowTemplate.add(1.0);
		rowTemplate.add(2.0);
		rowTemplate.add(9001.0);
		matrixComponent.setAllowedValues(rowTemplate);

		// Add some rows and columns - 4x2 matrix
		matrixComponent.addRow();
		matrixComponent.addRow();
		matrixComponent.addRow();
		matrixComponent.addColumn();

		// Try to insert a legal element
		assertTrue(matrixComponent.setElementValue(1, 1, 1.0));
		assertTrue(matrixComponent.setElementValue(1, 1, 2.0));
		assertTrue(matrixComponent.setElementValue(1, 1, 9001.0));

		// Try to insert a illegal element - throw false
		assertFalse(matrixComponent.setElementValue(1, 1, 0.0));

		// Check the value, it should be 5.0
		assertEquals(9001.0, matrixComponent.getElementValue(1, 1), 0.0);

		// Additional tests - Big test
		// Make a new matrixComponent - not squared, but Continuous
		matrixComponent = new MatrixComponent(false,
				AllowedValueType.Continuous);

		// Set Type
		rowTemplate = new ArrayList<Double>();
		rowTemplate.add(0.0);
		rowTemplate.add(10000000.0);
		matrixComponent.setAllowedValues(rowTemplate);

		// Add some rows and columns - 10x7 matrix
		matrixComponent.addRow();
		matrixComponent.addRow();
		matrixComponent.addRow();
		matrixComponent.addRow();
		matrixComponent.addRow();
		matrixComponent.addRow();
		matrixComponent.addRow();
		matrixComponent.addRow();
		matrixComponent.addRow();
		matrixComponent.addColumn();
		matrixComponent.addColumn();
		matrixComponent.addColumn();
		matrixComponent.addColumn();
		matrixComponent.addColumn();
		matrixComponent.addColumn();

		// Randomly set some matrices
		Random randomGenerator = new Random(123456);
		int indexArray[][] = new int[10][2];
		int row, col;
		boolean loop = true;
		double valuesArray[] = new double[10];

		// Loop to create random indexes.
		for (int i = 0; i < 10; i++) {
			row = randomGenerator.nextInt(9);
			col = randomGenerator.nextInt(6);

			// Makes sure the same index is not generated twice.
			while (loop) {
				for (int j = 0; j < 10; j++) {
					// If duplicate, reset
					if (indexArray[j][0] == row && indexArray[j][1] == col) {
						row = randomGenerator.nextInt(10);
						col = randomGenerator.nextInt(7);
						j = 0;
					}
				}
				// Not a duplicate, break
				loop = false;
			}

			indexArray[i][0] = row;
			indexArray[i][1] = col;
			loop = true;
		}

		// generate random values
		for (int i = 0; i < 10; i++) {
			valuesArray[i] = randomGenerator.nextDouble() * 10000000;
		}

		// Insert values into matrix and make sure it works
		for (int i = 0; i < 10; i++) {
			assertTrue(matrixComponent.setElementValue(indexArray[i][0],
					indexArray[i][1], valuesArray[i]));
		}

		// Check values
		for (int i = 0; i < 10; i++) {
			// Convert the values to string so that an accurate comparison can
			// be made without specifying a tolerance.
			String expected = String.valueOf(valuesArray[i]), actual = String
					.valueOf(matrixComponent.getElementValue(indexArray[i][0],
							indexArray[i][1]));
			// Check the values.
			assertEquals(expected, actual);
		}

	}

	/**
	 * <p>
	 * An operation that checks the resizable attribute.
	 * </p>
	 * 
	 */
	@Test
	public void checkResizable() {

		// If a row is not resizable, then rows and columns can not be added or
		// deleted

		matrixComponent = new MatrixComponent();

		// Add rows and columns 4x2 matrix
		matrixComponent.addRow();
		matrixComponent.addRow();
		matrixComponent.addRow();
		matrixComponent.addColumn();

		// Set resizable to false

		matrixComponent.setResizable(false);

		// Should be unable to add or delete rows
		assertEquals(-1, matrixComponent.addRow());
		assertFalse(matrixComponent.deleteRow());

		// Should be unable to add or delete columns
		assertEquals(-1, matrixComponent.addColumn());
		assertFalse(matrixComponent.deleteColumn());

		// Should still be a 4x2 matrix
		assertEquals(4, matrixComponent.numberOfRows());
		assertEquals(2, matrixComponent.numberOfColumns());

	}

	/**
	 * <p>
	 * An operation that checks the getAllowedValueType and getAllowedValues.
	 * </p>
	 * 
	 */
	@Test
	public void checkAllowedValues() {
		// Local Declarations
		ArrayList<Double> colTemplate = new ArrayList<Double>();

		// Create a matrix component
		matrixComponent = new MatrixComponent();

		// Check for Undefined. Allowed values should be null.
		assertEquals(AllowedValueType.Undefined,
				matrixComponent.getAllowedValueType());
		assertNull(matrixComponent.getAllowedValues()); // Null allowed values

		// Check for Continuous. Allowed values should be null, but setable!
		matrixComponent = new MatrixComponent(false,
				AllowedValueType.Continuous);
		assertEquals(AllowedValueType.Continuous,
				matrixComponent.getAllowedValueType());
		assertNull(matrixComponent.getAllowedValues());

		// Setting it properly - Allowed values for continuous
		colTemplate.add(2.0);
		colTemplate.add(11.0);
		// Set allowed values on matrixComponent
		matrixComponent.setAllowedValues(colTemplate);
		// Double check that it is continuous
		assertEquals(AllowedValueType.Continuous,
				matrixComponent.getAllowedValueType());
		// Check that the allowedValues are 2 and they are correct
		assertEquals(2, matrixComponent.getAllowedValues().size());
		assertEquals(2.0, matrixComponent.getAllowedValues().get(0), 0.0);
		assertEquals(11.0, matrixComponent.getAllowedValues().get(1), 0.0);

		// Check for Discrete. Check that the allowedvaluetype is discrete
		// and starts out null.
		matrixComponent = new MatrixComponent(false, AllowedValueType.Discrete);
		assertEquals(AllowedValueType.Discrete,
				matrixComponent.getAllowedValueType());
		assertNull(matrixComponent.getAllowedValues());

		// Setting it properly - Create template and add to component
		colTemplate.add(1.0); // appending to previous list.
		colTemplate.add(10.0);
		// Add allowed values to matrixcomponent
		matrixComponent.setAllowedValues(colTemplate);
		assertEquals(AllowedValueType.Discrete,
				matrixComponent.getAllowedValueType());
		// Check that there are 4 types of allowed values and they are correct
		assertEquals(4, matrixComponent.getAllowedValues().size());
		assertEquals(2.0, matrixComponent.getAllowedValues().get(0), 0.0);
		assertEquals(11.0, matrixComponent.getAllowedValues().get(1), 0.0);
		assertEquals(1.0, matrixComponent.getAllowedValues().get(2), 0.0);
		assertEquals(10.0, matrixComponent.getAllowedValues().get(3), 0.0);

	}
}