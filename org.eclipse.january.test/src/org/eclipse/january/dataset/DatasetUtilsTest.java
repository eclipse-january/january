package org.eclipse.january.dataset;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DatasetUtilsTest {

	@Test
	public void testFindIndexEqualTo() {
		Dataset dataset = DatasetFactory.createFromObject(new Double[] { 5.2, 2.0, 4.8, 13.0, 0.8, 96.0, 13.0 });
		int expected = 3;
		int actual = DatasetUtils.findIndexEqualTo(dataset, 13.0);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindIndexGreaterThan() {
		Dataset dataset = DatasetFactory.createFromObject(new Double[] { 5.2, 2.0, 4.8, 13.0, 0.8, 96.0, 13.0 });
		int expected = 5;
		int actual = DatasetUtils.findIndexGreaterThan(dataset, 50.0);
		assertEquals(expected, actual);		
	}
	
	@Test
	public void testFindIndexGreaterThanOrEqualTo() {
		Dataset dataset = DatasetFactory.createFromObject(new Double[] { 5.2, 2.0, 4.8, 13.0, 0.8, 96.0, 13.0 });
		int expected = 3;
		int actual = DatasetUtils.findIndexGreaterThanOrEqualTo(dataset, 13.0);
		assertEquals(expected, actual);	
	}
	
	@Test
	public void testFindIndexLessThan() {
		Dataset dataset = DatasetFactory.createFromObject(new Double[] { 5.2, 2.0, 4.8, 13.0, 0.8, 96.0, 13.0 });
		int expected = 4;
		int actual = DatasetUtils.findIndexLessThan(dataset, 1.0);
		assertEquals(expected, actual);	
	}
	
	@Test
	public void testFindIndexLesshanOrEqualTo() {
		Dataset dataset = DatasetFactory.createFromObject(new Double[] { 5.2, 2.0, 4.8, 13.0, 0.8, 96.0, 13.0 });
		int expected = 4;
		int actual = DatasetUtils.findIndexLessThanOrEqualTo(dataset, 0.8);
		assertEquals(expected, actual);	
	}

}
