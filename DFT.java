import java.io.*;
import java.util.*;
public class DFT 
{
	private static LinkedList<Integer> adj[];
	static void Dfs(int v,boolean visited[])
	{
		visited[v] = true;
		System.out.print(v+" ");
		Iterator<Integer> i = adj[v].listIterator();
		while(i.hasNext())
		{
			int n = i.next();
			if(!visited[n])
				Dfs(n,visited);
		}
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no.of Edges : ");
		int n = sc.nextInt();
		adj = new LinkedList[n];
		boolean visited[] = new boolean[n];
		for(int i=0;i<n;i++)
			adj[i] = new LinkedList();
		System.out.println("Enter the Edges : ");
		for(int i=0;i<n;i++)
		{
			int x = sc.nextInt();
			int y = sc.nextInt();
			adj[x].add(y);
		}
		System.out.println("Enter source vertex : ");
		int z = sc.nextInt();
		System.out.println("Following is Depth First Traversal (Starting from vertex "+z+" ) : ");
		Dfs(z,visited);
	}
}
