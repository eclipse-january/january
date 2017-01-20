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
package org.eclipse.ice.datastructures.test;

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

import javax.xml.bind.JAXBException;

import org.eclipse.january.form.ICEJAXBHandler;
import org.eclipse.january.form.IEntry;
import org.eclipse.january.form.StringEntry;
import org.eclipse.january.form.TableComponent;
import org.junit.Test;

/**
 * 
 * @author Jay Jay Billings
 */

public class TableComponentTester {
	/**
	 * <p>
	 * The TableComponent used in the test.
	 * </p>
	 * 
	 */
	private static TableComponent tableComponent;
	/**
	 * <p>
	 * An IComponentListener used to test notifications from the TableComponent.
	 * </p>
	 * 
	 */
	private TestComponentListener testComponentListener;
	/**
	 * <p>
	 * An IComponentVisitor used to test the ability of the TableComponent to be
	 * visited.
	 * </p>
	 * 
	 */
	private TestVisitor testVisitor;

	/**
	 * <p>
	 * This operation checks the TableComponent to make sure that setting the
	 * Row Template can only be done once and that the Row Template can be
	 * retrieved, but not manipulated. It also checks the name, id and
	 * description of the TableComponent.
	 * </p>
	 * 
	 */
	@Test
	public void checkConstruction() {
		// Local Declarations
		ArrayList<IEntry> template = new ArrayList<IEntry>();
		ArrayList<IEntry> template2 = new ArrayList<IEntry>();

		IEntry column1 = new StringEntry();
		IEntry column2 = new StringEntry();
		IEntry column3 = new StringEntry();

		IEntry column4 = new StringEntry();
		IEntry column5 = new StringEntry();
		IEntry column6 = new StringEntry();

		IEntry testColumn1, testColumn2, testColumn3 = null;

		// This test will verify a legal use of table component, append a row
		// template,
		// and set values. It will assert if they are correct.

		// create new tableComponent
		tableComponent = new TableComponent();

		// set tableComponent values for name, id, description
		tableComponent.setName("Table 1");
		tableComponent.setId(1);
		tableComponent.setDescription("This is a table that contains entries.");

		// Set row template - gather columns to table
		column1.setName("Column1");
		column1.setId(1);
		column1.setDescription("I am Column1!");
		column1.setValue("Over 9000!");

		column2.setName("Column2");
		column2.setId(2);
		column2.setDescription("I am Column2!");
		column2.setValue("Under 9000!");

		column3.setName("Column3");
		column3.setId(3);
		column3.setDescription("I am Column3!");
		column3.setValue("At 9000!");
		column3.setTag("HI!");
		// Add columns to template arraylist
		template.add(column1);
		template.add(column2);
		template.add(column3);

		// Add template to tableComponent
		tableComponent.setRowTemplate(template);
		template = null;

		// check current status
		// check table
		assertEquals("Table 1", tableComponent.getName());
		assertEquals(1, tableComponent.getId());
		assertEquals("This is a table that contains entries.",
				tableComponent.getDescription());

		// check row template, its entries, and columns
		template = tableComponent.getRowTemplate();
		assertNotNull(template);
		// Get columns
		testColumn1 = template.get(0);
		testColumn2 = template.get(1);
		testColumn3 = template.get(2);

		// check test Columns
		assertEquals(column1.getName(), testColumn1.getName());
		assertEquals(column1.getId(), testColumn1.getId());
		assertEquals(column1.getDescription(), testColumn1.getDescription());
		assertEquals(column1.getValue(), testColumn1.getValue());

		assertEquals(column2.getName(), testColumn2.getName());
		assertEquals(column2.getId(), testColumn2.getId());
		assertEquals(column2.getDescription(), testColumn2.getDescription());
		assertEquals(column2.getValue(), testColumn2.getValue());

		assertEquals(column3.getName(), testColumn3.getName());
		assertEquals(column3.getId(), testColumn3.getId());
		assertEquals(column3.getDescription(), testColumn3.getDescription());
		assertEquals(column3.getValue(), testColumn3.getValue());

		// check column names
		assertEquals(testColumn1.getName(), tableComponent.getColumnNames()
				.get(0));
		assertEquals(testColumn2.getName(), tableComponent.getColumnNames()
				.get(1));
		assertEquals(testColumn3.getName(), tableComponent.getColumnNames()
				.get(2));

		// Test that only one template can be made
		column4.setName("Column4");
		column4.setId(4);
		column4.setDescription("I am Column4!");
		column4.setValue("Goku");

		column5.setName("Column5");
		column5.setId(5);
		column5.setDescription("I am Column5!");
		column5.setValue("is");

		column6.setName("Column6");
		column6.setId(6);
		column6.setDescription("I am Column6!");
		column6.setValue("Kakarrot");

		template2.add(column4);
		template2.add(column5);
		template2.add(column6);

		// insert template2 into pre-existing tableComponent
		tableComponent.setRowTemplate(template2);

		// check column names - they don't change
		assertEquals(column1.getName(), tableComponent.getColumnNames().get(0));
		assertEquals(column2.getName(), tableComponent.getColumnNames().get(1));
		assertEquals(column3.getName(), tableComponent.getColumnNames().get(2));

		// Test for nulleries
		// test for setTableComponent
		tableComponent.setRowTemplate(null);
		tableComponent.setDescription(null);
		tableComponent.setName(null);

		// check - not null These should not be null since they were already
		// set.
		assertNotNull(tableComponent.getDescription());
		assertNotNull(tableComponent.getName());
		assertNotNull(tableComponent.getRowTemplate());

		// This is to check to make sure rowEdits are not being made on a
		// template
		// or columnNames
		ArrayList<String> tempArray = new ArrayList<String>();
		ArrayList<IEntry> tArray = new ArrayList<IEntry>();

		// check columnNames
		tempArray = tableComponent.getColumnNames();

		// Modify the arrayList
		tempArray.add("NewColumn!");

		// check arraylist, see that it is still the same size and does not
		// contain new content
		assertEquals(3, tableComponent.getColumnNames().size());

		// check column names - they don't change
		assertEquals(column1.getName(), tableComponent.getColumnNames().get(0));
		assertEquals(column2.getName(), tableComponent.getColumnNames().get(1));
		assertEquals(column3.getName(), tableComponent.getColumnNames().get(2));

		// check rowTemplate
		tArray = tableComponent.getRowTemplate();

		// Modify the arrayList
		tArray.add(column4);

		// Check arraylist, see that it is still the same size and does not
		// contain new content
		assertEquals(3, tableComponent.getRowTemplate().size());

		// check test Columns with other columns (to verify no change was made)
		assertEquals(column1.getName(), testColumn1.getName());
		assertEquals(column1.getId(), testColumn1.getId());
		assertEquals(column1.getDescription(), testColumn1.getDescription());
		assertEquals(column1.getValue(), testColumn1.getValue());

		assertEquals(column2.getName(), testColumn2.getName());
		assertEquals(column2.getId(), testColumn2.getId());
		assertEquals(column2.getDescription(), testColumn2.getDescription());
		assertEquals(column2.getValue(), testColumn2.getValue());

		assertEquals(column3.getName(), testColumn3.getName());
		assertEquals(column3.getId(), testColumn3.getId());
		assertEquals(column3.getDescription(), testColumn3.getDescription());
		assertEquals(column3.getValue(), testColumn3.getValue());

	}

	/**
	 * <p>
	 * This operation ensures that rows can be retrieved, added and deleted from
	 * the table and that the number of rows and columns, as well as the names
	 * of the columns are correct. It also checks that rows can be marked as
	 * selected.
	 * </p>
	 * 
	 */
	@Test
	public void checkRowManipulation() {

		// Local Declarations
		ArrayList<IEntry> template = new ArrayList<IEntry>();
		ArrayList<IEntry> row1 = new ArrayList<IEntry>();
		ArrayList<IEntry> row2 = new ArrayList<IEntry>();

		IEntry column1 = new StringEntry();
		IEntry column2 = new StringEntry();
		IEntry column3 = new StringEntry();

		// These tests will check the elasticity of the row editing methods.

		// create new tableComponent
		tableComponent = new TableComponent();

		// quick test to specify if an addRow operation fails for a nonexisting
		// template
		assertEquals(-1, tableComponent.addRow());

		// set tableComponent values for name, id, description
		tableComponent.setName("Table 1");
		tableComponent.setId(1);
		tableComponent.setDescription("This is a table that contains entries.");

		// Set row template - gather columns to table
		column1.setName("Column1");
		column1.setId(1);
		column1.setDescription("I am Column1!");
		column1.setValue("Over 9000!");

		column2.setName("Column2");
		column2.setId(2);
		column2.setDescription("I am Column2!");
		column2.setValue("Under 9000!");

		column3.setName("Column3");
		column3.setId(3);
		column3.setDescription("I am Column3!");
		column3.setValue("At 9000!");

		// Add columns to template arraylist
		template.add(column1);
		template.add(column2);
		template.add(column3);

		// check to see that no rows are added
		assertEquals(0, tableComponent.numberOfRows());

		// Add template to tableComponent
		tableComponent.setRowTemplate(template);

		// check to see that setting template does not add rows to rowcount
		assertEquals(0, tableComponent.numberOfRows());

		// Add entries - first add row (and make sure it returns proper rowID)
		assertEquals(0, tableComponent.addRow());
		assertEquals(1, tableComponent.addRow());

		// Get row ArrayLists
		row1 = null;
		row2 = null;
		row1 = tableComponent.getRow(0);
		row2 = tableComponent.getRow(1);

		// make sure rows are not null
		assertNotNull(row1);
		assertNotNull(row2);

		// Adding a row should copy the row template into a new row
		// check row1's information and contents for validity
		assertEquals(column1.getName(), row1.get(0).getName());
		assertEquals(column1.getId(), row1.get(0).getId());
		assertEquals(column1.getDescription(), row1.get(0).getDescription());

		assertEquals(column2.getName(), row1.get(1).getName());
		assertEquals(column2.getId(), row1.get(1).getId());
		assertEquals(column2.getDescription(), row1.get(1).getDescription());

		assertEquals(column3.getName(), row1.get(2).getName());
		assertEquals(column3.getId(), row1.get(2).getId());
		assertEquals(column3.getDescription(), row1.get(2).getDescription());

		// check row2's information and contents for validity
		assertEquals(column1.getName(), row2.get(0).getName());
		assertEquals(column1.getId(), row2.get(0).getId());
		assertEquals(column1.getDescription(), row2.get(0).getDescription());

		assertEquals(column2.getName(), row2.get(1).getName());
		assertEquals(column2.getId(), row2.get(1).getId());
		assertEquals(column2.getDescription(), row2.get(1).getDescription());

		assertEquals(column3.getName(), row2.get(2).getName());
		assertEquals(column3.getId(), row2.get(2).getId());
		assertEquals(column3.getDescription(), row2.get(2).getDescription());

		// Get row ArrayLists
		row1 = null;
		row2 = null;
		row1 = tableComponent.getRow(0);
		row2 = tableComponent.getRow(1);

		// assert the number of rows
		assertEquals(tableComponent.numberOfRows(), 2);

		// make sure not null
		assertNotNull(row1);
		assertNotNull(row2);

		// edit entries to rows

		// edit row1
		row1.get(0).setName("Entry1");
		row1.get(0).setId(1);
		row1.get(0).setDescription("I am Entry1!");

		row1.get(1).setName("Entry2");
		row1.get(1).setId(2);
		row1.get(1).setDescription("I am Entry2!");

		row1.get(2).setName("Entry3");
		row1.get(2).setId(3);
		row1.get(2).setDescription("I am Entry3!");

		// edit row2
		row2.get(0).setName("Entry4");
		row2.get(0).setId(4);
		row2.get(0).setDescription("I am Entry4!");

		row2.get(1).setName("Entry5");
		row2.get(1).setId(5);
		row2.get(1).setDescription("I am Entry5!");

		row2.get(2).setName("Entry6");
		row2.get(2).setId(6);
		row2.get(2).setDescription("I am Entry6!");

		// check to see if entries were added correctly
		row1 = null;
		row2 = null;
		row1 = tableComponent.getRow(0);
		row2 = tableComponent.getRow(1);
		assertNotNull(row1);
		assertNotNull(row2);

		// check row1's information and contents for validity
		assertEquals("Entry1", row1.get(0).getName());
		assertEquals(1, row1.get(0).getId());
		assertEquals("I am Entry1!", row1.get(0).getDescription());

		assertEquals("Entry2", row1.get(1).getName());
		assertEquals(2, row1.get(1).getId());
		assertEquals("I am Entry2!", row1.get(1).getDescription());

		assertEquals("Entry3", row1.get(2).getName());
		assertEquals(3, row1.get(2).getId());
		assertEquals("I am Entry3!", row1.get(2).getDescription());

		// check row2's information and contents for validity
		assertEquals("Entry4", row2.get(0).getName());
		assertEquals(4, row2.get(0).getId());
		assertEquals("I am Entry4!", row2.get(0).getDescription());

		assertEquals("Entry5", row2.get(1).getName());
		assertEquals(5, row2.get(1).getId());
		assertEquals("I am Entry5!", row2.get(1).getDescription());

		assertEquals("Entry6", row2.get(2).getName());
		assertEquals(6, row2.get(2).getId());
		assertEquals("I am Entry6!", row2.get(2).getDescription());

		// check number of rows, columns, and rowIds
		assertEquals(2, tableComponent.numberOfRows());
		assertEquals(3, tableComponent.numberOfColumns());

		// check rowIds - check to see there are 2 rows and they are set
		// correctly for each id.
		assertEquals(0, tableComponent.getRowIds().get(0).intValue());
		assertEquals(1, tableComponent.getRowIds().get(1).intValue());

		// check deletion - delete row 1, and make sure row2's id changes to 1
		assertTrue(tableComponent.deleteRow(0));
		assertEquals(1, tableComponent.numberOfRows());
		row1 = null;
		row1 = tableComponent.getRow(0);
		assertNotNull(row1);

		// check row1's information and contents for validity contents
		assertEquals("Entry4", row1.get(0).getName());
		assertEquals(4, row1.get(0).getId());
		assertEquals("I am Entry4!", row1.get(0).getDescription());

		assertEquals("Entry5", row1.get(1).getName());
		assertEquals(5, row1.get(1).getId());
		assertEquals("I am Entry5!", row1.get(1).getDescription());

		assertEquals("Entry6", row1.get(2).getName());
		assertEquals(6, row1.get(2).getId());
		assertEquals("I am Entry6!", row1.get(2).getDescription());

		// Trying to delete a nonexisting row - return false
		assertFalse(tableComponent.deleteRow(-1));

		// Trying to get a row that does not exist - Should return null
		assertNull(tableComponent.getRow(9));
		assertNull(tableComponent.getRow(-1));

		// More insertion and deletion tests for tableComponent
		tableComponent.addRow();
		tableComponent.addRow();
		tableComponent.addRow();
		tableComponent.addRow();
		tableComponent.addRow();

		// get last and second to last rows - need to check edits
		row1 = null;
		row2 = null;
		row1 = tableComponent.getRow(5);
		row2 = tableComponent.getRow(4);

		// set rows
		row1.get(0).setName("Bob");
		row2.get(0).setName("Bill");

		assertEquals(6, tableComponent.numberOfRows());
		assertTrue(tableComponent.deleteRow(1));
		assertEquals(5, tableComponent.numberOfRows());

		// delete last row and check to see if second to last row is "Bill"
		assertTrue(tableComponent.deleteRow(4));
		assertEquals(4, tableComponent.numberOfRows());
		assertEquals("Bill", tableComponent.getRow(3).get(0).getName());

		// delete all rows
		assertTrue(tableComponent.deleteRow(3));
		assertTrue(tableComponent.deleteRow(2));
		assertTrue(tableComponent.deleteRow(1));
		assertTrue(tableComponent.deleteRow(0));

		// check to see that there are no rows remaining
		assertEquals(0, tableComponent.numberOfRows());

		// Extra test - checking rowIds with row editing
		assertEquals(0, tableComponent.addRow());
		assertEquals(1, tableComponent.addRow());

		row1 = tableComponent.getRow(0);
		row2 = tableComponent.getRow(1);
		row1.get(0).setName("Bill");
		row2.get(0).setName("Bob");

		// get rowIds
		ArrayList<Integer> rowIds = tableComponent.getRowIds();

		// Iterate over the rowIds list, and check names
		assertEquals("Bill", tableComponent.getRow(rowIds.get(0)).get(0)
				.getName());
		assertEquals("Bob", tableComponent.getRow(rowIds.get(1)).get(0)
				.getName());

		// Modify the rows by rowIds to change the name
		tableComponent.getRow(rowIds.get(0)).get(0).setName("Bill2");
		tableComponent.getRow(rowIds.get(1)).get(0).setName("Billy");

		// getRowIds again, and check contents
		rowIds = tableComponent.getRowIds();

		// Iterate over the rowIds list, and check names - they reflected!
		assertEquals("Bill2", tableComponent.getRow(rowIds.get(0)).get(0)
				.getName());
		assertEquals("Billy", tableComponent.getRow(rowIds.get(1)).get(0)
				.getName());

		// Check that no selected rows exist
		assertNull(tableComponent.getSelectedRows());
		// Mark both rows selected
		ArrayList<Integer> selectedRows = new ArrayList<Integer>();
		selectedRows.add(0);
		selectedRows.add(1);
		tableComponent.setSelectedRows(selectedRows);
		// Make sure both are selected
		ArrayList<Integer> retSelectedRows = tableComponent.getSelectedRows();
		assertEquals(2, retSelectedRows.size());
		assertEquals(0, (int) retSelectedRows.get(0));
		assertEquals(1, (int) retSelectedRows.get(1));

		// Change the selection to only be the second row
		selectedRows.clear();
		selectedRows.add(1);
		tableComponent.setSelectedRows(selectedRows);
		// Make sure it is selected
		retSelectedRows = tableComponent.getSelectedRows();
		assertEquals(1, retSelectedRows.size());
		assertEquals(1, (int) retSelectedRows.get(0));

		// Make a selection with a row that doesn't exist
		selectedRows.clear();
		selectedRows.add(4);
		selectedRows.add(5);
		tableComponent.setSelectedRows(selectedRows);
		// Make sure the selections haven't changed since these ones are bad.
		retSelectedRows = tableComponent.getSelectedRows();
		assertEquals(1, retSelectedRows.size());
		assertEquals(1, (int) retSelectedRows.get(0));

		return;
	}

	/**
	 * <p>
	 * This operation tests the TableComponent to insure that it can properly
	 * dispatch notifications when it receives an update that changes its state.
	 * </p>
	 * 
	 */
	@Test
	public void checkNotifications() {

		// Setup the listener
		testComponentListener = new TestComponentListener();

		// Setup the DataComponent
		tableComponent = new TableComponent();

		// Register the listener
		tableComponent.register(testComponentListener);

		// Reset the listener
		testComponentListener.reset();

		// set a template
		ArrayList<IEntry> array = new ArrayList<IEntry>();
		array.add(new StringEntry());
		tableComponent.setRowTemplate(array);

		// Check the listener to make sure it was updated
		assertTrue(testComponentListener.wasNotified());

		// Reset the listener
		testComponentListener.reset();

		// Create a new row in the TableComponent
		tableComponent.addRow();
		// add "Entry"

		// Check the Listener
		assertTrue(testComponentListener.wasNotified());

		// Reset the listener
		testComponentListener.reset();

		// Remove a row
		tableComponent.deleteRow(0);

		// Check the listener to make sure it was updated
		assertTrue(testComponentListener.wasNotified());

		return;

	}

	/**
	 * <p>
	 * This operation checks the TableComponent to insure that it can be
	 * correctly visited by a realization of the IComponentVisitor interface.
	 * </p>
	 * 
	 */
	@Test
	public void checkVisitation() {

		// Setup the visitor
		testVisitor = new TestVisitor();

		// Setup the DataComponent
		tableComponent = new TableComponent();

		// Send the visitor
		tableComponent.accept(testVisitor);

		// Check the visitor
		assertTrue(testVisitor.wasVisited());

	}

	/**
	 * <p>
	 * This operation checks the TableComponent to insure that its equals() and
	 * hashcode() operations work.
	 * </p>
	 * 
	 */
	@Test
	public void checkEquality() {
		// Local Declarations
		ArrayList<IEntry> template = new ArrayList<IEntry>();
		ArrayList<IEntry> template2 = new ArrayList<IEntry>();

		// Create TableComponents to test
		TableComponent component = new TableComponent();
		TableComponent equalComponent = new TableComponent();
		TableComponent unEqualComponent = new TableComponent();
		TableComponent transitiveComponent = new TableComponent();

		// Create ArrayList for row templates. Add to component, equalcomponent,
		// and transitivecomponent
		for (int i = 0; i < 10; i++) {
			IEntry e = new StringEntry();
			e.setName("" + i);
			template.add(e);
		}

		// Add template to respective component
		component.setRowTemplate(template);
		equalComponent.setRowTemplate(template);
		transitiveComponent.setRowTemplate(template);

		// add five to unequal
		template2.add(template.get(0));
		template2.add(template.get(1));
		template2.add(template.get(2));
		template2.add(template.get(3));
		template2.add(template.get(4));

		// add to unequal
		unEqualComponent.setRowTemplate(template2);

		// Set ICEObject data
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

		// Assert two unequal DataComponents return fals
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

		// Assert that two equal objects return same hashCode
		assertTrue(component.equals(equalComponent)
				&& component.hashCode() == equalComponent.hashCode());

		// Assert that hashcode is consistent
		assertTrue(component.hashCode() == component.hashCode());

		// Assert that hashcodes from unequal objects are different
		assertTrue(component.hashCode() != unEqualComponent.hashCode());

	}

	/**
	 * <p>
	 * This operation checks the TableComponent to ensure that its copy() and
	 * clone() operations work as specified.
	 * </p>
	 * 
	 */
	@Test
	public void checkCopying() {

		/*
		 * The following sets of operations will be used to test the
		 * "clone and copy" portion of TableComponent.
		 */
		// Local Declarations
		ArrayList<IEntry> template = new ArrayList<IEntry>();
		ArrayList<IEntry> row1 = new ArrayList<IEntry>();
		ArrayList<IEntry> row2 = new ArrayList<IEntry>();

		IEntry column1 = new StringEntry();
		IEntry column2 = new StringEntry();
		IEntry column3 = new StringEntry();

		TableComponent cloneTable = new TableComponent();
		TableComponent copyTable = new TableComponent();

		IEntry testColumn1, testColumn2, testColumn3 = null;

		// create new tableComponent
		tableComponent = new TableComponent();

		// set tableComponent values for name, id, description
		tableComponent.setName("Table 1");
		tableComponent.setId(1);
		tableComponent.setDescription("This is a table that contains entries.");

		// Set row template - gather columns to table
		column1.setName("Column1");
		column1.setId(1);
		column1.setDescription("I am Column1!");
		column1.setValue("Over 9000!");

		column2.setName("Column2");
		column2.setId(2);
		column2.setDescription("I am Column2!");
		column2.setValue("Under 9000!");

		column3.setName("Column3");
		column3.setId(3);
		column3.setDescription("I am Column3!");
		column3.setValue("At 9000!");

		// Add columns to template arraylist
		template.add(column1);
		template.add(column2);
		template.add(column3);

		// Add template to tableComponent
		tableComponent.setRowTemplate(template);

		// check to see that setting template does not add rows to rowcount
		assertEquals(0, tableComponent.numberOfRows());

		// Add entries - first add row (and make sure it returns proper rowID)
		assertEquals(0, tableComponent.addRow());
		assertEquals(1, tableComponent.addRow());

		// Get row ArrayLists. Then with the rows, edit the contents
		// of each entry.
		row1 = tableComponent.getRow(0);
		row2 = tableComponent.getRow(1);

		// edit row1
		row1.get(0).setName("Entry1");
		row1.get(0).setId(1);
		row1.get(0).setDescription("I am Entry1!");

		row1.get(1).setName("Entry2");
		row1.get(1).setId(2);
		row1.get(1).setDescription("I am Entry2!");

		row1.get(2).setName("Entry3");
		row1.get(2).setId(3);
		row1.get(2).setDescription("I am Entry3!");

		// edit row2
		row2.get(0).setName("Entry4");
		row2.get(0).setId(4);
		row2.get(0).setDescription("I am Entry4!");

		row2.get(1).setName("Entry5");
		row2.get(1).setId(5);
		row2.get(1).setDescription("I am Entry5!");

		row2.get(2).setName("Entry6");
		row2.get(2).setId(6);
		row2.get(2).setDescription("I am Entry6!");

		// Select a row to check selected row copying
		ArrayList<Integer> selectedRowList = new ArrayList<Integer>();
		selectedRowList.add(1);
		tableComponent.setSelectedRows(selectedRowList);

		// run clone operation
		cloneTable = (TableComponent) tableComponent.clone();

		// check contents
		assertTrue(tableComponent.equals(cloneTable));

		// check copy operation
		copyTable.copy(tableComponent);

		// check contents
		assertTrue(tableComponent.equals(copyTable));

		// Show copy arg = null. Should show no change
		copyTable.copy(null);

		// no change
		assertTrue(tableComponent.equals(copyTable));

		return;
	}

	/**
	 * This operation checks the ability of the TableComponent to persist itself
	 * to XML and to load itself from an XML input stream.
	 * @throws IOException 
	 * @throws JAXBException 
	 * @throws NullPointerException 
	 */
	@Test
	public void checkLoadingFromXML() throws NullPointerException, JAXBException, IOException {

		/*
		 * The following sets of operations will be used to test the
		 * "read and write" portion of the TableComponent. It will demonstrate
		 * the behavior of reading and writing from an
		 * "XML (inputStream and outputStream)" file. It will use an annotated
		 * TableComponent to demonstrate basic behavior.
		 */

		// Local Declarations
		ArrayList<IEntry> template = new ArrayList<IEntry>();
		ArrayList<IEntry> row1 = new ArrayList<IEntry>();
		ArrayList<IEntry> row2 = new ArrayList<IEntry>();
		ICEJAXBHandler xmlHandler = new ICEJAXBHandler();
		ArrayList<Class> classList = new ArrayList<Class>();
		classList.add(TableComponent.class);
		classList.add(StringEntry.class);
		
		IEntry column1 = new StringEntry();
		IEntry column2 = new StringEntry();
		IEntry column3 = new StringEntry();

		TableComponent tableComponent2 = new TableComponent();

		IEntry testColumn1, testColumn2, testColumn3 = null;

		// create new tableComponent
		tableComponent = new TableComponent();

		// set tableComponent values for name, id, description
		tableComponent.setName("Table 1");
		tableComponent.setId(1);
		tableComponent.setDescription("This is a table that contains entries.");

		// Set row template - gather columns to table
		column1.setName("Column1");
		column1.setId(1);
		column1.setDescription("I am Column1!");
		column1.setValue("Over 9000!");
		column1.setTag("Column");

		column2.setName("Column2");
		column2.setId(2);
		column2.setDescription("I am Column2!");
		column2.setValue("Under 9000!");
		column2.setTag("Column");

		column3.setName("Column3");
		column3.setId(3);
		column3.setDescription("I am Column3!");
		column3.setValue("At 9000!");
		column3.setTag("Column");

		// Add columns to template arraylist
		template.add(column1);
		template.add(column2);
		template.add(column3);

		// Add template to tableComponent
		tableComponent.setRowTemplate(template);

		// check to see that setting template does not add rows to rowcount
		assertEquals(0, tableComponent.numberOfRows());

		// Add entries - first add row (and make sure it returns proper rowID)
		assertEquals(0, tableComponent.addRow());
		assertEquals(1, tableComponent.addRow());

		// Get row ArrayLists
		row1 = tableComponent.getRow(0);
		row2 = tableComponent.getRow(1);

		// edit row1
		row1.get(0).setName("Entry1");
		row1.get(0).setId(1);
		row1.get(0).setDescription("I am Entry1!");

		row1.get(1).setName("Entry2");
		row1.get(1).setId(2);
		row1.get(1).setDescription("I am Entry2!");

		row1.get(2).setName("Entry3");
		row1.get(2).setId(3);
		row1.get(2).setDescription("I am Entry3!");

		// edit row2
		row2.get(0).setName("Entry4");
		row2.get(0).setId(4);
		row2.get(0).setDescription("I am Entry4!");

		row2.get(1).setName("Entry5");
		row2.get(1).setId(5);
		row2.get(1).setDescription("I am Entry5!");

		row2.get(2).setName("Entry6");
		row2.get(2).setId(6);
		row2.get(2).setDescription("I am Entry6!");

		// Select a row for the test
		ArrayList<Integer> selectedRowList = new ArrayList<Integer>();
		selectedRowList.add(1);
		tableComponent.setSelectedRows(selectedRowList);

		// Demonstrate a basic "write" to file. Should not fail

		// persist to an output stream
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		xmlHandler.write(tableComponent, classList, outputStream);

		// Initialize object and pass inputStream to read()
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				outputStream.toByteArray());

		// create a new instance of a different variable to compare
		tableComponent2 = new TableComponent();

		// load into DataComponent();
		tableComponent2 = (TableComponent) xmlHandler.read(classList, inputStream);
		assertTrue(tableComponent.equals(tableComponent2));

		// check contents
		// check row template, its entries, and columns
		template = tableComponent2.getRowTemplate();
		assertNotNull(template);
		// Get columns
		testColumn1 = template.get(0);
		testColumn2 = template.get(1);
		testColumn3 = template.get(2);

		// check test Columns
		assertEquals("Column1", testColumn1.getName());
		assertEquals(1, testColumn1.getId());
		assertEquals("I am Column1!", testColumn1.getDescription());
		assertEquals("Over 9000!", testColumn1.getValue());

		assertEquals("Column2", testColumn2.getName());
		assertEquals(2, testColumn2.getId());
		assertEquals("I am Column2!", testColumn2.getDescription());
		assertEquals("Under 9000!", testColumn2.getValue());

		assertEquals("Column3", testColumn3.getName());
		assertEquals(3, testColumn3.getId());
		assertEquals("I am Column3!", testColumn3.getDescription());
		assertEquals("At 9000!", testColumn3.getValue());

		// check column names
		assertEquals("Column1", tableComponent2.getColumnNames().get(0));
		assertEquals("Column2", tableComponent2.getColumnNames().get(1));
		assertEquals("Column3", tableComponent2.getColumnNames().get(2));

		// check row1's information and contents for validity
		assertEquals("Entry1", row1.get(0).getName());
		assertEquals(1, row1.get(0).getId());
		assertEquals("I am Entry1!", row1.get(0).getDescription());

		assertEquals("Entry2", row1.get(1).getName());
		assertEquals(2, row1.get(1).getId());
		assertEquals("I am Entry2!", row1.get(1).getDescription());

		assertEquals("Entry3", row1.get(2).getName());
		assertEquals(3, row1.get(2).getId());
		assertEquals("I am Entry3!", row1.get(2).getDescription());

		// check row2's information and contents for validity
		assertEquals("Entry4", row2.get(0).getName());
		assertEquals(4, row2.get(0).getId());
		assertEquals("I am Entry4!", row2.get(0).getDescription());

		assertEquals("Entry5", row2.get(1).getName());
		assertEquals(5, row2.get(1).getId());
		assertEquals("I am Entry5!", row2.get(1).getDescription());

		assertEquals("Entry6", row2.get(2).getName());
		assertEquals(6, row2.get(2).getId());
		assertEquals("I am Entry6!", row2.get(2).getDescription());

		// check number of rows, columns, and rowIds
		assertEquals(2, tableComponent2.numberOfRows());
		assertEquals(3, tableComponent2.numberOfColumns());

		// check rowIds - check to see there are 2 rows and they are set
		// correctly for each id.
		assertEquals(0, tableComponent2.getRowIds().get(0).intValue());
		assertEquals(1, tableComponent2.getRowIds().get(1).intValue());

	}
}