/*-
 *******************************************************************************
 * Copyright (c) 2011, 2014 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Peter Chang - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.dawnsci.analysis.dataset.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.apache.commons.lang.ArrayUtils;

class InterpolatedPoint {

	Dataset realPoint;
	Dataset coordPoint;

	public InterpolatedPoint(Dataset realPoint, Dataset coordPoint) {
		this.realPoint = realPoint;
		this.coordPoint = coordPoint;
	}

	public Dataset getRealPoint() {
		return realPoint;
	}

	public Dataset getCoordPoint() {
		return coordPoint;
	}
	
	@Override
	public String toString() {
		String realString = "[ " + realPoint.getDouble(0);
		for(int i = 1; i < realPoint.getShapeRef()[0]; i++) {
			realString += " , " + realPoint.getDouble(i);
		}
		realString += " ]";
		
		String coordString = "[ " + coordPoint.getDouble(0);
		for(int i = 1; i < coordPoint.getShapeRef()[0]; i++) {
			coordString += " , " + coordPoint.getDouble(i) ;
		}
		coordString += " ]";
		
		return realString + " : " + coordString;
	}

}

public class InterpolatorUtils {

	public static Dataset regridOld(Dataset data, Dataset x, Dataset y,
			Dataset gridX, Dataset gridY) throws Exception {
		
		DoubleDataset result = new DoubleDataset(gridX.getShapeRef()[0], gridY.getShapeRef()[0]);
		
		IndexIterator itx = gridX.getIterator();
		
		// need a list of lists to store points
		ArrayList<ArrayList<InterpolatedPoint>> pointList = new ArrayList<ArrayList<InterpolatedPoint>>();
		
		while(itx.hasNext()){
			// Add a list to contain all the points which we find
			pointList.add(new ArrayList<InterpolatedPoint>());
			
			int xindex = itx.index;
			double xPos = gridX.getDouble(xindex);
			
			IndexIterator ity = gridY.getIterator();
			while(ity.hasNext()){
				int yindex = ity.index;
				System.out.println("Testing : "+xindex+","+yindex);
				double yPos = gridX.getDouble(yindex);
				result.set(getInterpolated(data, x, y, xPos, yPos), yindex, xindex);
				
			}
		}
		return result;
	}
	
	
	
	
	public static Dataset selectDatasetRegion(Dataset dataset, int x, int y, int xSize, int ySize) {
		int startX = x - xSize;
		int startY = y - ySize;
		int endX = x + xSize + 1;
		int endY = y + ySize +1;
		
		int shapeX = dataset.getShapeRef()[0];
		int shapeY = dataset.getShapeRef()[1];
		
		// Do edge checking
		if (startX < 0) {
			startX = 0;
			endX = 3;
		} 
		
		if (endX > shapeX) {
			endX = shapeX;
			startX = endX-3;
		}
		
		if (startY < 0) {
			startY = 0;
			endY = 3;
		}
		
		if (endY > shapeY) {
			endY = shapeY;
			startY = endY-3;
		}
		
		int[] start = new int[] { startX, startY };
		int[] stop = new int[] { endX, endY };
		
		
		return dataset.getSlice(start, stop, null);
	}
	
	private static double getInterpolated(Dataset val, Dataset x, Dataset y, double xPos,
			double yPos) throws Exception {
		
		// initial guess
		Dataset xPosDS = x.getSlice(new int[] {0,0}, new int[] {x.getShapeRef()[0],1}, null).isubtract(xPos);
		int xPosMin = xPosDS.minPos()[0];
		Dataset yPosDS = y.getSlice(new int[] {xPosMin,0}, new int[] {xPosMin+1,y.getShapeRef()[1]}, null).isubtract(yPos);
		int yPosMin = yPosDS.minPos()[0];
		
		
		// now search around there 5x5
		
		Dataset xClipped = selectDatasetRegion(x,xPosMin,yPosMin,2,2);
		Dataset yClipped = selectDatasetRegion(y,xPosMin,yPosMin,2,2);
		
		// first find the point in the arrays nearest to the point
		Dataset xSquare = Maths.subtract(xClipped, xPos).ipower(2);
		Dataset ySquare = Maths.subtract(yClipped, yPos).ipower(2);

		Dataset total = Maths.add(xSquare, ySquare);

		int[] pos = total.minPos();

		// now pull out the region around that point, as a 3x3 grid	
		Dataset xReduced = selectDatasetRegion(x, pos[0], pos[1], 1, 1);
		Dataset yReduced = selectDatasetRegion(y, pos[0], pos[1], 1, 1);
		Dataset valReduced = selectDatasetRegion(val, pos[0], pos[1], 1, 1);

		return getInterpolatedResultFromNinePoints(valReduced, xReduced, yReduced, xPos, yPos);
	}

	private static double getInterpolatedResultFromNinePoints(Dataset val, Dataset x, Dataset y,
			double xPos, double yPos) throws Exception {
		
		// First build the nine points
		InterpolatedPoint p00 = makePoint(x, y, 0, 0);
		InterpolatedPoint p01 = makePoint(x, y, 0, 1);
		InterpolatedPoint p02 = makePoint(x, y, 0, 2);
		InterpolatedPoint p10 = makePoint(x, y, 1, 0);
		InterpolatedPoint p11 = makePoint(x, y, 1, 1);
		InterpolatedPoint p12 = makePoint(x, y, 1, 2);
		InterpolatedPoint p20 = makePoint(x, y, 2, 0);
		InterpolatedPoint p21 = makePoint(x, y, 2, 1);
		InterpolatedPoint p22 = makePoint(x, y, 2, 2);

		// now try every connection and find points that intersect with the interpolated value
		ArrayList<InterpolatedPoint> points = new ArrayList<InterpolatedPoint>();

		InterpolatedPoint A = get1DInterpolatedPoint(p00, p10, 0, xPos);
		InterpolatedPoint B = get1DInterpolatedPoint(p10, p20, 0, xPos);
		InterpolatedPoint C = get1DInterpolatedPoint(p00, p01, 0, xPos);
		InterpolatedPoint D = get1DInterpolatedPoint(p10, p11, 0, xPos);
		InterpolatedPoint E = get1DInterpolatedPoint(p20, p21, 0, xPos);
		InterpolatedPoint F = get1DInterpolatedPoint(p01, p11, 0, xPos);
		InterpolatedPoint G = get1DInterpolatedPoint(p11, p21, 0, xPos);
		InterpolatedPoint H = get1DInterpolatedPoint(p01, p02, 0, xPos);
		InterpolatedPoint I = get1DInterpolatedPoint(p11, p12, 0, xPos);
		InterpolatedPoint J = get1DInterpolatedPoint(p21, p22, 0, xPos);
		InterpolatedPoint K = get1DInterpolatedPoint(p02, p12, 0, xPos);
		InterpolatedPoint L = get1DInterpolatedPoint(p12, p22, 0, xPos);

		// Now add any to the list which are not null
		if (A != null)
			points.add(A);
		if (B != null)
			points.add(B);
		if (C != null)
			points.add(C);
		if (D != null)
			points.add(D);
		if (E != null)
			points.add(E);
		if (F != null)
			points.add(F);
		if (G != null)
			points.add(G);
		if (H != null)
			points.add(H);
		if (I != null)
			points.add(I);
		if (J != null)
			points.add(J);
		if (K != null)
			points.add(K);
		if (L != null)
			points.add(L);

		// if no intercepts, then retun NaN;
		if (points.size() == 0) return Double.NaN;
		
		InterpolatedPoint bestPoint = null;

		// sort the points by y
		Collections.sort(points, new Comparator<InterpolatedPoint>() {

			@Override
			public int compare(InterpolatedPoint o1, InterpolatedPoint o2) {
				return (int) Math.signum(o1.realPoint.getDouble(1) - o2.realPoint.getDouble(1));
			}
		});
		
		
		// now we have all the points which fit the x criteria, Find the points which fit the y
		for (int a = 1; a < points.size(); a++) {
			InterpolatedPoint testPoint = get1DInterpolatedPoint(points.get(a - 1), points.get(a), 1, yPos);
			if (testPoint != null) {
				bestPoint = testPoint;
				break;
			}
		}

		if (bestPoint == null) {
			return Double.NaN;
		}

		// now we have the best point, we can calculate the weights, and positions
		int xs = (int) Math.floor(bestPoint.getCoordPoint().getDouble(0));
		int ys = (int) Math.floor(bestPoint.getCoordPoint().getDouble(1));
		
		double xoff = bestPoint.getCoordPoint().getDouble(0) - xs;
		double yoff = bestPoint.getCoordPoint().getDouble(1) - ys;

		// check corner cases
		if (xs == 2) {
			xs = 1;
			xoff = 1.0;
		}
		
		if (ys == 2) {
			ys = 1;
			yoff = 1.0;
		}
		
		double w00 = (1 - xoff) * (1 - yoff);
		double w10 = (xoff) * (1 - yoff);
		double w01 = (1 - xoff) * (yoff);
		double w11 = (xoff) * (yoff);
		
		// now using the weights, we can get the final interpolated value
		double result = val.getDouble(xs, ys) * w00;
		result += val.getDouble(xs + 1, ys) * w10;
		result += val.getDouble(xs, ys + 1) * w01;
		result += val.getDouble(xs + 1, ys + 1) * w11;
		
		return result;
	}

	private static InterpolatedPoint makePoint(Dataset x, Dataset y, int i, int j) {
		DoubleDataset realPoint = new DoubleDataset(new double[] { x.getDouble(i, j), y.getDouble(i, j) }, 2);
		DoubleDataset coordPoint = new DoubleDataset(new double[] { i, j }, 2);
		return new InterpolatedPoint(realPoint, coordPoint);
	}

	/**
	 * Gets an interpolated position when only dealing with 1 dimension for the interpolation.
	 * 
	 * @param p1
	 *            Point 1
	 * @param p2
	 *            Point 2
	 * @param interpolationDimension
	 *            The dimension in which the interpolation should be carried out
	 * @param interpolatedValue
	 *            The value at which the interpolated point should be at in the chosen dimension
	 * @return the new interpolated point.
	 * @throws IllegalArgumentException
	 */
	private static InterpolatedPoint get1DInterpolatedPoint(InterpolatedPoint p1, InterpolatedPoint p2,
			int interpolationDimension, double interpolatedValue) throws IllegalArgumentException {
		
		checkPoints(p1, p2);

		if (interpolationDimension >= p1.getRealPoint().getShapeRef()[0]) {
			throw new IllegalArgumentException("Dimention is too large for these datasets");
		}

		double p1_n = p1.getRealPoint().getDouble(interpolationDimension);
		double p2_n = p2.getRealPoint().getDouble(interpolationDimension);
		double max = Math.max(p1_n, p2_n);
		double min = Math.min(p1_n, p2_n);
		
		if (interpolatedValue < min || interpolatedValue > max || min==max) {
			return null;
		}
		
		double proportion = (interpolatedValue - min) / (max - min);
		
		return getInterpolatedPoint(p1, p2, proportion);
	}

	/**
	 * Gets an interpolated point between 2 points given a certain proportion
	 * 
	 * @param p1
	 *            the initial point
	 * @param p2
	 *            the final point
	 * @param proportion
	 *            how far the new point is along the path between P1(0.0) and P2(1.0)
	 * @return a new point which is the interpolated point
	 */
	private static InterpolatedPoint getInterpolatedPoint(InterpolatedPoint p1, InterpolatedPoint p2, double proportion) {

		checkPoints(p1, p2);

		if (proportion < 0 || proportion > 1.0) {
			throw new IllegalArgumentException("Proportion must be between 0 and 1");
		}

		Dataset p1RealContribution = Maths.multiply(p1.getRealPoint(), (1.0 - proportion));
		Dataset p2RealContribution = Maths.multiply(p2.getRealPoint(), (proportion));

		Dataset realPoint = Maths.add(p1RealContribution, p2RealContribution);

		Dataset p1CoordContribution = Maths.multiply(p1.getCoordPoint(), (1.0 - proportion));
		Dataset p2CoordContribution = Maths.multiply(p2.getCoordPoint(), (proportion));

		Dataset coordPoint = Maths.add(p1CoordContribution, p2CoordContribution);

		return new InterpolatedPoint(realPoint, coordPoint);
	}

	/**
	 * Checks to see if 2 points have the same dimensionality
	 * 
	 * @param p1
	 *            Point 1
	 * @param p2
	 *            Point 2
	 * @throws IllegalArgumentException
	 */
	private static void checkPoints(InterpolatedPoint p1, InterpolatedPoint p2) throws IllegalArgumentException {
		if (!p1.getCoordPoint().isCompatibleWith(p2.getCoordPoint())) {
			throw new IllegalArgumentException("Datasets do not match");
		}
	}

	
	
	
	
	
	private static Dataset getTrimmedAxis(Dataset axis, int axisIndex, InterpolatedPoint p1, InterpolatedPoint p2) {
		double startPoint = p1.getRealPoint().getDouble(axisIndex);
		double endPoint = p2.getRealPoint().getDouble(axisIndex);
		
		// swap if needed
		if (startPoint > endPoint) {
			startPoint = p2.getRealPoint().getDouble(axisIndex);
			endPoint = p1.getRealPoint().getDouble(axisIndex);
		}

		int start = getTrimmedAxisStart(axis, startPoint);
		int end = getTrimmedAxisEnd(axis, start, endPoint);
		
		return axis.getSlice(new int[] {start}, new int[] {end}, null);
	}

	private static int getTrimmedAxisStart(Dataset axis, double startPoint) {
		for (int i = 0; i < axis.getShapeRef()[0]; i++) {
			if (axis.getDouble(i) > startPoint) return i;
		}
		// if we get to here then the start point is higher than the whole system
		return -1;
	}
	
	private static int getTrimmedAxisEnd(Dataset axis, int startPos, double endPoint) {
		for (int i = startPos; i < axis.getShapeRef()[0]; i++) {
			if (axis.getDouble(i) > endPoint) return i-1;
		}
		// if we get to here then the end point is higher than the whole system
		return axis.getShapeRef()[0];
	}
	
	public static Dataset remap1D(Dataset dataset, Dataset axis, Dataset outputAxis) {
		DoubleDataset data = new DoubleDataset(outputAxis.getShapeRef());
		for(int i = 0; i < outputAxis.getShapeRef()[0]; i++) {
			double point = outputAxis.getDouble(i);
			double position = getRealPositionAsIndex(axis, point);
			if (position >= 0.0) {
				data.set(Maths.interpolate(dataset, position), i);
			} else {
				data.set(Double.NaN,i);
			}
		}
		
		return data;
	}

	// TODO need to make this work with reverse number lists
	private static double getRealPositionAsIndex(Dataset dataset, double point) {
		for (int j = 0; j < dataset.getShapeRef()[0]-1; j++) {
			double end = dataset.getDouble(j+1);
			double start = dataset.getDouble(j);
			//TODO could make this check once outside the loop with a minor assumption.
			if ( start < end) {
				if ((end > point) && (start <= point)) {
					// we have a bounding point
					double proportion = ((point-start)/(end-start));
					return j + proportion;
				}
			} else {
				if ((end < point) && (start >= point)) {
					// we have a bounding point
					double proportion = ((point-start)/(end-start));
					return j + proportion;
				}
			}
		}
		return -1.0;
	}
	
	public static Dataset remapOneAxis(Dataset dataset, int axisIndex, Dataset corrections,
			Dataset originalAxisForCorrection, Dataset outputAxis) {
		int[] stop = dataset.getShape();
		int[] start = new int[stop.length];
		int[] step = new int[stop.length];
		int[] resultSize = new int[stop.length];
		for (int i = 0 ; i < start.length; i++) {
			start[i] = 0;
			step[i] = 1;
			resultSize[i] = stop[i];
		}
		
		resultSize[axisIndex] = outputAxis.getShapeRef()[0];
		DoubleDataset result = new DoubleDataset(resultSize);
		
		step[axisIndex] = dataset.getShapeRef()[axisIndex];
		IndexIterator iter = dataset.getSliceIterator(start, stop, step);
		
		int[] pos = iter.getPos();
		int[] posEnd = new int[pos.length];
		while (iter.hasNext()){
			for (int i = 0 ; i < posEnd.length; i++) {
				posEnd[i] = pos[i]+1;
			}
			posEnd[axisIndex] = stop[axisIndex];
			// get the dataset
			Dataset slice = dataset.getSlice(pos, posEnd, null).squeeze();
			int[] correctionPos = new int[pos.length-1];
			int index = 0;
			for(int j = 0; j < pos.length; j++) {
				if (j != axisIndex) {
					correctionPos[index] = pos[j];
					index++;
				}
			}
			Dataset axis = Maths.subtract(originalAxisForCorrection,corrections.getDouble(correctionPos));
			Dataset remapped = remap1D(slice,axis,outputAxis);
			
			int[] ref = ArrayUtils.clone(pos);
			
			for (int k = 0; k < result.getShapeRef()[axisIndex]; k++) {
				ref[axisIndex] = k;
				result.set(remapped.getDouble(k), ref);
			}
		}
		
		return result;
	}
	
	
	public static Dataset remapAxis(Dataset dataset, int axisIndex, Dataset originalAxisForCorrection, Dataset outputAxis) {
		if (!dataset.isCompatibleWith(originalAxisForCorrection)) {
			throw new IllegalArgumentException("Datasets must be of the same shape");
		}
		
		int[] stop = dataset.getShapeRef();
		int[] start = new int[stop.length];
		int[] step = new int[stop.length];
		int[] resultSize = new int[stop.length];
		for (int i = 0 ; i < start.length; i++) {
			start[i] = 0;
			step[i] = 1;
			resultSize[i] = stop[i];
		}
		
		resultSize[axisIndex] = outputAxis.getShapeRef()[0];
		DoubleDataset result = new DoubleDataset(resultSize);
		
		step[axisIndex] = dataset.getShapeRef()[axisIndex];
		IndexIterator iter = dataset.getSliceIterator(start, stop, step);
		
		int[] pos = iter.getPos();
		int[] posEnd = new int[pos.length];
		while (iter.hasNext()){
			for (int i = 0 ; i < posEnd.length; i++) {
				posEnd[i] = pos[i]+1;
			}
			posEnd[axisIndex] = stop[axisIndex];
			
			// get the dataset
			Dataset slice = dataset.getSlice(pos, posEnd, null).squeeze();
			Dataset axis = originalAxisForCorrection.getSlice(pos, posEnd, null).squeeze();
			
			Dataset remapped = remap1D(slice,axis,outputAxis);
			
			int[] ref = ArrayUtils.clone(pos);
			
			for (int k = 0; k < result.shape[axisIndex]; k++) {
				ref[axisIndex] = k;
				result.set(remapped.getDouble(k), ref);
			}
		}
		
		return result;
	}

	public static Dataset regrid(Dataset data, Dataset x, Dataset y, Dataset gridX, Dataset gridY) {
		
		// apply X then Y regridding
		Dataset result = remapAxis(data,1,x,gridX);
		result = remapAxis(result,0,y,gridY);
		
		return result;
	}
}
