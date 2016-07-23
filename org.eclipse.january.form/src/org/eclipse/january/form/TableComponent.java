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
package org.eclipse.january.form;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * The TableComponent class is a Component that contains a set of Entries that
 * are related to each other within a single row of a table and it can contain
 * many rows. Each row of the table contains a set of Entries that only make
 * sense when they are considered as a set, such as "Hostname,"
 * "Operating System" and "Install Path" for a particular executable application
 * or script. The structure of the Table is defined by its "Row Template" that
 * contains a default Entry for each column. So, if we wanted a table with a
 * column for "Hostname," "Operating System" and "Install Path" we would set the
 * row template on the TableComponent with a set of three Entries, one for each
 * property, that describes the default configuration. The row template is the
 * canonical row configuration of the TableComponent. Once the template is set
 * it can not be changed, although it can be retrieved for reference. Adding a
 * row to the table creates a copy of the template and assumes the default
 * values, which can be edited after retrieving the row. Rows may be deleted and
 * if a row is deleted it will result in the entire table being re-ordered to
 * keep the row numbers sequential.
 * </p>
 * 
 * @author Jay Jay Billings
 */
@XmlRootElement(name = "TableComponent")
@XmlAccessorType(XmlAccessType.FIELD)
public class TableComponent extends ICEObject implements Component {

	/**
	 * <p>
	 * The java.util.HashTable that contains the rows. The key of the hashtable
	 * is an integer that represents the row index in the table. The value is a
	 * java.util.ArrayList that contains the set of Entries for that row. The
	 * value for key = 0 is the Row Template.
	 * </p>
	 */
	private Hashtable<Integer, ArrayList<IEntry>> rowTable;
	/**
	 * <p>
	 * A list containing the names of the columns.
	 * </p>
	 * 
	 */
	@XmlElement(name = "ColumnNames")
	private ArrayList<String> columnNames;

	/**
	 * <p >
	 * The set of DataComponents that represents the rows of the table. The
	 * index of the set represents the row index in the table. The DataComponent
	 * at i = 0 is the Row Template.
	 * </p>
	 * 
	 */
	@XmlElement(name = "Row")
	private ArrayList<DataComponent> rowComponents;

	/**
	 * The rows that have been selected and deemed of some importance for this
	 * table.
	 */
	@XmlElement(name = "SelectedRow")
	private ArrayList<Integer> selectedRows;

	/**
	 * <p>
	 * The constructor
	 * </p>
	 * 
	 */
	public TableComponent() {
		columnNames = new ArrayList<String>();
		rowComponents = new ArrayList<DataComponent>();
		listeners = new ArrayList<IUpdateableListener>();
		selectedRows = new ArrayList<Integer>();
	}

	/**
	 * <p>
	 * This operation returns the number of rows that are stored in the table.
	 * </p>
	 * 
	 * @return <p>
	 *         The total number of rows in the table.
	 *         </p>
	 */
	public int numberOfRows() {

		// exclude columns row
		if (rowComponents.size() <= 1) {
			return 0;
		} else {
			// Index shift -> index 0 of rowComponents are the column tags and
			// are not considered rows.
			return this.rowComponents.size() - 1;
		}
	}

	/**
	 * <p>
	 * This operation returns the number of columns that are stored in the
	 * table. This is exactly equal to the length of a single row since the
	 * TableComponent is built off of a row template.
	 * </p>
	 * 
	 * @return <p>
	 *         The number of columns.
	 *         </p>
	 */
	public int numberOfColumns() {
		return this.columnNames.size();
	}

	/**
	 * <p>
	 * This operation retrieves an individual row from the Table. The row is
	 * returned as a collection of Entries that represent each element in the
	 * row. The collection is a new collection, but the Entries are references
	 * of the values currently stored in the TableComponent. (This prevents the
	 * rows from being re-ordered.)
	 * </p>
	 * 
	 * @param index
	 *            <p>
	 *            The row's index or id in the table.
	 *            </p>
	 * @return <p>
	 *         The set of Entries that represent the row in the table.
	 *         </p>
	 */
	public ArrayList<IEntry> getRow(int index) {

		// return null if index does not exist
		// Index shift -> index 0 of rowComponents are the column tags and are
		// not considered rows.
		// Also do not return a row if the index is negative
		// Boolean operation
		if (!(!rowComponents.isEmpty() & index < rowComponents.size() - 1 & index >= 0)) {
			return null;
		}

		// create a new arraylist
		ArrayList<IEntry> rowArray = new ArrayList<IEntry>();

		// copy entries into rowArray
		// Index shift -> index 0 of rowComponents are the column tags and are
		// not considered rows.
		// Add one to index to compensate.
		for (int i = 0; i < rowComponents.get(index + 1).retrieveAllEntries()
				.size(); i++) {
			rowArray.add(rowComponents.get(index + 1).retrieveAllEntries()
					.get(i));
		}

		return rowArray;
	}

	/**
	 * <p>
	 * This operation adds a row to the Table and returns the index of that row.
	 * The new row may be retrieved and its Entries may be edited by calling
	 * getRow() using the returned index. When a new row is added, the elements
	 * of that row are configured from the row template using its default
	 * values. If the Row Template has not yet been set for the TableComponent,
	 * this operation cannot add a row and it returns -1.
	 * </p>
	 * 
	 * @return <p>
	 *         The index of the new row in the table.
	 *         </p>
	 */
	public int addRow() {
		// create a clone of template

		// Return -1 if the template has not been set
		// Notice how rowComponents has to have the rowTemplate created before
		// it will allow
		// a row addition
		if (rowComponents.isEmpty()) {
			return -1;
		}

		// create a datacomponent. Set dataComponent id to rowSize and set name
		// and description
		DataComponent dataComponent = new DataComponent();

		// Index shift -> index 0 of rowComponents are the column tags and are
		// not considered rows.
		// decrement one
		dataComponent.setId(rowComponents.size() - 1);
		dataComponent.setName("Row");
		dataComponent.setDescription("This is a row");

		// copy contents of template into new row
		for (int i = 0; i < rowComponents.get(0).retrieveAllEntries().size(); i++) {
			dataComponent.addEntry((IEntry) rowComponents.get(0)
					.retrieveAllEntries().get(i).clone());
		}

		rowComponents.add(dataComponent);
		notifyListeners();

		// Index shift -> index 0 of rowComponents are the column tags and are
		// not considered rows.
		return rowComponents.size() - 2;
	}

	/**
	 * <p>
	 * This operation will delete the row in the table with the specified index.
	 * It will return true if it is success or false otherwise (like if it can
	 * not find a row with that index).
	 * </p>
	 * 
	 * @param index
	 *            <p>
	 *            The index of the row that should be deleted.
	 *            </p>
	 * @return <p>
	 *         True if the row was deleted and false if some problem was
	 *         encountered, like an incorrect row id.
	 *         </p>
	 */
	public boolean deleteRow(int index) {

		// Return if the index is deleting a row that does not exist
		// Index shift -> index 0 of rowComponents are the column tags and are
		// not considered rows.
		// decrement by one from index
		// Also do not delete row if index is negative
		// Optimized for boolean operation
		if (!(!rowComponents.isEmpty() & index < rowComponents.size() - 1 & index >= 0)) {
			return false;
		}

		// delete row
		// Index shift -> index 0 of rowComponents are the column tags and are
		// not considered rows.
		rowComponents.remove(index + 1);

		// set indexes up
		// Index shift -> index 0 of rowComponents are the column tags and are
		// not considered rows.
		// Add one to make adjustments into rowComponents index
		for (int i = index + 1; i < rowComponents.size(); i++) {
			rowComponents.get(i).setId(i);
		}

		notifyListeners();
		// return true
		return true;

	}

	/**
	 * <p>
	 * This operation sets the collection of Entries which should be used as the
	 * template for this table. This template will be used to create new rows
	 * and to determine the default values of elements and the names of columns.
	 * The row template may only be set once per TableComponent: changing the
	 * row template of a TableComponent can only be done by creating a new one.
	 * </p>
	 * 
	 * @param template
	 *            <p>
	 *            The set of Entries that represent the canonical row of this
	 *            table.
	 *            </p>
	 */
	public void setRowTemplate(ArrayList<IEntry> template) {

		// Local Declarations
		int i = 0;

		// create a new dataComponent - set name id, and description
		DataComponent dataComponent = new DataComponent();
		dataComponent.setName(".xRowTemplatex.");
		dataComponent.setId(0);
		dataComponent.setDescription("This is a row template");
		// if template is null, return
		// Also if the columnNames are set, then a rowTemplate can not be set
		if (!(template != null & (this.columnNames.isEmpty()))) {
			return;
		}

		// Set Column Names
		for (i = 0; i < template.size(); i++) {
			this.columnNames.add(template.get(i).getName());
		}

		// copy contents of template to dataComponent
		for (i = 0; i < template.size(); i++) {
			dataComponent.addEntry(template.get(i));
		}

		// add dataComponent to rowComponents
		rowComponents.add(dataComponent);

		this.notifyListeners();
	}

	/**
	 * <p>
	 * This operation returns the row template for this TableComponent.
	 * </p>
	 * 
	 * @return <p>
	 *         The set of Entries that represent the canonical row of this
	 *         table.
	 *         </p>
	 */
	public ArrayList<IEntry> getRowTemplate() {
		// Local Declarations
		int i = 0;

		// Return null if the rowTemplate has not been set
		if (this.columnNames.isEmpty()) {
			return null;
		}

		// Create a new ArrayList and return it.
		ArrayList<IEntry> rowTemplate = new ArrayList<IEntry>();

		for (i = 0; i < rowComponents.get(0).retrieveAllEntries().size(); i++) {
			rowTemplate.add(rowComponents.get(0).retrieveAllEntries().get(i));
		}

		return rowTemplate;
	}

	/**
	 * <p>
	 * This operation returns the set of integers that uniquely identify rows in
	 * the table.
	 * </p>
	 * 
	 * @return <p>
	 *         The set of ids or indices for the rows in the table.
	 *         </p>
	 */
	public ArrayList<Integer> getRowIds() {
		// create a new arraylist
		ArrayList<Integer> rowIds = new ArrayList<Integer>();

		// add rowIds from hashTable
		// Index shift -> index 0 of rowComponents are the column tags and are
		// not considered rows.
		// Only return rows and not the rowTemplate
		for (int i = 1; i < rowComponents.size(); i++) {
			// Return the rowIds in each rowComponent (better than returning a
			// new arraylist of integers
			// because this allows for better verification of Id setting on data
			// component
			rowIds.add(rowComponents.get(i).getId());
		}

		return rowIds;
	}

	/**
	 * <p>
	 * This operation returns the names of the table's columns.
	 * </p>
	 * 
	 * @return <p>
	 *         The names of the columns.
	 *         </p>
	 */
	public ArrayList<String> getColumnNames() {

		// Create a new arraylist and copy it into a new array.
		// This prevents runtime edits.
		ArrayList<String> rowArray = new ArrayList<String>();

		// create copy of arraylist
		for (int i = 0; i < this.columnNames.size(); i++) {
			rowArray.add(this.columnNames.get(i));
		}

		return rowArray;
	}

	/**
	 * <p>
	 * This operation performs a deep copy of the attributes of another
	 * TableComponent into the current TableComponent.
	 * </p>
	 * 
	 * @param otherTableComponent
	 *            <p>
	 *            The TableComponent from which information should be copied.
	 *            </p>
	 */
	public void copy(TableComponent otherTableComponent) {
		// Return if otherTableComponenet is null
		if (otherTableComponent == null) {
			return;
		}

		// Copy contents into super and current object
		super.copy(otherTableComponent);

		// Deep copy column names
		this.columnNames.clear();
		for (int i = 0; i < otherTableComponent.columnNames.size(); i++) {
			this.columnNames.add(otherTableComponent.columnNames.get(i));
		}

		// Deep copy row components
		this.rowComponents.clear();
		for (int i = 0; i < otherTableComponent.rowComponents.size(); i++) {
			this.rowComponents
					.add((DataComponent) otherTableComponent.rowComponents.get(
							i).clone());
		}

		// Copy the selected rows
		setSelectedRows(otherTableComponent.getSelectedRows());

		// Notify the listeners
		this.notifyListeners();

		return;
	}

	/**
	 * <p>
	 * This operation provides a deep copy of the TableComponent.
	 * </p>
	 * 
	 * @return <p>
	 *         A clone of the TableComponent.
	 *         </p>
	 */
	@Override
	public Object clone() {

		// Create a new instance, copy contents, and return it

		// create a new instance of TableComponent and copy contents
		TableComponent tableComponent = new TableComponent();
		tableComponent.copy(this);
		return tableComponent;

	}

	/**
	 * <p>
	 * This operation is used to check equality between the TableComponent and
	 * another TableComponent. It returns true if the TableComponents are equal
	 * and false if they are not.
	 * </p>
	 * 
	 * @param otherTableComponent
	 *            <p>
	 *            The TableComponent that should be checked for equality.
	 *            </p>
	 * @return <p>
	 *         True if the TableComponents are equal, false if not
	 *         </p>
	 */
	@Override
	public boolean equals(Object otherTableComponent) {
		boolean retVal = true;
		// Check if they are the same reference in memory
		if (this == otherTableComponent) {
			return true;
		}

		// Check that the object is not null, and that it is a DataComponent
		if (otherTableComponent == null
				|| !(otherTableComponent instanceof TableComponent)) {
			return false;
		}

		// Check that these objects have the same ICEObject data
		if (!super.equals(otherTableComponent)) {
			return false;
		}

		// At this point, other object must be a TableComponent, so cast it
		TableComponent castedComponent = (TableComponent) otherTableComponent;

		// Loop through columnNames and rowComponentfor equality.

		retVal = (this.columnNames.equals(castedComponent.columnNames))
				&& (this.rowComponents.equals(castedComponent.rowComponents))
				&& (this.selectedRows.equals(castedComponent.selectedRows));

		return retVal;
	}

	/**
	 * <p>
	 * This operation returns the hashcode value of the TableComponent.
	 * </p>
	 * 
	 * @return <p>
	 *         The hashcode
	 *         </p>
	 */
	@Override
	public int hashCode() {

		// Local Declaration
		int hash = 9;

		// Compute hash code from TableComponent using rowComponents data
		hash = 31 * hash + super.hashCode();
		for (int i = 0; i < rowComponents.size(); i++) {
			hash += 31 * rowComponents.get(i).hashCode();
		}
		// Add the hash for the selected rows
		hash *= selectedRows.hashCode();

		return hash;
	}

	/**
	 * <p>
	 * This operation returns an array of the row ids that have been marked as
	 * selected in the table.
	 * </p>
	 * 
	 * @return <p>
	 *         The set of rows in the table that have been marked as selected or
	 *         null if none have been selected.
	 *         </p>
	 */
	public ArrayList<Integer> getSelectedRows() {
		return ((!selectedRows.isEmpty()) ? (ArrayList<Integer>) selectedRows
				.clone() : null);
	}

	/**
	 * This operation sets the selected rows in the table.
	 * 
	 * @param rows
	 *            An array of the rows in the table that should be marked as
	 *            selected. If an id in this array is not also in the table then
	 *            it is ignored and will not be returned in a call to
	 *            getSelectedRows.
	 */
	public void setSelectedRows(ArrayList<Integer> rows) {

		// Only store the array if it exists
		if (rows != null) {
			// Create the new array to store the rows
			ArrayList<Integer> rowsToStore = new ArrayList<Integer>();
			// Get the rows ids in the table
			ArrayList<Integer> rowIds = getRowIds();
			// Check the incoming rows
			for (int rowId : rows) {
				if (rowIds.contains(rowId)) {
					rowsToStore.add(rowId);
				}
			}
			// Update the list if it exists
			if (!rowsToStore.isEmpty()) {
				selectedRows = rowsToStore;
			}
		}

		return;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Component#accept(IComponentVisitor visitor)
	 */
	@Override
	public void accept(IComponentVisitor visitor) {
		// Reveal our type to the visitor
		visitor.visit(this);

	}

}