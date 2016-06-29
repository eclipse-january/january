/**
 */
package geometry.tests;

import org.eclipse.january.geometry.Cube;
import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.Sphere;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Sphere</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SphereTest extends ShapeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SphereTest.class);
	}

	/**
	 * Constructs a new Sphere test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SphereTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Sphere test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Sphere getFixture() {
		return (Sphere)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GeometryFactory.eINSTANCE.createSphere());
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
		Sphere sphere = GeometryFactory.eINSTANCE.createSphere();
		
		//Check that the radius can be set
		sphere.setRadius(1);
		assertEquals(1, sphere.getRadius());
		
		//Check that invalid values are ignored
		sphere.setRadius(-1);
		assertEquals(1, sphere.getRadius());
	}

} //SphereTest
