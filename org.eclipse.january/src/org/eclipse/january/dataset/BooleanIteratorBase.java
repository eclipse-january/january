package org.eclipse.january.dataset;

/**
 * @since 2.1
 */
abstract class BooleanIteratorBase extends BooleanIterator {

	protected int[] aShape;
	protected int[] aStride;
	protected int[] oStride;

	protected int endrank;

	/**
	 * position in dataset
	 */
	protected int[] pos;
	protected int[] aDelta;
	protected int[] oDelta; // this being non-null means output is different from inputs

	/**
	 * Construct a boolean iterator that stops at the given boolean value in choice dataset
	 * @param v boolean value
	 * @param a primary dataset
	 * @param c choice dataset
	 * @param o output dataset, can be null
	 */
	protected BooleanIteratorBase(boolean v, Dataset a, Dataset c, Dataset o) {
		super(v, a, c, o);
	}

	/**
	 * @return shape of first broadcasted dataset
	 */
	public int[] getFirstShape() {
		return aShape;
	}

	@Override
	public int[] getPos() {
		return pos;
	}
}
