import java.io.*;
public class Sanjiaoxing_area {

	public static void main(String[] args)throws IOException {
		double a,b,c,s;
		double area;
		//input the bianchang
		InputStreamReader reader=new InputStreamReader(System.in);
		BufferedReader input=new BufferedReader(reader);
			System.out.println(/*"�����������εı߳�a:"*/);
				//readLine()������ȡ�û��Ӽ�����������ݲ������ַ�������temp
		String temp=input.readLine();
		a=Double.parseDouble(temp);//�ַ�������ת��Ϊ˫���ȸ�����
			System.out.println("�����������εı߳�b:");
		String temp1=input.readLine();
		b=Double.parseDouble(temp1);
			System.out.println("�����������εı߳�c:");
		String temp2=input.readLine();
		c=Double.parseDouble(temp2);
		
		s=(a+b+c)/2;
		area=Math.sqrt(s*(s-a)*(s-b)*(s-c));
		System.out.println("�߳�"+a +b +c+"�������ε����Ϊ��"+area);
		// TODO Auto-generated method stub
	}

}
