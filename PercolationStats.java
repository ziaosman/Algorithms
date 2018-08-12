//zia
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats
{
   private double[] thresholds; 
   private int size, n, trials;
   //Trial 
   public PercolationStats(int n, int trials)
   {
      this.n = n;
      size = n*n;
      this.trials = trials;
      thresholds = new double[trials];

         if (n <= 0 || trials <= 0)
            {
               throw new java.lang.IllegalArgumentException("n value is not valid");
            }

      for (int i = 0; i < trials; i++)
         {
            thresholds[i] = trialPercolationThreshold();
         }
   }
   //sample Mean
   public double mean()
   {
         return StdStats.mean(thresholds);
   }
   //Sample Standard Deviation                       
   public double stddev()
   {
         return StdStats.stddev(thresholds);
   }
   //Low endpoint of a 95% confidence interval                     
   public double confidenceLo()
   {
      return mean() - 1.96*stddev()/Math.sqrt(trials);
   }
   //High Endpoint of a 95% confidence interval 
   public double confidenceHi()
   {
         return mean() + 1.96*stddev()/Math.sqrt(trials);
   }
   private double trialPercolationThreshold()
   {
         int row, col;
         int counter = 0;
         Percolation perc = new Percolation(n);

         while(!perc.percolates())
         {
            row = StdRandom.uniform(n)+1;
            col = StdRandom.uniform(n)+1;

            if(!perc.isOpen(row, col))
            {
               perc.open(row, col);
               counter++;
            }
    
         }
         return counter/(Math.pow(n,2));
   }        
   //test Client
   public static void main(String[] args)
   {
  
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);

    PercolationStats stats = new PercolationStats(a, b);
   StdOut.printf("mean = %f\n", stats.mean());
    StdOut.printf("stddev = %f\n", stats.stddev());
    StdOut.printf("95%% confidence interval = %f, %f\n", stats.confidenceLo(), stats.confidenceHi());
   }     
}