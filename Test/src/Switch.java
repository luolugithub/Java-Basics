import java.io.*;
public class Switch {
//Switch���Ӧ��
	public static void main(String[] args)throws IOException{
		int day;
		while(true){
		System.out.println("��������������");
		day=(int)((System.in.read())-'0');
		switch(day)
		{
			case 1:System.out.println("��һ");break;
			case 2:System.out.println("�ܶ�");break;
			case 3:System.out.println("����");break;
			case 4:System.out.println("����");break;
			case 5:System.out.println("����");break;
			case 6:System.out.println("����");break;
			case 7:System.out.println("����");break;
			default: System.out.println(day+"����Ч��!");
		}
		}// TODO Auto-generated method stub

	}

}
