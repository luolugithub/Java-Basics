package 排序;
import java.util.*;
public class Insertion_插入 {
	public static void sort(int[] a)
	{//升序排列 a[]
		int N=a.length;
		for(int i=1;i<N;i++)
		{
			for(int j=i;j>0&&less(a[j],a[j-1]);j--){
				exch(a,j,j-1);
			}
		}
		
	}
	public static boolean less(Comparable v,Comparable w){
		return v.compareTo(w)<0;
	}
	public static void exch(int[] a,int i,int j){
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=(int) t;
	}
	public static void show(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}
	public static boolean isSorted(int[] a){//测试数组是否有序
		for(int i=1;i<a.length;i++)
			if(less(a[i],a[i-1]))
				return false;
		return true;
	}
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int[] a=new int[6];
		for(int i=0;i<6;i++)
		{
			a[i]=input.nextInt();
		}
		//String[] a=System.in.read();
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
