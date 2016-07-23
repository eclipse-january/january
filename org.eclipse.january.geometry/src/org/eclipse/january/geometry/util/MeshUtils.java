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
package org.eclipse.january.geometry.util;

import java.util.ArrayList;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.january.geometry.GeometryFactory;
import org.eclipse.january.geometry.Triangle;
import org.eclipse.january.geometry.Vertex;

/**
 * A collection of utility methods for use with the JavaFX mesh classes.
 * 
 * @author Robert Smith
 * 
 * @generated NOT
 *
 */
public class MeshUtils {

	/**
	 * Create an array containing the given three dimensional points moved to be
	 * centered around the given vertex.
	 * 
	 * @param points
	 *            The coordinates for the original points, given in the format
	 *            x1, y1, z1, x2, y2, z2, x3... centered around the origin.
	 * @param center
	 *            The vertex around which the coordinates will be moved.
	 * @return An array of coordinates, each shifted by the distance from the
	 *         origin to the center
	 */
	public static double[] centerPoints(double[] points, Vertex center) {

		// The coordinates after being moved
		double[] centered = new double[points.length];

		// Move each coordinate relative to the new center
		for (int i = 0; i < points.length / 3; i++) {
			centered[i * 3] = points[i * 3] + center.getX();
			centered[i * 3 + 1] = points[i * 3 + 1] + center.getY();
			centered[i * 3 + 2] = points[i * 3 + 2] + center.getZ();
		}

		return centered;

	}

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
	public static double[] createCircle(double radius, int samples) {

		// The points defining the circle
		double[] points = new double[samples * 2];

		// The angle of the current point on the circle
		double angle = 0;

		for (int i = 0; i < samples; i++) {

			// Place the point's coordinates into the array
			points[i * 2] = radius * Math.cos(angle);
			points[i * 2 + 1] = radius * Math.sin(angle);

			// Move the angle by 1/(number of samples)th of the circle.
			angle += 2f / samples * Math.PI;
		}

		return points;
	}

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

	/**
	 * Create a list of 3D points forming the vertices of a rectangular prism
	 * with the given side lengths. The points will be specified in the format
	 * of the first point's three coordinates (x1, y1, z1) followed by the
	 * second point's three coordinates (x2, y2, z2).
	 * 
	 * @param lengthX
	 *            The box's x side length.
	 * @param lengthY
	 *            The box's y side length.
	 * @param lengthZ
	 *            The box's z side length.
	 * @return A list of 36 coordinates, ordered in 12 blocks, one for each
	 *         point, containing that point's coordinates in the order x, y, z.
	 */
	public static double[] createRectangularPrism(double lengthX,
			double lengthY, double lengthZ) {

		double[] points = new double[24];

		// Point 0
		points[0] = -lengthX / 2;
		points[1] = -lengthY / 2;
		points[2] = -lengthZ / 2;

		// Point 1
		points[3] = -lengthX / 2;
		points[4] = -lengthY / 2;
		points[5] = lengthZ / 2;

		// Point 2
		points[6] = -lengthX / 2;
		points[7] = lengthY / 2;
		points[8] = -lengthZ / 2;

		// Point 3
		points[9] = -lengthX / 2;
		points[10] = lengthY / 2;
		points[11] = lengthZ / 2;

		// Point 4
		points[12] = lengthX / 2;
		points[13] = -lengthY / 2;
		points[14] = -lengthZ / 2;

		// Point 5
		points[15] = lengthX / 2;
		points[16] = -lengthY / 2;
		points[17] = lengthZ / 2;

		// Point 6
		points[18] = lengthX / 2;
		points[19] = lengthY / 2;
		points[20] = -lengthZ / 2;

		// Point 7
		points[21] = lengthX / 2;
		points[22] = lengthY / 2;
		points[23] = lengthZ / 2;

		return points;
	}

	/**
	 * Create a list of triangles which form a box between the eight input
	 * points. It is expected that the eight points will be specified one at a
	 * time by their x, y, and z coordinates and laid out in the following
	 * order:
	 * 
	 * (Side 1)
	 * 
	 * 0 1
	 * 
	 * 2 3
	 * 
	 * (Side 2)
	 * 
	 * 4 5
	 * 
	 * 6 7
	 * 
	 * @param points
	 *            A length 24 array containing the eight points defining the
	 *            corners of the mesh, specified in the order x1, y1, z1, x2,
	 *            y2, z2, x3...
	 * @return A list of 12 triangles defining the rectangular prism, two for
	 *         each of its sides.
	 */
	public static EList<Triangle> createRectangularPrismMesh(double[] points) {

		// Point 0
		Vertex v0 = GeometryFactory.eINSTANCE.createVertex();
		v0.setX(points[0]);
		v0.setY(points[1]);
		v0.setZ(points[2]);

		// Point 1
		Vertex v1 = GeometryFactory.eINSTANCE.createVertex();
		v1.setX(points[3]);
		v1.setY(points[4]);
		v1.setZ(points[5]);

		// Point 2
		Vertex v2 = GeometryFactory.eINSTANCE.createVertex();
		v2.setX(points[6]);
		v2.setY(points[7]);
		v2.setZ(points[8]);

		// Point 3
		Vertex v3 = GeometryFactory.eINSTANCE.createVertex();
		v3.setX(points[9]);
		v3.setY(points[10]);
		v3.setZ(points[11]);

		// Point 4
		Vertex v4 = GeometryFactory.eINSTANCE.createVertex();
		v4.setX(points[12]);
		v4.setY(points[13]);
		v4.setZ(points[14]);

		// Point 5
		Vertex v5 = GeometryFactory.eINSTANCE.createVertex();
		v5.setX(points[15]);
		v5.setY(points[16]);
		v5.setZ(points[17]);

		// Point 6
		Vertex v6 = GeometryFactory.eINSTANCE.createVertex();
		v6.setX(points[18]);
		v6.setY(points[19]);
		v6.setZ(points[20]);

		// Point 7
		Vertex v7 = GeometryFactory.eINSTANCE.createVertex();
		v7.setX(points[21]);
		v7.setY(points[22]);
		v7.setZ(points[23]);

		// The list of triangles which form the prism
		BasicEList<Triangle> triangles = new BasicEList<Triangle>();

		// Start adding the faces, with each face of the cube formed from two
		// triangles. Triangles' vertices are specified in order according to
		// the right hand rule.
		// Left side face 1
		Triangle t0 = GeometryFactory.eINSTANCE.createTriangle();
		t0.getVertices().add((Vertex) v2.clone());
		t0.getVertices().add((Vertex) v0.clone());
		t0.getVertices().add((Vertex) v1.clone());
		triangles.add(t0);

		// Left side Face 2
		Triangle t1 = GeometryFactory.eINSTANCE.createTriangle();
		t1.getVertices().add((Vertex) v3.clone());
		t1.getVertices().add((Vertex) v2.clone());
		t1.getVertices().add((Vertex) v1.clone());
		triangles.add(t1);

		// Top side Face 1
		Triangle t2 = GeometryFactory.eINSTANCE.createTriangle();
		t2.getVertices().add((Vertex) v2.clone());
		t2.getVertices().add((Vertex) v3.clone());
		t2.getVertices().add((Vertex) v7.clone());
		triangles.add(t2);

		// Top side Face 2
		Triangle t3 = GeometryFactory.eINSTANCE.createTriangle();
		t3.getVertices().add((Vertex) v2.clone());
		t3.getVertices().add((Vertex) v7.clone());
		t3.getVertices().add((Vertex) v6.clone());
		triangles.add(t3);

		// Front side Face 1
		Triangle t4 = GeometryFactory.eINSTANCE.createTriangle();
		t4.getVertices().add((Vertex) v2.clone());
		t4.getVertices().add((Vertex) v6.clone());
		t4.getVertices().add((Vertex) v0.clone());
		triangles.add(t4);

		// Front side Face 2
		Triangle t5 = GeometryFactory.eINSTANCE.createTriangle();
		t5.getVertices().add((Vertex) v6.clone());
		t5.getVertices().add((Vertex) v4.clone());
		t5.getVertices().add((Vertex) v0.clone());
		triangles.add(t5);

		// Back side Face 1
		Triangle t6 = GeometryFactory.eINSTANCE.createTriangle();
		t6.getVertices().add((Vertex) v7.clone());
		t6.getVertices().add((Vertex) v3.clone());
		t6.getVertices().add((Vertex) v1.clone());
		triangles.add(t6);

		// Back side Face 2
		Triangle t7 = GeometryFactory.eINSTANCE.createTriangle();
		t7.getVertices().add((Vertex) v7.clone());
		t7.getVertices().add((Vertex) v1.clone());
		t7.getVertices().add((Vertex) v5.clone());
		triangles.add(t7);

		// Bottom side Face 1
		Triangle t8 = GeometryFactory.eINSTANCE.createTriangle();
		t8.getVertices().add((Vertex) v1.clone());
		t8.getVertices().add((Vertex) v0.clone());
		t8.getVertices().add((Vertex) v5.clone());
		triangles.add(t8);

		// Bottom side Face 2
		Triangle t9 = GeometryFactory.eINSTANCE.createTriangle();
		t9.getVertices().add((Vertex) v5.clone());
		t9.getVertices().add((Vertex) v0.clone());
		t9.getVertices().add((Vertex) v4.clone());
		triangles.add(t9);

		// Right side Face 1
		Triangle t10 = GeometryFactory.eINSTANCE.createTriangle();
		t10.getVertices().add((Vertex) v6.clone());
		t10.getVertices().add((Vertex) v7.clone());
		t10.getVertices().add((Vertex) v4.clone());
		triangles.add(t10);

		// Right side Face 2
		Triangle t11 = GeometryFactory.eINSTANCE.createTriangle();
		t11.getVertices().add((Vertex) v7.clone());
		t11.getVertices().add((Vertex) v5.clone());
		t11.getVertices().add((Vertex) v4.clone());
		triangles.add(t11);

		return triangles;
	}

	/**
	 * Creates a series of points which lie evenly spaced on the edge of a
	 * semicircle on the XY plane defined by the arguments.
	 * 
	 * @param radius
	 *            The circle's radius
	 * @param samples
	 *            The number of points to create
	 * @param top
	 *            Whether or not to render the top half of a circle. If true,
	 *            the top half of the circle will be rendered. If false, the
	 *            bottom half of the circle will be rendered.
	 * @return An array of floats defining the points on the circle. It is
	 *         ordered as: the first point's x coordinate, the first point's z
	 *         coordinate, the second point's x coordinate, the second point's y
	 *         coordinate, the third point's x coordinate, etc.
	 */
	public static double[] createSemiCircle(double radius, int samples,
			boolean top) {

		// The points defining the circle
		double[] points = new double[samples * 2];

		// The angle of the current point on the circle
		double angle = 0;

		for (int i = 0; i < samples; i++) {

			// Place the point's coordinates into the array
			points[i * 2] = radius * Math.cos(angle);
			points[i * 2 + 1] = radius * Math.sin(angle);

			// Move the angle by 1/(number of samples - 1)th of the circle, such
			// that the first point will be at the corner of the semicircle and
			// the last point will be at the corner of the semicircle
			angle += 1f / (samples - 1) * Math.PI;
		}

		return points;
	}

	/**
	 * Create the points which define a tube. A tube is defined by an outer
	 * cylindrical shell and, optionally, an inner cylinder sharing the same
	 * height but with a smaller radius. The tube will be oriented along the y
	 * axis and located with its midpoint at the origin.
	 * 
	 * @param height
	 *            How tall the tube will be.
	 * @param innerRadius
	 *            The radius for the inner cylinder. If innerRadius is equal to
	 *            radius, there will be no inner cylinder
	 * @param radius
	 *            The radius of the tube.
	 * @param resolution
	 *            How many sample points will exist along the circle defining
	 *            the edges of the tube.
	 * @param segments
	 *            How many sample points will be used along the cylinder's
	 *            length. The cylinder will be defined by two (or one) circles
	 *            on (segments + 1) equally spaced levels.
	 * @return An array of coordinates for points defining a tube. These
	 *         coordinates will be formated in the order x1, y1, z1, x2, y2, z2,
	 *         x3...
	 */
	public static double[] createTube(double height, double innerRadius,
			double radius, int resolution, int segments) {

		// The points defining the tube
		double[] points = innerRadius != radius
				? new double[(2 * resolution * (segments + 1)) * 3]
				: new double[(resolution * (segments + 1)) * 3];

		// The y coordinate of the pipe's bottom edge
		double base = height / -2d;

		// The vertices for the inner circle on the lower level
		double[] innerVertices = new double[resolution * 2];

		// The vertices for the outer circle on the lower level
		double[] outerVertices = new double[resolution * 2];

		// Get the XZ coordinates for the circles defining the tube's thickness
		innerVertices = MeshUtils.createCircle(innerRadius, resolution);
		outerVertices = MeshUtils.createCircle(radius, resolution);

		// Iterate through each point on each circle up the side of the inner
		// wall
		for (int i = 0; i <= segments; i++) {
			for (int j = 0; j < resolution; j++) {
				points[(i * resolution + j) * 3] = innerVertices[j * 2];
				points[(i * resolution + j) * 3 + 1] = base
						+ i * (height / segments);
				points[(i * resolution + j) * 3 + 2] = innerVertices[j * 2 + 1];
			}
		}

		// If the tube lacks a separate inner and outer cylinder, return the
		// single created one
		if (innerRadius == radius) {
			return points;
		}

		// The number of coordinates defining one of the two cylinders, and thus
		// the index into points[] at which the second cylinder begins
		int cylinderSize = ((segments + 1) * resolution) * 3;

		// Iterate through each point on each circle up the side of the outer
		// wall
		for (int i = 0; i <= segments; i++) {
			for (int j = 0; j < resolution; j++) {
				points[cylinderSize
						+ (i * resolution + j) * 3] = outerVertices[j * 2];
				points[cylinderSize + (i * resolution + j) * 3 + 1] = base
						+ i * (height / segments);
				points[cylinderSize + (i * resolution + j) * 3
						+ 2] = outerVertices[j * 2 + 1];
			}
		}

		return points;
	}

	/**
	 * Create a list of triangles that define a tube. The tube will have an
	 * outer cylindrical shell and, optionally, an inner cylindrical shell. If
	 * so, the two will be connected at the top and bottom with circles to
	 * create a solid cylinder with a hole running through its center. If not,
	 * the tube will simply be a completely thin mesh.
	 * 
	 * It is recommended that the output of createTube() be used as the points
	 * array, as it will generate coordinates in the expected order for this
	 * function.
	 * 
	 * @param points
	 *            The three dimensional points points defining the tube. It is
	 *            expected that each point will be specified by its three
	 *            coordinates in the order x, y, z. Points are to be ordered
	 *            such that each point lies on a circle, with the tube's shells
	 *            defined by several such circles moving up the mesh. There will
	 *            be a number of points on each circle equal to resolution and a
	 *            number of circles equal to either segments + 1 (for a thin
	 *            tube) or 2 * (segments + 1) (for a tube with some thickness
	 *            between the outer shell and the inner hole.) Each circle must
	 *            have all of its points defined before moving on to the next
	 *            circle's points. Circles must be specified in order from the
	 *            bottom of the tube to the top of one of the two cylinders,
	 *            then from bottom to top of the other cylinder. Points must be
	 *            specified in the same order around each circle, such that all
	 *            points congruent to some number X modulo the resolution all
	 *            lie on a a straight line (or two straight lines, one for each
	 *            of the two cylinders) and the ith point on the jth circle on
	 *            one cylinder is the closest point on that cylinder to the ith
	 *            point on the jth cylinder on the other cylinder. Points's
	 *            length must be equal to 3 * resolution * (segments + 1) or 6 *
	 *            resolution * (segments + 1).
	 * @param resolution
	 *            The number of points defining the circles around each of the
	 *            cylinders.
	 * @param segments
	 *            The number of cylindrical segments the tube's mesh is broken
	 *            into. S
	 * @return A list of triangles between the points specified. There will be
	 *         resolution * 2 triangles on the sides for each segment on the
	 *         outer (and inner if it exists) shells, as well as on the top and
	 *         bottom surfaces (again, if there is an inner surface).
	 */
	public static EList<Triangle> createTubeMesh(double[] points,
			int resolution, int segments) {

		// The triangles defining the mesh
		EList<Triangle> triangles = new BasicEList<Triangle>();

		// There are only resolution * (segments + 1) points per cylinder. If
		// there are more than that in the array, then there is a second
		// cylinder, and so this is the more complex case requiring an inner
		// cylinder connected by surfaces at the top and bottom edges.
		boolean complex = points.length > resolution * (segments + 1) * 3 ? true
				: false;

		// The list of vertices making up the tube
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();

		// Populate the list of vertices with the points
		for (int i = 0; i < points.length / 3; i++) {

			// Create a new vertex from the coordinates of a point in the points
			// array
			Vertex vertex = GeometryFactory.eINSTANCE.createVertex();
			vertex.setX(points[i * 3]);
			vertex.setY(points[i * 3 + 1]);
			vertex.setZ(points[i * 3 + 2]);
			vertices.add(vertex);
		}

		// The number of vertices needed to fully specify one of the two
		// cylindrical faces of the tube mesh
		int vertexBlockSize = (segments + 1) * resolution;

		// Construct the tube out of identical vertical segments, one at a time.
		for (int axialSegment = 0; axialSegment < segments; axialSegment++) {

			// Add two triangles for each vertex along the current circle
			for (int radialSegment = 0; radialSegment < resolution; radialSegment++) {

				// Create the first triangle on the inner side
				Triangle innerTri0 = GeometryFactory.eINSTANCE.createTriangle();

				// Create a triangle between the current vertex, the next vertex
				// along the circle, and the vertex immediately above this one.
				innerTri0.getVertices()
						.add((Vertex) vertices
								.get(axialSegment * resolution + radialSegment)
								.clone());
				innerTri0.getVertices()
						.add((Vertex) vertices
								.get(axialSegment * resolution
										+ ((radialSegment + 1) % resolution))
								.clone());
				innerTri0.getVertices()
						.add((Vertex) vertices
								.get((axialSegment + 1) * resolution
										+ ((radialSegment + 1) % resolution))
								.clone());

				// Add the triangle to the list
				triangles.add(innerTri0);

				// Create the second triangle on the inner side
				Triangle innerTri1 = GeometryFactory.eINSTANCE.createTriangle();

				// Create a triangle between the current vertex, the vertex
				// immediately above it, and the last one along the circle from
				// that one.
				innerTri1.getVertices()
						.add((Vertex) vertices
								.get((axialSegment + 1) * resolution
										+ ((radialSegment + 1) % resolution))
								.clone());
				innerTri1.getVertices()
						.add((Vertex) vertices.get(
								(axialSegment + 1) * resolution + radialSegment)
								.clone());
				innerTri1.getVertices()
						.add((Vertex) vertices
								.get(axialSegment * resolution + radialSegment)
								.clone());

				// Add the triangle to the list
				triangles.add(innerTri1);

				// For complex tubes, also add triangles to the second edge
				if (complex) {

					// Create the first triangle on the outer side
					Triangle outerTri0 = GeometryFactory.eINSTANCE
							.createTriangle();

					// Create a triangle between the current vertex, the next
					// vertex
					// along the circle, and the vertex immediately above this
					// one.
					outerTri0.getVertices()
							.add((Vertex) vertices.get(vertexBlockSize
									+ (axialSegment + 1) * resolution
									+ ((radialSegment + 1) % resolution))
									.clone());
					outerTri0
							.getVertices().add(
									(Vertex) vertices
											.get(vertexBlockSize
													+ axialSegment * resolution
													+ ((radialSegment + 1)
															% resolution))
											.clone());
					outerTri0.getVertices()
							.add((Vertex) vertices.get(vertexBlockSize
									+ axialSegment * resolution + radialSegment)
									.clone());

					// Add the triangle to the list
					triangles.add(outerTri0);

					// Create the first triangle on the outer side
					Triangle outerTri1 = GeometryFactory.eINSTANCE
							.createTriangle();

					// Create a triangle between the current vertex, the vertex
					// immediately above it, and the last one along the circle
					// from
					// that one.
					outerTri1.getVertices()
							.add((Vertex) vertices.get(vertexBlockSize
									+ axialSegment * resolution + radialSegment)
									.clone());
					outerTri1.getVertices()
							.add((Vertex) vertices.get(vertexBlockSize
									+ (axialSegment + 1) * resolution
									+ radialSegment).clone());
					outerTri1.getVertices()
							.add((Vertex) vertices.get(vertexBlockSize
									+ (axialSegment + 1) * resolution
									+ ((radialSegment + 1) % resolution))
									.clone());

					// Add the triangle to the list
					triangles.add(outerTri1);
				}
			}

			// For complex cylinders, we must also add triangles to the surfaces
			// forming the tube's top and bottom edges
			if (complex) {

				// Add two triangles for each vertex along the current circle
				for (int radialSegment = 0; radialSegment < resolution; radialSegment++) {

					// Create the first triangle on the bottom
					Triangle bottomTri0 = GeometryFactory.eINSTANCE
							.createTriangle();

					// Create a triangle between the current vertex, the next
					// vertex
					// along the circle, and the corresponding vertex on the
					// other
					// edge.
					bottomTri0.getVertices()
							.add((Vertex) vertices.get(vertexBlockSize
									+ ((radialSegment + 1) % resolution))
									.clone());
					bottomTri0.getVertices()
							.add((Vertex) vertices
									.get((radialSegment + 1) % resolution)
									.clone());
					bottomTri0.getVertices()
							.add((Vertex) vertices.get(radialSegment).clone());

					// Add the triangle to the list
					triangles.add(bottomTri0);

					// Create the second triangle on the bottom
					Triangle bottomTri1 = GeometryFactory.eINSTANCE
							.createTriangle();

					// Create a triangle between the current vertex, the
					// corresponding vertex on the other edge, and the last one
					// along the circle from the other edge.
					bottomTri1.getVertices()
							.add((Vertex) vertices.get(
									((segments) * resolution) + radialSegment)
									.clone());
					bottomTri1.getVertices()
							.add((Vertex) vertices.get(((segments) * resolution)
									+ ((radialSegment + 1) % resolution))
									.clone());
					bottomTri1
							.getVertices().add(
									(Vertex) vertices
											.get(((segments) * resolution)
													+ vertexBlockSize
													+ ((radialSegment + 1)
															% resolution))
											.clone());

					// Add the triangle to the list
					triangles.add(bottomTri1);

					// Create the first triangle on the top
					Triangle topTri0 = GeometryFactory.eINSTANCE
							.createTriangle();

					// Create a triangle between the current vertex, the
					// corresponding vertex on the other edge, and the last one
					// along the circle from the other edge.
					topTri0.getVertices()
							.add((Vertex) vertices.get(radialSegment).clone());
					topTri0.getVertices()
							.add((Vertex) vertices
									.get(vertexBlockSize + radialSegment)
									.clone());
					topTri0.getVertices()
							.add((Vertex) vertices.get(vertexBlockSize
									+ ((radialSegment + 1) % resolution))
									.clone());

					// Add the triangle to the list
					triangles.add(topTri0);

					// Create the second triangle on the top
					Triangle topTri1 = GeometryFactory.eINSTANCE
							.createTriangle();

					// Create a triangle between the current vertex, the vertex
					// immediately above it, and the last one along the circle
					// from
					// that one.
					topTri1.getVertices().add((Vertex) vertices
							.get(((segments) * resolution) + vertexBlockSize
									+ ((radialSegment + 1) % resolution))
							.clone());
					topTri1.getVertices()
							.add((Vertex) vertices
									.get(((segments) * resolution)
											+ vertexBlockSize + radialSegment)
									.clone());
					topTri1.getVertices()
							.add((Vertex) vertices.get(
									((segments) * resolution) + radialSegment)
									.clone());

					// Add the triangle to the list
					triangles.add(topTri1);
				}
			}
		}

		return triangles;
	}

	/**
	 * Rotate the given points around the x, y, and z axes by the given amount.
	 * 
	 * @param points
	 *            A list of coordinates for points in three dimensional space to
	 *            rotate. These are expected to be specified in the format x1,
	 *            y1, z1, x2, y2, z2, x3...
	 * @param rotationX
	 *            The amount of rotation about the x axis, given in radians.
	 * @param rotationY
	 *            The amount of rotation about the y axis, given in radians.
	 * @param rotationZ
	 *            The amount of rotation about the z axis, given in radians.
	 * @return An array of giving the coordinates of the points array after the
	 *         rotations have been applied to them, in the same format as the
	 *         points array.
	 */
	public static double[] rotatePoints(double[] points, double rotationX,
			double rotationY, double rotationZ) {

		// The points after they have undergone rotation
		double[] rotated = new double[points.length];

		// Consider each point one at a time
		for (int i = 0; i < points.length / 3; i++) {

			// Apply the rotation to the point
			double x = points[i * 3];
			double y = points[i * 3 + 1];
			double z = points[i * 3 + 2];

			// Rotate about the z axis
			double tempY = (x * Math.sin(rotationZ) + y * Math.cos(rotationZ));
			x = (x * Math.cos(rotationZ) - y * Math.sin(rotationZ));
			y = tempY;

			// Rotate about the y axis
			double tempX = (z * Math.sin(rotationY) + x * Math.cos(rotationY));
			z = (z * Math.cos(rotationY) - x * Math.sin(rotationY));
			rotated[i * 3] = tempX;

			// Rotate about the x axis
			tempY = (y * Math.cos(rotationX) - z * Math.sin(rotationX));
			rotated[i * 3 + 2] = (y * Math.sin(rotationX)
					+ z * Math.cos(rotationX));
			rotated[i * 3 + 1] = tempY;
		}

		return rotated;
	}

	/**
	 * Rotate the given set of three dimensional points about the axis beginning
	 * at the origin and ending at the given vertex.
	 * 
	 * @param points
	 *            The coordinates of the points to be rotated. It is expected
	 *            that these will be given in the format x1, y1, z1, x2, y2, z2,
	 *            x3...
	 * @param axis
	 *            The endpoint of the axis around which the rotation will
	 *            happen.
	 * @param magnitude
	 *            The amount of rotation to apply, given in radians.
	 * @return An array of coordinates for the points after the rotation has
	 *         been applied, using the same format as the points array.
	 */
	public static double[] rotatePointsAboutAxis(double[] points, Vertex axis,
			double magnitude) {

		// The array of rotated points
		double[] rotated = new double[points.length];

		// The multiplication matrix
		double[][] matrix = new double[3][3];

		// Get the three components of the axis of rotation
		double x = axis.getX();
		double y = axis.getY();
		double z = axis.getZ();
		
		//Normalize the vector
		double vectorLength = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
		x /= vectorLength;
		y /= vectorLength;
		z /= vectorLength;

		// Get the sin and (1 - cos) for the magnitude of the rotation
		double sin = Math.sin(magnitude);
		double cos = Math.cos(magnitude);
		double inverseCos = 1 - Math.cos(magnitude);

		//Fill the matrix for a rotation about the axis
		matrix[0][0] = cos + (Math.pow(x, 2) * inverseCos);
		matrix[0][1] = (x * y * inverseCos) - (z * sin);
		matrix[0][2] = (x * z * inverseCos) + (y * sin);
		matrix[1][0] = (y * x * inverseCos) + (z * sin);
		matrix[1][1] = cos + (Math.pow(y, 2) * inverseCos);
		matrix[1][2] = (y * z * inverseCos) - (x * sin);
		matrix[2][0] = (x * z * inverseCos) - (y * sin);
		matrix[2][1] = (z * y * inverseCos) + (x * sin);
		matrix[2][2] = cos + (Math.pow(z, 2) * inverseCos);

		// Apply the rotation matrix to each vector of three coordinates
		for (int i = 0; i < points.length / 3; i++) {

			// Calculate the vector of the rotated point's coordinates by
			// multiplying the original coordinates by the rotation matrix
			rotated[i * 3] = points[i * 3] * matrix[0][0]
					+ points[i * 3 + 1] * matrix[0][1]
					+ points[i * 3 + 2] * matrix[0][2];
			rotated[i * 3 + 1] = points[i * 3] * matrix[1][0]
					+ points[i * 3 + 1] * matrix[1][1]
					+ points[i * 3 + 2] * matrix[1][2];
			rotated[i * 3 + 2] = points[i * 3] * matrix[2][0]
					+ points[i * 3 + 1] * matrix[2][1]
					+ points[i * 3 + 2] * matrix[2][2];
		}

		return rotated;
	}
}
