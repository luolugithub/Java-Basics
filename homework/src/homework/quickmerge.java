package homework;


public class quickmerge
{
	public static char[] a={'A','B','C','D','E','E','D','C','B','A'};
	public static char[] aux;
	public static void merge(char[] a,int lo,int mid,int hi)//merge归并
	{
		int i=lo,j=hi-1;
		for(int k=lo;k<hi;k++)
		{
			aux[k]=a[k];
		}
		for(int k=lo;k<hi;k++)
		{
			if(less(aux[i],aux[j]))
				a[k]=aux[i++];
			else
				a[k]=aux[j--];
		}
	}
	private static boolean less(char a, char b) //less
	{
		int va=new Integer(a);
		int vb=new Integer(b);
		if(va-vb>=0) return false;
		else return true;
	}
	public static void main(String[] args)
	{	
		int lo=0,mid,hi;
		hi=a.length;
		mid=(lo+hi-1)/2;//中位数
		aux=new char[a.length];
		System.out.println(a);
		merge(a,lo,mid,hi);
		System.out.println(a);
	}
}
