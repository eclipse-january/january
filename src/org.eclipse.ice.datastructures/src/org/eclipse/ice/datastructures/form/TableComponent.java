/*******************************************************************************
 * Copyright (c) 2012, 2014 UT-Battelle, LLC.
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
package org.eclipse.ice.datastructures.form;

import org.eclipse.ice.datastructures.ICEObject.Component;
import org.eclipse.ice.datastructures.ICEObject.ICEJAXBHandler;
import org.eclipse.ice.datastructures.ICEObject.ICEObject;
import org.eclipse.ice.datastructures.ICEObject.IUpdateable;
import org.eclipse.ice.datastructures.ICEObject.IUpdateableListener;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.eclipse.ice.datastructures.componentVisitor.IComponentVisitor;

/**
 * <!-- begin-UML-doc -->
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
 * <!-- end-UML-doc -->
 * 
 * @author Jay Jay Billings
 * @generated 
 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@XmlRootElement(name = "TableComponent")
@XmlAccessorType(XmlAccessType.FIELD)
public class TableComponent extends ICEObject implements Component {

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The java.util.HashTable that contains the rows. The key of the hashtable
	 * is an integer that represents the row index in the table. The value is a
	 * java.util.ArrayList that contains the set of Entries for that row. The
	 * value for key = 0 is the Row Template.
	 * </p>
	 * <!-- end-UML-doc -->
	 */
	private Hashtable<Integer, ArrayList<Entry>> rowTable;
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * A list containing the names of the columns.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlElement(name = "ColumnNames")
	private ArrayList<String> columnNames;

	/**
	 * <!-- begin-UML-doc -->
	 * <p >
	 * The set of DataComponents that represents the rows of the table. The
	 * index of the set represents the row index in the table. The DataComponent
	 * at i = 0 is the Row Template.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
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
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The constructor
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TableComponent() {
		// begin-user-code
		columnNames = new ArrayList<String>();
		rowComponents = new ArrayList<DataComponent>();
		listeners = new ArrayList<IUpdateableListener>();
		selectedRows = new ArrayList<Integer>();
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation returns the number of rows that are stored in the table.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The total number of rows in the table.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int numberOfRows() {
		// begin-user-code

		// exclude columns row
		if (rowComponents.size() <= 1) {
			return 0;
		} else {
			// Index shift -> index 0 of rowComponents are the column tags and
			// are not considered rows.
			return this.rowComponents.size() - 1;
		}
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation returns the number of columns that are stored in the
	 * table. This is exactly equal to the length of a single row since the
	 * TableComponent is built off of a row template.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The number of columns.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int numberOfColumns() {
		// begin-user-code
		return this.columnNames.size();
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation retrieves an individual row from the Table. The row is
	 * returned as a collection of Entries that represent each element in the
	 * row. The collection is a new collection, but the Entries are references
	 * of the values currently stored in the TableComponent. (This prevents the
	 * rows from being re-ordered.)
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param index
	 *            <p>
	 *            The row's index or id in the table.
	 *            </p>
	 * @return <p>
	 *         The set of Entries that represent the row in the table.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<Entry> getRow(int index) {
		// begin-user-code

		// return null if index does not exist
		// Index shift -> index 0 of rowComponents are the column tags and are
		// not considered rows.
		// Also do not return a row if the index is negative
		// Boolean operation
		if (!(!rowComponents.isEmpty() & index < rowComponents.size() - 1 & index >= 0)) {
			return null;
		}

		// create a new arraylist
		ArrayList<Entry> rowArray = new ArrayList<Entry>();

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
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation adds a row to the Table and returns the index of that row.
	 * The new row may be retrieved and its Entries may be edited by calling
	 * getRow() using the returned index. When a new row is added, the elements
	 * of that row are configured from the row template using its default
	 * values. If the Row Template has not yet been set for the TableComponent,
	 * this operation cannot add a row and it returns -1.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The index of the new row in the table.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int addRow() {
		// begin-user-code
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
			dataComponent.addEntry((Entry) rowComponents.get(0)
					.retrieveAllEntries().get(i).clone());
		}

		rowComponents.add(dataComponent);
		notifyListeners();

		// Index shift -> index 0 of rowComponents are the column tags and are
		// not considered rows.
		return rowComponents.size() - 2;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation will delete the row in the table with the specified index.
	 * It will return true if it is success or false otherwise (like if it can
	 * not find a row with that index).
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param index
	 *            <p>
	 *            The index of the row that should be deleted.
	 *            </p>
	 * @return <p>
	 *         True if the row was deleted and false if some problem was
	 *         encountered, like an incorrect row id.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean deleteRow(int index) {
		// begin-user-code

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

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation sets the collection of Entries which should be used as the
	 * template for this table. This template will be used to create new rows
	 * and to determine the default values of elements and the names of columns.
	 * The row template may only be set once per TableComponent: changing the
	 * row template of a TableComponent can only be done by creating a new one.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param template
	 *            <p>
	 *            The set of Entries that represent the canonical row of this
	 *            table.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setRowTemplate(ArrayList<Entry> template) {
		// begin-user-code

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
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation returns the row template for this TableComponent.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The set of Entries that represent the canonical row of this
	 *         table.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<Entry> getRowTemplate() {
		// begin-user-code
		// Local Declarations
		int i = 0;

		// Return null if the rowTemplate has not been set
		if (this.columnNames.isEmpty()) {
			return null;
		}

		// Create a new ArrayList and return it.
		ArrayList<Entry> rowTemplate = new ArrayList<Entry>();

		for (i = 0; i < rowComponents.get(0).retrieveAllEntries().size(); i++) {
			rowTemplate.add(rowComponents.get(0).retrieveAllEntries().get(i));
		}

		return rowTemplate;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation returns the set of integers that uniquely identify rows in
	 * the table.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The set of ids or indices for the rows in the table.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<Integer> getRowIds() {
		// begin-user-code
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
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation returns the names of the table's columns.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The names of the columns.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<String> getColumnNames() {
		// begin-user-code

		// Create a new arraylist and copy it into a new array.
		// This prevents runtime edits.
		ArrayList<String> rowArray = new ArrayList<String>();

		// create copy of arraylist
		for (int i = 0; i < this.columnNames.size(); i++) {
			rowArray.add(this.columnNames.get(i));
		}

		return rowArray;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation performs a deep copy of the attributes of another
	 * TableComponent into the current TableComponent.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param otherTableComponent
	 *            <p>
	 *            The TableComponent from which information should be copied.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void copy(TableComponent otherTableComponent) {
		// begin-user-code
		// Return if otherTableComponenet is null
		if (otherTableComponent == null) {
			return;
		}

		// Copy contents into super and current object
		super.copy((ICEObject) otherTableComponent);

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
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation provides a deep copy of the TableComponent.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         A clone of the TableComponent.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Object clone() {
		// begin-user-code

		// Create a new instance, copy contents, and return it

		// create a new instance of TableComponent and copy contents
		TableComponent tableComponent = new TableComponent();
		tableComponent.copy(this);
		return tableComponent;

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation is used to check equality between the TableComponent and
	 * another TableComponent. It returns true if the TableComponents are equal
	 * and false if they are not.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param otherTableComponent
	 *            <p>
	 *            The TableComponent that should be checked for equality.
	 *            </p>
	 * @return <p>
	 *         True if the TableComponents are equal, false if not
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean equals(TableComponent otherTableComponent) {
		// begin-user-code
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
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation returns the hashcode value of the TableComponent.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The hashcode
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int hashCode() {
		// begin-user-code

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
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation returns an array of the row ids that have been marked as
	 * selected in the table.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The set of rows in the table that have been marked as selected or
	 *         null if none have been selected.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<Integer> getSelectedRows() {
		// begin-user-code
		return ((!selectedRows.isEmpty()) ? (ArrayList<Integer>) selectedRows
				.clone() : null);
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation sets the selected rows in the table.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         An array of the rows in the table that should be marked as
	 *         selected. If an id in this array is not also in the table then it
	 *         is ignored and will not be returned in a call to getSelectedRows.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setSelectedRows(ArrayList<Integer> rows) {
		// begin-user-code

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
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Component#accept(IComponentVisitor visitor)
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void accept(IComponentVisitor visitor) {
		// begin-user-code
		// Reveal our type to the visitor
		visitor.visit(this);

		// end-user-code
	}

}