package 排序;

public class Quick3way {
	public static void sort(int[] a){
		//	StdRandom.shuffle(a);//消除对输入的依赖
			sort(a,0,a.length-1);
		}
	private static void sort(int[] a,int lo,int hi){
		if(hi<=lo) return;
		int lt=lo,i=lo+1,gt=hi;
		int v=a[lo];
		while(i<=gt)
		{
			int cmp;
			if(a[i]<v)
				cmp=1;
			else if(a[i]>v) cmp=-1;
			else cmp=0;
			if(cmp<0) exch(a,lt++,i++);
			else if(cmp>0) exch(a,i,gt--);
			else		i++;
		}
		sort(a,lo,lt-1);
		sort(a,gt+1,hi);
	}
	private static void exch(int[] a,int i,int j)
	{
		int t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	private static void show(int[] a)
	{//在单行中打印数组
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	public static void main(String[] args){
		//String[] a={"x","f","n","z","g","b","d","c","a"};
		//sort(a);
		//show(a);
	}
}
