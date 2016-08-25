import java.io.*;
public class Hanoita_hannuota {
	static void move(int n,char x,char y,char z)
	{
		if(n==1)
			System.out.println(x+"-->"+z);
		else
		{
			move(n-1,x,y,z);
			System.out.println(x+"-->"+z);
			move(n-1,x,y,z);
		}
	}
	public static void main(String[] args)throws IOException {
		int n;
	InputStreamReader reader=new InputStreamReader(System.in);
	BufferedReader input=new BufferedReader(reader);
	System.out.println("请输入一个数：");
	String temp=input.readLine();
	n=Integer.parseInt(temp);
	System.out.println("移动到盘子的步数"+n);
	move(n,'a','b','c');		
		// TODO Auto-generated method stub
	}

}
