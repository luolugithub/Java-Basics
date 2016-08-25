package homework;


public class Daozhi3 
{
	public static char[] a={'K','G','Q','N','R','A','F','E','Z','T'};

	static int num=0;
	public static void tongji(char[] a)
	{
		int length=a.length;
		for(int i=0;i<length;i++)
		{
			for(int j=i;j<length;j++)
			{
				if(check(a[i],a[j]))
					num++;
			}
		}
	}
	private static boolean check(char a, char b)
	{
		int va=new Integer(a);
		int vb=new Integer(b);
		if(va-vb>0) return true;
		else return false;
	}
	public static void main(String[] args)
	{
		tongji(a);
		System.out.println(a);
		System.out.println("µ¹ÖÃÊı£º"+num);
	}
}

