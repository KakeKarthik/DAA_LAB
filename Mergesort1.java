
import java.util.*;
public class Mergesort1
{
	public static void merge(int a[],int l,int mid,int h)
	{
		int p=mid-l+1;
		int q=h-mid;
		int b[]=new int[p];
		int c[]=new int[q];
		for (int i= 0; i< p; i++)    
		    b[i] = a[l+i];    
	    for (int j= 0;j<q;j++)    
		    c[j] = a[mid+1+j];
		int i=0,j=0,k=l;
		while(i<p&& j<q)
		{
			if(b[i]<=c[j])
				a[k++]=b[i++];
			else
				a[k++]=c[j++];
		}
		while(i<p)
			a[k++]=b[i++];
		while(j<q)
			a[k++]=c[j++];
		print(a);
	}
	
	public static void sort(int a[],int l,int h)
	{
		if(l<h)
		{
			int mid=(l+h)/2;
			sort(a,l,mid);
			sort(a,mid+1,h);
			merge(a,l,mid,h);
		}
	}
	public static void print(int a[])
	{
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array : ");
		int n=sc.nextInt();
		int a[]=new int[n];
		System.out.println("Enter array elements :");
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		System.out.print("Before sorting : ");
		print(a);
		System.out.println();
        System.out.println("Passes : ");
        System.out.println("----------------");
		int s_time=(int)System.nanoTime();
		sort(a,0,a.length-1);
		int e_time=(int)System.nanoTime();
		System.out.println();
		System.out.print("After sorting : ");
		print(a);
		System.out.println("Time complexity : "+(e_time-s_time)+" ns");
	}
}
