import java.io.*;
public class Sanjiaoxing_area {

	public static void main(String[] args)throws IOException {
		double a,b,c,s;
		double area;
		//input the bianchang
		InputStreamReader reader=new InputStreamReader(System.in);
		BufferedReader input=new BufferedReader(reader);
			System.out.println(/*"请输入三角形的边长a:"*/);
				//readLine()方法读取用户从键盘输入的数据并赋给字符串对象temp
		String temp=input.readLine();
		a=Double.parseDouble(temp);//字符串类型转换为双精度浮点型
			System.out.println("请输入三角形的边长b:");
		String temp1=input.readLine();
		b=Double.parseDouble(temp1);
			System.out.println("请输入三角形的边长c:");
		String temp2=input.readLine();
		c=Double.parseDouble(temp2);
		
		s=(a+b+c)/2;
		area=Math.sqrt(s*(s-a)*(s-b)*(s-c));
		System.out.println("边长"+a +b +c+"该三角形的面积为："+area);
		// TODO Auto-generated method stub
	}

}
