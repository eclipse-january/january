package org.eclipse.january.examples.dataset;

import org.eclipse.january.dataset.ByteDataset;
import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.dataset.IndexIterator;
import org.eclipse.january.dataset.PositionIterator;
import org.eclipse.january.dataset.SliceND;

/**
 * Implementation of the board for Conway's Game of Life
 * <p>
 * This implementation uses a border of extra cells to enforce periodic boundary
 * conditions so the board behaves like a 2D torus
 */
public class ConwayGameOfLife {
	private ByteDataset currentBoard;
	private ByteDataset nextBoard;
	private int rowEnd;
	private int colEnd;
	private SliceND firstRow;
	private SliceND downRow;
	private SliceND upRow;
	private SliceND lastRow;
	private SliceND firstCol;
	private SliceND leftCol;
	private SliceND rightCol;
	private SliceND lastCol;
	private SliceND cellSlice;
	private SliceND viewSlice;

	/**
	 * Create a Game of Life
	 * @param seedingBoard
	 */
	public ConwayGameOfLife(Dataset seedingBoard) {
		setSeed(seedingBoard);
	}

	/**
	 * Set seeding board to initialize
	 * @param seedingBoard
	 */
	public void setSeed(Dataset seedingBoard) {
		if (seedingBoard.getRank() != 2) {
			throw new IllegalArgumentException("Seeding board must be 2D");
		}

		int[] shape = seedingBoard.getShape();
		// expand board so seeding board is surrounded by a border of extra cells
		shape[0] += 2;
		shape[1] += 2;
		rowEnd = shape[0] - 1;
		colEnd = shape[1] - 1;
		int[] step = new int[] {1, 1};

		firstRow = new SliceND(shape, new int[] {0, 1}, new int[] {1, colEnd}, step);
		upRow    = new SliceND(shape, new int[] {1, 1}, new int[] {2, colEnd}, step);
		downRow  = new SliceND(shape, new int[] {rowEnd - 1, 1}, new int[] {rowEnd, colEnd}, step);
		lastRow  = new SliceND(shape, new int[] {rowEnd, 1}, new int[] {shape[0], colEnd}, step);

		firstCol = new SliceND(shape, new int[] {0, 0}, new int[] {shape[0], 1}, step);
		leftCol = new SliceND(shape, new int[] {0, 1}, new int[] {shape[0], 2}, step);
		rightCol = new SliceND(shape, new int[] {0, colEnd - 1}, new int[] {shape[0], colEnd}, step);
		lastCol = new SliceND(shape, new int[] {0, colEnd}, new int[] {shape[0], shape[1]}, step);

		cellSlice = new SliceND(shape, new int[] {0, 0}, new int[] {3, 3}, step);
		viewSlice = new SliceND(shape, new int[] {1,1}, new int[] {rowEnd, colEnd}, step);

		currentBoard = DatasetFactory.zeros(ByteDataset.class, shape);
		currentBoard.setSlice(seedingBoard, viewSlice);
		updateBoundaryCells();
		nextBoard = DatasetFactory.zeros(currentBoard);
	}

	/**
	 * Update boundary cells to make current board look like a 2D torus
	 */
	private void updateBoundaryCells() {
		// copy up row to last and down row to first
		currentBoard.setSlice(currentBoard.getSliceView(upRow), lastRow);
		currentBoard.setSlice(currentBoard.getSliceView(downRow), firstRow);

		// copy left column to last and right column to first
		currentBoard.setSlice(currentBoard.getSliceView(leftCol), lastCol);
		currentBoard.setSlice(currentBoard.getSliceView(rightCol), firstCol);
	}

	/**
	 * Advance board state by one tick
	 */
	public void tick() {
		int[] start = cellSlice.getStart();
		int[] stop = cellSlice.getStop();

		// iterate over central portion of board
		PositionIterator it = new PositionIterator(viewSlice);
		int[] position = it.getPos();
		while (it.hasNext()) {
			// configure cell slice
			int i = position[0];
			start[0] = i - 1;
			stop[0] = i + 2;
			int j = position[1];
			start[1] = j - 1;
			stop[1] = j + 2;
			int count = ((Number) currentBoard.getSliceView(cellSlice).sum()).intValue();
			updateCell(i, j, count);
		}

		ByteDataset tmp = currentBoard;
		currentBoard = nextBoard;
		nextBoard = tmp;
		updateBoundaryCells();
	}

	/**
	 * @return current board
	 */
	public Dataset getCurrentBoard() {
		if (currentBoard == null) {
			return null;
		}
		return currentBoard.getSliceView(viewSlice);
	}

	/**
	 * Update cell on next board
	 * @param i cell's row
	 * @param j cell's column
	 * @param count tally of populated cells in 3x3 square centred on given position
	 */
	private void updateCell(int i, int j, int count) {
		int current = currentBoard.getInt(i, j);
		if (current == 0) {
			if (count == 3) { // reproduction
				nextBoard.setItem((byte) 1, i, j);
			} else {
				nextBoard.setItem((byte) 0, i, j);
			}
		} else {
			switch (count) { // this count includes current==1
			case 3: // sustainable population
			case 4: // ditto
				nextBoard.setItem((byte) 1, i, j);
				break;
			case 1: // under-population
			case 2: // ditto
			default: // over-population
				nextBoard.setItem((byte) 0, i, j);
				break;
			}
		}
	}

	@Override
	public String toString() {
		return toString('.',  'X');
	}

	/**
	 * Convert to board to a string where empty cells are represented by
	 * {@code off} and populated cells by {@code on}
	 * @param off character for empty cell
	 * @param on character for populated cell
	 * @return board state as a string
	 */
	public String toString(char off, char on) {
		return toString(String.valueOf(off), String.valueOf(on));
	}

	/**
	 * Convert to board to a string where empty cells are represented by
	 * {@code off} and populated cells by {@code on}
	 * @param off string for empty cell
	 * @param on string for populated cell
	 * @return board state as a string
	 */
	public String toString(String off, String on) {
		if (currentBoard == null) {
			return null;
		}

		StringBuilder output = new StringBuilder((rowEnd - 1) * colEnd);
		ByteDataset current = (ByteDataset) getCurrentBoard();
		IndexIterator it = current.getIterator();
		int col = 1;
		while (it.hasNext()) {
			output.append(current.getAbs(it.index) == 0 ? off : on);
			col++;
			if (col == colEnd) {
				col = 1;
				output.append('\n');
			}
		}

		return output.toString();
	}

	/**
	 * Stable block pattern
	 */
	static byte[][] blockSeed = {
			{ 0, 0, 0, 0 },
			{ 0, 1, 1, 0 },
			{ 0, 1, 1, 0 },
			{ 0, 0, 0, 0 },
	};

	/**
	 * Stable pattern called beehive
	 */
	static byte[][] beehiveSeed = {
			{ 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 1, 1, 0, 0 },
			{ 0, 1, 0, 0, 1, 0 },
			{ 0, 0, 1, 1, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 },
	};

	/**
	 * Period-two pattern switches between vertical and horizontal line
	 */
	static byte[][] blinkerSeed = {
			{ 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 1, 0, 0, 0 },
			{ 0, 0, 1, 0, 0, 0 },
			{ 0, 0, 1, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 },
	};

	/**
	 * Pattern glides forever
	 */
	static byte[][] gliderSeed = {
			{ 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 1, 0, 0, 0 },
			{ 0, 0, 0, 1, 0, 0 },
			{ 0, 1, 1, 1, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 },
	};

	/**
	 * Pattern reduces to a glider
	 */
	static byte[][] messySeed = {
			{ 0, 1, 1, 0, 0, 0, 0, 0 },
			{ 0, 1, 1, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 1, 1, 1, 0 },
			{ 0, 0, 1, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 1, 0, 0, 0, 0 },
			{ 0, 1, 1, 1, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 },
	};

	public static void main(String[] argv) throws Exception {
		ByteDataset seed = DatasetFactory.createFromObject(ByteDataset.class, messySeed);
		ConwayGameOfLife game = new ConwayGameOfLife(seed);

		for (int i = 0; i < 30; i++) {
			System.out.printf("Board at tick %d:\n", i);
			System.out.println(game);
			game.tick();
		}

		System.out.println("Final board:");
		System.out.println(game);
	}
}

