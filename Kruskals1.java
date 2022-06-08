import java.util.Scanner;
public class Kruskals1 {
	static int parent[] = new int[10];
	static int find(int m) 
	{
		int p = m;
		while(parent[p]!=0)
			p = parent[p];
		return p;
	}
	static void union(int i,int j)
	{
		if(i<j)
			parent[i] = j;
		else
			parent[j] = i;
	}
	static void Krsl(int a[][],int n)
	{
		int i,j,min,u=0,v=0,sum=0,k=0;
		while(k<n-1)
		{
			min = 99;
			for(i=1;i<=n;i++)
				for(j=1;j<=n;j++)
					if(a[i][j]<min && i!=j)
					{
						min = a[i][j];
						u = i;v=j;
					}
			i = find(u);
			j = find(v);
			if(i!=j) 
			{
				union(i,j);
				sum+=a[u][v];
				System.out.println(u+"-->"+v+" = "+a[u][v]);
				k++;
			}
			a[u][v] = a[v][u] = 99;
		}
		System.out.println("minimum cost : "+sum);
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of vertices : ");
		int n = sc.nextInt();
		int a[][] = new int[10][10];
		System.out.println("Enter cost adjacency matrix : ");
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
				a[i][j] = sc.nextInt();
		Krsl(a,n);
	}
}
