package homework;


public class qiefen 
{
	public static char[] a={'D','C','B','A'};
	public static char[] aux=new char[a.length];
	public static char[] save=new char[a.length];
	public static void sort(char[] a1)
	{
		sort(a1,0,a1.length-1);
	}
	public static void sort(char[] a2, int lo, int hi)  //sort
	{
		if(hi<=lo) return;
		int j=partition(a2,lo,hi);
		sort(a2,lo,j-1);
		sort(a2,j+1,hi);
	}
	private static boolean less(char a, char b) //less a b =a<b
	{
		int va=new Integer(a);
		int vb=new Integer(b);
		if(va-vb<0) return true;
		else return false;
	}
	public static int partition(char[] a3, int lo, int hi) //ÇÐ·ÖÎ»ÖÃ
	{
		int j=0,k=0,m=0,ra=(int)(Math.random()*(hi+1-lo))%(hi+1-lo);
		char c=a3[ra+lo];
		for(int i=lo;i<=hi;i++)
		{
			aux[i]=a3[i];
			if(less(c,aux[i]))
				j++;
		}
		m=lo+j+1;
		for(int i=lo;i<=hi;i++)
		{
			if(i==lo+j) save[i]=c;
			else if(less(c,aux[i]))
				save[m++]=aux[i];
			else
				save[lo+k++]=aux[i];
		}
		System.out.println(c);
		System.out.println(save);
		return j+lo;
	}
	public static void main(String[] args)throws Exception
	{
		sort(a);
		//merge.show(a);
	}
}
