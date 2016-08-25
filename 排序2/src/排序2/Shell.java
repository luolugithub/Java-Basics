package ÅÅÐò2;

import java.util.Scanner;

public class Shell {
	public static void sort(Comparable[] a){//ÉýÐò
		int N=a.length;
		int h=1;
		while(h<N/3)
			h=3*h+1;
		while(h>=1)
		{
			for(int i=h;i<N;i++)
			{
				for(int j=i;j>=h&&Selection.less(a[j],a[j-h]);j-=h)
					Selection.exch(a,i,j-h);
			}
			h=h/3;
		}
	}
		
	public static void main(String[] args){
			Scanner input=new Scanner(System.in);
			Comparable[] a=new Comparable[5];
			for(int i=0;i<5;i++)
				a[i]=input.nextLine();
			sort(a);
			assert Selection.isSorted(a);
			Selection.show(a);
		}
}
