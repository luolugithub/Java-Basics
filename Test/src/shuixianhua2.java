import java.io.*;
public class shuixianhua2 {
	public static int fenjie(int n)
	{
		int a,b,c,s;
		a=n%10;
		b=n/10%10;
		c=n/100;
		s=a*a*a+b*b*b+c*c*c;
		return s;
	}

	public static void main(String[] args)throws IOException {
		int num;
		InputStreamReader reader=new InputStreamReader(System.in);
		BufferedReader input=new BufferedReader(reader);
		//num=(int)(System.in.read())-'0';
		String temp=input.readLine();
		num=Integer.parseInt(temp);
		if(fenjie(num)==num)
			System.out.println(num+"是水仙花数");
		else
			System.out.println(num+"不是水仙花数");
		// TODO Auto-generated method stub

	}

}
