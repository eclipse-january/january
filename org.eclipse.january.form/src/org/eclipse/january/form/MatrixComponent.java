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

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * <p>
 * The MatrixComponent class is a realization of the Component interface that
 * provides the functionality necessary to encapsulate a two dimensional array
 * of double values, mimicking a mathematical matrix. It provides functionality
 * to dynamically resize the matrix by allowing clients to add both rows and
 * columns. MatrixComponent can exist in two 'flavors', a square matrix which is
 * restricted to having dimensions NxN, or a non-square matrix which can have
 * dimensions MxN, where M,N are not necessarily equal. MatrixComponent also
 * provides functionality to indicate that the matrix elements must conform to a
 * certain set of allowed values. MatrixComponent can take an AllowedValueType
 * when constructed to indicate that the elements of the matrix must either be
 * an element of a desired set of elements, or the matrix elements must exist
 * within a given range of values.
 * </p>
 * 
 * @author Jay Jay Billings
 */
@XmlRootElement(name = "MatrixComponent")
public class MatrixComponent extends ICEObject implements Component {
	/**
	 * <p>
	 * Boolean attribute that indicates whether this MatrixComponent represents
	 * a square matrix or not.
	 * </p>
	 * 
	 */
	@XmlAttribute
	private boolean isSquare;

	/**
	 * <p>
	 * The individual elements of this matrix. This is a list of n*m double
	 * values for a given matrix of size nxm.
	 * </p>
	 * 
	 */
	@XmlElement
	private ArrayList<Double> elements;
	/**
	 * <p>
	 * Reference to the current number of rows in this matrix.
	 * </p>
	 * 
	 */
	@XmlAttribute
	private int nRows;
	/**
	 * <p>
	 * Reference to the current number of columns in this matrix.
	 * </p>
	 * 
	 */
	@XmlAttribute
	private int nCols;
	/**
	 * <p>
	 * Reference to this MatrixComponent's allowed value type. By default, this
	 * is undefined. Can be used to indicate that all matrix elements must
	 * belong to a desired set of values, such as for an adjacency matrix.
	 * </p>
	 * 
	 */
	@XmlAttribute
	private AllowedValueType valueType;
	/**
	 * <p>
	 * If valueType is Discrete, this defines a set of values that the matrix
	 * elements must conform to. If valueType is Continuous, this defines a
	 * range of values that the matrix elements must conform to.
	 * </p>
	 * 
	 */
	@XmlElement
	private ArrayList<Double> allowedValues;
	/**
	 * <p>
	 * An attribute that sets if the matrix can be resized.
	 * </p>
	 * 
	 */
	private boolean resizable = true;

	/**
	 * <p>
	 * Returns true if this is a MatrixComponent representing a square matrix.
	 * </p>
	 * 
	 * @return <p>
	 *         A boolean for determining if a matrix is square or not.
	 *         </p>
	 */
	@XmlTransient
	public boolean isSquare() {

		return this.isSquare;
	}

	/**
	 * <p>
	 * Add a new row to this MatrixComponent. If this Matrix is square, also add
	 * a column through the resizeSquareMatrix private method. The resultant row
	 * is by default a row of zeros or the first element of the allowedValues
	 * array if the valueType is Discrete. Allowed values must be set if the
	 * type is not undefined for this operation to work.
	 * </p>
	 * 
	 * @return <p>
	 *         A value returned representing the row number that was added.
	 *         </p>
	 */
	public int addRow() {

		// Return if not resizable
		if (!this.resizable) {
			return -1;
		}

		// Return if Continuous or Discrete and valueType not set
		if ((this.valueType == AllowedValueType.Continuous && this.allowedValues == null)
				|| (this.valueType == AllowedValueType.Discrete && this.allowedValues == null)) {
			return -1;
		}

		if (this.isSquare) {
			this.resizeSquareMatrix(true);
		} else {
			this.resizeRow(true);
		}

		// notify listeners
		this.notifyListeners();

		// Return location of row. Zero indexed (-1)
		return this.nRows - 1;
	}

	/**
	 * <p>
	 * The Constructor, takes a boolean argument to indicate whether this matrix
	 * should be a square matrix or a non-square matrix. This constructor also
	 * takes an argument to indicate whether the elements of this matrix must
	 * conform to a given set of allowed values. If this constructor is used,
	 * users must call the setAllowedValues method to indicate either the set
	 * the elements must be, or the range they must lie in.
	 * </p>
	 * 
	 * @param isSquare
	 *            <p>
	 *            Determines if a MatrixComponent will be square.
	 *            </p>
	 * @param allowedValueType
	 *            <p>
	 *            The allowed value type for MatrixComponent.
	 *            </p>
	 */
	public MatrixComponent(boolean isSquare, AllowedValueType allowedValueType) {
		this.isSquare = isSquare;
		this.valueType = allowedValueType;

		// Setup a 1x1 matrix.
		this.elements = new ArrayList<Double>();
		elements.add(0.0);
		this.nCols = 1;
		this.nRows = 1;

		this.listeners = new ArrayList<IUpdateableListener>();
	}

	/**
	 * <p>
	 * Remove a row from this MatrixComponent. If this matrix is square, also
	 * call deletes column. Returns true if successful, false otherwise. Allowed
	 * values must be set if the type is not undefined for this operation to
	 * work.
	 * </p>
	 * 
	 * @return <p>
	 *         A number that represents the index of the row deleted.
	 *         </p>
	 */
	public boolean deleteRow() {
		double defaultValue = 0.0;

		// Return if not resizable
		if (!this.resizable) {
			return false;
		}

		// Return if Continuous or Discrete and valueType not set
		if (this.valueType == AllowedValueType.Continuous
				&& this.allowedValues == null
				|| this.valueType == AllowedValueType.Discrete
				&& this.allowedValues == null) {
			return false;
		}

		// Figure out default value
		if (this.valueType != AllowedValueType.Undefined) {
			defaultValue = this.allowedValues.get(0);
		}

		// If there is only 1 element in the list and its not default, delete
		// the whole entity and reset
		if (elements.size() == 1 && elements.get(0) != defaultValue) {
			this.elements = new ArrayList<Double>();
			this.elements.add(defaultValue);
			return true; // Return
		} else if (elements.size() == 1 && elements.get(0) == defaultValue) {
			return false; // Nothing to delete, return
		}

		// If there is only one row, delete whole row, reset to 1x1 matrix, and
		// return true
		if (elements.size() == this.nCols) {
			this.nCols = 1;
			this.nRows = 1;
			this.elements = new ArrayList<Double>();
			this.elements.add(defaultValue);
			return true; // Return
		}

		// Determine if its square or not. Delete one side or two.
		if (this.isSquare) {
			this.resizeSquareMatrix(false);
		} else {
			this.resizeRow(false);
		}

		// notify listeners
		this.notifyListeners();

		return true;
	}

	/**
	 * <p>
	 * This operation returns the number of rows that are stored in the matrix.
	 * </p>
	 * 
	 * @return <p>
	 *         The number of rows.
	 *         </p>
	 */
	public int numberOfRows() {

		return this.nRows;
	}

	/**
	 * <p>
	 * This operation returns the number of columns that are stored in the
	 * matrix.
	 * </p>
	 * 
	 * @return <p>
	 *         The number of columns.
	 *         </p>
	 */
	public int numberOfColumns() {
		// TODO Auto-generated method stub
		return this.nCols;
	}

	/**
	 * <p>
	 * This operation performs a deep copy of the attributes of another
	 * MatrixComponent into the current MatrixComponent.
	 * </p>
	 * 
	 * @param otherMatrixComponent
	 *            <p>
	 *            The TableComponent from which information should be copied.
	 *            </p>
	 */
	public void copy(MatrixComponent otherMatrixComponent) {
		// Return if otherMatrixComponenet is null
		if (otherMatrixComponent == null) {
			return;
		}

		// Copy contents into super and current object
		super.copy(otherMatrixComponent);

		// Get allowed values and elements correctly - unique!
		if (otherMatrixComponent.allowedValues == null) {
			this.allowedValues = otherMatrixComponent.allowedValues;
		} else {
			this.allowedValues = new ArrayList<Double>();
			for (int i = 0; i < otherMatrixComponent.allowedValues.size(); i++) {
				this.allowedValues.add(otherMatrixComponent.allowedValues
						.get(i));
			}
		}
		if (otherMatrixComponent.elements == null) {
			this.elements = otherMatrixComponent.elements;
		} else {
			this.elements = new ArrayList<Double>();
			for (int i = 0; i < otherMatrixComponent.elements.size(); i++) {
				this.elements.add(otherMatrixComponent.elements.get(i));
			}
		}

		// get other attributes
		this.isSquare = otherMatrixComponent.isSquare;
		this.nCols = otherMatrixComponent.nCols;
		this.nRows = otherMatrixComponent.nRows;
		this.resizable = otherMatrixComponent.resizable;
		this.valueType = otherMatrixComponent.valueType;

		this.notifyListeners();

	}

	/**
	 * <p>
	 * This operation provides a deep copy of the MatrixComponent.
	 * </p>
	 * 
	 * @return <p>
	 *         A clone of the TableComponent.
	 *         </p>
	 */
	@Override
	public Object clone() {
		// create a new instance of MatrixComponent and copy contents
		MatrixComponent matrixComponent = new MatrixComponent();
		matrixComponent.copy(this);
		return matrixComponent;
	}

	/**
	 * <p>
	 * This operation is used to check equality between the MatrixComponent and
	 * another MatrixComponent. It returns true if the MatrixComponents are
	 * equal and false if they are not.
	 * </p>
	 * 
	 * @param otherMatrixComponent
	 *            <p>
	 *            The TableComponent that should be checked for equality.
	 *            </p>
	 * @return <p>
	 *         True if the TableComponents are equal, false if not
	 *         </p>
	 */
	@Override
	public boolean equals(Object otherMatrixComponent) {
		
		boolean retVal = true;
		// Check if they are the same reference in memory
		if (this == otherMatrixComponent) {
			return true;
		}

		// Check that the object is not null, and that it is a MatrixComponent
		if (otherMatrixComponent == null
				|| !(otherMatrixComponent instanceof MatrixComponent)) {
			return false;
		}

		// Check that these objects have the same ICEObject data
		if (!super.equals(otherMatrixComponent)) {
			return false;
		}

		// At this point, other object must be a MatrixComponent, so cast it
		MatrixComponent castedComponent = (MatrixComponent) otherMatrixComponent;

		// Check each attribute

		retVal = (this.isSquare == castedComponent.isSquare)
				&& (this.resizable == castedComponent.resizable)
				&& (this.allowedValues.equals(castedComponent.allowedValues))
				&& (this.elements.equals(castedComponent.elements))
				&& (this.nCols == castedComponent.nCols)
				&& (this.nRows == castedComponent.nRows)
				&& (this.valueType == castedComponent.valueType);
		return retVal;

	}

	/**
	 * <p>
	 * This operation returns the hashcode value of the MatrixComponent.
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

		// Compute hash code from MatrixComponent data

		// Grab ICEObject data
		hash = 31 * hash + super.hashCode();

		// Grab attributes

		// Rows and cols
		hash = 31 * hash + this.nCols;
		hash = 31 * hash + this.nRows;

		// If allowed values is not null
		if (allowedValues != null) {
			hash = 31 * hash + this.allowedValues.hashCode();
		}

		// if elements are not null
		if (this.elements != null) {
			hash = 31 * hash + this.elements.hashCode();
		}

		// Value type
		hash = 31 * hash + this.valueType.hashCode();

		// Check isSquare
		if (this.isSquare) {
			hash = 31 * hash + 2;
		} else {
			hash = 31 * hash + 1;
		}

		// Check is resizable
		if (this.resizable) {
			hash = 31 * hash + 2;
		} else {
			hash = 31 * hash + 1;
		}

		return hash;
	}

	/**
	 * <p>
	 * Add a new column to this MatrixComponent. If this Matrix is square, it
	 * will also add a row through the resizeSquareMatrix private method. The
	 * resultant column is by default a row of zeros or the first element of the
	 * allowedValues array if the valueType is Discrete. Allowed values must be
	 * set if the type is not undefined for this operation to work.
	 * </p>
	 * 
	 * @return <p>
	 *         A value returned representing the column number that was added.
	 *         </p>
	 */
	public int addColumn() {

		// Return if not resizable
		if (!this.resizable) {
			return -1;
		}

		// Return if Continuous or Discrete and valueType not set
		if ((this.valueType == AllowedValueType.Continuous && this.allowedValues == null)
				|| (this.valueType == AllowedValueType.Discrete && this.allowedValues == null)) {
			return -1;
		}

		if (this.isSquare) {
			this.resizeSquareMatrix(true);
		} else {
			this.resizeColumn(true);
		}

		// notify listeners
		this.notifyListeners();

		// Return location of columns. Zero indexed (-1)
		return this.nCols - 1;
	}

	/**
	 * <p>
	 * Remove a column from this MatrixComponent. Returns true if successful,
	 * false otherwise. Allowed values must be set if the type is not undefined
	 * for this operation to work.
	 * </p>
	 * 
	 * @return <p>
	 *         A number that represents the index of the column deleted.
	 *         </p>
	 */
	public boolean deleteColumn() {
		double defaultValue = 0.0;

		// Return if not resizable
		if (!this.resizable) {
			return false;
		}

		// Return if Continuous or Discrete and valueType not set
		if ((this.valueType == AllowedValueType.Continuous && this.allowedValues == null)
				|| (this.valueType == AllowedValueType.Discrete && this.allowedValues == null)) {
			return false;
		}

		// Figure out default value
		if (this.valueType != AllowedValueType.Undefined) {
			defaultValue = this.allowedValues.get(0);
		}

		// If there is only 1 element in the list and its not default, delete
		// the whole entity and reset
		if (elements.size() == 1 && elements.get(0) != defaultValue) {
			this.elements = new ArrayList<Double>();
			this.elements.add(defaultValue);
			return true; // Return
		} else if (elements.size() == 1 && elements.get(0) == defaultValue) {
			return false; // Nothing to delete, return
		}

		// If there is only one col, delete whole col, reset to 1x1 matrix, and
		// return true
		if (elements.size() == this.nRows) {
			this.nCols = 1;
			this.nRows = 1;
			this.elements = new ArrayList<Double>();
			this.elements.add(defaultValue);
			return true; // Return
		}

		// Determine if its square or not. Delete one side or two.
		if (this.isSquare) {
			this.resizeSquareMatrix(false);
		} else {
			this.resizeColumn(false);
		}

		// notify listeners
		this.notifyListeners();

		return true;
	}

	/**
	 * <p>
	 * Set the value of the individual matrix element at index i,j. Returns true
	 * if successful, false if String value was not valid or the index was out
	 * of range.
	 * </p>
	 * 
	 * @param rowIndex
	 *            <p>
	 *            The row Index.
	 *            </p>
	 * @param colIndex
	 *            <p>
	 *            The column index.
	 *            </p>
	 * @param value
	 *            <p>
	 *            The value to be set.
	 *            </p>
	 * @return <p>
	 *         Returns true if operation was successful. False otherwise.
	 *         </p>
	 */
	public boolean setElementValue(int rowIndex, int colIndex, Double value) {
		int location;

		// Return if value is null
		if (value == null) {
			return false;
		}

		// Return if negative
		if (rowIndex < 0 || colIndex < 0) {
			return false;
		}

		// Return if out of range
		if (rowIndex >= this.nRows || colIndex >= this.nCols) {
			return false;
		}

		// Return if allowedValueType is not set
		// Return if Continuous or Discrete and valueType not set
		if ((this.valueType == AllowedValueType.Continuous && this.allowedValues == null)
				|| (this.valueType == AllowedValueType.Discrete && this.allowedValues == null)) {
			return false;
		}

		// check value to see if valid
		if (this.valueType == AllowedValueType.Continuous) {
			if (value < this.allowedValues.get(0)
					|| value > this.allowedValues.get(1)) {
				return false;
			}
		} else if (this.valueType == AllowedValueType.Discrete
				&& !this.allowedValues.contains(value)) {
			return false;
		}

		elements.set(nCols * rowIndex + colIndex, value);

		// notify listeners
		this.notifyListeners();

		return true;
	}

	/**
	 * <p>
	 * Return the double valued matrix element at index i,j. Returns null if
	 * invalid index.
	 * </p>
	 * 
	 * @param rowIndex
	 *            <p>
	 *            The row index.
	 *            </p>
	 * @param colIndex
	 *            <p>
	 *            The column index.
	 *            </p>
	 * @return <p>
	 *         The value at rowIndex, colIndex.
	 *         </p>
	 */
	public Double getElementValue(int rowIndex, int colIndex) {
		int location;
		// Return if negative
		if (rowIndex < 0 || colIndex < 0) {
			return null;
		}

		// Return if out of range
		if (rowIndex >= this.nRows || colIndex >= this.nCols) {
			return null;
		}

		// Return if the valueType is not set correctly
		// Return if Continuous or Discrete and valueType not set
		if ((this.valueType == AllowedValueType.Continuous && this.allowedValues == null)
				|| (this.valueType == AllowedValueType.Discrete && this.allowedValues == null)) {
			return null;
		}

		return this.elements.get(nCols * rowIndex + colIndex);

	}

	/**
	 * <p>
	 * If this MatrixComponent's valueType attribute is anything other than
	 * Undefined, use this method to indicate a list of matrix element allowed
	 * values. Useful for matrices that must have elements that adhere to a
	 * certain set of values, such as an adjacency matrix (ones and zeros).
	 * Values must be valid for this operation to pass.
	 * </p>
	 * 
	 * @param values
	 *            <p>
	 *            The allowed values to be set.
	 *            </p>
	 */
	public void setAllowedValues(ArrayList<Double> values) {
		// Return if the values have been set or if the values passed are null
		if (values == null || this.allowedValues != null) {
			return;
		}

		// Return if the values are empty
		if (values.isEmpty()) {
			return;
		}

		// Return if the allowedValues is continuous, but the values passed are
		// null

		if (values.size() != 2 && this.valueType == AllowedValueType.Continuous) {
			return;
		}

		// Reset values inside matrix

		// This should not happen, but this is a safety feature. Values can only
		// be set IFF there is
		// only a fresh matrix
		if (this.elements.size() > 1 || this.elements.isEmpty()) {
			return;
		}

		elements.set(0, values.get(0));

		// Set values - Do a copy
		this.allowedValues = new ArrayList<Double>();
		for (int i = 0; i < values.size(); i++) {
			allowedValues.add(values.get(i));
		}

		// notify listeners
		this.notifyListeners();

	}

	/**
	 * <p>
	 * The default nullary constructor.
	 * </p>
	 * 
	 */
	public MatrixComponent() {
		this.isSquare = false;
		this.valueType = AllowedValueType.Undefined;

		// Setup a 1x1 matrix.
		this.elements = new ArrayList<Double>();
		elements.add(0.0);
		this.nCols = 1;
		this.nRows = 1;

		this.listeners = new ArrayList<IUpdateableListener>();
	}

	/**
	 * <p>
	 * The Constructor, takes a boolean argument to indicate whether this matrix
	 * should be a square matrix or a non-square matrix.
	 * </p>
	 * 
	 * @param isSquare
	 *            <p>
	 *            Determines if a MatrixComponent is square.
	 *            </p>
	 */
	public MatrixComponent(boolean isSquare) {
		this.isSquare = isSquare;
		this.valueType = AllowedValueType.Undefined;

		// Setup a 1x1 matrix.
		this.elements = new ArrayList<Double>();
		elements.add(0.0);
		this.nCols = 1;
		this.nRows = 1;

		this.listeners = new ArrayList<IUpdateableListener>();
	}

	/**
	 * <p>
	 * Return a row of values at the given index.
	 * </p>
	 * 
	 * @param index
	 *            <p>
	 *            The index of the row.
	 *            </p>
	 * @return <p>
	 *         An arraylist of a row at index.
	 *         </p>
	 */
	public ArrayList<Double> getRow(int index) {
		ArrayList<Double> rowArray;
		int placeInElements = 0;

		// If the index is negative or out of range, return null
		if (index < 0 || index >= nRows) {
			return null;
		}

		// create a new double array
		rowArray = new ArrayList<Double>();

		// Figure out where in the elements list the item is
		placeInElements = this.nCols * index;

		// copy contents of row
		for (int i = placeInElements; i < this.nCols * (index + 1); i++) {
			rowArray.add(this.elements.get(i));
		}

		// return array
		return rowArray;
	}

	/**
	 * <p>
	 * Get a column of values at the given index.
	 * </p>
	 * 
	 * @param index
	 *            <p>
	 *            The column index.
	 *            </p>
	 * @return <p>
	 *         An arraylist of columns.
	 *         </p>
	 */
	public ArrayList<Double> getColumn(int index) {
		// Local declarations
		ArrayList<Double> colArray;
		int placeInElements = -1;

		// If the index is negative or out of range, return null
		if (index < 0 || index >= nCols) {
			return null;
		}

		// create a new double array
		colArray = new ArrayList<Double>();

		// Figure out where in the elements list the item is
		placeInElements = this.nRows * index;

		// copy contents of row
		for (int i = placeInElements; i < this.nRows * (index + 1); i++) {
			colArray.add(this.elements.get(i));
		}

		// return array
		return colArray;
	}

	/**
	 * <p>
	 * Private operation to add or remove a row to the array of double valued
	 * matrix elements. Takes a boolean argument that indicates whether to add
	 * or remove a row: true indicates add, false indicates remove.
	 * </p>
	 * 
	 * @param addOrRemove
	 *            <p>
	 *            True if add, false if remove.
	 *            </p>
	 */
	private void resizeRow(boolean addOrRemove) {

		// Local Declaration
		int i, j;
		double defaultValue = 0.0;

		// Get the defaultValue

		if (this.valueType != AllowedValueType.Undefined) {
			defaultValue = this.allowedValues.get(0);
		}

		// If true, add to the arraylist
		if (addOrRemove) {

			// Add for the number of columns
			for (i = 0; i < this.nCols; i++) {
				this.elements.add(defaultValue);
			}
			// Add to the row
			this.nRows += 1;
		} else {
			// Remove for the number of columns
			for (i = 0; i < this.nCols; i++) {
				this.elements.remove(this.elements.size() - 1);
			}
			// Remove a row
			this.nRows -= 1;
		}

	}

	/**
	 * <p>
	 * Private operation to add or remove a column to the array of double valued
	 * matrix elements. Takes a boolean argument that indicates whether to add
	 * or remove a column: true indicates add, false indicates remove.
	 * </p>
	 * 
	 * @param addOrRemove
	 *            <p>
	 *            True if add. False if remove.
	 *            </p>
	 */
	private void resizeColumn(boolean addOrRemove) {
		// Local Declaration
		int i, j;
		double defaultValue = 0.0;

		// Get the defaultValue

		if (this.valueType != AllowedValueType.Undefined) {
			defaultValue = this.allowedValues.get(0);
		}

		// If true, add to the arraylist
		if (addOrRemove) {

			// Add for the number of rows
			for (i = 0; i < this.nRows; i++) {
				this.elements.add(((i + 1) * this.nCols) + i, defaultValue);
			}
			// Add to the cols
			this.nCols += 1;
		} else {
			// Remove for the number of rows
			for (i = 0; i < this.nRows; i++) {
				this.elements.remove(((i + 1) * this.nCols) - i - 1);
			}
			// Remove a Column
			this.nCols -= 1;
		}

	}

	/**
	 * <p>
	 * Private operation to resize both the rows and the columns of the array of
	 * double valued matrix elements in the event this MatrixComponent is
	 * square. Takes a boolean argument that indicates whether to add or remove
	 * a row and column: true indicates add, false indicates remove.
	 * </p>
	 * 
	 * @param addOrRemove
	 *            <p>
	 *            True if add, false if remove.
	 *            </p>
	 */
	private void resizeSquareMatrix(boolean addOrRemove) {

		// Logic to determine add or remove row and column.
		if (addOrRemove) {
			this.resizeColumn(true);
			this.resizeRow(true);
		} else {
			this.resizeColumn(false);
			this.resizeRow(false);
		}

	}

	/**
	 * <p>
	 * Returns true if the matrix can be resized. False otherwise.
	 * </p>
	 * 
	 * @return <p>
	 *         A boolean to determine resizable attribute.
	 *         </p>
	 */
	@XmlAttribute
	public boolean isResizable() {
		// TODO Auto-generated method stub
		return this.resizable;
	}

	/**
	 * <p>
	 * Sets the matrix to be resized or not.
	 * </p>
	 * 
	 * @param resizable
	 *            <p>
	 *            An attribute to set resizable. Default true.
	 *            </p>
	 */
	public void setResizable(boolean resizable) {
		this.resizable = resizable;

		// notify listeners
		this.notifyListeners();

	}

	/**
	 * <p>
	 * Returns the ICE's AllowedValueType. If this is not set, returns null.
	 * </p>
	 * 
	 * @return <p>
	 *         An ArrayList of doubles.
	 *         </p>
	 */
	@XmlTransient
	public AllowedValueType getAllowedValueType() {

		return this.valueType;
	}

	/**
	 * <p>
	 * Returns a list of allowed value types if discrete or continuous. If
	 * undefined or not set, returns null.
	 * </p>
	 * 
	 * @return <p>
	 *         An AllowedValueType.
	 *         </p>
	 */
	@XmlTransient
	public ArrayList<Double> getAllowedValues() {
		ArrayList<Double> tempDoubles = new ArrayList<Double>();
		// if null, return null
		if (this.allowedValues == null) {
			return null;
		}

		// Create a clone
		for (int i = 0; i < this.allowedValues.size(); i++) {
			tempDoubles.add(this.allowedValues.get(i));
		}

		return tempDoubles;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.ICEObject.ICEObject#update(java.lang.String, java.lang.String)
	 */
	@Override
	public void update(String updatedKey, String newValue) {
		// TODO Auto-generated method stub

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