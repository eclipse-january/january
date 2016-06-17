/*******************************************************************************
 * Copyright (c) 2016 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Robert Smith
 *******************************************************************************/
package org.eclipse.eavp.viz.modeling;

/**
 * A collection of utility methods for use with the JavaFX mesh classes.
 * 
 * @author Robert Smith
 *
 */
public class MeshUtils {

	/**
	 * Creates a series of points which lie evenly spaced on the edge of a
	 * circle on the XZ plane defined by the arguments.
	 * 
	 * @param radius
	 *            The circle's radius
	 * @param samples
	 *            The number of points to create
	 * @return An array of floats defining the points on the circle. It is
	 *         ordered as: the first point's x coordinate, the first point's z
	 *         coordinate, the second point's x coordinate, the second point's y
	 *         coordinate, the third point's x coordinate, etc.
	 */
	public static float[] createCircle(float radius, int samples) {

		// The points defining the circle
		float[] points = new float[samples * 2];

		// The angle of the current point on the circle
		float angle = 0;

		for (int i = 0; i < samples; i++) {

			// Place the point's coordinates into the array
			points[i * 2] = (float) (radius * Math.cos(angle));
			points[i * 2 + 1] = (float) (radius * Math.sin(angle));

			// Move the angle by 1/(number of samples)th of the circle.
			angle += 2f / samples * Math.PI;
		}

		return points;
	}

}
