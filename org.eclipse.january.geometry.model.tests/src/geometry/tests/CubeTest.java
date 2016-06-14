/**
 */
package geometry.tests;

import geometry.Cube;
import geometry.GeometryFactory;
import geometry.Tube;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Cube</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CubeTest extends ShapeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CubeTest.class);
	}

	/**
	 * Constructs a new Cube test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CubeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Cube test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Cube getFixture() {
		return (Cube)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GeometryFactory.eINSTANCE.createCube());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}
	
	/**
	 * Check that only valid values are accepted for the properties.
	 * 
	 * @generated NOT
	 */
	public void checkProperties(){
		
		//The cube to be tested
		Cube cube = GeometryFactory.eINSTANCE.createCube();
		
		//Check that the length can be set
		cube.setSideLength(1);
		assertEquals(1, cube.getSideLength());
		
		//Check that invalid values are ignored
		cube.setSideLength(-1);
		assertEquals(1, cube.getSideLength());
	}

} //CubeTest
