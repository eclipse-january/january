package org.eclipse.january.examples.gameOfLife;

import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.dataset.Slice;

public class GameController {
	
	private int neighborsCpt(Dataset toUse, int coordX, int coordY)
	{
		int retour = 0;
		Dataset possiblesNeighbors;
		int [] shape = toUse.getShape();
		int [] currentPos = new int[2];
		if(coordX == 0)
		{
			//r0 c0
			if(coordY == 0)
			{
				possiblesNeighbors = DatasetFactory.createFromObject(new int[][]{{coordX, coordX+1}, {coordY, coordY+2}});
				currentPos[0] = 0;
				currentPos[1] = 0;
			}
			//r0 cmax
			else if(coordY == shape[1])
			{
				possiblesNeighbors = DatasetFactory.createFromObject(new int[][]{{coordX, coordX+1}, {coordY-1, coordY}});
				currentPos[0] = 0;
				currentPos[1] = 1;
			}
			//r0 c?
			else
			{
				possiblesNeighbors = DatasetFactory.createFromObject(new int[][]{{coordX, coordX, coordX+1}, {coordY-1, coordY, coordY+1}});
				currentPos[0] = 0;
				currentPos[1] = 1;
			}
		}
		else if(coordX == shape[0])
		{
			//rmax c0
			if(coordY == 0)
			{
				possiblesNeighbors = DatasetFactory.createFromObject(new int[][]{ {coordX-1, coordX}, {coordY, coordY+1}});
				currentPos[0] = 1;
				currentPos[1] = 0;
			}
			//rmax cmax
			else if(coordY == shape[1])
			{
				possiblesNeighbors = DatasetFactory.createFromObject(new int[][]{{coordX-1, coordX}, {coordY-1, coordY}});
				currentPos[0] = 1;
				currentPos[1] = 1;
			}
			//rmax c?
			else
			{
				possiblesNeighbors = DatasetFactory.createFromObject(new int[][]{{coordX-1, coordX}, {coordY-1, coordY, coordY+1}});
				currentPos[0] = 1;
				currentPos[1] = 1;
			}
		}
		else
		{
			//r? c0
			if(coordY == 0)
			{
				possiblesNeighbors = DatasetFactory.createFromObject(new int[][]{{coordX-1, coordX, coordX+1}, {coordY, coordY, coordY+2}});
				currentPos[0] = 1;
				currentPos[1] = 0;
			}
			//r? cmax
			else if(coordY == shape[1])
			{
				possiblesNeighbors = DatasetFactory.createFromObject(new int[][]{{coordX-1, coordX, coordX+1}, {coordY-1, coordY}});
				currentPos[0] = 1;
				currentPos[1] = 1;
			}
			//r? c?
			else
			{
				possiblesNeighbors = DatasetFactory.createFromObject(new int[][]{{coordX-1, coordX, coordX+1},{coordY-1, coordY, coordY+1}});
				currentPos[0] = 1;
				currentPos[1] = 1;
			}
		}
		Slice first = new Slice(possiblesNeighbors.getInt(0,0), possiblesNeighbors.getInt(0,-1)+1);
		Slice second = new Slice(possiblesNeighbors.getInt(1,0), possiblesNeighbors.getInt(1,-1)+1);
			
		Dataset slice = toUse.getSlice(first, second);

		int[] shapeFromSlice = slice.getShape();
		for(int i = 0; i<shapeFromSlice[0];i++)
		{
			for(int j=0; j<shapeFromSlice[1];j++)
			{
				if(i != currentPos[0] || j != currentPos[1])
				{
					if(slice.getBoolean(i, j))
						retour +=1;
				}
			}
		}
		return retour;
	}
	
	public Dataset playNextRound(Dataset toUse)
	{
		int[] shape = toUse.getShape();
		Dataset nextStep = DatasetFactory.createFromObject( new boolean[shape[0]][shape[1]]);
		for(int i=0;i<shape[0];i++)
		{
			for(int j=0; j<shape[1];j++)
			{
				int nbVoisins = neighborsCpt(toUse, i, j);
				if(!toUse.getBoolean(i, j) && nbVoisins == 3)
				{
					nextStep.set(true, i, j);
				}
				else if(toUse.getBoolean(i, j))
				{
					if(nbVoisins > 1 && nbVoisins < 4)
					{
						nextStep.set(true, i, j);
					}
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
