package ≈≈–Ú2;
import java.util.*;
public class Insertion {
	public static void sort(Comparable[] a){
		int N=a.length;
		for(int i=1;i<N;i++)
			for(int j=i;j>0&&Selection.less(a[j],a[j-1]);j--)
				Selection.exch(a, j, j-1);
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
