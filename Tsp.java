import java.util.*;
public class Tsp 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int c[][] = new int[10][10];
	    int tour[] = new int[10];
		int i,j,cost;
		System.out.println("Enter no.of cities : ");
		int n = sc.nextInt();
		System.out.println("Enter the cost matrix : ");
		for(i=1;i<=n;i++)
			for(j=1;j<=n;j++)
				c[i][j] = sc.nextInt();
		for(i=1;i<=n;i++)
			tour[i] = i;
		cost = tspdp(c,tour,1,n);
		System.out.print("The Optimal tour is : ");
		for(i=1;i<=n;i++)
			System.out.print(tour[i]+"-->");
		System.out.println("1");
		System.out.println("Minimum cost : "+cost);
	}
	static int tspdp(int c[][],int tour[],int start,int n)
	{
		int mintour[] = new int[10],temp[] = new int[10];
		int mincost  = 999,ccost,i,j,k;
		if(start == n-1)
			return(c[tour[n-1]][tour[n]]+c[tour[n]][1]);
		for(i=start+1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
				temp[j] = tour[j];
			temp[start+1] = tour[i];
			temp[i] = tour[start+1];
			ccost = tspdp(c,temp,start+1,n);
			if((c[tour[start]][tour[i]]+ccost)<mincost)
			{
				mincost = c[tour[start]][tour[i]]+ccost;
				for(k=1;k<=n;k++)
					mintour[k] = temp[k];
			}
		}
		for(i=1;i<=n;i++)
			tour[i] = mintour[i];
		return mincost;
	}

}
