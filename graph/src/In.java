import java.io.*;

public class In 
{	
	int i=0;
	public static int[] a=new int[1000];

	int N=1000;
	int V=a[i++];//=6;
	int E=a[i++];//=9;
	int[][] vertex=new int[V][2];//={{1000,2400},{2800,3000},{2400,2500},{4000,0},{4500,3800},{6000,1500}};
	int[][] edge=new int[E][2];//={{0,1},{0,3},{1,2},{1,4},{2,4},{2,3},{2,5},{3,5},{4,5}};
	int v1=0;
	int v2=5;
	
	public int[][] V()
	{
		for(int j=0;j<V;j++)
		{
		int t=a[i++];
		vertex[t][0]=a[i++];
		vertex[t][1]=a[i++];
		}
		return vertex;
	}
	public int[][] E()
	{
		for(int j=0;j<E;j++)
		{
			edge[j][0]=a[i++];
			edge[j][1]=a[i++];
		}
		return edge;
	}
	public static void ChangeStringToInt(String s)
	{
		int row=0;
		int count=0;
		char c=s.charAt(count);
		if((s.charAt(count)==' ')&&(s.charAt(count+1)==' '))
			return;
		while(count<s.length())
		{
			if(c!=' ') //deleat ' ' get int and store in array a
			{
				int num=0;
				while(c!=' ')//get int
			    {
					int save=c-'0';
					num=num*10+save;
					c=s.charAt(++count);
			    }	
				a[row++]=num;
				System.out.println(a[row-1]);
			}
			c=s.charAt(++count);
		}	
	}
	public static void main(String[] args) throws IOException
	{
		String store = null;
		FileInputStream fis=new FileInputStream("usa.txt"); //读取 usa.txt 文件内容
		InputStreamReader isr=new InputStreamReader(fis);
		BufferedReader br=new BufferedReader(isr);
		String strLine;
		while((strLine=br.readLine())!=null)
		{
			store=strLine;
		}
		br.close();
		System.out.println(store);
		ChangeStringToInt(store);
	}
}
