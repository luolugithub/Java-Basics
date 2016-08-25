package 排序2;
import java.util.Comparator;
import java.util.Random;
public class SortCompare {
	public static double time(String alg,Double[] a)
	{
		Stopwatch timer=new Stopwatch();
		if(alg.equals("Insertion")) Insertion.sort(a);
		if(alg.equals("Selection")) Selection.sort(a);
		if(alg.equals("Shell")) Shell.sort(a);
		if(alg.equals("Merge")) Merge.sort(a);
		if(alg.equals("Quick")) Quick.sort(a);
		if(alg.equals("Heap")) Heap.sort(a);
		return timer.elapsedTime();
	}
	public static double timeRandomInput(String alg,int N,int T)
	{//用 alg 算法将T个长度为N的数组排序
		double total=0.0;
		Double[] a=new Double[N];
		for(int t=0;t<T;t++)
		{//进行一次测试，（生成一个数组并排序）
			for(int i=0;i<N;i++)
				a[i]=StdRandom.uniform();
			total+=time(alg,a);
		}
		return total;
	}
	public static void main(String[] args)
	{
		
	}

}
