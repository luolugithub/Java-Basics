package ����;

//��̬������������������� ������Ľ���ȳ���
class staticInitDemo{
	static int i;
	static{
		i=5;
		System.out.println("static code:"+i++);
	}
}
public class ��̬����static {
	public static void main(String args[]){
		System.out.println("Main code:"+staticInitDemo.i);
	}

}
