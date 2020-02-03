package org.eclipse.january.dataset;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * 
 * This test attempts to show differences in the dataset iterator approach
 * vs. compiler optimised loop. It shows where January gets slow (impressively large),
 * where compiler optimisation wins out.
 * 
 * @author Matt Gerring
 *
 */
@Ignore
public class SpeedTest {

	@Before
	public void setup() {
		// We are doing a speed test so we run it once
		// to make sure libary loading is not timed.
		multiplyDoubles(Random.rand(10), Math.PI, false);
		multiplyDoubles(Random.rand(10), Random.rand(10), false);
		multiplyDoubles(Random.rand(10,10), Random.rand(10), false);
	}
	
	@Test
	public void imulConstant() throws Exception {
		System.out.println(">> Constant");
		multiplyDoubles(Random.rand(10000), Math.PI);
		multiplyDoubles(Random.rand(1000,1000), Math.PI);
		multiplyDoubles(Random.rand(5000,5000), Math.PI);
		multiplyDoubles(Random.rand(10,1000,1000), Math.PI);
		System.out.println(">>>>>");
	}
	
	@Test
	public void imulDataset() throws Exception {

		System.out.println(">> Matrix");
		multiplyDoubles(Random.rand(10000), Random.rand(10000));
		multiplyDoubles(Random.rand(1000,1000), Random.rand(1000,1000));
		multiplyDoubles(Random.rand(5000,5000), Random.rand(5000,5000));
		multiplyDoubles(Random.rand(10,1000,1000), Random.rand(10,1000,1000));
		System.out.println(">>>>>");
	}
	
	@Test
	public void imulColumn() throws Exception {

		System.out.println(">> Column");
		multiplyDoubles(Random.rand(1000,1000), Random.rand(1000));
		multiplyDoubles(Random.rand(5000,5000), Random.rand(5000));
		System.out.println(">>>>>");
	}
	
	private void multiplyDoubles(final Dataset data, final Object val) {
		multiplyDoubles(data, val, true);
	}
	
	private void multiplyDoubles(final Dataset data, final Object val, boolean realTest) {
		
		// Using iterator
		long dt = time(()->data.imultiply(val));
		if (realTest) {
			System.out.println("Time imultiply shape "+Arrays.toString(data.getShape())+" was "+dt+"ms");
		}
		
		Runnable nr = getNaiveImplementation(data, val);
		long nt = time(nr);
		if (realTest) {
			System.out.println("Time basic loop "+Arrays.toString(data.getShape())+" was "+nt+"ms");
		}
		
		// We do not want these tests to be too much slower than simple loop.
		if (realTest) assertTrue((2*nt)+25 >= dt); // The test is no longer than twice plus a small number constant. 
		// Adding  a small number constant allows for small differences to be ironed out.
	}

	private Runnable getNaiveImplementation(Dataset data, Object val) {
		if (val instanceof Dataset) {
			Dataset dsVal = (Dataset)val;
			final double[] da1 = (double[])data.getBuffer();
			final double[] da2 = (double[])dsVal.getBuffer();
			if (Arrays.equals(data.getShape(), dsVal.getShape())) {
				return ()-> {
					for (int i = 0; i < da1.length; i++) da1[i] *= da2[i];
				};
			} else { // Assume columnwise multiply
				return () -> {
					for (int i = 0; i < da1.length; i++) {
						da1[i] *= da2[i%da2.length];
					}
				};
			}
		} else {
			double dblValue = (double)val;
			final double[] da = (double[])data.getBuffer();
			return ()->{
				for (int i = 0; i < da.length; i++) da[i] *= dblValue;
			};
		}
		
	}

	private long time(Runnable nr) {
		long b = System.currentTimeMillis();
		nr.run();
		long a = System.currentTimeMillis();
		return Math.max(1, a-b); // 1 or more for out concerns here.
	}
}
