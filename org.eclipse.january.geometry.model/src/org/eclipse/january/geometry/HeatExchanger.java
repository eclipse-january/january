/**
 */
package org.eclipse.january.geometry;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Heat Exchanger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A heat exchanger is a wrapper around a pipe shape. It represents connections between up to four junctions. The HeatExchanger will be drawn as a box around the pipe and two additional cylindrical shells which connect the box to up to two junction. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.january.geometry.HeatExchanger#getPipe <em>Pipe</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.HeatExchanger#getInput <em>Input</em>}</li>
 *   <li>{@link org.eclipse.january.geometry.HeatExchanger#getOutput <em>Output</em>}</li>
 * </ul>
 *
 * @see org.eclipse.january.geometry.GeometryPackage#getHeatExchanger()
 * @model
 * @generated
 */
public interface HeatExchanger extends Shape {
	/**
	 * Returns the value of the '<em><b>Pipe</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pipe</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pipe</em>' reference.
	 * @see #setPipe(Pipe)
	 * @see org.eclipse.january.geometry.GeometryPackage#getHeatExchanger_Pipe()
	 * @model
	 * @generated
	 */
	Pipe getPipe();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.HeatExchanger#getPipe <em>Pipe</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pipe</em>' reference.
	 * @see #getPipe()
	 * @generated
	 */
	void setPipe(Pipe value);

	/**
	 * Returns the value of the '<em><b>Input</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The junction which provides the input to the secondary pipe for the HeatExchanger.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Input</em>' reference.
	 * @see #setInput(Junction)
	 * @see org.eclipse.january.geometry.GeometryPackage#getHeatExchanger_Input()
	 * @model
	 * @generated
	 */
	Junction getInput();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.HeatExchanger#getInput <em>Input</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' reference.
	 * @see #getInput()
	 * @generated
	 */
	void setInput(Junction value);

	/**
	 * Returns the value of the '<em><b>Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The junction to which output is provided from the HeatExchanger's secondary pipe.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Output</em>' reference.
	 * @see #setOutput(Junction)
	 * @see org.eclipse.january.geometry.GeometryPackage#getHeatExchanger_Output()
	 * @model
	 * @generated
	 */
	Junction getOutput();

	/**
	 * Sets the value of the '{@link org.eclipse.january.geometry.HeatExchanger#getOutput <em>Output</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' reference.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(Junction value);

} // HeatExchanger
