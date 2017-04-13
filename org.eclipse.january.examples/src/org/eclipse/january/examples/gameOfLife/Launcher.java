package org.eclipse.january.examples.gameOfLife;

import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;


/**
 * Class to launch the game of life, this class display the cells status at a step and which play the game the wanted time
 * @author Pierre Sachot
 *
 */
public class Launcher {
	
	private static int nbRound = 40;

	/**
	 * This method initialize the Dataset to display, play the number of game rounds defines by the nbRound variable 
	 * @param args
	 */
	public static void main(String[] args) {
		//Declaration of the game cells in a boolean Dataset
		Dataset cells = DatasetFactory.createFromObject(new boolean[][] {{	false, false, false,false, false, false, false, false, false, false, false, false, false,false, false, false},
																		{	false, false, false,false, false, false, false, false, false, false, false, false, false,false, false, false},
																		{	false, false, false,false, false, false, false, false, false, false, false, false, false,false, false, false},
																		{	false, false, false,false, false, false, false, true, false, false, false, false, false,false, false, false},
																		{	false, false, false,false, false, false, true, true, true, false, false, false, false,false, false, false},
																		{	false, false, false,false, false, false, true, false, true, false, false, false, false,false, false, false},
																		{	false, false, false,false, false, false, false, true, false, false, false, false, false,false, false, false},
																		{	false, false, false,false, false, false, false, false, false, false, false, false, false,false, false, false},
																		{	false, false, false,false, false, false, false, false, false, false, false, false, false,false, false, false}});
		GameController myGame = new GameController();

		for(int round = 1; round<nbRound+1;round++)
		{
			System.out.println("\n"+round + " Round");
			//display of the cells stats
			displayGame(cells);
			cells = myGame.playNextRound(cells);
		}
		//playing the next step
		
	}
	
	/**
	 * Method which dispay the state of the Dataset entered, a "X" means alive and " " a died cell.
	 * @param cells - Dataset of cells
	 */
	public static void displayGame(Dataset cells)
	{
		int[] shape = cells.getShape();
		for(int i = 0; i<shape[0];i++)
		{
			for(int j = 0; j<shape[1];j++)
			{
				if(cells.getBoolean(i, j))
					System.out.print("X");
				else
					System.out.print(" ");	
			}
			System.out.print("\n");
		}
	}

}
