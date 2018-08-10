//Zia

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
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
   //open site (row, col) if it is not open already
   public void open(int row, int col)
   {
   	if (!isLegal(row,col))
   	{
   	throw new IllegalArgumentException("Sorry, Those values are not valid");
   	}
   	gradStatus[index(row, col)] = true;
   }
   //is site (row, col) open?
   public boolean isOpen(int row, int col) 
   {
   	if (!isLegal(row,col))
   		{
   			throw new IllegalArgumentException("Sorry, Those values are not valid");
   		}
   	return gradStatus[index(row, col)];
   }
    //is site (row, col) full?
   public boolean isFull(int row, int col) 
   {
   	if (!isLegal(row,col))
   	{
   		throw new IllegalArgumentException("Sorry, Those values are not valid");
   	}
   	return gridSize.connected[index(row,col),topRow];
   }
   // number of open sites
   public int numberOfOpenSites()
   {
   	counter = 0;
   	for (int i : gridStatus)
   	{
   		if (gridStatus[i] == true)
   		{
   			counter++
   		}
   	}
   	return counter;
   }
   // does the system percolate?
   public boolean percolates()
   {
   	return gridSize.connected(topRow,bottomRow);
   }
   //calculates index of grid on the weighted grid 
   private int index(int row, int col)
	{
		return (n*(i-row)+col)-1;
	}
	//calculates whether a grid coordinate is legal 
	private boolean isLegal(int row, int col)
	{
		if((row < 1 || row > n) || (col < 1 || col > n))
		{
			return false;
		}
		return true;
	}
   public static void main(String[] args)
	{
		//test client
	}
}