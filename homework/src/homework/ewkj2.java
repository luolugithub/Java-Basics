package homework;


public class ewkj2
{
	public static char[] a={'X','G','Q','N','R','A','F','E','Z','T'};
	public static char[] aux=new char[a.length];
	public static char[] save=new char[a.length];
	public static int N=5;
	public static void merge(char[] save,int lo,int mid,int hi)//merge
	{
		int i=lo,j=mid+1;
		for(int k=lo;k<=hi;k++)
		{
			aux[k]=save[k];
		}
		for(int k=lo;k<=hi;k++)
		{
			if(i>mid)
				save[k]=aux[j++];
			else if(j>hi)
				save[k]=aux[i++];
			else if(less(aux[i],aux[j]))
				save[k]=aux[i++];
			else
				save[k]=aux[j++];
		}
	}
	private static boolean less(char a, char b) //less
	{
		int va=new Integer(a);
		int vb=new Integer(b);
		if(va-vb>=0) return false;
		else return true;
	}
	public static void slection(char[] a)//slection
	{
		char c;
		int NUM=a.length;
		for(int i=0;i<NUM;i++)
		{
			int min=i;
			for(int j=i+1;j<NUM;j++)
			{
				if(less(a[j],a[min]))
					min=j;
				c=a[i];
				a[i]=a[min];
				a[min]=c;
			}
		}
	}
	public static void main(String[] args)
	{	
		int m=0,length=0,hi=a.length;
		char[][] ay=new char[N][hi/N];
		save=new char[a.length];
		if(hi%N!=0);
		else
		{
			System.out.println(a);
			//分组
			for(int i=0;i<N;i++)  
			{
				for(int j=0;j<hi/N;j++)
				{
					ay[i][j]=a[m++];//sort
				}	
				slection(ay[i]);
			}
			for(int i=0;i<a.length/N;i++)//第一组
			{
				save[i]=ay[0][i];
			}
			//合并在一起
			for(int i=1;i<N;i++)
			{
				length=length+hi/N;
				for(int j=0;j<a.length/N;j++)
				{
					save[length+j]=ay[i][j];
				}
				merge(save,0,length-1,length+a.length/N-1);
			}
			System.out.println(save);
		}
	}
}
