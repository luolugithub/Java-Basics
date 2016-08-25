package 排序;

public class Quick {
	public static void sort(int[] a){
	//	StdRandom.shuffle(a);//消除对输入的依赖
		sort(a,3,a.length-1);
	}
	public static void sort(int[] a,int lo,int hi)
	{
		if(hi<lo) return;
		int j=partition(a,lo,hi);//切分
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
	private static int partition(int[] a,int lo,int hi){//切分
		int i=lo,j=hi+1;//左右扫描指针
		int v=a[lo];//切分元素
		while(true){
			while(less(a[++i],v))
				if(i==hi) break;
			while(less(v,a[--j]))
				if(j==lo) break;
		if(i>=j)
			break;
		exch(a,i,j);
		}
		exch(a,lo,j);//将v=a[j]放入正确的位置
		return j;
	}
	private static boolean less(int v,int w)
	{
		if(v<w)
			return true;
		else
			return false;
		//return v.compareTo(w)<0;
	}
	public static void exch(int[] a,int i,int j){
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
