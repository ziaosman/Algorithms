//Zia
//Defines percolation class 

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation
{
	private boolean[] gridStatus;
	private WeightedQuickUnionUF grid; 
	private int gridSize, topRow, bottomRow;

   //create n-by-n grid, with all sites blocked
   public Percolation(int n)
   {
   		gridSize = n*n;
   		grid = new WeightedQuickUnionUF(gridSize+2);
   		gridStatus= new Boolean(gridSize);

   		//indexes of top and bottom row in array
   		topRow = n*n+1;
   		bottomRow = n*n+2;
   }

   //Opens a site on the grid
   //Param: site on the grid
   //Throw: IllegalArgumentException if site is not on the grid
   public void open(int row, int col)
   {
   		if (!isLegal(row,col))
   		{
   			throw new IllegalArgumentException("Sorry, Those values are not valid");
   		}
   		gradStatus[index(row, col)] = true;
   }

   //Returns True if the site is open
   //Throw: IllegalArgumentException if site is not on the grid
   public boolean isOpen(int row, int col) 
   {
   		if (!isLegal(row,col))
   		{
   			throw new IllegalArgumentException("Sorry, Those values are not valid");
   		}
   		return gradStatus[index(row, col)];
   }

   //Returns True a site is connected to the top row
   //Throw: IllegalArgumentException if site is not on the grid
   public boolean isFull(int row, int col) 
   {
   		if (!isLegal(row,col))
   		{
   			throw new IllegalArgumentException("Sorry, Those values are not valid");
   		}
   		return gridSize.connected[index(row,col),topRow];
   }

   //Returns the number of open sites in the grid
   public int numberOfOpenSites()
   {
   		counter = 0;
		for (int i : gridStatus)
   		{
   			if (gridStatus[i] == true)
   			counter++
   		}
		return counter;
	}

   //Returns True if the grid percolates 
   public boolean percolates()
   {
   		return gridSize.connected(topRow,bottomRow);
   }

   //Calculates index of site in the WeightedQuickUnionUF array called grid
   private int index(int row, int col)
	{
		return (n*(i-row)+col)-1;
	}

	//Returns true if site is located on the grid
	private boolean isLegal(int row, int col)
	{
		if((row < 1 || row > n) || (col < 1 || col > n))
		{
			return false;
		}
		return true;
	}
}
   public static void main(String[] args)
	{
		//Test client
	}
