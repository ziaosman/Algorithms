//Zia
//Defines percolation class 
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class Percolation
{
	private boolean[] gridStatus;
	private WeightedQuickUnionUF grid; 
	private int size, topRow, bottomRow, n;

   //create n-by-n grid, with all sites blocked
   public Percolation(int n)
   {
   		size = n*n;
   		grid = new WeightedQuickUnionUF(size+2);
   		gridStatus= new boolean[size];
   		this.n = n;

   		//indexes of top and bottom row in array
   		topRow = n*n;
   		bottomRow = n*n+1;
   }

   //Opens a site on the grid
   //Param: site on the grid
   //Throw: IllegalArgumentException if site is not on the grid
   public void open(int row, int col)
   {
   		if (isLegal(row, col))
   		{
   			gridStatus[index(row,col)] = true;
   			connectTo(row, col);
   		}
   }

   //Returns True if the site is open
   //Throw: IllegalArgumentException if site is not on the grid
   public boolean isOpen(int row, int col) 
   {
   		isLegal(row, col);
   		return gridStatus[index(row, col)];
   
   }

   //Returns True a site is connected to the top row
   //Throw: IllegalArgumentException if site is not on the grid
   public boolean isFull(int row, int col) 
   {
   		isLegal(row, col);
   		return grid.connected(index(row,col),topRow);
   }

   //Returns the number of open sites in the grid
   public int numberOfOpenSites()
   {
   		int counter = 0;
		for (boolean site : gridStatus)
   		{
   			if (site == true)
   			counter++;
   		}
		return counter;
	}

   //Returns True if the grid percolates 
   public boolean percolates()
   {
   		return grid.connected(topRow,bottomRow);
   }

   //Calculates index of site in the WeightedQuickUnionUF array called grid
   private int index(int row, int col)
	{
		return (n*(row-1)+col)-1;
	}

	//Returns true if site is located on the grid
	private boolean isLegal(int row, int col)
	{
		if(row < 1 || row > n)
		{
			throw new IllegalArgumentException("Sorry, Those values are not valid");
		}
		else if (col < 1 || col > n)
		{
			throw new IllegalArgumentException("Sorry, Those values are not valid");
		}
		else
		{
			return true;
		}
	}

	//Connects newly open sites to neighboring open sites 
	private void connectTo(int row, int col)
	{
		int i = index(row, col);
		//Connects to open sites on the right 
		if (col!= n)
		{
			openUnion(row, col+1, i);
		}
		//Connects to open sites on the left
		if(col != 1)
		{
			openUnion(row, col-1, i);
		}
		//Connects to open sites below
		if(row != n)
		{
			openUnion(row+1, col, i);
		}
		//Connects to open sites above
		if(row != 1)
		{
			openUnion(row-1, col, i);
		}
		//Build a virtual top row of open sites
		if(row == 1)
		{
			grid.union(topRow, i);
		}
		//Build a virtual bottom row of open sites
		if(row == n)
		{
			grid.union(bottomRow, i);
		}
	}

	//Checks if neighboring site is open and performs WeightedQuickUnion union method
	private void openUnion(int row, int col, int i)
	{
		if (isOpen(row, col) == true)
		{
			grid.union(index(row, col), i);
		}
	}

	public static void main(String[] args) {
    	Percolation perc = new Percolation(4);
    	perc.open(1, 2);
    	perc.open(2, 2);
    	perc.open(2, 3);
    	perc.open(3, 3);
    	perc.open(4,3);
    	boolean a = perc.isFull(2, 2);
    	boolean b = perc.grid.connected(perc.index(1, 2), perc.index(2, 2));
    	boolean c = perc.percolates();
    	StdOut.println(a);
    	StdOut.println(b);
    	StdOut.println(c);
  }
}
