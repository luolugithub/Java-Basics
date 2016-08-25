//import java.lang.*;
public class Graph
{
	public static double pointlength (int v1,int v2)//the length of two points
	{
		Input in=new Input();
		//In in=new In();
		int[][]v=new int[in.V][2];
		v=in.V();
		double l,w;
		l=v[v1][0]-v[v2][0]>0?v[v1][0]-v[v2][0]:v[v2][0]-v[v1][0];
		w=v[v1][1]-v[v2][1]>0?v[v1][1]-v[v2][1]:v[v2][1]-v[v1][1];
		double length=Math.sqrt(l*l+w*w);
		return length;
	}
	public static void graph()//find the shortest path
	{
		Input in=new Input();
		//In in=new In();
		int[][]edge=new int[in.E][2];
		edge=in.E();
		boolean[] marked=new boolean[in.V];//use to check the point is or not have been achieved
		
		marked[in.v1]=true;                //ve1 is start point
		
		double[] findlength=new double[in.V];//use to save the length to ve1 
		for(int i=0;i<findlength.length;i++)
		{
			findlength[i]=0;//there are no length at begining
		}
		for(int i=0;i<in.E;i++)
		{
			for(int j=0;j<in.E;j++)
			{
				if(marked[edge[j][0]]&&!marked[edge[j][1]])
				{
					marked[edge[j][1]]=true;
					findlength[edge[j][1]]=findlength[edge[j][0]]+pointlength(edge[j][0],edge[j][1]);
					
					System.out.println(edge[j][1]+"  "+findlength[edge[j][1]]);
				}
				else if(!marked[edge[j][0]]&&marked[edge[j][1]])
				{
					marked[edge[j][0]]=true;
					findlength[edge[j][0]]=findlength[edge[j][1]]+pointlength(edge[j][0],edge[j][1]);
					
					System.out.println(edge[j][0]+"  "+findlength[edge[j][0]]);
				}
				else if((marked[edge[j][0]]&&marked[edge[j][1]]))
				{
					if(findlength[edge[j][0]]>findlength[edge[j][1]]+pointlength(edge[j][0],edge[j][1]))
					{
						findlength[edge[j][0]]=findlength[edge[j][1]]+pointlength(edge[j][0],edge[j][1]);
						
						System.out.println(edge[j][0]+"  "+findlength[edge[j][0]]);
					}
					else if(findlength[edge[j][1]]>findlength[edge[j][0]]+pointlength(edge[j][0],edge[j][1]))
					{
						findlength[edge[j][1]]=findlength[edge[j][0]]+pointlength(edge[j][0],edge[j][1]);
						
						System.out.println(edge[j][1]+"  "+findlength[edge[j][1]]);
					}
				}
			}
		}
		System.out.println(in.v1+"-->"+in.v2+"  "+findlength[in.v2]);
	}
	public static void main(String[] args) throws Exception
	{
		graph();
	}
}
