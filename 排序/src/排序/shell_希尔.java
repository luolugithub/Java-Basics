package ����;
import java.util.*;
public class shell_ϣ�� {
	public static void sort(Comparable[] a){//����
		int N=a.length;
		int h=1;
		while(h<N/3)
			h=3*h+1;
		while(h>=1)
		{
			for(int i=h;i<N;i++)
			{
				for(int j=i;j>=h&&less(a[j],a[j-h]);j-=h)
					exch(a,i,j-h);
			}
			h=h/3;
		}
	}
	public static boolean less(Comparable v,Comparable w)
	{
		return v.compareTo(w)<0;
	}
	public static void exch(Comparable[] a,int i,int j){
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	public static void show(Comparable[] a){
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);
	}
	public static boolean isSorted(Comparable[] a)
	{
		for(int i=0;i<a.length;i++)
			if(less(a[i],a[i-1]))
				return false;
			return true;
	}
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		Comparable[] a=new Comparable[10];
		for(int i=0;i<10;i++)
			a[i]=input.nextLine();
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
