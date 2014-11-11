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

import org.eclipse.ice.datastructures.ICEObject.ICEJAXBManipulator;
import org.eclipse.ice.datastructures.ICEObject.ICEObject;
import org.eclipse.ice.datastructures.updateableComposite.Component;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.eclipse.ice.datastructures.updateableComposite.IUpdateableListener;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.eclipse.ice.datastructures.componentVisitor.IComponentVisitor;

/**
 * <!-- begin-UML-doc -->
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
 * <!-- end-UML-doc -->
 * 
 * @author Jay Jay Billings
 * @generated 
 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@XmlRootElement(name = "MatrixComponent")
public class MatrixComponent extends ICEObject implements Component {
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Boolean attribute that indicates whether this MatrixComponent represents
	 * a square matrix or not.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlAttribute
	private boolean isSquare;

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The individual elements of this matrix. This is a list of n*m double
	 * values for a given matrix of size nxm.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlElement
	private ArrayList<Double> elements;
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Reference to the current number of rows in this matrix.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlAttribute
	private int nRows;
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Reference to the current number of columns in this matrix.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlAttribute
	private int nCols;
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Reference to this MatrixComponent's allowed value type. By default, this
	 * is undefined. Can be used to indicate that all matrix elements must
	 * belong to a desired set of values, such as for an adjacency matrix.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlAttribute
	private AllowedValueType valueType;
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * If valueType is Discrete, this defines a set of values that the matrix
	 * elements must conform to. If valueType is Continuous, this defines a
	 * range of values that the matrix elements must conform to.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlElement
	private ArrayList<Double> allowedValues;
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * An attribute that sets if the matrix can be resized.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private boolean resizable = true;

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Returns true if this is a MatrixComponent representing a square matrix.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         A boolean for determining if a matrix is square or not.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlTransient
	public boolean isSquare() {
		// begin-user-code

		return this.isSquare;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Add a new row to this MatrixComponent. If this Matrix is square, also add
	 * a column through the resizeSquareMatrix private method. The resultant row
	 * is by default a row of zeros or the first element of the allowedValues
	 * array if the valueType is Discrete. Allowed values must be set if the
	 * type is not undefined for this operation to work.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         A value returned representing the row number that was added.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int addRow() {
		// begin-user-code

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
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The Constructor, takes a boolean argument to indicate whether this matrix
	 * should be a square matrix or a non-square matrix. This constructor also
	 * takes an argument to indicate whether the elements of this matrix must
	 * conform to a given set of allowed values. If this constructor is used,
	 * users must call the setAllowedValues method to indicate either the set
	 * the elements must be, or the range they must lie in.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param isSquare
	 *            <p>
	 *            Determines if a MatrixComponent will be square.
	 *            </p>
	 * @param allowedValueType
	 *            <p>
	 *            The allowed value type for MatrixComponent.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public MatrixComponent(boolean isSquare, AllowedValueType allowedValueType) {
		// begin-user-code
		this.isSquare = isSquare;
		this.valueType = allowedValueType;

		// Setup a 1x1 matrix.
		this.elements = new ArrayList<Double>();
		elements.add(0.0);
		this.nCols = 1;
		this.nRows = 1;

		this.listeners = new ArrayList<IUpdateableListener>();
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Remove a row from this MatrixComponent. If this matrix is square, also
	 * call deletes column. Returns true if successful, false otherwise. Allowed
	 * values must be set if the type is not undefined for this operation to
	 * work.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         A number that represents the index of the row deleted.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean deleteRow() {
		// begin-user-code
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
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation returns the number of rows that are stored in the matrix.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         The number of rows.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int numberOfRows() {
		// begin-user-code

		return this.nRows;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation returns the number of columns that are stored in the
	 * matrix.
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
		// TODO Auto-generated method stub
		return this.nCols;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation performs a deep copy of the attributes of another
	 * MatrixComponent into the current MatrixComponent.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param otherMatrixComponent
	 *            <p>
	 *            The TableComponent from which information should be copied.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void copy(MatrixComponent otherMatrixComponent) {
		// begin-user-code
		// Return if otherMatrixComponenet is null
		if (otherMatrixComponent == null) {
			return;
		}

		// Copy contents into super and current object
		super.copy((ICEObject) otherMatrixComponent);

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

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation provides a deep copy of the MatrixComponent.
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
		// create a new instance of MatrixComponent and copy contents
		MatrixComponent matrixComponent = new MatrixComponent();
		matrixComponent.copy(this);
		return matrixComponent;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation is used to check equality between the MatrixComponent and
	 * another MatrixComponent. It returns true if the MatrixComponents are
	 * equal and false if they are not.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param otherMatrixComponent
	 *            <p>
	 *            The TableComponent that should be checked for equality.
	 *            </p>
	 * @return <p>
	 *         True if the TableComponents are equal, false if not
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean equals(MatrixComponent otherMatrixComponent) {
		// begin-user-code
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

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation returns the hashcode value of the MatrixComponent.
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
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * This operation overloads the ICEObject.loadFromXML() operation to
	 * properly load the MatrixComponent.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param stream
	 *            <p>
	 *            The InputStream from which the TableComponent should be
	 *            loaded.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void loadFromXML(InputStream stream) {
		// begin-user-code
		// Initialize JAXBManipulator
		jaxbManipulator = new ICEJAXBManipulator();

		// Call the read() on jaxbManipulator to create a new Object instance
		// from the inputStream
		Object dataObject;
		try {
			dataObject = jaxbManipulator.read(this.getClass(), stream);
			// Copy contents of new object into current data structure
			this.copy((MatrixComponent) dataObject);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Nullerize jaxbManipilator
		jaxbManipulator = null;

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Add a new column to this MatrixComponent. If this Matrix is square, it
	 * will also add a row through the resizeSquareMatrix private method. The
	 * resultant column is by default a row of zeros or the first element of the
	 * allowedValues array if the valueType is Discrete. Allowed values must be
	 * set if the type is not undefined for this operation to work.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         A value returned representing the column number that was added.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int addColumn() {
		// begin-user-code

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
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Remove a column from this MatrixComponent. Returns true if successful,
	 * false otherwise. Allowed values must be set if the type is not undefined
	 * for this operation to work.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         A number that represents the index of the column deleted.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean deleteColumn() {
		// begin-user-code
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
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Set the value of the individual matrix element at index i,j. Returns true
	 * if successful, false if String value was not valid or the index was out
	 * of range.
	 * </p>
	 * <!-- end-UML-doc -->
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
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean setElementValue(int rowIndex, int colIndex, Double value) {
		// begin-user-code
		// begin-user-code
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
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Return the double valued matrix element at index i,j. Returns null if
	 * invalid index.
	 * </p>
	 * <!-- end-UML-doc -->
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
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Double getElementValue(int rowIndex, int colIndex) {
		// begin-user-code
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

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * If this MatrixComponent's valueType attribute is anything other than
	 * Undefined, use this method to indicate a list of matrix element allowed
	 * values. Useful for matrices that must have elements that adhere to a
	 * certain set of values, such as an adjacency matrix (ones and zeros).
	 * Values must be valid for this operation to pass.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param values
	 *            <p>
	 *            The allowed values to be set.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setAllowedValues(ArrayList<Double> values) {
		// begin-user-code
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

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The default nullary constructor.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public MatrixComponent() {
		// begin-user-code
		this.isSquare = false;
		this.valueType = AllowedValueType.Undefined;

		// Setup a 1x1 matrix.
		this.elements = new ArrayList<Double>();
		elements.add(0.0);
		this.nCols = 1;
		this.nRows = 1;

		this.listeners = new ArrayList<IUpdateableListener>();
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * The Constructor, takes a boolean argument to indicate whether this matrix
	 * should be a square matrix or a non-square matrix.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param isSquare
	 *            <p>
	 *            Determines if a MatrixComponent is square.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public MatrixComponent(boolean isSquare) {
		// begin-user-code
		this.isSquare = isSquare;
		this.valueType = AllowedValueType.Undefined;

		// Setup a 1x1 matrix.
		this.elements = new ArrayList<Double>();
		elements.add(0.0);
		this.nCols = 1;
		this.nRows = 1;

		this.listeners = new ArrayList<IUpdateableListener>();
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Return a row of values at the given index.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param index
	 *            <p>
	 *            The index of the row.
	 *            </p>
	 * @return <p>
	 *         An arraylist of a row at index.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<Double> getRow(int index) {
		// begin-user-code
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
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Get a column of values at the given index.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param index
	 *            <p>
	 *            The column index.
	 *            </p>
	 * @return <p>
	 *         An arraylist of columns.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<Double> getColumn(int index) {
		// begin-user-code
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
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Private operation to add or remove a row to the array of double valued
	 * matrix elements. Takes a boolean argument that indicates whether to add
	 * or remove a row: true indicates add, false indicates remove.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param addOrRemove
	 *            <p>
	 *            True if add, false if remove.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private void resizeRow(boolean addOrRemove) {
		// begin-user-code

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

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Private operation to add or remove a column to the array of double valued
	 * matrix elements. Takes a boolean argument that indicates whether to add
	 * or remove a column: true indicates add, false indicates remove.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param addOrRemove
	 *            <p>
	 *            True if add. False if remove.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private void resizeColumn(boolean addOrRemove) {
		// begin-user-code
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

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Private operation to resize both the rows and the columns of the array of
	 * double valued matrix elements in the event this MatrixComponent is
	 * square. Takes a boolean argument that indicates whether to add or remove
	 * a row and column: true indicates add, false indicates remove.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param addOrRemove
	 *            <p>
	 *            True if add, false if remove.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private void resizeSquareMatrix(boolean addOrRemove) {
		// begin-user-code

		// Logic to determine add or remove row and column.
		if (addOrRemove) {
			this.resizeColumn(true);
			this.resizeRow(true);
		} else {
			this.resizeColumn(false);
			this.resizeRow(false);
		}

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Returns true if the matrix can be resized. False otherwise.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         A boolean to determine resizable attribute.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlAttribute
	public boolean isResizable() {
		// begin-user-code
		// TODO Auto-generated method stub
		return this.resizable;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Sets the matrix to be resized or not.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @param resizable
	 *            <p>
	 *            An attribute to set resizable. Default true.
	 *            </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setResizable(boolean resizable) {
		// begin-user-code
		this.resizable = resizable;

		// notify listeners
		this.notifyListeners();

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Returns the ICE's AllowedValueType. If this is not set, returns null.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         An ArrayList of doubles.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlTransient
	public AllowedValueType getAllowedValueType() {
		// begin-user-code

		return this.valueType;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Returns a list of allowed value types if discrete or continuous. If
	 * undefined or not set, returns null.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @return <p>
	 *         An AllowedValueType.
	 *         </p>
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@XmlTransient
	public ArrayList<Double> getAllowedValues() {
		// begin-user-code
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
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IUpdateable#update(String updatedKey, String newValue)
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void update(String updatedKey, String newValue) {
		// begin-user-code
		// TODO Auto-generated method stub

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