/*-
 * Copyright 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.tutorial;

import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.dataset.Maths;
import org.eclipse.january.examples.dataset.Utils;

public class C1TheBasics {

	public void doExamples() {
		Dataset a = DatasetFactory.createRange(15, Dataset.INT32).reshape(3, 5);
		Utils.print(a);

		// array of axis lengths
		Utils.print(a.getShapeRef());

		// number of dimensions, aka rank
		Utils.print(a.getRank());

		// dtype name
		Utils.printDType(a);

		// size of each item in bytes
		Utils.print(a.getItemBytes());

		// number of items
		Utils.print(a.getSize());

		Class<?> clazz = a.getClass().getSuperclass().getInterfaces()[0];
		Utils.print(clazz.toString());

		Dataset b = DatasetFactory.createFromObject(new int[] {6, 7, 8});
		Utils.print(b);

		clazz = b.getClass().getSuperclass().getInterfaces()[0];
		Utils.print(clazz.toString());
	}

	public void doArrayCreation() {
		Dataset a = DatasetFactory.createFromObject(new int[] {2, 3, 4});
		Utils.printDType(a);

		Dataset b = DatasetFactory.createFromObject(new double[] {1.2, 3.5, 5.1});
		Utils.printDType(b);

		b = DatasetFactory.createFromObject(new double[][] {{1.5, 2, 3}, {4, 5, 6}});
		Utils.printDType(b);

		Dataset c = DatasetFactory.createFromObject(new int[][] {{2, 3}, {4, 5}}, Dataset.COMPLEX128);
		Utils.print(c);
		Utils.printDType(c);

		Utils.print(DatasetFactory.zeros(new int[] {3, 4}, Dataset.FLOAT64));

		Utils.print(DatasetFactory.ones(new int[] {2, 3, 4}, Dataset.INT16));

		Utils.print(DatasetFactory.createRange(10, 30, 5, Dataset.INT32));

		Utils.print(DatasetFactory.createRange(0, 2, 0.3, Dataset.FLOAT64));

		Utils.print(DatasetFactory.createRange(0, 2, 0.3, Dataset.FLOAT64));

		Utils.print(DatasetFactory.createLinearSpace(0, 2, 9, Dataset.FLOAT64));

		Dataset x = DatasetFactory.createLinearSpace(0, 2*Math.PI, 100, Dataset.FLOAT64);
		Utils.print(x);
		Dataset f = Maths.sin(x);
		Utils.print(f);
	}

	public void doPrintArrays() {
		Dataset a = DatasetFactory.createRange(6, Dataset.INT32);
		Utils.print(a);

		Dataset b = DatasetFactory.createRange(12, Dataset.INT32).reshape(4, 3);
		Utils.print(b);
	}

	public static void main(String[] args) {
		Utils.suppressSLF4JError();

		C1TheBasics t = new C1TheBasics();
		t.doExamples();
		t.doArrayCreation();
		t.doPrintArrays();
	}

}
