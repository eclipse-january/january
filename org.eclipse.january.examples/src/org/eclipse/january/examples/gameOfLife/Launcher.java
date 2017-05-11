package org.eclipse.january.examples.gameOfLife;

import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;

public class Launcher {

	public static void main(String[] args) {
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
		int nbRound = 40;
		for(int round = 1; round<nbRound+1;round++)
		{
			int[] shape = cells.getShape();
			System.out.println("\n"+round + " Round");
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
			cells = myGame.playNextRound(cells);
		}
	}

}
