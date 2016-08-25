package ≈≈–Ú;
import java.util.*;
public class —°‘Ò2 {
	public static void sort(Comparable[] a){
		for(int i=0;i<a.length;i++)
		{
			int min=i;
			for(int j=i+1;j<a.length;j++)
				if(less(a[j],a[min]))
					exch(a,i,min);
		}
	}
	public static boolean less(Comparable v,Comparable w){
		return v.compareTo(w)<0;
	}
	public static void exch(Comparable[] a,int i,int j)
	{
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	public static void show(Comparable[] a){
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);
	}
	public static boolean isSorted(Comparable[] a){
		for(int i=0;i<a.length;i++)
			if(less(a[i],a[i-1]))
				return false;
		return true;
	}
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		String[] a=new String[6];
		for(int i=0;i<6;i++)
			a[i]=input.nextLine();
		sort(a);
		assert isSorted(a);
		show(a);
	}

}
