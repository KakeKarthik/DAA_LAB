import java.util.*;
public class AllPairsShortestPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no.of vertices : ");
		int n = sc.nextInt();
		int c[][] = new int[n][n];
		System.out.println("Enter cost adjacency matrix : ");
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				c[i][j] = sc.nextInt();
		int a[][] = new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				a[i][j] = c[i][j];
		for(int k=0;k<n;k++)
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					a[i][j] = Math.min(a[i][j],a[i][k]+a[k][j] );
		System.out.println("Shortest path matrix : ");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				System.out.print(a[i][j]+" ");
			System.out.println();
		}
	}

}
