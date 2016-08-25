
public class Input 
{
	int V=6;
	int E=9;
	int[][] vertex={{1000,2400},{2800,3000},{2400,2500},{4000,0},{4500,3800},{6000,1500}};
	int[][] edge={{0,1},{0,3},{1,2},{1,4},{2,4},{2,3},{2,5},{3,5},{4,5}};
	int v1=1;  //源节点
	int v2=4;  //目的节点
	public int[][] V()
	{
		return vertex;
	}
	public int[][] E()
	{
		return edge;
	}	
}
