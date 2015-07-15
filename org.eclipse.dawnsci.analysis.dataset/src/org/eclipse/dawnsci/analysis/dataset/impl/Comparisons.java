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
import java.util.List;

import org.eclipse.dawnsci.analysis.api.dataset.IDataset;

/**
 * Comparison and logical methods
 */
public class Comparisons {
	/**
	 * Compare item-wise for whether a's element is equal b's
	 * <p>
	 * For multi-element items, comparison is true if all elements in an item
	 * are equal. Where the datasets have mismatched item sizes, the first element
	 * of the dataset with smaller items is used for comparison.
	 * @param a
	 * @param b
	 * @return dataset where item is true if a == b
	 */
	public static BooleanDataset equalTo(Object a, Object b) {
		return equalTo(a, b, null);
	}

	/**
	 * Compare item-wise for whether a's element is equal b's
	 * <p>
	 * For multi-element items, comparison is true if all elements in an item
	 * are equal. Where the datasets have mismatched item sizes, the first element
	 * of the dataset with smaller items is used for comparison.
	 * @param a
	 * @param b
	 * @param o output can be null - in which case, a new dataset is created
	 * @return dataset where item is true if a == b
	 */
	public static BooleanDataset equalTo(Object a, Object b, BooleanDataset o) {
		final Dataset da = a instanceof Dataset ? (Dataset) a : DatasetFactory.createFromObject(a);
		final Dataset db = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);

		List<int[]> sl = BroadcastIterator.broadcastShapes(da.getShapeRef(), db.getShapeRef(), o == null ? null : o.getShapeRef());

		final BooleanDataset r = o == null ? new BooleanDataset(sl.get(0)) : o;

		final BroadcastIteratorBase it = BroadcastIterator.createIterator(da, db, r);
		final int as = da.getElementsPerItem();
		final int bs = db.getElementsPerItem();

		if (as > bs) {
			if (da.isComplex()) {
				while (it.hasNext()) {
					final double bd = it.bDouble;
					boolean rb = it.aDouble == bd && da.getElementDoubleAbs(it.aIndex + 1) == 0;
					r.setAbs(it.oIndex, rb);
				}
			} else if (it.isOutputDouble()) {
				while (it.hasNext()) {
					final double bd = it.bDouble;
					boolean rb = true;
					for (int j = 0; rb && j < as; j++) {
						rb &= da.getElementDoubleAbs(it.aIndex + j) == bd;
					}
					r.setAbs(it.oIndex, rb);
				}
			} else {
				while (it.hasNext()) {
					final long bl = it.bLong;
					boolean rb = true;
					for (int j = 0; rb && j < as; j++) {
						rb &= da.getElementLongAbs(it.aIndex + j) == bl;
					}
					r.setAbs(it.oIndex, rb);
				}
			}
		} else if (as < bs) {
			if (db.isComplex()) {
				while (it.hasNext()) {
					final double ad = it.aDouble;
					boolean rb = ad == it.bDouble && 0 == db.getElementDoubleAbs(it.bIndex + 1);
					r.setAbs(it.oIndex, rb);
				}
			} else if (it.isOutputDouble()) {
				while (it.hasNext()) {
					final double ad = it.aDouble;
					boolean rb = true;
					for (int j = 0; rb && j < bs; j++) {
						rb &= ad == db.getElementDoubleAbs(it.bIndex + j);
					}
					r.setAbs(it.oIndex, rb);
				}
			} else {
				while (it.hasNext()) {
					final long al = it.aLong;
					boolean rb = true;
					for (int j = 0; rb && j < bs; j++) {
						rb &= al == db.getElementLongAbs(it.bIndex + j);
					}
					r.setAbs(it.oIndex, rb);
				}
			}
		} else {
			if (as == 1) {
				if (it.isOutputDouble()) {
					while (it.hasNext()) {
						r.setAbs(it.oIndex, it.aDouble == it.bDouble);
					}
				} else {
					while (it.hasNext()) {
						r.setAbs(it.oIndex, it.aLong == it.bLong);
					}
				}
			} else if (it.isOutputDouble()) {
				while (it.hasNext()) {
					boolean rb = true;
					for (int j = 0; rb && j < bs; j++) {
						rb &= da.getElementDoubleAbs(it.aIndex + j) == db.getElementDoubleAbs(it.bIndex + j);
					}
					r.setAbs(it.oIndex, rb);
				}
			} else {
				while (it.hasNext()) {
					boolean rb = true;
					for (int j = 0; rb && j < bs; j++) {
						rb &= da.getElementLongAbs(it.aIndex + j) == db.getElementLongAbs(it.bIndex + j);
					}
					r.setAbs(it.oIndex, rb);
				}
			}
		}

		return r;
	}

	/**
	 * Compare item-wise for whether a's element is equal b's
	 * <p>
	 * For multi-element items, comparison is true if all elements in an item
	 * are equal. Where the datasets have mismatched item sizes, the first element
	 * of the dataset with smaller items is used for comparison.
	 * @param a
	 * @param b
	 * @param relTolerance
	 * @param absTolerance
	 * @return dataset where item is true if abs(a - b) <= absTol + relTol*max(abs(a),abs(b))
	 */
	public static BooleanDataset almostEqualTo(Object a, Object b, double relTolerance, double absTolerance) {
		return almostEqualTo(a, b, null, relTolerance, absTolerance);
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @param relTol
	 * @param absTol
	 * @return true if abs(a - b) <= max(absTol, relTol*max(abs(a),abs(b)))
	 */
	public final static boolean isClose(double a, double b, double relTol, double absTol) {
		return Math.abs(a - b) <= Math.max(absTol, relTol * Math.max(Math.abs(a), Math.abs(b)));
	}

	private final static boolean isCloseNP(double a, double b, double rt, double at) {
		return Math.abs(a - b) <= at + rt * Math.max(Math.abs(a), Math.abs(b));
	}

	private final static boolean isCloseNP(double a, double rt, double at) {
		double aa = Math.abs(a);
		return aa <= at + rt * aa;
	}

	/**
	 * Compare item-wise for whether a's element is equal b's
	 * <p>
	 * For multi-element items, comparison is true if all elements in an item
	 * are equal. Where the datasets have mismatched item sizes, the first element
	 * of the dataset with smaller items is used for comparison.
	 * @param a
	 * @param b
	 * @param o output can be null - in which case, a new dataset is created
	 * @param relTolerance
	 * @param absTolerance
	 * @return dataset where item is true if abs(a - b) <= absTol + relTol*max(abs(a),abs(b))
	 */
	public static BooleanDataset almostEqualTo(Object a, Object b, BooleanDataset o, double relTolerance, double absTolerance) {
		final Dataset da = a instanceof Dataset ? (Dataset) a : DatasetFactory.createFromObject(a);
		final Dataset db = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);

		List<int[]> sl = BroadcastIterator.broadcastShapes(da.getShapeRef(), db.getShapeRef(), o == null ? null : o.getShapeRef());

		final BooleanDataset r = o == null ? new BooleanDataset(sl.get(0)) : o;

		final BroadcastIteratorBase it = BroadcastIterator.createIterator(da, db, r);
		it.setOutputDouble(true);
		final int as = da.getElementsPerItem();
		final int bs = db.getElementsPerItem();

		if (as > bs) {
			if (da.isComplex()) {
				while (it.hasNext()) {
					boolean rb = isCloseNP(it.aDouble, it.bDouble, relTolerance, absTolerance);
					if (rb) {
						rb = isCloseNP(da.getElementDoubleAbs(it.aIndex + 1), relTolerance, absTolerance);
					}
					r.setAbs(it.oIndex, rb);
				}
			} else {
				while (it.hasNext()) {
					final double bd = it.bDouble;
					boolean rb = true;
					for (int j = 0; rb && j < as; j++) {
						rb &= isCloseNP(da.getElementDoubleAbs(it.aIndex + j), bd, relTolerance, absTolerance);
					}
					r.setAbs(it.oIndex, rb);
				}
			}
		} else if (as < bs) {
			if (db.isComplex()) {
				while (it.hasNext()) {
					boolean rb = isCloseNP(it.aDouble, it.bDouble, relTolerance, absTolerance);
					if (rb) {
						rb = isCloseNP(db.getElementDoubleAbs(it.bIndex + 1), relTolerance, absTolerance);
					}
					r.setAbs(it.oIndex, rb);
				}
			} else {
				while (it.hasNext()) {
					final double ad = it.aDouble;
					boolean rb = true;
					for (int j = 0; rb && j < bs; j++) {
						rb &= isCloseNP(ad, db.getElementDoubleAbs(it.bIndex + j), relTolerance, absTolerance);
					}
					r.setAbs(it.oIndex, rb);
				}
			}
		} else {
			if (as == 1) {
				while (it.hasNext()) {
					r.setAbs(it.oIndex, isCloseNP(it.aDouble, it.bDouble, relTolerance, absTolerance));
				}
			} else {
				while (it.hasNext()) {
					boolean rb = isCloseNP(it.aDouble, it.bDouble, relTolerance, absTolerance);
					for (int j = 1; rb && j < bs; j++) {
						rb &= isCloseNP(da.getElementDoubleAbs(it.aIndex + j), db.getElementDoubleAbs(it.bIndex + j), relTolerance, absTolerance);
					}
					r.setAbs(it.oIndex, rb);
				}
			}
		}
		
		return r;
	}

	/**
	 * Compare item-wise for whether a's element is greater than b's
	 * <p>
	 * For multi-element items, comparison is true if all elements in an item
	 * are greater. Where the datasets have mismatched item sizes, the first element
	 * of the dataset with smaller items is used for comparison.
	 * @param a
	 * @param b
	 * @return dataset where item is true if a > b
	 */
	public static BooleanDataset greaterThan(Object a, Object b) {
		return greaterThan(a, b, null);
	}

	/**
	 * Compare item-wise for whether a's element is greater than b's
	 * <p>
	 * For multi-element items, comparison is true if all elements in an item
	 * are greater. Where the datasets have mismatched item sizes, the first element
	 * of the dataset with smaller items is used for comparison.
	 * @param a
	 * @param b
	 * @param o output can be null - in which case, a new dataset is created
	 * @return dataset where item is true if a > b
	 */
	public static BooleanDataset greaterThan(Object a, Object b, BooleanDataset o) {
		final Dataset da = a instanceof Dataset ? (Dataset) a : DatasetFactory.createFromObject(a);
		final Dataset db = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);

		List<int[]> sl = BroadcastIterator.broadcastShapes(da.getShapeRef(), db.getShapeRef(), o == null ? null : o.getShapeRef());

		final BooleanDataset r = o == null ? new BooleanDataset(sl.get(0)) : o;

		final BroadcastIteratorBase it = BroadcastIterator.createIterator(da, db, r);
		final int as = da.getElementsPerItem();
		final int bs = db.getElementsPerItem();

		if (it.isOutputDouble()) {
			if (as > bs) {
				while (it.hasNext()) {
					final double bd = it.bDouble;
					boolean rb = true;
					for (int j = 0; rb && j < as; j++) {
						rb &= da.getElementDoubleAbs(it.aIndex + j) > bd;
					}
					r.setAbs(it.oIndex, rb);
				}
			} else if (as < bs) {
				while (it.hasNext()) {
					final double ad = it.aDouble;
					boolean rb = true;
					for (int j = 0; rb && j < bs; j++) {
						rb &= ad > db.getElementDoubleAbs(it.bIndex + j);
					}
					r.setAbs(it.oIndex, rb);
				}
			} else {
				if (as == 1) {
					while (it.hasNext()) {
						r.setAbs(it.oIndex, it.aDouble > it.bDouble);
					}
				} else {
					while (it.hasNext()) {
						boolean rb = true;
						for (int j = 0; rb && j < bs; j++) {
							rb &= da.getElementDoubleAbs(it.aIndex + j) > db.getElementDoubleAbs(it.bIndex + j);
						}
						r.setAbs(it.oIndex, rb);
					}
				}
			}
		} else {
			if (as > bs) {
				while (it.hasNext()) {
					final double bl = it.bLong;
					boolean rb = true;
					for (int j = 0; rb && j < as; j++) {
						rb &= da.getElementLongAbs(it.aIndex + j) > bl;
					}
					r.setAbs(it.oIndex, rb);
				}
			} else if (as < bs) {
				while (it.hasNext()) {
					final double al = it.aLong;
					boolean rb = true;
					for (int j = 0; rb && j < bs; j++) {
						rb &= al > db.getElementLongAbs(it.bIndex + j);
					}
					r.setAbs(it.oIndex, rb);
				}
			} else {
				if (as == 1) {
					while (it.hasNext()) {
						r.setAbs(it.oIndex, it.aLong > it.bLong);
					}
				} else {
					while (it.hasNext()) {
						boolean rb = true;
						for (int j = 0; rb && j < bs; j++) {
							rb &= da.getElementLongAbs(it.aIndex + j) > db.getElementLongAbs(it.bIndex + j);
						}
						r.setAbs(it.oIndex, rb);
					}
				}
			}
		}

		return r;
	}

	/**
	 * Compare item-wise for whether a's element is greater than or equal to b's
	 * <p>
	 * For multi-element items, comparison is true if all elements in an item
	 * are greater or equal. Where the datasets have mismatched item sizes, the first element
	 * of the dataset with smaller items is used for comparison.
	 * @param a
	 * @param b
	 * @return dataset where item is true if a >= b
	 */
	public static BooleanDataset greaterThanOrEqualTo(Object a, Object b) {
		return greaterThanOrEqualTo(a, b, null);
	}

	/**
	 * Compare item-wise for whether a's element is greater than or equal to b's
	 * <p>
	 * For multi-element items, comparison is true if all elements in an item
	 * are greater or equal. Where the datasets have mismatched item sizes, the first element
	 * of the dataset with smaller items is used for comparison.
	 * @param a
	 * @param b
	 * @param o output can be null - in which case, a new dataset is created
	 * @return dataset where item is true if a >= b
	 */
	public static BooleanDataset greaterThanOrEqualTo(Object a, Object b, BooleanDataset o) {
		final Dataset da = a instanceof Dataset ? (Dataset) a : DatasetFactory.createFromObject(a);
		final Dataset db = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);

		List<int[]> sl = BroadcastIterator.broadcastShapes(da.getShapeRef(), db.getShapeRef(), o == null ? null : o.getShapeRef());

		final BooleanDataset r = o == null ? new BooleanDataset(sl.get(0)) : o;

		final BroadcastIteratorBase it = BroadcastIterator.createIterator(da, db, r);
		final int as = da.getElementsPerItem();
		final int bs = db.getElementsPerItem();

		if (it.isOutputDouble()) {
			if (as > bs) {
				while (it.hasNext()) {
					final double bd = it.bDouble;
					boolean rb = true;
					for (int j = 0; rb && j < as; j++) {
						rb &= da.getElementDoubleAbs(it.aIndex + j) >= bd;
					}
					r.setAbs(it.oIndex, rb);
				}
			} else if (as < bs) {
				while (it.hasNext()) {
					final double ad = it.aDouble;
					boolean rb = true;
					for (int j = 0; rb && j < bs; j++) {
						rb &= ad >= db.getElementDoubleAbs(it.bIndex + j);
					}
					r.setAbs(it.oIndex, rb);
				}
			} else {
				if (as == 1) {
					while (it.hasNext()) {
						r.setAbs(it.oIndex, it.aDouble >= it.bDouble);
					}
				} else {
					while (it.hasNext()) {
						boolean rb = true;
						for (int j = 0; rb && j < bs; j++) {
							rb &= da.getElementDoubleAbs(it.aIndex + j) >= db.getElementDoubleAbs(it.bIndex + j);
						}
						r.setAbs(it.oIndex, rb);
					}
				}
			}
		} else {
			if (as > bs) {
				while (it.hasNext()) {
					final double bl = it.bLong;
					boolean rb = true;
					for (int j = 0; rb && j < as; j++) {
						rb &= da.getElementLongAbs(it.aIndex + j) >= bl;
					}
					r.setAbs(it.oIndex, rb);
				}
			} else if (as < bs) {
				while (it.hasNext()) {
					final double al = it.aLong;
					boolean rb = true;
					for (int j = 0; rb && j < bs; j++) {
						rb &= al >= db.getElementLongAbs(it.bIndex + j);
					}
					r.setAbs(it.oIndex, rb);
				}
			} else {
				if (as == 1) {
					while (it.hasNext()) {
						r.setAbs(it.oIndex, it.aLong >= it.bLong);
					}
				} else {
					while (it.hasNext()) {
						boolean rb = true;
						for (int j = 0; rb && j < bs; j++) {
							rb &= da.getElementLongAbs(it.aIndex + j) >= db.getElementLongAbs(it.bIndex + j);
						}
						r.setAbs(it.oIndex, rb);
					}
				}
			}
		}

		return r;
	}

	/**
	 * Compare item-wise for whether a's element is less than b's
	 * <p>
	 * For multi-element items, comparison is true if all elements in an item
	 * are lesser. Where the datasets have mismatched item sizes, the first element
	 * of the dataset with smaller items is used for comparison.
	 * @param a
	 * @param b
	 * @return dataset where item is true if a < b
	 */
	public static BooleanDataset lessThan(Object a, Object b) {
		return lessThan(a, b, null);
	}

	/**
	 * Compare item-wise for whether a's element is less than b's
	 * <p>
	 * For multi-element items, comparison is true if all elements in an item
	 * are lesser. Where the datasets have mismatched item sizes, the first element
	 * of the dataset with smaller items is used for comparison.
	 * @param a
	 * @param b
	 * @param o output can be null - in which case, a new dataset is created
	 * @return dataset where item is true if a < b
	 */
	public static BooleanDataset lessThan(Object a, Object b, BooleanDataset o) {
		final Dataset da = a instanceof Dataset ? (Dataset) a : DatasetFactory.createFromObject(a);
		final Dataset db = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);

		List<int[]> sl = BroadcastIterator.broadcastShapes(da.getShapeRef(), db.getShapeRef(), o == null ? null : o.getShapeRef());

		final BooleanDataset r = o == null ? new BooleanDataset(sl.get(0)) : o;

		final BroadcastIteratorBase it = BroadcastIterator.createIterator(da, db, r);
		it.setOutputDouble(true);
		final int as = da.getElementsPerItem();
		final int bs = db.getElementsPerItem();

		if (it.isOutputDouble()) {
			if (as > bs) {
				while (it.hasNext()) {
					final double bd = it.bDouble;
					boolean rb = true;
					for (int j = 0; rb && j < as; j++) {
						rb &= da.getElementDoubleAbs(it.aIndex + j) < bd;
					}
					r.setAbs(it.oIndex, rb);
				}
			} else if (as < bs) {
				while (it.hasNext()) {
					final double ad = it.aDouble;
					boolean rb = true;
					for (int j = 0; rb && j < bs; j++) {
						rb &= ad < db.getElementDoubleAbs(it.bIndex + j);
					}
					r.setAbs(it.oIndex, rb);
				}
			} else {
				if (as == 1) {
					while (it.hasNext()) {
						r.setAbs(it.oIndex, it.aDouble < it.bDouble);
					}
				} else {
					while (it.hasNext()) {
						boolean rb = true;
						for (int j = 0; rb && j < bs; j++) {
							rb &= da.getElementDoubleAbs(it.aIndex + j) < db.getElementDoubleAbs(it.bIndex + j);
						}
						r.setAbs(it.oIndex, rb);
					}
				}
			}
		} else {
			if (as > bs) {
				while (it.hasNext()) {
					final double bl = it.bLong;
					boolean rb = true;
					for (int j = 0; rb && j < as; j++) {
						rb &= da.getElementLongAbs(it.aIndex + j) < bl;
					}
					r.setAbs(it.oIndex, rb);
				}
			} else if (as < bs) {
				while (it.hasNext()) {
					final double al = it.aLong;
					boolean rb = true;
					for (int j = 0; rb && j < bs; j++) {
						rb &= al < db.getElementLongAbs(it.bIndex + j);
					}
					r.setAbs(it.oIndex, rb);
				}
			} else {
				if (as == 1) {
					while (it.hasNext()) {
						r.setAbs(it.oIndex, it.aLong < it.bLong);
					}
				} else {
					while (it.hasNext()) {
						boolean rb = true;
						for (int j = 0; rb && j < bs; j++) {
							rb &= da.getElementLongAbs(it.aIndex + j) < db.getElementLongAbs(it.bIndex + j);
						}
						r.setAbs(it.oIndex, rb);
					}
				}
			}
		}

		return r;
	}

	/**
	 * Compare item-wise for whether a's element is less than or equal to b's
	 * <p>
	 * For multi-element items, comparison is true if all elements in an item
	 * are lesser or equal. Where the datasets have mismatched item sizes, the first element
	 * of the dataset with smaller items is used for comparison.
	 * @param a
	 * @param b
	 * @return dataset where item is true if a <= b
	 */
	public static BooleanDataset lessThanOrEqualTo(Object a, Object b) {
		return lessThanOrEqualTo(a, b, null);
	}

	/**
	 * Compare item-wise for whether a's element is less than or equal to b's
	 * <p>
	 * For multi-element items, comparison is true if all elements in an item
	 * are lesser or equal. Where the datasets have mismatched item sizes, the first element
	 * of the dataset with smaller items is used for comparison.
	 * @param a
	 * @param b
	 * @param o output can be null - in which case, a new dataset is created
	 * @return dataset where item is true if a <= b
	 */
	public static BooleanDataset lessThanOrEqualTo(Object a, Object b, BooleanDataset o) {
		final Dataset da = a instanceof Dataset ? (Dataset) a : DatasetFactory.createFromObject(a);
		final Dataset db = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);

		List<int[]> sl = BroadcastIterator.broadcastShapes(da.getShapeRef(), db.getShapeRef(), o == null ? null : o.getShapeRef());

		final BooleanDataset r = o == null ? new BooleanDataset(sl.get(0)) : o;

		final BroadcastIteratorBase it = BroadcastIterator.createIterator(da, db, r);
		it.setOutputDouble(true);
		final int as = da.getElementsPerItem();
		final int bs = db.getElementsPerItem();

		if (it.isOutputDouble()) {
			if (as > bs) {
				while (it.hasNext()) {
					final double bd = it.bDouble;
					boolean rb = true;
					for (int j = 0; rb && j < as; j++) {
						rb &= da.getElementDoubleAbs(it.aIndex + j) <= bd;
					}
					r.setAbs(it.oIndex, rb);
				}
			} else if (as < bs) {
				while (it.hasNext()) {
					final double ad = it.aDouble;
					boolean rb = true;
					for (int j = 0; rb && j < bs; j++) {
						rb &= ad <= db.getElementDoubleAbs(it.bIndex + j);
					}
					r.setAbs(it.oIndex, rb);
				}
			} else {
				if (as == 1) {
					while (it.hasNext()) {
						r.setAbs(it.oIndex, it.aDouble <= it.bDouble);
					}
				} else {
					while (it.hasNext()) {
						boolean rb = true;
						for (int j = 0; rb && j < bs; j++) {
							rb &= da.getElementDoubleAbs(it.aIndex + j) <= db.getElementDoubleAbs(it.bIndex + j);
						}
						r.setAbs(it.oIndex, rb);
					}
				}
			}
		} else {
			if (as > bs) {
				while (it.hasNext()) {
					final double bl = it.bLong;
					boolean rb = true;
					for (int j = 0; rb && j < as; j++) {
						rb &= da.getElementLongAbs(it.aIndex + j) <= bl;
					}
					r.setAbs(it.oIndex, rb);
				}
			} else if (as < bs) {
				while (it.hasNext()) {
					final double al = it.aLong;
					boolean rb = true;
					for (int j = 0; rb && j < bs; j++) {
						rb &= al <= db.getElementLongAbs(it.bIndex + j);
					}
					r.setAbs(it.oIndex, rb);
				}
			} else {
				if (as == 1) {
					while (it.hasNext()) {
						r.setAbs(it.oIndex, it.aLong <= it.bLong);
					}
				} else {
					while (it.hasNext()) {
						boolean rb = true;
						for (int j = 0; rb && j < bs; j++) {
							rb &= da.getElementLongAbs(it.aIndex + j) <= db.getElementLongAbs(it.bIndex + j);
						}
						r.setAbs(it.oIndex, rb);
					}
				}
			}
		}

		return r;
	}

	/**
	 * @param a
	 * @param lo lower bound
	 * @param hi upper bound
	 * @return dataset where item is true if l <= a <= h
	 */
	public static BooleanDataset withinRange(Object a, Number lo, Number hi) {
		return withinRange(a, null, lo, hi);
	}

	/**
	 * @param a
	 * @param lo lower bound
	 * @param hi upper bound
	 * @param o output can be null - in which case, a new dataset is created
	 * @return dataset where item is true if l <= a <= h
	 */
	public static BooleanDataset withinRange(Object a, BooleanDataset o, Number lo, Number hi) {
		final Dataset da = a instanceof Dataset ? (Dataset) a : DatasetFactory.createFromObject(a);

		List<int[]> sl = BroadcastIterator.broadcastShapes(da.getShapeRef(), o == null ? null : o.getShapeRef());

		final BooleanDataset r = o == null ? new BooleanDataset(sl.get(0)) : o;

		final SingleInputBroadcastIterator it = new SingleInputBroadcastIterator(da, r);
		final int as = da.getElementsPerItem();

		if (it.isOutputDouble()) {
			final double l = lo.doubleValue();
			final double h = hi.doubleValue();
			if (as == 1) {
				while (it.hasNext()) {
					final double ad = it.aDouble;
					r.setAbs(it.oIndex, ad >= l && ad <= h);
				}
			} else {
				while (it.hasNext()) {
					boolean rb = true;
					for (int j = 0; rb && j < as; j++) {
						final double ad = da.getElementDoubleAbs(it.aIndex);
						rb &= ad >= l && ad <= h;
					}
					r.setAbs(it.oIndex, rb);
				}
			}
		} else {
			final long l = lo.longValue();
			final long h = hi.longValue();
			if (as == 1) {
				while (it.hasNext()) {
					final long al = it.aLong;
					r.setAbs(it.oIndex, al >= l && al <= h);
				}
			} else {
				while (it.hasNext()) {
					boolean rb = true;
					for (int j = 0; rb && j < as; j++) {
						final long al = da.getElementLongAbs(it.aIndex);
						rb &= al >= l && al <= h;
					}
					r.setAbs(it.oIndex, rb);
				}
			}
		}

		return r;
	}

	/**
	 * Compare item-wise for whether a's element is almost equal to b's
	 * <p>
	 * For multi-element items, comparison is true if all elements in an item
	 * are equal up to a tolerance. Where the datasets have mismatched item sizes, the first element
	 * of the dataset with smaller items is used for comparison.
	 * @param a
	 * @param b
	 * @param relTolerance
	 * @param absTolerance
	 * @return true if all items satisfy abs(a - b) <= absTol + relTol*max(abs(a),abs(b))
	 */
	public static boolean allCloseTo(Object a, Object b, double relTolerance, double absTolerance) {
		final Dataset da = a instanceof Dataset ? (Dataset) a : DatasetFactory.createFromObject(a);
		final Dataset db = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);

		final BroadcastIteratorBase it = BroadcastIterator.createIterator(da, db);
		it.setOutputDouble(true);
		final int as = da.getElementsPerItem();
		final int bs = db.getElementsPerItem();

		if (as > bs) {
			if (da.isComplex()) {
				while (it.hasNext()) {
					if (!isCloseNP(it.aDouble, it.bDouble, relTolerance, absTolerance))
						return false;
					if (!isCloseNP(da.getElementDoubleAbs(it.aIndex + 1), relTolerance, absTolerance))
						return false;
				}
			} else {
				while (it.hasNext()) {
					final double bd = it.bDouble;
					for (int j = 0; j < as; j++) {
						if (!isCloseNP(da.getElementDoubleAbs(it.aIndex + j), bd, relTolerance, absTolerance))
							return false;
					}
				}
			}
		} else if (as < bs) {
			if (db.isComplex()) {
				while (it.hasNext()) {
					if (!isCloseNP(it.aDouble, it.bDouble, relTolerance, absTolerance))
						return false;
					if (!isCloseNP(db.getElementDoubleAbs(it.bIndex + 1), relTolerance, absTolerance))
						return false;
				}
			} else {
				while (it.hasNext()) {
					final double ad = it.aDouble;
					for (int j = 0; j < bs; j++) {
						if (!isCloseNP(ad, db.getElementDoubleAbs(it.bIndex + j), relTolerance, absTolerance))
							return false;
					}
				}
			}
		} else {
			if (as == 1) {
				while (it.hasNext()) {
					if (!isCloseNP(it.aDouble, it.bDouble, relTolerance, absTolerance))
						return false;
				}
			} else {
				while (it.hasNext()) {
					for (int j = 0; j < bs; j++) {
						if (!isCloseNP(da.getElementDoubleAbs(it.aIndex + j), db.getElementDoubleAbs(it.bIndex + j), relTolerance, absTolerance))
							return false;
					}
				}
			}
		}
		
		return true;
	}

	/**
	 * @param a
	 * @return true if all elements are true
	 */
	public static boolean allTrue(Object a) {
		final Dataset da = a instanceof Dataset ? (Dataset) a : DatasetFactory.createFromObject(a);
		final IndexIterator it = da.getIterator();
		final int as = da.getElementsPerItem();

		if (as == 1) {
			while (it.hasNext()) {
				if (!da.getElementBooleanAbs(it.index))
					return false;
			}
		} else {
			while (it.hasNext()) {
				for (int j = 0; j < as; j++) {
					if (!da.getElementBooleanAbs(it.index + j))
						return false;
				}
			}
		}
		return true;
	}

	/**
	 * @param a
	 * @return true if all elements are true
	 */
	public static BooleanDataset allTrue(IDataset a, int axis) {
		axis = AbstractDataset.checkAxis(a.getRank(), axis);

		int rank = a.getRank();
		int[] oshape = a.getShape();
		int alen = oshape[axis];
		oshape[axis] = 1;

		int[] nshape = AbstractDataset.squeezeShape(oshape, false);

		BooleanDataset result = new BooleanDataset(nshape);

		IndexIterator qiter = result.getIterator(true);
		int[] qpos = qiter.getPos();
		int[] spos = oshape;

		while (qiter.hasNext()) {
			int i = 0;
			for (; i < axis; i++) {
				spos[i] = qpos[i];
			}
			spos[i++] = 0;
			for (; i < rank; i++) {
				spos[i] = qpos[i-1];
			}

			boolean br = true;
			for (int j = 0; br && j < alen; j++) {
				spos[axis] = j;
				br &= a.getBoolean(spos);
			}
			result.set(br, qpos);
		}
		return result;
	}

	/**
	 * @param a
	 * @return true if any element is true
	 */
	public static boolean anyTrue(Object a) {
		final Dataset da = a instanceof Dataset ? (Dataset) a : DatasetFactory.createFromObject(a);
		final IndexIterator it = da.getIterator();
		final int as = da.getElementsPerItem();

		if (as == 1) {
			while (it.hasNext()) {
				if (da.getElementBooleanAbs(it.index))
					return true;
			}
		} else {
			while (it.hasNext()) {
				for (int j = 0; j < as; j++) {
					if (da.getElementBooleanAbs(it.index + j))
						return true;
				}
			}
		}
		return false;
	}

	/**
	 * @param a
	 * @return true if any element is true
	 */
	public static BooleanDataset anyTrue(IDataset a, int axis) {
		axis = AbstractDataset.checkAxis(a.getRank(), axis);

		int rank = a.getRank();
		int[] oshape = a.getShape();
		int alen = oshape[axis];
		oshape[axis] = 1;

		int[] nshape = AbstractDataset.squeezeShape(oshape, false);

		BooleanDataset result = new BooleanDataset(nshape);

		IndexIterator qiter = result.getIterator(true);
		int[] qpos = qiter.getPos();
		int[] spos = oshape;

		while (qiter.hasNext()) {
			int i = 0;
			for (; i < axis; i++) {
				spos[i] = qpos[i];
			}
			spos[i++] = 0;
			for (; i < rank; i++) {
				spos[i] = qpos[i-1];
			}

			boolean br = false;
			for (int j = 0; !br && j < alen; j++) {
				spos[axis] = j;
				br |= a.getBoolean(spos);
			}
			result.set(br, qpos);
		}
		return result;
	}

	/**
	 * Negate item-wise
	 * <p>
	 * For multi-element items, negation is false if all elements in a pair of items
	 * are true.
	 * @param a
	 * @return dataset where item is true when a is false
	 */
	public static BooleanDataset logicalNot(Object a) {
		return logicalNot(a, null);
	}

	/**
	 * Negate item-wise
	 * <p>
	 * For multi-element items, negation is false if all elements in a pair of items
	 * are true.
	 * @param a
	 * @param o output can be null - in which case, a new dataset is created
	 * @return dataset where item is true when a is false
	 */
	public static BooleanDataset logicalNot(Object a, BooleanDataset o) {
		final Dataset da = a instanceof Dataset ? (Dataset) a : DatasetFactory.createFromObject(a);

		List<int[]> sl = BroadcastIterator.broadcastShapes(da.getShapeRef(), o == null ? null : o.getShapeRef());

		final BooleanDataset r = o == null ? new BooleanDataset(sl.get(0)) : o;

		final SingleInputBroadcastIterator it = new SingleInputBroadcastIterator(da, r);
		final int as = da.getElementsPerItem();

		if (as == 1) {
			while (it.hasNext()) {
				r.setAbs(it.oIndex, !da.getElementBooleanAbs(it.aIndex));
			}
		} else {
			boolean br = true;
			while (it.hasNext()) {
				for (int j = 0; j < as; j++) {
					br &= da.getElementBooleanAbs(it.aIndex + j);
				}
				r.setAbs(it.oIndex, !br);
			}
		}
		return r;
	}

	/**
	 * Compare item-wise for whether a's item is true and b's true too.
	 * <p>
	 * For multi-element items, comparison is true if all elements in a pair of items
	 * are true. Where the datasets have mismatched item sizes, the first element
	 * of the dataset with smaller items is used for comparison.
	 * @param a
	 * @param b
	 * @return dataset where item is true if a && b is true
	 */
	public static BooleanDataset logicalAnd(Object a, Object b) {
		return logicalAnd(a, b, null);
	}

	/**
	 * Compare item-wise for whether a's item is true and b's true too.
	 * <p>
	 * For multi-element items, comparison is true if all elements in a pair of items
	 * are true. Where the datasets have mismatched item sizes, the first element
	 * of the dataset with smaller items is used for comparison.
	 * @param a
	 * @param b
	 * @param o output can be null - in which case, a new dataset is created
	 * @return dataset where item is true if a && b is true
	 */
	public static BooleanDataset logicalAnd(Object a, Object b, BooleanDataset o) {
		final Dataset da = a instanceof Dataset ? (Dataset) a : DatasetFactory.createFromObject(a);
		final Dataset db = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);

		List<int[]> sl = BroadcastIterator.broadcastShapes(da.getShapeRef(), db.getShapeRef(), o == null ? null : o.getShapeRef());

		final BooleanDataset r = o == null ? new BooleanDataset(sl.get(0)) : o;

		final BroadcastIteratorBase it = BroadcastIterator.createIterator(da, db, r);
		it.setOutputDouble(true);
		final int as = da.getElementsPerItem();
		final int bs = db.getElementsPerItem();

		if (as > bs) {
			while (it.hasNext()) {
				final boolean bb = db.getElementBooleanAbs(it.bIndex);
				boolean rb = true;
				for (int j = 0; rb && j < as; j++) {
					rb &= da.getElementBooleanAbs(it.aIndex + j) && bb;
				}
				r.setAbs(it.oIndex, rb);
			}
		} else if (as < bs) {
			while (it.hasNext()) {
				final boolean ab = da.getElementBooleanAbs(it.aIndex);
				boolean rb = true;
				for (int j = 0; rb && j < bs; j++) {
					rb &= ab && db.getElementBooleanAbs(it.bIndex + j);
				}
				r.setAbs(it.oIndex, rb);
			}
		} else {
			if (as == 1) {
				while (it.hasNext()) {
					r.setAbs(it.oIndex, da.getElementBooleanAbs(it.aIndex) && db.getElementBooleanAbs(it.bIndex));
				}
			} else {
				while (it.hasNext()) {
					boolean rb = true;
					for (int j = 0; rb && j < bs; j++) {
						rb &= da.getElementBooleanAbs(it.aIndex + j) && db.getElementBooleanAbs(it.bIndex + j);
					}
					r.setAbs(it.oIndex, rb);
				}
			}
		}

		return r;
	}

	/**
	 * Compare item-wise for whether a's item is true or b's true.
	 * <p>
	 * For multi-element items, comparison is true if any elements in a pair of items
	 * are true. Where the datasets have mismatched item sizes, the first element
	 * of the dataset with smaller items is used for comparison.
	 * @param a
	 * @param b
	 * @return dataset where item is true if a || b is true
	 */
	public static BooleanDataset logicalOr(Object a, Object b) {
		return logicalOr(a, b, null);
	}

	/**
	 * Compare item-wise for whether a's item is true or b's true.
	 * <p>
	 * For multi-element items, comparison is true if any elements in a pair of items
	 * are true. Where the datasets have mismatched item sizes, the first element
	 * of the dataset with smaller items is used for comparison.
	 * @param a
	 * @param b
	 * @param o output can be null - in which case, a new dataset is created
	 * @return dataset where item is true if a || b is true
	 */
	public static BooleanDataset logicalOr(Object a, Object b, BooleanDataset o) {
		final Dataset da = a instanceof Dataset ? (Dataset) a : DatasetFactory.createFromObject(a);
		final Dataset db = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);

		List<int[]> sl = BroadcastIterator.broadcastShapes(da.getShapeRef(), db.getShapeRef(), o == null ? null : o.getShapeRef());

		final BooleanDataset r = o == null ? new BooleanDataset(sl.get(0)) : o;

		final BroadcastIteratorBase it = BroadcastIterator.createIterator(da, db, r);
		it.setOutputDouble(true);
		final int as = da.getElementsPerItem();
		final int bs = db.getElementsPerItem();

		if (as > bs) {
			while (it.hasNext()) {
				final boolean bb = db.getElementBooleanAbs(it.bIndex);
				boolean rb = true;
				for (int j = 0; j < as; j++) {
					rb |= da.getElementBooleanAbs(it.aIndex + j) || bb;
				}
				r.setAbs(it.oIndex, rb);
			}
		} else if (as < bs) {
			while (it.hasNext()) {
				final boolean ab = da.getElementBooleanAbs(it.aIndex);
				boolean rb = true;
				for (int j = 0; rb && j < bs; j++) {
					rb |= ab || db.getElementBooleanAbs(it.bIndex + j);
				}
				r.setAbs(it.oIndex, rb);
			}
		} else {
			if (as == 1) {
				while (it.hasNext()) {
					r.setAbs(it.oIndex, da.getElementBooleanAbs(it.aIndex) || db.getElementBooleanAbs(it.bIndex));
				}
			} else {
				while (it.hasNext()) {
					boolean rb = true;
					for (int j = 0; rb && j < bs; j++) {
						rb &= da.getElementBooleanAbs(it.aIndex + j) || db.getElementBooleanAbs(it.bIndex + j);
					}
					r.setAbs(it.oIndex, rb);
				}
			}
		}

		return r;
	}

	/**
	 * Compare item-wise for whether a's item is true or b's true exclusively.
	 * <p>
	 * For multi-element items, comparison is true if one element in a pair of items
	 * is true. Where the datasets have mismatched item sizes, the first element
	 * of the dataset with smaller items is used for comparison.
	 * @param a
	 * @param b
	 * @return dataset where item is true if a ^ b is true
	 */
	public static BooleanDataset logicalXor(Object a, Object b) {
		return logicalXor(a, b, null);
	}

	/**
	 * Compare item-wise for whether a's item is true or b's true exclusively.
	 * <p>
	 * For multi-element items, comparison is true if one element in a pair of items
	 * is true. Where the datasets have mismatched item sizes, the first element
	 * of the dataset with smaller items is used for comparison.
	 * @param a
	 * @param b
	 * @param o output can be null - in which case, a new dataset is created
	 * @return dataset where item is true if a ^ b is true
	 */
	public static BooleanDataset logicalXor(Object a, Object b, BooleanDataset o) {
		final Dataset da = a instanceof Dataset ? (Dataset) a : DatasetFactory.createFromObject(a);
		final Dataset db = b instanceof Dataset ? (Dataset) b : DatasetFactory.createFromObject(b);

		List<int[]> sl = BroadcastIterator.broadcastShapes(da.getShapeRef(), db.getShapeRef(), o == null ? null : o.getShapeRef());

		final BooleanDataset r = o == null ? new BooleanDataset(sl.get(0)) : o;

		final BroadcastIteratorBase it = BroadcastIterator.createIterator(da, db, r);
		it.setOutputDouble(true);
		final int as = da.getElementsPerItem();
		final int bs = db.getElementsPerItem();

		if (as > bs) {
			while (it.hasNext()) {
				boolean rb = db.getElementBooleanAbs(it.bIndex);
				for (int j = 0; j < as; j++) {
					rb ^= da.getElementBooleanAbs(it.aIndex + j);
				}
				r.setAbs(it.oIndex, rb);
			}
		} else if (as < bs) {
			while (it.hasNext()) {
				boolean rb = da.getElementBooleanAbs(it.aIndex);
				for (int j = 0; rb && j < bs; j++) {
					rb ^= db.getElementBooleanAbs(it.bIndex + j);
				}
				r.setAbs(it.oIndex, rb);
			}
		} else {
			if (as == 1) {
				while (it.hasNext()) {
					r.setAbs(it.oIndex, da.getElementBooleanAbs(it.aIndex) ^ db.getElementBooleanAbs(it.bIndex));
				}
			} else {
				while (it.hasNext()) {
					boolean rb = true;
					for (int j = 0; rb && j < bs; j++) {
						rb &= da.getElementBooleanAbs(it.aIndex + j) ^ db.getElementBooleanAbs(it.bIndex + j);
					}
					r.setAbs(it.oIndex, rb);
				}
			}
		}

		return r;
	}

	/**
	 * Create a list of indices of positions where items are non-zero
	 * @param a
	 * @return list of positions as integer datasets
	 */
	public static List<IntegerDataset> nonZero(Dataset a) {
		final int rank = a.getRank();
		final List<List<Integer>> indices = new ArrayList<List<Integer>>();
		List<IntegerDataset> indexList = new ArrayList<IntegerDataset>();

		if (rank == 0)
			return indexList;

		for (int j = 0; j < rank; j++) {
			indices.add(new ArrayList<Integer>());
		}

		final IndexIterator iter = a.getIterator(true);
		final int[] pos = iter.getPos();
		while (iter.hasNext()) {
			if (a.getElementBooleanAbs(iter.index)) {
				for (int j = 0; j < rank; j++) {
					indices.get(j).add(pos[j]);
				}
			}
		}

	
		final int length = indices.get(0).size();
		if (length > 0 ) {
			for (int j = 0; j < rank; j++) {
				indexList.add((IntegerDataset) DatasetFactory.createFromList(indices.get(j)));
			}
		}
		return indexList;
	}

	/**
	 * Check item-wise for whether any a's elements are Not-a-Numbers
	 * <p>
	 * For multi-element items, check is true if any elements in an item is Not-a-Number.
	 * @param a
	 * @return dataset where item is true if any of its elements are NaNs
	 */
	public static BooleanDataset isNaN(Object a) {
		return isNaN(a, null);
	}

	/**
	 * Check item-wise for whether any a's elements are Not-a-Numbers
	 * <p>
	 * For multi-element items, check is true if any elements in an item is Not-a-Number.
	 * @param a
	 * @param o output can be null - in which case, a new dataset is created
	 * @return dataset where item is true if any of its elements are NaNs
	 */
	public static BooleanDataset isNaN(Object a, BooleanDataset o) {
		final Dataset da = a instanceof Dataset ? (Dataset) a : DatasetFactory.createFromObject(a);

		List<int[]> sl = BroadcastIterator.broadcastShapes(da.getShapeRef(), o == null ? null : o.getShapeRef());

		final BooleanDataset r = o == null ? new BooleanDataset(sl.get(0)) : o;

		if (!da.hasFloatingPointElements()) {
			if (r == o) {
				r.fill(false);
			}
			return r;
		}

		final SingleInputBroadcastIterator it = new SingleInputBroadcastIterator(da, r);
		it.setOutputDouble(true);
		final int as = da.getElementsPerItem();

		if (as == 1) {
			while (it.hasNext()) {
				r.setAbs(it.oIndex, Double.isNaN(it.aDouble));
			}
		} else {
			if (da instanceof ComplexFloatDataset || da instanceof ComplexDoubleDataset) {
				while (it.hasNext()) {
					r.setAbs(it.oIndex, Double.isNaN(it.aDouble) || Double.isNaN(da.getElementDoubleAbs(it.aIndex + 1)));
				}
			} else {
				while (it.hasNext()) {
					boolean rb = false;
					for (int j = 0; !rb && j < as; j++) {
						rb &= Double.isNaN(da.getElementDoubleAbs(it.aIndex + j));
					}
					r.setAbs(it.oIndex, rb);
				}
			}
		}
		return r;
	}

	/**
	 * Check item-wise for whether any a's elements are infinite
	 * <p>
	 * For multi-element items, check is true if any elements in an item is infinite
	 * @param a
	 * @return dataset where item is true if any of its elements are infinite
	 */
	public static BooleanDataset isInfinite(Object a) {
		return isInfinite(a, null);
	}

	/**
	 * Check item-wise for whether any a's elements are infinite
	 * <p>
	 * For multi-element items, check is true if any elements in an item is infinite
	 * @param a
	 * @param o output can be null - in which case, a new dataset is created
	 * @return dataset where item is true if any of its elements are infinite
	 */
	public static BooleanDataset isInfinite(Object a, BooleanDataset o) {
		final Dataset da = a instanceof Dataset ? (Dataset) a : DatasetFactory.createFromObject(a);

		List<int[]> sl = BroadcastIterator.broadcastShapes(da.getShapeRef(), o == null ? null : o.getShapeRef());

		final BooleanDataset r = o == null ? new BooleanDataset(sl.get(0)) : o;

		if (!da.hasFloatingPointElements()) {
			if (r == o) {
				r.fill(false);
			}
			return r;
		}

		final SingleInputBroadcastIterator it = new SingleInputBroadcastIterator(da, r);
		it.setOutputDouble(true);
		final int as = da.getElementsPerItem();

		if (as == 1) {
			while (it.hasNext()) {
				r.setAbs(it.oIndex, Double.isInfinite(it.aDouble));
			}
		} else {
			if (da instanceof ComplexFloatDataset || da instanceof ComplexDoubleDataset) {
				while (it.hasNext()) {
					r.setAbs(it.oIndex, Double.isInfinite(it.aDouble) || Double.isInfinite(da.getElementDoubleAbs(it.aIndex + 1)));
				}
			} else {
				while (it.hasNext()) {
					boolean rb = false;
					for (int j = 0; !rb && j < as; j++) {
						rb &= Double.isInfinite(da.getElementDoubleAbs(it.aIndex + j));
					}
					r.setAbs(it.oIndex, rb);
				}
			}
		}
		return r;
	}

	/**
	 * Check item-wise for whether any a's elements are positive infinite
	 * <p>
	 * For multi-element items, the check is true if any elements in an item is positive infinite
	 * @param a
	 * @return dataset where items are true if any of its elements are positive infinite
	 */
	public static BooleanDataset isPositiveInfinite(Object a) {
		return isEqual(a, null, Double.POSITIVE_INFINITY);
	}

	/**
	 * Check item-wise for whether any a's elements are positive infinite
	 * <p>
	 * For multi-element items, the check is true if any elements in an item is positive infinite
	 * @param a
	 * @param o output can be null - in which case, a new dataset is created
	 * @return dataset where items are true if any of its elements are positive infinite
	 */
	public static BooleanDataset isPositiveInfinite(Object a, BooleanDataset o) {
		return isEqual(a, o, Double.POSITIVE_INFINITY);
	}

	/**
	 * Check item-wise for whether any a's elements are negative infinite
	 * <p>
	 * For multi-element items, the check is true if any elements in an item is negative infinite
	 * @param a
	 * @return dataset where items are true if any of its elements are negative infinite
	 */
	public static BooleanDataset isNegativeInfinite(Object a) {
		return isEqual(a, null, Double.NEGATIVE_INFINITY);
	}

	/**
	 * Check item-wise for whether any a's elements are negative infinite
	 * <p>
	 * For multi-element items, the check is true if any elements in an item is negative infinite
	 * @param a
	 * @param o output can be null - in which case, a new dataset is created
	 * @return dataset where items are true if any of its elements are negative infinite
	 */
	public static BooleanDataset isNegativeInfinite(Object a, BooleanDataset o) {
		return isEqual(a, o, Double.NEGATIVE_INFINITY);
	}

	/**
	 * Check item-wise for whether any a's elements match given item
	 * <p>
	 * For multi-element items, the check is true if any elements in an item matches
	 * @param a
	 * @param o output can be null - in which case, a new dataset is created
	 * @param match
	 * @return dataset where items are true if any of its elements match
	 */
	private static BooleanDataset isEqual(Object a, BooleanDataset o, final double match) {
		final Dataset da = a instanceof Dataset ? (Dataset) a : DatasetFactory.createFromObject(a);

		List<int[]> sl = BroadcastIterator.broadcastShapes(da.getShapeRef(), o == null ? null : o.getShapeRef());

		final BooleanDataset r = o == null ? new BooleanDataset(sl.get(0)) : o;

		if (!da.hasFloatingPointElements()) {
			if (r == o) {
				r.fill(false);
			}
			return r;
		}

		final SingleInputBroadcastIterator it = new SingleInputBroadcastIterator(da, r);
		it.setOutputDouble(true);
		final int as = da.getElementsPerItem();

		if (as == 1) {
			while (it.hasNext()) {
				r.setAbs(it.oIndex, it.aDouble == match);
			}
		} else {
			if (da instanceof ComplexFloatDataset || da instanceof ComplexDoubleDataset) {
				while (it.hasNext()) {
					final double rv = it.aDouble;
					final double iv = da.getElementDoubleAbs(it.aIndex + 1);
					r.setAbs(it.oIndex, (rv == match) || (iv == match));
				}
			} else {
				while (it.hasNext()) {
					boolean rb = false;
					for (int j = 0; !rb && j < as; j++) {
						rb &= da.getElementDoubleAbs(it.aIndex + j) == match;
					}
					r.setAbs(it.oIndex, rb);
				}
			}
		}
		return r;
	}

	/**
	 * Check item-wise for whether any a's elements are finite (or not infinite and not Not-a-Number)
	 * <p>
	 * For multi-element items, check is true if any elements in an item is finite
	 * @param a
	 * @return dataset where item is true if any of its elements are finite
	 */
	public static BooleanDataset isFinite(Object a) {
		return isFinite(a, null);
	}

	/**
	 * Check item-wise for whether any a's elements are finite (or not infinite and not Not-a-Number)
	 * <p>
	 * For multi-element items, check is true if any elements in an item is finite
	 * @param a
	 * @param o output can be null - in which case, a new dataset is created
	 * @return dataset where item is true if any of its elements are finite
	 */
	public static BooleanDataset isFinite(Object a, BooleanDataset o) {
		final Dataset da = a instanceof Dataset ? (Dataset) a : DatasetFactory.createFromObject(a);

		List<int[]> sl = BroadcastIterator.broadcastShapes(da.getShapeRef(), o == null ? null : o.getShapeRef());

		final BooleanDataset r = o == null ? new BooleanDataset(sl.get(0)) : o;

		if (!da.hasFloatingPointElements()) {
			r.fill(true);
			return r;
		}

		final SingleInputBroadcastIterator it = new SingleInputBroadcastIterator(da, r);
		it.setOutputDouble(true);
		final int as = da.getElementsPerItem();

		if (as == 1) {
			while (it.hasNext()) {
				final double rv = it.aDouble;
				r.setAbs(it.oIndex, !(Double.isInfinite(rv) || Double.isNaN(rv)));
			}
		} else {
			if (da instanceof ComplexFloatDataset || da instanceof ComplexDoubleDataset) {
				while (it.hasNext()) {
					final double rv = it.aDouble;
					final double iv = da.getElementDoubleAbs(it.aIndex + 1);
					r.setAbs(it.oIndex, !(Double.isInfinite(rv) || Double.isNaN(rv) || Double.isInfinite(iv) || Double.isNaN(iv)));
				}
			} else {
				while (it.hasNext()) {
					boolean rb = false;
					for (int j = 0; !rb && j < as; j++) {
						final double rv = it.aDouble;
						rb &= !(Double.isInfinite(rv) || Double.isNaN(rv));
					}
					r.setAbs(it.oIndex, rb);
				}
			}
		}
		return r;
	}
}
