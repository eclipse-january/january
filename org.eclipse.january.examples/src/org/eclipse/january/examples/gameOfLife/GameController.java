package org.eclipse.january.examples.gameOfLife;

import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.dataset.Slice;

/**
 * This class is the controller of the Game of Life, there is only a basic constructor, which just create an instance of it. This class
 * is used to play the next step of the game.
 * For the specifics cases (like one cell in a corner), the game calculate only 3 neighbors, the grid willn't loop on itself.
 * @author Pierre Sachot
 *
 */

public class GameController {
	
	
	/**
	 * Method to count the neighbors of one cell by giving the X and Y index
	 * @param toUse Dataset use in the game
	 * @param coordX X index of the cell
	 * @param coordY Y index of the cell
	 * @return
	 */
	private int neighborsCpt(Dataset toUse, int coordX, int coordY)
	{
		//this variable is the number of neighbors returns
		int retour = 0;
		Dataset possiblesNeighbors;
		int [] shape = toUse.getShape();
		int [] currentPos = new int[2];
		//here we determine the situation that the cell is in
		//currentPos is the save of the cell position to avoid counting himself as neighbor
		if(coordX == 0)
		{
			//row0 collumn0
			if(coordY == 0)
			{
				possiblesNeighbors = DatasetFactory.createFromObject(new int[][]{{coordX, coordX+1}, {coordY, coordY+2}});
				currentPos[0] = 0;
				currentPos[1] = 0;
			}
			//row0 columnMax
			else if(coordY == shape[1]-1)
			{
				possiblesNeighbors = DatasetFactory.createFromObject(new int[][]{{coordX, coordX+1}, {coordY-1, coordY}});
				currentPos[0] = 0;
				currentPos[1] = 1;
			}
			//row0 column?
			else
			{
				possiblesNeighbors = DatasetFactory.createFromObject(new int[][]{{coordX, coordX, coordX+1}, {coordY-1, coordY, coordY+1}});
				currentPos[0] = 0;
				currentPos[1] = 1;
			}
		}
		else if(coordX == shape[0])
		{
			//rowMax column0
			if(coordY == 0)
			{
				possiblesNeighbors = DatasetFactory.createFromObject(new int[][]{ {coordX-1, coordX}, {coordY, coordY+1}});
				currentPos[0] = 1;
				currentPos[1] = 0;
			}
			//rowMax columnMax
			else if(coordY == shape[1]-1)
			{
				possiblesNeighbors = DatasetFactory.createFromObject(new int[][]{{coordX-1, coordX}, {coordY-1, coordY}});
				currentPos[0] = 1;
				currentPos[1] = 1;
			}
			//rowMax column?
			else
			{
				possiblesNeighbors = DatasetFactory.createFromObject(new int[][]{{coordX-1, coordX}, {coordY-1, coordY, coordY+1}});
				currentPos[0] = 1;
				currentPos[1] = 1;
			}
		}
		else
		{
			//row? column0
			if(coordY == 0)
			{
				possiblesNeighbors = DatasetFactory.createFromObject(new int[][]{{coordX-1, coordX, coordX+1}, {coordY, coordY, coordY+2}});
				currentPos[0] = 1;
				currentPos[1] = 0;
			}
			//row? columnMax
			else if(coordY == shape[1])
			{
				possiblesNeighbors = DatasetFactory.createFromObject(new int[][]{{coordX-1, coordX, coordX+1}, {coordY-1, coordY}});
				currentPos[0] = 1;
				currentPos[1] = 1;
			}
			//row? column?
			else
			{
				possiblesNeighbors = DatasetFactory.createFromObject(new int[][]{{coordX-1, coordX, coordX+1},{coordY-1, coordY, coordY+1}});
				currentPos[0] = 1;
				currentPos[1] = 1;
			}
		}
		//Slice use for slicing the rows
		Slice first = new Slice(possiblesNeighbors.getInt(0,0), possiblesNeighbors.getInt(0,-1)+1);
		//Slice use for slicing the collumns
		Slice second = new Slice(possiblesNeighbors.getInt(1,0), possiblesNeighbors.getInt(1,-1)+1);
			
		//the goal of using a Slice is to get only the cells which can be neighbors of the current cell inside of the Dataset, for example : (X are alive)
		// in this data set :												what we want :
		// [ X . X . X . . X ]	
		// [ . . X . X X X . ]												 [ X . X ]	
		// [ X . . C X . . X ]												 [ . C X ]
		// [ X X . . . . X . ]												 [ . . . ]
		// [ X . X . X . X . ]
		//with the C our cell
		Dataset slice = toUse.getSlice(first, second);
		
		//here we count the number of neighbors
		int[] shapeFromSlice = slice.getShape();
		for(int i = 0; i<shapeFromSlice[0];i++)
		{
			for(int j=0; j<shapeFromSlice[1];j++)
			{
				//we don't check it if it's the cell itself
				if(i != currentPos[0] || j != currentPos[1])
				{
					if(slice.getBoolean(i, j))
						retour +=1;
				}
			}
		}
		return retour;
	}
	
	/**
	 * Returns the new Dataset with the new position of cells
	 * @param toUse Dataset to evaluate
	 * @return
	 * 		Returns the new Dataset calculated.
	 */
	public Dataset playNextRound(Dataset toUse)
	{
		int[] shape = toUse.getShape();
		//we create a new Dataset to evaluate the cells neighbors rightly
		Dataset nextStep = DatasetFactory.createFromObject( new boolean[shape[0]][shape[1]]);
		for(int i=0;i<shape[0];i++)
		{
			for(int j=0; j<shape[1];j++)
			{
				int nbVoisins = neighborsCpt(toUse, i, j);
				//case where the cell is dead but it is with 3 neighbors
				if(!toUse.getBoolean(i, j) && nbVoisins == 3)
				{
					nextStep.set(true, i, j);
				}
				//case in which it is alive
				else if(toUse.getBoolean(i, j))
				{
					//case where it had 2 or 3 neighbors
					if(nbVoisins > 1 && nbVoisins < 4)
					{
						nextStep.set(true, i, j);
					}
					//case where it had an other number of neighbors
					else
					{
						nextStep.set(false, i, j);
					}
				}
			}
		}
		return nextStep;
	}
}
