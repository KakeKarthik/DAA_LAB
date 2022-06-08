
import java.util.*;
public class BinarySearch1 {
	

	public static void bstR(int a[],int lb,int ub,int key)
	{
		long start = System.nanoTime();
		int mid=(lb+ub)/2;
		if(lb>ub)
		{
			System.out.println("Key is not found");
			System.out.println("Time complexity : "+(System.nanoTime()-start)+" ns");
		return;
		}
		if(key==a[mid])
		{
			System.out.println("key found at index: "+mid);
			System.out.println("Time complexity : "+(System.nanoTime()-start)+" ns");
			return ;
		}
		else if(key<a[mid])
		{
			ub=mid-1;
			bstR(a,lb,ub,key);
		}
		else if(key>a[mid])
		{
			lb=mid+1;
			bstR(a,lb,ub,key);
		}
	}
	
	public static void bstI(int a[],int key)
	{
		long start = System.nanoTime();
		
		int i=0,j=a.length-1;
		int flag=0;
		while(i<=j)
		{
			int mid=(i+j)/2;
			if(key==a[mid])
			{
				System.out.println("Key is found at index: "+mid);
				System.out.println("Time complexity : "+(System.nanoTime()-start)+" ns");
				flag=1;
				break;
			}
			else if(key<a[mid])
				j=mid-1;
			else
				i=mid+1;
		}
		if(flag==0)
		{
			System.out.println("Key is not found");
			System.out.println("Time complexity : "+(System.nanoTime()-start)+" ns");
		}
	}
	
	public static void main(String ars[])
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the size of a array : ");
		int n=s.nextInt();
		int a[]=new int[n];
		System.out.println("Enter "+n+" elements : ");
		for(int i=0;i<n;i++)
			a[i]=s.nextInt();
		Arrays.sort(a);
		System.out.println("Elements in array after sorting : ");
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
		System.out.println();
		System.out.println("Enter element to be searched : ");
		int key=s.nextInt();
		int lb=0;
		int ub=a.length-1;
		System.out.println();
		System.out.println("Using recursive Binary Search");
		System.out.println("---------------------------------");
		long st = System.nanoTime();
		bstR(a,lb,ub,key);
		System.out.println();
		System.out.println("Using Iterative BinarySearch");
		System.out.println("--------------------------------");
		bstI(a,key);
	}

}
