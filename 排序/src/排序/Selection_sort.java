package 排序;
import java.io.*;
import java.util.*;
//选择排序
public class Selection_sort implements Comparable<Selection_sort> {
	//选择排序
	public static void sort(Comparable[] a)
	{
		int N=a.length;
		for(int i=0;i<N;i++)
		{
			int min=i;
			for(int j=i+1;j<N;j++)
			{
				if(less(a[j],a[min]))
					min=j;
			}
			exch(a,i,min);
		}
	}
	//比较
	private static boolean less(Comparable v,Comparable w)
	{
		return v.compareTo(w)<0;
	}
	//exchange
	private static void exch(Comparable[] a,int i,int j)
	{
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	private static void show(Comparable[] a)
	{//在单行中打印数组
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	public static boolean isSorted(Comparable[] a)
	{//测试数组元素是否有序
		for(int i=1;i<a.length;i++)
		{
			if(less(a[i],a[i-1]))
				return false;
		}
		return true;
	}
	public static void main(String[] args)
	{//从标准输入读取字符串，将他们排序并输出
		String[] a={"a","s","f","e","w","q"};
		sort(a);
		assert isSorted(a);
		show (a);
	}
	@Override
	public int compareTo(Selection_sort arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
