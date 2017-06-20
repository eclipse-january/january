/*-
 * Copyright 2015, 2016 Kichwa Coders Ltd. and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jonah Graham - initial implementation
 */

package org.eclipse.january.examples.dataset;

import java.util.Arrays;

import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.dataset.IntegerDataset;
import org.eclipse.january.dataset.Maths;
import org.eclipse.january.dataset.Random;
import org.eclipse.january.dataset.Slice;


/**
 * A basic example of using Datasets.
 * <p>
 * To run the example, right-click on the file and choose
 * "Run As -> Java Application"
 * <p>
 * The example projects has additional dependencies so that the examples can run
 * as a Java Application.
 */
public class BasicExample {
	public static void main(String[] args) {
		Utils.suppressSLF4JError();
		System.out.println("Welcome to a Basic Example of the org.eclipse.january.");

		// Create a Dataset:
		Dataset dataset = DatasetFactory.createFromObject(new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });

		// Print the output:
		System.out.println("shape of dataset: " + Arrays.toString(dataset.getShape()));
		System.out.println("toString of dataset: " + dataset.toString());
		System.out.println("toString, with data, of dataset: \n" + dataset.toString(true));

		// Reshape the dataset:
		dataset = dataset.reshape(3, 3);
		System.out.println("reshaped dataset: \n" + dataset.toString(true));

		// create another [3, 3] shaped dataset directly
		Dataset another = DatasetFactory.createFromObject(new double[] { 1, 1, 2, 3, 5, 8, 13, 21, 34 }).reshape(3, 3);
		System.out.println("another dataset: \n" + another.toString(true));

		// do some maths on the datasets
		Dataset add = Maths.add(dataset, another);
		System.out.println("dataset + another dataset: \n" + add.toString(true));

		// do inplace maths on datasets
		Dataset inplace = DatasetFactory.createFromObject(new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }).reshape(3, 3);
		inplace.iadd(100);
		System.out.println("dataset + 100 inplace: \n" + inplace.toString(true));

		// take a slice of a dataset
		Dataset slice = dataset.getSlice(new Slice(0, 2), new Slice(1, 3));
		System.out.println("slice of dataset: \n" + slice.toString(true));

		// create a dataset with a range
		Dataset a = DatasetFactory.createRange(IntegerDataset.class, 15)
				.reshape(3, 5);
		System.out.println("Range dataset: \n" + a.toString(true));

		// create a dataset with a random
		Dataset rand = Random.rand(new int[] { 3, 4 });
		System.out.println("Random dataset: \n" + rand.toString(true));
		
		//do some more math on datasets
		Dataset sub = Maths.subtract(dataset, another);
		System.out.println("dataset - another dataset: \n" + sub.toString(true));
		
		// for more examples, see the other java files in this project
	}
}
